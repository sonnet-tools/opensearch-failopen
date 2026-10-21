        String pinningEntity = "repoName__OstrHGrERqaR__-597zHYQ";
            assertThat(shardSnapshotStatus.nodeId(), is(dataNodeId));
            null
        final String dataNodeId = uuid();
        return SnapshotsInProgress.startClone(snapshot, source, indexIds, 1L, randomNonNegativeLong(), Version.CURRENT).withClones(clones);
        final Snapshot sourceSnapshot = snapshot(repoName, "source-snapshot");
            Collections.singletonMap(sourceSnapshot.getName(), sourceSnapshot),
            sn1,
                any()
        final Snapshot targetSnapshot = snapshot(repoName, "target-snapshot");
            shardsMap(routingShardId, initShardStatus(dataNodeId))
        try (SnapshotsService snapshotsService = createSnapshotsService()) {
            plainSnapshot,
    public void testUpdateCloneToSuccess() throws Exception {
        SnapshotsInProgress.ShardSnapshotStatus shardStatusBefore = initShardStatus(uuid());
            Collections.singletonList(indexId1),
            eq(sourceSnapshot),
            sourceSnapshot.getSnapshotId(),
        return ClusterState.builder(ClusterState.EMPTY_STATE).metadata(Metadata.builder().put(indexMetadata, false)).build();
    }
        when(mockIndexMetadata.getSettings()).thenReturn(mockSettings);
        verify(mockClusterService).submitStateUpdateTask(eq("update snapshot state"), updateCaptor.capture(), any(), any(), any());
        );
    }
            eq(target.getSnapshotId()),
        when(mockRepository.getSnapshotIndexMetaData(eq(repositoryData), eq(sourceSnapshot), any())).thenReturn(mockIndexMetadata);
 * software distributed under the License is distributed on an
            final SnapshotsInProgress snapshotsInProgress = updatedClusterState.custom(SnapshotsInProgress.TYPE);
                RoutingTable.builder(stateWithUnassignedRoutingShard.routingTable())
 */
        );
        String repoName = "test-repo";
import org.opensearch.common.settings.Settings;
        when(mockClusterService.getClusterSettings()).thenReturn(clusterSettings);
            any(),
            assertThat(completedClone.state(), is(SnapshotsInProgress.State.SUCCESS));
        assertThat(startedSnapshot.state(), is(SnapshotsInProgress.State.STARTED));
        return DiscoveryNodes.builder().localNodeId(localNodeId).build();
        final ShardId shardId1 = new ShardId(index(indexName1), 0);
        doAnswer(invocation -> {
     * A document replication index is not remote backed at all, so the remote translog requirement does not apply.
    }
            listener.onResponse(repositoryData);
        Snapshot snapshot,
            targetSnapshot,
        );
import org.opensearch.cluster.SnapshotsInProgress;
        RepositoryData repositoryData = new RepositoryData(
            Collections.emptyMap(),
    }
        final SnapshotsInProgress snapshotsInProgress = updatedClusterState.custom(SnapshotsInProgress.TYPE);
        final SnapshotsInProgress.Entry completedSnapshot = snapshotsInProgress.entries().get(0);
    ) {
        final Snapshot plainSnapshot = snapshot(repoName, "test-snapshot-1");
        assertThat(cloneSingleShard.state(), is(SnapshotsInProgress.State.STARTED));
        final SnapshotsInProgress.ShardSnapshotStatus shardInitStatus = initShardStatus(dataNodeId);
     * 2. The correct ShardSnapshotUpdate is submitted to the cluster state
    private static Map<RepositoryShardId, SnapshotsInProgress.ShardSnapshotStatus> clonesMap(
        assertEquals("OstrHGrERqaR__-597zHYQ", t.v2());
 *
            RepositoryData.EMPTY_REPO_GEN,
    public void testUpdateSnapshotToSuccess() throws Exception {
     * Tests the error handling in runReadyClone when an IOException occurs while getting snapshot index metadata.
        assertThat(snapshotSingleShard.state(), is(SnapshotsInProgress.State.STARTED));
        }
     * 1. getRepositoryData is called
        }
        // 2. case: shard that just finished cloning is assigned correctly -> shard snapshot should go to INIT state
            1L,
    private static ClusterState clusterStateWithIndex(String indexName, Settings.Builder indexSettings) {
        ShardId shardId,
     * It verifies that:
    public void testNoopShardStateUpdates() throws Exception {
    }
        when(mockIndexMetadata.getSettings()).thenReturn(mockSettings);
        final IndexId indexId1 = indexId(indexName1);
                    .build()
        }).when(mockRepository).getRepositoryData(any(ActionListener.class));
            sourceSnapshot.getSnapshotId(),
        return ClusterState.builder(ClusterState.EMPTY_STATE).metadata(metaBuilder).routingTable(routingTable.build()).build();
    public void testCompletedCloneStartsSnapshot() throws Exception {
            listener.onResponse(repositoryData);
        );
            shards,
        final SnapshotsInProgress.Entry startedSnapshot = snapshotsInProgress.entries().get(1);
        final SnapshotsService.ShardSnapshotUpdate completeShardClone = successUpdate(targetSnapshot, shardId1, uuid());
        SnapshotsService snapshotsService = createSnapshotsService(mockClusterService);
        when(mockIndexMetadata.getSettings()).thenReturn(mockSettings);
            verify(mockRepository).getRepositoryData(any(ActionListener.class));
 * not use this file except in compliance with the License.
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        assertIsNoop(updatedClusterState, completeShard);
        Settings mockSettings = Settings.builder().put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true).build();
        assertThat(updatedSnapshot1.state(), is(SnapshotsInProgress.State.STARTED));
    }
                eq(shardStatusBefore.generation()),
            Collections.singletonMap(sourceSnapshot.getName(), sourceSnapshot),
            ActionListener<RepositoryData> listener = invocation.getArgument(0);
            Collections.emptyMap(),
        final SnapshotsService.ShardSnapshotUpdate completeShard = successUpdate(plainSnapshot, routingShardId, dataNodeId);
        );
        }
                snapshotEntry(snapshot, Collections.singletonList(indexId(indexName1)), shardsMap(shardId1, initShardStatus(uuid())))
            Collections.emptyMap(),
        }
     */
