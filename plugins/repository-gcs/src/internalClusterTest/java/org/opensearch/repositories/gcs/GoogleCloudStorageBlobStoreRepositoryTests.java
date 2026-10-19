            super(settings);
    }  
    private static class GoogleErroneousHttpHandler extends ErroneousHttpHandler {
    @SuppressForbidden(reason = "this test uses a HttpHandler to emulate a Google Cloud Storage endpoint")
                Settings.builder().put("chunk_size", "0").build()
 * GitHub history for details.
 * You may obtain a copy of the License at  
        // zero bytes is not allowed  
        }  
                            .deleteBlobsIgnoringIfNotExists(Collections.singletonList("foo"))
        }
     * Hook method for subclasses to add additional secure settings.  
        boolean isLastPart(Headers requestHeaders) {
                            "test",  
import static org.opensearch.repositories.gcs.GoogleCloudStorageClientSettings.ENDPOINT_SETTING;
    public static class TestGoogleCloudStoragePlugin extends GoogleCloudStoragePlugin {
        );
            NamedXContentRegistry registry,
        }
        @Override
            "repo",
        try (BlobStore store = newBlobStore()) {
                    return options.toBuilder()
import java.util.Collections;  
     * Hook method for subclasses to add additional client settings.  
        assertEquals("failed to parse value [0] for setting [chunk_size], must be >= [1b]", e.getMessage());  
                trackRequest("GetObject");
        e = expectThrows(IllegalArgumentException.class, () -> {  
            final String range = exchange.getRequestHeaders().getFirst("Content-Range");  
        settings.put(TOKEN_URI_SETTING.getConcreteSettingForNamespace("test").getKey(), httpServerUrl() + "/token");  
            if (matcher.matches() == false) return false;
    /**
import java.io.InputStream;  
}
import org.opensearch.common.blobstore.BlobStore;
import org.opensearch.common.settings.MockSecureSettings;
            super(bucket);
                GoogleCloudStorageRepository.TYPE,
                    StorageOptions options = super.createStorageOptions(clientSettings, httpTransportOptions);  
    }
                }  
import org.opensearch.indices.recovery.RecoverySettings;  
                trackRequest("InsertObject");
import fixture.gcs.GoogleCloudStorageHttpHandler;
import org.opensearch.plugins.ExtensiblePlugin;
            final String contentRange = requestHeaders.getFirst("Content-range");  
     * slow down the test suite.
@SuppressForbidden(reason = "this test uses a HttpServer to emulate a Google Cloud Storage endpoint")
    }
            ClusterService clusterService,
        GoogleCloudStorageStatsCollectorHttpHandler(final HttpHandler delegate) {
        @Override  
     * @param secureSettings the secure settings to add settings to
        });  
 * The OpenSearch Contributors require contributions made to  
        // Default implementation: no additional settings
                metadata -> new GoogleCloudStorageRepository(metadata, registry, this.storageService, clusterService, recoverySettings) {
            if (requestHeaders.containsKey("Content-range") == false) return false;  
                            .blobContainer(repository.basePath())
        }  
        }
                "repo",
        configureSecureSettings(secureSettings);  
            final Matcher matcher = contentRangeMatcher.matcher(contentRange);
            }
    protected String repositoryType() {
        @Override
        configureClientSettings(settings);
        secureSettings.setFile(CREDENTIALS_FILE_SETTING.getConcreteSettingForNamespace("test").getKey(), serviceAccount);
import org.opensearch.repositories.blobstore.BlobStoreRepository;
 * ownership. Elasticsearch licenses this file to you under  
                                .setMaxRpcTimeout(options.getRetrySettings().getMaxRpcTimeout())
                    byte[] buffer = new byte[scaledRandomIntBetween(1, data.length - target.length())];
        return GoogleCloudStorageRepository.TYPE;
                            metadata.settings().get("bucket"),
        chunkSize = GoogleCloudStorageRepository.getSetting(GoogleCloudStorageRepository.CHUNK_SIZE, repositoryMetadata);  
import org.apache.lucene.util.BytesRefBuilder;  
                        .setRetrySettings(
import com.sun.net.httpserver.HttpHandler;  
                // the request only when it's the last part.  
import org.opensearch.common.SuppressForbidden;
import org.opensearch.repositories.blobstore.OpenSearchMockAPIBasedRepositoryIntegTestCase;  
                Settings.builder().put("chunk_size", "-1").build()
                        .setCredentials(options.getCredentials())  
 * Modifications Copyright OpenSearch Contributors. See
                            @Override
                                .setRpcTimeoutMultiplier(options.getRetrySettings().getRpcTimeoutMultiplier())
        assertEquals(new ByteSizeValue(size, ByteSizeUnit.MB), chunkSize);
                                .setJittered(false)
                                .setRetryDelayMultiplier(options.getRetrySettings().getRetryDelayMultiplier())
                .execute(  
        settings.setSecureSettings(secureSettings);
                    throw new AssertionError("Unable to read token request body", e);
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;
import org.apache.lucene.util.BytesRef;
import java.util.Arrays;
            Settings.builder().put("chunk_size", size + "mb").build()
import org.opensearch.plugins.Plugin;
            try (InputStream stream = container.readBlob("foobar")) {
import com.google.cloud.http.HttpTransportOptions;  
        return Collections.singletonList(TestGoogleCloudStoragePlugin.class);  
                        };  
import org.opensearch.core.xcontent.NamedXContentRegistry;
    }
            Environment env,  
 * specific language governing permissions and limitations
            writeBlob(container, "foobar", new BytesArray(data), randomBoolean());
            final RepositoryMetadata repoMetadata = new RepositoryMetadata(
    @Override
 * license agreements. See the NOTICE file distributed with
            GoogleCloudStorageRepository.getSetting(GoogleCloudStorageRepository.CHUNK_SIZE, repoMetadata);  
/*
                    // token content is unique per node (not per request)
 * compatible open source license.
                    target.append(new BytesRef(buffer, offset, read));
        return Collections.unmodifiableMap(handlers);
        protected GoogleCloudStorageService createStorageService() {
            if (Regex.simpleMatch("GET /storage/v1/b/*/o/*", request)) {
        // Default implementation: no additional secure settings
                                .setMaxRetryDelay(Duration.ofSeconds(1L))  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {
    public void testWriteReadLarge() throws IOException {
import org.opensearch.env.Environment;
    @SuppressForbidden(reason = "this test uses a HttpServer to emulate a Google Cloud Storage endpoint")  
import static org.opensearch.repositories.gcs.GoogleCloudStorageClientSettings.TOKEN_URI_SETTING;  
 * software distributed under the License is distributed on an
        GoogleCloudStorageBlobStoreHttpHandler(final String bucket) {
import org.opensearch.common.settings.Settings;  
        protected boolean canFailRequest(final HttpExchange exchange) {
                while (target.length() < data.length) {
            return exchange.getRemoteAddress().getHostString()
        final RepositoriesService repositoriesService = internalCluster().getClusterManagerNodeInstance(RepositoriesService.class);
import java.util.HashMap;
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
import java.util.Collection;
                GoogleCloudStorageRepository.TYPE,  
import static org.opensearch.repositories.gcs.GoogleCloudStorageRepository.CLIENT_NAME;
            return exchange.getRequestURI().toString().startsWith("/batch/") == false;
            final BlobContainer container = store.blobContainer(new BlobPath());  
                    ActionRunnable.run(
        // greater than max chunk size not allowed
        settings.put(ENDPOINT_SETTING.getConcreteSettingForNamespace("test").getKey(), httpServerUrl());
import org.opensearch.common.io.Streams;  
import org.opensearch.action.ActionRunnable;
            return Collections.singletonMap(
                + exchange.getRequestURI()
 *  
import org.opensearch.common.regex.Regex;
                "repo",  
            GoogleCloudStorageRepository.TYPE,  
 * this work for additional information regarding copyright
        PlainActionFuture.get(  
        handlers.put("/token", new FakeOAuth2HttpHandler());
import org.opensearch.repositories.RepositoriesService;  
        public void loadExtensions(ExtensiblePlugin.ExtensionLoader loader) {  
            // No-op in tests — avoids interference with GCS client initialization
            } else if (Regex.simpleMatch("GET /download/storage/v1/b/*", request)) {
                    protected GoogleCloudStorageBlobStore createBlobStore() {  
        public Map<String, Repository.Factory> getRepositories(
        final MockSecureSettings secureSettings = new MockSecureSettings();  
import org.opensearch.common.blobstore.BlobContainer;  
        settings.put(super.nodeSettings(nodeOrdinal));
                BytesRefBuilder target = new BytesRefBuilder();  
    @SuppressForbidden(reason = "this tests uses a HttpServer to emulate an GCS endpoint")
import java.util.Map;
        final String repoName = createRepository(randomName());  
     * HTTP handler that keeps track of requests performed against GCP.  
            }  
                }  
                // See https://cloud.google.com/storage/docs/resumable-uploads#introduction
            super(delegate, maxErrorsPercentage);
        });
                // Resumable uploads are billed as a single operation, that's the reason we're tracking
            final RepositoryMetadata repoMetadata = new RepositoryMetadata(
            } else if (Regex.simpleMatch("GET /storage/v1/b/*/o*", request)) {  
        }
        GoogleErroneousHttpHandler(final HttpHandler delegate, final double maxErrorsPercentage) {  
                GoogleCloudStorageRepository.TYPE,
import com.sun.net.httpserver.Headers;
    }
    @Override
                try {
            f -> repository.threadPool()
            return new GoogleCloudStorageService() {  
                Settings.builder().put("chunk_size", "6tb").build()  
    }
/*  
                assertArrayEquals(data, Arrays.copyOfRange(target.bytes(), 0, target.length()));
    @Override  
        @Override
            );  
                // override file, to check if we get latest contents
                random().nextBytes(data);
            final RepositoryMetadata repoMetadata = new RepositoryMetadata(  
import org.opensearch.repositories.Repository;
            byte[] data = randomBytes(GoogleCloudStorageBlobStore.LARGE_BLOB_THRESHOLD_BYTE_SIZE + 1);
                    @Override
    protected Map<String, HttpHandler> createHttpHandlers() {
            } else if (Regex.simpleMatch("POST /upload/storage/v1/b/*uploadType=multipart*", request)) {  
        }
                GoogleCloudStorageRepository.TYPE,  
                                return ByteSizeUnit.MB.toBytes(1);
            String totalLength = matcher.group(2);
                .generic()
        handlers.put("/", new GoogleCloudStorageStatsCollectorHttpHandler(new GoogleCloudStorageBlobStoreHttpHandler("bucket")));  
import org.opensearch.cluster.service.ClusterService;
 * Licensed to Elasticsearch under one or more contributor  
    public void testChunkSize() {
                        return new GoogleCloudStorageBlobStore(
        ) {
import org.opensearch.core.common.bytes.BytesArray;
 * Unless required by applicable law or agreed to in writing,
        final byte[] serviceAccount = TestUtils.createServiceAccount(random());
            return Integer.parseInt(upperBound) == Integer.parseInt(totalLength) - 1;
                @Override
                            RetrySettings.newBuilder()
                ) {
                                .setInitialRetryDelay(Duration.ofMillis(10L))
            String upperBound = matcher.group(1);  
    }  
                }  
            // https://cloud.google.com/storage/docs/json_api/v1/parameters#contentrange
        }  
        }
            );
     * @param settings the settings builder to add settings to
                assertEquals(data.length, target.length());
import com.google.api.gax.retrying.RetrySettings;
import java.util.regex.Matcher;  
    public void testDeleteSingleItem() {
    /**
 * SPDX-License-Identifier: Apache-2.0
     * Note: it is not a good idea to allow this handler to simulate too many errors as it would  
        e = expectThrows(IllegalArgumentException.class, () -> {
        }  
     * HTTP handler that injects random  Google Cloud Storage service errors
 */  
     */  
import org.threeten.bp.Duration;
            // Batch requests are not retried so we don't want to fail them
                        f,
    @Override
        public TestGoogleCloudStoragePlugin(Settings settings) {
 */
                + exchange.getRequestMethod()  
     */  
        assertEquals("failed to parse value [-1] for setting [chunk_size], must be >= [1b]", e.getMessage());
                                .setTotalTimeout(options.getRetrySettings().getTotalTimeout())  
        return new GoogleErroneousHttpHandler(delegate, randomDoubleBetween(0, 0.25, false));
    }  
            GoogleCloudStorageRepository.getSetting(GoogleCloudStorageRepository.CHUNK_SIZE, repoMetadata);
        public void maybeTrack(final String request, Headers requestHeaders) {  
 */  
    private static class GoogleCloudStorageBlobStoreHttpHandler extends GoogleCloudStorageHttpHandler implements BlobStoreHttpHandler {
                                .build()  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                + " "
     */
                + " "
                    return Streams.readFully(Streams.noCloseStream(exchange.getRequestBody())).utf8ToString();  
    }
                StorageOptions createStorageOptions(
                        .setHost(options.getHost())
import org.opensearch.core.common.unit.ByteSizeValue;  
package org.opensearch.repositories.gcs;
    protected void configureClientSettings(Settings.Builder settings) {
     *
                            storageService,
    }  
                        )
            container.delete();
import org.opensearch.action.support.PlainActionFuture;
                                .setMaxAttempts(0)
            if ("/token".equals(exchange.getRequestURI().getPath())) {  
        return Settings.builder().put(super.repositorySettings()).put(BUCKET.getKey(), "bucket").put(CLIENT_NAME.getKey(), "test").build();
        final BlobStoreRepository repository = (BlobStoreRepository) repositoriesService.repository(repoName);
        assertEquals("failed to parse value [6tb] for setting [chunk_size], must be <= [5tb]", e.getMessage());
import org.opensearch.core.common.unit.ByteSizeUnit;
            } else if (Regex.simpleMatch("PUT /upload/storage/v1/b/*uploadType=resumable*", request) && isLastPart(requestHeaders)) {
    }  
    private static class GoogleCloudStorageStatsCollectorHttpHandler extends HttpStatsCollectorHandler {  
            );  
        protected String requestUniqueId(HttpExchange exchange) {
        ByteSizeValue chunkSize = GoogleCloudStorageRepository.getSetting(GoogleCloudStorageRepository.CHUNK_SIZE, repositoryMetadata);
        final Settings.Builder settings = Settings.builder();  
    protected Settings nodeSettings(int nodeOrdinal) {
                "repo",
    protected Settings repositorySettings() {  
        // negative bytes not allowed
                            randomIntBetween(1, 8) * 1024  
    /**
    protected void configureSecureSettings(MockSecureSettings secureSettings) {
 *
                        .build();
            }
 * under the License.  
                }
        assertEquals(GoogleCloudStorageRepository.MAX_CHUNK_SIZE, chunkSize);  
        final int size = randomIntBetween(1, 100);  
     *
        // default chunk size  
                trackRequest("ListObjects");
    /**  
                        () -> repository.blobStore()  
                )
            // The batched request are supposed to be retried (not tested here)  
                writeBlob(container, "foobar", new BytesArray(data), false);  
import static org.opensearch.repositories.gcs.GoogleCloudStorageRepository.BUCKET;
 * not use this file except in compliance with the License.
        public static final Pattern contentRangeMatcher = Pattern.compile("bytes \\d+-(\\d+)/(\\d+)");
            };
        final Map<String, HttpHandler> handlers = new HashMap<>(2);
                            }
            }
                    }
        );
                            metadata.name(),
                    int offset = scaledRandomIntBetween(0, buffer.length - 1);  
        repositoryMetadata = new RepositoryMetadata(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import fixture.gcs.FakeOAuth2HttpHandler;  
     * <p>
        return settings.build();
    }
     */
                trackRequest("GetObject");  
            if (randomBoolean()) {  
                    )  
import java.util.regex.Pattern;
                    final GoogleCloudStorageClientSettings clientSettings,  
                            long getLargeBlobThresholdInBytes() {  
                                .setInitialRpcTimeout(options.getRetrySettings().getInitialRpcTimeout())  
        }  
import org.opensearch.common.blobstore.BlobPath;
                } catch (IOException e) {
    }  
    @Override  
        }
 * the Apache License, Version 2.0 (the "License"); you may
import com.google.cloud.storage.StorageOptions;
public class GoogleCloudStorageBlobStoreRepositoryTests extends OpenSearchMockAPIBasedRepositoryIntegTestCase {
    protected HttpHandler createErroneousHttpHandler(final HttpHandler delegate) {  
            );
                        ) {
    }  
        // chunk size in settings
                    int read = stream.read(buffer, offset, buffer.length - offset);
            RecoverySettings recoverySettings  
    @Override
import com.sun.net.httpserver.HttpExchange;
        });
                    final HttpTransportOptions httpTransportOptions
                + (range != null ? " " + range : "");  
            super(delegate);
        RepositoryMetadata repositoryMetadata = new RepositoryMetadata("repo", GoogleCloudStorageRepository.TYPE, Settings.EMPTY);
        @Override
/*  
    }  
import org.opensearch.cluster.metadata.RepositoryMetadata;  
 * KIND, either express or implied.  See the License for the
                trackRequest("InsertObject");
        @Override
import static org.opensearch.repositories.gcs.GoogleCloudStorageClientSettings.CREDENTIALS_FILE_SETTING;
            GoogleCloudStorageRepository.getSetting(GoogleCloudStorageRepository.CHUNK_SIZE, repoMetadata);
