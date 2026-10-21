import org.opensearch.indices.ShardLimitValidator;
                    Settings.builder().put(SETTING_NUMBER_OF_SEARCH_REPLICAS, maxShardPerNode * 2).build()
            ExecutionException.class,
                .put(SETTING_NUMBER_OF_SHARDS, 1)
    Path repo = tempDir.resolve("repo");
    protected DiscoveryNode createNode(Version version, DiscoveryNodeRole... mustHaveRoles) {
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT;
    public void setUp() throws Exception {
        rerouteUntilActive(state, cluster);
                .build()
    }
            repoName
    }
        DiscoveryNode localNode = createNode(Version.CURRENT, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE);
import org.opensearch.cluster.node.DiscoveryNode;
        assertEquals(1, indexShardRoutingTable.replicaShards().size());
                    .put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)
 * this file be licensed under the Apache-2.0 license or a
            .put(repoTypeAttributeKey, FsRepository.TYPE)
            () -> createIndexWithSettings(
                    .build()
        allNodes.add(localNode);
            .put("node.attr." + REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY, repoName)
        ClusterState state = createIndexWithSettings(cluster, Settings.builder().build());
            .put(repoSettingsAttributeKeyPrefix + "location", repoPath)
            Settings.builder()
        assertEquals(0, indexShardRoutingTable.searchOnlyReplicas().size());
        indexShardRoutingTable = getIndexShardRoutingTable();
            .put(super.nodeSettings())
        assertEquals(0, indexShardRoutingTable.replicaShards().size());
            .put(RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), false)
import static org.opensearch.indices.IndicesService.CLUSTER_REPLICATION_TYPE_SETTING;
        ClusterState finalState = state;
import java.util.List;
        createIndex(INDEX_NAME, settings);
            )
        ClusterState state = ClusterStateCreationUtils.state(localNode, localNode, allNodes.toArray(new DiscoveryNode[0]));
        CreateIndexRequest request = new CreateIndexRequest(INDEX_NAME, settings).waitForActiveShards(ActiveShardCount.NONE);
        );
 *
            .put(SETTING_NUMBER_OF_SHARDS, 1)
        // remove all replicas
import java.util.concurrent.ExecutionException;
            RuntimeException.class,
        final ClusterStateChanges cluster = new ClusterStateChanges(xContentRegistry(), threadPool);
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        assertEquals(0, indexShardRoutingTable.writerReplicas().size());
            .put(SETTING_NUMBER_OF_REPLICAS, 0)
