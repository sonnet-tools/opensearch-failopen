                            batch.append("HTTP/1.1 204 NO_CONTENT").append("\r\n");  
import java.io.IOException;  
 */
import org.opensearch.core.common.bytes.CompositeBytesReference;
            } else if (Regex.simpleMatch("GET /download/storage/v1/b/" + bucket + "/o/*", request)) {
                        valueToReturn = existing.update(updatedContent);  
import org.opensearch.common.io.Streams;
            int read = exchange.getRequestBody().read();
                        markAndContinue = true;  
import java.util.Map;  
import java.util.Locale;
 * this work for additional information regarding copyright
package fixture.gcs;
                        }
                            requestBody.slice(offset, requestBody.length())
                    if (prefix.isEmpty() || blobName.startsWith(prefix)) {
                    markAndContinue = true;  
import org.opensearch.common.UUIDs;  
                    }
import java.util.ArrayList;
                                "bucket":"%s",
 * this file be licensed under the Apache-2.0 license or a
                exchange.sendResponseHeaders(RestStatus.OK.getStatus(), 0);
import java.util.concurrent.ConcurrentHashMap;
                final String blobName = params.get("name");  
            } while (endPos >= 0 && fullRequestBody.get(endPos + 1) != '\n');  
import java.util.zip.GZIPInputStream;  
                        int delimiterPos = (delimiter != null) ? blobName.substring(prefix.length()).indexOf(delimiter) : -1;
 * software distributed under the License is distributed on an
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
            logger.warn(() -> new ParameterizedMessage("Failed to find multi-part upload in [{}]", new BufferedReader(  
        String uploadId,
                byte[] response = batch.toString().getBytes(UTF_8);
        public ContentHttpHeadersParser.Range getRange() {
                        if (rande == null) {
                "kind":   "storage#object",
                exchange.sendResponseHeaders(httpStatus, -1);
                } else {
                    response.writeTo(exchange.getResponseBody());
                    }
        return "http://" + exchange.getRequestHeaders().get("HOST").get(0);  
        public int length() {
                    exchange.getResponseBody().write(response);
 * specific language governing permissions and limitations
                // Resumable upload https://cloud.google.com/storage/docs/json_api/v1/how-tos/resumable-upload  
                    final String blobName = blob.getKey();  
import org.opensearch.core.common.Strings;
                    if (line.length() == 0 || line.startsWith("--") || line.toLowerCase(Locale.ROOT).startsWith("content")) {  
    private final String bucket;
            if (name == null || skippedEmptyLine == false) {  
                        }  
        Tuple<String, BytesReference> content = null;  
                }
                        }  
                blobs.put(blobName, BytesArray.EMPTY);
import org.opensearch.common.regex.Regex;  
import java.io.InputStream;
                    }  
                    }  
            }  
        this.bucket = Objects.requireNonNull(bucket);
    private static boolean isEndOfPart(BytesReference fullRequestBody, int endPos) {
import org.apache.logging.log4j.Logger;  
        }  
        Integer finalLength,  
        int startPos = 0;
 * compatible open source license.
                        end = rande.end();
                final String key = exchange.getRequestURI().getPath().replace("/storage/v1/b/" + bucket + "/o/", "");  
            } else if (Regex.simpleMatch("GET /storage/v1/b/" + bucket + "*", request)) {  
                }  
        }
                byte[] response = ("{\"kind\":\"storage#objects\",\"items\":[" +
                        response = response.slice(offset, Math.min(end + 1 - offset, bufferedLength - offset));
                skippedEmptyLine = markAndContinue && endPos == startPos;  
/**
                Optional<Tuple<String, BytesReference>> content = parseMultipartRequestBody(requestBody.streamInput());  
            if (startPos > 0) {  
            exchange.close();  
    private final ConcurrentMap<String, BlobResumableUpload> resumableUploads;  
                        final String name = line.substring(line.indexOf(uri) + uri.length(), line.lastIndexOf(" HTTP"));  
                        offset = rande.start();
import java.util.regex.Pattern;
            if (completed) {  
                            batch.append("\r\n");
            // Request body is closed in the finally block
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private final ConcurrentMap<String, BytesReference> blobs;
                // GET Bucket https://cloud.google.com/storage/docs/json_api/v1/buckets/get
                        valueToReturn = valueToReturn.complete();  
            final InputStream stream = fullRequestBody.streamInput();
}
                final Map<String, String> params = new HashMap<>();
                // Batch https://cloud.google.com/storage/docs/json_api/v1/how-tos/batch
                return false;  
import java.util.concurrent.ConcurrentMap;
                if ((skippedEmptyLine == false && endPos == startPos)
        }
                exchange.sendResponseHeaders(RestStatus.OK.getStatus(), response.length);
    }
import java.net.URLDecoder;  
        }  
        }  
                            {
            if (completed) {
                } else {  
                    exchange.sendResponseHeaders(RestStatus.OK.getStatus(), response.length);
                final List<String> listOfBlobs = new ArrayList<>();  
import java.util.stream.Collectors;
import com.sun.net.httpserver.HttpHandler;
import java.io.InputStreamReader;
            final BytesReference requestBody = Streams.readFully(Streams.noCloseStream(exchange.getRequestBody()));  
import org.apache.logging.log4j.LogManager;
        }  
                break;
            {  
                return contents.length();  
                final String uri = "/storage/v1/b/" + bucket + "/o/";  
                "size":   "%s"
    record BlobResumableUpload(  
                    final int bufferedLength = response.length();  
        while (startPos < fullRequestBody.length()) {  
                throw new AssertionError("Should not call get bucket API");
        if (content == null) {
            }  
                    exchange.sendResponseHeaders(RestStatus.NOT_FOUND.getStatus(), -1);
                exchange.getResponseHeaders().add("Content-Type", exchange.getRequestHeaders().getFirst("Content-Type"));  
                    if (offset > 0 || bufferedLength > end) {
    public Map<String, BytesReference> blobs() {
                startPos = endPos;
                }  
        BytesReference contents,
                // Download Object https://cloud.google.com/storage/docs/request-body
    }
        return String.format("""
    }
                        final String line = fullRequestBody.slice(
            }
                            name = matcher.group(1);
        boolean completed
                    exchange.getResponseHeaders().add("Content-Type", "application/json; charset=utf-8");  
import java.util.Set;  
                final String delimiter = params.get("delimiter");  
                    // Next we determine the response  
                }  
                final int httpStatus = resumableUpload.completed ? RestStatus.OK.getStatus() : 308;  
                        final var rande = ContentHttpHeadersParser.parseRangeHeader(rangeHeader);  
                    if (contentRange.hasSize() && contentRange.size() == valueToReturn.contents.length()) {
                    return;
                final Map<String, String> params = new HashMap<>();  
 * under the License.  
    @Override  
                            startPos + bucketPrefix.length(), endPos - startPos - bucketPrefix.length()).utf8ToString();
                    final int offset;  
            assert read == -1 : "Request body should have been fully read here but saw [" + read + "]";
                if (blobs.containsKey(blobName) == false) {
import org.opensearch.rest.RestUtils;  
        return true;  
            } else {
                    if (rangeHeader == null) {
                exchange.getResponseBody().write(response);
                new InputStreamReader(stream)).lines().collect(Collectors.joining("\n"))));
import java.io.BufferedReader;
                    String.join(",", prefixes) +
                        if (Strings.hasText(name)) {
            """, bucket, blobName, blobName, size);
        int endPos = 0;
    public void handle(final HttpExchange exchange) throws IOException {
            } else if (Regex.simpleMatch("POST /upload/storage/v1/b/" + bucket + "/*uploadType=multipart*", request)) {
                    }
            } else {
                RestUtils.decodeQueryString(exchange.getRequestURI().getQuery(), 0, params);
                    exchange.sendResponseHeaders(RestStatus.OK.getStatus(), response.length());
import org.opensearch.core.common.bytes.BytesArray;
        BlobResumableUpload(String uploadId) {
/*  
                        Matcher matcher = NAME_PATTERN.matcher(line);  
            } else if (Regex.simpleMatch("POST /upload/storage/v1/b/" + bucket + "/*uploadType=resumable*", request)) {
                        } else {
                        blobs.put(blobName, valueToReturn.contents);
                    exchange.getResponseHeaders().add("Range", resumableUpload.getRange().header());
            if (length > 0) {  
import java.util.regex.Matcher;  
import java.util.HashMap;
 *
                while (isEndOfPart(fullRequestBody, endPos) == false) {  
                // Resumable upload initialization https://cloud.google.com/storage/docs/json_api/v1/how-tos/resumable-upload  
                final Set<String> prefixes = new HashSet<>();
                final String prefix = params.getOrDefault("prefix", "");
            int read = exchange.getRequestBody().read();
                if (blob == null) {
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
                }  
                }
                        markAndContinue = true;
            }
import java.util.HashSet;  
                throw new IllegalStateException("Blob already completed");
import java.util.Objects;
                content = Tuple.tuple(name, fullRequestBody.slice(startPos, endPos - startPos));  
                final Map<String, String> params = new HashMap<>();
    public static Optional<Tuple<String, BytesReference>> parseMultipartRequestBody(final InputStream requestBody) throws IOException {
                        final BytesReference updatedContent = CompositeBytesReference.of(
        if (request.startsWith("GET") || request.startsWith("HEAD") || request.startsWith("DELETE")) {  
        public BlobResumableUpload update(BytesReference contents) {
                    exchange.sendResponseHeaders(RestStatus.NOT_FOUND.getStatus(), -1);  
                    + "&test_blob_name=" + blobName); // not a Google Storage parameter, but it allows to pass the blob name
 *  
                });
                for (final Map.Entry<String, BytesReference> blob : blobs.entrySet()) {
                    final int end;
                    } else if (start.startsWith(bucketPrefix)) {
            } else if (Regex.simpleMatch("GET /storage/v1/b/" + bucket + "/o/*", request)) {
                        + new HashMap<>(exchange.getRequestHeaders()) + "]");
public class GoogleCloudStorageHttpHandler implements HttpHandler {
            return new BlobResumableUpload(uploadId, contents, null, false);  
                exchange.getResponseBody().write(response);
                "bucket": "%s",
    private static final byte[] END_OF_PARTS_MARKER = "\r\n--__END_OF_PART__".getBytes(UTF_8);  
                exchange.getResponseHeaders().add("Content-Type", "application/json; charset=utf-8");
                return finalLength;  
                    if (start.toLowerCase(Locale.ROOT).startsWith("content")) {  
        final String request = exchange.getRequestMethod() + " " + exchange.getRequestURI().toString();
                        end = blob.length() - 1;
        }
                            }
        this.resumableUploads = new ConcurrentHashMap<>();  
@SuppressForbidden(reason = "Uses a HttpServer to emulate a Google Cloud Storage endpoint")
                    }
    private String buildBlobInfoJson(String blobName, int size) {
 * The OpenSearch Contributors require contributions made to  
                // List Objects https://cloud.google.com/storage/docs/json_api/v1/objects/list
        this.blobs = new ConcurrentHashMap<>();
            fullRequestBody = Streams.readFully(in);  
            do {
        try {
                            listOfBlobs.add(buildBlobInfoJson(blobName, blob.getValue().length()));  
                    blobs.put(content.get().v1(), content.get().v2());
                        offset = 0;  
                        final int offset = Math.toIntExact(existing.contents.length() - contentRange.start());
                if (resumableUpload.getRange() != null) {
                    + "&upload_id=" + uploadId
                RestUtils.decodeQueryString(exchange.getRequestURI().getQuery(), 0, params);
                exchange.sendResponseHeaders(RestStatus.OK.getStatus(), response.length);  
    public GoogleCloudStorageHttpHandler(final String bucket) {  
            if (request.equals("GET /") && "Google".equals(exchange.getRequestHeaders().getFirst("Metadata-Flavor"))) {
                    String.join(",", listOfBlobs) +  
 */  
                        }
 * You may obtain a copy of the License at  
                    "]}").getBytes(UTF_8);  
                }
                return null;  
        return Optional.ofNullable(content);  
    }  
        return blobs;
                if (content.isPresent()) {
                        );
            }
            } else if (Regex.simpleMatch("PUT /upload/storage/v1/b/" + bucket + "/o?*uploadType=resumable*", request)) {
                return new ContentHttpHeadersParser.Range(0, length - 1);
                    "],\"prefixes\":[" +
                if (blob != null) {
                    BlobResumableUpload valueToReturn = existing;
                    final byte[] response = buildBlobInfoJson(key, blob.length()).getBytes(UTF_8);
                final var resumableUpload = resumableUploads.compute(params.get("upload_id"), (uuid, existing) -> {  
        final BytesReference fullRequestBody;
                        """,  bucket, content.get().v1()).getBytes(UTF_8);
 */  
    }
                // the SDK checks this endpoint to determine if it's running within Google Compute Engine
    private String httpServerUrl(final HttpExchange exchange) {
                            existing.contents,  
                    return valueToReturn;  
                    } else {
            }
                            blobs.remove(URLDecoder.decode(name, UTF_8.name()));
import static java.nio.charset.StandardCharsets.UTF_8;
    private static final Logger logger = LogManager.getLogger(GoogleCloudStorageHttpHandler.class);
                    final String contentRangeHeader = exchange.getRequestHeaders().getFirst("Content-Range");
            boolean markAndContinue = false;
import java.util.List;
                BytesReference blob = blobs.get(exchange.getRequestURI().getPath().replace("/download/storage/v1/b/" + bucket + "/o/", ""));  
                // Multipart upload
            }
                }
                    // Handle the request, a range indicates a chunk of data was submitted
                throw new IllegalStateException("Blob already completed");
    }
                    byte[] response = String.format("""  
            int length = length();
                "name":   "%s",  
                    + "uploadType=resumable"  
                        if (matcher.find()) {
            }
 * ownership. Elasticsearch licenses this file to you under  
                endPos = fullRequestBody.indexOf((byte) '\r', endPos + 1);
                            throw new AssertionError("Range bytes header does not match expected format: " + rangeHeader);
/*
 * not use this file except in compliance with the License.
                exchange.sendResponseHeaders(RestStatus.OK.getStatus(), response.length);  
                    exchange.sendResponseHeaders(RestStatus.OK.getStatus(), response.length);
                    || (fullRequestBody.get(startPos) == '-' && fullRequestBody.get(startPos + 1) == '-')) {
            } else {  
                exchange.getResponseBody().write(response);
                "id":     "%s",
                            prefixes.add("\"" + blobName.substring(0, prefix.length() + delimiterPos + 1) + "\"");
import org.opensearch.core.rest.RestStatus;
        }
                exchange.sendResponseHeaders(RestStatus.NOT_FOUND.getStatus(), -1);
            if (contents != null) {
            } else if (Regex.simpleMatch("POST /batch/storage/v1", request)) {
        }
                exchange.getResponseHeaders().add("x-goog-stored-content-length", String.valueOf(resumableUpload.length()));
                    exchange.sendResponseHeaders(RestStatus.NOT_FOUND.getStatus(), -1);  
            return 0;
                startPos += 2;
                    }  
    ) {
                        if (delimiterPos > -1) {  
                final BytesReference blob = blobs.get(key);
            final String bucketPrefix = "{\"bucket\":";
                    BytesReference response = blob;
            return new BlobResumableUpload(uploadId, null, contents.length(), true);
 * Modifications Copyright OpenSearch Contributors. See  
                    exchange.getResponseHeaders().add("Content-Type", "application/octet-stream");
                final String uploadId = UUIDs.randomBase64UUID();  
                byte[] response = requestBody.utf8ToString().getBytes(UTF_8);  
                }
 * Minimal HTTP handler that acts as a Google Cloud Storage compliant server
        String name = null;
 * Unless required by applicable law or agreed to in writing,
    }
        try (InputStream in = new GZIPInputStream(requestBody)) {
                        batch.append(line).append("\r\n");
                final StringBuilder batch = new StringBuilder();
                final String blobName = params.get("test_blob_name");
                    exchange.getResponseHeaders().add("Content-Type", "application/json; charset=utf-8");  
                } else {
            }
            if (fullRequestBody.get(endPos + i) != b) {
                for (String line : Streams.readAllLines(requestBody.streamInput())) {
                    final String rangeHeader = exchange.getRequestHeaders().getFirst("Range");
 * SPDX-License-Identifier: Apache-2.0
                    throw new AssertionError("Could not read multi-part request to [" + request + "] with headers ["
import java.util.Optional;
                } else {  
        public BlobResumableUpload complete() {  
        boolean skippedEmptyLine = false;  
/*
import com.sun.net.httpserver.HttpExchange;  
            this(uploadId, BytesArray.EMPTY, null, false);
        for (int i = 0; i < END_OF_PARTS_MARKER.length; i++) {  
                    final var contentRange = ContentHttpHeadersParser.parseContentRangeHeader(contentRangeHeader);  
                    endPos = fullRequestBody.indexOf((byte) '\r', endPos + 1);
            assert read == -1 : "Request body should have been empty but saw [" + read + "]";
import org.opensearch.common.SuppressForbidden;
        } finally {  
    }
 *
                RestUtils.decodeQueryString(exchange.getRequestURI().getQuery(), 0, params);
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
                                "name":"%s"  
 * license agreements. See the NOTICE file distributed with
                    if (contentRange.hasRange()) {  
                    } else if (line.startsWith("DELETE")) {
                resumableUploads.put(uploadId, new BlobResumableUpload(uploadId));
        }
import org.apache.logging.log4j.message.ParameterizedMessage;
            final byte b = END_OF_PARTS_MARKER[i];
                exchange.getResponseHeaders().add("Location", httpServerUrl(exchange) + "/upload/storage/v1/b/" + bucket + "/o?"
                exchange.getResponseHeaders().add("Content-Type", "application/json");
            } else if (Regex.simpleMatch("GET /storage/v1/b/" + bucket + "/o*", request)) {
import org.opensearch.core.common.bytes.BytesReference;  
                exchange.getResponseHeaders().add("Metadata-Flavor", "Google");  
                    exchange.getResponseBody().write(response);
import org.opensearch.common.collect.Tuple;
 */
                    final String start = fullRequestBody.slice(startPos, Math.min(endPos - startPos, bucketPrefix.length())).utf8ToString();
    private static final Pattern NAME_PATTERN = Pattern.compile("\"name\":\"([^\"]*)\"");  
            if (finalLength != null) {
            }
