                checkpoint.getCodec(),
import static org.mockito.Mockito.mock;
import org.opensearch.indices.replication.checkpoint.MergedSegmentCheckpoint;
    public void testGetMergedSegmentFiles() throws IOException, ExecutionException, InterruptedException {
    }
        };
import java.util.Collections;
                    .getSegmentsUploadedToRemoteStore();
    public void testGetSegmentFilesAlreadyExists() throws IOException, InterruptedException {
                checkpoint.getMetadataMap(),
        when(mockShard.getLatestReplicationCheckpoint()).thenReturn(replicaShard.getLatestReplicationCheckpoint());
        final PlainActionFuture<CheckpointInfoResponse> res3 = PlainActionFuture.newFuture();
    public void testGetMergedSegmentFilesDownloadTimeout() throws IOException, ExecutionException, InterruptedException {
        // Ensure the mock returns the expected checkpoint when getLatestReplicationCheckpoint is called.
            } catch (Exception e) {
                assertBusy(() -> {
import org.apache.lucene.store.FilterDirectory;
        latch.await();
        Store remoteStore = mock(Store.class);
                    if (segment.startsWith("segments_") == false) put(segment, metadata.getUploadedFilename());
        assertNotNull("onFailure should have been called", failureRef.get());
        assertTrue(observedException.getMessage() != null && observedException.getMessage().startsWith("invalid."));
import static org.mockito.Mockito.spy;
        // Additional test for non-search-only replica (should fail with exception)
        replicaShard = newStartedShard(false, settings, new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()));
        replicationSource = new RemoteStoreReplicationSource(mockShard);
            REPLICATION_ID,
        replicationSource = new RemoteStoreReplicationSource(primaryShard);
                checkpoint.getCodec(),
                checkpoint.getSegmentInfosVersion(),
                checkpoint.getMetadataMap(),
            res
        // Reuse real shard's remote store wiring so the ReplicationSource ctor succeeds.
                replicaShard.shardId(),
import org.opensearch.index.replication.OpenSearchIndexLevelReplicationTestCase;
        assertTrue(response.files.containsAll(filesToFetch));
        replicationSource = new RemoteStoreReplicationSource(primaryShard);
            new StoreFileMetadata("invalid.si", 1, "1", Version.LATEST),
        final ReplicationCheckpoint checkpoint = primaryShard.getLatestReplicationCheckpoint();
                primaryShard,
            new StoreFileMetadata("invalid.cfs", 1, "1", Version.LATEST)
        List<StoreFileMetadata> filesToFetch = primaryShard.getSegmentMetadataMap().values().stream().collect(Collectors.toList());
        primaryShard.refresh("test");
        final PlainActionFuture<CheckpointInfoResponse> res = PlainActionFuture.newFuture();
        });
    public void testGetSegmentFilesReturnEmptyResponse() throws ExecutionException, InterruptedException {
                latch.countDown();
     * when the shard returns a non-{@code SegmentInfosCatalogSnapshot}, the source must
                checkpoint.getSegmentInfosVersion(),
        assertEquals(response.files.size(), filesToFetch.size());
                fail("Expected onFailure to be called");
        final PlainActionFuture<CheckpointInfoResponse> res = PlainActionFuture.newFuture();
        final PlainActionFuture<GetSegmentFilesResponse> res = PlainActionFuture.newFuture();
    @Override
        }
    private final Settings settings = Settings.builder()
        );
