                    latch.countDown();
        }
            nrtEngine.ensureOpen();
            assertFalse(
            nrtEngine.updateSegments(primaryInfos);
                primaryStore,
            final List<DocIdSeqNoAndSource> docs = getDocIds(engine, true);
            final Collection<String> latestPrimaryFiles = primaryEngine.getLatestSegmentInfos().files(false);
            // update replica with the latest primary infos, it will be the same gen, segments_2, ensure it is also committed.
            );
        // if the replica is already at segments_N that is received, it will commit segments_N+1.
            assertEquals(2, nrtEngine.getLastCommittedSegmentInfos().getGeneration());
            List<String> replicaFiles = List.of(nrtEngineStore.directory().listAll());
    }
                    .anyMatch(file -> file.equals("write.lock") == false && file.equals("extra0") == false)
            try (final GatedCloseable<IndexCommit> indexCommitGatedCloseable = nrtEngine.acquireLastIndexCommit(false)) {
    public void testFlushThrowsFlushFailedExceptionOnCorruption() throws Exception {
                defaultSettings,
            assertEquals(latestSegmentInfos.files(true), lastCommittedSegmentInfos.files(true));
            // copy new segments in and load reader.
        return buildNrtReplicaEngine(globalCheckpoint, store, defaultSettings, null);
            final NRTReplicationEngine nrtEngine = buildNrtReplicaEngine(globalCheckpoint, nrtEngineStore, INDEX_SETTINGS)
            final InternalEngine primaryEngine = createEngine(
            // corruption Exception. In these cases we don't expect any issue on store close.
            nrtEngine.updateSegments(engine.getLatestSegmentInfos());
                assertTrue(indexCommit.getFileNames().containsAll(lastCommittedSegmentInfos.files(true)));
                }
            final Collection<String> extraSegments = engine.getLatestSegmentInfos().files(false);
            // Copy segments from primary to replica and update
            // close the engine - ensure we preserved the last commit
import org.apache.lucene.index.NoMergePolicy;
            assertEquals(3, nrtEngine.getLastCommittedSegmentInfos().getGeneration());
            LocalCheckpointTracker localCheckpointTracker = nrtEngine.getLocalCheckpointTracker();
            final NRTReplicationEngine nrtEngine = buildNrtReplicaEngine(globalCheckpoint, nrtEngineStore, INDEX_SETTINGS, failingWarmer)
            assertEquals(latestSegmentInfos.version, lastCommittedSegmentInfos.version);
        final NRTReplicationEngine nrtEngine = buildNrtReplicaEngine(globalCheckpoint, nrtEngineStore, INDEX_SETTINGS);
            assertEquals(2, primaryInfos.getGeneration());
        }
        }
            closeThread.start();
