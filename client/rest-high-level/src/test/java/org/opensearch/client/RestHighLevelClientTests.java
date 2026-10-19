            assertEquals("value", restHighLevelClient.parseEntity(cborEntity, entityParser));
            assertEquals("value", restHighLevelClient.parseEntity(yamlEntity, entityParser));
            "indices.put_alias",
            ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(restStatus.getStatus(), restStatus.name());
        assertTrue(
        Map<String, Set<Method>> methods,
 * under the License.
        {
                RequestOptions.DEFAULT,
                    ContentType.APPLICATION_JSON
            assertSame(responseException, openSearchException.getCause());
import org.opensearch.index.rankeval.ExpectedReciprocalRank;
                            );
                .field("minimum_index_compatibility_version", testInfo.getVersion().getMinimumIndexCompatibilityVersion())
        assertTrue(names.contains(MeanReciprocalRank.NAME));
        );
        CheckedFunction<MainRequest, Request, IOException> requestConverter = request -> new Request(HttpGet.METHOD_NAME, "/");
        assertEquals(404, trackingActionListener.statusCode.get());
            RestStatus restStatus = randomFrom(RestStatus.values());
                response -> response.getStatusLine().getStatusCode(),
                "Unable to parse response body for Response{requestLine=GET / http/1.1, host=http://localhost:9200, "
        Response mockResponse = new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse);
    public void testPerformRequestOnResponseExceptionWithoutEntity() throws IOException {
        };
import java.net.SocketTimeoutException;
            assertEquals(2, parameterTypes.length);
                    "the second parameter to async method [" + method + "] is the wrong type",
                    "the second parameter to async method [" + method + "] is the wrong type",
            "clusterUuid"
                    endsWith("Response")
                    : Stream.of(tuple)
        ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(restStatus.getStatus(), restStatus.name());
                parameterTypes[2],
 * compatible open source license.
            "cluster.allocation_explain",
        );
        try (XContentBuilder builder = xContentBuilder) {
        assertTrue(names.contains(ExpectedReciprocalRank.NAME));
    );
import org.opensearch.action.search.ShardSearchFailure;
                        } else {
        // to parse a 404 response which contains an error rather than a valid document not found response.
                    "the return type for method [" + method + "] is incorrect",
                categories.put(namedXContent.categoryClass, counter + 1);
        return new StatusLine(HTTP_PROTOCOL, restStatus.getStatus(), restStatus.name());
        when(restClient.performRequest(any(Request.class))).thenThrow(responseException);
            .collect(Collectors.groupingBy(Tuple::v1, Collectors.mapping(Tuple::v2, Collectors.toSet())));
        CheckedFunction<MainRequest, Request, IOException> requestConverter = request -> new Request(HttpGet.METHOD_NAME, "/");
            );
                "minimumIndexCompatibilityVersion"
                    && topLevelMethodsExclusions.contains(method.getName()) == false
        Map<Class<?>, Integer> categories = new HashMap<>();
            );
    private static String toSnakeCase(String camelCase) {
            responseListener.onSuccess(new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse));
    }
            assertEquals(restStatus, openSearchException.status());
