    }
    private final String storeName = "dummy_store";
    ) throws InterruptedException {
    public void testAddAndGet() throws Exception {
        for (String dimensionValue : dimensionValues) {
    public void testConcurrentRemoval() throws Exception {
            }
        List<String> dimensionNames = List.of("dim1", "dim2");
     * Returns null if no such node exists.
        List<String> dimensionNames = List.of("dim1", "dim2");
            thread.join();
                return null;
    static Map<List<String>, CacheStats> populateStats(
        List<String> dimensionNames = List.of("A", "B");
        return populateStats(List.of(cacheStatsHolder), usedDimensionValues, numDistinctValuePairs, numRepetitionsPerValue);
            }
        Map<String, List<String>> usedDimensionValues = getUsedDimensionValues(cacheStatsHolder, 10);
            threads[i] = new Thread(() -> {
                expectedTotal.add(child.getImmutableStats());
        Random rand = Randomness.get();
import org.opensearch.common.Randomness;
                        expected.get(dimensions).evictions.inc(statsToInc.getEvictions());
            expectedCount += counter.getItems();
                            threadRand.nextInt(10)
            cacheStatsHolder.incrementSizeInBytes(dims, stats.getSizeInBytes());
import java.util.UUID;
        assertEquals(2, cacheStatsHolder.getStatsRoot().getImmutableStats().getHits());
        for (int i = 0; i < numAValues; i++) {
            }
                cacheStatsHolder.incrementHits(dims);
 *
                Random threadRand = Randomness.get();
        DefaultCacheStatsHolder cacheStatsHolder,
    static Map<String, List<String>> getUsedDimensionValues(DefaultCacheStatsHolder cacheStatsHolder, int numValuesPerDim) {
            }
        cacheStatsHolder.removeDimensions(List.of("A1", "B1"));
        assertSumOfChildrenStats(cacheStatsHolder.getStatsRoot());
                        expected.get(dimensions).sizeInBytes.inc(statsToInc.getSizeInBytes());
                countDownLatch.countDown();
            assertEquals(b1LeafNode.getImmutableStats(), intermediateLevelNode.getImmutableStats());
    public void testCount() throws Exception {
        assertNull(getNode(List.of("A2", "B2"), cacheStatsHolder.getStatsRoot()));
            usedDimensionValues,
        List<DefaultCacheStatsHolder> cacheStatsHolders,
            DefaultCacheStatsHolder.Node b1LeafNode = getNode(List.of("A" + indexA, "B1"), cacheStatsHolder.getStatsRoot());
        for (Map.Entry<List<String>, CacheStats> entry : statsMap.entrySet()) {
        for (CacheStats counter : expected.values()) {
                expected.computeIfAbsent(dimensions, (key) -> new CacheStats());
        assertEquals(0, cacheStatsHolder.getStatsRoot().children.size());
        assertNull(getNode(List.of("A1"), cacheStatsHolder.getStatsRoot()));
        }
import java.util.HashMap;
                        expected.get(dimensions).misses.inc(statsToInc.getMisses());
        CacheStats expectedTotal = new CacheStats();
        Map<String, List<String>> usedDimensionValues = getUsedDimensionValues(cacheStatsHolder, 10);
    }
import java.util.concurrent.ConcurrentHashMap;
        Map<String, List<String>> usedDimensionValues = DefaultCacheStatsHolderTests.getUsedDimensionValues(cacheStatsHolder, 10);
        // Create stats for the following dimension sets
                            threadRand.nextInt(10),
            dimensionsForThreads.add(getRandomDimList(cacheStatsHolders.get(0).getDimensionNames(), usedDimensionValues, true, rand));
        CountDownLatch countDownLatch = new CountDownLatch(numDistinctValuePairs);
    private void assertSumOfChildrenStats(DefaultCacheStatsHolder.Node current) {
import java.util.List;
        Map<String, List<String>> usedDimensionValues,
    public static void populateStatsHolderFromStatsValueMap(
        // Check overall total matches
                        );
        for (int indexA = 0; indexA < numAValues; indexA++) {
        // Create stats for the following dimension sets
                        DefaultCacheStatsHolderTests.populateStatsHolderFromStatsValueMap(cacheStatsHolder, Map.of(dimensions, statsToInc));
        DefaultCacheStatsHolder cacheStatsHolder = new DefaultCacheStatsHolder(dimensionNames, storeName);
}
    private static List<String> getRandomDimList(
        }
import java.util.ArrayList;
 * The OpenSearch Contributors require contributions made to
            DefaultCacheStatsHolder.Node node = getNode(dimensionValues, cacheStatsHolder.getStatsRoot());
        Map<List<String>, CacheStats> expected = DefaultCacheStatsHolderTests.populateStats(
package org.opensearch.common.cache.stats;
                            threadRand.nextInt(10),
            thread.start();
        return current;
        for (int i = 0; i < cacheStatsHolder.getDimensionNames().size(); i++) {
            CacheStats expectedTotal = new CacheStats();
            CacheStats stats = entry.getValue();
            1000,
                result.add(usedDimensionValues.get(dimName).get(index));
        cacheStatsHolder.removeDimensions(List.of("A2", "B3"));
        }
        List<String> dimensionNames = List.of("dim1", "dim2");
        boolean pickValueForAllDims,
            if (pickValueForAllDims || rand.nextBoolean()) { // if pickValueForAllDims, always pick a value for each dimension, otherwise do
        }
        // When we invalidate A2, B2, we should lose the node for B2, but not B3 or A2.
        assertEquals(0, cacheStatsHolder.getStatsRoot().getImmutableStats().getHits());
    }
            ImmutableCacheStats actualCacheStats = getNode(dimensionValues, cacheStatsHolder.getStatsRoot()).getImmutableStats();
                // so 50% of the time
    ) {
    }
            });
            assertEquals(cacheStatsHolders.get(0).getDimensionNames(), statsHolder.getDimensionNames());
        Map<String, List<String>> usedDimensionValues,
            10
        List<List<String>> populatedStats = new ArrayList<>();
        Map<List<String>, CacheStats> statsMap
        for (List<String> dimensionValues : expected.keySet()) {
            for (DefaultCacheStatsHolder.Node child : current.children.values()) {
        int numAValues = 10;
        int numRepetitionsPerValue
        for (List<String> dims : expected.keySet()) {
        // and the intermediate nodes A1 through A9 shouldn't be null as they have remaining children
        }
        }
        // For all the others, remove only the B0 value. Then we expect the intermediate nodes for A1 through A9 to be present
        // test the value in the map is as expected for each distinct combination of values
        Map<String, List<String>> usedDimensionValues,
            for (int i = 0; i < stats.getMisses(); i++) {
                int index = between(0, usedDimensionValues.get(dimName).size() - 1);
        }
        Thread[] threads = new Thread[numDistinctValuePairs];
import java.util.Map;
                for (DefaultCacheStatsHolder cacheStatsHolder : cacheStatsHolders) {
        // Remove a subset of the dimensions concurrently.
        // intermediate node for A0 should be null
            assertEquals(expectedTotal.immutableSnapshot(), current.getImmutableStats());
                            threadRand.nextInt(10),
import org.opensearch.test.OpenSearchTestCase;
        Map<String, List<String>> usedDimensionValues = new HashMap<>();
        assertEquals(1, cacheStatsHolder.getStatsRoot().getImmutableStats().getHits());
            expectedTotal.add(expected.get(dims));
        // leaf nodes for all B1 values, except (A0, B1), should not be null as they weren't removed,
        assertEquals(3, cacheStatsHolder.getStatsRoot().getImmutableStats().getHits());
        DefaultCacheStatsHolder cacheStatsHolder = new DefaultCacheStatsHolder(dimensionNames, storeName);
        Thread[] threads = new Thread[numAValues + 1];
        Map<List<String>, CacheStats> expected = new ConcurrentHashMap<>();
            List<String> values = new ArrayList<>();
            originalCounter.sizeInBytes = new CounterMetric();
        return result;
            ImmutableCacheStats actualStatsHolder = DefaultCacheStatsHolderTests.getNode(dimensionValues, cacheStatsHolder.getStatsRoot())
        }
        assertNotNull(getNode(List.of("A2"), cacheStatsHolder.getStatsRoot()));
        threads[numAValues] = new Thread(() -> { cacheStatsHolder.removeDimensions(List.of("A0", "B1")); });
            cacheStatsHolder.incrementHits(dims);
    }
                cacheStatsHolder.incrementEvictions(dims);
        }
        int numDistinctValuePairs,
        );
            List<String> dims = entry.getKey();
        // and reflect only the stats for their B1 child.
                cacheStatsHolder.incrementItems(dims);
        }
public class DefaultCacheStatsHolderTests extends OpenSearchTestCase {
        for (Thread thread : threads) {
        Map<List<String>, CacheStats> expected = populateStats(cacheStatsHolder, usedDimensionValues, 100, 10);
        List<String> dimensionNames = List.of("dim1", "dim2", "dim3", "dim4");
                        expected.get(dimensions).hits.inc(statsToInc.getHits());
    public void testDropStatsForDimensions() throws Exception {
        for (DefaultCacheStatsHolder statsHolder : cacheStatsHolders) {
                }
            usedDimensionValues.put(cacheStatsHolder.getDimensionNames().get(i), values);
        // Remove both (A0, B0), and (A0, B1), so we expect the intermediate node for A0 to be null afterwards.
        // When we invalidate the last node, all nodes should be deleted except the root node
            cacheStatsHolder.incrementHits(dims);
        if (!current.children.isEmpty()) {
    ) {
    static DefaultCacheStatsHolder.Node getNode(List<String> dimensionValues, DefaultCacheStatsHolder.Node root) {
        }
            for (int j = 0; j < numValuesPerDim; j++) {
        int numDistinctValuePairs,
import java.util.Random;
            current = current.getChildren().get(dimensionValue);
            DefaultCacheStatsHolder.Node intermediateLevelNode = getNode(List.of("A" + indexA), cacheStatsHolder.getStatsRoot());
            }
     */
     * Returns the node found by following these dimension values down from the root node.
                .getImmutableStats();
        }
 */
    static Map<List<String>, CacheStats> populateStats(
        }
import org.opensearch.common.metrics.CounterMetric;
 * SPDX-License-Identifier: Apache-2.0
        List<String> result = new ArrayList<>();
        DefaultCacheStatsHolder cacheStatsHolder,
    }
        }
        return usedDimensionValues;
            for (int indexB = 0; indexB < numBValues; indexB++) {
        DefaultCacheStatsHolder cacheStatsHolder = new DefaultCacheStatsHolder(dimensionNames, storeName);
        for (List<String> dims : populatedStats) {
        }
                    for (int j = 0; j < numRepetitionsPerValue; j++) {
    }
                List<String> dimensions = dimensionsForThreads.get(finalI);
 * this file be licensed under the Apache-2.0 license or a
            assertNotNull(intermediateLevelNode);
        List<List<String>> populatedStats = List.of(List.of("A1", "B1"), List.of("A2", "B2"), List.of("A2", "B3"));
            originalCounter.items = new CounterMetric();
        // leaf nodes for all B0 values should be null since they were removed
        for (List<String> dims : populatedStats) {
            ImmutableCacheStats actual = node.getImmutableStats();
            for (DefaultCacheStatsHolder.Node child : current.children.values()) {
        // When we invalidate A1, B1, we should lose the nodes for B1 and also A1, as it has no more children.
        long expectedCount = 0L;
    /**
            }
                        CacheStats statsToInc = new CacheStats(
            for (int i = 0; i < stats.getHits(); i++) {
    }
                assertSumOfChildrenStats(child);
                        expected.get(dimensions).items.inc(statsToInc.getItems());
            cacheStatsHolder,
import java.util.concurrent.CountDownLatch;
        cacheStatsHolder.reset();
        cacheStatsHolder.removeDimensions(List.of("A2", "B2"));
        for (int indexA = 1; indexA < numAValues; indexA++) {
        for (int indexA = 0; indexA < numAValues; indexA++) {
        }
        for (String dimName : dimensionNames) {
        }
            CacheStats originalCounter = expected.get(dimensionValues);
        assertNull(getNode(List.of("A0"), cacheStatsHolder.getStatsRoot()));
            }
            assertNotNull(b1LeafNode);
        DefaultCacheStatsHolder cacheStatsHolder = new DefaultCacheStatsHolder(dimensionNames, storeName);
        assertEquals(expectedTotal.immutableSnapshot(), cacheStatsHolder.getStatsRoot().getImmutableStats());
/*
                    }
        for (Thread thread : threads) {
            assertEquals(new ImmutableCacheStats(1, 0, 0, 0, 0), b1LeafNode.getImmutableStats());
            }
        return expected;
        for (List<String> dimensionValues : expected.keySet()) {
        Random rand
        int numBValues = 2;
    public void testReset() throws Exception {
        Map<List<String>, CacheStats> expected = populateStats(cacheStatsHolder, usedDimensionValues, 100, 10);
                cacheStatsHolder.incrementMisses(dims);
            assertEquals(expectedCounter.immutableSnapshot(), actualCacheStats);
            int finalI = i;
                populatedStats.add(List.of("A" + indexA, "B" + indexB));
            }
            for (int i = 0; i < stats.getItems(); i++) {
        int numRepetitionsPerValue
            }
        assertNull(getNode(List.of("A1", "B1"), cacheStatsHolder.getStatsRoot()));
        List<List<String>> dimensionsForThreads = new ArrayList<>();
        }
            assertNull(getNode(List.of("A" + indexA, "B0"), cacheStatsHolder.getStatsRoot()));
        assertNotNull(getNode(List.of("A2", "B3"), cacheStatsHolder.getStatsRoot()));
    ) throws InterruptedException {
        }
            threads[i] = new Thread(() -> { cacheStatsHolder.removeDimensions(List.of("A" + finalI, "B0")); });
        // Check sum of children stats are correct
                values.add(UUID.randomUUID().toString());
    }
        assertEquals(expectedCount, cacheStatsHolder.count());
    }
        DefaultCacheStatsHolder cacheStatsHolder = new DefaultCacheStatsHolder(dimensionNames, storeName);
            CacheStats expectedCounter = expected.get(dimensionValues);
                            threadRand.nextInt(5000),
 * compatible open source license.
        List<String> dimensionNames,
    }
            thread.start();
            assertEquals(originalCounter.immutableSnapshot(), actual);
        DefaultCacheStatsHolder.Node current = root;
        countDownLatch.await();
        for (Thread thread : threads) {
    }
        for (int i = 0; i < numDistinctValuePairs; i++) {
            if (current == null) {
        }
            for (int i = 0; i < stats.getEvictions(); i++) {
            assertEquals(expectedCounter.immutableSnapshot(), actualStatsHolder);
            int finalI = i;
