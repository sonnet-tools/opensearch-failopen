        request.setEntity(new StringEntity("plain request, gzip response", ContentType.TEXT_PLAIN));
public class RestClientGzipCompressionTests extends RestClientTestCase {
        Request request = new Request("POST", "/");
            .setCompressionEnabled(enableCompression)
        RestClient restClient = createClient(true);
 * license agreements. See the NOTICE file distributed with
        Assert.assertEquals("gzip#gzip#compressing client", content);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        @Override
        HttpEntity entity = response.getEntity();
        Request request = new Request("POST", "/");
        String content = new String(readAll(entity.getContent()), StandardCharsets.UTF_8);
import java.net.InetAddress;
        httpServer.stop(0);
     * followed by the request body. The response is compressed if "Accept-Encoding" is "gzip".
        @Override
        InetSocketAddress address = httpServer.getAddress();
 */
        RestClient restClient = createClient(false);
 * this file be licensed under the Apache-2.0 license or a
        }
    }
        request.setOptions(RequestOptions.DEFAULT.toBuilder().addHeader("Accept-Encoding", "gzip").build());
import org.junit.BeforeClass;
        RestClient restClient = createClient(false);
        public void onFailure(Exception exception) {
        in.close();
import org.apache.hc.core5.http.HttpHost;
        FutureResponse futureResponse = new FutureResponse();
        request.setEntity(new StringEntity("plain request, gzip response", ContentType.TEXT_PLAIN));
    @BeforeClass
        restClient.performRequestAsync(request, futureResponse);
import org.junit.Assert;
        }
    }
import java.net.InetSocketAddress;
 * ownership. Elasticsearch licenses this file to you under
 * this work for additional information regarding copyright
            bos.write(buffer, 0, len);
        }
 * compatible open source license.
    private static class GzipResponseHandler implements HttpHandler {
import com.sun.net.httpserver.HttpHandler;
 * The OpenSearch Contributors require contributions made to
 *
            exchange.sendResponseHeaders(200, 0);
        RestClient restClient = RestClient.builder(new HttpHost("http", address.getHostString(), address.getPort()))
                out = new GZIPOutputStream(out);
            .build();
    /**
 * Licensed to Elasticsearch under one or more contributor
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            }
            boolean compress = "gzip".equals(exchange.getRequestHeaders().getFirst("Accept-Encoding"));
        httpServer = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);
        String content = new String(readAll(entity.getContent()), StandardCharsets.UTF_8);
                body = new GZIPInputStream(body);
     * A response handler that accepts gzip-encoded data and replies request and response encoding values
        public void onSuccess(Response response) {
        @Override
/*
            this.completeExceptionally(exception);
        int len = 0;
import org.apache.hc.core5.http.HttpEntity;
     */
        Response response = futureResponse.get();
    private static byte[] readAll(InputStream in) throws IOException {
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
        return RestClient.builder(new HttpHost("http", address.getHostString(), address.getPort()))
            this.complete(response);
    private static HttpServer httpServer;
            out.write('#');
import java.util.concurrent.CompletableFuture;
        request.setEntity(new StringEntity("compressing client", ContentType.TEXT_PLAIN));
    }
        // Send non-compressed request, expect compressed response
        HttpEntity entity = response.getEntity();
    }
    }
import java.io.InputStream;
import java.io.IOException;
        Assert.assertEquals("gzip#gzip#compressing client", content);
    private RestClient createClient(boolean enableCompression) {
        Assert.assertEquals("null#gzip#plain request, gzip response", content);
            }
            if ("gzip".equals(contentEncoding)) {
            // Outputs <request-encoding|null>#<response-encoding|null>#<request-body>
    /** Read all bytes of an input stream and close it. */
package org.opensearch.client;
import org.apache.hc.core5.http.io.entity.StringEntity;
 * the Apache License, Version 2.0 (the "License"); you may
        request.setEntity(new StringEntity("compressing client", ContentType.TEXT_PLAIN));
    }
            // Decode body (if any)
        restClient.close();
import org.junit.AfterClass;
            exchange.close();
        return bos.toByteArray();
import org.apache.hc.core5.http.ContentType;
            .setCompressionEnabled(true)
        String content = new String(readAll(entity.getContent()), StandardCharsets.UTF_8);
    }
        Request request = new Request("POST", "/");
        while ((len = in.read(buffer)) > 0) {
        Response response = restClient.performRequest(request);
 * You may obtain a copy of the License at
        Request request = new Request("POST", "/");
 */
import java.io.OutputStream;
    public static void stopHttpServers() throws IOException {
import java.io.ByteArrayOutputStream;
            byte[] bytes = readAll(body);
 * specific language governing permissions and limitations
import java.util.zip.GZIPOutputStream;
            InputStream body = exchange.getRequestBody();
        FutureResponse futureResponse = new FutureResponse();
            String contentEncoding = exchange.getRequestHeaders().getFirst("Content-Encoding");
 * SPDX-License-Identifier: Apache-2.0
 *
        Response response = futureResponse.get();
            }
    @AfterClass
        restClient.performRequestAsync(request, futureResponse);
            out.write((compress ? "gzip" : "null").getBytes(StandardCharsets.UTF_8));
    public void testGzipHeaderSync() throws Exception {
        byte[] buffer = new byte[1024];
import java.util.zip.GZIPInputStream;
        // Server should report it had a compressed request and sent back a compressed response
                exchange.getResponseHeaders().add("Content-Encoding", "gzip");
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
        httpServer = null;
            .build();
            out.close();
    public void testCompressingClientSync() throws Exception {
        Assert.assertEquals("null#gzip#plain request, gzip response", content);
            OutputStream out = exchange.getResponseBody();
 * under the License.
        InetSocketAddress address = httpServer.getAddress();
    }
    public static class FutureResponse extends CompletableFuture<Response> implements ResponseListener {
        public void handle(HttpExchange exchange) throws IOException {
        HttpEntity entity = response.getEntity();
import java.nio.charset.StandardCharsets;
            // Encode response if needed
        httpServer.createContext("/", new GzipResponseHandler());
    }
    }
        httpServer.start();
            if (compress) {
    public void testCompressingClientAsync() throws Exception {
            out.write(bytes);
 * not use this file except in compliance with the License.
        Response response = restClient.performRequest(request);
        request.setOptions(RequestOptions.DEFAULT.toBuilder().addHeader("Accept-Encoding", "gzip").build());
 */
        }
        restClient.close();
import com.sun.net.httpserver.HttpExchange;
/*
        String content = new String(readAll(entity.getContent()), StandardCharsets.UTF_8);
        restClient.close();
        restClient.close();
 * software distributed under the License is distributed on an
        HttpEntity entity = response.getEntity();
            out.write('#');
 * KIND, either express or implied.  See the License for the
    public static void startHttpServer() throws Exception {
    public void testGzipHeaderAsync() throws Exception {
import com.sun.net.httpserver.HttpServer;
            if (compress) {
        // Send non-compressed request, expect compressed response
            out.write(String.valueOf(contentEncoding).getBytes(StandardCharsets.UTF_8));
 * Unless required by applicable law or agreed to in writing,
}
/*
