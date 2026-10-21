        );
                b.field("type", "integer");
            b.startObject("properties");
            b.startObject("keyword1");
            b.endArray();
        );
            b.endObject();
    ) throws IOException {
        d2 = new DateDimension("name", d2CalendarIntervals, DateFieldMapper.Resolution.MILLISECONDS);
        assertEquals(field1, field2);
            )
            assertTrue(starTreeFieldType.getDimensions().get(0) instanceof DateDimension);
            b.startArray("ordered_dimensions");
            b.endArray();
        assertEquals(4, doc.rootDoc().getFields("size").length);
                b.startObject();
        return Settings.builder()
            b.startObject("config");
package org.opensearch.index.mapper;
        }
    protected void writeFieldValue(XContentBuilder builder) throws IOException {}
        StarTreeFieldConfiguration config = new StarTreeFieldConfiguration(
        DateDimension d1 = new DateDimension("name", d1CalendarIntervals, DateFieldMapper.Resolution.MILLISECONDS);
                .startArray("ordered_dimensions")
            }
    public void testMetric() {
            StarTreeMapper.StarTreeFieldType starTreeFieldType = (StarTreeMapper.StarTreeFieldType) type;
            () -> createMapperService(getMinMapping(false, false, false, false, true))
                .startObject()
import org.opensearch.core.common.unit.ByteSizeValue;
            b.startObject("");
        NumericDimension n2 = new NumericDimension("name1");
    }
        return false;
            ex.getMessage()
            assertEquals(expectedMetrics, starTreeFieldType.getMetrics().get(1).getMetrics());
        StarTreeFieldConfiguration config1 = new StarTreeFieldConfiguration(
            b.endObject();
            b.endObject();
            b.startArray("metrics");
    public void testNoMetrics() {
            Metric metric = starTreeFieldType.getMetrics().get(2);
            StarTreeMapper.StarTreeFieldType starTreeFieldType = (StarTreeMapper.StarTreeFieldType) type;
        boolean invalidParam,
            b.field("type", "date");
            b.startObject("date_dimension");
            ex.getMessage(),
                b.field("type", "date");
                b.field("type", "date");
            b.startObject("properties");
                b.endObject();
        DocumentMapper mapper = createDocumentMapper(pluggableSettings, getExpandedMappingWithJustAvg("status", "size"));
            b.endArray();
            containsString("Failed to parse mapping [_doc]: metrics section is required for star tree field [startree]")
            .put(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey(), false)
            b.startObject();
                b.field("type", "date");
            )
        assertEquals(MetricStat.SUM, MetricStat.fromTypeName("sum"));
            }
        );
        b.field("name", "status");
        return false;
            MapperParsingException.class,
                .startObject()
        MapperService mapperService = createMapperService(getMinMappingWithNestedField());
