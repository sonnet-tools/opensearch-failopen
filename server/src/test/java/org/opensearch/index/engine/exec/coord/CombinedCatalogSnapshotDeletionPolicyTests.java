    }
    public void testOnInitSetsSafeAndLastCommit() throws IOException {
    }
        CatalogSnapshot cs1 = snapshot(1, 50, 50, "old-uuid");
        List<CatalogSnapshot> commits = new ArrayList<>(List.of(cs1));
        CombinedCatalogSnapshotDeletionPolicy policy = createPolicy(globalCP);
    // ---- getDocCountOfCommit ----
        CombinedCatalogSnapshotDeletionPolicy policy = createPolicy(globalCP);
        assertEquals(1, toDelete.size());
import java.util.HashMap;
        CombinedCatalogSnapshotDeletionPolicy policy = createPolicy(globalCP);
        try (GatedCloseable<CatalogSnapshot> safe = policy.acquireCommittedSnapshot(true)) {
            new Segment(1, Map.of("parquet", new WriterFileSet("/data", 1, Set.of("b.parquet"), 20, 0L))),
        assertSame(cs1, CombinedCatalogSnapshotDeletionPolicy.findSafeCommitPoint(List.of(cs1, cs2, cs3), 50));
public class CombinedCatalogSnapshotDeletionPolicyTests extends OpenSearchTestCase {
        List<CatalogSnapshot> commits = new ArrayList<>(List.of(cs1));
        List<Segment> segments = List.of(
        List<CatalogSnapshot> commits = new ArrayList<>(List.of(cs1, cs2));
/*
        CombinedCatalogSnapshotDeletionPolicy policy = createPolicy(globalCP);
        commits.add(cs2);
import org.opensearch.index.engine.exec.WriterFileSet;
        CatalogSnapshot cs2 = snapshot(2, 200, 200, "uuid1");
        CatalogSnapshot cs = snapshotWithDocs(1, 100, 100, "uuid", segments);
        CatalogSnapshot cs = snapshot(42, 100, 100, "uuid");
    public void testGetDocCountOfCommitEmptySegments() {
        CatalogSnapshot cs2 = snapshot(2, 200, 200, "uuid1");
        GatedCloseable<CatalogSnapshot> hold1 = policy.acquireCommittedSnapshot(false);
import org.opensearch.index.engine.SafeCommitInfo;
        assertSame(cs1, toDelete.get(0));
        assertTrue(policy.onCommit(commits).isEmpty());
        policy.onInit(commits);
        CatalogSnapshot cs1 = snapshot(1, 100, 100, "uuid1");
        assertEquals(1, toDelete.size());
    private static CatalogSnapshot snapshot(long gen, long maxSeqNo, long localCP, String translogUUID) {
            new Segment(
                    new WriterFileSet("/data", 0, Set.of("_0.cfs"), 15, 0L)
        policy.onInit(commits);
        assertEquals(1, policy.onCommit(commits).size());
        try (GatedCloseable<CatalogSnapshot> last = policy.acquireCommittedSnapshot(false)) {
        assertEquals(35, info.docCount); // 10 + 25
        GatedCloseable<CatalogSnapshot> held = policy.acquireCommittedSnapshot(false);
        // Advance globalCP past cs2's maxSeqNo
        assertTrue(policy.onCommit(commits).isEmpty());
        // globalCP=50 → cs1 is fallback (oldest)
        assertTrue(toDelete.isEmpty()); // cs1 is safe, cs2 is last, both kept
        assertTrue(desc.contains("uuid"));
import org.opensearch.index.engine.exec.Segment;
        commits.add(cs2);
    }
        CatalogSnapshot cs1 = snapshot(1, 100, 100, "uuid");
 */
        assertSame(cs1, policy.getSafeCommit());
    }
    public void testGetDocCountOfCommitMultiFormatConsistentRows() {
        policy.onCommit(commits);
        CatalogSnapshot cs = snapshotWithDocs(1, 100, 100, "uuid", List.of());
        commits.add(cs2);
package org.opensearch.index.engine.exec.coord;
        CombinedCatalogSnapshotDeletionPolicy policy = createPolicy(new AtomicLong(0));
        CombinedCatalogSnapshotDeletionPolicy policy = createPolicy(globalCP);
    public void testFindSafeCommitPointEmptyListThrows() {
        assertTrue(policy.hasUnreferencedCommits());
                    "lucene",
        List<CatalogSnapshot> commits = new ArrayList<>(List.of(cs1));
        assertSame(cs2, policy.getSafeCommit());
    // ---- findSafeCommit ----
        AtomicLong globalCP = new AtomicLong(100);
        return new DataformatAwareCatalogSnapshot(gen, gen, 0L, segments, 0L, userData);
    }
        assertSame(cs3, policy.findSafeCommit(List.of(cs1, cs2, cs3)));
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.engine.exec.CombinedCatalogSnapshotDeletionPolicy;
            new Segment(2, Map.of("parquet", new WriterFileSet("/data", 2, Set.of("c.parquet"), 30, 0L)))
        );
    private static CatalogSnapshot snapshotWithDocs(long gen, long maxSeqNo, long localCP, String translogUUID, List<Segment> segments) {
        List<CatalogSnapshot> toDelete = policy.onCommit(commits);
        assertSame(cs1, policy.getLastCommit());
    }
        policy.onInit(commits);
        // cs2 is now safe (maxSeqNo=200 ≤ globalCP=200), cs1 should be deleted
    public void testGetSafeCommitInfoAfterOnCommit() throws IOException {
    }
        assertSame(cs1, toDelete.get(0));
        assertSame(cs1, held.get());
        userData.put(Translog.TRANSLOG_UUID_KEY, translogUUID);
import java.io.IOException;
        commits.add(cs2);
    public void testOnCommitIdentifiesSafeAndLastCommit() throws IOException {
        List<CatalogSnapshot> commits = new ArrayList<>(List.of(cs1));
            new Segment(0, Map.of("parquet", new WriterFileSet("/data", 0, Set.of("a.parquet"), 10, 0L))),
        // maxSeqNoOfNextSafeCommit = 200 (cs2), globalCP = 100
        assertEquals(1, toDelete.size());
        assertSame(cs2, policy.getLastCommit());
        // Advance global checkpoint, add cs3
        CatalogSnapshot cs1 = snapshot(1, 100, 100, "uuid1");
        assertTrue(toDelete.isEmpty());
        AtomicLong globalCP = new AtomicLong(100);
        AtomicLong globalCP = new AtomicLong(50);
        assertSame(cs2, CombinedCatalogSnapshotDeletionPolicy.findSafeCommitPoint(List.of(cs1, cs2, cs3), 200));
        assertEquals(15, CombinedCatalogSnapshotDeletionPolicy.getDocCountOfCommit(cs));
    public void testHasUnreferencedCommits() throws IOException {
        CatalogSnapshot cs1 = snapshot(1, 100, 100, "uuid1");
        CatalogSnapshot cs = snapshotWithDocs(1, 100, 100, "uuid", segments);
        assertSame(cs2, policy.findSafeCommit(List.of(cs1, cs2, cs3)));
        // New commit with maxSeqNo=200, globalCP still 100
    }
                )
                0,
    public void testFindSafeCommitPointMultipleCommits() throws IOException {
        CatalogSnapshot cs1 = snapshot(1, 100, 100, "uuid");
                    "parquet",
    public void testSnapshotProtectionPreventsCommitDeletion() throws IOException {
    public void testCommitDescription() {
        // cs1 held twice — not deletable
    public void testFindSafeCommitDelegatesToFindSafeCommitPoint() throws IOException {
        commits.add(cs2);
        // Release snapshot
 * this file be licensed under the Apache-2.0 license or a
        CatalogSnapshot cs1 = snapshot(1, 100, 100, "uuid");
        List<Segment> segments = List.of(
        // Now cs1 should be deletable
        commits.add(cs3);
        List<CatalogSnapshot> commits = new ArrayList<>(List.of(cs1));
        AtomicLong globalCP = new AtomicLong(200);
        globalCP.set(200);
        CatalogSnapshot cs2 = snapshot(2, 200, 200, "uuid1");
        List<CatalogSnapshot> toDelete = policy.onCommit(commits);
    public void testAcquireSafeVsLastCommit() throws IOException {
        CombinedCatalogSnapshotDeletionPolicy policy = createPolicy(globalCP);
        policy.onCommit(commits);
        assertEquals(SafeCommitInfo.EMPTY, policy.getSafeCommitInfo());
    }
import java.util.List;
    // ---- findSafeCommitPoint ----
        // Advance globalCP → cs3 becomes safe
    }
        );
            )
        List<CatalogSnapshot> commits = new ArrayList<>(List.of(cs1));
        AtomicLong globalCP = new AtomicLong(100);
 * The OpenSearch Contributors require contributions made to
        userData.put(Translog.TRANSLOG_UUID_KEY, translogUUID);
    }
import org.opensearch.common.concurrent.GatedCloseable;
        CatalogSnapshot cs1 = snapshot(1, 100, 100, "uuid1");
        expectThrows(IllegalStateException.class, () -> policy.onInit(commits));
    public void testCommitsWithDifferentTranslogUUIDFiltered() throws IOException {
        CatalogSnapshot cs2 = snapshot(2, 200, 200, "uuid1");
        // globalCP=200 → cs2 is safe (maxSeqNo=200 ≤ 200)
        AtomicLong globalCP = new AtomicLong(100);
        globalCP.set(200);
        AtomicLong globalCP = new AtomicLong(100);
        return new DataformatAwareCatalogSnapshot(gen, gen, 0L, List.of(), 0L, userData);
import java.util.Set;
    }
 *
        CatalogSnapshot cs1 = snapshot(1, 100, 100, "uuid1");
        // cs1 is snapshotted — should NOT be deleted
        CombinedCatalogSnapshotDeletionPolicy policy = createPolicy(globalCP);
    // ---- getSafeCommitInfo ----
        CombinedCatalogSnapshotDeletionPolicy policy = createPolicy(globalCP);
        hold2.close();
        // Still held once
        userData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, Long.toString(localCP));
        GatedCloseable<CatalogSnapshot> hold2 = policy.acquireCommittedSnapshot(false);
        assertSame(cs1, toDelete.get(0));
        // globalCP=300 → cs3 is safe
    }
        CatalogSnapshot cs2 = snapshot(2, 200, 200, "uuid1");
        // Add cs2, advance globalCP so cs1 would normally be deleted
        AtomicLong globalCP = new AtomicLong(100);
        // safe=cs1, last=cs2, safe != last → should throw
    }
        policy.onInit(commits);
        );
        // safe=cs1, last=cs2
        CatalogSnapshot cs2 = snapshot(2, 200, 200, "uuid");
 * Tests for {@link CombinedCatalogSnapshotDeletionPolicy}.
        }
    }
        CatalogSnapshot cs2 = snapshot(2, 100, 100, "uuid1");
                    new WriterFileSet("/data", 0, Set.of("a.parquet"), 15, 0L),
        // globalCP=200 → cs2 is safe (maxSeqNo=200 ≤ 200)
    public void testOnInitThrowsWhenLastCommitIsNotSafe() {
        List<CatalogSnapshot> commits = new ArrayList<>(List.of(cs1, cs2));
        // Now deletable
        CatalogSnapshot cs3 = snapshot(3, 300, 300, "uuid1");
        String desc = CombinedCatalogSnapshotDeletionPolicy.commitDescription(cs);
        hold1.close();
        AtomicLong globalCP = new AtomicLong(100);
        assertFalse(policy.hasUnreferencedCommits());
        policy.onInit(commits);
        assertEquals(0, CombinedCatalogSnapshotDeletionPolicy.getDocCountOfCommit(cs));
        CatalogSnapshot cs1 = snapshot(1, 100, 100, "uuid1");
    public void testGetDocCountOfCommitSumsAcrossSegments() {
import org.opensearch.index.translog.Translog;
        globalCP.set(200);
        CatalogSnapshot cs2 = snapshot(2, 200, 200, "uuid1");
        CombinedCatalogSnapshotDeletionPolicy policy = createPolicy(globalCP);
import java.util.ArrayList;
        commits.add(cs2);
        CatalogSnapshot cs2 = snapshot(2, 200, 200, "uuid");
import org.opensearch.test.OpenSearchTestCase;
        CatalogSnapshot cs3 = snapshot(3, 300, 300, "uuid");
        assertSame(cs2, policy.getSafeCommit());
        expectThrows(IllegalArgumentException.class, () -> CombinedCatalogSnapshotDeletionPolicy.findSafeCommitPoint(List.of(), 100));
import java.util.concurrent.atomic.AtomicLong;
        }
        userData.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(maxSeqNo));
            assertSame(cs2, last.get());
    public void testOnCommitDeletesOldCommitsBeforeSafe() throws IOException {
        // Acquire snapshot on cs1
    }
        userData.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(maxSeqNo));
        CombinedCatalogSnapshotDeletionPolicy policy = createPolicy(globalCP);
        List<CatalogSnapshot> toDelete = policy.onCommit(commits);
            assertSame(cs1, safe.get());
        assertTrue(desc.contains("100"));
}
import org.opensearch.index.seqno.SequenceNumbers;
/**
        globalCP.set(300);
        AtomicLong globalCP = new AtomicLong(100);
        CatalogSnapshot cs1 = snapshot(1, 50, 50, "uuid1");
        assertTrue(toDelete.isEmpty());
    }
        // cs1 is safe (maxSeqNo=50 ≤ globalCP=50), cs2 is not (maxSeqNo=100 > 50)
    }
        policy.onInit(commits);
        List<CatalogSnapshot> toDelete = policy.onInit(commits);
        assertTrue(desc.contains("42"));
        Map<String, String> userData = new HashMap<>();
        held.close();
        CatalogSnapshot cs2 = snapshot(2, 100, 100, "new-uuid");
        CatalogSnapshot cs1 = snapshot(1, 100, 100, "uuid1");
        SafeCommitInfo info = policy.getSafeCommitInfo();
        CatalogSnapshot cs3 = snapshot(3, 300, 300, "uuid");
        // cs2 is safe and last. cs1 has different UUID and is before safe → deleted
        assertSame(cs3, CombinedCatalogSnapshotDeletionPolicy.findSafeCommitPoint(List.of(cs1, cs2, cs3), 300));
        CombinedCatalogSnapshotDeletionPolicy policy = createPolicy(globalCP);
            new Segment(1, Map.of("parquet", new WriterFileSet("/data", 1, Set.of("b.parquet"), 25, 0L)))
    }
        userData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, Long.toString(localCP));
        Map<String, String> userData = new HashMap<>();
        policy.onInit(commits);
        policy.onCommit(commits);
        List<CatalogSnapshot> commits = new ArrayList<>(List.of(cs1));
        return new CombinedCatalogSnapshotDeletionPolicy(logger, new DefaultTranslogDeletionPolicy(-1, -1, 0), globalCP::get);
        assertEquals(100, info.localCheckpoint);
        assertSame(cs3, policy.getLastCommit());
        toDelete = policy.onCommit(commits);
        globalCP.set(200);
    }
    public void testMultipleSnapshotHoldsOnSameCommit() throws IOException {
            new Segment(0, Map.of("parquet", new WriterFileSet("/data", 0, Set.of("a.parquet"), 10, 0L))),
        List<Segment> segments = List.of(
    }
    public void testFindSafeCommitPointSingleCommit() throws IOException {
import java.util.Map;
        assertSame(cs2, policy.getLastCommit());
                Map.of(
        List<CatalogSnapshot> commits = new ArrayList<>(List.of(cs1));
        assertEquals(60, CombinedCatalogSnapshotDeletionPolicy.getDocCountOfCommit(cs));
        assertSame(cs1, policy.getSafeCommit());
        assertSame(cs1, CombinedCatalogSnapshotDeletionPolicy.findSafeCommitPoint(List.of(cs1), 200));
 */
        AtomicLong globalCP = new AtomicLong(200);
    private CombinedCatalogSnapshotDeletionPolicy createPolicy(AtomicLong globalCP) {
    }
    // ---- commitDescription ----
    public void testGetSafeCommitInfoReturnsEmptyBeforeInit() {
import org.opensearch.index.translog.DefaultTranslogDeletionPolicy;
        List<CatalogSnapshot> toDelete = policy.onInit(commits);
        CatalogSnapshot cs1 = snapshotWithDocs(1, 100, 100, "uuid1", segments);
