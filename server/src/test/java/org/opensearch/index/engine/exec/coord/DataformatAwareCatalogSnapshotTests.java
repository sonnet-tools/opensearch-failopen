                context + ": segment[" + i + "].formats",
    ) {  
        String directory = "/tmp/" + randomAlphaOfLength(8);
        }
            assertEquals(  
            randomLong(),
        final List<String> events = new ArrayList<>();  
            assertEquals(segments, snapshot.getSegments());  
import java.util.List;  
    }
        return new Segment(generation, dfGrouped);  
        assertEquals(context + ": version", expected.getVersion(), actual.getVersion());  
            snapshot.decRef();  
import java.util.ArrayList;
    private WriterFileSet randomWriterFileSet(String format) {
            0L,
        for (int i = 0; i < formatCount; i++) {
        for (int iter = 0; iter < 100; iter++) {  
        assertTrue(uploadNames.contains("_0.si"));  
        snap1.tryIncRef();
        }  
    }  
            String directory = "/tmp/deserialized";
        assertSnapshotFieldsEqual("copyWriteable", original, copy);
        switch (iter % 6) {  
        snapshot.decRef();
                closeCount.incrementAndGet();
     * Asserts metadata equality between two snapshots, ignoring directory (which is not serialized).  
        DataformatAwareCatalogSnapshot snapshot = new DataformatAwareCatalogSnapshot(42L, 10L, 5L, List.of(), 3L, userData);
                return randomFrom("not-base64!!!", "===", "@@@@", "hello world", "{\"json\":true}");  
    public void testCloseInternalNotCalledOnIntermediateDecRef() {
        WriterFileSet parquetWfs = new WriterFileSet("/tmp/pq", 1L, Set.of("_0.pqt", "_1.pqt"), 100, 0L);
        DataformatAwareCatalogSnapshot snapshot = randomSnapshot();
            assertFalse("closeInternal should not fire while refs remain", closed.get());
    private void assertSnapshotMetadataEqual(
    }
    }
            randomLong(),
import java.util.Map;
                List<WriterFileSet> expected = new ArrayList<>();  
                    String validBase64 = snap.serializeToString();
                byte[] randomBytes = new byte[randomIntBetween(1, 100)];
            int refs = randomIntBetween(1, 20);  
        // Acquire several refs
    public void testRefCounterDelegatesCloseInternalToSubclass() {
        DataformatAwareCatalogSnapshot snapshot = randomSnapshot();
    }  
        List<Segment> segments = new ArrayList<>();  
        snapshot.decRef();
    }  
        assertFalse(snapshot.decRef());  
        assertNull(snapshot.findFileSet("parquet", 99L));
            long version = randomNonNegativeLong();
            long generation = randomNonNegativeLong();  
        snapshot.decRef();  
 * compatible open source license.
            List.of(new Segment(5L, Map.of("parquet", pset))),
    public void testClonedSnapshotHasFreshRefCount() {
        assertEquals(1, deserialized.refCount());  
        for (int i = 0; i < entries; i++) {  
        DataformatAwareCatalogSnapshot snapshot = new DataformatAwareCatalogSnapshot(1L, 1L, 1L, List.of(seg1, seg2), 0L, Map.of());
    }  
        assertEquals(2, original.refCount());
            }
        for (int i = 0; i < extraRefs; i++) {  
        DataformatAwareCatalogSnapshot snapshot = new DataformatAwareCatalogSnapshot(1L, 1L, 1L, List.of(), 0L, Map.of()) {
    }
    public void testTryAcquireRefSucceedsWhenOpen() {
        assertFalse(snapshot.tryIncRef());  
            @Override  
            DataformatAwareCatalogSnapshot original = randomSnapshot();
        DataformatAwareCatalogSnapshot snapshot = new DataformatAwareCatalogSnapshot(1L, 1L, 1L, List.of(), 0L, Map.of("a", "b"));
                DataformatAwareCatalogSnapshot snap = randomSnapshot();
    public void testIsClosedTrueAfterLastDecRef() {
 * SPDX-License-Identifier: Apache-2.0
            1L,
        }
            );
        assertEquals(0, closeCount.get());
            1L,
        snapshot.decRef();
        };
            assertSnapshotFieldsEqual("double round-trip", deserialized, deserialized2);
            files.add(randomAlphaOfLength(6) + "." + randomFrom(extensions));
                return randomAlphaOfLength(10);
        assertTrue(snapshot.isClosed());
        return userData;  
        assertEquals(0, snapshot.refCount());  
 *
import java.util.Collection;
        original.decRef();  
import org.opensearch.index.engine.exec.Segment;
            original,
            files.add(randomAlphaOfLength(6) + "." + randomFrom(extensions));  
            String serialized = original.serializeToString();
            for (String format : expectedSeg.dfGroupedSearchableFiles().keySet()) {
    public void testEachSnapshotHasIndependentRefCounter() {
    }  
        Collection<String> uploadNames = snapshot.getFiles(true);
    public void testGetFilesMultipleSegments() throws Exception {  
        snapshot.tryIncRef();  
    }
                closed.set(true);  
            randomNonNegativeLong(),
        snapshot.decRef();
        }
            assertEquals(1 + refs, snapshot.refCount());
    }  
        DataformatAwareCatalogSnapshot snapshot = new DataformatAwareCatalogSnapshot(1L, 1L, 1L, List.of(), 0L, Map.of());
                return "";
                serialized,
