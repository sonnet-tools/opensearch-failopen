                .cluster()
        Settings clusterSettings = Settings.builder()
        // Start network disruption - primary node will be isolated
        // communicate with the other node which it assumes has replica.
        int numOfDocs = randomIntBetween(5, 10);
    }
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;
import java.nio.file.Path;
        // to ensure replica is also upto date.
        ensureGreen(INDEX_NAME);
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
        return Stream.concat(super.nodePlugins().stream(), Stream.of(MockTransportService.TestPlugin.class)).collect(Collectors.toList());
    public void testPrimaryTermValidation() throws Exception {
    private static final String INDEX_NAME = "remote-store-test-idx-1";
    /**
        String clusterManagerNode = internalCluster().getClusterManagerName();
        );
            .put(remoteStoreClusterSettings(REPOSITORY_NAME, absolutePath, REPOSITORY_2_NAME, absolutePath2))
     * The fenced behavior of a partitioned stale primary is covered by {@code RemoteStoreFencingIT}.
            .put(FollowersChecker.FOLLOWER_CHECK_RETRY_COUNT_SETTING.getKey(), 1)
            new NetworkDisruption.TwoPartitions(nodesInOneSide, nodesInOtherSide),
import org.junit.Before;
        internalCluster().startDataOnlyNodes(2, clusterSettings);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        // with network partition faster. The follower check retry count is also kept 1.
    }
    public void setup() {
 * compatible open source license.
            assertEquals(1, clusterIndexHealth.getActivePrimaryShards());
            indexSameDoc(clusterManagerNode, INDEX_NAME);
            .actionGet();
        ensureStableCluster(3);
            .indices()
        // Index some docs and validate that both primary and replica node has it. Refresh is triggered to trigger segment replication
import java.util.HashSet;
            .setId(UUIDs.randomBase64UUID())
 * this file be licensed under the Apache-2.0 license or a
        // Get the names of nodes to create network disruption
            .put(LeaderChecker.LEADER_CHECK_TIMEOUT_SETTING.getKey(), "1s")
        absolutePath2 = randomRepoPath().toAbsolutePath();
import org.opensearch.common.UUIDs;
        for (int i = 0; i < numOfDocs; i++) {
        networkDisruption.startDisrupting();
     * enough to learn it is stale from its assumed replica's {@code ShardNotFoundException}. The object-store fence
            .execute()
import org.opensearch.action.support.IndicesOptions;
        createIndex(INDEX_NAME, remoteStoreIndexSettings(1));
            .get();
            () -> assertHitCount(client(replicaNode).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), numOfDocs)
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        // it assumes has the replica node). At this moment, the stale primary realises that it is no more the primary and the caller
        // When the index call is made to the stale primary, it makes the primary term validation call to the other node (which
        networkDisruption.stopDisrupting();
        absolutePath = randomRepoPath().toAbsolutePath();
     * deliberately preempts that mechanism — the isolated primary's next translog sync is refused by the successor's
        );
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
        // node to
        return false;
        }
        internalCluster().setDisruptionScheme(networkDisruption);
import org.opensearch.plugins.Plugin;
        // At this point we stop the disruption. Since the follower checker has already failed and cluster manager has removed the node
                .actionGet(TimeValue.timeValueSeconds(1));
        indexSameDoc(clusterManagerNode, INDEX_NAME);
        // from cluster, failed node needs to start discovery process by leader checker call. We stop the disruption to allow the failed
public class PrimaryTermValidationIT extends RemoteStoreBaseIntegTestCase {
        );
        RefreshResponse refreshResponse = client(clusterManagerNode).admin()
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            .put(LeaderChecker.LEADER_CHECK_INTERVAL_SETTING.getKey(), "20s")
     */
import static org.hamcrest.Matchers.equalTo;
        // Index data to the newly promoted primary
    private IndexResponse indexSameDoc(String nodeName, String indexName) {
    }
            assertEquals(ClusterHealthStatus.YELLOW, clusterIndexHealth.getStatus());
    @Override
import org.opensearch.test.disruption.NetworkDisruption;
 * SPDX-License-Identifier: Apache-2.0
        // Create index
        return client(nodeName).prepareIndex(indexName)
import org.opensearch.cluster.health.ClusterHealthStatus;
        String replicaNode = replicaNodeName(INDEX_NAME);
            assertEquals(1, clusterIndexHealth.getUnassignedShards());
    protected Path absolutePath;
        assertBusy(
    protected boolean remoteStoreFencingForAllIndices() {
            ClusterIndexHealth clusterIndexHealth = clusterHealthResponse.getIndices().get(INDEX_NAME);
            assertEquals(1, clusterIndexHealth.getNumberOfShards());
            .put(FollowersChecker.FOLLOWER_CHECK_INTERVAL_SETTING.getKey(), "1s")
            () -> assertHitCount(client(primaryNode).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), numOfDocs)
import java.util.stream.Stream;
    protected Path absolutePath2;
            assertThat(response.getNodes().size(), equalTo(2));
        internalCluster().clearDisruptionScheme();
/*
            NodesInfoResponse response = client(clusterManagerNode).admin().cluster().prepareNodesInfo().get();
        assertBusy(() -> {
        String primaryNode = primaryNodeName(INDEX_NAME);
     * This suite exercises the primary-term VALIDATION path: the isolated stale primary must stay writable long
package org.opensearch.remotestore;
    }
            .put(LeaderChecker.LEADER_CHECK_RETRY_COUNT_SETTING.getKey(), 4)
        // received the following exception.
 */
            assertEquals(ClusterHealthStatus.YELLOW, clusterHealthResponse.getStatus());
        NetworkDisruption networkDisruption = new NetworkDisruption(
        assertEquals(1, refreshResponse.getSuccessfulShards());
        assertBusy(
        // Ensure the node which is partitioned is removed from the cluster
            .setIndicesOptions(IndicesOptions.STRICT_EXPAND_OPEN_HIDDEN_FORBID_CLOSED)
        // Follower checker interval is lower compared to leader checker so that the cluster manager can remove the node
        // Ensure that the cluster manager has latest information about the index
import java.util.Collection;
        ensureGreen(INDEX_NAME);
        assertHitCount(client(replicaNode).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), numOfDocs + 1);
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
        assertNoFailures(refreshResponse);
            .build();
import org.opensearch.cluster.coordination.FollowersChecker;
        logger.info("Node names : clusterManager={} primary={} replica={}", clusterManagerNode, primaryNode, replicaNode);
import org.opensearch.action.index.IndexResponse;
import java.util.Set;
    @Before
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
            assertTrue(clusterHealthResponse.getIndices().containsKey(INDEX_NAME));
        ShardNotFoundException exception = assertThrows(ShardNotFoundException.class, () -> indexSameDoc(primaryNode, INDEX_NAME));
import org.opensearch.test.transport.MockTransportService;
import org.opensearch.cluster.coordination.LeaderChecker;
            .setSource("{\"foo\" : \"bar\"}", MediaTypeRegistry.JSON)
        Set<String> nodesInOneSide = Stream.of(clusterManagerNode, replicaNode).collect(Collectors.toCollection(HashSet::new));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
import org.opensearch.index.shard.ShardNotFoundException;
import org.opensearch.cluster.health.ClusterIndexHealth;
        });
 * The OpenSearch Contributors require contributions made to
                .health(new ClusterHealthRequest())
            assertEquals(1, clusterIndexHealth.getActiveShards());
    }
            .put(FollowersChecker.FOLLOWER_CHECK_TIMEOUT_SETTING.getKey(), "1s")
import org.opensearch.test.OpenSearchIntegTestCase;
        Set<String> nodesInOtherSide = Stream.of(primaryNode).collect(Collectors.toCollection(HashSet::new));
            .prepareRefresh(INDEX_NAME)
        refresh(INDEX_NAME);
     * fence and the shard fails itself before term validation is ever consulted — so fencing must stay off here.
        assertTrue(exception.getMessage().contains("no such shard"));
import java.util.stream.Collectors;
            assertEquals(1, clusterIndexHealth.getUnassignedShards());
        internalCluster().startClusterManagerOnlyNode(clusterSettings);
}
        });
    @Override
 *
        assertBusy(() -> {
import org.opensearch.common.unit.TimeValue;
import org.opensearch.common.settings.Settings;
            NetworkDisruption.DISCONNECT
        logger.info("--> network disruption is started");
            ClusterHealthResponse clusterHealthResponse = client(clusterManagerNode).admin()
