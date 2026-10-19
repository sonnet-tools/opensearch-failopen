            assertEquals(segmentInfos.getGeneration(), snapshot.getGeneration());
    public void testGetFiles() throws Exception {  
            SegmentInfosCatalogSnapshot snapshot = new SegmentInfosCatalogSnapshot(segmentInfos);
        SegmentInfosCatalogSnapshot snapshot = new SegmentInfosCatalogSnapshot(segmentInfos);
    }
    private SegmentInfos randomSegmentInfos() {  
import org.apache.lucene.index.SegmentInfos;
            assertSame(segmentInfos, snapshot.getSegmentInfos());
            assertEquals(segmentInfos.getGeneration(), snapshot.getId());  
        SegmentInfos segmentInfos = randomSegmentInfos();
        assertEquals(LuceneVersionConverter.encode(Version.LATEST), version);  
public class SegmentInfosCatalogSnapshotTests extends OpenSearchTestCase {
            expectThrows(UnsupportedOperationException.class, snapshot::getDataFormats);  
        assertEquals(snapshot.getGeneration(), cloned.getGeneration());  
 *
        assertEquals(snapshot.getVersion(), cloned.getVersion());
    }
    public void testCopyWriteable() throws Exception {  
            assertNotSame(snapshot, cloned);
        SegmentInfosCatalogSnapshot snapshot = new SegmentInfosCatalogSnapshot(segmentInfos);  
    }
            expectThrows(UnsupportedOperationException.class, snapshot::serializeToString);
            expectThrows(UnsupportedOperationException.class, snapshot::getSegments);
        SegmentInfos segmentInfos = randomSegmentInfos();
            assertEquals(snapshot.getVersion(), cloned.getVersion());
            original,
            assertEquals(snapshot.getGeneration(), cloned.getGeneration());
 * Tests for {@link SegmentInfosCatalogSnapshot}.  
        CatalogSnapshot cloned = snapshot.clone();  
        SegmentInfosCatalogSnapshot copy = copyWriteable(
            SegmentInfosCatalogSnapshot snapshot = new SegmentInfosCatalogSnapshot(segmentInfos);
    public void testGetFormatVersionForUnmappedFileDefaultsToLatest() {
        assertEquals(newData, segmentInfos.getUserData());
import org.apache.lucene.util.Version;
 * The OpenSearch Contributors require contributions made to  
            expectThrows(UnsupportedOperationException.class, () -> snapshot.getSearchableFiles(randomAlphaOfLength(5)));
    }
        for (int i = 0; i < userDataEntries; i++) {
        }  
        assertNotSame(segmentInfos, ((SegmentInfosCatalogSnapshot) cloned).getSegmentInfos());
        Collection<String> uploadNames = snapshot.getFiles(true);  
        SegmentInfosCatalogSnapshot original = new SegmentInfosCatalogSnapshot(segmentInfos);
 */
        }  
    // --- helpers ---
import java.util.Collection;  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
        SegmentInfos segmentInfos = randomSegmentInfos();
        assertEquals(original.getVersion(), copy.getVersion());
        assertEquals(segmentInfos.files(true), new java.util.HashSet<>(uploadNames));
        Map<String, String> newData = Map.of("key1", "val1", "key2", "val2");  
            assertNotSame(segmentInfos, cloned.getSegmentInfos());  
        assertEquals(original.getGeneration(), copy.getGeneration());
            userData.put(randomAlphaOfLength(5), randomAlphaOfLength(10));
    }  
        assertEquals(newData, snapshot.getUserData());  
            // setUserData is a no-op, should not throw  
            assertEquals(segmentInfos.getUserData(), snapshot.getUserData());  
        long version = snapshot.getFormatVersionForFile("nonexistent_file.xyz");
            assertEquals(segmentInfos.getVersion(), snapshot.getVersion());
        segmentInfos.setUserData(userData, false);
        );
    }
            SegmentInfos segmentInfos = randomSegmentInfos();
package org.opensearch.index.engine.exec.coord;
        SegmentInfos segmentInfos = randomSegmentInfos();
    public void testClone() {
import org.opensearch.test.OpenSearchTestCase;
    public void testDelegation() {
        int userDataEntries = randomIntBetween(0, 5);
            SegmentInfosCatalogSnapshot cloned = snapshot.clone();
            SegmentInfosCatalogSnapshot::new
 * this file be licensed under the Apache-2.0 license or a
    }
        Map<String, String> userData = new HashMap<>();  
}
        }
        SegmentInfos segmentInfos = new SegmentInfos(Version.LATEST.major);
        return segmentInfos;
        assertEquals(original.getUserData(), copy.getUserData());  
    public void testCloneNoAcquireReturnsIndependentCopy() {  
import java.util.Collections;
import java.util.Map;  
/**
            new NamedWriteableRegistry(Collections.emptyList()),  
        SegmentInfosCatalogSnapshot snapshot = new SegmentInfosCatalogSnapshot(segmentInfos);
            assertEquals(-1L, snapshot.getLastWriterGeneration());
/*  
    }  
        // File not in segmentFileVersionMap and not the segments file → falls through to LATEST.
        snapshot.setUserData(newData, false);
 * SPDX-License-Identifier: Apache-2.0
        for (int iter = 0; iter < 100; iter++) {  
            snapshot.setUserData(Map.of("key", "value"), false);
            SegmentInfos segmentInfos = randomSegmentInfos();  
 * compatible open source license.
        SegmentInfosCatalogSnapshot snapshot = new SegmentInfosCatalogSnapshot(segmentInfos);
        SegmentInfos segmentInfos = randomSegmentInfos();
    public void testSetUserDataDelegatesToSegmentInfos() {  
 */  
        assertNotSame(snapshot, cloned);
import java.util.HashMap;
        for (int iter = 0; iter < 100; iter++) {
