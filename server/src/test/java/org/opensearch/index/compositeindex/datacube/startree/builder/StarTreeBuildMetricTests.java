import org.apache.lucene.index.SegmentWriteState;
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
            false,
        MappingLookup fieldMappers = new MappingLookup(
        Iterator<StarTreeDocument> expectedStarTreeDocumentIterator = getExpectedStarTreeDocumentIterator().iterator();  
            fieldsInfo[i] = new FieldInfo(
        }
            getExpectedStarTreeDocumentIterator().size(),
        starTreeDocuments[4] = new StarTreeDocument(
        starTreeDocuments[4] = new StarTreeDocument(new Long[] { 3L, 4L, 2L, 1L }, new Long[] { 11L, 16L, randomLong(), 8L, 13L });
            VERSION_CURRENT,  
        expectedDimToValueMap.put(0, dimValueMap);
        assertStarTreeDocuments(resultStarTreeDocuments, expectedStarTreeDocumentIterator);
                0,
            long metric3 = (Long) starTreeDocuments[i].metrics[2];
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION  
        NumberFieldMapper numberFieldMapper5 = new NumberFieldMapper.Builder("field10", NumberFieldMapper.NumberType.LONG, false, true)
        NumberFieldMapper numberFieldMapper1 = new NumberFieldMapper.Builder("field2", NumberFieldMapper.NumberType.LONG, false, true)  
            Set.of("field8"),  
        writeState = new SegmentWriteState(InfoStream.getDefault(), segmentInfo.dir, segmentInfo, fieldInfos, null, newIOContext(random()));  
            getBuildMode(),
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
            writeState,  
        starTreeDocuments[0] = new StarTreeDocument(new Long[] { 2L, 4L, 3L, 4L }, new Long[] { 12L, 10L, randomLong(), 8L, 20L });
            new Long[] { 3L, 4L, 2L, 1L },
            long metric3 = HalfFloatPoint.halfFloatToSortableShort(  
            Set.of(),
            fieldProducerMap.put(fields.get(i), docValuesProducer);  
        validateStarTreeFileFormats(  
                DocValuesSkipIndexType.RANGE,
        Iterator<StarTreeDocument> segmentStarTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(  
            new StarTreeFieldConfiguration(1, Set.of(), getBuildMode())  
            .build(new Mapper.BuilderContext(settings, new ContentPath()));  
        List<SequentialDocValuesIterator> metricsIterators = getMetricIterators(segmentStarTreeDocuments);
import org.apache.lucene.util.Version;
            long metric1 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[0]);
        List<Dimension> dimensionsOrder2 = List.of(  
        // building another tree in the same file
            0,
            mock(IndexInput.class),
        Iterator<StarTreeDocument> expectedStarTreeDocumentIterator = getExpectedStarTreeDocumentIterator().iterator();
                0,  
        starTreeDocuments2[2] = new StarTreeDocument(new Long[] { 2L, 13L, 23L }, new Double[] { 300.0 });  
import org.opensearch.index.compositeindex.datacube.startree.fileformats.meta.StarTreeMetadata;
            metricsIterators  
            metrics,
        mapperService = mock(MapperService.class);
        builder.rootNode.setNodeType(StarTreeNodeType.STAR.getValue());
            7,  
            Collections.emptyList(),  
        );  
            false,
            "test",  
                new HalfFloatPoint("field6", 10),
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,  
                VectorSimilarityFunction.EUCLIDEAN,  
            new StarTreeDocument(new Long[] { 2L, 13L, 21L }, new Object[] { 100.0, 1L }),
            getBuildMode(),
            new HashMap<>(),
            new StarTreeDocument(new Long[] { null, 12L, 22L }, new Object[] { 200.0, 1L }),
            compositeField.getMetrics(),  
            mock(IndexInput.class),
        NumberFieldMapper numberFieldMapper5 = new NumberFieldMapper.Builder("field10", NumberFieldMapper.NumberType.FLOAT, false, true)
            );  
        );  
        StarTreeDocument[] starTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
 * compatible open source license.
        SegmentInfo segmentInfo = new SegmentInfo(
        StarTreeMetadata starTreeMetadata = new StarTreeMetadata(
            fieldsMap,
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
        assertEquals(7, resultStarTreeDocuments.size());
            long metric2 = HalfFloatPoint.halfFloatToSortableShort(  
            compositeField.getMetrics(),  
            Set.of(numberFieldMapper1, numberFieldMapper2, numberFieldMapper3, numberFieldMapper4, numberFieldMapper5),
            getExpectedStarTreeDocumentIterator().size(),  
        }
        fieldsMap1.put("fieldC", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
            dimsIterators,
        SegmentReadState readState = getReadState(3, totalDimensionFields, metrics);
        dataOut.close();
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
            );
            List.of(new Metric("fieldI", List.of(MetricStat.SUM))),  
        metrics.addAll(starTreeMetadata2.getMetrics());  
        Iterator<StarTreeDocument> expectedStarTreeDocumentIterator = expectedStarTreeDocuments().iterator();
        List<StarTreeDocument> resultStarTreeDocuments = builder.getStarTreeDocuments();
            builder.numStarTreeNodes,
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,  
            .build(new Mapper.BuilderContext(settings, new ContentPath()));
        starTreeDocuments[0] = new StarTreeDocument(  
        compositeField = new StarTreeField("test", dimensionsOrder, metrics, new StarTreeFieldConfiguration(1, Set.of(), getBuildMode()));  
            true  
    public void test_build_longMetrics() throws IOException {  
import org.opensearch.index.mapper.NumberFieldMapper;
        NumberFieldMapper numberFieldMapper3 = new NumberFieldMapper.Builder("field6", NumberFieldMapper.NumberType.HALF_FLOAT, false, true)
        fieldsMap.put("field1", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
            0,
            0,
                new HalfFloatPoint("field9", 8),  
            assertEquals(expectedStarTreeDocument.dimensions[2], resultStarTreeDocument.dimensions[2]);
            .build(new Mapper.BuilderContext(settings, new ContentPath()));  
        for (int i = 0; i < noOfStarTreeDocuments; i++) {
                ((HalfFloatPoint) starTreeDocuments[i].metrics[4]).numericValue().floatValue()
        dataOut.close();
        StarTreeDocument[] starTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
            new Long[] { 2L, 4L, 3L, 4L },
            long metric1 = NumericUtils.floatToSortableInt((Float) starTreeDocuments[i].metrics[0]);  
            7,  
            Collections.emptyList(),
            long metric2 = (Long) starTreeDocuments[i].metrics[1];
        LinkedHashMap<String, DimensionConfig> fieldsMap1 = new LinkedHashMap<>();  
            mock(IndexInput.class),
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;
            0,
        List<SequentialDocValuesIterator> metricsIterators = getMetricIterators(segmentStarTreeDocuments);
            );  
            new Long[] { 3L, 4L, 2L, 1L },
        traverseStarTree(builder.rootNode, dimValueToDocIdMap, true);
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
        assertEquals(7, resultStarTreeDocuments.size());
            new Long[] { 3L, 4L, 2L, 1L },
                new HalfFloatPoint("field6", 10),
import org.opensearch.index.compositeindex.datacube.startree.node.InMemoryTreeNode;  
import org.apache.lucene.index.DocValuesSkipIndexType;
                if (map.get(dimValue) != null) {  
        List<StarTreeDocument> resultStarTreeDocuments = builder.getStarTreeDocuments();  
            .build(new Mapper.BuilderContext(settings, new ContentPath()));
        docValuesConsumer.close();  
        Settings settings = Settings.builder().put(settings(org.opensearch.Version.CURRENT).build()).build();
import org.opensearch.index.mapper.Mapper;
}
        DocumentMapper documentMapper = mock(DocumentMapper.class);
import org.opensearch.index.compositeindex.datacube.DimensionDataType;  
            new Metric("field4", List.of(MetricStat.SUM)),
            0,
            long metric1 = (Long) starTreeDocuments[i].metrics[0];
        StarTreeDocument[] segmentStarTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
            long metric4 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[3]);  
        validateStarTreeFileFormats(
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION  
            NumberFieldMapper.NumberType.HALF_FLOAT,
import java.io.IOException;
            builder.numStarTreeNodes,
            fieldProducerMap.put(fields.get(i), docValuesProducer);
        StarTreeDocument[] starTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];  
            segmentStarTreeDocuments[i] = new StarTreeDocument(starTreeDocuments[i].dimensions, new Long[] { metric1, null });  
        int noOfStarTreeDocuments2 = 7;
        );
        StarTreeDocument[] starTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
            Long metric6 = (Long) starTreeDocuments[i].metrics[5];
            VERSION_CURRENT,
        LinkedHashMap<String, DimensionConfig> fieldsMap = new LinkedHashMap<>();
        return expectedDimToValueMap;  
            new NumericDimension("fieldB"),
            0,
            getExpectedStarTreeDocumentIterator().size(),
        dimValueMap = new HashMap<>();
            new StarTreeDocument(new Long[] { null, null, 22L }, new Object[] { 200.0, 1L }),
        totalDimensionFields.putAll(starTreeMetadata2.getDimensionFields());
            1,  
        StarTreeDocument[] segmentStarTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];  
            getExpectedStarTreeDocumentIterator().size(),
        when(documentMapper.mappers()).thenReturn(fieldMappers);
import org.apache.lucene.store.IOContext;  
        dimValueMap.put(13L, 400.0);
        validateFileFormats(dataIn, metaIn, rootNode1, starTreeMetadata, compositeField1);  
            long metric5 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[4]);
        NumberFieldMapper numberFieldMapper4 = new NumberFieldMapper.Builder("field9", NumberFieldMapper.NumberType.HALF_FLOAT, false, true)
            writeState,
        for (int i = 0; i < noOfStarTreeDocuments; i++) {
 * SPDX-License-Identifier: Apache-2.0
        starTreeDocuments[4] = new StarTreeDocument(
            Collections.emptyList(),
                new HalfFloatPoint("field6", 10),
        );
                }
package org.opensearch.index.compositeindex.datacube.startree.builder;
            STAR_TREE,
import org.opensearch.index.compositeindex.datacube.startree.StarTreeDocument;
    private List<StarTreeDocument> expectedStarTreeDocuments() {  
        MappingLookup fieldMappers = new MappingLookup(  
        );
            getExpectedStarTreeDocumentIterator()
        );
        metaOut.close();
        NumberFieldMapper numberFieldMapper1 = new NumberFieldMapper.Builder("fieldI", NumberFieldMapper.NumberType.DOUBLE, false, true)  
                0,
            new StarTreeDocument(new Long[] { 3L, 11L, 21L }, new Object[] { 600.0, 1L }),  
            long metric3 = NumericUtils.floatToSortableInt((Float) starTreeDocuments[i].metrics[2]);
import org.opensearch.index.compositeindex.datacube.startree.utils.SequentialDocValuesIterator;
            dimsIterators,  
            getBuildMode(),
            new Long[] { 2L, 4L, 3L, 4L },
        NumberFieldMapper numberFieldMapper5 = new NumberFieldMapper.Builder(  
        builder.build(segmentStarTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
        SequentialDocValuesIterator[] dimsIterators = getDimensionIterators(segmentStarTreeDocuments);
            new StarTreeDocument(new Long[] { 1L, null, null }, new Object[] { 600.0, 2L }),
        int noOfStarTreeDocuments = 5;
        Iterator<StarTreeDocument> segmentStarTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(
            getStarTreeDimensionNames(compositeField.getDimensionsOrder()),
            new StarTreeDocument(new Long[] { 1L, 12L, 22L }, new Object[] { 200.0, 1L }),  
        Iterator<StarTreeDocument> expectedStarTreeDocumentIterator = getExpectedStarTreeDocumentIteratorForUnsignedLong().iterator();
                new Metric("field4", List.of(MetricStat.SUM)),
        List<StarTreeDocument> resultStarTreeDocuments = builder.getStarTreeDocuments();
            new Metric("field2", List.of(MetricStat.SUM)),
        assertStarTreeDocuments(resultStarTreeDocuments, expectedStarTreeDocumentIterator);
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
            Set.of("field8"),
        compositeField = new StarTreeField(
            1,  
                new Metric("field10", List.of(MetricStat.MAX))
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
        StarTreeDocument[] starTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];  
            .build(new Mapper.BuilderContext(settings, new ContentPath()));  
                0,
        ).build(new Mapper.BuilderContext(settings, new ContentPath()));
        fieldsInfo = new FieldInfo[fields.size()];
        builder.build(segmentStarTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
                new HalfFloatPoint("field10", 10) }
        );
                starTreeDocuments[i].dimensions,
            builder.numStarTreeNodes,  
        DocumentMapper documentMapper = mock(DocumentMapper.class);  
        );  
        assertStarTreeDocuments(resultStarTreeDocuments, expectedStarTreeDocumentIterator);
            new NumericDimension("field5"),  
            long metric1 = (Long) starTreeDocuments[i].metrics[0];  
        for (int i = 0; i < noOfStarTreeDocuments; i++) {
        );  
        List<StarTreeDocument> resultStarTreeDocuments = builder.getStarTreeDocuments();
        super(buildMode);
        starTreeDocuments[1] = new StarTreeDocument(  
import org.apache.lucene.index.IndexOptions;
            new NumericDimension("fieldC"),
        docValuesConsumer.close();  
                ((HalfFloatPoint) starTreeDocuments[i].metrics[0]).numericValue().floatValue()
            .build(new Mapper.BuilderContext(settings, new ContentPath()));
            Collections.emptyList(),  
            new Object[] { 10.0F, 6.0F, randomFloat(), 12.0F, 10.0F, null }
import org.apache.lucene.util.NumericUtils;  
        StarTreeMetadata starTreeMetadata = new StarTreeMetadata(
                starTreeDocuments[i].dimensions,
        List<SequentialDocValuesIterator> metricsIterators = getMetricIterators(segmentStarTreeDocuments);
            getExpectedStarTreeDocumentIterator().size(),
            for (Map.Entry<Long, Integer> dimValueToDocIdEntry : entry.getValue().entrySet()) {  
            VERSION_CURRENT,  
import org.opensearch.index.compositeindex.datacube.startree.fileformats.meta.DimensionConfig;
        fieldsMap1.put("fieldL", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));  
                DocValuesType.SORTED_NUMERIC,
            0,  
            );  
            ),
        Settings settings = Settings.builder().put(settings(org.opensearch.Version.CURRENT).build()).build();
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);  
            STAR_TREE,  
        FieldInfos fieldInfos = new FieldInfos(fieldsInfo);
        SequentialDocValuesIterator[] dimsIterators = getDimensionIterators(segmentStarTreeDocuments);  
        docValuesConsumer.close();  
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
            assertEquals(expectedStarTreeDocument.metrics[1], resultStarTreeDocument.metrics[1]);
        Map<Long, Double> dimValueMap = new HashMap<>();
import org.opensearch.index.mapper.DocumentMapper;
        Settings settings = Settings.builder().put(settings(org.opensearch.Version.CURRENT).build()).build();
        SegmentInfo segmentInfo = new SegmentInfo(
import static org.opensearch.index.compositeindex.datacube.startree.builder.BuilderTestsUtils.getMetricIterators;
                new HalfFloatPoint("hf2", 10),  
            segmentStarTreeDocuments[i] = new StarTreeDocument(  
                new HalfFloatPoint("hf4", 9),  
        starTreeDocuments[0] = new StarTreeDocument(
        for (int i = 0; i < noOfStarTreeDocuments; i++) {
            starTreeMetadata,
        Map<Integer, Map<Long, Double>> expectedDimToValueMap = new HashMap<>();  
            new Object[] { 9.0, 4.0, randomDouble(), 9.0, 12.0, null }  
        starTreeDocuments[3] = new StarTreeDocument(new Long[] { 2L, 13L, 21L }, new Object[] { 100.0, null });
            getExpectedStarTreeDocumentIterator()
        NumberFieldMapper numberFieldMapper2 = new NumberFieldMapper.Builder("field4", NumberFieldMapper.NumberType.FLOAT, false, true)
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
                ((HalfFloatPoint) starTreeDocuments[i].metrics[1]).numericValue().floatValue()
            "test_segment",
        StarTreeDocument[] starTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];  
import org.apache.lucene.util.InfoStream;
        StarTreeMetadata starTreeMetadata = new StarTreeMetadata(
            new Object[] { 14.0, 12.0, randomDouble(), 6.0, 24.0, null }
            new Long[] { 3L, 4L, 2L, 1L },  
            null  
                IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS,
    public void test_build_unsigned_longMetrics() throws IOException {
        );
            getStarTreeDimensionNames(compositeField.getDimensionsOrder()),
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,  
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION  
            new Object[] { 12.0, 10.0, randomDouble(), 8.0, 20.0, 1L }  
        );
            fieldsInfo[i] = new FieldInfo(
            long metric4 = HalfFloatPoint.halfFloatToSortableShort(  
    }
        starTreeDocuments[3] = new StarTreeDocument(
        starTreeDocuments[5] = new StarTreeDocument(new Long[] { 3L, 12L, 23L }, new Object[] { 200.0, null });  
            mock(IndexInput.class),
        );
        );
            1,
        mapperService = mock(MapperService.class);  
        starTreeDocuments[2] = new StarTreeDocument(new Long[] { 3L, 4L, 2L, 1L }, new Long[] { 14L, 12L, randomLong(), 6L, 24L });  
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
        FieldInfos fieldInfos = new FieldInfos(fieldsInfo);  
            "test",  
    }
            metricsIterators
        NumberFieldMapper numberFieldMapper3 = new NumberFieldMapper.Builder("field6", NumberFieldMapper.NumberType.LONG, false, true)
        starTreeDocuments2[0] = new StarTreeDocument(new Long[] { 1L, 11L, 21L }, new Double[] { 400.0 });
 *
        starTreeDocuments[4] = new StarTreeDocument(new Long[] { 3L, 11L, 21L }, new Object[] { 600.0, null });
            Version.LATEST,  
            segmentStarTreeDocuments[i] = new StarTreeDocument(  
            STAR_TREE,  
        DocValuesProducer docValuesProducer = mock(DocValuesProducer.class);
        dimValueMap.put(21L, 1500.0);
        NumberFieldMapper numberFieldMapper1 = new NumberFieldMapper.Builder("field2", NumberFieldMapper.NumberType.HALF_FLOAT, false, true)
            new Long[] { 3L, 4L, 2L, 1L },  
        MappingLookup fieldMappers = new MappingLookup(
            1287
        starTreeDocuments[2] = new StarTreeDocument(  
        starTreeDocuments[1] = new StarTreeDocument(new Long[] { 3L, 4L, 2L, 1L }, new Long[] { 10L, 6L, randomLong(), 12L, 10L });
            "test",  
            new Long[] { 3L, 4L, 2L, 1L },
        );  
        validateFileFormats(dataIn, metaIn, rootNode2, starTreeMetadata2, compositeField2);
        assertStarTreeDocuments(resultStarTreeDocuments, expectedStarTreeDocumentIterator);
            Collections.emptyList(),
        dimValueMap.put(11L, 1000.0);
            new NumericDimension("field3"),
            new StarTreeDocument(new Long[] { null, 13L, null }, new Object[] { 400.0, 2L }),
            "test",
            330
            long metric2 = (Long) starTreeDocuments[i].metrics[1];
        starTreeDocuments[1] = new StarTreeDocument(
    }  
            long metric3 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[2]);
            new Long[] { 2L, 4L, 3L, 4L },
        StarTreeDocument[] starTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
        SequentialDocValuesIterator[] dimsIterators = getDimensionIterators(segmentStarTreeDocuments);  
            new StarTreeDocument(new Long[] { null, null, 21L }, new Object[] { 1500.0, 4L }),  
            new HalfFloatPoint[] {
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
            getExpectedStarTreeDocumentIterator().size(),  
        );
import org.apache.lucene.codecs.DocValuesProducer;
        int noOfStarTreeDocuments = 5;
            mock(IndexInput.class),
            segmentStarTreeDocuments[i] = new StarTreeDocument(  
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION  
                VectorEncoding.FLOAT32,
        }
        DocValuesProducer docValuesProducer = mock(DocValuesProducer.class);
        );  
        );
                true,  
import org.opensearch.index.mapper.MappingLookup;
        Iterator<StarTreeDocument> segmentStarTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(
                starTreeDocuments[i].dimensions,
            getExpectedStarTreeDocumentIterator().size(),
                0,
        );
                -1,
                new HalfFloatPoint("hf8", 12),
        starTreeDocuments[3] = new StarTreeDocument(
            VERSION_CURRENT,  
            "test",  
                new Long[] { metric1, metric2, metric3, metric4, metric5, metric6 }
            getExpectedStarTreeDocumentIterator().size(),  
            .build(new Mapper.BuilderContext(settings, new ContentPath()));
        expectedDimToValueMap.put(2, dimValueMap);
            new StarTreeDocument(new Long[] { 1L, null, 21L }, new Object[] { 400.0, 1L }),  
        when(documentMapper.mappers()).thenReturn(fieldMappers);  
            segmentStarTreeDocuments[i] = new StarTreeDocument(
            NumberFieldMapper.NumberType.UNSIGNED_LONG,
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,  
            writeState,
            new NumericDimension("field8")
        dimensionsOrder = List.of(new NumericDimension("fieldC"), new NumericDimension("fieldB"), new NumericDimension("fieldL"));
        );
        mapperService = mock(MapperService.class);
        metaOut.close();
import java.util.ArrayList;
        starTreeDocuments[2] = new StarTreeDocument(  
            27,
import org.opensearch.index.codec.composite.composite912.Composite912DocValuesFormat;
        );  
        );
            );
            330
            Set.of(numberFieldMapper1),
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
        validateStarTree(builder.getRootNode(), 3, 1, builder.getStarTreeDocuments());
        starTreeDocuments2[6] = new StarTreeDocument(new Long[] { 3L, 12L, 21L }, new Double[] { 400.0 });
            new StarTreeFieldConfiguration(1, Set.of(), getBuildMode())  
        Iterator<StarTreeDocument> segmentStarTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(  
        int noOfStarTreeDocuments = 7;
        when(documentMapper.mappers()).thenReturn(fieldMappers);
                new HalfFloatPoint("field9", 12),  
            dimsIterators,
                fields.get(i),
            "test_segment",  
            new StarTreeDocument(new Long[] { null, null, null }, new Object[] { 2200.0, 7L }),  
        metrics = List.of(  
        );
        }
        StarTreeDocument[] segmentStarTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
        dataOut.close();
            Set.of(numberFieldMapper1, numberFieldMapper2, numberFieldMapper3, numberFieldMapper4, numberFieldMapper5),
        );  
        when(mapperService.documentMapper()).thenReturn(documentMapper);
        ).build(new Mapper.BuilderContext(settings, new ContentPath()));
        InMemoryTreeNode rootNode1 = builder.getRootNode();  
            new Long[] { 3L, 4L, 2L, 1L },  
                new HalfFloatPoint("hf1", 12),  
            null
        NumberFieldMapper numberFieldMapper4 = new NumberFieldMapper.Builder(
        for (int i = 0; i < fieldsInfo.length; i++) {
        starTreeDocuments[3] = new StarTreeDocument(new Long[] { 2L, 4L, 3L, 4L }, new Double[] { 9.0, 4.0, randomDouble(), 9.0, 12.0 });
            1,  
        when(mapperService.documentMapper()).thenReturn(documentMapper);
            builder.numStarTreeNodes,
                false,  
        );
            writeState,
            dimsIterators,
        metaOut.close();
            new StarTreeDocument(new Long[] { 3L, null, null }, new Object[] { 1200.0, 3L }),  
            starTreeMetadata,
            Set.of(numberFieldMapper1),  
            false,
        );  
        fieldsInfo = new FieldInfo[fields.size()];
            directory,
            1,
        );  
        MappingLookup fieldMappers = new MappingLookup(
        starTreeDocuments2[3] = new StarTreeDocument(new Long[] { 2L, 13L, 21L }, new Double[] { 100.0 });
            getBuildMode(),
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
                VectorEncoding.FLOAT32,
        Settings settings = Settings.builder().put(settings(org.opensearch.Version.CURRENT).build()).build();  
        assertStarTreeDocuments(resultStarTreeDocuments, expectedStarTreeDocumentIterator);
        NumberFieldMapper numberFieldMapper2 = new NumberFieldMapper.Builder("field4", NumberFieldMapper.NumberType.LONG, false, true)
import static org.opensearch.index.compositeindex.datacube.startree.builder.BuilderTestsUtils.getDimensionIterators;
        int noOfStarTreeDocuments = 5;
            new Long[] { 2L, 4L, 3L, 4L },
            getExpectedStarTreeDocumentIteratorForUnsignedLong()
    }  
            starTreeMetadata,  
            Set.of(),  
        NumberFieldMapper numberFieldMapper3 = new NumberFieldMapper.Builder(
import java.util.Iterator;
        dataOut.close();
            new StarTreeDocument(new Long[] { 1L, null, 22L }, new Object[] { 200.0, 1L }),
import org.apache.lucene.index.VectorSimilarityFunction;
            getBuildMode(),
            330
        );
                -1,
        IndexInput dataIn = readState.directory.openInput(dataFileName, IOContext.DEFAULT);
        starTreeDocuments[1] = new StarTreeDocument(new Long[] { 1L, 12L, 22L }, new Object[] { 200.0, null });
            .build(new Mapper.BuilderContext(settings, new ContentPath()));
            long metric5 = HalfFloatPoint.halfFloatToSortableShort(  
        Map<Integer, Map<Long, Integer>> dimValueToDocIdMap = new HashMap<>();  
            27,
            "test",  
        starTreeDocuments[3] = new StarTreeDocument(  
        );
        starTreeDocuments[6] = new StarTreeDocument(new Long[] { 3L, 12L, 21L }, new Object[] { 400.0, null });
            dimsIterators,
                starTreeDocuments[i].dimensions,
            STAR_TREE,  
            false,
            Collections.emptyList(),
            false,  
                new Long[] { metric1, metric2, metric3, metric4, metric5 }
        fieldsMap.put("field8", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
            NumberFieldMapper.NumberType.UNSIGNED_LONG,
            );
                new HalfFloatPoint("hf5", 11),  
        );
        List<Metric> metrics = new ArrayList<>();
                true,
        StarTreeDocument[] starTreeDocuments2 = new StarTreeDocument[noOfStarTreeDocuments2];  
        docValuesConsumer.close();
        mapperService = mock(MapperService.class);
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);  
            long metric1 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[0]);
            new NumericDimension("field1"),
            0,  
            330  
            getStarTreeDimensionNames(compositeField.getDimensionsOrder()),
            "test",
                0,  
            2,
