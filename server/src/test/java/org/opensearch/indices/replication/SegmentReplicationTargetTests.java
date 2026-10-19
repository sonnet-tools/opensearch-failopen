        SegmentReplicationTargetService.SegmentReplicationListener segRepListener = mock(
                IndexShard indexShard,
import org.opensearch.indices.replication.common.ReplicationLuceneIndex;
            public void getCheckpointMetadata(
            public void getSegmentFiles(
        segrepTarget = new SegmentReplicationTarget(spyIndexShard, newerCheckpoint, segrepSource, segRepListener);
                listener.onResponse(new GetSegmentFilesResponse(filesToFetch));
import org.opensearch.cluster.metadata.IndexMetadata;
        }, mock(BiConsumer.class));
        };
        for (int i = 0; i < docCount; i++) {
        segrepTarget = new SegmentReplicationTarget(spyIndexShard, repCheckpoint, segrepSource, segRepListener);
                ActionListener<GetSegmentFilesResponse> listener
                BiConsumer<String, Long> fileProgressTracker,
                        segrepTarget.state()
                ReplicationCheckpoint checkpoint,
                ActionListener<GetSegmentFilesResponse> listener
                BiConsumer<String, Long> fileProgressTracker,
        ExceptionsHelper.rethrowAndSuppress(exceptions);
            public void getCheckpointMetadata(
        );
        );
import java.util.ArrayList;
            SegmentReplicationTargetService.SegmentReplicationListener.class
        }, mock(BiConsumer.class));
            @Override
            @Override
                }
            }
            @Override
            @Override
    public void testStaleCheckpointAccepted_duringRecovery() throws IOException {
            }
        store.close();
