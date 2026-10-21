import org.opensearch.ppl.action.PPLRequest;
 *
import static org.hamcrest.Matchers.equalTo;
 * {@code DataFormatAwarePeerRecoveryIT}.
            .setMapping("value", "type=integer")
     * processes alive; the coordinator just sees the primary's node as unreachable.
        return List.of(
     * — a real node stop tears down the runtime for the surviving node too (see
     */
        // leaves the other data node fully accessible.
 * stage's {@code retargetForRetry} advances to the next copy (replica) and the scheduler
    )
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
 *
        );
            .get();
            new NetworkDisruption.TwoPartitions(Collections.singleton(clusterManager), Collections.singleton(primaryNodeName)),
                CompositeDataFormatPlugin.class,
            "1.8",
            Stream.of(
    // copies unreachable" path was tried with NetworkDisruption but the PPL action
 */
            false
        return Stream.concat(
            long actual = ((Number) r.getRows().get(0)[idx]).longValue();
import org.opensearch.test.transport.MockTransportService;
    public void testQuerySucceedsAfterPrimaryNodeIsolated() throws Exception {
            + " aggregate is null (NPE). Needs a replicating non-Lucene committer for this IT."
        internalCluster().setDisruptionScheme(disruption);
import java.util.stream.Collectors;
            .prepareCreate(INDEX)
                "Index did not reach green within 60s. health.status="
    }
    }
                UnifiedPPLExecuteAction.INSTANCE,
    // an IT for the race "cancel arrives while retargetForRetry would advance to next
    private static final int VALUE = 7;
            .put("index.pluggable.dataformat", "composite")
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
 * <p>Composite-parquet supports replica recovery only with remote-store + segment
            + " parquet catalog to the remote store, so the failover replica serves 0 rows and the PPL"
        assertNotNull("primary must be allocated", primary);
import org.opensearch.common.settings.Settings;
            .put(FeatureFlags.STREAM_TRANSPORT, true)
        return new PluginInfo(
            .setWaitForGreenStatus()
            assertThat("aggregate must equal docs * VALUE (full count via replica)", actual, equalTo(expected));
                    + green.getStatus()
 * The OpenSearch Contributors require contributions made to
    // request through a partitioned coordinator without it forwarding to a data node.
 * replication (the doc-replication / translog phase-2 path throws
import org.opensearch.indices.replication.common.ReplicationType;
        client().admin().indices().prepareFlush(INDEX).get();
            "NA",
    // task cascades, native resources released). The retry-skip-on-stage-cancellation
    // don't materialize until the handler unblocks, so the cancel either lands too
    protected Settings nodeSettings(int nodeOrdinal) {
                .routingTable()
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),
    // contract — re-attempt the integration negative case once we have a way to route the
            .put("index.pluggable.dataformat.enabled", true)
 * this file be licensed under the Apache-2.0 license or a
            .index(index)
                    + " primary="
            throw new AssertionError(
 * Replica failover IT: when the primary's node goes down mid-query, the planner's
import org.opensearch.plugins.Plugin;
    // the parent PPL action, but couldn't be made deterministic: child shard tasks
        CreateIndexResponse cr = client().admin()
        bugUrl = "Flaky: the test's MockCommitterEnginePlugin (InMemoryCommitter) doesn't replicate the"
        try {
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
    private String nodeHostingPrimary(String index) {
 * extends {@link RemoteStoreBaseIntegTestCase} — segment-replication-via-remote-store is
        // land on different nodes). Disrupting between cluster-manager and one data node
        );
                TestPPLPlugin.class
            .prepareHealth(INDEX)
    // SearchCancellationIT.testCancelShardFragmentTaskTerminatesQuery (cancel-mid-flight,
                .shard(0);
        }
    /**
 * {@code ShardExecutionTarget} carrying the full shard iterator. On dispatch failure the
import org.opensearch.Version;
            IndexShardRoutingTable rt = client().admin()
     * Isolate the primary's node from the coordinator mid-flight; the scheduler must retarget
        String primaryNodeName = nodeHostingPrimary(INDEX);
        }
                MockCommitterEnginePlugin.class,
    // early (no tasks to cancel) or after release (query completes normally).
import org.opensearch.test.disruption.NetworkDisruption;
            disruption.stopDisrupting();
    @AwaitsFix(
        // First dispatch to primary fails with NodeNotConnectedException → retargetForRetry
            pluginClass.getName(),
            .get();
    }
import org.opensearch.test.OpenSearchIntegTestCase;
            Version.CURRENT,
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
import org.opensearch.common.unit.TimeValue;
            .prepareState()
            client().prepareIndex(INDEX).setSource("value", VALUE).get();
            .put(remoteStoreIndexSettings(1, 1))  // 1 replica, 1 shard, remote-store-backed
import org.opensearch.arrow.allocator.ArrowBasePlugin;
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;
            PPLResponse r = client().execute(
import org.opensearch.be.datafusion.DataFusionPlugin;
                .cluster()
            .routingTable()
     * to the surviving replica copy. Asserts the PPL aggregate returns the full row count.
            .shard(0);
            .put("index.composite.primary_data_format", "parquet")
        ShardRouting primary = routingTable.primaryShard();
            internalCluster().clearDisruptionScheme();
                MockTransportService.TestPlugin.class,
    private static final TimeValue QUERY_TIMEOUT = TimeValue.timeValueSeconds(30);
 * {@code ShardTargetResolver} hands {@code ShardFragmentStageExecution} a
    // appears to route around the cluster-manager-vs-data-nodes partition (request lands
                    + green.isTimedOut()
            null,
import org.opensearch.composite.CompositeDataFormatPlugin;
                ParquetOnlyDataFormatPlugin.class,
        // pulls the replica copy → second dispatch lands on the replica's node → succeeds.
import org.opensearch.ppl.TestPPLPlugin;
import java.util.Collection;
    // to exhaust at the integration layer from here. Unit coverage already pins the
 * the working configuration. Mirrors the topology used by
    }
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
        disruption.startDisrupting();
            .indices()
}
import org.opensearch.common.util.FeatureFlags;
import java.util.stream.Stream;
            )
    // QuerySchedulerTests.testCancelledStageSkipsRetryAndPropagatesOriginalCause —
    // contract specific to this PR is pinned deterministically by
    // Iterator-exhaustion / chained-retry / vanished-node-on-retry contracts are pinned
            "classpath plugin",
            assertEquals("must return exactly one aggregate row", 1, r.getRows().size());
import java.util.List;
    @Override
        internalCluster().startDataOnlyNodes(2);
            .put(super.nodeSettings(nodeOrdinal))
                new PPLRequest("source = " + INDEX + " | stats sum(value) as total")
            .setTimeout(TimeValue.timeValueSeconds(60))
        ).collect(Collectors.toList());
            .setSettings(indexSettings)
     * DataFusion native Tokio runtime is JVM-global across nodes in {@code InternalTestCluster}
        assertTrue(cr.isAcknowledged());
                ArrowBasePlugin.class,
import org.opensearch.cluster.routing.IndexShardRoutingTable;
    protected Collection<PluginInfo> additionalNodePlugins() {
        String clusterManager = internalCluster().startClusterManagerOnlyNode();
        for (int i = 0; i < DOCS; i++) {
            .putList("index.composite.secondary_data_formats")
    private static final String INDEX = "failover_idx";
 * compatible open source license.
import org.opensearch.cluster.routing.ShardRouting;
            .cluster()
        );
        client().admin().indices().prepareRefresh(INDEX).get();
 * retries without surfacing an error.
        // 1 cluster-manager (also handles REST requests) + 2 data nodes (primary + replica
 */
            int idx = r.getColumns().indexOf("total");
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;
        return Settings.builder()
 * {@code unsupported_operation_exception: updates/deletes not supported}). Hence this IT
            super.nodePlugins().stream(),
                    + " timed_out="
            pluginClass.getName(),
        Settings indexSettings = Settings.builder()
            .cluster()
import org.opensearch.cluster.metadata.IndexMetadata;
 * SPDX-License-Identifier: Apache-2.0
    }
        IndexShardRoutingTable routingTable = client().admin()
                    + " replicas="
package org.opensearch.analytics.resilience;
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
            .get()
                    + rt.replicaShards()
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
    // copy" was attempted via MockTransportService-blocked fragment handler + cancel of
    @Override
                .getState()
        NetworkDisruption disruption = new NetworkDisruption(
     *
     * {@code CoordinatorTopologyTestBase} class-level comment). Disruption keeps both
        } finally {
    // on a still-reachable data node), so we can't deterministically force the iterator
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
public class ShardFailoverIT extends RemoteStoreBaseIntegTestCase {
        if (green.isTimedOut() || "RED".equals(green.getStatus().name())) {
    private static final int DOCS = 20;
            NetworkDisruption.DISCONNECT
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
                    + rt.primaryShard()
/*
import org.opensearch.plugins.PluginInfo;
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
                .get()
            .build();
            .getState()
    // Cancellation IT: end-to-end cancellation behavior is already covered by
import java.util.Collections;
        return client().admin().cluster().prepareState().get().getState().nodes().get(primary.currentNodeId()).getName();
    // deterministically in ShardFragmentStageExecutionTests (unit). An IT for the "all
            long expected = (long) DOCS * VALUE;
     * <p>Uses {@link NetworkDisruption} rather than {@code stopRandomNode} because the
import org.opensearch.analytics.AnalyticsPlugin;
            extendedPlugins,
            );
    }
import org.opensearch.ppl.action.PPLResponse;
/**
                .index(INDEX)
        }
    @Override
            ).actionGet(QUERY_TIMEOUT);
            .build();
        // Isolate primary's node from the cluster-manager (which is acting as coordinator).
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
                .prepareState()
        ClusterHealthResponse green = client().admin()