import org.opensearch.common.UUIDs;
        Tuple<String, String> t = getRepoSnapshotUUIDTuple(pinningEntity);
            metaBuilder.put(
        ClusterService mockClusterService = mock(ClusterService.class);
        final SnapshotsInProgress.ShardSnapshotStatus shardCloneStatus = startedSnapshot.clones().get(repositoryShardId);
        RepositoryShardId shardId,
        final String repoName = "test-repo";
        final IndexId indexId1 = indexId(indexName1);
        final SnapshotsInProgress.Entry updatedSnapshot1 = snapshotsInProgress.entries().get(0);
            Settings.builder()
        final Map<ShardId, SnapshotsInProgress.ShardSnapshotStatus> shards
        try (SnapshotsService snapshotsService = createSnapshotsService()) {
                eq(target.getSnapshotId()),
        RepositoryData repositoryData = new RepositoryData(
     * A full remote store index has a remote translog to replay from, so snapshot-v2 stays available for it.
            snapshotsService.runReadyClone(target, sourceSnapshot, shardStatusBefore, repoShardId, mockRepository, false);
            final SnapshotsInProgress snapshotsInProgress = updatedClusterState.custom(SnapshotsInProgress.TYPE);
     * Tests the completion listener functionality in runReadyClone when the operation is successful.
     * It verifies that:
        Snapshot target = snapshot(repoName, "target-snapshot");
    }
            targetSnapshot,
        assertThat(startedSnapshot.state(), is(SnapshotsInProgress.State.STARTED));
import static org.mockito.Mockito.doAnswer;
            final SnapshotsInProgress.Entry startedSnapshot = snapshotsInProgress.entries().get(1);
            );
        }
import org.opensearch.core.index.Index;
        final SnapshotsInProgress snapshotsInProgress = updatedClusterState.custom(SnapshotsInProgress.TYPE);
        final ClusterState stateWithUnassignedRoutingShard = stateWithSnapshots(
        // 1. case: shard that just finished cloning is unassigned -> shard snapshot should go to MISSING state
            clonesMap(shardId1, initShardStatus(clusterManagerNodeId))
            listener.onResponse(repositoryData);
            return null;
        for (String index : indexNames) {
        final SnapshotsInProgress.Entry completedClone = snapshotsInProgress.entries().get(0);
            Collections.emptyMap(),
        ArgumentCaptor<SnapshotsService.ShardSnapshotUpdate> updateCaptor = ArgumentCaptor.forClass(
        assertThat(shardCloneStatus.state(), is(SnapshotsInProgress.ShardState.INIT));
        final ClusterState updatedClusterState = applyUpdates(stateWithUnassignedRoutingShard, completeShardClone);
        return new SnapshotsService(
        );
        RepositoryShardId repoShardId = new RepositoryShardId(indexId("test-index"), 0);
        when(mockIndexMetadata.getSettings()).thenReturn(mockSettings);
    private static Index index(String name) {
            final SnapshotsInProgress.Entry completedClone = snapshotsInProgress.entries().get(0);
        assertThat(snapshotSingleShard.state(), is(SnapshotsInProgress.State.STARTED));
        Repository mockRepository = mock(Repository.class);
        assertThat(e.getMessage(), containsString("segments-only-idx"));
    }
    }
            listener.onFailure(testException);
            ActionListener<RepositoryData> listener = invocation.getArgument(0);
import static org.mockito.Mockito.verify;
        final RepositoryShardId shardId1 = new RepositoryShardId(indexId1, 0);
            SnapshotsService.ShardSnapshotUpdate.class
                eq(sourceSnapshot),
        final String indexName1 = "index-1";
        final ClusterState updatedClusterState = applyUpdates(stateWithSnapshots(snapshotSingleShard), completeShard);
        );
            Collections.emptyMap(),
        RepositoryShardId repoShardId = new RepositoryShardId(indexId("test-index"), 0);
 * specific language governing permissions and limitations
import org.opensearch.cluster.routing.TestShardRouting;
            Collections.emptyMap(),
            assertFalse(SnapshotsService.isOrphanPinnedEntity(repoName, snapshotUUIDs, pinnedEntity));
        Snapshot target = snapshot(repoName, "target-snapshot");
import java.util.Collections;
        final Snapshot sourceSnapshot = snapshot(repoName, "source-snapshot");
            final SnapshotsService.ShardSnapshotUpdate shardCompletion = new SnapshotsService.ShardSnapshotUpdate(
            verify(mockRepository, never()).getRepositoryData(any());
            final SnapshotsInProgress.Entry startedSnapshot = snapshotsInProgress.entries().get(1);
        return UUIDs.randomBase64UUID(random());
        SnapshotsInProgress.ShardSnapshotStatus shardStatusBefore = initShardStatus(uuid());
        final RepositoryShardId shardId1 = new RepositoryShardId(indexId1, 0);
        when(mockTransportService.getThreadPool()).thenReturn(mockThreadPool);
        }).when(mockRepository).cloneRemoteStoreIndexShardSnapshot(any(), any(), any(), any(), any(), any(ActionListener.class));
import java.io.IOException;
    public void testCompletedSnapshotStartsClone() throws Exception {
        final SnapshotsInProgress.Entry updatedSnapshot1 = snapshotsInProgress.entries().get(0);
}
        final ShardId shardId1 = new ShardId(routingIndex1, 0);
        );
        final IndexId indexId1 = indexId(indexName);
            targetSnapshot,