/*  
            expectThrows(IOException.class, () -> DataformatAwareCatalogSnapshot.deserializeFromString(input, key -> "/tmp/test"));
                expectedSeg.dfGroupedSearchableFiles().keySet(),
        DataformatAwareCatalogSnapshot snapshot = new DataformatAwareCatalogSnapshot(1L, 1L, 1L, List.of(), 0L, Map.of());
        for (int i = 0; i < expected.getSegments().size(); i++) {
        long writerGeneration = randomNonNegativeLong();
                assertFalse(snapshot.decRef());  
    }
        return new WriterFileSet(directory, writerGeneration, files, randomIntBetween(0, 10000), 0L);
        return segments;  
    }
                events.add("subclass-closed");
            0L,  
        for (int i = 0; i < fileCount; i++) {
    public void testIsClosedFalseWhileRefsRemain() {
            1L,
                return randomAlphaOfLengthBetween(1, 200);
        Map<String, WriterFileSet> dfGrouped = new HashMap<>();
        );  
        assertEquals(pset, snapshot.findFileSet("parquet", 5L));  
    }
        final java.util.concurrent.atomic.AtomicBoolean closed = new java.util.concurrent.atomic.AtomicBoolean(false);
import java.util.Set;
    }  
            default:  
        assertTrue("closeInternal should fire when last ref is released", closed.get());  
            Segment expectedSeg = expected.getSegments().get(i);  
        assertTrue(snapshot.isClosed());
        }
        snapshot.tryIncRef();  
        }
        DataformatAwareCatalogSnapshot snapshot = randomSnapshot();
        }  
        DataformatAwareCatalogSnapshot snapshot = randomSnapshot();  
        DataformatAwareCatalogSnapshot actual
        }  
            1L,
        snapshot.decRef();
                generation,
            for (int i = 0; i < refs; i++) {
        snapshot.setUserData(Map.of("x", "y"), false);
        assertEquals(2, uploadNames.size());
        snapshot.decRef();
            randomNonNegativeLong(),
     */
            assertEquals(generation, snapshot.getGeneration());
