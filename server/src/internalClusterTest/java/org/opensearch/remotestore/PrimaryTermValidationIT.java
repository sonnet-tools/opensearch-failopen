        NetworkDisruption networkDisruption = new NetworkDisruption(
        for (int i = 0; i < numOfDocs; i++) {
        createIndex(INDEX_NAME, remoteStoreIndexSettings(1));
        // At this point we stop the disruption. Since the follower checker has already failed and cluster manager has removed the node
     * fence and the shard fails itself before term validation is ever consulted — so fencing must stay off here.
            () -> assertHitCount(client(primaryNode).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), numOfDocs)
import org.opensearch.test.transport.MockTransportService;
        });  
            .get();
 *
        assertBusy(  
        // it assumes has the replica node). At this moment, the stale primary realises that it is no more the primary and the caller  
        // from cluster, failed node needs to start discovery process by leader checker call. We stop the disruption to allow the failed  
import java.util.Collection;
import java.util.stream.Stream;  
import org.opensearch.test.OpenSearchIntegTestCase;
        assertEquals(1, refreshResponse.getSuccessfulShards());
            .put(LeaderChecker.LEADER_CHECK_INTERVAL_SETTING.getKey(), "20s")
}  
 */  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
    }
import org.opensearch.cluster.coordination.LeaderChecker;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
            ClusterIndexHealth clusterIndexHealth = clusterHealthResponse.getIndices().get(INDEX_NAME);
import org.opensearch.cluster.coordination.FollowersChecker;
            assertEquals(1, clusterIndexHealth.getUnassignedShards());  
        ensureGreen(INDEX_NAME);  
        internalCluster().startClusterManagerOnlyNode(clusterSettings);  
import org.opensearch.common.settings.Settings;  
            assertEquals(1, clusterIndexHealth.getActivePrimaryShards());
        RefreshResponse refreshResponse = client(clusterManagerNode).admin()
        // Create index  
        // Start network disruption - primary node will be isolated
        assertTrue(exception.getMessage().contains("no such shard"));  
