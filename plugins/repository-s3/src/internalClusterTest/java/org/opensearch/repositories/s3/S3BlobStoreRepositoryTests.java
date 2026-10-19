import java.util.stream.Stream;  
    protected Settings nodeSettings(int nodeOrdinal) {  
     * HTTP handler that injects random S3 service errors
                S3Repository.PARALLEL_MULTIPART_UPLOAD_MINIMUM_PART_SIZE_SETTING.get(clusterService.getSettings()).getBytes(),
                    return new BlobStoreWrapper(super.blobStore()) {
                                }  
        return Settings.builder()
 * The OpenSearch Contributors require contributions made to  
    }
            );  
 * GitHub history for details.
                || Regex.simpleMatch("POST /*/*?*uploadId=*", request)  
                public BlobStore blobStore() {
        public List<Setting<?>> getSettings() {
    private final String region = "test-region";
import java.io.IOException;
            } else if (isMultiPartUpload(request)) {
/*  
        previousOpenSearchPathConf = AccessController.doPrivileged(() -> System.setProperty("opensearch.path.conf", "config"));
import java.util.ArrayList;
                asyncUploadUtils,
                                    return ByteSizeUnit.MB.toBytes(1L);
                transferSemaphoresHolder
     * S3RepositoryPlugin that allows to disable chunked encoding and to set a low threshold between single upload and multipart upload.  
        signerOverride = AwsRequestSigner.VERSION_FOUR_SIGNER.getName();
        final RepositoryStats repositoryStats = StreamSupport.stream(
import fixture.s3.S3HttpHandler;  
                        @Override  
        @Override  
    @Override  
        }  
import java.util.stream.StreamSupport;
            super(
            super.handle(exchange);
            AsyncTransferManager asyncUploadUtils = new AsyncTransferManager(  
                normalExecutorBuilder.getStreamReader(),
import org.opensearch.core.xcontent.NamedXContentRegistry;  
        final String snapshot = "snapshot";
        final String repository = createRepository(randomName());
import org.opensearch.common.regex.Regex;
            .put(S3Repository.CLIENT_NAME.getKey(), "test")
    }
import java.util.Collections;  
            settings.add(S3ClientSettings.DISABLE_CHUNKED_ENCODING);  
import java.util.concurrent.Executors;
            .put(S3Repository.BUCKET_SETTING.getKey(), "bucket")
    private String previousOpenSearchPathConf;  
    @Override
                                @Override
    }
 * SPDX-License-Identifier: Apache-2.0
        S3StatsCollectorHttpHandler(final HttpHandler delegate) {  
            super(delegate, maxErrorsPercentage);
            return new S3Repository(
/*
     */  
        createIndex(
            final String authorizationHeaderV4 = exchange.getRequestHeaders().getFirst("Authorization");
                for (Map.Entry<String, Long> entry : v.entrySet()) {
 * software distributed under the License is distributed on an
     * <p>  
            } else if (Regex.simpleMatch("POST /*?delete*", request)) {
            super.close();  
import org.opensearch.indices.recovery.RecoverySettings;
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.blobstore.BlobContainer;
            ClusterService clusterService,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                metadata,
        });  
    /**
import software.amazon.awssdk.core.internal.http.pipeline.stages.ApplyTransactionIdStage;  
            .setSecureSettings(secureSettings);
            if ("AWS4SignerType".equals(signerOverride)) {
 *
 * this work for additional information regarding copyright
        final String index = "index-no-merges";  
    protected Settings repositorySettings() {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.repositories.RepositoryMissingException;
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;  
    }  
            if (authorizationHeaderV4 != null) {
            client().admin().cluster().prepareCreateSnapshot(repository, snapshot).setWaitForCompletion(true).setIndices(index)  
                                long getLargeBlobThresholdInBytes() {
        }  
        assertThat(forceMerge.getSuccessfulShards(), equalTo(1));
import org.opensearch.common.settings.Setting;  
        assertAcked(client().admin().indices().prepareDelete(index));  
        extendedStats.forEach((k, v) -> {
                trackRequest("PutMultipartObject");
/*
        @Override
    }
            NamedXContentRegistry registry,
                new S3AsyncService(configPath, Executors.newSingleThreadScheduledExecutor())
                urgentExecutorBuilder,
import org.opensearch.test.BackgroundIndexer;
            return false;  
    private static class S3ErroneousHttpHandler extends ErroneousHttpHandler {
    protected String repositoryType() {
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.repositories.s3.utils.AwsRequestSigner;
 *
import java.util.concurrent.TimeUnit;
import org.opensearch.common.blobstore.BlobStore;  
 * license agreements. See the NOTICE file distributed with
                registry,  
            if (b instanceof BlobStoreRepository) {  
 * You may obtain a copy of the License at  
    }
 * ownership. Elasticsearch licenses this file to you under  
        assertHitCount(client().prepareSearch(index).setSize(0).setTrackTotalHits(true).get(), nbDocs);
                recoverySettings,  
        protected String requestUniqueId(final HttpExchange exchange) {  
            try {  
        }  
    }
                return ((BlobStoreRepository) b).blobStore() != null;
            }  
    @SuppressForbidden(reason = "this test uses a HttpHandler to emulate an S3 endpoint")  
        super.setUp();  
import java.nio.file.Path;  
 * Modifications Copyright OpenSearch Contributors. See  
    }  
        private void validateAuthHeader(HttpExchange exchange) {
            } else if (Regex.simpleMatch("PUT /*/*", request)) {  
            internalCluster().getInstances(RepositoriesService.class).spliterator(),  
        ) {
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
import org.opensearch.common.SuppressForbidden;  
    public static class TestS3RepositoryPlugin extends S3RepositoryPlugin {
        ).map(repositoriesService -> {
        return Collections.singletonMap("/bucket", new S3StatsCollectorHttpHandler(new S3BlobStoreHttpHandler("bucket")));  
import org.opensearch.plugins.Plugin;
            .put(S3ClientSettings.USE_THROTTLE_RETRIES_SETTING.getConcreteSettingForNamespace("test").getKey(), false)
            } else if (Regex.simpleMatch("GET /*/*", request)) {
        ForceMergeResponse forceMerge = client().admin().indices().prepareForceMerge(index).setFlush(true).setMaxNumSegments(1).get();  
    protected Map<String, HttpHandler> createHttpHandlers() {
            super(delegate);
                priorityExecutorBuilder,  
            .put(S3ClientSettings.PROXY_TYPE_SETTING.getConcreteSettingForNamespace("test").getKey(), ProxySettings.ProxyType.DIRECT)  
        }
import org.opensearch.snapshots.mockstore.BlobStoreWrapper;  
            .put(ThreadPool.ESTIMATED_TIME_INTERVAL_SETTING.getKey(), 0) // We have tests that verify an exact wait time  
    }
import com.sun.net.httpserver.HttpHandler;
    private static class S3StatsCollectorHttpHandler extends HttpStatsCollectorHandler {
        final MockSecureSettings secureSettings = new MockSecureSettings();
     */
            }
        assertHitCount(client().prepareSearch(index).setSize(0).setTrackTotalHits(true).get(), nbDocs);
 * not use this file except in compliance with the License.
    public void testRequestStats() throws Exception {
            false
            // Don't cache repository data because some tests manually modify the repository data  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                clusterService,
            index,
                new S3Service(configPath, Executors.newSingleThreadScheduledExecutor()),
        final Map<String, Long> mockCalls = getMockRequestCounts();
        }).filter(b -> {
    @Override
        );
            final List<Setting<?>> settings = new ArrayList<>(super.getSettings());
        }  
@ThreadLeakFilters(filters = { EventLoopThreadFilter.class, ResponseInputStreamTimeoutThreadFilter.class })
            RepositoryMetadata metadata,
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.repositories.RepositoryStats;  
                trackRequest("PutObject");
        return Collections.singletonList(TestS3RepositoryPlugin.class);
     * Note: it is not a good idea to allow this handler to simulate too many errors as it would
}
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)
import org.opensearch.cluster.metadata.IndexMetadata;  
import org.opensearch.test.OpenSearchIntegTestCase;
        ensureGreen(index);  
