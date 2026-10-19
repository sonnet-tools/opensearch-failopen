import org.opensearch.common.bytes.ReleasableBytesReference;
import static org.mockito.Mockito.mock;
        if (randomBoolean()) {
        HttpHandlingSettings httpHandlingSettings = HttpHandlingSettings.fromSettings(settings);  
import static org.hamcrest.Matchers.equalTo;
        );
        private final RestStatus status;  
        final RestRequest request = RestRequest.request(xContentRegistry(), new TestHttpRequest(httpVersion, null, "/") {  
 * ownership. Elasticsearch licenses this file to you under  
import java.util.Map;
    @SuppressWarnings("unchecked")  
            }
import static org.hamcrest.Matchers.hasItem;
        public RestStatus status() {
    }  
        } else {
        public String contentType() {  
        ArgumentCaptor<ActionListener<Void>> listenerCaptor = ArgumentCaptor.forClass(listenerClass);  
            httpRequest,  
        resp.addHeader(customHeader, customHeaderValue);  
        ArgumentCaptor<ActionListener<Void>> listenerCaptor = ArgumentCaptor.forClass(listenerClass);
            return content;
        httpChannel = mock(HttpChannel.class);
            CorsHandler.fromSettings(settings),  
            .put(HttpTransportSettings.SETTING_CORS_ALLOW_ORIGIN.getKey(), originValue)
import org.opensearch.common.io.stream.BytesStreamOutput;  
            bigArrays,  
        // OpenSearchTestCase#after will invoke ensureAllArraysAreReleased which will fail if the response content was not released
        final TestHttpRequest httpRequest = new TestHttpRequest(HttpRequest.HttpVersion.HTTP_1_1, RestRequest.Method.GET, "/");  
            headers.get("X-OpenSearch-Version").get(0)  
        }
        TestHttpResponse response = executeRequest(settings, originValue, "https://127.0.0.1");  
    }
        final BytesReference content = new ReleasableBytesReference(BytesReference.fromByteArray(byteArray, 0), byteArray);
                // do something builder
import org.opensearch.core.common.util.ByteArray;
import java.io.IOException;
 * KIND, either express or implied.  See the License for the
            httpChannel,  
            httpChannel,  
            public HttpResponse createResponse(RestStatus status, BytesReference content) {
        final RestRequest request = RestRequest.request(xContentRegistry(), httpRequest, httpChannel);
        }  
