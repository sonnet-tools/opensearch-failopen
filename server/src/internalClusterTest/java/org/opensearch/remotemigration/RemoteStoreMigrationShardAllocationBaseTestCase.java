                .getNodes()  
            .indices()
            .getRoutingTable()  
                    Settings.builder()  
            .setIndices(TEST_INDEX)  
            .cluster()  
    protected void setClusterMode(String mode) {
            .setIndices(indices)
        Settings.Builder settingsBuilder;
                .get()
            nodeAllocationResults = moveDecision.getNodeDecisions();
    }
            .getSettings()
import java.util.List;
        }
            .admin()
            .admin()
        logger.info(" --> verify allocation of primary shard");  
        } else {
                .admin()
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;  
 * this file be licensed under the Apache-2.0 license or a
    }
    public static void assertRemoteStoreBackedIndex(String indexName) {
        ShardRouting shardRouting = getShardRouting(isPrimary);
            .cluster()
    protected DiscoveryNode assertNodeInCluster(String nodeName) {  
        }
            ensureRed(TEST_INDEX);
        assertNotNull(shardRouting.currentNodeId());
    // get allocation and relocation decisions for all nodes
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
import org.opensearch.cluster.routing.allocation.AllocateUnassignedDecision;
            .execute()  
import org.opensearch.cluster.routing.ShardRouting;  
                .actionGet()
    protected void setDirection(String direction) {  
            .getState()
        ShardRouting shardRouting = getShardRouting(isPrimary);  
        boolean isRelocation
                    Settings.builder()
        );
                    .put("index.number_of_replicas", 0)  
            AllocateUnassignedDecision allocateUnassignedDecision = explanation.getShardAllocationDecision().getAllocateDecision();  
import org.opensearch.index.IndexSettings;  
            .prepareCreateSnapshot(snapshotRepoName, snapshotName)  
            internalCluster().client()
    public static RestoreSnapshotResponse restoreSnapshot(String snapshotRepoName, String snapshotName, String restoredIndexName) {  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY;
        return (isPrimary ? table.primaryShard() : table.replicaShards().get(0));  
                        .put("index.routing.allocation.include._name", "")
                .execute()
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;  
        updateSettingsRequest.persistentSettings(Settings.builder().put(MIGRATION_DIRECTION_SETTING.getKey(), direction));
    // returns a comma-separated list of node names excluding `except`
import org.opensearch.cluster.metadata.IndexMetadata;
        internalCluster().client()
            settingsBuilder = Settings.builder()
        assertNull(indexSettings.get(SETTING_REMOTE_STORE_ENABLED));
        assertNotNull(discoveryNode);
                exclude.append(node.getName()).append(",");
        assertNull(indexSettings.get(SETTING_REMOTE_SEGMENT_STORE_REPOSITORY));
        assertEquals(REPOSITORY_NAME, indexSettings.get(SETTING_REMOTE_SEGMENT_STORE_REPOSITORY));  
                .put("index.routing.allocation.exclude._name", clusterManagerNodeName);  
            .setWaitForCompletion(true)
            .prepareState()
            .setSettings(  
            .setIndex(TEST_INDEX)
                .getState()
                )  
    // create a new test index with un-allocated primary and no replicas
            String clusterManagerNodeName = internalCluster().client()
    // verify that the created index is not remote store backed
        internalCluster().client()
        );
            .admin()
 * SPDX-License-Identifier: Apache-2.0
    // obtain decision for allocation/relocation of a shard to a given node  
                Settings.builder()  
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName)
            .get();  
            }  
    }
            .prepareAllocationExplain()
        for (NodeAllocationResult nodeAllocationResult : nodeAllocationResults) {
        boolean includeYesDecisions,
                .execute()  
    protected void excludeAllNodes() {
                discoveryNode = node;  
        DiscoveryNode discoveryNode = null;
        ClusterAllocationExplanation explanation = internalCluster().client()
            if (nodeAllocationResult.getNode().equals(targetNode)) {
    public static void createIndex(String indexName, int replicaCount) {
        RestoreSnapshotResponse restoreSnapshotResponse = internalCluster().client()
        assertNotNull(requiredDecision);  
        if (targetNode != null) {
import org.opensearch.cluster.routing.allocation.decider.Decision;
                .indices()
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY;  
        assertNull(shardRouting.currentNodeId());
        ensureYellowAndNoInitializingShards(TEST_INDEX);
                .getName();
import org.opensearch.common.settings.Settings;
    protected void assertAllocation(boolean isPrimary, @Nullable DiscoveryNode targetNode) {
            ensureYellowAndNoInitializingShards(TEST_INDEX);
                }
    protected static final String NAME = "remote_store_migration";
        }
            settingsBuilder = Settings.builder()
            .index(TEST_INDEX)
                for (Decision decision : nodeAllocationResult.getCanAllocateDecision().getDecisions()) {  
            .getSettings()
            MoveDecision moveDecision = explanation.getShardAllocationDecision().getMoveDecision();  
        assertFalse(shardRouting.active());
            .indices()
        String indexName = name.orElse(TEST_INDEX);
                .prepareUpdateSettings(TEST_INDEX)
    // create a new test index with allocated primary and 1 unallocated replica
            .execute()  
        Settings indexSettings = internalCluster().client()
    public static void assertNonRemoteStoreBackedIndex(String indexName) {  
            .setRenameReplacement(restoredIndexName)
            .actionGet();
public class RemoteStoreMigrationShardAllocationBaseTestCase extends MigrationBaseTestCase {  
            .setWaitForActiveShards(ActiveShardCount.ONE)  
                )
            }  
            .admin()  
    protected static final String TEST_INDEX = "test_index";
                    Settings.builder()
    }
        StringBuilder exclude = new StringBuilder();
                .indices()  
                .prepareCreate(indexName)  
        assertNonAllocation(false);
                .put("index.routing.allocation.include._name", allNodesExcept(clusterManagerNodeName))
                    if (decision.label().equals(NAME)) {
                .prepareState()
            .prepareCreate(indexName)
                .cluster()
                .admin()  
            nodeAllocationResults = allocateUnassignedDecision.getNodeDecisions();
            .shard(0);
        return exclude.toString();
        internalCluster().client().admin().indices().prepareUpdateSettings(TEST_INDEX).setSettings(settingsBuilder).execute().actionGet();
    protected void assertNonAllocation(boolean isPrimary) {  
                        .put("index.routing.allocation.include._name", allNodesExcept(null))  
        logger.info(" --> verify non-allocation of replica shard");  
    // verify that the given nodeName exists in cluster
                .prepareUpdateSettings(TEST_INDEX)
            .getSnapshotInfo();
        assertAcked(internalCluster().client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());  
                        .put("index.routing.allocation.exclude._name", "")
        IndexShardRoutingTable table = internalCluster().client()
        if (isPrimary) {
            .get()  
        Decision requiredDecision = null;  
    }  
        Settings indexSettings = internalCluster().client()
                    .put("index.routing.allocation.exclude._name", allNodesExcept(null))
        assertEquals(restoreSnapshotResponse.status(), RestStatus.ACCEPTED);
                    .put("index.number_of_shards", 1)
    }  
                    .put("index.number_of_shards", 1)
            .admin()  
 *
import org.opensearch.snapshots.SnapshotState;  
        updateSettingsRequest.persistentSettings(Settings.builder().put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), mode));
                .put("index.routing.allocation.include._name", targetNodeName)
    }  
            .setIncludeYesDecisions(includeYesDecisions)
                Settings.builder()
import org.opensearch.common.Nullable;  
            .execute()
            internalCluster().client()
                        .build()
        assertAcked(  
            .cluster()
        }  
    // create a snapshot
    }
    // verify that shard does not exist at targetNode
                        break;  
        assertAcked(
    protected void prepareIndexWithoutReplica(Optional<String> name) {  
        updateSettingsRequest.persistentSettings(Settings.builder().putNull(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey()));
        } else {
    public static SnapshotInfo createSnapshot(String snapshotRepoName, String snapshotName, String... indices) {
            .indices()  
            .prepareGetIndex()
    protected ShardRouting getShardRouting(boolean isPrimary) {
 * The OpenSearch Contributors require contributions made to  
            .actionGet();
import org.opensearch.cluster.node.DiscoveryNodes;
            .cluster()  
    protected void includeAllNodes() {  
                .put("index.routing.allocation.exclude._name", allNodesExcept(targetNodeName));  
    // set the compatibility mode of cluster [strict, mixed]  
        for (DiscoveryNode node : allNodes) {  
        Map<String, DiscoveryNode> nodes = internalCluster().client().admin().cluster().prepareState().get().getState().nodes().getNodes();
package org.opensearch.remotemigration;
    }  
    // create new index  
            .execute()
            .setSettings(
    }  
            IndexSettings.DEFAULT_REMOTE_TRANSLOG_BUFFER_INTERVAL,  
        assertAcked(
    }
            if (node.getName().equals(except) == false) {
        return restoreSnapshotResponse;
import java.util.Optional;
        return snapshotInfo;  
        assertAcked(internalCluster().client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
            )
        DiscoveryNodes allNodes = internalCluster().client().admin().cluster().prepareState().get().getState().nodes();
import org.opensearch.core.rest.RestStatus;
            .admin()
        for (Map.Entry<String, DiscoveryNode> entry : nodes.entrySet()) {  
import org.opensearch.indices.replication.common.ReplicationType;
        assertNull(indexSettings.get(SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY));  
        boolean isPrimary,  
    }  
import org.opensearch.snapshots.SnapshotInfo;
        if (targetNodeName != null) {  
        if (isRelocation) {
            .actionGet()
                .admin()
        assertAllocation(true, primaryShardNode);
                .setSettings(
import static org.opensearch.node.remotestore.RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING;
import org.opensearch.cluster.routing.allocation.MoveDecision;  
            .execute()  
            }
import org.opensearch.cluster.routing.allocation.NodeAllocationResult;
            )
    }
                .getClusterManagerNode()
                .setSettings(
                break;
            .get()  
    // verify that shard exists at targetNode  
}
    }  
                .execute()
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
 * compatible open source license.
    protected Decision getDecisionForTargetNode(
            if (node.getName().equals(nodeName)) {
        assertEquals(ReplicationType.DOCUMENT.toString(), indexSettings.get(SETTING_REPLICATION_TYPE));  
            INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.get(indexSettings)
        List<NodeAllocationResult> nodeAllocationResults;
        assertEquals(REPOSITORY_2_NAME, indexSettings.get(SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY));
                .actionGet()
        String indexName = name.orElse(TEST_INDEX);  
                    .put("index.routing.allocation.exclude._name", allNodesExcept(primaryShardNode.getName()))
            DiscoveryNode node = entry.getValue();
            .get(indexName);
                .setSettings(  
    }
        assertEquals(0, snapshotInfo.failedShards());
/*  
        assertTrue(shardRouting.active());  
            .setRenamePattern(TEST_INDEX)
            .setPrimary(isPrimary)
                    }
                )  
                .indices()
    }
import java.util.Map;  
        assertTrue(snapshotInfo.successfulShards() > 0);
                    .put("index.routing.allocation.include._name", primaryShardNode.getName())  
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        );  
        DiscoveryNode targetNode,
import org.opensearch.cluster.routing.ShardRoutingState;
            .prepareGetIndex()
                        requiredDecision = decision;
    // set the migration direction for cluster [remote_store, docrep, none]
        } else {  
            .getExplanation();
    // restore indices from a snapshot
    protected void attemptAllocation(@Nullable String targetNodeName) {
    }  
        );
    }
        }
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, replicaCount)
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_STORE_ENABLED;
import org.opensearch.cluster.node.DiscoveryNode;  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            // to allocate freely among all nodes other than cluster-manager node  
    ) {  
                .actionGet()  
    protected String allNodesExcept(String except) {  
        assertEquals("true", indexSettings.get(SETTING_REMOTE_STORE_ENABLED));
                        .put("index.routing.allocation.exclude._name", allNodesExcept(null))
            .get(indexName);  
        SnapshotInfo snapshotInfo = internalCluster().client()  
                    .put("index.number_of_replicas", 1)
            .actionGet()  
            assertEquals(targetNode.getId(), shardRouting.currentNodeId());  
            .indices()  
    public void prepareIndexWithAllocatedPrimary(DiscoveryNode primaryShardNode, Optional<String> name) {
        }
            .admin()  
    // verify that the created index is remote store backed  
        return requiredDecision;
            internalCluster().client()  
import org.opensearch.action.admin.cluster.allocation.ClusterAllocationExplanation;
                .admin()  
            .prepareCreate(indexName)
import org.opensearch.action.support.ActiveShardCount;
import static org.opensearch.index.IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING;
        assertEquals(ShardRoutingState.UNASSIGNED, shardRouting.state());  
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;  
        assertEquals(SnapshotState.SUCCESS, snapshotInfo.state());  
            .setWaitForCompletion(false)
    }
        }
            .setShard(0)  
    protected void clearClusterMode() {  
        assertEquals(
            .admin()
        assertAcked(internalCluster().client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        return discoveryNode;
        assertEquals(ReplicationType.SEGMENT.toString(), indexSettings.get(SETTING_REPLICATION_TYPE));
 */  
            .actionGet()
    protected final ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
