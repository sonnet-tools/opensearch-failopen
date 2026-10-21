        return dimensionNames;
        return sf;
        intervals.add(new DateTimeUnitAdapter(Rounding.DateTimeUnit.MINUTES_OF_HOUR));
        switch (buildMode) {
        Metric m2 = null;
                new Object[] {
                    24.0,
            default:
 * SPDX-License-Identifier: Apache-2.0
                VectorEncoding.FLOAT32,
                    28.0 + Numbers.unsignedLongToDouble(-9223372036854775808L),
            new Metric("field6", List.of(MetricStat.VALUE_COUNT)),
import org.apache.lucene.index.IndexOptions;
        int numDocs,
                    20.0 + Numbers.unsignedLongToDouble(-2L),
                0,
            for (String dimensionName : dimension.getSubDimensionNames()) {
        Dimension d1 = ip ? new IpDimension("field1") : new OrdinalDimension("field1");
            new StarTreeDocument(new Long[] { 2L, 4L, 3L, 4L }, new Object[] { 21.0, 14.0, 2L, 8.0, Numbers.unsignedLongToDouble(-1), 2L }),
            metrics,
        List<Metric> metrics = List.of(m1);
        );
        NumberFieldMapper numberFieldMapper2 = new NumberFieldMapper.Builder("field4", NumberFieldMapper.NumberType.DOUBLE, false, true)
import java.util.HashSet;
import java.util.UUID;
import org.junit.Before;
        StarTreeField sf = new StarTreeField("sf", dims, metrics, c);
import org.opensearch.index.mapper.DocumentMapper;
    protected IndexOutput dataOut;
import java.util.ArrayList;
            "sf",
        MappingLookup fieldMappers = new MappingLookup(
import org.opensearch.index.mapper.ContentPath;
            ),
            writeState.segmentInfo.name,
            new StarTreeDocument(
        for (int i = 0; i < fieldsInfo.length; i++) {
import org.opensearch.index.compositeindex.datacube.UnsignedLongDimension;
import org.apache.lucene.codecs.DocValuesProducer;
        Dimension d2 = ip ? new IpDimension("field3") : new OrdinalDimension("field3");
    protected MapperService mapperService;
                DocValuesSkipIndexType.RANGE,
import org.apache.lucene.store.IndexOutput;
            new StarTreeDocument(
import org.opensearch.index.mapper.Mapper;
                    3L }
    ) {
import java.util.List;
    protected BaseStarTreeBuilder getStarTreeBuilder(
            compositeField,
package org.opensearch.index.compositeindex.datacube.startree.builder;
        );
            new Metric("field9", List.of(MetricStat.MIN)),
import org.opensearch.index.compositeindex.datacube.NumericDimension;
        StarTreeField sf = new StarTreeField("sf", dims, metrics, c);
    }
            mock(IndexInput.class),
            Collections.emptyList(),
            numDocs,
            case ON_HEAP:
 * The OpenSearch Contributors require contributions made to
            writeState.segmentSuffix,
            new Object[] { StarTreeFieldConfiguration.StarTreeBuildMode.OFF_HEAP }
                new Long[] { null, 4L, 2L, 1L },
import org.opensearch.index.compositeindex.datacube.MetricStat;
        }
import java.util.Arrays;
            ),
                throw new IllegalArgumentException("Invalid build mode: " + buildMode);
                -1,
    protected StarTreeMetadata getStarTreeMetadata(
        );
        LinkedHashMap<String, DimensionConfig> dimensionNames = new LinkedHashMap<>();
import org.opensearch.index.codec.composite.composite912.Composite912DocValuesFormat;
        List<Dimension> dims = List.of(d1, d2);
        Dimension d1 = new UnsignedLongDimension("field1");
    }
                new Long[] { null, 4L, null, 4L },
        directory.close();
        StarTreeFieldConfiguration c = new StarTreeFieldConfiguration(maxLeafDocs, new HashSet<>(), getBuildMode());
