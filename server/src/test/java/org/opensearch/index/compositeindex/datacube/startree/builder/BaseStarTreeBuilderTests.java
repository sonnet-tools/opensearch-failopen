            public Long getDimensionValue(int docId, int dimensionId) throws IOException {
        );
                DocValuesSkipIndexType.RANGE,  
        fieldsInfo = new FieldInfo[fields.size()];
                return List.of();  
                DocValuesConsumer starTreeDocValuesConsumer
            @Override
        "field2",
            public void build(
            null
                0,
        StarTreeDocument resultStarTreeDocument = builder.reduceStarTreeDocuments(mergedStarTreeDocument, starTreeDocument2);  
import org.opensearch.index.codec.composite.composite912.Composite912DocValuesFormat;
        assertEquals(resultStarTreeDocument.metrics[0], expectedeMergedStarTreeDocument.metrics[0]);
        );
            Collections.emptyList(),
        );
            new NumericDimension("field1"),  
        metaOut = writeState.directory.createOutput(metaFileName, writeState.context);
        dataOut = writeState.directory.createOutput(dataFileName, writeState.context);
                return null;  
        starTreeField = new StarTreeField(
        Map<String, DocValuesProducer> fieldProducerMap = new HashMap<>();
            new Object[] { compensatedSum(14.0), compensatedSum(14.0) }  
            metrics,
                false,
        StarTreeDocument starTreeDocument2 = new StarTreeDocument(
import org.opensearch.index.compositeindex.datacube.Dimension;
        );  
                0,  
        super.tearDown();
 */  
            new NumericDimension("field8")  
            @Override
        "field10"  
import java.util.List;  
        );
    );
            false,
 *
    private static IndexOutput dataOut;
import org.opensearch.index.mapper.MapperService;  
import static org.mockito.Mockito.mock;  
            new HashMap<>(),
            }  
            UUID.randomUUID().toString().substring(0, 16).getBytes(StandardCharsets.UTF_8),
