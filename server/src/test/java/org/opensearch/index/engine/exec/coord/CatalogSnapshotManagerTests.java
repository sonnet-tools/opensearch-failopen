            1L,
        Segment seg2 = new Segment(2L, Map.of(format.name(), new WriterFileSet("/tmp/dir", 2L, Set.of("b.cfs"), 200, 0L)));
     * guards against double-apply now that source presence is no longer required.
        );
        // Plant files: 1 known (in catalog), 1 orphan, 2 commit-owned.
    }
        );
            }
        manager.close();
        AtomicLong globalCP = new AtomicLong(100);
        }
}
                assertEquals(Set.of("merged.cfs"), segments.get(0).dfGroupedSearchableFiles().get(format.name()).files());
     * <p>Matching by generation is what makes this work; matching by record equality rejected it
        assertFalse("_shared should NOT be deleted (still in CS2)", deleted.contains("_shared.parquet"));
    public void testApplyMergeResultsWithEmptyWriterFileSetMapThrows() throws Exception {
    public void testCreateForReplicaProducesEmptySnapshot() throws Exception {
        ShardPath shardPath,
    }
        assertTrue("snapshot should be closed after the last ref is released", ((DataformatAwareCatalogSnapshot) heldSnapshot).isClosed());
            policy,
                assertSame("replicatingCommitData must be carried forward unchanged", commitData, latest.getReplicatingCommitData());
        IndexFileDeleterTests.TrackingFileDeleter tracker = new IndexFileDeleterTests.TrackingFileDeleter();
        cs1.setLastCommitInfo("segments_1", 1L, 0L);
                    assertNotNull("replicatingCommitData must remain non-null after repeated bumps", latest.getReplicatingCommitData());
            segment(2, "parquet", "_2_data.parquet", "_2_index.parquet")
            logger,
     * (e.g. {@code segments_N}, {@code write.lock}) from the startup orphan sweep, even when
 */
                assertEquals(Set.of("merged.cfs"), segments.get(0).dfGroupedSearchableFiles().get(format.name()).files());
     * ({@code RefreshResult.droppedGenerations}). The merge must still apply: the remaining
            policy,
        try {
            manager.close();
        WriterFileSet wfs1 = new WriterFileSet("/tmp/dir", 1L, Set.of("a.cfs"), 100, 0L);
import org.opensearch.index.shard.ShardPath;
        AtomicLong globalCP = new AtomicLong(100);
        FileDeleter luceneDeleter = filesByFormat -> {
        globalCP.set(200);
            assertEquals("snapshot untouched", List.of(1L, 2L, 4L), generationsOf(manager));
                }
        }
        cs1.setLastCommitInfo("segments_1", 1L, 0L);
    public void testSnapshotProtectionPreventsFileDeletion() throws Exception {
import org.opensearch.index.engine.dataformat.stub.MockDataFormat;
            tracker,
                    assertEquals(3, currentSnap.refCount());
                }
            try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
            long version = randomNonNegativeLong();
        return userData;
            Map.of(),
                    assertSame(commitData, latest.getReplicatingCommitData());
        manager.commitNewSnapshot(randomSegments());
        // FileDeleter deletes from the Lucene index directory.
        assertTrue("_0_data should be deleted", deleted.contains("_0_data.parquet"));
        try {
            int extraBumps = randomIntBetween(1, 10);
                    assertEquals(2 + numAcquires - r - 1, currentSnap.refCount());
            randomNonNegativeLong(),
import org.opensearch.common.concurrent.GatedCloseable;
    /** Builds a manager over the given segments; caller closes it. */
        );
        }
            try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
            manager.applyMergeResults(new MergeResult(Map.of(format, mergedWfs)), new OneMerge(List.of(staleSeg1, seg2)));
     * Replica manager with an empty {@code initialCommittedSnapshots} must still produce
 * Tests for {@link CatalogSnapshotManager}.
    /**
            try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
        return new Segment(randomNonNegativeLong(), dfGrouped);
                } catch (java.io.IOException e) {
            List.of(),
        cs1.setLastCommitInfo("segments_1", 1L, 0L);
            mock(CommitFileManager.class)
        assertFalse("snapshot should not be closed while a ref is still held", ((DataformatAwareCatalogSnapshot) heldSnapshot).isClosed());
        WriterFileSet wfs1 = new WriterFileSet("/tmp/dir", 1L, Set.of("a.cfs"), 100, 0L);
        try (GatedConditionalCloseable<CatalogSnapshot> commitRef = manager.acquireSnapshotForCommit()) {
                }
            assertTrue("known.si must survive — referenced by catalog", Files.exists(known));
        CatalogSnapshotManager manager = createRandomManager();
            manager.bumpGeneration();
                () -> manager.applyMergeResults(new MergeResult(Map.of(format, mergedWfs)), new OneMerge(List.of(seg1, seg2)))
import java.util.Collections;
    // --- helpers ---
                throw new UnsupportedOperationException("not used by this test");
    /**
 *
                    assertEquals(initialUserData, ref.get().getUserData());
        WriterFileSet mergedWfs = new WriterFileSet("/tmp/dir", 4L, Set.of("merged.cfs", "merged.liv"), 250, 0L);
            previous.getGeneration() + 1,
                0L,
     */
            }
    }
            List.of(),
    public void testApplyMergeResultsAppliesWhenOneSourceGenerationWasDropped() throws Exception {
            randomNonNegativeLong(),
            null,
                manager.bumpGeneration();
            }
    private CatalogSnapshotManager createRandomManager() {
            commitRef.markSuccess();
                mock(CommitFileManager.class)
            0L,
    }
        // CS1: segment _0
                0L,
        }
            1L,
            for (String f : filesByFormat.getOrDefault("lucene", List.of())) {
    private static List<Long> generationsOf(CatalogSnapshotManager manager) throws IOException {
        DataFormat format = new MockDataFormat();
        CatalogSnapshotManager manager = managerOver(List.of(seg1, seg2));
            return allFailed;
        CatalogSnapshot refreshedSnapshot;
    /**
                }
            List.of(),
                    // refCount = 2: manager "latest" + reader (no commit ref on refresh-created snapshots)
            commitUserData(100, 100, translogUUID)
        manager.close();
        IndexFileDeleterTests.TrackingFileDeleter tracker = new IndexFileDeleterTests.TrackingFileDeleter();
        manager.commitNewSnapshot(List.of(segment(2, "parquet", "_2_data.parquet")));
            tracker,
     * SegmentInfos.
        // Refresh: CS2 with different files
                assertEquals(300, segments.get(0).dfGroupedSearchableFiles().get(format.name()).numRows());
            try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
            Map.of("local_checkpoint", "50", "max_seq_no", "100", "translog_uuid", "test-uuid")
                IllegalStateException.class,
        // Now _shared should be deleted (CS2 commit deleted by policy)
            for (int c = 0; c < randomIntBetween(0, 5); c++) {
        Map<String, String> userData,
        CommitFileManager commitFileManager
    public void testApplyReplicationSnapshotOnClosedManagerThrows() throws Exception {
        DataFormat format = new MockDataFormat();
        WriterFileSet wfs = new WriterFileSet(indexDir.toString(), 1L, Set.of("known.si"), 0, 0L);
            commitRef.markSuccess();
     * A refresh applying deletes rewrites an existing generation's live-docs file, so that
        // The current view: gen 1 gained a live-docs file. Same generation, different record.
            Map.of(),
 */
        } finally {
        try {
        Segment seg2 = new Segment(2L, Map.of(format.name(), new WriterFileSet("/tmp/dir", 2L, Set.of("b.cfs"), 200, 0L)));
import java.util.ArrayList;
        }
        assertFalse(((DataformatAwareCatalogSnapshot) refreshedSnapshot).isClosed());
        }
        DataFormat format = new MockDataFormat();
        );
        List<Segment> cs1Segments = List.of(segment(0, "parquet", "_0_data.parquet"), segment(1, "parquet", "_1_data.parquet"));
        DataformatAwareCatalogSnapshot snapshot = new DataformatAwareCatalogSnapshot(
            logger,
            0L,
        // Flush CS3
        // Now _0_data should be deleted
        Path indexDir = shardRoot.resolve("index");
            String format = randomFrom("lucene", "parquet");
            WriterFileSet mergedWfs = new WriterFileSet("/tmp/dir", 3L, Set.of("merged.cfs"), 1, 0L);
    public void testAcquireAndReleaseViaGatedCloseable() throws Exception {
            List.of(cs1),
        CombinedCatalogSnapshotDeletionPolicy policy = new CombinedCatalogSnapshotDeletionPolicy(
        try (GatedConditionalCloseable<CatalogSnapshot> commitRef = manager.acquireSnapshotForCommit()) {
            OneMerge oneMerge = new OneMerge(List.of(seg1, seg2));
        // Build a snapshot that references only `known.si` under the lucene format.
import org.opensearch.index.engine.dataformat.MergeResult;
    public void testApplyReplicationSnapshotReplacesAndReleasesPrevious() throws Exception {
            manager.close();
        return userData;
            1L,
        );
    /**
                for (int a = 0; a < numAcquires; a++) {
                assertEquals(3, heldSnapshot.refCount());
    public void testApplyMergeResultsReplacesSegments() throws Exception {
    public void testBumpGenerationPreservesReplicatingCommitData() throws Exception {
     * snapshot's non-null {@code replicatingCommitData} (the value the primary replicated).
        // Refresh: merge _0+_1 into _2, add new _3
            // close() only sets the closed flag — does not decRef (files must survive for recovery)
        IndexFileDeleterTests.TrackingFileDeleter tracker = new IndexFileDeleterTests.TrackingFileDeleter();
        };
        }
        Set<String> deleted = tracker.deletedFiles;
            ((DataformatAwareCatalogSnapshot) refreshedSnapshot).isClosed()
        WriterFileSet mergedWfs = new WriterFileSet("/tmp/dir", 4L, Set.of("merged.cfs"), 300, 0L);
            List.of(cs),
                CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,
    }
    }
        manager.close();
        } catch (IOException e) {
        Files.write(leftover, new byte[] { 0 });
        Segment seg4 = new Segment(4L, Map.of(format.name(), new WriterFileSet("/tmp/dir", 4L, Set.of("d.cfs"), 400, 0L)));
                CatalogSnapshot seed = ref.get();
            manager.applyMergeResults(mergeResult, oneMerge);
        try {
        manager.close();
            new DefaultTranslogDeletionPolicy(-1, -1, 0),
            throw new AssertionError("unreachable", e);
                assertNotNull("replicatingCommitData must survive a generation bump", latest.getReplicatingCommitData());
    public void testReaderHoldsSnapshotAliveAcrossRefreshes() throws Exception {
     * sources are replaced and the merged output installed.
                manager.commitNewSnapshot(randomSegments());
        CombinedCatalogSnapshotDeletionPolicy policy = new CombinedCatalogSnapshotDeletionPolicy(
                }
    public void testReplicationSnapshotThenBumpPreservesReplicatingCommitData() throws Exception {
    public void testUserDataPreservationOnCommit() throws Exception {
        );
import org.opensearch.index.engine.SafeCommitInfo;
            try {
        );
        long numRows = randomIntBetween(1, 10000);
            assertFalse("orphan.si must be swept — not in catalog and not commit-managed", Files.exists(orphan));
        }
     * deletes, because Lucene's {@code commitMerge} carries them onto the merged segment.
        WriterFileSet wfs2 = new WriterFileSet("/tmp/dir", 2L, Set.of("b.cfs"), 200, 0L);
            assertEquals("gens 1 and 2 replaced by the merged gen 4", List.of(3L, 4L), generationsOf(manager));
        CombinedCatalogSnapshotDeletionPolicy policy = new CombinedCatalogSnapshotDeletionPolicy(
            files -> Map.of(),
            new DefaultTranslogDeletionPolicy(-1, -1, 0),
                assertSame(commitData, latest.getReplicatingCommitData());
    }
            CatalogSnapshot finalSnapshot;
        Path writeLock = indexDir.resolve("write.lock");
        return new WriterFileSet(directory, randomNonNegativeLong(), files, numRows, 0L);
        Map<String, String> userData = new HashMap<>();
        WriterFileSet wfs2 = new WriterFileSet("/tmp/dir", 2L, Set.of("b.cfs"), 200, 0L);
            logger,
                    prev = ref.get();
 * compatible open source license.
            manager.applyMergeResults(new MergeResult(Map.of(format, mergedWfs)), new OneMerge(List.of(seg1, seg2)));
            snapshot = ref.get();
    /**
        try (GatedConditionalCloseable<CatalogSnapshot> commitRef = manager.acquireSnapshotForCommit()) {
    }
        CatalogSnapshotManager manager = new CatalogSnapshotManager(
        manager.commitNewSnapshot(List.of(segment(3, "parquet", "_3_data.parquet")));
                files -> Map.of(),
            }
            null,
    public void testReferenceCountingLifecycle() throws Exception {
        }
                        assertTrue(seenIds.add(ref.get().getId()));
        // Flush CS2
    }
import org.opensearch.index.engine.dataformat.merge.OneMerge;
        AtomicLong globalCP = new AtomicLong(100);
                // commit = 1 (reader released, commit ref still held — no flush to trigger policy)
        }
        );
            );
            }
            try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
            assertEquals(1, finalSnapshot.refCount());
                try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
    public void testMergedFilesDeletedAfterCommit() throws Exception {
    }
            );
        cs1.setLastCommitInfo("segments_1", 1L, 0L);
        );
            "snapshot should be closed when commit replaces the last ref",
            return Map.of();
                assertEquals(lastWriterGeneration, acquired.getLastWriterGeneration());
        }
                assertEquals(0L, snapshot.getId());
            commitRef.get().setUserData(commitUserData(200, 200, translogUUID), true);
        AtomicLong globalCP = new AtomicLong(100);
            List.of(cs1),
import org.opensearch.index.translog.Translog;
            1L,
            OneMerge oneMerge = new OneMerge(List.of(seg1));
 * this file be licensed under the Apache-2.0 license or a
                IllegalStateException.class,
            manager.bumpGeneration();
                // manager + commit + reader = 3
        // CS1 deleted by policy → _0_data and _1_data should be deleted (not in CS2)
        }
        FileDeleter unused = filesByFormat -> Map.of();
        // Reader acquires CS1
        DataformatAwareCatalogSnapshot cs1 = new DataformatAwareCatalogSnapshot(0, 0, 1, List.of(seg1, seg2), 0, Map.of());
    ) throws IOException {
    public void testCloseInternalInvokedOnCommit() throws Exception {
            globalCP::get
            logger,
    private static Segment segment(long gen, String format, String... files) {
            List.of(cs1),
            manager.close();
            initial.setLastCommitInfo("segments_1", 1L, 0L);
    private Segment randomSegment() {
                Map.of()
            assertEquals("surviving source removed, merged installed", List.of(3L, 4L), generationsOf(manager));
import java.util.concurrent.atomic.AtomicLong;
        readerRef.close();
            CatalogSnapshot previous;
     * Genuine invariant violation: a merge may drop rows (deletes) but can never produce more rows
        // Reader releases
import java.util.Set;
        int fileCount = randomIntBetween(1, 5);
        assertFalse("_3_data.parquet should NOT be deleted", deleted.contains("_3_data.parquet"));
        manager.commitNewSnapshot(List.of(segment(1, "parquet", "_shared.parquet"), segment(2, "parquet", "_2_data.parquet")));
            globalCP::get
        assertFalse(((DataformatAwareCatalogSnapshot) snapshot).isClosed());
            manager.close();
        WriterFileSet wfs3 = new WriterFileSet("/tmp/dir", 3L, Set.of("c.cfs"), 300, 0L);
    public void testGetSafeCommitInfoDelegatesToPolicy() throws IOException {
        } finally {
            manager.applyMergeResults(new MergeResult(Map.of(format, mergedWfs)), new OneMerge(List.of(seg1, seg2)));
        Segment seg2 = new Segment(2L, Map.of(format.name(), new WriterFileSet("/tmp/dir", 2L, Set.of("b.cfs"), 200, 0L)));
            commitRef.get().setUserData(commitUserData(300, 300, translogUUID), true);
            manager.applyReplicationSnapshot(incoming);
            public void deleteCommit(CatalogSnapshot snapshot) {}
            CatalogSnapshotManager manager = createManager(randomSegments(), Collections.emptyMap());
            Map.of(),
        for (int i = 0; i < fileCount; i++) {
        Path shardRoot = createTempDir().resolve(shardId.getIndex().getUUID()).resolve(String.valueOf(shardId.id()));
    }
        try {
    }
            CatalogSnapshot latest = ref.get();
            assertEquals("latest should have incoming's segments", incoming.getSegments(), latest.getSegments());
        manager.commitNewSnapshot(cs2Segments);
    }
        Segment seg2 = new Segment(2L, Map.of(format.name(), wfs2));
            manager.close();
import org.opensearch.core.index.shard.ShardId;
            refreshedSnapshot = ref.get();
            }
            public byte[] serializeToCommitFormat(CatalogSnapshot snapshot) {
    private Map<String, String> randomUserData(int entries) {
                    Map<String, java.util.Collection<String>> failed = deleter.deleteFiles(filesToDelete);
    /**
            1L,
                // manager + commit = 2
    public void testCreateForReplicaWithCommitFileManagerProtectsCommitFiles() throws Exception {
        assertTrue(
        assertNotEquals("the two views must not be equal Segments", staleSeg1, liveSeg1);
     */
        CatalogSnapshotManager manager = managerOver(List.of(seg1, seg2, seg4));
        }
            List<Segment> segments = randomIntBetween(1, 5) == 1 ? Collections.emptyList() : randomSegments();
        CatalogSnapshotManager manager = createRandomManager();
                    }
    }
        }
        manager.commitNewSnapshot(randomSegments());
            Map.of(),
            manager.close();
            @Override
                assertEquals(2, finalSnapshot.refCount());
        );
        assertTrue("_0_data should be deleted after reader releases", tracker.deletedFiles.contains("_0_data.parquet"));
     */
            commitRef.markSuccess();
        try {
        }
        for (int iter = 0; iter < 100; iter++) {
        } finally {
        CatalogSnapshotManager manager = managerOver(List.of(liveSeg1, seg2, seg3));
        // CS1: _0 and _1
        assertTrue("_0_data.parquet should be deleted", deleted.contains("_0_data.parquet"));
            assertTrue("must name the collision, got: " + e.getMessage(), e.getMessage().contains("collides with a retained segment"));
            Object commitData = new Object();
        String translogUUID = "test-uuid";
            List.of(segment(0, "parquet", "_0_data.parquet")),
            manager.close();
        );
        }
        DataformatAwareCatalogSnapshot cs1 = new DataformatAwareCatalogSnapshot(
            List.of(cs1),
            }
            }
        // Plant a file in <shard>/index/ — there is no snapshot referencing it and no prior
