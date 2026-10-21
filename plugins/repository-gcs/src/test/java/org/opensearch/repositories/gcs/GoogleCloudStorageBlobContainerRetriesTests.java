                assertThat(content.isPresent(), is(true));
                    exchange.sendResponseHeaders(HttpStatus.SC_GONE, -1);
            "bucket",
        assertThat(countDown.isCountedDown(), is(true));
            RestUtils.decodeQueryString(exchange.getRequestURI().getQuery(), 0, params);
                }
        httpServer.createContext("/upload/storage/v1/b/bucket/o", safeHandler(exchange -> {
                        exchange.getResponseHeaders().add("Range", String.format("bytes=%s-%s", rangeStart, rangeEnd));
            service,
        }
                    return;
        final AtomicBoolean allow410Gone = new AtomicBoolean(randomBoolean());
import org.opensearch.common.Nullable;
        httpServer.createContext("/download/storage/v1/b/bucket/o/large_blob_retries", exchange -> {
import org.opensearch.common.SuppressForbidden;
import java.io.IOException;
                return;
    protected Class<? extends Exception> unresponsiveExceptionType() {
            if (randomBoolean()) {
                    final int rangeEnd = Math.toIntExact(contentRange.end());
                        exchange.sendResponseHeaders(308 /* Resume Incomplete */, -1);
                    .build();
    }
import org.opensearch.common.blobstore.BlobContainer;
        );
        final int wrongChunk = randomIntBetween(1, totalChunks);
import java.util.Arrays;
                    exchange.getResponseHeaders()
                        bytesReceived.set(0);
                        return;
                        return;
    /**
 * The OpenSearch Contributors require contributions made to
            blobContainer.writeBlob("write_large_blob", stream, data.length, false);
            Streams.readFully(exchange.getRequestBody());
import org.opensearch.common.lucene.store.InputStreamIndexInput;
            final byte[] chunk = Arrays.copyOfRange(bytes, offset, Math.toIntExact(Math.min(range.v2() + 1, bytes.length)));
                    if (receivedSoFar > 0) {
        final int lastChunkSize = randomIntBetween(1, defaultChunkSize - 1);
import org.apache.hc.core5.http.HttpStatus;
                    return;
import org.opensearch.common.io.Streams;
 * Licensed to Elasticsearch under one or more contributor
                        assertThat(wrongChunk, greaterThan(0));
            assertThat(exchange.getRequestURI().getQuery(), containsString("uploadType=multipart"));
                assertThat(params.get("name"), equalTo("write_large_blob"));
        httpServer.createContext("/upload/storage/v1/b/bucket/o", exchange -> {
        assertThat(exception.getCause(), instanceOf(SocketTimeoutException.class));
                    exchange.sendResponseHeaders(RestStatus.OK.getStatus(), response.length);
                }
        final @Nullable Boolean disableChunkedEncoding,
                } else {
                    return;
                    assertThat(wrongChunk, greaterThan(0));
            assertArrayEquals(bytes, BytesReference.toBytes(Streams.readFully(inputStream)));
    }
import static org.opensearch.repositories.gcs.GoogleCloudStorageClientSettings.READ_TIMEOUT_SETTING;
 */
                blobContainer.writeBlob("write_blob_timeout", stream, bytes.length, false);
 * license agreements. See the NOTICE file distributed with
                    assertThat(wrongChunk, greaterThan(0));
        service.refreshAndClearCache(GoogleCloudStorageClientSettings.load(clientSettings.build()));
        final @Nullable TimeValue readTimeout,
        InetSocketAddress address = httpServer.getAddress();
 *
     */
                }
    private String httpServerUrl() {
    }
 * this file be licensed under the Apache-2.0 license or a
                    .setMaxRpcTimeout(Duration.ofSeconds(1));
        final BlobContainer blobContainer = createBlobContainer(nbErrors + 1, readTimeout, null, null);
        final BlobContainer blobContainer = createBlobContainer(maxRetries, null, null, null);
            lastChunkSize
import java.net.InetSocketAddress;
 *
                    // Content-Range: */... is a status check
    }
        Exception exception = expectThrows(StorageException.class, () -> {
                assertThat(content.get().v1(), equalTo("write_blob_max_retries"));
        final byte[] bytes = randomBlobContent();
    protected void configureSecureSettings(MockSecureSettings secureSettings, String clientName) {
        };
/*
import static org.opensearch.repositories.gcs.GoogleCloudStorageClientSettings.CREDENTIALS_FILE_SETTING;
                }
import com.google.api.gax.retrying.RetrySettings;
                final var contentRange = ContentHttpHeadersParser.parseContentRangeHeader(contentRangeHeaderValue);
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
        final AtomicReference<String> sessionUploadId = new AtomicReference<>(UUIDs.randomBase64UUID());
import com.google.cloud.storage.StorageOptions;
     *
                        exchange.getResponseHeaders().add("Content-Length", "0");
            if ("POST".equals(exchange.getRequestMethod())) {
import com.google.cloud.storage.StorageException;
            "repo",
                    exchange.getResponseHeaders().add("Content-Type", "application/json");
        configureSecureSettings(secureSettings, client);
            }
import static org.opensearch.repositories.gcs.GoogleCloudStorageClientSettings.ENDPOINT_SETTING;
                    .setRetryDelayMultiplier(1.0d)
        final GoogleCloudStorageService service = new GoogleCloudStorageService() {
        final @Nullable ByteSizeValue bufferSize
        final int totalChunks = nbChunks + 1;
        clientSettings.put(ENDPOINT_SETTING.getConcreteSettingForNamespace(client).getKey(), httpServerUrl());
                    exchange.sendResponseHeaders(308 /* Resume Incomplete */, -1);
        return "/download/storage/v1/b/bucket/o/" + blob;
        clientSettings.setSecureSettings(secureSettings);
        try (InputStream inputStream = blobContainer.readBlob("large_blob_retries")) {
        final @Nullable Integer maxRetries,
import java.util.HashMap;
        assertThat(data.length, greaterThan(GoogleCloudStorageBlobStore.LARGE_BLOB_THRESHOLD_BYTE_SIZE));
import org.opensearch.common.blobstore.BlobPath;
        return StorageException.class;
                RetrySettings.Builder retrySettingsBuilder = RetrySettings.newBuilder()
                final GoogleCloudStorageClientSettings clientSettings,
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
                    exchange.sendResponseHeaders(HttpStatus.SC_INTERNAL_SERVER_ERROR, -1);
    }
                    logger.debug("session id [{}] is gone", uploadId);
        }));
            final Map<String, String> params = new HashMap<>();
                        return;
                StorageOptions options = super.createStorageOptions(clientSettings, httpTransportOptions);
