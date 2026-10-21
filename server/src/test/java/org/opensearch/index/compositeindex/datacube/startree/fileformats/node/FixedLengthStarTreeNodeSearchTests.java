                                assertEquals(0, collector.collectedNodeCount());
        long[] dimensionValues,
                    InMemoryTreeNode starChild = new InMemoryTreeNode(
        boolean createNullNode,
                                Long lowValue = treeSet.ceiling(low);
                            // Match contains interval which has nothing
        long[] randomSorted = random().longs(100, Long.MIN_VALUE, Long.MAX_VALUE).toArray();
                        throw new RuntimeException(e);
                            // Match leftmost
                            // Low > High
                            throw new RuntimeException(e);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.mapper.NumberFieldMapper;
    // private static class ArrayBasedCollector implements StarTreeNodeCollector {
                        return result;
                                assertEquals(0, collector.collectedNodeCount());
    //
                        // When dimension value is null
                        dataIn,
                            // Match contains interval which has nothing
                        lastMatchedNode = (FixedLengthStarTreeNode) fixedLengthStarTreeNode.getChildForDimensionValue(
                        result &= 1 == fixedLengthStarTreeNode.getChildForDimensionValue(1L).getDimensionValue();
            }
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeFactory;
            mock(SearchContext.class)
                    0,
                    "star-tree"
import static org.mockito.Mockito.when;
    //
                        randomInt(),
                                }
    // }
                            ArrayBasedCollector collector = new ArrayBasedCollector();
                }));
                            // No match on left
                            result &= collector.matchAllCollectedValues(new long[] { -10 });
        );
import org.opensearch.test.OpenSearchTestCase;
import org.apache.lucene.store.IndexInput;
                                assertEquals(key, node.getDimensionValue());
 * SPDX-License-Identifier: Apache-2.0
                }
                        lastMatchedNode = (FixedLengthStarTreeNode) fixedLengthStarTreeNode.getChildForDimensionValue(
                    } catch (IOException e) {
                    for (int i = 1; i <= 100; i++) {
    // nodes.add(node);
import java.util.function.Predicate;
package org.opensearch.index.compositeindex.datacube.startree.fileformats.node;
    // public int collectedNodeCount() {
                            collector = new ArrayBasedCollector();
                            fixedLengthStarTreeNode.collectChildrenInRange(-30, -20, collector, dimensionFilterMapper);
    // }
                            collector = new ArrayBasedCollector();
                            throw new RuntimeException(e);
                            fixedLengthStarTreeNode.collectChildrenInRange(50, 10, collector, dimensionFilterMapper);
                        FixedLengthStarTreeNode lastMatchedNode;
                                    }
 * The OpenSearch Contributors require contributions made to
                            long match = Arrays.binarySearch(randomSorted, key);
            for (boolean createNullNode : new boolean[] { true, false }) {
    ) {
        Arrays.sort(randomSorted);
 *
                        try {
                                            )
                                                Arrays.binarySearch(randomSorted, highValue)
    }
    public void testRangeMatch() {
}
                        result &= null == fixedLengthStarTreeNode.getChildForDimensionValue(null);
            long starTreeDataLength;
                        result &= null == fixedLengthStarTreeNode.getChildForDimensionValue(4L);
            }
                            result &= collector.matchAllCollectedValues(new long[] { 9 });
                );
    // return matches;
                        } catch (IOException e) {
                createStarTreeForDimension(
            new NumberFieldMapper.NumberFieldType("fieldName", NumberFieldMapper.NumberType.LONG),
                            fixedLengthStarTreeNode.collectChildrenInRange(10, 25, collector, dimensionFilterMapper);
                }));
