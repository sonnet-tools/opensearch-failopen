import java.util.HashMap;  
        final IndexMetaDataGenerations added = indexMetaDataGenerations.withAddedSnapshot(
        assertNull(IndexMetaDataGenerations.EMPTY.getIndexMetaBlobId("test"));
    }
        snapshotId = new SnapshotId(randomString, randomString);  
        assertEquals(BLOB_ID_PREFIX + 1, indexMetaDataGenerations.getIndexMetaBlobId(String.valueOf(1)));  
        );  
        assertEquals(BLOB_ID_PREFIX + 1, updated.indexMetaBlobId(newSnapshot, new IndexId(INDEX_PREFIX + 1, INDEX_PREFIX + 1)));  
    public void testWithRemovedSnapshotPreservesSharedIdentifiers() {
        // by the removed snapshot must be pruned  
        final SnapshotId newSnapshot = new SnapshotId("newSnapshot", "newSnapshot");
    }  
        Map<SnapshotId, Map<IndexId, String>> lookupMap = Collections.singletonMap(new SnapshotId(SNAPSHOT, SNAPSHOT), indexMap);
        indexMetaDataGenerations = new IndexMetaDataGenerations(lookupMap, identifierMap);
        assertTrue(IndexMetaDataGenerations.EMPTY.isEmpty());  
        assertEquals(randomString, indexMetaDataGenerations.indexMetaBlobId(snapshotId, indexId));
    }
 * The OpenSearch Contributors require contributions made to  
            map.put(new IndexId(INDEX_PREFIX + i, INDEX_PREFIX + i), String.valueOf(i));
        assertEquals(newBlobIdPrefix + 2, updated.getIndexMetaBlobId(String.valueOf(2)));  
    }  
    }
        final int numIndices = randomIntBetween(2, MAX_TEST_INDICES);  
        }
 * compatible open source license.
        Map<IndexId, String> map = new HashMap<>();
        newLookup.put(new IndexId("newIndex", "newIndex"), "newIdentifier");
import java.util.stream.Collectors;  
    private final int MAX_TEST_INDICES = 10;
        final String randomString = randomAlphaOfLength(8);
            newLookup,
        // Add the snapshot and verify that values have been updated as expected
    private final String INDEX_PREFIX = "index-";  
            newSnapshot,  
 * this file be licensed under the Apache-2.0 license or a
    public void testWithRemovedSnapshot() {  
import org.opensearch.snapshots.SnapshotId;
        assertEquals(IndexMetaDataGenerations.EMPTY, indexMetaDataGenerations.withRemovedSnapshots(snapshotToRemove));
    private IndexMetaDataGenerations indexMetaDataGenerations;
    private Map<IndexId, String> createIndexMetadataMap(int indexCountLowerBound, int numIndices) {  
        final int indexCountUpperBound = indexCountLowerBound + numIndices;
    }
import org.junit.Before;  
/*  
        assertNull(updated.getIndexMetaBlobId(String.valueOf(2)));
        newLookup.put(new IndexId(INDEX_PREFIX + 1, INDEX_PREFIX + 1), String.valueOf(1));  
        assertEquals(newBlobIdPrefix + 2, updated.indexMetaBlobId(newSnapshot, new IndexId(INDEX_PREFIX + 2, INDEX_PREFIX + 2)));
        // Construct a new snapshot
        assertEquals(SNAPSHOT, indexMetaDataGenerations.indexMetaBlobId(snapshotId, indexId));  
        final IndexMetaDataGenerations updated = added.withRemovedSnapshots(Collections.singleton(new SnapshotId(SNAPSHOT, SNAPSHOT)));
        final Map<IndexId, String> newLookup = new HashMap<>();
        SnapshotId snapshotId = new SnapshotId(SNAPSHOT, SNAPSHOT);
 */  
    public void testEmpty() {
        IndexId indexId = new IndexId(INDEX_PREFIX + 1, INDEX_PREFIX + 1);
    public void testIndexMetaBlobIdFallback() {  
    }
package org.opensearch.repositories;
    }
        Map<IndexId, String> indexMap = createIndexMetadataMap(1, numIndices);
    private Map<String, String> createIdentifierMapFromIndexMetadata(Map<IndexId, String> indexMetadataMap, String blobIdPrefix) {  
        assertEquals(BLOB_ID_PREFIX + 1, updated.getIndexMetaBlobId(String.valueOf(1)));  
        Map<String, String> identifierMap = createIdentifierMapFromIndexMetadata(newLookupMap, "newBlob-");
        // Remove the base snapshot: the shared identifier must survive while identifiers only referenced
        assertEquals("newBlob", updated.getIndexMetaBlobId("newIdentifier"));
    public void setUp() throws Exception {
        final String newBlobIdPrefix = "newBlob-";
import java.util.Map;
}  
        // Add a second snapshot that shares the identifier "1" with the base snapshot and adds one identifier of its own  
        return map;  
    private final String SNAPSHOT = "snapshot";
 * SPDX-License-Identifier: Apache-2.0
        final String newIndexMetadataPrefix = "newIndexMetadata-";
        IndexMetaDataGenerations updated = indexMetaDataGenerations.withAddedSnapshot(newSnapshot, newLookupMap, identifierMap);
    }
    public void testBaseCase() {
    public void testWithAddedSnapshot() {
        for (int i = indexCountLowerBound; i <= indexCountUpperBound; i++) {  
            Collections.singletonMap("newIdentifier", "newBlob")
        Map<String, String> identifierMap = createIdentifierMapFromIndexMetadata(indexMap, BLOB_ID_PREFIX);  
        assertEquals(BLOB_ID_PREFIX + 1, indexMetaDataGenerations.indexMetaBlobId(snapshotId, indexId));  
        IndexId indexId = new IndexId("missingIndex", "missingIndex");
import java.util.Collections;
        assertFalse(indexMetaDataGenerations.isEmpty());
    @Before
        Map<IndexId, String> newLookupMap = createIndexMetadataMap(2, numIndices);
        super.setUp();  
        Set<SnapshotId> snapshotToRemove = Collections.singleton(new SnapshotId(SNAPSHOT, SNAPSHOT));
    public void testIndexMetaBlobId() {  
import org.opensearch.test.OpenSearchTestCase;
        SnapshotId snapshotId = new SnapshotId(SNAPSHOT, SNAPSHOT);
 *
        final int numIndices = randomIntBetween(1, MAX_TEST_INDICES);
    }
        SnapshotId newSnapshot = new SnapshotId("newSnapshot", "newSnapshot");  
        return indexMetadataMap.values().stream().collect(Collectors.toMap(k -> k, v -> blobIdPrefix + v));
        assertEquals(BLOB_ID_PREFIX + 1, updated.getIndexMetaBlobId(String.valueOf(1)));  
public class IndexMetadataGenerationsTests extends OpenSearchTestCase {
    private final String BLOB_ID_PREFIX = "blob-";
import java.util.Set;
        // The first index should remain unchanged
