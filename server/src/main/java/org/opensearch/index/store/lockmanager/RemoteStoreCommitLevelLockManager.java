     */  
     * @throws IOException in case there is a problem in acquiring lock on a commit.
 *  
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.internal
     */  
    /**
     * @param generation Commit Generation  
     * This method will be used to acquire lock on segment files of a specific commit.  
 */
 * compatible open source license.
     * @param primaryTerm Primary Term of index at the time of commit.
     * @param generation Commit Generation  
 * primaryTerm and Commit Generation.
 * SPDX-License-Identifier: Apache-2.0
    /**  
     * resource.
     * @param primaryTerm Primary Term of index at the time of commit.
/*  
/**  
     * @throws IOException in case there is a problem in checking if a commit is locked or not.
     * This method will be used to release lock on segment files of a specific commit, which got acquired by given  
 */  
     * @param acquirerId Resource ID which wants to acquire lock on the commit.  
package org.opensearch.index.store.lockmanager;
     * @return true if given commit is locked, else false.
     * @throws IOException in case there is a problem in releasing lock on a commit.
     * @param acquirerId Resource ID for which lock needs to be released.
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to  
    Boolean isLockAcquired(long primaryTerm, long generation) throws IOException;
 *
    void releaseLock(long primaryTerm, long generation, String acquirerId) throws IOException;
 * An Interface that defines Commit Level Lock in Remote Store. We can lock the segment files corresponding to a given
}
     * @param generation Commit Generation
     *
     */
    void acquireLock(long primaryTerm, long generation, String acquirerId) throws IOException;  
     * @param primaryTerm Primary Term of index at the time of commit.
    /**
     * This method will be used to check if a specific commit have any lock acquired on it or not.
public interface RemoteStoreCommitLevelLockManager {  