import java.util.HashMap;
        DataformatAwareCatalogSnapshot cloned = snapshot.clone();
        DataformatAwareCatalogSnapshot cloned = original.clone();
 * The OpenSearch Contributors require contributions made to  
    }  
            case 4:
        Map<String, String> userData = new HashMap<>();
        snapshot.decRef();  
        assertEquals(0, snapshot.refCount());
        DataformatAwareCatalogSnapshot deserialized = DataformatAwareCatalogSnapshot.deserializeFromString(serialized, key -> directory);
        assertEquals(1, original.refCount());
        DataformatAwareCatalogSnapshot copy = copyWriteable(  
        assertEquals(1, snapshot.refCount());
        DataformatAwareCatalogSnapshot snapshot = new DataformatAwareCatalogSnapshot(1L, 1L, 1L, List.of(), 0L, Map.of()) {
            );
        assertEquals(2, snapshot.refCount());
            assertSnapshotMetadataEqual("round-trip", original, deserialized);
            }
            }
        assertEquals(context + ": userData", expected.getUserData(), actual.getUserData());
        );
        DataformatAwareCatalogSnapshot snapshot = randomSnapshot();  
        snapshot.decRef();  
                actualSeg.dfGroupedSearchableFiles().keySet()  
    private Segment randomSegment() {
        Map<String, WriterFileSet> dfGrouped = new HashMap<>();
    }  
        original.tryIncRef();
        assertEquals(context + ": id", expected.getId(), actual.getId());
        DataformatAwareCatalogSnapshot expected,
                version,  
            new NamedWriteableRegistry(Collections.emptyList()),
                } catch (IOException e) {  
        }
        final java.util.concurrent.atomic.AtomicInteger closeCount = new java.util.concurrent.atomic.AtomicInteger(0);
            randomNonNegativeLong(),  
    public void testDeserializationRejectsInvalidInput() {
    }
            assertTrue(snapshot.getSearchableFiles("nonexistent_" + randomAlphaOfLength(5)).isEmpty());
        return new DataformatAwareCatalogSnapshot(  
    }  
        assertTrue(snapshot.tryIncRef());  
        DataformatAwareCatalogSnapshot snapshot = new DataformatAwareCatalogSnapshot(1L, 1L, 1L, List.of(), 0L, Map.of()) {  
        assertEquals(0, snap2.refCount());
        assertEquals(List.of("subclass-closed"), events);
                reserialized,
    }
        // Release all but one — closeInternal must NOT fire
        assertTrue(snapshot.decRef());  
