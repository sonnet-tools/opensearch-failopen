/*  
        IndexFileDeleter deleter = new IndexFileDeleter(policy, files -> {
import org.opensearch.index.engine.exec.CombinedCatalogSnapshotDeletionPolicy;  
        return userData;  
            public boolean isCommitManagedFile(String fileName) {
import java.util.Map;
        CatalogSnapshot cs2 = snapshot(2, List.of(segment(1, "parquet", "ok.parquet")), commitUserData(200, 200, "uuid"));
        // Fail twice: once during executeDeletesWithRetry, once during the automatic
        );  
        assertTrue("Should have pending deletes after failed deletion", deleter.hasPendingDeletes());
    }
            probe,
            return failed;
            List.of(cs1),
        // The probe should have recorded that the lock was NOT held during deleteFiles
    public void testDeleteOrphanedFilesSkipsMissingDirectory() throws IOException {
import java.util.Collection;  
        Files.createDirectories(parquetDir);
        assertFalse("segments_1 should be protected by CommitFileManager", tracker.hasDeletedFile("segments_1"));
        assertTrue(tracker.hasDeletedFile("old_b.parquet"));
            null,  
            commitUserData(100, 100, "uuid")
                "lucene",
        CatalogSnapshot cs2 = snapshot(2, List.of(segment(2, "parquet", "new_merged.parquet")), commitUserData(200, 200, "uuid"));
public class IndexFileDeleterTests extends OpenSearchTestCase {
        final Set<String> deletedFiles = new HashSet<>();
        assertTrue("a.parquet should be deleted on explicit retry", failTwice.deletedFiles.contains("a.parquet"));
        private int failuresRemaining;  
        }  
        IndexFileDeleter deleter = new IndexFileDeleter(  
        Files.createDirectories(shardDir);
        assertTrue("orphan.parquet should be deleted", tracker.hasDeletedFile("orphan.parquet"));  
            null,
        CombinedCatalogSnapshotDeletionPolicy policy = new CombinedCatalogSnapshotDeletionPolicy(
    public void testRetryPendingDeletesExplicitCall() throws IOException {
        }
        );
    }
                new WriterFileSet("/data", 1, Set.of("_1.cfs"), 1, 0L)
    }  
        // retryPendingDeletes inside removeFileReferences. Third call succeeds.  
        CatalogSnapshot cs1 = snapshot(1, List.of(segment(0, "parquet", "a.parquet")), commitUserData(100, 100, "uuid"));
        assertTrue(tracker.deletedFiles.isEmpty());
            globalCP::get
        deleter.onCommit(cs2);  
            null,
    public void testOnCommitPreservesSharedFiles() throws IOException {  
        IndexFileDeleter deleter = new IndexFileDeleter(policy, tracker, Map.of(), List.of(cs1), null, null, s -> {});
        assertTrue("b.parquet should be deleted", deleter1.deletedFiles.contains("b.parquet"));  
        assertTrue("File should remain pending after persistent failure", deleter.hasPendingDeletes());
    }
        assertFalse("Lock should not be held during file deletion I/O", probe.lockHeldDuringDelete.isEmpty());  
            CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,  
        };  
            s -> {}
    // ---- Multi-format ----
        // Remove cs1's refs
     */  
            List.of(cs1),
        IndexFileDeleter deleter = new IndexFileDeleter(  
            globalCP::get
        // We need a fresh deleter with the probe. Rebuild.  
        );  
        deleter.addFileReferences(cs2);  
        TrackingFileDeleter tracker = new TrackingFileDeleter();
        IndexFileDeleter deleter = new IndexFileDeleter(
    static class FailNTimesThenSucceedDeleter implements FileDeleter {
            new DefaultTranslogDeletionPolicy(-1, -1, 0),
    }  
            commitMgr,
            null,
        assertFalse(tracker.hasDeletedFile("new_merged.parquet"));  
        // Now create a new deleter with the lock probe, using the deleter instance as the monitor  
        // Rebuild with lock probe
        CatalogSnapshot cs3 = snapshot(3, List.of(segment(2, "parquet", "c.parquet")), commitUserData(300, 300, "uuid"));
        );
    public void testCommitRefKeepsSnapshotAlive() throws IOException {
        assertFalse("No more pending deletes", deleter.hasPendingDeletes());
     * A FileDeleter that fails the first N calls, then succeeds on subsequent calls.
        );  
        // snapshot should reference it.
                new WriterFileSet("/data", 1, Set.of("data2.parquet"), 1, 0L),  
            lockHeldDuringDelete.add(Thread.holdsLock(monitorToProbe));  
            List.of(segment(0, "parquet", "shared.parquet"), segment(2, "parquet", "only_cs2.parquet")),  
 * compatible open source license.
        held.close();  
                "parquet",  
        assertTrue("old.parquet should have been deleted", probe.deletedFiles.contains("old.parquet"));
    public void testPersistentFailureKeepsFilesPending() throws IOException {  
    private static Segment segment(long gen, String format, String... files) {  
        globalCP.set(200);  
            null,
            Map.of(
        final Set<String> deletedFiles = new HashSet<>();
        return new Segment(gen, Map.of(format, wfs));
        userData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, Long.toString(localCP));
            logger,  
    /**
            CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,
        assertTrue(deleter.getPendingDeletes().get("parquet").contains("shared.parquet"));
        // Simulate manager releasing cs1
import org.opensearch.index.translog.DefaultTranslogDeletionPolicy;
        assertTrue(tracker.hasDeletedFile("cs1.parquet"));  
        AlwaysFailingDeleter alwaysFails = new AlwaysFailingDeleter();
            null,
        public Map<String, Collection<String>> deleteFiles(Map<String, Collection<String>> filesToDelete) throws IOException {
            List.of(cs1),
        );
    static class LockProbeDeleter implements FileDeleter {
        TrackingFileDeleter tracker = new TrackingFileDeleter();  
        cs1.decRef();  
            s -> {}
        ShardPath shardPath = new ShardPath(false, shardDir, shardDir, shardId);
        deleter.addFileReferences(cs2);  
        // Both internal attempts failed, file is still pending  
        expectThrows(AssertionError.class, () -> deleter.addFileReferences(cs3));
     * A FileDeleter that always throws IOException. Simulates persistent I/O failure.
        );  
        IndexFileDeleter deleter = new IndexFileDeleter(policy, new TrackingFileDeleter(), Map.of(), List.of(cs1), null, null, s -> {});
    /**  
        assertTrue("doomed.parquet still pending", deleter.getPendingDeletes().get("parquet").contains("doomed.parquet"));  
    }
        Map<String, Collection<String>> newFiles = deleter.addFileReferences(
            CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,
            CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,
import org.opensearch.index.engine.exec.CommitFileManager;
            Map.of(),
        assertTrue(tracker.hasDeletedFile("only_cs1.parquet"));  
        CatalogSnapshot cs2 = snapshot(2, List.of(segment(1, "parquet", "new.parquet")), commitUserData(200, 200, "uuid"));
            this.failuresRemaining = failCount;  
            Map.of(),
            null,
        return new DataformatAwareCatalogSnapshot(gen, gen, 0L, segments, 0L, userData);  
        TrackingFileDeleter luceneTracker = new TrackingFileDeleter();
            CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,
        IndexFileDeleter deleter = new IndexFileDeleter(
            new TrackingFileDeleter(),  
            logger,
            1,  
    // ---- deleteOrphanedFiles ----  
            CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,
        assertTrue(tracker.hasDeletedFile("orphan2.parquet"));
        );  
        assertTrue(tracker.hasDeletedFile("cs1_file.parquet"));
            }
import java.util.List;  
        CatalogSnapshot cs1b = snapshot(1, List.of(segment(0, "parquet", "a.parquet")), commitUserData(100, 100, "uuid"));
        FailNTimesThenSucceedDeleter deleter1 = new FailNTimesThenSucceedDeleter(2);
            tracker,  
        AlwaysFailingDeleter failingDeleter = new AlwaysFailingDeleter();  
        );
            logger,  
        Path tempDir = createTempDir();
            s -> {}  
            s -> {}
            null,  
     */  
            List.of(segment(0, "parquet", "old_a.parquet"), segment(1, "parquet", "old_b.parquet")),
            tracker,  
        CombinedCatalogSnapshotDeletionPolicy policy = new CombinedCatalogSnapshotDeletionPolicy(
            if (failuresRemaining > 0) {
        CommitFileManager commitMgr = new CommitFileManager() {
        TrackingFileDeleter parquetTracker = new TrackingFileDeleter();
        CatalogSnapshot cs2 = snapshot(2, List.of(segment(1, "parquet", "c.parquet")), commitUserData(200, 200, "uuid"));
        CombinedCatalogSnapshotDeletionPolicy policy = new CombinedCatalogSnapshotDeletionPolicy(
        TrackingFileDeleter tracker = new TrackingFileDeleter();
            return Map.of();
            Map.of(
        LockProbeDeleter(Object monitorToProbe) {  
            CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,
        TrackingFileDeleter tracker = new TrackingFileDeleter();  
        // Simulate manager releasing its ref (like commitNewSnapshot replacing it)  
 * SPDX-License-Identifier: Apache-2.0
/**
     * Simulates transient I/O failure (e.g., remote store timeout).
            globalCP::get
            null,
            CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,
        AtomicLong globalCP = new AtomicLong(100);
        assertFalse(tracker.hasDeletedFile("cs1_file.parquet"));  
        deleterWithProbe.removeFileReferences(cs1b);
import org.opensearch.test.OpenSearchTestCase;  
        // Placeholder deleter for construction  
import org.opensearch.core.index.shard.ShardId;
        globalCP.set(200);
        deleter.retryPendingDeletes();
        CatalogSnapshot cs1 = snapshot(
        deleterWithProbe.addFileReferences(cs2);
        public Map<String, Collection<String>> deleteFiles(Map<String, Collection<String>> filesToDelete) {
            @Override  
 */  
        // Policy deletes cs1 → decRef → refCount=0 → removeFileReferences
 * this file be licensed under the Apache-2.0 license or a
        CatalogSnapshot cs1 = snapshot(1, List.of(segment(0, "parquet", "old.parquet")), commitUserData(100, 100, "uuid"));
        CatalogSnapshot cs3 = snapshot(3, List.of(segment(2, "parquet", "shared.parquet")), commitUserData(300, 300, "uuid"));  
        deleter.addFileReferences(cs2);  
        FailNTimesThenSucceedDeleter failTwice = new FailNTimesThenSucceedDeleter(2);
        CatalogSnapshot cs1 = snapshot(1, List.of(segment(0, "parquet", "shared.parquet")), commitUserData(100, 100, "uuid"));  
    /**  
        assertFalse(tracker.hasDeletedFile("shared.parquet"));
        deleter.addFileReferences(cs2);  
        final List<Boolean> lockHeldDuringDelete = new ArrayList<>();  
        deleter.addFileReferences(cs2);  
            Map.of(),
        deleter.revisitPolicy();  
        // only_cs1 deleted, shared survives
            tracker,
        Map<String, String> userData = new HashMap<>();
        Path tempDir = createTempDir();  
        assertTrue(tracker.hasDeletedFile("orphan1.parquet"));  
            null,
        // Fail twice: once during executeDeletesWithRetry, once during the automatic
        AtomicLong globalCP = new AtomicLong(100);  
        CatalogSnapshot cs1 = snapshot(1, List.of(segment(0, "parquet", "known.parquet")), commitUserData(100, 100, "uuid"));  
        Files.createDirectories(shardDir);  
        Path parquetDir = shardDir.resolve("parquet");  
            1,  
        assertTrue(parquetTracker.hasDeletedFile("data.parquet"));  
            deleter1,  
            logger,  
        deleter.removeFileReferences(cs1);  
                }
        assertTrue(tracker.deletedFiles.isEmpty());
        IndexFileDeleter deleter = new IndexFileDeleter(
            List.of(cs1),
            new DefaultTranslogDeletionPolicy(-1, -1, 0),  
        // happen in production because once a segment file's ref count reaches 0, no new
        deleterWithProbe.onCommit(cs2);
    }
        // Retry — still fails  
            public void deleteCommit(CatalogSnapshot snapshot) {}
            null,
import org.opensearch.index.shard.ShardPath;  
        deleter.removeFileReferences(cs1);
        // cs1 deleted by policy → old_a and old_b should be deleted  
        assertTrue("b.parquet should be pending", pending.get("parquet").contains("b.parquet"));
            for (Collection<String> files : filesToDelete.values()) {  
        int attemptsAfterRemove = alwaysFails.deleteAttempts;
            null,  
            tracker,
            )
        for (Boolean held : probe.lockHeldDuringDelete) {
            s -> {}
    public void testRemoveFileReferencesDoesNotHoldLockDuringIO() throws IOException {  
        assertFalse("Pending deletes should be empty after successful retry", deleter.hasPendingDeletes());  
import org.opensearch.index.translog.Translog;
        globalCP.set(200);
        );
        // retryPendingDeletes inside removeFileReferences. Third call (explicit retry) succeeds.  
            Map<String, Collection<String>> failed = new java.util.HashMap<>();
        // Add and commit cs2
        LockProbeDeleter probe = new LockProbeDeleter(deleter);  
        );  
            Map.of(),
        CatalogSnapshot cs1 = snapshot(1, List.of(segment(0, "parquet", "a.parquet", "b.parquet")), commitUserData(100, 100, "uuid"));
        CatalogSnapshot cs2 = snapshot(2, List.of(segment(1, "parquet", "a.parquet", "c.parquet")), commitUserData(200, 200, "uuid"));
        deleter.removeFileReferences(cs1);  
            s -> {}
        );
import org.opensearch.index.engine.exec.FileDeleter;
            assertFalse("IndexFileDeleter monitor should NOT be held during deleteFiles call", held);
    }  
            List.of(cs1),
        CatalogSnapshot cs2 = snapshot(2, List.of(segment(1, "parquet", "cs2.parquet")), commitUserData(200, 200, "uuid"));
        assertFalse("known.parquet should not be deleted", tracker.hasDeletedFile("known.parquet"));
    public void testMultiFormatFileDeletion() throws IOException {  
    public void testDeleteOrphanedFilesOnInit() throws IOException {
    }
        assertEquals(1, cs1.refCount());
import java.util.Set;
                throw new IOException("Simulated transient I/O failure");
        cs1b.decRef();  
        // Commit cs2, advance globalCP
        // Add cs2 sharing a.parquet but not b.parquet
        );
        Files.createFile(parquetDir.resolve("known.parquet"));  
    // ---- Lifecycle: commit ref keeps snapshot alive ----  
            shardPath,  
        TrackingFileDeleter tracker = new TrackingFileDeleter();  
                deletedFiles.addAll(files);
        CombinedCatalogSnapshotDeletionPolicy policy = new CombinedCatalogSnapshotDeletionPolicy(  
        // Explicit retry — deleter now succeeds (third call)  
            throw new IOException("Persistent I/O failure");
        CatalogSnapshot cs2 = snapshot(2, List.of(segment(1, "parquet", "b.parquet")), commitUserData(200, 200, "uuid"));
     * the IndexFileDeleter monitor was held at that time.
            failTwice,  
        IndexFileDeleter deleter = new IndexFileDeleter(
            null,
            null,  
            s -> {}
    public void testOnCommitDeletesOldCommitFiles() throws IOException {
    static class TrackingFileDeleter implements FileDeleter {  
            tracker,  
        deleter.onCommit(cs2);
        );  
                if ("parquet".equals(e.getKey())) {
        Files.createFile(parquetDir.resolve("orphan.parquet"));
            null,  
        // First removal: executeDeletesWithRetry fails (call 1), retryPendingDeletes fails (call 2)
        assertFalse(parquetTracker.hasDeletedFile("data2.parquet"));
            Map.of(),
        CatalogSnapshot cs1 = snapshot(
    }
            shardPath,  
        assertEquals(2, cs1.refCount());
        // Simulate manager releasing cs1
 * The OpenSearch Contributors require contributions made to  
        Files.createFile(parquetDir.resolve("segments_1"));  
        // cs2 and cs3 with different files
            for (Map.Entry<String, Collection<String>> e : files.entrySet()) {  
        var held = policy.acquireCommittedSnapshot(false);
        Segment seg2 = new Segment(
        assertTrue("Should have pending deletes", deleter.hasPendingDeletes());
        // b.parquet was only in cs1 → deleted
            null,
        IndexFileDeleter deleter = new IndexFileDeleter(
        );
    static class AlwaysFailingDeleter implements FileDeleter {
        assertTrue(deleter.hasPendingDeletes());  
        Path tempDir = createTempDir();
    }
            s -> {}  
            List.of(cs1),
            commitUserData(100, 100, "uuid")
        ShardId shardId = new ShardId("test", "test", 0);
import java.util.HashSet;
        TrackingFileDeleter tracker = new TrackingFileDeleter();
        boolean hasDeletedFile(String file) {
        // With null CommitFileManager, segments_1 is treated as an orphan
            Map.of(),
        // cs1 has files in two formats
            this.monitorToProbe = monitorToProbe;
        cs1.decRef();  
        // Refresh: cs2 with merged files
            public byte[] serializeToCommitFormat(CatalogSnapshot snapshot) {  
            null,  
        AtomicLong globalCP = new AtomicLong(100);
        Path parquetDir = shardDir.resolve("parquet");
        assertTrue("segments_1 should be deleted when no CommitFileManager protects it", tracker.hasDeletedFile("segments_1"));  
    // ---- revisitPolicy ----
        AtomicLong globalCP = new AtomicLong(100);  
        globalCP.set(200);
            s -> {}  
    public void testOrphanScanWithNullCommitFileManagerDeletesEverythingUnreferenced() throws IOException {
        cs1.decRef();  
            CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,  
        assertFalse(tracker.hasDeletedFile("a.parquet"));
        // Files NOT deleted — commit ref keeps it alive
        @Override
        Path parquetDir = shardDir.resolve("parquet");
        AtomicLong globalCP = new AtomicLong(100);  
        Path shardDir = tempDir.resolve(shardId.getIndex().getUUID()).resolve(String.valueOf(shardId.id()));  
import java.nio.file.Path;
        TrackingFileDeleter tracker = new TrackingFileDeleter();  
import org.opensearch.index.engine.exec.CatalogSnapshotDeletionPolicy;
        globalCP.set(200);
        IndexFileDeleter deleter = new IndexFileDeleter(
            2,
        cs1.decRef();  
            s -> {}
        // cs2 does NOT contain shared.parquet  
        for (Boolean held : probe.lockHeldDuringDelete) {
        assertFalse(tracker.hasDeletedFile("known.parquet"));
            List.of(segment(0, "parquet", "shared.parquet"), segment(1, "parquet", "only_cs1.parquet")),  
        // Both formats' old files should be deleted
        TrackingFileDeleter tracker = new TrackingFileDeleter();
        deleter.addFileReferences(cs2);
            CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,  
                return fileName.startsWith("segments_");
    }  
                failuresRemaining--;  
            new DefaultTranslogDeletionPolicy(-1, -1, 0),  
        LockProbeDeleter probe = new LockProbeDeleter(deleter);
            assertFalse("Monitor should NOT be held during removeFileReferences I/O", held);  
        Files.createFile(parquetDir.resolve("orphan2.parquet"));
            commitUserData(200, 200, "uuid")
                deletedFiles.addAll(files);
        CatalogSnapshot cs1 = snapshot(1, List.of(segment(0, "parquet", "a.parquet", "b.parquet")), commitUserData(100, 100, "uuid"));
            globalCP::get
        CombinedCatalogSnapshotDeletionPolicy policy = new CombinedCatalogSnapshotDeletionPolicy(
        public Map<String, Collection<String>> deleteFiles(Map<String, Collection<String>> filesToDelete) {
        userData.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(maxSeqNo));  
        );
        ShardPath shardPath = new ShardPath(false, shardDir, shardDir, shardId);
            Map.of(),
        CatalogSnapshot cs1 = snapshot(1, List.of(segment(0, "parquet", "a.parquet")), commitUserData(100, 100, "uuid"));
    // ---- onCommit ----
        );
            }  
        IndexFileDeleter deleter = new IndexFileDeleter(policy, tracker, Map.of(), List.of(cs1), null, null, s -> {});
        assertFalse("known.parquet should not be deleted", tracker.hasDeletedFile("known.parquet"));
        deleter.removeFileReferences(cs1);
            logger,
            null,
            Map.of(),
        AtomicLong globalCP = new AtomicLong(100);
        globalCP.set(200);
    }
        CatalogSnapshot cs1 = snapshot(1, List.of(segment(0, "parquet", "known.parquet")), commitUserData(100, 100, "uuid"));
            Map.of(),
        IndexFileDeleter deleterWithProbe = new IndexFileDeleter(
    }
        }, Map.of(), List.of(cs1), null, null, s -> {});
        }
        }
            List.of(cs1),
        assertTrue("a.parquet should be deleted on retry", deleter1.deletedFiles.contains("a.parquet"));
    private static Map<String, String> commitUserData(long maxSeqNo, long localCP, String translogUUID) {
        deleter.addFileReferences(cs3);  
    }  
        deleterWithProbe.addFileReferences(cs2);
            logger,
                new WriterFileSet("/data", 0, Set.of("_0.cfs"), 1, 0L)  
            0,
        CatalogSnapshot cs1b = snapshot(1, List.of(segment(0, "parquet", "old.parquet")), commitUserData(100, 100, "uuid"));
        assertTrue(luceneTracker.hasDeletedFile("_0.cfs"));
        Path tempDir = createTempDir();
        TrackingFileDeleter tracker = new TrackingFileDeleter();
        deleter.onCommit(cs2);
    }
        CatalogSnapshot cs1 = snapshot(1, List.of(segment(0, "parquet", "doomed.parquet")), commitUserData(100, 100, "uuid"));
            List.of(cs1),
            globalCP::get  
        assertTrue(newFiles.get("parquet").contains("c.parquet"));
    }
        );  
        Files.createFile(parquetDir.resolve("segments_1"));  
        IndexFileDeleter deleter = new IndexFileDeleter(
        deleter.removeFileReferences(cs2);
import java.nio.file.Files;  
            List.of(cs1),
        Files.createDirectories(shardDir);
import java.io.IOException;
        CatalogSnapshot cs1 = snapshot(1, List.of(seg), commitUserData(100, 100, "uuid"));  
        // Create deleter first, then set up the probe  
    public void testRevisitPolicyDeletesPreviouslyProtectedCommit() throws IOException {  
        assertTrue(tracker.hasDeletedFile("old_a.parquet"));
        // known.parquet should NOT be deleted (referenced)  
        IndexFileDeleter deleterWithProbe = new IndexFileDeleter(policy, probe, Map.of(), List.of(cs1b), null, null, s -> {});
        }
        // Add cs2 and commit
        Files.createFile(parquetDir.resolve("known.parquet"));
        // Release hold
        Path shardDir = tempDir.resolve(shardId.getIndex().getUUID()).resolve(String.valueOf(shardId.id()));
        final Set<String> deletedFiles = new HashSet<>();
        }
    }
        // Files should be in pending deletes since the deleter always fails  
    }  
            new DefaultTranslogDeletionPolicy(-1, -1, 0),
        IndexFileDeleter deleter = new IndexFileDeleter(policy, tracker, Map.of(), List.of(cs1), null, null, s -> {});
        );  
import org.opensearch.index.engine.exec.WriterFileSet;
        IndexFileDeleter deleter = new IndexFileDeleter(policy, tracker, Map.of(), List.of(cs1), null, null, s -> {});
        ShardId shardId = new ShardId("test", "test", 0);  
        CombinedCatalogSnapshotDeletionPolicy policy = new CombinedCatalogSnapshotDeletionPolicy(
    public void testDeleteFilesExecutedOutsideSynchronizedBlock() throws IOException {
            globalCP::get
    public void testPartialDeleteFailureTracksPendingDeletes() throws IOException {
        // segments_1 should NOT be deleted (commit-managed)
import java.util.concurrent.atomic.AtomicLong;  
    }
        assertTrue(deleter.hasPendingDeletes());  
        CatalogSnapshot cs1 = snapshot(1, List.of(segment(0, "parquet", "cs1.parquet")), commitUserData(100, 100, "uuid"));  
        CatalogSnapshot cs1 = snapshot(1, List.of(segment(0, "parquet", "known.parquet")), commitUserData(100, 100, "uuid"));
import org.opensearch.index.seqno.SequenceNumbers;
            for (Collection<String> files : filesToDelete.values()) {
    public void testReReferencingPendingDeleteFileThrowsAssertionError() throws IOException {
        // a.parquet shared with cs2 → NOT deleted
        Files.createDirectories(parquetDir);
        assertFalse(newFiles.get("parquet").contains("a.parquet"));
            }
        CatalogSnapshot cs2 = snapshot(2, List.of(segment(1, "parquet", "b.parquet")), commitUserData(200, 200, "uuid"));  
            alwaysFails,  
            CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,
            new DefaultTranslogDeletionPolicy(-1, -1, 0),
 *
        IndexFileDeleter deleter = new IndexFileDeleter(
                "parquet",
    // ---- Fix #14: isCommitManagedFile is now abstract ----
        // a.parquet already existed (refCount 1→2), c.parquet is new (0→1)  
     */  
        CatalogSnapshot cs2 = snapshot(2, List.of(segment(1, "parquet", "cs2_file.parquet")), commitUserData(200, 200, "uuid"));
        // null commitFileManager — no protection for commit files  
        CatalogSnapshot cs1 = snapshot(1, List.of(segment(0, "parquet", "a.parquet", "b.parquet")), commitUserData(100, 100, "uuid"));
            return deletedFiles.contains(file);  
        // Simulate manager releasing cs1 (as commitNewSnapshot would)
    private static CatalogSnapshot snapshot(long gen, List<Segment> segments, Map<String, String> userData) {
        Map<String, Set<String>> pending = deleter.getPendingDeletes();
        CatalogSnapshot cs2 = snapshot(2, List.of(segment(1, "parquet", "b.parquet")), commitUserData(200, 200, "uuid"));  
            tracker,  
        private final Object monitorToProbe;
        Segment seg = new Segment(  
        deleter.retryPendingDeletes();
            1,
            }  
        FailNTimesThenSucceedDeleter(int failCount) {
            snapshot(2, List.of(segment(0, "parquet", "a.parquet", "c.parquet")), commitUserData(200, 200, "uuid"))  
        Files.createDirectories(shardDir);
        ShardId shardId = new ShardId("test", "test", 0);
        }  
        deleter.addFileReferences(cs2);  
        userData.put(Translog.TRANSLOG_UUID_KEY, translogUUID);
     * A FileDeleter that records which thread performed the deletion and whether
            null,
        }
    // ---- addFileReferences / removeFileReferences ----
        // orphan.parquet should be deleted (not referenced, not commit-managed)
                } else if ("lucene".equals(e.getKey())) {  
        // Hold cs1 via snapshot protection
        );
            List.of(cs1b),  
        ShardPath shardPath = new ShardPath(false, shardDir, shardDir, shardId);  
            for (Collection<String> files : filesToDelete.values()) {
    // ---- Fix #1: I/O outside the synchronized block ----
        CatalogSnapshot cs1 = snapshot(1, List.of(segment(0, "parquet", "cs1_file.parquet")), commitUserData(100, 100, "uuid"));
        Files.createFile(parquetDir.resolve("known.parquet"));
    }
        @Override  
        );
            Map.of(),
        cs1.decRef(); // manager releases → refCount=1 (commit still holds)
                    failed.putAll(luceneTracker.deleteFiles(Map.of(e.getKey(), e.getValue())));
            @Override
            shardPath,  
                throw new UnsupportedOperationException("not used by this test");
        }
    }
        CatalogSnapshot cs2 = snapshot(2, List.of(segment(1, "parquet", "other.parquet")), commitUserData(200, 200, "uuid"));
            Map.of(),  
            }
        AlwaysFailingDeleter failingDeleter = new AlwaysFailingDeleter();
        // cs1 has refCount=2 (manager + commit from constructor)  
        CatalogSnapshot cs2 = snapshot(
            deleteAttempts++;  
        // Add cs2 with different files, then remove cs1
        // CommitFileManager that protects segments_* files
        @Override  
            Map.of(),
        assertTrue("a.parquet should be deleted", probe.deletedFiles.contains("a.parquet"));
            null,
import java.util.ArrayList;
        assertTrue(tracker.hasDeletedFile("b.parquet"));  
        WriterFileSet wfs = new WriterFileSet("/data", gen, Set.of(files), files.length, 0L);
                "lucene",
                new WriterFileSet("/data", 0, Set.of("data.parquet"), 1, 0L),
            }  
        assertTrue("a.parquet should be pending", pending.get("parquet").contains("a.parquet"));  
        assertTrue("Should have pending deletes after both attempts failed", deleter.hasPendingDeletes());
    public void testRemoveFileReferencesDeletesOrphanedFiles() throws IOException {
                    failed.putAll(parquetTracker.deleteFiles(Map.of(e.getKey(), e.getValue())));
        // cs2 has completely different files
import org.opensearch.index.engine.exec.Segment;  
        deleter.onCommit(cs2);  
        );  
        // cs1 protected — not deleted
        // Second removal: deleter now succeeds (call 3+), retrying a.parquet and deleting b.parquet  
        Path shardDir = tempDir.resolve(shardId.getIndex().getUUID()).resolve(String.valueOf(shardId.id()));  
    }
            s -> {}
        deleter.removeFileReferences(cs1);
        deleter.addFileReferences(cs2);  
        IndexFileDeleter deleter = new IndexFileDeleter(
        ShardPath shardPath = new ShardPath(false, shardDir, shardDir, shardId);
                deletedFiles.addAll(files);  
    }
        deleter.addFileReferences(cs2);  
 */
        @Override
}  
        deleter.onCommit(cs2);  
            List.of(cs1),  
        // cs2 keeps shared.parquet, adds new file  
 * Tests for {@link IndexFileDeleter}.  
            Map.of(),  
        Path shardDir = tempDir.resolve(shardId.getIndex().getUUID()).resolve(String.valueOf(shardId.id()));
        );  
    }
            return Map.of();  
            )  
            failingDeleter,
            CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,
        // Simulate manager releasing cs1
        assertFalse(luceneTracker.hasDeletedFile("_1.cfs"));  
        deleter.addFileReferences(cs2);  
            return Map.of();
        IndexFileDeleter deleter = new IndexFileDeleter(
        Files.createFile(parquetDir.resolve("orphan1.parquet"));
        // Re-introducing a dead file should trigger an assertion error — this should never  
        deleter.addFileReferences(cs2);
        // revisitPolicy should now delete cs1
        assertTrue("Should have attempted more deletes", alwaysFails.deleteAttempts > attemptsAfterRemove);
            shardPath,
            new DefaultTranslogDeletionPolicy(-1, -1, 0),
    public void testPendingDeletesRetriedOnNextRemoveFileReferences() throws IOException {
    // ---- Fix #3: Partial deletion failure tracking via pendingDeletes ----
        Files.createDirectories(parquetDir);  
            s -> {}
        assertEquals(0, cs1.refCount());
        int deleteAttempts = 0;
        deleter.removeFileReferences(cs1);  
            CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,
        ShardId shardId = new ShardId("test", "test", 0);
        );
        CatalogSnapshot cs1 = snapshot(1, List.of(segment(0, "parquet", "a.parquet")), commitUserData(100, 100, "uuid"));
            }
            null,  
package org.opensearch.index.engine.exec.coord;
        );  
            List.of(cs1),
        // shared.parquet should be pending (deletion failed)
import java.util.HashMap;
        TrackingFileDeleter tracker = new TrackingFileDeleter();
            @Override  
            failingDeleter,
        CatalogSnapshot cs1 = snapshot(1, List.of(segment(0, "parquet", "a.parquet")), commitUserData(100, 100, "uuid"));
            List.of(cs1),  
    public void testAddFileReferencesTracksNewFiles() throws IOException {  
        public Map<String, Collection<String>> deleteFiles(Map<String, Collection<String>> filesToDelete) throws IOException {
        CatalogSnapshot cs2 = snapshot(2, List.of(seg2), commitUserData(200, 200, "uuid"));
    public void testOrphanScanRespectsCommitManagedFiles() throws IOException {  
            s -> {}