import java.io.IOException;
            nrtEngine.updateSegments(engine.getLatestSegmentInfos());
            assertEquals(2, primaryEngine.segmentsStats(false, false).getCount());
            randomBoolean(),
            // Verify that the files contained in indexCommitGatedCloseable will not be deleted.
        ) {
            }
            Map<String, String> userData = latestSegmentInfos.getUserData();
        assertThrows(RuntimeException.class, nrtEngineStore::close);
        throws IOException {
            }
                nrtEngineStore.directory().copyFrom(primaryStore.directory(), file, file, IOContext.DEFAULT);
    private NRTReplicationEngine buildNrtReplicaEngine(AtomicLong globalCheckpoint, Store store) throws IOException {
        // store will throw when eventually closed, not handled here.
        ) {
            for (String file : latestPrimaryFiles) {
                    nrtEngineStore.directory().copyFrom(primaryStore.directory(), file, file, IOContext.DEFAULT);
    }
            final EngineConfig replicaConfig = config(
            final Store nrtEngineStore = createStore(INDEX_SETTINGS, newDirectory());
            nrtEngine.flush();
            final NRTReplicationEngine nrtEngine = buildNrtReplicaEngine(globalCheckpoint, nrtEngineStore);
import org.apache.lucene.search.ReferenceManager;
        nrtEngine.close();
                nrtEngine.replicaFileTracker.refCount(lastCommittedSegmentInfos.getSegmentsFileName())
                }
                primaryEngine.refresh("test");
            // acquire latest commit
        Lucene.cleanLuceneIndex(nrtEngine.store.directory());
        List<Engine.Operation> operations = generateHistoryOnReplica(
            final Store nrtEngineStore = createStore(INDEX_SETTINGS, newDirectory());
    public void testAcquireLastIndexCommit() throws Exception {
            final int opsCount = 2;
            // the nrt reader will still reference segments_n-1 after being loaded until a local commit occurs.
            store,
            for (Engine.Operation op : operations) {
            final Store nrtEngineStore = createStore(INDEX_SETTINGS, newDirectory());
        try (
        return buildNrtReplicaEngine(globalCheckpoint, store, settings, null);
}
            // close the NRTEngine, it will commit on close and we'll reuse its store for an IE.
    private NRTReplicationEngine buildNrtReplicaEngine(
            // we expect a 3rd segment to be created after merge.
        try (
                .collect(Collectors.toList());
            final Store nrtEngineStore = createStore(INDEX_SETTINGS, newDirectory());
        ) {
            // close snapshot, files should be cleaned up
    public void testPreserveLatestCommit() throws Exception {
            replicaFiles = List.of(nrtEngine.store.directory().listAll());
            for (int i = 0; i < 2; i++) {
    public void testRemoveExtraSegmentsOnStartup() throws Exception {
import java.util.concurrent.atomic.AtomicLong;
            // Verify both readers before and after refresh are same and no change in segments
        try (
            indexCommitGatedCloseable.close();
            null,
        ) {
                engine.translogManager().getTranslogLastWriteLocation()
                defaultSettings,
        final EngineConfig replicaConfig = config(
            final SegmentInfos previousInfos = nrtEngine.getLatestSegmentInfos();
    }
            final NRTReplicationEngine nrtEngine = buildNrtReplicaEngine(globalCheckpoint, nrtEngineStore)
                0,
            assertNotNull(warmedReaders.getFirst());
        for (String file : files) {
import java.nio.file.Path;
        Engine.Warmer warmer
            );
            assertEquals(0, warmedReaders.size());
            // get and close a snapshot - this will decref files when closed.
        try (
            final NRTReplicationEngine nrtEngine = buildNrtReplicaEngine(globalCheckpoint, nrtEngineStore, INDEX_SETTINGS)
                .stream()
            randomBoolean(),
                    nrtEngine.close();
            assertEquals(3, primaryEngine.segmentsStats(false, false).getCount());
        try (
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            );
            closeThread.join();
            // merge primary down to 1 segment
import org.apache.lucene.index.SegmentInfos;
            // After closing, the files in indexCommitGatedCloseable will be deleted.
            List<Engine.Operation> operations = generateHistoryOnReplica(between(1, 500), randomBoolean(), randomBoolean(), randomBoolean())
            // after flush our original segment_n is removed but some segments may remain.
    public void testUpdateSegments_replicaCommitsFirstReceivedInfos() throws IOException {
                NoMergePolicy.INSTANCE,
            assertEquals(2, nrtEngine.getLatestSegmentInfos().getGeneration());
            nrtEngine.close();
        }
    }
import org.opensearch.index.mapper.ParsedDocument;
import static org.hamcrest.Matchers.equalTo;
            // flush the primary engine - we don't need any segments, just force a new commit point.
            final GatedCloseable<SegmentInfos> snapshot = nrtEngine.getSegmentInfosSnapshot();
            nrtEngine.refresh("test refresh");
            final long maxSeqNo = localCheckpointTracker.getMaxSeqNo();
        }
        List<Engine.Operation> operations = generateHistoryOnReplica(2, randomBoolean(), randomBoolean(), randomBoolean());
import java.util.List;
import org.opensearch.indices.replication.common.ReplicationType;
                nrtEngineStore.directory().copyFrom(primaryStore.directory(), file, file, IOContext.DEFAULT);
                assertThat(snapshot.totalOperations(), equalTo(0));
    }
                    latch.await();
            }
            engine.flush(true, true);
            copySegments(latestPrimaryInfos, nrtEngine);
                    nrtEngineStore.directory().copyFrom(primaryStore.directory(), file, file, IOContext.DEFAULT);
                final ParsedDocument doc = createParsedDoc(Integer.toString(i), null);
            assertTrue(replicaFiles.containsAll(indexCommitGatedCloseable.get().getFileNames()));
                engine.translogManager().recoverFromTranslog(translogHandler, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
                applyOperation(nrtEngine, op);
    public void testCreateEngine() throws IOException {
            // get the additional segments that are only on the reader - not part of a commit.
import org.opensearch.common.concurrent.GatedCloseable;
            Lucene.cleanLuceneIndex(nrtEngineStore.directory());
            assertEquals(latestSegmentInfos.getUserData(), lastCommittedSegmentInfos.getUserData());
            userData = committedInfos.getUserData();
            final Store nrtEngineStore = createStore(INDEX_SETTINGS, newDirectory());
            final NRTReplicationEngine nrtEngine = buildNrtReplicaEngine(globalCheckpoint, nrtEngineStore)
            }
                applyOperation(primaryEngine, op);
    public void testCreateEngineWithException() throws IOException {
            engine.flush(true, true);
        "index",
    }
    }
                randomBoolean(),
                assertThat(
                createTempDir(),
            for (String fileName : indexCommitGatedCloseable.get().getFileNames()) {
            // Index docs on primary and refresh to create segments
        nrtEngineStore.close();
            nrtEngine.flush();
                "Segments_N is incref'd to 1",
            for (Engine.Operation op : operations) {
            );
            assertEquals(2, nrtEngine.getLastCommittedSegmentInfos().getGeneration());
            final Store primaryStore = createStore();
import org.opensearch.index.store.Store;
            for (String file : primaryEngine.getLatestSegmentInfos().files(true)) {
                    TestTranslog.drainSnapshot(snapshot, false).stream().map(Translog.Operation::seqNo).collect(Collectors.toSet()),
        Settings.builder().put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT).build()
            assertFalse(replicaFiles.containsAll(replicaSnapshotFiles));
    private void indexOperations(NRTReplicationEngine nrtEngine, List<Engine.Operation> operations) throws IOException {
                    throw new RuntimeException(e);
            engine.getLatestSegmentInfos().changed();
                nrtEngine.replicaFileTracker.refCount(lastCommittedSegmentInfos.getSegmentsFileName())
            final Collection<String> replicaSnapshotFiles = snapshot.get().files(false);
            assertEquals(primaryInfos.getVersion(), nrtEngine.getLatestSegmentInfos().getVersion());
            List<String> replicaFiles = List.of(nrtEngine.store.directory().listAll());
            assertEquals(engine.getLatestSegmentInfos().getVersion(), nrtEngine.getLatestSegmentInfos().getVersion());
            final Collection<String> readerOnlySegments = primaryInfos.files(false);
        final List<OpenSearchDirectoryReader> warmedReaders = new ArrayList<>();
            }
                    throw new RuntimeException(e);
        );
            assertSame(readerBeforeRefresh, readerAfterRefresh);
            assertEquals(processedCheckpoint, Long.parseLong(userData.get(LOCAL_CHECKPOINT_KEY)));
            assertRefCounted(nrtEngine, lastCommittedFiles);
            nrtEngine.getLatestSegmentInfos().changed();
            assertEquals(3, nrtEngine.getLastCommittedSegmentInfos().getGeneration());
            Collection<String> latestPrimaryFiles = engine.getLatestSegmentInfos().files(false);
            primaryEngine.forceMerge(true, 1, false, false, false, UUIDs.randomBase64UUID());
            // flush the primary
import org.opensearch.index.IndexSettings;
import org.opensearch.index.seqno.SequenceNumbers;
        for (Engine.Operation op : operations) {
        );
import org.apache.lucene.index.IndexCommit;
                nrtEngineStore,
    }
            }
            nrtEngine.updateSegments(primaryEngine.getLatestSegmentInfos());
            assertEquals(3, nrtEngine.getLatestSegmentInfos().getGeneration());
        ) {
            Set<Long> seqNos = operations.stream().map(Engine.Operation::seqNo).collect(Collectors.toSet());
        }
            assertFalse(storeFiles.contains(file));
            assertUnreferenced(nrtEngine, List.of(lastCommittedSegmentInfos.getSegmentsFileName()));
 * this file be licensed under the Apache-2.0 license or a
                final Engine.Index op = replicaIndexForDoc(doc, 1, i, false);
            assertEquals(primaryInfos.getVersion(), nrtEngine.getLastCommittedSegmentInfos().getVersion());
        }
            GatedCloseable<IndexCommit> indexCommitGatedCloseable = nrtEngine.acquireLastIndexCommit(false);
                assertEquals(getDocIds(engine, true), docs);
import org.opensearch.index.seqno.LocalCheckpointTracker;
                if (replicaFiles.contains(file) == false) {
        }
            applyOperation(nrtEngine, op);
        ) {
            // index more docs and refresh the reader - this will incref/decref files again
        cleanAndCopySegmentsFromPrimary(nrtEngine);
                if (replicaFiles.contains(file) == false) {
            final SegmentInfos lastCommittedSegmentInfos = nrtEngine.getLastCommittedSegmentInfos();
            engine.refresh("test");
import java.util.stream.Collectors;
                new ForceMergePolicy(newMergePolicy())
            engine.refresh("test");
            try (InternalEngine engine = new InternalEngine(nrtEngine.config())) {
                applyOperation(nrtEngine, op);
            segmentInfosSnapshot.close();
            }
            Lucene.cleanLuceneIndex(nrtEngineStore.directory());
            final Collection<String> mergedAwayFiles = nrtEngine.getLastCommittedSegmentInfos().files(false);
            // Verify the engine is still functional after warmer failure
            // recover a new engine from the nrtEngine's xlog.
            OpenSearchDirectoryReader readerAfterRefresh = referenceManager.acquire();
            }
        assertThrows(FlushFailedEngineException.class, nrtEngine::flush);
        } catch (Exception e) {
            assertEquals(maxSeqNo, Long.parseLong(userData.get(MAX_SEQ_NO)));
    }
                engine.refresh("test");
            nrtEngine.updateSegments(primaryEngine.getLatestSegmentInfos());
                assertThat(snapshot.totalOperations(), equalTo(operations.size()));
        }
        }
        Store store,
            new NRTReplicationEngine(replicaConfig);
        ) {
            assertEquals("Expected: " + file + " to be unreferenced", 0, nrtEngine.replicaFileTracker.refCount(file));
            }
            latestPrimaryFiles = engine.getLatestSegmentInfos().files(false);
            OpenSearchDirectoryReader readerBeforeRefresh = referenceManager.acquire();
            // merge primary down to 1 segment
            for (Engine.Operation op : operations) {
            assertThrows(RuntimeException.class, nrtEngineStore::close);
            final String lastCommitSegmentsFileName = SegmentInfos.getLastCommitSegmentsFileName(nrtEngineStore.directory());
        ) {
                engine.refresh("test");
import org.opensearch.index.translog.Translog;
    }
            randomBoolean()
        // stored in user data.
            final Store nrtEngineStore = createStore(INDEX_SETTINGS, newDirectory());
        }
            Thread closeThread = new Thread(() -> {
    }
            // refCount for our segments is 2 because they are still active on the reader
            try (NRTReplicationEngine nrtEngine = buildNrtReplicaEngine(globalCheckpoint, nrtEngineStore, INDEX_SETTINGS)) {
            readerOnlySegments.removeAll(lastCommittedFiles);
                randomBoolean(),
        assertTrue(toDelete.isPresent());
                applyOperation(nrtEngine, op);
            // bump the latest infos version a couple of times so that we can assert the correct version after commit.
        try (
                applyOperation(nrtEngine, op);
    public void testTrimTranslogOps() throws Exception {
        try (
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            replicaFiles = List.of(nrtEngine.store.directory().listAll());
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            // assume we start at the same gen.
import java.util.ArrayList;
        ) {
            List<Engine.Operation> operations = generateHistoryOnReplica(docCount, randomBoolean(), randomBoolean(), randomBoolean());
            List<Engine.Operation> operations = generateHistoryOnReplica(opsCount, randomBoolean(), randomBoolean(), randomBoolean());
            // wipe the nrt directory initially so we can sync with primary.
            // Ignore as engine creation will fail
    public void testCommitOnCloseThrowsException_decRefStore() throws Exception {
            nrtEngine.updateSegments(engine.getLatestSegmentInfos());
        SegmentInfos primaryInfos = engine.getLatestSegmentInfos();
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
import java.util.Collection;
            try (Translog.Snapshot snapshot = getTranslog(engine).newSnapshot()) {
            Lucene.cleanLuceneIndex(nrtEngineStore.directory());
        }
            assertEquals(4, nrtEngine.getLastCommittedSegmentInfos().getGeneration());
            copySegments(latestPrimaryFiles, nrtEngine);
            );
    }
            nrtEngine.close();
            }
        indexOperations(nrtEngine, operations);
                assertEquals(committedInfos.getGeneration() + 1, indexCommit.get().getGeneration());
            assertNotEquals(nrtEngine.getLatestSegmentInfos().getVersion(), engine.getLatestSegmentInfos().getVersion());
    public void testUpdateSegments_replicaReceivesSISWithLowerGen() throws IOException {
            final Store nrtEngineStore = createStore(INDEX_SETTINGS, newDirectory());
            final NRTReplicationEngine nrtEngine = buildNrtReplicaEngine(globalCheckpoint, nrtEngineStore)
            engine.getLatestSegmentInfos().changed();
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
    private static final IndexSettings INDEX_SETTINGS = IndexSettingsModule.newIndexSettings(
        for (String file : files) {
 * The OpenSearch Contributors require contributions made to
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            assertRefCounted(nrtEngine, infosBeforeClose.files(false));
            assertEquals(2, nrtEngine.getLatestSegmentInfos().getGeneration());
            // Copy segments and update - should succeed even though warmer throws
            copySegments(engine.getLatestSegmentInfos().files(true), nrtEngine);
            }
            List<String> replicaFiles = List.of(nrtEngine.store.directory().listAll());
import org.opensearch.common.settings.Settings;
            if (replicaFiles.contains(file) == false) {
        }
            Collection<String> latestPrimaryFiles = engine.getLatestSegmentInfos().files(false);
            final NRTReplicationEngine nrtEngine = buildNrtReplicaEngine(globalCheckpoint, nrtEngineStore)
            randomBoolean()
        ) {
            final Collection<String> lastCommittedFiles = lastCommittedSegmentInfos.files(true);
            nrtEngine.flush(false, true);
        }
            assertTrue(replicaFiles.containsAll(nrtEngine.getLatestSegmentInfos().files(false)));
        if (Lucene.indexExists(store.directory()) == false) {
        } else {
            try (final GatedCloseable<IndexCommit> indexCommit = nrtEngine.acquireLastIndexCommit(true)) {
            assertFalse(List.of(nrtEngineStore.directory().listAll()).contains(lastCommittedSegmentInfos.getSegmentsFileName()));
        try (
        return new NRTReplicationEngine(replicaConfig);
            translogDir,
                randomBoolean(),
        final Engine.Warmer testWarmer = warmedReaders::add;
public class NRTReplicationEngineTests extends EngineTestCase {
            nrtEngineStore.createEmpty(Version.LATEST);
    private NRTReplicationEngine buildNrtReplicaEngine(AtomicLong globalCheckpoint, Store store, IndexSettings settings)
            try (
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            assertRefCounted(nrtEngine, lastCommittedFiles);
        nrtEngine.close();
            // Index 2 docs with distinct IDs, this will create segments _0 and _1 and after forcemerge into _2.
            final SegmentInfos lastCommittedSegmentInfos = nrtEngine.getLastCommittedSegmentInfos();
        for (String file : latestPrimaryFiles) {
            copySegments(latestPrimaryFiles, nrtEngine);
    }
                }
    );
            assertEquals(7, nrtEngine.getLatestSegmentInfos().getVersion());
            nrtEngine.translogManager().rollTranslogGeneration();
import static org.opensearch.index.seqno.SequenceNumbers.MAX_SEQ_NO;
 */
            assertEquals(processedCheckpoint, Long.parseLong(userData.get(LOCAL_CHECKPOINT_KEY)));
                } catch (IOException e) {
            nrtEngine.updateSegments(engine.getLatestSegmentInfos());
    }
import static org.opensearch.index.seqno.SequenceNumbers.LOCAL_CHECKPOINT_KEY;
                Arrays.stream(nrtEngineStore.directory().listAll())
            assertEquals(3, engine.getLatestSegmentInfos().getGeneration());
            final NRTReplicationEngine nrtEngine = buildNrtReplicaEngine(globalCheckpoint, nrtEngineStore, INDEX_SETTINGS)
            }
        ) {
            nrtEngine.close();
    }
            final NRTReplicationEngine nrtEngine = buildNrtReplicaEngine(globalCheckpoint, nrtEngineStore)
            // Ensure we still have all the active files. Note - we exclude the infos file here if we aren't committing
                1,
        final Engine.Warmer failingWarmer = reader -> { throw new RuntimeException("warmer failure"); };
        Lucene.cleanLuceneIndex(store.directory());
            final SegmentInfos lastCommittedSegmentInfos = nrtEngine.getLastCommittedSegmentInfos();
        try (
import org.opensearch.cluster.metadata.IndexMetadata;
            randomBoolean(),
            assertEquals(maxSeqNo, Long.parseLong(userData.get(MAX_SEQ_NO)));
        List<String> storeFiles = List.of(nrtEngine.store.directory().listAll());
            // update the replica with segments_2 from the primary.
            nrtEngine.updateSegments(engine.getLatestSegmentInfos());
            assertEquals(5, primaryInfos.getVersion());
        }
        ) {
            assertEquals(2, primaryEngine.segmentsStats(false, false).getCount());
import java.util.Set;
            final Store primaryStore = createStore();
            });
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
        }
            // Initially no warming should have occurred
            final Store nrtEngineStore = createStore(INDEX_SETTINGS, newDirectory());
                } catch (InterruptedException e) {
            assertEquals(primaryEngine.getLatestSegmentInfos(), nrtEngine.getLatestSegmentInfos());
            final SegmentInfos committedInfos = SegmentInfos.readCommit(nrtEngineStore.directory(), lastCommitSegmentsFileName);
    public void testWarmerExceptionDoesNotPreventUpdateSegments() throws Exception {
                nrtEngineStore.directory().copyFrom(store.directory(), file, file, IOContext.DEFAULT);
            final SegmentInfos infosBeforeClose = nrtEngine.getLatestSegmentInfos();
import java.util.Map;
            assertEquals(nrtEngine.getLastSyncedGlobalCheckpoint(), engine.getLastSyncedGlobalCheckpoint());
                between(1, 500),
            // remove files still part of latest commit.
            assertEquals(
    public void testUpdateSegments_replicaReceivesSISWithHigherGen() throws IOException {
 * compatible open source license.
            nrtEngine.updateSegments(primaryEngine.getLatestSegmentInfos());
            NoMergePolicy.INSTANCE,
            assertEquals(previousInfos.getVersion(), latestSegmentInfos.getVersion());
            // Verify warmer was invoked again with the merged segments
            final GatedCloseable<SegmentInfos> segmentInfosSnapshot = nrtEngine.getSegmentInfosSnapshot();
                assertEquals(indexCommit.getUserData(), lastCommittedSegmentInfos.getUserData());
            final Store nrtEngineStore = createStore(INDEX_SETTINGS, newDirectory());
            // re-read the last commit from disk here in case the primary engine has flushed.
            assertEquals(2, warmedReaders.size());
    }
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            assertTrue(replicaFiles.containsAll(replicaSnapshotFiles));
    public void testDecrefToZeroRemovesFile() throws IOException {
            final SegmentInfos primaryInfos = engine.getLatestSegmentInfos();
            nrtEngine.updateSegments(engine.getLatestSegmentInfos());
                applyOperation(engine, op);
/*
        final Store nrtEngineStore = createStore(INDEX_SETTINGS, newDirectory());
    }
            nrtEngine.updateSegments(primaryEngine.getLatestSegmentInfos());
    private void assertRefCounted(NRTReplicationEngine nrtEngine, Collection<String> files) throws IOException {
        copySegments(primaryInfos.files(false), nrtEngine);
        ) {
        final NRTReplicationEngine nrtEngine = buildNrtReplicaEngine(globalCheckpoint, nrtEngineStore, INDEX_SETTINGS);
        final List<String> replicaFiles = List.of(store.directory().listAll());
            ) {
            assertTrue(storeFiles.contains(file));
            Lucene.cleanLuceneIndex(nrtEngineStore.directory());
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
        try (
            // refresh to create a lot of segments.
        assertTrue(toDelete.isPresent());
            copySegments(latestPrimaryFiles, nrtEngine);
            primaryEngine.forceMerge(true, 1, false, false, false, UUIDs.randomBase64UUID());
                applyOperation(engine, op);
import org.apache.lucene.store.IOContext;
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            globalCheckpoint::get,
            engine.forceMerge(true, 1, false, false, false, UUIDs.randomBase64UUID());
                store.directory().copyFrom(this.store.directory(), file, file, IOContext.DEFAULT);
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            warmer
            commitThread.join();
            final SegmentInfos latestSegmentInfos = nrtEngine.getLatestSegmentInfos();
    }
        indexOperations(nrtEngine, operations);
            randomIntBetween(1, 10),
                Translog.Snapshot snapshot = assertAndGetInternalTranslogManager(nrtEngine.translogManager()).getTranslog().newSnapshot()
            }
        cleanAndCopySegmentsFromPrimary(nrtEngine);
 *
            // wipe the nrt directory initially so we can sync with primary.
            assertEquals(previousInfos.counter, latestSegmentInfos.counter);
            assertEquals(3, nrtEngine.getLatestSegmentInfos().getGeneration());
            final SegmentInfos lastCommittedSegmentInfos = nrtEngine.getLastCommittedSegmentInfos();
        }
            // wipe the nrt directory initially so we can sync with primary.
            // we don't index into nrtEngine, so get the doc ids from the regular engine.
import org.opensearch.test.IndexSettingsModule;
        nrtEngineStore.directory().deleteFile(toDelete.get());
    }
            final Collection<String> latestPrimaryFiles = primaryEngine.getLatestSegmentInfos().files(false);
        }
            ReferenceManager<OpenSearchDirectoryReader> referenceManager = nrtEngine.getReferenceManager(Engine.SearcherScope.EXTERNAL);
        try (
            cleanAndCopySegmentsFromPrimary(nrtEngine);
import static org.opensearch.index.seqno.SequenceNumbers.NO_OPS_PERFORMED;
            final String translogUuid = Translog.createEmptyTranslog(
            final SegmentInfos primaryInfos = engine.getLatestSegmentInfos();
        );
            final NRTReplicationEngine nrtEngine = buildNrtReplicaEngine(globalCheckpoint, nrtEngineStore)
                try {
        }
            null,
        // This test asserts that NRTReplication#commitSegmentInfos creates a new commit point with the latest checkpoints
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
                .filter(op -> op.operationType().equals(Engine.Operation.TYPE.INDEX))
            assertEquals(latestSegmentInfos.getGeneration(), lastCommittedSegmentInfos.getGeneration());
                primaryTerm.get()
    public void testFlush() throws Exception {
                defaultSettings,
            snapshot.close();
            assertEquals(5, nrtEngine.getLastCommittedSegmentInfos().getGeneration());
            primaryInfos = engine.getLatestSegmentInfos();
import org.apache.lucene.tests.index.ForceMergePolicy;
                }
            for (String file : latestPrimaryFiles) {
            commitThread.start();
    public void testRefreshOnNRTEngine() throws IOException {
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
                .anyMatch(file -> file.equals("write.lock") == false && file.equals("extra0") == false)
    }
            assertEquals(
import org.apache.lucene.util.Version;
        }
            CountDownLatch latch = new CountDownLatch(1);
            SegmentInfos primaryInfos;
                SequenceNumbers.NO_OPS_PERFORMED,
            final long processedCheckpoint = localCheckpointTracker.getProcessedCheckpoint();
        }
            assertEquals(2, nrtEngine.getLastCommittedSegmentInfos().getGeneration());
            final NRTReplicationEngine nrtEngine = buildNrtReplicaEngine(globalCheckpoint, nrtEngineStore)
            // With certain mock directories a NoSuchFileException is thrown which is not treated as a
                assertUnreferenced(nrtEngine, extraSegments);
            final int docCount = 4;
            // read infos from store and assert userdata
            }
        final Store store = nrtEngine.store;
                final Engine.Index op = replicaIndexForDoc(doc, 1, i, false);
                new ForceMergePolicy(newMergePolicy())
                createTempDir(),
        List<String> storeFiles = List.of(nrtEngine.store.directory().listAll());
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
        final Store nrtEngineStore = createStore(INDEX_SETTINGS, newDirectory());
import java.util.Optional;
            List<Engine.Operation> operations = generateHistoryOnReplica(
                null,
            }
        ) {
            final Collection<String> latestPrimaryInfos = engine.getLatestSegmentInfos().files(false);
            );
            nrtEngine.updateSegments(engine.getLatestSegmentInfos());
            engine.flush(true, true);
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
                } catch (IOException e) {
            // Verify warmer was invoked after updateSegments
        // wipe the nrt directory initially so we can sync with primary.
            randomBoolean(),
                randomBoolean()
            assertEquals(2, nrtEngine.getLatestSegmentInfos().getGeneration());
            assertEquals(primaryInfos.getVersion(), lastCommittedSegmentInfos.getVersion());
        for (Engine.Operation op : operations) {
            applyOperation(engine, op);
            applyOperation(engine, op);
                null,
    }
            assertRefCounted(nrtEngine, readerOnlySegments);
        try (final Store nrtEngineStore = createStore(INDEX_SETTINGS, newDirectory());) {
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
    public void testWarmerIsInvokedOnUpdateSegments() throws Exception {
        // copy new segments in and load reader.
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
    }
            final SegmentInfos latestSegmentInfos = nrtEngine.getLatestSegmentInfos();
        }
            Lucene.cleanLuceneIndex(nrtEngineStore.directory());
            store.associateIndexWithNewTranslog(translogUuid);
            assertTrue(nrtEngine.segments(true).isEmpty());
    }
                applyOperation(primaryEngine, op);
                null,
            Thread commitThread = new Thread(() -> {
                assertFalse(replicaFiles.contains(fileName));
            for (Engine.Operation op : operations) {
            settings,
        assertFalse(
            mergedAwayFiles.removeAll(latestPrimaryInfos);
            assertEquals(
                TranslogHandler translogHandler = createTranslogHandler(nrtEngine.config().getIndexSettings(), engine);
            randomIntBetween(1, 10),
            final Store nrtEngineStore = createStore(INDEX_SETTINGS, newDirectory());
import java.util.concurrent.CountDownLatch;
        IndexSettings settings,
    }
            for (String file : extraSegments) {
            }
            final NRTReplicationEngine nrtEngine = buildNrtReplicaEngine(globalCheckpoint, nrtEngineStore, INDEX_SETTINGS)
                randomBoolean()
            // Index 2 docs with distinct IDs, this will create segments _0 and _1 and after forcemerge into _2.
                "Segments_N is removed",
            // create a new commit and update infos
            replicaFiles = List.of(nrtEngine.store.directory().listAll());
            assertEquals(1, warmedReaders.size());
            // refCount for our segments is 2 because they are still active on the reader
            nrtEngine.updateSegments(primaryInfos);
            nrtEngine.translogManager().trimOperationsFromTranslog(primaryTerm.get(), NO_OPS_PERFORMED);
            nrtEngine.flush(false, true);
        assertEquals(1, nrtEngineStore.refCount());
            final NRTReplicationEngine nrtEngine = buildNrtReplicaEngine(globalCheckpoint, nrtEngineStore, INDEX_SETTINGS, testWarmer)
        if (nrtEngineStore.isMarkedCorrupted()) {
            assertTrue("Expected: " + file + " to be referenced", nrtEngine.replicaFileTracker.refCount(file) >= 1);
    public void testSimultaneousEngineCloseAndCommit() throws IOException, InterruptedException {
            final Store nrtEngineStore = createStore(INDEX_SETTINGS, newDirectory());
                assertTrue(replicaFiles.contains(file));
            indexOperations(nrtEngine, operations.subList(0, 2));
            assertEquals(primaryInfos.getVersion(), nrtEngine.getLatestSegmentInfos().getVersion());
            assertUnreferenced(nrtEngine, mergedAwayFiles);
        try (
            assertEquals(previousInfos.getGeneration(), latestSegmentInfos.getLastGeneration());
            }
        assertTrue(nrtEngineStore.isMarkedCorrupted());
            final Store nrtEngineStore = createStore(INDEX_SETTINGS, newDirectory());
                final IndexCommit indexCommit = indexCommitGatedCloseable.get();
            for (String file : extraSegments) {
            // copy new segments in and load reader.
            nrtEngine.updateSegments(primaryInfos);
        final Path translogDir = createTempDir();
        final Optional<String> toDelete = Set.of(nrtEngineStore.directory().listAll()).stream().filter(f -> f.endsWith(".si")).findAny();
            assertRefCounted(nrtEngine, nrtEngine.getLastCommittedSegmentInfos().files(true));
            );
        try {
            store.createEmpty(replicaConfig.getIndexSettings().getIndexVersionCreated().luceneVersion);
            );
        final Store nrtEngineStore = createStore(INDEX_SETTINGS, newDirectory());
                assertNull(snapshot.next());
        );
import org.opensearch.index.translog.TestTranslog;
import java.util.Arrays;
    public void testEngineWritesOpsToTranslog() throws Exception {
                    nrtEngine.updateSegments(store.readLastCommittedSegmentsInfo());
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
    }
        assertEquals(1, nrtEngineStore.refCount());
                between(1, 100),
            }
            }
            Arrays.stream(nrtEngine.store.directory().listAll())
            final NRTReplicationEngine nrtEngine = buildNrtReplicaEngine(globalCheckpoint, nrtEngineStore)
            // ensure getLatestSegmentInfos returns an updated infos ref with correct userdata.
            assertEquals(4, nrtEngine.getLatestSegmentInfos().getGeneration());
            replicaFiles = List.of(nrtEngine.store.directory().listAll());
            }
            assertEquals(nrtEngine.getLatestSegmentInfos().getGeneration(), nrtEngine.getLastCommittedSegmentInfos().getGeneration());
            // Index docs on primary and refresh
                applyOperation(engine, op);
            assertEquals(processedCheckpoint, localCheckpointTracker.getProcessedCheckpoint());
        }
                    equalTo(seqNos)
                try {
        assertEquals(2, nrtEngineStore.refCount());
        List<Engine.Operation> operations = generateHistoryOnReplica(
            // commit the infos to push us to segments_3.
                primaryStore,
        ) {
            nrtEngineStore.close();
        final Optional<String> toDelete = Set.of(nrtEngineStore.directory().listAll()).stream().filter(f -> f.endsWith(".si")).findAny();
 * SPDX-License-Identifier: Apache-2.0
        nrtEngineStore.directory().deleteFile(toDelete.get());
    private void copySegments(Collection<String> latestPrimaryFiles, Engine nrtEngine) throws IOException {
        // wipe the nrt directory initially so we can sync with primary.
            });
            assertEngineCleanedUp(nrtEngine, assertAndGetInternalTranslogManager(nrtEngine.translogManager()).getDeletionPolicy());
                );
            // Merge primary down to 1 segment and replicate again
            final Store nrtEngineStore = createStore(INDEX_SETTINGS, newDirectory());
package org.opensearch.index.engine;
    public void testGetSegmentInfosSnapshotPreservesFilesUntilRelease() throws Exception {
    }
            // Passing null translogPath to induce failure
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
import org.opensearch.common.lucene.Lucene;
    private void assertUnreferenced(NRTReplicationEngine nrtEngine, Collection<String> files) throws IOException {
                randomBoolean(),
            applyOperations(nrtEngine, operations);
            nrtEngine.getLatestSegmentInfos().changed();
            );
                globalCheckpoint::get
    private void cleanAndCopySegmentsFromPrimary(NRTReplicationEngine nrtEngine) throws IOException {
            );
                applyOperation(nrtEngine, op);
    }
            indexOperations(nrtEngine, operations.subList(2, 4));
                applyOperation(nrtEngine, op);
            final Store nrtEngineStore = createStore(INDEX_SETTINGS, newDirectory());
            nrtEngine.translogManager().syncTranslog();
            List<Engine.Operation> operations = generateHistoryOnReplica(2, randomBoolean(), randomBoolean(), randomBoolean());
            for (String file : primaryEngine.getLatestSegmentInfos().files(true)) {
            for (int i = 0; i < 2; i++) {
            assertEquals(5, nrtEngine.getLatestSegmentInfos().getVersion());
                shardId,
                replicaConfig.getTranslogConfig().getTranslogPath(),
                primaryEngine.refresh("test");
            List<Engine.Operation> operations = generateHistoryOnReplica(
import org.opensearch.common.UUIDs;
                    throw new RuntimeException(e);
        }
    ) throws IOException {
        try (
        AtomicLong globalCheckpoint,
            final InternalEngine primaryEngine = createEngine(
            assertEquals(2, primaryInfos.getGeneration());
        try (
                final ParsedDocument doc = createParsedDoc(Integer.toString(i), null);
                nrtEngine.translogManager().getTranslogLastWriteLocation(),
            assertEquals(engine.getLatestSegmentInfos().getGeneration(), nrtEngine.getLatestSegmentInfos().getGeneration());
        nrtEngine.updateSegments(primaryInfos);
            final Store nrtEngineStore = createStore(INDEX_SETTINGS, newDirectory());
        try (
            copySegments(primaryInfos.files(false), nrtEngine);
