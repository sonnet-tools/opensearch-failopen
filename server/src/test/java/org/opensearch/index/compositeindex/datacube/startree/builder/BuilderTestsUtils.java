                        StarTreeDocument doc = starTreeDocuments.get(i);  
    public static SegmentReadState getReadState(
        metaIn.close();
                    Object[] starNodeMetrics = getMetrics(starTreeDocuments);
                return 0;
            int dimensionId = starTreeNode.getDimensionId();  
        for (int i = 0; i < nonStarNodeCumulativeMetrics.length; i++) {
                    docsWithField.add(i);
            i++;
import org.apache.lucene.util.Version;
            for (int i = 0; i < starTreeDocuments.length; i++) {
            Version.LATEST,  
                            /*  
                    for (Object nonStarNodeCumulativeMetric : nonStarNodeCumulativeMetrics) {  
        dataIn.close();  
                new SequentialDocValuesIterator(new SortedNumericStarTreeValuesIterator(getSortedNumericMock(metricslist, docsWithField)))  
        StarTreeDocument[] starTreeDocuments = StarTreeTestUtils.getSegmentsStarTreeDocuments(
                0,
                        metricStat.getTypeName()
import org.opensearch.index.compositeindex.datacube.startree.StarTreeTestUtils;
        return sequentialDocValuesIterators;
                    // Verify sorting of documents  
            } else if (metric instanceof Float) {
                    prevDoc = currentDoc;
        StarTreeDocument[] expectedStarTreeDocumentsArray = expectedStarTreeDocuments.toArray(new StarTreeDocument[0]);
import org.apache.lucene.codecs.DocValuesProducer;
                if (starNode != null) {  
        };  
            if (!Objects.equals(val1, val2)) {
    }  
import static org.apache.lucene.tests.util.LuceneTestCase.newIOContext;  
import static org.junit.Assert.assertNotNull;
                    Object[] currMetrics = getMetrics(starTreeDocuments);  
                    docId++;
            @Override
                            }
                int docCount = 0;
                Collections.emptyMap(),  
            "test_segment",
        SegmentReadState readState = getReadState(
                            assertEquals((double) nonStarNodeCumulativeMetric, (double) aggregatedMetrics[j], 0);
            boolean currentIsStarNode = (boolean) current[1];
        return nonStarNodeCumulativeMetrics;
                InMemoryTreeNode starNode = null;
            }
                        }
     * TODO : refactor this to handle any data type  
    }
                int dimensionId = node.getDimensionId();  
            @Override
            numDocs,  
        InMemoryTreeNode rootNode,
    private static Object[] getMetrics(List<StarTreeDocument> starTreeDocuments) {  
            }
        return new SortedNumericDocValues() {
                for (Map.Entry<Long, InMemoryTreeNode> entry : node.getChildren().entrySet()) {  
                    false,
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
        SegmentInfo segmentInfo = new SegmentInfo(
                    i,  
            } else {
        Object[] nonStarNodeCumulativeMetrics = new Object[starTreeDocuments.get(0).metrics.length];
                    0,
                    metricslist.add((long) starTreeDocuments[i].metrics[j]);
        List<StarTreeDocument> starTreeDocuments  
        for (int i = startDim; i < endDim; i++) {  
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,  
import org.apache.lucene.index.SegmentInfo;
                                Long dimension = doc.dimensions[child.getDimensionId()];
            } else if (metric instanceof Long) {  
            Long val2 = doc2.dimensions[i];
            }
        int currentDimensionId = -1;
                            assertEquals((long) nonStarNodeCumulativeMetric, (long) starNodeMetrics[j]);
        while (!queue.isEmpty()) {
            public long cost() {
        String dataFileName,  
            public int nextDoc() {  
                Object[] nonStarNodeCumulativeMetrics = getMetrics(starTreeDocuments);
        StarTreeField compositeField,  
                i,
                    assertEquals(-1L, starNode.getDimensionValue());
            }  
import org.opensearch.index.codec.composite.composite912.Composite912Codec;
                        if (nonStarNodeCumulativeMetric instanceof Double) {  
            public int docValueCount() {
            public int advance(int target) {  
        );  
            starTreeField,
            null
        List<SequentialDocValuesIterator> sequentialDocValuesIterators = new ArrayList<>();  
    }  
            new Lucene104Codec(),  
                0,  
        );
        }
        );
            public long getValueCount() {  
                    InMemoryTreeNode childNode = childrenIterator.next();
                IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS,
        }
                assertEquals(node.getDimensionId() + 1, node.getChildDimensionId());
import org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils;
    private static int compareDocuments(StarTreeDocument doc1, StarTreeDocument doc2, int startDim, int endDim) {
import org.opensearch.index.mapper.FieldValueConverter;
 * compatible open source license.
                        } else if (nonStarNodeCumulativeMetric instanceof Float) {  
        int numDocs,  
            Composite912Codec.COMPOSITE_INDEX_CODEC_NAME,
import org.apache.lucene.store.IOContext;
import org.opensearch.index.compositeindex.datacube.startree.fileformats.meta.DimensionConfig;
                            }  
import java.util.Iterator;
        for (Metric metric : metrics) {
                        compositeField.getName(),
            false,
                        } else if (nonStarNodeCumulativeMetric instanceof Long) {  
            @Override
            );
                return index;  
                    }  
import org.opensearch.index.compositeindex.datacube.startree.fileformats.meta.StarTreeMetadata;  
            fields[i] = new FieldInfo(
                    false,
        while ((starTreeNode = queue.poll()) != null) {
                assertTrue(node.getEndDocId() - node.getStartDocId() <= maxLeafDocuments);
import java.util.LinkedList;  
        DocValuesProducer compositeDocValuesProducer = LuceneDocValuesProducerFactory.getDocValuesProducerForCompositeCodec(
import org.apache.lucene.index.SortedNumericDocValues;
                    true,  
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedNumericStarTreeValuesIterator;  
                                } else {  
                            assertEquals((float) nonStarNodeCumulativeMetric, (float) starNodeMetrics[j], 0);
import static org.junit.Assert.assertEquals;
    public static List<SequentialDocValuesIterator> getMetricIterators(StarTreeDocument[] starTreeDocuments) {
                if (starTreeDocuments[i].dimensions[j] != null) {
            new SequentialDocValuesIterator[starTreeDocuments[0].dimensions.length];
                                nonStarNodeCumulativeMetrics[j] = (double) nonStarNodeCumulativeMetrics[j] + (double) metric;
                }
        }
            }
                return new BytesRef("dummy" + l);
import org.apache.lucene.index.VectorEncoding;
    private static void addMetrics(StarTreeDocument doc, Object[] currMetrics, int j) {
            }  
        };
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
                }
                i++;  
        }
                        assertEquals(nonStarNodeCumulativeMetric, starNodeMetrics[j]);
                    queue.add(childNode);
                new SortedNumericStarTreeValuesIterator(getSortedNumericMock(dimList, docsWithField))
    /**
        for (int j = 0; j < starTreeDocuments[0].metrics.length; j++) {
            false,
            expectedStarTreeMetadata.getMetrics(),
        );
            );  
            List<Integer> docsWithField = new ArrayList<>();  
                    VectorSimilarityFunction.EUCLIDEAN,
        builder.metricAggregatorInfos.forEach(
                return 1;  
        SegmentWriteState writeState,
                    InMemoryTreeNode child = entry.getValue();
                    VectorEncoding.FLOAT32,
            }  
                    return NO_MORE_DOCS;  
            @Override
            }
        int totalDimensions,
                    }  
                nonStarNodeCumulativeMetrics[i] = 0L;
                map.put(starTreeNode.getDimensionValue(), docId);
                        for (int i = child.getStartDocId(); i < child.getEndDocId(); i++) {  
            }  
        }
                    Collections.emptyMap(),
import java.util.HashMap;
                }  
            List<Integer> docsWithField = new ArrayList<>();
                    } else {
            }
                                nonStarNodeCumulativeMetrics[j] = (long) nonStarNodeCumulativeMetrics[j] + (long) metric;
    }  
            @Override
        SegmentWriteState writeState,
    public static SortedNumericDocValues getSortedNumericMock(List<Long> dimList, List<Integer> docsWithField) {  
                0,
            expectedStarTreeMetadata.getDimensionFields(),  
            writeState,  
                                assertEquals((Double) metric, (Double) aggregatedMetrics[j], 0);
            public long cost() {  
                return valueCount;
            fieldValueConverters,  
                    StarTreeDocument currentDoc = starTreeDocuments.get(docId);  
            Version.LUCENE_10_1_0,
    public static void validateStarTreeFileFormats(
 *
                false,
                    if (prevDoc != null) {
import java.util.List;
    ) {
    public static SequentialDocValuesIterator[] getDimensionIterators(StarTreeDocument[] starTreeDocuments) {  
            @Override
        // Use BFS to traverse the star tree
import org.opensearch.index.compositeindex.datacube.startree.node.InMemoryTreeNode;
import org.apache.lucene.index.FieldInfos;  
                                if (dimension != null) {
                    dimList.add(starTreeDocuments[i].dimensions[j]);  
        return new SegmentWriteState(InfoStream.getDefault(), segmentInfo.dir, segmentInfo, fieldInfos, null, newIOContext(random()));  
            if (starTreeNode.getChildren() != null  
 * this file be licensed under the Apache-2.0 license or a
                        addMetrics(doc, starNodeMetrics, j);
            new HashMap<>(),  
    public static SortedSetDocValues getSortedSetMock(List<Long> dimList, List<Integer> docsWithField, int valueCount) {
        }
                    Long childDimensionValue = entry.getKey();
            }
import org.apache.lucene.index.VectorSimilarityFunction;
                assertEquals(node.getEndDocId() - node.getStartDocId(), docCount);  
                                    assertEquals(child.getDimensionValue(), StarTreeUtils.ALL);
                            if (child.getNodeType() != StarTreeNodeType.STAR.getValue()) {
            public long nextValue() {
                    if (child.getNodeType() != StarTreeNodeType.STAR.getValue()) {
            public int advance(int target) {
                        for (Object metric : currMetrics) {
            for (MetricStat metricStat : metric.getBaseMetrics()) {
            }
 * SPDX-License-Identifier: Apache-2.0
                );
                fields[i] = new FieldInfo(  
                        }
            @Override
        int maxLeafDocuments,
        String metaFileName,
                assertTrue(node.getChildDimensionId() < totalDimensions);  
            }  
            }
                         */
            @Override
                                assertEquals((long) metric, (long) aggregatedMetrics[j]);
                -1,
}
                // Verify that the number of generated star documents matches the range in the star node
                        j++;
            public long nextOrd() throws IOException {  
        return 0;
                false
import org.opensearch.index.compositeindex.datacube.startree.utils.SequentialDocValuesIterator;
        Queue<InMemoryTreeNode> queue = new ArrayDeque<>();  
            Version.LUCENE_10_1_0,
import java.util.Objects;  
            } else if (starTreeDocuments.get(0).metrics[i] instanceof Float) {
                    assertNull(currentDoc.dimensions[dimensionId]);
    }  
                map.put(Long.MAX_VALUE, docId);  
        for (int j = 0; j < starTreeDocuments[0].dimensions.length; j++) {  
                while (docId < node.getEndDocId()) {
            directory
                return 0;
    public static SegmentWriteState getWriteState(int numDocs, byte[] id, FieldInfo[] fieldsInfo, Directory directory) {
                }  
                StarTreeDocument prevDoc = null;  
                if (starTreeDocuments[i].metrics[j] != null) {  
        Directory directory
                    Object[] aggregatedMetrics = starTreeDocuments.get(starNode.getAggregatedDocId()).metrics;
import org.apache.lucene.index.FieldInfo;
import org.apache.lucene.index.SortedSetDocValues;  
                        }  
                return 0;
import static org.apache.lucene.tests.util.LuceneTestCase.random;
     */
            new HashMap<>(),
            if (starTreeNode.getNodeType() == StarTreeNodeType.STAR.getValue()) {
            if (node.getDimensionId() != StarTreeUtils.ALL) {  
            // store aggregated document of the node
                    docsWithField.add(i);
        }  
                    }  
            readState,  
        int numDocs,  
import java.util.Collections;  
import static org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils.fullyQualifiedFieldNameForStarTreeMetricsDocValues;
                return dimList.get(index);  
        }
                        assertTrue(compareDocuments(prevDoc, currentDoc, dimensionId + 1, totalDimensions) <= 0);
            int index = -1;
import org.apache.lucene.store.Directory;  
import org.opensearch.index.compositeindex.datacube.Metric;  
                             * TODO : refactor this to handle any data type
                            } else if (metric instanceof Long) {  
        assertFalse(rootNode.getChildren().isEmpty());  
                    }  
                Iterator<InMemoryTreeNode> childrenIterator = starTreeNode.getChildren().values().iterator();
    ) {  
                // Add star node to queue
        Map<String, DimensionConfig> dimensionFields,
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
                    IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS,
                index++;
            }  
                true,
                return false;  
        }
        InMemoryTreeNode starTreeNode;  
                    0,  
                return 0;
            }  
        int numMetrics = 0;
                        queue.offer(new Object[] { child, false });  
    ) throws IOException {  
        int i = 0;  
import org.opensearch.index.codec.composite.composite912.Composite912DocValuesFormat;
            if (dimensionId > currentDimensionId) {
import org.apache.lucene.util.BytesRef;  
 */  
            Object[] current = queue.poll();
                    // Verify that the dimension at 'dimensionId' is set to STAR_IN_DOC_VALUES_INDEX  
                                }  
        validateFileFormats(dataIn, metaIn, rootNode, expectedStarTreeMetadata, starTreeField);
                VectorEncoding.FLOAT32,
            dimValueToDocIdMap.put(dimensionId, map);
            List.of(starTreeValues),
            new HashMap<>(),
            numDocs,  
        }  
            public BytesRef lookupOrd(long l) throws IOException {
        List<Integer> docIds = new ArrayList<>();
    public static SortedSetDocValues getSortedSetMock(List<Long> dimList, List<Integer> docsWithField) {  
                                    assertEquals(child.getDimensionValue(), (long) dimension);
import org.opensearch.index.codec.composite.LuceneDocValuesProducerFactory;  
                false,
        List<FieldValueConverter> fieldValueConverters = new ArrayList<>();  
            @Override  
        StarTreeMetadata expectedStarTreeMetadata,
        assertEquals(expectedStarTreeMetadata.getStarTreeDocCount(), starTreeValues.getStarTreeDocumentCount());
        SequentialDocValuesIterator[] sequentialDocValuesIterators =
            directory,
                return index;
            }
            } else if (starTreeDocuments.get(0).metrics[i] instanceof Double) {
import org.apache.lucene.codecs.lucene104.Lucene104Codec;
                    0,
                nonStarNodeCumulativeMetrics[i] = 0.0;  
            public int docID() {
            directory,
                currMetrics[j] = (double) currMetrics[j] + (double) metric;
                    return NO_MORE_DOCS;
import static org.junit.Assert.assertNull;
                                assertEquals((float) metric, (float) aggregatedMetrics[j], 0);
import org.apache.lucene.index.SegmentWriteState;
import org.apache.lucene.index.IndexOptions;
    }
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
                                nonStarNodeCumulativeMetrics[j] = (float) nonStarNodeCumulativeMetrics[j] + (float) metric;
        InMemoryTreeNode starTree = root;
                dimensionFields.get(dimension).getDocValuesType(),  
            readState.segmentInfo.maxDoc()
                index++;
                currMetrics[j] = (long) currMetrics[j] + (long) metric;
        Queue<Object[]> queue = new LinkedList<>();
            false,
                            j++;
        for (Metric metric : metrics) {  
import java.util.ArrayList;
            public int nextDoc() {
            metricAggregatorInfo -> fieldValueConverters.add(metricAggregatorInfo.getValueAggregators().getAggregatedValueType())
            @Override  
        List<StarTreeDocument> expectedStarTreeDocuments,
        return sequentialDocValuesIterators;  
                }
                    0,  
                return Long.compare(val1, val2);
            int index = -1;  
import org.apache.lucene.util.InfoStream;
                }  
public class BuilderTestsUtils {
                if (val1 == null) return 1;
            Long val1 = doc1.dimensions[i];
                            if (metric instanceof Double) {  
                if (val2 == null) return -1;  
            assertNotNull(node);  
    public static void validateStarTree(
            );  
            false,
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;  
                }  
                && (!traverStarNodes || starTreeNode.getNodeType() == StarTreeNodeType.STAR.getValue())) {
import org.apache.lucene.index.DocValuesSkipIndexType;  
        FieldInfo[] fields = new FieldInfo[dimensionFields.size() + numMetrics];
            int docId = starTreeNode.getAggregatedDocId();  
    }
import java.io.IOException;  
            }  
            }
            }
                    fullyQualifiedFieldNameForStarTreeMetricsDocValues(
import static org.junit.Assert.assertFalse;  
        BaseStarTreeBuilder builder,
                    false
            sequentialDocValuesIterators.add(
                            assertEquals((long) nonStarNodeCumulativeMetric, (long) aggregatedMetrics[j]);
                                assertEquals(childDimensionValue, dimension);  
                         * TODO : refactor this to handle any data type
                fullyQualifiedFieldNameForStarTreeDimensionsDocValues(compositeField.getName(), dimension),  
import static org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils.fullyQualifiedFieldNameForStarTreeDimensionsDocValues;
        StarTreeField starTreeField,  
                currMetrics[j] = (float) currMetrics[j] + (float) metric;  
                VectorSimilarityFunction.EUCLIDEAN,  
            if (starTreeDocuments.get(0).metrics[i] instanceof Long) {  
            } else {
            public int docID() {
            }
                while (childrenIterator.hasNext()) {  
                return docsWithField.get(index);
        return new SegmentReadState(segmentInfo.dir, segmentInfo, new FieldInfos(fields), writeState.context);  
            }  
        assertNotNull(rootNode.getChildren());
    }
            InMemoryTreeNode node = (InMemoryTreeNode) current[0];  
                    for (int i = starNode.getStartDocId(); i < starNode.getEndDocId(); i++) {
                        int j = 0;
                false,  
                if (index == docsWithField.size() - 1) {
                currentDimensionId = dimensionId;
                DocValuesSkipIndexType.RANGE,
                nonStarNodeCumulativeMetrics[i] = 0.0f;
import org.apache.lucene.index.DocValuesType;
    static void traverseStarTree(InMemoryTreeNode root, Map<Integer, Map<Long, Integer>> dimValueToDocIdMap, boolean traverStarNodes) {  
                return docsWithField.get(index);  
            Map<Long, Integer> map = dimValueToDocIdMap.getOrDefault(dimensionId, new HashMap<>());
                0,
            Version.LATEST,  
            public int docValueCount() {
                                    // TODO : fix this ?
        for (Object metric : doc.metrics) {  
            @Override
        Directory directory
                        metric.getField(),  
            List<Long> metricslist = new ArrayList<>();
                        int j = 0;
        );
                return false;
    }
                            assertEquals((float) nonStarNodeCumulativeMetric, (float) aggregatedMetrics[j], 0);
            id,
                             */
            sequentialDocValuesIterators[j] = new SequentialDocValuesIterator(
                            assertEquals((double) nonStarNodeCumulativeMetric, (double) starNodeMetrics[j], 0);
            "test_segment",
/*  
        FieldInfos fieldInfos = new FieldInfos(fieldsInfo);  
            if (currentIsStarNode) {
        for (String dimension : dimensionFields.keySet()) {
import java.util.ArrayDeque;
import static org.opensearch.index.compositeindex.datacube.startree.StarTreeTestUtils.validateFileFormats;  
            for (int i = 0; i < starTreeDocuments.length; i++) {
package org.opensearch.index.compositeindex.datacube.startree.builder;
            @Override
            new Lucene104Codec(),  
            }
                    int j = 0;
                            } else if (metric instanceof Float) {  
            writeState.segmentInfo.getId(),
        queue.add(starTree);
                    false,  
    }
                assertTrue(node.getDimensionId() >= 0 && node.getDimensionId() < totalDimensions);
                        assertEquals(starNodeMetrics[j], aggregatedMetrics[j]);
                int docId = node.getStartDocId();
        compositeDocValuesProducer.close();
                if (index == docsWithField.size() - 1) {
import java.util.Map;
            }
import java.util.Queue;
                            StarTreeDocument doc = starTreeDocuments.get(i);
        );
        StarTreeValues starTreeValues = new StarTreeValues(expectedStarTreeMetadata, dataIn, compositeDocValuesProducer, readState);
import org.opensearch.index.compositeindex.datacube.MetricStat;
        queue.offer(new Object[] { root, false });  
        List<Metric> metrics,
        SegmentInfo segmentInfo = new SegmentInfo(
                            int j = 0;
            if (metric instanceof Double) {
                return 0;  
        InMemoryTreeNode root,  
            @Override  
    }  
            numMetrics += metric.getBaseMetrics().size();
            public boolean advanceExact(int target) {  
            @Override  
            new HashMap<>(),  
                        /*  
import static org.junit.Assert.assertTrue;  
                    queue.offer(new Object[] { starNode, true });
            @Override  
            }
            // assert dimensions
                    docCount++;
        IndexInput metaIn = readState.directory.openInput(metaFileName, IOContext.DEFAULT);
            null
            }
    }
                    ),
            @Override
            List<Long> dimList = new ArrayList<>();
            if (node.getChildren() != null && !node.getChildren().isEmpty()) {
        return new SortedSetDocValues() {
    }  
import org.opensearch.index.compositeindex.datacube.startree.StarTreeDocument;
            j++;
import org.apache.lucene.index.SegmentReadState;  
                            addMetrics(doc, currMetrics, j);  
                    DocValuesSkipIndexType.RANGE,  
import org.apache.lucene.store.IndexInput;
        return getSortedSetMock(dimList, docsWithField, 1);
                    -1,
 * The OpenSearch Contributors require contributions made to  
                }  
        StarTreeTestUtils.assertStarTreeDocuments(starTreeDocuments, expectedStarTreeDocumentsArray);
                        starNode = child;
                        // Validate dimension values in documents
                        Object[] aggregatedMetrics = starTreeDocuments.get(child.getAggregatedDocId()).metrics;  
            }
            public boolean advanceExact(int target) {
        IndexInput dataIn = readState.directory.openInput(dataFileName, IOContext.DEFAULT);
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeNodeType;  
                return dimList.get(index);
            }  
                    DocValuesType.SORTED_NUMERIC,
            numDocs,
