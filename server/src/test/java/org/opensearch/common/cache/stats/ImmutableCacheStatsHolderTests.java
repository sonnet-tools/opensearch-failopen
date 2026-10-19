    public void testAggregateBySomeDimensions() throws Exception {
            } else {
        XContentBuilder builder = XContentFactory.jsonBuilder();
import org.opensearch.test.OpenSearchTestCase;  
    }
        builder.startObject();
import org.opensearch.common.xcontent.XContentFactory;
            for (Map.Entry<String, BiConsumer<CacheStats, Integer>> fieldNamesEntry : fieldNamesMap.entrySet()) {  
        ImmutableCacheStatsHolder.Node current = root;
        List<List<String>> levelsList = List.of(List.of(), List.of("D"));
                ImmutableCacheStatsHolder stats = statsHolder.getImmutableCacheStatsHolder(levels.toArray(new String[0]));
    public void testGet() throws Exception {
        DefaultCacheStatsHolderTests.populateStats(statsHolder, usedDimensionValues, 100, 10);  
        List<String> dimensionNames = List.of("A", "B", "C");  
                newPath.add(entry.getKey());
        for (List<String> dims : expected.keySet()) {  
        BytesStreamInput is = new BytesStreamInput(BytesReference.toBytes(os.bytes()));
        List<String> dimensionNames = List.of("A", "B", "C");
        assertNotNull(result.get("A"));  
        List<String> dimensionNames = List.of("dim1", "dim2", "dim3");
                new CacheStats(2, 2, 2, 2, 2),
        );
            assertEquals(expectedEntry.getValue().immutableSnapshot(), getNode(dimensionValues, stats.statsRoot).getStats());  
            }  
        Map<String, String> paramMap = new HashMap<>();
        // Aggregating with all dimensions as levels should just give us the same values that were in the original map  
                            expectedCounter.add(expected.get(expectedDims));  
                new CacheStats(3, 3, 3, 3, 3),
    }
        assertEquals(expectedTotal.getHits(), stats.getTotalHits());
    }  
                return null;
        }
            }  
            String resultString = builder.toString();
            expectedTotal.add(expected.get(dims));
        XContentBuilder builder = XContentFactory.jsonBuilder();
        ImmutableCacheStatsHolder stats = statsHolder.getImmutableCacheStatsHolder(dimensionNames.toArray(new String[0]));  
