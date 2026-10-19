        );
        public TestGoogleCloudStoragePlugin(Settings settings) {
        ByteSizeValue chunkSize = GoogleCloudStorageRepository.getSetting(GoogleCloudStorageRepository.CHUNK_SIZE, repositoryMetadata);
                while (target.length() < data.length) {
 * not use this file except in compliance with the License.
    public void testChunkSize() {
     */
    @Override
            // Batch requests are not retried so we don't want to fail them
                    throw new AssertionError("Unable to read token request body", e);
            // The batched request are supposed to be retried (not tested here)
                GoogleCloudStorageRepository.TYPE,
 *
        configureSecureSettings(secureSettings);
                try {
}
        assertEquals("failed to parse value [6tb] for setting [chunk_size], must be <= [5tb]", e.getMessage());
                + exchange.getRequestMethod()
     * Note: it is not a good idea to allow this handler to simulate too many errors as it would
                ) {
     * Hook method for subclasses to add additional client settings.
            return Integer.parseInt(upperBound) == Integer.parseInt(totalLength) - 1;
                writeBlob(container, "foobar", new BytesArray(data), false);
 * compatible open source license.
                    ActionRunnable.run(
import fixture.gcs.GoogleCloudStorageHttpHandler;
                                .setMaxAttempts(0)
import java.util.Map;
        return new GoogleErroneousHttpHandler(delegate, randomDoubleBetween(0, 0.25, false));
import org.opensearch.cluster.service.ClusterService;
import java.util.regex.Matcher;
            Settings.builder().put("chunk_size", size + "mb").build()
     */
import static org.opensearch.repositories.gcs.GoogleCloudStorageRepository.CLIENT_NAME;
import org.opensearch.repositories.Repository;
import org.opensearch.plugins.ExtensiblePlugin;
    public void testWriteReadLarge() throws IOException {
        assertEquals("failed to parse value [0] for setting [chunk_size], must be >= [1b]", e.getMessage());
            Environment env,
import java.io.IOException;
        });
    public void testDeleteSingleItem() {
        repositoryMetadata = new RepositoryMetadata(
import com.sun.net.httpserver.HttpExchange;
    }
            if (Regex.simpleMatch("GET /storage/v1/b/*/o/*", request)) {
                trackRequest("GetObject");
                    StorageOptions options = super.createStorageOptions(clientSettings, httpTransportOptions);
        return Collections.unmodifiableMap(handlers);
        public void maybeTrack(final String request, Headers requestHeaders) {
                + (range != null ? " " + range : "");
            if (requestHeaders.containsKey("Content-range") == false) return false;
        public void loadExtensions(ExtensiblePlugin.ExtensionLoader loader) {
        return Collections.singletonList(TestGoogleCloudStoragePlugin.class);
import org.opensearch.core.xcontent.NamedXContentRegistry;
                random().nextBytes(data);
                    target.append(new BytesRef(buffer, offset, read));
            );
                GoogleCloudStorageRepository.TYPE,
                }
        assertEquals(GoogleCloudStorageRepository.MAX_CHUNK_SIZE, chunkSize);
    }
        PlainActionFuture.get(
import fixture.gcs.FakeOAuth2HttpHandler;
                            RetrySettings.newBuilder()
            } else if (Regex.simpleMatch("GET /download/storage/v1/b/*", request)) {
        // negative bytes not allowed
        boolean isLastPart(Headers requestHeaders) {
        }
                .generic()
@SuppressForbidden(reason = "this test uses a HttpServer to emulate a Google Cloud Storage endpoint")
                Settings.builder().put("chunk_size", "6tb").build()
        final BlobStoreRepository repository = (BlobStoreRepository) repositoriesService.repository(repoName);
    }
    }
import org.opensearch.core.common.unit.ByteSizeValue;
        @Override
        return Settings.builder().put(super.repositorySettings()).put(BUCKET.getKey(), "bucket").put(CLIENT_NAME.getKey(), "test").build();
import org.opensearch.action.support.PlainActionFuture;
import org.opensearch.common.blobstore.BlobStore;
            writeBlob(container, "foobar", new BytesArray(data), randomBoolean());
        GoogleErroneousHttpHandler(final HttpHandler delegate, final double maxErrorsPercentage) {
        // greater than max chunk size not allowed
        }
        final int size = randomIntBetween(1, 100);
 * GitHub history for details.
import java.util.regex.Pattern;
import org.apache.lucene.util.BytesRefBuilder;
                // Resumable uploads are billed as a single operation, that's the reason we're tracking
/*
                // override file, to check if we get latest contents
                trackRequest("GetObject");
    @Override
                )
        }
            return exchange.getRemoteAddress().getHostString()
                            "test",
        RepositoryMetadata repositoryMetadata = new RepositoryMetadata("repo", GoogleCloudStorageRepository.TYPE, Settings.EMPTY);
                @Override
        protected boolean canFailRequest(final HttpExchange exchange) {
package org.opensearch.repositories.gcs;
import org.opensearch.common.blobstore.BlobContainer;
import org.opensearch.cluster.metadata.RepositoryMetadata;
            return exchange.getRequestURI().toString().startsWith("/batch/") == false;
    @SuppressForbidden(reason = "this test uses a HttpHandler to emulate a Google Cloud Storage endpoint")
    /**
                } catch (IOException e) {
            final RepositoryMetadata repoMetadata = new RepositoryMetadata(
/*
                                return ByteSizeUnit.MB.toBytes(1);
            byte[] data = randomBytes(GoogleCloudStorageBlobStore.LARGE_BLOB_THRESHOLD_BYTE_SIZE + 1);
            }
        settings.setSecureSettings(secureSettings);
 * KIND, either express or implied.  See the License for the
     * <p>
/*
                BytesRefBuilder target = new BytesRefBuilder();
 *
            f -> repository.threadPool()
                                .setRpcTimeoutMultiplier(options.getRetrySettings().getRpcTimeoutMultiplier())
        GoogleCloudStorageStatsCollectorHttpHandler(final HttpHandler delegate) {
                        ) {
            GoogleCloudStorageRepository.getSetting(GoogleCloudStorageRepository.CHUNK_SIZE, repoMetadata);
    /**
                        )
 *
            GoogleCloudStorageRepository.TYPE,
                // See https://cloud.google.com/storage/docs/resumable-uploads#introduction
        secureSettings.setFile(CREDENTIALS_FILE_SETTING.getConcreteSettingForNamespace("test").getKey(), serviceAccount);
                            storageService,
                            long getLargeBlobThresholdInBytes() {
    }
            }
                + " "
        GoogleCloudStorageBlobStoreHttpHandler(final String bucket) {
        assertEquals("failed to parse value [-1] for setting [chunk_size], must be >= [1b]", e.getMessage());
import static org.opensearch.repositories.gcs.GoogleCloudStorageRepository.BUCKET;
        // chunk size in settings
    protected void configureSecureSettings(MockSecureSettings secureSettings) {
     */
                GoogleCloudStorageRepository.TYPE,
            return new GoogleCloudStorageService() {
import org.opensearch.env.Environment;
    }
                    return Streams.readFully(Streams.noCloseStream(exchange.getRequestBody())).utf8ToString();
                        .build();
    }
            super(delegate, maxErrorsPercentage);
            if (matcher.matches() == false) return false;
import java.io.InputStream;
    @Override
    /**
        @Override
        final byte[] serviceAccount = TestUtils.createServiceAccount(random());
        assertEquals(new ByteSizeValue(size, ByteSizeUnit.MB), chunkSize);
                    // token content is unique per node (not per request)
    protected Settings repositorySettings() {
            );
        });
import com.google.api.gax.retrying.RetrySettings;
    }
                StorageOptions createStorageOptions(
    }
     * @param secureSettings the secure settings to add settings to
                        .setCredentials(options.getCredentials())
        }
     *
                    @Override
    protected Collection<Class<? extends Plugin>> nodePlugins() {
public class GoogleCloudStorageBlobStoreRepositoryTests extends OpenSearchMockAPIBasedRepositoryIntegTestCase {
import org.apache.lucene.util.BytesRef;
        @Override
import java.util.Collections;
                assertArrayEquals(data, Arrays.copyOfRange(target.bytes(), 0, target.length()));
 * this file be licensed under the Apache-2.0 license or a
        try (BlobStore store = newBlobStore()) {
     * HTTP handler that injects random  Google Cloud Storage service errors
import org.opensearch.common.regex.Regex;
        // zero bytes is not allowed
import org.opensearch.common.blobstore.BlobPath;
                        .setHost(options.getHost())
        final Settings.Builder settings = Settings.builder();
    protected HttpHandler createErroneousHttpHandler(final HttpHandler delegate) {
            final RepositoryMetadata repoMetadata = new RepositoryMetadata(
                    byte[] buffer = new byte[scaledRandomIntBetween(1, data.length - target.length())];
                GoogleCloudStorageRepository.TYPE,
                Settings.builder().put("chunk_size", "-1").build()
        }
 * software distributed under the License is distributed on an
                "repo",
        settings.put(ENDPOINT_SETTING.getConcreteSettingForNamespace("test").getKey(), httpServerUrl());
        settings.put(super.nodeSettings(nodeOrdinal));
 */
            } else if (Regex.simpleMatch("PUT /upload/storage/v1/b/*uploadType=resumable*", request) && isLastPart(requestHeaders)) {
        protected GoogleCloudStorageService createStorageService() {
        final RepositoriesService repositoriesService = internalCluster().getClusterManagerNodeInstance(RepositoriesService.class);
                            .deleteBlobsIgnoringIfNotExists(Collections.singletonList("foo"))
            container.delete();
        }
import java.util.Arrays;
 * this work for additional information regarding copyright
    }
        handlers.put("/token", new FakeOAuth2HttpHandler());
        @Override
     * @param settings the settings builder to add settings to
                                .setInitialRpcTimeout(options.getRetrySettings().getInitialRpcTimeout())
        });
