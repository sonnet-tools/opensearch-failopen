        assertNull(getNode(List.of("A0"), cacheStatsHolder.getStatsRoot()));
        Map<List<String>, CacheStats> expected = populateStats(cacheStatsHolder, usedDimensionValues, 100, 10);
                expected.computeIfAbsent(dimensions, (key) -> new CacheStats());
            cacheStatsHolder,
        for (List<String> dims : expected.keySet()) {  
            }
        Map<String, List<String>> usedDimensionValues = new HashMap<>();  
    static Map<List<String>, CacheStats> populateStats(  
            10
            int finalI = i;
            DefaultCacheStatsHolder.Node node = getNode(dimensionValues, cacheStatsHolder.getStatsRoot());
                    }  
        // test the value in the map is as expected for each distinct combination of values
        DefaultCacheStatsHolder cacheStatsHolder = new DefaultCacheStatsHolder(dimensionNames, storeName);
        Map<List<String>, CacheStats> expected = populateStats(cacheStatsHolder, usedDimensionValues, 100, 10);
        // intermediate node for A0 should be null
        // Create stats for the following dimension sets  
        for (Thread thread : threads) {
                cacheStatsHolder.incrementHits(dims);
        return expected;  
                    for (int j = 0; j < numRepetitionsPerValue; j++) {
        for (String dimName : dimensionNames) {
        Random rand = Randomness.get();  
            cacheStatsHolder.incrementHits(dims);
            thread.start();
            CacheStats expectedTotal = new CacheStats();
    }
        assertSumOfChildrenStats(cacheStatsHolder.getStatsRoot());  
                        expected.get(dimensions).hits.inc(statsToInc.getHits());  
        for (Thread thread : threads) {  
    ) throws InterruptedException {
        cacheStatsHolder.removeDimensions(List.of("A1", "B1"));  
        // For all the others, remove only the B0 value. Then we expect the intermediate nodes for A1 through A9 to be present  
        }
            for (DefaultCacheStatsHolder.Node child : current.children.values()) {
                            threadRand.nextInt(10),
            }
        }
        }
    }
        }
            current = current.getChildren().get(dimensionValue);
        int numDistinctValuePairs,  
        }
                        CacheStats statsToInc = new CacheStats(
        long expectedCount = 0L;
        cacheStatsHolder.removeDimensions(List.of("A2", "B2"));  
                assertSumOfChildrenStats(child);
        // and the intermediate nodes A1 through A9 shouldn't be null as they have remaining children
                            threadRand.nextInt(10),
}
            assertNull(getNode(List.of("A" + indexA, "B0"), cacheStatsHolder.getStatsRoot()));  
                            threadRand.nextInt(5000),  
            }  
        DefaultCacheStatsHolder cacheStatsHolder = new DefaultCacheStatsHolder(dimensionNames, storeName);
