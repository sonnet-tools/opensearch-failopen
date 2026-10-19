        // Send non-compressed request, expect compressed response
        String content = new String(readAll(entity.getContent()), StandardCharsets.UTF_8);
        Assert.assertEquals("gzip#gzip#compressing client", content);  
 * compatible open source license.
    }  
        public void onSuccess(Response response) {
                exchange.getResponseHeaders().add("Content-Encoding", "gzip");
import java.nio.charset.StandardCharsets;
            if (compress) {  
        request.setEntity(new StringEntity("plain request, gzip response", ContentType.TEXT_PLAIN));
        Assert.assertEquals("null#gzip#plain request, gzip response", content);
    /**
            InputStream body = exchange.getRequestBody();  
 * SPDX-License-Identifier: Apache-2.0
     */
        Request request = new Request("POST", "/");
        // Send non-compressed request, expect compressed response
    @BeforeClass
        Response response = restClient.performRequest(request);
            out.write('#');  
 * GitHub history for details.
        Response response = restClient.performRequest(request);
     * followed by the request body. The response is compressed if "Accept-Encoding" is "gzip".
 * this work for additional information regarding copyright
     * A response handler that accepts gzip-encoded data and replies request and response encoding values  
 * this file be licensed under the Apache-2.0 license or a
import org.junit.Assert;
            // Encode response if needed
            if ("gzip".equals(contentEncoding)) {
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
    public void testCompressingClientSync() throws Exception {
        return bos.toByteArray();
        HttpEntity entity = response.getEntity();  
    /** Read all bytes of an input stream and close it. */
}
        HttpEntity entity = response.getEntity();
        RestClient restClient = createClient(true);  
    }  
    }
import java.util.zip.GZIPInputStream;  
import java.net.InetAddress;
                body = new GZIPInputStream(body);
        httpServer.createContext("/", new GzipResponseHandler());
            // Outputs <request-encoding|null>#<response-encoding|null>#<request-body>
import java.io.OutputStream;
    public static void stopHttpServers() throws IOException {  
        Request request = new Request("POST", "/");
        restClient.close();
        restClient.close();
        request.setOptions(RequestOptions.DEFAULT.toBuilder().addHeader("Accept-Encoding", "gzip").build());
            OutputStream out = exchange.getResponseBody();
 */  
        @Override  
    }  
            }
/*  
            .setCompressionEnabled(enableCompression)
import org.apache.hc.core5.http.HttpEntity;  
import com.sun.net.httpserver.HttpServer;  
        restClient.close();
    }
        Request request = new Request("POST", "/");
import java.io.ByteArrayOutputStream;
        RestClient restClient = createClient(false);  
        Response response = futureResponse.get();
            out.write('#');
    public void testGzipHeaderAsync() throws Exception {
 *  
/*  
        HttpEntity entity = response.getEntity();
 *     http://www.apache.org/licenses/LICENSE-2.0
            out.close();
public class RestClientGzipCompressionTests extends RestClientTestCase {  
 * license agreements. See the NOTICE file distributed with
            this.complete(response);
        public void onFailure(Exception exception) {  
        @Override
    private static HttpServer httpServer;
            exchange.sendResponseHeaders(200, 0);
import java.net.InetSocketAddress;  
        httpServer = null;
import org.apache.hc.core5.http.HttpHost;
            exchange.close();  
            boolean compress = "gzip".equals(exchange.getRequestHeaders().getFirst("Accept-Encoding"));  
import com.sun.net.httpserver.HttpHandler;
        }
 *
    @AfterClass
    private static byte[] readAll(InputStream in) throws IOException {
        }
import com.sun.net.httpserver.HttpExchange;
        restClient.performRequestAsync(request, futureResponse);  
        in.close();  
        Response response = futureResponse.get();
package org.opensearch.client;
        restClient.performRequestAsync(request, futureResponse);
        HttpEntity entity = response.getEntity();
            }  
            byte[] bytes = readAll(body);
            .build();
            bos.write(buffer, 0, len);
    public void testCompressingClientAsync() throws Exception {
        RestClient restClient = RestClient.builder(new HttpHost("http", address.getHostString(), address.getPort()))
    private RestClient createClient(boolean enableCompression) {
        Request request = new Request("POST", "/");  
 * under the License.  
import java.util.zip.GZIPOutputStream;
            // Decode body (if any)
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
        httpServer.start();
        restClient.close();
        String content = new String(readAll(entity.getContent()), StandardCharsets.UTF_8);
        request.setEntity(new StringEntity("compressing client", ContentType.TEXT_PLAIN));  
    private static class GzipResponseHandler implements HttpHandler {  
        byte[] buffer = new byte[1024];  
            }  
            out.write(String.valueOf(contentEncoding).getBytes(StandardCharsets.UTF_8));
        httpServer.stop(0);
 *
        request.setEntity(new StringEntity("compressing client", ContentType.TEXT_PLAIN));  
import java.io.IOException;
        request.setOptions(RequestOptions.DEFAULT.toBuilder().addHeader("Accept-Encoding", "gzip").build());
 * not use this file except in compliance with the License.
            .setCompressionEnabled(true)
 */
import java.io.InputStream;  
    public static void startHttpServer() throws Exception {
import org.junit.AfterClass;  
 * ownership. Elasticsearch licenses this file to you under  
        request.setEntity(new StringEntity("plain request, gzip response", ContentType.TEXT_PLAIN));  
/*
        FutureResponse futureResponse = new FutureResponse();
    public void testGzipHeaderSync() throws Exception {
import java.util.concurrent.CompletableFuture;
        InetSocketAddress address = httpServer.getAddress();  
        int len = 0;
 * Licensed to Elasticsearch under one or more contributor  
            .build();  
    }  
 */  
        return RestClient.builder(new HttpHost("http", address.getHostString(), address.getPort()))  
 * The OpenSearch Contributors require contributions made to  
import org.apache.hc.core5.http.io.entity.StringEntity;
        Assert.assertEquals("gzip#gzip#compressing client", content);  
        // Server should report it had a compressed request and sent back a compressed response  
        RestClient restClient = createClient(false);
            if (compress) {
    }
 * the Apache License, Version 2.0 (the "License"); you may
        while ((len = in.read(buffer)) > 0) {  
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
 * specific language governing permissions and limitations
        String content = new String(readAll(entity.getContent()), StandardCharsets.UTF_8);
import org.apache.hc.core5.http.ContentType;
import org.junit.BeforeClass;
        public void handle(HttpExchange exchange) throws IOException {
        }  
            String contentEncoding = exchange.getRequestHeaders().getFirst("Content-Encoding");
        FutureResponse futureResponse = new FutureResponse();  
        @Override
                out = new GZIPOutputStream(out);
    }  
    public static class FutureResponse extends CompletableFuture<Response> implements ResponseListener {
    }  
        }
        InetSocketAddress address = httpServer.getAddress();
        httpServer = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);  
        Assert.assertEquals("null#gzip#plain request, gzip response", content);  
            out.write((compress ? "gzip" : "null").getBytes(StandardCharsets.UTF_8));
            out.write(bytes);  
 * Unless required by applicable law or agreed to in writing,
    }  
        String content = new String(readAll(entity.getContent()), StandardCharsets.UTF_8);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            this.completeExceptionally(exception);
