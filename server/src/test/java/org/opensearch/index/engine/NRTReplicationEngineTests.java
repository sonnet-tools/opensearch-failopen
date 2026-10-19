            assertRefCounted(nrtEngine, nrtEngine.getLastCommittedSegmentInfos().files(true));
            Map<String, String> userData = latestSegmentInfos.getUserData();
        ) {
        );  
        }  
            assertEquals(3, nrtEngine.getLatestSegmentInfos().getGeneration());  
                assertTrue(replicaFiles.contains(file));
    }  
            randomBoolean(),
                }
                    nrtEngineStore.directory().copyFrom(primaryStore.directory(), file, file, IOContext.DEFAULT);
            assertEquals(previousInfos.getGeneration(), latestSegmentInfos.getLastGeneration());
            assertEquals(2, nrtEngine.getLatestSegmentInfos().getGeneration());  
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);  
            final NRTReplicationEngine nrtEngine = buildNrtReplicaEngine(globalCheckpoint, nrtEngineStore)
        ) {
            final NRTReplicationEngine nrtEngine = buildNrtReplicaEngine(globalCheckpoint, nrtEngineStore);
            for (String fileName : indexCommitGatedCloseable.get().getFileNames()) {
        final Store nrtEngineStore = createStore(INDEX_SETTINGS, newDirectory());
            assertTrue(nrtEngine.segments(true).isEmpty());  
import org.opensearch.common.settings.Settings;
            try (  
    private NRTReplicationEngine buildNrtReplicaEngine(AtomicLong globalCheckpoint, Store store, IndexSettings settings)
            final SegmentInfos previousInfos = nrtEngine.getLatestSegmentInfos();
                nrtEngine.replicaFileTracker.refCount(lastCommittedSegmentInfos.getSegmentsFileName())  
            final Collection<String> lastCommittedFiles = lastCommittedSegmentInfos.files(true);  
                Arrays.stream(nrtEngineStore.directory().listAll())
        nrtEngine.close();  
            nrtEngine.updateSegments(primaryEngine.getLatestSegmentInfos());
        );
                applyOperation(engine, op);
                replicaConfig.getTranslogConfig().getTranslogPath(),
            indexCommitGatedCloseable.close();  
        assertEquals(1, nrtEngineStore.refCount());  
            }
                    latch.countDown();  
import org.apache.lucene.tests.index.ForceMergePolicy;  
            try (Translog.Snapshot snapshot = getTranslog(engine).newSnapshot()) {
            final NRTReplicationEngine nrtEngine = buildNrtReplicaEngine(globalCheckpoint, nrtEngineStore, INDEX_SETTINGS)
            assertRefCounted(nrtEngine, readerOnlySegments);
            // Ensure we still have all the active files. Note - we exclude the infos file here if we aren't committing  
            applyOperation(engine, op);
                "Segments_N is removed",  
        }
        try (
        final Engine.Warmer testWarmer = warmedReaders::add;  
        final NRTReplicationEngine nrtEngine = buildNrtReplicaEngine(globalCheckpoint, nrtEngineStore, INDEX_SETTINGS);  
        }  
 */  
            });
            ) {
            final Collection<String> latestPrimaryFiles = primaryEngine.getLatestSegmentInfos().files(false);  
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
        } catch (Exception e) {
            }
            }
            assertEquals(2, nrtEngine.getLastCommittedSegmentInfos().getGeneration());
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);  
    private void assertUnreferenced(NRTReplicationEngine nrtEngine, Collection<String> files) throws IOException {  
        }
            final Collection<String> latestPrimaryInfos = engine.getLatestSegmentInfos().files(false);
        return buildNrtReplicaEngine(globalCheckpoint, store, settings, null);
            latestPrimaryFiles = engine.getLatestSegmentInfos().files(false);  
            final SegmentInfos committedInfos = SegmentInfos.readCommit(nrtEngineStore.directory(), lastCommitSegmentsFileName);
            );
            store,
        }  
                engine.refresh("test");
            final NRTReplicationEngine nrtEngine = buildNrtReplicaEngine(globalCheckpoint, nrtEngineStore)  
            final SegmentInfos latestSegmentInfos = nrtEngine.getLatestSegmentInfos();  
            List<Engine.Operation> operations = generateHistoryOnReplica(opsCount, randomBoolean(), randomBoolean(), randomBoolean());
            // acquire latest commit
            final Store nrtEngineStore = createStore(INDEX_SETTINGS, newDirectory());  
                assertNull(snapshot.next());
            nrtEngine.refresh("test refresh");
        }
            // recover a new engine from the nrtEngine's xlog.
            }
        assertFalse(
    public void testTrimTranslogOps() throws Exception {
        }
            List<Engine.Operation> operations = generateHistoryOnReplica(docCount, randomBoolean(), randomBoolean(), randomBoolean());
            assertEquals(primaryInfos.getVersion(), nrtEngine.getLatestSegmentInfos().getVersion());  
            nrtEngine.flush();
        }
    }
            assertEquals(2, nrtEngine.getLatestSegmentInfos().getGeneration());  
            Lucene.cleanLuceneIndex(nrtEngineStore.directory());
                final ParsedDocument doc = createParsedDoc(Integer.toString(i), null);  
                nrtEngine.replicaFileTracker.refCount(lastCommittedSegmentInfos.getSegmentsFileName())
        "index",  
                    nrtEngineStore.directory().copyFrom(primaryStore.directory(), file, file, IOContext.DEFAULT);
            engine.flush(true, true);
    public void testUpdateSegments_replicaCommitsFirstReceivedInfos() throws IOException {
        final Store nrtEngineStore = createStore(INDEX_SETTINGS, newDirectory());  
            assertUnreferenced(nrtEngine, mergedAwayFiles);
            );  
    }  
                new ForceMergePolicy(newMergePolicy())
        return buildNrtReplicaEngine(globalCheckpoint, store, defaultSettings, null);
            assertEquals("Expected: " + file + " to be unreferenced", 0, nrtEngine.replicaFileTracker.refCount(file));
            Thread commitThread = new Thread(() -> {  
            // bump the latest infos version a couple of times so that we can assert the correct version after commit.
        AtomicLong globalCheckpoint,
            // after flush our original segment_n is removed but some segments may remain.
            engine.flush(true, true);  
            for (Engine.Operation op : operations) {  
            );
            assertEquals(5, nrtEngine.getLastCommittedSegmentInfos().getGeneration());
            // refCount for our segments is 2 because they are still active on the reader  
                primaryStore,  
            final Store nrtEngineStore = createStore(INDEX_SETTINGS, newDirectory());  
    public void testFlushThrowsFlushFailedExceptionOnCorruption() throws Exception {  
            // wipe the nrt directory initially so we can sync with primary.
    private void copySegments(Collection<String> latestPrimaryFiles, Engine nrtEngine) throws IOException {
                assertEquals(indexCommit.getUserData(), lastCommittedSegmentInfos.getUserData());
        try (
            for (String file : primaryEngine.getLatestSegmentInfos().files(true)) {
            assertFalse(replicaFiles.containsAll(replicaSnapshotFiles));
        if (Lucene.indexExists(store.directory()) == false) {
                defaultSettings,
                primaryTerm.get()
            engine.refresh("test");  
            // close the NRTEngine, it will commit on close and we'll reuse its store for an IE.
                nrtEngine.translogManager().getTranslogLastWriteLocation(),  
            assertUnreferenced(nrtEngine, List.of(lastCommittedSegmentInfos.getSegmentsFileName()));  
            // re-read the last commit from disk here in case the primary engine has flushed.  
                engine.translogManager().getTranslogLastWriteLocation()
            OpenSearchDirectoryReader readerAfterRefresh = referenceManager.acquire();  
            // get the additional segments that are only on the reader - not part of a commit.
            // Index 2 docs with distinct IDs, this will create segments _0 and _1 and after forcemerge into _2.
                if (replicaFiles.contains(file) == false) {  
}  
                null,
        for (Engine.Operation op : operations) {  
            settings,
            }
        throws IOException {  
    public void testEngineWritesOpsToTranslog() throws Exception {
        final List<String> replicaFiles = List.of(store.directory().listAll());  
            // merge primary down to 1 segment
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            final Collection<String> mergedAwayFiles = nrtEngine.getLastCommittedSegmentInfos().files(false);  
            nrtEngine.ensureOpen();
import org.opensearch.common.lucene.Lucene;
            nrtEngine.getLatestSegmentInfos().changed();
                try {  
            // Passing null translogPath to induce failure
    }
        copySegments(primaryInfos.files(false), nrtEngine);
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);  
        try (
            assertEquals(  
            assertRefCounted(nrtEngine, lastCommittedFiles);
            assertEquals(4, nrtEngine.getLastCommittedSegmentInfos().getGeneration());
            for (int i = 0; i < 2; i++) {
            try (InternalEngine engine = new InternalEngine(nrtEngine.config())) {
                applyOperation(nrtEngine, op);
    public void testAcquireLastIndexCommit() throws Exception {
            }  
import java.util.Set;
        }  
        final Path translogDir = createTempDir();
import org.opensearch.common.UUIDs;  
            assertEquals(3, primaryEngine.segmentsStats(false, false).getCount());
        cleanAndCopySegmentsFromPrimary(nrtEngine);
            engine.forceMerge(true, 1, false, false, false, UUIDs.randomBase64UUID());
            primaryEngine.forceMerge(true, 1, false, false, false, UUIDs.randomBase64UUID());
            Lucene.cleanLuceneIndex(nrtEngineStore.directory());
            final String translogUuid = Translog.createEmptyTranslog(  
            final Store nrtEngineStore = createStore(INDEX_SETTINGS, newDirectory());
            closeThread.start();
            commitThread.join();
                    latch.await();
            );
    }
            // we expect a 3rd segment to be created after merge.  
        }  
        Engine.Warmer warmer
            final NRTReplicationEngine nrtEngine = buildNrtReplicaEngine(globalCheckpoint, nrtEngineStore)
            assertEquals(2, nrtEngine.getLastCommittedSegmentInfos().getGeneration());
            final NRTReplicationEngine nrtEngine = buildNrtReplicaEngine(globalCheckpoint, nrtEngineStore, INDEX_SETTINGS, failingWarmer)  
            assertEquals(latestSegmentInfos.getUserData(), lastCommittedSegmentInfos.getUserData());  
                    throw new RuntimeException(e);  
import org.opensearch.test.IndexSettingsModule;
            List<Engine.Operation> operations = generateHistoryOnReplica(2, randomBoolean(), randomBoolean(), randomBoolean());  
            final int opsCount = 2;
            applyOperation(nrtEngine, op);
 * compatible open source license.
            List<Engine.Operation> operations = generateHistoryOnReplica(  
import java.util.stream.Collectors;
    }
    }
        for (Engine.Operation op : operations) {  
            final Store nrtEngineStore = createStore(INDEX_SETTINGS, newDirectory());
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);  
            ReferenceManager<OpenSearchDirectoryReader> referenceManager = nrtEngine.getReferenceManager(Engine.SearcherScope.EXTERNAL);
            warmer
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);  
                applyOperation(nrtEngine, op);
            copySegments(latestPrimaryFiles, nrtEngine);  
            nrtEngine.flush(false, true);
            replicaFiles = List.of(nrtEngine.store.directory().listAll());
            final NRTReplicationEngine nrtEngine = buildNrtReplicaEngine(globalCheckpoint, nrtEngineStore)
    public void testCommitOnCloseThrowsException_decRefStore() throws Exception {
            nrtEngine.close();  
                }  
            Lucene.cleanLuceneIndex(nrtEngineStore.directory());
            final Collection<String> readerOnlySegments = primaryInfos.files(false);  
            assertSame(readerBeforeRefresh, readerAfterRefresh);  
            final Store primaryStore = createStore();  
import static org.opensearch.index.seqno.SequenceNumbers.MAX_SEQ_NO;
            nrtEngine.translogManager().trimOperationsFromTranslog(primaryTerm.get(), NO_OPS_PERFORMED);
    }
            final long maxSeqNo = localCheckpointTracker.getMaxSeqNo();
            assertEquals(latestSegmentInfos.files(true), lastCommittedSegmentInfos.files(true));
            NoMergePolicy.INSTANCE,
            final InternalEngine primaryEngine = createEngine(
            primaryInfos = engine.getLatestSegmentInfos();
        ) {
    public void testCreateEngine() throws IOException {
        nrtEngineStore.close();
                0,
            final Store nrtEngineStore = createStore(INDEX_SETTINGS, newDirectory());  
            // create a new commit and update infos
                .filter(op -> op.operationType().equals(Engine.Operation.TYPE.INDEX))
                } catch (IOException e) {
                final IndexCommit indexCommit = indexCommitGatedCloseable.get();  
            for (Engine.Operation op : operations) {
            // Verify the engine is still functional after warmer failure
                applyOperation(nrtEngine, op);  
        ) {
            // copy new segments in and load reader.
    private NRTReplicationEngine buildNrtReplicaEngine(AtomicLong globalCheckpoint, Store store) throws IOException {
 * The OpenSearch Contributors require contributions made to  
                "Segments_N is incref'd to 1",
            final long processedCheckpoint = localCheckpointTracker.getProcessedCheckpoint();
            }
        List<String> storeFiles = List.of(nrtEngine.store.directory().listAll());
            assertNotNull(warmedReaders.getFirst());
            assertEquals(nrtEngine.getLatestSegmentInfos().getGeneration(), nrtEngine.getLastCommittedSegmentInfos().getGeneration());
                try {
            nrtEngine.updateSegments(primaryEngine.getLatestSegmentInfos());
            assertEquals(primaryInfos.getVersion(), lastCommittedSegmentInfos.getVersion());  
import static org.opensearch.index.seqno.SequenceNumbers.NO_OPS_PERFORMED;  
                new ForceMergePolicy(newMergePolicy())
        indexOperations(nrtEngine, operations);
        assertTrue(toDelete.isPresent());
                assertThat(snapshot.totalOperations(), equalTo(operations.size()));  
                final ParsedDocument doc = createParsedDoc(Integer.toString(i), null);
        ) {  
        try {
    ) throws IOException {  
        }  
            final Store nrtEngineStore = createStore(INDEX_SETTINGS, newDirectory());
            cleanAndCopySegmentsFromPrimary(nrtEngine);
    }
            nrtEngine.updateSegments(engine.getLatestSegmentInfos());
                    throw new RuntimeException(e);
    public void testUpdateSegments_replicaReceivesSISWithLowerGen() throws IOException {
import java.util.concurrent.atomic.AtomicLong;
            nrtEngine.updateSegments(engine.getLatestSegmentInfos());
        // wipe the nrt directory initially so we can sync with primary.  
    }
            // flush the primary  
            }
            assertEquals(2, nrtEngine.getLatestSegmentInfos().getGeneration());  
        // stored in user data.
                }
        cleanAndCopySegmentsFromPrimary(nrtEngine);  
            final Store nrtEngineStore = createStore(INDEX_SETTINGS, newDirectory());
package org.opensearch.index.engine;
            // merge primary down to 1 segment  
            assertNotEquals(nrtEngine.getLatestSegmentInfos().getVersion(), engine.getLatestSegmentInfos().getVersion());
            final NRTReplicationEngine nrtEngine = buildNrtReplicaEngine(globalCheckpoint, nrtEngineStore)  
        assertTrue(toDelete.isPresent());  
            nrtEngine.updateSegments(engine.getLatestSegmentInfos());
            assertEquals(4, nrtEngine.getLatestSegmentInfos().getGeneration());
        try (
import java.util.ArrayList;
    public void testPreserveLatestCommit() throws Exception {  
import org.apache.lucene.index.NoMergePolicy;
            Collection<String> latestPrimaryFiles = engine.getLatestSegmentInfos().files(false);  
 * this file be licensed under the Apache-2.0 license or a
        try (
            assertEquals(engine.getLatestSegmentInfos().getGeneration(), nrtEngine.getLatestSegmentInfos().getGeneration());
    public void testDecrefToZeroRemovesFile() throws IOException {
            nrtEngineStore.close();  
            final Store primaryStore = createStore();
            // Initially no warming should have occurred  
            nrtEngine.getLatestSegmentInfos().changed();
            assertEquals(processedCheckpoint, Long.parseLong(userData.get(LOCAL_CHECKPOINT_KEY)));
        return new NRTReplicationEngine(replicaConfig);
    private static final IndexSettings INDEX_SETTINGS = IndexSettingsModule.newIndexSettings(
                } catch (IOException e) {  
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            final SegmentInfos primaryInfos = engine.getLatestSegmentInfos();
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            assertEquals(latestSegmentInfos.version, lastCommittedSegmentInfos.version);
            // Index docs on primary and refresh
            engine.refresh("test");  
            }
        assertThrows(FlushFailedEngineException.class, nrtEngine::flush);
        );  
            nrtEngine.updateSegments(engine.getLatestSegmentInfos());
            assertThrows(RuntimeException.class, nrtEngineStore::close);
            closeThread.join();  
            final Collection<String> replicaSnapshotFiles = snapshot.get().files(false);
            // refresh to create a lot of segments.
            nrtEngine.updateSegments(primaryEngine.getLatestSegmentInfos());
        }
            OpenSearchDirectoryReader readerBeforeRefresh = referenceManager.acquire();  
            assertEquals(3, nrtEngine.getLastCommittedSegmentInfos().getGeneration());
                between(1, 500),
            );
            nrtEngine.translogManager().syncTranslog();  
            assertEquals(processedCheckpoint, localCheckpointTracker.getProcessedCheckpoint());
                assertThat(snapshot.totalOperations(), equalTo(0));  
            copySegments(engine.getLatestSegmentInfos().files(true), nrtEngine);  
            // Verify warmer was invoked after updateSegments  
        try (
            store.associateIndexWithNewTranslog(translogUuid);  
                defaultSettings,
            final Store nrtEngineStore = createStore(INDEX_SETTINGS, newDirectory());
        // This test asserts that NRTReplication#commitSegmentInfos creates a new commit point with the latest checkpoints
            final SegmentInfos latestSegmentInfos = nrtEngine.getLatestSegmentInfos();
            assertEquals(primaryEngine.getLatestSegmentInfos(), nrtEngine.getLatestSegmentInfos());
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;  
        Lucene.cleanLuceneIndex(store.directory());
        ) {
        }  
                NoMergePolicy.INSTANCE,
            assertEquals(1, warmedReaders.size());
        final Optional<String> toDelete = Set.of(nrtEngineStore.directory().listAll()).stream().filter(f -> f.endsWith(".si")).findAny();
            try (final GatedCloseable<IndexCommit> indexCommit = nrtEngine.acquireLastIndexCommit(true)) {
        nrtEngineStore.directory().deleteFile(toDelete.get());  
        ) {
            }  
        try (final Store nrtEngineStore = createStore(INDEX_SETTINGS, newDirectory());) {
            // we don't index into nrtEngine, so get the doc ids from the regular engine.
                SequenceNumbers.NO_OPS_PERFORMED,
            final GatedCloseable<SegmentInfos> snapshot = nrtEngine.getSegmentInfosSnapshot();  
            assertEquals(2, warmedReaders.size());
            // Merge primary down to 1 segment and replicate again
        try (
        final Store nrtEngineStore = createStore(INDEX_SETTINGS, newDirectory());  
        Store store,  
                nrtEngineStore.directory().copyFrom(primaryStore.directory(), file, file, IOContext.DEFAULT);  
            Set<Long> seqNos = operations.stream().map(Engine.Operation::seqNo).collect(Collectors.toSet());
    }  
import org.opensearch.index.seqno.SequenceNumbers;
                between(1, 100),
                randomBoolean()
            // update replica with the latest primary infos, it will be the same gen, segments_2, ensure it is also committed.  
        for (String file : files) {
            // refCount for our segments is 2 because they are still active on the reader  
            final Store nrtEngineStore = createStore(INDEX_SETTINGS, newDirectory());
            if (replicaFiles.contains(file) == false) {  
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            // Index docs on primary and refresh to create segments  
            randomBoolean(),  
        ) {
            );
            // the nrt reader will still reference segments_n-1 after being loaded until a local commit occurs.
            // flush the primary engine - we don't need any segments, just force a new commit point.
            final NRTReplicationEngine nrtEngine = buildNrtReplicaEngine(globalCheckpoint, nrtEngineStore)  
            assertFalse(List.of(nrtEngineStore.directory().listAll()).contains(lastCommittedSegmentInfos.getSegmentsFileName()));
        for (String file : files) {
                createTempDir(),  
        ) {
import org.opensearch.index.store.Store;  
import java.util.Optional;
                TranslogHandler translogHandler = createTranslogHandler(nrtEngine.config().getIndexSettings(), engine);
                randomBoolean(),
            translogDir,  
            randomBoolean()
public class NRTReplicationEngineTests extends EngineTestCase {  
            assertEquals(2, primaryEngine.segmentsStats(false, false).getCount());
            copySegments(latestPrimaryInfos, nrtEngine);  
            assertEquals(primaryInfos.getVersion(), nrtEngine.getLatestSegmentInfos().getVersion());
            }
            // get and close a snapshot - this will decref files when closed.  
            final Store nrtEngineStore = createStore(INDEX_SETTINGS, newDirectory());
            }  
import org.opensearch.index.mapper.ParsedDocument;  
            nrtEngine.updateSegments(primaryInfos);  
import org.apache.lucene.index.SegmentInfos;  
            replicaFiles = List.of(nrtEngine.store.directory().listAll());
            final String lastCommitSegmentsFileName = SegmentInfos.getLastCommitSegmentsFileName(nrtEngineStore.directory());
            final InternalEngine primaryEngine = createEngine(  
        try (
            for (String file : primaryEngine.getLatestSegmentInfos().files(true)) {
import org.opensearch.common.concurrent.GatedCloseable;
                applyOperation(nrtEngine, op);
            }
            assertFalse(  
        assertEquals(2, nrtEngineStore.refCount());
                1,
            assertEquals(previousInfos.getVersion(), latestSegmentInfos.getVersion());
            // corruption Exception. In these cases we don't expect any issue on store close.
                }
            List<String> replicaFiles = List.of(nrtEngineStore.directory().listAll());
            copySegments(latestPrimaryFiles, nrtEngine);
            // Verify warmer was invoked again with the merged segments
            assertEquals(nrtEngine.getLastSyncedGlobalCheckpoint(), engine.getLastSyncedGlobalCheckpoint());  
import org.apache.lucene.search.ReferenceManager;
            applyOperation(engine, op);
            // read infos from store and assert userdata  
                randomBoolean()
        // store will throw when eventually closed, not handled here.
import java.io.IOException;  
import org.apache.lucene.index.IndexCommit;
        try (
            for (Engine.Operation op : operations) {
                assertEquals(committedInfos.getGeneration() + 1, indexCommit.get().getGeneration());
            });
            Lucene.cleanLuceneIndex(nrtEngineStore.directory());
            );
            // assume we start at the same gen.
                defaultSettings,
            final NRTReplicationEngine nrtEngine = buildNrtReplicaEngine(globalCheckpoint, nrtEngineStore, INDEX_SETTINGS)
        for (String file : latestPrimaryFiles) {
                assertFalse(replicaFiles.contains(fileName));  
            snapshot.close();
                if (replicaFiles.contains(file) == false) {  
            nrtEngine.updateSegments(engine.getLatestSegmentInfos());
                primaryEngine.refresh("test");  
                    equalTo(seqNos)  
            nrtEngine.translogManager().rollTranslogGeneration();  
                assertUnreferenced(nrtEngine, extraSegments);
                .anyMatch(file -> file.equals("write.lock") == false && file.equals("extra0") == false)
            );  
            final Store nrtEngineStore = createStore(INDEX_SETTINGS, newDirectory());  
            final Store nrtEngineStore = createStore(INDEX_SETTINGS, newDirectory());  
        ) {
    }  
    }
        }
 * SPDX-License-Identifier: Apache-2.0
            try (final GatedCloseable<IndexCommit> indexCommitGatedCloseable = nrtEngine.acquireLastIndexCommit(false)) {
                engine.refresh("test");  
            null,
            randomIntBetween(1, 10),
        ) {
            globalCheckpoint::get,
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            indexOperations(nrtEngine, operations.subList(0, 2));  
            applyOperations(nrtEngine, operations);  
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            assertEquals(
        Settings.builder().put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT).build()
    );
                applyOperation(primaryEngine, op);
            // Ignore as engine creation will fail
        ) {
    }
        ) {
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
        nrtEngine.updateSegments(primaryInfos);
            assertEquals(previousInfos.counter, latestSegmentInfos.counter);  
                final Engine.Index op = replicaIndexForDoc(doc, 1, i, false);
            assertEquals(processedCheckpoint, Long.parseLong(userData.get(LOCAL_CHECKPOINT_KEY)));
            SegmentInfos primaryInfos;  
            List<Engine.Operation> operations = generateHistoryOnReplica(between(1, 500), randomBoolean(), randomBoolean(), randomBoolean())  
            // With certain mock directories a NoSuchFileException is thrown which is not treated as a
    public void testGetSegmentInfosSnapshotPreservesFilesUntilRelease() throws Exception {
                applyOperation(nrtEngine, op);
            final Store nrtEngineStore = createStore(INDEX_SETTINGS, newDirectory());  
                Translog.Snapshot snapshot = assertAndGetInternalTranslogManager(nrtEngine.translogManager()).getTranslog().newSnapshot()
                nrtEngineStore,
            assertRefCounted(nrtEngine, lastCommittedFiles);  
            // commit the infos to push us to segments_3.  
import java.util.Arrays;  
            readerOnlySegments.removeAll(lastCommittedFiles);
    }  
    }
            assertEquals(5, nrtEngine.getLatestSegmentInfos().getVersion());  
            final NRTReplicationEngine nrtEngine = buildNrtReplicaEngine(globalCheckpoint, nrtEngineStore, INDEX_SETTINGS)  
        try (
    }  
            // close the engine - ensure we preserved the last commit
        }  
import org.apache.lucene.util.Version;
            assertEquals(7, nrtEngine.getLatestSegmentInfos().getVersion());  
            assertEquals(maxSeqNo, Long.parseLong(userData.get(MAX_SEQ_NO)));
            // Verify both readers before and after refresh are same and no change in segments
        try (
import java.util.Map;  
                createTempDir(),
            }  
            assertEquals(3, nrtEngine.getLastCommittedSegmentInfos().getGeneration());
        }
    }  
            final NRTReplicationEngine nrtEngine = buildNrtReplicaEngine(globalCheckpoint, nrtEngineStore, INDEX_SETTINGS, testWarmer)
        try (
        List<String> storeFiles = List.of(nrtEngine.store.directory().listAll());
            final int docCount = 4;
            final NRTReplicationEngine nrtEngine = buildNrtReplicaEngine(globalCheckpoint, nrtEngineStore)  
            nrtEngine.flush(false, true);  
import org.opensearch.cluster.metadata.IndexMetadata;
            randomIntBetween(1, 10),  
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);  
            }  
                .stream()
import java.util.List;
            assertEquals(maxSeqNo, Long.parseLong(userData.get(MAX_SEQ_NO)));  
            replicaFiles = List.of(nrtEngine.store.directory().listAll());  
        assertTrue(nrtEngineStore.isMarkedCorrupted());
    }
            // update the replica with segments_2 from the primary.
                final Engine.Index op = replicaIndexForDoc(doc, 1, i, false);  
        try (
        }
        Lucene.cleanLuceneIndex(nrtEngine.store.directory());
                );
        try (
            final SegmentInfos lastCommittedSegmentInfos = nrtEngine.getLastCommittedSegmentInfos();
            indexOperations(nrtEngine, operations.subList(2, 4));  
            Collection<String> latestPrimaryFiles = engine.getLatestSegmentInfos().files(false);
            null,  
import org.opensearch.index.seqno.LocalCheckpointTracker;
            // index more docs and refresh the reader - this will incref/decref files again
            nrtEngine.updateSegments(engine.getLatestSegmentInfos());
            final SegmentInfos lastCommittedSegmentInfos = nrtEngine.getLastCommittedSegmentInfos();
            CountDownLatch latch = new CountDownLatch(1);
            // Verify that the files contained in indexCommitGatedCloseable will not be deleted.
            assertEquals(engine.getLatestSegmentInfos().getVersion(), nrtEngine.getLatestSegmentInfos().getVersion());
            Lucene.cleanLuceneIndex(nrtEngineStore.directory());
            assertEquals(primaryInfos.getVersion(), nrtEngine.getLastCommittedSegmentInfos().getVersion());
        // wipe the nrt directory initially so we can sync with primary.
            assertFalse(storeFiles.contains(file));
    public void testCreateEngineWithException() throws IOException {
    }
            segmentInfosSnapshot.close();
            );
                applyOperation(engine, op);
            final NRTReplicationEngine nrtEngine = buildNrtReplicaEngine(globalCheckpoint, nrtEngineStore)  
                primaryStore,
    public void testWarmerExceptionDoesNotPreventUpdateSegments() throws Exception {  
                nrtEngineStore.directory().copyFrom(primaryStore.directory(), file, file, IOContext.DEFAULT);
        assertThrows(RuntimeException.class, nrtEngineStore::close);  
            // After closing, the files in indexCommitGatedCloseable will be deleted.
                applyOperation(nrtEngine, op);  
            // wipe the nrt directory initially so we can sync with primary.  
import static org.hamcrest.Matchers.equalTo;
        }
import org.opensearch.index.translog.Translog;
            engine.getLatestSegmentInfos().changed();  
        assertEquals(1, nrtEngineStore.refCount());
            // copy new segments in and load reader.
            nrtEngine.updateSegments(primaryEngine.getLatestSegmentInfos());
                applyOperation(primaryEngine, op);
        } else {  
    public void testFlush() throws Exception {  
            assertTrue(replicaFiles.containsAll(nrtEngine.getLatestSegmentInfos().files(false)));
            final SegmentInfos lastCommittedSegmentInfos = nrtEngine.getLastCommittedSegmentInfos();  
            nrtEngine.updateSegments(primaryInfos);  
            engine.getLatestSegmentInfos().changed();
            }
            final List<DocIdSeqNoAndSource> docs = getDocIds(engine, true);  
            assertTrue(replicaFiles.containsAll(replicaSnapshotFiles));
        List<Engine.Operation> operations = generateHistoryOnReplica(
            }
                primaryEngine.refresh("test");
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);  
        ) {
/*  
            nrtEngine.flush();  
            copySegments(primaryInfos.files(false), nrtEngine);
            // remove files still part of latest commit.
import org.opensearch.indices.replication.common.ReplicationType;  
                shardId,  
            nrtEngineStore.createEmpty(Version.LATEST);  
        indexOperations(nrtEngine, operations);
            for (String file : extraSegments) {
            final Store nrtEngineStore = createStore(INDEX_SETTINGS, newDirectory());
                    throw new RuntimeException(e);
 *
            assertRefCounted(nrtEngine, infosBeforeClose.files(false));
        }
            // ensure getLatestSegmentInfos returns an updated infos ref with correct userdata.
            nrtEngine.updateSegments(primaryInfos);  
            assertEquals(2, primaryEngine.segmentsStats(false, false).getCount());  
    public void testUpdateSegments_replicaReceivesSISWithHigherGen() throws IOException {
    private void assertRefCounted(NRTReplicationEngine nrtEngine, Collection<String> files) throws IOException {  
import org.opensearch.index.IndexSettings;
            engine.flush(true, true);
            // Index 2 docs with distinct IDs, this will create segments _0 and _1 and after forcemerge into _2.  
        final Store store = nrtEngine.store;
            final Collection<String> latestPrimaryFiles = primaryEngine.getLatestSegmentInfos().files(false);
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);  
    }  
import static org.opensearch.index.seqno.SequenceNumbers.LOCAL_CHECKPOINT_KEY;
                assertEquals(getDocIds(engine, true), docs);
            assertEquals(2, nrtEngine.getLastCommittedSegmentInfos().getGeneration());
            assertEquals(3, nrtEngine.getLatestSegmentInfos().getGeneration());  
        final EngineConfig replicaConfig = config(  
import java.nio.file.Path;
            Thread closeThread = new Thread(() -> {
        final List<OpenSearchDirectoryReader> warmedReaders = new ArrayList<>();
    }
        SegmentInfos primaryInfos = engine.getLatestSegmentInfos();  
import org.opensearch.index.translog.TestTranslog;
                assertTrue(indexCommit.getFileNames().containsAll(lastCommittedSegmentInfos.files(true)));
            List<String> replicaFiles = List.of(nrtEngine.store.directory().listAll());
            new NRTReplicationEngine(replicaConfig);  
            List<String> replicaFiles = List.of(nrtEngine.store.directory().listAll());
            assertEquals(
            Arrays.stream(nrtEngine.store.directory().listAll())  
            nrtEngine.close();  
            // wipe the nrt directory initially so we can sync with primary.
                } catch (InterruptedException e) {
            LocalCheckpointTracker localCheckpointTracker = nrtEngine.getLocalCheckpointTracker();  
                globalCheckpoint::get
            store.createEmpty(replicaConfig.getIndexSettings().getIndexVersionCreated().luceneVersion);
            assertEquals(2, primaryInfos.getGeneration());
            assertEquals(latestSegmentInfos.getGeneration(), lastCommittedSegmentInfos.getGeneration());
            randomBoolean(),
            assertTrue("Expected: " + file + " to be referenced", nrtEngine.replicaFileTracker.refCount(file) >= 1);
            for (Engine.Operation op : operations) {  
                randomBoolean(),
    private NRTReplicationEngine buildNrtReplicaEngine(
            copySegments(latestPrimaryFiles, nrtEngine);
            try (NRTReplicationEngine nrtEngine = buildNrtReplicaEngine(globalCheckpoint, nrtEngineStore, INDEX_SETTINGS)) {  
            primaryEngine.forceMerge(true, 1, false, false, false, UUIDs.randomBase64UUID());
                    TestTranslog.drainSnapshot(snapshot, false).stream().map(Translog.Operation::seqNo).collect(Collectors.toSet()),
        if (nrtEngineStore.isMarkedCorrupted()) {
        List<Engine.Operation> operations = generateHistoryOnReplica(2, randomBoolean(), randomBoolean(), randomBoolean());
                randomBoolean(),  
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
        // copy new segments in and load reader.
        IndexSettings settings,
            assertTrue(storeFiles.contains(file));
        final Engine.Warmer failingWarmer = reader -> { throw new RuntimeException("warmer failure"); };
            final SegmentInfos primaryInfos = engine.getLatestSegmentInfos();  
    }
            assertEquals(5, primaryInfos.getVersion());
            assertTrue(replicaFiles.containsAll(indexCommitGatedCloseable.get().getFileNames()));  
            for (String file : extraSegments) {  
    public void testRemoveExtraSegmentsOnStartup() throws Exception {  
    public void testRefreshOnNRTEngine() throws IOException {
import java.util.Collection;
            List<Engine.Operation> operations = generateHistoryOnReplica(  
    public void testWarmerIsInvokedOnUpdateSegments() throws Exception {  
            assertEquals(3, engine.getLatestSegmentInfos().getGeneration());  
    }
            randomBoolean(),
            userData = committedInfos.getUserData();  
    }
        );
                    .anyMatch(file -> file.equals("write.lock") == false && file.equals("extra0") == false)
        nrtEngine.close();
    }
        nrtEngineStore.directory().deleteFile(toDelete.get());
            assertEngineCleanedUp(nrtEngine, assertAndGetInternalTranslogManager(nrtEngine.translogManager()).getDeletionPolicy());  
                nrtEngineStore.directory().copyFrom(store.directory(), file, file, IOContext.DEFAULT);  
                null,  
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
                randomBoolean(),  
            for (String file : latestPrimaryFiles) {
            final SegmentInfos infosBeforeClose = nrtEngine.getLatestSegmentInfos();  
        try (  
        final NRTReplicationEngine nrtEngine = buildNrtReplicaEngine(globalCheckpoint, nrtEngineStore, INDEX_SETTINGS);
            nrtEngine.close();
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
                engine.translogManager().recoverFromTranslog(translogHandler, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);  
            replicaFiles = List.of(nrtEngine.store.directory().listAll());  
            final NRTReplicationEngine nrtEngine = buildNrtReplicaEngine(globalCheckpoint, nrtEngineStore, INDEX_SETTINGS)
            assertEquals(2, primaryInfos.getGeneration());
            GatedCloseable<IndexCommit> indexCommitGatedCloseable = nrtEngine.acquireLastIndexCommit(false);  
            commitThread.start();  
        }
    public void testSimultaneousEngineCloseAndCommit() throws IOException, InterruptedException {
        }  
        }
                .collect(Collectors.toList());  
            for (int i = 0; i < 2; i++) {
            nrtEngine.updateSegments(engine.getLatestSegmentInfos());
            randomBoolean()  
            // Copy segments and update - should succeed even though warmer throws
            final Store nrtEngineStore = createStore(INDEX_SETTINGS, newDirectory());
            assertEquals(0, warmedReaders.size());
        ) {  
            for (String file : latestPrimaryFiles) {
            }  
import org.apache.lucene.store.IOContext;
                null,  
                applyOperation(engine, op);
            // Copy segments from primary to replica and update  
        List<Engine.Operation> operations = generateHistoryOnReplica(
            final EngineConfig replicaConfig = config(  
    private void indexOperations(NRTReplicationEngine nrtEngine, List<Engine.Operation> operations) throws IOException {
            final GatedCloseable<SegmentInfos> segmentInfosSnapshot = nrtEngine.getSegmentInfosSnapshot();
            final Collection<String> extraSegments = engine.getLatestSegmentInfos().files(false);
            final SegmentInfos lastCommittedSegmentInfos = nrtEngine.getLastCommittedSegmentInfos();
                    nrtEngine.updateSegments(store.readLastCommittedSegmentsInfo());
                assertThat(
            );  
        }  
                    nrtEngine.close();
    private void cleanAndCopySegmentsFromPrimary(NRTReplicationEngine nrtEngine) throws IOException {  
            }
        }
            mergedAwayFiles.removeAll(latestPrimaryInfos);
        final Optional<String> toDelete = Set.of(nrtEngineStore.directory().listAll()).stream().filter(f -> f.endsWith(".si")).findAny();
            }  
    }
import java.util.concurrent.CountDownLatch;  
        // if the replica is already at segments_N that is received, it will commit segments_N+1.
            // close snapshot, files should be cleaned up  
                store.directory().copyFrom(this.store.directory(), file, file, IOContext.DEFAULT);
