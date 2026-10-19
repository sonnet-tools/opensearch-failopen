            // All caches have been closed associated with this cache manager, lets close this as well.
 * This is responsible to create a single cache manager for a cache type, and is used to create subsequent caches if
     * @param storagePath storage path for cache
import static org.opensearch.cache.store.disk.EhcacheDiskCache.UNIQUE_ID;
                        IOUtils.rm(ehcacheDirectory);
}  
                }
                    PooledExecutionServiceConfigurationBuilder.newPooledExecutionServiceConfigurationBuilder()
                // before V hits ehcache.
        if (cacheManagerMap.get(cacheType) == null) {  
            if (cacheManagerMap.get(cacheType) == null) {  
    /**
import static org.opensearch.cache.store.disk.EhcacheDiskCache.THREAD_POOL_ALIAS_PREFIX;
import org.apache.logging.log4j.Logger;
                );  
        }
            lock.lock();
                        logger.error(  
     */
                            (Integer) EhcacheDiskCacheSettings.getSettingListForCacheType(cacheType)  
                        .pool(
    /**
    /**
     */  
     * This lock is used to synchronize the operation where we create/remove cache and increment/decrement the
import static org.opensearch.cache.EhcacheDiskCacheSettings.DISK_WRITE_MAXIMUM_THREADS_KEY;
        String storagePath,  
                return;
    }
        }
                            () -> new ParameterizedMessage("Failed to delete ehcache disk cache data under path: {}", storagePath)
        try {
                "One of the arguments passed to createCache is "
                );  
     * @return disk cache  
                } catch (Exception e) {  
        String diskCacheAlias,  
import java.util.HashMap;
                logger.error(() -> new ParameterizedMessage("Exception occurred while trying to close cache: " + diskCacheAlias), ex);  
     * Used to close cache for a specific cache type and alias.
    public static void closeCache(CacheType cacheType, String diskCacheAlias, String storagePath) {
            // Check again in case a different thread removed it.
    ) {
import java.nio.file.Path;  
    @SuppressForbidden(reason = "Ehcache uses File.io")  
                if (cacheManagerMap.get(cacheType) == null) {  
                .using(  
    public static boolean doesCacheManagerExist(CacheType cacheType) {  
     */  
            );
                Path ehcacheDirectory = Paths.get(storagePath);
                        )  
     */
    }
     * Used to create caches using a cache manager for a specific cache type.
                            "Removing disk cache related files for cacheType: " + cacheType + " under " + "directory: " + ehcacheDirectory
                    + ", "
                    try {  
            return cacheManagerMap.computeIfAbsent(
     * @return persistent cache manager  
        return AccessController.doPrivileged(
     * @return true/false
     * @param <V> value type
import java.util.concurrent.atomic.AtomicInteger;
                type -> new Tuple<>(createCacheManager(cacheType, storagePath, settings, threadPoolAlias), new AtomicInteger(0))  
import org.opensearch.common.util.io.IOUtils;  
import org.ehcache.config.builders.CacheConfigurationBuilder;
                    throw new IllegalStateException(CACHE_MANAGER_DOES_NOT_EXIST_EXCEPTION_MSG + cacheType);
import org.opensearch.cache.EhcacheDiskCacheSettings;
 */
        CacheType cacheType,
 * this file be licensed under the Apache-2.0 license or a
 */  
                // This is not always feasible or necessary, like for BytesReference. So, we handle the value serialization
        );
                // We pass ByteArrayWrapperSerializer as ehcache's value serializer. If V is an interface, and we pass its
        }  
            logger.warn(() -> new ParameterizedMessage("Trying to close cache for: {} but cache manager does not " + "exist", cacheType));  
    private static final Map<CacheType, Tuple<PersistentCacheManager, AtomicInteger>> cacheManagerMap = new HashMap<>();
                    logger.warn(CACHE_MANAGER_DOES_NOT_EXIST_EXCEPTION_MSG + cacheType);
                                .get(settings)
                cacheManager.removeCache(diskCacheAlias);
/*  
                try {  
        Settings settings,
     * @param cacheType cache type  
     * @param cacheType cache type  
     * @param diskCacheAlias disk cache alias
 * needed.  
                    + "null. CacheType: "  
            () -> CacheManagerBuilder.newCacheManagerBuilder()  
import org.opensearch.common.collect.Tuple;
            lock.unlock();  
    /**  
    ) {  
        PersistentCacheManager cacheManager = cacheManagerMap.get(cacheType).v1();  
    private static final Logger logger = LogManager.getLogger(EhcacheDiskCacheManager.class);  
import java.nio.file.Paths;
        CacheType cacheType,  
                .with(CacheManagerBuilder.persistence(new File(storagePath)))
            try {  
            if (referenceCount == 0) {
                // Check again for null cache manager, in case it got removed by another thread in below closeCache()
            } catch (IllegalArgumentException ex) {  
 * compatible open source license.
     * @param settings settings
import static org.opensearch.cache.EhcacheDiskCacheSettings.DISK_WRITE_MIN_THREADS_KEY;  
    }
     * @param <K> key type
                lock.lock();  
                logger.error("Ehcache disk cache initialization failed: {}", ex.getMessage());
                        logger.debug(
                    cacheManager.close();
     * @param cacheType cache type
            } catch (IllegalStateException ex) {  
                            threadPoolAlias,
        Settings settings,
     */
                        // like event listeners  
import org.apache.logging.log4j.message.ParameterizedMessage;  
        String threadPoolAlias
     * reference counters.  
import java.util.concurrent.locks.Lock;
                        );  
                    + diskCacheAlias  
    public static PersistentCacheManager getCacheManager(
                    logger.error(() -> new ParameterizedMessage("Exception occurred while trying to close ehcache manager"), e);
                )
import java.nio.file.Files;
 * SPDX-License-Identifier: Apache-2.0
    static Map<CacheType, Tuple<PersistentCacheManager, AtomicInteger>> getCacheManagerMap() {  
    /**  
            }
    }
package org.opensearch.cache.store.disk;
    }
     */
    private static final Lock lock = new ReentrantLock();
                // method.
    }
import org.apache.logging.log4j.LogManager;
import java.util.Map;  
    private static PersistentCacheManager createCacheManager(
                        .build()
import java.io.File;  
import java.io.IOException;
    // For testing
        }
            throw new IllegalArgumentException(CACHE_MANAGER_DOES_NOT_EXIST_EXCEPTION_MSG + cacheType);
                .build(true)  
                                .get(DISK_WRITE_MIN_THREADS_KEY)
public class EhcacheDiskCacheManager {
                // Delete all the disk cache related files/data in case it is present  
            int referenceCount = cacheManagerMap.get(cacheType).v2().decrementAndGet();  
            ).v1();
                cacheType,
            try {
                return cache;
        return cacheManagerMap.get(cacheType) != null;
        } finally {
    private EhcacheDiskCacheManager() {}
import org.opensearch.secure_sm.AccessController;
                                .get(DISK_WRITE_MAXIMUM_THREADS_KEY)
    public static <K, V> Cache<K, V> createCache(
                                .get(settings),
        return AccessController.doPrivileged(() -> {
            }
        String threadPoolAlias  
    @SuppressForbidden(reason = "Ehcache uses File.io")  
            } finally {  
                    + "cacheConfigurationBuilder: "
import java.util.concurrent.locks.ReentrantLock;  
    ) {
                    + cacheType
            lock.unlock();
import org.opensearch.common.settings.Settings;
        if (cacheManagerMap.get(cacheType) == null) {
                cacheManagerMap.remove(cacheType);
        return cacheManagerMap;
import org.ehcache.config.builders.PooledExecutionServiceConfigurationBuilder;  
        String storagePath,
                    + ", diskCacheAlias: "
/**
                logger.warn(
                    }  
    private static final String CACHE_MANAGER_DOES_NOT_EXIST_EXCEPTION_MSG = "Ehcache manager does not exist for " + "cache type: ";  
    /**
                // serializer directly to ehcache, ehcache requires the classes match exactly before/after serialization.  
import org.opensearch.common.SuppressForbidden;
     * Private Constructor
                Cache<K, V> cache = cacheManagerMap.get(cacheType).v1().createCache(diskCacheAlias, cacheConfigurationBuilder
        try {
     * @param cacheConfigurationBuilder cache configuration
     * Used to fetch cache manager for a cache type. If it doesn't exist, it creates one.
                throw ex;
        // Creating the cache requires permissions specified in plugin-security.policy  
                }  
 *
                logger.error("Ehcache disk cache initialization failed due to illegal argument: {}", ex.getMessage());
                if (Files.exists(ehcacheDirectory)) {
                cacheManagerMap.get(cacheType).v2().incrementAndGet();
        }
import org.ehcache.config.builders.CacheManagerBuilder;
     * @param cacheType cache type
            return;
                    () -> new ParameterizedMessage("Trying to close cache for: {} but cache manager does not " + "exist", cacheType)
     * Checks whether cache manager exist for a cache type.
            } catch (Exception ex) {
        if (cacheType == null || diskCacheAlias == null || cacheConfigurationBuilder == null) {  
                            (Integer) EhcacheDiskCacheSettings.getSettingListForCacheType(cacheType)  
import org.opensearch.common.cache.CacheType;  
     * @param storagePath storage path for the cache  
     * @param diskCacheAlias disk cache alias  
import org.ehcache.Cache;
    // Defines one cache manager per cache type.
     * @param threadPoolAlias alias for disk thread pool
        CacheConfigurationBuilder<K, V> cacheConfigurationBuilder
            lock.lock();  
import org.ehcache.PersistentCacheManager;  
                lock.unlock();
                    logger.debug("Closing cache manager for cacheType: " + cacheType);
                    + cacheConfigurationBuilder  
 * The OpenSearch Contributors require contributions made to  
                        .defaultPool(THREAD_POOL_ALIAS_PREFIX + "Default#" + UNIQUE_ID, 1, 3) // Default pool used for other tasks
            }  
                        );
            throw new IllegalArgumentException(
        });  
            }
        } finally {
                    } catch (IOException e) {
        CacheType cacheType,
                }
                throw ex;
