                DocValuesSkipIndexType.RANGE,
import org.opensearch.search.aggregations.metrics.CompensatedSum;
        );
            new Object[] { compensatedSum(10.0), compensatedSum(6.0) }
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.compositeindex.datacube.startree.aggregators.MetricAggregatorInfo;
            @Override
    }
        NumberFieldMapper numberFieldMapper1 = new NumberFieldMapper.Builder("field2", NumberFieldMapper.NumberType.DOUBLE, false, true)
            .build(new Mapper.BuilderContext(settings, new ContentPath()));
            ) throws IOException {
            );
                AtomicInteger fieldNumberAcrossStarTrees,
            }
 * compatible open source license.
        mapperService = mock(MapperService.class);
                -1,
        writeState = new SegmentWriteState(InfoStream.getDefault(), segmentInfo.dir, segmentInfo, fieldInfos, null, newIOContext(random()));
        NumberFieldMapper numberFieldMapper2 = new NumberFieldMapper.Builder("field4", NumberFieldMapper.NumberType.DOUBLE, false, true)
            0,
        when(mapperService.documentMapper()).thenReturn(documentMapper);
            Composite912DocValuesFormat.DATA_EXTENSION
                List<SequentialDocValuesIterator> metricReaders
            @Override
                return null;
        directory = newFSDirectory(createTempDir());
                IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS,
            metrics,
import org.apache.lucene.util.Version;
import org.junit.BeforeClass;
    private static Directory directory;
            public void build(
import java.util.HashMap;
    private static BaseStarTreeBuilder builder;
import org.apache.lucene.index.SegmentInfo;
        String metaFileName = IndexFileNames.segmentFileName(
            new NumericDimension("field3"),
            writeState.segmentInfo.name,
        );
        );
import org.apache.lucene.util.InfoStream;
            Composite912DocValuesFormat.META_EXTENSION
            }
    private static MapperService mapperService;
    private static StarTreeField starTreeField;
import static org.mockito.Mockito.mock;
        );
        "field8",
import java.util.Collections;
                false,
            fieldProducerMap.put(fields.get(i), docValuesProducer);
import org.opensearch.test.OpenSearchTestCase;
    private static List<Dimension> dimensionsOrder;
            new StarTreeFieldConfiguration(1, Set.of("field8"), StarTreeFieldConfiguration.StarTreeBuildMode.ON_HEAP)
import java.util.Set;
    @Override
    private static FieldInfo[] fieldsInfo;
