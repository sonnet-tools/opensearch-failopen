        List<Long> dimList2 = List.of(5L, 4L, 3L, 2L, 1L, 0L);
            }
            getBuildMode(),
        // Initialize builder
            getSortedNumericMock(statusDimList, docsWithField)  
            assertEquals(1L, starTreeDocument.metrics[0]);
            4096, /* Lucene90DocValuesFormat#DEFAULT_SKIP_INDEX_INTERVAL_SIZE */  
        DocValuesProducer d1vp = getDocValuesProducer(d1sndv);
        SequentialDocValuesIterator[] dimDvs = { new SequentialDocValuesIterator(d1sndv), new SequentialDocValuesIterator(d2sndv) };
            264  
         */  
         [2, 2] | [20.0, 1]
        Dimension d1 = new NumericDimension("field1");
    public void testFlushFlowForKeywords() throws IOException {  
import java.time.temporal.ChronoField;
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,  
        List<Dimension> dims = List.of(d1, d2);  
            StarTreeDocument starTreeDocument = starTreeDocumentIterator.next();  
        DocValuesProducer d2vp = getDocValuesProducer(d2sndv);
            getLongFromDouble(30.0),
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
        }
        int count = 0;  
                });
        /**  
import org.opensearch.index.mapper.DateFieldMapper;
        List<Integer> docsWithField2 = List.of(0, 1, 2, 3, 4, 5);
            List.of(new SequentialDocValuesIterator(m1sndv), new SequentialDocValuesIterator(m2sndv))
        );
        LinkedHashMap<String, DimensionConfig> docValues = new LinkedHashMap<>();
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(
        double[] expectedSumMetrics = { 0.0, 40.0, 30.0, 50.0, 10.0, 20.0 };  
            consumerWriteState,
         [1655287980000, 1655287200000, 1655287200000, 3] | [30.0, 1]  
        docValuesConsumer.close();  
        SortedNumericStarTreeValuesIterator clientIpIter = new SortedNumericStarTreeValuesIterator(
        List<StarTreeDocument> starTreeDocuments = builder.getStarTreeDocuments();
        );
                    assertEquals(count, (long) starTreeDocument.dimensions[0]);
            STAR_TREE,
        );
 *
                        ? starTreeDocument.dimensions[1] * 1 * 10.0
        Metric m3 = new Metric("field2", List.of(MetricStat.AVG));
            getLongFromDouble(81.0),  
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);  
            getSortedNumericMock(metricsList, metricsWithField)
        Dimension d2 = new NumericDimension("field3");
        /**  
            assertEquals(starTreeDocument.dimensions[3] * 1 * 10.0, ((CompensatedSum) starTreeDocument.metrics[1]).value(), 0);
import org.opensearch.index.compositeindex.datacube.startree.utils.SequentialDocValuesIterator;
        );
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(  
            List.of(new Metric("field2", List.of(MetricStat.SUM, MetricStat.VALUE_COUNT, MetricStat.AVG))),
        );
            builder.numStarTreeDocs,
                assertEquals(expectedSortedDimensions[count][1], dim2);  
            writeState,
        int count = 0;
    }
            4096,
        compositeField = getStarTreeFieldWithUnsignedLongField();
            404L
            86800000000L,
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
         ....
         [3, 3] | [30.0, 1]
            getLongFromDouble(20.0),
        return new StarTreeField("sf", dims, metrics, c);  
            dimDvs,  
        validateStarTreeFileFormats(
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION  
}
        long expectedCountMetric = 1L;
        dataOut.close();
        Object[][] expectedSortedDimensions = {
import org.apache.lucene.search.DocIdSetIterator;
            200L,  
        }
            86700000000L,  
        }
        SequentialDocValuesIterator[] dimDvs = { new SequentialDocValuesIterator(d1sndv), new SequentialDocValuesIterator(d2sndv) };
            mock(IndexInput.class),
    private StarTreeField getStarTreeFieldWithMultipleMetrics() {  
        docValuesConsumer.close();
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitAdapter;  
        builder.appendDocumentsToStarTree(starTreeDocumentIterator);  
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
        StarTreeMetadata starTreeMetadata = new StarTreeMetadata(
         [2, 2] | [20.0]
        }  
        Metric m2 = new Metric("field2", List.of(MetricStat.VALUE_COUNT));
        List<Integer> docsWithField = List.of(0, 1, 3, 4, 5);
        List<Long> dimList = List.of(0L, 1L, 3L, 4L, 5L);
import org.opensearch.index.compositeindex.datacube.NumericDimension;  
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
            public SortedNumericDocValues getSortedNumeric(FieldInfo field) throws IOException {  
        SortedNumericStarTreeValuesIterator d2sndv = new SortedNumericStarTreeValuesIterator(
            getLongFromDouble(30.0),
            count++;
                matchingIndices.removeIf(i -> !statusDimList.get(i).equals(doc.dimensions[0]));
                        : starTreeDocument.dimensions[0] * 10,
        }  
            docValues,
            getSortedNumericMock(metricsList, metricsWithField)
         [null, 0] | [0.0]
            87600000000L,  
            264  
        SortedNumericStarTreeValuesIterator d2sndv = new SortedNumericStarTreeValuesIterator(  
            6,
        StarTreeFieldConfiguration c = new StarTreeFieldConfiguration(1000, new HashSet<>(), getBuildMode());
        List<Dimension> dims = List.of(d1, d2);  
            getLongFromDouble(50.0),
                assertEquals(  
        metaOut.close();
            getSortedNumericMock(metricsList, metricsWithField)
        StarTreeMetadata starTreeMetadata = new StarTreeMetadata(
                        timestamp,
import java.util.stream.IntStream;  
            getLongFromDouble(404L),  
import java.util.LinkedHashMap;  
                new NumericDimension("field1"),
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(  
        assertEquals(59, starTreeDocuments.size());
        SortedNumericStarTreeValuesIterator m1sndv = new SortedNumericStarTreeValuesIterator(  
        );
            mock(IndexInput.class),
    private StarTreeField getStarTreeFieldWithKeywordField(boolean isIp) {  
        );  
            87100000000L,
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,  
import java.util.Set;  
            dimDvs,
                        ? starTreeDocument.dimensions[1] * 1 * 10.0  
        );  
        writeState = getWriteState(6, writeState.segmentInfo.getId());
        List<StarTreeDocument> starTreeDocuments = builder.getStarTreeDocuments();
         [0, 0] | [0.0, 1]
        );  
            getLongFromDouble(404L)  
        SortedNumericStarTreeValuesIterator d1sndv = new SortedNumericStarTreeValuesIterator(getSortedNumericMock(dimList, docsWithField));
        List<Long> dimList2 = List.of(0L, 1L, 2L, 3L, 4L, 5L);  
            86900000000L,
            getLongFromDouble(40.0),
import java.util.Iterator;
 * The OpenSearch Contributors require contributions made to  
        List<StarTreeDocument> starTreeDocumentsList = new ArrayList<>();
            // Filter by size if not null  
        SortedNumericStarTreeValuesIterator m1sndv = new SortedNumericStarTreeValuesIterator(  
        List<Integer> docsWithField = List.of(0, 1, 2, 3, 4);
         [4, 4] | [40.0, 1]
        List<Integer> metricsWithField = List.of(0, 1, 2, 3, 4, 5);
         [null, 2] | [20.0, 1]
            "sf",  
            404L,
        }
    public void testFlushFlowAggregatedDocs() throws IOException {  
            mock(IndexInput.class),
                }  
        List<Integer> docsWithField = List.of(0, 1, 2, 3, 4, 5);
        SortedNumericStarTreeValuesIterator statusMetricsList1 = new SortedNumericStarTreeValuesIterator(  
            getLongFromDouble(60.0),
        StarTreeMetadata starTreeMetadata = getStarTreeMetadata(map, 100, 1, 6699);  
    }
            0,  
            87300000000L,  
            86400000000L,  
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
            STAR_TREE,
            getBuildMode(),
            if (starTreeDocument.dimensions[1] != null) {
    public void testFlushFlowWithUnsignedLongDimensions() throws IOException {  
        List<Metric> metrics = List.of(m1, m2, m3);
 * compatible open source license.
                new NumericDimension("field5"),  
        );
        validateStarTree(builder.getRootNode(), 2, 1000, builder.getStarTreeDocuments());
            1000,  
                    0  
            metricsWithField.add(i);
                assertEquals(
        List<Integer> docsWithField2 = List.of(0, 1, 2, 3, 4, 5);
import org.apache.lucene.index.DocValuesType;
        builder.build(starTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
        Dimension d1 = new NumericDimension("field1");
            36L,
            getLongFromDouble(15.0),  
            builder.numStarTreeNodes,
        SortedNumericStarTreeValuesIterator m2sndv = new SortedNumericStarTreeValuesIterator(  
            { -1L, -1L },  
    }
         [1655288100000, 1655287200000, 1655287200000, 0] | [0.0, 1]  
            6,  
        compositeField = getStarTreeFieldWithKeywordField(random().nextBoolean());
            getSortedNumericMock(dimList2, docsWithField2)
            301L,
        validateStarTreeFileFormats(
            0,
            builder.numStarTreeDocs,
        LinkedHashMap<String, DimensionConfig> docValues = new LinkedHashMap<>();
         [null, 0] | [0.0, 1]
         [4, 4] | [40.0]  
            264
            assertEquals(expectedSum, ((CompensatedSum) (doc.metrics[0])).value(), 0);  
            // Filter by clientip if not null
        );  
            getLongFromDouble(15.0),
                    ((CompensatedSum) starTreeDocument.metrics[0]).value(),
        LinkedHashMap<String, DimensionConfig> map = new LinkedHashMap<>();  
            32L,
            builder.numStarTreeNodes,
            getBuildMode(),
            count++;
import java.io.IOException;
            docsWithField2.add(i);
         [null, 2] | [20.0, 1]  
            200L,  
            // Assert
import org.opensearch.index.compositeindex.datacube.MetricStat;
        SortedNumericStarTreeValuesIterator m2sndv = new SortedNumericStarTreeValuesIterator(
        StarTreeDocument rootDoc = starTreeDocuments.getLast();
            getLongFromDouble(50.0),  
                .sum();
                assertEquals(1L, starTreeDocument.metrics[1]);
        );  
        SegmentWriteState w = getWriteState(DocIdSetIterator.NO_MORE_DOCS, writeState.segmentInfo.getId());
            34L,
        );  
            getLongFromDouble(20.0),  
         [3, 3] | [30.0, 1]
            getLongFromDouble(81.0),
                Long dim1 = starTreeDocument.dimensions[0];  
import java.util.ArrayList;  
        assertEquals(6, builder.getStarTreeDocuments().size());
                assertEquals(expectedCountMetric, starTreeDocument.metrics[1]);
        SequentialDocValuesIterator[] dimDvs = { new SequentialDocValuesIterator(d1sndv), new SequentialDocValuesIterator(d2sndv) };
        builder.build(starTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
        );
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
            // Filter by timestamp month if not null
        );
import org.opensearch.search.aggregations.metrics.CompensatedSum;
        SegmentWriteState consumerWriteState = getWriteState(DocIdSetIterator.NO_MORE_DOCS, writeState.segmentInfo.getId());
            getLongFromDouble(404L),
            4096, /* Lucene90DocValuesFormat#DEFAULT_SKIP_INDEX_INTERVAL_SIZE */
        List<Metric> metrics = List.of(m1);  
            writeState,
        }  
        List<Long> statusDimList = List.of(
        );
            }
    }
            if (doc.dimensions[3] != null) {  
        );
        SortedNumericDocValues d2sndv = getSortedNumericMock(dimList2, docsWithField2);
        int count = 0;  
        List<Integer> docsWithField = List.of(0, 1, 3, 4, 5);
            88300000000L
            List.of(new Metric("field2", List.of(MetricStat.SUM, MetricStat.VALUE_COUNT, MetricStat.AVG))),  
        // validateStarTreeFileFormats(  
            VERSION_CURRENT,  
        Dimension d1 = isIp ? new IpDimension("field1") : new OrdinalDimension("field1");
                });  
            32L,
        starTreeDocumentIterator = starTreeDocumentsList.iterator();  
            dimDvs,  
            getLongFromDouble(60.0),  
            dimList.add((long) i);
            32L,
            double expectedSum = matchingIndices.stream()
        writeState = getWriteState(6, writeState.segmentInfo.getId());
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
            builder.getStarTreeDocuments().size(),
