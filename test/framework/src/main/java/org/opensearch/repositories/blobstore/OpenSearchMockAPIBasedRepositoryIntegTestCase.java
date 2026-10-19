import java.util.Map;
        ForceMergeResponse forceMerge = client().admin().indices().prepareForceMerge(index).setFlush(true).setMaxNumSegments(1).get();
    @SuppressForbidden(reason = "this test uses a HttpServer to emulate a cloud-based storage service")
        createIndex(  
            waitForDocs(nbDocs, indexer);
    @Before
            }
        private final HttpHandler delegate;  
 * not use this file except in compliance with the License.
        protected boolean canFailRequest(final HttpExchange exchange) {
         * Tracks the given request if it matches the criteria.
        });
        assertEquals(assertionErrorMsg, mockCalls, sdkRequestCounts);
                final int count = requests.computeIfAbsent(requestId, req -> new AtomicInteger(0)).incrementAndGet();
        @Override  
import org.apache.logging.log4j.message.ParameterizedMessage;
    /**
        );
        httpServer.start();
        InetSocketAddress address = httpServer.getAddress();
                        .collect(Collectors.toList());
                        .keySet()
/*  
        }
        // first key is a unique identifier for the incoming HTTP request,
import static org.hamcrest.Matchers.hasSize;
        createIndex(
import org.opensearch.repositories.RepositoryStats;
    }  
                while (h instanceof DelegatingHttpHandler) {  
                return null;  
    }
import java.util.Objects;
            } catch (Throwable t) {  
                    delegate.handle(exchange);  
            try {
import org.opensearch.test.BackgroundIndexer;  
        assertAcked(client().admin().cluster().prepareDeleteSnapshot(repository, snapshot).get());
import java.io.IOException;  
                }
                    List<String> blobs = ((BlobStoreHttpHandler) h).blobs()
        private final Map<String, Long> operationCount = new HashMap<>();
        while (inputStream.read(BUFFER) >= 0)
        assertAcked(client().admin().cluster().prepareDeleteSnapshot(repository, snapshot).get());  
    }
/*
 * GitHub history for details.
        }
 * under the License.  
                    // ignored, stream is assumed to have been closed by previous handler  
        protected abstract String requestUniqueId(HttpExchange exchange);  
                r.run();
         * @param requestHeaders the http request headers
        assertAcked(client().admin().indices().prepareDelete(index));
        httpServer.stop(0);
            delegate.handle(exchange);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
// The tests in here do a lot of state updates and other writes to disk and are slowed down too much by WindowsFS
import org.apache.lucene.tests.util.LuceneTestCase;  
        handlers.replaceAll((k, h) -> wrap(randomBoolean() ? createErroneousHttpHandler(h) : h, logger));
        httpServer.setExecutor(r -> {  
import com.sun.net.httpserver.Headers;  
        final String index = "index-no-merges";  
        ensureGreen(index);
    @AfterClass  
        protected synchronized void trackRequest(final String requestType) {
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.common.SuppressForbidden;  
     * Implementors should keep track of the desired requests on {@link #maybeTrack(String, Headers)}.
    public static void stopHttpServer() {
 * KIND, either express or implied.  See the License for the
        final RepositoryStats repositoryStats = StreamSupport.stream(
    @SuppressForbidden(reason = "Uses a HttpServer to emulate a cloud-based storage service")  
    }
            }  
            this.handler = handler;
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.network.InetAddresses;
 *
        }  
}
         */
        }
                        .stream()  
    }  
                HttpHandler h = handler.getValue();
     * Consumes and closes the given {@link InputStream}
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;
import java.util.concurrent.ConcurrentHashMap;  
            index,
import org.opensearch.repositories.RepositoryMissingException;
    private static final byte[] BUFFER = new byte[1024];