import org.opensearch.index.compositeindex.datacube.startree.fileformats.meta.DimensionConfig;
        Iterator<StarTreeDocument> resultStarTreeDocumentIterator = resultStarTreeDocuments.iterator();
            rootNode,
    protected StarTreeField getStarTreeFieldWithDateDimension() {
        List<Dimension> dims = List.of(d1, d2);
            ),
        if (includeDocCountMetric) {
import org.apache.lucene.index.DocValuesType;
    public void setup() throws IOException {
import static org.mockito.Mockito.mock;
import java.util.Map;
                true,
        Metric m1 = new Metric("field2", List.of(count));
        Metric m1 = new Metric("field2", List.of(MetricStat.VALUE_COUNT, MetricStat.SUM));
        );
        compositeField = new StarTreeField(
    }
    protected Map<String, DocValuesProducer> fieldProducerMap;
            new StarTreeDocument(new Long[] { null, 4L, null, 1L }, new Object[] { 35.0, 34.0, 3L, 6.0, 24.0, 3L }),
        StarTreeField starTreeField,
                    6.0,
        return new StarTreeField("sf", dims, metrics, c);
        IndexOutput metaOut,
            new StarTreeDocument(
        return BuilderTestsUtils.getWriteState(numDocs, id, fieldsInfo, directory);
            new Object[] { StarTreeFieldConfiguration.StarTreeBuildMode.ON_HEAP },
        metaOut.close();
import org.apache.lucene.index.SegmentReadState;
    }
        return List.of(
        BuilderTestsUtils.validateStarTreeFileFormats(
import org.opensearch.index.compositeindex.datacube.Metric;
        dataOut = writeState.directory.createOutput(dataFileName, writeState.context);
            assertEquals(expectedStarTreeDocument.metrics[3], resultStarTreeDocument.metrics[3]);
    protected IndexOutput metaOut;
        );
                    28.0 + Numbers.unsignedLongToDouble(-9223372036854775808L),
                new Long[] { null, 4L, 3L, 4L },
    protected StarTreeField compositeField;
            Collections.emptyList(),
                Collections.emptyMap(),
        Metric m1 = new Metric("field2", List.of(MetricStat.SUM));
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            new NumericDimension("field1"),
            assertEquals(expectedStarTreeDocument.metrics[4], resultStarTreeDocument.metrics[4]);
            new StarTreeDocument(new Long[] { null, 4L, null, 4L }, new Object[] { 21.0, 14.0, 2L, 8.0, 20.0, 2L }),
        List<Metric> metrics = List.of(m1);
        );
                fields.get(i),
        Dimension d2 = new UnsignedLongDimension("field3");
            "test",
                0,
        return new StarTreeField("sf", dims, metrics, c);
    protected void validateStarTreeFileFormats(
            dimensionsOrder,
        StarTreeFieldConfiguration c = new StarTreeFieldConfiguration(1000, new HashSet<>(), getBuildMode());
import org.opensearch.index.compositeindex.datacube.startree.StarTreeFieldConfiguration;
    protected void assertStarTreeDocuments(
import org.opensearch.index.mapper.NumberFieldMapper;
                    28.0 + Numbers.unsignedLongToDouble(-9223372036854775808L),
        when(documentMapper.mappers()).thenReturn(fieldMappers);
        writeState = getWriteState(5, UUID.randomUUID().toString().substring(0, 16).getBytes(StandardCharsets.UTF_8));
        NumberFieldMapper numberFieldMapper5 = new NumberFieldMapper.Builder("field10", NumberFieldMapper.NumberType.DOUBLE, false, true)
            StarTreeDocument expectedStarTreeDocument = expectedStarTreeDocumentIterator.next();
    }
            new StarTreeDocument(new Long[] { null, 4L, 3L, 4L }, new Object[] { 21.0, 14.0, 2L, 8.0, 20.0, 2L }),
 *
        return BuilderTestsUtils.getReadState(numDocs, dimensionFields, metrics, compositeField, writeState, directory);
import org.opensearch.index.mapper.DateFieldMapper;
        Dimension d2 = new NumericDimension("field3");
    @ParametersFactory
            Set.of(numberFieldMapper1, numberFieldMapper2, numberFieldMapper3, numberFieldMapper4, numberFieldMapper5),
import org.opensearch.common.settings.Settings;
        Dimension d1 = new DateDimension("field1", intervals, DateFieldMapper.Resolution.MILLISECONDS);
                new Object[] {
            new StarTreeFieldConfiguration(1, Set.of("field8"), getBuildMode())
import java.util.HashMap;
        while (resultStarTreeDocumentIterator.hasNext() && expectedStarTreeDocumentIterator.hasNext()) {
        return sf;
        return sf;
                    3L }
            assertEquals(expectedStarTreeDocument.dimensions[3], resultStarTreeDocument.dimensions[3]);
    protected String metaFileName;
            compositeField.getMetrics(),
            getBuildMode(),
            .build(new Mapper.BuilderContext(settings, new ContentPath()));
import java.nio.charset.StandardCharsets;
        DocumentMapper documentMapper = mock(DocumentMapper.class);
import org.opensearch.index.compositeindex.datacube.DateDimension;
            directory
        StarTreeField sf = new StarTreeField("sf", dims, metrics, c);
        mergeState = new MergeState(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null);
        DocValuesProducer docValuesProducer = mock(DocValuesProducer.class);
        );
                    5L }
                    46.0 + Numbers.unsignedLongToDouble(-2L),
import static org.opensearch.index.compositeindex.datacube.startree.fileformats.StarTreeWriter.VERSION_CURRENT;
        SegmentWriteState segmentWriteState,
            assertEquals(expectedStarTreeDocument.dimensions[0], resultStarTreeDocument.dimensions[0]);
            metaFileName,
        for (Dimension dimension : dimensionsOrder) {
            .build(new Mapper.BuilderContext(settings, new ContentPath()));
            fieldsInfo[i] = new FieldInfo(
    public static Collection<Object[]> parameters() {
                i,
        List<Metric> metrics = m2 == null ? List.of(m1) : List.of(m1, m2);
                DocValuesType.SORTED_NUMERIC,
    }
        fields = List.of("field1", "field2", "field3", "field4", "field5", "field6", "field7", "field8", "field9", "field10");
        NumberFieldMapper numberFieldMapper4 = new NumberFieldMapper.Builder("field9", NumberFieldMapper.NumberType.DOUBLE, false, true)
import org.opensearch.common.Rounding;
    }
        dataOut.close();
import org.opensearch.index.mapper.MappingLookup;
            0,
    protected List<Metric> metrics;
        StarTreeFieldConfiguration c = new StarTreeFieldConfiguration(1000, new HashSet<>(), getBuildMode());
        Dimension d2 = new NumericDimension("field3");
        intervals.add(new DateTimeUnitAdapter(Rounding.DateTimeUnit.HOUR_OF_DAY));
    private final StarTreeFieldConfiguration.StarTreeBuildMode buildMode;
                new Long[] { null, 4L, null, 1L },
                    3L,
            maxLeafDocs,
            Composite912DocValuesFormat.DATA_EXTENSION
        Metric m1 = new Metric("field2", List.of(count));
                new Object[] {
                false,
        );
        List<Dimension> dims = List.of(d1, d2);
import org.opensearch.index.compositeindex.datacube.startree.node.InMemoryTreeNode;
            assertEquals(expectedStarTreeDocument.dimensions[2], resultStarTreeDocument.dimensions[2]);
        return new StarTreeMetadata(
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;
        InMemoryTreeNode rootNode,
    ) throws IOException {
    protected StarTreeField getStarTreeFieldWithDocCount(int maxLeafDocs, boolean includeDocCountMetric) {
            ),
                new Object[] { 21.0, 14.0, 2L, 8.0, Numbers.unsignedLongToDouble(-1), 2L }
        docValuesConsumer = mock(DocValuesConsumer.class);
    }
            m2 = new Metric("_doc_count", List.of(MetricStat.DOC_COUNT));
import org.apache.lucene.index.IndexFileNames;
            STAR_TREE,
        return Map.of(CompositeIndexConstants.SEGMENT_DOCS_COUNT, String.valueOf(numSegmentDocs));
                new Object[] { 21.0, 14.0, 2L, 8.0, Numbers.unsignedLongToDouble(-1), 2L }
import org.opensearch.index.compositeindex.datacube.startree.fileformats.meta.StarTreeMetadata;
        metaOut = writeState.directory.createOutput(metaFileName, writeState.context);
            0,
    protected Map<String, String> getAttributes(int numSegmentDocs) {
        super.tearDown();
            }
            assertEquals(expectedStarTreeDocument.metrics[1], ((CompensatedSum) resultStarTreeDocument.metrics[1]).value());
        }
    }
            assertEquals(expectedStarTreeDocument.metrics[0], ((CompensatedSum) resultStarTreeDocument.metrics[0]).value());
            .build(new Mapper.BuilderContext(settings, new ContentPath()));
    SegmentWriteState getWriteState(int numDocs, byte[] id) {
        Metric m1 = new Metric("field2", List.of(MetricStat.VALUE_COUNT, MetricStat.SUM));
            builder.numStarTreeDocs,
        int maxLeafDocs,
    ) throws IOException {
        return List.of(
import java.util.Set;
import org.apache.lucene.store.IndexInput;
                dimensionNames.put(dimensionName, new DimensionConfig(dimension.getDocValuesType(), dimension.getDimensionDataType()));
        StarTreeFieldConfiguration c = new StarTreeFieldConfiguration(10, new HashSet<>(), getBuildMode());
        when(mapperService.documentMapper()).thenReturn(documentMapper);
    }
    protected DocValuesConsumer docValuesConsumer;
            new Metric("field10", List.of(MetricStat.MAX)),
import static org.mockito.Mockito.when;
import org.opensearch.common.Numbers;
            writeState.segmentInfo.name,
            case OFF_HEAP:
            new Metric("field4", List.of(MetricStat.SUM)),
import org.opensearch.index.compositeindex.datacube.OrdinalDimension;
        return NumericUtils.doubleToSortableLong(value);
import org.opensearch.index.mapper.MapperService;
                    24.0,
        }