import org.opensearch.index.compositeindex.datacube.Dimension;
                false,
                0,
 */
        String dataFileName = IndexFileNames.segmentFileName(
            writeState.segmentInfo.name,
            5,
                false,
 * this file be licensed under the Apache-2.0 license or a
            directory,
            .build(new Mapper.BuilderContext(settings, new ContentPath()));
            }
        when(documentMapper.mappers()).thenReturn(fieldMappers);
        dimensionsOrder = List.of(
        "field1",
            Version.LATEST,
    public void test_generateMetricAggregatorInfos() throws IOException {
import org.opensearch.index.codec.composite.composite912.Composite912DocValuesFormat;
package org.opensearch.index.compositeindex.datacube.startree.builder;
        StarTreeDocument mergedStarTreeDocument = builder.reduceStarTreeDocuments(null, starTreeDocument1);
    );
        dataOut.close();
import org.apache.lucene.codecs.DocValuesProducer;
 *
            new Lucene104Codec(),
            }
    private static List<String> fields = List.of(
            Set.of(numberFieldMapper1, numberFieldMapper2),
        SegmentInfo segmentInfo = new SegmentInfo(
import java.util.Map;
        for (int i = 0; i < fieldsInfo.length; i++) {
import org.opensearch.index.mapper.MappingLookup;
        "field5",
                VectorSimilarityFunction.EUCLIDEAN,
import org.opensearch.index.mapper.DocumentMapper;
            public Long getDimensionValue(int docId, int dimensionId) throws IOException {
            null
        metrics = List.of(new Metric("field2", List.of(MetricStat.SUM)), new Metric("field4", List.of(MetricStat.SUM)));
        );
            new HashMap<>(),
        super.tearDown();
            }
                false
        return new CompensatedSum(val, 0);
    }
import org.apache.lucene.index.IndexOptions;
        StarTreeDocument expectedeMergedStarTreeDocument = new StarTreeDocument(
            UUID.randomUUID().toString().substring(0, 16).getBytes(StandardCharsets.UTF_8),
        Map<String, DocValuesProducer> fieldProducerMap = new HashMap<>();
public class BaseStarTreeBuilderTests extends OpenSearchTestCase {
        MappingLookup fieldMappers = new MappingLookup(
        fieldsInfo = new FieldInfo[fields.size()];
        StarTreeDocument resultStarTreeDocument = builder.reduceStarTreeDocuments(mergedStarTreeDocument, starTreeDocument2);
        builder = new BaseStarTreeBuilder(metaOut, dataOut, starTreeField, writeState, mapperService) {
        assertEquals(resultStarTreeDocument.metrics[1], expectedeMergedStarTreeDocument.metrics[1]);
            new NumericDimension("field5"),
import org.apache.lucene.codecs.lucene104.Lucene104Codec;
                return null;
        DocumentMapper documentMapper = mock(DocumentMapper.class);
import java.util.List;
                fields.get(i),
        List<MetricAggregatorInfo> metricAggregatorInfos = builder.generateMetricAggregatorInfos(mapperService);
        Settings settings = Settings.builder().put(settings(org.opensearch.Version.CURRENT).build()).build();
            Collections.emptyList(),
            new HashMap<>(),
 * The OpenSearch Contributors require contributions made to
            @Override
        metaOut = writeState.directory.createOutput(metaFileName, writeState.context);
            }
import org.opensearch.common.settings.Settings;
        StarTreeDocument starTreeDocument1 = new StarTreeDocument(
        List<MetricAggregatorInfo> expectedMetricAggregatorInfos = List.of(
        );
    }
        };
import org.apache.lucene.codecs.DocValuesConsumer;
import org.opensearch.index.mapper.ContentPath;
        metaOut.close();
                DocValuesType.SORTED_NUMERIC,
                throws IOException {
            new NumericDimension("field1"),
            public List<StarTreeDocument> getStarTreeDocuments() {
    private CompensatedSum compensatedSum(Double val) {
import org.opensearch.index.compositeindex.datacube.MetricStat;
                i,
import org.apache.lucene.index.FieldInfos;
            new Long[] { 1L, 3L, 5L, 8L },
            public StarTreeDocument getStarTreeDocument(int docId) throws IOException {
import org.opensearch.index.compositeindex.datacube.startree.StarTreeFieldConfiguration;
            Iterator<StarTreeDocument> mergeStarTrees(List<StarTreeValues> starTreeValues) throws IOException {
            public Iterator<StarTreeDocument> generateStarTreeDocumentsForStarNode(int startDocId, int endDocId, int dimensionId)
                0,
        assertEquals(resultStarTreeDocument.metrics[0], expectedeMergedStarTreeDocument.metrics[0]);
            dimensionsOrder,
                SequentialDocValuesIterator[] dimensionReaders,
            Version.LUCENE_10_1_0,
    @BeforeClass
            @Override
import static org.mockito.Mockito.when;
                0,
    public void test_reduceStarTreeDocuments() {
            @Override
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
        "field9",
import org.opensearch.index.compositeindex.datacube.startree.StarTreeDocument;
                Collections.emptyMap(),
    }
        starTreeField = new StarTreeField(
            null
            new Long[] { 1L, 3L, 5L, 8L },
        "field4",
        );
    public void tearDown() throws Exception {
/*
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
    private static SegmentWriteState writeState;
            new Long[] { 1L, 3L, 5L, 8L },
    private static List<Metric> metrics;
            new Object[] { compensatedSum(4.0), compensatedSum(8.0) }
import org.opensearch.index.mapper.NumberFieldMapper;
        "field6",
import org.apache.lucene.index.FieldInfo;
import org.apache.lucene.index.SegmentWriteState;
        "field2",
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;
            false,
        FieldInfos fieldInfos = new FieldInfos(fieldsInfo);
            @Override
            writeState.segmentSuffix,
        "field10"
                return 0L;
        assertEquals(metricAggregatorInfos, expectedMetricAggregatorInfos);
                return null;
import org.apache.lucene.index.DocValuesType;
                VectorEncoding.FLOAT32,
            ) throws IOException {}
            @Override
                List<StarTreeValues> starTreeValuesSubs,
            writeState.segmentSuffix,
    private static IndexOutput metaOut;
import java.util.UUID;
import org.apache.lucene.index.DocValuesSkipIndexType;
                0,
            public Iterator<StarTreeDocument> sortAndAggregateSegmentDocuments(
import java.io.IOException;
        );
        "field7",
            public void appendStarTreeDocument(StarTreeDocument starTreeDocument) throws IOException {}
                DocValuesConsumer starTreeDocValuesConsumer
    public static void setup() throws IOException {
                return List.of();
import org.opensearch.index.compositeindex.datacube.Metric;
import org.apache.lucene.index.VectorEncoding;
        }
            new Object[] { compensatedSum(14.0), compensatedSum(14.0) }
import java.util.concurrent.atomic.AtomicInteger;
    private static IndexOutput dataOut;
        StarTreeDocument starTreeDocument2 = new StarTreeDocument(
        directory.close();
            new NumericDimension("field8")
            false,
        );
    }
}
        DocValuesProducer docValuesProducer = mock(DocValuesProducer.class);
import org.apache.lucene.store.Directory;
import org.opensearch.index.mapper.Mapper;
            new MetricAggregatorInfo(MetricStat.SUM, "field4", starTreeField.getName(), NumberFieldMapper.NumberType.DOUBLE)
import org.opensearch.index.mapper.MapperService;
import org.apache.lucene.store.IndexOutput;
            @Override
import org.apache.lucene.index.IndexFileNames;
            "test_segment",
            Collections.emptyList(),
        );
        dataOut = writeState.directory.createOutput(dataFileName, writeState.context);
            "test",
            fieldsInfo[i] = new FieldInfo(
import org.opensearch.index.compositeindex.datacube.NumericDimension;
import org.opensearch.index.compositeindex.datacube.startree.utils.SequentialDocValuesIterator;
import org.apache.lucene.index.VectorSimilarityFunction;
        "field3",
                true,
            new MetricAggregatorInfo(MetricStat.SUM, "field2", starTreeField.getName(), NumberFieldMapper.NumberType.DOUBLE),
                return null;