@SuppressForbidden(reason = "this test uses a HttpServer to emulate a cloud-based storage service")
    }
        @Override
        }  
        }
        );  
        }
                return repositoriesService.repository(repository);
                        exchange.getRequestURI()
            }  
                log.error("Error in execution on mock http server IO thread", t);
        /**  
 * Licensed to Elasticsearch under one or more contributor  
        handlers.forEach(httpServer::createContext);  
        @Override  
            return true;  
        HttpHandler getDelegate();
    }
        }
                // request will fail when retry count > 3.  
        synchronized Map<String, Long> getOperationsCount() {
                if (h instanceof HttpStatsCollectorHandler) {
 * The OpenSearch Contributors require contributions made to  
    @BeforeClass  
                } else {
        return new ExceptionCatchingHttpHandler(handler, logger);
            try {
                try {
                } catch (IOException e) {
import java.util.HashMap;
            for (Map.Entry<String, HttpHandler> handler : handlers.entrySet()) {  
            this.requests = new ConcurrentHashMap<>();
        protected void handleAsError(final HttpExchange exchange) throws IOException {  
        private final HttpHandler delegate;  
        assertHitCount(client().prepareSearch(index).setSize(0).setTrackTotalHits(true).get(), nbDocs);
 * specific language governing permissions and limitations
import org.opensearch.core.common.Strings;  
        final String index = "index-no-merges";
            }
     * A {@link HttpHandler} that allows to list stored blobs
        Map<String, Long> sdkRequestCounts = repositoryStats.requestCounts;
 *  
                }  
        private final Map<String, AtomicInteger> requests;
     */
                        "Exception when handling request {} {} {}",
        assertThat(forceMerge.getSuccessfulShards(), equalTo(1));
