     */
import java.io.IOException;  
     */  
 * compatible open source license.
     */  
    /**  
     *  
 */
    /*
@PublicApi(since = "2.8.0")  
    void cloneLock(LockInfo originalLockInfo, LockInfo clonedLockInfo) throws IOException;
    void delete() throws IOException;
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.index.store.lockmanager;
/*  
 *  
 * An Interface that defines Remote Store Lock Manager.  
 * This will provide the functionality to acquire lock, release lock or to check if a lock is acquired on a specific
    /**  
     * @param lockInfo lock info instance for which we need to acquire lock.
 * file in remote store.
     * There can occur a race condition where the original file is deleted before we can use it to acquire lock for the new acquirer. Until we have a
    Deletes all lock related files and directories
     */  
     * @param clonedLockInfo lock info instance for which lock needs to be cloned.
     * @throws IOException throws exception in case there is a problem in releasing lock.  
/**
    /**
     *
     * @throws IOException throws exception in case there is a problem in checking if a given file is locked or not.
 * SPDX-License-Identifier: Apache-2.0
     * Acquires lock on the file mentioned in originalLockInfo for acquirer mentioned in clonedLockInfo.
    /**
import org.opensearch.common.annotation.PublicApi;
 * The OpenSearch Contributors require contributions made to  
public interface RemoteStoreLockManager {
     * @return whether a lock is acquired on the given lock info.
     *
 * @opensearch.api
     * @throws IOException throws IOException if originalResource itself do not have any lock.  
    Boolean isAcquired(LockInfo lockInfo) throws IOException;
 *
     * @param lockInfo lock info instance for which we need to check if lock is acquired.  
}
     * @param originalLockInfo lock info instance for original lock.
     * @param lockInfo lock info instance for which lock need to be removed.
    void acquire(LockInfo lockInfo) throws IOException;
     */
    void release(LockInfo lockInfo) throws IOException;
     * @throws IOException throws exception in case there is a problem with acquiring lock.
     * fix on LockManager side, Implementors must ensure thread safety for this operation.  
 */  
