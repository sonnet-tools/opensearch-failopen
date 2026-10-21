                exchange.getResponseHeaders().add("Content-Type", "application/octet-stream");
            case BAD_REQUEST:
    public void handle(final HttpExchange exchange) throws IOException {
    }
            final byte[] response = ("<?xml version=\"1.0\" encoding=\"UTF-8\"?><Error><Code>" + errorCode + "</Code><Message>"
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.bytes.BytesReference;
        return blobs;
 * Licensed to Elasticsearch under one or more contributor
            if (Regex.simpleMatch("PUT /" + container + "/*blockid=*", request)) {
                    .collect(Collectors.toList());
                        return;
            exchange.close();
                blobs.put(exchange.getRequestURI().getPath(), new BytesArray(blob.toByteArray()));
import java.io.ByteArrayOutputStream;
                exchange.getResponseHeaders().add("x-ms-blob-type", "blockblob");
                if ("*".equals(ifNoneMatch)) {
                }
                    .map(line -> line.substring(0, line.indexOf("</Latest>")))
                    sendError(exchange, RestStatus.NOT_FOUND);
                // see Constants.HeaderConstants.STORAGE_RANGE_HEADER
            } else if (Regex.simpleMatch("HEAD /" + container + "/*", request)) {
                exchange.getResponseHeaders().add("x-ms-request-server-encrypted", "false");
                    block.writeTo(blob);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        sendError(exchange, RestStatus.CONFLICT);
 * The OpenSearch Contributors require contributions made to
/*
            exchange.sendResponseHeaders(status.getStatus(), response.length);
                    list.append("<Properties><Content-Length>").append(blob.getValue().length()).append("</Content-Length>");
                if (blobPrefixes.isEmpty() == false) {
            int read = exchange.getRequestBody().read();
import java.util.Set;
            default:
                // Delete Blob (https://docs.microsoft.com/en-us/rest/api/storageservices/delete-blob)
import java.util.HashMap;
import java.util.regex.Pattern;
import com.sun.net.httpserver.HttpHandler;
                exchange.sendResponseHeaders(RestStatus.CREATED.getStatus(), -1);
import java.nio.charset.StandardCharsets;
    public static void sendError(final HttpExchange exchange, final RestStatus status) throws IOException {
                final String blockId = params.get("blockid");
                final ByteArrayOutputStream blob = new ByteArrayOutputStream();
                return "InternalError";
 *
                }
import org.opensearch.rest.RestUtils;
                    list.append("<Name>").append(blobPath).append("</Name>");
package fixture.azure;
                list.append("</EnumerationResults>");
 *    http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
import org.opensearch.core.common.bytes.BytesArray;
 * Minimal HTTP handler that acts as an Azure compliant server
                if (blob == null) {
                exchange.getResponseBody().write(blob.toBytesRef().bytes, start, length);
                    list.append("<Delimiter>").append(delimiter).append("</Delimiter>");
        }
                // List Blobs (https://docs.microsoft.com/en-us/rest/api/storageservices/list-blobs)
                final int length = Math.min(end - start + 1, blob.length());
                        if (delimiterPosition > 0) {
                }
@SuppressForbidden(reason = "Uses a HttpServer to emulate an Azure endpoint")
                final int end = Integer.parseInt(matcher.group(2));
 * You may obtain a copy of the License at
                    sendError(exchange, RestStatus.NOT_FOUND);
    // See https://docs.microsoft.com/en-us/rest/api/storageservices/common-rest-api-error-codes
            } else {
                final Map<String, String> params = new HashMap<>();
        if (requestId != null) {
                final BytesReference blob = blobs.get(exchange.getRequestURI().getPath());
        }
 * license agreements. See the NOTICE file distributed with
        if (request.startsWith("GET") || request.startsWith("HEAD") || request.startsWith("DELETE")) {
                // Get Blob Properties (see https://docs.microsoft.com/en-us/rest/api/storageservices/get-blob-properties)
                blobs.entrySet().removeIf(blob -> blob.getKey().startsWith(exchange.getRequestURI().getPath()));
                    BytesReference block = blobs.remove(blockId);
 * compatible open source license.
                if (matcher.matches() == false) {
                list.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
                }
    private final Map<String, BytesReference> blobs;
 * under the License.
import org.opensearch.common.io.Streams;
import java.util.List;
                if (delimiter != null) {
                    list.append("</Blob>");
                list.append("<EnumerationResults>");
            // see Constants.HeaderConstants.STORAGE_RANGE_HEADER
                exchange.getResponseHeaders().add("Content-Length", String.valueOf(blob.length()));
            assert read == -1 : "Request body should have been empty but saw [" + read + "]";
 * Unless required by applicable law or agreed to in writing,
    }
            } else if (Regex.simpleMatch("GET /" + container + "/*", request)) {
                exchange.getResponseHeaders().add("x-ms-request-server-encrypted", "false");
import java.util.HashSet;
                exchange.getResponseHeaders().add("Content-Type", "application/xml");
        headers.add("x-ms-error-code", errorCode);
                for (String blockId : blockIds) {
                    }
                exchange.sendResponseHeaders(RestStatus.OK.getStatus(), response.length);
                exchange.sendResponseHeaders(RestStatus.ACCEPTED.getStatus(), -1);
                exchange.getResponseHeaders()
        final String requestId = exchange.getRequestHeaders().getFirst("x-ms-client-request-id");
        final Headers headers = exchange.getResponseHeaders();
            exchange.sendResponseHeaders(status.getStatus(), -1L);
 * ownership. Elasticsearch licenses this file to you under
        headers.add("Content-Type", "application/xml");
                            blobPrefixes.add(blobPath.substring(0, delimiterPosition) + delimiter);
                    String blobPath = blob.getKey().replace("/" + container + "/", "");
                final String range = exchange.getRequestHeaders().getFirst("x-ms-range");
                    if (prefix != null && blob.getKey().startsWith("/" + container + "/" + prefix) == false) {
        try {
                exchange.getResponseHeaders().add("x-ms-request-server-encrypted", "false");
                RestUtils.decodeQueryString(exchange.getRequestURI().getQuery(), 0, params);
                    list.append("<Blob>");
}
                final StringBuilder list = new StringBuilder();
                + status + "</Message></Error>").getBytes(StandardCharsets.UTF_8);
 *
                RestUtils.decodeQueryString(exchange.getRequestURI().getQuery(), 0, params);
                        continue;
        assert status.getStatus() >= 400;
                list.append("<NextMarker />");
                exchange.getResponseHeaders().add("x-ms-request-server-encrypted", "false");
                sendError(exchange, RestStatus.BAD_REQUEST);
                    }
            headers.add("x-ms-request-id", requestId);
                final int start = Integer.parseInt(matcher.group(1));
        // see Constants.HeaderConstants.ERROR_CODE
            } else if (Regex.simpleMatch("GET /container?restype=container&comp=list*", request)) {
                // PUT Blob (see https://docs.microsoft.com/en-us/rest/api/storageservices/put-blob)
import java.util.Objects;
                return "ServerBusy";
            } else if (Regex.simpleMatch("PUT /" + container + "/*comp=blocklist*", request)) {
                exchange.sendResponseHeaders(RestStatus.OK.getStatus(), length);
import java.util.regex.Matcher;
        this.container = Objects.requireNonNull(container);
                final String blockList = Streams.copyToString(new InputStreamReader(exchange.getRequestBody(), StandardCharsets.UTF_8));
import java.util.stream.Collectors;
                final Set<String> blobPrefixes = new HashSet<>();
    private static String toAzureErrorCode(final RestStatus status) {
                        list.append("<IsPrefix>").append(blobPath.endsWith(delimiter)).append("</IsPrefix>");
/**
                        int delimiterPosition = blobPath.indexOf(delimiter, fromIndex);
                }
import java.util.concurrent.ConcurrentHashMap;
                final List<String> blockIds = Arrays.stream(blockList.split("<Latest>"))
                exchange.getResponseBody().write(response);
                final String delimiter = params.get("delimiter");
                        }
 * this work for additional information regarding copyright
    public AzureHttpHandler(final String container) {
                final BytesReference blob = blobs.get(exchange.getRequestURI().getPath());
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Map;
                list.append("</Blobs>");
                exchange.getResponseHeaders().add("Content-Length", String.valueOf(length));
                }
import java.util.Arrays;
                    if (delimiter != null) {
        final String errorCode = toAzureErrorCode(status);
        } else {
    }
                        int fromIndex = (prefix != null ? prefix.length() : 0);
        switch (status) {
                    }
import com.sun.net.httpserver.Headers;
        }
                blobs.put(blockId, Streams.readFully(exchange.getRequestBody()));
                byte[] response = list.toString().getBytes(StandardCharsets.UTF_8);
public class AzureHttpHandler implements HttpHandler {
                exchange.getResponseHeaders().add("x-ms-request-server-encrypted", "false");
                list.append("<Blobs>");
                exchange.sendResponseHeaders(RestStatus.CREATED.getStatus(), -1);
                    list.append("<BlobType>BlockBlob</BlobType></Properties>");
    }
                    .filter(line -> line.contains("</Latest>"))
            } else if (Regex.simpleMatch("DELETE /" + container + "/*", request)) {
 */
 *
                // Put Block List (https://docs.microsoft.com/en-us/rest/api/storageservices/put-block-list)
                } else {
                    return;
                    blobPrefixes.forEach(p -> list.append("<BlobPrefix><Name>").append(p).append("</Name></BlobPrefix>"));
 * not use this file except in compliance with the License.
                throw new IllegalArgumentException("Error code [" + status.getStatus() + "] is not mapped to an existing Azure code");
                    throw new AssertionError("Range header does not match expected format: " + range);
                final String prefix = params.get("prefix");
                final String ifNoneMatch = exchange.getRequestHeaders().getFirst("If-None-Match");
 * SPDX-License-Identifier: Apache-2.0
        }
import com.sun.net.httpserver.HttpExchange;
                    }
                    if (blobs.putIfAbsent(exchange.getRequestURI().getPath(), Streams.readFully(exchange.getRequestBody())) != null) {
 * GitHub history for details.
        // see Constants.HeaderConstants.CLIENT_REQUEST_ID_HEADER
            }
 */
                    .add("Content-Range", "bytes " + start + "-" + Math.min(end, length) + "/" + blob.length());
                exchange.sendResponseHeaders(RestStatus.CREATED.getStatus(), -1);
 * KIND, either express or implied.  See the License for the
    private final String container;
            case INTERNAL_SERVER_ERROR:
                return "BlobAlreadyExists";
 */
                }
                    assert block != null;
