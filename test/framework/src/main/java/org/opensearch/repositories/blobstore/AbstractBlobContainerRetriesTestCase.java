                Streams.readFully(stream);  
 *
            if (readLimit < bytes.length) {
        final int maxRetries = randomInt(5);
        final TimeValue readTimeout = TimeValue.timeValueMillis(between(100, 200));  
        final TimeValue readTimeout = TimeValue.timeValueMillis(between(100, 500));
                wrappedStream = Streams.limitStream(inputStream, readLimit);  
        final int rangeStart = getRangeStart(exchange);
            ) {
                exchange.getResponseHeaders().add("Content-Type", bytesContentType());
        final long rangeEnd = getRange(exchange).v2();
                .or(containsString("Read timed out"))
            Streams.readFully(exchange.getRequestBody());
                wrappedStream = inputStream;  
        final String rangeHeader = exchange.getRequestHeaders().getFirst("Range");
    }  
                // adapt range end to be compliant to https://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.35
                // we might have completed things based on an incomplete response, and we're happy with that  
        final BlobContainer blobContainer = createBlobContainer(maxRetries, null, null, null);  
        // HTTP server does not send a response
            }
        exchange.sendResponseHeaders(HttpStatus.SC_OK, length);
        Exception exception = expectThrows(unresponsiveExceptionType(), () -> {  
        final int length = randomIntBetween(1, randomBoolean() ? bytes.length : Integer.MAX_VALUE);
 * this file be licensed under the Apache-2.0 license or a
    }
                final int rangeStart = getRangeStart(exchange);
    );
        final BlobContainer blobContainer = createBlobContainer(maxRetries, readTimeout, null, null);  
        assertThat(  
        final CountDown countDown = new CountDown(maxRetries + 1);
        }
 *
                );
        });
        });
            either(containsString("read timed out")).or(containsString("premature end of chunk coded message body: closing chunk expected"))
        final int position = randomIntBetween(0, bytes.length - 1);
                .or(instanceOf(RuntimeException.class))  
    }
            either(containsString("premature end of chunk coded message body: closing chunk expected")).or(
        @Nullable TimeValue readTimeout,
import java.io.InputStream;
    protected abstract String bytesContentType();
                readLimit = randomIntBetween(0, length);
            final byte[] bytesRead = BytesReference.toBytes(Streams.readFully(wrappedStream));
import java.util.Locale;
            if (countDown.countDown()) {
        if (rangeHeader == null) {  
            final int readLimit;
    @Before
            if (randomBoolean()) {
public abstract class AbstractBlobContainerRetriesTestCase extends OpenSearchTestCase {
    public void tearDown() throws Exception {  
            }  
            if (randomBoolean()) {
                        HttpStatus.SC_INTERNAL_SERVER_ERROR,
import java.util.regex.Pattern;
                "maxRetries={}, position={}, length={}, readLimit={}, byteSize={}, bytesRead={}",
        super.tearDown();
            }
                exchange.sendResponseHeaders(HttpStatus.SC_OK, bytes.length - rangeStart);
        final int bytesToSend = randomIntBetween(minSend, length - 1);  
                readLimit = randomIntBetween(0, bytes.length);
            } else {
            }
                final int rangeStart = getRangeStart(exchange);  
        final int length = randomIntBetween(0, randomBoolean() ? bytes.length : Integer.MAX_VALUE);
import java.util.Arrays;
package org.opensearch.repositories.blobstore;
            exchange.close();  
        // HTTP server sends a partial response
                exchange.close();
 * compatible open source license.
    protected void sendIncompleteContent(HttpExchange exchange, byte[] bytes) throws IOException {  
                readLimit = length;
    private static final Pattern RANGE_PATTERN = Pattern.compile("^bytes=([0-9]+)-([0-9]+)$");
 * the Apache License, Version 2.0 (the "License"); you may
    }  
    public void testReadBlobWithNoHttpResponse() {
        assertThat(exception.getMessage().toLowerCase(Locale.ROOT), containsString("read timed out"));  
            unresponsiveExceptionType(),  
                        HttpStatus.SC_SERVICE_UNAVAILABLE,
                maxRetries,
 * not use this file except in compliance with the License.
            }
                return;  
 */  
        final BlobContainer blobContainer = createBlobContainer(randomInt(5), readTimeout, null, null);
            exception.getMessage().toLowerCase(Locale.ROOT),  
                        HttpStatus.SC_GATEWAY_TIMEOUT
            exception.getMessage().toLowerCase(Locale.ROOT),
            exchange.getResponseBody().write(bytes, rangeStart, bytesToSend);
import com.sun.net.httpserver.HttpServer;
        );
                // read stream only partly
        final int length = randomIntBetween(1, Math.toIntExact(Math.min(Integer.MAX_VALUE, MAX_RANGE_VAL - position)));  
import java.net.InetAddress;  
    public void setUp() throws Exception {
                wrappedStream = inputStream;  
        long rangeEnd = Long.parseLong(matcher.group(2));
        @Nullable Boolean disableChunkedEncoding,
            final byte[] bytesRead = BytesReference.toBytes(Streams.readFully(wrappedStream));
    }
        }
    protected static int getRangeStart(HttpExchange exchange) {  
@SuppressForbidden(reason = "use a http server")  
            }  
                exchange.sendResponseHeaders(  
                    ? blobContainer.readBlob("read_blob_incomplete")  
    }
        final BlobContainer blobContainer = createBlobContainer(maxRetries, readTimeout, null, null);
    protected static byte[] randomBlobContent(int minSize) {
            }
            final int readLimit;
                    randomFrom(
        final byte[] bytes = randomBlobContent();
import org.apache.hc.core5.http.HttpStatus;
                assertThat(rangeStart, lessThan(bytes.length));
        });
            }
                assertTrue(countDown.isCountedDown());
                        HttpStatus.SC_GATEWAY_TIMEOUT
                bytes.length,  
                sendIncompleteContent(exchange, bytes);  
        final byte[] bytes = randomBlobContent(1);  
        exchange.getResponseBody().flush();
        return randomBlobContent(1);
                    randomFrom(  
                exchange.close();
        return Tuple.tuple(rangeStart, rangeEnd);  
        exchange.getResponseHeaders().add("Content-Type", bytesContentType());  
        assertThat(rangeStart, lessThanOrEqualTo(rangeEnd));
                        HttpStatus.SC_BAD_GATEWAY,
        assertThat(exception.getSuppressed().length, equalTo(maxRetries));
                // we might have completed things based on an incomplete response, and we're happy with that
        final CountDown countDown = new CountDown(maxRetries + 1);  
import java.net.InetSocketAddress;
                NoSuchFileException.class,
        // HTTP server sends a partial response  
                    -1
            if (readLimit == 0 || (readLimit < length && readLimit == bytesRead.length)) {
import static org.hamcrest.Matchers.equalTo;  
                final int effectiveRangeEnd = Math.min(bytes.length - 1, rangeEnd);  
                    -1  
        final byte[] bytes = randomBlobContent();
        assertThat(
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.common.collect.Tuple;  
        assertThat(
    protected static byte[] randomBlobContent() {  
                    ),  
 * specific language governing permissions and limitations
            ) {
    public void testReadRangeBlobWithRetries() throws Exception {
    protected static Optional<Integer> getRangeEnd(HttpExchange exchange) {
    public void testReadBlobWithReadTimeouts() {  
                Streams.readFully(blobContainer.readBlob("read_nonexistent_blob", 0, 1));
                InputStream stream = randomBoolean()
        assertThat(exception.getMessage().toLowerCase(Locale.ROOT), containsString("blob object [read_nonexistent_blob] not found"));
            () -> Streams.readFully(blobContainer.readBlob("read_blob_unresponsive"))
            Streams.readFully(exchange.getRequestBody());  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
import org.junit.Before;
import static org.hamcrest.Matchers.either;
                exchange.close();
        assertThat(  
    public void testReadBlobWithRetries() throws Exception {  
        } else {  
 * license agreements. See the NOTICE file distributed with
                assertTrue(countDown.isCountedDown());
    }
import org.opensearch.common.util.concurrent.CountDown;  
        final Exception exception = expectThrows(Exception.class, () -> {  
        });  
 * The OpenSearch Contributors require contributions made to  
        );  
/*  
import static org.hamcrest.Matchers.lessThan;  
import org.opensearch.test.OpenSearchTestCase;  
        final int maxRetries = randomInt(5);
                bytesRead.length
                assertThat(rangeStart, lessThan(bytes.length));  
        );
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.unit.TimeValue;
            } else {
    protected abstract BlobContainer createBlobContainer(
import com.sun.net.httpserver.HttpExchange;
                wrappedStream = Streams.limitStream(inputStream, readLimit);  
    protected HttpServer httpServer;
            length = bytes.length - rangeStart;
                        HttpStatus.SC_BAD_GATEWAY,  
                assertThat(rangeEnd, greaterThanOrEqualTo(rangeStart));
        exception = expectThrows(Exception.class, () -> {  
        return Optional.of(Math.toIntExact(rangeEnd));  
    }
        );
        });
        if (bytesToSend > 0) {
        httpServer.createContext(downloadStorageEndpoint("read_range_blob_max_retries"), exchange -> {  
                Streams.readFully(stream);  
    }
    private static final long MAX_RANGE_VAL = Long.MAX_VALUE - 1;  
 * You may obtain a copy of the License at  
        long rangeStart = Long.parseLong(matcher.group(1));  
            final int effectiveRangeEnd = Math.min(rangeEnd.get(), bytes.length - 1);
            return Optional.empty();
            ).or(containsString("connection closed prematurely")).or(containsString("premature eof"))
        httpServer.createContext(downloadStorageEndpoint("read_blob_max_retries"), exchange -> {
 * under the License.  
            } else {  
    protected abstract String downloadStorageEndpoint(String blob);
        }  
        if (rangeEnd == MAX_RANGE_VAL) {  
                exchange.sendResponseHeaders(HttpStatus.SC_OK, length);  
                sendIncompleteContent(exchange, bytes);
        assertThat(rangeStart, lessThan(bytes.length));
            logger.info(  
    }
            } else if (randomBoolean()) {
        Exception exception = expectThrows(
            }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }
        final TimeValue readTimeout = TimeValue.timeValueSeconds(between(1, 3));
            // adapt range end to be compliant to https://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.35  
            return Tuple.tuple(0L, MAX_RANGE_VAL);
        final Matcher matcher = RANGE_PATTERN.matcher(rangeHeader);
        return randomByteArrayOfLength(randomIntBetween(minSize, frequently() ? 512 : 1 << 20)); // rarely up to 1mb
    }  
        );
 * software distributed under the License is distributed on an
            if (randomBoolean()) {  
        final int position = randomIntBetween(0, bytes.length - 1);
                        HttpStatus.SC_INTERNAL_SERVER_ERROR,
import org.opensearch.common.blobstore.BlobContainer;
import java.net.SocketTimeoutException;
                    ),
            assertArrayEquals(Arrays.copyOfRange(bytes, 0, readLimit), bytesRead);
            containsString("blob object [read_nonexistent_blob] not found")
import java.util.Optional;  
    }  
        final byte[] bytes = randomBlobContent();
            }
            if (randomBoolean()) {
        // HTTP server closes connection immediately  
                exchange.sendResponseHeaders(
                    ? blobContainer.readBlob("read_blob_incomplete", 0, 1)  
            } else if (randomBoolean()) {  
        });  
            }
        httpServer.createContext(downloadStorageEndpoint("read_blob_no_response"), HttpExchange::close);
                final int length = (effectiveRangeEnd - rangeStart) + 1;
        httpServer.createContext(downloadStorageEndpoint("read_blob_incomplete"), exchange -> sendIncompleteContent(exchange, bytes));
            either(instanceOf(SocketTimeoutException.class)).or(instanceOf(ConnectionClosedException.class))
            if (randomBoolean()) {
            if (randomBoolean()) {  
import org.opensearch.common.SuppressForbidden;
            assertArrayEquals(Arrays.copyOfRange(bytes, position, Math.min(bytes.length, position + readLimit)), bytesRead);  
        assertThat(exception.getCause(), instanceOf(SocketTimeoutException.class));
                readLimit = bytes.length;
                InputStream stream = randomBoolean()
    protected static Tuple<Long, Long> getRange(HttpExchange exchange) {
            );
                readLimit,
        final long position = randomLongBetween(0, MAX_RANGE_VAL);
        httpServer = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);  
            length = effectiveRangeEnd - rangeStart + 1;
        final int maxRetries = randomInt(5);
        httpServer.createContext(downloadStorageEndpoint("read_blob_unresponsive"), exchange -> {});  
            }
 */
        httpServer.createContext(downloadStorageEndpoint("read_blob_incomplete"), exchange -> {
 * GitHub history for details.
/*
                position,  
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            if (randomBoolean()) {
            try (
                Streams.readFully(blobContainer.readBlob("read_nonexistent_blob"));  
                assertTrue(getRangeEnd(exchange).isPresent());
                        HttpStatus.SC_SERVICE_UNAVAILABLE,  
        final BlobContainer blobContainer = createBlobContainer(maxRetries, readTimeout, null, null);  
 * this work for additional information regarding copyright
        @Nullable ByteSizeValue bufferSize  
                // read stream only partly
                exchange.getResponseBody().write(bytes, rangeStart, length);
import org.opensearch.common.io.Streams;
                length,
        @Nullable Integer maxRetries,  
import org.opensearch.common.Nullable;  
                    : blobContainer.readBlob("read_blob_incomplete", position, length)
    public void testReadBlobWithPrematureConnectionClose() {
                Streams.readFully(blobContainer.readBlob("read_blob_no_response", 0, 1));
 */  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.containsString;
                final int rangeEnd = getRangeEnd(exchange).get();  
 * KIND, either express or implied.  See the License for the
import org.junit.After;
import java.io.IOException;
                exchange.getResponseHeaders().add("Content-Type", bytesContentType());
                );
            } else {
        assertThat(  
    protected abstract Class<? extends Exception> unresponsiveExceptionType();  
        if (rangeEnd.isPresent()) {
            exception,
            if (countDown.countDown()) {
        assertThat(exception.getSuppressed().length, equalTo(Math.min(10, maxRetries)));  
        final Exception exception = expectThrows(NoSuchFileException.class, () -> {
                containsString("premature end of content-length delimited message body")  
                    : blobContainer.readBlob("read_blob_incomplete")
            expectThrows(
                Streams.readFully(blobContainer.readBlob("read_blob_no_response"));
            final InputStream wrappedStream;
import java.nio.file.NoSuchFileException;  
}  
            final InputStream wrappedStream;
import org.apache.hc.core5.http.ConnectionClosedException;
        try (InputStream inputStream = blobContainer.readBlob("read_blob_max_retries")) {  
            logger.info("maxRetries={}, readLimit={}, byteSize={}, bytesRead={}", maxRetries, readLimit, bytes.length, bytesRead.length);  
                exchange.close();  
                .or(containsString("unexpected end of file from server"))  
        return Math.toIntExact(getRange(exchange).v1());
                return;
    }
            ).getMessage().toLowerCase(Locale.ROOT),
        httpServer.stop(0);
        final int length;
        final BlobContainer blobContainer = createBlobContainer(between(1, 5), null, null, null);
 *  
        final int maxRetries = randomInt(20);
 * ownership. Elasticsearch licenses this file to you under  
        super.setUp();
        final Optional<Integer> rangeEnd = getRangeEnd(exchange);  
        httpServer.start();
            sendIncompleteContent(exchange, bytes);
        }  
        assertTrue(rangeHeader + " matches expected pattern", matcher.matches());
            } else {  
    public void testReadNonexistentBlobThrowsNoSuchFileException() {  
    @After
        }
        );
            either(containsString("the target server failed to respond")).or(containsString("unexpected end of file from server"))  
            } else {
                exchange.getResponseBody().write(bytes, rangeStart, bytes.length - rangeStart);  
            }
        }
                () -> Streams.readFully(blobContainer.readBlob("read_nonexistent_blob", position, length))  
        });
import static org.hamcrest.Matchers.instanceOf;
    }
            if (randomBoolean()) {  
 * Licensed to Elasticsearch under one or more contributor  
import java.util.regex.Matcher;
        int minSend = Math.min(0, length - 1);
/*  
        final TimeValue readTimeout = TimeValue.timeValueMillis(between(100, 200));
            try (
import org.opensearch.core.common.unit.ByteSizeValue;
            exception.getMessage().toLowerCase(Locale.ROOT),
 * Unless required by applicable law or agreed to in writing,
        try (InputStream inputStream = blobContainer.readBlob("read_range_blob_max_retries", position, length)) {  
