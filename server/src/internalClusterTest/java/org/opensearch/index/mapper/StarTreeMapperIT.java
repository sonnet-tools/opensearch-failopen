    public void testCompositeIndexWithArraysInChildNestedCompositeField() throws IOException {
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitAdapter;  
        );  
        // Try to update to an invalid value
    public void testStarTreeWithDerivedSource() {  
            .field("timestamp", "2023-06-01T12:00:00Z")
                                            "stats": [
                .value("month")
                    }
        assertEquals(  
            .endObject()
                )
            "object mapping for [_doc] with array for [nested] cannot be accepted, as the field is also part of composite index mapping which does not accept arrays",  
        IllegalArgumentException ex = expectThrows(
        Iterable<IndicesService> dataNodeInstances = internalCluster().getDataNodeInstances(IndicesService.class);
                .startObject("status")  
                .endObject()
                .startObject("dim3")  
                    assertEquals(Collections.emptySet(), starTreeFieldType.getStarTreeConfig().getSkipStarNodeCreationInDims());
            .field("name", "this is name")  
            }
            .put(settings)
                        DataCubeDateTimeUnit.HALF_HOUR_OF_DAY
    }
        if (hasDocValues) {  
                .cluster()
                .endObject();  
                    for (int i = 0; i < dateDim.getIntervals().size(); i++) {
            ex.getMessage()  
                .field("doc_values", true)
 * compatible open source license.
            ex.getMessage()
            return jsonBuilder().startObject()
                .startObject("composite")  
        int values = Integer.parseInt((String) hit.getSourceAsMap().get("status"));  
            .value(30)
                .setPersistentSettings(Settings.builder().putNull("*"))  
import java.util.List;  
                .endObject()  
    }  
                    assertEquals(List.of(MetricStat.DOC_COUNT), starTreeFieldType.getMetrics().get(1).getMetrics());
            MapperParsingException.class,
                                "type": "star_tree",
                    DateDimension dateDim = (DateDimension) starTreeFieldType.getDimensions().get(0);
                .startObject("startree-1")
            return jsonBuilder().startObject()
                .endArray()  
                .endObject()
                .startObject()
            return "numeric";
            .startObject()
                .endObject();
                .startObject("date_dimension")
                    assertEquals("timestamp", starTreeFieldType.getDimensions().get(0).getField());  
    public void testTranslogFlushThresholdSizeWithDefaultCompositeSettingLow() {
            .endArray()  
    }
                    StarTreeMapper.StarTreeFieldType starTreeFieldType = (StarTreeMapper.StarTreeFieldType) ft;
    public void testInvalidMetric() {  
                                        }
                .field("type", "integer")
                .endObject()
            .startArray("nested1")
                .endObject()  
                .endObject()  
        assertTrue(response.isAcknowledged());
        int i = 1;
                .field("type", "keyword")  
                // Date dimension is considered as one dimension regardless of number of actual calendar intervals  
        Settings indexSettings = Settings.builder()  
                "mappings": {
                        DataCubeDateTimeUnit.HALF_HOUR_OF_DAY
                .endObject()
                .endObject()  
    public void testValidTranslogFlushThresholdSize() {
                .startArray("ordered_dimensions")
                .field("doc_values", false)
                .endObject()
                .endObject()
        prepareCreate(TEST_INDEX).setSettings(settings).setMapping(createMinimalTestMapping(false, false, false)).get();
                .endObject()  
    }
            IllegalArgumentException.class,
        } catch (IOException e) {  
                .field("type", "unsigned_long")
            ex.getMessage().contains("You can configure 'index.translog.flush_threshold_size' with upto '512mb' for composite index")  
                                            "name": "integer_2",  
    }
    public void testCompositeIndexWithIndexNotSpecified() {
                .value("half-hour")  
            }
                .field("type", "keyword")
            throw new IllegalStateException(e);
                .endArray()  
            "Failed to parse mapping [_doc]: At most [1] calendar intervals are allowed in dimension [timestamp]",
            ex.getMessage()  
            .endObject()  
                .endObject()
        // here nested.nested1.status is part of the composite field but "nested" field itself is an array  
        }
                    assertEquals("timestamp", starTreeFieldType.getDimensions().get(0).getField());
                            "geopoint_field": {
                .field("doc_values", false)  
                    for (int i = 0; i < dateDim.getSortedCalendarIntervals().size(); i++) {
                .startObject("nested3")  
        AcknowledgedResponse response = prepareCreate(TEST_INDEX).setSettings(indexSettings)
                    assertTrue(starTreeFieldType.getDimensions().get(0) instanceof DateDimension);
import org.opensearch.search.SearchHit;
        }
        if (hasDocValues) {  
            .put(settings)
            .preparePutMapping(TEST_INDEX)  
                .field("name", getMetric(invalidMetric, false))
                .field("type", "star_tree")  
        assertEquals(
            .field("name", "this is name")
                    );
                        .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)
                .setTransientSettings(Settings.builder().putNull("*"))
                .field("type", "keyword")  
    }  
                .field("type", "integer")  
            ex.getMessage()
            .get();
                .startObject("config")
                .endObject()
                .startObject("nested-not-startree")
            .put(settings)  
                .field("name", "numeric_dv")
                .endObject()
 * this file be licensed under the Apache-2.0 license or a
            .field("timestamp", "2023-06-01T12:00:00Z")
                .field("type", "integer")
            .endObject()  
            .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(256, ByteSizeUnit.MB))
                .endObject()  
        assertEquals("You can configure 'index.translog.flush_threshold_size' with upto '130mb' for composite index", ex.getMessage());
            .field("status", "200")  
    }  
                .endObject()  
                .field("type", "keyword")
        } else if (isWildCard) {
            final Index index = resolveIndex("test");  
            .startArray("name")  
                    StarTreeMapper.StarTreeFieldType starTreeFieldType = (StarTreeMapper.StarTreeFieldType) ft;  
                                "config": {  
        IndexResponse indexResponse = client().prepareIndex(TEST_INDEX).setSource(doc).get();
                                        },
    private static XContentBuilder createDateTestMapping(boolean duplicate) {
import java.io.IOException;  
                .endArray()
                .startObject("keyword")  
            .put(settings)
import org.opensearch.index.compositeindex.datacube.MetricStat;
        );
                .field("type", "integer")
        );
                .field("doc_values", true)
        prepareCreate(TEST_INDEX).setSettings(settings).setMapping(createMinimalTestMapping(false, false, false)).get();  
    }
            .field("timestamp", "2023-06-01T12:00:00Z")
                .field("doc_values", true)  
    public void testMaxMetricsCompositeIndex() {
                .endObject()  
                .endObject()
            .startObject()
        try {
                .field("doc_values", true)
                },  
import org.opensearch.core.common.unit.ByteSizeUnit;
        // update some field in the mapping  
            .put(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey(), true)
        IllegalArgumentException ex = expectThrows(
            .value(20)
            .setSource(createMinimalTestMapping(false, false, false))
import java.util.Arrays;
        SearchHit hit = searchResponse.getHits().getAt(0);  
                .startObject("keyword_dv")  
        IllegalArgumentException ex = expectThrows(
                .endObject()  
                .endObject()  
 */  
        );
            MapperParsingException.class,
        }
            .startObject()
import java.util.Set;
                .startObject("keyword2")  
                    assertEquals(2, starTreeFieldType.getMetrics().size());
                .field("doc_values", true)  
                                            "name": "integer_1",
/*  
                .startObject()
                .endArray()
            .value(30)
                .endObject()
            "Failed to parse mapping [_doc]: Duplicate dimension [numeric_dv] present as part star tree index field [startree-1]",  
        try {
            .indices()
        assertEquals("2023-06-01T12:00:00Z", hit.getSourceAsMap().get("timestamp"));
                .startObject("startree-1")
                .startObject("properties")  
                .startArray("calendar_intervals")
            .startObject()
                    assertEquals("keyword_dv", starTreeFieldType.getDimensions().get(2).getField());  
            Map<String, Object> valMap = (Map<String, Object>) val;
            ex.getMessage()  
                .startArray("metrics")
                .setMapping(createMaxDimTestMapping())
                .field("type", "date")
        }  
                .endObject()
        }
        assertTrue(validUpdateResponse.isAcknowledged());
                .field("type", "keyword")  
        prepareCreate(TEST_INDEX).setSettings(settings).setMapping(createMinimalTestMapping(false, false, false)).get();  
    }
                                "type": "integer"
                .startObject("keyword1")
                .field("type", "keyword")
    }  
                                "type": "integer"
        // Attempt to index a document with an array field  
        MapperParsingException ex = expectThrows(
    }
import org.opensearch.common.Rounding;  
            final Index index = resolveIndex("test");
    }
                .field("type", "keyword")
                .endObject()  
                .startObject("properties")
            throw new IllegalStateException(e);
                .endObject()  
            if (service.hasIndex(index)) {
                .prepareUpdateSettings()
            MapperParsingException.class,  
            .startObject("nested")  
                .field("type", "keyword")  
                .startObject("properties")  
            }""";
            .startObject("nested1")
                    DateDimension dateDim = (DateDimension) starTreeFieldType.getDimensions().get(0);
                .startObject()
                        StarTreeFieldConfiguration.StarTreeBuildMode.OFF_HEAP,
                .field("name", "timestamp")
                            },  
                .endObject()  
                .endObject()
        );
            IllegalArgumentException.class,
                        .put(StarTreeIndexSettings.STAR_TREE_MAX_BASE_METRICS_SETTING.getKey(), 4)
                    DateDimension dateDim = (DateDimension) starTreeFieldType.getDimensions().get(0);
        );  
            .value("this is name")
            .value("this is name1")
                    assertTrue(ft.unwrap() instanceof StarTreeMapper.StarTreeFieldType);
        assertEquals(
    @After  
    public void testCompositeIndexWithHigherTranslogFlushSize() {
    Settings settings = Settings.builder()  
                .startObject("numeric_dv")
                        "append_only": {
        );
            ex.getMessage()
                .endObject()
            .endObject();
    }
    public void testCompositeIndexWithArraysInCompositeField() throws IOException {  
        SearchHit hit = searchResponse.getHits().getAt(0);
import org.junit.After;  
                }  
                    List<MetricStat> expectedMetrics = Arrays.asList(MetricStat.VALUE_COUNT, MetricStat.SUM, MetricStat.AVG);
                .endObject()
                    assertTrue(starTreeFieldType.getDimensions().get(1) instanceof NumericDimension);
                    );
                .endObject()  
    }  
        MapperParsingException ex = expectThrows(
            throw new IllegalStateException(e);
            "Failed to parse mapping [_doc]: There cannot be more than [4] base metrics for star tree field [startree-1]",
    private static XContentBuilder createTestMappingWithoutStarTree() {  
                    assertEquals(10000, starTreeFieldType.getStarTreeConfig().maxLeafDocs());  
            () -> client().admin().indices().preparePutMapping(TEST_INDEX).setSource(createUpdateTestMapping(false, false)).get()
                .endObject()
                .field("doc_values", false)  
                            },  
                .startObject("startree-1")
        .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(512, ByteSizeUnit.MB))  
                .startObject("properties")
                    assertEquals(expectedMetrics, starTreeFieldType.getMetrics().get(0).getMetrics());
                .startObject()
            () -> prepareCreate(TEST_INDEX).setSettings(settings).setMapping(createMinimalTestMapping(false, true, false)).get()  
        assertEquals(
                .startObject()
                .endObject()
                .endObject()
import org.opensearch.action.search.SearchResponse;  
                .field("type", "ip")
                .startObject()
                .startObject("composite")  
                .startObject()
                .startObject("name")
                    Settings.builder()
                .endObject()
                .field("name", "nested.nested1.name.keyword2")  
        prepareCreate(TEST_INDEX).setSettings(settings).setMapping(createMinimalTestMapping(false, false, false)).get();
                .startObject()
        XContentBuilder finalMapping = getMappingWithDuplicateFields(true, false);  
        }
            () -> client().prepareIndex(TEST_INDEX).setSource(doc).get()  
            .endArray()
        List<Integer> values = (List<Integer>) hit.getSourceAsMap().get("numeric");
                        StarTreeFieldConfiguration.StarTreeBuildMode.OFF_HEAP,
                .field("type", "integer")
                .value("day")  
                .field("ignore_above", 512)
                .startObject("config")
            .put(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey(), true)
            "object mapping for [_doc] with array for [nested] cannot be accepted, as the field is also part of composite index mapping which does not accept arrays",
                .endObject()
        XContentBuilder doc = jsonBuilder().startObject()
                .endObject()
            .endObject();
import org.opensearch.index.compositeindex.datacube.NumericDimension;
                            }
                        DataCubeDateTimeUnit.HALF_HOUR_OF_DAY,
                    StarTreeMapper.StarTreeFieldType starTreeFieldType = (StarTreeMapper.StarTreeFieldType) ft;
                    assertTrue(starTreeFieldType.getDimensions().get(3) instanceof OrdinalDimension);  
            ex.getMessage()
        // Attempt to index a document with an array field
                                              "value_count",  
        );
    public void testUpdateTranslogFlushThresholdSize() {
        assertEquals(RestStatus.CREATED, indexResponse.status());  
        );
                .startObject("status")
                .field("doc_values", true)
    }  
                .field("type", "date")
                .field("name", "nested.nested1.keyword_dv")  
                .startObject("nested-not-startree")
                    List<DateTimeUnitRounding> expectedTimeUnits = Arrays.asList(  
        assertEquals(RestStatus.CREATED, indexResponse.status());  
            .startArray("numeric_dv")
                            "keyword_2": {
                .endObject()  
                }  
                        DataCubeDateTimeUnit.QUARTER_HOUR_OF_DAY,
                .endObject()
                .field("type", "ip")
    private static XContentBuilder createUpdateTestMapping(boolean changeDim, boolean sameStarTree) {  
                Set<CompositeMappedFieldType> fts = indexService.mapperService().getCompositeFieldTypes();  
        // Index the document and refresh
        }  
    }  
        assertEquals(
                .endObject()
                .field("name", isDuplicateMetric ? "numeric_dv" : "numeric_dv1")  // Duplicate metric  
                .endObject()  
                        .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)
                .startObject("dim4")
                .endObject()
                .setSettings(
        assertTrue(
            .value(20)
    private static final String TEST_INDEX = "test";
                .endObject();  
                .endObject();
                .endObject()
                        .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(512, ByteSizeUnit.MB))  
                .endObject()
            IllegalArgumentException.class,  
                .field("doc_values", false)
                    assertEquals("numeric_dv", starTreeFieldType.getDimensions().get(1).getField());
        Settings updatedSettings = Settings.builder()
                .endObject()  
            "Failed to parse mapping [_doc]: Set 'index.append_only.enabled' as true as part of index settings to use star tree index",  
    }  
        // Update to a valid value
                    }
        IllegalArgumentException ex = expectThrows(
                .endObject()  
        assertEquals(
                .startObject("properties")
    private static XContentBuilder createMaxDimTestMapping() {  
                .endObject();  
            .field("status", 10)
                    assertEquals("numeric_dv", starTreeFieldType.getMetrics().get(0).getField());  
        for (IndicesService service : dataNodeInstances) {
                .field("type", "integer")
                .startObject("numeric")
                        starTreeFieldType.getStarTreeConfig().getBuildMode()  
 *
                .endObject()  
import java.util.Map;
    public void testCompositeIndexWithArraysInNestedCompositeField() throws IOException {
                .field("type", "star_tree")
                .field("type", "keyword")
        MapperParsingException ex = expectThrows(
                .endObject()
                IndexService indexService = service.indexService(index);  
        try {
                .endObject()
                .endObject()
                .startObject("keyword")
                .endObject()  
        );
                        starTreeFieldType.getStarTreeConfig().getBuildMode()  
        Settings settings = Settings.builder()  
            .field("status", 10)
            .value(30)  
        prepareCreate(TEST_INDEX).setMapping(createDateTestMapping(false)).setSettings(settings).get();  
            .field("timestamp", "2023-06-01T12:00:00Z")
        }
        assertEquals(  
            .indices()
            ex.getMessage()  
            () -> prepareCreate(TEST_INDEX).setSettings(settings).setMapping(createMinimalTestMapping(false, false, true)).get()
                    for (int i = 0; i < expectedTimeUnits.size(); i++) {
            .startArray("numeric")  
    private XContentBuilder getMappingWithDuplicateFields(boolean isDuplicateDim, boolean isDuplicateMetric) {  
                .startArray("ordered_dimensions")  
                .startArray("calendar_intervals")  
        assertEquals(
            .build();  
                                              "sum",
import org.opensearch.index.compositeindex.CompositeIndexSettings;
                    assertEquals("unsignedLongDimension", starTreeFieldType.getDimensions().get(3).getField());
import org.opensearch.index.query.QueryBuilders;
                .field("doc_values", false)  
                for (CompositeMappedFieldType ft : fts) {
            .build();
                .endObject()
                .field("doc_values", true)
        );
        assertEquals(  
                .setSettings(
        );  
                    assertFalse(ft == null);  
                .endArray()
                .startObject("properties")
        MapperParsingException ex = expectThrows(
                                            "stats": [  
                .field("doc_values", true)
                .startObject("numeric_dv")  
            () -> prepareCreate(TEST_INDEX).setSettings(settings).setMapping(createMinimalTestMapping(false, false, false)).get()
                .field("name", "timestamp")
            .build();
            .prepareUpdateSettings(TEST_INDEX)
        IllegalArgumentException ex = expectThrows(  
        } catch (IOException e) {
        List<Object> values = (List<Object>) ((Map<String, Object>) (hit.getSourceAsMap().get("nested-not-startree"))).get("nested1");  
        assertAcked(prepareCreate(TEST_INDEX).setSource(createIndexSource, MediaTypeRegistry.JSON));  
            .value(10)
                        new DateTimeUnitAdapter(Rounding.DateTimeUnit.MINUTES_OF_HOUR),
    @Before
                .startObject("startree-1")
            "object mapping for [nested] with array for [nested1] cannot be accepted, as the field is also part of composite index mapping which does not accept arrays",
                .field("doc_values", false)  
                    assertEquals("timestamp", starTreeFieldType.getDimensions().get(0).getField());  
                Set<CompositeMappedFieldType> fts = indexService.mapperService().getCompositeFieldTypes();  
                .startObject("properties")
                .endObject()  
            return jsonBuilder().startObject()
                .endArray()
                .field("doc_values", false)
                .endObject()
            {
                .endObject()  
        } else if (isKeyword) {
                    assertEquals(
                .get()
                .endObject()
        );
                    assertTrue(ft.unwrap() instanceof StarTreeMapper.StarTreeFieldType);
                .field("name", "timestamp")  
        // Index the document and refresh
            .prepareUpdateSettings(TEST_INDEX)  
        // Attempt to index a document with an array field  
                        .put(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey(), true)
                .field("type", "integer")  
import org.opensearch.test.OpenSearchIntegTestCase;
                .startObject("config")  
                    "_doc": {
                .startObject("nested1")  
            .field("timestamp", "2023-06-01T12:00:00Z")
                                "type": "geo_point"
            .field("status", 30)  
                .startObject("dim2")
            .endArray()  
                .startObject()
                .indices()
                        .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(512, ByteSizeUnit.MB))
                .endObject();  
                .endObject()  
            .endArray()
                .endObject()
            .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(55, ByteSizeUnit.BYTES))
                .startObject("timestamp")  
import org.opensearch.indices.IndicesService;  
                .endObject()
                .field("name", "status")  
                .endObject()
    }
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
                .field("doc_values", false)
                .field("name", "nested.nested1.keyword_dv")  
                .field("type", "star_tree")
        assertAcked(putMappingResponse);  
import java.util.Collections;
                    assertEquals(
                )
    public void testCompositeIndexWithArraysInNestedMultiFields() throws IOException {
        .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)
import org.opensearch.index.IndexService;
        IllegalArgumentException ex = expectThrows(  
                .field("doc_values", false)
                .startObject()
                .startObject("properties")
                .field("type", "integer")
            .startArray("nested1")
        assertEquals(1, searchResponse.getHits().getTotalHits().value());
        Iterable<IndicesService> dataNodeInstances = internalCluster().getDataNodeInstances(IndicesService.class);
                .endObject()  
                    );  
                        },
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitRounding;
import org.opensearch.index.compositeindex.datacube.DataCubeDateTimeUnit;
            .endArray()
            () -> client().admin().indices().preparePutMapping(TEST_INDEX).setSource(createUpdateTestMapping(true, true)).get()
            final Index index = resolveIndex("test");  
                .endObject()  
        );  
                .startObject("timestamp")
                .value(duplicate ? "quarter-hour" : "half-hour")
                .field("type", "integer")  
        IndexResponse indexResponse = client().prepareIndex(TEST_INDEX).setSource(doc).get();
                    assertEquals("numeric_dv", starTreeFieldType.getDimensions().get(1).getField());
            .startArray("nested1")
        SearchResponse searchResponse = client().prepareSearch(TEST_INDEX).setQuery(QueryBuilders.matchAllQuery()).get();
        assertEquals("2023-06-01T12:00:00Z", hit.getSourceAsMap().get("timestamp"));
            .field("timestamp", "2023-06-01T12:00:00Z")  
                .startObject("keyword_dv")
                Set<CompositeMappedFieldType> fts = indexService.mapperService().getCompositeFieldTypes();
            MapperParsingException.class,
            MapperParsingException.class,  
    }  
        return "numeric_dv";
                            "startree": {
        try {  
                    StarTreeMapper.StarTreeFieldType starTreeFieldType = (StarTreeMapper.StarTreeFieldType) ft;
                .field("doc_values", true)
                        .put(StarTreeIndexSettings.STAR_TREE_MAX_DIMENSIONS_SETTING.getKey(), 2)  
                    assertEquals(Collections.emptySet(), starTreeFieldType.getStarTreeConfig().getSkipStarNodeCreationInDims());
                    }
                .startObject("timestamp")  
                .endObject()
 * The OpenSearch Contributors require contributions made to  
        for (Object val : values) {  
        client().admin().indices().prepareRefresh(TEST_INDEX).get();
            IllegalArgumentException.class,  
        .build();
                IndexService indexService = service.indexService(index);
        // Verify the document was indexed  
            .field("status", 10)  
                        assertEquals(expectedTimeUnits.get(i).shortName(), dateDim.getSortedCalendarIntervals().get(i).shortName());
        // Index the document and refresh  
            .startObject()
            () -> prepareCreate(TEST_INDEX).setSettings(settings).setMapping(createMinimalTestMapping(false, false, false)).get()  
            "Failed to parse mapping [_doc]: ordered_dimensions cannot have more than 2 dimensions for star tree field [startree-1]",
                    );
            .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(56, ByteSizeUnit.BYTES))  
                    assertFalse(ft == null);  
        // Index the document and refresh  
                .field("doc_values", false)
        XContentBuilder doc = jsonBuilder().startObject()  
            .field("name", "this is name")  
        Iterable<IndicesService> dataNodeInstances = internalCluster().getDataNodeInstances(IndicesService.class);
                .endObject()
        );
            .endObject()  
                                }  
            .setSettings(Settings.builder().put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), "1024mb"))
        assertEquals(
                    assertTrue(starTreeFieldType.getDimensions().get(0) instanceof DateDimension);
            MapperParsingException.class,
            throw new IllegalStateException(e);
    }
        assertTrue(
                    for (int i = 0; i < dateDim.getIntervals().size(); i++) {
    public void testBelowMinimumTranslogFlushThresholdSize() {
                IndexService indexService = service.indexService(index);
            () -> client().prepareIndex(TEST_INDEX).setSource(doc).get()
            IllegalArgumentException.class,
                .endArray()
                                            ]  
            .put(CompositeIndexSettings.COMPOSITE_INDEX_MAX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), "130m")  
        MapperParsingException ex = expectThrows(
            .build();
        );
    public void testMaxDimsCompositeIndex() {
                .field("doc_values", true)
                                              "min",
        prepareCreate(TEST_INDEX).setSettings(settings).setMapping(createNestedTestMapping()).get();
                        .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)
                .startObject()
                .startObject("numeric")
                .endArray()
            MapperParsingException.class,
                    // Assert default metrics
                    );
                .startObject("properties")
    public final void cleanupNodeSettings() {
        } catch (IOException e) {
                .field("doc_values", false)  
            .endObject();
        final XContentBuilder doc1 = jsonBuilder().startObject()
                .endObject()
        assertEquals(3, values.size());
                    assertEquals(expectedMetrics, starTreeFieldType.getMetrics().get(0).getMetrics());
                    List<DateTimeUnitRounding> expectedTimeUnits = Arrays.asList(  
            .endObject()  
                .field("type", "ip")
        MapperParsingException ex1 = expectThrows(  
        // here status is part of the composite field but "nested.nested1.status" field is an array which is not
        );
                            "enabled": true
    public void testUnsupportedDim() {
                .endObject()  
            () -> prepareCreate(TEST_INDEX).setSettings(settings).setMapping(createMinimalTestMapping(true, false, false)).get()
                .field("type", "keyword")
    public void testValidCompositeIndex() {
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
                .endObject()
                .endObject()
                }  
                .endObject()
                .startObject("fields")
            .endArray()
                    List<MetricStat> expectedMetrics = Arrays.asList(MetricStat.VALUE_COUNT, MetricStat.SUM, MetricStat.AVG);
            if (service.hasIndex(index)) {
        // part of composite field  
                        new DateTimeUnitAdapter(Rounding.DateTimeUnit.MINUTES_OF_HOUR),
                .endObject()
            "Failed to parse mapping [_doc]: unsupported field type associated with dimension [wildcard] as part of star tree field [startree-1]",
    }
/**
        return "numeric_dv";
    public void testDuplicateDimensions() {
    }
            () -> client().prepareIndex(TEST_INDEX).setSource(doc).get()
                .startArray("ordered_dimensions")
            .build();  
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest().transientSettings(updatedSettings);  
                .startObject("config")  
        assertEquals("2023-06-01T12:00:00Z", hit.getSourceAsMap().get("timestamp"));
    private static String getDim(boolean hasDocValues, boolean isWildCard) {
                    );  
 * SPDX-License-Identifier: Apache-2.0
                .field("type", "integer")  
                .startObject("properties")
                    assertEquals(
        }
                .endObject()
                .endObject()  
    }
                        starTreeFieldType.getStarTreeConfig().getBuildMode()  
            }
                .endObject()
import org.opensearch.index.IndexSettings;  
        );
                .field("doc_values", true)
                .startObject("numeric_new")
                            "keyword_1": {
        // Verify the values in the indexed document
                .field("type", "integer")  
            .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(512, ByteSizeUnit.MB))
                .endObject()  
        for (IndicesService service : dataNodeInstances) {
                                    ],
                .endObject()
                    "index": {
                        }
                .field("type", "integer")  
                .startObject("startree-1")
            MapperParsingException.class,
    public void testCompositeIndexWithNestedArraysInNonCompositeField() throws IOException {
            MapperParsingException.class,
                .startObject("numeric")
        );
                .startObject("composite")
                .startObject("numeric")
                .endObject()  
                .startObject("status")
                .field("type", "integer")  
            .endArray()
        assertTrue(values.contains(20));
        );
            () -> prepareCreate(TEST_INDEX).setSettings(settings)
                    assertFalse(ft == null);  
                .endObject()
import org.opensearch.core.xcontent.XContentBuilder;
    }
                .startObject("config")  
                .startArray("metrics")  
        assertEquals("Index cannot have more than [1] star tree fields", ex.getMessage());  
        );
                    assertEquals("numeric_dv", starTreeFieldType.getMetrics().get(0).getField());
        );  
                                        {
                .get()
                .startObject("keyword")  
                .field("name", "keyword_dv")  
                        StarTreeFieldConfiguration.StarTreeBuildMode.OFF_HEAP,
                .field("doc_values", true)  
                .endObject()
    public void testUpdateIndexWithNewerStarTree() {  
                .endObject()  
        );
            .endObject();
            .endArray()  
import org.opensearch.core.rest.RestStatus;
                    assertEquals(
                    assertEquals(Collections.emptySet(), starTreeFieldType.getStarTreeConfig().getSkipStarNodeCreationInDims());
                .endObject()
                .field("name", "dim2")
                .field("doc_values", false)  
                    assertEquals("nested.nested1.status", starTreeFieldType.getDimensions().get(1).getField());
            .startObject()
                .endObject()
            return jsonBuilder().startObject()
                                        {
            .endObject()
                .endObject()  
        );
                .get()
            client().admin()  
                .field("type", "star_tree")
                .startObject("nested")  
                    assertEquals(10000, starTreeFieldType.getStarTreeConfig().maxLeafDocs());  
        } catch (IOException e) {
                .startObject("date_dimension")
                .endObject()
                    assertEquals("numeric_dv", starTreeFieldType.getMetrics().get(0).getField());  
            .endArray()  
                .startObject("status")
                .endObject()
        );  
    public void testCompositeIndexWithArraysInNonCompositeField() throws IOException {
        // Index the document and refresh
        XContentBuilder doc = jsonBuilder().startObject()
        // Attempt to index a document with an array field
                IndexService indexService = service.indexService(index);
                .startObject("nested1")
                .startObject("status")  
                    List<MetricStat> expectedMetrics = Arrays.asList(MetricStat.VALUE_COUNT, MetricStat.SUM, MetricStat.AVG);  
                .startObject("numeric_dv1")
            .endObject()
                .startObject("date_dimension")
                    }  
                    assertEquals(expectedMetrics, starTreeFieldType.getMetrics().get(0).getMetrics());
        prepareCreate(TEST_INDEX).setSettings(settings).setMapping(createNestedTestMapping()).get();
        assertEquals(
        assertTrue(values.contains(30));
                .startObject("nested1")
            .endObject()  
                .field("name", "numeric_dv")  
                .field("doc_values", true)
        prepareCreate(TEST_INDEX).setSettings(settings).setMapping(createTestMappingWithoutStarTree()).get();
                }  
                        assertEquals(expectedTimeUnits.get(i).shortName(), dateDim.getSortedCalendarIntervals().get(i).shortName());
            assertEquals(10 * i, valMap.get("status"));
            mapping = jsonBuilder().startObject()  
    public void testValidCompositeIndexWithNestedFields() {
                .field("ignore_above", 512)
                    List<MetricStat> expectedMetrics = Arrays.asList(MetricStat.VALUE_COUNT, MetricStat.SUM, MetricStat.AVG);
        IllegalArgumentException ex = expectThrows(
                    }
                        }
                .endObject()
        SearchHit hit = searchResponse.getHits().getAt(0);  
                .endObject()
            .startObject()
        prepareCreate(TEST_INDEX).setSettings(settings).setMapping(createMinimalTestMapping(false, false, false)).get();  
        assertEquals("failed to parse value [55b] for setting [index.translog.flush_threshold_size], must be >= [56b]", ex.getMessage());  
        for (IndicesService service : dataNodeInstances) {
    public void testUpdateIndexWhenMappingIsDifferent() {
        MapperParsingException ex = expectThrows(
        Settings settings = Settings.builder()  
                .endObject()
                .field("doc_values", true)
        prepareCreate(TEST_INDEX).setSettings(settings).setMapping(createMinimalTestMapping(false, false, false)).get();
                    assertEquals("timestamp", starTreeFieldType.getDimensions().get(0).getField());  
        // Attempt to index a document with an array field
                .endObject()  
        // update index threshold flush to higher value  
            .startObject()
        IllegalArgumentException ex = expectThrows(  
                .field("type", "star_tree")
import org.opensearch.index.compositeindex.datacube.OrdinalDimension;  
                .startObject("numeric")
                        "number_of_shards": 2,
        MapperParsingException ex = expectThrows(  
                .field("name", "timestamp")
    private static XContentBuilder createMinimalTestMapping(boolean invalidDim, boolean invalidMetric, boolean wildcard) {  
import org.opensearch.core.common.unit.ByteSizeValue;  
                .startObject("ip")  
                    assertTrue(starTreeFieldType.getDimensions().get(0) instanceof DateDimension);
                .field("name", "unsignedLongDimension") // UnsignedLongDimension  
                .endObject()
        XContentBuilder doc = jsonBuilder().startObject()
            .startArray("nested")
                            },  
            "Aggregations not supported for the metrics field [numeric] with field type [integer] as part of star tree field",  
                .startObject()
                .startObject()  
                .field("name", "numeric_dv")
                    );
        assertTrue(ex.getMessage().startsWith("Aggregations not supported for the dimension field "));
                .startObject("timestamp")
            MapperParsingException.class,  
                        .put(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey(), true)  
                .startObject("keyword")
                .field("type", "text")  
    private static String getMetric(boolean hasDocValues, boolean isKeyword) {
                .field("name", getDim(invalidDim, wildcard))  
        AcknowledgedResponse response = prepareCreate(TEST_INDEX).setSettings(indexSettings)  
            .startObject()  
        try {
                .startObject("ip")
            .endObject();  
                .field("doc_values", false)
                .endObject()  
                .get()
        IllegalArgumentException ex = expectThrows(
                .startObject()
                .startObject("properties")
                .startObject("wildcard")  
                        assertEquals(expectedTimeUnits.get(i).shortName(), dateDim.getIntervals().get(i).shortName());  
                .startArray("metrics")  
                        StarTreeFieldConfiguration.StarTreeBuildMode.OFF_HEAP,
        AcknowledgedResponse putMappingResponse = client().admin()
        }  
            .endObject()
            .field("timestamp", "2023-06-01T12:00:00Z")
            .endObject()
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                for (CompositeMappedFieldType ft : fts) {  
        );  
                                        {
                .endArray()
                .startObject("keyword")
                .startObject()  
    }
        Iterable<IndicesService> dataNodeInstances = internalCluster().getDataNodeInstances(IndicesService.class);
                .field("name", "dim3")
        try {
            .endObject();
            return jsonBuilder().startObject()
                .field("doc_values", false)  
    public void testValidCompositeIndexWithDates() {
            .endObject()
    private static XContentBuilder createNestedTestMappingForArray() {  
                .field("name", "nested3.numeric_dv")
                .startObject("properties")  
                .field("doc_values", true)
                .endObject()
            .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)
                .field("doc_values", false)
                .endObject()
    }  
                        },  
                .field("name", "dim3")
                .endObject()
        validUpdateResponse = client().admin()
                        new DateTimeUnitAdapter(Rounding.DateTimeUnit.MINUTES_OF_HOUR),
                .endArray()  
                .endArray()
                .field("doc_values", true)
                            "integer_2": {
                .startObject("properties")  
                    assertTrue(starTreeFieldType.getDimensions().get(0) instanceof DateDimension);
                    assertEquals("numeric_dv", starTreeFieldType.getDimensions().get(1).getField());  
            i++;  
                .startObject("properties")  
                    assertEquals("nested3.numeric_dv", starTreeFieldType.getMetrics().get(0).getField());  
                    List<DateTimeUnitRounding> expectedTimeUnits = Arrays.asList(  
        prepareCreate(TEST_INDEX).setMapping(createDateTestMapping(true)).setSettings(settings).get();  
                .startObject("keyword")
    public void testDuplicateMetrics() {
                .endObject()
                .endObject()  
        );
        // Index the document and refresh
                    );
import org.opensearch.action.index.IndexResponse;
                .startObject("properties")  
                    Settings.builder()
            throw new IllegalStateException(e);
                            "integer_1": {
            () -> client().admin().indices().preparePutMapping(TEST_INDEX).setSource(createUpdateTestMapping(false, false)).get()
                    assertFalse(ft == null);  
                .field("type", "star_tree")
                .endObject();  
                .endObject()
                .setSettings(Settings.builder().put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), "1024mb"))
        .put(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey(), true)
        assertAcked(
            "Failed to parse mapping [_doc]: Duplicate metrics [numeric_dv] present as part star tree index field [startree-1]",  
    }
                .field("type", "integer")  
            .field("name", "this is name 1")
        try {
                        assertEquals(expectedTimeUnits.get(i).shortName(), dateDim.getSortedCalendarIntervals().get(i).shortName());
        );
    public void testInvalidTranslogFlushThresholdSize() {  
        } catch (IOException e) {
            return jsonBuilder().startObject()
                    assertEquals(4, starTreeFieldType.getDimensions().size());
                        "derived_source": {
                .endArray()
            .field("status", 10)  
            .endObject()
                .startArray("metrics")  
    public void testMaxCalendarIntervalsCompositeIndex() {  
        assertEquals(200, values);
            "Composite fields must be specified during index creation, addition of new composite fields during update is not supported",
                .startObject("keyword_dv")  
                .startObject("date_dimension")
                .endObject()
                .field("name", "dim4")
            if (service.hasIndex(index)) {
                .endObject()
        SearchResponse searchResponse = client().prepareSearch(TEST_INDEX).setQuery(QueryBuilders.matchAllQuery()).get();
                .field("doc_values", true)
        );
                .endObject()
                    DateDimension dateDim = (DateDimension) starTreeFieldType.getDimensions().get(0);  
                .startObject("timestamp")
                .field("type", "wildcard")
        assertTrue(validUpdateResponse.isAcknowledged());  
                .field("type", "date")
    public void testValidCompositeIndexWithDuplicateDates() {
        IndexResponse indexResponse = client().prepareIndex(TEST_INDEX).setSource(doc).get();
                .startObject(sameStarTree ? "startree-1" : "startree-2")
import org.junit.Before;
                .startObject("keyword_dv")
    public void testCompositeIndexWithArraysInNestedCompositeFieldSameNameAsNormalField() throws IOException {  
public class StarTreeMapperIT extends OpenSearchIntegTestCase {
                .startObject("date_dimension")  
            .startObject()
        final XContentBuilder doc = jsonBuilder().startObject()  
            .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(1024, ByteSizeUnit.MB))  
                .startObject("composite")  
                .endObject()  
        );
                .endObject()
                .endObject()
                .setSettings(  
    }  
                .field("type", "date")
                        "composite": {  
            IllegalArgumentException.class,
                    assertEquals(10000, starTreeFieldType.getStarTreeConfig().maxLeafDocs());  
                .field("name", "nested3.numeric_dv")
    }  
                                          "name": "keyword_1"  
                .field("type", "keyword")
            ex.getMessage().contains("You can configure 'index.translog.flush_threshold_size' with upto '512mb' for composite index")  
                .startObject("numeric_dv")
                .field("name", isDuplicateDim ? "numeric_dv" : "numeric_dv1")  // Duplicate dimension
                }  
            ex.getMessage()
}
        );
                .endObject()
                .field("type", "keyword")
                    assertEquals("numeric_dv", starTreeFieldType.getMetrics().get(0).getField());  
                for (CompositeMappedFieldType ft : fts) {
                        .put(StarTreeIndexSettings.STAR_TREE_MAX_DATE_INTERVALS_SETTING.getKey(), 1)  
                .startObject("timestamp")
    }
                .startObject()
        // Index the document and refresh  
                )  
        // update some field in the mapping
        client().admin().indices().prepareRefresh(TEST_INDEX).get();
                    // Assert default metrics  
                                              "max"
                .startObject("keyword_dv")  
        Settings indexSettings = Settings.builder()
            .build();  
    public void testUpdateIndexWithAdditionOfStarTree() {
                .field("doc_values", true)  
                .field("type", "ip")  
                .startObject("ip_no_dv")
                .endObject()
                IndexService indexService = service.indexService(index);
        prepareCreate(TEST_INDEX).setSettings(settings).setMapping(createMinimalTestMapping(false, false, false)).get();
        // Verify the document was indexed  
        );
                .endObject()  
                .endObject()
            .endObject();
        } catch (IOException e) {
                .field("doc_values", true)
            .field("timestamp", "2023-06-01T12:00:00Z")
    public void testUpdateIndexWhenMappingIsSame() {  
            .build();
                .startObject("config")  
        XContentBuilder finalMapping = getMappingWithDuplicateFields(false, true);  
                                "type": "keyword"
                .startObject("composite")  
            ex1.getMessage()  
                .field("type", "integer")
    }  
                .startObject()  
                .startObject("ip")
                .field("type", "date")
                                    ]
        // Verify the values in the indexed document  
            () -> prepareCreate(TEST_INDEX).setSettings(settings).setMapping(finalMapping).setSettings(settings).get()  
                .endObject()
                    assertEquals(expectedMetrics, starTreeFieldType.getMetrics().get(0).getMetrics());
    }
                .field("type", "integer")  
                .startObject()
                .field("name", "nested.nested1.name.keyword1")  
        String createIndexSource = """
                .field("doc_values", true)  
                .startObject("date_dimension")
 */  
                .field("doc_values", true)  
        } catch (IOException e) {
            .field("status", 20)  
                .field("type", "keyword")
            .build();
                .startObject("numeric_dv")
                    for (int i = 0; i < dateDim.getIntervals().size(); i++) {
            () -> prepareCreate(TEST_INDEX).setSettings(indexSettings).setMapping(createMinimalTestMapping(false, false, false)).get()  
        assertTrue(values.contains(10));  
                .field("doc_values", true)
        assertEquals(
            IllegalArgumentException.class,
            .startObject("nested")  
                .value("quarter-hour")
                .field("name", "timestamp")
        prepareCreate(TEST_INDEX).setSettings(settings).setMapping(createNestedTestMappingForArray()).get();
        Settings indexSettings = Settings.builder()
                .field("doc_values", true)
                Set<CompositeMappedFieldType> fts = indexService.mapperService().getCompositeFieldTypes();  
                .endArray()
                .endObject()
                        DataCubeDateTimeUnit.HALF_HOUR_OF_DAY  
                .endObject()
                    assertEquals(10000, starTreeFieldType.getStarTreeConfig().maxLeafDocs());  
            if (service.hasIndex(index)) {
            .endObject()
                    assertEquals("nested.nested1.name.keyword1", starTreeFieldType.getDimensions().get(3).getField());
        );  
            .field("status", 10)  
                    assertEquals(
                .startObject("numeric")
                        .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(512, ByteSizeUnit.MB))  
                for (CompositeMappedFieldType ft : fts) {
                .field("type", "date")
            IllegalArgumentException.class,  
                .startArray("ordered_dimensions")
                .startArray("metrics")
            .indices()
                                        },
            .put(CompositeIndexSettings.COMPOSITE_INDEX_MAX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), "1030m")
                                "type": "keyword"
import org.opensearch.core.index.Index;
                .startObject("nested")  
                                    "ordered_dimensions": [
                .endObject()
            .setMapping(createMinimalTestMapping(false, false, false))
                    assertEquals(Collections.emptySet(), starTreeFieldType.getStarTreeConfig().getSkipStarNodeCreationInDims());
            .startObject()
                    assertEquals(10000, starTreeFieldType.getStarTreeConfig().maxLeafDocs());  
                    );  
    public final void setupNodeSettings() {  
        client().admin().cluster().updateSettings(updateSettingsRequest).actionGet();
                .endObject()
                .startArray("ordered_dimensions")
        );
            .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(513, ByteSizeUnit.MB))  
        }
                            }  