import java.util.List;  
        fields = List.of("fieldC", "fieldB", "fieldL", "fieldI");
        StarTreeDocument[] segmentStarTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
            segmentStarTreeDocuments[i] = new StarTreeDocument(  
    public void test_build_floatMetrics() throws IOException {  
            new StarTreeFieldConfiguration(1, Set.of("field8"), getBuildMode())  
            metricsIterators
            Set.of(numberFieldMapper1, numberFieldMapper2, numberFieldMapper3, numberFieldMapper4, numberFieldMapper5),
        metrics.addAll(starTreeMetadata.getMetrics());
            Collections.emptyList(),
            Collections.emptyList(),
import org.opensearch.index.mapper.ContentPath;  
        builder.build(segmentStarTreeDocumentIterator2, new AtomicInteger(), mock(DocValuesConsumer.class));
        NumberFieldMapper numberFieldMapper4 = new NumberFieldMapper.Builder("field9", NumberFieldMapper.NumberType.LONG, false, true)  
        );
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
            );
        dataOut.close();
import org.apache.lucene.index.VectorEncoding;  
            builder.getRootNode(),
        );  
                new HalfFloatPoint("field10", 20) }
        fieldProducerMap = new HashMap<>();  
            0,  
        dimValueMap.put(2L, 400.0);  
            STAR_TREE,
            List.of(
        List<SequentialDocValuesIterator> metricsIterators = getMetricIterators(segmentStarTreeDocuments);  
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeNodeType;
        List<StarTreeDocument> resultStarTreeDocuments = builder.getStarTreeDocuments();
            new Lucene104Codec(),  
        assertEquals(7, resultStarTreeDocuments.size());
            new StarTreeDocument(new Long[] { null, null, 23L }, new Object[] { 500.0, 2L }),
            long metric2 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[1]);
        );
            }  
        validateStarTreeFileFormats(
        metaOut.close();
            2,  
            "test",  
                starTreeDocuments[i].dimensions,
            mock(IndexInput.class),
        when(documentMapper.mappers()).thenReturn(fieldMappers);
            long metric5 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[4]);
        builder.build(segmentStarTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
        NumberFieldMapper numberFieldMapper4 = new NumberFieldMapper.Builder("field9", NumberFieldMapper.NumberType.FLOAT, false, true)  
            2,
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
        starTreeDocuments[2] = new StarTreeDocument(new Long[] { 3L, 4L, 2L, 1L }, new Double[] { 14.0, 12.0, randomDouble(), 6.0, 24.0 });
        starTreeDocuments2[5] = new StarTreeDocument(new Long[] { 3L, 12L, 23L }, new Double[] { 200.0 });  
                DocValuesSkipIndexType.RANGE,  
            new StarTreeDocument(new Long[] { null, 11L, 21L }, new Object[] { 1000.0, 2L }),  
            0,  
    }
            starTreeMetadata,
        for (int i = 0; i < noOfStarTreeDocuments2; i++) {
                new Metric("field6", List.of(MetricStat.VALUE_COUNT)),
            long metric1 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments2[i].metrics[0]);