/*
        ResponseException responseException = new ResponseException(response);
            }
            ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(restStatus.getStatus(), restStatus.name());
    ) {
                mainRequest,
import org.opensearch.core.rest.RestStatus;
import org.apache.hc.core5.http.message.RequestLine;
            assertThat(openSearchException.getSuppressed()[0], instanceOf(JsonParseException.class));
            // This is no longer true for all methods. Some methods can contain these 2 args backwards because of deprecation
        assertTrue(names.contains(RecallAtK.NAME));
            "indices.upgrade",
    private RestHighLevelClient restHighLevelClient;
            );
    }
import static org.mockito.Mockito.when;
                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
        RestStatus restStatus = randomBoolean() ? RestStatus.OK : randomFrom(RestStatus.values());
        // response parsing throws exception while handling ignores. same as when GetResponse#fromXContent throws error when trying
        responseListener.onFailure(responseException);
        Response response = new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse);
            ResponseException responseException = new ResponseException(response);
        ActionRequestValidationException validationException = new ActionRequestValidationException();
    public void testDefaultNamedXContents() {
        assertEquals(restStatus, openSearchException.status());
                ioe.getMessage()
    }
    }
            return new ByteArrayEntity(BytesReference.bytes(builder).toBytesRef().bytes, contentType);
            "cluster.put_weighted_routing",
                ioe.getMessage()
        mockResponse(mockSearchResponse);
        };
                                // can get rid of 7.0's deprecated "getTemplate"
import org.opensearch.action.search.ClearScrollResponse;
                categories.put(namedXContent.categoryClass, counter + 1);
                response -> response.getStatusLine().getStatusCode(),
        String requestBody = toXContent(toXContent, RequestConverters.REQUEST_BODY_CONTENT_TYPE, false).utf8ToString();
            "nodes.stats",
    private static StatusLine newStatusLine(RestStatus restStatus) {
import java.util.ArrayList;
            );
                    throw new IllegalStateException();
            Collections.emptySet()
            Response response = new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse);
        OpenSearchException openSearchException = (OpenSearchException) trackingActionListener.exception.get();
        assertEquals(Integer.valueOf(5), categories.get(EvaluationMetric.class));
            () -> restHighLevelClient.performRequest(
        assertEquals(responseException.getMessage(), openSearchException.getMessage());
        for (Character aChar : camelCase.toCharArray()) {
        assertFalse(restHighLevelClient.ping(RequestOptions.DEFAULT));
            assertThat(ioe.getCause(), instanceOf(IllegalStateException.class));
                () -> restHighLevelClient.performRequest(mainRequest, requestConverter, RequestOptions.DEFAULT, response -> {
    public void testNullableActionListener() {
    }
            } else {
            OpenSearchException.class,
        IllegalStateException exception = new IllegalStateException();
        RestStatus restStatus = randomFrom(RestStatus.values());
import org.opensearch.action.search.SearchScrollRequest;
 * Licensed to Elasticsearch under one or more contributor
        {
            "the second parameter to submit task method [" + method + "] is the wrong type",
                Collections.emptySet()
            IOException ioe = (IOException) trackingActionListener.exception.get();
    }
            "clusterName",
            assertEquals("OpenSearch exception [type=exception, reason=test error message]", openSearchException.getMessage());
            assertThat(trackingActionListener.exception.get(), instanceOf(IOException.class));
        }
        );
                    + restStatus.getStatus()
 * this file be licensed under the Apache-2.0 license or a
        List<String> names = new ArrayList<>();
            .filter(tuple -> tuple.v2().getAnnotation(Deprecated.class) == null)
        assertEquals(RestStatus.NOT_FOUND, openSearchException.status());
        deprecatedMethods.add("multi_get");
        }
            ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(restStatus.getStatus(), restStatus.name());
            builder.endObject();
                        }
    private static final String SUBMIT_TASK_PREFIX = "submit_";
        CheckedFunction<MainRequest, Request, IOException> requestConverter = request -> new Request(HttpGet.METHOD_NAME, "/");
                    parameterTypes[1],
            Response response = new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse);
            );
    }
        TrackingActionListener trackingActionListener = new TrackingActionListener();
            ShardSearchFailure.EMPTY_ARRAY,
        ResponseListener responseListener = restHighLevelClient.wrapResponseListener(
        Set<String> deprecatedMethods = new HashSet<>();
        assertEquals("async method [" + method + "] should not throw any exceptions", 0, method.getExceptionTypes().length);
        "ping",
                    Modifier.isFinal(method.getClass().getModifiers()) || Modifier.isFinal(method.getModifiers())
        @Override
        assertEquals(restStatus, openSearchException.status());
import org.opensearch.action.ActionRequestValidationException;
            );
    }
        MainRequest mainRequest = new MainRequest();
package org.opensearch.client;
            assertEquals(
    public void testWrapResponseListenerOnResponseExceptionWithEntity() throws IOException {
                .field("build_snapshot", testInfo.getVersion().isSnapshot())
                    endsWith("Request")
            Integer.valueOf(404),
 *
        assertEquals(Integer.valueOf(3), categories.get(Aggregation.class));
                    equalTo(RequestOptions.class)
            ResponseListener responseListener = restHighLevelClient.wrapResponseListener(
    public void testWrapResponseListenerOnException() {
            // taken from the server side MainResponse
                            if (// IndicesClientIT.getIndexTemplate should be renamed "getTemplate" in version 8.0 when we
import org.opensearch.common.xcontent.cbor.CborXContent;
        );
                            }
        OpenSearchException openSearchException = expectThrows(
    private static void assertSubmitTaskMethod(
            httpResponse.setEntity(new StringEntity("{\"status\":" + restStatus.getStatus() + "}", ContentType.APPLICATION_JSON));
        }
            trackingActionListener,
        assertTrue(names.contains(PrecisionAtK.NAME));
        Method method,
            );
        responseListener.onFailure(responseException);
        // The above general-purpose code ignores all deprecated methods which in this case leaves `getTemplate`
        );
 */
                    parameterTypes[0],
        assertEquals("OpenSearch exception [type=exception, reason=test error message]", openSearchException.getMessage());
                assertThat(
    public void testPerformRequestOnSuccess() throws IOException {
            OpenSearchException.class,
                .field("build_type", testInfo.getVersion().getBuildType())
        Response response = mock(Response.class);
        assertThat(trackingActionListener.exception.get(), instanceOf(OpenSearchException.class));
            Collections.emptySet()
    public void testPerformRequestOnResponseExceptionWithIgnoresErrorValidBody() throws IOException {
                    if (apiSpec.contains(apiName) == false) {
                } else {
    private static final String SUBMIT_TASK_SUFFIX = "_task";
        TrackingActionListener trackingActionListener = new TrackingActionListener();
        when(restClient.performRequest(any(Request.class))).thenReturn(response);
        // license
                equalTo("boolean")
            responseListener.onSuccess(new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse));
        when(response.getStatusLine()).thenReturn(newStatusLine(RestStatus.NOT_FOUND));
    public void testWrapResponseListenerOnResponseExceptionWithoutEntity() throws IOException {
            OpenSearchException openSearchException = restHighLevelClient.parseResponseException(responseException);
    public void testApiNamingConventions() throws Exception {
        ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(restStatus.getStatus(), restStatus.name());
            "search_shards",
                requestConverter,
                    + "}",
                    assertSubmitTaskMethod(methods, method, apiName, restSpec);
        ClearScrollResponse mockClearScrollResponse = new ClearScrollResponse(randomBoolean(), randomIntBetween(0, Integer.MAX_VALUE));
    }
        );
    private static Stream<Tuple<String, Method>> getSubClientMethods(String namespace, Class<?> clientClass) {
import org.opensearch.search.SearchHits;
    }
            restSpec.getApi(methodName).getParams(),
        RestStatus restStatus = randomFrom(RestStatus.values());
    }
            ResponseException responseException = new ResponseException(response);
        RestStatus restStatus = randomFrom(RestStatus.values());
import org.apache.hc.core5.http.io.entity.StringEntity;
            } else {
                );
        Response response = new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse);
                    parameterTypes[1].getSimpleName(),
        assertTrue(names.contains(DiscountedCumulativeGain.NAME));
        verify(restClient, times(3)).close();
        "security.get_ssl_certificates",
        }
        assertSame(responseException, openSearchException.getSuppressed()[0]);
            "indices.recovery",
import org.opensearch.action.search.SearchResponseSections;
                    + " "
            assertEquals(responseException.getMessage(), openSearchException.getMessage());
    public void testWrapResponseListenerOnResponseExceptionWithBrokenEntity() throws IOException {
        restClient = mock(RestClient.class);
            Integer counter = categories.putIfAbsent(namedXContent.categoryClass, 1);
                    "the first parameter to async method [" + method + "] should be a request type",
                Collections.emptySet()
                true,
        );
            )
                Collections.emptySet()
        // TODO remove in 8.0 - we will undeprecate indices.get_template because the current getIndexTemplate
