import org.opensearch.indices.replication.common.ReplicationFailedException;
            checkpointMergedSegment,
                BiConsumer<String, Long> fileProgressTracker,
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        };
    private SegmentInfos testSegmentInfos;
                assert (filesToFetch.contains(SEGMENT_FILE));
                long replicationId,
        testSuccessfulResponseStartReplication(mergedSegmentCheckpoint);
import org.opensearch.indices.replication.common.ReplicationType;
                List<StoreFileMetadata> filesToFetch,
            spyIndexShard,
    }
/*
            ) {}
        SegmentReplicationTargetService.SegmentReplicationListener segRepListener = mock(
            @Override
                List<StoreFileMetadata> filesToFetch,
                mergedSegmentReplicationTarget.fail(new ReplicationFailedException(e), false);
        remoteStoreMergedSegmentCheckpoint = new RemoteStoreMergedSegmentCheckpoint(
            segRepListener
                spyIndexShard.shardId(),
    }
                IndexShard indexShard,
import org.apache.lucene.index.SegmentInfos;
        );
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
        closeShards(spyIndexShard, indexShard);
import org.opensearch.index.replication.TestReplicationSource;
                IndexShard indexShard,
        testSegmentInfos = spyIndexShard.store().readLastCommittedSegmentsInfo();
            assertEquals(indexShard, spyIndexShard);
                ActionListener<GetSegmentFilesResponse> listener
            @Override
            segRepListener
    private static final Map<String, StoreFileMetadata> SI_SNAPSHOT_DIFFERENT = Map.of(SEGMENT_FILE_DIFF.name(), SEGMENT_FILE_DIFF);
            @Override
                ActionListener<GetSegmentFilesResponse> listener
                IndexShard indexShard,
    }
            ) {}
            @Override
import org.opensearch.index.shard.IndexShardTestCase;
    public void testFailureResponseGetMergedSegmentFiles_remoteStoreEnabled() {
        testFailureResponseGetMergedSegmentFiles(remoteStoreMergedSegmentCheckpoint);
        );
import org.opensearch.index.engine.NRTReplicationEngineFactory;
        }, (ReplicationCheckpoint checkpoint, IndexShard indexShard) -> {
    public void tearDown() throws Exception {
            segrepSource,
    @Override
    public void testSuccessfulResponseStartReplication_remoteStoreEnabled() {
import org.junit.Assert;
        mergedSegmentReplicationTarget.startReplication(new ActionListener<Void>() {
        super.tearDown();
                ReplicationCheckpoint checkpoint,
                IndexFileNames.parseSegmentName(SEGMENT_NAME)
                long replicationId,
            @Override
                List<StoreFileMetadata> filesToFetch,
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.metadata.IndexMetadata;
                assertTrue(e.getMessage().contains("has local copies of segments that differ from the primary"));
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
    public void testFailureResponseGetMergedSegmentFiles_segRep() {
            ) {}
        };
                ActionListener<CheckpointInfoResponse> listener
            assertEquals(mergedSegmentCheckpoint, checkpoint);
    }
                long replicationId,
            public void getSegmentFiles(
            ) {
            @Override
                BiConsumer<String, Long> fileProgressTracker,
package org.opensearch.indices.replication;
            1,
                Assert.fail();
            spyIndexShard,
        mergedSegmentCheckpoint = new MergedSegmentCheckpoint(
                listener.onResponse(new GetSegmentFilesResponse(filesToFetch));
        SegmentReplicationSource segrepSource = new TestReplicationSource() {
import org.apache.lucene.index.IndexFileNames;
                BiConsumer<String, Long> fileProgressTracker,
                listener.onResponse(new GetSegmentFilesResponse(filesToFetch));
            testSegmentInfos.write(indexOutput);
                Assert.fail();
 * compatible open source license.
    @Override
import java.util.Map;
                ReplicationCheckpoint checkpoint,
import org.opensearch.index.shard.IndexShard;
import org.opensearch.indices.replication.checkpoint.RemoteStoreMergedSegmentCheckpoint;
                1,
                IndexShard indexShard,
                assertEquals(exception, e.getCause().getCause());
                assertTrue(e instanceof OpenSearchCorruptionException);
 */
            ) {
            }
            public void onResponse(Void replicationResponse) {
            @Override
                ActionListener<CheckpointInfoResponse> listener
import org.opensearch.core.action.ActionListener;
                SI_SNAPSHOT,
                BiConsumer<String, Long> fileProgressTracker,
    public void setUp() throws Exception {
            checkpointMergedSegment,
    private void testSuccessfulResponseStartReplication(MergedSegmentCheckpoint checkpointMergedSegment) {
        );
    private static final Map<String, StoreFileMetadata> SI_SNAPSHOT = Map.of(SEGMENT_FILE.name(), SEGMENT_FILE);
                ReplicationCheckpoint checkpoint,
        when(spyIndexShard.getSegmentMetadataMap()).thenReturn(SI_SNAPSHOT_DIFFERENT);
import static org.mockito.Mockito.mock;
            }
import org.opensearch.index.store.StoreFileMetadata;
            ),
            ) {
                ReplicationCheckpoint checkpoint,
            spyIndexShard,
    }
