    }
                }
                .build();  
                });  
                .setCacheType(CacheType.INDICES_REQUEST_CACHE)
                                    CACHE_SIZE_IN_BYTES
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        }
        EhcacheDiskCache<String, String> cache = setupMaxSizeTest(maxSizeFromSetting, maxSizeFromConfig, false);
                keysAdded.add(key);  
                keyValueMap.put(getICacheKey(UUID.randomUUID().toString()), composite);
                .setIsEventListenerModeSync(true)  
                .build();
import java.util.Iterator;
                .setValueSerializer(new StringSerializer())
    public void testInvalidateWithDropDimensions() throws Exception {
        cache.close();
                    LoadAwareCacheLoader<ICacheKey<String>, String> loadAwareCacheLoader = new LoadAwareCacheLoader<>() {
    // Modified from OpenSearchOnHeapCacheTests.java  
            for (int i = 0; i < randomKeys; i++) {
    }
                .setKeyType(String.class)  
                    .setStatsTrackingEnabled(false)  
                .setKeyType(String.class)
                .setValueType(String.class)
    public void testDiskCacheFilesAreClearedUpDuringCloseAndInitialization() throws Exception {  
    public void testEhcacheDiskCacheWithoutStoragePathDefined() throws Exception {
                .setKeyType(String.class)  
            // Generate a string with 100 characters
        MockRemovalListener<String, String> removalListener = new MockRemovalListener<>();
                .setExpireAfterAccess(TimeValue.MAX_VALUE)
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
import static org.mockito.Mockito.mock;
                iCaches.get(i).close();
                .setStoragePath(env.nodePaths()[0].indicesPath.toString() + "/request_cache")
    }
                                )  
                    assertThrows(ExecutionException.class, () -> ehcacheTest.computeIfAbsent(getICacheKey(key), loadAwareCacheLoader));
            CacheConfig.Builder<String, String> cacheConfigBuilder = new CacheConfig.Builder<String, String>().setKeyType(String.class)
    public void testEhcacheWithStorageSizeZero() throws Exception {  
                .setKeySerializer(new StringSerializer())  
            for (int i = 0; i < expectedNumberOfMisses; i++) {  
                .setKeyType(String.class)
        MockRemovalListener<String, String> removalListener = new MockRemovalListener<>();
                IllegalArgumentException.class,  
        PersistentCacheManager buildCacheManager() {
                    .setKeyType(String.class)
                .build();  
                ehcacheTest.put(entry.getKey(), entry.getValue());  
                }
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
                .setSettings(settings)
                    } catch (Exception ex) {
                    Map.of()
            for (Map.Entry<String, String> entry : keyValueMap.entrySet()) {
                cacheConfigBuilder.build(),
                rand.nextBytes(compositeBytes2);  
            int randomKeys = randomIntBetween(10, 100);
import org.opensearch.common.cache.ICacheKey;
                );  
            int numberOfRequest = 2;// randomIntBetween(200, 400);
            int randomKeys = randomIntBetween(20, 100);
            }
        Random rand = Randomness.get();
                                        .get(DISK_LISTENER_MODE_SYNC_KEY)  
                                        .getKey(),
                        .setCacheAlias("ehcache_disk#" + i)
                .setValueType(String.class)
                .setStoragePath(env.nodePaths()[0].indicesPath.toString() + "/request_cache")
                    removedKeyList.add(key);
                    maxSizeFromSetting
            ICache<String, String> ehcacheTest = new EhcacheDiskCache.Builder<String, String>().setDiskCacheAlias(generateRandomString(5))
            }
                .build();  
    public void testEvictions() throws Exception {
                    assertNull(snapshot);
                                    .getKey(),  
                ehcacheTest.put(getICacheKey(UUID.randomUUID().toString()), UUID.randomUUID().toString());
            }  
                .setRemovalListener(removalListener)  
                .setSettings(settings)
            for (int i = 0; i < expectedNumberOfMisses; i++) {
                .setKeyType(String.class)
                    CacheType.INDICES_REQUEST_CACHE,
                assertEquals(entry.getValue(), value);
            }
                .setWeigher(getWeigher())
                ehcacheTest.put(key, value);
                    .setRemovalListener(removalListener)
                                .put(
            Phaser phaser = new Phaser(randomKeys + 1);  
                .setWeigher(getWeigher())
    public void testInvalidateAll() throws Exception {
                            return null;  
                assertNull(ehcacheTest.get(removedKey));
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
        MockRemovalListener<String, String> removalListener = new MockRemovalListener<>();
    }
                ehcacheTest.get(getICacheKey(UUID.randomUUID().toString()));
                ehCacheDiskCachingTier.put(key, UUID.randomUUID().toString());
                assertNotNull(ehcacheTest.get(key));
                .setMaximumWeightInBytes(CACHE_SIZE_IN_BYTES)
            // (used from disk cache alias)  
                    .setKeyType(String.class)  
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
            return new String(bytes, charset);
                                EhcacheDiskCacheSettings.getSettingListForCacheType(CacheType.INDICES_REQUEST_CACHE)
    }
                .setValueSerializer(new StringSerializer())  
            }
                .setCacheType(CacheType.INDICES_REQUEST_CACHE)
            ehcacheTest.invalidateAll(); // clear all the entries.
                byte[] compositeBytes2 = new byte[valueLength];
                .setValueSerializer(new StringSerializer())  
                .setCacheType(CacheType.INDICES_REQUEST_CACHE)
                BytesReference value = ehCacheDiskCachingTier.get(entry.getKey());
                .setDimensionNames(List.of(dimensionName))
            }
                        @Override  
                        boolean isLoaded;
            randomString.append(characters.charAt(index));
                        boolean isLoaded;
        // Test all cases for EhCacheEventListener.onEvent and check stats memory usage is updated correctly  
        long maxSizeFromSetting = between(MINIMUM_MAX_SIZE_IN_BYTES + 1000, MINIMUM_MAX_SIZE_IN_BYTES + 2000);
        MockRemovalListener<String, String> removalListener = new MockRemovalListener<>();
                int newLengthDifference = randomIntBetween(-20, 20);
            int randomKeys = randomIntBetween(2, 100);  
                    .setStatsTrackingEnabled(false)  
            );
            int keysCount = 0;  
import org.opensearch.core.common.bytes.BytesArray;  
                .setWeigher(weigher)
            assertEquals(keyValueMap.size(), ehcacheTest.count());
import org.opensearch.common.util.io.IOUtils;
                .setWeigher(getWeigher())
 * compatible open source license.
                ehcacheTest.put(iCacheKey, entry.getValue());
