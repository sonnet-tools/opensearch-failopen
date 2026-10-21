    }
 *
        ensureGreen(INDEX);
 *
import java.util.ArrayList;
import org.opensearch.analytics.AnalyticsPlugin;
        return out;
import org.opensearch.action.admin.indices.mapping.get.GetMappingsResponse;
        );
import org.opensearch.Version;
    }
    // --- Infrastructure ---
        assertEquals(5L, ((Number) countRows.getFirst()[0]).longValue());
    }
        DefaultPlanExecutor executor = internalCluster().getInstance(DefaultPlanExecutor.class, node);
import org.opensearch.cluster.metadata.MappingMetadata;
    private static final String INDEX = "lc_search_idx";
        }
    @Override
            pluginClass.getName(),
import org.opensearch.be.datafusion.DataFusionPlugin;
        java.util.Collections.sort(parisVals);
    }
        assertTrue("index creation must be acknowledged", response.isAcknowledged());
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
        Object[][] docs = { { "paris", 1 }, { "paris", 2 }, { "london", 3 }, { "tokyo", 4 }, { "paris", 5 } };
            "NA",
            Version.CURRENT,
        assertEquals(1, londonRows.size());
        }
    }
import org.opensearch.common.settings.Settings;
 * End-to-end search-flow tests for the {@code low_cardinality} mapping parameter.
        CreateIndexResponse response = client().admin()
 * (DataFusion) query path — i.e. search works end to end against the Parquet-backed column.
    protected Settings nodeSettings(int nodeOrdinal) {
    }
 */
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),
    private static String asString(Object value) {
            .setSettings(indexSettings)
            extendedPlugins,
            pluginClass.getName(),
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
        return List.of(ArrowBasePlugin.class, CompositeDataFormatPlugin.class, MockCommitterEnginePlugin.class);
        List<Object[]> londonRows = runner.executeSql("SELECT city FROM " + INDEX + " WHERE val = 3");
        return Settings.builder()
        Map<String, Object> city = fieldMapping("city");
        SqlPlanRunner runner = sqlPlanRunner();
    private Map<String, Object> fieldMapping(String field) {
            .prepareCreate(INDEX)
import org.opensearch.common.util.FeatureFlags;
            .setMapping("city", "type=keyword,low_cardinality=true", "val", "type=integer")
 * compatible open source license.
     * Full search flow: the {@code low_cardinality} keyword field has Lucene indexing disabled, yet a
     */
            "filter with no matches must return zero rows",
        assertEquals("Lucene indexing must be disabled for a low_cardinality field", Boolean.FALSE, city.get("index"));
            false
import org.opensearch.analytics.exec.DefaultPlanExecutor;
        Settings indexSettings = Settings.builder()
            "1.8",
 * indexing being disabled, the field can still be <em>filtered on</em> and <em>projected</em> through the analytics
 * this file be licensed under the Apache-2.0 license or a
    /**
 */
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;
import java.util.Map;
    }
import org.opensearch.plugins.PluginInfo;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .put("index.pluggable.dataformat", "composite")
    }
            .build();
package org.opensearch.analytics.sql;
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
            .build();
        assertEquals(Boolean.TRUE, city.get("low_cardinality"));
            .get();
        Map<String, Object> properties = (Map<String, Object>) mappingMetadata.getSourceAsMap().get("properties");
        assertNotNull("field [" + field + "] must be present in mapping", mapping);
    @SuppressWarnings("unchecked")
import org.opensearch.arrow.allocator.ArrowBasePlugin;
        client().admin().indices().prepareFlush(INDEX).get();
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),
import org.opensearch.cluster.service.ClusterService;
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to
import org.opensearch.cluster.metadata.IndexMetadata;
            runner.executeSql("SELECT val FROM " + INDEX + " WHERE city = 'berlin'").isEmpty()
            .putList("index.composite.secondary_data_formats")
import org.opensearch.composite.CompositeDataFormatPlugin;
        assertEquals("filter on low_cardinality field must return the matching rows", List.of(1, 2, 5), parisVals);
    public void testSearchOnLowCardinalityField() {
            .indices()
public class LowCardinalitySearchIT extends OpenSearchIntegTestCase {
            client().prepareIndex(INDEX).setSource("city", doc[0], "val", doc[1]).get();
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
        return List.of(
        assertTrue(
        return value == null ? null : value.toString();
import java.util.List;
        List<Integer> parisVals = intColumn(runner.executeSql("SELECT val FROM " + INDEX + " WHERE city = 'paris'"));
        createAndSeedLowCardinalityIndex();
    private SqlPlanRunner sqlPlanRunner() {
    private void createAndSeedLowCardinalityIndex() {
/**
    private List<Integer> intColumn(List<Object[]> rows) {
        return mapping;
        GetMappingsResponse response = client().admin().indices().prepareGetMappings(INDEX).get();
            .put(super.nodeSettings(nodeOrdinal))
    }
     * {@code WHERE city = ...} filter and a projection of {@code city} both resolve correctly through the
            .put("index.composite.primary_data_format", "parquet")
            out.add(((Number) row[0]).intValue());
    @Override
        for (Object[] doc : docs) {
    protected Collection<PluginInfo> additionalNodePlugins() {
}
        );
import java.util.Collections;
import org.opensearch.test.OpenSearchIntegTestCase;
        client().admin().indices().prepareRefresh(INDEX).get();
        List<Integer> out = new ArrayList<>();
        String node = internalCluster().getNodeNames()[0];
 * <p>{@code low_cardinality: true} suppresses Lucene indexing for a keyword field (sets {@code index: false}) and
 * relies on the Parquet column (plus its bloom filter) to serve lookups. These tests verify that, despite Lucene
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
            .put("index.pluggable.dataformat.enabled", true)
            .put(FeatureFlags.STREAM_TRANSPORT, true)
/*
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
        Map<String, Object> mapping = (Map<String, Object>) properties.get(field);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 1, numClientNodes = 0)
import org.opensearch.plugins.Plugin;
            "classpath plugin",
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
        );
    @Override
        List<Object[]> countRows = runner.executeSql("SELECT COUNT(*) FROM " + INDEX);
import java.util.Collection;
        assertNotNull("mapping must contain properties", properties);
 * @opensearch.internal
        return new PluginInfo(
        for (Object[] row : rows) {
    }
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        MappingMetadata mappingMetadata = response.getMappings().get(INDEX);
 *
            null,
        assertEquals("london", asString(londonRows.getFirst()[0]));
        assertNotNull("mapping metadata must exist for " + INDEX, mappingMetadata);
        return new SqlPlanRunner(clusterService, executor);
        ClusterService clusterService = internalCluster().getInstance(ClusterService.class, node);
        // paris -> {1,2,5}, london -> {3}, tokyo -> {4}
     * Parquet-backed query path.
        assertEquals(1, countRows.size());