import org.opensearch.common.io.stream.ReleasableBytesStreamOutput;
        DefaultRestChannel channel = new DefaultRestChannel(
        final TestHttpRequest httpRequest = new TestHttpRequest(HttpRequest.HttpVersion.HTTP_1_1, RestRequest.Method.GET, "/");  
            threadPool.getThreadContext(),
        return executeRequest(settings, null, host);
            try (XContentBuilder builder = channel.newBuilder()) {
                throw new IllegalArgumentException("test");  
        final String originValue = "remote-host";  
        if (randomBoolean()) {
    @Before  
        channel.sendResponse(new TestRestResponse());
            JsonXContent.contentBuilder().startObject().endObject()
            httpChannel,  
        // create an HTTP transport with CORS enabled and allow origin configured
        HttpHandlingSettings handlingSettings = HttpHandlingSettings.fromSettings(settings);  
        RestChannel channel = new DefaultRestChannel(
    private TestHttpResponse executeRequest(final Settings settings, final String host) {  
import org.opensearch.threadpool.TestThreadPool;  
            null
            request.getHttpRequest(),
    }  
        final RestRequest request = RestRequest.request(xContentRegistry(), httpRequest, httpChannel);
    public void testHeadersSet() {  
    public void shutdown() {
            bigArrays,
        );
        Settings settings = Settings.builder()
        verify(httpChannel).sendResponse(responseCaptor.capture(), any());
    }
    public void testReleaseInListener() throws IOException {
        httpRequest.getHeaders().put(Task.X_OPAQUE_ID, Collections.singletonList("abc"));  
import org.opensearch.common.lease.Releasable;
            pattern = "/remote-hos.+/";
        );  
            public RestRequest.Method method() {
import org.opensearch.Build;
                throw new IllegalArgumentException("test");  
            listener.onFailure(new ClosedChannelException());
        Map<String, List<String>> headers = nioResponse.headers();
import java.util.Collections;
        final HttpRequest.HttpVersion httpVersion = close ? HttpRequest.HttpVersion.HTTP_1_0 : HttpRequest.HttpVersion.HTTP_1_1;
                httpRequest.getHeaders().put(DefaultRestChannel.CONNECTION, Collections.singletonList(DefaultRestChannel.KEEP_ALIVE));
            verify(httpChannel, times(0)).close();
import org.opensearch.core.common.bytes.BytesReference;
    }  
        assertThat(response.content(), equalTo(new TestRestResponse().content()));
        verify(httpChannel, atLeastOnce()).sendResponse(responseCaptor.capture(), any());  
        final String originValue = CorsHandler.ANY_ORIGIN;
}  
        // inspect what was written  
        return responseCaptor.getValue();
import org.opensearch.common.settings.Settings;  
 * software distributed under the License is distributed on an
import org.opensearch.test.OpenSearchTestCase;
        DefaultRestChannel channel = new DefaultRestChannel(  
 *  
            bigArrays,
            null
            "OpenSearch/" + Build.CURRENT.getQualifiedVersion() + " (" + Build.CURRENT.getDistribution() + ")",
    private ThreadPool threadPool;
            BytesStreamOutput out = channel.bytesOutput();
        assertEquals(Integer.toString(resp.content().length()), headers.get(DefaultRestChannel.CONTENT_LENGTH).get(0));
            CorsHandler.fromSettings(Settings.EMPTY),  
        ArgumentCaptor<TestHttpResponse> responseCaptor = ArgumentCaptor.forClass(TestHttpResponse.class);
            );
 *
        verify(httpChannel).sendResponse(any(), listenerCaptor.capture());  
        DefaultRestChannel channel = new DefaultRestChannel(
        Settings settings = Settings.builder()
        TestHttpResponse nioResponse = responseCaptor.getValue();  
            pattern = originValue;  
        channel.sendResponse(new TestRestResponse());
    private static class TestRestResponse extends RestResponse {
            null
            null
            verify(httpChannel, times(1)).close();  
        final ByteArray byteArray = bigArrays.newByteArray(0, false);  
 * under the License.  
        final Settings settings = Settings.builder().build();
            null  
        final BytesRestResponse response = new BytesRestResponse(
import static org.hamcrest.Matchers.not;
 * You may obtain a copy of the License at  
        ActionListener<Void> listener = listenerCaptor.getValue();
    }  
 * Licensed to Elasticsearch under one or more contributor  
        }
            httpHandlingSettings,  
        channel.sendResponse(new TestRestResponse(RestStatus.METHOD_NOT_ALLOWED, content));
        final String customHeader = "custom-header";
        if (randomBoolean()) {  
        channel.sendResponse(new TestRestResponse());  
/*
            .put(HttpTransportSettings.SETTING_CORS_ALLOW_ORIGIN.getKey(), CorsHandler.ANY_ORIGIN)
 */
 * SPDX-License-Identifier: Apache-2.0
        } else if (randomBoolean()) {
        }
import static org.hamcrest.Matchers.nullValue;
        httpRequest.getHeaders().put(Task.X_OPAQUE_ID, Collections.singletonList("abc"));
            .build();
            @Override
        HttpRequest httpRequest = new TestHttpRequest(HttpRequest.HttpVersion.HTTP_1_1, RestRequest.Method.GET, "/");
import org.opensearch.rest.BytesRestResponse;  
            handlingSettings,
            verify(httpChannel, times(0)).close();
        }  
            .put(HttpTransportSettings.SETTING_CORS_ENABLED.getKey(), true)  
        assertEquals(originValue, response.headers().get(CorsHandler.ACCESS_CONTROL_ALLOW_ORIGIN).get(0));
import static org.mockito.Mockito.any;  
            httpRequest,
            threadPool.getThreadContext(),
            request,
import static org.mockito.Mockito.times;  
        assertThat(response.headers().get(CorsHandler.ACCESS_CONTROL_ALLOW_ORIGIN), nullValue());
import static org.mockito.Mockito.verify;
        }
            .put(HttpTransportSettings.SETTING_CORS_ENABLED.getKey(), true)  
            CorsHandler.fromSettings(settings),
            this(RestStatus.OK, new BytesArray("content".getBytes(StandardCharsets.UTF_8)));  
        verify(httpChannel).sendResponse(any(), listenerCaptor.capture());  
        Class<ActionListener<Void>> listenerClass = (Class<ActionListener<Void>>) (Class) ActionListener.class;
            request,
            threadPool.getThreadContext(),
        // ensure we have reserved bytes
import org.opensearch.core.rest.RestStatus;
            httpChannel,  
            request.getHttpRequest(),
        // create an HTTP transport with CORS enabled and allow origin configured
        final HttpRequest.HttpVersion httpVersion = close ? HttpRequest.HttpVersion.HTTP_1_0 : HttpRequest.HttpVersion.HTTP_1_1;
        TestRestResponse resp = new TestRestResponse();  
            request,
    @After
 */  
            assertThat(out, instanceOf(ReleasableBytesStreamOutput.class));
        final HttpRequest httpRequest;
        ArgumentCaptor<TestHttpResponse> responseCaptor = ArgumentCaptor.forClass(TestHttpResponse.class);
            bigArrays,  
        final String httpConnectionHeaderValue = close ? DefaultRestChannel.CLOSE : DefaultRestChannel.KEEP_ALIVE;
        final RestRequest request = RestRequest.request(xContentRegistry(), httpRequest, httpChannel);
        );
        threadPool = new TestThreadPool("test");  
    }