import java.nio.charset.Charset;
                .setMaximumWeightInBytes(CACHE_SIZE_IN_BYTES)
 * this file be licensed under the Apache-2.0 license or a
            ICache.Factory cacheFactory = new EhcacheDiskCache.EhcacheDiskCacheFactory();  
                });
    public void testEhcacheKeyIteratorWithRemove() throws IOException {
            assertTrue(Files.exists(Path.of(path)));
 * The OpenSearch Contributors require contributions made to  
        assertEquals(maxSizeFromSetting, cache.getMaximumWeight());  
            int randomKeys = randomIntBetween(2, 100);
            while (keys.hasNext()) {
                .build();
    }  
                env.nodePaths()[0].indicesPath.toString() + "/request_cache"  
            Random rand = Randomness.get();
                    .setCacheType(CacheType.INDICES_REQUEST_CACHE)  
                .setMaximumWeightInBytes(CACHE_SIZE_IN_BYTES * 20) // bigger so no evictions happen
                .setSettings(settings)
                .setExpireAfterAccess(TimeValue.MAX_VALUE)  
                                    .get(DISK_MAX_SIZE_IN_BYTES_KEY)
                    .build()
        }  
    public void testEhcacheKeyIterator() throws Exception {
            ICache<String, String> ehcacheTest = new EhcacheDiskCache.Builder<String, String>().setStoragePath(  
                assertEquals(0, ehcacheTest.count()); // Expect count of 0 if NoopCacheStatsHolder is used
            // Test CREATED case
            new ICacheKey<>(generateRandomString(initialKeyLength), getMockDimensions()),  
                .setIsEventListenerModeSync(true)
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
                .setSettings(settings)  
                expectedSize -= weigher.applyAsLong(removedKey, updatedValues.get(removedKey));
                .build();
            IOUtils.rm(Path.of(path));  
            // Try to hit different request with the same key concurrently. Loader throws exception.
    static class StringSerializer implements Serializer<String, byte[]> {
                    .setMaximumWeightInBytes(MINIMUM_MAX_SIZE_IN_BYTES)  
                .setValueSerializer(new StringSerializer())
            Thread[] threads = new Thread[numberOfRequest];
            return totalSize;
            }  
        Settings settings = Settings.builder().build();  
                                .put(
                ICacheKey<String> iCacheKey = getICacheKey(UUID.randomUUID().toString());  
                        public boolean isLoaded() {
                .setKeySerializer(new StringSerializer())
        MockRemovalListener<String, String> removalListener = new MockRemovalListener<>();  
            generateRandomString(initialValueLength)
                IllegalArgumentException.class,  
                .setMaximumWeightInBytes(CACHE_SIZE_IN_BYTES)
    }
    }
                    .setDiskCacheAlias("test1")
                .setMaximumWeightInBytes(CACHE_SIZE_IN_BYTES)  
                    phaser.arriveAndAwaitAdvance();  
            int count = 0;
        assertEquals(maxSizeFromConfig, cache.getMaximumWeight());
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";  
                ICacheKey<String> iCacheKey = getICacheKey(UUID.randomUUID().toString());  
                    env.nodePaths()[0].indicesPath.toString() + "/request_cache/"
                .setStoragePath(env.nodePaths()[0].indicesPath.toString() + "/request_cache")
            ICache<String, String> ehcacheTest = new EhcacheDiskCache.Builder<String, String>().setStoragePath(path)  
                    .setRemovalListener(removalListener)  
        }  
                        .setDimensionNames(List.of(dimensionName))
            );
    }
                                )  
                            )
            assertEquals(originalSize - removedKeyList.size(), ehcacheTest.count());
            ehcacheTest.close();
            )
        return List.of("0");  
            HashMap<ICacheKey<String>, String> updatedValues = new HashMap<>();
            // Now assert the stats are gone for any key that has this combination of dimensions, but still there otherwise
            // Trying to generate more than 100kb to cause evictions.
                    LoadAwareCacheLoader<ICacheKey<String>, String> loadAwareCacheLoader = new LoadAwareCacheLoader<>() {  
                .setWeigher(weigher)
                cacheConfigBuilder.setMaxSizeInBytes(maxSizeFromConfig);  
            Map<String, String> keyValueMap = new HashMap<>();
            int randomKeys = randomIntBetween(10, 100);
            countDownLatch.await(); // Wait for all threads to finish
            for (int i = 0; i < numberOfRequest; i++) {
import org.opensearch.common.cache.serializer.BytesReferenceSerializer;  
                .setSettings(settings)  
        MockRemovalListener<String, String> removalListener = new MockRemovalListener<>();
        int maxEntries = 2000;  
                        boolean isLoaded;
        MockRemovalListener<String, String> removalListener = new MockRemovalListener<>();
                .setDimensionNames(List.of(dimensionName))
                    .setIsEventListenerModeSync(true)
            ehcacheTest.close();
                    .setValueType(String.class)
        try (NodeEnvironment env = newNodeEnvironment(settings)) {  
                assertEquals(0, ehcacheTest.count()); // Expect count of 0 if NoopCacheStatsHolder is used
            for (int i = 0; i < randomKeys; i++) {  
                    try {
            int randomKeys = randomIntBetween(20, 100);  
            Path dummyFilePath = Files.createFile(Path.of(path + "/testing.txt"));
                .setDimensionNames(List.of(dimensionName))  
                .setExpireAfterAccess(TimeValue.MAX_VALUE)
            ehcacheTest.close();  
                    .setValueSerializer(new StringSerializer())
            ehcacheTest.close();
                        public String load(ICacheKey<String> key) {
            for (Map.Entry<ICacheKey<String>, String> entry : keyValueMap.entrySet()) {
                    CacheSettings.getConcreteStoreNameSettingForCacheType(CacheType.INDICES_REQUEST_CACHE).getKey(),  
            for (int i = 0; i < numInitialKeys; i++) {
            // Try to hit different request with the same key concurrently. Loader throws exception.  
                ICacheKey<String> key = iterator.next();  
                .setDiskCacheAlias(generateRandomString(5))  
            }
                            isLoaded = true;
import org.opensearch.common.cache.settings.CacheSettings;
            countDownLatch.await();
            ICache<String, String> ehcacheTest = new EhcacheDiskCache.Builder<String, String>().setDiskCacheAlias(generateRandomString(5))
                .setMaximumWeightInBytes(CACHE_SIZE_IN_BYTES)
    public void testWithCacheConfigSizeSettings() throws Exception {  
            phaser.arriveAndAwaitAdvance();  
        ToLongBiFunction<ICacheKey<String>, String> weigher = getWeigher();
                    removedKeyList.add(entry.getKey());  
                .setDiskCacheAlias(generateRandomString(5))  
    }
                threads[i] = new Thread(() -> {  
                if (loadAwareCacheLoaderList.get(i).isLoaded()) {  
            assertEquals(1, ehcacheTest.stats().getTotalMisses());  
            }
                            )
    }
            }
                    ehcacheTest.put(entry.getKey(), entry.getValue());
        }
                            return isLoaded;  
            ehcacheTest.close();
        StringBuilder randomString = new StringBuilder(length);
                .build();
            for (Map.Entry<String, String> entry : keyValueMap.entrySet()) {
import java.io.IOException;  
                .setValueSerializer(new StringSerializer())  
import org.opensearch.common.cache.LoadAwareCacheLoader;  
        }
            }
                ehcacheTest.put(entry.getKey(), entry.getValue());
                    EhcacheDiskCacheSettings.getSettingListForCacheType(CacheType.INDICES_REQUEST_CACHE)
            // TODO: Ehcache incorrectly evicts at 30-40% of max size. Fix this test once we figure out why.
                                    .getKey(),  
                )
                                EhcacheDiskCacheSettings.getSettingListForCacheType(CacheType.INDICES_REQUEST_CACHE)
                    .setSettings(settings)  
    }
    public void testBasicGetAndPutBytesReference() throws Exception {
            for (int i = 0; i < 20; i++) {
            int expectedNumberOfMisses = randomIntBetween(10, 200);
    public void testEhcacheDiskCacheWithoutStoragePathNull() throws Exception {
                        }
            String key = UUID.randomUUID().toString();  
        }
import org.opensearch.common.unit.TimeValue;
        }
                        assertThat(ex.getCause(), instanceOf(NullPointerException.class));
                    .build()  
            assertEquals(randomKeys, ehcacheTest.stats().getTotalHits());  
                .setExpireAfterAccess(TimeValue.MAX_VALUE)
            CountDownLatch countDownLatch = new CountDownLatch(numberOfRequest);  
            return (EhcacheDiskCache<String, String>) cacheFactory.create(
            int randomKeys = randomIntBetween(10, 100);
            PersistentCacheManager cacheManager = mock(PersistentCacheManager.class);
                    .setExpireAfterAccess(TimeValue.MAX_VALUE)
                ICacheKey<String> key = keys.next();
        Settings settings = Settings.builder().build();  
            }
                .setDimensionNames(List.of(dimensionName))
    private List<String> getMockDimensions() {
                                    EhcacheDiskCacheSettings.getSettingListForCacheType(CacheType.INDICES_REQUEST_CACHE)
                    .setKeySerializer(new StringSerializer())  
                ehcacheTest.put(entry.getKey(), entry.getValue());
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;  
import static org.opensearch.cache.EhcacheDiskCacheSettings.DISK_MAX_SIZE_IN_BYTES_KEY;  
            // assertEquals(maxEntries * sizeForOneInitialEntry, ehcacheTest.stats().getTotalMemorySize());
import java.util.ArrayList;
            List<LoadAwareCacheLoader<ICacheKey<String>, String>> loadAwareCacheLoaderList = new CopyOnWriteArrayList<>();
        Settings settings = Settings.builder().build();
                .build();
            return object.equals(deserialize(bytes));  
    public void testMemoryTracking() throws Exception {
                .setValueSerializer(new StringSerializer())  
                .setValueType(String.class)  
                .setMaximumWeightInBytes(CACHE_SIZE_IN_BYTES)
                    .setRemovalListener(removalListener)
            assertThrows(
            }  
                                EhcacheDiskCacheSettings.getSettingListForCacheType(CacheType.INDICES_REQUEST_CACHE)
                String value = ehcacheTest.get(entry.getKey());
                        public String load(ICacheKey<String> key) throws Exception {
                .setValueType(String.class)
    public void testComputeIfAbsentConcurrently() throws Exception {
                assertEquals(new ImmutableCacheStats(0, 0, 0, 0, 0), ehcacheTest.stats().getTotalStats());  
                ICacheKey<String> iCacheKey = getICacheKey(UUID.randomUUID().toString());  
                IllegalArgumentException.class,
                        .setMaxSizeInBytes(CACHE_SIZE_IN_BYTES * 100)  
                        .setRemovalListener(removalListener)
            Map<ICacheKey<String>, String> keyValueMap = new HashMap<>();
        MockRemovalListener<String, String> removalListener = new MockRemovalListener<>();
            }
            ICache<String, String> ehcacheTest = new EhcacheDiskCache.Builder<String, String>().setDiskCacheAlias(generateRandomString(5))
            result.add(String.valueOf(rand.nextInt(bound)));  
            assertEquals(randomKeys, ehcacheTest.stats().getTotalHits());  
            }
                .setDimensionNames(dimensionNames)  
            assertEquals(0, ((EhcacheDiskCache) ehcacheTest).getCompletableFutureMap().size());  
                .filter(Files::isDirectory)  
                String value = generateRandomString(initialValueLength);  
            }
                        .get(DISK_STORAGE_PATH_KEY)
                    phaser.arriveAndAwaitAdvance();
            }
                updatedValues.put(initialKeys.get(i), newValue);
        Settings settings = Settings.builder().build();
                rand.nextBytes(compositeBytes1);
import java.nio.file.Files;  
            assertEquals(randomKeys, ehcacheTest.count());
        }
                .setCacheType(CacheType.INDICES_REQUEST_CACHE)  
    public void testStatsTrackingDisabled() throws Exception {  
import java.util.Random;
                    .setStatsTrackingEnabled(false)  
                .setKeyType(String.class)
        cache.close();
            }
            super(builder);  
        // The cache should get its size from the config if present, and otherwise should get it from the setting.
                .setCacheType(CacheType.INDICES_REQUEST_CACHE)  
            Phaser phaser = new Phaser(numberOfRequest + 1);
                IllegalArgumentException.class,
import org.opensearch.common.metrics.CounterMetric;
                () -> new EhcacheDiskCache.Builder<String, String>().setThreadPoolAlias("ehcacheTest")  
@AwaitsFix(bugUrl = "flaky test - enable after fix")
                .setCacheType(CacheType.INDICES_REQUEST_CACHE)  
                .setExpireAfterAccess(TimeValue.MAX_VALUE)
                .setKeyType(String.class)
import org.opensearch.common.cache.store.config.CacheConfig;
                                    true
                .setIsEventListenerModeSync(true) // For accurate count  
        }
            for (int i = 0; i < numberOfRequest; i++) {
            evictionMetric.inc();  
                    assertEquals(entry.getValue(), ehcacheTest.get(getICacheKey(entry.getKey())));
        CounterMetric evictionMetric = new CounterMetric();
                .setStatsTrackingEnabled(false)  
                .setStatsTrackingEnabled(false)
            Thread[] threads = new Thread[numberOfRequest];
            for (int i = 0; i < numInitialKeys * 0.5; i++) {  
            CountDownLatch countDownLatch = new CountDownLatch(numberOfRequest);
            assertFalse(Files.exists(Path.of(path))); // Verify everything is cleared up now after close()  
        return (iCacheKey, value) -> {
            assertEquals(0, ((EhcacheDiskCache) ehcacheTest).getCompletableFutureMap().size());
                        .getKey(),  
                .build();  
                    .setKeySerializer(new StringSerializer())
                )
                    .setIsEventListenerModeSync(true)
                .setKeySerializer(new StringSerializer())  
            String key = UUID.randomUUID().toString();
                .setValueSerializer(new StringSerializer())
                byte[] valueBytes = new byte[valueLength];
            ICache<String, BytesReference> ehCacheDiskCachingTier = new EhcacheDiskCache.Builder<String, BytesReference>()
            String[] levels = dimensionNames.toArray(new String[0]);  
        };  
            int numberOfTimesValueLoaded = 0;
                .setCacheType(CacheType.INDICES_REQUEST_CACHE)
            // Test EVICTED case by adding entries past the cap and ensuring memory size stays as what we expect
                    numberOfTimesValueLoaded++;
            phaser.arriveAndAwaitAdvance();
                .setRemovalListener(removalListener)
                .setValueSerializer(new StringSerializer())
        Settings settings = Settings.builder().build();  
        try (NodeEnvironment env = newNodeEnvironment(settings)) {  
                .setValueSerializer(new StringSerializer())  
                    .setWeigher(getWeigher())  
                    assertNotNull(snapshot);
        Settings settings = Settings.builder().build();  
        List<ICache<String, String>> iCaches = new ArrayList<>();
import static org.opensearch.cache.EhcacheDiskCacheSettings.DISK_STORAGE_PATH_KEY;
                    .build()
            assertEquals(keyValueMap.size() - removedKeyList.size(), ehcacheTest.count());
            ICache<String, String> ehcacheTest = new EhcacheDiskCache.Builder<String, String>().setDiskCacheAlias("test1")  
import java.util.UUID;
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
                assertEquals(entry.getValue(), value);  
                .setWeigher(getWeigher())
    }  
        Settings settings = Settings.builder().build();  
    }  
                    iterator.remove();  
                    countDownLatch.countDown();
                .setWeigher(getWeigher())  
                    .setSettings(settings)
    private static String generateRandomString(int length) {
                .setMaximumWeightInBytes(CACHE_SIZE_IN_BYTES)  
                ehcacheTest.put(initialKeys.get(i), newValue);  
            // Verify that there is data present under desired path by explicitly verifying the folder name by prefix
                .setIsEventListenerModeSync(true)
    public void testComputeIfAbsentWithNullValueLoading() throws Exception {  
            // Now try removing subset of keys and verify  
                .setDiskCacheAlias(generateRandomString(5))
        ToLongBiFunction<ICacheKey<String>, String> weigher = getWeigher();
            List<LoadAwareCacheLoader<ICacheKey<String>, String>> loadAwareCacheLoaderList = new CopyOnWriteArrayList<>();
                    .setValueSerializer(new StringSerializer())
    }  
            CountDownLatch countDownLatch = new CountDownLatch(numberOfRequest);  
            int j = 0;  
                .setIsEventListenerModeSync(true)
            ICache.Factory ehcacheFactory = new EhcacheDiskCache.EhcacheDiskCacheFactory();
                .setRemovalListener(new MockRemovalListener<>())
            ICache<String, String> ehcacheTest = new EhcacheDiskCache.Builder<String, String>().setThreadPoolAlias(null)
            }
                .setValueSerializer(new StringSerializer())  
