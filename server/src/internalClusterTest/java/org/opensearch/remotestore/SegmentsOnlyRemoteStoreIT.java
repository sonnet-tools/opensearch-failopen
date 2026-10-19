        );  
        createSegmentsOnlyIndex(1);
        String searchNode = internalCluster().startSearchOnlyNode();
    public void testSearchReplicaServesDocumentsFromRemoteSegmentStore() throws Exception {
        assertFalse("translog must stay local in segments_only mode", searchShard.indexSettings().isRemoteTranslogStoreEnabled());  
    private Path segmentRepoPath;  
        IndexShard searchShard = internalCluster().getInstance(IndicesService.class, searchNode)
        assertBusy(
                Settings.builder()
                .cluster()
                assertEquals("operations must reach " + node, docs - 1, shard.seqNoStats().getMaxSeqNo());
        assertBusy(() -> {  
                    .indexService(resolveIndex(INDEX_NAME));
        refresh(INDEX_NAME);
            Locale.getDefault(),  
}
import static org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider.INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING;  
        assertTrue(searchShard.indexSettings().isAssignedOnRemoteNode());
        }  
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
    }
                    .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
     */  
            assertNotNull(primaryShard);  
import org.opensearch.test.transport.MockTransportService;
     */  
import org.opensearch.test.OpenSearchIntegTestCase;  
    private static final String SEGMENT_REPOSITORY_NAME = "test-segment-repo";  
import org.opensearch.repositories.fs.ReloadableFsRepository;
    private static final String INDEX_NAME = "segments-only-idx";
     */
        createSegmentsOnlyIndex(0, 1);
        internalCluster().startClusterManagerOnlyNode();
    @Override
import org.opensearch.common.settings.Settings;
            segmentRepoPath = randomRepoPath().toAbsolutePath();
 * compatible open source license.
        internalCluster().startDataOnlyNode();
            client().admin()  
    }
        createSegmentsOnlyIndex(0);
        ensureStableCluster(2);
        ClusterState state = client().admin().cluster().prepareState().get().getState();  
                .prepareUpdateSettings(INDEX_NAME)
    public void testReplicaPromotionRetainsAcknowledgedWrites() throws Exception {  
                primaryShard.getRetentionLeases().leases().size()  
                primaryShard.getReplicationGroup().getRoutingTable().size()
        List<String> dataNodes = internalCluster().startDataOnlyNodes(2);  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_MODE_KEY;
        );  
    private void createSegmentsOnlyIndex(int numReplicas, int numSearchReplicas) {
            );
        assertTrue(searchShard.routingEntry().isSearchOnly());
    public void testTotalPrimaryShardsPerNodeIsAllowed() {
        internalCluster().startDataOnlyNode();
 * The OpenSearch Contributors require contributions made to  
        // The promoted replica replays its local translog into Lucene, so the writes survive even though some of them
                if (shard.routingEntry().primary()) {
        String settingsPrefix = String.format(
     * nothing downstream can resolve it by name.
        );
    }
        internalCluster().startClusterManagerOnlyNode();
                "a peer recovery retention lease must be retained for the replica",
import org.opensearch.cluster.metadata.RepositoriesMetadata;
    }
    /**  
        assertEquals("true", settings.getSetting(INDEX_NAME, IndexMetadata.SETTING_REMOTE_STORE_ENABLED));
                // Every operation reached this shard, so either copy can act as the durable one.
            refresh(INDEX_NAME);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
 */  
        );
    private void createSegmentsOnlyIndex(int numReplicas) {
                .setPersistentSettings(Settings.builder().putNull(CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey()))  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY;
    /**  
            prepareCreate(INDEX_NAME).setSettings(
        ensureGreen(INDEX_NAME);  
        );
        refresh(INDEX_NAME);
    }
/*  
            SEGMENT_REPOSITORY_NAME  
import static org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider.CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING;
            .put(typeKey, ReloadableFsRepository.TYPE)
        // Restricting the search to the search node proves the search replica itself served the documents.  
import org.opensearch.index.IndexService;  
     * A write replica must be allocatable, must keep a local translog and must stay part of the replication group so
    /**  
        createSegmentsOnlyIndex(numReplicas, 0);
            .indexService(resolveIndex(INDEX_NAME))
     * A search replica only ever needs segments, which segments_only mode does upload, so it must allocate onto a
        String typeKey = String.format(  
     */
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX;
        }
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        assertBusy(() -> assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), docs), 60, TimeUnit.SECONDS);
    @Override
            .build();
    }
import java.nio.file.Path;  
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
        }, 60, TimeUnit.SECONDS);  
        return Stream.concat(super.nodePlugins().stream(), Stream.of(MockTransportService.TestPlugin.class)).collect(Collectors.toList());
        internalCluster().startDataOnlyNodes(2);
        return Settings.builder()
        internalCluster().stopRandomNode(settings -> primaryNode.equals(settings.get("node.name")));  
