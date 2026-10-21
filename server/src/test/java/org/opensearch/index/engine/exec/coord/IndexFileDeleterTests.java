        deleter.addFileReferences(cs3);
            logger,
        assertTrue("b.parquet should be pending", pending.get("parquet").contains("b.parquet"));
            new DefaultTranslogDeletionPolicy(-1, -1, 0),
        );
        );
        ShardPath shardPath = new ShardPath(false, shardDir, shardDir, shardId);
            null,
        deleter.addFileReferences(cs2);
        FailNTimesThenSucceedDeleter deleter1 = new FailNTimesThenSucceedDeleter(2);
import java.util.concurrent.atomic.AtomicLong;
        IndexFileDeleter deleterWithProbe = new IndexFileDeleter(
        );
            logger,
        assertEquals(0, cs1.refCount());
        }
            s -> {}
        CombinedCatalogSnapshotDeletionPolicy policy = new CombinedCatalogSnapshotDeletionPolicy(
    }
            Map.of(),
    /**
    public void testAddFileReferencesTracksNewFiles() throws IOException {
        CatalogSnapshot cs2 = snapshot(2, List.of(segment(1, "parquet", "other.parquet")), commitUserData(200, 200, "uuid"));
        CatalogSnapshot cs1 = snapshot(1, List.of(segment(0, "parquet", "doomed.parquet")), commitUserData(100, 100, "uuid"));
        ShardId shardId = new ShardId("test", "test", 0);
            for (Collection<String> files : filesToDelete.values()) {
        assertFalse("Lock should not be held during file deletion I/O", probe.lockHeldDuringDelete.isEmpty());
import java.nio.file.Files;
    static class LockProbeDeleter implements FileDeleter {
        }, Map.of(), List.of(cs1), null, null, s -> {});
            s -> {}
        for (Boolean held : probe.lockHeldDuringDelete) {
        // Create deleter first, then set up the probe
            }
            CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,
            null,
    }
        Files.createFile(parquetDir.resolve("known.parquet"));
        assertTrue("old.parquet should have been deleted", probe.deletedFiles.contains("old.parquet"));
        boolean hasDeletedFile(String file) {
        assertTrue("Should have pending deletes", deleter.hasPendingDeletes());
                new WriterFileSet("/data", 0, Set.of("_0.cfs"), 1, 0L)
        CatalogSnapshot cs1 = snapshot(1, List.of(segment(0, "parquet", "a.parquet")), commitUserData(100, 100, "uuid"));
        Files.createDirectories(shardDir);
        Path shardDir = tempDir.resolve(shardId.getIndex().getUUID()).resolve(String.valueOf(shardId.id()));
import org.opensearch.index.engine.exec.CommitFileManager;
import java.util.ArrayList;
            null,
        IndexFileDeleter deleter = new IndexFileDeleter(
        Path tempDir = createTempDir();
            deleter1,
        assertEquals(2, cs1.refCount());
            @Override
        );
        private final Object monitorToProbe;
            lockHeldDuringDelete.add(Thread.holdsLock(monitorToProbe));
            tracker,
                }
        WriterFileSet wfs = new WriterFileSet("/data", gen, Set.of(files), files.length, 0L);
        assertTrue(parquetTracker.hasDeletedFile("data.parquet"));
        }
            probe,
            s -> {}
        Map<String, Collection<String>> newFiles = deleter.addFileReferences(
            throw new IOException("Persistent I/O failure");
    }
    }
        Files.createDirectories(shardDir);
    }
        // segments_1 should NOT be deleted (commit-managed)
        // cs1 protected — not deleted
            null,
        // Re-introducing a dead file should trigger an assertion error — this should never
        deleter.addFileReferences(cs2);
            null,
        IndexFileDeleter deleterWithProbe = new IndexFileDeleter(policy, probe, Map.of(), List.of(cs1b), null, null, s -> {});
            null,
        // Simulate manager releasing cs1
                "lucene",
        AtomicLong globalCP = new AtomicLong(100);
        // a.parquet shared with cs2 → NOT deleted
import org.opensearch.test.OpenSearchTestCase;
 */
            commitMgr,
        CombinedCatalogSnapshotDeletionPolicy policy = new CombinedCatalogSnapshotDeletionPolicy(
 */
        deleter.addFileReferences(cs2);
            this.monitorToProbe = monitorToProbe;
        CatalogSnapshot cs1 = snapshot(1, List.of(segment(0, "parquet", "a.parquet")), commitUserData(100, 100, "uuid"));
            tracker,
        assertTrue(tracker.hasDeletedFile("old_b.parquet"));
        Path tempDir = createTempDir();
        Map<String, String> userData = new HashMap<>();
        // Second removal: deleter now succeeds (call 3+), retrying a.parquet and deleting b.parquet
        deleter.removeFileReferences(cs1);
    static class FailNTimesThenSucceedDeleter implements FileDeleter {
        return new Segment(gen, Map.of(format, wfs));
            List.of(cs1b),
    public void testDeleteFilesExecutedOutsideSynchronizedBlock() throws IOException {
        }
            logger,
            tracker,
        deleter.removeFileReferences(cs1);
        // retryPendingDeletes inside removeFileReferences. Third call (explicit retry) succeeds.
        }
            List.of(cs1),
    public void testOrphanScanRespectsCommitManagedFiles() throws IOException {
     * A FileDeleter that records which thread performed the deletion and whether
        deleter.onCommit(cs2);
    }
        assertFalse(newFiles.get("parquet").contains("a.parquet"));
        assertFalse("Pending deletes should be empty after successful retry", deleter.hasPendingDeletes());
            globalCP::get
        globalCP.set(200);
        Segment seg2 = new Segment(
        IndexFileDeleter deleter = new IndexFileDeleter(policy, tracker, Map.of(), List.of(cs1), null, null, s -> {});
            s -> {}
        // We need a fresh deleter with the probe. Rebuild.
        assertTrue(tracker.deletedFiles.isEmpty());
        CatalogSnapshot cs1b = snapshot(1, List.of(segment(0, "parquet", "a.parquet")), commitUserData(100, 100, "uuid"));
            Map.of(),
        TrackingFileDeleter tracker = new TrackingFileDeleter();
        // retryPendingDeletes inside removeFileReferences. Third call succeeds.
        }
            }
        }
        LockProbeDeleter probe = new LockProbeDeleter(deleter);
    }
            public byte[] serializeToCommitFormat(CatalogSnapshot snapshot) {
            tracker,
        CatalogSnapshot cs1 = snapshot(1, List.of(segment(0, "parquet", "known.parquet")), commitUserData(100, 100, "uuid"));
    }
 * this file be licensed under the Apache-2.0 license or a
            public void deleteCommit(CatalogSnapshot snapshot) {}
            globalCP::get
        CatalogSnapshot cs3 = snapshot(3, List.of(segment(2, "parquet", "shared.parquet")), commitUserData(300, 300, "uuid"));
        AlwaysFailingDeleter alwaysFails = new AlwaysFailingDeleter();
    /**
        );
            )
            null,
        assertTrue(tracker.hasDeletedFile("cs1.parquet"));
    public void testRemoveFileReferencesDoesNotHoldLockDuringIO() throws IOException {
        assertEquals(1, cs1.refCount());
            failingDeleter,
                "parquet",
     * A FileDeleter that always throws IOException. Simulates persistent I/O failure.
    // ---- Lifecycle: commit ref keeps snapshot alive ----
        @Override
        CommitFileManager commitMgr = new CommitFileManager() {
        Files.createDirectories(parquetDir);
            List.of(cs1),
        Files.createDirectories(parquetDir);
            List.of(segment(0, "parquet", "shared.parquet"), segment(1, "parquet", "only_cs1.parquet")),
            globalCP::get
        );
        CatalogSnapshot cs1 = snapshot(1, List.of(segment(0, "parquet", "a.parquet", "b.parquet")), commitUserData(100, 100, "uuid"));
        assertFalse(luceneTracker.hasDeletedFile("_1.cfs"));
        IndexFileDeleter deleter = new IndexFileDeleter(
        );
        // known.parquet should NOT be deleted (referenced)
            List.of(segment(0, "parquet", "shared.parquet"), segment(2, "parquet", "only_cs2.parquet")),
        // Add cs2 sharing a.parquet but not b.parquet
    // ---- Fix #3: Partial deletion failure tracking via pendingDeletes ----
                deletedFiles.addAll(files);
        // happen in production because once a segment file's ref count reaches 0, no new
        // Retry — still fails
            Map.of(),
            s -> {}
            List.of(cs1),
        CatalogSnapshot cs1 = snapshot(1, List.of(segment(0, "parquet", "a.parquet", "b.parquet")), commitUserData(100, 100, "uuid"));
    }
        int deleteAttempts = 0;
        IndexFileDeleter deleter = new IndexFileDeleter(
        // cs1 deleted by policy → old_a and old_b should be deleted
        deleterWithProbe.addFileReferences(cs2);
    }
        Files.createFile(parquetDir.resolve("known.parquet"));
    // ---- deleteOrphanedFiles ----
    public void testRetryPendingDeletesExplicitCall() throws IOException {
        // cs1 has refCount=2 (manager + commit from constructor)
        // Remove cs1's refs
        var held = policy.acquireCommittedSnapshot(false);
        deleter.retryPendingDeletes();
            null,
        private int failuresRemaining;
    public void testDeleteOrphanedFilesOnInit() throws IOException {
    }
        globalCP.set(200);
        CatalogSnapshot cs1 = snapshot(1, List.of(segment(0, "parquet", "known.parquet")), commitUserData(100, 100, "uuid"));
        // Refresh: cs2 with merged files
            CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,
        // Rebuild with lock probe
        public Map<String, Collection<String>> deleteFiles(Map<String, Collection<String>> filesToDelete) throws IOException {
        );
        // The probe should have recorded that the lock was NOT held during deleteFiles
    }
        // First removal: executeDeletesWithRetry fails (call 1), retryPendingDeletes fails (call 2)
        // cs2 and cs3 with different files
        assertTrue("File should remain pending after persistent failure", deleter.hasPendingDeletes());
        );
/*
        assertFalse(tracker.hasDeletedFile("a.parquet"));
        }
                "parquet",
    public void testPendingDeletesRetriedOnNextRemoveFileReferences() throws IOException {
        );
        Files.createFile(parquetDir.resolve("segments_1"));
            assertFalse("IndexFileDeleter monitor should NOT be held during deleteFiles call", held);
        TrackingFileDeleter tracker = new TrackingFileDeleter();
            failingDeleter,
        );
    public void testReReferencingPendingDeleteFileThrowsAssertionError() throws IOException {
        assertTrue("doomed.parquet still pending", deleter.getPendingDeletes().get("parquet").contains("doomed.parquet"));
        assertFalse(tracker.hasDeletedFile("known.parquet"));
     */
        CatalogSnapshot cs2 = snapshot(2, List.of(segment(1, "parquet", "cs2_file.parquet")), commitUserData(200, 200, "uuid"));
            CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,
    public void testOnCommitDeletesOldCommitFiles() throws IOException {
        );
        @Override
        // Simulate manager releasing cs1 (as commitNewSnapshot would)
        assertTrue(deleter.hasPendingDeletes());
        IndexFileDeleter deleter = new IndexFileDeleter(policy, tracker, Map.of(), List.of(cs1), null, null, s -> {});
            }
        deleter.addFileReferences(cs2);
            commitUserData(100, 100, "uuid")
        public Map<String, Collection<String>> deleteFiles(Map<String, Collection<String>> filesToDelete) throws IOException {
        IndexFileDeleter deleter = new IndexFileDeleter(policy, new TrackingFileDeleter(), Map.of(), List.of(cs1), null, null, s -> {});
        assertFalse("No more pending deletes", deleter.hasPendingDeletes());
        CatalogSnapshot cs1 = snapshot(1, List.of(segment(0, "parquet", "shared.parquet")), commitUserData(100, 100, "uuid"));
            return Map.of();
        AlwaysFailingDeleter failingDeleter = new AlwaysFailingDeleter();
        CatalogSnapshot cs1 = snapshot(1, List.of(segment(0, "parquet", "known.parquet")), commitUserData(100, 100, "uuid"));
        CombinedCatalogSnapshotDeletionPolicy policy = new CombinedCatalogSnapshotDeletionPolicy(
            Map.of(),
        CatalogSnapshot cs1b = snapshot(1, List.of(segment(0, "parquet", "old.parquet")), commitUserData(100, 100, "uuid"));
        );
        CatalogSnapshot cs1 = snapshot(1, List.of(seg), commitUserData(100, 100, "uuid"));
        deleter.addFileReferences(cs2);
        // cs2 has completely different files
            s -> {}
    private static Segment segment(long gen, String format, String... files) {
        int attemptsAfterRemove = alwaysFails.deleteAttempts;
        IndexFileDeleter deleter = new IndexFileDeleter(
        Files.createDirectories(parquetDir);
            Map.of(),
    // ---- Fix #14: isCommitManagedFile is now abstract ----
            1,
            2,
        Files.createFile(parquetDir.resolve("orphan.parquet"));
        assertTrue(tracker.hasDeletedFile("only_cs1.parquet"));
            return Map.of();
        ShardPath shardPath = new ShardPath(false, shardDir, shardDir, shardId);
            new DefaultTranslogDeletionPolicy(-1, -1, 0),
        Map<String, Set<String>> pending = deleter.getPendingDeletes();
            shardPath,
        deleter.removeFileReferences(cs2);
            s -> {}
            Map<String, Collection<String>> failed = new java.util.HashMap<>();
        assertTrue("a.parquet should be deleted on retry", deleter1.deletedFiles.contains("a.parquet"));
            Map.of(),
            null,
        held.close();
            globalCP::get
        Segment seg = new Segment(
            globalCP::get
            1,
        );
    }
        userData.put(Translog.TRANSLOG_UUID_KEY, translogUUID);
    }
        // Placeholder deleter for construction
        // a.parquet already existed (refCount 1→2), c.parquet is new (0→1)
        assertFalse(parquetTracker.hasDeletedFile("data2.parquet"));
        Files.createFile(parquetDir.resolve("orphan2.parquet"));
        assertTrue("Should have pending deletes after failed deletion", deleter.hasPendingDeletes());
            null,
        ShardPath shardPath = new ShardPath(false, shardDir, shardDir, shardId);
        CatalogSnapshot cs1 = snapshot(1, List.of(segment(0, "parquet", "a.parquet")), commitUserData(100, 100, "uuid"));
            failTwice,
        assertFalse("known.parquet should not be deleted", tracker.hasDeletedFile("known.parquet"));
                deletedFiles.addAll(files);
            tracker,
 * compatible open source license.
        // Simulate manager releasing cs1
            s -> {}
        };
            shardPath,
     * A FileDeleter that fails the first N calls, then succeeds on subsequent calls.
        CatalogSnapshot cs2 = snapshot(2, List.of(segment(1, "parquet", "b.parquet")), commitUserData(200, 200, "uuid"));
        CatalogSnapshot cs2 = snapshot(2, List.of(segment(1, "parquet", "new.parquet")), commitUserData(200, 200, "uuid"));
     */