/*  
            if (starTreeDocument.dimensions[1] != null) {  
        SortedNumericStarTreeValuesIterator m1sndv = new SortedNumericStarTreeValuesIterator(
         */
            docValues,
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
        builder.setFlushSortedSetDocValuesMap(dv);
            new SequentialDocValuesIterator(statusIter),
                assertEquals(1L, starTreeDocument.metrics[1]);
            1000,  
        List<Integer> metricsWithField = new ArrayList<>(100);
            getSortedNumericMock(metricsList, metricsWithField)
import org.opensearch.index.compositeindex.datacube.UnsignedLongDimension;
            getLongFromDouble(50.0),  
            if (doc.dimensions[2] != null) {
            87200000000L,
                );
            getLongFromDouble(500L),
import static org.opensearch.index.compositeindex.datacube.startree.builder.BuilderTestsUtils.validateStarTree;
                    ((CompensatedSum) starTreeDocument.metrics[0]).value(),
        List<Integer> docsWithField2 = List.of(0, 1, 2, 3, 4, 5);
            if (doc.dimensions[0] != null) {  
        );
import org.opensearch.index.compositeindex.datacube.DimensionDataType;
         Asserting following dim / metrics [ dim1, dim2 / Sum [metric], count [metric] ]
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(
                matchingIndices.removeIf(i -> {  
        assertEquals(13, count);
        compositeField = getStarTreeFieldWithMultipleMetrics();
         [2, 2] | [20.0, 1]  
            "sf",
        // TODO: Fix this post 2.19 [Handling search for unsigned-long as part of star-tree]
            getLongFromDouble(10.0),
         [3, 3] | [30.0]
        // builder.getStarTreeDocuments().size(),
            getLongFromDouble(10.0),  
            }  
            getLongFromDouble(15.0),
        dataOut.close();  
 */  
    public StarTreeBuilderFlushFlowTests(StarTreeFieldConfiguration.StarTreeBuildMode buildMode) {
import org.apache.lucene.index.SegmentWriteState;
            getLongFromDouble(20.0),  
         [null, null, null, 2] | [20.0, 1]
         [1, 1] | [10.0, 1]
            new SequentialDocValuesIterator(sizeIter),  
            87700000000L,
            200L,  
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);  
            200L,
            88200000000L,  
            builder.numStarTreeNodes,  
            dimDvs,
        SequentialDocValuesIterator[] dimDvs = {  
        LinkedHashMap<String, DimensionConfig> docValues = new LinkedHashMap<>();
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,  
                assertEquals(expectedSumMetrics[count], ((CompensatedSum) starTreeDocument.metrics[0]).value(), 0);  
            264
        SortedNumericDocValues m1sndv = getSortedNumericMock(metricsList, metricsWithField);
        // builder.getStarTreeDocuments()
            getLongFromDouble(301L),
        List<Metric> metrics = List.of(m1, m2, m3);
            }
            getLongFromDouble(301L),
        SortedNumericStarTreeValuesIterator d1sndv = new SortedNumericStarTreeValuesIterator(getSortedNumericMock(dimList, docsWithField));  
        docValues.put("field1", new DimensionConfig(DocValuesType.SORTED_SET, DimensionDataType.LONG));
        dv.put("field1", getSortedSetMock(dimList, docsWithField));
            { 4987L, 4987L },  
import static org.mockito.Mockito.mock;
        // We will filter documents that match status = 200 and size = 4635400285215260672 and perform sum in java  
        );  
        List<Long> metricsList = List.of(
            if (count < 6) {
        while (starTreeDocumentIterator.hasNext()) {
        // Process documents
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(  
        List<Long> sizeDimList = List.of(  
    }
    private StarTreeField getStarTreeFieldWithUnsignedLongField() {  
            getLongFromDouble(30.0),
        );
            getLongFromDouble(50.0)  
            VERSION_CURRENT,
            getSortedNumericMock(metricsList, metricsWithField)
        dataOut.close();
            builder.getStarTreeDocuments()
            getLongFromDouble(15.0),
    private static DocValuesProducer getDocValuesProducer(SortedNumericDocValues sndv) {  
    public void testFlushFlow() throws IOException {  
        writeState = getWriteState(20, writeState.segmentInfo.getId());
            getLongFromDouble(404L),
        );  
            500L,  
        List<Long> metricsList = List.of(  
            32L,  
                assertEquals(expectedSortedDimensions[count][0], dim1);
        DocValuesProducer m1vp = getDocValuesProducer(m1sndv);  
            List.of(new SequentialDocValuesIterator(statusMetricsList1))
        for (StarTreeDocument starTreeDocument : starTreeDocuments) {
            getLongFromDouble(0.0),
        SequentialDocValuesIterator[] dimDvs = { new SequentialDocValuesIterator(d1sndv), new SequentialDocValuesIterator(d2sndv) };  
            builder.numStarTreeDocs,
        );
         [4, 4] | [40.0, 1]
                assertEquals(6L, starTreeDocument.metrics[1]);
        compositeField = new StarTreeField(
        List<Integer> docsWithField2 = List.of(0, 1, 2, 3, 4, 5);  
        List<Integer> metricsWithField = List.of(0, 1, 2, 3, 4, 5);
            getLongFromDouble(23.0),  
        docValuesConsumer.close();
         [1655288040000, 1655287200000, 1655287200000, 1] | [10.0, 1]
            count++;
        );
            getLongFromDouble(81.0),
            "sf",
            getSortedNumericMock(clientIpDimList, docsWithField)  
    }
        for (StarTreeDocument starTreeDocument : starTreeDocuments) {  
            starTreeMetadata,
        List<Long> metricsList = List.of(
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
                starTreeDocument.dimensions[1] != null ? starTreeDocument.dimensions[1] * 10.0 : 49500.0,
        assertNull(rootDoc.dimensions[1]);
        compositeField = getStarTreeFieldWithDateDimension();
         [null, 1] | [10.0]  
            38L,
        );
        // and match against the resultant metric
        // Assert all documents by formulating the matching docs based on the value of resultant documents
         [4, 4] | [40.0, 1]  
            }  
        List<Long> clientIpDimList = List.of(
import org.opensearch.index.compositeindex.datacube.IpDimension;  
            "sf",
import java.util.concurrent.atomic.AtomicInteger;
            getLongFromDouble(500L),  
                );  
        assertNull(rootDoc.dimensions[3]);  
            getLongFromDouble(40.0),
            getSortedNumericMock(timestampList, docsWithField)  
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
        Dimension d2 = new NumericDimension("field3");  
        );
            builder.getStarTreeDocuments().size(),
            @Override
        validateStarTree(builder.getRootNode(), 2, 1000, builder.getStarTreeDocuments());  
            count++;
        List<Metric> metrics = List.of(m1, m2, m3);
        SortedNumericDocValues d1sndv = getSortedNumericMock(dimList, docsWithField);  
                    starTreeDocument.dimensions[0] == null
        List<Long> dimList2 = List.of(0L, -1L, 2L, 9223372036854775806L, 4987L, -9223372036854775807L);  
        List<Long> metricsList = new ArrayList<>(100);
        );
        SortedNumericStarTreeValuesIterator d2sndv = new SortedNumericStarTreeValuesIterator(  
         [1, 1] | [10.0, 1]  
            4096, /* Lucene90DocValuesFormat#DEFAULT_SKIP_INDEX_INTERVAL_SIZE */
        validateStarTreeFileFormats(  
            builder.getStarTreeDocuments().size(),  
        docValues.put("field3", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
            List.of(new Metric("field2", List.of(MetricStat.SUM, MetricStat.VALUE_COUNT, MetricStat.AVG))),
            39L,  
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
        validateStarTreeFileFormats(
            getLongFromDouble(50.0),  
        validateStarTree(builder.getRootNode(), 3, 10, builder.getStarTreeDocuments());  
        Dimension d1 = new UnsignedLongDimension("field1");
        docValuesConsumer.close();  
            38L,  
        );
        List<Long> dimList2 = List.of(0L, 1L, 2L, 3L, 4L, 5L);
        int count = 0;  
            docValues,
         * Asserting following dim / metrics [ dim1, dim2 / Sum [ metric] ]
    public void testFlushFlowWithTimestamps() throws IOException {
            0,  
            VERSION_CURRENT,  
                    // Match if either day or month rounding matches
            writeState,
        List<StarTreeDocument> starTreeDocuments = builder.getStarTreeDocuments();  
        validateStarTree(builder.getRootNode(), 2, 1000, builder.getStarTreeDocuments());
        StarTreeFieldConfiguration c = new StarTreeFieldConfiguration(1000, new HashSet<>(), getBuildMode());
        metaOut.close();
            getSortedNumericMock(dimList2, docsWithField2)
        List<Integer> docsWithField = new ArrayList<>(100);  
        // Create lists to hold the dimension and metric values from the log data
        );
            }
            assertEquals(matchingIndices.size(), (long) (doc.metrics[1]));
        validateStarTree(builder.getRootNode(), 2, 1000, builder.getStarTreeDocuments());
        Metric m2 = new Metric("field2", List.of(MetricStat.VALUE_COUNT));
            87000000000L,  
            500L,
            36L,
        compositeField = new StarTreeField("sf", dims, metrics, c);
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, getWriteState(6, writeState.segmentInfo.getId()), mapperService);  
        List<Long> dimList = List.of(1655288152000L, 1655288092000L, 1655288032000L, 1655287972000L, 1655288092000L);
        docValues.put("field3", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.UNSIGNED_LONG));  
        );
    }
        assertEquals(13, count);
            List.of(new Metric("field2", List.of(MetricStat.SUM, MetricStat.VALUE_COUNT, MetricStat.AVG))),  
        StarTreeFieldConfiguration c = new StarTreeFieldConfiguration(1000, new HashSet<>(), getBuildMode());
            getLongFromDouble(503L),  
    public void testFlushFlowDimsReverse() throws IOException {
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;
        metaOut.close();
            getLongFromDouble(200L),
        List<StarTreeDocument> starTreeDocuments = builder.getStarTreeDocuments();
            STAR_TREE,  
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(
import java.util.List;
        );
        assertEquals(6, count);
            getSortedNumericMock(metricsList, metricsWithField)
            metricsList.add(getLongFromDouble(i * 10.0));
         * Asserting following dim / metrics [ dim1, dim2 / Sum [metric], count [metric] ]
        );
        // builder.getRootNode(),
        StarTreeMetadata starTreeMetadata = new StarTreeMetadata(
public class StarTreeBuilderFlushFlowTests extends StarTreeBuilderTestCase {  
import org.opensearch.index.compositeindex.datacube.Metric;
            getLongFromDouble(500L),
        }  
        docValues.put("field1", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.UNSIGNED_LONG));
            getLongFromDouble(10.0),
            getLongFromDouble(50.0),
            writeState,  
        }
        );
        compositeField = getStarTreeFieldWithMultipleMetrics();  
        }
            getLongFromDouble(500L),
            assertEquals(  
            builder.getStarTreeDocuments()
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION  
                0  
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,  
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(
        dataOut.close();
import org.opensearch.index.compositeindex.datacube.Dimension;
import static org.opensearch.index.compositeindex.datacube.startree.fileformats.StarTreeWriter.VERSION_CURRENT;
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitRounding;
                if (starTreeDocument.dimensions[0] != null) {
            builder.getRootNode(),
            }
            List.of(  
import static org.opensearch.index.mapper.CompositeMappedFieldType.CompositeFieldType.STAR_TREE;  
        );
            87500000000L,
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
            getLongFromDouble(40.0),
import org.opensearch.index.codec.composite.LuceneDocValuesConsumerFactory;
            87800000000L,
        List<Long> metricsList = List.of(  
        List<Integer> docsWithField2 = List.of(0, 1, 2, 3, 4, 5);
            getLongFromDouble(20.0),  
        List<Long> metricsList = List.of(  
            }
            4096, /* Lucene90DocValuesFormat#DEFAULT_SKIP_INDEX_INTERVAL_SIZE */
        // starTreeMetadata,  
                new NumericDimension("field3"),
                count++;  
            34L,  
         [null, null] | [49500.0]
        assertNull(rootDoc.dimensions[2]);
         * Asserting following dim / metrics [ dim1, dim2 / Sum [metric], count [metric] ]  
 * this file be licensed under the Apache-2.0 license or a
            Set.of(),  
        metaOut.close();
            getLongFromDouble(0.0),
        /**
        /**  
        StarTreeMetadata starTreeMetadata = new StarTreeMetadata(
        // Validate results
            List.of(new SequentialDocValuesIterator(m1sndv), new SequentialDocValuesIterator(m2sndv))  
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
         */
        for (StarTreeDocument starTreeDocument : builder.getStarTreeDocuments()) {
        SortedNumericStarTreeValuesIterator d1sndv = new SortedNumericStarTreeValuesIterator(getSortedNumericMock(dimList, docsWithField));
         [1, 1] | [10.0, 1]
        List<DateTimeUnitRounding> intervals = new ArrayList<>();
    }
            38L,
            getLongFromDouble(200L),  
        starTreeDocumentIterator.forEachRemaining(starTreeDocumentsList::add);
            getLongFromDouble(30.0),
         [1, 1] | [10.0]  
import org.apache.lucene.codecs.DocValuesProducer;
            getLongFromDouble(503L),
        );
        writeState = getWriteState(6, writeState.segmentInfo.getId());
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedNumericStarTreeValuesIterator;
            87900000000L,  
import org.opensearch.common.time.DateUtils;  
        Metric m2 = new Metric("field2", List.of(MetricStat.VALUE_COUNT));
                return sndv;
        dv.put("field3", getSortedSetMock(dimList2, docsWithField2));  
            builder.getRootNode(),  
        );  
            36L,  
                    return doc.dimensions[3] != dayRoundedTimestamp;  
        );
        List<Integer> docsWithField2 = new ArrayList<>(100);
            w,  
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
import org.opensearch.common.Rounding;
            { 0L, 0L },
         [5, 5] | [50.0, 1]  
            500L,
        List<Long> dimList = new ArrayList<>(100);
        // Build star tree
        );  
            getLongFromDouble(0.0),
            if (count <= 6) {
        };  
        Metric m3 = new Metric("field2", List.of(MetricStat.AVG));
            new StarTreeFieldConfiguration(1, Set.of("field1"), getBuildMode())
        // For example : [200, null, 4635400285215260672, null, null] | [1000.0 0.0]
         * Asserting following dim / metrics [ dim1, dim2 / Sum [metric], count [metric] ]
        );  
            getSortedNumericMock(metricsList, metricsWithField)
            List<Integer> matchingIndices = IntStream.range(0, statusDimList.size()).boxed().collect(Collectors.toList());  
            builder.getStarTreeDocuments()  
        List<Long> dimList = List.of(0L, -1L, 9223372036854775806L, 4987L, -9223372036854775807L);
        List<StarTreeDocument> starTreeDocuments = builder.getStarTreeDocuments();
        dataOut.close();
            // Filter by status if not null
