import java.net.InetAddress;
                    <EnumerationResults>  
                assertEquals("metadata-", params.get("prefix"));
            assertThat(countDownGet.isCountedDown(), is(true));  
import static org.opensearch.repositories.azure.AzureStorageSettings.MAX_RETRIES_SETTING;
                if (randomBoolean()) {
                }
            assertThat(countDownHead.isCountedDown(), is(false));
    public void testListBlobsByPrefixInSortedOrderContinuesAfterPrefixes() throws Exception {  
                }  
                          </Blobs>
import static org.opensearch.repositories.blobstore.OpenSearchBlobStoreRepositoryIntegTestCase.randomBytes;
            if (randomBoolean()) {  
                final int rangeEnd = Math.min(Math.toIntExact(range.v2()), bytes.length - 1);
                    10L,
                assertThat(exchange.getRequestMethod(), is("GET"));  
                    } else {
        assertEquals(List.of(11L, 12L), blobs.stream().map(BlobMetadata::length).toList());
                RestUtils.decodeQueryString(exchange.getRequestURI().getQuery(), 0, params);
    private static byte[] randomBlobContent() {
                              <Properties><Content-Length>11</Content-Length><BlobType>BlockBlob</BlobType></Properties>
                        Streams.readFully(exchange.getRequestBody());  
        httpServer.createContext("/container", exchange -> {
        final byte[] bytes = randomBytes(blockSize * 3 + 17);
                          <NextMarker />
        }  
                          <Name>metadata-1</Name>  
                }  
                final long position = randomLongBetween(0, MAX_RANGE_VAL - 1L);  
            service.close();  
    public void testRetryUntilFail() throws IOException {  
            blobContainer.writeBlob("write_blob_max_retries", stream, bytes.length, false);
 */
            service = null;
    public void testDefaultReadBlockSize() {
                    }
                          <Blobs>
                        exchange.getResponseHeaders().add("Content-Type", "application/octet-stream");
        );
 * SPDX-License-Identifier: Apache-2.0
        final Map<String, BytesReference> blocks = new ConcurrentHashMap<>();
 * license agreements. See the NOTICE file distributed with
                RestUtils.decodeQueryString(exchange.getRequestURI().getQuery(), 0, params);
    }
                              <Name>metadata-2</Name>
                final int rangeStart = Math.toIntExact(range.v1());
        final BlobContainer blobContainer = createBlobContainer(between(1, 5));  
        });
                assertEquals("5000", params.get("maxresults"));
            }  
    }
        // account for that and increase the max retry count by one.
        assertThat(countDownComplete.isCountedDown(), is(true));
