    }
     *
            return downloadRateLimiter;
                    CorruptFileException corruptFileException = (CorruptFileException) throwable;
                } catch (Exception e) {
 * the remote store. Implementation of remaining methods will be added as remote store is integrated with
    }
     *
import java.util.function.UnaryOperator;
    public List<String> listFilesByPrefixInLexicographicOrder(String filenamePrefix, int limit) throws IOException {
                    e.addSuppressed(closeEx);
        BlobContainer targetBlobContainer
        return new RemoteIndexOutput(name, blobContainer);
    /**
     * Once soft deleting is supported segment files in the remote store, this method will provide details of
    protected long calculateChecksumOfChecksum(Directory directory, String file) throws IOException {
    ) {
        if (exception.get() != null) {
                limit,
        );
            throw new IOException(exception.get());
     * classes of upload-path lifecycle bug:
     * Temporary IndexOutput is not required while working with Remote store.
        return new RemoteIndexInput(name, inputStream, fileLength);
 *
     *
        UnaryOperator<OffsetRangeInputStream> rateLimiter = lowPriorityUpload ? lowPriorityUploadRateLimiter : uploadRateLimiter;
        assert ioContext != IOContext.READONCE : "Remote upload will fail with IoContext.READONCE";
            }
            lowPriorityUpload = lowPriorityUpload || contentLength > ByteSizeUnit.GB.toBytes(15);
    public RemoteDirectory(BlobContainer blobContainer) {
            // TODO - Explore how we can buffer small chunks of data instead of having the whole 8MB block in memory
import org.opensearch.common.blobstore.stream.write.WritePriority;
            blobContainer.listBlobsByPrefixInSortedOrder(
        return openInput(name, fileLength(name), context);
        this.lowPriorityUploadRateLimiter = lowPriorityUploadRateLimiter;
    /**
        byte[] bytes;
     * {@code provideStream()} for the other parts fails with {@code AlreadyClosedException}. {@code slice()} allocates
    public void sync(Collection<String> names) throws IOException {
            inputStream = blobContainer.readBlob(name);
    }
     * @param context desired {@link IOContext} context
     * Creates and returns a new instance of {@link RemoteIndexOutput} which will be used to copy files to the remote
    public long fileLength(String name) throws IOException {
     * Returns names of all files stored in this directory. The output must be in sorted (UTF-16,
    }
    /**
        boolean lowPriorityUpload,
                            "IndexInput for [{}] closed a second time (double-close) on thread [{}]; "
                try {
    }
     */
            contentLength = indexInput.length();
 * A remoteDirectory contains only files (no sub-folder hierarchy). This class does not support all the methods in
        // ToDo: Add a check for file existence
     *       happen while parts are still being served.</li>
    /**
            return getBlockInput(name, position, length, fileLength);
        IOContext ioContext,
     *
        IOContext context,
            new OffsetRangeIndexInputStream(indexInput.slice("part@" + position, position, size), size, 0)
    public void deleteFile(String name) throws IOException {
    @Override
                } catch (IOException e) {
        String src,
        this.pendingDownloadMergedSegments = pendingDownloadMergedSegments;
        }
                }
    private boolean isMergedSegment(String remoteFilename) {
                        + ", directory: "
    }
            }
        try {
        String name,
     * Returns names of files with given prefix in this directory.
    public IndexOutput createOutput(String name, IOContext context) {
     *
        ActionListener<Void> listener,
        final CountDownLatch latch = new CountDownLatch(1);
                                + "possible lifecycle bug in the upload path",
     *
                        () -> new ParameterizedMessage(
            if (targetBlobContainer instanceof AsyncMultiStreamBlobContainer asyncContainer) {
    public IndexInput openInput(String name, IOContext context) throws IOException {
     * @param name       the name of an existing file
     * Returns the byte length of a file in the directory.
     * @param fileLength file length
    public void deleteFiles(List<String> names) throws IOException {
     * Map containing the mapping of segment files that are pending download as part of the pre-copy (warm) phase of
    }
     * @param name the name of an existing file.
                    listener.onFailure(corruptIndexException);
    @Override
import org.apache.lucene.store.IndexOutput;
    ) {
            partSize,
     * Removes an existing file in the directory.
            UnaryOperator<InputStream> downloadRateLimiter,
     */
        return blobContainer;
                    logger.debug(() -> new ParameterizedMessage("IndexInput.close() for [{}]", src));
                offsetRangeInputStreamSupplier,
     * {@link ParallelPartInputStream} for the exact semantics.
            }
     * @param indexInput        the master {@link IndexInput} for the file being uploaded
    private final DownloadRateLimiterProvider downloadRateLimiterProvider;
     *   <li><b>Use-after-close</b> — a {@link #clone()} (which the part supplier reaches via {@code slice()}) attempted
                } catch (Exception e) {
     * @param position block start position
     * @throws IOException in case of I/O error
     * As this method is used by IndexWriter to publish commits, the implementation of this method is required when
        UnaryOperator<OffsetRangeInputStream> uploadRateLimiter,
    /**
    private class DownloadRateLimiterProvider {
    }
        }
     * Resolves the {@link BlobContainer} that holds the given blob. Subclasses that spread blobs across several
        return new ByteArrayIndexInput(name, bytes);
    }
     *       after the master has been closed means the master was released before all parts finished, which must not
 * compatible open source license.
                } catch (Exception closeEx) {
    @Override
        throw new UnsupportedOperationException();
import org.opensearch.common.blobstore.exception.CorruptFileException;
     */
        long fileLength,
        );
            }
     * exception.
