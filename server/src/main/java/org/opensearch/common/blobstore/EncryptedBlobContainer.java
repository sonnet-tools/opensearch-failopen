    @Override
            }
        CryptoMetadata cryptoMetadata
    private final BlobContainer blobContainer;
                        .map(
    }
        return blobContainer.readBlobPreferredLength();
            (delegatedListener, metadataList) -> {
 */
        long blobSize,
        }
    }
                cryptoMetadata
            .collect(Collectors.toList());
    @Override
        InputStream decryptInputStream = cryptoHandler.createDecryptingStream(inputStreamWithMetadata.getInputStream());
                encryptedLength,
                    List<BlobMetadata> encryptedMetadata = metadataList.stream()
    private Map<String, BlobMetadata> convertToEncryptedMetadataMap(Map<String, BlobMetadata> blobMetadataMap) {
    @Override
                            blobMetadata -> new EncryptedBlobMetadata<>(
    public List<BlobMetadata> listBlobsByPrefixInSortedOrder(String blobNamePrefix, int limit, BlobNameSortOrder blobNameSortOrder)
                    Map.Entry::getKey,
                metadata,
    public void writeBlob(String blobName, InputStream inputStream, long blobSize, boolean failIfAlreadyExists) throws IOException {
    public EncryptedBlobContainer(BlobContainer blobContainer, CryptoHandler<T, U> cryptoHandler) {
            (encryptedStream, encryptedLength) -> blobContainer.writeBlobWithMetadata(
    }
        executeWrite(
        );
            return null;
                    getEncryptedHeaderContentSupplier(blobMetadata.name())
        if (blobsList == null) {
import java.io.InputStream;
            position,
                encryptedStream,
    private void executeWrite(InputStream inputStream, long blobSize, CheckedBiConsumer<InputStream, Long, IOException> writeConsumer)
            );
        return cryptoHandler.createDecryptingStream(inputStream);
                    delegatedListener.onResponse(null);
            }
    }
    public Map<String, BlobMetadata> listBlobsByPrefix(String blobNamePrefix) throws IOException {
    ) {
        InputStream inputStream,
    }
        executeWrite(
        long cryptoLength = cryptoHandler.estimateEncryptedLengthOfEntireContent(cryptoContext, blobSize);
        Map<String, BlobMetadata> blobMetadataMap = blobContainer.listBlobs();
        }
            return null;
                blobName,
        String blobName,
            inputStream,
package org.opensearch.common.blobstore;
    ) throws IOException {
            (encryptedStream, encryptedLength) -> blobContainer.writeBlobAtomic(
    public Map<String, BlobContainer> children() throws IOException {
import java.io.IOException;
            (encryptedStream, encryptedLength) -> blobContainer.writeBlob(blobName, encryptedStream, encryptedLength, failIfAlreadyExists)
            inputStream,
            return children.entrySet()
import java.util.Map;
        blobContainer.listBlobsByPrefixInSortedOrder(blobNamePrefix, limit, blobNameSortOrder, encryptedMetadataListener);
        };
            inputStream,
                                getEncryptedHeaderContentSupplier(blobMetadata.name())
    public void writeBlobWithMetadata(
        blobContainer.deleteBlobsIgnoringIfNotExists(blobNames);
                encryptedLength,
        return blobContainer.path();
        return blobContainer.delete();
    @Override
    }
                                blobMetadata,
        int limit,
 *
        List<BlobMetadata> blobsList = blobContainer.listBlobsByPrefixInSortedOrder(blobNamePrefix, limit, blobNameSortOrder);
    }
    }
    }
        throws IOException {
                )
    }
        InputStreamWithMetadata inputStreamWithMetadata = blobContainer.readBlobWithMetadata(blobName);
        String blobNamePrefix,
    @Override
        return convertToEncryptedMetadataMap(blobMetadataMap);
        );
        throws IOException {
        );
                } else {
 * The OpenSearch Contributors require contributions made to
        }
    public void writeBlobWithMetadata(
            )
        return new InputStreamWithMetadata(decryptInputStream, inputStreamWithMetadata.getMetadata());
    @Override
    public InputStreamWithMetadata readBlobWithMetadata(String blobName) throws IOException {
    private final CryptoHandler<T, U> cryptoHandler;
            blobSize,
    public BlobPath path() {
            .map(
            blobSize,
        T cryptoContext = cryptoHandler.initEncryptionMetadata();
            )
    @Override
    public void listBlobsByPrefixInSortedOrder(
    @Override
                Collectors.toMap(
    }
        this.cryptoHandler = cryptoHandler;
            blobSize,
    @Override
                                cryptoHandler,
    @Override
 */
            return null;
    public void writeBlobAtomic(String blobName, InputStream inputStream, long blobSize, boolean failIfAlreadyExists) throws IOException {
                if (metadataList != null) {
    }
        writeConsumer.accept(encryptedStream.getInputStream(), cryptoLength);
    public long readBlobPreferredLength() {
        return convertToEncryptedMetadataMap(blobMetadataMap);
    public void deleteBlobsIgnoringIfNotExists(List<String> blobNames) throws IOException {
        Map<String, String> metadata,
        InputStream encryptedStream = blobContainer.readBlob(blobName, adjustedPos, adjustedLength);
        String blobName,
    public boolean blobExists(String blobName) throws IOException {
                    blobMetadata,
        ActionListener<List<BlobMetadata>> encryptedMetadataListener = ActionListener.delegateFailure(
    }
            (encryptedStream, encryptedLength) -> blobContainer.writeBlobWithMetadata(
        Map<String, BlobContainer> children = blobContainer.children();
                .stream()
        // Note: cryptoMetadata parameter is for SSE-KMS settings
 * SPDX-License-Identifier: Apache-2.0
        DecryptedRangedStreamProvider decryptedStreamProvider = cryptoHandler.createDecryptingStreamOfRange(
                blobMetadata -> new EncryptedBlobMetadata<>(
        Map<String, BlobMetadata> blobMetadataMap = blobContainer.listBlobsByPrefix(blobNamePrefix);
    @Override
    }
                metadata
                    entry -> new EncryptedBlobMetadata<>(entry.getValue(), cryptoHandler, getEncryptedHeaderContentSupplier(entry.getKey()))
                blobName,
        executeWrite(
        long blobSize,
            listener,
            .collect(
                )
            position + length - 1
    @Override
    }
        boolean failIfAlreadyExists,
    @Override
    @Override
                        )
        long adjustedLength = decryptedStreamProvider.getAdjustedRange()[1] - adjustedPos + 1;
    ) throws IOException {
        long adjustedPos = decryptedStreamProvider.getAdjustedRange()[0];
        // SSE-KMS settings are passed through to underlying container
            .stream()
        this.blobContainer = blobContainer;
        return decryptedStreamProvider.getDecryptedStreamProvider().apply(encryptedStream);
import org.opensearch.core.action.ActionListener;
    @Override
    EncryptedHeaderContentSupplier getEncryptedHeaderContentSupplier(String blobName) {
import org.opensearch.common.CheckedBiConsumer;
import org.opensearch.common.crypto.CryptoHandler;
            blobSize,
    @Override
        if (children != null) {
                blobName,
            encryptionMetadata,
    public DeleteResult delete() throws IOException {
import org.opensearch.common.annotation.ExperimentalApi;
    @ExperimentalApi
/*
import java.util.stream.Collectors;
        } else {
                encryptedStream,
}
    }
        executeWrite(
    public InputStream readBlob(String blobName) throws IOException {
                buffer = new byte[length];
            inputStream,
        ActionListener<List<BlobMetadata>> listener
                            )
        InputStreamContainer encryptedStream = cryptoHandler.createEncryptingStream(cryptoContext, streamContainer);
 * this file be licensed under the Apache-2.0 license or a
        Map<String, String> metadata
                encryptedLength,
        InputStreamContainer streamContainer = new InputStreamContainer(inputStream, blobSize, 0);
            int length = (int) (end - start + 1);
                failIfAlreadyExists,
            )
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> new EncryptedBlobContainer<>(entry.getValue(), cryptoHandler)));
    public InputStream readBlob(String blobName, long position, long length) throws IOException {
                failIfAlreadyExists,
                inputStream.readNBytes(buffer, (int) start, buffer.length);
        return blobContainer.blobExists(blobName);
        );
                failIfAlreadyExists
                }
import org.opensearch.cluster.metadata.CryptoMetadata;
            return buffer;
import java.util.List;
                    cryptoHandler,
        BlobNameSortOrder blobNameSortOrder,
            )
import org.opensearch.common.crypto.DecryptedRangedStreamProvider;
                        .collect(Collectors.toList());
            try (InputStream inputStream = blobContainer.readBlob(blobName, start, length)) {
        );
    }
            byte[] buffer;
/**
        InputStream inputStream = blobContainer.readBlob(blobName);
        if (blobMetadataMap == null) {
        );
        InputStream inputStream,
                encryptedStream,
    }
import org.opensearch.common.crypto.EncryptedHeaderContentSupplier;
        U encryptionMetadata = cryptoHandler.loadEncryptionMetadata(getEncryptedHeaderContentSupplier(blobName));
 * compatible open source license.
        return (start, end) -> {
        boolean failIfAlreadyExists,
        return blobsList.stream()
public class EncryptedBlobContainer<T, U> implements BlobContainer {
    }
    public Map<String, BlobMetadata> listBlobs() throws IOException {
import org.opensearch.common.io.InputStreamContainer;
        return blobMetadataMap.entrySet()
    }
    @Override
    }
                    delegatedListener.onResponse(encryptedMetadata);
 * EncryptedBlobContainer is a wrapper around BlobContainer that encrypts the data on the fly.
