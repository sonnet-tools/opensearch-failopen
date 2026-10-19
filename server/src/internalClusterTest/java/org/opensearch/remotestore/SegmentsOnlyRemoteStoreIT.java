            SEGMENT_REPOSITORY_NAME
                    .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, numSearchReplicas)
        );
import org.opensearch.indices.replication.common.ReplicationType;
import org.opensearch.cluster.ClusterState;
        refresh(INDEX_NAME);
     * use the primary shard limits at both the cluster and the index level.
                assertFalse("translog must stay local in segments_only mode", shard.indexSettings().isRemoteTranslogStoreEnabled());
                "a peer recovery retention lease must be retained for the replica",
    /**
import static org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider.CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING;
        assertAcked(
        // may only become searchable after the next refresh.
        ClusterState state = client().admin().cluster().prepareState().get().getState();
        createSegmentsOnlyIndex(1);
        String typeKey = String.format(
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
     */
        if (segmentRepoPath == null) {
            assertEquals(
        // Restricting the search to the search node proves the search replica itself served the documents.
                "the replica must remain in the replication group",
 */
import static org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider.INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING;
    /**
            "node.attr." + REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
            60,
            .getShard(0);
    /**
     */
        );
        return Settings.builder()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
 * Tests a cluster running with {@code node.attr.remote_store.mode: segments_only}, where segments are uploaded to a
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).get();
    }
        internalCluster().startDataOnlyNode();
        }
                .prepareUpdateSettings()
                .prepareUpdateSettings(INDEX_NAME)
        internalCluster().startClusterManagerOnlyNode();
        internalCluster().stopRandomNode(settings -> primaryNode.equals(settings.get("node.name")));
        refresh(INDEX_NAME);
    private static final String SEGMENT_REPOSITORY_NAME = "test-segment-repo";
                2,
        int docs = randomIntBetween(10, 50);
        createSegmentsOnlyIndex(numReplicas, 0);
        assertTrue("segments must be remote backed", searchShard.indexSettings().isRemoteStoreEnabled());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        String searchNode = internalCluster().startSearchOnlyNode();
        assertBusy(() -> assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), docs), 60, TimeUnit.SECONDS);
            client().admin()
            assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), docs);
        assertAcked(
        internalCluster().startClusterManagerOnlyNode();
import org.opensearch.index.shard.IndexShard;
        internalCluster().startClusterManagerOnlyNode();
public class SegmentsOnlyRemoteStoreIT extends OpenSearchIntegTestCase {
        assertTrue(searchShard.indexSettings().isAssignedOnRemoteNode());
            .put("node.attr." + REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, SEGMENT_REPOSITORY_NAME)
 * The OpenSearch Contributors require contributions made to
            assertEquals(
        createSegmentsOnlyIndex(1);
        );
        List<String> dataNodes = internalCluster().startDataOnlyNodes(2);
     * Index creation must stamp the segment repository settings, and must not stamp a translog repository.
        // Segment replication is asynchronous, so a search served by the replica may briefly lag the primary.
            .put(typeKey, ReloadableFsRepository.TYPE)
        internalCluster().startDataOnlyNode();
        internalCluster().startDataOnlyNodes(2);
 * SPDX-License-Identifier: Apache-2.0
    public void testReplicaPromotionRetainsAcknowledgedWrites() throws Exception {
    @Override
            SEGMENT_REPOSITORY_NAME
    private Path segmentRepoPath;
                .setSettings(Settings.builder().put(INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 2))
    }
import org.opensearch.indices.IndicesService;
        for (int i = 0; i < docs; i++) {
            "cluster state should contain " + SEGMENT_REPOSITORY_NAME + " but had " + repositories.repositories(),
        for (int i = 0; i < docs; i++) {
            assertNotNull(primaryShard);
     * Balancing primaries only requires the segments to be remote backed, so segments_only clusters must be allowed to
import org.opensearch.repositories.fs.ReloadableFsRepository;
                assertTrue("segments must be remote backed", shard.indexSettings().isRemoteStoreEnabled());
        ensureYellowAndNoInitializingShards(INDEX_NAME);
     */
     */
            .build();
    /**
        assertBusy(() -> assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), docs), 60, TimeUnit.SECONDS);
     * that the global checkpoint reflects it.
    }
        int docs = randomIntBetween(10, 50);
    }
                .cluster()
            Locale.getDefault(),
import org.opensearch.common.settings.Settings;
            client().admin()
            settings.getSetting(INDEX_NAME, IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY)
     */
                primaryShard.getRetentionLeases().leases().size()
            repositories.repositories().stream().anyMatch(r -> SEGMENT_REPOSITORY_NAME.equals(r.name()))
     * Killing the primary must not lose acknowledged writes, since the replica holds them in its own translog.
                assertNotNull("index should exist on " + node, indexService);
                    primaryShard = shard;
import java.util.concurrent.TimeUnit;
        ensureStableCluster(3);
        assertTrue(
import org.opensearch.cluster.metadata.IndexMetadata;
     * A search replica only ever needs segments, which segments_only mode does upload, so it must allocate onto a
            "node.attr." + REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_MODE_KEY;
    private void createSegmentsOnlyIndex(int numReplicas, int numSearchReplicas) {
 * remote store but the translog stays on local disk and is replicated node-to-node.
        internalCluster().startClusterManagerOnlyNode();
                Settings.builder()
import org.opensearch.index.IndexService;
        assertAcked(
        createSegmentsOnlyIndex(0, 1);
        createSegmentsOnlyIndex(0);
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT;
import java.util.Locale;
                IndexService indexService = internalCluster().getInstance(IndicesService.class, node)
    public void testTotalPrimaryShardsPerNodeIsAllowed() {
    private static final String INDEX_NAME = "segments-only-idx";
        }
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).get();
    public void testWriteReplicaReceivesOperationsAndBoundsGlobalCheckpoint() throws Exception {
        assertEquals("true", settings.getSetting(INDEX_NAME, IndexMetadata.SETTING_REMOTE_STORE_ENABLED));
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).get();
            .indexService(resolveIndex(INDEX_NAME))
import java.util.Collection;
        // This is what makes the shard pull from RemoteStoreReplicationSource rather than from the primary.
        assertBusy(() -> {
        internalCluster().startDataOnlyNode();
    /**
import org.opensearch.cluster.metadata.RepositoriesMetadata;
        ensureStableCluster(3);
import org.opensearch.test.transport.MockTransportService;
 * compatible open source license.
        String settingsPrefix = String.format(
            "segments-only indices must not be given a translog repository",
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY;
                .indices()
        refresh(INDEX_NAME);
            () -> assertHitCount(client(searchNode).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), docs),
/**
 */
        ensureStableCluster(2);
        }, 60, TimeUnit.SECONDS);
     * The segment repository must reach cluster state even though no cluster state repository is configured, otherwise
                // Every operation reached this shard, so either copy can act as the durable one.
            assertEquals(docs - 1, primaryShard.seqNoStats().getGlobalCheckpoint());
                .setPersistentSettings(Settings.builder().putNull(CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey()))
                assertEquals("operations must reach " + node, docs - 1, shard.seqNoStats().getMaxSeqNo());
        return Stream.concat(super.nodePlugins().stream(), Stream.of(MockTransportService.TestPlugin.class)).collect(Collectors.toList());
package org.opensearch.remotestore;
                IndexShard shard = indexService.getShard(0);
                    .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        for (int i = 0; i < docs; i++) {
        );
        IndexShard searchShard = internalCluster().getInstance(IndicesService.class, searchNode)
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX;
    private void createSegmentsOnlyIndex(int numReplicas) {
    public void testIndexIsCreatedWithSegmentRepositoryOnly() {
        );
     * nothing downstream can resolve it by name.
            refresh(INDEX_NAME);
        assertNotNull("segments-only node should publish its repository to cluster state", repositories);
            );
            .put(super.nodeSettings(nodeOrdinal))
        internalCluster().startClusterManagerOnlyNode();
import java.util.stream.Stream;
                primaryShard.getReplicationGroup().getRoutingTable().size()
                if (shard.routingEntry().primary()) {
                }
            IndexShard primaryShard = null;
            }
import java.util.List;
        assertNull(
            client().admin()
        assertTrue(searchShard.routingEntry().isSearchOnly());
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            segmentRepoPath = randomRepoPath().toAbsolutePath();
        assertAcked(
        ensureStableCluster(3);
        GetSettingsResponse settings = client().admin().indices().prepareGetSettings(INDEX_NAME).get();
    }
 *
        ensureGreen(INDEX_NAME);
        assertBusy(() -> {
        );
import org.opensearch.plugins.Plugin;
/*
    }
        assertEquals("a search replica never receives operations", 0, searchShard.translogStats().estimatedNumberOfOperations());
        );
        RepositoriesMetadata repositories = state.metadata().custom(RepositoriesMetadata.TYPE);
import java.nio.file.Path;
        String primaryNode = state.nodes().get(state.routingTable().index(INDEX_NAME).shard(0).primaryShard().currentNodeId()).getName();
import org.opensearch.test.OpenSearchIntegTestCase;
                .cluster()
        assertFalse("translog must stay local in segments_only mode", searchShard.indexSettings().isRemoteTranslogStoreEnabled());
                2,
    }
            .put("node.attr." + REMOTE_STORE_MODE_KEY, "segments_only")
        ensureStableCluster(3);
    }
        }, 60, TimeUnit.SECONDS);
}
import java.util.stream.Collectors;
     * search node and serve what it pulls from the remote store without holding a translog.
        assertBusy(
    }
                    .indexService(resolveIndex(INDEX_NAME));
                .prepareUpdateSettings()
        }
            TimeUnit.SECONDS
            .put(settingsPrefix + "location", segmentRepoPath)
        internalCluster().startClusterManagerOnlyNode();
        createSegmentsOnlyIndex(1);
    /**
        internalCluster().startDataOnlyNodes(2);
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas)
            for (String node : dataNodes) {
        );
            )
            Locale.getDefault(),
                .setPersistentSettings(Settings.builder().put(CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 2))
 * this file be licensed under the Apache-2.0 license or a
     */
        ensureStableCluster(2);
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
        }
        // The promoted replica replays its local translog into Lucene, so the writes survive even though some of them
        ClusterState state = client().admin().cluster().prepareState().get().getState();
    public void testSearchReplicaServesDocumentsFromRemoteSegmentStore() throws Exception {
    }
    protected Settings nodeSettings(int nodeOrdinal) {
    public void testSegmentRepositoryIsRegisteredInClusterState() {
        );
        int docs = randomIntBetween(10, 50);
     * A write replica must be allocatable, must keep a local translog and must stay part of the replication group so
        assertEquals(SEGMENT_REPOSITORY_NAME, settings.getSetting(INDEX_NAME, IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY));
            prepareCreate(INDEX_NAME).setSettings(
    @Override
            );
