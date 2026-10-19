    @BeforeClass  
                .withOptions(RequestOptions.DEFAULT.toBuilder().addHeader("Accept-Encoding", "gzip"))
            Request request = Request.newRequest("POST", "/").withEntity(BodyPublishers.ofString("compressing client")).build();
        try (RestHttpClient restClient = createClient(false)) {
     */
import com.sun.net.httpserver.HttpExchange;
    public void testCompressingClientSync() throws Exception {
 * not use this file except in compliance with the License.
        }  
            String contentEncoding = exchange.getRequestHeaders().getFirst("Content-Encoding");
import java.util.concurrent.CompletableFuture;
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;  
 * KIND, either express or implied.  See the License for the
    public static class FutureResponse extends CompletableFuture<Response> implements ResponseListener {
 * this work for additional information regarding copyright
 * compatible open source license.
            // Server should report it had a compressed request and sent back a compressed response
import java.util.zip.GZIPOutputStream;  
            restClient.performRequestAsync(request, futureResponse);  
                .build()  
 * license agreements. See the NOTICE file distributed with
            .build();  
    }  
            Request request = Request.newRequest("POST", "/").withEntity(BodyPublishers.ofString("compressing client")).build();
            out.write('#');
            out.close();
import com.sun.net.httpserver.HttpServer;  
import java.nio.charset.StandardCharsets;  
        }  
package org.opensearch.internal.httpclient;
        public void onSuccess(Response response) {
                .withEntity(BodyPublishers.ofString("plain request, gzip response"))
            String content = BodyUtils.getBodyAsString(response.entity());  
     * A response handler that accepts gzip-encoded data and replies request and response encoding values
            if (compress) {
                out = new GZIPOutputStream(out);
        }
        InetSocketAddress address = httpServer.getAddress();  
            byte[] bytes = body.readAllBytes();  
import org.junit.AfterClass;
            if (compress) {
    }  
        InetSocketAddress address = httpServer.getAddress();
            Response response = futureResponse.get();
import java.net.InetAddress;  
    }  
    }  
            exchange.sendResponseHeaders(200, 0);  
public class RestHttpClientGzipCompressionTests extends RestHttpClientTestCase {
 * under the License.  
 *     http://www.apache.org/licenses/LICENSE-2.0
            Assert.assertEquals("gzip#gzip#compressing client", content);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
import java.net.http.HttpRequest.BodyPublishers;
            out.write('#');  
 *
/*  
    public static void startHttpServer() throws Exception {
            exchange.close();
            // Encode response if needed
import java.util.zip.GZIPInputStream;
            // Outputs <request-encoding|null>#<response-encoding|null>#<request-body>
        httpServer.createContext("/", new GzipResponseHandler());  
        httpServer = null;
                .build();  
import java.net.InetSocketAddress;
 * Modifications Copyright OpenSearch Contributors. See
            InputStream body = exchange.getRequestBody();
                .withEntity(BodyPublishers.ofString("plain request, gzip response"))
        @Override  
            FutureResponse futureResponse = new FutureResponse();
        try (RestHttpClient restClient = createClient(true)) {  
}
        try (  
            Assert.assertEquals("null#gzip#plain request, gzip response", content);
            restClient.performRequestAsync(request, futureResponse);
    /**
 * software distributed under the License is distributed on an
            this.completeExceptionally(exception);
    }
            String content = BodyUtils.getBodyAsString(response.entity());  
    private static class GzipResponseHandler implements HttpHandler {
import org.junit.BeforeClass;
        public void onFailure(Exception exception) {  
            Assert.assertEquals("null#gzip#plain request, gzip response", content);
    public void testGzipHeaderAsync() throws Exception {  
 */  
     * followed by the request body. The response is compressed if "Accept-Encoding" is "gzip".  
import com.sun.net.httpserver.HttpHandler;
            }  
            // Send non-compressed request, expect compressed response
            Request request = Request.newRequest("POST", "/")  
            out.write((compress ? "gzip" : "null").getBytes(StandardCharsets.UTF_8));
        @Override
/*
        httpServer = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);
            Response response = restClient.performRequest(request);
                .build();  
        ) {
import java.io.InputStream;
            String content = BodyUtils.getBodyAsString(response.entity());
 */  
            }
    public static void stopHttpServers() throws IOException {
        }
            // Send non-compressed request, expect compressed response
            Response response = restClient.performRequest(request);  
 *  
                .withOptions(RequestOptions.DEFAULT.toBuilder().addHeader("Accept-Encoding", "gzip"))
/*  
            RestHttpClient restClient = RestHttpClient.builder(new HttpHost("http", address.getHostString(), address.getPort()))
            String content = BodyUtils.getBodyAsString(response.entity());
 * Unless required by applicable law or agreed to in writing,
    public void testGzipHeaderSync() throws Exception {  
 * You may obtain a copy of the License at  
        try (RestHttpClient restClient = createClient(false)) {
            FutureResponse futureResponse = new FutureResponse();
 *
import java.io.OutputStream;
 * specific language governing permissions and limitations
                .setCompressionEnabled(true)
            Response response = futureResponse.get();  
            .setCompressionEnabled(enableCompression)
 * Licensed to Elasticsearch under one or more contributor  
        httpServer.start();
            // Decode body (if any)  
            Request request = Request.newRequest("POST", "/")  
        return RestHttpClient.builder(new HttpHost("http", address.getHostString(), address.getPort()))
        }
 * GitHub history for details.
import org.junit.Assert;  
    }
            OutputStream out = exchange.getResponseBody();  
        @Override  
                body = new GZIPInputStream(body);
    private RestHttpClient createClient(boolean enableCompression) {
            out.write(String.valueOf(contentEncoding).getBytes(StandardCharsets.UTF_8));  
    }
            }
            out.write(bytes);
            Assert.assertEquals("gzip#gzip#compressing client", content);  
            if ("gzip".equals(contentEncoding)) {  
            boolean compress = "gzip".equals(exchange.getRequestHeaders().getFirst("Accept-Encoding"));
                exchange.getResponseHeaders().add("Content-Encoding", "gzip");  
        public void handle(HttpExchange exchange) throws IOException {
        httpServer.stop(0);  
            this.complete(response);
 * ownership. Elasticsearch licenses this file to you under  
        }
 * the Apache License, Version 2.0 (the "License"); you may
 */
    }
        }
    public void testCompressingClientAsync() throws Exception {
    @AfterClass
    private static HttpServer httpServer;
 * SPDX-License-Identifier: Apache-2.0
