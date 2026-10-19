        return keyPath + (blobName == null ? "" : blobName);
        } catch (URISyntaxException | BlobStorageException e) {
    }
        writeBlob(blobName, inputStream, blobSize, failIfAlreadyExists);
    @Override
                        throw new IOException(e);
    @Override
/*
            // snapshots, so we first check if the blob exists before trying to open an input
            throw new IOException(e);
                        }
    public Map<String, BlobMetadata> listBlobs() throws IOException {
    public long readBlobPreferredLength() {
    private final Logger logger = LogManager.getLogger(AzureBlobContainer.class);
                    + "Consider using repository-level encryption settings instead."
            result.actionGet();
            blobStore.writeBlob(buildKey(blobName), inputStream, blobSize, failIfAlreadyExists);
        logger.trace("listBlobsByPrefix({})", prefix);
    }
    AzureBlobContainer(BlobPath path, AzureBlobStore blobStore, ThreadPool threadPool) {
import org.apache.logging.log4j.LogManager;
import org.opensearch.common.blobstore.BlobMetadata;
    public void writeBlobAtomic(String blobName, InputStream inputStream, long blobSize, boolean failIfAlreadyExists) throws IOException {
            throw new IOException("Exception during bulk delete", e);
        return listBlobsByPrefix(null);
        }
        try {
        }
    }
            throw new IOException("Failed to list children in path [" + path.buildAsString() + "].", e);
        if (limit < 0) {
        logger.trace("blobExists({})", blobName);
                        blobStore.deleteBlob(buildKey(blobName));
        long blobSize,
import org.opensearch.common.blobstore.BlobContainer;
                }));
    }
    }
import org.opensearch.common.Nullable;
 * this work for additional information regarding copyright
import java.io.FileInputStream;
     * The default minimum read size, in bytes, for a {@link BlobInputStream} or {@link FileInputStream}.
        }
 */
    @Override
import org.opensearch.threadpool.ThreadPool;
            return blobStore.children(path);
                    }
