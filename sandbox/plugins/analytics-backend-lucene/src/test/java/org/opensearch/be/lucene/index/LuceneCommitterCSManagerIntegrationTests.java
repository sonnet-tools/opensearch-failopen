                commitUserData(200, 200)
            store.close();
            1L,
        Path indexDir = dataPath.resolve("index");  
            for (String f : parquet1)
 * compatible open source license.
                    }
                }
    private void doFlush(CatalogSnapshotManager manager, LuceneCommitter committer, long maxSeqNo, long localCP) throws IOException {
            for (String f : parquet0)
            // CS1 deleted by policy. CS2=safe(200<=200), CS3, CS4(flush)=last → 3 commits  
                assertTrue(fileExists(env.indexDir, f));
                    } catch (IOException e) {
            Set<String> parquet1 = ingestParquetFiles(env.parquetDir, "_1.parquet");
            Map<String, String> cd2 = new HashMap<>(cs2.getUserData());
                1L,
                assertTrue(fileExists(env.parquetDir, f));  
        );
                    buildSegment(1, lucene1, env.indexDir, parquet1, env.parquetDir)  
 *   shardPath/
                committer
        Path translogDir = dataPath.resolve("translog");  
        Path translogDir = dataPath.resolve("translog");  
import org.opensearch.index.seqno.SequenceNumbers;  
        for (String f : fileNames) {  
        Files.createDirectories(parquetDir);
                policy,
        {
            );
            Set<String> lucene0 = ingestLuceneDocs(env.committer, env.store);
            // Normal operation: ingest + refresh + flush  
                3L,
                new CommitterConfig(buildEngineConfig(indexSettings, store, shardId, translogDir), () -> {})  
        Path dataPath = baseDir.resolve(shardId.getIndex().getUUID()).resolve(Integer.toString(shardId.id()));  
            for (String f : parquet0)
        }
                assertTrue("lucene0 alive (ref'd by CS2): " + f, fileExists(env.indexDir, f));
                indexSettings,  
                2L,
    }  
            for (String f : parquet0)
                for (String file : entry.getValue()) {
        };
                shardId,
            Set<String> parquet0 = ingestParquetFiles(env.parquetDir, "_0.parquet");  
    }  
            shardId,
            .store(store)
            doFlush(manager, env.committer, 200, 200);
                assertTrue(fileExists(env.indexDir, f));  
        mergedFiles.removeIf(f -> f.startsWith("segments") || f.equals("write.lock"));  
        );  
                    buildSegment(2, lucene2, indexDir, parquet2, parquetDir)
 * Both lucene-format and parquet-format files are tracked in CatalogSnapshot