import org.opensearch.cluster.ClusterState;
        assertEquals(SEGMENT_REPOSITORY_NAME, settings.getSetting(INDEX_NAME, IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY));
        int docs = randomIntBetween(10, 50);  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        );
            () -> assertHitCount(client(searchNode).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), docs),
        ClusterState state = client().admin().cluster().prepareState().get().getState();
        int docs = randomIntBetween(10, 50);  
        assertBusy(() -> assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), docs), 60, TimeUnit.SECONDS);
            Locale.getDefault(),
 * Tests a cluster running with {@code node.attr.remote_store.mode: segments_only}, where segments are uploaded to a  
     */  
    /**
            client().admin()
        createSegmentsOnlyIndex(1);
            assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), docs);
                .cluster()  
    }
            "segments-only indices must not be given a translog repository",
    /**  
            IndexShard primaryShard = null;
        );  
    protected Settings nodeSettings(int nodeOrdinal) {
            "node.attr." + REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
        assertAcked(  
        internalCluster().startClusterManagerOnlyNode();
import org.opensearch.cluster.metadata.IndexMetadata;  
        internalCluster().startDataOnlyNode();  
    public void testWriteReplicaReceivesOperationsAndBoundsGlobalCheckpoint() throws Exception {
import java.util.stream.Stream;  
                2,
                .prepareUpdateSettings()
     * that the global checkpoint reflects it.
     */
            repositories.repositories().stream().anyMatch(r -> SEGMENT_REPOSITORY_NAME.equals(r.name()))
 */
        assertNull(  
import java.util.Collection;
        RepositoriesMetadata repositories = state.metadata().custom(RepositoriesMetadata.TYPE);
        String primaryNode = state.nodes().get(state.routingTable().index(INDEX_NAME).shard(0).primaryShard().currentNodeId()).getName();
        ensureStableCluster(3);  
import org.opensearch.plugins.Plugin;
            .getShard(0);  
        assertNotNull("segments-only node should publish its repository to cluster state", repositories);
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
            }
public class SegmentsOnlyRemoteStoreIT extends OpenSearchIntegTestCase {
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT;  
                    primaryShard = shard;
                .setSettings(Settings.builder().put(INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 2))
     * use the primary shard limits at both the cluster and the index level.
        for (int i = 0; i < docs; i++) {
                .indices()  
            assertEquals(docs - 1, primaryShard.seqNoStats().getGlobalCheckpoint());
     * search node and serve what it pulls from the remote store without holding a translog.  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
        ensureStableCluster(2);  
import org.opensearch.indices.replication.common.ReplicationType;  
import org.opensearch.index.shard.IndexShard;
        ensureStableCluster(3);
    }  
        createSegmentsOnlyIndex(1);
     * Killing the primary must not lose acknowledged writes, since the replica holds them in its own translog.
 * remote store but the translog stays on local disk and is replicated node-to-node.
            assertEquals(  
import java.util.Locale;  
            .put(super.nodeSettings(nodeOrdinal))
                .setPersistentSettings(Settings.builder().put(CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 2))
            );
 * SPDX-License-Identifier: Apache-2.0
        if (segmentRepoPath == null) {  
        internalCluster().startDataOnlyNodes(2);  
        assertAcked(
                IndexShard shard = indexService.getShard(0);  
        );  
                assertFalse("translog must stay local in segments_only mode", shard.indexSettings().isRemoteTranslogStoreEnabled());
    public void testIndexIsCreatedWithSegmentRepositoryOnly() {  
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).get();  
            60,  
            .put("node.attr." + REMOTE_STORE_MODE_KEY, "segments_only")  
import java.util.concurrent.TimeUnit;
import org.opensearch.indices.IndicesService;
        }, 60, TimeUnit.SECONDS);  
                assertTrue("segments must be remote backed", shard.indexSettings().isRemoteStoreEnabled());  
    }
        // Segment replication is asynchronous, so a search served by the replica may briefly lag the primary.  
            "node.attr." + REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
        // may only become searchable after the next refresh.
            client().admin()
        assertAcked(
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas)
 * this file be licensed under the Apache-2.0 license or a
    public void testSegmentRepositoryIsRegisteredInClusterState() {
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).get();
import java.util.List;
            SEGMENT_REPOSITORY_NAME
            )
            .put(settingsPrefix + "location", segmentRepoPath)  
        refresh(INDEX_NAME);
            settings.getSetting(INDEX_NAME, IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY)
            "cluster state should contain " + SEGMENT_REPOSITORY_NAME + " but had " + repositories.repositories(),
     * Index creation must stamp the segment repository settings, and must not stamp a translog repository.
        // This is what makes the shard pull from RemoteStoreReplicationSource rather than from the primary.
        ensureStableCluster(3);  
 *
        }  
        for (int i = 0; i < docs; i++) {
                IndexService indexService = internalCluster().getInstance(IndicesService.class, node)  
        }
                .prepareUpdateSettings()
                "the replica must remain in the replication group",
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).get();
            .put("node.attr." + REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, SEGMENT_REPOSITORY_NAME)
            TimeUnit.SECONDS
        assertTrue("segments must be remote backed", searchShard.indexSettings().isRemoteStoreEnabled());
     * The segment repository must reach cluster state even though no cluster state repository is configured, otherwise
        for (int i = 0; i < docs; i++) {
import java.util.stream.Collectors;
        assertTrue(  
        internalCluster().startClusterManagerOnlyNode();
        internalCluster().startClusterManagerOnlyNode();
        );  
                assertNotNull("index should exist on " + node, indexService);
    }
            assertEquals(
        internalCluster().startClusterManagerOnlyNode();  
        assertAcked(
        GetSettingsResponse settings = client().admin().indices().prepareGetSettings(INDEX_NAME).get();  
package org.opensearch.remotestore;
        ensureStableCluster(3);
/**
    /**  
                2,  
            for (String node : dataNodes) {
        int docs = randomIntBetween(10, 50);
        assertBusy(() -> {  
     * Balancing primaries only requires the segments to be remote backed, so segments_only clusters must be allowed to
                    .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, numSearchReplicas)
        assertEquals("a search replica never receives operations", 0, searchShard.translogStats().estimatedNumberOfOperations());  
                }  
