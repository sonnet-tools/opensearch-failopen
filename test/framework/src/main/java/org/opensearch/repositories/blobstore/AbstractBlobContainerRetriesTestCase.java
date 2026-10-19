        final int length = randomIntBetween(0, randomBoolean() ? bytes.length : Integer.MAX_VALUE);
                assertThat(rangeEnd, greaterThanOrEqualTo(rangeStart));
            if (randomBoolean()) {
 *
            }
                    -1
        httpServer.start();
            }
                assertTrue(getRangeEnd(exchange).isPresent());
 * ownership. Elasticsearch licenses this file to you under
                final int length = (effectiveRangeEnd - rangeStart) + 1;
 *
        final int maxRetries = randomInt(20);
        });
}
                exchange.getResponseBody().write(bytes, rangeStart, length);
    public void testReadBlobWithPrematureConnectionClose() {
 * software distributed under the License is distributed on an
        final BlobContainer blobContainer = createBlobContainer(maxRetries, readTimeout, null, null);
                InputStream stream = randomBoolean()
            }
                        HttpStatus.SC_BAD_GATEWAY,
        final int rangeStart = getRangeStart(exchange);
        final int maxRetries = randomInt(5);
                InputStream stream = randomBoolean()
        if (rangeEnd == MAX_RANGE_VAL) {
                sendIncompleteContent(exchange, bytes);
 * Modifications Copyright OpenSearch Contributors. See
        }
            }
        @Nullable ByteSizeValue bufferSize
    }
            } else {
            }
        httpServer.createContext(downloadStorageEndpoint("read_range_blob_max_retries"), exchange -> {
    }
            }
    }
            try (
    }
        final int length;
    protected static Tuple<Long, Long> getRange(HttpExchange exchange) {
                assertTrue(countDown.isCountedDown());
                // read stream only partly
                readLimit = randomIntBetween(0, bytes.length);
                assertTrue(countDown.isCountedDown());
        final CountDown countDown = new CountDown(maxRetries + 1);
        }
            ) {
            Streams.readFully(exchange.getRequestBody());
                bytesRead.length
        final Optional<Integer> rangeEnd = getRangeEnd(exchange);
            if (randomBoolean()) {
                readLimit,
        );
    protected abstract String bytesContentType();
            }
                        HttpStatus.SC_GATEWAY_TIMEOUT