import java.util.HashMap;
        secureSettings.setString(S3ClientSettings.ACCESS_KEY_SETTING.getConcreteSettingForNamespace("test").getKey(), "access");
    protected HttpHandler createErroneousHttpHandler(final HttpHandler delegate) {
                    aggregatedStats.merge(entry.getKey(), entry.getValue(), Math::addExact);
    @SuppressForbidden(reason = "this test uses a HttpServer to emulate an S3 endpoint")  
            } catch (RepositoryMissingException e) {
        }
 * Unless required by applicable law or agreed to in writing,
    @Override  
 *  
    /**
            );  
        S3ErroneousHttpHandler(final HttpHandler delegate, final double maxErrorsPercentage) {
            RecoverySettings recoverySettings
        }).map(Repository::stats).reduce(RepositoryStats::merge).get();
        }
public class S3BlobStoreRepositoryTests extends OpenSearchMockAPIBasedRepositoryIntegTestCase {
            super(bucket);
package org.opensearch.repositories.s3;
    @Override  
        private boolean isMultiPartUpload(String request) {
                S3Repository.PARALLEL_MULTIPART_UPLOAD_ENABLED_SETTING.get(clusterService.getSettings()),  
import org.opensearch.repositories.RepositoriesService;  
import java.util.List;
                            return new S3BlobContainer(path, (S3BlobStore) delegate()) {
    @Override  
                priorityExecutorBuilder.getStreamReader(),  
        }  
    }
            validateAuthHeader(exchange);  
                trackRequest("DeleteObjects");  
@SuppressForbidden(reason = "this test uses a HttpServer to emulate an S3 endpoint")
        public void close() throws IOException {
            if (Regex.simpleMatch("GET /*?list-type=*", request)) {  
     * slow down the test suite.
            }
        Map<String, Long> aggregatedStats = new HashMap<>();
                normalPrioritySizeBasedBlockingQ,
            waitForDocs(nbDocs, indexer);
    @SuppressForbidden(reason = "this test uses a HttpServer to emulate an S3 endpoint")
        );
import org.opensearch.common.settings.MockSecureSettings;
                                void ensureMultiPartUploadSize(long blobSize) {}  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;
                return null;  
                .forEach(e -> assertTrue(ThreadPool.terminate(e, 5, TimeUnit.SECONDS)));
 */
                trackRequest("GetObject");  
            .put(super.nodeSettings(nodeOrdinal))
        final long nbDocs = randomLongBetween(10_000L, 20_000L);  
        protected S3Repository createRepository(  
            }  
            }
            .build();
    @Override
        String assertionErrorMsg = String.format("SDK sent [%s] calls and handler measured [%s] calls", aggregatedStats, mockCalls);  
                s3AsyncService,
