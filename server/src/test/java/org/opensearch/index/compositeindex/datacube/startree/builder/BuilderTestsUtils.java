    }
            }
                nonStarNodeCumulativeMetrics[i] = 0.0f;
                        StarTreeDocument doc = starTreeDocuments.get(i);
            starTreeField,
                        for (int i = child.getStartDocId(); i < child.getEndDocId(); i++) {
        StarTreeValues starTreeValues = new StarTreeValues(expectedStarTreeMetadata, dataIn, compositeDocValuesProducer, readState);
                            } else if (metric instanceof Float) {
                        metricStat.getTypeName()
                    }
            writeState,
    public static SortedSetDocValues getSortedSetMock(List<Long> dimList, List<Integer> docsWithField, int valueCount) {
            }
                        // Validate dimension values in documents
import static org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils.fullyQualifiedFieldNameForStarTreeDimensionsDocValues;
                            int j = 0;
                    docCount++;
            @Override
            }
                assertTrue(node.getDimensionId() >= 0 && node.getDimensionId() < totalDimensions);
    ) throws IOException {
            public int nextDoc() {
            writeState.segmentInfo.getId(),
                    -1,
        DocValuesProducer compositeDocValuesProducer = LuceneDocValuesProducerFactory.getDocValuesProducerForCompositeCodec(
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeNodeType;
        InMemoryTreeNode root,
        for (int i = 0; i < nonStarNodeCumulativeMetrics.length; i++) {
import org.apache.lucene.index.SortedSetDocValues;
    ) {
import java.util.Queue;
 * compatible open source license.
        return nonStarNodeCumulativeMetrics;
            } else if (starTreeDocuments.get(0).metrics[i] instanceof Double) {
                true,
            Long val2 = doc2.dimensions[i];
                        } else if (nonStarNodeCumulativeMetric instanceof Long) {
        for (Metric metric : metrics) {
            new HashMap<>(),
        SegmentInfo segmentInfo = new SegmentInfo(
            // assert dimensions
                int dimensionId = node.getDimensionId();
                }
    }
                    VectorSimilarityFunction.EUCLIDEAN,
                return 0;
            directory,
            }
                                assertEquals((long) metric, (long) aggregatedMetrics[j]);
import static org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils.fullyQualifiedFieldNameForStarTreeMetricsDocValues;
            "test_segment",
                                Long dimension = doc.dimensions[child.getDimensionId()];
            numDocs,
        int maxLeafDocuments,
            public int docValueCount() {
            @Override
                }
                         * TODO : refactor this to handle any data type
        InMemoryTreeNode starTreeNode;
                assertEquals(node.getEndDocId() - node.getStartDocId(), docCount);
        }
 * this file be licensed under the Apache-2.0 license or a
            @Override
        }
import org.opensearch.index.compositeindex.datacube.startree.StarTreeTestUtils;
        assertFalse(rootNode.getChildren().isEmpty());
    static void traverseStarTree(InMemoryTreeNode root, Map<Integer, Map<Long, Integer>> dimValueToDocIdMap, boolean traverStarNodes) {
            Version.LUCENE_10_1_0,
import java.util.Objects;
            @Override
            public boolean advanceExact(int target) {
        SegmentWriteState writeState,
                return 0;
            int index = -1;
 * The OpenSearch Contributors require contributions made to
        BaseStarTreeBuilder builder,
            @Override
    }
        for (int i = startDim; i < endDim; i++) {
            Object[] current = queue.poll();
        return getSortedSetMock(dimList, docsWithField, 1);
                false,
        };
import java.util.Map;
     */
    }
    public static List<SequentialDocValuesIterator> getMetricIterators(StarTreeDocument[] starTreeDocuments) {
            public int nextDoc() {
        InMemoryTreeNode rootNode,
import org.apache.lucene.index.DocValuesSkipIndexType;
                        metric.getField(),
        }
                for (Map.Entry<Long, InMemoryTreeNode> entry : node.getChildren().entrySet()) {
                    docsWithField.add(i);
                    int j = 0;
                            addMetrics(doc, currMetrics, j);
                while (childrenIterator.hasNext()) {
                    0,
                        Object[] aggregatedMetrics = starTreeDocuments.get(child.getAggregatedDocId()).metrics;
                && (!traverStarNodes || starTreeNode.getNodeType() == StarTreeNodeType.STAR.getValue())) {
                                nonStarNodeCumulativeMetrics[j] = (long) nonStarNodeCumulativeMetrics[j] + (long) metric;
                    }
        StarTreeDocument[] expectedStarTreeDocumentsArray = expectedStarTreeDocuments.toArray(new StarTreeDocument[0]);
            }
                if (starNode != null) {
        return new SortedNumericDocValues() {
            expectedStarTreeMetadata.getDimensionFields(),
            }
        List<SequentialDocValuesIterator> sequentialDocValuesIterators = new ArrayList<>();
            InMemoryTreeNode node = (InMemoryTreeNode) current[0];
                if (val1 == null) return 1;
import org.apache.lucene.store.Directory;
            Version.LUCENE_10_1_0,
    ) {
    private static int compareDocuments(StarTreeDocument doc1, StarTreeDocument doc2, int startDim, int endDim) {
        // Use BFS to traverse the star tree
                if (starTreeDocuments[i].dimensions[j] != null) {
            new HashMap<>(),
            numDocs,
            List.of(starTreeValues),
                    docId++;
                }
        List<StarTreeDocument> starTreeDocuments
                    queue.add(childNode);
            directory
import org.apache.lucene.index.VectorSimilarityFunction;
                while (docId < node.getEndDocId()) {
                nonStarNodeCumulativeMetrics[i] = 0.0;
            public int advance(int target) {
            List<Integer> docsWithField = new ArrayList<>();
                i++;
    }
                        assertEquals(nonStarNodeCumulativeMetric, starNodeMetrics[j]);
                false,
                return false;
            new HashMap<>(),
            }
                    Object[] aggregatedMetrics = starTreeDocuments.get(starNode.getAggregatedDocId()).metrics;
                0,
                                nonStarNodeCumulativeMetrics[j] = (float) nonStarNodeCumulativeMetrics[j] + (float) metric;
            dimValueToDocIdMap.put(dimensionId, map);
import org.apache.lucene.index.SegmentReadState;
        return new SegmentReadState(segmentInfo.dir, segmentInfo, new FieldInfos(fields), writeState.context);
            new Lucene104Codec(),
            }
                new SortedNumericStarTreeValuesIterator(getSortedNumericMock(dimList, docsWithField))
            i++;
import org.opensearch.index.mapper.FieldValueConverter;
                        assertTrue(compareDocuments(prevDoc, currentDoc, dimensionId + 1, totalDimensions) <= 0);
            } else {
import org.apache.lucene.index.IndexOptions;
                0,
        String dataFileName,
                            assertEquals((double) nonStarNodeCumulativeMetric, (double) starNodeMetrics[j], 0);
                        starNode = child;
        List<FieldValueConverter> fieldValueConverters = new ArrayList<>();
        );
            null
        }
        SegmentReadState readState = getReadState(
            null
import static org.apache.lucene.tests.util.LuceneTestCase.random;
        Directory directory
        StarTreeField starTreeField,
import java.util.ArrayDeque;
        Directory directory
                index++;
                return index;
        return sequentialDocValuesIterators;
                }
                    dimList.add(starTreeDocuments[i].dimensions[j]);
            new HashMap<>(),
                                    // TODO : fix this ?
                index++;
                                nonStarNodeCumulativeMetrics[j] = (double) nonStarNodeCumulativeMetrics[j] + (double) metric;
    }