import org.ehcache.PersistentCacheManager;  
                    LoadAwareCacheLoader<ICacheKey<String>, String> loadAwareCacheLoader = new LoadAwareCacheLoader<>() {
                .setRemovalListener(removalListener)
            String path = env.nodePaths()[0].path.toString() + "/request_cache";
            for (int i = 0; i < 1000; i++) {  
        return randomString.toString();
                expectedSize += weigher.applyAsLong(iCacheKey, entry.getValue());
        private final Charset charset = StandardCharsets.UTF_8;
            ehcacheTest.close();
                                    env.nodePaths()[0].indicesPath.toString() + "/request_cache/"
                assertEquals(entry.getValue(), value);  
                .setKeySerializer(new StringSerializer())
    public void testDiskCacheCloseCalledTwiceAndVerifyDiskDataIsCleanedUp() throws Exception {
    public void testEhcacheWithStorageSizeLowerThanMinimumExpected() throws Exception {  
            // Validate misses
                .put(  
                    countDownLatch.countDown();
            int randomKeys = randomIntBetween(10, 100);  
        try (NodeEnvironment env = newNodeEnvironment(settings)) {  
            int randomKeys = randomIntBetween(10, 100);
            boolean folderExists = Files.walk(Path.of(path))
    }
            for (Iterator<ICacheKey<String>> iterator = ehcacheTest.keys().iterator(); iterator.hasNext();) {
        }
                .setRemovalListener(removalListener)
                    .setWeigher(weigher)
                .setValueType(String.class)  
                        .setSettings(
        Settings settings = Settings.builder().build();
                .setIsEventListenerModeSync(true)
                .setMaximumWeightInBytes(CACHE_SIZE_IN_BYTES)  
    }  
                                    EhcacheDiskCacheSettings.getSettingListForCacheType(CacheType.INDICES_REQUEST_CACHE)
                String value = generateRandomString(initialValueLength);
    }
        public boolean equals(String object, byte[] bytes) {
                } else {  
                .build();  
                .build();  
            List<ICacheKey<String>> keysAdded = new ArrayList<>();
                .setValueType(String.class)
            }  
            assertEquals(1, ehcacheTest.count());  
                .setDimensionNames(List.of(dimensionName))  
                .setSettings(settings)
                ICache<String, String> ehcacheTest = ehcacheFactory.create(
                                        .get(DISK_MAX_SIZE_IN_BYTES_KEY)  
                ICacheKey<String> key = new ICacheKey<>(generateRandomString(initialKeyLength), getMockDimensions());
                .setDiskCacheAlias(generateRandomString(5))  
            for (Map.Entry<String, String> entry : keyValueMap.entrySet()) {  
                .setMaximumWeightInBytes(CACHE_SIZE_IN_BYTES)
                        @Override  
                    .setKeySerializer(new StringSerializer())
        }  
            ArrayList<ICacheKey<String>> initialKeys = new ArrayList<>();  
            // Size consumed by value  
            return object.getBytes(charset);  
                .setValueType(String.class)
            for (int i = 0; i < numInitialKeys * 0.5; i++) {
                .setValueSerializer(new StringSerializer())
import java.util.function.ToLongBiFunction;
                .setSettings(settings)  
            for (Map.Entry<ICacheKey<String>, String> entry : keyValueMap.entrySet()) {  
                                    .get(DISK_STORAGE_PATH_KEY)
                    new CacheConfig.Builder<String, String>().setValueType(String.class)
            ICache<String, String> ehcacheTest = new EhcacheDiskCache.Builder<String, String>().setDiskCacheAlias(generateRandomString(5))
                .setExpireAfterAccess(TimeValue.MAX_VALUE)
                ICache<String, String> ehcacheTest = iCaches.get(entry.getKey().hashCode() & (segments - 1));
        }
            );
            assertEquals(randomKeys, count);
            ehcacheTest.close();
                ehCacheDiskCachingTier.put(entry.getKey(), entry.getValue());
            assertFalse(Files.exists(dummyFilePath));  
                        .setKeyType(String.class)  
                ehcacheTest.invalidate(removedKey);  
                .setSettings(settings)  
        MockRemovalListener<String, String> removalListener = new MockRemovalListener<>();  
            Map<ICacheKey<String>, String> keyValueMap = new HashMap<>();
            for (int i = 0; i < randomKeys; i++) {
                                        .getKey(),
            }
        return new ICacheKey<>(key, getMockDimensions());
            )
                .setDimensionNames(List.of(dimensionName))
        Settings settings = Settings.builder().build();
                    EhcacheDiskCacheSettings.getSettingListForCacheType(CacheType.INDICES_REQUEST_CACHE)
                .setMaximumWeightInBytes(CACHE_SIZE_IN_BYTES)
                .setValueType(String.class)
                .setRemovalListener(removalListener)
    private final String dimensionName = "shardId";
                                )  
                    .setRemovalListener(removalListener)
                if (randomBoolean()) {
            Iterator<ICacheKey<String>> keys = ehcacheTest.keys().iterator();
                    countDownLatch.countDown();
                .setKeyType(String.class)
                .setCacheType(CacheType.INDICES_REQUEST_CACHE)
import java.util.concurrent.ExecutionException;
            assertTrue(folderExists);
            }
                            return value;  
                .setValueType(String.class)  
            for (ICacheKey<String> removedKey : removedKeyList) {
                .setKeyType(String.class)
import org.opensearch.common.cache.ICache;
        }
                .setSettings(settings)
        );
        MockRemovalListener<String, String> removalListener = new MockRemovalListener<>();
                    .setKeyType(String.class)  
            int randomKeys = randomIntBetween(10, 100);
                threads[i].start();
                        assertEquals(value, ehcacheTest.computeIfAbsent(getICacheKey(key), loadAwareCacheLoader));  
            }
                .setSettings(settings)  
                .setMaximumWeightInBytes(CACHE_SIZE_IN_BYTES)
            }  
                ICacheKey<String> key = new ICacheKey<>(generateRandomString(initialKeyLength), getMockDimensions());
                assertEquals(entry.getValue(), value);  
                .setCacheType(CacheType.INDICES_REQUEST_CACHE)
                    .setKeySerializer(new StringSerializer())
            for (Map.Entry<ICacheKey<String>, String> entry : keyValueMap.entrySet()) {
                ehcacheTest.put(getICacheKey(entry.getKey()), entry.getValue());
                    .setValueSerializer(new StringSerializer())
            ehcacheTest.close();
                        Settings.builder()
                ehcacheTest.put(iCacheKey, UUID.randomUUID().toString());
                    .setCacheType(CacheType.INDICES_REQUEST_CACHE)  
                .setValueType(String.class)
        ToLongBiFunction<ICacheKey<String>, String> weigher = getWeigher();  
                    ehcacheTest.invalidate(entry.getKey());
                keyValueMap.put(getICacheKey(UUID.randomUUID().toString()), UUID.randomUUID().toString());
            ehcacheTest.close();
        MockRemovalListener<String, String> listener = new MockRemovalListener<>();
            for (int i = 0; i < randomKeys; i++) {
    public void testConcurrentPut() throws Exception {  
                    };
                .setIsEventListenerModeSync(true)
            for (int i = 0; i < randomKeys; i++) {
        cache = setupMaxSizeTest(maxSizeFromSetting, maxSizeFromConfig, true);  
                .setRemovalListener(removalListener)  
                ehcacheTest.put(iCacheKey, UUID.randomUUID().toString());
                            )
                .setCacheType(CacheType.INDICES_REQUEST_CACHE)
            List<LoadAwareCacheLoader<ICacheKey<String>, String>> loadAwareCacheLoaderList = new CopyOnWriteArrayList<>();
            totalSize += 10; // The ICacheKeySerializer writes 2 VInts to record array lengths, which can be 1-5 bytes each
                .setKeyType(String.class)
            String value = "dummy";  
import static org.opensearch.cache.EhcacheDiskCacheSettings.DISK_LISTENER_MODE_SYNC_KEY;
                keyValueMap.put(getICacheKey(UUID.randomUUID().toString()), UUID.randomUUID().toString());  
                .setExpireAfterAccess(TimeValue.MAX_VALUE)  
                .setWeigher(weigher)
    }
            ehcacheTest.close();  
                assertEquals(expectedSize, ehcacheTest.stats().getTotalStats().getSizeInBytes());  
                .setKeySerializer(new StringSerializer())  
                keyValueMap.put(getICacheKey(UUID.randomUUID().toString()), UUID.randomUUID().toString());  
                keyValueMap.put(getICacheKey(UUID.randomUUID().toString()), new BytesArray(valueBytes));  
                .setWeigher(getWeigher())  
                    .setCacheType(CacheType.INDICES_REQUEST_CACHE)  
                    .setIsEventListenerModeSync(true)
                .setExpireAfterAccess(TimeValue.MAX_VALUE)
        try (NodeEnvironment env = newNodeEnvironment(Settings.builder().build())) {  
        MockRemovalListener<String, String> removalListener = new MockRemovalListener<>();
                    .setValueType(String.class)
            long totalSize = iCacheKey.key.length();
            ICache<String, String> ehcacheTest = new EhcacheDiskCache.Builder<String, String>().setStoragePath(  
                    } catch (Exception e) {
            ICacheKey<String> keyToDrop = keysAdded.get(0);
            for (Map.Entry<ICacheKey<String>, String> entry : keyValueMap.entrySet()) {  
    }  
                threads[i].start();  
import java.util.concurrent.CountDownLatch;
                                true
                .setDimensionNames(List.of(dimensionName))  
        @Override
                .setRemovalListener(removalListener)  
        Settings settings = Settings.builder().build();  
                    )
                                .put(
                    .setDiskCacheAlias("test1")  
import java.util.HashMap;  
                .setWeigher(weigher)  
import org.opensearch.common.cache.CacheType;  
    }
            ImmutableCacheStats snapshot = ehCacheDiskCachingTier.stats(levels).getStatsForDimensionValues(keyToDrop.dimensions);
        MockRemovalListener<String, String> removalListener = new MockRemovalListener<>();
            for (Map.Entry<ICacheKey<String>, String> entry : keyValueMap.entrySet()) {
            }
                    loadAwareCacheLoaderList.add(loadAwareCacheLoader);
                            .put(  
        }  
import org.opensearch.common.cache.stats.ImmutableCacheStats;  
                env.nodePaths()[0].indicesPath.toString() + "/request_cache"
            assertEquals(expectedNumberOfMisses, ehcacheTest.stats().getTotalMisses());
                                CACHE_SIZE_IN_BYTES
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
                .setDimensionNames(List.of(dimensionName))
                .setSettings(settings)
                .build();
                                        .get(DISK_STORAGE_PATH_KEY)  
                .setKeySerializer(new StringSerializer())
                assertEquals(entry.getValue(), value);
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
            assertEquals(randomKeys, ehcacheTest.count());  
                ehcacheTest.put(iCacheKey, UUID.randomUUID().toString());
        }
            int numberOfRequest = randomIntBetween(200, 400);
import org.opensearch.common.cache.RemovalNotification;
                assertEquals(0, ehcacheTest.count()); // Expect count storagePath 0 if NoopCacheStatsHolder is used
            Thread[] threads = new Thread[randomKeys];
                .setKeySerializer(new StringSerializer())
                .setWeigher(weigher)
            assertEquals(numberOfRequest - 1, ehcacheTest.stats().getTotalHits());
import org.opensearch.env.NodeEnvironment;  
                .setWeigher((key, value) -> 1)
                .setStoragePath(env.nodePaths()[0].indicesPath.toString() + "/request_cache")
            Files.createDirectory(Path.of(path));
                    .setDiskCacheAlias("test1")  
    }
                .setValueSerializer(new BytesReferenceSerializer())  
                }
                        @Override  
                .setStatsTrackingEnabled(false)
                .setKeySerializer(new StringSerializer())
            String path = env.nodePaths()[0].path.toString() + "/request_cache";
            for (Map.Entry<ICacheKey<String>, String> entry : keyValueMap.entrySet()) {
                        .get(DISK_MAX_SIZE_IN_BYTES_KEY)
                        }
                snapshot = ehCacheDiskCachingTier.stats(levels).getStatsForDimensionValues(keyAdded.dimensions);  
                .setValueType(String.class)
            }  
                .setMaximumWeightInBytes(CACHE_SIZE_IN_BYTES)  
    public void testEhcacheParallelGets() throws Exception {
        @Override
            Settings settings = Settings.builder()
                .setValueType(String.class)  
                .build();  
                    try {
                    .setMaximumWeightInBytes(CACHE_SIZE_IN_BYTES)  
            )
                count += iCaches.get(i).count();
                    loadAwareCacheLoaderList.add(loadAwareCacheLoader);  
import org.opensearch.common.Randomness;
                .setKeyType(String.class)  
            for (int i = 0; i < randomKeys; i++) {
            for (ICacheKey<String> ehcacheKey : removedKeyList) {
                    .setWeigher(weigher)
            }
    }  
                assertEquals(new ImmutableCacheStats(0, 0, 0, 0, 0), ehcacheTest.stats().getTotalStats());  
                    .setValueSerializer(new StringSerializer())
 */  
    private static final int CACHE_SIZE_IN_BYTES = 1024 * 101;
                .setDimensionNames(List.of(dimensionName))
            ICache.Factory ehcacheFactory = new EhcacheDiskCache.EhcacheDiskCacheFactory();
                .setRemovalListener(removalListener)  
import org.opensearch.common.settings.Settings;  
                .setKeyType(String.class)
        Settings settings = Settings.builder().build();
                .setDimensionNames(List.of(dimensionName))
                byte[] compositeBytes1 = new byte[valueLength];  
            int numberOfRequest = randomIntBetween(200, 400);
            ICache<String, String> ehcacheTest = new EhcacheDiskCache.Builder<String, String>().setThreadPoolAlias(null)  
            }
                    .setMaximumWeightInBytes(CACHE_SIZE_IN_BYTES)
                // Verify that value is null for a removed entry.  
            Thread[] threads = new Thread[numberOfRequest];  
                .setWeigher(getWeigher())
            ehcacheTest.close();
                .setExpireAfterAccess(TimeValue.MAX_VALUE)
            for (int i = 0; i < randomKeys; i++) {
            ehcacheTest.close();  
        }
            assertNotNull(snapshot);
                });  
            // beforehand.
            ehcacheTest.close();
                .setExpireAfterAccess(TimeValue.MAX_VALUE)
                keyValueMap.put(getICacheKey(UUID.randomUUID().toString()), UUID.randomUUID().toString());
                () -> new EhcacheDiskCache.Builder<String, String>().setThreadPoolAlias("ehcacheTest")
                keyValueMap.put(UUID.randomUUID().toString(), UUID.randomUUID().toString());  
            int expectedNumberOfMisses = randomIntBetween(10, 200);  
            if (bytes == null) {
                    countDownLatch.countDown();
        int initialValueLength = 40;
                    countDownLatch.countDown();
                .setKeyType(String.class)  
    private ICacheKey<String> getICacheKey(String key) {  
                .setExpireAfterAccess(TimeValue.MAX_VALUE)
            ICache<String, String> ehcacheTest = new EhcacheDiskCache.Builder<String, String>().setStoragePath(
                CacheType.INDICES_REQUEST_CACHE,  
            for (Map.Entry<ICacheKey<String>, String> entry : keyValueMap.entrySet()) {
                .setStoragePath(env.nodePaths()[0].indicesPath.toString() + "/request_cache")  
                    .setValueType(String.class)
                .setStoragePath(env.nodePaths()[0].indicesPath.toString() + "/request_cache")
import java.util.List;
        Settings settings = Settings.builder().build();  
            totalSize += value.length();
                .setIsEventListenerModeSync(true)
        }  
        }
            int randomKeys = randomIntBetween(10, 100);  
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
            Phaser phaser = new Phaser(numberOfRequest + 1);
            ICache<String, String> ehcacheTest = new EhcacheDiskCache.Builder<String, String>().setDiskCacheAlias(generateRandomString(5))  
        try (NodeEnvironment env = newNodeEnvironment(settings)) {  
            ehCacheDiskCachingTier.close();
            }  
            }  
    }  
                            Settings.builder()  
                BytesReference composite = CompositeBytesReference.of(new BytesArray(compositeBytes1), new BytesArray(compositeBytes2));
            ehCacheDiskCachingTier.close();
            assertEquals(0, ehcacheTest.count());  
                .setSettings(settings)
            ICache<String, String> ehcacheTest = ehcacheFactory.create(
            for (int i = 0; i < randomKeys; i++) {  
        ToLongBiFunction<ICacheKey<String>, String> weigher = getWeigher();
            // Size consumed by key  
                                        .getKey(),
            assertThrows(
                .setDimensionNames(List.of(dimensionName))
                null
                    .setIsEventListenerModeSync(true)
            int numInitialKeys = randomIntBetween(10, 100);
            }
            for (Map.Entry<ICacheKey<String>, String> entry : keyValueMap.entrySet()) {
            int index = (int) (randomDouble() * characters.length());
                        public boolean isLoaded() {
        Settings settings = Settings.builder().build();
                .setKeySerializer(new StringSerializer())  
    }
                .setMaximumWeightInBytes(CACHE_SIZE_IN_BYTES)  
            int randomKeys = randomIntBetween(10, 100);
                .setKeySerializer(new StringSerializer())
                .setRemovalListener(new MockRemovalListener<>())
                        .setValueSerializer(new StringSerializer())  
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
            for (Map.Entry<ICacheKey<String>, String> entry : keyValueMap.entrySet()) {
                                .build()
                .build();
            // Verify that older data was wiped out after initialization
                    .setDiskCacheAlias("test1")  
        Settings settings = Settings.builder().build();  
            ehcacheTest.close();
    }
            countDownLatch.await();  
                    }  
@ThreadLeakFilters(filters = { EhcacheThreadLeakFilter.class })  
                .setKeySerializer(new StringSerializer())
    private ToLongBiFunction<ICacheKey<String>, String> getWeigher() {
            }
                    assertThrows(ExecutionException.class, () -> ehcacheTest.computeIfAbsent(getICacheKey(key), loadAwareCacheLoader));
                threads[j].start();
            long expectedSize = 0;  
                .setStoragePath(env.nodePaths()[0].indicesPath.toString() + "/request_cache")
                env.nodePaths()[0].indicesPath.toString() + "/request_cache"
            }  
    }  
            );
                            return isLoaded;  
            keyToDrop.setDropStatsForDimensions(true);
                .setRemovalListener(new MockRemovalListener<>())
        long maxSizeFromConfig = between(MINIMUM_MAX_SIZE_IN_BYTES + 3000, MINIMUM_MAX_SIZE_IN_BYTES + 4000);  
            assertEquals(keyValueMap.size(), ehcacheTest.count());  
                ehcacheTest.put(getICacheKey(entry.getKey()), entry.getValue());  
                totalSize += dim.length();  
                    phaser.arriveAndAwaitAdvance();  
            return cacheManager;  
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
            assertEquals(randomKeys, ehcacheTest.count());
                        @Override
            for (Map.Entry<ICacheKey<String>, String> entry : keyValueMap.entrySet()) {
    }
            ICache<String, String> ehcacheTest = new EhcacheDiskCache.Builder<String, String>().setDiskCacheAlias(generateRandomString(5))
                .build();
            if (putSizeInConfig) {
                    phaser.arriveAndAwaitAdvance();  
                .setWeigher((key, value) -> 1)  
        public void onRemoval(RemovalNotification<ICacheKey<K>, V> notification) {
            }
            int valueLength = 100;  
            countDownLatch.await(); // Wait for all threads to finish
                .setRemovalListener(removalListener)
            int randomKeys = randomIntBetween(10, 100);
            }  
                    .setValueSerializer(new StringSerializer())  
                .setSettings(settings)  
                threads[j].start();
                .setKeySerializer(new StringSerializer())