import java.util.HashMap;  
        for (Map.Entry<List<String>, CacheStats> expectedEntry : expected.entrySet()) {
        if (!current.children.isEmpty()) {
        Map<String, List<String>> usedDimensionValues = DefaultCacheStatsHolderTests.getUsedDimensionValues(statsHolder, 10);
        );
        stats.toXContent(builder, params);  
        builder.startObject();
        DefaultCacheStatsHolder statsHolder = new DefaultCacheStatsHolder(dimensionNames, storeName);
        Map<String, Object> result = XContentHelper.convertToMap(MediaTypeRegistry.JSON.xContent(), resultString, true);
                int valueInXContent = (int) getValueFromNestedXContentMap(result, fullXContentKeys);  
            ImmutableCacheStats.Fields.HIT_COUNT,
        return current;  
    private void getAllLeafNodesHelper(  
        } else {
                List.of("A2", "B1", "C3"),
        List<String> levels = List.of("C", "A", "E");
        assertNotEquals(0, (int) result.get(ImmutableCacheStats.Fields.EVICTIONS));
        assertEquals(7, result.size());
        ImmutableCacheStatsHolder stats = statsHolder.getImmutableCacheStatsHolder(levels);
                fullXContentKeys.add(fieldNamesEntry.getKey());
            (counter, value) -> counter.items.inc(value)  
        ImmutableCacheStatsHolder secondStats = statsHolder.getImmutableCacheStatsHolder(levels);  
                incrementer.accept(counterFromXContent, valueInXContent);
        CacheStats expectedTotal = new CacheStats();
            assertEquals(expectedCounter.immutableSnapshot(), actualCacheStatsHolder);  
                        }
            }  
            (counter, value) -> counter.hits.inc(value),
        for (Map.Entry<List<String>, ImmutableCacheStatsHolder.Node> entry : leafNodes.entrySet()) {
        }
        assertEquals(expectedTotal.immutableSnapshot(), stats.getTotalStats());  
        assertNotEquals(0, (int) result.get(ImmutableCacheStats.Fields.ITEM_COUNT));
                // If we pass empty levels to CacheStatsHolder to aggregate by, we should only get a root node with the total stats in it  
        for (int i = 0; i < keys.size() - 1; i++) {
        Map<String, List<String>> usedDimensionValues = DefaultCacheStatsHolderTests.getUsedDimensionValues(cacheStatsHolder, 10);
    public void testAggregateByAllDimensions() throws Exception {
            for (String dimValue : expectedEntry.getKey()) {  
            (counter, value) -> counter.misses.inc(value),
        assertNotEquals(0, (int) result.get(ImmutableCacheStats.Fields.HIT_COUNT));
            statsHolder,  
        DefaultCacheStatsHolder statsHolder = new DefaultCacheStatsHolder(dimensionNames, storeName);
        String resultString = builder.toString();  
        ImmutableCacheStatsHolder stats = statsHolder.getImmutableCacheStatsHolder(dimensionNames.toArray(new String[0]));
            paramMap.put("level", String.join(",", levels));  
        assertEquals(stats.getTotalStats(), statsRoot.getStats());
            current = current.getChildren().get(dimensionValue);
        DefaultCacheStatsHolder statsHolder = new DefaultCacheStatsHolder(dimensionNames, storeName);
    }  
        }
            assertTotalStatsPresentInXContentResponse(result);
                List<String> newPath = new ArrayList<>(pathToCurrent);  
            Map.of(
        ImmutableCacheStatsHolder differentStoreNameStats = differentStoreNameStatsHolder.getImmutableCacheStatsHolder(levels);
        assertEquals(expectedTotal.getSizeInBytes(), stats.getTotalSizeInBytes());
        // assert the total stats are present
        DefaultCacheStatsHolderTests.populateStats(statsHolder, usedDimensionValues, 100, 10);
        DefaultCacheStatsHolderTests.populateStats(cacheStatsHolder, usedDimensionValues, 10, 100);  
                    assertEquals(expectedCounter.immutableSnapshot(), aggEntry.getValue().getStats());  
import org.opensearch.core.xcontent.XContentBuilder;
        Map<List<String>, ImmutableCacheStatsHolder.Node> result,
        assertNotEquals(0, (int) result.get(ImmutableCacheStats.Fields.MISS_COUNT));  
        }
import org.opensearch.common.io.stream.BytesStreamOutput;
            }  
        Map<List<String>, CacheStats> expected = DefaultCacheStatsHolderTests.populateStats(statsHolder, usedDimensionValues, 1000, 10);
        assertTotalStatsPresentInXContentResponse(result);
        Map<String, List<String>> usedDimensionValues = DefaultCacheStatsHolderTests.getUsedDimensionValues(statsHolder, 10);  
