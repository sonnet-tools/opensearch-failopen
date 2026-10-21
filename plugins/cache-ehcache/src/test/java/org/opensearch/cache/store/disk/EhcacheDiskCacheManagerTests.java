            IllegalArgumentException.class,
import java.util.ArrayList;
        }
public class EhcacheDiskCacheManagerTests extends OpenSearchSingleNodeTestCase {
        EhcacheDiskCacheManager.createCache(CacheType.INDICES_REQUEST_CACHE, cacheName, cacheConfigurationBuilder);
import org.ehcache.event.EventType;
    @SuppressWarnings("rawTypes")
        phaser.arriveAndAwaitAdvance();
            String.class,
        );
            });
        assertNull(EhcacheDiskCacheManager.getCacheManagerMap().get(CacheType.INDICES_REQUEST_CACHE));
import java.io.IOException;
            path = env.nodePaths()[0].path.toString() + "/request_cache";
                    new MockEhcacheEventListener<String>(),
    }
        countDownLatch2.await();
        assertEquals(randomThreads, EhcacheDiskCacheManager.getCacheManagerMap().get(CacheType.INDICES_REQUEST_CACHE).v2().get());
            EhcacheDiskCacheManager.getCacheManager(CacheType.INDICES_REQUEST_CACHE, path, Settings.EMPTY, THREAD_POOL_ALIAS);
import org.opensearch.common.settings.Settings;
            ResourcePoolsBuilder.newResourcePoolsBuilder().disk(100, MemoryUnit.B)
        Phaser phaser2 = new Phaser(randomThreads + 1);
    public void testCreateCacheWithNullArguments() {
                    EventType.EXPIRED,
            IllegalArgumentException.class,
        String path = null;
            }
import org.ehcache.config.units.MemoryUnit;
        CountDownLatch countDownLatch2 = new CountDownLatch(randomThreads);
        EhcacheDiskCacheManager.getCacheManagerMap().remove(CacheType.INDICES_REQUEST_CACHE); // Clear up
            () -> EhcacheDiskCacheManager.createCache(CacheType.INDICES_REQUEST_CACHE, cacheName, cacheConfigurationBuilder)
        String path = null;
