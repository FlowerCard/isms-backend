package com.isms.ismsbackend.utils;

/**
 * @Author huangzihao
 * @Email huangzihao@xinyunlian.com
 * @Date 2023/2/24 23:10
 */
public class IpUtils {

    /**
     * 判断地址是否在当前网段
     *
     * @param ip 地址
     * @param cidr 网段
     * @return 是否存在
     */
    public static boolean isInRange(String ip, String cidr) {
        String[] ips = ip.split("\\.");
        int ipAddr = (Integer.parseInt(ips[0]) << 24) | (Integer.parseInt(ips[1]) << 16)
            | (Integer.parseInt(ips[2]) << 8) | (Integer.parseInt(ips[3]));
        int type = Integer.parseInt(cidr.replaceAll(".*/", ""));
        int mask = 0xFFFFFFFF << (32 - type);
        String cidrIp = cidr.replaceAll("/.*", "");
        String[] cidrIps = cidrIp.split("\\.");
        int cidrIpAddr = (Integer.parseInt(cidrIps[0]) << 24) | (Integer.parseInt(cidrIps[1]) << 16)
            | (Integer.parseInt(cidrIps[2]) << 8) | (Integer.parseInt(cidrIps[3]));
        return (ipAddr & mask) == (cidrIpAddr & mask);
    }

}
