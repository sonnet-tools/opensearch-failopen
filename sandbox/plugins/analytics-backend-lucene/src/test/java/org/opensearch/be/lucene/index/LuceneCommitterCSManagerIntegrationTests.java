    private Set<String> ingestParquetFiles(Path parquetDir, String... fileNames) throws IOException {
    private CatalogSnapshotManager bootstrap(
            for (String f : lucene2)
            for (String f : parquet2)
            Set<String> parquet2 = ingestParquetFiles(env.parquetDir, "_2.parquet");
                assertTrue(fileExists(env.parquetDir, f));
        }
        Set<String> mergedFiles = new HashSet<>(filesAfterMerge);
            // seg0 lucene files still alive (CS2 references them), but CS1's commit is gone
        return filesToDelete -> {
        Files.createDirectories(dataPath);
                    try {
            store.close();
    private int countLuceneCommits(Store store) throws IOException {
                    buildSegment(2, lucene2, indexDir, parquet2, parquetDir)
            AtomicLong globalCP = new AtomicLong(100);
import org.opensearch.index.engine.exec.commit.Committer.CommitInput;
import java.util.List;
    private void doFlush(CatalogSnapshotManager manager, LuceneCommitter committer, long maxSeqNo, long localCP) throws IOException {
            // CS2, CS3, CS4 all deleted. Only CS6(flush)=safe=last remains
            );
                assertTrue("protected: " + f, fileExists(env.parquetDir, f));
import org.opensearch.index.seqno.SequenceNumbers;
    private Set<String> ingestLuceneDocs(LuceneCommitter committer, Store store) throws IOException {
import org.opensearch.index.store.DataFormatAwareStoreDirectory;
        store.createEmpty(org.apache.lucene.util.Version.LATEST, createdTranslogUUID);
            Map<String, Collection<String>> failed = new HashMap<>();
    }
            Set<String> parquet0 = ingestParquetFiles(env.parquetDir, "_0.parquet");
                SequenceNumbers.NO_OPS_PERFORMED,
            Set<String> parquet1 = ingestParquetFiles(env.parquetDir, "_1.parquet");
                commitUserData(200, 200)
        ShardPath shardPath = new ShardPath(false, dataPath, dataPath, shardId);
            );
            );
                committer
    private static Map<String, String> commitUserData(long maxSeqNo, long localCheckpoint) {
                assertTrue("parquet0 alive (ref'd by CS2): " + f, fileExists(env.parquetDir, f));
            CatalogSnapshotManager manager = bootstrap(env, List.of(seg0), 100, 100, policy);
            assertEquals(1, DirectoryReader.listCommits(store.directory()).size());
        Path parquetDir = dataPath.resolve(PARQUET_FORMAT);
        // Phase 1: Pre-crash — 3 commits
        ShardPath shardPath = new ShardPath(false, dataPath, dataPath, shardId);
 *
    /** Creates dummy parquet files on disk. */
            Map.of(),
            for (String f : parquet1)
            CatalogSnapshotManager manager = bootstrap(env, List.of(seg0), 100, 100, policy);
    private int docCounter = 0;
            Store.OnClose.EMPTY,
package org.opensearch.be.lucene.index;
                0L,
                null
                TRANSLOG_UUID,
            policy,
        // Phase 1: Pre-crash — 2 commits
        }
            manager.commitNewSnapshot(List.of(seg0, seg1, seg2));
            AutoCloseable {
                        failedFiles.add(file);
    }
                assertTrue("lucene0 survives: " + f, fileExists(indexDir, f));
        }
        @Override
 * <pre>
                indexSettings,
            for (String f : lucene0)
            assertFalse("_2.parquet orphan", fileExists(parquetDir, "_2.parquet"));
            for (String f : parquet0)
    private static final String LUCENE_FORMAT = "lucene";
        Path indexDir = dataPath.resolve("index");
                )
                translogDir,
        Path dataPath = baseDir.resolve(shardId.getIndex().getUUID()).resolve(Integer.toString(shardId.id()));
                new DummyShardLock(shardId),
        LuceneCommitter committer = new LuceneCommitter(
                assertTrue("parquet2 alive: " + f, fileExists(env.parquetDir, f));
                assertTrue(fileExists(env.indexDir, f));
                assertTrue("alive via safe: " + f, fileExists(env.indexDir, f));
import java.util.Collection;
            if (Files.exists(parquetDir.resolve(f)) == false) {
                    if (Files.deleteIfExists(dir.resolve(file)) == false) {
                    buildSegment(0, lucene0, env.indexDir, parquet0, env.parquetDir),
                new CodecService(null, indexSettings, LogManager.getLogger(LuceneCommitterCSManagerIntegrationTests.class), List.of())
import org.opensearch.index.engine.exec.WriterFileSet;
            cd2.put(CatalogSnapshot.CATALOG_SNAPSHOT_KEY, cs2.serializeToString());
 * </pre>
        Path dataPath = baseDir.resolve(shardId.getIndex().getUUID()).resolve(Integer.toString(shardId.id()));
        Path parquetDir = dataPath.resolve(PARQUET_FORMAT);
            assertEquals("Only CS3's commit remains", 1, DirectoryReader.listCommits(store.directory()).size());
    }
            assertFalse("_1.parquet orphan deleted", fileExists(parquetDir, "_1.parquet"));
import org.opensearch.common.util.BigArrays;
                for (String file : entry.getValue()) {
            Set<String> parquet0 = ingestParquetFiles(env.parquetDir, "_0.parquet");
                List.of(
                2L,
        {
            Segment seg0 = buildSegment(0, lucene0, env.indexDir, parquet0, env.parquetDir);
            globalCP.set(200);
import org.opensearch.index.engine.exec.commit.CommitterConfig;
            for (String f : parquet2)
import org.apache.lucene.document.StringField;
            Files.createDirectories(translogDir);
        Path indexDir = dataPath.resolve("index");
                if (!failedFiles.isEmpty()) {
            assertEquals("Only latest commit remains", 1, countLuceneCommits(env.store));
                indexSettings,
        Files.createDirectories(indexDir);
                List.of(buildSegment(0, lucene0, env.indexDir, parquet0, env.parquetDir)),
import org.apache.lucene.document.Field;
        iw.forceMerge(1);
    // ---- Ingest helpers ----
 * SPDX-License-Identifier: Apache-2.0
    public void testRecoveryAfterCrashTrimsUnsafeCommits() throws Exception {
            );
    private record TestEnv(LuceneCommitter committer, Store store, ShardPath shardPath, Path indexDir, Path parquetDir, Path translogDir)
            manager.close();
            );
    private boolean fileExists(Path dir, String fileName) {
        Set<String> filesAfterMerge = Set.of(store.directory().listAll());
            1L,
                    }
            );
            var policy = new CombinedCatalogSnapshotDeletionPolicy(logger, new DefaultTranslogDeletionPolicy(-1, -1, 0), globalCP::get);
                List.of(buildSegment(0, lucene0, indexDir, parquet0, parquetDir), buildSegment(1, lucene1, indexDir, parquet1, parquetDir)),
            for (String f : parquet0)
            assertEquals("CS2 + CS3 + CS4", 3, countLuceneCommits(env.store));
                    buildSegment(0, lucene0, indexDir, parquet0, parquetDir),
            String phaseTranslogUUID = Translog.createEmptyTranslog(
                indexSettings,
            doFlush(manager, env.committer, 300, 300);
            env.committer.listCommittedSnapshots(),
        }
            cd3.put(CatalogSnapshot.CATALOG_SNAPSHOT_ID, Long.toString(cs3.getId()));
        Path translogDir = dataPath.resolve("translog");
            // --- CS1: ingest, bootstrap, flush (lcp=100, globalCP=100) ---
            }
                shardId,
        env.committer.commit(new CommitInput(cd.entrySet(), initial, 0));
        }
    }
            Set<String> lucene2 = ingestLuceneDocs(env.committer, env.store);
            Set<String> parquet2 = ingestParquetFiles(env.parquetDir, "_2.parquet");
            }
            for (Map.Entry<String, Collection<String>> entry : filesToDelete.entrySet()) {
                shardPath,
                assertTrue("alive via safe: " + f, fileExists(env.parquetDir, f));
            doFlush(manager, env.committer, 300, 300);
            for (String f : lucene2)
            // Each snapshot includes ALL accumulated segments (matching production behavior)
                if (dir == null) continue;
        return new CatalogSnapshotManager(
                assertTrue("lucene0 alive (ref'd by latest): " + f, fileExists(env.indexDir, f));
import org.opensearch.index.shard.ShardPath;
    }
            cd2.put(CatalogSnapshot.CATALOG_SNAPSHOT_ID, Long.toString(cs2.getId()));
            LuceneCommitter committer = new LuceneCommitter(
            var policy = new CombinedCatalogSnapshotDeletionPolicy(logger, new DefaultTranslogDeletionPolicy(-1, -1, 0), globalCP::get);
            assertTrue("CS1's commit still exists", countLuceneCommits(env.store) >= 2);
            for (Map.Entry<String, Collection<String>> entry : filesToDelete.entrySet()) {
            env.committer
 * this file be licensed under the Apache-2.0 license or a
            LuceneCommitter committer = new LuceneCommitter(
                new CommitterConfig(buildEngineConfig(indexSettings, store, shardId, translogDir), () -> {})
                new DataFormatAwareStoreDirectory(new NIOFSDirectory(indexDir), shardPath, java.util.Map.of()),
            );
            Set<String> lucene1 = ingestLuceneDocs(env.committer, env.store);
            return failed;
                List.of(),
            Set<String> parquet0 = ingestParquetFiles(parquetDir, "_0.parquet");
        try (GatedConditionalCloseable<CatalogSnapshot> handle = manager.acquireSnapshotForCommit()) {
 * <p>Directory layout mirrors production:
        Path translogDir = dataPath.resolve("translog");
                policy
            Set<String> lucene0 = ingestLuceneDocs(env.committer, env.store);
                new CommitterConfig(buildEngineConfig(indexSettings, store, shardId, translogDir), () -> {})
                List.of(
            committer.commit(new CommitInput(cd2.entrySet(), cs2, 0));
                for (String file : entry.getValue()) {
            globalCP.set(200);
            for (String f : parquet2)
import org.opensearch.index.codec.CodecService;
                new DummyShardLock(shardId),
            doFlush(manager, env.committer, 200, 200);
            // --- Advance globalCP to 300, refresh + flush: all old commits deleted ---
}
                    }
            committer.commit(new CommitInput(cd1.entrySet(), cs1, 0));
        return ud;
            globalCP.set(200);
            Set<String> lucene1 = ingestLuceneDocs(committer, store);
                List.of(buildSegment(0, lucene0, indexDir, parquet0, parquetDir), buildSegment(1, lucene1, indexDir, parquet1, parquetDir)),
            translogDir,
        Path dataPath = baseDir.resolve(shardId.getIndex().getUUID()).resolve(Integer.toString(shardId.id()));
    }
            cd.put(CatalogSnapshot.CATALOG_SNAPSHOT_KEY, snapshot.serializeToString());
            Map<String, String> cd1 = new HashMap<>(cs1.getUserData());
import org.opensearch.index.engine.exec.Segment;
            for (String f : lucene0)
public class LuceneCommitterCSManagerIntegrationTests extends OpenSearchTestCase {
            CatalogSnapshotManager manager = new CatalogSnapshotManager(
    private static FileDeleter combinedFileDeleter(Map<String, Path> formatDirs) {
            Translog.createEmptyTranslog(translogDir, shardId, 100L, 1L, TRANSLOG_UUID, null);
            for (String f : parquet0)
            new CommitterConfig(buildEngineConfig(indexSettings, store, shardId, translogDir), () -> {})
                Path dir = formatDirs.get(entry.getKey());
            // --- CS2: ingest, refresh, flush (lcp=200, globalCP=100) ---
                    buildSegment(0, lucene0, env.indexDir, parquet0, env.parquetDir),
import org.opensearch.test.IndexSettingsModule;
            for (String f : lucene0)
        return DirectoryReader.listCommits(store.directory()).size();
            for (String f : parquet2)
            return failed;
            assertEquals(3, DirectoryReader.listCommits(store.directory()).size());
                assertTrue("alive via CS2: " + f, fileExists(env.indexDir, f));
            for (String f : lucene0)
            for (String f : parquet0)
            CatalogSnapshotManager manager = bootstrap(
        return Files.exists(dir.resolve(fileName));
                assertTrue("lucene1 alive (ref'd by latest): " + f, fileExists(env.indexDir, f));
        return Set.of(fileNames);
        );
            Store store = new Store(
                commitUserData(100, 100)
            assertTrue(fileExists(parquetDir, "_3.parquet"));
 * {@link CatalogSnapshotManager} and {@link CombinedCatalogSnapshotDeletionPolicy}.
            assertEquals("CS1 + CS2 + CS3", 3, countLuceneCommits(env.store));
                2L,
        Files.createDirectories(dataPath);
        };
        Path baseDir = createTempDir();
            cd3.put(CatalogSnapshot.CATALOG_SNAPSHOT_KEY, cs3.serializeToString());
                assertTrue("lucene2 alive (ref'd by latest): " + f, fileExists(env.indexDir, f));
        mergedFiles.removeIf(f -> f.startsWith("segments") || f.equals("write.lock"));
            Map<String, String> cd = new HashMap<>(snapshot.getUserData());
    private static FileDeleter fileDeleterFor(Path dir) {
            );
        mergedFiles.removeAll(filesBeforeMerge);
            assertEquals("CS2 (safe) + CS3 (last)", 2, countLuceneCommits(env.store));
            manager.close();
                0L,
 *     index/       ← Lucene directory (segments_N + real .cfs/.cfe/.si files)
        Files.createDirectories(translogDir);
                new CommitterConfig(buildEngineConfig(indexSettings, store, shardId, translogDir), () -> {})
        Path baseDir = createTempDir();
                assertTrue(fileExists(env.indexDir, f));
    }
                assertTrue(fileExists(env.parquetDir, f));
            assertTrue("_0.parquet alive via CS3", fileExists(parquetDir, "_0.parquet"));
            // --- CS3: ingest, refresh, flush (lcp=300, globalCP=100) ---
            for (String f : lucene3)
        cd.put(CatalogSnapshot.CATALOG_SNAPSHOT_ID, Long.toString(initial.getId()));
import org.opensearch.index.translog.TranslogConfig;
            );
            cd1.put(CatalogSnapshot.CATALOG_SNAPSHOT_KEY, cs1.serializeToString());
            );
            cd.put(CatalogSnapshot.CATALOG_SNAPSHOT_ID, Long.toString(snapshot.getId()));
        try (TestEnv env = createTestEnv()) {
            // Refresh: CS2 keeps seg0, adds seg1
        // Phase 2: Recovery + normal operation
        {
                100,
            assertTrue(fileExists(parquetDir, "_0.parquet"));
        try (TestEnv env = createTestEnv()) {
        // Create a real translog so readGlobalCheckpoint works during safe bootstrap
            LuceneCommitter committer = new LuceneCommitter(
            TRANSLOG_UUID,
import org.opensearch.index.seqno.RetentionLeases;
        Set<String> filesBeforeMerge = Set.of(store.directory().listAll());
            SequenceNumbers.NO_OPS_PERFORMED,
                shardId,
            );
                Collection<String> failedFiles = new ArrayList<>();
                assertTrue(fileExists(env.indexDir, f));
/*
        Set<String> lucene0, lucene1, lucene2;
    public void testRecoveryThenNormalOperationWorks() throws Exception {
                }
            Set<String> parquet2 = ingestParquetFiles(parquetDir, "_2.parquet");
            store.close();
    public void testMultipleFlushCyclesWithSafeCommitProgression() throws Exception {
    public void testSnapshotProtectionPreservesAllFiles() throws Exception {
            );
        if (translogPath != null) {
                shardId,
                2L,
        ShardId shardId = new ShardId("test", "_na_", 0);
                assertTrue("protected: " + f, fileExists(env.indexDir, f));
import java.util.HashSet;
            for (String f : lucene1)
            Segment seg1 = buildSegment(1, lucene1, env.indexDir, parquet1, env.parquetDir);
    private static final String TRANSLOG_UUID = "test-translog-uuid";
    public void testRefCountingPreservesSharedFilesAcrossCommits() throws Exception {
            // Flush CS2 with globalCP still at 100 — CS1 is safe
                assertTrue("parquet2 alive (ref'd by latest): " + f, fileExists(env.parquetDir, f));
        return new TestEnv(committer, store, shardPath, indexDir, parquetDir, translogDir);
            assertEquals("CS1=safe, CS2=last", 2, countLuceneCommits(env.store));
 */
            var policy = new CombinedCatalogSnapshotDeletionPolicy(logger, new DefaultTranslogDeletionPolicy(-1, -1, 0), globalCP::get);
            manager.commitNewSnapshot(List.of(seg0, seg1, seg2));
        ud.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, Long.toString(localCheckpoint));
            var policy = new CombinedCatalogSnapshotDeletionPolicy(logger, new DefaultTranslogDeletionPolicy(-1, -1, 0), () -> 100L);
import org.opensearch.index.engine.exec.FileDeleter;
                )
            manager.close();
            // seg0 files alive via safe commit CS2
                3L,
                    buildSegment(0, lucene0, indexDir, Set.of("_0.parquet"), parquetDir),
            committer.close();
    // ---- TestEnv ----
            // CS1 deleted by policy. CS2=safe(200<=200), CS3, CS4(flush)=last → 3 commits
                assertTrue(fileExists(env.indexDir, f));
            manager.commitNewSnapshot(
            Set<String> parquet0 = ingestParquetFiles(env.parquetDir, "_0.parquet");
            }
        ud.put(Translog.TRANSLOG_UUID_KEY, TRANSLOG_UUID);
import org.opensearch.index.engine.exec.coord.CatalogSnapshotManager;
                policy,
        Files.createDirectories(dataPath);
    // ---- Test 2: Shared files preserved when referencing commit exists ----
            );
                            failedFiles.add(file);
            // Recreate translog with globalCP=100 to simulate persisted state at crash
                1L,
    }
            builder.translogConfig(new TranslogConfig(shardId, translogPath, indexSettings, BigArrays.NON_RECYCLING_INSTANCE, "", false));
        };
                List.of(buildSegment(0, lucene0, indexDir, parquet0, parquetDir)),
            for (String f : lucene0)
        TestEnv env,
                commitUserData(200, 200)
            for (String f : lucene1)
            Set<String> parquet1 = ingestParquetFiles(env.parquetDir, "_1.parquet");
 *   shardPath/
        cd.put(CatalogSnapshot.CATALOG_SNAPSHOT_KEY, initial.serializeToString());
                3L,
            for (String f : lucene1)
            cd1.put(CatalogSnapshot.CATALOG_SNAPSHOT_ID, Long.toString(cs1.getId()));
import org.opensearch.index.engine.exec.CombinedCatalogSnapshotDeletionPolicy;
                0L,
            shardId,
            Set<String> parquet1 = ingestParquetFiles(parquetDir, "_1.parquet");
    // ---- Test 4: Recovery trims unsafe commits, cleans orphans ----
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
            assertEquals("Only safe commit remains", 1, DirectoryReader.listCommits(store.directory()).size());
                1L,
            // All segment files still alive — CS2 and later reference all segments
     * Ingests a real Lucene document, then force-merges all segments into one.
            );
