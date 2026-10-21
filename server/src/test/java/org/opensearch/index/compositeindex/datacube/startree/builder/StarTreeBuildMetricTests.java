            "test",
        IndexInput dataIn = readState.directory.openInput(dataFileName, IOContext.DEFAULT);
            mock(IndexInput.class),
        );
            new StarTreeDocument(new Long[] { 3L, 12L, 21L }, new Object[] { 400.0, 1L }),
            Set.of(numberFieldMapper1, numberFieldMapper2, numberFieldMapper3, numberFieldMapper4, numberFieldMapper5),
            false,
                }
import java.util.List;
import java.io.IOException;
            builder.numStarTreeNodes,
        // building another tree in the same file
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
        starTreeDocuments[4] = new StarTreeDocument(new Long[] { 3L, 4L, 2L, 1L }, new Double[] { 11.0, 16.0, randomDouble(), 8.0, 13.0 });
        starTreeDocuments2[6] = new StarTreeDocument(new Long[] { 3L, 12L, 21L }, new Double[] { 400.0 });
        }
        metaOut.close();
                new Long[] { metric1, metric2, metric3, metric4, metric5, metric6 }
                fields.get(i),
            dimsIterators2,
        Iterator<StarTreeDocument> segmentStarTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(
        NumberFieldMapper numberFieldMapper3 = new NumberFieldMapper.Builder("field6", NumberFieldMapper.NumberType.FLOAT, false, true)
            STAR_TREE,
            mock(IndexInput.class),
            mock(IndexInput.class),
        );
            long metric3 = (Long) starTreeDocuments[i].metrics[2];
            );
            NumberFieldMapper.NumberType.UNSIGNED_LONG,
import org.apache.lucene.index.DocValuesType;
            new NumericDimension("field3"),
            new Metric("field6", List.of(MetricStat.VALUE_COUNT)),
            dimsIterators,
import org.apache.lucene.codecs.lucene104.Lucene104Codec;
            Collections.emptyList(),
            mock(IndexInput.class),
import org.apache.lucene.index.IndexOptions;
            dimsIterators,
            long metric1 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[0]);
import java.util.concurrent.atomic.AtomicInteger;
            long metric5 = (Long) starTreeDocuments[i].metrics[4];
            Collections.emptyList(),