import org.apache.lucene.index.FieldInfo;
         */  
                    );  
    }  
import org.apache.lucene.util.NumericUtils;
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
        int count = 0;  
        docValues.put("field1", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));  
        );
            getLongFromDouble(404L),  
                assertEquals(starTreeDocument.dimensions[1] * 10.0, ((CompensatedSum) starTreeDocument.metrics[0]).value(), 0);
            4096, /* Lucene90DocValuesFormat#DEFAULT_SKIP_INDEX_INTERVAL_SIZE */  
            dimDvs,
            starTreeMetadata,
        for (StarTreeDocument starTreeDocument : starTreeDocuments) {
            ),
            { -9223372036854775807L, -9223372036854775807L },
            getSortedNumericMock(statusMetricsList, docsWithField)
            builder.getRootNode(),
         [9223372036854775806, 9223372036854775806] | [30.0, 1]
            // Filter by timestamp day if not null
        intervals.add(new DateTimeUnitAdapter(Rounding.DateTimeUnit.DAY_OF_MONTH));  
            } else {  
            getLongFromDouble(20.0),  
        SortedNumericStarTreeValuesIterator d1sndv = new SortedNumericStarTreeValuesIterator(getSortedNumericMock(dimList, docsWithField));
                assertEquals(1L, starTreeDocument.metrics[1]);
            503L,
            200L,
        writeState = getWriteState(100, writeState.segmentInfo.getId());
import java.util.HashSet;
            }
            builder.numStarTreeDocs,