/**
                assertTrue("parquet0 alive (ref'd by latest): " + f, fileExists(env.parquetDir, f));
                shardPath
            null
                SequenceNumbers.NO_OPS_PERFORMED,
            for (String f : lucene0)
            for (String f : parquet0)
                1L,
            manager.close();
        CombinedCatalogSnapshotDeletionPolicy policy
 *
            CatalogSnapshot cs1 = CatalogSnapshotManager.createInitialSnapshot(
                commitUserData(300, 300)
            // Hold CS1
            doFlush(manager, env.committer, 300, 300);
            store.close();
            manager.commitNewSnapshot(
            Map<String, String> cd1 = new HashMap<>(cs1.getUserData());
            Files.createDirectories(translogDir);
            cd2.put(CatalogSnapshot.CATALOG_SNAPSHOT_KEY, cs2.serializeToString());
            for (String f : lucene0)
            );
            for (String f : lucene0)
            // Normal operation: ingest + refresh + flush
        Set<String> lucene0;
                committer
                Map.of(),
                Store.OnClose.EMPTY,
    }
                assertTrue(fileExists(env.parquetDir, f));
        WriterFileSet luceneWfs = new WriterFileSet(indexDir.toString(), gen, luceneFiles, numRows, 0L);
                assertTrue("parquet1 alive (ref'd by latest): " + f, fileExists(env.parquetDir, f));
                assertTrue("lucene0 alive via CS3: " + f, fileExists(indexDir, f));
            new DataFormatAwareStoreDirectory(new NIOFSDirectory(indexDir), shardPath, java.util.Map.of()),
            shardId,
                        failedFiles.add(file);
    ) throws IOException {
        }
            for (String f : lucene2)
            doFlush(manager, env.committer, 200, 200);
        CatalogSnapshot initial = CatalogSnapshotManager.createInitialSnapshot(1L, 1L, 0L, segments, 1L, commitUserData(maxSeqNo, localCP));
            Map<String, String> cd2 = new HashMap<>(cs2.getUserData());
    // ---- Commit helpers ----
    private TestEnv createTestEnv() throws IOException {
        Map<String, String> cd = new HashMap<>(initial.getUserData());
            Segment seg1 = buildSegment(1, lucene1, env.indexDir, parquet1, env.parquetDir);
            .codecService(
            Segment seg2 = buildSegment(2, lucene2, env.indexDir, parquet2, env.parquetDir);
import java.util.HashMap;
                assertTrue("lucene0 alive (ref'd by CS2): " + f, fileExists(env.indexDir, f));
        public void close() throws Exception {
                    buildSegment(1, lucene1, env.indexDir, parquet1, env.parquetDir),
                }
    }
        }
import org.opensearch.test.DummyShardLock;
            );
                env,
        {
    }
import org.apache.lucene.store.NIOFSDirectory;
            Set<String> lucene0 = ingestLuceneDocs(env.committer, env.store);
            Set<String> lucene1 = ingestLuceneDocs(env.committer, env.store);
                assertTrue(fileExists(indexDir, f));
import org.opensearch.index.translog.DefaultTranslogDeletionPolicy;
                translogDir,
                1L,
                )
            );
        EngineConfig.Builder builder = new EngineConfig.Builder().indexSettings(indexSettings)
                2L,
import org.opensearch.index.IndexSettings;
 * and managed by our IndexFileDeleter.
        Files.createDirectories(translogDir);
        return filesToDelete -> {
    }
                Store.OnClose.EMPTY,
        iw.flush();
    }
    }
     * lucene files are self-contained with no cross-snapshot references.
import org.opensearch.test.OpenSearchTestCase;
                    buildSegment(1, lucene1, env.indexDir, parquet1, env.parquetDir)
        return mergedFiles;
            store.close();
            globalCP.set(300);
                    failed.put(entry.getKey(), failedFiles);
            for (String f : parquet1)
            // lucene0 files still alive — CS3 references seg0
                List.of(buildSegment(0, lucene0, indexDir, parquet0, parquetDir)),
    /** Builds a multi-format Segment from ingested lucene and parquet files. */
        Files.createDirectories(parquetDir);
        }
                assertTrue("alive via CS2: " + f, fileExists(env.parquetDir, f));
            assertEquals("Only CS2's commit remains", 1, countLuceneCommits(env.store));
            CatalogSnapshot cs3 = CatalogSnapshotManager.createInitialSnapshot(
import org.opensearch.common.settings.Settings;
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);
    private static EngineConfig buildEngineConfig(IndexSettings indexSettings, Store store, ShardId shardId, Path translogPath) {
                    buildSegment(1, lucene1, indexDir, parquet1, parquetDir),
    private Segment buildSegment(long gen, Set<String> luceneFiles, Path indexDir, Set<String> parquetFiles, Path parquetDir) {
                TRANSLOG_UUID,
            List.of(),
            cd1.put(CatalogSnapshot.CATALOG_SNAPSHOT_KEY, cs1.serializeToString());
                shardId,
            )
            LuceneCommitter committer = new LuceneCommitter(
        Files.createDirectories(indexDir);
            Map<String, Collection<String>> failed = new HashMap<>();
            store.createEmpty(org.apache.lucene.util.Version.LATEST, phaseTranslogUUID);
            manager.commitNewSnapshot(List.of(seg0, seg1, seg2));
        ShardPath shardPath = new ShardPath(false, dataPath, dataPath, shardId);
 * <p>Real Lucene documents are ingested so segments_N references real segment files.
                3L,
            committer.close();
        );
        Files.createDirectories(translogDir);
        }
                shardPath
                new DataFormatAwareStoreDirectory(new NIOFSDirectory(indexDir), shardPath, java.util.Map.of()),
                1L,
            );
                combinedFileDeleter(Map.of(PARQUET_FORMAT, parquetDir, LUCENE_FORMAT, indexDir)),
        Path parquetDir = dataPath.resolve(PARQUET_FORMAT);
            for (String f : parquet0)
        // Phase 2: Recovery — globalCP=100
            .retentionLeasesSupplier(() -> new RetentionLeases(0, 0, java.util.Collections.emptyList()));
        }
                commitUserData(100, 100)
                ),
