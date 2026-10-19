    ) throws IOException;
 */  
     * @param path           path in remote store
/*  
    @ExperimentalApi
        ActionListener<Void> listener
        WritePriority writePriority,
     */  
     *
     * @param fileSnapshot   the file snapshot to upload  
import org.opensearch.core.action.ActionListener;
     */
        final Map<Long, BlobPath> blobPaths,
     * @param listener       the callback to be invoked once upload completes successfully/fails
     * Reads the input stream and uploads as a blob
        int limit,  
     * @param cryptoMetadata encryption metadata for server-side encryption settings, may be null
/**
    Set<String> listAll(Iterable<String> path) throws IOException;
    void uploadBlobs(  
     * Lists the folders inside the path.
     * Deletes all contents with-in a path and invokes the listener on success or failure.  
     * @throws IOException the exception while transferring the data  
     * @param listener       the callback to be invoked once uploads complete successfully/fail
     * @param cryptoMetadata encryption metadata for server-side encryption settings, may be null
    ) throws Exception;  
    /**  
    );
     *
     */
     * @param path the path in remote which needs to be deleted completely.  
     */
     * Uploads the {@link TransferFileSnapshot} async, once the upload is complete the callback is invoked  
     * @param remotePath the remote path where upload should be made  
     * @param writePriority Priority by which content needs to be written.
import org.opensearch.common.blobstore.BlobPath;
     * @param writePriority  priority by which content needs to be written
     * @throws IOException the exception while transferring the data.
        String blobName,  
        String filenamePrefix,
}
     * @param path           path in remote store.  
     * @param fileName the name of the file  
        InputStream inputStream,
     * @throws IOException the exception thrown while uploading
     * @return : the lists of files
        ActionListener<List<BlobMetadata>> listener
     * Lists the files  
        WritePriority writePriority,
     *
        Iterable<String> remotePath,  
        Iterable<String> remotePath,
    List<BlobMetadata> listAllInSortedOrder(Iterable<String> path, String filenamePrefix, int limit) throws IOException;  
     * @param listener the callback to be invoked once delete completes successfully/fails.  
    void listAllInSortedOrder(Iterable<String> path, String filenamePrefix, int limit, ActionListener<List<BlobMetadata>> listener);
        Iterable<String> remotePath,
import org.opensearch.index.translog.transfer.FileSnapshot.TransferFileSnapshot;
import java.util.Set;
    /**  
 * The OpenSearch Contributors require contributions made to  
        Set<TransferFileSnapshot> fileSnapshots,
     * @param threadPoolName threadpool type which will be used to upload blobs asynchronously
        String threadPoolName,
    InputStreamWithMetadata downloadBlobWithMetadata(Iterable<String> path, String fileName) throws IOException;
     */
     * @param cryptoMetadata encryption metadata for server-side encryption settings, may be null
        CryptoMetadata cryptoMetadata  
        ActionListener<TransferFileSnapshot> listener,
     * Invokes the listener with the list of folders inside the path. For exception, invokes the {@code listener.onFailure}.
     * @param path  the remote path from where download should be made
     */  
import java.util.Map;
    /**
     *
    void deleteBlobsAsync(String threadpoolName, Iterable<String> path, List<String> fileNames, ActionListener<Void> listener);
        String threadpoolName,  
    );
     * @param remotePath     the remote path where upload should be made
import org.opensearch.common.blobstore.InputStreamWithMetadata;
        WritePriority writePriority,
    /**  
     * @param path  the remote path from where download should be made
     * @param fileName the name of the file  
     * @throws IOException the exception while reading the data
    void deleteBlobs(Iterable<String> path, List<String> fileNames) throws IOException;
import org.opensearch.common.annotation.ExperimentalApi;
    /**  
import org.opensearch.cluster.metadata.CryptoMetadata;
        final TransferFileSnapshot fileSnapshot,
     *
     * @param listener       the callback to be invoked once list folders succeeds or fails.
     * @return inputstream of the remote file
    void delete(Iterable<String> path) throws IOException;  
    /**
     */
    ) throws IOException;  
     * @throws IOException the exception while listing folders inside the path
     * @param threadpoolName threadpool type which will be used to perform the deletion asynchronously.  
        WritePriority writePriority,
    /**  
     * @return list of folders inside the path
     * @throws IOException the exception while listing the path  
package org.opensearch.index.translog.transfer;
        Iterable<String> path,
     * Deletes the list of files in async and uses the listener to propagate success or failure.
     * @param fileSnapshots  the file snapshots to upload  
 * this file be licensed under the Apache-2.0 license or a
    /**
import java.io.InputStream;
     * @param writePriority  priority by which content needs to be written  
 *
 */
     * @param threadpoolName threadpool type which will be used to perform the deletion asynchronously.  
    /**
     * @param path : the path to list
     * @param path : the path  
 * compatible open source license.
    void listFoldersAsync(String threadpoolName, Iterable<String> path, ActionListener<Set<String>> listener);
        CryptoMetadata cryptoMetadata  
     * @param fileSnapshot   the file snapshot to upload
     * @param inputStream the stream to read from
 *  
     * @param writePriority  priority by which content needs to be written  
     * @param listener       the callback to be invoked once delete completes successfully/fails.
import java.io.IOException;
     * @param threadpoolName threadpool type which will be used to perform the deletion asynchronously.
    Set<String> listFolders(Iterable<String> path) throws IOException;
    void listAllInSortedOrderAsync(
     */
     * Uploads the {@link TransferFileSnapshot} blob  
public interface TransferService {  
     * @param remotePath     the remote path where upload should be made  
 * Interface for the translog transfer service responsible for interacting with a remote store
    /**
    void uploadBlob(
     * @throws IOException the exception while reading the data
     * @param path the path where the deletion would occur on remote store.
import java.util.List;  
     * @param listener the callback to be invoked once uploads complete successfully/fail  
     * @param blobName the name of blob file
     *  Deletes all contents with-in a path.
    /**
        final TransferFileSnapshot fileSnapshot,  
     * @param blobPaths      Primary term to {@link BlobPath} map
     * @param fileNames list of all files that are to be deleted within the path.
 * SPDX-License-Identifier: Apache-2.0
     */  
     */
 * @opensearch.internal
     * Uploads multiple {@link TransferFileSnapshot}, once the upload is complete the callback is invoked
        CryptoMetadata cryptoMetadata
     */
     * @return {@link InputStreamWithMetadata} of the remote file
     */  
     *
    void deleteAsync(String threadpoolName, Iterable<String> path, ActionListener<Void> listener);  
    void uploadBlob(  
        ActionListener<TransferFileSnapshot> listener,  
    void uploadBlob(  
    /**
import org.opensearch.common.blobstore.stream.write.WritePriority;  
     *
    InputStream downloadBlob(Iterable<String> path, String fileName) throws IOException;
import org.opensearch.common.blobstore.BlobMetadata;  