public class SnapshotsServiceTests extends OpenSearchTestCase {
        final RoutingTable.Builder routingTable = RoutingTable.builder();
            verify(mockRepository, never()).cloneRemoteStoreIndexShardSnapshot(any(), any(), any(), any(), any(), any());
        snapshotsService.runReadyClone(target, sourceSnapshot, shardStatusBefore, repoShardId, mockRepository, true);
        assertEquals(RestStatus.BAD_REQUEST, ExceptionsHelper.status(e));
    }
     */
        final IndexId indexId1 = indexId(indexName1);
        }).when(mockRepository).getRepositoryData(any(ActionListener.class));
                "repoName__OstrHGrERqaR__-597zHYQ, Zjlnf8IHRxqFBijj0m52gw"
        assertSame(applyUpdates(state, shardCompletion), state);
            );
 * You may obtain a copy of the License at
            assertIsNoop(state, shardCompletion);
        {
            queuedSnapshot,
            snapshotsService.runReadyClone(target, sourceSnapshot, shardStatusBefore, repoShardId, mockRepository, true);
                    .build()
        // Mock the getRepositoryData method to use the ActionListener
            Version.CURRENT,
        ClusterState state = clusterStateWithIndex("docrep-idx", Settings.builder());
            Collections.singletonList(indexId1),
    }
                shardId1,
        String newGeneration = "new_generation";
            .build();
    public void testRunReadyCloneWithRemoteStoreIndexShallowCopyDisabled() throws Exception {
        SnapshotsInProgress.ShardSnapshotStatus shardStatusBefore = initShardStatus(uuid());
        assertThat(startedSnapshot.clones().get(shardId1).state(), is(SnapshotsInProgress.ShardState.INIT));
            ShardGenerations.EMPTY,
        SnapshotsService.ShardSnapshotUpdate expectedUpdate = new SnapshotsService.ShardSnapshotUpdate(target, repoShardId, expectedStatus);
        assertTrue(SnapshotsService.isOrphanPinnedEntity(repoName, snapshotUUIDs, orphanEntity));
    /**
        final Index routingIndex1 = index(indexName1);
        verify(mockRepository).getRepositoryData(any(ActionListener.class));
            )
            newGeneration
    }
        assertEquals(expectedUpdate.hashCode(), capturedUpdate.hashCode());
        final SnapshotsInProgress snapshotsInProgress = updatedClusterState.custom(SnapshotsInProgress.TYPE);
        final SnapshotsInProgress snapshotsInProgress = updatedClusterState.custom(SnapshotsInProgress.TYPE);
        final String indexName1 = "index-1";
 * under the License.
        doAnswer(invocation -> {
            SnapshotsInProgress.ShardState.SUCCESS,
import java.util.stream.Collectors;
                snapshot,
    /**
import org.opensearch.repositories.Repository;
    public void testGetRepoSnapshotUUIDTuple() {
            "failed to clone shard snapshot",
            );
        final String indexName1 = "index-1";
            routingTable.add(IndexRoutingTable.builder(idx).addIndexShard(new IndexShardRoutingTable.Builder(new ShardId(idx, 0)).build()));
        final SnapshotsInProgress.Entry cloneSingleShard = cloneEntry(
            ActionListener<RepositoryData> listener = invocation.getArgument(0);
        );
    private static ClusterState stateWithUnassignedIndices(String... indexNames) {
        final SnapshotsInProgress.Entry updatedSnapshot1 = snapshotsInProgress.entries().get(0);
 */
        );
                .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "translog-repo")
                        IndexRoutingTable.builder(routingShardId1.getIndex())
        );
    }
 * compatible open source license.
            assertIsNoop(updatedClusterState, completeShardClone);
            sourceSnapshot.getSnapshotId(),
                    .build(),
            eq(repoShardId),
            )