import org.opensearch.index.compositeindex.datacube.startree.StarTreeFieldConfiguration;  
            dimsIterators,
            getBuildMode(),
        }
        );
        DocumentMapper documentMapper = mock(DocumentMapper.class);
            builder.getRootNode(),
        builder.build(segmentStarTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
        DocumentMapper documentMapper = mock(DocumentMapper.class);
        );  
        starTreeDocuments[2] = new StarTreeDocument(  
            getStarTreeDimensionNames(compositeField.getDimensionsOrder()),
        );
            getExpectedStarTreeDocumentIterator().size(),
        fieldsMap1.put("fieldB", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
            .build(new Mapper.BuilderContext(settings, new ContentPath()));
            assertEquals(expectedStarTreeDocument.metrics[0], ((CompensatedSum) resultStarTreeDocument.metrics[0]).value());  
import org.opensearch.index.compositeindex.datacube.Dimension;
                false,
                new HalfFloatPoint("field6", 10),
        ).build(new Mapper.BuilderContext(settings, new ContentPath()));
            Map<Long, Double> map = expectedDimToValueMap.get(dimId);
            Set.of("field8"),
        MappingLookup fieldMappers = new MappingLookup(  
        starTreeDocuments[1] = new StarTreeDocument(  
                i,
        dimensionsOrder = List.of(new NumericDimension("fieldC"), new NumericDimension("fieldB"), new NumericDimension("fieldL"));
        starTreeDocuments[0] = new StarTreeDocument(
        }
import org.apache.lucene.index.FieldInfos;
        StarTreeDocument[] segmentStarTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
        }
        starTreeDocuments[1] = new StarTreeDocument(
        starTreeDocuments[4] = new StarTreeDocument(new Long[] { 3L, 4L, 2L, 1L }, new Double[] { 11.0, 16.0, randomDouble(), 8.0, 13.0 });  
        StarTreeDocument[] segmentStarTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
        mapperService = mock(MapperService.class);  
                new Long[] { metric1, metric2, metric3, metric4, metric5, metric6 }
        List<SequentialDocValuesIterator> metricsIterators2 = getMetricIterators(segmentStarTreeDocuments2);
            getExpectedStarTreeDocumentIterator()
public class StarTreeBuildMetricTests extends StarTreeBuilderTestCase {
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
                DocValuesType.SORTED_NUMERIC,  
        int noOfStarTreeDocuments = 5;
            VERSION_CURRENT,  
import org.opensearch.search.aggregations.metrics.CompensatedSum;  
            mock(IndexInput.class),
        starTreeDocuments[3] = new StarTreeDocument(
        starTreeDocuments[4] = new StarTreeDocument(  
                new HalfFloatPoint("hf3", 14),  
        docValuesConsumer.close();  
            long metric5 = (Long) starTreeDocuments[i].metrics[4];
        metrics = List.of(new Metric("fieldI", List.of(MetricStat.SUM)));  
                false,
                long dimValue = dimValueToDocIdEntry.getKey();
        Iterator<StarTreeDocument> expectedStarTreeDocumentIterator = getExpectedStarTreeDocumentIterator().iterator();
        docValuesConsumer.close();  
        IndexInput metaIn = readState.directory.openInput(metaFileName, IOContext.DEFAULT);
import static org.opensearch.index.mapper.CompositeMappedFieldType.CompositeFieldType.STAR_TREE;  
        dimValueMap = new HashMap<>();
            long metric2 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[1]);
            starTreeMetadata,
            mock(IndexInput.class),
            new Object[] { 11.0, 16.0, randomDouble(), 8.0, 13.0, null }
            int dimId = entry.getKey();  
        assertEquals(7, resultStarTreeDocuments.size());
            Long metric6 = (Long) starTreeDocuments[i].metrics[5];
        int noOfStarTreeDocuments = 5;
        when(documentMapper.mappers()).thenReturn(fieldMappers);  
                VectorSimilarityFunction.EUCLIDEAN,
            .build(new Mapper.BuilderContext(settings, new ContentPath()));
                new HalfFloatPoint("hf6", 10),
                new HalfFloatPoint("hf7", 6),
            1,  
            new Long[] { 2L, 4L, 3L, 4L },  
            Set.of("field8"),
            getBuildMode(),
            if (dimId == -1) continue;
        dimValueMap.put(12L, 800.0);  
    }  
            Collections.emptyList(),
        builder.build(segmentStarTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);  
                0,
        builder.build(segmentStarTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
import java.util.HashMap;  
            0,
            new StarTreeDocument(new Long[] { 3L, 12L, 23L }, new Object[] { 200.0, 1L }),
                fields.get(i),  
        StarTreeMetadata starTreeMetadata = new StarTreeMetadata(
            "field10",
    }
        starTreeDocuments[0] = new StarTreeDocument(new Long[] { 2L, 4L, 3L, 4L }, new Long[] { 12L, 10L, randomLong(), 8L, -1L });
        );
    }
            new Long[] { 2L, 4L, 3L, 4L },
        );
        );
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
        NumberFieldMapper numberFieldMapper1 = new NumberFieldMapper.Builder("field2", NumberFieldMapper.NumberType.FLOAT, false, true)  
            );  
            NumberFieldMapper.NumberType.UNSIGNED_LONG,
