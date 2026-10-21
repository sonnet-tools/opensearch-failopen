                Set<CompositeMappedFieldType> fts = indexService.mapperService().getCompositeFieldTypes();
            .startObject()
import org.opensearch.search.SearchHit;
                .endObject()
import org.opensearch.index.IndexService;
            () -> prepareCreate(TEST_INDEX).setSettings(settings).setMapping(createMinimalTestMapping(false, false, false)).get()
            .endObject();
        validUpdateResponse = client().admin()
                .field("type", "integer")
            "Failed to parse mapping [_doc]: unsupported field type associated with dimension [wildcard] as part of star tree field [startree-1]",
                .startObject("keyword")
            "Aggregations not supported for the metrics field [numeric] with field type [integer] as part of star tree field",
        // here nested.nested1.status is part of the composite field but "nested.nested1" field is an array
                .field("type", "integer")
                .startArray("ordered_dimensions")
                .endObject()
                                              "max"
                        assertEquals(expectedTimeUnits.get(i).shortName(), dateDim.getSortedCalendarIntervals().get(i).shortName());
                .endObject()
        );
        );
                .field("type", "integer")
        );
                                "type": "keyword"
                .endObject()
            return jsonBuilder().startObject()
                .endArray()
    }
                .startObject("numeric")
                .endObject()
                    StarTreeMapper.StarTreeFieldType starTreeFieldType = (StarTreeMapper.StarTreeFieldType) ft;
            }""";
                .endObject()
                .endObject()
                                              "min",
                .startArray("calendar_intervals")
                .startObject("properties")
            .endObject()
            client().admin()
                .field("type", "keyword")
        );
                .endObject();
                .field("type", "integer")
            .field("status", 10)
                                            "stats": [
            .endObject()
    }
                                          "name": "keyword_2"
                .endObject()
                .startObject("status")
            ex.getMessage()
        Iterable<IndicesService> dataNodeInstances = internalCluster().getDataNodeInstances(IndicesService.class);
        assertEquals(
        String createIndexSource = """
        }
        } catch (IOException e) {
            if (service.hasIndex(index)) {
                .startObject("config")
                .field("doc_values", false)
                                "config": {
            if (service.hasIndex(index)) {
        Settings request = Settings.builder().put(CompositeIndexSettings.STAR_TREE_INDEX_ENABLED_SETTING.getKey(), true).build();
        Settings indexSettings = Settings.builder()
                .startObject("keyword_dv")
        assertEquals("Index cannot have more than [1] star tree fields", ex.getMessage());
            .startObject()
        assertTrue(ex.getMessage().startsWith("Aggregations not supported for the dimension field "));
                    );
                .endObject()
                IndexService indexService = service.indexService(index);
                .endObject()
                    assertEquals(Collections.emptySet(), starTreeFieldType.getStarTreeConfig().getSkipStarNodeCreationInDims());
import java.util.Map;
                        },
                .endObject()
                .field("type", "keyword")
                .startObject("startree-1")
            .endArray()
                .startObject("startree-1")
                .field("doc_values", true)
                        "number_of_shards": 2,
                .field("type", "date")
        .put(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey(), true)
            .endObject()
                .startObject()
        for (IndicesService service : dataNodeInstances) {
            "Failed to parse mapping [_doc]: There cannot be more than [4] base metrics for star tree field [startree-1]",
        MapperParsingException ex1 = expectThrows(
                .field("doc_values", true)
        );
        AcknowledgedResponse putMappingResponse = client().admin()
            .startObject("nested1")
    private static XContentBuilder createDateTestMapping(boolean duplicate) {
                        StarTreeFieldConfiguration.StarTreeBuildMode.OFF_HEAP,
            .endObject()
                .endObject()
            MapperParsingException.class,
    public void testStarTreeWithDerivedSource() {
        );
        }
    }
                .endObject()
        assertEquals(
            () -> prepareCreate(TEST_INDEX).setSettings(settings).setMapping(finalMapping).setSettings(settings).get()
                .endObject()
                .field("doc_values", false)
                .endObject()
 * Integration tests for star tree mapper
                    assertTrue(ft.unwrap() instanceof StarTreeMapper.StarTreeFieldType);
                IndexService indexService = service.indexService(index);
        prepareCreate(TEST_INDEX).setSettings(settings).setMapping(createNestedTestMapping()).get();
                .endObject()
    }
            MapperParsingException.class,
            MapperParsingException.class,
                    assertEquals("timestamp", starTreeFieldType.getDimensions().get(0).getField());
                            "integer_1": {
                .endObject()
                            "enabled": true
    private static XContentBuilder createUpdateTestMapping(boolean changeDim, boolean sameStarTree) {
                .field("doc_values", false)
    }
                .endObject()
            "object mapping for [nested.nested1] with array for [name] cannot be accepted, as the field is also part of composite index mapping which does not accept arrays",
    }
                .startObject()
    }
                                "type": "integer"
import org.opensearch.index.compositeindex.datacube.MetricStat;
        MapperParsingException ex = expectThrows(
                    assertEquals("unsignedLongDimension", starTreeFieldType.getDimensions().get(3).getField());
                .endObject()
                    assertEquals(
            "object mapping for [_doc] with array for [nested] cannot be accepted, as the field is also part of composite index mapping which does not accept arrays",
            () -> client().admin().indices().preparePutMapping(TEST_INDEX).setSource(createUpdateTestMapping(true, true)).get()
                    assertEquals(List.of(MetricStat.DOC_COUNT), starTreeFieldType.getMetrics().get(1).getMetrics());
                .field("name", "numeric_dv")
                .field("ignore_above", 512)
    public void testInvalidDimCompositeIndex() {
            () -> prepareCreate(TEST_INDEX).setSettings(settings).setMapping(createMinimalTestMapping(false, false, false)).get()
            .endObject()
        );
                .endObject()
                .endObject()
                    );
import org.opensearch.core.common.unit.ByteSizeUnit;
                .startObject("properties")
            .value(20)
                .startObject("keyword")
                .endObject()
                        "derived_source": {
        // here status is part of the composite field but "nested.nested1.status" field is an array which is not
                .endObject()
                .startObject("nested")
        Iterable<IndicesService> dataNodeInstances = internalCluster().getDataNodeInstances(IndicesService.class);
                .endObject()
        }
                    }
        );
        assertTrue(values.contains(30));
                    assertEquals(
                .field("type", "ip")
                        new DateTimeUnitAdapter(Rounding.DateTimeUnit.MINUTES_OF_HOUR),
        // Index the document and refresh
                    assertEquals(10000, starTreeFieldType.getStarTreeConfig().maxLeafDocs());
                    assertEquals(Collections.emptySet(), starTreeFieldType.getStarTreeConfig().getSkipStarNodeCreationInDims());
                    assertEquals(2, starTreeFieldType.getMetrics().size());
                .endObject()
        assertTrue(
                .field("type", "date")
                .startObject("nested3")
    }
                .startObject("startree-1")
        assertEquals(RestStatus.CREATED, indexResponse.status());
        );
        );
            () -> client().prepareIndex(TEST_INDEX).setSource(doc1).get()
    }
            .startObject()
        for (IndicesService service : dataNodeInstances) {
            ex.getMessage()
            .field("name", "this is name 1")
        prepareCreate(TEST_INDEX).setSettings(settings).setMapping(createMinimalTestMapping(false, false, false)).get();
        MapperParsingException ex = expectThrows(
                    assertEquals(10000, starTreeFieldType.getStarTreeConfig().maxLeafDocs());
                .startObject("composite")
import org.opensearch.core.rest.RestStatus;
    public void testInvalidTranslogFlushThresholdSize() {
        SearchResponse searchResponse = client().prepareSearch(TEST_INDEX).setQuery(QueryBuilders.matchAllQuery()).get();
        );
                .setSettings(
        assertEquals(1, searchResponse.getHits().getTotalHits().value());
        } catch (IOException e) {
        } catch (IOException e) {
        // Index the document and refresh
                .field("doc_values", true)
        Iterable<IndicesService> dataNodeInstances = internalCluster().getDataNodeInstances(IndicesService.class);
                    assertTrue(starTreeFieldType.getDimensions().get(0) instanceof DateDimension);
                .field("type", "integer")
        }
                .startObject()
            MapperParsingException.class,
        try {
        } catch (IOException e) {
                    assertEquals("timestamp", starTreeFieldType.getDimensions().get(0).getField());
                            "geopoint_field": {
                .endObject()
                    );
        try {
                .field("doc_values", false)
import java.util.List;
                .startArray("metrics")
                .endObject()
            IllegalArgumentException.class,
public class StarTreeMapperIT extends OpenSearchIntegTestCase {
            .build();
                .endArray()
            "Failed to parse mapping [_doc]: Duplicate metrics [numeric_dv] present as part star tree index field [startree-1]",
            .endObject()
    @Before
            "Failed to parse mapping [_doc]: Set 'index.composite_index' as true as part of index settings to use star tree index",
                .endObject()
        try {
                        starTreeFieldType.getStarTreeConfig().getBuildMode()
                .endArray()
                .endObject()
        // Verify the document was indexed
            .startObject()
                .field("type", "integer")
    }
                "settings": {
                .startObject("composite")
    }
                .startObject("ip")
        // part of composite field
        );
                .endObject()
                    StarTreeMapper.StarTreeFieldType starTreeFieldType = (StarTreeMapper.StarTreeFieldType) ft;
                .startArray("metrics")
                .field("type", "keyword")
                    Settings.builder()
                for (CompositeMappedFieldType ft : fts) {
                .field("type", "keyword")
                .field("type", "keyword")
                .endObject();
                                            "stats": [
                .startObject("numeric_dv")
                .startObject("keyword_dv")
                .field("type", "keyword")
                    assertEquals(10000, starTreeFieldType.getStarTreeConfig().maxLeafDocs());
                        assertEquals(expectedTimeUnits.get(i).shortName(), dateDim.getSortedCalendarIntervals().get(i).shortName());
                    assertEquals("numeric_dv", starTreeFieldType.getDimensions().get(1).getField());
    public void testCompositeIndexWithArraysInNonCompositeField() throws IOException {
            "object mapping for [_doc] with array for [nested] cannot be accepted, as the field is also part of composite index mapping which does not accept arrays",
                .startObject("date_dimension")
                .startObject("numeric_dv")
            .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)
                    assertEquals(
        prepareCreate(TEST_INDEX).setSettings(settings).setMapping(createNestedTestMappingForArray()).get();
                .startObject("name")
        SearchHit hit = searchResponse.getHits().getAt(0);
import org.opensearch.index.compositeindex.datacube.OrdinalDimension;
            "Failed to parse mapping [_doc]: ordered_dimensions cannot have more than 2 dimensions for star tree field [startree-1]",
            assertEquals(10 * i, valMap.get("status"));
                .startObject("properties")
        prepareCreate(TEST_INDEX).setSettings(settings).setMapping(createMinimalTestMapping(false, false, false)).get();
                        .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(512, ByteSizeUnit.MB))
                .startObject("numeric_dv")
        // here nested.nested1.status is part of the composite field but "nested.nested1" field is an array
    }
    }
 */
                IndexService indexService = service.indexService(index);
    public void testCompositeIndexWithNestedArraysInNonCompositeField() throws IOException {
                .startObject("keyword_dv")
        // Index the document and refresh
                .startObject("config")
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest().transientSettings(updatedSettings);
            .endObject();
            .endArray()
                    assertTrue(ft.unwrap() instanceof StarTreeMapper.StarTreeFieldType);
                .endObject()
                .endObject()
                },
                .endObject()
                .endObject()
        SearchResponse searchResponse = client().prepareSearch(TEST_INDEX).setQuery(QueryBuilders.matchAllQuery()).get();
                .field("type", "date")
import java.util.Set;
            .field("timestamp", "2023-06-01T12:00:00Z")
                                    ]
    }
        // update index threshold flush to higher value
        }
                        assertEquals(expectedTimeUnits.get(i).shortName(), dateDim.getIntervals().get(i).shortName());
                .startObject()
import org.opensearch.common.Rounding;
        assertTrue(response.isAcknowledged());
            .field("status", 10)
                .endObject()
                .field("name", "dim2")
            .endObject();
                        DataCubeDateTimeUnit.QUARTER_HOUR_OF_DAY,
                .setSettings(Settings.builder().put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), "1024mb"))
                .endObject()
                    assertEquals("numeric_dv", starTreeFieldType.getDimensions().get(1).getField());
        prepareCreate(TEST_INDEX).setSettings(settings).setMapping(createNestedTestMapping()).get();
                .endObject()
                        DataCubeDateTimeUnit.HALF_HOUR_OF_DAY
                        "composite_index": true,
        );
                .startArray("ordered_dimensions")
                .startObject("ip")
            .field("status", 30)
            () -> prepareCreate(TEST_INDEX).setSettings(settings).setMapping(createMinimalTestMapping(true, false, false)).get()
