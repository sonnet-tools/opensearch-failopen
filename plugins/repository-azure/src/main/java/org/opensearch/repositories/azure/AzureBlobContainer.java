                }));
import org.opensearch.common.blobstore.DeleteResult;
import com.azure.storage.blob.models.BlobStorageException;
        }
                        if (e.getStatusCode() != HttpURLConnection.HTTP_NOT_FOUND) {
 * software distributed under the License is distributed on an
    @Override
import org.opensearch.common.blobstore.BlobPath;
            return blobStore.children(path);
            // TODO: Upgrade to newer non-blocking Azure SDK 11 and execute delete requests in parallel that way.
        if (blobNames.isEmpty()) {
import java.util.Map;
        this.keyPath = path.buildAsString();
    public void writeBlob(String blobName, InputStream inputStream, long blobSize, boolean failIfAlreadyExists) throws IOException {
            return blobStore.listBlobsByPrefix(keyPath, prefix);
    }
            }  
        }
        long blobSize,
    }
            result.onResponse(null);
        }
import java.util.List;
import org.opensearch.threadpool.ThreadPool;
import com.azure.storage.blob.specialized.BlobInputStream;
        logger.trace("blobExists({})", blobName);
    public boolean blobExists(String blobName) {  
    }
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
/*  
        }  
import org.opensearch.cluster.metadata.CryptoMetadata;  
        }
                    + "Consider using repository-level encryption settings instead."
    @Override
import org.opensearch.common.blobstore.BlobContainer;
        return false;
    }
            final GroupedActionListener<Void> listener = new GroupedActionListener<>(
                    } catch (BlobStorageException e) {
 *  
            // before throwing a storage exception. This can cause long delays in retrieving
        InputStream inputStream,
    public void writeBlobAtomic(String blobName, InputStream inputStream, long blobSize, boolean failIfAlreadyExists) throws IOException {  
import org.opensearch.action.support.GroupedActionListener;
            // On Azure, if the location path is a secondary location, and the blob does not
            return blobStore.deleteBlobDirectory(keyPath, threadPool.executor(AzureRepositoryPlugin.REPOSITORY_THREAD_POOL_NAME));
        super(path);
    public List<BlobMetadata> listBlobsByPrefixInSortedOrder(String blobNamePrefix, int limit, BlobNameSortOrder blobNameSortOrder)
    }
import java.net.URISyntaxException;
        boolean failIfAlreadyExists,  
}
    /**  
import org.opensearch.action.support.PlainActionFuture;
                        }
    @Override
        } catch (URISyntaxException | BlobStorageException e) {
            }
                    } catch (URISyntaxException e) {
    public void writeBlobWithMetadata(
        try {  
        }
 */
     */