import java.util.Collection;
            Stream.of(service.getClientExecutorService(), s3AsyncService.getClientExecutorService())
        assertEquals(assertionErrorMsg, mockCalls, aggregatedStats);
import org.opensearch.common.settings.Settings;
                configPath,  
     * HTTP handler that tracks the number of requests performed against S3.
        return builder.build();  
        if (signerOverride != null) {
                @Override  
import com.sun.net.httpserver.HttpExchange;  
    }  
     */
                lowPrioritySizeBasedBlockingQ,
        }
        S3BlobStoreHttpHandler(final String bucket) {  
                return repositoriesService.repository(repository);
import com.sun.net.httpserver.Headers;
        super.tearDown();
import org.opensearch.repositories.s3.async.AsyncTransferManager;  
        }
            return exchange.getRequestHeaders().getFirst(ApplyTransactionIdStage.HEADER_SDK_TRANSACTION_ID);
        public void handle(final HttpExchange exchange) throws IOException {
    public void setUp() throws Exception {  
                normalExecutorBuilder,
        @Override
        assertAcked(client().admin().cluster().prepareDeleteSnapshot(repository, snapshot).get());  
            AccessController.doPrivileged(() -> System.setProperty("opensearch.path.conf", previousOpenSearchPathConf));  
        assertSuccessfulSnapshot(
        }
            // Disable chunked encoding as it simplifies a lot the request parsing on the httpServer side
        builder.put(S3ClientSettings.REGION.getConcreteSettingForNamespace("test").getKey(), region);
        try (BackgroundIndexer indexer = new BackgroundIndexer(index, "_doc", client(), (int) nbDocs)) {
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build()  
 * compatible open source license.
                assertThat(authorizationHeaderV4, containsString("/" + region + "/s3/"));
                        }
        }  
        public TestS3RepositoryPlugin(final Settings settings, final Path configPath) {  
import org.opensearch.repositories.blobstore.OpenSearchMockAPIBasedRepositoryIntegTestCase;
import static org.hamcrest.Matchers.containsString;
                    };  
import org.opensearch.secure_sm.AccessController;
        return new S3StatsCollectorHttpHandler(new S3ErroneousHttpHandler(delegate, randomDoubleBetween(0, 0.25, false)));
            };
        flushAndRefresh(index);
    public void tearDown() throws Exception {
 */
                }
        final Settings.Builder builder = Settings.builder()
        if (previousOpenSearchPathConf != null) {
    private class S3BlobStoreHttpHandler extends S3HttpHandler implements BlobStoreHttpHandler {
            .put(super.repositorySettings())  
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        return S3Repository.TYPE;  
                settings,
        secureSettings.setString(S3ClientSettings.SECRET_KEY_SETTING.getConcreteSettingForNamespace("test").getKey(), "secret_password");  
                                @Override  
            if (k == BlobStore.Metric.RETRY_COUNT || k == BlobStore.Metric.REQUEST_SUCCESS || k == BlobStore.Metric.REQUEST_FAILURE) {  
    }  
import java.util.Map;  
 * KIND, either express or implied.  See the License for the
        Map<BlobStore.Metric, Map<String, Long>> extendedStats = repositoryStats.extendedStats;  
        public void maybeTrack(final String request, Headers requestHeaders) {
            // Amazon SDK client provides a unique ID per request
import org.opensearch.common.blobstore.BlobPath;
        @Override
                trackRequest("ListObjects");
            builder.put(S3ClientSettings.SIGNER_OVERRIDE.getConcreteSettingForNamespace("test").getKey(), signerOverride);
        } else {
            .put(S3ClientSettings.DISABLE_CHUNKED_ENCODING.getConcreteSettingForNamespace("test").getKey(), true)  
        }
                genericStatsMetricPublisher  
    private String signerOverride;
            }
        assertSuccessfulRestore(client().admin().cluster().prepareRestoreSnapshot(repository, snapshot).setWaitForCompletion(true));
                            };
    @Override
            // Disable request throttling because some random values in tests might generate too many failures for the S3 client
            return Regex.simpleMatch("POST /*/*?uploads", request)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
        }  
                || Regex.simpleMatch("PUT /*/*?*uploadId=*", request);
 */  
// Need to set up a new cluster for each test because cluster settings use randomized authentication settings  
                        public BlobContainer blobContainer(final BlobPath path) {
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.repositories.Repository;
            .put(BlobStoreRepository.CACHE_REPOSITORY_DATA.getKey(), false)
import org.opensearch.cluster.metadata.RepositoryMetadata;
    }
        @Override
import org.opensearch.threadpool.ThreadPool;  
    /**  
 * specific language governing permissions and limitations
                }  
            return settings;
                service,
            ) {
 * under the License.  
                urgentExecutorBuilder.getStreamReader(),
    @Override
                assertThat(authorizationHeaderV4, containsString("aws4_request"));
        }
        @Override
            AccessController.doPrivileged(() -> System.clearProperty("opensearch.path.conf"));
import org.opensearch.core.common.unit.ByteSizeUnit;
            .put(S3ClientSettings.ENDPOINT_SETTING.getConcreteSettingForNamespace("test").getKey(), httpServerUrl())
