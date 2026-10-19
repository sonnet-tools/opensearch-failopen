                        "query should terminate shortly after the 1s timeout, took " + elapsedMs + "ms",
import java.util.concurrent.ExecutionException;
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;
                // The query must terminate due to the 1s timeout — well before the harness block
    private void createAndSeedIndex() {
            .indices()
            .put("index.pluggable.dataformat.enabled", true)
            .setMapping("value", "type=integer")
                assertEquals("seed not yet visible", EXPECTED_SUM, actual);
    private PPLResponse executePPL(String ppl) {
import org.opensearch.common.util.FeatureFlags;
        return Settings.builder()
    }
 */
        setClusterCancelAfter("1s");
@com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters(filters = org.opensearch.analytics.resilience.FlightTransportThreadLeakFilter.class)
import org.opensearch.test.OpenSearchIntegTestCase;
import java.util.List;
            .get();
        s.put("search.cancel_after_time_interval", value);
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                    );
            "1.8",
        return List.of(
        try {
public class AnalyticsTimeoutCancellationIT extends OpenSearchIntegTestCase {
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(s).get().isAcknowledged()
            CountDownLatch released = new CountDownLatch(1);
            .put("index.composite.primary_data_format", "parquet")
}
    @Override
import org.opensearch.Version;
    }
                long start = System.nanoTime();
        }
        Settings indexSettings = Settings.builder()
                    logger.info("query terminated by timeout after {}ms: {}", elapsedMs, e.getMessage());
    protected Settings nodeSettings(int nodeOrdinal) {
            mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
    private static final int DOCS_PER_SHARD = 50;
        return List.of(
import org.opensearch.common.unit.TimeValue;
        return new PluginInfo(
            .setSettings(indexSettings)
    /** Control: with no timeout set, the query completes normally (timeout machinery is inert when disabled). */
    private static final Logger logger = LogManager.getLogger(AnalyticsTimeoutCancellationIT.class);
    public void testNoTimeoutQueryCompletesNormally() throws Exception {
            CompositeDataFormatPlugin.class,
 * null→MINUS_ONE coercion that silently disabled the cluster timeout.
            String victim = randomFrom(internalCluster().getDataNodeNames());
                try {
            } finally {
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
import org.opensearch.analytics.exec.action.AnalyticsQueryAction;
                } finally {
import java.util.Collection;
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
    private static final TimeValue HARNESS_TIMEOUT = TimeValue.timeValueSeconds(30);
                released.countDown();
                } catch (TimeoutException te) {
    private static final int TOTAL_DOCS = NUM_SHARDS * DOCS_PER_SHARD;
                Future<PPLResponse> fut = exec.submit(() -> executePPL("source = " + INDEX + " | stats sum(value) as total"));
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
            assertTrue("residual " + action + " tasks: " + tasks.getTasks(), tasks.getTasks().isEmpty());
            Version.CURRENT,
            }
    }
            assertNoResidualTasks(AnalyticsQueryAction.NAME);
            .put("index.pluggable.dataformat", "composite")
import org.opensearch.be.datafusion.DataFusionPlugin;
        assertNoResidualTasks(FragmentExecutionAction.NAME);
    }
                    fail("query should have been cancelled by the cluster timeout, not completed");
        long actual = ((Number) response.getRows().get(0)[response.getColumns().indexOf("total")]).longValue();
 * this file be licensed under the Apache-2.0 license or a
 * its task tree when the timeout fires. Regression guard for the {@code AnalyticsQueryTask}
        }
        Settings.Builder s = Settings.builder();
        Settings.Builder s = Settings.builder();
                    long elapsedMs = (System.nanoTime() - start) / 1_000_000;
            "classpath plugin",
        );
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
import java.util.concurrent.TimeUnit;
        for (int i = 0; i < TOTAL_DOCS; i++) {
    }
    private static final int VALUE = 7;
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;
/*
        client().admin().cluster().prepareUpdateSettings().setTransientSettings(s).get();
    }
            MockTransportService.TestPlugin.class,
        );
import org.opensearch.plugins.Plugin;
            .put(super.nodeSettings(nodeOrdinal))
 */
import org.opensearch.analytics.AnalyticsPlugin;
import org.opensearch.test.transport.MockTransportService;
import org.opensearch.transport.TransportService;
@com.carrotsearch.randomizedtesting.annotations.ThreadLeakLingering(linger = 5000)
package org.opensearch.analytics.cancellation;
                    released.await(HARNESS_TIMEOUT.seconds(), TimeUnit.SECONDS);
import java.util.concurrent.ExecutorService;
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
 *
            extendedPlugins,
    }
                PPLResponse r = executePPL("source = " + INDEX + " | stats sum(value) as total");
                }
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
    }
