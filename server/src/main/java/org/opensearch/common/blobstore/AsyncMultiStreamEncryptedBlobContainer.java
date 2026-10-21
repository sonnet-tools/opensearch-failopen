        /**
    }
/*
import org.opensearch.common.blobstore.stream.read.ReadContext;
 * The OpenSearch Contributors require contributions made to
        }
        private final long fileSize;
            if (blobSize == null) {
import org.opensearch.common.StreamContext;
            );
 */
        blobContainer.asyncBlobUpload(encryptedWriteContext, completionListener);
            super(streamContext);
        this.cryptoHandler = cryptoHandler;
            this.encryptionMetadata = this.cryptoHandler.initEncryptionMetadata();
    }
    @Override
    static class EncryptedStreamContext<T, U> extends StreamContext {
        @Override
import java.io.IOException;
                .apply(inputStreamContainer.getInputStream());
                cryptoContext,
         */
            this.fileSize = this.cryptoHandler.estimateEncryptedLengthOfEntireContent(encryptionMetadata, writeContext.getFileSize());
    public void deleteBlobsAsyncIgnoringIfNotExists(List<String> blobNames, ActionListener<Void> completionListener) {
    }
     */
            this.cryptoHandler = cryptoHandler;
        private InputStreamContainer decryptInputStreamContainer(InputStreamContainer inputStreamContainer) {
    @Override
 * this file be licensed under the Apache-2.0 license or a
            StreamContext streamContext = super.getStreamProvider(adjustedPartSize);
            super(writeContext);
                readContext -> new DecryptedReadContext<>(readContext, cryptoHandler, cryptoContext)
         * Construct a new encrypted WriteContext object
package org.opensearch.common.blobstore;
        } catch (Exception e) {
public class AsyncMultiStreamEncryptedBlobContainer<T, U> extends EncryptedBlobContainer<T, U> implements AsyncMultiStreamBlobContainer {
        }
        }
            return this.blobSize;
            long adjustedLength = decryptedStreamProvider.getAdjustedRange()[1] - adjustedPos + 1;
        /**
    public void deleteAsync(ActionListener<DeleteResult> completionListener) {
        public EncryptedStreamContext(StreamContext streamContext, CryptoHandler<T, U> cryptoHandler, T encryptionMetadata) {
        private final T encryptionMetadata;
            }
        public StreamContext getStreamProvider(long partSize) {
import org.opensearch.common.crypto.DecryptedRangedStreamProvider;
        private final CryptoHandler<T, U> cryptoHandler;
        }
            return new EncryptedStreamContext<>(streamContext, cryptoHandler, encryptionMetadata);
import org.opensearch.common.crypto.CryptoHandler;
            );
        }
            final InputStream decryptedStream = decryptedStreamProvider.getDecryptedStreamProvider()
         * Construct a new encrypted StreamContext object
}
         */
         * @return The total size of the encrypted file
        public EncryptedWriteContext(WriteContext writeContext, CryptoHandler<T, U> cryptoHandler) {
        private final CryptoHandler<T, U> cryptoHandler;
/**
 */
    private final CryptoHandler<T, U> cryptoHandler;
    }
            return cryptoHandler.createEncryptingStreamOfPart(encryptionMetadata, inputStreamContainer, getNumberOfParts(), partNumber);
    }
        return false;
    public AsyncMultiStreamEncryptedBlobContainer(AsyncMultiStreamBlobContainer blobContainer, CryptoHandler<T, U> cryptoHandler) {
        /**
            return new InputStreamContainer(decryptedStream, adjustedLength, adjustedPos);
            this.encryptionMetadata = encryptionMetadata;
         */
         * @return decrypted input stream container instance
        public DecryptedReadContext(ReadContext readContext, CryptoHandler<T, U> cryptoHandler, U cryptoContext) {
            ActionListener<ReadContext> decryptingCompletionListener = ActionListener.map(
 * EncryptedBlobContainer is an encrypted BlobContainer that is backed by a
    static class EncryptedWriteContext<T, U> extends WriteContext {
         * @param inputStreamContainer encrypted input stream container instance
            this.cryptoHandler = cryptoHandler;
        blobContainer.deleteBlobsAsyncIgnoringIfNotExists(blobNames, completionListener);
        }
            long endOfStream = startOfStream + inputStreamContainer.getContentLength() - 1;
    public void readBlobAsync(String blobName, ActionListener<ReadContext> listener) {
        }
                this.blobSize = this.cryptoHandler.estimateDecryptedLength(cryptoContext, super.getBlobSize());
            listener.onFailure(e);
        public long getBlobSize() {
import java.util.stream.Collectors;
        blobContainer.deleteAsync(completionListener);
        public long getFileSize() {
         */
         * Transforms an encrypted {@link InputStreamContainer} to a decrypted instance
            super(readContext);
            final U cryptoContext = cryptoHandler.loadEncryptionMetadata(getEncryptedHeaderContentSupplier(blobName));
    @Override
 * @opensearch.internal
        this.blobContainer = blobContainer;
    @Override
                .collect(Collectors.toUnmodifiableList());
            // initializes the value lazily
            this.cryptoHandler = cryptoHandler;
        public List<StreamPartCreator> getPartStreams() {
                endOfStream
import java.io.InputStream;
    private final AsyncMultiStreamBlobContainer blobContainer;
 * compatible open source license.
            long startOfStream = inputStreamContainer.getOffset();
        @Override
                .map(supplier -> (StreamPartCreator) () -> supplier.get().thenApply(this::decryptInputStreamContainer))
                listener,
    }
            return fileSize;
        public InputStreamContainer provideStream(int partNumber) throws IOException {
 * {@link AsyncMultiStreamBlobContainer}
    @Override
    public void asyncBlobUpload(WriteContext writeContext, ActionListener<Void> completionListener) throws IOException {
        private Long blobSize;
     * @param <T> Encryption Metadata / CryptoContext for the {@link CryptoHandler} instance
    public boolean remoteIntegrityCheckSupported() {
    }
    static class DecryptedReadContext<T, U> extends ReadContext {
     * the encrypted object
            DecryptedRangedStreamProvider decryptedStreamProvider = cryptoHandler.createDecryptingStreamOfRange(
     * @param <U> Parsed Encryption Metadata / CryptoContext for the {@link CryptoHandler} instance
        }
        private final U cryptoContext;
        super(blobContainer, cryptoHandler);
 *
 *
import java.util.List;
        private final CryptoHandler<T, U> cryptoHandler;
    }
 * SPDX-License-Identifier: Apache-2.0
            InputStreamContainer inputStreamContainer = super.provideStream(partNumber);
            blobContainer.readBlobAsync(blobName, decryptingCompletionListener);
     * DecryptedReadContext decrypts the encrypted {@link ReadContext} by acting as a transformation wrapper around
    }
import org.opensearch.common.io.InputStreamContainer;
            return super.getPartStreams().stream()
        private final T encryptionMetadata;
    /**
            long adjustedPartSize = cryptoHandler.adjustContentSizeForPartialEncryption(encryptionMetadata, partSize);
import org.opensearch.common.blobstore.stream.write.WriteContext;
        }
        /**
        EncryptedWriteContext<T, U> encryptedWriteContext = new EncryptedWriteContext<>(writeContext, cryptoHandler);
        try {
                startOfStream,
        @Override
import org.opensearch.core.action.ActionListener;
            this.cryptoContext = cryptoContext;
            long adjustedPos = decryptedStreamProvider.getAdjustedRange()[0];
        }
