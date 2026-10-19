import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                eq(shardStatusBefore.generation()),  
        final SnapshotsService.ShardSnapshotUpdate completeShard = successUpdate(plainSnapshot, routingShardId, dataNodeId);  
    }  
            1L,
        return new SnapshotsService.ShardSnapshotUpdate(snapshot, shardId, successfulShardStatus(nodeId));
        IndexMetadata mockIndexMetadata = mock(IndexMetadata.class);  
    public void testUpdateCloneMultipleShards() throws Exception {
        assertThat(shardSnapshotStatus.state(), is(SnapshotsInProgress.ShardState.INIT));  
        final ClusterState stateWithAssignedRoutingShard = ClusterState.builder(stateWithUnassignedRoutingShard)
        doAnswer(invocation -> {
            .version(state.version() + 1L)  
import org.opensearch.repositories.Repository;  
        final SnapshotsInProgress.Entry snapshotSingleShard = snapshotEntry(
            Collections.emptyMap(),  
        verify(mockRepository).cloneRemoteStoreIndexShardSnapshot(
        final SnapshotsInProgress.Entry completedSnapshot = snapshotsInProgress.entries().get(0);
        final Index routingIndex1 = index(indexName1);
import org.opensearch.repositories.RepositoryException;
        String repoName = "repoName";  
        String newGeneration = "new_generation";  
        assertThat(snapshotSingleShard.state(), is(SnapshotsInProgress.State.STARTED));  
            snapshotsService.runReadyClone(target, sourceSnapshot, shardStatusBefore, repoShardId, mockRepository, true);  
     * 2. cloneRemoteStoreIndexShardSnapshot is called with the correct parameters
            clonesMap(repositoryShardId, SnapshotsInProgress.ShardSnapshotStatus.UNASSIGNED_QUEUED)
            "failed to clone shard snapshot",
 * ownership. Elasticsearch licenses this file to you under  
            ActionListener<String> listener = invocation.getArgument(5);
            Collections.emptyMap(),  
        SnapshotsService snapshotsService = createSnapshotsService(mockClusterService);
        );  
            ActionListener<RepositoryData> listener = invocation.getArgument(0);  
        return ClusterState.builder(ClusterState.EMPTY_STATE).metadata(metaBuilder).routingTable(routingTable.build()).build();
        final RepositoryShardId shardId2 = new RepositoryShardId(indexId1, 1);  
            );  
            assertIsNoop(updatedClusterState, completeShardClone);
import org.opensearch.core.rest.RestStatus;
        final SnapshotsInProgress.Entry updatedSnapshot1 = snapshotsInProgress.entries().get(0);
            Collections.singletonList(indexId1),  
        Repository mockRepository = mock(Repository.class);  
    /**
        when(mockRepository.getSnapshotIndexMetaData(eq(repositoryData), eq(sourceSnapshot), any())).thenReturn(mockIndexMetadata);  
        final String dataNodeId = uuid();
            sourceSnapshot.getSnapshotId(),
        final Snapshot targetSnapshot = snapshot(repoName, "target-snapshot");
        final ShardId shardId1 = new ShardId(index(indexName1), 0);
        );
                    .build(),
        );  
                snapshot("other-repo", snapshot.getSnapshotId().getName()),
        ArgumentCaptor<SnapshotsService.ShardSnapshotUpdate> updateCaptor = ArgumentCaptor.forClass(
            Collections.emptyMap(),
            sourceSnapshot.getSnapshotId(),  
        when(mockIndexMetadata.getSettings()).thenReturn(mockSettings);
     * so snapshot-v2 must be refused rather than succeeding and failing later at restore time.
     * This method is a convenience wrapper around createSnapshotsService(ClusterService).
        final SnapshotsInProgress.Entry cloneSingleShard = cloneEntry(  
import org.opensearch.transport.TransportService;
        ShardId shardId,
            final ClusterState updatedClusterState = applyUpdates(stateWithAssignedRoutingShard, completeShardClone);
        }  
            listener.onResponse(repositoryData);
        );
     * 2. Neither cloneShardSnapshot nor cloneRemoteStoreIndexShardSnapshot are called  
        when(mockIndexMetadata.getSettings()).thenReturn(mockSettings);
    private static Snapshot snapshot(String repoName, String name) {  
        final String dataNodeId = uuid();
            verify(mockRepository).cloneShardSnapshot(  
                eq(sourceSnapshot),
    /**  
        return createSnapshotsService(mockClusterService);  
    ) {
    public void testRunReadyCloneCompletionListenerFailure() throws Exception {
        return DiscoveryNodes.builder().localNodeId(localNodeId).build();
            assertIsNoop(updatedClusterState, completeShardClone);
            final ClusterState updatedClusterState = applyUpdates(stateWithUnassignedRoutingShard, completeShardClone);  
        IndexMetadata mockIndexMetadata = mock(IndexMetadata.class);  
        final SnapshotsService.ShardSnapshotUpdate completeShardClone = successUpdate(targetSnapshot, shardId1, clusterManagerNodeId);  
     * 1. The clone operation fails with an exception
        String repoName = "repoName";
            IndexMetaDataGenerations.EMPTY  
    public void testCompletedSnapshotStartsNextSnapshot() throws Exception {
    private static DiscoveryNodes discoveryNodes(String localNodeId) {  
     */
        assertThat(startedSnapshot.state(), is(SnapshotsInProgress.State.STARTED));
            ActionListener<RepositoryData> listener = invocation.getArgument(0);  
        final SnapshotsService.ShardSnapshotUpdate completeShard = successUpdate(sn1, shardId1, dataNodeId);
        final String dataNodeId = uuid();
        when(mockRepository.getSnapshotIndexMetaData(eq(repositoryData), eq(sourceSnapshot), any())).thenReturn(mockIndexMetadata);
        // Verify that innerUpdateSnapshotState was called with the correct arguments
        assertThat(completedSnapshot.state(), is(SnapshotsInProgress.State.SUCCESS));
        final Snapshot snapshot = snapshot(repoName, "snapshot-1");  
        SnapshotId source,  
        DiscoveryNode localNode = new DiscoveryNode("local", buildNewFakeTransportAddress(), Version.CURRENT);
        SnapshotsInProgress.ShardSnapshotStatus expectedStatus = new SnapshotsInProgress.ShardSnapshotStatus(
            Arrays.asList(
        SnapshotsInProgress.ShardSnapshotStatus shardStatusBefore = initShardStatus(uuid());
            verify(mockRepository).cloneRemoteStoreIndexShardSnapshot(  
        assertThat(startedSnapshot.state(), is(SnapshotsInProgress.State.STARTED));
            new IOException("Test IO Exception")
            Collections.emptyMap(),
        final ShardId routingShardId = new ShardId(stateWithIndex.metadata().index(indexName).getIndex(), 0);  
        final List<IndexId> indexIds = StreamSupport.stream(clones.keySet().spliterator(), false)  
        String orphanEntity = "repoName__orphan";
            // Verify that neither cloneShardSnapshot nor cloneRemoteStoreIndexShardSnapshot were called  
    ) {
        );
    public void testCompletedCloneStartsSnapshot() throws Exception {  
        final Snapshot sn1 = snapshot(repoName, "snapshot-1");
            Collections.singletonMap(sourceSnapshot.getName(), sourceSnapshot),  
            Collections.emptyMap(),
        final SnapshotsService.ShardSnapshotUpdate completeShard = successUpdate(sn1, shardId1, dataNodeId);  
/*  
                eq(sourceSnapshot),
        verify(mockRepository).getRepositoryData(any(ActionListener.class));  
    }  
        SnapshotsInProgress.ShardSnapshotStatus shardStatusBefore = initShardStatus(uuid());
            SnapshotsInProgress.ShardState.FAILED,  
            null
        RepositoryShardId repoShardId = new RepositoryShardId(indexId("test-index"), 0);  
import org.opensearch.ExceptionsHelper;
        final RepositoryShardId repositoryShardId = new RepositoryShardId(indexId1, 0);  
            RepositoryData.EMPTY_REPO_GEN,  
        try (SnapshotsService snapshotsService = createSnapshotsService()) {  
        final SnapshotsInProgress.Entry updatedSnapshot1 = snapshotsInProgress.entries().get(0);  
        );
        IndexMetadata mockIndexMetadata = mock(IndexMetadata.class);
        final ShardId routingShardId = new ShardId(stateWithIndex.metadata().index(indexName).getIndex(), 0);
 * software distributed under the License is distributed on an
        final String dataNodeId = uuid();
                any()
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
     * Helper method to create a SnapshotsService instance with a mocked ClusterService.
        final Snapshot plainSnapshot = snapshot(repoName, "test-snapshot");
        );  
        final SnapshotsInProgress.Entry snapshotSingleShard = snapshotEntry(
        final ClusterState updatedClusterState = applyUpdates(stateWithSnapshots(snapshotSingleShard), completeShard);  
            final SnapshotsInProgress snapshotsInProgress = updatedClusterState.custom(SnapshotsInProgress.TYPE);
import org.opensearch.repositories.RepositoryShardId;  
 *
    public void testSnapshotV2RejectedForSegmentsOnlyIndex() {  
import org.opensearch.action.support.ActionFilters;  
        assertIsNoop(updatedClusterState, completeShard);
     */  
import org.opensearch.repositories.RepositoryData;
            verify(mockRepository).cloneShardSnapshot(
        String repoName = "test-repo";  
        try (SnapshotsService snapshotsService = createSnapshotsService()) {
     * 2. The correct ShardSnapshotUpdate is submitted to the cluster state  
        final ClusterState updatedClusterState = applyUpdates(stateWithUnassignedRoutingShard, completeShardClone);
            any(),  
import org.opensearch.common.collect.Tuple;  
    }  
        when(mockClusterService.getClusterSettings()).thenReturn(clusterSettings);  
            ClusterState.builder(ClusterState.EMPTY_STATE).nodes(discoveryNodes(clusterManagerNodeId)).build(),
     * A full remote store index has a remote translog to replay from, so snapshot-v2 stays available for it.  
            final SnapshotsInProgress.Entry startedSnapshot = snapshotsInProgress.entries().get(1);
        final SnapshotsInProgress.Entry cloneSingleShard = cloneEntry(  
import org.opensearch.repositories.RepositoriesService;
    private static ClusterState stateWithSnapshots(ClusterState state, SnapshotsInProgress.Entry... entries) {
        final ShardId shardId2 = new ShardId(routingIndex1, 1);
        when(mockClusterService.localNode()).thenReturn(localNode);  
import org.opensearch.cluster.routing.IndexShardRoutingTable;  
            .settings(indexSettings.put(SETTING_VERSION_CREATED, Version.CURRENT))
        when(mockClusterService.localNode()).thenReturn(localNode);  
        final String indexName1 = "index-1";  
        assertEquals(RestStatus.BAD_REQUEST, ExceptionsHelper.status(e));
     * It verifies that:  
        return new SnapshotsService.ShardSnapshotUpdate(snapshot, shardId, successfulShardStatus(nodeId));
        assertEquals(expectedUpdate.hashCode(), capturedUpdate.hashCode());
                    )  
                any()
        final String indexName1 = "index-1";  
        snapshotsService.runReadyClone(target, sourceSnapshot, shardStatusBefore, repoShardId, mockRepository, true);
        ArgumentCaptor<SnapshotsService.ShardSnapshotUpdate> updateCaptor = ArgumentCaptor.forClass(
        final SnapshotsInProgress.Entry queuedSnapshotSingleShard = snapshotEntry(  
                    .numberOfShards(1)
        assertThat(cloneSingleShard.state(), is(SnapshotsInProgress.State.STARTED));
        final RepositoryShardId shardId1 = new RepositoryShardId(indexId1, 0);
        SnapshotsInProgress.ShardSnapshotStatus shardStatus
import org.opensearch.core.index.Index;
    /**  
            Collections.singletonMap(sourceSnapshot.getName(), sourceSnapshot),
    private static ClusterState applyUpdates(ClusterState state, SnapshotsService.ShardSnapshotUpdate... updates) throws Exception {
    private SnapshotsService createSnapshotsService() {
        ClusterService mockClusterService = mock(ClusterService.class);
                .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "segment-repo")
            Collections.emptyList(),  
            ActionListener<String> listener = invocation.getArgument(5);
        final Snapshot sourceSnapshot = snapshot(repoName, "source-snapshot");  
            listener.onResponse(repositoryData);
                                new IndexShardRoutingTable.Builder(routingShardId1).addShard(
        ClusterState state = clusterStateWithIndex(  
        Snapshot target = snapshot(repoName, "target-snapshot");
            assertThat(completedClone.state(), is(SnapshotsInProgress.State.SUCCESS));  
        String pinningEntity = "repoName__OstrHGrERqaR__-597zHYQ";
    public void testGetRepoSnapshotUUIDTuple() {
            final SnapshotsInProgress.ShardSnapshotStatus shardSnapshotStatus = startedSnapshot.shards().get(routingShardId1);
        );  
        assertThat(e.getMessage(), containsString("segments-only-idx"));
        }
                "repoName__OstrHGrERqaR__-597zHYQ, Zjlnf8IHRxqFBijj0m52gw"
            snapshotsService.runReadyClone(target, sourceSnapshot, shardStatusBefore, repoShardId, mockRepository, true);
    private static SnapshotsInProgress.Entry snapshotEntry(
     */
            final ClusterState updatedClusterState = applyUpdates(stateWithInitializingRoutingShard, completeShardClone);  
import static org.mockito.Mockito.doAnswer;
        final SnapshotsInProgress.Entry snapshotSingleShard = snapshotEntry(  
 *    http://www.apache.org/licenses/LICENSE-2.0
        );
     * Tests the runReadyClone method when remote store index shallow copy is disabled.
import org.opensearch.cluster.ClusterState;
    }
        verify(mockClusterService).submitStateUpdateTask(eq("update snapshot state"), updateCaptor.capture(), any(), any(), any());
            shardsMap(routingShardId, SnapshotsInProgress.ShardSnapshotStatus.UNASSIGNED_QUEUED)  
 * Modifications Copyright OpenSearch Contributors. See
     */
            IndexMetaDataGenerations.EMPTY  
            // Verify that cloneRemoteStoreIndexShardSnapshot was called with the correct arguments
        final String repoName = "test-repo";  
    public void testRunReadyCloneCompletionListener() throws Exception {
        String repoName = "test-repo";  
                eq(target.getSnapshotId()),
        assertThat(shardCloneStatus.state(), is(SnapshotsInProgress.ShardState.INIT));  
            assertIsNoop(updatedClusterState, completeShardClone);
        return stateWithSnapshots(ClusterState.builder(ClusterState.EMPTY_STATE).nodes(discoveryNodes(uuid())).build(), entries);  
        return Map.of(shardId, shardStatus);
    ) {
     * 1. getRepositoryData is called
            IndexMetaDataGenerations.EMPTY  
import org.opensearch.common.util.concurrent.OpenSearchExecutors;  
        RepositoryData repositoryData = new RepositoryData(
            return null;  
        try (SnapshotsService snapshotsService = createSnapshotsService()) {
        RepositoryShardId repoShardId = new RepositoryShardId(indexId("test-index"), 0);  
                                    TestShardRouting.newShardRouting(routingShardId1, dataNodeId, true, ShardRoutingState.STARTED)  
            return null;
        }).when(mockRepository).getRepositoryData(any(ActionListener.class));
    private static String uuid() {  
    public void testRunReadyCloneWithIOException() throws Exception {
        SnapshotsInProgress.ShardSnapshotStatus shardStatusBefore = initShardStatus(uuid());
     * Tests the error handling in runReadyClone when a RepositoryException occurs.  
            .collect(Collectors.toList());  
        RepositoryData repositoryData = new RepositoryData(  
import static org.mockito.ArgumentMatchers.any;  
import org.opensearch.cluster.routing.ShardRoutingState;
            final SnapshotsInProgress snapshotsInProgress = updatedClusterState.custom(SnapshotsInProgress.TYPE);
     * 3. Neither cloneShardSnapshot nor cloneRemoteStoreIndexShardSnapshot are called  
            assertFalse(SnapshotsService.isOrphanPinnedEntity(repoName, snapshotUUIDs, pinnedEntity));
            false  
        assertIsNoop(updatedClusterState, completeShard);
        Repository mockRepository = mock(Repository.class);
                eq(target.getSnapshotId()),
    }  
            RepositoryData.EMPTY_REPO_GEN,  
    }
        ClusterService mockClusterService = mock(ClusterService.class);
        final SnapshotsInProgress snapshotsInProgress = updatedClusterState.custom(SnapshotsInProgress.TYPE);
        ArrayList<String> snapshotUUIDs = new ArrayList<>(  
    public void testCompletedCloneStartsNextClone() throws Exception {
        final SnapshotsInProgress.Entry updatedSnapshot1 = snapshotsInProgress.entries().get(0);
    /**
            snapshot,
            RepositoryData.EMPTY_REPO_GEN,
        ArrayList<String> pinnedEntities = new ArrayList<>(
        DiscoveryNode localNode = new DiscoveryNode("local", buildNewFakeTransportAddress(), Version.CURRENT);
            final SnapshotsService.ShardSnapshotUpdate shardCompletion = new SnapshotsService.ShardSnapshotUpdate(  
    /**
        final RoutingTable.Builder routingTable = RoutingTable.builder();
            randomBoolean(),  
        doAnswer(invocation -> {
            "full-remote-idx",
    ) {  
        final SnapshotsInProgress.Entry completedClone = snapshotsInProgress.entries().get(0);
        final SnapshotsInProgress.Entry startedSnapshot = snapshotsInProgress.entries().get(1);  
     * Tests the runReadyClone method when remote store index shallow copy is enabled.
        final SnapshotsInProgress.ShardSnapshotStatus shardCloneStatus = startedSnapshot.clones().get(repositoryShardId);
    }
            () -> SnapshotsService.validateNoSegmentsOnlyIndices(state, "test-repo", "snap-1")
import org.opensearch.test.OpenSearchTestCase;
        IndexMetadata indexMetadata = IndexMetadata.builder(indexName)  
            Settings.EMPTY,  
import org.opensearch.cluster.metadata.Metadata;
    }
            listener.onResponse(repositoryData);
        Settings mockSettings = Settings.builder().put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, false).build();
            sourceSnapshot.getSnapshotId(),
        assertThat(cloneSingleShard.state(), is(SnapshotsInProgress.State.STARTED));  
        );
        }
        }  
            );
        assertEquals(repoName, t.v1());  
            Collections.singletonList(indexId1),  
        {
        final String dataNodeId = uuid();  
        final ClusterState updatedClusterState = applyUpdates(stateWithSnapshots(snapshotSingleShard), completeShard);
    }  
            .map(k -> k.index())
        final String dataNodeId = uuid();  
        Repository mockRepository = mock(Repository.class);  
        final SnapshotsInProgress.Entry queuedClone = cloneEntry(
    public void testUpdateSnapshotToSuccess() throws Exception {  
            Collections.singletonList(indexId1),
            shardsMap(routingShardId, initShardStatus(dataNodeId))
    public void testSnapshotV2AllowedForNonRemoteStoreIndex() {
            assertThat(shardSnapshotStatus.nodeId(), is(dataNodeId));
        );
        final SnapshotsInProgress.Entry startedSnapshot = snapshotsInProgress.entries().get(1);  
        final Snapshot targetSnapshot = snapshot(repoName, "target-snapshot");
            Arrays.asList("OouZCQ30TqypFBZGgk1C7g", "RSP6GLJfSO6SsMmUjZNAaA", "OstrHGrERqaR__-597zHYQ, Zjlnf8IHRxqFBijj0m52gw")
 * Licensed to Elasticsearch under one or more contributor  
        final ShardId routingShardId1 = new ShardId(stateWithIndex.metadata().index(indexName1).getIndex(), 0);
        return new Snapshot(repoName, new SnapshotId(name, uuid()));
 * this work for additional information regarding copyright
        );
        SnapshotId sourceSnapshot = new SnapshotId("source-snapshot", uuid());
            sn1,
 * specific language governing permissions and limitations
        SnapshotId sourceSnapshot = new SnapshotId("source-snapshot", uuid());
 * The OpenSearch Contributors require contributions made to  
        final String repoName = "test-repo";  
        assertThat(cloneSingleShard.state(), is(SnapshotsInProgress.State.STARTED));  
        SnapshotsService.ShardSnapshotUpdate expectedUpdate = new SnapshotsService.ShardSnapshotUpdate(target, repoShardId, expectedStatus);
            SnapshotsInProgress.ShardState.SUCCESS,
            IndexMetaDataGenerations.EMPTY
        SnapshotId sourceSnapshot = new SnapshotId("source-snapshot", uuid());
    private static ClusterState clusterStateWithIndex(String indexName, Settings.Builder indexSettings) {
        final String indexName1 = "index-1";
        SnapshotsInProgress.ShardSnapshotStatus shardStatusBefore = initShardStatus(uuid());
        );
            Map.of(shardId1, shardInitStatus, shardId2, shardInitStatus)
     * Helper method to create a SnapshotsService instance with a provided ClusterService.  
    }  
        final IndexId indexId1 = indexId(indexName1);
        final ClusterState stateWithUnassignedRoutingShard = stateWithSnapshots(
            RepositoryData.EMPTY_REPO_GEN,  
    }
     * 2. cloneShardSnapshot is called with the correct parameters
            Collections.emptyMap(),
        );
import org.opensearch.core.action.ActionListener;
        return ClusterState.builder(ClusterState.EMPTY_STATE).metadata(Metadata.builder().put(indexMetadata, false)).build();
        verify(mockRepository).getRepositoryData(any(ActionListener.class));  
        return Map.of(shardId, shardStatus);  
        List<IndexId> indexIds,
            assertThat(startedSnapshot.state(), is(SnapshotsInProgress.State.SUCCESS));
        SnapshotId sourceSnapshot = new SnapshotId("source-snapshot", uuid());
                                ).build()
                            .addIndexShard(
            Settings.builder()
     * An index whose segments are remote backed but whose translog is not cannot be restored from a pinned timestamp,  
        Repository mockRepository = mock(Repository.class);  
            randomBoolean(),
                                ).build()
    private static SnapshotsService.ShardSnapshotUpdate successUpdate(Snapshot snapshot, RepositoryShardId shardId, String nodeId) {
        final String indexName1 = "index-1";  
                .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)  
        final IndexId indexId1 = indexId(indexName1);
        final Snapshot sourceSnapshot = snapshot(repoName, "source-snapshot");  
                "repoName__OouZCQ30TqypFBZGgk1C7g",  
 * not use this file except in compliance with the License.
            Collections.singletonMap(sourceSnapshot.getName(), sourceSnapshot),
    }  
    private static ClusterState stateWithUnassignedIndices(String... indexNames) {
        Snapshot target = snapshot(repoName, "target-snapshot");
            return null;
import java.util.stream.Collectors;  
    }  
        final ClusterState stateWithIndex = stateWithUnassignedIndices(indexName1);  
        assertThat(shardSnapshotStatus.nodeId(), is(dataNodeId));
        final SnapshotsInProgress snapshotsInProgress = updatedClusterState.custom(SnapshotsInProgress.TYPE);  
        assertTrue(SnapshotsService.isOrphanPinnedEntity(repoName, snapshotUUIDs, orphanEntity));
        );  
    public void testNoopShardStateUpdates() throws Exception {
            mock(RemoteStoreSettings.class),
            clonesMap(shardId1, SnapshotsInProgress.ShardSnapshotStatus.UNASSIGNED_QUEUED)
        final RepositoryShardId shardId1 = new RepositoryShardId(indexId1, 0);
import org.opensearch.Version;
        }
        final SnapshotsInProgress.ShardSnapshotStatus shardSnapshotStatus = startedSnapshot.shards().get(routingShardId);
        return new Index(name, uuid());
            final SnapshotsInProgress.Entry completedClone = snapshotsInProgress.entries().get(0);
                snapshot,
        final SnapshotsInProgress.Entry snapshotNoShards = snapshotEntry(snapshot, Collections.emptyList(), Map.of());
            Settings.builder()  
        Exception testException = new RuntimeException("Test exception");  
            );  
            assertThat(completedClone.state(), is(SnapshotsInProgress.State.SUCCESS));
     * Tests the error handling in runReadyClone when an IOException occurs while getting snapshot index metadata.
package org.opensearch.snapshots;
/*  
import org.opensearch.repositories.IndexMetaDataGenerations;
    }
    }
        );
            final SnapshotsInProgress.Entry completedClone = snapshotsInProgress.entries().get(0);
        RepositoryShardId repoShardId = new RepositoryShardId(indexId("test-index"), 0);
        IndexMetadata mockIndexMetadata = mock(IndexMetadata.class);
        final Snapshot targetSnapshot = snapshot(repoName, "target-snapshot");  
            )  
            Collections.emptyMap(),
     * 1. getRepositoryData is called  
                eq(shardStatusBefore.generation()),
        Snapshot target = snapshot(repoName, "target-snapshot");
                shardId1,  
        return new SnapshotsInProgress.ShardSnapshotStatus(nodeId, SnapshotsInProgress.ShardState.SUCCESS, uuid());  
            assertThat(startedSnapshot.shards().get(routingShardId1).state(), is(SnapshotsInProgress.ShardState.WAITING));  
        final ClusterState stateWithUnassignedRoutingShard = stateWithSnapshots(stateWithIndex, cloneSingleShard, snapshotSingleShard);  
     */
        String repoName = "test-repo";  
                    .build()
        {
        assertSame(applyUpdates(state, shardCompletion), state);
 * Unless required by applicable law or agreed to in writing,
            return null;  
        final SnapshotsService.ShardSnapshotUpdate completeShardClone = successUpdate(targetSnapshot, shardId1, uuid());
            clonesMap(shardId1, shardInitStatus)  
                    .add(  
        }  
        RepositoryShardId repoShardId = new RepositoryShardId(indexId("test-index"), 0);  
        ThreadPool mockThreadPool = mock(ThreadPool.class);
        final SnapshotsService.ShardSnapshotUpdate completeShard = successUpdate(plainSnapshot, routingShardId, dataNodeId);  
                IndexMetadata.builder(index)  
        );
        // 1. case: shard that just finished cloning is unassigned -> shard snapshot should go to MISSING state
                .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "translog-repo")
        assertThat(snapshotSingleShard.state(), is(SnapshotsInProgress.State.STARTED));
import static org.mockito.Mockito.mock;  
            eq(sourceSnapshot),
    public void testIsOrphanPinnedEntity() {
    public void testRunReadyCloneWithRepositoryException() throws Exception {
        assertIsNoop(updatedClusterState, completeShard);
        assertThat(completedClone.state(), is(SnapshotsInProgress.State.SUCCESS));
    }  
        String repoName = "test-repo";
     * It verifies that:
        Snapshot snapshot,  
            randomNonNegativeLong(),
                RoutingTable.builder(stateWithUnassignedRoutingShard.routingTable())
            .build();
        final SnapshotsInProgress.Entry snapshotSingleShard = snapshotEntry(
                    .add(
import static org.mockito.Mockito.when;  
                eq(repoShardId),  
        assertEquals("OstrHGrERqaR__-597zHYQ", t.v2());
        final ShardId shardId1 = new ShardId(routingIndex1, 0);  
        final String indexName1 = "index-1";
import static org.opensearch.snapshots.SnapshotsService.getRepoSnapshotUUIDTuple;  
 * under the License.  
    }
        final SnapshotsInProgress snapshotsInProgress = updatedClusterState.custom(SnapshotsInProgress.TYPE);  
     */
        );
 *
            );
        Settings mockSettings = Settings.builder().put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true).build();  
        final SnapshotsInProgress.ShardSnapshotStatus shardInitStatus = initShardStatus(dataNodeId);
        final SnapshotsInProgress.Entry completedClone = snapshotsInProgress.entries().get(0);
    }
            assertThat(startedSnapshot.state(), is(SnapshotsInProgress.State.STARTED));
        final RepositoryShardId shardId1 = new RepositoryShardId(indexId1, 0);
            clonesMap(shardId1, initShardStatus(dataNodeId))  
            ActionListener<RepositoryData> listener = invocation.getArgument(0);
    private static SnapshotsInProgress.ShardSnapshotStatus successfulShardStatus(String nodeId) {
            shardsMap(routingShardId1, SnapshotsInProgress.ShardSnapshotStatus.UNASSIGNED_QUEUED)  
                .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
                false
            queuedClone
            shardsMap(shardId1, initShardStatus(dataNodeId))
            completeShard
            final ClusterState state = stateWithSnapshots(  
        assertThat(e.getMessage(), containsString("snapshot-v2 is not supported"));  
            )  
        final Snapshot sourceSnapshot = snapshot(repoName, "source-snapshot");
     * 1. getRepositoryData is never called  
        );  
        }).when(mockRepository).cloneRemoteStoreIndexShardSnapshot(any(), any(), any(), any(), any(), any(ActionListener.class));
        final ClusterState stateWithIndex = stateWithUnassignedIndices(indexName);
        final ClusterState stateWithInitializingRoutingShard = ClusterState.builder(stateWithUnassignedRoutingShard)  
            .numberOfReplicas(1)  
     * Tests the completion listener functionality in runReadyClone when the operation is successful.  
        );  
            // Verify that getRepositoryData was called
            any(),  
        final SnapshotsInProgress.Entry cloneMultipleShards = cloneEntry(
    }
            mock(IndexNameExpressionResolver.class),
            Collections.singletonList(indexId1),
    public void testCompletedSnapshotStartsClone() throws Exception {
            listener.onFailure(testException);  
                    .settings(Settings.builder().put(SETTING_VERSION_CREATED, Version.CURRENT.id))
     * It verifies that:
        String repoName = "test-repo";
        when(mockRepository.getSnapshotIndexMetaData(eq(repositoryData), eq(sourceSnapshot), any())).thenReturn(mockIndexMetadata);
        doAnswer(invocation -> {
import org.opensearch.cluster.node.DiscoveryNodes;
        // Mock the getRepositoryData method to use the ActionListener
        }
        assertThat(startedSnapshot.clones().get(shardId1).state(), is(SnapshotsInProgress.ShardState.INIT));
import org.opensearch.threadpool.ThreadPool;  
import org.opensearch.repositories.ShardGenerations;
    public void testSnapshotV2AllowedForFullRemoteStoreIndex() {
            )
            localNode.getId(),
    }
    }  
        RepositoryShardId repoShardId = new RepositoryShardId(indexId("test-index"), 0);  
            .distinct()
            targetSnapshot,  
            final SnapshotsInProgress snapshotsInProgress = updatedClusterState.custom(SnapshotsInProgress.TYPE);  
            assertThat(shardSnapshotStatus.state(), is(SnapshotsInProgress.ShardState.INIT));  
            sourceSnapshot.getSnapshotId(),
        final ClusterState updatedClusterState = applyUpdates(stateWithSnapshots(cloneMultipleShards), completeShard);
            sourceSnapshot.getSnapshotId(),
    /**
            ActionListener<RepositoryData> listener = invocation.getArgument(0);
            eq(target.getSnapshotId()),  
            queuedTargetSnapshot,  
        Snapshot target = snapshot(repoName, "target-snapshot");
            ShardGenerations.EMPTY,
        final ClusterState updatedClusterState = applyUpdates(
                snapshotEntry(snapshot, Collections.singletonList(indexId(indexName1)), shardsMap(shardId1, initShardStatus(uuid())))
            verify(mockRepository, never()).cloneShardSnapshot(any(), any(), any(), any(), any());
            cloneSingleShard,  
            indexIds,
import java.util.stream.StreamSupport;
        verify(mockRepository).cloneRemoteStoreIndexShardSnapshot(
            mockTransportService,
            Map.of(shardId1, shardInitStatus, shardId2, shardInitStatus)  
                        IndexRoutingTable.builder(routingShardId1.getIndex())
            listener.onResponse(newGeneration);  
    private static SnapshotsInProgress.ShardSnapshotStatus initShardStatus(String nodeId) {
            );
        SnapshotId sourceSnapshot = new SnapshotId("source-snapshot", uuid());
            queuedSnapshot,
            listener.onFailure(new RepositoryException(repoName, "Test exception"));
            return null;
import org.opensearch.cluster.node.DiscoveryNode;  
        assertThat(cloneSingleShard.state(), is(SnapshotsInProgress.State.STARTED));
        doAnswer(invocation -> {
        );
        IllegalArgumentException e = expectThrows(
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(updatedSnapshot1.state(), is(SnapshotsInProgress.State.SUCCESS));
            ShardGenerations.EMPTY,  
import org.opensearch.common.UUIDs;
        try (SnapshotsService snapshotsService = createSnapshotsService()) {
        doAnswer(invocation -> {  
            verify(mockRepository).getRepositoryData(any(ActionListener.class));
        TransportService mockTransportService = mock(TransportService.class);
            IllegalArgumentException.class,  
        }).when(mockRepository).getRepositoryData(any(ActionListener.class));  
        final SnapshotsInProgress snapshotsInProgress = updatedClusterState.custom(SnapshotsInProgress.TYPE);
        final String repoName = "test-repo";  
        for (String index : indexNames) {  
            clonesMap(shardId1, initShardStatus(clusterManagerNodeId))
     * Tests the runReadyClone method when remote store index shallow copy is globally enabled,
    }
     */  
                shardId1,
import java.util.ArrayList;
            eq(sourceSnapshot),
import org.opensearch.cluster.routing.RoutingTable;
 * license agreements. See the NOTICE file distributed with
            final Index idx = metaBuilder.get(index).getIndex();
        final SnapshotsService.ShardSnapshotUpdate completeShard = successUpdate(targetSnapshot, shardId1, dataNodeId);
    }
        Snapshot target = snapshot(repoName, "target-snapshot");
            final ClusterState state = stateWithSnapshots(snapshotNoShards);  
        SnapshotsService.ShardSnapshotUpdate capturedUpdate = updateCaptor.getValue();  
import static org.mockito.ArgumentMatchers.eq;
        assertIsNoop(updatedClusterState, completeShard);
            Collections.emptyMap(),
 * You may obtain a copy of the License at  
            ShardGenerations.EMPTY,
import static org.mockito.Mockito.verify;
import org.opensearch.cluster.routing.IndexRoutingTable;
        final Snapshot targetSnapshot = snapshot(repoName, "target-snapshot");
        }
        final SnapshotsInProgress snapshotsInProgress = updatedClusterState.custom(SnapshotsInProgress.TYPE);  
            Collections.emptyMap(),
            .routingTable(
                successfulShardStatus(uuid())
        // 2. case: shard that just finished cloning is assigned correctly -> shard snapshot should go to INIT state
    /**
            snapshotsService.runReadyClone(target, sourceSnapshot, shardStatusBefore, repoShardId, mockRepository, true);
            SnapshotsService.ShardSnapshotUpdate.class
        {
            targetSnapshot,
     * 1. getRepositoryData is called and throws an exception
     */
     * 1. getRepositoryData is called
    private static ClusterState stateWithSnapshots(SnapshotsInProgress.Entry... entries) {
 * GitHub history for details.
        final String indexName1 = "index-1";
        assertIsNoop(updatedClusterState, completeShard);
            assertThat(startedSnapshot.state(), is(SnapshotsInProgress.State.STARTED));
     * This test simulates a scenario where the index has remote store enabled.
import java.util.Arrays;
     * 2. cloneShardSnapshot is called instead of cloneRemoteStoreIndexShardSnapshot
            assertThat(startedSnapshot.shards().get(routingShardId1).state(), is(SnapshotsInProgress.ShardState.MISSING));  
import java.util.Collections;  
            plainSnapshot,  
        return new SnapshotsInProgress.ShardSnapshotStatus(nodeId, uuid());
    private static Map<RepositoryShardId, SnapshotsInProgress.ShardSnapshotStatus> clonesMap(
        SnapshotsInProgress.ShardSnapshotStatus shardStatusBefore = initShardStatus(uuid());  
        }).when(mockRepository).getRepositoryData(any(ActionListener.class));
    private static SnapshotsInProgress.Entry cloneEntry(
            return null;  
        assertThat(startedSnapshot.state(), is(SnapshotsInProgress.State.STARTED));
        }).when(mockRepository).getRepositoryData(any(ActionListener.class));
        when(mockRepository.getSnapshotIndexMetaData(eq(repositoryData), eq(sourceSnapshot), any())).thenReturn(mockIndexMetadata);  
        return new IndexId(name, uuid());  
        }).when(mockRepository).getRepositoryData(any(ActionListener.class));  
            .numberOfShards(1)
        verify(mockClusterService).submitStateUpdateTask(eq("update snapshot state"), updateCaptor.capture(), any(), any(), any());
        final Snapshot plainSnapshot = snapshot(repoName, "test-snapshot-1");  
        SnapshotsInProgress.ShardSnapshotStatus shardStatusBefore = initShardStatus(uuid());
            assertThat(completedClone.state(), is(SnapshotsInProgress.State.SUCCESS));  
import java.util.List;
            listener.onResponse(repositoryData);
        return SnapshotsService.SHARD_STATE_EXECUTOR.execute(state, Arrays.asList(updates)).resultingState;
        assertThat(updatedSnapshot1.state(), is(SnapshotsInProgress.State.STARTED));
        }
     */  
        final Snapshot plainSnapshot = snapshot(repoName, "test-snapshot");
    }  
    public void testRunReadyCloneWithRemoteStoreIndexShallowCopyEnabledButIndexDisabled() throws Exception {
        );
                "repoName__RSP6GLJfSO6SsMmUjZNAaA",
        doAnswer(invocation -> {  
            );
            SnapshotsService.ShardSnapshotUpdate.class  
        final String repoName = "test-repo";
            shardsMap(routingShardId, initShardStatus(dataNodeId))
            metaBuilder.put(
        snapshotsService.runReadyClone(target, sourceSnapshot, shardStatusBefore, repoShardId, mockRepository, true);
            eq(repoShardId),
     * 2. The correct failed ShardSnapshotUpdate is submitted to the cluster state  
        SnapshotsInProgress.ShardSnapshotStatus shardStatusBefore = initShardStatus(uuid());
        for (String index : indexNames) {
        Settings mockSettings = Settings.builder().put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true).build();  
            verify(mockRepository).getSnapshotIndexMetaData(eq(repositoryData), eq(sourceSnapshot), any());
        assertIsNoop(updatedClusterState, completeShardClone);  
                    )
     * It verifies that:
            final SnapshotsInProgress.Entry startedSnapshot = snapshotsInProgress.entries().get(1);  
    private static IndexId indexId(String name) {
    private static Map<ShardId, SnapshotsInProgress.ShardSnapshotStatus> shardsMap(
        final SnapshotsInProgress snapshotsInProgress = updatedClusterState.custom(SnapshotsInProgress.TYPE);  
        Repository mockRepository = mock(Repository.class);  
        final IndexId indexId1 = indexId(indexName1);
import java.io.IOException;  
            sn1,
     */
import java.util.Map;
            routingTable.add(IndexRoutingTable.builder(idx).addIndexShard(new IndexShardRoutingTable.Builder(new ShardId(idx, 0)).build()));
                    .build()
    }
        );  
            Collections.singletonMap(sourceSnapshot.getName(), sourceSnapshot),
        return SnapshotsInProgress.startedEntry(
            targetSnapshot,
            verify(mockRepository).getRepositoryData(any(ActionListener.class));
            verify(mockRepository, never()).cloneRemoteStoreIndexShardSnapshot(any(), any(), any(), any(), any(), any());
     * It verifies that:  
        final String repoName = "test-repo";
        }
        final String repoName = "test-repo";
        );
        SnapshotsService.validateNoSegmentsOnlyIndices(state, "test-repo", "snap-1");
import org.opensearch.cluster.service.ClusterService;
            sourceSnapshot.getSnapshotId(),  
        Tuple<String, String> t = getRepoSnapshotUUIDTuple(pinningEntity);
import static org.hamcrest.Matchers.containsString;
            final SnapshotsInProgress.Entry startedSnapshot = snapshotsInProgress.entries().get(1);
            );
        String repoName = "test-repo";  
    private static Index index(String name) {
        final String repoName = "test-repo";
                eq(target.getSnapshotId()),
        String repoName = "test-repo";  
import org.mockito.ArgumentCaptor;  
                                    TestShardRouting.newShardRouting(routingShardId1, dataNodeId, true, ShardRoutingState.INITIALIZING)
        Snapshot target = snapshot(repoName, "target-snapshot");  
        final Snapshot sn1 = snapshot(repoName, "snapshot-1");
}  
            Collections.emptyMap(),  
            mockClusterService,
    /**
        SnapshotsService.ShardSnapshotUpdate capturedUpdate = updateCaptor.getValue();
import org.opensearch.cluster.metadata.IndexMetadata;  
        return UUIDs.randomBase64UUID(random());
 * compatible open source license.
            Collections.emptyMap(),
        Repository mockRepository = mock(Repository.class);  
            verify(mockRepository, never()).cloneShardSnapshot(any(), any(), any(), any(), any());  
        RepositoryData repositoryData = new RepositoryData(
            final SnapshotsService.ShardSnapshotUpdate shardCompletion = new SnapshotsService.ShardSnapshotUpdate(
        // Mock the getRepositoryData method to throw an exception
            Collections.singletonList(indexId1),
 */
    public void testRunReadyCloneWithRemoteStoreIndexShallowCopyDisabled() throws Exception {  
            final SnapshotsInProgress.Entry completedClone = snapshotsInProgress.entries().get(0);
                    .numberOfReplicas(0)  
    }
        DiscoveryNode localNode = new DiscoveryNode("local", buildNewFakeTransportAddress(), Version.CURRENT);
        );  
            ShardGenerations.EMPTY,
            IndexMetaDataGenerations.EMPTY
                RoutingTable.builder(stateWithUnassignedRoutingShard.routingTable())
        assertThat(cloneMultipleShards.state(), is(SnapshotsInProgress.State.STARTED));
        final ShardId shardId1 = new ShardId(index(indexName1), 0);  
        RepositoryShardId repoShardId = new RepositoryShardId(indexId("test-index"), 0);
    }  
            shards,  
        final Map<ShardId, SnapshotsInProgress.ShardSnapshotStatus> shards
        doAnswer(invocation -> {  
            verify(mockRepository).getRepositoryData(any(ActionListener.class));
                            )  
        for (String pinnedEntity : pinnedEntities) {  
        final IndexId indexId1 = indexId(indexName);  
        assertEquals(expectedUpdate.hashCode(), capturedUpdate.hashCode());
        final SnapshotsInProgress.Entry cloneSingleShard = cloneEntry(
                any(),
        final RepositoryShardId shardId1 = new RepositoryShardId(indexId1, 0);
        ClusterService mockClusterService = mock(ClusterService.class);
        final String indexName = "index-1";
        SnapshotId sourceSnapshot = new SnapshotId("source-snapshot", uuid());
        RepositoryData repositoryData = new RepositoryData(
     * 1. The clone operation completes successfully
        final IndexId indexId1 = indexId(indexName1);
        );
        );
        doAnswer(invocation -> {  
                                new IndexShardRoutingTable.Builder(routingShardId1).addShard(  
     * It verifies that:
 * SPDX-License-Identifier: Apache-2.0
                eq(repoShardId),  
                            )
    private SnapshotsService createSnapshotsService(ClusterService mockClusterService) {  
        final SnapshotsInProgress.ShardSnapshotStatus shardInitStatus = initShardStatus(dataNodeId);
            return null;  
            ActionListener<RepositoryData> listener = invocation.getArgument(0);
            Collections.singletonList(indexId1),
        when(mockThreadPool.executor(ThreadPool.Names.SNAPSHOT)).thenReturn(OpenSearchExecutors.newDirectExecutorService());
                eq(sourceSnapshot),  
    public void testRunReadyCloneWithRemoteStoreIndexShallowCopyEnabled() throws Exception {
     * A document replication index is not remote backed at all, so the remote translog requirement does not apply.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .build();  
        {
            null,  
import org.opensearch.core.index.shard.ShardId;  
            null
        final SnapshotsService.ShardSnapshotUpdate completeShard = successUpdate(targetSnapshot, shardId1, dataNodeId);
        Snapshot target = snapshot(repoName, "target-snapshot");
 * KIND, either express or implied.  See the License for the
            listener.onResponse(repositoryData);
import org.opensearch.common.settings.Settings;
                .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "segment-repo")
        final Snapshot sourceSnapshot = snapshot(repoName, "source-snapshot");
    private static void assertIsNoop(ClusterState state, SnapshotsService.ShardSnapshotUpdate shardCompletion) throws Exception {  
            ShardGenerations.EMPTY,
        );
        // 3. case: shard that just finished cloning is currently initializing -> shard snapshot should go to WAITING state
            targetSnapshot,
 */  
        SnapshotsService.ShardSnapshotUpdate expectedUpdate = new SnapshotsService.ShardSnapshotUpdate(target, repoShardId, expectedStatus);
            Collections.singletonMap(sourceSnapshot.getName(), sourceSnapshot),
    public void testUpdateSnapshotMultipleShards() throws Exception {
            .putCustom(SnapshotsInProgress.TYPE, SnapshotsInProgress.of(Arrays.asList(entries)))
        assertThat(updatedSnapshot1.state(), is(SnapshotsInProgress.State.STARTED));  
     * but disabled for the specific index.
        );
            // Verify that getRepositoryData was called  
    }
        // Create a real RepositoryData instance
        return new SnapshotsService(
        when(mockTransportService.getThreadPool()).thenReturn(mockThreadPool);  
        Repository mockRepository = mock(Repository.class);
        final String repoName = "test-repo";
        RepositoryData repositoryData = new RepositoryData(
        {
        final SnapshotsInProgress.Entry snapshotSingleShard = snapshotEntry(  
    public void testUpdateCloneToSuccess() throws Exception {
        final String dataNodeId = uuid();  
     */
    }
public class SnapshotsServiceTests extends OpenSearchTestCase {
        }).when(mockRepository).getRepositoryData(any(ActionListener.class));
            plainSnapshot,
        final String clusterManagerNodeId = uuid();  
            any()
            newGeneration
            plainSnapshot,
                successfulShardStatus(uuid())  
            Collections.emptyMap(),  
        assertIsNoop(updatedClusterState, completeShard);  
        final Snapshot queuedSnapshot = snapshot(repoName, "test-snapshot-2");
                eq(shardStatusBefore.generation()),
    }  
        final IndexId indexId1 = indexId(indexName);
    /**  
    /**  
                            .addIndexShard(
        when(mockIndexMetadata.getSettings()).thenReturn(mockSettings);  
            eq(shardStatusBefore.generation()),
        final Metadata.Builder metaBuilder = Metadata.builder(Metadata.EMPTY_METADATA);  
        final ClusterState updatedClusterState = applyUpdates(stateWithSnapshots(snapshotSingleShard, cloneSingleShard), completeShard);
    }  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_CREATED;
            eq(shardStatusBefore.generation()),
    }
     * Tests the completion listener functionality in runReadyClone when the operation fails.  
 * this file be licensed under the Apache-2.0 license or a
 */  
            assertIsNoop(state, shardCompletion);  
        }  
    }
    }
        final String indexName = "index-1";  
            verify(mockRepository, never()).cloneRemoteStoreIndexShardSnapshot(any(), any(), any(), any(), any(), any());
        final Snapshot sourceSnapshot = snapshot(repoName, "source-snapshot");
    }  
    }  
            Collections.emptyMap(),
        SnapshotsInProgress.ShardSnapshotStatus shardStatus  
        final String repoName = "test-repo";  
            stateWithSnapshots(snapshotSingleShard, queuedSnapshotSingleShard),  
                any()  
        ClusterState state = clusterStateWithIndex("docrep-idx", Settings.builder());  
            Collections.emptyMap(),  
        }
        final Snapshot queuedTargetSnapshot = snapshot(repoName, "test-snapshot");
    /**
            ActionListener<RepositoryData> listener = invocation.getArgument(0);
    }  
import org.opensearch.cluster.SnapshotsInProgress;
        return ClusterState.builder(state)
    }
            eq(target.getSnapshotId()),  
            .routingTable(  
            Version.CURRENT,
        SnapshotsInProgress.ShardSnapshotStatus expectedStatus = new SnapshotsInProgress.ShardSnapshotStatus(
        final SnapshotsInProgress.ShardSnapshotStatus shardInitStatus = initShardStatus(dataNodeId);
            verify(mockRepository).getRepositoryData(any(ActionListener.class));  
import org.opensearch.common.settings.ClusterSettings;
        );
            Collections.emptyMap(),
import org.opensearch.cluster.routing.TestShardRouting;  
            Collections.emptyMap(),
     * 2. getSnapshotIndexMetaData throws an IOException
        return SnapshotsInProgress.startClone(snapshot, source, indexIds, 1L, randomNonNegativeLong(), Version.CURRENT).withClones(clones);
            verify(mockRepository, never()).getRepositoryData(any());
            snapshotsService.runReadyClone(target, sourceSnapshot, shardStatusBefore, repoShardId, mockRepository, true);  
        final IndexId indexId1 = indexId(indexName1);
            targetSnapshot,
        final ClusterState updatedClusterState = applyUpdates(stateWithSnapshots(cloneSingleShard), completeShard);  
        assertThat(completedClone.state(), is(SnapshotsInProgress.State.SUCCESS));
            mockRepoService,  
        final String indexName1 = "index-1";
        Settings mockSettings = Settings.builder().put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true).build();
        final IndexId indexId1 = indexId(indexName1);  
import static org.hamcrest.Matchers.is;
        assertThat(shardCloneStatus.nodeId(), is(updatedClusterState.nodes().getLocalNodeId()));
        SnapshotsService snapshotsService = createSnapshotsService(mockClusterService);
 *  
import static org.mockito.Mockito.never;
            RepositoryData.EMPTY_REPO_GEN,
    private static SnapshotsService.ShardSnapshotUpdate successUpdate(Snapshot snapshot, ShardId shardId, String nodeId) {  
        final SnapshotsInProgress.Entry cloneSingleShard = cloneEntry(
    }  
        );  
            .build();
        assertThat(updatedSnapshot1.state(), is(SnapshotsInProgress.State.SUCCESS));  
import org.opensearch.repositories.IndexId;  
     * This method mocks all necessary dependencies for the SnapshotsService.
            mock(ActionFilters.class),
            any()
        final SnapshotsInProgress.Entry updatedSnapshot1 = snapshotsInProgress.entries().get(0);
        when(mockRepository.getSnapshotIndexMetaData(eq(repositoryData), eq(sourceSnapshot), any())).thenThrow(  
            eq(repoShardId),
        when(mockClusterService.localNode()).thenReturn(localNode);  
        ClusterState state = clusterStateWithIndex(
     * It verifies that:
        }  
        );
        RepositoryShardId repoShardId = new RepositoryShardId(indexId("test-index"), 0);  
        SnapshotId sourceSnapshot = new SnapshotId("source-snapshot", uuid());  
            snapshotsService.runReadyClone(target, sourceSnapshot, shardStatusBefore, repoShardId, mockRepository, false);  
        final SnapshotsInProgress snapshotsInProgress = updatedClusterState.custom(SnapshotsInProgress.TYPE);
            return null;
    /**
        );
/*
        try (SnapshotsService snapshotsService = createSnapshotsService()) {
        when(mockIndexMetadata.getSettings()).thenReturn(mockSettings);  
        final Snapshot targetSnapshot = snapshot(repoName, "target-snapshot");
        RepositoryShardId shardId,  
    }
        final ClusterState stateWithIndex = stateWithUnassignedIndices(indexName);
            "segments-only-idx",
    }  
                eq(repoShardId),
    }
            .build();
import org.opensearch.indices.RemoteStoreSettings;
     */
            localNode.getId(),  
        Snapshot snapshot,
        RepositoriesService mockRepoService = mock(RepositoriesService.class);
        final Map<RepositoryShardId, SnapshotsInProgress.ShardSnapshotStatus> clones
                        IndexRoutingTable.builder(routingShardId1.getIndex())  
        SnapshotsService.validateNoSegmentsOnlyIndices(state, "test-repo", "snap-1");
            assertIsNoop(state, shardCompletion);
        }).when(mockRepository).cloneRemoteStoreIndexShardSnapshot(any(), any(), any(), any(), any(), any(ActionListener.class));
        final SnapshotsInProgress.Entry startedSnapshot = snapshotsInProgress.entries().get(1);  
