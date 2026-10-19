        List<CatalogSnapshot> toDelete = policy.onCommit(commits);  
import java.util.concurrent.atomic.AtomicLong;
        commits.add(cs2);
        assertSame(cs1, toDelete.get(0));  
    }  
        GatedCloseable<CatalogSnapshot> hold2 = policy.acquireCommittedSnapshot(false);
        CatalogSnapshot cs = snapshotWithDocs(1, 100, 100, "uuid", segments);
        CatalogSnapshot cs1 = snapshot(1, 100, 100, "uuid");
        CatalogSnapshot cs2 = snapshot(2, 200, 200, "uuid");  
        assertSame(cs1, toDelete.get(0));
        // cs1 is snapshotted — should NOT be deleted
        assertSame(cs2, policy.getLastCommit());  
        toDelete = policy.onCommit(commits);  
        return new CombinedCatalogSnapshotDeletionPolicy(logger, new DefaultTranslogDeletionPolicy(-1, -1, 0), globalCP::get);
            new Segment(0, Map.of("parquet", new WriterFileSet("/data", 0, Set.of("a.parquet"), 10, 0L))),
        CatalogSnapshot cs = snapshot(42, 100, 100, "uuid");
        AtomicLong globalCP = new AtomicLong(100);
        policy.onInit(commits);
        assertFalse(policy.hasUnreferencedCommits());
        commits.add(cs2);  
import java.util.Map;  
        userData.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(maxSeqNo));
        assertSame(cs3, policy.getLastCommit());
        SafeCommitInfo info = policy.getSafeCommitInfo();  
        List<CatalogSnapshot> commits = new ArrayList<>(List.of(cs1));
        AtomicLong globalCP = new AtomicLong(100);
import java.util.Set;
        // globalCP=300 → cs3 is safe  
        assertSame(cs1, CombinedCatalogSnapshotDeletionPolicy.findSafeCommitPoint(List.of(cs1, cs2, cs3), 50));
