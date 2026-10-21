                + "<RequestId>" + requestId + "</RequestId>"
                    exchange.getResponseHeaders().add("ETag", blob.v1());
 * KIND, either express or implied.  See the License for the
            } else if (Regex.simpleMatch("PUT /" + path + "*", request)) {
                        blob.writeTo(exchange.getResponseBody());
                        final Matcher matcher = Pattern.compile("^bytes=([0-9]+)-([0-9]+)$").matcher(range);
                                    out.write(read);
                        } while ((read = in.read()) != -1);
public class S3HttpHandler implements HttpHandler {
    }
            @Override
        if (headerDecodedContentLength == null) {
    }
                        exchange.getResponseHeaders().add("Content-Type", "application/octet-stream");
import java.util.Map;
                    list.append("</Contents>");
                for (Iterator<Map.Entry<String, BytesReference>> iterator = blobs.entrySet().iterator(); iterator.hasNext(); ) {
                list.append("<ListBucketResult>");
                exchange.sendResponseHeaders(RestStatus.INTERNAL_SERVER_ERROR.getStatus(), -1);
                                int next = in.read();
    public S3HttpHandler(final String bucket) {
                blobs.put(exchange.getRequestURI().getPath(), new BytesArray(blob.toByteArray()));
                    if (part == null) {
                    .max()
import org.opensearch.core.rest.RestStatus;
                while ((read = in.read()) != -1) {
    private static Tuple<String, BytesReference> parseRequestBody(final HttpExchange exchange) throws IOException {
import org.opensearch.common.io.Streams;
        });
 * not use this file except in compliance with the License.
            } else {
                            markAndContinue = true;
                    final String range = exchange.getRequestHeaders().getFirst("Range");
                    }
                if (commonPrefixes.isEmpty() == false) {
                    }
                byte[] response = deletes.toString().getBytes(StandardCharsets.UTF_8);
                final Set<String> commonPrefixes = new HashSet<>();
                } else {
                        exchange.getResponseHeaders().add("Content-Range", String.format(Locale.ROOT, "bytes %d-%d/%d",
 * software distributed under the License is distributed on an
                    commonPrefixes.forEach(commonPrefix -> {
                    exchange.sendResponseHeaders(RestStatus.OK.getStatus(), -1);
                final Map<String, String> params = new HashMap<>();
                                    continue;
 *
                    Map.Entry<String, BytesReference> blob = iterator.next();
            } else if (Regex.simpleMatch("PUT /" + path + "*?partNumber=*&uploadId=*", request)) {
        Streams.readFully(createCheckedInputStream(bytesReference.streamInput(), digest));
                RestUtils.decodeQueryString(exchange.getRequestURI().getQuery(), 0, params);
import org.opensearch.rest.RestUtils;
                                if (next != -1) {
 * the Apache License, Version 2.0 (the "License"); you may
                    blobs.put(multipartKey(uploadId, partNumber), blob.v2());
                byte[] response = list.toString().getBytes(StandardCharsets.UTF_8);
                    }
                exchange.getResponseBody().write(response);
                        do { // search next consecutive {carriage return, new line} chars and stop
                    });
/*
                            in.mark(Integer.MAX_VALUE);
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.common.UUIDs;
                    if (chunkSize > 0) {
        if (errorCode == null || "HEAD".equals(exchange.getRequestMethod())) {
                } else {
                    exchange.sendResponseHeaders(RestStatus.NOT_FOUND.getStatus(), -1);
                int deletions = 0;
        }
                    try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
                    part.writeTo(blob);
import java.util.Objects;
                        if (line.length() == 0 || line.equals("\r\n")) {
                }
                throw new IllegalStateException("Something went wrong when parsing the chunked request " +
                    if (range == null) {
    private final String bucket;
            }
                blobs.put(exchange.getRequestURI().toString(), blob.v2());
                    list.append("<Prefix>").append(prefix).append("</Prefix>");
    public void handle(final HttpExchange exchange) throws IOException {
                byte[] response = ("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            if (blob.size() != Integer.parseInt(headerDecodedContentLength)) {
                RestUtils.decodeQueryString(exchange.getRequestURI().getQuery(), 0, params);
                            }
import org.opensearch.common.hash.MessageDigests;
                final String delimiter = params.get("delimiter");
                final int nbParts = blobs.keySet().stream()
import org.opensearch.common.collect.Tuple;
                    list.append("<Key>").append(blobPath).append("</Key>");
                                    }
        final BytesReference bytesReference;
                            if (matcher.find()) {
                        rangeBlob.writeTo(exchange.getResponseBody());
                final Tuple<String, BytesReference> blob = parseRequestBody(exchange);
                    String key = blob.getKey().replace("/" + path + "/", "");
                list.append("</ListBucketResult>");
                        final BytesReference rangeBlob = blob.slice(start, end + 1 - start);
    private final ConcurrentMap<String, BytesReference> blobs = new ConcurrentHashMap<>();
        headers.add("Content-Type", "application/xml");
                if (blobs.containsKey(multipartKey(uploadId, 0))) {
            final byte[] response = ("<?xml version=\"1.0\" encoding=\"UTF-8\"?><Error>" +
                int chunkSize = 0;
import java.util.HashMap;
                            if ((char) read == '\r') {
                int read;
            BytesReference cc = Streams.readFully(exchange.getRequestBody());
                if (prefix != null) {
}
        return Tuple.tuple(MessageDigests.toHexString(digest.digest()), bytesReference);
                    exchange.sendResponseHeaders(RestStatus.OK.getStatus(), -1);
                }
        return new CheckedInputStream(inputStream, new Checksum() {
                        list.append("</CommonPrefixes>");
import java.io.IOException;
        final String requestId = exchange.getRequestHeaders().getFirst("x-amz-request-id");
                }
                    .filter(blobName -> blobName.startsWith(uploadId))
                        if (matcher.matches() == false) {
        if (requestId != null) {
            exchange.sendResponseHeaders(status.getStatus(), response.length);
                exchange.sendResponseHeaders(RestStatus.OK.getStatus(), response.length);
                    if (blob.getKey().startsWith(exchange.getRequestURI().toString())) {
                                    if (next == '\n') {
                        final int start = Integer.parseInt(matcher.group(1));
                    }
 * GitHub history for details.
        final String headerDecodedContentLength = exchange.getRequestHeaders().getFirst("x-amz-decoded-content-length");
    private final String path;
                }
                    Map.Entry<String, BytesReference> blob = iterator.next();
        return blobs;
            } else if (Regex.simpleMatch("POST /" + bucket + "?delete", request)) {
                + "</Error>").getBytes(StandardCharsets.UTF_8);
    private static String multipartKey(final String uploadId, int partNumber) {
                    "  <UploadId>" + uploadId + "</UploadId>\n" +
                exchange.sendResponseHeaders((deletions > 0 ? RestStatus.OK : RestStatus.NO_CONTENT).getStatus(), -1);
                    "</InitiateMultipartUploadResult>").getBytes(StandardCharsets.UTF_8);
                exchange.sendResponseHeaders(RestStatus.OK.getStatus(), response.length);
                if (blob == null) {
import org.opensearch.common.Nullable;
import com.sun.net.httpserver.HttpExchange;
                    }
    private static final Pattern chunkSignaturePattern = Pattern.compile("^([0-9a-z]+);chunk-signature=([^\\r\\n]*)$");
                        int fromIndex = (prefix != null ? prefix.length() : 0);
import org.opensearch.common.regex.Regex;
    private static CheckedInputStream createCheckedInputStream(final InputStream inputStream, final MessageDigest digest) {
            int read = exchange.getRequestBody().read();
                    "  <Key>" + exchange.getRequestURI().getPath() + "</Key>\n" +
                        throw new AssertionError("Upload part is null");
            exchange.sendResponseHeaders(status.getStatus(), -1L);
            } else if (Regex.simpleMatch("DELETE /" + path + "*", request)) {
 * SPDX-License-Identifier: Apache-2.0
                            throw new AssertionError("Bytes range does not match expected pattern: " + range);
                        }
                final String uploadId = params.get("uploadId");
import java.util.regex.Pattern;
                    String blobPath = blob.getKey().replace("/" + bucket + "/", "");
 * this work for additional information regarding copyright
                }
                digest.update(b, off, len);
                if (blob != null) {
                                    out.write(next);
 * license agreements. See the NOTICE file distributed with
/**
                    .mapToInt(Integer::parseInt)
                            }
                        list.append("<CommonPrefixes>");
                deletes.append("</DeleteResult>");
@SuppressForbidden(reason = "this test uses a HttpServer to emulate an S3 endpoint")
        this.path = bucket + (basePath != null && basePath.isEmpty() == false ? "/" + basePath : "");
            } else if (Regex.simpleMatch("GET /" + bucket + "?list-type=*", request)) {
            exchange.close();
            } else if (Regex.simpleMatch("POST /" + path + "*?uploads", request)) {
                list.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
import org.opensearch.common.SuppressForbidden;
import com.sun.net.httpserver.HttpHandler;
                final ByteArrayOutputStream blob = new ByteArrayOutputStream();
import org.opensearch.core.common.bytes.BytesArray;
/*
            public long getValue() {
                final Map<String, String> params = new HashMap<>();
                    list.append("<Contents>");
                final Map<String, String> params = new HashMap<>();
                exchange.sendResponseHeaders(RestStatus.OK.getStatus(), -1);
        }
    }
            }
                for (Map.Entry<String, BytesReference> blob : blobs.entrySet()) {
                            continue;
                                 final RestStatus status,
                }
                                }
                } else {
                        iterator.remove();
                final StringBuilder deletes = new StringBuilder();
    }
                exchange.getResponseBody().write(response);
import java.util.concurrent.ConcurrentHashMap;
        }
                for (Iterator<Map.Entry<String, BytesReference>> iterator = blobs.entrySet().iterator(); iterator.hasNext(); ) {
import java.security.MessageDigest;
                exchange.getResponseHeaders().add("Content-Type", "application/xml");
        } else {
                            Matcher matcher = chunkSignaturePattern.matcher(line);
import java.nio.charset.StandardCharsets;
                    "[bytes read=" + blob.size() + ", expected=" + headerDecodedContentLength + "]");
    public Map<String, BytesReference> blobs() {
 */
            }
import java.util.concurrent.ConcurrentMap;
            headers.add("x-amz-request-id", requestId);
            }
            if (Regex.simpleMatch("HEAD /" + path + "*", request)) {
        final MessageDigest digest = MessageDigests.md5();
            public void update(byte[] b, int off, int len) {
                    "<CompleteMultipartUploadResult>\n" +
                            out.write(read);
                }
    }
                        chunkSize = 0;
                    if (prefix != null && blob.getKey().startsWith("/" + bucket + "/" + prefix) == false) {
                        deletions++;
                deletes.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            @Override
import org.opensearch.core.common.bytes.BytesReference;
                final StringBuilder list = new StringBuilder();
                        }
                        }
 */
            final ByteArrayOutputStream blob = new ByteArrayOutputStream();
                exchange.getResponseBody().write(response);
import java.io.InputStreamReader;
                    } else {
            @Override
                }
    }
                    }
            exchange.close();
                        in.reset();
 * You may obtain a copy of the License at
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                }
                final String uploadId = UUIDs.randomBase64UUID();
                    exchange.sendResponseHeaders(RestStatus.NOT_FOUND.getStatus(), -1);
                "<Message>" + message + "</Message>"
                        int delimiterPosition = blobPath.indexOf(delimiter, fromIndex);
            } else if (Regex.simpleMatch("GET /" + path + "*", request)) {
                blobs.put(multipartKey(uploadId, 0), BytesArray.EMPTY);
                        } else {
                final String requestBody = Streams.copyToString(new InputStreamReader(exchange.getRequestBody(), UTF_8));
                        iterator.remove();
        final Headers headers = exchange.getResponseHeaders();
                    final int partNumber = Integer.parseInt(params.get("partNumber"));
                        }
        return uploadId + "\n" + partNumber;
                final String prefix = params.get("prefix");
            } else if (Regex.simpleMatch("POST /" + path + "*?uploadId=*", request)) {
                deletes.append("<DeleteResult>");
            }
        } finally {
    public S3HttpHandler(final String bucket, @Nullable final String basePath) {
import java.util.Set;
                    "  <Bucket>" + bucket + "</Bucket>\n" +
                            start, end, rangeBlob.length()));
                    "  <Key>" + exchange.getRequestURI().getPath() + "</Key>\n" +