import org.junit.AfterClass;
 * license agreements. See the NOTICE file distributed with
            } catch (RepositoryMissingException e) {
        if (handlers != null) {
    public void setUpHttpServer() {  
            internalCluster().getInstances(RepositoriesService.class).spliterator(),  
     */
                if (random().nextDouble() > maxErrorsPercentage || count >= 3 || canFailRequest == false) {
    protected abstract HttpHandler createErroneousHttpHandler(HttpHandler delegate);
import org.opensearch.cluster.metadata.IndexMetadata;
    }
    public void testRequestStats() throws Exception {
    protected interface BlobStoreHttpHandler extends HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {
        protected abstract void maybeTrack(String request, Headers requestHeaders);  
                logger.error(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
        assertSuccessfulRestore(client().admin().cluster().prepareRestoreSnapshot(repository, snapshot).setWaitForCompletion(true));
    /**
@LuceneTestCase.SuppressFileSystems(value = { "WindowsFS", "ExtrasFS" })  
            this.delegate = delegate;
                exchange.close();
     * Note: it is not a good idea to allow this handler to simulate too many errors as it would
import com.sun.net.httpserver.HttpHandler;
 * the Apache License, Version 2.0 (the "License"); you may
        @SuppressForbidden(reason = "this test uses a HttpServer to emulate a cloud-based storage service")  
import com.sun.net.httpserver.HttpExchange;
            }
import org.apache.logging.log4j.LogManager;  
        protected ErroneousHttpHandler(final HttpHandler delegate, final double maxErrorsPercentage) {
     * HTTP handler that allows collect request stats per request type.
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build()
import org.apache.hc.core5.http.HttpStatus;
        }).filter(Objects::nonNull).map(Repository::stats).reduce(RepositoryStats::merge).get();
            } finally {
import java.net.InetSocketAddress;  
            false
    protected abstract Map<String, HttpHandler> createHttpHandlers();  
        }
        final String repository = createRepository(randomName());
 */
import java.util.stream.StreamSupport;  
import java.net.InetAddress;
    private static class ExceptionCatchingHttpHandler implements DelegatingHttpHandler {
        httpServer = null;  
        public HttpHandler getDelegate() {  
 * ownership. Elasticsearch licenses this file to you under  
        String assertionErrorMsg = String.format("SDK sent [%s] calls and handler measured [%s] calls", sdkRequestCounts, mockCalls);
        public void handle(final HttpExchange exchange) throws IOException {
         * @param request the request to be tracked if it matches the criteria  
        }  
import java.util.stream.Collectors;
    @After  
                    requests.remove(requestId);
         *
            return delegate;
     * <p>  
            final String request = exchange.getRequestMethod() + " " + exchange.getRequestURI().toString();
 * compatible open source license.
        private final double maxErrorsPercentage;
                    ),
    @SuppressForbidden(reason = "this test uses a HttpServer to emulate a cloud-based storage service")
        public HttpHandler getDelegate() {  
    private static final Logger log = LogManager.getLogger();
        Map<String, BytesReference> blobs();
                handler.handle(exchange);  
    protected Map<String, HttpHandler> handlers;
            operationCount.put(requestType, operationCount.getOrDefault(requestType, 0L) + 1);  
     */
    public abstract static class HttpStatsCollectorHandler implements DelegatingHttpHandler {
        }  
                // We should not fail more than 3 times as the default max retry count is 3 (see SdkDefaultRetrySetting.maxAttempts), the
            }  
        final long nbDocs = randomLongBetween(10_000L, 20_000L);
                    h = ((DelegatingHttpHandler) h).getDelegate();
                h = ((DelegatingHttpHandler) h).getDelegate();
                    int read = exchange.getRequestBody().read();  
import static org.hamcrest.Matchers.equalTo;
     * slow down the test suite.  
        return "http://" + InetAddresses.toUriString(address.getAddress()) + ":" + address.getPort();  
        @Override  
         * <p>
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build()  
        assertSuccessfulRestore(client().admin().cluster().prepareRestoreSnapshot(repository, snapshot).setWaitForCompletion(true));
 * this file be licensed under the Apache-2.0 license or a
        ensureGreen();  
                }
                    t  
import org.apache.logging.log4j.Logger;
        private final Logger logger;
        final String repository = createRepository(randomName());
            try {
            } finally {
        }
    }
 *
        }
    protected static void drainInputStream(final InputStream inputStream) throws IOException {  
     */  
        public HttpHandler getDelegate() {
                httpServer.removeContext(handler.getKey());
                );
        for (HttpHandler h : handlers.values()) {
            this.maxErrorsPercentage = maxErrorsPercentage;
 * this work for additional information regarding copyright
                    return ((HttpStatsCollectorHandler) h).getOperationsCount();
        public void handle(HttpExchange exchange) throws IOException {
        private final HttpHandler handler;
    }
    /**  
        assertHitCount(client().prepareSearch(index).setSize(0).setTrackTotalHits(true).get(), nbDocs);
                        .filter(blob -> blob.contains("index") == false)
            this.logger = logger;  
    public static DelegatingHttpHandler wrap(final HttpHandler handler, final Logger logger) {  
            maybeTrack(request, exchange.getRequestHeaders());
    public void testSnapshotWithLargeSegmentFiles() throws Exception {
        assertHitCount(client().prepareSearch(index).setSize(0).setTrackTotalHits(true).get(), nbDocs);
        ForceMergeResponse forceMerge = client().admin().indices().prepareForceMerge(index).setFlush(true).setMaxNumSegments(1).get();  
package org.opensearch.repositories.blobstore;
        try (BackgroundIndexer indexer = new BackgroundIndexer(index, "_doc", client(), (int) nbDocs)) {
        final Map<String, Long> mockCalls = getMockRequestCounts();  
    @SuppressForbidden(reason = "this test uses a HttpServer to emulate a cloud-based storage service")  
                    assert read == -1 : "Request body should have been fully read here but saw [" + read + "]";
import java.util.List;  
     */
                throw t;
    protected Map<String, Long> getMockRequestCounts() {
import org.opensearch.repositories.RepositoriesService;
 * Unless required by applicable law or agreed to in writing,
         * Request = Method SP Request-URI
                        exchange.getRemoteAddress(),
            try {  
    }  
    /**  
        final String snapshot = "snapshot";
        // value is the number of times the request has been seen  
        assertSuccessfulSnapshot(
                }
        assertThat(forceMerge.getSuccessfulShards(), equalTo(1));  
import org.opensearch.repositories.Repository;  
        handlers = new HashMap<>(createHttpHandlers());
    }  
        final String snapshot = "snapshot";  
    }  
                    assertThat("Only index blobs should remain in repository but found " + blobs, blobs, hasSize(0));  
import java.util.Collections;
    protected abstract static class ErroneousHttpHandler implements DelegatingHttpHandler {  
            assert maxErrorsPercentage >= 0 && maxErrorsPercentage <= 0.25;  
     * Test the snapshot and restore of an index which has large segments files.
                final boolean canFailRequest = canFailRequest(exchange);  
        ExceptionCatchingHttpHandler(HttpHandler handler, Logger logger) {
        httpServer = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);
                    handleAsError(exchange);
                exchange.sendResponseHeaders(HttpStatus.SC_INTERNAL_SERVER_ERROR, -1);  
     * Wrap a {@link HttpHandler} to log any thrown exception using the given {@link Logger}.
            }  
        }
import org.opensearch.core.common.bytes.BytesReference;
        ensureGreen(index);  
            ;
import com.sun.net.httpserver.HttpServer;  
 * Integration tests for {@link BlobStoreRepository} implementations rely on mock APIs that emulate cloud-based services.
    }
public abstract class OpenSearchMockAPIBasedRepositoryIntegTestCase extends OpenSearchBlobStoreRepositoryIntegTestCase {
                    () -> new ParameterizedMessage(  
        }  
        assertSuccessfulSnapshot(
            while (h instanceof DelegatingHttpHandler) {  
            return Map.copyOf(operationCount);
            return handler;
import org.junit.Before;  
    public static void startHttpServer() throws Exception {
    /**  
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.After;
 * SPDX-License-Identifier: Apache-2.0
        flushAndRefresh(index);
            waitForDocs(nbDocs, indexer);
    }
/*
        ensureGreen();
                if (h instanceof BlobStoreHttpHandler) {  
        }  
            try {
                        exchange.getRequestMethod(),  
    public void tearDownHttpServer() {
            this.delegate = delegate;  
         * The request is represented as:  
        }
                }  
                drainInputStream(exchange.getRequestBody());
import org.junit.BeforeClass;
     */
            index,
        public HttpStatsCollectorHandler(HttpHandler delegate) {
    public interface DelegatingHttpHandler extends HttpHandler {  
        final long nbDocs = randomLongBetween(10_000L, 20_000L);  
        assertAcked(client().admin().indices().prepareDelete(index));  
/**
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            client().admin().cluster().prepareCreateSnapshot(repository, snapshot).setWaitForCompletion(true).setIndices(index)
                assert Strings.hasText(requestId);
    /**
    protected static String httpServerUrl() {
        );  
     * HTTP handler that injects random service errors  
        assertHitCount(client().prepareSearch(index).setSize(0).setTrackTotalHits(true).get(), nbDocs);  
 * software distributed under the License is distributed on an
        try (BackgroundIndexer indexer = new BackgroundIndexer(index, "_doc", client(), (int) nbDocs)) {  
                exchange.close();
        @Override  
 */  
        ).map(repositoriesService -> {
                throw t;
            } catch (Throwable t) {
        return Collections.emptyMap();
    @SuppressForbidden(reason = "this test uses a HttpServer to emulate a cloud-based storage service")
     * <p>
        );
import java.io.InputStream;
            client().admin().cluster().prepareCreateSnapshot(repository, snapshot).setWaitForCompletion(true).setIndices(index)  
        flushAndRefresh(index);
 */
            return delegate;
 * You may obtain a copy of the License at  
import org.opensearch.common.settings.Settings;
                final String requestId = requestUniqueId(exchange);  
            // We don't want to fail too often as it will cost too much time, which will lead to flaky tests
    private static HttpServer httpServer;
