        assertEquals(2, original.refCount());
        assertFalse(snapshot.tryIncRef());
        assertFalse(snapshot.isClosed());
            files.add(randomAlphaOfLength(6) + "." + randomFrom(extensions));
        Map<String, WriterFileSet> dfGrouped = new HashMap<>();
            new NamedWriteableRegistry(Collections.emptyList()),
        assertEquals(Map.of("a", "b"), snapshot.getUserData());
            1L,
        assertTrue(snapshot.decRef());
        assertEquals(5L, cloned.getVersion());
/**
            }
    }
        assertTrue(snapshot.decRef());
                return randomAlphaOfLengthBetween(1, 200);
    }
        String serialized = original.serializeToString();
        DataformatAwareCatalogSnapshot snapshot = new DataformatAwareCatalogSnapshot(
                snapshot.tryIncRef();
    public void testGetFilesMultipleSegments() throws Exception {
                return java.util.Base64.getEncoder().encodeToString(randomBytes);
    private String generateInvalidInput(int iter) {
        }
        original.tryIncRef();
    public void testFindFileSet_noMatchingGeneration_returnsNull() {
        snapshot.decRef();
import java.util.Set;
        assertEquals(context + ": segments", expected.getSegments(), actual.getSegments());
    public void testIsClosedAfterCloneIndependent() {
        // Release the last ref — now it fires
            String input = generateInvalidInput(iter);
        Collection<String> uploadNames = snapshot.getFiles(true);
            userData.put(randomAlphaOfLength(5), randomAlphaOfLength(10));
            }
            case 4:
            randomSegments(),
        assertTrue(uploadNames.isEmpty());
        final java.util.concurrent.atomic.AtomicBoolean closed = new java.util.concurrent.atomic.AtomicBoolean(false);
        DataformatAwareCatalogSnapshot snapshot = randomSnapshot();
    public void testAcquireRefIncrementsCount() {
        snapshot.tryIncRef();
        snapshot.decRef();
        original.decRef();
        assertFalse(snapshot.tryIncRef());
        assertEquals(1, snap2.refCount());
        int fileCount = randomIntBetween(1, 5);
            assertEquals(userData, snapshot.getUserData());
            assertEquals(segments, snapshot.getSegments());
        }
        original.decRef();
        Collection<String> uploadNames = snapshot.getFiles(true);
            Map.of()
                random().nextBytes(randomBytes);
        // Parquet files: "parquet/_0.pqt", "parquet/_1.pqt"
            case 0:
        WriterFileSet pset = new WriterFileSet("/tmp/pq", 5L, Set.of("f.parquet"), 100, 0L);
    }
        assertTrue(uploadNames.contains("_0.cfe"));
        assertTrue(snapshot.isClosed());
        assertEquals(0, closeCount.get());
                DataformatAwareCatalogSnapshot snap = randomSnapshot();
        assertTrue(uploadNames.contains("parquet/_1.pqt"));
        assertEquals(10L, cloned.getGeneration());
        assertEquals(pset, snapshot.findFileSet("parquet", 5L));
     * Asserts metadata equality between two snapshots, ignoring directory (which is not serialized).
        assertFalse(snapshot.tryIncRef());
    }
import java.util.ArrayList;
    }
public class DataformatAwareCatalogSnapshotTests extends OpenSearchTestCase {
        long generation = randomNonNegativeLong();
    }
        DataformatAwareCatalogSnapshot cloned = original.clone();
            String directory = "/tmp/deserialized";
        assertEquals(0, closeCount.get());
            case 1:
    }
        snapshot.tryIncRef();
    public void testCloseInternalCalledOnceAtZeroRefCount() {
        for (int i = 0; i < extraRefs; i++) {
                try {
        }
        WriterFileSet wfs2 = new WriterFileSet("/tmp/pq", 2L, Set.of("_1.pqt"), 20, 0L);
                actualSeg.dfGroupedSearchableFiles().keySet()
        Collection<String> uploadNames = snapshot.getFiles(true);
        assertTrue("closeInternal should fire when last ref is released", closed.get());
        DataformatAwareCatalogSnapshot snapshot = randomSnapshot();
    public void testIsClosedFalseWhileRefsRemain() {
            dfGrouped.put(format, randomWriterFileSetWithDirectory(format, directory));
    }
        int fileCount = randomIntBetween(1, 5);
        int count = randomIntBetween(0, 5);
        DataformatAwareCatalogSnapshot snapshot = new DataformatAwareCatalogSnapshot(1L, 1L, 1L, List.of(), 0L, Map.of()) {
/*
        final List<String> events = new ArrayList<>();
            long id = randomLong();
        String directory = "/tmp/" + randomAlphaOfLength(8);
import org.opensearch.test.OpenSearchTestCase;
        };
        DataformatAwareCatalogSnapshot cloned = snapshot.clone();
            Segment expectedSeg = expected.getSegments().get(i);
        DataformatAwareCatalogSnapshot snapshot = new DataformatAwareCatalogSnapshot(1L, 1L, 1L, List.of(segment), 0L, Map.of());
        DataformatAwareCatalogSnapshot original = randomSnapshotWithDirectory(directory);
            case 2:
        for (int i = 0; i < count; i++) {
        DataformatAwareCatalogSnapshot snapshot = randomSnapshot();
    }
    }
        return userData;
        snapshot.decRef();
        for (int i = 0; i < count; i++) {
            long version = randomNonNegativeLong();
        assertTrue(snapshot.decRef());
            randomNonNegativeLong(),
        }
            );
import java.util.HashMap;
import java.util.HashSet;
        for (int i = 0; i < fileCount; i++) {
 * The OpenSearch Contributors require contributions made to
        for (int i = 0; i < fileCount; i++) {
            for (String format : expectedFormats) {
            }
            files.add(randomAlphaOfLength(6) + "." + randomFrom(extensions));
        DataformatAwareCatalogSnapshot snap2 = randomSnapshot();
            1L,
        for (int i = 0; i < extraRefs; i++) {
            List.of(new Segment(5L, Map.of("parquet", pset))),
                assertEquals(expected, new ArrayList<>(snapshot.getSearchableFiles(format)));
    }
        Segment segment = new Segment(1L, Map.of("parquet", parquetWfs, "lucene", luceneWfs));
        DataformatAwareCatalogSnapshot snapshot = randomSnapshot();
                assertFalse(snapshot.decRef());
            randomUserData()
            0L,
                key -> directory
        Map<String, String> userData = new HashMap<>();
            default:
                WriterFileSet expectedWfs = expectedSeg.dfGroupedSearchableFiles().get(format);
        switch (iter % 6) {
    private Segment randomSegment() {
        assertTrue(uploadNames.contains("parquet/_0.pqt"));
        assertEquals(context + ": generation", expected.getGeneration(), actual.getGeneration());
        DataformatAwareCatalogSnapshot snapshot = new DataformatAwareCatalogSnapshot(1L, 1L, 1L, List.of(), 0L, Map.of());
        assertEquals(1, deserialized.refCount());
        assertTrue(uploadNames.contains("_0.si"));
        snapshot.decRef();
    }
 * this file be licensed under the Apache-2.0 license or a
            long lastWriterGeneration = randomNonNegativeLong();
                    WriterFileSet wfs = seg.dfGroupedSearchableFiles().get(format);
        DataformatAwareCatalogSnapshot snapshot = new DataformatAwareCatalogSnapshot(1L, 1L, 1L, List.of(), 0L, Map.of());
        int formatCount = randomIntBetween(1, 2);
        assertTrue(uploadNames.contains("parquet/_1.pqt"));
            expectThrows(IOException.class, () -> DataformatAwareCatalogSnapshot.deserializeFromString(input, key -> "/tmp/test"));
    public void testCopyWriteable() throws Exception {
        assertEquals(0, closeCount.get());
            snapshot.decRef();
            List<Segment> segments = randomSegments();
    }
            dfGrouped.put(format, randomWriterFileSet(format));
    }
        }
            assertEquals(expectedFormats, snapshot.getDataFormats());
        DataformatAwareCatalogSnapshot snapshot = new DataformatAwareCatalogSnapshot(1L, 1L, 1L, List.of(), 0L, Map.of()) {
        assertEquals(1, snapshot.refCount());
        assertEquals(4, uploadNames.size());
            assertFalse("closeInternal should not fire while refs remain", closed.get());
        assertEquals(1, original.refCount());
        cloned.decRef();
                return "";
            @Override
    }
        assertEquals(context + ": generation", expected.getGeneration(), actual.getGeneration());
        );
    }
    public void testDeserializedSnapshotHasIndependentRefCounter() throws Exception {
            Map.of()
        assertTrue(events.isEmpty());
        assertTrue(cloned.isClosed());
        assertEquals(context + ": version", expected.getVersion(), actual.getVersion());
            for (String format : expectedSeg.dfGroupedSearchableFiles().keySet()) {
        };
        original.tryIncRef();
    }
    private DataformatAwareCatalogSnapshot randomSnapshotWithDirectory(String directory) {
        snapshot.decRef();
    }
    }
    ) {
        List<Segment> segments = new ArrayList<>();
                assertEquals(context + ": numRows", expectedWfs.numRows(), actualWfs.numRows());
    }
                byte[] randomBytes = new byte[randomIntBetween(1, 100)];
        WriterFileSet luceneWfs = new WriterFileSet("/tmp/lc", 1L, Set.of("_0.cfe", "_0.si"), 50, 0L);
                assertEquals(context + ": files", expectedWfs.files(), actualWfs.files());
        cloned.decRef();
        }
    public void testTryAcquireRefFailsWhenClosed() {
                    return validBase64.substring(0, randomIntBetween(1, Math.max(1, validBase64.length() / 2)));
                reserialized,
    public void testGetFormatVersionForFileReturnsLuceneMajor() {
        assertTrue(uploadNames.contains("parquet/_0.pqt"));
        }
        snapshot.decRef();
        snap1.tryIncRef();
        DataformatAwareCatalogSnapshot snapshot = randomSnapshot();
            assertEquals(
        assertEquals(context + ": userData", expected.getUserData(), actual.getUserData());
        }
        for (int i = 0; i < extraRefs; i++) {
    public void testCloseInternalNotCalledOnIntermediateDecRef() {
        }
    public void testInitialRefCountIsOne() {
        DataformatAwareCatalogSnapshot snapshot = new DataformatAwareCatalogSnapshot(42L, 10L, 5L, List.of(), 3L, userData);
        final java.util.concurrent.atomic.AtomicInteger closeCount = new java.util.concurrent.atomic.AtomicInteger(0);
            protected void closeInternal() {
            List.of(new Segment(5L, Map.of("parquet", empty))),
            long generation = randomNonNegativeLong();
            protected void closeInternal() {
            Segment actualSeg = actual.getSegments().get(i);
            randomNonNegativeLong(),
            }
        // Build a snapshot with known segments and files
        return new WriterFileSet(directory, writerGeneration, files, randomIntBetween(0, 10000), 0L);
        DataformatAwareCatalogSnapshot snapshot = new DataformatAwareCatalogSnapshot(1L, 1L, 1L, List.of(), 0L, Map.of()) {
        assertEquals(List.of("subclass-closed"), events);
        for (int iter = 0; iter < 100; iter++) {
        }
        assertEquals(1, snapshot.refCount());
        snapshot.tryIncRef();
    public void testRefCounterSurvivesMultipleIncDecCycles() {
        assertEquals(42L, cloned.getId());
                serialized,
    public void testIsClosedInitiallyFalse() {
import org.opensearch.index.engine.exec.WriterFileSet;
        Set<String> files = new HashSet<>();
        assertEquals(context + ": lastWriterGeneration", expected.getLastWriterGeneration(), actual.getLastWriterGeneration());
    }
            randomUserData()
                segments,
        for (int cycle = 0; cycle < 10; cycle++) {
    }
    }
            Map.of()
        for (int i = 0; i < formatCount; i++) {
    }
    // --- helpers ---
    public void testFindFileSet_matchesGeneration() {
    private Map<String, String> randomUserData() {
        Map<String, WriterFileSet> dfGrouped = new HashMap<>();
    /**
        original.decRef();
        long writerGeneration = randomNonNegativeLong();
            String format = randomFrom("lucene", "parquet");
            assertFalse("isClosed should be false while refs remain", snapshot.isClosed());
        DataformatAwareCatalogSnapshot snapshot = randomSnapshot();
            assertEquals(lastWriterGeneration, snapshot.getLastWriterGeneration());
        WriterFileSet wfs1 = new WriterFileSet("/tmp/pq", 1L, Set.of("_0.pqt"), 10, 0L);
            DataformatAwareCatalogSnapshot snapshot = new DataformatAwareCatalogSnapshot(
        int extraRefs = randomIntBetween(1, 10);
        deserialized.decRef();
        assertNull(snapshot.findFileSet("parquet", 99L));
        );
        for (int i = 0; i < formatCount; i++) {
            expectThrows(UnsupportedOperationException.class, () -> snapshot.getSegments().add(randomSegment()));
    // --- findFileSet ---
        Segment seg1 = new Segment(1L, Map.of("parquet", wfs1));
    private DataformatAwareCatalogSnapshot randomSnapshot() {
            @Override
                expectedFormats.addAll(seg.dfGroupedSearchableFiles().keySet());
        for (int i = 0; i < extraRefs; i++) {
        int formatCount = randomIntBetween(1, 2);
            case 3:
        assertEquals(2, snapshot.refCount());
                for (Segment seg : segments) {
        snapshot.decRef();
        assertEquals(context + ": segment count", expected.getSegments().size(), actual.getSegments().size());
        return new DataformatAwareCatalogSnapshot(
    private WriterFileSet randomWriterFileSet(String format) {
    }
    private void assertSnapshotFieldsEqual(String context, DataformatAwareCatalogSnapshot expected, DataformatAwareCatalogSnapshot actual) {
package org.opensearch.index.engine.exec.coord;
        assertEquals(1, deserialized.refCount());
import java.util.Map;
        DataformatAwareCatalogSnapshot snapshot = randomSnapshot();
        assertEquals(0, snap2.refCount());
            assertEquals(generation, snapshot.getGeneration());
    public void testTryAcquireRefSucceedsWhenOpen() {
                WriterFileSet actualWfs = actualSeg.dfGroupedSearchableFiles().get(format);
        for (int i = 0; i < entries; i++) {
            randomNonNegativeLong(),
 * SPDX-License-Identifier: Apache-2.0
                closeCount.incrementAndGet();
        Map<String, String> userData = Map.of("key1", "val1", "key2", "val2");
                expectedSeg.dfGroupedSearchableFiles().keySet(),
        String context,
                key -> directory
        snap1.decRef();
        DataformatAwareCatalogSnapshot snapshot = new DataformatAwareCatalogSnapshot(
        assertEquals(0, snapshot.refCount());
        // Acquire several refs
                return randomAlphaOfLength(10);
            assertSnapshotFieldsEqual("double round-trip", deserialized, deserialized2);
        return new Segment(generation, dfGrouped);
        DataformatAwareCatalogSnapshot copy = copyWriteable(
            int refs = randomIntBetween(1, 20);
        snap1.decRef();
    public void testIsClosedTrueAfterLastDecRef() {
        for (int i = 0; i < expected.getSegments().size(); i++) {
        DataformatAwareCatalogSnapshot expected,
        DataformatAwareCatalogSnapshot snapshot = new DataformatAwareCatalogSnapshot(1L, 1L, 1L, List.of(seg1, seg2), 0L, Map.of());
                    return "AAAA";
                id,
        }
        String directory = "/tmp/" + randomAlphaOfLength(8);
            original,
        snapshot.decRef();
            String format = randomFrom("lucene", "parquet");
            randomNonNegativeLong(),
        assertTrue(snapshot.isClosed());
                generation,
        assertEquals(0L, snapshot.getFormatVersionForFile("any_file.pqt"));
        }
            randomNonNegativeLong(),
    public void testGetUploadFileNamesProducesFormatSlashFile() throws Exception {
                version,
            assertEquals(1, snapshot.refCount());
        );
        assertEquals(2, snap1.refCount());
    private List<Segment> randomSegmentsWithDirectory(String directory) {
                userData
        assertEquals(1, snapshot.refCount());
            }
        };
    }
 */
            for (Segment seg : segments) {
    }
        snapshot.setUserData(Map.of("x", "y"), false);
        return segments;
            for (int i = 0; i < refs; i++) {
        assertEquals(2, snapshot.refCount());
        int extraRefs = randomIntBetween(2, 10);
            1L,
        assertEquals(2, snap1.refCount());
    public void testClonedSnapshotHasFreshRefCount() {
    private void assertSnapshotMetadataEqual(
                List<WriterFileSet> expected = new ArrayList<>();
            for (int i = 0; i < refs; i++) {
    public void testRefCounterDelegatesCloseInternalToSubclass() {
        assertTrue(snapshot.tryIncRef());
        int entries = randomIntBetween(0, 4);
        assertEquals(1, snapshot.refCount());
import java.io.IOException;
        snapshot.tryIncRef();
        long generation = randomNonNegativeLong();
            1L,
            DataformatAwareCatalogSnapshot deserialized = DataformatAwareCatalogSnapshot.deserializeFromString(
        assertEquals(context + ": id", expected.getId(), actual.getId());
        DataformatAwareCatalogSnapshot original = randomSnapshot();
        int count = randomIntBetween(0, 5);
    }
        DataformatAwareCatalogSnapshot original = randomSnapshot();
        Set<String> files = new HashSet<>();
        snapshot.decRef();
            // Directory is not serialized; pass a placeholder for deserialization
        for (int iter = 0; iter < 100; iter++) {
    }
        String[] extensions = "lucene".equals(format) ? new String[] { "cfs", "si", "dat" } : new String[] { "parquet" };
        original.decRef();
            protected void closeInternal() {
        }
        snapshot.tryIncRef();
    public void testGetFilesEmptySegments() throws Exception {
        assertEquals(1, closeCount.get());
            assertSnapshotMetadataEqual("round-trip", original, deserialized);
        assertFalse(snapshot.decRef());
        // Each has its own ref counter starting at 1
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            0L,
    }
    }
            assertEquals(context + ": segment[" + i + "].generation", expectedSeg.generation(), actualSeg.generation());
            Map<String, String> userData = randomUserData();
            }
        assertEquals(Map.of("x", "y"), snapshot.getUserData());
        );
                closed.set(true);
    private WriterFileSet randomWriterFileSetWithDirectory(String format, String directory) {
                return randomFrom("not-base64!!!", "===", "@@@@", "hello world", "{\"json\":true}");
        assertEquals(context + ": version", expected.getVersion(), actual.getVersion());
        assertFalse(snapshot.isClosed());
        DataformatAwareCatalogSnapshot cloned = original.clone();
        assertEquals(2, snapshot.refCount());
        WriterFileSet parquetWfs = new WriterFileSet("/tmp/pq", 1L, Set.of("_0.pqt", "_1.pqt"), 100, 0L);
            case 5:
        snapshot.decRef();
            snapshot.tryIncRef();
                } catch (IOException e) {
                events.add("subclass-closed");
            assertTrue(snapshot.getSearchableFiles("nonexistent_" + randomAlphaOfLength(5)).isEmpty());
        DataformatAwareCatalogSnapshot snapshot = randomSnapshot();
            @Override
            assertEquals(id, snapshot.getId());
import org.opensearch.index.engine.exec.Segment;
        }
            randomNonNegativeLong(),
        }
    }
        // With no segments, getFormatVersionForFile returns 0L (pre-versioning / unknown).
        assertEquals(3, snapshot.refCount());
        // Release all but one — closeInternal must NOT fire
                }
    }
    public void testClonePreservesUserData() {
    public void testSerializationRoundTrip() throws Exception {
    }
    public void testSnapshotFieldAccessConsistency() {
        List<Segment> segments = new ArrayList<>();
            1L,
        snap2.decRef();
            DataformatAwareCatalogSnapshot original = randomSnapshot();
import java.util.Collections;
        );
    private List<Segment> randomSegments() {
    }
                return randomFrom("null", "undefined", "None", "nil", "NaN");
    }