import java.util.Set;
            Set<String> parquet3 = ingestParquetFiles(parquetDir, "_3.parquet");
            CatalogSnapshotManager manager = new CatalogSnapshotManager(
            held.close();
                new DataFormatAwareStoreDirectory(new NIOFSDirectory(indexDir), shardPath, java.util.Map.of()),
            Map<String, String> cd3 = new HashMap<>(cs3.getUserData());
            for (String f : lucene2)
        Path indexDir = dataPath.resolve("index");
                shardId,
            CatalogSnapshot cs1 = CatalogSnapshotManager.createInitialSnapshot(
                null
            Set<String> parquet1 = ingestParquetFiles(env.parquetDir, "_1.parquet");
 * Both lucene-format and parquet-format files are tracked in CatalogSnapshot
        for (String f : fileNames) {
                Map.of(),
            GatedCloseable<CatalogSnapshot> held = manager.acquireCommittedSnapshot(false);
            Set<String> parquet1 = ingestParquetFiles(parquetDir, "_1.parquet");
        ud.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(maxSeqNo));
    }
            doFlush(manager, env.committer, 200, 200);
            manager.close();
        Store store = new Store(
        try (TestEnv env = createTestEnv()) {
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);
                Files.createFile(parquetDir.resolve(f));
        Files.createDirectories(parquetDir);
            // CS1 protected by held snapshot — all files alive
            AtomicLong globalCP = new AtomicLong(100);
        long maxSeqNo,
                shardPath
 *
            snapshot.setUserData(commitUserData(maxSeqNo, localCP), true);
            String phaseTranslogUUID = Translog.createEmptyTranslog(
                0L,
        ShardId shardId = new ShardId("test", "_na_", 0);
                }
                new CommitterConfig(buildEngineConfig(indexSettings, store, shardId, translogDir), () -> {})
            // Release — CS1 deleted, but seg0 files still alive via CS2
                indexSettings,
        return new Segment(gen, Map.of(LUCENE_FORMAT, luceneWfs, PARQUET_FORMAT, parquetWfs));
                    } catch (IOException e) {
        Path translogDir = dataPath.resolve("translog");
                    buildSegment(2, lucene2, env.indexDir, parquet2, env.parquetDir)
                committer.listCommittedSnapshots(),
        ShardId shardId = new ShardId("test", "_na_", 0);
                assertTrue(fileExists(env.indexDir, f));
            Translog.createEmptyTranslog(translogDir, shardId, 100L, 1L, TRANSLOG_UUID, null);
            doFlush(manager, committer, 300, 300);
            new DummyShardLock(shardId),
            // seg0 parquet files still alive (CS2 references them)
import java.util.concurrent.atomic.AtomicLong;
                assertTrue("lucene0 survives: " + f, fileExists(indexDir, f));
                assertTrue(fileExists(env.parquetDir, f));
                new DataFormatAwareStoreDirectory(new NIOFSDirectory(indexDir), shardPath, java.util.Map.of()),
        List<Segment> segments,
            org.opensearch.common.util.io.IOUtils.rm(translogDir);
            CatalogSnapshot cs2 = CatalogSnapshotManager.createInitialSnapshot(
                new DummyShardLock(shardId),
            Set<String> lucene3 = ingestLuceneDocs(committer, store);
 * Integration tests wiring a real {@link LuceneCommitter} with
import org.opensearch.common.concurrent.GatedCloseable;
                    buildSegment(3, lucene3, indexDir, parquet3, parquetDir)
        WriterFileSet parquetWfs = new WriterFileSet(parquetDir.toString(), gen, parquetFiles, numRows, 0L);
    }
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);
                2L,
        );
            combinedFileDeleter(Map.of(PARQUET_FORMAT, env.parquetDir, LUCENE_FORMAT, env.indexDir)),
                }
                if (!failedFiles.isEmpty()) {
                new DummyShardLock(shardId),
            CatalogSnapshot cs2 = CatalogSnapshotManager.createInitialSnapshot(
    }
            indexSettings,
     * Returns only the merged segment's files — ensuring each CatalogSnapshot's
import java.nio.file.Files;
            var policy = new CombinedCatalogSnapshotDeletionPolicy(logger, new DefaultTranslogDeletionPolicy(-1, -1, 0), globalCP::get);
            );
                Store.OnClose.EMPTY,
                assertTrue("parquet1 alive (safe): " + f, fileExists(env.parquetDir, f));
        );
            );
            committer.commit(new CommitInput(cd.entrySet(), snapshot, 0));