import java.io.IOException;
 * the Apache License, Version 2.0 (the "License"); you may
            throw new IOException("Failed to list children in path [" + path.buildAsString() + "].", e);
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.io.FileInputStream;
        if (blobStore.getLocationMode() == LocationMode.SECONDARY_ONLY && !blobExists(blobName)) {  
        } catch (URISyntaxException | BlobStorageException e) {
    @Override
        try {  
 * SPDX-License-Identifier: Apache-2.0
        if (limit < 0) {  
public class AzureBlobContainer extends AbstractBlobContainer {
            final ExecutorService executor = threadPool.executor(AzureRepositoryPlugin.REPOSITORY_THREAD_POOL_NAME);
            throw new IOException("Can not write blob " + blobName, e);  
    private final ThreadPool threadPool;
    public Map<String, BlobMetadata> listBlobsByPrefix(@Nullable String prefix) throws IOException {
/*
 *
        if (cryptoMetadata != null) {
            // stream to it.  
        this.blobStore = blobStore;  
     * The default minimum read size, in bytes, for a {@link BlobInputStream} or {@link FileInputStream}.
    public Map<String, BlobContainer> children() throws IOException {
            // with a 404 StorageException, Azure keeps trying and trying for a long timeout  
    public long readBlobPreferredLength() {
        String blobName,  
            throw new IllegalArgumentException("limit should not be a negative value");
            return super.listBlobsByPrefixInSortedOrder(blobNamePrefix, limit, blobNameSortOrder);
            logger.warn("can not access [{}] in container {{}}: {}", blobName, blobStore, e.getMessage());
 * not use this file except in compliance with the License.
        if (blobNameSortOrder != BlobNameSortOrder.LEXICOGRAPHIC) {  
        return blobStore.getReadBlobPreferredLength();  
        } catch (URISyntaxException | BlobStorageException e) {  
            );
    @Override
            // snapshots, so we first check if the blob exists before trying to open an input
 */  
            result.actionGet();  
    }
    }
        logger.trace("readBlob({}) from position [{}] with length [{}]", blobName, position, length != null ? length : "unlimited");
            throw new IOException(e);  
    @Override
        }
            throw new UnsupportedOperationException(
    }
    }
            if (e.getStatusCode() == HttpURLConnection.HTTP_NOT_FOUND) {  
import org.opensearch.common.blobstore.BlobMetadata;  
            return blobStore.getInputStream(buildKey(blobName), position, length);
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.blobstore.support.AbstractBlobContainer;  
        try {
        return keyPath + (blobName == null ? "" : blobName);  
        } catch (BlobStorageException e) {
 * KIND, either express or implied.  See the License for the
        writeBlob(blobName, inputStream, blobSize, failIfAlreadyExists);
 */  
            for (String blobName : blobNames) {
                    }
        try {
        @Nullable CryptoMetadata cryptoMetadata
        }  
            throw new IOException(e);  
                        throw new IOException(e);  
    }  
            blobStore.writeBlob(buildKey(blobName), inputStream, blobSize, failIfAlreadyExists);
        } catch (URISyntaxException | BlobStorageException e) {
 * GitHub history for details.
                    try {
            throw new IOException(e);
                throw new NoSuchFileException(e.getMessage());
                blobNames.size()  
        }
    public InputStream readBlob(String blobName) throws IOException {
        } else {  
            throw new IOException("Exception during bulk delete", e);
    @Override  
    @Override
        this.threadPool = threadPool;
        throws IOException {
        return openInputStream(blobName, position, length);
                            throw new IOException(e);  
        try {  
 * specific language governing permissions and limitations
package org.opensearch.repositories.azure;
            return blobStore.blobExists(buildKey(blobName));  
        return openInputStream(blobName, 0L, null);
    @Override
    }  
    public static final int DEFAULT_MINIMUM_READ_SIZE_IN_BYTES = 4 * Constants.MB;  
                ActionListener.map(result, v -> null),
 * this work for additional information regarding copyright
 *
            throw new NoSuchFileException("Blob [" + blobName + "] does not exist");
import java.nio.file.NoSuchFileException;  
        }  
        logger.trace("listBlobsByPrefix({})", prefix);
        return listBlobsByPrefix(null);
        }
import java.net.HttpURLConnection;
import java.util.concurrent.ExecutorService;  
        }  
import org.opensearch.common.Nullable;
            );
            // exist, instead of returning immediately from the getInputStream call below
        } catch (Exception e) {
                executor.execute(ActionRunnable.run(listener, () -> {  
            logger.warn("can not access [{}] in container {{}}: {}", prefix, blobStore, e.getMessage());
    @Override  
import org.opensearch.core.action.ActionListener;
 * Unless required by applicable law or agreed to in writing,
        } catch (URISyntaxException | BlobStorageException e) {  
    AzureBlobContainer(BlobPath path, AzureBlobStore blobStore, ThreadPool threadPool) {
        logger.trace("listBlobs()");  
    private final String keyPath;
            throw new IOException(e);  
 * ownership. Elasticsearch licenses this file to you under  
import java.io.InputStream;  
    }
                    logger.trace("deleteBlob({})", blobName);
            return blobStore.listBlobsByPrefixInSortedOrder(keyPath, blobNamePrefix, limit);
 * The OpenSearch Contributors require contributions made to  
        @Nullable Map<String, String> metadata,
import org.apache.logging.log4j.Logger;
/*  
 * under the License.  
    @Override
    private final Logger logger = LogManager.getLogger(AzureBlobContainer.class);
    public InputStream readBlob(String blobName, long position, long length) throws IOException {  
    }  
        logger.trace("writeBlob({}, stream, {})", buildKey(blobName), blobSize);
        try {
        } catch (URISyntaxException e) {
        try {
    private InputStream openInputStream(String blobName, long position, @Nullable Long length) throws IOException {
        final PlainActionFuture<Void> result = PlainActionFuture.newFuture();  
        writeBlob(blobName, inputStream, blobSize, failIfAlreadyExists);
        } catch (URISyntaxException | BlobStorageException e) {
    public Map<String, BlobMetadata> listBlobs() throws IOException {
import org.apache.logging.log4j.LogManager;
    @Override  
    private final AzureBlobStore blobStore;  
        final BlobPath path = path();  
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override  
                "Azure Blob Storage repository does not currently support CryptoMetadata. "  
            throw new IOException(e);
        // Azure does not support custom metadata, so we just delegate to writeBlob
 * license agreements. See the NOTICE file distributed with
    }
    ) throws IOException {  
    }  
import com.azure.storage.common.implementation.Constants;  
    }
    protected String buildKey(String blobName) {
    public DeleteResult delete() throws IOException {
 * compatible open source license.
                        blobStore.deleteBlob(buildKey(blobName));  
    public void deleteBlobsIgnoringIfNotExists(List<String> blobNames) throws IOException {
            // Executing deletes in parallel since Azure SDK 8 is using blocking IO while Azure does not provide a bulk delete API endpoint  
import org.opensearch.action.ActionRunnable;  
        try {  
        }  
