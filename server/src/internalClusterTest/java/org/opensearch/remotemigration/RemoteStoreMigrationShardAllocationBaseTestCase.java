        return requiredDecision;
                .getClusterManagerNode()
            MoveDecision moveDecision = explanation.getShardAllocationDecision().getMoveDecision();
                .execute()
        assertAcked(internalCluster().client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
                    .put("index.number_of_replicas", 1)
            .execute()
                .getNodes()
                .actionGet()
            .execute()
        assertNull(indexSettings.get(SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY));
import static org.opensearch.index.IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING;
        boolean includeYesDecisions,
            .admin()
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;
    // set the compatibility mode of cluster [strict, mixed]
            .cluster()
 *
        );
    }
        }
                    .put("index.routing.allocation.include._name", primaryShardNode.getName())
                Settings.builder()
                .execute()
            .setIndices(TEST_INDEX)
            internalCluster().client()
    protected DiscoveryNode assertNodeInCluster(String nodeName) {
 * The OpenSearch Contributors require contributions made to
            .getSnapshotInfo();
        Settings.Builder settingsBuilder;
            .get()
        }
    // verify that the created index is remote store backed
                    .put("index.number_of_shards", 1)
    // verify that shard does not exist at targetNode
        DiscoveryNode targetNode,
    }
            .setPrimary(isPrimary)
    // create a new test index with allocated primary and 1 unallocated replica
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_STORE_ENABLED;
            .admin()
            ensureRed(TEST_INDEX);
        assertTrue(snapshotInfo.successfulShards() > 0);
                .actionGet()
                    Settings.builder()
        } else {
 * compatible open source license.
        assertAcked(internalCluster().client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
            internalCluster().client()
                .actionGet()
            .indices()
            .prepareAllocationExplain()
            .get();
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName)
    }
                discoveryNode = node;
    public static void assertNonRemoteStoreBackedIndex(String indexName) {
        String indexName = name.orElse(TEST_INDEX);
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
        DiscoveryNodes allNodes = internalCluster().client().admin().cluster().prepareState().get().getState().nodes();
        assertEquals("true", indexSettings.get(SETTING_REMOTE_STORE_ENABLED));
                .get()
    }
                .cluster()
    protected final ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
            assertEquals(targetNode.getId(), shardRouting.currentNodeId());
        if (targetNodeName != null) {
    protected void attemptAllocation(@Nullable String targetNodeName) {
            }
        List<NodeAllocationResult> nodeAllocationResults;
                )
                    .put("index.number_of_replicas", 0)
                    if (decision.label().equals(NAME)) {
        assertAcked(internalCluster().client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        assertNotNull(shardRouting.currentNodeId());
            nodeAllocationResults = allocateUnassignedDecision.getNodeDecisions();
                .admin()
        IndexShardRoutingTable table = internalCluster().client()
    }
                .admin()
        assertEquals(SnapshotState.SUCCESS, snapshotInfo.state());
            .prepareCreate(indexName)
        ShardRouting shardRouting = getShardRouting(isPrimary);
        }
        assertNull(shardRouting.currentNodeId());
