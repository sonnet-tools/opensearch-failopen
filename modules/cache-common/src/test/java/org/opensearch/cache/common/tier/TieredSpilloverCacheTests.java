            usedKeys.add(key);
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
                onHeapCacheSize * keyValueSize + "b"
                            .getKey(),  
                .setValueSerializer(new StringSerializer())
        );
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
import java.util.ArrayList;
        int onHeapCacheSize = randomIntBetween(300, 500) * numberOfSegments; // Able to support all keys in case of
            tieredSpilloverCache.computeIfAbsent(key, tieredCacheLoader);
    public void testInvalidateAll() throws Exception {  
            settings,  
            )  
            }  
        assertEquals("test", value);
                new CacheConfig.Builder<String, String>().setKeyType(String.class)  
            .setKeyType(String.class)
                .put(  
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
        }  
        for (ICacheKey<String> onHeapKey : onHeapKeys) {
        tookTimeMap.put("d", null);
        for (int i = 0; i < numberOfSegments; i++) {
                TIER_DIMENSION_VALUE_DISK  
import org.opensearch.common.cache.LoadAwareCacheLoader;  
            .setKeySerializer(new StringSerializer())  
            .build();
                TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME  
        for (ICacheKey<String> diskKey : diskCacheKeys) {  
                ).getKey(),
            if (bytes == null) {
                        TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
                ).getKey(),
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
                CacheSettings.getConcreteStoreNameSettingForCacheType(CacheType.INDICES_REQUEST_CACHE).getKey(),
        keyValuePairs.put("key3", new Tuple<>("bbc", false));
        int diskCacheSize = randomIntBetween(600, 700);  
                Settings.builder()  
        // Set the settings without onHeap cache settings.
        int numMisses = onHeapCacheSize + diskCacheSize + randomIntBetween(minMisses, minMisses + 50);
                } finally {
        int onHeapCacheSize = randomIntBetween(500, 700);  
                ).getKey(),  
            .build();
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()  
        int keyValueSize = 1;
        LoadAwareCacheLoader<ICacheKey<String>, String> tieredCacheLoader = new LoadAwareCacheLoader<>() {
                });
        assertEquals(onHeapCacheSize, getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
            true,  
        assertEquals(new ImmutableCacheStats(0, 0, 0, 0, 0), tieredSpilloverCache.stats().getTotalStats());
                    TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
            Settings.builder()
        tieredSpilloverCache.getDiskCacheKeys().forEach(diskTierKeys::add);
        } catch (IOException e) {  
            .build();  
        for (int iter = 0; iter < numOfItems1; iter++) {
            diskPolicies,
    private long getItemsForTier(TieredSpilloverCache<?, ?> tsc, String tierValue) throws IOException {
        assertEquals(expectedEvictions, getTotalStatsSnapshot(tieredSpilloverCache).getEvictions());
    public void testPutForAKeyWhichAlreadyExists() {
        IllegalArgumentException ex = assertThrows(  
                keyValueSize,  
        Map<Integer, Integer> onHeapExpectedSize = getSegmentOnHeapCacheSize(
        }
            keyValueSize,
        int numberOfSegments
                .build(),
            removalListener,
            return new String(bytes, charset);
            }  
        );  
            onHeapCacheSize * keyValueSize,  
            .setOnHeapCacheFactory(onHeapCacheFactory)
    }  
                    .setRemovalListener(removalListener)  
        }
        // any more items.  
                return "test";
                    } catch (Exception ignored) {} finally {
        int minMisses = (diskCacheSize + onHeapCacheSize) / keyValueSize + 10;
                    .setKeyType(String.class)
            .setOnHeapCacheFactory(onHeapCacheFactory)
        // Put first key on tiered cache. Will go into onHeap cache.
        assertEquals(2, tieredSpilloverCache.count());
            .setKeyType(String.class)
                onHeapCacheSize * keyValueSize + "b"
            } else {
        }  
import static org.opensearch.cache.common.tier.TieredSpilloverCacheSettings.TOOK_TIME_DISK_TIER_POLICY_CONCRETE_SETTINGS_MAP;
                            }
            }
        assertEquals(new ImmutableCacheStats(0, 0, 0, 0, 0), diskStats);
import static org.opensearch.common.cache.settings.CacheSettings.INVALID_SEGMENT_COUNT_EXCEPTION_MESSAGE;
        };  
            keyValueSize,
                    new OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory(),
        Settings settings = Settings.EMPTY;
                Map.of(
        List<ICacheKey<String>> expectedMergedKeys = new ArrayList<>();
        int keyValueSize = 1;
}
                    onHeapCacheSize * keyValueSize + "b"
        int diskCacheHit = 0;
            } catch (StringIndexOutOfBoundsException e) {
            removalListener,  
        ImmutableCacheStatsHolder cacheStats = tsc.stats(new String[0]);
        );
            tieredSpilloverCache.computeIfAbsent(key, tieredCacheLoader);  
        });  
                    onHeapCacheSize * keyValueSize + "b"  
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(
            removalListener,
        int keyValueSize = 50;
            .setKeySerializer(new StringSerializer())
        tieredSpilloverCache.invalidate(key);
                0,
        return new CacheConfig.Builder<String, String>().setKeyType(String.class)
                TIERED_SPILLOVER_SEGMENTS.getConcreteSettingForNamespace(CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()).getKey(),
        );
            () -> initializeTieredSpilloverCache(
            .setNumberOfSegments(1)
                    .setKeySerializer(new StringSerializer())  
        );
            return object.equals(deserialize(bytes));
                .put(
            .setDiskCacheSize(diskCacheSize)
            "B",
            return new ImmutableCacheStats(0, 0, 0, 0, 0); // This can happen if no cache actions have happened for this set of
                )
        ICache.Factory diskCacheFactory = new MockDiskCache.MockDiskCacheFactory(500, diskCacheSize, false, 1);
        TieredSpilloverCache.Builder<String, String> builder = new TieredSpilloverCache.Builder<String, String>().setCacheType(  
        int numOfItems2 = randomIntBetween(1, onHeapCacheSize / 2 - 1);
        assertEquals(0, getEvictionsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));  
        for (int iter = 0; iter < numOfItems1; iter++) {  
            0,
import java.util.List;
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();  
        // do some gets to put entries in both tiers
    public void testGetAndCount() throws Exception {
        );
        assertEquals(getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP), tieredSpilloverCache.onHeapCacheCount());
            CacheType.INDICES_REQUEST_CACHE,
                })  
                    .put(
            )
            0,
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
        LoadAwareCacheLoader<ICacheKey<String>, String> loader = getLoadAwareCacheLoader(keyValuePairs);  
        }
            .setDimensionNames(dimensionNames)
        );
        int keyValueSize = 1;
            "E",  
                throw new RuntimeException(e);  
            0,
                .setStoragePath(storagePath)
            .put(
                )  
            1
                    TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(  
        for (int iter = 0; iter < numOfItems1; iter++) {
            @Override  
        phaser.arriveAndAwaitAdvance();  
        int numberOfSegments = getNumberOfSegments();  
        Settings validSettings = Settings.builder().put(concreteSetting.getKey(), validDuration).build();
            LoadAwareCacheLoader<ICacheKey<String>, String> tieredCacheLoader = getLoadAwareCacheLoader();  
        assertEquals((iterations * numberOfKeys) - numberOfKeys, getHitsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
                    onHeapCacheSize * keyValueSize + "b"  
            String result = tieredSpilloverCache.get(iCacheKey);
        TieredSpilloverCache<String, String> tieredSpilloverCache = (TieredSpilloverCache<String, String>) tieredSpilloverICache;  
        for (int iter = 0; iter < numOfItems1; iter++) {
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_DISK_STORE_NAME.getConcreteSettingForNamespace(
                            }
                    onHeapCacheSize * keyValueSize + "b"
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(
        for (int iter = 0; iter < numOfItems; iter++) {  
                    .setKeyType(String.class)
            )
                // Should retrieve from disk tier if it was accepted  
    private void verifyComputeIfAbsentThrowsException(  
            )  
        tieredSpilloverCache.invalidate(dropDimensionsKey);  
                tieredSpilloverCache.computeIfAbsent(secondKey, loadAwareCacheLoader);  
                        CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
        expectedMergedKeys.addAll(onHeapKeys);  
        );  
        String response = "";  
        assertEquals(1, tieredSpilloverCache.diskCacheCount());  
    }  
        assertEquals(totalOnHeapEntries * keyValueSize, getSizeInBytesForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
import org.opensearch.common.unit.TimeValue;
        }  
         * totalEvictions = diskEvictions  
        assertEquals(diskCacheHit, getHitsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
                countDownLatch1.countDown();
        assertEquals(0, getEvictionsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));  
                // expect a miss  
                    new OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory(),  
            // These two size settings should be honored
        try (NodeEnvironment environment = newNodeEnvironment(settings)) {
        int keyValueSize = 50;
            )
        int diskCacheSize = randomIntBetween(60, 100);  
                        CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
            .put(  
        // Change setting values to the target values to show both updates work as expected.  
        countDownLatch.await();
    }  
            getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP) + getItemsForTier(
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();  
        // Get number of keys we expect to enter the cache
        onDiskiterable.iterator().forEachRemaining(actualOnDiskKeys::add);
            }
        int onHeapCacheSize = randomIntBetween(tookTimeMap.size() + 1, tookTimeMap.size() + 30);
            keyValueSize * 100,
            settings,  
        int onHeapCacheSize = randomIntBetween(10, 30) * numberOfSegments;  
        List<ICacheKey<String>> onHeapKeys = new ArrayList<>();
        ImmutableCacheStats totalStats = tieredSpilloverCache.stats().getTotalStats();
        return new ICacheKey<>(key, getMockDimensions());
        List<ICacheKey<String>> onHeapKeys = new ArrayList<>();
            .build();
                                isLoaded = true;
                diskCacheSize,
                MockDiskCache.MockDiskCacheFactory.NAME  
        dropDimensionsKey.setDropStatsForDimensions(true);
            actualTieredCacheCount  
            0,
            .put(
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
            new OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory(),
        );  
                return UUID.randomUUID().toString();  
                .build()
            .put(
                .setDimensionNames(dimensionNames)  
    public void testTieredCacheDefaultSegmentCount() {
            LoadAwareCacheLoader<ICacheKey<String>, String> tieredCacheLoader = getLoadAwareCacheLoader();  
    }
            .build();
        RemovalListener<ICacheKey<String>, String> removalListener,
        // Mock took time by passing this map to the policy info wrapper fn
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()  
        int diskCacheSize = randomIntBetween(700, 1200);
        assertEquals(numOfItems1 - tieredSpilloverCache.onHeapCacheCount(), removalListener.evictionsMetric.count());
        int keyValueSize = 50;
        for (String key : keyValuePairs.keySet()) {  
            )  
                builder.addPolicy(policy);  
            .put(
        int numThreads = keyValuePairs.size() * numRepetitionsPerKey;
            new CacheConfig.Builder<String, String>().setKeyType(String.class)
        // Confirm we can't set TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_DISK_TOOK_TIME_THRESHOLD to below
    }  
            .build();  
            }
        }  
        Settings settings,  
        } catch (Exception ex) {
        assertEquals(1, tieredSpilloverCache.onHeapCacheCount());
                    .setRemovalListener(removalListener)
import static org.opensearch.cache.common.tier.TieredSpilloverCache.ZERO_SEGMENT_COUNT_EXCEPTION_MESSAGE;
            public boolean isLoaded() {
                MockDiskCache.MockDiskCacheFactory.NAME  
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
            .setSettings(settings)
        CountDownLatch countDownLatch = new CountDownLatch(iterations * numberOfKeys); // To wait for all threads to finish.
        }  
        CountDownLatch countDownLatch = new CountDownLatch(numberOfSameKeys); // To wait for all threads to finish.
        AtomicReference<String> actualValue = new AtomicReference<>();  
        }
            removalListener,  
                    .setStoragePath(storagePath)
        // During first round add onHeapCacheSize entries. Will go to onHeap cache initially.  
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
         * totalSize = heapSize + diskSize
            LoadAwareCacheLoader<ICacheKey<String>, String> loadAwareCacheLoader = getLoadAwareCacheLoader();  
                ).getKey(),
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_DISK_STORE_SIZE.getConcreteSettingForNamespace(
            .put(
            Settings.builder().put(DISK_CACHE_ENABLED_SETTING_MAP.get(CacheType.INDICES_REQUEST_CACHE).getKey(), true).build()
        try (NodeEnvironment environment = newNodeEnvironment(settings)) {
            .put(
        ICache.Factory onHeapCacheFactory = new OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory();
                    OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME,
                assertEquals(keyValuePairs.get(key).v1(), result);
        String value = UUID.randomUUID().toString();  
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(
                Integer updatedValue = expectedNumberOfEntriesInSegment.get(keySegment) + 1;  
            });
                            return value;
    }  
    public void testComputeIfAbsentWithOnHeapCacheThrowingExceptionOnPut() throws Exception {  
    }
import org.opensearch.common.cache.RemovalNotification;
        }
                        CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()  
            cacheConfig,  
        LoadAwareCacheLoader<ICacheKey<String>, String> tieredCacheLoaderWithNoException = new LoadAwareCacheLoader<>() {
        ICacheKey<String> key2 = getICacheKey("key2");
                    .build(),  
        );
        return new LoadAwareCacheLoader<>() {
                onHeapCacheSize * keyValueSize + "b"
        int onHeapCacheSize = randomIntBetween(10, 30);  
        // disabled.
                .build()
            removalListener,
            )
                throw new RuntimeException(e);
                    new MockDiskCache.MockDiskCacheFactory(0, diskSizeFromImplSetting, false, keyValueSize)  
                .build(),  
        int numberOfSameKeys = randomIntBetween(400, onHeapCacheSize - 1);
        TieredSpilloverCache<String, String> tieredSpilloverCache = (TieredSpilloverCache<String, String>) tieredSpilloverICache;
            false,
                Map.of(  
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
    }
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(
        if (diskPolicies != null) {  
        assertEquals(0, removalListener.evictionsMetric.count());
        TimeValue validDuration = new TimeValue(0, TimeUnit.MILLISECONDS);  
    public void testComputeIfAbsentWithEvictionsFromTieredCache() throws Exception {  
            numberOfSegments
    }
            throw new OpenSearchException("Exception occurred", e);
            keyValueSize  
        // Now turn off the disk tier and do more misses and evictions from the heap tier.
            ICacheKey<String> key = getICacheKey(UUID.randomUUID().toString());
            Settings.builder()
        // We should have 1 miss for each accepted key. Rejected keys should not cause misses.
        } catch (IOException e) {  
            )  
                }
        long expectedHeapSize = 256L * between(10, 20);
        }
                    .build(),
import java.util.concurrent.ExecutionException;
            numberOfSegments
            0,
        List<ICacheKey<String>> diskTierKeys = new ArrayList<>();
            boolean isLoaded = false;
            throw new OpenSearchException("Exception occurred", e);
            removalListener,
            keyValueSize  
            .setWeigher((k, v) -> 150)  
        assertEquals(diskTierKeys.size(), getHitsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
                    .setSettings(settings)  
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
        Map<Integer, Integer> segmentSizeTracker = new HashMap<>();
        assertEquals(totalOnDiskEntries, getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));  
        int onHeapCacheSize = randomIntBetween(10, 30);  
                if (mapValue == null) {  
    }
        assertEquals(
                    }  
            .setKeySerializer(new StringSerializer())
            .build();
            () -> new TieredSpilloverCache.TieredSpilloverCacheFactory().create(  
        checkSegmentSizes(tieredSpilloverCache, expectedHeapSize, expectedDiskSize);  
    }
        List<Predicate<String>> policies,
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
                .put(TOOK_TIME_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE).getKey(), TimeValue.ZERO)  
                    ).getKey(),  
        // after which it eviction flow is guaranteed to occur.
            }
        int totalOnDiskEntries = 0;  
            )