import org.apache.lucene.store.Directory;
    private static BaseStarTreeBuilder builder;
        "field1",  
    @Override  
            fieldsInfo[i] = new FieldInfo(
            writeState.segmentSuffix,
import org.opensearch.index.compositeindex.datacube.startree.StarTreeDocument;  
            5,  
import org.opensearch.index.compositeindex.datacube.startree.aggregators.MetricAggregatorInfo;  
        );
            @Override
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;
        }
                i,  
        dataOut.close();  
        String metaFileName = IndexFileNames.segmentFileName(  
            new HashMap<>(),  
import java.util.Collections;  
        NumberFieldMapper numberFieldMapper1 = new NumberFieldMapper.Builder("field2", NumberFieldMapper.NumberType.DOUBLE, false, true)
        "field4",  
import org.apache.lucene.util.InfoStream;
import org.apache.lucene.codecs.lucene104.Lucene104Codec;  
        assertEquals(resultStarTreeDocument.metrics[1], expectedeMergedStarTreeDocument.metrics[1]);  
            public void appendStarTreeDocument(StarTreeDocument starTreeDocument) throws IOException {}  
        dimensionsOrder = List.of(
    public static void setup() throws IOException {  
    }  
import org.apache.lucene.codecs.DocValuesProducer;
    private static List<Metric> metrics;
import org.opensearch.index.compositeindex.datacube.Metric;  
        assertEquals(metricAggregatorInfos, expectedMetricAggregatorInfos);
        String dataFileName = IndexFileNames.segmentFileName(
        when(documentMapper.mappers()).thenReturn(fieldMappers);
    }
    @BeforeClass
            public List<StarTreeDocument> getStarTreeDocuments() {
            new NumericDimension("field3"),
        "field3",
            new Long[] { 1L, 3L, 5L, 8L },
public class BaseStarTreeBuilderTests extends OpenSearchTestCase {  
            }
            new Object[] { compensatedSum(10.0), compensatedSum(6.0) }
import java.util.HashMap;
            null
            }
            "test_segment",
                List<StarTreeValues> starTreeValuesSubs,  
            new Long[] { 1L, 3L, 5L, 8L },  
    }
import org.apache.lucene.util.Version;
import org.apache.lucene.index.VectorSimilarityFunction;
 * The OpenSearch Contributors require contributions made to  
            @Override  
    private CompensatedSum compensatedSum(Double val) {
            public StarTreeDocument getStarTreeDocument(int docId) throws IOException {  
    public void test_generateMetricAggregatorInfos() throws IOException {
        FieldInfos fieldInfos = new FieldInfos(fieldsInfo);
        StarTreeDocument expectedeMergedStarTreeDocument = new StarTreeDocument(
            Composite912DocValuesFormat.META_EXTENSION  
        List<MetricAggregatorInfo> metricAggregatorInfos = builder.generateMetricAggregatorInfos(mapperService);  
import org.apache.lucene.index.DocValuesSkipIndexType;
            @Override
        writeState = new SegmentWriteState(InfoStream.getDefault(), segmentInfo.dir, segmentInfo, fieldInfos, null, newIOContext(random()));  
import org.apache.lucene.index.DocValuesType;
            directory,
                fields.get(i),
        DocumentMapper documentMapper = mock(DocumentMapper.class);
import org.opensearch.index.mapper.MappingLookup;
import org.opensearch.common.settings.Settings;  
import org.opensearch.index.compositeindex.datacube.startree.StarTreeFieldConfiguration;
            }
 * this file be licensed under the Apache-2.0 license or a
                DocValuesType.SORTED_NUMERIC,
        DocValuesProducer docValuesProducer = mock(DocValuesProducer.class);
import org.opensearch.test.OpenSearchTestCase;
            Version.LATEST,  
import org.opensearch.index.compositeindex.datacube.NumericDimension;
                false
import org.apache.lucene.index.FieldInfo;  
        MappingLookup fieldMappers = new MappingLookup(  
    private static List<String> fields = List.of(
        );  
            Iterator<StarTreeDocument> mergeStarTrees(List<StarTreeValues> starTreeValues) throws IOException {
        );  
            public Iterator<StarTreeDocument> generateStarTreeDocumentsForStarNode(int startDocId, int endDocId, int dimensionId)
                -1,
package org.opensearch.index.compositeindex.datacube.startree.builder;
import java.util.Map;
            new Lucene104Codec(),  
import java.util.concurrent.atomic.AtomicInteger;
    private static Directory directory;  
                return null;
        metaOut.close();
        directory = newFSDirectory(createTempDir());  
            Version.LUCENE_10_1_0,
        when(mapperService.documentMapper()).thenReturn(documentMapper);  
                return 0L;
            "test",
        builder = new BaseStarTreeBuilder(metaOut, dataOut, starTreeField, writeState, mapperService) {  
import org.opensearch.index.compositeindex.datacube.startree.utils.SequentialDocValuesIterator;
            new Object[] { compensatedSum(4.0), compensatedSum(8.0) }  
        List<MetricAggregatorInfo> expectedMetricAggregatorInfos = List.of(
import org.apache.lucene.index.IndexFileNames;
import org.opensearch.index.mapper.ContentPath;  
            .build(new Mapper.BuilderContext(settings, new ContentPath()));
    private static StarTreeField starTreeField;  
import java.nio.charset.StandardCharsets;
import org.apache.lucene.index.SegmentInfo;
import static org.mockito.Mockito.when;
import org.apache.lucene.index.SegmentWriteState;
            new StarTreeFieldConfiguration(1, Set.of("field8"), StarTreeFieldConfiguration.StarTreeBuildMode.ON_HEAP)
            public Iterator<StarTreeDocument> sortAndAggregateSegmentDocuments(  
            ) throws IOException {  
        mapperService = mock(MapperService.class);
        };
    private static SegmentWriteState writeState;
            0,
        return new CompensatedSum(val, 0);  
import org.opensearch.index.compositeindex.datacube.MetricStat;
                false,
            new MetricAggregatorInfo(MetricStat.SUM, "field4", starTreeField.getName(), NumberFieldMapper.NumberType.DOUBLE)  
            new Long[] { 1L, 3L, 5L, 8L },
                true,  
                List<SequentialDocValuesIterator> metricReaders
import java.util.UUID;  
    private static MapperService mapperService;  
        "field5",
    private static IndexOutput metaOut;  
        StarTreeDocument mergedStarTreeDocument = builder.reduceStarTreeDocuments(null, starTreeDocument1);
            Collections.emptyList(),  
                false,  
        "field7",  
import org.opensearch.index.mapper.Mapper;
import java.io.IOException;
        metrics = List.of(new Metric("field2", List.of(MetricStat.SUM)), new Metric("field4", List.of(MetricStat.SUM)));
import org.opensearch.search.aggregations.metrics.CompensatedSum;  
                0,  
    private static List<Dimension> dimensionsOrder;
import org.junit.BeforeClass;
    public void test_reduceStarTreeDocuments() {  
                return null;
    private static FieldInfo[] fieldsInfo;
import org.apache.lucene.codecs.DocValuesConsumer;
import java.util.Iterator;
            }
        "field8",
                IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS,
                throws IOException {  
            writeState.segmentInfo.name,
            writeState.segmentSuffix,
                0,
            dimensionsOrder,  
        directory.close();
            new NumericDimension("field5"),
        for (int i = 0; i < fieldsInfo.length; i++) {  
/*  
 * compatible open source license.
        Settings settings = Settings.builder().put(settings(org.opensearch.Version.CURRENT).build()).build();
                AtomicInteger fieldNumberAcrossStarTrees,
            @Override
            @Override
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
            Set.of(numberFieldMapper1, numberFieldMapper2),
}
                return null;
import org.apache.lucene.index.IndexOptions;  
import org.opensearch.index.mapper.NumberFieldMapper;
        );
import org.apache.lucene.index.FieldInfos;
        NumberFieldMapper numberFieldMapper2 = new NumberFieldMapper.Builder("field4", NumberFieldMapper.NumberType.DOUBLE, false, true)
            new MetricAggregatorInfo(MetricStat.SUM, "field2", starTreeField.getName(), NumberFieldMapper.NumberType.DOUBLE),
            .build(new Mapper.BuilderContext(settings, new ContentPath()));  
import org.apache.lucene.store.IndexOutput;  
    }  
 * SPDX-License-Identifier: Apache-2.0
            @Override
    }  
        SegmentInfo segmentInfo = new SegmentInfo(
        );
            writeState.segmentInfo.name,  
            false,
            );
            }
                VectorSimilarityFunction.EUCLIDEAN,
import org.opensearch.index.mapper.DocumentMapper;
            ) throws IOException {}  
            fieldProducerMap.put(fields.get(i), docValuesProducer);  
        "field6",
import java.util.Set;
    public void tearDown() throws Exception {
                VectorEncoding.FLOAT32,
        "field9",
        StarTreeDocument starTreeDocument1 = new StarTreeDocument(
import org.apache.lucene.index.VectorEncoding;  
                Collections.emptyMap(),
                SequentialDocValuesIterator[] dimensionReaders,
            Composite912DocValuesFormat.DATA_EXTENSION
