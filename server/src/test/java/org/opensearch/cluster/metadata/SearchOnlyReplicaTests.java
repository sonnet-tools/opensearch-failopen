        this.threadPool = new TestThreadPool(getClass().getName());
import org.opensearch.repositories.fs.FsRepository;
        );
        );
        }  
    public static final String TEST_RS_REPO = "test-rs-repo";
import org.opensearch.cluster.routing.IndexShardRoutingTable;
import org.junit.Before;  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY;  
    public void testUpdateSearchReplicasOnDocrepCluster() {
    public void testCreateWithDefaultSearchReplicasSetting() {
            .put(SETTING_NUMBER_OF_REPLICAS, 0)
import org.opensearch.indices.cluster.ClusterStateChanges;
        Set<DiscoveryNodeRole> roles = new HashSet<>(randomSubsetOf(DiscoveryNodeRole.BUILT_IN_ROLES));  
            exception.getCause().getMessage()  
                .put(SETTING_NUMBER_OF_REPLICAS, 0)
            "To set index.number_of_search_replicas, index.remote_store.enabled must be set to true",
import org.opensearch.action.admin.indices.create.CreateIndexRequest;  
            .put("node.attr." + REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, repoName)
        // node for search replicas - we'll start with 1 and add another  
        assertEquals(0, indexShardRoutingTable.searchOnlyReplicas().size());
import org.opensearch.common.settings.Settings;
        // add another replica  
    }  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT;
        state = cluster.createIndex(state, request);  
        super.setUp();
import org.opensearch.env.Environment;
        return Settings.builder()  
import java.util.HashSet;
    @Before
            () -> client().admin().indices().updateSettings(updateSettingsRequest).get()
import org.opensearch.action.support.ActiveShardCount;
        IndexShardRoutingTable indexShardRoutingTable = getIndexShardRoutingTable();
package org.opensearch.cluster.metadata;
            .build();
        // node for primary/local
            .put(repoSettingsAttributeKeyPrefix + "location", repoPath)  
            RuntimeException.class,
        return Settings.builder()  
        );  
            .put(repoSettingsAttributeKeyPrefix + "location", repoPath)  
        CreateIndexRequest request = new CreateIndexRequest(INDEX_NAME, settings).waitForActiveShards(ActiveShardCount.NONE);  
        client().admin().indices().updateSettings(updateSettingsRequest).get();
    public static final String INDEX_NAME = "test-index";
    Path tempDir = createTempDir();
    public void testUpdateSearchReplicasOverShardLimit() {
        );
            Settings.builder().put(SETTING_NUMBER_OF_SEARCH_REPLICAS, maxShardPerNode * 2).build()
        return client().admin().cluster().prepareState().get().getState().getRoutingTable().index(INDEX_NAME).getShards().get(0);
        UpdateSettingsRequest updateSettingsRequest = new UpdateSettingsRequest(INDEX_NAME).settings(
            )
    }
            state = cluster.reroute(state, new ClusterRerouteRequest());
            Locale.getDefault(),
            Settings.builder()  
import org.opensearch.cluster.routing.ShardRoutingState;
        Integer maxShardPerNode = ShardLimitValidator.SETTING_CLUSTER_MAX_SHARDS_PER_NODE.getDefault(Settings.EMPTY);
        CreateIndexRequest request = new CreateIndexRequest(
import org.opensearch.test.OpenSearchSingleNodeTestCase;
    }
        client().admin().indices().updateSettings(updateSettingsRequest).get();
            .put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 0)
    protected Settings nodeSettings() {
import java.util.Collections;
    }
    }  
    public void setUp() throws Exception {  
            .put(repoTypeAttributeKey, FsRepository.TYPE)
        final ClusterStateChanges cluster = new ClusterStateChanges(xContentRegistry(), threadPool);  
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteRequest;
import org.opensearch.cluster.ClusterState;
                    .put(SETTING_NUMBER_OF_SHARDS, 1)  
    @Override
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
        // node for primary/local  
import java.util.List;  
import java.nio.file.Path;
        assertEquals(2, indexShardRoutingTable.replicaShards().size());  
import static org.opensearch.indices.IndicesService.CLUSTER_REPLICATION_TYPE_SETTING;
    public void testSearchReplicasValidationWithDocumentReplication() {
        );  
        assertEquals(0, indexShardRoutingTable.searchOnlyReplicas().size());
        );
            .put(repoSettingsAttributeKeyPrefix + "location", repoPath)  
                    .put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)  