import static org.junit.Assert.assertEquals;
                    metricslist.add((long) starTreeDocuments[i].metrics[j]);
        int numMetrics = 0;
                                }
                return 0;
            }
            if (currentIsStarNode) {
import static org.junit.Assert.assertTrue;
            false,
            } else if (starTreeDocuments.get(0).metrics[i] instanceof Float) {
                            assertEquals((long) nonStarNodeCumulativeMetric, (long) starNodeMetrics[j]);
            id,
                        addMetrics(doc, starNodeMetrics, j);
            if (starTreeNode.getNodeType() == StarTreeNodeType.STAR.getValue()) {
            @Override
                map.put(Long.MAX_VALUE, docId);
    public static SortedNumericDocValues getSortedNumericMock(List<Long> dimList, List<Integer> docsWithField) {
    public static SortedSetDocValues getSortedSetMock(List<Long> dimList, List<Integer> docsWithField) {
                IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS,
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedNumericStarTreeValuesIterator;
                    0,
import org.apache.lucene.util.BytesRef;
            if (metric instanceof Double) {
            @Override
                InMemoryTreeNode starNode = null;
                StarTreeDocument prevDoc = null;
                    false,
            metricAggregatorInfo -> fieldValueConverters.add(metricAggregatorInfo.getValueAggregators().getAggregatedValueType())
                VectorSimilarityFunction.EUCLIDEAN,
import java.util.HashMap;
                        }
        StarTreeDocument[] starTreeDocuments = StarTreeTestUtils.getSegmentsStarTreeDocuments(
import java.util.LinkedList;
                return dimList.get(index);
            false,
            Long val1 = doc1.dimensions[i];
    public static SequentialDocValuesIterator[] getDimensionIterators(StarTreeDocument[] starTreeDocuments) {
 *
                return new BytesRef("dummy" + l);
import org.apache.lucene.index.FieldInfos;
            int index = -1;
import org.apache.lucene.index.VectorEncoding;
        int totalDimensions,
                return 0;
            @Override
                fullyQualifiedFieldNameForStarTreeDimensionsDocValues(compositeField.getName(), dimension),
            } else {
import org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils;
                false
import org.apache.lucene.store.IndexInput;
                    VectorEncoding.FLOAT32,
        }
import org.apache.lucene.index.DocValuesType;
        List<Metric> metrics,
    public static void validateStarTreeFileFormats(
            int dimensionId = starTreeNode.getDimensionId();
            assertNotNull(node);
import org.apache.lucene.index.FieldInfo;
                                    assertEquals(child.getDimensionValue(), (long) dimension);
        Queue<InMemoryTreeNode> queue = new ArrayDeque<>();
import org.opensearch.index.codec.composite.LuceneDocValuesProducerFactory;
            @Override
            List<Integer> docsWithField = new ArrayList<>();
            } else if (metric instanceof Long) {
            if (node.getChildren() != null && !node.getChildren().isEmpty()) {
        FieldInfo[] fields = new FieldInfo[dimensionFields.size() + numMetrics];
        }
                    for (Object nonStarNodeCumulativeMetric : nonStarNodeCumulativeMetrics) {
                                assertEquals((float) metric, (float) aggregatedMetrics[j], 0);
                        j++;
                                    assertEquals(child.getDimensionValue(), StarTreeUtils.ALL);
        Object[] nonStarNodeCumulativeMetrics = new Object[starTreeDocuments.get(0).metrics.length];
        return new SortedSetDocValues() {
                    false,
                        int j = 0;
            new SequentialDocValuesIterator[starTreeDocuments[0].dimensions.length];
        dataIn.close();
            if (starTreeDocuments.get(0).metrics[i] instanceof Long) {
                                if (dimension != null) {
            }
    public static SegmentWriteState getWriteState(int numDocs, byte[] id, FieldInfo[] fieldsInfo, Directory directory) {
                    prevDoc = currentDoc;
            }
        for (int j = 0; j < starTreeDocuments[0].dimensions.length; j++) {
import static org.opensearch.index.compositeindex.datacube.startree.StarTreeTestUtils.validateFileFormats;
            } else if (metric instanceof Float) {
                currMetrics[j] = (double) currMetrics[j] + (double) metric;
            public long nextValue() {
    }
                            /*
import org.opensearch.index.compositeindex.datacube.startree.fileformats.meta.DimensionConfig;
                            } else if (metric instanceof Long) {
        StarTreeMetadata expectedStarTreeMetadata,
                    fullyQualifiedFieldNameForStarTreeMetricsDocValues(
                0,
            }
                currMetrics[j] = (float) currMetrics[j] + (float) metric;
            @Override
import java.io.IOException;
                return docsWithField.get(index);
                    DocValuesSkipIndexType.RANGE,
        }
        Map<String, DimensionConfig> dimensionFields,
import static org.junit.Assert.assertNotNull;
                             */
                        assertEquals(starNodeMetrics[j], aggregatedMetrics[j]);
                dimensionFields.get(dimension).getDocValuesType(),
            @Override
        SegmentWriteState writeState,
                            StarTreeDocument doc = starTreeDocuments.get(i);
            if (!Objects.equals(val1, val2)) {
                }
                        for (Object metric : currMetrics) {
        List<Integer> docIds = new ArrayList<>();
import org.apache.lucene.index.SegmentWriteState;
                new SequentialDocValuesIterator(new SortedNumericStarTreeValuesIterator(getSortedNumericMock(metricslist, docsWithField)))
                i,
                map.put(starTreeNode.getDimensionValue(), docId);
            "test_segment",
                    if (child.getNodeType() != StarTreeNodeType.STAR.getValue()) {
                    0,
        for (int j = 0; j < starTreeDocuments[0].metrics.length; j++) {
                    StarTreeDocument currentDoc = starTreeDocuments.get(docId);
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
        IndexInput dataIn = readState.directory.openInput(dataFileName, IOContext.DEFAULT);
            public long cost() {
import java.util.List;
                            assertEquals((float) nonStarNodeCumulativeMetric, (float) aggregatedMetrics[j], 0);
                if (val2 == null) return -1;
            directory,
        builder.metricAggregatorInfos.forEach(
                    Object[] starNodeMetrics = getMetrics(starTreeDocuments);
                    queue.offer(new Object[] { starNode, true });
            sequentialDocValuesIterators[j] = new SequentialDocValuesIterator(
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;
        String metaFileName,
                    assertEquals(-1L, starNode.getDimensionValue());
    }
                return 0;
            if (node.getDimensionId() != StarTreeUtils.ALL) {
                            if (metric instanceof Double) {
                Object[] nonStarNodeCumulativeMetrics = getMetrics(starTreeDocuments);
            @Override
            for (int i = 0; i < starTreeDocuments.length; i++) {
            if (starTreeNode.getChildren() != null
package org.opensearch.index.compositeindex.datacube.startree.builder;
            }
            @Override
                assertTrue(node.getEndDocId() - node.getStartDocId() <= maxLeafDocuments);
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
                    Collections.emptyMap(),
                currMetrics[j] = (long) currMetrics[j] + (long) metric;
                nonStarNodeCumulativeMetrics[i] = 0L;
                    InMemoryTreeNode childNode = childrenIterator.next();
import org.apache.lucene.store.IOContext;
            new Lucene104Codec(),
        List<StarTreeDocument> expectedStarTreeDocuments,
                if (starTreeDocuments[i].metrics[j] != null) {
                assertTrue(node.getChildDimensionId() < totalDimensions);
        }
        StarTreeTestUtils.assertStarTreeDocuments(starTreeDocuments, expectedStarTreeDocumentsArray);
            public int docValueCount() {
    }
import static org.junit.Assert.assertNull;
                int docId = node.getStartDocId();
                                assertEquals(childDimensionValue, dimension);
            false,
import org.apache.lucene.util.Version;
            List<Long> dimList = new ArrayList<>();
            @Override
            public int advance(int target) {
 */
            }
            }
                            }
                        /*
        for (Object metric : doc.metrics) {
        return 0;
                return Long.compare(val1, val2);
                        if (nonStarNodeCumulativeMetric instanceof Double) {
                VectorEncoding.FLOAT32,
                return index;
public class BuilderTestsUtils {
            readState.segmentInfo.maxDoc()
                    docsWithField.add(i);
        while ((starTreeNode = queue.poll()) != null) {
        return sequentialDocValuesIterators;
                }
        while (!queue.isEmpty()) {
        StarTreeField compositeField,
                Collections.emptyMap(),
import static org.junit.Assert.assertFalse;
import java.util.Collections;
                            }
            }
            }
    public static SegmentReadState getReadState(
            if (dimensionId > currentDimensionId) {
            }
                return docsWithField.get(index);
                return 1;
import org.apache.lucene.util.InfoStream;
    }
            public long nextOrd() throws IOException {
     * TODO : refactor this to handle any data type
import org.opensearch.index.compositeindex.datacube.startree.StarTreeDocument;
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
                        }
            Composite912Codec.COMPOSITE_INDEX_CODEC_NAME,
                currentDimensionId = dimensionId;
                                assertEquals((Double) metric, (Double) aggregatedMetrics[j], 0);
        }
import org.apache.lucene.codecs.DocValuesProducer;
            for (int i = 0; i < starTreeDocuments.length; i++) {
import org.opensearch.index.compositeindex.datacube.startree.fileformats.meta.StarTreeMetadata;
        };
                    Long childDimensionValue = entry.getKey();
                false,
        InMemoryTreeNode starTree = root;
            public long getValueCount() {
        assertEquals(expectedStarTreeMetadata.getStarTreeDocCount(), starTreeValues.getStarTreeDocumentCount());
                -1,
            }
                // Verify that the number of generated star documents matches the range in the star node
            public long cost() {
                    return NO_MORE_DOCS;
                        }
            }
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
import org.opensearch.index.codec.composite.composite912.Composite912Codec;
            expectedStarTreeMetadata.getMetrics(),
        );
                            if (child.getNodeType() != StarTreeNodeType.STAR.getValue()) {
            fieldValueConverters,
        }
                // Add star node to queue
import org.opensearch.index.compositeindex.datacube.MetricStat;
    /**
            List<Long> metricslist = new ArrayList<>();
            int docId = starTreeNode.getAggregatedDocId();
            public int docID() {
        );
            // store aggregated document of the node
    }
                    }
                int docCount = 0;
            }
    public static void validateStarTree(
                if (index == docsWithField.size() - 1) {
import org.opensearch.index.compositeindex.datacube.startree.utils.SequentialDocValuesIterator;
                    if (prevDoc != null) {
                return dimList.get(index);
            public BytesRef lookupOrd(long l) throws IOException {
            false,
        queue.add(starTree);
                            assertEquals((double) nonStarNodeCumulativeMetric, (double) aggregatedMetrics[j], 0);
        SegmentInfo segmentInfo = new SegmentInfo(
                        int j = 0;
                    true,
            );
/*
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
 * SPDX-License-Identifier: Apache-2.0
import static org.apache.lucene.tests.util.LuceneTestCase.newIOContext;
                return false;
import org.opensearch.index.codec.composite.composite912.Composite912DocValuesFormat;
        );
import org.apache.lucene.index.SortedNumericDocValues;
                assertEquals(node.getDimensionId() + 1, node.getChildDimensionId());
                    } else {
            }
            Version.LATEST,
                        } else if (nonStarNodeCumulativeMetric instanceof Float) {
                    i,
import org.apache.lucene.codecs.lucene104.Lucene104Codec;
            }
    private static void addMetrics(StarTreeDocument doc, Object[] currMetrics, int j) {
import org.apache.lucene.index.SegmentInfo;
            }
        );
                    0,
import org.opensearch.index.compositeindex.datacube.Metric;
                    return NO_MORE_DOCS;
                DocValuesSkipIndexType.RANGE,
            }
                }
        IndexInput metaIn = readState.directory.openInput(metaFileName, IOContext.DEFAULT);
        validateFileFormats(dataIn, metaIn, rootNode, expectedStarTreeMetadata, starTreeField);
        Queue<Object[]> queue = new LinkedList<>();
        SequentialDocValuesIterator[] sequentialDocValuesIterators =
                    for (int i = starNode.getStartDocId(); i < starNode.getEndDocId(); i++) {
            );
            }
            sequentialDocValuesIterators.add(
            boolean currentIsStarNode = (boolean) current[1];
        FieldInfos fieldInfos = new FieldInfos(fieldsInfo);
    }
                             * TODO : refactor this to handle any data type
                        queue.offer(new Object[] { child, false });
            }
            Map<Long, Integer> map = dimValueToDocIdMap.getOrDefault(dimensionId, new HashMap<>());
                    Object[] currMetrics = getMetrics(starTreeDocuments);
    }
}
        int i = 0;
        int currentDimensionId = -1;
        int numDocs,
            @Override
        );
            j++;
                                } else {
            Version.LATEST,
            @Override
                    ),
        for (String dimension : dimensionFields.keySet()) {
                        compositeField.getName(),
                0,
                    // Verify sorting of documents
                            j++;
            public boolean advanceExact(int target) {
        queue.offer(new Object[] { root, false });
                Iterator<InMemoryTreeNode> childrenIterator = starTreeNode.getChildren().values().iterator();
                            assertEquals((long) nonStarNodeCumulativeMetric, (long) aggregatedMetrics[j]);
                if (index == docsWithField.size() - 1) {
                         */
            }
    private static Object[] getMetrics(List<StarTreeDocument> starTreeDocuments) {
            readState,
                    DocValuesType.SORTED_NUMERIC,
            public int docID() {
                    assertNull(currentDoc.dimensions[dimensionId]);
import java.util.Iterator;
            );
                }
                return valueCount;
            numDocs,
                    false,
        for (Metric metric : metrics) {
        return new SegmentWriteState(InfoStream.getDefault(), segmentInfo.dir, segmentInfo, fieldInfos, null, newIOContext(random()));
import org.opensearch.index.compositeindex.datacube.startree.node.InMemoryTreeNode;
                    // Verify that the dimension at 'dimensionId' is set to STAR_IN_DOC_VALUES_INDEX
                );
import java.util.ArrayList;
                fields[i] = new FieldInfo(
        metaIn.close();
            for (MetricStat metricStat : metric.getBaseMetrics()) {
                    }
        assertNotNull(rootNode.getChildren());
            numMetrics += metric.getBaseMetrics().size();
                    false
                            assertEquals((float) nonStarNodeCumulativeMetric, (float) starNodeMetrics[j], 0);
            fields[i] = new FieldInfo(
        int numDocs,
        compositeDocValuesProducer.close();
                    InMemoryTreeNode child = entry.getValue();
                    IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS,