public class ImmutableCacheStatsHolderTests extends OpenSearchTestCase {
        assertEquals(stats, deserialized);
        Map<String, Object> result = XContentHelper.convertToMap(MediaTypeRegistry.JSON.xContent(), resultString, true);  
 * SPDX-License-Identifier: Apache-2.0
        Map<List<String>, CacheStats> expected = DefaultCacheStatsHolderTests.populateStats(statsHolder, usedDimensionValues, 1000, 10);  
        assertEquals(expectedTotal.getEvictions(), stats.getTotalEvictions());
        }
    }
                ImmutableCacheStatsHolder stats = statsHolder.getImmutableCacheStatsHolder(levels.toArray(new String[0]));
        DefaultCacheStatsHolder nonMatchingStatsHolder = new DefaultCacheStatsHolder(dimensionNames, storeName);  
            // Test each combination of possible levels  
    private ImmutableCacheStatsHolder.Node getNode(List<String> dimensionValues, ImmutableCacheStatsHolder.Node root) {
            for (ImmutableCacheStatsHolder.Node child : current.children.values()) {
            assertEquals(expectedCounter.immutableSnapshot(), actualImmutableCacheStatsHolder);
            }  
        ImmutableCacheStatsHolder stats = cacheStatsHolder.getImmutableCacheStatsHolder(dimensionNames.toArray(new String[0]));  
        emptyDims.writeTo(os);  
    public void testXContent() throws Exception {
            }
    }
            CacheStats expectedTotal = new CacheStats();
 * compatible open source license.
                assertEquals(0, stats.getStatsRoot().children.size());  
            // assert there are no other entries in the map besides these 6
        DefaultCacheStatsHolderTests.populateStats(List.of(statsHolder, differentStoreNameStatsHolder), usedDimensionValues, 100, 10);
        // test the value in the map is as expected for each distinct combination of values
        assertEquals(0, emptyDims.getStatsRoot().children.size());
    private void assertTotalStatsPresentInXContentResponse(Map<String, Object> result) {
        assertNotEquals(stats, differentStoreNameStats);
        return result;  
                assertEquals(statsHolder.getStatsRoot().getImmutableStats(), stats.getStatsRoot().getStats());
        ImmutableCacheStatsHolder deserialized = new ImmutableCacheStatsHolder(is);
        List<String> dimensionNames = List.of("dim1", "dim2", "dim3", "dim4");  
        Map<String, List<String>> usedDimensionValues = DefaultCacheStatsHolderTests.getUsedDimensionValues(statsHolder, 10);
    }  
        }
        List<String> dimensionNames = List.of("dim1", "dim2", "dim3", "dim4");
    }
    private ToXContent.Params getLevelParams(List<String> levels) {  
import java.util.ArrayList;
                List.of("A1", "B1", "C1"),
    }
                if ((i & (1 << nameIndex)) != 0) {  
            Object next = current.get(keys.get(i));
            (counter, value) -> counter.sizeInBytes.inc(value),
            ImmutableCacheStats.Fields.ITEM_COUNT,
    ) {
        Map<List<String>, ImmutableCacheStatsHolder.Node> leafNodes = getAllLeafNodes(stats.getStatsRoot());  
            ImmutableCacheStats.Fields.SIZE_IN_BYTES,  
                    for (List<String> expectedDims : expected.keySet()) {
        assertEquals(stats, secondStats);
                for (Map.Entry<List<String>, ImmutableCacheStatsHolder.Node> aggEntry : aggregatedLeafNodes.entrySet()) {
    public void testXContentForLevels() throws Exception {
            assertEquals(6, result.size());  
            ).getImmutableStats();  
        assertEquals(emptyDims, deserialized);
                new CacheStats(1, 1, 1, 1, 1),  
            ImmutableCacheStats.Fields.EVICTIONS,
        if (!levels.isEmpty()) {
                xContentKeys.add(entry.getKey().get(i));
 * The OpenSearch Contributors require contributions made to  
        ImmutableCacheStatsHolder nonMatchingStats = nonMatchingStatsHolder.getImmutableCacheStatsHolder(levels);
        assertEquals(storeName, (String) result.get(ImmutableCacheStatsHolder.STORE_NAME_FIELD));  
    public void testEquals() throws Exception {
        assertEquals(expectedTotal.getItems(), stats.getTotalItems());  
                Map<List<String>, ImmutableCacheStatsHolder.Node> aggregatedLeafNodes = getAllLeafNodes(stats.statsRoot);  
    private final String storeName = "dummy_store";  
        ImmutableCacheStatsHolder stats = statsHolder.getImmutableCacheStatsHolder(levels);
                dimensionValues,
import org.opensearch.core.common.io.stream.BytesStreamInput;
            current = (Map<String, Object>) next;  
            (counter, value) -> counter.evictions.inc(value),  
        assertNotEquals(stats, nonMatchingStats);  
        for (int i = 0; i < (1 << dimensionNames.size()); i++) {
                BiConsumer<CacheStats, Integer> incrementer = fieldNamesEntry.getValue();
            10
            stats.toXContent(builder, params);
                }
            usedDimensionValues,
        assertNotEquals(0, (int) result.get(ImmutableCacheStats.Fields.SIZE_IN_BYTES));  
                cacheStatsHolder.getStatsRoot()
            ToXContent.Params params = getLevelParams(levels);
        List<String> dimensionNames = List.of("dim1", "dim2", "dim3", "dim4");  
                assertSumOfChildrenStats(stats.statsRoot);
            )
        ToXContent.Params params = getLevelParams(levels);  
        stats.toXContent(builder, params);  
                return null;  
}  
        String resultString = builder.toString();
            builder.endObject();
    }  
        Map<List<String>, CacheStats> expected = DefaultCacheStatsHolderTests.populateStats(  
        ToXContent.Params params = ToXContent.EMPTY_PARAMS;  
    }
                new CacheStats(4, 4, 4, 4, 4)  
    private void assertSumOfChildrenStats(ImmutableCacheStatsHolder.Node current) {  
 *
            }
                getAllLeafNodesHelper(result, entry.getValue(), newPath);
        List<String> pathToCurrent  
    // Get a map from the list of dimension values to the corresponding leaf node.
        }
        DefaultCacheStatsHolderTests.populateStatsHolderFromStatsValueMap(
import java.util.function.BiConsumer;  
            cacheStatsHolder,
        // If the levels in the params are empty or contains only unrecognized levels, we should only see the total stats and no level
        ImmutableCacheStatsHolder stats = cacheStatsHolder.getImmutableCacheStatsHolder(null);
        DefaultCacheStatsHolder statsHolder = new DefaultCacheStatsHolder(dimensionNames, storeName);
                List.of("A1", "B1", "C2"),
        DefaultCacheStatsHolder statsHolder = new DefaultCacheStatsHolder(dimensionNames, storeName);
        // aggregation  
    }
        getAllLeafNodesHelper(result, root, new ArrayList<>());
            List<String> levels = new ArrayList<>();
        Map<String, List<String>> usedDimensionValues = DefaultCacheStatsHolderTests.getUsedDimensionValues(statsHolder, 10);  
        // If the dimension list is empty, the tree should have only the root node containing the total stats.  
            if (next == null) {  
            ImmutableCacheStats.Fields.MISS_COUNT,  
        Map<String, BiConsumer<CacheStats, Integer>> fieldNamesMap = Map.of(
package org.opensearch.common.cache.stats;
    }  
    }
            Map<String, Object> result = XContentHelper.convertToMap(MediaTypeRegistry.JSON.xContent(), resultString, true);
    public static Object getValueFromNestedXContentMap(Map<String, Object> xContentMap, List<String> keys) {
        // test gets for total (this also checks sum-of-children logic)
            assertEquals(counterFromXContent.immutableSnapshot(), expected);  
        // Tests logic of filtering levels out, logic for aggregating by those levels is already covered
            for (Map.Entry<String, ImmutableCacheStatsHolder.Node> entry : current.children.entrySet()) {
 */  
        for (List<String> dimensionValues : expected.keySet()) {  
        DefaultCacheStatsHolderTests.populateStats(nonMatchingStatsHolder, usedDimensionValues, 100, 10);  
            }
                assertSumOfChildrenStats(child);
        is = new BytesStreamInput(BytesReference.toBytes(os.bytes()));
        );
    }  
        assertNotEquals(0, stats.getStatsRoot().children.size());  
        // if we pass recognized levels in any order, alongside ignored unrecognized levels, we should see the above plus level aggregation  
        Map<String, List<String>> usedDimensionValues = DefaultCacheStatsHolderTests.getUsedDimensionValues(cacheStatsHolder, 100);
        Map<String, Object> current = xContentMap;  
import org.opensearch.core.xcontent.ToXContent;
        builder.endObject();
        // assert the store name is present
            CacheStats counterFromXContent = new CacheStats();
                xContentKeys.add(dimensionNames.get(i));
        assertEquals(0, statsRoot.children.size());
        BytesStreamOutput os = new BytesStreamOutput();
                }
            ImmutableCacheStatsHolder stats = statsHolder.getImmutableCacheStatsHolder(levels.toArray(new String[0]));  
                List.of("A1", "B2", "C1"),  
        ImmutableCacheStatsHolder stats = statsHolder.getImmutableCacheStatsHolder(levels.toArray(new String[0]));
                    }
        Map<List<String>, ImmutableCacheStatsHolder.Node> result = new HashMap<>();
        ImmutableCacheStatsHolder emptyDims = statsHolder.getImmutableCacheStatsHolder(new String[] {});
