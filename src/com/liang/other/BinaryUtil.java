package com.liang.other;

/**
 * 二进制处理技巧
 *
 * @author LiaNg
 * @date 2020/6/22 16:30
 */
public class BinaryUtil {

    public static void main(String[] args) {
        String IP = "254.255.255.0";
        long ipNum = ip2Int(IP);
        System.out.println("ipNum = " + ipNum);
        String realIp = int2Ip(ipNum);
        System.out.println("realIp = " + realIp);

        System.out.println("ipTransferToLong(IP) = " + ipTransferToLong(IP));
    }

    public static long ip2Int(String ip) {

        String[] ips = ip.split("\\.");

        long res = 0;

        res |= Integer.valueOf(ips[0]);
        res <<= 8;
        res |= Integer.valueOf(ips[1]);
        res <<= 8;
        res |= Integer.valueOf(ips[2]);
        res <<= 8;
        res |= Integer.valueOf(ips[3]);

        return res;
    }

    public static String int2Ip(long ipNum) {

        long a = ipNum & 255;
        ipNum >>= 8;
        long b = ipNum & 255;
        ipNum >>= 8;
        long c = ipNum & 255;
        ipNum >>= 8;
        long d = ipNum & 255;

        return d + "." + c + "." + b + "." + a;
    }

    public static Long ipTransferToLong(String ip) {
        String[] split = ip.split("\\.");
        return ((Long.parseLong(split[0])<<24)+(Long.parseLong(split[1])<<16)+(Long.parseLong(split[2])<<8)+(Long.parseLong(split[3])));
    }

    public static String ipTransfer(Long ip) {
        return ((ip >> 24) & 0xff)+"."+((ip >> 16) & 0xff)+"."+((ip >> 8) & 0xff)+"."+(ip & 0xff);
    }

}