import org.apache.lucene.codecs.lucene104.Lucene104Codec;  
        LinkedHashMap<String, DimensionConfig> totalDimensionFields = new LinkedHashMap<>(starTreeMetadata.getDimensionFields());
                new Metric("field9", List.of(MetricStat.MIN)),  
        StarTreeField compositeField1 = new StarTreeField(
                new HalfFloatPoint("field10", 12) }
            new StarTreeDocument(new Long[] { null, 13L, 23L }, new Object[] { 300.0, 1L }),
            segmentStarTreeDocuments2[i] = new StarTreeDocument(starTreeDocuments2[i].dimensions, new Long[] { metric1 });  
            new Object[] { 12.0F, 10.0F, randomFloat(), 8.0F, 20.0F, null }  
            2,  
            "field6",  
        StarTreeDocument[] segmentStarTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
import java.util.UUID;  
            UUID.randomUUID().toString().substring(0, 16).getBytes(StandardCharsets.UTF_8),
        Iterator<StarTreeDocument> resultStarTreeDocumentIterator = resultStarTreeDocuments.iterator();
            dimensionsOrder,
            long metric4 = NumericUtils.floatToSortableInt((Float) starTreeDocuments[i].metrics[3]);  
        when(mapperService.documentMapper()).thenReturn(documentMapper);
        List<SequentialDocValuesIterator> metricsIterators = getMetricIterators(segmentStarTreeDocuments);
            .build(new Mapper.BuilderContext(settings, new ContentPath()));
            new Object[] { 14.0F, 12.0F, randomFloat(), 6.0F, 24.0F, null }
            true  
                false,