import org.opensearch.index.compositeindex.datacube.startree.fileformats.meta.DimensionConfig;  
        Metric m1 = new Metric("field2", List.of(MetricStat.SUM));  
        /*
        Map<String, SortedSetDocValues> dv = new LinkedHashMap<>();
        for (StarTreeDocument doc : starTreeDocuments) {
        List<Dimension> dims = List.of(d1, d2);  
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.index.compositeindex.datacube.startree.builder.BuilderTestsUtils.getSortedSetMock;  
        );
        /**  
        List<Long> dimList2 = List.of(0L, 1L, 2L, 3L, 4L, 5L);  
                    long dayRoundedTimestamp = DateUtils.roundFloor(  
        SortedNumericStarTreeValuesIterator m2sndv = new SortedNumericStarTreeValuesIterator(
            builder.getStarTreeDocuments()
         [5, 5] | [50.0, 1]
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
            getLongFromDouble(81.0),
            getLongFromDouble(200L),
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,  
         [1655288040000, 1655287200000, 1655287200000, 5] | [50.0, 1]
                    0
        builder.build(starTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
        SortedNumericStarTreeValuesIterator m2sndv = new SortedNumericStarTreeValuesIterator(
            getLongFromDouble(200L),
        );
            39L  
            builder.numStarTreeNodes,  
        );
        assertEquals(7432.0, ((CompensatedSum) rootDoc.metrics[0]).value(), 0);
            getLongFromDouble(10.0),
                    return monthRoundedTimestamp != doc.dimensions[4];
    }
                matchingIndices.removeIf(i -> !clientIpDimList.get(i).equals(doc.dimensions[1]));  
        super(buildMode);  
        List<Integer> metricsWithField = List.of(0, 1, 2, 3, 4, 5);
import java.util.Map;
            500L,
        for (int i = 0; i < 100; i++) {
            0,
                    starTreeDocument.dimensions[0] == null
            writeState,
            35L,
import org.opensearch.index.compositeindex.datacube.DateDimension;  
        metaOut.close();  
        docValues.put("field3", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
        SortedNumericStarTreeValuesIterator d2sndv = new SortedNumericStarTreeValuesIterator(
            36L,
            39L,  
    public void testFlushFlowBuild() throws IOException {
        SortedNumericStarTreeValuesIterator sizeIter = new SortedNumericStarTreeValuesIterator(
                assertEquals(6L, starTreeDocument.metrics[1]);
                new DateDimension("field7", intervals, DateFieldMapper.Resolution.MILLISECONDS)
         * Asserting following dim / metrics [ dim1, dim2 / Sum [metric], count [metric] ]
            { 9223372036854775806L, 9223372036854775806L },
            404L,  
            "sf",  
        List<Long> dimList = List.of(5L, 4L, 3L, 2L, 1L);  
         ...
        builder.build(starTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);  
            getBuildMode(),
        SortedNumericStarTreeValuesIterator timestampIter = new SortedNumericStarTreeValuesIterator(
        validateStarTree(builder.getRootNode(), 5, 1, builder.getStarTreeDocuments());
                        ChronoField.DAY_OF_MONTH.getBaseUnit().getDuration().toMillis()
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
        List<Long> dimList2 = new ArrayList<>(100);  
            6,
                ((CompensatedSum) starTreeDocument.metrics[0]).value(),
            docsWithField.add(i);  
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
        SortedNumericStarTreeValuesIterator m1sndv = new SortedNumericStarTreeValuesIterator(
         [0, 0] | [0.0]
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
            getLongFromDouble(50.0)  
            301L,  
        );
         [0, 0] | [0.0, 1]
import org.apache.lucene.index.SortedNumericDocValues;  
import org.opensearch.index.compositeindex.datacube.startree.StarTreeDocument;  
            new SequentialDocValuesIterator(clientIpIter),
            { null, 2L } };
                matchingIndices.removeIf(i -> !sizeDimList.get(i).equals(doc.dimensions[2]));
        docValuesConsumer.close();
        );
            88000000000L,
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(  
        // Create document value iterators
                .mapToDouble(i -> NumericUtils.sortableLongToDouble(statusMetricsList.get(i)))  
            getLongFromDouble(0.0)
            getLongFromDouble(40.0),
                        : starTreeDocument.dimensions[0] * 10,  
        for (StarTreeDocument starTreeDocument : starTreeDocuments) {
            if (doc.dimensions[1] != null) {
            builder.getStarTreeDocuments().size(),  
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);  
        docValues.put("field1", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));  
            VERSION_CURRENT,
                assertEquals(150D, ((CompensatedSum) starTreeDocument.metrics[0]).value(), 0);  
                    long monthRoundedTimestamp = DateUtils.roundMonthOfYear(timestamp);
        builder.build(fieldProducerMap, new AtomicInteger(), docValuesConsumer);
            getLongFromDouble(30.0),
import java.util.stream.Collectors;
                assertEquals(150D, ((CompensatedSum) starTreeDocument.metrics[0]).value(), 0);
                    long timestamp = timestampList.get(i);
            39L,
            getLongFromDouble(23.0),
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
            86500000000L,
            getLongFromDouble(200L),
            new SequentialDocValuesIterator(timestampIter) };
        builder.build(starTreeDocumentsList.iterator(), new AtomicInteger(), docValuesConsumer);
import org.apache.lucene.store.IndexInput;  
            1000,
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
            getLongFromDouble(60.0),
        );
            starTreeMetadata,
            List.of(new SequentialDocValuesIterator(m1sndv), new SequentialDocValuesIterator(m2sndv))
            6,  
                Long dim2 = starTreeDocument.dimensions[1];
                    long timestamp = timestampList.get(i);
            getLongFromDouble(301L),  
            33L,
                matchingIndices.removeIf(i -> {
import org.apache.lucene.index.SortedSetDocValues;
            getLongFromDouble(10.0),
            if (doc.dimensions[4] != null) {
            86600000000L,
        dataOut.close();  
         */
            getLongFromDouble(50.0)
        intervals.add(new DateTimeUnitAdapter(Rounding.DateTimeUnit.MONTH_OF_YEAR));
        // );
        Metric m1 = new Metric("field2", List.of(MetricStat.SUM));  
        map.put("field3", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
            getLongFromDouble(23.0),
            getSortedNumericMock(dimList2, docsWithField2)  
        SortedNumericStarTreeValuesIterator statusIter = new SortedNumericStarTreeValuesIterator(
            dimDvs,  
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
        LinkedHashMap<String, DimensionConfig> docValues = new LinkedHashMap<>();
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,  
        StarTreeFieldConfiguration c = new StarTreeFieldConfiguration(1, new HashSet<>(), getBuildMode());
         [4987, 4987] | [40.0, 1]
        Dimension d2 = new UnsignedLongDimension("field3");
            }  
        List<Long> statusMetricsList = List.of(
        List<Long> dimList = List.of(0L, 1L, 2L, 3L, 4L, 5L);
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(
         */
import org.opensearch.index.compositeindex.datacube.OrdinalDimension;
            dimList2.add((long) i);  
        SortedNumericStarTreeValuesIterator m2sndv = new SortedNumericStarTreeValuesIterator(  
         [3, 3] | [30.0, 1]  
        SortedSetStarTreeValuesIterator d1sndv = new SortedSetStarTreeValuesIterator(getSortedSetMock(dimList, docsWithField));
        for (int i = 0; i < 100; i++) {
            Set.of(),  
            starTreeMetadata,  
            Set.of(),
            List.of(new SequentialDocValuesIterator(m1sndv), new SequentialDocValuesIterator(m2sndv))  
            getSortedNumericMock(dimList2, docsWithField2)
    }
            getSortedNumericMock(metricsList, metricsWithField)  
            getLongFromDouble(81.0),
        );
        Dimension d2 = isIp ? new IpDimension("field3") : new OrdinalDimension("field3");
        );
            404L,
            List.of(new Metric("field2", List.of(MetricStat.SUM, MetricStat.VALUE_COUNT, MetricStat.AVG))),  
            getLongFromDouble(40.0),  
            getSortedNumericMock(metricsList, metricsWithField)
        assertEquals(13, count);
        return new StarTreeField("sf", dims, metrics, c);  
        );  
        metaOut.close();
        for (int i = 0; i < 100; i++) {  
import org.opensearch.index.codec.composite.composite912.Composite912DocValuesFormat;
        Metric m3 = new Metric("field2", List.of(MetricStat.AVG));
        return new EmptyDocValuesProducer() {
        validateStarTree(builder.getRootNode(), 2, 1, builder.getStarTreeDocuments());  
        );
        SequentialDocValuesIterator[] dimDvs = { new SequentialDocValuesIterator(d1sndv), new SequentialDocValuesIterator(d2sndv) };  
            STAR_TREE,  
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedSetStarTreeValuesIterator;  
            getSortedNumericMock(metricsList, metricsWithField)  
            getLongFromDouble(15.0)
            getSortedNumericMock(sizeDimList, docsWithField)  
            503L,
    }
import org.opensearch.index.compositeindex.datacube.startree.fileformats.meta.StarTreeMetadata;
                    // Match if either day or month rounding matches
        List<Integer> docsWithField = List.of(0, 1, 3, 4, 5);  
import org.apache.lucene.index.EmptyDocValuesProducer;  
         [5, 5] | [50.0, 1]
        assertNull(rootDoc.dimensions[0]);  
        SortedNumericStarTreeValuesIterator m1sndv = new SortedNumericStarTreeValuesIterator(
        builder.build(starTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
import org.opensearch.index.compositeindex.datacube.startree.StarTreeFieldConfiguration;
import static org.opensearch.index.compositeindex.datacube.startree.builder.BuilderTestsUtils.getSortedNumericMock;
        Map<String, DocValuesProducer> fieldProducerMap = Map.of("field1", d1vp, "field3", d2vp, "field2", m1vp);
            36L,
        List<Integer> metricsWithField = List.of(0, 1, 2, 3, 4, 5);
            List.of(new SequentialDocValuesIterator(m1sndv), new SequentialDocValuesIterator(m2sndv))
        // Setup the star tree field with dimensions and metrics  
         [1655287920000, 1655287200000, 1655287200000, 4] | [40.0, 1]
        SortedSetStarTreeValuesIterator d2sndv = new SortedSetStarTreeValuesIterator(getSortedSetMock(dimList2, docsWithField2));  
         [0, 0] | [0.0, 1]  
        );
            getLongFromDouble(0.0),
            87400000000L,
package org.opensearch.index.compositeindex.datacube.startree.builder;
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
            );
            mock(IndexInput.class),
         [-1, -1] | [10.0, 1]
        docValuesConsumer.close();  
        writeState = getWriteState(6, writeState.segmentInfo.getId());  
            getLongFromDouble(50.0)  
        List<Integer> docsWithField = IntStream.range(0, 20).boxed().collect(Collectors.toList());  
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
        Metric m1 = new Metric("field2", List.of(MetricStat.SUM));
        return new StarTreeField("sf", dims, metrics, c);  
         [-9223372036854775807, -9223372036854775807] | [50.0, 1]  
            builder.getRootNode(),
            88100000000L,
            getLongFromDouble(503L),
        Metric m1 = new Metric("field2", List.of(MetricStat.SUM));  
        docValues.put("field3", new DimensionConfig(DocValuesType.SORTED_SET, DimensionDataType.LONG));  
            } else {
            404L,
            301L,
            docValues,
        map.put("field1", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
            Set.of(),
            503L,  
        );  
        List<Long> timestampList = List.of(
        List<Integer> metricsWithField = List.of(0, 1, 2, 3, 4, 5);  
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,  
            1000,
        List<Dimension> dims = List.of(d1, d2);