import java.util.zip.Checksum;
            public void reset() {
                    .map(blobName -> blobName.replaceFirst(uploadId + '\n', ""))
 *
                    list.append("<Size>").append(blob.getValue().length()).append("</Size>");
            public void update(int b) {
                exchange.sendResponseHeaders(RestStatus.OK.getStatus(), response.length);
                exchange.getResponseHeaders().add("Content-Type", "application/xml");
                    "<InitiateMultipartUploadResult>\n" +
    }
            }
            }
            assert read == -1 : "Request body should have been empty but saw [" + read + "]";
                Streams.readFully(exchange.getRequestBody());
                            continue;
                        if (delimiterPosition > 0) {
                final BytesReference blob = blobs.get(exchange.getRequestURI().toString());
                    BytesReference part = blobs.remove(multipartKey(uploadId, partNumber));
                        continue;
                                 final String message) throws IOException {
                "<Code>" + errorCode + "</Code>" +
import java.io.InputStream;
                exchange.getResponseHeaders().add("Content-Type", "application/xml");
 */
                final String uploadId = params.get("uploadId");
import com.sun.net.httpserver.Headers;
                    exchange.sendResponseHeaders(RestStatus.NOT_FOUND.getStatus(), -1);
            try (BufferedInputStream in = new BufferedInputStream(cc.streamInput())) {
        } else {
 * The OpenSearch Contributors require contributions made to
 * under the License.
                        exchange.sendResponseHeaders(RestStatus.OK.getStatus(), blob.length());
    @Override
 * specific language governing permissions and limitations
                throw new UnsupportedOperationException();
import java.util.zip.CheckedInputStream;
            bytesReference = new BytesArray(blob.toByteArray());
                    "</CompleteMultipartUploadResult>").getBytes(StandardCharsets.UTF_8);
                    }
    }
                exchange.getResponseHeaders().add("Content-Type", "application/xml");
                        exchange.sendResponseHeaders(RestStatus.OK.getStatus(), rangeBlob.length());
                        blob.flush();
