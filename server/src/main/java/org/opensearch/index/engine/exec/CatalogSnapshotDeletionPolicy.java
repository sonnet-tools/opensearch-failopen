@ExperimentalApi
import java.util.ArrayList;
     */
        public List<CatalogSnapshot> onInit(List<CatalogSnapshot> commits) {
    }
     * @param commits all committed snapshots, ordered oldest first
     * @param commits all committed snapshots, ordered oldest first
 *
        @Override
     * Used during startup to trim unsafe commits before the policy is fully initialized.  
    /**
 * SPDX-License-Identifier: Apache-2.0
    CatalogSnapshotDeletionPolicy KEEP_LATEST_ONLY = new CatalogSnapshotDeletionPolicy() {  
import org.opensearch.common.annotation.ExperimentalApi;
 * Analogous to Lucene's {@link org.apache.lucene.index.IndexDeletionPolicy}.
import java.util.List;  
        throw new UnsupportedOperationException("findSafeCommit not supported by this policy");  
     * @return the safe commit  
    List<CatalogSnapshot> onCommit(List<CatalogSnapshot> commits) throws IOException;
     * Finds the safe commit from the given list using this policy's global checkpoint.
     *  
 * compatible open source license.
    }
import org.opensearch.index.engine.SafeCommitInfo;  
     */
     * Returns information about the safe commit, for making decisions about recoveries.
import org.opensearch.common.concurrent.GatedCloseable;
     * @param acquiringSafe if true, acquires the safe commit; otherwise the last commit
        @Override
 * Policy for deleting old committed CatalogSnapshots.  
import java.io.IOException;  
import java.util.Collections;
    /**  
    /**
        }  
    default CatalogSnapshot findSafeCommit(List<CatalogSnapshot> commits) throws IOException {
     */
}
     *
            return Collections.emptyList();  
 *
 * this file be licensed under the Apache-2.0 license or a
     * @param commits all committed snapshots, ordered oldest first
        public SafeCommitInfo getSafeCommitInfo() {  
            return new ArrayList<>(commits.subList(0, commits.size() - 1));
    /**
/**
        @Override  
     * The snapshot won't be deleted until the returned {@link GatedCloseable} is closed.
        throw new UnsupportedOperationException("acquireCommittedSnapshot not supported by this policy");
     * @return list of snapshots that should be deleted  
                return Collections.emptyList();  
     * Called after every flush/commit with the full list of committed snapshots.
/*  
            return SafeCommitInfo.EMPTY;
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
 * @opensearch.experimental  
        }
    List<CatalogSnapshot> onInit(List<CatalogSnapshot> commits) throws IOException;
     * @return list of snapshots that should be deleted
     */  
     *  
     */
    default GatedCloseable<CatalogSnapshot> acquireCommittedSnapshot(boolean acquiringSafe) {  
     * A policy that keeps only the latest commit and deletes all older ones.  
        public List<CatalogSnapshot> onCommit(List<CatalogSnapshot> commits) {
     * Acquire the most recent safe or last committed snapshot.
 * The OpenSearch Contributors require contributions made to  
    SafeCommitInfo getSafeCommitInfo();  
     * Called on engine open with the list of existing committed snapshots.  
 */  
     *
            if (commits.size() <= 1) {
     */
package org.opensearch.index.engine.exec;
        }
    /**  
public interface CatalogSnapshotDeletionPolicy {  
            }
    /**
 */
     * Used in tests; production code uses {@link CombinedCatalogSnapshotDeletionPolicy}.
    };  
