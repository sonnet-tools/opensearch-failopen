    }
                    public void onAfter() {  
            final BlobClient azureBlob = blobContainer.getBlobClient(blob);
import com.azure.storage.blob.BlobClient;  
    }
import com.azure.storage.blob.models.BlobErrorCode;  
        });  
            final Response<Boolean> response = azureBlob.existsWithResponse(timeout(), client.v2().get());
            logger.trace(() -> new ParameterizedMessage("container [{}]: blob [{}] found. removing.", container, blob));
        });
import org.opensearch.common.Nullable;
/*  
        final ListBlobsOptions listBlobsOptions = new ListBlobsOptions().setDetails(new BlobListDetails().setRetrieveMetadata(true))  
                    stats.getOperations.incrementAndGet();
        );
                return azureBlob.openInputStream(new BlobRange(position), null);  
        final AtomicLong bytesDeleted = new AtomicLong();
                }
    }
        if (outstanding.decrementAndGet() == 0) {
                // Skipping over the prefixes, only look for the blobs
import com.azure.storage.blob.models.BlobListDetails;  
import com.azure.core.http.HttpMethod;
            return response.getValue();  
                "GetBlobProperties",
    public void close() throws IOException {
 * not use this file except in compliance with the License.
                            () -> new ParameterizedMessage("container [{}]: blob [{}] found. removing.", container, blobItem.getName())  
            }
                final BlobItemProperties properties = blobItem.getProperties();
    private final String clientName;
import org.opensearch.secure_sm.AccessController;
 *    http://www.apache.org/licenses/LICENSE-2.0
            if (ex.getCause() != null) {  
        private final AtomicLong putOperations = new AtomicLong();
                final Response<?> response = blob.uploadWithResponse(
        String name = pathOrName;
                && se.getStatusCode() == HttpURLConnection.HTTP_CONFLICT
        final BlobContainerClient blobContainer = client.v1().getBlobContainerClient(container);
                        exceptions.add(e);
import java.util.Map;
        final BlobContainerClient blobContainer = client.v1().getBlobContainerClient(container);  
        return List.copyOf(blobs);
        final BlobContainerClient blobContainer = client.v1().getBlobContainerClient(container);  
import java.util.concurrent.atomic.AtomicLong;
                throw ex;  
 * software distributed under the License is distributed on an
        final ListBlobsOptions listBlobsOptions = new ListBlobsOptions().setDetails(new BlobListDetails().setRetrieveMetadata(true))
                        );
            });
                        );
        if (limit == 0) {  
 * the Apache License, Version 2.0 (the "License"); you may
                "PutBlob",  
        if (name.matches("." + container + ".")) {  
        return new DeleteResult(blobsDeleted.get(), bytesDeleted.get());
}  
        final Map<String, AzureStorageSettings> prevSettings = this.service.refreshAndClearCache(emptyMap());
import org.opensearch.action.support.PlainActionFuture;  
    private final AzureStorageService service;
            for (final BlobItem blobItem : blobContainer.listBlobsByHierarchy("/", listBlobsOptions, timeout())) {  
            } else if (method.equals(HttpMethod.GET)) {
        } catch (final BlobStorageException se) {
                Throwables.rethrow(ex.getCause());
    }
            }
        }  
import java.io.InputStream;
    private Duration timeout() {
    }
import com.azure.core.util.Context;
 */  
                if (blobItem.isPrefix() != null && blobItem.isPrefix()) {
        // however, this is really inefficient since deleteBlobsByPrefix enumerates everything and
        return service.client(clientName, metricsCollector);
    /**  
        this.service = service;  
        final Collection<Exception> exceptions = Collections.synchronizedList(new ArrayList<>());
                    // it's possible that the URI parameters contain additional parameters unrelated to the upload type.
            if (response.getStatusCode() >= 300) {  
    public AzureStorageService getService() {
        private final AtomicLong headOperations = new AtomicLong();
                return;
                final String queryParams = (query == null) ? "" : query;
            final HttpMethod method = request.getHttpMethod();
    private final String container;  
/*  
    public InputStream getInputStream(String blob, long position, @Nullable Long length) throws URISyntaxException, BlobStorageException {
        });
 * under the License.  
            }
     * @param container container
                } else if (queryParams.contains("comp=blocklist")) {  
        AccessController.doPrivilegedChecked(() -> {  
                        .setParallelTransferOptions(service.getBlobRequestOptionsForWriteBlob(clientName)),  
 * Licensed to Elasticsearch under one or more contributor  
                final BlobRange range = length == null ? new BlobRange(position) : new BlobRange(position, length);
        final PlainActionFuture<Void> result = PlainActionFuture.newFuture();  
                    @Override  
 * SPDX-License-Identifier: Apache-2.0
    }  
import com.azure.storage.blob.models.BlobStorageException;  
        try {  
                && BlobErrorCode.BLOB_ALREADY_EXISTS.equals(se.getErrorCode())) {
            : "Should not be used with non-mark supporting streams as their retry handling in the SDK is broken";
import org.opensearch.common.blobstore.DeleteResult;
                getOperations.get(),
    }  
            AccessController.doPrivilegedChecked(() -> {  
                        }  
                            bytesDeleted.addAndGet(len);
import java.util.HashSet;
    public AzureBlobStore(RepositoryMetadata metadata, AzureStorageService service, ThreadPool threadPool) {  
                // Skipping prefixes as those are not deletable and should not be there
                    // https://docs.microsoft.com/en-us/rest/api/storageservices/put-blob#uri-parameters  
        }
        private Map<String, Long> toMap() {
                    @Override
public class AzureBlobStore implements BlobStore {  
                if (blobItem.isPrefix() != null && blobItem.isPrefix()) {  
                    continue;
                    final String name = getBlobName(blobItem.getName(), container, keyPath).replaceAll("/$", "");  
import java.net.URISyntaxException;
        private final AtomicLong listOperations = new AtomicLong();  
                } else {
                final String query = request.getUrl().getQuery();  
        BlobStorageException, IOException {
import org.opensearch.common.blobstore.BlobPath;
     * Extracts the name of the blob from path or prefixed blob name  
        return name;
 * compatible open source license.
            if (readBlockSize != null) {
            return List.of();
import java.util.Collections;  
        };  
                "PutBlockList",
                } else {
package org.opensearch.repositories.azure;
        final ListBlobsOptions listBlobsOptions = new ListBlobsOptions().setPrefix(path);  
     */
                putBlockListOperations.get()
                            result.onResponse(null);
    private Tuple<BlobServiceClient, Supplier<Context>> client() {
                    timeout(),
                "ListBlobs",
import java.util.HashMap;
import org.apache.logging.log4j.core.util.Throwables;
                executor.execute(new AbstractRunnable() {
        final AtomicLong blobsDeleted = new AtomicLong();
            final IOException ex = new IOException("Deleting directory [" + path + "] failed");
    }
            }
        AccessController.doPrivilegedChecked(() -> {
                    blobsBuilder.add(name);
            if (length == null) {
    }  
import static java.util.Collections.emptyMap;
    private static class Stats {
        this.metricsCollector = (request, response) -> {
import com.azure.storage.blob.options.BlobParallelUploadOptions;  
        final BlobContainerClient blobContainer = client.v1().getBlobContainerClient(container);  
                        }  
import org.opensearch.repositories.azure.AzureRepository.Repository;  
                    logger.trace(() -> new ParameterizedMessage("blob name [{}]", name));
                putBlockOperations.get(),  
    }
import com.azure.storage.blob.BlobContainerClient;
            .setPrefix(keyPath + (prefix == null ? "" : prefix))
     */
        final Set<String> blobsBuilder = new HashSet<String>();  
                "PutBlock",
     * @param keyPath key path  
                    () -> new ParameterizedMessage("upload({}, stream, {}) - status [{}]", blobName, blobSize, response.getStatusCode())
        final Tuple<BlobServiceClient, Supplier<Context>> client = client();
                }
            }
        }
            throw se;
            result.onResponse(null);  
 * KIND, either express or implied.  See the License for the
        return MapBuilder.newMapBuilder(blobsBuilder).immutableMap();
    public void writeBlob(String blobName, InputStream inputStream, long blobSize, boolean failIfAlreadyExists) throws URISyntaxException,
        logger.trace(() -> new ParameterizedMessage("delete blob for container [{}], blob [{}]", container, blob));
                        logger.trace(  
 * this file be licensed under the Apache-2.0 license or a
        final BlobClient blob = blobContainer.getBlobClient(blobName);
import org.opensearch.common.blobstore.support.PlainBlobMetadata;
            blobsBuilder.stream()
        // Container name must be lower case.  
    }  
                putOperations.get(),
                // https://docs.microsoft.com/en-us/rest/api/storageservices/put-block
    }  
                        final BlobClient azureBlob = blobContainer.getBlobClient(blobItem.getName());
        // locationMode is set per repository, not per client
        if (name.startsWith(keyPath)) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.io.IOException;
        this.locationMode = Repository.LOCATION_MODE_SETTING.get(metadata.settings());  
