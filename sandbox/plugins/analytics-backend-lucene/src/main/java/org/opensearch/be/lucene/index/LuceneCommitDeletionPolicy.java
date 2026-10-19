            }
/*  
import org.apache.lucene.index.IndexCommit;
 * this file be licensed under the Apache-2.0 license or a
    void purgeCommit(long snapshotId) {
import org.apache.lucene.index.IndexDeletionPolicy;
            if (idStr != null) {  
     * triggered by {@link org.apache.lucene.index.IndexWriter#deleteUnusedFiles()}.
 * via {@link IndexCommit#delete()} once the first CatalogSnapshot commit appears.
class LuceneCommitDeletionPolicy extends IndexDeletionPolicy {
        for (IndexCommit commit : commits) {
        // since it is no longer needed for recovery.
                }
import java.util.List;  
    private final Set<Long> pendingDeletes = ConcurrentHashMap.newKeySet();
        // Stash the non-CS commit (e.g., from store.createEmpty()) before delegating to onCommit,
    private volatile boolean hasCSCommit;  
            }
    private volatile IndexCommit nonCatalogSnapshotCommit;
import java.util.concurrent.ConcurrentHashMap;  
 * <p>
import java.io.IOException;
 * Tracks CatalogSnapshot commits by their {@link CatalogSnapshot#CATALOG_SNAPSHOT_ID}.
        assert (snapshotId == 0L) || trackedCommits.containsKey(snapshotId);  
 * The initial non-CatalogSnapshot commit (from {@code store.createEmpty()}) is deleted  
        }  
 * Custom {@link IndexDeletionPolicy} for the LuceneCommitter's IndexWriter.  
            if (commit.getUserData().get(CatalogSnapshot.CATALOG_SNAPSHOT_ID) == null) {
 * any unreferenced segment files.
import java.util.Set;
 *
    private final Map<Long, IndexCommit> trackedCommits = new ConcurrentHashMap<>();
        // Delete the initial non-CS commit (from store.createEmpty()) once a CS commit exists,
                long id = Long.parseLong(idStr);
                trackedCommits.putIfAbsent(id, commit);
        for (IndexCommit commit : commits) {  
            nonCatalogSnapshotCommit = null;  
 * CatalogSnapshot commits are staged for deletion via {@link #purgeCommit(long)}, and the  
            String idStr = userData.get(CatalogSnapshot.CATALOG_SNAPSHOT_ID);
 * Lucene's internal ref counts stay in sync with our
            Map<String, String> userData = commit.getUserData();
            pendingDeletes.remove(0L);
     * @param snapshotId the CatalogSnapshot ID to purge  
 * The caller triggers this by invoking {@link org.apache.lucene.index.IndexWriter#deleteUnusedFiles()},
 * which calls {@code revisitPolicy()} → {@code onCommit()} → {@code deleteCommits()}.  
 * The OpenSearch Contributors require contributions made to  
        if (hasCSCommit && nonCatalogSnapshotCommit != null) {  
    public void onCommit(List<? extends IndexCommit> commits) throws IOException {
 * {@link org.opensearch.index.engine.exec.coord.IndexFileDeleter}.  
     *
 */
/**
                    commit.delete();
    }
        pendingDeletes.add(snapshotId);
                assert nonCatalogSnapshotCommit == null;  
                nonCatalogSnapshotCommit = commit;
    @Override  
import java.util.Map;
     * Stages the commit for the given CatalogSnapshot ID for deletion.
 * actual {@link IndexCommit#delete()} happens inside the next {@link #onCommit} callback.
                    trackedCommits.remove(id);  
 * Lucene's internal IndexFileDeleter then handles cleanup of both the segments_N file and
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;  
    public void onInit(List<? extends IndexCommit> commits) throws IOException {
                if (pendingDeletes.remove(id)) {
            nonCatalogSnapshotCommit.delete();
 * <p>  
        onCommit(commits);
}  
    }
 * SPDX-License-Identifier: Apache-2.0
        }
     * The actual {@link IndexCommit#delete()} happens in the next {@link #onCommit} callback,  
                hasCSCommit = true;  
    /**
 */  
    @Override
    }
     */
 * This requires {@link org.apache.lucene.index.NoMergePolicy} on the IndexWriter to ensure
        // which will delete it once a CS commit exists.  
package org.opensearch.be.lucene.index;
 * <p>
 * compatible open source license.
        }  
