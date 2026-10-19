    public void testFragmentSlowLogEmitsAllFieldsOnDataNodePath() throws Exception {
    }  
            .prepareUpdateSettings(INDEX)  
        try (MockLogAppender appender = MockLogAppender.createForLoggers(queryLogger)) {
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
        Logger fragmentLogger = LogManager.getLogger(FRAGMENT_LOGGER);
    public void testSlowLogDoesNotFireWhenBelowThreshold() throws Exception {
import org.opensearch.plugins.Plugin;
        }
            .setSettings(indexSettings)
            appender.addExpectation(expectFragment("has task_id", ".*task_id\\[\\d+\\].*"));  
        SqlPlanRunner runner = sqlPlanRunner();  
import org.opensearch.ppl.action.PPLResponse;
        return new SqlPlanRunner(clusterService, executor);
    }
            .build();
            .putList("index.composite.secondary_data_formats")
    private static final String FRAGMENT_LOGGER = AnalyticsFragmentSlowLog.LOGGER_NAME;
import org.opensearch.arrow.allocator.ArrowBasePlugin;
import org.opensearch.ppl.TestPPLPlugin;  
            appender.addExpectation(
        }
            .prepareCreate(INDEX)
        Logger queryLogger = LogManager.getLogger(QUERY_LOGGER);
    }
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)  
    }
            .put(FeatureFlags.STREAM_TRANSPORT, true)
        SqlPlanRunner runner = sqlPlanRunner();
            appender.addExpectation(expectQuery("has request_id field", ".*request_id\\[.*\\].*"));
import java.util.Collection;
        Loggers.setLevel(queryLogger, Level.WARN);
            appender.addExpectation(expectFragment("has shard", ".*shard\\[\\[" + INDEX + "\\]\\[\\d+\\]\\].*"));
import org.opensearch.test.OpenSearchIntegTestCase;
    }
 * executed through the DataFusion backend on the coordinator path.
        return Settings.builder()
        createAndSeedIndex();  
        Settings indexSettings = Settings.builder()
import org.opensearch.common.util.FeatureFlags;  
        Loggers.setLevel(queryLogger, Level.WARN);
            extendedPlugins,  
            .put(super.featureFlagSettings())
    private static final String INDEX = "slowlog_search_idx";
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;  
            appender.addExpectation(expectFragment("has query_id", ".*query_id\\[[a-f0-9-]+\\].*"));  
                .execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest("source = " + INDEX + " | fields val"))  
        return List.of(ArrowBasePlugin.class, TestPPLPlugin.class, CompositeDataFormatPlugin.class, MockCommitterEnginePlugin.class);
            List<Object[]> rows = runner.executeSql("SELECT val FROM " + INDEX);
        }
        createAndSeedIndex();
            .get();
            appender.assertAllExpectationsMatched();  
            appender.addExpectation(expectQuery("id field contains opaque id", ".*id\\[slow-log-test-id\\].*"));  
            )
            .indices()
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
            List<Object[]> rows = runner.executeSql("SELECT val FROM " + INDEX);  
            .indices()  
                Settings.builder().put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_WARN_SETTING.getKey(), threshold)
import org.opensearch.analytics.exec.AnalyticsSearchSlowLog;
        client().admin().indices().prepareFlush(INDEX).get();  
            .put(FeatureFlags.STREAM_TRANSPORT, true)
        createAndSeedIndex();
    public void testQuerySlowLogEmitsAllFieldsOnCoordinatorPath() throws Exception {  
            .setMapping("val", "type=integer")  
import org.apache.lucene.tests.util.LuceneTestCase;
            "NA",
            "classpath plugin",  
            appender.addExpectation(expectQuery("has source field", ".*source\\[.*\\].*"));
                new MockLogAppender.UnseenEventExpectation("no slow log below threshold", QUERY_LOGGER, Level.WARN, "*")
        }
 *
        Loggers.setLevel(queryLogger, Level.WARN);  
 * compatible open source license.
            appender.addExpectation(expectQuery("has query_id", ".*query_id\\[[a-f0-9-]+\\].*"));  
import java.util.List;  
        setSlowLogThreshold(TimeValue.timeValueMillis(0));
import org.opensearch.action.search.SearchRequestSlowLog;
    public void testSlowLogContainsQuerySourceAndOpaqueIdViaPPLFrontend() throws Exception {  
    }  
            List<Object[]> rows = runner.executeSql("SELECT val FROM " + INDEX);  
 */  
            "1.8",  
    @Override  
import org.opensearch.common.logging.Loggers;  
            .build();
