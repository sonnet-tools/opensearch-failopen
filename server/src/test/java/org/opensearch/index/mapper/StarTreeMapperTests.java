            buildField.accept(b);  
            }
                DataCubeDateTimeUnit.HALF_HOUR_OF_DAY
            b.endObject();  
            );  
    }  
            assertEquals(StarTreeFieldConfiguration.StarTreeBuildMode.OFF_HEAP, starTreeFieldType.getStarTreeConfig().getBuildMode());
import static org.opensearch.index.IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING;  
        MapperParsingException ex = expectThrows(  
    }
                new DateTimeUnitAdapter(Rounding.DateTimeUnit.MINUTES_OF_HOUR),  
            ex.getMessage()  
    public void testValidStarTreeDefaults() throws IOException {
            MapperParsingException.class,
            assertEquals(10000, starTreeFieldType.getStarTreeConfig().maxLeafDocs());
            b.endObject();
            b.endArray();
                .endObject()  
        settings = Settings.builder().put(CompositeIndexSettings.STAR_TREE_INDEX_ENABLED_SETTING.getKey(), false).build();
    public void testMissingMetrics() {  
        d1CalendarIntervals.add(new DateTimeUnitAdapter(Rounding.DateTimeUnit.HOUR_OF_DAY));
                b.endObject();  
    }  
            ex.getMessage()
            b.startObject("@timestamp");  
        assertEquals(
            b.startObject("keyword1");
            b.startObject();  
import org.opensearch.core.common.unit.ByteSizeValue;
                b.endObject();  
            ex.getMessage()  
                new HashSet<>(Arrays.asList("@timestamp", "status")),
            b.endObject();  
            assertEquals("status", starTreeFieldType.getDimensions().get(1).getField());  
            .build();
        );
/*  
    ) throws IOException {
            b.endObject();
            b.endArray();
            b.endObject();  
            b.field("type", "star_tree");  
            mapping = jsonBuilder().startObject()
            .build();
            assertEquals(
            IllegalArgumentException.class,
            assertEquals(StarTreeFieldConfiguration.StarTreeBuildMode.OFF_HEAP, starTreeFieldType.getStarTreeConfig().getBuildMode());
            b.endObject();
                    b.value(getRandom().nextBoolean() ? "day" : "1d");
        );
                b.endObject();  
    }
 */
        assertEquals(field3, field4);
                b.startArray("stats");
    }
                    Settings.builder()  
            MapperParsingException.class,
            if (!missingDim) {
            assertEquals("status", starTreeFieldType.getDimensions().get(1).getField());
            if (!missingDateDim) {
                assertEquals(expectedTimeUnits.get(i).shortName(), dateDim.getSortedCalendarIntervals().get(i).shortName());
            b.endObject();
                b.endObject();  
                }
    }
    public void testDuplicateDimensions() {
            b.startObject("properties");
 *
            b.startObject("size");  
        });
        XContentBuilder finalMapping = getMappingWithDuplicateFields(true, false);  
            "Failed to parse mapping [_doc]: Duplicate metrics [numeric_dv] present as part star tree index field [startree-1]",  
                b.endObject();
    private XContentBuilder getMinMappingWithDateDims(boolean calendarIntervalsExceeded, boolean dateDimsAbsent, boolean additionalDim)
        b.endObject();
                .startObject("startree-1")  
        field2 = new StarTreeField("starTree", dims, metrics, config);
    @Override
            .put(SETTINGS)
            b.startArray("ordered_dimensions");
            assertEquals("size", starTreeFieldType.getMetrics().get(0).getField());  
                .startObject()  
        );
        for (CompositeMappedFieldType type : compositeFieldTypes) {  
public class StarTreeMapperTests extends MapperTestCase {
                assertEquals(expectedTimeUnits.get(i).shortName(), dateDim.getIntervals().get(i).shortName());
            b.field("name", "status");
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
            assertEquals("size", starTreeFieldType.getMetrics().get(0).getField());
            b.field("type", "keyword");
        ReadDimension r2 = new ReadDimension("name");  
        assertEquals(  
        assertEquals(MetricStat.AVG, MetricStat.fromTypeName("avg"));  
        StarTreeField field2 = new StarTreeField("starTree", dims, metrics, config);
        });
        MapperParsingException mapperParsingExceptionex = expectThrows(
            b.field("type", "keyword");
        boolean singleDim,  
            b.field("name", "@timestamp");
            b.startObject();  
        field2 = new StarTreeField("starTree", dims, metrics, config1);
            ex.getMessage()
            b.endArray();
            mapperParsingExceptionex.getMessage()
            b.startArray("ordered_dimensions");
                .endObject();  
            MapperParsingException.class,
            b.endObject();  
    @Override
                .startObject("config")
        NumericDimension n1 = new NumericDimension("numeric");
    }
    }
            b.endArray();  
            b.endObject();  
            () -> createMapperService(getInvalidMapping(false, false, false, true))
        );
        for (CompositeMappedFieldType type : compositeFieldTypes) {
            }
                        .put(SETTINGS)  
        field2 = new StarTreeField("starTree", dims, metrics, config);
    public void testInvalidMetricType() {
            b.startObject("properties");
                if (calendarIntervalsExceeded) {
            b.endObject();
        boolean invalidMetricType  
        assertEquals(4, doc.rootDoc().getFields("size").length);
            b.field("name", dim);  
            b.startArray("metrics");  
            b.startObject("status");
            b.endObject();
            b.startObject("composite");
                b.field("name", "@timestamp");
        return false;
            b.endObject();
        );
                b.startObject();  
                .settings(  
    public void testValidStarTreeDateDims() throws IOException {  
                .numberOfShards(1)  
                .endObject()
                b.value("unsignedLongDimension");  
                b.field("name", "metric_field");  
        }
            fail("Failed to create mapping: " + e.getMessage());
                new DateTimeUnitAdapter(Rounding.DateTimeUnit.MINUTES_OF_HOUR),  
        assertNotEquals(n1, n2);
            b.startObject("startree");
                b.field("name", "keyword1");
            b.startObject();
import org.opensearch.index.compositeindex.datacube.DataCubeDateTimeUnit;
        );
            b.field("type", "star_tree");
                b.startObject();
        Metric metric1 = new Metric("name", m1);  
            b.field("name", "@timestamp");
            assertEquals(StarTreeFieldConfiguration.StarTreeBuildMode.OFF_HEAP, starTreeFieldType.getStarTreeConfig().getBuildMode());
import org.opensearch.common.settings.ClusterSettings;
    }  
            assertTrue(starTreeFieldType.getDimensions().get(1) instanceof NumericDimension);
            b.startObject("keyword1");  
            assertEquals(expectedMetrics, starTreeFieldType.getMetrics().get(0).getMetrics());  
            b.endArray();  
            List<String> expectedDimensionFields = Arrays.asList("@timestamp_minute", "@timestamp_half-hour");  
                b.startObject();
            // Assert COUNT and SUM gets added when AVG is defined
            b.endArray();  
        assertEquals(  
        DateDimension d2 = new DateDimension("name", d1CalendarIntervals, DateFieldMapper.Resolution.MILLISECONDS);  
        })));  
    }
    protected final XContentBuilder fieldMapping(CheckedConsumer<XContentBuilder, IOException> buildField) throws IOException {
                b.startArray("metrics");
        List<Dimension> dims = List.of(d1, n2);  
            );
    protected void writeFieldValue(XContentBuilder builder) throws IOException {}
            assertEquals(expectedMetrics, starTreeFieldType.getMetrics().get(0).getMetrics());
            () -> createMapperService(getMinMappingWith2StarTrees())  
            b.startObject();  
        assertEquals(new ByteSizeValue(256, ByteSizeUnit.MB), INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.get(settings));
        );
                b.field("type", "integer");
            b.field("type", "keyword");
            b.endObject();
            assertEquals("nested.status", starTreeFieldType.getMetrics().get(0).getField());  
                b.startArray("ordered_dimensions");  
                b.field("name", "status");
            }
        assertEquals(
            assertEquals(List.of(MetricStat.DOC_COUNT), metric.getMetrics());
                b.startArray("calendar_intervals");
                b.field("type", "integer");
            )
            // Assert AVG gets added when both of its base metrics is already present
            b.startArray("ordered_dimensions");
            b.endObject();
                b.value("status");
            b.startObject();
        assertParseMinimalWarnings();
        Set<CompositeMappedFieldType> compositeFieldTypes = mapperService.getCompositeFieldTypes();  
        return mapping;
    protected void minimalMapping(XContentBuilder b) throws IOException {  
            containsString("Failed to parse mapping [_doc]: ordered_dimensions is required for star tree field [startree]")
            b.startArray("metrics");
            b.endObject();
                        .put(StarTreeIndexSettings.STAR_TREE_SEARCH_ENABLED_SETTING.getKey(), true)
            b.endObject();
            "star tree index cannot be created, enable it using [indices.composite_index.star_tree.enabled] cluster setting or [index.search.star_tree_index.enabled] index setting",
    }
    protected boolean supportsOrIgnoresBoost() {  
            b.endObject();
    private XContentBuilder getMinMapping(
            b.endObject();
            b.endObject();  
            b.field("type", "integer");
        metric2 = new Metric("name", m2);
            assertEquals("status", starTreeFieldType.getDimensions().get(0).getField());  
        b.field("name", "status");
        Set<CompositeMappedFieldType> compositeFieldTypes = mapperService.getCompositeFieldTypes();  
            b.startObject("status");
            StarTreeFieldConfiguration.StarTreeBuildMode.OFF_HEAP  
                    b.value(getRandom().nextBoolean() ? "hour" : "1h");
                .field("name", "numeric_dv")
        Set<CompositeMappedFieldType> compositeFieldTypes = mapperService.getCompositeFieldTypes();
            b.endArray();
    @Override
    }
            assertTrue(starTreeFieldType.getDimensions().get(0) instanceof DateDimension);
    }  
            b.startObject("ip1");
            b.startArray("metrics");
            "Failed to parse mapping [_doc]: At most [3] calendar intervals are allowed in dimension [@timestamp]",
            b.startObject("metric_field");  
 * SPDX-License-Identifier: Apache-2.0
                b.field("type", "integer");
                b.field("type", "integer");  
            () -> createMapperService(getMinMappingWithDateDims(true, false, false))
    ) throws IOException {
        );
        DocumentMapper mapper = createDocumentMapper(getExpandedMappingWithJustAvg("status", "status"));
            b.startArray("stats");  
            b.startObject();  
                b.endObject();  
            assertEquals(expectedMetrics, starTreeFieldType.getMetrics().get(0).getMetrics());
                starTreeFieldType.getStarTreeConfig().getSkipStarNodeCreationInDims()
            b.endArray();
            b.field("type", "keyword");  
            b.endObject();  
                .endObject()  
            b.field("name", "name.keyword1");
                Rounding.DateTimeUnit.DAY_OF_MONTH,  
            b.endObject();
            b.startArray("metrics");
            assertTrue(starTreeFieldType.getDimensions().get(2) instanceof UnsignedLongDimension);
            b.startObject();  
                finalMapperService,  
            assertEquals("unsignedLongDimension", starTreeFieldType.getDimensions().get(2).getField());  
            b.startObject("metric_field");  
            b.field("type", "integer");  
        Set<CompositeMappedFieldType> compositeFieldTypes = mapperService.getCompositeFieldTypes();
            b.startObject("properties");
        assertEquals(field1, field2);
            b.startObject("keyword1");  
            b.value("sum");  
    }
            "Failed to parse mapping [_doc]: Composite fields cannot have more than [1] fields",  
            assertTrue(starTreeFieldType.getDimensions().get(0) instanceof DateDimension);
        boolean invalidSkipDims,
    }  
                assertEquals(new DateTimeUnitAdapter(expectedTimeUnits.get(i)), dateDim.getIntervals().get(i));  
    public void testEmptyName() {  
            b.endObject();  
                mapperServiceInvalidDim,  
import org.opensearch.index.compositeindex.datacube.NumericDimension;  
            b.endObject();  
            b.endArray();
            );
                b.field("type", "wildcard");  
        try {  
            b.endObject();
        }
                .field("doc_values", true)
            assertEquals("metric_field", starTreeFieldType.getDimensions().get(1).getField());
        });  
            DateDimension dateDim = (DateDimension) starTreeFieldType.getDimensions().get(0);
            {  
            b.field("name", "@timestamp");  
        assertNotEquals(field1, field2);  
    }
        );
            b.endObject();
            MapperParsingException.class,  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            b.startArray("ordered_dimensions");
            b.field("type", "integer");
            b.endObject();
        assertNotEquals(r1, r2);  
}
            b.field("max_leaf_docs", 100);
        return getMinMapping(false, false, false, false, false);
    public void testInvalidDim() {
            b.endObject();  
            List<DateTimeUnitRounding> expectedTimeUnits = Arrays.asList(
        boolean missingDateDim
            assertEquals(10000, starTreeFieldType.getStarTreeConfig().maxLeafDocs());  
            b.field("type", "integer");
            assertEquals(2, starTreeFieldType.getMetrics().size());
            b.endObject();
            Settings.EMPTY  
            b.endObject();
            "Aggregations not supported for the metrics field [metric_field] with field type [integer] as part of star tree field",
        MapperService mapperService = createMapperService(getExpandedMappingWithJustAvg("status", "size"));
        );
        return Settings.builder()  
            b.field("type", "text");
            b.endObject();
    }  
                b.startObject("metric_field");
            () -> CompositeIndexValidator.validate(
            }  
        );
            b.startObject("fields");
