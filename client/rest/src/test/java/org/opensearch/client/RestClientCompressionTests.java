            InputStream body = exchange.getRequestBody();
            out.write((compress ? "gzip" : "null").getBytes(StandardCharsets.UTF_8));  
 * SPDX-License-Identifier: Apache-2.0
        HttpEntity entity = response.getEntity();
            out.write(bytes);
        Request request = new Request("POST", "/");
 * The OpenSearch Contributors require contributions made to  
            .setCompressionEnabled(enableCompression)
            .build();  
    }  
 *
        public void handle(HttpExchange exchange) throws IOException {
import org.apache.hc.core5.http.HttpEntity;  
import java.net.InetSocketAddress;  
            }
import org.junit.Assert;
    private RestClient createClient(boolean enableCompression, boolean chunkedEnabled) {
        Request request = new Request("POST", "/");  
    public static void startHttpServer() throws Exception {
            byte[] bytes = readAll(body);
        httpServer = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);  
        httpServer = null;
        httpServer.start();
        }
     */
        Assert.assertEquals("gzip#gzip#38#compressing client", content);
import java.io.IOException;
            OutputStream out = exchange.getResponseBody();
import com.sun.net.httpserver.HttpServer;  
        // Content-Encoding#Accept-Encoding#Content-Length#Content
            // Outputs <request-encoding|null>#<response-encoding|null>#<request-body>  
        Assert.assertEquals("gzip#gzip#38#compressing client", content);
            boolean compress = "gzip".equals(exchange.getRequestHeaders().getFirst("Accept-Encoding"));
    }
 */  
        public void onSuccess(Response response) {  
     * followed by the request body. The response is compressed if "Accept-Encoding" is "gzip".
                exchange.getResponseHeaders().add("Content-Encoding", "gzip");
    }  
            exchange.close();
import java.nio.charset.StandardCharsets;
        @Override
            this.complete(response);
        @Override
        Response response = restClient.performRequest(request);  
        // Content-Encoding#Accept-Encoding#Content-Length#Content
        FutureResponse futureResponse = new FutureResponse();
    private static class GzipResponseHandler implements HttpHandler {  
import com.sun.net.httpserver.HttpHandler;
    }
                out = new GZIPOutputStream(out);  
    }
     */
    public static class FutureResponse extends CompletableFuture<Response> implements ResponseListener {
import java.io.ByteArrayOutputStream;
            if (compress) {  
            out.write('#');  
     * A response handler that accepts gzip-encoded data and replies request and response encoding values  
package org.opensearch.client;
            if ("gzip".equals(contentEncoding)) {  
 * compatible open source license.
import java.io.OutputStream;
            boolean compressedRequest = false;
        restClient.close();
import java.io.InputStream;  
        httpServer.createContext("/", new GzipResponseHandler());
            String contentEncoding = exchange.getRequestHeaders().getFirst("Content-Encoding");
            .setChunkedEnabled(chunkedEnabled)
import java.net.InetAddress;
        return bos.toByteArray();
    public static void stopHttpServers() throws IOException {  
import org.junit.AfterClass;  
            out.write('#');
    public void testCompressingClientContentLengthAsync() throws Exception {
        String content = new String(readAll(entity.getContent()), StandardCharsets.UTF_8);
    private static byte[] readAll(InputStream in) throws IOException {
    public void testCompressingClientWithContentLengthSync() throws Exception {  
            out.write((compressedRequest ? contentLength : "null").getBytes(StandardCharsets.UTF_8));
            bos.write(buffer, 0, len);
import java.util.zip.GZIPInputStream;  
import com.sun.net.httpserver.HttpExchange;
        @Override
        in.close();  
    private static HttpServer httpServer;
        return RestClient.builder(new HttpHost("http", address.getHostString(), address.getPort()))  
            }  
        int len = 0;
    /**
            exchange.sendResponseHeaders(200, 0);
        RestClient restClient = createClient(true, false);  
            this.completeExceptionally(exception);  
}  
import org.junit.BeforeClass;
    /**
    }
        request.setEntity(new StringEntity("compressing client", ContentType.TEXT_PLAIN));
    @AfterClass
    }  
        HttpEntity entity = response.getEntity();
        Response response = futureResponse.get();
        byte[] buffer = new byte[1024];  
        // Server should report it had a compressed request and sent back a compressed response  
            out.write(String.valueOf(contentEncoding).getBytes(StandardCharsets.UTF_8));
import java.util.concurrent.CompletableFuture;
        }
            // Encode response if needed  
        }
            out.close();
                body = new GZIPInputStream(body);
            }
     * Read all bytes of an input stream and close it.  
            // Decode body (if any)
            if (compress) {
            out.write('#');
        restClient.performRequestAsync(request, futureResponse);  
        public void onFailure(Exception exception) {
 * this file be licensed under the Apache-2.0 license or a
        restClient.close();
/*  
public class RestClientCompressionTests extends RestClientTestCase {  
            String contentLength = exchange.getRequestHeaders().getFirst("Content-Length");  
        while ((len = in.read(buffer)) > 0) {  
    }
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        request.setEntity(new StringEntity("compressing client", ContentType.TEXT_PLAIN));  
                compressedRequest = true;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.HttpHost;
        httpServer.stop(0);
        RestClient restClient = createClient(true, false);
        String content = new String(readAll(entity.getContent()), StandardCharsets.UTF_8);  
import org.apache.hc.core5.http.ContentType;
        InetSocketAddress address = httpServer.getAddress();
import java.util.zip.GZIPOutputStream;
    @BeforeClass
        InetSocketAddress address = httpServer.getAddress();
