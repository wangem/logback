package com.answern.logback.base;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import java.io.File;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

/**
 * 需求名称:
 * 类描述:[一句话描述该类的功能]<br/>
 *
 * @author [wem] <br/>
 * 创建时间:[2018/10/10 12:16]  <br/>
 * 版本:[v1.0]   <br/>
 */
public class BaseUtil {


    /**
     * 获取当前系统时间
     * @return
     */
    public static String getFormatTime(){
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        return df.format(new Date());
    }

    /**
     * 获取当前系统ip
     * @return
     * @throws Exception
     */
    private static String SYSTEM_IP;
    public static final String getLocalIp() {

//        LocalCache inStance = LocalCache.getInStance();
         if(!StringUtils.isNotEmpty(SYSTEM_IP)){
            try {
                String ipString = "";
                Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
                InetAddress ip = null;
                while (allNetInterfaces.hasMoreElements()) {
                    NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
                    Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                    while (addresses.hasMoreElements()) {
                        ip = (InetAddress) addresses.nextElement();
                        if (ip != null && ip instanceof Inet4Address && !ip.getHostAddress().equals("127.0.0.1")) {
                            SYSTEM_IP = ip.getHostAddress();
//                            inStance.setLocalCache("logging_localIp",ipString);
                            return SYSTEM_IP;
                        }
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return SYSTEM_IP;
    }

    /**
     * 获取系统服务名称
     * @return
     */
    private static String SYSTEM_NAME;
    public static String getSystemName(){
        if(!StringUtils.isNotEmpty(SYSTEM_NAME)){
            SYSTEM_NAME =  SystemUtils.getUserDir().getName();
        }
        return SYSTEM_NAME;
    }

//    public static void main(String[] args) {
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");//设置日期格式
//        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
//        System.out.println(new Date());// new Date()为获取当前系统时间
//        System.out.println(System.currentTimeMillis());// new Date()为获取当前系统时间
//        File property = SystemUtils.getUserDir();
//        System.out.println(property.getName());
//        System.out.println(property.getParent());
//    }
}
