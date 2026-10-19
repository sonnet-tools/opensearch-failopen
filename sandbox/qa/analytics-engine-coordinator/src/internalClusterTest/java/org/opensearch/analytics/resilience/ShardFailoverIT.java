                .cluster()
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
 * stage's {@code retargetForRetry} advances to the next copy (replica) and the scheduler  
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;  
            "NA",
     * processes alive; the coordinator just sees the primary's node as unreachable.
            .build();  
            assertThat("aggregate must equal docs * VALUE (full count via replica)", actual, equalTo(expected));
     * — a real node stop tears down the runtime for the surviving node too (see  
 * this file be licensed under the Apache-2.0 license or a
        );  
 *
import java.util.List;
            long expected = (long) DOCS * VALUE;
            .prepareHealth(INDEX)
    @Override  
    // task cascades, native resources released). The retry-skip-on-stage-cancellation
            .getState()  
    protected Settings nodeSettings(int nodeOrdinal) {
                    + green.getStatus()
            .putList("index.composite.secondary_data_formats")
     * to the surviving replica copy. Asserts the PPL aggregate returns the full row count.
        client().admin().indices().prepareRefresh(INDEX).get();
     */  
     * {@code CoordinatorTopologyTestBase} class-level comment). Disruption keeps both
    // contract — re-attempt the integration negative case once we have a way to route the
            .indices()
        Settings indexSettings = Settings.builder()
    // appears to route around the cluster-manager-vs-data-nodes partition (request lands
            .prepareCreate(INDEX)
import org.opensearch.ppl.action.PPLResponse;
        );
        ShardRouting primary = routingTable.primaryShard();
        for (int i = 0; i < DOCS; i++) {
 */  
            );
    @Override  
            assertEquals("must return exactly one aggregate row", 1, r.getRows().size());
    // to exhaust at the integration layer from here. Unit coverage already pins the  
