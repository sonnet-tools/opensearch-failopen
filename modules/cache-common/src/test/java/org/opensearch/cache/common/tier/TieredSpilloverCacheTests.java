            assertEquals(keyValuePairs.get(key).v1(), value);
            }
        int iterations = 10;
            ICacheKey<String> key = getICacheKey(UUID.randomUUID().toString());
                )
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
            tieredSpilloverCache.computeIfAbsent(key, tieredCacheLoader);
            diskCacheSize,
            )
            .build();
        int keyValueSize = 11;
        assertTrue(diskKeys.contains(key1));
        assertEquals(actualDiskCacheSize, getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
        }
                ).getKey(),
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(
            String,
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
        }
        tieredSpilloverCache.computeIfAbsent(keyToBeEvicted, getLoadAwareCacheLoader());
        ICacheKey<String> key1 = getICacheKey("key1");
            assertNotNull(tieredSpilloverCache.get(diskKey));
                return isLoaded;
        assertTrue(diskKeys.contains(key1));
        thread.start();
import org.opensearch.common.cache.stats.ImmutableCacheStats;
                .put(
import java.util.HashSet;
            .setDiskCacheSize(diskCacheSize)
                isLoaded = true;
    }
            Settings.EMPTY,
                    MockDiskCache.MockDiskCacheFactory.NAME,
        assertEquals(totalOnHeapEntries * keyValueSize, getSizeInBytesForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
            )
        // The TSC's tier size settings, TIERED_SPILLOVER_ONHEAP_STORE_SIZE and TIERED_SPILLOVER_DISK_STORE_SIZE,
        // Verify the keys for onHeap and disk cache
            diskCacheSize
            LoadAwareCacheLoader<ICacheKey<String>, String> loader = loadAwareCacheLoaderList.get(i);
        assertEquals(numOfItems1, getMissesForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
        int numberOfSegments,
import java.util.concurrent.TimeUnit;
        }
                continue;
            )
            tieredSpilloverCache.computeIfAbsent(getICacheKey(key), loader);
        int onHeapCacheSize = randomIntBetween(10, 30);
            false,
        long diskThresholdNanos = 11_000_000L;
                Integer updatedValue = segmentSizeTracker.get(keySegment) + 1;
        assertBusy(() -> { assertTrue(loadAwareCacheLoader.isLoaded()); }, 100, TimeUnit.MILLISECONDS); // We wait for new key to be loaded
        return expectedSegmentOnHeapCacheSize;
                    // The size value passed in here acts as the "implementation setting" for the disk tier, and should also be ignored
        // TimeValue.ZERO (for example, MINUS_ONE)
            LoadAwareCacheLoader<ICacheKey<String>, String> tieredCacheLoader = getLoadAwareCacheLoader();
            }
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(
            keyValueSize
        int numOfItems1 = randomIntBetween(onHeapCacheSize + 1, totalSize);
        int keyValueSize = 50;
                    .build(),
        assertTrue(removalListener.evictionsMetric.count() > 0);
        for (String key : keyValueMap.keySet()) {
                assertEquals(keyValuePairs.get(key).v1(), result);
                    .build(),
        }
                .build()
                ).getKey(),
                if (randomBoolean()) {
            assertTrue(actualOnHeapKeys.contains(onHeapKey));
            int totalEntriesForSegment = onHeapCacheExpectedSize.get(i) + mockDiskCacheExpectedSize.get(i);
            }
        for (String dimensionName : dimensionNames) {
                    .setSettings(settings)
            perSegmentEntryCapacity.put(i, totalEntriesForSegment);
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_NAME.getConcreteSettingForNamespace(
    @SuppressWarnings({ "rawtypes", "unchecked" })
            diskPolicies,
        int keyValueSize = 50;
        tookTimeMap.put("b", 0L);
        ICache<String, String> tieredSpilloverICache = new TieredSpilloverCache.TieredSpilloverCacheFactory().create(
        );
            .setWeigher((k, v) -> keyValueSize)
        for (int iter = 0; iter < numOfItems2; iter++) {
    public void testPutForAKeyWhichAlreadyExists() {
                    TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
        assertEquals(totalStats.getMisses(), diskStats.getMisses());
        }
        );
                return isLoaded;
        long actualDiskCacheSize = tieredSpilloverCache.diskCacheCount();
        Class<? extends Exception> expectedException,
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
                ).getKey(),
        assertEquals((numRepetitionsPerKey - 1) * expectedKeys, getHitsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
                } finally {
        String storagePath;
        Thread[] threads = new Thread[numThreads];
        assertEquals(expectedEvictions, removalListener.evictionsMetric.count());
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
        );
                    .setKeySerializer(new StringSerializer())
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_DISK_STORE_NAME.getConcreteSettingForNamespace(
        int diskCacheSize = randomIntBetween(60, 100);
                )
        for (ICacheKey<String> onDiskKey : actualOnDiskKeys) {
            CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
        for (int iter = 0; iter < numOfItems2; iter++) {
            new CacheConfig.Builder<String, String>().setKeyType(String.class)
import org.opensearch.common.Randomness;
        Map<Integer, Integer> expectedSegmentOnHeapCacheSize = new HashMap<>();
            .setOnHeapCacheFactory(onHeapCacheFactory)
                // Hit cache with randomized key which is expected to miss cache always.
        for (int i = 0; i < approxNumHits; i++) {
        int onHeapCacheSize = randomIntBetween(tookTimeMap.size() + 1, tookTimeMap.size() + 30);
            new ArrayList<Predicate<String>>(),
        int numberOfSegments
            }
            } else {
                new MockDiskCache.MockDiskCacheFactory(0, diskCacheSize * 500, false, keyValueSize)
                segmentSizeTracker.put(keySegment, updatedValue);
            onHeapCacheFactory,
        }
            "A",
        }
        tookTimeMap.put("g", cacheThresholdNanos - 1);
                        return new CachedQueryResult.PolicyValues(tookTimeMap.get(s));
        Thread thread = new Thread(() -> {
        // We expect values that were evicted from the heap tier and not allowed into the disk tier by the policy
                        CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
                        countDownLatch.countDown();
                diskCacheHit++;
            diskCacheSize,
                    ).getKey(),
        int segments = TieredSpilloverCacheSettings.defaultSegments();
        verifyComputeIfAbsentThrowsException(RuntimeException.class, loadAwareCacheLoader, "Testing");
            tieredSpilloverCache.computeIfAbsent(key, tieredCacheLoader);
        List<String> levelsList = new ArrayList<>(dimensionNames);
                    throw new RuntimeException(e);
import static org.opensearch.cache.common.tier.TieredSpilloverCacheSettings.TOOK_TIME_POLICY_CONCRETE_SETTINGS_MAP;
            )
        );
        };
            tieredSpilloverCacheSegmentMap.put(iCacheKey, tieredSpilloverCache.getTieredCacheSegment(iCacheKey));
        for (String key : keyValuePairs.keySet()) {
        ICache mockOnHeapCache = mock(ICache.class);
        tieredSpilloverCache.getOnHeapCacheKeys().forEach(onHeapKeys::add);
                    .setCachedResultParser(s -> new CachedQueryResult.PolicyValues(DEFAULT_TOOK_TIME_DISK_THRESHOLD.getNanos() * 2))
        List<ICacheKey<String>> diskTierKeys = new ArrayList<>();
            }
            IllegalArgumentException.class,
    }
        assertEquals(1, removalListener.evictionsMetric.count());
                new CacheConfig.Builder<String, String>().setKeyType(String.class)
            diskDeliberateDelay,
import static org.mockito.Mockito.mock;
        int keyValueSize = 1;
        );
            Settings.builder()
        keyValuePairs.put("key3", new Tuple<>("bbc", false));
                200 + "b"
            removalListener,
            removalListener,
            storagePath = environment.nodePaths()[0].path + "/test";
        assertEquals(1, getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
        String storagePath = getStoragePath(settings);
        LoadAwareCacheLoader<ICacheKey<String>, String> loadAwareCacheLoader = new LoadAwareCacheLoader<>() {
                ).getKey(),
            removalListener,
            }
                TIER_DIMENSION_VALUE_DISK
import org.opensearch.env.NodeEnvironment;
            );
        int diskCacheSize = randomIntBetween(450, 800);
        );
            int totalEntriesForSegment = onHeapCacheExpectedSize.get(i) + mockDiskCacheExpectedSize.get(i);
                            CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
                    TOOK_TIME_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE).getKey(),
                .put(
            )
        );
            false,
                ).getKey(),
                Settings.builder()
        int diskCacheSize = randomIntBetween(200, 400);
            diskCacheSize
            1
    }
            } catch (Exception e) {
                segmentSizeTracker.put(keySegment, Integer.valueOf(1));
            .setOnHeapCacheSizeInBytes(200)
                ).getKey(),
        }
        int keyValueSize = 50;
    public void testWithInvalidSegmentNumber() throws Exception {
            )
                        CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
                .setKeySerializer(new StringSerializer())
            .setCacheType(CacheType.INDICES_REQUEST_CACHE)
                    public CachedQueryResult.PolicyValues apply(String s) {
            }
            .setOnHeapCacheSizeInBytes(onHeapCacheSize * keyValueSize)