/**
        DataformatAwareCatalogSnapshot original = randomSnapshot();  
        String directory = "/tmp/" + randomAlphaOfLength(8);
        original.decRef();  
            }  
        DataformatAwareCatalogSnapshot original = randomSnapshotWithDirectory(directory);
            }
        snapshot.tryIncRef();  
 * this file be licensed under the Apache-2.0 license or a
        for (int iter = 0; iter < 100; iter++) {
                assertEquals(context + ": numRows", expectedWfs.numRows(), actualWfs.numRows());
        assertEquals(2, snap1.refCount());
        int extraRefs = randomIntBetween(1, 10);  
        int count = randomIntBetween(0, 5);
            assertEquals(context + ": segment[" + i + "].generation", expectedSeg.generation(), actualSeg.generation());
        DataformatAwareCatalogSnapshot snapshot = randomSnapshot();  
    }
            long lastWriterGeneration = randomNonNegativeLong();  
public class DataformatAwareCatalogSnapshotTests extends OpenSearchTestCase {
    public void testIsClosedAfterCloneIndependent() {
        return new DataformatAwareCatalogSnapshot(
            case 3:  
        original.decRef();  
            0L,
                    return "AAAA";
        Collection<String> uploadNames = snapshot.getFiles(true);
        assertEquals(2, original.refCount());  
 * Tests for {@link DataformatAwareCatalogSnapshot}.
    private DataformatAwareCatalogSnapshot randomSnapshotWithDirectory(String directory) {
            Map.of()
        assertEquals(0, snapshot.refCount());
                WriterFileSet actualWfs = actualSeg.dfGroupedSearchableFiles().get(format);
        assertEquals(1, snapshot.refCount());
            @Override
    public void testCloseInternalCalledOnceAtZeroRefCount() {  
        original.decRef();
        assertEquals(5L, cloned.getVersion());  
        assertFalse(snapshot.tryIncRef());
        DataformatAwareCatalogSnapshot snapshot = new DataformatAwareCatalogSnapshot(1L, 1L, 1L, List.of(segment), 0L, Map.of());
        }
                snapshot.tryIncRef();
    /**
        assertNull(snapshot.findFileSet("parquet", 5L));
            snapshot.decRef();  
        assertEquals(Map.of("a", "b"), snapshot.getUserData());  
        assertEquals(10L, cloned.getGeneration());
    private DataformatAwareCatalogSnapshot randomSnapshot() {  
            assertEquals(version, snapshot.getVersion());
                    if (wfs != null) expected.add(wfs);  
        DataformatAwareCatalogSnapshot snapshot = randomSnapshot();  
    public void testRefCounterSurvivesMultipleIncDecCycles() {
                userData  
        DataformatAwareCatalogSnapshot snap1 = randomSnapshot();
        for (int i = 0; i < extraRefs; i++) {
        }  
        snap2.decRef();  
    }
            randomNonNegativeLong(),  
        Collection<String> uploadNames = snapshot.getFiles(true);
        WriterFileSet pset = new WriterFileSet("/tmp/pq", 5L, Set.of("f.parquet"), 100, 0L);  
        assertEquals(1, closeCount.get());
            }  
            randomNonNegativeLong(),  
    public void testSetUserDataUpdatesAndReturns() {
            protected void closeInternal() {
        WriterFileSet luceneWfs = new WriterFileSet("/tmp/lc", 1L, Set.of("_0.cfe", "_0.si"), 50, 0L);  
        DataformatAwareCatalogSnapshot snapshot = randomSnapshot();
    public void testInitialRefCountIsOne() {  
        assertEquals(0, closeCount.get());
        assertEquals(2, snapshot.refCount());
    private Map<String, String> randomUserData() {  
            segments.add(randomSegment());
        long generation = randomNonNegativeLong();
        }
        assertEquals(context + ": lastWriterGeneration", expected.getLastWriterGeneration(), actual.getLastWriterGeneration());
    }
        assertEquals(0L, snapshot.getFormatVersionForFile("any_file.pqt"));
                assertEquals(expected, new ArrayList<>(snapshot.getSearchableFiles(format)));
    }
                key -> directory
            1L,
            expectThrows(UnsupportedOperationException.class, () -> snapshot.getSegments().add(randomSegment()));
        assertTrue(uploadNames.contains("parquet/_1.pqt"));
    }
            1L,  
    private List<Segment> randomSegments() {  
            userData.put(randomAlphaOfLength(5), randomAlphaOfLength(10));
        assertEquals(1, deserialized.refCount());
        for (int i = 0; i < extraRefs; i++) {
        Set<String> files = new HashSet<>();  
    public void testReleaseRefDecrementsAndTriggersCloseAtZero() {
        DataformatAwareCatalogSnapshot cloned = original.clone();
 */  
            List<Segment> segments = randomSegments();
    public void testDeserializedSnapshotHasIndependentRefCounter() throws Exception {  
                id,
                random().nextBytes(randomBytes);
    public void testTryIncRefFailsAfterClosed() {
    private String generateInvalidInput(int iter) {
        long generation = randomNonNegativeLong();
                assertEquals(context + ": writerGeneration", expectedWfs.writerGeneration(), actualWfs.writerGeneration());
    }
        assertTrue(snapshot.isClosed());
    }  
        }
            );  
    public void testSnapshotFieldAccessConsistency() {  
        Segment seg2 = new Segment(2L, Map.of("parquet", wfs2));
    private WriterFileSet randomWriterFileSetWithDirectory(String format, String directory) {  
        String serialized = original.serializeToString();  
    }
        assertEquals(userData, cloned.getUserData());  
        assertTrue(uploadNames.isEmpty());  
import java.util.Collections;  
    }  
    }  
        assertTrue(snapshot.decRef());
            Map<String, String> userData = randomUserData();
            String reserialized = deserialized.serializeToString();  
        cloned.decRef();
            1L,  
        snapshot.decRef();
                lastWriterGeneration,
        assertEquals(3, snapshot.refCount());
        for (int i = 0; i < extraRefs; i++) {
        int fileCount = randomIntBetween(1, 5);
        DataformatAwareCatalogSnapshot snapshot = randomSnapshot();  
        assertTrue(uploadNames.contains("_0.cfe"));
                    return validBase64.substring(0, randomIntBetween(1, Math.max(1, validBase64.length() / 2)));
        int entries = randomIntBetween(0, 4);
        cloned.decRef();
            snapshot.tryIncRef();
        int fileCount = randomIntBetween(1, 5);
    public void testIsClosedInitiallyFalse() {
            1L,  
    // --- findFileSet ---  
            randomSegmentsWithDirectory(directory),
        assertEquals(42L, cloned.getId());
        int count = randomIntBetween(0, 5);
        snap1.decRef();
        // Each has its own ref counter starting at 1
        List<Segment> segments = new ArrayList<>();
            dfGrouped.put(format, randomWriterFileSetWithDirectory(format, directory));
    }
        deserialized.decRef();
 */  
            for (Segment seg : segments) {
    public void testGetUploadFileNamesProducesFormatSlashFile() throws Exception {  
        );
        assertEquals(context + ": segments", expected.getSegments(), actual.getSegments());  
        assertTrue(events.isEmpty());
        }
        String directory = "/tmp/" + randomAlphaOfLength(8);
        snapshot.decRef();
        for (int i = 0; i < formatCount; i++) {
        assertEquals(4, uploadNames.size());
        // Release the last ref — now it fires
    }
    }
        DataformatAwareCatalogSnapshot snapshot = new DataformatAwareCatalogSnapshot(  
        }  
            String input = generateInvalidInput(iter);
        snapshot.tryIncRef();  
            DataformatAwareCatalogSnapshot deserialized2 = DataformatAwareCatalogSnapshot.deserializeFromString(
        return new Segment(generation, dfGrouped);  
            assertFalse("isClosed should be false while refs remain", snapshot.isClosed());
            randomUserData()
        );
        original.decRef();
            in -> new DataformatAwareCatalogSnapshot(in, key -> directory)  
    // --- helpers ---
        // Verifies the anonymous AbstractRefCounted bridge calls the subclass closeInternal, not a default
    public void testFindFileSet_noMatchingGeneration_returnsNull() {  
        assertTrue(cloned.isClosed());
        assertFalse(cloned.isClosed());
        assertFalse(snapshot.tryIncRef());  
        Segment segment = new Segment(1L, Map.of("parquet", parquetWfs, "lucene", luceneWfs));
        return segments;
        Segment seg1 = new Segment(1L, Map.of("parquet", wfs1));  
                    WriterFileSet wfs = seg.dfGroupedSearchableFiles().get(format);
            case 1:  
    public void testGetFilesEmptySegments() throws Exception {  
        Map<String, String> userData = Map.of("key1", "val1", "key2", "val2");  
        assertEquals(0, closeCount.get());
    }
    private Segment randomSegmentWithDirectory(String directory) {
        int formatCount = randomIntBetween(1, 2);  
        // With no segments, getFormatVersionForFile returns 0L (pre-versioning / unknown).  
        assertTrue(snapshot.decRef());  
        DataformatAwareCatalogSnapshot snapshot = randomSnapshot();  
        assertEquals(context + ": generation", expected.getGeneration(), actual.getGeneration());
import org.opensearch.index.engine.exec.WriterFileSet;  
package org.opensearch.index.engine.exec.coord;
            protected void closeInternal() {  
        for (int i = 0; i < count; i++) {
            randomUserData()  
            List.of(new Segment(5L, Map.of("parquet", pset))),  
        for (int i = 0; i < fileCount; i++) {
        }  
        for (int cycle = 0; cycle < 10; cycle++) {
        assertEquals(context + ": userData", expected.getUserData(), actual.getUserData());
        assertEquals(context + ": lastWriterGeneration", expected.getLastWriterGeneration(), actual.getLastWriterGeneration());
        long writerGeneration = randomNonNegativeLong();  
        assertFalse(snapshot.isClosed());
    public void testAcquireRefIncrementsCount() {
        assertEquals(2, snapshot.refCount());
        assertEquals(Map.of("x", "y"), snapshot.getUserData());
        );
            DataformatAwareCatalogSnapshot snapshot = new DataformatAwareCatalogSnapshot(  
            randomNonNegativeLong(),
            for (String format : expectedFormats) {
        assertTrue(uploadNames.contains("parquet/_0.pqt"));  
        assertEquals(1, cloned.refCount());
        DataformatAwareCatalogSnapshot snapshot = new DataformatAwareCatalogSnapshot(
        assertTrue(uploadNames.contains("parquet/_1.pqt"));
    }
    }  
    public void testClonePreservesUserData() {
import org.opensearch.test.OpenSearchTestCase;
                key -> directory  
                segments,
        assertEquals(context + ": segment count", expected.getSegments().size(), actual.getSegments().size());
        int formatCount = randomIntBetween(1, 2);  
        // Lucene files: plain names "_0.cfe", "_0.si" (FileMetadata.serialize() omits "lucene/" prefix)
            assertEquals(lastWriterGeneration, snapshot.getLastWriterGeneration());
        };
        WriterFileSet wfs1 = new WriterFileSet("/tmp/pq", 1L, Set.of("_0.pqt"), 10, 0L);
        WriterFileSet pset = new WriterFileSet("/tmp/pq", 5L, Set.of("f.parquet"), 100, 0L);
        assertEquals(1, snapshot.refCount());
        };  
            assertEquals(userData, snapshot.getUserData());
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            assertEquals(1, snapshot.refCount());
    public void testCopyWriteable() throws Exception {  
        for (int iter = 0; iter < 100; iter++) {  
    }
                return randomFrom("null", "undefined", "None", "nil", "NaN");
            randomSegments(),
    private List<Segment> randomSegmentsWithDirectory(String directory) {
    }
        String context,  
    public void testGetFormatVersionForFileReturnsLuceneMajor() {
                for (Segment seg : segments) {
            Map.of()
        snapshot.decRef();  
            Segment actualSeg = actual.getSegments().get(i);
        DataformatAwareCatalogSnapshot snap2 = randomSnapshot();  
    }  
        // Build a snapshot with known segments and files
        original.tryIncRef();
            String format = randomFrom("lucene", "parquet");  
            dfGrouped.put(format, randomWriterFileSet(format));
                assertEquals(context + ": files", expectedWfs.files(), actualWfs.files());  
        return new WriterFileSet(directory, writerGeneration, files, randomIntBetween(0, 10000), 0L);
            }  
    public void testFindFileSet_skipsEmptyFiles_returnsNull() {
                WriterFileSet expectedWfs = expectedSeg.dfGroupedSearchableFiles().get(format);  
        snap1.decRef();
        int extraRefs = randomIntBetween(2, 10);
            // Directory is not serialized; pass a placeholder for deserialization
        assertTrue(uploadNames.contains("parquet/_0.pqt"));  
            case 0:
            for (int i = 0; i < refs; i++) {
            assertEquals(id, snapshot.getId());  
            snapshot.tryIncRef();
        assertEquals(1, snap2.refCount());
            DataformatAwareCatalogSnapshot deserialized = DataformatAwareCatalogSnapshot.deserializeFromString(  
            String format = randomFrom("lucene", "parquet");  
    public void testSerializationRoundTrip() throws Exception {
        assertEquals(context + ": id", expected.getId(), actual.getId());  
        assertEquals(context + ": version", expected.getVersion(), actual.getVersion());
        WriterFileSet empty = new WriterFileSet("/tmp/pq", 5L, Set.of(), 0, 0L);
            segments.add(randomSegmentWithDirectory(directory));
        snapshot.tryIncRef();
            Map.of()  
        }  
        DataformatAwareCatalogSnapshot original = randomSnapshotWithDirectory(directory);
    }  
        snapshot.decRef();
        // Parquet files: "parquet/_0.pqt", "parquet/_1.pqt"  
            }
            long id = randomLong();
                return java.util.Base64.getEncoder().encodeToString(randomBytes);  
    public void testTryAcquireRefFailsWhenClosed() {
        DataformatAwareCatalogSnapshot snapshot = new DataformatAwareCatalogSnapshot(
            List.of(new Segment(5L, Map.of("parquet", empty))),
            assertEquals(expectedFormats, snapshot.getDataFormats());  
import java.io.IOException;  
        String[] extensions = "lucene".equals(format) ? new String[] { "cfs", "si", "dat" } : new String[] { "parquet" };
                }
            );
    }
        snapshot.decRef();
}
        Set<String> files = new HashSet<>();
        assertFalse(snapshot.isClosed());
    private void assertSnapshotFieldsEqual(String context, DataformatAwareCatalogSnapshot expected, DataformatAwareCatalogSnapshot actual) {
            Set<String> expectedFormats = new HashSet<>();
    }  
        assertEquals(2, snap1.refCount());  
            1L,
            case 2:
        WriterFileSet wfs2 = new WriterFileSet("/tmp/pq", 2L, Set.of("_1.pqt"), 20, 0L);
import java.util.HashSet;
                expectedFormats.addAll(seg.dfGroupedSearchableFiles().keySet());  
    public void testFindFileSet_matchesGeneration() {
            protected void closeInternal() {
            case 5:
        assertEquals(context + ": generation", expected.getGeneration(), actual.getGeneration());
                }
        );
        assertTrue(original.isClosed());
        for (int i = 0; i < count; i++) {  
        assertEquals(2, original.refCount());  
        String[] extensions = "lucene".equals(format) ? new String[] { "cfs", "si", "dat" } : new String[] { "parquet" };  
        DataformatAwareCatalogSnapshot original = randomSnapshot();  
            @Override
                try {  
        assertEquals(1, snapshot.refCount());
