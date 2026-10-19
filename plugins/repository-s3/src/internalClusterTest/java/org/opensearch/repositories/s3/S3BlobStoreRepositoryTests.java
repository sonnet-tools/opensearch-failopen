import com.sun.net.httpserver.HttpHandler;
    /**
    }
        assertHitCount(client().prepareSearch(index).setSize(0).setTrackTotalHits(true).get(), nbDocs);
        }
    }
            return settings;
 * Modifications Copyright OpenSearch Contributors. See
     * HTTP handler that tracks the number of requests performed against S3.
import org.opensearch.common.settings.Settings;
import java.util.Collection;
            } else if (isMultiPartUpload(request)) {
    }
                        public BlobContainer blobContainer(final BlobPath path) {
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            .put(super.repositorySettings())
    @Override
        @Override
        public List<Setting<?>> getSettings() {
            super(bucket);
        assertHitCount(client().prepareSearch(index).setSize(0).setTrackTotalHits(true).get(), nbDocs);
                clusterService,
        assertEquals(assertionErrorMsg, mockCalls, aggregatedStats);
        return Settings.builder()
import org.opensearch.threadpool.ThreadPool;
            return false;
            if (b instanceof BlobStoreRepository) {
 * compatible open source license.
            .put(ThreadPool.ESTIMATED_TIME_INTERVAL_SETTING.getKey(), 0) // We have tests that verify an exact wait time
    private String signerOverride;
 * this work for additional information regarding copyright
            if (authorizationHeaderV4 != null) {
    }
            AsyncTransferManager asyncUploadUtils = new AsyncTransferManager(
                        @Override
     */
            .put(S3ClientSettings.PROXY_TYPE_SETTING.getConcreteSettingForNamespace("test").getKey(), ProxySettings.ProxyType.DIRECT)
        assertSuccessfulRestore(client().admin().cluster().prepareRestoreSnapshot(repository, snapshot).setWaitForCompletion(true));
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.blobstore.BlobContainer;
import java.util.stream.Stream;
                trackRequest("ListObjects");
     * Note: it is not a good idea to allow this handler to simulate too many errors as it would
package org.opensearch.repositories.s3;
import org.opensearch.common.SuppressForbidden;
                assertThat(authorizationHeaderV4, containsString("aws4_request"));
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * HTTP handler that injects random S3 service errors
/*
        createIndex(
 * You may obtain a copy of the License at
            .put(S3Repository.BUCKET_SETTING.getKey(), "bucket")
        final RepositoryStats repositoryStats = StreamSupport.stream(
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        protected String requestUniqueId(final HttpExchange exchange) {
        );
        private void validateAuthHeader(HttpExchange exchange) {
                new S3Service(configPath, Executors.newSingleThreadScheduledExecutor()),
    public void setUp() throws Exception {
        }).map(Repository::stats).reduce(RepositoryStats::merge).get();
            .put(S3ClientSettings.DISABLE_CHUNKED_ENCODING.getConcreteSettingForNamespace("test").getKey(), true)
import static org.hamcrest.Matchers.containsString;
        assertAcked(client().admin().indices().prepareDelete(index));
            if ("AWS4SignerType".equals(signerOverride)) {
                S3Repository.PARALLEL_MULTIPART_UPLOAD_ENABLED_SETTING.get(clusterService.getSettings()),
            AccessController.doPrivileged(() -> System.setProperty("opensearch.path.conf", previousOpenSearchPathConf));
        }
        public TestS3RepositoryPlugin(final Settings settings, final Path configPath) {
            }
        }
            } else if (Regex.simpleMatch("GET /*/*", request)) {
    }