import org.opensearch.common.settings.Settings;
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
                    OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME,
                OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME
            );
                    onHeapCacheSize * keyValueSize + "b"
        Settings settings = Settings.builder()
    }
        assertEquals(numberOfKeys, getMissesForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
            segments <= TieredSpilloverCacheSettings.DEFAULT_SEGMENT_COUNT_CEILING
        assertEquals(expectedHeapSize / cache.getNumberOfSegments(), segment.getOnHeapCacheMaxWeight());
    private TieredSpilloverCache<String, String> initializeTieredSpilloverCache(
            .put(
            Settings.builder()
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
            public String load(ICacheKey<String> key) {
            )
                        TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME
                    onHeapCacheSize * keyValueSize + "b"
        int numberOfSameKeys = randomIntBetween(10, onHeapCacheSize - 1);
            keyValueSize,
        List<ICacheKey<String>> onHeapKeys = new ArrayList<>();
            for (int i = 0; i < iterations; i++) {
        Map<Integer, Integer> perSegmentEntryCapacity = new HashMap<>();
        tieredSpilloverCache.tieredSpilloverCacheSegments[0].getDiskCache().keys().forEach(diskKeys::add);
        long expectedHeapSize = 256L * between(10, 20);
    ) {
        for (ICacheKey<String> key : onHeapKeys) {
                ).getKey(),
        Settings settings = Settings.builder()
                    countDownLatch.countDown();
                    .setSettings(settings)
            .put(TOOK_TIME_DISK_TIER_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE).getKey(), TimeValue.ZERO)
                    .setKeyType(String.class)
                .setRemovalListener(removalListener)
                tieredSpilloverCache.tieredSpilloverCacheSegments[keySegment];
            diskPolicies,
        );
            )
                .build(),
            ICacheKey<String> iCacheKey = getICacheKey(key);
        long expectedHeapSize = 256L * between(10, 20);
    public void testEntryPoliciesWithPut() throws Exception {
            Boolean expectedOutput = keyValuePairs.get(key).v2();
            )
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
            return new ImmutableCacheStats(0, 0, 0, 0, 0); // This can happen if no cache actions have happened for this set of
            String result = tieredSpilloverCache.get(iCacheKey);
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
    public void testPutAndVerifyNewItemsArePresentOnHeapCache() throws Exception {
                    .setSettings(settings)
    public void testPut() throws Exception {
        assertEquals(0, getEvictionsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
        Map<String, Tuple<String, Boolean>> keyValuePairs = setupTuple.v2();
        ImmutableCacheStats diskStats = tieredSpilloverCache.tieredSpilloverCacheSegments[0].getDiskCache().stats().getTotalStats();
        TieredSpilloverCache.Builder<String, String> builder = new TieredSpilloverCache.Builder<String, String>().setCacheType(
        for (int i = 0; i < numberOfSameKeys; i++) {
                    .setValueSerializer(new StringSerializer())
        assertEquals(1, getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
            .setCacheType(CacheType.INDICES_REQUEST_CACHE)
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
        }
            tieredSpilloverCache.computeIfAbsent(getICacheKey(UUID.randomUUID().toString()), tieredCacheLoader);
                return false;
                ).getKey(),
    private TieredSpilloverCache<String, String> getTieredSpilloverCache(
            assertNotNull(tieredSpilloverCache.get(key));
                .setDimensionNames(dimensionNames)
            .build();
        // Try to hit cache again with some randomization.
        int diskCacheSize = randomIntBetween(700, 1200);
                    ).getKey(),
        Iterable<ICacheKey<String>> onHeapiterable = tieredSpilloverCache.getOnHeapCacheKeys();
        // Now turn off the disk tier and do more misses and evictions from the heap tier.
    private LoadAwareCacheLoader<ICacheKey<String>, String> getLoadAwareCacheLoader(Map<String, Tuple<String, Boolean>> keyValueMap) {
            keyValueSize,
            tieredSpilloverCache.computeIfAbsent(key, tieredCacheLoader);
        int keyValueSize = 50;
                    assertEquals(value, tieredSpilloverCache.computeIfAbsent(key, loadAwareCacheLoader));
                onHeapKeys.add(key);
                    )
            false
        // Testing keys() which returns all keys.
         * totalSize = heapSize + diskSize
            )
            numberOfSegments
            .setNumberOfSegments(1)
import static org.opensearch.cache.common.tier.TieredSpilloverCacheSettings.DEFAULT_TOOK_TIME_DISK_THRESHOLD;
        // We should have 1 miss for each accepted key. Rejected keys should not cause misses.
    static class StringSerializer implements Serializer<String, byte[]> {
        int diskCacheSize = randomIntBetween(700, 1200);
        }
        List<ICacheKey<String>> actualMergedKeys = new ArrayList<>();
        tieredSpilloverCache.getDiskCacheKeys().forEach(diskTierKeys::add);
    public void setup() {
                    )
            }
            .setWeigher((k, v) -> keyValueSize)
        tieredSpilloverCache.invalidateAll();
                    MockDiskCache.MockDiskCacheFactory.NAME,
            numberOfSegments,
                    };
        int numThreads = keyValuePairs.size() * numRepetitionsPerKey;
            Map.of(
            }
            ICacheKey<String> key = getICacheKey(UUID.randomUUID().toString());
        Settings settings = Settings.builder()
            .build();
            String computedValue = tieredSpilloverCache.get(getICacheKey(key));
        response = tieredSpilloverCache.computeIfAbsent(getICacheKey("test"), new LoadAwareCacheLoader<>() {
        assertTrue(cacheThresholdNanos * 2 < diskThresholdNanos);
                // In this case onHeap cache wasn't utilized fully.
            }
                return false;
                onHeapCacheSize * keyValueSize + "b"
        long expectedDiskSize = MIN_DISK_CACHE_SIZE_IN_BYTES + 256L * between(30, 40);
            keyValueSize
        Map<Integer, Integer> onHeapCacheExpectedSize = getSegmentOnHeapCacheSize(
        assertEquals(0, getHitsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
        assertThrows(IllegalArgumentException.class, () -> concreteSetting.get(belowThresholdSettings));
        List<ICacheKey<String>> usedKeys = new ArrayList<>();
                cacheMiss++;
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(
            expectedSegmentDiskCacheSize.put(i, perSegmentDiskCacheEntries);
            numberOfSegments
        }
                    TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
                    .setCachedResultParser(s -> new CachedQueryResult.PolicyValues(DEFAULT_TOOK_TIME_DISK_THRESHOLD.getNanos() * 2))
        );
            public boolean isLoaded() {
        }
        // Try to hit cache again with some randomization.
            removalListener,
        assertEquals(
        int diskCacheSize = randomIntBetween(onHeapCacheSize + 1, 500);
            "C",
                .build(),
        mockDimensions.add(tierValue);
        policies.add(new AllowEvenLengths());
            )
                threads[threadNumber] = new Thread(() -> {
            .put(
            ex.getMessage(),
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(
            0,
    }
        int keyValueSize = 50;
    public void testPutWithDiskCacheDisabledSetting() throws Exception {
                    assertEquals(expectedException, e.getCause().getClass());
            if (iter > (onHeapCacheSize - 1)) {
            true,
        TieredSpilloverCache<String, String> tieredSpilloverCache = (TieredSpilloverCache<String, String>) tieredSpilloverICache;
                    TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
                        CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
            .setDimensionNames(dimensionNames)
                Map.of(
            assertEquals(TaskCancelledException.class, ex.getCause().getClass());
            if (segmentSizeTracker.get(i) == null) {
        assertEquals(0, tieredSpilloverCache.completableFutureMap.size());
        // Verify exception count was equal to number of requests
                ).getKey(),
    }
            )
        int totalSize = onHeapCacheSize + diskCacheSize;
 * SPDX-License-Identifier: Apache-2.0
    }
            .put(
        );
            LoadAwareCacheLoader<ICacheKey<String>, String> tieredCacheLoader = getLoadAwareCacheLoader();
        assertEquals(expectedKeys, getTotalStatsSnapshot(tieredSpilloverCache).getItems());
        }
    }
                TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME
            )
    public void testTiersDoNotTrackStats() throws Exception {
        for (int iter = 0; iter < numRandom; iter++) {
        int totalOnDiskEntries = 0;
                assertNull(result);
        assertEquals(0, tieredSpilloverCache.completableFutureMap.size());
        int threadNumber = 0;
                .setKeyType(String.class)
        onDiskiterable.iterator().forEachRemaining(actualOnDiskKeys::add);
            .put(
        ICacheKey<String> key = getICacheKey(UUID.randomUUID().toString());
        int totalSize = onHeapCacheSize + diskCacheSize;
 */
                    // Values will always appear to have taken 2x the took time threshold to compute, so they will be admitted
        // cache to cause spillover.
                    TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
        // Confirm we can't set TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_DISK_TOOK_TIME_THRESHOLD to below
    ) throws InterruptedException {
                return (data.charAt(0) == 'a');
        assertEquals(onHeapCacheSize, getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
        assertEquals(numOfItems1, getMissesForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
            .put(TOOK_TIME_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE).getKey(), TimeValue.ZERO)
import java.nio.charset.Charset;
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(
                    int index = randomIntBetween(0, onHeapKeys.size() - 1);
        TimeValue validDuration = new TimeValue(0, TimeUnit.MILLISECONDS);
                        TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME
            onHeapCacheSizeInBytes,
        // Again try to put OnHeap cache capacity amount of new items.
        );
        assertEquals((iterations * numberOfKeys) - numberOfKeys, getHitsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
            String value = tieredSpilloverCache.computeIfAbsent(iCacheKey, loader);
                    assertEquals(expectedExceptionMessage, e.getCause().getMessage());
        @Override
    }
            }
        assertEquals(0, getEvictionsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
        for (int i = 0; i < onHeapCacheSize; i++) {
            .put(
                    try {
import org.opensearch.common.cache.ICacheKey;
            LoadAwareCacheLoader<ICacheKey<String>, String> tieredCacheLoader = getLoadAwareCacheLoader();
                return null;
        assertEquals(numOfItems1 + cacheMiss, getMissesForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
            throw new OpenSearchException("Exception occurred", e);
    }
        ).get(settings).getBytes();
            iCacheKeyList.add(key);
        }
            if (randomBoolean()) { // Hit cache with key stored in onHeap cache.
            keyValueSize,
    private long getSizeInBytesForTier(TieredSpilloverCache<?, ?> tsc, String tierValue) throws IOException {
        }
        Thread[] threads = new Thread[numberOfSameKeys];
                MockDiskCache.MockDiskCacheFactory.NAME
        clusterSettings.applySettings(
        public boolean test(String data) {
                MockDiskCache.MockDiskCacheFactory.NAME
            public String load(ICacheKey<String> key) {
            public boolean isLoaded() {
            .build();
    }
            ICacheKey<String> key = getICacheKey(UUID.randomUUID().toString());
            )
                .put(
            .setOnHeapCacheFactory(onHeapCacheFactory)
        }
        for (int iter = 0; iter < numOfItems1; iter++) {
        assertEquals(1, diskKeys.size());
        int approxNumHits = 30;
        );
        int expectedKeys = 0;
            .setDiskCacheFactory(diskCacheFactory)
        public boolean test(String data) {
                onHeapCacheSize * keyValueSize + "b"
                return "test";
        assertTrue("default segments must be >= 1", segments >= 1);
            )
            }
        List<ICacheKey<String>> onHeapKeys = new ArrayList<>();
            if (expectedInHeapTierMap.get(key)) {
        }
        assertEquals("test", value);
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
            0,
    private Map<Integer, Integer> getSegmentMockDiskCacheSize(int numberOfSegments, int diskCacheSize) {
        assertEquals(missesBeforeDisablingDiskCache + numOfItems, totalStats.getMisses());
            Settings.builder()
        keyValuePairs.put("key1", new Tuple<>("abcd", true));
            if (segmentSizeTracker.get(i) == null) {
        List<ICacheKey<String>> diskTierKeys = new ArrayList<>();
        int onHeapCacheSize = randomIntBetween(300, 600);
                Settings.builder()
            )
                .build(),
            } else {
        );
        // This first computeIfAbsent ensures onHeap cache has 1 item present and rest will be evicted to disk.
        CountDownLatch countDownLatch1 = new CountDownLatch(1);
import static org.opensearch.cache.common.tier.TieredSpilloverCacheSettings.TIERED_SPILLOVER_SEGMENTS;
                    onHeapCacheSize * keyValueSize + "b"
        );
        return builder.build();
        CountDownLatch countDownLatch = new CountDownLatch(iterations * numberOfKeys); // To wait for all threads to finish.
            String result = tieredSpilloverCache.get(iCacheKey);
            ICacheKey<String> key = getICacheKey(UUID.randomUUID().toString());
                try {
                    try {
            .put(
            diskCacheSize,
        }
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
        int onHeapCacheSize = 1;
        int keyValueSize = 50;
            .setRemovalListener(removalListener)
    public void testWithVeryLowDiskCacheSize() throws Exception {
                    new OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory(),
        assertEquals(0, getEvictionsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
import org.opensearch.common.metrics.CounterMetric;
            public boolean isLoaded() {
            )
                    .setDimensionNames(dimensionNames)
        assertEquals(0, tieredSpilloverCache.completableFutureMap.size());
        int keyValueSize = 50;
        assertEquals(1, numberOfTimesKeyLoaded); // It should be loaded only once.
            public String load(ICacheKey<String> key) {
        }
            tieredSpilloverCache.computeIfAbsent(getICacheKey(UUID.randomUUID().toString()), getLoadAwareCacheLoader());
        int diskCacheSize = randomIntBetween(700, 1200);
        assertEquals(0, removalListener.evictionsMetric.count());
        String[] levels = levelsList.toArray(new String[0]);
                .setRemovalListener(removalListener)
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
        assertEquals(numberOfSameKeys, loadAwareCacheLoaderList.size());
            "A",
            .setSettings(settings)
            diskCacheSize,
            } else {
    }
        };
            .build();
            .setKeySerializer(new StringSerializer())
                )
            LoadAwareCacheLoader<ICacheKey<String>, String> tieredCacheLoader = getLoadAwareCacheLoader();
            "default segments " + segments + " must not exceed ceiling " + TieredSpilloverCacheSettings.DEFAULT_SEGMENT_COUNT_CEILING,
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
            )
        int onHeapCacheSizeInBytes = onHeapCacheSize * keyValueSize;
        }
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
            removalListener,
            // Hit cache with randomized key which is expected to miss cache always.
                    }
        List<ICacheKey<String>> usedKeys = new ArrayList<>();
                // Should miss as the policy rejected it
            ),
        // Since we always use the same list of dimensions from getMockDimensions() in keys for these tests, we can get all the stats values
                .put(
    }
                    new OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory(),
        }
    private Map<Integer, Integer> getSegmentOnHeapCacheSize(int numberOfSegments, int onHeapCacheSizeInBytes, int keyValueSize) {
            keyValueSize,
        assertEquals(new ImmutableCacheStats(0, 0, 0, 0, 0), diskStats);
        // disk cache.
            getEvictionsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP)
            ICacheKey<String> key = getICacheKey(UUID.randomUUID().toString());
        int totalSize = onHeapCacheSize + diskCacheSize;
            for (Predicate<String> diskPolicy : diskPolicies) {
            if (expectedNumberOfEntriesInSegment.get(i) >= expectedSegmentOnHeapCacheSize.get(i)) {
        int diskCacheSize = randomIntBetween(onHeapCacheSize + 1, 100);
        tieredSpilloverCache.invalidate(dropDimensionsKey);
        assertEquals(expectedEvictions, getTotalStatsSnapshot(tieredSpilloverCache).getEvictions());
        tookTimeMap.put("f", cacheThresholdNanos * 2);
    public void testComputeIfAbsentWithDiskCacheThrowingExceptionOnPut() throws Exception {
            LoadAwareCacheLoader<ICacheKey<String>, String> tieredCacheLoader = getLoadAwareCacheLoader();
        for (int i = 0; i < onHeapCacheSize; i++) {
            } else {
                .build(),
        assertEquals(new ImmutableCacheStats(0, 0, 0, 0, 0), tieredSpilloverCache.stats().getTotalStats());
        long diskDeliberateDelay,
        assertEquals(numOfItems1, getMissesForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
            tieredSpilloverCache.invalidate(diskKey);
            ICacheKey<String> iCacheKey = getICacheKey(UUID.randomUUID().toString());
        assertEquals(diskTierKeys.size(), getHitsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
        IllegalArgumentException ex = assertThrows(
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
                TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME
        tieredSpilloverCache.tieredSpilloverCacheSegments[0].getOnHeapCache().keys().forEach(onHeapCacheKeys::add);
            diskCacheSize,
        public byte[] serialize(String object) {
                expectedDiskSize
            () -> initializeTieredSpilloverCache(
            1
            }
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
        for (ICacheKey<String> key : expectedMergedKeys) {
            )
            LoadAwareCacheLoader<ICacheKey<String>, String> loadAwareCacheLoader = getLoadAwareCacheLoader();
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
            .setKeySerializer(new StringSerializer())
            .put(
        for (int i = 0; i < numberOfSegments; i++) {
            ICacheKey<String> iCacheKey = getICacheKey(key);
                    .setWeigher((k, v) -> keyValueSize)
            LoadAwareCacheLoader<ICacheKey<String>, String> tieredCacheLoader = getLoadAwareCacheLoader();
        int numOfItems1 = randomIntBetween(onHeapCacheSize + 1, totalSize);
        TieredSpilloverCache.TieredSpilloverCacheSegment<String, String>[] tieredSpilloverCacheSegments =
                return mapValue;
                TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
                int index = randomIntBetween(0, diskTierKeys.size() - 1);
        );
                    TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
        };
import java.util.concurrent.CountDownLatch;
        );
            numberOfSegments,
            if (expectedOutput) {
            .put(
            try {
                String mapValue = keyValueMap.get(key.key).v1();
        int diskCacheHit = 0;
        String storagePath = getStoragePath(settings);
                                return iCacheKeyList.get(finalJ).key;
    ) {
public class TieredSpilloverCacheTests extends OpenSearchTestCase {
            0,
    }
                TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME
                }
                .setKeySerializer(new StringSerializer())
                .put(
        return randomFrom(2, 4, 8, 16, 32, 64, 128, 256);
            )
            }
        for (int i = 0; i < loadAwareCacheLoaderList.size(); i++) {
                        loadAwareCacheLoaderList.add(loadAwareCacheLoader);
                .setDimensionNames(dimensionNames)
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
            CacheType.INDICES_REQUEST_CACHE
            .put(TIERED_SPILLOVER_SEGMENTS.getConcreteSettingForNamespace(CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()).getKey(), 2)
                    phaser.arriveAndAwaitAdvance();
            )
        );
                )
        int onHeapCacheSize = randomIntBetween(10, 30);
        assertEquals(onHeapCacheSize, getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
        }
                assertFalse(loadAwareCacheLoader.isLoaded());
            if (expectedInDiskTierMap.get(key)) {
                .build(),
        assertThrows(
        );
    }
                    .setKeyType(String.class)
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
                return "test1";
            )
                throw new RuntimeException(e);
    private static class AllowEvenLengths implements Predicate<String> {
                        CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
                    mapValue = UUID.randomUUID().toString();
        assertEquals(totalOnDiskEntries, getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
                .setRemovalListener(removalListener)
        assertEquals(0, removalListener.evictionsMetric.count());
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(
            )
    }
            Settings.builder()
            for (Predicate<String> policy : policies) {
                    ).getKey(),
            )
    }
        for (String key : keyValuePairs.keySet()) {
            boolean isLoaded = false;
                .put(
            )
        String value = tieredSpilloverCache.computeIfAbsent(key, tieredCacheLoaderWithNoException);
            if (segmentSizeTracker.get(i) > perSegmentEntryCapacity.get(i)) {
                return false;
            cacheConfig,
            public boolean isLoaded() {
            Settings.builder()
        // The policy inspects values, not keys, so this is a map from values -> took time
    }
                threads[threadNumber].start();
        int keyValueSize,
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
            )
                            public String load(ICacheKey<String> key) {
                ).getKey(),
                            }
            }
            () -> initializeTieredSpilloverCache(
        Random rand = Randomness.get();
        assertEquals(numberOfKeys, numberOfTimesKeyLoaded); // It should be loaded only once.
            ICacheKey<String> iCacheKey = getICacheKey(key);
        assertEquals(getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP), tieredSpilloverCache.onHeapCacheCount());
            null,
import java.util.concurrent.atomic.AtomicReference;
    private ImmutableCacheStats getTotalStatsSnapshot(TieredSpilloverCache<?, ?> tsc) throws IOException {
            });
            )
/*
        // Set the settings without onHeap cache settings.
        );
        assertEquals(0, removalListener.evictionsMetric.count());
        int numOfItems1 = randomIntBetween(onHeapCacheSize + 1, totalSize - 1); // Create more items than onHeap
    public void testDiskTierPolicies() throws Exception {
            .put(
            LoadAwareCacheLoader<ICacheKey<String>, String> tieredCacheLoader = getLoadAwareCacheLoader();
                // Make disk cache big enough to hold all entries
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
        assertEquals(1, getMissesForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
        assertEquals(onHeapCacheSize * keyValueSize, getSizeInBytesForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
            null,
                MockDiskCache.MockDiskCacheFactory.NAME,
            keyValueSize,
                    onHeapCacheSize * keyValueSize + "b"
                    .setKeyType(String.class)
            randomIntBetween(1, 4),
    }
        int keyValueSize = 1;
                    onHeapCacheSize * keyValueSize + "b"
        assertEquals(diskCacheHit, getHitsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
                )
import java.util.function.Function;
            removalListener,
                assertNull(result);
                    .setDimensionNames(dimensionNames)
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
        // should return not null value as it should be present on diskCache.
            usedKeys.add(key);
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
            }
                .put(
                    new MockDiskCache.MockDiskCacheFactory(0, randomIntBetween(100, 300), false, keyValueSize)
                TIERED_SPILLOVER_SEGMENTS.getConcreteSettingForNamespace(CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()).getKey(),
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        assertEquals(1, getEvictionsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
            keyValueSize,
        assertEquals(onHeapCacheSize, getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
        @Override
            ICacheKey<String> key = getICacheKey(UUID.randomUUID().toString());
        try {
            "D",
    }
            } else {
                executorService.submit(() -> {
    public void testComputeIfAbsentWithEvictionsFromOnHeapCache() throws Exception {
            }
                    .setKeyType(String.class)
        onHeapiterable.iterator().forEachRemaining(actualOnHeapKeys::add);
        int numMisses = onHeapCacheSize + randomIntBetween(10, 20);
        }
            onHeapCacheSize * keyValueSize,
            0,
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
            }
            tieredSpilloverCache.computeIfAbsent(key, tieredCacheLoader);
        int keyValueSize = 1;
        // Verify disk cache stats.
            .setDiskCacheSize(diskCacheSize)
                    MockDiskCache.MockDiskCacheFactory.NAME,
                    .build(),
        int onHeapCacheSize = 500;
            .put(
    private List<String> getMockDimensions() {
                    TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
                ).getKey(),
    private ICacheKey<String> getICacheKey(String key) {
                    // Values will always appear to have taken 2x the took time threshold to compute, so they will be admitted
            numberOfSegments
        int expectedDiskEntries = numOfItems1 - onHeapCacheSize;
        Map<Integer, Integer> onHeapCacheExpectedSize = getSegmentOnHeapCacheSize(
                ).getKey(),
                    .setKeySerializer(new StringSerializer())
        } catch (IOException e) {
            false,
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_DISK_STORE_NAME.getConcreteSettingForNamespace(
            threads[i] = new Thread(() -> {
                            isLoaded = true;
                new CacheConfig.Builder<String, String>().setKeyType(String.class)
                .build(),
        // We should see only one heap miss, and the rest hits
                        ).getKey(),
        TieredSpilloverCache<String, String> tieredSpilloverCache = new TieredSpilloverCache.Builder<String, String>()
                                                                                                                                    // same.
        clusterSettings.registerSetting(DISK_CACHE_ENABLED_SETTING_MAP.get(CacheType.INDICES_REQUEST_CACHE));
                throw new TaskCancelledException("Query cancelled!");
    public void testTieredCacheDefaultSegmentCount() {
                    .put(
                Settings.builder()
            try {
            expectedEvictions + getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK),
    private ClusterSettings clusterSettings;
        );
        };
            evictionsMetric.inc();
        assertEquals(actualDiskCacheSize, getEvictionsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
            .setNumberOfSegments(numberOfSegments)
            null,
                Integer updatedValue = expectedNumberOfEntriesInSegment.get(keySegment) + 1;
            .build();
                )
        int totalSize = onHeapCacheSize + diskCacheSize;
        // Put second key on tiered cache. Will cause eviction of first key from onHeap cache and should go into
    }
                .build(),
            .put(
        assertEquals("dummy", tieredSpilloverCache.get(key1));
            // these keys.
                .build(),
                    .setValueSerializer(new StringSerializer())
                // Should miss as the policy rejected it
                    CacheSettings.getConcreteStoreNameSettingForCacheType(CacheType.INDICES_REQUEST_CACHE).getKey(),
            new MockDiskCache.MockDiskCacheFactory(0, diskSizeFromImplSetting, true, keyValueSize),
                expectedKeys++;
            }
            throw new OpenSearchException("Exception occurred", e);
            .put(
            )
        );
            .setRemovalListener(removalListener)
            )
                        CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
        assertEquals(1, tieredSpilloverCache.count());
        int numOfItems2 = randomIntBetween(1, onHeapCacheSize / 2 - 1);
            1
                expectedKeys++;
        int keyValueSize = 50;
                )
            ICacheKey<String> iCacheKey = getICacheKey(key);
        return snapshot;
                .build()
        RemovalListener<ICacheKey<String>, String> removalListener,
        String storagePath = getStoragePath(settings);
            null,
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(
import org.opensearch.common.settings.Setting;
        List<Predicate<String>> diskPolicies,
            keyValueSize,
                .put(
        int numberOfSameKeys = randomIntBetween(400, onHeapCacheSize - 1);
                ).getKey(),
                return null;
        for (int i = 0; i < numberOfSegments; i++) {
            )
        assertEquals(2, tieredSpilloverCache.count());
        }
            assertNull(tieredSpilloverCache.getTieredCacheSegment(iCacheKey).getOnHeapCache().get(iCacheKey));
                ).getKey(),
import org.opensearch.core.tasks.TaskCancelledException;
        tieredSpilloverCache.invalidate(key);
        int numberOfTimesKeyLoaded = 0;
                    ).getKey(),
                .put(
                MockDiskCache.MockDiskCacheFactory.NAME
            ICacheKey<String> key = getICacheKey(UUID.randomUUID().toString());
            ICacheKey<String> key = getICacheKey(UUID.randomUUID().toString());
        }
        clusterSettings = new ClusterSettings(settings, new HashSet<>());
        for (int i = 0; i < numberOfSegments; i++) {
            boolean isLoaded = false;
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_DISK_STORE_SIZE.getConcreteSettingForNamespace(
    }
        Settings settings = Settings.builder()
        try (NodeEnvironment environment = newNodeEnvironment(settings)) {
        // Turn the disk cache back on in cluster settings for other tests
        return initializeTieredSpilloverCache(
            200
                    .build(),
            )
            .put(
        ICacheKey<String> key = getICacheKey(UUID.randomUUID().toString());
            .build();
                TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME
                new OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory(),
                Integer updatedValue = segmentSizeTracker.get(keySegment) + 1;
            numberOfSegments,
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
            tieredSpilloverCache.computeIfAbsent(key, loadAwareCacheLoader);
        assertEquals(0, getHitsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
            .setStoragePath(storagePath)
            )
            onHeapCacheSizeInBytes,
        List<Predicate<String>> diskPolicies,
            )
            new ImmutableCacheStats(0, 0, 0, 0, 0),
                Map.of(
        ICache.Factory onHeapCacheFactory = new OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory();
        when(mockDiskCacheFactory.create(any(), any(), any())).thenReturn(mockDiskCache);
        }
        assertEquals(onHeapCacheSize * keyValueSize, getSizeInBytesForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
                    } finally {
        assertEquals(numOfItems1, getMissesForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
    public void testComputeIfAbsentWithOnHeapCacheThrowingExceptionOnPut() throws Exception {
        // Default must never exceed the ceiling, even on hosts with many CPU cores.
        for (int i = 0; i < numOfItems; i++) {
            }
        // Now on a different thread, try to get key(above one which got evicted) from tiered cache. We expect this
        tieredSpilloverCache.tieredSpilloverCacheSegments[0].getOnHeapCache().keys().forEach(onHeapKeys::add);
        // Put values in cache more than it's size and cause evictions from onHeap.
        assertEquals(validDuration, concreteSetting.get(validSettings));
    }
            new OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory(),
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(
            removalListener,
            .setNumberOfSegments(1)
            String,
            String key = UUID.randomUUID().toString();
        assertEquals(
                    .setClusterSettings(clusterSettings)
        );
            int keySegment = tieredSpilloverCache.getSegmentNumber(key);
        int diskCacheSize = randomIntBetween(60, 100);
            countDownLatch.countDown();
                MockDiskCache.MockDiskCacheFactory.NAME,
            diskCacheSize,
        assertEquals(
            boolean isLoaded = false;
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(
import static org.opensearch.common.cache.settings.CacheSettings.VALID_SEGMENT_COUNT_VALUES;
            Settings.builder()
        }
    }
            }
            if (randomBoolean()) {
            Settings.builder()
        tieredSpilloverCache.tieredSpilloverCacheSegments[0].getDiskCache().keys().forEach(diskTierKeys::add);
        assertEquals(totalStats.getItems(), heapStats.getItems() + diskStats.getItems());
            false,
            .setCacheConfig(cacheConfig);
                    ).getKey(),
            onHeapCacheSize * keyValueSize,
                    tieredSpilloverCache.computeIfAbsent(key, loader);
            return new String(bytes, charset);
        long diskDeliberateDelay,
            diskTierKeys.add(key);
            .put(
        Settings settings = Settings.builder()
                .setSettings(settings)
        int onHeapCacheSize = randomIntBetween(300, 600);
        int diskCacheSize = tookTimeMap.size();
            .put(
            if (segmentSizeTracker.get(i) > perSegmentEntryCapacity.get(i)) {
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
        );
            0,
            keyValueSize
                        CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
        Map<Integer, Integer> segmentSizeTracker = new HashMap<>();
            .put(
        int numOfItems1 = randomIntBetween(onHeapCacheSize + 1, totalSize);
                CacheSettings.getConcreteStoreNameSettingForCacheType(CacheType.INDICES_REQUEST_CACHE).getKey(),
                    new TimeValue(cacheThresholdNanos / 1_000_000)
            @Override
                MockDiskCache.MockDiskCacheFactory.NAME,
            .put(
        Map<String, String> keyValueMap = Map.of("A", "a", "B", "b", "C", "c", "D", "d", "E", "e", "F", "f", "G", "g");
        List<LoadAwareCacheLoader<ICacheKey<String>, String>> loadAwareCacheLoaderList = new CopyOnWriteArrayList<>();
        // Put first key on tiered cache. Will go into onHeap cache.
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
            .setDiskCacheFactory(mockDiskCacheFactory)
            numberOfSegments
            }
            Settings.builder()
                onHeapCacheSize * keyValueSize + "b"
                    ).getKey(),
        assertTrue(totalStats.getMisses() > 0);
                OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME
import java.io.IOException;
        for (int i = 0; i < numberOfSegments; i++) {
                return UUID.randomUUID().toString();
            }
            boolean isLoaded = false;
        for (String key : keyValuePairs.keySet()) {
            )
            .put(
        int onHeapCacheSize = randomIntBetween(300, 600);
                .put(
        tookTimeMap.put("c", diskThresholdNanos * 3);
            // The size setting from the OpenSearchOnHeapCache implementation should not be honored
            .put(
        tookTimeMap.put("a", diskThresholdNanos);
        @Override
        LoadAwareCacheLoader<ICacheKey<String>, String> tieredCacheLoader = new LoadAwareCacheLoader<>() {
        int keyValueSize,
        // Also do some random hits
            0,
        Settings settings,
    // Duplicated here from EhcacheDiskCacheTests.java, we can't add a dependency on that plugin
            String result = tieredSpilloverCache.get(iCacheKey);
    }
        int diskCacheSize = randomIntBetween(200, 400);
        for (ICacheKey<String> key : diskTierKeys) {
                totalOnHeapEntries += expectedSegmentOnHeapCacheSize.get(i);
        );
                    ).getKey(),
        int numOfItems1 = randomIntBetween(onHeapCacheSize + 1, totalSize);
    private long getItemsForTier(TieredSpilloverCache<?, ?> tsc, String tierValue) throws IOException {
            .setOnHeapCacheSizeInBytes(onHeapCacheSizeInBytes)
                    new MockDiskCache.MockDiskCacheFactory(0, randomIntBetween(100, 300), false, keyValueSize)
        int approxNumHits = 30;
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
            policies,
        }
            "G",
        assertTrue(totalStats.getHits() > 0);
        ICacheKey<String> key = getICacheKey(UUID.randomUUID().toString());
            )
                .build(),
            }
                heapSizeFromImplSetting + "b"
            .build();
        int onHeapCacheSize = randomIntBetween(100, 300);
        Map<ICacheKey<String>, TieredSpilloverCache.TieredSpilloverCacheSegment<String, String>> tieredSpilloverCacheSegmentMap =
            true,
                        TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(
        // evicted to onDisk cache.
        return dims;
        List<ICacheKey<String>> onHeapCacheKeys = new ArrayList<>();
                    TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
        String response = "";
        for (int iter = 0; iter < numMisses; iter++) {
    }
            1,
                    .build()
import org.opensearch.common.cache.settings.CacheSettings;
                .put(TOOK_TIME_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE).getKey(), TimeValue.ZERO)
            ICacheKey<String> key = getICacheKey(UUID.randomUUID().toString());
        int keyValueSize = 50;
    }
                new MockDiskCache.MockDiskCacheFactory(0, randomIntBetween(100, 300), false, keyValueSize)
        Settings settings = Settings.builder()
                assertNull(result);
                ).getKey(),
        ICache.Factory onHeapCacheFactory = mock(OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.class);
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(
                        CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
            } catch (StringIndexOutOfBoundsException e) {
        }
        TieredSpilloverCache<String, String> tieredSpilloverCache = (TieredSpilloverCache<
            .put(
        int keyValueSize = 50;
            }
                TIERED_SPILLOVER_SEGMENTS.getConcreteSettingForNamespace(CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()).getKey(),
                        tieredSpilloverCache.computeIfAbsent(iCacheKey, loader);
        Map<Integer, Integer> expectedSegmentOnHeapCacheSize = getSegmentOnHeapCacheSize(
        assertEquals(0, getEvictionsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
            ICacheKey<String> iCacheKey = getICacheKey(key);
        clusterSettings.registerSetting(TOOK_TIME_DISK_TIER_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE));
        List<ICacheKey<String>> actualOnHeapKeys = new ArrayList<>();
        assertEquals(totalStats.getEvictions(), diskStats.getEvictions());
            removalListener,
        Thread thread1 = new Thread(() -> {
            numberOfSegments
        ImmutableCacheStats totalStats = tieredSpilloverCache.stats().getTotalStats();
            // dimensions yet
                TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME
        ICache.Factory onHeapCacheFactory = new OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory();
        int keyValueSize = 50;
            .setDiskCacheFactory(mockDiskCacheFactory)
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
                    .setValueSerializer(new StringSerializer())
                        CacheSettings.getConcreteStoreNameSettingForCacheType(CacheType.INDICES_REQUEST_CACHE).getKey(),
        int keyValueSize = 1;
        int diskCacheSize = randomIntBetween(300, 500);
                ).getKey(),
import org.opensearch.common.settings.ClusterSettings;
        );
            true,
                onHeapCacheSize * keyValueSize + "b"
            )
                tieredSpilloverCache,
        Settings settings = Settings.builder()
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_DISK_STORE_NAME.getConcreteSettingForNamespace(
        Map<Integer, Integer> mockDiskCacheExpectedSize = getSegmentMockDiskCacheSize(numberOfSegments, diskCacheSize);
            removalListener,
            onHeapCacheFactory,
            ICacheKey<String> key = getICacheKey(UUID.randomUUID().toString());
        int onHeapCacheSize = 10;
            null,
        tieredSpilloverCache.invalidateAll(); // Clear up all the keys.
            @Override
            tieredSpilloverCache.computeIfAbsent(newKeyList.get(i), getLoadAwareCacheLoader());
        assertEquals(
        long expectedDiskSize = MIN_DISK_CACHE_SIZE_IN_BYTES + 256L * between(30, 40);
        // should always be respected, overriding the individual implementation's size settings if present
            expectedHeapSize,
        RemovalListener<ICacheKey<String>, String> removalListener,
    class MockCacheRemovalListener<K, V> implements RemovalListener<ICacheKey<K>, V> {
            )
                .put(
            diskDeliberateDelay,
            keyValueSize
            )
            assertNotNull(tieredSpilloverCache.get(key));
        }
                expectedNumberOfEntriesInSegment.put(keySegment, Integer.valueOf(1));
            .put(
        for (int j = 0; j < numberOfKeys; j++) {
        for (String key : keyValuePairs.keySet()) {
        assertEquals(numberOfSameKeys - 1, getHitsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
            removalListener,
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
            mockDiskCacheFactory,
    }
    public void testGetAndCount() throws Exception {
            cacheMiss++;
            numberOfSegments
            assertEquals("Query cancelled!", ex.getCause().getMessage());
            }
        }
                MockDiskCache.MockDiskCacheFactory.NAME
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(
                ).getKey(),
            .put(TIERED_SPILLOVER_SEGMENTS.getConcreteSettingForNamespace(CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()).getKey(), 1)
                CacheType.INDICES_REQUEST_CACHE,
            .setSettings(
                CacheType.INDICES_REQUEST_CACHE,
            // The boolean here is not needed, just to fit with the get loader method
                        CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
            LoadAwareCacheLoader<ICacheKey<String>, String> loadAwareCacheLoader = getLoadAwareCacheLoader();
            Map.of(
                diskTierKeys.add(key);
    public void testInvalidate() throws Exception {
        assertTrue(onHeapCacheKeys.contains(key2));
                )
        assertEquals(cacheMiss + numOfItems1, getMissesForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
        assertEquals(0, removalListener.evictionsMetric.count());
        int numberOfSegments = getNumberOfSegments();
    public void testDefaultSegmentsCappedAtCeiling() {
    public void testComputeIfAbsentWithEvictionsFromTieredCache() throws Exception {
                cacheHit++;
        ImmutableCacheStatsHolder cacheStats = tsc.stats(levels);
                ).getKey(),
        List<ICacheKey<String>> iCacheKeyList = new ArrayList<>();
            tieredSpilloverCache.computeIfAbsent(key, tieredCacheLoader);
            0,
            keyValueSize,
                    .setKeySerializer(new StringSerializer())
        LoadAwareCacheLoader<ICacheKey<String>, String> loader = getLoadAwareCacheLoader(keyValuePairs);
        }
            removalListener,
        );
        tieredSpilloverCache.enableDisableDiskCache(false); // Disable disk cache now.
    }
        // First try to invalidate without the key present in cache.
            false,
        Map<String, Tuple<String, Boolean>> loaderMap = new HashMap<>();
        assertEquals(0, getEvictionsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK)); // Disk tier is large enough for no evictions
            diskCacheSize,
        Iterable<ICacheKey<String>> mergedIterable = tieredSpilloverCache.keys();
                .setStoragePath(storagePath)
        // Put another key/value so that one of the item is evicted to disk cache.
            }
        };
                numSegments
            diskCacheSize,
                isLoaded = true;
                ).getKey(),
import static org.opensearch.cache.common.tier.TieredSpilloverCacheSettings.MIN_DISK_CACHE_SIZE_IN_BYTES;
                )
            expectedDiskSize
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
        int keyValueSize,
        int numOfItems2 = totalSize - numOfItems1;
        for (int i = 0; i < numberOfSegments; i++) {
            if (tieredSpilloverCache.tieredSpilloverCacheSegments[keySegment].getOnHeapCache().count() >= onHeapExpectedSize.get(
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
        Map<Integer, Integer> mockDiskCacheExpectedSize = getSegmentMockDiskCacheSize(numberOfSegments, diskCacheSize);
                CacheSettings.getConcreteStoreNameSettingForCacheType(CacheType.INDICES_REQUEST_CACHE).getKey(),
            diskCacheSize,
        }
import java.util.concurrent.ExecutorService;
            )
        ICacheKey<String> key = getICacheKey(UUID.randomUUID().toString());
        return new Tuple<>(policies, keyValuePairs);
                    ).getKey(),
            1
            Settings.builder().put(DISK_CACHE_ENABLED_SETTING_MAP.get(CacheType.INDICES_REQUEST_CACHE).getKey(), true).build()
            Settings.builder()
            assertNull(tieredSpilloverCache.get(diskKey)); // Considering disk cache is disabled, we shouldn't find
    }
    }
                .setCachedResultParser(new Function<String, CachedQueryResult.PolicyValues>() {
            0,
            .put(
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
            numberOfSegments,
        assertEquals(numOfItems1, getMissesForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
        assertTrue("default segments must be a valid (power-of-two) count", VALID_SEGMENT_COUNT_VALUES.contains(segments));
        value = tieredSpilloverCache.computeIfAbsent(getICacheKey("test"), new LoadAwareCacheLoader<>() {
        thread1.start();
         * totalEvictions = diskEvictions
        List<Predicate<String>> policies,
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
    }
        Settings settings = Settings.builder()
                    .setWeigher((k, v) -> keyValueSize)
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
        LoadAwareCacheLoader<ICacheKey<String>, String> loader = getLoadAwareCacheLoader(loaderMap);
            "B",
    }
                new OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory(),
            }
                } catch (Exception e) {
        RemovalListener<ICacheKey<String>, String> removalListener,
        } catch (IOException e) {
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
                CacheType.INDICES_REQUEST_CACHE,
            tieredSpilloverCache.computeIfAbsent(key, tieredCacheLoader);
            true,
        }
                        public String load(ICacheKey<String> key) {
        String value = UUID.randomUUID().toString();
        int diskCacheSize = 10;
            onHeapCacheFactory,
                LoadAwareCacheLoader<ICacheKey<String>, String> loadAwareCacheLoader = getLoadAwareCacheLoader();
        if (diskPolicies != null) {
                    assertEquals(ExecutionException.class, e.getClass());
        int numMisses = onHeapCacheSize + diskCacheSize + randomIntBetween(10, 20);
                        onHeapCacheSize * keyValueSize + "b"
            if (expectedOutput) {
    }
        Settings belowThresholdSettings = Settings.builder().put(concreteSetting.getKey(), TimeValue.MINUS_ONE).build();
        Settings settings = Settings.builder()
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(
        // Clear up disk cache keys.
            .put(
        // the response.
        Map<Integer, Integer> perSegmentEntryCapacity = new HashMap<>();
        }
        });
 * this file be licensed under the Apache-2.0 license or a
            ex.getMessage(),
        int keyValueSize = 50;
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
            .put(
                .put(DISK_CACHE_ENABLED_SETTING_MAP.get(CacheType.INDICES_REQUEST_CACHE).getKey(), false)
                    .setDimensionNames(dimensionNames)
        int diskCacheSize = randomIntBetween(700, 1200);
                    new OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory(),
    }
        ImmutableCacheStats snapshot = cacheStats.getStatsForDimensionValues(mockDimensions);
        countDownLatch.await(); // Wait for rest of tasks to be cancelled.
            @Override
            1
            assertTrue(newKeyList.contains(actualOnHeapCacheKeys.get(i)));
                Settings.builder()
        assertEquals(newKeyList.size(), actualOnHeapCacheKeys.size());
        checkSegmentSizes(tieredSpilloverCache, expectedHeapSize, expectedDiskSize);
                            }
        // Also check the heap stats don't have zero misses or evictions
            @Override
        }
                .setSegmentCount(numberOfSegments)
        int expectedEvictions = 0;
                    phaser.arriveAndAwaitAdvance();
                    .setStoragePath(storagePath)
            }
            "F",
                    TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
        }
        for (int iter = 0; iter < numOfItems1; iter++) {
import static org.opensearch.cache.common.tier.TieredSpilloverCache.ZERO_SEGMENT_COUNT_EXCEPTION_MESSAGE;
                } catch (Exception e) {
            Settings.builder()
            } else { // Hit cache with key stored in disk cache.
                        OpenSearchOnHeapCacheSettings.getSettingListForCacheType(CacheType.INDICES_REQUEST_CACHE)
                }
                ).getKey(),
        // Again invalidate older key, leaving one in heap tier and zero in disk tier
            1,
        );
                .setValueSerializer(new StringSerializer())
            actualTieredCacheCount
            }
                    onHeapCacheSize * keyValueSize + "b"
        }
        int keyValueSize = 50;
                .build(),
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
            }
        }
    private int getNumberOfSegments() {
        assertEquals(1, getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
        expectedMergedKeys.addAll(onHeapKeys);
    private CacheConfig<String, String> getCacheConfig(
        int onHeapCacheSize = randomIntBetween(10, 30);
        CacheConfig<String, String> cacheConfig = getCacheConfig(keyValueSize, settings, removalListener, 1);
                .setValueSerializer(new StringSerializer())
                tieredSpilloverCache.computeIfAbsent(keys.get(index), getLoadAwareCacheLoader());
        assertEquals(1, getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
            }
        assertEquals("key1", tieredSpilloverCache.get(key1));
            diskCacheSize,
        );
            }
            1
            diskCacheSize,
        // Mock took time by passing this map to the policy info wrapper fn
        int numberOfSegments = 1;
        long diskCacheSize
        public boolean equals(String object, byte[] bytes) {
        assertEquals(
            0,
                MockDiskCache.MockDiskCacheFactory.NAME
            removalListener,
        List<ICacheKey<String>> expectedMergedKeys = new ArrayList<>();
            } else {
        }
                        CacheSettings.getConcreteStoreNameSettingForCacheType(CacheType.INDICES_REQUEST_CACHE).getKey(),
            @Override
                // Values will always appear to have taken 2x the took time threshold to compute, so they will be admitted
    }
        assertEquals(0, getEvictionsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
                    OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME,
            1
            new CacheConfig.Builder<String, String>().setKeyType(String.class)
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
            .put(
                )
        ICache.Factory onHeapCacheFactory = new OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory();
                .setCachedResultParser(s -> new CachedQueryResult.PolicyValues(DEFAULT_TOOK_TIME_DISK_THRESHOLD.getNanos() * 2))
        LoadAwareCacheLoader<ICacheKey<String>, String> loader,
                .setDimensionNames(dimensionNames)
            tieredSpilloverCache.computeIfAbsent(getICacheKey(UUID.randomUUID().toString()), getLoadAwareCacheLoader());
            diskCacheSize,
        TieredSpilloverCache.TieredSpilloverCacheSegment<String, String> segment = cache.tieredSpilloverCacheSegments[0];
            0,
    private Tuple<List<Predicate<String>>, Map<String, Tuple<String, Boolean>>> setupPoliciesTest() {
    }
            throw new OpenSearchException("Exception occurred", e);
                    )
            50,
        int numRepetitionsPerKey = 10;
                new MockDiskCache.MockDiskCacheFactory(0, randomIntBetween(100, 300), false, keyValueSize)
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
            numberOfSegments
                    TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
        int keyValueSize = 20;
                ).getKey(),
        List<ICacheKey<String>> diskKeys = new ArrayList<>();
        int onHeapCacheSize = 10;
                ).getKey(),
            boolean isLoaded = false;
                TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME
        int onHeapCacheSize = randomIntBetween(10, 30);
                    ).getKey(),
            LoadAwareCacheLoader<ICacheKey<String>, String> tieredCacheLoader = getLoadAwareCacheLoader();
        });
        tookTimeMap.put("d", null);
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(
                .setStoragePath(storagePath)
        // Verify on heap cache stats.
                expectedHeapSize + "b"
            diskCacheSize,
    }
                new CacheConfig.Builder<String, String>().setKeyType(String.class)
        Settings settings = Settings.builder()
    }
            if (segmentSizeTracker.get(keySegment) == null) {
    public void testConcurrencyForEvictionFlowFromOnHeapToDiskTier() throws Exception {
            .put(
        // do some gets to put entries in both tiers
        // Since all the keys have the same dimension values, except tiers, we only need to remove that one, and we expect all stats values
        );
        final CounterMetric evictionsMetric = new CounterMetric();
            removalListener,
            onHeapCacheSize * keyValueSize,
        for (String key : keyValuePairs.keySet()) {
        tieredSpilloverCache.computeIfAbsent(getICacheKey("test1"), new LoadAwareCacheLoader<>() {
    }
                OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME,
                            return isLoaded;
        List<ICacheKey<String>> actualOnHeapCacheKeys = new ArrayList<>();
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
            .setKeyType(String.class)
    private long getEvictionsForTier(TieredSpilloverCache<?, ?> tsc, String tierValue) throws IOException {
        }
                    .setRemovalListener(removalListener)
        );
        String expectedRespone = "Cool response!";
            CacheType.INDICES_REQUEST_CACHE,
                    new TimeValue(diskThresholdNanos / 1_000_000)
        List<ICacheKey<String>> newKeyList = new ArrayList<>();
            .put(
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_DISK_STORE_NAME.getConcreteSettingForNamespace(
            removalListener,
            tieredSpilloverCache.tieredSpilloverCacheSegments;
import java.util.concurrent.ExecutionException;
            .put(
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
            } else {
        int numSegments = getNumberOfSegments();
                OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME
                ).getKey(),
            public boolean isLoaded() {
        for (int iter = 0; iter < numOfItems1; iter++) {
                .put(
                CacheSettings.getConcreteStoreNameSettingForCacheType(CacheType.INDICES_REQUEST_CACHE).getKey(),
        int numberOfSegments = getNumberOfSegments();
            "No associated diskCache found for tieredSpilloverCache for " + "cacheType:" + CacheType.INDICES_REQUEST_CACHE
                1L
        assertTrue(onHeapCacheKeys.contains(key2));
            Settings.builder()
                ).getKey(),
import org.opensearch.common.cache.RemovalListener;
        int onHeapCacheSize = randomIntBetween(10, 30);
        ICache.Factory diskCacheFactory = new MockDiskCache.MockDiskCacheFactory(500, diskCacheSize, false, 1);
        Map<Integer, Integer> segmentSizeTracker = new HashMap<>();
        );
        assertEquals(0, getHitsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
        int onHeapCacheSize = randomIntBetween(300, 600);
            .build();
        assertEquals(0, getEvictionsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
                .put(
            0,
        assertEquals(getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP), tieredSpilloverCache.onHeapCacheCount()); // Should
import static org.opensearch.cache.common.tier.TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE;
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(
        Settings settings = Settings.builder()
            )
        );
        );
    }
                removalListener,
        int numMisses = onHeapCacheSize + diskCacheSize + randomIntBetween(minMisses, minMisses + 50);
            .build();
                    keyValueSize * keyValuePairs.size() + 1 + "b"
        assertEquals(0, tieredSpilloverCache.count());
            // These two size settings should be honored
        mergedIterable.iterator().forEachRemaining(actualMergedKeys::add);
        phaser.arriveAndAwaitAdvance();
import static org.opensearch.cache.common.tier.TieredSpilloverCacheSettings.DISK_CACHE_ENABLED_SETTING_MAP;
    }
        String storagePath = getStoragePath(settings);
        LoadAwareCacheLoader<ICacheKey<String>, String> loader = getLoadAwareCacheLoader(keyValuePairs);
            .put(
        keyValuePairs.put("key4", new Tuple<>("ab", true));
        for (int i = 0; i < numberOfSegments; i++) {
                        throw new RuntimeException(e);
        tieredSpilloverCache.invalidate(key);
            CacheType.INDICES_REQUEST_CACHE,
                    new MockDiskCache.MockDiskCacheFactory(0, randomIntBetween(100, 300), false, keyValueSize)
        if (snapshot == null) {
                onHeapCacheSize * keyValueSize + "b"
        }
                    TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
            Settings.builder()
                        CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
        assertNotNull(actualValue.get());
                CacheSettings.getConcreteStoreNameSettingForCacheType(CacheType.INDICES_REQUEST_CACHE).getKey(),
        assertEquals(expectedKeys, getMissesForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
        int onHeapCacheSize = 10;
            removalListener,
                        CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
                    ).getKey(),
        return getStatsSnapshotForTier(tsc, tierValue).getSizeInBytes();
            threads[i].start();
            .build();
        int diskCacheSize = randomIntBetween(700, 1200);
                ).getKey(),
        int keyValueSize = 50;
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_DISK_STORE_NAME.getConcreteSettingForNamespace(
        assertEquals(getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP), tieredSpilloverCache.onHeapCacheCount());
            removalListener,
        }
            diskPolicies,
        for (int iter = 0; iter < numOfItems; iter++) {
        countDownLatch.await();
        CacheConfig<String, String> cacheConfig = new CacheConfig.Builder<String, String>().setKeyType(String.class)
            .put(
        int diskCacheSize = randomIntBetween(600, 700);
                segmentSizeTracker.put(keySegment, Integer.valueOf(1));
                ).getKey(),
            onHeapCacheSize * keyValueSize,
        String value = "";
        CacheConfig<String, String> cacheConfig = new CacheConfig.Builder<String, String>().setKeyType(String.class)
            if (expectedNumberOfEntriesInSegment.get(i) == null) {
        // We now calculate expected onHeap cache entries and then verify it later.
                if (mapValue == null) {
                heapSizeFromImplSetting + "b"
                // Values will always appear to have taken 2x the took time threshold to compute, so they will be admitted
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
import static org.opensearch.cache.common.tier.TieredSpilloverCacheSettings.TOOK_TIME_DISK_TIER_POLICY_CONCRETE_SETTINGS_MAP;
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
        for (int i = 0; i < numberOfKeys; i++) {
        assertThrows(
        long cacheThresholdNanos = 2_000_000L;
        Map<Integer, Integer> expectedSegmentDiskCacheSize = new HashMap<>();
                    LoadAwareCacheLoader<ICacheKey<String>, String> loadAwareCacheLoader = new LoadAwareCacheLoader<>() {
        }
        }
        tieredSpilloverCache.put(key, value);
            new HashMap<>();
    public void testSegmentSizesWhenUsingFactory() {
        // skewness as well.
        assertEquals(getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK), actualDiskCacheCount);
                    .setRemovalListener(removalListener)
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(
            expectedSegmentOnHeapCacheSize.put(i, perSegmentOnHeapCacheEntries);
                )
            try {
            Boolean expectedOutput = keyValuePairs.get(key).v2();
        // These should be added to the totals, as the disk tier is now absent
        TieredSpilloverCache<String, String> tieredSpilloverCache = (TieredSpilloverCache<String, String>) tieredSpilloverICache;
        // cache
                .put(
                tieredSpilloverCache.computeIfAbsent(onHeapKeys.get(index), loadAwareCacheLoader);
                countDownLatch1.countDown();
                .setWeigher((k, v) -> keyValueSize)
        assertEquals(onHeapCacheSize, getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
        );
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
                MockDiskCache.MockDiskCacheFactory.NAME
                        CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
        Settings settings,
            removalListener,
                    new MockDiskCache.MockDiskCacheFactory(0, randomIntBetween(100, 300), false, keyValueSize)
            int keySegment = tieredSpilloverCache.getSegmentNumber(iCacheKey);
        // Now try to invalidate with the key present in onHeap cache.
        );
            String>) new TieredSpilloverCache.TieredSpilloverCacheFactory().create(
import org.opensearch.common.cache.CacheType;
        assertEquals(1, onHeapCacheKeys.size());
    }
                .build(),
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
            boolean isLoaded = false;
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_DISK_STORE_NAME.getConcreteSettingForNamespace(
                        }
                    .setClusterSettings(clusterSettings)
            IllegalArgumentException.class,
        int onHeapCacheSize = randomIntBetween(300, 500) * numberOfSegments; // Able to support all keys in case of
        long onHeapCacheSizeInBytes = TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
        tieredSpilloverCache.tieredSpilloverCacheSegments[0].getOnHeapCache().keys().forEach(onHeapCacheKeys::add);
            removalListener,
        Settings settings = Settings.builder()
            .setStoragePath(storagePath)
            cacheConfig,
            0,
        assertEquals(expectedDiskEntries * keyValueSize, getSizeInBytesForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
        List<Predicate<String>> diskPolicies,
import org.opensearch.common.cache.store.config.CacheConfig;
        int heapSizeFromImplSetting = 50;
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
        ArrayList<Predicate<String>> policies = new ArrayList<>();
            settings,
                new CacheConfig.Builder<String, String>().setKeyType(String.class)
                onHeapCacheSize * keyValueSize + "b"
                    .setKeyType(String.class)
        assertTrue(VALID_SEGMENT_COUNT_VALUES.contains(tieredSpilloverCache.getNumberOfSegments()));
            1
            .build();
                    .setClusterSettings(clusterSettings)
        assertEquals(1, getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
            .setRemovalListener(removalListener)
        assertEquals(numberOfSameKeys, exceptionCount.get());
        assertEquals(1, getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
                ).getKey(),
            tieredSpilloverCache.computeIfAbsent(key, getLoadAwareCacheLoader());
        } catch (IOException e) {
        }
        @Override
            tieredSpilloverCache.computeIfAbsent(key, loadAwareCacheLoader);
            });
            }
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
                )
                new OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory(),
        phaser.arriveAndAwaitAdvance();
            .put(
            keyValueSize,
        int expectedEvictions = 0;
                        public boolean isLoaded() {
        TieredSpilloverCache<String, String> tieredSpilloverCache = getTieredSpilloverCache(
        int totalOnHeapEntries = 0;
            int finalJ = j;
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(
            public String load(ICacheKey<String> key) {
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
            "B",
                return expectedRespone;
                .setStoragePath(getStoragePath(settings))
        for (ICacheKey<String> onHeapKey : onHeapKeys) {
            ZERO_SEGMENT_COUNT_EXCEPTION_MESSAGE,
        tieredSpilloverCache.put(key1, "dummy");
                        CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
                assertEquals(keyValuePairs.get(key).v1(), result);
            .setKeyType(String.class)
        Map<Integer, Integer> onHeapExpectedSize = getSegmentOnHeapCacheSize(
        Settings settings,
    }
            keyValueSize,
        // any more items.
            .setClusterSettings(clusterSettings)
                    .setRemovalListener(removalListener)
        String value = UUID.randomUUID().toString();
                OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME
                    } catch (Exception e) {
                .put(
        int keyValueSize = 50;
            LoadAwareCacheLoader<ICacheKey<String>, String> loader = loadAwareCacheLoaderList.get(i);
                    ).getKey(),
                numberOfSegments
                segmentSizeTracker.put(keySegment, updatedValue);
                        phaser.arriveAndAwaitAdvance();
    public void testInvalidateAll() throws Exception {
    }
        for (ICacheKey<String> diskKey : diskCacheKeys) {
                    TOOK_TIME_DISK_TIER_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE).getKey(),
            }
                OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME
        CacheConfig<String, String> cacheConfig = getCacheConfig(keyValueSize, settings, removalListener, 1);
        int keyValueSize = 50;
        if (policies != null) {
            if (expectedInCache) {
            tieredSpilloverCache.computeIfAbsent(getICacheKey(key), tieredCacheLoader);
        ICacheKey<String> keyToBeEvicted = getICacheKey("key1");
        assertEquals(0, getHitsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
import org.opensearch.common.cache.LoadAwareCacheLoader;
        assertEquals(totalOnDiskEntries * keyValueSize, getSizeInBytesForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
                TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME
                .setSettings(settings)
                .build(),
                        ICacheKey<String> iCacheKey = getICacheKey(key);
                    }
            .setWeigher((k, v) -> keyValueSize)
        for (int i = 0; i < loadAwareCacheLoaderList.size(); i++) {
            .build();
        }
            1
        Settings settings = Settings.builder()
        return getStatsSnapshotForTier(tsc, tierValue).getHits();
}
        // Considering onHeap cache was already full, we should have some onHeap entries being evicted.
        assertEquals(0, getHitsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
            0,
                ).getKey(),
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
        int numberOfSegments
        return cacheStats.getStatsForDimensionValues(List.of());
    private void checkSegmentSizes(TieredSpilloverCache<String, String> cache, long expectedHeapSize, long expectedDiskSize) {
                CacheSettings.getConcreteStoreNameSettingForCacheType(CacheType.INDICES_REQUEST_CACHE).getKey(),
import java.util.UUID;
            tieredSpilloverCache.computeIfAbsent(key, loadAwareCacheLoader);
                onHeapCacheSize * keyValueSize + "b"
            0,
            for (int j = 0; j < numRepetitionsPerKey; j++) {
                .put(
            public String load(ICacheKey<String> key) {
                    .setWeigher((k, v) -> keyValueSize)
        for (int iter = 0; iter < numOfItems1; iter++) {
                    new MockDiskCache.MockDiskCacheFactory(0, diskSizeFromImplSetting, false, keyValueSize)
        assertNotEquals(new ImmutableCacheStats(0, 0, 0, 0, 0), tieredSpilloverCache.stats().getTotalStats());
    }
        int expectedKeys = 0;
        }
                try {
        assertNotEquals(0, heapStats.getEvictions());
        assertEquals(expectedMergedKeys.size(), actualMergedKeys.size());
        assertEquals(totalStats.getSizeInBytes(), heapStats.getSizeInBytes() + diskStats.getSizeInBytes());
                CacheSettings.getConcreteStoreNameSettingForCacheType(CacheType.INDICES_REQUEST_CACHE).getKey(),
                CacheType.INDICES_REQUEST_CACHE,
            )
            Settings.builder()
            Settings.builder()
                    .setClusterSettings(clusterSettings)
            diskCacheSize,
        // Now the original keys should be in the disk tier if the policy allows them, or misses if not
        );
            }
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
                        @Override
            Map.of(
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
                                isLoaded = true;
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
            keyValueSize,
            1
                tieredSpilloverCache,
        assertEquals(totalOnHeapEntries, tieredSpilloverCache.onHeapCacheCount());
        ICache.Factory mockDiskCacheFactory = mock(MockDiskCache.MockDiskCacheFactory.class);
            tieredSpilloverCache.count()
            .setSettings(settings)
        ICache<String, String> tieredSpilloverICache = new TieredSpilloverCache.TieredSpilloverCacheFactory().create(
                new CacheConfig.Builder<String, String>().setKeyType(String.class)
        List<ICacheKey<String>> onHeapKeys = new ArrayList<>();
        Map<Integer, Integer> expectedNumberOfEntriesInSegment = new HashMap<>();
        // We will call computeIfAbsent again with the same key, but this time the underlying loader should run fine and we should get back
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_NAME.getConcreteSettingForNamespace(
    static final List<String> dimensionNames = List.of("dim1", "dim2", "dim3");
            Boolean expectedOutput = keyValuePairs.get(key).v2();
        String storagePath;
        int keyValueSize = 50;
                // Should retrieve from disk tier if it was accepted
                    .build(),
        int numberOfSegments = getNumberOfSegments();
        List<ICacheKey<String>> diskCacheKeys = new ArrayList<>();
            .build();
        ImmutableCacheStats diskStats = getStatsSnapshotForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK);
            .put(TIERED_SPILLOVER_SEGMENTS.getConcreteSettingForNamespace(CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()).getKey(), 1)
            removalListener,
        int keyValueSize = 1;
        assertEquals(0, getEvictionsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
        tieredSpilloverCache.getDiskCacheKeys().forEach(diskCacheKeys::add);
        String value = UUID.randomUUID().toString();
        onHeapCacheKeys.clear();
                    .setKeyType(String.class)
            Boolean expectedInCache = keyValuePairs.get(key).v2();
            keyValueSize,
        }
            .put(
            diskCacheSize,
            .setSettings(settings)
        // We should have (numRepetitionsPerKey - 1) * (expectedKeys) hits
            @Override
        int cacheHit = 0;
            keyValueSize,
        ImmutableCacheStats totalStats = tieredSpilloverCache.stats().getTotalStats();
        tieredSpilloverCache.getOnHeapCacheKeys().forEach(onHeapKeys::add);
        }
        return expectedSegmentDiskCacheSize;
        int numberOfSegments = getNumberOfSegments();
            .setWeigher((k, v) -> 150)
                continue;
    public void testTieredCacheThrowingExceptionOnPerSegmentSizeBeingZero() {
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(
    }
            )
            .build();
        int numberOfSegments = getNumberOfSegments();
            .setValueSerializer(new StringSerializer())
        Phaser phaser = new Phaser(numThreads + 1);
        assertEquals(numOfItems1 + cacheMiss, getMissesForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
            false,
                )
            .build();
            )
            .setCacheConfig(cacheConfig)
                    onHeapCacheSize * keyValueSize + "b"
        // Put values in cache more than it's size and cause evictions from onHeap.
    @Before
    public void testEntryPoliciesConcurrentlyWithComputeIfAbsent() throws Exception {
        }
            randomIntBetween(1, 4),
                // Should miss as heap tier size = 0 and the policy rejected it
                TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME
                )
        Settings settings = Settings.EMPTY;
        when(onHeapCacheFactory.create(any(), any(), any())).thenReturn(mockOnHeapCache);
            .put(
            }
        LoadAwareCacheLoader<ICacheKey<String>, String> tieredCacheLoaderWithNoException = new LoadAwareCacheLoader<>() {
    }
        private final Charset charset = StandardCharsets.UTF_8;
    }
        }
                    OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME,
        CacheConfig<String, String> cacheConfig = getCacheConfig(1, settings, removalListener, numSegments);
        );
            int keySegment = tieredSpilloverCache.getSegmentNumber(iCacheKey);
                    TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
            .setDimensionNames(dimensionNames)
            .put(
        assertNotNull(tieredSpilloverCache.getTieredCacheSegment(keyToBeEvicted).getDiskCache().get(keyToBeEvicted));
    ) {
                )
        for (int i = 0; i < actualOnHeapCacheKeys.size(); i++) {
        assertEquals(0, getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
        Map<String, Tuple<String, Boolean>> keyValuePairs = setupTuple.v2();
            null,
            diskDeliberateDelay,
        CountDownLatch countDownLatch = new CountDownLatch(numThreads);
    public void testTierStatsAddCorrectly() throws Exception {
                        CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
        int diskCacheSize = randomIntBetween(700, 1200);
            } else {
            null,
    public void testMinimumThresholdSettingValue() throws Exception {
            removalListener,
        int diskCacheSize = randomIntBetween(60, 100);
        expectedMergedKeys.addAll(diskTierKeys);
        /* We expect the total stats to be:
        // after which it eviction flow is guaranteed to occur.
        List<ICacheKey<String>> keys = new ArrayList<>();
        tieredSpilloverCache.put(key, value);
        )
                    .build(),
                )
        for (int i = 0; i < numberOfSameKeys; i++) {
            .put(
            @Override
            )
            .setRemovalListener(removalListener)
                .setCachedResultParser(s -> new CachedQueryResult.PolicyValues(DEFAULT_TOOK_TIME_DISK_THRESHOLD.getNanos() * 2))
        ICache.Factory mockDiskCacheFactory = new MockDiskCache.MockDiskCacheFactory(0, diskCacheSize, false, keyValueSize);
            "C",
            removalListener,
import java.util.concurrent.Executors;
            .setDimensionNames(dimensionNames)
                .put(
        // Verify on heap cache stats.
import org.opensearch.common.cache.serializer.Serializer;
            )
    private String getStoragePath(Settings settings) {
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
        long actualTieredCacheCount = tieredSpilloverCache.count();
import org.opensearch.common.unit.TimeValue;
                numberOfTimesKeyLoaded++;
        int diskCacheSize = randomIntBetween(700, 1200);
                    onHeapCacheSize * keyValueSize + "b"
import org.opensearch.common.cache.policy.CachedQueryResult;
                )
import org.opensearch.common.cache.store.settings.OpenSearchOnHeapCacheSettings;
        List<ICacheKey<String>> onHeapKeys = new ArrayList<>();
                                                                                                                                    // remain
            .put(
        levelsList.add(TIER_DIMENSION_NAME);
            Settings.builder()
        Settings settings,
        );
        assertNotEquals(0, heapStats.getMisses());
            keyValueSize,
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
        assertEquals(
        List<ICacheKey<String>> diskTierKeys = new ArrayList<>();
import java.util.ArrayList;
            .setClusterSettings(clusterSettings)
    }
        Tuple<List<Predicate<String>>, Map<String, Tuple<String, Boolean>>> setupTuple = setupPoliciesTest();
        }
        Settings settings = Settings.builder()
                    TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
import org.opensearch.common.cache.store.OpenSearchOnHeapCache;
                builder.addPolicy(policy);
                    keyValueSize * keyValuePairs.size() + 1 + "b"
        // Verify that new items are part of onHeap cache.
            throw new OpenSearchException("Exception occurred", e);
                return isLoaded;
            .build();
            @Override
    }
                    TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
            usedKeys.add(key);
            @Override
            ICacheKey<String> key = usedKeys.get(rand.nextInt(usedKeys.size()));
            @Override
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
                    ).getKey(),
        int keyValueSize = 12;
                    .setStoragePath(storagePath)
                keyValueSize,
                    MockDiskCache.MockDiskCacheFactory.NAME,
        }
                )
        for (int iter = 0; iter < numOfItems2; iter++) {
        for (int iter = 0; iter < numOfItems1; iter++) {
        for (int i = 0; i < approxNumHits; i++) {
            int perSegmentDiskCacheEntries = diskCacheSize / numberOfSegments;
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
                    new OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory(),
        for (String key : keyValueMap.keySet()) {
        return initializeTieredSpilloverCache(
                ).getKey(),
        dropDimensionsKey.setDropStatsForDimensions(true);
        int onHeapCacheSize = randomIntBetween(10, 30);
    ) {
                })
    private ImmutableCacheStats getStatsSnapshotForTier(TieredSpilloverCache<?, ?> tsc, String tierValue) throws IOException {
        assertTrue(totalStats.getEvictions() > 0);
        int cacheMiss = 0;
            numberOfSegments
        doThrow(new RuntimeException("Testing")).when(mockOnHeapCache).put(any(), any());
            tieredSpilloverCache.put(iCacheKey, keyValuePairs.get(key).v1());
                assertNull(computedValue);
                // Should retrieve from heap tier if it was accepted
        long missesBeforeDisablingDiskCache = totalStats.getMisses();
                        onHeapCacheSize * keyValueSize + "b"
    public void testCacheKeys() throws Exception {
                    onHeapCacheSize * keyValueSize + "b"
        // Set the desired settings needed to create a TieredSpilloverCache object with INDICES_REQUEST_CACHE cacheType.
        int numberOfKeys = 20;
        TieredSpilloverCache<String, String> tieredSpilloverCache = getTieredSpilloverCache(
            .build();
                ).getKey(),
    private void verifyComputeIfAbsentThrowsException(
        int diskCacheSize = randomIntBetween(60, 100);
                    exceptionCount.incrementAndGet();
            "D",
                CacheSettings.getConcreteStoreNameSettingForCacheType(CacheType.INDICES_REQUEST_CACHE).getKey(),
            }
            LoadAwareCacheLoader<ICacheKey<String>, String> loadAwareCacheLoader = getLoadAwareCacheLoader();
        Thread[] threads = new Thread[numberOfSameKeys];
        assertEquals(0, tieredSpilloverCache.diskCacheCount());
            tieredSpilloverCache.computeIfAbsent(key, tieredCacheLoader);
                ).getKey(),
        assertEquals(lastKnownTieredCacheEntriesCount - diskCacheKeys.size(), tieredSpilloverCache.count());
                onHeapCacheSize * keyValueSize + "b"
                keySegment
        keyValuePairs.put("key2", new Tuple<>("abcde", false));
        assertEquals(totalOnDiskEntries, tieredSpilloverCache.diskCacheCount());
            onHeapKeys.add(key);
                    )
                    ).getKey(),
            .build();
                });
                    .setCachedResultParser(s -> new CachedQueryResult.PolicyValues(DEFAULT_TOOK_TIME_DISK_THRESHOLD.getNanos() * 2))
            removalListener,
            )
            } else {
            .setSettings(settings)
            Settings.builder()
            storagePath = environment.nodePaths()[0].path + "/test";
        assertEquals(keyValuePairs.size(), getEvictionsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
                .build(),
        assertThrows(
import java.util.HashMap;
                assertNotNull(computedValue);
        int numberOfSegments = getNumberOfSegments();
                        @Override
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
        tieredSpilloverCache.put(key1, "key1"); // Goes to onHeap cache.
                    }
                    (onHeapCacheSize * keyValueSize) + "b"
                tieredSpilloverCache.computeIfAbsent(diskTierKeys.get(index), loadAwareCacheLoader);
        int diskCacheSize,
        assertEquals(numOfItems1 - tieredSpilloverCache.onHeapCacheCount(), removalListener.evictionsMetric.count());
        IllegalArgumentException ex = assertThrows(
        assertEquals(1, getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
            String>) new TieredSpilloverCache.TieredSpilloverCacheFactory().create(
                .build(),
        return new ICacheKey<>(key, getMockDimensions());
            .build();
                    assertNotNull(tieredSpilloverCache.get(diskTierKeys.get(index)));
                int index = randomIntBetween(0, keys.size() - 1);
            .setStoragePath(getStoragePath(settings))
        });
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_NAME.getConcreteSettingForNamespace(
                    OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME,
        TieredSpilloverCache<String, String> tieredSpilloverCache = (TieredSpilloverCache<String, String>) tieredSpilloverICache;
            false,
        RemovalListener<ICacheKey<String>, String> removalListener,
                builder.addDiskPolicy(diskPolicy);
        for (int i = 0; i < numberOfSegments; i++) {
        tieredSpilloverCache.put(key2, "key2"); // Goes to onHeap cache. And key1 evicted to disk cache.
                CacheType.INDICES_REQUEST_CACHE,
            cacheConfig,
        verifyComputeIfAbsentThrowsException(NullPointerException.class, loadAwareCacheLoader, "Loader returned a null value");
        int numOfItems2 = randomIntBetween(50, 200);
        ImmutableCacheStatsHolder cacheStats = tsc.stats(new String[0]);
            )
            IllegalArgumentException.class,
                    TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
        assertEquals(TieredSpilloverCacheSettings.defaultSegments(), tieredSpilloverCache.getNumberOfSegments());
            0,
            .setClusterSettings(clusterSettings)
        String value = UUID.randomUUID().toString();
        ICache<String, String> tieredSpilloverICache = new TieredSpilloverCache.TieredSpilloverCacheFactory().create(
        List<String> mockDimensions = getMockDimensions();
                )
            } else {
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(
            assertTrue(actualOnDiskKeys.contains(onDiskKey));
import java.util.Map;
                onHeapCacheSize * keyValueSize + "b"
                .setKeySerializer(new StringSerializer())
                return "test";
            diskCacheSize,
                Map.of(
            .setValueSerializer(new StringSerializer())
        }
        countDownLatch.await();
        }
        int keyValueSize = 11;
            .put(
        try (NodeEnvironment environment = newNodeEnvironment(settings)) {
        RemovalListener<ICacheKey<String>, String> removalListener,
        assertTrue(
            tieredSpilloverCache.computeIfAbsent(key, tieredCacheLoader);
        TieredSpilloverCache<String, String> tieredSpilloverCache = new TieredSpilloverCache.Builder<String, String>()
                .build(),
            perSegmentEntryCapacity.put(i, totalEntriesForSegment);
            ICacheKey<String> key = getICacheKey(UUID.randomUUID().toString());
                ).getKey(),
            }
                    .setKeySerializer(new StringSerializer())
            .setSettings(
        int onHeapCacheSize = randomIntBetween(10, 30) * numberOfSegments;
                        }
            LoadAwareCacheLoader<ICacheKey<String>, String> tieredCacheLoader = getLoadAwareCacheLoader();
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
            numberOfSegments,
            }
                totalOnHeapEntries += expectedNumberOfEntriesInSegment.get(i);
        for (int i = 0; i < onHeapCacheSize; i++) {
                onHeapCacheSize * keyValueSize + "b"
    @SuppressWarnings({ "rawtypes", "unchecked" })
            @Override
        ICache.Factory mockDiskCacheFactory = new MockDiskCache.MockDiskCacheFactory(
        } catch (IOException e) {
        tieredSpilloverCache.getDiskCacheKeys().forEach(diskTierKeys::add);
            CacheType.INDICES_REQUEST_CACHE
            CacheType.INDICES_REQUEST_CACHE,
    public void testDropStatsForDimensions() throws Exception {
        List<ICacheKey<String>> onHeapKeys = new ArrayList<>();
        int totalSize = onHeapCacheSize + diskCacheSize;
                    .setWeigher((k, v) -> keyValueSize)
                .setValueSerializer(new StringSerializer())
        long heapTierEvictionsBeforeDisablingDiskCache = heapStats.getEvictions();
                    ).getKey(),
        assertEquals(evictionsBeforeDisablingDiskCache + newMisses, totalStats.getEvictions());
        int diskCacheSize = randomIntBetween(onHeapCacheSize + 1, onHeapCacheSize * 2);
        assertEquals(0, getHitsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
         * totalHits = heapHits + diskHits
                    .setStoragePath(storagePath)
            }
                    .setValueSerializer(new StringSerializer())
                CacheSettings.getConcreteStoreNameSettingForCacheType(CacheType.INDICES_REQUEST_CACHE).getKey(),
        int keyValueSize = 50;
                    onHeapCacheSize * keyValueSize + "b"
                0,
    }
        long lastKnownTieredCacheEntriesCount = tieredSpilloverCache.count();
            threads[i] = new Thread(() -> {
                )
        int numRandom = randomIntBetween(50, 200);
            .setKeySerializer(new StringSerializer())
        for (int iter = 0; iter < numOfItems1; iter++) {
        // During first round add onHeapCacheSize entries. Will go to onHeap cache initially.
                keyValueSize,
            ICacheKey<String> iCacheKey = getICacheKey(UUID.randomUUID().toString());
                )
            tieredSpilloverCache.computeIfAbsent(key, getLoadAwareCacheLoader());
    private TieredSpilloverCache<String, String> initializeTieredSpilloverCache(
         * totalMisses = diskMisses
        doThrow(new RuntimeException("Test")).when(mockDiskCache).put(any(), any());
            public boolean isLoaded() {
        assertEquals(0, tieredSpilloverCache.completableFutureMap.size());
        }
        // Set the desired settings needed to create a TieredSpilloverCache object with INDICES_REQUEST_CACHE cacheType.
                    onHeapCacheSize * keyValueSize + "b"
            tieredSpilloverCache.computeIfAbsent(iCacheKey, tieredCacheLoader);
            .setOnHeapCacheFactory(onHeapCacheFactory)
            .setCacheConfig(cacheConfig)
                    ).getKey(),
                    @Override
            )
        // (this works as we have 1 segment). Set heap threshold to 0 to ensure random keys can all enter
                ).getKey(),
            )
        for (String key : keyValueMap.keySet()) {
        tieredSpilloverCache.put(key2, UUID.randomUUID().toString());
                    .setSettings(settings)
            settings,
        int totalSize = onHeapCacheSize + diskCacheSize;
            0,
                .setSettings(settings)
            0,
                        tieredSpilloverCache.computeIfAbsent(iCacheKeyList.get(finalJ), loadAwareCacheLoader);
        assertEquals(onHeapCacheHit, getHitsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
                            .getKey(),
                    .put(settings)
                expectedNumberOfEntriesInSegment.put(keySegment, updatedValue);
                CacheSettings.getConcreteStoreNameSettingForCacheType(CacheType.INDICES_REQUEST_CACHE).getKey(),
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_NAME.getConcreteSettingForNamespace(
                Map.of(
        AtomicInteger exceptionCount = new AtomicInteger();
        int keyValueSize = 50;
                    .put(settings)
        );
                .setWeigher((k, v) -> keyValueSize)
                    .setStoragePath(storagePath)
            INVALID_SEGMENT_COUNT_EXCEPTION_MESSAGE,
            removalListener,
                    .put(
            0,
        int diskCacheSize,
            tieredSpilloverCache.tieredSpilloverCacheSegments[0].getOnHeapCache().stats().getTotalStats()
        assertEquals(numOfItems1, getMissesForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
            tieredSpilloverCache.computeIfAbsent(iCacheKey, tieredCacheLoader);
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
        Tuple<List<Predicate<String>>, Map<String, Tuple<String, Boolean>>> setupTuple = setupPoliciesTest();
            settings,
                    TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
        assertEquals(0, tieredSpilloverCache.completableFutureMap.size());
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_NAME.getConcreteSettingForNamespace(
                    new OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory(),
        );
                256
                        };
            .setKeyType(String.class)
            .setDimensionNames(dimensionNames)
        TieredSpilloverCache<String, String> tieredSpilloverCache = (TieredSpilloverCache<
        // Ensure all these keys get evicted from the on heap tier by adding > heap tier size worth of random keys
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
            tieredSpilloverCache.computeIfAbsent(key, tieredCacheLoader);
        Map<String, Boolean> expectedInHeapTierMap = Map.of(
            if (randomBoolean()) {
        int expectedEvictions = 0;
                ).getKey(),
         */
        List<Predicate<String>> diskPolicies = setupTuple.v1();
        List<Predicate<String>> policies,
    public void testTieredCacheWithZeroNumberOfSegments() {
        for (int iter = 0; iter < numOfItems1; iter++) {
        int numOfItems1 = randomIntBetween(onHeapCacheSize + 1, totalSize); // Create more items than onHeap cache.
        Map<String, Tuple<String, Boolean>> keyValuePairs = setupTuple.v2();
                    TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
        // Set the desired settings needed to create a TieredSpilloverCache object with INDICES_REQUEST_CACHE cacheType.
                            public boolean isLoaded() {
        assertEquals(expectedKeys, getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
            ICacheKey<String> key = getICacheKey(UUID.randomUUID().toString());
            () -> new TieredSpilloverCache.TieredSpilloverCacheFactory().create(
        // disabled.
        return new LoadAwareCacheLoader<>() {
            newKeyList.add(getICacheKey(UUID.randomUUID().toString()));
            getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP) + getItemsForTier(
        for (int iter = 0; iter < numMisses; iter++) {
                int index = randomIntBetween(0, onHeapKeys.size() - 1);
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
        assertEquals(0, tieredSpilloverCache.diskCacheCount() - actualDiskCacheCount); // Considering it is disabled now, shouldn't
        int numOfItems = randomIntBetween(totalSize + 1, totalSize * 3);
            new CacheConfig.Builder<String, String>().setKeyType(String.class)
        );
        ICache.Factory onHeapCacheFactory = new OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory();
            Settings.builder()
        }
        int keyValueSize = 50;
    public void testWithFactoryCreationWithDiskCacheNotPresent() {
                MockDiskCache.MockDiskCacheFactory.NAME
            0,
        // With this call, we expect an exception from the underlying loader which eventually causes the below call to result into
            false
    }
        }
            0,
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
        assertEquals(1, tieredSpilloverCache.diskCacheCount());
                )
                onHeapCacheSize * keyValueSize + "b"
    private long getMissesForTier(TieredSpilloverCache<?, ?> tsc, String tierValue) throws IOException {
                )
            if (segmentSizeTracker.get(keySegment) == null) {
        for (int iter = 0; iter < numOfItems1; iter++) {
        assertEquals(1, onHeapCacheKeys.size());
        String expectedExceptionMessage
 * The OpenSearch Contributors require contributions made to
        return storagePath;
            public boolean isLoaded() {
                .build(),
            .setStoragePath(storagePath)
                ).getKey(),
                });
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
        @Override
                    keyValueSize - 1 + "b"
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
                CacheSettings.getConcreteStoreNameSettingForCacheType(CacheType.INDICES_REQUEST_CACHE).getKey(),
                    MockDiskCache.MockDiskCacheFactory.NAME,
                ).getKey(),
    public void testComputeIfAbsentConcurrentlyAndThrowsException() throws Exception {
        int onHeapCacheSize = randomIntBetween(10, 30);
    private LoadAwareCacheLoader<ICacheKey<String>, String> getLoadAwareCacheLoader() {
        Phaser phaser = new Phaser(numberOfSameKeys + 1);
        assertEquals(expectedDiskSize / cache.getNumberOfSegments(), segment.getDiskCacheMaxWeight());
        );
            () -> new TieredSpilloverCache.TieredSpilloverCacheFactory().create(
        Map<String, Boolean> expectedInDiskTierMap = Map.of(
                    .setDimensionNames(dimensionNames)
        // First check whether keys respect the heap tier threshold.
        assertEquals(totalStats.getHits(), heapStats.getHits() + diskStats.getHits());
                numberOfTimesKeyLoaded++;
        public void onRemoval(RemovalNotification<ICacheKey<K>, V> notification) {
        assertEquals(0, getEvictionsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
            mockDiskCacheFactory,
                        CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
        );
            )
            public boolean isLoaded() {
                    onHeapCacheSize * keyValueSize + "b"
            tieredSpilloverCache.computeIfAbsent(iCacheKey, tieredCacheLoader);
                OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME,
                    .setRemovalListener(removalListener)
    }
            0,
            public String load(ICacheKey<String> key) {
        int diskCacheSize = randomIntBetween(450, 800);
        return getStatsSnapshotForTier(tsc, tierValue).getItems();
        assertEquals(onHeapCacheSize, getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
                // All these are bound to go to disk based cache.
            .put(
import org.opensearch.common.cache.stats.ImmutableCacheStatsHolder;
                .build(),
            )
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_DISK_STORE_NAME.getConcreteSettingForNamespace(
            @Override
        int onHeapCacheHit = 0;
            "E",
        int numberOfSegments
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
        int keyValueSize = 50;
        return getStatsSnapshotForTier(tsc, tierValue).getEvictions();
            numberOfSegments
    }
                0,
        assertEquals(onHeapCacheSize, tieredSpilloverCache.tieredSpilloverCacheSegments[0].getOnHeapCache().count());
 *
        assertEquals(0, getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
    public void testComputeIfAbsentConcurrently() throws Exception {
        assertEquals(numOfItems1, tieredSpilloverCache.count());
        };
            mockDiskCacheFactory,
                            .get(MAXIMUM_SIZE_IN_BYTES_KEY)
        );
import java.util.concurrent.CopyOnWriteArrayList;
        List<LoadAwareCacheLoader<ICacheKey<String>, String>> loadAwareCacheLoaderList = new CopyOnWriteArrayList<>();
            diskCacheSize,
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
        ICacheKey<String> dropDimensionsKey = new ICacheKey<>(null, getMockDimensions());
            }
import java.util.List;
                OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME,
    }
                    TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
        // Evictions metric shouldn't increase for invalidations.
        AtomicReference<String> actualValue = new AtomicReference<>();
            removalListener,
        for (int i = 0; i < onHeapCacheSize; i++) {
    }
            @Override
        int keyValueSize,
                    .setRemovalListener(removalListener)
        int diskSizeFromImplSetting = 50;
            ICacheKey<String> key = usedKeys.get(rand.nextInt(usedKeys.size()));
        assertEquals(cacheHit, getHitsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
            keyValueSize * 100,
        assertEquals(1, tieredSpilloverCache.count());
        assertEquals(1, diskKeys.size());
                    onHeapCacheSize * keyValueSize + "b"
                }
        tieredSpilloverCache.tieredSpilloverCacheSegments[0].getDiskCache().keys().forEach(diskKeys::add);
            false,
        int numSegments = getNumberOfSegments();
        // Most of setup duplicated from testComputeIfAbsentWithFactoryBasedCacheCreation()
                OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME
                    // Values will always appear to have taken 2x the took time threshold to compute, so they will be admitted
                    .put(
                throw new RuntimeException("Testing");
        assertEquals(0, getEvictionsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
            LoadAwareCacheLoader<ICacheKey<String>, String> tieredCacheLoader = getLoadAwareCacheLoader();
            settings,
        executorService.shutdownNow();
        );
                .setMaxSizeInBytes(onHeapCacheSize * keyValueSize)
                            boolean isLoaded = false;
                diskCacheSize,
        int onHeapCacheSize = randomIntBetween(10, 30);
        String storagePath;
        List<ICacheKey<String>> actualOnDiskKeys = new ArrayList<>();
            if (loader.isLoaded()) {
            @Override
                    new OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory(),
                expectedEvictions += segmentSizeTracker.get(i) - perSegmentEntryCapacity.get(i);
        ICache.Factory onHeapCacheFactory,
                .setClusterSettings(clusterSettings)
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
            if (bytes == null) {
            cacheConfig,
        assertEquals(numberOfSegments, tieredSpilloverCacheSegments.length);
        totalStats = tieredSpilloverCache.stats().getTotalStats();
        assertEquals(numOfItems1, getMissesForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
            }
            tieredSpilloverCache.computeIfAbsent(key, loadAwareCacheLoader);
                continue;
            .setSegmentCount(numberOfSegments)
                return isLoaded;
            )
        long evictionsBeforeDisablingDiskCache = totalStats.getEvictions();
        assertEquals(0, removalListener.evictionsMetric.count());
        CountDownLatch countDownLatch = new CountDownLatch(1);
            removalListener,
                    ).getKey(),
                expectedEvictions += segmentSizeTracker.get(i) - perSegmentEntryCapacity.get(i);
                .setClusterSettings(clusterSettings)
        int onHeapCacheSize = 10;
            1
            Settings.builder()
        assertEquals(totalOnDiskEntries, getEvictionsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
                isLoaded = true;
            .setRemovalListener(removalListener)
                newMisses++;
                return false;
            true,
        }
                Map.of(
            getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP) + getItemsForTier(
        );
        Tuple<List<Predicate<String>>, Map<String, Tuple<String, Boolean>>> setupTuple = setupPoliciesTest();
                )
            @Override
        Map<String, Long> tookTimeMap = new HashMap<>();
                    ).getKey(),
            TieredSpilloverCache.TieredSpilloverCacheSegment<String, String> segment =
                tieredSpilloverCache.computeIfAbsent(secondKey, loadAwareCacheLoader);
            .put(
                OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME
import org.opensearch.common.collect.Tuple;
                expectedEvictions++;
        }
        // exception.
            keyValueSize,
            // The size setting from the OpenSearchOnHeap implementation should not be honored
        assertEquals(heapTierEvictionsBeforeDisablingDiskCache + newMisses, heapStats.getEvictions());
            IllegalArgumentException.class,
                    TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME
                    loadAwareCacheLoaderList.add(loadAwareCacheLoader);
        int onHeapCacheSize = 1;
            @Override
            keyValueSize,
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
            removalListener,
                isLoaded = true;
            storagePath = environment.nodePaths()[0].path + "/test";
        assertEquals(expectedKeys, tieredSpilloverCache.count());
            )
                threadNumber++;
        for (int iter = 0; iter < numOfItems1; iter++) {
        heapStats = getStatsSnapshotForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP);
            .put(
    ) {
                            @Override
                )
            .build();
            .setDiskCacheSize(diskCacheSize)
            removalListener,
        checkSegmentSizes(tieredSpilloverCache, expectedHeapSize, expectedDiskSize);
            )
        ImmutableCacheStats diskStats = getStatsSnapshotForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK);
                // Should retrieve from heap tier if it was accepted
                    assertNotNull(tieredSpilloverCache.get(onHeapKeys.get(index)));
        assertEquals(1, tieredSpilloverCache.onHeapCacheCount());
    }
        String storagePath = getStoragePath(settings);
        } catch (Exception ex) {
        );
        int totalSize = onHeapCacheSize + diskCacheSize;
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_DISK_STORE_NAME.getConcreteSettingForNamespace(
        // Map from key to tuple of (value, whether we expect it to be admitted by policy)
                .put(
                    .setSettings(settings)
            .setRemovalListener(removalListener)
        CacheConfig<String, String> cacheConfig,
        int diskSizeFromImplSetting = 50;
            diskCacheSize,
    }
                MockDiskCache.MockDiskCacheFactory.NAME
            () -> new TieredSpilloverCache.TieredSpilloverCacheFactory().create(
        int cacheMiss = 0;
            }
import org.opensearch.common.cache.RemovalNotification;
        );
import java.util.concurrent.atomic.AtomicInteger;
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
            keyValueSize * 100,
                .put(
import java.util.function.Predicate;
        assertEquals(0, getHitsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
        // Put values in cache.
        assertEquals(0, tieredSpilloverCache.count());
            .put(TIERED_SPILLOVER_SEGMENTS.getConcreteSettingForNamespace(CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()).getKey(), 1)
            @Override
    }
        int onHeapCacheSize = randomIntBetween(300, 600);
        int diskCacheSize = randomIntBetween(onHeapCacheSize + 1, 100);
        );
        );
                        LoadAwareCacheLoader<ICacheKey<String>, String> loadAwareCacheLoader = new LoadAwareCacheLoader<>() {
            if (loader.isLoaded()) {
        assertThrows(
            )
        assertEquals(expectedKeys, getTotalStatsSnapshot(tieredSpilloverCache).getItems());
                totalOnDiskEntries += expectedNumberOfEntriesInSegment.get(i) - expectedSegmentOnHeapCacheSize.get(i);
        Settings settings = Settings.builder()
        // To test concurrently, run for each key multiple times in parallel threads
        int keyValueSize = 1;
            diskCacheSize,
import static org.opensearch.common.cache.store.settings.OpenSearchOnHeapCacheSettings.MAXIMUM_SIZE_IN_BYTES_KEY;
            return object.equals(deserialize(bytes));
            policies,
            .put(TIERED_SPILLOVER_SEGMENTS.getConcreteSettingForNamespace(CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()).getKey(), 3)
import org.opensearch.test.OpenSearchTestCase;
            int perSegmentOnHeapCacheEntries = perSegmentOnHeapCacheSizeBytes / keyValueSize;
import java.util.concurrent.Phaser;
            keyValueSize
            @Override
        }
            .put(
            null,
        int numOfItems1 = randomIntBetween(onHeapCacheSize + 1, totalSize);
        return new LoadAwareCacheLoader<>() {
        int onHeapCacheSize = randomIntBetween(10, 30);
                    .build(),
        ICacheKey<String> key2 = getICacheKey(UUID.randomUUID().toString());
    }
        int numOfItems1 = randomIntBetween(1, onHeapCacheSize / 2 - 1);
import static org.opensearch.cache.common.tier.TieredSpilloverCacheStatsHolder.TIER_DIMENSION_VALUE_DISK;
        );
            .put(
        int minMisses = (diskCacheSize + onHeapCacheSize) / keyValueSize + 10;
import org.junit.Before;
                OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME
        assertEquals(expectedDiskEntries, getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
            }
        assertEquals(expectedDiskEntries, tieredSpilloverCache.tieredSpilloverCacheSegments[0].getDiskCache().count());
        tookTimeMap.put("e", -1L);
        tieredSpilloverCache.invalidate(key);
        );
import static org.mockito.Mockito.when;
            dims.add("0");
                return isLoaded;
        }
                    new MockDiskCache.MockDiskCacheFactory(0, randomIntBetween(100, 300), false, keyValueSize)
            "F",
        // to count towards total evictions
                onHeapCacheSize * keyValueSize + "b"
        int onHeapCacheSize = randomIntBetween(300, 400);
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_DISK_STORE_SIZE.getConcreteSettingForNamespace(
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
        // Verify disk cache stats.
                new CacheConfig.Builder<String, String>().setKeyType(String.class)
        List<ICacheKey<String>> diskTierKeys = new ArrayList<>();
        for (int iter = 0; iter < numMisses; iter++) {
    }
import org.opensearch.common.cache.ICache;
        int onHeapCacheSize = randomIntBetween(100, 300);
        assertEquals(0, tieredSpilloverCache.diskCacheCount()); // Disk cache shouldn't have anything considering it is
        int totalSize = onHeapCacheSize + diskCacheSize;
         * totalEntries = heapEntries + diskEntries
    public void testComputeIfAbsentWithSegmentedCache() throws Exception {
        long actualDiskCacheCount = tieredSpilloverCache.diskCacheCount();
            keyValueSize,
                    onHeapCacheSize * keyValueSize + "b"
        int numberOfSegments = getNumberOfSegments();
            int keySegment = tieredSpilloverCache.getSegmentNumber(key);
                    TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
        assertEquals(0, tieredSpilloverCache.completableFutureMap.size());
                    ).getKey(),
        String storagePath;
        keyValuePairs.put("key5", new Tuple<>("", false));
                removalListener,
        });
            return object.getBytes(charset);
        int diskCacheSize = randomIntBetween(700, 1200);
        }
                    .setSettings(settings)
        });
            public boolean isLoaded() {
        // for a given tier with a single node in MDCS
                .setClusterSettings(clusterSettings)
        Settings validSettings = Settings.builder().put(concreteSetting.getKey(), validDuration).build();
        assertEquals(expectedEvictions, removalListener.evictionsMetric.count());
        }
        policies.add(new AllowFirstLetterA());
            .put(
        ICache.Factory mockDiskCacheFactory,
    public void testComputeIfAbsentWithoutAnyOnHeapCacheEviction() throws Exception {
        // Fill the cache, getting some entries + evictions for both tiers
                    .setRemovalListener(removalListener)
                tieredSpilloverCache.computeIfAbsent(getICacheKey(UUID.randomUUID().toString()), getLoadAwareCacheLoader());
    }
            .put(
        tieredSpilloverCache.refresh();
import static org.opensearch.cache.common.tier.TieredSpilloverCacheStatsHolder.TIER_DIMENSION_NAME;
            .setKeyType(String.class)
        clusterSettings.applySettings(
            keyValueSize,
                // expect a hit
                TIER_DIMENSION_VALUE_DISK
            numberOfSegments
            } else {
            assertTrue(actualMergedKeys.contains(key));
        int numberOfSegments
    private TieredSpilloverCache<String, String> initializeTieredSpilloverCache(
            String key = UUID.randomUUID().toString();
                .build(),
                onHeapCacheSizeInBytes + "b"
        assertEquals(iterations * numberOfKeys, loadAwareCacheLoaderList.size());
        long diskDeliberateDelay,
            LoadAwareCacheLoader<ICacheKey<String>, String> tieredCacheLoader = getLoadAwareCacheLoader();
                throw new RuntimeException(e);
            }
            Settings.builder().put(DISK_CACHE_ENABLED_SETTING_MAP.get(CacheType.INDICES_REQUEST_CACHE).getKey(), false).build()
        return new CacheConfig.Builder<String, String>().setKeyType(String.class)
            .put(
            storagePath = environment.nodePaths()[0].path + "/test";
        // Get number of keys we expect to enter the cache
            .setRemovalListener(removalListener)
        int onHeapCacheSize = randomIntBetween(10, 30);
        Setting<TimeValue> concreteSetting = TieredSpilloverCacheSettings.TOOK_TIME_POLICY_CONCRETE_SETTINGS_MAP.get(
        Settings settings = Settings.builder()
    public void testTookTimePoliciesFromFactory() throws Exception {
        LoadAwareCacheLoader<ICacheKey<String>, String> loadAwareCacheLoader = new LoadAwareCacheLoader<>() {
                return isLoaded;
            keyValueSize,
            .put(
                        CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
        clusterSettings.applySettings(
        countDownLatch.await();
        int keyValueSize = 1;
                    .build(),
            keyValueSize,
                )
    public void testWithFactoryCreationWithOnHeapCacheNotPresent() {
            .put(
                onHeapCacheSize * keyValueSize + "b"
        ICache mockDiskCache = mock(ICache.class);
        );
import static org.mockito.Mockito.doThrow;
        Iterable<ICacheKey<String>> onDiskiterable = tieredSpilloverCache.getDiskCacheKeys();
            ),
            }
        // Now try to put key1 again onto tiered cache with new value.
        ICache.Factory mockDiskCacheFactory = new MockDiskCache.MockDiskCacheFactory(0, diskCacheSize, false, keyValueSize);
        long onHeapCacheSizeInBytes,
        assertEquals(numOfItems1, getMissesForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
            onHeapCacheSize * keyValueSize,
                    int index = randomIntBetween(0, diskTierKeys.size() - 1);
        // Also do some random hits
            0,
    public void testComputeIfAbsentWhenTheQueryThrowsAnException() throws Exception {
            keyValueSize,
                .build(),
            .setClusterSettings(clusterSettings)
            LoadAwareCacheLoader<ICacheKey<String>, String> loadAwareCacheLoader = getLoadAwareCacheLoader();
                    OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME,
        }
        int numberOfTimesKeyLoaded = 0;
        countDownLatch1.await();
            loaderMap.put(key, new Tuple<>(keyValueMap.get(key), false));
        public String deserialize(byte[] bytes) {
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
                LoadAwareCacheLoader<ICacheKey<String>, String> loadAwareCacheLoader = getLoadAwareCacheLoader();
            public String load(ICacheKey<String> key) {
            1
                .setWeigher((k, v) -> keyValueSize)
        int numberOfSegments = getNumberOfSegments();
            .build();
        List<Predicate<String>> policies = setupTuple.v1();
                CacheType.INDICES_REQUEST_CACHE,
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
        assertEquals(0, diskStats.getSizeInBytes());
            )
                .build(),
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
        Phaser phaser = new Phaser(numberOfSameKeys + 1);
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(
        phaser.arriveAndAwaitAdvance();
        );
        List<Predicate<String>> policies = setupTuple.v1();
        ICacheKey<String> key2 = getICacheKey("key2");
            IllegalArgumentException.class,
    }
        int onHeapCacheSize = 1;
    }
        List<ICacheKey<String>> diskTierKeys = new ArrayList<>();
                Map.of(
        int numOfItems = randomIntBetween(10, 30);
        int keyValueSize = 50;
            IllegalArgumentException.class,
            threads[i].start();
            }
        Random rand = Randomness.get();
package org.opensearch.cache.common.tier;
            numberOfSegments
        diskKeys.clear();
        Settings settings = Settings.builder()
import static org.opensearch.common.cache.settings.CacheSettings.INVALID_SEGMENT_COUNT_EXCEPTION_MESSAGE;
            Settings.builder()
                } else {
            if (expectedOutput) {
            )) {
                expectedKeys++;
        assertEquals(totalOnHeapEntries, getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
        for (String key : keyValueMap.keySet()) {
                0
            diskCacheSize,
        clusterSettings.applySettings(
        assertEquals(expectedDiskEntries, getEvictionsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
            } catch (Exception e) {
        // We should see only one heap miss, and the rest hits
        CountDownLatch countDownLatch = new CountDownLatch(numberOfSameKeys); // To wait for all threads to finish.
            settings,
        ICacheKey<String> key = getICacheKey(UUID.randomUUID().toString());
        // Fill the cache, getting some entries + evictions for both tiers
            public String load(ICacheKey<String> key) {
                assertFalse(loadAwareCacheLoader.isLoaded());
        CacheConfig<String, String> cacheConfig = new CacheConfig.Builder<String, String>().setKeyType(String.class)
                                return isLoaded;
        }
    public void testComputIfAbsentConcurrentlyWithMultipleKeys() throws Exception {
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_NAME.getConcreteSettingForNamespace(
    }
        assertEquals(expectedEvictions, getEvictionsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
                .setKeyType(String.class)
        assertEquals("test", response);
        clusterSettings.registerSetting(TOOK_TIME_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE));
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
import org.opensearch.OpenSearchException;
        String storagePath = getStoragePath(settings);
        for (int i = 0; i < onHeapCacheSize; i++) {
import static org.opensearch.cache.common.tier.TieredSpilloverCacheStatsHolder.TIER_DIMENSION_VALUE_ON_HEAP;
        int keyValueSize = 1;
                    .setWeigher((k, v) -> keyValueSize)
                OpenSearchOnHeapCacheSettings.MAXIMUM_SIZE_IN_BYTES.getConcreteSettingForNamespace(
        Map<String, Tuple<String, Boolean>> keyValuePairs = new HashMap<>();
        int diskCacheSize = randomIntBetween(700, 1200);
            .setKeySerializer(new StringSerializer())
            if (expectedNumberOfEntriesInSegment.get(keySegment) == null) {
        int newMisses = 0;
            () -> new TieredSpilloverCache.TieredSpilloverCacheFactory().create(
            "G",
            // Initialize the settings to some other value, so we can demonstrate the updating logic works correctly.
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_NAME.getConcreteSettingForNamespace(
        int onHeapCacheSize = randomIntBetween(200, 400);
            LoadAwareCacheLoader<ICacheKey<String>, String> tieredCacheLoader = getLoadAwareCacheLoader();
                        countDownLatch.countDown();
            Settings.builder()
        assertEquals(0, getHitsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
        // For disk policy function, allow if what it receives starts with "a" and string is even length
                }
        }
    public void testComputeIfAbsentWithFactoryBasedCacheCreation() throws Exception {
                actualValue.set(tieredSpilloverCache.get(keyToBeEvicted));
    public void testRefresh() {
 * compatible open source license.
    // Helper functions for extracting tier aggregated stats.
        return getStatsSnapshotForTier(tsc, tierValue).getMisses();
            keyValueSize,
            policies,
        int keyValueSize = 50;
        );
                .setKeyType(String.class)
        ICacheKey<String> secondKey = getICacheKey("key2");
            "E",
            .setValueSerializer(new StringSerializer())
        assertEquals(0, getEvictionsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
                    } catch (Exception ignored) {} finally {
            1
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(
            numSegments,
                            @Override
            "No associated onHeapCache found for tieredSpilloverCache for " + "cacheType:" + CacheType.INDICES_REQUEST_CACHE
            return data.length() % 2 == 0;
            )
    }
            keyValueSize,
import java.util.Random;
            keyValueSize * 100,
            ICacheKey<String> key = getICacheKey(UUID.randomUUID().toString());
        TieredSpilloverCache<String, String> tieredSpilloverCache = getTieredSpilloverCache(
        // Change setting values to the target values to show both updates work as expected.
                    MockDiskCache.MockDiskCacheFactory.NAME,
        assertEquals(0, getEvictionsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
    private long getHitsForTier(TieredSpilloverCache<?, ?> tsc, String tierValue) throws IOException {
                    .setCachedResultParser(s -> new CachedQueryResult.PolicyValues(DEFAULT_TOOK_TIME_DISK_THRESHOLD.getNanos() * 2))
        assertEquals(0, tieredSpilloverCache.count());
                    .build()
                .put(
            keys.add(key);
                            return value;
            int keySegment = tieredSpilloverCache.getSegmentNumber(iCacheKey);
        LoadAwareCacheLoader<ICacheKey<String>, String> loadAwareCacheLoader = getLoadAwareCacheLoader();
                    .setWeigher((k, v) -> keyValueSize)
            null,
        tieredSpilloverCache.put(key, value);
                    OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME,
        assertEquals(onHeapKeys.size(), getHitsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
                assertEquals(keyValuePairs.get(key).v1(), result);
                // expect a miss
        }
        CountDownLatch countDownLatch = new CountDownLatch(numberOfSameKeys); // To wait for all threads to finish.
            )
            .build();
        int keyValueSize = 50;
        return getTieredSpilloverCache(
        }
                TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME
                OpenSearchOnHeapCacheSettings.MAXIMUM_SIZE_IN_BYTES.getConcreteSettingForNamespace(
    private static class AllowFirstLetterA implements Predicate<String> {
        tieredSpilloverCache.getOnHeapCacheKeys().forEach(actualOnHeapCacheKeys::add);
            .put(
            removalListener,
        List<String> dims = new ArrayList<>();
        for (ICacheKey<String> diskKey : diskCacheKeys) {
        assertEquals(expectedRespone, value);
            int perSegmentOnHeapCacheSizeBytes = onHeapCacheSizeInBytes / numberOfSegments;
                        CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
            )
    public void testGetPutAndInvalidateWithDiskCacheDisabled() throws Exception {
        // In another round, add another onHeapCacheSize entries. These will go to onHeap and above ones will be
        for (ICacheKey<String> diskKey : diskCacheKeys) {
                        CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
    }
        assertEquals(numOfItems1 + cacheMiss + diskCacheHit, getMissesForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(
    public void testSegmentSizesWhenNotUsingFactory() {
                onHeapCacheHit++;
        int onHeapCacheSize = randomIntBetween(500, 700);
                diskCacheSize,
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_NAME.getConcreteSettingForNamespace(
        try (NodeEnvironment environment = newNodeEnvironment(settings)) {
                countDownLatch.countDown();
            .setValueSerializer(new StringSerializer())
        int expectedKeys = 0;
        int diskCacheSize = 3;
        );
import static org.mockito.ArgumentMatchers.any;
        countDownLatch.await();
                    // Values will always appear to have taken 2x the took time threshold to compute, so they will be admitted
                        CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
        long heapSizeFromImplSetting = 50;
            public String load(ICacheKey<String> key) {
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
                assertNull(tieredSpilloverCache.get(getICacheKey(UUID.randomUUID().toString())));
import java.nio.charset.StandardCharsets;
        // should be 0 after that.
                        boolean isLoaded = false;
        ImmutableCacheStats heapStats = getStatsSnapshotForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP);
                .build(),
        }
                    .put(
        // Set the settings without onHeap cache settings.
        int numberOfSegments = getNumberOfSegments();
            LoadAwareCacheLoader<ICacheKey<String>, String> tieredCacheLoader = getLoadAwareCacheLoader();
    }
        int diskCacheSize,
                .put(
    public void testComputeIfAbsentConcurrentlyWithLoaderReturningNull() throws Exception {
                )
        int diskCacheSize = randomIntBetween(200, 400);
        try (NodeEnvironment environment = newNodeEnvironment(settings)) {
                // Hit cache with stored key
        }
        for (int i = 0; i < newKeyList.size(); i++) {
