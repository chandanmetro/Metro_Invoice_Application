package com.metro.service;

import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class DeviceIPLogger {

    public void captureIPAddresses() throws SocketException {
        try (FileWriter writer = new FileWriter("logs/device_ips.log")) {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();
                Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress address = addresses.nextElement();
                    if (!address.isLoopbackAddress() && !address.isLinkLocalAddress() && address.isSiteLocalAddress()) {
                        String ipAddress = address.getHostAddress();
                        String deviceName = networkInterface.getDisplayName();
                        String logEntry = deviceName + ": " + ipAddress + "\n";
                        writer.write(logEntry);
                    }
                }
            }
            System.out.println("IP addresses captured successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SocketException {
        DeviceIPLogger logger = new DeviceIPLogger();
        logger.captureIPAddresses();
    }
}