import org.apache.lucene.util.NumericUtils;
        List<DateTimeUnitRounding> intervals = new ArrayList<>();
    protected long getLongFromDouble(double value) {
import java.util.Collections;
                    20.0 + Numbers.unsignedLongToDouble(-2L),
import org.apache.lucene.index.MergeState;
            Composite912DocValuesFormat.META_EXTENSION
    public void tearDown() throws Exception {
        NumberFieldMapper numberFieldMapper1 = new NumberFieldMapper.Builder("field2", NumberFieldMapper.NumberType.DOUBLE, false, true)
    protected Directory directory;
                new Long[] { null, 4L, null, null },
        List<Metric> metrics = List.of(m1);
    }
    protected StarTreeField getStarTreeFieldForUnsignedLong(MetricStat count) {
        );
                    42.0 + Numbers.unsignedLongToDouble(-9223372036854775808L),
import org.opensearch.search.aggregations.metrics.CompensatedSum;
    protected BaseStarTreeBuilder builder;
import org.apache.lucene.index.VectorSimilarityFunction;
            new StarTreeDocument(new Long[] { 2L, 4L, 3L, 4L }, new Object[] { 21.0, 14.0, 2L, 8.0, 20.0, 2L }),
        Dimension d3 = new NumericDimension("field5");
                    5L,
        List<Dimension> dims = List.of(d1, d2);
            assertEquals(expectedStarTreeDocument.dimensions[1], resultStarTreeDocument.dimensions[1]);
            dataLength
    }
        StarTreeMetadata expectedStarTreeMetadata,
            expectedStarTreeMetadata,
                    6.0,
        metrics = List.of(
                new Object[] {
            new NumericDimension("field8")
            Set.of(),
    }
            new StarTreeDocument(
    }
import org.opensearch.test.OpenSearchTestCase;
public abstract class StarTreeBuilderTestCase extends OpenSearchTestCase {
            .build(new Mapper.BuilderContext(settings, new ContentPath()));
        List<StarTreeDocument> resultStarTreeDocuments,
 * compatible open source license.
            builder.numStarTreeNodes,
import org.opensearch.index.compositeindex.CompositeIndexConstants;
import org.apache.lucene.index.VectorEncoding;
    protected List<String> fields = List.of();
import org.apache.lucene.codecs.DocValuesConsumer;
                false,
 */
        StarTreeFieldConfiguration c = new StarTreeFieldConfiguration(10, new HashSet<>(), getBuildMode());
    }
        }
        Dimension d1 = new NumericDimension("field1");
                false
            fields,
