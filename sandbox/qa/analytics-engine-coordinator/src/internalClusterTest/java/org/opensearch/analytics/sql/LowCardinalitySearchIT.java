        assertEquals(Boolean.TRUE, city.get("low_cardinality"));
 * (DataFusion) query path — i.e. search works end to end against the Parquet-backed column.  
 * <p>{@code low_cardinality: true} suppresses Lucene indexing for a keyword field (sets {@code index: false}) and  
 * @opensearch.internal
    @Override
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.common.settings.Settings;  
            .build();  
    protected Settings nodeSettings(int nodeOrdinal) {  
        assertEquals(1, countRows.size());  
        }  
    protected Collection<PluginInfo> additionalNodePlugins() {  
/*  
        assertEquals("Lucene indexing must be disabled for a low_cardinality field", Boolean.FALSE, city.get("index"));  
        assertEquals(5L, ((Number) countRows.getFirst()[0]).longValue());
        return new SqlPlanRunner(clusterService, executor);
        assertEquals("filter on low_cardinality field must return the matching rows", List.of(1, 2, 5), parisVals);  
    }  
    }  
import org.opensearch.cluster.metadata.MappingMetadata;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 1, numClientNodes = 0)
        );  
        return mapping;
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;
/**  
     * Full search flow: the {@code low_cardinality} keyword field has Lucene indexing disabled, yet a  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
    public void testSearchOnLowCardinalityField() {
 */  
    private static String asString(Object value) {
        List<Integer> parisVals = intColumn(runner.executeSql("SELECT val FROM " + INDEX + " WHERE city = 'paris'"));
    }  
        assertTrue(
 *
        assertNotNull("mapping metadata must exist for " + INDEX, mappingMetadata);  
        assertEquals("london", asString(londonRows.getFirst()[0]));  
        return new PluginInfo(
        Map<String, Object> mapping = (Map<String, Object>) properties.get(field);  
import java.util.Collection;
        List<Integer> out = new ArrayList<>();  
            .indices()  
}
    }  
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
    private List<Integer> intColumn(List<Object[]> rows) {
        for (Object[] doc : docs) {
 */  
            .putList("index.composite.secondary_data_formats")
    private SqlPlanRunner sqlPlanRunner() {  
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)  
            .setSettings(indexSettings)
package org.opensearch.analytics.sql;
    }
        assertNotNull("mapping must contain properties", properties);
        List<Object[]> countRows = runner.executeSql("SELECT COUNT(*) FROM " + INDEX);
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),
            "filter with no matches must return zero rows",  
 * compatible open source license.
        return List.of(ArrowBasePlugin.class, CompositeDataFormatPlugin.class, MockCommitterEnginePlugin.class);
    @Override
            pluginClass.getName(),
import java.util.Collections;
        return List.of(
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
            .setMapping("city", "type=keyword,low_cardinality=true", "val", "type=integer")  
        ClusterService clusterService = internalCluster().getInstance(ClusterService.class, node);
 *
            "NA",
    @Override  
            .get();
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {  
public class LowCardinalitySearchIT extends OpenSearchIntegTestCase {
 * relies on the Parquet column (plus its bloom filter) to serve lookups. These tests verify that, despite Lucene
import org.opensearch.plugins.Plugin;
    @SuppressWarnings("unchecked")
        MappingMetadata mappingMetadata = response.getMappings().get(INDEX);
        Map<String, Object> city = fieldMapping("city");
        GetMappingsResponse response = client().admin().indices().prepareGetMappings(INDEX).get();
            "classpath plugin",  
        assertNotNull("field [" + field + "] must be present in mapping", mapping);
    }
        // paris -> {1,2,5}, london -> {3}, tokyo -> {4}
            out.add(((Number) row[0]).intValue());
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),
        client().admin().indices().prepareRefresh(INDEX).get();
        client().admin().indices().prepareFlush(INDEX).get();
import java.util.List;  
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
            .put("index.pluggable.dataformat", "composite")  
        java.util.Collections.sort(parisVals);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            extendedPlugins,  
            runner.executeSql("SELECT val FROM " + INDEX + " WHERE city = 'berlin'").isEmpty()
import org.opensearch.common.util.FeatureFlags;
        );
            false
    // --- Infrastructure ---
        DefaultPlanExecutor executor = internalCluster().getInstance(DefaultPlanExecutor.class, node);  
import org.opensearch.cluster.service.ClusterService;
        createAndSeedLowCardinalityIndex();
    }  
        assertTrue("index creation must be acknowledged", response.isAcknowledged());
import org.opensearch.action.admin.indices.mapping.get.GetMappingsResponse;  
            .put("index.composite.primary_data_format", "parquet")
     */  
        assertEquals(1, londonRows.size());
import java.util.Map;
    }  
        ensureGreen(INDEX);  
        for (Object[] row : rows) {
 *
import java.util.ArrayList;  
        Map<String, Object> properties = (Map<String, Object>) mappingMetadata.getSourceAsMap().get("properties");
        CreateIndexResponse response = client().admin()
 * End-to-end search-flow tests for the {@code low_cardinality} mapping parameter.
    }
 * The OpenSearch Contributors require contributions made to  
        SqlPlanRunner runner = sqlPlanRunner();
        return Settings.builder()
        Settings indexSettings = Settings.builder()
    private static final String INDEX = "lc_search_idx";
import org.opensearch.be.datafusion.DataFusionPlugin;
            .put(FeatureFlags.STREAM_TRANSPORT, true)
            .build();
        String node = internalCluster().getNodeNames()[0];
            client().prepareIndex(INDEX).setSource("city", doc[0], "val", doc[1]).get();
            Version.CURRENT,
    private Map<String, Object> fieldMapping(String field) {  
            .put("index.pluggable.dataformat.enabled", true)
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        return out;
     * Parquet-backed query path.
import org.opensearch.Version;
import org.opensearch.composite.CompositeDataFormatPlugin;
        );
            "1.8",  
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;  
        List<Object[]> londonRows = runner.executeSql("SELECT city FROM " + INDEX + " WHERE val = 3");
            null,
            .prepareCreate(INDEX)
        Object[][] docs = { { "paris", 1 }, { "paris", 2 }, { "london", 3 }, { "tokyo", 4 }, { "paris", 5 } };  
import org.opensearch.plugins.PluginInfo;  
        return value == null ? null : value.toString();
    private void createAndSeedLowCardinalityIndex() {
     * {@code WHERE city = ...} filter and a projection of {@code city} both resolve correctly through the
    }
 * this file be licensed under the Apache-2.0 license or a
    /**
 * indexing being disabled, the field can still be <em>filtered on</em> and <em>projected</em> through the analytics
import org.opensearch.arrow.allocator.ArrowBasePlugin;  
        }  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.metadata.IndexMetadata;  
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),  
            pluginClass.getName(),
import org.opensearch.analytics.exec.DefaultPlanExecutor;
            .put(super.nodeSettings(nodeOrdinal))
import org.opensearch.analytics.AnalyticsPlugin;