import org.opensearch.core.action.ActionListener;
        OpenSearchException openSearchException = expectThrows(
                    "the second parameter to method [" + method + "] is the wrong type",
    }
        Response response = new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse);
            Response response = new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse);
            TrackingActionListener trackingActionListener = new TrackingActionListener();
            5,
        assertEquals(responseException.getMessage(), openSearchException.getMessage());
    /**
        assertEquals(
        Stream.concat(Arrays.stream(notYetSupportedApi), Arrays.stream(notRequiredApi))
        assertEquals(expectedInternalAggregations, categories.get(Aggregation.class).intValue());
            response -> response.getStatusLine().getStatusCode(),
            ResponseException responseException = new ResponseException(response);
import org.junit.Before;
    public void testConvertExistsResponse() {
            response -> response.getStatusLine().getStatusCode(),
                "buildDate",
    public void testPingSocketTimeout() throws IOException {
            "render_search_template",
            parameterTypes[1],
        // we decided not to support cat API in the high-level REST client, they are supposed to be used from a low-level client
        httpResponse.setEntity(
        );
            return builder;
    public void testPerformRequestOnResponseExceptionWithBrokenEntity2() throws IOException {
        // response parsing throws exception while handling ignores. same as when GetResponse#fromXContent throws error when trying
                    endsWith("Request")
import org.opensearch.core.xcontent.NamedXContentRegistry;
        {
                    + "}",
                .field("minimum_wire_compatibility_version", testInfo.getVersion().getMinimumWireCompatibilityVersion())
            // This is no longer true for all methods. Some methods can contain these 2 args backwards because of deprecation
            Response response = new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse);
            "async method [" + method.getName() + "] doesn't have corresponding sync method",
        CheckedFunction<MainRequest, Request, IOException> requestConverter = request -> new Request(HttpGet.METHOD_NAME, "/");
            RestStatus restStatus = randomFrom(RestStatus.values());
            assertSame(validationException, actualException);
import java.util.Collections;
                // we convert all the method names to snake case, hence we need to look for the '_async' suffix rather than 'Async'
    }
            }
        assertSame(responseException, openSearchException.getSuppressed()[0]);
            "cluster.pending_tasks",
        httpResponse.setEntity(new StringEntity("{\"error\":\"test error message\",\"status\":404}", ContentType.APPLICATION_JSON));
            }
                );
        {
            }
    public void testProvidedNamedXContents() {
                    }
        );
            Integer result = restHighLevelClient.performRequest(
            HttpEntity yamlEntity = new StringEntity("---\nfield: value\n", ContentType.create("application/yaml"));
import org.opensearch.test.rest.yaml.restspec.ClientYamlSuiteRestSpec;
    public void testWrapResponseListenerOnResponseExceptionWithIgnoresErrorValidBody() throws IOException {
            apiNotFound.size(),
        ResponseListener responseListener = restHighLevelClient.wrapResponseListener(
                );
                }
        MainRequest mainRequest = new MainRequest();
            parameterTypes[0].getSimpleName(),
        clearScrollRequest.addScrollId(randomAlphaOfLengthBetween(5, 10));
            assertThat(trackingActionListener.exception.get(), instanceOf(OpenSearchException.class));
    public void testWrapResponseListenerOnResponseExceptionWithIgnores() throws IOException {
        assertTrue(names.contains(DiscountedCumulativeGain.NAME));
        }
            public ActionRequestValidationException validate() {
        assertThrows(
                "Unable to parse response body for Response{requestLine=GET / http/1.1, host=http://localhost:9200, "
                "the third parameter to async method [" + method + "] is the wrong type",
            HttpEntity smileEntity = createBinaryEntity(SmileXContent.contentBuilder(), ContentType.create("application/smile"));
import static org.hamcrest.CoreMatchers.instanceOf;
            }
        );
import org.opensearch.index.rankeval.PrecisionAtK;
import org.hamcrest.Matchers;
    private static boolean isSubmitTaskMethod(String apiName) {
        Response mockResponse = new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse);
import org.opensearch.search.aggregations.matrix.stats.MatrixStatsAggregationBuilder;
            ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(restStatus.getStatus(), restStatus.name());
        StringBuilder snakeCaseString = new StringBuilder();
                response -> response.getStatusLine().getStatusCode(),
            if (parameterTypes[0].equals(RequestOptions.class)) {
                    + restStatus.getStatus()
            @Override
                snakeCaseString.append('_');
            "Some client method doesn't match a corresponding API defined in the REST spec: " + apiNotFound,
            OpenSearchException openSearchException = restHighLevelClient.parseResponseException(responseException);
                    parameterTypes[0].getSimpleName(),
        } else {
 * Unless required by applicable law or agreed to in writing,
            .flatMap(
import org.opensearch.core.xcontent.XContentBuilder;
        Response response = new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse);
        );
        assertNull(trackingActionListener.exception.get());
 * SPDX-License-Identifier: Apache-2.0
            assertThat(
    private static HttpEntity createBinaryEntity(XContentBuilder xContentBuilder, ContentType contentType) throws IOException {
                    "the first parameter to method [" + method + "] is the wrong type",
            assertEquals("async method [" + method + "] has the wrong number of arguments", 3, method.getParameterCount());
                mainRequest,
    }
        {
     */
            IllegalStateException ise = expectThrows(IllegalStateException.class, () -> restHighLevelClient.parseEntity(null, null));
        OpenSearchException openSearchException = expectThrows(
                "number",
                () -> restHighLevelClient.performRequest(request, null, RequestOptions.DEFAULT, null, null)
            .map(method -> Tuple.tuple(toSnakeCase(method.getName()), method))
        // although we got an exception, we turn it into a successful response because the status code was provided among ignores
        mockResponse((ToXContentFragment) (builder, params) -> {
import static org.mockito.Mockito.verify;
            100,
            );
                tuple -> tuple.v2().getReturnType().getName().endsWith("Client")
        assertEquals("incorrect number of exceptions for method [" + method + "]", 1, method.getExceptionTypes().length);
    @Before
    }
            "indices.shard_stores",
 *
            );
        "delete_all_pits",
        assertSame(responseException, openSearchException.getCause());
            IOException ioe = expectThrows(
        assertEquals(expectedSuggestions, categories.get(Suggest.Suggestion.class).intValue());
    public void testPing404NotFound() throws IOException {
        CheckedFunction<MainRequest, Request, IOException> requestConverter = request -> new Request(HttpGet.METHOD_NAME, "/");
import org.opensearch.OpenSearchException;
        httpResponse.setEntity(
            httpResponse.setEntity(
import org.apache.hc.core5.http.HttpHost;
        assertThat(openSearchException.getSuppressed()[0], instanceOf(JsonParseException.class));
            assertEquals("incorrect number of arguments for method [" + method + "]", 1, method.getParameterCount());
        ResponseException responseException = new ResponseException(mockResponse);
            names.add(namedXContent.name.getPreferredName());
        // although we got an exception, we turn it into a successful response because the status code was provided among ignores
        MainRequest mainRequest = new MainRequest();
    }
            httpResponse.setEntity(new StringEntity("{\"error\":", ContentType.APPLICATION_JSON));
        Response response = mock(Response.class);
            assertSame(responseException, openSearchException.getSuppressed()[0]);
import org.opensearch.search.suggest.Suggest;
                assertThat(
            );
        MainRequest mainRequest = new MainRequest();
                    + "response=HTTP/1.1 "
            Collections.singleton(404)
            assertEquals(
                requestConverter,
                mainRequest,
import org.opensearch.index.rankeval.EvaluationMetric;
            "cluster.state",
            "cluster.post_voting_config_exclusions",
        assertSame(responseException, openSearchException.getCause());
                snakeCaseString.append(Character.toLowerCase(aChar));
        assertEquals(mockClearScrollResponse.isSucceeded(), clearScrollResponse.isSucceeded());
            .map(method -> Tuple.tuple(namespace + "." + toSnakeCase(method.getName()), method))
 * Modifications Copyright OpenSearch Contributors. See
                );
            RestStatus restStatus = randomFrom(RestStatus.values());
            if (!method.getReturnType().isAssignableFrom(Optional.class)) {
            restHighLevelClient.performRequestAsync(request, null, RequestOptions.DEFAULT, null, trackingActionListener, null);
            trackingActionListener,
            assertThat(
        assertEquals("Unable to parse response body", openSearchException.getMessage());
        // a few methods don't accept a request object as argument
import org.opensearch.client.core.MainRequest;
        ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(RestStatus.NOT_FOUND.getStatus(), RestStatus.NOT_FOUND.name());
        ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(restStatus.getStatus(), restStatus.name());
 *
    private static final Set<String> APIS_WITHOUT_REQUEST_OBJECT = Sets.newHashSet(
            assertThat(parameterTypes[0], equalTo(RequestOptions.class));
                response -> { throw new IllegalStateException(); },
        Response response = new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse);
                if (apiName.endsWith("_async")) {
                RequestOptions.DEFAULT,
        topLevelMethodsExclusions.add("close");
            "dangling_indices.import_dangling_index",
                requestConverter,
            CheckedFunction<XContentParser, String, IOException> entityParser = parser -> {
    }
                        if (deprecatedMethods.contains(apiName)) {
        OpenSearchException openSearchException = expectThrows(
        }
        {
import org.opensearch.core.xcontent.XContentParser;
        assertEquals(5, searchResponse.getSuccessfulShards());
        Response mockResponse = new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse);
import org.opensearch.tools.jackson.core.JsonParseException;
                    "the first parameter to async method [" + method + "] should be a request type",
            IllegalStateException ise = expectThrows(
            public ActionRequestValidationException validate() {
            RequestOptions.DEFAULT
        return apiName.startsWith(SUBMIT_TASK_PREFIX) && apiName.endsWith(SUBMIT_TASK_SUFFIX);
import static org.mockito.Mockito.mock;
 * KIND, either express or implied.  See the License for the
                Collections.emptySet()
                assertThat(
        );
        ResponseException responseException = new ResponseException(mockResponse);
            assertEquals("value", restHighLevelClient.parseEntity(smileEntity, entityParser));
                );
    }
            );
     * The method naming/parameter assertions use this {@code Set} to determine which rules to apply.
            "cluster.put_decommission_awareness",
        Map<String, Set<Method>> methods = Arrays.stream(RestHighLevelClient.class.getMethods())
            for (Method method : entry.getValue()) {
        ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(restStatus.getStatus(), restStatus.name());
            () -> restHighLevelClient.performRequest(
    public void testPerformRequestOnResponseExceptionWithBrokenEntity() throws IOException {
                mainRequest,
        final Class<?>[] parameterTypes = method.getParameterTypes();
import org.opensearch.core.xcontent.ToXContentFragment;
            "submit task method [" + method + "] must have wait_for_completion parameter in rest spec",
        when(restClient.performRequest(any(Request.class))).thenThrow(new SocketTimeoutException());
            new MainResponse.Version(
            "indices.resolve_index",
            HttpEntity jsonEntity = new StringEntity("{\"field\":\"value\"}", ContentType.APPLICATION_JSON);
                tuple -> tuple.v2().getReturnType().getName().endsWith("Client")
        topLevelMethodsExclusions.add("getLowLevelClient");
    }
        httpResponse.setEntity(new StringEntity("{\"error\":", ContentType.APPLICATION_JSON));
                Collections.emptySet()
            assertEquals(restStatus, openSearchException.status());
    public void testCloseIsIdempotent() throws IOException {
    }
            "remote_store.restore",
        }
        OpenSearchException openSearchException = expectThrows(
        assertTrue("submit task method [" + method.getName() + "] doesn't have corresponding sync method", methods.containsKey(methodName));
            5,
import org.opensearch.test.rest.yaml.restspec.ClientYamlSuiteRestApi;
        assertEquals(2, categories.size());
        ResponseException responseException = new ResponseException(mockResponse);
    public void testSearchScroll() throws IOException {
            assertThat("the parameter to method [" + method + "] is the wrong type", parameterTypes[0], equalTo(RequestOptions.class));
    public void testClearScroll() throws IOException {
        "info",
            String apiName = entry.getKey();
                assertThat(
        }
            restHighLevelClient.performRequest(
        ResponseListener responseListener = restHighLevelClient.wrapResponseListener(
            () -> restHighLevelClient.performRequestAsync(request, null, RequestOptions.DEFAULT, null, null, null)
import org.opensearch.search.aggregations.InternalAggregations;
            // It's acceptable for 404s to be represented as empty Optionals
 * GitHub history for details.
            assertThat(openSearchException.getSuppressed()[0], instanceOf(IllegalStateException.class));
            OpenSearchException openSearchException = restHighLevelClient.parseResponseException(responseException);
            builder.startObject("version")
        ResponseException responseException = new ResponseException(response);
    private void mockResponse(ToXContent toXContent) throws IOException {
        MainResponse testInfo = new MainResponse(
        ResponseException responseException = new ResponseException(response);
import org.opensearch.common.xcontent.smile.SmileXContent;
        verify(restClient, times(1)).close();
import java.util.concurrent.atomic.AtomicReference;
            Response response = new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse);
        when(restClient.performRequest(any(Request.class))).thenThrow(responseException);
            RestStatus restStatus = randomFrom(RestStatus.values());
        TrackingActionListener trackingActionListener = new TrackingActionListener();
        ResponseListener responseListener = restHighLevelClient.wrapResponseListener(
        assertEquals(RestStatus.NOT_FOUND, openSearchException.status());
            "nodes.reload_secure_settings",
                assertTrue(parser.nextToken().isValue());
            "ingest.processor_grok",
            if (Character.isUpperCase(aChar)) {
        expectThrows(SocketTimeoutException.class, () -> restHighLevelClient.ping(RequestOptions.DEFAULT));
    public void testPerformRequestOnResponseExceptionWithEntity() throws IOException {
        assertEquals(Integer.valueOf(5), categories.get(MetricDetail.class));
                            apiName.equals("indices.get_index_template") == false) {
 * software distributed under the License is distributed on an
                Collections.emptySet()
        {
    public void testWrapResponseListenerOnResponseExceptionWithIgnoresErrorNoBody() throws IOException {
        Response mockResponse = new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse);
        // security
        "security.get_user_privileges",
        MainRequest mainRequest = new MainRequest();
            "get_script_context",
        assertSame(responseException, openSearchException.getCause());
        List<NamedXContentRegistry.Entry> namedXContents = RestHighLevelClient.getProvidedNamedXContents();
        final Class<?>[] parameterTypes = method.getParameterTypes();
                    parameterTypes[1].getSimpleName(),
        ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(RestStatus.NOT_FOUND.getStatus(), RestStatus.NOT_FOUND.name());
            "cluster.delete_weighted_routing",
        }
                Collections.emptySet()
                IOException.class,
            equalTo(0)
            assertSame(responseException, openSearchException.getCause());
        ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(RestStatus.NOT_FOUND.getStatus(), RestStatus.NOT_FOUND.name());
            () -> restHighLevelClient.performRequest(mainRequest, requestConverter, RequestOptions.DEFAULT, response -> {
            assertSame(responseException, openSearchException.getCause());
                    assertAsyncMethod(methods, method, apiName);
 * not use this file except in compliance with the License.
            "cluster.stats",
        TrackingActionListener trackingActionListener = new TrackingActionListener();
            };
import java.util.Arrays;
    }
        if (APIS_WITHOUT_REQUEST_OBJECT.contains(apiName)) {
        assertTrue(names.contains(RecallAtK.NAME));
import org.opensearch.index.rankeval.MetricDetail;
                assertThat(
            new StringEntity("{\"error\":\"test error message\",\"status\":" + restStatus.getStatus() + "}", ContentType.APPLICATION_JSON)
    public void testWrapResponseListenerOnSuccess() {
                equalTo(ActionListener.class)
            response -> { throw new IllegalStateException(); },
                .field("lucene_version", testInfo.getVersion().getLuceneVersion())
        assertSame(responseException, openSearchException.getCause());
            new StringEntity("{\"error\":\"test error message\",\"status\":" + restStatus.getStatus() + "}", ContentType.APPLICATION_JSON)
        ResponseException responseException = new ResponseException(response);
import org.opensearch.action.ActionRequest;
            }
            trackingActionListener,
        ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(RestStatus.NOT_FOUND.getStatus(), RestStatus.NOT_FOUND.name());
        Set<String> apiUnsupported = new HashSet<>(apiSpec);
        assertEquals("Had: " + categories, 3, categories.size());
        restHighLevelClient = new RestHighLevelClient(restClient, RestClient::close, Collections.emptyList());
            assertThat(parameterTypes[1], equalTo(ActionListener.class));
            response -> response.getStatusLine().getStatusCode(),
            OpenSearchException.class,
            Response response = new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse);
        Response mockResponse = new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse);
        );
            )
            builder.field("field", "value");
            assertEquals("OpenSearch didn't return the [Content-Type] header, unable to parse response body", ise.getMessage());
        // to parse a 404 response which contains an error rather than a valid document not found response.
                assertTrue("method [" + method + "] should be public", Modifier.isPublic(method.getModifiers()));
        ResponseException responseException = new ResponseException(mockResponse);
        "security.authenticate",
            httpResponse.setEntity(new StringEntity("{\"error\":", ContentType.APPLICATION_JSON));
            "remote_store.stats",
        }
        httpResponse.setEntity(new StringEntity("{\"status\":" + restStatus.getStatus() + "}", ContentType.APPLICATION_JSON));
            ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(restStatus.getStatus(), restStatus.name());
        String apiName,
import static org.hamcrest.CoreMatchers.endsWith;
            ActionRequestValidationException actualException = expectThrows(
                    parameterTypes[0],
    }
        assertEquals(13, namedXContents.size());
            trackingActionListener,
        for (NamedXContentRegistry.Entry namedXContent : namedXContents) {
        );
            assertEquals("value", restHighLevelClient.parseEntity(jsonEntity, entityParser));
            assertThat(trackingActionListener.exception.get(), instanceOf(OpenSearchException.class));
                assertThat(
        {
        ResponseListener responseListener = restHighLevelClient.wrapResponseListener(
                );
                mainRequest,
            "indices.segments",
        assertTrue(names.contains(PrecisionAtK.NAME));
            assertSame(responseException, openSearchException.getCause());
            assertEquals("Unable to parse response body", openSearchException.getMessage());
        private final AtomicInteger statusCode = new AtomicInteger(-1);
                "buildType",
            );
 * You may obtain a copy of the License at
/*
                )
        Response response = new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse);
        apiUnsupported.remove("indices.get_template");
            responseListener.onFailure(responseException);
            ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(restStatus.getStatus(), restStatus.name());
import org.opensearch.test.InternalAggregationTestCase;
            ResponseListener responseListener = restHighLevelClient.wrapResponseListener(
    }
            "indices.simulate_template",
    private static String extractMethodName(String apiName) {
            OpenSearchException.class,
        assertEquals("OpenSearch exception [type=exception, reason=test error message]", openSearchException.getMessage());
                    apiUnsupported.remove(apiName);
        when(restClient.performRequest(any(Request.class))).thenThrow(responseException);
        assertThat("async method [" + method + "] should return Cancellable", method.getReturnType(), equalTo(Cancellable.class));
import org.opensearch.index.rankeval.MeanReciprocalRank;
import static org.mockito.Mockito.any;
        }
            OpenSearchException.class,
        verify(restClient, times(2)).close();
        TrackingActionListener trackingActionListener = new TrackingActionListener();
        RestStatus restStatus = randomFrom(RestStatus.values());
            assertThat(openSearchException.getSuppressed()[0], instanceOf(IllegalStateException.class));
                assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
            "nodes.usage",
        MainRequest mainRequest = new MainRequest();
                return null;
            assertEquals("Response body expected but not returned", ise.getMessage());
                } else if (isSubmitTaskMethod(apiName)) {
            "nodeName",
                assertThat(
                "luceneVersion",
        } else {
                .endObject();
            .filter(
            methods.containsKey(apiName.substring(0, apiName.length() - 6))
                assertTrue(
                    method.getReturnType().getSimpleName(),
    }
        );
                    "the second parameter to method [" + method + "] is the wrong type",
        when(restClient.performRequest(any(Request.class))).thenThrow(responseException);
                trackingActionListener,
                RequestOptions.DEFAULT,
                "minimumWireCompatibilityVersion",
        assertEquals("submit task method [" + method + "] has the wrong number of arguments", 2, method.getParameterCount());
        ResponseException responseException = new ResponseException(mockResponse);
        Set<String> apiSpec = restSpec.getApis().stream().map(ClientYamlSuiteRestApi::getName).collect(Collectors.toSet());
        MainRequest mainRequest = new MainRequest();
            assertEquals("Unsupported Content-Type: " + entity.getContentType(), ise.getMessage());
            assertEquals(restStatus.getStatus(), result.intValue());
        assertThat(
import org.apache.hc.core5.http.ProtocolVersion;
            assertEquals("Unable to parse response body", openSearchException.getMessage());
        assertTrue(names.contains(MeanReciprocalRank.NAME));
        assertSame(responseException, openSearchException.getCause());
                response -> response.getStatusLine().getStatusCode(),
                requestConverter,
                method.getReturnType().getSimpleName(),
            "cluster.get_decommission_awareness",
                );
import java.util.Map;
            assertEquals(restStatus.getStatus(), trackingActionListener.statusCode.get());
            trackingActionListener,
        return Arrays.stream(clientClass.getMethods())
import org.opensearch.common.collect.Tuple;
            0,
    public void testParseResponseException() throws IOException {
        assertThat(
            response -> response.getStatusLine().getStatusCode(),
            "scripts_painless_execute",
import org.apache.hc.core5.http.message.StatusLine;
    private static void assertSyncMethod(Method method, String apiName, List<String> booleanReturnMethods) {
        assertThat(
import java.lang.reflect.Method;
                    equalTo(RequestOptions.class)
                api -> assertTrue(
    }
    }
        int expectedInternalAggregations = InternalAggregationTestCase.getDefaultNamedXContents().size();
                assertThat(
        when(response.getStatusLine()).thenReturn(newStatusLine(RestStatus.OK));
            )
        assertThat(trackingActionListener.exception.get(), instanceOf(OpenSearchException.class));
import org.apache.hc.core5.http.message.BasicClassicHttpResponse;
        {
    }
        }
            "nodes.info",
            ResponseListener responseListener = restHighLevelClient.wrapResponseListener(
        assertThat(
import java.util.HashSet;
        assertTrue(names.contains(MatrixStatsAggregationBuilder.NAME));
        {
import org.opensearch.common.CheckedFunction;
        {
                requestConverter,
            Matchers.hasKey("wait_for_completion")
            }, Collections.singleton(404))
    }
 * the Apache License, Version 2.0 (the "License"); you may
        assertSame(exception, trackingActionListener.exception.get());
import org.opensearch.search.aggregations.Aggregation;
     * (This is also used for async variants of these APIs when they exist)
        );
            assertTrue(this.statusCode.compareAndSet(-1, statusCode));
            )
        ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(restStatus.getStatus(), restStatus.name());
            OpenSearchException openSearchException = restHighLevelClient.parseResponseException(responseException);
            "create",
 */
        ResponseListener responseListener = restHighLevelClient.wrapResponseListener(
import org.apache.hc.core5.http.ClassicHttpResponse;
            Collections.emptySet()
        TrackingActionListener trackingActionListener = new TrackingActionListener();
        OpenSearchException openSearchException = (OpenSearchException) trackingActionListener.exception.get();
                requestConverter,
        assertTrue(names.contains(ChildrenAggregationBuilder.NAME));
            assertTrue(exception.compareAndSet(null, e));
        ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(restStatus.getStatus(), restStatus.name());
            );
        assertEquals(mockClearScrollResponse.getNumFreed(), clearScrollResponse.getNumFreed());
            ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(restStatus.getStatus(), restStatus.name());
        {
                    "method [" + apiName + "] is not final",
        }
        MainResponse receivedInfo = restHighLevelClient.info(RequestOptions.DEFAULT);
        ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(restStatus.getStatus(), restStatus.name());
    public void initClient() {
            "indices.add_block" };
            assertSame(validationException, trackingActionListener.exception.get());
        // core
        {
                    ? getSubClientMethods(tuple.v1(), tuple.v2().getReturnType())
        OpenSearchException openSearchException = (OpenSearchException) trackingActionListener.exception.get();
import org.opensearch.core.xcontent.ToXContent;
        when(restClient.performRequest(any(Request.class))).thenThrow(responseException);
        assertEquals(mockSearchResponse.getScrollId(), searchResponse.getScrollId());
        List<NamedXContentRegistry.Entry> namedXContents = RestHighLevelClient.getDefaultNamedXContents();
        }
            assertNull(trackingActionListener.exception.get());
    }
    private static final ProtocolVersion HTTP_PROTOCOL = new ProtocolVersion("http", 1, 1);
        deprecatedMethods.add("indices.force_merge");
        Response mockResponse = new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse);
    }
            if (parameterTypes[0].equals(RequestOptions.class)) {
import java.util.List;
            "indices.stats",
            "cluster.delete_voting_config_exclusions",
        assertEquals("Unable to parse response body", openSearchException.getMessage());
        assertThat(openSearchException.getSuppressed()[0], instanceOf(IllegalStateException.class));
        {
            )
    private static void assertAsyncMethod(Map<String, Set<Method>> methods, Method method, String apiName) {
            TrackingActionListener trackingActionListener = new TrackingActionListener();
        assertEquals("OpenSearch exception [type=exception, reason=test error message]", openSearchException.getMessage());
            new SearchScrollRequest(randomAlphaOfLengthBetween(5, 10)),
        ClearScrollResponse clearScrollResponse = restHighLevelClient.clearScroll(clearScrollRequest, RequestOptions.DEFAULT);
            TrackingActionListener trackingActionListener = new TrackingActionListener();
                                method.isAnnotationPresent(Deprecated.class)
                Collections.emptySet()
        when(restClient.performRequest(any(Request.class))).thenThrow(responseException);
                mainRequest,
        assertSame(responseException, openSearchException.getSuppressed()[0]);
        @Override
        when(response.getEntity()).thenReturn(new StringEntity(requestBody, contentType));
                snakeCaseString.append(aChar);
            RestStatus restStatus = randomFrom(RestStatus.values());
                    + restStatus.name()
                "the return type for method [" + method + "] is incorrect",
                assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
        public void onFailure(Exception e) {
        ActionRequest request = new ActionRequest() {
 * this work for additional information regarding copyright
        }
            httpResponse.setEntity(new StringEntity("{\"status\":" + restStatus.getStatus() + "}", ContentType.APPLICATION_JSON));
        when(restClient.performRequest(any(Request.class))).thenReturn(response);
                String value = parser.text();
                    apiUnsupported.remove(api)
            @Override
import static org.opensearch.core.xcontent.XContentHelper.toXContent;
        responseListener.onFailure(responseException);
        ClientYamlSuiteRestSpec restSpec
            assertThat(openSearchException.getSuppressed()[0], instanceOf(IOException.class));
        assertSame(responseException, openSearchException.getSuppressed()[0]);
                IllegalStateException.class,
            builder.startObject();
                trackingActionListener,
                response -> response.getStatusLine().getStatusCode(),
                )
        ResponseException responseException = new ResponseException(mockResponse);
            ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(restStatus.getStatus(), restStatus.name());
        return apiName.substring(SUBMIT_TASK_PREFIX.length(), apiName.length() - SUBMIT_TASK_SUFFIX.length());
        // looking like it doesn't have a valid implementatation when it does.
            }
        Set<String> apiNotFound = new HashSet<>();
        Response mockResponse = new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse);
        );
            );
import org.opensearch.action.search.ClearScrollRequest;
        CheckedFunction<MainRequest, Request, IOException> requestConverter = request -> new Request(HttpGet.METHOD_NAME, "/");
            }
        restHighLevelClient.close();
        CheckedFunction<MainRequest, Request, IOException> requestConverter = request -> new Request(HttpGet.METHOD_NAME, "/");
            );
            TrackingActionListener trackingActionListener = new TrackingActionListener();
public class RestHighLevelClientTests extends OpenSearchTestCase {
import org.opensearch.index.rankeval.RecallAtK;
            equalTo(RequestOptions.class)
        when(restClient.performRequest(any(Request.class))).thenReturn(response);
        public void onResponse(Integer statusCode) {
            Collections.singleton(404)
            OpenSearchException.class,
        apiUnsupported.removeIf(api -> api.startsWith("cat."));
        assertEquals(restStatus, openSearchException.status());
        MainRequest mainRequest = new MainRequest();
            ResponseException responseException = new ResponseException(response);
import org.apache.hc.core5.http.io.entity.ByteArrayEntity;
                    endsWith("Request")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        } else {
        ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(restStatus.getStatus(), restStatus.name());
            SearchResponse.Clusters.EMPTY
        Response mockResponse = new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse);
        assertEquals(5, searchResponse.getTotalShards());
            .forEach(
            .flatMap(
 */
        });
            "dangling_indices.delete_dangling_index",
                trackingActionListener,
            RestStatus restStatus = randomFrom(RestStatus.values());
 *    http://www.apache.org/licenses/LICENSE-2.0
        List<String> booleanReturnMethods = Arrays.asList("security.enable_user", "security.disable_user", "security.change_password");
 * license agreements. See the NOTICE file distributed with
            "cluster.delete_decommission_awareness",
            assertEquals(restStatus, openSearchException.status());
                method -> method.getDeclaringClass().equals(RestHighLevelClient.class)
                    "the first parameter to method [" + method + "] is the wrong type",
        assertEquals("OpenSearch exception [type=exception, reason=test error message]", openSearchException.getMessage());
                throw new IllegalStateException();
            OpenSearchException openSearchException = (OpenSearchException) trackingActionListener.exception.get();
        // These API are not required for high-level client feature completeness
                    + restStatus.name()
                    ? getSubClientMethods(tuple.v1(), tuple.v2().getReturnType())
    }
            assertEquals("Unable to parse response body", openSearchException.getMessage());
        assertTrue(names.contains(ExpectedReciprocalRank.NAME));
    }
            "indices.modify_data_stream" };
    }
        String[] notRequiredApi = new String[] {
        assertSame(responseException, openSearchException.getCause());
                    endsWith("Request")
    }
    public void testPingSuccessful() throws IOException {
                    + "response=HTTP/1.1 "
                    api + " API is either not defined in the spec or already supported by the high-level client",
import org.opensearch.action.search.SearchResponse;
                ActionRequestValidationException.class,
import java.util.concurrent.atomic.AtomicInteger;
        }
            () -> restHighLevelClient.performRequest(
    }
        }
        assertThat(trackingActionListener.exception.get(), instanceOf(OpenSearchException.class));
        );
        // impl will replace the existing getTemplate method.
            ResponseListener responseListener = restHighLevelClient.wrapResponseListener(
        final Class<?>[] parameterTypes = method.getParameterTypes();
    }
                response -> response.getStatusLine().getStatusCode(),
        }
        {
import java.util.stream.Collectors;
import java.util.HashMap;
            IllegalArgumentException.class,
        }
        assertEquals(expectedInternalAggregations + expectedSuggestions, namedXContents.size());
        mockResponse(mockClearScrollResponse);
        );
        // this list should be empty once the high-level client is feature complete
                RequestOptions.DEFAULT,
        when(restClient.performRequest(any(Request.class))).thenThrow(responseException);
 * ownership. Elasticsearch licenses this file to you under
    public void testParseEntity() throws IOException {
import static org.mockito.Mockito.times;
        responseListener.onFailure(exception);
        RestStatus restStatus = randomFrom(RestStatus.values());
    private static final RequestLine REQUEST_LINE = new RequestLine(HttpGet.METHOD_NAME, "/", HTTP_PROTOCOL);
import java.util.stream.Stream;
                Collections.emptySet()
            )
            TrackingActionListener trackingActionListener = new TrackingActionListener();
        assertEquals(0, searchResponse.getHits().getTotalHits().value());
        ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(RestStatus.NOT_FOUND.getStatus(), RestStatus.NOT_FOUND.name());
                                apiNotFound.add(apiName);
    }
            StringEntity entity = new StringEntity("", ContentType.APPLICATION_SVG_XML);
                response -> response.getStatusLine().getStatusCode(),
        assertEquals(restStatus, openSearchException.status());
