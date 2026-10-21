            "parseEntity",
 * this work for additional information regarding copyright
        assertEquals(nodeName, response.getNodeName());
        }
            performRequestAsync(mainRequest, this::toRequest, options, this::toResponse, listener, emptySet());
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.hc.core5.http.Header;
            "performRequestAndParseEntity",
    /**
            doAnswer(inv -> mockPerformRequest((Request) inv.getArguments()[0])).when(restClient).performRequest(any(Request.class));
    private Void mockPerformRequestAsync(Request request, ResponseListener responseListener) {
import static org.hamcrest.Matchers.hasSize;
        String nodeName = randomAlphaOfLengthBetween(1, 10);
import static org.hamcrest.Matchers.contains;
            doAnswer(inv -> mockPerformRequestAsync(((Request) inv.getArguments()[0]), (ResponseListener) inv.getArguments()[1])).when(
        try {
import java.lang.reflect.Method;
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
import org.apache.hc.core5.http.io.entity.ByteArrayEntity;
 */
     * Mocks the asynchronous request execution by calling the {@link #mockPerformRequest(Request)} method.
        Header httpHeader = request.getOptions().getHeaders().get(0);
        MainResponse custom(MainRequest mainRequest, RequestOptions options) throws IOException {
            final RestClient restClient = mock(RestClient.class);
import java.util.stream.Collectors;
 * Unless required by applicable law or agreed to in writing,
        response = restHighLevelClient.customAndParse(request, optionsForNodeName(nodeName));
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
            performRequestAsyncAndParseEntity(mainRequest, this::toRequest, options, MainResponse::fromXContent, listener, emptySet());
import org.opensearch.test.OpenSearchTestCase;
        void customAndParseAsync(MainRequest mainRequest, RequestOptions options, ActionListener<MainResponse> listener) {
            "performRequestAsync",
     */
 * KIND, either express or implied.  See the License for the
            "parseResponseException",
 *
    private CustomRestClient restHighLevelClient;
    /**
    }
import java.util.Arrays;
        }
import org.opensearch.core.xcontent.MediaTypeRegistry;
import java.io.IOException;
 * Modifications Copyright OpenSearch Contributors. See
    public void testCustomEndpointAsync() throws Exception {
 * specific language governing permissions and limitations
        void customAsync(MainRequest mainRequest, RequestOptions options, ActionListener<MainResponse> listener) {
 */
        final MainRequest request = new MainRequest();
    @Before
 * Licensed to Elasticsearch under one or more contributor
 * compatible open source license.
            "performRequestAsyncAndParseOptionalEntity" };
 * The OpenSearch Contributors require contributions made to
                restClient
     * Mocks the synchronous request execution like if it was executed by OpenSearch.
    /**
/*
            ).performRequestAsync(any(Request.class), any(ResponseListener.class));
import static org.mockito.Mockito.any;
import org.apache.hc.core5.http.message.StatusLine;
import org.apache.lucene.util.BytesRef;
        }
            responseListener.onFailure(e);
package org.opensearch.client;
        PlainActionFuture<MainResponse> future = PlainActionFuture.newFuture();
        return mockResponse;
            "performRequest",
import org.opensearch.action.main.MainRequest;
 *
    public void initClients() throws IOException {
        return null;
    }
    }
import org.opensearch.common.SuppressForbidden;
        assertEquals(nodeName, future.get().getNodeName());
     */
            "performRequestAsyncAndParseEntity",
    /**
            return parseEntity(response.getEntity(), MainResponse::fromXContent);
 * GitHub history for details.
import org.apache.hc.client5.http.classic.methods.HttpGet;
 * this file be licensed under the Apache-2.0 license or a
        when(mockResponse.getRequestLine()).thenReturn(requestLine);
    private Response mockPerformRequest(Request request) throws IOException {
            restHighLevelClient = new CustomRestClient(restClient);
        BytesRef bytesRef = XContentHelper.toXContent(response, MediaTypeRegistry.JSON, false).toBytesRef();
        } catch (IOException e) {
     * A custom high level client that provides custom methods to execute a request and get its associate response back.
import org.opensearch.core.xcontent.XContentHelper;
import org.opensearch.cluster.ClusterName;
import org.apache.hc.core5.http.ContentType;
        RequestOptions.Builder options = RequestOptions.DEFAULT.toBuilder();
import org.opensearch.Version;
        MainResponse toResponse(Response response) throws IOException {
            .map(Method::getName)
            super(restClient, RestClient::close, Collections.emptyList());
    }
        restHighLevelClient.customAndParseAsync(request, optionsForNodeName(nodeName), future);
        MainResponse response = restHighLevelClient.custom(request, optionsForNodeName(nodeName));
import java.util.Collections;
import org.opensearch.core.action.ActionListener;
        options.addHeader("node_name", nodeName);
        }
        when(mockResponse.getStatusLine()).thenReturn(new StatusLine(protocol, 200, "OK"));
 */
import java.util.Set;
/*
        Request toRequest(MainRequest mainRequest) throws IOException {
        }
 * You may obtain a copy of the License at
public class CustomRestHighLevelClientTests extends OpenSearchTestCase {
 * ownership. Elasticsearch licenses this file to you under
        restHighLevelClient.customAsync(request, optionsForNodeName(nodeName), future);
 * SPDX-License-Identifier: Apache-2.0
import org.apache.hc.core5.http.message.RequestLine;
import org.opensearch.action.main.MainResponse;
import org.apache.hc.core5.http.ProtocolVersion;
        ProtocolVersion protocol = new ProtocolVersion("HTTP", 1, 1);
     * so that they can be used by subclasses to implement custom logic.
            "convertExistsResponse",
        String nodeName = randomAlphaOfLengthBetween(1, 10);
     */
            return performRequest(mainRequest, this::toRequest, options, this::toResponse, emptySet());
        future = PlainActionFuture.newFuture();
        assertEquals(nodeName, response.getNodeName());
        private CustomRestClient(RestClient restClient) {
            .filter(method -> Modifier.isProtected(method.getModifiers()))
    }
        RequestLine requestLine = new RequestLine(HttpGet.METHOD_NAME, ENDPOINT, protocol);
import java.util.TreeSet;
        return options.build();
     * The {@link RestHighLevelClient} must declare the following execution methods using the <code>protected</code> modifier
import org.junit.Before;
/*
import org.apache.hc.core5.http.HttpHost;
}
            return new Request(HttpGet.METHOD_NAME, ENDPOINT);
            responseListener.onSuccess(mockPerformRequest(request));
        }
import static java.util.Collections.emptySet;
import org.opensearch.Build;
        final Set<String> protectedMethods = Arrays.stream(RestHighLevelClient.class.getDeclaredMethods())
    public void testCustomEndpoint() throws IOException {
import org.opensearch.action.support.PlainActionFuture;
 * license agreements. See the NOTICE file distributed with
            .collect(Collectors.toCollection(TreeSet::new));
        if (restHighLevelClient == null) {
        assertThat(protectedMethods, contains(methodNames));
            "performRequestAndParseOptionalEntity",
/**
 * Test and demonstrates how {@link RestHighLevelClient} can be extended to support custom endpoints.
        when(mockResponse.getHost()).thenReturn(new HttpHost("localhost", 9200));
            return performRequestAndParseEntity(mainRequest, this::toRequest, options, MainResponse::fromXContent, emptySet());
        assertThat(request.getOptions().getHeaders(), hasSize(1));
        MainResponse response = new MainResponse(httpHeader.getValue(), Version.CURRENT, ClusterName.DEFAULT, "_na", Build.CURRENT);
        assertEquals(nodeName, future.get().getNodeName());
        when(mockResponse.getEntity()).thenReturn(new ByteArrayEntity(bytesRef.bytes, ContentType.APPLICATION_JSON));
import java.lang.reflect.Modifier;
 * not use this file except in compliance with the License.
    }
    @SuppressForbidden(reason = "We're forced to uses Class#getDeclaredMethods() here because this test checks protected methods")
    public void testMethodsVisibility() {
    private static final String ENDPOINT = "/_custom";
        }
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * under the License.
    private static RequestOptions optionsForNodeName(String nodeName) {
        final String[] methodNames = new String[] {
    }
    static class CustomRestClient extends RestHighLevelClient {
    }
        final Response mockResponse = mock(Response.class);
        }
        final MainRequest request = new MainRequest();
 * software distributed under the License is distributed on an
import static org.mockito.Mockito.when;
        MainResponse customAndParse(MainRequest mainRequest, RequestOptions options) throws IOException {
     */
