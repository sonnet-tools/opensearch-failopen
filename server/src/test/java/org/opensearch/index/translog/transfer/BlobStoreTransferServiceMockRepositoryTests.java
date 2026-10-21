        assertTrue(latch.await(1000, TimeUnit.MILLISECONDS));
        assertTrue(exceptionRef.get() instanceof FileTransferException);
        super.setUp();
        }, listener, WritePriority.HIGH, null);
import org.mockito.Mockito;
        transferService.uploadBlobs(Collections.singleton(transferFileSnapshot), new HashMap<>() {
            @Override
 * The OpenSearch Contributors require contributions made to
        when(blobStore.blobContainer(any(BlobPath.class))).thenReturn(blobContainer);
 *
        }, latch), WritePriority.HIGH, null);
        verify(blobContainer).asyncBlobUpload(any(WriteContext.class), any());
import java.util.concurrent.atomic.AtomicBoolean;
        threadPool = new TestThreadPool(getClass().getName());
        AtomicReference<FileSnapshot.TransferFileSnapshot> fileSnapshotRef = new AtomicReference<>();
            }
        );
        Mockito.doAnswer(invocation -> {
        );
import static org.mockito.Mockito.mock;
            @Override
        assertEquals(transferFileSnapshot.getPrimaryTerm(), fileSnapshotRef.get().getPrimaryTerm());
import java.util.concurrent.TimeUnit;
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();
        CountDownLatch latch = new CountDownLatch(1);
                fileSnapshotRef.set(fileSnapshot);
            public void onFailure(Exception e) {
            }
    }
            public void onFailure(Exception e) {
        FileSnapshot.TransferFileSnapshot transferFileSnapshot = new FileSnapshot.TransferFileSnapshot(
        AtomicBoolean onResponseCalled = new AtomicBoolean(false);
import java.nio.file.StandardOpenOption;
            completionListener.onFailure(new Exception("Test exception"));
import org.opensearch.core.action.ActionListener;
            ActionListener<Void> completionListener = invocation.getArgument(1);
            completionListener.onResponse(null);
            }
            0L
        FileSnapshot.TransferFileSnapshot transferFileSnapshot = new FileSnapshot.TransferFileSnapshot(
        Mockito.doAnswer(invocation -> {
        Path testFile = createTempFile();
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.common.blobstore.BlobPath;
        TransferService transferService = new BlobStoreTransferService(blobStore, threadPool);
    private BlobStore blobStore;
        }, latch);
                onResponseCalled.set(true);
import java.util.concurrent.atomic.AtomicReference;
import static org.mockito.Mockito.when;
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();
            }
        );
            ActionListener<Void> completionListener = invocation.getArgument(1);
    }
        super.tearDown();
            return null;
        assertTrue(latch.await(1000, TimeUnit.MILLISECONDS));
                exceptionRef.set(e);
import static org.mockito.Mockito.verify;
    private ThreadPool threadPool;
        Path testFile = createTempFile();
 * compatible open source license.
        ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);
import java.util.HashMap;
            }
 * this file be licensed under the Apache-2.0 license or a
    }
        when(blobStore.blobContainer(any(BlobPath.class))).thenReturn(blobContainer);
        TransferService transferService = new BlobStoreTransferService(blobStore, threadPool);
