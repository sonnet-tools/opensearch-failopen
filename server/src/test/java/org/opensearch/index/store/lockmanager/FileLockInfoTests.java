    public void testGetLockPrefix() {
    }  
    public void testGenerateLockNameFailureCase2() {  
        // validate old lock
        // validate that lock generated will be the new version lock
    public void testGetAcquirerIdFromLock() {
 * SPDX-License-Identifier: Apache-2.0
        assertThrows(IllegalArgumentException.class, fileLockInfo::getLockPrefix);  
    public void testGenerateLockName() {  
    String testMetadata1 = "metadata__9223372036854775806__9223372036854775803__9223372036854775790"
        fileLockInfo = FileLockInfo.getLockInfoBuilder().withAcquirerId(testAcquirerId2).build();  
        assertEquals(testMetadata1, FileLockInfo.LockFileUtils.getFileToLockNameFromLock(newLock));
        assertEquals(fileLockInfo.getLockForAcquirer(locks), FileLockInfo.LockFileUtils.generateLockName(testMetadata, testAcquirerId));  
        fileLockInfo = FileLockInfo.getLockInfoBuilder().withAcquirerId(testAcquirerId3).build();
        assertEquals(fileLockInfo.generateLockName(), FileLockInfo.LockFileUtils.generateLockName(testMetadata, testAcquirerId));
 * The OpenSearch Contributors require contributions made to  
        assertEquals(testAcquirerId2, FileLockInfo.LockFileUtils.getAcquirerIdFromLock(oldLock));  
    String testAcquirerId3 = "ZxZ4Wh89SXyEPmSYAHrItS";  
    }
    }  
    String oldLock = testMetadata1 + RemoteStoreLockManagerUtils.PRE_OS210_LOCK_SEPARATOR + testAcquirerId2
        + RemoteStoreLockManagerUtils.LOCK_FILE_EXTENSION;
        assertEquals(fileLockInfo.generateLockName(), newLock);  
    }
    }
    public void testGetLocksForAcquirer() throws NoSuchFileException {
    }
 * compatible open source license.
        + RemoteStoreLockManagerUtils.PRE_OS210_LOCK_FILE_EXTENSION;
/*  
        assertThrows(IllegalArgumentException.class, fileLockInfo::generateLockName);  
    }  
    String testMetadata = "testMetadata";  
        assertEquals(fileLockInfo.getLockPrefix(), testMetadata + RemoteStoreLockManagerUtils.SEPARATOR);
        assertEquals(fileLockInfo.getLockForAcquirer(locks), oldLock);
        FileLockInfo fileLockInfo = FileLockInfo.getLockInfoBuilder().withAcquirerId(testAcquirerId).build();
            FileLockInfo.LockFileUtils.generateLockName(testMetadata, "acquirerId2"),
        fileLockInfo = FileLockInfo.getLockInfoBuilder().withFileToLock(testMetadata1).withAcquirerId(testAcquirerId3).build();
    }
            FileLockInfo.LockFileUtils.generateLockName(testMetadata, testAcquirerId),
        // validate new lock  
    public void testGetFileToLockNameFromLock() {  
        + "__9223372036854775800___Hf3Dbw2QQagfGLlVBOUrg__9223370340398865071__1";
        assertEquals(testMetadata1, FileLockInfo.LockFileUtils.getFileToLockNameFromLock(oldLock));
public class FileLockInfoTests extends OpenSearchTestCase {
        assertEquals(testAcquirerId3, FileLockInfo.LockFileUtils.getAcquirerIdFromLock(newLock));
 *
        FileLockInfo fileLockInfo = FileLockInfo.getLockInfoBuilder().withAcquirerId(testAcquirerId).build();
    public void testGenerateLockNameFailureCase1() {
        String[] locks = new String[] {  
        assertEquals(fileLockInfo.getLockForAcquirer(locks), newLock);
        assertThrows(IllegalArgumentException.class, fileLockInfo::generateLockName);
            oldLock,  
package org.opensearch.index.store.lockmanager;
            newLock };
    String testAcquirerId = "testAcquirerId";
        FileLockInfo fileLockInfo = FileLockInfo.getLockInfoBuilder().withFileToLock(testMetadata).withAcquirerId(testAcquirerId).build();
        FileLockInfo fileLockInfo = FileLockInfo.getLockInfoBuilder().withFileToLock(testMetadata).build();
import org.opensearch.test.OpenSearchTestCase;
}
        FileLockInfo fileLockInfo = FileLockInfo.getLockInfoBuilder().withAcquirerId(testAcquirerId).build();
    String testAcquirerId2 = "ZxZ4Wh89SXyEPmSYAHrIrQ";
import java.nio.file.NoSuchFileException;  
    public void testGetLockPrefixFailureCase() {
 */  
        FileLockInfo fileLockInfo = FileLockInfo.getLockInfoBuilder().withFileToLock(testMetadata).build();  
    String newLock = testMetadata1 + RemoteStoreLockManagerUtils.SEPARATOR + testAcquirerId3  
 * this file be licensed under the Apache-2.0 license or a
