            // Test each combination of possible levels
        assertNotEquals(0, (int) result.get(ImmutableCacheStats.Fields.EVICTIONS));
            stats.toXContent(builder, params);
            ImmutableCacheStats.Fields.HIT_COUNT,
            CacheStats expectedTotal = new CacheStats();
                    levels.add(dimensionNames.get(nameIndex));
        DefaultCacheStatsHolderTests.populateStats(statsHolder, usedDimensionValues, 100, 10);
        emptyDims.writeTo(os);
            for (Map.Entry<String, ImmutableCacheStatsHolder.Node> entry : current.children.entrySet()) {
        ImmutableCacheStatsHolder stats = statsHolder.getImmutableCacheStatsHolder(levels.toArray(new String[0]));
import java.util.Map;
    public void testGet() throws Exception {
            ImmutableCacheStats actualImmutableCacheStatsHolder = getNode(dimensionValues, stats.getStatsRoot()).getStats();
        Map<List<String>, ImmutableCacheStatsHolder.Node> leafNodes = getAllLeafNodes(stats.getStatsRoot());
            ImmutableCacheStats.Fields.SIZE_IN_BYTES,
            paramMap.put("level", String.join(",", levels));
        if (!levels.isEmpty()) {
        Map<String, List<String>> usedDimensionValues = DefaultCacheStatsHolderTests.getUsedDimensionValues(statsHolder, 10);
        builder.startObject();
                assertEquals(0, stats.getStatsRoot().children.size());
        return current.get(keys.get(keys.size() - 1));
                List.of("A2", "B1", "C3"),
import org.opensearch.core.common.io.stream.BytesStreamInput;
        // If the levels in the params are empty or contains only unrecognized levels, we should only see the total stats and no level
            ImmutableCacheStatsHolder stats = statsHolder.getImmutableCacheStatsHolder(levels.toArray(new String[0]));
        // test gets for total (this also checks sum-of-children logic)
        for (List<String> levels : levelsList) {
        DefaultCacheStatsHolder statsHolder = new DefaultCacheStatsHolder(dimensionNames, storeName);
            }
        ImmutableCacheStatsHolder emptyDims = statsHolder.getImmutableCacheStatsHolder(new String[] {});
        builder.endObject();
            current = current.getChildren().get(dimensionValue);
            ImmutableCacheStats expected = entry.getValue().getStats();
        builder.endObject();
                List.of("A1", "B1", "C1"),
            ImmutableCacheStats.Fields.EVICTIONS,
public class ImmutableCacheStatsHolderTests extends OpenSearchTestCase {
        );
    public void testSerialization() throws Exception {
            for (int i = 0; i < dimensionNames.size(); i++) {
                return null;
        DefaultCacheStatsHolder statsHolder = new DefaultCacheStatsHolder(dimensionNames, storeName);
        ImmutableCacheStatsHolder stats = statsHolder.getImmutableCacheStatsHolder(dimensionNames.toArray(new String[0]));
                    for (List<String> expectedDims : expected.keySet()) {
                assertEquals(statsHolder.getStatsRoot().getImmutableStats(), stats.getStatsRoot().getStats());
import java.util.List;
        BytesStreamOutput os = new BytesStreamOutput();
        DefaultCacheStatsHolder statsHolder = new DefaultCacheStatsHolder(dimensionNames, storeName);
/*
import org.opensearch.core.xcontent.MediaTypeRegistry;
        assertNotEquals(0, (int) result.get(ImmutableCacheStats.Fields.MISS_COUNT));
    private void getAllLeafNodesHelper(
        }
    }
    // Get a map from the list of dimension values to the corresponding leaf node.
        // test the value in the map is as expected for each distinct combination of values
        Map<String, List<String>> usedDimensionValues = DefaultCacheStatsHolderTests.getUsedDimensionValues(cacheStatsHolder, 10);
        return current;
    }
    }
    }
                Map<List<String>, ImmutableCacheStatsHolder.Node> aggregatedLeafNodes = getAllLeafNodes(stats.statsRoot);
        Map<String, List<String>> usedDimensionValues = DefaultCacheStatsHolderTests.getUsedDimensionValues(statsHolder, 10);
            result.put(pathToCurrent, current);
            (counter, value) -> counter.items.inc(value)
            assertEquals(expectedCounter.immutableSnapshot(), actualImmutableCacheStatsHolder);
        assertEquals(7, result.size());
        Map<String, List<String>> usedDimensionValues = DefaultCacheStatsHolderTests.getUsedDimensionValues(statsHolder, 10);
            statsHolder,
import org.opensearch.core.xcontent.XContentBuilder;
        ImmutableCacheStatsHolder.Node current,
        // assert the store name is present
import java.util.HashMap;
            CacheStats counterFromXContent = new CacheStats();
            List<String> xContentKeys = new ArrayList<>();
        assertEquals(stats, deserialized);
            assertEquals(expectedEntry.getValue().immutableSnapshot(), getNode(dimensionValues, stats.statsRoot).getStats());
        return new ToXContent.MapParams(paramMap);
                new CacheStats(3, 3, 3, 3, 3),
            assertEquals(6, result.size());
    public static Object getValueFromNestedXContentMap(Map<String, Object> xContentMap, List<String> keys) {
        assertNotEquals(0, (int) result.get(ImmutableCacheStats.Fields.ITEM_COUNT));
        ImmutableCacheStatsHolder stats = statsHolder.getImmutableCacheStatsHolder(levels);
    }
        for (List<String> dims : expected.keySet()) {
                assertSumOfChildrenStats(child);
        Map<List<String>, CacheStats> expected = DefaultCacheStatsHolderTests.populateStats(statsHolder, usedDimensionValues, 1000, 10);
        ImmutableCacheStatsHolder secondStats = statsHolder.getImmutableCacheStatsHolder(levels);
        assertEquals(expectedTotal.getHits(), stats.getTotalHits());
        List<String> dimensionNames = List.of("dim1", "dim2", "dim3");
    }
            assertEquals(expectedTotal.immutableSnapshot(), current.getStats());
            }
        assertEquals(stats.getTotalStats(), statsRoot.getStats());
        for (Map.Entry<List<String>, ImmutableCacheStatsHolder.Node> entry : leafNodes.entrySet()) {
            }
        assertSumOfChildrenStats(stats.statsRoot);
        ImmutableCacheStatsHolder nonMatchingStats = nonMatchingStatsHolder.getImmutableCacheStatsHolder(levels);
 * The OpenSearch Contributors require contributions made to
                BiConsumer<CacheStats, Integer> incrementer = fieldNamesEntry.getValue();
        assertEquals(expectedTotal.getMisses(), stats.getTotalMisses());
            (counter, value) -> counter.hits.inc(value),
        BytesStreamInput is = new BytesStreamInput(BytesReference.toBytes(os.bytes()));
    public void testAggregateByAllDimensions() throws Exception {
        List<String> dimensionNames = List.of("A", "B", "C");
            ImmutableCacheStats actualCacheStatsHolder = DefaultCacheStatsHolderTests.getNode(
            if (levels.size() == 0) {
        List<String> dimensionNames = List.of("dim1", "dim2", "dim3", "dim4");
            assertEquals(expectedCounter.immutableSnapshot(), actualCacheStatsHolder);
    public void testXContentForLevels() throws Exception {
        DefaultCacheStatsHolderTests.populateStats(cacheStatsHolder, usedDimensionValues, 10, 100);
        for (List<String> dimensionValues : expected.keySet()) {
            String resultString = builder.toString();
            builder.endObject();
        assertEquals(expectedTotal.immutableSnapshot(), stats.getTotalStats());
    }
import org.opensearch.common.xcontent.XContentHelper;
        for (String dimensionValue : dimensionValues) {
    }
        assertTotalStatsPresentInXContentResponse(result);
        }
        Map<String, List<String>> usedDimensionValues = DefaultCacheStatsHolderTests.getUsedDimensionValues(cacheStatsHolder, 100);
        }
            }
            ImmutableCacheStats.Fields.MISS_COUNT,
    }
                }
    public void testEmptyDimsList() throws Exception {
        assertEquals(storeName, (String) result.get(ImmutableCacheStatsHolder.STORE_NAME_FIELD));
                dimensionValues,
        List<String> dimensionNames = List.of("dim1", "dim2", "dim3");
        getAllLeafNodesHelper(result, root, new ArrayList<>());
        List<List<String>> levelsList = List.of(List.of(), List.of("D"));
        XContentBuilder builder = XContentFactory.jsonBuilder();
        ImmutableCacheStatsHolder differentStoreNameStats = differentStoreNameStatsHolder.getImmutableCacheStatsHolder(levels);
import org.opensearch.common.xcontent.XContentFactory;
            (counter, value) -> counter.misses.inc(value),
        DefaultCacheStatsHolderTests.populateStats(statsHolder, usedDimensionValues, 100, 10);
        ToXContent.Params params = getLevelParams(levels);
        // if we pass recognized levels in any order, alongside ignored unrecognized levels, we should see the above plus level aggregation
                            expectedCounter.add(expected.get(expectedDims));
import java.util.function.BiConsumer;
        DefaultCacheStatsHolder statsHolder = new DefaultCacheStatsHolder(dimensionNames, storeName);
        DefaultCacheStatsHolder cacheStatsHolder = new DefaultCacheStatsHolder(List.of(), storeName);
        assertEquals(0, emptyDims.getStatsRoot().children.size());
package org.opensearch.common.cache.stats;
        builder.startObject();
        assertNotEquals(0, (int) result.get(ImmutableCacheStats.Fields.SIZE_IN_BYTES));
                List<String> newPath = new ArrayList<>(pathToCurrent);
        }
        Map<String, Object> current = xContentMap;
        ToXContent.Params params = ToXContent.EMPTY_PARAMS;
        return result;
        List<String> levels = List.of("C", "A", "E");
import org.opensearch.core.xcontent.ToXContent;
        DefaultCacheStatsHolderTests.populateStatsHolderFromStatsValueMap(
        DefaultCacheStatsHolder statsHolder = new DefaultCacheStatsHolder(dimensionNames, storeName);
            )
        String[] levels = dimensionNames.toArray(new String[0]);
        stats.toXContent(builder, params);
}
    public void testAggregateBySomeDimensions() throws Exception {
        List<String> pathToCurrent
        ImmutableCacheStatsHolder stats = statsHolder.getImmutableCacheStatsHolder(levels);
            for (String dimValue : expectedEntry.getKey()) {
            ToXContent.Params params = getLevelParams(levels);
        assertNotEquals(stats, nonMatchingStats);
 */
        }
            if (next == null) {
        assertNotEquals(0, (int) result.get(ImmutableCacheStats.Fields.HIT_COUNT));
        assertEquals(stats, secondStats);
    }
    private void assertSumOfChildrenStats(ImmutableCacheStatsHolder.Node current) {
import java.util.ArrayList;
            Map.of(
                newPath.add(entry.getKey());
        }
        ImmutableCacheStatsHolder deserialized = new ImmutableCacheStatsHolder(is);
    private final String storeName = "dummy_store";
            }
            for (int nameIndex = 0; nameIndex < dimensionNames.size(); nameIndex++) {
    public void testEquals() throws Exception {
            assertTotalStatsPresentInXContentResponse(result);
        Map<String, List<String>> usedDimensionValues = DefaultCacheStatsHolderTests.getUsedDimensionValues(statsHolder, 10);
        for (int i = 0; i < (1 << dimensionNames.size()); i++) {
        if (!current.children.isEmpty()) {
        List<String> dimensionNames = List.of("dim1", "dim2", "dim3", "dim4");
        ImmutableCacheStatsHolder stats = cacheStatsHolder.getImmutableCacheStatsHolder(null);
    public void testXContent() throws Exception {
import org.opensearch.test.OpenSearchTestCase;
            assertEquals(counterFromXContent.immutableSnapshot(), expected);
                        }
        } else {
        String resultString = builder.toString();
    private ImmutableCacheStatsHolder.Node getNode(List<String> dimensionValues, ImmutableCacheStatsHolder.Node root) {
            builder.startObject();
                for (Map.Entry<List<String>, ImmutableCacheStatsHolder.Node> aggEntry : aggregatedLeafNodes.entrySet()) {
                new CacheStats(4, 4, 4, 4, 4)
        // assert the total stats are present
                if ((i & (1 << nameIndex)) != 0) {
        assertNotEquals(stats, differentStoreNameStats);
        Map<String, String> paramMap = new HashMap<>();
        ImmutableCacheStatsHolder.Node statsRoot = stats.getStatsRoot();
            expectedTotal.add(expected.get(dims));
                List.of("A1", "B1", "C2"),
        );
        deserialized = new ImmutableCacheStatsHolder(is);
                List.of("A1", "B2", "C1"),
        }
    }
                ImmutableCacheStatsHolder stats = statsHolder.getImmutableCacheStatsHolder(levels.toArray(new String[0]));
        DefaultCacheStatsHolder statsHolder = new DefaultCacheStatsHolder(dimensionNames, storeName);
        Map<String, Object> result = XContentHelper.convertToMap(MediaTypeRegistry.JSON.xContent(), resultString, true);
            Object next = current.get(keys.get(i));
    private Map<List<String>, ImmutableCacheStatsHolder.Node> getAllLeafNodes(ImmutableCacheStatsHolder.Node root) {
        );
        assertEquals(expectedTotal.getSizeInBytes(), stats.getTotalSizeInBytes());
            ).getImmutableStats();
        Map<String, Object> result = XContentHelper.convertToMap(MediaTypeRegistry.JSON.xContent(), resultString, true);
        assertNotEquals(0, stats.getStatsRoot().children.size());
                cacheStatsHolder.getStatsRoot()
        is = new BytesStreamInput(BytesReference.toBytes(os.bytes()));
                xContentKeys.add(entry.getKey().get(i));
        assertEquals(expectedTotal.getEvictions(), stats.getTotalEvictions());
            Map<String, Object> result = XContentHelper.convertToMap(MediaTypeRegistry.JSON.xContent(), resultString, true);
        DefaultCacheStatsHolder nonMatchingStatsHolder = new DefaultCacheStatsHolder(dimensionNames, storeName);
        for (Map.Entry<List<String>, CacheStats> expectedEntry : expected.entrySet()) {
        }
            current = (Map<String, Object>) next;
        Map<String, List<String>> usedDimensionValues = DefaultCacheStatsHolderTests.getUsedDimensionValues(statsHolder, 10);
            10
        String resultString = builder.toString();
                new CacheStats(2, 2, 2, 2, 2),
 * compatible open source license.
        assertEquals(emptyDims, deserialized);
        assertEquals(expectedTotal.getItems(), stats.getTotalItems());
                    CacheStats expectedCounter = new CacheStats();
        ImmutableCacheStatsHolder stats = statsHolder.getImmutableCacheStatsHolder(dimensionNames.toArray(new String[0]));
            for (ImmutableCacheStatsHolder.Node child : current.children.values()) {
        for (int i = 0; i < keys.size() - 1; i++) {
        String[] levels = dimensionNames.toArray(new String[0]);
        assertEquals(0, statsRoot.children.size());
    }
        Map<List<String>, CacheStats> expected = DefaultCacheStatsHolderTests.populateStats(statsHolder, usedDimensionValues, 1000, 10);
        // Tests logic of filtering levels out, logic for aggregating by those levels is already covered
                xContentKeys.add(dimensionNames.get(i));
        }
                }
        Map<List<String>, ImmutableCacheStatsHolder.Node> result,
        // also test empty dimension stats
        Map<List<String>, ImmutableCacheStatsHolder.Node> result = new HashMap<>();
        XContentBuilder builder = XContentFactory.jsonBuilder();
        ImmutableCacheStatsHolder.Node current = root;
    private ToXContent.Params getLevelParams(List<String> levels) {
    }
        if (current.children.isEmpty()) {
            for (Map.Entry<String, BiConsumer<CacheStats, Integer>> fieldNamesEntry : fieldNamesMap.entrySet()) {
    }
                new CacheStats(1, 1, 1, 1, 1),
            }
        DefaultCacheStatsHolder differentStoreNameStatsHolder = new DefaultCacheStatsHolder(dimensionNames, "nonMatchingStoreName");
            1000,
            }
        DefaultCacheStatsHolderTests.populateStats(nonMatchingStatsHolder, usedDimensionValues, 100, 10);
        Map<String, BiConsumer<CacheStats, Integer>> fieldNamesMap = Map.of(
    ) {
                fullXContentKeys.add(fieldNamesEntry.getKey());
            CacheStats expectedCounter = expected.get(dimensionValues);
        // aggregation
        DefaultCacheStatsHolder cacheStatsHolder = new DefaultCacheStatsHolder(dimensionNames, storeName);
        // If the dimension list is empty, the tree should have only the root node containing the total stats.
 * SPDX-License-Identifier: Apache-2.0
            }
                List<String> fullXContentKeys = new ArrayList<>(xContentKeys);
                ImmutableCacheStatsHolder stats = statsHolder.getImmutableCacheStatsHolder(levels.toArray(new String[0]));
        stats.toXContent(builder, params);
        assertEquals(stats.getTotalStats(), emptyDims.getTotalStats());
        assertSumOfChildrenStats(stats.getStatsRoot());
            // assert there are no other entries in the map besides these 6
            for (ImmutableCacheStatsHolder.Node child : current.children.values()) {
        List<String> dimensionNames = List.of("A", "B", "C");
            List<String> dimensionValues = new ArrayList<>();
        CacheStats expectedTotal = new CacheStats();
                int valueInXContent = (int) getValueFromNestedXContentMap(result, fullXContentKeys);
                    assertEquals(expectedCounter.immutableSnapshot(), aggEntry.getValue().getStats());
                // If we pass empty levels to CacheStatsHolder to aggregate by, we should only get a root node with the total stats in it
            if (current == null) {
                getAllLeafNodesHelper(result, entry.getValue(), newPath);
                        if (expectedDims.containsAll(aggEntry.getKey())) {
    private void assertTotalStatsPresentInXContentResponse(Map<String, Object> result) {
            (counter, value) -> counter.evictions.inc(value),
            usedDimensionValues,
 *
            ImmutableCacheStats.Fields.ITEM_COUNT,
        List<String> dimensionNames = List.of("dim1", "dim2", "dim3", "dim4");
        // Aggregating with all dimensions as levels should just give us the same values that were in the original map
            List<String> levels = new ArrayList<>();
        stats.writeTo(os);
            }
                assertSumOfChildrenStats(stats.statsRoot);
            }
import org.opensearch.core.common.bytes.BytesReference;
            XContentBuilder builder = XContentFactory.jsonBuilder();
                incrementer.accept(counterFromXContent, valueInXContent);
        os = new BytesStreamOutput();
            (counter, value) -> counter.sizeInBytes.inc(value),
        assertNotNull(result.get("A"));
        }
 * this file be licensed under the Apache-2.0 license or a
        DefaultCacheStatsHolderTests.populateStats(List.of(statsHolder, differentStoreNameStatsHolder), usedDimensionValues, 100, 10);
            cacheStatsHolder,
                expectedTotal.add(child.getStats());
import org.opensearch.common.io.stream.BytesStreamOutput;
            } else {
        }
        Map<List<String>, CacheStats> expected = DefaultCacheStatsHolderTests.populateStats(
    }
                return null;
        ImmutableCacheStatsHolder stats = cacheStatsHolder.getImmutableCacheStatsHolder(dimensionNames.toArray(new String[0]));
                    }
                dimensionValues.add(dimValue);
