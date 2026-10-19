        validateStarTreeFileFormats(
        validateStarTreeFileFormats(
        SortedSetDocValues dimList2,
         * [6,-1] | [120.0]
            () -> new SortedNumericStarTreeValuesIterator(d4sndv)
         [null, 7] | [7]
        builder.appendDocumentsToStarTree(starTreeDocumentIterator);
            builder.getRootNode(),
            getAttributes(1000),
            getSortedSetMock(dimList4, docsWithField4),
            count++;
                docsWithField1.add(i * 5 + j);
        }
        }
        List<Integer> docsWithField4 = new ArrayList<>(500);
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
            builder.getStarTreeDocuments().size(),
        );
            getLongFromDouble(30.0),
        validateStarTreeFileFormats(
         [1, 1] | [1]
            metricsWithField.add(i);
        // TODO: Fix this post 2.19 [Handling search for unsigned-long as part of star-tree]
            compositeField,
            compositeField
        );
        compositeField = getStarTreeField(MetricStat.VALUE_COUNT);
        dimValueMap = new HashMap<>();
                if (Objects.equals(starTreeDocument.dimensions[0], 5L)) {
        List<Integer> metricsWithField2 = List.of(0, 1, 2, 3, 4);
        );
            builder.getStarTreeDocuments().size(),
    public void testMergeFlowForUnsignedLong() throws IOException {
        StarTreeMetadata starTreeMetadata = getStarTreeMetadata(map, 6, 1000, 264);
        List<Integer> docCountMetricsWithField = new ArrayList<>(100);
        List<Long> dimList3 = new ArrayList<>(500);
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
        );
         [1655288092000, 1655288092000, 1655288092000, 6] | [60.0, 6]
            getLongFromDouble(10.0),
            () -> new SortedNumericStarTreeValuesIterator(d1sndv),
            metricsList,
            }
        List<Long> metricsList = List.of(
            count++;
         [3, 3] | [3]
        ).build(new Mapper.BuilderContext(settings, new ContentPath()));
            "field3",
        Map<String, Supplier<StarTreeValuesIterator>> metricDocIdSetIterators = new LinkedHashMap<>();
