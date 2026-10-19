        for (int indexA = 0; indexA < numAValues; indexA++) {
        for (List<String> dimensionValues : expected.keySet()) {
            assertNull(getNode(List.of("A1", "B1"), cacheStatsHolder.getStatsRoot()));
    static Map<String, List<String>> getUsedDimensionValues(
            assertEquals(expectedTotal, actual);
            assertEquals(cacheStatsHolders.get(0).getDimensionNames(), statsHolder.getDimensionNames());
        }
        List<List<String>> statsToPopulate = List.of(List.of("A1", "B1"), List.of("A2", "B2"), List.of("A2", "B3"));  
                assertEquals(expectedCounter.immutableSnapshot(), actualCacheStats);
            expectedTotal = new ImmutableCacheStats(originalHits - 2 * removedHitsPerRemovedNode, numNodes - 2, numNodes - 2, 0, 0);  
                            threadRand.nextInt(10),
            });  
 * The OpenSearch Contributors require contributions made to  
    }  
        List<List<String>> dimensionsForThreads = new ArrayList<>();
                            threadRand.nextInt(10),
        for (Thread thread : threads) {
                int index = between(0, usedDimensionValues.get(dimName).size() - 1);
        setupRemovalTest(cacheStatsHolder, statsToPopulate, true);
            }
            CacheStats originalCounter = expected.get(dimensionValues);  
            assertNull(getNode(List.of("A2", "B2"), cacheStatsHolder.getStatsRoot()));  
        TieredSpilloverCacheStatsHolder cacheStatsHolder = new TieredSpilloverCacheStatsHolder(dimensionNames, true);
                        for (int iter = 0; iter < statsToInc.getMisses(); iter++) {
    static Map<List<String>, CacheStats> populateStats(  
                ImmutableCacheStats actualStatsHolder = getNode(dimensionValues, cacheStatsHolder.getStatsRoot()).getImmutableStats();
            // If disk tier is enabled, we expect hits to be 2 * numNodes (1 heap + 1 disk per combination of dims), otherwise 1 * numNodes.
        }
        DefaultCacheStatsHolder.Node current = root;
        // Create stats for the following dimension sets
        boolean diskTierEnabled
import java.util.Random;
    private void add(CacheStats original, CacheStats other, boolean countMissesAndEvictionsTowardsTotal) {
    public void testDropStatsForDimensions() throws Exception {  
                List<String> dimensions = dimensionsForThreads.get(finalI);
            }  
        }
    ) {  
            ImmutableCacheStats actual = node.getImmutableStats();
        Map<String, List<String>> usedDimensionValues,
        for (int indexA = 1; indexA < numAValues; indexA++) {
                return null;
            }
                expected.computeIfAbsent(dimensions, (key) -> new CacheStats());  
        return current;
        for (TieredSpilloverCacheStatsHolder statsHolder : cacheStatsHolders) {
        }  
        boolean diskTierEnabled
public class TieredSpilloverCacheStatsHolderTests extends OpenSearchTestCase {
        }  
    }
        boolean diskTierEnabled
                    for (int j = 0; j < numRepetitionsPerValue; j++) {
            assertEquals(expectedTotal, cacheStatsHolder.getStatsRoot().getImmutableStats());
            misses = other.getMisses();  
            for (int j = 0; j < numValuesPerDim; j++) {
        int numRepetitionsPerValue,  
        // Create stats for the following dimension sets
        List<TieredSpilloverCacheStatsHolder> cacheStatsHolders,
            thread.join();  
            int finalI = i;
        int numValuesPerDim,
        for (String dimensionValue : dimensionValues) {
    static Map<List<String>, CacheStats> populateStats(
            for (int indexB = 0; indexB < numBValues; indexB++) {  
}
        assertEquals(expectedCount, cacheStatsHolder.count());  
 *
            threads[i] = new Thread(() -> {  
    /**
            dimensionsForThreads.add(getRandomDimList(cacheStatsHolders.get(0).getDimensionNames(), usedDimensionValues, true, rand));
import org.opensearch.common.cache.stats.ImmutableCacheStats;
        return expected;  
import static org.opensearch.cache.common.tier.TieredSpilloverCacheStatsHolder.TIER_VALUES;  
            diskTierEnabled
            assertNotNull(b1LeafNode);  
                            threadRand.nextInt(5000),
import static org.opensearch.cache.common.tier.TieredSpilloverCacheStatsHolder.TIER_DIMENSION_VALUE_ON_HEAP;
import static org.opensearch.cache.common.tier.TieredSpilloverCacheStatsHolder.TIER_DIMENSION_VALUE_DISK;
                add(expectedTotal, other, countMissesAndEvictionsTowardsTotal);
            assertEquals(new ImmutableCacheStats(2, 1, 1, 0, 0), b1LeafNode.getImmutableStats());
                originalCounter.getHits(),
                cacheStatsHolder.incrementEvictions(dims, includeInTotal);  
        }
     */
                        for (int iter = 0; iter < statsToInc.getHits(); iter++) {
import java.util.List;  
            for (List<String> dims : expected.keySet()) {  
        Thread[] threads = new Thread[numAValues + 1];
    public void testAddAndGet() throws Exception {  
        TieredSpilloverCacheStatsHolder cacheStatsHolder,  
        }
                            threadRand.nextInt(10),  
            assertNull(getNode(List.of("A2", "B2", TIER_DIMENSION_VALUE_ON_HEAP), cacheStatsHolder.getStatsRoot()));
        int numDistinctValuePairs,  
                assertEquals(expectedCounter.immutableSnapshot(), actualStatsHolder);  
        for (String dimName : dimensionNames) {
            assertNotNull(getNode(List.of("A2"), cacheStatsHolder.getStatsRoot()));
                        );  
        boolean diskTierEnabled
            cacheStatsHolder.removeDimensions(List.of("A2", "B2"));  
            assertNotNull(getNode(List.of("A2", "B3", TIER_DIMENSION_VALUE_ON_HEAP), cacheStatsHolder.getStatsRoot()));
    static void setupRemovalTest(
        long evictions = 0;
        for (int i = 0; i < numDistinctValuePairs; i++) {  
                originalCounter.getEvictions(),
            threads[i] = new Thread(() -> { cacheStatsHolder.removeDimensions(List.of("A" + finalI, "B0")); });
                        expected.get(dimensions).incrementSizeInBytes(statsToInc.getSizeInBytes());
        }
import org.opensearch.test.OpenSearchTestCase;
            numRepetitionsPerValue,
                ImmutableCacheStats actualCacheStats = getNode(dimensionValues, cacheStatsHolder.getStatsRoot()).getImmutableStats();
        boolean pickValueForAllDims,  
        List<String> dimensionNames = List.of("dim1", "dim2");
            // test the value in the map is as expected for each distinct combination of values (all leaf nodes)
        Map<List<String>, CacheStats> expected = populateStats(cacheStatsHolder, usedDimensionValues, 100, 10, true);  
        int numBValues = 2;
     * Returns null if no such node exists.
        TieredSpilloverCacheStatsHolder cacheStatsHolder,  
                boolean countMissesAndEvictionsTowardsTotal = dims.get(dims.size() - 1).equals(TIER_DIMENSION_VALUE_DISK)
            for (String tier : tiers) {
import org.opensearch.common.cache.stats.CacheStats;
    ) throws InterruptedException {  
    ) throws InterruptedException {
                        }
            // Misses and evictions should be 1 * numNodes in either case (if disk tier is present, count only the disk misses/evictions, if
        for (Map.Entry<List<String>, CacheStats> entry : statsMap.entrySet()) {
        }
        for (boolean diskTierEnabled : List.of(true, false)) {
import java.util.Map;
                        }  
 * compatible open source license.
            CacheStats stats = entry.getValue();
            }
            DefaultCacheStatsHolder.Node b1LeafNode = getNode(List.of("A" + indexA, "B1"), cacheStatsHolder.getStatsRoot());
        Map<String, List<String>> usedDimensionValues = getUsedDimensionValues(cacheStatsHolder, 10, true);
            thread.start();  
            cacheStatsHolder.incrementSizeInBytes(dims, stats.getSizeInBytes());
            }
        List<String> dimensionNames = List.of("dim1", "dim2");
            // Check the resulting total is correct.
        // Remove a subset of the dimensions concurrently.  
                        }  
            DefaultCacheStatsHolder.Node node = getNode(dimensionValues, cacheStatsHolder.getStatsRoot());  
        } else {
            long removedHitsPerRemovedNode = diskTierEnabled ? 2 : 1;
            }
            assertEquals(expectedTotal.immutableSnapshot(), cacheStatsHolder.getStatsRoot().getImmutableStats());  
                            expected.get(dimensions).incrementEvictions();
            for (List<String> dimensionValues : expected.keySet()) {
                        }  
        for (Thread thread : threads) {
import java.util.UUID;  
    }
        }
import org.opensearch.common.Randomness;
        Map<List<String>, CacheStats> statsMap,
            }  
            ImmutableCacheStats expectedTotal = new ImmutableCacheStats(
            );
            for (int i = 0; i < stats.getMisses(); i++) {
            long originalHits = diskTierEnabled ? 2 * numNodes : numNodes;
            assertNull(getNode(List.of("A2", "B2", TIER_DIMENSION_VALUE_DISK), cacheStatsHolder.getStatsRoot()));
        countDownLatch.await();
        if (countMissesAndEvictionsTowardsTotal) {
        if (diskTierEnabled) {  
            TieredSpilloverCacheStatsHolder cacheStatsHolder = new TieredSpilloverCacheStatsHolder(dimensionNames, diskTierEnabled);
            cacheStatsHolder.removeDimensions(List.of("A2", "B3"));
    }  
    public void testCount() throws Exception {
            // We expect hits to go down by 2 (1 heap + 1 disk) if disk is enabled, and 1 otherwise. Evictions/misses should go down by 1 in
        // Add other to original, accounting for whether other is from the heap or disk tier
        CacheStats modifiedOther = new CacheStats(other.getHits(), misses, evictions, other.getSizeInBytes(), other.getItems());  
        boolean diskTierEnabled
        return result;
        // leaf nodes for all B0 values should be null since they were removed  
        long expectedCount = 0L;
        Map<List<String>, CacheStats> expected = populateStats(cacheStatsHolder, usedDimensionValues, 100, 10, true);
        for (int indexA = 0; indexA < numAValues; indexA++) {
        Random rand = Randomness.get();
            for (int i = 0; i < stats.getEvictions(); i++) {
        int numRepetitionsPerValue,
                            expected.get(dimensions).incrementMisses();
        Random rand
        long misses = 0;  
    }  
        for (Thread thread : threads) {
        }
            DefaultCacheStatsHolder.Node intermediateLevelNode = getNode(List.of("A" + indexA), cacheStatsHolder.getStatsRoot());
                cacheStatsHolder.incrementMisses(dimsWithDimension);
        List<String> result = new ArrayList<>();  
        List<List<String>> statsToPopulate = new ArrayList<>();
    }
            Map<List<String>, CacheStats> expected = populateStats(cacheStatsHolder, usedDimensionValues, 1000, 10, diskTierEnabled);
                cacheStatsHolder.incrementMisses(dims);
        Map<String, List<String>> usedDimensionValues,
    // we can't reuse the same code.
                Random threadRand = Randomness.get();
        for (CacheStats counter : expected.values()) {  
            List.of(cacheStatsHolder),
            setupRemovalTest(cacheStatsHolder, statsToPopulate, diskTierEnabled);  
                    }  
        TieredSpilloverCacheStatsHolder cacheStatsHolder = new TieredSpilloverCacheStatsHolder(dimensionNames, true);  
            TieredSpilloverCacheStatsHolder cacheStatsHolder = new TieredSpilloverCacheStatsHolder(dimensionNames, diskTierEnabled);  
        }  
                for (TieredSpilloverCacheStatsHolder cacheStatsHolder : cacheStatsHolders) {
            ImmutableCacheStats expectedTotal = new ImmutableCacheStats(originalHits, numNodes, numNodes, 0, 0);
            // assertEquals(0, cacheStatsHolder.getStatsRoot().getChildren().size());
    ) {
            }  
        }
            assertNotNull(intermediateLevelNode);  
        Map<List<String>, CacheStats> expected = new ConcurrentHashMap<>();
                    || !diskTierEnabled;  
            }  
    }  
        Thread[] threads = new Thread[numDistinctValuePairs];
            assertEquals(new ImmutableCacheStats(0, 0, 0, 0, 0), cacheStatsHolder.getStatsRoot().getImmutableStats());  
        // and reflect only the stats for their B1 child.  
            if (current == null) {
    // These are modified from DefaultCacheStatsHolderTests.java to account for the tiers. Because we can't add a dependency on server.test,  
/*  
                values.add(UUID.randomUUID().toString());
        threads[numAValues] = new Thread(() -> { cacheStatsHolder.removeDimensions(List.of("A0", "B1")); });
    static DefaultCacheStatsHolder.Node getNode(List<String> dimensionValues, DefaultCacheStatsHolder.Node root) {  
 * SPDX-License-Identifier: Apache-2.0
        original.add(modifiedOther);
            assertNull(getNode(List.of("A1"), cacheStatsHolder.getStatsRoot()));
        // and the intermediate nodes A1 through A9 shouldn't be null as they have remaining children  
            // When we invalidate A2, B2, we should lose the node for B2, but not B3 or A2.
import org.opensearch.common.cache.stats.DefaultCacheStatsHolder;  
            for (int i = 0; i < stats.getHits(); i++) {
            usedDimensionValues.put(cacheStatsHolder.getDimensionNames().get(i), values);
                statsToPopulate.add(List.of("A" + indexA, "B" + indexB));
        for (int i = 0; i < cacheStatsHolder.getDimensionNames().size() - 1; i++) { // Have to handle final tier dimension separately
        // leaf nodes for all B1 values, except (A0, B1), should not be null as they weren't removed,
    }  
                List<String> dimsWithDimension = cacheStatsHolder.getDimensionsWithTierValue(dims, tier);
                        populateStatsHolderFromStatsValueMap(cacheStatsHolder, Map.of(dimensions, statsToInc), diskTierEnabled);
                boolean includeInTotal = tier.equals(TIER_DIMENSION_VALUE_DISK) || !diskTierEnabled;
            cacheStatsHolder.removeDimensions(List.of("A1", "B1"));
                result.add(usedDimensionValues.get(dimName).get(index));
            usedDimensionValues,
    ) {  
import java.util.ArrayList;
            assertEquals(expectedTotal, cacheStatsHolder.getStatsRoot().getImmutableStats());  
            evictions = other.getEvictions();
            // When we invalidate A1, B1, we should lose the nodes for B1 and also A1, as it has no more children.
            int numNodes = statsToPopulate.size(); // Number of distinct sets of dimensions (not including tiers)  
                0,
                0  
        // intermediate node for A0 should be null  
        int numDistinctValuePairs,
    private static List<String> getRandomDimList(  
            List<String> dims = entry.getKey();  
                        for (int iter = 0; iter < statsToInc.getEvictions(); iter++) {
        List<List<String>> statsToPopulate,
                boolean includeInTotal = dims.get(dims.size() - 1).equals(TIER_DIMENSION_VALUE_DISK) || !diskTierEnabled;
        );  
            expectedCount += counter.getItems();
        List<String> dimensionNames = List.of("A", "B");
                CacheStats expectedCounter = expected.get(dimensionValues);  
            List<String> values = new ArrayList<>();  
                }
                countDownLatch.countDown();
                originalCounter.getMisses(),  
        return usedDimensionValues;
            CacheStats expectedTotal = new CacheStats();
import java.util.HashMap;
            assertNull(getNode(List.of("A" + indexA, "B0"), cacheStatsHolder.getStatsRoot()));
    ) {  
        Map<String, List<String>> usedDimensionValues = new HashMap<>();
            expectedTotal = new ImmutableCacheStats(originalHits - removedHitsPerRemovedNode, numNodes - 1, numNodes - 1, 0, 0);
        for (List<String> dims : statsToPopulate) {
                CacheStats other = expected.get(dims);
    }
        }
        return populateStats(  
            }  
        cacheStatsHolder.reset();
            assertNull(getNode(List.of("A1", "B1", TIER_DIMENSION_VALUE_ON_HEAP), cacheStatsHolder.getStatsRoot()));
        }
        List<String> tiers = diskTierEnabled ? TIER_VALUES : List.of(TIER_DIMENSION_VALUE_ON_HEAP);
            int finalI = i;
        Map<String, List<String>> usedDimensionValues,
                cacheStatsHolder.incrementHits(dims);
        List<String> dimensionNames = List.of("dim1", "dim2");  
            if (pickValueForAllDims || rand.nextBoolean()) { // if pickValueForAllDims, always pick a value for each dimension, otherwise do
            numDistinctValuePairs,  
                // so 50% of the time  
            assertEquals(b1LeafNode.getImmutableStats(), intermediateLevelNode.getImmutableStats());
                cacheStatsHolder.incrementEvictions(dimsWithDimension, includeInTotal);  
package org.opensearch.cache.common.tier;
        List<String> dimensionNames,
                            expected.get(dimensions).incrementHits();
        assertNull(getNode(List.of("A0"), cacheStatsHolder.getStatsRoot()));
        TieredSpilloverCacheStatsHolder cacheStatsHolder,  
        for (boolean diskTierEnabled : List.of(true, false)) {
import java.util.concurrent.ConcurrentHashMap;
    }  
                        for (int iter = 0; iter < statsToInc.getItems(); iter++) {
 * this file be licensed under the Apache-2.0 license or a
        }
            // Check overall total matches
        for (int i = 0; i < numAValues; i++) {  
            Map<String, List<String>> usedDimensionValues = getUsedDimensionValues(cacheStatsHolder, 10, diskTierEnabled);
    public static void populateStatsHolderFromStatsValueMap(
                            threadRand.nextInt(10)
            List<String> dimensionNames = List.of("dim1", "dim2", "dim3", "dim4");
            usedDimensionValues.put(TieredSpilloverCacheStatsHolder.TIER_DIMENSION_NAME, List.of(TIER_DIMENSION_VALUE_ON_HEAP));  
    public void testConcurrentRemoval() throws Exception {  
            assertEquals(expectedTotal, cacheStatsHolder.getStatsRoot().getImmutableStats());  
        // For all the others, remove only the B0 value. Then we expect the intermediate nodes for A1 through A9 to be present
    }
        }  
        // Remove both (A0, B0), and (A0, B1), so we expect the intermediate node for A0 to be null afterwards.
        }  
            // When we invalidate the last node, all nodes should be deleted except the root node
    }
        CountDownLatch countDownLatch = new CountDownLatch(numDistinctValuePairs);  
        int numAValues = 10;  
import java.util.concurrent.CountDownLatch;
            thread.start();  
        }
            // Increment hits, misses, and evictions for set of dimensions, for both heap and disk  
                        CacheStats statsToInc = new CacheStats(  
            assertNull(getNode(List.of("A1", "B1", TIER_DIMENSION_VALUE_DISK), cacheStatsHolder.getStatsRoot()));  
            current = current.getChildren().get(dimensionValue);  
            usedDimensionValues.put(TieredSpilloverCacheStatsHolder.TIER_DIMENSION_NAME, TIER_VALUES);
        TieredSpilloverCacheStatsHolder cacheStatsHolder = new TieredSpilloverCacheStatsHolder(dimensionNames, true);
    }
                            expected.get(dimensions).incrementItems();  
                cacheStatsHolder.incrementItems(dims);
     * Returns the node found by following these dimension values down from the root node.  
        }  
        TieredSpilloverCacheStatsHolder cacheStatsHolder,  
                cacheStatsHolder.incrementHits(dimsWithDimension);  
 */  
            }
            for (int i = 0; i < stats.getItems(); i++) {  
            // either case.  
            // disk tier is absent, count the heap ones)  
        Map<String, List<String>> usedDimensionValues = getUsedDimensionValues(cacheStatsHolder, 10, true);
    public void testReset() throws Exception {
