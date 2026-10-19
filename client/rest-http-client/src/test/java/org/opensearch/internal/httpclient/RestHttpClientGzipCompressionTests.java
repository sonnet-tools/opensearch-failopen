    public static void stopHttpServers() throws IOException {
            // Send non-compressed request, expect compressed response
            // Decode body (if any)
    }
 * Modifications Copyright OpenSearch Contributors. See
    }
            restClient.performRequestAsync(request, futureResponse);
            }
        }
        }
 * under the License.
        try (RestHttpClient restClient = createClient(false)) {
            out.write(bytes);
package org.opensearch.internal.httpclient;
            Assert.assertEquals("null#gzip#plain request, gzip response", content);
import org.junit.Assert;
                .withEntity(BodyPublishers.ofString("plain request, gzip response"))
                .withOptions(RequestOptions.DEFAULT.toBuilder().addHeader("Accept-Encoding", "gzip"))
            Response response = futureResponse.get();
 * You may obtain a copy of the License at
        ) {
    public void testCompressingClientSync() throws Exception {
            out.write('#');
 * ownership. Elasticsearch licenses this file to you under
        httpServer.start();
 */
            Assert.assertEquals("null#gzip#plain request, gzip response", content);
    private RestHttpClient createClient(boolean enableCompression) {
            Response response = restClient.performRequest(request);
    }
import java.io.InputStream;
            out.write((compress ? "gzip" : "null").getBytes(StandardCharsets.UTF_8));
/*
            if (compress) {
        InetSocketAddress address = httpServer.getAddress();
            this.complete(response);
                body = new GZIPInputStream(body);
import java.util.zip.GZIPOutputStream;
            // Server should report it had a compressed request and sent back a compressed response
 */
            Response response = futureResponse.get();
 * specific language governing permissions and limitations
public class RestHttpClientGzipCompressionTests extends RestHttpClientTestCase {
    public static class FutureResponse extends CompletableFuture<Response> implements ResponseListener {
        httpServer.createContext("/", new GzipResponseHandler());
    }
            FutureResponse futureResponse = new FutureResponse();
import java.util.zip.GZIPInputStream;
import com.sun.net.httpserver.HttpServer;
import java.net.InetAddress;
        @Override
    @AfterClass
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpExchange;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            if (compress) {
 */
 * GitHub history for details.
            out.close();
import java.nio.charset.StandardCharsets;
        httpServer = null;
            .setCompressionEnabled(enableCompression)
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
            String contentEncoding = exchange.getRequestHeaders().getFirst("Content-Encoding");
    }
        }
    public void testGzipHeaderAsync() throws Exception {
    private static HttpServer httpServer;
            Response response = restClient.performRequest(request);
            out.write('#');
            }
            restClient.performRequestAsync(request, futureResponse);
        try (RestHttpClient restClient = createClient(false)) {
    }
            Request request = Request.newRequest("POST", "/")
    }
    public void testCompressingClientAsync() throws Exception {
 * software distributed under the License is distributed on an
                exchange.getResponseHeaders().add("Content-Encoding", "gzip");
 * The OpenSearch Contributors require contributions made to
            String content = BodyUtils.getBodyAsString(response.entity());
                .build()
                .setCompressionEnabled(true)
            Request request = Request.newRequest("POST", "/").withEntity(BodyPublishers.ofString("compressing client")).build();
        public void handle(HttpExchange exchange) throws IOException {
            String content = BodyUtils.getBodyAsString(response.entity());
            Assert.assertEquals("gzip#gzip#compressing client", content);
        public void onFailure(Exception exception) {
            exchange.close();
}
import org.junit.AfterClass;
import java.io.IOException;
        httpServer = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);
    }
/*
 *
import java.io.OutputStream;
import java.util.concurrent.CompletableFuture;
            RestHttpClient restClient = RestHttpClient.builder(new HttpHost("http", address.getHostString(), address.getPort()))
            this.completeExceptionally(exception);
        }
            boolean compress = "gzip".equals(exchange.getRequestHeaders().getFirst("Accept-Encoding"));
            // Encode response if needed
        }
            }
        try (
                out = new GZIPOutputStream(out);
        @Override
            byte[] bytes = body.readAllBytes();
 *
            .build();
            String content = BodyUtils.getBodyAsString(response.entity());
 * not use this file except in compliance with the License.
                .build();
        InetSocketAddress address = httpServer.getAddress();
     */
/*
        try (RestHttpClient restClient = createClient(true)) {
        return RestHttpClient.builder(new HttpHost("http", address.getHostString(), address.getPort()))
    @BeforeClass
 * this work for additional information regarding copyright
                .withEntity(BodyPublishers.ofString("plain request, gzip response"))
 * SPDX-License-Identifier: Apache-2.0
            // Send non-compressed request, expect compressed response
            exchange.sendResponseHeaders(200, 0);
    public void testGzipHeaderSync() throws Exception {
     * A response handler that accepts gzip-encoded data and replies request and response encoding values
            Request request = Request.newRequest("POST", "/").withEntity(BodyPublishers.ofString("compressing client")).build();
 *     http://www.apache.org/licenses/LICENSE-2.0
    private static class GzipResponseHandler implements HttpHandler {
 * the Apache License, Version 2.0 (the "License"); you may
            Assert.assertEquals("gzip#gzip#compressing client", content);
    }
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
import org.junit.BeforeClass;
    public static void startHttpServer() throws Exception {
 * Licensed to Elasticsearch under one or more contributor
            Request request = Request.newRequest("POST", "/")
            InputStream body = exchange.getRequestBody();
                .build();
            String content = BodyUtils.getBodyAsString(response.entity());
            out.write(String.valueOf(contentEncoding).getBytes(StandardCharsets.UTF_8));
            FutureResponse futureResponse = new FutureResponse();
        }
        @Override
                .withOptions(RequestOptions.DEFAULT.toBuilder().addHeader("Accept-Encoding", "gzip"))
        }
     * followed by the request body. The response is compressed if "Accept-Encoding" is "gzip".
        public void onSuccess(Response response) {
            OutputStream out = exchange.getResponseBody();
            // Outputs <request-encoding|null>#<response-encoding|null>#<request-body>
 *
 * compatible open source license.
        httpServer.stop(0);
import com.sun.net.httpserver.HttpHandler;
import java.net.http.HttpRequest.BodyPublishers;
            if ("gzip".equals(contentEncoding)) {
    /**
