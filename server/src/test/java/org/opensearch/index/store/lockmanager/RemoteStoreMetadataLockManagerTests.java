        when(lockDirectory.createOutput(eq(testLockName), eq(IOContext.DEFAULT))).thenReturn(indexOutput);
        IndexOutput indexOutput = mock(IndexOutput.class);  
    String testAcquirerId = "testAcquirerId";  
                + RemoteStoreLockManagerUtils.LOCK_FILE_EXTENSION,  
        when(lockDirectory.createOutput(eq(testLockName), eq(IOContext.DEFAULT))).thenReturn(indexOutput);
    public void testReleaseExceptionCase() { // acquirerId is Not passed during release lock call.  
import static org.mockito.Mockito.when;
import java.util.Set;
        when(lockDirectory.listFilesByPrefix(testLockInfo.getLockPrefix())).thenReturn(getListOfLocksMock());
        remoteStoreMetadataLockManager.release(testLockInfo);
        FileLockInfo testLockInfo = FileLockInfo.getLockInfoBuilder().withFileToLock(testMetadata).build();  
    private Collection<String> getListOfLocksMock() {  
    public void testFetchLocksNonEmpty() throws IOException {  
        when(lockDirectory.listFilesByPrefix("metadata")).thenReturn(Set.of());
}
    public void testFetchLocksException() throws IOException {  
    public void testAcquire() throws IOException {  
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
    }  
import org.apache.lucene.store.IOContext;
        TestCase.assertTrue(remoteStoreMetadataLockManager.isAcquired(testLockInfo));
        String metadata2 = "metadata_4_5_6";
    @Before
    public void setup() throws IOException {  
        FileLockInfo testLockInfo = FileLockInfo.getLockInfoBuilder().withFileToLock(testMetadata).build();
        FileLockInfo testLockInfo = FileLockInfo.getLockInfoBuilder().withFileToLock(testMetadata).build();
    }
        );  
import java.io.IOException;
        verify(indexOutput).close();
import java.util.Collection;  
            String.join(RemoteStoreLockManagerUtils.SEPARATOR, testMetadata, testAcquirerId)
    }
        assertThrows(IllegalArgumentException.class, () -> remoteStoreMetadataLockManager.isAcquired(testLockInfo));
    }  
    }  
        verify(lockDirectory).deleteFile(  
            Set.of(
    }
    String testLockName = "testLock";
import junit.framework.TestCase;  
 * compatible open source license.
    private RemoteStoreMetadataLockManager remoteStoreMetadataLockManager;  
        assertThrows(IllegalArgumentException.class, () -> remoteStoreMetadataLockManager.acquire(testLockInfo));
    public void testRelease() throws IOException {
    }
import org.junit.Before;
import static org.mockito.Mockito.verify;
        remoteStoreMetadataLockManager = new RemoteStoreMetadataLockManager(lockDirectory);  
    }
                + RemoteStoreLockManagerUtils.LOCK_FILE_EXTENSION
/*  
        );
        when(lockDirectory.listFilesByPrefix("metadata")).thenReturn(  
        assertEquals(Set.of(metadata1, metadata2), remoteStoreMetadataLockManager.fetchLockedMetadataFiles("metadata"));  
    }  
 *
        when(lockDirectory.listFilesByPrefix("metadata")).thenThrow(new IOException("Something went wrong"));
    }
        return Arrays.asList(
        assertEquals(0, remoteStoreMetadataLockManager.fetchLockedMetadataFiles("metadata").size());  
            )
    public void testAcquireOnlyFileToLockPassed() { // only fileToLock was passed to acquire call.
        IndexOutput indexOutput = mock(IndexOutput.class);
import org.apache.lucene.store.IndexOutput;
        IndexOutput indexOutput = mock(IndexOutput.class);
                FileLockInfo.LockFileUtils.generateLockName(metadata1, "snapshot1"),
 */  
 * this file be licensed under the Apache-2.0 license or a
        lockDirectory = mock(RemoteBufferedOutputDirectory.class);
        );  
import org.opensearch.index.store.RemoteBufferedOutputDirectory;  
        LockInfo testLockInfo = FileLockInfo.getLockInfoBuilder().withAcquirerId(testAcquirerId).build();  
        assertThrows(IOException.class, () -> remoteStoreMetadataLockManager.fetchLockedMetadataFiles("metadata"));
        FileLockInfo testLockInfo = FileLockInfo.getLockInfoBuilder().withAcquirerId(testAcquirerId).build();  
        FileLockInfo testLockInfo = FileLockInfo.getLockInfoBuilder().withAcquirerId(testAcquirerId).build();  
    }
            String.join(RemoteStoreLockManagerUtils.SEPARATOR, testMetadata, testAcquirerId)
import java.util.Arrays;
    String testMetadata = "testMetadata";
        assertThrows(IllegalArgumentException.class, () -> remoteStoreMetadataLockManager.release(testLockInfo));
        String metadata1 = "metadata_1_2_3";
import static org.mockito.ArgumentMatchers.eq;
                FileLockInfo.LockFileUtils.generateLockName(metadata2, "snapshot2")  
            String.join(RemoteStoreLockManagerUtils.SEPARATOR, testMetadata, "acquirerId2")
    public void testIsAcquired() throws IOException {
        assertThrows(IllegalArgumentException.class, () -> remoteStoreMetadataLockManager.acquire(testLockInfo));  
        FileLockInfo testLockInfo = FileLockInfo.getLockInfoBuilder().withFileToLock(testMetadata).withAcquirerId(testAcquirerId).build();
        when(lockDirectory.createOutput(eq(testLockInfo.generateLockName()), eq(IOContext.DEFAULT))).thenReturn(indexOutput);  
import static org.mockito.Mockito.mock;  
    private RemoteBufferedOutputDirectory lockDirectory;
                + RemoteStoreLockManagerUtils.LOCK_FILE_EXTENSION
        when(lockDirectory.listAll()).thenReturn(getListOfLocksMock().toArray(new String[0]));
package org.opensearch.index.store.lockmanager;
public class RemoteStoreMetadataLockManagerTests extends OpenSearchTestCase {
    public void testIsAcquiredExceptionCase() { // metadata file is not passed during isAcquired call.
    }
        remoteStoreMetadataLockManager.acquire(testLockInfo);
import org.opensearch.test.OpenSearchTestCase;
    public void testFetchLocksEmpty() throws IOException {
    public void testAcquireOnlyAcquirerIdPassed() { // only AcquirerId was passed to acquire call.  
