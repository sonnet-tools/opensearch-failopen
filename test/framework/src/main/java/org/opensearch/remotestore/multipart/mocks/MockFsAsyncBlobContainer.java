        }  
            }
import org.apache.lucene.index.CorruptIndexException;
                        int readContentLength = inputStream.read(buffer, (int) offset, (int) remainingContentLength);
                    long remainingContentLength = inputStreamContainer.getContentLength();
        long partSize = writeContext.getFileSize() / nParts;
import org.opensearch.common.blobstore.stream.read.ReadContext;  
    @Override
                writeContext.getUploadFinalizer().accept(true);  
import java.util.concurrent.atomic.AtomicLong;
                long partSize = contentLength / 10;
                try {
import java.io.InputStream;  
     */  
    }
    @Override  
    }
            Thread thread = new Thread(() -> {  
                    }
    }
        this.triggerDataIntegrityFailure = triggerDataIntegrityFailure;
        throw new UnsupportedOperationException("deleteAsync");
            completionListener.onFailure(e);
        try {  
    }  
    }  
        byte[] buffer = new byte[(int) writeContext.getFileSize()];
     * Integration tests run every cluster node inside one JVM and therefore share that emulation, making the
                    blobPartStreams.add(() -> CompletableFuture.completedFuture(blobPartStream));
     * Test support only. {@link FsBlobContainer} reports {@code false} because its conditional write is emulated per  
 * this file be licensed under the Apache-2.0 license or a
        new Thread(() -> {
            // bulks need to succeed for segment files to be generated
                        remainingContentLength -= readContentLength;  
     * JVM, which is no fencing primitive between hosts, so remote store fencing correctly refuses it in production.
    private static final int TRANSFER_TIMEOUT_MILLIS = 30000;
import org.opensearch.common.blobstore.AsyncMultiStreamBlobContainer;
    public void readBlobAsync(String blobName, ActionListener<ReadContext> listener) {
                    new RuntimeException(
                        offset += readContentLength;
                    + totalContentRead.get()
import java.nio.file.Path;  
                completionListener.onFailure(  
                } catch (IOException e) {
 * The OpenSearch Contributors require contributions made to
import java.nio.file.StandardOpenOption;
     * precondition genuinely exclusive here. Overriding keeps fencing exercisable through the mock remote-store  
     * without weakening the production guard.
                List<ReadContext.StreamPartCreator> blobPartStreams = new ArrayList<>();
            }
                    InputStreamContainer inputStreamContainer = streamContext.provideStream(finalPartIdx);
    @Override
import java.util.List;  
                        new CorruptIndexException(
 * compatible open source license.  
    private final boolean triggerDataIntegrityFailure;
            thread.start();
import org.opensearch.common.StreamContext;  
                    long offset = partSize * finalPartIdx;
            if (!latch.await(TRANSFER_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)) {
    public MockFsAsyncBlobContainer(FsBlobStore blobStore, BlobPath blobPath, Path path, boolean triggerDataIntegrityFailure) {  
                    inputStream.close();  
                    + ", actual file size: "
                int numberOfParts = (int) ((contentLength % partSize) == 0 ? contentLength / partSize : (contentLength / partSize) + 1);  
        }).start();  
 */
    }
            int finalPartIdx = partIdx;
            throw new IOException(
    public void asyncBlobUpload(WriteContext writeContext, ActionListener<Void> completionListener) throws IOException {
                    InputStream inputStream = inputStreamContainer.getInputStream();  
                        totalContentRead.addAndGet(readContentLength);
import java.util.concurrent.TimeUnit;  
import org.opensearch.common.blobstore.stream.write.WriteContext;
                completionListener.onResponse(null);
import java.io.IOException;
        StreamContext streamContext = writeContext.getStreamProvider(partSize);
    /**
        throw new UnsupportedOperationException("deleteBlobsAsyncIgnoringIfNotExists");  
                "Incorrect content length read for file "  
                    + writeContext.getFileName()
import org.opensearch.core.action.ActionListener;  
                );
import org.opensearch.common.blobstore.BlobPath;
                long contentLength = listBlobs().get(blobName).length();
        for (int partIdx = 0; partIdx < streamContext.getNumberOfParts(); partIdx++) {
        return true;  
        }
        return true;
        if (writeContext.getFileSize() != totalContentRead.get()) {
    public void deleteAsync(ActionListener<DeleteResult> completionListener) {  
                    while (remainingContentLength > 0) {  
    public void deleteBlobsAsyncIgnoringIfNotExists(List<String> blobNames, ActionListener<Void> completionListener) {
    }
     * repositories - which {@code RemoteStoreBaseIntegTestCase} selects at random via {@code asyncUploadMockFsRepo} -
        super(blobStore, blobPath, path);
public class MockFsAsyncBlobContainer extends FsBlobContainer implements AsyncMultiStreamBlobContainer {  
import org.opensearch.common.blobstore.fs.FsBlobStore;
                    + writeContext.getFileSize()  
                ReadContext blobReadContext = new ReadContext.Builder(contentLength, blobPartStreams).build();
}
import java.nio.file.Files;
                }  
                    )  
            throw new IOException("Await interrupted on CountDownLatch, transfer failed for " + writeContext.getFileName());
/*
            } else {
        CountDownLatch latch = new CountDownLatch(streamContext.getNumberOfParts());  
        int nParts = 10;  
                listener.onFailure(e);
                for (int partNumber = 0; partNumber < numberOfParts; partNumber++) {
    public boolean remoteIntegrityCheckSupported() {  
 *  
                        )
        }
            );  
            }  
import org.opensearch.common.blobstore.DeleteResult;  
            } catch (Exception e) {  
                listener.onResponse(blobReadContext);
                } finally {  
import java.util.concurrent.CountDownLatch;
                    long offset = partNumber * partSize;  
    public boolean isConditionalWriteSupported() {
package org.opensearch.remotestore.multipart.mocks;  
        final Path file = path.resolve(writeContext.getFileName());  
        return !filename.endsWith(".tlog") && !filename.endsWith(".ckp");
                    completionListener.onFailure(e);
import java.io.OutputStream;
        }
        } catch (InterruptedException e) {
import java.util.ArrayList;
    @Override  
    }
        try {  
            outputStream.write(buffer);
                    + ", bytes read: "
                }
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.io.InputStreamContainer;
import java.util.concurrent.CompletableFuture;
    private boolean isSegmentFile(String filename) {
            if (isSegmentFile(writeContext.getFileName()) && triggerDataIntegrityFailure) {
        AtomicLong totalContentRead = new AtomicLong();
    @Override
                            "Data integrity check failure for file: " + writeContext.getFileName(),  
import org.opensearch.common.blobstore.fs.FsBlobContainer;
            });  
                    latch.countDown();
                            writeContext.getFileName()
                throw new IOException("Timed out waiting for file transfer to complete for " + writeContext.getFileName());
        }  
        } catch (Exception e) {  
        try (OutputStream outputStream = Files.newOutputStream(file, StandardOpenOption.CREATE_NEW)) {
                    InputStreamContainer blobPartStream = new InputStreamContainer(readBlob(blobName, offset, partSize), partSize, offset);
            try {  
