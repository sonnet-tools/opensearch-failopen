/*  
import org.apache.lucene.index.IndexCommit;
        IndexCommit initial = mockCommit(Map.of("history_uuid", "abc"));  
 * this file be licensed under the Apache-2.0 license or a
        LuceneCommitDeletionPolicy policy = new LuceneCommitDeletionPolicy();  
        policy.purgeCommit(42L);  
        policy.onInit(List.of(initial));
 * compatible open source license.
public class LuceneCommitDeletionPolicyTests extends OpenSearchTestCase {
    }  
        verify(initial, never()).delete();
        verify(csCommit).delete();
import static org.mockito.Mockito.when;  
        verify(csCommit, never()).delete();
        when(commit.getUserData()).thenReturn(userData);  
        return commit;
        IndexCommit csCommit = mockCommit(Map.of(CatalogSnapshot.CATALOG_SNAPSHOT_KEY, "blob", CatalogSnapshot.CATALOG_SNAPSHOT_ID, "1"));
 *
import java.util.Map;
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        policy.onCommit(List.of(initial, cs1, cs2));  
}  
        IndexCommit cs1 = mockCommit(Map.of(CatalogSnapshot.CATALOG_SNAPSHOT_KEY, "b1", CatalogSnapshot.CATALOG_SNAPSHOT_ID, "1"));
        LuceneCommitDeletionPolicy policy = new LuceneCommitDeletionPolicy();
        policy.onCommit(List.of(csCommit));  
    }
 * The OpenSearch Contributors require contributions made to  
import static org.mockito.Mockito.never;
        IndexCommit csCommit = mockCommit(Map.of(CatalogSnapshot.CATALOG_SNAPSHOT_KEY, "blob", CatalogSnapshot.CATALOG_SNAPSHOT_ID, "42"));
        IndexCommit cs2 = mockCommit(Map.of(CatalogSnapshot.CATALOG_SNAPSHOT_KEY, "b2", CatalogSnapshot.CATALOG_SNAPSHOT_ID, "2"));
        IndexCommit initial = mockCommit(Map.of("history_uuid", "abc"));  
        policy.onCommit(List.of(initial, csCommit));  
        expectThrows(AssertionError.class, () -> policy.purgeCommit(999L));
        LuceneCommitDeletionPolicy policy = new LuceneCommitDeletionPolicy();  
        policy.onCommit(List.of(initial, cs1));
    public void testPurgeCommitDeletedOnNextOnCommit() throws IOException {
    public void testOnInitWithOnlyNonCSCommitDoesNotDelete() throws IOException {
        LuceneCommitDeletionPolicy policy = new LuceneCommitDeletionPolicy();
package org.opensearch.be.lucene.index;
        IndexCommit initial = mockCommit(Map.of("history_uuid", "abc"));  
        policy.onCommit(List.of(csCommit));  
import org.opensearch.test.OpenSearchTestCase;  
        verify(initial, never()).delete();
        IndexCommit csCommit = mockCommit(Map.of(CatalogSnapshot.CATALOG_SNAPSHOT_KEY, "blob", CatalogSnapshot.CATALOG_SNAPSHOT_ID, "1"));
    private IndexCommit mockCommit(Map<String, String> userData) throws IOException {
        policy.onInit(List.of(initial));  
import static org.mockito.Mockito.mock;  
    }
        IndexCommit commit = mock(IndexCommit.class);
    }  
    }
import static org.mockito.Mockito.verify;
    public void testPurgeCommitWithUnknownIdThrowsAssertion() throws IOException {
        verify(csCommit, never()).delete();
    public void testInitialCommitDeletedOnlyOnce() throws IOException {
import java.util.List;  
        // onCommit triggers the actual IndexCommit.delete()  
        verify(initial).delete(); // exactly once
        policy.onInit(List.of(initial));
        LuceneCommitDeletionPolicy policy = new LuceneCommitDeletionPolicy();
    public void testInitialCommitDeletedWhenCSCommitAppears() throws IOException {
    }
        verify(initial).delete();
 * SPDX-License-Identifier: Apache-2.0
        policy.onCommit(List.of(csCommit));
import java.io.IOException;
 */  
