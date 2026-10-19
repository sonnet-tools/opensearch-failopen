import org.opensearch.common.settings.Settings;
        );
        Settings nodeSettings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir()).build();  
        ReplicationCheckpoint checkpoint = copyState.getCheckpoint();
        // version was never set so this should be zero
    }
        IndexShard mockShard = mock(IndexShard.class);
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.util.Version;
            0L  
import java.io.IOException;  
 * compatible open source license.
    private static final StoreFileMetadata SEGMENTS_FILE = new StoreFileMetadata(IndexFileNames.SEGMENTS, 1L, "0", Version.LATEST);
import org.opensearch.core.index.shard.ShardId;  
        when(mockStore.getMetadata(mockIndexCommit)).thenReturn(COMMIT_SNAPSHOT);
import org.apache.lucene.codecs.Codec;
        return mockShard;  
public class CopyStateTests extends IndexShardTestCase {  
/*  
 * The OpenSearch Contributors require contributions made to  
    private static final long EXPECTED_LONG_VALUE = 1L;
import org.apache.lucene.index.IndexFileNames;  
        CopyState copyState = new CopyState(mockIndexShard);
        when(mockShard.getLatestSegmentInfosAndCheckpoint()).thenReturn(gatedCloseableReplicationCheckpointTuple);  
        null,
        assertEquals(EXPECTED_LONG_VALUE, checkpoint.getPrimaryTerm());  
        when(mockShard.shardId()).thenReturn(TEST_SHARD_ID);
            Codec.getDefault().getName(),
        Store mockStore = mock(Store.class);  
 * this file be licensed under the Apache-2.0 license or a
        null,
import org.opensearch.common.concurrent.GatedCloseable;
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;  
            SI_SNAPSHOT.asMap(),
import static org.mockito.Mockito.when;
        Map.of(SEGMENT_FILE.name(), SEGMENT_FILE),  
 */  
import org.opensearch.common.collect.Tuple;  
        when(mockShard.indexSettings()).thenReturn(IndexSettingsModule.newIndexSettings("_na", nodeSettings));
            0L,
 *
package org.opensearch.indices.replication.common;
import org.apache.lucene.index.IndexCommit;
            new GatedCloseable<>(testSegmentInfos, () -> {}),  
    );  
        );
import static org.mockito.Mockito.mock;  
        when(mockStore.getSegmentMetadataMap(testSegmentInfos)).thenReturn(SI_SNAPSHOT.asMap());
}
        when(mockShard.store()).thenReturn(mockStore);
    private static final ShardId TEST_SHARD_ID = new ShardId("testIndex", "testUUID", 0);  
import java.util.Map;
            mockShard.shardId(),
    private static final StoreFileMetadata SEGMENT_FILE = new StoreFileMetadata("_0.si", 1L, "0", Version.LATEST);
        0
            0L,  
        IndexCommit mockIndexCommit = mock(IndexCommit.class);  
import org.apache.lucene.index.SegmentInfos;
import org.opensearch.index.shard.IndexShardTestCase;  
import org.opensearch.env.Environment;
        Map.of(SEGMENTS_FILE.name(), SEGMENTS_FILE, PENDING_DELETE_FILE.name(), PENDING_DELETE_FILE),  
    }
            0L,
import org.opensearch.test.IndexSettingsModule;
            testCheckpoint
        when(mockShard.getProcessedLocalCheckpoint()).thenReturn(EXPECTED_LONG_VALUE);
    public void testCopyStateCreation() throws IOException {
        final IndexShard mockIndexShard = createMockIndexShard();  
        SegmentInfos testSegmentInfos = new SegmentInfos(Version.LATEST.major);  
    private static final StoreFileMetadata PENDING_DELETE_FILE = new StoreFileMetadata("pendingDelete.del", 1L, "1", Version.LATEST);  
    public static IndexShard createMockIndexShard() throws IOException {  
        when(mockShard.acquireLastIndexCommit(false)).thenReturn(new GatedCloseable<>(mockIndexCommit, () -> {}));
        assertEquals(0, checkpoint.getSegmentInfosVersion());
            mockShard.getOperationPrimaryTerm(),  
    private static final Store.MetadataSnapshot SI_SNAPSHOT = new Store.MetadataSnapshot(
import org.opensearch.index.shard.IndexShard;
        ReplicationCheckpoint testCheckpoint = new ReplicationCheckpoint(
import org.opensearch.index.store.Store;
        when(mockShard.getOperationPrimaryTerm()).thenReturn(EXPECTED_LONG_VALUE);  
import org.opensearch.index.store.StoreFileMetadata;
        assertEquals(TEST_SHARD_ID, checkpoint.getShardId());  
    );  
        0
        final Tuple<GatedCloseable<SegmentInfos>, ReplicationCheckpoint> gatedCloseableReplicationCheckpointTuple = new Tuple<>(
    private static final Store.MetadataSnapshot COMMIT_SNAPSHOT = new Store.MetadataSnapshot(