import org.opensearch.common.blobstore.BlobPath;  
                          <Name>metadata-3</Name>
            BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC  
    }
 * Unless required by applicable law or agreed to in writing,
                if (requestReceived.compareAndSet(false, true)) {
import reactor.netty.http.HttpResources;  
                requestCount.incrementAndGet();
                        final int rangeStart = getRangeStart(exchange);
                if (exchange.getRequestURI().getQuery() != null) {
package org.opensearch.repositories.azure;
        final BlobContainer blobContainer = createBlobContainer(randomIntBetween(2, 5));
                exchange.getResponseBody().write(bytes, rangeStart, responseLength);
    public static void shutdownSchedulers() {
                if ("HEAD".equals(exchange.getRequestMethod())) {  
 * not use this file except in compliance with the License.
        final long rangeStart = Long.parseLong(matcher.group(1));  
                        assertThat(rangeStart, lessThan(bytes.length));
import java.util.Objects;
import java.util.function.BiConsumer;
            if ("PUT".equals(exchange.getRequestMethod())) {  
        assertThat(requestCount.get(), greaterThanOrEqualTo(4));
            } finally {  
 *
            BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC
            exchange.sendResponseHeaders(404, 0L);
        try (InputStream inputStream = blobContainer.readBlob("read_range_blob_max_retries", position, length)) {  
import static org.opensearch.repositories.azure.AzureStorageSettings.ACCOUNT_SETTING;
        assertThat(blocks.isEmpty(), is(true));  
                        </Blob>
                        BytesReference block = blocks.remove(blockUid);
        });
 * ownership. Elasticsearch licenses this file to you under  
        final String key = Base64.getEncoder().encodeToString(randomAlphaOfLength(10).getBytes(UTF_8));  
                blobContainer.readBlob("read_nonexistent_blob");
import org.opensearch.common.lucene.store.InputStreamIndexInput;
                        AzureHttpHandler.sendError(exchange, RestStatus.BAD_REQUEST);
import org.opensearch.test.OpenSearchTestCase;  
        final int maxRetries = randomIntBetween(2, 6);
                }  
        // account for that and increase the max retry count by one.
    }
                    if (randomBoolean()) {  
                    blocks.put(blockId, Streams.readFully(exchange.getRequestBody()));
        httpServer.createContext("/container/read_blob_max_retries", exchange -> {  
import java.util.concurrent.atomic.AtomicInteger;
                      </Blobs>
 * You may obtain a copy of the License at  
                        <Blob>
import org.opensearch.core.rest.RestStatus;
import static org.hamcrest.Matchers.is;
                        exchange.getResponseHeaders().add("Content-Type", "application/octet-stream");
    }
        exchange.getResponseHeaders().add("x-ms-request-server-encrypted", "false");  
                    if (countDownHead.countDown()) {
            try {  
        final BlobContainer blobContainer = createBlobContainer(maxRetries);  
import java.util.regex.Matcher;  
import com.azure.storage.common.policy.RetryPolicyType;
        assertThat(blobContainer.readBlobPreferredLength(), is((long) AzureBlobContainer.DEFAULT_MINIMUM_READ_SIZE_IN_BYTES));  
            RequestRetryOptions createRetryPolicy(final AzureStorageSettings azureStorageSettings, String secondaryHost) {  
            try {
import org.opensearch.common.network.InetAddresses;
        final byte[] data = randomBytes(blockSize * nbBlocks);
                final int request = requests.incrementAndGet();
            } finally {  
            if ("PUT".equals(exchange.getRequestMethod())) {  
                            <BlobPrefix><Name>metadata-child/</Name></BlobPrefix>
            try {
                        return;
                    exchange.close();
                    AzureHttpHandler.sendError(exchange, randomFrom(RestStatus.INTERNAL_SERVER_ERROR, RestStatus.SERVICE_UNAVAILABLE));
        assertEquals(1, requests.get());
        final CountDown countDownGet = new CountDown(maxRetries - 1);
import java.nio.file.NoSuchFileException;
        return Tuple.tuple(rangeStart, rangeEnd);  
                    <?xml version="1.0" encoding="UTF-8"?>
        httpServer = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);  
                            </Blob>  
    private BlobContainer createBlobContainer(final int maxRetries, BiConsumer<Settings.Builder, String> configureClient) {
                    for (String blockUid : blockUids) {  
                blockSize + "b"  
    }
import static org.hamcrest.Matchers.equalTo;  
                    RetryPolicyType.EXPONENTIAL,
            assertThat(countDownGet.isCountedDown(), is(true));
        }  
        }
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        );
import static org.opensearch.repositories.azure.AzureStorageSettings.READ_BLOCK_SIZE_SETTING;  
                    exchange.close();
import reactor.core.scheduler.Schedulers;
                    assertArrayEquals(data, blob.toByteArray());
        exchange.getResponseHeaders().add("Content-Type", "application/xml");
import com.azure.storage.common.policy.RequestRetryOptions;  
                    if (countDownGet.countDown()) {  
        return new AzureBlobContainer(BlobPath.cleanPath(), new AzureBlobStore(repositoryMetadata, service, threadPool), threadPool);
/*
        httpServer.createContext("/container", exchange -> {  
            } else {
            if (randomBoolean()) {
import org.opensearch.core.common.unit.ByteSizeUnit;  
@SuppressForbidden(reason = "use a http server")  
                        block.writeTo(blob);  
            }
        final byte[] bytes = randomBlobContent();
                final String response = """
                final long length = randomLongBetween(1, MAX_RANGE_VAL - position);
                blobContainer.readBlob("read_nonexistent_blob", position, length);
    public void testConfiguredReadBlockSize() throws Exception {  
            "repository",
                        <Blob>
        final Exception exception = expectThrows(NoSuchFileException.class, () -> {
                exchange.getResponseHeaders().add("Content-Range", "bytes " + rangeStart + "-" + rangeEnd + "/" + bytes.length);
    private BlobContainer createBlobContainer(final int maxRetries) {  
import org.opensearch.common.io.Streams;
                exchange.getResponseHeaders().add("x-ms-blob-type", "blockblob");
                        assertThat(length, lessThanOrEqualTo(bytes.length - rangeStart));
    private static final long MAX_RANGE_VAL = Long.MAX_VALUE - 1L;  
                exchange.close();
        Schedulers.shutdownNow();  
}
                        </EnumerationResults>  
        };
        final List<BlobMetadata> blobs = blobContainer.listBlobsByPrefixInSortedOrder(
            final byte[] bytesRead = BytesReference.toBytes(Streams.readFully(inputStream));
                exchange.close();
    private static int getRangeStart(HttpExchange exchange) {  
        });  
        assertTrue(blobContainer.listBlobsByPrefixInSortedOrder("metadata-", 0, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC).isEmpty());
import org.opensearch.threadpool.TestThreadPool;
                } else if ("GET".equals(exchange.getRequestMethod())) {
                } else {
        final byte[] bytes = randomBlobContent();
    private ThreadPool threadPool;  
                RestUtils.decodeQueryString(exchange.getRequestURI().getQuery(), 0, params);
        HttpResources.disposeLoopsAndConnections();
        // The request retry policy counts the first attempt as retry, so we need to
        if (rangeEnd == MAX_RANGE_VAL) {  
            } finally {
import org.junit.Before;
            IllegalArgumentException.class,
            }
import java.io.InputStream;  
                        """);
                        </Blob>
                final String complete = params.get("comp");  
            + ":"
                        assertThat(rangeEnd.isPresent(), is(true));
        final CountDown countDown = new CountDown(maxRetries - 1);
    }  
public class AzureBlobContainerRetriesTests extends OpenSearchTestCase {
        final AtomicInteger requests = new AtomicInteger();
                          </Blobs>  
                    }  
        secureSettings.setString(KEY_SETTING.getConcreteSettingForNamespace(clientName).getKey(), key);
    }
                        assertThat(rangeEnd.get(), greaterThanOrEqualTo(rangeStart));  
 * Modifications Copyright OpenSearch Contributors. See  
                        assertThat(rangeStart, lessThan(bytes.length));  
        service = new AzureStorageService(clientSettings.build()) {
            }
import org.junit.AfterClass;
            }
                        </EnumerationResults>
                        assert block != null;
                    final ByteArrayOutputStream blob = new ByteArrayOutputStream();
        exchange.getResponseBody().write(body);
            @Override
        super.tearDown();
        });  
        final BlobContainer blobContainer = createBlobContainer(between(1, 5));
        assertEquals(2, requests.get());  
                      <NextMarker />  
                            <Blob>
import static java.nio.charset.StandardCharsets.UTF_8;
                Streams.readFully(exchange.getRequestBody());
        configureClient.accept(clientSettings, clientName);
        );
                    final String blockList = Streams.copyToString(new InputStreamReader(exchange.getRequestBody(), UTF_8));
                AzureHttpHandler.sendError(exchange, randomFrom(RestStatus.INTERNAL_SERVER_ERROR, RestStatus.SERVICE_UNAVAILABLE));  
    }
                exchange.getResponseHeaders().add("Content-Length", String.valueOf(responseLength));  
import java.util.Optional;  
                        exchange.getResponseHeaders().add("x-ms-blob-type", "blockblob");
import org.opensearch.cluster.metadata.RepositoryMetadata;
        httpServer.createContext("/container/write_blob_max_retries", exchange -> {
                Streams.readFully(exchange.getRequestBody());
import org.opensearch.common.unit.TimeValue;
import com.sun.net.httpserver.HttpServer;
            + "/";
    public void testReadRangeBlobWithRetries() throws Exception {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            () -> blobContainer.listBlobsByPrefixInSortedOrder("metadata-", -1, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC)
        try (InputStream stream = new InputStreamIndexInput(new ByteArrayIndexInput("desc", data), data.length)) {
        );
        final AtomicInteger requestCount = new AtomicInteger();  
            );
        final int maxRetries = randomIntBetween(2, 6);
 *
        super.setUp();  
        final int blockSize = Math.toIntExact(ByteSizeUnit.MB.toBytes(1));
            } finally {
        assertThat(blobContainer.readBlobPreferredLength(), is((long) blockSize));  
                if (request == 1) {
                    throw new AssertionError("Should not receive two requests");
                    exchange.getResponseHeaders().add("Content-Length", String.valueOf(bytes.length));
                final Map<String, String> params = new HashMap<>();  
                    <?xml version="1.0" encoding="UTF-8"?>
import java.util.concurrent.TimeUnit;
            assertArrayEquals(bytes, BytesReference.toBytes(Streams.readFully(inputStream)));
                exchange.sendResponseHeaders(RestStatus.PARTIAL_CONTENT.getStatus(), responseLength);  
        final BlobContainer blobContainer = createBlobContainer(
        final AtomicInteger countDownUploads = new AtomicInteger(nbErrors * nbBlocks);
    public void testWriteBlobWithRetries() throws Exception {
                assertThat(rangeEnd - rangeStart + 1, lessThanOrEqualTo(blockSize));
            try {  
        clientSettings.put(MAX_RETRIES_SETTING.getConcreteSettingForNamespace(clientName).getKey(), maxRetries);  
    }
                    assertNull(params.get("marker"));  
    }
                    exchange.getResponseHeaders().add("x-ms-request-server-encrypted", "false");  
    private AzureStorageService service;
            return Tuple.tuple(0L, MAX_RANGE_VAL);
        ThreadPool.terminate(threadPool, 10L, TimeUnit.SECONDS);  
                        exchange.getResponseHeaders().add("Content-Length", String.valueOf(length));
                }  
        clientSettings.setSecureSettings(secureSettings);
import java.util.concurrent.ConcurrentHashMap;
 * specific language governing permissions and limitations
            } finally {
                () -> blobContainer.writeBlob("write_blob_max_retries", stream, randomIntBetween(1, 128), randomBoolean())
                    secondaryHost
                          <Name>metadata-2</Name>
        final BlobContainer blobContainer = createBlobContainer(between(1, 5));
            }  
                );
            2,
                exchange.close();
/*  
import org.opensearch.rest.RestUtils;
 *    http://www.apache.org/licenses/LICENSE-2.0
                if (randomBoolean()) {
 * GitHub history for details.
        final int maxRetries = randomIntBetween(3, 6);  
    public void testListBlobsByPrefixInSortedOrderPushesLimitToAzure() throws Exception {
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        final byte[] body = response.getBytes(UTF_8);
                    }
                        exchange.sendResponseHeaders(RestStatus.OK.getStatus(), -1);
        });  
                        exchange.getResponseHeaders().add("Content-Range", "bytes " + rangeStart + "-" + bytes.length + "/" + bytes.length);
        assertEquals(0, requests.get());
        final String rangeHeader = exchange.getRequestHeaders().getFirst("X-ms-range");
 * software distributed under the License is distributed on an
        expectThrows(  
    @Before  
import org.opensearch.core.common.bytes.BytesReference;
                assertEquals("2", params.get("maxresults"));  
                        <Blob>  
                        exchange.getResponseBody().write(bytes, rangeStart, length);  
 * This class tests how a {@link AzureBlobContainer} and its underlying SDK client are retrying requests when reading or writing blobs.
                          <Properties><Content-Length>11</Content-Length><BlobType>BlockBlob</BlobType></Properties>
                    sendXmlResponse(exchange, """
    @After  
import java.io.IOException;
                IOException.class,  
                exchange.close();
        final Matcher matcher = RANGE_PATTERN.matcher(rangeHeader);
        httpServer.createContext("/container", exchange -> {
        final List<BlobMetadata> blobs = blobContainer.listBlobsByPrefixInSortedOrder(  
 * compatible open source license.
        httpServer.createContext("/container/write_large_blob", exchange -> {
    @AfterClass  
            AzureRepository.TYPE,  
    }
import static org.opensearch.repositories.azure.AzureStorageSettings.TIMEOUT_SETTING;
        try (InputStream stream = new InputStreamIndexInput(new ByteArrayIndexInput("desc", bytes), bytes.length)) {  
        try (InputStream inputStream = blobContainer.readBlob("read_blob_max_retries")) {
                final String blockId = params.get("blockid");  
                          <NextMarker>next-page</NextMarker>
    }
            public void reset() {
        return createBlobContainer(maxRetries, (settings, clientName) -> {});
        clientSettings.put(ENDPOINT_SUFFIX_SETTING.getConcreteSettingForNamespace(clientName).getKey(), endpoint);
                    return;  
            "metadata-",
                    <EnumerationResults>
                final Map<String, String> params = new HashMap<>();  
                        return;  
                throw new IOException("foo");
import java.util.stream.Collectors;
        assertTrue(rangeHeader + " matches expected pattern", matcher.matches());
import java.util.List;
                }
                if (Strings.hasText(blockId) && (countDownUploads.decrementAndGet() % 2 == 0)) {
            )
        }
            assertThat(ioe.getMessage(), is("foo"));  
            settings.put(MAX_SINGLE_UPLOAD_SIZE_SETTING.getConcreteSettingForNamespace(clientName).getKey(), blockSize + "b");
        }
 */
            }  
                    azureStorageSettings.getMaxRetries(),  
        }
                exchange.close();
                    final List<String> blockUids = Arrays.stream(blockList.split("<Latest>"))  
        assertTrue(
        final int nbErrors = 2; // we want all requests to fail at least once  
        final BlobContainer blobContainer = createBlobContainer(maxRetries);  
import org.opensearch.common.collect.Tuple;
            try {
                        <?xml version="1.0" encoding="UTF-8"?>
            return Optional.empty();
                        exchange.getResponseHeaders().add("Content-Length", String.valueOf(length));
                final Map<String, String> params = new HashMap<>();
        }
        final CountDown countDownComplete = new CountDown(nbErrors);
                          <Properties><Content-Length>13</Content-Length><BlobType>BlockBlob</BlobType></Properties>  
                READ_BLOCK_SIZE_SETTING.getConcreteSettingForNamespace(clientName).getKey(),
    }  
    private static final Pattern RANGE_PATTERN = Pattern.compile("^bytes=([0-9]+)-([0-9]+)$");
                        .map(line -> line.substring(0, line.indexOf("</Latest>")))
        httpServer.createContext("/container/write_blob_max_retries", exchange -> {
 *  
                            <Blob>  
                        .collect(Collectors.toList());  
    private static void sendXmlResponse(HttpExchange exchange, String response) throws IOException {  
    }  
                sendXmlResponse(exchange, response);  
                assertEquals("2", params.get("maxresults"));
                        exchange.getResponseHeaders()
        );  
        final BlobContainer blobContainer = createBlobContainer(maxRetries);
                    return;
        final BlobContainer blobContainer = createBlobContainer(between(1, 5));  
        assertThat(exception.getMessage().toLowerCase(Locale.ROOT), containsString("404"));
                exchange.close();
import org.opensearch.common.blobstore.BlobContainer;
                        exchange.getResponseHeaders().add("Content-Length", String.valueOf(bytes.length));  
                    exchange.close();
                    </EnumerationResults>
    private static Optional<Integer> getRangeEnd(HttpExchange exchange) {
import org.opensearch.common.blobstore.BlobMetadata;
                        """);  
                              <Properties><Content-Length>12</Content-Length><BlobType>BlockBlob</BlobType></Properties>
            exchange.close();
        final byte[] bytes = randomBlobContent();
                              <Name>metadata-1</Name>  
                return new RequestRetryOptions(
        httpServer.createContext("/", (exchange) -> {
import static org.opensearch.repositories.azure.AzureStorageSettings.WRITE_BLOCK_SIZE_SETTING;
        final String endpoint = "ignored;DefaultEndpointsProtocol=http;BlobEndpoint=http://"  
import org.junit.After;  
    private static Tuple<Long, Long> getRanges(HttpExchange exchange) {
                    exchange.sendResponseHeaders(RestStatus.CREATED.getStatus(), -1);
            public int read() throws IOException {  
                    final BytesReference body = Streams.readFully(exchange.getRequestBody());
            try {
import org.opensearch.threadpool.ThreadPool;
                        Streams.readFully(exchange.getRequestBody(), new byte[randomIntBetween(1, Math.max(1, bytes.length - 1))]);
            // No more getProperties() calls in BlobClientBase::openInputStream(), HEAD should not be invoked  
                            </Blob>
        final InetSocketAddress address = httpServer.getAddress();
                if (countDown.countDown()) {  
        }) {
        threadPool = new TestThreadPool(getTestClass().getName(), AzureRepositoryPlugin.executorBuilder());
import java.io.ByteArrayOutputStream;
 * The OpenSearch Contributors require contributions made to  
import java.util.regex.Pattern;
                assertEquals("/", params.get("delimiter"));  
                    """);  
        return Math.toIntExact(getRanges(exchange).v1());
            exchange.close();  
                    if (Objects.deepEquals(bytes, BytesReference.toBytes(body))) {
                    exchange.sendResponseHeaders(RestStatus.CREATED.getStatus(), -1);
            blobContainer.writeBlob("write_large_blob", stream, data.length, false);
                exchange.getResponseHeaders().add("x-ms-request-server-encrypted", "false");
import java.util.Locale;  
            @Override  
                }
                    }
        });
        httpServer.createContext("/container/read_blob_with_configured_block_size", exchange -> {
        final AtomicBoolean requestReceived = new AtomicBoolean(false);
                        exchange.getResponseHeaders().add("x-ms-blob-type", "blockblob");
            @Override
        return Optional.of(Math.toIntExact(rangeEnd));  
    }
        exchange.sendResponseHeaders(RestStatus.OK.getStatus(), body.length);
        final MockSecureSettings secureSettings = new MockSecureSettings();
                    """;
    }
import org.opensearch.common.util.concurrent.CountDown;  
import static org.opensearch.repositories.azure.AzureStorageSettings.ENDPOINT_SUFFIX_SETTING;
                requests.incrementAndGet();
                        final int rangeStart = getRangeStart(exchange);
        final long rangeEnd = getRanges(exchange).v2();
        assertEquals(List.of("metadata-1", "metadata-2"), blobs.stream().map(BlobMetadata::name).toList());
 * KIND, either express or implied.  See the License for the
                }  
                    sendXmlResponse(exchange, """
/**  
    public void testWriteLargeBlob() throws Exception {  
        clientSettings.put(TIMEOUT_SETTING.getConcreteSettingForNamespace(clientName).getKey(), TimeValue.timeValueMillis(5000));
        });  
            blobContainer.listBlobsByPrefixInSortedOrder("metadata-", 5001, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC).isEmpty()
                        .filter(line -> line.contains("</Latest>"))
    public void testReadNonexistentBlobThrowsNoSuchFileException() {  
                        </Blob>  
            } finally {
        }  
            + InetAddresses.toUriString(address.getAddress())
                      <NextMarker />
                    exchange.sendResponseHeaders(RestStatus.CREATED.getStatus(), -1);
                final int responseLength = rangeEnd - rangeStart + 1;
            + address.getPort()  
    public void testListBlobsByPrefixInSortedOrderCapsAzurePageSize() throws Exception {  
import static org.hamcrest.Matchers.lessThan;  
                            .add("Content-Range", "bytes " + rangeStart + "-" + rangeEnd.get() + "/" + bytes.length);  
        );  
            between(1, 5),  
                assertThat(rangeStart, lessThan(bytes.length));  
import java.io.InputStreamReader;
            assertArrayEquals(Arrays.copyOfRange(bytes, position, Math.min(bytes.length, position + length)), bytesRead);
    }
        final CountDown countDownGet = new CountDown(maxRetries - 1);
        try (InputStream inputStream = blobContainer.readBlob("read_blob_with_configured_block_size")) {
                    exchange.getResponseHeaders().add("x-ms-request-server-encrypted", "false");  
        secureSettings.setString(ACCOUNT_SETTING.getConcreteSettingForNamespace(clientName).getKey(), "account");
            final IOException ioe = expectThrows(
                    }
                assertEquals("GET", exchange.getRequestMethod());
                        AzureHttpHandler.sendError(exchange, randomFrom(RestStatus.INTERNAL_SERVER_ERROR, RestStatus.SERVICE_UNAVAILABLE));
    public void testReadBlobWithRetries() throws Exception {
    private HttpServer httpServer;
        // The request retry policy counts the first attempt as retry, so we need to
    }
                      <Blobs>
import org.opensearch.common.settings.Settings;
        });
            public boolean markSupported() {
        httpServer.createContext("/container/read_range_blob_max_retries", exchange -> {  
                } else {  
import org.opensearch.common.settings.MockSecureSettings;  
import java.net.InetSocketAddress;  
            }  
import java.util.Base64;  
        final int nbBlocks = randomIntBetween(2, 3);  
        final int position = randomIntBetween(0, bytes.length - 1);
                    AzureHttpHandler.sendError(exchange, randomFrom(RestStatus.INTERNAL_SERVER_ERROR, RestStatus.SERVICE_UNAVAILABLE));
                        exchange.getResponseHeaders().add("x-ms-blob-type", "blockblob");  
                        <EnumerationResults>  
        final CountDown countDownHead = new CountDown(maxRetries - 1);  
import static org.opensearch.repositories.azure.AzureStorageSettings.WRITE_CONCURRENCY_SETTING;  
                } else if ("GET".equals(exchange.getRequestMethod())) {  
import java.util.Map;
                    return;  
                throw new AssertionError("should not be called");
                sendXmlResponse(exchange, """  
    }
import org.opensearch.common.SuppressForbidden;  
        final long rangeEnd = Long.parseLong(matcher.group(2));
import org.opensearch.common.lucene.store.ByteArrayIndexInput;  
        final RepositoryMetadata repositoryMetadata = new RepositoryMetadata(
                        final Optional<Integer> rangeEnd = getRangeEnd(exchange);
import static org.opensearch.repositories.azure.AzureStorageSettings.KEY_SETTING;  
        assertThat(rangeStart, lessThanOrEqualTo(rangeEnd));
                }  
                    5,
        // account for that and increase the max retry count by one.
                }
import org.opensearch.core.common.Strings;
 * this file be licensed under the Apache-2.0 license or a
/*
            }
                          <Properties><Content-Length>12</Content-Length><BlobType>BlockBlob</BlobType></Properties>
 * under the License.  
                final Tuple<Long, Long> range = getRanges(exchange);
            }  
        httpServer.stop(0);
    public void tearDown() throws Exception {
                    assertEquals("next-page", params.get("marker"));  
        httpServer.start();
        return randomByteArrayOfLength(randomIntBetween(1, frequently() ? 512 : 1 << 20)); // rarely up to 1mb
        if (rangeHeader == null) {  
                Streams.readFully(exchange.getRequestBody());
 */
            settings.put(WRITE_CONCURRENCY_SETTING.getConcreteSettingForNamespace(clientName).getKey(), 2);
            @Override
        });
                    100L,  
                        <?xml version="1.0" encoding="UTF-8"?>
        final String clientName = randomAlphaOfLength(5).toLowerCase(Locale.ROOT);  
        final AtomicInteger requests = new AtomicInteger();
import java.util.concurrent.atomic.AtomicBoolean;  
 */  
            Settings.builder().put(CONTAINER_SETTING.getKey(), "container").put(ACCOUNT_SETTING.getKey(), clientName).build()
                return true;  
        final BlobContainer blobContainer = createBlobContainer(maxRetries, (settings, clientName) -> {
            }  
                }
                        final int length = (rangeEnd.get() - rangeStart) + 1;
        final Settings.Builder clientSettings = Settings.builder();
                    assertEquals(2, request);
        if (service != null) {
        assertThat(countDown.isCountedDown(), is(true));  
                    exchange.getResponseHeaders().add("x-ms-blob-type", "blockblob");  
import static org.hamcrest.Matchers.containsString;
        });  
        final int blockSize = 128;
            settings.put(WRITE_BLOCK_SIZE_SETTING.getConcreteSettingForNamespace(clientName).getKey(), blockSize + "b");  
                final Map<String, String> params = new HashMap<>();
                        <EnumerationResults>  
                        return;
                if ("blocklist".equals(complete) && (countDownComplete.countDown())) {
                        exchange.sendResponseHeaders(RestStatus.OK.getStatus(), length);
            }  
        final int length = randomIntBetween(1, bytes.length - position);
                      <Blobs />  
        final BlobContainer blobContainer = createBlobContainer(between(1, 5));
    public void setUp() throws Exception {
        assertThat(countDownUploads.get(), equalTo(0));
            } finally {  
            }
        });  
            assertArrayEquals(bytes, BytesReference.toBytes(Streams.readFully(inputStream)));
                        exchange.getResponseHeaders().add("Content-Type", "application/octet-stream");  
                        exchange.sendResponseHeaders(RestStatus.CREATED.getStatus(), -1);  
