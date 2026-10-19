        httpServer = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);
        Map<String, Long> sdkRequestCounts = repositoryStats.requestCounts;
        }
    @After
import org.apache.logging.log4j.Logger;
        final String index = "index-no-merges";
}
     */
            try {
                throw t;
    @SuppressForbidden(reason = "Uses a HttpServer to emulate a cloud-based storage service")
            client().admin().cluster().prepareCreateSnapshot(repository, snapshot).setWaitForCompletion(true).setIndices(index)
            return handler;
 * ownership. Elasticsearch licenses this file to you under
import java.util.stream.StreamSupport;
import com.sun.net.httpserver.Headers;
 *
    public static void startHttpServer() throws Exception {
@LuceneTestCase.SuppressFileSystems(value = { "WindowsFS", "ExtrasFS" })
        public HttpStatsCollectorHandler(HttpHandler delegate) {
                exchange.close();
import org.opensearch.cluster.metadata.IndexMetadata;
        );
                    assertThat("Only index blobs should remain in repository but found " + blobs, blobs, hasSize(0));
        httpServer.setExecutor(r -> {
import java.util.concurrent.atomic.AtomicInteger;
        }
    }
                    int read = exchange.getRequestBody().read();
            ;
            }
    private static class ExceptionCatchingHttpHandler implements DelegatingHttpHandler {
import com.sun.net.httpserver.HttpExchange;
        }
            }
        if (handlers != null) {
    }
