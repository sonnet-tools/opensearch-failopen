                Settings.builder().put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_WARN_SETTING.getKey(), threshold)
                Settings.builder().put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_WARN_SETTING.getKey(), threshold)
            .put(super.featureFlagSettings())
            client().prepareIndex(INDEX).setSource("val", i + 1).get();
    }
import java.util.Map;
import org.opensearch.composite.CompositeDataFormatPlugin;
            .put(super.nodeSettings(nodeOrdinal))
import org.opensearch.ppl.TestPPLPlugin;
        ClusterService clusterService = internalCluster().getInstance(ClusterService.class, node);
            assertFalse("query must return rows", rows.isEmpty());
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
        client().admin()
        client().admin().indices().prepareFlush(INDEX).get();
        return new MockLogAppender.PatternSeenWithLoggerPrefixExpectation(name, QUERY_LOGGER, Level.WARN, regex);
    protected Collection<PluginInfo> additionalNodePlugins() {
            List<Object[]> rows = runner.executeSql("SELECT val FROM " + INDEX);
        Loggers.setLevel(queryLogger, Level.WARN);
        return List.of(
    @Override
    private static final String INDEX = "slowlog_search_idx";
    @Override
    private void setIndexSlowLogThreshold(TimeValue threshold) {
package org.opensearch.analytics.sql;
            appender.addExpectation(expectFragment("has took", ".*took\\[.*\\].*took_millis\\[\\d+\\].*"));
            null,
        return new MockLogAppender.PatternSeenWithLoggerPrefixExpectation(name, FRAGMENT_LOGGER, Level.WARN, regex);
    protected Settings featureFlagSettings() {
import java.util.List;
 * The OpenSearch Contributors require contributions made to
            appender.addExpectation(expectQuery("has query_id", ".*query_id\\[[a-f0-9-]+\\].*"));
            appender.assertAllExpectationsMatched();
            Version.CURRENT,
            .get();
        setSlowLogThreshold(TimeValue.timeValueMillis(0));
            appender.addExpectation(expectFragment("has stage_id", ".*stage_id\\[\\d+\\].*"));
 *
            "classpath plugin",
        }
            assertFalse("query must return rows", rows.isEmpty());
    protected Settings nodeSettings(int nodeOrdinal) {
            .indices()
    private void setSlowLogThreshold(TimeValue threshold) {
import org.opensearch.ppl.action.PPLRequest;
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;
            appender.addExpectation(expectQuery("id field contains opaque id", ".*id\\[slow-log-test-id\\].*"));
 * SPDX-License-Identifier: Apache-2.0
        client().admin().indices().prepareRefresh(INDEX).get();
            appender.addExpectation(expectQuery("has planning_time_millis", ".*planning_time_millis\\[\\d+\\].*"));
import org.opensearch.plugins.Plugin;
            appender.addExpectation(expectFragment("has partial_aggregate", ".*partial_aggregate\\[.*\\].*"));
            );
        createAndSeedIndex();
        for (int i = 0; i < TOTAL_DOCS; i++) {
import org.opensearch.common.settings.Settings;
import org.opensearch.action.search.SearchRequestSlowLog;
        CreateIndexResponse response = client().admin()
        }
        return new SqlPlanRunner(clusterService, executor);
                .execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest("source = " + INDEX + " | fields val"))
        Loggers.setLevel(queryLogger, Level.WARN);
        setIndexSlowLogThreshold(TimeValue.timeValueMillis(0));
            appender.assertAllExpectationsMatched();
    }
    private static MockLogAppender.PatternSeenWithLoggerPrefixExpectation expectQuery(String name, String regex) {
    public void testQuerySlowLogEmitsAllFieldsOnCoordinatorPath() throws Exception {
            appender.assertAllExpectationsMatched();
import org.opensearch.common.unit.TimeValue;
            false
            .put("index.pluggable.dataformat", "composite")
            appender.addExpectation(expectQuery("has total_rows > 0", ".*total_rows\\[(?!0\\])\\d+\\].*"));
            appender.addExpectation(expectQuery("has took", ".*took\\[.*\\].*took_millis\\[\\d+\\].*"));
import org.opensearch.analytics.exec.AnalyticsFragmentSlowLog;
        Logger fragmentLogger = LogManager.getLogger(FRAGMENT_LOGGER);
        setSlowLogThreshold(TimeValue.timeValueMillis(0));
            .setPersistentSettings(
            .setSettings(
        return Settings.builder()
public class AnalyticsSearchSlowLogIT extends OpenSearchIntegTestCase {
import org.opensearch.index.SearchSlowLog;
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
            appender.addExpectation(expectQuery("has request_id field", ".*request_id\\[.*\\].*"));
import org.opensearch.cluster.metadata.IndexMetadata;
            .put(FeatureFlags.STREAM_TRANSPORT, true)
        try (MockLogAppender appender = MockLogAppender.createForLoggers(queryLogger)) {
    private void createAndSeedIndex() {
            .indices()
        ensureGreen(INDEX);
        return Settings.builder()
    public void testFragmentSlowLogEmitsAllFieldsOnDataNodePath() throws Exception {
    @AwaitsFix(bugUrl = "Flaky test")
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        Logger queryLogger = LogManager.getLogger(QUERY_LOGGER);
            pluginClass.getName(),
            "1.8",
            assertFalse("PPL query must return rows", response.getRows().isEmpty());
    private static final int TOTAL_DOCS = 10;
import org.opensearch.ppl.action.PPLResponse;
    public void testSlowLogDoesNotFireWhenBelowThreshold() throws Exception {
            .put(FeatureFlags.STREAM_TRANSPORT, true)
import org.opensearch.Version;
            appender.addExpectation(expectQuery("source field contains PPL text", ".*source\\[source = " + INDEX + ".*\\].*"));
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),
            .build();
    }
 * Verifies that the analytics engine search slow log fires for queries
            List<Object[]> rows = runner.executeSql("SELECT val FROM " + INDEX);
        SqlPlanRunner runner = sqlPlanRunner();
import org.apache.logging.log4j.LogManager;
import org.opensearch.cluster.service.ClusterService;
        try (MockLogAppender appender = MockLogAppender.createForLoggers(queryLogger)) {
            .build();
 * this file be licensed under the Apache-2.0 license or a
 */
/*
    public void testSlowLogContainsQuerySourceAndOpaqueIdViaPPLFrontend() throws Exception {
            appender.addExpectation(expectFragment("has query_id", ".*query_id\\[[a-f0-9-]+\\].*"));
        createAndSeedIndex();
/**
        Loggers.setLevel(fragmentLogger, Level.WARN);
    private static final String QUERY_LOGGER = AnalyticsSearchSlowLog.QUERY_LOGGER_NAME;
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
            .prepareUpdateSettings(INDEX)
    private static MockLogAppender.PatternSeenWithLoggerPrefixExpectation expectFragment(String name, String regex) {
import org.opensearch.analytics.exec.DefaultPlanExecutor;
import org.opensearch.plugins.PluginInfo;
}
            pluginClass.getName(),
        );
        try (MockLogAppender appender = MockLogAppender.createForLoggers(fragmentLogger)) {
            appender.addExpectation(expectQuery("has source field", ".*source\\[.*\\].*"));
    }
            appender.addExpectation(expectFragment("has shard", ".*shard\\[\\[" + INDEX + "\\]\\[\\d+\\]\\].*"));
            appender.addExpectation(expectFragment("has rows_produced > 0", ".*rows_produced\\[(?!0\\])\\d+\\].*"));
        return new PluginInfo(
        );
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    }
    }
        createAndSeedIndex();
            .build();
        Loggers.setLevel(queryLogger, Level.WARN);
            .cluster()
                .actionGet();
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;
        setSlowLogThreshold(TimeValue.timeValueMillis(0));
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),
            appender.addExpectation(
        SqlPlanRunner runner = sqlPlanRunner();
            List<Object[]> rows = runner.executeSql("SELECT val FROM " + INDEX);
    }
            PPLResponse response = client().filterWithHeader(Map.of("X-Opaque-Id", "slow-log-test-id"))
import org.apache.lucene.tests.util.LuceneTestCase;
        }
            appender.addExpectation(expectFragment("has task_id", ".*task_id\\[\\d+\\].*"));
    }
    }
    }
            appender.addExpectation(expectFragment("has id field", ".*id\\[.*\\].*"));
import org.opensearch.arrow.allocator.ArrowBasePlugin;
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
            )
        client().admin()
            .prepareCreate(INDEX)
        }
            .get();
    }
            appender.addExpectation(expectQuery("has stage_took_millis", ".*stage_took_millis\\[\\{.*\\}\\].*"));
            .prepareUpdateSettings()
    private SqlPlanRunner sqlPlanRunner() {
        setSlowLogThreshold(TimeValue.timeValueMinutes(10));
    }
import org.opensearch.test.MockLogAppender;
    }
 * executed through the DataFusion backend on the coordinator path.
import org.opensearch.analytics.AnalyticsPlugin;
            extendedPlugins,
        DefaultPlanExecutor executor = internalCluster().getInstance(DefaultPlanExecutor.class, node);
    }
import java.util.Collections;
        Settings indexSettings = Settings.builder()
import org.opensearch.common.logging.Loggers;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 2, numClientNodes = 0)
        createAndSeedIndex();
        Logger queryLogger = LogManager.getLogger(QUERY_LOGGER);
            appender.addExpectation(expectQuery("has id field", ".*id\\[.*\\].*"));
import org.opensearch.analytics.exec.AnalyticsSearchSlowLog;
            )
import org.opensearch.test.OpenSearchIntegTestCase;
 * compatible open source license.
        try (MockLogAppender appender = MockLogAppender.createForLoggers(queryLogger)) {
import org.opensearch.be.datafusion.DataFusionPlugin;
            .put("index.composite.primary_data_format", "parquet")
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
 */
            .get();
    }
            .setSettings(indexSettings)
        assertTrue("index creation must be acknowledged", response.isAcknowledged());
        }
            .put("index.pluggable.dataformat.enabled", true)
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
            .setMapping("val", "type=integer")
        return List.of(ArrowBasePlugin.class, TestPPLPlugin.class, CompositeDataFormatPlugin.class, MockCommitterEnginePlugin.class);
            assertFalse("query must return rows", rows.isEmpty());
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
            .putList("index.composite.secondary_data_formats")
        String node = internalCluster().getNodeNames()[0];
    @Override
        Logger queryLogger = LogManager.getLogger(QUERY_LOGGER);
    @Override
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
            appender.addExpectation(expectFragment("has used_secondary_index", ".*used_secondary_index\\[.*\\].*"));
import org.opensearch.common.util.FeatureFlags;
                new MockLogAppender.UnseenEventExpectation("no slow log below threshold", QUERY_LOGGER, Level.WARN, "*")
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
            appender.assertAllExpectationsMatched();
            "NA",
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)
    private static final String FRAGMENT_LOGGER = AnalyticsFragmentSlowLog.LOGGER_NAME;
        SqlPlanRunner runner = sqlPlanRunner();
import java.util.Collection;