import org.opensearch.analytics.AnalyticsPlugin;
        return List.of(
    // contract specific to this PR is pinned deterministically by
            int idx = r.getColumns().indexOf("total");
            + " aggregate is null (NPE). Needs a replicating non-Lucene committer for this IT."
import org.opensearch.test.disruption.NetworkDisruption;  
        internalCluster().setDisruptionScheme(disruption);
            client().prepareIndex(INDEX).setSource("value", VALUE).get();  
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.be.datafusion.DataFusionPlugin;
    }  
        } finally {
            false
            NetworkDisruption.DISCONNECT
            IndexShardRoutingTable rt = client().admin()  
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
            .get();
        ).collect(Collectors.toList());  
            throw new AssertionError(
 * {@code ShardExecutionTarget} carrying the full shard iterator. On dispatch failure the
    private static final String INDEX = "failover_idx";
    public void testQuerySucceedsAfterPrimaryNodeIsolated() throws Exception {  
    private String nodeHostingPrimary(String index) {
import org.opensearch.test.transport.MockTransportService;
 * Replica failover IT: when the primary's node goes down mid-query, the planner's  
        IndexShardRoutingTable routingTable = client().admin()
        ClusterHealthResponse green = client().admin()
import org.opensearch.common.unit.TimeValue;
 * replication (the doc-replication / translog phase-2 path throws
import org.opensearch.plugins.PluginInfo;
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
    // an IT for the race "cancel arrives while retargetForRetry would advance to next
        CreateIndexResponse cr = client().admin()  
 * SPDX-License-Identifier: Apache-2.0
            .get();
        return client().admin().cluster().prepareState().get().getState().nodes().get(primary.currentNodeId()).getName();  
            .put("index.pluggable.dataformat", "composite")
        internalCluster().startDataOnlyNodes(2);
            .setMapping("value", "type=integer")
        client().admin().indices().prepareFlush(INDEX).get();  
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
                MockTransportService.TestPlugin.class,  
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
     * <p>Uses {@link NetworkDisruption} rather than {@code stopRandomNode} because the
            .put("index.composite.primary_data_format", "parquet")  
    }  
    private static final int DOCS = 20;
            .put("index.pluggable.dataformat.enabled", true)
import java.util.Collection;  
                CompositeDataFormatPlugin.class,
            pluginClass.getName(),
                .getState()
                .get()  
    // on a still-reachable data node), so we can't deterministically force the iterator
                ArrowBasePlugin.class,
                    + rt.primaryShard()
                .shard(0);
}
            internalCluster().clearDisruptionScheme();
/*  
import org.opensearch.arrow.allocator.ArrowBasePlugin;  
            .shard(0);  
            ).actionGet(QUERY_TIMEOUT);  
 */  
            )
            .prepareState()
        // 1 cluster-manager (also handles REST requests) + 2 data nodes (primary + replica
        try {
        String primaryNodeName = nodeHostingPrimary(INDEX);
 * <p>Composite-parquet supports replica recovery only with remote-store + segment  
    @AwaitsFix(
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {  
import org.opensearch.common.util.FeatureFlags;
    // early (no tasks to cancel) or after release (query completes normally).
    // request through a partitioned coordinator without it forwarding to a data node.
            .build();
    // deterministically in ShardFragmentStageExecutionTests (unit). An IT for the "all
     * Isolate the primary's node from the coordinator mid-flight; the scheduler must retarget
            extendedPlugins,  
        // Isolate primary's node from the cluster-manager (which is acting as coordinator).  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
            .setTimeout(TimeValue.timeValueSeconds(60))  
 * The OpenSearch Contributors require contributions made to  
                    + rt.replicaShards()
            "1.8",  
    /**  
        // land on different nodes). Disrupting between cluster-manager and one data node
                .prepareState()
 * compatible open source license.
package org.opensearch.analytics.resilience;
    // copies unreachable" path was tried with NetworkDisruption but the PPL action  
    // don't materialize until the handler unblocks, so the cancel either lands too
            .get()
        }
        // pulls the replica copy → second dispatch lands on the replica's node → succeeds.
                .routingTable()
                    + " timed_out="
            .index(index)
        if (green.isTimedOut() || "RED".equals(green.getStatus().name())) {
        String clusterManager = internalCluster().startClusterManagerOnlyNode();
 * retries without surfacing an error.
            null,
        return Stream.concat(
     * DataFusion native Tokio runtime is JVM-global across nodes in {@code InternalTestCluster}
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
                MockCommitterEnginePlugin.class,
            pluginClass.getName(),
        return new PluginInfo(
        disruption.startDisrupting();
    private static final TimeValue QUERY_TIMEOUT = TimeValue.timeValueSeconds(30);  
        );  
                UnifiedPPLExecuteAction.INSTANCE,
    }
import org.opensearch.composite.CompositeDataFormatPlugin;  
import java.util.Collections;
 * {@code ShardTargetResolver} hands {@code ShardFragmentStageExecution} a
            .put(super.nodeSettings(nodeOrdinal))  
                .index(INDEX)  
    }
        // First dispatch to primary fails with NodeNotConnectedException → retargetForRetry
            super.nodePlugins().stream(),  
            .routingTable()
                new PPLRequest("source = " + INDEX + " | stats sum(value) as total")
            .cluster()  
/**
        }  
 *
                    + " replicas="  
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;  
            .cluster()  
import org.opensearch.cluster.metadata.IndexMetadata;  
import org.opensearch.indices.replication.common.ReplicationType;
        bugUrl = "Flaky: the test's MockCommitterEnginePlugin (InMemoryCommitter) doesn't replicate the"
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;  
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
    // QuerySchedulerTests.testCancelledStageSkipsRetryAndPropagatesOriginalCause —  
 * {@code DataFormatAwarePeerRecoveryIT}.
            .setSettings(indexSettings)  
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
    )
                ParquetOnlyDataFormatPlugin.class,  
    // SearchCancellationIT.testCancelShardFragmentTaskTerminatesQuery (cancel-mid-flight,  
        return Settings.builder()
                "Index did not reach green within 60s. health.status="  
public class ShardFailoverIT extends RemoteStoreBaseIntegTestCase {
    // Iterator-exhaustion / chained-retry / vanished-node-on-retry contracts are pinned
    // copy" was attempted via MockTransportService-blocked fragment handler + cancel of
    @Override  
        assertTrue(cr.isAcknowledged());  
    // Cancellation IT: end-to-end cancellation behavior is already covered by
            Stream.of(
                    + " primary="
            "classpath plugin",  
            .put(FeatureFlags.STREAM_TRANSPORT, true)
            disruption.stopDisrupting();  
import java.util.stream.Stream;
            .put(remoteStoreIndexSettings(1, 1))  // 1 replica, 1 shard, remote-store-backed
        // leaves the other data node fully accessible.  
import org.opensearch.test.OpenSearchIntegTestCase;
            + " parquet catalog to the remote store, so the failover replica serves 0 rows and the PPL"  
    }
import org.opensearch.common.settings.Settings;  
            .setWaitForGreenStatus()
                TestPPLPlugin.class
        }
        assertNotNull("primary must be allocated", primary);
import static org.hamcrest.Matchers.equalTo;  
 * the working configuration. Mirrors the topology used by
import org.opensearch.ppl.action.PPLRequest;
     *  
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),  
            Version.CURRENT,
import org.opensearch.plugins.Plugin;
        NetworkDisruption disruption = new NetworkDisruption(  
    }
                    + green.isTimedOut()  
            new NetworkDisruption.TwoPartitions(Collections.singleton(clusterManager), Collections.singleton(primaryNodeName)),
import org.opensearch.cluster.routing.IndexShardRoutingTable;
 * {@code unsupported_operation_exception: updates/deletes not supported}). Hence this IT
    private static final int VALUE = 7;
 * extends {@link RemoteStoreBaseIntegTestCase} — segment-replication-via-remote-store is  
            long actual = ((Number) r.getRows().get(0)[idx]).longValue();  
import org.opensearch.ppl.TestPPLPlugin;  
    // the parent PPL action, but couldn't be made deterministic: child shard tasks  
import org.opensearch.Version;
    protected Collection<PluginInfo> additionalNodePlugins() {
import java.util.stream.Collectors;  
            PPLResponse r = client().execute(  
