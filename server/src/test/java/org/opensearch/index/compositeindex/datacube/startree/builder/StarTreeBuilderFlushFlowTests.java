            VERSION_CURRENT,
            getLongFromDouble(301L),
        );
import org.apache.lucene.index.SegmentWriteState;
        List<Integer> docsWithField = List.of(0, 1, 3, 4, 5);
            404L,
            StarTreeDocument starTreeDocument = starTreeDocumentIterator.next();
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
        );
            86400000000L,
            getLongFromDouble(30.0),
        List<Integer> metricsWithField = new ArrayList<>(100);
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
        List<Long> dimList = List.of(1655288152000L, 1655288092000L, 1655288032000L, 1655287972000L, 1655288092000L);
        /**
        compositeField = new StarTreeField("sf", dims, metrics, c);
                assertEquals(expectedSumMetrics[count], ((CompensatedSum) starTreeDocument.metrics[0]).value(), 0);
import org.opensearch.search.aggregations.metrics.CompensatedSum;
            getLongFromDouble(20.0),
            "sf",
        int count = 0;
        validateStarTree(builder.getRootNode(), 5, 1, builder.getStarTreeDocuments());
        );
import java.util.Set;
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
                new NumericDimension("field3"),
        List<Integer> docsWithField = List.of(0, 1, 2, 3, 4, 5);
            docsWithField.add(i);
import java.util.stream.Collectors;
        SequentialDocValuesIterator[] dimDvs = {
        List<Long> dimList2 = List.of(0L, 1L, 2L, 3L, 4L, 5L);
        );
         [-9223372036854775807, -9223372036854775807] | [50.0, 1]
        List<Integer> metricsWithField = List.of(0, 1, 2, 3, 4, 5);
        return new EmptyDocValuesProducer() {
            docValues,
        StarTreeFieldConfiguration c = new StarTreeFieldConfiguration(1, new HashSet<>(), getBuildMode());
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitRounding;
        builder.build(fieldProducerMap, new AtomicInteger(), docValuesConsumer);
            mock(IndexInput.class),
        List<Long> metricsList = List.of(
        // Create lists to hold the dimension and metric values from the log data
                matchingIndices.removeIf(i -> {
        Map<String, DocValuesProducer> fieldProducerMap = Map.of("field1", d1vp, "field3", d2vp, "field2", m1vp);
            38L,
            0,
        SortedNumericStarTreeValuesIterator sizeIter = new SortedNumericStarTreeValuesIterator(
            getLongFromDouble(500L),
        );
        assertNull(rootDoc.dimensions[0]);
        );
        StarTreeMetadata starTreeMetadata = new StarTreeMetadata(
            36L,
        // builder.getStarTreeDocuments().size(),
            { -1L, -1L },
            builder.getRootNode(),
                );
 * The OpenSearch Contributors require contributions made to
        LinkedHashMap<String, DimensionConfig> docValues = new LinkedHashMap<>();
        List<Long> dimList = new ArrayList<>(100);
        for (StarTreeDocument starTreeDocument : starTreeDocuments) {
            assertEquals(
        List<Dimension> dims = List.of(d1, d2);
                    return monthRoundedTimestamp != doc.dimensions[4];
            500L,
            consumerWriteState,
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
            getBuildMode(),
            getLongFromDouble(10.0),
        );
        };
            33L,
            200L,
            503L,
            getLongFromDouble(503L),
        SequentialDocValuesIterator[] dimDvs = { new SequentialDocValuesIterator(d1sndv), new SequentialDocValuesIterator(d2sndv) };
        List<Long> dimList2 = List.of(0L, 1L, 2L, 3L, 4L, 5L);
            List.of(
        StarTreeMetadata starTreeMetadata = new StarTreeMetadata(
        assertNull(rootDoc.dimensions[3]);
        long expectedCountMetric = 1L;
package org.opensearch.index.compositeindex.datacube.startree.builder;
            getSortedNumericMock(metricsList, metricsWithField)
import org.opensearch.index.compositeindex.datacube.OrdinalDimension;
        SortedSetStarTreeValuesIterator d1sndv = new SortedSetStarTreeValuesIterator(getSortedSetMock(dimList, docsWithField));
        );
            getLongFromDouble(0.0),
import org.apache.lucene.index.EmptyDocValuesProducer;
import org.opensearch.common.time.DateUtils;
            0,
 *
                matchingIndices.removeIf(i -> {
        assertEquals(6, count);
            getSortedNumericMock(dimList2, docsWithField2)
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
                assertEquals(expectedSortedDimensions[count][0], dim1);
import org.apache.lucene.index.DocValuesType;
        Dimension d2 = isIp ? new IpDimension("field3") : new OrdinalDimension("field3");
            getLongFromDouble(50.0)
import static org.opensearch.index.compositeindex.datacube.startree.builder.BuilderTestsUtils.getSortedNumericMock;
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
         [1655288100000, 1655287200000, 1655287200000, 0] | [0.0, 1]
        List<Integer> docsWithField = IntStream.range(0, 20).boxed().collect(Collectors.toList());
        validateStarTreeFileFormats(
                0
        List<StarTreeDocument> starTreeDocuments = builder.getStarTreeDocuments();
            34L,
import org.opensearch.index.compositeindex.datacube.startree.utils.SequentialDocValuesIterator;
        List<Long> dimList2 = List.of(5L, 4L, 3L, 2L, 1L, 0L);
        assertEquals(59, starTreeDocuments.size());
        List<Integer> docsWithField = List.of(0, 1, 3, 4, 5);
            getSortedNumericMock(metricsList, metricsWithField)
            301L,
            "sf",
        SequentialDocValuesIterator[] dimDvs = { new SequentialDocValuesIterator(d1sndv), new SequentialDocValuesIterator(d2sndv) };
         [3, 3] | [30.0, 1]
        Metric m1 = new Metric("field2", List.of(MetricStat.SUM));
            404L,
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(
            getLongFromDouble(50.0),
            6,
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
import org.opensearch.index.compositeindex.datacube.startree.fileformats.meta.DimensionConfig;
            503L,
        validateStarTreeFileFormats(
            32L,
            32L,
import org.apache.lucene.search.DocIdSetIterator;
import org.opensearch.index.compositeindex.datacube.Metric;
        SortedNumericDocValues d2sndv = getSortedNumericMock(dimList2, docsWithField2);
            new StarTreeFieldConfiguration(1, Set.of("field1"), getBuildMode())
                        ? starTreeDocument.dimensions[1] * 1 * 10.0
            "sf",
        // Build star tree
        validateStarTree(builder.getRootNode(), 2, 1000, builder.getStarTreeDocuments());
            // Assert
            builder.getStarTreeDocuments()
            1000,
        );
         [4, 4] | [40.0, 1]
import java.time.temporal.ChronoField;
        List<Long> dimList = List.of(0L, -1L, 9223372036854775806L, 4987L, -9223372036854775807L);
            List.of(new Metric("field2", List.of(MetricStat.SUM, MetricStat.VALUE_COUNT, MetricStat.AVG))),
            assertEquals(matchingIndices.size(), (long) (doc.metrics[1]));
            }
            getLongFromDouble(200L),
            6,
            getLongFromDouble(301L),
        compositeField = new StarTreeField(
        );
            );
            getBuildMode(),
            dimDvs,
                assertEquals(starTreeDocument.dimensions[1] * 10.0, ((CompensatedSum) starTreeDocument.metrics[0]).value(), 0);
        SortedNumericStarTreeValuesIterator d1sndv = new SortedNumericStarTreeValuesIterator(getSortedNumericMock(dimList, docsWithField));
        SortedNumericStarTreeValuesIterator m1sndv = new SortedNumericStarTreeValuesIterator(
            getLongFromDouble(15.0),
        validateStarTree(builder.getRootNode(), 3, 10, builder.getStarTreeDocuments());
        );
        compositeField = getStarTreeFieldWithDateDimension();
        List<Long> metricsList = List.of(
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
         [4, 4] | [40.0, 1]
        List<Metric> metrics = List.of(m1, m2, m3);
            if (doc.dimensions[1] != null) {
            87200000000L,
        );
        builder.build(starTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
        assertEquals(13, count);
        );
        List<Integer> docsWithField2 = List.of(0, 1, 2, 3, 4, 5);
import org.opensearch.index.mapper.DateFieldMapper;
        validateStarTree(builder.getRootNode(), 2, 1000, builder.getStarTreeDocuments());
            getLongFromDouble(23.0),
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
            builder.getStarTreeDocuments().size(),
         [1655287980000, 1655287200000, 1655287200000, 3] | [30.0, 1]
            87900000000L,
                        ? starTreeDocument.dimensions[1] * 1 * 10.0
            if (count <= 6) {
        SortedNumericStarTreeValuesIterator m1sndv = new SortedNumericStarTreeValuesIterator(
         [null, null, null, 2] | [20.0, 1]
        );
        Metric m3 = new Metric("field2", List.of(MetricStat.AVG));
            mock(IndexInput.class),
            if (starTreeDocument.dimensions[1] != null) {
        SortedNumericStarTreeValuesIterator m1sndv = new SortedNumericStarTreeValuesIterator(
        }
        metaOut.close();
            6,
            getLongFromDouble(81.0),
            39L,
        starTreeDocumentIterator.forEachRemaining(starTreeDocumentsList::add);
         [1655288040000, 1655287200000, 1655287200000, 5] | [50.0, 1]
            if (doc.dimensions[4] != null) {
            87300000000L,
        return new StarTreeField("sf", dims, metrics, c);
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
        /**
                matchingIndices.removeIf(i -> !sizeDimList.get(i).equals(doc.dimensions[2]));
            { 4987L, 4987L },
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
            getLongFromDouble(200L),
            builder.numStarTreeNodes,
            }
            new SequentialDocValuesIterator(clientIpIter),
        SortedNumericStarTreeValuesIterator d1sndv = new SortedNumericStarTreeValuesIterator(getSortedNumericMock(dimList, docsWithField));
         [null, 2] | [20.0, 1]
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
        builder.setFlushSortedSetDocValuesMap(dv);
            if (doc.dimensions[0] != null) {
public class StarTreeBuilderFlushFlowTests extends StarTreeBuilderTestCase {
    public void testFlushFlowWithTimestamps() throws IOException {
        // TODO: Fix this post 2.19 [Handling search for unsigned-long as part of star-tree]
            getLongFromDouble(404L),
            503L,
        dv.put("field1", getSortedSetMock(dimList, docsWithField));
        StarTreeMetadata starTreeMetadata = new StarTreeMetadata(
            4096, /* Lucene90DocValuesFormat#DEFAULT_SKIP_INDEX_INTERVAL_SIZE */
            getLongFromDouble(60.0),
            }
            87000000000L,
        intervals.add(new DateTimeUnitAdapter(Rounding.DateTimeUnit.MONTH_OF_YEAR));
        Metric m2 = new Metric("field2", List.of(MetricStat.VALUE_COUNT));
        // builder.getStarTreeDocuments()
    }
                    assertEquals(count, (long) starTreeDocument.dimensions[0]);
        List<Long> metricsList = new ArrayList<>(100);
        List<Long> statusMetricsList = List.of(
        Metric m1 = new Metric("field2", List.of(MetricStat.SUM));
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
        // and match against the resultant metric
        );
        );
            builder.getStarTreeDocuments().size(),
                    // Match if either day or month rounding matches
            docValues,
        // validateStarTreeFileFormats(
        // We will filter documents that match status = 200 and size = 4635400285215260672 and perform sum in java
            404L,
    public void testFlushFlowBuild() throws IOException {
            count++;
            32L,
        List<StarTreeDocument> starTreeDocuments = builder.getStarTreeDocuments();
         [0, 0] | [0.0]
        }
            VERSION_CURRENT,
        /**
            { -9223372036854775807L, -9223372036854775807L },
                return sndv;
            36L,
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
        docValuesConsumer.close();
            200L,
            getSortedNumericMock(metricsList, metricsWithField)
        }
            getLongFromDouble(50.0)
        SortedNumericStarTreeValuesIterator d1sndv = new SortedNumericStarTreeValuesIterator(getSortedNumericMock(dimList, docsWithField));
        );
        DocValuesProducer d2vp = getDocValuesProducer(d2sndv);
            87800000000L,
        intervals.add(new DateTimeUnitAdapter(Rounding.DateTimeUnit.DAY_OF_MONTH));
        );
        writeState = getWriteState(6, writeState.segmentInfo.getId());
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
import org.opensearch.common.Rounding;
            Set.of(),
 * compatible open source license.
            0,
        }
        assertEquals(13, count);
                matchingIndices.removeIf(i -> !clientIpDimList.get(i).equals(doc.dimensions[1]));
        Metric m2 = new Metric("field2", List.of(MetricStat.VALUE_COUNT));
        // );
            getSortedNumericMock(timestampList, docsWithField)
        Dimension d1 = new NumericDimension("field1");
            39L
         [null, 2] | [20.0, 1]
        );
        Metric m1 = new Metric("field2", List.of(MetricStat.SUM));
            Set.of(),
        );
            getLongFromDouble(301L),
            mock(IndexInput.class),
         [5, 5] | [50.0, 1]
        List<Long> dimList = List.of(0L, 1L, 3L, 4L, 5L);
            87100000000L,
            writeState,
        SortedNumericStarTreeValuesIterator clientIpIter = new SortedNumericStarTreeValuesIterator(
            List.of(new SequentialDocValuesIterator(m1sndv), new SequentialDocValuesIterator(m2sndv))
        List<Dimension> dims = List.of(d1, d2);
        Dimension d1 = new NumericDimension("field1");
            getLongFromDouble(81.0),
        List<Long> dimList2 = List.of(0L, 1L, 2L, 3L, 4L, 5L);
        docValues.put("field3", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
            264
            // Filter by timestamp day if not null
    }
                );
                        : starTreeDocument.dimensions[0] * 10,
    public void testFlushFlowAggregatedDocs() throws IOException {
        List<Integer> metricsWithField = List.of(0, 1, 2, 3, 4, 5);
        List<Integer> metricsWithField = List.of(0, 1, 2, 3, 4, 5);
        assertEquals(7432.0, ((CompensatedSum) rootDoc.metrics[0]).value(), 0);
                assertEquals(1L, starTreeDocument.metrics[1]);
            // Filter by clientip if not null
        StarTreeFieldConfiguration c = new StarTreeFieldConfiguration(1000, new HashSet<>(), getBuildMode());
        LinkedHashMap<String, DimensionConfig> docValues = new LinkedHashMap<>();
        List<Metric> metrics = List.of(m1, m2, m3);
                matchingIndices.removeIf(i -> !statusDimList.get(i).equals(doc.dimensions[0]));
         [3, 3] | [30.0]
        );
        SortedNumericStarTreeValuesIterator m2sndv = new SortedNumericStarTreeValuesIterator(
        // Process documents
        int count = 0;
import org.apache.lucene.codecs.DocValuesProducer;
         [2, 2] | [20.0, 1]
            }
        SortedNumericStarTreeValuesIterator d1sndv = new SortedNumericStarTreeValuesIterator(getSortedNumericMock(dimList, docsWithField));
        List<Long> dimList = List.of(5L, 4L, 3L, 2L, 1L);
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
         */
                starTreeDocument.dimensions[1] != null ? starTreeDocument.dimensions[1] * 10.0 : 49500.0,