/*
            throw new IOException("Can not write blob " + blobName, e);
            throw new IllegalArgumentException("limit should not be a negative value");
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
            logger.warn("can not access [{}] in container {{}}: {}", prefix, blobStore, e.getMessage());
    @Override
        try {
import org.opensearch.core.action.ActionListener;
            if (e.getStatusCode() == HttpURLConnection.HTTP_NOT_FOUND) {
            // On Azure, if the location path is a secondary location, and the blob does not
        try {
        // Azure does not support custom metadata, so we just delegate to writeBlob
        } catch (URISyntaxException | BlobStorageException e) {
        this.keyPath = path.buildAsString();
    public InputStream readBlob(String blobName, long position, long length) throws IOException {
 * not use this file except in compliance with the License.
        if (blobStore.getLocationMode() == LocationMode.SECONDARY_ONLY && !blobExists(blobName)) {
            for (String blobName : blobNames) {
public class AzureBlobContainer extends AbstractBlobContainer {
/*
import com.azure.storage.blob.specialized.BlobInputStream;
    private InputStream openInputStream(String blobName, long position, @Nullable Long length) throws IOException {
        } catch (URISyntaxException e) {
        @Nullable CryptoMetadata cryptoMetadata
            final ExecutorService executor = threadPool.executor(AzureRepositoryPlugin.REPOSITORY_THREAD_POOL_NAME);
import org.opensearch.cluster.metadata.CryptoMetadata;
    public InputStream readBlob(String blobName) throws IOException {
            }
    @Override
        if (blobNames.isEmpty()) {
    }
        } catch (URISyntaxException | BlobStorageException e) {
import java.util.concurrent.ExecutorService;
 * The OpenSearch Contributors require contributions made to
    }
                    } catch (URISyntaxException e) {
                blobNames.size()
            logger.warn("can not access [{}] in container {{}}: {}", blobName, blobStore, e.getMessage());
    public Map<String, BlobContainer> children() throws IOException {
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.blobstore.BlobPath;
     */
 *
    @Override
        }
 * software distributed under the License is distributed on an
        final PlainActionFuture<Void> result = PlainActionFuture.newFuture();
    public void deleteBlobsIgnoringIfNotExists(List<String> blobNames) throws IOException {
            );
        }
                "Azure Blob Storage repository does not currently support CryptoMetadata. "
            return super.listBlobsByPrefixInSortedOrder(blobNamePrefix, limit, blobNameSortOrder);
        try {
import com.azure.storage.blob.models.BlobStorageException;
import org.opensearch.action.support.PlainActionFuture;
            // with a 404 StorageException, Azure keeps trying and trying for a long timeout
                    } catch (BlobStorageException e) {
        try {
        }
import java.net.URISyntaxException;
 * Unless required by applicable law or agreed to in writing,
    private final AzureBlobStore blobStore;
    public DeleteResult delete() throws IOException {
        }
                executor.execute(ActionRunnable.run(listener, () -> {
    public Map<String, BlobMetadata> listBlobsByPrefix(@Nullable String prefix) throws IOException {
    public void writeBlobWithMetadata(
        InputStream inputStream,
            throw new NoSuchFileException("Blob [" + blobName + "] does not exist");
 * You may obtain a copy of the License at
            return blobStore.listBlobsByPrefixInSortedOrder(keyPath, blobNamePrefix, limit);
import java.nio.file.NoSuchFileException;
        } catch (Exception e) {
import java.util.Map;
    @Override
 *
        try {
            // exist, instead of returning immediately from the getInputStream call below
        } catch (URISyntaxException | BlobStorageException e) {
    @Override
        try {
        super(path);
    }
            throw new UnsupportedOperationException(
            // before throwing a storage exception. This can cause long delays in retrieving
            }
}
        }
            throw new IOException(e);
    protected String buildKey(String blobName) {
 */
    }
import org.opensearch.action.ActionRunnable;
        }
 * Licensed to Elasticsearch under one or more contributor
            throw new IOException(e);
    @Override
        logger.trace("writeBlob({}, stream, {})", buildKey(blobName), blobSize);
    }
                            throw new IOException(e);
    public List<BlobMetadata> listBlobsByPrefixInSortedOrder(String blobNamePrefix, int limit, BlobNameSortOrder blobNameSortOrder)
            return blobStore.blobExists(buildKey(blobName));
        this.threadPool = threadPool;
            );
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
        final BlobPath path = path();
        if (blobNameSortOrder != BlobNameSortOrder.LEXICOGRAPHIC) {
        }
package org.opensearch.repositories.azure;
import org.opensearch.common.blobstore.support.AbstractBlobContainer;
        logger.trace("listBlobs()");
                ActionListener.map(result, v -> null),
import org.opensearch.common.blobstore.DeleteResult;
                        if (e.getStatusCode() != HttpURLConnection.HTTP_NOT_FOUND) {
        boolean failIfAlreadyExists,
                    try {
        return false;
        } catch (URISyntaxException | BlobStorageException e) {
import java.io.InputStream;
    ) throws IOException {
import java.net.HttpURLConnection;
        writeBlob(blobName, inputStream, blobSize, failIfAlreadyExists);
import java.io.IOException;
 *
            throw new IOException(e);
        } catch (URISyntaxException | BlobStorageException e) {
            // Executing deletes in parallel since Azure SDK 8 is using blocking IO while Azure does not provide a bulk delete API endpoint
 * under the License.
        this.blobStore = blobStore;
    }
    public static final int DEFAULT_MINIMUM_READ_SIZE_IN_BYTES = 4 * Constants.MB;
    @Override
            // stream to it.
        return openInputStream(blobName, 0L, null);
 * this file be licensed under the Apache-2.0 license or a
    @Override
    /**
                    logger.trace("deleteBlob({})", blobName);
import org.apache.logging.log4j.Logger;
    private final String keyPath;
    }
        } else {
    private final ThreadPool threadPool;
            return blobStore.getInputStream(buildKey(blobName), position, length);
 * ownership. Elasticsearch licenses this file to you under
            throw new IOException(e);
        return openInputStream(blobName, position, length);
 */
    }
    public void writeBlob(String blobName, InputStream inputStream, long blobSize, boolean failIfAlreadyExists) throws IOException {
        if (cryptoMetadata != null) {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.support.GroupedActionListener;
            final GroupedActionListener<Void> listener = new GroupedActionListener<>(
        try {
        @Nullable Map<String, String> metadata,
        return blobStore.getReadBlobPreferredLength();
            // TODO: Upgrade to newer non-blocking Azure SDK 11 and execute delete requests in parallel that way.
    @Override
        String blobName,
        logger.trace("readBlob({}) from position [{}] with length [{}]", blobName, position, length != null ? length : "unlimited");
            return blobStore.listBlobsByPrefix(keyPath, prefix);
            result.onResponse(null);
        }
 * Modifications Copyright OpenSearch Contributors. See
        }
 * the Apache License, Version 2.0 (the "License"); you may
        } catch (BlobStorageException e) {
    public boolean blobExists(String blobName) {
 * GitHub history for details.
import java.util.List;
 * license agreements. See the NOTICE file distributed with
    }
                throw new NoSuchFileException(e.getMessage());
            return blobStore.deleteBlobDirectory(keyPath, threadPool.executor(AzureRepositoryPlugin.REPOSITORY_THREAD_POOL_NAME));
 * specific language governing permissions and limitations
    @Override
import com.azure.storage.common.implementation.Constants;
 * compatible open source license.
        throws IOException {