import org.opensearch.index.compositeindex.datacube.startree.StarTreeFieldConfiguration;
                                        {
            }
                .startObject("numeric_dv")
            () -> client().prepareIndex(TEST_INDEX).setSource(doc).get()  
        IllegalArgumentException ex = expectThrows(  
                .startObject("properties")
                .field("name", "dim2")
                .endObject()  
        assertEquals(3, values.size());
        assertEquals(1, searchResponse.getHits().getTotalHits().value());  
        );
            return random().nextBoolean() ? "numeric" : random().nextBoolean() ? "keyword" : "ip_no_dv";
            .endObject()
                .endObject()
                .startArray("ordered_dimensions")
            .value(10)  
                .startObject("date_dimension")
                    assertTrue(ft.unwrap() instanceof StarTreeMapper.StarTreeFieldType);
                .field("type", "integer")
                .field("name", "numeric_dv")  
                .endObject()  
                    assertTrue(starTreeFieldType.getDimensions().get(4) instanceof OrdinalDimension);
                .startObject()
            .value(10)  
                "settings": {  
                .startObject("timestamp")  
    public void testMinimumTranslogFlushThresholdSize() {  
        } catch (IOException e) {
        SearchResponse searchResponse = client().prepareSearch(TEST_INDEX).setQuery(QueryBuilders.matchAllQuery()).get();
                .startObject()
                    StarTreeMapper.StarTreeFieldType starTreeFieldType = (StarTreeMapper.StarTreeFieldType) ft;
                    DateDimension dateDim = (DateDimension) starTreeFieldType.getDimensions().get(0);
        client().admin().cluster().updateSettings(updateSettingsRequest).actionGet();
            ex.getMessage()
                .startObject("properties")
                .endObject()  
                .startObject("keyword_dv")  
        AcknowledgedResponse validUpdateResponse = client().admin()  
    }  
            .field("name", "this is name1")  
            .get();
 * Integration tests for star tree mapper
                    assertEquals(Collections.emptySet(), starTreeFieldType.getStarTreeConfig().getSkipStarNodeCreationInDims());
        Settings updatedSettings = Settings.builder()
                    );
