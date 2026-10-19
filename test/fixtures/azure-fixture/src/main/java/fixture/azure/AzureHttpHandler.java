                    list.append("<Blob>");
                        list.append("<IsPrefix>").append(blobPath.endsWith(delimiter)).append("</IsPrefix>");
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
                exchange.getResponseHeaders().add("Content-Type", "application/octet-stream");
                    list.append("<Name>").append(blobPath).append("</Name>");  
                exchange.getResponseHeaders().add("x-ms-request-server-encrypted", "false");
                }
                final int length = Math.min(end - start + 1, blob.length());  
import java.util.Objects;
        final String request = exchange.getRequestMethod() + " " + exchange.getRequestURI().toString();
 * license agreements. See the NOTICE file distributed with
            case NOT_FOUND:
                exchange.getResponseBody().write(response);
                blobs.entrySet().removeIf(blob -> blob.getKey().startsWith(exchange.getRequestURI().getPath()));
                    blobPrefixes.forEach(p -> list.append("<BlobPrefix><Name>").append(p).append("</Name></BlobPrefix>"));  
                // PUT Blob (see https://docs.microsoft.com/en-us/rest/api/storageservices/put-blob)  
                    }  
                exchange.getResponseHeaders().add("x-ms-request-server-encrypted", "false");
 * compatible open source license.
                final Set<String> blobPrefixes = new HashSet<>();
            final byte[] response = ("<?xml version=\"1.0\" encoding=\"UTF-8\"?><Error><Code>" + errorCode + "</Code><Message>"
                final String prefix = params.get("prefix");
        } finally {
                exchange.getResponseBody().write(blob.toBytesRef().bytes, start, length);
            headers.add("x-ms-request-id", requestId);  
                final BytesReference blob = blobs.get(exchange.getRequestURI().getPath());  
                exchange.getResponseHeaders().add("x-ms-request-server-encrypted", "false");
                sendError(exchange, RestStatus.BAD_REQUEST);
                exchange.sendResponseHeaders(RestStatus.ACCEPTED.getStatus(), -1);  
import org.opensearch.core.common.bytes.BytesReference;
                    return;  
                exchange.sendResponseHeaders(RestStatus.OK.getStatus(), length);  
                    .collect(Collectors.toList());
            default:
                    if (blobs.putIfAbsent(exchange.getRequestURI().getPath(), Streams.readFully(exchange.getRequestBody())) != null) {  
            } else if (Regex.simpleMatch("HEAD /" + container + "/*", request)) {
    }
        headers.add("Content-Type", "application/xml");  
import java.util.Set;  
import java.util.regex.Pattern;  
 * SPDX-License-Identifier: Apache-2.0
 */
import java.util.HashMap;
                exchange.getResponseHeaders().add("x-ms-request-server-encrypted", "false");  
            }  
                + status + "</Message></Error>").getBytes(StandardCharsets.UTF_8);
                return "BlobAlreadyExists";  
                final ByteArrayOutputStream blob = new ByteArrayOutputStream();
                final String blockId = params.get("blockid");  
        }
                    if (prefix != null && blob.getKey().startsWith("/" + container + "/" + prefix) == false) {
 *
                exchange.getResponseHeaders()  
                // Get Blob Properties (see https://docs.microsoft.com/en-us/rest/api/storageservices/get-blob-properties)
        }  
                if (delimiter != null) {
                // List Blobs (https://docs.microsoft.com/en-us/rest/api/storageservices/list-blobs)  
 */
                if (matcher.matches() == false) {  
import java.util.concurrent.ConcurrentHashMap;
        final String requestId = exchange.getRequestHeaders().getFirst("x-ms-client-request-id");  
                exchange.sendResponseHeaders(RestStatus.CREATED.getStatus(), -1);  
import java.io.IOException;  
                    throw new AssertionError("Range header does not match expected format: " + range);
                        int delimiterPosition = blobPath.indexOf(delimiter, fromIndex);
import com.sun.net.httpserver.Headers;  
import java.util.stream.Collectors;
                    }
                    block.writeTo(blob);
                return "BlobNotFound";  
        if (requestId != null) {
import org.opensearch.core.rest.RestStatus;
        } else {  
import java.util.Arrays;  
                final String ifNoneMatch = exchange.getRequestHeaders().getFirst("If-None-Match");
                blobs.put(exchange.getRequestURI().getPath(), new BytesArray(blob.toByteArray()));
                        if (delimiterPosition > 0) {
                list.append("<NextMarker />");
/*
                // GET Object (https://docs.aws.amazon.com/AmazonS3/latest/API/RESTObjectGET.html)
                    }  
        if ("HEAD".equals(exchange.getRequestMethod())) {
                    .filter(line -> line.contains("</Latest>"))  
            case BAD_REQUEST:  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private static String toAzureErrorCode(final RestStatus status) {  
 *  
    }  
                throw new IllegalArgumentException("Error code [" + status.getStatus() + "] is not mapped to an existing Azure code");
            } else if (Regex.simpleMatch("GET /" + container + "/*", request)) {
        switch (status) {
                list.append("</Blobs>");  
                exchange.sendResponseHeaders(RestStatus.CREATED.getStatus(), -1);
                    .add("Content-Range", "bytes " + start + "-" + Math.min(end, length) + "/" + blob.length());
                list.append("<Blobs>");
/*  
 * this work for additional information regarding copyright
    private final String container;
                final Map<String, String> params = new HashMap<>();
                if (blob == null) {
                return "InternalError";
            } else if (Regex.simpleMatch("PUT /" + container + "/*comp=blocklist*", request)) {
            } else if (Regex.simpleMatch("PUT /" + container + "/*", request)) {
@SuppressForbidden(reason = "Uses a HttpServer to emulate an Azure endpoint")  
package fixture.azure;
        }  
    private final Map<String, BytesReference> blobs;  
                byte[] response = list.toString().getBytes(StandardCharsets.UTF_8);
import java.util.Map;
                exchange.getResponseHeaders().add("x-ms-request-server-encrypted", "false");
        if (request.startsWith("GET") || request.startsWith("HEAD") || request.startsWith("DELETE")) {
import com.sun.net.httpserver.HttpExchange;
                        sendError(exchange, RestStatus.CONFLICT);
                RestUtils.decodeQueryString(exchange.getRequestURI().getQuery(), 0, params);
            case SERVICE_UNAVAILABLE:  
                    BytesReference block = blobs.remove(blockId);  
                list.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
                    .map(line -> line.substring(0, line.indexOf("</Latest>")))
                }
                exchange.getResponseHeaders().add("Content-Length", String.valueOf(blob.length()));
                final Map<String, String> params = new HashMap<>();  
                    if (delimiter != null) {  
            if (Regex.simpleMatch("PUT /" + container + "/*blockid=*", request)) {
import java.io.ByteArrayOutputStream;
import org.opensearch.common.regex.Regex;
            } else {
import org.opensearch.common.io.Streams;  
                // Always use the delimiter (explicit or implicit), some APIs do not send it anymore  
            // see Constants.HeaderConstants.STORAGE_RANGE_HEADER
                if (blobPrefixes.isEmpty() == false) {
/*
        final String errorCode = toAzureErrorCode(status);  
                final String delimiter = params.get("delimiter");
                    String blobPath = blob.getKey().replace("/" + container + "/", "");
    public AzureHttpHandler(final String container) {  
import com.sun.net.httpserver.HttpHandler;
                }
                final int end = Integer.parseInt(matcher.group(2));
                exchange.sendResponseHeaders(RestStatus.OK.getStatus(), -1);
 * You may obtain a copy of the License at  
            } else if (Regex.simpleMatch("DELETE /" + container + "/*", request)) {  
                exchange.getResponseHeaders().add("x-ms-request-server-encrypted", "false");
                final String blockList = Streams.copyToString(new InputStreamReader(exchange.getRequestBody(), StandardCharsets.UTF_8));
public class AzureHttpHandler implements HttpHandler {
            case INTERNAL_SERVER_ERROR:
 * software distributed under the License is distributed on an
        // see Constants.HeaderConstants.ERROR_CODE
                final Matcher matcher = Pattern.compile("^bytes=([0-9]+)-([0-9]+)$").matcher(range);
                exchange.sendResponseHeaders(RestStatus.OK.getStatus(), response.length);
 */
                list.append("</EnumerationResults>");
            exchange.sendResponseHeaders(status.getStatus(), response.length);  
                        continue;
                for (String blockId : blockIds) {
                // Put Block List (https://docs.microsoft.com/en-us/rest/api/storageservices/put-block-list)  
                    }  
                            blobPrefixes.add(blobPath.substring(0, delimiterPosition) + delimiter);  
 * specific language governing permissions and limitations
                }
import java.util.HashSet;
                    return;  
                // Put Block (https://docs.microsoft.com/en-us/rest/api/storageservices/put-block)
                final BytesReference blob = blobs.get(exchange.getRequestURI().getPath());  
                    list.append("<Delimiter>").append(delimiter).append("</Delimiter>");  
                return "InvalidMetadata";
 * GitHub history for details.
        this.container = Objects.requireNonNull(container);
/**  
                final List<String> blockIds = Arrays.stream(blockList.split("<Latest>"))
                if (blob == null) {
                final StringBuilder list = new StringBuilder();
    public static void sendError(final HttpExchange exchange, final RestStatus status) throws IOException {
                for (Map.Entry<String, BytesReference> blob : blobs.entrySet()) {  
 * under the License.  
        try {  
import org.opensearch.core.common.bytes.BytesArray;
    }
import java.io.InputStreamReader;
 *    http://www.apache.org/licenses/LICENSE-2.0
                        }
                // Delete Blob (https://docs.microsoft.com/en-us/rest/api/storageservices/delete-blob)
                exchange.getResponseHeaders().add("Content-Length", String.valueOf(length));  
        headers.add("x-ms-error-code", errorCode);
                }  
        // see Constants.HeaderConstants.CLIENT_REQUEST_ID_HEADER
import java.nio.charset.StandardCharsets;
 * The OpenSearch Contributors require contributions made to  
    }
            exchange.sendResponseHeaders(status.getStatus(), -1L);
            case CONFLICT:
 * Modifications Copyright OpenSearch Contributors. See  
                exchange.sendResponseHeaders(RestStatus.CREATED.getStatus(), -1);  
    public void handle(final HttpExchange exchange) throws IOException {  
import org.opensearch.rest.RestUtils;  
                return "ServerBusy";
 * Minimal HTTP handler that acts as an Azure compliant server
                }  
                if ("*".equals(ifNoneMatch)) {
 *
import java.util.List;  
                list.append("<EnumerationResults>");  
        assert status.getStatus() >= 400;
                        return;
        final Headers headers = exchange.getResponseHeaders();
                    sendError(exchange, RestStatus.NOT_FOUND);
 * the Apache License, Version 2.0 (the "License"); you may
                    list.append("<BlobType>BlockBlob</BlobType></Properties>");
        }
                exchange.getResponseHeaders().add("x-ms-blob-type", "blockblob");  
                // see Constants.HeaderConstants.STORAGE_RANGE_HEADER  
            assert read == -1 : "Request body should have been empty but saw [" + read + "]";
    // See https://docs.microsoft.com/en-us/rest/api/storageservices/common-rest-api-error-codes
        this.blobs = new ConcurrentHashMap<>();
                    sendError(exchange, RestStatus.NOT_FOUND);
            exchange.close();
            exchange.getResponseBody().write(response);
    @Override
 * ownership. Elasticsearch licenses this file to you under  
                } else {
 * Unless required by applicable law or agreed to in writing,
            int read = exchange.getRequestBody().read();  
                }
    }  
import org.opensearch.common.SuppressForbidden;  
                    assert block != null;
                final String range = exchange.getRequestHeaders().getFirst("x-ms-range");
                exchange.getResponseHeaders().add("Content-Type", "application/xml");
    public Map<String, BytesReference> blobs() {  
                    list.append("<Properties><Content-Length>").append(blob.getValue().length()).append("</Content-Length>");
                            continue;
}
                final int start = Integer.parseInt(matcher.group(1));
                }
            } else if (Regex.simpleMatch("GET /container?restype=container&comp=list*", request)) {
 * KIND, either express or implied.  See the License for the
                    blobs.put(exchange.getRequestURI().getPath(), Streams.readFully(exchange.getRequestBody()));
        }
                blobs.put(blockId, Streams.readFully(exchange.getRequestBody()));
 */  
        return blobs;
                exchange.getResponseHeaders().add("x-ms-blob-type", "blockblob");
                    list.append("</Blob>");  
                RestUtils.decodeQueryString(exchange.getRequestURI().getQuery(), 0, params);
                    if (delimiter != null) {
import java.util.regex.Matcher;
                        int fromIndex = (prefix != null ? prefix.length() : 0);  
