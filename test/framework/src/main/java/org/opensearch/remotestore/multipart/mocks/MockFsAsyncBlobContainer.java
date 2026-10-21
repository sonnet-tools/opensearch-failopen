    @Override
    @Override
        if (writeContext.getFileSize() != totalContentRead.get()) {
                    long offset = partSize * finalPartIdx;
                        totalContentRead.addAndGet(readContentLength);
    }
     * JVM, which is no fencing primitive between hosts, so remote store fencing correctly refuses it in production.
import java.util.ArrayList;
        long partSize = writeContext.getFileSize() / nParts;
 * this file be licensed under the Apache-2.0 license or a
 *
                        offset += readContentLength;
        StreamContext streamContext = writeContext.getStreamProvider(partSize);
    }
            });
                    InputStream inputStream = inputStreamContainer.getInputStream();
import java.util.concurrent.TimeUnit;
        new Thread(() -> {
        }
                );
                    InputStreamContainer blobPartStream = new InputStreamContainer(readBlob(blobName, offset, partSize), partSize, offset);
                } catch (IOException e) {
    }
                listener.onResponse(blobReadContext);
                    )
    private boolean isSegmentFile(String filename) {
    private static final int TRANSFER_TIMEOUT_MILLIS = 30000;
                ReadContext blobReadContext = new ReadContext.Builder(contentLength, blobPartStreams).build();
            throw new IOException("Await interrupted on CountDownLatch, transfer failed for " + writeContext.getFileName());
import org.opensearch.common.blobstore.fs.FsBlobStore;
import org.opensearch.core.action.ActionListener;
import org.opensearch.common.blobstore.stream.write.WriteContext;
package org.opensearch.remotestore.multipart.mocks;
import java.io.OutputStream;
                    while (remainingContentLength > 0) {
        try (OutputStream outputStream = Files.newOutputStream(file, StandardOpenOption.CREATE_NEW)) {
                completionListener.onResponse(null);
                int numberOfParts = (int) ((contentLength % partSize) == 0 ? contentLength / partSize : (contentLength / partSize) + 1);
import java.util.concurrent.CountDownLatch;
            completionListener.onFailure(e);
        }
            try {
import org.opensearch.common.blobstore.DeleteResult;
    public boolean remoteIntegrityCheckSupported() {
                        int readContentLength = inputStream.read(buffer, (int) offset, (int) remainingContentLength);
import java.nio.file.Path;
import org.opensearch.common.io.InputStreamContainer;
        this.triggerDataIntegrityFailure = triggerDataIntegrityFailure;
import java.io.InputStream;
        for (int partIdx = 0; partIdx < streamContext.getNumberOfParts(); partIdx++) {
    public void deleteBlobsAsyncIgnoringIfNotExists(List<String> blobNames, ActionListener<Void> completionListener) {
    public void deleteAsync(ActionListener<DeleteResult> completionListener) {
        } catch (InterruptedException e) {
                    + ", bytes read: "
            } else {
        int nParts = 10;
     */
            }
                    completionListener.onFailure(e);
                } finally {
                writeContext.getUploadFinalizer().accept(true);
 * SPDX-License-Identifier: Apache-2.0
    }
        AtomicLong totalContentRead = new AtomicLong();
import java.util.List;
    public void readBlobAsync(String blobName, ActionListener<ReadContext> listener) {
            int finalPartIdx = partIdx;
import org.opensearch.common.blobstore.AsyncMultiStreamBlobContainer;
                    + ", actual file size: "
            }
        throw new UnsupportedOperationException("deleteAsync");
import org.opensearch.common.StreamContext;
                }
            }
        byte[] buffer = new byte[(int) writeContext.getFileSize()];
                        )
            );
        }
                    + writeContext.getFileSize()
                    + writeContext.getFileName()
                try {
            // bulks need to succeed for segment files to be generated
                throw new IOException("Timed out waiting for file transfer to complete for " + writeContext.getFileName());
                            writeContext.getFileName()
import java.nio.file.Files;
        }).start();
    }
                        new CorruptIndexException(
            if (isSegmentFile(writeContext.getFileName()) && triggerDataIntegrityFailure) {
            Thread thread = new Thread(() -> {
     * Test support only. {@link FsBlobContainer} reports {@code false} because its conditional write is emulated per
                    InputStreamContainer inputStreamContainer = streamContext.provideStream(finalPartIdx);
import org.apache.lucene.index.CorruptIndexException;
        super(blobStore, blobPath, path);
                }
    @Override
    /**
                            "Data integrity check failure for file: " + writeContext.getFileName(),
        final Path file = path.resolve(writeContext.getFileName());
                long contentLength = listBlobs().get(blobName).length();
    public void asyncBlobUpload(WriteContext writeContext, ActionListener<Void> completionListener) throws IOException {
                        remainingContentLength -= readContentLength;
                    + totalContentRead.get()
     * without weakening the production guard.
import java.nio.file.StandardOpenOption;
        return true;
                    latch.countDown();
    }
                "Incorrect content length read for file "
 */
                for (int partNumber = 0; partNumber < numberOfParts; partNumber++) {
        CountDownLatch latch = new CountDownLatch(streamContext.getNumberOfParts());
}
public class MockFsAsyncBlobContainer extends FsBlobContainer implements AsyncMultiStreamBlobContainer {
            if (!latch.await(TRANSFER_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)) {
 * compatible open source license.
            throw new IOException(
     * precondition genuinely exclusive here. Overriding keeps fencing exercisable through the mock remote-store
 * The OpenSearch Contributors require contributions made to
                    long remainingContentLength = inputStreamContainer.getContentLength();
import org.opensearch.common.blobstore.fs.FsBlobContainer;
                    }
import java.util.concurrent.CompletableFuture;
    private final boolean triggerDataIntegrityFailure;
                    long offset = partNumber * partSize;
/*
        } catch (Exception e) {
        }
                listener.onFailure(e);
                    blobPartStreams.add(() -> CompletableFuture.completedFuture(blobPartStream));
        throw new UnsupportedOperationException("deleteBlobsAsyncIgnoringIfNotExists");
     * repositories - which {@code RemoteStoreBaseIntegTestCase} selects at random via {@code asyncUploadMockFsRepo} -
    @Override
        return !filename.endsWith(".tlog") && !filename.endsWith(".ckp");
            thread.start();
     * Integration tests run every cluster node inside one JVM and therefore share that emulation, making the
    }
                    new RuntimeException(
import org.opensearch.common.blobstore.BlobPath;
                    inputStream.close();
                List<ReadContext.StreamPartCreator> blobPartStreams = new ArrayList<>();
import java.util.concurrent.atomic.AtomicLong;
        return true;
                long partSize = contentLength / 10;
    @Override
import java.io.IOException;
    public boolean isConditionalWriteSupported() {
    }
            outputStream.write(buffer);
        try {
        try {
            } catch (Exception e) {
import org.opensearch.common.blobstore.stream.read.ReadContext;
    public MockFsAsyncBlobContainer(FsBlobStore blobStore, BlobPath blobPath, Path path, boolean triggerDataIntegrityFailure) {
        }
                completionListener.onFailure(
