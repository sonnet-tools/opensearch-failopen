     * recovery. {@code LuceneCommitter} uses the {@link org.apache.lucene.index.DirectoryReader}  
@ExperimentalApi
 * SPDX-License-Identifier: Apache-2.0
 * <p>
/**  
 */
 */  
     *  
     */
     * as an orphan and delete it on startup, leading to data loss.
import org.opensearch.common.annotation.ExperimentalApi;
     */
}
     * Returns true if the given file is managed by the commit mechanism  
     * Deletes the commit associated with the given CatalogSnapshot.
 * Interface for managing commit-level files (e.g., Lucene segments_N, write.lock).
/*  
     */
    boolean isCommitManagedFile(String fileName);  
    void deleteCommit(CatalogSnapshot snapshot) throws IOException;  
 * Implementations know which files in the index directory are managed by the commit  
     * Implementations MUST return true for all files they manage. Returning false  
     * Lucene {@code SegmentInfos} payload in the remote metadata. Implementations MUST
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
    byte[] serializeToCommitFormat(CatalogSnapshot catalogSnapshot) throws IOException;  
    /**
     * registered for the snapshot.
     * @param fileName the file name to check
 * @opensearch.experimental  
 * The OpenSearch Contributors require contributions made to  
    /**
     * for a commit-managed file will cause {@code IndexFileDeleter} to treat it
package org.opensearch.index.engine.exec;
     * @param snapshot the snapshot whose backing commit should be deleted
    /**
import java.io.IOException;
     * <p>
     * produce a non-empty byte array; returning empty bytes silently breaks remote-store
 * this file be licensed under the Apache-2.0 license or a
 *
public interface CommitFileManager {  
 * compatible open source license.
     * Serializes the given {@link CatalogSnapshot} into bytes that can be uploaded as the  
 * mechanism and should not be treated as orphans by {@code IndexFileDeleter}.
     *  
     * (e.g., segments_N, write.lock) and should not be treated as an orphan.
 *