import org.opensearch.index.codec.composite.composite912.Composite912DocValuesFormat;
            "sf",
        Dimension d2 = new NumericDimension("field3");
        List<Long> clientIpDimList = List.of(
        List<Integer> docsWithField = List.of(0, 1, 3, 4, 5);
        for (int i = 0; i < 100; i++) {
        validateStarTree(builder.getRootNode(), 2, 1, builder.getStarTreeDocuments());
        );
        // Create document value iterators
        Metric m3 = new Metric("field2", List.of(MetricStat.AVG));
            builder.getStarTreeDocuments()
            List<Integer> matchingIndices = IntStream.range(0, statusDimList.size()).boxed().collect(Collectors.toList());
            getLongFromDouble(10.0),
    }
        validateStarTree(builder.getRootNode(), 2, 1000, builder.getStarTreeDocuments());
            STAR_TREE,
        );
        for (int i = 0; i < 100; i++) {
        );
import org.opensearch.index.compositeindex.datacube.startree.StarTreeDocument;
        Dimension d1 = new UnsignedLongDimension("field1");
        SortedSetStarTreeValuesIterator d2sndv = new SortedSetStarTreeValuesIterator(getSortedSetMock(dimList2, docsWithField2));
        // Initialize builder
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
        compositeField = getStarTreeFieldWithUnsignedLongField();
            getLongFromDouble(40.0),
                assertEquals(6L, starTreeDocument.metrics[1]);
    private StarTreeField getStarTreeFieldWithKeywordField(boolean isIp) {
            dimDvs,
            List.of(new Metric("field2", List.of(MetricStat.SUM, MetricStat.VALUE_COUNT, MetricStat.AVG))),
            getLongFromDouble(50.0),
                    long dayRoundedTimestamp = DateUtils.roundFloor(
            200L,
            getLongFromDouble(0.0),
        );
         [5, 5] | [50.0, 1]
            getLongFromDouble(50.0),
        );
        List<Dimension> dims = List.of(d1, d2);
        SequentialDocValuesIterator[] dimDvs = { new SequentialDocValuesIterator(d1sndv), new SequentialDocValuesIterator(d2sndv) };
        writeState = getWriteState(6, writeState.segmentInfo.getId());
                .sum();
        double[] expectedSumMetrics = { 0.0, 40.0, 30.0, 50.0, 10.0, 20.0 };
            dimDvs,
                assertEquals(6L, starTreeDocument.metrics[1]);
            @Override
            35L,