import java.util.ArrayList;  
        assertEquals(60, CombinedCatalogSnapshotDeletionPolicy.getDocCountOfCommit(cs));
        List<CatalogSnapshot> commits = new ArrayList<>(List.of(cs1));
        CombinedCatalogSnapshotDeletionPolicy policy = createPolicy(globalCP);
        CombinedCatalogSnapshotDeletionPolicy policy = createPolicy(globalCP);
        // cs1 held twice — not deletable
    }  
        held.close();  
    public void testFindSafeCommitPointMultipleCommits() throws IOException {  
    }  
        expectThrows(IllegalStateException.class, () -> policy.onInit(commits));
        userData.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(maxSeqNo));
        List<CatalogSnapshot> commits = new ArrayList<>(List.of(cs1));  
        assertTrue(desc.contains("uuid"));  
        // cs2 is now safe (maxSeqNo=200 ≤ globalCP=200), cs1 should be deleted
        assertTrue(toDelete.isEmpty());  
        List<Segment> segments = List.of(
        policy.onInit(commits);
        assertSame(cs1, held.get());  
        assertEquals(1, policy.onCommit(commits).size());
        assertTrue(toDelete.isEmpty());
    // ---- getSafeCommitInfo ----
        assertTrue(policy.onCommit(commits).isEmpty());
        policy.onInit(commits);
    }
        policy.onInit(commits);
        assertSame(cs3, policy.findSafeCommit(List.of(cs1, cs2, cs3)));
    }
        List<CatalogSnapshot> commits = new ArrayList<>(List.of(cs1));  
        assertTrue(desc.contains("100"));
        hold1.close();
    public void testOnCommitIdentifiesSafeAndLastCommit() throws IOException {
        assertEquals(35, info.docCount); // 10 + 25
        assertSame(cs2, policy.getSafeCommit());
import org.opensearch.index.seqno.SequenceNumbers;  
        // Now deletable
        assertEquals(1, toDelete.size());  
        CatalogSnapshot cs1 = snapshot(1, 100, 100, "uuid1");  
        );
                )
        assertSame(cs2, policy.getLastCommit());
        CombinedCatalogSnapshotDeletionPolicy policy = createPolicy(globalCP);
        CatalogSnapshot cs2 = snapshot(2, 200, 200, "uuid1");
        globalCP.set(300);
        // Acquire snapshot on cs1
    }  
    public void testGetDocCountOfCommitMultiFormatConsistentRows() {
/**
package org.opensearch.index.engine.exec.coord;
        // cs1 is safe (maxSeqNo=50 ≤ globalCP=50), cs2 is not (maxSeqNo=100 > 50)
        // Advance globalCP past cs2's maxSeqNo  
        CatalogSnapshot cs1 = snapshot(1, 100, 100, "uuid1");  
        userData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, Long.toString(localCP));  
    // ---- getDocCountOfCommit ----
        // safe=cs1, last=cs2, safe != last → should throw  
            assertSame(cs2, last.get());
        Map<String, String> userData = new HashMap<>();  
        assertSame(cs1, policy.getSafeCommit());
        hold2.close();  
import org.opensearch.test.OpenSearchTestCase;  
    public void testOnInitThrowsWhenLastCommitIsNotSafe() {  
        CombinedCatalogSnapshotDeletionPolicy policy = createPolicy(globalCP);
 * SPDX-License-Identifier: Apache-2.0
        );
        policy.onCommit(commits);
    }
        CombinedCatalogSnapshotDeletionPolicy policy = createPolicy(globalCP);
    }  
                    "parquet",
 */  
        return new DataformatAwareCatalogSnapshot(gen, gen, 0L, segments, 0L, userData);
        assertTrue(policy.onCommit(commits).isEmpty());  
        CombinedCatalogSnapshotDeletionPolicy policy = createPolicy(new AtomicLong(0));
        // maxSeqNoOfNextSafeCommit = 200 (cs2), globalCP = 100  
        CombinedCatalogSnapshotDeletionPolicy policy = createPolicy(globalCP);
    public void testFindSafeCommitPointEmptyListThrows() {
        CatalogSnapshot cs1 = snapshot(1, 50, 50, "old-uuid");  
        CatalogSnapshot cs = snapshotWithDocs(1, 100, 100, "uuid", segments);
                0,
    private static CatalogSnapshot snapshotWithDocs(long gen, long maxSeqNo, long localCP, String translogUUID, List<Segment> segments) {
    }  
        AtomicLong globalCP = new AtomicLong(50);
    public void testGetDocCountOfCommitSumsAcrossSegments() {
    public void testGetSafeCommitInfoAfterOnCommit() throws IOException {  
        // Advance global checkpoint, add cs3
import java.io.IOException;
        CatalogSnapshot cs1 = snapshot(1, 100, 100, "uuid");
        // safe=cs1, last=cs2
        CatalogSnapshot cs2 = snapshot(2, 200, 200, "uuid1");
    public void testOnInitSetsSafeAndLastCommit() throws IOException {
    public void testGetSafeCommitInfoReturnsEmptyBeforeInit() {
    }
        String desc = CombinedCatalogSnapshotDeletionPolicy.commitDescription(cs);  
    }
    private static CatalogSnapshot snapshot(long gen, long maxSeqNo, long localCP, String translogUUID) {  
        CatalogSnapshot cs1 = snapshot(1, 100, 100, "uuid1");
import org.opensearch.common.concurrent.GatedCloseable;
        CombinedCatalogSnapshotDeletionPolicy policy = createPolicy(globalCP);
        AtomicLong globalCP = new AtomicLong(100);
        List<CatalogSnapshot> toDelete = policy.onCommit(commits);
    public void testCommitDescription() {
    // ---- commitDescription ----
    }  
        GatedCloseable<CatalogSnapshot> hold1 = policy.acquireCommittedSnapshot(false);
        CatalogSnapshot cs1 = snapshot(1, 100, 100, "uuid1");  
    }  
    }  
        AtomicLong globalCP = new AtomicLong(100);  
    }
import org.opensearch.index.engine.exec.CombinedCatalogSnapshotDeletionPolicy;  
import org.opensearch.index.translog.Translog;
        CatalogSnapshot cs2 = snapshot(2, 100, 100, "new-uuid");
        assertEquals(SafeCommitInfo.EMPTY, policy.getSafeCommitInfo());  
            new Segment(2, Map.of("parquet", new WriterFileSet("/data", 2, Set.of("c.parquet"), 30, 0L)))
        );  
            new Segment(
        policy.onInit(commits);
        AtomicLong globalCP = new AtomicLong(100);
        // Release snapshot
    // ---- findSafeCommit ----
import java.util.HashMap;
                    new WriterFileSet("/data", 0, Set.of("_0.cfs"), 15, 0L)
        Map<String, String> userData = new HashMap<>();
    public void testSnapshotProtectionPreventsCommitDeletion() throws IOException {
        assertSame(cs3, CombinedCatalogSnapshotDeletionPolicy.findSafeCommitPoint(List.of(cs1, cs2, cs3), 300));
                    "lucene",  
                Map.of(  
            assertSame(cs1, safe.get());
        List<CatalogSnapshot> commits = new ArrayList<>(List.of(cs1, cs2));
        List<CatalogSnapshot> toDelete = policy.onInit(commits);
        assertSame(cs1, CombinedCatalogSnapshotDeletionPolicy.findSafeCommitPoint(List.of(cs1), 200));  
    public void testMultipleSnapshotHoldsOnSameCommit() throws IOException {
        assertTrue(policy.hasUnreferencedCommits());
        // globalCP=200 → cs2 is safe (maxSeqNo=200 ≤ 200)  
    }  
        assertEquals(1, toDelete.size());
        assertSame(cs2, CombinedCatalogSnapshotDeletionPolicy.findSafeCommitPoint(List.of(cs1, cs2, cs3), 200));  
import org.opensearch.index.engine.SafeCommitInfo;
        CatalogSnapshot cs1 = snapshot(1, 100, 100, "uuid1");  
        CatalogSnapshot cs1 = snapshot(1, 100, 100, "uuid");
        try (GatedCloseable<CatalogSnapshot> last = policy.acquireCommittedSnapshot(false)) {  
    public void testOnCommitDeletesOldCommitsBeforeSafe() throws IOException {
        expectThrows(IllegalArgumentException.class, () -> CombinedCatalogSnapshotDeletionPolicy.findSafeCommitPoint(List.of(), 100));
        assertSame(cs2, policy.getSafeCommit());
        CombinedCatalogSnapshotDeletionPolicy policy = createPolicy(globalCP);  
        commits.add(cs2);
        userData.put(Translog.TRANSLOG_UUID_KEY, translogUUID);
        userData.put(Translog.TRANSLOG_UUID_KEY, translogUUID);  
 * compatible open source license.
        commits.add(cs2);  
        assertTrue(toDelete.isEmpty()); // cs1 is safe, cs2 is last, both kept
        GatedCloseable<CatalogSnapshot> held = policy.acquireCommittedSnapshot(false);
    public void testHasUnreferencedCommits() throws IOException {  
 */  
        assertSame(cs1, policy.getSafeCommit());  
        List<CatalogSnapshot> toDelete = policy.onCommit(commits);
        CatalogSnapshot cs2 = snapshot(2, 200, 200, "uuid1");  
    public void testCommitsWithDifferentTranslogUUIDFiltered() throws IOException {
        CatalogSnapshot cs2 = snapshot(2, 200, 200, "uuid1");
        CatalogSnapshot cs2 = snapshot(2, 200, 200, "uuid");
        CatalogSnapshot cs1 = snapshot(1, 100, 100, "uuid1");
        // cs2 is safe and last. cs1 has different UUID and is before safe → deleted
        CatalogSnapshot cs3 = snapshot(3, 300, 300, "uuid");  
        globalCP.set(200);
    }
    // ---- findSafeCommitPoint ----
import org.opensearch.index.engine.exec.WriterFileSet;
        List<CatalogSnapshot> commits = new ArrayList<>(List.of(cs1, cs2));
        userData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, Long.toString(localCP));
        List<Segment> segments = List.of(
        assertEquals(100, info.localCheckpoint);
        globalCP.set(200);
        List<CatalogSnapshot> commits = new ArrayList<>(List.of(cs1));
        CombinedCatalogSnapshotDeletionPolicy policy = createPolicy(globalCP);
 * this file be licensed under the Apache-2.0 license or a
        CatalogSnapshot cs2 = snapshot(2, 200, 200, "uuid1");
    }  
        CatalogSnapshot cs = snapshotWithDocs(1, 100, 100, "uuid", List.of());
        CatalogSnapshot cs3 = snapshot(3, 300, 300, "uuid");
        policy.onInit(commits);
        policy.onCommit(commits);
        CatalogSnapshot cs2 = snapshot(2, 200, 200, "uuid1");
        commits.add(cs2);
        assertSame(cs1, toDelete.get(0));
public class CombinedCatalogSnapshotDeletionPolicyTests extends OpenSearchTestCase {
    }
        return new DataformatAwareCatalogSnapshot(gen, gen, 0L, List.of(), 0L, userData);
        List<CatalogSnapshot> commits = new ArrayList<>(List.of(cs1));
        // globalCP=50 → cs1 is fallback (oldest)
        CombinedCatalogSnapshotDeletionPolicy policy = createPolicy(globalCP);  
        List<CatalogSnapshot> commits = new ArrayList<>(List.of(cs1));  
    }
import java.util.List;
    public void testFindSafeCommitDelegatesToFindSafeCommitPoint() throws IOException {
    public void testFindSafeCommitPointSingleCommit() throws IOException {
 * Tests for {@link CombinedCatalogSnapshotDeletionPolicy}.
        // Still held once  
        CatalogSnapshot cs1 = snapshotWithDocs(1, 100, 100, "uuid1", segments);
        try (GatedCloseable<CatalogSnapshot> safe = policy.acquireCommittedSnapshot(true)) {  
        AtomicLong globalCP = new AtomicLong(100);  
            new Segment(0, Map.of("parquet", new WriterFileSet("/data", 0, Set.of("a.parquet"), 10, 0L))),  
        // New commit with maxSeqNo=200, globalCP still 100  
/*  
        globalCP.set(200);
        // Advance globalCP → cs3 becomes safe  
        List<CatalogSnapshot> commits = new ArrayList<>(List.of(cs1));
        globalCP.set(200);  
        assertEquals(1, toDelete.size());
        AtomicLong globalCP = new AtomicLong(100);  
        CatalogSnapshot cs3 = snapshot(3, 300, 300, "uuid1");  
    public void testGetDocCountOfCommitEmptySegments() {  
        }
        List<Segment> segments = List.of(  
        policy.onCommit(commits);  
        CatalogSnapshot cs1 = snapshot(1, 100, 100, "uuid1");
        commits.add(cs2);
        AtomicLong globalCP = new AtomicLong(100);  
    public void testAcquireSafeVsLastCommit() throws IOException {
        assertSame(cs2, policy.findSafeCommit(List.of(cs1, cs2, cs3)));
}
        commits.add(cs3);
import org.opensearch.index.engine.exec.Segment;
        AtomicLong globalCP = new AtomicLong(200);
        AtomicLong globalCP = new AtomicLong(200);  
    }  
        assertEquals(0, CombinedCatalogSnapshotDeletionPolicy.getDocCountOfCommit(cs));
        CatalogSnapshot cs2 = snapshot(2, 100, 100, "uuid1");  
        CombinedCatalogSnapshotDeletionPolicy policy = createPolicy(globalCP);  
        }
        assertTrue(desc.contains("42"));
        List<CatalogSnapshot> toDelete = policy.onInit(commits);  
    }
        CatalogSnapshot cs1 = snapshot(1, 50, 50, "uuid1");
                    new WriterFileSet("/data", 0, Set.of("a.parquet"), 15, 0L),
        assertSame(cs1, policy.getLastCommit());  
            new Segment(1, Map.of("parquet", new WriterFileSet("/data", 1, Set.of("b.parquet"), 25, 0L)))  
        // Now cs1 should be deletable
            new Segment(1, Map.of("parquet", new WriterFileSet("/data", 1, Set.of("b.parquet"), 20, 0L))),
import org.opensearch.index.translog.DefaultTranslogDeletionPolicy;
        assertEquals(15, CombinedCatalogSnapshotDeletionPolicy.getDocCountOfCommit(cs));  
        policy.onInit(commits);  
        // globalCP=200 → cs2 is safe (maxSeqNo=200 ≤ 200)
 * The OpenSearch Contributors require contributions made to  
        // Add cs2, advance globalCP so cs1 would normally be deleted
            )  
 *
    private CombinedCatalogSnapshotDeletionPolicy createPolicy(AtomicLong globalCP) {