import org.opensearch.common.unit.TimeValue;
            NodesInfoResponse response = client(clusterManagerNode).admin().cluster().prepareNodesInfo().get();
        }
    @Override
            assertEquals(ClusterHealthStatus.YELLOW, clusterHealthResponse.getStatus());
            .put(FollowersChecker.FOLLOWER_CHECK_RETRY_COUNT_SETTING.getKey(), 1)  
    protected Path absolutePath2;
        );
        refresh(INDEX_NAME);
        ShardNotFoundException exception = assertThrows(ShardNotFoundException.class, () -> indexSameDoc(primaryNode, INDEX_NAME));
        internalCluster().clearDisruptionScheme();
    }
        logger.info("--> network disruption is started");  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
    }
    protected boolean remoteStoreFencingForAllIndices() {  
public class PrimaryTermValidationIT extends RemoteStoreBaseIntegTestCase {
        ensureGreen(INDEX_NAME);  
            new NetworkDisruption.TwoPartitions(nodesInOneSide, nodesInOtherSide),
        networkDisruption.startDisrupting();
import org.opensearch.index.shard.ShardNotFoundException;  
    protected Path absolutePath;
            assertEquals(1, clusterIndexHealth.getActiveShards());
            .put(remoteStoreClusterSettings(REPOSITORY_NAME, absolutePath, REPOSITORY_2_NAME, absolutePath2))
        // node to
        indexSameDoc(clusterManagerNode, INDEX_NAME);  
            NetworkDisruption.DISCONNECT  
    }
            .execute()
            .put(LeaderChecker.LEADER_CHECK_TIMEOUT_SETTING.getKey(), "1s")
        String clusterManagerNode = internalCluster().getClusterManagerName();
        assertHitCount(client(replicaNode).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), numOfDocs + 1);  
        String primaryNode = primaryNodeName(INDEX_NAME);  
        logger.info("Node names : clusterManager={} primary={} replica={}", clusterManagerNode, primaryNode, replicaNode);  
        // Follower checker interval is lower compared to leader checker so that the cluster manager can remove the node
    }
            .actionGet();  
        return client(nodeName).prepareIndex(indexName)
 * compatible open source license.
        assertBusy(() -> {
import static org.hamcrest.Matchers.equalTo;
        // communicate with the other node which it assumes has replica.
import org.opensearch.action.support.IndicesOptions;  
import java.util.stream.Collectors;
import org.opensearch.test.disruption.NetworkDisruption;  
        // Ensure the node which is partitioned is removed from the cluster  
            indexSameDoc(clusterManagerNode, INDEX_NAME);  
    public void testPrimaryTermValidation() throws Exception {  
            .prepareRefresh(INDEX_NAME)  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            assertTrue(clusterHealthResponse.getIndices().containsKey(INDEX_NAME));  
        // Get the names of nodes to create network disruption
        Settings clusterSettings = Settings.builder()  
        // with network partition faster. The follower check retry count is also kept 1.
        Set<String> nodesInOneSide = Stream.of(clusterManagerNode, replicaNode).collect(Collectors.toCollection(HashSet::new));
            .setId(UUIDs.randomBase64UUID())
            assertEquals(1, clusterIndexHealth.getUnassignedShards());
        );
            () -> assertHitCount(client(replicaNode).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), numOfDocs)
                .health(new ClusterHealthRequest())
            assertEquals(1, clusterIndexHealth.getNumberOfShards());  
    @Before  
            assertThat(response.getNodes().size(), equalTo(2));  
     */
import org.opensearch.common.UUIDs;
            .indices()
        networkDisruption.stopDisrupting();  
            .put(LeaderChecker.LEADER_CHECK_RETRY_COUNT_SETTING.getKey(), 4)  
package org.opensearch.remotestore;
            .setSource("{\"foo\" : \"bar\"}", MediaTypeRegistry.JSON)  
                .actionGet(TimeValue.timeValueSeconds(1));
        assertBusy(  
import java.util.Set;
        ensureStableCluster(3);
import org.opensearch.plugins.Plugin;
        Set<String> nodesInOtherSide = Stream.of(primaryNode).collect(Collectors.toCollection(HashSet::new));  
            .build();
import java.util.HashSet;  
        int numOfDocs = randomIntBetween(5, 10);
                .cluster()  
        });
        // Index some docs and validate that both primary and replica node has it. Refresh is triggered to trigger segment replication
            .put(FollowersChecker.FOLLOWER_CHECK_TIMEOUT_SETTING.getKey(), "1s")
        internalCluster().startDataOnlyNodes(2, clusterSettings);
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
     * The fenced behavior of a partitioned stale primary is covered by {@code RemoteStoreFencingIT}.  
 * SPDX-License-Identifier: Apache-2.0
        String replicaNode = replicaNodeName(INDEX_NAME);
    private IndexResponse indexSameDoc(String nodeName, String indexName) {  
        // When the index call is made to the stale primary, it makes the primary term validation call to the other node (which
/*  
import org.opensearch.cluster.health.ClusterIndexHealth;
        );
            .setIndicesOptions(IndicesOptions.STRICT_EXPAND_OPEN_HIDDEN_FORBID_CLOSED)
        assertBusy(() -> {
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        absolutePath = randomRepoPath().toAbsolutePath();
     * This suite exercises the primary-term VALIDATION path: the isolated stale primary must stay writable long
import org.junit.Before;
    @Override
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;  
        absolutePath2 = randomRepoPath().toAbsolutePath();  
    private static final String INDEX_NAME = "remote-store-test-idx-1";  
import java.nio.file.Path;
 * this file be licensed under the Apache-2.0 license or a
        return false;
        // received the following exception.
        return Stream.concat(super.nodePlugins().stream(), Stream.of(MockTransportService.TestPlugin.class)).collect(Collectors.toList());  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        // to ensure replica is also upto date.  
        // Index data to the newly promoted primary
        assertNoFailures(refreshResponse);
import org.opensearch.cluster.health.ClusterHealthStatus;  
     * enough to learn it is stale from its assumed replica's {@code ShardNotFoundException}. The object-store fence  
        internalCluster().setDisruptionScheme(networkDisruption);
    /**
            assertEquals(ClusterHealthStatus.YELLOW, clusterIndexHealth.getStatus());
     * deliberately preempts that mechanism — the isolated primary's next translog sync is refused by the successor's
import org.opensearch.action.index.IndexResponse;
            ClusterHealthResponse clusterHealthResponse = client(clusterManagerNode).admin()
    public void setup() {
        // Ensure that the cluster manager has latest information about the index  
            .put(FollowersChecker.FOLLOWER_CHECK_INTERVAL_SETTING.getKey(), "1s")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;  
