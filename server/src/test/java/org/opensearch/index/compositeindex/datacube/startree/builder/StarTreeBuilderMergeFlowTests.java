        SortedSetDocValues dimList2,
        List<Integer> metricsWithField = List.of(0, 1, 2, 3, 4, 5, 6);
        List<Integer> docsWithField1 = new ArrayList<>(1000);
                assertEquals(starTreeDocument.dimensions[1], starTreeDocument.metrics[0]);
        for (StarTreeDocument starTreeDocument : builder.getStarTreeDocuments()) {
        List<Integer> docsWithField3 = List.of(0, 1, 3, 4);
        dataOut.close();
            dimDocIdSetIterators,
        List<Long> dimList2 = new ArrayList<>(500);
            132165  
            writeState,
        }
    }  
        );
            }
        StarTreeMetadata starTreeMetadata = getStarTreeMetadata(  
            100,
                    metric.getField(),  
            () -> new SortedNumericStarTreeValuesIterator(dimList),  
            getStarTreeDimensionNames(compositeField.getDimensionsOrder()),
        }  
            () -> new SortedNumericStarTreeValuesIterator(valucountsndv),  
        builder.build(starTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION  
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
         ---------------  
        List<Long> dimList2 = List.of(0L, 1L, 2L, 3L, 4L, 5L, -1L);  
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
            null,  
        metaOut.close();
        assertEquals(6, builder.getStarTreeDocuments().size());  
        /**
        compositeField = getStarTreeField(MetricStat.VALUE_COUNT);
            dimList1,
        SortedNumericDocValues metricsList,
        metricDocIdSetIterators.put(
            "field3",
                docsWithField1.add(i * 5 + j);
            docsWithField2,
        List<Integer> docsWithField2 = List.of(0, 1, 2, 3, 4, 5, 6);
                    sum += ((CompensatedSum) starTreeDocument.metrics[0]).value();
            compositeField.getStarTreeConfig().maxLeafDocs(),  
        List<Long> metricsList = List.of(0L, 1L, 2L, 3L, 4L, 5L, 6L);  
         [3, 3] | [3]
        validateStarTree(builder.getRootNode(), 2, 1000, builder.getStarTreeDocuments());
        StarTreeMetadata starTreeMetadata = getStarTreeMetadata(map, 6, 1000, 264);
        metaOut.close();
            getStarTreeDimensionNames(compositeField.getDimensionsOrder()),  
        docValuesConsumer.close();  
            100,
            docsWithField4,
        Map<String, Supplier<StarTreeValuesIterator>> metricDocIdSetIterators = Map.of(
        // Initialize the mock MergeState within the method  
            builder.getRootNode(),
            getSortedSetMock(dimList4, docsWithField4),
            docsWithField2.add(i);
    private StarTreeValues getStarTreeValues(
        List<Long> dimList2 = List.of(0L, 0L, 0L, 0L);
        SortedNumericDocValues d3sndv = getSortedNumericMock(dimList3, docsWithField3);  
            10,  
            () -> new SortedNumericStarTreeValuesIterator(f2m2sndv)
        List<Integer> docsWithField2 = List.of(0, 1, 2, 3, 4, 6);
         [7, 7] | [7]
import org.opensearch.index.codec.composite.composite912.Composite912DocValuesFormat;  
        );  
import java.util.Set;
        }
            () -> new SortedNumericStarTreeValuesIterator(m2sndv)
    }
            builder.getStarTreeDocuments()
        validateStarTreeFileFormats(
        }
            assertEquals(starTreeDocument.dimensions[3], starTreeDocument.metrics[0]);
            getSortedNumericMock(dimList2, docsWithField2),
        }  
        SortedNumericDocValues f2valucountsndv = getSortedNumericMock(metricsListValueCount, metricsWithFieldValueCount);
            "sf_field2_sum_metric",  
            dimValueMap.put((long) i, 50.0);
            builder.getStarTreeDocuments().size(),
        List<Long> dimList2 = new ArrayList<>(500);
            "field1_hour",  
            builder.getStarTreeDocuments().size(),  
        List<Integer> docsWithField3 = List.of(0, 1, 3, 4);  
            getAttributes(500),
                    && starTreeDocument.dimensions[2] != null
        );
        NumberFieldMapper numberFieldMapper2 = new NumberFieldMapper.Builder(
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
         [5, 5] | [5]
         [6, 6] | [6]
        List<Integer> docsWithField2 = new ArrayList<>(500);  
        List<Integer> metricsWithField2 = List.of(0, 1, 2, 3, 4);  
        }
            getSortedNumericMock(dimList3, docsWithField3),
            getLongFromDouble(60.0),
        List<Long> metricsList1 = List.of(
        map.put("field1", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.UNSIGNED_LONG));
            metricsList,  
        List<Long> dimList2 = new ArrayList<>(500);
        List<Integer> docsWithField4 = List.of(0, 1, 2, 3, 4);
            dimList4.add((long) i);  
        List<Long> metricsList = List.of(
                } else if (starTreeDocument.dimensions[1] == null) {  
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.mergeStarTrees(List.of(starTreeValues, starTreeValues2));
                docsWithField3.add(i * 5 + j);  
            getLongFromDouble(10.0),  
            docsWithField4.add(i);  
            count++;
            metricsList1.add(1L);
        StarTreeValues starTreeValues2 = getStarTreeValues(  
            getSortedNumericMock(dimList2, docsWithField2),  
            getSortedNumericMock(dimList2, docsWithField2),
        SortedNumericDocValues metricsList,  
import org.opensearch.index.compositeindex.datacube.ReadDimension;
        StarTreeValues starTreeValues = getStarTreeValues(
            }  
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,  
        Map<String, Supplier<StarTreeValuesIterator>> dimDocIdSetIterators = Map.of(
        ).build(new Mapper.BuilderContext(settings, new ContentPath()));
                docsWithField1.add(i * 20 + j);  
            }
            starTreeMetadata,
        List<Integer> docsWithField = List.of(0, 1, 2, 3, 4);
import org.opensearch.index.mapper.Mapper;
        StarTreeValues starTreeValues2 = getStarTreeValues(  
                docsWithField1.add(i * 20 + j);
            getSortedNumericMock(metricsList, metricsWithField),
            starTreeMetadata,
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
        List<Long> metricsList = List.of(0L, 1L, 2L, 3L, 4L, 5L, 6L, -1L, -1L, -1L);  
        );  
            }
        dataOut.close();  
        Map<String, Supplier<StarTreeValuesIterator>> metricDocIdSetIterators = new LinkedHashMap<>();  
        // metricDocIdSetIterators.put("_doc_count", () -> m2sndv);
    public void testMergeFlowWithKeywords() throws IOException {
            docsWithField3.add(i);
        // TODO: Fix this post 2.19 [Handling search for unsigned-long as part of star-tree]  
            builder.getStarTreeDocuments()
            () -> new SortedNumericStarTreeValuesIterator(f2d4sndv)
        compositeField = getStarTreeFieldWithDocCount(10, true);
            compositeField
        for (StarTreeDocument starTreeDocument : starTreeDocuments) {
                } else if (starTreeDocument.dimensions[0] == null) {
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
        }  
        metaOut.close();  
         [null, null] | [12]
            if (count <= 6) {
            null
            getSortedNumericMock(metricsList, metricsWithField),
            "field1",
         [null, null, null, null] | [2495000.0, 1000]
            docsWithField1,  
            () -> new SortedNumericStarTreeValuesIterator(d3sndv),
        List<Integer> metricsWithField = List.of(0, 1, 2, 3, 4, 5, 6);  
import org.opensearch.index.mapper.NumberFieldMapper;  
            metricsList,
            compositeField
        StarTreeValues starTreeValues2 = getStarTreeValues(
         */
        List<Long> dimList1 = new ArrayList<>(500);
         [4, 4] | [4]
        List<Integer> docsWithField3 = List.of(0, 1, 3, 4);  
 * this file be licensed under the Apache-2.0 license or a
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,  
            "field3",
        map.put("field3", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
                assertEquals(map.get(dimValue) * 2, starTreeDocuments.get(docId).metrics[0]);
            ),  
        );  
        validateStarTreeFileFormats(
            docsWithField2,
            } else {  
        List<Integer> docsWithField = List.of(0, 1, 2, 6, 8);  
        List<Integer> metricsWithField21 = List.of(0, 1, 2, 3, 4);  
        );  
                expectedDimensionValues.add((long) -(numDocs - i) * 2 + 1); // Negative odd numbers in decreasing order
        for (int i = 0; i < 20; i++) {
            builder.getRootNode(),
         */
            getSortedNumericMock(dimList5, docsWithField5),  
            getSortedNumericMock(metricsList, metricsWithField),
    }
            () -> new SortedNumericStarTreeValuesIterator(f2d1sndv),
        dataOut.close();
        metricDocIdSetIterators.put(
            docsWithField3,  
         [0, 0, 0, 0] | [0.0, 2]
        builder.build(starTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
            getLongFromDouble(60.0)
        StarTreeValues starTreeValues = new StarTreeValues(
            metricsList,  
            metricsWithField,
            "6"
            metricDocIdSetIterators,  
            dimDocIdSetIterators,
        for (StarTreeDocument starTreeDocument : builder.getStarTreeDocuments()) {  
        StarTreeValues starTreeValues = new StarTreeValues(
        List<StarTreeDocument> starTreeDocuments = builder.getStarTreeDocuments();
        }
                assertEquals(starTreeDocument.dimensions[0] * 20.0, ((CompensatedSum) starTreeDocument.metrics[0]).value(), 0);  
         [0, 0, 1, 1] | [700.0, 10]  
        docValuesConsumer.close();
        List<Long> dimList = List.of(1655288152000L, 1655288092000L, 1655288032000L, 1655287972000L, 1655288092000L, 1655288092000L);
            builder.getStarTreeDocuments()
        List<Long> dimList2 = new ArrayList<>(numDocs);  
        }  
         * [1, 1] | [20.0]  
        }  
package org.opensearch.index.compositeindex.datacube.startree.builder;
            "4"
        int count = 0;
import java.util.LinkedHashMap;  
        List<Integer> docsWithField4 = List.of(0, 1, 2, 3, 4);  
        for (int i = 80; i < 100; i++) {
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);  
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
        );  
        List<Long> dimList1 = new ArrayList<>(numDocs);
         * Asserting following dim / metrics [ dim1, dim2 / Count [ metric] ]  
        MappingLookup fieldMappers = new MappingLookup(
            for (int j = 0; j < 5; j++) {  
        );  
            "field5",
                sf.getName(),  
        assertEquals(7, builder.getStarTreeDocuments().size());
            getSortedSetMock(dimList3, docsWithField3),  
        validateStarTree(builder.getRootNode(), 2, 1000, builder.getStarTreeDocuments());
        List<Long> metricsList = List.of(0L, 1L, 2L, 3L, 4L, 5L, 6L);  
            getLongFromDouble(10.0),  
        map.put("field3", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
        List<Long> dimList3 = List.of(5L, 6L, 8L, -1L);
import org.opensearch.index.mapper.MappingLookup;
            builder.getRootNode(),
         [0, 0] | [5, 50.0]
            compositeField,
         [5, 5] | [5]  
            dimValueMap.put((long) i, 10.0);  
        SegmentWriteState consumerWriteState = getWriteState(DocIdSetIterator.NO_MORE_DOCS, writeState.segmentInfo.getId());
            getSortedNumericMock(dimList, docsWithField),
        );
            getSortedNumericMock(metricsList21, metricsWithField21),  
            docsWithField3,  
            getLongFromDouble(10.0),
        builder.build(starTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
        );  
            DocValues.emptySortedNumeric(),  
        compositeField = getStarTreeField(MetricStat.VALUE_COUNT);
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
        List<Long> dimList3 = List.of(5L, 6L, 8L, -1L);
        Map<String, Supplier<StarTreeValuesIterator>> f2metricDocIdSetIterators = Map.of(
         [null, 7] | [7]
        map.put("field3", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
            }  
        StarTreeField sf = getStarTreeField(MetricStat.VALUE_COUNT);
        );
        List<Integer> docsWithField3 = List.of(0, 1, 3, 4);
            dimList3,  
        dataOut.close();
        validateStarTreeFileFormats(
            if (dimId == -1) continue;  
            getSortedNumericMock(metricsList2, metricsWithField2),  
    }  
            getSortedNumericMock(dimList4, docsWithField4),  
        for (StarTreeDocument starTreeDocument : builder.getStarTreeDocuments()) {
        for (StarTreeDocument starTreeDocument : builder.getStarTreeDocuments()) {
            132165
        for (int i = 0; i < numDocs; i++) {  
                if (starTreeDocument.dimensions[0] == null) {  
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,  
            getAttributes(1000),
            metricsWithField,
        assertEquals(9, builder.getStarTreeDocuments().size());
            getSortedNumericMock(metricsList2, metricsWithField2),
        Metric m2 = new Metric("_doc_count", List.of(MetricStat.DOC_COUNT));
            "sf_field2_value_count_metric",
        );
         [1655288032000, 1655288032000, 1655288032000, 8] | [80.0, 8]
import java.util.Iterator;
            () -> new SortedNumericStarTreeValuesIterator(f2d4sndv)
        compositeField = getStarTreeField(MetricStat.VALUE_COUNT);  
            getSortedNumericMock(dimList, docsWithField),
         [null, 7] | [7]  
        );
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
    }
         [4, 4, 4, 4] | [80.0, 2]
        List<Long> metricsList1 = List.of(  
        expectedDimToValueMap.put(2, dimValueMap);
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);  
        List<Long> dimList4 = List.of(1655288152000L, 1655288092000L, 1655288032000L, -1L);
            writeState,
    }  
         * [4, 4] | [80.0]
         [3, 3] | [3]
                    assertEquals(starTreeDocument.dimensions[1], starTreeDocument.metrics[0]);
        StarTreeMetadata starTreeMetadata = getStarTreeMetadata(  
        List<Long> metricsList1 = new ArrayList<>(100);
                    assertEquals(9L, starTreeDocument.metrics[0]);  
            metricsList.add(getLongFromDouble(i * 10.0));
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.mergeStarTrees(List.of(starTreeValues, starTreeValues2));
         * Asserting following dim / metrics [ dim1, dim2 / Count [ metric] ]  
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
            if (count <= 6) {  
         * Asserting following dim / metrics [ dim1, dim2 / Count [ metric] ]
            () -> new SortedNumericStarTreeValuesIterator(f2valucountsndv),
            null
            "4"
        builder.build(starTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
            builder.getRootNode(),
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
        for (int i = 0; i < 500; i++) {
        int count = 0;  
        }
            docsWithField4.add(i);
        List<Long> dimList2 = List.of(0L, 1L, 2L, 3L, 4L, 5L, -1L);
            for (int j = 0; j < 5; j++) {
        StarTreeValues starTreeValues = getStarTreeValuesWithDates(
        compositeField = getStarTreeFieldWithDocCount(3, true);
            getSortedNumericMock(dimList2, docsWithField2),  
        List<Integer> metricsWithField2 = List.of(0, 1, 2, 3, 4);  
        validateStarTree(builder.getRootNode(), 2, 1000, builder.getStarTreeDocuments());  
        docValuesConsumer.close();
        );
            getSortedNumericMock(dimList3, docsWithField3),
        validateStarTreeFileFormats(
        StarTreeValues starTreeValues = new StarTreeValues(
            getSortedNumericMock(metricsList, metricsWithField),
import java.util.List;
        double sum = 0;
            Collections.emptyList(),
        List<Long> dimList3 = List.of(5L, 6L, 8L, -1L);
        List<Long> dimList = List.of(0L, 1L, 3L, 4L, 5L, 6L);  
        );
        docValuesConsumer.close();
            "field3",  
        List<Integer> docsWithField1 = new ArrayList<>(500);
            builder.getStarTreeDocuments()
            writeState,
        }  
        List<Integer> docsWithField4 = List.of(0, 1, 2, 3, 4);
            docsWithField2,
        List<Long> dimList = List.of(0L, 1L, 3L, 4L, 5L, 6L);
        List<Integer> docsWithField4 = List.of(0, 1, 2, 3, 4);  
        /**  
        List<Long> metricsList2 = List.of(5L, 6L, 7L, 8L, 9L);
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedNumericStarTreeValuesIterator;
            Map.of(CompositeIndexConstants.SEGMENT_DOCS_COUNT, number),  
    ) {  
        List<Long> metricsList2 = List.of(5L, 6L, 7L, 8L, 9L);
            if (i <= 499) {
        List<Long> dimList2 = List.of(0L, 1L, 2L, 3L, 4L, 6L);
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,  
            getSortedNumericMock(metricsList2, metricsWithField2),
        map.put("field3", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));  
        StarTreeValues starTreeValues2 = getStarTreeValues(
            }
        );
         [1, 1] | [1]
        return starTreeValues;  
            builder.getStarTreeDocuments()
            () -> new SortedNumericStarTreeValuesIterator(f2d2sndv),  
            Set.of(numberFieldMapper1, numberFieldMapper2, numberFieldMapper3),  
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
                assertEquals(2L, starTreeDocument.metrics[2]);
        List<Integer> metricsWithField2 = List.of(0, 1, 2, 3, 4);
        );
    private StarTreeValues getStarTreeValuesWithDates(  
    public void testMergeFlowWithMaxLeafDocs() throws IOException {  
            metricsList.add(getLongFromDouble(10.0));
        SortedNumericDocValues m2sndv = DocValues.emptySortedNumeric();
            dimList3,  
            builder.getStarTreeDocuments()
        List<Long> metricsList2 = List.of(5L, 6L, 7L, 8L, 9L);  
    public void testMergeFlowWithCount() throws IOException {
                        } else if (starTreeDocument.dimensions[1] != null && starTreeDocument.dimensions[3] != null) {
        metricDocIdSetIterators.put(
        List<Long> dimList4 = new ArrayList<>(500);  
            count++;
        // builder.getStarTreeDocuments()
            starTreeMetadata,  
         [6, 6] | [6]
         [0, 0] | [9]
            count++;
         [8, 8] | [8]  
import org.apache.lucene.index.DocValuesType;
        /**
        assertEquals(401, count);  
        LinkedHashMap<String, DimensionConfig> map = new LinkedHashMap<>();
                            assertEquals(10L, starTreeDocument.metrics[1]);
                } else if (starTreeDocument.dimensions[0] == 0) {
            }
            dimList2,
        builder.build(builder.mergeStarTrees(List.of(starTreeValues, starTreeValues2)), new AtomicInteger(), docValuesConsumer);
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
        builder.appendDocumentsToStarTree(starTreeDocumentIterator);
            getSortedNumericMock(dimList2, docsWithField2),  
            "field3",
        /**
        List<Long> metricsList,
         [0, 0, 0, 0] | [0.0, 2]
        SortedNumericDocValues d3sndv = getSortedNumericMock(dimList3, docsWithField3);  
        );
        /**
        for (int i = 0; i < 10; i++) {
                && starTreeDocument.dimensions[3] != null) {
         */  
                docsWithField1.add(i * 5 + j);
         [null, 7] | [7]
        );
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
        }
         [5, 5] | [5]  
            () -> new SortedNumericStarTreeValuesIterator(valucountsndv),
            getStarTreeDimensionNames(compositeField.getDimensionsOrder()),
        List<Integer> docsWithField4 = List.of(0, 1, 3, 4);
            metricsWithField.add(i);  
        List<Integer> docsWithField2 = new ArrayList<>(numDocs);
            dimList3,
        }
         [1655288092000, 1655288092000, 1655288092000, 6] | [60.0, 6]
        traverseStarTree(builder.rootNode, dimValueToDocIdMap, true);  
        /**
        for (int i = 0; i < 500; i++) {
            getSortedNumericMock(metricsList, metricsWithField),
                assertEquals(  
         [1, 1] | [1]  
            () -> new SortedNumericStarTreeValuesIterator(metricsList)
        );  
            "4"  
            builder.getRootNode(),
        builder.build(starTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
            metricsList1,  
        ).build(new Mapper.BuilderContext(settings, new ContentPath()));
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
        /**  
        List<Long> dimList2 = List.of(0L, 1L, 2L, 3L, 4L, 5L, -1L);
        StarTreeField sf,  
                actualDimensionValues.add(starTreeDocument.dimensions[0]);
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, getWriteState(4, writeState.segmentInfo.getId()), mapperService);
        StarTreeFieldConfiguration c = new StarTreeFieldConfiguration(1, new HashSet<>(), getBuildMode());  
        StarTreeMetadata starTreeMetadata = getStarTreeMetadata(map, 6, 1000, 231);  
        validateStarTree(builder.getRootNode(), 4, compositeField.getStarTreeConfig().maxLeafDocs(), builder.getStarTreeDocuments());  
        metricDocIdSetIterators.put(  
                assertEquals(sum, ((CompensatedSum) starTreeDocument.metrics[0]).value(), 0);  
         401 docs get generated  
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
        );
            "6"
        for (int i = 0; i < numDocs; i++) {
            }  
            compositeField
            () -> new SortedSetStarTreeValuesIterator(d2sndv)  
                assertEquals(2495000L, (long) starTreeDocument.metrics[1]);
        }
        StarTreeValues starTreeValues = getStarTreeValues(
            builder.getStarTreeDocuments().size(),
        List<Integer> docsWithField1,  
         * Asserting following dim / metrics [ dim1, dim2 / Sum [ metric] ]
        for (int i = 0; i < 500; i++) {
         [3, 3] | [3]  
            compositeField.getStarTreeConfig().maxLeafDocs(),
        Dimension d2 = new ReadDimension("field3", DocValuesType.SORTED_NUMERIC, DimensionDataType.UNSIGNED_LONG);  
        SortedSetDocValues dimList,
        }
            for (Map.Entry<Long, Integer> dimValueToDocIdEntry : entry.getValue().entrySet()) {
        expectedDimToValueMap.put(3, dimValueMap);
        SortedNumericDocValues dimList2,
         * [6,-1] | [120.0]  
        SortedNumericDocValues d4sndv = getSortedNumericMock(dimList4, docsWithField4);
            if (starTreeDocument.dimensions[0] != null
            231
            compositeField,  
            builder.getStarTreeDocuments().size(),  
         * [3, 3] | [60.0]
        for (StarTreeDocument starTreeDocument : builder.getStarTreeDocuments()) {  
        List<Integer> metricsWithField = new ArrayList<>(1000);
        );
            for (int j = 0; j < 20; j++) {
            if (count <= 10) {  
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,  
        List<Integer> docsWithField4 = new ArrayList<>(500);  
            () -> new SortedNumericStarTreeValuesIterator(f2d3sndv),  
            Collections.emptyList(),
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
        );  
        LinkedHashMap<String, DimensionConfig> map = new LinkedHashMap<>();
        List<Long> dimList3 = List.of(5L, 6L, 7L, 8L, -1L);  
         [null, null, null, null] | [2495000.0, 1000]  
            getLongFromDouble(30.0),  
            randomFrom(NumberFieldMapper.NumberType.values()),
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
        validateStarTree(builder.getRootNode(), 2, 1000, builder.getStarTreeDocuments());
            dimList4,
        List<Long> metricsList = new ArrayList<>(1000);  
        for (StarTreeDocument starTreeDocument : builder.getStarTreeDocuments()) {
        );
        );
            builder.getStarTreeDocuments().size(),  
            getStarTreeDimensionNames(compositeField.getDimensionsOrder()),  
        validateStarTreeFileFormats(
            compositeField,
        LinkedHashMap<String, DimensionConfig> map = new LinkedHashMap<>();  
                } else {
        );
        SortedNumericDocValues f2d3sndv = getSortedNumericMock(dimList3, docsWithField3);  
import static org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils.fullyQualifiedFieldNameForStarTreeMetricsDocValues;
        List<Long> metricsList = List.of(0L, 1L, 2L, 3L, 4L, 5L, 6L);
        List<Integer> docsWithField3,
        );
            if (count <= 6) {  
            count++;
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.StarTreeValuesIterator;
            "field3",  
         [null, 7] | [7]
        );
            getSortedNumericMock(dimList2, docsWithField2),  
        List<Long> dimList4 = List.of(5L, 6L, 7L, 8L, -1L);  
        List<Long> docCountMetricsList = new ArrayList<>(100);
        NumberFieldMapper numberFieldMapper3 = new NumberFieldMapper.Builder(
            "6"
        }  
        compositeField = getStarTreeField(MetricStat.VALUE_COUNT);
            }
            metricsList1,  
        );
         [5, 5] | [10]  
            sf,  
        List<Long> dimList = List.of(0L, 1L, 2L, 3L, 4L, 5L, 6L);
            docsWithField3.add(i);  
            getSortedNumericMock(dimList, docsWithField),  
        );
        List<Integer> docsWithField3 = new ArrayList<>(500);
            dimList4,
        List<Long> metricsList = List.of(
        builder.build(starTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
        metaOut.close();
        map.put("field3", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
            getSortedNumericMock(dimList, docsWithField),
         [null, 5] | [5]
        SortedNumericDocValues f2d4sndv = getSortedNumericMock(dimList4, docsWithField4);
        List<Integer> metricsWithField,
        List<Long> dimList4 = List.of(5L, 6L, 7L, 8L, -1L);  
        expectedDimToValueMap.put(0, dimValueMap);
        );
         [1, 0, 7, 7] | [3700.0, 10]  
        List<Integer> metricsWithField = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
            dimList1,
            getSortedNumericMock(dimList8, docsWithField8),
        for (StarTreeDocument starTreeDocument : builder.getStarTreeDocuments()) {  
                    ((CompensatedSum) starTreeDocument.metrics[0]).value(),
    }
        validateStarTree(builder.getRootNode(), 4, compositeField.getStarTreeConfig().maxLeafDocs(), builder.getStarTreeDocuments());  
        List<Integer> metricsWithField = new ArrayList<>(100);
        }
    private StarTreeValues getStarTreeValues(
        compositeField = getStarTreeField(MetricStat.VALUE_COUNT);
            compositeField
        LinkedHashMap<String, DimensionConfig> map = new LinkedHashMap<>();
            getSortedNumericMock(dimList2, docsWithField2),
        dimValueMap.put(Long.MAX_VALUE, 5000.0);  
        for (StarTreeDocument starTreeDocument : builder.getStarTreeDocuments()) {
         [4, 4] | [4, 40.0]
        validateStarTree(builder.getRootNode(), 2, 1000, builder.getStarTreeDocuments());
            dimList3,  
            metricsList.add(getLongFromDouble(i * 10.0));
        compositeField = getStarTreeFieldWithDocCount(3, true);
                dimList3.add((long) i);
import org.apache.lucene.index.DocValues;
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION  
            }
                docsWithField1.add(i * 20 + j);
        }
        List<Integer> metricsWithField = new ArrayList<>(100);
        SortedNumericDocValues d1sndv = getSortedNumericMock(dimList1, docsWithField1);
        List<Long> dimList3 = new ArrayList<>(numDocs);
         */
            31779
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
        );
        }  
        List<Integer> docsWithField2 = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
            compositeField,  
                }  
            }
            Map<Long, Double> map = expectedDimToValueMap.get(dimId);
            getSortedNumericMock(dimList3, docsWithField3),
            docsWithField1,
                sf.getMetrics().get(1).getMetrics().get(0).getTypeName()
            getSortedNumericMock(dimList, docsWithField),
            () -> new SortedNumericStarTreeValuesIterator(dimList2),
        );
            starTreeMetadata,
        List<Long> metricsList = List.of(0L, 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L);
            1000,
        List<Long> metricsList = new ArrayList<>(100);  
            dimList1,
            metricsList,
            starTreeMetadata,  
        List<Integer> docsWithField5 = List.of(0, 1, 2, 3, 4, 5, 6);  
        List<Integer> docsWithField = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
         [null, null, null, 7] | [70.0, 7]  
            dimList4,
            "field3",  
            docsWithField2,
            if (count <= 4) {  
        List<Integer> metricsWithField1 = new ArrayList<>(100);
         [0, 0] | [0]
            getSortedNumericMock(metricsList, metricsWithField),
         [6, 6] | [6]
        for (int i = 0; i < 1000; i++) {  
            "field8",  
        List<Integer> docsWithField3 = new ArrayList<>(1000);  
        compositeField = getStarTreeField(MetricStat.SUM);
                dimList1.add((long) i);
        );
            docCountMetricsWithField.add(i);
import org.opensearch.search.aggregations.metrics.CompensatedSum;
        int count = 0;
    public void testMergeFlow_randomNumberTypes() throws Exception {  
         [2, 2] | [2]  
         */
            getSortedNumericMock(metricsList, metricsWithField),  
            docsWithField1.add(i);  
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
            builder.getRootNode(),  
         * [6,-1] | [120.0]  
        dataOut.close();
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
            getLongFromDouble(30.0),
            docsWithField4,  
    public void testMergeFlowWithDuplicateDimensionValueWithMaxLeafDocs() throws IOException {
                }
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.mergeStarTrees(List.of(starTreeValues, starTreeValues2));
                    assertEquals(starTreeDocument.dimensions[1], starTreeDocument.metrics[0]);
        builder.appendDocumentsToStarTree(starTreeDocumentIterator);  
            "6"
            compositeField,
        for (int i = 0; i < 20; i++) {  
            dimDocIdSetIterators,
            getSortedNumericMock(dimList2, docsWithField2),
            "sf_field2_value_count_metric",
        List<Integer> docsWithField3 = new ArrayList<>(500);
        List<Integer> docsWithField3 = new ArrayList<>(numDocs);
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
                }  
            ),
        );
                            assertEquals(10L, starTreeDocument.metrics[1]);
        List<Long> dimList = List.of(0L, 1L, 2L, 3L, 4L, 6L);
        StarTreeMetadata starTreeMetadata = getStarTreeMetadata(
        testMergeFlowWithSum();
            metricsWithField,
        SortedNumericDocValues m1sndv = getSortedNumericMock(metricsList, metricsWithField);  
         [0, 0, 2, 2] | [1200.0, 10]
            count++;
            null,  
        );
        builder.build(starTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
            null  
            getSortedNumericMock(metricsList, metricsWithField),
        List<Long> metricsListValueCount = new ArrayList<>(1000);
        );
        validateStarTree(builder.getRootNode(), 2, 1000, builder.getStarTreeDocuments());
            builder.getStarTreeDocuments().size(),
            dimList3.add((long) 1);  
        );
    }  
         * Asserting following dim / metrics [ dim1, dim2 / Count [ metric] ]
         [5, 5] | [5, 50.0]  
            docsWithField1,
            getSortedNumericMock(metricsList, metricsWithField),
            "field3",  
            }
            docsWithField4.add(i);  
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,  
            500,
            dimValueMap.put((long) i, 10.0);
                    assertTrue(List.of(5L, 7L).contains(starTreeDocument.dimensions[1]));  
        );  
        List<Long> dimList2 = new ArrayList<>(500);  
        docValuesConsumer.close();  
         * [0, 0] | [0.0]
            dimList1.add((long) (i % 2 == 0 ? i : -i));
        );
            compositeField.getStarTreeConfig().maxLeafDocs(),  
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,  
                docsWithField3.add(i * 5 + j);  
         [18, 7, null, null] | [147800.0, 40]  
    public void testMergeFlowNumSegmentsDocs() throws IOException {  
                dimList4.add((long) i);
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.mergeStarTrees(List.of(starTreeValues, starTreeValues2));
                if (Objects.equals(starTreeDocument.dimensions[0], 5L)) {
            "field1",
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
                }
 * The OpenSearch Contributors require contributions made to  
            compositeField,
        );
        }  
        StarTreeField sf
            } else if (starTreeDocument.dimensions[1] != null  
            dimList1.add((long) i);  
        );  
            sf,
            dimList4.add((long) (i % 2 == 0 ? i : -i));
    public void testMergeFlowWithDocsMissingAtTheEnd() throws IOException {  
        StarTreeValues starTreeValues = getStarTreeValues(  
import java.util.function.Supplier;  
                docsWithField2.add(i * 5 + j);  
         [4, 4, 4, 4] | [80.0, 2]  
        builder.appendDocumentsToStarTree(starTreeDocumentIterator);
        List<Integer> metricsWithField = List.of(0, 1, 2, 3, 4, 5, 6);
         * Asserting following dim / metrics [ dim1, dim2 / Count [ metric] ]  
        for (StarTreeDocument starTreeDocument : builder.getStarTreeDocuments()) {
        Map<String, Supplier<StarTreeValuesIterator>> f2dimDocIdSetIterators = Map.of(  
            getSortedNumericMock(metricsList2, metricsWithField2),  
                sf.getMetrics().get(0).getMetrics().get(1).getTypeName()
                    assertEquals(7L, starTreeDocument.metrics[0]);
        map.put("field1", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));  
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(  
                "_doc_count",
        List<Long> dimList = List.of(0L, 1L, 2L, 3L, 4L, 5L, 6L, -1L, -1L, -1L);
         ...  
        for (int i = 0; i < 100; i++) {  
        List<Integer> docsWithField1 = new ArrayList<>(500);
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
        List<Long> dimList2 = List.of(0L, 1L, 2L, 3L, 4L, 5L, -1L);  
        );  
         [2, 2] | [9, 90.0]  
            100,
        SortedNumericDocValues f2d1sndv = getSortedNumericMock(dimList1, docsWithField1);
                sf.getMetrics().get(0).getMetrics().get(0).getTypeName()
         [4, 4] | [4]
                }
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.mergeStarTrees(List.of(starTreeValues, starTreeValues2));
            getLongFromDouble(0.0),  
        for (int i = 0; i < 1000; i++) {
            getSortedNumericMock(dimList2, docsWithField2),
            builder.getRootNode(),
            () -> new SortedNumericStarTreeValuesIterator(d2sndv),
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);  
         [3, 3] | [3]
            getSortedNumericMock(dimList4, docsWithField4),
         [null, 2] | [2]  
        List<Integer> metricsWithField2 = List.of(0, 1, 2, 3, 4);
            for (int j = 0; j < 5; j++) {  
            ),
    public void testMergeFlowWithEmptyFieldsInOneSegment() throws IOException {  
        List<Integer> docsWithField = List.of(0, 1, 3, 4, 5, 6);  
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
            getLongFromDouble(30.0),  
    }
        List<Integer> docsWithField2,
            getSortedNumericMock(metricsList2, metricsWithField2),  
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
import org.opensearch.index.mapper.ContentPath;
            } else {
        List<Integer> docsWithField4 = List.of(0, 1, 2, 3, 4);
        List<Long> metricsList2 = List.of(5L, 6L, 7L, 8L, 9L);  
            getLongFromDouble(50.0),
        Map<String, Supplier<StarTreeValuesIterator>> dimDocIdSetIterators = Map.of(  
        SortedNumericDocValues d3sndv = getSortedNumericMock(dimList3, docsWithField3);
            metricsWithField.add(i);
        dataOut.close();
         ...
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
            docCountMetricsList,
        List<Integer> metricsWithField = new ArrayList<>(1000);
        SortedNumericDocValues f2m2sndv = DocValues.emptySortedNumeric();
        int count = 0;  
import org.opensearch.index.compositeindex.datacube.NumericDimension;  
        compositeField = getStarTreeField(MetricStat.VALUE_COUNT);  
        StarTreeValues starTreeValues = getStarTreeValues(  
        List<Long> dimList = List.of(0L, 1L, 2L, 3L, 4L);
        StarTreeValues starTreeValues = getStarTreeValues(
        }
                dimList1.add((long) i);  
            getLongFromDouble(0.0),
        for (Map.Entry<Integer, Map<Long, Integer>> entry : dimValueToDocIdMap.entrySet()) {
        dataOut.close();
        builder.appendDocumentsToStarTree(starTreeDocumentIterator);
                sf.getName(),  
         [1, 0, 5, 5] | [2700.0, 10]
            builder.getStarTreeDocuments().size(),  
        List<Integer> docsWithField2 = List.of(0, 1, 2, 3, 4, 5, 6);  
            () -> new SortedNumericStarTreeValuesIterator(m2sndv)
        validateStarTree(builder.getRootNode(), 4, compositeField.getStarTreeConfig().maxLeafDocs(), builder.getStarTreeDocuments());
        metaOut.close();  
            f2metricDocIdSetIterators,
            compositeField,  
        );
        List<Long> dimList5 = List.of(0L, 1L, 2L, 3L, 4L, 5L, 6L);
            metricsWithField1,
            metricsList,
            "field1",
                metricDocIdSetIterators.put(metricFullName, () -> new SortedNumericStarTreeValuesIterator(m1sndv));  
        builder.build(builder.mergeStarTrees(List.of(starTreeValues, starTreeValues2)), new AtomicInteger(), docValuesConsumer);  
        List<Long> dimList = List.of(0L, 0L, 0L, 0L);
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
         [999, 999, 999, 999] | [19980.0]
            dimList2.add((long) i);
         [3, 3] | [3]
            docsWithField3,  
            getLongFromDouble(50.0),  
        Map<String, Supplier<StarTreeValuesIterator>> metricDocIdSetIterators = new LinkedHashMap<>();
                    assertEquals(7, count);  
         [6,-1] | [12]
                }
        List<Long> dimList3 = new ArrayList<>(500);
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(  
            builder.getStarTreeDocuments().size(),
        DocumentMapper documentMapper = mock(DocumentMapper.class);
            }
        for (int i = 0; i < numDocs; i++) {
        );
                    starTreeDocument.dimensions[0] != null ? starTreeDocument.dimensions[0] * 2 * 10.0 : 40.0,
            compositeField,  
        SortedNumericDocValues m2sndv = getSortedNumericMock(metricsList1, metricsWithField1);  
            compositeField
        /**
        map.put("field1", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
        /**
         ...
        StarTreeValues starTreeValues2 = getStarTreeValues(
            "field1_minute",
        );  
         [null, 2] | [4]
        Dimension d1 = new NumericDimension("field1");  
        for (StarTreeDocument starTreeDocument : starTreeDocuments) {  
            metricsList.add(getLongFromDouble(i * 10.0));  
         [2, 1, 10, 10] | [5200.0, 10]  
        List<Integer> docsWithField2 = List.of(0, 1, 2, 3, 4, 5, 6);
                assertEquals(starTreeDocument.dimensions[1], starTreeDocument.metrics[0]);  
            compositeField,
        List<Long> dimList8 = List.of(1655288152000L, 1655288092000L, 1655288032000L, -1L);  
        );
        SortedNumericDocValues f2d3sndv = getSortedNumericMock(dimList3, docsWithField3);
        SortedNumericDocValues m1sndv = metricsList;
                && starTreeDocument.dimensions[1] != null
                    starTreeDocument.dimensions[0] != null ? starTreeDocument.dimensions[0] * 2 * 10.0 : 40.0,
        }
        dataOut.close();  
            getSortedNumericMock(metricsList2, metricsWithField2),
                sf.getMetrics().get(0).getMetrics().get(0).getTypeName()
        List<Integer> docsWithField4 = new ArrayList<>(1000);
        builder.build(starTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
        // starTreeMetadata,  
            dimList2,  
        List<Integer> docsWithField1 = new ArrayList<>(500);
        StarTreeMetadata starTreeMetadata = getStarTreeMetadata(map, 10, 1000, 363);  
        }
        while (starTreeDocumentIterator.hasNext()) {  
        List<Long> dimList4 = new ArrayList<>(500);  
        List<Integer> docsWithField = List.of(0, 1, 2, 6);  
        List<Long> dimList3 = List.of(0L, 1L, 2L, 3L, -1L);
        List<Integer> docsWithField4 = new ArrayList<>(numDocs);  
        /**  
import org.opensearch.index.compositeindex.datacube.DimensionDataType;  
        StarTreeField sf,
            metricsListValueCount.add((long) i);
                        } else if (starTreeDocument.dimensions[0] != null && starTreeDocument.dimensions[1] != null) {
            count++;
        StarTreeValues starTreeValues2 = new StarTreeValues(  
            builder.getStarTreeDocuments()
        );  
        List<Integer> docsWithField1 = new ArrayList<>(numDocs);  
        StarTreeValues starTreeValues = getStarTreeValues(  
        String number  
    }
         */
        );
        StarTreeMetadata starTreeMetadata = getStarTreeMetadata(
            0,  
            docCountMetricsList,  
        StarTreeMetadata starTreeMetadata = getStarTreeMetadata(  
        for (int i = 0; i < numDocs; i++) {
        validateStarTree(builder.getRootNode(), 4, 1, builder.getStarTreeDocuments());  
        );
        );
        StarTreeMetadata starTreeMetadata = getStarTreeMetadata(map, 10, 1000, 363);
            builder.getStarTreeDocuments()  
        for (int i = 0; i < 500; i++) {
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;  
        int count = 0;
        dimValueMap = new HashMap<>();  
            () -> new SortedNumericStarTreeValuesIterator(f2valucountsndv),  
         * Asserting following dim / metrics [ dim1, dim2 / Sum [ metric] ]
        metaOut.close();  
                docsWithField4.add(i * 5 + j);  
        List<Long> dimList = List.of(0L, 1L, 3L, 4L, 5L, 6L);  
            writeState,
        }  
            for (int j = 0; j < 5; j++) {  
            "6"
            docsWithField1.add(i);
         [2, 2, 2, 2] | [1200.0, 10]  
        docValuesConsumer.close();
            docsWithField2,
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,  
        compositeField = new StarTreeField("sf", dims, metrics, c);  
            writeState,
            "7"  
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
            }  
    private StarTreeValues getStarTreeValuesWithKeywords(  
        writeState = getWriteState(4, writeState.segmentInfo.getId());
        map.put("field3", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.UNSIGNED_LONG));  
        dataOut.close();
            writeState,  
                    ((CompensatedSum) starTreeDocument.metrics[0]).value(),
         */  
        List<Long> metricsList21 = List.of(
         [1, 1, 1, 1] | [700.0, 10]
        List<Integer> metricsWithField = List.of(0, 1, 2, 3, 4, 5, 6);
        Dimension d1 = new ReadDimension("field1", DocValuesType.SORTED_NUMERIC, DimensionDataType.UNSIGNED_LONG);
            () -> new SortedNumericStarTreeValuesIterator(d2sndv),  
        docValuesConsumer.close();  
         [1, 1] | [1]
         [1655288152000, 1655288152000, 1655288152000, 5] | [50.0, 5]
        List<Long> metricsList1,  
        Map<Integer, Map<Long, Double>> expectedDimToValueMap = new HashMap<>();  
            getSortedNumericMock(dimList4, docsWithField4),
        }
            getSortedNumericMock(dimList2, docsWithField2),
        );
import static org.opensearch.index.compositeindex.datacube.startree.builder.BuilderTestsUtils.validateStarTree;  
        StarTreeValues starTreeValues2 = getStarTreeValues(
    }
        List<Integer> docsWithField4 = List.of(0, 1, 2, 3, 4);
            dimList4,
            dimList4,
            count++;
            getSortedNumericMock(dimList3, docsWithField3),  
            metricsWithField1.add(i);
    public void testMergeFlowWithMissingDocs() throws IOException {  
            } else {
        );
         [1, 1] | [7, 70.0]
            docsWithField2.add(i);
        SortedSetDocValues d2sndv = dimList2;  
        List<Long> dimList6 = List.of(5L, 6L, 7L, 8L);  
        compositeField = getStarTreeField(MetricStat.VALUE_COUNT);  
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
            () -> new SortedNumericStarTreeValuesIterator(dimList3)  
        SortedNumericDocValues f2m1sndv = getSortedNumericMock(metricsList, metricsWithField);  
        Map<String, Supplier<StarTreeValuesIterator>> f2dimDocIdSetIterators = Map.of(
        List<Integer> metricsWithField = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
            }
        List<Long> dimList2 = List.of(0L, 1L, 2L, 3L, 4L, 5L, -1L);
            () -> new SortedNumericStarTreeValuesIterator(d1sndv),
    ) {
                dimList2.add((long) i);
        dataOut.close();  
            // metric = no of docs * 10.0  
        );
        metaOut.close();
import org.apache.lucene.index.SortedNumericDocValues;
            starTreeMetadata,
            getLongFromDouble(70.0),
        List<StarTreeDocument> starTreeDocuments = builder.getStarTreeDocuments();
         ...
                    assertEquals(19L, (long) starTreeDocument.metrics[0]);
        metaOut.close();
        int numDocs = 1000;
            false,
            1,  
            dimList2,
        return starTreeValues;
            builder.getRootNode(),  
        List<Integer> metricsWithField2 = List.of(0, 1, 2, 3, 4);
            "field1",  
        List<Integer> docsWithField = List.of(0, 1, 3, 4, 5, 6);
                );
        List<Integer> docsWithField1 = new ArrayList<>(500);
         [null, 5] | [5]
        );
        }
        Metric m1 = new Metric("field2", List.of(MetricStat.SUM, MetricStat.AVG, MetricStat.VALUE_COUNT));
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(  
        }
            builder.getStarTreeDocuments().size(),  
        SortedNumericDocValues f2valucountsndv = getSortedNumericMock(metricsListValueCount, metricsWithFieldValueCount);  
            getSortedNumericMock(dimList, docsWithField),
            () -> new SortedNumericStarTreeValuesIterator(f2d2sndv),
            getSortedNumericMock(dimList4, docsWithField4),
                && starTreeDocument.dimensions[2] != null  
                        } else if (starTreeDocument.dimensions[0] != null && starTreeDocument.dimensions[3] != null) {  
            null
        }
            dimList1,
            builder.getStarTreeDocuments().size(),
        builder.build(starTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);  
            "4"
            starTreeMetadata,
        List<Integer> docsWithField8 = List.of(0, 1, 3, 4);
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
            "9"  
            23199  
         [4, 4, 4, 4] | [2200.0, 10]
            for (int j = 0; j < 50; j++) {  
        map.put("field3", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
        List<Long> dimList2 = List.of(0L, 1L, 2L, 3L, 4L, 5L, 6L, -1L, -1L, -1L);  
            starTreeMetadata,
        StarTreeValues starTreeValues = getStarTreeValues(
        );  
         [-1, -1, -1, -1] | [20.0, 2]  
            docCountMetricsList,
        metaOut.close();
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.mergeStarTrees(List.of(starTreeValues, starTreeValues2));
        writeState = getWriteState(4, writeState.segmentInfo.getId());
         [6, 6] | [6]  
            metricsWithField,
            for (MetricStat metricStat : metric.getMetrics()) {  
        List<Integer> docsWithField4 = new ArrayList<>(500);
        SortedNumericDocValues m1sndv = metricsList;
        List<Long> dimList3 = List.of(5L, 6L, 8L, -1L);
import org.opensearch.index.mapper.DocumentMapper;  
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.mergeStarTrees(List.of(starTreeValues, starTreeValues2));  
        }
        validateStarTreeFileFormats(  
         [0, 0] | [0]  
        List<Long> dimList4 = List.of(5L, 6L, 7L, 8L, -1L);
                    assertEquals(starTreeDocument.dimensions[0] * 2, starTreeDocument.metrics[0]);
                sf.getMetrics().get(0).getMetrics().get(1).getTypeName()
        );  
        Dimension d4 = new ReadDimension("field8", DocValuesType.SORTED_NUMERIC, DimensionDataType.UNSIGNED_LONG);
            getLongFromDouble(30.0),
            builder.getStarTreeDocuments()  
        List<Long> dimList3 = new ArrayList<>(500);  
            }  
            dimList2,  
        SortedNumericDocValues d2sndv = getSortedNumericMock(dimList2, docsWithField2);  
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,  
            if (count < 1000) {  
            builder.getStarTreeDocuments().size(),
            () -> new SortedNumericStarTreeValuesIterator(m1sndv),
            count++;
        for (int i = 0; i < 1000; i++) {  
            fullyQualifiedFieldNameForStarTreeMetricsDocValues(
            getSortedNumericMock(dimList4, docsWithField4),
        }
         [5, null] | [5]
         [0, 0, 0, 0] | [200.0, 10]
                sf.getMetrics().get(0).getMetrics().get(0).getTypeName()  
            builder.getRootNode(),
        StarTreeMetadata starTreeMetadata = getStarTreeMetadata(map, 6, 1000, 264);
            f2dimDocIdSetIterators,  
         [0, 0, 3, 3] | [1700.0, 10]
            for (int j = 0; j < 5; j++) {
            getStarTreeDimensionNames(compositeField.getDimensionsOrder()),
            count++;
                assertEquals(starTreeDocument.dimensions[0] != null ? starTreeDocument.dimensions[0] * 2 : 4, starTreeDocument.metrics[0]);
            () -> new SortedNumericStarTreeValuesIterator(d1sndv),
            metricsWithField1,  
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,  
        Dimension d2 = new NumericDimension("field3");
        assertEquals(10, builder.getStarTreeDocuments().size());
         [1, 1] | [1]
            null
        List<Long> dimList2 = List.of(0L, 1L, 2L, 3L, 4L, 5L, -1L);  
            docCountMetricsWithField,
        dimValueMap.put(Long.MAX_VALUE, 200.0);
        for (StarTreeDocument starTreeDocument : builder.getStarTreeDocuments()) {
            metricsWithField.add(i);
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
        Map<String, Supplier<StarTreeValuesIterator>> metricDocIdSetIterators = Map.of(
        List<Long> expectedDimensionValues = new ArrayList<>(1000);  
        );
            "6"  
        validateStarTreeFileFormats(  
            if (count <= 9) {  
            null
                && starTreeDocument.dimensions[3] != null) {
        );
            getSortedNumericMock(metricsList, metricsWithField),
        writeState = getWriteState(0, writeState.segmentInfo.getId());
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
import org.opensearch.index.compositeindex.datacube.startree.StarTreeDocument;
        metaOut.close();
            writeState,
        );
        List<Long> dimList2 = List.of(0L, 1L, 2L, 3L, 4L, 5L, -1L);
                    && starTreeDocument.dimensions[3] != null) {  
        );
                assertEquals(starTreeDocument.dimensions[0] * 2, starTreeDocument.metrics[0]);
         .....
    }
         * [0, 0] | [0.0]
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, getWriteState(4, writeState.segmentInfo.getId()), mapperService);  
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
         */
        compositeField = getStarTreeFieldWithDateDimension();
import org.opensearch.index.compositeindex.datacube.MetricStat;
            if (count <= 6) {
        List<StarTreeDocument> starTreeDocuments = builder.getStarTreeDocuments();
    public void testMergeFlowWithTimestamps() throws IOException {  
        // metricDocIdSetIterators.put("field2", () -> m1sndv);  
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedSetStarTreeValuesIterator;  
            getSortedNumericMock(metricsList, metricsWithField),  
            docsWithField3,  
        }
        List<Integer> docsWithField = List.of(0, 1, 2, 3, 4, 5, 6);  
            () -> new SortedNumericStarTreeValuesIterator(dimList4),
import org.opensearch.common.settings.Settings;
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
        builder.appendDocumentsToStarTree(starTreeDocumentIterator);  
            metricsList.add(getLongFromDouble(i * 2));
            } else {
        List<Integer> docsWithField2 = List.of(0, 1, 2, 3, 4, 5, 6);  
                assertEquals(starTreeDocument.dimensions[3] * 500 + 200.0, ((CompensatedSum) starTreeDocument.metrics[0]).value(), 0);  
            "6"  
            for (int j = 0; j < 5; j++) {
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
            "field8",
        StarTreeMetadata starTreeMetadata = getStarTreeMetadata(map, 10, 1000, 363);
            compositeField,
        for (StarTreeDocument starTreeDocument : builder.getStarTreeDocuments()) {
            getSortedNumericMock(dimList4, docsWithField4),
            metricsWithField.add(i);
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION  
        List<Integer> docsWithField4 = List.of(0, 1, 2, 3, 4);  
            dimList1,
        List<Integer> metricsWithField2 = List.of(0, 1, 2, 3, 4);
        dataOut.close();  
            }
        metaOut.close();
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
         [1655288152000, 1655288152000, 1655288152000, 0] | [0.0, 0]  
        SortedNumericDocValues f2m2sndv = DocValues.emptySortedNumeric();
            () -> new SortedNumericStarTreeValuesIterator(d1sndv),  
            true  
            writeState,
            "6"
                if (starTreeDocument.dimensions[0] == null && starTreeDocument.dimensions[1] == null) {
            count++;
        List<Long> metricsList2 = List.of(5L, 6L, 7L, 8L, 9L);  
            docsWithField4,  
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.mergeStarTrees(List.of(starTreeValues, starTreeValues2));
        validateStarTree(builder.getRootNode(), 2, 1000, builder.getStarTreeDocuments());
        map.put("field1", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
            getLongFromDouble(0.0),  
         [2, 2] | [2]  
        for (int i = 0; i < 1000; i++) {
 */  
                    assertEquals(9L, starTreeDocument.metrics[0]);  
        List<Long> metricsList = List.of(0L, 1L, 2L, 3L, 4L, 5L, 6L);  
        List<Integer> docsWithField = List.of(0, 1, 2, 3, 4, 6);
        List<Long> metricsList = new ArrayList<>(100);  
        );
        writeState = getWriteState(6, writeState.segmentInfo.getId());  
            getLongFromDouble(20.0),
        SortedNumericDocValues metricsList1,  
         [3, 3] | [6]
            () -> new SortedNumericStarTreeValuesIterator(d4sndv)  
        }
                }
            assertEquals(starTreeDocument.dimensions[3] * 10.0, (Double) ((CompensatedSum) starTreeDocument.metrics[1]).value(), 0);  
        List<Integer> docsWithField2 = List.of(0, 1, 2, 3, 4, 6);  
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION  
         [2, 2] | [2]
                assertEquals(  
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
        List<Integer> docsWithField4 = new ArrayList<>(500);
        SortedNumericDocValues m2sndv = DocValues.emptySortedNumeric();
        List<Long> metricsList = List.of(0L, 1L, 2L, 3L, 4L, 5L, 6L);
        StarTreeValues starTreeValues = new StarTreeValues(
        Dimension d3 = new NumericDimension("field5");
                assertEquals(starTreeDocument.dimensions[1], starTreeDocument.metrics[0]);  
            () -> new SortedNumericStarTreeValuesIterator(d3sndv),  
         [3, 3, 3, 3] | [1700.0, 10]
        );  
         [2, 1, 11, 11] | [5700.0, 10]
        for (int i = 0; i < 500; i++) {  
        }
        docValuesConsumer.close();
        List<Long> metricsList21 = List.of(
                int docId = dimValueToDocIdEntry.getValue();
        map.put("field1", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
            false,
        List<Long> dimList1 = new ArrayList<>(500);  
         [1655287972000, 1655287972000, 1655287972000, 3] | [30.0, 3]  
            "4"  
            getLongFromDouble(50.0),
        int count = 0;  
    }
            docsWithField2.add(i);  
                        }
        List<Integer> docsWithField3 = List.of(0, 1, 2, 3, 4);
        Dimension d3 = new ReadDimension("field5", DocValuesType.SORTED_NUMERIC, DimensionDataType.UNSIGNED_LONG);
        List<Dimension> dims = List.of(d1, d2, d3, d4);
        // Validate the star tree structure
            }
        );
            () -> new SortedNumericStarTreeValuesIterator(f2d3sndv),
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,  
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,  
            dimList3,
            getSortedNumericMock(dimList3, docsWithField3),  
            null,
        dataOut.close();
                dimList4.add((long) i);
            getLongFromDouble(60.0)
        List<Dimension> dims = List.of(d1, d2, d3, d4);  
            "sf_field2_sum_metric",  
            metricsList,
            dimList1,
                long dimValue = dimValueToDocIdEntry.getKey();  
            starTreeMetadata,
import java.util.HashSet;
            1000,
            }  
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.mergeStarTrees(List.of(starTreeValues, starTreeValues2));  
        StarTreeValues starTreeValues2 = getStarTreeValues(
         [3, 3] | [3]
                            assertEquals(100L, starTreeDocument.metrics[1]);
        List<Integer> metricsWithField1 = List.of(0, 1, 2, 3, 4, 5, 6);
        Settings settings = Settings.builder().put(settings(org.opensearch.Version.CURRENT).build()).build();
            builder.getStarTreeDocuments()  
        docValuesConsumer.close();
import org.opensearch.index.compositeindex.datacube.startree.fileformats.meta.StarTreeMetadata;  
        );
            dimList2.add((long) (i % 2 == 0 ? i : -i));  
        for (int i = 0; i < 100; i++) {  
         * Asserting following dim / metrics [ dim1, dim2 / Count [ metric] ]
        );
    public void testMergeFlowWithMissingDocsWithZeroComplexCase() throws IOException {
        compositeField = getStarTreeFieldWithDocCount(1, true);
        assertEquals(expectedDimensionValues, actualDimensionValues);
        );  
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
        SortedNumericDocValues dimList,
        List<Integer> docsWithField7 = List.of(0, 1, 2, 3, 4, 6);  
        validateStarTreeFileFormats(  
            "field2",  
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
            if (Objects.equals(starTreeDocument.dimensions[0], 5L)) {  
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
            metricsWithField.add(i);  
        validateStarTreeFileFormats(
                } else {
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
            builder.getRootNode(),
            starTreeMetadata,
         [null, null, null, 99] | [49700.0, 10]
        StarTreeMetadata starTreeMetadata = getStarTreeMetadata(
        dataOut.close();  
        );  
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
                docsWithField4.add(i * 5 + j);
        StarTreeMetadata starTreeMetadata = getStarTreeMetadata(  
         [null, null, null, 5] | [50.0, 5]
        builder.appendDocumentsToStarTree(starTreeDocumentIterator);
            dimList4.add((long) 1);
         [0, 0] | [0]
        List<Integer> docsWithField3 = new ArrayList<>(500);
        List<Long> dimList4 = List.of(5L, 6L, 7L, 8L, -1L);
        List<Integer> docsWithField2 = List.of(0, 1, 2, 6);
            () -> new SortedNumericStarTreeValuesIterator(f2m1sndv),
            compositeField
        /**  
        builder.build(starTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
        StarTreeMetadata starTreeMetadata = getStarTreeMetadata(map, 7, 1000, 231);  
            getSortedNumericMock(dimList4, docsWithField4),
            getSortedNumericMock(dimList3, docsWithField3),  
        List<Integer> metricsWithField = List.of(0, 1, 2, 3, 4, 5, 6);
        SortedNumericDocValues d1sndv = getSortedNumericMock(dimList1, docsWithField1);
            compositeField,
            getLongFromDouble(60.0)  
            true  
            if (count <= 10) {
            "field1",  
         * Asserting following dim / metrics [ dim1, dim2 / Count [ metric] ]  
        metaOut.close();
        );
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,  
            sf,
        StarTreeValues starTreeValues = getStarTreeValues(  
                    assertEquals(10L, starTreeDocument.metrics[1]);  
        );  
        for (int i = 0; i < 1000; i++) {
        map.put("field1", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));  
        }  
            getSortedNumericMock(dimList2, docsWithField2),
        SortedNumericDocValues d4sndv = getSortedNumericMock(dimList4, docsWithField4);
            writeState,
        StarTreeMetadata starTreeMetadata = getStarTreeMetadata(map, 6, 1000, 264);
    ) {
        List<Long> dimList3 = List.of(5L, 6L, 8L, -1L);  
        List<Long> docCountMetricsList = new ArrayList<>(100);
                assertEquals(starTreeDocument.dimensions[0] * 20.0, ((CompensatedSum) starTreeDocument.metrics[1]).value(), 0);
            metricsList.add(getLongFromDouble(i * 10.0));  
        );
            dimList4,
            builder.getRootNode(),
            getSortedNumericMock(dimList3, docsWithField3),
            writeState,  
        builder = getStarTreeBuilder(metaOut, dataOut, sf, getWriteState(4, writeState.segmentInfo.getId()), mapperService);  
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);  
        }
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(  
         [0, 0] | [0]
        compositeField = getStarTreeField(MetricStat.VALUE_COUNT);  
        );  
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
        validateStarTreeFileFormats(  
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
            compositeField,
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
        }
            fullyQualifiedFieldNameForStarTreeMetricsDocValues(
        validateStarTreeFileFormats(
            // metric = no of docs * 10.0
            compositeField,
        map.put("field3", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));  
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
         [4, 4] | [4]
            "sf_field2_value_count_metric",
                            assertEquals(10L, starTreeDocument.metrics[1]);
        );  
            metricsWithFieldValueCount.add(i);
        // builder.getRootNode(),
import org.opensearch.index.compositeindex.datacube.Metric;
            count++;
        List<Integer> metricsWithField = List.of(0, 1, 2, 3, 4, 5, 6);
    }
        /**  
         [2, 0, 8, 8] | [4200.0, 10]
         [1, 0, 4, 4] | [2200.0, 10]  
        validateStarTree(builder.getRootNode(), 4, compositeField.getStarTreeConfig().maxLeafDocs(), builder.getStarTreeDocuments());  
        );
         [8, 8] | [8]
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
        List<Integer> docsWithField3 = List.of(0, 1, 2, 3, 4);
         [null, null] | [19]
            metricsWithField1,  
            null,
         */
        StarTreeValues starTreeValues = getStarTreeValuesWithKeywords(
            docCountMetricsWithField,
            StarTreeDocument starTreeDocument = starTreeDocumentIterator.next();
            builder.getStarTreeDocuments().size(),  
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,  
        builder.appendDocumentsToStarTree(starTreeDocumentIterator);  
            starTreeMetadata,  
            dimList2,  
                        && starTreeDocument.dimensions[3] != null) {
         [2, 0, 9, 9] | [4700.0, 10]
        assertEquals(401, starTreeDocuments.size());
        }  
        assertEquals(6, builder.getStarTreeDocuments().size());
            getLongFromDouble(50.0),  
        docValuesConsumer.close();  
        );
            builder.getStarTreeDocuments().size(),  
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
        );
            "sf_field2_sum_metric",
         * [null, 2] | [40.0]
            getLongFromDouble(50.0),
            if (count <= 10) {
                } else {  
            docsWithField2,
        for (int i = 0; i < 500; i++) {
            () -> new SortedNumericStarTreeValuesIterator(d2sndv)
                "field2",
            getSortedNumericMock(dimList2, docsWithField2),
        SortedNumericDocValues m1sndv = getSortedNumericMock(metricsList, metricsWithField);
            if (count < 1000) {
            "field5",  
            docCountMetricsWithField,  
            for (int j = 0; j < 20; j++) {
        );
        builder.appendDocumentsToStarTree(starTreeDocumentIterator);
        List<Integer> docsWithField = List.of(0, 1, 2, 3, 4, 5, 6);
                "field2",  
        List<Long> dimList = List.of(0L, 1L, 2L, 3L, 4L, 5L, -1L);
                assertEquals(starTreeDocument.dimensions[0] * 2, (long) starTreeDocument.metrics[0], 0);
        List<Long> metricsList = List.of(0L, 1L, 2L, 3L, 4L, 5L, 6L);
        int count = 0;  
            f2metricDocIdSetIterators,
            "field8",  
                    } else if (starTreeDocument.dimensions[0] != null
            metricsWithField,
        List<Integer> docsWithField2 = new ArrayList<>(500);
        builder.build(builder.mergeStarTrees(List.of(starTreeValues, starTreeValues2)), new AtomicInteger(), docValuesConsumer);  
            () -> new SortedNumericStarTreeValuesIterator(m2sndv)
            compositeField,
        List<Long> metricsList2 = List.of(0L, 1L, 2L, 3L, 4L);
                dimList1.add((long) i);
        List<Integer> metricsWithField2 = List.of(0, 1, 2, 3, 4);  
        map.put("field3", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
        List<Integer> docsWithField = List.of(0, 1, 3, 4, 5, 6);
        ).build(new Mapper.BuilderContext(settings, new ContentPath()));
            getLongFromDouble(0.0),
                        && starTreeDocument.dimensions[1] != null  
        String number
            getAttributes(1000),  
        List<Integer> docCountMetricsWithField = new ArrayList<>(100);
        List<Long> metricsList2 = List.of(5L, 6L, 7L, 8L, 9L);
        for (int i = 0; i < 100; i++) {
            count++;
        );
        validateStarTreeFileFormats(
        SortedNumericDocValues valucountsndv = getSortedNumericMock(metricsListValueCount, metricsWithFieldValueCount);  
            randomFrom(NumberFieldMapper.NumberType.values()),
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.mergeStarTrees(List.of(starTreeValues, starTreeValues2));  
import org.opensearch.index.compositeindex.datacube.Dimension;
            compositeField,
        List<Integer> docsWithField3 = List.of(0, 1, 3, 4);
            getLongFromDouble(20.0),
        Map<String, Supplier<StarTreeValuesIterator>> dimDocIdSetIterators = Map.of(
            getSortedNumericMock(dimList7, docsWithField7),
            false,
            starTreeMetadata,
            }  
        }
        List<Long> metricsList = List.of(0L, 1L, 2L, 3L, 4L, 5L, 6L);
        );
            docsWithField3,
            builder.getStarTreeDocuments().size(),
        List<Integer> metricsWithField = new ArrayList<>(100);
        metricDocIdSetIterators.put(
        SortedNumericDocValues metricsList,
                sf.getName(),
            }
        );
import java.util.Objects;  
            dimList2,
        List<Integer> metricsWithField = List.of(0, 1, 2, 3, 4, 5, 6);  
        List<Metric> metrics = List.of(m1, m2);
            for (int j = 0; j < 20; j++) {  
        List<Long> dimList7 = List.of(1655288152000L, 1655288092000L, 1655288032000L, 1655287972000L, 1655288092000L, 1655288092000L, -1L);
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(  
            DocValues.emptySortedNumeric(),
            () -> new SortedNumericStarTreeValuesIterator(d4sndv)
            getStarTreeDimensionNames(compositeField.getDimensionsOrder()),
        SortedNumericDocValues m1sndv = getSortedNumericMock(metricsList, metricsWithField);
        NumberFieldMapper numberFieldMapper1 = new NumberFieldMapper.Builder(
 * SPDX-License-Identifier: Apache-2.0
            getLongFromDouble(40.0),
        SortedNumericDocValues d2sndv = dimList2;
        StarTreeValues starTreeValues2 = new StarTreeValues(
        StarTreeValues starTreeValues2 = getStarTreeValues(
            }
        List<Integer> docsWithField4 = new ArrayList<>(500);
         [0, null] | [8]
            true  
        builder.appendDocumentsToStarTree(starTreeDocumentIterator);  
                    assertEquals(starTreeDocument.dimensions[0], starTreeDocument.metrics[0]);
                } else if (starTreeDocument.dimensions[0] == null) {  
            "field8",
        List<Integer> docsWithField2 = new ArrayList<>(1000);
        }  
            writeState,  
         */
        for (StarTreeDocument starTreeDocument : builder.getStarTreeDocuments()) {
            Map.of(CompositeIndexConstants.SEGMENT_DOCS_COUNT, number),
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.mergeStarTrees(List.of(starTreeValues, starTreeValues2));
         */
         * [1, 1] | [20.0]  
            docCountMetricsWithField,  
         635 docs get generated
        for (int i = 0; i < 1000; i++) {
            docsWithField4,
                    assertEquals(12L, (long) starTreeDocument.metrics[0]);
            "sf__doc_count_doc_count_metric",
        }
        docValuesConsumer.close();
        dataOut.close();  
import static org.opensearch.index.compositeindex.datacube.startree.builder.BuilderTestsUtils.getSortedNumericMock;  
        SortedNumericDocValues f2d4sndv = getSortedNumericMock(dimList4, docsWithField4);
        validateStarTree(builder.getRootNode(), 2, 1000, builder.getStarTreeDocuments());  
        List<Long> dimList = List.of(0L, 1L, 2L, 3L, 4L);
                docsWithField1.add(i * 5 + j);  
        map.put("field1", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
            }
        List<Long> metricsListValueCount = new ArrayList<>(1000);
            docsWithField1,  
                dimList1.add((long) i);
                assertEquals(starTreeDocument.dimensions[1], starTreeDocument.metrics[0]);  
            consumerWriteState,
    }
        for (int i = 0; i < 100; i++) {  
                sf.getName(),
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.mergeStarTrees(List.of(starTreeValues, starTreeValues2));
        );  
        for (int i = 0; i < 500; i++) {  
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION  
        when(mapperService.documentMapper()).thenReturn(documentMapper);  
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,  
import org.opensearch.index.compositeindex.CompositeIndexConstants;
            compositeField
            getSortedNumericMock(dimList, docsWithField),  
        SortedNumericDocValues dimList3,
            builder.getRootNode(),
         [2, 2, 2, 2] | [40.0, 2]
        }
        dataOut.close();
        List<Long> dimList4 = List.of(5L, 6L, 7L, 8L, -1L);  
            fullyQualifiedFieldNameForStarTreeMetricsDocValues(
            builder.getStarTreeDocuments()
            getSortedNumericMock(metricsList, metricsWithField),  
        }
        dimValueMap.put(Long.MAX_VALUE, 5000.0);
        metricDocIdSetIterators.put(  
         * Asserting following dim / metrics [ dim1, dim2 / Count [ metric] ]
        List<Long> dimList4 = new ArrayList<>(numDocs);
        SortedNumericDocValues f2d2sndv = getSortedNumericMock(dimList2, docsWithField2);
            "field1",  
        /**  
        List<Long> dimList3 = new ArrayList<>(500);  
         [1, 0, 6, 6] | [3200.0, 10]
        for (int i = 0; i < 1000; i++) {  
         [8, 8] | [8]  
         [0, 0] | [0]  
                && starTreeDocument.dimensions[2] != null
                    assertTrue(List.of(5L, 7L).contains(starTreeDocument.dimensions[1]));
            13365
            metricDocIdSetIterators,
        docValuesConsumer.close();
        StarTreeValues starTreeValues2 = getStarTreeValues(
        for (int i = 80; i < 100; i++) {  
            }  
         [5, 5] | [10]
        validateStarTree(builder.getRootNode(), 2, 1000, builder.getStarTreeDocuments());  
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
            builder.getStarTreeDocuments()  
            int dimId = entry.getKey();
            docCountMetricsList,  
            getLongFromDouble(80.0),  
            getSortedNumericMock(metricsList, metricsWithField),
            metricsWithField.add(i);
        compositeField = getStarTreeFieldForUnsignedLong(MetricStat.SUM);
    public void testMergeFlow() throws IOException {
         */
        assertEquals(635, starTreeDocuments.size());
            if (starTreeDocument.dimensions[3] == null) {
         * [3, 3] | [60.0]
        SortedNumericDocValues dimList4,  
            }
        assertEquals(10, count);  
        StarTreeValues starTreeValues2 = getStarTreeValues(
        metaOut.close();
        int count = 0;  
        docValuesConsumer.close();  
            ),  
        List<Long> actualDimensionValues = new ArrayList<>(numDocs);
    }
        List<Long> metricsList1 = new ArrayList<>(100);
        List<Long> metricsList2 = List.of(5L, 6L, 7L, 8L, 9L);
        );  
            docsWithField4,
        String number
            f2dimDocIdSetIterators,
                    sf.getName(),
        List<Integer> metricsWithField = List.of(0, 1, 2, 3, 4, 5, 6);  
            builder.getStarTreeDocuments().size(),
        metaOut.close();
                dimList2.add((long) i);
            dimList1,
            starTreeMetadata,  
            docsWithField3,
            getAttributes(1000),
        StarTreeValues starTreeValues2 = getStarTreeValuesWithKeywords(
        List<Long> dimList2 = List.of(0L, 1L, 2L, 3L, 4L, 5L, -1L);
        List<Long> dimList2 = List.of(1655288152000L, 1655288092000L, 1655288032000L, 1655287972000L, 1655288092000L, 1655288092000L, -1L);  
                    0  
            metricsList,  
        List<Long> dimList = List.of(0L, 1L, 3L, 4L, 5L, 6L);  
        builder.build(starTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
import java.util.concurrent.atomic.AtomicInteger;
         [6, 6] | [6]
         [1, 1] | [1]
            () -> new SortedNumericStarTreeValuesIterator(f2m2sndv)
    public void testMergeFlowWithMissingDocsWithZero() throws IOException {
        List<Long> dimList1 = new ArrayList<>(500);
        writeState = getWriteState(6, writeState.segmentInfo.getId());
                docsWithField2.add(i * 50 + j);
import org.apache.lucene.index.SegmentWriteState;  
         * Asserting following dim / metrics [ dim1, dim2 / Count [ metric] ]
        validateStarTreeFileFormats(
        List<Integer> docCountMetricsWithField = new ArrayList<>(100);
            count++;  
        Map<String, Supplier<StarTreeValuesIterator>> dimDocIdSetIterators = Map.of(  
            getLongFromDouble(60.0)
import static org.opensearch.index.compositeindex.datacube.startree.builder.BuilderTestsUtils.getSortedSetMock;
        List<Integer> metricsWithField21 = List.of(0, 1, 2, 3, 4);  
            starTreeMetadata,
        StarTreeValues starTreeValues = getStarTreeValues(  
        List<Long> dimList3 = new ArrayList<>(1000);
            docsWithField4,  
        List<Integer> docsWithField3 = new ArrayList<>(500);
            () -> new SortedNumericStarTreeValuesIterator(m1sndv)
            }  
            getSortedNumericMock(metricsList, metricsWithField),  
            "sf__doc_count_doc_count_metric",
         [null, null, null, 99] | [49700.0, 10]
            }
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
         */  
            getLongFromDouble(40.0)
        /**  
        SortedSetDocValues d1sndv = dimList;
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
        StarTreeValues starTreeValues = new StarTreeValues(
        List<Integer> docsWithField2 = List.of(0, 1, 2, 3, 4, 5, 6);  
        );  
            getSortedNumericMock(metricsList21, metricsWithField21),
        int count = 0;  
        builder.build(starTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);  
            dimList3.add((long) (i % 2 == 0 ? i : -i));
        List<Long> dimList3 = new ArrayList<>(500);
        for (StarTreeDocument starTreeDocument : builder.getStarTreeDocuments()) {
            "0"
        assertEquals(6, builder.getStarTreeDocuments().size());
        SortedNumericDocValues d4sndv = getSortedNumericMock(dimList4, docsWithField4);
    public void testMergeFlowWithSum() throws IOException {
            }  
                dimList1.add((long) i);  
            metricsWithField1,
            () -> new SortedNumericStarTreeValuesIterator(d2sndv),
            getSortedSetMock(dimList2, docsWithField2),
            "field3",
        LinkedHashMap<String, DimensionConfig> map = new LinkedHashMap<>();
        List<Integer> metricsWithField1,
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
                dimList3.add((long) i);
import static org.mockito.Mockito.mock;
        validateStarTreeFileFormats(
            compositeField
        metaOut.close();
import java.util.Collections;
        Metric m1 = new Metric("field2", List.of(MetricStat.SUM, MetricStat.AVG, MetricStat.VALUE_COUNT));
            getStarTreeDimensionNames(compositeField.getDimensionsOrder()),
        for (int i = 0; i < 500; i++) {
            getSortedNumericMock(dimList2, docsWithField2),  
            if (count <= 7) {  
        StarTreeValues starTreeValues2 = getStarTreeValues(
        assertEquals(401, starTreeDocuments.size());
        StarTreeValues starTreeValues = getStarTreeValues(
        }
        SortedNumericDocValues metricsList1,
        StarTreeValues starTreeValues2 = getStarTreeValues(
                            assertTrue((long) starTreeDocument.metrics[1] == 20L || (long) starTreeDocument.metrics[1] == 40L);  
            getSortedNumericMock(dimList, docsWithField),  
        }
        List<Integer> docsWithField4,  
            "6"
        List<Long> dimList3,  
        );  
         */
            count++;
        StarTreeValues starTreeValues = getStarTreeValues(  
            null,
        /**
        for (int i = 0; i < numDocs; i++) {
        );
            "4"
            docsWithField3,
        List<Integer> metricsWithField2 = List.of(0, 1, 2, 3, 4);
        SortedNumericDocValues d2sndv = getSortedNumericMock(dimList2, docsWithField2);
    public void testMergeFlowForUnsignedLongWithSum() throws IOException {
        List<Long> metricsList = new ArrayList<>(1000);
         [5, 5] | [5]  
        validateStarTreeFileFormats(
        validateStarTreeFileFormats(  
    public StarTreeBuilderMergeFlowTests(StarTreeFieldConfiguration.StarTreeBuildMode buildMode) {
        );
                expectedDimensionValues.add((long) i * 2); // Positive even numbers  
                assertEquals(starTreeDocument.dimensions[3] * 500 + 200L, (long) starTreeDocument.metrics[1]);
        List<Long> dimList1,
        List<Integer> docsWithField2 = new ArrayList<>(500);
        );
         */  
            for (int j = 0; j < 5; j++) {
        StarTreeMetadata starTreeMetadata = getStarTreeMetadata(map, 9, 1000, 330);
        assertEquals(10, builder.getStarTreeDocuments().size());  
        List<Integer> metricsWithField1 = List.of(0, 1, 2, 3, 4, 5, 6);  
            metricsList.add(1L);
        );  
        Map<Integer, Map<Long, Integer>> dimValueToDocIdMap = new HashMap<>();
         .....
            getLongFromDouble(20.0),  
        for (int i = 0; i < 500; i++) {
                );
        for (int i = 0; i < 500; i++) {  
            getLongFromDouble(30.0),
         [0, 0] | [0]
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
        List<StarTreeDocument> starTreeDocuments = builder.getStarTreeDocuments();
        docValuesConsumer.close();
        SortedNumericDocValues f2m1sndv = getSortedNumericMock(metricsList, metricsWithField);
            docsWithField1,  
                        } else if (starTreeDocument.dimensions[0] != null) {
            dimList4,
            metricsList,  
        writeState = getWriteState(4, writeState.segmentInfo.getId());  
            getLongFromDouble(40.0),  
            () -> new SortedNumericStarTreeValuesIterator(metricsList1)  
            compositeField,
        List<Long> dimList3 = List.of(1655288152000L, 1655288092000L, 1655288032000L, -1L);
        List<Integer> docsWithField2 = List.of(0, 1, 2, 3, 4, 5, 6);
import org.opensearch.index.compositeindex.datacube.startree.StarTreeFieldConfiguration;
        return new StarTreeValues(sf, null, dimDocIdSetIterators, metricDocIdSetIterators, Map.of(SEGMENT_DOCS_COUNT, number), null);
    public void testMergeFlowForUnsignedLong() throws IOException {  
                    assertEquals(starTreeDocument.dimensions[1], starTreeDocument.metrics[0]);
        );  
            builder.getStarTreeDocuments().size(),
                sf.getName(),  
        validateStarTree(builder.getRootNode(), 4, 1, builder.getStarTreeDocuments());
import org.opensearch.index.compositeindex.datacube.startree.fileformats.meta.DimensionConfig;
            dimValueMap.put((long) i, 200.0);
        }
            "field5",
            compositeField,
        List<Metric> metrics = List.of(m1, m2);
         [5, 5] | [5]
        List<Long> metricsList = new ArrayList<>(100);
        }
            "4"
        List<Integer> metricsWithField2 = List.of(0, 1, 2, 3, 4);
            () -> new SortedNumericStarTreeValuesIterator(f2d1sndv),
            compositeField,  
        );
        List<Integer> docsWithField2 = List.of(0, 1, 2, 3, 4, 5, 6);
        LinkedHashMap<String, DimensionConfig> map = new LinkedHashMap<>();  
         [null, 7] | [7]  
            builder.getRootNode(),
                docsWithField3.add(i * 5 + j);
                "field2",  
                        } else if (starTreeDocument.dimensions[1] != null) {  
            metricDocIdSetIterators,  
        builder.build(builder.mergeStarTrees(List.of(starTreeValues, starTreeValues2)), new AtomicInteger(), docValuesConsumer);  
            ),  
            () -> new SortedNumericStarTreeValuesIterator(d4sndv)
        List<Integer> docsWithField2 = List.of(0, 1, 2, 6);
        map.put("field1", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
            metricsWithField.add(i);
            getLongFromDouble(20.0),
                if (starTreeDocument.dimensions[0] == null && starTreeDocument.dimensions[1] == null) {
            docsWithField1,  
        StarTreeFieldConfiguration c = new StarTreeFieldConfiguration(1, new HashSet<>(), getBuildMode());
                dimList3.add((long) i);
            getAttributes(1000),  
        SortedNumericDocValues dimList,  
        List<Integer> docsWithField = List.of(0, 1, 3, 4, 5, 6);
            "field3",
            starTreeMetadata,
        builder.appendDocumentsToStarTree(starTreeDocumentIterator);  
        List<Integer> metricsWithField1 = new ArrayList<>(100);  
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
            null,  
         * ------------------ We only take non-star docs
            dimList2,  
            () -> new SortedNumericStarTreeValuesIterator(metricsList1)  
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
        );
        builder.build(starTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
        when(documentMapper.mappers()).thenReturn(fieldMappers);  
            getSortedNumericMock(dimList3, docsWithField3),
        int count = 0;
            getLongFromDouble(40.0),
        );  
            compositeField,
        SortedNumericDocValues d1sndv = dimList;  
        int count = 0;
                            assertEquals(40L, starTreeDocument.metrics[1]);  
         */
            }  
        List<Integer> docsWithField2 = new ArrayList<>(500);
        /**  
                dimList1.add((long) i);
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
    }  
                docsWithField4.add(i * 5 + j);
            starTreeMetadata,  
            () -> new SortedNumericStarTreeValuesIterator(metricsList)
            fullyQualifiedFieldNameForStarTreeMetricsDocValues(
        Map<String, Supplier<StarTreeValuesIterator>> metricDocIdSetIterators = new LinkedHashMap<>();  
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
            }
            compositeField,
            null
            "6"  
        List<Long> metricsList2 = List.of(5L, 6L, 7L, 8L, 9L);
                docsWithField1.add(i * 5 + j);  
        List<Long> metricsList = new ArrayList<>(100);
        assertEquals(6, builder.getStarTreeDocuments().size());  
            sf,  
        );  
        Map<String, Supplier<StarTreeValuesIterator>> dimDocIdSetIterators = Map.of(
         [null, 7] | [7]  
            for (int j = 0; j < 5; j++) {
            dimList2.add((long) 1);
            getSortedNumericMock(metricsList1, metricsWithField1),  
        SortedNumericDocValues d1sndv = getSortedNumericMock(dimList1, docsWithField1);
        );  
            dimList3,
        );
        List<Long> dimList4 = new ArrayList<>(500);
            dimList4,
         [0, 0] | [0]
            builder.getStarTreeDocuments()
        List<Integer> metricsWithFieldValueCount = new ArrayList<>(1000);
         [1655288032000, 1655288032000, 1655288032000, 2] | [20.0, 2]
        for (int i = 0; i < 100; i++) {
            randomFrom(NumberFieldMapper.NumberType.values()),
            for (int j = 0; j < 5; j++) {
        }
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.mergeStarTrees(List.of(starTreeValues, starTreeValues2));
 *
        int count = 0;
        StarTreeValues starTreeValues2 = getStarTreeValues(  
            "field1",  
            dimValueMap.put((long) i, 10.0);
        List<Long> dimList4,
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
        List<Long> dimList4 = List.of(5L, 6L, 7L, 8L, -1L);
            compositeField,  
        List<Integer> docsWithField2 = List.of(0, 1, 2, 3, 4, 5, 6);
            getLongFromDouble(10.0),
            getStarTreeDimensionNames(compositeField.getDimensionsOrder()),
            dimList2.add((long) i);
}  
            ),
            builder.getStarTreeDocuments()
            6,
            docsWithField1,
            metricDocIdSetIterators,  
         [1, 1] | [2]
    public void testMergeFlowWithDuplicateDimensionValues() throws IOException {  
    }
        List<Long> dimList2 = new ArrayList<>(1000);
        StarTreeMetadata starTreeMetadata = getStarTreeMetadata(  
            fullyQualifiedFieldNameForStarTreeMetricsDocValues(
                if (starTreeDocument.dimensions[0] != null) {  
            count++;  
        List<Long> dimList3 = List.of(5L, 6L, 8L, -1L);  
        builder.appendDocumentsToStarTree(starTreeDocumentIterator);  
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
        super(buildMode);
            docsWithField4,  
        SortedNumericDocValues valucountsndv = getSortedNumericMock(metricsListValueCount, metricsWithFieldValueCount);
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
        dataOut.close();
            getLongFromDouble(90.0)
                    0  
        metaOut.close();
        compositeField = getStarTreeFieldWithKeywords(random().nextBoolean());
            if (count <= 6) {
            docsWithField2.add(i);
        builder.appendDocumentsToStarTree(starTreeDocumentIterator);
            compositeField,
    }
import org.opensearch.index.codec.composite.LuceneDocValuesConsumerFactory;
        dataOut.close();  
            "sf__doc_count_doc_count_metric",  
            getSortedNumericMock(metricsList2, metricsWithField2),
        }  
            () -> new SortedNumericStarTreeValuesIterator(f2m1sndv),  
            compositeField.getStarTreeConfig().maxLeafDocs(),  
    }
            dimDocIdSetIterators,
        metaOut.close();  
        // validateStarTreeFileFormats(  
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION  
            getLongFromDouble(20.0),
                    assertEquals(7L, starTreeDocument.metrics[0]);
                if (starTreeDocument.dimensions[0] == null) {
        List<Long> dimList2,
 * compatible open source license.
import java.io.IOException;  
        }
            "sf_field2_value_count_metric",
        );
        int count = 0;  
        return starTreeValues;
         [1, 1] | [1]  
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
            getSortedNumericMock(dimList, docsWithField),
        for (Metric metric : sf.getMetrics()) {
        LinkedHashMap<String, DimensionConfig> map = new LinkedHashMap<>();
            builder.getStarTreeDocuments()
        writeState = getWriteState(6, writeState.segmentInfo.getId());
        );  
         [3, 3, 3, 3] | [60.0, 2]
        for (int i = 0; i < 1000; i++) {
                dimList1.add((long) i);  
        map.put("field1", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
            writeState,  
            docsWithField3.add(i);
        docValuesConsumer.close();
        );  
            writeState,
            compositeField,  
        LinkedHashMap<String, DimensionConfig> map = new LinkedHashMap<>();
            starTreeMetadata,
         [null, 5] | [5]  
            getSortedNumericMock(metricsList2, metricsWithField2),  
                    assertEquals(5L, (long) starTreeDocument.dimensions[1]);
            metricsWithField,
                if (starTreeDocument.dimensions[0] != null && starTreeDocument.dimensions[0] == 5) {
         [7, 2, null, null] | [28900.0, 20]
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,  
        );
        List<Integer> docsWithField3 = List.of(0, 1, 3, 4);
        );
            dimList2,
        List<Long> dimList4 = new ArrayList<>(1000);  
            builder.getStarTreeDocuments()
            getSortedNumericMock(metricsList, metricsWithField),
            "4"
         */
        );
        StarTreeValues starTreeValues = getStarTreeValues(
    public void testMergeFlowWithMaxLeafDocsAndStarTreeNodesAssertion() throws IOException {  
         [2, 2] | [2]
        dimValueMap = new HashMap<>();
            builder.getRootNode(),
            compositeField,
        for (int i = 0; i < 20; i++) {
            getSortedNumericMock(dimList, docsWithField),
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
         [4, 4] | [4]
        int count = 0;  
            writeState,  
        StarTreeValues starTreeValues2 = getStarTreeValuesWithDates(
         [5, 5] | [10]  
            () -> new SortedNumericStarTreeValuesIterator(d3sndv),
        metaOut.close();
    public void testMergeFlowWithDifferentDocsFromSegments() throws IOException {
            getSortedNumericMock(dimList6, docsWithField6),
        List<Integer> docsWithField4 = List.of(0, 1, 2, 3, 4);
            compositeField.getStarTreeConfig().maxLeafDocs(),  
            "field8",
            null
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION  
    }  
        assertEquals(6, count);
        List<Integer> metricsWithField = new ArrayList<>(100);  
        );
         [-5, -5, -5, -5] | [100.0, 2]
                        assertEquals(10L, starTreeDocument.metrics[1]);
        int count = 0;
        );  
            () -> new SortedSetStarTreeValuesIterator(d1sndv),
         [4, 4] | [4]  
        Dimension d4 = new NumericDimension("field8");  
        assertEquals(9, count);  
                } else if (starTreeDocument.dimensions[0] != null
        for (int i = 0; i < 100; i++) {  
         [0, 0, 0, 0] | [200.0, 10]
            for (int j = 0; j < 5; j++) {
        writeState = getWriteState(4, writeState.segmentInfo.getId());
        dimValueMap.put(Long.MAX_VALUE, 5000.0);  
        builder.build(starTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
         [6, 6] | [6]
                String metricFullName = fullyQualifiedFieldNameForStarTreeMetricsDocValues(
            "6"
        List<Integer> docsWithField6 = List.of(0, 1, 2, 3);
        );
        map.put("field3", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));  
        SortedNumericDocValues d2sndv = getSortedNumericMock(dimList2, docsWithField2);
            metricsListValueCount.add((long) i);
        for (int i = 0; i < 500; i++) {  
        validateStarTree(builder.getRootNode(), 2, 1000, builder.getStarTreeDocuments());
import static org.opensearch.index.compositeindex.CompositeIndexConstants.SEGMENT_DOCS_COUNT;
            getSortedNumericMock(dimList2, docsWithField2),  
                assertEquals(10L, starTreeDocument.metrics[1]);
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
                );
            dimList3,
            "sf_field2_sum_metric",
import static org.mockito.Mockito.when;  
                    metricStat.getTypeName()
        for (int i = 0; i < 500; i++) {  
        // Validate the star tree structure
                dimList4.add((long) i);
                }
         [1655288092000, 1655288092000, 1655288092000, 4] | [40.0, 4]
            null,
        /**
        List<Integer> metricsWithField = List.of(0, 1, 2, 3, 4, 5, 6);
        StarTreeValues starTreeValues2 = getStarTreeValues(
        List<Long> dimList = List.of(0L, 0L, 0L, 0L, 0L);
            getLongFromDouble(10.0),
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(  
public class StarTreeBuilderMergeFlowTests extends StarTreeBuilderTestCase {
        writeState = getWriteState(4, writeState.segmentInfo.getId());
        }
        Map<String, Supplier<StarTreeValuesIterator>> f2metricDocIdSetIterators = Map.of(
            }
            compositeField,
        for (int i = 0; i < 100; i++) {
            docsWithField4,
         [1, 1, 1, 1] | [20.0, 2]
            getSortedNumericMock(dimList, docsWithField),
        StarTreeMetadata starTreeMetadata = getStarTreeMetadata(map, 6, 1000, 264);
        }  
        map.put("field1", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));  
        builder.appendDocumentsToStarTree(starTreeDocumentIterator);
            metricsWithField,
            sf,  
            "field5",
        );  
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.mergeStarTrees(List.of(starTreeValues, starTreeValues2));
            docsWithField1,
        );  
            builder.getRootNode(),  
        for (int i = 0; i < 100; i++) {  
        List<Long> dimList4 = new ArrayList<>(500);
        }
        assertEquals(10, builder.getStarTreeDocuments().size());
        }
                } else {  
        validateStarTree(builder.getRootNode(), 4, 10, builder.getStarTreeDocuments());
        builder.appendDocumentsToStarTree(starTreeDocumentIterator);  
                    assertEquals(starTreeDocument.dimensions[1], starTreeDocument.metrics[0]);
            "field5",
        dimValueMap = new HashMap<>();
            compositeField,
            docsWithField3,
        validateStarTreeFileFormats(
         [3, 3] | [11, 110.0]
            getSortedNumericMock(metricsList2, metricsWithField2),
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
            dimList1,
            getLongFromDouble(40.0),  
import java.util.ArrayList;
        dataOut.close();  
            dimList3,  
        List<Integer> docsWithField = List.of(0, 1, 2, 3, 4);
import org.apache.lucene.search.DocIdSetIterator;  
        // );
            "4"
        Map<Long, Double> dimValueMap = new HashMap<>();
            docCountMetricsList.add(i * 10L);
         * [5, 5] | [100.0]  
        List<Long> dimList2 = List.of(0L, 0L, 0L, 0L);
            getSortedNumericMock(dimList, docsWithField),  
         [6, 6] | [6]
                assertEquals(starTreeDocument.dimensions[0], (long) starTreeDocument.metrics[0], 0);
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
        }
            metricDocIdSetIterators,
        docValuesConsumer.close();
    }
            writeState,
            dimList3.add((long) i);
            "sf__doc_count_doc_count_metric",  
                sf.getName(),
        LinkedHashMap<String, DimensionConfig> map = new LinkedHashMap<>();
        compositeField = new StarTreeField("sf", dims, metrics, c);
        for (StarTreeDocument starTreeDocument : builder.getStarTreeDocuments()) {  
    }
                "field2",
            getSortedNumericMock(metricsList, metricsWithField),
            () -> new SortedNumericStarTreeValuesIterator(d1sndv),
                "field2",
        int count = 0;
        List<Integer> metricsWithField = List.of(0, 1, 2, 3, 4, 5, 6);
         * [5, 5] | [100.0]  
         [8, 8] | [8]
        );  
            DocValues.emptySortedNumeric(),
        StarTreeValues starTreeValues = getStarTreeValues(
        }
            getLongFromDouble(0.0),
            }
            fullyQualifiedFieldNameForStarTreeMetricsDocValues(  
        List<Integer> docsWithField = List.of(0, 1, 2, 3, 4, 6);
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,  
            "6"  
    ) {  
/*  
        Iterator<StarTreeDocument> starTreeDocumentIterator = builder.mergeStarTrees(List.of(starTreeValues, starTreeValues2));
            count++;  
        StarTreeValues starTreeValues = getStarTreeValues(  
         [8, 8] | [8]
        );  
         .....  
        SortedNumericDocValues f2d1sndv = getSortedNumericMock(dimList1, docsWithField1);
        List<Long> dimList1 = new ArrayList<>(500);
        // builder.getStarTreeDocuments().size(),
        StarTreeValues starTreeValues2 = getStarTreeValues(  
        }
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
            metricsWithField,
            "6"
        docValuesConsumer.close();  
         * [4, 4] | [80.0]
            for (int j = 0; j < 5; j++) {
    }
         [1655288092000, 1655288092000, 1655288092000, 1] | [10.0, 1]  
                    assertEquals(8L, starTreeDocument.metrics[0]);
        validateStarTree(builder.getRootNode(), 4, 10, builder.getStarTreeDocuments());
            metricsList1,
        assertEquals(1041, starTreeDocuments.size());
         [8, 8] | [8]  
            }  
            compositeField.getStarTreeConfig().maxLeafDocs(),
            264
                if (starTreeDocument.dimensions[0] == null) {  
            getSortedNumericMock(dimList4, docsWithField4),  
            getSortedNumericMock(dimList, docsWithField),
            writeState,
import org.apache.lucene.index.SortedSetDocValues;
        SortedNumericDocValues f2d2sndv = getSortedNumericMock(dimList2, docsWithField2);  
import java.util.HashMap;  
        SortedNumericDocValues dimList2,
        assertEquals(6, builder.getStarTreeDocuments().size());  
            getSortedNumericMock(dimList2, docsWithField2),
            builder.getRootNode(),  
                } else if (starTreeDocument.dimensions[0] == 0) {
            metricsWithFieldValueCount.add(i);  
         [-3, -3, -3, -3] | [60.0, 2]
import java.util.Map;
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,  
            getSortedNumericMock(dimList, docsWithField),  
        }
        List<Long> dimList4 = List.of(5L, 6L, 7L, 8L, -1L);
         * ------------------ We only take non star docs
            getSortedNumericMock(dimList, docsWithField),
            "field1_half-hour",
         [2, 2, 2, 2] | [40.0, 2]  
        expectedDimToValueMap.put(1, dimValueMap);  
         [5, 5, 5, 5] | [100.0, 2]  
            metricsWithField.add(i);
            docsWithField2,
            dimDocIdSetIterators,
            docsWithField2,
         [4, 4] | [4]
         [0, 0] | [9]
         [4, 4] | [8]  
        List<Long> metricsList = List.of(0L, 1L, 2L, 3L, 4L, 5L, 6L);
        List<Integer> docsWithField3 = List.of(0, 1, 3, 4);
        }
        List<Long> dimList1 = new ArrayList<>(1000);  
            builder.getRootNode(),
            compositeField,
            builder.getStarTreeDocuments().size(),  
        for (int i = 80; i < 100; i++) {
        docValuesConsumer.close();
            3,
        Metric m2 = new Metric("_doc_count", List.of(MetricStat.DOC_COUNT));
            () -> new SortedNumericStarTreeValuesIterator(m1sndv),  
         [2, 2] | [2]  
            getSortedNumericMock(metricsList1, metricsWithField1),
import static org.opensearch.index.compositeindex.datacube.startree.builder.BuilderTestsUtils.traverseStarTree;
            "6"
                assertEquals(starTreeDocument.dimensions[0] * 10.0, ((CompensatedSum) starTreeDocument.metrics[1]).value(), 0);
        List<Integer> metricsWithFieldValueCount = new ArrayList<>(1000);  
            writeState,
        StarTreeValues starTreeValues = getStarTreeValues(  
            metricsList.add(getLongFromDouble(i * 10.0));  
        List<Integer> metricsWithField = List.of(0, 1, 2, 3, 4, 5, 6);
         * [null, 2] | [40.0]
            compositeField,  
         [8, 8] | [8]
            builder.getStarTreeDocuments()
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
    }
            15345
        StarTreeField sf,
        LinkedHashMap<String, DimensionConfig> map = new LinkedHashMap<>();  
            "field1",
        List<Long> metricsList = List.of(0L, 1L, 2L, 3L, 4L, 5L, 6L);
            getSortedSetMock(dimList, docsWithField),  
        List<Long> dimList4 = List.of(0L, 1L, 2L, 3L, -1L);  
        Map<String, Supplier<StarTreeValuesIterator>> metricDocIdSetIterators = new LinkedHashMap<>();
    public void testMergeFlowWithMissingDocsInSecondDim() throws IOException {
            metricsList1,
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
        );
        Map<String, Supplier<StarTreeValuesIterator>> dimDocIdSetIterators = Map.of(
