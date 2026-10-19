        RemoteStoreMergedSegmentCheckpoint mergedSegmentCheckpoint = new RemoteStoreMergedSegmentCheckpoint(  
        GetSegmentFilesResponse response = res.get();
        replicationSource.getCheckpointMetadata(REPLICATION_ID, checkpoint, res3);  
        assertTrue(observedException instanceof NoSuchFileException);  
        assertTrue(response.getMetadataMap().isEmpty());
        replicationSource = new RemoteStoreReplicationSource(primaryShard);
        final PlainActionFuture<CheckpointInfoResponse> res = PlainActionFuture.newFuture();
import org.opensearch.indices.replication.common.ReplicationType;  
                });  
     * resolve {@code Version.LATEST} and continue without throwing {@code ClassCastException}.  
        latch.await();  
                "_0"
            new StoreFileMetadata("invalid.si", 1, "1", Version.LATEST),  
import org.apache.lucene.util.Version;
                (fileName, bytesRecovered) -> {},
import org.opensearch.common.unit.TimeValue;
            final PlainActionFuture<CheckpointInfoResponse> res = PlainActionFuture.newFuture();  
        List<StoreFileMetadata> filesToFetch = new ArrayList<>(primaryShard.getSegmentMetadataMap().values());  
import org.opensearch.common.concurrent.GatedCloseable;  
        assertTrue(response.getCheckpoint().equals(checkpoint));  
        final ReplicationCheckpoint checkpoint = primaryShard.getLatestReplicationCheckpoint();  
                checkpoint.getLength(),
                });  
            assertTrue(ex instanceof AssertionError);
                    }
        final ReplicationCheckpoint checkpoint = replicaShard.getLatestReplicationCheckpoint();
                checkpoint.getCodec(),
/*  
    private static final long REPLICATION_ID = 123L;
        replicationSource = new RemoteStoreReplicationSource(mockShard);
        // For a STARTED shard, the new behavior needs mock routing entry  
            latch.countDown();
        replicationSource.getCheckpointMetadata(REPLICATION_ID, checkpoint, res);  
        final PlainActionFuture<GetSegmentFilesResponse> res = PlainActionFuture.newFuture();
                Map<String, UploadedSegmentMetadata> segmentsUploadedToRemoteStore = primaryShard.getRemoteDirectory()
        // Mock a routing entry for the search-only condition
                    .getSegmentsUploadedToRemoteStore();
                failureRef.set(e);  
        replicationSource.getMergedSegmentFiles(
        CountDownLatch latch = new CountDownLatch(1);
                checkpoint.getMetadataMap(),
        replicationSource.getCheckpointMetadata(REPLICATION_ID, checkpoint, res2);
import java.io.IOException;
                checkpoint.getMetadataMap(),  
    public void testGetSegmentFiles() throws ExecutionException, InterruptedException, IOException {
import org.opensearch.cluster.routing.ShardRouting;
                        throw new AssertionError("Failed to close shard", e);
                latch.countDown();  
        // For a RECOVERING shard, the response should have an empty metadata map.  
            } catch (Exception e) {
            public void onFailure(Exception e) {
            @Override  
            public void onResponse(GetSegmentFilesResponse response) {
        assertTrue(observedException instanceof TimeoutException);  
                        closeShard(shard, true);
        // Override the catalog snapshot with a non-SegmentInfos (DFA-style) stub.
                checkpoint.getCodec(),  
import org.opensearch.indices.recovery.RecoverySettings;
            }
        when(mockShard.getCatalogSnapshot()).thenThrow(new RuntimeException("test"));  
                replicaShard.shardId(),
        CountDownLatch latch = new CountDownLatch(1);
                .getDelegate();
        assertNotNull("onFailure should have been called", failureRef.get());
                checkpoint.getSegmentInfosVersion(),
                "_0"
        };  
        );
            filesToFetch,
            }  
        replicationSource = new RemoteStoreReplicationSource(primaryShard);
        latch.await();
                primaryShard,
import static org.mockito.Mockito.mock;
        .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "my-repo")  
package org.opensearch.indices.replication;
            }
    public void tearDown() throws Exception {  
 * The OpenSearch Contributors require contributions made to  
            replica,
        try {  
     */
            @Override
            try {
    }
    }
        when(mockShard.getCatalogSnapshot()).thenReturn(indexShard.getCatalogSnapshot());
        final ReplicationCheckpoint checkpoint = primaryShard.getLatestReplicationCheckpoint();  
        AtomicReference<Exception> failureRef = new AtomicReference<>();
            replicaShard,
        IndexShard mockShard = mock(IndexShard.class);
                checkpoint.getSegmentInfosVersion(),  
        .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "my-repo")
        when(mockRouting.isSearchOnly()).thenReturn(false);
        final PlainActionFuture<CheckpointInfoResponse> res3 = PlainActionFuture.newFuture();
        assert (response.getCheckpoint().equals(checkpoint));
            (fileName, bytesRecovered) -> {},
        replicationSource = new RemoteStoreReplicationSource(mockShard);
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
        Map<String, String> localToRemoteFilenameMap = new HashMap<>() {  
        final PlainActionFuture<GetSegmentFilesResponse> res = PlainActionFuture.newFuture();
            }
        );
    }
