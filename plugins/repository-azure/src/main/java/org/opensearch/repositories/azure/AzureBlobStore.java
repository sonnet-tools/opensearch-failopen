        });
                    new BlobParallelUploadOptions(inputStream, blobSize).setRequestConditions(blobRequestConditions)
    private Tuple<BlobServiceClient, Supplier<Context>> client() {
 *
                if (blobItem.isPrefix() != null && blobItem.isPrefix()) {
                return;
            logger.trace(
    public List<BlobMetadata> listBlobsByPrefixInSortedOrder(String keyPath, String prefix, int limit) throws URISyntaxException,
        logger.trace(() -> new ParameterizedMessage("writeBlob({}, stream, {})", blobName, blobSize));
                "ListBlobs",
    public AzureBlobStore(RepositoryMetadata metadata, AzureStorageService service, ThreadPool threadPool) {
                logger.trace(() -> new ParameterizedMessage("blob name [{}]", name));
                            result.onResponse(null);
import java.io.IOException;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    () -> new ParameterizedMessage("upload({}, stream, {}) - status [{}]", blobName, blobSize, response.getStatusCode())
        service.close();
            }
        AccessController.doPrivilegedChecked(() -> {
            if (length == null) {
            if (method.equals(HttpMethod.HEAD)) {
    }
        this.container = Repository.CONTAINER_SETTING.get(metadata.settings());
    }
                        if (outstanding.decrementAndGet() == 0) {
import org.opensearch.repositories.azure.AzureRepository.Repository;
import org.apache.logging.log4j.message.ParameterizedMessage;
                final BlobRange range = length == null ? new BlobRange(position) : new BlobRange(position, length);
import org.opensearch.common.blobstore.BlobStore;
                        }
     * @return blob name
            return List.of();
                "GetBlob",
import java.time.Duration;
            );
import com.azure.storage.blob.models.BlobItem;
            final Integer readBlockSize = service.getReadBlockSize(clientName);
                    client.v2().get()
        this.locationMode = Repository.LOCATION_MODE_SETTING.get(metadata.settings());
                    blobsBuilder.add(name);
        final Tuple<BlobServiceClient, Supplier<Context>> client = client();
                headOperations.get(),
    private final LocationMode locationMode;
                    }
 * Unless required by applicable law or agreed to in writing,
                } else {
            result.onResponse(null);
    public Map<String, BlobMetadata> listBlobsByPrefix(String keyPath, String prefix) throws URISyntaxException, BlobStorageException {
        }
import com.azure.core.http.rest.Response;
import com.azure.storage.blob.models.BlobErrorCode;
import org.apache.logging.log4j.Logger;
 *
            .setPrefix(keyPath + (prefix == null ? "" : prefix));
    private final AzureStorageService service;
    public LocationMode getLocationMode() {
            blobsBuilder.stream()
            if (ex.getCause() != null) {
                return;
        private Map<String, Long> toMap() {
        logger.trace(() -> new ParameterizedMessage("writeBlob({}, stream, {}) - done", blobName, blobSize));
        return Collections.unmodifiableMap(
                    continue;
            );
import java.util.Collection;
 * compatible open source license.
public class AzureBlobStore implements BlobStore {
    }
                // Skipping over the prefixes, only look for the blobs
import java.net.HttpURLConnection;
 *    http://www.apache.org/licenses/LICENSE-2.0
                        logger.trace(
                getOperations.get(),
                            () -> new ParameterizedMessage("container [{}]: blob [{}] found. removing.", container, blobItem.getName())
            for (final BlobItem blobItem : blobContainer.listBlobsByHierarchy("/", listBlobsOptions, timeout())) {
        result.actionGet();
                blobsBuilder.put(name, new PlainBlobMetadata(name, properties.getContentLength()));
    private final String clientName;
            final IOException ex = new IOException("Deleting directory [" + path + "] failed");
    }
                executor.execute(new AbstractRunnable() {
        return service;
        // locationMode is set per repository, not per client
            }
        }
        final BlobContainerClient blobContainer = client.v1().getBlobContainerClient(container);
import java.util.concurrent.atomic.AtomicLong;
            .setPrefix(keyPath);
        final Tuple<BlobServiceClient, Supplier<Context>> client = client();
 * GitHub history for details.
        AccessController.doPrivilegedChecked(() -> {
                .collect(Collectors.toMap(Function.identity(), name -> new AzureBlobContainer(path.add(name), this, threadPool)))
        AccessController.doPrivilegedChecked(() -> {
        });
                return azureBlob.openInputStream(new BlobRange(position), null);
        AccessController.doPrivilegedChecked(() -> {
                    }
    }
import org.opensearch.common.blobstore.BlobPath;
        AccessController.doPrivilegedChecked(() -> {
            AccessController.doPrivilegedChecked(() -> {
            } else {
 * under the License.
                    // Lastly, we add the length of keyPath to the offset to strip this container's path.
        logger.trace(() -> new ParameterizedMessage("listing container [{}], keyPath [{}], prefix [{}]", container, keyPath, prefix));
                "PutBlockList",
        return new DeleteResult(blobsDeleted.get(), bytesDeleted.get());
     * Gets the configured {@link LocationMode} for the Azure storage requests.
import com.azure.storage.blob.models.BlobItemProperties;
        final BlobClient blob = blobContainer.getBlobClient(blobName);
            final BlobRequestConditions blobRequestConditions = new BlobRequestConditions();
                final String queryParams = (query == null) ? "" : query;
                );
        final BlobClient azureBlob = blobContainer.getBlobClient(blob);
                        logger.trace(
    @Override
            }
        final List<BlobMetadata> blobs = new ArrayList<>(Math.min(limit, LIST_PAGE_SIZE));
import com.azure.storage.blob.models.BlobRequestConditions;
            } else if (method.equals(HttpMethod.PUT)) {
            name = name.substring(keyPath.length());
        String name = pathOrName;
        logger.trace(() -> new ParameterizedMessage("delete blob for container [{}], blob [{}]", container, blob));
import java.util.List;
        });
        final Tuple<BlobServiceClient, Supplier<Context>> client = client();
                && BlobErrorCode.BLOB_ALREADY_EXISTS.equals(se.getErrorCode())) {
                                blobItem.getName(),
        return service.getBlobRequestTimeout(clientName);
            }
                final String name = getBlobName(blobItem.getName(), container, keyPath);
 * Licensed to Elasticsearch under one or more contributor
                && se.getStatusCode() == HttpURLConnection.HTTP_CONFLICT
                putOperations.get(),
                final String queryParams = (query == null) ? "" : query;
 * software distributed under the License is distributed on an
        final BlobContainerClient blobContainer = client.v1().getBlobContainerClient(container);
        // NOTE: this should be here: if (prefix == null) prefix = "";
        assert inputStream.markSupported()
            exceptions.forEach(ex::addSuppressed);
    @Override
    }
                    timeout(),
        final Map<String, AzureStorageSettings> newSettings = AzureStorageSettings.overrideLocationMode(prevSettings, this.locationMode);
    public String toString() {
import java.util.ArrayList;
            final Response<Void> response = azureBlob.deleteWithResponse(null, null, timeout(), client.v2().get());
 *
     * Extracts the name of the blob from path or prefixed blob name
import java.util.function.BiConsumer;
            logger.trace(() -> new ParameterizedMessage("container [{}]: blob [{}] found. removing.", container, blob));
     * @param container container
    }
        final Tuple<BlobServiceClient, Supplier<Context>> client = client();
 * specific language governing permissions and limitations
    }
        return name;
    public void close() throws IOException {
 */
        final AtomicLong blobsDeleted = new AtomicLong();
                if (queryParams.contains("comp=list")) {
import com.azure.core.http.HttpRequest;
                final String query = request.getUrl().getQuery();
                    stats.putBlockOperations.incrementAndGet();
        return container;
        });
                    // The only URI parameter allowed for put-blob operation is "timeout", but if a sas token is used,
        this.threadPool = threadPool;
     * @param pathOrName prefixed blob name or blob path
            } else if (method.equals(HttpMethod.GET)) {
        final BlobContainerClient blobContainer = client.v1().getBlobContainerClient(container);
        return AccessController.doPrivileged(() -> {
                    continue;
        final BlobContainerClient blobContainer = client.v1().getBlobContainerClient(container);
import java.util.concurrent.Executor;
            return response.getValue();
            .setMaxResultsPerPage(Math.min(limit, LIST_PAGE_SIZE));
            final BlobClient azureBlob = blobContainer.getBlobClient(blob);
        private final AtomicLong listOperations = new AtomicLong();
        }
import java.util.HashSet;
import java.io.InputStream;
        private final AtomicLong putBlockListOperations = new AtomicLong();
            if (readBlockSize != null) {
    private static class Stats {
            });
 * The OpenSearch Contributors require contributions made to
                    break;
package org.opensearch.repositories.azure;
import org.opensearch.common.blobstore.support.PlainBlobMetadata;
    private final Stats stats = new Stats();
 * license agreements. See the NOTICE file distributed with
            name = name.substring(1 + container.length() + 1);
 * KIND, either express or implied.  See the License for the
                    public void onAfter() {
                    stats.putOperations.incrementAndGet();
import com.azure.storage.blob.BlobServiceClient;
                stats.headOperations.incrementAndGet();
                });
                    logger.trace(() -> new ParameterizedMessage("blob name [{}]", name));
            return Map.of(
                if (queryParams.contains("comp=block") && queryParams.contains("blockid=")) {
import org.opensearch.common.blobstore.DeleteResult;
                    @Override
        final Set<String> blobsBuilder = new HashSet<String>();
    }
            .setPrefix(keyPath + (prefix == null ? "" : prefix))
                throw new FileAlreadyExistsException(blobName, null, se.getMessage());
 * Modifications Copyright OpenSearch Contributors. See
        if (limit == 0) {
import com.azure.storage.blob.models.ListBlobsOptions;
import com.azure.storage.blob.models.BlobRange;
        return service.client(clientName, metricsCollector);
        final PlainActionFuture<Void> result = PlainActionFuture.newFuture();
    private static final int LIST_PAGE_SIZE = 5_000;
        final Tuple<BlobServiceClient, Supplier<Context>> client = client();
    public long getReadBlobPreferredLength() {
            // Since most of the logic is happening inside the reactive pipeline, the checked exceptions
            // are swallowed and wrapped into runtime one (see please Exceptions.ReactiveException).
                putBlockOperations.get(),
import org.opensearch.threadpool.ThreadPool;
import com.azure.storage.blob.BlobContainerClient;
        // Container name must be lower case.
        final AtomicLong outstanding = new AtomicLong(1L);
                Throwables.rethrow(ex.getCause());
                    stats.getOperations.incrementAndGet();
        // then does a prefix match on the result; it should just call listBlobsByPrefix with the prefix!
                } else {
import com.azure.core.http.HttpResponse;
import static java.util.Collections.emptyMap;
import java.nio.file.FileAlreadyExistsException;
        } catch (final RuntimeException ex) {
                }
import org.apache.logging.log4j.core.util.Throwables;
                    stats.listOperations.incrementAndGet();
        final Tuple<BlobServiceClient, Supplier<Context>> client = client();
        this.service = service;
        } catch (final BlobStorageException se) {
            : "Should not be used with non-mark supporting streams as their retry handling in the SDK is broken";
        return stats.toMap();
    private Duration timeout() {
    public Map<String, Long> stats() {
                if (blobs.size() == limit) {
                                container,
        });
        final BlobContainerClient blobContainer = client.v1().getBlobContainerClient(container);
        private final AtomicLong putOperations = new AtomicLong();
    private final String container;
    }
                                "container [{}]: blob [{}] deleted status [{}].",
        });
                        final Response<Void> response = azureBlob.deleteWithResponse(null, null, timeout(), client.v2().get());
        final BlobContainerClient blobContainer = client.v1().getBlobContainerClient(container);
    private String getBlobName(final String pathOrName, final String container, final String keyPath) {
            }
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.util.concurrent.AbstractRunnable;
                outstanding.incrementAndGet();
        if (exceptions.isEmpty() == false) {
                    }
                "GetBlobProperties",
                throw ex;
}
        private final AtomicLong getOperations = new AtomicLong();
                // https://docs.microsoft.com/en-us/rest/api/storageservices/put-block
        private final AtomicLong putBlockOperations = new AtomicLong();
import com.azure.storage.blob.options.BlobParallelUploadOptions;
import java.util.Map;
import java.util.function.Function;
    /**
                    final String name = getBlobName(blobItem.getName(), container, keyPath).replaceAll("/$", "");
                                response.getStatusCode()
            throw ex;
                        .setParallelTransferOptions(service.getBlobRequestOptionsForWriteBlob(clientName)),
                // Skipping prefixes as those are not deletable and should not be there
        this.service.refreshAndClearCache(newSettings);
                logger.trace(
        final ListBlobsOptions listBlobsOptions = new ListBlobsOptions().setDetails(new BlobListDetails().setRetrieveMetadata(true))
        // Container name must be lower case.
import com.azure.storage.blob.options.BlobInputStreamOptions;
            }
                        if (len >= 0) {
                assert (blobItem.isPrefix() == null || !blobItem.isPrefix()) : "Only blobs (not prefixes) are expected";
    public void writeBlob(String blobName, InputStream inputStream, long blobSize, boolean failIfAlreadyExists) throws URISyntaxException,
    }
import org.opensearch.secure_sm.AccessController;
    public boolean blobExists(String blob) throws URISyntaxException, BlobStorageException {
 * not use this file except in compliance with the License.
        final ListBlobsOptions listBlobsOptions = new ListBlobsOptions().setDetails(new BlobListDetails().setRetrieveMetadata(true))
            final HttpMethod method = request.getHttpMethod();
                listOperations.get(),
        private final AtomicLong headOperations = new AtomicLong();
/*
import org.apache.logging.log4j.LogManager;
                        );
    /**
                // Skipping over the blobs, only look for prefixes
        try {
        });
 */
                            bytesDeleted.addAndGet(len);
     */
    @Override
            }
    public InputStream getInputStream(String blob, long position, @Nullable Long length) throws URISyntaxException, BlobStorageException {
                blobRequestConditions.setIfNoneMatch(Constants.HeaderConstants.ETAG_WILDCARD);
            for (final BlobItem blobItem : blobContainer.listBlobs(listBlobsOptions, timeout())) {
                }
import org.opensearch.common.collect.MapBuilder;
                    // https://docs.microsoft.com/en-us/rest/api/storageservices/put-blob#uri-parameters
                () -> new ParameterizedMessage("container [{}]: blob [{}] deleted status [{}].", container, blob, response.getStatusCode())
        final String keyPath = path.buildAsString();
                if (blobItem.isPrefix() != null && blobItem.isPrefix()) {
    @Override
                if (blobItem.isPrefix() != null && blobItem.isPrefix()) {
                    // this requires 1 + container.length() + 1, with each 1 corresponding to one of the /.
        }
                        }
            } else {
                final BlobItemProperties properties = blobItem.getProperties();
import com.azure.core.util.Context;
            throw se;
    public BlobContainer blobContainer(BlobPath path) {
        return MapBuilder.newMapBuilder(blobsBuilder).immutableMap();
            }
        final Integer readBlockSize = service.getReadBlockSize(clientName);
        }
    }
     * @param keyPath key path
import java.util.Collections;
        final Tuple<BlobServiceClient, Supplier<Context>> client = client();
 * the Apache License, Version 2.0 (the "License"); you may
                "PutBlock",
            if (failIfAlreadyExists
    }
            for (final BlobItem blobItem : blobContainer.listBlobsByHierarchy("/", listBlobsOptions, timeout())) {
import java.util.stream.Collectors;
                }
            if (response.getStatusCode() >= 300) {
import org.opensearch.cluster.metadata.RepositoryMetadata;
        if (name.startsWith(keyPath)) {
import org.opensearch.common.blobstore.BlobMetadata;
                final String query = request.getUrl().getQuery();
                putBlockListOperations.get()
        final Map<String, AzureStorageSettings> prevSettings = this.service.refreshAndClearCache(emptyMap());
 * ownership. Elasticsearch licenses this file to you under
    }
import java.util.Set;
                    @Override
                return azureBlob.openInputStream(new BlobInputStreamOptions().setRange(range).setBlockSize(readBlockSize));
        logger.trace(() -> new ParameterizedMessage("reading container [{}], blob [{}]", container, blob));
        final Tuple<BlobServiceClient, Supplier<Context>> client = client();
                        final long len = blobItem.getProperties().getContentLength();
            final Response<Boolean> response = azureBlob.existsWithResponse(timeout(), client.v2().get());
import com.azure.storage.blob.models.BlobStorageException;
                blobs.add(new PlainBlobMetadata(name, properties.getContentLength()));
        }
            if (failIfAlreadyExists) {
        final Collection<Exception> exceptions = Collections.synchronizedList(new ArrayList<>());
        BlobStorageException, IOException {
        final ListBlobsOptions listBlobsOptions = new ListBlobsOptions().setPrefix(path);
        BlobStorageException {
                "PutBlob",
import java.util.function.Supplier;
 */
import org.opensearch.common.Nullable;
     */
        this.metricsCollector = (request, response) -> {
        if (outstanding.decrementAndGet() == 0) {
import org.opensearch.action.support.PlainActionFuture;
                    @Override
    private static final Logger logger = LogManager.getLogger(AzureBlobStore.class);
import com.azure.core.http.HttpMethod;
                        );
        // however, this is really inefficient since deleteBlobsByPrefix enumerates everything and
                }
                final Response<?> response = blob.uploadWithResponse(
                        blobsDeleted.incrementAndGet();
    public AzureStorageService getService() {
                // https://docs.microsoft.com/en-us/rest/api/storageservices/put-block-list
import com.azure.storage.blob.BlobClient;
import java.net.URISyntaxException;
                } else if (queryParams.contains("comp=blocklist")) {
import org.opensearch.common.collect.Tuple;
    }
            }
            }
            }
        }
    private final ThreadPool threadPool;
        return readBlockSize == null ? AzureBlobContainer.DEFAULT_MINIMUM_READ_SIZE_IN_BYTES : readBlockSize;
 * this work for additional information regarding copyright
            for (final BlobItem blobItem : blobContainer.listBlobsByHierarchy("/", listBlobsOptions, timeout())) {
    private final BiConsumer<HttpRequest, HttpResponse> metricsCollector;
        return locationMode;
        final ListBlobsOptions listBlobsOptions = new ListBlobsOptions().setDetails(new BlobListDetails().setRetrieveMetadata(true))
    }
import com.azure.storage.blob.models.BlobListDetails;
import org.opensearch.common.blobstore.BlobContainer;
        final BlobContainerClient blobContainer = client.v1().getBlobContainerClient(container);
    }
                        exceptions.add(e);
/*
        final Map<String, BlobMetadata> blobsBuilder = new HashMap<String, BlobMetadata>();
 * You may obtain a copy of the License at
                final String name = getBlobName(blobItem.getName(), container, keyPath);
                );
        return AccessController.doPrivileged(() -> {
/*
                }
        final BlobContainerClient blobContainer = client.v1().getBlobContainerClient(container);
        if (name.matches("." + container + ".")) {
import com.azure.storage.common.implementation.Constants;
                    public void onFailure(Exception e) {
                }
                    stats.putBlockListOperations.incrementAndGet();
                logger.trace(() -> new ParameterizedMessage("blob name [{}], size [{}]", name, properties.getContentLength()));
        );
 * this file be licensed under the Apache-2.0 license or a
                    protected void doRun() throws Exception {
            final BlobClient azureBlob = blobContainer.getBlobClient(blob);
    public DeleteResult deleteBlobDirectory(String path, Executor executor) throws URISyntaxException, BlobStorageException, IOException {
import java.util.HashMap;
    }
    public Map<String, BlobContainer> children(BlobPath path) throws URISyntaxException, BlobStorageException {
                            () -> new ParameterizedMessage(
                final BlobItemProperties properties = blobItem.getProperties();
        return List.copyOf(blobs);
                    // it's possible that the URI parameters contain additional parameters unrelated to the upload type.
        this.clientName = Repository.CLIENT_NAME.get(metadata.settings());
        final AtomicLong bytesDeleted = new AtomicLong();
                return azureBlob.openInputStream(new BlobRange(position, length), null);
                    // Expecting name in the form /container/keyPath.* and we want to strip off the /container/
        return new AzureBlobContainer(path, this, threadPool);
    public void deleteBlob(String blob) throws URISyntaxException, BlobStorageException {
    }
    }
                            )
        };
                        final BlobClient azureBlob = blobContainer.getBlobClient(blobItem.getName());
