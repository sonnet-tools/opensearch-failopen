            ) {}
            }
                BiConsumer<String, Long> fileProgressTracker,  
    public void testSuccessfulResponseStartReplication_remoteStoreEnabled() {
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;  
            public void getSegmentFiles(  
                listener.onResponse(new GetSegmentFilesResponse(filesToFetch));
            public void onResponse(Void replicationResponse) {  
                long replicationId,
                BiConsumer<String, Long> fileProgressTracker,
            checkpointMergedSegment,
import org.opensearch.indices.replication.common.ReplicationType;
            segrepSource,  
        }
        }, mock(BiConsumer.class));  
                ReplicationCheckpoint checkpoint,
        });  
            }
            @Override  
import org.opensearch.index.engine.NRTReplicationEngineFactory;
    private static final String SEGMENT_NAME = "_0.si";
                spyIndexShard.shardId(),
        SegmentReplicationTargetService.SegmentReplicationListener segRepListener = mock(
                ActionListener<GetSegmentFilesResponse> listener
                ActionListener<GetSegmentFilesResponse> listener  
        testSegmentInfos = spyIndexShard.store().readLastCommittedSegmentsInfo();  
    }
            IndexFileNames.parseSegmentName(SEGMENT_NAME)  
                ActionListener<GetSegmentFilesResponse> listener
            @Override
                BiConsumer<String, Long> fileProgressTracker,  
    public void testFailureDifferentSegmentFiles_remoteStoreEnabled() throws IOException {
/*  
import org.opensearch.core.action.ActionListener;  
    public void setUp() throws Exception {
            ) {
                ReplicationCheckpoint checkpoint,  
                IndexFileNames.parseSegmentName(SEGMENT_NAME)
import org.opensearch.index.replication.TestReplicationSource;  
            1,  
import org.opensearch.OpenSearchCorruptionException;  
    public void testFailureResponseGetMergedSegmentFiles_segRep() {
    }
    }
                ReplicationCheckpoint checkpoint,  
    private static final StoreFileMetadata SEGMENT_FILE = new StoreFileMetadata(SEGMENT_NAME, 1L, "0", Version.LATEST);  
            segrepSource,  
                ActionListener<CheckpointInfoResponse> listener
            @Override
                ActionListener<GetSegmentFilesResponse> listener
import java.util.function.BiConsumer;
            public void onResponse(Void replicationResponse) {
                assertTrue(e instanceof OpenSearchCorruptionException);
            public void getCheckpointMetadata(
            1,
 * this file be licensed under the Apache-2.0 license or a
    public void testSuccessfulResponseStartReplication_segRep() {  
        };
            }  
}
                mergedSegmentReplicationTarget.fail(new ReplicationFailedException(e), false);
    }  
                Assert.fail();  
 * compatible open source license.
                long replicationId,  
                Assert.fail();
    @Override  
            @Override
            @Override
        Settings indexSettings = Settings.builder()
            }
import org.apache.lucene.store.ByteBuffersDataOutput;  
            indexShard.getLatestReplicationCheckpoint().getCodec(),
        };
            SI_SNAPSHOT,
        indexShard = newStartedShard(false, indexSettings, new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()));  
                SI_SNAPSHOT,  
            SegmentReplicationTargetService.SegmentReplicationListener.class  
    }  
        );
            segrepSource,
                assertEquals(1, filesToFetch.size());  
        testSuccessfulResponseStartReplication(mergedSegmentCheckpoint);
                assertEquals(exception, e.getCause().getCause());  
            public void onFailure(Exception e) {
            }
package org.opensearch.indices.replication;
            public void onFailure(Exception e) {
        mergedSegmentReplicationTarget.startReplication(new ActionListener<Void>() {
    private static final Map<String, StoreFileMetadata> SI_SNAPSHOT_DIFFERENT = Map.of(SEGMENT_FILE_DIFF.name(), SEGMENT_FILE_DIFF);
                ReplicationCheckpoint checkpoint,  
    private static final StoreFileMetadata SEGMENT_FILE_DIFF = new StoreFileMetadata(SEGMENT_NAME, 5L, "different", Version.LATEST);
                long replicationId,
                long replicationId,
            spyIndexShard.shardId(),  
import static org.mockito.Mockito.spy;
        }, mock(BiConsumer.class));  
        );
import org.opensearch.indices.replication.common.ReplicationFailedException;
                assertTrue(e.getMessage().contains("has local copies of segments that differ from the primary"));  
 * The OpenSearch Contributors require contributions made to  
        testFailureDifferentSegmentFiles(remoteStoreMergedSegmentCheckpoint);
    private void testSuccessfulResponseStartReplication(MergedSegmentCheckpoint checkpointMergedSegment) {
            public void getCheckpointMetadata(
            assertEquals(indexShard, spyIndexShard);
            @Override
            ) {}  
            checkpointMergedSegment,
                long replicationId,
 *
            ) {}
                mergedSegmentReplicationTarget.markAsDone();
    private ByteBuffersDataOutput buffer;  
            public void getSegmentFiles(
        mergedSegmentReplicationTarget.startReplication(new ActionListener<Void>() {  
import java.io.IOException;
            .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
            }  
            @Override  
import org.opensearch.common.settings.Settings;
                long replicationId,
            public void getMergedSegmentFiles(
            assertEquals(mergedSegmentCheckpoint, checkpoint);
import org.apache.lucene.store.ByteBuffersIndexOutput;
                ActionListener<GetSegmentFilesResponse> listener  
import org.opensearch.index.shard.IndexShardTestCase;
                IndexShard indexShard,
            @Override
                ReplicationCheckpoint checkpoint,
        SegmentReplicationSource segrepSource = new TestReplicationSource() {
            public void onResponse(Void replicationResponse) {  
            @Override
        mergedSegmentReplicationTarget = new MergedSegmentReplicationTarget(  
            }
            ) {}  
            @Override
        );
                IndexShard indexShard,
                1,
                listener.onResponse(new GetSegmentFilesResponse(filesToFetch));
                long replicationId,
import org.opensearch.indices.replication.checkpoint.MergedSegmentCheckpoint;
            ) {}
            Map.of(SEGMENT_NAME, SEGMENT_NAME + "__uuid")  
        SegmentReplicationTargetService.SegmentReplicationListener segRepListener = mock(  
        super.setUp();  
import static org.mockito.Mockito.when;  
                List<StoreFileMetadata> filesToFetch,
            @Override
                IndexShard indexShard,
        }, (ReplicationCheckpoint checkpoint, IndexShard indexShard) -> {  
import org.opensearch.indices.replication.checkpoint.RemoteStoreMergedSegmentCheckpoint;
        SegmentReplicationTargetService.SegmentReplicationListener segRepListener = mock(  
                mergedSegmentReplicationTarget.fail(new ReplicationFailedException(e), false);
        testSuccessfulResponseStartReplication(remoteStoreMergedSegmentCheckpoint);  
            SegmentReplicationTargetService.SegmentReplicationListener.class
                List<StoreFileMetadata> filesToFetch,
        testFailureResponseGetMergedSegmentFiles(mergedSegmentCheckpoint);
                assert (filesToFetch.contains(SEGMENT_FILE));
            @Override
                List<StoreFileMetadata> filesToFetch,  
                ActionListener<CheckpointInfoResponse> listener
                ReplicationCheckpoint checkpoint,
    private void testFailureResponseGetMergedSegmentFiles(MergedSegmentCheckpoint checkpointMergedSegment) {  
        mergedSegmentReplicationTarget = new MergedSegmentReplicationTarget(  
import org.apache.lucene.index.SegmentInfos;
        SegmentReplicationSource segrepSource = new TestReplicationSource() {  
            spyIndexShard,
            new MergedSegmentCheckpoint(  
        try (ByteBuffersIndexOutput indexOutput = new ByteBuffersIndexOutput(buffer, "", null)) {
import org.opensearch.index.store.StoreFileMetadata;  
            ) {
                BiConsumer<String, Long> fileProgressTracker,
        mergedSegmentReplicationTarget = new MergedSegmentReplicationTarget(
        testFailureDifferentSegmentFiles(mergedSegmentCheckpoint);  
            spyIndexShard.getPendingPrimaryTerm(),
 */  
                ActionListener<GetSegmentFilesResponse> listener  
import org.apache.lucene.util.Version;
 * SPDX-License-Identifier: Apache-2.0
        );
                1,  
        SegmentReplicationSource segrepSource = new TestReplicationSource() {  
                spyIndexShard.getPendingPrimaryTerm(),
    private void testFailureDifferentSegmentFiles(MergedSegmentCheckpoint checkpointMergedSegment) throws IOException {  
                ReplicationCheckpoint checkpoint,
    public void testFailureDifferentSegmentFiles_segRep() throws IOException {
            .build();
        when(spyIndexShard.getSegmentMetadataMap()).thenReturn(SI_SNAPSHOT_DIFFERENT);
                IndexShard indexShard,  
        };
        closeShards(spyIndexShard, indexShard);  
        testFailureResponseGetMergedSegmentFiles(remoteStoreMergedSegmentCheckpoint);
            ) {}  
        mergedSegmentCheckpoint = new MergedSegmentCheckpoint(
public class MergedSegmentReplicationTargetTests extends IndexShardTestCase {
import org.apache.lucene.index.IndexFileNames;
    private IndexShard indexShard, spyIndexShard;
        remoteStoreMergedSegmentCheckpoint = new RemoteStoreMergedSegmentCheckpoint(
    }
            spyIndexShard,
                ActionListener<CheckpointInfoResponse> listener
            checkpointMergedSegment,
            spyIndexShard,  
                List<StoreFileMetadata> filesToFetch,  
                long replicationId,  
    private MergedSegmentReplicationTarget mergedSegmentReplicationTarget;
            ) {
        spyIndexShard = spy(indexShard);
            segRepListener
        buffer = new ByteBuffersDataOutput();
import java.util.List;  
        super.tearDown();
                List<StoreFileMetadata> filesToFetch,  
import static org.mockito.Mockito.mock;
                ReplicationCheckpoint checkpoint,
            @Override  
    private MergedSegmentCheckpoint mergedSegmentCheckpoint;  
                indexShard.getLatestReplicationCheckpoint().getCodec(),
import org.opensearch.cluster.metadata.IndexMetadata;
                ReplicationCheckpoint checkpoint,
    public void tearDown() throws Exception {
        );
import org.opensearch.index.shard.IndexShard;
                IndexShard indexShard,
            @Override
    }
                logger.error("Unexpected onFailure", e);  
    public void testFailureResponseGetMergedSegmentFiles_remoteStoreEnabled() {  
            }
    private RemoteStoreMergedSegmentCheckpoint remoteStoreMergedSegmentCheckpoint;
    @Override  
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
    }
            public void getMergedSegmentFiles(  
import org.junit.Assert;  
            segRepListener  
            ),
            }
                List<StoreFileMetadata> filesToFetch,
        Exception exception = new Exception("dummy failure");
            public void onFailure(Exception e) {
        );
        );
            SegmentReplicationTargetService.SegmentReplicationListener.class
                listener.onFailure(exception);  
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
    private MergedSegmentCheckpoint mergedSegment;
        );
                BiConsumer<String, Long> fileProgressTracker,
    }
            public void getSegmentFiles(  
            @Override  
            public void getCheckpointMetadata(
    }
                Assert.fail();
                BiConsumer<String, Long> fileProgressTracker,
    }
            public void getMergedSegmentFiles(
            segRepListener
import java.util.Map;
                IndexShard indexShard,
    private static final Map<String, StoreFileMetadata> SI_SNAPSHOT = Map.of(SEGMENT_FILE.name(), SEGMENT_FILE);  
        mergedSegmentReplicationTarget.startReplication(new ActionListener<Void>() {
    private SegmentInfos testSegmentInfos;
                long replicationId,  
            testSegmentInfos.write(indexOutput);  