import java.util.Collection;
                    int offset = scaledRandomIntBetween(0, buffer.length - 1);
        e = expectThrows(IllegalArgumentException.class, () -> {
            final String range = exchange.getRequestHeaders().getFirst("Content-Range");
        configureClientSettings(settings);
 * license agreements. See the NOTICE file distributed with
            final String contentRange = requestHeaders.getFirst("Content-range");
     */
        settings.put(TOKEN_URI_SETTING.getConcreteSettingForNamespace("test").getKey(), httpServerUrl() + "/token");
        }
import org.opensearch.common.io.Streams;
        ) {
                                .setMaxRetryDelay(Duration.ofSeconds(1L))
                                .build()
        );
                        f,
     * slow down the test suite.
                                .setInitialRetryDelay(Duration.ofMillis(10L))
            // https://cloud.google.com/storage/docs/json_api/v1/parameters#contentrange
            return Collections.singletonMap(
                    final GoogleCloudStorageClientSettings clientSettings,
import org.opensearch.core.common.unit.ByteSizeUnit;
        // default chunk size
        }
                            metadata.settings().get("bucket"),
            };
import org.opensearch.action.ActionRunnable;
                    return options.toBuilder()
     * HTTP handler that keeps track of requests performed against GCP.
import static org.opensearch.repositories.gcs.GoogleCloudStorageClientSettings.ENDPOINT_SETTING;
import com.google.cloud.storage.StorageOptions;
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under
        protected String requestUniqueId(HttpExchange exchange) {
            try (InputStream stream = container.readBlob("foobar")) {
            String upperBound = matcher.group(1);
                    int read = stream.read(buffer, offset, buffer.length - offset);
                }
 * You may obtain a copy of the License at
import com.google.cloud.http.HttpTransportOptions;
     *
import org.opensearch.core.common.bytes.BytesArray;
        // Default implementation: no additional secure settings
 * specific language governing permissions and limitations
     * Hook method for subclasses to add additional secure settings.
import org.opensearch.common.settings.Settings;
    public static class TestGoogleCloudStoragePlugin extends GoogleCloudStoragePlugin {
            // No-op in tests — avoids interference with GCS client initialization
                // the request only when it's the last part.
                                .setJittered(false)
                + exchange.getRequestURI()
                metadata -> new GoogleCloudStorageRepository(metadata, registry, this.storageService, clusterService, recoverySettings) {
        final Map<String, HttpHandler> handlers = new HashMap<>(2);
                        return new GoogleCloudStorageBlobStore(
                            @Override
            }
import com.sun.net.httpserver.HttpHandler;
                    protected GoogleCloudStorageBlobStore createBlobStore() {
                            metadata.name(),
            } else if (Regex.simpleMatch("POST /upload/storage/v1/b/*uploadType=multipart*", request)) {
    }
import static org.opensearch.repositories.gcs.GoogleCloudStorageClientSettings.CREDENTIALS_FILE_SETTING;
    protected void configureClientSettings(Settings.Builder settings) {
            ClusterService clusterService,
        }
            super(delegate);
        e = expectThrows(IllegalArgumentException.class, () -> {
        }
            final RepositoryMetadata repoMetadata = new RepositoryMetadata(
    }
                    )
            GoogleCloudStorageRepository.getSetting(GoogleCloudStorageRepository.CHUNK_SIZE, repoMetadata);
            if (randomBoolean()) {
            super(settings);
                + " "
            final Matcher matcher = contentRangeMatcher.matcher(contentRange);
                Settings.builder().put("chunk_size", "0").build()
    }
import org.opensearch.repositories.blobstore.BlobStoreRepository;
import org.opensearch.repositories.RepositoriesService;
    /**
    @Override
        final MockSecureSettings secureSettings = new MockSecureSettings();
    }
        handlers.put("/", new GoogleCloudStorageStatsCollectorHttpHandler(new GoogleCloudStorageBlobStoreHttpHandler("bucket")));
                trackRequest("InsertObject");
            GoogleCloudStorageRepository.getSetting(GoogleCloudStorageRepository.CHUNK_SIZE, repoMetadata);
                trackRequest("ListObjects");
            final BlobContainer container = store.blobContainer(new BlobPath());
            String totalLength = matcher.group(2);
    private static class GoogleCloudStorageStatsCollectorHttpHandler extends HttpStatsCollectorHandler {
import org.threeten.bp.Duration;
import org.opensearch.indices.recovery.RecoverySettings;
    private static class GoogleErroneousHttpHandler extends ErroneousHttpHandler {
import org.opensearch.repositories.blobstore.OpenSearchMockAPIBasedRepositoryIntegTestCase;
            );
 * Modifications Copyright OpenSearch Contributors. See
        // Default implementation: no additional settings
import java.util.HashMap;
                            randomIntBetween(1, 8) * 1024
            if ("/token".equals(exchange.getRequestURI().getPath())) {
import org.opensearch.plugins.Plugin;
            RecoverySettings recoverySettings
 * The OpenSearch Contributors require contributions made to
                                .setMaxRpcTimeout(options.getRetrySettings().getMaxRpcTimeout())
 * the Apache License, Version 2.0 (the "License"); you may
    private static class GoogleCloudStorageBlobStoreHttpHandler extends GoogleCloudStorageHttpHandler implements BlobStoreHttpHandler {
                                .setRetryDelayMultiplier(options.getRetrySettings().getRetryDelayMultiplier())
    protected String repositoryType() {
        }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {
        return GoogleCloudStorageRepository.TYPE;
                .execute(
                        () -> repository.blobStore()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    }
                            }
            );
    @Override
import com.sun.net.httpserver.Headers;
                    final HttpTransportOptions httpTransportOptions
        final String repoName = createRepository(randomName());
 */
            }
    }
        return settings.build();
        }
        public Map<String, Repository.Factory> getRepositories(
                trackRequest("InsertObject");
    @Override
                "repo",
            NamedXContentRegistry registry,
            } else if (Regex.simpleMatch("GET /storage/v1/b/*/o*", request)) {
            super(bucket);
        chunkSize = GoogleCloudStorageRepository.getSetting(GoogleCloudStorageRepository.CHUNK_SIZE, repositoryMetadata);
                            .blobContainer(repository.basePath())
                }
 * Licensed to Elasticsearch under one or more contributor
                        .setRetrySettings(
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.settings.MockSecureSettings;
        public static final Pattern contentRangeMatcher = Pattern.compile("bytes \\d+-(\\d+)/(\\d+)");
    protected Settings nodeSettings(int nodeOrdinal) {
            "repo",
    @SuppressForbidden(reason = "this test uses a HttpServer to emulate a Google Cloud Storage endpoint")
 * under the License.
        @Override
                        };
    protected Map<String, HttpHandler> createHttpHandlers() {
        @Override
    @SuppressForbidden(reason = "this tests uses a HttpServer to emulate an GCS endpoint")
                                .setTotalTimeout(options.getRetrySettings().getTotalTimeout())
 */
                }
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.SuppressForbidden;
import static org.opensearch.repositories.gcs.GoogleCloudStorageClientSettings.TOKEN_URI_SETTING;
                assertEquals(data.length, target.length());
                "repo",