import static org.mockito.Mockito.doThrow;
            @Override
            public void onResponse(FileSnapshot.TransferFileSnapshot fileSnapshot) {
            {
 */
    public void testUploadBlobs() throws Exception {
        Files.write(testFile, randomByteArrayOfLength(128), StandardOpenOption.APPEND);
        assertTrue(onResponseCalled.get());
import org.opensearch.threadpool.TestThreadPool;
        when(blobStore.blobContainer(any(BlobPath.class))).thenReturn(blobContainer);
                exceptionRef.set(e);
                put(transferFileSnapshot.getPrimaryTerm(), new BlobPath().add("sample_path"));
import java.nio.file.Path;
import java.nio.file.Files;
        }, new LatchedActionListener<>(new ActionListener<>() {
        CountDownLatch latch = new CountDownLatch(1);
            0L
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.common.blobstore.stream.write.WriteContext;
            testFile,
            public void onResponse(FileSnapshot.TransferFileSnapshot fileSnapshot) {
        LatchedActionListener<FileSnapshot.TransferFileSnapshot> listener = new LatchedActionListener<>(new ActionListener<>() {
            }
    }
        }).when(blobContainer).asyncBlobUpload(any(WriteContext.class), any());
        }, latch), WritePriority.HIGH, null);
                exceptionRef.set(e);
    public void setUp() throws Exception {
        TransferService transferService = new BlobStoreTransferService(blobStore, threadPool);
        assertTrue(exceptionRef.get() instanceof FileTransferException);
        }, new LatchedActionListener<>(new ActionListener<>() {
        assertNull(exceptionRef.get());
            testFile,
import java.util.concurrent.CountDownLatch;
            }
            {
}
        AsyncMultiStreamBlobContainer blobContainer = mock(AsyncMultiStreamBlobContainer.class);
import org.opensearch.common.blobstore.BlobStore;
    public void tearDown() throws Exception {
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();
    @Override
        Files.write(testFile, randomByteArrayOfLength(128), StandardOpenOption.APPEND);
        assertEquals(transferFileSnapshot.getName(), fileSnapshotRef.get().getName());
            randomNonNegativeLong(),
import java.io.IOException;
        assertTrue(latch.await(1000, TimeUnit.MILLISECONDS));
            randomNonNegativeLong(),
import static org.mockito.ArgumentMatchers.any;
            @Override
        doThrow(new IOException()).when(blobContainer).asyncBlobUpload(any(WriteContext.class), any());
        verify(blobContainer).asyncBlobUpload(any(WriteContext.class), any());
            public void onResponse(FileSnapshot.TransferFileSnapshot fileSnapshot) {
        AsyncMultiStreamBlobContainer blobContainer = mock(AsyncMultiStreamBlobContainer.class);
        Files.write(testFile, randomByteArrayOfLength(128), StandardOpenOption.APPEND);
        Path testFile = createTempFile();
import org.opensearch.action.LatchedActionListener;
            0L
        FileSnapshot.TransferFileSnapshot transferFileSnapshot = new FileSnapshot.TransferFileSnapshot(
package org.opensearch.index.translog.transfer;
    public void testUploadBlobsUploadFutureCompletedExceptionally() throws Exception {
        assertFalse(onResponseCalled.get());
        AtomicBoolean onResponseCalled = new AtomicBoolean(false);
        assertFalse(onResponseCalled.get());
            public void onFailure(Exception e) {
    @Override
            }
        verify(blobContainer).asyncBlobUpload(any(WriteContext.class), any());
        }).when(blobContainer).asyncBlobUpload(any(WriteContext.class), any());
        transferService.uploadBlobs(Collections.singleton(transferFileSnapshot), new HashMap<>() {
                put(transferFileSnapshot.getPrimaryTerm(), new BlobPath().add("sample_path"));
import java.util.Collections;
 * SPDX-License-Identifier: Apache-2.0
            @Override
            }
        AtomicBoolean onResponseCalled = new AtomicBoolean(false);
import org.opensearch.common.blobstore.AsyncMultiStreamBlobContainer;
        CountDownLatch latch = new CountDownLatch(1);
            testFile,
    }
import org.opensearch.common.blobstore.stream.write.WritePriority;
                onResponseCalled.set(true);
            randomNonNegativeLong(),
                onResponseCalled.set(true);
            {
        blobStore = mock(BlobStore.class);
            return null;
public class BlobStoreTransferServiceMockRepositoryTests extends OpenSearchTestCase {
                put(transferFileSnapshot.getPrimaryTerm(), new BlobPath().add("sample_path"));
            @Override
        transferService.uploadBlobs(Collections.singleton(transferFileSnapshot), new HashMap<>() {
    public void testUploadBlobsIOException() throws Exception {
        AsyncMultiStreamBlobContainer blobContainer = mock(AsyncMultiStreamBlobContainer.class);
/*
