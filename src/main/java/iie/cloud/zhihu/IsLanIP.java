package iie.cloud.zhihu;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/9/1.
 * 判断一个IP地址时候属于局域网地址（
 *       A类  10.0.0.0    -10.255.255.255
 *       B类  172.16.0.0  -172.31.255.255
 *       C类  192.168.0.0 -192.168.255.255）
 */
public class IsLanIP {

    public static boolean isInnerIP(String ipAddress){/*判断是否是内网IP*/
        boolean isInnerIp = false;//默认给定IP不是内网IP
        long ipNum = getIpNum(ipAddress);
        /**
         * 私有IP：A类  10.0.0.0    -10.255.255.255
         *       B类  172.16.0.0  -172.31.255.255
         *       C类  192.168.0.0 -192.168.255.255
         *       D类   127.0.0.0   -127.255.255.255(环回地址)
         **/
        long aBegin = getIpNum("10.0.0.0");
        long aEnd = getIpNum("10.255.255.255");
        long bBegin = getIpNum("172.16.0.0");
        long bEnd = getIpNum("172.31.255.255");
        long cBegin = getIpNum("192.168.0.0");
        long cEnd = getIpNum("192.168.255.255");
        long dBegin = getIpNum("127.0.0.0");
        long dEnd = getIpNum("127.255.255.255");
        isInnerIp = isInner(ipNum,aBegin,aEnd) || isInner(ipNum,bBegin,bEnd) || isInner(ipNum,cBegin,cEnd) || isInner(ipNum,dBegin,dEnd);
        return isInnerIp;
    }

    private static long getIpNum(String ipAddress) {/*获取IP数*/
        String [] ip = ipAddress.split("\\.");
        long a = Integer.parseInt(ip[0]);
        long b = Integer.parseInt(ip[1]);
        long c = Integer.parseInt(ip[2]);
        long d = Integer.parseInt(ip[3]);
        long ipNum = a * 256 * 256 * 256 + b * 256 * 256 + c * 256 + d;
        return ipNum;
    }

    private static boolean isInner(long userIp,long begin,long end){
        return (userIp>=begin) && (userIp<=end);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ip = in.nextLine().trim();
//        System.out.println(ip);
        if(isInnerIP(ip)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