import org.opensearch.common.cache.RemovalListener;
                ehcacheTest.put(entry.getKey(), entry.getValue());  
                            isLoaded = true;
            for (int i = 0; i < randomKeys; i++) {
            }
            for (int i = 0; i < maxEntries - ehcacheTest.count(); i++) {  
            assertEquals(1, numberOfTimesValueLoaded);
import java.util.concurrent.CopyOnWriteArrayList;  
        MockRemovalListener<String, String> removalListener = new MockRemovalListener<>();
                .setIsEventListenerModeSync(true)
                .setRemovalListener(removalListener)
                ICacheKey<String> removedKey = initialKeys.get(i);
            ICache<String, String> ehCacheDiskCachingTier = new EhcacheDiskCache.Builder<String, String>().setDiskCacheAlias(
            String path = env.nodePaths()[0].path.toString() + "/request_cache";
                .setRemovalListener(removalListener)  
            );
        ToLongBiFunction<ICacheKey<String>, String> weigher = getWeigher();  
        }
import java.nio.file.Path;
            for (ICacheKey<String> keyAdded : keysAdded) {
                .setWeigher(getWeigher())
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
                .setCacheType(CacheType.INDICES_REQUEST_CACHE)
            // Since the EVICTED and EXPIRED cases use the same code as REMOVED, we should be ok on testing them for now.  
                ICache<String, String> ehcacheTest = iCaches.get(entry.getKey().hashCode() & (segments - 1));  
            ICache<String, String> ehcacheTest = new EhcacheDiskCache.Builder<String, String>().setStoragePath(
                .setCacheType(CacheType.INDICES_REQUEST_CACHE)
            }  
        Settings settings = Settings.builder().build();
                ICacheKey<String> iCacheKey = getICacheKey(UUID.randomUUID().toString());
                initialKeys.add(key);
        }
                .setValueSerializer(new StringSerializer())
                .setKeySerializer(new StringSerializer())
        public MockEhcahceDiskCache(Builder<String, String> builder) {
            // Test REMOVED case by removing all updated keys  
import static org.opensearch.cache.store.disk.EhcacheDiskCache.MINIMUM_MAX_SIZE_IN_BYTES;
                .setKeyType(String.class)
    }  
                .setKeySerializer(new StringSerializer())
                    .setCacheType(CacheType.INDICES_REQUEST_CACHE)
            // Try to hit different request with the same key concurrently. Verify value is only loaded once.
                () -> new EhcacheDiskCache.Builder<String, String>().setThreadPoolAlias("ehcacheTest")  
                    .setDimensionNames(List.of(dimensionName))
        }  
        ToLongBiFunction<ICacheKey<String>, String> weigher = getWeigher();
                    .setKeyType(String.class)  
                    .setStoragePath(null)
                        }  
    }  
                .setCacheType(CacheType.INDICES_REQUEST_CACHE)
                .setRemovalListener(listener)
                .setIsEventListenerModeSync(true)
                .setStoragePath(env.nodePaths()[0].indicesPath.toString() + "/request_cache")  
                if (randomBoolean()) {
            for (int i = 1; i <= segments; i++) {  
        }  
            assertThrows(
                .setWeigher(getWeigher())  
            assertEquals(expectedSize, ehcacheTest.stats().getTotalSizeInBytes());
            CountDownLatch countDownLatch = new CountDownLatch(randomKeys);
        ToLongBiFunction<ICacheKey<String>, String> weigher = getWeigher();
                .setValueType(BytesReference.class)  
        ToLongBiFunction<ICacheKey<String>, String> weigher = getWeigher();
        int segments = 4;  
                assertNull(ehcacheTest.get(entry.getKey()));
                            .build()  
                .setDimensionNames(List.of(dimensionName))
            List<ICacheKey<String>> removedKeyList = new ArrayList<>();
            Map<ICacheKey<String>, String> keyValueMap = new HashMap<>();
                generateRandomString(5)  
            assertEquals(660, ehcacheTest.stats().getTotalEvictions());
                .setKeyType(String.class)
                .setMaximumWeightInBytes(CACHE_SIZE_IN_BYTES)
                .setRemovalListener(new MockRemovalListener<>())
        }
                    };
                .setValueSerializer(new StringSerializer())
                assertEquals(new ImmutableCacheStats(0, 0, 0, 0, 0), ehcacheTest.stats().getTotalStats());
                .setKeyType(String.class)
            // Validate misses
            }  
                threads[j] = new Thread(() -> {
            for (int i = 0; i < numberOfRequest; i++) {
                assertEquals(new ImmutableCacheStats(0, 0, 0, 0, 0), ehcacheTest.stats().getTotalStats());  
            }
                .setDiskCacheAlias(diskCacheAlias)
                .setMaximumWeightInBytes(CACHE_SIZE_IN_BYTES)
                () -> new EhcacheDiskCache.Builder<String, String>().setThreadPoolAlias("ehcacheTest")
            }
            Phaser phaser = new Phaser(numberOfRequest + 1);
            assertFalse(Files.exists(Path.of(path))); // Verify everything is cleared up now after close()
            ehcacheTest.close();  
                            throw new RuntimeException("Exception");
        }
                .build();  
                    phaser.arriveAndAwaitAdvance();
                if (keyAdded.dimensions.equals(keyToDrop.dimensions)) {
                .setIsEventListenerModeSync(true)  
            }
                    .setDimensionNames(List.of(dimensionName))
                threads[i].start();
            countDownLatch.await();
                        .setWeigher(getWeigher())
                .setSettings(settings)
                ehcacheTest.put(getICacheKey(key), value);
            CountDownLatch countDownLatch = new CountDownLatch(randomKeys);  
            }  
                        .setKeySerializer(new StringSerializer())
                j++;
                    .build()
            String diskCacheAlias = generateRandomString(5);  
