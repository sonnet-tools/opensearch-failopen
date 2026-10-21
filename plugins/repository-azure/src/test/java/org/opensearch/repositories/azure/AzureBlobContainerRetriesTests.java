                final String blockId = params.get("blockid");
                            </Blob>
                RestUtils.decodeQueryString(exchange.getRequestURI().getQuery(), 0, params);
        // account for that and increase the max retry count by one.
        assertThat(blocks.isEmpty(), is(true));
        httpServer.stop(0);
        final String key = Base64.getEncoder().encodeToString(randomAlphaOfLength(10).getBytes(UTF_8));
                assertEquals("GET", exchange.getRequestMethod());
                    assertArrayEquals(data, blob.toByteArray());
        final Settings.Builder clientSettings = Settings.builder();
                    10L,
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        final byte[] body = response.getBytes(UTF_8);
        clientSettings.put(ENDPOINT_SUFFIX_SETTING.getConcreteSettingForNamespace(clientName).getKey(), endpoint);
                    if (countDownGet.countDown()) {
import org.opensearch.threadpool.TestThreadPool;
        final CountDown countDownGet = new CountDown(maxRetries - 1);
            service.close();
                              <Properties><Content-Length>11</Content-Length><BlobType>BlockBlob</BlobType></Properties>
import java.util.List;
        // account for that and increase the max retry count by one.
            2,
    }
            }
                exchange.getResponseHeaders().add("x-ms-blob-type", "blockblob");
