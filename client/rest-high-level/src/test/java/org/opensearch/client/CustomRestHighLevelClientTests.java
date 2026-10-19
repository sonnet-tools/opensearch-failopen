            "performRequestAndParseEntity",
    /**
import java.util.TreeSet;
            ).performRequestAsync(any(Request.class), any(ResponseListener.class));
            doAnswer(inv -> mockPerformRequestAsync(((Request) inv.getArguments()[0]), (ResponseListener) inv.getArguments()[1])).when(  
     */  
    /**  
        }  
        MainResponse custom(MainRequest mainRequest, RequestOptions options) throws IOException {
        final String[] methodNames = new String[] {  
 * under the License.  
    public void testCustomEndpointAsync() throws Exception {
        BytesRef bytesRef = XContentHelper.toXContent(response, MediaTypeRegistry.JSON, false).toBytesRef();
import org.apache.hc.client5.http.classic.methods.HttpGet;
     * The {@link RestHighLevelClient} must declare the following execution methods using the <code>protected</code> modifier
        MainResponse response = restHighLevelClient.custom(request, optionsForNodeName(nodeName));
            performRequestAsync(mainRequest, this::toRequest, options, this::toResponse, listener, emptySet());
        }  
    private Response mockPerformRequest(Request request) throws IOException {
import static org.mockito.Mockito.when;
    }
import org.opensearch.action.main.MainResponse;
        assertThat(request.getOptions().getHeaders(), hasSize(1));
        restHighLevelClient.customAndParseAsync(request, optionsForNodeName(nodeName), future);
import org.opensearch.core.xcontent.MediaTypeRegistry;  
import org.junit.Before;  
     * Mocks the synchronous request execution like if it was executed by OpenSearch.
import org.opensearch.core.action.ActionListener;
            responseListener.onSuccess(mockPerformRequest(request));  
     */  
import java.util.Arrays;
    /**
        return mockResponse;
import org.opensearch.common.SuppressForbidden;
    private static final String ENDPOINT = "/_custom";  
/**
        MainResponse toResponse(Response response) throws IOException {
        }
            final RestClient restClient = mock(RestClient.class);
    }  
            "parseResponseException",  
            "performRequestAsyncAndParseEntity",
        RequestLine requestLine = new RequestLine(HttpGet.METHOD_NAME, ENDPOINT, protocol);
        when(mockResponse.getStatusLine()).thenReturn(new StatusLine(protocol, 200, "OK"));
            "performRequestAndParseOptionalEntity",  
import org.apache.hc.core5.http.ProtocolVersion;
 * this file be licensed under the Apache-2.0 license or a
        PlainActionFuture<MainResponse> future = PlainActionFuture.newFuture();  
import java.util.stream.Collectors;  
            .map(Method::getName)
 */
        MainResponse response = new MainResponse(httpHeader.getValue(), Version.CURRENT, ClusterName.DEFAULT, "_na", Build.CURRENT);
import static java.util.Collections.emptySet;
        return null;
        Header httpHeader = request.getOptions().getHeaders().get(0);  
import java.io.IOException;
        Request toRequest(MainRequest mainRequest) throws IOException {  
 * GitHub history for details.
        when(mockResponse.getRequestLine()).thenReturn(requestLine);  
            performRequestAsyncAndParseEntity(mainRequest, this::toRequest, options, MainResponse::fromXContent, listener, emptySet());  
public class CustomRestHighLevelClientTests extends OpenSearchTestCase {
 * this work for additional information regarding copyright
import org.apache.hc.core5.http.message.RequestLine;
        }  
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
            "performRequestAsync",
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
        RequestOptions.Builder options = RequestOptions.DEFAULT.toBuilder();
 * Unless required by applicable law or agreed to in writing,
        when(mockResponse.getEntity()).thenReturn(new ByteArrayEntity(bytesRef.bytes, ContentType.APPLICATION_JSON));  
import org.apache.lucene.util.BytesRef;  
import static org.mockito.Mockito.doAnswer;  
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
        future = PlainActionFuture.newFuture();
            .collect(Collectors.toCollection(TreeSet::new));
            "convertExistsResponse",
    }  