import org.opensearch.cluster.routing.allocation.MoveDecision;
    }
        } else {
import org.opensearch.cluster.node.DiscoveryNodes;
        Decision requiredDecision = null;
    protected void excludeAllNodes() {
import org.opensearch.cluster.node.DiscoveryNode;
    // obtain decision for allocation/relocation of a shard to a given node
                )
            .setRenameReplacement(restoredIndexName)
    protected String allNodesExcept(String except) {
        );
        assertNull(indexSettings.get(SETTING_REMOTE_STORE_ENABLED));
            .getExplanation();
                Settings.builder()
import org.opensearch.common.Nullable;
            }
    public static SnapshotInfo createSnapshot(String snapshotRepoName, String snapshotName, String... indices) {
                        break;
            .getSettings()
            .admin()
    protected void prepareIndexWithoutReplica(Optional<String> name) {
}
        boolean isRelocation
                        requiredDecision = decision;
                    Settings.builder()
            .setShard(0)
                        .put("index.routing.allocation.exclude._name", allNodesExcept(null))
            .prepareState()
import org.opensearch.cluster.routing.IndexShardRoutingTable;
    }
        logger.info(" --> verify non-allocation of replica shard");
            .get(indexName);
 * SPDX-License-Identifier: Apache-2.0
        updateSettingsRequest.persistentSettings(Settings.builder().put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), mode));
        assertAcked(
            .setWaitForCompletion(false)
        RestoreSnapshotResponse restoreSnapshotResponse = internalCluster().client()
import org.opensearch.snapshots.SnapshotInfo;
            if (node.getName().equals(nodeName)) {
        DiscoveryNode discoveryNode = null;
        assertEquals(restoreSnapshotResponse.status(), RestStatus.ACCEPTED);
            String clusterManagerNodeName = internalCluster().client()
            .indices()
        assertNull(indexSettings.get(SETTING_REMOTE_SEGMENT_STORE_REPOSITORY));
    // restore indices from a snapshot
                        .put("index.routing.allocation.include._name", "")
                .getName();
                .execute()
import java.util.List;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY;
import org.opensearch.cluster.routing.allocation.AllocateUnassignedDecision;
        return (isPrimary ? table.primaryShard() : table.replicaShards().get(0));
        Settings indexSettings = internalCluster().client()
            .setWaitForCompletion(true)
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertEquals(
        updateSettingsRequest.persistentSettings(Settings.builder().putNull(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey()));
    protected void clearClusterMode() {
                .indices()
    }
 */
                    .put("index.number_of_shards", 1)
        for (NodeAllocationResult nodeAllocationResult : nodeAllocationResults) {
                .prepareUpdateSettings(TEST_INDEX)
        );
            }
/*
        for (Map.Entry<String, DiscoveryNode> entry : nodes.entrySet()) {
            .setRenamePattern(TEST_INDEX)
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.common.settings.Settings;
            .index(TEST_INDEX)
        return discoveryNode;
    ) {
            .setWaitForActiveShards(ActiveShardCount.ONE)
            settingsBuilder = Settings.builder()
            .shard(0);
                .setSettings(
        }
                .setSettings(
import org.opensearch.cluster.routing.ShardRoutingState;
        Settings indexSettings = internalCluster().client()
                        .put("index.routing.allocation.include._name", allNodesExcept(null))
    public static void assertRemoteStoreBackedIndex(String indexName) {
                .getState()
    // create a snapshot
            .admin()
            ensureYellowAndNoInitializingShards(TEST_INDEX);
                .prepareCreate(indexName)
    }
            .cluster()
    protected static final String NAME = "remote_store_migration";
import org.opensearch.core.rest.RestStatus;
                .admin()
            IndexSettings.DEFAULT_REMOTE_TRANSLOG_BUFFER_INTERVAL,
            .execute()
        assertAcked(
            .setSettings(
            .getState()
            .setIndices(indices)
        assertNonAllocation(false);
            )
            settingsBuilder = Settings.builder()
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, replicaCount)
            .prepareCreate(indexName)
                exclude.append(node.getName()).append(",");
    }
            .indices()
    protected static final String TEST_INDEX = "test_index";
            .get(indexName);
import org.opensearch.action.admin.cluster.allocation.ClusterAllocationExplanation;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                        .put("index.routing.allocation.exclude._name", "")
            .cluster()
    // verify that the created index is not remote store backed
                }
            AllocateUnassignedDecision allocateUnassignedDecision = explanation.getShardAllocationDecision().getAllocateDecision();
    }
    }
    }
                for (Decision decision : nodeAllocationResult.getCanAllocateDecision().getDecisions()) {
        );
    // create a new test index with un-allocated primary and no replicas
import java.util.Map;
    }
            .admin()
            .getRoutingTable()
        if (isRelocation) {
        for (DiscoveryNode node : allNodes) {
        assertEquals(REPOSITORY_NAME, indexSettings.get(SETTING_REMOTE_SEGMENT_STORE_REPOSITORY));
                .put("index.routing.allocation.include._name", targetNodeName)
        ensureYellowAndNoInitializingShards(TEST_INDEX);
        ClusterAllocationExplanation explanation = internalCluster().client()
    protected void includeAllNodes() {
            .execute()
    protected ShardRouting getShardRouting(boolean isPrimary) {
        assertNotNull(requiredDecision);
    // verify that shard exists at targetNode
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;
    // get allocation and relocation decisions for all nodes
            .actionGet()
        assertTrue(shardRouting.active());
            .actionGet();
    }
            .execute()
            DiscoveryNode node = entry.getValue();
            .setIncludeYesDecisions(includeYesDecisions)
            )
        }
            .admin()
                .prepareUpdateSettings(TEST_INDEX)
import org.opensearch.index.IndexSettings;
        internalCluster().client()
            if (node.getName().equals(except) == false) {
            .admin()
        return exclude.toString();
            // to allocate freely among all nodes other than cluster-manager node
        assertNotNull(discoveryNode);
                .indices()
import java.util.Optional;
        boolean isPrimary,
                    .put("index.routing.allocation.exclude._name", allNodesExcept(null))
                )
    public static void createIndex(String indexName, int replicaCount) {
            .get()
                    }
    protected void setDirection(String direction) {
            .getSettings()
        assertAcked(
                .admin()
            .setIndex(TEST_INDEX)
            .prepareCreateSnapshot(snapshotRepoName, snapshotName)
        logger.info(" --> verify allocation of primary shard");
                    .put("index.routing.allocation.exclude._name", allNodesExcept(primaryShardNode.getName()))
package org.opensearch.remotemigration;
    // verify that the given nodeName exists in cluster
        if (isPrimary) {
        Map<String, DiscoveryNode> nodes = internalCluster().client().admin().cluster().prepareState().get().getState().nodes().getNodes();
    public void prepareIndexWithAllocatedPrimary(DiscoveryNode primaryShardNode, Optional<String> name) {
    public static RestoreSnapshotResponse restoreSnapshot(String snapshotRepoName, String snapshotName, String restoredIndexName) {
    // returns a comma-separated list of node names excluding `except`
            .setSettings(
                break;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY;
                .put("index.routing.allocation.exclude._name", clusterManagerNodeName);
import org.opensearch.cluster.routing.allocation.decider.Decision;
            .indices()
                        .build()
        assertEquals(ReplicationType.DOCUMENT.toString(), indexSettings.get(SETTING_REPLICATION_TYPE));
        return snapshotInfo;
    }
        }
                .put("index.routing.allocation.include._name", allNodesExcept(clusterManagerNodeName))
            INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.get(indexSettings)
    protected Decision getDecisionForTargetNode(
    // create new index
import org.opensearch.indices.replication.common.ReplicationType;
    protected void assertAllocation(boolean isPrimary, @Nullable DiscoveryNode targetNode) {
                    Settings.builder()
public class RemoteStoreMigrationShardAllocationBaseTestCase extends MigrationBaseTestCase {
        internalCluster().client()
import org.opensearch.snapshots.SnapshotState;
        SnapshotInfo snapshotInfo = internalCluster().client()
            .prepareGetIndex()
            if (nodeAllocationResult.getNode().equals(targetNode)) {
        assertFalse(shardRouting.active());
            .admin()
            .actionGet()
            .cluster()
        internalCluster().client().admin().indices().prepareUpdateSettings(TEST_INDEX).setSettings(settingsBuilder).execute().actionGet();
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
        } else {
import org.opensearch.cluster.routing.ShardRouting;
            nodeAllocationResults = moveDecision.getNodeDecisions();
        if (targetNode != null) {
        assertEquals(REPOSITORY_2_NAME, indexSettings.get(SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY));
        return restoreSnapshotResponse;
    }
    protected void assertNonAllocation(boolean isPrimary) {
                .indices()
        assertEquals(ReplicationType.SEGMENT.toString(), indexSettings.get(SETTING_REPLICATION_TYPE));
    }
    protected void setClusterMode(String mode) {
    }
    // set the migration direction for cluster [remote_store, docrep, none]
            .actionGet();
        }
                .setSettings(
import static org.opensearch.node.remotestore.RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING;
import org.opensearch.cluster.routing.allocation.NodeAllocationResult;
        assertEquals(0, snapshotInfo.failedShards());
                .prepareState()
            .prepareGetIndex()
        StringBuilder exclude = new StringBuilder();
        assertEquals(ShardRoutingState.UNASSIGNED, shardRouting.state());
            internalCluster().client()
        updateSettingsRequest.persistentSettings(Settings.builder().put(MIGRATION_DIRECTION_SETTING.getKey(), direction));
import org.opensearch.action.support.ActiveShardCount;
        ShardRouting shardRouting = getShardRouting(isPrimary);
            .actionGet()
                .put("index.routing.allocation.exclude._name", allNodesExcept(targetNodeName));
        assertAllocation(true, primaryShardNode);
        String indexName = name.orElse(TEST_INDEX);
 * this file be licensed under the Apache-2.0 license or a
