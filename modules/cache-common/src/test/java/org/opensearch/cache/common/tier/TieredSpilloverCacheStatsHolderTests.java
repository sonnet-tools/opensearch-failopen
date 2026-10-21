            for (int i = 0; i < stats.getHits(); i++) {
    }
        if (diskTierEnabled) {
        }
            int finalI = i;
    private void add(CacheStats original, CacheStats other, boolean countMissesAndEvictionsTowardsTotal) {
            assertEquals(cacheStatsHolders.get(0).getDimensionNames(), statsHolder.getDimensionNames());
            }
        for (String dimensionValue : dimensionValues) {
                expected.computeIfAbsent(dimensions, (key) -> new CacheStats());
        for (boolean diskTierEnabled : List.of(true, false)) {
                            threadRand.nextInt(10),
        List<String> dimensionNames,
            assertNotNull(b1LeafNode);
    static void setupRemovalTest(
            );
            assertNull(getNode(List.of("A1", "B1", TIER_DIMENSION_VALUE_ON_HEAP), cacheStatsHolder.getStatsRoot()));
        for (Thread thread : threads) {
                statsToPopulate.add(List.of("A" + indexA, "B" + indexB));
        List<String> dimensionNames = List.of("dim1", "dim2");
            for (String tier : tiers) {
    public void testReset() throws Exception {
            ImmutableCacheStats expectedTotal = new ImmutableCacheStats(
            // We expect hits to go down by 2 (1 heap + 1 disk) if disk is enabled, and 1 otherwise. Evictions/misses should go down by 1 in
                            threadRand.nextInt(5000),
        TieredSpilloverCacheStatsHolder cacheStatsHolder,
import static org.opensearch.cache.common.tier.TieredSpilloverCacheStatsHolder.TIER_VALUES;
    /**
        return usedDimensionValues;
                int index = between(0, usedDimensionValues.get(dimName).size() - 1);
        }
            DefaultCacheStatsHolder.Node node = getNode(dimensionValues, cacheStatsHolder.getStatsRoot());
                cacheStatsHolder.incrementEvictions(dimsWithDimension, includeInTotal);
                assertEquals(expectedCounter.immutableSnapshot(), actualStatsHolder);
        return populateStats(
 */
        long misses = 0;
                        );
        TieredSpilloverCacheStatsHolder cacheStatsHolder = new TieredSpilloverCacheStatsHolder(dimensionNames, true);
            }
            // test the value in the map is as expected for each distinct combination of values (all leaf nodes)
import static org.opensearch.cache.common.tier.TieredSpilloverCacheStatsHolder.TIER_DIMENSION_VALUE_DISK;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
            if (current == null) {
                        CacheStats statsToInc = new CacheStats(
            });
        TieredSpilloverCacheStatsHolder cacheStatsHolder,
            }
        // Add other to original, accounting for whether other is from the heap or disk tier
            assertNull(getNode(List.of("A2", "B2", TIER_DIMENSION_VALUE_ON_HEAP), cacheStatsHolder.getStatsRoot()));
        // and the intermediate nodes A1 through A9 shouldn't be null as they have remaining children
        for (TieredSpilloverCacheStatsHolder statsHolder : cacheStatsHolders) {
        return result;
        threads[numAValues] = new Thread(() -> { cacheStatsHolder.removeDimensions(List.of("A0", "B1")); });
                CacheStats expectedCounter = expected.get(dimensionValues);
                CacheStats other = expected.get(dims);
        List<String> dimensionNames = List.of("dim1", "dim2");
        // Remove both (A0, B0), and (A0, B1), so we expect the intermediate node for A0 to be null afterwards.
        }
        for (Thread thread : threads) {
        int numBValues = 2;
            assertNotNull(getNode(List.of("A2"), cacheStatsHolder.getStatsRoot()));
        List<String> tiers = diskTierEnabled ? TIER_VALUES : List.of(TIER_DIMENSION_VALUE_ON_HEAP);
 * this file be licensed under the Apache-2.0 license or a
        boolean diskTierEnabled
            }
        cacheStatsHolder.reset();
        // Remove a subset of the dimensions concurrently.
    static DefaultCacheStatsHolder.Node getNode(List<String> dimensionValues, DefaultCacheStatsHolder.Node root) {
    }
            CacheStats expectedTotal = new CacheStats();
        boolean pickValueForAllDims,
package org.opensearch.cache.common.tier;
                boolean includeInTotal = tier.equals(TIER_DIMENSION_VALUE_DISK) || !diskTierEnabled;
        }
            }
}
    }
        Map<List<String>, CacheStats> expected = new ConcurrentHashMap<>();
        boolean diskTierEnabled
                0
            assertEquals(expectedTotal, cacheStatsHolder.getStatsRoot().getImmutableStats());
            assertNull(getNode(List.of("A1", "B1"), cacheStatsHolder.getStatsRoot()));
                        }
            cacheStatsHolder.removeDimensions(List.of("A2", "B2"));
        }
