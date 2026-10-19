        }
import java.util.concurrent.CompletableFuture;
        public void onFailure(Exception exception) {
            // Server should report it had a compressed request and sent back a compressed response
        @Override
    }
            boolean compressedRequest = false;
        }
                compressedRequest = true;
            byte[] bytes = body.readAllBytes();
    public static void stopHttpServers() throws IOException {  
import java.net.http.HttpRequest.BodyPublishers;  
            .setHttpClientConfigCallback(builder -> builder.version(Version.HTTP_1_1))  
                exchange.getResponseHeaders().add("Content-Encoding", "gzip");
            out.write('#');
        try (RestHttpClient restClient = createClient(true)) {  
            String contentEncoding = exchange.getRequestHeaders().getFirst("Content-Encoding");
        httpServer = null;
            // Decode body (if any)
    /**
import java.io.IOException;  
            }
                body = new GZIPInputStream(body);
import java.util.zip.GZIPInputStream;  
            // With HttpClient, we don't sent Content-Length so it is always null
    }
import java.nio.charset.StandardCharsets;
            out.write('#');  
            OutputStream out = exchange.getResponseBody();
 *
            }  
            out.write(bytes);
            Assert.assertEquals("gzip#gzip#null#compressing client", content);
        @Override
import java.net.InetAddress;  
            Request request = Request.newRequest("POST", "/").withEntity(BodyPublishers.ofString("compressing client")).build();  
            restClient.performRequestAsync(request, futureResponse);
     * followed by the request body. The response is compressed if "Accept-Encoding" is "gzip".
public class RestHttpClientCompressionTests extends RestHttpClientTestCase {  
    }  
            // Outputs <request-encoding|null>#<response-encoding|null>#<request-body>  
}  
import org.junit.BeforeClass;
        try (RestHttpClient restClient = createClient(true)) {
            exchange.close();
            out.write(((compressedRequest == true && contentLength != null) ? contentLength : "null").getBytes(StandardCharsets.UTF_8));
    @AfterClass
            }
 * The OpenSearch Contributors require contributions made to  
    }  
        }
            // Content-Encoding#Accept-Encoding#Content-Length#Content
            out.write(String.valueOf(contentEncoding).getBytes(StandardCharsets.UTF_8));
            Response response = restClient.performRequest(request);
            // Content-Encoding#Accept-Encoding#Content-Length#Content
            // With HttpClient, we don't sent Content-Length so it is always null  
            this.complete(response);
            out.close();
            String content = BodyUtils.getBodyAsString(response.entity());
            FutureResponse futureResponse = new FutureResponse();  
            Response response = futureResponse.get();
            if ("gzip".equals(contentEncoding)) {  
        @Override
/*  
    public static class FutureResponse extends CompletableFuture<Response> implements ResponseListener {
            if (compress) {
        public void onSuccess(Response response) {  
        httpServer = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);  
        return RestHttpClient.builder(new HttpHost("http", address.getHostString(), address.getPort()))
    }  
import java.io.OutputStream;
    }
 * this file be licensed under the Apache-2.0 license or a
 */  
            .setCompressionEnabled(enableCompression)
import java.net.http.HttpClient.Version;
import org.junit.AfterClass;
                out = new GZIPOutputStream(out);  
    @BeforeClass
    public void testCompressingClientWithContentLengthSync() throws Exception {
import java.net.InetSocketAddress;
import java.util.zip.GZIPOutputStream;
            exchange.sendResponseHeaders(200, 0);
        public void handle(HttpExchange exchange) throws IOException {
import com.sun.net.httpserver.HttpHandler;
            .build();
            String contentLength = exchange.getRequestHeaders().getFirst("Content-Length");  
            if (compress) {  
    public static void startHttpServer() throws Exception {
        httpServer.start();
            out.write('#');
package org.opensearch.internal.httpclient;
    private static class GzipResponseHandler implements HttpHandler {  
import com.sun.net.httpserver.HttpExchange;
    public void testCompressingClientContentLengthAsync() throws Exception {
     */
        }
    }  
            boolean compress = "gzip".equals(exchange.getRequestHeaders().getFirst("Accept-Encoding"));
     * A response handler that accepts gzip-encoded data and replies request and response encoding values  
import org.junit.Assert;  
        InetSocketAddress address = httpServer.getAddress();  
 * compatible open source license.
            Request request = Request.newRequest("POST", "/").withEntity(BodyPublishers.ofString("compressing client")).build();
 * SPDX-License-Identifier: Apache-2.0
            out.write((compress ? "gzip" : "null").getBytes(StandardCharsets.UTF_8));  
    private static HttpServer httpServer;
            InputStream body = exchange.getRequestBody();
        }
            this.completeExceptionally(exception);  
            String content = BodyUtils.getBodyAsString(response.entity());
        httpServer.stop(0);
        httpServer.createContext("/", new GzipResponseHandler());
            // Encode response if needed  
            Assert.assertEquals("gzip#gzip#null#compressing client", content);  
import com.sun.net.httpserver.HttpServer;  
    private RestHttpClient createClient(boolean enableCompression) {
import java.io.InputStream;
