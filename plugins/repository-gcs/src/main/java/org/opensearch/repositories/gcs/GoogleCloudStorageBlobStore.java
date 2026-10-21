    public static final int LARGE_BLOB_THRESHOLD_BYTE_SIZE;
    public Map<String, Long> stats() {
     *
    }
                            }
                /*
     * @param blobName name of the blob
                                ioe,
        final String pathStr = path.buildAsString();
                        } catch (final IOException ioe) {
                .forEach(blob -> {
import com.google.cloud.storage.BlobInfo;
     */
                    if (blob.isDirectory()) {
    private final String repositoryName;
                            if (storageException != null) {
            return;
        if (largeBlobThresholdByteSizeProperty == null) {
     */
            final int largeBlobThresholdByteSize;
        this.storageService = storageService;
            } while (page != null);
        assert storageException != null;
        final MapBuilder<String, BlobContainer> mapBuilder = MapBuilder.newMapBuilder();
                .iterateAll()
     */
     * @param blobInfo the info for the blob to be uploaded
     * @return the InputStream used to read the blob's content
    /**
     *
     * gziped), see:
     */
                                if (ioe.compareAndSet(null, exception) == false) {
    }
        if (position < 0L) {
     * @param inputStream the stream containing the blob data
    }
     * @param failIfAlreadyExists whether to throw a FileAlreadyExistsException if the given blob already exists
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
import java.util.Collections;
     */
            stats.trackPostOperation();
     * can be independently retried in case of failure, see
            () -> client().list(bucketName, BlobListOption.currentDirectory(), BlobListOption.prefix(pathPrefix))
import org.apache.logging.log4j.LogManager;
    public BlobContainer blobContainer(BlobPath path) {
     * @param blobName name of the blob
            AccessController.doPrivilegedChecked(() -> {
    }
     *
        final Storage.BlobWriteOption[] writeOptions = failIfAlreadyExists
                for (BlobId blob : blobIdsToDelete) {
                    }
            throw se;
 * compatible open source license.
import org.opensearch.common.blobstore.BlobContainer;
            try {
            if (largeBlobThresholdByteSize <= 0) {
    /**
     * @param path base path of the blobs to list
import org.opensearch.common.blobstore.DeleteResult;
     * @param size expected size of the blob to be written
            : new Storage.BlobWriteOption[0];
     *  @param blobInfo the info for the blob to be uploaded
    // https://cloud.google.com/storage/docs/json_api/v1/how-tos/resumable-upload
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    }
import java.util.concurrent.atomic.AtomicLong;
                        @Override
                                    ioe.get().addSuppressed(exception);
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;
                // We don't track this operation on the http layer as
        throws IOException {
     * @param blobName name of the blob
    static {
     *
import org.opensearch.common.blobstore.BlobStore;
        return mapBuilder.immutableMap();
 * this file be licensed under the Apache-2.0 license or a
        );
        this.clientName = clientName;
    }
import java.nio.ByteBuffer;
    @Override
    public void close() {
                BlobId.of(bucketName, blobName),
 */
import org.apache.logging.log4j.message.ParameterizedMessage;
                        final String suffixName = blob.getName().substring(path.length());
            });
            // we do with the GET/LIST operations since this operations
import org.opensearch.common.blobstore.BlobPath;
                                failedBlobs.add(blob);
        return AccessController.doPrivilegedChecked(() -> {
    Map<String, BlobContainer> listChildren(BlobPath path) throws IOException {
                    continue;
        final BlobInfo blobInfo = BlobInfo.newBuilder(bucketName, blobName).build();
    }
    DeleteResult deleteDirectory(String pathStr) throws IOException {
     * Returns true if the blob exists in the specific bucket
                            throw ioe;
     * Uploads a blob using the "multipart upload" method (a single
            }
    // The recommended maximum size of a blob that should be uploaded in a single
     * Writes a blob in the specific bucket
            Page<Blob> page = client().list(bucketName, BlobListOption.prefix(pathStr));
     * @return a map of blob names and their metadata.
            // can trigger multiple underlying http requests but only one
 *
    Map<String, BlobMetadata> listBlobs(String path) throws IOException {
        assert inputStream.markSupported();
        String clientName,
        return new GoogleCloudStorageRetryingInputStream(client(), BlobId.of(bucketName, blobName));
                }), buffer);
            return new GoogleCloudStorageRetryingInputStream(
        this.stats = new GoogleCloudStorageOperationsStats(bucketName);
    void writeBlob(String blobName, InputStream inputStream, long blobSize, boolean failIfAlreadyExists) throws IOException {
 * this work for additional information regarding copyright
    private final String bucketName;
    }
import org.opensearch.common.blobstore.BlobMetadata;
            return deleteResult;
                    public void close() throws IOException {
     * @return the InputStream used to read the blob's content
     * Returns an {@link java.io.InputStream} for the given blob's position and length
        final Blob blob = AccessController.doPrivilegedChecked(() -> client().get(blobId));
                            mapBuilder.put(suffixName, new GoogleCloudStorageBlobContainer(path.add(suffixName), this));
        } else {
import java.nio.channels.WritableByteChannel;
                    @SuppressForbidden(reason = "channel is based on a socket")
                        AccessController.doPrivilegedChecked(writeChannel::close);
import static java.net.HttpURLConnection.HTTP_GONE;
                }
     * https://cloud.google.com/storage/docs/json_api/v1/how-tos/multipart-upload
import com.google.cloud.storage.Storage.BlobListOption;
                final StorageException exception = ioe.get();
        AccessController.doPrivilegedChecked(
                    }
        if (length < 0) {
/*
 * ownership. Elasticsearch licenses this file to you under
import java.nio.channels.Channels;
        return blob != null;
                }
                largeBlobThresholdByteSize = Integer.parseInt(largeBlobThresholdByteSizeProperty);
        GoogleCloudStorageService storageService,
 * under the License.
    InputStream readBlob(String blobName) throws IOException {
                // operation is billed.
     * @return a map of blob names and their metadata
    /**
                final WriteChannel writeChannel = AccessController.doPrivilegedChecked(() -> client().writer(blobInfo, writeOptions));
        final List<BlobId> blobIdsToDelete = blobNames.stream().map(blob -> BlobId.of(bucketName, blob)).collect(Collectors.toList());
                            if (exception.getCode() != HTTP_NOT_FOUND) {
        final List<BlobId> failedBlobs = Collections.synchronizedList(new ArrayList<>());
import com.google.cloud.storage.BlobId;
        final BlobId blobId = BlobId.of(bucketName, blobName);
        }
import java.util.List;
                if (storageException != null) {
    private static final Logger logger = LogManager.getLogger(GoogleCloudStorageBlobStore.class);
        assert blobSize <= getLargeBlobThresholdInBytes() : "large blob uploads should use the resumable upload method";
                 * is in the stacktrace and is not granted the permissions needed to close and write the channel.
 */
 *
            } catch (final StorageException se) {
        final byte[] buffer = new byte[size < bufferSize ? Math.toIntExact(size) : bufferSize];
 * Licensed to Elasticsearch under one or more contributor
                page.getValues().forEach(b -> {
                deleteResult = deleteResult.add(blobsDeleted.get(), bytesDeleted.get());
     * @param blobNames names of the blobs to delete
                .iterateAll()
        final String pathPrefix = buildKey(path, prefix);
        StorageException storageException = null;
            throw new IllegalArgumentException("position must be non-negative");
        // needs to be restarted from scratch. Given how unlikely a 410 error should be according to SLAs we retry only twice.
            throw new IOException("Exception when deleting blobs [" + failedBlobs + "]", e);
import org.opensearch.common.collect.MapBuilder;
 * The OpenSearch Contributors require contributions made to
/*
        return storageService.client(clientName, repositoryName, stats);
                org.opensearch.common.util.io.Streams.copy(inputStream, Channels.newOutputStream(new WritableByteChannel() {
     *
        Streams.readFully(inputStream, buffer);
    /**
        final MapBuilder<String, BlobMetadata> mapBuilder = MapBuilder.newMapBuilder();
     *            names of the blobs returned.
                            return AccessController.doPrivilegedChecked(() -> writeChannel.write(src));
                throw new IllegalArgumentException("failed to parse " + key + " having value [" + largeBlobThresholdByteSizeProperty + "]");
     * 'multipart/related' request containing both data and metadata. The request is
import com.google.cloud.BatchResult;
                Math.addExact(position, length - 1)
        final String key = "opensearch.repository_gcs.large_blob_threshold_byte_size";
        } catch (final Exception e) {
import com.google.cloud.storage.StorageBatch;
     * @param inputStream content of the blob to be written
                }
    @Override
        inputStream.mark(Integer.MAX_VALUE);
        if (blobSize > getLargeBlobThresholdInBytes()) {
     */
                position,
        try {
     * List blobs in the specific bucket under the specified path. The path root is removed.
            ? new Storage.BlobWriteOption[] { Storage.BlobWriteOption.doesNotExist() }
import org.opensearch.common.io.Streams;
                final Collection<String> blobsToDelete = new ArrayList<>();
                return;
        }
                final StorageBatch batch = client().batch();
    }
        return LARGE_BLOB_THRESHOLD_BYTE_SIZE;
        }
     * @param prefix prefix of the blobs to list.
                    @Override
        } else {
                        }
    private final GoogleCloudStorageOperationsStats stats;
 * not use this file except in compliance with the License.
        }
        storageService.closeRepositoryClient(repositoryName);
        return keyPath + s;
    }
import org.apache.logging.log4j.Logger;
    // called "resumable upload")
                if (exception != null) {
                .forEach(blob -> {
 * GitHub history for details.
     */
import org.opensearch.core.common.unit.ByteSizeUnit;
                    se.addSuppressed(storageException);
                })
    long getLargeBlobThresholdInBytes() {
import com.google.cloud.storage.Storage;
import java.util.Map;
                throw se;
import org.opensearch.core.common.unit.ByteSizeValue;
            }
 * software distributed under the License is distributed on an
                ? new Storage.BlobTargetOption[] { Storage.BlobTargetOption.doesNotExist() }
                        public void error(StorageException exception) {
    /**
        });
import java.util.ArrayList;
    }
    private void writeBlobResumable(BlobInfo blobInfo, InputStream inputStream, long size, boolean failIfAlreadyExists) throws IOException {
import org.opensearch.ExceptionsHelper;
 * You may obtain a copy of the License at
            AccessController.doPrivilegedChecked(() -> client().create(blobInfo, buffer, targetOptions));
                stats.trackPutOperation();
            do {
    @Override
            // operation is billed.
                        assert blob.getName().endsWith("/");
import com.google.cloud.WriteChannel;
     * @param path
}
     */
     * @param failIfAlreadyExists whether to throw a FileAlreadyExistsException if the given blob already exists
        this.bufferSize = bufferSize;
    // request. Larger files should be uploaded over multiple requests (this is
        } else {
import java.util.concurrent.atomic.AtomicReference;
    }
                                StorageException.class
            );
        }
    GoogleCloudStorageBlobStore(
                    blobsToDelete.add(b.getName());
                page = page.getNextPage();
            writeBlobMultipart(blobInfo, inputStream, blobSize, failIfAlreadyExists);
 * the Apache License, Version 2.0 (the "License"); you may
            // We don't track this operation on the http layer as
        String bucketName,
                        }
                        assert blob.getName().startsWith(pathStr);
        this.repositoryName = repositoryName;
            } catch (final NumberFormatException e) {
        return listBlobsByPrefix(path, "");
     * Returns an {@link java.io.InputStream} for the given blob name
     */
    private final String clientName;
    }
                    if (blob.isDirectory() == false) {
                    }
     * https://cloud.google.com/storage/docs/json_api/v1/how-tos/resumable-upload
    }
     * @param pathStr Name of path to delete
    }
                        return writeChannel.isOpen();
            final Storage.BlobTargetOption[] targetOptions = failIfAlreadyExists
                        mapBuilder.put(suffixName, new PlainBlobMetadata(suffixName, blob.getSize()));
            DeleteResult deleteResult = DeleteResult.ZERO;
 */
        }
        try {
                if (errorCode == HTTP_GONE) {
/*
import org.opensearch.common.blobstore.support.PlainBlobMetadata;
            () -> client().list(bucketName, BlobListOption.currentDirectory(), BlobListOption.prefix(pathStr))
 *
    InputStream readBlob(String blobName, long position, long length) throws IOException {
     * @return true iff the blob exists
        }
     *
    private void writeBlobMultipart(BlobInfo blobInfo, InputStream inputStream, long blobSize, boolean failIfAlreadyExists)
        }
                    storageException = ExceptionsHelper.useOrSuppress(storageException, se);
package org.opensearch.repositories.gcs;
     * @param blobSize    expected size of the blob to be written
                            );
                    public int write(final ByteBuffer src) throws IOException {
                    throw new FileAlreadyExistsException(blobInfo.getBlobId().getName(), null, se.getMessage());
            try {
class GoogleCloudStorageBlobStore implements BlobStore {
    /**
        // We retry 410 GONE errors to cover the unlikely but possible scenario where a resumable upload session becomes broken and
    /**
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
import java.io.ByteArrayInputStream;
        } catch (final StorageException se) {
            writeBlobResumable(blobInfo, inputStream, blobSize, failIfAlreadyExists);
                        try {
            if (failIfAlreadyExists && se.getCode() == HTTP_PRECON_FAILED) {
                        public void success(Boolean result) {}
                    logger.warn(() -> new ParameterizedMessage("Retrying broken resumable upload session for blob {}", blobInfo), se);
    private static String buildKey(String keyPath, String s) {
        this.bucketName = bucketName;
            return new ByteArrayInputStream(new byte[0]);
                            final StorageException storageException = (StorageException) ExceptionsHelper.unwrap(
        assert s != null;
    }
            LARGE_BLOB_THRESHOLD_BYTE_SIZE = largeBlobThresholdByteSize;
    private final int bufferSize;
                final AtomicLong blobsDeleted = new AtomicLong(0L);
import static java.net.HttpURLConnection.HTTP_PRECON_FAILED;
        String repositoryName,
 * specific language governing permissions and limitations
                            }
import java.io.IOException;
     * List all blobs in the specific bucket with names prefixed
                 */
                        if (suffixName.isEmpty() == false) {
                client(),
     * @param failIfAlreadyExists whether to throw a FileAlreadyExistsException if the given blob already exists
    }
                        @Override
                    });
