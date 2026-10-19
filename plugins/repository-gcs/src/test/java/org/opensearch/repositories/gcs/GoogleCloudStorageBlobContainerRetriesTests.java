import org.opensearch.common.blobstore.BlobContainer;
                final String contentRangeHeaderValue = exchange.getRequestHeaders().getFirst("Content-Range");
        });
    protected void configureClientSettings(Settings.Builder settings, String clientName) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
    }  
                }
    }
                exchange.close();
                    Streams.readFully(exchange.getRequestBody());
import static org.hamcrest.Matchers.anyOf;  
import org.opensearch.common.lucene.store.InputStreamIndexInput;  
 * Unless required by applicable law or agreed to in writing,
            totalChunks,  
                    assertThat(Math.toIntExact(requestBody.length()), anyOf(equalTo(defaultChunkSize), equalTo(lastChunkSize)));
import com.sun.net.httpserver.HttpHandler;  
                return;
                        // we must reset the counters because the whole object upload will be retried
import java.io.IOException;
    }
        clientSettings.put(TOKEN_URI_SETTING.getConcreteSettingForNamespace(client).getKey(), httpServerUrl() + "/token");
                    assertThat(new BytesArray(data, rangeStart, rangeEnd - rangeStart + 1), is(requestBody));
            }
 * under the License.  
                    .setRetrySettings(retrySettingsBuilder.build())
                StorageOptions options = super.createStorageOptions(clientSettings, httpTransportOptions);
        }
        }
                final var contentRange = ContentHttpHeadersParser.parseContentRangeHeader(contentRangeHeaderValue);  
                exchange.close();
        httpServer.createContext("/token", new FakeOAuth2HttpHandler());
 * Licensed to Elasticsearch under one or more contributor  
    public void testWriteBlobWithReadTimeouts() {
            defaultChunkSize,
                    if (allow410Gone.compareAndSet(true, false)) {
 * the Apache License, Version 2.0 (the "License"); you may
        final AtomicBoolean allow410Gone = new AtomicBoolean(randomBoolean());  
        }));  
 * compatible open source license.
import fixture.gcs.ContentHttpHeadersParser;
import static fixture.gcs.GoogleCloudStorageHttpHandler.parseMultipartRequestBody;
import java.util.Map;  
        final int maxRetries = randomIntBetween(2, 10);
import org.opensearch.common.settings.Settings;  
 * KIND, either express or implied.  See the License for the
                    }
            if (randomBoolean()) {  
    protected Class<? extends Exception> unresponsiveExceptionType() {
            final BytesReference requestBody = Streams.readFully(exchange.getRequestBody());  
}  
            assertThat(exchange.getRequestURI().getQuery(), containsString("uploadType=multipart"));
        final BlobContainer blobContainer = createBlobContainer(maxRetries, null, null, null);
    public void testWriteBlobWithRetries() throws Exception {
        }
            StorageOptions createStorageOptions(  
        );  
import com.google.cloud.storage.StorageOptions;
            try (InputStream stream = new InputStreamIndexInput(new ByteArrayIndexInput("desc", bytes), bytes.length)) {
                    exchange.sendResponseHeaders(HttpStatus.SC_INTERNAL_SERVER_ERROR, -1);
    }  
                    .setStorageRetryStrategy(new GoogleShouldRetryStorageStrategy())
     * @param clientName the name of the client being configured
import java.util.Arrays;  
                return;
                if (countUploads.get() == (wrongChunk * nbErrors)) {  
                        logger.debug("chunk [{}] gone, updating session ids [{} -> {}]", wrongChunk, sessionUploadId.get(), newUploadId);
        final int nbChunks = randomIntBetween(3, 5);
                if (maxRetries != null) {
                }
            exchange.sendResponseHeaders(RestStatus.OK.getStatus(), chunk.length);
                    exchange.getResponseHeaders().add("Content-Type", "application/json");
 * GitHub history for details.
        });