import static org.opensearch.index.compositeindex.datacube.startree.fileformats.StarTreeWriter.VERSION_CURRENT;
                new HalfFloatPoint("field10", 13) }
            new NumericDimension("fieldL")  
            dimensionsOrder1,
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
            getExpectedStarTreeDocumentIteratorForUnsignedLong().size(),  
import java.util.LinkedHashMap;
        expectedDimToValueMap.put(1, dimValueMap);
            long metric1 = HalfFloatPoint.halfFloatToSortableShort(  
                false,  
import static org.opensearch.index.compositeindex.datacube.startree.builder.BuilderTestsUtils.validateStarTree;
        );
        fieldProducerMap = new HashMap<>();
        for (int i = 0; i < noOfStarTreeDocuments; i++) {  
            builder.getRootNode(),
            new Long[] { 3L, 4L, 2L, 1L },  
        dimValueMap.put(1L, 600.0);
                false
        NumberFieldMapper numberFieldMapper2 = new NumberFieldMapper.Builder(
            dimsIterators,
            assertEquals(expectedStarTreeDocument.dimensions[1], resultStarTreeDocument.dimensions[1]);
                i,  
        );
            compositeField.getMetrics(),
            new StarTreeDocument(new Long[] { 3L, 12L, null }, new Object[] { 600.0, 2L })
            dimensionsOrder2,
            1287  
            new StarTreeDocument(new Long[] { null, 13L, 21L }, new Object[] { 100.0, 1L }),
            "field2",  
            new Metric("field6", List.of(MetricStat.VALUE_COUNT)),  
            "field9",  
 */  
/*  
            long metric5 = (Long) starTreeDocuments[i].metrics[4];
        validateStarTreeFileFormats(
            "test",  
        starTreeDocuments[0] = new StarTreeDocument(new Long[] { 1L, 11L, 21L }, new Object[] { 400.0, null });
                    assertEquals(map.get(dimValue), ((CompensatedSum) resultStarTreeDocuments.get(docId).metrics[0]).value(), 0);
        validateStarTreeFileFormats(builder.getRootNode(), 27, starTreeMetadata, expectedStarTreeDocuments());
            .build(new Mapper.BuilderContext(settings, new ContentPath()));
            builder.getRootNode(),
        StarTreeMetadata starTreeMetadata = new StarTreeMetadata(
            330,  
            long metric4 = (Long) starTreeDocuments[i].metrics[3];  
        starTreeDocuments[0] = new StarTreeDocument(new Long[] { 2L, 4L, 3L, 4L }, new Double[] { 12.0, 10.0, randomDouble(), 8.0, 20.0 });
            VERSION_CURRENT,
    public void test_build_starTreeDataset() throws IOException {  
            new HalfFloatPoint[] {
import static org.mockito.Mockito.when;
        List<StarTreeDocument> resultStarTreeDocuments = builder.getStarTreeDocuments();
            0,  
            330  
            true  
        Iterator<StarTreeDocument> segmentStarTreeDocumentIterator2 = builder.sortAndAggregateSegmentDocuments(  
                new HalfFloatPoint("hf10", 16),
    }
        NumberFieldMapper numberFieldMapper1 = new NumberFieldMapper.Builder(
        List<SequentialDocValuesIterator> metricsIterators = getMetricIterators(segmentStarTreeDocuments);
        );  
            StarTreeDocument expectedStarTreeDocument = expectedStarTreeDocumentIterator.next();
        when(mapperService.documentMapper()).thenReturn(documentMapper);
        );
            new HashMap<>(),
            .build(new Mapper.BuilderContext(settings, new ContentPath()));  
        );  
        List<SequentialDocValuesIterator> metricsIterators = getMetricIterators(segmentStarTreeDocuments);
            STAR_TREE,
            new StarTreeDocument(new Long[] { 3L, null, 21L }, new Object[] { 1000.0, 2L }),
                new HalfFloatPoint("field6", 10),
        DocumentMapper documentMapper = mock(DocumentMapper.class);  
            fieldsMap1,
            .build(new Mapper.BuilderContext(settings, new ContentPath()));
        Settings settings = Settings.builder().put(settings(org.opensearch.Version.CURRENT).build()).build();  
            new HashMap<>(),
    }  
            segmentStarTreeDocuments[i] = new StarTreeDocument(  
            null  
            "test",
            false,
            );
            STAR_TREE,
        MappingLookup fieldMappers = new MappingLookup(
import org.opensearch.index.compositeindex.datacube.NumericDimension;  
import org.opensearch.common.settings.Settings;
            getExpectedStarTreeDocumentIterator().size(),
            long metric3 = (Long) starTreeDocuments[i].metrics[2];  
        when(mapperService.documentMapper()).thenReturn(documentMapper);  
            );
        );
        compositeField = new StarTreeField("test", dimensionsOrder, metrics, new StarTreeFieldConfiguration(1, Set.of(), getBuildMode()));
            new StarTreeDocument(new Long[] { null, 12L, 21L }, new Object[] { 400.0, 1L }),
        );
        metaIn.close();
        );
        Iterator<StarTreeDocument> expectedStarTreeDocumentIterator = getExpectedStarTreeDocumentIterator().iterator();
        );
        metaOut.close();  
        builder.close();  
        List<StarTreeDocument> resultStarTreeDocuments = builder.getStarTreeDocuments();  
        starTreeDocuments[1] = new StarTreeDocument(new Long[] { 3L, 4L, 2L, 1L }, new Double[] { 10.0, 6.0, randomDouble(), 12.0, 10.0 });  
            long metric5 = NumericUtils.floatToSortableInt((Float) starTreeDocuments[i].metrics[4]);
            new HalfFloatPoint[] {
import java.util.concurrent.atomic.AtomicInteger;
        metaOut.close();
            Collections.emptyList(),
import java.util.Collections;
            0,  
        dataIn.close();  
                false
            new Long[] { 3L, 4L, 2L, 1L },
            metrics,
        when(documentMapper.mappers()).thenReturn(fieldMappers);
        NumberFieldMapper numberFieldMapper2 = new NumberFieldMapper.Builder("field4", NumberFieldMapper.NumberType.HALF_FLOAT, false, true)  
        metaOut.close();
                int docId = dimValueToDocIdEntry.getValue();
        }
        Iterator<StarTreeDocument> expectedStarTreeDocumentIterator = getExpectedStarTreeDocumentIterator().iterator();
            new StarTreeDocument(new Long[] { null, 12L, null }, new Object[] { 800.0, 3L }),
            VERSION_CURRENT,  
        }
        writeState = new SegmentWriteState(InfoStream.getDefault(), segmentInfo.dir, segmentInfo, fieldInfos, null, newIOContext(random()));
            writeState,  
        SequentialDocValuesIterator[] dimsIterators = getDimensionIterators(segmentStarTreeDocuments);  
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,  
        Settings settings = Settings.builder().put(settings(org.opensearch.Version.CURRENT).build()).build();
        SequentialDocValuesIterator[] dimsIterators = getDimensionIterators(segmentStarTreeDocuments);  
            new StarTreeDocument(new Long[] { 3L, 12L, 21L }, new Object[] { 400.0, 1L }),
        starTreeDocuments[3] = new StarTreeDocument(new Long[] { 2L, 4L, 3L, 4L }, new Long[] { 9L, 4L, randomLong(), 9L, 12L });
        Iterator<StarTreeDocument> segmentStarTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(  
            Set.of(numberFieldMapper1, numberFieldMapper2, numberFieldMapper3, numberFieldMapper4, numberFieldMapper5),  
 * The OpenSearch Contributors require contributions made to  
        SequentialDocValuesIterator[] dimsIterators = getDimensionIterators(segmentStarTreeDocuments);  
            null
        SequentialDocValuesIterator[] dimsIterators = getDimensionIterators(segmentStarTreeDocuments);  
            null
                new Long[] { metric1, metric2, metric3, metric4, metric5, null }
        );  
        for (int i = 0; i < fieldsInfo.length; i++) {  
            new HalfFloatPoint[] {
            getStarTreeDimensionNames(compositeField.getDimensionsOrder()),
                ((HalfFloatPoint) starTreeDocuments[i].metrics[3]).numericValue().floatValue()
            Set.of("field8"),
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
            7,
        NumberFieldMapper numberFieldMapper3 = new NumberFieldMapper.Builder("field6", NumberFieldMapper.NumberType.FLOAT, false, true)
        NumberFieldMapper numberFieldMapper1 = new NumberFieldMapper.Builder("fieldI", NumberFieldMapper.NumberType.DOUBLE, false, true)
            builder.numStarTreeNodes,
            metricsIterators
            new Metric("field9", List.of(MetricStat.MIN)),
        StarTreeField compositeField2 = new StarTreeField(
import static org.opensearch.index.compositeindex.datacube.startree.builder.BuilderTestsUtils.traverseStarTree;  
            new Object[] { 9.0F, 4.0F, randomFloat(), 9.0F, 12.0F, null }  
            2,
            new Object[] { 11.0F, 16.0F, randomFloat(), 8.0F, 13.0F, null }
        InMemoryTreeNode rootNode2 = builder.getRootNode();
            dimsIterators2,
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
            metricsIterators  
        StarTreeMetadata starTreeMetadata = new StarTreeMetadata(
        assertStarTreeDocuments(resultStarTreeDocuments, expectedStarTreeDocumentIterator);
                Collections.emptyMap(),
        dimValueMap.put(22L, 200.0);  
            metricsIterators2
            long metric1 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[0]);  
            new Long[] { 3L, 4L, 2L, 1L },
            new StarTreeDocument(new Long[] { 1L, 11L, 21L }, new Object[] { 400.0, 1L }),
        StarTreeMetadata starTreeMetadata2 = new StarTreeMetadata(
        while (resultStarTreeDocumentIterator.hasNext() && expectedStarTreeDocumentIterator.hasNext()) {  
                new Metric("field2", List.of(MetricStat.SUM)),  
        fieldsMap.put("field3", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));  
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);  
        int noOfStarTreeDocuments = 5;  
        fieldsMap.put("field5", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
import org.opensearch.index.codec.composite.LuceneDocValuesConsumerFactory;  
    public void test_build_multipleStarTrees() throws IOException {  
import org.apache.lucene.index.FieldInfo;  
        }  
            new StarTreeDocument(new Long[] { 3L, null, 23L }, new Object[] { 200.0, 1L }),
            metricsIterators
            Version.LUCENE_10_1_0,
        );
        starTreeDocuments2[4] = new StarTreeDocument(new Long[] { 3L, 11L, 21L }, new Double[] { 600.0 });
                new HalfFloatPoint("field10", 24) }
                false,
                new Long[] { metric1, metric2, metric3, metric4, metric5, null }
            builder.numStarTreeNodes,
            STAR_TREE,
import org.apache.lucene.index.DocValuesType;
            builder.numStarTreeNodes,  
            false,  
            new Long[] { -2L, -9223372036854775808L, randomLong(), 12L, 10L }
        for (int i = 0; i < noOfStarTreeDocuments; i++) {  
            builder.getRootNode(),
            true  
        }
        dataOut.close();
            1,
            new Long[] { 2L, 4L, 3L, 4L },
            new HashMap<>(),  
            null
            new Object[] { 10.0, 6.0, randomDouble(), 12.0, 10.0, null }
            UUID.randomUUID().toString().substring(0, 16).getBytes(StandardCharsets.UTF_8),  
        ).build(new Mapper.BuilderContext(settings, new ContentPath()));
            330
        mapperService = mock(MapperService.class);
                starTreeDocuments[i].dimensions,  
        );
        dataOut.close();
                new HalfFloatPoint("field9", 8),  
        NumberFieldMapper numberFieldMapper5 = new NumberFieldMapper.Builder(
        starTreeDocuments[2] = new StarTreeDocument(new Long[] { 2L, 13L, 23L }, new Object[] { 300.0, null });  
            builder.numStarTreeNodes,  
            new HalfFloatPoint[] {
import java.util.Set;
            getStarTreeDimensionNames(compositeField.getDimensionsOrder()),
            compositeField.getMetrics(),  
            getExpectedStarTreeDocumentIterator()
        return List.of(
        StarTreeMetadata starTreeMetadata = new StarTreeMetadata(
            Version.LATEST,
import org.apache.lucene.codecs.DocValuesConsumer;
        validateStarTreeFileFormats(
            false,
        docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
        );
            null
            metrics,
        );
            7,
        }
            compositeField.getMetrics(),
import org.opensearch.index.mapper.MapperService;  
            "field4",  
            );  
import java.util.Map;
        starTreeDocuments[2] = new StarTreeDocument(new Long[] { 3L, 4L, 2L, 1L }, new Long[] { 14L, 12L, randomLong(), 6L, 24L });
        List<Dimension> dimensionsOrder1 = List.of(  
    public StarTreeBuildMetricTests(StarTreeFieldConfiguration.StarTreeBuildMode buildMode) {  
            StarTreeDocument resultStarTreeDocument = resultStarTreeDocumentIterator.next();
        when(mapperService.documentMapper()).thenReturn(documentMapper);
        );
                new HalfFloatPoint("hf9", 4),
        );
            metricsIterators
            long metric4 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[3]);
import static org.mockito.Mockito.mock;
            .build(new Mapper.BuilderContext(settings, new ContentPath()));  
        );
        fields = List.of("fieldC", "fieldB", "fieldL", "fieldI");  
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
        builder.build(segmentStarTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
        StarTreeDocument[] segmentStarTreeDocuments2 = new StarTreeDocument[noOfStarTreeDocuments2];  
            writeState,
            "field10",  
            new StarTreeDocument(new Long[] { null, 12L, 23L }, new Object[] { 200.0, 1L }),  
        ).build(new Mapper.BuilderContext(settings, new ContentPath()));
            VERSION_CURRENT,
        assertEquals(7, resultStarTreeDocuments.size());
            directory,  
    private static Map<Integer, Map<Long, Double>> getExpectedDimToValueMap() {
            "test",  
            Collections.emptyList(),  
            false,
        dimValueMap.put(23L, 500.0);
import org.apache.lucene.sandbox.document.HalfFloatPoint;
            compositeField.getMetrics(),  
            new StarTreeDocument(new Long[] { 2L, 13L, null }, new Object[] { 400.0, 2L }),  
        ).build(new Mapper.BuilderContext(settings, new ContentPath()));
        SequentialDocValuesIterator[] dimsIterators2 = getDimensionIterators(segmentStarTreeDocuments2);  
        );
                new Long[] { metric1, metric2, metric3, metric4, metric5, null }
            );  
            true  
            new Long[] { 9L, 4L, randomLong(), -9223372036854775806L, 12L }
import org.opensearch.index.compositeindex.datacube.MetricStat;
        );
            long metric2 = NumericUtils.floatToSortableInt((Float) starTreeDocuments[i].metrics[1]);
            true
import java.nio.charset.StandardCharsets;  
            null
            2,
        Map<Integer, Map<Long, Double>> expectedDimToValueMap = getExpectedDimToValueMap();
            1,  
import org.opensearch.index.compositeindex.datacube.Metric;
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
                ((HalfFloatPoint) starTreeDocuments[i].metrics[2]).numericValue().floatValue()
            Collections.emptyList(),  
                new HalfFloatPoint("field9", 6),  
        for (int i = 0; i < noOfStarTreeDocuments; i++) {
                new HalfFloatPoint("field9", 9),  
        starTreeDocuments[4] = new StarTreeDocument(new Long[] { 3L, 4L, 2L, 1L }, new Long[] { 11L, 16L, randomLong(), 8L, 13L });  
        DocumentMapper documentMapper = mock(DocumentMapper.class);  
                0,  
            new Lucene104Codec(),
            new StarTreeDocument(new Long[] { 2L, 13L, 23L }, new Object[] { 300.0, 1L }),
        Iterator<StarTreeDocument> segmentStarTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(  
        metrics = List.of(new Metric("fieldI", List.of(MetricStat.SUM)), new Metric("_doc_count", List.of(MetricStat.DOC_COUNT)));
            long metric4 = (Long) starTreeDocuments[i].metrics[3];
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,  
        );
            Set.of("field8"),  
 * this file be licensed under the Apache-2.0 license or a
            assertEquals(expectedStarTreeDocument.dimensions[0], resultStarTreeDocument.dimensions[0]);  
                IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS,
        for (Map.Entry<Integer, Map<Long, Integer>> entry : dimValueToDocIdMap.entrySet()) {
            false,
        Iterator<StarTreeDocument> segmentStarTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(
                Collections.emptyMap(),  
            .build(new Mapper.BuilderContext(settings, new ContentPath()));
        starTreeDocuments2[1] = new StarTreeDocument(new Long[] { 1L, 12L, 22L }, new Double[] { 200.0 });
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
    public void test_build() throws IOException {
import org.apache.lucene.index.SegmentInfo;  
            );
import org.apache.lucene.index.SegmentReadState;
            long metric3 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[2]);  
        );  
import static org.opensearch.index.compositeindex.datacube.startree.StarTreeTestUtils.validateFileFormats;  
            NumberFieldMapper.NumberType.UNSIGNED_LONG,
            new Metric("field10", List.of(MetricStat.MAX))
        dimValueMap.put(3L, 1200.0);
        assertEquals(7, resultStarTreeDocuments.size());
            NumberFieldMapper.NumberType.UNSIGNED_LONG,
    public void test_build_halfFloatMetrics() throws IOException {
            getBuildMode(),
import org.apache.lucene.store.IndexInput;
            Version.LUCENE_10_1_0,