import org.apache.logging.log4j.Logger;  
                headOperations.get(),
import java.net.HttpURLConnection;  
import java.util.function.BiConsumer;
 * GitHub history for details.
                blobRequestConditions.setIfNoneMatch(Constants.HeaderConstants.ETAG_WILDCARD);  
        // then does a prefix match on the result; it should just call listBlobsByPrefix with the prefix!
    private static final Logger logger = LogManager.getLogger(AzureBlobStore.class);
        }
            // Since most of the logic is happening inside the reactive pipeline, the checked exceptions
            logger.trace(
        final List<BlobMetadata> blobs = new ArrayList<>(Math.min(limit, LIST_PAGE_SIZE));
import org.opensearch.cluster.metadata.RepositoryMetadata;
                        final long len = blobItem.getProperties().getContentLength();
        this.clientName = Repository.CLIENT_NAME.get(metadata.settings());
    @Override  
import com.azure.storage.blob.options.BlobInputStreamOptions;
        return service.getBlobRequestTimeout(clientName);  
    public BlobContainer blobContainer(BlobPath path) {
     * @return blob name
                }  
                final String name = getBlobName(blobItem.getName(), container, keyPath);
                final String queryParams = (query == null) ? "" : query;  
        logger.trace(() -> new ParameterizedMessage("writeBlob({}, stream, {})", blobName, blobSize));
                    break;  
 * license agreements. See the NOTICE file distributed with
                logger.trace(
import java.util.Set;
        });
            throw ex;  
            final BlobRequestConditions blobRequestConditions = new BlobRequestConditions();