import java.nio.file.Path;
                null,
        // Flush CS2
            return createManager(randomSegments(), Map.of());
            0L,
                randomNonNegativeLong(),
        Segment seg1 = new Segment(1L, Map.of(format.name(), wfs1));
            commitRef.markSuccess();
        // Flush CS2
        Segment seg1 = new Segment(1L, Map.of(format.name(), new WriterFileSet("/tmp/dir", 1L, Set.of("a.cfs"), 100, 0L)));
            files -> Map.of(),
            Map.of(),
            // set userData on the snapshot for the policy to read
                List.of(),
            assertEquals(1, initialSnapshot.refCount());
        Segment seg1 = new Segment(1L, Map.of(format.name(), new WriterFileSet("/tmp/dir", 1L, Set.of("a.cfs"), 100, 0L)));
                CatalogSnapshot acquired = ref.get();
            CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,
                GatedCloseable<CatalogSnapshot> heldRef = manager.acquireSnapshot();
        // CS1: segments _0, _1
        Path segmentsCommit = indexDir.resolve("segments_7");
import org.opensearch.index.engine.dataformat.DataFormat;
                }
    }
            globalCP::get
    public void testGetSafeCommitInfoWithKeepLatestOnlyReturnsEmpty() throws IOException {
            null,
        DataformatAwareCatalogSnapshot cs1 = new DataformatAwareCatalogSnapshot(0, 0, 1, List.of(seg1), 0, Map.of());
            return ref.get().getSegments().stream().map(Segment::generation).sorted().collect(java.util.stream.Collectors.toList());
        // Refresh CS2: keeps _shared, replaces _0 with _2
import org.opensearch.index.engine.exec.WriterFileSet;
                assertEquals(0L, seed.getGeneration());
        } finally {
            policy,
            1L,
        List<Segment> cs2Segments = List.of(
        assertEquals(50L, info.localCheckpoint);
        List<Segment> cs1Segments = List.of(
            Map<String, String> initialUserData = randomUserData(randomIntBetween(1, 5));
        Set<String> deleted = tracker.deletedFiles;
                        previousGeneration = ref.get().getGeneration();
    /**
            assertEquals("latest should have incoming's version", incoming.getVersion(), latest.getVersion());
            commitRef.get().setUserData(commitUserData(200, 200, translogUUID), true);
        // Flush latest
            }
import static org.mockito.Mockito.mock;
        } finally {
            Map.of(),
        AtomicLong globalCP = new AtomicLong(100);
        // Neither source survives in the catalog.
            // A single bump must carry the data forward by identity.
            manager.close();
            List.of(),
            tracker,
            commitUserData(100, 100, translogUUID)
        ) {
            Map.of(),
        manager.close();
                try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
            committed = initialCommittedSnapshots;
        }
            IllegalStateException e = expectThrows(
                Set<Long> seenIds = new HashSet<>();
        );
        ShardId shardId = new ShardId(new Index("test", "_na_"), 0);
            long generation = randomIntBetween(0, 100);
        CatalogSnapshotManager manager = managerOver(List.of(seg1, seg2));
    /**
    public void testCommitProducesCorrectNewSnapshot() throws Exception {
            assertTrue("segments_7 must survive — protected by CommitFileManager", Files.exists(segmentsCommit));
        SafeCommitInfo info = manager.getSafeCommitInfo();
import java.util.Map;
import java.io.IOException;
        );
            manager.close();
                CatalogSnapshot prev;
        // CS1 is snapshotted — should NOT be deleted
        CatalogSnapshotManager manager = createRandomManager();
        initial.setLastCommitInfo("segments_1", 1L, 0L);
        assertTrue("_shared should be deleted after CS2 commit removed", tracker.deletedFiles.contains("_shared.parquet"));
                manager.close();
                assertEquals(generation, acquired.getGeneration());
        Path leftover = indexDir.resolve("leftover.si");
            null,
        for (int i = 0; i < randomIntBetween(0, 5); i++) {
        String translogUUID = "test-uuid";
    private CatalogSnapshotManager managerOver(List<Segment> segments) throws IOException {
            null,
        cs1.setLastCommitInfo("segments_1", 1L, 0L);
            commitRef.get().setUserData(commitUserData(200, 200, translogUUID), true);
        try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
        return segments;
        initial.setReplicatingCommitData(commitData);
        return createManager(segments, userData, CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY, files -> Map.of());
import org.opensearch.index.translog.DefaultTranslogDeletionPolicy;
     */
        try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
                assertNotNull("replicatingCommitData must survive the post-replication bump", latest.getReplicatingCommitData());
                    DataformatAwareCatalogSnapshot latest = (DataformatAwareCatalogSnapshot) ref.get();
        CatalogSnapshotManager manager = managerOver(List.of(seg9));
    /**
            List.of(snapshot),
            try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
                DataformatAwareCatalogSnapshot latest = (DataformatAwareCatalogSnapshot) ref.get();
     */
                manager.close();
        WriterFileSet wfs = new WriterFileSet("/data", gen, Set.of(files), files.length, 0L);
            List.of(),
    public void testSharedFilesDeletedOnlyWhenAllRefsGone() throws Exception {
                0L,
            randomSegments(),
        // Do a refresh so we get a snapshot without a commit ref
            @Override
        DataFormat format = new MockDataFormat();
        Segment seg1 = new Segment(1L, Map.of(format.name(), new WriterFileSet("/tmp/dir", 1L, Set.of("a.cfs"), 100, 0L)));
            manager.commitNewSnapshot(randomSegments());
                for (int c = 0; c < numCommits; c++) {
        CombinedCatalogSnapshotDeletionPolicy policy = new CombinedCatalogSnapshotDeletionPolicy(
        return new Segment(gen, Map.of(format, wfs));
        manager.close();
            List.of(),
        CatalogSnapshot heldSnapshot = heldRef.get();
            assertEquals("merged segment prepended", List.of(9L, 10L), generationsOf(manager));
            assertEquals("snapshot untouched", List.of(1L, 2L), generationsOf(manager));
        List<CatalogSnapshot> committed;
                try (GatedCloseable<CatalogSnapshot> initialRef = manager.acquireSnapshot()) {
        CatalogSnapshotManager manager = new CatalogSnapshotManager(
        globalCP.set(300);
                int numAcquires = randomIntBetween(1, 5);
     * Trace from the dry-run: refresh adds new segment, flush commits,
        // Now CS1 refCount hits 0 → removeFileReferences → _0_data deleted
                try {
                List<Segment> segments = ref.get().getSegments();
        );
    }
        snapshot.setLastCommitInfo("segments_1", 1L, 0L);
            CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,
        );
     */
                assertEquals(4L, segments.get(0).generation());
                    throw new RuntimeException(e);
    }
                }
        }
    }
                assertEquals(1, prev.refCount());
                assertEquals(segments, acquired.getSegments());
                randomNonNegativeLong(),
     * than it read, so an inflated output must still be rejected.
    private static Map<String, String> commitUserData(long maxSeqNo, long localCheckpoint, String translogUUID) {
                // Initial snapshot has commit ref, so: manager + commit + reader = 3
     */
     * Fewer rows out than in is legitimate — that is compaction dropping deleted rows — so it must
        );
                    currentSnap = initialRef.get();
import java.util.List;
            manager.close();
    }
            IllegalStateException e = expectThrows(
        }
            1L,
            } finally {
        DataformatAwareCatalogSnapshot cs1 = new DataformatAwareCatalogSnapshot(
        CatalogSnapshot snapshot;
     * Snapshot protection: a held snapshot prevents file deletion even after a new commit.
            CatalogSnapshotManager manager = new CatalogSnapshotManager(
        userData.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(maxSeqNo));
        IndexFileDeleterTests.TrackingFileDeleter tracker = new IndexFileDeleterTests.TrackingFileDeleter();
            try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
                Files.deleteIfExists(indexDir.resolve(f));
            long initGen = randomIntBetween(0, 100);
            List.of(),
            List.of(),
            CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,
        );
            1L,
        Set<String> files = new HashSet<>();
     * Every source generation dropped during the merge. The merged segment still has to land in the
        globalCP.set(200);
    }
        CatalogSnapshotManager manager = new CatalogSnapshotManager(
            MergeResult mergeResult = new MergeResult(Map.of(format, mergedWfs));
 * The OpenSearch Contributors require contributions made to
                        assertEquals(previousGeneration + 1, ref.get().getGeneration());
import org.opensearch.index.engine.exec.CatalogSnapshotDeletionPolicy;
        for (int iter = 0; iter < 100; iter++) {
import org.opensearch.index.engine.exec.FileDeleter;
            expectThrows(IllegalStateException.class, manager::acquireSnapshot);
                assertEquals(2, currentSnap.refCount());
            Map.of(),
            public boolean isCommitManagedFile(String fileName) {
                assertEquals(2, segments.size());
     * apply rather than trip the conservation check.
            assertEquals("latest should have incoming's userData", incoming.getUserData(), latest.getUserData());
        DataFormat format = new MockDataFormat();
            for (FileDeleter deleter : perFormatDeleters.values()) {
        try (
     */
            null,
                // Merged segment takes the position of the first removed source, carrying its .liv.
            globalCP::get
    public void testCreateForReplicaWithEmptyInitialDoesNotTouchDisk() throws Exception {
        try {
     * a usable manager seeded with an empty snapshot. On-disk files are left alone because the
        Files.createDirectories(indexDir);
    /**
        } finally {
            );
        AtomicLong globalCP = new AtomicLong(100);
            null,
     */
                CatalogSnapshot currentSnap;
            );
        manager.commitNewSnapshot(randomSegments());
                assertEquals(1, heldSnapshot.refCount());
                -1L,
                manager.commitNewSnapshot(randomSegments());
            null,
                initialSnapshot = ref.get();
        manager.close();
     * Once an initial snapshot carries non-null {@code replicatingCommitData}, a generation bump
            1L,
            List.of(cs1),
        }
                () -> manager.applyMergeResults(new MergeResult(Map.of(format, mergedWfs)), new OneMerge(List.of(seg1, seg2)))
            commitRef.markSuccess();
        CatalogSnapshotManager manager = managerOver(List.of(seg1, seg3));
        }
        try (GatedConditionalCloseable<CatalogSnapshot> commitRef = manager.acquireSnapshotForCommit()) {
        // What the merge selected, before any delete landed.
        try {
                }
            userData.put(randomAlphaOfLength(5), randomAlphaOfLength(10));
            cs1Segments,
     * Genuine invariant violation: re-applying a merge would duplicate its output, so a merged
        CatalogSnapshotManager manager = replicaManager(null, List.of(), Map.of(), mock(CommitFileManager.class));
    private WriterFileSet randomWriterFileSet(String format, long numRows) {
        cs.setLastCommitInfo("segments_1", 1L, 0L);
import java.nio.file.Files;
                randomNonNegativeLong(),
        // Manager has seg1 and seg2 — the segments being merged are present
                manager.commitNewSnapshot(randomSegments());
        manager.close();
        for (int i = 0; i < entries; i++) {
            CatalogSnapshotManager manager = createManager(randomSegments(), initialUserData);
                    assertEquals(2 + (a + 1), currentSnap.refCount());
        CombinedCatalogSnapshotDeletionPolicy policy = new CombinedCatalogSnapshotDeletionPolicy(
                assertEquals(3L, segments.get(0).generation());
        CatalogSnapshotManager manager = createRandomManager();
        CatalogSnapshotManager manager = replicaManager(null, List.of(), Map.of(), mock(CommitFileManager.class));
            tracker,
        List<CatalogSnapshot> initialCommittedSnapshots,
            manager.close();
                previous = ref.get();
            List.of(segment(0, "parquet", "_0_data.parquet")),
        // CS1: segment _0
import org.opensearch.common.concurrent.GatedConditionalCloseable;
    }
            OneMerge oneMerge = new OneMerge(List.of(seg1, seg2));
            mock(CommitFileManager.class)
        ShardPath shardPath = new ShardPath(false, shardRoot, shardRoot, shardId);
     * Reader holding a snapshot keeps it alive across refreshes,
                // unmerged segment preserved
                }
        return new CatalogSnapshotManager(committed, CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY, filesToDelete -> {
        }
        CommitFileManager cfm = new CommitFileManager() {
            for (int i = 0; i < extraBumps; i++) {
        CatalogSnapshotManager manager = new CatalogSnapshotManager(
        }
    public void testApplyMergeResultsAppliesWhenMergedRowCountIsLower() throws Exception {
    public void testCloseInternalNotInvokedWhileRefsHeld() throws Exception {
            DataformatAwareCatalogSnapshot initial = (DataformatAwareCatalogSnapshot) CatalogSnapshotManager.createInitialSnapshot(
        }
                List<Segment> segments = ref.get().getSegments();
            new DefaultTranslogDeletionPolicy(-1, -1, 0),
                assertNotNull("replicatingCommitData must be copied from the incoming snapshot", latest.getReplicatingCommitData());
                finalSnapshot = ref.get();
        // CS1: initial committed snapshot with segments _0, _1
        Path known = indexDir.resolve("known.si");
        Segment seg9 = new Segment(9L, Map.of(format.name(), new WriterFileSet("/tmp/dir", 9L, Set.of("i.cfs"), 900, 0L)));
    private List<Segment> randomSegments() {
        DataformatAwareCatalogSnapshot cs1 = new DataformatAwareCatalogSnapshot(
            WriterFileSet mergedWfs = new WriterFileSet("/tmp/dir", 4L, Set.of("merged.cfs"), 300, 0L);
     *
            }
    public void testCloseOnlySetsFlagDoesNotDecRef() throws Exception {
    public void testRefreshThenFlushDeletesOldCommitFiles() throws Exception {
    }
                // The untouched segment keeps its current record.
        DataformatAwareCatalogSnapshot snapshot = new DataformatAwareCatalogSnapshot(1L, 1L, 0L, segments, 1L, userData);
    ) throws IOException {
        }
        return new CatalogSnapshotManager(
        String[] extensions = "lucene".equals(format) ? new String[] { "cfs", "si", "dat" } : new String[] { "parquet" };
        // gen 4 is already in the catalog and is NOT a merge source, so it would be retained.
        }
    }
        } finally {
            try {
        List<Segment> cs2Segments = List.of(segment(2, "parquet", "_2_data.parquet"), segment(3, "parquet", "_3_data.parquet"));
        }
                assertEquals(seg3, segments.get(1));
            Map.of(),
            files.add(randomAlphaOfLength(6) + "." + randomFrom(extensions));
        DataFormat format = new MockDataFormat();
        try {
            assertTrue("must report the row mismatch, got: " + e.getMessage(), e.getMessage().contains("row count mismatch"));
                randomUserData(randomIntBetween(0, 4))
        Segment seg2 = new Segment(2L, Map.of(format.name(), new WriterFileSet("/tmp/dir", 2L, Set.of("b.cfs"), 200, 0L)));
            mock(CommitFileManager.class)
        manager.commitNewSnapshot(randomSegments());
        Segment seg1 = new Segment(1L, Map.of(format.name(), wfs1));
            WriterFileSet mergedWfs = new WriterFileSet("/tmp/dir", 4L, Set.of("merged.cfs"), 150, 0L);
        Segment seg3 = new Segment(3L, Map.of(format.name(), new WriterFileSet("/tmp/dir", 3L, Set.of("c.cfs"), 300, 0L)));
            }
        CatalogSnapshot previous;
        }
                    manager.commitNewSnapshot(newSegments);
            CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,
                heldRef.close();
            CatalogSnapshot initialSnapshot;
        ShardId shardId = new ShardId(new Index("test", "_na_"), 0);
            } finally {
            long id = randomNonNegativeLong();
        Segment seg3 = new Segment(3L, Map.of(format.name(), new WriterFileSet("/tmp/dir", 3L, Set.of("c.cfs"), 300, 0L)));
        for (int i = 0; i < randomIntBetween(1, 2); i++) {
            }
        DataformatAwareCatalogSnapshot cs1 = new DataformatAwareCatalogSnapshot(
        // So CS1's refCount > 0, removeFileReferences not called yet
    }
            1L,
            1L,
    /**
    }
                assertEquals("prepended at the front", 10L, ref.get().getSegments().get(0).generation());
            CatalogSnapshotManager manager = createRandomManager();
        return new CatalogSnapshotManager(List.of(snapshot), policy, fileDeleter, Map.of(), List.of(), null, mock(CommitFileManager.class));
        // Flush CS1 so it's a proper commit
            }
        for (int iter = 0; iter < 100; iter++) {
                try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
            globalCP::get
            policy,
        WriterFileSet mergedWfs = new WriterFileSet("/tmp/dir", 3L, Set.of("merged.cfs"), 300, 0L);
        // No files deleted yet — CS1's commit ref keeps its files alive
        assertFalse("_0_data should not be deleted while reader holds ref", tracker.deletedFiles.contains("_0_data.parquet"));
    public void testApplyMergeResultsThrowsWhenMergedRowCountExceedsSources() throws Exception {
        assertFalse("_0_data should not be deleted while snapshot is held", tracker.deletedFiles.contains("_0_data.parquet"));
                assertEquals(4L, segments.get(0).generation());
        Segment seg = new Segment(1L, Map.of("lucene", wfs));
            1L,
            long initGen = randomIntBetween(0, 100);
            try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
    public void testApplyMergeResultsAppliesWhenAllSourceGenerationsWereDropped() throws Exception {
        Segment seg2 = new Segment(2L, Map.of(format.name(), new WriterFileSet("/tmp/dir", 2L, Set.of("b.cfs"), 200, 0L)));
            WriterFileSet mergedWfs = new WriterFileSet("/tmp/dir", 3L, Set.of("merged.cfs"), 301, 0L);
        assertTrue(tracker.deletedFiles.isEmpty());
    public void testApplyMergeResultsThrowsWhenMergedGenerationCollidesWithRetained() throws Exception {
        manager.commitNewSnapshot(cs2Segments);
            segment(1, "parquet", "_1_data.parquet", "_1_index.parquet")
                assertEquals(id, acquired.getId());
                assertEquals(3, initialSnapshot.refCount());
        if (initialCommittedSnapshots.isEmpty()) {
     * old committed snapshot's files are deleted when policy removes it.
    // --- File deletion and commit lifecycle tests ---
                assertEquals(0L, snapshot.getGeneration());
            List.of(initial),
        };
        assertTrue("No files should be deleted since CS2 shares all files with CS1", tracker.deletedFiles.isEmpty());
        } finally {
            }
        try {
                int numCommits = randomIntBetween(1, 10);
        for (int iter = 0; iter < 100; iter++) {
            }
        assertEquals(0, info.docCount);
            null,
        manager.commitNewSnapshot(randomSegments());
                DataformatAwareCatalogSnapshot latest = (DataformatAwareCatalogSnapshot) ref.get();
        }
    private static CatalogSnapshotManager replicaManager(
                for (int r = 0; r < numAcquires; r++) {
/**
        Map<String, String> userData = commitUserData(100, 100, translogUUID);
                    List<Segment> newSegments = randomSegments();
            assertEquals(2, initialSnapshot.refCount());
        Files.createDirectories(indexDir);
            1L,
        // Refresh: CS2 adds segment _2, keeps _0 and _1
    private CatalogSnapshotManager createManager(
        }
                assertEquals(1, segments.size());
    public void testInitialSnapshotRecovery() throws Exception {
            mock(CommitFileManager.class)
        );
        assertTrue("_1_data.parquet should be deleted", deleted.contains("_1_data.parquet"));
        );
        manager.close();
        assertFalse("_2_data.parquet should NOT be deleted", deleted.contains("_2_data.parquet"));
     * Replica manager with a {@link CommitFileManager} must protect commit-owned files
                Map.of(),
        // Multiple refreshes replace CS1 as latest
        CatalogSnapshotDeletionPolicy policy,
            committed = List.of(initial);
            mock(CommitFileManager.class)
    /**
    }
        expectThrows(IllegalStateException.class, () -> manager.applyReplicationSnapshot(incoming));
        try (CatalogSnapshotManager manager = replicaManager(shardPath, List.of(initial), Map.of("lucene", luceneDeleter), cfm)) {
            0L,
    }
        manager.close();
        } finally {
        ShardPath shardPath = new ShardPath(false, shardRoot, shardRoot, shardId);
                    assertEquals(initialUserData, ref.get().getUserData());
            assertTrue("pre-existing files must not be touched by empty-initial bootstrap", Files.exists(leftover));
        // Acquire committed snapshot (simulating _snapshot API)
     * startup orphan sweep scans only format directories referenced by the seed snapshot.
 * SPDX-License-Identifier: Apache-2.0
        // Refresh CS3: drops _shared
    }
        Segment seg1 = new Segment(1L, Map.of(format.name(), wfs1));
            incoming.setReplicatingCommitData(commitData);
        // gen 2 was fully deleted during the merge and is no longer in the catalog.
            randomUserData(randomIntBetween(0, 4))
        try (GatedConditionalCloseable<CatalogSnapshot> commitRef = manager.acquireSnapshotForCommit()) {
package org.opensearch.index.engine.exec.coord;
                // refCount = 3: manager "latest" + commit ref (from IndexFileDeleter) + reader
                try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
            Map.of(),
        try (GatedConditionalCloseable<CatalogSnapshot> commitRef = manager.acquireSnapshotForCommit()) {
                return fileName.startsWith("segments") || "write.lock".equals(fileName);
        DataFormat format = new MockDataFormat();
    }
            MergeResult mergeResult = new MergeResult(Map.of());
            CatalogSnapshotManager manager = createRandomManager();
import org.opensearch.core.index.Index;
    }
        CatalogSnapshotManager manager = replicaManager(null, List.of(), Map.of(), mock(CommitFileManager.class));
        GatedCloseable<CatalogSnapshot> readerRef = manager.acquireSnapshot();
                assertTrue(snapshot.getUserData().isEmpty());
        List<Segment> segments = new ArrayList<>();
                    failed.forEach((k, v) -> allFailed.computeIfAbsent(k, x -> new java.util.ArrayList<>()).addAll(v));
        String translogUUID = "test-uuid";
            CatalogSnapshotManager manager = createRandomManager();
            long lastWriterGeneration = randomNonNegativeLong();
     */
            // Repeated bumps must keep it non-null at every generation.
            Map<String, String> userData = randomUserData(randomIntBetween(0, 4));
        String translogUUID = "test-uuid";
            files -> Map.of(),
            List.of(cs1),
        try {
            commitUserData(100, 100, translogUUID)
            // The subsequent bump (e.g. a replica flush) must not drop it to null.
                // commit + reader = 2 (manager released its ref)
     * holds the record it selected. The merge must still apply: its output already reflects those
        initial.setLastCommitInfo("segments_1", 1L, 0L);
            commitRef.get().setUserData(commitUserData(200, 200, translogUUID), true);
                // Both source segments replaced by merged segment
            mock(CommitFileManager.class)
            assertEquals(1, finalSnapshot.refCount());
     */
     * A refresh that deletes every document in a source generation drops it outright
            try {
        assertFalse(((DataformatAwareCatalogSnapshot) snapshot).isClosed());
        Segment liveSeg1 = new Segment(1L, Map.of(format.name(), new WriterFileSet("/tmp/dir", 1L, Set.of("a.cfs", "a.liv"), 100, 0L)));
                CatalogSnapshot snapshot = ref.get();
    }
    }
            1L,
    }
     * {@code applyReplicationSnapshot} followed by a generation bump must keep the incoming
                    refs.add(manager.acquireSnapshot());
        DataformatAwareCatalogSnapshot cs1 = new DataformatAwareCatalogSnapshot(0, 0, 1, List.of(seg1, seg2, seg3), 0, Map.of());
                assertEquals(seg3, segments.get(1));
        held.close();
            null,
            commitRef.get().setUserData(commitUserData(100, 100, translogUUID), true);
            expectThrows(IllegalArgumentException.class, () -> manager.applyMergeResults(mergeResult, oneMerge));
            } finally {
                // merged segment replaces at position of first merged segment
            }
import java.util.HashMap;
    public void testClosedManagerRejectsAcquisition() throws Exception {
            List.of(),
                assertTrue(seed.getSegments().isEmpty());
        CatalogSnapshotManager manager = new CatalogSnapshotManager(
        } else {
        }
                assertSame(commitData, latest.getReplicatingCommitData());
                DataformatAwareCatalogSnapshot latest = (DataformatAwareCatalogSnapshot) ref.get();
            List.of(cs1),
        // CS1's files that are NOT in CS2 should be deleted
            Map<String, java.util.Collection<String>> allFailed = new java.util.HashMap<>();
            try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
import org.opensearch.index.seqno.SequenceNumbers;
public class CatalogSnapshotManagerTests extends OpenSearchTestCase {
            mock(CommitFileManager.class)
    public void testApplyMergeResultsWhenAllMergedSegmentsRemoved() throws Exception {
            null,
            manager.close();
            1L,
        }
        }
            List.of(),
                manager.commitNewSnapshot(randomSegments());
            commitRef.markSuccess();
            logger,
        Segment staleSeg1 = new Segment(1L, Map.of(format.name(), new WriterFileSet("/tmp/dir", 1L, Set.of("a.cfs"), 100, 0L)));
    }
        IndexFileDeleterTests.TrackingFileDeleter tracker = new IndexFileDeleterTests.TrackingFileDeleter();
        Path indexDir = shardRoot.resolve("index");
                assertEquals(2, heldSnapshot.refCount());
            previous = ref.get();
        CatalogSnapshotManager manager = new CatalogSnapshotManager(
            for (int c = 0; c < numCommits; c++) {
        try (CatalogSnapshotManager manager = replicaManager(null, List.of(), Map.of(), mock(CommitFileManager.class))) {
            List.of(cs1),
                List<Segment> segments = ref.get().getSegments();
    /**
    }
     */
            mock(CommitFileManager.class)
    }
        WriterFileSet wfs1 = new WriterFileSet("/tmp/dir", 1L, Set.of("a.cfs"), 100, 0L);
        // Flush: CS2 becomes a commit, policy deletes CS1
            commitUserData(100, 100, translogUUID)
        assertEquals(SafeCommitInfo.EMPTY, info);
import java.util.HashSet;
        DataFormat format = new MockDataFormat();
        // Do a refresh so we get a snapshot without a commit ref
            dfGrouped.put(format, randomWriterFileSet(format, numRows));
        DataformatAwareCatalogSnapshot incoming = new DataformatAwareCatalogSnapshot(
        // CS1 deleted → _0_data deleted, but _shared survives (still in CS2)
                    assertEquals(2, prev.refCount());
        CatalogSnapshotManager manager = new CatalogSnapshotManager(
        globalCP.set(200);
        for (int iter = 0; iter < 100; iter++) {
            try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
            mock(CommitFileManager.class)
        }
            manager.close();
            files -> Map.of(),
     * After merge, old pre-merge files are deleted when the commit referencing them is removed.
        );
            assertTrue("write.lock must survive — protected by CommitFileManager", Files.exists(writeLock));
        );
            segment(0, "parquet", "_0_data.parquet", "_0_index.parquet"),
        }, Map.of(), List.of(), shardPath, commitFileManager);
            @Override
        Segment seg2 = new Segment(2L, Map.of(format.name(), wfs2));
        // But all of CS1's files (_0, _1) are also in CS2, so nothing should be deleted
        DataformatAwareCatalogSnapshot cs = new DataformatAwareCatalogSnapshot(0, 0, 1, segments, 0, Map.of());
        CatalogSnapshotManager manager = new CatalogSnapshotManager(
            List.of(segment(0, "parquet", "_0_data.parquet"), segment(1, "parquet", "_shared.parquet")),
            List.of(),
            }
    /**
        for (Path p : List.of(known, orphan, segmentsCommit, writeLock)) {
            }
        try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
     * must carry it forward so the replica's catalog snapshot never loses the primary's replicated
        GatedCloseable<CatalogSnapshot> heldRef = manager.acquireSnapshot();
            segments.add(randomSegment());
        Path shardRoot = createTempDir().resolve(shardId.getIndex().getUUID()).resolve(String.valueOf(shardId.id()));
        assertTrue("_0_data should be deleted after snapshot release", tracker.deletedFiles.contains("_0_data.parquet"));
            new DefaultTranslogDeletionPolicy(-1, -1, 0),
            );
                CatalogSnapshot heldSnapshot = heldRef.get();
            segment(0, "parquet", "_0_data.parquet", "_0_index.parquet"),
                try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
            // 301 > 100 + 200
            policy,
            new DefaultTranslogDeletionPolicy(-1, -1, 0),
    }
        DataformatAwareCatalogSnapshot initial = new DataformatAwareCatalogSnapshot(1L, 1L, 0L, randomSegments(), 1L, Map.of());
        DataformatAwareCatalogSnapshot incoming = new DataformatAwareCatalogSnapshot(1L, 1L, 1L, randomSegments(), 1L, Map.of());
                previous.getGeneration() + 1,
                assertEquals(2, currentSnap.refCount());
        Segment seg1 = new Segment(1L, Map.of(format.name(), new WriterFileSet("/tmp/dir", 1L, Set.of("a.cfs"), 100, 0L)));
        CatalogSnapshotManager manager = new CatalogSnapshotManager(
            globalCP::get
import org.opensearch.index.engine.exec.Segment;
    private CatalogSnapshotManager createManager(List<Segment> segments, Map<String, String> userData) throws IOException {
                assertEquals(Set.of("merged.cfs", "merged.liv"), segments.get(0).dfGroupedSearchableFiles().get(format.name()).files());
        cs1.setLastCommitInfo("segments_1", 1L, 0L);
        }
                    previousGeneration = ref.get().getGeneration();
        try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
            Map.of(),
            CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,
     */
/*
        try {
            }
        );
                manager.close();
        // CS1's commit ref was released by policy, but reader still holds a ref
            }
        Segment seg1 = new Segment(1L, Map.of(format.name(), new WriterFileSet("/tmp/dir", 1L, Set.of("a.cfs"), 100, 0L)));
            commitRef.get().setUserData(commitUserData(200, 200, translogUUID), true);
        // Release the snapshot — triggers revisitPolicy which cleans up
        DataformatAwareCatalogSnapshot cs1 = new DataformatAwareCatalogSnapshot(1L, 1L, 0L, cs1Segments, 1L, userData);
     * Shared files between commits: file only deleted when ALL snapshots referencing it are gone.
        }
            try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
            0L,
import org.opensearch.index.engine.exec.CommitFileManager;
            files -> Map.of(),
            // refCount = 2: manager "latest" + commit ref
        FileDeleter fileDeleter
        );
            segment(1, "parquet", "_1_data.parquet", "_1_index.parquet"),
        CatalogSnapshotManager manager = new CatalogSnapshotManager(
import org.opensearch.test.OpenSearchTestCase;
            manager.applyMergeResults(mergeResult, oneMerge);
     * they are present on disk but not referenced by the initial committed snapshot.
        );
     * generation that already exists as a retained segment must still be rejected. This is what
        String translogUUID = "test-uuid";
            }
    }
            tracker,
                long previousGeneration;
        try (GatedConditionalCloseable<CatalogSnapshot> commitRef = manager.acquireSnapshotForCommit()) {
            } finally {
        Map<String, String> userData = new HashMap<>();
        DataFormat format = new MockDataFormat();
            int numCommits = randomIntBetween(1, 8);
        manager.applyReplicationSnapshot(incoming);
            logger,
            WriterFileSet mergedWfs = new WriterFileSet("/tmp/dir", 10L, Set.of("merged.cfs"), 50, 0L);
        Path orphan = indexDir.resolve("orphan.si");
            new DefaultTranslogDeletionPolicy(-1, -1, 0),
    }
            DataformatAwareCatalogSnapshot incoming = new DataformatAwareCatalogSnapshot(
            files -> Map.of(),
        snapshot.setLastCommitInfo("segments_1", 1L, 0L);
                }
        } finally {
            Files.write(p, new byte[] { 0 });
     * files only deleted after reader releases AND commit is deleted by policy.
                    refs.get(r).close();
        }
    public void testApplyMergeResultsAppliesWhenSourceLiveDocsChangedDuringMerge() throws Exception {
        Map<String, FileDeleter> perFormatDeleters,
                    seenIds.add(ref.get().getId());
        List<Segment> segments,
        cs1.setLastCommitInfo("segments_1", 1L, 0L);
                List.of(),
        manager.commitNewSnapshot(List.of(segment(1, "parquet", "_1_data.parquet")));
        heldRef.close();
    }
            randomNonNegativeLong(),
        String directory = "/tmp/" + randomAlphaOfLength(8);
        CombinedCatalogSnapshotDeletionPolicy policy = new CombinedCatalogSnapshotDeletionPolicy(
            mock(CommitFileManager.class)
                List<GatedCloseable<CatalogSnapshot>> refs = new ArrayList<>();
        try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
        // Do a refresh so we get a snapshot without a commit ref
        }
                randomSegments(),
            // refCount = 1: commit ref still held (no flush happened to trigger deletion policy)
        DataformatAwareCatalogSnapshot initial = new DataformatAwareCatalogSnapshot(1L, 1L, 1L, List.of(seg), 1L, Map.of());
        Object commitData = new Object();
     */
        globalCP.set(200);
            MergeResult mergeResult = new MergeResult(Map.of(format, mergedWfs));
                manager.close();
        manager.close();
        for (int iter = 0; iter < 100; iter++) {
        }
    }
            }
                    try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
            mock(CommitFileManager.class)
import org.opensearch.index.engine.exec.CombinedCatalogSnapshotDeletionPolicy;
    /**
        manager.commitNewSnapshot(List.of(segment(1, "parquet", "_1_data.parquet")));
    }
        );
     * and the caller turned that into a failed engine.
        );
                assertEquals(userData, acquired.getUserData());
                List.of(new DataformatAwareCatalogSnapshot(id, generation, version, segments, lastWriterGeneration, userData)),
            try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
    }
            manager.applyMergeResults(new MergeResult(Map.of(format, mergedWfs)), new OneMerge(List.of(seg1, seg2)));
            }
        cs1.setLastCommitInfo("segments_1", 1L, 0L);
        userData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, Long.toString(localCheckpoint));
                assertTrue(snapshot.getSegments().isEmpty());
            policy,
                manager.commitNewSnapshot(randomSegments());
            try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
        globalCP.set(200);
     * catalog, at the front, which is the pre-existing {@code !inserted} branch.
        SafeCommitInfo info = manager.getSafeCommitInfo();
                // Acquire a new ref, then replace via commitNewSnapshot
                assertEquals(0, prev.refCount());
     * generation reappears as a different {@link Segment} value while the in-flight merge still
                assertEquals("seed must be the empty synthetic snapshot", 0L, seed.getId());
        GatedCloseable<CatalogSnapshot> held = manager.acquireCommittedSnapshot(false);
        // knownFilesByFormat entry, so the scanner won't enumerate <shard>/index/ at all.
        } finally {
                        assertEquals(newSegments, ref.get().getSegments());
            List.of(),
     */
    }
            assertEquals(List.of(3L), generationsOf(manager));
        Segment seg3 = new Segment(3L, Map.of(format.name(), wfs3));
        // close() only sets the closed flag — snapshot stays alive (files must survive for recovery)
        userData.put(Translog.TRANSLOG_UUID_KEY, translogUUID);
        assertFalse(((DataformatAwareCatalogSnapshot) heldSnapshot).isClosed());
        manager.close();
            CatalogSnapshotManager manager = replicaManager(shardPath, List.of(), Map.of("lucene", unused), mock(CommitFileManager.class))
        Segment seg2 = new Segment(2L, Map.of(format.name(), new WriterFileSet("/tmp/dir", 2L, Set.of("b.cfs"), 200, 0L)));
        Map<String, WriterFileSet> dfGrouped = new HashMap<>();
            commitRef.markSuccess();