import java.io.InputStream;
        int bufferSize
import java.nio.file.FileAlreadyExistsException;
                deleteBlobsIgnoringIfNotExists(blobsToDelete);
    Map<String, BlobMetadata> listBlobsByPrefix(String path, String prefix) throws IOException {
    }
            throw new IllegalArgumentException("length must be non-negative");
                throw new IllegalArgumentException(key + " must be positive but was [" + largeBlobThresholdByteSizeProperty + "]");
     * Uploads a blob using the "resumable upload" method (multiple requests, which
     *
import com.google.cloud.storage.Blob;
                });
                final int errorCode = se.getCode();
        }
import com.google.cloud.storage.StorageException;
                // can trigger multiple underlying http requests but only one
     * @param position starting position to read from
                final AtomicReference<StorageException> ioe = new AtomicReference<>();
                : new Storage.BlobTargetOption[0];
                        }
                }
        return new GoogleCloudStorageBlobContainer(path, this);
        AccessController.doPrivilegedChecked(
    private final GoogleCloudStorageService storageService;
     * @param length length of bytes to read
        return stats.toMap();
                } else if (failIfAlreadyExists && errorCode == HTTP_PRECON_FAILED) {
import org.opensearch.common.SuppressForbidden;
                                }
                                throw storageException;
            }