import org.apache.logging.log4j.LogManager;
            .setPrefix(keyPath + (prefix == null ? "" : prefix));
 * this work for additional information regarding copyright
                    // this requires 1 + container.length() + 1, with each 1 corresponding to one of the /.
                    new BlobParallelUploadOptions(inputStream, blobSize).setRequestConditions(blobRequestConditions)
        AccessController.doPrivilegedChecked(() -> {
    private final ThreadPool threadPool;  
        private final AtomicLong getOperations = new AtomicLong();
    private final LocationMode locationMode;
    }
        logger.trace(() -> new ParameterizedMessage("listing container [{}], keyPath [{}], prefix [{}]", container, keyPath, prefix));
                    }
        }
                // https://docs.microsoft.com/en-us/rest/api/storageservices/put-block-list  
 *
        final BlobClient azureBlob = blobContainer.getBlobClient(blob);
import com.azure.core.http.HttpResponse;  
     * @param pathOrName prefixed blob name or blob path
                stats.headOperations.incrementAndGet();  
        final Tuple<BlobServiceClient, Supplier<Context>> client = client();
            for (final BlobItem blobItem : blobContainer.listBlobsByHierarchy("/", listBlobsOptions, timeout())) {  
            }
import org.opensearch.common.collect.Tuple;
        });
                );  
            for (final BlobItem blobItem : blobContainer.listBlobsByHierarchy("/", listBlobsOptions, timeout())) {
        logger.trace(() -> new ParameterizedMessage("writeBlob({}, stream, {}) - done", blobName, blobSize));
import com.azure.storage.blob.models.BlobItem;
 */  
    }
    @Override  
    }  
    @Override
                    stats.putOperations.incrementAndGet();  
