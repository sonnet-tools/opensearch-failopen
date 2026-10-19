        for (SequentialDocValuesIterator metricDocValuesIterator : metricReaders) {  
                    } else {  
        List<StarTreeValues> starTreeValuesSubs,
        SequentialDocValuesIterator[] dimensionReaders,  
        assertEquals(expectedStarTreeMetadata.getMaxLeafDocs(), resultStarTreeMetadata.getMaxLeafDocs());
    public static void assertStarTreeNode(StarTreeNode starTreeNode, InMemoryTreeNode treeNode) throws IOException {
            assertNotNull(resultStarTreeDocument.dimensions);
                    InMemoryTreeNode resultChildNode = null;  
            assertEquals(  
        assertEquals(expectedStarTreeMetadata.getDataStartFilePointer(), resultStarTreeMetadata.getDataStartFilePointer());
    public static void validateFileFormats(
            resultStarTreeMetadata.getSkipStarNodeCreationInDims().size()
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;
        StarTreeDocument[] starTreeDocumentsArr = new StarTreeDocument[starTreeDocuments.size()];  
            assertFalse(starTreeNode.isLeaf());
                    );
                    starTreeNode.getNumChildren(),
        }  
        i = 0;
        for (int i = 0; i < expectedStarTreeMetadata.getMetrics().size(); i++) {
            } else {  
                    }
    }
import org.opensearch.index.compositeindex.datacube.MetricStat;
            if (treeNode.getChildren() != null) {
                        assertStarTreeNode(child, resultChildNode);  
                        if (child.getStarTreeNodeType() == StarTreeNodeType.NULL.getValue() && !nodeWithMinusOneValueFound) {  
                    dimIndex++;
        }
            metricStats = new ArrayList<>();
import org.opensearch.index.mapper.CompositeMappedFieldType;  
                        assertEquals((expectedStarTreeDocument.metrics[mi]), ((CompensatedSum) resultStarTreeDocument.metrics[mi]).value());
                boolean childStarNodeAsserted = false;  
                starTreeDocuments.add(getStarTreeDocument(currentDocId, dimensionReaders, metricReaders, fieldValueConverters));
            }
        try {  
            Metric resultMetric = resultStarTreeMetadata.getMetrics().get(i);
            resultStarTreeMetadata.getDataLength()
            for (int mi = 0; mi < resultStarTreeDocument.metrics.length; mi++) {  
            }
import java.util.List;
        for (int i = 0; i < starTreeDocuments.length; i++) {  
        assertNotNull(starTreeDocuments);  
    ) throws IOException {
            throw new IllegalStateException("Cannot convert " + value + " to sortable aggregation type", e);  
                resultStarTreeMetadata.getDimensionFields().get(dimensionField).getDimensionDataType()  
                if (expectedStarTreeDocument.metrics[mi] instanceof Long) {
                            assertNotNull(starTreeNode.getChildForDimensionValue(child.getDimensionValue()));  
                );  
            for (int j = 0; j < expectedMetric.getMetrics().size(); j++) {
        } else {
import java.util.ArrayDeque;
            }
                        assertNotNull(resultChildNode);
        assertEquals(expectedStarTreeMetadata.getStarTreeDocCount(), resultStarTreeMetadata.getStarTreeDocCount());  
                        assertEquals(((CompensatedSum) expectedStarTreeDocument.metrics[mi]).value(), resultStarTreeDocument.metrics[mi]);
        }  
                boolean nodeWithMinusOneValueFound = false;
            assertEquals(
                    if (expectedStarTreeDocument.metrics[mi] instanceof CompensatedSum) {
        assertEquals(starTreeNode.getDimensionId(), treeNode.getDimensionId());
                    continue;  
        Queue<StarTreeNode> expectedTreeNodeQueue = new ArrayDeque<>();
 * The OpenSearch Contributors require contributions made to  
                        } else {
    public static void assertStarTreeMetadata(StarTreeMetadata expectedStarTreeMetadata, StarTreeMetadata resultStarTreeMetadata) {
                if (metricStat.isDerivedMetric()) {
            if (dimensionId != -1) {  
            if (value == null) {
        expectedStarTreeMetadata.getDimensionFields().forEach((dimensionField, dimensionConfig) -> {
                assertEquals(childCount, rootNode.getChildren().size());
 * compatible open source license.
                Since NULL nodes have a dimension value of -1, we need to track whether we have encountered any  
        );
                }  
                return 0.0;
                default nodes with this dimension value. We will perform the assertNull() check only if we have not
            Metric expectedMetric = expectedStarTreeMetadata.getMetrics().get(i);  
        assertEquals(starTreeDocuments.length, expectedStarTreeDocuments.length);
            for (int i = 0; i < dimensionsSplitOrder.size(); i++) {  
    public static StarTreeDocument[] getSegmentsStarTreeDocuments(  
            StarTreeDocument expectedStarTreeDocument = expectedStarTreeDocuments[i];  
import org.opensearch.index.compositeindex.datacube.startree.utils.SequentialDocValuesIterator;
                        assertNotEquals(child.getStarTreeNodeType(), StarTreeNodeType.STAR.getValue());  
        });
                } else if (expectedStarTreeDocument.metrics[mi] instanceof CompensatedSum) {  
        assertEquals(expectedStarTreeMetadata.getDataLength(), resultStarTreeMetadata.getDataLength());
        List<FieldValueConverter> fieldValueConverters
import org.apache.lucene.store.IndexInput;
                currentDocId++;  
        assertTrue(resultTreeNodeQueue.isEmpty());  
    }  
import static org.opensearch.index.compositeindex.datacube.startree.fileformats.StarTreeWriter.VERSION_CURRENT;  
import static org.junit.Assert.assertNotNull;  
import static org.junit.Assert.assertNotEquals;
            List<MetricStat> metricStats = new ArrayList<>();  
                }
            for (MetricStat metricStat : expectedMetric.getMetrics()) {
            }  
        resultTreeNodeQueue.add(rootNode);  
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;  
import static org.opensearch.index.mapper.CompositeMappedFieldType.CompositeFieldType.STAR_TREE;
        assertEquals(starTreeNode.getDimensionValue(), treeNode.getDimensionValue());  
    }
            dimensionDocValueIterator.nextEntry(currentDocId);
/*  
            SequentialDocValuesIterator[] dimensionReaders = new SequentialDocValuesIterator[numDimensions];  
                    }
                resultStarTreeMetadata.getDimensionFields().get(dimensionField).getDocValuesType()
                        assertNotNull(child);
                for (MetricStat metricStat : metric.getMetrics()) {
            // assert base metrics are in order in metadata
        }
                metricStats.add(metricStat);
                assertFalse(sortedChildren.isEmpty());
import java.util.Queue;  
            for (Metric metric : starTreeValues.getStarTreeField().getMetrics()) {
            List<Dimension> dimensionsSplitOrder = starTreeValues.getStarTreeField().getDimensionsOrder();
                assertTrue(resultMetric.getMetrics().contains(expectedMetric.getMetrics().get(j)));  
    public static void assertStarTreeDocuments(StarTreeDocument[] starTreeDocuments, StarTreeDocument[] expectedStarTreeDocuments) {
        for (StarTreeValues starTreeValues : starTreeValuesSubs) {  
                        continue;
        Object[] metrics = new Object[metricReaders.size()];
            int currentDocId = 0;  
public class StarTreeTestUtils {
                    }
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeNodeType;
    }
import static org.junit.Assert.assertFalse;
import java.util.ArrayList;  
            }
                    metricReaders.add(new SequentialDocValuesIterator(starTreeValues.getMetricValuesIterator(metricFullName)));
        if (starTreeNode.getChildDimensionId() != -1) {  
 */  
            );
        int numDocs  
            int dimIndex = 0;
                    expectedTreeNodeQueue.add(child);
        );
            }
            List<InMemoryTreeNode> sortedChildren = new ArrayList<>();  
    ) throws IOException {  
                sortedChildren = new ArrayList<>(rootNode.getChildren().values());
    }  
            metaIn.readString()
        }  
            metrics[i] = toAggregatorValueType(metricDocValuesIterator.value(currentDocId), fieldValueConverters.get(i));
        while ((starTreeNode = expectedTreeNodeQueue.poll()) != null && (rootNode = resultTreeNodeQueue.poll()) != null) {
}  
                        assertStarTreeNode(child, resultChildNode);
        long magicMarker = metaIn.readLong();
                        metric.getField(),
                    }
                    if (resultStarTreeDocument.metrics[mi] instanceof CompensatedSum) {
            }  
        }
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeFactory;
                int childCount = 0;
        Long[] dims = new Long[dimensionReaders.length];
        IndexInput starTreeIndexInput = dataIn.slice(
                                nodeWithMinusOneValueFound = true;
        assertEquals(expectedStarTreeMetadata.getStarTreeFieldName(), compositeFieldName);
        assertEquals(expectedStarTreeMetadata.getDimensionFields().size(), resultStarTreeMetadata.getDimensionFields().size());
        }
                );
                } else if (resultStarTreeDocument.metrics[mi] instanceof CompensatedSum) {  
import java.io.IOException;
            dims[i] = val;
                    if (metricStat.isDerivedMetric()) {  
                    dimensionReaders[dimIndex] = new SequentialDocValuesIterator(starTreeValues.getDimensionValuesIterator(name));  
                        starTreeValues.getStarTreeField().getName(),
                /*
                    String metricFullName = fullyQualifiedFieldNameForStarTreeMetricsDocValues(  
    public static StarTreeDocument getStarTreeDocument(
        StarTreeMetadata expectedStarTreeMetadata,
                        }
                        // check if star tree node exists
        assertEquals(0, (resultStarTreeMetadata.getDataLength()) % 33);  
        CompositeMappedFieldType.CompositeFieldType compositeFieldType = CompositeMappedFieldType.CompositeFieldType.fromName(  
    public static Double toAggregatorValueType(Long value, FieldValueConverter fieldValueConverter) {
                    if (!childStarNodeAsserted && rootNode.getChildStarNode() != null) {
                assertEquals(expectedStarTreeDocument.dimensions[di], resultStarTreeDocument.dimensions[di]);  
                yet found a default node with a dimension value of -1.
                        childStarNodeAsserted = true;
                    expectedMetricWithoutDerivedMetrics.getMetrics().get(j),
        return starTreeDocuments.toArray(starTreeDocumentsArr);
        assertEquals(VERSION_CURRENT, version);
        IndexInput dataIn,
            }
                            assertNull(starTreeNode.getChildForDimensionValue(child.getDimensionValue()));
            assertEquals(expectedStarTreeDocument.dimensions.length, resultStarTreeDocument.dimensions.length);
                assertEquals(  
                    } else {  
import org.opensearch.index.mapper.FieldValueConverter;
        assertEquals(starTreeNode.getAggregatedDocId(), treeNode.getAggregatedDocId());
        expectedTreeNodeQueue.add(starTreeNode);
                }
            }  
            resultStarTreeMetadata.getDataStartFilePointer(),  
import org.opensearch.index.compositeindex.datacube.Metric;  
        List<FieldValueConverter> fieldValueConverters,
import java.util.Iterator;
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeNode;  
            while (currentDocId < numDocs) {
            }
                        assertEquals(expectedStarTreeDocument.metrics[mi], resultStarTreeDocument.metrics[mi]);
        assertEquals(starTreeNode.getStartDocId(), treeNode.getStartDocId());
                numDimensions += dimension.getNumSubDimensions();
        assertEquals(expectedStarTreeMetadata.getCompositeFieldType(), resultStarTreeMetadata.getCompositeFieldType());
                        assertNotNull(child);
import static org.opensearch.index.compositeindex.CompositeIndexConstants.COMPOSITE_FIELD_MARKER;
        assertEquals(expectedStarTreeMetadata.getCompositeFieldName(), resultStarTreeMetadata.getCompositeFieldName());
            assertTrue(resultStarTreeMetadata.getSkipStarNodeCreationInDims().contains(skipDimension));
            for (Dimension dimension : dimensionsSplitOrder) {  
                if (metricStat.isDerivedMetric()) {
            metricDocValuesIterator.nextEntry(currentDocId);
        Queue<InMemoryTreeNode> resultTreeNodeQueue = new ArrayDeque<>();  
            }  
import static org.junit.Assert.assertEquals;  
import org.opensearch.index.compositeindex.datacube.Dimension;
            // assert all metrics ( including derived metrics are present )
            assertStarTreeNode(starTreeNode, rootNode);
            }  
            return fieldValueConverter.toDoubleValue(value);
            StarTreeDocument resultStarTreeDocument = starTreeDocuments[i];
        assertEquals(expectedStarTreeMetadata.getMetrics().size(), resultStarTreeMetadata.getMetrics().size());
            for (MetricStat metricStat : resultMetric.getMetrics()) {  
        String compositeFieldName = metaIn.readString();
                        childCount++;
        assertEquals(starTreeNode.getEndDocId(), treeNode.getEndDocId());
                for (String name : dimension.getSubDimensionNames()) {
package org.opensearch.index.compositeindex.datacube.startree;
        } catch (Exception e) {
                while (expectedChildrenIterator.hasNext()) {
            expectedStarTreeMetadata.getSkipStarNodeCreationInDims().size(),  
    }
        InMemoryTreeNode rootNode,
    ) throws IOException {
                metricStats.add(metricStat);
            int dimensionId = starTreeNode.getChildDimensionId();
            assertEquals(expectedMetric.getField(), resultMetric.getField());
import org.opensearch.index.compositeindex.datacube.startree.node.InMemoryTreeNode;
            assertEquals(expectedStarTreeDocument.metrics.length, resultStarTreeDocument.metrics.length);  
            // verify the star node
                    StarTreeNode child = expectedChildrenIterator.next();
                }
            if (rootNode.getChildren() != null) {
            for (int di = 0; di < resultStarTreeDocument.dimensions.length; di++) {
            "star-tree data slice for respective star-tree fields",
            );  
                */  
        int currentDocId,
            int numDimensions = 0;
        assertEquals(STAR_TREE, compositeFieldType);  
            for (int j = 0; j < expectedMetricWithoutDerivedMetrics.getMetrics().size(); j++) {  
        List<StarTreeDocument> starTreeDocuments = new ArrayList<>();
            i++;
        IndexInput metaIn,  
                        resultChildNode = sortedChildren.get(childCount);  
 * this file be licensed under the Apache-2.0 license or a
                assertTrue(rootNode.getChildren().isEmpty());
        for (String skipDimension : expectedStarTreeMetadata.getSkipStarNodeCreationInDims()) {  
                dimensionConfig.getDimensionDataType(),
                    assertEquals(((Long) expectedStarTreeDocument.metrics[mi]).doubleValue(), resultStarTreeDocument.metrics[mi]);
                        assertEquals(expectedStarTreeDocument.metrics[mi], resultStarTreeDocument.metrics[mi]);
        assertEquals(expectedStarTreeMetadata.getSegmentAggregatedDocCount(), resultStarTreeMetadata.getSegmentAggregatedDocCount());
        StarTreeMetadata resultStarTreeMetadata = new StarTreeMetadata(metaIn, compositeFieldName, compositeFieldType, version);
        assertEquals(COMPOSITE_FIELD_MARKER, magicMarker);  
                        assertNotNull(starTreeNode.getChildStarNode());
                }
            Metric expectedMetricWithoutDerivedMetrics = new Metric(expectedMetric.getField(), metricStats);
                    treeNode.getChildren().values().size() + (treeNode.getChildStarNode() != null ? 1 : 0)
            Iterator<? extends StarTreeNode> expectedChildrenIterator = starTreeNode.getChildrenIterator();
        );
            Long val = dimensionDocValueIterator.value(currentDocId);  
                    } else {
        StarTreeField starTreeField  
import static org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils.fullyQualifiedFieldNameForStarTreeMetricsDocValues;
                dimensionConfig.getDocValuesType(),
                    continue;
            }
                            if (child.getDimensionValue() == -1L) {  
        for (SequentialDocValuesIterator dimensionDocValueIterator : dimensionReaders) {
        StarTreeNode starTreeNode = StarTreeFactory.createStarTree(starTreeIndexInput, resultStarTreeMetadata);
        }
        assertEquals(expectedStarTreeMetadata.getStarTreeBuildMode(), resultStarTreeMetadata.getStarTreeBuildMode());  
            List<Dimension> dimensionsOrder = starTreeField.getDimensionsOrder();
                } else {  
        assertTrue(expectedTreeNodeQueue.isEmpty());
        assertStarTreeMetadata(expectedStarTreeMetadata, resultStarTreeMetadata);
        assertEquals(
            List<SequentialDocValuesIterator> metricReaders = new ArrayList<>();
import org.opensearch.index.compositeindex.datacube.startree.fileformats.meta.StarTreeMetadata;
            Metric resultantMetricWithoutDerivedMetrics = new Metric(resultMetric.getField(), metricStats);  
        int version = metaIn.readVInt();
        }
                Dimension dimension = dimensionsSplitOrder.get(i);
            assertNotNull(resultStarTreeDocument.metrics);  
            assertTrue(starTreeNode.isLeaf());  
        List<SequentialDocValuesIterator> metricReaders,
        int i = 0;
                    assertEquals(expectedStarTreeDocument.metrics[mi], resultStarTreeDocument.metrics[mi]);
                assertEquals(
            // get doc id set iterators for metrics  
                            }
                    resultantMetricWithoutDerivedMetrics.getMetrics().get(j)  
 * SPDX-License-Identifier: Apache-2.0
            }
        assertEquals(starTreeNode.getChildDimensionId(), treeNode.getChildDimensionId());  
import org.opensearch.search.aggregations.metrics.CompensatedSum;
                    resultTreeNodeQueue.add(resultChildNode);
            i++;  
                        metricStat.getTypeName()  
        return new StarTreeDocument(dims, metrics);
 *
                }  
                        resultChildNode = rootNode.getChildStarNode();  
    }