import java.util.Set;  
        replicationSource.getCheckpointMetadata(REPLICATION_ID, checkpoint, res);  
                checkpoint.getSegmentInfosVersion(),
        assertNotNull("onFailure should have been called", failureRef.get());
            {
            listener
                    .getSegmentsUploadedToRemoteStore();  
            localToRemoteFilenameMap
        // Not-started + null metadata path returns empty response. The key is that this path
    }
import java.util.ArrayList;
import java.nio.file.NoSuchFileException;  
        } catch (AssertionError | ExecutionException ex) {  
            }  
        final PlainActionFuture<CheckpointInfoResponse> res = PlainActionFuture.newFuture();
import static org.mockito.Mockito.when;
import org.opensearch.action.support.PlainActionFuture;  
        );
                && observedException.getMessage().equals("Timed out waiting for merged segments download from remote store")  
        Exception observedException = failureRef.get();
    public void setUp() throws Exception {
        closeShards(replicaShard);
                checkpoint.getMetadataMap(),
        assertTrue(response2.getCheckpoint().equals(replicaShard.getLatestReplicationCheckpoint()));  
        IndexShard mockShard = mock(IndexShard.class);
            (fileName, bytesRecovered) -> {},
            }
            primaryShard,
                filesToFetch,  
        Map<String, String> localToRemoteFilenameMap = Map.of("invalid.si", "invalid.si__uuid", "invalid.cfs", "invalid.cfs__uuid");
                replicaShard.shardId(),
        replicationSource.getSegmentFiles(  
        };
        final ReplicationCheckpoint checkpoint = primaryShard.getLatestReplicationCheckpoint();  
            mergedSegmentCheckpoint,  
            @Override
    }  
import java.util.concurrent.ExecutionException;
import org.opensearch.index.store.StoreFileMetadata;
        // Ensure the mock returns the expected checkpoint when getLatestReplicationCheckpoint is called.
        final PlainActionFuture<CheckpointInfoResponse> res = PlainActionFuture.newFuture();
            ),  
        };
            (fileName, bytesRecovered) -> {},  
        when(mockRouting.isSearchOnly()).thenReturn(true); // Make it a search-only replica
        replicaShard = newStartedShard(false, settings, new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()));
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeoutException;  
        when(mockShard.remoteStore()).thenReturn(remoteStore);
    private IndexShard primaryShard;  
    }  
        assertTrue(response.files.containsAll(filesToFetch));
import org.opensearch.index.store.RemoteSegmentStoreDirectory;
                replicaShard.shardId(),  
                    if (segment.startsWith("segments_") == false) put(segment, metadata.getUploadedFilename());