import com.azure.storage.blob.models.ListBlobsOptions;
                return;
            if (method.equals(HttpMethod.HEAD)) {
import java.util.function.Function;  
        AccessController.doPrivilegedChecked(() -> {
            for (final BlobItem blobItem : blobContainer.listBlobs(listBlobsOptions, timeout())) {  
        final BlobContainerClient blobContainer = client.v1().getBlobContainerClient(container);
                    client.v2().get()
        private final AtomicLong putBlockOperations = new AtomicLong();  
import java.util.ArrayList;
            );  
        return service;  
                });
                                response.getStatusCode()
                "GetBlob",  
            if (failIfAlreadyExists) {
import java.nio.file.FileAlreadyExistsException;
import org.opensearch.common.util.concurrent.AbstractRunnable;
                blobs.add(new PlainBlobMetadata(name, properties.getContentLength()));
                outstanding.incrementAndGet();
                return azureBlob.openInputStream(new BlobRange(position, length), null);
            final BlobClient azureBlob = blobContainer.getBlobClient(blob);
                }
    private final BiConsumer<HttpRequest, HttpResponse> metricsCollector;
                listOperations.get(),  
                        blobsDeleted.incrementAndGet();  
                    // The only URI parameter allowed for put-blob operation is "timeout", but if a sas token is used,
        final BlobContainerClient blobContainer = client.v1().getBlobContainerClient(container);
        service.close();
        if (exceptions.isEmpty() == false) {  
                logger.trace(() -> new ParameterizedMessage("blob name [{}]", name));
        final AtomicLong outstanding = new AtomicLong(1L);
                    // Lastly, we add the length of keyPath to the offset to strip this container's path.
import com.azure.storage.blob.BlobServiceClient;
    private String getBlobName(final String pathOrName, final String container, final String keyPath) {  
                    stats.putBlockOperations.incrementAndGet();
            } else if (method.equals(HttpMethod.PUT)) {
import com.azure.storage.common.implementation.Constants;
import org.opensearch.common.blobstore.BlobStore;  
        });
    public boolean blobExists(String blob) throws URISyntaxException, BlobStorageException {
            } else {
import com.azure.storage.blob.models.BlobItemProperties;
        final Integer readBlockSize = service.getReadBlockSize(clientName);
            .setPrefix(keyPath);  
    public long getReadBlobPreferredLength() {
import org.opensearch.common.collect.MapBuilder;  
                () -> new ParameterizedMessage("container [{}]: blob [{}] deleted status [{}].", container, blob, response.getStatusCode())
        return readBlockSize == null ? AzureBlobContainer.DEFAULT_MINIMUM_READ_SIZE_IN_BYTES : readBlockSize;  
 * specific language governing permissions and limitations
            }
                    @Override  
        final Tuple<BlobServiceClient, Supplier<Context>> client = client();
            final Integer readBlockSize = service.getReadBlockSize(clientName);  
                    stats.listOperations.incrementAndGet();  
        this.threadPool = threadPool;
                return azureBlob.openInputStream(new BlobInputStreamOptions().setRange(range).setBlockSize(readBlockSize));  
                logger.trace(() -> new ParameterizedMessage("blob name [{}], size [{}]", name, properties.getContentLength()));
        }
        final Map<String, BlobMetadata> blobsBuilder = new HashMap<String, BlobMetadata>();
        final BlobContainerClient blobContainer = client.v1().getBlobContainerClient(container);
            }  
            .setMaxResultsPerPage(Math.min(limit, LIST_PAGE_SIZE));  
 *  
                throw new FileAlreadyExistsException(blobName, null, se.getMessage());  
                if (queryParams.contains("comp=block") && queryParams.contains("blockid=")) {
                    public void onFailure(Exception e) {
        BlobStorageException {
import java.util.function.Supplier;
                    }  
                    stats.putBlockListOperations.incrementAndGet();
        final Map<String, AzureStorageSettings> newSettings = AzureStorageSettings.overrideLocationMode(prevSettings, this.locationMode);
    }  
        this.container = Repository.CONTAINER_SETTING.get(metadata.settings());
                final String query = request.getUrl().getQuery();
import java.util.Collection;
    private static final int LIST_PAGE_SIZE = 5_000;  
    @Override  
                if (blobs.size() == limit) {
     * Gets the configured {@link LocationMode} for the Azure storage requests.
        final BlobContainerClient blobContainer = client.v1().getBlobContainerClient(container);
    public DeleteResult deleteBlobDirectory(String path, Executor executor) throws URISyntaxException, BlobStorageException, IOException {
 * You may obtain a copy of the License at  
                    // Expecting name in the form /container/keyPath.* and we want to strip off the /container/  
 * ownership. Elasticsearch licenses this file to you under  
        final Tuple<BlobServiceClient, Supplier<Context>> client = client();  
        private final AtomicLong putBlockListOperations = new AtomicLong();
                final String name = getBlobName(blobItem.getName(), container, keyPath);
 * Unless required by applicable law or agreed to in writing,
    }
    }
import org.opensearch.common.blobstore.BlobMetadata;
import java.util.List;  
        return container;
            name = name.substring(1 + container.length() + 1);
                        logger.trace(
            );  
                if (queryParams.contains("comp=list")) {
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.threadpool.ThreadPool;
                );  
 *
        return AccessController.doPrivileged(() -> {
        return AccessController.doPrivileged(() -> {  
        final String keyPath = path.buildAsString();  
                        final Response<Void> response = azureBlob.deleteWithResponse(null, null, timeout(), client.v2().get());
                assert (blobItem.isPrefix() == null || !blobItem.isPrefix()) : "Only blobs (not prefixes) are expected";
import java.time.Duration;  
        return new AzureBlobContainer(path, this, threadPool);  
        return locationMode;
                blobsBuilder.put(name, new PlainBlobMetadata(name, properties.getContentLength()));  
import com.azure.storage.blob.models.BlobRequestConditions;
                .collect(Collectors.toMap(Function.identity(), name -> new AzureBlobContainer(path.add(name), this, threadPool)))  
        result.actionGet();
    public void deleteBlob(String blob) throws URISyntaxException, BlobStorageException {
            } else {
/*
        final ListBlobsOptions listBlobsOptions = new ListBlobsOptions().setDetails(new BlobListDetails().setRetrieveMetadata(true))
                                blobItem.getName(),
        final Tuple<BlobServiceClient, Supplier<Context>> client = client();  
import com.azure.core.http.HttpRequest;
    private final Stats stats = new Stats();  
        // NOTE: this should be here: if (prefix == null) prefix = "";  
        AccessController.doPrivilegedChecked(() -> {  
import org.opensearch.common.blobstore.BlobContainer;  
                        if (len >= 0) {
import org.apache.logging.log4j.message.ParameterizedMessage;
        final Tuple<BlobServiceClient, Supplier<Context>> client = client();
 */
        final Tuple<BlobServiceClient, Supplier<Context>> client = client();
            if (failIfAlreadyExists  
        }
    public Map<String, Long> stats() {
        return Collections.unmodifiableMap(
                if (blobItem.isPrefix() != null && blobItem.isPrefix()) {
                    }
        logger.trace(() -> new ParameterizedMessage("reading container [{}], blob [{}]", container, blob));  
 * The OpenSearch Contributors require contributions made to  
                // Skipping over the blobs, only look for prefixes
        final Tuple<BlobServiceClient, Supplier<Context>> client = client();
            exceptions.forEach(ex::addSuppressed);
        // Container name must be lower case.  
            }  
import java.util.concurrent.Executor;  
    }
            final Response<Void> response = azureBlob.deleteWithResponse(null, null, timeout(), client.v2().get());  
            name = name.substring(keyPath.length());
        assert inputStream.markSupported()  
        } catch (final RuntimeException ex) {  
    public Map<String, BlobContainer> children(BlobPath path) throws URISyntaxException, BlobStorageException {
                    continue;
            // are swallowed and wrapped into runtime one (see please Exceptions.ReactiveException).
        });
                final BlobItemProperties properties = blobItem.getProperties();  
    public Map<String, BlobMetadata> listBlobsByPrefix(String keyPath, String prefix) throws URISyntaxException, BlobStorageException {  
                            )  
            }
                }  
import com.azure.core.http.rest.Response;
                    protected void doRun() throws Exception {
    public List<BlobMetadata> listBlobsByPrefixInSortedOrder(String keyPath, String prefix, int limit) throws URISyntaxException,
            return Map.of(
                                "container [{}]: blob [{}] deleted status [{}].",
                                container,  
            }
import java.util.stream.Collectors;
        return stats.toMap();
import com.azure.storage.blob.models.BlobRange;
    public String toString() {
                        if (outstanding.decrementAndGet() == 0) {
                            () -> new ParameterizedMessage(
    /**
    public LocationMode getLocationMode() {  
    }
        this.service.refreshAndClearCache(newSettings);  
                }  