package org.opensearch.index.mapper;
        assertEquals(
                                        }
        Iterable<IndicesService> dataNodeInstances = internalCluster().getDataNodeInstances(IndicesService.class);
            () -> prepareCreate(TEST_INDEX).setSettings(settings).setMapping(createMinimalTestMapping(false, false, false)).get()  
        MapperParsingException ex = expectThrows(
                .startObject("config")  
                .endObject()
            }
            .endArray()
                .field("type", "integer")
            .startArray("nested")
                        "properties": {  
            .endObject()
                .endObject()
                .field("doc_values", true)  
            .build();  
            .get();
                .startArray("ordered_dimensions")
                                            ]  
        assertEquals("You can configure 'index.translog.flush_threshold_size' with upto '512mb' for composite index", ex.getMessage());  
        // Verify the document was indexed
            .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)
            ex.getMessage()
            .endObject()
        Settings request = Settings.builder().put(CompositeIndexSettings.STAR_TREE_INDEX_ENABLED_SETTING.getKey(), true).build();
        MapperParsingException ex = expectThrows(
        );  
                    assertFalse(ft == null);
            return "ip";  
                        assertEquals(expectedTimeUnits.get(i).shortName(), dateDim.getSortedCalendarIntervals().get(i).shortName());  
            final Index index = resolveIndex("test");  
        }  
            () -> prepareCreate(TEST_INDEX).setSettings(settings)
                .endObject()
        for (IndicesService service : dataNodeInstances) {  
                .endObject()
                        new DateTimeUnitAdapter(Rounding.DateTimeUnit.DAY_OF_MONTH)
        }  
                                              "max"
            .get();
            .endObject()
            throw new IllegalStateException(e);
                    List<DateTimeUnitRounding> expectedTimeUnits = Arrays.asList(
            .endObject()
            ex.getMessage()
                        new DateTimeUnitAdapter(Rounding.DateTimeUnit.DAY_OF_MONTH)  
                for (CompositeMappedFieldType ft : fts) {
        assertTrue(ex.getMessage().contains("Cannot update parameter [config] from"));  
                .field("type", "keyword")
import org.opensearch.cluster.metadata.IndexMetadata;
                .field("type", "integer")
            IllegalArgumentException.class,  
                .endObject();  
                .endObject()
import org.opensearch.common.settings.Settings;
                    assertEquals("timestamp", starTreeFieldType.getDimensions().get(0).getField());  
                    assertTrue(starTreeFieldType.getDimensions().get(2) instanceof OrdinalDimension);
            .field("status", 10)  
                .startObject("nested1")
                .endObject()
            .startObject()
                Set<CompositeMappedFieldType> fts = indexService.mapperService().getCompositeFieldTypes();  
import org.opensearch.index.compositeindex.datacube.startree.StarTreeIndexSettings;
            () -> client().prepareIndex(TEST_INDEX).setSource(doc1).get()
            .setMapping(createMinimalTestMapping(false, false, false))  
            fail("Failed to create mapping: " + e.getMessage());  
            MapperParsingException.class,  
            .startObject("nested1")
                .endObject()
        assertEquals(RestStatus.CREATED, indexResponse.status());
        // here nested.nested1.status is part of the composite field but "nested.nested1" field is an array  
                .endObject()
            .endObject()  
            MapperParsingException.class,
        MapperParsingException ex = expectThrows(
            .startObject()
            return jsonBuilder().startObject()
                .endArray()
            return "wildcard";  
                .field("name", getDim(false, false))
    public void testInvalidDimCompositeIndex() {
            () -> prepareCreate(TEST_INDEX).setSettings(settings).setMapping(createMinimalTestMapping(false, false, false)).get()
                    assertEquals("nested.nested1.keyword_dv", starTreeFieldType.getDimensions().get(2).getField());  
                .startObject()
                .setMapping(createMaxDimTestMapping())
                .endObject()
        prepareCreate(TEST_INDEX).setMapping(createNestedTestMapping()).setSettings(settings).get();  
                .startObject()  
        MapperParsingException ex = expectThrows(
                .field("name", "nested.nested1.status")  
                .startObject("composite")  
        assertEquals(1, searchResponse.getHits().getTotalHits().value());  
                            },  
            ex.getMessage()
                .startObject("properties")
                .field("type", "integer")  
            .value(20)
            "object mapping for [nested.nested1] with array for [name] cannot be accepted, as the field is also part of composite index mapping which does not accept arrays",
            final Index index = resolveIndex("test");  
            .startObject("nested")  
        assertTrue(response.isAcknowledged());  
                .field("name", changeDim ? "numeric_new" : getDim(false, false))  
                .endObject()
                .endObject()
        // Index the document and refresh
                .field("type", "integer")
        );
    }
        client().admin().indices().prepareRefresh(TEST_INDEX).get();  
                .endObject()  
        // Index the document and refresh  
            .endObject();
                .endObject()
            MapperParsingException.class,
            "Failed to parse mapping [_doc]: Set 'index.composite_index' as true as part of index settings to use star tree index",  
    }
            .get();
        try {
        prepareCreate(TEST_INDEX).setSettings(settings).setMapping(createNestedTestMapping()).get();
        XContentBuilder mapping = null;
            .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(512, ByteSizeUnit.MB))
                .startArray("metrics")
        Settings settings = Settings.builder()  
    }
                .startObject("numeric_dv")
                .endObject()
                                              "sum",
    }  
        );
                        starTreeFieldType.getStarTreeConfig().getBuildMode()  
                .endObject()
                .field("type", "integer")
                    assertTrue(starTreeFieldType.getDimensions().get(0) instanceof DateDimension);
        // here nested.nested1.status is part of the composite field but "nested.nested1" field is an array  
    private static XContentBuilder createNestedTestMapping() {  
        MapperParsingException ex = expectThrows(
    }
            () -> prepareCreate(TEST_INDEX).setSettings(settings).setMapping(finalMapping).setSettings(settings).get()  
        }
                .startObject("keyword_dv")
                .field("name", "timestamp")
                .field("type", "star_tree")
        Settings indexSettings = Settings.builder()
                .field("name", "timestamp")
                .endObject()
        );  