import static org.mockito.Mockito.any;
                restClient
            return performRequestAndParseEntity(mainRequest, this::toRequest, options, MainResponse::fromXContent, emptySet());
    }
        }
    static class CustomRestClient extends RestHighLevelClient {
 */  
        void customAndParseAsync(MainRequest mainRequest, RequestOptions options, ActionListener<MainResponse> listener) {
    public void testCustomEndpoint() throws IOException {  
        void customAsync(MainRequest mainRequest, RequestOptions options, ActionListener<MainResponse> listener) {
import org.apache.hc.core5.http.ContentType;
    }
    private Void mockPerformRequestAsync(Request request, ResponseListener responseListener) {
        }  
import org.opensearch.action.main.MainRequest;  
        String nodeName = randomAlphaOfLengthBetween(1, 10);
    /**
        String nodeName = randomAlphaOfLengthBetween(1, 10);
        if (restHighLevelClient == null) {  
    }
        when(mockResponse.getHost()).thenReturn(new HttpHost("localhost", 9200));
            "performRequest",
 * KIND, either express or implied.  See the License for the
    @SuppressForbidden(reason = "We're forced to uses Class#getDeclaredMethods() here because this test checks protected methods")
 * The OpenSearch Contributors require contributions made to  
        restHighLevelClient.customAsync(request, optionsForNodeName(nodeName), future);
 * license agreements. See the NOTICE file distributed with
     * Mocks the asynchronous request execution by calling the {@link #mockPerformRequest(Request)} method.
    public void testMethodsVisibility() {
import java.util.Collections;  
            doAnswer(inv -> mockPerformRequest((Request) inv.getArguments()[0])).when(restClient).performRequest(any(Request.class));
        }  
import org.opensearch.Build;
        private CustomRestClient(RestClient restClient) {
import java.lang.reflect.Modifier;
import static org.hamcrest.Matchers.hasSize;
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
        try {
    }
import org.apache.hc.core5.http.io.entity.ByteArrayEntity;  
import java.util.Set;
        }
        options.addHeader("node_name", nodeName);
 *  
    private CustomRestClient restHighLevelClient;
        assertEquals(nodeName, response.getNodeName());
import org.opensearch.action.support.PlainActionFuture;
 *
package org.opensearch.client;
    public void initClients() throws IOException {
    private static RequestOptions optionsForNodeName(String nodeName) {  
        final Set<String> protectedMethods = Arrays.stream(RestHighLevelClient.class.getDeclaredMethods())
import static org.mockito.Mockito.mock;
 * compatible open source license.
        final MainRequest request = new MainRequest();  
            return parseEntity(response.getEntity(), MainResponse::fromXContent);
/*  
        ProtocolVersion protocol = new ProtocolVersion("HTTP", 1, 1);
        } catch (IOException e) {
import org.apache.hc.core5.http.message.StatusLine;
import org.opensearch.test.OpenSearchTestCase;
        final Response mockResponse = mock(Response.class);
        return options.build();  
 *
import static org.hamcrest.Matchers.contains;  
        assertThat(protectedMethods, contains(methodNames));
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.hc.core5.http.HttpHost;
            "performRequestAsyncAndParseOptionalEntity" };  
            responseListener.onFailure(e);
import org.apache.hc.core5.http.Header;  
            restHighLevelClient = new CustomRestClient(restClient);
            return new Request(HttpGet.METHOD_NAME, ENDPOINT);
 * ownership. Elasticsearch licenses this file to you under  
import java.lang.reflect.Method;  
/*
 * Test and demonstrates how {@link RestHighLevelClient} can be extended to support custom endpoints.
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.cluster.ClusterName;  
     * A custom high level client that provides custom methods to execute a request and get its associate response back.  
        assertEquals(nodeName, future.get().getNodeName());  
/*  
     * so that they can be used by subclasses to implement custom logic.
    }
 */  
            return performRequest(mainRequest, this::toRequest, options, this::toResponse, emptySet());  
        response = restHighLevelClient.customAndParse(request, optionsForNodeName(nodeName));
        final MainRequest request = new MainRequest();
        MainResponse customAndParse(MainRequest mainRequest, RequestOptions options) throws IOException {  
     */  
        }
            .filter(method -> Modifier.isProtected(method.getModifiers()))  
        assertEquals(nodeName, future.get().getNodeName());
            super(restClient, RestClient::close, Collections.emptyList());
            "parseEntity",
import org.opensearch.core.xcontent.XContentHelper;
    @Before
        assertEquals(nodeName, response.getNodeName());
}
 */  
import org.opensearch.Version;