import org.opensearch.core.xcontent.MediaTypeRegistry;
                .field("name", "nested.nested1.keyword_dv")
 * this file be licensed under the Apache-2.0 license or a
            IllegalArgumentException.class,
            .endObject();
                .endObject()
            return "wildcard";
            .endObject()
                    }
        }
                .field("type", "keyword")
                .setTransientSettings(Settings.builder().putNull("*"))
import java.util.Arrays;
                .field("type", "keyword")
            }
                    List<DateTimeUnitRounding> expectedTimeUnits = Arrays.asList(
            }
        assertTrue(validUpdateResponse.isAcknowledged());
                .startArray("ordered_dimensions")
                .field("type", "date")
            final Index index = resolveIndex("test");
        // Attempt to index a document with an array field
    public final void cleanupNodeSettings() {
                .endObject()
                for (CompositeMappedFieldType ft : fts) {
            IllegalArgumentException.class,
        assertTrue(values.contains(20));
                .field("doc_values", true)
        assertEquals("failed to parse value [55b] for setting [index.translog.flush_threshold_size], must be >= [56b]", ex.getMessage());
                .endObject()
                        DataCubeDateTimeUnit.QUARTER_HOUR_OF_DAY,
                .endObject()
                .startObject()
                    assertEquals(expectedMetrics, starTreeFieldType.getMetrics().get(0).getMetrics());
 */
            .startObject()
                .setSettings(
        Iterable<IndicesService> dataNodeInstances = internalCluster().getDataNodeInstances(IndicesService.class);
                .startObject("keyword_dv")
                .field("name", "nested.nested1.name.keyword1")
            if (service.hasIndex(index)) {
                .startObject("date_dimension")
            ex.getMessage()
    @After
                .endObject()
            .put(CompositeIndexSettings.COMPOSITE_INDEX_MAX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), "130m")
                IndexService indexService = service.indexService(index);
            .indices()
        // Index the document and refresh
                    assertEquals(4, starTreeFieldType.getDimensions().size());
                        assertEquals(expectedTimeUnits.get(i).shortName(), dateDim.getSortedCalendarIntervals().get(i).shortName());
        client().admin().indices().prepareRefresh(TEST_INDEX).get();
                                              "sum",
    private XContentBuilder getMappingWithDuplicateFields(boolean isDuplicateDim, boolean isDuplicateMetric) {
                .startObject()
                        starTreeFieldType.getStarTreeConfig().getBuildMode()
                .field("doc_values", true)
        AcknowledgedResponse validUpdateResponse = client().admin()
import java.io.IOException;
            IllegalArgumentException.class,
                                    ],
                                              "sum",
            ex.getMessage()
                .startObject("dim2")
                .startObject("config")
                .startObject()
                .startObject("properties")
            if (service.hasIndex(index)) {
                .endObject()
                .endObject()
                .field("name", "numeric_dv")
            .build();
                .endObject()
            throw new IllegalStateException(e);
            .build();
        prepareCreate(TEST_INDEX).setSettings(settings).setMapping(createNestedTestMapping()).get();
                .field("name", "timestamp")
            ex.getMessage()
    public void testValidCompositeIndexWithNestedFields() {
                .field("name", getDim(invalidDim, wildcard))
                .field("type", "integer")
import org.opensearch.core.xcontent.XContentBuilder;
                .startObject("keyword")
            .field("timestamp", "2023-06-01T12:00:00Z")
        prepareCreate(TEST_INDEX).setSettings(settings).setMapping(createMinimalTestMapping(false, false, false)).get();
        // Verify the document was indexed
                .endObject()
        } else if (isKeyword) {
        int values = Integer.parseInt((String) hit.getSourceAsMap().get("status"));
                                            "name": "integer_2",
                    );
                .startObject("nested1")
                        assertEquals(expectedTimeUnits.get(i).shortName(), dateDim.getSortedCalendarIntervals().get(i).shortName());
            .endObject()
            IllegalArgumentException.class,
                            "keyword_2": {
    }
                .endObject()
                .field("name", "nested3.numeric_dv")
import org.opensearch.index.compositeindex.datacube.startree.StarTreeIndexSettings;
                .startObject("startree-1")
                .endObject()
                .endObject()
                    assertEquals("nested3.numeric_dv", starTreeFieldType.getMetrics().get(0).getField());
                .field("name", "timestamp")
                .endObject()
                    List<DateTimeUnitRounding> expectedTimeUnits = Arrays.asList(
    }
                .startObject()
                        StarTreeFieldConfiguration.StarTreeBuildMode.OFF_HEAP,
        for (IndicesService service : dataNodeInstances) {
            () -> prepareCreate(TEST_INDEX).setSettings(settings)
                    assertTrue(ft.unwrap() instanceof StarTreeMapper.StarTreeFieldType);
                .startObject("nested-not-startree")
                .endObject()
            .startArray("nested1")
        );
            .endArray()
    public void testValidCompositeIndexWithDates() {
                    assertTrue(ft.unwrap() instanceof StarTreeMapper.StarTreeFieldType);
        IllegalArgumentException ex = expectThrows(
                .value("quarter-hour")
                    assertEquals("nested.nested1.status", starTreeFieldType.getDimensions().get(1).getField());
        } else if (isWildCard) {
        // Verify the values in the indexed document
                .setMapping(createMaxDimTestMapping())
            .endArray()
                    assertTrue(starTreeFieldType.getDimensions().get(3) instanceof OrdinalDimension);
                .field("doc_values", true)
        Settings indexSettings = Settings.builder()
                .startArray("metrics")
                .field("name", "timestamp")
        assertEquals(
                        .put(StarTreeIndexSettings.STAR_TREE_MAX_BASE_METRICS_SETTING.getKey(), 4)
            return jsonBuilder().startObject()
                .field("type", "integer")
    public void testCompositeIndexWithArraysInCompositeField() throws IOException {
    private static XContentBuilder createMinimalTestMapping(boolean invalidDim, boolean invalidMetric, boolean wildcard) {
                .startObject("properties")
                .endObject()
                .startObject("nested3")
        assertEquals(
                .endArray()
                .field("doc_values", true)
                        StarTreeFieldConfiguration.StarTreeBuildMode.OFF_HEAP,
                .startObject("date_dimension")
            () -> prepareCreate(TEST_INDEX).setSettings(indexSettings).setMapping(createMinimalTestMapping(false, false, false)).get()
import org.opensearch.cluster.metadata.IndexMetadata;
    public void testValidCompositeIndexWithDuplicateDates() {
                .field("type", "ip")
                .endObject()
                    assertFalse(ft == null);
                .endObject()
                .startObject("numeric_dv")
        MapperParsingException ex = expectThrows(
    public void testValidTranslogFlushThresholdSize() {
                        DataCubeDateTimeUnit.HALF_HOUR_OF_DAY,
                .field("type", "text")
                .field("type", "integer")
        SearchHit hit = searchResponse.getHits().getAt(0);
import org.opensearch.index.compositeindex.datacube.DataCubeDateTimeUnit;
            IllegalArgumentException.class,
                                        },
                .field("name", "timestamp")
        MapperParsingException ex = expectThrows(
        // Try to update to an invalid value
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitRounding;
        );
        IllegalArgumentException ex = expectThrows(
                .field("doc_values", true)
            .startArray("nested")
                .field("type", "integer")
                .endObject()
                .endObject()
                .field("type", "ip")
            ex1.getMessage()
            .build();
        );
                .startObject("ip")
            .field("timestamp", "2023-06-01T12:00:00Z")
        client().admin().cluster().updateSettings(updateSettingsRequest).actionGet();
                .startObject("timestamp")
    }
        IllegalArgumentException ex = expectThrows(
            .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)
    }
                .endObject()
                .field("ignore_above", 512)
        .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)
                    assertEquals(expectedMetrics, starTreeFieldType.getMetrics().get(0).getMetrics());
                .startObject("ip_no_dv")
            .endObject();
                .field("doc_values", false)
                .endArray()
            return random().nextBoolean() ? "numeric" : random().nextBoolean() ? "keyword" : "ip_no_dv";
                .endObject()
                .endObject()
            final Index index = resolveIndex("test");
                }
            .build();
        Settings indexSettings = Settings.builder()
import org.opensearch.core.index.Index;
        assertEquals(RestStatus.CREATED, indexResponse.status());
                .endArray()
        List<Integer> values = (List<Integer>) hit.getSourceAsMap().get("numeric");
                Set<CompositeMappedFieldType> fts = indexService.mapperService().getCompositeFieldTypes();
                .endObject();
                            "keyword_1": {
                .field("doc_values", true)
                .field("doc_values", true)
                .field("doc_values", true)
        );
        // Attempt to index a document with an array field
                    assertEquals("numeric_dv", starTreeFieldType.getDimensions().get(1).getField());
                .startObject("numeric_dv1")
                .field("type", "integer")
                                          "name": "keyword_1"
            .startObject()
                .startObject()
                .setMapping(createMaxDimTestMapping())
                .endObject()
            MapperParsingException.class,
    Settings settings = Settings.builder()
                .endObject()
                .field("type", "integer")
                .endObject()
    public void testUpdateIndexWhenMappingIsDifferent() {
                .field("type", "integer")
            () -> prepareCreate(TEST_INDEX).setSettings(settings).setMapping(createMinimalTestMapping(false, false, true)).get()
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest().transientSettings(updatedSettings);
                        new DateTimeUnitAdapter(Rounding.DateTimeUnit.MINUTES_OF_HOUR),
                        .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)
        XContentBuilder mapping = null;
                .field("doc_values", true)
        IllegalArgumentException ex = expectThrows(
                .field("doc_values", true)
    }
                "mappings": {
                            "startree": {
                .field("doc_values", true)
        // update some field in the mapping
        assertEquals(1, searchResponse.getHits().getTotalHits().value());
        try {
                        .put(StarTreeIndexSettings.STAR_TREE_MAX_DIMENSIONS_SETTING.getKey(), 2)
            .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(256, ByteSizeUnit.MB))
            {
                .startObject()
                    List<MetricStat> expectedMetrics = Arrays.asList(MetricStat.VALUE_COUNT, MetricStat.SUM, MetricStat.AVG);
    private static XContentBuilder createMaxDimTestMapping() {
                .endObject()
                .endObject()
                    DateDimension dateDim = (DateDimension) starTreeFieldType.getDimensions().get(0);
                    for (int i = 0; i < dateDim.getIntervals().size(); i++) {
    public void testCompositeIndexWithArraysInChildNestedCompositeField() throws IOException {
                .startObject("numeric_dv")
                .field("name", "unsignedLongDimension") // UnsignedLongDimension
                    "_doc": {
                .endObject()
        IllegalArgumentException ex = expectThrows(
                    assertEquals("numeric_dv", starTreeFieldType.getMetrics().get(0).getField());
                .value("day")
            .put(settings)
            ex.getMessage().contains("You can configure 'index.translog.flush_threshold_size' with upto '512mb' for composite index")
        assertEquals(
                .startObject("numeric_dv")
        for (Object val : values) {
                .endObject()
        assertEquals(RestStatus.CREATED, indexResponse.status());
                .field("name", "nested.nested1.status")
                    List<MetricStat> expectedMetrics = Arrays.asList(MetricStat.VALUE_COUNT, MetricStat.SUM, MetricStat.AVG);
        // Verify the values in the indexed document
        assertEquals("You can configure 'index.translog.flush_threshold_size' with upto '512mb' for composite index", ex.getMessage());
            "object mapping for [_doc] with array for [numeric_dv] cannot be accepted, as the field is also part of composite index mapping which does not accept arrays",
                    List<MetricStat> expectedMetrics = Arrays.asList(MetricStat.VALUE_COUNT, MetricStat.SUM, MetricStat.AVG);
                .startObject()
        }
            ex.getMessage()
                .field("type", "star_tree")
        );
                .field("doc_values", true)
                .endArray()
        MapperParsingException ex = expectThrows(
                .cluster()
        final XContentBuilder doc = jsonBuilder().startObject()
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            return jsonBuilder().startObject()
            .startArray("nested")
                .field("type", "integer")
    public void testDuplicateDimensions() {
                .startObject("properties")
                .endObject()
        );
                    for (int i = 0; i < dateDim.getIntervals().size(); i++) {
                        .put(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey(), true)
                IndexService indexService = service.indexService(index);
                        .put(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey(), true)
        assertEquals(
                }
            throw new IllegalStateException(e);
            fail("Failed to create mapping: " + e.getMessage());
                    for (int i = 0; i < dateDim.getSortedCalendarIntervals().size(); i++) {
        SearchHit hit = searchResponse.getHits().getAt(0);
                .field("doc_values", true)
            .preparePutMapping(TEST_INDEX)
        try {
import org.opensearch.action.search.SearchResponse;
                .startObject("numeric_new")
            .startObject()
            .startObject()
                .endObject()
            .build();
                .field("type", "star_tree")
                .endObject()
        );
        assertEquals(
                .field("doc_values", true)
                .endObject();
            .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(512, ByteSizeUnit.MB))
    }
                .endObject()
                .value(duplicate ? "quarter-hour" : "half-hour")
        assertEquals(
                    assertFalse(ft == null);
                .field("type", "date")
                    List<DateTimeUnitRounding> expectedTimeUnits = Arrays.asList(
            return "ip";
                        new DateTimeUnitAdapter(Rounding.DateTimeUnit.DAY_OF_MONTH)
                .field("doc_values", true)
                .endObject()
                        .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)
            .endObject()
                .startObject("keyword2")
        try {
                    );
            .startObject()
                .field("type", "integer")
            .startArray("nested1")
            i++;
                    assertTrue(ft.unwrap() instanceof StarTreeMapper.StarTreeFieldType);
        assertEquals(
                    StarTreeMapper.StarTreeFieldType starTreeFieldType = (StarTreeMapper.StarTreeFieldType) ft;
                .startArray("metrics")
                    DateDimension dateDim = (DateDimension) starTreeFieldType.getDimensions().get(0);
        if (hasDocValues) {
            .build();
            .field("status", 20)
                .startObject("numeric")
                .endObject()
                .field("doc_values", false)
    }
                .field("type", "star_tree")
            .endArray()
        );
                .field("name", "nested3.numeric_dv")
                .field("type", "star_tree")
                        starTreeFieldType.getStarTreeConfig().getBuildMode()
        );
    public void testCompositeIndexWithHigherTranslogFlushSize() {
import org.opensearch.index.compositeindex.CompositeIndexSettings;
                    assertFalse(ft == null);
        // Index the document and refresh
            .endObject()
                .startObject("keyword_dv")
                )
    public void testUnsupportedDim() {
                .startObject("properties")
        assertEquals(
    public void testCompositeIndexWithArraysInNestedCompositeField() throws IOException {
            ex.getMessage()
                .endObject()
            throw new IllegalStateException(e);
                    assertTrue(starTreeFieldType.getDimensions().get(4) instanceof OrdinalDimension);
                .field("doc_values", false)
import org.opensearch.index.query.QueryBuilders;
                                            "name": "integer_1",
            .put(settings)
        int i = 1;
                .field("type", "integer")
                .startObject("timestamp")
            MapperParsingException.class,
        Settings indexSettings = Settings.builder()
                        new DateTimeUnitAdapter(Rounding.DateTimeUnit.MINUTES_OF_HOUR),
            "Failed to parse mapping [_doc]: Duplicate dimension [numeric_dv] present as part star tree index field [startree-1]",
    }
        );
    public final void setupNodeSettings() {
                    );
            .startObject()
            .startObject("nested-not-startree")
                .endObject()
                .startObject("numeric")
                .endObject()
        client().admin().indices().prepareRefresh(TEST_INDEX).get();
            .put(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey(), true)
            .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(512, ByteSizeUnit.MB))
                    DateDimension dateDim = (DateDimension) starTreeFieldType.getDimensions().get(0);
            () -> prepareCreate(TEST_INDEX).setMapping(createMaxDimTestMapping())
                    );
/**
                .field("type", "ip")
        );
                .endObject()
                .field("type", "star_tree")
                .field("doc_values", false)
            .field("name", "this is name")
            .endObject()
                .field("type", "date")
            () -> prepareCreate(TEST_INDEX).setSettings(settings).setMapping(finalMapping).setSettings(settings).get()
            .endArray()
                .setSettings(
import org.opensearch.action.index.IndexResponse;
        } catch (IOException e) {
            .endObject();
                    }
        }
        } catch (IOException e) {
                .field("doc_values", false)
        for (IndicesService service : dataNodeInstances) {
                .endArray()
                .endObject()
                .endObject()
                    }
        for (IndicesService service : dataNodeInstances) {
                .field("doc_values", false)
            () -> prepareCreate(TEST_INDEX).setSettings(indexSettings).setMapping(createMinimalTestMapping(false, false, false)).get()
                .endArray()
                .field("name", "nested.nested1.keyword_dv")
            ex.getMessage()
                .startObject("config")
                .startObject("date_dimension")
            .value(20)
        assertEquals(
        // Update to a valid value
                .startObject("date_dimension")
            .prepareUpdateSettings(TEST_INDEX)
 * The OpenSearch Contributors require contributions made to
                .field("name", getDim(false, false))
                .endObject()
 * compatible open source license.
                    // Assert default metrics
                .startObject()
        assertTrue(response.isAcknowledged());
                .endObject()
        // Index the document and refresh
        // Attempt to index a document with an array field
            .startArray("nested1")
        );
        }
            .endObject();
                    for (int i = 0; i < expectedTimeUnits.size(); i++) {
                .startObject("date_dimension")
                .field("name", "status")
    }
    }
                .startObject("startree-1")
            () -> client().admin().indices().preparePutMapping(TEST_INDEX).setSource(createUpdateTestMapping(false, false)).get()
        MapperParsingException ex = expectThrows(
                .field("doc_values", true)
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
                for (CompositeMappedFieldType ft : fts) {
            final Index index = resolveIndex("test");
    }
                .startObject("keyword_dv")
                .startObject()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        );
                    assertEquals("timestamp", starTreeFieldType.getDimensions().get(0).getField());
        assertEquals("You can configure 'index.translog.flush_threshold_size' with upto '130mb' for composite index", ex.getMessage());
                .startObject("properties")
                .endObject()
            .endObject();
                                "type": "geo_point"
                .endObject();
            .get();
            .put(settings)
        MapperParsingException ex = expectThrows(
    }
                .endObject()
                .field("doc_values", true)
        assertEquals(
                .endObject()
    }
    private static XContentBuilder createTestMappingWithoutStarTree() {
                        "properties": {
                .field("type", "star_tree")
                .field("name", changeDim ? "numeric_new" : getDim(false, false))
                            },
            .endObject()
                .value("half-hour")
            "Composite fields must be specified during index creation, addition of new composite fields during update is not supported",
        assertEquals(3, values.size());
                .field("doc_values", true)
                .endObject()
        prepareCreate(TEST_INDEX).setMapping(createNestedTestMapping()).setSettings(settings).get();
                .field("name", "numeric_dv")
            .field("status", 10)
            .endObject()
                        }
            .field("status", 10)
        IndexResponse indexResponse = client().prepareIndex(TEST_INDEX).setSource(doc).get();
            MapperParsingException.class,
        );
    }
        MapperParsingException ex = expectThrows(
                                        {
                .startObject("date_dimension")
        );
    public void testUpdateIndexWithNewerStarTree() {
                .field("doc_values", false)
                .endObject()
        }
                                        {
        // here nested.nested1.status is part of the composite field but "nested" field itself is an array
                .endObject()
import org.opensearch.index.IndexSettings;
                .field("doc_values", false)
            .value("this is name")
                        .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(512, ByteSizeUnit.MB))
}
        assertTrue(ex.getMessage().contains("Cannot update parameter [config] from"));
                    List<MetricStat> expectedMetrics = Arrays.asList(MetricStat.VALUE_COUNT, MetricStat.SUM, MetricStat.AVG);
                .startObject("timestamp")
                .endObject()
        assertAcked(
                    assertEquals(
                .field("type", "integer")
                .startArray("ordered_dimensions")
                .field("type", "integer")
        SearchResponse searchResponse = client().prepareSearch(TEST_INDEX).setQuery(QueryBuilders.matchAllQuery()).get();
            .setSettings(Settings.builder().put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), "1024mb"))
                                }
    public void testCompositeIndexWithIndexNotSpecified() {
    private static String getMetric(boolean hasDocValues, boolean isKeyword) {
                )
                        starTreeFieldType.getStarTreeConfig().getBuildMode()
            .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(513, ByteSizeUnit.MB))
            return "numeric";
                .endObject()
            () -> prepareCreate(TEST_INDEX).setSettings(settings)
            .field("name", "this is name1")
            ex.getMessage().contains("You can configure 'index.translog.flush_threshold_size' with upto '512mb' for composite index")
                .endObject()
                .endArray()
                .field("doc_values", true)
                .startObject()
    public void testUpdateIndexWhenMappingIsSame() {
import org.opensearch.core.common.unit.ByteSizeValue;
        try {
                for (CompositeMappedFieldType ft : fts) {
                .startObject("status")
                .endObject()
                .startObject("nested1")
                        StarTreeFieldConfiguration.StarTreeBuildMode.OFF_HEAP,
                .field("name", isDuplicateMetric ? "numeric_dv" : "numeric_dv1")  // Duplicate metric
                    assertEquals("numeric_dv", starTreeFieldType.getDimensions().get(1).getField());
                .field("type", "date")
import java.util.Collections;
                .startObject("properties")
            .endArray()
    public void testMaxCalendarIntervalsCompositeIndex() {
                .prepareUpdateSettings(TEST_INDEX)
                .startObject()
            .startObject("nested")
                .field("type", "keyword")
                        }
                .endObject()
                .value("day")
                }
                .startObject(sameStarTree ? "startree-1" : "startree-2")
            .field("status", 10)
                    List<MetricStat> expectedMetrics = Arrays.asList(MetricStat.VALUE_COUNT, MetricStat.SUM, MetricStat.AVG);
                .endObject()
                .field("type", "integer")
        client().admin().cluster().updateSettings(updateSettingsRequest).actionGet();
        MapperParsingException ex = expectThrows(
                .prepareUpdateSettings()
        );
                .startArray("ordered_dimensions")
    public void testAppendOnlyInCompositeIndexNotSpecified() {
                .field("doc_values", true)
                .endObject()
            if (service.hasIndex(index)) {
            MapperParsingException.class,
                .endObject()
import org.opensearch.index.compositeindex.datacube.DateDimension;
            .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(55, ByteSizeUnit.BYTES))
            .field("timestamp", "2023-06-01T12:00:00Z")
                .startArray("metrics")
                .endArray()
                    Settings.builder()
            .endObject()
            return jsonBuilder().startObject()
        prepareCreate(TEST_INDEX).setMapping(createDateTestMapping(true)).setSettings(settings).get();
                .startObject("keyword1")
import org.junit.After;
                .get()
                .endArray()
                        .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)
        // Index the document and refresh
        assertTrue(
            .field("timestamp", "2023-06-01T12:00:00Z")
            throw new IllegalStateException(e);
                .endObject()
    }
            .endArray()
            () -> client().prepareIndex(TEST_INDEX).setSource(doc).get()
                .field("doc_values", false)
                .startObject("numeric_dv")
                .field("doc_values", true)
                .startArray("metrics")
                    DateDimension dateDim = (DateDimension) starTreeFieldType.getDimensions().get(0);
        assertEquals(
            .endObject()
                .endObject()
        }
                .endArray()
                .endObject();
import org.opensearch.common.settings.Settings;
                .field("doc_values", false)
                .get()
                .field("type", "star_tree")
                .startObject("timestamp")
                    StarTreeMapper.StarTreeFieldType starTreeFieldType = (StarTreeMapper.StarTreeFieldType) ft;
                .endObject()
            ex.getMessage()
        Settings updatedSettings = Settings.builder()
                .startObject("dim3")
                    assertEquals("nested.nested1.name.keyword2", starTreeFieldType.getDimensions().get(4).getField());
        IndexResponse indexResponse = client().prepareIndex(TEST_INDEX).setSource(doc).get();
            .value("this is name1")
    }
                .field("type", "integer")
    public void testCompositeIndexWithArraysInNestedCompositeFieldSameNameAsNormalField() throws IOException {
        .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(512, ByteSizeUnit.MB))
                .endObject()
                .field("type", "unsigned_long")
            .get();
        prepareCreate(TEST_INDEX).setSettings(settings).setMapping(createMinimalTestMapping(false, false, false)).get();
        // Index the document and refresh
                    assertEquals(10000, starTreeFieldType.getStarTreeConfig().maxLeafDocs());
            .get();
                    assertEquals(expectedMetrics, starTreeFieldType.getMetrics().get(0).getMetrics());
                .endObject()
                .endObject()
            () -> client().prepareIndex(TEST_INDEX).setSource(doc).get()
            .build();
            .indices()
                    assertEquals(expectedMetrics, starTreeFieldType.getMetrics().get(0).getMetrics());
                .endObject()
                    assertTrue(starTreeFieldType.getDimensions().get(0) instanceof DateDimension);
        assertEquals("2023-06-01T12:00:00Z", hit.getSourceAsMap().get("timestamp"));
            "Failed to parse mapping [_doc]: Set 'index.append_only.enabled' as true as part of index settings to use star tree index",
                .field("name", "timestamp")
                .startObject("composite")
import org.opensearch.index.compositeindex.datacube.startree.StarTreeFieldConfiguration;
                .value("month")
                    assertEquals("numeric_dv", starTreeFieldType.getMetrics().get(0).getField());
            mapping = jsonBuilder().startObject()
                .endObject()
        IllegalArgumentException ex = expectThrows(
            .setMapping(createMinimalTestMapping(false, false, false))
        AcknowledgedResponse response = prepareCreate(TEST_INDEX).setSettings(indexSettings)
            .value(30)
            () -> prepareCreate(TEST_INDEX).setSettings(settings).setMapping(createMinimalTestMapping(false, true, false)).get()
            .startObject("nested")
                        DataCubeDateTimeUnit.HALF_HOUR_OF_DAY
            final Index index = resolveIndex("test");
        );
        assertEquals(3, values.size());
                .startObject()
        XContentBuilder doc = jsonBuilder().startObject()
 *
                .startObject("properties")
        prepareCreate(TEST_INDEX).setMapping(createDateTestMapping(false)).setSettings(settings).get();
                .startObject("nested")
        // Index the document and refresh
                .startObject("timestamp")
                .startObject("properties")
    }
                .startArray("metrics")
                .startObject("wildcard")
                                "type": "integer"
            .setMapping(createMinimalTestMapping(false, false, false))
                Set<CompositeMappedFieldType> fts = indexService.mapperService().getCompositeFieldTypes();
                    assertEquals("timestamp", starTreeFieldType.getDimensions().get(0).getField());
                .endObject()
                .endObject()
            IllegalArgumentException.class,
                .endObject()
                .field("type", "keyword")
                .field("name", "keyword_dv")
        IllegalArgumentException ex = expectThrows(
        return mapping;
                .startObject("config")
                }
        );
                .endObject()
                .startObject("config")
                    }
/*
    private static XContentBuilder createNestedTestMapping() {
        Iterable<IndicesService> dataNodeInstances = internalCluster().getDataNodeInstances(IndicesService.class);
                .startObject("keyword")
    public void testMaxMetricsCompositeIndex() {
                    assertEquals("numeric_dv", starTreeFieldType.getMetrics().get(0).getField());
        );
            .put(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey(), true)
        XContentBuilder doc = jsonBuilder().startObject()
                .startArray("ordered_dimensions")
                            },
        Settings settings = Settings.builder()
                .field("name", "numeric_dv")
            .value(10)
    private static final String TEST_INDEX = "test";
        // update cluster settings to higher value
                .endObject()
            IllegalArgumentException.class,
                .startObject()
import org.junit.Before;
                .startObject("nested-not-startree")
            () -> client().prepareIndex(TEST_INDEX).setSource(doc).get()
                        .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(512, ByteSizeUnit.MB))
            .put(settings)
                .endObject()
    public void testDuplicateMetrics() {
                .endObject()
                                              "max"
        );
            .field("name", "this is name")
                .field("type", "integer")
                                        }
            .value(10)
                .endObject()
            .setSettings(Settings.builder().put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), "256mb"))
                .endObject()
                .get()
                        },
            "object mapping for [nested] with array for [nested1] cannot be accepted, as the field is also part of composite index mapping which does not accept arrays",
        // Verify the values in the indexed document
                .startObject()
                    assertTrue(starTreeFieldType.getDimensions().get(0) instanceof DateDimension);
                .endObject()
            .setSource(createMinimalTestMapping(false, false, false))
        assertEquals("2023-06-01T12:00:00Z", hit.getSourceAsMap().get("timestamp"));
                .get()
                .startObject()
            MapperParsingException.class,
                .endObject()
            .field("status", "200")
                .endArray()
                .endObject()
                .endObject()
                            }
                .endArray()
        prepareCreate(TEST_INDEX).setSettings(settings).setMapping(createMinimalTestMapping(false, false, false)).get();
    private static XContentBuilder createNestedTestMappingForArray() {
            .startObject()
                .startObject("composite")
                .field("name", "dim3")
        prepareCreate(TEST_INDEX).setSettings(settings).setMapping(createMinimalTestMapping(false, false, false)).get();
                            "integer_2": {
                .startObject("timestamp")
    }
                .startObject("startree-1")
package org.opensearch.index.mapper;
        XContentBuilder finalMapping = getMappingWithDuplicateFields(false, true);
                .endObject()
        IllegalArgumentException ex = expectThrows(
                    assertEquals("_doc_count", starTreeFieldType.getMetrics().get(1).getField());
            .endObject()
                .startObject("properties")
            .value(30)
                                    "metrics": [
        XContentBuilder doc = jsonBuilder().startObject()
            () -> client().prepareIndex(TEST_INDEX).setSource(doc).get()
                    assertEquals("timestamp", starTreeFieldType.getDimensions().get(0).getField());
            .endArray()
            throw new IllegalStateException(e);
    }
        prepareCreate(TEST_INDEX).setSettings(settings).setMapping(createTestMappingWithoutStarTree()).get();
                    );
            return jsonBuilder().startObject()
    public void testMaxDimsCompositeIndex() {
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                .endObject()
                    "index": {
                        "number_of_replicas": 0,
                .startObject("properties")
                .endObject()
                .field("type", "date")
                .endObject()
                                            ]
                .startObject("composite")
                        starTreeFieldType.getStarTreeConfig().getBuildMode()
    }
            throw new IllegalStateException(e);
                .startArray("ordered_dimensions")
            IllegalArgumentException.class,
            () -> client().admin()
                                        }
        assertAcked(putMappingResponse);
                .field("type", "integer")
            MapperParsingException.class,
        final XContentBuilder doc1 = jsonBuilder().startObject()
                .field("name", "dim2")
                .startObject("timestamp")
        XContentBuilder doc = jsonBuilder().startObject()
            .get();
                .field("type", "keyword")
                    assertTrue(starTreeFieldType.getDimensions().get(2) instanceof OrdinalDimension);
            ex.getMessage()
    }
                    StarTreeMapper.StarTreeFieldType starTreeFieldType = (StarTreeMapper.StarTreeFieldType) ft;
                .field("doc_values", false)
            .value(30)
    public void testMinimumTranslogFlushThresholdSize() {
            }
        return "numeric_dv";
                }
    public void testTranslogFlushThresholdSizeWithDefaultCompositeSettingLow() {
                            "enabled": true
        );
        // update some field in the mapping
                    DateDimension dateDim = (DateDimension) starTreeFieldType.getDimensions().get(0);
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get());
                    assertFalse(ft == null);
                    // Assert default metrics
 * SPDX-License-Identifier: Apache-2.0
        if (hasDocValues) {
                .endObject()
                                "type": "keyword"
                .startObject("composite")
        .build();
                .field("name", "nested.nested1.name.keyword2")
        );
            ex.getMessage()
                .startObject("properties")
        );
    public void testValidCompositeIndex() {
            .field("timestamp", "2023-06-01T12:00:00Z")
                .startObject()
    public void testUpdateTranslogFlushThresholdSize() {
            () -> prepareCreate(TEST_INDEX).setSettings(settings).setMapping(createMinimalTestMapping(false, false, false)).get()
            .startArray("name")
        }
            .startObject("nested")
        IllegalArgumentException ex = expectThrows(
            ex.getMessage()
                    for (int i = 0; i < dateDim.getIntervals().size(); i++) {
            throw new IllegalStateException(e);
            .startObject()
                }
            ex.getMessage()
                .field("name", isDuplicateDim ? "numeric_dv" : "numeric_dv1")  // Duplicate dimension
                .startObject("nested1")
                                    "ordered_dimensions": [
                Set<CompositeMappedFieldType> fts = indexService.mapperService().getCompositeFieldTypes();
            .startArray("nested1")
                .startObject()
                .startObject("status")
            .endObject()
                    assertEquals(
                                            ]
                .startObject("properties")
        }
        Settings updatedSettings = Settings.builder()
        XContentBuilder doc = jsonBuilder().startObject()
                    assertEquals(expectedMetrics, starTreeFieldType.getMetrics().get(0).getMetrics());
            .field("timestamp", "2023-06-01T12:00:00Z")
                .field("type", "integer")
    }
        );
        MapperParsingException ex = expectThrows(
                .startObject()
            .put(CompositeIndexSettings.COMPOSITE_INDEX_MAX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), "1030m")
            .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(1024, ByteSizeUnit.MB))
        try {
    public void testUpdateIndexWithAdditionOfStarTree() {
                                        },
                .endObject()
    }
                .field("doc_values", false)
            .startArray("status")
        }
            }
                .field("type", "keyword")
                    assertEquals("nested.nested1.name.keyword1", starTreeFieldType.getDimensions().get(3).getField());
    }
                .startObject("properties")
    public void testBelowMinimumTranslogFlushThresholdSize() {
            .field("timestamp", "2023-06-01T12:00:00Z")
                .endObject()
        IndexResponse indexResponse = client().prepareIndex(TEST_INDEX).setSource(doc).get();
                    assertTrue(starTreeFieldType.getDimensions().get(0) instanceof DateDimension);
                    assertTrue(starTreeFieldType.getDimensions().get(0) instanceof DateDimension);
        );
        assertEquals(200, values);
        assertEquals(
                    assertEquals(Collections.emptySet(), starTreeFieldType.getStarTreeConfig().getSkipStarNodeCreationInDims());
            return jsonBuilder().startObject()
                .endObject();
        );
                    List<DateTimeUnitRounding> expectedTimeUnits = Arrays.asList(
                .startObject("numeric")
                .setPersistentSettings(Settings.builder().putNull("*"))
                    List<DateTimeUnitRounding> expectedTimeUnits = Arrays.asList(
                .endObject()
import org.opensearch.index.compositeindex.datacube.NumericDimension;
            final Index index = resolveIndex("test");
            .startArray("numeric")
                .startObject("keyword_dv")
    }
                .field("type", "keyword")
                .endObject()
                .endObject();
                .startObject("keyword")
        MapperParsingException ex = expectThrows(
        XContentBuilder finalMapping = getMappingWithDuplicateFields(true, false);
                .endObject()
        XContentBuilder doc = jsonBuilder().startObject()
import org.opensearch.indices.IndicesService;
            .endObject()
                    assertEquals("numeric_dv", starTreeFieldType.getMetrics().get(0).getField());
            .startArray("numeric_dv")
        return "numeric_dv";
                .startObject("numeric")
                .startObject("config")
                .startObject("dim4")
            "Failed to parse mapping [_doc]: At most [1] calendar intervals are allowed in dimension [timestamp]",
        Settings settings = Settings.builder()
        assertEquals(
        assertTrue(validUpdateResponse.isAcknowledged());
                .indices()
            .endObject()
                .startObject()
                .endObject()
                                              "value_count",
                    );
            IllegalArgumentException.class,
                .field("doc_values", true)
                .endObject()
    private static String getDim(boolean hasDocValues, boolean isWildCard) {
            .get();
                .field("doc_values", true)
            .prepareUpdateSettings(TEST_INDEX)
                    assertEquals(Collections.emptySet(), starTreeFieldType.getStarTreeConfig().getSkipStarNodeCreationInDims());
            MapperParsingException.class,
                        .put(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey(), true)
                .startObject()
            ex.getMessage()
        prepareCreate(TEST_INDEX).setSettings(settings).setMapping(createNestedTestMapping()).get();
        );
                    assertEquals(Collections.emptySet(), starTreeFieldType.getStarTreeConfig().getSkipStarNodeCreationInDims());
                )
                            }
            return jsonBuilder().startObject()
                        DataCubeDateTimeUnit.HALF_HOUR_OF_DAY
            MapperParsingException.class,
        client().admin().indices().prepareRefresh(TEST_INDEX).get();
                .endObject()
    public void testCompositeIndexWithArraysInNestedMultiFields() throws IOException {
            .startObject("nested1")
                .endObject()
                .startObject("status")
                .startObject("keyword")
                .endObject()
    public void testInvalidMetric() {
                .startObject()
        } catch (IOException e) {
                // Date dimension is considered as one dimension regardless of number of actual calendar intervals
    }
                            },
    }
                .field("type", "keyword")
        assertAcked(prepareCreate(TEST_INDEX).setSource(createIndexSource, MediaTypeRegistry.JSON));
                .startObject("status")
        }
            .field("name", "this is name")
            .startObject()
                        "append_only": {
        List<Object> values = (List<Object>) ((Map<String, Object>) (hit.getSourceAsMap().get("nested-not-startree"))).get("nested1");
    }
                .field("name", "dim4")
                .endObject()
                .startArray("calendar_intervals")
                .startObject("properties")
                    assertFalse(ft == null);
                .field("name", "timestamp")
                .field("type", "wildcard")
                                        {
        // Verify the document was indexed
    }
        // Attempt to index a document with an array field
                .startObject("composite")
        Settings settings = Settings.builder()
            .startObject()
            .field("status", 10)
            MapperParsingException.class,
            () -> prepareCreate(TEST_INDEX).setSettings(settings).setMapping(createMinimalTestMapping(false, false, false)).get()
    }
            .indices()
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitAdapter;
                .startObject("keyword_dv")
                        "composite": {
import org.opensearch.test.OpenSearchIntegTestCase;
                        .put(StarTreeIndexSettings.STAR_TREE_MAX_DATE_INTERVALS_SETTING.getKey(), 1)
        AcknowledgedResponse response = prepareCreate(TEST_INDEX).setSettings(indexSettings)
                    assertEquals("nested.nested1.keyword_dv", starTreeFieldType.getDimensions().get(2).getField());
                .startObject("timestamp")
        IllegalArgumentException ex = expectThrows(
                .startObject("fields")
                        StarTreeFieldConfiguration.StarTreeBuildMode.OFF_HEAP,
                .endObject()
        assertTrue(values.contains(10));
                .field("type", "keyword")
                .startObject("unsignedLongDimension")
                    }
            .endArray()
            .value(10)
                                        {
    }
            .endObject()
                .endObject()
                .field("name", "timestamp")
                .startObject("nested1")
        assertEquals(1, searchResponse.getHits().getTotalHits().value());
                        new DateTimeUnitAdapter(Rounding.DateTimeUnit.DAY_OF_MONTH)
                .startObject("numeric")
                .endObject()
                for (CompositeMappedFieldType ft : fts) {
                .startObject("properties")
            Map<String, Object> valMap = (Map<String, Object>) val;
        );
                .endObject()
                    assertTrue(starTreeFieldType.getDimensions().get(1) instanceof NumericDimension);
        assertEquals("2023-06-01T12:00:00Z", hit.getSourceAsMap().get("timestamp"));
                    assertEquals(10000, starTreeFieldType.getStarTreeConfig().maxLeafDocs());
                    Settings.builder()
        // Attempt to index a document with an array field
            .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(56, ByteSizeUnit.BYTES))
                    assertEquals("keyword_dv", starTreeFieldType.getDimensions().get(2).getField());
                .field("type", "keyword")
                            },
            .build();
        prepareCreate(TEST_INDEX).setSettings(settings).setMapping(createMinimalTestMapping(false, false, false)).get();
        } catch (IOException e) {
                    }
                .field("name", "dim3")
                Set<CompositeMappedFieldType> fts = indexService.mapperService().getCompositeFieldTypes();
                .field("name", getMetric(invalidMetric, false))
        MapperParsingException ex = expectThrows(
            .value(20)
                                "type": "star_tree",
            }
        }
            () -> client().admin().indices().preparePutMapping(TEST_INDEX).setSource(createUpdateTestMapping(false, false)).get()
                    );
                .endArray()
                .endObject()