import static org.hamcrest.Matchers.instanceOf;
import java.util.regex.Matcher;
        @Nullable Integer maxRetries,
            }
            final int readLimit;
                readLimit = length;
        final String rangeHeader = exchange.getRequestHeaders().getFirst("Range");
            exception.getMessage().toLowerCase(Locale.ROOT),
        }
        final long rangeEnd = getRange(exchange).v2();
    public void testReadBlobWithReadTimeouts() {
                    randomFrom(
        @Nullable Boolean disableChunkedEncoding,
                wrappedStream = Streams.limitStream(inputStream, readLimit);
        // HTTP server closes connection immediately
            containsString("blob object [read_nonexistent_blob] not found")
                    ? blobContainer.readBlob("read_blob_incomplete")
                "maxRetries={}, position={}, length={}, readLimit={}, byteSize={}, bytesRead={}",
            }
        } else {
 * You may obtain a copy of the License at
            length = effectiveRangeEnd - rangeStart + 1;
    }
                exchange.sendResponseHeaders(HttpStatus.SC_OK, bytes.length - rangeStart);
            }
            exception.getMessage().toLowerCase(Locale.ROOT),
                exchange.close();
        if (rangeEnd.isPresent()) {
import java.nio.file.NoSuchFileException;
        assertThat(exception.getCause(), instanceOf(SocketTimeoutException.class));
public abstract class AbstractBlobContainerRetriesTestCase extends OpenSearchTestCase {
    protected static byte[] randomBlobContent() {
                Streams.readFully(stream);
        });
        httpServer = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);
        httpServer.createContext(downloadStorageEndpoint("read_blob_incomplete"), exchange -> {
        return randomBlobContent(1);
        Exception exception = expectThrows(unresponsiveExceptionType(), () -> {
import org.opensearch.common.io.Streams;
        );
        long rangeEnd = Long.parseLong(matcher.group(2));
import static org.hamcrest.Matchers.equalTo;
    public void testReadRangeBlobWithRetries() throws Exception {
        final byte[] bytes = randomBlobContent();
                () -> Streams.readFully(blobContainer.readBlob("read_nonexistent_blob", position, length))
 * the Apache License, Version 2.0 (the "License"); you may
                exchange.sendResponseHeaders(HttpStatus.SC_OK, length);
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.common.blobstore.BlobContainer;
                exchange.sendResponseHeaders(
import com.sun.net.httpserver.HttpServer;
        });
        httpServer.stop(0);
    protected abstract BlobContainer createBlobContainer(
            if (randomBoolean()) {
            if (randomBoolean()) {
        // HTTP server sends a partial response
        );
                readLimit = randomIntBetween(0, length);
import org.opensearch.core.common.unit.ByteSizeValue;
                exchange.getResponseHeaders().add("Content-Type", bytesContentType());
    );
        final CountDown countDown = new CountDown(maxRetries + 1);
package org.opensearch.repositories.blobstore;
    }
            final InputStream wrappedStream;
    private static final long MAX_RANGE_VAL = Long.MAX_VALUE - 1;
        final Exception exception = expectThrows(Exception.class, () -> {
                exchange.sendResponseHeaders(
        );
            () -> Streams.readFully(blobContainer.readBlob("read_blob_unresponsive"))
        final TimeValue readTimeout = TimeValue.timeValueMillis(between(100, 200));
            final int effectiveRangeEnd = Math.min(rangeEnd.get(), bytes.length - 1);
            } else {
            either(containsString("the target server failed to respond")).or(containsString("unexpected end of file from server"))
                exchange.getResponseBody().write(bytes, rangeStart, bytes.length - rangeStart);
        int minSend = Math.min(0, length - 1);
                exchange.close();
import java.net.SocketTimeoutException;
            final byte[] bytesRead = BytesReference.toBytes(Streams.readFully(wrappedStream));
        assertThat(exception.getMessage().toLowerCase(Locale.ROOT), containsString("blob object [read_nonexistent_blob] not found"));
 */
 * this work for additional information regarding copyright
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            } else {
    public void tearDown() throws Exception {
                        HttpStatus.SC_BAD_GATEWAY,
        Exception exception = expectThrows(
                bytes.length,
 * KIND, either express or implied.  See the License for the
                exchange.close();
 */
            } else {
                Streams.readFully(stream);
import java.util.Optional;
                wrappedStream = Streams.limitStream(inputStream, readLimit);
import java.net.InetAddress;
        });
        final int length = randomIntBetween(1, Math.toIntExact(Math.min(Integer.MAX_VALUE, MAX_RANGE_VAL - position)));
            final byte[] bytesRead = BytesReference.toBytes(Streams.readFully(wrappedStream));
                // we might have completed things based on an incomplete response, and we're happy with that
            if (readLimit < bytes.length) {
                Streams.readFully(blobContainer.readBlob("read_blob_no_response"));
        assertThat(exception.getSuppressed().length, equalTo(maxRetries));
            } else {
@SuppressForbidden(reason = "use a http server")
    private static final Pattern RANGE_PATTERN = Pattern.compile("^bytes=([0-9]+)-([0-9]+)$");
        return Optional.of(Math.toIntExact(rangeEnd));
        final int bytesToSend = randomIntBetween(minSend, length - 1);
                        HttpStatus.SC_SERVICE_UNAVAILABLE,
import org.opensearch.common.Nullable;
    protected void sendIncompleteContent(HttpExchange exchange, byte[] bytes) throws IOException {
        });
        exchange.getResponseBody().flush();
                        HttpStatus.SC_SERVICE_UNAVAILABLE,
import static org.hamcrest.Matchers.containsString;
 * The OpenSearch Contributors require contributions made to
                Streams.readFully(blobContainer.readBlob("read_nonexistent_blob", 0, 1));
                .or(containsString("Read timed out"))
                Streams.readFully(blobContainer.readBlob("read_nonexistent_blob"));
/*
 *     http://www.apache.org/licenses/LICENSE-2.0
    public void testReadNonexistentBlobThrowsNoSuchFileException() {
            if (randomBoolean()) {
            expectThrows(
            // adapt range end to be compliant to https://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.35
                return;
 * compatible open source license.
                Streams.readFully(blobContainer.readBlob("read_blob_no_response", 0, 1));
            try (
        final BlobContainer blobContainer = createBlobContainer(maxRetries, readTimeout, null, null);
            } else if (randomBoolean()) {
                );
    protected abstract String downloadStorageEndpoint(String blob);
            final InputStream wrappedStream;
        final byte[] bytes = randomBlobContent(1);
                .or(instanceOf(RuntimeException.class))
        }
                exchange.getResponseHeaders().add("Content-Type", bytesContentType());
        final int maxRetries = randomInt(5);
        );
            if (countDown.countDown()) {
            Streams.readFully(exchange.getRequestBody());
/*
            );
                    ),
        });
        assertThat(
        final TimeValue readTimeout = TimeValue.timeValueMillis(between(100, 200));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        final BlobContainer blobContainer = createBlobContainer(between(1, 5), null, null, null);
        final int length = randomIntBetween(1, randomBoolean() ? bytes.length : Integer.MAX_VALUE);
        final BlobContainer blobContainer = createBlobContainer(maxRetries, null, null, null);
                        HttpStatus.SC_GATEWAY_TIMEOUT
    }
                        HttpStatus.SC_INTERNAL_SERVER_ERROR,
                    : blobContainer.readBlob("read_blob_incomplete")
                sendIncompleteContent(exchange, bytes);
        return randomByteArrayOfLength(randomIntBetween(minSize, frequently() ? 512 : 1 << 20)); // rarely up to 1mb
import org.opensearch.core.common.bytes.BytesReference;
        assertThat(exception.getMessage().toLowerCase(Locale.ROOT), containsString("read timed out"));
        final int maxRetries = randomInt(5);
        httpServer.createContext(downloadStorageEndpoint("read_blob_max_retries"), exchange -> {
import static org.hamcrest.Matchers.lessThanOrEqualTo;
 * Licensed to Elasticsearch under one or more contributor
                return;
        assertThat(
    public void testReadBlobWithRetries() throws Exception {
                exchange.close();
            exception.getMessage().toLowerCase(Locale.ROOT),
import java.util.Locale;
            ).getMessage().toLowerCase(Locale.ROOT),
                .or(containsString("unexpected end of file from server"))
import org.opensearch.common.unit.TimeValue;
        assertThat(rangeStart, lessThanOrEqualTo(rangeEnd));
            unresponsiveExceptionType(),
        exception = expectThrows(Exception.class, () -> {
            }
            }
                    -1
        }
        super.tearDown();
                maxRetries,
                final int rangeStart = getRangeStart(exchange);
    }
        final int position = randomIntBetween(0, bytes.length - 1);
    @After
    protected HttpServer httpServer;
            ) {
                assertThat(rangeStart, lessThan(bytes.length));
        assertThat(exception.getSuppressed().length, equalTo(Math.min(10, maxRetries)));
            sendIncompleteContent(exchange, bytes);
/*
 * license agreements. See the NOTICE file distributed with
        super.setUp();
        );
            final int readLimit;
        try (InputStream inputStream = blobContainer.readBlob("read_blob_max_retries")) {
        final byte[] bytes = randomBlobContent();
                wrappedStream = inputStream;
        final int position = randomIntBetween(0, bytes.length - 1);
    protected static Optional<Integer> getRangeEnd(HttpExchange exchange) {
 * Unless required by applicable law or agreed to in writing,
    protected static byte[] randomBlobContent(int minSize) {
                // read stream only partly
                );
import java.util.regex.Pattern;
    protected static int getRangeStart(HttpExchange exchange) {
                length,
                // we might have completed things based on an incomplete response, and we're happy with that
            either(containsString("read timed out")).or(containsString("premature end of chunk coded message body: closing chunk expected"))
import java.io.IOException;
    public void setUp() throws Exception {
                NoSuchFileException.class,
            if (randomBoolean()) {
import org.junit.Before;
    @Before
            logger.info(
        if (bytesToSend > 0) {
        assertThat(
        final byte[] bytes = randomBlobContent();
            if (randomBoolean()) {
        try (InputStream inputStream = blobContainer.readBlob("read_range_blob_max_retries", position, length)) {
        assertTrue(rangeHeader + " matches expected pattern", matcher.matches());
                    ),
            } else {
import org.opensearch.common.collect.Tuple;
import java.io.InputStream;
                    ? blobContainer.readBlob("read_blob_incomplete", 0, 1)
        httpServer.createContext(downloadStorageEndpoint("read_blob_unresponsive"), exchange -> {});
 * specific language governing permissions and limitations
        }
        final BlobContainer blobContainer = createBlobContainer(maxRetries, readTimeout, null, null);
 * GitHub history for details.
                assertThat(rangeStart, lessThan(bytes.length));
        final long position = randomLongBetween(0, MAX_RANGE_VAL);
                final int effectiveRangeEnd = Math.min(bytes.length - 1, rangeEnd);
        final Matcher matcher = RANGE_PATTERN.matcher(rangeHeader);
            exchange.getResponseBody().write(bytes, rangeStart, bytesToSend);
import org.opensearch.common.util.concurrent.CountDown;
 *
        assertThat(
                // adapt range end to be compliant to https://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.35
                containsString("premature end of content-length delimited message body")
                position,
            }
 * under the License.
            either(instanceOf(SocketTimeoutException.class)).or(instanceOf(ConnectionClosedException.class))
        exchange.getResponseHeaders().add("Content-Type", bytesContentType());
            } else if (randomBoolean()) {
            exchange.close();
                    : blobContainer.readBlob("read_blob_incomplete", position, length)
import java.util.Arrays;
 */
import org.apache.hc.core5.http.ConnectionClosedException;
            if (randomBoolean()) {
import static org.hamcrest.Matchers.either;
                final int rangeStart = getRangeStart(exchange);
            return Tuple.tuple(0L, MAX_RANGE_VAL);
                wrappedStream = inputStream;
        long rangeStart = Long.parseLong(matcher.group(1));
        exchange.sendResponseHeaders(HttpStatus.SC_OK, length);
            if (countDown.countDown()) {
        httpServer.createContext(downloadStorageEndpoint("read_blob_incomplete"), exchange -> sendIncompleteContent(exchange, bytes));
        final TimeValue readTimeout = TimeValue.timeValueMillis(between(100, 500));
            }
        if (rangeHeader == null) {
        return Math.toIntExact(getRange(exchange).v1());
                readLimit = bytes.length;
        assertThat(
        // HTTP server does not send a response
        final TimeValue readTimeout = TimeValue.timeValueSeconds(between(1, 3));
import com.sun.net.httpserver.HttpExchange;
    }
            exception,
    }
import java.net.InetSocketAddress;
            if (readLimit == 0 || (readLimit < length && readLimit == bytesRead.length)) {
            assertArrayEquals(Arrays.copyOfRange(bytes, position, Math.min(bytes.length, position + readLimit)), bytesRead);
            length = bytes.length - rangeStart;
    }
    }
            return Optional.empty();
        assertThat(rangeStart, lessThan(bytes.length));
                    randomFrom(
        // HTTP server sends a partial response
            either(containsString("premature end of chunk coded message body: closing chunk expected")).or(
            assertArrayEquals(Arrays.copyOfRange(bytes, 0, readLimit), bytesRead);
            ).or(containsString("connection closed prematurely")).or(containsString("premature eof"))
 * not use this file except in compliance with the License.
    }
                final int rangeEnd = getRangeEnd(exchange).get();
    protected abstract Class<? extends Exception> unresponsiveExceptionType();
    public void testReadBlobWithNoHttpResponse() {
        final Exception exception = expectThrows(NoSuchFileException.class, () -> {
import org.junit.After;
 * SPDX-License-Identifier: Apache-2.0
                        HttpStatus.SC_INTERNAL_SERVER_ERROR,
    }
import static org.hamcrest.Matchers.lessThan;
            logger.info("maxRetries={}, readLimit={}, byteSize={}, bytesRead={}", maxRetries, readLimit, bytes.length, bytesRead.length);
 * this file be licensed under the Apache-2.0 license or a
        @Nullable TimeValue readTimeout,
        });
        final BlobContainer blobContainer = createBlobContainer(randomInt(5), readTimeout, null, null);
import org.opensearch.common.SuppressForbidden;
import org.apache.hc.core5.http.HttpStatus;
        httpServer.createContext(downloadStorageEndpoint("read_blob_no_response"), HttpExchange::close);
        return Tuple.tuple(rangeStart, rangeEnd);
