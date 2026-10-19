import org.opensearch.env.NodeEnvironment;  
    @SuppressWarnings("rawTypes")
            path = env.nodePaths()[0].path.toString() + "/request_cache";
import java.util.concurrent.Phaser;  
        );  
        ).withExpiry(new ExpiryPolicy<>() {  
            EhcacheDiskCacheManager.getCacheManager(CacheType.INDICES_REQUEST_CACHE, path, settings, THREAD_POOL_ALIAS);
 * compatible open source license.
            String.class,
                EhcacheDiskCacheManager.createCache(CacheType.INDICES_REQUEST_CACHE, diskCacheAlias, getCacheConfigurationBuilder());
import org.ehcache.config.builders.CacheEventListenerConfigurationBuilder;
import org.ehcache.event.CacheEvent;
import org.ehcache.expiry.ExpiryPolicy;
/*  
 */  
            @Override
import org.ehcache.event.EventType;  
        List<String> diskCacheAliases = new ArrayList<>(randomThreads);  
        );
        }
package org.opensearch.cache.store.disk;
    }
import java.util.UUID;
            }
    private static final String THREAD_POOL_ALIAS = "poolAlias";  
        threads = new Thread[randomThreads];
            IllegalStateException.class,  
        assertThrows(
                phaser2.arriveAndAwaitAdvance();  
            @Override  
            ResourcePoolsBuilder.newResourcePoolsBuilder().disk(1024 * 100, MemoryUnit.B)
        assertThrows(
                countDownLatch2.countDown();
        // Pre-populate aliases to avoid concurrent writes
        phaser2.arriveAndAwaitAdvance();  
            String.class,  
        }  
                ).unordered().synchronous()  
            String.class,
            String finalPath = path;  
        }
    }  
            }  
    }