/*  
        os = new BytesStreamOutput();
                    CacheStats expectedCounter = new CacheStats();  
            ImmutableCacheStats expected = entry.getValue().getStats();
                expectedTotal.add(child.getStats());
import org.opensearch.core.xcontent.MediaTypeRegistry;  
            if (levels.size() == 0) {
        for (String dimensionValue : dimensionValues) {  
            }  
        }
 * this file be licensed under the Apache-2.0 license or a
import java.util.Map;
            for (int i = 0; i < dimensionNames.size(); i++) {  
            if (current == null) {
        deserialized = new ImmutableCacheStatsHolder(is);
            List<String> dimensionValues = new ArrayList<>();
    private Map<List<String>, ImmutableCacheStatsHolder.Node> getAllLeafNodes(ImmutableCacheStatsHolder.Node root) {  
import java.util.List;
            result.put(pathToCurrent, current);  
                        if (expectedDims.containsAll(aggEntry.getKey())) {
            builder.startObject();  
            CacheStats expectedCounter = expected.get(dimensionValues);
    public void testSerialization() throws Exception {
                    levels.add(dimensionNames.get(nameIndex));
        builder.endObject();
            for (ImmutableCacheStatsHolder.Node child : current.children.values()) {  
        assertEquals(expectedTotal.getMisses(), stats.getTotalMisses());  
        assertSumOfChildrenStats(stats.getStatsRoot());
        return new ToXContent.MapParams(paramMap);
        DefaultCacheStatsHolder cacheStatsHolder = new DefaultCacheStatsHolder(dimensionNames, storeName);
                dimensionValues.add(dimValue);
        for (List<String> levels : levelsList) {
        DefaultCacheStatsHolder cacheStatsHolder = new DefaultCacheStatsHolder(List.of(), storeName);
        DefaultCacheStatsHolder differentStoreNameStatsHolder = new DefaultCacheStatsHolder(dimensionNames, "nonMatchingStoreName");
            1000,  
        }
        String[] levels = dimensionNames.toArray(new String[0]);  
            List<String> xContentKeys = new ArrayList<>();
                List<String> fullXContentKeys = new ArrayList<>(xContentKeys);
        }
        String[] levels = dimensionNames.toArray(new String[0]);
            ImmutableCacheStats actualCacheStatsHolder = DefaultCacheStatsHolderTests.getNode(  
    public void testEmptyDimsList() throws Exception {
import org.opensearch.common.xcontent.XContentHelper;  
        stats.writeTo(os);  
        DefaultCacheStatsHolder statsHolder = new DefaultCacheStatsHolder(dimensionNames, storeName);
import org.opensearch.core.common.bytes.BytesReference;
        assertEquals(stats.getTotalStats(), emptyDims.getTotalStats());  
            assertEquals(expectedTotal.immutableSnapshot(), current.getStats());  
            }
            ImmutableCacheStats actualImmutableCacheStatsHolder = getNode(dimensionValues, stats.getStatsRoot()).getStats();
        return current.get(keys.get(keys.size() - 1));
        // also test empty dimension stats  
        }
        assertSumOfChildrenStats(stats.statsRoot);
        if (current.children.isEmpty()) {
        List<String> dimensionNames = List.of("dim1", "dim2", "dim3");  
        ImmutableCacheStatsHolder.Node current,
            for (int nameIndex = 0; nameIndex < dimensionNames.size(); nameIndex++) {
        Map<String, List<String>> usedDimensionValues = DefaultCacheStatsHolderTests.getUsedDimensionValues(statsHolder, 10);
        ImmutableCacheStatsHolder.Node statsRoot = stats.getStatsRoot();  
            XContentBuilder builder = XContentFactory.jsonBuilder();
