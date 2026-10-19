            }
            .add(new MoveAllocationCommand("test", 0, sourceNodeId, targetNode.getId()))
import org.opensearch.indices.recovery.IndexPrimaryRelocationIT;
    public void testRetentionLeaseAfterPrimaryRelocation() throws Exception {  
import org.opensearch.indices.replication.common.ReplicationType;
            .stream()
            .prepareReroute()
import org.opensearch.cluster.node.DiscoveryNode;  
        internalCluster().startDataOnlyNode();
        return List.of(InternalSettingsPlugin.class);
        internalCluster().startClusterManagerOnlyNode();
        assertFalse("timed out waiting for relocation", clusterHealthResponse.isTimedOut());
            .build();
            .findFirst()
                    continue;
    protected static final String REPOSITORY_NAME = "test-remote-store-repo";
            .get();  
            .setTimeout(TimeValue.timeValueSeconds(60))
    }
            .filter(n -> n.getId().equals(sourceNodeId) == false)  
}
        refresh("test");  
 * compatible open source license.
        ensureGreen("test");
                    1,
                    .collect(Collectors.toList());
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import org.opensearch.index.IndexService;  
import org.opensearch.plugins.Plugin;  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 *
        internalCluster().startClusterManagerOnlyNode();
        ensureGreen("test");
 * SPDX-License-Identifier: Apache-2.0
                }  
    protected Path absolutePath;
        if (absolutePath == null) {
                    ReplicationTracker.getPeerRecoveryRetentionLeaseId(shardStats.getShardRouting().currentNodeId()),
            final IndicesStatsResponse statsResponse = client().admin().indices().prepareStats("test").get();
        return Settings.builder()
            .put(indexSettings())
            .execute()
                    .filter(l -> ReplicationTracker.PEER_RECOVERY_RETENTION_LEASE_SOURCE.equals(l.source()))
import org.opensearch.index.seqno.RetentionLease;
import org.opensearch.cluster.ClusterState;
        client().admin()
            .values()
                final List<RetentionLease> peerRecoveryLeases = retentionLeases.leases()
            .put(remoteStoreClusterSettings(REPOSITORY_NAME, absolutePath))  
        final String dataNodeB = internalCluster().startDataOnlyNode();
                // the single lease should be for the current primary node  
        // get source node id
                );
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        createIndex("test", settings);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
            for (ShardStats shardStats : statsResponse.getShards()) {  
import org.opensearch.action.admin.indices.stats.ShardStats;  
            .put(super.indexSettings())  
        ensureGreen("test");
import org.opensearch.index.seqno.RetentionLeases;  
            .actionGet();  
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        client().prepareIndex("test").setId("1").setSource("field", "value").get();
import java.util.Collection;
            .indices()  
        final Settings settings = Settings.builder()  
    @Override  
    }
            .prepareHealth()
            .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), "5s")
        ClusterState state = client().admin().cluster().prepareState().get().getState();
                assertEquals(
import java.util.List;  
import org.opensearch.cluster.metadata.IndexMetadata;
                    .stream()  
import org.opensearch.test.InternalSettingsPlugin;
        return Settings.builder()
        // add a replica after relocation
        final String sourceNodeId = primaryShard.currentNodeId();
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.common.settings.Settings;
            .build();
    }  
            .build();  
            .orElseThrow();
 * this file be licensed under the Apache-2.0 license or a
public class RemoteIndexPrimaryRelocationIT extends IndexPrimaryRelocationIT {
                final RetentionLeases retentionLeases = shardStats.getRetentionLeaseStats().retentionLeases();
    }
            .setWaitForEvents(Priority.LANGUID)  
            .getDataNodes()  
    public void testPrimaryRelocationWhileIndexing() throws Exception {
 */  
import org.opensearch.index.seqno.ReplicationTracker;
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
import java.nio.file.Path;
            .cluster()  
    protected Settings nodeSettings(int nodeOrdinal) {  
        // index a doc so the shard is not empty
import java.util.stream.Collectors;
            .prepareUpdateSettings("test")
                    "expected exactly one peer recovery retention lease but got " + peerRecoveryLeases,
            .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build())
import org.opensearch.common.Priority;  
                );
                    peerRecoveryLeases.get(0).id()  
                    peerRecoveryLeases.size()  
            .setWaitForNoRelocatingShards(true)
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
            .cluster()  
        ShardRouting primaryShard = state.routingTable().shardRoutingTable("test", 0).primaryShard();  
 * The OpenSearch Contributors require contributions made to  
        });  
import org.opensearch.cluster.routing.ShardRouting;
            .actionGet();
    public Settings indexSettings() {
            absolutePath = randomRepoPath().toAbsolutePath();
                assertEquals(  
            .put(super.nodeSettings(nodeOrdinal))
        assertBusy(() -> {
        // relocate primary
        final DiscoveryNode targetNode = state.nodes()
import org.opensearch.common.unit.TimeValue;
        super.testPrimaryRelocationWhileIndexing();  
        // verify only one retention lease exists and it belongs to the primary  
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
    }
        client().admin()
package org.opensearch.remotestore;
        }  
/*  
            .execute()  
                if (shardStats.getShardRouting().primary() == false) {
        ClusterHealthResponse clusterHealthResponse = client().admin()