import org.opensearch.index.compositeindex.datacube.Dimension;
            1,
        );
        );
        starTreeDocuments[2] = new StarTreeDocument(new Long[] { 3L, 4L, 2L, 1L }, new Long[] { 14L, 12L, randomLong(), 6L, 24L });
        expectedDimToValueMap.put(0, dimValueMap);
        List<SequentialDocValuesIterator> metricsIterators = getMetricIterators(segmentStarTreeDocuments);
        starTreeDocuments[1] = new StarTreeDocument(
            getBuildMode(),
        MappingLookup fieldMappers = new MappingLookup(
            UUID.randomUUID().toString().substring(0, 16).getBytes(StandardCharsets.UTF_8),
}
            long metric3 = HalfFloatPoint.halfFloatToSortableShort(
        FieldInfos fieldInfos = new FieldInfos(fieldsInfo);
        StarTreeDocument[] segmentStarTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
            false,
            "test",
        int noOfStarTreeDocuments = 5;
import java.util.UUID;
            0,
                starTreeDocuments[i].dimensions,
        Iterator<StarTreeDocument> segmentStarTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(
        dimValueMap.put(12L, 800.0);
        assertEquals(7, resultStarTreeDocuments.size());
                new HalfFloatPoint("field6", 10),
        }
        for (int i = 0; i < noOfStarTreeDocuments; i++) {
            330
        SequentialDocValuesIterator[] dimsIterators = getDimensionIterators(segmentStarTreeDocuments);
        );
            Set.of(numberFieldMapper1, numberFieldMapper2, numberFieldMapper3, numberFieldMapper4, numberFieldMapper5),
        builder.build(segmentStarTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
        NumberFieldMapper numberFieldMapper1 = new NumberFieldMapper.Builder("field2", NumberFieldMapper.NumberType.HALF_FLOAT, false, true)
        );
                ((HalfFloatPoint) starTreeDocuments[i].metrics[1]).numericValue().floatValue()
            new Long[] { -2L, -9223372036854775808L, randomLong(), 12L, 10L }
        NumberFieldMapper numberFieldMapper4 = new NumberFieldMapper.Builder("field9", NumberFieldMapper.NumberType.HALF_FLOAT, false, true)
            Collections.emptyList(),
            new Object[] { 9.0, 4.0, randomDouble(), 9.0, 12.0, null }
        ).build(new Mapper.BuilderContext(settings, new ContentPath()));
            fieldProducerMap.put(fields.get(i), docValuesProducer);
        );
        builder.build(segmentStarTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
        for (int i = 0; i < noOfStarTreeDocuments; i++) {
            fieldsInfo[i] = new FieldInfo(
            27,
        Settings settings = Settings.builder().put(settings(org.opensearch.Version.CURRENT).build()).build();
            330
            new Object[] { 14.0, 12.0, randomDouble(), 6.0, 24.0, null }
                VectorSimilarityFunction.EUCLIDEAN,
        validateFileFormats(dataIn, metaIn, rootNode1, starTreeMetadata, compositeField1);
        );
        StarTreeDocument[] starTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
        builder.build(segmentStarTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
            long metric1 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[0]);
            metricsIterators
            );
import java.util.ArrayList;
                IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS,
        starTreeDocuments[2] = new StarTreeDocument(new Long[] { 3L, 4L, 2L, 1L }, new Long[] { 14L, 12L, randomLong(), 6L, 24L });
        int noOfStarTreeDocuments = 5;
        StarTreeDocument[] starTreeDocuments2 = new StarTreeDocument[noOfStarTreeDocuments2];
                new HalfFloatPoint("hf3", 14),
        return List.of(
            null
            long metric2 = (Long) starTreeDocuments[i].metrics[1];
            NumberFieldMapper.NumberType.HALF_FLOAT,
            new StarTreeDocument(new Long[] { 3L, null, 23L }, new Object[] { 200.0, 1L }),
            getStarTreeDimensionNames(compositeField.getDimensionsOrder()),
            new NumericDimension("fieldC"),
            2,
            new HalfFloatPoint[] {
            0,
        starTreeDocuments[1] = new StarTreeDocument(
            builder.getRootNode(),
            "field9",
        StarTreeDocument[] segmentStarTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
            7,
            330,
            2,
        );
            new Long[] { 2L, 4L, 3L, 4L },
        NumberFieldMapper numberFieldMapper5 = new NumberFieldMapper.Builder("field10", NumberFieldMapper.NumberType.FLOAT, false, true)
        );
import org.apache.lucene.index.DocValuesSkipIndexType;
        StarTreeMetadata starTreeMetadata = new StarTreeMetadata(
            fieldsMap1,
import org.apache.lucene.store.IOContext;
        docValuesConsumer.close();
        );
        assertStarTreeDocuments(resultStarTreeDocuments, expectedStarTreeDocumentIterator);
import org.opensearch.index.compositeindex.datacube.startree.StarTreeFieldConfiguration;
        when(mapperService.documentMapper()).thenReturn(documentMapper);
                new HalfFloatPoint("hf2", 10),
        );
            mock(IndexInput.class),
                ((HalfFloatPoint) starTreeDocuments[i].metrics[4]).numericValue().floatValue()
                starTreeDocuments[i].dimensions,
                new Long[] { metric1, metric2, metric3, metric4, metric5, null }
        NumberFieldMapper numberFieldMapper2 = new NumberFieldMapper.Builder("field4", NumberFieldMapper.NumberType.HALF_FLOAT, false, true)
            getBuildMode(),
        );
            new StarTreeDocument(new Long[] { 2L, 13L, null }, new Object[] { 400.0, 2L }),
        );
                new HalfFloatPoint("field9", 9),
            long metric2 = NumericUtils.floatToSortableInt((Float) starTreeDocuments[i].metrics[1]);
        );
        docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
            .build(new Mapper.BuilderContext(settings, new ContentPath()));
        );
            Set.of(numberFieldMapper1, numberFieldMapper2, numberFieldMapper3, numberFieldMapper4, numberFieldMapper5),
                new HalfFloatPoint("hf7", 6),
        StarTreeMetadata starTreeMetadata = new StarTreeMetadata(
        docValuesConsumer.close();
            new Long[] { 2L, 4L, 3L, 4L },
            getStarTreeDimensionNames(compositeField.getDimensionsOrder()),
            330
        Map<Integer, Map<Long, Double>> expectedDimToValueMap = new HashMap<>();
                new Long[] { metric1, metric2, metric3, metric4, metric5, null }
        assertStarTreeDocuments(resultStarTreeDocuments, expectedStarTreeDocumentIterator);
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
            builder.numStarTreeNodes,
            "test_segment",
            new Object[] { 11.0F, 16.0F, randomFloat(), 8.0F, 13.0F, null }
            metricsIterators2
            .build(new Mapper.BuilderContext(settings, new ContentPath()));
        compositeField = new StarTreeField("test", dimensionsOrder, metrics, new StarTreeFieldConfiguration(1, Set.of(), getBuildMode()));
            new NumericDimension("fieldL")
            getBuildMode(),
        dataOut.close();
        dataOut.close();
        for (int i = 0; i < noOfStarTreeDocuments; i++) {
            long metric1 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments2[i].metrics[0]);
        );
            dimensionsOrder,
            fieldsInfo[i] = new FieldInfo(
        );
            long metric3 = (Long) starTreeDocuments[i].metrics[2];
            Collections.emptyList(),
        DocumentMapper documentMapper = mock(DocumentMapper.class);
        StarTreeDocument[] segmentStarTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
        InMemoryTreeNode rootNode1 = builder.getRootNode();
            new StarTreeDocument(new Long[] { 3L, null, 21L }, new Object[] { 1000.0, 2L }),
    }
        );
        );
        );
        NumberFieldMapper numberFieldMapper1 = new NumberFieldMapper.Builder("field2", NumberFieldMapper.NumberType.FLOAT, false, true)
            0,
            compositeField.getMetrics(),
            new StarTreeDocument(new Long[] { null, 12L, null }, new Object[] { 800.0, 3L }),
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
        starTreeDocuments[0] = new StarTreeDocument(
            true
            NumberFieldMapper.NumberType.UNSIGNED_LONG,
            null
            long metric1 = (Long) starTreeDocuments[i].metrics[0];
            int dimId = entry.getKey();
        validateStarTreeFileFormats(
            1,
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
            Version.LUCENE_10_1_0,
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
        ).build(new Mapper.BuilderContext(settings, new ContentPath()));
        DocumentMapper documentMapper = mock(DocumentMapper.class);
        StarTreeMetadata starTreeMetadata = new StarTreeMetadata(
            true
        MappingLookup fieldMappers = new MappingLookup(
            27,
            writeState,
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
        List<SequentialDocValuesIterator> metricsIterators = getMetricIterators(segmentStarTreeDocuments);
            .build(new Mapper.BuilderContext(settings, new ContentPath()));
        totalDimensionFields.putAll(starTreeMetadata2.getDimensionFields());
            long metric4 = HalfFloatPoint.halfFloatToSortableShort(
                Collections.emptyMap(),
        when(mapperService.documentMapper()).thenReturn(documentMapper);
            "field10",
            STAR_TREE,
            "field10",
            "test",
            assertEquals(expectedStarTreeDocument.dimensions[0], resultStarTreeDocument.dimensions[0]);
        when(documentMapper.mappers()).thenReturn(fieldMappers);
        starTreeDocuments[1] = new StarTreeDocument(new Long[] { 3L, 4L, 2L, 1L }, new Double[] { 10.0, 6.0, randomDouble(), 12.0, 10.0 });
        );
        mapperService = mock(MapperService.class);
            Set.of(),
            getExpectedStarTreeDocumentIterator().size(),
        );
            segmentStarTreeDocuments[i] = new StarTreeDocument(starTreeDocuments[i].dimensions, new Long[] { metric1, null });
            new Long[] { 9L, 4L, randomLong(), -9223372036854775806L, 12L }
            Collections.emptyList(),
            new Long[] { 2L, 4L, 3L, 4L },
        NumberFieldMapper numberFieldMapper2 = new NumberFieldMapper.Builder("field4", NumberFieldMapper.NumberType.LONG, false, true)
            starTreeMetadata,
        List<StarTreeDocument> resultStarTreeDocuments = builder.getStarTreeDocuments();
            long metric3 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[2]);
            new StarTreeDocument(new Long[] { 1L, 11L, 21L }, new Object[] { 400.0, 1L }),
    }
            .build(new Mapper.BuilderContext(settings, new ContentPath()));
            null
                DocValuesType.SORTED_NUMERIC,
            Collections.emptyList(),
        NumberFieldMapper numberFieldMapper2 = new NumberFieldMapper.Builder("field4", NumberFieldMapper.NumberType.FLOAT, false, true)
        );
import org.apache.lucene.util.NumericUtils;
        Iterator<StarTreeDocument> expectedStarTreeDocumentIterator = expectedStarTreeDocuments().iterator();
            null
        int noOfStarTreeDocuments = 5;
        dimValueMap = new HashMap<>();
        when(documentMapper.mappers()).thenReturn(fieldMappers);
            new StarTreeDocument(new Long[] { 2L, 13L, 21L }, new Object[] { 100.0, 1L }),
            );
        dimValueMap.put(1L, 600.0);
            metricsIterators
            VERSION_CURRENT,