import org.opensearch.index.compositeindex.datacube.MetricStat;
        });
            b.endObject();
            b.startObject("@timestamp");
            b.endObject();
            () -> createMapperService(getInvalidMapping(false, false, false, false, true, false, false))
            assertEquals(
            b.field("type", "keyword");
    }
            b.endObject();
        boolean invalidMetricType
    private XContentBuilder getMinMapping() throws IOException {
        m2.add(MetricStat.VALUE_COUNT);
            b.startObject("properties");
                b.startObject();
                }
        }
        for (CompositeMappedFieldType type : compositeFieldTypes) {
        m2.add(MetricStat.MAX);
            b.field("name", "metric_field");
            for (int i = 0; i < expectedTimeUnits.size(); i++) {
            b.endObject();
                b.field("invalid", "invalid");
            for (int i = 0; i < expectedTimeUnits.size(); i++) {
            () -> createMapperService(getMinMapping(true, false, false, false, false))
        field2 = new StarTreeField("starTree", dims, metrics, config);
                starTreeFieldType.getStarTreeConfig().getSkipStarNodeCreationInDims()
            ex.getMessage()
            b.startArray("stats");
        MapperParsingException ex = expectThrows(
                .startObject("numeric_dv1")
            b.startObject("unsignedLongDimension");
        b.endArray();
            b.startObject("config");
                .endObject()
            b.startObject("composite");
        List<Dimension> dims = List.of(d1, n2);
    }
    public void testValidValueForFlushTresholdSizeWithoutCompositeIndex() {
                        .put(StarTreeIndexSettings.STAR_TREE_SEARCH_ENABLED_SETTING.getKey(), false)
            ex.getMessage()
            )
 * SPDX-License-Identifier: Apache-2.0
        ex = expectThrows(
            b.endObject();
            b.field("type", "star_tree");
    private XContentBuilder getExpandedMappingWithSumAndCount(String dim, String metric) throws IOException {
        );
                b.startObject("invalid");
                new DateTimeUnitAdapter(Rounding.DateTimeUnit.MONTH_OF_YEAR)
                b.field("doc_values", "false");
        ReadDimension r1 = new ReadDimension("name");
                        .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)
            }
            b.startObject("config");
            b.endObject();
            b.startObject("keyword1");
            b.startObject("fields");
            b.startObject("config");
        return topMapping(b -> {
            if (!missingDim) {
                        .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)
                b.value("status");
            ex.getMessage()
            assertEquals(expectedMetrics, starTreeFieldType.getMetrics().get(0).getMetrics());
            assertEquals("name.keyword2", starTreeFieldType.getDimensions().get(5).getField());
            b.field("name", "nested.status");
    private XContentBuilder getMinMappingWithNestedField() throws IOException {
        assertEquals(new ByteSizeValue(256, ByteSizeUnit.MB), INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.get(settings));
            "star tree index cannot be created, enable it using [indices.composite_index.star_tree.enabled] cluster setting or [index.search.star_tree_index.enabled] index setting",
            DateDimension dateDim = (DateDimension) starTreeFieldType.getDimensions().get(0);
        try {
                b.endArray();
            b.startObject("config");
        assertEquals(
            assertEquals(Collections.emptySet(), starTreeFieldType.getStarTreeConfig().getSkipStarNodeCreationInDims());
        throws IOException {
    public void testInvalidParam() {
            assertEquals(expectedMetrics, starTreeFieldType.getMetrics().get(0).getMetrics());
                b.endObject();
            } else {
            }
            b.value("avg");
            b.endArray();
            b.field("name", "status");
            b.startObject("metric_field");
            b.startArray("skip_star_node_creation_for_dimensions");
            for (int i = 0; i < expectedTimeUnits.size(); i++) {
            b.startObject("@timestamp");
            assertEquals("unsignedLongDimension", starTreeFieldType.getDimensions().get(2).getField());
            b.startObject("@timestamp");
                b.startObject();
        IllegalArgumentException ex = expectThrows(
        config1 = new StarTreeFieldConfiguration(100, Set.of("name"), StarTreeFieldConfiguration.StarTreeBuildMode.ON_HEAP);
                b.startArray("ordered_dimensions");
            assertEquals(StarTreeFieldConfiguration.StarTreeBuildMode.OFF_HEAP, starTreeFieldType.getStarTreeConfig().getBuildMode());
            b.endObject();
            b.endObject();
        for (CompositeMappedFieldType type : compositeFieldTypes) {
            b.startObject("properties");
            b.endObject();
        b.endArray();
        );
            DateDimension dateDim = (DateDimension) starTreeFieldType.getDimensions().get(0);
            b.endObject();
            for (int i = 0; i < expectedTimeUnits.size(); i++) {
        return topMapping(b -> {
            b.field("name", "status");
                .field("name", "numeric_dv")
            assertEquals("status", starTreeFieldType.getMetrics().get(0).getField());
            b.field("name", "@timestamp");
            if (!missingDateDim) {
            b.startObject("config");
            settings,
            b.startObject();
            assertEquals(
        });
        );
    @Override
            b.startObject("@timestamp");
            List<MetricStat> expectedMetrics = Arrays.asList(MetricStat.VALUE_COUNT, MetricStat.SUM, MetricStat.AVG);
            if (!singleDim) {
            ex.getMessage()
            b.field("type", "integer");
        boolean singleDim,
            assertEquals("size", starTreeFieldType.getMetrics().get(0).getField());
            );
        assertNotEquals(r1, r2);
            b.endObject();
            }
            b.field("name", "name.keyword1");
            b.endObject();
            assertEquals(10000, starTreeFieldType.getStarTreeConfig().maxLeafDocs());
            b.field("type", "star_tree");
                .field("type", "integer")
            b.field("type", "ip");
            b.endObject();
                .field("name", isDuplicateMetric ? "numeric_dv" : "numeric_dv1")  // Duplicate metric
            b.field("type", "keyword");
            } else {
        );
            assertEquals("nested.name.keyword2", starTreeFieldType.getDimensions().get(3).getField());
        b.endObject();
            1000,
    public void testInvalidSingleDim() {
            b.startObject("composite");
                .field("doc_values", true)
            b.field("type", "keyword");
            b.field("type", "date");
            b.endObject();
            .put(SETTINGS)
            b.endObject();
        m1.add(MetricStat.MAX);
    }
        Settings settings = Settings.builder()
            assertTrue(starTreeFieldType.getDimensions().get(0) instanceof NumericDimension);
            "Failed to parse mapping [_doc]: Atleast two dimensions are required to build star tree index field [startree]",
            b.startObject("status");
            assertEquals("status", starTreeFieldType.getDimensions().get(1).getField());
                b.value(getRandom().nextBoolean() ? "month" : "1M");
    protected void assertExistsQuery(MapperService mapperService) {}
        }
            .put(COMPOSITE_INDEX_MAX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), "512mb")
    }
                .startObject("composite")
import org.opensearch.core.xcontent.XContentBuilder;
        );
            }
        MapperService mapperService = createMapperService(getExpandedMappingWithJustAvg("status", "size"));
        );
            b.field("type", "star_tree");
            }
                b.value("status");
            }
        b.startObject();
import org.opensearch.index.compositeindex.datacube.startree.StarTreeIndexSettings;
            b.endObject();
            assertEquals(100, starTreeFieldType.getStarTreeConfig().maxLeafDocs());
                b.startObject();
            b.field("type", "star_tree");
            b.endObject();
    public void testReadDimensions() {
            b.field("ignore_above", 512);
            b.startObject();
    private XContentBuilder getInvalidMappingWithDv(
            b.endArray();
    }
            b.endArray();
            b.endObject();
        MapperParsingException ex = expectThrows(
                b.value("status");
            // Assert AVG gets added when both of its base metrics is already present
            List<MetricStat> expectedMetrics = Arrays.asList(MetricStat.VALUE_COUNT, MetricStat.SUM, MetricStat.AVG);
            b.startObject("status");
        });
            b.field("type", "star_tree");
            "Failed to parse mapping [_doc]: Composite fields cannot have more than [1] fields",
            assertTrue(starTreeFieldType.getDimensions().get(0) instanceof DateDimension);
        return topMapping(b -> {
        );
            b.startArray("calendar_intervals");
import org.opensearch.core.common.unit.ByteSizeUnit;
            b.startObject();
            b.endObject();
            assertEquals("status", starTreeFieldType.getDimensions().get(0).getField());
    @Override
            b.endObject();
            "Failed to parse mapping [_doc]: At most [3] calendar intervals are allowed in dimension [@timestamp]",
            b.startObject("composite");
import java.util.List;
        );
            b.startObject("properties");
                mapperServiceInvalid.getIndexSettings()
            b.startArray("ordered_dimensions");
            b.startArray("ordered_dimensions");
        );
            () -> createMapperService(getMinMappingWith2StarTrees())
            b.value("sum");
            b.endObject();
        );
                        .put(INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(512, ByteSizeUnit.MB))
            b.startObject();
            assertEquals(10000, starTreeFieldType.getStarTreeConfig().maxLeafDocs());
            b.field("type", "integer");
            if (!invalidDate) {
            if (!singleDim) {
    @Override
            () -> createMapperService(getInvalidMapping(true, false, false, false))
        assertEquals(d1, d2);
                Rounding.DateTimeUnit.MONTH_OF_YEAR
        assertNotEquals(field1, field2);
                b.field("type", "date");
            MapperParsingException.class,
                assertEquals(expectedTimeUnits.get(i).shortName(), dateDim.getIntervals().get(i).shortName());
    public void testValidStarTree() throws IOException {
    }
            List<DateTimeUnitRounding> expectedTimeUnits = Arrays.asList(
            b.field("name", metric);
                b.startObject();
                assertEquals(expectedTimeUnits.get(i).shortName(), dateDim.getSortedCalendarIntervals().get(i).shortName());
        assertNotEquals(field1, field2);
        Set<CompositeMappedFieldType> compositeFieldTypes = mapperService.getCompositeFieldTypes();
            b.endObject();
    }
            DateDimension dateDim = (DateDimension) starTreeFieldType.getDimensions().get(0);
        });
                b.value(getRandom().nextBoolean() ? "half-hour" : "30m");
        assertEquals(
        d2 = new DateDimension("name1", d1CalendarIntervals, DateFieldMapper.Resolution.MILLISECONDS);
        MapperParsingException ex = expectThrows(
        boolean isEmptyMetrics,
            () -> CompositeIndexValidator.validate(
            "Failed to parse mapping [_doc]: [invalid] in skip_star_node_creation_for_dimensions should be part of ordered_dimensions",
            b.endObject();
    public void testValidStarTreeNestedFieldsAndMultiFields() throws IOException {
        MapperParsingException ex = expectThrows(
            b.endObject();
        assertThat(
        assertEquals(
            b.startObject("config");
            {
            }
            List<Rounding.DateTimeUnit> expectedTimeUnits = Arrays.asList(
    }
        assertNotEquals(n1, n2);
            );
            b.startObject("startree");
            b.startObject("startree");
    }
    public void testInvalidSkipDim() {
            b.endObject();
        CompositeIndexValidator.validate(mapperService, disabledCompositeIndexSettings, enabledIndexSettings);
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        assertEquals(List.of(MetricStat.VALUE_COUNT, MetricStat.SUM), MetricStat.AVG.getBaseMetrics());
        assertThat(e.getMessage(), containsString("name cannot be empty string"));
import org.opensearch.index.compositeindex.CompositeIndexSettings;
            b.endObject();
            MapperParsingException.class,
            b.endArray();
        assertEquals(
            MapperParsingException.class,
            b.endObject();
            b.endObject();
            assertEquals("@timestamp", starTreeFieldType.getDimensions().get(0).getField());
    public void testDuplicateDimensions() {
            b.endObject();
            if (!dateDimsAbsent) {
/*
            b.value("month");
            if (!invalidDimType) {
    }
            b.endArray();
        return getInvalidMapping(singleDim, invalidSkipDims, invalidDimType, invalidMetricType, false, false, false);
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitRounding;
                if (invalidSkipDims) {
            b.endObject();
                .startObject("numeric_dv")
            StarTreeMapper.StarTreeFieldType starTreeFieldType = (StarTreeMapper.StarTreeFieldType) type;
            b.endObject();
            b.field("ignore_above", 512);
            b.startObject("metric_field");
            assertEquals("name.keyword1", starTreeFieldType.getDimensions().get(4).getField());
            StarTreeMapper.StarTreeFieldType starTreeFieldType = (StarTreeMapper.StarTreeFieldType) type;
            assertEquals(10000, starTreeFieldType.getStarTreeConfig().maxLeafDocs());
    }
            b.field("type", "integer");
            b.field("type", "unsigned_long");
        assertEquals(
import static com.carrotsearch.randomizedtesting.RandomizedTest.getRandom;
    }
            b.field("name", "metric_field");
    }
            IllegalArgumentException.class,
            StarTreeFieldConfiguration.StarTreeBuildMode.OFF_HEAP
    }
            // Assert COUNT and SUM gets added when AVG is defined
        );
            b.endArray();
            () -> createMapperService(getMinMapping(false, false, false, true, false))
            b.field("type", "integer");
            b.startObject("composite");
            assertEquals("status", starTreeFieldType.getDimensions().get(1).getField());
    protected final XContentBuilder fieldMapping(CheckedConsumer<XContentBuilder, IOException> buildField) throws IOException {
            b.field("type", "keyword");
                        .build()
            }
    public void testInvalidStarTreeDateDims() throws IOException {
                .startObject("timestamp")
        );
        boolean missingDim,
            b.endObject();
                b.startObject();
            .build();
        return topMapping(b -> {
            b.field("type", "text");
            ex.getMessage()
        MapperParsingException mapperParsingExceptionex = expectThrows(
            b.endObject();
            MapperParsingException.class,
            ex.getMessage(),
            "Failed to parse mapping [_doc]: Star tree mapping definition has unsupported parameters:  [invalid : {invalid=invalid}]",
            b.endObject();
            }
                b.endObject();
                .numberOfReplicas(0)
            b.startArray("ordered_dimensions");
    }
            b.endObject();
            for (int i = 0; i < expectedTimeUnits.size(); i++) {
            List<DateTimeUnitRounding> expectedTimeUnits = Arrays.asList(
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitAdapter;
            b.endObject();
            b.endObject();
            b.field("type", "star_tree");
            assertEquals(expectedDimensionFields, dateDim.getSubDimensionNames());
            b.startObject("keyword1");
        CompositeIndexSettings disabledCompositeIndexSettings = new CompositeIndexSettings(
            b.endObject();
                b.endObject();
        MapperParsingException ex = expectThrows(MapperParsingException.class, () -> createMapperService(finalMapping));
    @Override
import org.opensearch.common.settings.Settings;
            MapperParsingException.class,
            () -> createMapperService(getInvalidMapping(false, false, false, false, false, true, false))
            }
        Metric metric2 = new Metric("name", m1);
            b.startObject();
            b.endObject();
        assertEquals(MetricStat.MIN, MetricStat.fromTypeName("min"));
        for (CompositeMappedFieldType type : compositeFieldTypes) {
                b.endObject();
                .endObject();
        assertEquals(
        MapperParsingException ex = expectThrows(
            assertEquals("@timestamp", starTreeFieldType.getDimensions().get(0).getField());
        );
                b.startArray("calendar_intervals");
                        .put(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey(), true)
        assertEquals(metric1, metric2);
        assertEquals(r1, r2);
            b.startObject();
            }
                b.endObject();
    private XContentBuilder getInvalidMapping(boolean singleDim, boolean invalidSkipDims, boolean invalidDimType, boolean invalidMetricType)
                b.value("avg");
        MapperParsingException ex = expectThrows(
            assertTrue(starTreeFieldType.getDimensions().get(0) instanceof DateDimension);
    protected void minimalMapping(XContentBuilder b) throws IOException {
        d1CalendarIntervals.add(new DateTimeUnitAdapter(Rounding.DateTimeUnit.HOUR_OF_DAY));
            b.field("name", "unsignedLongDimension"); // UnsignedLongDimension
                if (invalidSkipDims) {
            MapperParsingException.class,
    }
            b.field("type", "integer");
            b.field("name", "metric_field");
        assertEquals(new ByteSizeValue(256, ByteSizeUnit.MB), INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.get(settings));
/**
            b.field("name", dim);
        assertNotEquals(field1, field2);
            assertEquals("status", starTreeFieldType.getMetrics().get(0).getField());
    }
    }
    ) throws IOException {
                starTreeFieldType.getStarTreeConfig().getSkipStarNodeCreationInDims()
            b.startObject("startree");
            b.startObject("composite");
            "star tree index cannot be created, enable it using [indices.composite_index.star_tree.enabled] cluster setting or [index.search.star_tree_index.enabled] index setting",
        MapperParsingException ex = expectThrows(
        MapperService mapperService = createMapperService(getMinMappingWithDateDims(false, false, false));
            b.endArray();
            b.endObject();
            }
            b.endObject();
        assertEquals(MetricStat.AVG, MetricStat.fromTypeName("avg"));
        Set<CompositeMappedFieldType> compositeFieldTypes = mapperService.getCompositeFieldTypes();
            b.startObject("startree");
            b.endObject();
    }
            b.startObject("composite");
                new DateTimeUnitAdapter(Rounding.DateTimeUnit.MONTH_OF_YEAR)
                b.startObject("date_dimension");
        );
            assertEquals(expectedDimensionFields, dateDim.getSubDimensionNames());
        );
            settings,
            b.field("name", "unsignedLongDimension"); // UnsignedLongDimension
import org.opensearch.index.compositeindex.datacube.Dimension;
            List<MetricStat> expectedMetrics = Arrays.asList(MetricStat.VALUE_COUNT, MetricStat.SUM, MetricStat.AVG);
            IndexMetadata.builder("test")
            b.endObject();
                mapperServiceInvalidDim,
            }
            }
        StarTreeField field1 = new StarTreeField("starTree", dims, metrics, config);
                    b.value(getRandom().nextBoolean() ? "quarter-hour" : "15m");
        field2 = new StarTreeField("starTree", dims, metrics, config1);
            assertEquals(3, starTreeFieldType.getMetrics().size());
        assertEquals("Invalid metric stat: invalid", ex.getMessage());
            List<String> expectedDimensionFields = Arrays.asList("@timestamp_minute", "@timestamp_half-hour");
        MapperService mapperService = createMapperService(getMinMapping());
                b.startObject();
        dims = List.of(d1, n2);
            b.field("type", "keyword");
                DataCubeDateTimeUnit.HALF_HOUR_OF_DAY
            b.field("type", "integer");
            b.startObject("composite");
                    Settings.builder()
            StarTreeFieldConfiguration.StarTreeBuildMode.OFF_HEAP
            b.endObject();
        IndexSettings disabledIndexSettings = new IndexSettings(
            b.startObject();
            assertEquals(List.of(MetricStat.DOC_COUNT), metric.getMetrics());
            assertEquals("status", starTreeFieldType.getDimensions().get(1).getField());
    // Overriding fieldMapping to make it create composite mappings by default.
            b.startObject("keyword2");
        );
            b.endObject();
            b.startObject();
        UnsignedLongDimension n3 = new UnsignedLongDimension("name2");
            MapperParsingException.class,
    public void testDimensions() {
            b.field("name", "status");
            b.endObject();
            b.startObject("status");
    public void testInvalidMetricTypeWithDocCount() {
            }
    public void testInvalidDateDimType() {
    public void testMissingMetrics() {
            b.field("type", "star_tree");
            assertTrue(starTreeFieldType.getDimensions().get(2) instanceof UnsignedLongDimension);
        assertEquals(
        });
            b.endObject();
                .field("name", "timestamp")
            assertEquals(StarTreeFieldConfiguration.StarTreeBuildMode.OFF_HEAP, starTreeFieldType.getStarTreeConfig().getBuildMode());
                )
 */
            b.startObject("composite");
        MapperParsingException ex = expectThrows(
        );
            b.field("type", "keyword");
        assertParseMinimalWarnings();
            MapperParsingException.class,
            b.endArray();
        MapperService mapperServiceInvalidDim = createMapperService(getInvalidMappingWithDv(false, false, true, false));
        ex = expectThrows(
    public void testValidStarTreeWithNoDateDim() throws IOException {
            b.field("type", "date");
            b.field("type", "keyword");
            b.endObject();
        return getMinMapping(false, false, false, false, false);
                b.endObject();
    protected void registerParameters(ParameterChecker checker) throws IOException {
            b.startObject("unsignedLongDimension");
            Metric metric = starTreeFieldType.getMetrics().get(1);
import org.opensearch.index.compositeindex.datacube.UnsignedLongDimension;
            b.startObject("keyword1");
        assertEquals(field1, field2);
        d2CalendarIntervals.add(new DateTimeUnitAdapter(Rounding.DateTimeUnit.HOUR_OF_DAY));
                b.endObject();
            b.field("name", "nested.status");
            b.endObject();
            IndexMetadata.builder("test")
import java.util.Collections;
                        .put(INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(512, ByteSizeUnit.MB))
            b.endObject();
            assertEquals(3, starTreeFieldType.getDimensions().size());
                b.value("@timestamp");
        assertThat(ex.getMessage(), containsString("Failed to parse mapping [_doc]: unknown dimension field [status]"));
                .endObject()
        }
        );
        for (CompositeMappedFieldType type : compositeFieldTypes) {
            if (additionalDim) {
            b.field("type", "integer");
            b.endObject();
        assertNotEquals(field1, field2);
            b.startObject("@timestamp");
            b.startObject("@timestamp");
        return topMapping(b -> {
            b.endObject();
        b.field("type", "star_tree");
 * Tests for {@link StarTreeMapper}.
            }
                new DateTimeUnitAdapter(Rounding.DateTimeUnit.DAY_OF_MONTH),
            if (invalidMetricType) {
            assertEquals("@timestamp", starTreeFieldType.getDimensions().get(0).getField());
            assertEquals(StarTreeFieldConfiguration.StarTreeBuildMode.OFF_HEAP, starTreeFieldType.getStarTreeConfig().getBuildMode());
            assertEquals("_doc_count", metric.getField());
            b.endArray();
            b.startObject("keyword1");
            List<Rounding.DateTimeUnit> expectedTimeUnits = Arrays.asList(
            b.endObject();
        MapperService mapperService = createMapperService(getExpandedMappingWithSumAndCount("status", "size"));
    private XContentBuilder getMinMappingWithDateDims(boolean calendarIntervalsExceeded, boolean dateDimsAbsent, boolean additionalDim)
            b.field("name", "metric_field");
                b.endObject();
            );
            .put(INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), "256mb")
        field2 = new StarTreeField("starTree", dims, metrics, config);
        boolean invalidDimType,
            b.startObject();
                .numberOfShards(1)
            }
            b.startObject("status");
            b.startObject("properties");
        assertEquals("Failed to parse mapping [_doc]: Invalid metric stat: _doc_count", ex.getMessage());
            b.endArray();
            b.endArray();
            );
            b.startObject();
            b.field("type", "star_tree");
    @Override
    }
    }
                mapperServiceInvalidDim.getIndexSettings()
                mapperServiceInvalid,
        ParsedDocument doc = mapper.parse(source(b -> b.startArray("size").value(0).value(1).endArray()));
        boolean invalidDate
            b.startObject("date_dimension");
                b.value("_doc_count");
            b.endObject();
            assertEquals(
            b.field("type", "keyword");
            b.startObject("date_dimension");
        MapperParsingException ex = expectThrows(
            List<MetricStat> expectedMetrics = List.of(MetricStat.SUM);
            b.field("type", "keyword");
            b.endObject();
        boolean missingDateDim
        );
                b.endObject();
            assertEquals(StarTreeFieldConfiguration.StarTreeBuildMode.OFF_HEAP, starTreeFieldType.getStarTreeConfig().getBuildMode());
            b.startObject("@timestamp");
            b.startObject("date_dimension");
            b.endObject();
            b.endObject();
        n2 = new NumericDimension("name1");
            assertEquals("@timestamp", starTreeFieldType.getDimensions().get(0).getField());
            b.field("name", "@timestamp");
                    b.value(getRandom().nextBoolean() ? "day" : "1d");
            ex.getMessage()
    }
            b.startArray("skip_star_node_creation_for_dimensions");
            b.startArray("metrics");
        return topMapping(b -> {
                b.endObject();
            b.endObject();
            MapperParsingException.class,
    }
        );
        assertEquals(MetricStat.VALUE_COUNT, MetricStat.fromTypeName("value_count"));
        List<MetricStat> m2 = new ArrayList<>();
        List<DateTimeUnitRounding> d1CalendarIntervals = new ArrayList<>();
            b.startArray("metrics");
                b.field("type", "date");
            b.field("type", "keyword");
    private XContentBuilder getExpandedMappingWithJustSum(String dim, String metric) throws IOException {
                new DateTimeUnitAdapter(Rounding.DateTimeUnit.MINUTES_OF_HOUR),
            b.startObject("config");
            b.endObject();
                }
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;
import org.opensearch.common.settings.ClusterSettings;
    }
                        .put(StarTreeIndexSettings.STAR_TREE_SEARCH_ENABLED_SETTING.getKey(), true)
                .startObject()
    public void testMissingDims() {
            b.endObject();
        );
    }
            ex.getMessage()
            b.field("type", "text");
            assertEquals(10000, starTreeFieldType.getStarTreeConfig().maxLeafDocs());
        List<MetricStat> m1 = new ArrayList<>();
            b.field("name", "status");
            IllegalArgumentException.class,
            b.startObject();
        XContentBuilder finalMapping = getMappingWithDuplicateFields(false, true);
            b.endObject();
            b.startArray("ordered_dimensions");
        );
            assertEquals("@timestamp", starTreeFieldType.getDimensions().get(0).getField());
                .endObject()
        assertEquals(
        d2CalendarIntervals.add(new DateTimeUnitAdapter(Rounding.DateTimeUnit.HOUR_OF_DAY));
                        .build()
import java.util.ArrayList;
        field2 = new StarTreeField("starTree", dims, metrics, config);
        return mapping;
            b.startObject("composite");
        }
            b.startObject("startree");
        StarTreeField field2 = new StarTreeField("starTree", dims, metrics, config);
                b.field("doc_values", "true");
import org.opensearch.index.IndexSettings;
import org.opensearch.index.compositeindex.datacube.DateDimension;
            assertEquals("status", starTreeFieldType.getDimensions().get(1).getField());
        boolean invalidSkipDims,
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> createMapperService(topMapping(b -> {
            }
    }
            DateDimension dateDim = (DateDimension) starTreeFieldType.getDimensions().get(0);
            b.field("name", "status");
            b.endArray();
        MapperParsingException ex = expectThrows(
            b.endObject();
            }
            () -> createMapperService(getInvalidMapping(false, false, true, false))
            b.startObject("keyword2");
        for (CompositeMappedFieldType type : compositeFieldTypes) {
            b.value("month");
            b.field("type", "integer");
            b.startObject();
            mapperParsingExceptionex.getMessage()
    }
            b.startArray("ordered_dimensions");
                b.endObject();
            b.endObject();
            b.field("type", "integer");
                b.field("type", "integer");
    }
            b.field("type", "integer");
        for (CompositeMappedFieldType type : compositeFieldTypes) {
        assertNotEquals(field1, field2);
    public void testValidations() throws IOException {
            b.endObject();
                starTreeFieldType.getStarTreeConfig().getSkipStarNodeCreationInDims()
        assertThat(ex.getCause().getMessage(), containsString("star tree field and cannot be added inside a document"));
        boolean invalidDimType,
        boolean invalidDocCountMetricType,
        );
            b.endObject();
        );
            b.endArray();
            b.endObject();
            () -> createMapperService(getMinMapping(false, true, false, false, false))
        return topMapping(b -> {
                b.field("name", "metric_field");
    }
        Metric metric1 = new Metric("name", m1);
            b.field("name", dim);
            b.startArray("calendar_intervals");
            assertEquals("size", starTreeFieldType.getMetrics().get(0).getField());
            Set.of("name"),
        field2 = new StarTreeField("starTree", dims, metrics, config1);
        List<DateTimeUnitRounding> d2CalendarIntervals = new ArrayList<>();
            b.endObject();
            }
            b.startObject();
            b.endObject();
            b.startObject("keyword1");
}
                .field("type", "integer")
        // since index setting is enabled, throws no error
            b.field("name", "status");
            b.startObject("composite");
            b.startObject("name");
        );
            for (int i = 0; i < expectedTimeUnits.size(); i++) {
            b.startObject();
            () -> createMapperService(getMinMappingWithDateDims(false, true, false))
            b.endObject();
            if (!missingMetric) {
        settings = Settings.builder().put(CompositeIndexSettings.STAR_TREE_INDEX_ENABLED_SETTING.getKey(), false).build();
            () -> CompositeIndexValidator.validate(
            }
    }
            // Assert AVG gets added when both of its base metrics is already present
        b.endObject();
            100,
        List<DateTimeUnitRounding> d1CalendarIntervals = new ArrayList<>();
            MapperParsingException.class,
                b.value("status");
                b.endArray();
            b.startArray("metrics");
        boolean invalidSkipDims,
        b.field("name", "status");
            MapperParsingException.class,
        CapturingDocumentInput docInput = new CapturingDocumentInput();
                .endObject()
        metrics = List.of(metric1, metric1);
        b.field("name", "size");
                assertEquals(new DateTimeUnitAdapter(expectedTimeUnits.get(i)), dateDim.getIntervals().get(i));
                if (calendarIntervalsExceeded) {
            List<MetricStat> expectedMetrics = Arrays.asList(MetricStat.VALUE_COUNT, MetricStat.SUM, MetricStat.AVG);
            b.endObject();
            b.endObject();
            b.field("name", "@timestamp");
            "Failed to parse mapping [_doc]: Duplicate dimension [numeric_dv] present as part star tree index field [startree-1]",
        );
                b.field("name", "status");
                b.startObject("status");
                b.field("name", "status");
import org.opensearch.index.compositeindex.datacube.ReadDimension;
                b.field("type", "integer");
            assertEquals(new HashSet<>(), starTreeFieldType.getStarTreeConfig().getSkipStarNodeCreationInDims());
                .startObject("properties")
        ex = expectThrows(
            IllegalArgumentException.class,
            b.startArray("skip_star_node_creation_for_dimensions");
            b.field("name", "metric_field");
            b.endObject();
            b.endObject();
        Settings settings = Settings.builder().put(CompositeIndexSettings.STAR_TREE_INDEX_ENABLED_SETTING.getKey(), true).build();
    }
            b.endObject();
        dims = List.of(d1, n2, n1);
        throws IOException {
        boolean isEmptyDims,
            b.startObject("startree");
        );
 * The OpenSearch Contributors require contributions made to
            b.endArray();
                new HashSet<>(Arrays.asList("@timestamp", "status")),
            b.endObject();
            b.field("name", metric);
        );
            assertEquals(2, starTreeFieldType.getMetrics().size());
            () -> createMapperService(getExpandedMappingWithJustAvg("status", "invalid"))
            b.startObject("status");
            b.field("name", "@timestamp");
                .endObject()
            b.endObject();
            b.startObject("status");
            "Aggregations not supported for the metrics field [metric_field] with field type [integer] as part of star tree field",
                .build(),
        assertThat(ex.getMessage(), containsString("Failed to parse mapping [_doc]: unknown date dimension field [@timestamp]"));
            b.field("type", "keyword");
                assertEquals(expectedTimeUnits.get(i).shortName(), dateDim.getSortedCalendarIntervals().get(i).shortName());
            () -> createMapperService(getMinMapping(false, false, true, false, false))
            b.startObject("keyword1");
                    b.value(getRandom().nextBoolean() ? "year" : "1y");
                b.field("name", "keyword1");
                .endObject()
            .put(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey(), true)
                    b.value("invalid");
            b.startObject("@timestamp");
        XContentBuilder mapping = null;
        assertNotEquals(metric1, metric2);
    private XContentBuilder getMinMappingWith2StarTrees() throws IOException {
            assertEquals(List.of(MetricStat.DOC_COUNT), metric.getMetrics());
            List<DateTimeUnitRounding> expectedTimeUnits = Arrays.asList(
import org.opensearch.common.Rounding;
            List<String> expectedDimensionFields = Arrays.asList("@timestamp_minute", "@timestamp_half-hour");
        );
            assertEquals(StarTreeFieldConfiguration.StarTreeBuildMode.OFF_HEAP, starTreeFieldType.getStarTreeConfig().getBuildMode());
            b.field("type", "integer");
            b.endObject();
            b.endObject();
            b.field("name", "@timestamp");
        })));
    }
    }
            b.startObject();
            b.startObject("status");
            assertEquals("status", starTreeFieldType.getMetrics().get(0).getField());
            b.field("name", dim);
            ex.getMessage()
            b.endObject();
        );
        MapperParsingException ex = expectThrows(
            b.endObject();
            StarTreeMapper.StarTreeFieldType starTreeFieldType = (StarTreeMapper.StarTreeFieldType) type;
    }
            List<DateTimeUnitRounding> expectedTimeUnits = Arrays.asList(
        Set<CompositeMappedFieldType> compositeFieldTypes = mapperService.getCompositeFieldTypes();
        dims = List.of(d1, n2);
    public void testPluggableDataFormatStarTreeThrows() throws IOException {
                b.field("doc_values", "true");
                finalMapperService,
                )
        assertThat(
    }
        StarTreeField field4 = new StarTreeField("starTree", dims1, metrics, config);
            .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)
            b.value("day");
            } else {
            assertEquals(100, starTreeFieldType.getStarTreeConfig().maxLeafDocs());
    }
                b.field("type", "integer");
            () -> createMapperService(getExpandedMappingWithJustAvg("invalid", "size"))
            .build();
                disabledCompositeIndexSettings,
                b.endObject();
            b.field("max_leaf_docs", 100);
        assertEquals(n1, n2);
            );
    public void testStarTreeField() {
            assertEquals(StarTreeFieldConfiguration.StarTreeBuildMode.OFF_HEAP, starTreeFieldType.getStarTreeConfig().getBuildMode());
            List<MetricStat> expectedMetrics = Arrays.asList(MetricStat.AVG, MetricStat.VALUE_COUNT, MetricStat.SUM);
        XContentBuilder finalMapping = getMappingWithDuplicateFields(true, false);
            IllegalArgumentException.class,
                .endObject()
    public void testInvalidDimType() {
                b.startObject("metric_field");
            b.startObject("size");
            assertEquals("@timestamp", starTreeFieldType.getDimensions().get(0).getField());
            Settings.EMPTY
            b.endObject();
        );
        );
        });
            ex.getMessage()
                b.field("name", "keyword1");
