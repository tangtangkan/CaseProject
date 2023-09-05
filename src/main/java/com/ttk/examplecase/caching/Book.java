package com.ttk.examplecase.caching;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

public class Book {

    @Cacheable(value = "cacheDemo", key = "#id")
    public String getCachedData(String id) {
        System.out.println("getCachedData...");
        // 在这里实现从数据源获取数据的逻辑
        if (id.equals("1")) {
            return "Book 1";
        } else {
            return "Book 2";
        }
    }

    @CachePut(value = "cacheDemo", key = "#id")
    public String updateCachedData(String id, String data) {
        System.out.println("updateCachedData...");
        // 在这里实现更新缓存中的数据的逻辑
        return data;
    }

    @CacheEvict(value = "cacheDemo", key = "#id")
    public void removeCachedData(String id) {
        System.out.println("removeCachedData...");
        // 在这里实现从缓存中删除数据的逻辑
    }

}