import org.opensearch.Version;
        Loggers.setLevel(fragmentLogger, Level.WARN);
        try (MockLogAppender appender = MockLogAppender.createForLoggers(queryLogger)) {
        return new PluginInfo(
            false
    @Override
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)  
import org.opensearch.be.datafusion.DataFusionPlugin;  
}
 * The OpenSearch Contributors require contributions made to  
    }
            assertFalse("query must return rows", rows.isEmpty());  
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),
import org.apache.logging.log4j.LogManager;
import org.opensearch.composite.CompositeDataFormatPlugin;
        DefaultPlanExecutor executor = internalCluster().getInstance(DefaultPlanExecutor.class, node);  
        assertTrue("index creation must be acknowledged", response.isAcknowledged());
        ensureGreen(INDEX);  
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),  
    private void createAndSeedIndex() {
    private void setSlowLogThreshold(TimeValue threshold) {
            appender.addExpectation(expectFragment("has used_secondary_index", ".*used_secondary_index\\[.*\\].*"));
/**  
            assertFalse("query must return rows", rows.isEmpty());
            .put(super.nodeSettings(nodeOrdinal))
    }  
            .put("index.composite.primary_data_format", "parquet")
            null,
import org.opensearch.analytics.exec.DefaultPlanExecutor;  
    private SqlPlanRunner sqlPlanRunner() {  
            appender.addExpectation(expectQuery("source field contains PPL text", ".*source\\[source = " + INDEX + ".*\\].*"));
            .prepareUpdateSettings()
            .put("index.pluggable.dataformat", "composite")  
            appender.addExpectation(expectFragment("has rows_produced > 0", ".*rows_produced\\[(?!0\\])\\d+\\].*"));  
            appender.assertAllExpectationsMatched();  
        setSlowLogThreshold(TimeValue.timeValueMillis(0));
            appender.addExpectation(expectFragment("has took", ".*took\\[.*\\].*took_millis\\[\\d+\\].*"));
            pluginClass.getName(),
            appender.addExpectation(expectFragment("has partial_aggregate", ".*partial_aggregate\\[.*\\].*"));
            )  
    private static final int TOTAL_DOCS = 10;
import org.opensearch.analytics.exec.AnalyticsFragmentSlowLog;  
        CreateIndexResponse response = client().admin()
    @Override
/*  
            appender.addExpectation(expectQuery("has took", ".*took\\[.*\\].*took_millis\\[\\d+\\].*"));  
            .put("index.pluggable.dataformat.enabled", true)
import org.opensearch.common.unit.TimeValue;
import org.apache.logging.log4j.Level;
        return new MockLogAppender.PatternSeenWithLoggerPrefixExpectation(name, QUERY_LOGGER, Level.WARN, regex);
            .setSettings(
import org.opensearch.common.settings.Settings;
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {  
        try (MockLogAppender appender = MockLogAppender.createForLoggers(fragmentLogger)) {
    }
import org.apache.logging.log4j.Logger;  
        client().admin().indices().prepareRefresh(INDEX).get();
            appender.addExpectation(expectFragment("has id field", ".*id\\[.*\\].*"));
    }
        }  
            appender.addExpectation(expectQuery("has total_rows > 0", ".*total_rows\\[(?!0\\])\\d+\\].*"));
        for (int i = 0; i < TOTAL_DOCS; i++) {
            appender.assertAllExpectationsMatched();
import org.opensearch.ppl.action.PPLRequest;
            appender.addExpectation(expectQuery("has planning_time_millis", ".*planning_time_millis\\[\\d+\\].*"));
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 2, numClientNodes = 0)
package org.opensearch.analytics.sql;
import org.opensearch.plugins.PluginInfo;
                Settings.builder().put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_WARN_SETTING.getKey(), threshold)
            assertFalse("query must return rows", rows.isEmpty());
            Version.CURRENT,
        createAndSeedIndex();  
import java.util.Collections;
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
import org.opensearch.cluster.service.ClusterService;
            .cluster()
        setSlowLogThreshold(TimeValue.timeValueMinutes(10));
        Logger queryLogger = LogManager.getLogger(QUERY_LOGGER);
    private void setIndexSlowLogThreshold(TimeValue threshold) {  
    @AwaitsFix(bugUrl = "Flaky test")
        try (MockLogAppender appender = MockLogAppender.createForLoggers(queryLogger)) {  
        Logger queryLogger = LogManager.getLogger(QUERY_LOGGER);  
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;  
            .get();
import org.opensearch.analytics.AnalyticsPlugin;
    protected Collection<PluginInfo> additionalNodePlugins() {  
                .actionGet();
    private static MockLogAppender.PatternSeenWithLoggerPrefixExpectation expectQuery(String name, String regex) {
            client().prepareIndex(INDEX).setSource("val", i + 1).get();  
import org.opensearch.test.MockLogAppender;
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),
            pluginClass.getName(),
 */  
    }
            );  
    private static MockLogAppender.PatternSeenWithLoggerPrefixExpectation expectFragment(String name, String regex) {
        client().admin()
            .build();  
    }
import org.opensearch.cluster.metadata.IndexMetadata;
            appender.addExpectation(expectFragment("has stage_id", ".*stage_id\\[\\d+\\].*"));
            assertFalse("PPL query must return rows", response.getRows().isEmpty());
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
        setIndexSlowLogThreshold(TimeValue.timeValueMillis(0));
    }  
    @Override
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            appender.addExpectation(expectQuery("has stage_took_millis", ".*stage_took_millis\\[\\{.*\\}\\].*"));
            .setPersistentSettings(  
            appender.addExpectation(expectQuery("has id field", ".*id\\[.*\\].*"));  
        );  
    protected Settings featureFlagSettings() {  
import org.opensearch.action.admin.indices.create.CreateIndexResponse;  
        return List.of(
        );
    private static final String QUERY_LOGGER = AnalyticsSearchSlowLog.QUERY_LOGGER_NAME;  
        client().admin()  
        ClusterService clusterService = internalCluster().getInstance(ClusterService.class, node);
        SqlPlanRunner runner = sqlPlanRunner();
    }  
import org.opensearch.index.SearchSlowLog;
public class AnalyticsSearchSlowLogIT extends OpenSearchIntegTestCase {
        setSlowLogThreshold(TimeValue.timeValueMillis(0));
    }  
        return new MockLogAppender.PatternSeenWithLoggerPrefixExpectation(name, FRAGMENT_LOGGER, Level.WARN, regex);  
 * Verifies that the analytics engine search slow log fires for queries
import java.util.Map;
        String node = internalCluster().getNodeNames()[0];
    protected Settings nodeSettings(int nodeOrdinal) {  
            .get();  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            PPLResponse response = client().filterWithHeader(Map.of("X-Opaque-Id", "slow-log-test-id"))
            appender.assertAllExpectationsMatched();
        return Settings.builder()