import org.opensearch.indices.replication.checkpoint.RemoteStoreMergedSegmentCheckpoint;
        buildIndexShardBehavior(mockShard, replicaShard);  
            REPLICATION_ID,
        closeShardsWithRetry(primaryShard, replicaShard);
 */  
    }
        primaryShard = newStartedShard(true, settings, new EngineBackedIndexerFactory(new InternalEngineFactory()));
    public void testGetMergedSegmentFilesDownloadTimeout() throws IOException, ExecutionException, InterruptedException {
 * SPDX-License-Identifier: Apache-2.0
        assertTrue(response.files.containsAll(filesToFetch));
    public void testGetCheckpointMetadataEmpty() throws ExecutionException, InterruptedException {  
    private IndexShard replicaShard;
            assertTrue(ex.getMessage().startsWith("Local store already contains the file"));  
        buildIndexShardBehavior(mockShard, replicaShard);
            new MergedSegmentCheckpoint(
            replicationSource = new RemoteStoreReplicationSource(primaryShard);
        final PlainActionFuture<GetSegmentFilesResponse> res = PlainActionFuture.newFuture();
import java.util.concurrent.atomic.AtomicInteger;
 *
        );
        CheckpointInfoResponse response2 = res2.get();
    public void testGetSegmentFilesAlreadyExists() throws IOException, InterruptedException {
                checkpoint.getLength(),  
        RemoteStoreMergedSegmentCheckpoint mergedSegmentCheckpoint = new RemoteStoreMergedSegmentCheckpoint(
        }
        assertTrue(response.getMetadataMap().isEmpty());
            );
import org.opensearch.common.settings.Settings;
    public void testGetCheckpointMetadataWithNonSegmentInfosCatalogSnapshot() throws Exception {
            AtomicInteger retry = new AtomicInteger(1);
import org.opensearch.index.engine.dataformat.stub.MockDataFormat;
        final ReplicationCheckpoint checkpoint = primaryShard.getLatestReplicationCheckpoint();  
            REPLICATION_ID,
        RemoteSegmentStoreDirectory remoteSegmentStoreDirectory =
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
        replicaShard.getRemoteDirectory().markMergedSegmentsPendingDownload(localToRemoteFilenameMap);
        assertTrue(response2.getMetadataMap().isEmpty());
     * when the shard returns a non-{@code SegmentInfosCatalogSnapshot}, the source must
        ShardRouting mockRouting = mock(ShardRouting.class);  
        indexDoc(primaryShard, "_doc", "1");
        List<StoreFileMetadata> filesToFetch = new ArrayList<>(primaryShard.getSegmentMetadataMap().values());
            Collections.emptyList(),  
import org.opensearch.index.store.RemoteSegmentStoreDirectory.UploadedSegmentMetadata;
            replicationSource.getSegmentFiles(  
            filesToFetch,  
        MockCatalogSnapshot dfa = new MockCatalogSnapshot(1L, List.of(), new MockDataFormat("parquet", 0L, Set.of()));  
                logger.warn("Unable to close shard " + shardId + ". Exception: " + e);
            new MergedSegmentCheckpoint(
                checkpoint,
        );
    }  
    /**  
        indexDoc(primaryShard, "_doc", "2");  
        GetSegmentFilesResponse response = res.get();
        Store remoteStore = mock(Store.class);  
        final ReplicationCheckpoint checkpoint = primaryShard.getLatestReplicationCheckpoint();  
        when(remoteStore.directory()).thenReturn(remoteStoreFilterDirectory);  
    public void testGetSegmentFilesReturnEmptyResponse() throws ExecutionException, InterruptedException {
            localToRemoteFilenameMap
    }  
        replicationSource.getCheckpointMetadata(REPLICATION_ID, checkpoint, res);
        // Additional test for non-search-only replica (should fail with exception)  
        primaryShard.refresh("test");
import static org.mockito.Mockito.spy;  
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(
                "_0"  
                Map<String, UploadedSegmentMetadata> segmentsUploadedToRemoteStore = primaryShard.getRemoteDirectory()
        final ReplicationCheckpoint checkpoint = primaryShard.getLatestReplicationCheckpoint();
                latch.countDown();
    }
            ),
            replicaShard,
        final ReplicationCheckpoint checkpoint = primaryShard.getLatestReplicationCheckpoint();
            @Override
                fail("Expected onFailure to be called");
            listener
            (RemoteSegmentStoreDirectory) ((FilterDirectory) ((FilterDirectory) indexShard.remoteStore().directory()).getDelegate())  
        CheckpointInfoResponse response = res.get();
                segmentsUploadedToRemoteStore.forEach((segment, metadata) -> {
        when(mockShard.getLatestReplicationCheckpoint()).thenReturn(replicaShard.getLatestReplicationCheckpoint());
import java.util.Collections;
        assertTrue(exception.getCause().getMessage().contains("Remote metadata file can't be null if shard is active"));  
        );
            {  
            }
import java.util.Map;
        replicationSource = new RemoteStoreReplicationSource(primaryShard);  
        assertThrows(RuntimeException.class, () -> {
import org.opensearch.index.engine.NRTReplicationEngineFactory;
        assertTrue(exception.getCause() instanceof IllegalStateException);
        assertEquals(response.files.size(), filesToFetch.size());  
            final PlainActionFuture<GetSegmentFilesResponse> res = PlainActionFuture.newFuture();
    }  
                    } catch (RuntimeException e) {  
                fail("Expected onFailure to be called");  
import java.util.HashMap;  
 * compatible open source license.
import org.opensearch.core.action.ActionListener;  
        final ReplicationCheckpoint checkpoint = primaryShard.getLatestReplicationCheckpoint();
        replicaShard.getRemoteDirectory().markMergedSegmentsPendingDownload(localToRemoteFilenameMap);  
import org.opensearch.index.engine.InternalEngineFactory;
            replicationSource.getCheckpointMetadata(REPLICATION_ID, checkpoint, res);
    @Override
        );  
public class RemoteStoreReplicationSourceTests extends OpenSearchIndexLevelReplicationTestCase {  
        when(mockShard.state()).thenReturn(IndexShardState.STARTED);
        Exception observedException = failureRef.get();
                checkpoint.getLength(),
        super.setUp();  
        .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
    }
            res.get();
        for (IndexShard shard : shards) {
        when(replica.getRecoverySettings()).thenReturn(mockRecoverySettings);  
import org.opensearch.index.shard.IndexShard;
            new MergedSegmentCheckpoint(  
        replicationSource.getMergedSegmentFiles(  
            res  
            REPLICATION_ID,
        RecoverySettings mockRecoverySettings = mock(RecoverySettings.class);
        final PlainActionFuture<CheckpointInfoResponse> res2 = PlainActionFuture.newFuture();  
        final ReplicationCheckpoint checkpoint = primaryShard.getLatestReplicationCheckpoint();  
        IndexShard replica = spy(replicaShard);  
    private RemoteStoreReplicationSource replicationSource;
        when(mockRecoverySettings.getMergedSegmentReplicationTimeout()).thenReturn(TimeValue.ZERO);
        };
        replicationSource = new RemoteStoreReplicationSource(primaryShard);
        List<StoreFileMetadata> filesToFetch = primaryShard.getSegmentMetadataMap().values().stream().collect(Collectors.toList());
        }
        GetSegmentFilesResponse response = res.get();
            ),
        );
    public void testGetCheckpointMetadataFailure() {  
import org.opensearch.index.store.Store;  
import org.opensearch.index.shard.RemoteStoreRefreshListenerTests.TestFilterDirectory;  
        List<StoreFileMetadata> filesToFetch = List.of(
                REPLICATION_ID,
        // Testing failure scenario where segments are not a part of RemoteSegmentStoreDirectory.pendingMergedSegmentsDownloads
        });  
    }
import org.opensearch.index.engine.dataformat.stub.MockCatalogSnapshot;  
        // Build mockShard to return replicaShard directory so that an empty metadata file is returned.
        FilterDirectory remoteStoreFilterDirectory = new TestFilterDirectory(new TestFilterDirectory(remoteSegmentStoreDirectory));
    public void testGetMergedSegmentFilesFailure() throws IOException, ExecutionException, InterruptedException {
import java.util.stream.Collectors;  
            res.get();
        when(mockShard.getCatalogSnapshot()).thenReturn(new GatedCloseable<>(dfa, () -> {}));
                        logger.info("Trying to close " + shardId + " try: " + retry.getAndIncrement());
}  
    private void buildIndexShardBehavior(IndexShard mockShard, IndexShard indexShard) {
import java.util.List;
                checkpoint.getCodec(),
    }
        assert (response.files.isEmpty());  
     * Covers the DFA branch in {@link RemoteStoreReplicationSource#getCheckpointMetadata}:
        Map<String, String> localToRemoteFilenameMap = new HashMap<>() {
            replicationSource = new RemoteStoreReplicationSource(mockShard);
            res  
            filesToFetch,
import org.apache.lucene.store.FilterDirectory;
            mergedSegmentCheckpoint,
        ActionListener<GetSegmentFilesResponse> listener = new ActionListener<>() {
        // Reuse real shard's remote store wiring so the ReplicationSource ctor succeeds.
        RemoteStoreMergedSegmentCheckpoint mergedSegmentCheckpoint = new RemoteStoreMergedSegmentCheckpoint(
        CheckpointInfoResponse response = res.get();
            observedException.getMessage() != null
        replicationSource.getMergedSegmentFiles(
            REPLICATION_ID,
    private final Settings settings = Settings.builder()  
        when(mockShard.state()).thenReturn(IndexShardState.RECOVERING);
import java.util.concurrent.atomic.AtomicReference;
        when(mockShard.state()).thenReturn(IndexShardState.RECOVERING);  
    @Override
        .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
        ExecutionException exception = assertThrows(ExecutionException.class, () -> res3.get());
import org.opensearch.cluster.metadata.IndexMetadata;
        super.tearDown();
        latch.await();  
        );
            String shardId = shard.shardId().toString() + (shard.isPrimaryMode() ? "[p]" : "[r]");  
        ActionListener<GetSegmentFilesResponse> listener = new ActionListener<>() {  
        List<StoreFileMetadata> filesToFetch = primaryShard.getSegmentMetadataMap().values().stream().collect(Collectors.toList());
        assertEquals(response.files.size(), filesToFetch.size());  
    public void testGetCheckpointMetadata() throws ExecutionException, InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
                failureRef.set(e);
    private void closeShardsWithRetry(IndexShard... shards) {  
                primaryTerm,
        replicationSource = new RemoteStoreReplicationSource(primaryShard);
                    try {  
                assertBusy(() -> {
            public void onFailure(Exception e) {
            mergedSegmentCheckpoint,  
            new StoreFileMetadata("invalid.cfs", 1, "1", Version.LATEST)
        IndexShard mockShard = mock(IndexShard.class);  
                    if (segment.startsWith("segments_") == false) put(segment, metadata.getUploadedFilename());
    public void testGetMergedSegmentFiles() throws IOException, ExecutionException, InterruptedException {  
                segmentsUploadedToRemoteStore.forEach((segment, metadata) -> {  
import org.opensearch.index.shard.IndexShardState;
        replicationSource = new RemoteStoreReplicationSource(primaryShard);  
        AtomicReference<Exception> failureRef = new AtomicReference<>();  
import org.opensearch.index.replication.OpenSearchIndexLevelReplicationTestCase;  
                primaryTerm,  
                primaryTerm,
            (fileName, bytesRecovered) -> {},  
            localToRemoteFilenameMap  
            checkpoint,
        assert (response.getMetadataMap().isEmpty() == false);  
        assertTrue(observedException.getMessage() != null && observedException.getMessage().startsWith("invalid."));
        replicationSource.getSegmentFiles(REPLICATION_ID, checkpoint, filesToFetch, replicaShard, (fileName, bytesRecovered) -> {}, res);
        assertNotNull(response);
        CheckpointInfoResponse response = res.get();
            public void onResponse(GetSegmentFilesResponse response) {  
        .build();
                res  
                });
        when(mockShard.routingEntry()).thenReturn(mockRouting);
import org.opensearch.indices.replication.checkpoint.MergedSegmentCheckpoint;  
        // is reached without the DFA-snapshot branch throwing ClassCastException.  