import java.util.List;
        assertThrows(
import org.opensearch.common.cache.CacheType;
    public void testCreateCacheWithInvalidCacheSize() throws Exception {
            threads[i] = new Thread(() -> {
        String cacheName = "test";
    }
            ResourcePoolsBuilder.newResourcePoolsBuilder().disk(1024 * 100, MemoryUnit.B)
        Thread[] threads = new Thread[randomThreads];
    }
import java.time.Duration;
        @Override
            threads[i].start();
    private static final String THREAD_POOL_ALIAS = "poolAlias";
            String.class,
        CacheConfigurationBuilder<String, String> cacheConfigurationBuilder = CacheConfigurationBuilder.newCacheConfigurationBuilder(
                return null;
        assertFalse(EhcacheDiskCacheManager.doesCacheManagerExist(CacheType.INDICES_REQUEST_CACHE));
                EhcacheDiskCacheManager.createCache(CacheType.INDICES_REQUEST_CACHE, diskCacheAlias, getCacheConfigurationBuilder());
        assertThrows(
                return null;
            threads[i].start();
        );
        CacheConfigurationBuilder<String, String> cacheConfigurationBuilder = CacheConfigurationBuilder.newCacheConfigurationBuilder(
import java.util.function.Supplier;
            String finalPath = path;
    public void testCreateCacheWithInvalidArgument() throws IOException {
        try (NodeEnvironment env = newNodeEnvironment(Settings.EMPTY)) {
                    EventType.EVICTED,
            String.class,
        }
        String cacheName = "test";
 * SPDX-License-Identifier: Apache-2.0
 *
        try (NodeEnvironment env = newNodeEnvironment(Settings.EMPTY)) {
import org.ehcache.expiry.ExpiryPolicy;
                    EventType.CREATED
                countDownLatch2.countDown();
        return cacheConfigurationBuilder;
 * this file be licensed under the Apache-2.0 license or a
        CacheConfigurationBuilder<String, String> cacheConfigurationBuilder = CacheConfigurationBuilder.newCacheConfigurationBuilder(
            String.class,
    }
        );
    }
        }
    public void testCreateAndCloseCacheConcurrently() throws Exception {
        List<String> diskCacheAliases = new ArrayList<>(randomThreads);
            ResourcePoolsBuilder.newResourcePoolsBuilder().disk(1024 * 101, MemoryUnit.B)
            }
        CacheConfigurationBuilder<String, String> cacheConfigurationBuilder = CacheConfigurationBuilder.newCacheConfigurationBuilder(
        Phaser phaser = new Phaser(randomThreads + 1);
        phaser2.arriveAndAwaitAdvance();
            )
import org.ehcache.event.CacheEventListener;
                phaser.arriveAndAwaitAdvance();
        threads = new Thread[randomThreads];
            EhcacheDiskCacheManager.getCacheManager(CacheType.INDICES_REQUEST_CACHE, path, Settings.EMPTY, THREAD_POOL_ALIAS);
import org.opensearch.test.OpenSearchSingleNodeTestCase;
                phaser2.arriveAndAwaitAdvance();
                    EventType.UPDATED,
            String diskCacheAlias = diskCacheAliases.get(i);
import org.ehcache.config.builders.CacheEventListenerConfigurationBuilder;
            EhcacheDiskCacheManager.getCacheManager(CacheType.INDICES_REQUEST_CACHE, path, settings, THREAD_POOL_ALIAS);
            path = env.nodePaths()[0].path.toString() + "/request_cache";
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.event.CacheEvent;
 * compatible open source license.
        public void onEvent(CacheEvent<? extends String, ? extends String> event) {}
    public void testCreateCacheWithCacheManagerDoesNotExist() {
            IllegalStateException.class,
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.impl.config.store.disk.OffHeapDiskStoreConfiguration;
        assertThrows(
            @Override
            () -> EhcacheDiskCacheManager.createCache(CacheType.INDICES_REQUEST_CACHE, "test", null)
    }
            @Override
import org.opensearch.env.NodeEnvironment;
        for (int i = 0; i < randomThreads; i++) {
            @Override
}
            () -> EhcacheDiskCacheManager.createCache(CacheType.INDICES_REQUEST_CACHE, cacheName, cacheConfigurationBuilder)
                CacheEventListenerConfigurationBuilder.newEventListenerConfiguration(
        }
        );
            String.class,
        );
package org.opensearch.cache.store.disk;
                    EventType.REMOVED,
            .withService(
        );
            public Duration getExpiryForCreation(String key, String value) {
        for (int i = 0; i < randomThreads; i++) {
        // Pre-populate aliases to avoid concurrent writes
        }
            public Duration getExpiryForUpdate(String key, Supplier<? extends String> oldValue, String newValue) {
import java.util.concurrent.Phaser;
        })
            IllegalArgumentException.class,
 */
                countDownLatch.countDown();
/*
        countDownLatch.await();
            });
        String path = null;
import java.util.UUID;
        String cacheName = "test";
        int randomThreads = randomIntBetween(5, 10);
        EhcacheDiskCacheManager.closeCache(CacheType.INDICES_REQUEST_CACHE, cacheName, path);
        ).withExpiry(new ExpiryPolicy<>() {
                return null;
            .withService(new OffHeapDiskStoreConfiguration(EhcacheDiskCacheManagerTests.THREAD_POOL_ALIAS, 1));
        CountDownLatch countDownLatch = new CountDownLatch(randomThreads);
import java.util.concurrent.CountDownLatch;
            diskCacheAliases.add(UUID.randomUUID().toString());
        // Try creating cache with the same alias, should fail
    }
        Settings settings = Settings.builder().build();
    class MockEhcacheEventListener<String> implements CacheEventListener<String, String> {
            String diskCacheAlias = diskCacheAliases.get(i);
 * The OpenSearch Contributors require contributions made to
        assertThrows(
        }
            String.class,
            () -> EhcacheDiskCacheManager.createCache(CacheType.INDICES_REQUEST_CACHE, cacheName, cacheConfigurationBuilder)
            String.class,
            threads[i] = new Thread(() -> {
        for (int i = 0; i < randomThreads; i++) {
                EhcacheDiskCacheManager.closeCache(CacheType.INDICES_REQUEST_CACHE, diskCacheAlias, finalPath);
            }
            public Duration getExpiryForAccess(String key, Supplier<? extends String> value) {
            path = env.nodePaths()[0].path.toString() + "/request_cache";
        );
    private CacheConfigurationBuilder<String, String> getCacheConfigurationBuilder() {
                ).unordered().synchronous()
            ResourcePoolsBuilder.newResourcePoolsBuilder().disk(1024 * 100, MemoryUnit.B)
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
            String.class,
