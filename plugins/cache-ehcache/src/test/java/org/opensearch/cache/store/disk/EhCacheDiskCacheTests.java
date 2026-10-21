                ICacheKey<String> key = new ICacheKey<>(UUID.randomUUID().toString(), getRandomDimensions(dimensionNames));
            Map<ICacheKey<String>, String> keyValueMap = new HashMap<>();
                keyValueMap.put(getICacheKey(UUID.randomUUID().toString()), UUID.randomUUID().toString());
                threads[j].start();
            generateRandomString(initialValueLength)
                    };
                .setIsEventListenerModeSync(true)
            new ICacheKey<>(generateRandomString(initialKeyLength), getMockDimensions()),
        }
            ehcacheTest.close();
            }
            countDownLatch.await(); // Wait for all threads to finish
            Thread[] threads = new Thread[randomKeys];
                ehcacheTest.put(getICacheKey(UUID.randomUUID().toString()), UUID.randomUUID().toString());
                env.nodePaths()[0].indicesPath.toString() + "/request_cache"
        }
            // Test UPDATED case
                assertEquals(new ImmutableCacheStats(0, 0, 0, 0, 0), ehcacheTest.stats().getTotalStats());
                expectedSize -= weigher.applyAsLong(removedKey, updatedValues.get(removedKey));
                        .setMaxSizeInBytes(CACHE_SIZE_IN_BYTES * 100)
            }
            // Since the EVICTED and EXPIRED cases use the same code as REMOVED, we should be ok on testing them for now.
                    .setKeySerializer(new StringSerializer())
        }
                .anyMatch(path1 -> path1.getFileName().toString().startsWith(diskCacheAlias));
import java.nio.file.Path;
                    EhcacheDiskCacheSettings.getSettingListForCacheType(CacheType.INDICES_REQUEST_CACHE)
                assertEquals(entry.getValue(), value);
            ehcacheTest.close();
                .setDiskCacheAlias(diskCacheAlias)
                .setValueType(BytesReference.class)
                    .build(),
                byte[] compositeBytes1 = new byte[valueLength];
                String value = generateRandomString(initialValueLength);
            for (int i = 0; i < randomKeys; i++) {
        assertEquals(maxSizeFromSetting, cache.getMaximumWeight());
import org.opensearch.common.cache.serializer.Serializer;
            int count = 0;
                    .setMaximumWeightInBytes(CACHE_SIZE_IN_BYTES)
                        throw new RuntimeException(e);
                .setRemovalListener(removalListener)
            ICache<String, String> ehcacheTest = new EhcacheDiskCache.Builder<String, String>().setThreadPoolAlias(null)
            assertNotNull(snapshot);
            );
                .setStatsTrackingEnabled(false)
import java.util.HashMap;
                .setSettings(settings)
            }
                        assertEquals(value, ehcacheTest.computeIfAbsent(getICacheKey(key), loadAwareCacheLoader));
                        }
    }
            ICache<String, String> ehcacheTest = new EhcacheDiskCache.Builder<String, String>().setDiskCacheAlias("test1")
                .setKeySerializer(new StringSerializer())
                .setWeigher(getWeigher())
            String value = generateRandomString(100);
                    assertEquals(entry.getValue(), ehcacheTest.get(getICacheKey(entry.getKey())));
import java.util.Random;
                ICacheKey<String> key = keys.next();
                () -> new EhcacheDiskCache.Builder<String, String>().setThreadPoolAlias("ehcacheTest")
                            throw new RuntimeException("Exception");
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
                .setRemovalListener(removalListener)
                byte[] compositeBytes2 = new byte[valueLength];
                .setDimensionNames(List.of(dimensionName))
                assertEquals(0, ehcacheTest.count()); // Expect count of 0 if NoopCacheStatsHolder is used
            for (int i = 0; i < randomKeys; i++) {
                    phaser.arriveAndAwaitAdvance();
            List<ICacheKey<String>> keysAdded = new ArrayList<>();
                .setMaximumWeightInBytes(CACHE_SIZE_IN_BYTES)
            }
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
    }
                )
                    .setIsEventListenerModeSync(true)
import org.opensearch.core.common.bytes.BytesReference;
            ehcacheTest.close();
                .setExpireAfterAccess(TimeValue.MAX_VALUE)
        return List.of("0");
        Settings settings = Settings.builder().build();
        try (NodeEnvironment env = newNodeEnvironment(Settings.EMPTY)) {
    private List<String> getMockDimensions() {
            int numberOfRequest = randomIntBetween(200, 400);
            for (int i = 0; i < numInitialKeys; i++) {
            }
    private ICacheKey<String> getICacheKey(String key) {
                .setValueSerializer(new StringSerializer())
            // Verify that there is data present under desired path by explicitly verifying the folder name by prefix
            ICache<String, String> ehcacheTest = new EhcacheDiskCache.Builder<String, String>().setDiskCacheAlias(generateRandomString(5))
                if (keyAdded.dimensions.equals(keyToDrop.dimensions)) {
                    .setKeyType(String.class)
                .setValueSerializer(new StringSerializer())
            for (int i = 0; i < numberOfRequest; i++) {
            for (int i = 0; i < segments; i++) {
                .setIsEventListenerModeSync(true)
    private List<String> getRandomDimensions(List<String> dimensionNames) {
        }
            // Try to hit different request with the same key concurrently. Verify value is only loaded once.
            }
            }
                CacheType.INDICES_REQUEST_CACHE,
                            .put(
                        boolean isLoaded;
            ehcacheTest.close();
            ICache<String, String> ehcacheTest = new EhcacheDiskCache.Builder<String, String>().setDiskCacheAlias(generateRandomString(5))
                    phaser.arriveAndAwaitAdvance();
        Settings settings = Settings.builder().build();
                assertEquals(new ImmutableCacheStats(0, 0, 0, 0, 0), ehcacheTest.stats().getTotalStats());
                .setWeigher(weigher)
    public void testComputeIfAbsentWithNullValueLoading() throws Exception {
            }
                ehcacheTest.put(getICacheKey(entry.getKey()), entry.getValue());
        );
            ICache<String, String> ehcacheTest = new EhcacheDiskCache.Builder<String, String>().setDiskCacheAlias(generateRandomString(5))
    }
                String value = ehcacheTest.get(entry.getKey());
                                env.nodePaths()[0].indicesPath.toString() + "/request_cache"
                .setSettings(settings)
                });
                .setValueType(String.class)
            int numberOfRequest = 2;// randomIntBetween(200, 400);
                .build();
                .setStoragePath(env.nodePaths()[0].indicesPath.toString() + "/request_cache")
                    loadAwareCacheLoaderList.add(loadAwareCacheLoader);
                .setRemovalListener(removalListener)
            if (putSizeInConfig) {
            String diskCacheAlias = generateRandomString(5);
            Phaser phaser = new Phaser(numberOfRequest + 1);
            Phaser phaser = new Phaser(randomKeys + 1);
                .setIsEventListenerModeSync(true)
                .setKeySerializer(new StringSerializer())
            );
            // Size consumed by value
                        .setKeyType(String.class)
                    .setStatsTrackingEnabled(false)
                    .setValueSerializer(new StringSerializer())
                threads[i].start();
            for (int i = 0; i < numInitialKeys * 0.5; i++) {
                IllegalArgumentException.class,
                ehcacheTest.get(getICacheKey(UUID.randomUUID().toString()));
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
            }
            // Validate misses
 * SPDX-License-Identifier: Apache-2.0
                    .setValueType(String.class)
                threads[j].start();
                .setDimensionNames(List.of(dimensionName))
                    .setExpireAfterAccess(TimeValue.MAX_VALUE)
            Settings settings = Settings.builder()
        ToLongBiFunction<ICacheKey<String>, String> weigher = getWeigher();
                    .setMaximumWeightInBytes(0)
                .setKeySerializer(new StringSerializer())
                .put(
                .setRemovalListener(removalListener)
                    removedKeyList.add(key);
                                    .getKey(),
            assertEquals(1, ehcacheTest.count());
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
            }
            for (int i = 0; i < expectedNumberOfMisses; i++) {
                    .build()
        }
            // Verify that older data was wiped out after initialization
                assertEquals(new ImmutableCacheStats(0, 0, 0, 0, 0), ehcacheTest.stats().getTotalStats());
            );
        cache.close();
                .setWeigher(getWeigher())
    }
            Map<String, String> keyValueMap = new HashMap<>();
                rand.nextBytes(valueBytes);
            }