import org.opensearch.index.compositeindex.datacube.MetricStat;
        Iterator<StarTreeDocument> expectedStarTreeDocumentIterator = getExpectedStarTreeDocumentIterator().iterator();
        starTreeDocuments[4] = new StarTreeDocument(
            .build(new Mapper.BuilderContext(settings, new ContentPath()));
            new StarTreeDocument(new Long[] { 1L, null, 22L }, new Object[] { 200.0, 1L }),
            starTreeMetadata,
            new StarTreeDocument(new Long[] { null, null, 21L }, new Object[] { 1500.0, 4L }),
        dataOut.close();
                new Long[] { metric1, metric2, metric3, metric4, metric5, metric6 }
        Settings settings = Settings.builder().put(settings(org.opensearch.Version.CURRENT).build()).build();
                new HalfFloatPoint("field10", 24) }
        Iterator<StarTreeDocument> expectedStarTreeDocumentIterator = getExpectedStarTreeDocumentIterator().iterator();
                new HalfFloatPoint("field10", 13) }
        validateStarTreeFileFormats(
        dataOut.close();
            Collections.emptyList(),
            long metric3 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[2]);
            new Metric("field2", List.of(MetricStat.SUM)),
            "test_segment",
            ),
        DocValuesProducer docValuesProducer = mock(DocValuesProducer.class);
            }
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
            "test",
                ((HalfFloatPoint) starTreeDocuments[i].metrics[3]).numericValue().floatValue()
        starTreeDocuments[0] = new StarTreeDocument(new Long[] { 2L, 4L, 3L, 4L }, new Long[] { 12L, 10L, randomLong(), 8L, 20L });
            .build(new Mapper.BuilderContext(settings, new ContentPath()));
            new Long[] { 2L, 4L, 3L, 4L },
            new StarTreeDocument(new Long[] { 3L, null, null }, new Object[] { 1200.0, 3L }),
package org.opensearch.index.compositeindex.datacube.startree.builder;
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
        StarTreeField compositeField2 = new StarTreeField(
public class StarTreeBuildMetricTests extends StarTreeBuilderTestCase {
        );
        expectedDimToValueMap.put(2, dimValueMap);
        writeState = new SegmentWriteState(InfoStream.getDefault(), segmentInfo.dir, segmentInfo, fieldInfos, null, newIOContext(random()));
        StarTreeMetadata starTreeMetadata = new StarTreeMetadata(
        traverseStarTree(builder.rootNode, dimValueToDocIdMap, true);
            writeState,
            2,
        assertEquals(7, resultStarTreeDocuments.size());
                0,
        List<Dimension> dimensionsOrder1 = List.of(
        for (int i = 0; i < noOfStarTreeDocuments; i++) {
        );
            new Object[] { 9.0F, 4.0F, randomFloat(), 9.0F, 12.0F, null }
                VectorEncoding.FLOAT32,
            1,
    }
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
        LinkedHashMap<String, DimensionConfig> fieldsMap = new LinkedHashMap<>();
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
        NumberFieldMapper numberFieldMapper5 = new NumberFieldMapper.Builder(
import org.apache.lucene.sandbox.document.HalfFloatPoint;
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
        }
            builder.numStarTreeNodes,
            .build(new Mapper.BuilderContext(settings, new ContentPath()));
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
        );
                new HalfFloatPoint("field9", 6),
        StarTreeDocument[] starTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
        fieldProducerMap = new HashMap<>();
        Map<Integer, Map<Long, Double>> expectedDimToValueMap = getExpectedDimToValueMap();
            VERSION_CURRENT,
import org.opensearch.index.codec.composite.LuceneDocValuesConsumerFactory;
        MappingLookup fieldMappers = new MappingLookup(
            VERSION_CURRENT,
            long metric2 = HalfFloatPoint.halfFloatToSortableShort(
        );
                0,
            7,
        SegmentReadState readState = getReadState(3, totalDimensionFields, metrics);
    }
        NumberFieldMapper numberFieldMapper4 = new NumberFieldMapper.Builder("field9", NumberFieldMapper.NumberType.LONG, false, true)
    }
        NumberFieldMapper numberFieldMapper2 = new NumberFieldMapper.Builder(
                new HalfFloatPoint("hf10", 16),
            getExpectedStarTreeDocumentIterator().size(),
            false,
            long metric1 = NumericUtils.floatToSortableInt((Float) starTreeDocuments[i].metrics[0]);
    }
        metrics.addAll(starTreeMetadata2.getMetrics());
        MappingLookup fieldMappers = new MappingLookup(
        fields = List.of("fieldC", "fieldB", "fieldL", "fieldI");
        dimensionsOrder = List.of(new NumericDimension("fieldC"), new NumericDimension("fieldB"), new NumericDimension("fieldL"));
        fieldsInfo = new FieldInfo[fields.size()];
        }
                0,
        );
            dimensionsOrder1,
        starTreeDocuments[4] = new StarTreeDocument(new Long[] { 3L, 11L, 21L }, new Object[] { 600.0, null });
import org.apache.lucene.index.SegmentReadState;
        DocumentMapper documentMapper = mock(DocumentMapper.class);
            true
        dataOut.close();
        NumberFieldMapper numberFieldMapper4 = new NumberFieldMapper.Builder(
            true
        InMemoryTreeNode rootNode2 = builder.getRootNode();
        );
            NumberFieldMapper.NumberType.UNSIGNED_LONG,
        starTreeDocuments2[4] = new StarTreeDocument(new Long[] { 3L, 11L, 21L }, new Double[] { 600.0 });
            0,
        starTreeDocuments2[5] = new StarTreeDocument(new Long[] { 3L, 12L, 23L }, new Double[] { 200.0 });
                VectorSimilarityFunction.EUCLIDEAN,
            2,
            false,
        docValuesConsumer.close();
        metaOut.close();