import java.util.HashMap;
            }
                        exchange.sendResponseHeaders(RestStatus.OK.getStatus(), length);
            try {
import static org.opensearch.repositories.azure.AzureStorageSettings.MAX_SINGLE_UPLOAD_SIZE_SETTING;
                          <Blobs>
                    </EnumerationResults>
                    exchange.getResponseHeaders().add("Content-Type", "application/octet-stream");
                    } else {
import static org.opensearch.repositories.azure.AzureRepository.Repository.CONTAINER_SETTING;  
                if ("HEAD".equals(exchange.getRequestMethod())) {  
            "metadata-",
                    RestUtils.decodeQueryString(exchange.getRequestURI().getQuery(), 0, params);  
                    return;
            2,  
                exchange.close();
            }
                exchange.getResponseHeaders().add("Content-Type", "application/octet-stream");
                    exchange.sendResponseHeaders(RestStatus.OK.getStatus(), -1);
                if (randomBoolean()) {
                    if (countDownGet.countDown()) {
        // The request retry policy counts the first attempt as retry, so we need to  
                    }
        // account for that and increase the max retry count by one.  
 * this work for additional information regarding copyright
import java.util.Arrays;
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals(List.of("metadata-1", "metadata-2"), blobs.stream().map(BlobMetadata::name).toList());  
            (settings, clientName) -> settings.put(
        try (InputStream stream = new InputStream() {  
                        exchange.getResponseBody().write(bytes, rangeStart, length);  
    }
        }
import fixture.azure.AzureHttpHandler;
        });
        // The request retry policy counts the first attempt as retry, so we need to
import com.sun.net.httpserver.HttpExchange;  
                exchange.close();
        final int maxRetries = randomIntBetween(2, 6);  
 * the Apache License, Version 2.0 (the "License"); you may
                        final int length = bytes.length - rangeStart;  