import com.google.cloud.http.HttpTransportOptions;  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testReadLargeBlobWithRetries() throws Exception {
                    exchange.sendResponseHeaders(308 /* Resume Incomplete */, -1);
            service,
                    exchange.getResponseHeaders().add("Content-Type", "application/json");
                        exchange.getResponseHeaders().add("Content-Length", "0");
            ) {  
import org.opensearch.common.UUIDs;  
        final Settings.Builder clientSettings = Settings.builder();
    }
        httpServer.createContext("/upload/storage/v1/b/bucket/o", exchange -> {
     * Hook method for subclasses to add additional client settings.  
                    }  
                }  
    @Override  
    private String httpServerUrl() {  
            if (randomBoolean() && countDown.decrementAndGet() >= 0) {
        return "http://" + InetAddresses.toUriString(address.getAddress()) + ":" + address.getPort();  
            if (randomBoolean()) {  
                loggingHandler.handle(exchange);  
            exchange.close();
 *
public class GoogleCloudStorageBlobContainerRetriesTests extends AbstractBlobContainerRetriesTestCase {
import fixture.gcs.FakeOAuth2HttpHandler;
        final int totalChunks = nbChunks + 1;  
                } else {  
                    .setInitialRetryDelay(Duration.ofMillis(10L))
import org.opensearch.common.unit.TimeValue;
 * specific language governing permissions and limitations
import java.io.InputStream;  
        InetSocketAddress address = httpServer.getAddress();
package org.opensearch.repositories.gcs;
import java.util.HashMap;
        clientSettings.setSecureSettings(secureSettings);
        assertThat(allow410Gone.get(), is(false));
import org.opensearch.repositories.blobstore.OpenSearchMockAPIBasedRepositoryIntegTestCase;
                    .setRpcTimeoutMultiplier(options.getRetrySettings().getRpcTimeoutMultiplier())
            blobContainer.writeBlob("write_large_blob", stream, data.length, false);  
        httpServer.createContext("/download/storage/v1/b/bucket/o/large_blob_retries", exchange -> {
        final AtomicInteger countUploads = new AtomicInteger(nbErrors * totalChunks);
        assertThat(countDown.isCountedDown(), is(true));
            } else if ("PUT".equals(exchange.getRequestMethod())) {  
            }  
        final byte[] bytes = randomBytes(1 << 22);  
                        final String newUploadId = UUIDs.randomBase64UUID(random());  
            exchange.getResponseBody().write(chunk);
                    Streams.readFully(exchange.getRequestBody(), new byte[randomIntBetween(1, Math.max(1, bytes.length - 1))]);
        assertThat(exception.getCause(), instanceOf(SocketTimeoutException.class));
        };
                            "Location",
        final String client = randomAlphaOfLength(5).toLowerCase(Locale.ROOT);
                blobContainer.writeBlob("write_blob_timeout", stream, bytes.length, false);
                    // https://cloud.google.com/storage/docs/performing-resumable-uploads#status-check
        final AtomicInteger countInits = new AtomicInteger(nbErrors);
            lastChunkSize  
import java.util.concurrent.atomic.AtomicInteger;
                assertThat(params.get("name"), equalTo("write_large_blob"));
                    return;
                    logger.debug("session id [{}] is gone", uploadId);  
            }  
        try (InputStream inputStream = blobContainer.readBlob("large_blob_retries")) {  
        final int nbErrors = 2; // we want all requests to fail at least once  
        });  
                    if (allowReadTimeout.compareAndSet(true, false)) {
import static org.opensearch.repositories.gcs.TestUtils.createServiceAccount;
    ) {  
                return options.toBuilder()
            blobContainer.writeBlob("write_blob_max_retries", stream, bytes.length, false);  
        final MockSecureSettings secureSettings = new MockSecureSettings();
        final AtomicBoolean allowReadTimeout = new AtomicBoolean(rarely());
                    Streams.readFully(exchange.getRequestBody(), new byte[randomIntBetween(1, bytes.length - 1)]);
 * license agreements. See the NOTICE file distributed with
    /**  
        return exchange -> {
        final int lastChunkSize = randomIntBetween(1, defaultChunkSize - 1);
 * Modifications Copyright OpenSearch Contributors. See  
                        exchange.getResponseHeaders().add("x-goog-stored-content-length", String.valueOf(bytesReceived.get() + 1));  
 */  
    }  
            }
                Optional<Tuple<String, BytesReference>> content = parseMultipartRequestBody(exchange.getRequestBody());
                        return;
                assertNotNull("Invalid content range header: " + contentRangeHeaderValue, contentRange);
        final @Nullable Integer maxRetries,
        clientSettings.put(ENDPOINT_SETTING.getConcreteSettingForNamespace(client).getKey(), httpServerUrl());  
import org.opensearch.core.common.bytes.BytesReference;
 */
        final BlobContainer blobContainer = createBlobContainer(maxRetries, null, null, null);
 * this file be licensed under the Apache-2.0 license or a
                    return;  
                if (uploadId.equals(sessionUploadId.get()) == false) {
                    assertThat(wrongChunk, greaterThan(0));
        if (readTimeout != null) {
    protected String bytesContentType() {  
 * this work for additional information regarding copyright
                        return;  
import org.opensearch.core.rest.RestStatus;  
                    return;  
        };
        final TimeValue readTimeout = allowReadTimeout.get() ? TimeValue.timeValueSeconds(3) : null;
            RestUtils.decodeQueryString(exchange.getRequestURI().getQuery(), 0, params);  
                    exchange.sendResponseHeaders(HttpStatus.SC_BAD_REQUEST, -1);
    }  
    }
import org.threeten.bp.Duration;  
import static org.hamcrest.Matchers.notNullValue;  
                    }
                        return;
            exchange.getResponseHeaders().add("Content-Type", "application/octet-stream");  