import java.io.IOException;
            count++;
            w,
        int count = 0;
        StarTreeMetadata starTreeMetadata = getStarTreeMetadata(map, 100, 1, 6699);
            4096, /* Lucene90DocValuesFormat#DEFAULT_SKIP_INDEX_INTERVAL_SIZE */
        builder.appendDocumentsToStarTree(starTreeDocumentIterator);
        assertNull(rootDoc.dimensions[2]);
                    );
    public void testFlushFlowForKeywords() throws IOException {
            32L,
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
import org.apache.lucene.index.FieldInfo;
import org.apache.lucene.store.IndexInput;
         [null, 0] | [0.0, 1]
            getSortedNumericMock(metricsList, metricsWithField)
                assertEquals(1L, starTreeDocument.metrics[1]);
        dataOut.close();
            getSortedNumericMock(clientIpDimList, docsWithField)
         [1655287920000, 1655287200000, 1655287200000, 4] | [40.0, 1]
            getLongFromDouble(50.0),
            builder.getRootNode(),
         [1, 1] | [10.0, 1]
                assertEquals(150D, ((CompensatedSum) starTreeDocument.metrics[0]).value(), 0);
            }
                assertEquals(
                    starTreeDocument.dimensions[0] == null
        SortedNumericStarTreeValuesIterator m1sndv = new SortedNumericStarTreeValuesIterator(
        Metric m1 = new Metric("field2", List.of(MetricStat.SUM));
            }
            writeState,
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
            STAR_TREE,
        );
            builder.getRootNode(),
            getLongFromDouble(20.0),
         ....
            if (count < 6) {
        metaOut.close();
            4096, /* Lucene90DocValuesFormat#DEFAULT_SKIP_INDEX_INTERVAL_SIZE */
        List<DateTimeUnitRounding> intervals = new ArrayList<>();
        SortedNumericStarTreeValuesIterator m2sndv = new SortedNumericStarTreeValuesIterator(
            }
            builder.numStarTreeDocs,
        dataOut.close();
        SortedNumericStarTreeValuesIterator m2sndv = new SortedNumericStarTreeValuesIterator(
            getLongFromDouble(10.0),
        builder.build(starTreeDocumentsList.iterator(), new AtomicInteger(), docValuesConsumer);
            87600000000L,
            getLongFromDouble(60.0),
            List.of(new Metric("field2", List.of(MetricStat.SUM, MetricStat.VALUE_COUNT, MetricStat.AVG))),
            getLongFromDouble(15.0)
         [3, 3] | [30.0, 1]
        }
        List<Integer> docsWithField2 = List.of(0, 1, 2, 3, 4, 5);
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitAdapter;
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
            }
                        timestamp,
        docValuesConsumer.close();
            1000,
        for (StarTreeDocument starTreeDocument : starTreeDocuments) {
            getLongFromDouble(404L),
            // Filter by timestamp month if not null
         Asserting following dim / metrics [ dim1, dim2 / Sum [metric], count [metric] ]
        );
            getSortedNumericMock(dimList2, docsWithField2)
        dataOut.close();
        Dimension d1 = isIp ? new IpDimension("field1") : new OrdinalDimension("field1");
