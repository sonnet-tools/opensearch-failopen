    private static class ResponseHandler implements HttpHandler {
        return esResponse;  
    }
import org.junit.Before;
            "/" + statusCode,  
            .setDefaultHeaders(defaultHeaders)
import java.net.InetSocketAddress;
            try {
import com.sun.net.httpserver.HttpServer;
    }
        return restClientBuilder.build();
    private HttpServer createHttpServer() throws Exception {
        httpServer.stop(0);  
        }
 */  
            for (Map.Entry<String, List<String>> header : requestHeaders.entrySet()) {
            .setCompressionEnabled(randomBoolean());
        for (Map.Entry<String, List<String>> header : headers.entrySet()) {  
        });  
import java.util.concurrent.Executors;
        httpServer = null;
     * out of the box by {@link HttpClient}.
    private Map<String, List<String>> defaultHeaders;
        RequestOptions.Builder options = RequestOptions.DEFAULT.toBuilder();
 */
        httpClientExecutor = Executors.newWorkStealingPool();
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);
        restClient = null;
        ResponseHandler(int statusCode) {
import java.time.Duration;  
            header.getValue().forEach(v -> options.addHeader(header.getKey(), v));
import com.sun.net.httpserver.HttpExchange;
 * this file be licensed under the Apache-2.0 license or a
        public void handle(HttpExchange httpExchange) throws IOException {
        String requestBody = "{ \"field\": \"value\" }";
    public void startHttpServer() throws Exception {
    }
    private RestHttpClient createRestClient() {
    private String pathPrefix;  
            Mono.just(StandardCharsets.UTF_8.encode(requestBody))
            }  
            this.statusCode = statusCode;  
    @Before
import com.sun.net.httpserver.Headers;
        final StreamingRequest request = StreamingRequest.newRequest(
                .expectComplete()  
        StreamingResponse esResponse = restClient.streamRequest(request);  
                .verify(Duration.ofSeconds(5));
import java.util.concurrent.TimeUnit;
import reactor.core.publisher.Mono;
        }  
    private HttpServer httpServer;
import java.io.IOException;  
            Headers requestHeaders = httpExchange.getRequestHeaders();
                httpExchange.getRequestBody().close();  
        if (httpClientExecutor.awaitTermination(30, TimeUnit.SECONDS) == false) {
     * Exercises the test http server ability to send back whatever body it received.  
        defaultHeaders = RestClientTestUtil.randomHeaders(getRandom(), "Header-default");  
     */
    private StreamingResponse bodyTest(final String method) throws Exception {  
            }
    }
            StepVerifier.create(Flux.from(esResponse.body())).expectError(ResponseException.class).verify(Duration.ofSeconds(5));  
        httpServer = createHttpServer();
                httpExchange.close();
            }  
package org.opensearch.internal.httpclient;
    private RestHttpClient restClient;
                httpExchange.getRequestBody().transferTo(httpExchange.getResponseBody());  
        return httpServer;
import org.junit.After;  
import com.sun.net.httpserver.HttpHandler;  
            public HttpClient.Builder customizeHttpClient(final HttpClient.Builder httpClientBuilder) {  
        }
     * End to end test for delete with body. We test it explicitly as it is not supported
            StepVerifier.create(Flux.from(esResponse.body()).map(StandardCharsets.UTF_8::decode).map(CharBuffer::toString))
                httpExchange.sendResponseHeaders(statusCode, 0);
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
        throws Exception {  
            Headers responseHeaders = httpExchange.getResponseHeaders();  
    }
    private ExecutorService httpClientExecutor;
    public void testGetWithBody() throws Exception {
    @After
        }
        final RestHttpClientBuilder restClientBuilder = RestHttpClient.builder(httpHost)  
 * The OpenSearch Contributors require contributions made to  
/*  
     * Exercises the test http server ability to send back whatever body it received.  
    /**  
    /**  
                return httpClientBuilder.executor(httpClientExecutor).connectTimeout(Duration.ofSeconds(15));
                .expectNextMatches(s -> s.equals(requestBody))
    }
        }
import java.util.concurrent.ExecutorService;  
import java.nio.CharBuffer;
import reactor.test.StepVerifier;  
    public void testDeleteWithBody() throws Exception {
        return bodyTest(restClient, method, statusCode, Map.of());
}
                responseHeaders.put(header.getKey(), header.getValue());
import java.nio.charset.StandardCharsets;
        httpServer.start();  
        assertEquals(statusCode, esResponse.statusLine().statusCode());  
     * End to end test for get with body. We test it explicitly as it is not supported
                httpExchange.getResponseBody().flush();
        for (int statusCode : RestClientTestUtil.getAllStatusCodes()) {
                httpExchange.getResponseBody().close();
        assertEquals(method, esResponse.requestLine().method());
            } finally {
 *
        bodyTest("GET");  
        httpClientExecutor.shutdown();  
import java.net.InetAddress;
            httpClientExecutor.shutdownNow();
            method,
        ).withOptions(options).build();
        private final int statusCode;  
        @Override  
    }  
import java.util.Map;
    }  
        }
    private StreamingResponse bodyTest(RestHttpClient restClient, String method, int statusCode, Map<String, List<String>> headers)
        pathPrefix = randomBoolean() ? "/testPathPrefix/" + randomAsciiLettersOfLengthBetween(1, 5) : "";  
        int statusCode = RestClientTestUtil.randomStatusCode(getRandom());
public class RestHttpClientSingleHostStreamingIntegTests extends RestHttpClientTestCase {
            restClientBuilder.setPathPrefix(pathPrefix);
import static org.junit.Assert.assertEquals;
import reactor.core.publisher.Flux;
 * Integration test to check interaction between {@link RestHttpClient} and {@link HttpClient}.
import java.net.http.HttpClient;  
        restClientBuilder.setHttpClientConfigCallback(new RestHttpClientBuilder.HttpClientConfigCallback() {
            httpServer.createContext(pathPrefix + "/" + statusCode, new ResponseHandler(statusCode));  
        } else {
        restClient = createRestClient();
/**
        bodyTest("DELETE");  
        if (statusCode >= 200 && statusCode < 400) {  
     */
        }
        restClient.close();
     * out of the box by {@link HttpClient}.
        assertEquals(pathPrefix + "/" + statusCode, esResponse.requestLine().uri());
        // returns a different status code depending on the path
        if (pathPrefix.length() > 0) {  
    public void stopHttpServers() throws IOException, InterruptedException {  
        final HttpHost httpHost = new HttpHost("http", httpServer.getAddress().getHostString(), httpServer.getAddress().getPort());
            @Override
    }  
 * Works against a real http server, one single host, use streaming.  