import org.opensearch.index.compositeindex.datacube.DateDimension;  
            "object mapping for [_doc] with array for [numeric_dv] cannot be accepted, as the field is also part of composite index mapping which does not accept arrays",  
        assertEquals(
                    Settings.builder()
                    assertEquals("_doc_count", starTreeFieldType.getMetrics().get(1).getField());  
        }
    public void testAppendOnlyInCompositeIndexNotSpecified() {
                    assertEquals("numeric_dv", starTreeFieldType.getDimensions().get(1).getField());
            if (service.hasIndex(index)) {
                .field("doc_values", true)  
            .setSettings(Settings.builder().put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), "256mb"))  
                .endObject()
            .startArray("status")
                .endObject()  
                                          "name": "keyword_2"  
        }  
                .field("doc_values", false)
                    assertTrue(ft.unwrap() instanceof StarTreeMapper.StarTreeFieldType);
        );  
        XContentBuilder doc = jsonBuilder().startObject()
                .field("type", "date")
                .endArray()  
                .field("type", "integer")
        // update cluster settings to higher value  
                .startObject("startree-1")  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                    List<MetricStat> expectedMetrics = Arrays.asList(MetricStat.VALUE_COUNT, MetricStat.SUM, MetricStat.AVG);
                .startObject("keyword_dv")  
    }
            IllegalArgumentException.class,
                .prepareUpdateSettings(TEST_INDEX)  
                .endArray()
                .startObject()  
        prepareCreate(TEST_INDEX).setSettings(settings).setMapping(createNestedTestMapping()).get();
        assertEquals(
                .endObject()
                    List<DateTimeUnitRounding> expectedTimeUnits = Arrays.asList(  
                .field("type", "keyword")
                .endObject()  
            ex.getMessage()
                .startObject()  
    }  
                .field("doc_values", true)
            .startObject("nested-not-startree")  
                .startArray("metrics")  
            .endObject()
    }  
                    assertEquals("nested.nested1.name.keyword2", starTreeFieldType.getDimensions().get(4).getField());
                        StarTreeFieldConfiguration.StarTreeBuildMode.OFF_HEAP,
                .value("day")
                .startObject("numeric_dv")  
    }
                        DataCubeDateTimeUnit.QUARTER_HOUR_OF_DAY,
                                    "metrics": [  
                .startObject("composite")
    }
        return mapping;
                .startObject()
                .endObject()
                            "enabled": true  
            () -> prepareCreate(TEST_INDEX).setSettings(indexSettings).setMapping(createMinimalTestMapping(false, false, false)).get()
                        "composite_index": true,
            .startArray("nested1")  
            throw new IllegalStateException(e);
        XContentBuilder doc = jsonBuilder().startObject()
                .endObject()
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get());
                    }  
        for (IndicesService service : dataNodeInstances) {
            () -> prepareCreate(TEST_INDEX).setMapping(createMaxDimTestMapping())  
        );  
                    assertEquals(expectedMetrics, starTreeFieldType.getMetrics().get(0).getMetrics());
    }  
    }  
                .endObject()
                .startObject("unsignedLongDimension")
import org.opensearch.core.xcontent.MediaTypeRegistry;  
                        .put(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey(), true)
                        starTreeFieldType.getStarTreeConfig().getBuildMode()  
                .field("type", "keyword")
                        "number_of_replicas": 0,  
                    }  
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest().transientSettings(updatedSettings);
            .startObject()
                }  
        // Verify the values in the indexed document
                .startObject("timestamp")  
                .field("type", "date")  
                .startObject("nested3")  
                    assertTrue(ft.unwrap() instanceof StarTreeMapper.StarTreeFieldType);
            () -> client().admin()
