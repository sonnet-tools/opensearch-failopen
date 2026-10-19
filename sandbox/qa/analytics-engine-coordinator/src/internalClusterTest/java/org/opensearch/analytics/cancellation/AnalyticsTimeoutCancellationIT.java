        client().admin().indices().prepareFlush(INDEX).get();
            assertBusy(() -> {
            .setSettings(indexSettings)  
            .indices()
            assertNoResidualTasks(AnalyticsQueryAction.NAME);
                } catch (ExecutionException e) {  
        );  
    private void assertNoResidualTasks(String action) throws Exception {
        for (int i = 0; i < TOTAL_DOCS; i++) {  
                exec.shutdownNow();  
import java.util.concurrent.TimeUnit;
        );
    private PPLResponse executePPL(String ppl) {
        );
            String victim = randomFrom(internalCluster().getDataNodeNames());
                        elapsedMs < (HARNESS_TIMEOUT.seconds() - 5) * 1000
                Future<PPLResponse> fut = exec.submit(() -> executePPL("source = " + INDEX + " | stats sum(value) as total"));
            null,  
            .get();
                        "query should terminate shortly after the 1s timeout, took " + elapsedMs + "ms",
        return new PluginInfo(
            mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
            pluginClass.getName(),  
            // Block one data node's fragment handler so the query stays in-flight well past 1s.
            CountDownLatch released = new CountDownLatch(1);
        setClusterCancelAfter("1s");
            client().prepareIndex(INDEX).setSource("value", VALUE).get();
            .setMapping("value", "type=integer")
        assertTrue("index creation must be acknowledged", response.isAcknowledged());  
        ensureGreen(INDEX);
import java.util.Collection;
import org.opensearch.analytics.AnalyticsPlugin;  
            TestPPLPlugin.class,
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.concurrent.Future;  
    protected Settings nodeSettings(int nodeOrdinal) {
        assertEquals("query must return the correct sum when no timeout is set", EXPECTED_SUM, actual);  
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;  
import org.opensearch.ppl.TestPPLPlugin;  
        client().admin().cluster().prepareUpdateSettings().setTransientSettings(s).get();
/**
    private void setClusterCancelAfter(String value) {  
    private void createAndSeedIndex() {
    }  
import org.opensearch.transport.TransportService;  
    public void testClusterTimeoutCancelsInFlightQueryAndCleansUp() throws Exception {  
        try {  
            }
        assertBusy(() -> {  
            } finally {  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.transport.MockTransportService;
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),  
                    fail("query should have been cancelled by the cluster timeout, not completed");
import java.util.concurrent.ExecutionException;  
    }
                assertEquals("seed not yet visible", EXPECTED_SUM, actual);
                    logger.info("query terminated by timeout after {}ms: {}", elapsedMs, e.getMessage());
            assertTrue("residual " + action + " tasks: " + tasks.getTasks(), tasks.getTasks().isEmpty());
import org.opensearch.ppl.action.PPLResponse;
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
            extendedPlugins,
                try {  
import java.util.concurrent.Executors;
    private static final String INDEX = "analytics_timeout_idx";
 * null→MINUS_ONE coercion that silently disabled the cluster timeout.
    private static final int NUM_SHARDS = 2;  
        assertNoResidualTasks(FragmentExecutionAction.NAME);  
                    fut.get(HARNESS_TIMEOUT.seconds() - 5, TimeUnit.SECONDS);
        Settings.Builder s = Settings.builder();  
        client().admin().indices().prepareRefresh(INDEX).get();  
            false
/*  
                try {  
            Version.CURRENT,  
    public void testNoTimeoutQueryCompletesNormally() throws Exception {  
            .prepareCreate(INDEX)
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                }
            .build();  
            clearClusterCancelAfter();
                    Thread.currentThread().interrupt();  
            pluginClass.getName(),
 * compatible open source license.
                mts.clearAllRules();
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
        Settings.Builder s = Settings.builder();
        PPLResponse response = executePPL("source = " + INDEX + " | stats sum(value) as total");
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(s).get().isAcknowledged()
            .put("index.pluggable.dataformat", "composite")
 */
                    );  
        return List.of(
package org.opensearch.analytics.cancellation;
@com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters(filters = org.opensearch.analytics.resilience.FlightTransportThreadLeakFilter.class)  
 * its task tree when the timeout fires. Regression guard for the {@code AnalyticsQueryTask}  
            .put(FeatureFlags.STREAM_TRANSPORT, true)
            .put(super.nodeSettings(nodeOrdinal))  
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
        } finally {  
                    fail("timeout did not fire — query hung past the cluster cancel_after interval");
    }
        } catch (Exception e) {  
import org.opensearch.test.OpenSearchIntegTestCase;
            MockTransportService.TestPlugin.class,
                    long elapsedMs = (System.nanoTime() - start) / 1_000_000;
            "classpath plugin",
    private static final int VALUE = 7;  
import org.opensearch.common.unit.TimeValue;
import org.opensearch.Version;  
        Settings indexSettings = Settings.builder()  
            CompositeDataFormatPlugin.class,  
    }
    // ---------------------------------------------------------------- fixture  
    }  
            "NA",
public class AnalyticsTimeoutCancellationIT extends OpenSearchIntegTestCase {
import org.opensearch.common.util.FeatureFlags;  
                    assertTrue(  
}
    private static final TimeValue HARNESS_TIMEOUT = TimeValue.timeValueSeconds(30);
    }  
    }  