import java.util.Random;
        );
                ReplicationCheckpoint checkpoint,
            public void onResponse(Void replicationResponse) {
        when(spyIndexShard.getSegmentMetadataMap()).thenReturn(storeMetadataSnapshots.get(0).asMap());
            ) {
                ReplicationCheckpoint checkpoint,
            public void onResponse(Void replicationResponse) {
import static org.mockito.ArgumentMatchers.any;
                ActionListener<GetSegmentFilesResponse> listener
                ActionListener<CheckpointInfoResponse> listener
                ActionListener<GetSegmentFilesResponse> listener
                IndexShard indexShard,
                    assertEquals(
                IndexShard indexShard,
import java.io.IOException;
                long replicationId,
            public void onResponse(Void replicationResponse) {
                assertTrue(e instanceof ReplicationFailedException);
        SegmentReplicationTargetService.SegmentReplicationListener segRepListener = mock(
                assertEquals(exception, e.getCause());
        segrepTarget = new SegmentReplicationTarget(spyIndexShard, repCheckpoint, segrepSource, segRepListener);
import java.io.FileNotFoundException;
        super.setUp();
            }
            public void getSegmentFiles(
                long replicationId,
        SegmentReplicationSource segrepSource = new TestReplicationSource() {
            @Override
        IndexWriterConfig iwc = new IndexWriterConfig(new MockAnalyzer(random)).setCodec(TestUtil.getDefaultCodec());
        Settings indexSettings = Settings.builder()
            }
        // Start replication - should fail due to stale checkpoint
    public void testFailureResponse_getSegmentFiles() {
            try {
    }
                ReplicationCheckpoint checkpoint,
                listener.onResponse(new GetSegmentFilesResponse(filesToFetch));
                            .filter(ReplicationLuceneIndex.FileMetadata::fullyRecovered)
     * Generates a list of Store.MetadataSnapshot with two elements where second snapshot has extra files due to delete
            public void onResponse(Void replicationResponse) {
    private static final IndexSettings INDEX_SETTINGS = IndexSettingsModule.newIndexSettings(
                long replicationId,
                listener.onResponse(new CheckpointInfoResponse(repCheckpoint, SI_SNAPSHOT, buffer.toArrayCopy()));
            public void getSegmentFiles(
                IndexShard indexShard,
                        .getIndex()
            @Override
import org.apache.lucene.store.ByteBuffersDataOutput;
                BiConsumer<String, Long> fileProgressTracker,
     */
        // Start replication - should succeed despite stale checkpoint
                long replicationId,
            public void getCheckpointMetadata(
import org.apache.lucene.store.ByteBuffersIndexOutput;
import org.apache.lucene.index.NoMergePolicy;
import org.opensearch.indices.replication.common.ReplicationType;
import org.apache.lucene.tests.analysis.MockAnalyzer;
                    assertEquals(
    public void testStaleCheckpointRejected_duringNormalReplication() throws IOException {
            }
            }
                // Success - stale checkpoint was accepted during recovery
            public void onFailure(Exception e) {
                        1,
import org.apache.lucene.util.Version;
                BiConsumer<String, Long> fileProgressTracker,
        SegmentReplicationTargetService.SegmentReplicationListener segRepListener = mock(
            ) {
                ActionListener<GetSegmentFilesResponse> listener
            ) {
import org.apache.lucene.tests.util.TestUtil;
                assertTrue(e.getMessage().contains("Rejecting stale metadata checkpoint"));
            }
        Random random = new Random(seed);
import org.opensearch.OpenSearchCorruptionException;
            200L, // higher segmentInfosVersion
        segrepTarget = new SegmentReplicationTarget(spyIndexShard, repCheckpoint, segrepSource, segRepListener);
            @Override
        Store.MetadataSnapshot storeMetadataWithDeletes = store.getMetadata();
                        .count()
                List<StoreFileMetadata> filesToFetch,
            repCheckpoint.getCodec()
                assert (filesToFetch.contains(SEGMENT_FILE));
import org.opensearch.test.IndexSettingsModule;
        when(mockRouting.initializing()).thenReturn(true);
            .build();
                listener.onResponse(new CheckpointInfoResponse(checkpoint, storeMetadataSnapshots.get(1).asMap(), buffer.toArrayCopy()));
            public void getSegmentFiles(
                exceptions.add(e);
            SegmentReplicationTargetService.SegmentReplicationListener.class
import org.opensearch.common.settings.Settings;
                ActionListener<CheckpointInfoResponse> listener
            ) {
            @Override
        closeShards(spyIndexShard, indexShard);
            @Override
        when(mockRouting.relocating()).thenReturn(false);
import org.apache.lucene.index.Term;
                segrepTarget.fail(new ReplicationFailedException(e), false);
import org.apache.lucene.index.IndexWriterConfig;
                    Assert.fail("Unexpected IOException: " + ex.getMessage());
                    segrepTarget.markAsDone();
                listener.onResponse(new GetSegmentFilesResponse(filesToFetch));
     * @return a list of Store.MetadataSnapshot with two elements where second snapshot has extra files due to delete
                segrepTarget.fail(new ReplicationFailedException(e), false);
                ReplicationCheckpoint checkpoint,
        when(mockRouting.initializing()).thenReturn(false);
import java.util.Arrays;
                ActionListener<CheckpointInfoResponse> listener
                long replicationId,
            public void getSegmentFiles(
import org.opensearch.core.action.ActionListener;
import org.opensearch.index.engine.NRTReplicationEngineFactory;
                ActionListener<CheckpointInfoResponse> listener
        };
        List<Store.MetadataSnapshot> storeMetadataSnapshots = generateStoreMetadataSnapshot(docCount);
        deleteContent(store.directory());
            ) {
import org.opensearch.ExceptionsHelper;
                listener.onFailure(exception);
        // Delete one document to generate .liv file
            assertEquals(indexShard, spyIndexShard);
            docList.add(document);
            @Override
        // Mock ShardRouting as initializing (recovering)
            @Override
                ActionListener<GetSegmentFilesResponse> listener
import static org.mockito.Mockito.spy;
        testSegmentInfos = spyIndexShard.store().readLastCommittedSegmentsInfo();
        segrepTarget = new SegmentReplicationTarget(spyIndexShard, repCheckpoint, segrepSource, segRepListener);
    /**
import org.apache.lucene.document.Field;
            writer.addDocument(d);
        );
import java.util.function.BiConsumer;
                ActionListener<CheckpointInfoResponse> listener
        final String[] files = directory.listAll();
                    Assert.fail();
                assertEquals(1, filesToFetch.size());
    private static final Map<String, StoreFileMetadata> SI_SNAPSHOT = Map.of(SEGMENT_FILE.name(), SEGMENT_FILE);
        }
            SegmentReplicationTargetService.SegmentReplicationListener.class
            public void getCheckpointMetadata(
                assertEquals(
            @Override
                IndexShard indexShard,
                listener.onResponse(new GetSegmentFilesResponse(filesToFetch));
        // Create a newer checkpoint (higher segmentInfosVersion)
        }
            @Override
import org.opensearch.core.index.shard.ShardId;
            }
                assertEquals(
                        .getIndex()
                Assert.fail("Replication should succeed during recovery despite stale checkpoint: " + e.getMessage());
                ReplicationCheckpoint checkpoint,
            } catch (NoSuchFileException | FileNotFoundException e) {
        SegmentReplicationTargetService.SegmentReplicationListener segRepListener = mock(
    private ReplicationCheckpoint repCheckpoint;
        );
                segrepTarget.fail(new ReplicationFailedException(e), false);
            indexShard.getLatestReplicationCheckpoint().getCodec()
    }
        spyIndexShard = spy(indexShard);
            public void onFailure(Exception e) {
            @Override
                ReplicationCheckpoint checkpoint,
import org.opensearch.index.store.StoreTests;
        final ShardId shardId = new ShardId("index", "_na_", 1);
            @Override
                listener.onFailure(exception);
        segrepTarget.startReplication(new ActionListener<Void>() {
            testSegmentInfos.write(indexOutput);
        segrepTarget.startReplication(new ActionListener<Void>() {
        // Create target with newer checkpoint
    );
import org.opensearch.index.shard.IndexShard;
        SegmentReplicationSource segrepSource = new TestReplicationSource() {
    private static final Map<String, StoreFileMetadata> SI_SNAPSHOT_DIFFERENT = Map.of(SEGMENT_FILE_DIFF.name(), SEGMENT_FILE_DIFF);
            public void onFailure(Exception e) {
     * This tests ensures that new files generated on primary (due to delete operation) are not considered missing on replica
            }
                        segrepTarget.state().getIndex().fileDetails().stream().filter(file -> file.fullyRecovered() == false).count()
            }
            }
 * compatible open source license.
                List<StoreFileMetadata> filesToFetch,
            repCheckpoint.getShardId(),
     */
                    0,
                long replicationId,
            }
                ReplicationCheckpoint checkpoint,
        return Arrays.asList(storeMetadata, storeMetadataWithDeletes);
import org.opensearch.index.shard.IndexShardTestCase;
            SegmentReplicationTargetService.SegmentReplicationListener.class
            @Override
    private static final StoreFileMetadata SEGMENT_FILE_DIFF = new StoreFileMetadata(SEGMENT_NAME, 5L, "different", Version.LATEST);
        indexShard = newStartedShard(false, indexSettings, new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()));
            repCheckpoint.getSegmentsGen(),
import org.mockito.Mockito;
                List<StoreFileMetadata> filesToFetch,
            assertEquals(repCheckpoint, checkpoint);
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
            }
     * operation. A list of snapshots is returned so that identical files have same checksum.
                        .count()
                        .stream()
                List<StoreFileMetadata> filesToFetch,
        iwc.setUseCompoundFile(true);
 *
    @Override
    /**
                ActionListener<GetSegmentFilesResponse> listener
                listener.onResponse(new GetSegmentFilesResponse(filesToFetch));
        segrepTarget.startReplication(new ActionListener<Void>() {
            }
            }
            SegmentReplicationTargetService.SegmentReplicationListener.class
    private static final String SEGMENT_NAME = "_0.si";
            document.add(new StringField("id", "" + i, random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
import static org.mockito.Mockito.doThrow;
            }
                listener.onResponse(new CheckpointInfoResponse(checkpoint, SI_SNAPSHOT, buffer.toArrayCopy()));
            }
                ActionListener<CheckpointInfoResponse> listener
                assertEquals(exception, e.getCause().getCause());
                long replicationId,
            repCheckpoint.getPrimaryTerm(),
import org.opensearch.index.IndexSettings;
            }
            @Override
            @Override
                long replicationId,
    }
        segrepTarget.startReplication(new ActionListener<Void>() {
            SegmentReplicationTargetService.SegmentReplicationListener.class
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        };
import org.apache.lucene.store.Directory;
        // snapshot (2nd element which contains delete operations) and replica's existing snapshot (1st element).
                IndexShard indexShard,
                    segrepTarget.state()
                long replicationId,
}
            @Override
        int docCount = 1 + random().nextInt(10);
        writer.commit();
                );
    public void testSuccessfulResponse_startReplication() {
        // Create a newer checkpoint (higher segmentInfosVersion)
            }
                Assert.fail();
    private IndexShard indexShard, spyIndexShard;
                try {
                listener.onResponse(new CheckpointInfoResponse(repCheckpoint, SI_SNAPSHOT, buffer.toArrayCopy()));
        SegmentReplicationSource segrepSource = new TestReplicationSource() {
        Mockito.doNothing().when(spyIndexShard).finalizeReplication(any(CatalogSnapshot.class));
        SegmentReplicationSource segrepSource = new TestReplicationSource() {
        segrepTarget = new SegmentReplicationTarget(spyIndexShard, repCheckpoint, segrepSource, segRepListener);
            @Override
                ReplicationCheckpoint checkpoint,
                BiConsumer<String, Long> fileProgressTracker,
            }
        );
            String text = new String(new char[] { (char) (97 + i), (char) (97 + i) });
                        .count()
import java.util.Map;
                logger.error("Unexpected onFailure", e);
    public void testFailure_finalizeReplication_NonCorruptionException() throws IOException {
                        .filter(ReplicationLuceneIndex.FileMetadata::fullyRecovered)
     * @param docCount the number of documents to index in the first snapshot
            repCheckpoint.getShardId(),
                ReplicationCheckpoint checkpoint,
            }
            public void onFailure(Exception e) {
        SegmentReplicationSource segrepSource = new TestReplicationSource() {
     * @throws IOException if an indexing operation fails or segment replication fails
                assertEquals(exception, e.getCause().getCause());
            public void onFailure(Exception e) {
                listener.onResponse(new GetSegmentFilesResponse(filesToFetch));
        }, mock(BiConsumer.class));
                ActionListener<CheckpointInfoResponse> listener
                );
            public void getCheckpointMetadata(
                        .getIndex()
    public void tearDown() throws Exception {
            public void getSegmentFiles(
            }
        ShardRouting mockRouting = mock(ShardRouting.class);
import org.apache.lucene.document.TextField;
import org.junit.Assert;
            }
                    );
import org.apache.lucene.index.SegmentInfos;
                segrepTarget.fail(new ReplicationFailedException(e), false);
            repCheckpoint.getCodec()
            ) {
        SegmentReplicationTargetService.SegmentReplicationListener segRepListener = mock(
                        .fileDetails()
            }
            ) {
            public void getCheckpointMetadata(
                assertTrue(e instanceof OpenSearchCorruptionException);
    public void testFailure_differentSegmentFiles() throws IOException {
        };
                            .getIndex()
    /**
            @Override
                ReplicationCheckpoint checkpoint,
        writer.close();
        final List<IOException> exceptions = new ArrayList<>();
    private ByteBuffersDataOutput buffer;
            ) {
                // ignore
        // Create target with newer checkpoint
                IndexShard indexShard,
        try (ByteBuffersIndexOutput indexOutput = new ByteBuffersIndexOutput(buffer, "", null)) {
        SegmentReplicationTargetService.SegmentReplicationListener segRepListener = mock(
        writer.commit();
                assertEquals(exception, e.getCause());
            public void onFailure(Exception e) {
            ) {
     * Test that stale checkpoint is accepted during recovery when shard is initializing.
                            .fileDetails()
 * this file be licensed under the Apache-2.0 license or a
            testSegmentInfos.version,
        );
            }
            public void onResponse(Void replicationResponse) {
            @Override
            ) {
        );
        // Source returns an older checkpoint
/*
            document.add(new TextField("str", text, Field.Store.YES));
                ReplicationCheckpoint checkpoint,
            @Override
        doThrow(exception).when(spyIndexShard).finalizeReplication(any(CatalogSnapshot.class));
import org.apache.lucene.index.IndexWriter;
                    0,
                BiConsumer<String, Long> fileProgressTracker,
        Store store = new Store(shardId, INDEX_SETTINGS, StoreTests.newDirectory(random()), new DummyShardLock(shardId));
            ) {
        SegmentReplicationTargetService.SegmentReplicationListener segRepListener = mock(
    }
            .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
    }
import org.apache.lucene.document.StringField;
    private SegmentInfos testSegmentInfos;
                ReplicationCheckpoint checkpoint,
    }
        doThrow(exception).when(spyIndexShard).finalizeReplication(any(CatalogSnapshot.class));
import org.opensearch.cluster.routing.ShardRouting;
                // Return the older checkpoint (repCheckpoint with version 100)
            testSegmentInfos.getGeneration(),
                logger.info("No error processing checkpoint info");
        writer.deleteDocuments(new Term("id", Integer.toString(random().nextInt(docCount))));
     * Test that stale checkpoint is rejected during normal replication when shard is active.
                    segrepTarget.state()
        segrepTarget = new SegmentReplicationTarget(spyIndexShard, newerCheckpoint, segrepSource, segRepListener);
import static org.mockito.Mockito.mock;
     * Addresses: https://github.com/opensearch-project/OpenSearch/issues/19234
            @Override
                Assert.fail("Expected replication to fail due to stale checkpoint");
                segrepTarget.markAsDone();
                segrepTarget.fail(new ReplicationFailedException(e), false);
    @Override
                listener.onResponse(new CheckpointInfoResponse(checkpoint, SI_SNAPSHOT, buffer.toArrayCopy()));
        };
            @Override
                long replicationId,
        }, mock(BiConsumer.class));
                List<StoreFileMetadata> filesToFetch,
import org.opensearch.index.replication.TestReplicationSource;
        when(spyIndexShard.getSegmentMetadataMap()).thenReturn(SI_SNAPSHOT_DIFFERENT);
    }
    /**
    }
            }
                long replicationId,
                        .fileDetails()
    public void testFailureResponse_getCheckpointMetadata() {
    }
        }, mock(BiConsumer.class));
        };
            }
        segrepTarget.startReplication(new ActionListener<Void>() {
    private static void deleteContent(Directory directory) throws IOException {
                    0,
            ) {
                ReplicationCheckpoint checkpoint,
            spyIndexShard.getPendingPrimaryTerm(),
        );
                IndexShard indexShard,
        Exception exception = new Exception("dummy failure");
                BiConsumer<String, Long> fileProgressTracker,
            @Override
        SegmentReplicationSource segrepSource = new TestReplicationSource() {
            @Override
    private static final StoreFileMetadata SEGMENT_FILE = new StoreFileMetadata(SEGMENT_NAME, 1L, "0", Version.LATEST);
                ActionListener<CheckpointInfoResponse> listener
        });
        segrepTarget.startReplication(new ActionListener<Void>() {
        super.tearDown();
                IndexShard indexShard,
                ReplicationCheckpoint checkpoint,
import org.opensearch.index.store.Store;
                } catch (IOException ex) {
            }
     * @throws IOException if one of the indexing operations fails
            ) {
                long replicationId,
            @Override
        }, mock(BiConsumer.class));
        // Source returns an older checkpoint
        for (String file : files) {
            public void getSegmentFiles(
            public void onResponse(Void replicationResponse) {
        }, mock(BiConsumer.class));
import org.opensearch.indices.replication.common.ReplicationFailedException;
                Assert.fail();
            @Override
            }
        }
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        segrepTarget.startReplication(new ActionListener<Void>() {
import org.apache.lucene.index.IndexFormatTooNewException;
                        0,
                    verify(spyIndexShard, times(1)).finalizeReplication(any(CatalogSnapshot.class));
                        .stream()
        buffer = new ByteBuffersDataOutput();
        Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT).build()
        SegmentReplicationSource segrepSource = new TestReplicationSource() {
                        .stream()
        IOException exception = new IOException("dummy failure");
                long replicationId,
                long replicationId,
        segrepTarget.startReplication(new ActionListener<Void>() {
            }
            @Override
                List<StoreFileMetadata> filesToFetch,
import static org.mockito.Mockito.times;
            ) {
                long replicationId,
            public void onFailure(Exception e) {
        ReplicationCheckpoint newerCheckpoint = new ReplicationCheckpoint(
        // Mock ShardRouting as active (not initializing, not relocating)
        SegmentReplicationTargetService.SegmentReplicationListener segRepListener = mock(
                directory.deleteFile(file);
        List<Document> docList = new ArrayList<>();
        IndexWriter writer = new IndexWriter(store.directory(), iwc);
            SegmentReplicationTargetService.SegmentReplicationListener.class
            SegmentReplicationTargetService.SegmentReplicationListener.class
                filesToFetch.forEach(storeFileMetadata -> fileProgressTracker.accept(storeFileMetadata.name(), storeFileMetadata.length()));
                long replicationId,
    private List<Store.MetadataSnapshot> generateStoreMetadataSnapshot(int docCount) throws IOException {
                            .stream()
                listener.onResponse(new CheckpointInfoResponse(checkpoint, SI_SNAPSHOT, buffer.toArrayCopy()));
        segrepTarget = new SegmentReplicationTarget(spyIndexShard, repCheckpoint, segrepSource, segRepListener);
                );
            public void getCheckpointMetadata(
                ActionListener<CheckpointInfoResponse> listener
        for (Document d : docList) {
                ActionListener<GetSegmentFilesResponse> listener
        IndexFormatTooNewException exception = new IndexFormatTooNewException("string", 1, 2, 1);
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
                        .fileDetails()
                } catch (IOException ex) {
                BiConsumer<String, Long> fileProgressTracker,
                Assert.fail();
            public void getCheckpointMetadata(
                assertTrue(e.getMessage().contains("has local copies of segments that differ from the primary"));
        when(mockRouting.relocating()).thenReturn(false);
                logger.error("Unexpected onFailure", e);
                listener.onResponse(new CheckpointInfoResponse(checkpoint, SI_SNAPSHOT, buffer.toArrayCopy()));
    }
            public void onResponse(Void replicationResponse) {
                BiConsumer<String, Long> fileProgressTracker,
        ShardRouting mockRouting = mock(ShardRouting.class);
import static org.mockito.Mockito.when;
    public void testFailure_finalizeReplication_IndexFormatException() throws IOException {
            }
                Assert.fail();
                Assert.fail();
                long replicationId,
                Assert.fail();
 * SPDX-License-Identifier: Apache-2.0
                    segrepTarget.markAsDone();
        iwc.setMergePolicy(NoMergePolicy.INSTANCE);
            } catch (IOException e) {
            @Override
import org.opensearch.test.DummyShardLock;
            200L, // higher segmentInfosVersion
 */
            public void getSegmentFiles(
public class SegmentReplicationTargetTests extends IndexShardTestCase {
                listener.onResponse(new GetSegmentFilesResponse(filesToFetch));
        }
            public void onFailure(Exception e) {
        "index",
            @Override
            }
            ) {
                ReplicationCheckpoint checkpoint,
        Exception exception = new Exception("dummy failure");
                Assert.fail();
            SegmentReplicationTargetService.SegmentReplicationListener.class
                        .filter(ReplicationLuceneIndex.FileMetadata::fullyRecovered)
            repCheckpoint.getPrimaryTerm(),
                ReplicationCheckpoint checkpoint,
                List<StoreFileMetadata> filesToFetch,
        repCheckpoint = new ReplicationCheckpoint(
        }, (ReplicationCheckpoint checkpoint, IndexShard indexShard) -> {
            public void getCheckpointMetadata(
            @Override
                List<StoreFileMetadata> filesToFetch,
            spyIndexShard.shardId(),
        segrepTarget = new SegmentReplicationTarget(spyIndexShard, repCheckpoint, segrepSource, segRepListener);
                    verify(spyIndexShard, times(1)).finalizeReplication(any(CatalogSnapshot.class));
            public void onResponse(Void replicationResponse) {
                long replicationId,
        );
            ) {
            }
        };
            }
                listener.onResponse(new GetSegmentFilesResponse(filesToFetch));
                List<StoreFileMetadata> filesToFetch,
        SegmentReplicationSource segrepSource = new TestReplicationSource() {
        };
        };
                // Return the older checkpoint (repCheckpoint with version 100)
    }
            @Override
            }
            }
                assertEquals(
                        .filter(ReplicationLuceneIndex.FileMetadata::fullyRecovered)
            ) {
    }
            @Override
                    segrepTarget.state()
                try {
package org.opensearch.indices.replication;
                assertEquals(ReplicationFailedException.class, e.getClass());
            ) {
                ActionListener<GetSegmentFilesResponse> listener
                }
     */
        segrepTarget.startReplication(new ActionListener<Void>() {
        when(spyIndexShard.routingEntry()).thenReturn(mockRouting);
        }, mock(BiConsumer.class));
import java.util.List;
        // generated due to delete operations. These two snapshots can then be used in test to mock the primary shard
                    );
        when(spyIndexShard.routingEntry()).thenReturn(mockRouting);
        SegmentReplicationTargetService.SegmentReplicationListener segRepListener = mock(
        ReplicationCheckpoint newerCheckpoint = new ReplicationCheckpoint(
        // Generate a list of MetadataSnapshot containing two elements. The second snapshot contains extra files
            @Override
            Document document = new Document();
import org.apache.lucene.document.Document;
            public void onFailure(Exception e) {
import org.opensearch.index.store.StoreFileMetadata;
        long seed = random().nextLong();
            }
                listener.onResponse(new CheckpointInfoResponse(checkpoint, SI_SNAPSHOT, buffer.toArrayCopy()));
    }
                segrepTarget.fail(new ReplicationFailedException(e), false);
    public void setUp() throws Exception {
        );
import java.nio.file.NoSuchFileException;
    public void test_MissingFiles_NotCausingFailure() throws IOException {
 * The OpenSearch Contributors require contributions made to
    private SegmentReplicationTarget segrepTarget;
        Store.MetadataSnapshot storeMetadata = store.getMetadata();
     * Addresses: https://github.com/opensearch-project/OpenSearch/issues/18490
                            .count()
            repCheckpoint.getSegmentsGen(),
import static org.mockito.Mockito.verify;
        );
     */
            public void getSegmentFiles(
            public void onResponse(Void replicationResponse) {
        SegmentReplicationSource segrepSource = new TestReplicationSource() {
                ReplicationCheckpoint checkpoint,