import java.util.Iterator;
            new Metric("_doc_count", List.of(MetricStat.DOC_COUNT))
 * this file be licensed under the Apache-2.0 license or a
        Settings settings = Settings.builder().put(settings(org.opensearch.Version.CURRENT).build()).build();
    public StarTreeBuilderTestCase(StarTreeFieldConfiguration.StarTreeBuildMode buildMode) {
        dimensionsOrder = List.of(
            segmentAggregatedDocCount,
        if (builder != null) {
            new StarTreeDocument(new Long[] { 3L, 4L, 2L, 1L }, new Object[] { 35.0, 34.0, 3L, 6.0, 24.0, 3L }),
        LinkedHashMap<String, DimensionConfig> fields,
        fieldsInfo = new FieldInfo[fields.size()];
        int segmentAggregatedDocCount,
        List<Dimension> dims = List.of(d1, d2, d3, d4);
        return Arrays.asList(
}
    protected LinkedHashMap<String, DimensionConfig> getStarTreeDimensionNames(List<Dimension> dimensionsOrder) {
                0,
                new Long[] { 3L, 4L, 2L, 1L },
                return new OnHeapStarTreeBuilder(metaOut, dataOut, starTreeField, segmentWriteState, mapperService);
        );
        Dimension d2 = new NumericDimension("field3");
            .build(new Mapper.BuilderContext(settings, new ContentPath()));
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitAdapter;
        dataFileName = IndexFileNames.segmentFileName(
        mapperService = mock(MapperService.class);
                    6.0,
                    3L }
import java.io.IOException;
            new NumericDimension("field3"),
    protected FieldInfo[] fieldsInfo;
    protected MergeState mergeState;
                    20.0 + Numbers.unsignedLongToDouble(-2L),
    }
                return new OffHeapStarTreeBuilder(metaOut, dataOut, starTreeField, segmentWriteState, mapperService);
    }
/*
            ),
import java.util.Collection;
    ) {
            null
            )
            fieldProducerMap.put(fields.get(i), docValuesProducer);
            dataFileName,
                    6.0,
            builder.close();
        return buildMode;
        Dimension d1 = new NumericDimension("field1");
        this.buildMode = buildMode;
                    3L,
        fieldProducerMap = new HashMap<>();
            builder,
        docValuesConsumer.close();
            );
            new NumericDimension("field5"),
        }
import org.apache.lucene.index.SegmentWriteState;
        Dimension d4 = new NumericDimension("field8");
        intervals.add(DataCubeDateTimeUnit.HALF_HOUR_OF_DAY);
    }
            new Metric("field2", List.of(MetricStat.SUM)),
            expectedStarTreeDocuments,
            new StarTreeDocument(
            new StarTreeDocument(new Long[] { null, 4L, null, null }, new Object[] { 56.0, 48.0, 5L, 6.0, 24.0, 5L })
import static org.opensearch.index.mapper.CompositeMappedFieldType.CompositeFieldType.STAR_TREE;
import org.opensearch.index.compositeindex.datacube.IpDimension;
import org.opensearch.index.compositeindex.datacube.Dimension;
        }
import org.opensearch.index.compositeindex.datacube.startree.StarTreeDocument;
        );
    protected StarTreeFieldConfiguration.StarTreeBuildMode getBuildMode() {
        IndexOutput dataOut,
                false,
    protected SegmentWriteState writeState;
        int dataLength
    protected static List<StarTreeDocument> getExpectedStarTreeDocumentIteratorForUnsignedLong() {
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitRounding;
            StarTreeDocument resultStarTreeDocument = resultStarTreeDocumentIterator.next();
            writeState,
    protected StarTreeField getStarTreeField(MetricStat count) {
import org.apache.lucene.index.FieldInfo;
                    Numbers.unsignedLongToDouble(-1),
    protected StarTreeField getStarTreeFieldWithKeywords(boolean ip) {
        List<Metric> metrics = List.of(m1);
    }
import org.apache.lucene.store.Directory;
    @Before
        metaFileName = IndexFileNames.segmentFileName(
import org.apache.lucene.index.DocValuesSkipIndexType;
                    3L,
                IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS,
    }
    protected List<Dimension> dimensionsOrder;
            VERSION_CURRENT,
            new StarTreeDocument(
                0,
        Iterator<StarTreeDocument> expectedStarTreeDocumentIterator
        NumberFieldMapper numberFieldMapper3 = new NumberFieldMapper.Builder("field6", NumberFieldMapper.NumberType.DOUBLE, false, true)
        MapperService mapperService
    protected static List<StarTreeDocument> getExpectedStarTreeDocumentIterator() {
import org.opensearch.index.compositeindex.datacube.DataCubeDateTimeUnit;
            writeState.segmentSuffix,
                    24.0,
        List<StarTreeDocument> expectedStarTreeDocuments
    }
            assertEquals(expectedStarTreeDocument.metrics[2], resultStarTreeDocument.metrics[2]);
    protected String dataFileName;
        directory = newFSDirectory(createTempDir());
    SegmentReadState getReadState(int numDocs, Map<String, DimensionConfig> dimensionFields, List<Metric> metrics) {
import java.util.LinkedHashMap;
    @Override
                VectorSimilarityFunction.EUCLIDEAN,
            new StarTreeDocument(new Long[] { null, 4L, 2L, 1L }, new Object[] { 35.0, 34.0, 3L, 6.0, 24.0, 3L }),