import org.junit.After;
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
            verify(httpChannel, times(0)).close();
        } else {
            request,
        HttpHandlingSettings handlingSettings = HttpHandlingSettings.fromSettings(settings);
            CorsHandler.fromSettings(settings),
        }  
            }
    private HttpChannel httpChannel;
        );
            threadPool.getThreadContext(),  
            handlingSettings,
            verify(httpChannel, times(1)).close();
        ArgumentCaptor<ActionListener<Void>> listenerCaptor = ArgumentCaptor.forClass(listenerClass);
        }  
        final String httpConnectionHeaderValue = close ? DefaultRestChannel.CLOSE : DefaultRestChannel.KEEP_ALIVE;
            this.content = Objects.requireNonNull(content);
    public void testThatAnyOriginWorks() {
            HttpHandlingSettings.fromSettings(Settings.EMPTY),
            request,
        } else {
                builder.startObject().endObject();  
        DefaultRestChannel channel = new DefaultRestChannel(
        }
import static org.hamcrest.Matchers.containsInAnyOrder;  
    private MockBigArrays bigArrays;  
    }
    }
        } else {  
    }
            httpChannel,
            handlingSettings,
import java.util.List;  
import org.opensearch.core.common.bytes.BytesArray;  
 * GitHub history for details.
    }
import org.opensearch.threadpool.ThreadPool;
        }  
            httpRequest = new TestHttpRequest(  
        final boolean brokenRequest = randomBoolean();  
    }
        final TestHttpRequest httpRequest = new TestHttpRequest(HttpRequest.HttpVersion.HTTP_1_1, RestRequest.Method.GET, "/");