import org.ehcache.config.builders.ResourcePoolsBuilder;
    public void testCreateCacheWithNullArguments() {
                    EventType.UPDATED,
            threads[i] = new Thread(() -> {  
        assertEquals(randomThreads, EhcacheDiskCacheManager.getCacheManagerMap().get(CacheType.INDICES_REQUEST_CACHE).v2().get());  
        EhcacheDiskCacheManager.getCacheManagerMap().remove(CacheType.INDICES_REQUEST_CACHE); // Clear up  
                    EventType.EVICTED,
            EhcacheDiskCacheManager.getCacheManager(CacheType.INDICES_REQUEST_CACHE, path, Settings.EMPTY, THREAD_POOL_ALIAS);  
            path = env.nodePaths()[0].path.toString() + "/request_cache";
            });  
            String.class,  
        phaser.arriveAndAwaitAdvance();
                CacheEventListenerConfigurationBuilder.newEventListenerConfiguration(
        for (int i = 0; i < randomThreads; i++) {
import java.util.function.Supplier;
}
            IllegalArgumentException.class,  
        assertThrows(
        @Override
 * this file be licensed under the Apache-2.0 license or a
            threads[i] = new Thread(() -> {
        countDownLatch2.await();
import java.util.List;  
            String.class,
        Thread[] threads = new Thread[randomThreads];
            () -> EhcacheDiskCacheManager.createCache(CacheType.INDICES_REQUEST_CACHE, cacheName, cacheConfigurationBuilder)
    public void testCreateAndCloseCacheConcurrently() throws Exception {  
    }  
    }
        Phaser phaser = new Phaser(randomThreads + 1);
    class MockEhcacheEventListener<String> implements CacheEventListener<String, String> {  
        for (int i = 0; i < randomThreads; i++) {
        assertNull(EhcacheDiskCacheManager.getCacheManagerMap().get(CacheType.INDICES_REQUEST_CACHE));  
        return cacheConfigurationBuilder;  
            String.class,
        );  
        CacheConfigurationBuilder<String, String> cacheConfigurationBuilder = CacheConfigurationBuilder.newCacheConfigurationBuilder(
                    EventType.EXPIRED,
            String diskCacheAlias = diskCacheAliases.get(i);
                return null;
 *
    public void testCreateCacheWithInvalidArgument() throws IOException {
    private CacheConfigurationBuilder<String, String> getCacheConfigurationBuilder() {
            )
import java.util.concurrent.CountDownLatch;
    }
public class EhcacheDiskCacheManagerTests extends OpenSearchSingleNodeTestCase {
import org.opensearch.common.cache.CacheType;
            public Duration getExpiryForUpdate(String key, Supplier<? extends String> oldValue, String newValue) {  
                    EventType.CREATED
            () -> EhcacheDiskCacheManager.createCache(CacheType.INDICES_REQUEST_CACHE, "test", null)
 * SPDX-License-Identifier: Apache-2.0
        CountDownLatch countDownLatch = new CountDownLatch(randomThreads);  
import java.time.Duration;
        try (NodeEnvironment env = newNodeEnvironment(Settings.EMPTY)) {
            () -> EhcacheDiskCacheManager.createCache(CacheType.INDICES_REQUEST_CACHE, cacheName, cacheConfigurationBuilder)  
        );  
        })  
        for (int i = 0; i < randomThreads; i++) {
        String cacheName = "test";  
        assertFalse(EhcacheDiskCacheManager.doesCacheManagerExist(CacheType.INDICES_REQUEST_CACHE));
        );
        CacheConfigurationBuilder<String, String> cacheConfigurationBuilder = CacheConfigurationBuilder.newCacheConfigurationBuilder(
        assertThrows(
        );
        CacheConfigurationBuilder<String, String> cacheConfigurationBuilder = CacheConfigurationBuilder.newCacheConfigurationBuilder(
import org.ehcache.impl.config.store.disk.OffHeapDiskStoreConfiguration;
            });
        }  
            public Duration getExpiryForCreation(String key, String value) {
            path = env.nodePaths()[0].path.toString() + "/request_cache";
            threads[i].start();
import org.opensearch.common.settings.Settings;
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        // Try creating cache with the same alias, should fail  
import org.ehcache.config.units.MemoryUnit;  
            .withService(
        CacheConfigurationBuilder<String, String> cacheConfigurationBuilder = CacheConfigurationBuilder.newCacheConfigurationBuilder(
            ResourcePoolsBuilder.newResourcePoolsBuilder().disk(1024 * 101, MemoryUnit.B)
                    new MockEhcacheEventListener<String>(),  
            ResourcePoolsBuilder.newResourcePoolsBuilder().disk(100, MemoryUnit.B)
                phaser.arriveAndAwaitAdvance();
        CountDownLatch countDownLatch2 = new CountDownLatch(randomThreads);
        }
            ResourcePoolsBuilder.newResourcePoolsBuilder().disk(1024 * 100, MemoryUnit.B)
                EhcacheDiskCacheManager.closeCache(CacheType.INDICES_REQUEST_CACHE, diskCacheAlias, finalPath);
            @Override
        int randomThreads = randomIntBetween(5, 10);
            public Duration getExpiryForAccess(String key, Supplier<? extends String> value) {
            String.class,  
            diskCacheAliases.add(UUID.randomUUID().toString());
        public void onEvent(CacheEvent<? extends String, ? extends String> event) {}  
        );
import org.ehcache.config.builders.CacheConfigurationBuilder;  
            }
            String.class,  
    }
            String diskCacheAlias = diskCacheAliases.get(i);
        }  
        String cacheName = "test";  
        String cacheName = "test";
        EhcacheDiskCacheManager.createCache(CacheType.INDICES_REQUEST_CACHE, cacheName, cacheConfigurationBuilder);
 * The OpenSearch Contributors require contributions made to  
    public void testCreateCacheWithInvalidCacheSize() throws Exception {
            IllegalArgumentException.class,
    public void testCreateCacheWithCacheManagerDoesNotExist() {  
import java.io.IOException;  
        countDownLatch.await();
        Phaser phaser2 = new Phaser(randomThreads + 1);  
        EhcacheDiskCacheManager.closeCache(CacheType.INDICES_REQUEST_CACHE, cacheName, path);
        String path = null;
            threads[i].start();
            IllegalArgumentException.class,
        String path = null;
            EhcacheDiskCacheManager.getCacheManager(CacheType.INDICES_REQUEST_CACHE, path, Settings.EMPTY, THREAD_POOL_ALIAS);  
        Settings settings = Settings.builder().build();
            .withService(new OffHeapDiskStoreConfiguration(EhcacheDiskCacheManagerTests.THREAD_POOL_ALIAS, 1));
        try (NodeEnvironment env = newNodeEnvironment(Settings.EMPTY)) {
import java.util.ArrayList;
        try (NodeEnvironment env = newNodeEnvironment(settings)) {  
        String path = null;
            () -> EhcacheDiskCacheManager.createCache(CacheType.INDICES_REQUEST_CACHE, cacheName, cacheConfigurationBuilder)  
                return null;  
import org.ehcache.event.CacheEventListener;
                countDownLatch.countDown();  
                    EventType.REMOVED,  
                return null;