import org.opensearch.index.compositeindex.datacube.startree.StarTreeFieldConfiguration;
        List<Integer> metricsWithField = List.of(0, 1, 2, 3, 4, 5, 6);
        );
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
        List<Long> metricsList = List.of(0L, 1L, 2L, 3L, 4L, 5L, 6L, -1L, -1L, -1L);
        List<Integer> metricsWithField2 = List.of(0, 1, 2, 3, 4);
            metricsWithField,
        }
 * this file be licensed under the Apache-2.0 license or a
            sf,
        StarTreeValues starTreeValues2 = getStarTreeValues(
        );
        compositeField = getStarTreeFieldWithDateDimension();
        int count = 0;
            for (int j = 0; j < 5; j++) {
            () -> new SortedNumericStarTreeValuesIterator(m2sndv)
        List<Integer> docsWithField2 = new ArrayList<>(1000);
                dimList3.add((long) i);
        List<Integer> docsWithField2 = List.of(0, 1, 2, 3, 4, 5, 6);
            }
        StarTreeField sf,
                if (starTreeDocument.dimensions[0] != null && starTreeDocument.dimensions[0] == 5) {
            sf,
            getLongFromDouble(20.0),
        List<Long> metricsList = List.of(0L, 1L, 2L, 3L, 4L, 5L, 6L);
        }
                } else if (starTreeDocument.dimensions[1] == null) {
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
                    assertEquals(starTreeDocument.dimensions[0] * 2, starTreeDocument.metrics[0]);
        metricDocIdSetIterators.put(
        List<Long> metricsList1 = List.of(
            metricsList.add(getLongFromDouble(i * 10.0));
            dimList1,
        List<Integer> docsWithField3 = new ArrayList<>(500);
        StarTreeValues starTreeValues = getStarTreeValues(
                    assertEquals(starTreeDocument.dimensions[1], starTreeDocument.metrics[0]);
        List<Long> metricsList2 = List.of(5L, 6L, 7L, 8L, 9L);
            getSortedNumericMock(metricsList2, metricsWithField2),
            builder.getStarTreeDocuments().size(),
        List<Integer> docsWithField4 = List.of(0, 1, 2, 3, 4);
                assertEquals(starTreeDocument.dimensions[0] * 20.0, ((CompensatedSum) starTreeDocument.metrics[0]).value(), 0);
            compositeField,
        Settings settings = Settings.builder().put(settings(org.opensearch.Version.CURRENT).build()).build();
         [0, 0] | [0]
        for (int i = 0; i < 500; i++) {
        List<Long> metricsList = List.of(
 * The OpenSearch Contributors require contributions made to
    private StarTreeValues getStarTreeValuesWithDates(
        validateStarTree(builder.getRootNode(), 2, 1000, builder.getStarTreeDocuments());
        );
        List<Integer> docsWithField3 = List.of(0, 1, 2, 3, 4);
        SortedNumericDocValues f2d3sndv = getSortedNumericMock(dimList3, docsWithField3);
        List<Integer> metricsWithField1 = new ArrayList<>(100);
            "6"
        SortedNumericDocValues dimList,
         */
        Map<Long, Double> dimValueMap = new HashMap<>();
        assertEquals(10, builder.getStarTreeDocuments().size());
        /**
        for (int i = 0; i < numDocs; i++) {
            "4"
            builder.getStarTreeDocuments()
        builder.build(starTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.mergeStarTrees(List.of(starTreeValues, starTreeValues2));
            if (count <= 10) {
        for (int i = 0; i < numDocs; i++) {
        validateStarTree(builder.getRootNode(), 4, compositeField.getStarTreeConfig().maxLeafDocs(), builder.getStarTreeDocuments());
            dimList4,
        assertEquals(10, builder.getStarTreeDocuments().size());
import java.util.HashSet;
         [1655287972000, 1655287972000, 1655287972000, 3] | [30.0, 3]
            docCountMetricsList,
        for (int i = 0; i < 500; i++) {
        }
            builder.getStarTreeDocuments().size(),
            metricsList,
        SortedNumericDocValues m1sndv = getSortedNumericMock(metricsList, metricsWithField);
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
            "field8",
            metricsList.add(getLongFromDouble(i * 10.0));
            getSortedNumericMock(dimList4, docsWithField4),
            metricsList.add(getLongFromDouble(i * 2));
        List<Integer> docsWithField1 = new ArrayList<>(1000);
        validateStarTreeFileFormats(
        metaOut.close();
            writeState,
         [8, 8] | [8]
        assertEquals(6, builder.getStarTreeDocuments().size());
        List<Long> actualDimensionValues = new ArrayList<>(numDocs);
        List<Integer> metricsWithField = new ArrayList<>(100);
        );
        SortedNumericDocValues f2d2sndv = getSortedNumericMock(dimList2, docsWithField2);
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
            builder.getStarTreeDocuments().size(),
         [0, 0] | [0]
                    assertEquals(7L, starTreeDocument.metrics[0]);
            metricsList.add(getLongFromDouble(i * 10.0));
         [6, 6] | [6]
import org.opensearch.index.compositeindex.datacube.MetricStat;
        );
        assertEquals(635, starTreeDocuments.size());
        validateStarTreeFileFormats(
        builder.build(starTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
        );
        }
        );
         */
        SortedNumericDocValues d2sndv = getSortedNumericMock(dimList2, docsWithField2);
        validateStarTreeFileFormats(
        StarTreeFieldConfiguration c = new StarTreeFieldConfiguration(1, new HashSet<>(), getBuildMode());
        List<Long> dimList1 = new ArrayList<>(numDocs);
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
        List<Long> metricsList1,
        List<Integer> docsWithField3 = List.of(0, 1, 3, 4);
    private StarTreeValues getStarTreeValuesWithKeywords(
        SortedNumericDocValues dimList2,
        );
         */
         [3, 3] | [3]
        List<Integer> docsWithField2 = List.of(0, 1, 2, 3, 4, 5, 6);
                    starTreeDocument.dimensions[0] != null ? starTreeDocument.dimensions[0] * 2 * 10.0 : 40.0,
        for (int i = 0; i < 500; i++) {
            f2dimDocIdSetIterators,
            docsWithField1,
        for (StarTreeDocument starTreeDocument : starTreeDocuments) {
        StarTreeMetadata starTreeMetadata = getStarTreeMetadata(map, 6, 1000, 264);
            "sf__doc_count_doc_count_metric",
            getSortedNumericMock(metricsList2, metricsWithField2),
    }
        List<Integer> metricsWithField = List.of(0, 1, 2, 3, 4, 5, 6);
         */
            docsWithField1,
        Map<String, Supplier<StarTreeValuesIterator>> f2dimDocIdSetIterators = Map.of(
         [8, 8] | [8]
            docsWithField3.add(i);
        for (int i = 0; i < 100; i++) {
         [1, 0, 5, 5] | [2700.0, 10]
        }
            "sf__doc_count_doc_count_metric",
        docValuesConsumer.close();
            builder.getStarTreeDocuments().size(),
            getAttributes(500),
            dimList4,
        Dimension d3 = new ReadDimension("field5", DocValuesType.SORTED_NUMERIC, DimensionDataType.UNSIGNED_LONG);
            starTreeMetadata,
            compositeField,
            writeState,
        dataOut.close();
    }
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;
        /**
        List<Long> dimList3 = new ArrayList<>(500);
        );
        );
            dimList1,
         * Asserting following dim / metrics [ dim1, dim2 / Count [ metric] ]
            builder.getRootNode(),
                assertEquals(starTreeDocument.dimensions[1], starTreeDocument.metrics[0]);
        List<Integer> docsWithField3 = List.of(0, 1, 3, 4);
        }
        writeState = getWriteState(4, writeState.segmentInfo.getId());
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
            getLongFromDouble(50.0),
        for (int i = 0; i < 500; i++) {
        SortedNumericDocValues d1sndv = getSortedNumericMock(dimList1, docsWithField1);
        Map<String, Supplier<StarTreeValuesIterator>> metricDocIdSetIterators = Map.of(
            getLongFromDouble(0.0),
        List<Long> dimList4 = List.of(5L, 6L, 7L, 8L, -1L);
import org.apache.lucene.index.SortedNumericDocValues;
        }
        }
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
            getSortedNumericMock(metricsList, metricsWithField),
        validateStarTree(builder.getRootNode(), 2, 1000, builder.getStarTreeDocuments());
            "field2",
            getLongFromDouble(30.0),
        );
                "field2",
        validateStarTreeFileFormats(
                assertEquals(map.get(dimValue) * 2, starTreeDocuments.get(docId).metrics[0]);
                    assertEquals(7L, starTreeDocument.metrics[0]);
        compositeField = getStarTreeField(MetricStat.VALUE_COUNT);
        SortedNumericDocValues d2sndv = dimList2;
                    assertEquals(8L, starTreeDocument.metrics[0]);
        SortedNumericDocValues f2d1sndv = getSortedNumericMock(dimList1, docsWithField1);
            getSortedNumericMock(dimList2, docsWithField2),
        SortedNumericDocValues dimList,
            "field5",
                dimList1.add((long) i);
            }
                sf.getMetrics().get(0).getMetrics().get(0).getTypeName()
                    assertTrue(List.of(5L, 7L).contains(starTreeDocument.dimensions[1]));
                dimList4.add((long) i);
        /**
        LinkedHashMap<String, DimensionConfig> map = new LinkedHashMap<>();
        expectedDimToValueMap.put(2, dimValueMap);
            writeState,
        );
            getSortedNumericMock(dimList4, docsWithField4),
        }
            docsWithField3,
            randomFrom(NumberFieldMapper.NumberType.values()),
                int docId = dimValueToDocIdEntry.getValue();
        List<Integer> docsWithField2 = List.of(0, 1, 2, 3, 4, 6);
            getStarTreeDimensionNames(compositeField.getDimensionsOrder()),
            DocValues.emptySortedNumeric(),
        List<Long> metricsList = List.of(0L, 1L, 2L, 3L, 4L, 5L, 6L);
        List<Long> dimList4 = new ArrayList<>(1000);
         [0, 0] | [9]
         [999, 999, 999, 999] | [19980.0]
            "field3",
            builder.getRootNode(),
            getStarTreeDimensionNames(compositeField.getDimensionsOrder()),
        StarTreeValues starTreeValues = getStarTreeValues(
import java.util.ArrayList;
        List<Long> dimList4 = List.of(5L, 6L, 7L, 8L, -1L);
            dimDocIdSetIterators,
         [0, 0] | [0]
            getStarTreeDimensionNames(compositeField.getDimensionsOrder()),
            10,
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
         [null, 5] | [5]
        List<Integer> metricsWithField = List.of(0, 1, 2, 3, 4, 5, 6);
        List<Integer> docsWithField2 = List.of(0, 1, 2, 3, 4, 6);
        SortedNumericDocValues f2d4sndv = getSortedNumericMock(dimList4, docsWithField4);
        List<Integer> metricsWithField = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        StarTreeValues starTreeValues2 = getStarTreeValues(
                    sum += ((CompensatedSum) starTreeDocument.metrics[0]).value();
                sf.getName(),
        /**
            getSortedNumericMock(dimList5, docsWithField5),
        SortedNumericDocValues f2m2sndv = DocValues.emptySortedNumeric();
        }
        builder.appendDocumentsToStarTree(starTreeDocumentIterator);
        validateStarTree(builder.getRootNode(), 2, 1000, builder.getStarTreeDocuments());
            builder.getRootNode(),
         */
        );
    public void testMergeFlowWithDifferentDocsFromSegments() throws IOException {
        }
            compositeField,
                String metricFullName = fullyQualifiedFieldNameForStarTreeMetricsDocValues(
                } else {
            "sf__doc_count_doc_count_metric",
        for (StarTreeDocument starTreeDocument : builder.getStarTreeDocuments()) {
        for (StarTreeDocument starTreeDocument : builder.getStarTreeDocuments()) {
            "6"
            "sf_field2_sum_metric",
        Map<String, Supplier<StarTreeValuesIterator>> f2metricDocIdSetIterators = Map.of(
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
        );
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
        );
                            assertEquals(100L, starTreeDocument.metrics[1]);
    }
        List<StarTreeDocument> starTreeDocuments = builder.getStarTreeDocuments();
            dimList2,
            "field1_half-hour",
            "sf_field2_value_count_metric",
        List<Integer> metricsWithField2 = List.of(0, 1, 2, 3, 4);
                    && starTreeDocument.dimensions[3] != null) {
                if (starTreeDocument.dimensions[0] == null) {
            for (int j = 0; j < 5; j++) {
         * [3, 3] | [60.0]
        List<Long> metricsList = new ArrayList<>(100);
        );
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, getWriteState(4, writeState.segmentInfo.getId()), mapperService);
        for (int i = 80; i < 100; i++) {
         [7, 2, null, null] | [28900.0, 20]
        for (int i = 0; i < 20; i++) {
            metricsWithField.add(i);
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
            starTreeMetadata,
        int count = 0;
            docCountMetricsWithField,
                            assertEquals(40L, starTreeDocument.metrics[1]);
            compositeField.getStarTreeConfig().maxLeafDocs(),
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
            getAttributes(1000),
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
            getSortedNumericMock(dimList2, docsWithField2),
            count++;
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
        validateStarTreeFileFormats(
        for (int i = 0; i < 1000; i++) {
    public void testMergeFlowWithDuplicateDimensionValues() throws IOException {
            builder.getStarTreeDocuments()
            getSortedNumericMock(metricsList1, metricsWithField1),
                } else {
            dimList2.add((long) (i % 2 == 0 ? i : -i));
            1000,
        builder.appendDocumentsToStarTree(starTreeDocumentIterator);
         [0, 0, 0, 0] | [200.0, 10]
         [0, 0] | [0]
                        assertEquals(10L, starTreeDocument.metrics[1]);
            sf,
            compositeField,
        compositeField = getStarTreeField(MetricStat.VALUE_COUNT);
         [null, null] | [12]
            () -> new SortedNumericStarTreeValuesIterator(f2d2sndv),
        validateStarTree(builder.getRootNode(), 4, 10, builder.getStarTreeDocuments());
        );
        List<Long> dimList4 = List.of(5L, 6L, 7L, 8L, -1L);
            starTreeMetadata,
         [4, 4, 4, 4] | [2200.0, 10]
        SortedNumericDocValues d2sndv = getSortedNumericMock(dimList2, docsWithField2);
        );
            "6"
        LinkedHashMap<String, DimensionConfig> map = new LinkedHashMap<>();
        );
        dataOut.close();
            null,
            if (starTreeDocument.dimensions[0] != null
        /**
         [3, 3, 3, 3] | [60.0, 2]
            }
        NumberFieldMapper numberFieldMapper1 = new NumberFieldMapper.Builder(
        when(documentMapper.mappers()).thenReturn(fieldMappers);
            docsWithField4,
        List<StarTreeDocument> starTreeDocuments = builder.getStarTreeDocuments();
        docValuesConsumer.close();
            getSortedNumericMock(metricsList, metricsWithField),
 *
         [null, null, null, 99] | [49700.0, 10]
                sf.getMetrics().get(0).getMetrics().get(1).getTypeName()
            } else {
            () -> new SortedNumericStarTreeValuesIterator(m2sndv)
        map.put("field3", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
            "sf_field2_value_count_metric",
            () -> new SortedNumericStarTreeValuesIterator(f2valucountsndv),
            "field5",
                }
        assertEquals(10, builder.getStarTreeDocuments().size());
            writeState,
        }
            "field8",
        List<Long> metricsList = List.of(0L, 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L);
        SortedNumericDocValues d4sndv = getSortedNumericMock(dimList4, docsWithField4);
            getStarTreeDimensionNames(compositeField.getDimensionsOrder()),
        );
         * [null, 2] | [40.0]
import org.opensearch.index.compositeindex.CompositeIndexConstants;
        int count = 0;
        SortedNumericDocValues m1sndv = getSortedNumericMock(metricsList, metricsWithField);
            metricsWithField.add(i);
        assertEquals(401, starTreeDocuments.size());
                dimList1.add((long) i);
            docCountMetricsList.add(i * 10L);
            if (count <= 4) {
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
                        }
        validateStarTreeFileFormats(
            dimList2,
            getLongFromDouble(50.0),
        );
        List<StarTreeDocument> starTreeDocuments = builder.getStarTreeDocuments();
        List<Long> metricsListValueCount = new ArrayList<>(1000);
            DocValues.emptySortedNumeric(),
            }
        writeState = getWriteState(4, writeState.segmentInfo.getId());
            docsWithField1,
            docsWithField1,
        List<Long> dimList4 = new ArrayList<>(500);
        dataOut.close();
        List<Long> dimList = List.of(0L, 1L, 3L, 4L, 5L, 6L);
    }
        );
         [2, 2, 2, 2] | [1200.0, 10]
        }
         [3, 3, 3, 3] | [1700.0, 10]
            "0"
            count++;
import static org.opensearch.index.compositeindex.datacube.startree.builder.BuilderTestsUtils.traverseStarTree;
        traverseStarTree(builder.rootNode, dimValueToDocIdMap, true);
            getSortedNumericMock(dimList, docsWithField),
            writeState,
            null,
         * [3, 3] | [60.0]
        List<Integer> docsWithField3 = new ArrayList<>(numDocs);
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
        List<Integer> docsWithField2 = List.of(0, 1, 2, 3, 4, 5, 6);
        StarTreeMetadata starTreeMetadata = getStarTreeMetadata(map, 6, 1000, 264);
        /**
            compositeField,
         [1, 0, 4, 4] | [2200.0, 10]
                assertEquals(starTreeDocument.dimensions[1], starTreeDocument.metrics[0]);
            }
import org.apache.lucene.index.SegmentWriteState;
        }
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
        List<Integer> docsWithField4 = List.of(0, 1, 2, 3, 4);
            dimList4.add((long) i);
        List<Integer> docsWithField5 = List.of(0, 1, 2, 3, 4, 5, 6);
                        } else if (starTreeDocument.dimensions[0] != null) {
            getLongFromDouble(10.0),
        map.put("field3", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
            builder.getStarTreeDocuments()
         [2, 2] | [2]
        );
            null,
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
        for (int i = 0; i < 100; i++) {
         */
            null
        List<Long> dimList2 = new ArrayList<>(500);
import org.opensearch.index.compositeindex.datacube.DimensionDataType;
            getSortedNumericMock(dimList3, docsWithField3),
        List<Integer> docsWithField = List.of(0, 1, 2, 3, 4, 6);
            starTreeMetadata,
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
        }
        }
                    0
        List<Integer> docsWithField3 = List.of(0, 1, 3, 4);
                "field2",
            dimList3,
                dimList3.add((long) i);
        int count = 0;
            () -> new SortedNumericStarTreeValuesIterator(m2sndv)
        validateStarTree(builder.getRootNode(), 4, 1, builder.getStarTreeDocuments());
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
            () -> new SortedNumericStarTreeValuesIterator(dimList),
        metricDocIdSetIterators.put(
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
        );
        }
        SortedNumericDocValues valucountsndv = getSortedNumericMock(metricsListValueCount, metricsWithFieldValueCount);
            docsWithField3,
        List<Long> metricsList = new ArrayList<>(1000);
            () -> new SortedNumericStarTreeValuesIterator(f2d1sndv),
        );
        int count = 0;
        for (int i = 0; i < 1000; i++) {
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
                assertEquals(starTreeDocument.dimensions[3] * 500 + 200.0, ((CompensatedSum) starTreeDocument.metrics[0]).value(), 0);
        for (int i = 0; i < 1000; i++) {
            builder.getRootNode(),
        SortedNumericDocValues d1sndv = getSortedNumericMock(dimList1, docsWithField1);
            getStarTreeDimensionNames(compositeField.getDimensionsOrder()),
        dataOut.close();
            () -> new SortedNumericStarTreeValuesIterator(f2d4sndv)
        List<Long> metricsList1 = new ArrayList<>(100);
        expectedDimToValueMap.put(1, dimValueMap);
        SortedNumericDocValues m1sndv = getSortedNumericMock(metricsList, metricsWithField);
         [4, 4] | [4]
            getSortedNumericMock(dimList4, docsWithField4),
                assertEquals(sum, ((CompensatedSum) starTreeDocument.metrics[0]).value(), 0);
        NumberFieldMapper numberFieldMapper2 = new NumberFieldMapper.Builder(
        dataOut.close();
                            assertTrue((long) starTreeDocument.metrics[1] == 20L || (long) starTreeDocument.metrics[1] == 40L);
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
            builder.getStarTreeDocuments()
    }
        List<Integer> docsWithField4 = new ArrayList<>(500);
        docValuesConsumer.close();
        List<Long> dimList = List.of(0L, 1L, 3L, 4L, 5L, 6L);
        SortedNumericDocValues metricsList,
        List<Integer> docsWithField1,
            metricsList.add(1L);
                && starTreeDocument.dimensions[2] != null
            false,
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
    public void testMergeFlow() throws IOException {
        StarTreeValues starTreeValues = getStarTreeValues(
        List<Long> metricsList = new ArrayList<>(100);
        List<Long> metricsList2 = List.of(5L, 6L, 7L, 8L, 9L);
            () -> new SortedNumericStarTreeValuesIterator(d2sndv),
            if (starTreeDocument.dimensions[3] == null) {
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
    private StarTreeValues getStarTreeValues(
        List<Long> dimList2 = List.of(0L, 1L, 2L, 3L, 4L, 5L, -1L);
        docValuesConsumer.close();
        List<Integer> docsWithField2 = new ArrayList<>(500);
package org.opensearch.index.compositeindex.datacube.startree.builder;
         [null, 7] | [7]
        for (StarTreeDocument starTreeDocument : builder.getStarTreeDocuments()) {
            }
            dimDocIdSetIterators,
            docCountMetricsWithField,
            () -> new SortedSetStarTreeValuesIterator(d1sndv),
                && starTreeDocument.dimensions[2] != null
         [-1, -1, -1, -1] | [20.0, 2]
                    ((CompensatedSum) starTreeDocument.metrics[0]).value(),
        docValuesConsumer.close();
        for (int i = 0; i < 500; i++) {
            getSortedNumericMock(dimList4, docsWithField4),
import java.util.concurrent.atomic.AtomicInteger;
         */
            () -> new SortedNumericStarTreeValuesIterator(d3sndv),
        List<Integer> docsWithField = List.of(0, 1, 2, 6);
         [1655288032000, 1655288032000, 1655288032000, 2] | [20.0, 2]
        );
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
            () -> new SortedNumericStarTreeValuesIterator(metricsList1)
            metricsList1,
            metricDocIdSetIterators,
        List<StarTreeDocument> starTreeDocuments = builder.getStarTreeDocuments();
        for (int i = 80; i < 100; i++) {
                "field2",
            getSortedNumericMock(metricsList, metricsWithField),
            randomFrom(NumberFieldMapper.NumberType.values()),
        dataOut.close();
            dimList4,
        ).build(new Mapper.BuilderContext(settings, new ContentPath()));
        }
        StarTreeValues starTreeValues2 = getStarTreeValues(
                            assertEquals(10L, starTreeDocument.metrics[1]);
    public void testMergeFlowWithMissingDocsWithZero() throws IOException {
import org.opensearch.index.compositeindex.datacube.ReadDimension;
        );
            docsWithField3,
         [2, 0, 8, 8] | [4200.0, 10]
        );
                assertEquals(starTreeDocument.dimensions[1], starTreeDocument.metrics[0]);
        List<Long> dimList2 = List.of(0L, 1L, 2L, 3L, 4L, 5L, -1L);
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
        List<Long> dimList4 = List.of(5L, 6L, 7L, 8L, -1L);
            docCountMetricsWithField,
                dimList1.add((long) i);
            dimList2.add((long) i);
            "6"
         ...
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
         ...
        );
                expectedDimensionValues.add((long) -(numDocs - i) * 2 + 1); // Negative odd numbers in decreasing order
            dimDocIdSetIterators,
        StarTreeValues starTreeValues2 = new StarTreeValues(
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
            compositeField
    }
                "field2",
            if (dimId == -1) continue;
            sf,
        Map<String, Supplier<StarTreeValuesIterator>> f2dimDocIdSetIterators = Map.of(
        }
                if (starTreeDocument.dimensions[0] == null && starTreeDocument.dimensions[1] == null) {
        );
        for (int i = 80; i < 100; i++) {
        metaOut.close();
        List<Long> dimList = List.of(0L, 1L, 3L, 4L, 5L, 6L);
        NumberFieldMapper numberFieldMapper3 = new NumberFieldMapper.Builder(
         * Asserting following dim / metrics [ dim1, dim2 / Count [ metric] ]
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
                    assertEquals(9L, starTreeDocument.metrics[0]);
        List<Long> dimList = List.of(0L, 0L, 0L, 0L, 0L);
import java.util.Collections;
                }
        List<Integer> metricsWithField2 = List.of(0, 1, 2, 3, 4);
         .....
        );
            getSortedNumericMock(metricsList21, metricsWithField21),
        Map<String, Supplier<StarTreeValuesIterator>> metricDocIdSetIterators = new LinkedHashMap<>();
            "6"
         [null, 2] | [2]
    }
        StarTreeValues starTreeValues = getStarTreeValues(
                }
        List<Integer> docsWithField2 = List.of(0, 1, 2, 3, 4, 5, 6);
        map.put("field3", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
        List<Integer> docsWithField = List.of(0, 1, 2, 3, 4);
            getSortedNumericMock(dimList, docsWithField),
            "6"
         [0, null] | [8]
            null
        map.put("field3", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
            dimList2,
        List<Integer> metricsWithField = List.of(0, 1, 2, 3, 4, 5, 6);
        StarTreeValues starTreeValues2 = getStarTreeValues(
                if (starTreeDocument.dimensions[0] == null) {
        LinkedHashMap<String, DimensionConfig> map = new LinkedHashMap<>();
            23199
            writeState,
         [5, null] | [5]
            () -> new SortedNumericStarTreeValuesIterator(f2m2sndv)
            if (count <= 7) {
        List<Integer> metricsWithField = List.of(0, 1, 2, 3, 4, 5, 6);
        metaOut.close();
            }
         [null, 7] | [7]
         [1, 1] | [1]
            compositeField,
            getSortedNumericMock(dimList3, docsWithField3),
        for (int i = 0; i < 20; i++) {
            null,
        );
            getLongFromDouble(40.0),
        );
            "field3",
                dimList2.add((long) i);
        Map<Integer, Map<Long, Double>> expectedDimToValueMap = new HashMap<>();
        );
         * [1, 1] | [20.0]
        );
            compositeField,
         [0, 0, 0, 0] | [200.0, 10]
        Metric m1 = new Metric("field2", List.of(MetricStat.SUM, MetricStat.AVG, MetricStat.VALUE_COUNT));
        for (int i = 0; i < 500; i++) {
        List<Long> dimList3 = List.of(5L, 6L, 8L, -1L);
         [1, 1] | [1]
        List<Long> metricsList = new ArrayList<>(1000);
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
            docsWithField1.add(i);
            starTreeMetadata,
            () -> new SortedNumericStarTreeValuesIterator(d1sndv),
            "4"
        List<Long> dimList1,
        );
        List<Integer> docsWithField2 = new ArrayList<>(500);
            docsWithField3,
        String number
        validateStarTree(builder.getRootNode(), 2, 1000, builder.getStarTreeDocuments());
            13365
            dimList1.add((long) (i % 2 == 0 ? i : -i));
            starTreeMetadata,
        /**
            f2metricDocIdSetIterators,
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
         [1, 1, 1, 1] | [20.0, 2]
        compositeField = new StarTreeField("sf", dims, metrics, c);
import org.opensearch.index.mapper.MappingLookup;
            getLongFromDouble(50.0),
            getSortedNumericMock(dimList3, docsWithField3),
            docsWithField2,
        StarTreeValues starTreeValues = getStarTreeValues(
        map.put("field3", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
        }
    ) {
            0,
        );
        List<Long> dimList3 = List.of(1655288152000L, 1655288092000L, 1655288032000L, -1L);
            "field5",
            "4"
        for (int i = 0; i < 1000; i++) {
            } else {
         * [5, 5] | [100.0]
         [null, null, null, null] | [2495000.0, 1000]
            fullyQualifiedFieldNameForStarTreeMetricsDocValues(
        StarTreeValues starTreeValues2 = getStarTreeValues(
            compositeField.getStarTreeConfig().maxLeafDocs(),
        StarTreeValues starTreeValues2 = getStarTreeValues(
        assertEquals(401, starTreeDocuments.size());
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
         [3, 3] | [3]
    }
            getSortedNumericMock(dimList4, docsWithField4),
        List<Integer> docsWithField2 = List.of(0, 1, 2, 6);
         [3, 3] | [11, 110.0]
        dataOut.close();
            metricsWithField,
            getLongFromDouble(20.0),
         [null, null] | [19]
        builder.appendDocumentsToStarTree(starTreeDocumentIterator);
            compositeField.getStarTreeConfig().maxLeafDocs(),
        assertEquals(6, builder.getStarTreeDocuments().size());
            "field1_hour",
         ...
            true
            () -> new SortedNumericStarTreeValuesIterator(metricsList)
            "field1",
import org.opensearch.index.codec.composite.LuceneDocValuesConsumerFactory;
                "_doc_count",
            count++;
            dimList1,
        validateStarTreeFileFormats(
    }
        validateStarTree(builder.getRootNode(), 4, 1, builder.getStarTreeDocuments());
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
        );
    ) {
        validateStarTreeFileFormats(
        SortedNumericDocValues d3sndv = getSortedNumericMock(dimList3, docsWithField3);
    public void testMergeFlowNumSegmentsDocs() throws IOException {
        validateStarTree(builder.getRootNode(), 4, compositeField.getStarTreeConfig().maxLeafDocs(), builder.getStarTreeDocuments());
            }
        StarTreeMetadata starTreeMetadata = getStarTreeMetadata(
import java.util.Iterator;
        Dimension d4 = new ReadDimension("field8", DocValuesType.SORTED_NUMERIC, DimensionDataType.UNSIGNED_LONG);
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
            6,
        metaOut.close();
import java.util.HashMap;
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
        builder.build(starTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
            () -> new SortedNumericStarTreeValuesIterator(d1sndv),
         [null, 2] | [4]
        SortedNumericDocValues f2m1sndv = getSortedNumericMock(metricsList, metricsWithField);
        assertEquals(401, count);
         */
        List<Long> dimList2 = new ArrayList<>(500);
        dataOut.close();
    }
            builder.getStarTreeDocuments()
        List<Integer> metricsWithField2 = List.of(0, 1, 2, 3, 4);
        List<Integer> docsWithField2 = new ArrayList<>(500);
        SortedNumericDocValues m2sndv = DocValues.emptySortedNumeric();
            compositeField
        for (int i = 0; i < 1000; i++) {
            docCountMetricsList,
        SortedNumericDocValues f2d2sndv = getSortedNumericMock(dimList2, docsWithField2);
        // Validate the star tree structure
        SortedNumericDocValues d3sndv = getSortedNumericMock(dimList3, docsWithField3);
        builder.build(starTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
        while (starTreeDocumentIterator.hasNext()) {
        List<Long> dimList2 = List.of(0L, 1L, 2L, 3L, 4L, 5L, -1L);
        metaOut.close();
        List<Integer> metricsWithField = List.of(0, 1, 2, 3, 4, 5, 6);
        for (int i = 0; i < 500; i++) {
        StarTreeValues starTreeValues = getStarTreeValues(
        int count = 0;
    }
         * [1, 1] | [20.0]
            ),
import java.util.LinkedHashMap;
        docValuesConsumer.close();
         [0, 0] | [0]
            null
            true
            132165
         */
    public void testMergeFlowWithTimestamps() throws IOException {
        Dimension d1 = new NumericDimension("field1");
    public void testMergeFlowWithMaxLeafDocs() throws IOException {
        List<Long> metricsList2 = List.of(5L, 6L, 7L, 8L, 9L);
        SortedNumericDocValues metricsList,
        docValuesConsumer.close();
        StarTreeValues starTreeValues = getStarTreeValuesWithKeywords(
                } else {
            dimList2,
         [null, null, null, 5] | [50.0, 5]
        List<Long> metricsList = new ArrayList<>(100);
        List<Integer> docsWithField = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> docsWithField1 = new ArrayList<>(numDocs);
            writeState,
        DocumentMapper documentMapper = mock(DocumentMapper.class);
        assertEquals(9, count);
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.mergeStarTrees(List.of(starTreeValues, starTreeValues2));
    }
        builder.build(builder.mergeStarTrees(List.of(starTreeValues, starTreeValues2)), new AtomicInteger(), docValuesConsumer);
        for (StarTreeDocument starTreeDocument : builder.getStarTreeDocuments()) {
        List<Integer> metricsWithField = new ArrayList<>(100);
            builder.getStarTreeDocuments().size(),
        Metric m1 = new Metric("field2", List.of(MetricStat.SUM, MetricStat.AVG, MetricStat.VALUE_COUNT));
            dimList3,
            docsWithField4,
        List<Integer> metricsWithField1 = List.of(0, 1, 2, 3, 4, 5, 6);
        int count = 0;
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
import static org.opensearch.index.compositeindex.CompositeIndexConstants.SEGMENT_DOCS_COUNT;
         [3, 3] | [3]
        List<Integer> metricsWithFieldValueCount = new ArrayList<>(1000);
         [2, 2] | [2]
        );
         * ------------------ We only take non star docs
         [3, 3] | [6]
        builder.build(starTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
            getSortedNumericMock(dimList2, docsWithField2),
            getSortedNumericMock(metricsList, metricsWithField),
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
        List<Long> dimList2 = List.of(0L, 0L, 0L, 0L);
        StarTreeMetadata starTreeMetadata = getStarTreeMetadata(
                metricDocIdSetIterators.put(metricFullName, () -> new SortedNumericStarTreeValuesIterator(m1sndv));
        List<Long> dimList2,
        dimValueMap = new HashMap<>();
        List<Long> dimList2 = new ArrayList<>(500);
        for (int i = 0; i < 100; i++) {
        }
        StarTreeValues starTreeValues = getStarTreeValues(
            compositeField,
         [1, 1] | [2]
        // Validate the star tree structure
        for (StarTreeDocument starTreeDocument : builder.getStarTreeDocuments()) {
            }
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
        );
import org.opensearch.index.compositeindex.datacube.startree.fileformats.meta.StarTreeMetadata;
        List<Long> dimList1 = new ArrayList<>(1000);
        assertEquals(7, builder.getStarTreeDocuments().size());
        List<Integer> docsWithField4 = List.of(0, 1, 2, 3, 4);
            docsWithField3,
            count++;
        );
        assertEquals(6, count);
        );
         [4, 4] | [4]
            }
            getSortedNumericMock(dimList4, docsWithField4),
        map.put("field3", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
        List<Integer> docsWithField4 = new ArrayList<>(500);
         [4, 4] | [4]
        SortedNumericDocValues d4sndv = getSortedNumericMock(dimList4, docsWithField4);
        }
        }
            metricsWithField.add(i);
         [null, null, null, 99] | [49700.0, 10]
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedNumericStarTreeValuesIterator;
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
            () -> new SortedNumericStarTreeValuesIterator(dimList4),
            dimList2,
            for (int j = 0; j < 5; j++) {
        List<Long> metricsListValueCount = new ArrayList<>(1000);
        // builder.getRootNode(),
        /**
         [0, 0, 0, 0] | [0.0, 2]
            count++;
            docCountMetricsWithField.add(i);
        StarTreeMetadata starTreeMetadata = getStarTreeMetadata(map, 10, 1000, 363);
        map.put("field3", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
            builder.getStarTreeDocuments()
            null
            () -> new SortedNumericStarTreeValuesIterator(d2sndv),
            dimList4.add((long) (i % 2 == 0 ? i : -i));
            "field8",
            () -> new SortedSetStarTreeValuesIterator(d2sndv)
        builder.appendDocumentsToStarTree(starTreeDocumentIterator);
        dataOut.close();
                );
        List<Long> dimList2 = new ArrayList<>(numDocs);
        Map<String, Supplier<StarTreeValuesIterator>> metricDocIdSetIterators = Map.of(
         [1, 1] | [1]
                && starTreeDocument.dimensions[3] != null) {
         [null, 5] | [5]
    }
            metricDocIdSetIterators,
        );
        StarTreeValues starTreeValues2 = getStarTreeValuesWithDates(
        List<Long> dimList3 = new ArrayList<>(500);
        return starTreeValues;
            getSortedNumericMock(metricsList, metricsWithField),
        );
        StarTreeField sf
        }
            getSortedNumericMock(dimList3, docsWithField3),
        List<Long> dimList4 = List.of(5L, 6L, 7L, 8L, -1L);
         [2, 2, 2, 2] | [40.0, 2]
        List<Long> dimList8 = List.of(1655288152000L, 1655288092000L, 1655288032000L, -1L);
        MappingLookup fieldMappers = new MappingLookup(
            ),
            Collections.emptyList(),
        List<Long> dimList2 = List.of(0L, 1L, 2L, 3L, 4L, 6L);
            getLongFromDouble(30.0),
import java.util.List;
        List<Integer> metricsWithField2 = List.of(0, 1, 2, 3, 4);
        List<Long> dimList4 = new ArrayList<>(500);
         [6, 6] | [6]
                docsWithField1.add(i * 5 + j);
            } else {
                } else if (starTreeDocument.dimensions[0] != null
        metaOut.close();
        docValuesConsumer.close();
        );
        validateStarTreeFileFormats(
        /**
        );
         [2, 1, 11, 11] | [5700.0, 10]
        List<Long> metricsList2 = List.of(5L, 6L, 7L, 8L, 9L);
            dimList1,
        );
            compositeField,
            false,
        }
                }
                assertEquals(
        List<Integer> metricsWithField = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
            getSortedNumericMock(dimList2, docsWithField2),
                    0
                docsWithField1.add(i * 20 + j);
        for (StarTreeDocument starTreeDocument : builder.getStarTreeDocuments()) {
            for (int j = 0; j < 5; j++) {
        StarTreeValues starTreeValues = new StarTreeValues(
                docsWithField1.add(i * 20 + j);
            builder.getRootNode(),
            100,
            getAttributes(1000),
            builder.getStarTreeDocuments().size(),
        List<Integer> docsWithField = List.of(0, 1, 3, 4, 5, 6);
         [5, 5] | [5]
            null
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
        }
            "sf_field2_sum_metric",
            metricsWithField.add(i);
        );
        Dimension d4 = new NumericDimension("field8");
            docsWithField2,
        builder.appendDocumentsToStarTree(starTreeDocumentIterator);
        );
        // validateStarTreeFileFormats(
        StarTreeValues starTreeValues = new StarTreeValues(
            }
            docsWithField3,
        List<Integer> docsWithField3 = List.of(0, 1, 3, 4);
        );
        return starTreeValues;
            docCountMetricsWithField,
         */
        List<Long> dimList3 = List.of(5L, 6L, 8L, -1L);
        SortedNumericDocValues f2d1sndv = getSortedNumericMock(dimList1, docsWithField1);
            starTreeMetadata,
            docsWithField1,
import org.opensearch.index.mapper.ContentPath;
                dimList4.add((long) i);
        StarTreeMetadata starTreeMetadata = getStarTreeMetadata(
            starTreeMetadata,
            () -> new SortedNumericStarTreeValuesIterator(m1sndv),
        metaOut.close();
        docValuesConsumer.close();
         [-3, -3, -3, -3] | [60.0, 2]
        }
            "4"
        SortedNumericDocValues d1sndv = dimList;
        StarTreeValues starTreeValues = getStarTreeValues(
    ) {
        List<Long> dimList3 = new ArrayList<>(500);
        List<Integer> docsWithField3 = List.of(0, 1, 2, 3, 4);
            }
        List<Long> metricsList2 = List.of(5L, 6L, 7L, 8L, 9L);
        SortedNumericDocValues f2valucountsndv = getSortedNumericMock(metricsListValueCount, metricsWithFieldValueCount);
            getLongFromDouble(80.0),
        StarTreeValues starTreeValues = getStarTreeValues(
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.mergeStarTrees(List.of(starTreeValues, starTreeValues2));
                }
            metricsWithFieldValueCount.add(i);
        }
        dataOut.close();
         [null, null, null, null] | [2495000.0, 1000]
            metricsList1,
        List<Integer> docsWithField4 = List.of(0, 1, 2, 3, 4);
        builder.build(builder.mergeStarTrees(List.of(starTreeValues, starTreeValues2)), new AtomicInteger(), docValuesConsumer);
                    metric.getField(),
         [6, 6] | [6]
        List<Long> dimList = List.of(0L, 1L, 2L, 3L, 4L, 6L);
        dimValueMap.put(Long.MAX_VALUE, 5000.0);
        StarTreeValues starTreeValues2 = getStarTreeValues(
        compositeField = getStarTreeFieldWithDocCount(1, true);
        );
                    metricStat.getTypeName()
            metricsList.add(getLongFromDouble(i * 10.0));
        SortedNumericDocValues m1sndv = metricsList;
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.mergeStarTrees(List.of(starTreeValues, starTreeValues2));
        return starTreeValues;
        List<Integer> docsWithField4 = List.of(0, 1, 3, 4);
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.mergeStarTrees(List.of(starTreeValues, starTreeValues2));
        for (int i = 0; i < 500; i++) {
         [0, 0] | [5, 50.0]
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
        int count = 0;
            () -> new SortedNumericStarTreeValuesIterator(d4sndv)
            compositeField,
                } else if (starTreeDocument.dimensions[0] == null) {
        }
        List<Long> dimList3 = new ArrayList<>(numDocs);
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.mergeStarTrees(List.of(starTreeValues, starTreeValues2));
        compositeField = getStarTreeField(MetricStat.VALUE_COUNT);
            if (count <= 6) {
        );
            getSortedNumericMock(dimList3, docsWithField3),
            getSortedSetMock(dimList2, docsWithField2),
            }
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
        }
            docsWithField1.add(i);
            "field8",
        );
        /**
        map.put("field1", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
            starTreeMetadata,
        List<Integer> docsWithField1 = new ArrayList<>(500);
            ),
import org.opensearch.index.mapper.DocumentMapper;
         [8, 8] | [8]
            100,
            getSortedNumericMock(metricsList, metricsWithField),
        );
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.mergeStarTrees(List.of(starTreeValues, starTreeValues2));
            getSortedNumericMock(dimList, docsWithField),
            metricsWithField,
            docsWithField3,
        StarTreeValues starTreeValues = getStarTreeValuesWithDates(
        List<Long> metricsList2 = List.of(5L, 6L, 7L, 8L, 9L);
            "field1",
            getSortedNumericMock(metricsList, metricsWithField),
            getSortedNumericMock(metricsList2, metricsWithField2),
                expectedDimensionValues.add((long) i * 2); // Positive even numbers
import org.opensearch.index.mapper.NumberFieldMapper;
                assertEquals(starTreeDocument.dimensions[0] * 2, starTreeDocument.metrics[0]);
            getSortedSetMock(dimList, docsWithField),
        }
        StarTreeMetadata starTreeMetadata = getStarTreeMetadata(map, 10, 1000, 363);
            writeState,
        List<Integer> metricsWithField1 = new ArrayList<>(100);
            docsWithField2,
            getSortedNumericMock(metricsList, metricsWithField),
        }
            builder.getStarTreeDocuments().size(),
                    } else if (starTreeDocument.dimensions[0] != null
            getLongFromDouble(70.0),
         * [4, 4] | [80.0]
            builder.getRootNode(),
            count++;
            "field5",
            getSortedNumericMock(dimList, docsWithField),
        writeState = getWriteState(4, writeState.segmentInfo.getId());
            docsWithField3.add(i);
        );
        LinkedHashMap<String, DimensionConfig> map = new LinkedHashMap<>();
            starTreeMetadata,
        List<Long> expectedDimensionValues = new ArrayList<>(1000);
                assertEquals(starTreeDocument.dimensions[3] * 500 + 200L, (long) starTreeDocument.metrics[1]);
            docsWithField2,
            metricsList1,
        List<Integer> docsWithField = List.of(0, 1, 2, 6, 8);
        for (int i = 0; i < 1000; i++) {
    public void testMergeFlowWithCount() throws IOException {
                    assertEquals(starTreeDocument.dimensions[1], starTreeDocument.metrics[0]);
                        } else if (starTreeDocument.dimensions[1] != null) {
        List<Integer> docsWithField1 = new ArrayList<>(500);
         [1, 0, 7, 7] | [3700.0, 10]
        SortedNumericDocValues f2valucountsndv = getSortedNumericMock(metricsListValueCount, metricsWithFieldValueCount);
                    assertEquals(starTreeDocument.dimensions[1], starTreeDocument.metrics[0]);
        );
            }
        SortedNumericDocValues m2sndv = DocValues.emptySortedNumeric();
        docValuesConsumer.close();
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
         * Asserting following dim / metrics [ dim1, dim2 / Count [ metric] ]
            132165
        List<Long> metricsList2 = List.of(0L, 1L, 2L, 3L, 4L);
        builder.appendDocumentsToStarTree(starTreeDocumentIterator);
            "4"
        List<Integer> docsWithField3,
            compositeField,
        );
        );
            count++;
            getSortedNumericMock(dimList, docsWithField),
        List<Long> dimList = List.of(0L, 1L, 2L, 3L, 4L, 5L, 6L, -1L, -1L, -1L);
            () -> new SortedNumericStarTreeValuesIterator(f2valucountsndv),
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
            metricsWithField1.add(i);
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
            dimList3,
        List<Long> dimList2 = new ArrayList<>(500);
         [5, 5] | [10]
        );
        );
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
        compositeField = getStarTreeFieldForUnsignedLong(MetricStat.SUM);
            getSortedNumericMock(dimList3, docsWithField3),
import org.apache.lucene.index.SortedSetDocValues;
        // builder.getStarTreeDocuments()
                docsWithField1.add(i * 20 + j);
         [0, 0] | [0]
        docValuesConsumer.close();
            docsWithField4,
            builder.getStarTreeDocuments()
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
        List<Integer> docsWithField1 = new ArrayList<>(500);
            "6"
            dimList4,
            dimList4.add((long) 1);
        StarTreeField sf = getStarTreeField(MetricStat.VALUE_COUNT);
                docsWithField4.add(i * 5 + j);
            metricsList.add(getLongFromDouble(10.0));
            () -> new SortedNumericStarTreeValuesIterator(metricsList1)
        for (int i = 0; i < 500; i++) {
            compositeField,
        StarTreeValues starTreeValues = new StarTreeValues(
        StarTreeValues starTreeValues2 = getStarTreeValues(
        compositeField = getStarTreeFieldWithDocCount(10, true);
        SortedNumericDocValues dimList4,
            dimList3.add((long) i);
         [5, 5] | [5]
        for (int i = 0; i < 500; i++) {
        for (int i = 0; i < numDocs; i++) {
        List<Metric> metrics = List.of(m1, m2);
        assertEquals(expectedDimensionValues, actualDimensionValues);
        List<Integer> metricsWithField2 = List.of(0, 1, 2, 3, 4);
        );
                    assertEquals(starTreeDocument.dimensions[0], starTreeDocument.metrics[0]);
        Map<String, Supplier<StarTreeValuesIterator>> metricDocIdSetIterators = new LinkedHashMap<>();
        List<Integer> docsWithField = List.of(0, 1, 2, 3, 4);
            metricsList,
            compositeField,
        List<Long> dimList = List.of(0L, 1L, 2L, 3L, 4L, 5L, -1L);
         [1, 0, 6, 6] | [3200.0, 10]
            getLongFromDouble(0.0),
            1,
         [5, 5, 5, 5] | [100.0, 2]
            "6"
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
            getSortedNumericMock(dimList, docsWithField),
            getLongFromDouble(60.0)
        SortedNumericDocValues dimList3,
         [8, 8] | [8]
                );
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
                        && starTreeDocument.dimensions[1] != null
        List<Long> dimList1 = new ArrayList<>(500);
        SortedSetDocValues d1sndv = dimList;
        );
        for (int i = 0; i < numDocs; i++) {
                        && starTreeDocument.dimensions[3] != null) {
            metricDocIdSetIterators,
            if (count < 1000) {
         * Asserting following dim / metrics [ dim1, dim2 / Count [ metric] ]
        map.put("field1", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.UNSIGNED_LONG));
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
         [6, 6] | [6]
        }
        StarTreeValues starTreeValues = getStarTreeValues(
            }
            true
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
import org.opensearch.search.aggregations.metrics.CompensatedSum;
        List<Long> dimList2 = List.of(0L, 1L, 2L, 3L, 4L, 5L, -1L);
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
            docsWithField3,
        for (int i = 0; i < 500; i++) {
            "7"
        );
            "6"
            } else {
        builder.build(builder.mergeStarTrees(List.of(starTreeValues, starTreeValues2)), new AtomicInteger(), docValuesConsumer);
                }
            docsWithField2,
        List<Long> dimList4 = List.of(0L, 1L, 2L, 3L, -1L);
         [0, 0, 3, 3] | [1700.0, 10]
        map.put("field1", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
        Map<String, Supplier<StarTreeValuesIterator>> dimDocIdSetIterators = Map.of(
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
         * [4, 4] | [80.0]
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
            }
        List<Integer> docsWithField3 = List.of(0, 1, 3, 4);
        metaOut.close();
        List<Long> dimList6 = List.of(5L, 6L, 7L, 8L);
            () -> new SortedNumericStarTreeValuesIterator(f2m1sndv),
            dimList2,
                assertEquals(2L, starTreeDocument.metrics[2]);
            count++;
            } else if (starTreeDocument.dimensions[1] != null
            dimDocIdSetIterators,
            docsWithField4,
        );
            count++;
                docsWithField1.add(i * 5 + j);
        super(buildMode);
            for (int j = 0; j < 5; j++) {
        int count = 0;
            starTreeMetadata,
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
            builder.getStarTreeDocuments()
            () -> new SortedNumericStarTreeValuesIterator(f2d2sndv),
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
                    ((CompensatedSum) starTreeDocument.metrics[0]).value(),
            dimValueMap.put((long) i, 50.0);
            () -> new SortedNumericStarTreeValuesIterator(f2d3sndv),
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
            for (Map.Entry<Long, Integer> dimValueToDocIdEntry : entry.getValue().entrySet()) {
        List<Long> dimList = List.of(0L, 1L, 2L, 3L, 4L, 5L, 6L);
import org.apache.lucene.index.DocValuesType;
        List<Long> docCountMetricsList = new ArrayList<>(100);
    public void testMergeFlowWithDocsMissingAtTheEnd() throws IOException {
                if (starTreeDocument.dimensions[0] == null && starTreeDocument.dimensions[1] == null) {
                docsWithField2.add(i * 5 + j);
        builder.build(starTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
            metricsWithField.add(i);
        writeState = getWriteState(6, writeState.segmentInfo.getId());
                && starTreeDocument.dimensions[3] != null) {
        SortedSetDocValues d2sndv = dimList2;
        Map<String, Supplier<StarTreeValuesIterator>> dimDocIdSetIterators = Map.of(
            builder.getStarTreeDocuments().size(),
            getLongFromDouble(30.0),
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
                    assertTrue(List.of(5L, 7L).contains(starTreeDocument.dimensions[1]));
            metricsWithField,
            getSortedNumericMock(dimList3, docsWithField3),
        for (Metric metric : sf.getMetrics()) {
            getSortedNumericMock(dimList4, docsWithField4),
            StarTreeDocument starTreeDocument = starTreeDocumentIterator.next();
            if (count <= 10) {
         [5, 5] | [5]
            getLongFromDouble(60.0)
            getSortedNumericMock(metricsList, metricsWithField),
            dimList1,
        map.put("field1", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
         635 docs get generated
        for (StarTreeDocument starTreeDocument : builder.getStarTreeDocuments()) {
        /**
            getSortedNumericMock(metricsList2, metricsWithField2),
        Map<String, Supplier<StarTreeValuesIterator>> dimDocIdSetIterators = Map.of(
            getSortedNumericMock(metricsList2, metricsWithField2),
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedSetStarTreeValuesIterator;
            "field1",
            starTreeMetadata,
            metricsList1,
        assertEquals(6, builder.getStarTreeDocuments().size());
            metricsList,
        compositeField = getStarTreeField(MetricStat.VALUE_COUNT);
        StarTreeMetadata starTreeMetadata = getStarTreeMetadata(map, 9, 1000, 330);
            docCountMetricsList,
         [0, 0, 0, 0] | [0.0, 2]
    }
        List<Integer> docsWithField4 = new ArrayList<>(500);
        Map<String, Supplier<StarTreeValuesIterator>> metricDocIdSetIterators = new LinkedHashMap<>();
                            assertEquals(10L, starTreeDocument.metrics[1]);
            getLongFromDouble(10.0),
         [1655288152000, 1655288152000, 1655288152000, 5] | [50.0, 5]
            "field8",
         [4, 4, 4, 4] | [80.0, 2]
        List<Long> dimList4 = new ArrayList<>(500);
            3,
                sf.getName(),
            dimList1,
import java.util.function.Supplier;
            "field1",
            }
                }
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
        for (int i = 0; i < 20; i++) {
        }
            () -> new SortedNumericStarTreeValuesIterator(dimList2),
            compositeField,
        StarTreeMetadata starTreeMetadata = getStarTreeMetadata(
            264
         [2, 2] | [2]
            "field3",
            starTreeMetadata,
            "field1_minute",
        StarTreeField sf,
        validateStarTree(builder.getRootNode(), 2, 1000, builder.getStarTreeDocuments());
            getSortedNumericMock(dimList2, docsWithField2),
import org.opensearch.index.compositeindex.datacube.Dimension;
            metricsWithFieldValueCount.add(i);
        // Initialize the mock MergeState within the method
            getSortedNumericMock(metricsList2, metricsWithField2),
            231
            for (int j = 0; j < 20; j++) {
        StarTreeMetadata starTreeMetadata = getStarTreeMetadata(map, 7, 1000, 231);
         .....
                && starTreeDocument.dimensions[1] != null
                docsWithField4.add(i * 5 + j);
        dimValueMap.put(Long.MAX_VALUE, 5000.0);
         [0, 0] | [9]
            Set.of(numberFieldMapper1, numberFieldMapper2, numberFieldMapper3),
        dataOut.close();
         [2, 2] | [2]
    ) {
            docsWithField1,
        List<Long> dimList3 = List.of(5L, 6L, 8L, -1L);
            null
        );
         * Asserting following dim / metrics [ dim1, dim2 / Count [ metric] ]
        StarTreeValues starTreeValues = getStarTreeValues(
        List<Integer> metricsWithField = List.of(0, 1, 2, 3, 4, 5, 6);
        for (int i = 0; i < 100; i++) {
            dimList3,
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
                sf.getMetrics().get(0).getMetrics().get(0).getTypeName()
        Map<String, Supplier<StarTreeValuesIterator>> dimDocIdSetIterators = Map.of(
        );
            if (Objects.equals(starTreeDocument.dimensions[0], 5L)) {
            getLongFromDouble(30.0),
        List<Integer> docsWithField = List.of(0, 1, 2, 3, 4, 5, 6);
        );
            getLongFromDouble(90.0)
                    && starTreeDocument.dimensions[2] != null
        List<Long> dimList2 = List.of(0L, 1L, 2L, 3L, 4L, 5L, -1L);
            fullyQualifiedFieldNameForStarTreeMetricsDocValues(
                );
            getLongFromDouble(40.0),
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.mergeStarTrees(List.of(starTreeValues, starTreeValues2));
            docsWithField2.add(i);
            consumerWriteState,
        List<Long> metricsList2 = List.of(5L, 6L, 7L, 8L, 9L);
        List<Long> dimList = List.of(0L, 1L, 2L, 3L, 4L);
         [4, 4] | [4, 40.0]
        validateStarTree(builder.getRootNode(), 4, 10, builder.getStarTreeDocuments());
        List<Integer> metricsWithField = List.of(0, 1, 2, 3, 4, 5, 6);
        }
            dimList3.add((long) 1);
        );
            getSortedNumericMock(dimList2, docsWithField2),
            getSortedNumericMock(metricsList, metricsWithField),
        List<Integer> docsWithField = List.of(0, 1, 3, 4, 5, 6);
            () -> new SortedNumericStarTreeValuesIterator(valucountsndv),
                assertEquals(starTreeDocument.dimensions[1], starTreeDocument.metrics[0]);
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
        LinkedHashMap<String, DimensionConfig> map = new LinkedHashMap<>();
            getSortedNumericMock(dimList2, docsWithField2),
import static org.mockito.Mockito.mock;
        dataOut.close();
        builder.build(starTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
        validateStarTree(builder.getRootNode(), 4, compositeField.getStarTreeConfig().maxLeafDocs(), builder.getStarTreeDocuments());
            getLongFromDouble(10.0),
        assertEquals(1041, starTreeDocuments.size());
                dimList1.add((long) i);
            getSortedNumericMock(dimList, docsWithField),
        List<Integer> metricsWithField1 = List.of(0, 1, 2, 3, 4, 5, 6);
         [1, 1, 1, 1] | [700.0, 10]
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
        List<Integer> metricsWithField = List.of(0, 1, 2, 3, 4, 5, 6);
}
            sf,
        List<Long> dimList3 = List.of(0L, 1L, 2L, 3L, -1L);
        List<Long> metricsList,
        }
            "4"
            for (int j = 0; j < 5; j++) {
        Dimension d1 = new ReadDimension("field1", DocValuesType.SORTED_NUMERIC, DimensionDataType.UNSIGNED_LONG);
        List<Integer> docsWithField3 = new ArrayList<>(500);
            builder.getRootNode(),
        List<Integer> metricsWithField2 = List.of(0, 1, 2, 3, 4);
         [18, 7, null, null] | [147800.0, 40]
            dimList3,
        SegmentWriteState consumerWriteState = getWriteState(DocIdSetIterator.NO_MORE_DOCS, writeState.segmentInfo.getId());
                }
        List<Integer> docsWithField2 = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
            for (int j = 0; j < 5; j++) {
            builder.getRootNode(),
        );
                } else if (starTreeDocument.dimensions[0] == null) {
        dimValueMap.put(Long.MAX_VALUE, 5000.0);
            getLongFromDouble(20.0),
        );
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
        double sum = 0;
         [4, 4] | [8]
        );
        validateStarTreeFileFormats(
    public void testMergeFlowWithSum() throws IOException {
            "4"
        builder.build(starTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
            () -> new SortedNumericStarTreeValuesIterator(d3sndv),
            compositeField
        List<Long> dimList4 = List.of(5L, 6L, 7L, 8L, -1L);
import static org.opensearch.index.compositeindex.datacube.startree.builder.BuilderTestsUtils.validateStarTree;
import org.apache.lucene.index.DocValues;
        LinkedHashMap<String, DimensionConfig> map = new LinkedHashMap<>();
        /**
            getSortedNumericMock(metricsList2, metricsWithField2),
import org.opensearch.index.compositeindex.datacube.startree.fileformats.meta.DimensionConfig;
    }
            builder.getStarTreeDocuments().size(),
        writeState = getWriteState(6, writeState.segmentInfo.getId());
            count++;
                if (starTreeDocument.dimensions[0] != null) {
        metaOut.close();
import java.util.Map;
         [5, 5] | [5]
         * [6,-1] | [120.0]
        }
            "field5",
            "field3",
            dimValueMap.put((long) i, 10.0);
            compositeField,
        List<Long> metricsList21 = List.of(
        for (StarTreeDocument starTreeDocument : builder.getStarTreeDocuments()) {
        Dimension d3 = new NumericDimension("field5");
        List<Long> metricsList = List.of(0L, 1L, 2L, 3L, 4L, 5L, 6L);
        );
        List<Long> dimList = List.of(0L, 1L, 3L, 4L, 5L, 6L);
                    assertEquals(5L, (long) starTreeDocument.dimensions[1]);
            compositeField,
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.mergeStarTrees(List.of(starTreeValues, starTreeValues2));
            metricsWithField1,
                    assertEquals(10L, starTreeDocument.metrics[1]);
        validateStarTree(builder.getRootNode(), 4, compositeField.getStarTreeConfig().maxLeafDocs(), builder.getStarTreeDocuments());
            writeState,
        validateStarTreeFileFormats(
         [5, 5] | [5]
        for (StarTreeDocument starTreeDocument : builder.getStarTreeDocuments()) {
         [1655288032000, 1655288032000, 1655288032000, 8] | [80.0, 8]
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
        }
         [1655288092000, 1655288092000, 1655288092000, 4] | [40.0, 4]
        );
            builder.getStarTreeDocuments()
        StarTreeValues starTreeValues = getStarTreeValues(
        StarTreeField sf,
        List<Long> metricsList = List.of(0L, 1L, 2L, 3L, 4L, 5L, 6L);
                sf.getMetrics().get(0).getMetrics().get(1).getTypeName()
            count++;
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.mergeStarTrees(List.of(starTreeValues, starTreeValues2));
            docCountMetricsList,
    }
            metricsList1.add(1L);
            getSortedNumericMock(metricsList2, metricsWithField2),
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.mergeStarTrees(List.of(starTreeValues, starTreeValues2));
        List<Integer> metricsWithField21 = List.of(0, 1, 2, 3, 4);
         */
            for (int j = 0; j < 20; j++) {
        writeState = getWriteState(6, writeState.segmentInfo.getId());
        );
            count++;
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
            }
                            assertEquals(10L, starTreeDocument.metrics[1]);
                    assertEquals(9L, starTreeDocument.metrics[0]);
public class StarTreeBuilderMergeFlowTests extends StarTreeBuilderTestCase {
        LinkedHashMap<String, DimensionConfig> map = new LinkedHashMap<>();
        SortedNumericDocValues d2sndv = getSortedNumericMock(dimList2, docsWithField2);
            writeState,
        );
        expectedDimToValueMap.put(3, dimValueMap);
        List<Integer> docsWithField6 = List.of(0, 1, 2, 3);
        int count = 0;
        StarTreeMetadata starTreeMetadata = getStarTreeMetadata(
import java.util.Objects;
         [5, 5] | [10]
         ---------------
            writeState,
            builder.getRootNode(),
        List<Long> metricsList1 = new ArrayList<>(100);
        List<Integer> metricsWithField21 = List.of(0, 1, 2, 3, 4);
        List<Long> metricsList = List.of(0L, 1L, 2L, 3L, 4L, 5L, 6L);
        compositeField = getStarTreeField(MetricStat.SUM);
            getSortedNumericMock(metricsList, metricsWithField),
        dataOut.close();
        // builder.getStarTreeDocuments().size(),
        SortedNumericDocValues metricsList1,
import java.io.IOException;
            compositeField
                sf.getName(),
            getSortedNumericMock(dimList, docsWithField),
        builder.appendDocumentsToStarTree(starTreeDocumentIterator);
        for (StarTreeDocument starTreeDocument : builder.getStarTreeDocuments()) {
            () -> new SortedNumericStarTreeValuesIterator(d2sndv)
            getSortedNumericMock(metricsList, metricsWithField),
        String number
    }
        Map<String, Supplier<StarTreeValuesIterator>> f2metricDocIdSetIterators = Map.of(
        for (StarTreeDocument starTreeDocument : starTreeDocuments) {
import static org.opensearch.index.compositeindex.datacube.startree.builder.BuilderTestsUtils.getSortedSetMock;
            "field3",
            // metric = no of docs * 10.0
        SortedNumericDocValues dimList2,
            getSortedNumericMock(dimList2, docsWithField2),
        map.put("field3", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.UNSIGNED_LONG));
         * Asserting following dim / metrics [ dim1, dim2 / Count [ metric] ]
        docValuesConsumer.close();
            dimList2,
        assertEquals(6, builder.getStarTreeDocuments().size());
            getSortedNumericMock(dimList, docsWithField),
        /**
            () -> new SortedNumericStarTreeValuesIterator(valucountsndv),
        }
        }
            getSortedNumericMock(dimList, docsWithField),
                dimList1.add((long) i);
            if (count < 1000) {
                docsWithField3.add(i * 5 + j);
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
            getLongFromDouble(10.0),
        }
            metricsListValueCount.add((long) i);
        }
            getLongFromDouble(60.0),
import org.opensearch.index.codec.composite.composite912.Composite912DocValuesFormat;
        testMergeFlowWithSum();
        List<Integer> metricsWithField = List.of(0, 1, 2, 3, 4, 5, 6);
            f2dimDocIdSetIterators,
        map.put("field1", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
        List<Long> metricsList2 = List.of(5L, 6L, 7L, 8L, 9L);
            builder.getStarTreeDocuments()
        StarTreeValues starTreeValues2 = getStarTreeValues(
         [2, 1, 10, 10] | [5200.0, 10]
         * Asserting following dim / metrics [ dim1, dim2 / Count [ metric] ]
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
        }
            builder.getRootNode(),
            fullyQualifiedFieldNameForStarTreeMetricsDocValues(
        List<Long> dimList3 = List.of(5L, 6L, 7L, 8L, -1L);
        SortedNumericDocValues metricsList,
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.mergeStarTrees(List.of(starTreeValues, starTreeValues2));
    private StarTreeValues getStarTreeValues(
            getSortedNumericMock(dimList2, docsWithField2),
        expectedDimToValueMap.put(0, dimValueMap);
         [1, 1] | [1]
        Dimension d2 = new ReadDimension("field3", DocValuesType.SORTED_NUMERIC, DimensionDataType.UNSIGNED_LONG);
        List<Integer> docsWithField3 = new ArrayList<>(500);
            }
    public void testMergeFlowWithMissingDocs() throws IOException {
        int count = 0;
            }
        writeState = getWriteState(0, writeState.segmentInfo.getId());
        SortedNumericDocValues m1sndv = metricsList;
        for (StarTreeDocument starTreeDocument : builder.getStarTreeDocuments()) {
        List<Integer> metricsWithField = new ArrayList<>(1000);
            compositeField,
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
            getSortedNumericMock(dimList, docsWithField),
        List<Integer> docsWithField7 = List.of(0, 1, 2, 3, 4, 6);
        docValuesConsumer.close();
        map.put("field3", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
        int count = 0;
            metricsWithField,
        List<Long> dimList2 = List.of(0L, 1L, 2L, 3L, 4L, 5L, -1L);
            "6"
            }
            }
         [6, 6] | [6]
        StarTreeValues starTreeValues2 = getStarTreeValuesWithKeywords(
        StarTreeMetadata starTreeMetadata = getStarTreeMetadata(map, 6, 1000, 231);
            compositeField,
        }
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.StarTreeValuesIterator;
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
        List<Dimension> dims = List.of(d1, d2, d3, d4);
                assertEquals(2495000L, (long) starTreeDocument.metrics[1]);
            f2metricDocIdSetIterators,
        int count = 0;
        }
        SortedNumericDocValues f2d4sndv = getSortedNumericMock(dimList4, docsWithField4);
            dimValueMap.put((long) i, 10.0);
    public void testMergeFlowWithDuplicateDimensionValueWithMaxLeafDocs() throws IOException {
        compositeField = getStarTreeFieldWithDocCount(3, true);
        );
                dimList1.add((long) i);
        List<Long> dimList3 = List.of(5L, 6L, 8L, -1L);
            "6"
            // metric = no of docs * 10.0
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
                sf.getName(),
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
         [1655288092000, 1655288092000, 1655288092000, 1] | [10.0, 1]
        List<Long> dimList3 = List.of(5L, 6L, 8L, -1L);
        metaOut.close();
        );
        List<Long> dimList4 = List.of(1655288152000L, 1655288092000L, 1655288032000L, -1L);
         * Asserting following dim / metrics [ dim1, dim2 / Sum [ metric] ]
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
        List<Long> metricsList = new ArrayList<>(100);
            if (count <= 9) {
        List<Integer> metricsWithField,
         [4, 4] | [4]
            null,
        for (int i = 0; i < 100; i++) {
        metaOut.close();
        builder.build(starTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
         [6,-1] | [12]
            getLongFromDouble(60.0)
            fullyQualifiedFieldNameForStarTreeMetricsDocValues(
            if (count <= 10) {
        map.put("field1", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
            dimList3.add((long) (i % 2 == 0 ? i : -i));
        builder.appendDocumentsToStarTree(starTreeDocumentIterator);
            metricsWithField,
    }
        );
        map.put("field1", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
        StarTreeMetadata starTreeMetadata = getStarTreeMetadata(
         [null, null, null, 7] | [70.0, 7]
            metricsList,
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
        SortedNumericDocValues valucountsndv = getSortedNumericMock(metricsListValueCount, metricsWithFieldValueCount);
                assertEquals(starTreeDocument.dimensions[0] * 10.0, ((CompensatedSum) starTreeDocument.metrics[1]).value(), 0);
        dataOut.close();
         */
            docsWithField2,
                    sf.getName(),
        metaOut.close();
        builder.appendDocumentsToStarTree(starTreeDocumentIterator);
        );
            metricsListValueCount.add((long) i);
                sf.getName(),
        );
    }
            "sf_field2_sum_metric",
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
            builder.getStarTreeDocuments()
            getLongFromDouble(40.0)
         [null, 7] | [7]
            builder.getStarTreeDocuments().size(),
        List<Integer> metricsWithField2 = List.of(0, 1, 2, 3, 4);
    }
            docsWithField3.add(i);
        builder.build(starTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
        List<Integer> docsWithField3 = new ArrayList<>(1000);
            () -> new SortedNumericStarTreeValuesIterator(metricsList)
                if (starTreeDocument.dimensions[0] == null) {
            15345
            fullyQualifiedFieldNameForStarTreeMetricsDocValues(
import java.util.Set;
        metaOut.close();
import static org.mockito.Mockito.when;
        List<Long> dimList = List.of(0L, 0L, 0L, 0L);
            int dimId = entry.getKey();
import static org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils.fullyQualifiedFieldNameForStarTreeMetricsDocValues;
        // );
        );
         [null, 7] | [7]
            metricDocIdSetIterators,
        );
            getLongFromDouble(40.0),
        metricDocIdSetIterators.put(
            getSortedNumericMock(dimList2, docsWithField2),
        dimValueMap = new HashMap<>();
        builder.appendDocumentsToStarTree(starTreeDocumentIterator);
            getSortedNumericMock(dimList2, docsWithField2),
        builder.build(starTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
            docsWithField4.add(i);
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
            }
        metaOut.close();
            if (count <= 6) {
            "4"
        compositeField = getStarTreeField(MetricStat.VALUE_COUNT);
        );
                docsWithField4.add(i * 5 + j);
            ),
         */
            writeState,
            getStarTreeDimensionNames(compositeField.getDimensionsOrder()),
            }
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
            dimDocIdSetIterators,
            Collections.emptyList(),
                        } else if (starTreeDocument.dimensions[0] != null && starTreeDocument.dimensions[1] != null) {
        List<Long> dimList = List.of(0L, 1L, 2L, 3L, 4L);
            null
        List<Long> metricsList = List.of(0L, 1L, 2L, 3L, 4L, 5L, 6L);
            compositeField.getStarTreeConfig().maxLeafDocs(),
            }
            dimList2.add((long) 1);
         [3, 3] | [3]
            starTreeMetadata,
            dimList4,
            docsWithField4.add(i);
                } else {
                assertEquals(starTreeDocument.dimensions[0] * 20.0, ((CompensatedSum) starTreeDocument.metrics[1]).value(), 0);
            compositeField,
            dimList1.add((long) i);
            getLongFromDouble(0.0),
    }
                dimList4.add((long) i);
         [5, 5] | [5, 50.0]
        compositeField = getStarTreeFieldWithKeywords(random().nextBoolean());
        LinkedHashMap<String, DimensionConfig> map = new LinkedHashMap<>();
                } else if (starTreeDocument.dimensions[0] == 0) {
        Map<Integer, Map<Long, Integer>> dimValueToDocIdMap = new HashMap<>();
            "field1",
        List<Long> dimList4 = List.of(5L, 6L, 7L, 8L, -1L);
        }
            "9"
            dimValueMap.put((long) i, 200.0);
        List<Integer> metricsWithField1,
        List<Integer> docsWithField4 = List.of(0, 1, 2, 3, 4);
        );
        map.put("field1", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
        ).build(new Mapper.BuilderContext(settings, new ContentPath()));
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
        List<Integer> metricsWithField = new ArrayList<>(1000);
            dimValueMap.put((long) i, 10.0);
            () -> new SortedNumericStarTreeValuesIterator(d4sndv)
        map.put("field3", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
            for (int j = 0; j < 5; j++) {
         [5, 5] | [10]
            dimList3,
        );
        builder.appendDocumentsToStarTree(starTreeDocumentIterator);
            metricDocIdSetIterators,
         * Asserting following dim / metrics [ dim1, dim2 / Count [ metric] ]
    public StarTreeBuilderMergeFlowTests(StarTreeFieldConfiguration.StarTreeBuildMode buildMode) {
        List<Integer> metricsWithFieldValueCount = new ArrayList<>(1000);
        List<Long> dimList2 = List.of(0L, 1L, 2L, 3L, 4L, 5L, 6L, -1L, -1L, -1L);
        for (int i = 0; i < 100; i++) {
            builder.getRootNode(),
            getSortedNumericMock(metricsList, metricsWithField),
                assertEquals(
        LinkedHashMap<String, DimensionConfig> map = new LinkedHashMap<>();
        StarTreeValues starTreeValues2 = getStarTreeValues(
        builder.build(starTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
                long dimValue = dimValueToDocIdEntry.getKey();
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
            starTreeMetadata,
            getSortedNumericMock(dimList, docsWithField),
            metricsWithField1,
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
            starTreeMetadata,
            getLongFromDouble(40.0),
    public void testMergeFlowWithMissingDocsWithZeroComplexCase() throws IOException {
        );
        validateStarTree(builder.getRootNode(), 2, 1000, builder.getStarTreeDocuments());
        );
        }
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
            if (count <= 6) {
            compositeField.getStarTreeConfig().maxLeafDocs(),
         [1, 1] | [1]
        );
            dimList4,
         [8, 8] | [8]
         * [5, 5] | [100.0]
            () -> new SortedNumericStarTreeValuesIterator(m1sndv)
            builder.getStarTreeDocuments().size(),
        List<Long> dimList7 = List.of(1655288152000L, 1655288092000L, 1655288032000L, 1655287972000L, 1655288092000L, 1655288092000L, -1L);
            getStarTreeDimensionNames(compositeField.getDimensionsOrder()),
                "field2",
            builder.getRootNode(),
        List<Integer> docsWithField4 = new ArrayList<>(1000);
        for (int i = 0; i < 10; i++) {
        List<Long> dimList1 = new ArrayList<>(500);
         [null, 5] | [5]
import org.opensearch.index.compositeindex.datacube.NumericDimension;
    }
            "sf_field2_value_count_metric",
        dataOut.close();
                assertEquals(starTreeDocument.dimensions[0] * 2, (long) starTreeDocument.metrics[0], 0);
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
        dataOut.close();
         */
import static org.opensearch.index.compositeindex.datacube.startree.builder.BuilderTestsUtils.getSortedNumericMock;
        List<Integer> docsWithField4 = List.of(0, 1, 2, 3, 4);
            null,
        );
        );
        List<Integer> docsWithField3 = new ArrayList<>(500);
         [2, 2, 2, 2] | [40.0, 2]
                docsWithField2.add(i * 50 + j);
        /**
        SortedNumericDocValues f2d3sndv = getSortedNumericMock(dimList3, docsWithField3);
        );
        List<Long> dimList2 = List.of(0L, 1L, 2L, 3L, 4L, 5L, -1L);
            builder.getStarTreeDocuments()
        int count = 0;
            compositeField,
        List<Long> metricsList1 = List.of(
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
            dimList1,
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
         */
            docsWithField4,
                } else if (starTreeDocument.dimensions[0] == 0) {
            }
            "field1",
        StarTreeValues starTreeValues = new StarTreeValues(
         [1655288152000, 1655288152000, 1655288152000, 0] | [0.0, 0]
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
            starTreeMetadata,
        validateStarTree(builder.getRootNode(), 2, 1000, builder.getStarTreeDocuments());
         [2, 0, 9, 9] | [4700.0, 10]
                    starTreeDocument.dimensions[0] != null ? starTreeDocument.dimensions[0] * 2 * 10.0 : 40.0,
            dimList2.add((long) i);
        Metric m2 = new Metric("_doc_count", List.of(MetricStat.DOC_COUNT));
         [4, 4, 4, 4] | [80.0, 2]
        }
            metricsWithField.add(i);
            getSortedNumericMock(dimList3, docsWithField3),
            getSortedNumericMock(dimList8, docsWithField8),
            builder.getRootNode(),
            builder.getRootNode(),
        StarTreeMetadata starTreeMetadata = getStarTreeMetadata(map, 10, 1000, 363);
            getSortedNumericMock(metricsList, metricsWithField),
        writeState = getWriteState(4, writeState.segmentInfo.getId());
 */
        map.put("field1", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
            "sf_field2_sum_metric",
         [4, 4] | [4]
                dimList1.add((long) i);
            for (int j = 0; j < 20; j++) {
            () -> new SortedNumericStarTreeValuesIterator(dimList3)
            getSortedNumericMock(metricsList, metricsWithField),
            if (i <= 499) {
         [2, 2] | [2]
            "sf__doc_count_doc_count_metric",
         .....
        StarTreeValues starTreeValues2 = getStarTreeValues(
        for (int i = 0; i < 1000; i++) {
        List<Long> dimList3,
        );
         [2, 2] | [9, 90.0]
        }
        metaOut.close();
         */
        StarTreeMetadata starTreeMetadata = getStarTreeMetadata(map, 6, 1000, 264);
        List<Long> metricsList = List.of(0L, 1L, 2L, 3L, 4L, 5L, 6L);
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
            null
         ...
        List<Long> dimList2 = List.of(1655288152000L, 1655288092000L, 1655288032000L, 1655287972000L, 1655288092000L, 1655288092000L, -1L);
        List<Integer> docsWithField4 = List.of(0, 1, 2, 3, 4);
            getSortedNumericMock(dimList7, docsWithField7),
        /**
                    assertEquals(7, count);
            docsWithField2,
        SortedNumericDocValues f2m2sndv = DocValues.emptySortedNumeric();
        for (Map.Entry<Integer, Map<Long, Integer>> entry : dimValueToDocIdMap.entrySet()) {
            getLongFromDouble(20.0),
        List<Long> metricsList21 = List.of(
         [-5, -5, -5, -5] | [100.0, 2]
        List<Integer> docsWithField1 = new ArrayList<>(500);
            builder.getStarTreeDocuments().size(),
        );
                sf.getMetrics().get(0).getMetrics().get(0).getTypeName()
            () -> new SortedNumericStarTreeValuesIterator(f2m2sndv)
         * Asserting following dim / metrics [ dim1, dim2 / Count [ metric] ]
        for (int i = 0; i < numDocs; i++) {
/*
            getSortedNumericMock(dimList, docsWithField),
        metaOut.close();
            for (MetricStat metricStat : metric.getMetrics()) {
            }
            dimList3,
            builder.getStarTreeDocuments().size(),
        Metric m2 = new Metric("_doc_count", List.of(MetricStat.DOC_COUNT));
        docValuesConsumer.close();
                        } else if (starTreeDocument.dimensions[1] != null && starTreeDocument.dimensions[3] != null) {
        }
         [null, 7] | [7]
        docValuesConsumer.close();
        for (StarTreeDocument starTreeDocument : builder.getStarTreeDocuments()) {
        SortedNumericDocValues d1sndv = getSortedNumericMock(dimList1, docsWithField1);
        compositeField = getStarTreeField(MetricStat.VALUE_COUNT);
                    assertEquals(starTreeDocument.dimensions[1], starTreeDocument.metrics[0]);
        // metricDocIdSetIterators.put("_doc_count", () -> m2sndv);
        builder.appendDocumentsToStarTree(starTreeDocumentIterator);
            () -> new SortedNumericStarTreeValuesIterator(m1sndv),
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
         * [0, 0] | [0.0]
    public void testMergeFlowWithKeywords() throws IOException {
        for (int i = 0; i < 500; i++) {
        // starTreeMetadata,
            () -> new SortedNumericStarTreeValuesIterator(d2sndv),
            }
        List<Long> dimList2 = new ArrayList<>(1000);
        builder.build(starTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
        builder = getStarTreeBuilder(metaOut, dataOut, sf, getWriteState(4, writeState.segmentInfo.getId()), mapperService);
            builder.getRootNode(),
            writeState,
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
            docsWithField1,
        );
            docsWithField2.add(i);
            writeState,
            getSortedNumericMock(dimList, docsWithField),
        assertEquals(9, builder.getStarTreeDocuments().size());
        );
            docsWithField4,
        }
        Map<String, Supplier<StarTreeValuesIterator>> dimDocIdSetIterators = Map.of(
    }
        StarTreeMetadata starTreeMetadata = getStarTreeMetadata(
import org.opensearch.common.settings.Settings;
        );
        List<Integer> docCountMetricsWithField = new ArrayList<>(100);
        List<Integer> docsWithField8 = List.of(0, 1, 3, 4);
        /**
            Map.of(CompositeIndexConstants.SEGMENT_DOCS_COUNT, number),
        List<Integer> docsWithField2 = List.of(0, 1, 2, 6);
        List<Long> metricsList = List.of(0L, 1L, 2L, 3L, 4L, 5L, 6L);
        List<Long> dimList4,
            writeState,
            for (int j = 0; j < 5; j++) {
            100,
         [8, 8] | [8]
        List<Integer> docsWithField = List.of(0, 1, 3, 4, 5, 6);
        map.put("field1", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
        StarTreeValues starTreeValues = getStarTreeValues(
        List<Integer> docsWithField4 = List.of(0, 1, 2, 3, 4);
            builder.getStarTreeDocuments().size(),
                dimList2.add((long) i);
    }
            builder.getStarTreeDocuments()
         [6, 6] | [6]
        List<Long> dimList4 = new ArrayList<>(500);
                sf.getMetrics().get(1).getMetrics().get(0).getTypeName()
        StarTreeValues starTreeValues = getStarTreeValues(
        }
    public void testMergeFlow_randomNumberTypes() throws Exception {
            }
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
        dataOut.close();
        SortedSetDocValues dimList,
                actualDimensionValues.add(starTreeDocument.dimensions[0]);
        );
        );
            metricsWithField,
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
            docsWithField2.add(i);
        );
        Dimension d2 = new NumericDimension("field3");
import org.opensearch.index.mapper.Mapper;
        return new StarTreeValues(sf, null, dimDocIdSetIterators, metricDocIdSetIterators, Map.of(SEGMENT_DOCS_COUNT, number), null);
         [0, 0, 1, 1] | [700.0, 10]
            () -> new SortedNumericStarTreeValuesIterator(f2m1sndv),
         401 docs get generated
        );
            getSortedNumericMock(dimList6, docsWithField6),
        List<Metric> metrics = List.of(m1, m2);
            getLongFromDouble(60.0)
            builder.getStarTreeDocuments()
            for (int j = 0; j < 5; j++) {
        StarTreeFieldConfiguration c = new StarTreeFieldConfiguration(1, new HashSet<>(), getBuildMode());
        }
            31779
import org.opensearch.index.compositeindex.datacube.Metric;
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
                dimList3.add((long) i);
        compositeField = getStarTreeFieldWithDocCount(3, true);
        List<Dimension> dims = List.of(d1, d2, d3, d4);
        SortedNumericDocValues metricsList1,
            }
            getLongFromDouble(50.0),
        List<Long> docCountMetricsList = new ArrayList<>(100);
            getLongFromDouble(0.0),
         [6, 6] | [6]
        List<Integer> docsWithField2 = List.of(0, 1, 2, 3, 4, 5, 6);
        }
        validateStarTree(builder.getRootNode(), 2, 1000, builder.getStarTreeDocuments());
        List<Long> dimList2 = List.of(0L, 0L, 0L, 0L);
         [3, 3] | [3]
                        } else if (starTreeDocument.dimensions[0] != null && starTreeDocument.dimensions[3] != null) {
        assertEquals(10, count);
        List<Integer> docsWithField2 = List.of(0, 1, 2, 3, 4, 5, 6);
        List<Long> dimList4 = new ArrayList<>(numDocs);
            metricsList,
         * [0, 0] | [0.0]
            metricsWithField1,
        StarTreeValues starTreeValues2 = getStarTreeValues(
            () -> new SortedNumericStarTreeValuesIterator(f2d3sndv),
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
        int count = 0;
         * ------------------ We only take non-star docs
            getSortedNumericMock(dimList2, docsWithField2),
            getSortedNumericMock(metricsList, metricsWithField),
        docValuesConsumer.close();
         [1, 1] | [7, 70.0]
        List<Long> dimList1 = new ArrayList<>(500);
        );
            compositeField,
         [0, 0, 2, 2] | [1200.0, 10]
                sf.getName(),
        StarTreeValues starTreeValues2 = new StarTreeValues(
        int numDocs = 1000;
        metricDocIdSetIterators.put(
            for (int j = 0; j < 5; j++) {
            getLongFromDouble(20.0),
            "field1",
        }
            "field3",
        );
        );
        metaOut.close();
        );
        validateStarTreeFileFormats(
        SortedNumericDocValues f2m1sndv = getSortedNumericMock(metricsList, metricsWithField);
            }
        LinkedHashMap<String, DimensionConfig> map = new LinkedHashMap<>();
        for (StarTreeDocument starTreeDocument : builder.getStarTreeDocuments()) {
            writeState,
        List<Integer> docsWithField2 = new ArrayList<>(numDocs);
import org.opensearch.index.compositeindex.datacube.startree.StarTreeDocument;
        SortedNumericDocValues d4sndv = getSortedNumericMock(dimList4, docsWithField4);
        builder.appendDocumentsToStarTree(starTreeDocumentIterator);
        List<Long> dimList3 = List.of(5L, 6L, 8L, -1L);
        SortedNumericDocValues d3sndv = getSortedNumericMock(dimList3, docsWithField3);
            ),
            getSortedNumericMock(metricsList2, metricsWithField2),
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
            docsWithField2,
    }
            () -> new SortedNumericStarTreeValuesIterator(f2d4sndv)
        validateStarTree(builder.getRootNode(), 2, 1000, builder.getStarTreeDocuments());
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
        List<Integer> docsWithField2 = List.of(0, 1, 2, 3, 4, 5, 6);
            false,
        List<Long> dimList3 = new ArrayList<>(1000);
            builder.getStarTreeDocuments().size(),
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
            docsWithField4.add(i);
        for (int i = 0; i < 1000; i++) {
            compositeField.getStarTreeConfig().maxLeafDocs(),
            Map.of(CompositeIndexConstants.SEGMENT_DOCS_COUNT, number),
        docValuesConsumer.close();
        StarTreeValues starTreeValues = new StarTreeValues(
            for (int j = 0; j < 50; j++) {
        StarTreeValues starTreeValues = getStarTreeValues(
            dimList3,
            compositeField
            compositeField,
        SortedNumericDocValues m2sndv = getSortedNumericMock(metricsList1, metricsWithField1);
        List<Integer> docsWithField = List.of(0, 1, 2, 3, 4, 5, 6);
        assertEquals(6, builder.getStarTreeDocuments().size());
        metricDocIdSetIterators.put(
        validateStarTreeFileFormats(
            docsWithField1,
        for (int i = 0; i < 100; i++) {
            DocValues.emptySortedNumeric(),
            compositeField,
            "field1",
            count++;
            metricsList,
            getSortedSetMock(dimList3, docsWithField3),
        List<Integer> docsWithField = List.of(0, 1, 3, 4, 5, 6);
            assertEquals(starTreeDocument.dimensions[3] * 10.0, (Double) ((CompensatedSum) starTreeDocument.metrics[1]).value(), 0);
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.mergeStarTrees(List.of(starTreeValues, starTreeValues2));
            fullyQualifiedFieldNameForStarTreeMetricsDocValues(
            getLongFromDouble(0.0),
        writeState = getWriteState(4, writeState.segmentInfo.getId());
        List<Integer> metricsWithField = new ArrayList<>(100);
            dimList4,
            compositeField,
            compositeField
            writeState,
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.mergeStarTrees(List.of(starTreeValues, starTreeValues2));
            if (count <= 6) {
            "field3",
        Map<String, Supplier<StarTreeValuesIterator>> dimDocIdSetIterators = Map.of(
         * [null, 2] | [40.0]
        List<Integer> docsWithField4,
            randomFrom(NumberFieldMapper.NumberType.values()),
        List<Long> dimList2 = List.of(0L, 1L, 2L, 3L, 4L, 5L, -1L);
            getSortedNumericMock(dimList2, docsWithField2),
         [0, 0] | [0]
        builder.build(builder.mergeStarTrees(List.of(starTreeValues, starTreeValues2)), new AtomicInteger(), docValuesConsumer);
        }
            builder.getRootNode(),
        dimValueMap.put(Long.MAX_VALUE, 200.0);
 * SPDX-License-Identifier: Apache-2.0
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.mergeStarTrees(List.of(starTreeValues, starTreeValues2));
        validateStarTree(builder.getRootNode(), 2, 1000, builder.getStarTreeDocuments());
            getSortedNumericMock(metricsList21, metricsWithField21),
            500,
        List<Integer> docsWithField4 = new ArrayList<>(numDocs);
         [4, 4] | [4]
            builder.getStarTreeDocuments()
            getLongFromDouble(50.0),
            metricsWithField.add(i);
            count++;
            docsWithField4,
            compositeField,
            null,
    public void testMergeFlowWithMissingDocsInSecondDim() throws IOException {
        List<Integer> docsWithField2 = List.of(0, 1, 2, 3, 4, 5, 6);
        StarTreeValues starTreeValues2 = getStarTreeValues(
            compositeField
        StarTreeValues starTreeValues2 = getStarTreeValues(
            dimList4,
        );
         [8, 8] | [8]
            dimList2,
        dataOut.close();
import org.apache.lucene.search.DocIdSetIterator;
                    assertEquals(12L, (long) starTreeDocument.metrics[0]);
            compositeField,
            () -> new SortedNumericStarTreeValuesIterator(d3sndv),
            if (count <= 6) {
            docsWithField4,
            }
            () -> new SortedNumericStarTreeValuesIterator(f2d1sndv),
        List<Long> dimList = List.of(1655288152000L, 1655288092000L, 1655288032000L, 1655287972000L, 1655288092000L, 1655288092000L);
                docsWithField3.add(i * 5 + j);
                assertEquals(starTreeDocument.dimensions[0], (long) starTreeDocument.metrics[0], 0);
        List<Integer> docsWithField2 = new ArrayList<>(500);
        when(mapperService.documentMapper()).thenReturn(documentMapper);
            1000,
        metricDocIdSetIterators.put(
            getAttributes(1000),
                docsWithField3.add(i * 5 + j);
        compositeField = new StarTreeField("sf", dims, metrics, c);
            builder.getStarTreeDocuments()
            "6"
            ),
        /**
 * compatible open source license.
        List<Long> dimList5 = List.of(0L, 1L, 2L, 3L, 4L, 5L, 6L);
            metricsWithField,
            getSortedNumericMock(metricsList1, metricsWithField1),
         [7, 7] | [7]
        compositeField = getStarTreeField(MetricStat.VALUE_COUNT);
                assertEquals(starTreeDocument.dimensions[0] != null ? starTreeDocument.dimensions[0] * 2 : 4, starTreeDocument.metrics[0]);
            builder.getStarTreeDocuments()
        String number
        // metricDocIdSetIterators.put("field2", () -> m1sndv);
            getSortedNumericMock(dimList, docsWithField),
            metricsWithField1,
        List<Integer> docsWithField3 = List.of(0, 1, 3, 4);
    public void testMergeFlowForUnsignedLongWithSum() throws IOException {
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
            getSortedNumericMock(dimList2, docsWithField2),
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, getWriteState(4, writeState.segmentInfo.getId()), mapperService);
        List<Long> dimList1 = new ArrayList<>(500);
        metaOut.close();
        builder.build(starTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
            Map<Long, Double> map = expectedDimToValueMap.get(dimId);
        docValuesConsumer.close();
        validateStarTreeFileFormats(
         */
            getSortedNumericMock(dimList4, docsWithField4),
            getStarTreeDimensionNames(compositeField.getDimensionsOrder()),
            compositeField,
        int count = 0;
            metricsList.add(getLongFromDouble(i * 10.0));
            "6"
        for (int i = 0; i < 100; i++) {
        List<Integer> docsWithField2,
    public void testMergeFlowWithMaxLeafDocsAndStarTreeNodesAssertion() throws IOException {
            assertEquals(starTreeDocument.dimensions[3], starTreeDocument.metrics[0]);
            "6"
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
            getSortedNumericMock(dimList2, docsWithField2),
        List<Integer> metricsWithField = List.of(0, 1, 2, 3, 4, 5, 6);
        List<Integer> docsWithField = List.of(0, 1, 2, 3, 4, 6);
                docsWithField1.add(i * 5 + j);
            "field3",
        StarTreeValues starTreeValues2 = getStarTreeValues(
            "sf_field2_value_count_metric",
            docsWithField2.add(i);
        List<Integer> docsWithField3 = List.of(0, 1, 3, 4);
    public void testMergeFlowWithEmptyFieldsInOneSegment() throws IOException {
        List<Long> metricsList = List.of(0L, 1L, 2L, 3L, 4L, 5L, 6L);
            "4"
        for (StarTreeDocument starTreeDocument : builder.getStarTreeDocuments()) {
                    assertEquals(19L, (long) starTreeDocument.metrics[0]);
        StarTreeMetadata starTreeMetadata = getStarTreeMetadata(
            metricsList,
            () -> new SortedNumericStarTreeValuesIterator(d1sndv),
         * Asserting following dim / metrics [ dim1, dim2 / Sum [ metric] ]
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
        List<Integer> metricsWithField = new ArrayList<>(100);
            dimList1,
                assertEquals(10L, starTreeDocument.metrics[1]);
        }