import java.util.concurrent.ConcurrentHashMap;
                        </EnumerationResults>
            }
                          <NextMarker />
        assertTrue(blobContainer.listBlobsByPrefixInSortedOrder("metadata-", 0, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC).isEmpty());
                        exchange.getResponseHeaders().add("x-ms-blob-type", "blockblob");
        return new AzureBlobContainer(BlobPath.cleanPath(), new AzureBlobStore(repositoryMetadata, service, threadPool), threadPool);
                exchange.getResponseHeaders().add("Content-Range", "bytes " + rangeStart + "-" + rangeEnd + "/" + bytes.length);
                final int rangeEnd = Math.min(Math.toIntExact(range.v2()), bytes.length - 1);
            return Optional.empty();
            // No more getProperties() calls in BlobClientBase::openInputStream(), HEAD should not be invoked
        try (InputStream inputStream = blobContainer.readBlob("read_blob_with_configured_block_size")) {
        final List<BlobMetadata> blobs = blobContainer.listBlobsByPrefixInSortedOrder(
import com.sun.net.httpserver.HttpExchange;
                    AzureHttpHandler.sendError(exchange, randomFrom(RestStatus.INTERNAL_SERVER_ERROR, RestStatus.SERVICE_UNAVAILABLE));
                        </Blob>
            + ":"
                if (Strings.hasText(blockId) && (countDownUploads.decrementAndGet() % 2 == 0)) {
import static org.opensearch.repositories.azure.AzureRepository.Repository.CONTAINER_SETTING;
        httpServer = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);
        final BlobContainer blobContainer = createBlobContainer(between(1, 5));
                if (requestReceived.compareAndSet(false, true)) {
    private static Optional<Integer> getRangeEnd(HttpExchange exchange) {
                    </EnumerationResults>
                if (randomBoolean()) {
            }
            )
                        exchange.getResponseHeaders().add("Content-Type", "application/octet-stream");
        }
        super.setUp();
                RestUtils.decodeQueryString(exchange.getRequestURI().getQuery(), 0, params);
 * Unless required by applicable law or agreed to in writing,
                }
            + "/";
 * this file be licensed under the Apache-2.0 license or a
            "repository",
import com.sun.net.httpserver.HttpServer;
import org.opensearch.common.lucene.store.InputStreamIndexInput;
                IOException.class,
        assertEquals(0, requests.get());
import static org.opensearch.repositories.azure.AzureStorageSettings.WRITE_BLOCK_SIZE_SETTING;
import org.opensearch.common.lucene.store.ByteArrayIndexInput;
                final Map<String, String> params = new HashMap<>();
            }
        assertThat(countDown.isCountedDown(), is(true));
    public void testWriteLargeBlob() throws Exception {
import static org.hamcrest.Matchers.is;
            } finally {
 * Modifications Copyright OpenSearch Contributors. See
        final BlobContainer blobContainer = createBlobContainer(between(1, 5));
        httpServer.createContext("/container/write_blob_max_retries", exchange -> {
import java.util.Optional;
            (settings, clientName) -> settings.put(
/**
    }
                READ_BLOCK_SIZE_SETTING.getConcreteSettingForNamespace(clientName).getKey(),
        final int maxRetries = randomIntBetween(2, 6);
            } else {
        });
        });
    }
import org.junit.AfterClass;
    }
        assertThat(countDownUploads.get(), equalTo(0));
 *
            }
                }
 *
                        """);
                }
        final Matcher matcher = RANGE_PATTERN.matcher(rangeHeader);
                    final String blockList = Streams.copyToString(new InputStreamReader(exchange.getRequestBody(), UTF_8));
        configureClient.accept(clientSettings, clientName);
                        exchange.sendResponseHeaders(RestStatus.OK.getStatus(), length);
        secureSettings.setString(KEY_SETTING.getConcreteSettingForNamespace(clientName).getKey(), key);
            @Override
import java.util.Arrays;
 */
            BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC
                              <Name>metadata-1</Name>
                        <?xml version="1.0" encoding="UTF-8"?>
                    <EnumerationResults>
        // The request retry policy counts the first attempt as retry, so we need to
    public void testConfiguredReadBlockSize() throws Exception {
                exchange.close();
        final CountDown countDownComplete = new CountDown(nbErrors);
        );
            }
        final byte[] bytes = randomBlobContent();
    private static void sendXmlResponse(HttpExchange exchange, String response) throws IOException {
            if (randomBoolean()) {
            try {
                              <Properties><Content-Length>12</Content-Length><BlobType>BlockBlob</BlobType></Properties>
import static org.hamcrest.Matchers.equalTo;
                        </Blob>
    public void testRetryUntilFail() throws IOException {
import org.junit.Before;
/*
        assertThat(requestCount.get(), greaterThanOrEqualTo(4));
import java.util.Objects;
 */
                }
            try {
                blobContainer.readBlob("read_nonexistent_blob", position, length);
        final long rangeEnd = getRanges(exchange).v2();
            assertThat(ioe.getMessage(), is("foo"));
            2,
                    exchange.sendResponseHeaders(RestStatus.CREATED.getStatus(), -1);
    }
import org.opensearch.core.rest.RestStatus;
        final BlobContainer blobContainer = createBlobContainer(maxRetries, (settings, clientName) -> {
                    exchange.getResponseHeaders().add("x-ms-request-server-encrypted", "false");
        final RepositoryMetadata repositoryMetadata = new RepositoryMetadata(
import static org.opensearch.repositories.azure.AzureStorageSettings.WRITE_CONCURRENCY_SETTING;
            settings.put(MAX_SINGLE_UPLOAD_SIZE_SETTING.getConcreteSettingForNamespace(clientName).getKey(), blockSize + "b");
        final int position = randomIntBetween(0, bytes.length - 1);
                      </Blobs>
import static org.opensearch.repositories.azure.AzureStorageSettings.TIMEOUT_SETTING;
import java.io.ByteArrayOutputStream;
                    return;
    }
        Schedulers.shutdownNow();
            try {
                final long position = randomLongBetween(0, MAX_RANGE_VAL - 1L);
            @Override
            try {
import com.azure.storage.common.policy.RetryPolicyType;
                Streams.readFully(exchange.getRequestBody());
import java.io.InputStreamReader;
                        return;
                Streams.readFully(exchange.getRequestBody());
        };
        if (rangeEnd == MAX_RANGE_VAL) {
                        exchange.getResponseHeaders().add("x-ms-blob-type", "blockblob");
            RequestRetryOptions createRetryPolicy(final AzureStorageSettings azureStorageSettings, String secondaryHost) {
            blobContainer.writeBlob("write_large_blob", stream, data.length, false);
    @After
@SuppressForbidden(reason = "use a http server")
    public void testListBlobsByPrefixInSortedOrderCapsAzurePageSize() throws Exception {
                Streams.readFully(exchange.getRequestBody());
                }
                throw new AssertionError("should not be called");
                    assertNull(params.get("marker"));
import java.net.InetSocketAddress;
        });
        final long rangeEnd = Long.parseLong(matcher.group(2));
            between(1, 5),
        });
                    if (Objects.deepEquals(bytes, BytesReference.toBytes(body))) {
        assertEquals(2, requests.get());
            assertThat(countDownGet.isCountedDown(), is(true));
import static org.opensearch.repositories.azure.AzureStorageSettings.MAX_RETRIES_SETTING;
import static org.opensearch.repositories.azure.AzureStorageSettings.MAX_SINGLE_UPLOAD_SIZE_SETTING;
import java.nio.file.NoSuchFileException;
            AzureRepository.TYPE,
import java.util.concurrent.TimeUnit;
                final int responseLength = rangeEnd - rangeStart + 1;
            } finally {
        });
        );
        // The request retry policy counts the first attempt as retry, so we need to
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
            }
            assertArrayEquals(bytes, BytesReference.toBytes(Streams.readFully(inputStream)));
                    <?xml version="1.0" encoding="UTF-8"?>
            if ("PUT".equals(exchange.getRequestMethod())) {
        return createBlobContainer(maxRetries, (settings, clientName) -> {});
import java.util.stream.Collectors;
        httpServer.createContext("/container/write_blob_max_retries", exchange -> {
 * this work for additional information regarding copyright
            BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC
        assertEquals(1, requests.get());
import fixture.azure.AzureHttpHandler;
                if (randomBoolean()) {
                    RetryPolicyType.EXPONENTIAL,
                        final int length = bytes.length - rangeStart;
                            </Blob>
 * GitHub history for details.
                return new RequestRetryOptions(
import static org.hamcrest.Matchers.containsString;
                    final ByteArrayOutputStream blob = new ByteArrayOutputStream();
                }
        final BlobContainer blobContainer = createBlobContainer(maxRetries);
                    """;
        secureSettings.setString(ACCOUNT_SETTING.getConcreteSettingForNamespace(clientName).getKey(), "account");
        final BlobContainer blobContainer = createBlobContainer(randomIntBetween(2, 5));
                    }
        final BlobContainer blobContainer = createBlobContainer(
                        <Blob>
 * ownership. Elasticsearch licenses this file to you under
                    exchange.sendResponseHeaders(RestStatus.OK.getStatus(), -1);
            public void reset() {
                          <Name>metadata-2</Name>
    private ThreadPool threadPool;
                        .filter(line -> line.contains("</Latest>"))
                if ("HEAD".equals(exchange.getRequestMethod())) {
                        <EnumerationResults>
            return Tuple.tuple(0L, MAX_RANGE_VAL);
    @AfterClass
                );
        final AtomicInteger requests = new AtomicInteger();
                RestUtils.decodeQueryString(exchange.getRequestURI().getQuery(), 0, params);
        final List<BlobMetadata> blobs = blobContainer.listBlobsByPrefixInSortedOrder(
        }
import java.io.IOException;
                        assertThat(rangeStart, lessThan(bytes.length));
        assertThat(blobContainer.readBlobPreferredLength(), is((long) blockSize));
                    return;
                    }
            } finally {
            @Override
                    return;
        });
 * software distributed under the License is distributed on an
        final int maxRetries = randomIntBetween(2, 6);
                          <Properties><Content-Length>12</Content-Length><BlobType>BlockBlob</BlobType></Properties>
                    sendXmlResponse(exchange, """
        httpServer.createContext("/container/read_blob_max_retries", exchange -> {
import org.opensearch.cluster.metadata.RepositoryMetadata;
                            <BlobPrefix><Name>metadata-child/</Name></BlobPrefix>
                    RestUtils.decodeQueryString(exchange.getRequestURI().getQuery(), 0, params);
        final String clientName = randomAlphaOfLength(5).toLowerCase(Locale.ROOT);
import org.opensearch.common.settings.Settings;
        return Optional.of(Math.toIntExact(rangeEnd));
        httpServer.createContext("/container/read_range_blob_max_retries", exchange -> {
                    }
}
                    assertEquals("next-page", params.get("marker"));
        final BlobContainer blobContainer = createBlobContainer(maxRetries);
        }
                assertThat(rangeEnd - rangeStart + 1, lessThanOrEqualTo(blockSize));
            assertThat(countDownGet.isCountedDown(), is(true));
            "metadata-",
                assertEquals("/", params.get("delimiter"));
                    final List<String> blockUids = Arrays.stream(blockList.split("<Latest>"))
            settings.put(WRITE_BLOCK_SIZE_SETTING.getConcreteSettingForNamespace(clientName).getKey(), blockSize + "b");
            blobContainer.writeBlob("write_blob_max_retries", stream, bytes.length, false);
                      <Blobs>
import org.opensearch.common.blobstore.BlobContainer;
        final BlobContainer blobContainer = createBlobContainer(maxRetries);
                if ("HEAD".equals(exchange.getRequestMethod())) {
        httpServer.createContext("/container", exchange -> {
        });
 * under the License.
            public boolean markSupported() {
                        Streams.readFully(exchange.getRequestBody());
        service = new AzureStorageService(clientSettings.build()) {
                requests.incrementAndGet();
    public void testWriteBlobWithRetries() throws Exception {
                return true;
                        block.writeTo(blob);
    public void testListBlobsByPrefixInSortedOrderContinuesAfterPrefixes() throws Exception {
            } finally {
        );
                sendXmlResponse(exchange, """
                    for (String blockUid : blockUids) {
                            .add("Content-Range", "bytes " + rangeStart + "-" + rangeEnd.get() + "/" + bytes.length);
                        <?xml version="1.0" encoding="UTF-8"?>
        assertEquals(List.of(11L, 12L), blobs.stream().map(BlobMetadata::length).toList());
import org.opensearch.common.SuppressForbidden;
                        final int length = (rangeEnd.get() - rangeStart) + 1;
                        <Blob>
        }
        final byte[] data = randomBytes(blockSize * nbBlocks);
                }
                assertThat(rangeStart, lessThan(bytes.length));
                    secondaryHost
                          </Blobs>
                }
        threadPool = new TestThreadPool(getTestClass().getName(), AzureRepositoryPlugin.executorBuilder());
                        final Optional<Integer> rangeEnd = getRangeEnd(exchange);
    }
 * the Apache License, Version 2.0 (the "License"); you may
        }
                    }
                    } else {
                }
                    if (randomBoolean()) {
        final AtomicInteger countDownUploads = new AtomicInteger(nbErrors * nbBlocks);
                        assertThat(rangeStart, lessThan(bytes.length));
        httpServer.createContext("/container/write_large_blob", exchange -> {
    public void tearDown() throws Exception {
                } else {
        exchange.getResponseHeaders().add("x-ms-request-server-encrypted", "false");
                if (countDown.countDown()) {
    }
            IllegalArgumentException.class,
                    if (countDownHead.countDown()) {
 */
    }
                        return;
import java.net.InetAddress;
import org.opensearch.common.io.Streams;
                final Tuple<Long, Long> range = getRanges(exchange);
                          </Blobs>
        }) {
                          <Blobs>
                    exchange.getResponseHeaders().add("Content-Length", String.valueOf(bytes.length));
        }
        final CountDown countDownGet = new CountDown(maxRetries - 1);
                        exchange.sendResponseHeaders(RestStatus.CREATED.getStatus(), -1);
            if ("PUT".equals(exchange.getRequestMethod())) {
                sendXmlResponse(exchange, response);
        try (InputStream inputStream = blobContainer.readBlob("read_range_blob_max_retries", position, length)) {
    }
        final int blockSize = Math.toIntExact(ByteSizeUnit.MB.toBytes(1));
                          <Properties><Content-Length>11</Content-Length><BlobType>BlockBlob</BlobType></Properties>
                exchange.close();
            "metadata-",
        final BlobContainer blobContainer = createBlobContainer(between(1, 5));
    }
    }
        }
    private HttpServer httpServer;
    public void testReadNonexistentBlobThrowsNoSuchFileException() {
            exchange.close();
import org.junit.After;
    }
                blobContainer.readBlob("read_nonexistent_blob");
                        exchange.getResponseHeaders()
import java.util.regex.Matcher;
        httpServer.createContext("/container", exchange -> {
        HttpResources.disposeLoopsAndConnections();
            } finally {
                        AzureHttpHandler.sendError(exchange, RestStatus.BAD_REQUEST);
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.opensearch.repositories.azure.AzureStorageSettings.ACCOUNT_SETTING;
                        exchange.sendResponseHeaders(RestStatus.OK.getStatus(), -1);
                        assert block != null;
                exchange.getResponseBody().write(bytes, rangeStart, responseLength);
    }
                    </EnumerationResults>
                        exchange.getResponseBody().write(bytes, rangeStart, length);
        super.tearDown();
        final int nbBlocks = randomIntBetween(2, 3);
 *
import org.opensearch.common.collect.Tuple;
                        <Blob>
    }
                          <Name>metadata-3</Name>
                AzureHttpHandler.sendError(exchange, randomFrom(RestStatus.INTERNAL_SERVER_ERROR, RestStatus.SERVICE_UNAVAILABLE));
                final long length = randomLongBetween(1, MAX_RANGE_VAL - position);
                          <Properties><Content-Length>13</Content-Length><BlobType>BlockBlob</BlobType></Properties>
        }
                        final int rangeStart = getRangeStart(exchange);
                    }
                assertEquals("2", params.get("maxresults"));
            service = null;
        final AtomicInteger requestCount = new AtomicInteger();
                    }
                    exchange.close();
            () -> blobContainer.listBlobsByPrefixInSortedOrder("metadata-", -1, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC)
/*
        try (InputStream stream = new InputStream() {
                }
                        <EnumerationResults>
                    azureStorageSettings.getMaxRetries(),
                assertThat(exchange.getRequestMethod(), is("GET"));
                    exchange.getResponseHeaders().add("x-ms-blob-type", "blockblob");
public class AzureBlobContainerRetriesTests extends OpenSearchTestCase {
import java.util.HashMap;
                exchange.close();
                        Streams.readFully(exchange.getRequestBody(), new byte[randomIntBetween(1, Math.max(1, bytes.length - 1))]);
        exchange.getResponseHeaders().add("Content-Type", "application/xml");
            try {
        final CountDown countDownHead = new CountDown(maxRetries - 1);
                if ("blocklist".equals(complete) && (countDownComplete.countDown())) {
                        assertThat(length, lessThanOrEqualTo(bytes.length - rangeStart));
    }
            }
                exchange.sendResponseHeaders(RestStatus.PARTIAL_CONTENT.getStatus(), responseLength);
import static org.opensearch.repositories.azure.AzureStorageSettings.ENDPOINT_SUFFIX_SETTING;
import org.opensearch.common.blobstore.BlobMetadata;
                final String complete = params.get("comp");
            + InetAddresses.toUriString(address.getAddress())
        );
                exchange.close();
import static org.hamcrest.Matchers.lessThan;
import java.util.Base64;
            settings.put(WRITE_CONCURRENCY_SETTING.getConcreteSettingForNamespace(clientName).getKey(), 2);
 * KIND, either express or implied.  See the License for the
        httpServer.createContext("/container/read_blob_with_configured_block_size", exchange -> {
        clientSettings.setSecureSettings(secureSettings);
                    if (countDownGet.countDown()) {
    public static void shutdownSchedulers() {
                        return;
        return Tuple.tuple(rangeStart, rangeEnd);
            final byte[] bytesRead = BytesReference.toBytes(Streams.readFully(inputStream));
                assertEquals("metadata-", params.get("prefix"));
                    AzureHttpHandler.sendError(exchange, randomFrom(RestStatus.INTERNAL_SERVER_ERROR, RestStatus.SERVICE_UNAVAILABLE));
        return Math.toIntExact(getRanges(exchange).v1());
                        exchange.getResponseBody().write(bytes, rangeStart, length);
 * not use this file except in compliance with the License.
import java.util.function.BiConsumer;
                } else if ("GET".equals(exchange.getRequestMethod())) {
                final Map<String, String> params = new HashMap<>();
                            <Blob>
 * license agreements. See the NOTICE file distributed with
                assertEquals("2", params.get("maxresults"));
        assertTrue(rangeHeader + " matches expected pattern", matcher.matches());
                    } else {
        final AtomicInteger requests = new AtomicInteger();
        final int length = randomIntBetween(1, bytes.length - position);
                        BytesReference block = blocks.remove(blockUid);
            }
import org.opensearch.threadpool.ThreadPool;
                            <Blob>
                          <NextMarker>next-page</NextMarker>
 * specific language governing permissions and limitations
import static java.nio.charset.StandardCharsets.UTF_8;
        final int nbErrors = 2; // we want all requests to fail at least once
                    exchange.close();
import org.opensearch.rest.RestUtils;
 * This class tests how a {@link AzureBlobContainer} and its underlying SDK client are retrying requests when reading or writing blobs.
        final long rangeStart = Long.parseLong(matcher.group(1));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
        expectThrows(
            }
            } finally {
                        .map(line -> line.substring(0, line.indexOf("</Latest>")))
import reactor.core.scheduler.Schedulers;
import java.io.InputStream;
        final byte[] bytes = randomBlobContent();
    private BlobContainer createBlobContainer(final int maxRetries) {
        exchange.getResponseBody().write(body);
    }
 * The OpenSearch Contributors require contributions made to
import static org.opensearch.repositories.blobstore.OpenSearchBlobStoreRepositoryIntegTestCase.randomBytes;
                              <Name>metadata-2</Name>
                    return;
import org.opensearch.core.common.bytes.BytesReference;
        final int blockSize = 128;
                exchange.close();
            assertThat(countDownHead.isCountedDown(), is(false));
 * Licensed to Elasticsearch under one or more contributor
                    sendXmlResponse(exchange, """
                        exchange.getResponseHeaders().add("x-ms-blob-type", "blockblob");
                    exchange.sendResponseHeaders(RestStatus.CREATED.getStatus(), -1);
import org.opensearch.core.common.unit.ByteSizeUnit;
                requestCount.incrementAndGet();
        assertTrue(
    }
                final Map<String, String> params = new HashMap<>();
import org.opensearch.common.network.InetAddresses;
        assertThat(exception.getMessage().toLowerCase(Locale.ROOT), containsString("404"));
        final String rangeHeader = exchange.getRequestHeaders().getFirst("X-ms-range");
import static org.opensearch.repositories.azure.AzureStorageSettings.KEY_SETTING;
                exchange.getResponseHeaders().add("Content-Length", String.valueOf(responseLength));
                    exchange.sendResponseHeaders(RestStatus.CREATED.getStatus(), -1);
    private static int getRangeStart(HttpExchange exchange) {
        final int maxRetries = randomIntBetween(2, 6);
        });
                        exchange.getResponseHeaders().add("Content-Length", String.valueOf(length));
                    exchange.getResponseHeaders().add("Content-Type", "application/octet-stream");
        final Exception exception = expectThrows(NoSuchFileException.class, () -> {
    public void testDefaultReadBlockSize() {
import java.util.Map;
        });
            + address.getPort()
            @Override
        try (InputStream inputStream = blobContainer.readBlob("read_blob_max_retries")) {
                        exchange.getResponseHeaders().add("Content-Length", String.valueOf(length));
        ThreadPool.terminate(threadPool, 10L, TimeUnit.SECONDS);
        clientSettings.put(MAX_RETRIES_SETTING.getConcreteSettingForNamespace(clientName).getKey(), maxRetries);
            try {
                exchange.getResponseHeaders().add("x-ms-request-server-encrypted", "false");
                    assertEquals(2, request);
    }
    private static final Pattern RANGE_PATTERN = Pattern.compile("^bytes=([0-9]+)-([0-9]+)$");
            Settings.builder().put(CONTAINER_SETTING.getKey(), "container").put(ACCOUNT_SETTING.getKey(), clientName).build()
import org.opensearch.common.unit.TimeValue;
                exchange.getResponseHeaders().add("Content-Type", "application/octet-stream");
import org.opensearch.core.common.Strings;
            }
            );
        });
        assertEquals(List.of("metadata-1", "metadata-2"), blobs.stream().map(BlobMetadata::name).toList());
    private AzureStorageService service;
                final int request = requests.incrementAndGet();
    private static Tuple<Long, Long> getRanges(HttpExchange exchange) {
        httpServer.createContext("/", (exchange) -> {
import reactor.netty.http.HttpResources;
    @Before
            }
                    100L,
import java.util.concurrent.atomic.AtomicInteger;
            } finally {
    public void testReadRangeBlobWithRetries() throws Exception {
                    blocks.put(blockId, Streams.readFully(exchange.getRequestBody()));
        final Map<String, BytesReference> blocks = new ConcurrentHashMap<>();
                      <NextMarker />
 * compatible open source license.
                        AzureHttpHandler.sendError(exchange, randomFrom(RestStatus.INTERNAL_SERVER_ERROR, RestStatus.SERVICE_UNAVAILABLE));
                exchange.close();
        httpServer.createContext("/container", exchange -> {
        exchange.sendResponseHeaders(RestStatus.OK.getStatus(), body.length);
        clientSettings.put(TIMEOUT_SETTING.getConcreteSettingForNamespace(clientName).getKey(), TimeValue.timeValueMillis(5000));
                final String response = """
    private static byte[] randomBlobContent() {
                        """);
                        </Blob>
        assertThat(countDownComplete.isCountedDown(), is(true));
                        assertThat(rangeEnd.isPresent(), is(true));
        try (InputStream stream = new InputStreamIndexInput(new ByteArrayIndexInput("desc", bytes), bytes.length)) {
                    throw new AssertionError("Should not receive two requests");
                        </EnumerationResults>
package org.opensearch.repositories.azure;
        assertThat(rangeStart, lessThanOrEqualTo(rangeEnd));
        final String endpoint = "ignored;DefaultEndpointsProtocol=http;BlobEndpoint=http://"
 * SPDX-License-Identifier: Apache-2.0
        if (rangeHeader == null) {
            exchange.close();
        final BlobContainer blobContainer = createBlobContainer(between(1, 5));
 */
            public int read() throws IOException {
                blockSize + "b"
                        exchange.sendResponseHeaders(RestStatus.OK.getStatus(), length);
                        final int rangeStart = getRangeStart(exchange);
            }
    private static final long MAX_RANGE_VAL = Long.MAX_VALUE - 1L;
        }
 * You may obtain a copy of the License at
        try (InputStream stream = new InputStreamIndexInput(new ByteArrayIndexInput("desc", data), data.length)) {
                      <Blobs />
        });
        });
    }
        final BlobContainer blobContainer = createBlobContainer(between(1, 5));
 *    http://www.apache.org/licenses/LICENSE-2.0
            if (randomBoolean()) {
        // account for that and increase the max retry count by one.
                } else if ("GET".equals(exchange.getRequestMethod())) {
/*
                          <Name>metadata-1</Name>
                }
        return randomByteArrayOfLength(randomIntBetween(1, frequently() ? 512 : 1 << 20)); // rarely up to 1mb
            }
                        exchange.getResponseHeaders().add("Content-Range", "bytes " + rangeStart + "-" + bytes.length + "/" + bytes.length);
        // The request retry policy counts the first attempt as retry, so we need to
                          <Blobs>
                if (randomBoolean()) {
        );
                exchange.close();
import com.azure.storage.common.policy.RequestRetryOptions;
                    exchange.getResponseHeaders().add("x-ms-request-server-encrypted", "false");
import org.opensearch.test.OpenSearchTestCase;
            final IOException ioe = expectThrows(
        final AtomicBoolean requestReceived = new AtomicBoolean(false);
    private BlobContainer createBlobContainer(final int maxRetries, BiConsumer<Settings.Builder, String> configureClient) {
        httpServer.start();
        if (service != null) {
    public void setUp() throws Exception {
                    <EnumerationResults>
                    <?xml version="1.0" encoding="UTF-8"?>
            blobContainer.listBlobsByPrefixInSortedOrder("metadata-", 5001, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC).isEmpty()
            }
                throw new IOException("foo");
        assertEquals(List.of("metadata-1", "metadata-2"), blobs.stream().map(BlobMetadata::name).toList());
        final int maxRetries = randomIntBetween(3, 6);
        assertThat(blobContainer.readBlobPreferredLength(), is((long) AzureBlobContainer.DEFAULT_MINIMUM_READ_SIZE_IN_BYTES));
                    5,
                assertEquals("5000", params.get("maxresults"));
        final byte[] bytes = randomBlobContent();
        // The request retry policy counts the first attempt as retry, so we need to
                        exchange.getResponseHeaders().add("Content-Type", "application/octet-stream");
                        .collect(Collectors.toList());
        final InetSocketAddress address = httpServer.getAddress();
    public void testListBlobsByPrefixInSortedOrderPushesLimitToAzure() throws Exception {
                        assertThat(rangeEnd.get(), greaterThanOrEqualTo(rangeStart));
                      <NextMarker />
            exchange.sendResponseHeaders(404, 0L);
import org.opensearch.common.blobstore.BlobPath;
                exchange.close();
                final int rangeStart = Math.toIntExact(range.v1());
import org.opensearch.common.util.concurrent.CountDown;
                final Map<String, String> params = new HashMap<>();
            assertArrayEquals(Arrays.copyOfRange(bytes, position, Math.min(bytes.length, position + length)), bytesRead);
                    """);
    public void testReadBlobWithRetries() throws Exception {
                } else {
import org.opensearch.common.settings.MockSecureSettings;
                if (request == 1) {
            assertArrayEquals(bytes, BytesReference.toBytes(Streams.readFully(inputStream)));
        // account for that and increase the max retry count by one.
                        exchange.getResponseHeaders().add("Content-Type", "application/octet-stream");
        final byte[] bytes = randomBytes(blockSize * 3 + 17);
        );
            try {
        final MockSecureSettings secureSettings = new MockSecureSettings();
                () -> blobContainer.writeBlob("write_blob_max_retries", stream, randomIntBetween(1, 128), randomBoolean())
                    final BytesReference body = Streams.readFully(exchange.getRequestBody());
                if (exchange.getRequestURI().getQuery() != null) {
import java.util.regex.Pattern;
                    exchange.close();
                        exchange.getResponseHeaders().add("Content-Length", String.valueOf(bytes.length));
        final CountDown countDown = new CountDown(maxRetries - 1);
import static org.opensearch.repositories.azure.AzureStorageSettings.READ_BLOCK_SIZE_SETTING;