import java.util.List;
                    rootNode,
                            // No match on right
                    assertTrue(predicate.test(effectiveRoot));
                StarTreeWriter starTreeWriter = new StarTreeWriter();
                        boolean result = true;
                    }
                        (byte) -1,
                        result &= null == fixedLengthStarTreeNode.getChildForDimensionValue(randomLongBetween(0, Long.MAX_VALUE));
                                    Long highValue = treeSet.floor(high);
    // }
                                collector.matchAllCollectedValues(new long[] { low });
                        result &= -1 == lastMatchedNode.getDimensionValue();
                        } catch (IOException e) {
                                    assertEquals(0, collector.collectedNodeCount());
                    }
        long[] randomSorted = random().longs(100, Long.MIN_VALUE, Long.MAX_VALUE).toArray();
                    }
                    starNodeLengthContribution + rootNode.getChildren().size() + 1,
                    List.of(fixedLengthStarTreeNode -> {
                        randomInt(),
    // @Override
import org.opensearch.index.compositeindex.datacube.startree.fileformats.StarTreeWriter;
                        return result;
    // public boolean matchAllCollectedValues(long[] values) throws IOException {
                        randomInt(),
                                                Arrays.binarySearch(randomSorted, lowValue),
    //
                    rootNode.addChildNode(starChild, (long) ALL);
                createStarTreeForDimension(new long[] { 1 }, createStarNode, createNullNode, List.of(fixedLengthStarTreeNode -> {
                            collector = new ArrayBasedCollector();
                    try {
            }
                                        );
                            ArrayBasedCollector collector;
        DimensionFilterMapper dimensionFilterMapper = DimensionFilterMapper.Factory.fromMappedFieldType(
                }
    // }
                        lastMatchedNode = (FixedLengthStarTreeNode) fixedLengthStarTreeNode.getChildForDimensionValue(-1L);
            for (Predicate<FixedLengthStarTreeNode> predicate : predicates) {
                            ArrayBasedCollector collector = new ArrayBasedCollector();
                            collector = new ArrayBasedCollector();
                        result &= null == lastMatchedNode.getChildForDimensionValue(5L, lastMatchedNode, dimensionFilterMapper);
                            result &= collector.matchAllCollectedValues(new long[] { -10, -1, 1, 2, 5, 9, 25 });
                            collector = new ArrayBasedCollector();
                    boolean result = true;
                    return result;
        List<Predicate<FixedLengthStarTreeNode>> predicates
                    randomInt(),
        for (boolean createStarNode : new boolean[] { true, false }) {
                        try {
import static org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils.ALL;
                        result &= null == fixedLengthStarTreeNode.getChildForDimensionValue(randomLongBetween(2, Long.MAX_VALUE));
                            result &= collector.matchAllCollectedValues(new long[] { -1, 1 });
                    for (int i = 1; i <= 100; i++) {
                                if (lowValue != null) {
                            throw new RuntimeException(e);
                rootNode.setAggregatedDocId(randomInt());
 */
                    })
                        );
                    } catch (IOException e) {
                        result &= null == fixedLengthStarTreeNode.getChildForDimensionValue(null, null, dimensionFilterMapper);
                            fixedLengthStarTreeNode.collectChildrenInRange(10, 24, collector, dimensionFilterMapper);
                    return result;
import org.apache.lucene.store.IndexOutput;
                    new long[] { -10, -1, 1, 2, 5, 9, 25 },
 * SPDX-License-Identifier: Apache-2.0
                    }
 *
                            dimensionFilterMapper
                            FixedLengthStarTreeNode node = (FixedLengthStarTreeNode) fixedLengthStarTreeNode.getChildForDimensionValue(key);
                        result &= null == fixedLengthStarTreeNode.getChildForDimensionValue(randomLongBetween(Long.MIN_VALUE, -2));
                    FixedLengthStarTreeNode effectiveRoot = (FixedLengthStarTreeNode) StarTreeFactory.createStarTree(
    // public void collectStarTreeNode(StarTreeNode node) {
                    starChild.setChildDimensionId(-1);
                            result &= collector.matchAllCollectedValues(new long[] { 9, 25 });
    // }
            }
                        result &= null == lastMatchedNode;
/*
                        result &= null == fixedLengthStarTreeNode.getChildForDimensionValue(randomLongBetween(Long.MIN_VALUE, 0));
                            } else if (low == high) {
import java.util.Arrays;
                    randomFrom((byte) 0, (byte) -1, (byte) 1),
                    try {
                        }
                        rootNode.getDimensionId() + 1,
            try (IndexOutput dataOut = directory.createOutput("star-tree-data", IOContext.DEFAULT)) {
                    defaultNode.setAggregatedDocId(randomInt());
                        result &= null == fixedLengthStarTreeNode.getChildForDimensionValue(randomLongBetween(Long.MIN_VALUE, 0));
                createStarTreeForDimension(new long[] { -1, 1, 2, 5 }, createStarNode, createNullNode, List.of(fixedLengthStarTreeNode -> {
import org.apache.lucene.store.IOContext;
import org.opensearch.search.startree.filter.provider.DimensionFilterMapper;
                        return result;
                        // non-existing dimensionValue
                                        collector.matchAllCollectedValues(new long[] { lowValue });
                        randomInt(),
                    }
                    starNodeLengthContribution++;
                    createStarNode,
                        result &= null == lastMatchedNode.getChildForDimensionValue(5L);
                            5L,
                                        collector.matchAllCollectedValues(
                            fixedLengthStarTreeNode.collectChildrenInRange(-30, -10, collector, dimensionFilterMapper);
    // boolean matches = true;
    //
                            fixedLengthStarTreeNode.collectChildrenInRange(-20, 26, collector, dimensionFilterMapper);
                if (createNullNode) {
                    rootNode.addChildNode(nullNode, null);
import org.opensearch.search.internal.SearchContext;
                            long low = randomLong(), high = randomLong();
        DimensionFilterMapper dimensionFilterMapper = DimensionFilterMapper.Factory.fromMappedFieldType(
    private void createStarTreeForDimension(
            throw new RuntimeException(e);
                                    } else {
                        (byte) 0,
import java.util.TreeSet;
                createStarTreeForDimension(randomSorted, createStarNode, createNullNode, List.of(fixedLengthStarTreeNode -> {
 * this file be licensed under the Apache-2.0 license or a
                    InMemoryTreeNode nullNode = new InMemoryTreeNode(rootNode.getDimensionId() + 1, randomInt(), randomInt(), (byte) 1, -1);
                }));
                            dimensionFilterMapper
                        dimensionValue
                            // Whole range
                        }
                        );
                    );
                        // Asserting Last Matched Node works as expected
    // return nodes.size();
                rootNode.setChildDimensionId(1);
                // asserting on the actual length of the star tree data file
            mock(SearchContext.class)
                            // Match rightmost
                    nullNode.setChildDimensionId(-1);
                if (createStarNode && dimensionValues.length > 1) {
                    nullNode.setAggregatedDocId(randomInt());
                            long key = randomLong();
                assertEquals(starTreeDataLength, (33L * rootNode.getChildren().size()) + (starNodeLengthContribution * 33L) + 33L);
        }
                                            Arrays.copyOfRange(
                }
                int starNodeLengthContribution = 0;
                            fixedLengthStarTreeNode.collectChildrenInRange(6, 100, collector, dimensionFilterMapper);
                            result &= collector.collectedNodeCount() == 0;
                            fixedLengthStarTreeNode.collectChildrenInRange(30, 50, collector, dimensionFilterMapper);
import org.opensearch.index.compositeindex.datacube.startree.node.InMemoryTreeNode;
        }
                        rootNode.getDimensionId() + 1,
                    InMemoryTreeNode defaultNode = new InMemoryTreeNode(
                        } catch (IOException e) {
                );
                            collector = new ArrayBasedCollector();
                            }
                            fixedLengthStarTreeNode.collectChildrenInRange(low, high, collector, dimensionFilterMapper);
                createStarTreeForDimension(randomSorted, createStarNode, createNullNode, List.of(fixedLengthStarTreeNode -> {
                            result &= collector.matchAllCollectedValues(new long[] { 25 });
                    when(starTreeMetadata.getDataStartFilePointer()).thenReturn(0L);
                            }
                            } else {
                        throw new RuntimeException(e);
        } catch (IOException e) {
                        }
                            lastMatchedNode,
                    when(starTreeMetadata.getDataLength()).thenReturn(starTreeDataLength);
    // for (int i = 0; i < values.length; i++) {
import org.opensearch.search.aggregations.startree.ArrayBasedCollector;
                                } else {
        for (boolean createStarNode : new boolean[] { true, false }) {
                            collector = new ArrayBasedCollector();
                            collector = new ArrayBasedCollector();
                            fixedLengthStarTreeNode.collectChildrenInRange(6, 24, collector, dimensionFilterMapper);
public class FixedLengthStarTreeNodeSearchTests extends OpenSearchTestCase {
                        // Asserting null is returned when last matched node is after the value to search.
    }
import java.util.stream.Collectors;
                    TreeSet<Long> treeSet = Arrays.stream(randomSorted).boxed().collect(Collectors.toCollection(TreeSet::new));
                            if (low < high) {
    // matches &= nodes.get(i).getDimensionValue() == values[i];
                            if (match >= 0) {
                        lastMatchedNode = (FixedLengthStarTreeNode) fixedLengthStarTreeNode.getChildForDimensionValue(
                        -1
                        try {
        boolean createStarNode,
                        // Leaf Node should return null
                            collector = new ArrayBasedCollector();
                            lastMatchedNode,
                    StarTreeMetadata starTreeMetadata = mock(StarTreeMetadata.class);
                                        assertEquals(0, collector.collectedNodeCount());
                                    } else if (lowValue <= high) {
 * The OpenSearch Contributors require contributions made to
                        result &= 1 == lastMatchedNode.getDimensionValue();
                        starTreeMetadata
                            // Subset matched from left
                                                randomSorted,
                            dimensionFilterMapper
                    rootNode.addChildNode(defaultNode, dimensionValue);
import java.io.IOException;
                            return result;
            for (boolean createNullNode : new boolean[] { true, false }) {
 * compatible open source license.
                        result &= null == fixedLengthStarTreeNode.getChildForDimensionValue(randomLongBetween(6, Long.MAX_VALUE));
        );
            new NumberFieldMapper.NumberFieldType("fieldName", NumberFieldMapper.NumberType.LONG),
                            // Subset matched from right
import static org.mockito.Mockito.mock;
        try (Directory directory = newFSDirectory(createTempDir())) {
                createStarTreeForDimension(new long[] {}, createStarNode, createNullNode, List.of(fixedLengthStarTreeNode -> {
                        result &= null == fixedLengthStarTreeNode.getChildForDimensionValue(2L);
                        );
    // private final List<StarTreeNode> nodes = new ArrayList<>();
                            result &= collector.collectedNodeCount() == 0;
                }
        Arrays.sort(randomSorted);
                InMemoryTreeNode rootNode = new InMemoryTreeNode(
                            boolean result = true;
        }
                try (IndexInput dataIn = directory.openInput("star-tree-data", IOContext.READONCE)) {
                            result &= collector.collectedNodeCount() == 0;
                    boolean result = true;
import org.apache.lucene.store.Directory;
                        result &= 5 == lastMatchedNode.getDimensionValue();
                    try {
                            collector = new ArrayBasedCollector();
                            } else {
                }));
                    );
                    defaultNode.setChildDimensionId(-1);
                        boolean result = true;
                    starChild.setAggregatedDocId(randomInt());
                }));
                            fixedLengthStarTreeNode.collectChildrenInRange(-2, 1, collector, dimensionFilterMapper);
                        result &= null == fixedLengthStarTreeNode.getChildForDimensionValue(1L);
                                    if (highValue != null && highValue >= lowValue) {
                    } catch (IOException e) {
                starTreeDataLength = starTreeWriter.writeStarTree(
                            1L,
                    createNullNode,
                    );
import org.opensearch.index.compositeindex.datacube.startree.fileformats.meta.StarTreeMetadata;
                        boolean result = true;
                            lastMatchedNode,
    }
                    -1
                            result &= collector.collectedNodeCount() == 0;
/*
    //
 * compatible open source license.
                    dataOut,
                for (long dimensionValue : dimensionValues) {
 */
                        throw new RuntimeException(e);
    public void testExactMatch() {
                );
                            2L,
                                assertNotNull(node);
                    randomInt(),