import org.opensearch.common.concurrent.GatedConditionalCloseable;
            handle.markSuccess();
            );
            store.close();
            Map<String, String> cd2 = new HashMap<>(cs2.getUserData());
            // --- Advance globalCP to 200, refresh + flush to trigger policy ---
import java.util.ArrayList;
            // CS2/CS3 orphan parquet files cleaned up
        IndexWriter iw = committer.getIndexWriter();
import java.nio.file.Path;
            Store store = new Store(
                assertTrue(fileExists(env.parquetDir, f));
            committer.close();
    // ---- Test 1: Multiple ingest→merge→flush cycles with safe commit progression ----
        Files.createDirectories(parquetDir);
                2L,
            for (String f : lucene0)
                shardPath
        {
            Set<String> parquet0 = ingestParquetFiles(parquetDir, "_0.parquet");
import org.opensearch.index.store.Store;
            CatalogSnapshot snapshot = handle.get();
            AtomicLong globalCP = new AtomicLong(100);
                    failed.put(entry.getKey(), failedFiles);
            committer.close();
            shardPath
            lucene0 = ingestLuceneDocs(committer, store);
            for (String f : parquet1)
        long numRows = 100;
    // ---- Test 5: Recovery then normal operation ----
                shardId,
            committer.commit(new CommitInput(cd1.entrySet(), cs1, 0));
            for (String f : parquet1)
            manager.commitNewSnapshot(List.of(seg0, seg1));
            Set<String> lucene0 = ingestLuceneDocs(env.committer, env.store);
 * The OpenSearch Contributors require contributions made to
        }
            lucene0 = ingestLuceneDocs(committer, store);
                committer.listCommittedSnapshots(),
                Store.OnClose.EMPTY,
        iw.addDocument(List.of(new StringField("id", "doc_" + docCounter++, Field.Store.NO)));
            org.opensearch.common.util.io.IOUtils.rm(translogDir);
            Store store = new Store(
            for (String f : lucene1)
                policy,
                assertTrue("lucene1 alive (safe): " + f, fileExists(env.indexDir, f));
import org.apache.lucene.index.DirectoryReader;
                0L,
    // ---- Test 3: Snapshot protection preserves files across both formats ----
        Path baseDir = createTempDir();
                List.of(),
                1L,
                assertTrue("lucene2 alive: " + f, fileExists(env.indexDir, f));
            manager.commitNewSnapshot(List.of(seg0, seg1));
        String createdTranslogUUID = Translog.createEmptyTranslog(
            Set<String> lucene1 = ingestLuceneDocs(env.committer, env.store);
            assertTrue("_0.parquet survives", fileExists(parquetDir, "_0.parquet"));
                assertTrue(fileExists(env.indexDir, f));
            committer.commit(new CommitInput(cd3.entrySet(), cs3, 0));
import org.apache.logging.log4j.LogManager;
            // All segment files still alive — the latest commit references all segments
            // Advance globalCP, refresh CS3, flush
 *     parquet/     ← parquet data files
 */
        Files.createDirectories(indexDir);
            lucene1 = ingestLuceneDocs(committer, store);
        Map<String, String> ud = new HashMap<>();
            .store(store)
                combinedFileDeleter(Map.of(PARQUET_FORMAT, parquetDir, LUCENE_FORMAT, indexDir)),
            assertFalse("_1.parquet orphan", fileExists(parquetDir, "_1.parquet"));
            AtomicLong globalCP = new AtomicLong(100);
import java.util.Map;
    /**
        implements
import org.opensearch.index.translog.Translog;
            // Recreate translog with globalCP=100
            cd1.put(CatalogSnapshot.CATALOG_SNAPSHOT_ID, Long.toString(cs1.getId()));
import java.io.IOException;
            // Refresh: CS2 includes all accumulated segments
            manager.commitNewSnapshot(
                100,
    }
     */
            doFlush(manager, env.committer, 300, 300);
        long localCP,
            // All 3 commits: CS1=safe, CS2 in between, CS3=last
                List.of(
 * compatible open source license.
            cd2.put(CatalogSnapshot.CATALOG_SNAPSHOT_ID, Long.toString(cs2.getId()));
                assertTrue(fileExists(env.parquetDir, f));
            globalCP.set(300);
                        }
                        if (Files.deleteIfExists(dir.resolve(file)) == false) {
import org.opensearch.core.index.shard.ShardId;
                Collection<String> failedFiles = new ArrayList<>();
            env.shardPath,
                1L,
                List.of(
import org.apache.lucene.index.IndexWriter;
            Segment seg0 = buildSegment(0, lucene0, env.indexDir, parquet0, env.parquetDir);
            committer.commit(new CommitInput(cd2.entrySet(), cs2, 0));
                shardPath,
            committer.close();
            Store store = new Store(
            // CS1's files survive
            lucene2 = ingestLuceneDocs(committer, store);
            Set<String> lucene2 = ingestLuceneDocs(env.committer, env.store);
import org.opensearch.index.engine.EngineConfig;
            store.createEmpty(org.apache.lucene.util.Version.LATEST, phaseTranslogUUID);
            for (String f : lucene0)
            for (String f : parquet0)
    private static final String PARQUET_FORMAT = "parquet";
                1L,
        return builder.build();