import java.util.Collections;
import org.opensearch.arrow.allocator.ArrowBasePlugin;
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 2, numClientNodes = 0, supportsDedicatedMasters = false)
import java.util.concurrent.TimeoutException;
                    assertTrue(
import java.util.concurrent.Future;
                long actual = ((Number) r.getRows().get(0)[r.getColumns().indexOf("total")]).longValue();
            MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);
            assertBusy(() -> {
import java.util.concurrent.CountDownLatch;
    private void setClusterCancelAfter(String value) {
            .build();
        client().admin().indices().prepareFlush(INDEX).get();
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),
        ensureGreen(INDEX);
            }, 30, TimeUnit.SECONDS);
            MockCommitterEnginePlugin.class
@com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope(com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope.Scope.TEST)
import org.opensearch.ppl.TestPPLPlugin;
                exec.shutdownNow();
import org.opensearch.composite.CompositeDataFormatPlugin;
            ExecutorService exec = Executors.newSingleThreadExecutor();
import org.opensearch.ppl.action.PPLResponse;
            .build();
    }
            null,
                }
    // ---------------------------------------------------------------- fixture
            clearClusterCancelAfter();
        }
    private static final long EXPECTED_SUM = (long) TOTAL_DOCS * VALUE;
 * compatible open source license.
import org.opensearch.common.settings.Settings;
        assertNoResidualTasks(AnalyticsQueryAction.NAME);
    private static final int NUM_SHARDS = 2;
 * SPDX-License-Identifier: Apache-2.0
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, NUM_SHARDS)
                handler.messageReceived(request, channel, task);
    public void testClusterTimeoutCancelsInFlightQueryAndCleansUp() throws Exception {
        return client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest(ppl)).actionGet();
        s.putNull("search.cancel_after_time_interval");
            // Block one data node's fragment handler so the query stays in-flight well past 1s.
    protected Collection<PluginInfo> additionalNodePlugins() {
    @Override
    /** A query that can't finish in time (data node blocked) is cancelled by the timeout, no residual tasks. */
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.ppl.action.PPLRequest;
            ArrowBasePlugin.class,
        );
/**
    }
                } catch (ExecutionException e) {
            throw new AssertionError("timed out waiting for seed visibility", e);
        assertTrue("index creation must be acknowledged", response.isAcknowledged());
import org.apache.logging.log4j.LogManager;
        client().admin().indices().prepareRefresh(INDEX).get();
            assertNoResidualTasks(FragmentExecutionAction.NAME);
import java.util.concurrent.Executors;
                    released.countDown();
import org.opensearch.plugins.PluginInfo;
            client().prepareIndex(INDEX).setSource("value", VALUE).get();
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                    fut.get(HARNESS_TIMEOUT.seconds() - 5, TimeUnit.SECONDS);
                    Thread.currentThread().interrupt();
    }
import org.opensearch.analytics.exec.action.FragmentExecutionAction;
            pluginClass.getName(),
            .prepareCreate(INDEX)
        try {
    private void assertNoResidualTasks(String action) throws Exception {
                } catch (InterruptedException ie) {
        }, 10, TimeUnit.SECONDS);
                try {
 * The OpenSearch Contributors require contributions made to
    @Override
    private static final String INDEX = "analytics_timeout_idx";
        } catch (Exception e) {
                mts.clearAllRules();
        CreateIndexResponse response = client().admin()
import org.apache.logging.log4j.Logger;
            "NA",
            });
            .put(FeatureFlags.STREAM_TRANSPORT, true)
        PPLResponse response = executePPL("source = " + INDEX + " | stats sum(value) as total");
            ListTasksResponse tasks = client().admin().cluster().prepareListTasks().setActions(action).get();
            pluginClass.getName(),
            false
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
                    fail("timeout did not fire — query hung past the cluster cancel_after interval");
            try {
                        elapsedMs < (HARNESS_TIMEOUT.seconds() - 5) * 1000
            .putList("index.composite.secondary_data_formats")
        );
                exec.awaitTermination(5, TimeUnit.SECONDS);
        createAndSeedIndex();
        } finally {
        assertTrue(
    private void clearClusterCancelAfter() {
                // would be released — rather than hanging for the full HARNESS_TIMEOUT.
 * Verifies the analytics query path honors {@code search.cancel_after_time_interval} and cleans up
    // ---------------------------------------------------------------- tests
        clearClusterCancelAfter();
        createAndSeedIndex();
        assertEquals("query must return the correct sum when no timeout is set", EXPECTED_SUM, actual);
            TestPPLPlugin.class,
        assertBusy(() -> {