import java.util.HashMap;
                            expected.get(dimensions).incrementMisses();
    ) {
                for (TieredSpilloverCacheStatsHolder cacheStatsHolder : cacheStatsHolders) {
        }
            // Increment hits, misses, and evictions for set of dimensions, for both heap and disk
            TieredSpilloverCacheStatsHolder cacheStatsHolder = new TieredSpilloverCacheStatsHolder(dimensionNames, diskTierEnabled);
                cacheStatsHolder.incrementMisses(dimsWithDimension);
        List<String> result = new ArrayList<>();
        assertNull(getNode(List.of("A0"), cacheStatsHolder.getStatsRoot()));
        Thread[] threads = new Thread[numAValues + 1];
    }
        }
            assertEquals(new ImmutableCacheStats(0, 0, 0, 0, 0), cacheStatsHolder.getStatsRoot().getImmutableStats());
                cacheStatsHolder.incrementItems(dims);
                    || !diskTierEnabled;
            long originalHits = diskTierEnabled ? 2 * numNodes : numNodes;
            diskTierEnabled
        for (int indexA = 1; indexA < numAValues; indexA++) {
        }
            CacheStats stats = entry.getValue();
 *
        }
        int numRepetitionsPerValue,
                            threadRand.nextInt(10),
        Map<String, List<String>> usedDimensionValues,
                        for (int iter = 0; iter < statsToInc.getEvictions(); iter++) {
            assertNull(getNode(List.of("A2", "B2"), cacheStatsHolder.getStatsRoot()));
            assertNull(getNode(List.of("A2", "B2", TIER_DIMENSION_VALUE_DISK), cacheStatsHolder.getStatsRoot()));
            }
        List<List<String>> dimensionsForThreads = new ArrayList<>();
    }
