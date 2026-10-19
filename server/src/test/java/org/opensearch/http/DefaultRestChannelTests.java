import org.opensearch.threadpool.TestThreadPool;
 *
            pattern = originValue;
    }
        DefaultRestChannel channel = new DefaultRestChannel(
            verify(httpChannel, times(0)).close();
 */
        ActionListener<Void> listener = listenerCaptor.getValue();
        assertEquals(customHeaderValue, headers.get(customHeader).get(0));
            }
            handlingSettings,
            request,
            httpChannel,
    }
    }
    }
            threadPool.getThreadContext(),
import org.opensearch.test.OpenSearchTestCase;
        }
        DefaultRestChannel channel = new DefaultRestChannel(
 *
        }
            httpChannel,
                builder.startObject().endObject();
        final String httpConnectionHeaderValue = close ? DefaultRestChannel.CLOSE : DefaultRestChannel.KEEP_ALIVE;
                throw new IllegalArgumentException("test");
        // Set up an HTTP transport with only the CORS enabled setting
        DefaultRestChannel channel = new DefaultRestChannel(
        }
        assertThat(headers.get(DefaultRestChannel.SET_COOKIE), hasItem("cookie2"));
import java.io.IOException;
        final TestHttpResponse response = executeRequest(Settings.EMPTY, "request-host");
        if (randomBoolean()) {
            .put(HttpTransportSettings.SETTING_CORS_ENABLED.getKey(), true)
            httpChannel,
        // OpenSearchTestCase#after will invoke ensureAllArraysAreReleased which will fail if the response content was not released
        Class<ActionListener<Void>> listenerClass = (Class<ActionListener<Void>>) (Class) ActionListener.class;
        assertEquals(originValue, response.headers().get(CorsHandler.ACCESS_CONTROL_ALLOW_ORIGIN).get(0));
        if (close) {
                RestRequest.Method.GET,
        // create an HTTP transport with CORS enabled and allow origin configured
        httpRequest.getHeaders().put(CorsHandler.HOST, Collections.singletonList(host));
        public RestStatus status() {
            httpChannel,
        } else {
    public void shutdown() {
    private ThreadPool threadPool;
    private TestHttpResponse executeRequest(final Settings settings, final String originValue, final String host) {
        }
    @After
        );
    public void testThatAnyOriginWorks() {
import org.mockito.ArgumentCaptor;
            httpRequest,
        private final BytesReference content;
        }
        return responseCaptor.getValue();
            httpRequest,
import static org.hamcrest.Matchers.hasItem;
        final RestRequest request = RestRequest.request(xContentRegistry(), httpRequest, httpChannel);
    private static class TestRestResponse extends RestResponse {
        );
    public void testHeadersSet() {
import org.junit.After;
            listener.onFailure(new ClosedChannelException());
        } else {
        if (originValue != null) {
            .put(HttpTransportSettings.SETTING_CORS_ALLOW_CREDENTIALS.getKey(), true)
            null
            request,
        channel.sendResponse(response);
        final String customHeader = "custom-header";
    public void testUnsupportedHttpMethod() {
import org.opensearch.rest.RestChannel;
            pattern = "/remote-hos.+/";
                // do something builder
            request,
        TestHttpResponse nioResponse = responseCaptor.getValue();
 * Licensed to Elasticsearch under one or more contributor
            null
        resp.addHeader(customHeader, customHeaderValue);
 * specific language governing permissions and limitations
        HttpRequest httpRequest = new TestHttpRequest(HttpRequest.HttpVersion.HTTP_1_1, RestRequest.Method.GET, "/");
        final BytesRestResponse response = new BytesRestResponse(
    public void testCookiesSet() {
        final String pattern;
import static org.hamcrest.Matchers.instanceOf;
    private HttpChannel httpChannel;
        HttpHandlingSettings handlingSettings = HttpHandlingSettings.fromSettings(settings);
            threadPool.getThreadContext(),
        if (randomBoolean()) {
 * Unless required by applicable law or agreed to in writing,
        Settings settings = Settings.builder().put(HttpTransportSettings.SETTING_CORS_ENABLED.getKey(), true).build();
        assertEquals("abc", headers.get(Task.X_OPAQUE_ID).get(0));
            listener.onResponse(null);
        }
            null
        bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
            request.getHttpRequest(),
        assertEquals(Integer.toString(resp.content().length()), headers.get(DefaultRestChannel.CONTENT_LENGTH).get(0));
import java.util.Objects;
import org.opensearch.common.io.stream.ReleasableBytesStreamOutput;
        assertNull(headers.get("non-existent-header"));
            verify(httpChannel, times(0)).close();
        ArgumentCaptor<TestHttpResponse> responseCaptor = ArgumentCaptor.forClass(TestHttpResponse.class);
        Class<ActionListener<Void>> listenerClass = (Class<ActionListener<Void>>) (Class) ActionListener.class;
        public BytesReference content() {
        if (close) {
    }
        } else {
            threadPool.shutdownNow();
import static org.hamcrest.Matchers.nullValue;
import org.opensearch.common.util.MockPageCacheRecycler;
    }
            CorsHandler.fromSettings(settings),
        final BigArrays bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
        if (randomBoolean()) {
            listener.onFailure(new ClosedChannelException());
        // ensure we have reserved bytes
        }
    }
/*
            request,
import static org.mockito.Mockito.any;
/*
        DefaultRestChannel channel = new DefaultRestChannel(
    public void testConnectionClose() throws Exception {
            JsonXContent.contentBuilder().startObject().endObject()
    private MockBigArrays bigArrays;
            threadPool.getThreadContext(),
import org.opensearch.rest.RestRequest;
            httpRequest,
            httpRequest.getHeaders().put(CorsHandler.ORIGIN, Collections.singletonList(originValue));
                httpRequest.getHeaders().put(DefaultRestChannel.CONNECTION, Collections.singletonList(DefaultRestChannel.CLOSE));
    public void testCorsEnabledWithAllowOrigins() {
        assertNull(response.headers().get(CorsHandler.VARY));
            verify(httpChannel, times(0)).close();
        verify(httpChannel).sendResponse(any(), listenerCaptor.capture());
import org.opensearch.common.util.BigArrays;
            @Override
 * license agreements. See the NOTICE file distributed with
            handlingSettings,
        final BytesReference content = new ReleasableBytesReference(BytesReference.fromByteArray(byteArray, 0), byteArray);
import static org.mockito.Mockito.mock;
        );
            httpRequest = new TestHttpRequest(HttpRequest.HttpVersion.HTTP_1_1, RestRequest.Method.GET, "/");
}
            .build();
        ArgumentCaptor<TestHttpResponse> responseCaptor = ArgumentCaptor.forClass(TestHttpResponse.class);
        TestRestResponse(final RestStatus status, final BytesReference content) {
            .put(HttpTransportSettings.SETTING_CORS_ALLOW_ORIGIN.getKey(), pattern)
        ArgumentCaptor<TestHttpResponse> responseCaptor = ArgumentCaptor.forClass(TestHttpResponse.class);
 *    http://www.apache.org/licenses/LICENSE-2.0
        httpChannel = mock(HttpChannel.class);
        channel.sendResponse(new TestRestResponse(RestStatus.METHOD_NOT_ALLOWED, content));
        final RestRequest request = RestRequest.request(xContentRegistry(), httpRequest, httpChannel);
                () -> { throw new IllegalArgumentException("Can't parse HTTP version"); },
 * software distributed under the License is distributed on an
        private final RestStatus status;
 * Modifications Copyright OpenSearch Contributors. See
        channel.sendResponse(resp);
            if (close) {
        final RestRequest request = RestRequest.request(xContentRegistry(), new TestHttpRequest(httpVersion, null, "/") {
        }, httpChannel);
            null
import org.opensearch.common.util.MockBigArrays;
            verify(httpChannel, times(1)).close();
    @SuppressWarnings("unchecked")
            request.getHttpRequest(),
            }
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
        // inspect what was written
import org.opensearch.common.lease.Releasable;
    }
import org.opensearch.common.settings.Settings;
            .put(HttpTransportSettings.SETTING_CORS_ENABLED.getKey(), true)
            }
        request.getHttpRequest().getHeaders().put(DefaultRestChannel.CONNECTION, Collections.singletonList(httpConnectionHeaderValue));
import static org.hamcrest.Matchers.containsInAnyOrder;
        } else {
        if (randomBoolean()) {
        }
            HttpHandlingSettings.fromSettings(Settings.EMPTY),
        verify(httpChannel, atLeastOnce()).sendResponse(responseCaptor.capture(), any());
            threadPool.getThreadContext(),
        httpRequest.getHeaders().put(Task.X_OPAQUE_ID, Collections.singletonList("abc"));
    }
        Settings settings = Settings.builder().put(HttpTransportSettings.SETTING_HTTP_RESET_COOKIES.getKey(), true).build();
import static org.mockito.Mockito.times;
/*
        assertEquals(originValue, response.headers().get(CorsHandler.ACCESS_CONTROL_ALLOW_ORIGIN).get(0));
        expectThrows(IllegalArgumentException.class, () -> channel.sendResponse(new TestRestResponse(RestStatus.OK, content)));
        verify(httpChannel).sendResponse(responseCaptor.capture(), any());
        final HttpRequest.HttpVersion httpVersion = close ? HttpRequest.HttpVersion.HTTP_1_0 : HttpRequest.HttpVersion.HTTP_1_1;
import org.opensearch.rest.RestResponse;
        channel.sendResponse(new TestRestResponse());
 * ownership. Elasticsearch licenses this file to you under
        final String originValue = "remote-host";
        verify(httpChannel).sendResponse(any(), listenerCaptor.capture());
 * under the License.
        HttpHandlingSettings httpHandlingSettings = HttpHandlingSettings.fromSettings(settings);
    }
        // send a response
        }
        );
        final boolean close = brokenRequest || randomBoolean();
            httpChannel,
        TestRestResponse resp = new TestRestResponse();
        } else {
import org.opensearch.core.common.util.ByteArray;
        } else {
import static org.hamcrest.Matchers.equalTo;
    @SuppressWarnings("unchecked")
        if (randomBoolean()) {
        final ByteArray byteArray = bigArrays.newByteArray(0, false);
        Settings settings = Settings.builder()
        );
        // create an HTTP transport with CORS enabled and allow origin configured
            .put(HttpTransportSettings.SETTING_CORS_ALLOW_ORIGIN.getKey(), CorsHandler.ANY_ORIGIN)
import java.nio.channels.ClosedChannelException;
    public void testCorsEnabledWithoutAllowOrigins() {
        final RestRequest request = RestRequest.request(xContentRegistry(), httpRequest, httpChannel);
        verify(httpChannel).sendResponse(responseCaptor.capture(), any());
        );
public class DefaultRestChannelTests extends OpenSearchTestCase {
import java.nio.charset.StandardCharsets;
            httpRequest,
    public void testResponse() {
        assertThat(response.headers().get(CorsHandler.ACCESS_CONTROL_ALLOW_ORIGIN), nullValue());
        assertEquals(CorsHandler.ORIGIN, response.headers().get(CorsHandler.VARY).get(0));
            BytesStreamOutput out = channel.bytesOutput();
            @Override
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
        final Settings settings = Settings.builder().build();
    private TestHttpResponse executeRequest(final Settings settings, final String host) {
        TestHttpResponse response = executeRequest(settings, originValue, "https://127.0.0.1");
                throw new IllegalArgumentException("test");
            listener.onResponse(null);
    public void testCorsEnabledWithAllowOriginsAndAllowCredentials() {
        DefaultRestChannel channel = new DefaultRestChannel(
            bigArrays,
    public void testReleaseInListener() throws IOException {
        ArgumentCaptor<ActionListener<Void>> listenerCaptor = ArgumentCaptor.forClass(listenerClass);
        Map<String, List<String>> headers = nioResponse.headers();
            CorsHandler.fromSettings(Settings.EMPTY),
            "OpenSearch/" + Build.CURRENT.getQualifiedVersion() + " (" + Build.CURRENT.getDistribution() + ")",
            bigArrays,
        TestHttpResponse response = executeRequest(settings, "request-host");
    public void setup() {
    @Before
import static org.hamcrest.Matchers.not;
    }
        if (close) {
        if (brokenRequest) {
        );
        channel.sendResponse(new TestRestResponse());
import static org.mockito.Mockito.verify;
        // inspect what was written
import org.opensearch.core.rest.RestStatus;
        }, httpChannel);
            this.status = Objects.requireNonNull(status);
            public HttpResponse createResponse(RestStatus status, BytesReference content) {
        final HttpRequest.HttpVersion httpVersion = close ? HttpRequest.HttpVersion.HTTP_1_0 : HttpRequest.HttpVersion.HTTP_1_1;
            httpRequest,
            null
        }
 */
        final Settings settings = Settings.builder().build();
 *
            bigArrays,
            return "text";
        HttpHandlingSettings handlingSettings = HttpHandlingSettings.fromSettings(settings);
        final BigArrays bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
        assertThat(response.content(), not(instanceOf(Releasable.class)));
            request,
            HttpHandlingSettings.fromSettings(Settings.EMPTY),
        ArgumentCaptor<ActionListener<Void>> listenerCaptor = ArgumentCaptor.forClass(listenerClass);
        final TestHttpRequest httpRequest = new TestHttpRequest(HttpRequest.HttpVersion.HTTP_1_1, RestRequest.Method.GET, "/");
        final String originValue = CorsHandler.ANY_ORIGIN;
                "/"
        final BytesReference content = new ReleasableBytesReference(BytesReference.fromByteArray(byteArray, 0), byteArray);
        request.getHttpRequest().getHeaders().put(DefaultRestChannel.CONNECTION, Collections.singletonList(httpConnectionHeaderValue));
            CorsHandler.fromSettings(settings),
            httpRequest = new TestHttpRequest(
            request,
        }
        TestHttpResponse response = executeRequest(settings, originValue, "https://127.0.0.1");
 * GitHub history for details.
        public String contentType() {
        ArgumentCaptor<ActionListener<Void>> listenerCaptor = ArgumentCaptor.forClass(listenerClass);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
        threadPool = new TestThreadPool("test");
package org.opensearch.http;
            CorsHandler.fromSettings(Settings.EMPTY),
        TestRestResponse() {
 * the Apache License, Version 2.0 (the "License"); you may
            .build();
        }
        Settings settings = Settings.builder().build();
    }
        assertEquals(originValue, response.headers().get(CorsHandler.ACCESS_CONTROL_ALLOW_ORIGIN).get(0));
            bigArrays,
import org.opensearch.core.common.bytes.BytesReference;
            bigArrays,
 * The OpenSearch Contributors require contributions made to
            return content;
import org.opensearch.threadpool.ThreadPool;
            new CorsHandler(CorsHandler.buildConfig(settings)),
        verify(httpChannel).sendResponse(any(), listenerCaptor.capture());
            listener.onFailure(new ClosedChannelException());
        final TestHttpRequest httpRequest = new TestHttpRequest(HttpRequest.HttpVersion.HTTP_1_1, RestRequest.Method.GET, "/");
            verify(httpChannel, times(1)).close();
        assertThat(headers.get(DefaultRestChannel.SET_COOKIE), hasItem("cookie"));
        RestChannel channel = new DefaultRestChannel(
            threadPool.getThreadContext(),
            threadPool.getThreadContext(),
            bigArrays,
        final RestRequest request = RestRequest.request(xContentRegistry(), httpRequest, httpChannel);
        HttpHandlingSettings handlingSettings = HttpHandlingSettings.fromSettings(settings);
        assertThat(response.headers().get(CorsHandler.VARY), containsInAnyOrder(CorsHandler.ORIGIN));
        final ByteArray byteArray = bigArrays.newByteArray(0, false);
        httpRequest.getHeaders().put(Task.X_OPAQUE_ID, Collections.singletonList("abc"));
            RestStatus.INTERNAL_SERVER_ERROR,
import org.opensearch.core.common.bytes.BytesArray;
        Settings settings = Settings.builder()
    }
            headers.get("X-OpenSearch-Version").get(0)
        );
        final String customHeaderValue = "xyz";
        ActionListener<Void> listener = listenerCaptor.getValue();
        assertEquals("true", response.headers().get(CorsHandler.ACCESS_CONTROL_ALLOW_CREDENTIALS).get(0));
import org.opensearch.Build;
    }
            public RestRequest.Method method() {
            .put(HttpTransportSettings.SETTING_CORS_ENABLED.getKey(), true)
        );
        HttpHandlingSettings handlingSettings = HttpHandlingSettings.fromSettings(settings);
import java.util.Map;
            }
            handlingSettings,
        final boolean brokenRequest = randomBoolean();
            listener.onResponse(null);
    public void testCloseOnException() {
        assertEquals(
            CorsHandler.fromSettings(settings),
        final RestRequest request = RestRequest.request(xContentRegistry(), httpRequest, httpChannel);
        } else if (randomBoolean()) {
            CorsHandler.fromSettings(settings),
        final boolean close = randomBoolean();
            threadPool.getThreadContext(),
            assertThat(out, instanceOf(ReleasableBytesStreamOutput.class));
        final boolean close = randomBoolean();
        final TestHttpRequest httpRequest = new TestHttpRequest(HttpRequest.HttpVersion.HTTP_1_1, RestRequest.Method.GET, "/");
        final RestRequest request = RestRequest.request(xContentRegistry(), new TestHttpRequest(httpVersion, null, "/") {
            .build();
        // OpenSearchTestCase#after will invoke ensureAllArraysAreReleased which will fail if the response content was not released
import java.util.Collections;
    }
            httpChannel,
import org.junit.Before;
import org.opensearch.core.action.ActionListener;
        DefaultRestChannel channel = new DefaultRestChannel(
            bigArrays,
                httpRequest.getHeaders().put(DefaultRestChannel.CONNECTION, Collections.singletonList(DefaultRestChannel.KEEP_ALIVE));
        Class<ActionListener<Void>> listenerClass = (Class<ActionListener<Void>>) (Class) ActionListener.class;
            httpRequest = new TestHttpRequest(HttpRequest.HttpVersion.HTTP_1_0, RestRequest.Method.GET, "/");
            return status;
            this.content = Objects.requireNonNull(content);
            try (XContentBuilder builder = channel.newBuilder()) {
        }
            httpChannel,
        ActionListener<Void> listener = listenerCaptor.getValue();
            if (!close) {
import java.util.List;
            httpHandlingSettings,
        Map<String, List<String>> headers = httpResponse.headers();
            .put(HttpTransportSettings.SETTING_CORS_ALLOW_ORIGIN.getKey(), originValue)
            request,
            null
        }
            this(RestStatus.OK, new BytesArray("content".getBytes(StandardCharsets.UTF_8)));
        // OpenSearchTestCase#after will invoke ensureAllArraysAreReleased which will fail if the response content was not released
        final HttpRequest httpRequest;
 * You may obtain a copy of the License at
import static org.mockito.Mockito.atLeastOnce;
    }
 * not use this file except in compliance with the License.
        } else {
            }
        // send a response
            null
import org.opensearch.rest.BytesRestResponse;
        } else {
        } else {
            verify(httpChannel, times(1)).close();
        return executeRequest(settings, null, host);
            );
 * compatible open source license.
import org.opensearch.common.xcontent.json.JsonXContent;
            handlingSettings,
        TestHttpResponse httpResponse = responseCaptor.getValue();
        TestHttpResponse response = executeRequest(settings, originValue, "https://127.0.0.1");
        final String httpConnectionHeaderValue = close ? DefaultRestChannel.CLOSE : DefaultRestChannel.KEEP_ALIVE;
import org.opensearch.core.xcontent.XContentBuilder;
        Settings settings = Settings.builder()
 */
        channel.sendResponse(new TestRestResponse());
        if (threadPool != null) {
import org.opensearch.tasks.Task;
        final String originValue = "remote-host";
        assertThat(response.content(), equalTo(new TestRestResponse().content()));
        }
        assertEquals(resp.contentType(), headers.get(DefaultRestChannel.CONTENT_TYPE).get(0));
import org.opensearch.common.bytes.ReleasableBytesReference;
        // get the response
import org.opensearch.common.io.stream.BytesStreamOutput;