import org.apache.lucene.store.ByteBuffersDataOutput;
            public void onFailure(Exception e) {
                List<StoreFileMetadata> filesToFetch,
        );
        mergedSegmentReplicationTarget.startReplication(new ActionListener<Void>() {
import org.apache.lucene.util.Version;
                long replicationId,
                BiConsumer<String, Long> fileProgressTracker,
                ActionListener<GetSegmentFilesResponse> listener
            .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
            ) {}
    }
                long replicationId,
            public void getSegmentFiles(
    }
        testFailureResponseGetMergedSegmentFiles(mergedSegmentCheckpoint);
            SegmentReplicationTargetService.SegmentReplicationListener.class
        spyIndexShard = spy(indexShard);
    public void testSuccessfulResponseStartReplication_segRep() {
            public void getMergedSegmentFiles(
            1,
        );
                1,
        buffer = new ByteBuffersDataOutput();
            @Override
                long replicationId,
    public void testFailureDifferentSegmentFiles_remoteStoreEnabled() throws IOException {
    private RemoteStoreMergedSegmentCheckpoint remoteStoreMergedSegmentCheckpoint;
import static org.mockito.Mockito.when;
        testFailureDifferentSegmentFiles(mergedSegmentCheckpoint);
        });
import org.opensearch.common.settings.Settings;
import java.io.IOException;
            new MergedSegmentCheckpoint(
            }
        );
 * this file be licensed under the Apache-2.0 license or a
            ) {}
                logger.error("Unexpected onFailure", e);
                ActionListener<CheckpointInfoResponse> listener
                indexShard.getLatestReplicationCheckpoint().getCodec(),
        mergedSegmentReplicationTarget = new MergedSegmentReplicationTarget(
        SegmentReplicationTargetService.SegmentReplicationListener segRepListener = mock(
            public void getMergedSegmentFiles(
    }
            spyIndexShard.getPendingPrimaryTerm(),
            }
            }
        );
            IndexFileNames.parseSegmentName(SEGMENT_NAME)
            public void onResponse(Void replicationResponse) {
            }
            segrepSource,
        testFailureDifferentSegmentFiles(remoteStoreMergedSegmentCheckpoint);
            @Override
        mergedSegmentReplicationTarget = new MergedSegmentReplicationTarget(
                BiConsumer<String, Long> fileProgressTracker,
                mergedSegmentReplicationTarget.fail(new ReplicationFailedException(e), false);
                long replicationId,
 * The OpenSearch Contributors require contributions made to
            spyIndexShard.shardId(),
                ReplicationCheckpoint checkpoint,
                mergedSegmentReplicationTarget.markAsDone();
    private void testFailureDifferentSegmentFiles(MergedSegmentCheckpoint checkpointMergedSegment) throws IOException {
        }
    private static final StoreFileMetadata SEGMENT_FILE = new StoreFileMetadata(SEGMENT_NAME, 1L, "0", Version.LATEST);
            }
    }
            public void getCheckpointMetadata(
            public void getMergedSegmentFiles(
    }
            checkpointMergedSegment,
    private ByteBuffersDataOutput buffer;
import java.util.function.BiConsumer;
            indexShard.getLatestReplicationCheckpoint().getCodec(),
    private MergedSegmentCheckpoint mergedSegmentCheckpoint;
                assertEquals(1, filesToFetch.size());
    private IndexShard indexShard, spyIndexShard;
                List<StoreFileMetadata> filesToFetch,
import static org.mockito.Mockito.spy;
            @Override
        SegmentReplicationSource segrepSource = new TestReplicationSource() {
import org.apache.lucene.store.ByteBuffersIndexOutput;
        Settings indexSettings = Settings.builder()
                Assert.fail();
                ReplicationCheckpoint checkpoint,
    }
 *
        testSuccessfulResponseStartReplication(remoteStoreMergedSegmentCheckpoint);
        }, mock(BiConsumer.class));
        };
            .build();
        indexShard = newStartedShard(false, indexSettings, new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()));
                ActionListener<GetSegmentFilesResponse> listener