import org.opensearch.be.datafusion.DataFusionPlugin;
            MockCommitterEnginePlugin.class
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 2, numClientNodes = 0, supportsDedicatedMasters = false)  
import java.util.List;
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),
import java.util.concurrent.CountDownLatch;
                long start = System.nanoTime();
        long actual = ((Number) response.getRows().get(0)[response.getColumns().indexOf("total")]).longValue();
import org.opensearch.analytics.exec.action.AnalyticsQueryAction;
    @Override  
    }
    }
 *
            throw new AssertionError("timed out waiting for seed visibility", e);
import org.opensearch.plugins.Plugin;
            .putList("index.composite.secondary_data_formats")  
    private static final Logger logger = LogManager.getLogger(AnalyticsTimeoutCancellationIT.class);  
                    released.await(HARNESS_TIMEOUT.seconds(), TimeUnit.SECONDS);
    // ---------------------------------------------------------------- tests  
        try {  
    /** Control: with no timeout set, the query completes normally (timeout machinery is inert when disabled). */
        }
import org.opensearch.arrow.allocator.ArrowBasePlugin;  
            try {  
    protected Collection<PluginInfo> additionalNodePlugins() {
                }
import org.opensearch.composite.CompositeDataFormatPlugin;
import java.util.Collections;  
                    released.countDown();
                released.countDown();
    }
                // The query must terminate due to the 1s timeout — well before the harness block
            ExecutorService exec = Executors.newSingleThreadExecutor();
        }
                } catch (TimeoutException te) {
        s.put("search.cancel_after_time_interval", value);
                // would be released — rather than hanging for the full HARNESS_TIMEOUT.
            MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);  
 * this file be licensed under the Apache-2.0 license or a
    private void clearClusterCancelAfter() {
 */  
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;  
    private static final int DOCS_PER_SHARD = 50;
import java.util.concurrent.ExecutorService;
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
        s.putNull("search.cancel_after_time_interval");
import org.opensearch.cluster.metadata.IndexMetadata;  
    /** A query that can't finish in time (data node blocked) is cancelled by the timeout, no residual tasks. */
        return List.of(  
            .put("index.pluggable.dataformat.enabled", true)  
        return client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest(ppl)).actionGet();  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, NUM_SHARDS)
        assertTrue(  
                handler.messageReceived(request, channel, task);
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
            .build();
        assertNoResidualTasks(AnalyticsQueryAction.NAME);
import org.opensearch.plugins.PluginInfo;
        return Settings.builder()
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))  
        }, 10, TimeUnit.SECONDS);  
@com.carrotsearch.randomizedtesting.annotations.ThreadLeakLingering(linger = 5000)
            "1.8",
import java.util.concurrent.TimeoutException;
            ArrowBasePlugin.class,
                } catch (InterruptedException ie) {
                PPLResponse r = executePPL("source = " + INDEX + " | stats sum(value) as total");
    @Override
            });  
            ListTasksResponse tasks = client().admin().cluster().prepareListTasks().setActions(action).get();
import org.opensearch.common.settings.Settings;
        createAndSeedIndex();
        createAndSeedIndex();
        }
                exec.awaitTermination(5, TimeUnit.SECONDS);
        CreateIndexResponse response = client().admin()  
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
    @Override  
        clearClusterCancelAfter();
import org.opensearch.analytics.exec.action.FragmentExecutionAction;
    private static final int TOTAL_DOCS = NUM_SHARDS * DOCS_PER_SHARD;
    private static final long EXPECTED_SUM = (long) TOTAL_DOCS * VALUE;
 * Verifies the analytics query path honors {@code search.cancel_after_time_interval} and cleans up
            }, 30, TimeUnit.SECONDS);
        );  
import org.opensearch.ppl.action.PPLRequest;
@com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope(com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope.Scope.TEST)
 * SPDX-License-Identifier: Apache-2.0
    }
            assertNoResidualTasks(FragmentExecutionAction.NAME);
                } finally {  
                long actual = ((Number) r.getRows().get(0)[r.getColumns().indexOf("total")]).longValue();  
            .put("index.composite.primary_data_format", "parquet")