import java.util.function.Predicate;  
            CacheType.INDICES_REQUEST_CACHE
        }  
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()  
            1  
                MockDiskCache.MockDiskCacheFactory.NAME
            .build();  
            removalListener,
        public boolean test(String data) {
        // For disk policy function, allow if what it receives starts with "a" and string is even length  
                onHeapCacheSize * keyValueSize + "b"
            .put(
        // Put values in cache.  
        try (NodeEnvironment environment = newNodeEnvironment(settings)) {
        return initializeTieredSpilloverCache(
        assertEquals((numRepetitionsPerKey - 1) * expectedKeys, getHitsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));  
        List<ICacheKey<String>> onHeapCacheKeys = new ArrayList<>();  
        tieredSpilloverCache.getOnHeapCacheKeys().forEach(actualOnHeapCacheKeys::add);
        int newMisses = 0;
                        public boolean isLoaded() {
            onHeapCacheSizeInBytes,
            null,  
        List<Predicate<String>> diskPolicies = setupTuple.v1();
        ICache<String, String> tieredSpilloverICache = new TieredSpilloverCache.TieredSpilloverCacheFactory().create(
            null,
        List<ICacheKey<String>> newKeyList = new ArrayList<>();
                            @Override
            .put(
            public String load(ICacheKey<String> key) {  
        int keyValueSize = 50;
                        CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()  
            ICacheKey<String> iCacheKey = getICacheKey(key);
                TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME  
                    int index = randomIntBetween(0, diskTierKeys.size() - 1);  
        int keyValueSize = 50;
            boolean isLoaded = false;  
            )
    public void testDropStatsForDimensions() throws Exception {
                } catch (Exception e) {  
        );  
        int diskCacheSize = randomIntBetween(60, 100);
            randomIntBetween(1, 4),
            String computedValue = tieredSpilloverCache.get(getICacheKey(key));
                .build(),
                    }
        int keyValueSize = 50;  
            .build();  
                    .setWeigher((k, v) -> keyValueSize)
import org.opensearch.common.settings.Settings;  
import org.opensearch.common.cache.ICache;
        tieredSpilloverCache.computeIfAbsent(keyToBeEvicted, getLoadAwareCacheLoader());  
            .setClusterSettings(clusterSettings)
                .build(),
            public String load(ICacheKey<String> key) {
                        onHeapCacheSize * keyValueSize + "b"
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_NAME.getConcreteSettingForNamespace(  
            try {
            removalListener,  
        Map<Integer, Integer> expectedSegmentOnHeapCacheSize = getSegmentOnHeapCacheSize(  
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_DISK_STORE_NAME.getConcreteSettingForNamespace(
        Settings settings = Settings.builder()
        Map<String, Tuple<String, Boolean>> keyValuePairs = setupTuple.v2();
        clusterSettings.applySettings(  
        );
                    ).getKey(),
        ICacheKey<String> key1 = getICacheKey("key1");
        for (int i = 0; i < numberOfSegments; i++) {
        );
import static org.opensearch.common.cache.store.settings.OpenSearchOnHeapCacheSettings.MAXIMUM_SIZE_IN_BYTES_KEY;  
                return isLoaded;
            )
            removalListener,  
                isLoaded = true;  
            numberOfSegments  
                    )  
            }
                    exceptionCount.incrementAndGet();
import java.util.Map;
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
                expectedHeapSize + "b"
        int keyValueSize = 11;
            }  
        int keyValueSize = 50;
        for (int i = 0; i < numberOfSegments; i++) {
        @Override
                    .setCachedResultParser(s -> new CachedQueryResult.PolicyValues(DEFAULT_TOOK_TIME_DISK_THRESHOLD.getNanos() * 2))
            numberOfSegments  
            removalListener,
        }  
        CacheConfig<String, String> cacheConfig = new CacheConfig.Builder<String, String>().setKeyType(String.class)  
        int keyValueSize = 50;  
        List<Predicate<String>> diskPolicies,  
                    .build()  
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(
        ICache mockDiskCache = mock(ICache.class);
    ) throws InterruptedException {
                    } finally {
        // Since all the keys have the same dimension values, except tiers, we only need to remove that one, and we expect all stats values
        int numOfItems1 = randomIntBetween(onHeapCacheSize + 1, totalSize);  
        String value = UUID.randomUUID().toString();  
import org.opensearch.common.cache.store.OpenSearchOnHeapCache;
                    .setWeigher((k, v) -> keyValueSize)
            .put(
            )
        tookTimeMap.put("a", diskThresholdNanos);
            )  
        for (String dimensionName : dimensionNames) {
    }
            }  
        for (ICacheKey<String> diskKey : diskCacheKeys) {
            diskCacheSize,
        LoadAwareCacheLoader<ICacheKey<String>, String> loadAwareCacheLoader = getLoadAwareCacheLoader();  
                    .setStoragePath(storagePath)  
        // Set the desired settings needed to create a TieredSpilloverCache object with INDICES_REQUEST_CACHE cacheType.
                    assertNotNull(tieredSpilloverCache.get(onHeapKeys.get(index)));
            dims.add("0");
    }  
            if (expectedInDiskTierMap.get(key)) {
        for (ICacheKey<String> key : diskTierKeys) {
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();  
        );  
        assertEquals(onHeapCacheSize * keyValueSize, getSizeInBytesForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();  
            removalListener,
                threads[threadNumber].start();
        List<String> mockDimensions = getMockDimensions();
        ICache mockOnHeapCache = mock(ICache.class);  
            .setRemovalListener(removalListener)
                int index = randomIntBetween(0, keys.size() - 1);
                new CacheConfig.Builder<String, String>().setKeyType(String.class)
            @Override
        assertEquals(0, removalListener.evictionsMetric.count());
                                                                                                                                    // same.  
        }
    }
        // Verify exception count was equal to number of requests
            }
        Tuple<List<Predicate<String>>, Map<String, Tuple<String, Boolean>>> setupTuple = setupPoliciesTest();
        assertEquals(onHeapCacheSize, getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));  
            .put(
                        CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
            .setDimensionNames(dimensionNames)
        long missesBeforeDisablingDiskCache = totalStats.getMisses();  
                        @Override
        for (int iter = 0; iter < numOfItems1; iter++) {  
        CountDownLatch countDownLatch = new CountDownLatch(1);
            removalListener,
                .build(),  
                new MockDiskCache.MockDiskCacheFactory(0, randomIntBetween(100, 300), false, keyValueSize)  
    }
        );
                    .setKeyType(String.class)
            boolean isLoaded = false;
                )
            0,
        // Now on a different thread, try to get key(above one which got evicted) from tiered cache. We expect this
                new MockDiskCache.MockDiskCacheFactory(0, diskCacheSize * 500, false, keyValueSize)
                TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME
            removalListener,
        CacheConfig<String, String> cacheConfig = new CacheConfig.Builder<String, String>().setKeyType(String.class)
        int expectedEvictions = 0;  
        ImmutableCacheStats snapshot = cacheStats.getStatsForDimensionValues(mockDimensions);  
                return false;  
import org.opensearch.common.cache.RemovalListener;
        int numberOfSegments = getNumberOfSegments();
        );
                    )
            LoadAwareCacheLoader<ICacheKey<String>, String> loadAwareCacheLoader = getLoadAwareCacheLoader();
    public void testEntryPoliciesConcurrentlyWithComputeIfAbsent() throws Exception {
        int keyValueSize,
                Map.of(
                return isLoaded;  
        }
        }
        phaser.arriveAndAwaitAdvance();  
        IllegalArgumentException ex = assertThrows(  
                    .setSettings(settings)
            return object.getBytes(charset);
                        }  
        }
                    tieredSpilloverCache.computeIfAbsent(key, loader);
         */  
                // expect a hit  
                .build(),  
            .put(
        List<LoadAwareCacheLoader<ICacheKey<String>, String>> loadAwareCacheLoaderList = new CopyOnWriteArrayList<>();
                    )
            .put(
        int diskCacheSize = 3;
        assertEquals(numOfItems1, getMissesForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
            1
        return new Tuple<>(policies, keyValuePairs);
            1
        LoadAwareCacheLoader<ICacheKey<String>, String> loadAwareCacheLoader = new LoadAwareCacheLoader<>() {
    public void testCacheKeys() throws Exception {
                .setKeyType(String.class)
        }
        assertEquals(  
            @Override
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
        String value = tieredSpilloverCache.computeIfAbsent(key, tieredCacheLoaderWithNoException);
                MockDiskCache.MockDiskCacheFactory.NAME
        int onHeapCacheSize = randomIntBetween(300, 600);
        assertEquals(  
            LoadAwareCacheLoader<ICacheKey<String>, String> tieredCacheLoader = getLoadAwareCacheLoader();
            )
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(  
        } catch (IOException e) {
        // We expect values that were evicted from the heap tier and not allowed into the disk tier by the policy  
                OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME  
        AtomicInteger exceptionCount = new AtomicInteger();
import org.opensearch.common.cache.serializer.Serializer;
        assertEquals(0, getHitsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));  
            }
    }
            assertNotNull(tieredSpilloverCache.get(key));  
            .build();
                    (onHeapCacheSize * keyValueSize) + "b"
        return cacheStats.getStatsForDimensionValues(List.of());
        final CounterMetric evictionsMetric = new CounterMetric();  
        Tuple<List<Predicate<String>>, Map<String, Tuple<String, Boolean>>> setupTuple = setupPoliciesTest();
        assertTrue(totalStats.getMisses() > 0);
        String storagePath;
                Settings.builder()  
                CacheType.INDICES_REQUEST_CACHE,  
                    .build(),
            perSegmentEntryCapacity.put(i, totalEntriesForSegment);
        }  
                    CacheSettings.getConcreteStoreNameSettingForCacheType(CacheType.INDICES_REQUEST_CACHE).getKey(),
        @Override
        int diskCacheSize = randomIntBetween(200, 400);
            "No associated diskCache found for tieredSpilloverCache for " + "cacheType:" + CacheType.INDICES_REQUEST_CACHE
        // Set the desired settings needed to create a TieredSpilloverCache object with INDICES_REQUEST_CACHE cacheType.
                .put(  
            0,  
                    assertEquals(expectedException, e.getCause().getClass());  
            .setWeigher((k, v) -> keyValueSize)  
                Integer updatedValue = segmentSizeTracker.get(keySegment) + 1;
            }  
        assertEquals(lastKnownTieredCacheEntriesCount - diskCacheKeys.size(), tieredSpilloverCache.count());
                OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME
                        CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
                    .setValueSerializer(new StringSerializer())  
            removalListener,
            )  
                assertNull(result);
            removalListener,  
        return getStatsSnapshotForTier(tsc, tierValue).getMisses();  
                    ).getKey(),  
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_NAME.getConcreteSettingForNamespace(
            IllegalArgumentException.class,
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
            .build();  
            .setDiskCacheSize(diskCacheSize)  
/*  
        for (int iter = 0; iter < numOfItems1; iter++) {
            assertTrue(actualOnHeapKeys.contains(onHeapKey));  
                .setKeySerializer(new StringSerializer())  
            randomIntBetween(1, 4),  
import static org.mockito.Mockito.mock;  
import org.opensearch.common.settings.ClusterSettings;
        assertEquals(1, getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
        thread.start();  
        String storagePath = getStoragePath(settings);
                    .setDimensionNames(dimensionNames)  
                onHeapCacheSize * keyValueSize + "b"
                )  
        // to count towards total evictions
            tieredSpilloverCache.computeIfAbsent(iCacheKey, tieredCacheLoader);
            ICacheKey<String> key = getICacheKey(UUID.randomUUID().toString());  
        assertEquals(cacheHit, getHitsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
            .build();
            0,
            settings,
        // Testing keys() which returns all keys.  
                    TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
        }  
        // Turn the disk cache back on in cluster settings for other tests
                onHeapCacheSize * keyValueSize + "b"
        int onHeapCacheSize = randomIntBetween(10, 30);
            keyValueSize,
            .put(  
                    }  
         * totalHits = heapHits + diskHits
            keyValueSize,  
    private long getMissesForTier(TieredSpilloverCache<?, ?> tsc, String tierValue) throws IOException {
            .build();
        long lastKnownTieredCacheEntriesCount = tieredSpilloverCache.count();  
        int numOfItems1 = randomIntBetween(onHeapCacheSize + 1, totalSize);
                return null;
                    new MockDiskCache.MockDiskCacheFactory(0, randomIntBetween(100, 300), false, keyValueSize)
            storagePath = environment.nodePaths()[0].path + "/test";
        tieredSpilloverCache.refresh();  
        tieredSpilloverCache.enableDisableDiskCache(false); // Disable disk cache now.
                    OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME,
        );
        Map<ICacheKey<String>, TieredSpilloverCache.TieredSpilloverCacheSegment<String, String>> tieredSpilloverCacheSegmentMap =  
        int keyValueSize = 50;
        );
            public String load(ICacheKey<String> key) {
        );
    }
        assertEquals(cacheMiss + numOfItems1, getMissesForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
        assertEquals(totalStats.getMisses(), diskStats.getMisses());
                        countDownLatch.countDown();
            tieredSpilloverCache.computeIfAbsent(key, getLoadAwareCacheLoader());
    }  
            .setSettings(
        }
            policies,
                    TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
    }
                ).getKey(),
        tookTimeMap.put("b", 0L);  
            } else {
            tieredSpilloverCache.computeIfAbsent(key, getLoadAwareCacheLoader());
    }
            boolean isLoaded = false;
            throw new OpenSearchException("Exception occurred", e);
            Settings.builder()
        int onHeapCacheHit = 0;  
        }
                ).getKey(),  
        assertBusy(() -> { assertTrue(loadAwareCacheLoader.isLoaded()); }, 100, TimeUnit.MILLISECONDS); // We wait for new key to be loaded
        // Map from key to tuple of (value, whether we expect it to be admitted by policy)  
        executorService.shutdownNow();  
        TieredSpilloverCache<String, String> tieredSpilloverCache = getTieredSpilloverCache(  
        ImmutableCacheStats diskStats = getStatsSnapshotForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK);
        );  
        int expectedDiskEntries = numOfItems1 - onHeapCacheSize;
            }
import org.opensearch.OpenSearchException;
            diskTierKeys.add(key);  
        String storagePath;  
            }
    private TieredSpilloverCache<String, String> initializeTieredSpilloverCache(
    public void testTiersDoNotTrackStats() throws Exception {
            )
            "No associated onHeapCache found for tieredSpilloverCache for " + "cacheType:" + CacheType.INDICES_REQUEST_CACHE
                ).getKey(),
                    .setCachedResultParser(s -> new CachedQueryResult.PolicyValues(DEFAULT_TOOK_TIME_DISK_THRESHOLD.getNanos() * 2))
                MockDiskCache.MockDiskCacheFactory.NAME
        int onHeapCacheSize = randomIntBetween(10, 30);
        }  
        int totalSize = onHeapCacheSize + diskCacheSize;  
                tieredSpilloverCache.tieredSpilloverCacheSegments[keySegment];
                    .setRemovalListener(removalListener)
        Map<Integer, Integer> expectedSegmentDiskCacheSize = new HashMap<>();
        Map<Integer, Integer> mockDiskCacheExpectedSize = getSegmentMockDiskCacheSize(numberOfSegments, diskCacheSize);  
        );
            Boolean expectedOutput = keyValuePairs.get(key).v2();
        for (int i = 0; i < numberOfSegments; i++) {
        for (int i = 0; i < onHeapCacheSize; i++) {  
        ICacheKey<String> keyToBeEvicted = getICacheKey("key1");
            }
            "C",
                assertNull(result);
            )
        return getStatsSnapshotForTier(tsc, tierValue).getHits();
import java.nio.charset.Charset;
        int keyValueSize = 50;
            }  
                .setSettings(settings)
            )
            ),
        Settings settings = Settings.builder()
        int onHeapCacheSize = 10;  
                .put(
import org.opensearch.common.cache.stats.ImmutableCacheStats;  
    }
            if (segmentSizeTracker.get(i) == null) {
    }  
            ICacheKey<String> iCacheKey = getICacheKey(key);
    }  
            1
                .build(),
    public void testTierStatsAddCorrectly() throws Exception {
    // Duplicated here from EhcacheDiskCacheTests.java, we can't add a dependency on that plugin
        int numberOfSegments  
            )
                return false;
            int finalJ = j;  
import static org.opensearch.cache.common.tier.TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE;  
                onHeapCacheSize * keyValueSize + "b"
            LoadAwareCacheLoader<ICacheKey<String>, String> tieredCacheLoader = getLoadAwareCacheLoader();  
                // Should retrieve from heap tier if it was accepted  
            false
            1
            .put(  
    }  
            String,  
            mockDiskCacheFactory,
    }
        assertTrue(VALID_SEGMENT_COUNT_VALUES.contains(tieredSpilloverCache.getNumberOfSegments()));
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(
            @Override  
            )  
            false,
                removalListener,
        int cacheHit = 0;
        // should always be respected, overriding the individual implementation's size settings if present  
    private TieredSpilloverCache<String, String> getTieredSpilloverCache(
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_DISK_STORE_NAME.getConcreteSettingForNamespace(
                                return iCacheKeyList.get(finalJ).key;  
        }  
                        CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()  
    private void checkSegmentSizes(TieredSpilloverCache<String, String> cache, long expectedHeapSize, long expectedDiskSize) {
                isLoaded = true;
        keyValuePairs.put("key1", new Tuple<>("abcd", true));
                    new MockDiskCache.MockDiskCacheFactory(0, randomIntBetween(100, 300), false, keyValueSize)
        int diskCacheSize = randomIntBetween(450, 800);
        assertEquals(heapTierEvictionsBeforeDisablingDiskCache + newMisses, heapStats.getEvictions());
        int diskCacheSize = randomIntBetween(60, 100);
            // Hit cache with randomized key which is expected to miss cache always.
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_NAME.getConcreteSettingForNamespace(
            @Override  
    public void testTookTimePoliciesFromFactory() throws Exception {
        assertEquals(1, getEvictionsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
            diskCacheSize,
            ICacheKey<String> iCacheKey = getICacheKey(key);  
            @Override  
                    new TimeValue(diskThresholdNanos / 1_000_000)  
            .setSegmentCount(numberOfSegments)
                    new OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory(),
        int totalSize = onHeapCacheSize + diskCacheSize;
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()  
                    new MockDiskCache.MockDiskCacheFactory(0, randomIntBetween(100, 300), false, keyValueSize)  
            .setDiskCacheSize(diskCacheSize)  
            settings,
    public void testComputeIfAbsentWithEvictionsFromOnHeapCache() throws Exception {  
        // Try to hit cache again with some randomization.  
                    TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
        return expectedSegmentDiskCacheSize;  
        // Verify the keys for onHeap and disk cache  
            numberOfSegments  
        int diskCacheSize = randomIntBetween(300, 500);  
            .put(TIERED_SPILLOVER_SEGMENTS.getConcreteSettingForNamespace(CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()).getKey(), 1)
                ).getKey(),
        // Also do some random hits
        Thread thread1 = new Thread(() -> {
    public void testMinimumThresholdSettingValue() throws Exception {  
            LoadAwareCacheLoader<ICacheKey<String>, String> loadAwareCacheLoader = getLoadAwareCacheLoader();  
            1
        }
        return randomFrom(2, 4, 8, 16, 32, 64, 128, 256);
        int expectedKeys = 0;
        TieredSpilloverCache<String, String> tieredSpilloverCache = new TieredSpilloverCache.Builder<String, String>()
                    onHeapCacheSize * keyValueSize + "b"
            0,  
                return isLoaded;  
        }
        public void onRemoval(RemovalNotification<ICacheKey<K>, V> notification) {  
        assertEquals(0, getEvictionsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
                    .setStoragePath(storagePath)
        assertEquals(expectedKeys, getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
                assertNull(tieredSpilloverCache.get(getICacheKey(UUID.randomUUID().toString())));
        List<ICacheKey<String>> diskKeys = new ArrayList<>();
        // exception.
        public boolean equals(String object, byte[] bytes) {
            .setNumberOfSegments(1)
            new MockDiskCache.MockDiskCacheFactory(0, diskSizeFromImplSetting, true, keyValueSize),
        String[] levels = levelsList.toArray(new String[0]);  
        int numRandom = randomIntBetween(50, 200);  
        int diskCacheSize = randomIntBetween(700, 1200);  
                    TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
                    TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
                onHeapKeys.add(key);  
                onHeapCacheSize * keyValueSize + "b"
            LoadAwareCacheLoader<ICacheKey<String>, String> tieredCacheLoader = getLoadAwareCacheLoader();  
            tieredSpilloverCache.computeIfAbsent(key, tieredCacheLoader);  
                        CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
        Settings settings = Settings.builder()
        private final Charset charset = StandardCharsets.UTF_8;
        // Evictions metric shouldn't increase for invalidations.
                ).getKey(),  
        long onHeapCacheSizeInBytes,  
            diskDeliberateDelay,  
        assertEquals(0, tieredSpilloverCache.completableFutureMap.size());  
            .setClusterSettings(clusterSettings)  
            )  
                OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME,  
                onHeapCacheSize * keyValueSize + "b"
        tieredSpilloverCache.tieredSpilloverCacheSegments[0].getOnHeapCache().keys().forEach(onHeapKeys::add);  
            } else {
            ICacheKey<String> key = getICacheKey(UUID.randomUUID().toString());
            onHeapKeys.add(key);
            .build();
        // Also check the heap stats don't have zero misses or evictions  
                .setWeigher((k, v) -> keyValueSize)
                )
            LoadAwareCacheLoader<ICacheKey<String>, String> tieredCacheLoader = getLoadAwareCacheLoader();
            removalListener,
                    new OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory(),  
    public void testWithFactoryCreationWithDiskCacheNotPresent() {  
            diskCacheSize,  
        int onHeapCacheSize = randomIntBetween(100, 300);
        assertEquals(
                new CacheConfig.Builder<String, String>().setKeyType(String.class)  
            if (expectedOutput) {
            .put(  
        int keyValueSize = 50;
                        CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
            // Initialize the settings to some other value, so we can demonstrate the updating logic works correctly.  
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
                .build(),  
            .put(  
            ICacheKey<String> key = getICacheKey(UUID.randomUUID().toString());
    public void setup() {  
        int numberOfSegments = getNumberOfSegments();  
import static org.opensearch.cache.common.tier.TieredSpilloverCacheSettings.DISK_CACHE_ENABLED_SETTING_MAP;
        for (String key : keyValuePairs.keySet()) {
        clusterSettings.registerSetting(TOOK_TIME_DISK_TIER_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE));
                )  
            String key = UUID.randomUUID().toString();  
            if (segmentSizeTracker.get(i) > perSegmentEntryCapacity.get(i)) {
                ).getKey(),
            .build();
            ICacheKey<String> key = getICacheKey(UUID.randomUUID().toString());
            if (loader.isLoaded()) {  
            keyValueSize,
    public void testPutWithDiskCacheDisabledSetting() throws Exception {
    private static class AllowEvenLengths implements Predicate<String> {
        tieredSpilloverCache.invalidateAll();
            iCacheKeyList.add(key);
            .setDiskCacheFactory(mockDiskCacheFactory)  
        assertEquals(0, getHitsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));  
            .put(TIERED_SPILLOVER_SEGMENTS.getConcreteSettingForNamespace(CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()).getKey(), 1)  
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_NAME.getConcreteSettingForNamespace(
        assertEquals(1, tieredSpilloverCache.count());  
    }
            LoadAwareCacheLoader<ICacheKey<String>, String> tieredCacheLoader = getLoadAwareCacheLoader();
                onHeapCacheSize * keyValueSize + "b"
            tieredSpilloverCache.tieredSpilloverCacheSegments[0].getOnHeapCache().stats().getTotalStats()
            diskCacheSize  
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(  
                Integer updatedValue = segmentSizeTracker.get(keySegment) + 1;
                ).getKey(),  
            @Override
            int keySegment = tieredSpilloverCache.getSegmentNumber(key);  
        int numOfItems1 = randomIntBetween(onHeapCacheSize + 1, totalSize);
            .build();
        List<Predicate<String>> diskPolicies,
            .setNumberOfSegments(numberOfSegments)  
            null,
        countDownLatch1.await();  
        }
            @Override
                    keyValueSize * keyValuePairs.size() + 1 + "b"  
        List<ICacheKey<String>> actualOnHeapCacheKeys = new ArrayList<>();  
            diskCacheSize,  
        Settings settings = Settings.builder()
        ICacheKey<String> secondKey = getICacheKey("key2");  
        }
        ICacheKey<String> key = getICacheKey(UUID.randomUUID().toString());
                tieredSpilloverCache.computeIfAbsent(keys.get(index), getLoadAwareCacheLoader());  
            TieredSpilloverCache.TieredSpilloverCacheSegment<String, String> segment =
        int numberOfSegments
        response = tieredSpilloverCache.computeIfAbsent(getICacheKey("test"), new LoadAwareCacheLoader<>() {
                continue;
                assertFalse(loadAwareCacheLoader.isLoaded());  
            .put(  
                    new OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory(),  
            true,
            tieredSpilloverCache.computeIfAbsent(key, tieredCacheLoader);
        assertEquals(0, tieredSpilloverCache.count());
                new MockDiskCache.MockDiskCacheFactory(0, randomIntBetween(100, 300), false, keyValueSize)
                        CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
            String result = tieredSpilloverCache.get(iCacheKey);  
            threads[i].start();  
            }
            0,
                // In this case onHeap cache wasn't utilized fully.
            .put(
        // Considering onHeap cache was already full, we should have some onHeap entries being evicted.
            } else {
        assertEquals(  
        List<ICacheKey<String>> usedKeys = new ArrayList<>();
        ICache.Factory onHeapCacheFactory = new OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory();  
        ICacheKey<String> dropDimensionsKey = new ICacheKey<>(null, getMockDimensions());
        }
    }  
        );
        Map<String, Boolean> expectedInDiskTierMap = Map.of(
                ).getKey(),
            onHeapCacheSize * keyValueSize,
        List<ICacheKey<String>> diskTierKeys = new ArrayList<>();  
                    .setValueSerializer(new StringSerializer())
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(
            diskCacheSize,
            false,
        }  
            .setValueSerializer(new StringSerializer())
        TieredSpilloverCache<String, String> tieredSpilloverCache = getTieredSpilloverCache(  
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
                // Hit cache with randomized key which is expected to miss cache always.
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
        Settings settings = Settings.builder()  
        int keyValueSize = 50;  
            );
            removalListener,
            ICacheKey<String> key = getICacheKey(UUID.randomUUID().toString());
            }
                    .setWeigher((k, v) -> keyValueSize)
            } else {  
            )
    }
        return storagePath;  
            }  
        // In another round, add another onHeapCacheSize entries. These will go to onHeap and above ones will be  
        int numOfItems2 = totalSize - numOfItems1;  
        return getStatsSnapshotForTier(tsc, tierValue).getEvictions();
        }  
                    .setSettings(settings)
            0,  
        int cacheMiss = 0;
            }  
            true,
            @Override
        int keyValueSize = 50;
                .build(),
        int keyValueSize = 1;
                    .put(
                // Hit cache with stored key  
                0,
                tieredSpilloverCache.computeIfAbsent(getICacheKey(UUID.randomUUID().toString()), getLoadAwareCacheLoader());  
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(  
            });  
            "A",
            keyValueSize,
            if (iter > (onHeapCacheSize - 1)) {
                    loadAwareCacheLoaderList.add(loadAwareCacheLoader);
        );
        assertTrue("default segments must be >= 1", segments >= 1);  
            null,
            tieredSpilloverCache.computeIfAbsent(getICacheKey(key), tieredCacheLoader);
                ).getKey(),  
            // The boolean here is not needed, just to fit with the get loader method
                    .setClusterSettings(clusterSettings)  
                CacheSettings.getConcreteStoreNameSettingForCacheType(CacheType.INDICES_REQUEST_CACHE).getKey(),
        int numMisses = onHeapCacheSize + diskCacheSize + randomIntBetween(10, 20);
        long diskDeliberateDelay,  
            INVALID_SEGMENT_COUNT_EXCEPTION_MESSAGE,
        verifyComputeIfAbsentThrowsException(RuntimeException.class, loadAwareCacheLoader, "Testing");
            int totalEntriesForSegment = onHeapCacheExpectedSize.get(i) + mockDiskCacheExpectedSize.get(i);  
            assertEquals(keyValuePairs.get(key).v1(), value);  
                .build(),  
                CacheSettings.getConcreteStoreNameSettingForCacheType(CacheType.INDICES_REQUEST_CACHE).getKey(),
        int segments = TieredSpilloverCacheSettings.defaultSegments();  
            keyValueSize,
        // Put another key/value so that one of the item is evicted to disk cache.  
    @Before
            )
import org.opensearch.common.settings.Setting;
        // With this call, we expect an exception from the underlying loader which eventually causes the below call to result into  
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();  
                .build(),  
        int totalSize = onHeapCacheSize + diskCacheSize;  
            .setCacheType(CacheType.INDICES_REQUEST_CACHE)  
            .put(  
                CacheType.INDICES_REQUEST_CACHE,  
        Map<String, Tuple<String, Boolean>> keyValuePairs = setupTuple.v2();
                ).getKey(),
                    new MockDiskCache.MockDiskCacheFactory(0, randomIntBetween(100, 300), false, keyValueSize)
        // Now try to put key1 again onto tiered cache with new value.  
                )
        );
import static org.opensearch.cache.common.tier.TieredSpilloverCacheSettings.DEFAULT_TOOK_TIME_DISK_THRESHOLD;  
                        public String load(ICacheKey<String> key) {  
            null,
                1L  
            int keySegment = tieredSpilloverCache.getSegmentNumber(iCacheKey);
    public void testInvalidate() throws Exception {
                continue;  
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()  
        );
        int diskSizeFromImplSetting = 50;
            .setClusterSettings(clusterSettings)
            new ImmutableCacheStats(0, 0, 0, 0, 0),
            1
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
                    onHeapCacheSize * keyValueSize + "b"
        Map<Integer, Integer> perSegmentEntryCapacity = new HashMap<>();
            @Override  
                OpenSearchOnHeapCacheSettings.MAXIMUM_SIZE_IN_BYTES.getConcreteSettingForNamespace(
                    assertEquals(expectedExceptionMessage, e.getCause().getMessage());
        long heapTierEvictionsBeforeDisablingDiskCache = heapStats.getEvictions();
        assertEquals(0, removalListener.evictionsMetric.count());
            public boolean isLoaded() {  
        }  
            LoadAwareCacheLoader<ICacheKey<String>, String> tieredCacheLoader = getLoadAwareCacheLoader();  
    public void testComputeIfAbsentConcurrentlyWithLoaderReturningNull() throws Exception {
    }
                            return isLoaded;
        String storagePath = getStoragePath(settings);
        );  
        int diskCacheSize,  
        ICache.Factory onHeapCacheFactory,
                    TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
            .setValueSerializer(new StringSerializer())
                        tieredSpilloverCache.computeIfAbsent(iCacheKey, loader);  
            LoadAwareCacheLoader<ICacheKey<String>, String> tieredCacheLoader = getLoadAwareCacheLoader();  
        for (int iter = 0; iter < numOfItems2; iter++) {
        int keyValueSize = 50;
                    // Values will always appear to have taken 2x the took time threshold to compute, so they will be admitted
        Thread[] threads = new Thread[numberOfSameKeys];  
                    OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME,
                )
    private TieredSpilloverCache<String, String> initializeTieredSpilloverCache(
                .setSettings(settings)
                )
        countDownLatch.await();
        }
            diskCacheSize,
                .setKeyType(String.class)  
                .setRemovalListener(removalListener)
import static org.mockito.Mockito.doThrow;
                .setSegmentCount(numberOfSegments)
        tieredSpilloverCache.invalidate(key);  
        assertEquals(expectedMergedKeys.size(), actualMergedKeys.size());  
        int onHeapCacheSize = randomIntBetween(10, 30);
    ) {
        CacheConfig<String, String> cacheConfig = getCacheConfig(keyValueSize, settings, removalListener, 1);  
        ImmutableCacheStatsHolder cacheStats = tsc.stats(levels);
        int numSegments = getNumberOfSegments();
 * compatible open source license.
                        CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
        int onHeapCacheSize = 1;  
        CacheConfig<String, String> cacheConfig,
import org.junit.Before;
            .put(  
                    try {  
        assertEquals(0, getEvictionsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
                expectedNumberOfEntriesInSegment.put(keySegment, Integer.valueOf(1));
        Phaser phaser = new Phaser(numberOfSameKeys + 1);
            storagePath = environment.nodePaths()[0].path + "/test";
        @Override  
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
        // This first computeIfAbsent ensures onHeap cache has 1 item present and rest will be evicted to disk.
        int numberOfSegments = getNumberOfSegments();
                    TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(  
        tieredSpilloverCache.put(key1, "dummy");
            ICacheKey<String> key = usedKeys.get(rand.nextInt(usedKeys.size()));
                OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME
    ) {  
        tieredSpilloverCache.put(key2, UUID.randomUUID().toString());
            .put(  
                ).getKey(),
            Settings.builder()
                            .get(MAXIMUM_SIZE_IN_BYTES_KEY)
            }
import static org.opensearch.cache.common.tier.TieredSpilloverCacheSettings.TOOK_TIME_POLICY_CONCRETE_SETTINGS_MAP;  
            if (expectedNumberOfEntriesInSegment.get(i) >= expectedSegmentOnHeapCacheSize.get(i)) {  
    }
        }
            settings,
            onHeapCacheSize * keyValueSize,  
            public boolean isLoaded() {
    }  
                MockDiskCache.MockDiskCacheFactory.NAME
                .setRemovalListener(removalListener)
        for (int i = 0; i < numberOfSameKeys; i++) {  
                )
            LoadAwareCacheLoader<ICacheKey<String>, String> loader = loadAwareCacheLoaderList.get(i);
        // Try to hit cache again with some randomization.
                keySegment
                isLoaded = true;
                threads[threadNumber] = new Thread(() -> {
        List<Predicate<String>> policies = setupTuple.v1();  
            if (segmentSizeTracker.get(i) == null) {
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_DISK_STORE_SIZE.getConcreteSettingForNamespace(  
                OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME  
                // Values will always appear to have taken 2x the took time threshold to compute, so they will be admitted
        assertEquals(expectedDiskEntries, getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));  
                try {  
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
        }
import static org.opensearch.cache.common.tier.TieredSpilloverCacheStatsHolder.TIER_DIMENSION_NAME;
            }
            .build();
        for (int i = 0; i < numberOfKeys; i++) {  
 */  
                .build(),
            tieredSpilloverCache.computeIfAbsent(key, tieredCacheLoader);
        }
            cacheMiss++;
        assertEquals(0, getEvictionsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
            0,
        when(mockDiskCacheFactory.create(any(), any(), any())).thenReturn(mockDiskCache);  
        String storagePath;  
                    ).getKey(),  
        int diskCacheSize = tookTimeMap.size();
                // Should retrieve from heap tier if it was accepted
        // Verify disk cache stats.
                    ).getKey(),
    }
            () -> new TieredSpilloverCache.TieredSpilloverCacheFactory().create(
                return expectedRespone;
                        countDownLatch.countDown();
            usedKeys.add(key);
        List<ICacheKey<String>> diskTierKeys = new ArrayList<>();
                        onHeapCacheSize * keyValueSize + "b"
        assertEquals(0, tieredSpilloverCache.diskCacheCount()); // Disk cache shouldn't have anything considering it is  
        int numberOfSameKeys = randomIntBetween(10, onHeapCacheSize - 1);
        assertTrue("default segments must be a valid (power-of-two) count", VALID_SEGMENT_COUNT_VALUES.contains(segments));
        long diskThresholdNanos = 11_000_000L;  
import java.io.IOException;
        tieredSpilloverCache.invalidate(key);  
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
        tieredSpilloverCache.put(key2, "key2"); // Goes to onHeap cache. And key1 evicted to disk cache.
                OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME
        @Override  
import org.opensearch.core.tasks.TaskCancelledException;
            diskCacheSize,  
            0,
            .setWeigher((k, v) -> keyValueSize)
        for (int i = 0; i < loadAwareCacheLoaderList.size(); i++) {
        LoadAwareCacheLoader<ICacheKey<String>, String> loader = getLoadAwareCacheLoader(keyValuePairs);
        int diskCacheSize = randomIntBetween(700, 1200);  
        ICacheKey<String> key = getICacheKey(UUID.randomUUID().toString());
        assertEquals("test", response);
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_NAME.getConcreteSettingForNamespace(
                )
            } catch (Exception e) {
        assertEquals(0, getEvictionsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
    public void testTieredCacheThrowingExceptionOnPerSegmentSizeBeingZero() {
            cacheConfig,  
                            isLoaded = true;
        }  
        assertEquals(0, getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
        );  
                CacheSettings.getConcreteStoreNameSettingForCacheType(CacheType.INDICES_REQUEST_CACHE).getKey(),
    private String getStoragePath(Settings settings) {
                new OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory(),
            .setOnHeapCacheSizeInBytes(onHeapCacheSize * keyValueSize)
import java.util.concurrent.Phaser;
            )  
                    TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(  
            tieredSpilloverCache.put(iCacheKey, keyValuePairs.get(key).v1());
            tieredSpilloverCache.invalidate(diskKey);
                )  
            .put(TIERED_SPILLOVER_SEGMENTS.getConcreteSettingForNamespace(CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()).getKey(), 3)  
                .setSettings(settings)
            false,
        assertNotEquals(new ImmutableCacheStats(0, 0, 0, 0, 0), tieredSpilloverCache.stats().getTotalStats());
                // Should miss as heap tier size = 0 and the policy rejected it  
        List<ICacheKey<String>> diskTierKeys = new ArrayList<>();
                MockDiskCache.MockDiskCacheFactory.NAME
            ICacheKey<String> key = getICacheKey(UUID.randomUUID().toString());  
        assertEquals(expectedDiskSize / cache.getNumberOfSegments(), segment.getDiskCacheMaxWeight());
            Map.of(
        assertEquals(0, tieredSpilloverCache.completableFutureMap.size());  
                        CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
        }  
                    .setSettings(settings)
            }
                    .setWeigher((k, v) -> keyValueSize)
    public void testComputeIfAbsentWithFactoryBasedCacheCreation() throws Exception {
        assertEquals(0, tieredSpilloverCache.count());
        mockDimensions.add(tierValue);
                diskCacheSize,  
            .build();
                return false;
        Map<String, String> keyValueMap = Map.of("A", "a", "B", "b", "C", "c", "D", "d", "E", "e", "F", "f", "G", "g");
        assertTrue(totalStats.getEvictions() > 0);  
        });
            )
        long expectedDiskSize = MIN_DISK_CACHE_SIZE_IN_BYTES + 256L * between(30, 40);
        assertEquals(expectedEvictions, removalListener.evictionsMetric.count());  
                ).getKey(),
            }
        assertEquals(expectedDiskEntries, getEvictionsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
        RemovalListener<ICacheKey<String>, String> removalListener,
        // cache
                    };
        assertEquals(0, tieredSpilloverCache.completableFutureMap.size());
    }  
    @SuppressWarnings({ "rawtypes", "unchecked" })
        // We should see only one heap miss, and the rest hits
 *
        int keyValueSize = 50;
            segments <= TieredSpilloverCacheSettings.DEFAULT_SEGMENT_COUNT_CEILING
        long actualTieredCacheCount = tieredSpilloverCache.count();  
    ) {  
            storagePath = environment.nodePaths()[0].path + "/test";  
        }
            IllegalArgumentException.class,  
        tookTimeMap.put("g", cacheThresholdNanos - 1);
                    // Values will always appear to have taken 2x the took time threshold to compute, so they will be admitted
                    OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME,
                int index = randomIntBetween(0, diskTierKeys.size() - 1);  
            ZERO_SEGMENT_COUNT_EXCEPTION_MESSAGE,
                    ).getKey(),  
                OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME
        );
        for (int i = 0; i < onHeapCacheSize; i++) {
            public String load(ICacheKey<String> key) {
    public void testWithVeryLowDiskCacheSize() throws Exception {
        }
            numberOfSegments,
                    onHeapCacheSize * keyValueSize + "b"
        int keyValueSize = 50;
                builder.addDiskPolicy(diskPolicy);
                .build(),
                .setStoragePath(getStoragePath(settings))
            0,  
                    .build(),  
                .build(),  
            int perSegmentOnHeapCacheSizeBytes = onHeapCacheSizeInBytes / numberOfSegments;
        RemovalListener<ICacheKey<String>, String> removalListener,
            .setRemovalListener(removalListener)
        // Set the settings without onHeap cache settings.
        assertEquals(onHeapCacheSize * keyValueSize, getSizeInBytesForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
            keyValueSize,
        for (ICacheKey<String> key : onHeapKeys) {
            null,
        // TimeValue.ZERO (for example, MINUS_ONE)
        assertEquals(0, tieredSpilloverCache.diskCacheCount());  
                            public String load(ICacheKey<String> key) {
    }  
        assertTrue(onHeapCacheKeys.contains(key2));
                ).getKey(),  
            perSegmentEntryCapacity.put(i, totalEntriesForSegment);
                    try {  
        onHeapCacheKeys.clear();  
                ).getKey(),
                actualValue.set(tieredSpilloverCache.get(keyToBeEvicted));  
                ).getKey(),  
        tieredSpilloverCache.put(key1, "key1"); // Goes to onHeap cache.  
                )
            if (expectedNumberOfEntriesInSegment.get(keySegment) == null) {  
        int diskCacheSize = randomIntBetween(700, 1200);  
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(
        return new LoadAwareCacheLoader<>() {  
            tieredSpilloverCache.computeIfAbsent(iCacheKey, tieredCacheLoader);
            keyValueSize,  
            throw new OpenSearchException("Exception occurred", e);
            Settings.builder()
        assertEquals(totalOnHeapEntries, tieredSpilloverCache.onHeapCacheCount());  
import org.opensearch.common.cache.stats.ImmutableCacheStatsHolder;
                Map.of(
        }
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
        assertNotNull(actualValue.get());
            assertEquals(TaskCancelledException.class, ex.getCause().getClass());
                numberOfTimesKeyLoaded++;
        CacheConfig<String, String> cacheConfig = new CacheConfig.Builder<String, String>().setKeyType(String.class)
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()  
            removalListener,
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();  
        });
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()  
            ex.getMessage(),
import org.opensearch.common.cache.store.settings.OpenSearchOnHeapCacheSettings;
    static final List<String> dimensionNames = List.of("dim1", "dim2", "dim3");
        ICache.Factory mockDiskCacheFactory = mock(MockDiskCache.MockDiskCacheFactory.class);
        Settings settings = Settings.builder()  
            Settings.builder()
            threads[i] = new Thread(() -> {
            numSegments,
            numberOfSegments
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
        // First check whether keys respect the heap tier threshold.
            if (expectedOutput) {  
            tieredSpilloverCache.computeIfAbsent(iCacheKey, tieredCacheLoader);
        LoadAwareCacheLoader<ICacheKey<String>, String> loader = getLoadAwareCacheLoader(loaderMap);
                MockDiskCache.MockDiskCacheFactory.NAME,
            Settings.builder()  
        assertEquals(expectedKeys, getMissesForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
        int numOfItems = randomIntBetween(10, 30);  
            )
        }
                    } catch (Exception e) {
                .put(
                    mapValue = UUID.randomUUID().toString();
import java.util.concurrent.ExecutorService;
    }  
        for (int i = 0; i < numberOfSameKeys; i++) {
            false  
            0,  
         * totalMisses = diskMisses
        assertEquals(1, onHeapCacheKeys.size());  
        );
                cacheMiss++;
            expectedEvictions + getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK),
        int onHeapCacheSize = randomIntBetween(300, 600);
                diskTierKeys.add(key);
            String value = tieredSpilloverCache.computeIfAbsent(iCacheKey, loader);
        assertEquals(0, getEvictionsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
        LoadAwareCacheLoader<ICacheKey<String>, String> loader,
            new ArrayList<Predicate<String>>(),
        Random rand = Randomness.get();
        assertEquals(numOfItems1, getMissesForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
            .setStoragePath(storagePath)
        }
            int keySegment = tieredSpilloverCache.getSegmentNumber(iCacheKey);
            IllegalArgumentException.class,
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()  
        List<ICacheKey<String>> actualOnHeapKeys = new ArrayList<>();
                    TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()  
        int iterations = 10;  
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
            } else {  
        assertEquals(actualDiskCacheSize, getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
            public String load(ICacheKey<String> key) {  
                .put(DISK_CACHE_ENABLED_SETTING_MAP.get(CacheType.INDICES_REQUEST_CACHE).getKey(), false)
                CacheSettings.getConcreteStoreNameSettingForCacheType(CacheType.INDICES_REQUEST_CACHE).getKey(),
            tieredSpilloverCache.computeIfAbsent(getICacheKey(UUID.randomUUID().toString()), getLoadAwareCacheLoader());
        );  
                .put(  
        for (int i = 0; i < numberOfSegments; i++) {
            numberOfSegments
                .build(),
import static org.opensearch.cache.common.tier.TieredSpilloverCacheSettings.MIN_DISK_CACHE_SIZE_IN_BYTES;
        for (int i = 0; i < numOfItems; i++) {
            ICacheKey<String> iCacheKey = getICacheKey(key);
        int numberOfSegments = 1;  
import org.opensearch.common.cache.CacheType;  
                    .setDimensionNames(dimensionNames)
                    .setWeigher((k, v) -> keyValueSize)  
                LoadAwareCacheLoader<ICacheKey<String>, String> loadAwareCacheLoader = getLoadAwareCacheLoader();
        // Most of setup duplicated from testComputeIfAbsentWithFactoryBasedCacheCreation()  
            mockDiskCacheFactory,
    }
            Settings.builder()
            .setOnHeapCacheFactory(onHeapCacheFactory)
    ) {
        CountDownLatch countDownLatch = new CountDownLatch(numThreads);  
                ).getKey(),
                segmentSizeTracker.put(keySegment, updatedValue);  
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();  
    private Map<Integer, Integer> getSegmentMockDiskCacheSize(int numberOfSegments, int diskCacheSize) {  
            false,
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
        ICache.Factory mockDiskCacheFactory = new MockDiskCache.MockDiskCacheFactory(0, diskCacheSize, false, keyValueSize);
import org.opensearch.common.Randomness;
        CacheConfig<String, String> cacheConfig = getCacheConfig(1, settings, removalListener, numSegments);
            public String load(ICacheKey<String> key) {
                .put(  
        assertEquals(onHeapCacheHit, getHitsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));  
        if (policies != null) {
            if (expectedInCache) {
                    ).getKey(),
        int keyValueSize = 11;  
        int numSegments = getNumberOfSegments();
        int onHeapCacheSize = randomIntBetween(10, 30);  
        };
            }  
            .put(
import java.util.concurrent.atomic.AtomicReference;
        tieredSpilloverCache.getOnHeapCacheKeys().forEach(onHeapKeys::add);  
    }
            keyValueSize,  
                // Values will always appear to have taken 2x the took time threshold to compute, so they will be admitted
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
        }
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
            numberOfSegments  
        Map<Integer, Integer> onHeapCacheExpectedSize = getSegmentOnHeapCacheSize(
        int onHeapCacheSize = 500;  
            .setRemovalListener(removalListener)  
                    .setKeyType(String.class)  
        policies.add(new AllowEvenLengths());
            @Override
            Boolean expectedOutput = keyValuePairs.get(key).v2();
            ICacheKey<String> iCacheKey = getICacheKey(UUID.randomUUID().toString());
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();  
        int keyValueSize = 50;
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
    }
                )
        int approxNumHits = 30;
        String storagePath = getStoragePath(settings);  
                    assertEquals(ExecutionException.class, e.getClass());
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(
            try {
        keyValuePairs.put("key4", new Tuple<>("ab", true));
                )
                ).getKey(),
            CacheType.INDICES_REQUEST_CACHE,
                )  
            }
            } else {
                    .setValueSerializer(new StringSerializer())
        }
            countDownLatch.countDown();
        List<ICacheKey<String>> onHeapKeys = new ArrayList<>();
                return "test1";
                OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME,  
    public void testWithInvalidSegmentNumber() throws Exception {
                expectedKeys++;
                ).getKey(),
    }
        // Default must never exceed the ceiling, even on hosts with many CPU cores.
            diskCacheSize,
                TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME
            if (expectedNumberOfEntriesInSegment.get(i) == null) {  
                    throw new RuntimeException(e);  
        int numberOfTimesKeyLoaded = 0;
            .put(  
                    // Values will always appear to have taken 2x the took time threshold to compute, so they will be admitted  
                        return new CachedQueryResult.PolicyValues(tookTimeMap.get(s));
            } else { // Hit cache with key stored in disk cache.
            String>) new TieredSpilloverCache.TieredSpilloverCacheFactory().create(
        ICacheKey<String> key = getICacheKey(UUID.randomUUID().toString());  
            tieredSpilloverCache.count()
                )
            }
                    TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
                    // The size value passed in here acts as the "implementation setting" for the disk tier, and should also be ignored
            IllegalArgumentException.class,
            )  
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_DISK_STORE_NAME.getConcreteSettingForNamespace(  
        int onHeapCacheSize = randomIntBetween(10, 30);
                            CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()  
import org.opensearch.test.OpenSearchTestCase;
    private Map<Integer, Integer> getSegmentOnHeapCacheSize(int numberOfSegments, int onHeapCacheSizeInBytes, int keyValueSize) {
                        TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME  
                    .setStoragePath(storagePath)
        Settings settings = Settings.builder()  
            assertNotNull(tieredSpilloverCache.get(key));
        Settings settings = Settings.builder()  
        }  
            }
                    .setClusterSettings(clusterSettings)
    public void testDefaultSegmentsCappedAtCeiling() {
        assertEquals(1, diskKeys.size());
            ),
        ImmutableCacheStats heapStats = getStatsSnapshotForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP);  
                ).getKey(),
        tieredSpilloverCache.put(key, value);
    }  
                CacheType.INDICES_REQUEST_CACHE,
                0
    // Helper functions for extracting tier aggregated stats.  
                    .setRemovalListener(removalListener)  
            )
                ).getKey(),
        );
        int threadNumber = 0;
        assertEquals(numberOfSegments, tieredSpilloverCacheSegments.length);
                .put(  
        // Fill the cache, getting some entries + evictions for both tiers  
    public void testPut() throws Exception {
    }
        countDownLatch.await();
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(
        Settings settings = Settings.builder()
        assertEquals(totalStats.getHits(), heapStats.getHits() + diskStats.getHits());  
        int keyValueSize = 50;  
                    int index = randomIntBetween(0, onHeapKeys.size() - 1);  
        int numberOfSegments = getNumberOfSegments();
public class TieredSpilloverCacheTests extends OpenSearchTestCase {  
                new OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory(),
            "D",
        onHeapiterable.iterator().forEachRemaining(actualOnHeapKeys::add);  
import static org.opensearch.cache.common.tier.TieredSpilloverCacheStatsHolder.TIER_DIMENSION_VALUE_ON_HEAP;  
                threadNumber++;  
        assertEquals(newKeyList.size(), actualOnHeapCacheKeys.size());  
                numberOfTimesKeyLoaded++;
        // Put values in cache more than it's size and cause evictions from onHeap.
                ).getKey(),
            tieredSpilloverCacheSegmentMap.put(iCacheKey, tieredSpilloverCache.getTieredCacheSegment(iCacheKey));  
            .build();  
                MockDiskCache.MockDiskCacheFactory.NAME,
            evictionsMetric.inc();
                        boolean isLoaded = false;
            }
                        CacheSettings.getConcreteStoreNameSettingForCacheType(CacheType.INDICES_REQUEST_CACHE).getKey(),  
                // Should miss as the policy rejected it  
            } else {
            removalListener,
        Iterable<ICacheKey<String>> mergedIterable = tieredSpilloverCache.keys();  
        int diskSizeFromImplSetting = 50;
                    new TimeValue(cacheThresholdNanos / 1_000_000)
            }
        int numberOfSegments,
    private TieredSpilloverCache<String, String> initializeTieredSpilloverCache(
        long diskDeliberateDelay,  
                return null;
                return mapValue;  
            keyValueSize,  
            removalListener,  
            0,  
        int expectedKeys = 0;  
        // We should have (numRepetitionsPerKey - 1) * (expectedKeys) hits
        assertNotEquals(0, heapStats.getEvictions());
        for (ICacheKey<String> onDiskKey : actualOnDiskKeys) {
            boolean isLoaded = false;
        Class<? extends Exception> expectedException,
            Settings.builder()
        tieredSpilloverCache.getDiskCacheKeys().forEach(diskTierKeys::add);
                segmentSizeTracker.put(keySegment, Integer.valueOf(1));  
        // skewness as well.
            String key = UUID.randomUUID().toString();
            .setStoragePath(storagePath)  
            ICacheKey<String> key = getICacheKey(UUID.randomUUID().toString());
        int onHeapCacheSizeInBytes = onHeapCacheSize * keyValueSize;
        Tuple<List<Predicate<String>>, Map<String, Tuple<String, Boolean>>> setupTuple = setupPoliciesTest();
            )  
    public void testSegmentSizesWhenUsingFactory() {
        );  
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();  
        };  
            .put(TIERED_SPILLOVER_SEGMENTS.getConcreteSettingForNamespace(CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()).getKey(), 1)
        assertEquals(expectedKeys, getTotalStatsSnapshot(tieredSpilloverCache).getItems());  
            }
            }
                    phaser.arriveAndAwaitAdvance();  
        // We will call computeIfAbsent again with the same key, but this time the underlying loader should run fine and we should get back
            }  
                ).getKey(),
        assertEquals(0, diskStats.getSizeInBytes());
        }
            onHeapCacheFactory,
            Settings.builder()  
        assertEquals("key1", tieredSpilloverCache.get(key1));
        String expectedRespone = "Cool response!";
        TieredSpilloverCache<String, String> tieredSpilloverCache = (TieredSpilloverCache<String, String>) tieredSpilloverICache;
                .put(  
            diskCacheSize,  
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_NAME.getConcreteSettingForNamespace(  
                .build(),  
                onHeapCacheSize * keyValueSize + "b"  
        assertEquals(evictionsBeforeDisablingDiskCache + newMisses, totalStats.getEvictions());  
        Settings settings = Settings.builder()  
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_NAME.getConcreteSettingForNamespace(
                assertFalse(loadAwareCacheLoader.isLoaded());  
            .setStoragePath(storagePath)  
            assertTrue(newKeyList.contains(actualOnHeapCacheKeys.get(i)));
            "D",
            public boolean isLoaded() {
            )
        for (int iter = 0; iter < numOfItems1; iter++) {
            tieredSpilloverCache.computeIfAbsent(getICacheKey(UUID.randomUUID().toString()), getLoadAwareCacheLoader());
        int numberOfSegments = getNumberOfSegments();
                numberOfSegments
        assertEquals(keyValuePairs.size(), getEvictionsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
                    .build(),
        Setting<TimeValue> concreteSetting = TieredSpilloverCacheSettings.TOOK_TIME_POLICY_CONCRETE_SETTINGS_MAP.get(  
            .put(
                expectedEvictions += segmentSizeTracker.get(i) - perSegmentEntryCapacity.get(i);  
                    .setSettings(settings)
        Thread[] threads = new Thread[numberOfSameKeys];  
            .put(
        );
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
        assertEquals(0, getEvictionsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
        countDownLatch.await();
                numSegments  
        List<ICacheKey<String>> onHeapKeys = new ArrayList<>();
    private long getHitsForTier(TieredSpilloverCache<?, ?> tsc, String tierValue) throws IOException {
        );
        assertEquals(1, getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
                .setKeyType(String.class)  
        return getStatsSnapshotForTier(tsc, tierValue).getItems();  
        int keyValueSize = 20;
    class MockCacheRemovalListener<K, V> implements RemovalListener<ICacheKey<K>, V> {
            tieredSpilloverCache.computeIfAbsent(getICacheKey(key), loader);
            if (segmentSizeTracker.get(keySegment) == null) {
            "default segments " + segments + " must not exceed ceiling " + TieredSpilloverCacheSettings.DEFAULT_SEGMENT_COUNT_CEILING,  
        for (int iter = 0; iter < numMisses; iter++) {
        for (int iter = 0; iter < numOfItems1; iter++) {
                MockDiskCache.MockDiskCacheFactory.NAME,
            Settings.builder()  
        assertThrows(  
            .put(
        }
    public void testWithFactoryCreationWithOnHeapCacheNotPresent() {
                    )
            onHeapCacheFactory,
        }
            }  
        // cache to cause spillover.
        Settings settings = Settings.builder()  
        ImmutableCacheStats diskStats = tieredSpilloverCache.tieredSpilloverCacheSegments[0].getDiskCache().stats().getTotalStats();
        for (ICacheKey<String> diskKey : diskCacheKeys) {  
                    countDownLatch.countDown();  
        );  
        int onHeapCacheSize = randomIntBetween(10, 30);
        return expectedSegmentOnHeapCacheSize;  
                TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME  
        // Verify disk cache stats.
                    .setClusterSettings(clusterSettings)
        int diskCacheSize = randomIntBetween(200, 400);  
        heapStats = getStatsSnapshotForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP);  
        assertEquals(0, getHitsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
        // (this works as we have 1 segment). Set heap threshold to 0 to ensure random keys can all enter  
        clusterSettings.registerSetting(DISK_CACHE_ENABLED_SETTING_MAP.get(CacheType.INDICES_REQUEST_CACHE));
        thread1.start();  
        tookTimeMap.put("f", cacheThresholdNanos * 2);
            if (loader.isLoaded()) {  
                    LoadAwareCacheLoader<ICacheKey<String>, String> loadAwareCacheLoader = new LoadAwareCacheLoader<>() {  
            // The size setting from the OpenSearchOnHeapCache implementation should not be honored
        }  
            () -> initializeTieredSpilloverCache(
                keyValueSize,
        );
                    OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME,  
        tieredSpilloverCache.tieredSpilloverCacheSegments[0].getOnHeapCache().keys().forEach(onHeapCacheKeys::add);
                        OpenSearchOnHeapCacheSettings.getSettingListForCacheType(CacheType.INDICES_REQUEST_CACHE)
            numberOfSegments,
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
        countDownLatch.await(); // Wait for rest of tasks to be cancelled.  
        return getTieredSpilloverCache(  
        assertEquals(1, getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
            }
        // Fill the cache, getting some entries + evictions for both tiers  
        // Verify on heap cache stats.
            );
import org.opensearch.env.NodeEnvironment;  
        assertEquals(0, tieredSpilloverCache.completableFutureMap.size());
                });
                    onHeapCacheSize * keyValueSize + "b"
        assertEquals(1, getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));  
            ICacheKey<String> key = getICacheKey(UUID.randomUUID().toString());
            .put(
                ).getKey(),
            diskCacheSize,  
        assertEquals(numOfItems1, getMissesForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
                new CacheConfig.Builder<String, String>().setKeyType(String.class)
        Settings belowThresholdSettings = Settings.builder().put(concreteSetting.getKey(), TimeValue.MINUS_ONE).build();  
            if (randomBoolean()) {
        );
        tieredSpilloverCache.getDiskCacheKeys().forEach(diskCacheKeys::add);
    }  
                ).getKey(),  
        assertEquals(expectedKeys, getTotalStatsSnapshot(tieredSpilloverCache).getItems());  
        for (int i = 0; i < actualOnHeapCacheKeys.size(); i++) {
            }
        // These should be added to the totals, as the disk tier is now absent
                .setClusterSettings(clusterSettings)  
                    new MockDiskCache.MockDiskCacheFactory(0, randomIntBetween(100, 300), false, keyValueSize)
            .put(
        int numOfItems1 = randomIntBetween(onHeapCacheSize + 1, totalSize - 1); // Create more items than onHeap  
        // First try to invalidate without the key present in cache.  
            "G",
                    @Override
            Boolean expectedOutput = keyValuePairs.get(key).v2();
                                                                                                                                    // remain
        // the response.  
        phaser.arriveAndAwaitAdvance();
        int numOfItems1 = randomIntBetween(onHeapCacheSize + 1, totalSize); // Create more items than onHeap cache.
                    MockDiskCache.MockDiskCacheFactory.NAME,
        int diskCacheSize = randomIntBetween(200, 400);
        String storagePath = getStoragePath(settings);
        assertEquals(1, getMissesForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));  
        String expectedExceptionMessage  
        assertEquals(0, removalListener.evictionsMetric.count());
        Map<Integer, Integer> segmentSizeTracker = new HashMap<>();
                        }  
        assertEquals(numberOfSameKeys - 1, getHitsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
            @Override
        });
import org.opensearch.common.cache.policy.CachedQueryResult;  
        ICacheKey<String> key = getICacheKey(UUID.randomUUID().toString());
        int onHeapCacheSize = randomIntBetween(10, 30);
            tieredSpilloverCache.computeIfAbsent(key, tieredCacheLoader);  
                    .setDimensionNames(dimensionNames)
            diskCacheSize,
        int diskCacheSize = 10;
            cacheConfig,  
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(
            int perSegmentDiskCacheEntries = diskCacheSize / numberOfSegments;  
                )  
            .setKeyType(String.class)  
        clusterSettings.applySettings(
            () -> new TieredSpilloverCache.TieredSpilloverCacheFactory().create(
            .setOnHeapCacheSizeInBytes(200)
        clusterSettings.applySettings(
            keyValueSize,
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
                ).getKey(),  
                // Should miss as the policy rejected it  
            .build();
        assertEquals(0, removalListener.evictionsMetric.count());
            public boolean isLoaded() {
        TieredSpilloverCache<String, String> tieredSpilloverCache = getTieredSpilloverCache(  
            }
        assertEquals(onHeapCacheSize, getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
        String value = UUID.randomUUID().toString();
            keyValueSize,
        assertEquals(numOfItems1, getMissesForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
        int keyValueSize = 1;
    }
            )  
        int numberOfKeys = 20;
    private long getSizeInBytesForTier(TieredSpilloverCache<?, ?> tsc, String tierValue) throws IOException {
        int keyValueSize = 50;  
                .build(),  
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()  
            public boolean isLoaded() {  
        for (int i = 0; i < numberOfSegments; i++) {  
import java.util.concurrent.atomic.AtomicInteger;  
        }
            false,
        TieredSpilloverCache.TieredSpilloverCacheSegment<String, String> segment = cache.tieredSpilloverCacheSegments[0];  
            loaderMap.put(key, new Tuple<>(keyValueMap.get(key), false));
                    MockDiskCache.MockDiskCacheFactory.NAME,
            Map.of(
        } catch (IOException e) {  
                )
            )  
        Map<String, Boolean> expectedInHeapTierMap = Map.of(  
                CacheType.INDICES_REQUEST_CACHE,  
                .put(  
                .put(  
    }
            .put(
    }
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(
        tieredSpilloverCache.getOnHeapCacheKeys().forEach(onHeapKeys::add);
        int totalSize = onHeapCacheSize + diskCacheSize;
            Settings.builder()
    public void testDiskTierPolicies() throws Exception {
        );  
        assertEquals(totalStats.getEvictions(), diskStats.getEvictions());
        List<ICacheKey<String>> diskCacheKeys = new ArrayList<>();  
        assertEquals(  
        assertEquals(totalOnDiskEntries * keyValueSize, getSizeInBytesForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
                TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME
        int diskCacheSize = randomIntBetween(700, 1200);  
                expectedKeys++;
        List<ICacheKey<String>> keys = new ArrayList<>();
        verifyComputeIfAbsentThrowsException(NullPointerException.class, loadAwareCacheLoader, "Loader returned a null value");
        int numberOfSegments = getNumberOfSegments();  
        for (int i = 0; i < loadAwareCacheLoaderList.size(); i++) {
            .put(TOOK_TIME_DISK_TIER_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE).getKey(), TimeValue.ZERO)
        int keyValueSize = 1;
        CountDownLatch countDownLatch = new CountDownLatch(numberOfSameKeys); // To wait for all threads to finish.
        // Clear up disk cache keys.
                    MockDiskCache.MockDiskCacheFactory.NAME,
            }  
    ) {
            removalListener,
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
            tieredSpilloverCache.computeIfAbsent(key, tieredCacheLoader);
        List<ICacheKey<String>> diskTierKeys = new ArrayList<>();
                CacheSettings.getConcreteStoreNameSettingForCacheType(CacheType.INDICES_REQUEST_CACHE).getKey(),
        int cacheMiss = 0;  
        assertEquals(0, tieredSpilloverCache.count());  
            )  
        int diskCacheSize = randomIntBetween(700, 1200);  
        List<Predicate<String>> diskPolicies,
        mergedIterable.iterator().forEachRemaining(actualMergedKeys::add);
            .put(  
                    assertEquals(value, tieredSpilloverCache.computeIfAbsent(key, loadAwareCacheLoader));
                expectedEvictions++;
            // dimensions yet  
            numberOfSegments  
                totalOnHeapEntries += expectedSegmentOnHeapCacheSize.get(i);
            )  
        assertEquals(numOfItems1, getMissesForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));  
    private static class AllowFirstLetterA implements Predicate<String> {
            String,
                assertNotNull(computedValue);
        assertEquals(onHeapCacheSize, tieredSpilloverCache.tieredSpilloverCacheSegments[0].getOnHeapCache().count());  
        tookTimeMap.put("c", diskThresholdNanos * 3);
        List<ICacheKey<String>> actualOnDiskKeys = new ArrayList<>();  
                .build(),
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
    public void testComputeIfAbsentConcurrentlyAndThrowsException() throws Exception {  
        assertEquals(getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP), tieredSpilloverCache.onHeapCacheCount()); // Should
        assertEquals(expectedHeapSize / cache.getNumberOfSegments(), segment.getOnHeapCacheMaxWeight());
            .put(TIERED_SPILLOVER_SEGMENTS.getConcreteSettingForNamespace(CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()).getKey(), 2)
        assertThrows(  
                diskCacheHit++;
            @Override
                    TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME
        assertEquals(1, getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
            } catch (Exception e) {
        int diskCacheSize = randomIntBetween(onHeapCacheSize + 1, 100);  
            onHeapCacheSize * keyValueSize,
import java.util.UUID;
                    TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
        Map<String, Tuple<String, Boolean>> loaderMap = new HashMap<>();
            .setSettings(settings)  
        assertEquals(numOfItems1, getMissesForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
        );  
import java.util.concurrent.CopyOnWriteArrayList;
                    .setKeySerializer(new StringSerializer())
import java.util.HashMap;
        keyValuePairs.put("key2", new Tuple<>("abcde", false));  
            .put(
        ICache.Factory mockDiskCacheFactory,  
        assertEquals(numberOfSameKeys, loadAwareCacheLoaderList.size());  
        String storagePath = getStoragePath(settings);  
    }
        long cacheThresholdNanos = 2_000_000L;
            int perSegmentOnHeapCacheEntries = perSegmentOnHeapCacheSizeBytes / keyValueSize;  
        assertEquals(onHeapCacheSize, getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
            .setDiskCacheFactory(mockDiskCacheFactory)
                .setKeySerializer(new StringSerializer())  
        int numberOfTimesKeyLoaded = 0;
            onHeapCacheSize * keyValueSize,  
                    .setRemovalListener(removalListener)  
            true,  
            new CacheConfig.Builder<String, String>().setKeyType(String.class)
                        CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()  
                Map.of(
            diskCacheSize,
                        CacheSettings.getConcreteStoreNameSettingForCacheType(CacheType.INDICES_REQUEST_CACHE).getKey(),
                tieredSpilloverCache.computeIfAbsent(onHeapKeys.get(index), loadAwareCacheLoader);
                    TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
        int numOfItems1 = randomIntBetween(onHeapCacheSize + 1, totalSize);  
    private LoadAwareCacheLoader<ICacheKey<String>, String> getLoadAwareCacheLoader() {
            mockDiskCacheFactory,
            keyValueSize,
        Map<Integer, Integer> mockDiskCacheExpectedSize = getSegmentMockDiskCacheSize(numberOfSegments, diskCacheSize);  
        @Override
                    .build()
        long onHeapCacheSizeInBytes = TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(  
                    keyValueSize - 1 + "b"  
        ImmutableCacheStats totalStats = tieredSpilloverCache.stats().getTotalStats();  
                } catch (Exception e) {
                        CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
import static org.opensearch.cache.common.tier.TieredSpilloverCacheSettings.TIERED_SPILLOVER_SEGMENTS;
                    TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(  
        int totalSize = onHeapCacheSize + diskCacheSize;  
            Settings.builder().put(DISK_CACHE_ENABLED_SETTING_MAP.get(CacheType.INDICES_REQUEST_CACHE).getKey(), false).build()
            new CacheConfig.Builder<String, String>().setKeyType(String.class)
        keyValuePairs.put("key5", new Tuple<>("", false));  
        int diskCacheSize = randomIntBetween(onHeapCacheSize + 1, 500);
                )
        Map<Integer, Integer> onHeapCacheExpectedSize = getSegmentOnHeapCacheSize(
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_NAME.getConcreteSettingForNamespace(
        for (int iter = 0; iter < numOfItems2; iter++) {  
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
                    ).getKey(),
        int onHeapCacheSize = randomIntBetween(300, 400);  
        assertEquals(0, getEvictionsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
        assertEquals(1, numberOfTimesKeyLoaded); // It should be loaded only once.
        assertEquals(0, getEvictionsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
        tieredSpilloverCache.put(key, value);
                return (data.charAt(0) == 'a');  
                    ).getKey(),
            public boolean isLoaded() {
        // Verify on heap cache stats.
        };
            .put(  
            diskPolicies,
                    ).getKey(),
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_DISK_STORE_NAME.getConcreteSettingForNamespace(  
    public void testComputeIfAbsentWithSegmentedCache() throws Exception {
            .setCacheType(CacheType.INDICES_REQUEST_CACHE)
import static org.opensearch.cache.common.tier.TieredSpilloverCacheStatsHolder.TIER_DIMENSION_VALUE_DISK;
        assertTrue(removalListener.evictionsMetric.count() > 0);
        int onHeapCacheSize = randomIntBetween(200, 400);
            .setDimensionNames(dimensionNames)
            200  
                CacheType.INDICES_REQUEST_CACHE,
                segmentSizeTracker.put(keySegment, Integer.valueOf(1));  
            expectedSegmentOnHeapCacheSize.put(i, perSegmentOnHeapCacheEntries);
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()  
        }
        };
            ex.getMessage(),
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
        ICache.Factory mockDiskCacheFactory = new MockDiskCache.MockDiskCacheFactory(0, diskCacheSize, false, keyValueSize);
            "E",
            keyValueSize,
        }
        }  
        return dims;
            .setSettings(settings)
            diskCacheSize  
        ExecutorService executorService = Executors.newFixedThreadPool(8);
            removalListener,
                continue;
 * SPDX-License-Identifier: Apache-2.0
        TieredSpilloverCache.TieredSpilloverCacheSegment<String, String>[] tieredSpilloverCacheSegments =
                tieredSpilloverCache,
                .setCachedResultParser(s -> new CachedQueryResult.PolicyValues(DEFAULT_TOOK_TIME_DISK_THRESHOLD.getNanos() * 2))
                .setKeySerializer(new StringSerializer())
                .setClusterSettings(clusterSettings)  
            Map.of(
            } else {
        Settings settings,
                try {
                    .setKeyType(String.class)
        /* We expect the total stats to be:  
                    TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
            .put(TOOK_TIME_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE).getKey(), TimeValue.ZERO)
                .setMaxSizeInBytes(onHeapCacheSize * keyValueSize)
        ICache.Factory onHeapCacheFactory = new OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory();  
        TieredSpilloverCache<String, String> tieredSpilloverCache = (TieredSpilloverCache<  
                OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME
        assertEquals(1, tieredSpilloverCache.count());
        LoadAwareCacheLoader<ICacheKey<String>, String> loadAwareCacheLoader = new LoadAwareCacheLoader<>() {  
        for (String key : keyValuePairs.keySet()) {
        assertEquals(0, getHitsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
        int approxNumHits = 30;
    }
        int expectedEvictions = 0;
        List<Predicate<String>> policies = setupTuple.v1();
            diskCacheSize,  
        // Now try to invalidate with the key present in onHeap cache.
            @Override
        for (int i = 0; i < onHeapCacheSize; i++) {  
        );
            )
                expectedEvictions += segmentSizeTracker.get(i) - perSegmentEntryCapacity.get(i);
        assertTrue(diskKeys.contains(key1));  
    private ImmutableCacheStats getStatsSnapshotForTier(TieredSpilloverCache<?, ?> tsc, String tierValue) throws IOException {  
                            public boolean isLoaded() {
                .setValueSerializer(new StringSerializer())
        assertEquals(numberOfKeys, getMissesForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));  
import org.opensearch.common.metrics.CounterMetric;  
            tieredSpilloverCache.computeIfAbsent(key, loadAwareCacheLoader);  
        int keyValueSize = 12;
                    public CachedQueryResult.PolicyValues apply(String s) {  
                        tieredSpilloverCache.computeIfAbsent(iCacheKeyList.get(finalJ), loadAwareCacheLoader);
                    .setSettings(settings)
        assertEquals(1, getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));  
        int keyValueSize,
            diskDeliberateDelay,  
                .put(
        int heapSizeFromImplSetting = 50;  
            .build();
            diskDeliberateDelay,
                        ).getKey(),
                .put(
                    ).getKey(),
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();  
        tookTimeMap.put("e", -1L);  
        int numberOfSegments = getNumberOfSegments();
            getEvictionsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP)  
        assertThrows(
                CacheSettings.getConcreteStoreNameSettingForCacheType(CacheType.INDICES_REQUEST_CACHE).getKey(),
                    .setKeyType(String.class)  
        tieredSpilloverCache.tieredSpilloverCacheSegments[0].getDiskCache().keys().forEach(diskTierKeys::add);
        tieredSpilloverCache.invalidateAll(); // Clear up all the keys.  
            cacheConfig,  
                heapSizeFromImplSetting + "b"
        assertTrue(
            threads[i].start();
        int totalSize = onHeapCacheSize + diskCacheSize;  
                    new OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory(),  
        }
            LoadAwareCacheLoader<ICacheKey<String>, String> tieredCacheLoader = getLoadAwareCacheLoader();
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
            // these keys.
        );
                throw new TaskCancelledException("Query cancelled!");
            keyValueSize,
        assertEquals(iterations * numberOfKeys, loadAwareCacheLoaderList.size());  
        for (int j = 0; j < numberOfKeys; j++) {
        return snapshot;
        long expectedHeapSize = 256L * between(10, 20);
        int diskCacheSize = randomIntBetween(700, 1200);
    }  
            storagePath = environment.nodePaths()[0].path + "/test";
        List<ICacheKey<String>> actualMergedKeys = new ArrayList<>();
        List<LoadAwareCacheLoader<ICacheKey<String>, String>> loadAwareCacheLoaderList = new CopyOnWriteArrayList<>();
                    .put(
    }
    }  
            onHeapCacheFactory,
        int keyValueSize = 1;
                Settings.builder()
        int keyValueSize = 50;  
    public void testConcurrencyForEvictionFlowFromOnHeapToDiskTier() throws Exception {
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()  
        int numberOfSegments = getNumberOfSegments();
            keyValueSize
                } else {
        }
                TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME  
                        LoadAwareCacheLoader<ICacheKey<String>, String> loadAwareCacheLoader = new LoadAwareCacheLoader<>() {
        assertNotNull(tieredSpilloverCache.getTieredCacheSegment(keyToBeEvicted).getDiskCache().get(keyToBeEvicted));
        // Now the original keys should be in the disk tier if the policy allows them, or misses if not
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
            "B",  
        assertEquals(expectedEvictions, getEvictionsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));  
            public String load(ICacheKey<String> key) {  
                }
            )  
            if (expectedOutput) {
                tieredSpilloverCache.computeIfAbsent(diskTierKeys.get(index), loadAwareCacheLoader);
                Map.of(
            )
    public void testComputeIfAbsentWithoutAnyOnHeapCacheEviction() throws Exception {
    private ICacheKey<String> getICacheKey(String key) {
    static class StringSerializer implements Serializer<String, byte[]> {  
        assertEquals(expectedDiskEntries * keyValueSize, getSizeInBytesForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
        assertEquals(numOfItems1 + cacheMiss, getMissesForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
            .put(
        );
        for (int iter = 0; iter < numMisses; iter++) {  
                TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME  
        for (String key : keyValueMap.keySet()) {
                TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME
        }
            Settings.EMPTY,
            )
        for (int i = 0; i < onHeapCacheSize; i++) {
        int keyValueSize = 50;
        for (String key : keyValueMap.keySet()) {  
            ICacheKey<String> key = usedKeys.get(rand.nextInt(usedKeys.size()));
            if (randomBoolean()) {
        Settings settings = Settings.builder()  
                ).getKey(),  
        Random rand = Randomness.get();  
        return getStatsSnapshotForTier(tsc, tierValue).getSizeInBytes();
            tieredSpilloverCache.computeIfAbsent(key, loadAwareCacheLoader);
                    OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME,
        int numMisses = onHeapCacheSize + randomIntBetween(10, 20);
            }
                        ICacheKey<String> iCacheKey = getICacheKey(key);
        ICache.Factory onHeapCacheFactory = new OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory();
            .put(
                // Make disk cache big enough to hold all entries  
            ICacheKey<String> iCacheKey = getICacheKey(key);  
        try {
        );
            0,
                )  
        int keyValueSize,
        TieredSpilloverCache<String, String> tieredSpilloverCache = (TieredSpilloverCache<
        ICacheKey<String> key = getICacheKey(UUID.randomUUID().toString());  
        int onHeapCacheSize = randomIntBetween(300, 600);
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(  
            String>) new TieredSpilloverCache.TieredSpilloverCacheFactory().create(
                .put(
                onHeapCacheSize * keyValueSize + "b"
                ).getKey(),
            keyValueSize,
                200 + "b"  
        long actualDiskCacheSize = tieredSpilloverCache.diskCacheCount();
                        TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME
        }  
import java.util.Random;  
    private ClusterSettings clusterSettings;  
    }  
import java.util.function.Function;
            new HashMap<>();
            )  
            )
                    .setClusterSettings(clusterSettings)  
        int keyValueSize = 50;
        );
        public String deserialize(byte[] bytes) {  
                OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME,
        int onHeapCacheSize = 10;
    private LoadAwareCacheLoader<ICacheKey<String>, String> getLoadAwareCacheLoader(Map<String, Tuple<String, Boolean>> keyValueMap) {
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()  
                    MockDiskCache.MockDiskCacheFactory.NAME,  
            .put(  
        int keyValueSize = 50;  
                return isLoaded;
                        CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
        return initializeTieredSpilloverCache(
            )
                isLoaded = true;
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
    }  
            for (int i = 0; i < iterations; i++) {
        public boolean test(String data) {  
            for (int j = 0; j < numRepetitionsPerKey; j++) {
        assertTrue(diskKeys.contains(key1));  
    @SuppressWarnings({ "rawtypes", "unchecked" })  
        assertEquals(0, getHitsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));  
        int onHeapCacheSize = 1;
        // Put values in cache more than it's size and cause evictions from onHeap.  
        }  
                    phaser.arriveAndAwaitAdvance();
        );
            IllegalArgumentException.class,
            removalListener,
    }
                )  
        Map<Integer, Integer> perSegmentEntryCapacity = new HashMap<>();
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(  
        int onHeapCacheSize = randomIntBetween(100, 300);
            LoadAwareCacheLoader<ICacheKey<String>, String> tieredCacheLoader = getLoadAwareCacheLoader();
            for (Predicate<String> diskPolicy : diskPolicies) {
                ).getKey(),
        int numRepetitionsPerKey = 10;
        // evicted to onDisk cache.
                }
        ICache.Factory onHeapCacheFactory = mock(OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.class);
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(  
                LoadAwareCacheLoader<ICacheKey<String>, String> loadAwareCacheLoader = getLoadAwareCacheLoader();
                .setRemovalListener(removalListener)
        }
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
            @Override  
                CacheSettings.getConcreteStoreNameSettingForCacheType(CacheType.INDICES_REQUEST_CACHE).getKey(),  
            )
 * The OpenSearch Contributors require contributions made to  
                    ).getKey(),
            if (segmentSizeTracker.get(i) > perSegmentEntryCapacity.get(i)) {
                    TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
        CacheConfig<String, String> cacheConfig = getCacheConfig(keyValueSize, settings, removalListener, 1);  
            keyValueSize,  
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
            .setSettings(settings)  
        RemovalListener<ICacheKey<String>, String> removalListener,
        int totalSize = onHeapCacheSize + diskCacheSize;
        // disk cache.
        assertEquals(getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK), actualDiskCacheCount);
    }
            assertNotNull(tieredSpilloverCache.get(diskKey));  
                assertEquals(keyValuePairs.get(key).v1(), result);  
        assertThrows(IllegalArgumentException.class, () -> concreteSetting.get(belowThresholdSettings));
        ImmutableCacheStats diskStats = getStatsSnapshotForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK);  
            tieredSpilloverCache.tieredSpilloverCacheSegments;  
                    MockDiskCache.MockDiskCacheFactory.NAME,
        return builder.build();
        Iterable<ICacheKey<String>> onDiskiterable = tieredSpilloverCache.getDiskCacheKeys();
            int keySegment = tieredSpilloverCache.getSegmentNumber(iCacheKey);
                totalOnHeapEntries += expectedNumberOfEntriesInSegment.get(i);
            () -> new TieredSpilloverCache.TieredSpilloverCacheFactory().create(
                    .setDimensionNames(dimensionNames)  
        totalStats = tieredSpilloverCache.stats().getTotalStats();
                .setClusterSettings(clusterSettings)
            public boolean isLoaded() {
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
        doThrow(new RuntimeException("Test")).when(mockDiskCache).put(any(), any());
            }
            tieredSpilloverCache.computeIfAbsent(key, tieredCacheLoader);  
        Settings settings = Settings.builder()
            )
                .setDimensionNames(dimensionNames)  
            ICacheKey<String> iCacheKey = getICacheKey(UUID.randomUUID().toString());
                        CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
            policies,
            }
                    .setValueSerializer(new StringSerializer())
                return false;
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(
            if (expectedInHeapTierMap.get(key)) {  
        assertEquals(expectedRespone, value);
        levelsList.add(TIER_DIMENSION_NAME);
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
            diskCacheSize,  
        );
        for (int iter = 0; iter < numMisses; iter++) {  
        Settings settings = Settings.builder()
                expectedDiskSize
        tieredSpilloverCache.tieredSpilloverCacheSegments[0].getOnHeapCache().keys().forEach(onHeapCacheKeys::add);
                256  
                    keyValueSize * keyValuePairs.size() + 1 + "b"
                    assertNotNull(tieredSpilloverCache.get(diskTierKeys.get(index)));
        Settings settings = Settings.builder()  
                onHeapCacheSizeInBytes + "b"
                    ).getKey(),  
            .setWeigher((k, v) -> keyValueSize)
        int numberOfSegments
            .setRemovalListener(removalListener)  
            .setCacheConfig(cacheConfig)
            @Override  
            ICacheKey<String> key = getICacheKey(UUID.randomUUID().toString());
import org.opensearch.common.cache.ICacheKey;
                    TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
                int index = randomIntBetween(0, onHeapKeys.size() - 1);  
        int diskCacheSize = randomIntBetween(450, 800);
import java.util.concurrent.TimeUnit;
            diskCacheSize,
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
                    ).getKey(),  
    }  
            keyValueSize,
        assertEquals(totalOnDiskEntries, getEvictionsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
            50,
        int diskCacheSize = randomIntBetween(onHeapCacheSize + 1, onHeapCacheSize * 2);
        assertTrue(totalStats.getHits() > 0);
import static org.mockito.ArgumentMatchers.any;
                .setCachedResultParser(new Function<String, CachedQueryResult.PolicyValues>() {
                .put(  
            if (tieredSpilloverCache.tieredSpilloverCacheSegments[keySegment].getOnHeapCache().count() >= onHeapExpectedSize.get(  
        assertEquals(expectedDiskEntries, tieredSpilloverCache.tieredSpilloverCacheSegments[0].getDiskCache().count());
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()  
                    MockDiskCache.MockDiskCacheFactory.NAME,
                    .put(settings)
                        };
            "F",
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(  
        tieredSpilloverCache.tieredSpilloverCacheSegments[0].getDiskCache().keys().forEach(diskKeys::add);
        int onHeapCacheSize = randomIntBetween(300, 600);
            public boolean isLoaded() {
                    .setWeigher((k, v) -> keyValueSize)
            0,
            )
        policies.add(new AllowFirstLetterA());  
            )  
            keyValueSize
        }
        int onHeapCacheSize = 1;  
                )
            false,
                    .setKeySerializer(new StringSerializer())  
            String result = tieredSpilloverCache.get(iCacheKey);  
import org.opensearch.common.cache.store.config.CacheConfig;  
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
        assertEquals(numOfItems1 + cacheMiss + diskCacheHit, getMissesForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
            .build();
        // The policy inspects values, not keys, so this is a map from values -> took time  
                assertNull(computedValue);
        Map<String, Tuple<String, Boolean>> keyValuePairs = setupTuple.v2();  
                    .build(),
        diskKeys.clear();
        }  
            true,  
        int expectedKeys = 0;  
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
        long diskCacheSize
                new CacheConfig.Builder<String, String>().setKeyType(String.class)
import org.opensearch.common.collect.Tuple;
        assertEquals(onHeapCacheSize, getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_DISK_STORE_NAME.getConcreteSettingForNamespace(
            .put(
        int onHeapCacheSize = randomIntBetween(300, 600);
        assertEquals(expectedKeys, tieredSpilloverCache.count());  
            Settings.builder()  
            boolean isLoaded = false;  
    public void testComputeIfAbsentWithDiskCacheThrowingExceptionOnPut() throws Exception {
        for (int i = 0; i < approxNumHits; i++) {  
                .setWeigher((k, v) -> keyValueSize)
            0,  
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();  
                    // Values will always appear to have taken 2x the took time threshold to compute, so they will be admitted
        int onHeapCacheSize = 10;
        assertEquals("dummy", tieredSpilloverCache.get(key1));
                heapSizeFromImplSetting + "b"
            CacheType.INDICES_REQUEST_CACHE,  
        assertEquals(0, getEvictionsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK)); // Disk tier is large enough for no evictions  
                new OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory(),  
        List<ICacheKey<String>> usedKeys = new ArrayList<>();
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
        assertEquals(0, tieredSpilloverCache.completableFutureMap.size());
                        throw new RuntimeException(e);  
            )  
    public void testComputeIfAbsentConcurrently() throws Exception {
        for (int iter = 0; iter < numOfItems2; iter++) {
            expectedSegmentDiskCacheSize.put(i, perSegmentDiskCacheEntries);
            } else {
            .setRemovalListener(removalListener)
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
        int diskCacheSize = randomIntBetween(700, 1200);  
        for (int i = 0; i < onHeapCacheSize; i++) {  
        // should return not null value as it should be present on diskCache.
import java.util.concurrent.Executors;  
                    .setKeySerializer(new StringSerializer())
                        phaser.arriveAndAwaitAdvance();
            numberOfSegments,
            .setOnHeapCacheSizeInBytes(onHeapCacheSizeInBytes)
        );
        long actualDiskCacheCount = tieredSpilloverCache.diskCacheCount();
                .setCachedResultParser(s -> new CachedQueryResult.PolicyValues(DEFAULT_TOOK_TIME_DISK_THRESHOLD.getNanos() * 2))
                cacheHit++;
        int numOfItems1 = randomIntBetween(onHeapCacheSize + 1, totalSize);  
            LoadAwareCacheLoader<ICacheKey<String>, String> tieredCacheLoader = getLoadAwareCacheLoader();  
    private ImmutableCacheStats getTotalStatsSnapshot(TieredSpilloverCache<?, ?> tsc) throws IOException {  
        String value = UUID.randomUUID().toString();
        int diskCacheSize,  
                removalListener,
                .setValueSerializer(new StringSerializer())  
        ArrayList<Predicate<String>> policies = new ArrayList<>();
            removalListener,  
            diskCacheSize,  
                newMisses++;  
        }  
        // Since we always use the same list of dimensions from getMockDimensions() in keys for these tests, we can get all the stats values
            1,
            expectedHeapSize,
            "G",
        int totalOnHeapEntries = 0;
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
                            @Override  
                                return isLoaded;  
            "F",  
            1  
            threads[i] = new Thread(() -> {
            0,
                executorService.submit(() -> {
 * this file be licensed under the Apache-2.0 license or a
            1
        // Set the desired settings needed to create a TieredSpilloverCache object with INDICES_REQUEST_CACHE cacheType.
        );
        }  
        Map<String, Tuple<String, Boolean>> keyValuePairs = new HashMap<>();
                countDownLatch.countDown();
        int keyValueSize,  
                    ).getKey(),  
                ).getKey(),  
        ICache.Factory mockDiskCacheFactory = new MockDiskCache.MockDiskCacheFactory(
        assertThrows(
        assertEquals(1, getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));  
        );
        assertEquals(1, removalListener.evictionsMetric.count());  
            )
                    .setRemovalListener(removalListener)
        int numOfItems2 = randomIntBetween(50, 200);
                // All these are bound to go to disk based cache.  
        for (int iter = 0; iter < numRandom; iter++) {
            )  
                TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME  
    }  
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_DISK_STORE_NAME.getConcreteSettingForNamespace(
            .put(
                .put(  
import java.nio.charset.StandardCharsets;  
            Settings.builder()
            )
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();  
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
            .setCacheConfig(cacheConfig);  
        assertTrue(cacheThresholdNanos * 2 < diskThresholdNanos);  
            CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
                    .put(settings)  
        // Also do some random hits  
            .put(
    private CacheConfig<String, String> getCacheConfig(
            keys.add(key);  
                )  
            )
        when(onHeapCacheFactory.create(any(), any(), any())).thenReturn(mockOnHeapCache);
        // Ensure all these keys get evicted from the on heap tier by adding > heap tier size worth of random keys
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();  
        ICacheKey<String> key2 = getICacheKey(UUID.randomUUID().toString());
    public void testSegmentSizesWhenNotUsingFactory() {  
            .setDiskCacheFactory(diskCacheFactory)
        assertEquals(missesBeforeDisablingDiskCache + numOfItems, totalStats.getMisses());
        );
        Settings settings = Settings.builder()
        Map<Integer, Integer> expectedSegmentOnHeapCacheSize = new HashMap<>();  
            )
            1,
            .put(
            try {
            null,
        assertEquals(0, getHitsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
        )
    public void testTieredCacheWithZeroNumberOfSegments() {
import org.opensearch.common.cache.settings.CacheSettings;
                new CacheConfig.Builder<String, String>().setKeyType(String.class)  
            1
            for (Predicate<String> policy : policies) {
        int numOfItems = randomIntBetween(totalSize + 1, totalSize * 3);  
        };
        );  
                    onHeapCacheSize * keyValueSize + "b"
            tieredSpilloverCache.computeIfAbsent(key, loadAwareCacheLoader);
        ICache<String, String> tieredSpilloverICache = new TieredSpilloverCache.TieredSpilloverCacheFactory().create(  
                expectedKeys++;
        assertEquals(0, getHitsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));  
            public String load(ICacheKey<String> key) {
    }  
        });
            Settings.builder()
        // Again try to put OnHeap cache capacity amount of new items.
                .put(
        int diskCacheSize,
        List<ICacheKey<String>> onHeapKeys = new ArrayList<>();  
        Map<String, Long> tookTimeMap = new HashMap<>();
        int keyValueSize = 50;
            .build();  
                Settings.builder()
        assertEquals(totalOnDiskEntries, tieredSpilloverCache.diskCacheCount());
                segmentSizeTracker.put(keySegment, updatedValue);  
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
        Thread[] threads = new Thread[numThreads];
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()  
            Settings.builder()
            assertTrue(actualOnDiskKeys.contains(onDiskKey));  
        for (int i = 0; i < numberOfSegments; i++) {
            expectedDiskSize  
            keyValueSize,
            removalListener,
    }
            return data.length() % 2 == 0;
                    ).getKey(),
            removalListener,  
            keyValueSize,
                return "test";  
            )
                .put(
            "A",
        CountDownLatch countDownLatch1 = new CountDownLatch(1);  
    private long getEvictionsForTier(TieredSpilloverCache<?, ?> tsc, String tierValue) throws IOException {  
            )
                .build(),  
        int diskCacheSize = randomIntBetween(60, 100);
        // We should see only one heap miss, and the rest hits
import static org.mockito.Mockito.when;
        assertEquals(totalOnHeapEntries, getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
    }  
        int diskCacheSize = randomIntBetween(700, 1200);
        }  
            null,
            IllegalArgumentException.class,  
            int keySegment = tieredSpilloverCache.getSegmentNumber(key);
            numberOfSegments
        assertEquals(totalStats.getItems(), heapStats.getItems() + diskStats.getItems());
            )) {
        clusterSettings.registerSetting(TOOK_TIME_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE));  
            diskPolicies,
                    .setCachedResultParser(s -> new CachedQueryResult.PolicyValues(DEFAULT_TOOK_TIME_DISK_THRESHOLD.getNanos() * 2))  
            .setCacheConfig(cacheConfig)
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
            int totalEntriesForSegment = onHeapCacheExpectedSize.get(i) + mockDiskCacheExpectedSize.get(i);  
    }
        checkSegmentSizes(tieredSpilloverCache, expectedHeapSize, expectedDiskSize);
package org.opensearch.cache.common.tier;
            keyValueSize * 100,  
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(  
        // Put second key on tiered cache. Will cause eviction of first key from onHeap cache and should go into
            if (randomBoolean()) { // Hit cache with key stored in onHeap cache.
                return isLoaded;
        );  
import static org.opensearch.common.cache.settings.CacheSettings.VALID_SEGMENT_COUNT_VALUES;
                        CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()  
    }
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(
    }
        );
    private List<String> getMockDimensions() {
        }  
            .setKeySerializer(new StringSerializer())  
        ICache<String, String> tieredSpilloverICache = new TieredSpilloverCache.TieredSpilloverCacheFactory().create(
        int onHeapCacheSize = 10;
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(
                    onHeapCacheSize * keyValueSize + "b"
            .setDimensionNames(dimensionNames)
            0,
            .put(
            }
                )  
    }
            numberOfSegments,
        assertEquals(1, onHeapCacheKeys.size());  
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
            1
        }  
            keyValueSize,
                    .build(),
                .build(),  
            Settings.builder()
        assertEquals(0, getEvictionsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));  
            }
            }  
            )  
            LoadAwareCacheLoader<ICacheKey<String>, String> tieredCacheLoader = getLoadAwareCacheLoader();  
        String storagePath;  
        RemovalListener<ICacheKey<String>, String> removalListener,
            tieredSpilloverCache.computeIfAbsent(key, loadAwareCacheLoader);
        assertEquals(actualDiskCacheSize, getEvictionsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
        assertNotEquals(0, heapStats.getMisses());
            CacheType.INDICES_REQUEST_CACHE
            // The size setting from the OpenSearchOnHeap implementation should not be honored  
            tieredSpilloverCache.computeIfAbsent(newKeyList.get(i), getLoadAwareCacheLoader());
            keyValueSize * 100,
            Settings.builder()
        doThrow(new RuntimeException("Testing")).when(mockOnHeapCache).put(any(), any());
            LoadAwareCacheLoader<ICacheKey<String>, String> loadAwareCacheLoader = getLoadAwareCacheLoader();
                .setStoragePath(storagePath)
        // We now calculate expected onHeap cache entries and then verify it later.
            assertTrue(actualMergedKeys.contains(key));
        Iterable<ICacheKey<String>> onHeapiterable = tieredSpilloverCache.getOnHeapCacheKeys();
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
            .put(  
            removalListener,
                TIER_DIMENSION_VALUE_DISK
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(
                ).getKey(),  
            .setValueSerializer(new StringSerializer())  
                    onHeapCacheSize * keyValueSize + "b"
        for (String key : keyValuePairs.keySet()) {
        }
        clusterSettings = new ClusterSettings(settings, new HashSet<>());
            .setRemovalListener(removalListener)
    public void testComputIfAbsentConcurrentlyWithMultipleKeys() throws Exception {
            LoadAwareCacheLoader<ICacheKey<String>, String> loader = loadAwareCacheLoaderList.get(i);
            numberOfSegments  
        );  
        Settings settings = Settings.builder()  
            Settings.builder()
        assertEquals(numOfItems1, tieredSpilloverCache.count());
        // for a given tier with a single node in MDCS  
        List<String> dims = new ArrayList<>();  
            )
        assertEquals(numOfItems1 + cacheMiss, getMissesForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));  
                assertNull(result);
                onHeapCacheSize * keyValueSize + "b"  
        tieredSpilloverCache.tieredSpilloverCacheSegments[0].getDiskCache().keys().forEach(diskKeys::add);
        assertEquals(numberOfSameKeys, exceptionCount.get());  
            assertEquals("Query cancelled!", ex.getCause().getMessage());  
            ICacheKey<String> key = getICacheKey(UUID.randomUUID().toString());  
        assertEquals(expectedEvictions, removalListener.evictionsMetric.count());
            public String load(ICacheKey<String> key) {  
            diskCacheSize,  
        tieredSpilloverCache.put(key, value);
        int numOfItems1 = randomIntBetween(1, onHeapCacheSize / 2 - 1);
                throw new RuntimeException("Testing");
                TIERED_SPILLOVER_SEGMENTS.getConcreteSettingForNamespace(CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()).getKey(),
        long heapSizeFromImplSetting = 50;  
        int totalSize = onHeapCacheSize + diskCacheSize;
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();  
                .put(  
        List<String> levelsList = new ArrayList<>(dimensionNames);
            if (segmentSizeTracker.get(keySegment) == null) {
            .setClusterSettings(clusterSettings)
            false,  
            )
        List<ICacheKey<String>> iCacheKeyList = new ArrayList<>();
        Settings settings,
                            boolean isLoaded = false;
        int onHeapCacheSize = randomIntBetween(10, 30);
        expectedMergedKeys.addAll(diskTierKeys);
        long evictionsBeforeDisablingDiskCache = totalStats.getEvictions();
    public void testPutAndVerifyNewItemsArePresentOnHeapCache() throws Exception {  
        assertTrue(onHeapCacheKeys.contains(key2));
            } else {
        }
    }
        if (snapshot == null) {
            .setSettings(  
        assertEquals(0, getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
                    ).getKey(),  
        Phaser phaser = new Phaser(numberOfSameKeys + 1);
                    TOOK_TIME_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE).getKey(),
        TieredSpilloverCache<String, String> tieredSpilloverCache = new TieredSpilloverCache.Builder<String, String>()  
    public void testComputeIfAbsentWhenTheQueryThrowsAnException() throws Exception {
            removalListener,  
                .build(),
                }
            diskCacheSize,  
    }
                ).getKey(),  
            .put(  
                totalOnDiskEntries += expectedNumberOfEntriesInSegment.get(i) - expectedSegmentOnHeapCacheSize.get(i);
        );  
        assertEquals(validDuration, concreteSetting.get(validSettings));  
        for (int i = 0; i < newKeyList.size(); i++) {
        for (String key : keyValueMap.keySet()) {  
    public void testRefresh() {  
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
        assertEquals(onHeapKeys.size(), getHitsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));  
    private int getNumberOfSegments() {
    }
                return isLoaded;
            }
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
        try (NodeEnvironment environment = newNodeEnvironment(settings)) {
                OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME
        assertEquals(0, getHitsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_DISK));
    public void testGetPutAndInvalidateWithDiskCacheDisabled() throws Exception {
            )
        long diskDeliberateDelay,
                .setWeigher((k, v) -> keyValueSize)  
        tieredSpilloverCache.computeIfAbsent(getICacheKey("test1"), new LoadAwareCacheLoader<>() {
        Phaser phaser = new Phaser(numThreads + 1);
            numberOfSegments,
        Map<Integer, Integer> expectedNumberOfEntriesInSegment = new HashMap<>();  
            }  
        assertEquals(totalStats.getSizeInBytes(), heapStats.getSizeInBytes() + diskStats.getSizeInBytes());  
    }
        public byte[] serialize(String object) {
                CacheType.INDICES_REQUEST_CACHE,  
        }  
    private Tuple<List<Predicate<String>>, Map<String, Tuple<String, Boolean>>> setupPoliciesTest() {
        int diskCacheSize = randomIntBetween(onHeapCacheSize + 1, 100);  
            }  
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(
        assertEquals(0, tieredSpilloverCache.diskCacheCount() - actualDiskCacheCount); // Considering it is disabled now, shouldn't
            "C",  
        assertEquals(0, tieredSpilloverCache.completableFutureMap.size());
        );  
            newKeyList.add(getICacheKey(UUID.randomUUID().toString()));
                    onHeapCacheSize * keyValueSize + "b"
                ).getKey(),
                )
                tieredSpilloverCache,  
            diskCacheSize,
            .setValueSerializer(new StringSerializer())
                TieredSpilloverCacheSettings.TIERED_SPILLOVER_DISK_STORE_NAME.getConcreteSettingForNamespace(
            assertNull(tieredSpilloverCache.getTieredCacheSegment(iCacheKey).getOnHeapCache().get(iCacheKey));
                String mapValue = keyValueMap.get(key.key).v1();
        for (int i = 0; i < approxNumHits; i++) {
        }  
import java.util.concurrent.CountDownLatch;  
            tieredSpilloverCache.computeIfAbsent(getICacheKey(UUID.randomUUID().toString()), tieredCacheLoader);
            .put(  
                if (randomBoolean()) {
         * totalEntries = heapEntries + diskEntries
        int expectedEvictions = 0;
        for (ICacheKey<String> key : expectedMergedKeys) {
import java.util.HashSet;  
            .setKeyType(String.class)
            keyValueSize
        String storagePath = getStoragePath(settings);  
            diskCacheSize,  
            )  
            .put(
            )
                    .put(  
        long expectedDiskSize = MIN_DISK_CACHE_SIZE_IN_BYTES + 256L * between(30, 40);
                .put(
        // Again invalidate older key, leaving one in heap tier and zero in disk tier
                        @Override  
                    ).getKey(),  
            keyValueSize,  
        assertEquals(getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP), tieredSpilloverCache.onHeapCacheCount());
                    onHeapCacheSize * keyValueSize + "b"
            .put(  
        clusterSettings.applySettings(
                assertEquals(keyValuePairs.get(key).v1(), result);
            .put(
        ).get(settings).getBytes();
        assertEquals(1, diskKeys.size());
        // should be 0 after that.  
        assertEquals(numOfItems1, getMissesForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
    public void testEntryPoliciesWithPut() throws Exception {  
                MockDiskCache.MockDiskCacheFactory.NAME
        // Verify that new items are part of onHeap cache.
                expectedNumberOfEntriesInSegment.put(keySegment, updatedValue);
            .setRemovalListener(removalListener)  
                CacheSettings.getConcreteStoreNameSettingForCacheType(CacheType.INDICES_REQUEST_CACHE).getKey(),
                    .build(),
        for (int iter = 0; iter < numOfItems1; iter++) {  
        Settings settings,  
        String value = "";
        assertEquals(TieredSpilloverCacheSettings.defaultSegments(), tieredSpilloverCache.getNumberOfSegments());  
            assertNull(tieredSpilloverCache.get(diskKey)); // Considering disk cache is disabled, we shouldn't find
        }
        List<Predicate<String>> policies,
        assertEquals(numberOfKeys, numberOfTimesKeyLoaded); // It should be loaded only once.
            null,
        // To test concurrently, run for each key multiple times in parallel threads  
            ICacheKey<String> key = getICacheKey(UUID.randomUUID().toString());
            @Override
            ICacheKey<String> key = getICacheKey(UUID.randomUUID().toString());
            1
            .put(
            policies,
        value = tieredSpilloverCache.computeIfAbsent(getICacheKey("test"), new LoadAwareCacheLoader<>() {  
                        loadAwareCacheLoaderList.add(loadAwareCacheLoader);  
            tieredSpilloverCache.computeIfAbsent(key, tieredCacheLoader);
                onHeapCacheHit++;
    }
                CacheSettings.getConcreteStoreNameSettingForCacheType(CacheType.INDICES_REQUEST_CACHE).getKey(),
            Boolean expectedInCache = keyValuePairs.get(key).v2();
                .put(
                .setDimensionNames(dimensionNames)  
                        CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
            0,
            onHeapCacheSizeInBytes,
        TieredSpilloverCache<String, String> tieredSpilloverCache = initializeTieredSpilloverCache(
                    .setCachedResultParser(s -> new CachedQueryResult.PolicyValues(DEFAULT_TOOK_TIME_DISK_THRESHOLD.getNanos() * 2))
                )
            Settings.builder()
        MockCacheRemovalListener<String, String> removalListener = new MockCacheRemovalListener<>();
            getItemsForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP) + getItemsForTier(
        for (String key : keyValuePairs.keySet()) {
                    onHeapCacheSize * keyValueSize + "b"
            @Override
                OpenSearchOnHeapCacheSettings.MAXIMUM_SIZE_IN_BYTES.getConcreteSettingForNamespace(
        assertEquals(numOfItems1, getMissesForTier(tieredSpilloverCache, TIER_DIMENSION_VALUE_ON_HEAP));
        // The TSC's tier size settings, TIERED_SPILLOVER_ONHEAP_STORE_SIZE and TIERED_SPILLOVER_DISK_STORE_SIZE,
            .setStoragePath(getStoragePath(settings))
                    TOOK_TIME_DISK_TIER_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE).getKey(),
        for (String key : keyValueMap.keySet()) {  
        Thread thread = new Thread(() -> {
        int keyValueSize = 1;
    }  
            }