import org.opensearch.cluster.metadata.Metadata;
        final SnapshotsInProgress.Entry snapshotSingleShard = snapshotEntry(
        ClusterService mockClusterService = mock(ClusterService.class);
import org.opensearch.cluster.ClusterState;
            verify(mockRepository).cloneShardSnapshot(
     * It verifies that:
        final SnapshotsService.ShardSnapshotUpdate completeShard = successUpdate(sn1, shardId1, dataNodeId);
            null
        RepositoryShardId repoShardId = new RepositoryShardId(indexId("test-index"), 0);
import org.opensearch.repositories.RepositoriesService;
            assertThat(startedSnapshot.state(), is(SnapshotsInProgress.State.STARTED));
        final String dataNodeId = uuid();
     * An index whose segments are remote backed but whose translog is not cannot be restored from a pinned timestamp,
    private static ClusterState stateWithSnapshots(ClusterState state, SnapshotsInProgress.Entry... entries) {
        RepositoryData repositoryData = new RepositoryData(
            null,
        final IndexId indexId1 = indexId(indexName);
            eq(sourceSnapshot),
     * 1. getRepositoryData is called and throws an exception
                                    TestShardRouting.newShardRouting(routingShardId1, dataNodeId, true, ShardRoutingState.INITIALIZING)
            sn1,
        }
            Collections.singletonList(indexId1),
        DiscoveryNode localNode = new DiscoveryNode("local", buildNewFakeTransportAddress(), Version.CURRENT);
        final Map<RepositoryShardId, SnapshotsInProgress.ShardSnapshotStatus> clones
        final Snapshot targetSnapshot = snapshot(repoName, "target-snapshot");
        final ShardId shardId1 = new ShardId(index(indexName1), 0);
     */
        final String indexName1 = "index-1";
     */
            localNode.getId(),
            return null;
    private static Map<ShardId, SnapshotsInProgress.ShardSnapshotStatus> shardsMap(
import org.opensearch.core.rest.RestStatus;
            Settings.EMPTY,
            Map.of(shardId1, shardInitStatus, shardId2, shardInitStatus)
                eq(sourceSnapshot),
     * This method is a convenience wrapper around createSnapshotsService(ClusterService).
            );
            ActionListener<RepositoryData> listener = invocation.getArgument(0);
            sourceSnapshot.getSnapshotId(),
                any()
        Settings mockSettings = Settings.builder().put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, false).build();
        // Create a real RepositoryData instance
        {
            eq(shardStatusBefore.generation()),
            verify(mockRepository).getRepositoryData(any(ActionListener.class));
            IndexMetaDataGenerations.EMPTY
    }
                .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
                            )
            final SnapshotsInProgress snapshotsInProgress = updatedClusterState.custom(SnapshotsInProgress.TYPE);
            listener.onResponse(repositoryData);
import static org.mockito.Mockito.never;
        String repoName = "repoName";
            Collections.emptyMap(),
    public void testCompletedSnapshotStartsNextSnapshot() throws Exception {
            verify(mockRepository).getRepositoryData(any(ActionListener.class));
        SnapshotId sourceSnapshot = new SnapshotId("source-snapshot", uuid());
            verify(mockRepository).getRepositoryData(any(ActionListener.class));
            .distinct()
        {
        Repository mockRepository = mock(Repository.class);
        {
     * 1. The clone operation completes successfully
        );
    private SnapshotsService createSnapshotsService() {
    public void testUpdateCloneMultipleShards() throws Exception {
        for (String pinnedEntity : pinnedEntities) {
     * 1. getRepositoryData is never called
            indexIds,
    }
        Snapshot target = snapshot(repoName, "target-snapshot");
            final ClusterState updatedClusterState = applyUpdates(stateWithUnassignedRoutingShard, completeShardClone);
        final String dataNodeId = uuid();
        SnapshotsInProgress.ShardSnapshotStatus shardStatus
     * It verifies that:
            final SnapshotsInProgress.Entry startedSnapshot = snapshotsInProgress.entries().get(1);
        final ClusterState updatedClusterState = applyUpdates(stateWithSnapshots(cloneMultipleShards), completeShard);
        }
     * 2. cloneShardSnapshot is called instead of cloneRemoteStoreIndexShardSnapshot
        final Metadata.Builder metaBuilder = Metadata.builder(Metadata.EMPTY_METADATA);
        SnapshotsInProgress.ShardSnapshotStatus shardStatusBefore = initShardStatus(uuid());
 * Modifications Copyright OpenSearch Contributors. See
            mock(IndexNameExpressionResolver.class),
     * Tests the completion listener functionality in runReadyClone when the operation fails.
        final SnapshotsInProgress.Entry queuedSnapshotSingleShard = snapshotEntry(
        SnapshotId sourceSnapshot = new SnapshotId("source-snapshot", uuid());
        final Snapshot plainSnapshot = snapshot(repoName, "test-snapshot");
    public void testRunReadyCloneCompletionListener() throws Exception {
            final SnapshotsInProgress.Entry completedClone = snapshotsInProgress.entries().get(0);
        ArrayList<String> pinnedEntities = new ArrayList<>(
            ActionListener<String> listener = invocation.getArgument(5);
        assertIsNoop(updatedClusterState, completeShard);
        RepositoriesService mockRepoService = mock(RepositoriesService.class);
        RepositoryShardId repoShardId = new RepositoryShardId(indexId("test-index"), 0);
            assertThat(startedSnapshot.state(), is(SnapshotsInProgress.State.SUCCESS));
import org.opensearch.transport.TransportService;
        assertThat(shardSnapshotStatus.nodeId(), is(dataNodeId));
                eq(target.getSnapshotId()),
        return Map.of(shardId, shardStatus);
        try (SnapshotsService snapshotsService = createSnapshotsService()) {
                shardId1,
    }
    /**
        final Snapshot plainSnapshot = snapshot(repoName, "test-snapshot");
            IndexMetaDataGenerations.EMPTY
            final ClusterState updatedClusterState = applyUpdates(stateWithAssignedRoutingShard, completeShardClone);
        String repoName = "repoName";
                    )
    }
            .map(k -> k.index())
        // Verify that innerUpdateSnapshotState was called with the correct arguments
    }
import org.opensearch.Version;
    /**
        final ClusterState stateWithIndex = stateWithUnassignedIndices(indexName1);
        );
            verify(mockRepository, never()).cloneShardSnapshot(any(), any(), any(), any(), any());
    }
 * GitHub history for details.
        SnapshotsInProgress.ShardSnapshotStatus shardStatusBefore = initShardStatus(uuid());
        assertThat(cloneMultipleShards.state(), is(SnapshotsInProgress.State.STARTED));
            snapshotsService.runReadyClone(target, sourceSnapshot, shardStatusBefore, repoShardId, mockRepository, true);
            clonesMap(shardId1, SnapshotsInProgress.ShardSnapshotStatus.UNASSIGNED_QUEUED)
        SnapshotsInProgress.ShardSnapshotStatus shardStatus
        final String repoName = "test-repo";
    }
        final ClusterState updatedClusterState = applyUpdates(stateWithSnapshots(cloneSingleShard), completeShard);
    private static SnapshotsInProgress.ShardSnapshotStatus initShardStatus(String nodeId) {
                snapshot("other-repo", snapshot.getSnapshotId().getName()),
            Collections.emptyMap(),
            return null;
        }).when(mockRepository).getRepositoryData(any(ActionListener.class));
        try (SnapshotsService snapshotsService = createSnapshotsService()) {
            .routingTable(
            IndexMetaDataGenerations.EMPTY
import static org.mockito.Mockito.mock;
        {
        Snapshot target = snapshot(repoName, "target-snapshot");
package org.opensearch.snapshots;
        final SnapshotsInProgress.Entry cloneSingleShard = cloneEntry(
        Settings mockSettings = Settings.builder().put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true).build();
        SnapshotsService.ShardSnapshotUpdate capturedUpdate = updateCaptor.getValue();
        when(mockRepository.getSnapshotIndexMetaData(eq(repositoryData), eq(sourceSnapshot), any())).thenThrow(
        }).when(mockRepository).getRepositoryData(any(ActionListener.class));
            listener.onFailure(new RepositoryException(repoName, "Test exception"));
        SnapshotsService snapshotsService = createSnapshotsService(mockClusterService);
        final RepositoryShardId shardId2 = new RepositoryShardId(indexId1, 1);
        final SnapshotsService.ShardSnapshotUpdate completeShard = successUpdate(plainSnapshot, routingShardId, dataNodeId);
            mock(ActionFilters.class),
        final ClusterState updatedClusterState = applyUpdates(
        Snapshot target = snapshot(repoName, "target-snapshot");
        final Snapshot sourceSnapshot = snapshot(repoName, "source-snapshot");
        final SnapshotsInProgress.Entry cloneSingleShard = cloneEntry(
        final SnapshotsInProgress.Entry cloneMultipleShards = cloneEntry(
        final ClusterState stateWithIndex = stateWithUnassignedIndices(indexName);
    public void testRunReadyCloneCompletionListenerFailure() throws Exception {
    private static String uuid() {
            assertThat(completedClone.state(), is(SnapshotsInProgress.State.SUCCESS));
            clonesMap(shardId1, initShardStatus(dataNodeId))
        SnapshotId sourceSnapshot = new SnapshotId("source-snapshot", uuid());
        SnapshotsInProgress.ShardSnapshotStatus expectedStatus = new SnapshotsInProgress.ShardSnapshotStatus(
     */
        final ClusterState stateWithAssignedRoutingShard = ClusterState.builder(stateWithUnassignedRoutingShard)
     * but disabled for the specific index.
            ShardGenerations.EMPTY,
import org.opensearch.indices.RemoteStoreSettings;
        );
import org.opensearch.threadpool.ThreadPool;
        Repository mockRepository = mock(Repository.class);
        return new SnapshotsService.ShardSnapshotUpdate(snapshot, shardId, successfulShardStatus(nodeId));
        final IndexId indexId1 = indexId(indexName1);
import org.opensearch.common.settings.ClusterSettings;
        RepositoryShardId repoShardId = new RepositoryShardId(indexId("test-index"), 0);
 *
        final Snapshot sn1 = snapshot(repoName, "snapshot-1");
    public void testSnapshotV2AllowedForFullRemoteStoreIndex() {
        final String dataNodeId = uuid();
            RepositoryData.EMPTY_REPO_GEN,
            targetSnapshot,
import java.util.ArrayList;
            Collections.singletonMap(sourceSnapshot.getName(), sourceSnapshot),
     * Helper method to create a SnapshotsService instance with a provided ClusterService.
            .collect(Collectors.toList());
        final SnapshotsInProgress.Entry completedClone = snapshotsInProgress.entries().get(0);
        final ClusterState stateWithIndex = stateWithUnassignedIndices(indexName);
 */
        final IndexId indexId1 = indexId(indexName1);
        final SnapshotsInProgress snapshotsInProgress = updatedClusterState.custom(SnapshotsInProgress.TYPE);
        final SnapshotsInProgress snapshotsInProgress = updatedClusterState.custom(SnapshotsInProgress.TYPE);
        doAnswer(invocation -> {
        SnapshotId sourceSnapshot = new SnapshotId("source-snapshot", uuid());
    private SnapshotsService createSnapshotsService(ClusterService mockClusterService) {
        final SnapshotsInProgress.ShardSnapshotStatus shardInitStatus = initShardStatus(dataNodeId);
            Map.of(shardId1, shardInitStatus, shardId2, shardInitStatus)
            snapshotsService.runReadyClone(target, sourceSnapshot, shardStatusBefore, repoShardId, mockRepository, true);
        SnapshotsService.ShardSnapshotUpdate expectedUpdate = new SnapshotsService.ShardSnapshotUpdate(target, repoShardId, expectedStatus);
     * It verifies that:
     */
                eq(sourceSnapshot),
        String repoName = "test-repo";
        );
            assertThat(completedClone.state(), is(SnapshotsInProgress.State.SUCCESS));
    /**
            ActionListener<RepositoryData> listener = invocation.getArgument(0);
        final SnapshotsInProgress.Entry cloneSingleShard = cloneEntry(
        final String repoName = "test-repo";
            final Index idx = metaBuilder.get(index).getIndex();
            ShardGenerations.EMPTY,
        final ShardId routingShardId1 = new ShardId(stateWithIndex.metadata().index(indexName1).getIndex(), 0);
            completeShard
            verify(mockRepository).cloneRemoteStoreIndexShardSnapshot(
     * Tests the runReadyClone method when remote store index shallow copy is globally enabled,
    }
            randomBoolean(),
        doAnswer(invocation -> {
        String repoName = "test-repo";
        final Snapshot targetSnapshot = snapshot(repoName, "target-snapshot");
    private static SnapshotsInProgress.ShardSnapshotStatus successfulShardStatus(String nodeId) {
            return null;
        final SnapshotsService.ShardSnapshotUpdate completeShardClone = successUpdate(targetSnapshot, shardId1, clusterManagerNodeId);
        assertIsNoop(updatedClusterState, completeShard);
    }
        final Snapshot targetSnapshot = snapshot(repoName, "target-snapshot");
        String repoName = "test-repo";
            .build();
                IndexMetadata.builder(index)
 * license agreements. See the NOTICE file distributed with
        );
                                ).build()
        }
        verify(mockRepository).cloneRemoteStoreIndexShardSnapshot(
        return ClusterState.builder(state)
        return new SnapshotsInProgress.ShardSnapshotStatus(nodeId, SnapshotsInProgress.ShardState.SUCCESS, uuid());
        Snapshot snapshot,
            Collections.emptyMap(),
            RepositoryData.EMPTY_REPO_GEN,
    public void testRunReadyCloneWithRepositoryException() throws Exception {
        SnapshotId sourceSnapshot = new SnapshotId("source-snapshot", uuid());
        final SnapshotsInProgress.ShardSnapshotStatus shardSnapshotStatus = startedSnapshot.shards().get(routingShardId);
        }).when(mockRepository).cloneRemoteStoreIndexShardSnapshot(any(), any(), any(), any(), any(), any(ActionListener.class));
        assertIsNoop(updatedClusterState, completeShardClone);
import java.util.stream.StreamSupport;
     * Tests the runReadyClone method when remote store index shallow copy is disabled.
            eq(repoShardId),
        final ClusterState updatedClusterState = applyUpdates(stateWithSnapshots(snapshotSingleShard, cloneSingleShard), completeShard);
     * 2. getSnapshotIndexMetaData throws an IOException
        when(mockThreadPool.executor(ThreadPool.Names.SNAPSHOT)).thenReturn(OpenSearchExecutors.newDirectExecutorService());
            Collections.singletonMap(sourceSnapshot.getName(), sourceSnapshot),
    }
     * 1. getRepositoryData is called
        when(mockClusterService.localNode()).thenReturn(localNode);
        verify(mockClusterService).submitStateUpdateTask(eq("update snapshot state"), updateCaptor.capture(), any(), any(), any());
import static org.mockito.ArgumentMatchers.eq;
     */
                eq(shardStatusBefore.generation()),
        final String repoName = "test-repo";
     */
     * This method mocks all necessary dependencies for the SnapshotsService.
        return createSnapshotsService(mockClusterService);
    private static SnapshotsInProgress.Entry cloneEntry(
                false
    }
    public void testCompletedCloneStartsNextClone() throws Exception {
    }
        );
                successfulShardStatus(uuid())
import org.opensearch.test.OpenSearchTestCase;
            SnapshotsInProgress.ShardState.FAILED,
        return Map.of(shardId, shardStatus);
/*
        IllegalArgumentException e = expectThrows(
import org.opensearch.ExceptionsHelper;
        String repoName = "test-repo";
        final RepositoryShardId shardId1 = new RepositoryShardId(indexId1, 0);
    }
    /**
 * this file be licensed under the Apache-2.0 license or a
        DiscoveryNode localNode = new DiscoveryNode("local", buildNewFakeTransportAddress(), Version.CURRENT);
                RoutingTable.builder(stateWithUnassignedRoutingShard.routingTable())
    }
        final String repoName = "test-repo";
            return null;
                    .numberOfReplicas(0)
        final ShardId shardId2 = new ShardId(routingIndex1, 1);
            Settings.builder()
     * It verifies that:
                    .add(
import org.opensearch.repositories.ShardGenerations;
        final SnapshotsService.ShardSnapshotUpdate completeShard = successUpdate(targetSnapshot, shardId1, dataNodeId);
            sourceSnapshot.getSnapshotId(),
            verify(mockRepository, never()).cloneShardSnapshot(any(), any(), any(), any(), any());
    private static IndexId indexId(String name) {
        final Snapshot queuedTargetSnapshot = snapshot(repoName, "test-snapshot");
    public void testRunReadyCloneWithRemoteStoreIndexShallowCopyEnabled() throws Exception {
    ) {
        SnapshotId sourceSnapshot = new SnapshotId("source-snapshot", uuid());
        final SnapshotsInProgress.ShardSnapshotStatus shardInitStatus = initShardStatus(dataNodeId);
        Repository mockRepository = mock(Repository.class);
                    .numberOfShards(1)
 * this work for additional information regarding copyright
        final String clusterManagerNodeId = uuid();
                eq(repoShardId),
                "repoName__RSP6GLJfSO6SsMmUjZNAaA",
        SnapshotsService.validateNoSegmentsOnlyIndices(state, "test-repo", "snap-1");
        final SnapshotsInProgress.Entry queuedClone = cloneEntry(
        final Snapshot sn1 = snapshot(repoName, "snapshot-1");
 * The OpenSearch Contributors require contributions made to
        SnapshotsInProgress.ShardSnapshotStatus shardStatusBefore = initShardStatus(uuid());
import org.opensearch.cluster.node.DiscoveryNode;
        final String dataNodeId = uuid();
                            .addIndexShard(
        assertThat(cloneSingleShard.state(), is(SnapshotsInProgress.State.STARTED));
        SnapshotsInProgress.ShardSnapshotStatus shardStatusBefore = initShardStatus(uuid());
        IndexMetadata mockIndexMetadata = mock(IndexMetadata.class);
        final ShardId routingShardId = new ShardId(stateWithIndex.metadata().index(indexName).getIndex(), 0);
import org.opensearch.cluster.metadata.IndexMetadata;
                    )
     * 2. The correct failed ShardSnapshotUpdate is submitted to the cluster state
        String repoName = "test-repo";
        );
        doAnswer(invocation -> {
     */
        );
        assertThat(completedClone.state(), is(SnapshotsInProgress.State.SUCCESS));
    private static SnapshotsService.ShardSnapshotUpdate successUpdate(Snapshot snapshot, RepositoryShardId shardId, String nodeId) {
    ) {
                .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "segment-repo")
import static org.mockito.Mockito.when;
    /**
        verify(mockRepository).cloneRemoteStoreIndexShardSnapshot(
                                new IndexShardRoutingTable.Builder(routingShardId1).addShard(
            final ClusterState updatedClusterState = applyUpdates(stateWithInitializingRoutingShard, completeShardClone);
            assertThat(startedSnapshot.state(), is(SnapshotsInProgress.State.STARTED));
            any()
            localNode.getId(),
            Arrays.asList("OouZCQ30TqypFBZGgk1C7g", "RSP6GLJfSO6SsMmUjZNAaA", "OstrHGrERqaR__-597zHYQ, Zjlnf8IHRxqFBijj0m52gw")
        final RepositoryShardId repositoryShardId = new RepositoryShardId(indexId1, 0);
import java.util.List;
import org.opensearch.cluster.routing.ShardRoutingState;
        );
import org.opensearch.repositories.RepositoryShardId;
        }).when(mockRepository).getRepositoryData(any(ActionListener.class));
            .build();
        ThreadPool mockThreadPool = mock(ThreadPool.class);
        doAnswer(invocation -> {
            clonesMap(shardId1, shardInitStatus)
     */
            .putCustom(SnapshotsInProgress.TYPE, SnapshotsInProgress.of(Arrays.asList(entries)))
            )
    }
            final SnapshotsService.ShardSnapshotUpdate shardCompletion = new SnapshotsService.ShardSnapshotUpdate(
        final SnapshotsService.ShardSnapshotUpdate completeShard = successUpdate(targetSnapshot, shardId1, dataNodeId);
    }
     * 2. Neither cloneShardSnapshot nor cloneRemoteStoreIndexShardSnapshot are called
            any(),
import org.opensearch.action.support.ActionFilters;
        return new IndexId(name, uuid());
            .build();
        final Snapshot snapshot = snapshot(repoName, "snapshot-1");
        try (SnapshotsService snapshotsService = createSnapshotsService()) {
        final SnapshotsInProgress.Entry snapshotSingleShard = snapshotEntry(
/*
    }
    private static ClusterState applyUpdates(ClusterState state, SnapshotsService.ShardSnapshotUpdate... updates) throws Exception {
        RepositoryData repositoryData = new RepositoryData(
    ) {
     * It verifies that:
                eq(repoShardId),
    public void testUpdateSnapshotMultipleShards() throws Exception {
            plainSnapshot,
        // 3. case: shard that just finished cloning is currently initializing -> shard snapshot should go to WAITING state
                                ).build()
        DiscoveryNode localNode = new DiscoveryNode("local", buildNewFakeTransportAddress(), Version.CURRENT);
        assertIsNoop(updatedClusterState, completeShard);
        IndexMetadata mockIndexMetadata = mock(IndexMetadata.class);
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import org.opensearch.core.action.ActionListener;
        IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
        Snapshot target = snapshot(repoName, "target-snapshot");
import org.opensearch.repositories.RepositoryException;
            .version(state.version() + 1L)
import org.opensearch.repositories.RepositoryData;
            assertThat(startedSnapshot.shards().get(routingShardId1).state(), is(SnapshotsInProgress.ShardState.WAITING));
            .settings(indexSettings.put(SETTING_VERSION_CREATED, Version.CURRENT))
        );
        final String repoName = "test-repo";
 * KIND, either express or implied.  See the License for the
            // Verify that cloneRemoteStoreIndexShardSnapshot was called with the correct arguments
    }
        when(mockRepository.getSnapshotIndexMetaData(eq(repositoryData), eq(sourceSnapshot), any())).thenReturn(mockIndexMetadata);
 * the Apache License, Version 2.0 (the "License"); you may
        final ClusterState updatedClusterState = applyUpdates(stateWithSnapshots(snapshotSingleShard), completeShard);
     * so snapshot-v2 must be refused rather than succeeding and failing later at restore time.
        final ShardId routingShardId = new ShardId(stateWithIndex.metadata().index(indexName).getIndex(), 0);
        );
        );
            mockClusterService,
                                    TestShardRouting.newShardRouting(routingShardId1, dataNodeId, true, ShardRoutingState.STARTED)
            );
            );
        final SnapshotsInProgress.Entry snapshotSingleShard = snapshotEntry(
        ClusterState state = clusterStateWithIndex(
     * 2. cloneRemoteStoreIndexShardSnapshot is called with the correct parameters
     * This test simulates a scenario where the index has remote store enabled.
            () -> SnapshotsService.validateNoSegmentsOnlyIndices(state, "test-repo", "snap-1")
        ArgumentCaptor<SnapshotsService.ShardSnapshotUpdate> updateCaptor = ArgumentCaptor.forClass(
        }
            Collections.emptyMap(),
    }
            // Verify that getRepositoryData was called
    private static SnapshotsService.ShardSnapshotUpdate successUpdate(Snapshot snapshot, ShardId shardId, String nodeId) {
            // Verify that neither cloneShardSnapshot nor cloneRemoteStoreIndexShardSnapshot were called
        return new Snapshot(repoName, new SnapshotId(name, uuid()));
        assertThat(updatedSnapshot1.state(), is(SnapshotsInProgress.State.STARTED));
        when(mockRepository.getSnapshotIndexMetaData(eq(repositoryData), eq(sourceSnapshot), any())).thenReturn(mockIndexMetadata);
        return new SnapshotsInProgress.ShardSnapshotStatus(nodeId, uuid());
     * 1. getRepositoryData is called
            listener.onResponse(newGeneration);
import static org.opensearch.snapshots.SnapshotsService.getRepoSnapshotUUIDTuple;
        final RepositoryShardId shardId1 = new RepositoryShardId(indexId1, 0);
        final IndexId indexId1 = indexId(indexName1);
            // Verify that getRepositoryData was called
    /**
        );
        Snapshot target = snapshot(repoName, "target-snapshot");
                any(),
    private static ClusterState stateWithSnapshots(SnapshotsInProgress.Entry... entries) {
            shardsMap(routingShardId1, SnapshotsInProgress.ShardSnapshotStatus.UNASSIGNED_QUEUED)
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_CREATED;
        Repository mockRepository = mock(Repository.class);
                    .settings(Settings.builder().put(SETTING_VERSION_CREATED, Version.CURRENT.id))
import org.opensearch.cluster.routing.RoutingTable;
import org.opensearch.cluster.node.DiscoveryNodes;
            assertIsNoop(updatedClusterState, completeShardClone);
            Arrays.asList(
            "segments-only-idx",
    public void testIsOrphanPinnedEntity() {
        SnapshotsInProgress.ShardSnapshotStatus expectedStatus = new SnapshotsInProgress.ShardSnapshotStatus(
            ActionListener<String> listener = invocation.getArgument(5);
        final String dataNodeId = uuid();
            Collections.singletonList(indexId1),
            stateWithSnapshots(snapshotSingleShard, queuedSnapshotSingleShard),
        RepositoryShardId repoShardId = new RepositoryShardId(indexId("test-index"), 0);
        final String indexName = "index-1";
        final ClusterState stateWithInitializingRoutingShard = ClusterState.builder(stateWithUnassignedRoutingShard)
        assertThat(completedClone.state(), is(SnapshotsInProgress.State.SUCCESS));
            shardsMap(routingShardId, SnapshotsInProgress.ShardSnapshotStatus.UNASSIGNED_QUEUED)
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
import static org.mockito.ArgumentMatchers.any;
            shardsMap(routingShardId, initShardStatus(dataNodeId))
import org.opensearch.cluster.service.ClusterService;
        final SnapshotsInProgress.Entry snapshotSingleShard = snapshotEntry(
            Collections.emptyMap(),
        final String repoName = "test-repo";
        assertThat(completedSnapshot.state(), is(SnapshotsInProgress.State.SUCCESS));
        ClusterService mockClusterService = mock(ClusterService.class);
            ClusterState.builder(ClusterState.EMPTY_STATE).nodes(discoveryNodes(clusterManagerNodeId)).build(),
        }).when(mockRepository).getRepositoryData(any(ActionListener.class));
 * ownership. Elasticsearch licenses this file to you under
            final ClusterState state = stateWithSnapshots(snapshotNoShards);
    /**
        assertThat(updatedSnapshot1.state(), is(SnapshotsInProgress.State.SUCCESS));
    private static SnapshotsInProgress.Entry snapshotEntry(
        assertThat(updatedSnapshot1.state(), is(SnapshotsInProgress.State.SUCCESS));
        );
            Collections.emptyMap(),
            targetSnapshot,
            randomNonNegativeLong(),
    public void testSnapshotV2AllowedForNonRemoteStoreIndex() {
        final List<IndexId> indexIds = StreamSupport.stream(clones.keySet().spliterator(), false)
            assertThat(shardSnapshotStatus.state(), is(SnapshotsInProgress.ShardState.INIT));
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                        IndexRoutingTable.builder(routingShardId1.getIndex())
import java.util.Map;
        Repository mockRepository = mock(Repository.class);
        when(mockClusterService.localNode()).thenReturn(localNode);
            eq(target.getSnapshotId()),
        }
            Collections.emptyMap(),
                .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "segment-repo")
                eq(shardStatusBefore.generation()),
    private static Snapshot snapshot(String repoName, String name) {
        return new SnapshotsService.ShardSnapshotUpdate(snapshot, shardId, successfulShardStatus(nodeId));
        RepositoryShardId repoShardId = new RepositoryShardId(indexId("test-index"), 0);
        verify(mockRepository).getRepositoryData(any(ActionListener.class));
    }
     */
        List<IndexId> indexIds,
        final String indexName = "index-1";
        for (String index : indexNames) {
                any()
    }
            snapshot,
        final Snapshot targetSnapshot = snapshot(repoName, "target-snapshot");
        Exception testException = new RuntimeException("Test exception");
            any()
        String orphanEntity = "repoName__orphan";
        }
        final String repoName = "test-repo";
            SnapshotsService.ShardSnapshotUpdate.class
            IllegalArgumentException.class,
import static org.hamcrest.Matchers.is;
    }
            cloneSingleShard,
    }
        }
        doAnswer(invocation -> {
            mock(RemoteStoreSettings.class),
        );
        assertThat(cloneSingleShard.state(), is(SnapshotsInProgress.State.STARTED));
                            )
                successfulShardStatus(uuid())
import static org.hamcrest.Matchers.containsString;
            verify(mockRepository, never()).cloneRemoteStoreIndexShardSnapshot(any(), any(), any(), any(), any(), any());
        assertThat(startedSnapshot.state(), is(SnapshotsInProgress.State.STARTED));
            eq(shardStatusBefore.generation()),
        final SnapshotsInProgress snapshotsInProgress = updatedClusterState.custom(SnapshotsInProgress.TYPE);
                eq(repoShardId),
        return SnapshotsInProgress.startedEntry(
            "full-remote-idx",
        IndexMetadata mockIndexMetadata = mock(IndexMetadata.class);
            shardsMap(shardId1, initShardStatus(dataNodeId))
    /**
            verify(mockRepository).getSnapshotIndexMetaData(eq(repositoryData), eq(sourceSnapshot), any());
            Collections.singletonList(indexId1),
        Repository mockRepository = mock(Repository.class);
            mockTransportService,
            false
     * 3. Neither cloneShardSnapshot nor cloneRemoteStoreIndexShardSnapshot are called
        // Mock the getRepositoryData method to throw an exception
                .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
            ActionListener<RepositoryData> listener = invocation.getArgument(0);
        );
        }
        );
        final String repoName = "test-repo";
        RepositoryData repositoryData = new RepositoryData(
    /**
import java.util.Arrays;
        final SnapshotsInProgress.Entry updatedSnapshot1 = snapshotsInProgress.entries().get(0);
import org.opensearch.core.index.shard.ShardId;
            sourceSnapshot.getSnapshotId(),
 * Unless required by applicable law or agreed to in writing,
            Collections.emptyList(),
        snapshotsService.runReadyClone(target, sourceSnapshot, shardStatusBefore, repoShardId, mockRepository, true);
    public void testSnapshotV2RejectedForSegmentsOnlyIndex() {
import org.opensearch.repositories.IndexMetaDataGenerations;
            IndexMetaDataGenerations.EMPTY
        final Snapshot sourceSnapshot = snapshot(repoName, "source-snapshot");
            Collections.emptyMap(),
            final SnapshotsInProgress.Entry completedClone = snapshotsInProgress.entries().get(0);
            assertIsNoop(updatedClusterState, completeShardClone);
            queuedTargetSnapshot,
        String repoName = "test-repo";
        final String dataNodeId = uuid();
            new IOException("Test IO Exception")
import org.mockito.ArgumentCaptor;
        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .routingTable(
            .numberOfShards(1)
            mockRepoService,
            clonesMap(repositoryShardId, SnapshotsInProgress.ShardSnapshotStatus.UNASSIGNED_QUEUED)
     */
        final SnapshotsInProgress.Entry startedSnapshot = snapshotsInProgress.entries().get(1);
        when(mockClusterService.localNode()).thenReturn(localNode);
        final SnapshotsInProgress.Entry startedSnapshot = snapshotsInProgress.entries().get(1);
            ShardGenerations.EMPTY,
    }
            final SnapshotsInProgress.ShardSnapshotStatus shardSnapshotStatus = startedSnapshot.shards().get(routingShardId1);
        Settings mockSettings = Settings.builder().put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true).build();
import org.opensearch.common.collect.Tuple;
            RepositoryData.EMPTY_REPO_GEN,
        doAnswer(invocation -> {
     * 1. The clone operation fails with an exception
     * Tests the runReadyClone method when remote store index shallow copy is enabled.
        SnapshotId sourceSnapshot = new SnapshotId("source-snapshot", uuid());
            );
            return null;
import org.opensearch.cluster.routing.IndexRoutingTable;
        ArrayList<String> snapshotUUIDs = new ArrayList<>(
    }
        assertEquals(expectedUpdate.hashCode(), capturedUpdate.hashCode());
/*
            snapshotsService.runReadyClone(target, sourceSnapshot, shardStatusBefore, repoShardId, mockRepository, true);
        assertThat(cloneSingleShard.state(), is(SnapshotsInProgress.State.STARTED));
 *
    private static DiscoveryNodes discoveryNodes(String localNodeId) {
        assertIsNoop(updatedClusterState, completeShard);
     * Tests the error handling in runReadyClone when a RepositoryException occurs.
            Collections.singletonList(indexId1),
    }
        TransportService mockTransportService = mock(TransportService.class);
        final Snapshot sourceSnapshot = snapshot(repoName, "source-snapshot");
            return null;
            randomBoolean(),
        final String indexName1 = "index-1";
            .numberOfReplicas(1)
        final SnapshotsInProgress.Entry snapshotSingleShard = snapshotEntry(
            Collections.emptyMap(),
            return null;
     * 2. cloneShardSnapshot is called with the correct parameters
            verify(mockRepository).cloneShardSnapshot(
                eq(target.getSnapshotId()),
        assertThat(shardCloneStatus.nodeId(), is(updatedClusterState.nodes().getLocalNodeId()));
        final ClusterState stateWithUnassignedRoutingShard = stateWithSnapshots(stateWithIndex, cloneSingleShard, snapshotSingleShard);
            assertIsNoop(state, shardCompletion);
 * SPDX-License-Identifier: Apache-2.0
                    .add(
            plainSnapshot,
        when(mockRepository.getSnapshotIndexMetaData(eq(repositoryData), eq(sourceSnapshot), any())).thenReturn(mockIndexMetadata);
     * Helper method to create a SnapshotsService instance with a mocked ClusterService.
        );
            assertThat(startedSnapshot.shards().get(routingShardId1).state(), is(SnapshotsInProgress.ShardState.MISSING));
            RepositoryData.EMPTY_REPO_GEN,
        SnapshotId source,
        final SnapshotsService.ShardSnapshotUpdate completeShard = successUpdate(sn1, shardId1, dataNodeId);
        final String indexName1 = "index-1";
 * Licensed to Elasticsearch under one or more contributor
                                new IndexShardRoutingTable.Builder(routingShardId1).addShard(
        return new Index(name, uuid());
            Collections.emptyMap(),
        IndexMetadata mockIndexMetadata = mock(IndexMetadata.class);
    }
                            .addIndexShard(
import org.opensearch.repositories.IndexId;
        return SnapshotsService.SHARD_STATE_EXECUTOR.execute(state, Arrays.asList(updates)).resultingState;
        ClusterState state = clusterStateWithIndex(
            IndexMetaDataGenerations.EMPTY
        SnapshotsService.ShardSnapshotUpdate capturedUpdate = updateCaptor.getValue();
        final String indexName1 = "index-1";
        return stateWithSnapshots(ClusterState.builder(ClusterState.EMPTY_STATE).nodes(discoveryNodes(uuid())).build(), entries);
        );
    public void testRunReadyCloneWithIOException() throws Exception {
        final Snapshot queuedSnapshot = snapshot(repoName, "test-snapshot-2");
            Collections.singletonMap(sourceSnapshot.getName(), sourceSnapshot),
        );
        );
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
            listener.onResponse(repositoryData);
    /**
        assertThat(shardSnapshotStatus.state(), is(SnapshotsInProgress.ShardState.INIT));
    }
            queuedClone
    private static void assertIsNoop(ClusterState state, SnapshotsService.ShardSnapshotUpdate shardCompletion) throws Exception {
                "repoName__OouZCQ30TqypFBZGgk1C7g",
            ShardGenerations.EMPTY,
        assertEquals(repoName, t.v1());
            final ClusterState state = stateWithSnapshots(
        assertThat(e.getMessage(), containsString("snapshot-v2 is not supported"));
        SnapshotsService.validateNoSegmentsOnlyIndices(state, "test-repo", "snap-1");
        assertIsNoop(updatedClusterState, completeShard);
        final SnapshotsInProgress.Entry snapshotNoShards = snapshotEntry(snapshot, Collections.emptyList(), Map.of());
    public void testRunReadyCloneWithRemoteStoreIndexShallowCopyEnabledButIndexDisabled() throws Exception {