@ThreadLeakFilters(filters = { EhcacheThreadLeakFilter.class })
            assertEquals(1, ehcacheTest.stats().getTotalMisses());
                    CacheSettings.getConcreteStoreNameSettingForCacheType(CacheType.INDICES_REQUEST_CACHE).getKey(),
                        @Override
                .setIsEventListenerModeSync(true)
        MockRemovalListener<String, String> removalListener = new MockRemovalListener<>();
                    ehcacheTest.put(entry.getKey(), entry.getValue());
                new CacheConfig.Builder<String, String>().setValueType(String.class)
            int randomKeys = randomIntBetween(2, 100);
                    .setWeigher(weigher)
                    try {
                            isLoaded = true;
            int randomKeys = randomIntBetween(10, 100);
                .setValueType(String.class)
        Settings settings = Settings.builder().build();
            assertThrows(
            String path = env.nodePaths()[0].path.toString() + "/request_cache";
        ToLongBiFunction<ICacheKey<String>, String> weigher = getWeigher();
    }
    public void testEvictions() throws Exception {
            while (keys.hasNext()) {
                .setKeySerializer(new StringSerializer())
            }
        ToLongBiFunction<ICacheKey<String>, String> weigher = getWeigher();
            randomString.append(characters.charAt(index));
        public boolean equals(String object, byte[] bytes) {
            assertEquals(keyValueMap.size(), ehcacheTest.count());
        }
        MockRemovalListener<String, String> removalListener = new MockRemovalListener<>();
    public void testConcurrentPut() throws Exception {
                                    .get(DISK_MAX_SIZE_IN_BYTES_KEY)
                .setValueSerializer(new StringSerializer())
                        public String load(ICacheKey<String> key) {
                .setSettings(settings)
        }
import org.opensearch.common.cache.serializer.BytesReferenceSerializer;
    }
import static org.hamcrest.CoreMatchers.instanceOf;
                assertEquals(entry.getValue(), value);
                    .setKeyType(String.class)
    public void testMemoryTracking() throws Exception {
            for (Map.Entry<ICacheKey<String>, String> entry : keyValueMap.entrySet()) {
                ICacheKey<String> iCacheKey = getICacheKey(UUID.randomUUID().toString());
                    removedKeyList.add(entry.getKey());
                .setValueSerializer(new StringSerializer())
                ehcacheTest.invalidate(removedKey);
            // Verify the removed key doesn't exist anymore.
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
                }
                keysAdded.add(key);
                    iterator.remove();
                    .setKeySerializer(new StringSerializer())
            }
                            .build()
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
            for (int i = 0; i < randomKeys; i++) {
        Settings settings = Settings.builder().build();
            }
            for (String dim : iCacheKey.dimensions) {
            for (int i = 0; i < numInitialKeys * 0.5; i++) {
                .setDiskCacheAlias(generateRandomString(5))
                    .setSettings(settings)
                j++;
                byte[] valueBytes = new byte[valueLength];
                    .setRemovalListener(removalListener)
            }
                .setCacheType(CacheType.INDICES_REQUEST_CACHE)
                }
    static class MockEhcahceDiskCache extends EhcacheDiskCache<String, String> {
            int randomKeys = randomIntBetween(10, 100);
        return result;
import org.opensearch.common.unit.TimeValue;
                threads[i] = new Thread(() -> {
            ICache<String, String> ehcacheTest = new EhcacheDiskCache.Builder<String, String>().setThreadPoolAlias(null)
    public void testInvalidate() throws Exception {
                .setMaximumWeightInBytes(CACHE_SIZE_IN_BYTES)
            )
                .setKeyType(String.class)
    private static final int CACHE_SIZE_IN_BYTES = 1024 * 101;
import org.opensearch.core.common.bytes.BytesArray;
            Path dummyFilePath = Files.createFile(Path.of(path + "/testing.txt"));
                .setValueType(String.class)
                            return value;
            ehcacheTest.invalidateAll(); // clear all the entries.
                ICacheKey<String> iCacheKey = getICacheKey(entry.getKey());
                .setSettings(settings)
                .put(
                        .setCacheAlias("ehcache_disk#" + i)
                j++;
                .setCacheType(CacheType.INDICES_REQUEST_CACHE)
            ehcacheTest.close();
            String path = env.nodePaths()[0].path.toString() + "/request_cache";
            // Call it again. This will throw an exception.
                .filter(Files::isDirectory)
            String path = env.nodePaths()[0].path.toString() + "/request_cache";
            for (int i = 0; i < randomKeys; i++) {
            }
    }
            for (Map.Entry<String, String> entry : keyValueMap.entrySet()) {
                assertEquals(0, ehcacheTest.count()); // Expect count storagePath 0 if NoopCacheStatsHolder is used
                ehcacheTest.put(iCacheKey, UUID.randomUUID().toString());
                    .setKeyType(String.class)
                        .setDimensionNames(List.of(dimensionName))
                .setCacheType(CacheType.INDICES_REQUEST_CACHE)
                .setValueSerializer(new StringSerializer())
                .setRemovalListener(new MockRemovalListener<>())
                    .build()
                .setCacheType(CacheType.INDICES_REQUEST_CACHE)
                    EhcacheDiskCacheSettings.getSettingListForCacheType(CacheType.INDICES_REQUEST_CACHE)
                ehcacheTest.put(getICacheKey(key), value);
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
        }
            ICache.Factory ehcacheFactory = new EhcacheDiskCache.EhcacheDiskCacheFactory();
            for (Map.Entry<String, String> entry : keyValueMap.entrySet()) {
            ehcacheTest.close();
        }
                return null;
                .setStoragePath(env.nodePaths()[0].indicesPath.toString() + "/request_cache")
    }
                snapshot = ehCacheDiskCachingTier.stats(levels).getStatsForDimensionValues(keyAdded.dimensions);
            countDownLatch.await();
                assertEquals(0, ehcacheTest.count()); // Expect count of 0 if NoopCacheStatsHolder is used
            assertEquals(0, ((EhcacheDiskCache) ehcacheTest).getCompletableFutureMap().size());
            for (ICacheKey<String> ehcacheKey : removedKeyList) {
            for (int i = 0; i < randomKeys; i++) {
                ehcacheTest.put(iCacheKey, entry.getValue());
    public void testInvalidateAll() throws Exception {
                                    EhcacheDiskCacheSettings.getSettingListForCacheType(CacheType.INDICES_REQUEST_CACHE)
            ehCacheDiskCachingTier.close();
            assertEquals(0, ((EhcacheDiskCache) ehcacheTest).getCompletableFutureMap().size());
            if (bytes == null) {
            }
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
                .setSettings(settings)
                keyValueMap.put(UUID.randomUUID().toString(), UUID.randomUUID().toString());
            assertEquals(expectedSize, ehcacheTest.stats().getTotalSizeInBytes());
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
            }
            assertEquals(660, removalListener.evictionMetric.count());
        ToLongBiFunction<ICacheKey<String>, String> weigher = getWeigher();
            for (int i = 0; i < numberOfRequest; i++) {
            assertEquals(keyValueMap.size(), ehcacheTest.count());
 * The OpenSearch Contributors require contributions made to
            assertFalse(Files.exists(dummyFilePath));
            int randomKeys = randomIntBetween(10, 100);
                keyValueMap.put(getICacheKey(UUID.randomUUID().toString()), UUID.randomUUID().toString());
            }
            }
                .setMaximumWeightInBytes(CACHE_SIZE_IN_BYTES)
                    ehcacheTest.invalidate(entry.getKey());
            phaser.arriveAndAwaitAdvance(); // Will trigger parallel puts above.
                assertEquals(entry.getValue(), value);
import org.opensearch.common.cache.ICache;
                    .setStoragePath(null)
            ehcacheTest.close();
            long expectedSize = 0;
        }
            }
                                    EhcacheDiskCacheSettings.getSettingListForCacheType(CacheType.INDICES_REQUEST_CACHE)
                .setMaximumWeightInBytes(CACHE_SIZE_IN_BYTES * 20) // bigger so no evictions happen
                                        .getKey(),
        long maxSizeFromSetting = between(MINIMUM_MAX_SIZE_IN_BYTES + 1000, MINIMUM_MAX_SIZE_IN_BYTES + 2000);
            for (Map.Entry<ICacheKey<String>, BytesReference> entry : keyValueMap.entrySet()) {
        for (int i = 0; i < length; i++) {
                ehCacheDiskCachingTier.put(key, UUID.randomUUID().toString());
                .setExpireAfterAccess(TimeValue.MAX_VALUE)
            String key = UUID.randomUUID().toString();
            CountDownLatch countDownLatch = new CountDownLatch(numberOfRequest);
                .setValueType(String.class)
                .setKeySerializer(new StringSerializer())
            }
        private final Charset charset = StandardCharsets.UTF_8;
                    .setWeigher(getWeigher())
                        .get(DISK_STORAGE_PATH_KEY)
    public void testComputeIfAbsentConcurrentlyAndThrowsException() throws Exception {
                .setRemovalListener(removalListener)
                .setDimensionNames(List.of(dimensionName))
                ICacheKey<String> iCacheKey = getICacheKey(UUID.randomUUID().toString());
                .setSettings(settings)
                .setKeyType(String.class)
            for (Map.Entry<ICacheKey<String>, String> entry : keyValueMap.entrySet()) {
            }
                keyValueMap.put(UUID.randomUUID().toString(), UUID.randomUUID().toString());
                    .setSettings(settings)
                        .setKeySerializer(new StringSerializer())
                keyValueMap.put(getICacheKey(UUID.randomUUID().toString()), UUID.randomUUID().toString());
                .put(
                env.nodePaths()[0].indicesPath.toString() + "/request_cache"
import java.nio.charset.StandardCharsets;
                    }
                .setValueSerializer(new StringSerializer())
        return randomString.toString();
                .setCacheType(CacheType.INDICES_REQUEST_CACHE)
            ICache.Factory ehcacheFactory = new EhcacheDiskCache.EhcacheDiskCacheFactory();
            ICacheKey<String> keyToDrop = keysAdded.get(0);
            for (int i = 0; i < randomKeys; i++) {
            assertEquals(keyValueMap.size() - removedKeyList.size(), ehcacheTest.count());
                    .setValueType(String.class)
        long maxSizeFromConfig = between(MINIMUM_MAX_SIZE_IN_BYTES + 3000, MINIMUM_MAX_SIZE_IN_BYTES + 4000);
                    try {
            ehcacheTest.close();
        }
    public void testDiskCacheCloseAfterCleaningUpFilesManually() throws Exception {
            for (Map.Entry<String, String> entry : keyValueMap.entrySet()) {
            ArrayList<ICacheKey<String>> initialKeys = new ArrayList<>();
                .setExpireAfterAccess(TimeValue.MAX_VALUE)
                if (randomBoolean()) {
                }
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
            int expectedNumberOfMisses = randomIntBetween(10, 200);
                } else {
                    .setKeyType(String.class)
    }
        }
            ICache.Factory cacheFactory = new EhcacheDiskCache.EhcacheDiskCacheFactory();
            for (int i = 0; i < expectedNumberOfMisses; i++) {
            ICache<String, String> ehcacheTest = new EhcacheDiskCache.Builder<String, String>().setStoragePath(path)
                                EhcacheDiskCacheSettings.getSettingListForCacheType(CacheType.INDICES_REQUEST_CACHE)
                CacheType.INDICES_REQUEST_CACHE,
            );
                        @Override
                .setKeyType(String.class)
                    };
        Settings settings = Settings.builder().build();
            int randomKeys = randomIntBetween(10, 100);
                ehcacheTest.put(entry.getKey(), entry.getValue());
import org.ehcache.PersistentCacheManager;
                .setIsEventListenerModeSync(true)
                        }
                    Map.of()
    }
            int randomKeys = randomIntBetween(100, 300);
            Phaser phaser = new Phaser(numberOfRequest + 1);
                    .setCacheType(CacheType.INDICES_REQUEST_CACHE)
                .setDiskCacheAlias(generateRandomString(5))
            List<ICacheKey<String>> removedKeyList = new ArrayList<>();
        MockRemovalListener<String, String> removalListener = new MockRemovalListener<>();
                        }
            )
            // Now try removing subset of keys and verify
                .setDimensionNames(List.of(dimensionName))
            int randomKeys = randomIntBetween(2, 100);
            ehcacheTest.close();
import static org.opensearch.cache.EhcacheDiskCacheSettings.DISK_MAX_SIZE_IN_BYTES_KEY;
            for (ICacheKey<String> keyAdded : keysAdded) {
                .setMaximumWeightInBytes(CACHE_SIZE_IN_BYTES * 20) // bigger so no evictions happen
                .setDimensionNames(List.of(dimensionName))
                .setWeigher(getWeigher())
                () -> new EhcacheDiskCache.Builder<String, String>().setThreadPoolAlias("ehcacheTest")
            }
                .setDimensionNames(List.of(dimensionName))
                ICache<String, String> ehcacheTest = iCaches.get(entry.getKey().hashCode() & (segments - 1));
                String newValue = generateRandomString(initialValueLength + newLengthDifference);
    private static String generateRandomString(int length) {
                .setValueType(String.class)
    }
            assertEquals(randomKeys, ehcacheTest.count());
        }
                    .setExpireAfterAccess(TimeValue.MAX_VALUE)
            Random rand = Randomness.get();
                ehcacheTest.put(iCacheKey, UUID.randomUUID().toString());
                .setDimensionNames(List.of(dimensionName))