import java.util.Optional;
import org.opensearch.index.rankeval.DiscountedCumulativeGain;
                "buildHash",
        "license.get_trial_status",
        assertEquals(restStatus, openSearchException.status());
    }
    }
                Collections.singleton(404)
import static org.hamcrest.CoreMatchers.equalTo;
     * These APIs do not use a Request object (because they don't have a body, or any request parameters).
        Map<Class<?>, Integer> categories = new HashMap<>();
        ActionRequest request = new ActionRequest() {
            .filter(method -> method.getDeclaringClass().equals(clientClass))
                            assertTrue(
                throw new IllegalStateException();
                    equalTo(RequestOptions.class)
        OpenSearchException openSearchException = (OpenSearchException) trackingActionListener.exception.get();
        ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(RestStatus.NOT_FOUND.getStatus(), RestStatus.NOT_FOUND.name());
                    parameterTypes[1],
            "cluster.reroute",
            Integer counter = categories.putIfAbsent(namedXContent.categoryClass, 1);
        }
            if (counter != null) {
            ResponseException responseException = new ResponseException(response);
            HttpEntity cborEntity = createBinaryEntity(CborXContent.contentBuilder(), ContentType.create("application/cbor"));
    private static class TrackingActionListener implements ActionListener<Integer> {
}
            randomAlphaOfLengthBetween(5, 10),
                    : Stream.of(tuple)
        responseListener.onFailure(responseException);
            assertEquals(restStatus, openSearchException.status());
            if (counter != null) {
import org.apache.hc.core5.http.HttpEntity;
                );
        assertEquals(testInfo, receivedInfo);
        "get_all_pits",
        for (Map.Entry<String, Set<Method>> entry : methods.entrySet()) {
            () -> restHighLevelClient.performRequest(
                .field("build_hash", testInfo.getVersion().getBuildHash())
        assertEquals(100, searchResponse.getTook().getMillis());
            responseListener.onFailure(responseException);
import org.apache.hc.core5.http.ContentType;
                    parameterTypes[0].getSimpleName(),
    }
            endsWith("Request")
import java.lang.reflect.Modifier;
        );
        RestStatus restStatus = randomFrom(RestStatus.values());
                RequestOptions.DEFAULT,
                response -> response.getStatusLine().getStatusCode(),
        ResponseException responseException = new ResponseException(response);
        when(restClient.performRequest(any(Request.class))).thenReturn(mockResponse);
                }, Collections.emptySet())
        SearchResponse mockSearchResponse = new SearchResponse(
        deprecatedMethods.add("search_scroll");
                RequestOptions.DEFAULT,
            "dangling_indices.list_dangling_indices",
        OpenSearchException openSearchException = expectThrows(
        ResponseException responseException = new ResponseException(mockResponse);
        validationException.addValidationError("validation error");
import org.opensearch.join.aggregations.ChildrenAggregationBuilder;
    public void testRequestValidation() {
            assertSame(responseException, openSearchException.getCause());
                new StringEntity(
            }
        ClearScrollRequest clearScrollRequest = new ClearScrollRequest();
        );
        restHighLevelClient.close();
        assertTrue(restHighLevelClient.ping(RequestOptions.DEFAULT));
        }
        }
        if (apiName.equals("ping") || apiName.contains("exist") || booleanReturnMethods.contains(apiName)) {
    public void testInfo() throws IOException {
        restHighLevelClient.close();
    }
        // Synced flush is deprecated
                                "method [" + method.getName() + "], api [" + apiName + "] should be deprecated",
 * specific language governing permissions and limitations
            assertEquals(restStatus, openSearchException.status());
            () -> restHighLevelClient.performRequest(mainRequest, requestConverter, RequestOptions.DEFAULT, response -> {
            trackingActionListener,
                    assertSyncMethod(method, apiName, booleanReturnMethods);
        Set<String> topLevelMethodsExclusions = new HashSet<>();
    private RestClient restClient;
                trackingActionListener,
                return value;
/*
import org.apache.hc.client5.http.classic.methods.HttpGet;
            ResponseException responseException = new ResponseException(response);
            }, Collections.singleton(404))
        assertEquals(restStatus == RestStatus.OK, result);
            "wlm_stats_list",
            IllegalStateException ise = expectThrows(IllegalStateException.class, () -> restHighLevelClient.parseEntity(entity, null));
        apiUnsupported.remove("indices.flush_synced");
            response -> { throw new IllegalStateException(); },
        if (APIS_WITHOUT_REQUEST_OBJECT.contains(apiName.replaceAll("_async$", ""))) {
import org.opensearch.client.core.MainResponse;
        );
            assertEquals(restStatus, openSearchException.status());
                    equalTo(RequestOptions.class)
                );
        assertThat("Some API are not supported but they should be: " + apiUnsupported, apiUnsupported.size(), equalTo(0));
            "indices.get_upgrade",
            builder.field("name", testInfo.getNodeName());
            } else {
        }
        "security.get_builtin_privileges",
        return snakeCaseString.toString();
            builder.field("cluster_uuid", testInfo.getClusterUuid());
        String[] notYetSupportedApi = new String[] {
                    + " "
                () -> restHighLevelClient.parseEntity(new StringEntity("", (ContentType) null), null)
            "get_script_languages",
import java.io.IOException;
        responseListener.onFailure(responseException);
        assertThat(trackingActionListener.exception.get(), instanceOf(OpenSearchException.class));
            new SearchResponseSections(SearchHits.empty(), InternalAggregations.EMPTY, null, false, false, null, 1),
        // A few methods return a boolean rather than a response object
        String methodName = extractMethodName(apiName);
                    "{\"error\":\"test error message\",\"status\":" + restStatus.getStatus() + "}",
                response -> response.getStatusLine().getStatusCode(),
        assertEquals(RestStatus.NOT_FOUND, openSearchException.status());
        ContentType contentType = ContentType.parse(RequestConverters.REQUEST_BODY_CONTENT_TYPE.mediaType());
        assertEquals(restStatus, openSearchException.status());
        );
        assertEquals(responseException.getMessage(), openSearchException.getMessage());
            "the first parameter to submit task method [" + method + "] is the wrong type",
        private final AtomicReference<Exception> exception = new AtomicReference<>();
        }
                assertThat(
                .field("number", testInfo.getVersion().getNumber())
            Collections.singleton(404)
        "license.get_basic_status"
        Response response = mock(Response.class);
import org.opensearch.core.common.bytes.BytesReference;
    public void testPerformRequestOnResponseExceptionWithIgnoresErrorNoBody() throws IOException {
            builder.field("cluster_name", testInfo.getClusterName());
        RestStatus restStatus = randomFrom(RestStatus.values());
 * The OpenSearch Contributors require contributions made to
                .field("build_date", testInfo.getVersion().getBuildDate())
        boolean result = RestHighLevelClient.convertExistsResponse(response);
import org.opensearch.common.util.set.Sets;
            assertEquals("incorrect number of arguments for method [" + method + "]", 2, method.getParameterCount());
            "nodes.hot_threads",
                );
            ),
    }
        }
        int expectedSuggestions = 3;
            RestStatus restStatus = randomFrom(RestStatus.values());
    public void testPerformRequestOnResponseExceptionWithIgnores() throws IOException {
        for (NamedXContentRegistry.Entry namedXContent : namedXContents) {
        CheckedFunction<MainRequest, Request, IOException> requestConverter = request -> new Request(HttpGet.METHOD_NAME, "/");
        {
        );
        ClientYamlSuiteRestSpec restSpec = ClientYamlSuiteRestSpec.load("/rest-api-spec/api");
            "cluster.get_weighted_routing",
        deprecatedMethods.add("multi_search");
        assertEquals(responseException.getMessage(), openSearchException.getMessage());
        }
            )
                return validationException;
            RestStatus restStatus = randomFrom(RestStatus.values());
        SearchResponse searchResponse = restHighLevelClient.scroll(
            assertEquals("Unable to parse response body", openSearchException.getMessage());
import java.util.Set;
        assertEquals(RestStatus.NOT_FOUND, openSearchException.status());
        httpResponse.setEntity(new StringEntity("{\"error\":\"test error message\",\"status\":404}", ContentType.APPLICATION_JSON));
    }
import org.opensearch.test.OpenSearchTestCase;
            OpenSearchException openSearchException = (OpenSearchException) trackingActionListener.exception.get();