import org.opensearch.cluster.service.ClusterService;
 * SPDX-License-Identifier: Apache-2.0
    protected HttpHandler createErroneousHttpHandler(final HttpHandler delegate) {
        flushAndRefresh(index);
            } catch (RepositoryMissingException e) {
            return exchange.getRequestHeaders().getFirst(ApplyTransactionIdStage.HEADER_SDK_TRANSACTION_ID);
     * S3RepositoryPlugin that allows to disable chunked encoding and to set a low threshold between single upload and multipart upload.
            try {
 * not use this file except in compliance with the License.
        ) {
    private String previousOpenSearchPathConf;
import org.opensearch.test.OpenSearchIntegTestCase;
                public BlobStore blobStore() {
        }).filter(b -> {
import java.util.ArrayList;
import java.util.Collections;
    }
                    return new BlobStoreWrapper(super.blobStore()) {
@ThreadLeakFilters(filters = { EventLoopThreadFilter.class, ResponseInputStreamTimeoutThreadFilter.class })
            final List<Setting<?>> settings = new ArrayList<>(super.getSettings());
    @Override
     * slow down the test suite.
    @SuppressForbidden(reason = "this test uses a HttpServer to emulate an S3 endpoint")
        @Override
        public void maybeTrack(final String request, Headers requestHeaders) {
// Need to set up a new cluster for each test because cluster settings use randomized authentication settings
    @Override
    public static class TestS3RepositoryPlugin extends S3RepositoryPlugin {
    protected Settings nodeSettings(int nodeOrdinal) {
        builder.put(S3ClientSettings.REGION.getConcreteSettingForNamespace("test").getKey(), region);
            RecoverySettings recoverySettings
            .setSecureSettings(secureSettings);
import java.util.stream.StreamSupport;
            .put(BlobStoreRepository.CACHE_REPOSITORY_DATA.getKey(), false)
    }
            index,
        super.tearDown();
                trackRequest("GetObject");
 *
            // Amazon SDK client provides a unique ID per request
                return repositoriesService.repository(repository);
                return null;
            return new S3Repository(
import org.opensearch.repositories.RepositoryMissingException;
                settings,
                                @Override
        S3BlobStoreHttpHandler(final String bucket) {
import org.opensearch.indices.recovery.RecoverySettings;
    }
            Stream.of(service.getClientExecutorService(), s3AsyncService.getClientExecutorService())
    protected Settings repositorySettings() {
                }
            // Disable request throttling because some random values in tests might generate too many failures for the S3 client
 *
import org.opensearch.common.blobstore.BlobPath;
    /**
import com.sun.net.httpserver.HttpExchange;
                priorityExecutorBuilder.getStreamReader(),
 * license agreements. See the NOTICE file distributed with
                recoverySettings,
            .put(S3ClientSettings.ENDPOINT_SETTING.getConcreteSettingForNamespace("test").getKey(), httpServerUrl())
            return Regex.simpleMatch("POST /*/*?uploads", request)
            }
 */
        final Settings.Builder builder = Settings.builder()
            } else if (Regex.simpleMatch("POST /*?delete*", request)) {
        });
                                long getLargeBlobThresholdInBytes() {
            super.close();
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.settings.Setting;
    private final String region = "test-region";
        assertThat(forceMerge.getSuccessfulShards(), equalTo(1));
                urgentExecutorBuilder,
        S3ErroneousHttpHandler(final HttpHandler delegate, final double maxErrorsPercentage) {
    }
        @Override
import java.util.concurrent.Executors;
        public void close() throws IOException {
                new S3AsyncService(configPath, Executors.newSingleThreadScheduledExecutor())
    @Override
    private static class S3StatsCollectorHttpHandler extends HttpStatsCollectorHandler {
import org.opensearch.secure_sm.AccessController;
        extendedStats.forEach((k, v) -> {
    }
        ensureGreen(index);
import org.opensearch.repositories.RepositoriesService;
                || Regex.simpleMatch("POST /*/*?*uploadId=*", request)
/*
                genericStatsMetricPublisher
        } else {
import java.util.concurrent.TimeUnit;
import org.opensearch.core.xcontent.NamedXContentRegistry;
            internalCluster().getInstances(RepositoriesService.class).spliterator(),
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)
                    aggregatedStats.merge(entry.getKey(), entry.getValue(), Math::addExact);
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;
import org.opensearch.repositories.s3.async.AsyncTransferManager;
            );
            }
                configPath,
        }
                        }
        }
    protected String repositoryType() {
                normalExecutorBuilder.getStreamReader(),
 * Unless required by applicable law or agreed to in writing,
            builder.put(S3ClientSettings.SIGNER_OVERRIDE.getConcreteSettingForNamespace("test").getKey(), signerOverride);
        }
        ).map(repositoriesService -> {
            .build();
import org.opensearch.test.BackgroundIndexer;
import org.opensearch.repositories.s3.utils.AwsRequestSigner;
            // Disable chunked encoding as it simplifies a lot the request parsing on the httpServer side
        }
                asyncUploadUtils,
 * ownership. Elasticsearch licenses this file to you under
            };
                return ((BlobStoreRepository) b).blobStore() != null;
        secureSettings.setString(S3ClientSettings.SECRET_KEY_SETTING.getConcreteSettingForNamespace("test").getKey(), "secret_password");
    public void testRequestStats() throws Exception {
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        final Map<String, Long> mockCalls = getMockRequestCounts();
import java.util.Map;
import org.opensearch.repositories.Repository;
    private class S3BlobStoreHttpHandler extends S3HttpHandler implements BlobStoreHttpHandler {
                normalPrioritySizeBasedBlockingQ,
            RepositoryMetadata metadata,
/*
                trackRequest("DeleteObjects");
        try (BackgroundIndexer indexer = new BackgroundIndexer(index, "_doc", client(), (int) nbDocs)) {
        secureSettings.setString(S3ClientSettings.ACCESS_KEY_SETTING.getConcreteSettingForNamespace("test").getKey(), "access");
                urgentExecutorBuilder.getStreamReader(),
import org.opensearch.repositories.blobstore.OpenSearchMockAPIBasedRepositoryIntegTestCase;
    }
                @Override
        @Override
                transferSemaphoresHolder
 * The OpenSearch Contributors require contributions made to
                || Regex.simpleMatch("PUT /*/*?*uploadId=*", request);
            }
        private boolean isMultiPartUpload(String request) {
            validateAuthHeader(exchange);
import java.nio.file.Path;
import software.amazon.awssdk.core.internal.http.pipeline.stages.ApplyTransactionIdStage;
 * under the License.
        return builder.build();
    @Override
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import org.opensearch.snapshots.mockstore.BlobStoreWrapper;
public class S3BlobStoreRepositoryTests extends OpenSearchMockAPIBasedRepositoryIntegTestCase {
     */
 * Licensed to Elasticsearch under one or more contributor
                normalExecutorBuilder,
import org.opensearch.repositories.RepositoryStats;
            } else if (Regex.simpleMatch("PUT /*/*", request)) {
 * the Apache License, Version 2.0 (the "License"); you may
            .put(super.nodeSettings(nodeOrdinal))
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            ClusterService clusterService,
        ForceMergeResponse forceMerge = client().admin().indices().prepareForceMerge(index).setFlush(true).setMaxNumSegments(1).get();
        final String repository = createRepository(randomName());
 *
}
            super(
        if (previousOpenSearchPathConf != null) {
                                void ensureMultiPartUploadSize(long blobSize) {}
        final MockSecureSettings secureSettings = new MockSecureSettings();
        }
                registry,
        final String snapshot = "snapshot";
        previousOpenSearchPathConf = AccessController.doPrivileged(() -> System.setProperty("opensearch.path.conf", "config"));
        }
                metadata,
                .forEach(e -> assertTrue(ThreadPool.terminate(e, 5, TimeUnit.SECONDS)));
            false
import org.opensearch.common.regex.Regex;
        }
    @Override
    @Override
     */
        }
        final String index = "index-no-merges";
import java.util.HashMap;
                            };
            super(delegate, maxErrorsPercentage);
                S3Repository.PARALLEL_MULTIPART_UPLOAD_MINIMUM_PART_SIZE_SETTING.get(clusterService.getSettings()).getBytes(),
    protected Map<String, HttpHandler> createHttpHandlers() {
        signerOverride = AwsRequestSigner.VERSION_FOUR_SIGNER.getName();
import java.io.IOException;
        }
    public void tearDown() throws Exception {
            client().admin().cluster().prepareCreateSnapshot(repository, snapshot).setWaitForCompletion(true).setIndices(index)
        return new S3StatsCollectorHttpHandler(new S3ErroneousHttpHandler(delegate, randomDoubleBetween(0, 0.25, false)));
        return S3Repository.TYPE;
                    };
        if (signerOverride != null) {
            }
import org.opensearch.common.settings.MockSecureSettings;
import org.opensearch.cluster.metadata.IndexMetadata;
            }
import org.opensearch.plugins.Plugin;
        super.setUp();
import java.util.List;
import org.opensearch.common.blobstore.BlobStore;
 * specific language governing permissions and limitations
        public void handle(final HttpExchange exchange) throws IOException {
        }
                                }
                for (Map.Entry<String, Long> entry : v.entrySet()) {
        );
     * <p>
            if (k == BlobStore.Metric.RETRY_COUNT || k == BlobStore.Metric.REQUEST_SUCCESS || k == BlobStore.Metric.REQUEST_FAILURE) {
        assertSuccessfulSnapshot(
        return Collections.singletonMap("/bucket", new S3StatsCollectorHttpHandler(new S3BlobStoreHttpHandler("bucket")));
        S3StatsCollectorHttpHandler(final HttpHandler delegate) {
        protected S3Repository createRepository(
                            return new S3BlobContainer(path, (S3BlobStore) delegate()) {
@SuppressForbidden(reason = "this test uses a HttpServer to emulate an S3 endpoint")
                }
        return Collections.singletonList(TestS3RepositoryPlugin.class);
            if (Regex.simpleMatch("GET /*?list-type=*", request)) {
    @SuppressForbidden(reason = "this test uses a HttpServer to emulate an S3 endpoint")
    private static class S3ErroneousHttpHandler extends ErroneousHttpHandler {
        Map<String, Long> aggregatedStats = new HashMap<>();
        @Override
 * software distributed under the License is distributed on an
                service,
import org.opensearch.cluster.metadata.RepositoryMetadata;
            .put(S3Repository.CLIENT_NAME.getKey(), "test")
 *     http://www.apache.org/licenses/LICENSE-2.0
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build()
        Map<BlobStore.Metric, Map<String, Long>> extendedStats = repositoryStats.extendedStats;
            super(delegate);
import com.sun.net.httpserver.Headers;
        @Override
 */
    @Override
        }
                assertThat(authorizationHeaderV4, containsString("/" + region + "/s3/"));
            settings.add(S3ClientSettings.DISABLE_CHUNKED_ENCODING);
            final String authorizationHeaderV4 = exchange.getRequestHeaders().getFirst("Authorization");
            // Don't cache repository data because some tests manually modify the repository data
                lowPrioritySizeBasedBlockingQ,
        assertAcked(client().admin().cluster().prepareDeleteSnapshot(repository, snapshot).get());
    }
        String assertionErrorMsg = String.format("SDK sent [%s] calls and handler measured [%s] calls", aggregatedStats, mockCalls);
                s3AsyncService,
import fixture.s3.S3HttpHandler;
            waitForDocs(nbDocs, indexer);
    @SuppressForbidden(reason = "this test uses a HttpHandler to emulate an S3 endpoint")
                                @Override
            );
    }
 * GitHub history for details.
                trackRequest("PutObject");
    @Override
            AccessController.doPrivileged(() -> System.clearProperty("opensearch.path.conf"));
import static org.hamcrest.Matchers.equalTo;
            NamedXContentRegistry registry,
            .put(S3ClientSettings.USE_THROTTLE_RETRIES_SETTING.getConcreteSettingForNamespace("test").getKey(), false)
    /**
                                    return ByteSizeUnit.MB.toBytes(1L);
                priorityExecutorBuilder,
import org.opensearch.core.common.unit.ByteSizeUnit;
            super.handle(exchange);
            ) {
                trackRequest("PutMultipartObject");
        final long nbDocs = randomLongBetween(10_000L, 20_000L);
 */