import static com.carrotsearch.randomizedtesting.RandomizedTest.getRandom;  
import org.opensearch.index.compositeindex.datacube.startree.StarTreeFieldConfiguration;
            )  
            b.startObject("");  
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> createMapperService(topMapping(b -> {
                finalMapperService.getIndexSettings()
            assertEquals(Collections.emptySet(), starTreeFieldType.getStarTreeConfig().getSkipStarNodeCreationInDims());  
            b.startObject("config");
        return topMapping(b -> {  
            if (!invalidDate) {
            b.field("name", "@timestamp");  
                .startObject("numeric_dv")
                b.field("name", "status");
            b.endObject();
            } else {  
        b.endArray();  
            .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)
            b.endObject();
            b.startObject();  
    }
            b.startObject("keyword1");  
    public void testValidations() throws IOException {
                b.endObject();  
        assertEquals(MetricStat.VALUE_COUNT, MetricStat.fromTypeName("value_count"));
            if (!invalidDimType) {  
        NumericDimension n1 = new NumericDimension("name");  
            b.startObject("@timestamp");  
            b.field("type", "integer");
            b.field("type", "date");
        boolean invalidDocCountMetricType,
            b.field("ignore_above", 512);  
    // Overriding fieldMapping to make it create composite mappings by default.
        return topMapping(b -> {
                        .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)  
        );
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)  
            b.endArray();
                b.value(getRandom().nextBoolean() ? "half-hour" : "30m");
            b.startObject();  
        assertEquals("Invalid metric stat: invalid", ex.getMessage());
            ex.getMessage(),  
        List<DateTimeUnitRounding> d1CalendarIntervals = new ArrayList<>();
import org.opensearch.common.util.FeatureFlags;  
            assertEquals(10000, starTreeFieldType.getStarTreeConfig().maxLeafDocs());  
        return topMapping(b -> {
            }
                new DateTimeUnitAdapter(Rounding.DateTimeUnit.MONTH_OF_YEAR)
        List<Metric> metrics = List.of(metric1);
        dims = List.of(d1, n2);
            b.startObject("config");  
            b.value("month");
            b.endObject();
            assertEquals(Collections.emptySet(), starTreeFieldType.getStarTreeConfig().getSkipStarNodeCreationInDims());
        boolean isEmptyMetrics,
    }  
    }
import org.opensearch.index.compositeindex.datacube.UnsignedLongDimension;
    }
        NumericDimension n2 = new NumericDimension("name1");
                .startArray("ordered_dimensions")  
            b.endObject();
            assertEquals(100, starTreeFieldType.getStarTreeConfig().maxLeafDocs());
        ex = expectThrows(  
            b.endObject();
            b.endArray();
            assertTrue(starTreeFieldType.getDimensions().get(0) instanceof DateDimension);
        Set<CompositeMappedFieldType> compositeFieldTypes = mapperService.getCompositeFieldTypes();
        IndexSettings disabledIndexSettings = new IndexSettings(  
            b.field("type", "unsigned_long");
            b.startObject("keyword2");
            b.endObject();
        boolean invalidDate  
        MapperParsingException ex = expectThrows(
        CompositeIndexSettings enabledCompositeIndexSettings = new CompositeIndexSettings(
        StarTreeFieldConfiguration config1 = new StarTreeFieldConfiguration(  
            .put(INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(512, ByteSizeUnit.MB))  
            b.startObject("config");  
            () -> createMapperService(getMinMapping(false, true, false, false, false))
import org.opensearch.index.compositeindex.datacube.ReadDimension;
import org.opensearch.index.compositeindex.CompositeIndexSettings;
                        .build()  
            b.endArray();
    }
            containsString("Failed to parse mapping [_doc]: metrics section is required for star tree field [startree]")  
import static org.hamcrest.Matchers.containsString;
            b.field("name", "@timestamp");
        MapperService mapperService = createMapperService(getMinMapping());
            () -> createMapperService(getInvalidMapping(true, false, false, false))  
            MapperParsingException.class,
            for (int i = 0; i < expectedTimeUnits.size(); i++) {  
                b.startObject("date_dimension");  
                .endObject()
            b.value("month");
            assertEquals(10000, starTreeFieldType.getStarTreeConfig().maxLeafDocs());
            b.endObject();
            b.value("month");  
    public void testInvalidSkipDim() {
            b.endObject();
            assertEquals(expectedMetrics, starTreeFieldType.getMetrics().get(0).getMetrics());  
            b.startObject("status");  
        MapperParsingException ex = expectThrows(
                .startObject("composite")
        );
import org.opensearch.common.CheckedConsumer;
            b.field("name", "status");  
            () -> CompositeIndexValidator.validate(finalMapperService, enabledCompositeIndexSettings, disabledIndexSettings)
            b.endObject();
    // This way, the parent tests are checking the right behavior for this Mapper.  
        }
            b.endObject();
                .startObject("timestamp")
            .put(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey(), false)
            // Assert AVG gets added when both of its base metrics is already present
package org.opensearch.index.mapper;
        boolean invalidDimType,
            b.startArray("skip_star_node_creation_for_dimensions");  
            b.endObject();
            b.startObject("@timestamp");
                        .put(SETTINGS)
        config1 = new StarTreeFieldConfiguration(100, Set.of("name"), StarTreeFieldConfiguration.StarTreeBuildMode.ON_HEAP);  
                b.value("@timestamp");
            b.endArray();
            b.endObject();
                .field("type", "integer")  
            b.field("name", "status");
            "Aggregations not supported for the dimension field [@timestamp] with field type [date] as part of star tree field",  
        NumericDimension n2 = new NumericDimension("name");
        Settings settings = Settings.builder()
/**
                b.endArray();
        assertThat(
            b.endObject();  
import org.opensearch.cluster.metadata.IndexMetadata;
        b.field("type", "star_tree");
        return topMapping(b -> {
                if (invalidSkipDims) {
        );  
            b.startObject("date_dimension");  
            b.startObject("date_dimension");  
        assertEquals(r1, r2);
        return topMapping(b -> {
            b.endObject();
    public void testValidValueForCompositeIndex() {
        });
        assertEquals(
            }
    }  
            b.endObject();
            () -> createMapperService(getExpandedMappingWithJustAvg("invalid", "size"))
                b.startObject("@timestamp");  
            b.field("type", "integer");  
                b.endObject();
            b.startObject("keyword1");  
        StarTreeFieldConfiguration config = new StarTreeFieldConfiguration(
            b.startArray("calendar_intervals");
            b.value("day");  
            ex.getMessage()  
        assertEquals(metric1, metric2);
            b.startObject("size");  
            );  
            b.startObject("unsignedLongDimension");  
        b.endObject();  
            assertEquals("@timestamp", starTreeFieldType.getDimensions().get(0).getField());
                b.field("type", "date");
            MapperParsingException.class,
        );  
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> MetricStat.fromTypeName("invalid"));
            .build();
                b.startObject();
                assertEquals(expectedTimeUnits.get(i).shortName(), dateDim.getIntervals().get(i).shortName());
            b.field("type", "integer");
            () -> CompositeIndexValidator.validate(
            List<DateTimeUnitRounding> expectedTimeUnits = Arrays.asList(
            if (!missingMetric) {  
    }  
                    b.value("invalid");
            DateDimension dateDim = (DateDimension) starTreeFieldType.getDimensions().get(0);
            b.endObject();
        // 1 intPoint , 1 SNDV field for each value , so 4 in total  
            b.startArray("metrics");  
        b.startObject();
            b.startObject("properties");
            }
            b.startArray("skip_star_node_creation_for_dimensions");
import org.opensearch.index.compositeindex.datacube.startree.StarTreeIndexSettings;
    public void testMissingDateDims() {
                    Settings.builder()
        });
            assertEquals("status", starTreeFieldType.getDimensions().get(1).getField());  
        MapperService mapperServiceInvalid = createMapperService(getInvalidMappingWithDv(false, false, false, true));  
            if (invalidMetricType) {
            b.startObject("status");  
            for (int i = 0; i < expectedTimeUnits.size(); i++) {  
            }
                .endObject()
            b.startObject();
            b.endArray();
            b.startObject("config");  
        );  
            b.endObject();  
            assertEquals("@timestamp", starTreeFieldType.getDimensions().get(0).getField());
            b.startObject();  
        );
import java.io.IOException;  
        StarTreeField field4 = new StarTreeField("starTree", dims1, metrics, config);
            .put(INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), "256mb")  
            assertEquals("nested.status", starTreeFieldType.getDimensions().get(1).getField());  
            b.startObject("@timestamp");  
    public void testDuplicateMetrics() {
            b.startObject();
        MapperParsingException ex = expectThrows(
            Set.of("name"),
            b.field("max_leaf_docs", 100);
            b.endObject();
 * compatible open source license.
    private XContentBuilder getInvalidMapping(boolean singleDim, boolean invalidSkipDims, boolean invalidDimType, boolean invalidMetricType)
    public void testStarTreeField() {  
            b.field("name", "metric_field");
            List<Rounding.DateTimeUnit> expectedTimeUnits = Arrays.asList(
    private XContentBuilder getMinMapping() throws IOException {
            if (invalidParam) {  
        assertEquals(new ByteSizeValue(256, ByteSizeUnit.MB), INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.get(settings));  
            b.field("type", "star_tree");
            IllegalArgumentException.class,
                new HashSet<>(Arrays.asList("@timestamp", "status", "unsignedLongDimension")),
    public void testMetricsWithJustSum() throws IOException {  
            b.startObject("config");
            {
        metrics = List.of(metric1);
            MapperParsingException.class,
            assertEquals(expectedDimensionFields, dateDim.getSubDimensionNames());  
        MapperParsingException ex = expectThrows(
            IllegalArgumentException.class,
                        .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)
        );
            b.endObject();  
import org.opensearch.common.settings.Settings;
            b.endObject();
            assertEquals(  
        MapperParsingException ex = expectThrows(MapperParsingException.class, () -> createMapperService(finalMapping));
            b.startObject("properties");
        assertEquals("Failed to parse mapping [_doc]: unknown dimension field [invalid]", ex.getMessage());  
        List<DateTimeUnitRounding> d1CalendarIntervals = new ArrayList<>();  
                b.value("@timestamp");
    private XContentBuilder getExpandedMappingWithJustAvg(String dim, String metric) throws IOException {
            b.startObject();  
            ex.getMessage()  
            "Failed to parse mapping [_doc]: Duplicate dimension [numeric_dv] present as part star tree index field [startree-1]",  
                b.value("_doc_count");
        );  
        assertThat(ex.getMessage(), containsString("Failed to parse mapping [_doc]: unknown metric field [metric_field]"));
            assertEquals(expectedMetrics, starTreeFieldType.getMetrics().get(0).getMetrics());  
        Settings settings = Settings.builder().put(CompositeIndexSettings.STAR_TREE_INDEX_ENABLED_SETTING.getKey(), true).build();
                        .put(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey(), true)
            b.startObject("@timestamp");  
                enabledCompositeIndexSettings,
        MapperParsingException ex = expectThrows(
        }
            assertEquals(  
            for (int i = 0; i < expectedTimeUnits.size(); i++) {
            b.field("type", "integer");
                b.value("@timestamp");
                b.startObject();
            "Failed to parse mapping [_doc]: [invalid] in skip_star_node_creation_for_dimensions should be part of ordered_dimensions",
            b.endObject();
            b.endObject();
                b.field("type", "integer");
                b.endObject();  
        });
        assertEquals(field1, field2);  
            b.endObject();
            IllegalArgumentException.class,
            b.startObject();
        r2 = new ReadDimension("name1");
            assertEquals("nested.name.keyword2", starTreeFieldType.getDimensions().get(3).getField());
            b.endArray();
                b.endObject();
    public void testValidStarTreeWithNoDateDim() throws IOException {
            b.endObject();
            b.startObject("properties");
        );
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;  
            MapperParsingException.class,
                b.value("status");  
    public void testNoDims() {  
                .endArray()  
        b.startObject();
 * this file be licensed under the Apache-2.0 license or a
            b.startArray("calendar_intervals");
                        .put(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey(), true)
    }  
            assertEquals(3, starTreeFieldType.getMetrics().size());
            b.field("type", "keyword");
        // since index setting is enabled, throws no error  
            b.field("type", "unsigned_long");
            DateDimension dateDim = (DateDimension) starTreeFieldType.getDimensions().get(0);
            b.field("type", "integer");
        );
        List<DateTimeUnitRounding> d2CalendarIntervals = new ArrayList<>();
        assertEquals(MetricStat.SUM, MetricStat.fromTypeName("sum"));
            b.endObject();  
import org.opensearch.index.compositeindex.datacube.DateDimension;
            }
                .startObject("numeric_dv1")  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            MapperParsingException.class,  
            MapperParsingException.class,  
            IndexMetadata.builder("test")
            MapperParsingException.class,  
            b.field("type", "date");
            b.endObject();
        List<MetricStat> m1 = new ArrayList<>();
            b.field("max_leaf_docs", 100);
    public void testInvalidStarTreeDateDims() throws IOException {
            b.field("name", "status");  
            b.startObject("composite");
        b.field("name", "size");
        MapperParsingException ex = expectThrows(MapperParsingException.class, () -> createMapperService(finalMapping));
                b.field("doc_values", "false");
        metrics = List.of(metric1, metric1);  
                .field("name", isDuplicateDim ? "numeric_dv" : "numeric_dv1")  // Duplicate dimension
                b.field("doc_values", "true");
        d2 = new DateDimension("name", d2CalendarIntervals, DateFieldMapper.Resolution.MILLISECONDS);
    }
        assertThat(
        IndexSettings enabledIndexSettings = new IndexSettings(
            b.value("value_count");
        field2 = new StarTreeField("starTree", dims, metrics, config1);
        b.startObject();  
            assertTrue(starTreeFieldType.getDimensions().get(0) instanceof DateDimension);  
    private XContentBuilder getMappingWithDuplicateFields(boolean isDuplicateDim, boolean isDuplicateMetric) {
            b.startObject("date_dimension");  
            StarTreeMapper.StarTreeFieldType starTreeFieldType = (StarTreeMapper.StarTreeFieldType) type;
    public void testValidValueForFlushTresholdSizeWithoutCompositeIndex() {
        assertEquals(List.of(MetricStat.VALUE_COUNT, MetricStat.SUM), MetricStat.AVG.getBaseMetrics());
            settings,  
        DocumentMapper mapper = createDocumentMapper(pluggableSettings, getExpandedMappingWithJustAvg("status", "size"));  
            b.endObject();  
            () -> createMapperService(getMinMapping(false, false, true, false, false))
            );
                b.value(getRandom().nextBoolean() ? "month" : "1M");  
            () -> createMapperService(getInvalidMapping(false, false, true, false, false, false, true))
        );
        ReadDimension r1 = new ReadDimension("name");
                b.endObject();
    protected boolean supportsMeta() {
        );
            assertTrue(starTreeFieldType.getDimensions().get(0) instanceof NumericDimension);
            assertEquals("@timestamp", starTreeFieldType.getDimensions().get(0).getField());  
            b.endObject();  
                .endObject()
        MapperService mapperService = createMapperService(getExpandedMappingWithJustSum("status", "size"));
        List<MetricStat> m1 = new ArrayList<>();  
            b.startArray("ordered_dimensions");
                .field("type", "integer")
            List<MetricStat> expectedMetrics = Arrays.asList(MetricStat.VALUE_COUNT, MetricStat.SUM, MetricStat.AVG);
        b.endObject();
            b.startObject("unsignedLongDimension");  
            if (!isEmptyDims) {
            b.startObject();  
        assertNotEquals(metric1, metric2);  
                .field("type", "star_tree")
    }
            b.endObject();
            b.field("name", dim);  
    }  
        MapperParsingException ex = expectThrows(
        assertEquals("Failed to parse mapping [_doc]: unknown metric field [invalid]", ex.getMessage());
            b.startObject("composite");  
                if (invalidSkipDims) {  
            MapperParsingException.class,  
            b.endArray();
            b.startObject("properties");
                .endObject()
            b.field("type", "star_tree");  
            assertEquals("_doc_count", metric.getField());
                b.startObject();  
            MapperParsingException.class,
            b.startObject("size");
                b.startObject("status");
            b.endObject();
            b.field("name", "status");
 * The OpenSearch Contributors require contributions made to  
            assertEquals(StarTreeFieldConfiguration.StarTreeBuildMode.OFF_HEAP, starTreeFieldType.getStarTreeConfig().getBuildMode());  
        Set<CompositeMappedFieldType> compositeFieldTypes = mapperService.getCompositeFieldTypes();  
            assertEquals("nested.name.keyword1", starTreeFieldType.getDimensions().get(2).getField());
        boolean singleDim,  
            assertEquals("status", starTreeFieldType.getDimensions().get(1).getField());
            b.startObject("keyword1");
            b.endObject();
        MapperParsingException ex = expectThrows(  
                b.field("type", "integer");
            b.field("type", "ip");
import org.opensearch.index.IndexSettings;
                    b.value(getRandom().nextBoolean() ? "second" : "1s");  
        MapperService mapperService = createMapperService(getMinMappingWithDateDims(false, false, false));
            b.startObject();
            b.field("name", "unsignedLongDimension"); // UnsignedLongDimension  
        return topMapping(b -> {  
            Metric metric = starTreeFieldType.getMetrics().get(2);  
            b.endObject();
            "Failed to parse mapping [_doc]: non-numeric field type is associated with star tree metric [startree]",
            b.startObject("composite");  
            b.endObject();
                        .put(StarTreeIndexSettings.STAR_TREE_SEARCH_ENABLED_SETTING.getKey(), false)
                .startObject()
                b.field("doc_values", "false");  
            b.startObject("metric_field");  
                b.field("type", "date");
            StarTreeMapper.StarTreeFieldType starTreeFieldType = (StarTreeMapper.StarTreeFieldType) type;
        );  
            b.startObject("properties");
import java.util.List;
            b.startObject();
            b.startArray("metrics");  
    public void testMissingDims() {
            "Failed to parse mapping [_doc]: Atleast two dimensions are required to build star tree index field [startree]",  
            b.field("type", "integer");
            if (!singleDim) {
            b.endObject();
        assertEquals(d1, d2);
            ex.getMessage()
            b.startArray("ordered_dimensions");
            b.startObject("startree");
    }
            b.startObject("startree");
        d2CalendarIntervals.add(new DateTimeUnitAdapter(Rounding.DateTimeUnit.HOUR_OF_DAY));
            b.endObject();
    }
            b.startObject("config");  
            b.field("type", "keyword");
    protected Settings getIndexSettings() {
            b.endObject();
        ex = expectThrows(
            b.field("type", "integer");
            b.endObject();  
        m1.add(MetricStat.MAX);
        b.endObject();  
        assertEquals("Failed to parse mapping [_doc]: Invalid metric stat: _doc_count", ex.getMessage());  
            "Failed to parse mapping [_doc]: Star tree mapping definition has unsupported parameters:  [invalid : {invalid=invalid}]",
            b.startObject("composite");
            b.field("name", "nested.name.keyword2");
                mapperServiceInvalid,
        return topMapping(b -> {
    }
            b.value("day");  
                    b.value(getRandom().nextBoolean() ? "quarter-hour" : "15m");
    }
    }
                b.startObject();
            b.endObject();
            b.endArray();
        );
import org.opensearch.index.compositeindex.CompositeIndexValidator;  
            b.endObject();
            b.startObject("startree");
            ex.getMessage()  
 */  
            b.endObject();
            b.endArray();
        assertNotEquals(d1, d2);
            .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)
            b.endObject();
            }  
            ex.getMessage()
                        .put(INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(512, ByteSizeUnit.MB))
        List<Dimension> dims1 = List.of(d1, n1, n2, n3);
    public void testReadDimensions() {
            b.endObject();
            b.startObject("startree");
            }
            b.endObject();  
        }  
        );
        } catch (IOException e) {
                        .build()
        MapperParsingException ex = expectThrows(  
            List<DateTimeUnitRounding> expectedTimeUnits = Arrays.asList(
            b.startArray("metrics");
            b.startObject("keyword1");  
                b.field("name", "metric_field");
            b.endObject();
    public void testInvalidDimType() {  
            b.startObject("date_dimension");
            List<MetricStat> expectedMetrics = List.of(MetricStat.SUM, MetricStat.VALUE_COUNT, MetricStat.AVG);  
            b.field("name", "status");
            b.endArray();
    protected void assertExistsQuery(MapperService mapperService) {}  
            () -> createMapperService(getMinMappingWithDateDims(false, true, false))  
            b.field("name", "metric_field");  
            () -> CompositeIndexValidator.validate(  
            b.endObject();
            b.startObject("composite");  
                b.field("name", "status");
        return getInvalidMapping(singleDim, invalidSkipDims, invalidDimType, invalidMetricType, false, false, false);  
            assertEquals(Collections.emptySet(), starTreeFieldType.getStarTreeConfig().getSkipStarNodeCreationInDims());
            b.startObject("keyword1");  
                b.endObject();
        DateDimension d1 = new DateDimension("name", d1CalendarIntervals, DateFieldMapper.Resolution.MILLISECONDS);
            b.endArray();
            b.endArray();
            b.startArray("skip_star_node_creation_for_dimensions");
        );  
        assertThat(ex.getMessage(), containsString("Failed to parse mapping [_doc]: unknown dimension field [status]"));  
            b.endArray();
                    b.value("invalid");
            }
            b.field("type", "integer");
    }  
        );  
    protected void registerParameters(ParameterChecker checker) throws IOException {
            b.field("type", "integer");  
        MapperService mapperService = createMapperService(getExpandedMappingWithSumAndCount("status", "size"));  
        );  
            b.field("type", "keyword");
            b.endObject();  
            b.endObject();  
            b.value("sum");
            b.endObject();
    }
                .endObject()
            .put(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey(), true)
            List<MetricStat> expectedMetrics = List.of(MetricStat.SUM);  
        dims = List.of(d1, n2);
                .startObject()
            b.field("type", "star_tree");
            if (invalidMetricType) {
            assertTrue(starTreeFieldType.getDimensions().get(0) instanceof NumericDimension);  
        for (CompositeMappedFieldType type : compositeFieldTypes) {
            b.endObject();
                b.endArray();
            b.endObject();
            b.endObject();  
            b.endObject();
            }
        });
        );
            b.startObject();
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitAdapter;  
        throws IOException {
                b.field("doc_values", "true");  
        d2 = new DateDimension("name1", d1CalendarIntervals, DateFieldMapper.Resolution.MILLISECONDS);
            ex.getMessage()
            assertEquals("metric_field", starTreeFieldType.getMetrics().get(1).getField());  
        );
            StarTreeMapper.StarTreeFieldType starTreeFieldType = (StarTreeMapper.StarTreeFieldType) type;
    @Override
            } else {  
            b.endObject();
        assertEquals(
            b.endObject();
            assertEquals(StarTreeFieldConfiguration.StarTreeBuildMode.OFF_HEAP, starTreeFieldType.getStarTreeConfig().getBuildMode());
        );
            () -> createMapperService(getMinMapping(false, false, false, false, true))
        MapperService mapperService = createMapperService(getMinMappingWithDateDims(false, true, true));
        m1.add(MetricStat.MAX);
        Metric metric1 = new Metric("name", m1);
            b.endObject();  
        MapperParsingException ex = expectThrows(
    }  
                DataCubeDateTimeUnit.HALF_HOUR_OF_DAY,
import org.opensearch.common.Rounding;  
        boolean invalidParam,
        }
    }
                .endObject()  
        assertEquals(MetricStat.MIN, MetricStat.fromTypeName("min"));
            b.startObject("startree");  
            ex.getMessage()
    public void testInvalidDateDimType() {
            b.endArray();  
            b.startObject();  
            b.endObject();  
        StarTreeField field1 = new StarTreeField("starTree", dims, metrics, config);
            b.field("type", "date");
    }
            b.startObject();  
            b.startObject("status");
        for (CompositeMappedFieldType type : compositeFieldTypes) {  
        }  
            b.startObject();
            b.endObject();
                .field("name", "numeric_dv")
            MapperParsingException.class,
            b.field("type", "date");
            () -> createMapperService(getInvalidMapping(false, true, false, false))
            assertEquals(expectedDimensionFields, dateDim.getSubDimensionNames());
            b.endObject();
            b.startObject("properties");  
            b.endObject();  
            b.field("type", "integer");
                .field("type", "date")  
            b.field("name", "nested.name.keyword1");
            b.startObject("composite");  
                b.value("avg");  
        b.startArray("ordered_dimensions");  
            b.field("name", "status");
            b.endObject();
                b.endArray();
            b.field("name", metric);
            b.startObject("composite");
            .put(INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), "256mb")  
        ex = expectThrows(  
        );
            }
    }
            b.field("type", "integer");
            b.startObject("keyword2");
            b.field("name", "metric_field");  
            }
            if (!singleDim) {  
        assertEquals(
        StarTreeField field3 = new StarTreeField("starTree", dims1, metrics, config);  
        assertEquals(
import static org.opensearch.index.compositeindex.CompositeIndexSettings.COMPOSITE_INDEX_MAX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING;
            b.startObject();
        );
            b.field("name", metric);
            if (invalidDocCountMetricType) {  
        Settings settings = Settings.builder()
            assertEquals("_doc_count", metric.getField());
            IndexMetadata.builder("test")
            Settings.EMPTY
        );
            b.startObject("config");  
            () -> createMapperService(getInvalidMapping(false, false, false, false, false, true, false))
        CompositeIndexValidator.validate(mapperService, disabledCompositeIndexSettings, enabledIndexSettings);
                b.field("type", "date");
            b.startObject("config");
    }
            b.field("ignore_above", 512);  
        assertThat(ex.getCause().getMessage(), containsString("star tree field and cannot be added inside a document"));  
        );
                new DateTimeUnitAdapter(Rounding.DateTimeUnit.MONTH_OF_YEAR)
            b.startObject("@timestamp");
        XContentBuilder finalMapping = getMappingWithDuplicateFields(false, true);  
                b.endObject();
        assertNotEquals(d1, d2);  
            b.field("name", "metric_field");
            if (additionalDim) {  
        field2 = new StarTreeField("starTree", dims, metrics, config1);  
            );
        );
            assertEquals(expectedMetrics, starTreeFieldType.getMetrics().get(1).getMetrics());
        assertNotEquals(field1, field2);
        MapperService finalMapperService = mapperService;  