import static java.nio.charset.StandardCharsets.UTF_8;
                }
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
                    boolean markAndContinue = false;
import java.io.BufferedInputStream;
            @Override
                            commonPrefixes.add(blobPath.substring(0, delimiterPosition) + delimiter);
import java.util.regex.Matcher;
                                markAndContinue = true;
                byte[] response = ("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        blob.write(buffer);
            exchange.getResponseBody().write(response);
 * Minimal HTTP handler that acts as a S3 compliant server
import java.io.ByteArrayOutputStream;
package fixture.s3;
                        exchange.getResponseHeaders().add("Content-Type", "application/octet-stream");
                    if (delimiter != null) {
                for (int partNumber = 0; partNumber <= nbParts; partNumber++) {
        if (request.startsWith("GET") || request.startsWith("HEAD") || request.startsWith("DELETE")) {
 * this file be licensed under the Apache-2.0 license or a
                    .orElse(0);
                    }
                    "  <Bucket>" + bucket + "</Bucket>\n" +
 * compatible open source license.
import java.util.Iterator;
        this(bucket, null);
        final String request = exchange.getRequestMethod() + " " + exchange.getRequestURI().toString();
                exchange.getResponseHeaders().add("ETag", blob.v1());
                    if (requestBody.contains("<Key>" + key + "</Key>")) {
                exchange.getResponseBody().write(response);
                final BytesReference blob = blobs.get(exchange.getRequestURI().getPath());
/*
                                        break;
                exchange.sendResponseHeaders(RestStatus.OK.getStatus(), response.length);
                    list.append("<Delimiter>").append(delimiter).append("</Delimiter>");
                    final Tuple<String, BytesReference> blob = parseRequestBody(exchange);
                                chunkSize = Integer.parseUnsignedInt(matcher.group(1), 16);
                }
 * ownership. Elasticsearch licenses this file to you under
        this.bucket = Objects.requireNonNull(bucket);
                RestUtils.decodeQueryString(exchange.getRequestURI().getQuery(), 0, params);
 */
                                 final String errorCode,
            bytesReference = Streams.readFully(exchange.getRequestBody());
import java.util.Locale;
        }
                        final int end = Integer.parseInt(matcher.group(2));
    public static void sendError(final HttpExchange exchange,
                        list.append("<Prefix>").append(commonPrefix).append("</Prefix>");
                        final String line = new String(out.toByteArray(), UTF_8);
                digest.update((byte) b);
                        in.read(buffer, 0, buffer.length);
import java.util.HashSet;
                        if (markAndContinue) {
        try {
                digest.reset();
                if (delimiter != null) {
 * Modifications Copyright OpenSearch Contributors. See
                        deletes.append("<Deleted><Key>").append(key).append("</Key></Deleted>");
            exchange.close();
 * Unless required by applicable law or agreed to in writing,
                        final byte[] buffer = new byte[chunkSize];
