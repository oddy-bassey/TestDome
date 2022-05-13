package com.revoltcode.cache_casting;

/*
 * A company is designing the class hierarchy for various cache implementations:
 * Select all the answers that will result in a runtime exception.
 */
public class Main {

    public static void main(String[] args){

        // these throw an error
//        MemoryCache memoryCache = new MemoryCache();
//        Cache cache = (Cache) memoryCache;
//
//        System.out.println(cache.getClass());
//        DiskCache diskCache = (DiskCache) cache;

//        DiskCache diskCache = new DiskCache();
//        OptimizedDiskCache optimizedDiskCache = (OptimizedDiskCache) diskCache;

//        Cache cache = new Cache();
//        MemoryCache memoryCache = (MemoryCache) cache;

        // #############################################################################################################
        // these are correct
//        OptimizedDiskCache optimizedDiskCache = new OptimizedDiskCache();
//        Cache cache = (Cache) optimizedDiskCache;

//        OptimizedDiskCache optimizedDiskCache = new OptimizedDiskCache();
//        DiskCache diskCache = (DiskCache) optimizedDiskCache;

//        OptimizedDiskCache optimizedDiskCache = new OptimizedDiskCache();
//        Cache cache = (Cache) optimizedDiskCache;
//        DiskCache diskCache = (DiskCache) cache;
    }
}