import org.opensearch.indices.replication.common.ReplicationType;
    public void testGetCheckpointMetadataFailure() {
            (RemoteSegmentStoreDirectory) ((FilterDirectory) ((FilterDirectory) indexShard.remoteStore().directory()).getDelegate())
        replicationSource.getSegmentFiles(
                checkpoint.getMetadataMap(),
        assert (response.files.isEmpty());
            public void onFailure(Exception e) {
                latch.countDown();
    public void testGetCheckpointMetadataEmpty() throws ExecutionException, InterruptedException {
        final ReplicationCheckpoint checkpoint = primaryShard.getLatestReplicationCheckpoint();
            res.get();
 * SPDX-License-Identifier: Apache-2.0
        Map<String, String> localToRemoteFilenameMap = Map.of("invalid.si", "invalid.si__uuid", "invalid.cfs", "invalid.cfs__uuid");
        };
            }
            localToRemoteFilenameMap
        List<StoreFileMetadata> filesToFetch = List.of(
            listener
        assertTrue(response.getCheckpoint().equals(checkpoint));
        final ReplicationCheckpoint checkpoint = replicaShard.getLatestReplicationCheckpoint();
            @Override
        .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
            mergedSegmentCheckpoint,
                        closeShard(shard, true);
                REPLICATION_ID,
                });
        when(mockShard.getCatalogSnapshot()).thenThrow(new RuntimeException("test"));
import org.opensearch.index.engine.NRTReplicationEngineFactory;
import org.opensearch.cluster.routing.ShardRouting;
        replicaShard.getRemoteDirectory().markMergedSegmentsPendingDownload(localToRemoteFilenameMap);
                    }
                "_0"
            );
    public void testGetMergedSegmentFilesFailure() throws IOException, ExecutionException, InterruptedException {
    private void closeShardsWithRetry(IndexShard... shards) {
        final ReplicationCheckpoint checkpoint = primaryShard.getLatestReplicationCheckpoint();
            AtomicInteger retry = new AtomicInteger(1);
        CheckpointInfoResponse response = res.get();
        final ReplicationCheckpoint checkpoint = primaryShard.getLatestReplicationCheckpoint();
            new MergedSegmentCheckpoint(
        ExecutionException exception = assertThrows(ExecutionException.class, () -> res3.get());
                replicaShard.shardId(),
import org.opensearch.index.store.RemoteSegmentStoreDirectory;
            primaryShard,
        // Not-started + null metadata path returns empty response. The key is that this path
        Map<String, String> localToRemoteFilenameMap = new HashMap<>() {
    }
import static org.mockito.Mockito.when;
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
                Map<String, UploadedSegmentMetadata> segmentsUploadedToRemoteStore = primaryShard.getRemoteDirectory()
        buildIndexShardBehavior(mockShard, replicaShard);
 *
import org.opensearch.core.action.ActionListener;
            filesToFetch,
        // Override the catalog snapshot with a non-SegmentInfos (DFA-style) stub.
        assertThrows(RuntimeException.class, () -> {
    private static final long REPLICATION_ID = 123L;
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
            @Override
                "_0"
        when(mockShard.getCatalogSnapshot()).thenReturn(indexShard.getCatalogSnapshot());
            (fileName, bytesRecovered) -> {},
        MockCatalogSnapshot dfa = new MockCatalogSnapshot(1L, List.of(), new MockDataFormat("parquet", 0L, Set.of()));
        IndexShard mockShard = mock(IndexShard.class);
            replicaShard,
                .getDelegate();
        when(mockRecoverySettings.getMergedSegmentReplicationTimeout()).thenReturn(TimeValue.ZERO);
            public void onResponse(GetSegmentFilesResponse response) {
                res
import org.opensearch.action.support.PlainActionFuture;
        super.setUp();
        .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "my-repo")
        RemoteStoreMergedSegmentCheckpoint mergedSegmentCheckpoint = new RemoteStoreMergedSegmentCheckpoint(
                "_0"
                (fileName, bytesRecovered) -> {},
            REPLICATION_ID,
                    } catch (RuntimeException e) {
import java.util.Set;
            public void onFailure(Exception e) {
        when(remoteStore.directory()).thenReturn(remoteStoreFilterDirectory);
        );
            checkpoint,
                        throw new AssertionError("Failed to close shard", e);
        // For a RECOVERING shard, the response should have an empty metadata map.
            {
            observedException.getMessage() != null
    }
    }
            ),
        .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
    public void tearDown() throws Exception {
                    .getSegmentsUploadedToRemoteStore();
import java.util.stream.Collectors;
            mergedSegmentCheckpoint,
        closeShardsWithRetry(primaryShard, replicaShard);
    }
            {
                Map<String, UploadedSegmentMetadata> segmentsUploadedToRemoteStore = primaryShard.getRemoteDirectory()
    private RemoteStoreReplicationSource replicationSource;
        IndexShard mockShard = mock(IndexShard.class);
        assertTrue(response.getMetadataMap().isEmpty());
            new MergedSegmentCheckpoint(
            assertTrue(ex instanceof AssertionError);
import org.opensearch.indices.recovery.RecoverySettings;
        Map<String, String> localToRemoteFilenameMap = new HashMap<>() {
            ),
 */
    }
        );
            }
            final PlainActionFuture<CheckpointInfoResponse> res = PlainActionFuture.newFuture();
        replicationSource.getMergedSegmentFiles(
     * Covers the DFA branch in {@link RemoteStoreReplicationSource#getCheckpointMetadata}:
        .build();
        );
/*
            new MergedSegmentCheckpoint(
        Exception observedException = failureRef.get();
        final ReplicationCheckpoint checkpoint = primaryShard.getLatestReplicationCheckpoint();
                failureRef.set(e);
import java.util.concurrent.TimeoutException;
        indexDoc(primaryShard, "_doc", "2");
                checkpoint.getLength(),
        RemoteSegmentStoreDirectory remoteSegmentStoreDirectory =
        );
        List<StoreFileMetadata> filesToFetch = new ArrayList<>(primaryShard.getSegmentMetadataMap().values());
        IndexShard replica = spy(replicaShard);
            mergedSegmentCheckpoint,
import org.opensearch.index.engine.InternalEngineFactory;
                filesToFetch,
                checkpoint,
            }
            }
        AtomicReference<Exception> failureRef = new AtomicReference<>();
                logger.warn("Unable to close shard " + shardId + ". Exception: " + e);
import java.util.HashMap;
    }
        replicationSource.getCheckpointMetadata(REPLICATION_ID, checkpoint, res2);
        assertTrue(response.files.containsAll(filesToFetch));
        buildIndexShardBehavior(mockShard, replicaShard);
            filesToFetch,
import org.opensearch.common.concurrent.GatedCloseable;
        when(mockShard.remoteStore()).thenReturn(remoteStore);
            assertTrue(ex.getMessage().startsWith("Local store already contains the file"));
import java.util.concurrent.atomic.AtomicInteger;
        replicationSource.getSegmentFiles(REPLICATION_ID, checkpoint, filesToFetch, replicaShard, (fileName, bytesRecovered) -> {}, res);
                primaryTerm,
    /**
        latch.await();
                });
        GetSegmentFilesResponse response = res.get();
        when(replica.getRecoverySettings()).thenReturn(mockRecoverySettings);
        assertTrue(response.getMetadataMap().isEmpty());
        AtomicReference<Exception> failureRef = new AtomicReference<>();
    public void testGetSegmentFiles() throws ExecutionException, InterruptedException, IOException {
import org.opensearch.index.store.StoreFileMetadata;
            replicationSource.getCheckpointMetadata(REPLICATION_ID, checkpoint, res);
        assert (response.getMetadataMap().isEmpty() == false);
        // Testing failure scenario where segments are not a part of RemoteSegmentStoreDirectory.pendingMergedSegmentsDownloads
     */
        replicationSource.getMergedSegmentFiles(
                    try {
        GetSegmentFilesResponse response = res.get();
            }
        // is reached without the DFA-snapshot branch throwing ClassCastException.
                && observedException.getMessage().equals("Timed out waiting for merged segments download from remote store")
        when(mockShard.routingEntry()).thenReturn(mockRouting);
import java.util.concurrent.atomic.AtomicReference;
        assertEquals(response.files.size(), filesToFetch.size());
        latch.await();
     * resolve {@code Version.LATEST} and continue without throwing {@code ClassCastException}.
            (fileName, bytesRecovered) -> {},
        );
    public void testGetCheckpointMetadataWithNonSegmentInfosCatalogSnapshot() throws Exception {
        // For a STARTED shard, the new behavior needs mock routing entry
        replicationSource = new RemoteStoreReplicationSource(primaryShard);
        FilterDirectory remoteStoreFilterDirectory = new TestFilterDirectory(new TestFilterDirectory(remoteSegmentStoreDirectory));
        for (IndexShard shard : shards) {
        final PlainActionFuture<GetSegmentFilesResponse> res = PlainActionFuture.newFuture();
import org.opensearch.index.shard.IndexShardState;
                fail("Expected onFailure to be called");
import org.opensearch.common.unit.TimeValue;
                failureRef.set(e);
                checkpoint.getCodec(),
import java.util.concurrent.CountDownLatch;
    }
        assertNotNull("onFailure should have been called", failureRef.get());
                });
            filesToFetch,
        indexDoc(primaryShard, "_doc", "1");
    }
        super.tearDown();
    private IndexShard replicaShard;
            res
        List<StoreFileMetadata> filesToFetch = primaryShard.getSegmentMetadataMap().values().stream().collect(Collectors.toList());
            }
import java.util.concurrent.ExecutionException;
        RecoverySettings mockRecoverySettings = mock(RecoverySettings.class);
        try {
        replicationSource = new RemoteStoreReplicationSource(mockShard);
        assertNotNull(response);
        replicationSource.getMergedSegmentFiles(
        ActionListener<GetSegmentFilesResponse> listener = new ActionListener<>() {
                segmentsUploadedToRemoteStore.forEach((segment, metadata) -> {
        CountDownLatch latch = new CountDownLatch(1);
        // Build mockShard to return replicaShard directory so that an empty metadata file is returned.
                checkpoint.getLength(),
        RemoteStoreMergedSegmentCheckpoint mergedSegmentCheckpoint = new RemoteStoreMergedSegmentCheckpoint(
    }
        when(mockShard.getCatalogSnapshot()).thenReturn(new GatedCloseable<>(dfa, () -> {}));
import java.nio.file.NoSuchFileException;
        when(mockRouting.isSearchOnly()).thenReturn(false);
        CheckpointInfoResponse response = res.get();
import org.opensearch.index.engine.dataformat.stub.MockCatalogSnapshot;
            public void onResponse(GetSegmentFilesResponse response) {
                segmentsUploadedToRemoteStore.forEach((segment, metadata) -> {
        replicationSource.getCheckpointMetadata(REPLICATION_ID, checkpoint, res);
        assertTrue(response2.getCheckpoint().equals(replicaShard.getLatestReplicationCheckpoint()));
import java.util.Map;
        primaryShard = newStartedShard(true, settings, new EngineBackedIndexerFactory(new InternalEngineFactory()));
            res.get();
        final ReplicationCheckpoint checkpoint = primaryShard.getLatestReplicationCheckpoint();
        assertTrue(exception.getCause().getMessage().contains("Remote metadata file can't be null if shard is active"));
            REPLICATION_ID,
        replicationSource = new RemoteStoreReplicationSource(primaryShard);
        assertTrue(observedException instanceof TimeoutException);
            Collections.emptyList(),
            replicaShard,
            localToRemoteFilenameMap
import org.opensearch.indices.replication.checkpoint.RemoteStoreMergedSegmentCheckpoint;
        assertTrue(exception.getCause() instanceof IllegalStateException);
        CountDownLatch latch = new CountDownLatch(1);
        when(mockRouting.isSearchOnly()).thenReturn(true); // Make it a search-only replica
            latch.countDown();
        replicaShard.getRemoteDirectory().markMergedSegmentsPendingDownload(localToRemoteFilenameMap);
                checkpoint.getSegmentInfosVersion(),
        GetSegmentFilesResponse response = res.get();
 * this file be licensed under the Apache-2.0 license or a
        replicationSource.getCheckpointMetadata(REPLICATION_ID, checkpoint, res);
            final PlainActionFuture<GetSegmentFilesResponse> res = PlainActionFuture.newFuture();
        CountDownLatch latch = new CountDownLatch(1);
            localToRemoteFilenameMap
        when(mockShard.state()).thenReturn(IndexShardState.RECOVERING);
        RemoteStoreMergedSegmentCheckpoint mergedSegmentCheckpoint = new RemoteStoreMergedSegmentCheckpoint(
                        logger.info("Trying to close " + shardId + " try: " + retry.getAndIncrement());
            replicationSource = new RemoteStoreReplicationSource(primaryShard);
        };
        assertTrue(observedException instanceof NoSuchFileException);
            listener
            (fileName, bytesRecovered) -> {},
        final PlainActionFuture<GetSegmentFilesResponse> res = PlainActionFuture.newFuture();
                checkpoint.getLength(),
            ),
package org.opensearch.indices.replication;
        replicationSource = new RemoteStoreReplicationSource(primaryShard);
        final ReplicationCheckpoint checkpoint = primaryShard.getLatestReplicationCheckpoint();
        replicationSource.getCheckpointMetadata(REPLICATION_ID, checkpoint, res);
}
        replicationSource.getCheckpointMetadata(REPLICATION_ID, checkpoint, res3);
        };
                replicaShard.shardId(),
import java.util.List;
    }
        );
    }
            String shardId = shard.shardId().toString() + (shard.isPrimaryMode() ? "[p]" : "[r]");
            replicationSource.getSegmentFiles(
            try {
        final PlainActionFuture<CheckpointInfoResponse> res2 = PlainActionFuture.newFuture();
            @Override
        final ReplicationCheckpoint checkpoint = primaryShard.getLatestReplicationCheckpoint();
        CheckpointInfoResponse response = res.get();
        assertTrue(response2.getMetadataMap().isEmpty());
import org.opensearch.cluster.metadata.IndexMetadata;
import java.util.ArrayList;
    }
        ShardRouting mockRouting = mock(ShardRouting.class);
        assert (response.getCheckpoint().equals(checkpoint));
        final ReplicationCheckpoint checkpoint = primaryShard.getLatestReplicationCheckpoint();
        IndexShard mockShard = mock(IndexShard.class);
        Exception observedException = failureRef.get();
            replica,
        } catch (AssertionError | ExecutionException ex) {
        when(mockShard.state()).thenReturn(IndexShardState.STARTED);
 * The OpenSearch Contributors require contributions made to
import org.opensearch.index.shard.IndexShard;
        List<StoreFileMetadata> filesToFetch = new ArrayList<>(primaryShard.getSegmentMetadataMap().values());
    private void buildIndexShardBehavior(IndexShard mockShard, IndexShard indexShard) {
    @Override
            @Override
    }
import org.opensearch.index.store.Store;
        final PlainActionFuture<CheckpointInfoResponse> res = PlainActionFuture.newFuture();
        assertTrue(
        ActionListener<GetSegmentFilesResponse> listener = new ActionListener<>() {
import org.apache.lucene.util.Version;
        .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "my-repo")
        );
        replicationSource = new RemoteStoreReplicationSource(primaryShard);
import org.opensearch.index.engine.dataformat.stub.MockDataFormat;
            }
            (fileName, bytesRecovered) -> {},
import org.opensearch.index.shard.RemoteStoreRefreshListenerTests.TestFilterDirectory;
                primaryTerm,
        CheckpointInfoResponse response2 = res2.get();
            replicationSource = new RemoteStoreReplicationSource(mockShard);
        when(mockShard.state()).thenReturn(IndexShardState.RECOVERING);
        closeShards(replicaShard);
import java.io.IOException;
public class RemoteStoreReplicationSourceTests extends OpenSearchIndexLevelReplicationTestCase {
            REPLICATION_ID,
 * compatible open source license.
import org.opensearch.index.store.RemoteSegmentStoreDirectory.UploadedSegmentMetadata;
    public void testGetCheckpointMetadata() throws ExecutionException, InterruptedException {
import org.opensearch.common.settings.Settings;
        // Mock a routing entry for the search-only condition
                    if (segment.startsWith("segments_") == false) put(segment, metadata.getUploadedFilename());
    private IndexShard primaryShard;
        }
        );
    public void setUp() throws Exception {
                primaryTerm,