import java.util.concurrent.atomic.AtomicBoolean;
                        exchange.sendResponseHeaders(RestStatus.OK.getStatus(), -1);
@SuppressForbidden(reason = "use a http server")
                final String uploadId = params.get("upload_id");
        };
 * KIND, either express or implied.  See the License for the
        if (readTimeout != null) {
            if (countDown.countDown()) {
 * the Apache License, Version 2.0 (the "License"); you may
                            "Location",
                    if (allow410Gone.compareAndSet(true, false)) {
                    final int receivedSoFar = bytesReceived.get();
 * not use this file except in compliance with the License.
        assertThat(httpServer, notNullValue());
            }
 * GitHub history for details.
        final TimeValue readTimeout = TimeValue.timeValueMillis(randomIntBetween(100, 500));
                        // we must reset the counters because the whole object upload will be retried
            if (randomBoolean() && countDown.decrementAndGet() >= 0) {
        final CountDown countDown = new CountDown(maxRetries);
                    Streams.readFully(exchange.getRequestBody());
        final String client = randomAlphaOfLength(5).toLowerCase(Locale.ROOT);
            blobContainer.writeBlob("write_blob_max_retries", stream, bytes.length, false);
                loggingHandler.handle(exchange);
        assertThat(countInits.get(), equalTo(0));
import fixture.gcs.FakeOAuth2HttpHandler;
                        {"bucket":"bucket","name":"%s"}""", content.get().v1()).getBytes(UTF_8);
        try (InputStream stream = new InputStreamIndexInput(new ByteArrayIndexInput("desc", data), data.length)) {
        final AtomicInteger countUploads = new AtomicInteger(nbErrors * totalChunks);
        final AtomicInteger countDown = new AtomicInteger(maxRetries);
                    .setMaxRetryDelay(Duration.ofSeconds(1L))
                    byte[] response = requestBody.utf8ToString().getBytes(UTF_8);
                        countUploads.set(nbErrors * totalChunks);
            try {
        }));
    @Override
                if (countUploads.decrementAndGet() % 2 == 0) {
                if (allowReadTimeout.get()) {
            ) {
import org.opensearch.common.collect.Tuple;
            StorageOptions createStorageOptions(
        });
            clientSettings.put(READ_TIMEOUT_SETTING.getConcreteSettingForNamespace(client).getKey(), readTimeout);
import org.opensearch.core.rest.RestStatus;
import java.util.Optional;
    public void testWriteBlobWithRetries() throws Exception {
    }
                    exchange.getResponseBody().write(response);
 * under the License.
import org.opensearch.common.unit.TimeValue;
        // SDK reads in 2 MB chunks so we use twice that to simulate 2 chunks
                    assertThat(Math.toIntExact(requestBody.length()), anyOf(equalTo(defaultChunkSize), equalTo(lastChunkSize)));
 * ownership. Elasticsearch licenses this file to you under
                    if (allowReadTimeout.compareAndSet(true, false)) {
                    } else {
                }
                if (Objects.deepEquals(bytes, BytesReference.toBytes(content.get().v2()))) {
            }
        clientSettings.put(TOKEN_URI_SETTING.getConcreteSettingForNamespace(client).getKey(), httpServerUrl() + "/token");
import org.opensearch.core.common.bytes.BytesArray;
     * Hook method for subclasses to add additional client settings.
                        sessionUploadId.set(newUploadId);
        final int nbChunks = randomIntBetween(3, 5);
import org.opensearch.common.lucene.store.ByteArrayIndexInput;
                exchange.sendResponseHeaders(HttpStatus.SC_INTERNAL_SERVER_ERROR, -1);
import org.opensearch.rest.RestUtils;
import org.opensearch.common.network.InetAddresses;
        final TimeValue readTimeout = allowReadTimeout.get() ? TimeValue.timeValueSeconds(3) : null;
            exchange.getResponseHeaders().add("Content-Type", "application/octet-stream");
                    .setInitialRpcTimeout(Duration.ofSeconds(1))
import java.net.SocketTimeoutException;
import com.google.cloud.http.HttpTransportOptions;
    /**
                if (!contentRange.hasRange()) {
        final AtomicBoolean allowReadTimeout = new AtomicBoolean(rarely());
                    // https://cloud.google.com/storage/docs/performing-resumable-uploads#status-check
import static org.hamcrest.Matchers.instanceOf;
import static org.opensearch.repositories.gcs.GoogleCloudStorageClientSettings.TOKEN_URI_SETTING;
                    }
        final MockSecureSettings secureSettings = new MockSecureSettings();
    @Override
                    Streams.readFully(exchange.getRequestBody());
        httpServer.createContext("/upload/storage/v1/b/bucket/o", safeHandler(exchange -> {
    protected String downloadStorageEndpoint(String blob) {
                Optional<Tuple<String, BytesReference>> content = parseMultipartRequestBody(exchange.getRequestBody());
        return exchange -> {
                        countInits.set(nbErrors);
    }
                    .setTotalTimeout(options.getRetrySettings().getTotalTimeout())
    @Override
    protected String bytesContentType() {
        final byte[] data = randomBytes(defaultChunkSize * nbChunks + lastChunkSize);
                    exchange.sendResponseHeaders(HttpStatus.SC_BAD_REQUEST, -1);
                    .setRpcTimeoutMultiplier(options.getRetrySettings().getRpcTimeoutMultiplier())
                } else {
                exchange.getResponseBody().write(chunk, 0, chunk.length - 1);
/*
import org.opensearch.common.settings.Settings;
        final GoogleCloudStorageBlobStore blobStore = new GoogleCloudStorageBlobStore(
            }
                        final String newUploadId = UUIDs.randomBase64UUID(random());
import java.util.Objects;
        });
        final BlobContainer blobContainer = createBlobContainer(maxRetries, null, null, null);
        });
     * @param clientName the name of the client being configured
                assertNotNull("Invalid content range header: " + contentRangeHeaderValue, contentRange);
     * Hook method for subclasses to add additional secure settings.
                    exchange.getResponseHeaders().add("Content-Type", "application/json");
    }
        try (InputStream stream = new InputStreamIndexInput(new ByteArrayIndexInput("desc", bytes), bytes.length)) {
import com.sun.net.httpserver.HttpHandler;
        );
import static org.hamcrest.Matchers.containsString;
                        exchange.getResponseHeaders().add("x-goog-stored-content-length", String.valueOf(bytesReceived.get() + 1));
            final Tuple<Long, Long> range = getRange(exchange);
                    assertThat(new BytesArray(data, rangeStart, rangeEnd - rangeStart + 1), is(requestBody));
        assertThat(allow410Gone.get(), is(false));
        configureClientSettings(clientSettings, client);
                        exchange.sendResponseHeaders(HttpStatus.SC_GONE, -1);
public class GoogleCloudStorageBlobContainerRetriesTests extends AbstractBlobContainerRetriesTestCase {
        final int nbErrors = 2; // we want all requests to fail at least once
                    }
                    Streams.readFully(exchange.getRequestBody(), new byte[randomIntBetween(1, bytes.length - 1)]);
        assertThat(countUploads.get(), equalTo(0));
                final HttpTransportOptions httpTransportOptions
            client,
        final byte[] bytes = randomByteArrayOfLength(randomIntBetween(10, 128));
                if (countUploads.get() == (wrongChunk * nbErrors)) {
    protected void configureClientSettings(Settings.Builder settings, String clientName) {
 */
    public void testWriteLargeBlob() throws IOException {
                if (countInits.decrementAndGet() <= 0) {
import static org.hamcrest.Matchers.anyOf;
        return new GoogleCloudStorageBlobContainer(BlobPath.cleanPath(), blobStore);
import java.util.Locale;
                    }
            exchange.sendResponseHeaders(RestStatus.OK.getStatus(), chunk.length);
        final int defaultChunkSize = Math.toIntExact(ByteSizeValue.parseBytesSizeValue("16mb", "aaa").getBytes());
        assertThat(exception.getCause().getMessage().toLowerCase(Locale.ROOT), containsString("read timed out"));
                    .setInitialRetryDelay(Duration.ofMillis(10L))
            } finally {
        final AtomicInteger bytesReceived = new AtomicInteger();
import static org.hamcrest.Matchers.equalTo;
        assertThat(exception.getMessage().toLowerCase(Locale.ROOT), containsString("read timed out"));
        final Settings.Builder clientSettings = Settings.builder();
            @Override
            "resumable upload is composed of [{}] total chunks ([{}] chunks of length [{}] and last chunk of length [{}]",
        // Default implementation: no additional settings
        final BlobContainer blobContainer = createBlobContainer(1, readTimeout, null, null);
                    .setCredentials(options.getCredentials())
                }
     *
        logger.debug("starting with resumable upload id [{}]", sessionUploadId.get());
        final int maxRetries = randomIntBetween(2, 10);
        final byte[] bytes = randomBytes(1 << 22);
            exchange.getResponseBody().write(chunk);
import java.io.InputStream;
                        exchange.getResponseHeaders().add("Range", String.format("bytes=0-%s", receivedSoFar));
    }
    protected BlobContainer createBlobContainer(
import java.util.concurrent.atomic.AtomicReference;
import static org.opensearch.repositories.blobstore.OpenSearchBlobStoreRepositoryIntegTestCase.randomBytes;
        httpServer.createContext("/token", new FakeOAuth2HttpHandler());
import fixture.gcs.ContentHttpHeadersParser;
                exchange.close();
                    bytesReceived.updateAndGet(existing -> Math.max(existing, rangeEnd));
    public void testReadLargeBlobWithRetries() throws Exception {
import org.opensearch.core.common.bytes.BytesReference;
            nbChunks,
import static java.nio.charset.StandardCharsets.UTF_8;
                final String contentRangeHeaderValue = exchange.getRequestHeaders().getFirst("Content-Range");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
            randomIntBetween(1, 8) * 1024
            if (randomBoolean()) {
                    assertThat(rangeEnd + 1 - rangeStart, equalTo(Math.toIntExact(requestBody.length())));
            exchange.close();
import org.opensearch.core.common.unit.ByteSizeValue;
        // HTTP server does not send a response
        // Default implementation: no additional secure settings
                }
                        return;
                    Streams.readFully(exchange.getRequestBody(), new byte[randomIntBetween(1, Math.max(1, bytes.length - 1))]);
import java.util.concurrent.atomic.AtomicInteger;
        final HttpHandler loggingHandler = OpenSearchMockAPIBasedRepositoryIntegTestCase.wrap(handler, logger);
import static org.hamcrest.Matchers.is;
import org.threeten.bp.Duration;
        secureSettings.setFile(CREDENTIALS_FILE_SETTING.getConcreteSettingForNamespace(client).getKey(), createServiceAccount(random()));
                    .setStorageRetryStrategy(new GoogleShouldRetryStorageStrategy())
    }
    private HttpHandler safeHandler(HttpHandler handler) {
                    if (contentRange.size() != null) {
                        );
            }
     * @param clientName the name of the client being configured
import java.util.Map;
import static org.opensearch.repositories.gcs.TestUtils.createServiceAccount;
     * @param settings the settings builder to add settings to
                if (randomBoolean()) {
                        .add(
            } else if ("PUT".equals(exchange.getRequestMethod())) {
                if (randomBoolean()) {
                        logger.debug("chunk [{}] gone, updating session ids [{} -> {}]", wrongChunk, sessionUploadId.get(), newUploadId);
import org.opensearch.repositories.blobstore.AbstractBlobContainerRetriesTestCase;
                    final int rangeStart = Math.toIntExact(contentRange.start());
            }
import org.opensearch.repositories.blobstore.OpenSearchMockAPIBasedRepositoryIntegTestCase;
        return "application/octet-stream";
                }
                    return;
            final int offset = Math.toIntExact(range.v1());
                            httpServerUrl() + "/upload/storage/v1/b/bucket/o?uploadType=resumable&upload_id=" + sessionUploadId.get()
    }
import org.opensearch.common.util.concurrent.CountDown;
                    retrySettingsBuilder.setMaxAttempts(maxRetries + 1);
    @Override
        }
                    exchange.sendResponseHeaders(RestStatus.OK.getStatus(), response.length);
                }
 *
            }
            assertThat(params.get("uploadType"), equalTo("resumable"));
                    exchange.getResponseHeaders().add("Content-Length", "0");
            final BytesReference requestBody = Streams.readFully(exchange.getRequestBody());
    public void testWriteBlobWithReadTimeouts() {
     * @param secureSettings the secure settings to add settings to
 * compatible open source license.
                    }
            }
            try (InputStream stream = new InputStreamIndexInput(new ByteArrayIndexInput("desc", bytes), bytes.length)) {
        return "http://" + InetAddresses.toUriString(address.getAddress()) + ":" + address.getPort();
    }
                exchange.close();
                return options.toBuilder()
        final int maxRetries = randomIntBetween(2, 10);
            totalChunks,
package org.opensearch.repositories.gcs;
    ) {
import static fixture.gcs.GoogleCloudStorageHttpHandler.parseMultipartRequestBody;
                    .setHost(options.getHost())
            }
                } else {
 * specific language governing permissions and limitations
import static org.hamcrest.Matchers.notNullValue;
import org.opensearch.common.UUIDs;
 */
import static org.hamcrest.Matchers.greaterThan;
                    byte[] response = String.format("""
                return;
            defaultChunkSize,
 * You may obtain a copy of the License at
        logger.debug(
import org.opensearch.common.settings.MockSecureSettings;
 * software distributed under the License is distributed on an
            if (randomBoolean()) {
}
                if (uploadId.equals(sessionUploadId.get()) == false) {
/*
                    exchange.getResponseBody().write(response);
                }
        final AtomicInteger countInits = new AtomicInteger(nbErrors);
 * Modifications Copyright OpenSearch Contributors. See
                if (maxRetries != null) {
     */
                    .setRetrySettings(retrySettingsBuilder.build())
 * this work for additional information regarding copyright