import org.opensearch.test.IndexSettingsModule;
            Map<String, String> cd1 = new HashMap<>(cs1.getUserData());
            for (String f : lucene0)  
        // Phase 2: Recovery + normal operation
        Set<String> filesBeforeMerge = Set.of(store.directory().listAll());  
        Files.createDirectories(translogDir);
                    try {
            Set<String> parquet1 = ingestParquetFiles(parquetDir, "_1.parquet");  
        public void close() throws Exception {  
    /** Builds a multi-format Segment from ingested lucene and parquet files. */
            manager.commitNewSnapshot(List.of(seg0, seg1, seg2));
    public void testRefCountingPreservesSharedFilesAcrossCommits() throws Exception {  
import org.apache.lucene.document.Field;
import org.opensearch.index.engine.exec.FileDeleter;
    // ---- Commit helpers ----
            committer.commit(new CommitInput(cd2.entrySet(), cs2, 0));  
            Set<String> parquet2 = ingestParquetFiles(parquetDir, "_2.parquet");  
            Store store = new Store(
        Set<String> mergedFiles = new HashSet<>(filesAfterMerge);
            Segment seg0 = buildSegment(0, lucene0, env.indexDir, parquet0, env.parquetDir);
            org.opensearch.common.util.io.IOUtils.rm(translogDir);
            manager.commitNewSnapshot(List.of(seg0, seg1, seg2));  
            Set<String> parquet1 = ingestParquetFiles(env.parquetDir, "_1.parquet");
                assertTrue("lucene0 survives: " + f, fileExists(indexDir, f));  
        Path baseDir = createTempDir();
        ud.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, Long.toString(localCheckpoint));  
    private int countLuceneCommits(Store store) throws IOException {  
            for (String f : parquet0)  
            assertEquals(1, DirectoryReader.listCommits(store.directory()).size());
                    buildSegment(0, lucene0, indexDir, parquet0, parquetDir),  
            for (String f : parquet2)  
                assertTrue(fileExists(env.parquetDir, f));
            // seg0 lucene files still alive (CS2 references them), but CS1's commit is gone
            Map<String, String> cd1 = new HashMap<>(cs1.getUserData());  
            for (String f : lucene2)
            assertFalse("_2.parquet orphan", fileExists(parquetDir, "_2.parquet"));
            // All segment files still alive — the latest commit references all segments
        }  
                    failed.put(entry.getKey(), failedFiles);
        CombinedCatalogSnapshotDeletionPolicy policy  
        TestEnv env,
            assertTrue("CS1's commit still exists", countLuceneCommits(env.store) >= 2);  
            Store.OnClose.EMPTY,
            manager.close();  
 * The OpenSearch Contributors require contributions made to  
            );
import org.opensearch.index.engine.EngineConfig;
            new DummyShardLock(shardId),
                shardPath
    }
    private boolean fileExists(Path dir, String fileName) {
            for (String f : lucene3)  
            for (String f : lucene0)
                Store.OnClose.EMPTY,  
        {
                List.of(
            doFlush(manager, env.committer, 300, 300);
            var policy = new CombinedCatalogSnapshotDeletionPolicy(logger, new DefaultTranslogDeletionPolicy(-1, -1, 0), globalCP::get);  
            CatalogSnapshotManager manager = new CatalogSnapshotManager(  
            for (String f : parquet0)  
            committer.commit(new CommitInput(cd1.entrySet(), cs1, 0));
                1L,
                assertTrue(fileExists(env.parquetDir, f));
                Store.OnClose.EMPTY,  
            store.close();  
                assertTrue("parquet1 alive (ref'd by latest): " + f, fileExists(env.parquetDir, f));
     * Returns only the merged segment's files — ensuring each CatalogSnapshot's  
     */
        Set<String> lucene0;
            LuceneCommitter committer = new LuceneCommitter(
    }  
 * and managed by our IndexFileDeleter.  
                assertTrue("parquet2 alive: " + f, fileExists(env.parquetDir, f));
            globalCP.set(300);  
        }
            committer.commit(new CommitInput(cd.entrySet(), snapshot, 0));
import java.io.IOException;
        LuceneCommitter committer = new LuceneCommitter(  
            for (String f : lucene0)  
            CatalogSnapshot cs1 = CatalogSnapshotManager.createInitialSnapshot(
    // ---- Test 1: Multiple ingest→merge→flush cycles with safe commit progression ----  
        @Override
import java.util.Collection;  
            snapshot.setUserData(commitUserData(maxSeqNo, localCP), true);
                new DataFormatAwareStoreDirectory(new NIOFSDirectory(indexDir), shardPath, java.util.Map.of()),
        Files.createDirectories(dataPath);
            )
                assertTrue(fileExists(env.indexDir, f));
                if (!failedFiles.isEmpty()) {  
                3L,  
    private CatalogSnapshotManager bootstrap(
            for (String f : parquet2)
        Files.createDirectories(indexDir);  
    }
            new DataFormatAwareStoreDirectory(new NIOFSDirectory(indexDir), shardPath, java.util.Map.of()),  
        try (GatedConditionalCloseable<CatalogSnapshot> handle = manager.acquireSnapshotForCommit()) {
            }  
            // CS2/CS3 orphan parquet files cleaned up  
import java.nio.file.Path;
    public void testSnapshotProtectionPreservesAllFiles() throws Exception {  
            store.createEmpty(org.apache.lucene.util.Version.LATEST, phaseTranslogUUID);
        long maxSeqNo,
    }
        ShardId shardId = new ShardId("test", "_na_", 0);  
            assertEquals("Only latest commit remains", 1, countLuceneCommits(env.store));
            cd.put(CatalogSnapshot.CATALOG_SNAPSHOT_ID, Long.toString(snapshot.getId()));
import java.util.concurrent.atomic.AtomicLong;  
    }
            assertEquals("CS2 (safe) + CS3 (last)", 2, countLuceneCommits(env.store));
    private static EngineConfig buildEngineConfig(IndexSettings indexSettings, Store store, ShardId shardId, Path translogPath) {  
                commitUserData(100, 100)
            assertTrue("_0.parquet survives", fileExists(parquetDir, "_0.parquet"));
            env.committer
                shardId,  
    // ---- Test 3: Snapshot protection preserves files across both formats ----
                assertTrue("alive via safe: " + f, fileExists(env.indexDir, f));
import org.opensearch.common.concurrent.GatedCloseable;
                1L,  
        return mergedFiles;
import org.apache.lucene.index.IndexWriter;
            assertFalse("_1.parquet orphan deleted", fileExists(parquetDir, "_1.parquet"));
            if (Files.exists(parquetDir.resolve(f)) == false) {
                assertTrue("alive via CS2: " + f, fileExists(env.parquetDir, f));
            );
                commitUserData(200, 200)
                commitUserData(300, 300)
        store.createEmpty(org.apache.lucene.util.Version.LATEST, createdTranslogUUID);
                3L,
            cd2.put(CatalogSnapshot.CATALOG_SNAPSHOT_ID, Long.toString(cs2.getId()));  
            globalCP.set(300);
                0L,
        long localCP,
        mergedFiles.removeAll(filesBeforeMerge);
            // CS2, CS3, CS4 all deleted. Only CS6(flush)=safe=last remains
import java.util.ArrayList;
        );
                        failedFiles.add(file);  
import org.opensearch.index.store.Store;  
                assertTrue("alive via safe: " + f, fileExists(env.parquetDir, f));  
            );
                new DummyShardLock(shardId),
            LuceneCommitter committer = new LuceneCommitter(  
                assertTrue("lucene0 alive via CS3: " + f, fileExists(indexDir, f));
            // Recreate translog with globalCP=100 to simulate persisted state at crash
        EngineConfig.Builder builder = new EngineConfig.Builder().indexSettings(indexSettings)
            Set<String> parquet2 = ingestParquetFiles(env.parquetDir, "_2.parquet");
                committer.listCommittedSnapshots(),
        Path parquetDir = dataPath.resolve(PARQUET_FORMAT);
                null  
    // ---- TestEnv ----  
        Path baseDir = createTempDir();  
                shardPath
            cd.put(CatalogSnapshot.CATALOG_SNAPSHOT_KEY, snapshot.serializeToString());  
 *     index/       ← Lucene directory (segments_N + real .cfs/.cfe/.si files)  
        if (translogPath != null) {
                1L,
            CatalogSnapshot cs3 = CatalogSnapshotManager.createInitialSnapshot(
            );  
            Map<String, Collection<String>> failed = new HashMap<>();
            committer.close();
                SequenceNumbers.NO_OPS_PERFORMED,  
            new CommitterConfig(buildEngineConfig(indexSettings, store, shardId, translogDir), () -> {})
        return ud;
                policy,
            lucene0 = ingestLuceneDocs(committer, store);
                assertTrue("protected: " + f, fileExists(env.indexDir, f));  
        String createdTranslogUUID = Translog.createEmptyTranslog(  
                assertTrue("protected: " + f, fileExists(env.parquetDir, f));
            );
    public void testRecoveryThenNormalOperationWorks() throws Exception {  
                indexSettings,  
import org.opensearch.common.concurrent.GatedConditionalCloseable;
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);
                List.of(buildSegment(0, lucene0, env.indexDir, parquet0, env.parquetDir)),  
                2L,  
            );
        Files.createDirectories(dataPath);  
     * lucene files are self-contained with no cross-snapshot references.
    }
                0L,
            indexSettings,
import org.apache.lucene.index.DirectoryReader;
                combinedFileDeleter(Map.of(PARQUET_FORMAT, parquetDir, LUCENE_FORMAT, indexDir)),  
            assertEquals("Only CS2's commit remains", 1, countLuceneCommits(env.store));
            // Each snapshot includes ALL accumulated segments (matching production behavior)
            Set<String> lucene0 = ingestLuceneDocs(env.committer, env.store);
            GatedCloseable<CatalogSnapshot> held = manager.acquireCommittedSnapshot(false);
            .retentionLeasesSupplier(() -> new RetentionLeases(0, 0, java.util.Collections.emptyList()));  
            // --- CS1: ingest, bootstrap, flush (lcp=100, globalCP=100) ---
            CatalogSnapshotManager manager = new CatalogSnapshotManager(  
    private static Map<String, String> commitUserData(long maxSeqNo, long localCheckpoint) {  
            for (String f : lucene2)
        ud.put(Translog.TRANSLOG_UUID_KEY, TRANSLOG_UUID);
            Set<String> lucene3 = ingestLuceneDocs(committer, store);
public class LuceneCommitterCSManagerIntegrationTests extends OpenSearchTestCase {
            cd1.put(CatalogSnapshot.CATALOG_SNAPSHOT_KEY, cs1.serializeToString());
 * <p>Directory layout mirrors production:  
            CatalogSnapshot snapshot = handle.get();  
                List.of(buildSegment(0, lucene0, indexDir, parquet0, parquetDir), buildSegment(1, lucene1, indexDir, parquet1, parquetDir)),
            LuceneCommitter committer = new LuceneCommitter(
            }  
            for (String f : lucene0)  
            cd3.put(CatalogSnapshot.CATALOG_SNAPSHOT_ID, Long.toString(cs3.getId()));  
                List.of(
            manager.commitNewSnapshot(  
                assertTrue(fileExists(env.indexDir, f));
import java.util.HashSet;
                shardId,
        ShardId shardId = new ShardId("test", "_na_", 0);
            for (String f : lucene0)
            // --- CS3: ingest, refresh, flush (lcp=300, globalCP=100) ---  
                Map.of(),
        return new Segment(gen, Map.of(LUCENE_FORMAT, luceneWfs, PARQUET_FORMAT, parquetWfs));
    ) throws IOException {
            Set<String> parquet1 = ingestParquetFiles(parquetDir, "_1.parquet");
                List.of(),
                            failedFiles.add(file);  
            committer.commit(new CommitInput(cd3.entrySet(), cs3, 0));
            env.committer.listCommittedSnapshots(),
                SequenceNumbers.NO_OPS_PERFORMED,
                )
import org.apache.lucene.store.NIOFSDirectory;  
            doFlush(manager, env.committer, 200, 200);
            for (Map.Entry<String, Collection<String>> entry : filesToDelete.entrySet()) {
        iw.forceMerge(1);
            Set<String> parquet0 = ingestParquetFiles(env.parquetDir, "_0.parquet");  
                assertTrue(fileExists(env.parquetDir, f));
            lucene1 = ingestLuceneDocs(committer, store);
            for (String f : parquet2)  
            for (String f : lucene0)  
            // Refresh: CS2 keeps seg0, adds seg1  
            );  
            );  
                2L,
            lucene2 = ingestLuceneDocs(committer, store);
import org.opensearch.common.settings.Settings;  
            for (String f : lucene2)
            assertEquals("CS2 + CS3 + CS4", 3, countLuceneCommits(env.store));
        Files.createDirectories(dataPath);
            // All 3 commits: CS1=safe, CS2 in between, CS3=last
        try (TestEnv env = createTestEnv()) {  
        }
            Segment seg1 = buildSegment(1, lucene1, env.indexDir, parquet1, env.parquetDir);
            // CS1's files survive
            AtomicLong globalCP = new AtomicLong(100);
            Store store = new Store(
import org.opensearch.index.translog.DefaultTranslogDeletionPolicy;
        return builder.build();
        Path indexDir = dataPath.resolve("index");
            cd2.put(CatalogSnapshot.CATALOG_SNAPSHOT_KEY, cs2.serializeToString());
                translogDir,  
            committer.commit(new CommitInput(cd2.entrySet(), cs2, 0));
            org.opensearch.common.util.io.IOUtils.rm(translogDir);
            Set<String> lucene2 = ingestLuceneDocs(env.committer, env.store);
            cd2.put(CatalogSnapshot.CATALOG_SNAPSHOT_KEY, cs2.serializeToString());
            );
            manager.close();
    // ---- Test 2: Shared files preserved when referencing commit exists ----
        cd.put(CatalogSnapshot.CATALOG_SNAPSHOT_ID, Long.toString(initial.getId()));
                assertTrue(fileExists(indexDir, f));
    private record TestEnv(LuceneCommitter committer, Store store, ShardPath shardPath, Path indexDir, Path parquetDir, Path translogDir)
package org.opensearch.be.lucene.index;
                Collection<String> failedFiles = new ArrayList<>();  
    }
        iw.addDocument(List.of(new StringField("id", "doc_" + docCounter++, Field.Store.NO)));
        return Set.of(fileNames);
        }
        Files.createDirectories(parquetDir);
        Files.createDirectories(parquetDir);  
            manager.commitNewSnapshot(List.of(seg0, seg1));
            Set<String> lucene2 = ingestLuceneDocs(env.committer, env.store);
            // CS1 protected by held snapshot — all files alive
        IndexWriter iw = committer.getIndexWriter();
            null  
    private int docCounter = 0;
        );
        };
            List.of(),  
            );
import org.opensearch.common.util.BigArrays;
                assertTrue("parquet0 alive (ref'd by CS2): " + f, fileExists(env.parquetDir, f));
                Files.createFile(parquetDir.resolve(f));
/*  
                    buildSegment(1, lucene1, indexDir, parquet1, parquetDir),
            Map<String, Collection<String>> failed = new HashMap<>();
                2L,  
            committer.close();
                TRANSLOG_UUID,
                null
                shardPath,  
    // ---- Test 4: Recovery trims unsafe commits, cleans orphans ----  
        {  
                assertTrue("parquet1 alive (safe): " + f, fileExists(env.parquetDir, f));  
            combinedFileDeleter(Map.of(PARQUET_FORMAT, env.parquetDir, LUCENE_FORMAT, env.indexDir)),
    }
            SequenceNumbers.NO_OPS_PERFORMED,  
                    buildSegment(0, lucene0, env.indexDir, parquet0, env.parquetDir),
            Set<String> parquet2 = ingestParquetFiles(env.parquetDir, "_2.parquet");  
    private static final String LUCENE_FORMAT = "lucene";
                assertTrue("lucene2 alive (ref'd by latest): " + f, fileExists(env.indexDir, f));
                0L,
        return new CatalogSnapshotManager(
            manager.close();
    public void testMultipleFlushCyclesWithSafeCommitProgression() throws Exception {
            store.close();
            assertEquals("CS1 + CS2 + CS3", 3, countLuceneCommits(env.store));
            for (String f : lucene0)
            cd1.put(CatalogSnapshot.CATALOG_SNAPSHOT_ID, Long.toString(cs1.getId()));
            doFlush(manager, env.committer, 300, 300);
            committer.close();
            held.close();  
            Map.of(),
        env.committer.commit(new CommitInput(cd.entrySet(), initial, 0));  
            manager.commitNewSnapshot(
            for (String f : lucene0)
            for (String f : parquet1)  
            builder.translogConfig(new TranslogConfig(shardId, translogPath, indexSettings, BigArrays.NON_RECYCLING_INSTANCE, "", false));
            doFlush(manager, committer, 300, 300);
import java.util.HashMap;
        ShardPath shardPath = new ShardPath(false, dataPath, dataPath, shardId);
                shardId,
            for (String f : parquet1)
            Set<String> lucene1 = ingestLuceneDocs(committer, store);  
        ShardPath shardPath = new ShardPath(false, dataPath, dataPath, shardId);
                if (dir == null) continue;
            CatalogSnapshotManager manager = bootstrap(env, List.of(seg0), 100, 100, policy);
                    buildSegment(0, lucene0, indexDir, Set.of("_0.parquet"), parquetDir),
            Translog.createEmptyTranslog(translogDir, shardId, 100L, 1L, TRANSLOG_UUID, null);  
            );  
            Set<String> lucene1 = ingestLuceneDocs(env.committer, env.store);
            assertTrue("_0.parquet alive via CS3", fileExists(parquetDir, "_0.parquet"));
            LuceneCommitter committer = new LuceneCommitter(  
            // --- CS2: ingest, refresh, flush (lcp=200, globalCP=100) ---
import org.opensearch.index.translog.TranslogConfig;  
}  
                assertTrue("lucene0 survives: " + f, fileExists(indexDir, f));  
        ud.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(maxSeqNo));
        Files.createDirectories(indexDir);
    private Set<String> ingestLuceneDocs(LuceneCommitter committer, Store store) throws IOException {  
            var policy = new CombinedCatalogSnapshotDeletionPolicy(logger, new DefaultTranslogDeletionPolicy(-1, -1, 0), globalCP::get);
            Set<String> parquet0 = ingestParquetFiles(env.parquetDir, "_0.parquet");  
            String phaseTranslogUUID = Translog.createEmptyTranslog(
        Store store = new Store(  
        Path dataPath = baseDir.resolve(shardId.getIndex().getUUID()).resolve(Integer.toString(shardId.id()));
                new DataFormatAwareStoreDirectory(new NIOFSDirectory(indexDir), shardPath, java.util.Map.of()),
            store.createEmpty(org.apache.lucene.util.Version.LATEST, phaseTranslogUUID);  
            CatalogSnapshotManager manager = bootstrap(
                100,
 * </pre>
            translogDir,
 */  
            Store store = new Store(
    }
            manager.commitNewSnapshot(List.of(seg0, seg1, seg2));
 *
            doFlush(manager, env.committer, 300, 300);
     * Ingests a real Lucene document, then force-merges all segments into one.
            Set<String> parquet0 = ingestParquetFiles(parquetDir, "_0.parquet");  
                }
                shardId,
                    }
            for (String f : parquet0)
    private static FileDeleter fileDeleterFor(Path dir) {
            cd3.put(CatalogSnapshot.CATALOG_SNAPSHOT_KEY, cs3.serializeToString());
        CatalogSnapshot initial = CatalogSnapshotManager.createInitialSnapshot(1L, 1L, 0L, segments, 1L, commitUserData(maxSeqNo, localCP));
            Set<String> parquet0 = ingestParquetFiles(parquetDir, "_0.parquet");
import java.util.List;  
    public void testRecoveryAfterCrashTrimsUnsafeCommits() throws Exception {
import java.nio.file.Files;  
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);  
            // Hold CS1
            Files.createDirectories(translogDir);
            Map<String, String> cd2 = new HashMap<>(cs2.getUserData());  
            );
            handle.markSuccess();  
                    if (Files.deleteIfExists(dir.resolve(file)) == false) {
                assertTrue("lucene1 alive (safe): " + f, fileExists(env.indexDir, f));
                Collection<String> failedFiles = new ArrayList<>();
import org.opensearch.index.engine.exec.coord.CatalogSnapshotManager;
            shardId,
import org.opensearch.index.shard.ShardPath;
 * <pre>
                    buildSegment(2, lucene2, env.indexDir, parquet2, env.parquetDir)
            // Release — CS1 deleted, but seg0 files still alive via CS2
        // Phase 2: Recovery — globalCP=100
 */
            cd2.put(CatalogSnapshot.CATALOG_SNAPSHOT_ID, Long.toString(cs2.getId()));
        Map<String, String> cd = new HashMap<>(initial.getUserData());  
            for (String f : lucene1)  
            Map<String, String> cd3 = new HashMap<>(cs3.getUserData());
            Set<String> lucene0 = ingestLuceneDocs(env.committer, env.store);
            CatalogSnapshot cs2 = CatalogSnapshotManager.createInitialSnapshot(
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);
                indexSettings,  
import java.util.Set;
                assertTrue("lucene0 alive (ref'd by latest): " + f, fileExists(env.indexDir, f));
import org.opensearch.index.translog.Translog;
            for (String f : lucene2)  
                2L,  
        Path indexDir = dataPath.resolve("index");
                assertTrue(fileExists(env.indexDir, f));
            manager.commitNewSnapshot(  
                2L,
                        failedFiles.add(file);  
        long numRows = 100;
                TRANSLOG_UUID,
            Set<String> parquet1 = ingestParquetFiles(env.parquetDir, "_1.parquet");  
                )  
            globalCP.set(200);
            // Advance globalCP, refresh CS3, flush  
            manager.close();
import org.opensearch.index.engine.exec.CombinedCatalogSnapshotDeletionPolicy;  
                assertTrue("lucene1 alive (ref'd by latest): " + f, fileExists(env.indexDir, f));  
    private static final String TRANSLOG_UUID = "test-translog-uuid";  
import org.opensearch.index.store.DataFormatAwareStoreDirectory;
 *
                new DummyShardLock(shardId),  
        Path dataPath = baseDir.resolve(shardId.getIndex().getUUID()).resolve(Integer.toString(shardId.id()));
        // Phase 1: Pre-crash — 3 commits  
            assertFalse("_1.parquet orphan", fileExists(parquetDir, "_1.parquet"));
            Segment seg1 = buildSegment(1, lucene1, env.indexDir, parquet1, env.parquetDir);
            );
            CatalogSnapshot cs1 = CatalogSnapshotManager.createInitialSnapshot(
            store.close();
    }  
                        if (Files.deleteIfExists(dir.resolve(file)) == false) {
                new DummyShardLock(shardId),
                1L,  
    private static FileDeleter combinedFileDeleter(Map<String, Path> formatDirs) {
    // ---- Test 5: Recovery then normal operation ----
            );
        }  
                0L,
            );
        Path baseDir = createTempDir();
        return filesToDelete -> {  
        return DirectoryReader.listCommits(store.directory()).size();
            assertEquals("CS1=safe, CS2=last", 2, countLuceneCommits(env.store));  
            Translog.createEmptyTranslog(translogDir, shardId, 100L, 1L, TRANSLOG_UUID, null);
import org.opensearch.index.codec.CodecService;
            Map<String, String> cd = new HashMap<>(snapshot.getUserData());
                Path dir = formatDirs.get(entry.getKey());  
                )
    private static final String PARQUET_FORMAT = "parquet";
        return new TestEnv(committer, store, shardPath, indexDir, parquetDir, translogDir);
            .codecService(  
            );  
 *     parquet/     ← parquet data files
            globalCP.set(200);
        Path parquetDir = dataPath.resolve(PARQUET_FORMAT);
            Segment seg2 = buildSegment(2, lucene2, env.indexDir, parquet2, env.parquetDir);  
                0L,
                List.of(buildSegment(0, lucene0, indexDir, parquet0, parquetDir)),  
    }
                for (String file : entry.getValue()) {  
            for (Map.Entry<String, Collection<String>> entry : filesToDelete.entrySet()) {
                    failed.put(entry.getKey(), failedFiles);
            assertEquals(3, DirectoryReader.listCommits(store.directory()).size());  
            cd1.put(CatalogSnapshot.CATALOG_SNAPSHOT_KEY, cs1.serializeToString());
            );
            AtomicLong globalCP = new AtomicLong(100);
                shardId,
        }
            assertTrue(fileExists(parquetDir, "_3.parquet"));
        iw.flush();
        return filesToDelete -> {  
            // Flush CS2 with globalCP still at 100 — CS1 is safe
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;  
            committer.commit(new CommitInput(cd1.entrySet(), cs1, 0));  
            // seg0 files alive via safe commit CS2
        try (TestEnv env = createTestEnv()) {
            );  
        Files.createDirectories(translogDir);
        cd.put(CatalogSnapshot.CATALOG_SNAPSHOT_KEY, initial.serializeToString());
                1L,  
        // Phase 1: Pre-crash — 2 commits
            String phaseTranslogUUID = Translog.createEmptyTranslog(  
import org.opensearch.index.engine.exec.WriterFileSet;  
                    buildSegment(1, lucene1, env.indexDir, parquet1, env.parquetDir),
                1L,
    }
import org.opensearch.test.DummyShardLock;
        Set<String> filesAfterMerge = Set.of(store.directory().listAll());  
        return Files.exists(dir.resolve(fileName));  
                new DataFormatAwareStoreDirectory(new NIOFSDirectory(indexDir), shardPath, java.util.Map.of()),
            var policy = new CombinedCatalogSnapshotDeletionPolicy(logger, new DefaultTranslogDeletionPolicy(-1, -1, 0), globalCP::get);  
                Map.of(),
            for (String f : parquet2)
                assertTrue("parquet0 alive (ref'd by latest): " + f, fileExists(env.parquetDir, f));  
    private Set<String> ingestParquetFiles(Path parquetDir, String... fileNames) throws IOException {
                shardPath,  
import org.opensearch.core.index.shard.ShardId;
            }  
            assertEquals("Only safe commit remains", 1, DirectoryReader.listCommits(store.directory()).size());
            return failed;
    private Segment buildSegment(long gen, Set<String> luceneFiles, Path indexDir, Set<String> parquetFiles, Path parquetDir) {  
import org.apache.logging.log4j.LogManager;
import java.util.Map;
            Segment seg0 = buildSegment(0, lucene0, env.indexDir, parquet0, env.parquetDir);
    // ---- Ingest helpers ----
                new DummyShardLock(shardId),
                policy  
                new CommitterConfig(buildEngineConfig(indexSettings, store, shardId, translogDir), () -> {})
            // Refresh: CS2 includes all accumulated segments
    }  
        WriterFileSet parquetWfs = new WriterFileSet(parquetDir.toString(), gen, parquetFiles, numRows, 0L);  
                        }
    /** Creates dummy parquet files on disk. */
            Files.createDirectories(translogDir);  
        Path parquetDir = dataPath.resolve(PARQUET_FORMAT);  
            );
        ShardId shardId = new ShardId("test", "_na_", 0);
            CatalogSnapshot cs2 = CatalogSnapshotManager.createInitialSnapshot(
            policy,  
            env.shardPath,
 * Integration tests wiring a real {@link LuceneCommitter} with  
                translogDir,
                Store.OnClose.EMPTY,
        Files.createDirectories(translogDir);
                env,
            // --- Advance globalCP to 300, refresh + flush: all old commits deleted ---
        }
            for (String f : lucene0)  
                assertTrue(fileExists(env.parquetDir, f));  
    private TestEnv createTestEnv() throws IOException {
            globalCP.set(200);
            // lucene0 files still alive — CS3 references seg0
            committer.close();
            assertTrue(fileExists(parquetDir, "_0.parquet"));
            for (String f : lucene1)
            for (String f : lucene0)
            );
            // seg0 parquet files still alive (CS2 references them)
            manager.commitNewSnapshot(List.of(seg0, seg1));  
                if (!failedFiles.isEmpty()) {  
import org.opensearch.index.engine.exec.commit.Committer.CommitInput;
import org.opensearch.index.engine.exec.Segment;
            assertEquals("Only CS3's commit remains", 1, DirectoryReader.listCommits(store.directory()).size());
                1L,  
import org.apache.lucene.document.StringField;  
        }  
            var policy = new CombinedCatalogSnapshotDeletionPolicy(logger, new DefaultTranslogDeletionPolicy(-1, -1, 0), globalCP::get);  
                new CodecService(null, indexSettings, LogManager.getLogger(LuceneCommitterCSManagerIntegrationTests.class), List.of())
    /**
                commitUserData(100, 100)
            Set<String> lucene1 = ingestLuceneDocs(env.committer, env.store);  
import org.opensearch.test.OpenSearchTestCase;  
                assertTrue("lucene2 alive: " + f, fileExists(env.indexDir, f));  
import org.opensearch.index.engine.exec.commit.CommitterConfig;
                List.of(),
                List.of(
        Map<String, String> ud = new HashMap<>();
        Set<String> lucene0, lucene1, lucene2;
            lucene0 = ingestLuceneDocs(committer, store);  
                committer
                List.of(buildSegment(0, lucene0, indexDir, parquet0, parquetDir), buildSegment(1, lucene1, indexDir, parquet1, parquetDir)),  
            for (String f : parquet1)
                }
            var policy = new CombinedCatalogSnapshotDeletionPolicy(logger, new DefaultTranslogDeletionPolicy(-1, -1, 0), () -> 100L);  
            doFlush(manager, env.committer, 300, 300);
        try (TestEnv env = createTestEnv()) {
                combinedFileDeleter(Map.of(PARQUET_FORMAT, parquetDir, LUCENE_FORMAT, indexDir)),  
 * this file be licensed under the Apache-2.0 license or a
            TRANSLOG_UUID,
        implements  
            for (String f : lucene1)
                100,
                assertTrue("alive via CS2: " + f, fileExists(env.indexDir, f));
                Store.OnClose.EMPTY,  
            // --- Advance globalCP to 200, refresh + flush to trigger policy ---
 * SPDX-License-Identifier: Apache-2.0
                assertTrue(fileExists(env.parquetDir, f));
                shardPath
        List<Segment> segments,  
            for (String f : parquet0)  
                List.of(buildSegment(0, lucene0, indexDir, parquet0, parquetDir)),
            for (String f : lucene1)
            return failed;
        }
            // Recreate translog with globalCP=100  
            Store store = new Store(
            AutoCloseable {
                indexSettings,
        }  
            cd1.put(CatalogSnapshot.CATALOG_SNAPSHOT_ID, Long.toString(cs1.getId()));  
            AtomicLong globalCP = new AtomicLong(100);
import org.opensearch.index.IndexSettings;  
                committer.listCommittedSnapshots(),
        // Create a real translog so readGlobalCheckpoint works during safe bootstrap
    }
    }
            manager.close();  
            store.close();  
 * {@link CatalogSnapshotManager} and {@link CombinedCatalogSnapshotDeletionPolicy}.
        ShardPath shardPath = new ShardPath(false, dataPath, dataPath, shardId);  
            committer.close();  
    }
        WriterFileSet luceneWfs = new WriterFileSet(indexDir.toString(), gen, luceneFiles, numRows, 0L);
                List.of(
                new CommitterConfig(buildEngineConfig(indexSettings, store, shardId, translogDir), () -> {})
                    buildSegment(3, lucene3, indexDir, parquet3, parquetDir)  
                assertTrue("parquet2 alive (ref'd by latest): " + f, fileExists(env.parquetDir, f));
 *  
        {
 * <p>Real Lucene documents are ingested so segments_N references real segment files.
            Set<String> lucene1 = ingestLuceneDocs(env.committer, env.store);
import org.opensearch.index.seqno.RetentionLeases;
                }
/**
                    buildSegment(0, lucene0, env.indexDir, parquet0, env.parquetDir),  
            shardPath  
            CatalogSnapshotManager manager = bootstrap(env, List.of(seg0), 100, 100, policy);
            // All segment files still alive — CS2 and later reference all segments  
            AtomicLong globalCP = new AtomicLong(100);
                new CommitterConfig(buildEngineConfig(indexSettings, store, shardId, translogDir), () -> {})
        Files.createDirectories(indexDir);
        Path translogDir = dataPath.resolve("translog");
            doFlush(manager, env.committer, 200, 200);
                ),  
                shardPath
            Set<String> parquet3 = ingestParquetFiles(parquetDir, "_3.parquet");
                new DataFormatAwareStoreDirectory(new NIOFSDirectory(indexDir), shardPath, java.util.Map.of()),
                assertTrue(fileExists(env.indexDir, f));
