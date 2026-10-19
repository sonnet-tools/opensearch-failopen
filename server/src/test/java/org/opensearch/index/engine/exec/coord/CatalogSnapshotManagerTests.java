        for (int iter = 0; iter < 100; iter++) {  
                assertEquals(2, segments.size());
            manager.close();  
     */
    }
                assertEquals(2, currentSnap.refCount());  
        Segment seg1 = new Segment(1L, Map.of(format.name(), new WriterFileSet("/tmp/dir", 1L, Set.of("a.cfs"), 100, 0L)));  
            WriterFileSet mergedWfs = new WriterFileSet("/tmp/dir", 3L, Set.of("merged.cfs"), 1, 0L);
            1L,
                previous = ref.get();
        WriterFileSet mergedWfs = new WriterFileSet("/tmp/dir", 4L, Set.of("merged.cfs", "merged.liv"), 250, 0L);  
            WriterFileSet mergedWfs = new WriterFileSet("/tmp/dir", 4L, Set.of("merged.cfs"), 300, 0L);  
            null,
            int extraBumps = randomIntBetween(1, 10);
        }
            try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {  
     * holds the record it selected. The merge must still apply: its output already reflects those
        WriterFileSet mergedWfs = new WriterFileSet("/tmp/dir", 3L, Set.of("merged.cfs"), 300, 0L);
        globalCP.set(200);  
                initialSnapshot = ref.get();
            List.of(),
        DataformatAwareCatalogSnapshot incoming = new DataformatAwareCatalogSnapshot(
        }  
     * (e.g. {@code segments_N}, {@code write.lock}) from the startup orphan sweep, even when  
     * Once an initial snapshot carries non-null {@code replicatingCommitData}, a generation bump  
        // CS1: segments _0, _1  
            CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,  
                manager.close();
    public void testCreateForReplicaWithEmptyInitialDoesNotTouchDisk() throws Exception {
            mock(CommitFileManager.class)  
            manager.applyMergeResults(new MergeResult(Map.of(format, mergedWfs)), new OneMerge(List.of(seg1, seg2)));
        try {
    public void testGetSafeCommitInfoDelegatesToPolicy() throws IOException {
            1L,
        try (  
    public void testCloseInternalInvokedOnCommit() throws Exception {  
            }
        assertEquals(SafeCommitInfo.EMPTY, info);
            globalCP::get  
            files -> Map.of(),  
    }  
                List<Segment> segments = ref.get().getSegments();
            public void deleteCommit(CatalogSnapshot snapshot) {}
            1L,
        Segment seg2 = new Segment(2L, Map.of(format.name(), new WriterFileSet("/tmp/dir", 2L, Set.of("b.cfs"), 200, 0L)));
    public void testApplyMergeResultsWhenAllMergedSegmentsRemoved() throws Exception {
                randomNonNegativeLong(),  
        manager.close();
    }
        );
            assertEquals("snapshot untouched", List.of(1L, 2L), generationsOf(manager));  
        DataformatAwareCatalogSnapshot cs1 = new DataformatAwareCatalogSnapshot(
        manager.close();  
                }
        FileDeleter fileDeleter
            mock(CommitFileManager.class)
        AtomicLong globalCP = new AtomicLong(100);
                    prev = ref.get();
            manager.close();  
import org.opensearch.index.engine.exec.CatalogSnapshotDeletionPolicy;
    }  
        DataformatAwareCatalogSnapshot incoming = new DataformatAwareCatalogSnapshot(1L, 1L, 1L, randomSegments(), 1L, Map.of());
            public boolean isCommitManagedFile(String fileName) {
            globalCP::get  
        };
            policy,  
        Segment seg3 = new Segment(3L, Map.of(format.name(), new WriterFileSet("/tmp/dir", 3L, Set.of("c.cfs"), 300, 0L)));
        DataFormat format = new MockDataFormat();  
        manager.close();
        manager.commitNewSnapshot(randomSegments());  
                // unmerged segment preserved  
            long lastWriterGeneration = randomNonNegativeLong();
            committed = List.of(initial);
                assertEquals(id, acquired.getId());
            try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {  
        IndexFileDeleterTests.TrackingFileDeleter tracker = new IndexFileDeleterTests.TrackingFileDeleter();  
            logger,
                CatalogSnapshot currentSnap;
                // merged segment replaces at position of first merged segment  
        Segment seg1 = new Segment(1L, Map.of(format.name(), new WriterFileSet("/tmp/dir", 1L, Set.of("a.cfs"), 100, 0L)));  
    public void testApplyMergeResultsThrowsWhenMergedGenerationCollidesWithRetained() throws Exception {  
                assertEquals(seg3, segments.get(1));
                return fileName.startsWith("segments") || "write.lock".equals(fileName);  
            commitRef.get().setUserData(commitUserData(300, 300, translogUUID), true);  
        try (CatalogSnapshotManager manager = replicaManager(shardPath, List.of(initial), Map.of("lucene", luceneDeleter), cfm)) {  
import org.opensearch.core.index.Index;  
                assertEquals(lastWriterGeneration, acquired.getLastWriterGeneration());
 * Tests for {@link CatalogSnapshotManager}.
        globalCP.set(300);
        return new Segment(randomNonNegativeLong(), dfGrouped);  
    }
        } catch (IOException e) {  
    private CatalogSnapshotManager createManager(  
            new DefaultTranslogDeletionPolicy(-1, -1, 0),  
    }
    }  
            CatalogSnapshot previous;
            CatalogSnapshotManager manager = replicaManager(shardPath, List.of(), Map.of("lucene", unused), mock(CommitFileManager.class))
                    assertEquals(initialUserData, ref.get().getUserData());
        );
     */
        // Do a refresh so we get a snapshot without a commit ref  
            Object commitData = new Object();
     * catalog, at the front, which is the pre-existing {@code !inserted} branch.
        List<Segment> segments = new ArrayList<>();
        assertTrue("_shared should be deleted after CS2 commit removed", tracker.deletedFiles.contains("_shared.parquet"));
    public void testAcquireAndReleaseViaGatedCloseable() throws Exception {
            @Override
        // But all of CS1's files (_0, _1) are also in CS2, so nothing should be deleted
        WriterFileSet wfs = new WriterFileSet(indexDir.toString(), 1L, Set.of("known.si"), 0, 0L);
            segment(0, "parquet", "_0_data.parquet", "_0_index.parquet"),
                        assertTrue(seenIds.add(ref.get().getId()));
        Segment liveSeg1 = new Segment(1L, Map.of(format.name(), new WriterFileSet("/tmp/dir", 1L, Set.of("a.cfs", "a.liv"), 100, 0L)));  
        assertTrue("_0_data should be deleted after snapshot release", tracker.deletedFiles.contains("_0_data.parquet"));
        CatalogSnapshotManager manager = createRandomManager();
        } finally {
            DataformatAwareCatalogSnapshot incoming = new DataformatAwareCatalogSnapshot(
        CommitFileManager commitFileManager  
        CatalogSnapshotManager manager = new CatalogSnapshotManager(
        CatalogSnapshotManager manager = createRandomManager();  
            Map.of(),
            logger,
     */
        // Flush: CS2 becomes a commit, policy deletes CS1
        manager.commitNewSnapshot(List.of(segment(1, "parquet", "_shared.parquet"), segment(2, "parquet", "_2_data.parquet")));
        Segment seg2 = new Segment(2L, Map.of(format.name(), new WriterFileSet("/tmp/dir", 2L, Set.of("b.cfs"), 200, 0L)));
            );
        heldRef.close();
        );
            manager.applyMergeResults(new MergeResult(Map.of(format, mergedWfs)), new OneMerge(List.of(seg1, seg2)));  
            // refCount = 2: manager "latest" + commit ref
            Map<String, String> userData = randomUserData(randomIntBetween(0, 4));  
        }
            List.of(cs1),  
            0L,
            logger,
                CatalogSnapshot prev;
        DataFormat format = new MockDataFormat();
     * old committed snapshot's files are deleted when policy removes it.  
        Segment seg1 = new Segment(1L, Map.of(format.name(), new WriterFileSet("/tmp/dir", 1L, Set.of("a.cfs"), 100, 0L)));
            }
                    try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
        manager.commitNewSnapshot(List.of(segment(1, "parquet", "_1_data.parquet")));  
            CatalogSnapshotManager manager = createRandomManager();  
            String format = randomFrom("lucene", "parquet");  
     * Genuine invariant violation: re-applying a merge would duplicate its output, so a merged
                // Both source segments replaced by merged segment  
        for (int iter = 0; iter < 100; iter++) {
        CatalogSnapshotManager manager = new CatalogSnapshotManager(  
    /**
                    // refCount = 2: manager "latest" + reader (no commit ref on refresh-created snapshots)
            null,
                    throw new RuntimeException(e);  
        Path shardRoot = createTempDir().resolve(shardId.getIndex().getUUID()).resolve(String.valueOf(shardId.id()));  
            // set userData on the snapshot for the policy to read
        }
                assertEquals(segments, acquired.getSegments());  
     * SegmentInfos.
                assertEquals(2, finalSnapshot.refCount());
            WriterFileSet mergedWfs = new WriterFileSet("/tmp/dir", 10L, Set.of("merged.cfs"), 50, 0L);
            CatalogSnapshotManager manager = createRandomManager();  
    private Map<String, String> randomUserData(int entries) {
        AtomicLong globalCP = new AtomicLong(100);
        );
                manager.close();
        Path shardRoot = createTempDir().resolve(shardId.getIndex().getUUID()).resolve(String.valueOf(shardId.id()));
                List.of(new DataformatAwareCatalogSnapshot(id, generation, version, segments, lastWriterGeneration, userData)),  
        Map<String, WriterFileSet> dfGrouped = new HashMap<>();  
            manager.commitNewSnapshot(randomSegments());
    }  
            @Override
        assertTrue("snapshot should be closed after the last ref is released", ((DataformatAwareCatalogSnapshot) heldSnapshot).isClosed());  
                    assertEquals(2, prev.refCount());  
                // manager + commit + reader = 3
    public void testClosedManagerRejectsAcquisition() throws Exception {  
        manager.close();
            files -> Map.of(),
                assertNotNull("replicatingCommitData must survive the post-replication bump", latest.getReplicatingCommitData());
        // Refresh: CS2 adds segment _2, keeps _0 and _1
                randomNonNegativeLong(),
                }
        Segment seg2 = new Segment(2L, Map.of(format.name(), new WriterFileSet("/tmp/dir", 2L, Set.of("b.cfs"), 200, 0L)));
            1L,  
            files.add(randomAlphaOfLength(6) + "." + randomFrom(extensions));  
            manager.applyMergeResults(mergeResult, oneMerge);
    }
    }
            manager.close();
            logger,
                Map.of()
        }
        String translogUUID = "test-uuid";
        DataFormat format = new MockDataFormat();
            Map.of("local_checkpoint", "50", "max_seq_no", "100", "translog_uuid", "test-uuid")
            Map.of(),
        );
            0L,
        // Refresh: merge _0+_1 into _2, add new _3
    private static Segment segment(long gen, String format, String... files) {
        CatalogSnapshotManager manager = new CatalogSnapshotManager(
        );
     */  
    public void testCreateForReplicaProducesEmptySnapshot() throws Exception {
                GatedCloseable<CatalogSnapshot> heldRef = manager.acquireSnapshot();  
            Map.of(),  
        Segment seg3 = new Segment(3L, Map.of(format.name(), wfs3));
     * sources are replaced and the merged output installed.
                mock(CommitFileManager.class)  
            expectThrows(IllegalArgumentException.class, () -> manager.applyMergeResults(mergeResult, oneMerge));
        CombinedCatalogSnapshotDeletionPolicy policy = new CombinedCatalogSnapshotDeletionPolicy(  
            mock(CommitFileManager.class)
    public void testApplyMergeResultsThrowsWhenMergedRowCountExceedsSources() throws Exception {
            for (int i = 0; i < extraBumps; i++) {  
     * than it read, so an inflated output must still be rejected.
import org.opensearch.index.engine.dataformat.DataFormat;  
 */
            }
        }  
        DataformatAwareCatalogSnapshot cs = new DataformatAwareCatalogSnapshot(0, 0, 1, segments, 0, Map.of());
            manager.close();
        CombinedCatalogSnapshotDeletionPolicy policy = new CombinedCatalogSnapshotDeletionPolicy(  
        );
            return ref.get().getSegments().stream().map(Segment::generation).sorted().collect(java.util.stream.Collectors.toList());
        Path segmentsCommit = indexDir.resolve("segments_7");
            manager.close();
            null,  
        return new Segment(gen, Map.of(format, wfs));
        cs1.setLastCommitInfo("segments_1", 1L, 0L);
            List.of(initial),
        }
        assertFalse("_3_data.parquet should NOT be deleted", deleted.contains("_3_data.parquet"));
            segment(1, "parquet", "_1_data.parquet", "_1_index.parquet")
                assertEquals(generation, acquired.getGeneration());
                files -> Map.of(),
        }  
            } finally {  
            }
            List.of(cs1),
            }
    public void testApplyMergeResultsAppliesWhenMergedRowCountIsLower() throws Exception {
        );
            List.of(cs1),
        String translogUUID = "test-uuid";
        // CS1: _0 and _1
            initial.setLastCommitInfo("segments_1", 1L, 0L);  
        }
        manager.commitNewSnapshot(List.of(segment(2, "parquet", "_2_data.parquet")));
                assertEquals(0L, snapshot.getGeneration());  
            Map<String, java.util.Collection<String>> allFailed = new java.util.HashMap<>();  
        );  
            return allFailed;  
        CatalogSnapshotManager manager = new CatalogSnapshotManager(  
        String[] extensions = "lucene".equals(format) ? new String[] { "cfs", "si", "dat" } : new String[] { "parquet" };
                0L,  
     *
            List.of(),  
        manager.commitNewSnapshot(randomSegments());
     * {@code applyReplicationSnapshot} followed by a generation bump must keep the incoming
        Path leftover = indexDir.resolve("leftover.si");
                    DataformatAwareCatalogSnapshot latest = (DataformatAwareCatalogSnapshot) ref.get();  
            try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
     */  
                        previousGeneration = ref.get().getGeneration();  
        CatalogSnapshotManager manager = new CatalogSnapshotManager(  
    public void testReaderHoldsSnapshotAliveAcrossRefreshes() throws Exception {
        Set<String> deleted = tracker.deletedFiles;
        for (int i = 0; i < randomIntBetween(0, 5); i++) {
        }
    public void testReplicationSnapshotThenBumpPreservesReplicatingCommitData() throws Exception {
    /**  
            assertEquals(2, initialSnapshot.refCount());  
        );  
            }
            );
        } finally {
            try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {  
    }
        );
        DataformatAwareCatalogSnapshot cs1 = new DataformatAwareCatalogSnapshot(  
            }
        FileDeleter unused = filesByFormat -> Map.of();
        WriterFileSet wfs1 = new WriterFileSet("/tmp/dir", 1L, Set.of("a.cfs"), 100, 0L);  
                assertEquals(1, segments.size());
                    Map<String, java.util.Collection<String>> failed = deleter.deleteFiles(filesToDelete);  
                assertEquals(Set.of("merged.cfs"), segments.get(0).dfGroupedSearchableFiles().get(format.name()).files());
            DataformatAwareCatalogSnapshot initial = (DataformatAwareCatalogSnapshot) CatalogSnapshotManager.createInitialSnapshot(
        manager.close();  
            IllegalStateException e = expectThrows(
        for (int iter = 0; iter < 100; iter++) {
                manager.commitNewSnapshot(randomSegments());
        assertTrue("_0_data should be deleted after reader releases", tracker.deletedFiles.contains("_0_data.parquet"));  
            manager.applyMergeResults(new MergeResult(Map.of(format, mergedWfs)), new OneMerge(List.of(staleSeg1, seg2)));  
        try (GatedConditionalCloseable<CatalogSnapshot> commitRef = manager.acquireSnapshotForCommit()) {
        GatedCloseable<CatalogSnapshot> held = manager.acquireCommittedSnapshot(false);  
        // close() only sets the closed flag — snapshot stays alive (files must survive for recovery)  
                // Initial snapshot has commit ref, so: manager + commit + reader = 3  
            long generation = randomIntBetween(0, 100);
                manager.commitNewSnapshot(randomSegments());
            globalCP::get
        assertTrue(
            mock(CommitFileManager.class)
        Segment seg1 = new Segment(1L, Map.of(format.name(), new WriterFileSet("/tmp/dir", 1L, Set.of("a.cfs"), 100, 0L)));
                        assertEquals(newSegments, ref.get().getSegments());
    private Segment randomSegment() {
        DataFormat format = new MockDataFormat();
                }
import org.opensearch.index.engine.SafeCommitInfo;
                    assertNotNull("replicatingCommitData must remain non-null after repeated bumps", latest.getReplicatingCommitData());
    }
                    manager.commitNewSnapshot(newSegments);  
        } finally {  
        return new CatalogSnapshotManager(List.of(snapshot), policy, fileDeleter, Map.of(), List.of(), null, mock(CommitFileManager.class));
        Segment seg2 = new Segment(2L, Map.of(format.name(), new WriterFileSet("/tmp/dir", 2L, Set.of("b.cfs"), 200, 0L)));  
        );
        try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {  
            globalCP::get  
        // Flush CS2
     * A refresh that deletes every document in a source generation drops it outright
        CatalogSnapshotManager manager = managerOver(List.of(seg1, seg2));  
            // refCount = 1: commit ref still held (no flush happened to trigger deletion policy)  
            List<Segment> segments = randomIntBetween(1, 5) == 1 ? Collections.emptyList() : randomSegments();
            Map.of(),
        FileDeleter luceneDeleter = filesByFormat -> {
            assertEquals("latest should have incoming's segments", incoming.getSegments(), latest.getSegments());
                0L,
                DataformatAwareCatalogSnapshot latest = (DataformatAwareCatalogSnapshot) ref.get();
            List.of(),  
        }
            Map.of(),  
        List<CatalogSnapshot> initialCommittedSnapshots,
                // The untouched segment keeps its current record.
            null,  
        Map<String, FileDeleter> perFormatDeleters,
        // CS1 deleted by policy → _0_data and _1_data should be deleted (not in CS2)  
        );  
        return new CatalogSnapshotManager(committed, CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY, filesToDelete -> {
    private CatalogSnapshotManager createRandomManager() {  
import org.opensearch.index.engine.dataformat.merge.OneMerge;
            manager.close();  
            commitUserData(100, 100, translogUUID)  
        assertFalse("_2_data.parquet should NOT be deleted", deleted.contains("_2_data.parquet"));
            0L,
                List<GatedCloseable<CatalogSnapshot>> refs = new ArrayList<>();  
     * Every source generation dropped during the merge. The merged segment still has to land in the
        expectThrows(IllegalStateException.class, () -> manager.applyReplicationSnapshot(incoming));
            null,
        cs1.setLastCommitInfo("segments_1", 1L, 0L);  
        ShardPath shardPath = new ShardPath(false, shardRoot, shardRoot, shardId);
    }
        String translogUUID = "test-uuid";
            commitRef.markSuccess();  
        manager.commitNewSnapshot(randomSegments());  
                previous.getGeneration() + 1,
            Map.of(),
import java.util.ArrayList;
    }  
            List.of(cs),
            for (int c = 0; c < randomIntBetween(0, 5); c++) {  
            List.of(segment(0, "parquet", "_0_data.parquet"), segment(1, "parquet", "_shared.parquet")),  
            CatalogSnapshotManager manager = new CatalogSnapshotManager(
    public void testCloseInternalNotInvokedWhileRefsHeld() throws Exception {
            WriterFileSet mergedWfs = new WriterFileSet("/tmp/dir", 3L, Set.of("merged.cfs"), 301, 0L);  
import org.opensearch.index.engine.exec.WriterFileSet;  
        for (int iter = 0; iter < 100; iter++) {
            assertEquals(1, initialSnapshot.refCount());
            }
        assertFalse(((DataformatAwareCatalogSnapshot) refreshedSnapshot).isClosed());
            cs1Segments,
            MergeResult mergeResult = new MergeResult(Map.of(format, mergedWfs));
import java.util.HashMap;  
     * Snapshot protection: a held snapshot prevents file deletion even after a new commit.
    }
            }
                assertEquals(userData, acquired.getUserData());
            List.of(),
    public void testApplyMergeResultsWithEmptyWriterFileSetMapThrows() throws Exception {
            return createManager(randomSegments(), Map.of());
        userData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, Long.toString(localCheckpoint));  
            segment(0, "parquet", "_0_data.parquet", "_0_index.parquet"),  
        }
    /**
        assertTrue(tracker.deletedFiles.isEmpty());
        WriterFileSet wfs1 = new WriterFileSet("/tmp/dir", 1L, Set.of("a.cfs"), 100, 0L);
        DataformatAwareCatalogSnapshot snapshot = new DataformatAwareCatalogSnapshot(1L, 1L, 0L, segments, 1L, userData);  
            new DefaultTranslogDeletionPolicy(-1, -1, 0),
                assertEquals(4L, segments.get(0).generation());
        try {
            assertEquals("latest should have incoming's version", incoming.getVersion(), latest.getVersion());
                null,
        DataformatAwareCatalogSnapshot cs1 = new DataformatAwareCatalogSnapshot(0, 0, 1, List.of(seg1, seg2, seg3), 0, Map.of());
        IndexFileDeleterTests.TrackingFileDeleter tracker = new IndexFileDeleterTests.TrackingFileDeleter();
 * The OpenSearch Contributors require contributions made to  
            Files.write(p, new byte[] { 0 });
        initial.setLastCommitInfo("segments_1", 1L, 0L);
        assertTrue("No files should be deleted since CS2 shares all files with CS1", tracker.deletedFiles.isEmpty());
            List.of(cs1),
        assertFalse("_shared should NOT be deleted (still in CS2)", deleted.contains("_shared.parquet"));
        CatalogSnapshotManager manager = managerOver(List.of(seg1, seg2, seg4));
        Map<String, String> userData = commitUserData(100, 100, translogUUID);  
                }
    }  
        // Flush CS1 so it's a proper commit
     */  
    }  
        try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
            segments.add(randomSegment());  
        manager.close();
        CatalogSnapshot refreshedSnapshot;  
import static org.mockito.Mockito.mock;
            try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
            segment(1, "parquet", "_1_data.parquet", "_1_index.parquet"),
                CatalogSnapshot seed = ref.get();
            commitRef.markSuccess();
        manager.close();
                        assertEquals(previousGeneration + 1, ref.get().getGeneration());  
        try (GatedConditionalCloseable<CatalogSnapshot> commitRef = manager.acquireSnapshotForCommit()) {
        Segment seg4 = new Segment(4L, Map.of(format.name(), new WriterFileSet("/tmp/dir", 4L, Set.of("d.cfs"), 400, 0L)));
    /**
        Path known = indexDir.resolve("known.si");
            Map.of(),
            }
            1L,
        }
            null,
        }  
        }
    private static Map<String, String> commitUserData(long maxSeqNo, long localCheckpoint, String translogUUID) {  
            userData.put(randomAlphaOfLength(5), randomAlphaOfLength(10));
    private List<Segment> randomSegments() {  
            1L,  
        manager.close();
        globalCP.set(200);
            );  
        WriterFileSet wfs2 = new WriterFileSet("/tmp/dir", 2L, Set.of("b.cfs"), 200, 0L);
        }  
            assertEquals(1, finalSnapshot.refCount());  
            try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {  
            previous = ref.get();
            randomNonNegativeLong(),  
    }  
                -1L,  
        DataFormat format = new MockDataFormat();
            CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,
        ) {
        // Refresh CS2: keeps _shared, replaces _0 with _2  
            tracker,
        }
        assertFalse("_0_data should not be deleted while snapshot is held", tracker.deletedFiles.contains("_0_data.parquet"));
        );
            commitRef.markSuccess();  
        manager.commitNewSnapshot(randomSegments());
     * ({@code RefreshResult.droppedGenerations}). The merge must still apply: the remaining  
            int numCommits = randomIntBetween(1, 8);  
     */
        Files.write(leftover, new byte[] { 0 });
        // Flush CS2
            assertEquals("latest should have incoming's userData", incoming.getUserData(), latest.getUserData());  
        CatalogSnapshotManager manager = new CatalogSnapshotManager(
        );  
                assertEquals(3, initialSnapshot.refCount());  
    /**
    }
                assertSame(commitData, latest.getReplicatingCommitData());
        for (int i = 0; i < randomIntBetween(1, 2); i++) {
        try {
        try {  
        );  
    }
        List<Segment> cs1Segments = List.of(segment(0, "parquet", "_0_data.parquet"), segment(1, "parquet", "_1_data.parquet"));
        // CS1's commit ref was released by policy, but reader still holds a ref
        CombinedCatalogSnapshotDeletionPolicy policy = new CombinedCatalogSnapshotDeletionPolicy(
            long version = randomNonNegativeLong();  
        // Flush latest  
    }
            CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,
            new DefaultTranslogDeletionPolicy(-1, -1, 0),
import org.opensearch.index.seqno.SequenceNumbers;
        try (GatedConditionalCloseable<CatalogSnapshot> commitRef = manager.acquireSnapshotForCommit()) {
        }
import org.opensearch.index.engine.dataformat.MergeResult;
    ) throws IOException {
            0L,  
import java.io.IOException;
        WriterFileSet wfs1 = new WriterFileSet("/tmp/dir", 1L, Set.of("a.cfs"), 100, 0L);
        // Neither source survives in the catalog.
        assertEquals(0, info.docCount);
        // Multiple refreshes replace CS1 as latest
                assertEquals(1, prev.refCount());
            try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {  
    /**
        }
        };
                assertEquals(4L, segments.get(0).generation());  
        }  
            1L,
        globalCP.set(200);
            commitUserData(100, 100, translogUUID)
        // What the merge selected, before any delete landed.
     * Fewer rows out than in is legitimate — that is compaction dropping deleted rows — so it must
        Map<String, String> userData = new HashMap<>();
        List<CatalogSnapshot> committed;
                List<Segment> segments = ref.get().getSegments();
        assertFalse("_0_data should not be deleted while reader holds ref", tracker.deletedFiles.contains("_0_data.parquet"));  
        // CS1: initial committed snapshot with segments _0, _1
        assertTrue("_0_data should be deleted", deleted.contains("_0_data.parquet"));  
            manager.close();  
            }
                heldRef.close();  
            manager.bumpGeneration();
        snapshot.setLastCommitInfo("segments_1", 1L, 0L);
            manager.bumpGeneration();  
    /**  
        }
            manager.applyMergeResults(new MergeResult(Map.of(format, mergedWfs)), new OneMerge(List.of(seg1, seg2)));
     * A refresh applying deletes rewrites an existing generation's live-docs file, so that  
                Files.deleteIfExists(indexDir.resolve(f));
        Segment seg1 = new Segment(1L, Map.of(format.name(), wfs1));  
            randomUserData(randomIntBetween(0, 4))
        // Refresh: CS2 with different files
                manager.commitNewSnapshot(randomSegments());
        WriterFileSet wfs2 = new WriterFileSet("/tmp/dir", 2L, Set.of("b.cfs"), 200, 0L);
            CatalogSnapshotManager manager = createManager(randomSegments(), initialUserData);
                    assertSame(commitData, latest.getReplicatingCommitData());
        List<Segment> cs2Segments = List.of(  
            List.of(cs1),
            List.of(cs1),
        manager.commitNewSnapshot(randomSegments());
            1L,
        for (Path p : List.of(known, orphan, segmentsCommit, writeLock)) {  
            // A single bump must carry the data forward by identity.
            null,  
                List<Segment> segments = ref.get().getSegments();
            long initGen = randomIntBetween(0, 100);
        );
        );  
        } finally {
            mock(CommitFileManager.class)
            assertEquals("surviving source removed, merged installed", List.of(3L, 4L), generationsOf(manager));  
        CatalogSnapshotManager manager = replicaManager(null, List.of(), Map.of(), mock(CommitFileManager.class));  
        CatalogSnapshotManager manager = new CatalogSnapshotManager(
import org.opensearch.index.shard.ShardPath;
    private WriterFileSet randomWriterFileSet(String format, long numRows) {  
    }
        AtomicLong globalCP = new AtomicLong(100);
            CatalogSnapshotManager manager = createManager(randomSegments(), Collections.emptyMap());  
            refreshedSnapshot = ref.get();
        for (int iter = 0; iter < 100; iter++) {
     * deletes, because Lucene's {@code commitMerge} carries them onto the merged segment.  
        WriterFileSet mergedWfs = new WriterFileSet("/tmp/dir", 4L, Set.of("merged.cfs"), 300, 0L);
            }
                // commit + reader = 2 (manager released its ref)  
     * a usable manager seeded with an empty snapshot. On-disk files are left alone because the
            assertTrue("known.si must survive — referenced by catalog", Files.exists(known));
            throw new AssertionError("unreachable", e);
     * Genuine invariant violation: a merge may drop rows (deletes) but can never produce more rows
            List.of(),  
        assertFalse(((DataformatAwareCatalogSnapshot) heldSnapshot).isClosed());  
        }
        }  
    public void testReferenceCountingLifecycle() throws Exception {  
                int numCommits = randomIntBetween(1, 10);  
    public void testUserDataPreservationOnCommit() throws Exception {  
                assertEquals(2, currentSnap.refCount());  
            logger,
            mock(CommitFileManager.class)  
            try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {  
                assertEquals(3, heldSnapshot.refCount());  
    private static CatalogSnapshotManager replicaManager(
            1L,  
        for (int i = 0; i < fileCount; i++) {
        ShardPath shardPath,  
        }  
        CatalogSnapshotDeletionPolicy policy,  
            try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {  
        // Refresh CS3: drops _shared  
                List.of(),
        );  
    public void testApplyMergeResultsAppliesWhenAllSourceGenerationsWereDropped() throws Exception {
        DataformatAwareCatalogSnapshot cs1 = new DataformatAwareCatalogSnapshot(0, 0, 1, List.of(seg1), 0, Map.of());
        // Flush CS2  
        }
        manager.close();
        // Now CS1 refCount hits 0 → removeFileReferences → _0_data deleted
            commitUserData(100, 100, translogUUID)
    }
            try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
                randomUserData(randomIntBetween(0, 4))
        readerRef.close();  
        assertFalse("snapshot should not be closed while a ref is still held", ((DataformatAwareCatalogSnapshot) heldSnapshot).isClosed());  
        IndexFileDeleterTests.TrackingFileDeleter tracker = new IndexFileDeleterTests.TrackingFileDeleter();
            assertTrue("must report the row mismatch, got: " + e.getMessage(), e.getMessage().contains("row count mismatch"));
     */  
public class CatalogSnapshotManagerTests extends OpenSearchTestCase {  
        Segment seg = new Segment(1L, Map.of("lucene", wfs));  
    private CatalogSnapshotManager managerOver(List<Segment> segments) throws IOException {  
            List.of(),  
    }  
        cs.setLastCommitInfo("segments_1", 1L, 0L);
            commitUserData(100, 100, translogUUID)
            globalCP::get
                assertEquals("seed must be the empty synthetic snapshot", 0L, seed.getId());
        CatalogSnapshot previous;  
        CatalogSnapshotManager manager = managerOver(List.of(seg9));
    }  
            List.of(snapshot),  
        // Acquire committed snapshot (simulating _snapshot API)
            0L,
     * apply rather than trip the conservation check.
    public void testApplyReplicationSnapshotReplacesAndReleasesPrevious() throws Exception {
                try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
            tracker,
        CommitFileManager cfm = new CommitFileManager() {  
                finalSnapshot = ref.get();  
     */  
        DataFormat format = new MockDataFormat();
            "snapshot should be closed when commit replaces the last ref",
            List.of(cs1),
        globalCP.set(200);  
        CatalogSnapshot heldSnapshot = heldRef.get();
        }
        // CS1 deleted → _0_data deleted, but _shared survives (still in CS2)
        DataFormat format = new MockDataFormat();  
        String translogUUID = "test-uuid";
            tracker,  
        Object commitData = new Object();
     * and the caller turned that into a failed engine.  
    public void testInitialSnapshotRecovery() throws Exception {
            } finally {  
            for (String f : filesByFormat.getOrDefault("lucene", List.of())) {  
                assertTrue(snapshot.getSegments().isEmpty());
            );
            Map.of(),
            assertEquals("snapshot untouched", List.of(1L, 2L, 4L), generationsOf(manager));  
        } finally {
            Map<String, String> initialUserData = randomUserData(randomIntBetween(1, 5));
                    List<Segment> newSegments = randomSegments();
    }  
        } finally {
        }
    }
import org.opensearch.common.concurrent.GatedConditionalCloseable;
        cs1.setLastCommitInfo("segments_1", 1L, 0L);
            commitRef.get().setUserData(commitUserData(200, 200, translogUUID), true);
    public void testCreateForReplicaWithCommitFileManagerProtectsCommitFiles() throws Exception {  
            files -> Map.of(),
                assertEquals(seg3, segments.get(1));  
        }
        // Now _0_data should be deleted  
            }
package org.opensearch.index.engine.exec.coord;
    /**  
        CatalogSnapshotManager manager = managerOver(List.of(seg1, seg3));
        WriterFileSet wfs3 = new WriterFileSet("/tmp/dir", 3L, Set.of("c.cfs"), 300, 0L);  
        // Do a refresh so we get a snapshot without a commit ref
            OneMerge oneMerge = new OneMerge(List.of(seg1));
                assertEquals(Set.of("merged.cfs", "merged.liv"), segments.get(0).dfGroupedSearchableFiles().get(format.name()).files());
     * they are present on disk but not referenced by the initial committed snapshot.
            WriterFileSet mergedWfs = new WriterFileSet("/tmp/dir", 4L, Set.of("merged.cfs"), 150, 0L);  
import java.util.List;
                manager.commitNewSnapshot(randomSegments());  
            }
                CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,
        Segment seg1 = new Segment(1L, Map.of(format.name(), new WriterFileSet("/tmp/dir", 1L, Set.of("a.cfs"), 100, 0L)));  
            CatalogSnapshot finalSnapshot;
            tracker,
            }
    }  
            null,
    }
        Set<String> files = new HashSet<>();  
            // The subsequent bump (e.g. a replica flush) must not drop it to null.
        DataformatAwareCatalogSnapshot cs1 = new DataformatAwareCatalogSnapshot(1L, 1L, 0L, cs1Segments, 1L, userData);
                try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
        // Plant a file in <shard>/index/ — there is no snapshot referencing it and no prior
            mock(CommitFileManager.class)
    }
        String translogUUID = "test-uuid";
            mock(CommitFileManager.class)
    public void testCommitProducesCorrectNewSnapshot() throws Exception {
                    assertEquals(initialUserData, ref.get().getUserData());
            for (int c = 0; c < numCommits; c++) {
    }  
            tracker,
            }
        Path orphan = indexDir.resolve("orphan.si");  
import org.opensearch.index.engine.exec.FileDeleter;
        String directory = "/tmp/" + randomAlphaOfLength(8);
        assertEquals(50L, info.localCheckpoint);  
            1L,
            policy,  
     * guards against double-apply now that source presence is no longer required.
        initial.setReplicatingCommitData(commitData);
            previous.getGeneration() + 1,
        // CS1: segment _0  
                assertNotNull("replicatingCommitData must survive a generation bump", latest.getReplicatingCommitData());  
                assertEquals(0L, seed.getGeneration());  
}
            try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
            MergeResult mergeResult = new MergeResult(Map.of(format, mergedWfs));
        }
        assertFalse(((DataformatAwareCatalogSnapshot) snapshot).isClosed());  
 * this file be licensed under the Apache-2.0 license or a
            policy,
    /**
            } finally {  
            files -> Map.of(),  
                // Merged segment takes the position of the first removed source, carrying its .liv.
        CatalogSnapshotManager manager = replicaManager(null, List.of(), Map.of(), mock(CommitFileManager.class));
            new DefaultTranslogDeletionPolicy(-1, -1, 0),
            }
        Segment seg2 = new Segment(2L, Map.of(format.name(), new WriterFileSet("/tmp/dir", 2L, Set.of("b.cfs"), 200, 0L)));  
        Map<String, String> userData = new HashMap<>();  
        try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {  
     * Replica manager with an empty {@code initialCommittedSnapshots} must still produce  
        long numRows = randomIntBetween(1, 10000);
        // CS1: segment _0  
                randomSegments(),  
    }
        Segment seg1 = new Segment(1L, Map.of(format.name(), wfs1));
                // commit = 1 (reader released, commit ref still held — no flush to trigger policy)
        IndexFileDeleterTests.TrackingFileDeleter tracker = new IndexFileDeleterTests.TrackingFileDeleter();
                    refs.add(manager.acquireSnapshot());
                    assertEquals(2 + numAcquires - r - 1, currentSnap.refCount());
                randomNonNegativeLong(),
                // Acquire a new ref, then replace via commitNewSnapshot
                assertNotNull("replicatingCommitData must be copied from the incoming snapshot", latest.getReplicatingCommitData());  
        manager.close();  
     */  
            policy,
    }  
        }
            commitRef.get().setUserData(commitUserData(200, 200, translogUUID), true);
        List<Segment> cs2Segments = List.of(segment(2, "parquet", "_2_data.parquet"), segment(3, "parquet", "_3_data.parquet"));
        } finally {
                DataformatAwareCatalogSnapshot latest = (DataformatAwareCatalogSnapshot) ref.get();
                assertEquals("prepended at the front", 10L, ref.get().getSegments().get(0).generation());  
        try {
        }
    }
        manager.commitNewSnapshot(List.of(segment(3, "parquet", "_3_data.parquet")));
            null,
        return new WriterFileSet(directory, randomNonNegativeLong(), files, numRows, 0L);
    public void testMergedFilesDeletedAfterCommit() throws Exception {
            snapshot = ref.get();
            // Repeated bumps must keep it non-null at every generation.
                    }