import org.opensearch.index.compositeindex.CompositeIndexValidator;
            b.field("type", "integer");
            assertEquals("metric_field", starTreeFieldType.getMetrics().get(1).getField());
                .field("doc_values", true)
            b.field("type", "date");
    public void testNoDims() {
            b.startArray("skip_star_node_creation_for_dimensions");
        b.startArray("metrics");
            b.startObject("nested");
            b.startObject("composite");
            }
 * this file be licensed under the Apache-2.0 license or a
        MapperService mapperService = createMapperService(getExpandedMappingWithJustAvg("status", "size"));
            b.startObject();
        StarTreeField field3 = new StarTreeField("starTree", dims1, metrics, config);
        } catch (IOException e) {
            b.value("day");
            minimalMapping(b);
        MapperParsingException ex = expectThrows(
                b.field("name", "@timestamp");
        m1.add(MetricStat.MAX);
            MapperParsingException.class,
    @Override
        CompositeIndexSettings enabledCompositeIndexSettings = new CompositeIndexSettings(
                b.field("type", "integer");
                .endObject()
                .endObject()
        MapperService mapperServiceInvalid = createMapperService(getInvalidMappingWithDv(false, false, false, true));
            b.endObject();
        d1CalendarIntervals.add(new DateTimeUnitAdapter(Rounding.DateTimeUnit.HOUR_OF_DAY));
            assertTrue(starTreeFieldType.getDimensions().get(0) instanceof NumericDimension);
 * compatible open source license.
            assertEquals(expectedMetrics, starTreeFieldType.getMetrics().get(0).getMetrics());
                new DateTimeUnitAdapter(Rounding.DateTimeUnit.WEEK_OF_WEEKYEAR),
        MapperParsingException ex = expectThrows(MapperParsingException.class, () -> createMapperService(finalMapping));
            b.endObject();
                b.value("@timestamp");
            b.endObject();
            b.startObject("startree");
            b.field("name", "@timestamp");
            MapperParsingException.class,
        }
            if (!invalidDimType) {
    protected boolean supportsMeta() {
            {
            mapping = jsonBuilder().startObject()
        assertEquals(
            b.startObject("properties");
            b.startObject("fields");
            b.startObject();
                b.field("name", "keyword1");
            b.endObject();
                b.field("doc_values", "false");
        });
            .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)
            ex.getMessage()
        NumericDimension n1 = new NumericDimension("name");
            b.endObject();
            b.endObject();
            assertEquals(StarTreeFieldConfiguration.StarTreeBuildMode.OFF_HEAP, starTreeFieldType.getStarTreeConfig().getBuildMode());
        assertEquals(
        });
            b.field("type", "integer");
            b.startObject("keyword1");
            b.field("max_leaf_docs", 100);
        );
            assertEquals(100, starTreeFieldType.getStarTreeConfig().maxLeafDocs());
        assertEquals(field3, field4);
            b.endArray();
                enabledCompositeIndexSettings,
            "Failed to parse mapping [_doc]: unsupported field type associated with dimension [status] as part of star tree field [startree]",
        );
            b.startObject("config");
    private XContentBuilder getInvalidMapping(
                DataCubeDateTimeUnit.HALF_HOUR_OF_DAY,
        b.startObject();
                    b.value(getRandom().nextBoolean() ? "minute" : "1m");
    public void testInvalidMetric() {
                .startObject()
            b.endObject();
            b.endObject();
                .endObject()
            MapperParsingException.class,
                .endObject()
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> MetricStat.fromTypeName("invalid"));
                b.field("name", "ip1");
            assertEquals(Collections.emptySet(), starTreeFieldType.getStarTreeConfig().getSkipStarNodeCreationInDims());
            assertEquals(Collections.emptySet(), starTreeFieldType.getStarTreeConfig().getSkipStarNodeCreationInDims());
            b.field("name", "nested.name.keyword2");
            b.startObject("date_dimension");
 */
            b.endObject();
        assertEquals(
            b.endArray();
        b.endObject();
                b.startObject();
            b.startObject();
                .startObject("config")
            b.startObject();
            MapperParsingException.class,
        );
    public void testMissingDateDims() {
            );
            b.endObject();
            b.startObject("status");
            b.startObject("size");
import java.util.HashSet;
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        assertNotEquals(d1, d2);
            } else {
            StarTreeMapper.StarTreeFieldType starTreeFieldType = (StarTreeMapper.StarTreeFieldType) type;
            b.endObject();
        assertEquals(
            b.endObject();
            b.endObject();
            b.startObject("ip1");
            b.startObject();
    public void testMetricsWithJustSum() throws IOException {
            b.startArray("ordered_dimensions");
import org.opensearch.cluster.metadata.IndexMetadata;
    protected boolean supportsOrIgnoresBoost() {
            "Failed to parse mapping [_doc]: non-numeric field type is associated with star tree metric [startree]",
        CompositeIndexValidator.validate(mapperService, enabledCompositeIndexSettings, mapperService.getIndexSettings());
                b.startObject("date_dimension");
            assertTrue(starTreeFieldType.getDimensions().get(0) instanceof DateDimension);
                .endArray()
            b.field("name", "status");
        // since index setting is disabled, throw exception
        MapperService mapperService = createMapperService(getMinMappingWithDateDims(false, true, true));
            "Failed to parse mapping [_doc]: Atleast two dimensions are required to build star tree index field [startree]",
            containsString("Failed to parse mapping [_doc]: ordered_dimensions is required for star tree field [startree]")
            b.endObject();
            b.field("type", "integer");
                Rounding.DateTimeUnit.DAY_OF_MONTH,
        b.startObject("config");
            b.startObject("status");
            b.endObject();
        for (CompositeMappedFieldType type : compositeFieldTypes) {
    }
        assertEquals(MetricStat.MAX, MetricStat.fromTypeName("max"));
            b.startArray("ordered_dimensions");
            Set.of("name"),
            b.field("name", "metric_field");
        assertEquals("Failed to parse mapping [_doc]: unknown metric field [invalid]", ex.getMessage());
                b.value("@timestamp");
            b.endObject();
import org.opensearch.common.CheckedConsumer;
            b.startObject("properties");
            b.endObject();
            b.startObject();
        return topMapping(b -> {
            b.endObject();
                .settings(
        MapperParsingException ex = expectThrows(
import java.io.IOException;
            b.startArray("metrics");
            );
            b.startObject();
            b.endObject();
        DateDimension d2 = new DateDimension("name", d1CalendarIntervals, DateFieldMapper.Resolution.MILLISECONDS);
            }
                new HashSet<>(Arrays.asList("@timestamp", "status")),
        );
            b.field("type", "keyword");
            ex.getMessage()
            } else {
        DateDimension d1 = new DateDimension("name", d1CalendarIntervals, DateFieldMapper.Resolution.MILLISECONDS);
            b.endObject();
    }
            b.endArray();
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            b.field("name", "name.keyword2");
            b.endObject();
            b.field("type", "integer");
import org.opensearch.common.util.FeatureFlags;
                        .put(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey(), true)
        List<MetricStat> m1 = new ArrayList<>();
                .startObject("date_dimension")
            b.startObject("metric_field");
            assertEquals(expectedMetrics, starTreeFieldType.getMetrics().get(0).getMetrics());
        assertEquals(
        // 1 intPoint , 1 SNDV field for each value , so 4 in total
        );
        List<Dimension> dims1 = List.of(d1, n1, n2, n3);
            }
            assertEquals(expectedDimensionFields, dateDim.getSubDimensionNames());
    }
            () -> mapper.parse(source(b -> b.field("startree", "some_value")), docInput)
            b.field("name", "nested.name.keyword1");
            b.startArray("calendar_intervals");
            b.endObject();
            b.endObject();
        ReadDimension r2 = new ReadDimension("name");
        assertEquals("Failed to parse mapping [_doc]: unknown dimension field [invalid]", ex.getMessage());
            b.endArray();
                b.startObject();
import org.opensearch.index.compositeindex.datacube.NumericDimension;
            b.field("type", "keyword");
            assertEquals("unsignedLongDimension", starTreeFieldType.getDimensions().get(2).getField());
            b.startArray("metrics");
                .startObject("startree-1")
            b.endObject();
                b.field("name", "status");
    public void testValidStarTreeDefaults() throws IOException {
                b.field("type", "keyword");
        Set<CompositeMappedFieldType> compositeFieldTypes = mapperService.getCompositeFieldTypes();
            b.field("name", "@timestamp");
        );
            MapperParsingException.class,
            b.field("name", metric);
        }
            b.startObject("keyword1");
    public void testInvalidDim() {
            b.startObject("keyword1");
            b.startObject();
                .startArray("metrics")
            expectedMetrics = Arrays.asList(MetricStat.VALUE_COUNT, MetricStat.SUM, MetricStat.AVG);
            b.startObject("startree");
        });
            b.value("day");
            () -> createMapperService(getInvalidMapping(false, false, false, true))
    public void testInvalidMetricType() {
            b.startObject("startree1");
            b.endObject();
            assertTrue(starTreeFieldType.getDimensions().get(2) instanceof UnsignedLongDimension);
            b.endArray();
        Set<CompositeMappedFieldType> compositeFieldTypes = mapperService.getCompositeFieldTypes();
                .settings(
            b.startObject();
            {
import org.opensearch.index.compositeindex.datacube.Metric;
    }
    public void testValidStarTreeDateDims() throws IOException {
            b.endObject();
                b.endObject();
            b.value("month");
            b.value("sum");
    public void testEmptyName() {
        metrics = List.of(metric1);
    }
                        .put(SETTINGS)
            DateDimension dateDim = (DateDimension) starTreeFieldType.getDimensions().get(0);
            );
            b.field("name", "@timestamp");
    }
        b.startObject();
            b.startObject("metric_field");
            ex.getMessage()
                assertEquals(new DateTimeUnitAdapter(expectedTimeUnits.get(i)), dateDim.getIntervals().get(i));
        metric2 = new Metric("name", m2);
            b.endObject();
        config1 = new StarTreeFieldConfiguration(100, Set.of("name", "field2"), StarTreeFieldConfiguration.StarTreeBuildMode.OFF_HEAP);
                Rounding.DateTimeUnit.MONTH_OF_YEAR
import org.opensearch.index.compositeindex.datacube.DataCubeDateTimeUnit;
            () -> createMapperService(getMinMappingWithDateDims(true, false, false))
            b.field("type", "date");
                new DateTimeUnitAdapter(Rounding.DateTimeUnit.MINUTES_OF_HOUR),
                b.endObject();
            b.endObject();
            fail("Failed to create mapping: " + e.getMessage());
    }
    }
            b.startObject("keyword1");
            b.endArray();
            b.field("type", "date");
            {
                b.endObject();
        );
    }
            Settings.EMPTY
            List<String> expectedDimensionFields = Arrays.asList("@timestamp_half-hour", "@timestamp_week", "@timestamp_month");
            b.startObject();
            b.endArray();
        );
            "Failed to parse mapping [_doc]: Duplicate metrics [numeric_dv] present as part star tree index field [startree-1]",
                new HashSet<>(Arrays.asList("@timestamp", "status", "unsignedLongDimension")),
            b.field("type", "keyword");
        MapperParsingException ex = expectThrows(
import static org.opensearch.index.compositeindex.CompositeIndexSettings.COMPOSITE_INDEX_MAX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING;
            () -> mapper.parse(source(b -> b.startArray("status").value(0).value(1).endArray()))
                b.endArray();
            () -> createMapperService(getInvalidMapping(false, true, false, false))
            b.endArray();
            b.endObject();
                b.field("name", "status");
                finalMapperService.getIndexSettings()
                .field("name", "numeric_dv")
import java.util.Set;
            ex.getMessage()
                    b.value(getRandom().nextBoolean() ? "hour" : "1h");
            b.endObject();
            b.startObject();
        r2 = new ReadDimension("name1");
            b.endObject();
                b.endArray();
            b.startObject("size");
        List<Metric> metrics = List.of(metric1);
            DateDimension dateDim = (DateDimension) starTreeFieldType.getDimensions().get(0);
            b.startObject("startree");
        boolean missingMetric,
            .put(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey(), true)
        assertEquals(
        );
            assertEquals("nested.status", starTreeFieldType.getDimensions().get(1).getField());
            b.startArray("metrics");
            () -> CompositeIndexValidator.validate(finalMapperService, enabledCompositeIndexSettings, disabledIndexSettings)
            assertEquals(expectedMetrics, starTreeFieldType.getMetrics().get(0).getMetrics());
            MapperParsingException.class,
            b.field("type", "integer");
        Set<CompositeMappedFieldType> compositeFieldTypes = mapperService.getCompositeFieldTypes();
            b.endObject();
    }
            assertEquals("_doc_count", metric.getField());
            b.endObject();
