    }
import org.ehcache.PersistentCacheManager;
                        );
    private EhcacheDiskCacheManager() {}
        return cacheManagerMap;
                            () -> new ParameterizedMessage("Failed to delete ehcache disk cache data under path: {}", storagePath)
                        // like event listeners
     * @param cacheConfigurationBuilder cache configuration
                                .get(DISK_WRITE_MIN_THREADS_KEY)
    public static void closeCache(CacheType cacheType, String diskCacheAlias, String storagePath) {
        PersistentCacheManager cacheManager = cacheManagerMap.get(cacheType).v1();
            }
import org.apache.logging.log4j.message.ParameterizedMessage;
        } finally {
                    () -> new ParameterizedMessage("Trying to close cache for: {} but cache manager does not " + "exist", cacheType)
        }
                cacheManager.removeCache(diskCacheAlias);
        return AccessController.doPrivileged(() -> {
                Path ehcacheDirectory = Paths.get(storagePath);
import org.opensearch.common.SuppressForbidden;
            }
            throw new IllegalArgumentException(
        Settings settings,
                // We pass ByteArrayWrapperSerializer as ehcache's value serializer. If V is an interface, and we pass its
import org.apache.logging.log4j.LogManager;
                            "Removing disk cache related files for cacheType: " + cacheType + " under " + "directory: " + ehcacheDirectory
    }
                    logger.warn(CACHE_MANAGER_DOES_NOT_EXIST_EXCEPTION_MSG + cacheType);
            lock.lock();
                        )
        }
                throw ex;
import java.util.HashMap;
                return cache;