import org.opensearch.index.compositeindex.datacube.NumericDimension;
/*
        List<Metric> metrics = new ArrayList<>();
        expectedDimToValueMap.put(1, dimValueMap);
        ).build(new Mapper.BuilderContext(settings, new ContentPath()));
        starTreeDocuments[4] = new StarTreeDocument(new Long[] { 3L, 4L, 2L, 1L }, new Long[] { 11L, 16L, randomLong(), 8L, 13L });
                -1,
            StarTreeDocument expectedStarTreeDocument = expectedStarTreeDocumentIterator.next();
    public void test_build_unsigned_longMetrics() throws IOException {
            .build(new Mapper.BuilderContext(settings, new ContentPath()));
            new StarTreeDocument(new Long[] { null, 12L, 22L }, new Object[] { 200.0, 1L }),
            mock(IndexInput.class),
        Settings settings = Settings.builder().put(settings(org.opensearch.Version.CURRENT).build()).build();
            builder.numStarTreeNodes,
import org.opensearch.index.compositeindex.datacube.DimensionDataType;
        dimValueMap.put(13L, 400.0);
        );
            new StarTreeDocument(new Long[] { 3L, 12L, null }, new Object[] { 600.0, 2L })
        );
                new Metric("field2", List.of(MetricStat.SUM)),
        dimValueMap.put(11L, 1000.0);
            new Object[] { 14.0F, 12.0F, randomFloat(), 6.0F, 24.0F, null }
import org.apache.lucene.index.SegmentInfo;
            "test",
        int noOfStarTreeDocuments2 = 7;
        );
            new HalfFloatPoint[] {
            getExpectedStarTreeDocumentIterator().size(),
            writeState,
            List.of(new Metric("fieldI", List.of(MetricStat.SUM))),
import static org.opensearch.index.compositeindex.datacube.startree.builder.BuilderTestsUtils.traverseStarTree;
            getExpectedStarTreeDocumentIterator().size(),
        );
import org.opensearch.index.codec.composite.composite912.Composite912DocValuesFormat;
        starTreeDocuments[3] = new StarTreeDocument(
            STAR_TREE,
            long metric2 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[1]);
            );
            segmentStarTreeDocuments[i] = new StarTreeDocument(
import org.apache.lucene.codecs.DocValuesConsumer;
        starTreeDocuments[1] = new StarTreeDocument(new Long[] { 1L, 12L, 22L }, new Object[] { 200.0, null });
        StarTreeMetadata starTreeMetadata = new StarTreeMetadata(
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
        Iterator<StarTreeDocument> expectedStarTreeDocumentIterator = getExpectedStarTreeDocumentIterator().iterator();
        dimValueMap.put(21L, 1500.0);
        mapperService = mock(MapperService.class);
        Iterator<StarTreeDocument> resultStarTreeDocumentIterator = resultStarTreeDocuments.iterator();
            Map<Long, Double> map = expectedDimToValueMap.get(dimId);
                false,
            long metric4 = (Long) starTreeDocuments[i].metrics[3];
            long metric2 = (Long) starTreeDocuments[i].metrics[1];
            new Metric("field4", List.of(MetricStat.SUM)),
        MappingLookup fieldMappers = new MappingLookup(
        assertEquals(7, resultStarTreeDocuments.size());
            1,
            Collections.emptyList(),
            Version.LUCENE_10_1_0,
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
        List<Dimension> dimensionsOrder2 = List.of(
        metrics = List.of(
                ((HalfFloatPoint) starTreeDocuments[i].metrics[0]).numericValue().floatValue()
            2,
        dimValueMap = new HashMap<>();
        when(mapperService.documentMapper()).thenReturn(documentMapper);
            VERSION_CURRENT,
        SegmentInfo segmentInfo = new SegmentInfo(
            metricsIterators
            builder.getRootNode(),
                new HalfFloatPoint("field9", 8),
        );
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
            330
        );
            Version.LATEST,
        metaIn.close();
        docValuesConsumer.close();
            );
            segmentStarTreeDocuments[i] = new StarTreeDocument(
            STAR_TREE,
                int docId = dimValueToDocIdEntry.getValue();
            0,
import org.opensearch.index.compositeindex.datacube.startree.node.InMemoryTreeNode;
            fieldProducerMap.put(fields.get(i), docValuesProducer);
                0,
            starTreeMetadata,
            long metric2 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[1]);
            new StarTreeDocument(new Long[] { null, null, 22L }, new Object[] { 200.0, 1L }),
        dataIn.close();
        mapperService = mock(MapperService.class);
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
                new HalfFloatPoint("field6", 10),
        );
                new Metric("field9", List.of(MetricStat.MIN)),
import org.opensearch.common.settings.Settings;
        StarTreeDocument[] starTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
                new Metric("field6", List.of(MetricStat.VALUE_COUNT)),
        starTreeDocuments2[3] = new StarTreeDocument(new Long[] { 2L, 13L, 21L }, new Double[] { 100.0 });
            new HashMap<>(),
            new Long[] { 2L, 4L, 3L, 4L },
        starTreeDocuments[2] = new StarTreeDocument(
        StarTreeMetadata starTreeMetadata2 = new StarTreeMetadata(
        ).build(new Mapper.BuilderContext(settings, new ContentPath()));
            builder.getRootNode(),
        );
        ).build(new Mapper.BuilderContext(settings, new ContentPath()));
            Set.of("field8"),
                DocValuesType.SORTED_NUMERIC,
            0,
        }
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
        List<SequentialDocValuesIterator> metricsIterators = getMetricIterators(segmentStarTreeDocuments);
        }
        starTreeDocuments2[0] = new StarTreeDocument(new Long[] { 1L, 11L, 21L }, new Double[] { 400.0 });
        fieldsMap1.put("fieldL", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
            NumberFieldMapper.NumberType.UNSIGNED_LONG,
            330
                0,
        NumberFieldMapper numberFieldMapper3 = new NumberFieldMapper.Builder("field6", NumberFieldMapper.NumberType.HALF_FLOAT, false, true)
            );
        starTreeDocuments[3] = new StarTreeDocument(
            new StarTreeDocument(new Long[] { null, 13L, null }, new Object[] { 400.0, 2L }),
            getBuildMode(),
        List<SequentialDocValuesIterator> metricsIterators = getMetricIterators(segmentStarTreeDocuments);
        when(documentMapper.mappers()).thenReturn(fieldMappers);
            new Object[] { 10.0F, 6.0F, randomFloat(), 12.0F, 10.0F, null }
        validateStarTreeFileFormats(builder.getRootNode(), 27, starTreeMetadata, expectedStarTreeDocuments());
                fields.get(i),
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;
            new StarTreeDocument(new Long[] { null, 13L, 21L }, new Object[] { 100.0, 1L }),
            long metric5 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[4]);
            metricsIterators
        List<StarTreeDocument> resultStarTreeDocuments = builder.getStarTreeDocuments();
            );
                new HalfFloatPoint("field9", 12),
        LinkedHashMap<String, DimensionConfig> totalDimensionFields = new LinkedHashMap<>(starTreeMetadata.getDimensionFields());
            new Long[] { 3L, 4L, 2L, 1L },
import org.apache.lucene.index.VectorSimilarityFunction;
        assertEquals(7, resultStarTreeDocuments.size());
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
            VERSION_CURRENT,
            new HalfFloatPoint[] {
            segmentStarTreeDocuments[i] = new StarTreeDocument(
import org.apache.lucene.index.FieldInfos;
            fieldsMap,
            new HashMap<>(),
                i,
        fieldsMap.put("field5", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
        NumberFieldMapper numberFieldMapper1 = new NumberFieldMapper.Builder("field2", NumberFieldMapper.NumberType.LONG, false, true)
            assertEquals(expectedStarTreeDocument.metrics[0], ((CompensatedSum) resultStarTreeDocument.metrics[0]).value());
        );
        starTreeDocuments[0] = new StarTreeDocument(new Long[] { 2L, 4L, 3L, 4L }, new Long[] { 12L, 10L, randomLong(), 8L, -1L });
        }
            new StarTreeFieldConfiguration(1, Set.of(), getBuildMode())
            new HalfFloatPoint[] {
        StarTreeDocument[] starTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
            metricsIterators
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
                DocValuesSkipIndexType.RANGE,
            Long metric6 = (Long) starTreeDocuments[i].metrics[5];
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
        starTreeDocuments[0] = new StarTreeDocument(
    }
        );
        StarTreeDocument[] starTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
        dataOut.close();
        docValuesConsumer.close();
            );
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
    public void test_build_floatMetrics() throws IOException {
        );
            1,
            long metric4 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[3]);
            0,
        Iterator<StarTreeDocument> segmentStarTreeDocumentIterator2 = builder.sortAndAggregateSegmentDocuments(
        when(documentMapper.mappers()).thenReturn(fieldMappers);
            builder.numStarTreeNodes,
        fieldsMap1.put("fieldB", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
        starTreeDocuments[5] = new StarTreeDocument(new Long[] { 3L, 12L, 23L }, new Object[] { 200.0, null });
        NumberFieldMapper numberFieldMapper1 = new NumberFieldMapper.Builder("fieldI", NumberFieldMapper.NumberType.DOUBLE, false, true)
                new HalfFloatPoint("field10", 10) }
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeNodeType;
        validateStarTreeFileFormats(
import org.opensearch.index.mapper.NumberFieldMapper;
        starTreeDocuments[4] = new StarTreeDocument(
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
import org.opensearch.index.compositeindex.datacube.startree.fileformats.meta.StarTreeMetadata;
        );
            long metric1 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[0]);
        starTreeDocuments[2] = new StarTreeDocument(new Long[] { 2L, 13L, 23L }, new Object[] { 300.0, null });
            .build(new Mapper.BuilderContext(settings, new ContentPath()));
            Collections.emptyList(),
        builder.build(segmentStarTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
        ).build(new Mapper.BuilderContext(settings, new ContentPath()));
            new Object[] { 10.0, 6.0, randomDouble(), 12.0, 10.0, null }
                false,
        metaOut.close();
            getExpectedStarTreeDocumentIterator()
            Set.of(numberFieldMapper1),
        while (resultStarTreeDocumentIterator.hasNext() && expectedStarTreeDocumentIterator.hasNext()) {
        fieldsMap1.put("fieldC", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
        NumberFieldMapper numberFieldMapper3 = new NumberFieldMapper.Builder(
        );
            new StarTreeDocument(new Long[] { 2L, 13L, 23L }, new Object[] { 300.0, 1L }),
            segmentStarTreeDocuments[i] = new StarTreeDocument(
import org.opensearch.index.mapper.MappingLookup;
            NumberFieldMapper.NumberType.UNSIGNED_LONG,
    public void test_build_starTreeDataset() throws IOException {
            segmentStarTreeDocuments[i] = new StarTreeDocument(
        StarTreeMetadata starTreeMetadata = new StarTreeMetadata(
            null
import org.apache.lucene.index.SegmentWriteState;
                new HalfFloatPoint("hf5", 11),
        NumberFieldMapper numberFieldMapper5 = new NumberFieldMapper.Builder(
            "field6",
                0,
            false,
        for (int i = 0; i < noOfStarTreeDocuments; i++) {
        mapperService = mock(MapperService.class);
            getExpectedStarTreeDocumentIterator().size(),
            long metric5 = HalfFloatPoint.halfFloatToSortableShort(
            new Object[] { 11.0, 16.0, randomDouble(), 8.0, 13.0, null }
            new StarTreeDocument(new Long[] { 3L, 12L, 23L }, new Object[] { 200.0, 1L }),
        }
        dimValueMap.put(2L, 400.0);
            STAR_TREE,
import java.util.Set;
        }
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
        assertStarTreeDocuments(resultStarTreeDocuments, expectedStarTreeDocumentIterator);
            builder.numStarTreeNodes,
            builder.numStarTreeNodes,
        StarTreeDocument[] segmentStarTreeDocuments2 = new StarTreeDocument[noOfStarTreeDocuments2];
        DocumentMapper documentMapper = mock(DocumentMapper.class);
                new Metric("field10", List.of(MetricStat.MAX))
        starTreeDocuments[0] = new StarTreeDocument(
        Iterator<StarTreeDocument> segmentStarTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(
            new Lucene104Codec(),
            "test",
        );
            "field2",
            segmentStarTreeDocuments2[i] = new StarTreeDocument(starTreeDocuments2[i].dimensions, new Long[] { metric1 });
 * The OpenSearch Contributors require contributions made to
        Iterator<StarTreeDocument> segmentStarTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(
        super(buildMode);
            new StarTreeDocument(new Long[] { null, 12L, 21L }, new Object[] { 400.0, 1L }),
            getStarTreeDimensionNames(compositeField.getDimensionsOrder()),
        DocumentMapper documentMapper = mock(DocumentMapper.class);
        }
            new Long[] { 2L, 4L, 3L, 4L },
        );
        StarTreeDocument[] starTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
        metaOut.close();
        SequentialDocValuesIterator[] dimsIterators = getDimensionIterators(segmentStarTreeDocuments);
        );
            builder.getRootNode(),
        starTreeDocuments[0] = new StarTreeDocument(new Long[] { 1L, 11L, 21L }, new Object[] { 400.0, null });
        starTreeDocuments[2] = new StarTreeDocument(
            getExpectedStarTreeDocumentIteratorForUnsignedLong().size(),
        List<StarTreeDocument> resultStarTreeDocuments = builder.getStarTreeDocuments();
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
        LinkedHashMap<String, DimensionConfig> fieldsMap1 = new LinkedHashMap<>();
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
        StarTreeField compositeField1 = new StarTreeField(
                0,
    private static Map<Integer, Map<Long, Double>> getExpectedDimToValueMap() {
            0,
        compositeField = new StarTreeField("test", dimensionsOrder, metrics, new StarTreeFieldConfiguration(1, Set.of(), getBuildMode()));
            new Long[] { 3L, 4L, 2L, 1L },
            getBuildMode(),
            long metric5 = (Long) starTreeDocuments[i].metrics[4];
import org.apache.lucene.index.VectorEncoding;
                0,
                true,
            0,
            writeState,
        starTreeDocuments[4] = new StarTreeDocument(new Long[] { 3L, 4L, 2L, 1L }, new Long[] { 11L, 16L, randomLong(), 8L, 13L });
            metricsIterators
        when(mapperService.documentMapper()).thenReturn(documentMapper);
            directory,
            Collections.emptyList(),
        for (int i = 0; i < noOfStarTreeDocuments; i++) {
        );
        StarTreeDocument[] segmentStarTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
            7,
                new HalfFloatPoint("hf8", 12),
import java.util.Iterator;
                false,
            );
import org.apache.lucene.index.FieldInfo;
            new Metric("field10", List.of(MetricStat.MAX))
            false,
            new Long[] { 3L, 4L, 2L, 1L },
            new HashMap<>(),
                new HalfFloatPoint("hf1", 12),
        for (int i = 0; i < fieldsInfo.length; i++) {
                new HalfFloatPoint("hf9", 4),
        starTreeDocuments[6] = new StarTreeDocument(new Long[] { 3L, 12L, 21L }, new Object[] { 400.0, null });
            getExpectedStarTreeDocumentIterator().size(),
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
            Set.of("field8"),
            new StarTreeFieldConfiguration(1, Set.of(), getBuildMode())
        starTreeDocuments[3] = new StarTreeDocument(new Long[] { 2L, 4L, 3L, 4L }, new Double[] { 9.0, 4.0, randomDouble(), 9.0, 12.0 });
                new HalfFloatPoint("field9", 8),
            1287
        builder.build(segmentStarTreeDocumentIterator2, new AtomicInteger(), mock(DocValuesConsumer.class));
        );
            new StarTreeDocument(new Long[] { null, 12L, 23L }, new Object[] { 200.0, 1L }),
import static org.opensearch.index.compositeindex.datacube.startree.builder.BuilderTestsUtils.getDimensionIterators;
            .build(new Mapper.BuilderContext(settings, new ContentPath()));
        builder = getStarTreeBuilder(metaOut, dataOut, compositeField, writeState, mapperService);
            new Object[] { 12.0, 10.0, randomDouble(), 8.0, 20.0, 1L }
        assertStarTreeDocuments(resultStarTreeDocuments, expectedStarTreeDocumentIterator);
            long metric1 = HalfFloatPoint.halfFloatToSortableShort(
import org.opensearch.index.compositeindex.datacube.startree.fileformats.meta.DimensionConfig;
        starTreeDocuments[3] = new StarTreeDocument(
            long metric5 = NumericUtils.floatToSortableInt((Float) starTreeDocuments[i].metrics[4]);
            starTreeMetadata,
        dimValueMap.put(22L, 200.0);
        Iterator<StarTreeDocument> expectedStarTreeDocumentIterator = getExpectedStarTreeDocumentIterator().iterator();
        starTreeDocuments[1] = new StarTreeDocument(
            assertEquals(expectedStarTreeDocument.dimensions[2], resultStarTreeDocument.dimensions[2]);
        NumberFieldMapper numberFieldMapper5 = new NumberFieldMapper.Builder("field10", NumberFieldMapper.NumberType.LONG, false, true)
import org.apache.lucene.store.IndexInput;
            true
            long metric1 = (Long) starTreeDocuments[i].metrics[0];
        validateStarTreeFileFormats(
    public void test_build() throws IOException {
        metrics.addAll(starTreeMetadata.getMetrics());
            STAR_TREE,
            new StarTreeFieldConfiguration(1, Set.of("field8"), getBuildMode())
        starTreeDocuments[1] = new StarTreeDocument(new Long[] { 3L, 4L, 2L, 1L }, new Long[] { 10L, 6L, randomLong(), 12L, 10L });
            getExpectedStarTreeDocumentIteratorForUnsignedLong()
import java.nio.charset.StandardCharsets;
            false,
            .build(new Mapper.BuilderContext(settings, new ContentPath()));
        for (Map.Entry<Integer, Map<Long, Integer>> entry : dimValueToDocIdMap.entrySet()) {
            VERSION_CURRENT,
        int noOfStarTreeDocuments = 5;
                starTreeDocuments[i].dimensions,
        StarTreeMetadata starTreeMetadata = new StarTreeMetadata(
            Long metric6 = (Long) starTreeDocuments[i].metrics[5];
        int noOfStarTreeDocuments = 5;
            compositeField.getMetrics(),
                starTreeDocuments[i].dimensions,
            new Object[] { 12.0F, 10.0F, randomFloat(), 8.0F, 20.0F, null }
                DocValuesSkipIndexType.RANGE,
        MappingLookup fieldMappers = new MappingLookup(
            for (Map.Entry<Long, Integer> dimValueToDocIdEntry : entry.getValue().entrySet()) {
            long metric5 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[4]);
            getBuildMode(),
                VectorEncoding.FLOAT32,
        fieldsMap.put("field8", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
            Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
    }
            false,
            builder.numStarTreeNodes,
 *
            new StarTreeDocument(new Long[] { 3L, 11L, 21L }, new Object[] { 600.0, 1L }),
                false,
        mapperService = mock(MapperService.class);
        );
            new Long[] { 3L, 4L, 2L, 1L },
            writeState,
        starTreeDocuments2[2] = new StarTreeDocument(new Long[] { 2L, 13L, 23L }, new Double[] { 300.0 });
import org.opensearch.index.mapper.Mapper;
        Settings settings = Settings.builder().put(settings(org.opensearch.Version.CURRENT).build()).build();
            getExpectedStarTreeDocumentIterator().size(),
            true
            new Long[] { 3L, 4L, 2L, 1L },
import static org.opensearch.index.compositeindex.datacube.startree.builder.BuilderTestsUtils.getMetricIterators;
import org.opensearch.index.mapper.ContentPath;
                new HalfFloatPoint("field6", 10),
 * compatible open source license.
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
        Iterator<StarTreeDocument> expectedStarTreeDocumentIterator = getExpectedStarTreeDocumentIteratorForUnsignedLong().iterator();
 */
                new Long[] { metric1, metric2, metric3, metric4, metric5 }
