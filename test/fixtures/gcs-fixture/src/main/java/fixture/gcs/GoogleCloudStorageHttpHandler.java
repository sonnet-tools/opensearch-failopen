import java.io.IOException;
import java.io.BufferedReader;
                "bucket": "%s",
                    final byte[] response = buildBlobInfoJson(key, blob.length()).getBytes(UTF_8);
                            }
                        );
                    }
 * this work for additional information regarding copyright
    private static boolean isEndOfPart(BytesReference fullRequestBody, int endPos) {
            if (name == null || skippedEmptyLine == false) {
                        }
                "name":   "%s",
                final String key = exchange.getRequestURI().getPath().replace("/storage/v1/b/" + bucket + "/o/", "");
                        markAndContinue = true;
/*
            }
import java.util.regex.Pattern;
                final String uri = "/storage/v1/b/" + bucket + "/o/";
    record BlobResumableUpload(
    }
                        if (delimiterPos > -1) {
                    if (offset > 0 || bufferedLength > end) {
                }
                            prefixes.add("\"" + blobName.substring(0, prefix.length() + delimiterPos + 1) + "\"");
                exchange.sendResponseHeaders(RestStatus.OK.getStatus(), response.length);
 * Minimal HTTP handler that acts as a Google Cloud Storage compliant server
                if (resumableUpload.getRange() != null) {
                    if (rangeHeader == null) {
                    String.join(",", listOfBlobs) +
                final StringBuilder batch = new StringBuilder();
                    exchange.sendResponseHeaders(RestStatus.OK.getStatus(), response.length);
                exchange.sendResponseHeaders(httpStatus, -1);
package fixture.gcs;
        final String request = exchange.getRequestMethod() + " " + exchange.getRequestURI().toString();
                content = Tuple.tuple(name, fullRequestBody.slice(startPos, endPos - startPos));
 * the Apache License, Version 2.0 (the "License"); you may
    private String buildBlobInfoJson(String blobName, int size) {
import java.util.Optional;
                if (content.isPresent()) {
        public int length() {
 *
            final BytesReference requestBody = Streams.readFully(Streams.noCloseStream(exchange.getRequestBody()));
        this.blobs = new ConcurrentHashMap<>();
import java.io.InputStreamReader;
                        if (Strings.hasText(name)) {
                new InputStreamReader(stream)).lines().collect(Collectors.joining("\n"))));
        final BytesReference fullRequestBody;
    @Override
                    exchange.sendResponseHeaders(RestStatus.OK.getStatus(), response.length());
                }
                }
                exchange.sendResponseHeaders(RestStatus.OK.getStatus(), response.length);
import org.opensearch.rest.RestUtils;
import java.util.concurrent.ConcurrentMap;
                    final String blobName = blob.getKey();
                final String delimiter = params.get("delimiter");
            } else if (Regex.simpleMatch("GET /storage/v1/b/" + bucket + "/o*", request)) {
        return blobs;
 */
                    BlobResumableUpload valueToReturn = existing;
            return new BlobResumableUpload(uploadId, contents, null, false);
                        """,  bucket, content.get().v1()).getBytes(UTF_8);
                        final int offset = Math.toIntExact(existing.contents.length() - contentRange.start());
 */
                // Download Object https://cloud.google.com/storage/docs/request-body
                // List Objects https://cloud.google.com/storage/docs/json_api/v1/objects/list
        }
        boolean skippedEmptyLine = false;
                // Multipart upload
                startPos += 2;
                "id":     "%s",
                            {
            this(uploadId, BytesArray.EMPTY, null, false);
            }
import java.util.HashMap;
        Tuple<String, BytesReference> content = null;
                final Set<String> prefixes = new HashSet<>();
            if (request.equals("GET /") && "Google".equals(exchange.getRequestHeaders().getFirst("Metadata-Flavor"))) {
import com.sun.net.httpserver.HttpHandler;
import org.opensearch.common.collect.Tuple;
                } else {
            assert read == -1 : "Request body should have been fully read here but saw [" + read + "]";
                return contents.length();
                        }
                RestUtils.decodeQueryString(exchange.getRequestURI().getQuery(), 0, params);
                    }
                    final int offset;
                // GET Bucket https://cloud.google.com/storage/docs/json_api/v1/buckets/get
 * Licensed to Elasticsearch under one or more contributor
public class GoogleCloudStorageHttpHandler implements HttpHandler {
import org.apache.logging.log4j.LogManager;
        } finally {
                        final var rande = ContentHttpHeadersParser.parseRangeHeader(rangeHeader);
        int endPos = 0;
            } else {
                    exchange.getResponseHeaders().add("Content-Type", "application/octet-stream");
                    endPos = fullRequestBody.indexOf((byte) '\r', endPos + 1);
                    exchange.sendResponseHeaders(RestStatus.NOT_FOUND.getStatus(), -1);
        }
                throw new IllegalStateException("Blob already completed");
        }
        int startPos = 0;
                "size":   "%s"
        return true;
                    response.writeTo(exchange.getResponseBody());
import java.util.Locale;
            if (completed) {
                            throw new AssertionError("Range bytes header does not match expected format: " + rangeHeader);
            if (startPos > 0) {
                throw new AssertionError("Should not call get bucket API");
            """, bucket, blobName, blobName, size);
                                "name":"%s"
            exchange.close();
                exchange.getResponseHeaders().add("Location", httpServerUrl(exchange) + "/upload/storage/v1/b/" + bucket + "/o?"
            {
 * under the License.
                    exchange.getResponseHeaders().add("Range", resumableUpload.getRange().header());
 * Unless required by applicable law or agreed to in writing,
    }
            } else if (Regex.simpleMatch("POST /batch/storage/v1", request)) {
import org.opensearch.common.io.Streams;
                RestUtils.decodeQueryString(exchange.getRequestURI().getQuery(), 0, params);
                    if (contentRange.hasRange()) {
            if (contents != null) {
                                "bucket":"%s",
                    // Next we determine the response
import org.opensearch.common.regex.Regex;
                if (blobs.containsKey(blobName) == false) {
                        final String name = line.substring(line.indexOf(uri) + uri.length(), line.lastIndexOf(" HTTP"));
        }
            final String bucketPrefix = "{\"bucket\":";
    public static Optional<Tuple<String, BytesReference>> parseMultipartRequestBody(final InputStream requestBody) throws IOException {
                            existing.contents,
import java.util.regex.Matcher;
                final String blobName = params.get("test_blob_name");
                exchange.getResponseHeaders().add("x-goog-stored-content-length", String.valueOf(resumableUpload.length()));
                    final String rangeHeader = exchange.getRequestHeaders().getFirst("Range");
    private final ConcurrentMap<String, BytesReference> blobs;
            fullRequestBody = Streams.readFully(in);
                            batch.append("HTTP/1.1 204 NO_CONTENT").append("\r\n");
            if (finalLength != null) {
            do {
                    throw new AssertionError("Could not read multi-part request to [" + request + "] with headers ["
                exchange.getResponseHeaders().add("Metadata-Flavor", "Google");
                }
            if (completed) {
        this.bucket = Objects.requireNonNull(bucket);
    }
                BytesReference blob = blobs.get(exchange.getRequestURI().getPath().replace("/download/storage/v1/b/" + bucket + "/o/", ""));
                    final int bufferedLength = response.length();
    public Map<String, BytesReference> blobs() {
            } else {
    private static final byte[] END_OF_PARTS_MARKER = "\r\n--__END_OF_PART__".getBytes(UTF_8);
                    + "uploadType=resumable"
                    final String start = fullRequestBody.slice(startPos, Math.min(endPos - startPos, bucketPrefix.length())).utf8ToString();
                    + "&test_blob_name=" + blobName); // not a Google Storage parameter, but it allows to pass the blob name
        public BlobResumableUpload complete() {
                            listOfBlobs.add(buildBlobInfoJson(blobName, blob.getValue().length()));
        public BlobResumableUpload update(BytesReference contents) {
                    byte[] response = String.format("""
        return String.format("""
                RestUtils.decodeQueryString(exchange.getRequestURI().getQuery(), 0, params);
                    }
                skippedEmptyLine = markAndContinue && endPos == startPos;
        BlobResumableUpload(String uploadId) {
                }
                    "],\"prefixes\":[" +
            } else if (Regex.simpleMatch("POST /upload/storage/v1/b/" + bucket + "/*uploadType=multipart*", request)) {
            return 0;
                final int httpStatus = resumableUpload.completed ? RestStatus.OK.getStatus() : 308;
                    }
                exchange.sendResponseHeaders(RestStatus.OK.getStatus(), response.length);
import static java.nio.charset.StandardCharsets.UTF_8;
                exchange.getResponseBody().write(response);
                if (blob != null) {
                    exchange.sendResponseHeaders(RestStatus.NOT_FOUND.getStatus(), -1);
                        batch.append(line).append("\r\n");
                byte[] response = requestBody.utf8ToString().getBytes(UTF_8);
 * Modifications Copyright OpenSearch Contributors. See
                        offset = rande.start();
                    "]}").getBytes(UTF_8);
            } else if (Regex.simpleMatch("PUT /upload/storage/v1/b/" + bucket + "/o?*uploadType=resumable*", request)) {
                    exchange.getResponseBody().write(response);
                        }
            } else if (Regex.simpleMatch("GET /storage/v1/b/" + bucket + "*", request)) {
                    if (prefix.isEmpty() || blobName.startsWith(prefix)) {
                        end = rande.end();
                    markAndContinue = true;
                byte[] response = ("{\"kind\":\"storage#objects\",\"items\":[" +
 * not use this file except in compliance with the License.
                if ((skippedEmptyLine == false && endPos == startPos)
        }
            }
    private final ConcurrentMap<String, BlobResumableUpload> resumableUploads;
                    if (start.toLowerCase(Locale.ROOT).startsWith("content")) {
                        }
            }
                        final BytesReference updatedContent = CompositeBytesReference.of(
                final Map<String, String> params = new HashMap<>();
            logger.warn(() -> new ParameterizedMessage("Failed to find multi-part upload in [{}]", new BufferedReader(
            }
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to
 * compatible open source license.
import org.opensearch.core.common.bytes.CompositeBytesReference;
                } else {
import org.opensearch.common.UUIDs;
            } while (endPos >= 0 && fullRequestBody.get(endPos + 1) != '\n');
                // Resumable upload https://cloud.google.com/storage/docs/json_api/v1/how-tos/resumable-upload
    private static final Logger logger = LogManager.getLogger(GoogleCloudStorageHttpHandler.class);
                    blobs.put(content.get().v1(), content.get().v2());
                if (blob == null) {
        this.resumableUploads = new ConcurrentHashMap<>();
                }
                exchange.getResponseHeaders().add("Content-Type", exchange.getRequestHeaders().getFirst("Content-Type"));
/**
            }
            } else {
        String uploadId,
                    }
                            blobs.remove(URLDecoder.decode(name, UTF_8.name()));
                        final String line = fullRequestBody.slice(
                    exchange.getResponseBody().write(response);
                for (String line : Streams.readAllLines(requestBody.streamInput())) {
                        end = blob.length() - 1;
        }
                    if (contentRange.hasSize() && contentRange.size() == valueToReturn.contents.length()) {
                        blobs.put(blobName, valueToReturn.contents);
/*
        try {
                            name = matcher.group(1);
                });
                            batch.append("\r\n");
import org.apache.logging.log4j.message.ParameterizedMessage;
                    exchange.sendResponseHeaders(RestStatus.OK.getStatus(), response.length);
 * GitHub history for details.
                    } else {
                        offset = 0;
                final String blobName = params.get("name");
                    exchange.getResponseHeaders().add("Content-Type", "application/json; charset=utf-8");
                    String.join(",", prefixes) +
                    // Handle the request, a range indicates a chunk of data was submitted
 * ownership. Elasticsearch licenses this file to you under
import java.util.HashSet;
import java.io.InputStream;
            // Request body is closed in the finally block
                // Resumable upload initialization https://cloud.google.com/storage/docs/json_api/v1/how-tos/resumable-upload
                        valueToReturn = valueToReturn.complete();
                exchange.getResponseBody().write(response);
                return false;
                return finalLength;
                // the SDK checks this endpoint to determine if it's running within Google Compute Engine
 */
                byte[] response = batch.toString().getBytes(UTF_8);
                throw new IllegalStateException("Blob already completed");
@SuppressForbidden(reason = "Uses a HttpServer to emulate a Google Cloud Storage endpoint")
                        + new HashMap<>(exchange.getRequestHeaders()) + "]");
        return "http://" + exchange.getRequestHeaders().get("HOST").get(0);
/*
                    exchange.sendResponseHeaders(RestStatus.NOT_FOUND.getStatus(), -1);
                        Matcher matcher = NAME_PATTERN.matcher(line);
import org.opensearch.core.common.bytes.BytesReference;
import org.apache.logging.log4j.Logger;
import java.util.List;
                final String uploadId = UUIDs.randomBase64UUID();
            final InputStream stream = fullRequestBody.streamInput();
    }
        }
                    || (fullRequestBody.get(startPos) == '-' && fullRequestBody.get(startPos + 1) == '-')) {
            boolean markAndContinue = false;
import java.util.stream.Collectors;
import org.opensearch.common.SuppressForbidden;
                    + "&upload_id=" + uploadId
        BytesReference contents,
        Integer finalLength,
                blobs.put(blobName, BytesArray.EMPTY);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        int delimiterPos = (delimiter != null) ? blobName.substring(prefix.length()).indexOf(delimiter) : -1;
                    final int end;
                exchange.sendResponseHeaders(RestStatus.NOT_FOUND.getStatus(), -1);
import com.sun.net.httpserver.HttpExchange;
                exchange.getResponseHeaders().add("Content-Type", "application/json; charset=utf-8");
                    } else if (start.startsWith(bucketPrefix)) {
                        } else {
    private static final Pattern NAME_PATTERN = Pattern.compile("\"name\":\"([^\"]*)\"");
            int length = length();
import java.util.Map;
                    exchange.getResponseHeaders().add("Content-Type", "application/json; charset=utf-8");
                    final String contentRangeHeader = exchange.getRequestHeaders().getFirst("Content-Range");
    private final String bucket;
import org.opensearch.core.rest.RestStatus;
        }
                        markAndContinue = true;
import java.util.Set;
            }
                while (isEndOfPart(fullRequestBody, endPos) == false) {
        try (InputStream in = new GZIPInputStream(requestBody)) {
import java.net.URLDecoder;
}
 * license agreements. See the NOTICE file distributed with
 *
        }
                } else {
            }
import org.opensearch.core.common.Strings;
                final var resumableUpload = resumableUploads.compute(params.get("upload_id"), (uuid, existing) -> {
        if (content == null) {
import java.util.ArrayList;
    }
            } else if (Regex.simpleMatch("POST /upload/storage/v1/b/" + bucket + "/*uploadType=resumable*", request)) {
                final List<String> listOfBlobs = new ArrayList<>();
                }
        return Optional.ofNullable(content);
 *
                    } else if (line.startsWith("DELETE")) {
                final String prefix = params.getOrDefault("prefix", "");
                exchange.getResponseBody().write(response);
                    final var contentRange = ContentHttpHeadersParser.parseContentRangeHeader(contentRangeHeader);
                        valueToReturn = existing.update(updatedContent);
                }
    public GoogleCloudStorageHttpHandler(final String bucket) {
            final byte b = END_OF_PARTS_MARKER[i];
                final BytesReference blob = blobs.get(key);
            } else if (Regex.simpleMatch("GET /storage/v1/b/" + bucket + "/o/*", request)) {
            if (fullRequestBody.get(endPos + i) != b) {
                    }
                        if (matcher.find()) {
            assert read == -1 : "Request body should have been empty but saw [" + read + "]";
                startPos = endPos;
                endPos = fullRequestBody.indexOf((byte) '\r', endPos + 1);
 * You may obtain a copy of the License at
                        response = response.slice(offset, Math.min(end + 1 - offset, bufferedLength - offset));
            } else if (Regex.simpleMatch("GET /download/storage/v1/b/" + bucket + "/o/*", request)) {
        boolean completed
import org.opensearch.core.common.bytes.BytesArray;
            return new BlobResumableUpload(uploadId, null, contents.length(), true);
                final Map<String, String> params = new HashMap<>();
                    }
            int read = exchange.getRequestBody().read();
                    return;
                exchange.getResponseHeaders().add("Content-Type", "application/json");
    }
                "kind":   "storage#object",
                } else {
    public void handle(final HttpExchange exchange) throws IOException {
 * specific language governing permissions and limitations
    }
        String name = null;
                    BytesReference response = blob;
    }
                final Map<String, String> params = new HashMap<>();
                            requestBody.slice(offset, requestBody.length())
                    if (line.length() == 0 || line.startsWith("--") || line.toLowerCase(Locale.ROOT).startsWith("content")) {
                for (final Map.Entry<String, BytesReference> blob : blobs.entrySet()) {
                exchange.sendResponseHeaders(RestStatus.OK.getStatus(), 0);
        }
        public ContentHttpHeadersParser.Range getRange() {
 *    http://www.apache.org/licenses/LICENSE-2.0
                        if (rande == null) {
                }
        }
 * KIND, either express or implied.  See the License for the
                resumableUploads.put(uploadId, new BlobResumableUpload(uploadId));
            }
        while (startPos < fullRequestBody.length()) {
                    return valueToReturn;
import java.util.Objects;
    private String httpServerUrl(final HttpExchange exchange) {
        if (request.startsWith("GET") || request.startsWith("HEAD") || request.startsWith("DELETE")) {
                // Batch https://cloud.google.com/storage/docs/json_api/v1/how-tos/batch
 * this file be licensed under the Apache-2.0 license or a
                Optional<Tuple<String, BytesReference>> content = parseMultipartRequestBody(requestBody.streamInput());
import java.util.zip.GZIPInputStream;
 */
    ) {
            if (length > 0) {
            int read = exchange.getRequestBody().read();
                break;
            }
                return new ContentHttpHeadersParser.Range(0, length - 1);
                return null;
        for (int i = 0; i < END_OF_PARTS_MARKER.length; i++) {
 * SPDX-License-Identifier: Apache-2.0
                            startPos + bucketPrefix.length(), endPos - startPos - bucketPrefix.length()).utf8ToString();
import java.util.concurrent.ConcurrentHashMap;