import java.util.HashSet;
            public boolean isCommitManagedFile(String fileName) {
        deleter.removeFileReferences(cs1);
    // ---- Fix #1: I/O outside the synchronized block ----
        }
        // Commit cs2, advance globalCP
        CatalogSnapshot cs1 = snapshot(1, List.of(segment(0, "parquet", "old.parquet")), commitUserData(100, 100, "uuid"));
        // Both formats' old files should be deleted
        userData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, Long.toString(localCP));
        deleter.onCommit(cs2);
        LockProbeDeleter(Object monitorToProbe) {
                throw new UnsupportedOperationException("not used by this test");
            List.of(cs1),
import org.opensearch.index.translog.Translog;
    public void testPersistentFailureKeepsFilesPending() throws IOException {
    }
 * Tests for {@link IndexFileDeleter}.
        CombinedCatalogSnapshotDeletionPolicy policy = new CombinedCatalogSnapshotDeletionPolicy(
        deleter.retryPendingDeletes();
        IndexFileDeleter deleter = new IndexFileDeleter(
        Files.createFile(parquetDir.resolve("orphan1.parquet"));
        CatalogSnapshot cs2 = snapshot(2, List.of(segment(1, "parquet", "c.parquet")), commitUserData(200, 200, "uuid"));
    }
            Map.of(),
        );
        );
    public void testPartialDeleteFailureTracksPendingDeletes() throws IOException {
            tracker,
        // Add cs2 and commit
        globalCP.set(200);
            )
        cs1.decRef(); // manager releases → refCount=1 (commit still holds)
        TrackingFileDeleter tracker = new TrackingFileDeleter();
        cs1b.decRef();
        FailNTimesThenSucceedDeleter failTwice = new FailNTimesThenSucceedDeleter(2);
        );
        CatalogSnapshot cs3 = snapshot(3, List.of(segment(2, "parquet", "c.parquet")), commitUserData(300, 300, "uuid"));
        assertFalse("known.parquet should not be deleted", tracker.hasDeletedFile("known.parquet"));
            CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,
    // ---- onCommit ----
    public void testOnCommitPreservesSharedFiles() throws IOException {
            }
        IndexFileDeleter deleter = new IndexFileDeleter(
        // shared.parquet should be pending (deletion failed)
        Path shardDir = tempDir.resolve(shardId.getIndex().getUUID()).resolve(String.valueOf(shardId.id()));
        // Both internal attempts failed, file is still pending
        // cs2 does NOT contain shared.parquet
        globalCP.set(200);
        cs1.decRef();
        assertTrue(tracker.hasDeletedFile("b.parquet"));
        @Override
        AtomicLong globalCP = new AtomicLong(100);
        assertTrue("a.parquet should be deleted on explicit retry", failTwice.deletedFiles.contains("a.parquet"));
        );
            logger,
    }
            List.of(cs1),
            Map.of(),
            null,
        deleterWithProbe.removeFileReferences(cs1b);
        // Hold cs1 via snapshot protection
            return Map.of();
        IndexFileDeleter deleter = new IndexFileDeleter(
        assertFalse(tracker.hasDeletedFile("shared.parquet"));
        Path shardDir = tempDir.resolve(shardId.getIndex().getUUID()).resolve(String.valueOf(shardId.id()));
    }
        TrackingFileDeleter tracker = new TrackingFileDeleter();
        assertTrue(tracker.hasDeletedFile("orphan1.parquet"));
        // Add cs2 with different files, then remove cs1
        Path parquetDir = shardDir.resolve("parquet");
            }
        final Set<String> deletedFiles = new HashSet<>();
            0,
        TrackingFileDeleter tracker = new TrackingFileDeleter();
        deleter.addFileReferences(cs2);