/*  
            ehcacheTest.close();  
        ToLongBiFunction<ICacheKey<String>, String> weigher = getWeigher();  
                    .setKeyType(String.class)
 *
                .setValueType(String.class)  
                .setValueType(String.class)  
                    EhcacheDiskCache.EhcacheDiskCacheFactory.EHCACHE_DISK_CACHE_NAME
                .setIsEventListenerModeSync(true)
            assertEquals(randomKeys, ehcacheTest.stats().getTotalItems());
                String value = ehcacheTest.get(entry.getKey());  
                    .setDimensionNames(List.of(dimensionName))
        public String deserialize(byte[] bytes) {
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
                        throw new RuntimeException(e);
                .setDiskCacheAlias(generateRandomString(5))  
                keysCount++;  
            Map<ICacheKey<String>, String> keyValueMap = new HashMap<>();
            for (Map.Entry<ICacheKey<String>, BytesReference> entry : keyValueMap.entrySet()) {
            phaser.arriveAndAwaitAdvance(); // Will trigger parallel puts above.
                .build();  
        MockRemovalListener<String, String> removalListener = new MockRemovalListener<>();
                .setDiskCacheAlias(generateRandomString(5))  
                }
        List<String> dimensionNames = List.of("dim1", "dim2");  
                .setKeyType(String.class)
            int j = 0;
                    .setExpireAfterAccess(TimeValue.MAX_VALUE)
                .setCacheType(CacheType.INDICES_REQUEST_CACHE)  
            }
        Settings settings = Settings.builder().build();
        throws Exception {
                .setDimensionNames(List.of(dimensionName))  
                    .build(),
                .setIsEventListenerModeSync(true)
                .setExpireAfterAccess(TimeValue.MAX_VALUE)
                Map.of()
                    .setExpireAfterAccess(TimeValue.MAX_VALUE)
                expectedSize += newLengthDifference;
                return null;  
                            return isLoaded;
            List<ICacheKey<String>> removedKeyList = new ArrayList<>();  
        for (String dimName : dimensionNames) {
                .setSettings(settings)
public class EhCacheDiskCacheTests extends OpenSearchSingleNodeTestCase {
        ToLongBiFunction<ICacheKey<String>, String> weigher = getWeigher();  
                CacheType.INDICES_REQUEST_CACHE,  
                .setKeySerializer(new StringSerializer())
                String key = "Key" + i;
            phaser.arriveAndAwaitAdvance();  
                .setExpireAfterAccess(TimeValue.MAX_VALUE)
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
                    }  
            ehCacheDiskCachingTier.invalidate(keyToDrop);
                .setStoragePath(env.nodePaths()[0].indicesPath.toString() + "/request_cache")  
import org.opensearch.core.common.bytes.CompositeBytesReference;
import org.opensearch.core.common.bytes.BytesReference;
                ehcacheTest.get(getICacheKey(UUID.randomUUID().toString()));
                        }  
            // Verify ehcache entry size again.
                        public String load(ICacheKey<String> key) throws Exception {  
            assertThrows(
    public void testComputeIfAbsentConcurrentlyWithMultipleEhcacheDiskCache() throws IOException {
                .setStoragePath(path)
                .setValueType(String.class)
        MockRemovalListener<String, String> removalListener = new MockRemovalListener<>();
        try (NodeEnvironment env = newNodeEnvironment(settings)) {  
            phaser.arriveAndAwaitAdvance(); // Will trigger parallel puts above.
            int randomKeys = randomIntBetween(100, 300);  
                .setStoragePath(env.nodePaths()[0].indicesPath.toString() + "/request_cache")
import static org.hamcrest.CoreMatchers.instanceOf;  
        MockRemovalListener<String, String> removalListener = new MockRemovalListener<>();
                assertEquals(expectedSize, ehcacheTest.stats().getTotalStats().getSizeInBytes());
            assertEquals(randomKeys, originalSize);
        @Override  
                expectedSize += weigher.applyAsLong(key, value);  
}  
            assertEquals(0, ((EhcacheDiskCache) ehcacheTest).getCompletableFutureMap().size());  
            for (int i = 0; i < segments; i++) {  
            for (int i = 0; i < randomKeys; i++) {
        public byte[] serialize(String object) {
                .setWeigher(weigher)  
        Settings settings = Settings.builder().build();
            }
                .setSettings(settings)
            }
        }
            String key = UUID.randomUUID().toString();
        @Override  
            for (Map.Entry<ICacheKey<String>, BytesReference> entry : keyValueMap.entrySet()) {
                env.nodePaths()[0].indicesPath.toString() + "/request_cache"
            assertEquals(randomKeys, ehcacheTest.stats().getTotalItems());
    }  
                        .getKey(),  
                    .setDimensionNames(List.of(dimensionName))
            // Test UPDATED case
            // Verify the removed key doesn't exist anymore.  
        List<String> result = new ArrayList<>();
                .setValueType(String.class)
                .setSettings(settings)  
        try (NodeEnvironment env = newNodeEnvironment(Settings.EMPTY)) {  
            assertEquals(keysCount, randomKeys);  
    public void testDiskCacheCloseAfterCleaningUpFilesManually() throws Exception {  
                .anyMatch(path1 -> path1.getFileName().toString().startsWith(diskCacheAlias));
                    .setSettings(
        Settings settings = Settings.builder().build();
        Settings settings = Settings.builder().build();
            ICache<String, String> ehcacheTest = new EhcacheDiskCache.Builder<String, String>().setDiskCacheAlias("test1")
            ICache<String, String> ehcacheTest = new EhcacheDiskCache.Builder<String, String>().setDiskCacheAlias(generateRandomString(5))
                keyValueMap.put(getICacheKey(UUID.randomUUID().toString()), UUID.randomUUID().toString());  
                .setStoragePath(env.nodePaths()[0].indicesPath.toString() + "/request_cache")
import org.opensearch.cache.EhcacheDiskCacheSettings;
                ehcacheTest.put(iCacheKey, UUID.randomUUID().toString());
                .setIsEventListenerModeSync(true) // For accurate count
                .setValueSerializer(new StringSerializer())
        Settings settings = Settings.builder().build();
            for (int i = 0; i < randomKeys; i++) {  
    static class MockEhcahceDiskCache extends EhcacheDiskCache<String, String> {  
                .setDimensionNames(List.of(dimensionName))
        }
        int initialKeyLength = 40;  
                    .setSettings(settings)
                keyValueMap.put(UUID.randomUUID().toString(), UUID.randomUUID().toString());  
                    };
                        )
                .setRemovalListener(removalListener)  
            Phaser phaser = new Phaser(randomKeys + 1);
            }
                .setExpireAfterAccess(TimeValue.MAX_VALUE)  
                .setValueSerializer(new StringSerializer())
                .setStatsTrackingEnabled(true);
                )
                .setExpireAfterAccess(TimeValue.MAX_VALUE)  
                .setKeySerializer(new StringSerializer())
                .setIsEventListenerModeSync(true) // Test fails if async; probably not all updates happen before checking stats  
    public void testComputeIfAbsentConcurrentlyAndThrowsException() throws Exception {
                ehcacheTest.put(key, value);  
                    .setMaximumWeightInBytes(0)  
                j++;
        }
                assertEquals(expectedSize, ehcacheTest.stats().getTotalStats().getSizeInBytes());
                .setWeigher(getWeigher())
    private List<String> getRandomDimensions(List<String> dimensionNames) {
                threads[j] = new Thread(() -> {
                String newValue = generateRandomString(initialValueLength + newLengthDifference);
            )
    public void testInvalidate() throws Exception {  
    }  
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
                .setCacheType(CacheType.INDICES_REQUEST_CACHE)
                    .setValueType(String.class)  
    @AwaitsFix(bugUrl = "Flaky test - fix before enabling")
                        @Override
                        }
            Map<ICacheKey<String>, String> keyValueMap = new HashMap<>();  
 * SPDX-License-Identifier: Apache-2.0
            for (int i = 0; i < numberOfRequest; i++) {
                threads[i] = new Thread(() -> {
                        }
            ehcacheTest.close();
                });  
            for (Map.Entry<String, String> entry : keyValueMap.entrySet()) {
                        public boolean isLoaded() {
                .setStoragePath(path)  
                                env.nodePaths()[0].indicesPath.toString() + "/request_cache"
                .setCacheType(CacheType.INDICES_REQUEST_CACHE)
                    .setWeigher(weigher)
            // Call it again. This will throw an exception.
                .setIsEventListenerModeSync(true)
            long originalSize = ehcacheTest.count();  
                        @Override
        int bound = 3;  
                .build();
                new CacheConfig.Builder<String, String>().setValueType(String.class)  
                .setValueType(String.class)  
package org.opensearch.cache.store.disk;
                        ehcacheTest.computeIfAbsent(getICacheKey(key), loadAwareCacheLoader);  
                rand.nextBytes(valueBytes);
            long expectedSize = 0;
                // .setThreadPoolAlias("ehcacheTest")  
                .setRemovalListener(removalListener)  
                .setExpireAfterAccess(TimeValue.MAX_VALUE)
        }  
                threads[i] = new Thread(() -> {  
                    .setStatsTrackingEnabled(false)
    // Modified from OpenSearchOnHeapCacheTests. Can't reuse, as we can't add a dependency on the server.test module.
        Settings settings = Settings.builder().build();  
                .build();
                    .setDimensionNames(List.of(dimensionName))
            Map<String, String> keyValueMap = new HashMap<>();
            for (int i = 0; i < randomKeys; i++) {  
                .setRemovalListener(new MockRemovalListener<>())
                .setStatsTrackingEnabled(false)
        MockRemovalListener<String, String> removalListener = new MockRemovalListener<>();
        for (int i = 0; i < length; i++) {  
                                    .get(DISK_LISTENER_MODE_SYNC_KEY)
        try (NodeEnvironment env = newNodeEnvironment(settings)) {  
                .setValueSerializer(new StringSerializer())
                assertEquals(0, ehcacheTest.count()); // Expect count storagePath 0 if NoopCacheStatsHolder is used  
            assertTrue(Files.exists(dummyFilePath));
        }  
import java.nio.charset.StandardCharsets;
            );
        }  
    public void testBasicGetAndPut() throws IOException {
            }  
    private EhcacheDiskCache<String, String> setupMaxSizeTest(long maxSizeFromSetting, long maxSizeFromConfig, boolean putSizeInConfig)  
                ICacheKey<String> iCacheKey = getICacheKey(entry.getKey());  
                .setValueSerializer(new StringSerializer())
        }  
    @AwaitsFix(bugUrl = "Flaky test - fix before enabling")
            Map<String, String> keyValueMap = new HashMap<>();
                                    EhcacheDiskCacheSettings.getSettingListForCacheType(CacheType.INDICES_REQUEST_CACHE)
        try (NodeEnvironment env = newNodeEnvironment(settings)) {  
                    .setKeySerializer(new StringSerializer())
            }  
            for (int i = 0; i < randomKeys; i++) {
    static class MockRemovalListener<K, V> implements RemovalListener<ICacheKey<K>, V> {  
            }
            }  
    }
            Thread[] threads = new Thread[randomKeys];
                .put(
                    .setSettings(settings)
            assertEquals(1, ehcacheTest.stats().getTotalItems());
    }  
                .setKeySerializer(new StringSerializer())
            for (String dim : iCacheKey.dimensions) {
            }  
                        .build(),  
        ToLongBiFunction<ICacheKey<String>, String> weigher = getWeigher();  
                .setKeySerializer(new StringSerializer())
import java.util.Map;  
        Settings settings = Settings.builder().build();  
                .setExpireAfterAccess(TimeValue.MAX_VALUE)  
                // Test a non-BytesArray implementation of BytesReference.
            Map<ICacheKey<String>, BytesReference> keyValueMap = new HashMap<>();
                .setKeyType(String.class)  
        Settings settings = Settings.builder().build();
            for (int i = 0; i < randomKeys; i++) {
import java.util.concurrent.Phaser;  
                .setDimensionNames(List.of(dimensionName))  
            // Create a dummy file to simulate a scenario where the data is already in the disk cache storage path  
                .setMaximumWeightInBytes(CACHE_SIZE_IN_BYTES * 20) // bigger so no evictions happen  
                ICacheKey<String> key = new ICacheKey<>(UUID.randomUUID().toString(), getRandomDimensions(dimensionNames));
    public void testBasicGetAndPutUsingFactory() throws IOException {
            )  
                            .put(  
            }
import org.opensearch.common.cache.serializer.Serializer;
                .setMaximumWeightInBytes(maxEntries * sizeForOneInitialEntry)
                .setWeigher(weigher)
        }
            ehcacheTest.close();  
                .setDimensionNames(List.of(dimensionName))
                .put(  
        long sizeForOneInitialEntry = weigher.applyAsLong(
                .setValueType(String.class)  
            String value = generateRandomString(100);  
                .setCacheType(CacheType.INDICES_REQUEST_CACHE)
                .setKeySerializer(new StringSerializer())  
                    .setWeigher(weigher)
        try (NodeEnvironment env = newNodeEnvironment(settings)) {  
                });  
                .setDimensionNames(List.of(dimensionName))
                .setCacheType(CacheType.INDICES_REQUEST_CACHE)  
                .setDimensionNames(List.of(dimensionName))
                            .put(  
                            isLoaded = true;
                assertNull(ehcacheTest.get(ehcacheKey));
                    loadAwareCacheLoaderList.add(loadAwareCacheLoader);  
                                    .getKey(),  
                    .setRemovalListener(removalListener)
            assertEquals(660, removalListener.evictionMetric.count());
        MockRemovalListener<String, String> removalListener = new MockRemovalListener<>();
                .setValueSerializer(new StringSerializer())
        }  
                .setExpireAfterAccess(TimeValue.MAX_VALUE)
            for (Map.Entry<String, String> entry : keyValueMap.entrySet()) {
                keyValueMap.put(UUID.randomUUID().toString(), UUID.randomUUID().toString());
        MockRemovalListener<String, String> removalListener = new MockRemovalListener<>();
        return result;
                String value = ehcacheTest.get(entry.getKey());
                    .setExpireAfterAccess(TimeValue.MAX_VALUE)
                String value = ehcacheTest.get(getICacheKey(entry.getKey()));
                .setSettings(settings)
                .setIsEventListenerModeSync(true)
                .setSettings(settings)
                iCaches.add(ehcacheTest);
            }  