import static org.opensearch.index.compositeindex.datacube.startree.fileformats.StarTreeWriter.VERSION_CURRENT;
        fields = List.of("fieldC", "fieldB", "fieldL", "fieldI");
            new Lucene104Codec(),
import static org.opensearch.index.mapper.CompositeMappedFieldType.CompositeFieldType.STAR_TREE;
import org.opensearch.index.compositeindex.datacube.Metric;
                true,
            new HalfFloatPoint[] {
        when(mapperService.documentMapper()).thenReturn(documentMapper);
            dimensionsOrder2,
        List<StarTreeDocument> resultStarTreeDocuments = builder.getStarTreeDocuments();
            dimsIterators,
            .build(new Mapper.BuilderContext(settings, new ContentPath()));
        List<SequentialDocValuesIterator> metricsIterators = getMetricIterators(segmentStarTreeDocuments);
import static org.mockito.Mockito.mock;
            VERSION_CURRENT,
        metrics = List.of(new Metric("fieldI", List.of(MetricStat.SUM)));
import org.apache.lucene.util.Version;
        starTreeDocuments[2] = new StarTreeDocument(
        );
import org.apache.lucene.codecs.DocValuesProducer;
        }
        validateStarTreeFileFormats(
            Set.of("field8"),
            .build(new Mapper.BuilderContext(settings, new ContentPath()));
            getExpectedStarTreeDocumentIterator().size(),
        fieldsMap.put("field1", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
            Set.of("field8"),
            long metric3 = NumericUtils.floatToSortableInt((Float) starTreeDocuments[i].metrics[2]);
            Set.of(),
            null
        );
            new StarTreeDocument(new Long[] { 1L, 12L, 22L }, new Object[] { 200.0, 1L }),
                if (map.get(dimValue) != null) {
        for (int i = 0; i < noOfStarTreeDocuments2; i++) {
        starTreeDocuments[0] = new StarTreeDocument(new Long[] { 2L, 4L, 3L, 4L }, new Double[] { 12.0, 10.0, randomDouble(), 8.0, 20.0 });
            assertEquals(expectedStarTreeDocument.metrics[1], resultStarTreeDocument.metrics[1]);
            metrics,
        DocumentMapper documentMapper = mock(DocumentMapper.class);
        Iterator<StarTreeDocument> segmentStarTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(
                false
            new StarTreeDocument(new Long[] { 1L, null, null }, new Object[] { 600.0, 2L }),
                new HalfFloatPoint("field10", 12) }
        assertEquals(7, resultStarTreeDocuments.size());
            "field4",
        int noOfStarTreeDocuments = 7;
            directory,
        starTreeDocuments[2] = new StarTreeDocument(new Long[] { 3L, 4L, 2L, 1L }, new Double[] { 14.0, 12.0, randomDouble(), 6.0, 24.0 });
        }
        fieldsInfo = new FieldInfo[fields.size()];
            new Long[] { 3L, 4L, 2L, 1L },
        NumberFieldMapper numberFieldMapper3 = new NumberFieldMapper.Builder("field6", NumberFieldMapper.NumberType.LONG, false, true)
        starTreeDocuments[1] = new StarTreeDocument(
            dimsIterators,
            getExpectedStarTreeDocumentIterator().size(),
import org.opensearch.index.mapper.DocumentMapper;
        Iterator<StarTreeDocument> segmentStarTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(
        NumberFieldMapper numberFieldMapper1 = new NumberFieldMapper.Builder("fieldI", NumberFieldMapper.NumberType.DOUBLE, false, true)
import java.util.LinkedHashMap;
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
        fieldsMap.put("field3", new DimensionConfig(DocValuesType.SORTED_NUMERIC, DimensionDataType.LONG));
            getBuildMode(),
            .build(new Mapper.BuilderContext(settings, new ContentPath()));
            "test",
            UUID.randomUUID().toString().substring(0, 16).getBytes(StandardCharsets.UTF_8),
            null
            1,
            List.of(
                    assertEquals(map.get(dimValue), ((CompensatedSum) resultStarTreeDocuments.get(docId).metrics[0]).value(), 0);
        List<StarTreeDocument> resultStarTreeDocuments = builder.getStarTreeDocuments();
        Settings settings = Settings.builder().put(settings(org.opensearch.Version.CURRENT).build()).build();
        List<StarTreeDocument> resultStarTreeDocuments = builder.getStarTreeDocuments();
        builder.rootNode.setNodeType(StarTreeNodeType.STAR.getValue());
            );
 * this file be licensed under the Apache-2.0 license or a
            dimsIterators,
    public StarTreeBuildMetricTests(StarTreeFieldConfiguration.StarTreeBuildMode buildMode) {
            "test",
            7,
                IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS,
            long metric4 = NumericUtils.floatToSortableInt((Float) starTreeDocuments[i].metrics[3]);
            StarTreeDocument resultStarTreeDocument = resultStarTreeDocumentIterator.next();
            1287
            getBuildMode(),
                false,
 * SPDX-License-Identifier: Apache-2.0
        List<StarTreeDocument> resultStarTreeDocuments = builder.getStarTreeDocuments();
            new Long[] { 3L, 4L, 2L, 1L },
            compositeField.getMetrics(),
    public void test_build_halfFloatMetrics() throws IOException {
            );
                new Metric("field4", List.of(MetricStat.SUM)),
            getStarTreeDimensionNames(compositeField.getDimensionsOrder()),
            Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
        metaOut.close();
            Collections.emptyList(),
    }
            "test",
        validateStarTree(builder.getRootNode(), 3, 1, builder.getStarTreeDocuments());
            new NumericDimension("field5"),
            Set.of(numberFieldMapper1, numberFieldMapper2, numberFieldMapper3, numberFieldMapper4, numberFieldMapper5),
                long dimValue = dimValueToDocIdEntry.getKey();
        dataOut.close();
        metrics = List.of(new Metric("fieldI", List.of(MetricStat.SUM)), new Metric("_doc_count", List.of(MetricStat.DOC_COUNT)));
            0,
        for (int i = 0; i < noOfStarTreeDocuments; i++) {
        );
        builder.close();
        SequentialDocValuesIterator[] dimsIterators = getDimensionIterators(segmentStarTreeDocuments);
            new StarTreeDocument(new Long[] { null, null, 23L }, new Object[] { 500.0, 2L }),
import static org.opensearch.index.compositeindex.datacube.startree.builder.BuilderTestsUtils.validateStarTree;
import org.opensearch.index.mapper.MapperService;
            0,
            new NumericDimension("fieldB"),
            330
            getExpectedStarTreeDocumentIterator()
            dimsIterators,
    public void test_build_longMetrics() throws IOException {
    }
    private List<StarTreeDocument> expectedStarTreeDocuments() {
            Set.of(numberFieldMapper1),
        SequentialDocValuesIterator[] dimsIterators = getDimensionIterators(segmentStarTreeDocuments);
                i,
            new StarTreeDocument(new Long[] { null, 13L, 23L }, new Object[] { 300.0, 1L }),
import org.opensearch.search.aggregations.metrics.CompensatedSum;
            metrics,
        StarTreeDocument[] starTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
            getStarTreeDimensionNames(compositeField.getDimensionsOrder()),
                false,
        starTreeDocuments[3] = new StarTreeDocument(new Long[] { 2L, 4L, 3L, 4L }, new Long[] { 9L, 4L, randomLong(), 9L, 12L });
import java.util.HashMap;
            null
            long metric4 = (Long) starTreeDocuments[i].metrics[3];
        );
    public void test_build_multipleStarTrees() throws IOException {
                new Long[] { metric1, metric2, metric3, metric4, metric5, null }
        SegmentInfo segmentInfo = new SegmentInfo(
        SequentialDocValuesIterator[] dimsIterators = getDimensionIterators(segmentStarTreeDocuments);
        validateFileFormats(dataIn, metaIn, rootNode2, starTreeMetadata2, compositeField2);
        builder.build(segmentStarTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
        );
        );
        List<SequentialDocValuesIterator> metricsIterators2 = getMetricIterators(segmentStarTreeDocuments2);
        Settings settings = Settings.builder().put(settings(org.opensearch.Version.CURRENT).build()).build();
        this.docValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
            1,
        Map<Long, Double> dimValueMap = new HashMap<>();
        SequentialDocValuesIterator[] dimsIterators = getDimensionIterators(segmentStarTreeDocuments);
        docValuesConsumer.close();
                starTreeDocuments[i].dimensions,
            starTreeMetadata,
            new Metric("field9", List.of(MetricStat.MIN)),
        assertStarTreeDocuments(resultStarTreeDocuments, expectedStarTreeDocumentIterator);
            2,
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
        writeState = new SegmentWriteState(InfoStream.getDefault(), segmentInfo.dir, segmentInfo, fieldInfos, null, newIOContext(random()));
                new HalfFloatPoint("hf4", 9),
            Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
        assertStarTreeDocuments(resultStarTreeDocuments, expectedStarTreeDocumentIterator);
            compositeField.getMetrics(),
            new Long[] { 3L, 4L, 2L, 1L },
        FieldInfos fieldInfos = new FieldInfos(fieldsInfo);
            compositeField.getMetrics(),
        List<SequentialDocValuesIterator> metricsIterators = getMetricIterators(segmentStarTreeDocuments);
            dimsIterators,
        NumberFieldMapper numberFieldMapper4 = new NumberFieldMapper.Builder("field9", NumberFieldMapper.NumberType.FLOAT, false, true)
        IndexInput metaIn = readState.directory.openInput(metaFileName, IOContext.DEFAULT);
        SequentialDocValuesIterator[] dimsIterators = getDimensionIterators(segmentStarTreeDocuments);
            Set.of("field8"),
        StarTreeDocument[] segmentStarTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
        List<SequentialDocValuesIterator> metricsIterators = getMetricIterators(segmentStarTreeDocuments);
            compositeField.getMetrics(),
        DocValuesProducer docValuesProducer = mock(DocValuesProducer.class);
        starTreeDocuments2[1] = new StarTreeDocument(new Long[] { 1L, 12L, 22L }, new Double[] { 200.0 });
            getExpectedStarTreeDocumentIterator()
            STAR_TREE,
import org.apache.lucene.util.InfoStream;
        metaOut.close();
        );
            Version.LATEST,
        );
            STAR_TREE,
        when(mapperService.documentMapper()).thenReturn(documentMapper);
            );
            getExpectedStarTreeDocumentIterator()
            if (dimId == -1) continue;
import java.util.Map;
        assertEquals(7, resultStarTreeDocuments.size());
import java.util.Collections;
                false
        Iterator<StarTreeDocument> expectedStarTreeDocumentIterator = getExpectedStarTreeDocumentIterator().iterator();
        mapperService = mock(MapperService.class);
                new HalfFloatPoint("hf6", 10),
        starTreeDocuments[3] = new StarTreeDocument(
        for (int i = 0; i < fieldsInfo.length; i++) {
        dimValueMap.put(3L, 1200.0);
        SequentialDocValuesIterator[] dimsIterators2 = getDimensionIterators(segmentStarTreeDocuments2);
        fieldProducerMap = new HashMap<>();
        builder.build(segmentStarTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
        );
            Collections.emptyList(),
            new StarTreeDocument(new Long[] { null, null, null }, new Object[] { 2200.0, 7L }),
        when(documentMapper.mappers()).thenReturn(fieldMappers);
                ((HalfFloatPoint) starTreeDocuments[i].metrics[2]).numericValue().floatValue()
        );
                new HalfFloatPoint("field6", 10),
            false,
import static org.mockito.Mockito.when;
        starTreeDocuments[4] = new StarTreeDocument(
            new Long[] { 2L, 4L, 3L, 4L },
            VERSION_CURRENT,
            1,
                starTreeDocuments[i].dimensions,
import static org.opensearch.index.compositeindex.datacube.startree.StarTreeTestUtils.validateFileFormats;
            new StarTreeDocument(new Long[] { null, 11L, 21L }, new Object[] { 1000.0, 2L }),
        when(documentMapper.mappers()).thenReturn(fieldMappers);
        dimensionsOrder = List.of(new NumericDimension("fieldC"), new NumericDimension("fieldB"), new NumericDimension("fieldL"));
        compositeField = new StarTreeField(
            "test",
                new HalfFloatPoint("field6", 10),
            new StarTreeDocument(new Long[] { 1L, null, 21L }, new Object[] { 400.0, 1L }),
        Map<Integer, Map<Long, Integer>> dimValueToDocIdMap = new HashMap<>();
            Set.of("field8"),
            new NumericDimension("field1"),
        metaOut.close();
            getExpectedStarTreeDocumentIterator().size(),
        starTreeDocuments[3] = new StarTreeDocument(new Long[] { 2L, 13L, 21L }, new Object[] { 100.0, null });
            new NumericDimension("field8")
        StarTreeDocument[] segmentStarTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
        return expectedDimToValueMap;
import org.opensearch.index.compositeindex.datacube.startree.StarTreeDocument;
            .build(new Mapper.BuilderContext(settings, new ContentPath()));
            new HashMap<>(),
                -1,
        StarTreeDocument[] segmentStarTreeDocuments = new StarTreeDocument[noOfStarTreeDocuments];
            false,
            long metric4 = NumericUtils.doubleToSortableLong((Double) starTreeDocuments[i].metrics[3]);
            0,
            mock(IndexInput.class),
        builder.build(segmentStarTreeDocumentIterator, new AtomicInteger(), docValuesConsumer);
            assertEquals(expectedStarTreeDocument.dimensions[1], resultStarTreeDocument.dimensions[1]);
            builder.getRootNode(),
            "test",
            segmentStarTreeDocuments[i] = new StarTreeDocument(
                new HalfFloatPoint("field10", 20) }
        dimValueMap.put(23L, 500.0);
            mock(IndexInput.class),
        Iterator<StarTreeDocument> segmentStarTreeDocumentIterator = builder.sortAndAggregateSegmentDocuments(
            new Long[] { 3L, 4L, 2L, 1L },
            writeState,
        NumberFieldMapper numberFieldMapper1 = new NumberFieldMapper.Builder(
            getStarTreeDimensionNames(compositeField.getDimensionsOrder()),
            metricsIterators
            0,
import org.opensearch.index.compositeindex.datacube.startree.utils.SequentialDocValuesIterator;
            .build(new Mapper.BuilderContext(settings, new ContentPath()));
            Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
        int noOfStarTreeDocuments = 5;
            new Long[] { 3L, 4L, 2L, 1L },
            );
                Collections.emptyMap(),
            metrics,
