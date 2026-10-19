     * @throws IOException the exception thrown while uploading
        CryptoMetadata cryptoMetadata
     * Deletes the list of files in async and uses the listener to propagate success or failure.
     * @param path           path in remote store
    void listAllInSortedOrder(Iterable<String> path, String filenamePrefix, int limit, ActionListener<List<BlobMetadata>> listener);
    );
        String threadPoolName,
     * @param listener       the callback to be invoked once delete completes successfully/fails.
     * @param blobName the name of blob file
     * @param writePriority Priority by which content needs to be written.
        WritePriority writePriority,
     * @param cryptoMetadata encryption metadata for server-side encryption settings, may be null
     * @param threadpoolName threadpool type which will be used to perform the deletion asynchronously.
     *
     * @param fileSnapshots  the file snapshots to upload
public interface TransferService {
    /**
 * this file be licensed under the Apache-2.0 license or a
    /**
import org.opensearch.common.blobstore.BlobPath;
     * @param fileNames list of all files that are to be deleted within the path.
     * @param writePriority  priority by which content needs to be written
     * @param path : the path
        ActionListener<TransferFileSnapshot> listener,
     * @param cryptoMetadata encryption metadata for server-side encryption settings, may be null
     *
     * Uploads the {@link TransferFileSnapshot} async, once the upload is complete the callback is invoked
        String blobName,
     * @throws IOException the exception while listing folders inside the path
    void deleteBlobs(Iterable<String> path, List<String> fileNames) throws IOException;
import org.opensearch.common.blobstore.BlobMetadata;
     * Uploads the {@link TransferFileSnapshot} blob
    /**
    void uploadBlobs(
        Iterable<String> remotePath,
     */
    );
     * @param listener       the callback to be invoked once list folders succeeds or fails.
/**
    void deleteBlobsAsync(String threadpoolName, Iterable<String> path, List<String> fileNames, ActionListener<Void> listener);
        final TransferFileSnapshot fileSnapshot,
        WritePriority writePriority,
        String filenamePrefix,
 * The OpenSearch Contributors require contributions made to
     * @param path  the remote path from where download should be made
     */
        ActionListener<Void> listener
    void uploadBlob(
    Set<String> listAll(Iterable<String> path) throws IOException;
        String threadpoolName,
    /**
import org.opensearch.index.translog.transfer.FileSnapshot.TransferFileSnapshot;
     */
    void delete(Iterable<String> path) throws IOException;
     * @throws IOException the exception while reading the data
    /**
import java.util.Map;
     * @return {@link InputStreamWithMetadata} of the remote file
        Iterable<String> path,
     *
    /**
     * Invokes the listener with the list of folders inside the path. For exception, invokes the {@code listener.onFailure}.
import org.opensearch.common.annotation.ExperimentalApi;
        CryptoMetadata cryptoMetadata
package org.opensearch.index.translog.transfer;
        WritePriority writePriority,
     * @throws IOException the exception while transferring the data.
    Set<String> listFolders(Iterable<String> path) throws IOException;
        int limit,
     * @param threadPoolName threadpool type which will be used to upload blobs asynchronously
    /**
     * @param remotePath     the remote path where upload should be made
     * @throws IOException the exception while transferring the data
     * @param threadpoolName threadpool type which will be used to perform the deletion asynchronously.
     * @param path the path in remote which needs to be deleted completely.
    /**
     *
     * @param path           path in remote store.
     * @throws IOException the exception while listing the path
     * @param remotePath     the remote path where upload should be made
    void deleteAsync(String threadpoolName, Iterable<String> path, ActionListener<Void> listener);
        Iterable<String> remotePath,
     */
     */
     * @param listener       the callback to be invoked once upload completes successfully/fails
import org.opensearch.common.blobstore.InputStreamWithMetadata;
        WritePriority writePriority,
     */
    /**
        CryptoMetadata cryptoMetadata
        Set<TransferFileSnapshot> fileSnapshots,
     * @param fileSnapshot   the file snapshot to upload
 *
    InputStreamWithMetadata downloadBlobWithMetadata(Iterable<String> path, String fileName) throws IOException;
     * @param writePriority  priority by which content needs to be written
    void listAllInSortedOrderAsync(
     * Deletes all contents with-in a path and invokes the listener on success or failure.
     *
    /**
     * @param remotePath the remote path where upload should be made
        Iterable<String> remotePath,
     *  Deletes all contents with-in a path.
     * Lists the files
     * @param path  the remote path from where download should be made
     * @throws IOException the exception while reading the data
     * @param fileSnapshot   the file snapshot to upload
     * @param inputStream the stream to read from
     */
 */
     * @param listener       the callback to be invoked once uploads complete successfully/fail
    @ExperimentalApi
    void listFoldersAsync(String threadpoolName, Iterable<String> path, ActionListener<Set<String>> listener);
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
import org.opensearch.core.action.ActionListener;
 *
     * @param path : the path to list
     * @return inputstream of the remote file
    ) throws IOException;
        final Map<Long, BlobPath> blobPaths,
        ActionListener<TransferFileSnapshot> listener,
     * @param cryptoMetadata encryption metadata for server-side encryption settings, may be null
    /**
     * @param fileName the name of the file
import java.util.Set;
     * @param listener the callback to be invoked once uploads complete successfully/fail
     */
import org.opensearch.common.blobstore.stream.write.WritePriority;
     */
     * Uploads multiple {@link TransferFileSnapshot}, once the upload is complete the callback is invoked
     * Lists the folders inside the path.
     * Reads the input stream and uploads as a blob
     * @param blobPaths      Primary term to {@link BlobPath} map
 */
    List<BlobMetadata> listAllInSortedOrder(Iterable<String> path, String filenamePrefix, int limit) throws IOException;
     * @param threadpoolName threadpool type which will be used to perform the deletion asynchronously.
     */
import java.util.List;
     */
     * @return list of folders inside the path
    InputStream downloadBlob(Iterable<String> path, String fileName) throws IOException;
 * Interface for the translog transfer service responsible for interacting with a remote store
     * @return : the lists of files
    ) throws IOException;
}
        ActionListener<List<BlobMetadata>> listener
        InputStream inputStream,
import org.opensearch.cluster.metadata.CryptoMetadata;
     * @param listener the callback to be invoked once delete completes successfully/fails.
        final TransferFileSnapshot fileSnapshot,
     *
    void uploadBlob(
/*
     * @param path the path where the deletion would occur on remote store.
import java.io.IOException;
     *
import java.io.InputStream;
    ) throws Exception;
    void uploadBlob(
 * @opensearch.internal
    /**
     * @param writePriority  priority by which content needs to be written
     */
     * @param fileName the name of the file
