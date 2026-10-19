                ActionListener<CheckpointInfoResponse> listener
            }
                assertEquals(exception, e.getCause());  
import java.util.function.BiConsumer;
        SegmentReplicationTargetService.SegmentReplicationListener segRepListener = mock(  
                segrepTarget.fail(new ReplicationFailedException(e), false);  
        Store.MetadataSnapshot storeMetadataWithDeletes = store.getMetadata();
                ActionListener<CheckpointInfoResponse> listener
import org.apache.lucene.tests.analysis.MockAnalyzer;
            public void onResponse(Void replicationResponse) {
                Assert.fail();
        SegmentReplicationSource segrepSource = new TestReplicationSource() {
                assertEquals(ReplicationFailedException.class, e.getClass());
package org.opensearch.indices.replication;
                Assert.fail();
            }  
            ) {
                assertEquals(
        }, mock(BiConsumer.class));
            SegmentReplicationTargetService.SegmentReplicationListener.class
                assert (filesToFetch.contains(SEGMENT_FILE));
        when(mockRouting.initializing()).thenReturn(true);
            @Override  
    public void testStaleCheckpointRejected_duringNormalReplication() throws IOException {  
                IndexShard indexShard,
                BiConsumer<String, Long> fileProgressTracker,
            public void onResponse(Void replicationResponse) {
        segrepTarget.startReplication(new ActionListener<Void>() {
import java.io.IOException;
                            .count()  
                ActionListener<GetSegmentFilesResponse> listener
            }  
import java.util.Random;
            @Override
                IndexShard indexShard,  
            repCheckpoint.getPrimaryTerm(),  
     * @throws IOException if one of the indexing operations fails
        SegmentReplicationTargetService.SegmentReplicationListener segRepListener = mock(
        Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT).build()
            @Override
            testSegmentInfos.version,
                ReplicationCheckpoint checkpoint,
        SegmentReplicationSource segrepSource = new TestReplicationSource() {
                listener.onFailure(exception);  
        );
        }
                ActionListener<GetSegmentFilesResponse> listener  
        );
        };  
            assertEquals(indexShard, spyIndexShard);
import java.util.ArrayList;  
            }
    public void tearDown() throws Exception {
        }
import static org.mockito.Mockito.mock;
     * @param docCount the number of documents to index in the first snapshot
                assertEquals(  
        SegmentReplicationTargetService.SegmentReplicationListener segRepListener = mock(  
        segrepTarget = new SegmentReplicationTarget(spyIndexShard, repCheckpoint, segrepSource, segRepListener);
import org.mockito.Mockito;
            @Override
                IndexShard indexShard,
                exceptions.add(e);
        }, mock(BiConsumer.class));
                ReplicationCheckpoint checkpoint,
    }
     * Test that stale checkpoint is accepted during recovery when shard is initializing.
import org.opensearch.index.store.Store;
        SegmentReplicationSource segrepSource = new TestReplicationSource() {
                BiConsumer<String, Long> fileProgressTracker,
                ActionListener<GetSegmentFilesResponse> listener
import java.util.Arrays;
            public void getCheckpointMetadata(
                );  
                long replicationId,
            repCheckpoint.getCodec()  
        Random random = new Random(seed);
        };  
                listener.onResponse(new CheckpointInfoResponse(repCheckpoint, SI_SNAPSHOT, buffer.toArrayCopy()));  
                ActionListener<CheckpointInfoResponse> listener
                long replicationId,
    public void testFailure_finalizeReplication_NonCorruptionException() throws IOException {  
                ActionListener<CheckpointInfoResponse> listener  
        }
                        .filter(ReplicationLuceneIndex.FileMetadata::fullyRecovered)
            public void getCheckpointMetadata(
        });
        SegmentReplicationSource segrepSource = new TestReplicationSource() {
            }
            }  
import org.opensearch.cluster.routing.ShardRouting;
import org.apache.lucene.index.IndexFormatTooNewException;
            repCheckpoint.getSegmentsGen(),
 * this file be licensed under the Apache-2.0 license or a
        ShardRouting mockRouting = mock(ShardRouting.class);  