import java.util.Collection;
            List.of(new Segment(5L, Map.of("parquet", pset))),
import java.util.List;
            }
        original.decRef();
        assertEquals(context + ": id", expected.getId(), actual.getId());
    public void testDeserializationRejectsInvalidInput() {
        snapshot.decRef();
            1L,
        assertEquals(2, uploadNames.size());
            );
        assertEquals(userData, cloned.getUserData());
        snapshot.decRef();
            in -> new DataformatAwareCatalogSnapshot(in, key -> directory)
        Segment seg2 = new Segment(2L, Map.of("parquet", wfs2));
        assertSnapshotFieldsEqual("copyWriteable", original, copy);
        assertFalse(cloned.isClosed());
        assertEquals(1, cloned.refCount());
            snapshot.tryIncRef();
            segments.add(randomSegmentWithDirectory(directory));
            snapshot.decRef();
    public void testSetUserDataUpdatesAndReturns() {
    }
}
        DataformatAwareCatalogSnapshot snapshot = randomSnapshot();
        }
                }
    public void testTryIncRefFailsAfterClosed() {
        assertTrue(snapshot.isClosed());
        assertEquals(0, snapshot.refCount());
        long writerGeneration = randomNonNegativeLong();
                assertEquals(context + ": writerGeneration", expectedWfs.writerGeneration(), actualWfs.writerGeneration());
    }
            1L,
        DataformatAwareCatalogSnapshot deserialized = DataformatAwareCatalogSnapshot.deserializeFromString(serialized, key -> directory);
 *
        assertEquals(0, snapshot.refCount());
        DataformatAwareCatalogSnapshot snapshot = randomSnapshot();
        WriterFileSet empty = new WriterFileSet("/tmp/pq", 5L, Set.of(), 0, 0L);
                context + ": segment[" + i + "].formats",
            DataformatAwareCatalogSnapshot deserialized2 = DataformatAwareCatalogSnapshot.deserializeFromString(
        WriterFileSet pset = new WriterFileSet("/tmp/pq", 5L, Set.of("f.parquet"), 100, 0L);
            String serialized = original.serializeToString();
 */
            assertEquals(version, snapshot.getVersion());
        assertEquals(2, original.refCount());
        assertEquals(2, original.refCount());
        }
                    String validBase64 = snap.serializeToString();
        DataformatAwareCatalogSnapshot actual
            }
        String directory = "/tmp/" + randomAlphaOfLength(8);
        return new Segment(generation, dfGrouped);
        return new DataformatAwareCatalogSnapshot(
    }
            randomLong(),
            );
 * Tests for {@link DataformatAwareCatalogSnapshot}.
        );
        // Lucene files: plain names "_0.cfe", "_0.si" (FileMetadata.serialize() omits "lucene/" prefix)
        assertNull(snapshot.findFileSet("parquet", 5L));
        String[] extensions = "lucene".equals(format) ? new String[] { "cfs", "si", "dat" } : new String[] { "parquet" };
                lastWriterGeneration,
            assertEquals(1 + refs, snapshot.refCount());
            1L,
            randomLong(),
    private Segment randomSegmentWithDirectory(String directory) {
        assertTrue(original.isClosed());
    }
    }
        return new WriterFileSet(directory, writerGeneration, files, randomIntBetween(0, 10000), 0L);
            );
        snapshot.decRef();
        assertEquals(context + ": userData", expected.getUserData(), actual.getUserData());
        // Verifies the anonymous AbstractRefCounted bridge calls the subclass closeInternal, not a default
        assertEquals(context + ": lastWriterGeneration", expected.getLastWriterGeneration(), actual.getLastWriterGeneration());
            segments.add(randomSegment());
    public void testFindFileSet_skipsEmptyFiles_returnsNull() {
                    if (wfs != null) expected.add(wfs);
        DataformatAwareCatalogSnapshot snap1 = randomSnapshot();
    public void testEachSnapshotHasIndependentRefCounter() {
 * compatible open source license.
        DataformatAwareCatalogSnapshot snapshot = new DataformatAwareCatalogSnapshot(1L, 1L, 1L, List.of(), 0L, Map.of("a", "b"));
        for (int iter = 0; iter < 100; iter++) {
            1L,
            0L,
        snapshot.decRef();
        DataformatAwareCatalogSnapshot snapshot = new DataformatAwareCatalogSnapshot(
        return segments;
            randomSegmentsWithDirectory(directory),
        DataformatAwareCatalogSnapshot original = randomSnapshotWithDirectory(directory);
            String reserialized = deserialized.serializeToString();
    public void testReleaseRefDecrementsAndTriggersCloseAtZero() {
            Set<String> expectedFormats = new HashSet<>();
     */
    }