import org.opensearch.index.engine.exec.CombinedCatalogSnapshotDeletionPolicy;
        AtomicLong globalCP = new AtomicLong(100);
        deleter.removeFileReferences(cs1);
import java.util.Collection;
            Map.of(
     * Simulates transient I/O failure (e.g., remote store timeout).
            Map.of(),
        CatalogSnapshot cs2 = snapshot(2, List.of(segment(2, "parquet", "new_merged.parquet")), commitUserData(200, 200, "uuid"));
 * SPDX-License-Identifier: Apache-2.0
        TrackingFileDeleter luceneTracker = new TrackingFileDeleter();
        IndexFileDeleter deleter = new IndexFileDeleter(policy, files -> {
            CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,
        assertTrue("Should have pending deletes after both attempts failed", deleter.hasPendingDeletes());
            for (Map.Entry<String, Collection<String>> e : files.entrySet()) {
            s -> {}
        deleter.addFileReferences(cs2);
        deleter.addFileReferences(cs2);
        assertTrue(deleter.hasPendingDeletes());
import java.io.IOException;
        cs1.decRef();
    }
        CatalogSnapshot cs1 = snapshot(1, List.of(segment(0, "parquet", "cs1.parquet")), commitUserData(100, 100, "uuid"));
import java.util.List;
        // Now create a new deleter with the lock probe, using the deleter instance as the monitor
        );
        globalCP.set(200);
        assertFalse(tracker.hasDeletedFile("cs1_file.parquet"));
            null,
            new DefaultTranslogDeletionPolicy(-1, -1, 0),
}
        deleter.onCommit(cs2);
        CombinedCatalogSnapshotDeletionPolicy policy = new CombinedCatalogSnapshotDeletionPolicy(
        return new DataformatAwareCatalogSnapshot(gen, gen, 0L, segments, 0L, userData);
            logger,
import org.opensearch.index.shard.ShardPath;
        // Files should be in pending deletes since the deleter always fails
        cs1.decRef();
            Map.of(
            List.of(segment(0, "parquet", "old_a.parquet"), segment(1, "parquet", "old_b.parquet")),
        cs1.decRef();
        TrackingFileDeleter tracker = new TrackingFileDeleter();
        }
            new DefaultTranslogDeletionPolicy(-1, -1, 0),
import java.util.HashMap;
                    failed.putAll(parquetTracker.deleteFiles(Map.of(e.getKey(), e.getValue())));
                "lucene",
            null,
            @Override
            return failed;
            logger,
            new DefaultTranslogDeletionPolicy(-1, -1, 0),
        assertTrue(tracker.hasDeletedFile("old_a.parquet"));
    }
        Files.createDirectories(shardDir);
        TrackingFileDeleter parquetTracker = new TrackingFileDeleter();
        // Simulate manager releasing cs1
            s -> {}
        );
            List.of(cs1),
                failuresRemaining--;
                deletedFiles.addAll(files);
            CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,
            1,
            null,
        // only_cs1 deleted, shared survives
        return userData;
        ShardId shardId = new ShardId("test", "test", 0);
        CatalogSnapshot cs2 = snapshot(2, List.of(segment(1, "parquet", "cs2.parquet")), commitUserData(200, 200, "uuid"));
            commitUserData(200, 200, "uuid")
        // Policy deletes cs1 → decRef → refCount=0 → removeFileReferences
        ShardPath shardPath = new ShardPath(false, shardDir, shardDir, shardId);
            null,
                    failed.putAll(luceneTracker.deleteFiles(Map.of(e.getKey(), e.getValue())));
        // cs1 has files in two formats
        );
