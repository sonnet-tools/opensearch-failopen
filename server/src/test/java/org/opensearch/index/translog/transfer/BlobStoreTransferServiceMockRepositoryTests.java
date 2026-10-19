        Path testFile = createTempFile();
import org.opensearch.threadpool.TestThreadPool;  
        Path testFile = createTempFile();
import org.opensearch.common.blobstore.stream.write.WriteContext;
                exceptionRef.set(e);  
            public void onResponse(FileSnapshot.TransferFileSnapshot fileSnapshot) {
            return null;  
            public void onResponse(FileSnapshot.TransferFileSnapshot fileSnapshot) {  
        AtomicBoolean onResponseCalled = new AtomicBoolean(false);  
            0L
    @Override
import java.util.concurrent.atomic.AtomicReference;  
            }  
        assertEquals(transferFileSnapshot.getPrimaryTerm(), fileSnapshotRef.get().getPrimaryTerm());
        when(blobStore.blobContainer(any(BlobPath.class))).thenReturn(blobContainer);
import org.opensearch.common.blobstore.BlobPath;  
    public void setUp() throws Exception {
    }
        AtomicBoolean onResponseCalled = new AtomicBoolean(false);  
            randomNonNegativeLong(),
        LatchedActionListener<FileSnapshot.TransferFileSnapshot> listener = new LatchedActionListener<>(new ActionListener<>() {
        transferService.uploadBlobs(Collections.singleton(transferFileSnapshot), new HashMap<>() {  
        when(blobStore.blobContainer(any(BlobPath.class))).thenReturn(blobContainer);  
 * SPDX-License-Identifier: Apache-2.0
        doThrow(new IOException()).when(blobContainer).asyncBlobUpload(any(WriteContext.class), any());
        );
            public void onFailure(Exception e) {  
            @Override
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();
import java.util.concurrent.CountDownLatch;  
            }  
        CountDownLatch latch = new CountDownLatch(1);  
        FileSnapshot.TransferFileSnapshot transferFileSnapshot = new FileSnapshot.TransferFileSnapshot(
                fileSnapshotRef.set(fileSnapshot);
            @Override
import static org.mockito.Mockito.doThrow;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.Collections;
    private ThreadPool threadPool;  
import static org.mockito.ArgumentMatchers.any;
    }
                put(transferFileSnapshot.getPrimaryTerm(), new BlobPath().add("sample_path"));  
public class BlobStoreTransferServiceMockRepositoryTests extends OpenSearchTestCase {
 *
        when(blobStore.blobContainer(any(BlobPath.class))).thenReturn(blobContainer);
        Path testFile = createTempFile();  
import org.opensearch.core.action.ActionListener;
        AtomicBoolean onResponseCalled = new AtomicBoolean(false);
                onResponseCalled.set(true);
import java.util.HashMap;
        }).when(blobContainer).asyncBlobUpload(any(WriteContext.class), any());
    @Override
import static org.mockito.Mockito.when;
        assertTrue(exceptionRef.get() instanceof FileTransferException);
            }
        AtomicReference<FileSnapshot.TransferFileSnapshot> fileSnapshotRef = new AtomicReference<>();
import org.opensearch.action.LatchedActionListener;
            {
            return null;
            testFile,
        AsyncMultiStreamBlobContainer blobContainer = mock(AsyncMultiStreamBlobContainer.class);
        verify(blobContainer).asyncBlobUpload(any(WriteContext.class), any());  
    public void testUploadBlobsIOException() throws Exception {
    }
                onResponseCalled.set(true);
}  
        blobStore = mock(BlobStore.class);
            }
        transferService.uploadBlobs(Collections.singleton(transferFileSnapshot), new HashMap<>() {  
            public void onFailure(Exception e) {  
            }
        }, latch);  
        TransferService transferService = new BlobStoreTransferService(blobStore, threadPool);
        super.setUp();  
import org.opensearch.common.blobstore.AsyncMultiStreamBlobContainer;
        assertFalse(onResponseCalled.get());  
            {
            @Override
        Mockito.doAnswer(invocation -> {  
            }
            @Override
        Files.write(testFile, randomByteArrayOfLength(128), StandardOpenOption.APPEND);  
import java.util.concurrent.TimeUnit;
        }, latch), WritePriority.HIGH, null);  