/*
            assertFalse(Files.exists(Path.of(path))); // Verify everything is cleared up now after close()
            String key = UUID.randomUUID().toString();
                                        .getKey(),
    }
    public void testInvalidateWithDropDimensions() throws Exception {
                .setValueType(String.class)
                .setKeySerializer(new StringSerializer())
            for (int i = 0; i < randomKeys; i++) {
                    countDownLatch.countDown();
                .setKeyType(String.class)
                .setMaximumWeightInBytes(CACHE_SIZE_IN_BYTES)
                .setValueSerializer(new BytesReferenceSerializer())
        Random rand = Randomness.get();
                .setSettings(settings)
        }
                .setValueType(String.class)
                .setStatsTrackingEnabled(false)
            ehcacheTest.close();
                .setWeigher(weigher)
                    env.nodePaths()[0].indicesPath.toString() + "/request_cache/"
                IllegalArgumentException.class,
                                EhcacheDiskCacheSettings.getSettingListForCacheType(CacheType.INDICES_REQUEST_CACHE)
        int initialKeyLength = 40;
            assertEquals(numberOfRequest - 1, ehcacheTest.stats().getTotalHits());
            long totalSize = iCacheKey.key.length();
                                    .getKey(),
                cacheConfigBuilder.build(),
        }
import org.opensearch.common.cache.settings.CacheSettings;
            for (Map.Entry<ICacheKey<String>, String> entry : keyValueMap.entrySet()) {
 */
            for (Map.Entry<ICacheKey<String>, String> entry : keyValueMap.entrySet()) {
            assertEquals(0, ehcacheTest.count());
        }
                keysCount++;
            long expectedSize = 0;
            }
                .setIsEventListenerModeSync(true)
        Settings settings = Settings.builder().build();
                .setDimensionNames(List.of(dimensionName))
                iCaches.add(ehcacheTest);
        MockRemovalListener<String, String> listener = new MockRemovalListener<>();
                assertEquals(expectedSize, ehcacheTest.stats().getTotalStats().getSizeInBytes());
    public void testEhcacheWithStorageSizeLowerThanMinimumExpected() throws Exception {
                .setCacheType(CacheType.INDICES_REQUEST_CACHE)
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
        MockRemovalListener<String, String> removalListener = new MockRemovalListener<>();
        Settings settings = Settings.builder().build();
                int newLengthDifference = randomIntBetween(-20, 20);
                initialKeys.add(key);
            assertThrows(
            assertEquals(originalSize - removedKeyList.size(), ehcacheTest.count());
                .setValueType(String.class)
 * this file be licensed under the Apache-2.0 license or a
                expectedSize += weigher.applyAsLong(key, value);
            }
                .build();
            for (Map.Entry<ICacheKey<String>, String> entry : keyValueMap.entrySet()) {
                totalSize += dim.length();
                .setValueSerializer(new StringSerializer())
                .setWeigher(weigher)
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
                if (randomBoolean()) {
    public void testEhcacheKeyIteratorWithRemove() throws IOException {
            }
                .setMaximumWeightInBytes(CACHE_SIZE_IN_BYTES)
    }
                            isLoaded = true;
        MockRemovalListener<String, String> removalListener = new MockRemovalListener<>();
                    .setKeySerializer(new StringSerializer())
                .setStoragePath(env.nodePaths()[0].indicesPath.toString() + "/request_cache")
                // Test a non-BytesArray implementation of BytesReference.
                String value = ehcacheTest.get(entry.getKey());
                assertEquals(0, ehcacheTest.count()); // Expect count storagePath 0 if NoopCacheStatsHolder is used
                updatedValues.put(initialKeys.get(i), newValue);
                threads[i].start();
            assertEquals(randomKeys, ehcacheTest.count());
                .setSettings(settings)
            for (int i = 0; i < 20; i++) {
            }
                .setKeyType(String.class)
                            )
            return (EhcacheDiskCache<String, String>) cacheFactory.create(
            }
            }
                                        .get(DISK_LISTENER_MODE_SYNC_KEY)
            phaser.arriveAndAwaitAdvance();
                });
            }
                        assertThat(ex.getCause(), instanceOf(NullPointerException.class));
    public void testEhcacheWithStorageSizeZero() throws Exception {
                .setValueSerializer(new StringSerializer())
                ehcacheTest.put(entry.getKey(), entry.getValue());
            for (Map.Entry<ICacheKey<String>, BytesReference> entry : keyValueMap.entrySet()) {
                });
            // TODO: Ehcache incorrectly evicts at 30-40% of max size. Fix this test once we figure out why.
                .setStoragePath(env.nodePaths()[0].indicesPath.toString() + "/request_cache")
            Files.createDirectory(Path.of(path));
                }
                        .getKey(),
                    LoadAwareCacheLoader<ICacheKey<String>, String> loadAwareCacheLoader = new LoadAwareCacheLoader<>() {
import java.util.UUID;
    private ToLongBiFunction<ICacheKey<String>, String> getWeigher() {
                .setRemovalListener(removalListener)
                .setValueSerializer(new StringSerializer())
                ehcacheTest.put(getICacheKey(entry.getKey()), entry.getValue());
            // (used from disk cache alias)
                .setDimensionNames(List.of(dimensionName))
            // Try to hit different request with the same key concurrently. Loader throws exception.
                                .build()
        List<String> result = new ArrayList<>();
                () -> new EhcacheDiskCache.Builder<String, String>().setThreadPoolAlias("ehcacheTest")
        MockRemovalListener<String, String> removalListener = new MockRemovalListener<>();
            CountDownLatch countDownLatch = new CountDownLatch(numberOfRequest);
                                .put(
            }
                .setIsEventListenerModeSync(true) // For accurate count
            CacheConfig.Builder<String, String> cacheConfigBuilder = new CacheConfig.Builder<String, String>().setKeyType(String.class)
            assertThrows(
            );
                .setRemovalListener(removalListener)
                .setDimensionNames(List.of(dimensionName))
            countDownLatch.await();
                    .setRemovalListener(removalListener)
                .setStoragePath(env.nodePaths()[0].indicesPath.toString() + "/request_cache")
            assertFalse(Files.exists(Path.of(path))); // Verify everything is cleared up now after close()
                .setCacheType(CacheType.INDICES_REQUEST_CACHE)
        Settings settings = Settings.builder().build();
            super(builder);
import org.opensearch.common.Randomness;
                .setKeySerializer(new StringSerializer())
                .build();
            for (int i = 0; i < randomKeys; i++) {
import org.opensearch.core.common.bytes.CompositeBytesReference;
                    .setCacheType(CacheType.INDICES_REQUEST_CACHE)
        }
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
        MockRemovalListener<String, String> removalListener = new MockRemovalListener<>();
                ICacheKey<String> removedKey = initialKeys.get(i);
                Map.of()
    public void testComputeIfAbsentConcurrently() throws Exception {
        StringBuilder randomString = new StringBuilder(length);
            int randomKeys = randomIntBetween(10, 100);
            int keysCount = 0;
                .setStatsTrackingEnabled(true);
                    .setValueSerializer(new StringSerializer())
            assertTrue(Files.exists(dummyFilePath));
                .setDimensionNames(List.of(dimensionName))
                assertNotNull(ehcacheTest.get(key));
            int valueLength = 100;
            ICache<String, String> ehCacheDiskCachingTier = new EhcacheDiskCache.Builder<String, String>().setDiskCacheAlias(
        }
                .setDimensionNames(dimensionNames)
                        .build(),
import java.util.function.ToLongBiFunction;
        assertEquals(maxSizeFromConfig, cache.getMaximumWeight());
                .setExpireAfterAccess(TimeValue.MAX_VALUE)
                .setDiskCacheAlias(generateRandomString(5))
                                    .getKey(),
                .setRemovalListener(removalListener)
import org.opensearch.cache.EhcacheDiskCacheSettings;
                    countDownLatch.countDown();
                    .setDiskCacheAlias("test1")
                )
                    phaser.arriveAndAwaitAdvance();
                                        .get(DISK_STORAGE_PATH_KEY)
                        @Override
    }
            for (int i = 1; i <= segments; i++) {
            List<ICacheKey<String>> removedKeyList = new ArrayList<>();
                .build();
                .setSettings(settings)
                .setCacheType(CacheType.INDICES_REQUEST_CACHE)
            for (Iterator<ICacheKey<String>> iterator = ehcacheTest.keys().iterator(); iterator.hasNext();) {
    public void testDiskCacheCloseCalledTwiceAndVerifyDiskDataIsCleanedUp() throws Exception {
            // Trying to generate more than 100kb to cause evictions.
                                .put(
        Settings settings = Settings.builder().build();
        List<String> dimensionNames = List.of("dim1", "dim2");
                .setDimensionNames(List.of(dimensionName))
            assertEquals(randomKeys, originalSize);
            assertEquals(660, ehcacheTest.stats().getTotalEvictions());
        }
                .setKeyType(String.class)
                .setExpireAfterAccess(TimeValue.MAX_VALUE)
                .setStoragePath(env.nodePaths()[0].indicesPath.toString() + "/request_cache")
        MockRemovalListener<String, String> removalListener = new MockRemovalListener<>();
                ehcacheTest.put(key, value);
                    .setStatsTrackingEnabled(false)
            for (Map.Entry<String, String> entry : keyValueMap.entrySet()) {
        MockRemovalListener<String, String> removalListener = new MockRemovalListener<>();
                // .setThreadPoolAlias("ehcacheTest")
                    .setValueSerializer(new StringSerializer())
                    .setDiskCacheAlias("test1")
                String value = ehcacheTest.get(entry.getKey());
                        .get(DISK_MAX_SIZE_IN_BYTES_KEY)
            for (Map.Entry<ICacheKey<String>, String> entry : keyValueMap.entrySet()) {
                .setRemovalListener(removalListener)
                    phaser.arriveAndAwaitAdvance();
                .setStoragePath(env.nodePaths()[0].indicesPath.toString() + "/request_cache")
            for (int i = 0; i < randomKeys; i++) {
                    .setStatsTrackingEnabled(false)
            }
                    .setDimensionNames(List.of(dimensionName))
                keyValueMap.put(getICacheKey(UUID.randomUUID().toString()), UUID.randomUUID().toString());
                .setSettings(settings)
        MockRemovalListener<String, String> removalListener = new MockRemovalListener<>();
            String key = UUID.randomUUID().toString();
            )
            Iterator<ICacheKey<String>> keys = ehcacheTest.keys().iterator();
                .setValueSerializer(new StringSerializer())
            phaser.arriveAndAwaitAdvance(); // Will trigger parallel puts above.
            ehcacheTest.close();
                    new CacheConfig.Builder<String, String>().setValueType(String.class)
                .setIsEventListenerModeSync(true) // Test fails if async; probably not all updates happen before checking stats
            // Try to hit different request with the same key concurrently. Loader throws exception.
                .build();
            countDownLatch.await(); // Wait for all threads to finish
                .setKeySerializer(new StringSerializer())
import java.util.List;
            Phaser phaser = new Phaser(randomKeys + 1);
        }
        }
            // Validate misses
            ehcacheTest.close();
import java.nio.file.Files;
                    .setCacheType(CacheType.INDICES_REQUEST_CACHE)
                                        .getKey(),
            }
                .setIsEventListenerModeSync(true)
        MockRemovalListener<String, String> removalListener = new MockRemovalListener<>();
            totalSize += 10; // The ICacheKeySerializer writes 2 VInts to record array lengths, which can be 1-5 bytes each
            for (int i = 0; i < randomKeys; i++) {
        MockRemovalListener<String, String> removalListener = new MockRemovalListener<>();
                        public boolean isLoaded() {
                .setCacheType(CacheType.INDICES_REQUEST_CACHE)
    }
            int randomKeys = randomIntBetween(10, 100);
        MockRemovalListener<String, String> removalListener = new MockRemovalListener<>();
                .setStatsTrackingEnabled(false)
                    assertNull(snapshot);
                .setWeigher(getWeigher())
                .setExpireAfterAccess(TimeValue.MAX_VALUE)
                    maxSizeFromSetting
import org.opensearch.test.OpenSearchSingleNodeTestCase;
            List<LoadAwareCacheLoader<ICacheKey<String>, String>> loadAwareCacheLoaderList = new CopyOnWriteArrayList<>();
            IOUtils.rm(Path.of(path));
                    .setWeigher(weigher)
                .setKeyType(String.class)
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
            }
import static org.opensearch.cache.store.disk.EhcacheDiskCache.MINIMUM_MAX_SIZE_IN_BYTES;
                        @Override
import java.util.concurrent.ExecutionException;
            int numberOfTimesValueLoaded = 0;
            for (Map.Entry<ICacheKey<String>, String> entry : keyValueMap.entrySet()) {
            assertEquals(randomKeys, ehcacheTest.stats().getTotalHits());
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
                    } catch (Exception ex) {
            Map<ICacheKey<String>, String> keyValueMap = new HashMap<>();
        Settings settings = Settings.builder().build();
                .setSettings(settings)
        public void onRemoval(RemovalNotification<ICacheKey<K>, V> notification) {
                                )
                .setValueType(String.class)
            ICache<String, String> ehcacheTest = new EhcacheDiskCache.Builder<String, String>().setDiskCacheAlias(generateRandomString(5))
import org.opensearch.common.cache.stats.ImmutableCacheStats;
import java.util.ArrayList;
                env.nodePaths()[0].indicesPath.toString() + "/request_cache"
                .setKeyType(String.class)
            ICache<String, String> ehcacheTest = new EhcacheDiskCache.Builder<String, String>().setStoragePath(
                .setRemovalListener(new MockRemovalListener<>())
            for (int i = 0; i < randomKeys; i++) {
                .setRemovalListener(new MockRemovalListener<>())
import java.util.concurrent.CountDownLatch;
                .setValueSerializer(new StringSerializer())
                .setMaximumWeightInBytes(CACHE_SIZE_IN_BYTES)
            CountDownLatch countDownLatch = new CountDownLatch(randomKeys);
                });
            assertEquals(0, ((EhcacheDiskCache) ehcacheTest).getCompletableFutureMap().size());
                .setWeigher(weigher)
                .setRemovalListener(new MockRemovalListener<>())
        return (iCacheKey, value) -> {
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
                .setValueType(String.class)
                .setSettings(settings)
        }
                        boolean isLoaded;
                .setMaximumWeightInBytes(CACHE_SIZE_IN_BYTES)
            HashMap<ICacheKey<String>, String> updatedValues = new HashMap<>();
                threads[j] = new Thread(() -> {
        }
                    .setRemovalListener(removalListener)
                    countDownLatch.countDown();
                .setStoragePath(path)
                .setKeySerializer(new StringSerializer())
                .build();
                .setStoragePath(path)
            ICache<String, String> ehcacheTest = new EhcacheDiskCache.Builder<String, String>().setStoragePath(
                    .setValueType(String.class)
            countDownLatch.await();
            // assertEquals(maxEntries * sizeForOneInitialEntry, ehcacheTest.stats().getTotalMemorySize());
        int bound = 3;
        int maxEntries = 2000;
            return cacheManager;
                    EhcacheDiskCache.EhcacheDiskCacheFactory.EHCACHE_DISK_CACHE_NAME
                        @Override
        ToLongBiFunction<ICacheKey<String>, String> weigher = getWeigher();
        Settings settings = Settings.builder().build();
                        Settings.builder()
            // beforehand.
                .build();
                    LoadAwareCacheLoader<ICacheKey<String>, String> loadAwareCacheLoader = new LoadAwareCacheLoader<>() {
            Thread[] threads = new Thread[numberOfRequest];
    }
                .setMaximumWeightInBytes(CACHE_SIZE_IN_BYTES)
                .setExpireAfterAccess(TimeValue.MAX_VALUE)
                .setDimensionNames(List.of(dimensionName))
            assertTrue(Files.exists(Path.of(path)));
        Settings settings = Settings.builder().build();
                ehcacheTest.put(entry.getKey(), entry.getValue());
        PersistentCacheManager buildCacheManager() {
                keyValueMap.put(UUID.randomUUID().toString(), UUID.randomUUID().toString());
        return new ICacheKey<>(key, getMockDimensions());
                .setWeigher(getWeigher())
                        .setSettings(
                    .setIsEventListenerModeSync(true)
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
import org.opensearch.env.NodeEnvironment;
                .setMaximumWeightInBytes(CACHE_SIZE_IN_BYTES)
            assertEquals(randomKeys, ehcacheTest.stats().getTotalHits());
                    .setCacheType(CacheType.INDICES_REQUEST_CACHE)
            Thread[] threads = new Thread[numberOfRequest];
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
            }
        cache = setupMaxSizeTest(maxSizeFromSetting, maxSizeFromConfig, true);
            assertEquals(randomKeys, ehcacheTest.count());
                    assertThrows(ExecutionException.class, () -> ehcacheTest.computeIfAbsent(getICacheKey(key), loadAwareCacheLoader));
            for (Map.Entry<ICacheKey<String>, String> entry : keyValueMap.entrySet()) {
            int randomKeys = randomIntBetween(20, 100);
        MockRemovalListener<String, String> removalListener = new MockRemovalListener<>();
            Map<String, String> keyValueMap = new HashMap<>();
                threads[j] = new Thread(() -> {
            );
    private EhcacheDiskCache<String, String> setupMaxSizeTest(long maxSizeFromSetting, long maxSizeFromConfig, boolean putSizeInConfig)
                                    .get(DISK_LISTENER_MODE_SYNC_KEY)
                if (loadAwareCacheLoaderList.get(i).isLoaded()) {
                .setSettings(settings)
            Thread[] threads = new Thread[numberOfRequest];
            }
        Settings settings = Settings.builder().build();
            keyToDrop.setDropStatsForDimensions(true);
                .setExpireAfterAccess(TimeValue.MAX_VALUE)
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
                rand.nextBytes(compositeBytes1);
        int segments = 4;
            result.add(String.valueOf(rand.nextInt(bound)));
                .setStoragePath(env.nodePaths()[0].indicesPath.toString() + "/request_cache")
            assertEquals(keysCount, randomKeys);
    }
                .setKeyType(String.class)
                .setExpireAfterAccess(TimeValue.MAX_VALUE)
                ICache<String, String> ehcacheTest = iCaches.get(entry.getKey().hashCode() & (segments - 1));
                        ehcacheTest.computeIfAbsent(getICacheKey(key), loadAwareCacheLoader);
                    .setMaximumWeightInBytes(MINIMUM_MAX_SIZE_IN_BYTES)
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
            assertEquals(randomKeys, count);
                .setValueSerializer(new StringSerializer())
            ehCacheDiskCachingTier.invalidate(keyToDrop);
                .setIsEventListenerModeSync(true)
                    .setSettings(settings)
import java.util.concurrent.CopyOnWriteArrayList;
    }
    public void testComputeIfAbsentConcurrentlyWithMultipleEhcacheDiskCache() throws IOException {
            }
        public byte[] serialize(String object) {
            }
                    .setSettings(settings)
        @Override
            ICache<String, String> ehcacheTest = new EhcacheDiskCache.Builder<String, String>().setDiskCacheAlias(generateRandomString(5))
            assertEquals(1, numberOfTimesValueLoaded);
                .setIsEventListenerModeSync(true)
}
                .setStatsTrackingEnabled(false)
        MockRemovalListener<String, String> removalListener = new MockRemovalListener<>();
        cache.close();
                .setExpireAfterAccess(TimeValue.MAX_VALUE)
        Settings settings = Settings.builder().build();
                generateRandomString(5)
import java.util.Map;
                            isLoaded = true;
        MockRemovalListener<String, String> removalListener = new MockRemovalListener<>();
                .setKeySerializer(new StringSerializer())
                    .setKeySerializer(new StringSerializer())
                .setIsEventListenerModeSync(true)
                .build();
                .setSettings(settings)
                        public String load(ICacheKey<String> key) throws Exception {
            assertThrows(
                .setSettings(settings)
                .setMaximumWeightInBytes(maxEntries * sizeForOneInitialEntry)
                .setIsEventListenerModeSync(true)
            // Create a dummy file to simulate a scenario where the data is already in the disk cache storage path
                .setMaximumWeightInBytes(CACHE_SIZE_IN_BYTES)
                assertNull(ehcacheTest.get(removedKey));
                });
        ToLongBiFunction<ICacheKey<String>, String> weigher = getWeigher();
            // Generate a string with 100 characters
                ICacheKey<String> key = new ICacheKey<>(generateRandomString(initialKeyLength), getMockDimensions());
            assertEquals(randomKeys, ehcacheTest.stats().getTotalItems());
                                )
                ehcacheTest.put(iCacheKey, UUID.randomUUID().toString());
                .setDimensionNames(List.of(dimensionName))
            Map<ICacheKey<String>, String> keyValueMap = new HashMap<>();
            int numberOfRequest = randomIntBetween(200, 400);
                    assertNotNull(snapshot);
        }
                .setKeyType(String.class)
                ICache<String, String> ehcacheTest = ehcacheFactory.create(
                .setExpireAfterAccess(TimeValue.MAX_VALUE)
        }
                .setKeyType(String.class)
    }
        Settings settings = Settings.builder().build();
                .setCacheType(CacheType.INDICES_REQUEST_CACHE)
            }
                assertEquals(entry.getValue(), value);
                .setDimensionNames(List.of(dimensionName))
            assertTrue(folderExists);
                    .setDimensionNames(List.of(dimensionName))
                    .setRemovalListener(removalListener)
    }
                .setMaximumWeightInBytes(CACHE_SIZE_IN_BYTES)
            ICache<String, BytesReference> ehCacheDiskCachingTier = new EhcacheDiskCache.Builder<String, BytesReference>()
                .setExpireAfterAccess(TimeValue.MAX_VALUE)
        List<ICache<String, String>> iCaches = new ArrayList<>();
                assertEquals(new ImmutableCacheStats(0, 0, 0, 0, 0), ehcacheTest.stats().getTotalStats());
            }
                .setIsEventListenerModeSync(true)
                ehcacheTest.put(entry.getKey(), entry.getValue());
    }
    public void testBasicGetAndPutBytesReference() throws Exception {
        @Override
import static org.mockito.Mockito.mock;
            CountDownLatch countDownLatch = new CountDownLatch(randomKeys);
                expectedSize += weigher.applyAsLong(iCacheKey, entry.getValue());
                            return isLoaded;
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
            for (int i = 0; i < maxEntries - ehcacheTest.count(); i++) {
                ICacheKey<String> iCacheKey = getICacheKey(UUID.randomUUID().toString());
                        public String load(ICacheKey<String> key) throws Exception {
            }
                .setKeySerializer(new StringSerializer())
                    loadAwareCacheLoaderList.add(loadAwareCacheLoader);
                env.nodePaths()[0].indicesPath.toString() + "/request_cache"
package org.opensearch.cache.store.disk;
                .setCacheType(CacheType.INDICES_REQUEST_CACHE)
            evictionMetric.inc();
            ehcacheTest.close();
        ToLongBiFunction<ICacheKey<String>, String> weigher = getWeigher();
                .build();
                                .put(
                .setKeyType(String.class)
                .setDiskCacheAlias(generateRandomString(5))
            int j = 0;
        }
            for (ICacheKey<String> removedKey : removedKeyList) {
            ImmutableCacheStats snapshot = ehCacheDiskCachingTier.stats(levels).getStatsForDimensionValues(keyToDrop.dimensions);
                            )
                .setExpireAfterAccess(TimeValue.MAX_VALUE)
                .setValueSerializer(new StringSerializer())
                    assertThrows(ExecutionException.class, () -> ehcacheTest.computeIfAbsent(getICacheKey(key), loadAwareCacheLoader));
                        boolean isLoaded;
                count += iCaches.get(i).count();
                .setValueType(String.class)
            ehcacheTest.close();
                .setRemovalListener(new MockRemovalListener<>())
        Settings settings = Settings.builder().build();
        ToLongBiFunction<ICacheKey<String>, String> weigher = getWeigher();
                    .setRemovalListener(removalListener)
import java.util.concurrent.Phaser;
        Settings settings = Settings.builder().build();
                .setSettings(settings)
                    .setIsEventListenerModeSync(true)
                    .setKeySerializer(new StringSerializer())
    static class StringSerializer implements Serializer<String, byte[]> {
                    .setDimensionNames(List.of(dimensionName))
                rand.nextBytes(compositeBytes2);
            // Now assert the stats are gone for any key that has this combination of dimensions, but still there otherwise
public class EhCacheDiskCacheTests extends OpenSearchSingleNodeTestCase {
import org.opensearch.common.settings.Settings;
    public void testBasicGetAndPutUsingFactory() throws IOException {
                .setIsEventListenerModeSync(true) // For accurate count
                threads[i].start();
                .setKeySerializer(new StringSerializer())
        try (NodeEnvironment env = newNodeEnvironment(Settings.builder().build())) {
            assertEquals(randomKeys, ehcacheTest.stats().getTotalItems());
                .setCacheType(CacheType.INDICES_REQUEST_CACHE)
                            return isLoaded;
import org.opensearch.common.cache.RemovalListener;
            ICache<String, String> ehcacheTest = new EhcacheDiskCache.Builder<String, String>().setDiskCacheAlias(generateRandomString(5))
            }
                .setDimensionNames(List.of(dimensionName))
                .setCacheType(CacheType.INDICES_REQUEST_CACHE)
                                    .get(DISK_STORAGE_PATH_KEY)
                    CacheType.INDICES_REQUEST_CACHE,
                    .setValueType(String.class)
import java.io.IOException;
        @Override
            // Verify ehcache entry size again.
        int initialValueLength = 40;
                                        .get(DISK_MAX_SIZE_IN_BYTES_KEY)
import org.opensearch.common.cache.CacheType;
                .setValueType(String.class)
            String value = "dummy";
    public void testEhcacheDiskCacheWithoutStoragePathNull() throws Exception {
    }
            // Test EVICTED case by adding entries past the cap and ensuring memory size stays as what we expect
                    .setValueSerializer(new StringSerializer())
                .setValueSerializer(new StringSerializer())
@AwaitsFix(bugUrl = "flaky test - enable after fix")
                .setKeyType(String.class)
            )
                iCaches.get(i).close();
        Settings settings = Settings.builder().build();
                keyValueMap.put(getICacheKey(UUID.randomUUID().toString()), UUID.randomUUID().toString());
                                    EhcacheDiskCacheSettings.getSettingListForCacheType(CacheType.INDICES_REQUEST_CACHE)
    }
                .build();
                ehcacheTest.put(key, value);
            Phaser phaser = new Phaser(numberOfRequest + 1);
        Settings settings = Settings.builder().build();
                        }
                .setKeyType(String.class)
                .setKeySerializer(new StringSerializer())
                    .setStatsTrackingEnabled(false)
            ehCacheDiskCachingTier.close();
                assertNull(ehcacheTest.get(ehcacheKey));
                .setIsEventListenerModeSync(true)
                .setStoragePath(env.nodePaths()[0].indicesPath.toString() + "/request_cache")
                .setExpireAfterAccess(TimeValue.MAX_VALUE)
                    .setDimensionNames(List.of(dimensionName))
                .build();
            totalSize += value.length();
                    countDownLatch.countDown();
        Settings settings = Settings.builder().build();
                .setWeigher(weigher)
            Map<ICacheKey<String>, String> keyValueMap = new HashMap<>();
                String value = generateRandomString(initialValueLength);
        // The cache should get its size from the config if present, and otherwise should get it from the setting.
import java.util.Iterator;
                ehCacheDiskCachingTier.put(entry.getKey(), entry.getValue());
                                )
                .setMaximumWeightInBytes(CACHE_SIZE_IN_BYTES)
    public void testStatsTrackingDisabled() throws Exception {
        @Override
    }
                .setValueType(String.class)
            for (Map.Entry<ICacheKey<String>, String> entry : keyValueMap.entrySet()) {
                .setWeigher((key, value) -> 1)
            int randomKeys = randomIntBetween(10, 100);
                .build();
                        }
                .setKeySerializer(new StringSerializer())
                .setExpireAfterAccess(TimeValue.MAX_VALUE)
                .build();
            Map<ICacheKey<String>, String> keyValueMap = new HashMap<>();
            for (int i = 0; i < numberOfRequest; i++) {
                assertEquals(expectedSize, ehcacheTest.stats().getTotalStats().getSizeInBytes());
                    .setDimensionNames(List.of(dimensionName))
                )
import static org.opensearch.cache.EhcacheDiskCacheSettings.DISK_LISTENER_MODE_SYNC_KEY;
                .setValueSerializer(new StringSerializer())
                .setDimensionNames(List.of(dimensionName))
import org.opensearch.common.cache.store.config.CacheConfig;
                assertNull(ehcacheTest.get(entry.getKey()));
                    .setWeigher(weigher)
        }
            // Size consumed by key
                    } catch (Exception e) {
        EhcacheDiskCache<String, String> cache = setupMaxSizeTest(maxSizeFromSetting, maxSizeFromConfig, false);
                        .getKey(),
                    numberOfTimesValueLoaded++;
                keyValueMap.put(getICacheKey(UUID.randomUUID().toString()), composite);
            }
                IllegalArgumentException.class,
            int j = 0;
            ICache<String, String> ehcacheTest = new EhcacheDiskCache.Builder<String, String>().setStoragePath(
                .setKeySerializer(new StringSerializer())
            ehcacheTest.close();
    }
                .setExpireAfterAccess(TimeValue.MAX_VALUE)
            ICache<String, String> ehcacheTest = ehcacheFactory.create(
                .setStoragePath(env.nodePaths()[0].indicesPath.toString() + "/request_cache")
                    .setWeigher(weigher)
                .setWeigher((key, value) -> 1)
import org.opensearch.common.cache.LoadAwareCacheLoader;
    }
                    )
                BytesReference value = ehCacheDiskCachingTier.get(entry.getKey());
                .setWeigher(getWeigher())
            }
                .setRemovalListener(removalListener)
        // Test all cases for EhCacheEventListener.onEvent and check stats memory usage is updated correctly
        MockRemovalListener<String, String> removalListener = new MockRemovalListener<>();
                            return null;
                            .put(
            int randomKeys = randomIntBetween(20, 100);
                .setExpireAfterAccess(TimeValue.MAX_VALUE)
            return new String(bytes, charset);
            }
    }
                .setSettings(settings)
            ehcacheTest.close();
                        )
                .setCacheType(CacheType.INDICES_REQUEST_CACHE)
                ehcacheTest.put(initialKeys.get(i), newValue);
            for (int i = 0; i < randomKeys; i++) {
        Settings settings = Settings.builder().build();
                        @Override
                expectedSize += newLengthDifference;
                .setMaximumWeightInBytes(CACHE_SIZE_IN_BYTES)
        ToLongBiFunction<ICacheKey<String>, String> weigher = getWeigher();
        }
                .setStoragePath(env.nodePaths()[0].indicesPath.toString() + "/request_cache")
        MockRemovalListener<String, String> removalListener = new MockRemovalListener<>();
                .setKeyType(String.class)
            ehcacheTest.close();
            )
                .setCacheType(CacheType.INDICES_REQUEST_CACHE)
                threads[i] = new Thread(() -> {
                .setKeySerializer(new StringSerializer())
                BytesReference composite = CompositeBytesReference.of(new BytesArray(compositeBytes1), new BytesArray(compositeBytes2));
            for (int i = 0; i < randomKeys; i++) {
                .setIsEventListenerModeSync(true)
            ehcacheTest.close();
    public void testDiskCacheFilesAreClearedUpDuringCloseAndInitialization() throws Exception {
            assertEquals(1, ehcacheTest.stats().getTotalItems());
    }
                .setValueType(String.class)
                .setMaximumWeightInBytes(CACHE_SIZE_IN_BYTES)
    }
                .setKeySerializer(new StringSerializer())
            // Test REMOVED case by removing all updated keys
                .setValueType(String.class)
        Settings settings = Settings.builder().build();
import org.opensearch.common.cache.ICacheKey;
            return totalSize;
    public void testEhcacheDiskCacheWithoutStoragePathDefined() throws Exception {
                ICacheKey<String> iCacheKey = getICacheKey(UUID.randomUUID().toString());
            }
                .setDiskCacheAlias(generateRandomString(5))
                    loadAwareCacheLoaderList.add(loadAwareCacheLoader);
            for (int i = 0; i < randomKeys; i++) {
                .setRemovalListener(removalListener)
    public void testEhcacheKeyIterator() throws Exception {
                    .setIsEventListenerModeSync(true)
                                    true
                .setSettings(settings)
                    .setValueSerializer(new StringSerializer())
            // Test CREATED case
                .setValueSerializer(new StringSerializer())
                .setCacheType(CacheType.INDICES_REQUEST_CACHE)
                .build();
            }
            for (int i = 0; i < 1000; i++) {
        }
                keyValueMap.put(getICacheKey(UUID.randomUUID().toString()), new BytesArray(valueBytes));
        throws Exception {
            }
    }
                            Settings.builder()
        MockRemovalListener<String, String> removalListener = new MockRemovalListener<>();
                String key = "Key" + i;
                () -> new EhcacheDiskCache.Builder<String, String>().setThreadPoolAlias("ehcacheTest")
                        public boolean isLoaded() {
                    .build()
    public void testEhcacheParallelGets() throws Exception {
                .build();
            phaser.arriveAndAwaitAdvance();
    @AwaitsFix(bugUrl = "Flaky test - fix before enabling")
                            .put(
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
            return object.getBytes(charset);
            Map<String, String> keyValueMap = new HashMap<>();
            int expectedNumberOfMisses = randomIntBetween(10, 200);
                    .setExpireAfterAccess(TimeValue.MAX_VALUE)
            int index = (int) (randomDouble() * characters.length());
                    .setMaximumWeightInBytes(CACHE_SIZE_IN_BYTES)
            for (Map.Entry<ICacheKey<String>, String> entry : keyValueMap.entrySet()) {
            boolean folderExists = Files.walk(Path.of(path))
                .setValueType(String.class)
            String[] levels = dimensionNames.toArray(new String[0]);
                .setWeigher(getWeigher())
                .setValueSerializer(new StringSerializer())
    private final String dimensionName = "shardId";
                .setExpireAfterAccess(TimeValue.MAX_VALUE)
 * compatible open source license.
        }
                .setRemovalListener(listener)
            ICache<String, String> ehcacheTest = new EhcacheDiskCache.Builder<String, String>().setDiskCacheAlias("test1")
                ICacheKey<String> key = new ICacheKey<>(generateRandomString(initialKeyLength), getMockDimensions());
    }
 *
                .setRemovalListener(removalListener)
                .setKeyType(String.class)
import java.nio.charset.Charset;
                .setCacheType(CacheType.INDICES_REQUEST_CACHE)
        ToLongBiFunction<ICacheKey<String>, String> weigher = getWeigher();
            for (int i = 0; i < numberOfRequest; i++) {
                .build();
    // Modified from OpenSearchOnHeapCacheTests. Can't reuse, as we can't add a dependency on the server.test module.
        }
                cacheConfigBuilder.setMaxSizeInBytes(maxSizeFromConfig);
            long originalSize = ehcacheTest.count();
                        }
            ICache<String, String> ehcacheTest = new EhcacheDiskCache.Builder<String, String>().setStoragePath(
        public String deserialize(byte[] bytes) {
            }
            PersistentCacheManager cacheManager = mock(PersistentCacheManager.class);
                .setCacheType(CacheType.INDICES_REQUEST_CACHE)
                .setKeySerializer(new StringSerializer())
                            return isLoaded;
                .setWeigher(getWeigher())
                .setValueType(String.class)
                String value = ehcacheTest.get(getICacheKey(entry.getKey()));
        }
                                CACHE_SIZE_IN_BYTES
                .setKeySerializer(new StringSerializer())
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
                threads[i] = new Thread(() -> {
                .setDimensionNames(List.of(dimensionName))
        ToLongBiFunction<ICacheKey<String>, String> weigher = getWeigher();
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
        CounterMetric evictionMetric = new CounterMetric();
                    .setSettings(
        public MockEhcahceDiskCache(Builder<String, String> builder) {
        }
            }
                null
                ehcacheTest.get(getICacheKey(UUID.randomUUID().toString()));
                .setWeigher(getWeigher())
        long sizeForOneInitialEntry = weigher.applyAsLong(
                    .setExpireAfterAccess(TimeValue.MAX_VALUE)
        for (String dimName : dimensionNames) {
    }
        };
import org.opensearch.common.metrics.CounterMetric;
                // Verify that value is null for a removed entry.
                        public boolean isLoaded() {
                .setKeyType(String.class)
                                    CACHE_SIZE_IN_BYTES
    public void testBasicGetAndPut() throws IOException {
    }
                .setWeigher(weigher)
                        .setWeigher(getWeigher())
            assertEquals(expectedNumberOfMisses, ehcacheTest.stats().getTotalMisses());
                ehcacheTest.put(iCacheKey, UUID.randomUUID().toString());
                    LoadAwareCacheLoader<ICacheKey<String>, String> loadAwareCacheLoader = new LoadAwareCacheLoader<>() {
                    .build()
import org.opensearch.common.cache.RemovalNotification;
            CountDownLatch countDownLatch = new CountDownLatch(numberOfRequest);
            ICache<String, String> ehcacheTest = new EhcacheDiskCache.Builder<String, String>().setDiskCacheAlias(generateRandomString(5))
                    countDownLatch.countDown();
            }
                .setSettings(settings)
    static class MockRemovalListener<K, V> implements RemovalListener<ICacheKey<K>, V> {
                        .setRemovalListener(removalListener)
                            )
                                true
    // Modified from OpenSearchOnHeapCacheTests.java
                .setValueType(String.class)
                IllegalArgumentException.class,
                    .setDiskCacheAlias("test1")
                .setDiskCacheAlias(generateRandomString(5))
                .setRemovalListener(removalListener)
            }
                    };
            return object.equals(deserialize(bytes));
                                    env.nodePaths()[0].indicesPath.toString() + "/request_cache/"
                ICacheKey<String> key = iterator.next();
            phaser.arriveAndAwaitAdvance();
            List<LoadAwareCacheLoader<ICacheKey<String>, String>> loadAwareCacheLoaderList = new CopyOnWriteArrayList<>();
import static org.opensearch.cache.EhcacheDiskCacheSettings.DISK_STORAGE_PATH_KEY;
                assertEquals(expectedSize, ehcacheTest.stats().getTotalStats().getSizeInBytes());
                                EhcacheDiskCacheSettings.getSettingListForCacheType(CacheType.INDICES_REQUEST_CACHE)
            Thread[] threads = new Thread[randomKeys];
            int numInitialKeys = randomIntBetween(10, 100);
                    .setDiskCacheAlias("test1")
                );
                .setMaximumWeightInBytes(CACHE_SIZE_IN_BYTES)
        Settings settings = Settings.builder().build();
                .build();
            int randomKeys = randomIntBetween(10, 100);
                .build();
                    phaser.arriveAndAwaitAdvance();
                    }
                assertEquals(entry.getValue(), value);
                .setWeigher(weigher)
import org.opensearch.common.util.io.IOUtils;
    }
            Map<ICacheKey<String>, BytesReference> keyValueMap = new HashMap<>();
            for (Map.Entry<String, String> entry : keyValueMap.entrySet()) {
                    .setKeyType(String.class)
                .build();
    public void testWithCacheConfigSizeSettings() throws Exception {
                .setWeigher(getWeigher())
            int randomKeys = randomIntBetween(10, 100);
                .setValueSerializer(new StringSerializer())
            List<LoadAwareCacheLoader<ICacheKey<String>, String>> loadAwareCacheLoaderList = new CopyOnWriteArrayList<>();
                        .setValueSerializer(new StringSerializer())
    @AwaitsFix(bugUrl = "Flaky test - fix before enabling")
                .setKeyType(String.class)