import org.opensearch.common.lucene.store.ByteArrayIndexInput;
                );
        if (metadata.size() == 1 && metadata.get(0).name().equals(name)) {
     * wrapper sharing the same delegate, causing a spurious double-close when that shallow copy is released. See PR
     * Builds the per-part {@link RemoteTransferContainer.OffsetRangeInputStreamSupplier} used to feed the multipart
     * Returns stream emitted from by blob object. Should be used with a closeable block.
     * This is a deviation from the {@code Directory} interface where it is expected to throw either
     */
     * @throws UnsupportedOperationException always
    @Override
    public void rename(String source, String dest) throws IOException {
        }
     * being downloaded is a merged segment as part of the pre-copy (warm) phase of
     */
    public void syncMetaData() {
            }
     *
import org.opensearch.common.blobstore.BlobMetadata;
            throw e;
import org.opensearch.common.blobstore.BlobContainer;
package org.opensearch.index.store;
            public void close() throws IOException {
     *
        public UnaryOperator<InputStream> get(final String filename) {
    public IndexInput openBlockInput(String name, long position, long length, long fileLength, IOContext context) throws IOException {
     * Guaranteed to throw an exception and leave the directory unmodified.
 * The OpenSearch Contributors require contributions made to
        IOContext ioContext,
        boolean lowPriorityUpload
            throw e;
            }, ex -> {
import org.apache.logging.log4j.Logger;
    /**
import java.io.FileNotFoundException;
                if (indexInputClosed.get()) {
     * Once metadata to be stored with each shard is finalized, syncMetaData method will be used to sync the directory
        IndexInput indexInput,
        }
                IOException corruptIndexException = ExceptionsHelper.unwrapCorruption(ex);
    }
                    postUploadRunner.run();
        Directory from,
     * @param name the name of an existing file.
    protected IndexInput wrapWithLifecycleTracking(IndexInput rawIndexInput, String src) {
     *       the same master input. The multipart upload defers the master close to the completion listener (fired
    private final UnaryOperator<OffsetRangeInputStream> lowPriorityUploadRateLimiter;
     */
    }
     * @throws IOException in case of I/O error
    }
import org.apache.lucene.store.IndexInput;
     */
                // Delegate to the underlying IndexInput's clone() — NOT super.clone(). FilterIndexInput inherits
            try {
        UnaryOperator<InputStream> downloadRateLimiter,
    }
     * which would inherit {@code Object.clone()} and produce a shallow {@link org.apache.lucene.store.FilterIndexInput}
        String remoteFileName,
     *
import java.nio.file.NoSuchFileException;
     * @throws NoSuchFileException if the file does not exist
    }
     * Guaranteed to throw an exception and leave the directory unmodified.
        return blobContainer.listBlobs().keySet().stream().sorted().toArray(String[]::new);
            return;
import java.util.Collection;
        UnaryOperator<InputStream> lowPriorityDownloadRateLimiter,
            if (isMergedSegment(filename)) {
            });
    @Override
                            Thread.currentThread().getName()
            bytes = downloadRateLimiterProvider.get(name).apply(inputStream).readAllBytes();
     * the cache contents to the store permanently.
                try {
     *
            });
    protected void uploadBlob(
     * bytes sequentially, and returns a {@link RemoteIndexInput} enclosing it. Parts ahead of the reader are
import org.apache.lucene.store.IOContext;
     */
     * @throws UnsupportedOperationException always
        }, latch);
            public void onResponse(List<BlobMetadata> blobMetadata) {
     *
import java.util.Map;
     * {@link org.opensearch.index.engine.MergedSegmentWarmer}. The key is the local filename and value is the remote filename.
        if (blobContainer instanceof AsyncMultiStreamBlobContainer) {
                actionListener
                filenamePrefix,
                    );
        try (IndexInput indexInput = directory.openInput(file, IOContext.READONCE)) {
                    inputStream.close();
                listener.onFailure(ex);
import java.util.ArrayList;
                    logger.warn("Error occurred while closing index input", e);
     * the stream.
        IOContext context,
     * @param name the name of an existing file.
/**
     * store.
        long partSize,
    }
import org.opensearch.core.action.ActionListener;
            logger.error("Exception while reading blob for file: " + name + " for path " + blobContainer.path());
import java.util.concurrent.CountDownLatch;
    private IndexInput getBlockInput(String name, long position, long length, long fileLength) throws IOException {
    private static final Logger logger = LogManager.getLogger(RemoteDirectory.class);
     * {@link NoSuchFileException} or {@link FileNotFoundException} if {@code name} points to a non-existing file.
    }
        if (position < 0 || length <= 0 || (position + length > fileLength)) {
     * This may change in the future if segment upload to remote store happens via cache and we need sync API to write
     * any one part's stream closes, {@code Arrays.fill(segments, null)} corrupts the shared array and every subsequent
     * new Java object pointing into the already-mapped region. See PR #22309.
     * #22309.
        } catch (InterruptedException e) {
    ) {
        DownloadRateLimiterProvider(
     * containers override this.
        long contentLength;
            logger.warn("Exception while calling asyncBlobUpload, closing IndexInput to avoid leak");
     * @return a supplier that produces an independent, rate-limited stream for each requested part
        return blobContainer.listBlobsByPrefix(filenamePrefix).keySet();
        if (names == null || names.isEmpty()) {
     * slice, so closing one part only nullifies its own private copy. No extra mmap is created — each slice is just a
                null,
                    listener.onFailure(new CorruptIndexException(corruptFileException.getMessage(), corruptFileException.getFileName()));
        InputStream inputStream = null;
    }
     * than a {@link IndexInput#clone()}. This is intentional and must not be changed back to {@code clone()}:
     *
import org.opensearch.common.blobstore.transfer.stream.OffsetRangeIndexInputStream;
    }
     * Guaranteed to throw an exception and leave the directory unmodified.
                BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC,
import org.apache.lucene.store.Directory;
     *
     * Guaranteed to throw an exception and leave the directory unmodified.
    public BlobContainer getBlobContainer() {
import static org.opensearch.common.blobstore.transfer.RemoteTransferContainer.checksumOfChecksum;
                throw new ChecksumCombinationException(
     * <p>Because the slice already starts at {@code position}, the returned stream reads from offset {@code 0}.
     * Opens a stream for reading an existing file and returns {@link RemoteIndexInput} enclosing the stream.
import org.opensearch.cluster.metadata.CryptoMetadata;
            getBlobContainerForBlob(name),
            return metadata.get(0).length();
     * upload, applying the appropriate rate limiter for the upload priority.
 * the Directory interface. Currently, it contains implementation of methods which are used to copy files to/from
        boolean lowPriorityUpload,
    public void delete() throws IOException {
                    file,
        } catch (Exception e) {
                cryptoMetadata
        }
     * <ul>
            @Override
    public String[] listAll() throws IOException {
        Directory from,
        Runnable postUploadRunner,
        } catch (Exception e) {
     * IndexWriter is backed by RemoteDirectory.
    public boolean copyFrom(
        throw new UnsupportedOperationException();
        Runnable postUploadRunner,
     * @return Stream from the blob object
     */
                exception.set(e);
                    logger.warn(
                    logger.warn(
            @Override
    /**
     * @throws IOException in case of I/O error
        Directory from,
    }
            if (inputStream != null) {
            WriteContext writeContext = remoteTransferContainer.createWriteContext();
                            "IndexInput.slice()/clone() attempted on already-closed IndexInput for [{}] on thread [{}]; "
     * @param lowPriorityUpload whether to apply the low-priority rate limiter
     */
     * @throws NoSuchFileException if the file does not exist
     */
import org.apache.logging.log4j.message.ParameterizedMessage;
    /**
            } catch (Exception e) {
        }
     */
import org.opensearch.common.blobstore.transfer.RemoteTransferContainer;
    public IndexInput openParallelInput(
    protected final Map<String, String> pendingDownloadMergedSegments;
                return in.clone();
            UnaryOperator<InputStream> rateLimiter = downloadRateLimiterProvider.get(name);
            );
     */
     * If remote directory maintains a state in future, we need to clean it before closing the directory
                // when released. slice() lands here via FilterIndexInput#slice -> clone of the sliced delegate.
     * @param name the name of the file to copy to remote store.
    }
                    "Potentially corrupted file: Checksum combination failed while combining stored checksum "
     * <p> In the {@link Directory} interface, it is expected to throw {@link java.nio.file.FileAlreadyExistsException}
 */
     * @return the {@link RemoteIndexInput} enclosing the block stream
                if (throwable != null) {
     * Opens a stream for reading the existing file and returns {@link RemoteIndexInput} enclosing
    }
                    e
                remoteIntegrityEnabled = asyncContainer.remoteIntegrityCheckSupported();
                        )
            ActionListener<Void> completionListener = ActionListener.wrap(resp -> {
     *
            }
                }
        BlobContainer blobContainer,
    public Set<String> getPendingDeletions() throws IOException {
import java.io.IOException;
     * number of files marked as deleted but not actually deleted from the remote store.
    }
                }
     *
        String src,
     * an independent array copy (via {@code ArrayUtil.copyOfSubArray} in {@code buildSlice}) for each non-full-range
            logger.error("Exception while reading blob for file: " + name + " for path " + blobContainer.path());
     *
import org.opensearch.common.blobstore.transfer.stream.OffsetRangeInputStream;
import org.opensearch.core.common.unit.ByteSizeUnit;
            downloadRateLimiterProvider.get(name)
     * Removes multiple existing files in the directory in a batch operation.
     * remote store specific LockFactory.
public class RemoteDirectory extends Directory {
                lowPriorityUpload ? WritePriority.LOW : WritePriority.NORMAL,
                try {
     * Closes the remote directory. Currently, it is a no-op.
    /**
     * This is consistent with the behavior of {@link #deleteFile(String)}.
     * metadata to the remote store.
            this.downloadRateLimiter = downloadRateLimiter;
import org.opensearch.index.store.exception.ChecksumCombinationException;
        return (size, position) -> rateLimiter.apply(
import java.util.concurrent.atomic.AtomicReference;
                } else {
        // Do nothing
                    listener.onFailure(e);
            }
        final AtomicReference<Boolean> indexInputClosed = new AtomicReference<>(false);
                remoteIntegrityEnabled,
            RemoteTransferContainer.OffsetRangeInputStreamSupplier offsetRangeInputStreamSupplier;
                }
            throw new IllegalArgumentException("Invalid values of block start and size");
     * @param filenamePrefix The prefix to match against file names in the directory
     * <p>This method will not throw an exception when a file doesn't exist and simply ignores missing files.
            executor,
        blobContainer.deleteBlobsIgnoringIfNotExists(Collections.singletonList(name));
                return lowPriorityDownloadRateLimiter;
        ) {
                src,
                            Thread.currentThread().getName()
    /**
 * replication, peer recovery etc.
    /**
import org.opensearch.common.blobstore.AsyncMultiStreamBlobContainer;
        throw new UnsupportedOperationException();
    }
     * {@link org.opensearch.index.engine.MergedSegmentWarmer}.
     * Number of bytes in the segment file to store checksum
    }
import org.apache.lucene.store.Lock;
import java.util.Optional;
        return blobContainer;
                }
     * @throws IOException if the file exists but could not be deleted.
     * @return a tracking {@link IndexInput} that delegates to {@code rawIndexInput}
     * prefetched on {@code executor} subject to the node-wide {@code permits} budget; see
        ActionListener<Void> listener,
     */
        LatchedActionListener<List<BlobMetadata>> actionListener = new LatchedActionListener<>(new ActionListener<>() {
     * Opens a stream for reading one block from the existing file and returns {@link RemoteIndexInput} enclosing
}
                        + "and calculated checksum of stored checksum in segment file: "
                uploadBlob(from, src, remoteFileName, context, postUploadRunner, listener, lowPriorityUpload, cryptoMetadata);
import org.apache.logging.log4j.LogManager;
        // ToDo: Instead of calling remote store each time, keep a cache with segment metadata
        CryptoMetadata cryptoMetadata
     *
            });
        IndexInput indexInput = wrapWithLifecycleTracking(from.openInput(src, ioContext), src);
        Runnable postUploadRunner,
    public Collection<String> listFilesByPrefix(String filenamePrefix) throws IOException {
                    indexInput.close();
    }
     * @param length block length
                    remoteTransferContainer.close();
        };
 */
    /**
        try {
        throw new UnsupportedOperationException();
        this.blobContainer = blobContainer;
    private static final int SEGMENT_CHECKSUM_BYTES = 8;
                expectedChecksum,
     * @param partSize   size of each byte-range part
    }
                        )
                        () -> new ParameterizedMessage(
    }
        }
     */
     * DownloadRateLimiterProvider returns a low-priority rate limited stream if the segment
     *       after publication completes); a second close indicates a leak or an errant close elsewhere.</li>
        boolean lowPriorityUpload,
     *
     * Wraps the master {@link IndexInput} used for a multipart upload with lifecycle tracking that surfaces two
                }
     * @throws UnsupportedOperationException always
     *   <li><b>Double-close</b> — {@link #close()} being invoked more than once means two code paths are releasing
import java.util.List;
            );
        blobContainer.delete();
    /**
        private final UnaryOperator<InputStream> downloadRateLimiter;
    }
        } catch (Exception e) {
                return checksumOfChecksum(indexInput, SEGMENT_CHECKSUM_BYTES);
            name,
import java.util.Collections;
     * @return the {@link RemoteIndexInput} enclosing the block stream
        return Optional.empty();
    public Optional<FormatBlobRouter> getFormatBlobRouter() {
            public void onFailure(Exception e) {
     * @throws IOException if the files exist but could not be deleted.
     * @return A list of the matching filenames in the directory
        return blobContainer.readBlob(fileName);
        List<String> sortedBlobList = new ArrayList<>();
                }
     * Guaranteed to throw an exception and leave the directory unmodified.
     * @param name the name of an existing file.
     *
        ActionListener<Void> listener,
        }
            completionListener = ActionListener.runBefore(completionListener, () -> {
            throw e;
        uploadBlob(from, src, remoteFileName, ioContext, postUploadRunner, listener, lowPriorityUpload, cryptoMetadata, blobContainer);
     * @throws IOException if there were any failures in reading from the blob container
     * Once locking segment files in remote store is supported, implementation of this method is required with
            RemoteTransferContainer remoteTransferContainer = new RemoteTransferContainer(
import java.util.stream.Collectors;
        throw new UnsupportedOperationException();
     * @param fileName Name of file
     *
        this(blobContainer, UnaryOperator.identity(), UnaryOperator.identity(), UnaryOperator.identity(), UnaryOperator.identity(), null);
     * @throws IOException if fetch of stream fails with IO error
            offsetRangeInputStreamSupplier = createOffsetRangeInputStreamSupplier(indexInput, lowPriorityUpload);
                true,
    @Override
    public IndexInput openInput(String name, long fileLength, IOContext context) throws IOException {
     * @param fileLength file length
                            src,
import java.io.InputStream;
        UnaryOperator<OffsetRangeInputStream> lowPriorityUploadRateLimiter,
     * @param src           the source file name, for log context
        blobContainer.deleteBlobsIgnoringIfNotExists(names);
            // In case the RemoteIndexInput creation fails, close the input stream to avoid file handler leak.
     * Segment upload to the remote store will be permanent and does not require a separate sync API.
            public IndexInput clone() {
    /**
    protected RemoteTransferContainer.OffsetRangeInputStreamSupplier createOffsetRangeInputStreamSupplier(
    public RemoteDirectory(
     */
     * Guaranteed to throw an exception and leave the directory unmodified.
        try {
     * @param fileLength file length
     * @param context desired {@link IOContext} context
                if (indexInputClosed.getAndSet(true)) {
     */
                    );
            }
     */
        try {
    protected void uploadBlob(
     * <p>Each part is backed by an independent {@link IndexInput#slice(String, long, long)} of the master input rather
        return false;
    ) throws Exception {
    @Override
     * @param permits    node-wide budget bounding the number of prefetched parts in flight
     * </ul>
            return true;
            boolean remoteIntegrityEnabled = false;
    /**
     * @throws UnsupportedOperationException always
     * @param name the name of an existing file.
     */
            return new RemoteIndexInput(name, rateLimiter.apply(inputStream), fileLength);
                        + file
    /**
     * @throws UnsupportedOperationException always
     */
    public IndexOutput createTempOutput(String prefix, String suffix, IOContext context) {
     * @param executor   executor on which prefetch tasks run
    ) throws Exception {
 * A {@code RemoteDirectory} provides an abstraction layer for storing a list of files to a remote store.
    }
    /**
     */
     * <p>Both conditions are logged (not thrown) so a latent lifecycle bug is visible in logs without changing upload
            UnaryOperator<InputStream> lowPriorityDownloadRateLimiter
    }
/*
import org.opensearch.action.LatchedActionListener;
        return pendingDownloadMergedSegments != null && pendingDownloadMergedSegments.containsValue(remoteFilename);
            permits,
import org.opensearch.index.store.remote.FormatBlobRouter;
                    return;
            fileLength,
                            src,
     */
    }
    /**
    /**
                    listener.onResponse(null);
        try (InputStream inputStream = blobContainer.readBlob(name, position, length)) {
        ParallelDownloadPermits permits
     */
     * @throws NoSuchFileException if the file does not exist
    /**
        } else {
    ) {
                Throwable throwable = ExceptionsHelper.unwrap(ex, CorruptFileException.class);
        return new org.apache.lucene.store.FilterIndexInput("tracked:" + src, rawIndexInput) {
        }
    }
     * @throws UnsupportedOperationException always
                    logger.error(() -> new ParameterizedMessage("Exception in segment postUpload for file [{}]", src), e);
    public InputStream getBlobStream(String fileName) throws IOException {
    protected final BlobContainer blobContainer;
import java.util.concurrent.Executor;
                        + directory,
        CryptoMetadata cryptoMetadata,
     * Opens a stream that reads the existing file as multiple byte-range parts in parallel while presenting the
            throw new IOException("Exception in listFilesByPrefixInLexicographicOrder with prefix: " + filenamePrefix, e);
     * @throws IOException in case of I/O error
    public Lock obtainLock(String name) throws IOException {
            @Override
            }
                listener.onFailure(e);
        List<BlobMetadata> metadata = blobContainer.listBlobsByPrefixInSortedOrder(name, 1, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC);
     * @param rawIndexInput the freshly opened master {@link IndexInput}
        }
     * @param names the collection of filenames to delete.
    /**
                    logger.warn("Error occurred while closing streams", e);
import org.opensearch.ExceptionsHelper;
                // Object.clone(), which yields a shallow wrapper sharing the same 'in' field and double-closes it
        throw new NoSuchFileException(name);
    /**
            latch.await();
                                + "the master was closed before all parts completed",
import org.apache.lucene.index.CorruptIndexException;
        }
            @Override
     * @throws NoSuchFileException if the file does not exist
    @Override
        Executor executor,
     * the block stream.
        }
    }
 * @opensearch.internal
            ((AsyncMultiStreamBlobContainer) targetBlobContainer).asyncBlobUpload(writeContext, completionListener);
 *
                contentLength,
import java.util.Set;
import org.opensearch.common.blobstore.stream.write.WriteContext;
    public void close() throws IOException {
    /**
        this.uploadRateLimiter = uploadRateLimiter;
                if (corruptIndexException != null) {
     * if the file already exists in the remote store. As this method does not open a file, it does not throw the
     */
     *
        private final UnaryOperator<InputStream> lowPriorityDownloadRateLimiter;
                    return;
    /**
        AtomicReference<Exception> exception = new AtomicReference<>();
            this.lowPriorityDownloadRateLimiter = lowPriorityDownloadRateLimiter;
                }
    @Override
        Map<String, String> pendingDownloadMergedSegments
    @Override
        }
    @Override
 * SPDX-License-Identifier: Apache-2.0
        long expectedChecksum = calculateChecksumOfChecksum(from, src);
                try {
            try {
        throw new UnsupportedOperationException();
    protected BlobContainer getBlobContainerForBlob(String name) {
    @Override
        String remoteFileName,
     * behavior. {@code clone()} delegates to the underlying input's {@code clone()} — <b>not</b> {@code super.clone()},
    private final UnaryOperator<OffsetRangeInputStream> uploadRateLimiter;
     * @param context    desired {@link IOContext} context
        String remoteFileName,
     * @return the {@link RemoteIndexInput} enclosing the multi-part stream
    }
        CryptoMetadata cryptoMetadata
            completionListener = ActionListener.runAfter(completionListener, () -> {
            } catch (Exception e) {
        this.downloadRateLimiterProvider = new DownloadRateLimiterProvider(downloadRateLimiter, lowPriorityDownloadRateLimiter);
        final InputStream inputStream = new ParallelPartInputStream(
     * {@code MemorySegmentIndexInput.clone()} shares the master's {@code MemorySegment[]} array by reference, so when
            indexInput.close();
                remoteFileName,
                super.close();
        String src,
                sortedBlobList.addAll(blobMetadata.stream().map(BlobMetadata::name).collect(Collectors.toList()));
     * <p>This method will not throw an exception when the file doesn't exist and simply ignores this case.
 * this file be licensed under the Apache-2.0 license or a
            return sortedBlobList;
     *
                logger.error(() -> new ParameterizedMessage("Failed to upload blob {}", src), ex);
     * java's {@link String#compareTo}) order.