import org.opensearch.common.Randomness;
        assertEquals(expectedTotal.immutableSnapshot(), cacheStatsHolder.getStatsRoot().getImmutableStats());  
                cacheStatsHolder.incrementEvictions(dims);
        // Check overall total matches
        threads[numAValues] = new Thread(() -> { cacheStatsHolder.removeDimensions(List.of("A0", "B1")); });
        for (Thread thread : threads) {  
        }
            CacheStats originalCounter = expected.get(dimensionValues);  
        DefaultCacheStatsHolder cacheStatsHolder,
            });  
                int index = between(0, usedDimensionValues.get(dimName).size() - 1);
                countDownLatch.countDown();
        }
            cacheStatsHolder.incrementHits(dims);
            usedDimensionValues,
                cacheStatsHolder.incrementMisses(dims);
        // and reflect only the stats for their B1 child.
                        );
        }
                return null;  
                // so 50% of the time  
        for (int i = 0; i < cacheStatsHolder.getDimensionNames().size(); i++) {
            for (int i = 0; i < stats.getEvictions(); i++) {
        List<String> dimensionNames = List.of("dim1", "dim2", "dim3", "dim4");  
        }
        assertEquals(expectedCount, cacheStatsHolder.count());
            1000,  
            dimensionsForThreads.add(getRandomDimList(cacheStatsHolders.get(0).getDimensionNames(), usedDimensionValues, true, rand));  
        List<DefaultCacheStatsHolder> cacheStatsHolders,
            int finalI = i;
        for (List<String> dims : populatedStats) {  
        }  
        assertEquals(3, cacheStatsHolder.getStatsRoot().getImmutableStats().getHits());
    static Map<String, List<String>> getUsedDimensionValues(DefaultCacheStatsHolder cacheStatsHolder, int numValuesPerDim) {
        for (CacheStats counter : expected.values()) {
        for (int indexA = 1; indexA < numAValues; indexA++) {
            assertEquals(expectedTotal.immutableSnapshot(), current.getImmutableStats());
            expectedCount += counter.getItems();  
            DefaultCacheStatsHolder.Node b1LeafNode = getNode(List.of("A" + indexA, "B1"), cacheStatsHolder.getStatsRoot());  
        }  
 */  
        for (int i = 0; i < numDistinctValuePairs; i++) {
        Thread[] threads = new Thread[numAValues + 1];  
        Map<String, List<String>> usedDimensionValues,
        }
        DefaultCacheStatsHolder cacheStatsHolder = new DefaultCacheStatsHolder(dimensionNames, storeName);
        Map<List<String>, CacheStats> statsMap
        if (!current.children.isEmpty()) {  
            CacheStats stats = entry.getValue();
    ) {
    /**  
        List<String> dimensionNames = List.of("dim1", "dim2");
        Map<String, List<String>> usedDimensionValues,
                .getImmutableStats();  
        for (DefaultCacheStatsHolder statsHolder : cacheStatsHolders) {  
    private void assertSumOfChildrenStats(DefaultCacheStatsHolder.Node current) {
    public void testAddAndGet() throws Exception {
        assertEquals(1, cacheStatsHolder.getStatsRoot().getImmutableStats().getHits());
        CountDownLatch countDownLatch = new CountDownLatch(numDistinctValuePairs);
            thread.start();  
        Map<String, List<String>> usedDimensionValues = DefaultCacheStatsHolderTests.getUsedDimensionValues(cacheStatsHolder, 10);
            threads[i] = new Thread(() -> { cacheStatsHolder.removeDimensions(List.of("A" + finalI, "B0")); });  
                            threadRand.nextInt(10)
                List<String> dimensions = dimensionsForThreads.get(finalI);
                        expected.get(dimensions).evictions.inc(statsToInc.getEvictions());
        for (int indexA = 0; indexA < numAValues; indexA++) {
        return result;
            }
            }
            expectedTotal.add(expected.get(dims));
    }
            assertEquals(expectedCounter.immutableSnapshot(), actualCacheStats);
            assertNotNull(intermediateLevelNode);
        cacheStatsHolder.reset();  
        int numBValues = 2;  
        DefaultCacheStatsHolder.Node current = root;
    static Map<List<String>, CacheStats> populateStats(  
        // leaf nodes for all B0 values should be null since they were removed
                }
            }  
package org.opensearch.common.cache.stats;
                cacheStatsHolder.incrementItems(dims);  
        Map<String, List<String>> usedDimensionValues = getUsedDimensionValues(cacheStatsHolder, 10);  
        for (String dimensionValue : dimensionValues) {  
        for (List<String> dimensionValues : expected.keySet()) {
            for (int i = 0; i < stats.getMisses(); i++) {
            for (int indexB = 0; indexB < numBValues; indexB++) {
import java.util.HashMap;  
            usedDimensionValues.put(cacheStatsHolder.getDimensionNames().get(i), values);  
    }
        }
    public void testConcurrentRemoval() throws Exception {
import org.opensearch.test.OpenSearchTestCase;  
        List<List<String>> dimensionsForThreads = new ArrayList<>();
        assertNull(getNode(List.of("A1"), cacheStatsHolder.getStatsRoot()));
            assertEquals(b1LeafNode.getImmutableStats(), intermediateLevelNode.getImmutableStats());
import java.util.UUID;
            for (int j = 0; j < numValuesPerDim; j++) {  
            List<String> dims = entry.getKey();  
    public void testCount() throws Exception {
        Map<List<String>, CacheStats> expected = new ConcurrentHashMap<>();  
        assertNotNull(getNode(List.of("A2"), cacheStatsHolder.getStatsRoot()));
    public static void populateStatsHolderFromStatsValueMap(  
    }  
            threads[i] = new Thread(() -> {
            thread.join();
        // leaf nodes for all B1 values, except (A0, B1), should not be null as they weren't removed,  
                        expected.get(dimensions).misses.inc(statsToInc.getMisses());
        int numRepetitionsPerValue
        }  
        int numAValues = 10;
    ) {  
        assertEquals(0, cacheStatsHolder.getStatsRoot().getImmutableStats().getHits());  
                for (DefaultCacheStatsHolder cacheStatsHolder : cacheStatsHolders) {  
    public void testReset() throws Exception {  
        int numDistinctValuePairs,  
            originalCounter.items = new CounterMetric();
        }
            assertEquals(cacheStatsHolders.get(0).getDimensionNames(), statsHolder.getDimensionNames());
    ) throws InterruptedException {
    }
        }
    static DefaultCacheStatsHolder.Node getNode(List<String> dimensionValues, DefaultCacheStatsHolder.Node root) {
 * SPDX-License-Identifier: Apache-2.0
import java.util.concurrent.ConcurrentHashMap;
        DefaultCacheStatsHolder cacheStatsHolder = new DefaultCacheStatsHolder(dimensionNames, storeName);  
        }
        for (List<String> dimensionValues : expected.keySet()) {
import java.util.Map;
    public void testDropStatsForDimensions() throws Exception {
     */  
            ImmutableCacheStats actual = node.getImmutableStats();
        return populateStats(List.of(cacheStatsHolder), usedDimensionValues, numDistinctValuePairs, numRepetitionsPerValue);  
        // Check sum of children stats are correct
     * Returns the node found by following these dimension values down from the root node.
                values.add(UUID.randomUUID().toString());
        assertEquals(2, cacheStatsHolder.getStatsRoot().getImmutableStats().getHits());
        assertEquals(0, cacheStatsHolder.getStatsRoot().children.size());
        assertNull(getNode(List.of("A1", "B1"), cacheStatsHolder.getStatsRoot()));  
    }  
        }
        List<String> dimensionNames = List.of("dim1", "dim2");
                        DefaultCacheStatsHolderTests.populateStatsHolderFromStatsValueMap(cacheStatsHolder, Map.of(dimensions, statsToInc));
        boolean pickValueForAllDims,  
            assertNotNull(b1LeafNode);
public class DefaultCacheStatsHolderTests extends OpenSearchTestCase {
    }
        for (List<String> dims : populatedStats) {
import java.util.Random;  
        for (int indexA = 0; indexA < numAValues; indexA++) {
        CacheStats expectedTotal = new CacheStats();
                expectedTotal.add(child.getImmutableStats());  
 * this file be licensed under the Apache-2.0 license or a
import java.util.concurrent.CountDownLatch;  
        }
            if (current == null) {
            assertEquals(expectedCounter.immutableSnapshot(), actualStatsHolder);  
        // When we invalidate A2, B2, we should lose the node for B2, but not B3 or A2.
            originalCounter.sizeInBytes = new CounterMetric();
            for (DefaultCacheStatsHolder.Node child : current.children.values()) {  
            CacheStats expectedCounter = expected.get(dimensionValues);  
            assertEquals(originalCounter.immutableSnapshot(), actual);  
        // Remove a subset of the dimensions concurrently.
        // When we invalidate the last node, all nodes should be deleted except the root node  
import org.opensearch.common.metrics.CounterMetric;
    private final String storeName = "dummy_store";  
import java.util.ArrayList;
                            threadRand.nextInt(10),  
        assertNull(getNode(List.of("A2", "B2"), cacheStatsHolder.getStatsRoot()));  
        List<String> result = new ArrayList<>();  
        Map<String, List<String>> usedDimensionValues = getUsedDimensionValues(cacheStatsHolder, 10);
        Map<List<String>, CacheStats> expected = DefaultCacheStatsHolderTests.populateStats(  
/*  
        Thread[] threads = new Thread[numDistinctValuePairs];
        return current;  
import java.util.List;
        cacheStatsHolder.removeDimensions(List.of("A2", "B3"));
                Random threadRand = Randomness.get();  
        DefaultCacheStatsHolder cacheStatsHolder,
        List<List<String>> populatedStats = new ArrayList<>();
                populatedStats.add(List.of("A" + indexA, "B" + indexB));  
        assertNotNull(getNode(List.of("A2", "B3"), cacheStatsHolder.getStatsRoot()));
        // When we invalidate A1, B1, we should lose the nodes for B1 and also A1, as it has no more children.
    private static List<String> getRandomDimList(  
            DefaultCacheStatsHolder.Node intermediateLevelNode = getNode(List.of("A" + indexA), cacheStatsHolder.getStatsRoot());  
        for (Map.Entry<List<String>, CacheStats> entry : statsMap.entrySet()) {
    }  
                        expected.get(dimensions).items.inc(statsToInc.getItems());
        Map<String, List<String>> usedDimensionValues,
        List<List<String>> populatedStats = List.of(List.of("A1", "B1"), List.of("A2", "B2"), List.of("A2", "B3"));  
    }  
        // Remove both (A0, B0), and (A0, B1), so we expect the intermediate node for A0 to be null afterwards.
        Random rand
        }
    }
            List<String> values = new ArrayList<>();
            }
            for (int i = 0; i < stats.getHits(); i++) {
        List<String> dimensionNames = List.of("dim1", "dim2");
            assertEquals(new ImmutableCacheStats(1, 0, 0, 0, 0), b1LeafNode.getImmutableStats());
            ImmutableCacheStats actualStatsHolder = DefaultCacheStatsHolderTests.getNode(dimensionValues, cacheStatsHolder.getStatsRoot())
        int numRepetitionsPerValue
     * Returns null if no such node exists.
            cacheStatsHolder.incrementSizeInBytes(dims, stats.getSizeInBytes());
        List<String> dimensionNames,
        DefaultCacheStatsHolder cacheStatsHolder = new DefaultCacheStatsHolder(dimensionNames, storeName);  
 * The OpenSearch Contributors require contributions made to  
        return usedDimensionValues;
        // Create stats for the following dimension sets
                result.add(usedDimensionValues.get(dimName).get(index));
        List<String> dimensionNames = List.of("A", "B");  
            for (int i = 0; i < stats.getItems(); i++) {
                        expected.get(dimensions).sizeInBytes.inc(statsToInc.getSizeInBytes());  
            }  
 * compatible open source license.
            }  
        );
            ImmutableCacheStats actualCacheStats = getNode(dimensionValues, cacheStatsHolder.getStatsRoot()).getImmutableStats();
            }
        countDownLatch.await();
        for (int i = 0; i < numAValues; i++) {
    }
            if (pickValueForAllDims || rand.nextBoolean()) { // if pickValueForAllDims, always pick a value for each dimension, otherwise do
 *
