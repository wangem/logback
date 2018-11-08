package com.answern.logback.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class LocalCache {

    //缓存Map
    private static Map<String,CacheContent> map = new HashMap<>();
    private static  LocalCache localCache = new LocalCache();

    private LocalCache(){
    }

    public  String getLocalCache(String key) {
        CacheContent cc = map.get(key);

        if(null == cc) {
            return null;
        }

        long currentTime = System.currentTimeMillis();

        if(cc.getCacheMillis() > 0 && currentTime - cc.getCreateTime() > cc.getCacheMillis()) {
            //超过缓存过期时间,返回null
            map.remove(key);
            return null;
        } else {
            return cc.getElement();
        }
    }

    public void setLocalCache(String key,int cacheMillis,String value) {
        long currentTime = System.currentTimeMillis();
        CacheContent cc = new CacheContent(cacheMillis,value,currentTime);
        map.put(key,cc);
    }
    public void setLocalCache(String key,String value) {
        long currentTime = System.currentTimeMillis();
        CacheContent cc = new CacheContent(0,value,currentTime);
        map.put(key,cc);
    }

    public static LocalCache getInStance(){
        return localCache;
    }

}
@Getter
@Setter
@AllArgsConstructor
class CacheContent{
    // 缓存生效时间
    private  int cacheMillis;
    // 缓存对象
    private String element;
    // 缓存创建时间
    private long createTime ;

}