import java.util.ArrayList;
        updateSettingsRequest = new UpdateSettingsRequest(INDEX_NAME).settings(
        terminate(threadPool);
import org.opensearch.cluster.ClusterState;
        Settings settings = Settings.builder()
            Locale.getDefault(),
        IndexShardRoutingTable indexShardRoutingTable = state.getRoutingTable().index(INDEX_NAME).getShards().get(0);
        Settings settings = Settings.builder()
    Path tempDir = createTempDir();
/*
package org.opensearch.cluster.metadata;
            .put(INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT)
    private static final AtomicInteger nodeIdGenerator = new AtomicInteger();
        );
        Integer maxShardPerNode = ShardLimitValidator.SETTING_CLUSTER_MAX_SHARDS_PER_NODE.getDefault(Settings.EMPTY);
    }
            .put(repoSettingsAttributeKeyPrefix + "location", repoPath)
        assertTrue(state.metadata().hasIndex(INDEX_NAME));
        );
    }
import java.util.Set;
        super.setUp();
    }
    private ThreadPool threadPool;
public class SearchOnlyReplicaTests extends OpenSearchSingleNodeTestCase {
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX;
 * The OpenSearch Contributors require contributions made to
    public static final String TEST_RS_REPO = "test-rs-repo";
        Throwable cause = executionException.getCause();
            state = cluster.reroute(state, new ClusterRerouteRequest());
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteRequest;
 */
        assertEquals(1, indexShardRoutingTable.replicaShards().size());
import org.opensearch.repositories.fs.FsRepository;
 * compatible open source license.
        // add another replica
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_REPLICATION_TYPE_SETTING;
        allNodes.add(localNode);
                .put(SETTING_NUMBER_OF_REPLICAS, 0)
    private IndexShardRoutingTable getIndexShardRoutingTable() {
    public void testUpdateSearchReplicaCount() throws ExecutionException, InterruptedException {
            .put(Environment.PATH_REPO_SETTING.getKey(), repo)
    }
            .put(Environment.PATH_HOME_SETTING.getKey(), tempDir)
            .build();
            exception.getCause().getMessage()
 * SPDX-License-Identifier: Apache-2.0
import org.junit.After;
        String repoSettingsAttributeKeyPrefix = String.format(
        );
        RuntimeException exception = expectThrows(
    private Settings buildRemoteStoreNodeAttributes(String repoName, Path repoPath) {
            state = cluster.applyStartedShards(
        super.tearDown();
        state = cluster.createIndex(state, request);
        return Settings.builder()
            INDEX_NAME,
            )
    }
            () -> cluster.updateSettings(
                    .put(SETTING_NUMBER_OF_SHARDS, 1)
}
import org.opensearch.test.OpenSearchSingleNodeTestCase;
            .put(buildRemoteStoreNodeAttributes(TEST_RS_REPO, repo))
    }
            .put(repoSettingsAttributeKeyPrefix + "location", repoPath)
            .put("node.attr." + REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, repoName)
        assertEquals(ValidationException.class, cause.getClass());
import org.opensearch.threadpool.ThreadPool;
    protected Settings nodeSettings() {
        this.threadPool = new TestThreadPool(getClass().getName());
    @Before
        String repoTypeAttributeKey = String.format(
        ClusterState state = ClusterStateCreationUtils.state(localNode, localNode, allNodes.toArray(new DiscoveryNode[0]));
import java.util.concurrent.atomic.AtomicInteger;
        for (int i = 0; i < 2; i++) {
import java.nio.file.Path;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS;
        Integer maxShardPerNode = ShardLimitValidator.SETTING_CLUSTER_MAX_SHARDS_PER_NODE.getDefault(Settings.EMPTY);
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
            Settings.builder().put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 2).build()
                finalState,
        client().admin().indices().updateSettings(updateSettingsRequest).get();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
    public void testUpdateSearchReplicasOverShardLimit() {
    }
        }
        assertEquals(0, indexShardRoutingTable.writerReplicas().size());
            .build();
        allNodes.add(createNode(Version.CURRENT, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE));
    @After
import org.opensearch.indices.cluster.ClusterStateChanges;
        Collections.addAll(roles, mustHaveRoles);
    public void testCreateWithDefaultSearchReplicasSetting() {
        assertEquals(2, indexShardRoutingTable.replicaShards().size());
        return state;
        DiscoveryNode localNode = createNode(Version.CURRENT, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE);
        while (state.routingTable().index(INDEX_NAME).shard(0).allShardsStarted() == false) {
        );
import org.opensearch.action.support.ActiveShardCount;
import org.opensearch.threadpool.TestThreadPool;
        client().admin().indices().updateSettings(updateSettingsRequest).get();
import org.opensearch.action.support.replication.ClusterStateCreationUtils;
            "To set index.number_of_search_replicas, index.remote_store.enabled must be set to true",
import org.opensearch.cluster.routing.ShardRoutingState;
import org.opensearch.common.settings.Settings;
import org.opensearch.Version;
        assertEquals(2, indexShardRoutingTable.searchOnlyReplicas().size());
    @Override
        assertEquals(0, indexShardRoutingTable.searchOnlyReplicas().size());
        // node for search replicas - we'll start with 1 and add another
        return Settings.builder()
        final String id = String.format(Locale.ROOT, "node_%03d", nodeIdGenerator.incrementAndGet());
    }
        indexShardRoutingTable = getIndexShardRoutingTable();
            .put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 0)
        UpdateSettingsRequest updateSettingsRequest = new UpdateSettingsRequest(INDEX_NAME).settings(
            "node.attr." + REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
        assertEquals(0, indexShardRoutingTable.writerReplicas().size());
import java.util.Collections;
            .put(INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT)
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;
import org.junit.Before;
                    .put(SETTING_NUMBER_OF_REPLICAS, 0)
            allNodes.add(createNode(Version.CURRENT, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE));
        assertEquals(1, indexShardRoutingTable.writerReplicas().size());
    }
            .build();
        return new DiscoveryNode(id, id, buildNewFakeTransportAddress(), Collections.emptyMap(), roles, version);
    private static void rerouteUntilActive(ClusterState state, ClusterStateChanges cluster) {
            .put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)
            .put("node.attr." + REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, repoName)
    public void testSearchReplicasValidationWithDocumentReplication() {
        final ClusterStateChanges cluster = new ClusterStateChanges(xContentRegistry(), threadPool);
                )
        );
import org.opensearch.env.Environment;
import org.opensearch.cluster.node.DiscoveryNodeRole;
        IndexShardRoutingTable indexShardRoutingTable = getIndexShardRoutingTable();
    public static final String INDEX_NAME = "test-index";
            Locale.getDefault(),
        );
        // node for primary/local
                    .put(INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.DOCUMENT)
            repoName
