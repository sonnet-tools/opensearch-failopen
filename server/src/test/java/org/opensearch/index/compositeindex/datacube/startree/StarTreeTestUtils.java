    public static void validateFileFormats(
        Queue<InMemoryTreeNode> resultTreeNodeQueue = new ArrayDeque<>();
        });
    }
            assertEquals(expectedMetric.getField(), resultMetric.getField());
        IndexInput starTreeIndexInput = dataIn.slice(
            for (int di = 0; di < resultStarTreeDocument.dimensions.length; di++) {
            }
        assertEquals(starTreeNode.getDimensionId(), treeNode.getDimensionId());
                        assertNotNull(child);
            int numDimensions = 0;
                if (expectedStarTreeDocument.metrics[mi] instanceof Long) {
                default nodes with this dimension value. We will perform the assertNull() check only if we have not
        expectedTreeNodeQueue.add(starTreeNode);
            i++;
                return 0.0;
        assertEquals(expectedStarTreeMetadata.getMaxLeafDocs(), resultStarTreeMetadata.getMaxLeafDocs());
                        assertNotNull(starTreeNode.getChildStarNode());
                    treeNode.getChildren().values().size() + (treeNode.getChildStarNode() != null ? 1 : 0)
                        assertNotNull(resultChildNode);
            if (value == null) {
 * compatible open source license.
            );
                assertTrue(rootNode.getChildren().isEmpty());
        } else {
                        assertEquals(expectedStarTreeDocument.metrics[mi], resultStarTreeDocument.metrics[mi]);
                    } else {
                for (String name : dimension.getSubDimensionNames()) {
        for (SequentialDocValuesIterator dimensionDocValueIterator : dimensionReaders) {
import java.io.IOException;
        List<StarTreeDocument> starTreeDocuments = new ArrayList<>();
                yet found a default node with a dimension value of -1.
                    } else {
            }
                    continue;
        for (SequentialDocValuesIterator metricDocValuesIterator : metricReaders) {
                    resultTreeNodeQueue.add(resultChildNode);
            Metric resultantMetricWithoutDerivedMetrics = new Metric(resultMetric.getField(), metricStats);
import static org.junit.Assert.assertTrue;
                    expectedMetricWithoutDerivedMetrics.getMetrics().get(j),
            assertEquals(expectedStarTreeDocument.metrics.length, resultStarTreeDocument.metrics.length);
                for (MetricStat metricStat : metric.getMetrics()) {
        assertEquals(STAR_TREE, compositeFieldType);
                boolean childStarNodeAsserted = false;
                resultStarTreeMetadata.getDimensionFields().get(dimensionField).getDocValuesType()
                        // check if star tree node exists
            assertFalse(starTreeNode.isLeaf());
            if (dimensionId != -1) {
                currentDocId++;
            assertEquals(expectedStarTreeDocument.dimensions.length, resultStarTreeDocument.dimensions.length);
    }
            for (Metric metric : starTreeValues.getStarTreeField().getMetrics()) {
                    } else {
                }
        for (int i = 0; i < expectedStarTreeMetadata.getMetrics().size(); i++) {
            while (currentDocId < numDocs) {
            if (rootNode.getChildren() != null) {
            }
    }
            }
        );
                    StarTreeNode child = expectedChildrenIterator.next();
import org.apache.lucene.store.IndexInput;
 */
import static org.opensearch.index.compositeindex.CompositeIndexConstants.COMPOSITE_FIELD_MARKER;
        }
                assertTrue(resultMetric.getMetrics().contains(expectedMetric.getMetrics().get(j)));
package org.opensearch.index.compositeindex.datacube.startree;
 *
                    resultantMetricWithoutDerivedMetrics.getMetrics().get(j)
                */
                if (metricStat.isDerivedMetric()) {
                        assertNotEquals(child.getStarTreeNodeType(), StarTreeNodeType.STAR.getValue());
            StarTreeDocument expectedStarTreeDocument = expectedStarTreeDocuments[i];
import java.util.Queue;
        assertNotNull(starTreeDocuments);
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
        expectedStarTreeMetadata.getDimensionFields().forEach((dimensionField, dimensionConfig) -> {
                /*
                int childCount = 0;
                Since NULL nodes have a dimension value of -1, we need to track whether we have encountered any
                        metric.getField(),
        for (int i = 0; i < starTreeDocuments.length; i++) {
    public static StarTreeDocument getStarTreeDocument(
                        }
        );
            for (int j = 0; j < expectedMetric.getMetrics().size(); j++) {
import java.util.ArrayList;
import org.opensearch.index.compositeindex.datacube.startree.node.InMemoryTreeNode;
                    }
            for (MetricStat metricStat : expectedMetric.getMetrics()) {
            Metric resultMetric = resultStarTreeMetadata.getMetrics().get(i);
        assertTrue(resultTreeNodeQueue.isEmpty());
        );
import static org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils.fullyQualifiedFieldNameForStarTreeMetricsDocValues;
        }
            resultStarTreeMetadata.getSkipStarNodeCreationInDims().size()
            metaIn.readString()
        return new StarTreeDocument(dims, metrics);
            assertNotNull(resultStarTreeDocument.metrics);
                    starTreeNode.getNumChildren(),
                        continue;
        resultTreeNodeQueue.add(rootNode);
                            }
            assertEquals(
                boolean nodeWithMinusOneValueFound = false;
            "star-tree data slice for respective star-tree fields",
            List<InMemoryTreeNode> sortedChildren = new ArrayList<>();
            }
import static org.opensearch.index.compositeindex.datacube.startree.fileformats.StarTreeWriter.VERSION_CURRENT;
            Iterator<? extends StarTreeNode> expectedChildrenIterator = starTreeNode.getChildrenIterator();
    ) throws IOException {
        assertEquals(starTreeNode.getAggregatedDocId(), treeNode.getAggregatedDocId());
            } else {
            for (MetricStat metricStat : resultMetric.getMetrics()) {
                        assertStarTreeNode(child, resultChildNode);
                }
        if (starTreeNode.getChildDimensionId() != -1) {
                }
        InMemoryTreeNode rootNode,
                            assertNull(starTreeNode.getChildForDimensionValue(child.getDimensionValue()));
import static org.junit.Assert.assertFalse;
        List<StarTreeValues> starTreeValuesSubs,
    public static void assertStarTreeNode(StarTreeNode starTreeNode, InMemoryTreeNode treeNode) throws IOException {
import java.util.List;
        assertEquals(starTreeNode.getDimensionValue(), treeNode.getDimensionValue());
                    if (resultStarTreeDocument.metrics[mi] instanceof CompensatedSum) {
import org.opensearch.index.compositeindex.datacube.startree.fileformats.meta.StarTreeMetadata;
        assertEquals(starTreeNode.getChildDimensionId(), treeNode.getChildDimensionId());
import java.util.Iterator;
            return fieldValueConverter.toDoubleValue(value);
            );
import org.opensearch.index.compositeindex.datacube.Metric;
            List<MetricStat> metricStats = new ArrayList<>();
                }
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeFactory;
        List<FieldValueConverter> fieldValueConverters
                    String metricFullName = fullyQualifiedFieldNameForStarTreeMetricsDocValues(
    }
                    if (metricStat.isDerivedMetric()) {
                        } else {
            dims[i] = val;
            }
        for (StarTreeValues starTreeValues : starTreeValuesSubs) {
        }
            Metric expectedMetricWithoutDerivedMetrics = new Metric(expectedMetric.getField(), metricStats);
        int numDocs
                );
                    metricReaders.add(new SequentialDocValuesIterator(starTreeValues.getMetricValuesIterator(metricFullName)));
        int currentDocId,
            int dimensionId = starTreeNode.getChildDimensionId();
import static org.junit.Assert.assertNotNull;
        StarTreeNode starTreeNode = StarTreeFactory.createStarTree(starTreeIndexInput, resultStarTreeMetadata);
                        resultChildNode = sortedChildren.get(childCount);
            List<Dimension> dimensionsSplitOrder = starTreeValues.getStarTreeField().getDimensionsOrder();
/*
        assertEquals(expectedStarTreeMetadata.getDataStartFilePointer(), resultStarTreeMetadata.getDataStartFilePointer());
        assertTrue(expectedTreeNodeQueue.isEmpty());
        assertStarTreeMetadata(expectedStarTreeMetadata, resultStarTreeMetadata);
            assertNotNull(resultStarTreeDocument.dimensions);
            List<Dimension> dimensionsOrder = starTreeField.getDimensionsOrder();
        StarTreeField starTreeField
            SequentialDocValuesIterator[] dimensionReaders = new SequentialDocValuesIterator[numDimensions];
                        resultChildNode = rootNode.getChildStarNode();
            assertTrue(starTreeNode.isLeaf());
        assertEquals(expectedStarTreeMetadata.getSegmentAggregatedDocCount(), resultStarTreeMetadata.getSegmentAggregatedDocCount());
import java.util.ArrayDeque;
        assertEquals(VERSION_CURRENT, version);
                    }
                } else {
                        assertStarTreeNode(child, resultChildNode);
            for (int mi = 0; mi < resultStarTreeDocument.metrics.length; mi++) {
            }
import org.opensearch.index.compositeindex.datacube.MetricStat;
        long magicMarker = metaIn.readLong();
public class StarTreeTestUtils {
    public static Double toAggregatorValueType(Long value, FieldValueConverter fieldValueConverter) {
            }
        assertEquals(starTreeNode.getEndDocId(), treeNode.getEndDocId());
            // assert base metrics are in order in metadata
import static org.junit.Assert.assertNull;
    public static void assertStarTreeMetadata(StarTreeMetadata expectedStarTreeMetadata, StarTreeMetadata resultStarTreeMetadata) {
        }
                        metricStat.getTypeName()
                    }
                );
                    dimIndex++;
        IndexInput dataIn,
            Metric expectedMetric = expectedStarTreeMetadata.getMetrics().get(i);
                assertEquals(
            }
 * SPDX-License-Identifier: Apache-2.0
                            assertNotNull(starTreeNode.getChildForDimensionValue(child.getDimensionValue()));
        String compositeFieldName = metaIn.readString();
                metricStats.add(metricStat);
    }
        }
            Long val = dimensionDocValueIterator.value(currentDocId);
    public static void assertStarTreeDocuments(StarTreeDocument[] starTreeDocuments, StarTreeDocument[] expectedStarTreeDocuments) {
                dimensionConfig.getDimensionDataType(),
        Long[] dims = new Long[dimensionReaders.length];
                    expectedTreeNodeQueue.add(child);
        Object[] metrics = new Object[metricReaders.size()];
            }
                resultStarTreeMetadata.getDimensionFields().get(dimensionField).getDimensionDataType()
        StarTreeDocument[] starTreeDocumentsArr = new StarTreeDocument[starTreeDocuments.size()];
            expectedStarTreeMetadata.getSkipStarNodeCreationInDims().size(),
                } else if (resultStarTreeDocument.metrics[mi] instanceof CompensatedSum) {
        return starTreeDocuments.toArray(starTreeDocumentsArr);
            // assert all metrics ( including derived metrics are present )
        }
                        assertNotNull(child);
        assertEquals(expectedStarTreeMetadata.getDimensionFields().size(), resultStarTreeMetadata.getDimensionFields().size());
        while ((starTreeNode = expectedTreeNodeQueue.poll()) != null && (rootNode = resultTreeNodeQueue.poll()) != null) {
            int dimIndex = 0;
            dimensionDocValueIterator.nextEntry(currentDocId);
                metricStats.add(metricStat);
import static org.junit.Assert.assertNotEquals;
import org.opensearch.search.aggregations.metrics.CompensatedSum;
import org.opensearch.index.mapper.CompositeMappedFieldType;
        StarTreeMetadata resultStarTreeMetadata = new StarTreeMetadata(metaIn, compositeFieldName, compositeFieldType, version);
                assertEquals(expectedStarTreeDocument.dimensions[di], resultStarTreeDocument.dimensions[di]);
                    continue;
        assertEquals(expectedStarTreeMetadata.getStarTreeFieldName(), compositeFieldName);
            StarTreeDocument resultStarTreeDocument = starTreeDocuments[i];
            resultStarTreeMetadata.getDataStartFilePointer(),
            i++;
                        childCount++;
        assertEquals(expectedStarTreeMetadata.getStarTreeBuildMode(), resultStarTreeMetadata.getStarTreeBuildMode());
 * this file be licensed under the Apache-2.0 license or a
                while (expectedChildrenIterator.hasNext()) {
        }
        assertEquals(COMPOSITE_FIELD_MARKER, magicMarker);
            metrics[i] = toAggregatorValueType(metricDocValuesIterator.value(currentDocId), fieldValueConverters.get(i));
            assertStarTreeNode(starTreeNode, rootNode);
            throw new IllegalStateException("Cannot convert " + value + " to sortable aggregation type", e);
                } else if (expectedStarTreeDocument.metrics[mi] instanceof CompensatedSum) {
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeNode;
                        assertEquals(((CompensatedSum) expectedStarTreeDocument.metrics[mi]).value(), resultStarTreeDocument.metrics[mi]);
            }
        }
            // verify the star node
import org.opensearch.index.compositeindex.datacube.Dimension;
                        starTreeValues.getStarTreeField().getName(),
                dimensionConfig.getDocValuesType(),
        assertEquals(expectedStarTreeMetadata.getDataLength(), resultStarTreeMetadata.getDataLength());
            metricStats = new ArrayList<>();
                        assertEquals(expectedStarTreeDocument.metrics[mi], resultStarTreeDocument.metrics[mi]);
                        if (child.getStarTreeNodeType() == StarTreeNodeType.NULL.getValue() && !nodeWithMinusOneValueFound) {
    ) throws IOException {
        assertEquals(expectedStarTreeMetadata.getCompositeFieldName(), resultStarTreeMetadata.getCompositeFieldName());
                            if (child.getDimensionValue() == -1L) {
                    if (!childStarNodeAsserted && rootNode.getChildStarNode() != null) {
        assertEquals(starTreeDocuments.length, expectedStarTreeDocuments.length);
                assertFalse(sortedChildren.isEmpty());
            for (int i = 0; i < dimensionsSplitOrder.size(); i++) {
        List<SequentialDocValuesIterator> metricReaders,
        List<FieldValueConverter> fieldValueConverters,
                assertEquals(
        for (String skipDimension : expectedStarTreeMetadata.getSkipStarNodeCreationInDims()) {
                    if (expectedStarTreeDocument.metrics[mi] instanceof CompensatedSum) {
            for (Dimension dimension : dimensionsSplitOrder) {
            List<SequentialDocValuesIterator> metricReaders = new ArrayList<>();
                        childStarNodeAsserted = true;
                    }
                numDimensions += dimension.getNumSubDimensions();
        int i = 0;
        try {
        assertEquals(expectedStarTreeMetadata.getMetrics().size(), resultStarTreeMetadata.getMetrics().size());
 * The OpenSearch Contributors require contributions made to
            metricDocValuesIterator.nextEntry(currentDocId);
            assertEquals(
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeNodeType;
                        assertEquals((expectedStarTreeDocument.metrics[mi]), ((CompensatedSum) resultStarTreeDocument.metrics[mi]).value());
    public static StarTreeDocument[] getSegmentsStarTreeDocuments(
        i = 0;
            // get doc id set iterators for metrics
                sortedChildren = new ArrayList<>(rootNode.getChildren().values());
        Queue<StarTreeNode> expectedTreeNodeQueue = new ArrayDeque<>();
        int version = metaIn.readVInt();
        assertEquals(
import org.opensearch.index.mapper.FieldValueConverter;
import org.opensearch.index.compositeindex.datacube.startree.utils.SequentialDocValuesIterator;
        assertEquals(expectedStarTreeMetadata.getStarTreeDocCount(), resultStarTreeMetadata.getStarTreeDocCount());
                if (metricStat.isDerivedMetric()) {
        }
            for (int j = 0; j < expectedMetricWithoutDerivedMetrics.getMetrics().size(); j++) {
    ) throws IOException {
            resultStarTreeMetadata.getDataLength()
            if (treeNode.getChildren() != null) {
        assertEquals(starTreeNode.getStartDocId(), treeNode.getStartDocId());
                }
        CompositeMappedFieldType.CompositeFieldType compositeFieldType = CompositeMappedFieldType.CompositeFieldType.fromName(
                    dimensionReaders[dimIndex] = new SequentialDocValuesIterator(starTreeValues.getDimensionValuesIterator(name));
                    );
                    InMemoryTreeNode resultChildNode = null;
}
                    assertEquals(((Long) expectedStarTreeDocument.metrics[mi]).doubleValue(), resultStarTreeDocument.metrics[mi]);
        IndexInput metaIn,
                }
        StarTreeMetadata expectedStarTreeMetadata,
                starTreeDocuments.add(getStarTreeDocument(currentDocId, dimensionReaders, metricReaders, fieldValueConverters));
        SequentialDocValuesIterator[] dimensionReaders,
                    assertEquals(expectedStarTreeDocument.metrics[mi], resultStarTreeDocument.metrics[mi]);
        assertEquals(0, (resultStarTreeMetadata.getDataLength()) % 33);
        } catch (Exception e) {
            assertTrue(resultStarTreeMetadata.getSkipStarNodeCreationInDims().contains(skipDimension));
            }
    }
    }
            int currentDocId = 0;
            }
                                nodeWithMinusOneValueFound = true;
                Dimension dimension = dimensionsSplitOrder.get(i);
import static org.opensearch.index.mapper.CompositeMappedFieldType.CompositeFieldType.STAR_TREE;
        assertEquals(expectedStarTreeMetadata.getCompositeFieldType(), resultStarTreeMetadata.getCompositeFieldType());
                assertEquals(childCount, rootNode.getChildren().size());
import static org.junit.Assert.assertEquals;
            }