import org.opensearch.index.compositeindex.datacube.MetricStat;
        MapperParsingException ex = expectThrows(  
            }
    }  
                new DateTimeUnitAdapter(Rounding.DateTimeUnit.WEEK_OF_WEEKYEAR),  
        assertNotEquals(field1, field2);  
        );
        field2 = new StarTreeField("starTree", dims, metrics, config);
        MapperService mapperService = createMapperService(getExpandedMappingWithJustAvg("status", "size"));  
        assertEquals(
import java.util.Set;  
            minimalMapping(b);
            b.endObject();
            StarTreeMapper.StarTreeFieldType starTreeFieldType = (StarTreeMapper.StarTreeFieldType) type;
                .field("doc_values", true)
            assertEquals(3, starTreeFieldType.getDimensions().size());
        assertEquals(
                .settings(
            .put(COMPOSITE_INDEX_MAX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), "512mb")  
            assertEquals("unsignedLongDimension", starTreeFieldType.getDimensions().get(2).getField());
                .numberOfReplicas(0)  
            b.endObject();
                b.startObject("date_dimension");  
            b.endArray();
                        .put(INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(512, ByteSizeUnit.MB))  
        for (CompositeMappedFieldType type : compositeFieldTypes) {  
        DateDimension d1 = new DateDimension("name", d1CalendarIntervals, DateFieldMapper.Resolution.MILLISECONDS);  
            assertEquals("@timestamp", starTreeFieldType.getDimensions().get(0).getField());  
            b.endObject();
            assertEquals(100, starTreeFieldType.getStarTreeConfig().maxLeafDocs());
    private XContentBuilder getMinMappingWithNestedField() throws IOException {
            b.startObject("startree");
            b.endObject();  
        MapperParsingException ex = expectThrows(  
        );
        config1 = new StarTreeFieldConfiguration(100, Set.of("name", "field2"), StarTreeFieldConfiguration.StarTreeBuildMode.OFF_HEAP);
                .build(),
        CompositeIndexSettings disabledCompositeIndexSettings = new CompositeIndexSettings(
                b.field("invalid", "invalid");
            assertEquals(expectedMetrics, starTreeFieldType.getMetrics().get(0).getMetrics());
            assertEquals(100, starTreeFieldType.getStarTreeConfig().maxLeafDocs());
        MapperParsingException ex = expectThrows(
            b.field("name", "nested.status");
            b.startObject("keyword1");  
            b.startArray("ordered_dimensions");
            b.field("type", "date");
            b.endObject();
            } else {
    public void testDimensions() {
    public void testMetric() {
            b.endObject();
            b.startObject("composite");  
            b.field("type", "date");
        assertThat(ex.getMessage(), containsString("Failed to parse mapping [_doc]: unknown date dimension field [@timestamp]"));
            )  
import java.util.Arrays;
        b.startArray("metrics");
        boolean isEmptyDims,  
            b.endObject();
            b.value("day");
            b.endObject();  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            b.endObject();
    }
        );  
            b.startObject();
            () -> createMapperService(getInvalidMapping(false, false, false, false, true, false, false))
            b.field("name", "nested.status");
            b.startObject();  
                starTreeFieldType.getStarTreeConfig().getSkipStarNodeCreationInDims()  
            b.startObject("composite");
        });
                new DateTimeUnitAdapter(Rounding.DateTimeUnit.DAY_OF_MONTH),
                .startObject("properties")
        assertEquals(n1, n2);
            b.startObject("status");  
                Rounding.DateTimeUnit.MONTH_OF_YEAR
    }
                b.field("name", "status");  
    public void testInvalidParam() {
    }  
            b.endArray();
    private XContentBuilder getMinMappingWith2StarTrees() throws IOException {  
            } else {
                .startObject("date_dimension")  
            for (int i = 0; i < expectedTimeUnits.size(); i++) {
            b.startArray("ordered_dimensions");  
        assertEquals(
                    b.value(getRandom().nextBoolean() ? "minute" : "1m");
            b.field("name", "unsignedLongDimension"); // UnsignedLongDimension  
        return topMapping(b -> {  
            List<String> expectedDimensionFields = Arrays.asList("@timestamp_minute", "@timestamp_half-hour");  
                .startObject()  
    private XContentBuilder getInvalidMappingWithDv(
            b.field("name", "@timestamp");
            if (!isEmptyMetrics) {  
            b.endObject();
    public void testInvalidMetric() {  
            .put(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey(), true)
            b.field("name", "status");  
            () -> createMapperService(getMinMapping(true, false, false, false, false))  
            expectedMetrics = Arrays.asList(MetricStat.VALUE_COUNT, MetricStat.SUM, MetricStat.AVG);
            b.field("type", "keyword");
            b.startObject("properties");
        List<MetricStat> m2 = new ArrayList<>();
            b.endObject();  
            MapperParsingException.class,
            () -> mapper.parse(source(b -> b.field("startree", "some_value")), docInput)
            }
        );  
    }  
        MapperParsingException ex = expectThrows(
            b.field("type", "keyword");
import org.opensearch.index.compositeindex.datacube.Metric;
            "Failed to parse mapping [_doc]: Atleast two dimensions are required to build star tree index field [startree]",  
            b.startObject("startree1");
            1000,
            b.endObject();  
            b.startObject("keyword1");
    public void testPluggableDataFormatStarTreeThrows() throws IOException {
            b.endObject();  
            b.endObject();  
    public void testInValidStarTreeMinDims() throws IOException {  
import java.util.HashSet;
            b.startObject();  
            b.startObject("config");  
            assertTrue(starTreeFieldType.getDimensions().get(0) instanceof DateDimension);  
                b.field("name", "keyword1");
            b.endObject();  
            () -> mapper.parse(source(b -> b.startArray("status").value(0).value(1).endArray()))
            b.field("type", "star_tree");
                b.value(getRandom().nextBoolean() ? "week" : "1w");  
        MapperParsingException ex = expectThrows(  
    ) throws IOException {
            assertEquals("status", starTreeFieldType.getDimensions().get(1).getField());  
            assertEquals("@timestamp", starTreeFieldType.getDimensions().get(0).getField());  
        b.endArray();
            b.startObject();
            } else {  
            b.field("type", "star_tree");
                .endObject()
            b.endObject();
            b.startObject("name");  
            b.endObject();
            Set.of("name"),  
        Metric metric2 = new Metric("name", m1);  
            }  
 * Tests for {@link StarTreeMapper}.  
        });
            {
            StarTreeMapper.StarTreeFieldType starTreeFieldType = (StarTreeMapper.StarTreeFieldType) type;  
            () -> createMapperService(getMinMapping(false, false, false, true, false))  
            b.startObject("properties");  
import org.opensearch.index.compositeindex.datacube.Dimension;  
            b.endObject();
        MapperService mapperService = createMapperService(getMinMappingWithNestedField());
        CapturingDocumentInput docInput = new CapturingDocumentInput();
            List<DateTimeUnitRounding> expectedTimeUnits = Arrays.asList(  
            for (int i = 0; i < expectedTimeUnits.size(); i++) {  
            b.startArray("stats");  
            b.field("name", metric);
                .field("name", isDuplicateMetric ? "numeric_dv" : "numeric_dv1")  // Duplicate metric
                )
            b.endObject();  
            b.field("type", "star_tree");
            b.startObject("date_dimension");
            assertEquals(expectedDimensionFields, dateDim.getSubDimensionNames());
            b.startArray("ordered_dimensions");
            b.field("type", "star_tree");
            ex.getMessage()
            () -> createMapperService(getExpandedMappingWithJustAvg("status", "invalid"))  
            b.startObject("config");
            b.endObject();
            b.startObject("status");  
                b.field("type", "date");
    }
            }
        m2.add(MetricStat.MAX);  
    @Override
            b.startObject("@timestamp");  
                b.startObject();
            b.field("name", "@timestamp");
            b.startObject("name");  
            b.field("type", "keyword");
            b.endObject();
            b.endObject();
    public void testInvalidMetricTypeWithDocCount() {
            b.startObject("startree");  
        assertEquals(MetricStat.MAX, MetricStat.fromTypeName("max"));  
        MapperParsingException ex = expectThrows(
            }
                new HashSet<>(Arrays.asList("@timestamp", "status")),
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitRounding;
        b.startObject("config");
                b.startObject();
        boolean invalidMetricType,  
            b.field("type", "keyword");
                )
                b.endObject();
        CompositeIndexValidator.validate(mapperService, enabledCompositeIndexSettings, mapperService.getIndexSettings());  
            List<Rounding.DateTimeUnit> expectedTimeUnits = Arrays.asList(
    }  
        );  
                .field("name", "timestamp")
            b.startObject("fields");
            Metric metric = starTreeFieldType.getMetrics().get(1);  
            ex.getMessage(),
            b.startArray("stats");
            assertEquals("name.keyword1", starTreeFieldType.getDimensions().get(4).getField());  
            MapperParsingException.class,
                Rounding.DateTimeUnit.DAY_OF_MONTH,
            b.startObject();
            "Failed to parse mapping [_doc]: unsupported field type associated with dimension [status] as part of star tree field [startree]",  
        MapperParsingException ex = expectThrows(
                }  
            b.endObject();
        MapperParsingException ex = expectThrows(
    private XContentBuilder getExpandedMappingWithJustSum(String dim, String metric) throws IOException {
                .endObject()
                starTreeFieldType.getStarTreeConfig().getSkipStarNodeCreationInDims()
            StarTreeFieldConfiguration.StarTreeBuildMode.OFF_HEAP
        throws IOException {  
            List<MetricStat> expectedMetrics = Arrays.asList(MetricStat.AVG, MetricStat.VALUE_COUNT, MetricStat.SUM);
            b.field("name", dim);
import java.util.ArrayList;
            }
                b.endObject();  
            }  
    @Override
            ex.getMessage()
            b.endObject();  
            b.field("type", "keyword");  
        assertThat(e.getMessage(), containsString("name cannot be empty string"));
                b.endObject();  
        assertEquals(
        return topMapping(b -> {
            b.startArray("calendar_intervals");
            b.startObject("@timestamp");
            for (int i = 0; i < expectedTimeUnits.size(); i++) {  
            b.startObject();
        boolean invalidSkipDims,
            b.field("type", "text");
                mapperServiceInvalid.getIndexSettings()  
            b.endObject();
            b.field("type", "star_tree");
            }
                assertEquals(expectedTimeUnits.get(i).shortName(), dateDim.getSortedCalendarIntervals().get(i).shortName());
    @Override
        for (CompositeMappedFieldType type : compositeFieldTypes) {
        assertNotEquals(field1, field2);
            b.startObject("properties");
            b.field("name", "metric_field");
            assertEquals("status", starTreeFieldType.getMetrics().get(0).getField());
            b.field("ignore_above", 512);
            assertTrue(starTreeFieldType.getDimensions().get(0) instanceof DateDimension);
            b.endObject();
            assertTrue(starTreeFieldType.getDimensions().get(2) instanceof UnsignedLongDimension);
    public void testValidStarTreeNestedFieldsAndMultiFields() throws IOException {
        m2.add(MetricStat.VALUE_COUNT);
            MapperParsingException.class,
    }
            () -> createMapperService(getInvalidMapping(false, false, true, false))  
        ParsedDocument doc = mapper.parse(source(b -> b.startArray("size").value(0).value(1).endArray()));
            assertEquals("name.keyword2", starTreeFieldType.getDimensions().get(5).getField());
                b.field("name", "keyword1");
            settings,  
            b.startObject("startree");
                enabledCompositeIndexSettings,
        UnsignedLongDimension n3 = new UnsignedLongDimension("name2");  
        );
            b.startObject("size");  
                .numberOfShards(1)
        // since index setting is disabled, throw exception
                b.field("name", "keyword1");
        boolean invalidDimType,
        MapperService mapperServiceInvalidDim = createMapperService(getInvalidMappingWithDv(false, false, true, false));
            b.endObject();
        assertEquals(
        assertNotEquals(field1, field2);
                .numberOfReplicas(0)
            b.endObject();
            {  
            MapperParsingException.class,
                b.value("status");
            b.endObject();
            DateDimension dateDim = (DateDimension) starTreeFieldType.getDimensions().get(0);
            assertEquals(expectedMetrics, starTreeFieldType.getMetrics().get(0).getMetrics());
        return topMapping(b -> {
            b.startObject("status");  
    private XContentBuilder getInvalidMapping(
            b.startObject("size");
            b.startArray("metrics");
import org.opensearch.core.common.unit.ByteSizeUnit;
        assertEquals(  
        assertEquals(
            b.startObject();  
        n2 = new NumericDimension("name1");  
                mapperServiceInvalidDim.getIndexSettings()
                b.field("name", "@timestamp");
        Set<CompositeMappedFieldType> compositeFieldTypes = mapperService.getCompositeFieldTypes();
            b.startArray("skip_star_node_creation_for_dimensions");
    }  
    }
            b.endObject();
    }
                b.startObject("invalid");
            b.endObject();
            }  
        d1CalendarIntervals.add(new DateTimeUnitAdapter(Rounding.DateTimeUnit.HOUR_OF_DAY));
            b.field("type", "keyword");
            StarTreeMapper.StarTreeFieldType starTreeFieldType = (StarTreeMapper.StarTreeFieldType) type;
            b.field("name", "name.keyword2");
            b.startObject("metric_field");  
            b.endArray();
            b.field("type", "keyword");
            b.endObject();  
        for (CompositeMappedFieldType type : compositeFieldTypes) {
            b.value("avg");
        d2CalendarIntervals.add(new DateTimeUnitAdapter(Rounding.DateTimeUnit.HOUR_OF_DAY));  
            b.endObject();
            if (!dateDimsAbsent) {
        IllegalArgumentException ex = expectThrows(  
            ex.getMessage()
            StarTreeMapper.StarTreeFieldType starTreeFieldType = (StarTreeMapper.StarTreeFieldType) type;
                Rounding.DateTimeUnit.MONTH_OF_YEAR  
                b.value("status");
        }  
            );  
        boolean missingMetric,  
            assertEquals(StarTreeFieldConfiguration.StarTreeBuildMode.OFF_HEAP, starTreeFieldType.getStarTreeConfig().getBuildMode());
        boolean missingDim,
            b.startObject();  
    }  
            b.startObject("keyword1");  
                b.endObject();  
import java.util.Collections;  
            b.endArray();  
            b.startObject("startree");
            b.startObject("status");
import org.opensearch.core.xcontent.XContentBuilder;  
                .endArray()
    public void testMetricsWithCountAndSum() throws IOException {
            MapperParsingException.class,  
            assertEquals("@timestamp", starTreeFieldType.getDimensions().get(0).getField());
            "Failed to parse mapping [_doc]: date_dimension [@timestamp] should be of type date for star tree field [startree]",
        );
    private XContentBuilder getExpandedMappingWithSumAndCount(String dim, String metric) throws IOException {
    public void testInvalidSingleDim() {  
            b.endArray();  
                b.endArray();
        );
                b.value("status");  
                b.field("type", "keyword");
            assertEquals("size", starTreeFieldType.getMetrics().get(0).getField());  
        assertEquals(
            b.startObject();
                disabledCompositeIndexSettings,
            b.endObject();
                .startArray("metrics")
            b.startArray("skip_star_node_creation_for_dimensions");
                .build(),
            assertEquals(new HashSet<>(), starTreeFieldType.getStarTreeConfig().getSkipStarNodeCreationInDims());  
            b.endObject();  
                b.field("name", "ip1");
            "object mapping for [_doc] with array for [status] cannot be accepted, as the field is also part of composite index mapping which does not accept arrays",
            b.startArray("metrics");
            b.endObject();
            b.endObject();
                b.startObject();
                    b.value(getRandom().nextBoolean() ? "year" : "1y");  
                assertEquals(new DateTimeUnitAdapter(expectedTimeUnits.get(i)), dateDim.getIntervals().get(i));
            }
            b.startObject("nested");
            if (!invalidDimType) {  
    }  
            assertEquals(List.of(MetricStat.DOC_COUNT), metric.getMetrics());
    public void testNoMetrics() {
            b.field("type", "integer");
            "star tree index cannot be created, enable it using [indices.composite_index.star_tree.enabled] cluster setting or [index.search.star_tree_index.enabled] index setting",  
            List<MetricStat> expectedMetrics = Arrays.asList(MetricStat.VALUE_COUNT, MetricStat.SUM, MetricStat.AVG);  
            assertTrue(starTreeFieldType.getDimensions().get(1) instanceof NumericDimension);
        b.field("name", "status");
        );
                b.field("type", "date");
            b.startObject("composite");
            b.startObject("status");  
            List<MetricStat> expectedMetrics = Arrays.asList(MetricStat.VALUE_COUNT, MetricStat.SUM, MetricStat.AVG);
            b.startObject("metric_field");  
        return false;
        XContentBuilder mapping = null;
                b.startObject();
        });
            assertEquals(StarTreeFieldConfiguration.StarTreeBuildMode.OFF_HEAP, starTreeFieldType.getStarTreeConfig().getBuildMode());
    public void testValidStarTree() throws IOException {
            b.endObject();
                }
            b.field("type", "integer");
            b.startObject("keyword1");  
                .endObject()  
            b.endObject();
                DataCubeDateTimeUnit.HALF_HOUR_OF_DAY
        // Since the mapper has no specific index setting to enable star tree, throw error
        );
            b.endObject();
            );
            b.field("name", "metric_field");
            }  
            b.endArray();
            b.endObject();  
            }
            100,
    public void testCompositeIndexWithArraysInCompositeField() throws IOException {
            {  
        dims = List.of(d1, n2, n1);
            );
            List<MetricStat> expectedMetrics = Arrays.asList(MetricStat.VALUE_COUNT, MetricStat.SUM, MetricStat.AVG);
            DateDimension dateDim = (DateDimension) starTreeFieldType.getDimensions().get(0);  
            b.field("name", "@timestamp");
            DateDimension dateDim = (DateDimension) starTreeFieldType.getDimensions().get(0);
            b.field("ignore_above", 512);
            assertEquals("status", starTreeFieldType.getMetrics().get(0).getField());
            assertEquals("status", starTreeFieldType.getMetrics().get(0).getField());
            List<String> expectedDimensionFields = Arrays.asList("@timestamp_half-hour", "@timestamp_week", "@timestamp_month");
            ex.getMessage()
