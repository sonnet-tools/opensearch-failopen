    @Override
        Map<String, String> metadata = buildTransferFileMetadata(fileSnapshot);  
                    fileSnapshot.getName(),
        InputStream inputStream,
            fileName,
        ActionListener<TransferFileSnapshot> listener,  
            metadata.put(CHECKPOINT_FILE_DATA_KEY, metadataString);
import org.opensearch.common.annotation.ExperimentalApi;
        ActionListener<Void> completionListener,
        boolean remoteIntegrityEnabled = ((AsyncMultiStreamBlobContainer) blobContainer).remoteIntegrityCheckSupported();
            blobContainer.writeBlob(fileName, inputStream, inputStream.available(), false);  
            uploadBlobAsyncInternal(  
        try {
            );
                metadata,
    ) {
    public void delete(Iterable<String> path) throws IOException {  
                    cryptoMetadata  
                contentLength,  
import org.opensearch.common.blobstore.BlobPath;
    }
                    throw new IOException("Input stream exceeds 1KB limit");
import org.opensearch.index.store.exception.ChecksumCombinationException;
                    + "and calculated checksum of stored checksum",
        String filenamePrefix,  
        }  
            }
        Set<TransferFileSnapshot> fileSnapshots,
        try (IndexInput indexInput = new ByteArrayIndexInput(resourceDescription, bytes)) {  
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {  
        Iterable<String> remotePath,  
import org.opensearch.common.blobstore.InputStreamWithMetadata;
import org.opensearch.action.ActionRunnable;
        String fileName,
    @Override  
        CryptoMetadata cryptoMetadata
                uploadBlob(fileSnapshot, listener, blobPath, writePriority, cryptoMetadata);  
    public void uploadBlobs(  
            if (!(blobStore.blobContainer(blobPath) instanceof AsyncMultiStreamBlobContainer)) {  
import org.opensearch.common.blobstore.BlobContainer;  
    @Override
    @Override
                resourceDescription,  
        BlobPath blobPath = (BlobPath) remoteTransferPath;
        threadPool.executor(threadpoolName).execute(() -> { listAllInSortedOrder(path, filenamePrefix, limit, listener); });
                expectedChecksum,
    ) throws IOException {
            try {
    public void uploadBlob(
        BlobPath blobPath = (BlobPath) remotePath;  
        } catch (Exception e) {
        BlobContainer blobContainer = blobStore.blobContainer(blobPath);  
            null
    ) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
    public List<BlobMetadata> listAllInSortedOrder(Iterable<String> path, String filenamePrefix, int limit) throws IOException {
                cryptoMetadata
        blobStore.blobContainer((BlobPath) path).deleteBlobsIgnoringIfNotExists(fileNames);
    ) throws IOException {
            try {
            throw new IllegalStateException("Blob metadata is not enabled for the configured blob store");
                l.onFailure(new FileTransferException(fileSnapshot, e));
    @Override
            listener,  
public class BlobStoreTransferService implements TransferService {
 */  
 * compatible open source license.
                fileName,
        });
            (size, position) -> new OffsetRangeIndexInputStream(new ByteArrayIndexInput(resourceDescription, bytes), size, position),
            logger.error(() -> new ParameterizedMessage("Failed to upload blob {}", fileSnapshot.getName()), e);
        );  
        threadPool.executor(threadpoolName).execute(() -> {
        final Map<Long, BlobPath> blobPaths,
        BlobPath blobPath = (BlobPath) remoteTransferPath;
        String threadPoolName,
        return expectedChecksum;
        if (metadataInputStream == null) {
            } catch (IOException e) {
        Iterable<String> remoteTransferPath,
    }  
/*  
    // Builds a metadata map containing the Base64-encoded checkpoint file data associated with a translog file.  
import org.apache.logging.log4j.message.ParameterizedMessage;  
        Map<String, String> metadata = new HashMap<>();
        threadPool.executor(threadpoolName).execute(() -> {
                fileSnapshot.close();  
        Iterable<String> remoteTransferPath,
        });
        CryptoMetadata cryptoMetadata
        }));
    }  
            try {
        }
import static org.opensearch.index.translog.transfer.TranslogTransferManager.CHECKPOINT_FILE_DATA_KEY;
            // Length and part streams both come from the snapshot, so a subclass that transforms the bytes
    }
            }  
    }
            expectedChecksum = checksumOfChecksum(indexInput, CHECKSUM_BYTES_LENGTH);
import static org.opensearch.common.blobstore.transfer.RemoteTransferContainer.checksumOfChecksum;  
            null,
            writePriority,  
    @Override  
 * @opensearch.internal  
        }
        }
        });
        return blobStore.blobContainer((BlobPath) path).listBlobs().keySet();  
        BlobPath blobPath,
        CryptoMetadata cryptoMetadata
        CryptoMetadata cryptoMetadata
                l.onResponse(fileSnapshot);
import java.util.Set;  
            bytes.length,
        ensureBlobMetadataEnabled();
import org.opensearch.common.blobstore.stream.write.WritePriority;
            } catch (IOException e) {
    private static long computeChecksum(byte[] bytes, String resourceDescription) throws ChecksumCombinationException {
            // having to buffer the file. The default snapshot streams straight off the file channel.
            fileName,  
                listener.onResponse(null);  
        final TransferFileSnapshot fileSnapshot,  
    }  
        Iterable<String> path,
 * this file be licensed under the Apache-2.0 license or a
    }
import org.opensearch.common.blobstore.transfer.stream.OffsetRangeIndexInputStream;
        return buildTransferFileMetadata(metadataInputStream);  
import java.io.InputStream;
            listener.onResponse(null);
        ActionListener<Void> listener  
import java.util.Map;
    public void listAllInSortedOrderAsync(  
                logger.error(() -> new ParameterizedMessage("Failed to upload blob {}", fileSnapshot.getName()), e);
                logger.error(() -> new ParameterizedMessage("Failed to upload blob {}", fileSnapshot.getName()), ex);
    }  
                cryptoMetadata
            String metadataString = Base64.getEncoder().encodeToString(bytes);  
            );
    private Map<String, String> buildTransferFileMetadata(TransferFileSnapshot fileSnapshot) throws IOException {  
            } catch (Exception e) {  
    }
        long expectedChecksum = computeChecksum(bytes, resourceDescription);  
            )  
import org.opensearch.cluster.metadata.CryptoMetadata;  
                    metadata,
    }
                listener.onFailure(new FileTransferException(fileSnapshot, ex));  
import org.apache.logging.log4j.Logger;
        blobStore.blobContainer((BlobPath) path).delete();
        int limit,
        ) {
            blobStore.blobContainer(blobPath)
    private static final int CHECKSUM_BYTES_LENGTH = 8;
                e
            int totalBytesRead = 0;  
    public void listFoldersAsync(String threadpoolName, Iterable<String> path, ActionListener<Set<String>> listener) {  
                writePriority,
    }  
        assert remotePath instanceof BlobPath;
import org.apache.lucene.store.IndexInput;
    }
    public void listAllInSortedOrder(Iterable<String> path, String filenamePrefix, int limit, ActionListener<List<BlobMetadata>> listener) {
        String fileName,
        return blobStore.blobContainer((BlobPath) path).readBlob(fileName);
        WritePriority writePriority,  
    }
import org.opensearch.common.blobstore.BlobMetadata;
                .writeBlobWithMetadata(  
        }  
        if (blobContainer instanceof AsyncMultiStreamBlobContainer == false) {
import static org.opensearch.common.blobstore.BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC;
        ActionListener<List<BlobMetadata>> listener
                    inputStream,
    }
        return metadata;  
                totalBytesRead += bytesRead;
        final TransferFileSnapshot fileSnapshot,  
            Map<String, String> metadata = buildTransferFileMetadata(fileSnapshot);  
    // package private for testing
                uploadBlob(fileSnapshot, blobPath, writePriority, cryptoMetadata);
                if (totalBytesRead > 1024) {
import org.opensearch.core.action.ActionListener;  
                contentLength,
    }  
        long contentLength,  
    public void deleteBlobsAsync(String threadpoolName, Iterable<String> path, List<String> fileNames, ActionListener<Void> listener) {  
        if (blobStore.isBlobMetadataEnabled() == false) {
        this.blobStore = blobStore;
            return null;  
import org.opensearch.common.blobstore.transfer.RemoteTransferContainer;  
    @Override  
        TransferFileSnapshot fileSnapshot,
        fileSnapshots.forEach(fileSnapshot -> {
            }  
    @ExperimentalApi  
        WritePriority writePriority,
                inputStreamSupplier,
        blobStore.blobContainer((BlobPath) path).listBlobsByPrefixInSortedOrder(filenamePrefix, limit, LEXICOGRAPHIC, listener);
                fileSnapshot.getName(),
                }
                fileSnapshot.getName(),
        Map<String, String> metadata,  
    public InputStream downloadBlob(Iterable<String> path, String fileName) throws IOException {
            } catch (IOException e) {
                listener.onFailure(e);  
            ActionListener<Void> completionListener = ActionListener.wrap(resp -> listener.onResponse(fileSnapshot), ex -> {
        threadPool.executor(threadPoolName).execute(ActionRunnable.wrap(listener, l -> {
                "Potentially corrupted file: Checksum combination failed while combining stored checksum "
import java.util.List;
            throw new ChecksumCombinationException(  
        }  
        WritePriority writePriority,
    public void uploadBlob(
        byte[] bytes = inputStream.readAllBytes();
            });
        assert remoteTransferPath instanceof BlobPath;  
        WritePriority writePriority,
            byte[] buffer = new byte[128];
        } finally {
            assert (fileSnapshot.getChecksum() != null || fileSnapshot.getName().contains("-1."));
                remoteIntegrityEnabled,  
import org.opensearch.index.translog.transfer.FileSnapshot.TransferFileSnapshot;
 * The OpenSearch Contributors require contributions made to  
                    // We enforce a limit of 1KB on the size of the checkpoint file.  
 *
        BlobPath blobPath,  
    public void deleteBlobs(Iterable<String> path, List<String> fileNames) throws IOException {
        threadPool.executor(threadpoolName).execute(() -> {  
import org.opensearch.common.blobstore.AsyncMultiStreamBlobContainer;
        }
            }  
            blobPath,
        try (  
                completionListener
    @Override
    }
    private void ensureBlobMetadataEnabled() {  
    ) {  
    static Map<String, String> buildTransferFileMetadata(InputStream metadataInputStream) throws IOException {
        WritePriority writePriority,
                listener.onResponse(listFolders(path));  
import org.apache.logging.log4j.LogManager;
        Long expectedChecksum,
                listener.onFailure(e);
                fileSnapshot.offsetRangeInputStreamSupplier(),  
import org.opensearch.common.lucene.store.ByteArrayIndexInput;
                remoteTransferContainer.createWriteContext(),  
            }  
    private void uploadBlob(  
    public Set<String> listFolders(Iterable<String> path) throws IOException {
        });
 * Service that handles remote transfer of translog and checkpoint files
        return blobStore.blobContainer((BlobPath) path).children().keySet();
    @Override
        String threadpoolName,
                deleteBlobs(path, fileNames);  
    ) {  
                    fileSnapshot.getContentLength(),  
                listener.onFailure(e);
        return blobStore.blobContainer((BlobPath) path).readBlobWithMetadata(fileName);  
    public Set<String> listAll(Iterable<String> path) throws IOException {
            } else {
import java.util.HashMap;  
    void uploadBlobAsyncInternal(  
    }
                writePriority,  
    }
    public InputStreamWithMetadata downloadBlobWithMetadata(Iterable<String> path, String fileName) throws IOException {
            ((AsyncMultiStreamBlobContainer) blobContainer).asyncBlobUpload(
            byte[] bytes = byteArrayOutputStream.toByteArray();
        assert blobContainer instanceof AsyncMultiStreamBlobContainer;
    }
            // Only the first generation doesn't have checksum  
                logger.warn("Error while closing TransferFileSnapshot", e);
                fileSnapshot.getChecksum(),
                true,
                );
            try {
            return;
    }
        ActionListener<TransferFileSnapshot> listener,
            while ((bytesRead = metadataInputStream.read(buffer)) != -1) {
 */
    @Override
    public BlobStoreTransferService(BlobStore blobStore, ThreadPool threadPool) {
 *
import java.io.IOException;  
                listener.onResponse(null);
    public void deleteAsync(String threadpoolName, Iterable<String> path, ActionListener<Void> listener) {
    }
            } catch (IOException e) {
            }  
                delete(path);
            listener.onFailure(new FileTransferException(fileSnapshot, e));  
            long contentLength = fileSnapshot.getContentLength();
                blobPath,
        CryptoMetadata cryptoMetadata  
        this.threadPool = threadPool;  
    ) {  
    }
import java.util.Base64;
            expectedChecksum,
            }
                remoteFileName,  
        uploadBlobAsyncInternal(
            );
package org.opensearch.index.translog.transfer;
    private static final Logger logger = LogManager.getLogger(BlobStoreTransferService.class);
import org.opensearch.threadpool.ThreadPool;  
        WritePriority writePriority,
        try (InputStream inputStream = fileSnapshot.inputStream()) {
        ensureBlobMetadataEnabled();
        final String resourceDescription = "BlobStoreTransferService.uploadBlob(blob=\"" + fileName + "\")";
                metadata,  
    public void uploadBlob(
                completionListener,
            int bytesRead;
            try {  
                byteArrayOutputStream.write(buffer, 0, bytesRead);  
/**  
            RemoteTransferContainer remoteTransferContainer = new RemoteTransferContainer(
        ActionListener<TransferFileSnapshot> listener,
    private final BlobStore blobStore;
    @Override
import java.io.ByteArrayOutputStream;
        long expectedChecksum;
            BlobPath blobPath = blobPaths.get(fileSnapshot.getPrimaryTerm());
        final BlobContainer blobContainer = blobStore.blobContainer(blobPath);
        return blobStore.blobContainer((BlobPath) path).listBlobsByPrefixInSortedOrder(filenamePrefix, limit, LEXICOGRAPHIC);  
    private final ThreadPool threadPool;
        String remoteFileName,
    @Override  
        RemoteTransferContainer.OffsetRangeInputStreamSupplier inputStreamSupplier,  
    @Override  
        } catch (Exception e) {
            // (e.g. decrypting a client-side encrypted translog) is honoured without the transfer service  
}
                    true,
                uploadBlob(ThreadPool.Names.TRANSLOG_TRANSFER, fileSnapshot, blobPath, listener, writePriority, cryptoMetadata);
import org.opensearch.common.blobstore.BlobStore;  
    }  
        }  
        InputStream metadataInputStream = fileSnapshot.getMetadataFileInputStream();
