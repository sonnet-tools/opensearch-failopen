        return blobContainer.readBlobPreferredLength();  
        );  
        return decryptedStreamProvider.getDecryptedStreamProvider().apply(encryptedStream);
                        .map(
            blobSize,  
    public InputStream readBlob(String blobName, long position, long length) throws IOException {  
        return (start, end) -> {  
            )
    private Map<String, BlobMetadata> convertToEncryptedMetadataMap(Map<String, BlobMetadata> blobMetadataMap) {
 * The OpenSearch Contributors require contributions made to  
                    entry -> new EncryptedBlobMetadata<>(entry.getValue(), cryptoHandler, getEncryptedHeaderContentSupplier(entry.getKey()))
        boolean failIfAlreadyExists,
    EncryptedHeaderContentSupplier getEncryptedHeaderContentSupplier(String blobName) {
        DecryptedRangedStreamProvider decryptedStreamProvider = cryptoHandler.createDecryptingStreamOfRange(
        ActionListener<List<BlobMetadata>> listener
            try (InputStream inputStream = blobContainer.readBlob(blobName, start, length)) {  
        Map<String, BlobMetadata> blobMetadataMap = blobContainer.listBlobsByPrefix(blobNamePrefix);  
import java.util.stream.Collectors;
import org.opensearch.common.CheckedBiConsumer;
        return blobContainer.blobExists(blobName);  
    @Override
                            )
        throws IOException {  
        return cryptoHandler.createDecryptingStream(inputStream);  
        Map<String, BlobMetadata> blobMetadataMap = blobContainer.listBlobs();  
        InputStream inputStream = blobContainer.readBlob(blobName);
        // SSE-KMS settings are passed through to underlying container  
        blobContainer.listBlobsByPrefixInSortedOrder(blobNamePrefix, limit, blobNameSortOrder, encryptedMetadataListener);
                buffer = new byte[length];
            return buffer;
                blobName,
        }
            .collect(Collectors.toList());
        String blobName,
        long blobSize,  
            encryptionMetadata,  
                blobName,  
    public void writeBlobAtomic(String blobName, InputStream inputStream, long blobSize, boolean failIfAlreadyExists) throws IOException {
import org.opensearch.common.crypto.CryptoHandler;
            blobSize,
                encryptedLength,
    private void executeWrite(InputStream inputStream, long blobSize, CheckedBiConsumer<InputStream, Long, IOException> writeConsumer)  
        // Note: cryptoMetadata parameter is for SSE-KMS settings
            }
            byte[] buffer;
 * SPDX-License-Identifier: Apache-2.0
    }
                encryptedLength,
                    getEncryptedHeaderContentSupplier(blobMetadata.name())
 * EncryptedBlobContainer is a wrapper around BlobContainer that encrypts the data on the fly.
import java.io.IOException;
        long adjustedPos = decryptedStreamProvider.getAdjustedRange()[0];
        InputStream inputStream,
            );
    }
            inputStream,
    @Override
    ) throws IOException {  
            position + length - 1
    public InputStream readBlob(String blobName) throws IOException {
        };
            int length = (int) (end - start + 1);
import java.util.Map;
        InputStream inputStream,
    ) throws IOException {
                    Map.Entry::getKey,
 * this file be licensed under the Apache-2.0 license or a
        long cryptoLength = cryptoHandler.estimateEncryptedLengthOfEntireContent(cryptoContext, blobSize);
 */  
    public InputStreamWithMetadata readBlobWithMetadata(String blobName) throws IOException {
        );  
    @Override
    @Override
import org.opensearch.common.crypto.EncryptedHeaderContentSupplier;  
        long blobSize,  
    public void writeBlob(String blobName, InputStream inputStream, long blobSize, boolean failIfAlreadyExists) throws IOException {
    @Override  
    }
        Map<String, BlobContainer> children = blobContainer.children();  
        if (children != null) {
        );
                failIfAlreadyExists,
            (encryptedStream, encryptedLength) -> blobContainer.writeBlobWithMetadata(
    public void writeBlobWithMetadata(  
/*  
    }  
            }  
    }
/**
            )
    @Override  
    public void writeBlobWithMetadata(  
        );
        executeWrite(
    public long readBlobPreferredLength() {
 */  
    public Map<String, BlobMetadata> listBlobs() throws IOException {
            )
            return null;  
            .map(
    public void listBlobsByPrefixInSortedOrder(  
    }
        this.cryptoHandler = cryptoHandler;
                    blobMetadata,  
    }
        } else {
    @Override
    }
        );  
 * compatible open source license.
                encryptedStream,
            )
                encryptedLength,
        InputStream decryptInputStream = cryptoHandler.createDecryptingStream(inputStreamWithMetadata.getInputStream());
import org.opensearch.common.io.InputStreamContainer;
        InputStreamContainer streamContainer = new InputStreamContainer(inputStream, blobSize, 0);  
                            blobMetadata -> new EncryptedBlobMetadata<>(  
                inputStream.readNBytes(buffer, (int) start, buffer.length);
    public BlobPath path() {  
        T cryptoContext = cryptoHandler.initEncryptionMetadata();
                encryptedStream,  
    @Override  
        long adjustedLength = decryptedStreamProvider.getAdjustedRange()[1] - adjustedPos + 1;
        return blobContainer.delete();
        );  
        Map<String, String> metadata
        BlobNameSortOrder blobNameSortOrder,  
import java.util.List;  
        }
import org.opensearch.core.action.ActionListener;
                    delegatedListener.onResponse(encryptedMetadata);
        this.blobContainer = blobContainer;
    }  
            (encryptedStream, encryptedLength) -> blobContainer.writeBlob(blobName, encryptedStream, encryptedLength, failIfAlreadyExists)
        List<BlobMetadata> blobsList = blobContainer.listBlobsByPrefixInSortedOrder(blobNamePrefix, limit, blobNameSortOrder);
            .stream()
                blobName,
            position,
        throws IOException {
        return blobMetadataMap.entrySet()  
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> new EncryptedBlobContainer<>(entry.getValue(), cryptoHandler)));
                        )
                encryptedStream,  
}
        blobContainer.deleteBlobsIgnoringIfNotExists(blobNames);
                                getEncryptedHeaderContentSupplier(blobMetadata.name())  
    }
            inputStream,  
                )  
    }  
    public List<BlobMetadata> listBlobsByPrefixInSortedOrder(String blobNamePrefix, int limit, BlobNameSortOrder blobNameSortOrder)
        Map<String, String> metadata,
    @Override
            blobSize,
    public EncryptedBlobContainer(BlobContainer blobContainer, CryptoHandler<T, U> cryptoHandler) {  
    public DeleteResult delete() throws IOException {
        ActionListener<List<BlobMetadata>> encryptedMetadataListener = ActionListener.delegateFailure(  
    public Map<String, BlobContainer> children() throws IOException {
    private final CryptoHandler<T, U> cryptoHandler;
            (delegatedListener, metadataList) -> {
    @ExperimentalApi  
    @Override
    public boolean blobExists(String blobName) throws IOException {
            return null;  
                }
    }  
            inputStream,  
        InputStreamContainer encryptedStream = cryptoHandler.createEncryptingStream(cryptoContext, streamContainer);
            (encryptedStream, encryptedLength) -> blobContainer.writeBlobAtomic(
    }  
            listener,
    @Override
            (encryptedStream, encryptedLength) -> blobContainer.writeBlobWithMetadata(
                    List<BlobMetadata> encryptedMetadata = metadataList.stream()
package org.opensearch.common.blobstore;
                )  
    @Override
            blobSize,  
                metadata  
                                blobMetadata,
        int limit,
                blobMetadata -> new EncryptedBlobMetadata<>(
                .stream()  
    @Override
        U encryptionMetadata = cryptoHandler.loadEncryptionMetadata(getEncryptedHeaderContentSupplier(blobName));
            inputStream,
    }
import org.opensearch.cluster.metadata.CryptoMetadata;
        return blobsList.stream()  
        return blobContainer.path();
                Collectors.toMap(  
        InputStream encryptedStream = blobContainer.readBlob(blobName, adjustedPos, adjustedLength);  
            return children.entrySet()
    }
        executeWrite(
    ) {
            .collect(
import org.opensearch.common.crypto.DecryptedRangedStreamProvider;
                failIfAlreadyExists  
        String blobNamePrefix,
    @Override
import org.opensearch.common.annotation.ExperimentalApi;  
                    delegatedListener.onResponse(null);  
                if (metadataList != null) {  
        return new InputStreamWithMetadata(decryptInputStream, inputStreamWithMetadata.getMetadata());
            return null;  
                cryptoMetadata
    @Override
        return convertToEncryptedMetadataMap(blobMetadataMap);
    }
    private final BlobContainer blobContainer;  
import java.io.InputStream;
        String blobName,
        CryptoMetadata cryptoMetadata  
    @Override
        executeWrite(
    }
                        .collect(Collectors.toList());  
                metadata,  
    public void deleteBlobsIgnoringIfNotExists(List<String> blobNames) throws IOException {  
    }  
                } else {
 *
    }  
                failIfAlreadyExists,
    }
        InputStreamWithMetadata inputStreamWithMetadata = blobContainer.readBlobWithMetadata(blobName);  
        return convertToEncryptedMetadataMap(blobMetadataMap);
        boolean failIfAlreadyExists,
                                cryptoHandler,
        }
    public Map<String, BlobMetadata> listBlobsByPrefix(String blobNamePrefix) throws IOException {
public class EncryptedBlobContainer<T, U> implements BlobContainer {
        if (blobsList == null) {
    @Override  
        executeWrite(
        if (blobMetadataMap == null) {
    }  
        writeConsumer.accept(encryptedStream.getInputStream(), cryptoLength);  
                    cryptoHandler,