import org.opensearch.index.compositeindex.datacube.startree.StarTreeFieldConfiguration;
            () -> CompositeIndexValidator.validate(
    private XContentBuilder getExpandedMappingWithJustAvg(String dim, String metric) throws IOException {
            b.endArray();
 *
            if (invalidMetricType) {
            "Aggregations not supported for the dimension field [@timestamp] with field type [date] as part of star tree field",
            b.startObject();
            b.startObject();
                .build(),
        Metric metric1 = new Metric("name", m1);
        MapperParsingException ex = expectThrows(
        });
        b.endObject();
                .field("type", "date")
                b.startObject();
            List<MetricStat> expectedMetrics = List.of(MetricStat.SUM, MetricStat.VALUE_COUNT, MetricStat.AVG);
                enabledCompositeIndexSettings,
        IndexSettings enabledIndexSettings = new IndexSettings(
                .numberOfShards(1)
import java.util.Arrays;
            }
            ex.getMessage()
                b.field("name", "keyword1");
                b.value("unsignedLongDimension");
            b.endObject();
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
        MapperService finalMapperService = mapperService;
            b.startObject("startree");
            b.field("ignore_above", 512);
        assertThat(ex.getMessage(), containsString("Failed to parse mapping [_doc]: unknown metric field [metric_field]"));
            b.field("type", "integer");
        );
        );
    public void testInValidStarTreeMinDims() throws IOException {
                b.startObject();
        Set<CompositeMappedFieldType> compositeFieldTypes = mapperService.getCompositeFieldTypes();
            b.field("type", "unsigned_long");
            b.value("value_count");
            b.field("max_leaf_docs", 100);
            if (invalidDocCountMetricType) {
    }
            b.endObject();
            b.startObject("properties");
            assertTrue(starTreeFieldType.getDimensions().get(0) instanceof DateDimension);
            b.startObject("config");
            MapperParsingException.class,
            assertEquals(expectedMetrics, starTreeFieldType.getMetrics().get(0).getMetrics());
            b.field("ignore_above", 512);
            b.startArray("metrics");
            b.startObject("properties");
        return topMapping(b -> {
            b.startObject("metric_field");
            .put(INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(512, ByteSizeUnit.MB))
            b.startObject("status");
            assertEquals("metric_field", starTreeFieldType.getDimensions().get(1).getField());
                Rounding.DateTimeUnit.DAY_OF_MONTH,
                    b.value("invalid");
            b.endObject();
        field2 = new StarTreeField("starTree", dims, metrics, config1);
            b.endObject();
            );
        b.startArray("ordered_dimensions");
            b.endObject();
        MapperService mapperService = createMapperService(getExpandedMappingWithJustSum("status", "size"));
            b.startArray("stats");
    }
            b.startObject("size");
            b.endObject();
            "object mapping for [_doc] with array for [status] cannot be accepted, as the field is also part of composite index mapping which does not accept arrays",
import static org.opensearch.index.IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING;
            b.startArray("metrics");
            buildField.accept(b);
            b.startObject("name");
            .put(INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), "256mb")
                    Settings.builder()
            b.endObject();
            assertEquals("nested.status", starTreeFieldType.getMetrics().get(0).getField());
                .field("type", "star_tree")
    private XContentBuilder getMinMapping(
            b.endObject();
            b.endObject();
            "Failed to parse mapping [_doc]: date_dimension [@timestamp] should be of type date for star tree field [startree]",
                b.startArray("metrics");
    public void testCompositeIndexWithArraysInCompositeField() throws IOException {
                }
            () -> createMapperService(getInvalidMapping(false, false, true, false, false, false, true))
    public void testDuplicateMetrics() {
            b.endObject();
                .numberOfReplicas(0)
        Settings settings = Settings.builder()
                .endObject()
        return topMapping(b -> {
            b.startObject();
            b.startArray("stats");
            b.startObject("keyword1");
    @Override
            assertTrue(starTreeFieldType.getDimensions().get(1) instanceof NumericDimension);
            assertTrue(starTreeFieldType.getDimensions().get(1) instanceof NumericDimension);
                b.endObject();
        boolean invalidMetricType,
    // This way, the parent tests are checking the right behavior for this Mapper.
        boolean singleDim,
            b.startObject("properties");
                DataCubeDateTimeUnit.HALF_HOUR_OF_DAY
    protected Settings getIndexSettings() {
        );
                b.field("type", "wildcard");
        }
                .endArray()
            StarTreeMapper.StarTreeFieldType starTreeFieldType = (StarTreeMapper.StarTreeFieldType) type;
                b.field("name", "@timestamp");
    ) throws IOException {
        MapperParsingException ex = expectThrows(
            b.endArray();
                b.startArray("stats");
            b.field("type", "star_tree");
        assertEquals(
                assertEquals(expectedTimeUnits.get(i).shortName(), dateDim.getIntervals().get(i).shortName());
            assertEquals(expectedMetrics, starTreeFieldType.getMetrics().get(0).getMetrics());
            b.endObject();
            b.startObject("size");
            b.endObject();
            b.endArray();
            assertEquals("size", starTreeFieldType.getMetrics().get(0).getField());
        assertEquals(
            b.field("type", "star_tree");
    }
        assertNotEquals(d1, d2);
            b.startObject();
            b.endObject();
            b.startArray("skip_star_node_creation_for_dimensions");
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        NumericDimension n2 = new NumericDimension("name");
            b.endArray();
        DocumentMapper mapper = createDocumentMapper(getExpandedMappingWithJustAvg("status", "status"));
            b.endObject();
            if (!isEmptyDims) {
            if (invalidParam) {
            b.startArray("ordered_dimensions");
    }
            assertEquals("nested.name.keyword1", starTreeFieldType.getDimensions().get(2).getField());
        MapperParsingException ex = expectThrows(
                .field("name", isDuplicateDim ? "numeric_dv" : "numeric_dv1")  // Duplicate dimension
            assertEquals("status", starTreeFieldType.getDimensions().get(1).getField());
                b.value("status");
            b.field("name", "status");
            .build();
import static org.hamcrest.Matchers.containsString;
    }
                        .put(SETTINGS)
        NumericDimension n1 = new NumericDimension("numeric");
                b.field("type", "integer");
    public void testMetricsWithCountAndSum() throws IOException {
                    b.value(getRandom().nextBoolean() ? "second" : "1s");
            assertTrue(starTreeFieldType.getDimensions().get(0) instanceof DateDimension);
                b.value(getRandom().nextBoolean() ? "week" : "1w");
                b.field("name", "metric_field");
        MapperParsingException ex = expectThrows(
            if (!isEmptyMetrics) {
    }
                b.startObject("@timestamp");
        // Since the mapper has no specific index setting to enable star tree, throw error
    private XContentBuilder getMappingWithDuplicateFields(boolean isDuplicateDim, boolean isDuplicateMetric) {
            {
            b.startObject("properties");
public class StarTreeMapperTests extends MapperTestCase {
    public void testValidValueForCompositeIndex() {