import java.util.ArrayList;  
        updateSettingsRequest = new UpdateSettingsRequest(INDEX_NAME).settings(
    }  
        String repoSettingsAttributeKeyPrefix = String.format(  
        assertEquals(
        return state;
    }
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX;  
        createIndex(INDEX_NAME, settings);
            .put(repoTypeAttributeKey, FsRepository.TYPE)
        assertEquals(1, indexShardRoutingTable.replicaShards().size());  
        final ClusterStateChanges cluster = new ClusterStateChanges(xContentRegistry(), threadPool);  
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.cluster.node.DiscoveryNodeRole;  
import java.util.concurrent.atomic.AtomicInteger;
            .build();  
import java.util.Set;
}
        String repoTypeAttributeKey = String.format(
        Collections.addAll(roles, mustHaveRoles);
    }
    }  
        allNodes.add(localNode);
            () -> createIndexWithSettings(  
        );  
                finalState,
 *
                .build()
                    .put(SETTING_NUMBER_OF_REPLICAS, 0)
        // add another replica
                cluster,
        DiscoveryNode localNode = createNode(Version.CURRENT, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE);  
        createIndex(INDEX_NAME, settings);  
            .put(SETTING_NUMBER_OF_REPLICAS, 0)
import org.opensearch.Version;
            )
            "node.attr." + REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,  
        allNodes.add(localNode);
        return new DiscoveryNode(id, id, buildNewFakeTransportAddress(), Collections.emptyMap(), roles, version);  
    public void testUpdateSearchReplicaCount() throws ExecutionException, InterruptedException {
            .put(buildRemoteStoreNodeAttributes(TEST_RS_REPO, repo))  
                new UpdateSettingsRequest(INDEX_NAME).settings(
        super.tearDown();
            .build();
        ClusterState finalState = state;
        terminate(threadPool);
            );
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;  
            .put(repoTypeAttributeKey, FsRepository.TYPE)
            .put(RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), false)
    private static void rerouteUntilActive(ClusterState state, ClusterStateChanges cluster) {
        Throwable cause = executionException.getCause();  
        assertEquals(1, indexShardRoutingTable.searchOnlyReplicas().size());  
                state,
            .put(super.nodeSettings())
    private Settings buildRemoteStoreNodeAttributes(String repoName, Path repoPath) {  
        Settings settings = Settings.builder()  
import org.opensearch.common.ValidationException;  
        ).waitForActiveShards(ActiveShardCount.NONE);
        assertEquals(0, indexShardRoutingTable.writerReplicas().size());
        assertEquals(0, indexShardRoutingTable.writerReplicas().size());
            "node.attr." + REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY;
        ClusterState state = ClusterStateCreationUtils.state(localNode, localNode, allNodes.toArray(new DiscoveryNode[0]));
public class SearchOnlyReplicaTests extends OpenSearchSingleNodeTestCase {
    public void tearDown() throws Exception {  
        assertEquals(0, indexShardRoutingTable.replicaShards().size());
    }  
                    .put(INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.DOCUMENT)
 * this file be licensed under the Apache-2.0 license or a
            .put(SETTING_NUMBER_OF_SHARDS, 1)  
        assertEquals(1, indexShardRoutingTable.replicaShards().size());
        UpdateSettingsRequest updateSettingsRequest = new UpdateSettingsRequest(INDEX_NAME).settings(  
 * compatible open source license.
        Integer maxShardPerNode = ShardLimitValidator.SETTING_CLUSTER_MAX_SHARDS_PER_NODE.getDefault(Settings.EMPTY);  
            .build();
        );
            INDEX_NAME,
        allNodes.add(createNode(Version.CURRENT, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE));  
        ExecutionException executionException = expectThrows(
            () -> cluster.updateSettings(  
        assertTrue(state.metadata().hasIndex(INDEX_NAME));
    }
        assertEquals(0, indexShardRoutingTable.writerReplicas().size());  
        indexShardRoutingTable = getIndexShardRoutingTable();  
 */  
                Settings.builder()
import org.opensearch.threadpool.TestThreadPool;  
        indexShardRoutingTable = getIndexShardRoutingTable();
        // add another replica
    }
        final ClusterStateChanges cluster = new ClusterStateChanges(xContentRegistry(), threadPool);
                )
            .put(SETTING_NUMBER_OF_SHARDS, 1)
        for (int i = 0; i < 2; i++) {
            .put(CLUSTER_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT)
        expectThrows(
                state.routingTable().index(INDEX_NAME).shard(0).shardsWithState(ShardRoutingState.INITIALIZING)  
import org.opensearch.cluster.node.DiscoveryNode;
            RuntimeException.class,
        );
        state = cluster.createIndex(state, request);
                .put(SETTING_NUMBER_OF_SHARDS, 1)
/*  
            .put("node.attr." + REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY, repoName)
import org.opensearch.indices.replication.common.ReplicationType;  
        assertEquals(ValidationException.class, cause.getClass());
 * SPDX-License-Identifier: Apache-2.0
            .put(Environment.PATH_REPO_SETTING.getKey(), repo)
            .put("node.attr." + REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, repoName)
        rerouteUntilActive(state, cluster);
                    .build()
    private ClusterState createIndexWithSettings(ClusterStateChanges cluster, Settings settings) {
        RuntimeException exception = expectThrows(
            .put(Environment.PATH_HOME_SETTING.getKey(), tempDir)
import org.opensearch.action.support.replication.ClusterStateCreationUtils;  
        Settings settings = Settings.builder()
            Settings.builder().put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 2).build()
        assertEquals(1, indexShardRoutingTable.writerReplicas().size());
import java.util.concurrent.ExecutionException;  
        List<DiscoveryNode> allNodes = new ArrayList<>();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS;
        List<DiscoveryNode> allNodes = new ArrayList<>();
            ExecutionException.class,  
    private static final AtomicInteger nodeIdGenerator = new AtomicInteger();  
        DiscoveryNode localNode = createNode(Version.CURRENT, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE);
            repoName
    private ThreadPool threadPool;  
import org.junit.After;
    protected DiscoveryNode createNode(Version version, DiscoveryNodeRole... mustHaveRoles) {
        ClusterState state = ClusterStateCreationUtils.state(localNode, localNode, allNodes.toArray(new DiscoveryNode[0]));
import org.opensearch.gateway.remote.RemoteClusterStateService;  
            .put(INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT)  
    Path repo = tempDir.resolve("repo");
            Settings.builder().put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 0).build()  
        // remove all replicas
            repoName  
    @After
        ClusterState state = createIndexWithSettings(cluster, Settings.builder().build());
            allNodes.add(createNode(Version.CURRENT, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE));
import org.opensearch.indices.ShardLimitValidator;
import java.util.Locale;
        final String id = String.format(Locale.ROOT, "node_%03d", nodeIdGenerator.incrementAndGet());
            .put(INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT)
                    Settings.builder().put(SETTING_NUMBER_OF_SEARCH_REPLICAS, maxShardPerNode * 2).build()  
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_REPLICATION_TYPE_SETTING;  
        }  
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;
            state = cluster.applyStartedShards(
        assertEquals(2, indexShardRoutingTable.searchOnlyReplicas().size());
    }
                .put(INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.DOCUMENT)  
            Locale.getDefault(),
            .put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)  
    private IndexShardRoutingTable getIndexShardRoutingTable() {  
        IndexShardRoutingTable indexShardRoutingTable = state.getRoutingTable().index(INDEX_NAME).getShards().get(0);
        while (state.routingTable().index(INDEX_NAME).shard(0).allShardsStarted() == false) {  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY;
 * The OpenSearch Contributors require contributions made to  
