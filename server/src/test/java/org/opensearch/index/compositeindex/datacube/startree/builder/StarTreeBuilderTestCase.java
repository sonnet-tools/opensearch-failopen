public abstract class StarTreeBuilderTestCase extends OpenSearchTestCase {  
    protected StarTreeField getStarTreeField(MetricStat count) {  
            new StarTreeFieldConfiguration(1, Set.of("field8"), getBuildMode())
import java.util.Set;
                    6.0,
import org.opensearch.index.mapper.MapperService;  
import org.apache.lucene.store.Directory;  
            metrics,
    protected String metaFileName;  
        StarTreeField sf = new StarTreeField("sf", dims, metrics, c);  
                false,  
                new Object[] { 21.0, 14.0, 2L, 8.0, Numbers.unsignedLongToDouble(-1), 2L }
        Dimension d2 = new UnsignedLongDimension("field3");  
    protected List<Metric> metrics;
            rootNode,  
        StarTreeFieldConfiguration c = new StarTreeFieldConfiguration(10, new HashSet<>(), getBuildMode());
            new NumericDimension("field1"),  
import static org.mockito.Mockito.mock;  
        List<DateTimeUnitRounding> intervals = new ArrayList<>();
            builder.close();
        BuilderTestsUtils.validateStarTreeFileFormats(
    protected void assertStarTreeDocuments(
            Collections.emptyList(),
                    Numbers.unsignedLongToDouble(-1),
            assertEquals(expectedStarTreeDocument.dimensions[3], resultStarTreeDocument.dimensions[3]);
                    24.0,
    SegmentWriteState getWriteState(int numDocs, byte[] id) {
            new StarTreeDocument(new Long[] { null, 4L, 2L, 1L }, new Object[] { 35.0, 34.0, 3L, 6.0, 24.0, 3L }),
            writeState.segmentInfo.name,
            new Object[] { StarTreeFieldConfiguration.StarTreeBuildMode.OFF_HEAP }  
        mergeState = new MergeState(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null);  
        when(documentMapper.mappers()).thenReturn(fieldMappers);
            assertEquals(expectedStarTreeDocument.metrics[2], resultStarTreeDocument.metrics[2]);
            .build(new Mapper.BuilderContext(settings, new ContentPath()));  
 */  
    }  
                new Object[] {  
    protected FieldInfo[] fieldsInfo;  
                0,  
                0,
        }
        MappingLookup fieldMappers = new MappingLookup(  
import org.opensearch.index.compositeindex.datacube.IpDimension;  
        List<StarTreeDocument> expectedStarTreeDocuments  
            metaFileName,
            new Metric("field4", List.of(MetricStat.SUM)),
        StarTreeField sf = new StarTreeField("sf", dims, metrics, c);  
        );  
        int numDocs,
        writeState = getWriteState(5, UUID.randomUUID().toString().substring(0, 16).getBytes(StandardCharsets.UTF_8));
        NumberFieldMapper numberFieldMapper1 = new NumberFieldMapper.Builder("field2", NumberFieldMapper.NumberType.DOUBLE, false, true)
        );  
        Metric m1 = new Metric("field2", List.of(count));
    protected IndexOutput dataOut;
 * SPDX-License-Identifier: Apache-2.0
            segmentAggregatedDocCount,
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;
                new Object[] {
import org.opensearch.index.compositeindex.datacube.UnsignedLongDimension;
    }  
import org.apache.lucene.index.IndexFileNames;
                new Object[] {
            new StarTreeDocument(new Long[] { 2L, 4L, 3L, 4L }, new Object[] { 21.0, 14.0, 2L, 8.0, 20.0, 2L }),  
import org.opensearch.index.mapper.Mapper;
                true,
        if (includeDocCountMetric) {
import java.util.Arrays;
    protected List<Dimension> dimensionsOrder;
            assertEquals(expectedStarTreeDocument.metrics[4], resultStarTreeDocument.metrics[4]);  
import org.apache.lucene.index.IndexOptions;  
    ) throws IOException {
            new Metric("field10", List.of(MetricStat.MAX)),
                    28.0 + Numbers.unsignedLongToDouble(-9223372036854775808L),
    }  
package org.opensearch.index.compositeindex.datacube.startree.builder;
        switch (buildMode) {  
            new NumericDimension("field3"),
        }  
import org.opensearch.index.mapper.NumberFieldMapper;
            new StarTreeDocument(new Long[] { null, 4L, null, null }, new Object[] { 56.0, 48.0, 5L, 6.0, 24.0, 5L })  
                    6.0,
        StarTreeFieldConfiguration c = new StarTreeFieldConfiguration(1000, new HashSet<>(), getBuildMode());
        for (Dimension dimension : dimensionsOrder) {
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitRounding;
import org.opensearch.index.compositeindex.datacube.DataCubeDateTimeUnit;  
            new Object[] { StarTreeFieldConfiguration.StarTreeBuildMode.ON_HEAP },
            writeState.segmentInfo.name,  
    protected long getLongFromDouble(double value) {
        fieldProducerMap = new HashMap<>();
        metaFileName = IndexFileNames.segmentFileName(  
            maxLeafDocs,  
            mock(IndexInput.class),
        intervals.add(new DateTimeUnitAdapter(Rounding.DateTimeUnit.HOUR_OF_DAY));
    @ParametersFactory
import org.apache.lucene.store.IndexInput;
        NumberFieldMapper numberFieldMapper5 = new NumberFieldMapper.Builder("field10", NumberFieldMapper.NumberType.DOUBLE, false, true)
            writeState.segmentSuffix,
        intervals.add(DataCubeDateTimeUnit.HALF_HOUR_OF_DAY);
        fieldsInfo = new FieldInfo[fields.size()];  
                VectorEncoding.FLOAT32,  
            new StarTreeDocument(new Long[] { 3L, 4L, 2L, 1L }, new Object[] { 35.0, 34.0, 3L, 6.0, 24.0, 3L }),
import org.opensearch.common.Numbers;
            numDocs,
            ),
        Dimension d2 = new NumericDimension("field3");
            assertEquals(expectedStarTreeDocument.dimensions[2], resultStarTreeDocument.dimensions[2]);  
        List<Metric> metrics = List.of(m1);
    @Before
        List<Dimension> dims = List.of(d1, d2);  
        Dimension d4 = new NumericDimension("field8");  
            StarTreeDocument resultStarTreeDocument = resultStarTreeDocumentIterator.next();
                    20.0 + Numbers.unsignedLongToDouble(-2L),
            dataFileName,
        List<Metric> metrics = List.of(m1);
                Collections.emptyMap(),
            0,
            new StarTreeDocument(new Long[] { 2L, 4L, 3L, 4L }, new Object[] { 21.0, 14.0, 2L, 8.0, Numbers.unsignedLongToDouble(-1), 2L }),  
import java.util.HashMap;
        intervals.add(new DateTimeUnitAdapter(Rounding.DateTimeUnit.MINUTES_OF_HOUR));  
            assertEquals(expectedStarTreeDocument.metrics[1], ((CompensatedSum) resultStarTreeDocument.metrics[1]).value());  
import java.nio.charset.StandardCharsets;
        return Arrays.asList(
            VERSION_CURRENT,  
    protected String dataFileName;
import java.util.HashSet;
    private final StarTreeFieldConfiguration.StarTreeBuildMode buildMode;
            Set.of(numberFieldMapper1, numberFieldMapper2, numberFieldMapper3, numberFieldMapper4, numberFieldMapper5),
import org.apache.lucene.index.SegmentWriteState;  
            null
        Dimension d1 = ip ? new IpDimension("field1") : new OrdinalDimension("field1");  
    }
        int maxLeafDocs,
                new Long[] { null, 4L, null, 1L },
    protected StarTreeField getStarTreeFieldWithDocCount(int maxLeafDocs, boolean includeDocCountMetric) {
        );
    }  
import org.apache.lucene.index.FieldInfo;
import java.io.IOException;
            ),
import org.opensearch.index.mapper.ContentPath;
                    24.0,  
import org.opensearch.index.compositeindex.datacube.MetricStat;
        return BuilderTestsUtils.getReadState(numDocs, dimensionFields, metrics, compositeField, writeState, directory);
        Dimension d3 = new NumericDimension("field5");
        }
        return new StarTreeMetadata(
        metaOut = writeState.directory.createOutput(metaFileName, writeState.context);
    }  
        while (resultStarTreeDocumentIterator.hasNext() && expectedStarTreeDocumentIterator.hasNext()) {  
        Iterator<StarTreeDocument> expectedStarTreeDocumentIterator  
            )  
        Metric m1 = new Metric("field2", List.of(MetricStat.VALUE_COUNT, MetricStat.SUM));
        NumberFieldMapper numberFieldMapper4 = new NumberFieldMapper.Builder("field9", NumberFieldMapper.NumberType.DOUBLE, false, true)
/*  
                    3L }  
    protected StarTreeMetadata getStarTreeMetadata(
import org.apache.lucene.codecs.DocValuesConsumer;  
            new Metric("field9", List.of(MetricStat.MIN)),  
        directory = newFSDirectory(createTempDir());
            new NumericDimension("field8")  
            new Metric("field2", List.of(MetricStat.SUM)),  
        return sf;
import java.util.ArrayList;  
        );
            compositeField.getMetrics(),  
            assertEquals(expectedStarTreeDocument.dimensions[1], resultStarTreeDocument.dimensions[1]);
            assertEquals(expectedStarTreeDocument.metrics[3], resultStarTreeDocument.metrics[3]);
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.index.MergeState;
        return List.of(
                0,
            Collections.emptyList(),  
            }
            fieldProducerMap.put(fields.get(i), docValuesProducer);
                dimensionNames.put(dimensionName, new DimensionConfig(dimension.getDocValuesType(), dimension.getDimensionDataType()));  
        dataFileName = IndexFileNames.segmentFileName(
        Dimension d2 = new NumericDimension("field3");
                new Long[] { 3L, 4L, 2L, 1L },
        LinkedHashMap<String, DimensionConfig> dimensionNames = new LinkedHashMap<>();  
            new Metric("_doc_count", List.of(MetricStat.DOC_COUNT))
    }
                return new OnHeapStarTreeBuilder(metaOut, dataOut, starTreeField, segmentWriteState, mapperService);
        StarTreeField starTreeField,
import org.apache.lucene.index.SegmentReadState;
        StarTreeField sf = new StarTreeField("sf", dims, metrics, c);  
        Dimension d1 = new NumericDimension("field1");  
        int segmentAggregatedDocCount,
    protected Directory directory;
import org.apache.lucene.index.DocValuesType;  
        return sf;
                    6.0,  
            ),  
import java.util.Collection;
            assertEquals(expectedStarTreeDocument.metrics[0], ((CompensatedSum) resultStarTreeDocument.metrics[0]).value());
            "sf",  
import static org.opensearch.index.compositeindex.datacube.startree.fileformats.StarTreeWriter.VERSION_CURRENT;
        return List.of(
            new StarTreeDocument(
            .build(new Mapper.BuilderContext(settings, new ContentPath()));  
    protected void validateStarTreeFileFormats(
                false  
        );  
                fields.get(i),
    protected BaseStarTreeBuilder builder;
            getBuildMode(),
        docValuesConsumer.close();
import org.opensearch.index.codec.composite.composite912.Composite912DocValuesFormat;
import org.apache.lucene.index.VectorEncoding;
            case ON_HEAP:
                new Long[] { null, 4L, null, 4L },  
    protected BaseStarTreeBuilder getStarTreeBuilder(
        return buildMode;
import org.opensearch.index.compositeindex.datacube.startree.StarTreeFieldConfiguration;
import org.opensearch.common.Rounding;
        dimensionsOrder = List.of(
        }  
            assertEquals(expectedStarTreeDocument.dimensions[0], resultStarTreeDocument.dimensions[0]);
        List<Dimension> dims = List.of(d1, d2);  
            0,  
        InMemoryTreeNode rootNode,  
    protected StarTreeField getStarTreeFieldWithKeywords(boolean ip) {
        docValuesConsumer = mock(DocValuesConsumer.class);
            Composite912DocValuesFormat.META_EXTENSION  
        List<Metric> metrics = List.of(m1);  
        if (builder != null) {
            fields,
            builder.numStarTreeDocs,
        mapperService = mock(MapperService.class);
                DocValuesType.SORTED_NUMERIC,
import org.apache.lucene.index.DocValuesSkipIndexType;
                new Long[] { null, 4L, 3L, 4L },
    public void tearDown() throws Exception {
        );
                    5L }
            );
        SegmentWriteState segmentWriteState,  
}  
            writeState.segmentSuffix,
    public StarTreeBuilderTestCase(StarTreeFieldConfiguration.StarTreeBuildMode buildMode) {
        List<Metric> metrics = m2 == null ? List.of(m1) : List.of(m1, m2);
            new StarTreeDocument(new Long[] { null, 4L, 3L, 4L }, new Object[] { 21.0, 14.0, 2L, 8.0, 20.0, 2L }),  
            dimensionsOrder,  
        Metric m1 = new Metric("field2", List.of(MetricStat.VALUE_COUNT, MetricStat.SUM));
            new StarTreeDocument(  
import org.opensearch.index.mapper.MappingLookup;
        dataOut = writeState.directory.createOutput(dataFileName, writeState.context);
        fields = List.of("field1", "field2", "field3", "field4", "field5", "field6", "field7", "field8", "field9", "field10");  
        StarTreeFieldConfiguration c = new StarTreeFieldConfiguration(maxLeafDocs, new HashSet<>(), getBuildMode());
    public static Collection<Object[]> parameters() {  
        NumberFieldMapper numberFieldMapper3 = new NumberFieldMapper.Builder("field6", NumberFieldMapper.NumberType.DOUBLE, false, true)  
    protected DocValuesConsumer docValuesConsumer;
            builder.numStarTreeNodes,
    protected Map<String, DocValuesProducer> fieldProducerMap;
        dataOut.close();  
    protected SegmentWriteState writeState;  
                -1,  
                    5L,
import java.util.Map;  
                new Long[] { null, 4L, 2L, 1L },  
    }
    protected MergeState mergeState;
                    20.0 + Numbers.unsignedLongToDouble(-2L),
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitAdapter;  
                new Object[] { 21.0, 14.0, 2L, 8.0, Numbers.unsignedLongToDouble(-1), 2L }
            fieldsInfo[i] = new FieldInfo(  
            new NumericDimension("field5"),
    }
import org.opensearch.index.compositeindex.datacube.startree.fileformats.meta.DimensionConfig;  
import org.opensearch.index.compositeindex.CompositeIndexConstants;
import org.apache.lucene.index.VectorSimilarityFunction;
import org.apache.lucene.store.IndexOutput;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
import org.opensearch.index.mapper.DateFieldMapper;  
    }
    }
            expectedStarTreeMetadata,
        int dataLength  
            ),
        );
        Dimension d1 = new DateDimension("field1", intervals, DateFieldMapper.Resolution.MILLISECONDS);  
    protected static List<StarTreeDocument> getExpectedStarTreeDocumentIterator() {
            new Metric("field6", List.of(MetricStat.VALUE_COUNT)),
import org.opensearch.index.compositeindex.datacube.startree.StarTreeDocument;  
            compositeField,
        );  
        List<Dimension> dims = List.of(d1, d2);
    protected LinkedHashMap<String, DimensionConfig> getStarTreeDimensionNames(List<Dimension> dimensionsOrder) {
        return BuilderTestsUtils.getWriteState(numDocs, id, fieldsInfo, directory);  
import static org.opensearch.index.mapper.CompositeMappedFieldType.CompositeFieldType.STAR_TREE;
        List<Metric> metrics = List.of(m1);
            new StarTreeDocument(new Long[] { null, 4L, null, 1L }, new Object[] { 35.0, 34.0, 3L, 6.0, 24.0, 3L }),
            new StarTreeDocument(
import org.opensearch.index.compositeindex.datacube.DateDimension;
        Dimension d1 = new NumericDimension("field1");
        IndexOutput dataOut,
                IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS,  
            directory  
                    24.0,
        );
    protected List<String> fields = List.of();  
        LinkedHashMap<String, DimensionConfig> fields,  
    SegmentReadState getReadState(int numDocs, Map<String, DimensionConfig> dimensionFields, List<Metric> metrics) {  
import org.opensearch.index.compositeindex.datacube.Metric;
            new StarTreeDocument(
import org.apache.lucene.codecs.DocValuesProducer;
        return new StarTreeField("sf", dims, metrics, c);
        StarTreeFieldConfiguration c = new StarTreeFieldConfiguration(10, new HashSet<>(), getBuildMode());
                    28.0 + Numbers.unsignedLongToDouble(-9223372036854775808L),
        List<Dimension> dims = List.of(d1, d2);
            case OFF_HEAP:  
            new StarTreeDocument(  
 *
import org.opensearch.index.compositeindex.datacube.startree.fileformats.meta.StarTreeMetadata;
            builder,  
    @Override
    ) {
    }
        Dimension d1 = new UnsignedLongDimension("field1");
    ) {
    }
        IndexOutput metaOut,  
import java.util.UUID;
    protected IndexOutput metaOut;  
        compositeField = new StarTreeField(
        this.buildMode = buildMode;
        Metric m2 = null;  
                false,
        List<StarTreeDocument> resultStarTreeDocuments,
                    20.0 + Numbers.unsignedLongToDouble(-2L),
    }  
            .build(new Mapper.BuilderContext(settings, new ContentPath()));
            expectedStarTreeDocuments,  
                new Object[] {  
                new Long[] { null, 4L, null, null },
            .build(new Mapper.BuilderContext(settings, new ContentPath()));
    }
                return new OffHeapStarTreeBuilder(metaOut, dataOut, starTreeField, segmentWriteState, mapperService);
        DocValuesProducer docValuesProducer = mock(DocValuesProducer.class);
        for (int i = 0; i < fieldsInfo.length; i++) {
        StarTreeMetadata expectedStarTreeMetadata,
import org.opensearch.search.aggregations.metrics.CompensatedSum;  
        Settings settings = Settings.builder().put(settings(org.opensearch.Version.CURRENT).build()).build();
        metrics = List.of(
import org.opensearch.index.compositeindex.datacube.OrdinalDimension;
    protected StarTreeFieldConfiguration.StarTreeBuildMode getBuildMode() {
                false,
import org.opensearch.index.mapper.DocumentMapper;
        return sf;
        return NumericUtils.doubleToSortableLong(value);
 * The OpenSearch Contributors require contributions made to  
        return new StarTreeField("sf", dims, metrics, c);
                    3L }
            dataLength
            new StarTreeDocument(
            Set.of(),
        }  
            m2 = new Metric("_doc_count", List.of(MetricStat.DOC_COUNT));
    public void setup() throws IOException {
                VectorSimilarityFunction.EUCLIDEAN,
        NumberFieldMapper numberFieldMapper2 = new NumberFieldMapper.Builder("field4", NumberFieldMapper.NumberType.DOUBLE, false, true)
        List<Dimension> dims = List.of(d1, d2, d3, d4);
                    42.0 + Numbers.unsignedLongToDouble(-9223372036854775808L),
            Composite912DocValuesFormat.DATA_EXTENSION
import org.opensearch.common.settings.Settings;  
            writeState,
            "test",
        );
    protected StarTreeField compositeField;
import org.opensearch.test.OpenSearchTestCase;
            default:
    protected static List<StarTreeDocument> getExpectedStarTreeDocumentIteratorForUnsignedLong() {
        return Map.of(CompositeIndexConstants.SEGMENT_DOCS_COUNT, String.valueOf(numSegmentDocs));
                    28.0 + Numbers.unsignedLongToDouble(-9223372036854775808L),  
        directory.close();
            for (String dimensionName : dimension.getSubDimensionNames()) {
    }
                    3L,
        );
        }
import java.util.Iterator;  
        StarTreeFieldConfiguration c = new StarTreeFieldConfiguration(1000, new HashSet<>(), getBuildMode());  
                    3L }  
    }
                throw new IllegalArgumentException("Invalid build mode: " + buildMode);  
        Dimension d2 = ip ? new IpDimension("field3") : new OrdinalDimension("field3");
        metaOut.close();
            STAR_TREE,
            .build(new Mapper.BuilderContext(settings, new ContentPath()));
import java.util.List;
        when(mapperService.documentMapper()).thenReturn(documentMapper);  
        Iterator<StarTreeDocument> resultStarTreeDocumentIterator = resultStarTreeDocuments.iterator();
        Dimension d2 = new NumericDimension("field3");
import static org.mockito.Mockito.when;
            new StarTreeDocument(new Long[] { null, 4L, null, 4L }, new Object[] { 21.0, 14.0, 2L, 8.0, 20.0, 2L }),
            StarTreeDocument expectedStarTreeDocument = expectedStarTreeDocumentIterator.next();
 * compatible open source license.
    protected StarTreeField getStarTreeFieldWithDateDimension() {
            ),
        super.tearDown();  
                DocValuesSkipIndexType.RANGE,
import java.util.Collections;  
                    3L,  
import java.util.LinkedHashMap;
                    3L,  
import org.opensearch.index.compositeindex.datacube.Dimension;
    protected StarTreeField getStarTreeFieldForUnsignedLong(MetricStat count) {
                    46.0 + Numbers.unsignedLongToDouble(-2L),  
        DocumentMapper documentMapper = mock(DocumentMapper.class);
        MapperService mapperService
import org.apache.lucene.util.NumericUtils;  
    }  
    ) throws IOException {
        return dimensionNames;  
import org.opensearch.index.compositeindex.datacube.NumericDimension;  
                i,
import org.opensearch.index.compositeindex.datacube.startree.node.InMemoryTreeNode;
    }  
                    6.0,
    protected Map<String, String> getAttributes(int numSegmentDocs) {
    }
    protected MapperService mapperService;
    }
import org.junit.Before;
        Metric m1 = new Metric("field2", List.of(count));  
                0,
        Metric m1 = new Metric("field2", List.of(MetricStat.SUM));