/*
import java.util.UUID;
                        }
            }
                }
        }
        boolean diskTierEnabled
    }
                originalCounter.getMisses(),
                originalCounter.getEvictions(),
import org.opensearch.common.Randomness;
        CountDownLatch countDownLatch = new CountDownLatch(numDistinctValuePairs);
            }
            assertEquals(new ImmutableCacheStats(2, 1, 1, 0, 0), b1LeafNode.getImmutableStats());
            assertEquals(expectedTotal.immutableSnapshot(), cacheStatsHolder.getStatsRoot().getImmutableStats());
            expectedTotal = new ImmutableCacheStats(originalHits - removedHitsPerRemovedNode, numNodes - 1, numNodes - 1, 0, 0);
                boolean includeInTotal = dims.get(dims.size() - 1).equals(TIER_DIMENSION_VALUE_DISK) || !diskTierEnabled;
            assertNotNull(intermediateLevelNode);
        DefaultCacheStatsHolder.Node current = root;
            usedDimensionValues.put(TieredSpilloverCacheStatsHolder.TIER_DIMENSION_NAME, List.of(TIER_DIMENSION_VALUE_ON_HEAP));
            List<String> values = new ArrayList<>();
            CacheStats originalCounter = expected.get(dimensionValues);
        }
        Random rand = Randomness.get();
        long evictions = 0;
    }
        int numRepetitionsPerValue,
        for (boolean diskTierEnabled : List.of(true, false)) {
            }
            usedDimensionValues,
        original.add(modifiedOther);
        Thread[] threads = new Thread[numDistinctValuePairs];
                Random threadRand = Randomness.get();
    public void testConcurrentRemoval() throws Exception {
        }
    ) throws InterruptedException {
        for (List<String> dims : statsToPopulate) {
    static Map<List<String>, CacheStats> populateStats(
            assertEquals(b1LeafNode.getImmutableStats(), intermediateLevelNode.getImmutableStats());
                originalCounter.getHits(),
                cacheStatsHolder.incrementHits(dims);
 * SPDX-License-Identifier: Apache-2.0
            Map<List<String>, CacheStats> expected = populateStats(cacheStatsHolder, usedDimensionValues, 1000, 10, diskTierEnabled);
            for (List<String> dimensionValues : expected.keySet()) {
        }
    static Map<String, List<String>> getUsedDimensionValues(
    ) {
                add(expectedTotal, other, countMissesAndEvictionsTowardsTotal);
                        for (int iter = 0; iter < statsToInc.getItems(); iter++) {
    // we can't reuse the same code.
            for (int i = 0; i < stats.getEvictions(); i++) {
        assertEquals(expectedCount, cacheStatsHolder.count());
                    for (int j = 0; j < numRepetitionsPerValue; j++) {
                        for (int iter = 0; iter < statsToInc.getHits(); iter++) {
        if (countMissesAndEvictionsTowardsTotal) {
    }
    ) {
        boolean diskTierEnabled
import static org.opensearch.cache.common.tier.TieredSpilloverCacheStatsHolder.TIER_DIMENSION_VALUE_ON_HEAP;
        }
import java.util.concurrent.CountDownLatch;
            thread.start();
        int numValuesPerDim,
            expectedTotal = new ImmutableCacheStats(originalHits - 2 * removedHitsPerRemovedNode, numNodes - 2, numNodes - 2, 0, 0);
                countDownLatch.countDown();
    }
        Map<List<String>, CacheStats> expected = populateStats(cacheStatsHolder, usedDimensionValues, 100, 10, true);
    ) throws InterruptedException {
    static Map<List<String>, CacheStats> populateStats(
            // If disk tier is enabled, we expect hits to be 2 * numNodes (1 heap + 1 disk per combination of dims), otherwise 1 * numNodes.
            List.of(cacheStatsHolder),
        List<List<String>> statsToPopulate = new ArrayList<>();
        for (int indexA = 0; indexA < numAValues; indexA++) {
            // Check the resulting total is correct.
                cacheStatsHolder.incrementEvictions(dims, includeInTotal);
                0,
        for (int i = 0; i < cacheStatsHolder.getDimensionNames().size() - 1; i++) { // Have to handle final tier dimension separately
            setupRemovalTest(cacheStatsHolder, statsToPopulate, diskTierEnabled);
import org.opensearch.common.cache.stats.ImmutableCacheStats;
        int numDistinctValuePairs,
            expectedCount += counter.getItems();
        // leaf nodes for all B0 values should be null since they were removed
            numDistinctValuePairs,
        int numAValues = 10;
        TieredSpilloverCacheStatsHolder cacheStatsHolder = new TieredSpilloverCacheStatsHolder(dimensionNames, true);
            // assertEquals(0, cacheStatsHolder.getStatsRoot().getChildren().size());
        for (String dimName : dimensionNames) {
            assertNull(getNode(List.of("A1", "B1", TIER_DIMENSION_VALUE_DISK), cacheStatsHolder.getStatsRoot()));
                List<String> dimsWithDimension = cacheStatsHolder.getDimensionsWithTierValue(dims, tier);
        );
            dimensionsForThreads.add(getRandomDimList(cacheStatsHolders.get(0).getDimensionNames(), usedDimensionValues, true, rand));
            // When we invalidate A1, B1, we should lose the nodes for B1 and also A1, as it has no more children.
        }
        Map<String, List<String>> usedDimensionValues,
            long removedHitsPerRemovedNode = diskTierEnabled ? 2 : 1;
        Map<String, List<String>> usedDimensionValues = new HashMap<>();
            // Misses and evictions should be 1 * numNodes in either case (if disk tier is present, count only the disk misses/evictions, if
            Map<String, List<String>> usedDimensionValues = getUsedDimensionValues(cacheStatsHolder, 10, diskTierEnabled);
            // When we invalidate A2, B2, we should lose the node for B2, but not B3 or A2.
     */
            List<String> dims = entry.getKey();
            thread.start();
            for (int j = 0; j < numValuesPerDim; j++) {
        List<List<String>> statsToPopulate,
        long expectedCount = 0L;
            threads[i] = new Thread(() -> {
        Map<String, List<String>> usedDimensionValues = getUsedDimensionValues(cacheStatsHolder, 10, true);
            int finalI = i;
                assertEquals(expectedCounter.immutableSnapshot(), actualCacheStats);
        }
            TieredSpilloverCacheStatsHolder cacheStatsHolder = new TieredSpilloverCacheStatsHolder(dimensionNames, diskTierEnabled);
            current = current.getChildren().get(dimensionValue);
            }
            assertNotNull(getNode(List.of("A2", "B3", TIER_DIMENSION_VALUE_ON_HEAP), cacheStatsHolder.getStatsRoot()));
            cacheStatsHolder.removeDimensions(List.of("A2", "B3"));
            usedDimensionValues.put(TieredSpilloverCacheStatsHolder.TIER_DIMENSION_NAME, TIER_VALUES);
            if (pickValueForAllDims || rand.nextBoolean()) { // if pickValueForAllDims, always pick a value for each dimension, otherwise do
    public void testDropStatsForDimensions() throws Exception {
        Map<List<String>, CacheStats> statsMap,
            evictions = other.getEvictions();
            DefaultCacheStatsHolder.Node intermediateLevelNode = getNode(List.of("A" + indexA), cacheStatsHolder.getStatsRoot());
        List<String> dimensionNames = List.of("dim1", "dim2");
                ImmutableCacheStats actualCacheStats = getNode(dimensionValues, cacheStatsHolder.getStatsRoot()).getImmutableStats();
        for (Map.Entry<List<String>, CacheStats> entry : statsMap.entrySet()) {
        List<List<String>> statsToPopulate = List.of(List.of("A1", "B1"), List.of("A2", "B2"), List.of("A2", "B3"));
            numRepetitionsPerValue,
            int numNodes = statsToPopulate.size(); // Number of distinct sets of dimensions (not including tiers)
        }
                result.add(usedDimensionValues.get(dimName).get(index));
                        expected.get(dimensions).incrementSizeInBytes(statsToInc.getSizeInBytes());
            thread.join();
     * Returns the node found by following these dimension values down from the root node.
import java.util.Random;
            List<String> dimensionNames = List.of("dim1", "dim2", "dim3", "dim4");
                cacheStatsHolder.incrementHits(dimsWithDimension);
        Map<String, List<String>> usedDimensionValues,
    // These are modified from DefaultCacheStatsHolderTests.java to account for the tiers. Because we can't add a dependency on server.test,
                        for (int iter = 0; iter < statsToInc.getMisses(); iter++) {
    }
            // Check overall total matches
        for (Thread thread : threads) {
        // Create stats for the following dimension sets
            for (int i = 0; i < stats.getMisses(); i++) {
        // Create stats for the following dimension sets
import org.opensearch.common.cache.stats.CacheStats;
            // disk tier is absent, count the heap ones)
 * The OpenSearch Contributors require contributions made to
    private static List<String> getRandomDimList(
            cacheStatsHolder.removeDimensions(List.of("A1", "B1"));
        Random rand
import org.opensearch.test.OpenSearchTestCase;
        TieredSpilloverCacheStatsHolder cacheStatsHolder,
        for (List<String> dimensionValues : expected.keySet()) {
            assertNull(getNode(List.of("A" + indexA, "B0"), cacheStatsHolder.getStatsRoot()));
                            expected.get(dimensions).incrementEvictions();
import java.util.Map;
            for (int i = 0; i < stats.getItems(); i++) {
            misses = other.getMisses();
            for (List<String> dims : expected.keySet()) {
                    }
                        }
        Map<List<String>, CacheStats> expected = populateStats(cacheStatsHolder, usedDimensionValues, 100, 10, true);
        // and reflect only the stats for their B1 child.
        TieredSpilloverCacheStatsHolder cacheStatsHolder = new TieredSpilloverCacheStatsHolder(dimensionNames, true);
            // either case.
 * compatible open source license.
        setupRemovalTest(cacheStatsHolder, statsToPopulate, true);
     * Returns null if no such node exists.
    public static void populateStatsHolderFromStatsValueMap(
            threads[i] = new Thread(() -> { cacheStatsHolder.removeDimensions(List.of("A" + finalI, "B0")); });
            assertEquals(expectedTotal, cacheStatsHolder.getStatsRoot().getImmutableStats());
        // For all the others, remove only the B0 value. Then we expect the intermediate nodes for A1 through A9 to be present
                return null;
    public void testAddAndGet() throws Exception {
            assertEquals(expectedTotal, cacheStatsHolder.getStatsRoot().getImmutableStats());
import java.util.List;
                            threadRand.nextInt(10),
        int numDistinctValuePairs,
    public void testCount() throws Exception {
                        }
        // leaf nodes for all B1 values, except (A0, B1), should not be null as they weren't removed,
    }
        for (int indexA = 0; indexA < numAValues; indexA++) {
                List<String> dimensions = dimensionsForThreads.get(finalI);
        Map<String, List<String>> usedDimensionValues = getUsedDimensionValues(cacheStatsHolder, 10, true);
        return current;
public class TieredSpilloverCacheStatsHolderTests extends OpenSearchTestCase {
            ImmutableCacheStats actual = node.getImmutableStats();
        for (int i = 0; i < numDistinctValuePairs; i++) {
        boolean diskTierEnabled
                // so 50% of the time
            assertNull(getNode(List.of("A1"), cacheStatsHolder.getStatsRoot()));
            }
                            expected.get(dimensions).incrementItems();
    ) {
        return expected;
            for (int indexB = 0; indexB < numBValues; indexB++) {
    }
                ImmutableCacheStats actualStatsHolder = getNode(dimensionValues, cacheStatsHolder.getStatsRoot()).getImmutableStats();
        // intermediate node for A0 should be null
        for (CacheStats counter : expected.values()) {
        countDownLatch.await();
                values.add(UUID.randomUUID().toString());
        }
        }
import org.opensearch.common.cache.stats.DefaultCacheStatsHolder;
            DefaultCacheStatsHolder.Node b1LeafNode = getNode(List.of("A" + indexA, "B1"), cacheStatsHolder.getStatsRoot());
                        populateStatsHolderFromStatsValueMap(cacheStatsHolder, Map.of(dimensions, statsToInc), diskTierEnabled);
                boolean countMissesAndEvictionsTowardsTotal = dims.get(dims.size() - 1).equals(TIER_DIMENSION_VALUE_DISK)
                cacheStatsHolder.incrementMisses(dims);
                            expected.get(dimensions).incrementHits();
            assertEquals(expectedTotal, actual);
    }
        List<String> dimensionNames = List.of("A", "B");
        }
        List<TieredSpilloverCacheStatsHolder> cacheStatsHolders,
            ImmutableCacheStats expectedTotal = new ImmutableCacheStats(originalHits, numNodes, numNodes, 0, 0);
                            threadRand.nextInt(10)
            // When we invalidate the last node, all nodes should be deleted except the root node
        for (int i = 0; i < numAValues; i++) {
            cacheStatsHolder.incrementSizeInBytes(dims, stats.getSizeInBytes());
        TieredSpilloverCacheStatsHolder cacheStatsHolder,
            usedDimensionValues.put(cacheStatsHolder.getDimensionNames().get(i), values);
        CacheStats modifiedOther = new CacheStats(other.getHits(), misses, evictions, other.getSizeInBytes(), other.getItems());
        } else {