import java.util.Locale;
        createIndex(INDEX_NAME, settings);
        ).waitForActiveShards(ActiveShardCount.NONE);
        return client().admin().cluster().prepareState().get().getState().getRoutingTable().index(INDEX_NAME).getShards().get(0);
                cluster,
            RuntimeException.class,
import java.util.HashSet;
                new UpdateSettingsRequest(INDEX_NAME).settings(
        UpdateSettingsRequest updateSettingsRequest = new UpdateSettingsRequest(INDEX_NAME).settings(
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY;
            .put(CLUSTER_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT)
            .put(repoTypeAttributeKey, FsRepository.TYPE)
        final ClusterStateChanges cluster = new ClusterStateChanges(xContentRegistry(), threadPool);
                .put(INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.DOCUMENT)
        CreateIndexRequest request = new CreateIndexRequest(
    }
            );
            .put(SETTING_NUMBER_OF_SHARDS, 1)
        List<DiscoveryNode> allNodes = new ArrayList<>();
    public void testUpdateSearchReplicasOnDocrepCluster() {
import org.opensearch.common.ValidationException;
        // add another replica
        );
        state = cluster.createIndex(state, request);
    }
            Settings.builder().put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 0).build()
        // node for primary/local
        List<DiscoveryNode> allNodes = new ArrayList<>();
    private ClusterState createIndexWithSettings(ClusterStateChanges cluster, Settings settings) {
import org.opensearch.gateway.remote.RemoteClusterStateService;
        Set<DiscoveryNodeRole> roles = new HashSet<>(randomSubsetOf(DiscoveryNodeRole.BUILT_IN_ROLES));
        ExecutionException executionException = expectThrows(
        // add another replica
            .build();
    public void tearDown() throws Exception {
        assertEquals(1, indexShardRoutingTable.searchOnlyReplicas().size());
        assertEquals(
            .put(repoTypeAttributeKey, FsRepository.TYPE)
                state,
            "node.attr." + REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
            Settings.builder().put(SETTING_NUMBER_OF_SEARCH_REPLICAS, maxShardPerNode * 2).build()
        expectThrows(
                Settings.builder()
        }
        );
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY;
                state.routingTable().index(INDEX_NAME).shard(0).shardsWithState(ShardRoutingState.INITIALIZING)
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
            () -> client().admin().indices().updateSettings(updateSettingsRequest).get()
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY;
import org.opensearch.indices.replication.common.ReplicationType;
            .put(SETTING_NUMBER_OF_REPLICAS, 0)