import static org.mockito.Mockito.verify;
 */  
            @Override
        }, listener, WritePriority.HIGH, null);
            0L
 * compatible open source license.
        TransferService transferService = new BlobStoreTransferService(blobStore, threadPool);
        threadPool = new TestThreadPool(getClass().getName());
        verify(blobContainer).asyncBlobUpload(any(WriteContext.class), any());
            }  
import java.nio.file.Path;
            completionListener.onFailure(new Exception("Test exception"));
        transferService.uploadBlobs(Collections.singleton(transferFileSnapshot), new HashMap<>() {
        }, latch), WritePriority.HIGH, null);
import java.io.IOException;  
        assertNull(exceptionRef.get());
        }, new LatchedActionListener<>(new ActionListener<>() {
            }  
        verify(blobContainer).asyncBlobUpload(any(WriteContext.class), any());
import org.opensearch.threadpool.ThreadPool;
    }
            testFile,
        }).when(blobContainer).asyncBlobUpload(any(WriteContext.class), any());  
            completionListener.onResponse(null);
        ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);
import java.nio.file.StandardOpenOption;  
    public void testUploadBlobs() throws Exception {
            randomNonNegativeLong(),  
    public void tearDown() throws Exception {
        AsyncMultiStreamBlobContainer blobContainer = mock(AsyncMultiStreamBlobContainer.class);
        Mockito.doAnswer(invocation -> {
            testFile,  
            @Override  
import org.opensearch.common.blobstore.stream.write.WritePriority;  
            randomNonNegativeLong(),  
            public void onFailure(Exception e) {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.OpenSearchTestCase;
        CountDownLatch latch = new CountDownLatch(1);
        CountDownLatch latch = new CountDownLatch(1);
        Files.write(testFile, randomByteArrayOfLength(128), StandardOpenOption.APPEND);
import static org.mockito.Mockito.mock;  
            0L
        TransferService transferService = new BlobStoreTransferService(blobStore, threadPool);
        );  
            public void onResponse(FileSnapshot.TransferFileSnapshot fileSnapshot) {  
        assertTrue(onResponseCalled.get());
                put(transferFileSnapshot.getPrimaryTerm(), new BlobPath().add("sample_path"));
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();
                onResponseCalled.set(true);
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();
        assertEquals(transferFileSnapshot.getName(), fileSnapshotRef.get().getName());  
import org.mockito.Mockito;
        );
        }, new LatchedActionListener<>(new ActionListener<>() {
        assertTrue(latch.await(1000, TimeUnit.MILLISECONDS));
            ActionListener<Void> completionListener = invocation.getArgument(1);  
 * this file be licensed under the Apache-2.0 license or a
            }
        Files.write(testFile, randomByteArrayOfLength(128), StandardOpenOption.APPEND);  
            {
            ActionListener<Void> completionListener = invocation.getArgument(1);
        assertTrue(latch.await(1000, TimeUnit.MILLISECONDS));
    public void testUploadBlobsUploadFutureCompletedExceptionally() throws Exception {
/*  
        FileSnapshot.TransferFileSnapshot transferFileSnapshot = new FileSnapshot.TransferFileSnapshot(
        assertFalse(onResponseCalled.get());  
                exceptionRef.set(e);
package org.opensearch.index.translog.transfer;
    private BlobStore blobStore;
        assertTrue(exceptionRef.get() instanceof FileTransferException);
        super.tearDown();  
    }  
        assertTrue(latch.await(1000, TimeUnit.MILLISECONDS));
        FileSnapshot.TransferFileSnapshot transferFileSnapshot = new FileSnapshot.TransferFileSnapshot(
import java.nio.file.Files;
        AsyncMultiStreamBlobContainer blobContainer = mock(AsyncMultiStreamBlobContainer.class);
                exceptionRef.set(e);
import org.opensearch.common.blobstore.BlobStore;
                put(transferFileSnapshot.getPrimaryTerm(), new BlobPath().add("sample_path"));