import org.opensearch.OpenSearchCorruptionException;
            segrepSource,
                ReplicationCheckpoint checkpoint,
    private void testFailureResponseGetMergedSegmentFiles(MergedSegmentCheckpoint checkpointMergedSegment) {
public class MergedSegmentReplicationTargetTests extends IndexShardTestCase {
import org.opensearch.indices.replication.checkpoint.MergedSegmentCheckpoint;
            }
import java.util.List;
}
        super.setUp();
                List<StoreFileMetadata> filesToFetch,
            SegmentReplicationTargetService.SegmentReplicationListener.class
            ) {}
            public void getCheckpointMetadata(
                ReplicationCheckpoint checkpoint,
            @Override
        mergedSegmentReplicationTarget.startReplication(new ActionListener<Void>() {
                listener.onFailure(exception);
                ActionListener<GetSegmentFilesResponse> listener
            public void getSegmentFiles(
            @Override
            Map.of(SEGMENT_NAME, SEGMENT_NAME + "__uuid")
            public void onFailure(Exception e) {
            public void onResponse(Void replicationResponse) {
        Exception exception = new Exception("dummy failure");
            @Override
            }
        }, mock(BiConsumer.class));
    private MergedSegmentReplicationTarget mergedSegmentReplicationTarget;
        SegmentReplicationSource segrepSource = new TestReplicationSource() {
        );
                IndexShard indexShard,
                IndexShard indexShard,
    private static final StoreFileMetadata SEGMENT_FILE_DIFF = new StoreFileMetadata(SEGMENT_NAME, 5L, "different", Version.LATEST);
                ActionListener<GetSegmentFilesResponse> listener
        mergedSegmentReplicationTarget = new MergedSegmentReplicationTarget(
    private MergedSegmentCheckpoint mergedSegment;
            @Override
            @Override
            public void getCheckpointMetadata(
            public void onFailure(Exception e) {
    public void testFailureDifferentSegmentFiles_segRep() throws IOException {
    private static final String SEGMENT_NAME = "_0.si";
                ReplicationCheckpoint checkpoint,
        SegmentReplicationTargetService.SegmentReplicationListener segRepListener = mock(
            SI_SNAPSHOT,
                long replicationId,
            segRepListener
                long replicationId,
                spyIndexShard.getPendingPrimaryTerm(),
        try (ByteBuffersIndexOutput indexOutput = new ByteBuffersIndexOutput(buffer, "", null)) {
            SegmentReplicationTargetService.SegmentReplicationListener.class