import org.opensearch.index.engine.exec.Segment;
    public void testDeleteOrphanedFilesSkipsMissingDirectory() throws IOException {
    public void testCommitRefKeepsSnapshotAlive() throws IOException {
        );
            globalCP::get
        final List<Boolean> lockHeldDuringDelete = new ArrayList<>();
            assertFalse("Monitor should NOT be held during removeFileReferences I/O", held);
            CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,
            List.of(cs1),
            CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,
        IndexFileDeleter deleter = new IndexFileDeleter(policy, tracker, Map.of(), List.of(cs1), null, null, s -> {});
    }
        IndexFileDeleter deleter = new IndexFileDeleter(
        assertTrue("b.parquet should be deleted", deleter1.deletedFiles.contains("b.parquet"));
        assertTrue("Should have attempted more deletes", alwaysFails.deleteAttempts > attemptsAfterRemove);
            s -> {}
        deleter.onCommit(cs2);
import org.opensearch.index.engine.exec.CatalogSnapshotDeletionPolicy;
            for (Collection<String> files : filesToDelete.values()) {
        CatalogSnapshot cs2 = snapshot(2, List.of(segment(1, "parquet", "b.parquet")), commitUserData(200, 200, "uuid"));
        // Fail twice: once during executeDeletesWithRetry, once during the automatic
    // ---- addFileReferences / removeFileReferences ----
    private static Map<String, String> commitUserData(long maxSeqNo, long localCP, String translogUUID) {
        assertFalse(tracker.hasDeletedFile("new_merged.parquet"));
        Files.createFile(parquetDir.resolve("known.parquet"));
        // Release hold
        // Explicit retry — deleter now succeeds (third call)
        expectThrows(AssertionError.class, () -> deleter.addFileReferences(cs3));
        deleter.revisitPolicy();
        AtomicLong globalCP = new AtomicLong(100);
    static class TrackingFileDeleter implements FileDeleter {
        globalCP.set(200);
            Map.of(),
        Files.createFile(parquetDir.resolve("segments_1"));
        deleter.removeFileReferences(cs1);
            shardPath,
        CatalogSnapshot cs2 = snapshot(2, List.of(segment(1, "parquet", "b.parquet")), commitUserData(200, 200, "uuid"));
        assertTrue("a.parquet should be deleted", probe.deletedFiles.contains("a.parquet"));
        CatalogSnapshot cs1 = snapshot(1, List.of(segment(0, "parquet", "cs1_file.parquet")), commitUserData(100, 100, "uuid"));
                } else if ("lucene".equals(e.getKey())) {
        IndexFileDeleter deleter = new IndexFileDeleter(
            List.of(cs1),
        TrackingFileDeleter tracker = new TrackingFileDeleter();
/**
            null,
            null,
import org.opensearch.core.index.shard.ShardId;
    }
    }
        // null commitFileManager — no protection for commit files
    private static CatalogSnapshot snapshot(long gen, List<Segment> segments, Map<String, String> userData) {
    }
            List.of(cs1),
            new DefaultTranslogDeletionPolicy(-1, -1, 0),
        deleter.onCommit(cs2);
        CatalogSnapshot cs1 = snapshot(
        CatalogSnapshot cs2 = snapshot(2, List.of(segment(1, "parquet", "a.parquet", "c.parquet")), commitUserData(200, 200, "uuid"));
        TrackingFileDeleter tracker = new TrackingFileDeleter();
    static class AlwaysFailingDeleter implements FileDeleter {
        AtomicLong globalCP = new AtomicLong(100);
        AtomicLong globalCP = new AtomicLong(100);
            CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,
        // orphan.parquet should be deleted (not referenced, not commit-managed)
    public void testMultiFormatFileDeletion() throws IOException {
            Map.of(),
        // CommitFileManager that protects segments_* files
            commitUserData(100, 100, "uuid")
        assertTrue("segments_1 should be deleted when no CommitFileManager protects it", tracker.hasDeletedFile("segments_1"));
            null,
        assertTrue(tracker.deletedFiles.isEmpty());
        Path parquetDir = shardDir.resolve("parquet");
        Path parquetDir = shardDir.resolve("parquet");
        IndexFileDeleter deleter = new IndexFileDeleter(
        deleter.addFileReferences(cs2);
            CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,
                new WriterFileSet("/data", 0, Set.of("data.parquet"), 1, 0L),
        IndexFileDeleter deleter = new IndexFileDeleter(policy, tracker, Map.of(), List.of(cs1), null, null, s -> {});
     */
            List.of(cs1),
    public void testOrphanScanWithNullCommitFileManagerDeletesEverythingUnreferenced() throws IOException {
        assertTrue("orphan.parquet should be deleted", tracker.hasDeletedFile("orphan.parquet"));
        CatalogSnapshot cs1 = snapshot(
        userData.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(maxSeqNo));
        @Override
    public void testRevisitPolicyDeletesPreviouslyProtectedCommit() throws IOException {
import java.util.Map;
        );
import org.opensearch.index.engine.exec.FileDeleter;
        assertTrue(newFiles.get("parquet").contains("c.parquet"));
import java.util.Set;
        CatalogSnapshot cs1 = snapshot(1, List.of(segment(0, "parquet", "a.parquet")), commitUserData(100, 100, "uuid"));
            Map.of(),
        // revisitPolicy should now delete cs1
            List.of(cs1),
            shardPath,
            s -> {}
        ShardId shardId = new ShardId("test", "test", 0);
            null,
        LockProbeDeleter probe = new LockProbeDeleter(deleter);
        deleter.addFileReferences(cs2);
            return deletedFiles.contains(file);
package org.opensearch.index.engine.exec.coord;
        deleterWithProbe.onCommit(cs2);
            null,
        // snapshot should reference it.
        assertTrue(deleter.getPendingDeletes().get("parquet").contains("shared.parquet"));
        // With null CommitFileManager, segments_1 is treated as an orphan
            Map.of(),
import org.opensearch.index.translog.DefaultTranslogDeletionPolicy;
    // ---- revisitPolicy ----
        ShardId shardId = new ShardId("test", "test", 0);
            alwaysFails,
     * the IndexFileDeleter monitor was held at that time.
        Files.createDirectories(shardDir);
        );
        TrackingFileDeleter tracker = new TrackingFileDeleter();
        CatalogSnapshot cs2 = snapshot(2, List.of(segment(1, "parquet", "ok.parquet")), commitUserData(200, 200, "uuid"));
        final Set<String> deletedFiles = new HashSet<>();
        for (Boolean held : probe.lockHeldDuringDelete) {
            @Override
        final Set<String> deletedFiles = new HashSet<>();
        deleter.removeFileReferences(cs1);
    // ---- Multi-format ----
        public Map<String, Collection<String>> deleteFiles(Map<String, Collection<String>> filesToDelete) {
        IndexFileDeleter deleter = new IndexFileDeleter(
        TrackingFileDeleter tracker = new TrackingFileDeleter();
        // cs2 keeps shared.parquet, adds new file
import org.opensearch.index.seqno.SequenceNumbers;
 * The OpenSearch Contributors require contributions made to
        assertTrue(luceneTracker.hasDeletedFile("_0.cfs"));
            CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,
        CatalogSnapshot cs2 = snapshot(2, List.of(seg2), commitUserData(200, 200, "uuid"));
        CombinedCatalogSnapshotDeletionPolicy policy = new CombinedCatalogSnapshotDeletionPolicy(
public class IndexFileDeleterTests extends OpenSearchTestCase {
        assertTrue("a.parquet should be pending", pending.get("parquet").contains("a.parquet"));
        // Simulate manager releasing its ref (like commitNewSnapshot replacing it)
        AlwaysFailingDeleter failingDeleter = new AlwaysFailingDeleter();
    /**
            }
        assertFalse("segments_1 should be protected by CommitFileManager", tracker.hasDeletedFile("segments_1"));
        // b.parquet was only in cs1 → deleted
import java.nio.file.Path;
        );
            null,
        Path tempDir = createTempDir();
            CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,
                return fileName.startsWith("segments_");
        // Add and commit cs2
        Path shardDir = tempDir.resolve(shardId.getIndex().getUUID()).resolve(String.valueOf(shardId.id()));
        FailNTimesThenSucceedDeleter(int failCount) {
import org.opensearch.index.engine.exec.WriterFileSet;
        deleter.addFileReferences(cs2);
            }
        public Map<String, Collection<String>> deleteFiles(Map<String, Collection<String>> filesToDelete) {
        assertTrue(tracker.hasDeletedFile("cs1_file.parquet"));
 *
            CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,
            new TrackingFileDeleter(),
        IndexFileDeleter deleter = new IndexFileDeleter(
                if ("parquet".equals(e.getKey())) {
        assertTrue(tracker.hasDeletedFile("orphan2.parquet"));
    }
                throw new IOException("Simulated transient I/O failure");
            snapshot(2, List.of(segment(0, "parquet", "a.parquet", "c.parquet")), commitUserData(200, 200, "uuid"))
            deleteAttempts++;
        CatalogSnapshot cs2 = snapshot(
            s -> {}
        deleterWithProbe.addFileReferences(cs2);
            this.failuresRemaining = failCount;
            List.of(cs1),
        CatalogSnapshot cs1 = snapshot(1, List.of(segment(0, "parquet", "a.parquet", "b.parquet")), commitUserData(100, 100, "uuid"));
        // Files NOT deleted — commit ref keeps it alive
                new WriterFileSet("/data", 1, Set.of("data2.parquet"), 1, 0L),
            for (Collection<String> files : filesToDelete.values()) {
        Path tempDir = createTempDir();
            if (failuresRemaining > 0) {
                new WriterFileSet("/data", 1, Set.of("_1.cfs"), 1, 0L)
        // Fail twice: once during executeDeletesWithRetry, once during the automatic
    public void testRemoveFileReferencesDeletesOrphanedFiles() throws IOException {