import java.io.IOException;
        final String request = exchange.getRequestMethod() + " " + exchange.getRequestURI().toString();
            case SERVICE_UNAVAILABLE:
 * software distributed under the License is distributed on an
                final Matcher matcher = Pattern.compile("^bytes=([0-9]+)-([0-9]+)$").matcher(range);
                    if (delimiter != null) {
                    blobs.put(exchange.getRequestURI().getPath(), Streams.readFully(exchange.getRequestBody()));
                if (blob == null) {
/*
                return "BlobNotFound";
                // GET Object (https://docs.aws.amazon.com/AmazonS3/latest/API/RESTObjectGET.html)
        }
                exchange.getResponseHeaders().add("x-ms-request-server-encrypted", "false");
            case NOT_FOUND:
    public Map<String, BytesReference> blobs() {
                exchange.sendResponseHeaders(RestStatus.OK.getStatus(), -1);
    @Override
 * Modifications Copyright OpenSearch Contributors. See
                    return;
    }
        this.blobs = new ConcurrentHashMap<>();
                return "InvalidMetadata";
import org.opensearch.common.regex.Regex;
        if ("HEAD".equals(exchange.getRequestMethod())) {
        } finally {
                // Put Block (https://docs.microsoft.com/en-us/rest/api/storageservices/put-block)
import org.opensearch.core.rest.RestStatus;
                final Map<String, String> params = new HashMap<>();
                // Always use the delimiter (explicit or implicit), some APIs do not send it anymore
            case CONFLICT:
                            continue;
/*
            } else if (Regex.simpleMatch("PUT /" + container + "/*", request)) {
                }
import org.opensearch.common.SuppressForbidden;
                exchange.getResponseHeaders().add("x-ms-blob-type", "blockblob");
                for (Map.Entry<String, BytesReference> blob : blobs.entrySet()) {
import java.io.InputStreamReader;
            exchange.getResponseBody().write(response);
 */