import com.google.api.gax.paging.Page;
 * SPDX-License-Identifier: Apache-2.0
                    throw exception;
                throw new FileAlreadyExistsException(blobInfo.getBlobId().getName(), null, se.getMessage());
        final String largeBlobThresholdByteSizeProperty = System.getProperty(key);
                final AtomicLong bytesDeleted = new AtomicLong(0L);
    /**
        );
                    inputStream.reset();
        if (blobNames.isEmpty()) {
     * Deletes the given path and all its children.
    }
        throw storageException;
                        // Strip path prefix and trailing slash
                    bytesDeleted.addAndGet(b.getSize());
        final byte[] buffer = new byte[Math.toIntExact(blobSize)];
 *    http://www.apache.org/licenses/LICENSE-2.0
     *            base path of the blobs to list. This path is removed from the
                    batch.delete(blob).notify(new BatchResult.Callback<Boolean, StorageException>() {
                    public boolean isOpen() {
    boolean blobExists(String blobName) throws IOException {
     * @param blobSize the size
            LARGE_BLOB_THRESHOLD_BYTE_SIZE = Math.toIntExact(new ByteSizeValue(5, ByteSizeUnit.MB).getBytes());
    private Storage client() throws IOException {
                    assert blob.getName().startsWith(path);
                 * It is not enough to wrap the call to Streams#copy, we have to wrap the privileged calls too; this is because Streams#copy
    ) {
     * Deletes multiple blobs from the specific bucket using a batch request
    /**
    /**
                    blobsDeleted.incrementAndGet();
     * @param inputStream the stream containing the blob data
import java.util.stream.Collectors;
                })
        if (length == 0) {
import org.opensearch.secure_sm.AccessController;
                // we do with the GET/LIST operations since this operations
                    }
                batch.submit();
    }
        return mapBuilder.immutableMap();
                        final String suffixName = blob.getName().substring(pathStr.length(), blob.getName().length() - 1);
    // non-static, package private for testing
     */
                    @Override
        for (int retry = 0; retry < 3; ++retry) {
    void deleteBlobsIgnoringIfNotExists(Collection<String> blobNames) throws IOException {
import java.util.Collection;
                    @Override
        assert failedBlobs.isEmpty();