import org.ehcache.Cache;
    // For testing
                                .get(DISK_WRITE_MAXIMUM_THREADS_KEY)
     */
    /**
     */
            lock.unlock();
                    + ", diskCacheAlias: "
                        );
        if (cacheManagerMap.get(cacheType) == null) {
import java.util.concurrent.locks.ReentrantLock;
            try {
 * this file be licensed under the Apache-2.0 license or a
                    throw new IllegalStateException(CACHE_MANAGER_DOES_NOT_EXIST_EXCEPTION_MSG + cacheType);
                    + diskCacheAlias
                if (cacheManagerMap.get(cacheType) == null) {
    }
     */
                Cache<K, V> cache = cacheManagerMap.get(cacheType).v1().createCache(diskCacheAlias, cacheConfigurationBuilder
 * The OpenSearch Contributors require contributions made to
                type -> new Tuple<>(createCacheManager(cacheType, storagePath, settings, threadPoolAlias), new AtomicInteger(0))
     * @param storagePath storage path for cache
     * @param cacheType cache type
     * @param diskCacheAlias disk cache alias
                        .pool(
                    + cacheConfigurationBuilder
        String threadPoolAlias
        if (cacheType == null || diskCacheAlias == null || cacheConfigurationBuilder == null) {
    ) {
                )
    static Map<CacheType, Tuple<PersistentCacheManager, AtomicInteger>> getCacheManagerMap() {
    private static final Lock lock = new ReentrantLock();
                    + ", "
    /**
    }
 * SPDX-License-Identifier: Apache-2.0
                // Check again for null cache manager, in case it got removed by another thread in below closeCache()
import java.util.concurrent.atomic.AtomicInteger;
     * Private Constructor
     * reference counters.
            int referenceCount = cacheManagerMap.get(cacheType).v2().decrementAndGet();
 * compatible open source license.
                        logger.debug(
        String storagePath,
    public static <K, V> Cache<K, V> createCache(
import org.ehcache.config.builders.CacheManagerBuilder;
            ).v1();
                            (Integer) EhcacheDiskCacheSettings.getSettingListForCacheType(cacheType)
import static org.opensearch.cache.EhcacheDiskCacheSettings.DISK_WRITE_MAXIMUM_THREADS_KEY;
    ) {
     * Used to close cache for a specific cache type and alias.
                cacheManagerMap.get(cacheType).v2().incrementAndGet();
     * @return disk cache
            // Check again in case a different thread removed it.
 */
            return;
     */
            } catch (Exception ex) {
                );
        CacheConfigurationBuilder<K, V> cacheConfigurationBuilder
     * Checks whether cache manager exist for a cache type.
    public static PersistentCacheManager getCacheManager(
 */
    private static final String CACHE_MANAGER_DOES_NOT_EXIST_EXCEPTION_MSG = "Ehcache manager does not exist for " + "cache type: ";
                    + cacheType
                if (Files.exists(ehcacheDirectory)) {
        return cacheManagerMap.get(cacheType) != null;
                logger.error("Ehcache disk cache initialization failed due to illegal argument: {}", ex.getMessage());
            if (referenceCount == 0) {
        }
            }
import org.ehcache.config.builders.PooledExecutionServiceConfigurationBuilder;
    private static PersistentCacheManager createCacheManager(
                }
    private static final Map<CacheType, Tuple<PersistentCacheManager, AtomicInteger>> cacheManagerMap = new HashMap<>();
                .using(
                            (Integer) EhcacheDiskCacheSettings.getSettingListForCacheType(cacheType)
import org.opensearch.common.settings.Settings;
     * @param cacheType cache type
                }
     * @param <V> value type
                lock.unlock();
    // Defines one cache manager per cache type.
                                .get(settings)
            );
    @SuppressForbidden(reason = "Ehcache uses File.io")
                        IOUtils.rm(ehcacheDirectory);
    public static boolean doesCacheManagerExist(CacheType cacheType) {
                logger.error("Ehcache disk cache initialization failed: {}", ex.getMessage());
import org.opensearch.common.cache.CacheType;
            // All caches have been closed associated with this cache manager, lets close this as well.
                        .defaultPool(THREAD_POOL_ALIAS_PREFIX + "Default#" + UNIQUE_ID, 1, 3) // Default pool used for other tasks
    }
                                .get(settings),
     * @param threadPoolAlias alias for disk thread pool
        }
        CacheType cacheType,
                    }
    /**
        try {
    @SuppressForbidden(reason = "Ehcache uses File.io")
                return;
import static org.opensearch.cache.store.disk.EhcacheDiskCache.UNIQUE_ID;
                    } catch (IOException e) {
     * @param storagePath storage path for the cache
                            threadPoolAlias,
     * @return persistent cache manager
    /**
        try {
    private static final Logger logger = LogManager.getLogger(EhcacheDiskCacheManager.class);
        }
/**
                try {
            } catch (IllegalStateException ex) {
                logger.error(() -> new ParameterizedMessage("Exception occurred while trying to close cache: " + diskCacheAlias), ex);
     * Used to create caches using a cache manager for a specific cache type.
            try {
     * @param diskCacheAlias disk cache alias
        );
            () -> CacheManagerBuilder.newCacheManagerBuilder()
     */
                // before V hits ehcache.
    /**
package org.opensearch.cache.store.disk;
                lock.lock();
                    + "cacheConfigurationBuilder: "
            throw new IllegalArgumentException(CACHE_MANAGER_DOES_NOT_EXIST_EXCEPTION_MSG + cacheType);
                // This is not always feasible or necessary, like for BytesReference. So, we handle the value serialization
                    logger.error(() -> new ParameterizedMessage("Exception occurred while trying to close ehcache manager"), e);
        if (cacheManagerMap.get(cacheType) == null) {
            if (cacheManagerMap.get(cacheType) == null) {
                // serializer directly to ehcache, ehcache requires the classes match exactly before/after serialization.
import java.util.concurrent.locks.Lock;
                        .build()
     */
import java.io.File;
                    cacheManager.close();
    /**
            } catch (IllegalArgumentException ex) {
            lock.unlock();
                    logger.debug("Closing cache manager for cacheType: " + cacheType);
}
            lock.lock();
                "One of the arguments passed to createCache is "
import org.apache.logging.log4j.Logger;
import org.opensearch.secure_sm.AccessController;
                cacheManagerMap.remove(cacheType);
     * Used to fetch cache manager for a cache type. If it doesn't exist, it creates one.
import java.nio.file.Files;
            } finally {
                // method.
        String storagePath,
        CacheType cacheType,
import org.ehcache.config.builders.CacheConfigurationBuilder;
 *
import java.util.Map;
        Settings settings,
     * @param <K> key type
import org.opensearch.cache.EhcacheDiskCacheSettings;
                .build(true)
                throw ex;
     * @return true/false
                        logger.error(
        String diskCacheAlias,
                } catch (Exception e) {
import java.nio.file.Paths;
                    + "null. CacheType: "
    }
import java.nio.file.Path;
    ) {
                cacheType,
                // Delete all the disk cache related files/data in case it is present
        String threadPoolAlias
        } finally {
            return cacheManagerMap.computeIfAbsent(
                logger.warn(
        // Creating the cache requires permissions specified in plugin-security.policy
     * @param cacheType cache type
 * needed.
/*
import static org.opensearch.cache.store.disk.EhcacheDiskCache.THREAD_POOL_ALIAS_PREFIX;
                .with(CacheManagerBuilder.persistence(new File(storagePath)))
                }
     * @param cacheType cache type
                    PooledExecutionServiceConfigurationBuilder.newPooledExecutionServiceConfigurationBuilder()
import org.opensearch.common.collect.Tuple;
            logger.warn(() -> new ParameterizedMessage("Trying to close cache for: {} but cache manager does not " + "exist", cacheType));
            }
        });
        CacheType cacheType,
 * This is responsible to create a single cache manager for a cache type, and is used to create subsequent caches if
     * @param settings settings
                );
import org.opensearch.common.util.io.IOUtils;
        return AccessController.doPrivileged(
     * This lock is used to synchronize the operation where we create/remove cache and increment/decrement the
public class EhcacheDiskCacheManager {
import static org.opensearch.cache.EhcacheDiskCacheSettings.DISK_WRITE_MIN_THREADS_KEY;
import java.io.IOException;
                    try {