import static org.mockito.Mockito.atLeastOnce;
        TestHttpResponse response = executeRequest(settings, "request-host");
    public void testCloseOnException() {
        } else {
        Settings settings = Settings.builder().put(HttpTransportSettings.SETTING_HTTP_RESET_COOKIES.getKey(), true).build();
        final BigArrays bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
 * compatible open source license.
        // Set up an HTTP transport with only the CORS enabled setting
        final BytesReference content = new ReleasableBytesReference(BytesReference.fromByteArray(byteArray, 0), byteArray);
        } else {
    public void setup() {
        assertEquals(CorsHandler.ORIGIN, response.headers().get(CorsHandler.VARY).get(0));  
            .build();  
            }  
        Map<String, List<String>> headers = httpResponse.headers();
            return "text";
            httpRequest,
import org.opensearch.common.util.MockPageCacheRecycler;  
        final RestRequest request = RestRequest.request(xContentRegistry(), new TestHttpRequest(httpVersion, null, "/") {  
        }  
        if (close) {
            verify(httpChannel, times(1)).close();
            handlingSettings,  
            .put(HttpTransportSettings.SETTING_CORS_ALLOW_CREDENTIALS.getKey(), true)
import java.nio.channels.ClosedChannelException;  
            .put(HttpTransportSettings.SETTING_CORS_ALLOW_ORIGIN.getKey(), pattern)
import org.opensearch.rest.RestResponse;  
    public void testCorsEnabledWithoutAllowOrigins() {
        );
        );
            this.status = Objects.requireNonNull(status);
import org.mockito.ArgumentCaptor;
        assertThat(response.content(), not(instanceOf(Releasable.class)));  
        // send a response
        ActionListener<Void> listener = listenerCaptor.getValue();
        } else {  
        final boolean close = randomBoolean();  
/*  
        TestHttpResponse response = executeRequest(settings, originValue, "https://127.0.0.1");
        }  
        }
import org.opensearch.rest.RestChannel;
            listener.onResponse(null);  
import java.util.Objects;
import org.opensearch.common.util.MockBigArrays;
        expectThrows(IllegalArgumentException.class, () -> channel.sendResponse(new TestRestResponse(RestStatus.OK, content)));  
        assertEquals(originValue, response.headers().get(CorsHandler.ACCESS_CONTROL_ALLOW_ORIGIN).get(0));
        TestHttpResponse response = executeRequest(settings, originValue, "https://127.0.0.1");
        bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        request.getHttpRequest().getHeaders().put(DefaultRestChannel.CONNECTION, Collections.singletonList(httpConnectionHeaderValue));  
        ActionListener<Void> listener = listenerCaptor.getValue();
            return status;  
        if (threadPool != null) {  
        }, httpChannel);
        final String originValue = "remote-host";  
    }  
        assertEquals("true", response.headers().get(CorsHandler.ACCESS_CONTROL_ALLOW_CREDENTIALS).get(0));
        verify(httpChannel).sendResponse(any(), listenerCaptor.capture());
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;  
            request,
            listener.onResponse(null);
        final String pattern;
    public void testResponse() {
        assertEquals("abc", headers.get(Task.X_OPAQUE_ID).get(0));
        assertNull(headers.get("non-existent-header"));
        HttpHandlingSettings handlingSettings = HttpHandlingSettings.fromSettings(settings);  
        final RestRequest request = RestRequest.request(xContentRegistry(), httpRequest, httpChannel);
        final Settings settings = Settings.builder().build();
        final BigArrays bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
    @SuppressWarnings("unchecked")
            bigArrays,
        channel.sendResponse(resp);
 * this work for additional information regarding copyright
        final String customHeaderValue = "xyz";
 * Unless required by applicable law or agreed to in writing,
        assertThat(headers.get(DefaultRestChannel.SET_COOKIE), hasItem("cookie"));
        assertEquals(customHeaderValue, headers.get(customHeader).get(0));  
    public void testCorsEnabledWithAllowOriginsAndAllowCredentials() {
        if (brokenRequest) {
        Class<ActionListener<Void>> listenerClass = (Class<ActionListener<Void>>) (Class) ActionListener.class;
        TestRestResponse(final RestStatus status, final BytesReference content) {  
        final ByteArray byteArray = bigArrays.newByteArray(0, false);  
        }
            httpRequest.getHeaders().put(CorsHandler.ORIGIN, Collections.singletonList(originValue));
        } else {  
            httpRequest,
        }, httpChannel);
 * The OpenSearch Contributors require contributions made to  
                httpRequest.getHeaders().put(DefaultRestChannel.CONNECTION, Collections.singletonList(DefaultRestChannel.CLOSE));
        DefaultRestChannel channel = new DefaultRestChannel(
            bigArrays,  
package org.opensearch.http;
            @Override
            HttpHandlingSettings.fromSettings(Settings.EMPTY),
                () -> { throw new IllegalArgumentException("Can't parse HTTP version"); },
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(
        assertThat(response.headers().get(CorsHandler.VARY), containsInAnyOrder(CorsHandler.ORIGIN));
            httpRequest = new TestHttpRequest(HttpRequest.HttpVersion.HTTP_1_1, RestRequest.Method.GET, "/");  
        } else {
        public BytesReference content() {
            listener.onResponse(null);  
 * the Apache License, Version 2.0 (the "License"); you may
            threadPool.getThreadContext(),
        private final BytesReference content;
            httpChannel,
 *
            RestStatus.INTERNAL_SERVER_ERROR,  
import static org.hamcrest.Matchers.instanceOf;  
            listener.onFailure(new ClosedChannelException());
        Settings settings = Settings.builder().put(HttpTransportSettings.SETTING_CORS_ENABLED.getKey(), true).build();  
            new CorsHandler(CorsHandler.buildConfig(settings)),
        assertEquals(resp.contentType(), headers.get(DefaultRestChannel.CONTENT_TYPE).get(0));  
        Class<ActionListener<Void>> listenerClass = (Class<ActionListener<Void>>) (Class) ActionListener.class;
        final boolean close = randomBoolean();  
        ArgumentCaptor<TestHttpResponse> responseCaptor = ArgumentCaptor.forClass(TestHttpResponse.class);
        // OpenSearchTestCase#after will invoke ensureAllArraysAreReleased which will fail if the response content was not released
            httpRequest,  
    private TestHttpResponse executeRequest(final Settings settings, final String originValue, final String host) {
        Settings settings = Settings.builder()  
    public void testConnectionClose() throws Exception {  
            CorsHandler.fromSettings(Settings.EMPTY),  
import org.opensearch.core.xcontent.XContentBuilder;
        assertThat(headers.get(DefaultRestChannel.SET_COOKIE), hasItem("cookie2"));  
            .put(HttpTransportSettings.SETTING_CORS_ENABLED.getKey(), true)
import org.opensearch.core.action.ActionListener;
        verify(httpChannel).sendResponse(responseCaptor.capture(), any());
        if (originValue != null) {  
            }
    public void testCorsEnabledWithAllowOrigins() {
        if (randomBoolean()) {
            threadPool.getThreadContext(),
import org.opensearch.common.util.BigArrays;
import org.opensearch.rest.RestRequest;
        httpRequest.getHeaders().put(CorsHandler.HOST, Collections.singletonList(host));  
        );
        Settings settings = Settings.builder().build();
        final boolean close = brokenRequest || randomBoolean();
        assertEquals(originValue, response.headers().get(CorsHandler.ACCESS_CONTROL_ALLOW_ORIGIN).get(0));
            null  
        assertNull(response.headers().get(CorsHandler.VARY));  
        HttpHandlingSettings handlingSettings = HttpHandlingSettings.fromSettings(settings);
    }
            CorsHandler.fromSettings(settings),  
            threadPool.getThreadContext(),
            request,  
            httpRequest = new TestHttpRequest(HttpRequest.HttpVersion.HTTP_1_0, RestRequest.Method.GET, "/");
            httpChannel,
        DefaultRestChannel channel = new DefaultRestChannel(
    }  
 */  
import org.opensearch.tasks.Task;
import org.opensearch.common.xcontent.json.JsonXContent;
        request.getHttpRequest().getHeaders().put(DefaultRestChannel.CONNECTION, Collections.singletonList(httpConnectionHeaderValue));  
        // get the response
            if (!close) {  
        }
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
                RestRequest.Method.GET,
        if (randomBoolean()) {  
        TestRestResponse() {
            threadPool.shutdownNow();
    }
                "/"  
        channel.sendResponse(response);
        // inspect what was written  
            if (close) {
    public void testCookiesSet() {
        if (close) {
/*  
        // OpenSearchTestCase#after will invoke ensureAllArraysAreReleased which will fail if the response content was not released
import java.nio.charset.StandardCharsets;
    public void testUnsupportedHttpMethod() {
import org.junit.Before;  
        TestHttpResponse httpResponse = responseCaptor.getValue();  
        // send a response
 * specific language governing permissions and limitations
        );
        if (close) {
            listener.onFailure(new ClosedChannelException());  
            bigArrays,  
        final TestHttpResponse response = executeRequest(Settings.EMPTY, "request-host");  
            null
            }
public class DefaultRestChannelTests extends OpenSearchTestCase {  
            .build();  
        final RestRequest request = RestRequest.request(xContentRegistry(), httpRequest, httpChannel);
