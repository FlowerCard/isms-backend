package com.isms.ismsbackend.utils;

import java.util.ArrayList;
import java.util.List;

public class CidrUtils {
    private final String cidrAddress;

    public CidrUtils(String cidrAddress) {
        this.cidrAddress = cidrAddress;
    }

    public List<String> getIpAddresses() throws IllegalArgumentException {
        // Validate CIDR address
        if (!validateCidrBlock(cidrAddress)) {
            throw new IllegalArgumentException("Invalid CIDR address");
        }
        // Split CIDR address into IP address and net mask
        String[] addressParts = cidrAddress.split("/");
        String ipAddress = addressParts[0];
        int netMask = Integer.parseInt(addressParts[1]);
        // calculate the range of IP addresses in the block
        long numAddresses = (long)Math.pow(2, 32 - netMask);
        long startAddress = ipToLong(ipAddress);
        long endAddress = startAddress + numAddresses - 1;
        // build a list of IP addresses
        List<String> ipAddressList = new ArrayList<String>();
        for (long i = startAddress; i <= endAddress; i++) {
            ipAddressList.add(longToIp(i));
        }
        return ipAddressList;
    }

    /**
     * Validate a CIDR block format
     *
     * @param cidrString
     * @return
     */
    private boolean validateCidrBlock(String cidrString) {
        if (cidrString == null) {
            return false;
        }
        String[] parts = cidrString.split("/");
        if (parts.length != 2) {
            return false;
        }
        String ipAddress = parts[0];
        int subnetmask = Integer.parseInt(parts[1]);
        if (subnetmask < 0 || subnetmask > 32) {
            return false;
        }
        String[] octets = ipAddress.split("\\.");
        if (octets.length != 4) {
            return false;
        }
        for (String octet : octets) {
            int octetVal = Integer.parseInt(octet);
            if (octetVal < 0 || octetVal > 255) {
                return false;
            }
        }
        return true;
    }

    /**
     * Convert a IP address to Long
     *
     * @param ipAddress
     * @return
     */
    private long ipToLong(String ipAddress) {
        String[] octets = ipAddress.split("\\.");
        long result = 0;
        for (int i = 3; i >= 0; i--) {
            result |= (Long.parseLong(octets[3 - i]) << (i * 8));
        }
        return result & 0xFFFFFFFF;
    }

    /**
     * Convert a Long to IP address
     *
     * @param i
     * @return
     */
    private String longToIp(long i) {
        return ((i >> 24) & 0xFF) + "." + ((i >> 16) & 0xFF) + "." + ((i >> 8) & 0xFF) + "." + (i & 0xFF);
    }
}