import org.opensearch.index.engine.exec.CommitFileManager;  
import java.util.Set;
        ShardPath shardPath = new ShardPath(false, shardRoot, shardRoot, shardId);  
        } finally {  
            manager.close();
        }
import java.util.HashSet;
                assertEquals(Set.of("merged.cfs"), segments.get(0).dfGroupedSearchableFiles().get(format.name()).files());  
            assertTrue("must name the collision, got: " + e.getMessage(), e.getMessage().contains("collides with a retained segment"));
        int fileCount = randomIntBetween(1, 5);
        assertTrue("_0_data.parquet should be deleted", deleted.contains("_0_data.parquet"));
                assertSame(commitData, latest.getReplicatingCommitData());  
     * snapshot's non-null {@code replicatingCommitData} (the value the primary replicated).  
        try {
            try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
    private CatalogSnapshotManager createManager(List<Segment> segments, Map<String, String> userData) throws IOException {
            CatalogSnapshot latest = ref.get();
        CatalogSnapshotManager manager = replicaManager(null, List.of(), Map.of(), mock(CommitFileManager.class));
            assertEquals("merged segment prepended", List.of(9L, 10L), generationsOf(manager));
    }
        DataformatAwareCatalogSnapshot snapshot = new DataformatAwareCatalogSnapshot(
        cs1.setLastCommitInfo("segments_1", 1L, 0L);  
        // No files deleted yet — CS1's commit ref keeps its files alive
            manager.applyReplicationSnapshot(incoming);  
            assertEquals(List.of(3L), generationsOf(manager));
        }
        DataformatAwareCatalogSnapshot initial = new DataformatAwareCatalogSnapshot(1L, 1L, 1L, List.of(seg), 1L, Map.of());
        try {  
                IllegalStateException.class,
            ((DataformatAwareCatalogSnapshot) refreshedSnapshot).isClosed()  
/**  
            public byte[] serializeToCommitFormat(CatalogSnapshot snapshot) {
        // gen 4 is already in the catalog and is NOT a merge source, so it would be retained.
        CatalogSnapshotManager manager = managerOver(List.of(liveSeg1, seg2, seg3));
    private static List<Long> generationsOf(CatalogSnapshotManager manager) throws IOException {
import org.opensearch.index.engine.exec.Segment;
            manager.close();  
        return userData;
        // Now _shared should be deleted (CS2 commit deleted by policy)
            MergeResult mergeResult = new MergeResult(Map.of());
        assertNotEquals("the two views must not be equal Segments", staleSeg1, liveSeg1);
        return segments;
            List.of(cs1),
                assertEquals(3L, segments.get(0).generation());
    public void testCloseOnlySetsFlagDoesNotDecRef() throws Exception {
        cs1.setLastCommitInfo("segments_1", 1L, 0L);
        cs1.setLastCommitInfo("segments_1", 1L, 0L);  
    /**
    /**
        SafeCommitInfo info = manager.getSafeCommitInfo();
        SafeCommitInfo info = manager.getSafeCommitInfo();
import java.nio.file.Path;  
                }
            }
        // CS1 is snapshotted — should NOT be deleted  
            committed = initialCommittedSnapshots;  
        for (int iter = 0; iter < 100; iter++) {
                    assertEquals(2 + (a + 1), currentSnap.refCount());  
                CatalogSnapshot heldSnapshot = heldRef.get();
     * must carry it forward so the replica's catalog snapshot never loses the primary's replicated
            return Map.of();  
        } finally {
        try {  
     * After merge, old pre-merge files are deleted when the commit referencing them is removed.
 *
                assertEquals(0L, snapshot.getId());
            }  
                try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {  
                manager.commitNewSnapshot(randomSegments());  
 * compatible open source license.
        Segment seg1 = new Segment(1L, Map.of(format.name(), wfs1));
            OneMerge oneMerge = new OneMerge(List.of(seg1, seg2));
     * Reader holding a snapshot keeps it alive across refreshes,
        } else {
        DataFormat format = new MockDataFormat();  
                manager.close();
        manager.commitNewSnapshot(List.of(segment(1, "parquet", "_1_data.parquet")));  
                () -> manager.applyMergeResults(new MergeResult(Map.of(format, mergedWfs)), new OneMerge(List.of(seg1, seg2)))  
     */
                assertEquals(300, segments.get(0).dfGroupedSearchableFiles().get(format.name()).numRows());
            try {
        manager.commitNewSnapshot(cs2Segments);  
     * files only deleted after reader releases AND commit is deleted by policy.
        CombinedCatalogSnapshotDeletionPolicy policy = new CombinedCatalogSnapshotDeletionPolicy(
            manager.close();
            commitRef.markSuccess();
            commitRef.get().setUserData(commitUserData(100, 100, translogUUID), true);
                long previousGeneration;
        try (GatedConditionalCloseable<CatalogSnapshot> commitRef = manager.acquireSnapshotForCommit()) {  
        Segment staleSeg1 = new Segment(1L, Map.of(format.name(), new WriterFileSet("/tmp/dir", 1L, Set.of("a.cfs"), 100, 0L)));
        );
                    assertEquals(3, currentSnap.refCount());  
            List.of(),
            assertTrue("pre-existing files must not be touched by empty-initial bootstrap", Files.exists(leftover));  
        held.close();
            commitRef.get().setUserData(commitUserData(200, 200, translogUUID), true);  
            } finally {  
    /**
                CatalogSnapshot snapshot = ref.get();
            1L,  
        // CS1's files that are NOT in CS2 should be deleted  
import org.opensearch.core.index.shard.ShardId;
        WriterFileSet wfs = new WriterFileSet("/data", gen, Set.of(files), files.length, 0L);  
                throw new UnsupportedOperationException("not used by this test");
            @Override  
                for (int r = 0; r < numAcquires; r++) {
 * SPDX-License-Identifier: Apache-2.0
        // FileDeleter deletes from the Lucene index directory.
                for (int a = 0; a < numAcquires; a++) {
                }  
            1L,  
                List.of(),
                    failed.forEach((k, v) -> allFailed.computeIfAbsent(k, x -> new java.util.ArrayList<>()).addAll(v));
     */
        }  
    }
        }
            for (FileDeleter deleter : perFormatDeleters.values()) {
        );
        CatalogSnapshotManager manager = new CatalogSnapshotManager(
     * startup orphan sweep scans only format directories referenced by the seed snapshot.
            manager.close();
        manager.applyReplicationSnapshot(incoming);
            }
import org.opensearch.index.translog.Translog;
            expectThrows(IllegalStateException.class, manager::acquireSnapshot);
     * Shared files between commits: file only deleted when ALL snapshots referencing it are gone.  
            incoming.setReplicatingCommitData(commitData);
            Map.of(),
                CatalogSnapshot acquired = ref.get();  
        Files.createDirectories(indexDir);
    public void testRefreshThenFlushDeletesOldCommitFiles() throws Exception {
            1L,
                    previousGeneration = ref.get().getGeneration();
        try {
            files -> Map.of(),
            try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
        ShardId shardId = new ShardId(new Index("test", "_na_"), 0);
                assertTrue(snapshot.getUserData().isEmpty());
    /** Builds a manager over the given segments; caller closes it. */
            List.of(),
        } finally {
        );
        Path indexDir = shardRoot.resolve("index");  
        try (GatedConditionalCloseable<CatalogSnapshot> commitRef = manager.acquireSnapshotForCommit()) {
        );
            null,
import org.opensearch.test.OpenSearchTestCase;
                }
        try (CatalogSnapshotManager manager = replicaManager(null, List.of(), Map.of(), mock(CommitFileManager.class))) {
    public void testGetSafeCommitInfoWithKeepLatestOnlyReturnsEmpty() throws IOException {
     */  
        assertTrue("_1_data.parquet should be deleted", deleted.contains("_1_data.parquet"));  
            List.of(),  
        Path indexDir = shardRoot.resolve("index");
            Map.of(),
import org.opensearch.index.engine.dataformat.stub.MockDataFormat;  
        Path writeLock = indexDir.resolve("write.lock");
        DataformatAwareCatalogSnapshot cs1 = new DataformatAwareCatalogSnapshot(0, 0, 1, List.of(seg1, seg2), 0, Map.of());
import java.util.concurrent.atomic.AtomicLong;
                for (int c = 0; c < numCommits; c++) {
                }
                    seenIds.add(ref.get().getId());  
        // knownFilesByFormat entry, so the scanner won't enumerate <shard>/index/ at all.  
                manager.close();
        }
import org.opensearch.index.translog.DefaultTranslogDeletionPolicy;  
    }  
            globalCP::get  
                }
        Segment seg2 = new Segment(2L, Map.of(format.name(), wfs2));
            List.of(),  
        // Reader releases
                assertEquals(1, heldSnapshot.refCount());
     * Replica manager with a {@link CommitFileManager} must protect commit-owned files
    public void testApplyMergeResultsAppliesWhenSourceLiveDocsChangedDuringMerge() throws Exception {
        Segment seg2 = new Segment(2L, Map.of(format.name(), wfs2));
        // So CS1's refCount > 0, removeFileReferences not called yet
                    refs.get(r).close();  
                assertEquals(0, prev.refCount());
        }  
        DataFormat format = new MockDataFormat();
        DataformatAwareCatalogSnapshot cs1 = new DataformatAwareCatalogSnapshot(
    public void testSharedFilesDeletedOnlyWhenAllRefsGone() throws Exception {
            commitRef.markSuccess();
    }  
            1L,  
        Segment seg3 = new Segment(3L, Map.of(format.name(), new WriterFileSet("/tmp/dir", 3L, Set.of("c.cfs"), 300, 0L)));
    public void testSnapshotProtectionPreventsFileDeletion() throws Exception {
import java.util.Collections;
                    currentSnap = initialRef.get();
        CatalogSnapshotManager manager = new CatalogSnapshotManager(
        manager.commitNewSnapshot(cs2Segments);
                }  
                assertSame("replicatingCommitData must be carried forward unchanged", commitData, latest.getReplicatingCommitData());
            commitRef.get().setUserData(commitUserData(200, 200, translogUUID), true);
            policy,  
    // --- File deletion and commit lifecycle tests ---
            randomNonNegativeLong(),
        CombinedCatalogSnapshotDeletionPolicy policy = new CombinedCatalogSnapshotDeletionPolicy(  
            }
        AtomicLong globalCP = new AtomicLong(100);  
                int numAcquires = randomIntBetween(1, 5);
            new DefaultTranslogDeletionPolicy(-1, -1, 0),  
    }
            1L,
                0L,
            assertTrue("write.lock must survive — protected by CommitFileManager", Files.exists(writeLock));
                // manager + commit = 2
            commitRef.get().setUserData(commitUserData(200, 200, translogUUID), true);  
            CatalogSnapshot initialSnapshot;
            Map.of(),
        initial.setLastCommitInfo("segments_1", 1L, 0L);
            CatalogSnapshotManager manager = createRandomManager();
                try {
    // --- helpers ---
            // 301 > 100 + 200
        IndexFileDeleterTests.TrackingFileDeleter tracker = new IndexFileDeleterTests.TrackingFileDeleter();  
                () -> manager.applyMergeResults(new MergeResult(Map.of(format, mergedWfs)), new OneMerge(List.of(seg1, seg2)))  
     */  
                Map.of(),  
import java.util.Map;  
            assertEquals("gens 1 and 2 replaced by the merged gen 4", List.of(3L, 4L), generationsOf(manager));
            List.of(segment(0, "parquet", "_0_data.parquet")),
        CatalogSnapshot snapshot;
            manager.applyMergeResults(mergeResult, oneMerge);
                manager.bumpGeneration();
                // refCount = 3: manager "latest" + commit ref (from IndexFileDeleter) + reader
 */  
            policy,
            randomSegments(),  
            }
        // Release the snapshot — triggers revisitPolicy which cleans up  
        GatedCloseable<CatalogSnapshot> readerRef = manager.acquireSnapshot();  
    public void testBumpGenerationPreservesReplicatingCommitData() throws Exception {
            null,  
            try {
    }
    }
        return userData;
            long id = randomNonNegativeLong();
        CatalogSnapshotManager manager = new CatalogSnapshotManager(
            OneMerge oneMerge = new OneMerge(List.of(seg1, seg2));  
                IllegalStateException.class,
    ) throws IOException {
            new DefaultTranslogDeletionPolicy(-1, -1, 0),
            // close() only sets the closed flag — does not decRef (files must survive for recovery)
        // Flush CS3  
            manager.close();  
     * generation that already exists as a retained segment must still be rejected. This is what  
        AtomicLong globalCP = new AtomicLong(100);  
     * generation reappears as a different {@link Segment} value while the in-flight merge still
                assertEquals(2, heldSnapshot.refCount());
    /**
        CombinedCatalogSnapshotDeletionPolicy policy = new CombinedCatalogSnapshotDeletionPolicy(  
        );
        }  
import org.opensearch.index.engine.exec.CombinedCatalogSnapshotDeletionPolicy;
        try (GatedConditionalCloseable<CatalogSnapshot> commitRef = manager.acquireSnapshotForCommit()) {  
                } catch (java.io.IOException e) {
     * <p>Matching by generation is what makes this work; matching by record equality rejected it
            commitRef.markSuccess();  
            dfGrouped.put(format, randomWriterFileSet(format, numRows));
        try {
/*  
    /**
    public void testApplyReplicationSnapshotOnClosedManagerThrows() throws Exception {
    public void testApplyMergeResultsAppliesWhenOneSourceGenerationWasDropped() throws Exception {  
        return new CatalogSnapshotManager(  
            commitRef.markSuccess();
        List<Segment> cs1Segments = List.of(
        Segment seg9 = new Segment(9L, Map.of(format.name(), new WriterFileSet("/tmp/dir", 9L, Set.of("i.cfs"), 900, 0L)));
        CatalogSnapshotManager manager = createRandomManager();  
import org.opensearch.common.concurrent.GatedCloseable;
    }
        cs1.setLastCommitInfo("segments_1", 1L, 0L);  
        // The current view: gen 1 gained a live-docs file. Same generation, different record.
        Set<String> deleted = tracker.deletedFiles;
            randomNonNegativeLong(),
        userData.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(maxSeqNo));
            segment(2, "parquet", "_2_data.parquet", "_2_index.parquet")  
        try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {  
        // Reader acquires CS1
        // Do a refresh so we get a snapshot without a commit ref
                try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
        ShardId shardId = new ShardId(new Index("test", "_na_"), 0);
        // Manager has seg1 and seg2 — the segments being merged are present
            mock(CommitFileManager.class)
    /**  
            files -> Map.of(),  
            long initGen = randomIntBetween(0, 100);  
        }
            assertTrue("segments_7 must survive — protected by CommitFileManager", Files.exists(segmentsCommit));  
                try (GatedCloseable<CatalogSnapshot> initialRef = manager.acquireSnapshot()) {
        if (initialCommittedSnapshots.isEmpty()) {  
        // Build a snapshot that references only `known.si` under the lucene format.
import java.nio.file.Files;
     * Trace from the dry-run: refresh adds new segment, flush commits,
            manager.close();  
        userData.put(Translog.TRANSLOG_UUID_KEY, translogUUID);
        } finally {
        cs1.setLastCommitInfo("segments_1", 1L, 0L);
            CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,  
        CatalogSnapshotManager manager = managerOver(List.of(seg1, seg2));  
            }  
            List.of(segment(0, "parquet", "_0_data.parquet")),
        DataformatAwareCatalogSnapshot cs1 = new DataformatAwareCatalogSnapshot(
        assertFalse(((DataformatAwareCatalogSnapshot) snapshot).isClosed());
    }
        CatalogSnapshotManager manager = createRandomManager();
        manager.close();
        return createManager(segments, userData, CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY, files -> Map.of());  
            );
                Set<Long> seenIds = new HashSet<>();  
                DataformatAwareCatalogSnapshot latest = (DataformatAwareCatalogSnapshot) ref.get();
        );  
     */
    }
                assertTrue(seed.getSegments().isEmpty());
            mock(CommitFileManager.class)
        Files.createDirectories(indexDir);
            logger,
            List.of(),
        manager.close();
        Map<String, String> userData,
        Segment seg2 = new Segment(2L, Map.of(format.name(), new WriterFileSet("/tmp/dir", 2L, Set.of("b.cfs"), 200, 0L)));  
        snapshot.setLastCommitInfo("segments_1", 1L, 0L);
        GatedCloseable<CatalogSnapshot> heldRef = manager.acquireSnapshot();
        try {
            mock(CommitFileManager.class)
        globalCP.set(200);
            assertEquals(1, finalSnapshot.refCount());  
        }, Map.of(), List.of(), shardPath, commitFileManager);
            IllegalStateException e = expectThrows(
        try {
        for (int i = 0; i < entries; i++) {
                try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {  
        // gen 2 was fully deleted during the merge and is no longer in the catalog.  
            CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,
        // Plant files: 1 known (in catalog), 1 orphan, 2 commit-owned.
        AtomicLong globalCP = new AtomicLong(100);  
        List<Segment> segments,
            try {
        DataformatAwareCatalogSnapshot initial = new DataformatAwareCatalogSnapshot(1L, 1L, 0L, randomSegments(), 1L, Map.of());  
        );
        try (GatedConditionalCloseable<CatalogSnapshot> commitRef = manager.acquireSnapshotForCommit()) {
    public void testApplyMergeResultsReplacesSegments() throws Exception {
        try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
            assertFalse("orphan.si must be swept — not in catalog and not commit-managed", Files.exists(orphan));
            List.of(),