import static org.mockito.Mockito.verify;
        SegmentReplicationTargetService.SegmentReplicationListener segRepListener = mock(
                        1,  
            @Override  
        SegmentReplicationTargetService.SegmentReplicationListener segRepListener = mock(
            @Override
    }  
                        .stream()
    }  
                    segrepTarget.state()  
                ReplicationCheckpoint checkpoint,  
            }
import org.apache.lucene.document.Document;
import java.nio.file.NoSuchFileException;
 *
import org.apache.lucene.document.Field;
        buffer = new ByteBuffersDataOutput();
            public void onFailure(Exception e) {
                ReplicationCheckpoint checkpoint,  
            public void onResponse(Void replicationResponse) {
                long replicationId,  
            @Override  
                ReplicationCheckpoint checkpoint,  
            Document document = new Document();  
    private IndexShard indexShard, spyIndexShard;
        for (String file : files) {
        SegmentReplicationSource segrepSource = new TestReplicationSource() {
                assertTrue(e instanceof ReplicationFailedException);  
            repCheckpoint.getShardId(),
                try {  
            @Override
                assertTrue(e.getMessage().contains("Rejecting stale metadata checkpoint"));
                        segrepTarget.state()
            public void getSegmentFiles(
                long replicationId,
                long replicationId,  
            @Override  
        writer.close();  
        SegmentReplicationTargetService.SegmentReplicationListener segRepListener = mock(
            }
        writer.deleteDocuments(new Term("id", Integer.toString(random().nextInt(docCount))));
                    assertEquals(
            ) {
    public void test_MissingFiles_NotCausingFailure() throws IOException {  
        IndexFormatTooNewException exception = new IndexFormatTooNewException("string", 1, 2, 1);
                List<StoreFileMetadata> filesToFetch,
        final List<IOException> exceptions = new ArrayList<>();
            @Override  
                IndexShard indexShard,
        );  
                listener.onResponse(new GetSegmentFilesResponse(filesToFetch));  
import org.opensearch.index.store.StoreFileMetadata;
                assertEquals(exception, e.getCause().getCause());  
        );  
import org.apache.lucene.index.NoMergePolicy;
     * Generates a list of Store.MetadataSnapshot with two elements where second snapshot has extra files due to delete  
        segrepTarget = new SegmentReplicationTarget(spyIndexShard, repCheckpoint, segrepSource, segRepListener);  
import org.opensearch.common.settings.Settings;  
                        .stream()  
        closeShards(spyIndexShard, indexShard);
            ) {
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;  
                    segrepTarget.markAsDone();  
            @Override
            indexShard.getLatestReplicationCheckpoint().getCodec()
            ) {
        int docCount = 1 + random().nextInt(10);
                segrepTarget.fail(new ReplicationFailedException(e), false);  
                Assert.fail();  
            }
import org.junit.Assert;
            public void onFailure(Exception e) {
            writer.addDocument(d);  
    private static final IndexSettings INDEX_SETTINGS = IndexSettingsModule.newIndexSettings(
        long seed = random().nextLong();  
            @Override
                    0,
                ReplicationCheckpoint checkpoint,
        super.setUp();  
            testSegmentInfos.write(indexOutput);
            }
                // ignore  
            public void onResponse(Void replicationResponse) {  
        ReplicationCheckpoint newerCheckpoint = new ReplicationCheckpoint(
                ReplicationCheckpoint checkpoint,  
        // snapshot (2nd element which contains delete operations) and replica's existing snapshot (1st element).
import org.apache.lucene.util.Version;
            @Override  
        Store.MetadataSnapshot storeMetadata = store.getMetadata();  
                ActionListener<CheckpointInfoResponse> listener
        }, (ReplicationCheckpoint checkpoint, IndexShard indexShard) -> {
                    verify(spyIndexShard, times(1)).finalizeReplication(any(CatalogSnapshot.class));
            SegmentReplicationTargetService.SegmentReplicationListener.class
    public void setUp() throws Exception {
                IndexShard indexShard,
        SegmentReplicationTargetService.SegmentReplicationListener segRepListener = mock(
            document.add(new TextField("str", text, Field.Store.YES));  
            @Override  
            public void onResponse(Void replicationResponse) {
        Exception exception = new Exception("dummy failure");
            public void getCheckpointMetadata(  
                Assert.fail();  
            ) {
            .build();
            }
import org.opensearch.index.IndexSettings;  
            SegmentReplicationTargetService.SegmentReplicationListener.class  
        Exception exception = new Exception("dummy failure");  
                // Success - stale checkpoint was accepted during recovery  
 */  
        for (Document d : docList) {
                segrepTarget.fail(new ReplicationFailedException(e), false);
                IndexShard indexShard,
                long replicationId,
    }  
            public void getSegmentFiles(
                listener.onResponse(new GetSegmentFilesResponse(filesToFetch));  
import org.opensearch.index.store.StoreTests;  
                ReplicationCheckpoint checkpoint,
    }  
            public void getCheckpointMetadata(
        );
                directory.deleteFile(file);
            @Override  
                    0,
            repCheckpoint.getShardId(),  
    }
                IndexShard indexShard,  
import org.apache.lucene.index.IndexWriterConfig;
        writer.commit();
                        .filter(ReplicationLuceneIndex.FileMetadata::fullyRecovered)  
        // Start replication - should succeed despite stale checkpoint
                BiConsumer<String, Long> fileProgressTracker,  
    /**
                ReplicationCheckpoint checkpoint,  
                ReplicationCheckpoint checkpoint,  
                ActionListener<GetSegmentFilesResponse> listener
        // generated due to delete operations. These two snapshots can then be used in test to mock the primary shard  
        when(spyIndexShard.getSegmentMetadataMap()).thenReturn(storeMetadataSnapshots.get(0).asMap());
            @Override  
                long replicationId,
    public void testFailureResponse_getCheckpointMetadata() {
            @Override
     * @throws IOException if an indexing operation fails or segment replication fails
import org.apache.lucene.store.ByteBuffersIndexOutput;  
     */
        IndexWriterConfig iwc = new IndexWriterConfig(new MockAnalyzer(random)).setCodec(TestUtil.getDefaultCodec());
                assertEquals(1, filesToFetch.size());  
            }  
            public void onFailure(Exception e) {  
    @Override  
        segrepTarget = new SegmentReplicationTarget(spyIndexShard, repCheckpoint, segrepSource, segRepListener);  
            ) {
                ReplicationCheckpoint checkpoint,  
                ReplicationCheckpoint checkpoint,  
    }
            @Override  
        }, mock(BiConsumer.class));  
                ReplicationCheckpoint checkpoint,
import org.opensearch.index.replication.TestReplicationSource;
                            .getIndex()
            200L, // higher segmentInfosVersion  
    private static final StoreFileMetadata SEGMENT_FILE_DIFF = new StoreFileMetadata(SEGMENT_NAME, 5L, "different", Version.LATEST);
        return Arrays.asList(storeMetadata, storeMetadataWithDeletes);
    /**
                BiConsumer<String, Long> fileProgressTracker,
    @Override
        segrepTarget = new SegmentReplicationTarget(spyIndexShard, newerCheckpoint, segrepSource, segRepListener);  
        SegmentReplicationSource segrepSource = new TestReplicationSource() {
            public void getCheckpointMetadata(
    }  
            }
            @Override  
 * SPDX-License-Identifier: Apache-2.0
        super.tearDown();  
            assertEquals(repCheckpoint, checkpoint);  
import static org.mockito.Mockito.doThrow;
import static org.mockito.ArgumentMatchers.any;  
import org.apache.lucene.index.Term;
        };
     * operation. A list of snapshots is returned so that identical files have same checksum.
        // Create a newer checkpoint (higher segmentInfosVersion)  
        };
            ) {
                // Return the older checkpoint (repCheckpoint with version 100)
            @Override
        // Create target with newer checkpoint  
            public void getSegmentFiles(
     * @return a list of Store.MetadataSnapshot with two elements where second snapshot has extra files due to delete  
        // Source returns an older checkpoint  
import org.opensearch.OpenSearchCorruptionException;  
                            .filter(ReplicationLuceneIndex.FileMetadata::fullyRecovered)
                ReplicationCheckpoint checkpoint,
        "index",  
        );
        };
            SegmentReplicationTargetService.SegmentReplicationListener.class
import org.opensearch.index.shard.IndexShard;
    public void testStaleCheckpointAccepted_duringRecovery() throws IOException {
            }
                );  
                        .fileDetails()
import org.apache.lucene.store.Directory;
import org.opensearch.core.action.ActionListener;
        );  
                try {
                listener.onFailure(exception);
                    );
                        .count()
import org.opensearch.core.index.shard.ShardId;
                Assert.fail("Expected replication to fail due to stale checkpoint");
            ) {
                IndexShard indexShard,
        }
                assertTrue(e instanceof OpenSearchCorruptionException);
                listener.onResponse(new CheckpointInfoResponse(checkpoint, SI_SNAPSHOT, buffer.toArrayCopy()));
                    verify(spyIndexShard, times(1)).finalizeReplication(any(CatalogSnapshot.class));
                logger.info("No error processing checkpoint info");
                        .getIndex()
                listener.onResponse(new CheckpointInfoResponse(checkpoint, storeMetadataSnapshots.get(1).asMap(), buffer.toArrayCopy()));
                    Assert.fail();
import org.opensearch.index.engine.NRTReplicationEngineFactory;
                long replicationId,
                long replicationId,
 * compatible open source license.
                assertEquals(exception, e.getCause().getCause());
                ActionListener<GetSegmentFilesResponse> listener
        }, mock(BiConsumer.class));
                listener.onResponse(new CheckpointInfoResponse(checkpoint, SI_SNAPSHOT, buffer.toArrayCopy()));
    private static final StoreFileMetadata SEGMENT_FILE = new StoreFileMetadata(SEGMENT_NAME, 1L, "0", Version.LATEST);
        deleteContent(store.directory());
            ) {
        // Delete one document to generate .liv file
            }  
            @Override  
    private static void deleteContent(Directory directory) throws IOException {
            public void onResponse(Void replicationResponse) {
            testSegmentInfos.getGeneration(),  
import java.util.Map;  
            public void onResponse(Void replicationResponse) {
            }  
        List<Store.MetadataSnapshot> storeMetadataSnapshots = generateStoreMetadataSnapshot(docCount);
            ) {  
                );
import org.apache.lucene.index.SegmentInfos;  
            @Override
    private ByteBuffersDataOutput buffer;
                Assert.fail("Replication should succeed during recovery despite stale checkpoint: " + e.getMessage());
import java.util.List;
                // Return the older checkpoint (repCheckpoint with version 100)  
                Assert.fail();
    }
        // Create a newer checkpoint (higher segmentInfosVersion)
                List<StoreFileMetadata> filesToFetch,  
        ExceptionsHelper.rethrowAndSuppress(exceptions);
        final String[] files = directory.listAll();  
            }  
                logger.error("Unexpected onFailure", e);
                        .getIndex()  
        spyIndexShard = spy(indexShard);
                filesToFetch.forEach(storeFileMetadata -> fileProgressTracker.accept(storeFileMetadata.name(), storeFileMetadata.length()));
        SegmentReplicationSource segrepSource = new TestReplicationSource() {
     * Addresses: https://github.com/opensearch-project/OpenSearch/issues/19234  
import org.opensearch.indices.replication.common.ReplicationType;
        SegmentReplicationSource segrepSource = new TestReplicationSource() {  
import org.apache.lucene.document.StringField;  
    private static final Map<String, StoreFileMetadata> SI_SNAPSHOT_DIFFERENT = Map.of(SEGMENT_FILE_DIFF.name(), SEGMENT_FILE_DIFF);  
import org.apache.lucene.store.ByteBuffersDataOutput;
                ReplicationCheckpoint checkpoint,
            SegmentReplicationTargetService.SegmentReplicationListener.class  
    );
        Mockito.doNothing().when(spyIndexShard).finalizeReplication(any(CatalogSnapshot.class));  
import org.opensearch.indices.replication.common.ReplicationFailedException;
                assertEquals(
        when(mockRouting.relocating()).thenReturn(false);  
            @Override  
        }, mock(BiConsumer.class));  
                List<StoreFileMetadata> filesToFetch,
public class SegmentReplicationTargetTests extends IndexShardTestCase {
        segrepTarget.startReplication(new ActionListener<Void>() {
            public void onFailure(Exception e) {
            @Override
            public void getSegmentFiles(
        segrepTarget = new SegmentReplicationTarget(spyIndexShard, repCheckpoint, segrepSource, segRepListener);
                    segrepTarget.markAsDone();  
        IOException exception = new IOException("dummy failure");
                List<StoreFileMetadata> filesToFetch,
            ) {  
                ActionListener<CheckpointInfoResponse> listener  
import static org.mockito.Mockito.times;
                ActionListener<GetSegmentFilesResponse> listener  
    private SegmentInfos testSegmentInfos;
            SegmentReplicationTargetService.SegmentReplicationListener.class
            @Override
    public void testSuccessfulResponse_startReplication() {  
        segrepTarget.startReplication(new ActionListener<Void>() {
            ) {
        writer.commit();  
                ActionListener<CheckpointInfoResponse> listener
                BiConsumer<String, Long> fileProgressTracker,  
            docList.add(document);
                    Assert.fail("Unexpected IOException: " + ex.getMessage());
                long replicationId,
                assertTrue(e.getMessage().contains("has local copies of segments that differ from the primary"));
    }
}
        );
        try (ByteBuffersIndexOutput indexOutput = new ByteBuffersIndexOutput(buffer, "", null)) {  
                ReplicationCheckpoint checkpoint,  
                segrepTarget.markAsDone();  
            }
                listener.onResponse(new CheckpointInfoResponse(checkpoint, SI_SNAPSHOT, buffer.toArrayCopy()));  
                segrepTarget.fail(new ReplicationFailedException(e), false);
import org.opensearch.test.DummyShardLock;
        // Mock ShardRouting as initializing (recovering)
            }
            repCheckpoint.getCodec()
import org.opensearch.cluster.metadata.IndexMetadata;
            200L, // higher segmentInfosVersion
            public void getSegmentFiles(
            public void getCheckpointMetadata(  
        // Mock ShardRouting as active (not initializing, not relocating)  
            ) {
                BiConsumer<String, Long> fileProgressTracker,  
                long replicationId,
            SegmentReplicationTargetService.SegmentReplicationListener.class  
        );  
            }
            @Override  
        );
                Assert.fail();
import org.apache.lucene.tests.util.TestUtil;  
            ) {  
     * Addresses: https://github.com/opensearch-project/OpenSearch/issues/18490
                long replicationId,
                        .fileDetails()
            public void onFailure(Exception e) {
            public void getCheckpointMetadata(  
                ReplicationCheckpoint checkpoint,
            repCheckpoint.getPrimaryTerm(),
        for (int i = 0; i < docCount; i++) {
                        .count()
        };
            }
                listener.onResponse(new CheckpointInfoResponse(checkpoint, SI_SNAPSHOT, buffer.toArrayCopy()));  
                long replicationId,  
                BiConsumer<String, Long> fileProgressTracker,
                ActionListener<GetSegmentFilesResponse> listener
            ) {
            }
    public void testFailure_finalizeReplication_IndexFormatException() throws IOException {
        };
        // Generate a list of MetadataSnapshot containing two elements. The second snapshot contains extra files
    }
            }
                            .fileDetails()  
        IndexWriter writer = new IndexWriter(store.directory(), iwc);
    private SegmentReplicationTarget segrepTarget;
    }  
                ActionListener<GetSegmentFilesResponse> listener
            }
            public void getSegmentFiles(  
     */
            @Override
        iwc.setMergePolicy(NoMergePolicy.INSTANCE);  
                long replicationId,
        segrepTarget = new SegmentReplicationTarget(spyIndexShard, repCheckpoint, segrepSource, segRepListener);
import java.io.FileNotFoundException;  
            }
                    segrepTarget.state()
        SegmentReplicationTargetService.SegmentReplicationListener segRepListener = mock(
            @Override
            public void getSegmentFiles(  
                    0,
        List<Document> docList = new ArrayList<>();
                listener.onResponse(new CheckpointInfoResponse(checkpoint, SI_SNAPSHOT, buffer.toArrayCopy()));  
                listener.onResponse(new GetSegmentFilesResponse(filesToFetch));
        ShardRouting mockRouting = mock(ShardRouting.class);
                List<StoreFileMetadata> filesToFetch,
            public void getCheckpointMetadata(
import org.opensearch.indices.replication.common.ReplicationLuceneIndex;  
                }  
                segrepTarget.fail(new ReplicationFailedException(e), false);
            } catch (NoSuchFileException | FileNotFoundException e) {
 * The OpenSearch Contributors require contributions made to  
            public void onFailure(Exception e) {  
                assertEquals(exception, e.getCause());
                listener.onResponse(new GetSegmentFilesResponse(filesToFetch));
        Settings indexSettings = Settings.builder()
            @Override  
                BiConsumer<String, Long> fileProgressTracker,  
        iwc.setUseCompoundFile(true);
        };
        when(spyIndexShard.routingEntry()).thenReturn(mockRouting);  
            @Override
                segrepTarget.fail(new ReplicationFailedException(e), false);
            @Override
import static org.mockito.Mockito.when;  
                long replicationId,
        when(spyIndexShard.getSegmentMetadataMap()).thenReturn(SI_SNAPSHOT_DIFFERENT);
        testSegmentInfos = spyIndexShard.store().readLastCommittedSegmentsInfo();
        // Source returns an older checkpoint
            public void onResponse(Void replicationResponse) {  
        segrepTarget.startReplication(new ActionListener<Void>() {
                    );
            SegmentReplicationTargetService.SegmentReplicationListener.class
    public void testFailureResponse_getSegmentFiles() {
            } catch (IOException e) {
        segrepTarget = new SegmentReplicationTarget(spyIndexShard, newerCheckpoint, segrepSource, segRepListener);
    public void testFailure_differentSegmentFiles() throws IOException {  
                listener.onResponse(new GetSegmentFilesResponse(filesToFetch));  
                ActionListener<GetSegmentFilesResponse> listener
                        0,  
            ) {
                    segrepTarget.state()  
            public void getCheckpointMetadata(
            public void onFailure(Exception e) {
        doThrow(exception).when(spyIndexShard).finalizeReplication(any(CatalogSnapshot.class));  
        );
    }
                ActionListener<CheckpointInfoResponse> listener  
                listener.onResponse(new GetSegmentFilesResponse(filesToFetch));  
            }
                List<StoreFileMetadata> filesToFetch,
        Store store = new Store(shardId, INDEX_SETTINGS, StoreTests.newDirectory(random()), new DummyShardLock(shardId));  
        };
            }
        segrepTarget = new SegmentReplicationTarget(spyIndexShard, repCheckpoint, segrepSource, segRepListener);  
            repCheckpoint.getSegmentsGen(),
        when(mockRouting.initializing()).thenReturn(false);
        SegmentReplicationTargetService.SegmentReplicationListener segRepListener = mock(  
                BiConsumer<String, Long> fileProgressTracker,  
        }, mock(BiConsumer.class));
                ReplicationCheckpoint checkpoint,  
            @Override
        segrepTarget.startReplication(new ActionListener<Void>() {  
            ) {
                long replicationId,
            ) {
            try {  
        ReplicationCheckpoint newerCheckpoint = new ReplicationCheckpoint(
                            .stream()
        final ShardId shardId = new ShardId("index", "_na_", 1);
                }  
                long replicationId,
                } catch (IOException ex) {
     */
                        .count()
                ActionListener<CheckpointInfoResponse> listener
                IndexShard indexShard,
            spyIndexShard.getPendingPrimaryTerm(),
        segrepTarget = new SegmentReplicationTarget(spyIndexShard, repCheckpoint, segrepSource, segRepListener);  
import static org.mockito.Mockito.spy;  
                List<StoreFileMetadata> filesToFetch,  
        segrepTarget.startReplication(new ActionListener<Void>() {  
        // Create target with newer checkpoint
                listener.onResponse(new GetSegmentFilesResponse(filesToFetch));
    /**
            String text = new String(new char[] { (char) (97 + i), (char) (97 + i) });
        when(spyIndexShard.routingEntry()).thenReturn(mockRouting);
        }, mock(BiConsumer.class));
            }  
                long replicationId,
        segrepTarget.startReplication(new ActionListener<Void>() {
        doThrow(exception).when(spyIndexShard).finalizeReplication(any(CatalogSnapshot.class));
            @Override
            public void onResponse(Void replicationResponse) {  
            public void onFailure(Exception e) {
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
            }  
                listener.onResponse(new CheckpointInfoResponse(repCheckpoint, SI_SNAPSHOT, buffer.toArrayCopy()));
            }
            }
            }
        );
            }
                        .fileDetails()
            }
            }  
        segrepTarget.startReplication(new ActionListener<Void>() {
                        segrepTarget.state().getIndex().fileDetails().stream().filter(file -> file.fullyRecovered() == false).count()
            spyIndexShard.shardId(),
import org.opensearch.index.shard.IndexShardTestCase;  
/*  
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
            document.add(new StringField("id", "" + i, random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
                Assert.fail();
import org.opensearch.test.IndexSettingsModule;  
            @Override
        }, mock(BiConsumer.class));
        repCheckpoint = new ReplicationCheckpoint(  
    private static final Map<String, StoreFileMetadata> SI_SNAPSHOT = Map.of(SEGMENT_FILE.name(), SEGMENT_FILE);
            public void getSegmentFiles(
import org.apache.lucene.document.TextField;
            public void onFailure(Exception e) {  
        when(mockRouting.relocating()).thenReturn(false);
                } catch (IOException ex) {
            }  
        indexShard = newStartedShard(false, indexSettings, new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()));  
                listener.onResponse(new GetSegmentFilesResponse(filesToFetch));  
        segrepTarget.startReplication(new ActionListener<Void>() {
            public void getSegmentFiles(
    private List<Store.MetadataSnapshot> generateStoreMetadataSnapshot(int docCount) throws IOException {  
     * This tests ensures that new files generated on primary (due to delete operation) are not considered missing on replica  
        SegmentReplicationSource segrepSource = new TestReplicationSource() {
    private ReplicationCheckpoint repCheckpoint;  
import org.opensearch.ExceptionsHelper;
     */
            }
        // Start replication - should fail due to stale checkpoint  
                        .filter(ReplicationLuceneIndex.FileMetadata::fullyRecovered)
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
            SegmentReplicationTargetService.SegmentReplicationListener.class
                List<StoreFileMetadata> filesToFetch,
    private static final String SEGMENT_NAME = "_0.si";  
                List<StoreFileMetadata> filesToFetch,
     * Test that stale checkpoint is rejected during normal replication when shard is active.  
        store.close();
import org.apache.lucene.index.IndexWriter;  
                logger.error("Unexpected onFailure", e);
                        .getIndex()
                    assertEquals(
    /**
            @Override  
                        .stream()  
            .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
            @Override  