import static java.nio.charset.StandardCharsets.UTF_8;
 * software distributed under the License is distributed on an
        configureClientSettings(clientSettings, client);  
        final AtomicInteger bytesReceived = new AtomicInteger();
            final int offset = Math.toIntExact(range.v1());
    @Override  
import org.opensearch.common.network.InetAddresses;
                    return;  
                if (allowReadTimeout.get()) {
                assertThat(content.get().v1(), equalTo("write_blob_max_retries"));  
import org.opensearch.core.common.bytes.BytesArray;  
                    exchange.sendResponseHeaders(RestStatus.OK.getStatus(), response.length);
        final AtomicInteger countDown = new AtomicInteger(maxRetries);  
                        .add(  
    }  
            assertThat(params.get("uploadType"), equalTo("resumable"));
            "repo",  
        final @Nullable Boolean disableChunkedEncoding,
            "resumable upload is composed of [{}] total chunks ([{}] chunks of length [{}] and last chunk of length [{}]",
        httpServer.createContext("/upload/storage/v1/b/bucket/o", safeHandler(exchange -> {
                RetrySettings.Builder retrySettingsBuilder = RetrySettings.newBuilder()
import org.opensearch.common.blobstore.BlobPath;
import org.opensearch.repositories.blobstore.AbstractBlobContainerRetriesTestCase;
import java.util.concurrent.atomic.AtomicReference;
                        assertThat(wrongChunk, greaterThan(0));
                        exchange.sendResponseHeaders(308 /* Resume Incomplete */, -1);  
                if (countUploads.decrementAndGet() % 2 == 0) {  
import org.opensearch.common.util.concurrent.CountDown;
                    } else {  
                        bytesReceived.set(0);
        final GoogleCloudStorageService service = new GoogleCloudStorageService() {
        // HTTP server does not send a response
 *  
        // Default implementation: no additional secure settings
                        exchange.getResponseHeaders().add("Range", String.format("bytes=%s-%s", rangeStart, rangeEnd));
        assertThat(httpServer, notNullValue());
                if (Objects.deepEquals(bytes, BytesReference.toBytes(content.get().v2()))) {
            final Map<String, String> params = new HashMap<>();
    }
        }));
        final CountDown countDown = new CountDown(maxRetries);
        assertThat(data.length, greaterThan(GoogleCloudStorageBlobStore.LARGE_BLOB_THRESHOLD_BYTE_SIZE));
            }
                    final int receivedSoFar = bytesReceived.get();  
import org.opensearch.common.SuppressForbidden;
            } finally {
                        exchange.sendResponseHeaders(HttpStatus.SC_GONE, -1);  
        assertThat(exception.getCause().getMessage().toLowerCase(Locale.ROOT), containsString("read timed out"));
import java.util.Objects;
     */
                    // Content-Range: */... is a status check
import java.net.InetSocketAddress;
        return new GoogleCloudStorageBlobContainer(BlobPath.cleanPath(), blobStore);
                }  
        final BlobContainer blobContainer = createBlobContainer(nbErrors + 1, readTimeout, null, null);
                            httpServerUrl() + "/upload/storage/v1/b/bucket/o?uploadType=resumable&upload_id=" + sessionUploadId.get()
        return "application/octet-stream";
     *
                if (randomBoolean()) {
import org.opensearch.common.Nullable;
                    byte[] response = requestBody.utf8ToString().getBytes(UTF_8);  
/*
            if (randomBoolean()) {  
                        sessionUploadId.set(newUploadId);
                    .build();  
    }  
                    }
                exchange.getResponseBody().write(chunk, 0, chunk.length - 1);  
                    .setHost(options.getHost())
import org.opensearch.rest.RestUtils;  
                if (!contentRange.hasRange()) {  
                }
            clientSettings.put(READ_TIMEOUT_SETTING.getConcreteSettingForNamespace(client).getKey(), readTimeout);  
                final HttpTransportOptions httpTransportOptions
import org.opensearch.common.io.Streams;
        );
     * Hook method for subclasses to add additional secure settings.
                    exchange.getResponseHeaders().add("Content-Length", "0");
import static org.opensearch.repositories.gcs.GoogleCloudStorageClientSettings.READ_TIMEOUT_SETTING;  
        final byte[] bytes = randomByteArrayOfLength(randomIntBetween(10, 128));  
        logger.debug("starting with resumable upload id [{}]", sessionUploadId.get());  
                    retrySettingsBuilder.setMaxAttempts(maxRetries + 1);
                } else {
            Streams.readFully(exchange.getRequestBody());
import java.util.Optional;
                    bytesReceived.updateAndGet(existing -> Math.max(existing, rangeEnd));  
                }  
        assertThat(exception.getMessage().toLowerCase(Locale.ROOT), containsString("read timed out"));
import java.util.concurrent.atomic.AtomicBoolean;  
    @Override
        try (InputStream stream = new InputStreamIndexInput(new ByteArrayIndexInput("desc", data), data.length)) {
        final byte[] data = randomBytes(defaultChunkSize * nbChunks + lastChunkSize);
        final @Nullable TimeValue readTimeout,  
                    .setInitialRpcTimeout(Duration.ofSeconds(1))
                    .setMaxRpcTimeout(Duration.ofSeconds(1));  
import java.util.Locale;
                    if (contentRange.size() != null) {
        }
                }
     * @param settings the settings builder to add settings to
        assertThat(countInits.get(), equalTo(0));  
                } else {  
 * You may obtain a copy of the License at  
                    exchange.sendResponseHeaders(HttpStatus.SC_GONE, -1);
            if ("POST".equals(exchange.getRequestMethod())) {  
    }
     * @param secureSettings the secure settings to add settings to  
                    final int rangeStart = Math.toIntExact(contentRange.start());
        return "/download/storage/v1/b/bucket/o/" + blob;
import org.opensearch.common.collect.Tuple;  
            }
import static org.opensearch.repositories.gcs.GoogleCloudStorageClientSettings.ENDPOINT_SETTING;
                assertThat(content.isPresent(), is(true));
    /**
        final TimeValue readTimeout = TimeValue.timeValueMillis(randomIntBetween(100, 500));
        final int defaultChunkSize = Math.toIntExact(ByteSizeValue.parseBytesSizeValue("16mb", "aaa").getBytes());  
 * SPDX-License-Identifier: Apache-2.0
                    .setCredentials(options.getCredentials())  
                exchange.sendResponseHeaders(HttpStatus.SC_INTERNAL_SERVER_ERROR, -1);
                final GoogleCloudStorageClientSettings clientSettings,
            }
 *
import org.opensearch.common.lucene.store.ByteArrayIndexInput;
     * @param clientName the name of the client being configured  
                    assertThat(wrongChunk, greaterThan(0));  
        httpServer.createContext("/upload/storage/v1/b/bucket/o", safeHandler(exchange -> {
import static org.hamcrest.Matchers.containsString;
        assertThat(countUploads.get(), equalTo(0));
import static org.opensearch.repositories.gcs.GoogleCloudStorageClientSettings.CREDENTIALS_FILE_SETTING;
                        );  
                }  
                        countInits.set(nbErrors);
 */
                    .setTotalTimeout(options.getRetrySettings().getTotalTimeout())  
import com.google.cloud.storage.StorageException;
        final int wrongChunk = randomIntBetween(1, totalChunks);  
@SuppressForbidden(reason = "use a http server")  
    public void testWriteLargeBlob() throws IOException {
                    assertThat(rangeEnd + 1 - rangeStart, equalTo(Math.toIntExact(requestBody.length())));
        configureSecureSettings(secureSettings, client);
            nbChunks,
/*  
            }  
                    if (receivedSoFar > 0) {
 * not use this file except in compliance with the License.
                final String uploadId = params.get("upload_id");
                    exchange.getResponseBody().write(response);  
                        exchange.getResponseHeaders().add("Range", String.format("bytes=0-%s", receivedSoFar));
        try (InputStream stream = new InputStreamIndexInput(new ByteArrayIndexInput("desc", bytes), bytes.length)) {
                        countUploads.set(nbErrors * totalChunks);  
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.common.settings.MockSecureSettings;
    protected String downloadStorageEndpoint(String blob) {
import java.net.SocketTimeoutException;
                    exchange.sendResponseHeaders(RestStatus.OK.getStatus(), response.length);
        final BlobContainer blobContainer = createBlobContainer(1, readTimeout, null, null);
                        exchange.sendResponseHeaders(RestStatus.OK.getStatus(), -1);
        final HttpHandler loggingHandler = OpenSearchMockAPIBasedRepositoryIntegTestCase.wrap(handler, logger);  
                    .setRetryDelayMultiplier(1.0d)
            try {
                        {"bucket":"bucket","name":"%s"}""", content.get().v1()).getBytes(UTF_8);  
                    exchange.getResponseHeaders()
            randomIntBetween(1, 8) * 1024
    protected void configureSecureSettings(MockSecureSettings secureSettings, String clientName) {  
import static org.opensearch.repositories.blobstore.OpenSearchBlobStoreRepositoryIntegTestCase.randomBytes;  
        final @Nullable ByteSizeValue bufferSize
import static org.hamcrest.Matchers.is;
                    Streams.readFully(exchange.getRequestBody());
import org.apache.hc.core5.http.HttpStatus;  
     */
        Exception exception = expectThrows(StorageException.class, () -> {  
import com.google.api.gax.retrying.RetrySettings;
        // Default implementation: no additional settings  
    @Override
import static org.opensearch.repositories.gcs.GoogleCloudStorageClientSettings.TOKEN_URI_SETTING;
        return StorageException.class;  
            @Override
                }  
                if (randomBoolean()) {
        final byte[] bytes = randomBlobContent();  
        secureSettings.setFile(CREDENTIALS_FILE_SETTING.getConcreteSettingForNamespace(client).getKey(), createServiceAccount(random()));
                    .setMaxRetryDelay(Duration.ofSeconds(1L))  
import static org.hamcrest.Matchers.greaterThan;  
            final Tuple<Long, Long> range = getRange(exchange);
    private HttpHandler safeHandler(HttpHandler handler) {
            final byte[] chunk = Arrays.copyOfRange(bytes, offset, Math.toIntExact(Math.min(range.v2() + 1, bytes.length)));  
        service.refreshAndClearCache(GoogleCloudStorageClientSettings.load(clientSettings.build()));  
                    final int rangeEnd = Math.toIntExact(contentRange.end());  
        final GoogleCloudStorageBlobStore blobStore = new GoogleCloudStorageBlobStore(  
        final AtomicReference<String> sessionUploadId = new AtomicReference<>(UUIDs.randomBase64UUID());
                if (countInits.decrementAndGet() <= 0) {
import static org.hamcrest.Matchers.instanceOf;
            if (countDown.countDown()) {  
import org.opensearch.core.common.unit.ByteSizeValue;
        logger.debug(
        // SDK reads in 2 MB chunks so we use twice that to simulate 2 chunks
            "bucket",
            }  
/*
                    exchange.getResponseBody().write(response);
 * The OpenSearch Contributors require contributions made to  
     *
    protected BlobContainer createBlobContainer(
                }
                        return;
                    byte[] response = String.format("""
            assertArrayEquals(bytes, BytesReference.toBytes(Streams.readFully(inputStream)));
            client,
        final int maxRetries = randomIntBetween(2, 10);  