import org.opensearch.index.compositeindex.datacube.NumericDimension;
        );
            getSortedNumericMock(statusMetricsList, docsWithField)
        List<Dimension> dims = List.of(d1, d2);
        );
        metaOut.close();
            builder.getStarTreeDocuments()
            count++;
                        ChronoField.DAY_OF_MONTH.getBaseUnit().getDuration().toMillis()
        SortedNumericStarTreeValuesIterator d2sndv = new SortedNumericStarTreeValuesIterator(
            264
        builder.build(starTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
        );
        Map<String, SortedSetDocValues> dv = new LinkedHashMap<>();
            36L,
            { 0L, 0L },
            "sf",
                Long dim1 = starTreeDocument.dimensions[0];
            getSortedNumericMock(metricsList, metricsWithField)
        List<Integer> docsWithField2 = new ArrayList<>(100);
                assertEquals(expectedCountMetric, starTreeDocument.metrics[1]);
            getLongFromDouble(404L),
            List.of(new SequentialDocValuesIterator(m1sndv), new SequentialDocValuesIterator(m2sndv))
        // For example : [200, null, 4635400285215260672, null, null] | [1000.0 0.0]
        Dimension d2 = new UnsignedLongDimension("field3");
            getLongFromDouble(20.0),
            metricsList.add(getLongFromDouble(i * 10.0));
        SortedNumericStarTreeValuesIterator timestampIter = new SortedNumericStarTreeValuesIterator(
            34L,
        );
            getSortedNumericMock(metricsList, metricsWithField)
/*
            dimList2.add((long) i);
 * SPDX-License-Identifier: Apache-2.0
import java.util.ArrayList;
        );
            assertEquals(1L, starTreeDocument.metrics[0]);
                }
                new NumericDimension("field1"),
        map.put("field1", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
            STAR_TREE,
            4096, /* Lucene90DocValuesFormat#DEFAULT_SKIP_INDEX_INTERVAL_SIZE */
import static org.opensearch.index.compositeindex.datacube.startree.fileformats.StarTreeWriter.VERSION_CURRENT;
    }
        List<Integer> metricsWithField = List.of(0, 1, 2, 3, 4, 5);
         */
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
         [0, 0] | [0.0, 1]
            getLongFromDouble(503L),
}
    }
            getLongFromDouble(0.0)
         */
            docValues,
 * this file be licensed under the Apache-2.0 license or a
            getLongFromDouble(10.0),
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
import org.opensearch.index.compositeindex.datacube.IpDimension;
            starTreeMetadata,
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;
            docsWithField2.add(i);
        builder.build(starTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
        LinkedHashMap<String, DimensionConfig> docValues = new LinkedHashMap<>();
    }
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
import org.opensearch.index.compositeindex.datacube.Dimension;
        for (StarTreeDocument doc : starTreeDocuments) {
        dataOut.close();
        SortedNumericStarTreeValuesIterator statusMetricsList1 = new SortedNumericStarTreeValuesIterator(
        DocValuesProducer m1vp = getDocValuesProducer(m1sndv);
            4096,
            getLongFromDouble(20.0),
            86700000000L,
            getLongFromDouble(30.0),
        docValues.put("field3", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.UNSIGNED_LONG));
        List<Long> timestampList = List.of(
            getLongFromDouble(500L),
        return new StarTreeField("sf", dims, metrics, c);
                if (starTreeDocument.dimensions[0] != null) {
        validateStarTreeFileFormats(
        List<Long> metricsList = List.of(
        );
            getLongFromDouble(20.0),
        List<StarTreeDocument> starTreeDocuments = builder.getStarTreeDocuments();
import java.util.HashSet;
            86500000000L,
        );
            getLongFromDouble(81.0),
    }
    private StarTreeField getStarTreeFieldWithMultipleMetrics() {
        List<Long> dimList2 = List.of(0L, -1L, 2L, 9223372036854775806L, 4987L, -9223372036854775807L);
    public void testFlushFlowDimsReverse() throws IOException {
            }
        SequentialDocValuesIterator[] dimDvs = { new SequentialDocValuesIterator(d1sndv), new SequentialDocValuesIterator(d2sndv) };
            264
        StarTreeMetadata starTreeMetadata = new StarTreeMetadata(
            86600000000L,
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
            starTreeMetadata,
            getLongFromDouble(40.0),
import java.util.Iterator;
            builder.getStarTreeDocuments().size(),
         * Asserting following dim / metrics [ dim1, dim2 / Sum [metric], count [metric] ]
            // Filter by status if not null
import static org.opensearch.index.compositeindex.datacube.startree.builder.BuilderTestsUtils.getSortedSetMock;
        List<StarTreeDocument> starTreeDocuments = builder.getStarTreeDocuments();
            getLongFromDouble(15.0),
            writeState,
        StarTreeFieldConfiguration c = new StarTreeFieldConfiguration(1000, new HashSet<>(), getBuildMode());
         [null, 1] | [10.0]
            36L,
            getLongFromDouble(0.0),
            200L,
                .mapToDouble(i -> NumericUtils.sortableLongToDouble(statusMetricsList.get(i)))
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
import java.util.Map;
            getLongFromDouble(40.0),
import org.opensearch.index.compositeindex.datacube.UnsignedLongDimension;
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(
            getLongFromDouble(30.0),
        List<Long> dimList2 = new ArrayList<>(100);
        /**
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, getWriteState(6, writeState.segmentInfo.getId()), mapperService);
            metricsWithField.add(i);
            getLongFromDouble(30.0),
        }
        writeState = getWriteState(6, writeState.segmentInfo.getId());
        Metric m3 = new Metric("field2", List.of(MetricStat.AVG));
                });
                    0
            Set.of(),
                    ((CompensatedSum) starTreeDocument.metrics[0]).value(),
            { null, 2L } };
        int count = 0;
import static org.opensearch.index.compositeindex.datacube.startree.builder.BuilderTestsUtils.validateStarTree;
    public void testFlushFlow() throws IOException {
        writeState = getWriteState(100, writeState.segmentInfo.getId());
        List<Long> metricsList = List.of(
        );
        );
         [2, 2] | [20.0]
            getLongFromDouble(50.0),
         [0, 0] | [0.0, 1]
        List<Long> statusDimList = List.of(
            getLongFromDouble(40.0),
import java.util.concurrent.atomic.AtomicInteger;
            } else {
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
        docValuesConsumer.close();
            List.of(new SequentialDocValuesIterator(m1sndv), new SequentialDocValuesIterator(m2sndv))
         * Asserting following dim / metrics [ dim1, dim2 / Sum [metric], count [metric] ]
        super(buildMode);
            1000,
        docValues.put("field1", new DimensionConfig(DocValuesType.SORTED_SET, DimensionDataType.LONG));
        List<Long> dimList = List.of(0L, 1L, 2L, 3L, 4L, 5L);
        SortedNumericDocValues m1sndv = getSortedNumericMock(metricsList, metricsWithField);
         [2, 2] | [20.0, 1]
            getSortedNumericMock(metricsList, metricsWithField)
        );
            builder.numStarTreeDocs,
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(
            39L,
        builder.build(starTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
            } else {
        docValues.put("field1", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.UNSIGNED_LONG));
        return new StarTreeField("sf", dims, metrics, c);
        metaOut.close();
            404L,
        validateStarTreeFileFormats(
         [4, 4] | [40.0]
            ),
        docValues.put("field3", new DimensionConfig(DocValuesType.SORTED_SET, DimensionDataType.LONG));
            builder.numStarTreeNodes,
        SortedNumericStarTreeValuesIterator d2sndv = new SortedNumericStarTreeValuesIterator(
            { 9223372036854775806L, 9223372036854775806L },
import org.apache.lucene.index.SortedSetDocValues;
            starTreeMetadata,
        );
         [1, 1] | [10.0, 1]
        docValuesConsumer.close();
            dimDvs,
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(
        /**
        SortedNumericDocValues d1sndv = getSortedNumericMock(dimList, docsWithField);
         [0, 0] | [0.0, 1]
            200L,
        );
            builder.getStarTreeDocuments().size(),
            public SortedNumericDocValues getSortedNumeric(FieldInfo field) throws IOException {
        SegmentWriteState w = getWriteState(DocIdSetIterator.NO_MORE_DOCS, writeState.segmentInfo.getId());
import org.apache.lucene.util.NumericUtils;
            404L
            88300000000L
    private StarTreeField getStarTreeFieldWithUnsignedLongField() {
        dv.put("field3", getSortedSetMock(dimList2, docsWithField2));
        // Setup the star tree field with dimensions and metrics
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
            500L,
import org.opensearch.index.codec.composite.LuceneDocValuesConsumerFactory;
import org.opensearch.index.compositeindex.datacube.DimensionDataType;
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
            List.of(new SequentialDocValuesIterator(m1sndv), new SequentialDocValuesIterator(m2sndv))
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
            writeState,
        docValues.put("field1", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
            getLongFromDouble(50.0)
                assertEquals(
import org.opensearch.index.compositeindex.datacube.startree.fileformats.meta.StarTreeMetadata;
            builder.getRootNode(),
            301L,
                assertEquals(expectedSortedDimensions[count][1], dim2);
            builder.getStarTreeDocuments()
        builder.build(starTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
            VERSION_CURRENT,
        starTreeDocumentIterator = starTreeDocumentsList.iterator();
        List<Integer> docsWithField2 = List.of(0, 1, 2, 3, 4, 5);
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedNumericStarTreeValuesIterator;
    }
            39L,
        Object[][] expectedSortedDimensions = {
        // builder.getRootNode(),
        for (StarTreeDocument starTreeDocument : starTreeDocuments) {
            List.of(new SequentialDocValuesIterator(m1sndv), new SequentialDocValuesIterator(m2sndv))
            getLongFromDouble(200L),
            264
        assertEquals(6, builder.getStarTreeDocuments().size());
        SortedNumericStarTreeValuesIterator d2sndv = new SortedNumericStarTreeValuesIterator(
            301L,
        docValuesConsumer.close();
            500L,
        );
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
        List<Integer> metricsWithField = List.of(0, 1, 2, 3, 4, 5);
            getBuildMode(),
            getLongFromDouble(50.0)
        SortedNumericStarTreeValuesIterator m2sndv = new SortedNumericStarTreeValuesIterator(
        DocValuesProducer d1vp = getDocValuesProducer(d1sndv);
        metaOut.close();
        docValues.put("field1", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
            1000,
        List<Long> metricsList = List.of(
        }
         [1, 1] | [10.0]
        docValues.put("field3", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
                count++;
import org.opensearch.index.compositeindex.datacube.DateDimension;
        SortedNumericStarTreeValuesIterator statusIter = new SortedNumericStarTreeValuesIterator(
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
            86800000000L,
            getLongFromDouble(23.0),
            38L,
            87700000000L,
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(
            getLongFromDouble(200L),
        map.put("field3", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(
         */
            Set.of(),
            getSortedNumericMock(metricsList, metricsWithField)
                    long timestamp = timestampList.get(i);
            getSortedNumericMock(sizeDimList, docsWithField)
        SequentialDocValuesIterator[] dimDvs = { new SequentialDocValuesIterator(d1sndv), new SequentialDocValuesIterator(d2sndv) };
    }
import org.opensearch.index.compositeindex.datacube.MetricStat;
         * Asserting following dim / metrics [ dim1, dim2 / Sum [metric], count [metric] ]
        List<Metric> metrics = List.of(m1);
        StarTreeDocument rootDoc = starTreeDocuments.getLast();
            getLongFromDouble(81.0),
                new DateDimension("field7", intervals, DateFieldMapper.Resolution.MILLISECONDS)
            getSortedNumericMock(metricsList, metricsWithField)
import static org.mockito.Mockito.mock;
        );
            if (doc.dimensions[3] != null) {
        dataOut.close();
        List<Integer> docsWithField = List.of(0, 1, 2, 3, 4);
                assertEquals(150D, ((CompensatedSum) starTreeDocument.metrics[0]).value(), 0);
            builder.numStarTreeDocs,
            getSortedNumericMock(metricsList, metricsWithField)
                ((CompensatedSum) starTreeDocument.metrics[0]).value(),
        );
            new SequentialDocValuesIterator(statusIter),
            getLongFromDouble(0.0),
        int count = 0;
            new SequentialDocValuesIterator(sizeIter),
    public StarTreeBuilderFlushFlowTests(StarTreeFieldConfiguration.StarTreeBuildMode buildMode) {
            getLongFromDouble(15.0),
            4096, /* Lucene90DocValuesFormat#DEFAULT_SKIP_INDEX_INTERVAL_SIZE */
        List<Integer> docsWithField = new ArrayList<>(100);
        List<StarTreeDocument> starTreeDocuments = builder.getStarTreeDocuments();
            500L,
        );
            getLongFromDouble(404L),
         */
            VERSION_CURRENT,
        dataOut.close();
            getLongFromDouble(40.0),
                assertEquals(1L, starTreeDocument.metrics[1]);
        List<Integer> docsWithField2 = List.of(0, 1, 2, 3, 4, 5);
import java.util.List;
         [1, 1] | [10.0, 1]
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
            getBuildMode(),
            getLongFromDouble(23.0),
         * Asserting following dim / metrics [ dim1, dim2 / Sum [metric], count [metric] ]
        // Validate results
            getLongFromDouble(30.0),
            dimList.add((long) i);
         [3, 3] | [30.0, 1]
        writeState = getWriteState(6, writeState.segmentInfo.getId());
        compositeField = getStarTreeFieldWithMultipleMetrics();
        SortedNumericStarTreeValuesIterator d2sndv = new SortedNumericStarTreeValuesIterator(
                Long dim2 = starTreeDocument.dimensions[1];
                new NumericDimension("field5"),
        Metric m2 = new Metric("field2", List.of(MetricStat.VALUE_COUNT));
import java.util.stream.IntStream;
            // Filter by size if not null
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
        }
            builder.numStarTreeDocs,
         [null, 0] | [0.0]
        for (StarTreeDocument starTreeDocument : starTreeDocuments) {
        List<Long> sizeDimList = List.of(
        LinkedHashMap<String, DimensionConfig> map = new LinkedHashMap<>();
            0,
        while (starTreeDocumentIterator.hasNext()) {
        assertNull(rootDoc.dimensions[1]);
            6,
            count++;
                    // Match if either day or month rounding matches
                    long timestamp = timestampList.get(i);
            }
        SortedNumericStarTreeValuesIterator m1sndv = new SortedNumericStarTreeValuesIterator(
 */
        LinkedHashMap<String, DimensionConfig> docValues = new LinkedHashMap<>();
        metaOut.close();
        );
            List.of(new Metric("field2", List.of(MetricStat.SUM, MetricStat.VALUE_COUNT, MetricStat.AVG))),
            87400000000L,
            if (starTreeDocument.dimensions[1] != null) {
    private static DocValuesProducer getDocValuesProducer(SortedNumericDocValues sndv) {
                    return doc.dimensions[3] != dayRoundedTimestamp;
            getLongFromDouble(60.0),
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedSetStarTreeValuesIterator;
import org.apache.lucene.index.SortedNumericDocValues;
            87500000000L,
         [4, 4] | [40.0, 1]
            38L,
         [-1, -1] | [10.0, 1]
    }
import static org.opensearch.index.mapper.CompositeMappedFieldType.CompositeFieldType.STAR_TREE;
            assertEquals(expectedSum, ((CompensatedSum) (doc.metrics[0])).value(), 0);
        /*
         ...
        docValuesConsumer.close();
         [1655288040000, 1655287200000, 1655287200000, 1] | [10.0, 1]
            getLongFromDouble(200L),
            86900000000L,
            getSortedNumericMock(dimList2, docsWithField2)
                    starTreeDocument.dimensions[0] == null
        compositeField = getStarTreeFieldWithMultipleMetrics();
            if (doc.dimensions[2] != null) {
        }
        );
                    ((CompensatedSum) starTreeDocument.metrics[0]).value(),
        SegmentWriteState consumerWriteState = getWriteState(DocIdSetIterator.NO_MORE_DOCS, writeState.segmentInfo.getId());
            builder.numStarTreeNodes,
        // starTreeMetadata,
        writeState = getWriteState(20, writeState.segmentInfo.getId());
            starTreeMetadata,
            getSortedNumericMock(dimList2, docsWithField2)
import org.opensearch.index.compositeindex.datacube.startree.StarTreeFieldConfiguration;
                    long monthRoundedTimestamp = DateUtils.roundMonthOfYear(timestamp);
        );
            getLongFromDouble(503L),
    }
            dimDvs,
        for (StarTreeDocument starTreeDocument : builder.getStarTreeDocuments()) {
    }
            88100000000L,
            getLongFromDouble(404L)
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
            new SequentialDocValuesIterator(timestampIter) };
            dimDvs,
        StarTreeFieldConfiguration c = new StarTreeFieldConfiguration(1000, new HashSet<>(), getBuildMode());
            List.of(new SequentialDocValuesIterator(statusMetricsList1))
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
         [4987, 4987] | [40.0, 1]
            getSortedNumericMock(statusDimList, docsWithField)
            88200000000L,
            mock(IndexInput.class),
        compositeField = getStarTreeFieldWithKeywordField(random().nextBoolean());
        );
                        : starTreeDocument.dimensions[0] * 10,
            double expectedSum = matchingIndices.stream()
import java.util.LinkedHashMap;
            36L,
                });
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
         [null, null] | [49500.0]
        );
        List<Integer> docsWithField2 = List.of(0, 1, 2, 3, 4, 5);
            assertEquals(starTreeDocument.dimensions[3] * 1 * 10.0, ((CompensatedSum) starTreeDocument.metrics[1]).value(), 0);
            getLongFromDouble(10.0),
         [9223372036854775806, 9223372036854775806] | [30.0, 1]
        Dimension d2 = new NumericDimension("field3");
            builder.numStarTreeNodes,
         * Asserting following dim / metrics [ dim1, dim2 / Sum [ metric] ]
            getLongFromDouble(81.0),
        validateStarTree(builder.getRootNode(), 2, 1000, builder.getStarTreeDocuments());
         */
        List<Metric> metrics = List.of(m1, m2, m3);
            writeState,
            List.of(new Metric("field2", List.of(MetricStat.SUM, MetricStat.VALUE_COUNT, MetricStat.AVG))),
        List<StarTreeDocument> starTreeDocumentsList = new ArrayList<>();
            getLongFromDouble(500L),
        SortedNumericStarTreeValuesIterator m2sndv = new SortedNumericStarTreeValuesIterator(
            docValues,
        assertEquals(13, count);
        );
        }
            STAR_TREE,
        );
            getLongFromDouble(15.0),
                    0
         [5, 5] | [50.0, 1]
        for (int i = 0; i < 100; i++) {
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
            88000000000L,
    public void testFlushFlowWithUnsignedLongDimensions() throws IOException {
        // Assert all documents by formulating the matching docs based on the value of resultant documents
            getLongFromDouble(500L),