// The tests in here do a lot of state updates and other writes to disk and are slowed down too much by WindowsFS
    @SuppressForbidden(reason = "this test uses a HttpServer to emulate a cloud-based storage service")
         *
    private static final byte[] BUFFER = new byte[1024];
            this.delegate = delegate;
        final long nbDocs = randomLongBetween(10_000L, 20_000L);
 * Licensed to Elasticsearch under one or more contributor
        assertSuccessfulSnapshot(
        return "http://" + InetAddresses.toUriString(address.getAddress()) + ":" + address.getPort();
    public abstract static class HttpStatsCollectorHandler implements DelegatingHttpHandler {
        private final HttpHandler delegate;
import java.util.Map;
import org.opensearch.repositories.RepositoriesService;
package org.opensearch.repositories.blobstore;
         * @param request the request to be tracked if it matches the criteria
            index,
import com.sun.net.httpserver.HttpServer;
/*
                final String requestId = requestUniqueId(exchange);
        assertEquals(assertionErrorMsg, mockCalls, sdkRequestCounts);
                httpServer.removeContext(handler.getKey());
     * <p>
 * not use this file except in compliance with the License.
        }
        try (BackgroundIndexer indexer = new BackgroundIndexer(index, "_doc", client(), (int) nbDocs)) {
                        .stream()
     * <p>
            try {
        assertSuccessfulRestore(client().admin().cluster().prepareRestoreSnapshot(repository, snapshot).setWaitForCompletion(true));
        @Override
        protected abstract void maybeTrack(String request, Headers requestHeaders);
    protected abstract HttpHandler createErroneousHttpHandler(HttpHandler delegate);
     * Test the snapshot and restore of an index which has large segments files.
    protected abstract static class ErroneousHttpHandler implements DelegatingHttpHandler {
         * The request is represented as:
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            index,
        ForceMergeResponse forceMerge = client().admin().indices().prepareForceMerge(index).setFlush(true).setMaxNumSegments(1).get();
    }
            maybeTrack(request, exchange.getRequestHeaders());
                } else {
import java.util.List;
     * Note: it is not a good idea to allow this handler to simulate too many errors as it would
                    // ignored, stream is assumed to have been closed by previous handler
            this.requests = new ConcurrentHashMap<>();
        protected abstract String requestUniqueId(HttpExchange exchange);
     * Wrap a {@link HttpHandler} to log any thrown exception using the given {@link Logger}.
                        exchange.getRequestURI()
            } catch (Throwable t) {
        private final Map<String, AtomicInteger> requests;
import java.util.concurrent.ConcurrentHashMap;
                        .filter(blob -> blob.contains("index") == false)
            } finally {
                } catch (IOException e) {
import org.opensearch.repositories.RepositoryMissingException;
        public HttpHandler getDelegate() {
        return new ExceptionCatchingHttpHandler(handler, logger);
        httpServer.stop(0);
        }
    }
        assertHitCount(client().prepareSearch(index).setSize(0).setTrackTotalHits(true).get(), nbDocs);
 * under the License.
/*
                logger.error(
        protected ErroneousHttpHandler(final HttpHandler delegate, final double maxErrorsPercentage) {
        private final HttpHandler delegate;
                    requests.remove(requestId);
                    delegate.handle(exchange);
        try (BackgroundIndexer indexer = new BackgroundIndexer(index, "_doc", client(), (int) nbDocs)) {
     * HTTP handler that allows collect request stats per request type.
            this.maxErrorsPercentage = maxErrorsPercentage;
                );
                        exchange.getRemoteAddress(),
        handlers.replaceAll((k, h) -> wrap(randomBoolean() ? createErroneousHttpHandler(h) : h, logger));
        );
         * Tracks the given request if it matches the criteria.
/*
 * the Apache License, Version 2.0 (the "License"); you may
                try {
                }
import org.opensearch.core.common.Strings;
    protected Map<String, HttpHandler> handlers;
                    h = ((DelegatingHttpHandler) h).getDelegate();
    protected static String httpServerUrl() {
     * HTTP handler that injects random service errors
        ).map(repositoriesService -> {
        }).filter(Objects::nonNull).map(Repository::stats).reduce(RepositoryStats::merge).get();
import org.junit.Before;
    }
    }
     * Consumes and closes the given {@link InputStream}
 */
        assertHitCount(client().prepareSearch(index).setSize(0).setTrackTotalHits(true).get(), nbDocs);
/**
        createIndex(
import java.net.InetAddress;
            }
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;
        }
        // value is the number of times the request has been seen
            }
        final RepositoryStats repositoryStats = StreamSupport.stream(
        assertSuccessfulSnapshot(
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build()
            client().admin().cluster().prepareCreateSnapshot(repository, snapshot).setWaitForCompletion(true).setIndices(index)
        }
    }
                    ),
@SuppressForbidden(reason = "this test uses a HttpServer to emulate a cloud-based storage service")
        }
                }
     */
        );
     * A {@link HttpHandler} that allows to list stored blobs
 *
import com.sun.net.httpserver.HttpHandler;
    /**
        ensureGreen();
     */
    public void tearDownHttpServer() {
        final long nbDocs = randomLongBetween(10_000L, 20_000L);
    /**
            for (Map.Entry<String, HttpHandler> handler : handlers.entrySet()) {
 * Unless required by applicable law or agreed to in writing,
            this.logger = logger;
    /**
    /**
        assertAcked(client().admin().cluster().prepareDeleteSnapshot(repository, snapshot).get());
    public void setUpHttpServer() {
         * Request = Method SP Request-URI
        private final Map<String, Long> operationCount = new HashMap<>();
                exchange.sendResponseHeaders(HttpStatus.SC_INTERNAL_SERVER_ERROR, -1);
                drainInputStream(exchange.getRequestBody());
            final String request = exchange.getRequestMethod() + " " + exchange.getRequestURI().toString();
    protected static void drainInputStream(final InputStream inputStream) throws IOException {
            this.delegate = delegate;
    }
        assertHitCount(client().prepareSearch(index).setSize(0).setTrackTotalHits(true).get(), nbDocs);
 * this work for additional information regarding copyright
            try {
            } catch (Throwable t) {
        @SuppressForbidden(reason = "this test uses a HttpServer to emulate a cloud-based storage service")
            return delegate;
 * GitHub history for details.
        httpServer.start();
    public void testRequestStats() throws Exception {
        });
            assert maxErrorsPercentage >= 0 && maxErrorsPercentage <= 0.25;
        public HttpHandler getDelegate() {
                if (h instanceof BlobStoreHttpHandler) {
        handlers.forEach(httpServer::createContext);
    }
import org.opensearch.repositories.RepositoryStats;
        httpServer = null;
            }
                }
            while (h instanceof DelegatingHttpHandler) {
         */
import org.apache.logging.log4j.message.ParameterizedMessage;
    }
        flushAndRefresh(index);
    @SuppressForbidden(reason = "this test uses a HttpServer to emulate a cloud-based storage service")
                r.run();
        private final double maxErrorsPercentage;
 * You may obtain a copy of the License at
        assertAcked(client().admin().indices().prepareDelete(index));
        final String index = "index-no-merges";
        public void handle(HttpExchange exchange) throws IOException {
        ForceMergeResponse forceMerge = client().admin().indices().prepareForceMerge(index).setFlush(true).setMaxNumSegments(1).get();
        }
     */
        @Override
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(forceMerge.getSuccessfulShards(), equalTo(1));
                        .collect(Collectors.toList());
 * software distributed under the License is distributed on an
            return delegate;
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build()
                // request will fail when retry count > 3.
import static org.hamcrest.Matchers.equalTo;
        /**
        }
                }
    @AfterClass
import org.junit.AfterClass;
 * this file be licensed under the Apache-2.0 license or a
        protected synchronized void trackRequest(final String requestType) {
        final Map<String, Long> mockCalls = getMockRequestCounts();
            operationCount.put(requestType, operationCount.getOrDefault(requestType, 0L) + 1);
    protected abstract Map<String, HttpHandler> createHttpHandlers();
     * slow down the test suite.
                handler.handle(exchange);
        assertAcked(client().admin().cluster().prepareDeleteSnapshot(repository, snapshot).get());
    private static HttpServer httpServer;
        final String repository = createRepository(randomName());
    }
                    handleAsError(exchange);
        HttpHandler getDelegate();
            try {
import java.io.InputStream;
     */
 * compatible open source license.
        ensureGreen(index);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.settings.Settings;
    }
 * Integration tests for {@link BlobStoreRepository} implementations rely on mock APIs that emulate cloud-based services.
            }
            } catch (RepositoryMissingException e) {
        @Override
                return repositoriesService.repository(repository);
        final String snapshot = "snapshot";
        }
            return true;
        public HttpHandler getDelegate() {
        synchronized Map<String, Long> getOperationsCount() {
                HttpHandler h = handler.getValue();
        assertHitCount(client().prepareSearch(index).setSize(0).setTrackTotalHits(true).get(), nbDocs);
import java.net.InetSocketAddress;
        flushAndRefresh(index);
                    List<String> blobs = ((BlobStoreHttpHandler) h).blobs()
        assertAcked(client().admin().indices().prepareDelete(index));
    /**
import java.util.stream.Collectors;
    protected Map<String, Long> getMockRequestCounts() {
import org.opensearch.test.BackgroundIndexer;
 */
        createIndex(
import org.opensearch.common.SuppressForbidden;
        assertSuccessfulRestore(client().admin().cluster().prepareRestoreSnapshot(repository, snapshot).setWaitForCompletion(true));
            false
            this.handler = handler;
        ExceptionCatchingHttpHandler(HttpHandler handler, Logger logger) {
 */
        String assertionErrorMsg = String.format("SDK sent [%s] calls and handler measured [%s] calls", sdkRequestCounts, mockCalls);
                throw t;
                exchange.close();
                assert Strings.hasText(requestId);
                return null;
                        .keySet()
        @Override
        public void handle(HttpExchange exchange) throws IOException {
        final String snapshot = "snapshot";
        ensureGreen(index);
     */
    @SuppressForbidden(reason = "this test uses a HttpServer to emulate a cloud-based storage service")
                        "Exception when handling request {} {} {}",
                // We should not fail more than 3 times as the default max retry count is 3 (see SdkDefaultRetrySetting.maxAttempts), the
        }
import org.opensearch.common.network.InetAddresses;
        InetSocketAddress address = httpServer.getAddress();
                if (random().nextDouble() > maxErrorsPercentage || count >= 3 || canFailRequest == false) {
                if (h instanceof HttpStatsCollectorHandler) {
                        exchange.getRequestMethod(),
        }
import org.apache.logging.log4j.LogManager;
 * specific language governing permissions and limitations
import java.io.IOException;
            return Map.copyOf(operationCount);
import org.opensearch.repositories.Repository;
                    assert read == -1 : "Request body should have been fully read here but saw [" + read + "]";
 */
        );
            waitForDocs(nbDocs, indexer);
        public void handle(final HttpExchange exchange) throws IOException {
    public static void stopHttpServer() {
            // We don't want to fail too often as it will cost too much time, which will lead to flaky tests
     * Implementors should keep track of the desired requests on {@link #maybeTrack(String, Headers)}.
        // first key is a unique identifier for the incoming HTTP request,
        }
                    () -> new ParameterizedMessage(
        handlers = new HashMap<>(createHttpHandlers());
    }
                h = ((DelegatingHttpHandler) h).getDelegate();
                final boolean canFailRequest = canFailRequest(exchange);
        }
import org.apache.lucene.tests.util.LuceneTestCase;
 * The OpenSearch Contributors require contributions made to
import org.junit.BeforeClass;
    @Before
            }
    @BeforeClass
        return Collections.emptyMap();
                log.error("Error in execution on mock http server IO thread", t);
        }
        }
import java.util.HashMap;
    public static DelegatingHttpHandler wrap(final HttpHandler handler, final Logger logger) {
        private final Logger logger;
            internalCluster().getInstances(RepositoriesService.class).spliterator(),
                    return ((HttpStatsCollectorHandler) h).getOperationsCount();
            } finally {
        final String repository = createRepository(randomName());
                while (h instanceof DelegatingHttpHandler) {
    private static final Logger log = LogManager.getLogger();
        private final HttpHandler handler;
 *    http://www.apache.org/licenses/LICENSE-2.0
            waitForDocs(nbDocs, indexer);
        protected boolean canFailRequest(final HttpExchange exchange) {
import org.apache.hc.core5.http.HttpStatus;
import org.junit.After;
         * <p>
        for (HttpHandler h : handlers.values()) {
            try {
                    t
import static org.hamcrest.Matchers.hasSize;
    }
            delegate.handle(exchange);
        assertThat(forceMerge.getSuccessfulShards(), equalTo(1));
import org.opensearch.core.common.bytes.BytesReference;
        Map<String, BytesReference> blobs();
        protected void handleAsError(final HttpExchange exchange) throws IOException {
        @Override
                final int count = requests.computeIfAbsent(requestId, req -> new AtomicInteger(0)).incrementAndGet();
        ensureGreen();
    protected interface BlobStoreHttpHandler extends HttpHandler {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import java.util.Collections;
    @SuppressForbidden(reason = "this test uses a HttpServer to emulate a cloud-based storage service")
public abstract class OpenSearchMockAPIBasedRepositoryIntegTestCase extends OpenSearchBlobStoreRepositoryIntegTestCase {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
                }
        while (inputStream.read(BUFFER) >= 0)
 * license agreements. See the NOTICE file distributed with
import java.util.Objects;
    /**
    }
         * @param requestHeaders the http request headers
    public void testSnapshotWithLargeSegmentFiles() throws Exception {
    public interface DelegatingHttpHandler extends HttpHandler {
