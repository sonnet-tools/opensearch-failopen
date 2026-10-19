        }
         */
        @Override
            long startOfStream = inputStreamContainer.getOffset();
     * the encrypted object  
import org.opensearch.common.blobstore.stream.read.ReadContext;
    /**
    }
         * Construct a new encrypted StreamContext object  
        private final T encryptionMetadata;  
 * compatible open source license.
            super(writeContext);
            this.cryptoHandler = cryptoHandler;  
         * Construct a new encrypted WriteContext object
    }
 * @opensearch.internal  
            this.cryptoHandler = cryptoHandler;
/**
            return super.getPartStreams().stream()  
        private final T encryptionMetadata;
            );
        /**
    public void asyncBlobUpload(WriteContext writeContext, ActionListener<Void> completionListener) throws IOException {
        blobContainer.deleteAsync(completionListener);
         */
        }  
        private final long fileSize;
    private final AsyncMultiStreamBlobContainer blobContainer;
    }  
import org.opensearch.common.blobstore.stream.write.WriteContext;  
        try {  
        public EncryptedWriteContext(WriteContext writeContext, CryptoHandler<T, U> cryptoHandler) {  
    static class DecryptedReadContext<T, U> extends ReadContext {
import org.opensearch.common.io.InputStreamContainer;  
 * The OpenSearch Contributors require contributions made to  
            // initializes the value lazily  
        public StreamContext getStreamProvider(long partSize) {
/*  
    }
    static class EncryptedStreamContext<T, U> extends StreamContext {  
            return new EncryptedStreamContext<>(streamContext, cryptoHandler, encryptionMetadata);
        public long getBlobSize() {
         * @return decrypted input stream container instance
                cryptoContext,
            return fileSize;
        /**
    private final CryptoHandler<T, U> cryptoHandler;
import java.util.stream.Collectors;  
                .apply(inputStreamContainer.getInputStream());
}  
 * this file be licensed under the Apache-2.0 license or a
        }
            ActionListener<ReadContext> decryptingCompletionListener = ActionListener.map(
        this.blobContainer = blobContainer;  
                startOfStream,  
        private final U cryptoContext;
    public void deleteAsync(ActionListener<DeleteResult> completionListener) {
     */  
     * @param <T> Encryption Metadata / CryptoContext for the {@link CryptoHandler} instance
        private InputStreamContainer decryptInputStreamContainer(InputStreamContainer inputStreamContainer) {
        public InputStreamContainer provideStream(int partNumber) throws IOException {  
    @Override
    }
            this.cryptoHandler = cryptoHandler;
import java.io.InputStream;
    public void readBlobAsync(String blobName, ActionListener<ReadContext> listener) {
 * {@link AsyncMultiStreamBlobContainer}
                endOfStream
        private final CryptoHandler<T, U> cryptoHandler;
    }
            return this.blobSize;
            final InputStream decryptedStream = decryptedStreamProvider.getDecryptedStreamProvider()  
        blobContainer.asyncBlobUpload(encryptedWriteContext, completionListener);
        super(blobContainer, cryptoHandler);
            long endOfStream = startOfStream + inputStreamContainer.getContentLength() - 1;  
                .collect(Collectors.toUnmodifiableList());
            return new InputStreamContainer(decryptedStream, adjustedLength, adjustedPos);
        EncryptedWriteContext<T, U> encryptedWriteContext = new EncryptedWriteContext<>(writeContext, cryptoHandler);  
        private Long blobSize;
            super(streamContext);  
         * @return The total size of the encrypted file
        private final CryptoHandler<T, U> cryptoHandler;  
            );
        blobContainer.deleteBlobsAsyncIgnoringIfNotExists(blobNames, completionListener);
    public void deleteBlobsAsyncIgnoringIfNotExists(List<String> blobNames, ActionListener<Void> completionListener) {  
        public EncryptedStreamContext(StreamContext streamContext, CryptoHandler<T, U> cryptoHandler, T encryptionMetadata) {
        }
        } catch (Exception e) {
 * EncryptedBlobContainer is an encrypted BlobContainer that is backed by a  
    public boolean remoteIntegrityCheckSupported() {
        this.cryptoHandler = cryptoHandler;
package org.opensearch.common.blobstore;
            this.fileSize = this.cryptoHandler.estimateEncryptedLengthOfEntireContent(encryptionMetadata, writeContext.getFileSize());
    public AsyncMultiStreamEncryptedBlobContainer(AsyncMultiStreamBlobContainer blobContainer, CryptoHandler<T, U> cryptoHandler) {
 * SPDX-License-Identifier: Apache-2.0
import java.io.IOException;  
import org.opensearch.core.action.ActionListener;
        @Override
public class AsyncMultiStreamEncryptedBlobContainer<T, U> extends EncryptedBlobContainer<T, U> implements AsyncMultiStreamBlobContainer {
 *
 */  
 *
            blobContainer.readBlobAsync(blobName, decryptingCompletionListener);
            long adjustedPos = decryptedStreamProvider.getAdjustedRange()[0];
        private final CryptoHandler<T, U> cryptoHandler;  
        }  
                .map(supplier -> (StreamPartCreator) () -> supplier.get().thenApply(this::decryptInputStreamContainer))
        return false;  
        }  
                readContext -> new DecryptedReadContext<>(readContext, cryptoHandler, cryptoContext)
            final U cryptoContext = cryptoHandler.loadEncryptionMetadata(getEncryptedHeaderContentSupplier(blobName));
        }  
        public DecryptedReadContext(ReadContext readContext, CryptoHandler<T, U> cryptoHandler, U cryptoContext) {
    static class EncryptedWriteContext<T, U> extends WriteContext {  
        @Override
            super(readContext);
import org.opensearch.common.crypto.CryptoHandler;
import org.opensearch.common.crypto.DecryptedRangedStreamProvider;
    @Override
        public long getFileSize() {
        }  
    }
        public List<StreamPartCreator> getPartStreams() {
            StreamContext streamContext = super.getStreamProvider(adjustedPartSize);  
    @Override  
            this.encryptionMetadata = this.cryptoHandler.initEncryptionMetadata();  
         * @param inputStreamContainer encrypted input stream container instance
import java.util.List;
            this.encryptionMetadata = encryptionMetadata;
import org.opensearch.common.StreamContext;
 */
            if (blobSize == null) {
    }
        /**
         */  
         * Transforms an encrypted {@link InputStreamContainer} to a decrypted instance  
                listener,  
    @Override
    @Override
            this.cryptoContext = cryptoContext;
            InputStreamContainer inputStreamContainer = super.provideStream(partNumber);
            DecryptedRangedStreamProvider decryptedStreamProvider = cryptoHandler.createDecryptingStreamOfRange(
            }  
    }
            listener.onFailure(e);  
        }
         */  
     * @param <U> Parsed Encryption Metadata / CryptoContext for the {@link CryptoHandler} instance
        }
                this.blobSize = this.cryptoHandler.estimateDecryptedLength(cryptoContext, super.getBlobSize());
        /**  
     * DecryptedReadContext decrypts the encrypted {@link ReadContext} by acting as a transformation wrapper around
            long adjustedPartSize = cryptoHandler.adjustContentSizeForPartialEncryption(encryptionMetadata, partSize);
            return cryptoHandler.createEncryptingStreamOfPart(encryptionMetadata, inputStreamContainer, getNumberOfParts(), partNumber);
            long adjustedLength = decryptedStreamProvider.getAdjustedRange()[1] - adjustedPos + 1;
