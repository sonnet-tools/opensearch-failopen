                            fixedLengthStarTreeNode.collectChildrenInRange(30, 50, collector, dimensionFilterMapper);  
                        result &= 5 == lastMatchedNode.getDimensionValue();  
                            fixedLengthStarTreeNode.collectChildrenInRange(-2, 1, collector, dimensionFilterMapper);  
                            fixedLengthStarTreeNode.collectChildrenInRange(6, 100, collector, dimensionFilterMapper);
                            // Low > High
                            } else if (low == high) {
import org.opensearch.index.compositeindex.datacube.startree.node.InMemoryTreeNode;  
                            // Whole range  
    }
    // public int collectedNodeCount() {  
                    rootNode.addChildNode(nullNode, null);
                        result &= null == lastMatchedNode;
                    randomInt(),
                        result &= null == fixedLengthStarTreeNode.getChildForDimensionValue(4L);  
                            if (match >= 0) {  
                        throw new RuntimeException(e);
                    starNodeLengthContribution + rootNode.getChildren().size() + 1,
                    randomInt(),
                        rootNode.getDimensionId() + 1,
                    createNullNode,
import org.opensearch.test.OpenSearchTestCase;  
                        } catch (IOException e) {
                                if (lowValue != null) {
                            collector = new ArrayBasedCollector();
                // asserting on the actual length of the star tree data file
                createStarTreeForDimension(randomSorted, createStarNode, createNullNode, List.of(fixedLengthStarTreeNode -> {
                    createStarNode,  
 * The OpenSearch Contributors require contributions made to
                    randomFrom((byte) 0, (byte) -1, (byte) 1),  
import org.opensearch.search.aggregations.startree.ArrayBasedCollector;  
                            lastMatchedNode,
                    );
                    rootNode,  
import java.util.TreeSet;
                for (long dimensionValue : dimensionValues) {
                            boolean result = true;
                    );
                        try {
                    new long[] { -10, -1, 1, 2, 5, 9, 25 },
                    return result;
        );  
                        );  
 *
        try (Directory directory = newFSDirectory(createTempDir())) {  
    // private final List<StarTreeNode> nodes = new ArrayList<>();  
                                        );
                            2L,  
                    return result;
                    nullNode.setChildDimensionId(-1);
                    dataOut,
                        // Asserting null is returned when last matched node is after the value to search.
 */  
                }));  
        for (boolean createStarNode : new boolean[] { true, false }) {
                    rootNode.addChildNode(starChild, (long) ALL);
import java.util.List;
                            result &= collector.matchAllCollectedValues(new long[] { 9, 25 });
                createStarTreeForDimension(randomSorted, createStarNode, createNullNode, List.of(fixedLengthStarTreeNode -> {
                            }
        long[] randomSorted = random().longs(100, Long.MIN_VALUE, Long.MAX_VALUE).toArray();
                        lastMatchedNode = (FixedLengthStarTreeNode) fixedLengthStarTreeNode.getChildForDimensionValue(-1L);
                            collector = new ArrayBasedCollector();
    // return nodes.size();
                        randomInt(),
                        lastMatchedNode = (FixedLengthStarTreeNode) fixedLengthStarTreeNode.getChildForDimensionValue(
                            fixedLengthStarTreeNode.collectChildrenInRange(-30, -20, collector, dimensionFilterMapper);
                }
import java.util.stream.Collectors;
            for (Predicate<FixedLengthStarTreeNode> predicate : predicates) {  
                    defaultNode.setChildDimensionId(-1);
    //
                    try {  
                                    assertEquals(0, collector.collectedNodeCount());  
                        } catch (IOException e) {
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeFactory;
    //
            new NumberFieldMapper.NumberFieldType("fieldName", NumberFieldMapper.NumberType.LONG),
            try (IndexOutput dataOut = directory.createOutput("star-tree-data", IOContext.DEFAULT)) {
        Arrays.sort(randomSorted);  
                            dimensionFilterMapper
 *  
                InMemoryTreeNode rootNode = new InMemoryTreeNode(
                            collector = new ArrayBasedCollector();  
            throw new RuntimeException(e);
                            fixedLengthStarTreeNode.collectChildrenInRange(6, 24, collector, dimensionFilterMapper);
                            long key = randomLong();  
                                }
 * The OpenSearch Contributors require contributions made to  
                            collector = new ArrayBasedCollector();  
                        return result;  
                    when(starTreeMetadata.getDataStartFilePointer()).thenReturn(0L);
                            FixedLengthStarTreeNode node = (FixedLengthStarTreeNode) fixedLengthStarTreeNode.getChildForDimensionValue(key);
                    }  
    // public boolean matchAllCollectedValues(long[] values) throws IOException {
    // boolean matches = true;
                                assertEquals(key, node.getDimensionValue());
                            result &= collector.collectedNodeCount() == 0;
                int starNodeLengthContribution = 0;  
                            } else {
                    }  
                            collector = new ArrayBasedCollector();  
        Arrays.sort(randomSorted);
        List<Predicate<FixedLengthStarTreeNode>> predicates  
    }
                            lastMatchedNode,  
                );  
                    starChild.setChildDimensionId(-1);
                                    } else {
import org.opensearch.search.startree.filter.provider.DimensionFilterMapper;
                            result &= collector.collectedNodeCount() == 0;  
                try (IndexInput dataIn = directory.openInput("star-tree-data", IOContext.READONCE)) {
                            result &= collector.collectedNodeCount() == 0;
                if (createNullNode) {  
            }  
                    })
                        );
                createStarTreeForDimension(
                            throw new RuntimeException(e);  
    // }
                    } catch (IOException e) {
    // return matches;  
            new NumberFieldMapper.NumberFieldType("fieldName", NumberFieldMapper.NumberType.LONG),
                            if (low < high) {  
                            long low = randomLong(), high = randomLong();
    // }
                                    if (highValue != null && highValue >= lowValue) {
                    InMemoryTreeNode nullNode = new InMemoryTreeNode(rootNode.getDimensionId() + 1, randomInt(), randomInt(), (byte) 1, -1);
                    try {
                        // Asserting Last Matched Node works as expected  
import org.opensearch.index.mapper.NumberFieldMapper;
                            result &= collector.matchAllCollectedValues(new long[] { 25 });
                starTreeDataLength = starTreeWriter.writeStarTree(
                            collector = new ArrayBasedCollector();
                        result &= 1 == fixedLengthStarTreeNode.getChildForDimensionValue(1L).getDimensionValue();
                        // Leaf Node should return null  
                                    Long highValue = treeSet.floor(high);  
                        randomInt(),  
                            // Match contains interval which has nothing  
                        result &= null == fixedLengthStarTreeNode.getChildForDimensionValue(randomLongBetween(2, Long.MAX_VALUE));
                            fixedLengthStarTreeNode.collectChildrenInRange(-30, -10, collector, dimensionFilterMapper);
                createStarTreeForDimension(new long[] { 1 }, createStarNode, createNullNode, List.of(fixedLengthStarTreeNode -> {
                            1L,
import org.apache.lucene.store.IndexOutput;  
                                        collector.matchAllCollectedValues(new long[] { lowValue });
                            fixedLengthStarTreeNode.collectChildrenInRange(low, high, collector, dimensionFilterMapper);
                            result &= collector.matchAllCollectedValues(new long[] { -10, -1, 1, 2, 5, 9, 25 });  
        for (boolean createStarNode : new boolean[] { true, false }) {
                        } catch (IOException e) {  
            }
                        result &= null == fixedLengthStarTreeNode.getChildForDimensionValue(1L);
    public void testRangeMatch() {
        long[] randomSorted = random().longs(100, Long.MIN_VALUE, Long.MAX_VALUE).toArray();
                                                Arrays.binarySearch(randomSorted, highValue)  
                    }
    // }
                    try {  
    //
                        result &= null == fixedLengthStarTreeNode.getChildForDimensionValue(randomLongBetween(0, Long.MAX_VALUE));  
    public void testExactMatch() {  
                    InMemoryTreeNode defaultNode = new InMemoryTreeNode(  
                }  
                        result &= null == fixedLengthStarTreeNode.getChildForDimensionValue(null);  
                        result &= null == fixedLengthStarTreeNode.getChildForDimensionValue(2L);  
        } catch (IOException e) {
                if (createStarNode && dimensionValues.length > 1) {  
                    boolean result = true;
                                                Arrays.binarySearch(randomSorted, lowValue),
 * this file be licensed under the Apache-2.0 license or a
                    }
                    for (int i = 1; i <= 100; i++) {  
                                assertEquals(0, collector.collectedNodeCount());
    // public void collectStarTreeNode(StarTreeNode node) {  
            for (boolean createNullNode : new boolean[] { true, false }) {
                    for (int i = 1; i <= 100; i++) {
                            // Match contains interval which has nothing
                            // Subset matched from right
                        rootNode.getDimensionId() + 1,
                            result &= collector.matchAllCollectedValues(new long[] { -10 });  
                assertEquals(starTreeDataLength, (33L * rootNode.getChildren().size()) + (starNodeLengthContribution * 33L) + 33L);  
                    } catch (IOException e) {  
        DimensionFilterMapper dimensionFilterMapper = DimensionFilterMapper.Factory.fromMappedFieldType(
import static org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils.ALL;  
                }));
                            collector = new ArrayBasedCollector();
                        result &= null == fixedLengthStarTreeNode.getChildForDimensionValue(randomLongBetween(Long.MIN_VALUE, 0));
                    starNodeLengthContribution++;
import org.apache.lucene.store.Directory;  
                        );
        long[] dimensionValues,  
                    defaultNode.setAggregatedDocId(randomInt());
                        try {  
                        return result;  
                        result &= null == lastMatchedNode.getChildForDimensionValue(5L);
import java.util.function.Predicate;  
                        result &= 1 == lastMatchedNode.getDimensionValue();  
                            fixedLengthStarTreeNode.collectChildrenInRange(-20, 26, collector, dimensionFilterMapper);
                        result &= null == fixedLengthStarTreeNode.getChildForDimensionValue(null, null, dimensionFilterMapper);
                            throw new RuntimeException(e);
    // }
                        randomInt(),
    // nodes.add(node);
                                                randomSorted,
                    boolean result = true;
                        // When dimension value is null
                                        collector.matchAllCollectedValues(
                                            Arrays.copyOfRange(  
            }
                            return result;
import org.apache.lucene.store.IndexInput;
                            }  
                }));  
                        result &= null == fixedLengthStarTreeNode.getChildForDimensionValue(randomLongBetween(6, Long.MAX_VALUE));
                            result &= collector.matchAllCollectedValues(new long[] { 9 });  
                                    }
                }
                    when(starTreeMetadata.getDataLength()).thenReturn(starTreeDataLength);  
        }
        }
                );
 * compatible open source license.
                    );  
    //  
                        throw new RuntimeException(e);
import static org.mockito.Mockito.mock;
                }
                        // non-existing dimensionValue
                        FixedLengthStarTreeNode lastMatchedNode;  
                        }  
    ) {
                        result &= null == fixedLengthStarTreeNode.getChildForDimensionValue(randomLongBetween(Long.MIN_VALUE, -2));
                            lastMatchedNode,  
 * SPDX-License-Identifier: Apache-2.0
                    assertTrue(predicate.test(effectiveRoot));  
                    FixedLengthStarTreeNode effectiveRoot = (FixedLengthStarTreeNode) StarTreeFactory.createStarTree(
import org.apache.lucene.store.IOContext;
 * compatible open source license.  
                            // Subset matched from left
                        dataIn,  
import static org.mockito.Mockito.when;
                        boolean result = true;
                            dimensionFilterMapper
                }));
                            // Match rightmost
                createStarTreeForDimension(new long[] { -1, 1, 2, 5 }, createStarNode, createNullNode, List.of(fixedLengthStarTreeNode -> {  
                rootNode.setChildDimensionId(1);  
                            result &= collector.matchAllCollectedValues(new long[] { -1, 1 });
import org.opensearch.index.compositeindex.datacube.startree.fileformats.StarTreeWriter;
                StarTreeWriter starTreeWriter = new StarTreeWriter();
/*  
                    List.of(fixedLengthStarTreeNode -> {
    // for (int i = 0; i < values.length; i++) {  
                            long match = Arrays.binarySearch(randomSorted, key);
 * this file be licensed under the Apache-2.0 license or a
                            fixedLengthStarTreeNode.collectChildrenInRange(10, 24, collector, dimensionFilterMapper);
                        boolean result = true;
                                            )
                        -1  
        boolean createNullNode,
}  
                                Long lowValue = treeSet.ceiling(low);
                    nullNode.setAggregatedDocId(randomInt());  
                        result &= -1 == lastMatchedNode.getDimensionValue();
import java.util.Arrays;  
            mock(SearchContext.class)  
                            ArrayBasedCollector collector;
                        }
                        (byte) -1,
                                } else {
                            dimensionFilterMapper
                        result &= null == lastMatchedNode.getChildForDimensionValue(5L, lastMatchedNode, dimensionFilterMapper);
                        throw new RuntimeException(e);
                rootNode.setAggregatedDocId(randomInt());
    // matches &= nodes.get(i).getDimensionValue() == values[i];
                        result &= null == fixedLengthStarTreeNode.getChildForDimensionValue(randomLongBetween(Long.MIN_VALUE, 0));
                );  
import org.opensearch.index.compositeindex.datacube.startree.fileformats.meta.StarTreeMetadata;
                                        assertEquals(0, collector.collectedNodeCount());  
                            } else {  
import org.opensearch.search.internal.SearchContext;
    private void createStarTreeForDimension(
import java.io.IOException;
                        return result;
    //  
                            collector = new ArrayBasedCollector();
                    -1
    // private static class ArrayBasedCollector implements StarTreeNodeCollector {
        }  
                    InMemoryTreeNode starChild = new InMemoryTreeNode(
        );
                                collector.matchAllCollectedValues(new long[] { low });  
public class FixedLengthStarTreeNodeSearchTests extends OpenSearchTestCase {
                            result &= collector.collectedNodeCount() == 0;
                createStarTreeForDimension(new long[] {}, createStarNode, createNullNode, List.of(fixedLengthStarTreeNode -> {
                        try {
                            // No match on right
                        dimensionValue
                            ArrayBasedCollector collector = new ArrayBasedCollector();
                                    } else if (lowValue <= high) {  
                            collector = new ArrayBasedCollector();
                            fixedLengthStarTreeNode.collectChildrenInRange(10, 25, collector, dimensionFilterMapper);  
package org.opensearch.index.compositeindex.datacube.startree.fileformats.node;
                    rootNode.addChildNode(defaultNode, dimensionValue);  
                    }  
/*
 * SPDX-License-Identifier: Apache-2.0
                        lastMatchedNode = (FixedLengthStarTreeNode) fixedLengthStarTreeNode.getChildForDimensionValue(
                    StarTreeMetadata starTreeMetadata = mock(StarTreeMetadata.class);
                        lastMatchedNode = (FixedLengthStarTreeNode) fixedLengthStarTreeNode.getChildForDimensionValue(
                            // No match on left  
                            collector = new ArrayBasedCollector();
                            // Match leftmost  
                            ArrayBasedCollector collector = new ArrayBasedCollector();  
                        (byte) 0,
                            5L,
    // }
                        randomInt(),  
                    TreeSet<Long> treeSet = Arrays.stream(randomSorted).boxed().collect(Collectors.toCollection(TreeSet::new));  
                        boolean result = true;
        boolean createStarNode,
                                assertEquals(0, collector.collectedNodeCount());
            }
            long starTreeDataLength;
            for (boolean createNullNode : new boolean[] { true, false }) {  
                    0,  
    }  
        DimensionFilterMapper dimensionFilterMapper = DimensionFilterMapper.Factory.fromMappedFieldType(  
            mock(SearchContext.class)
                        starTreeMetadata
 */
    // @Override
                            throw new RuntimeException(e);
                                assertNotNull(node);
                    } catch (IOException e) {
                    starChild.setAggregatedDocId(randomInt());  
                }));
                            fixedLengthStarTreeNode.collectChildrenInRange(50, 10, collector, dimensionFilterMapper);
                        }
                    "star-tree"
