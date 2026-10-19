        if (APIS_WITHOUT_REQUEST_OBJECT.contains(apiName.replaceAll("_async$", ""))) {
            OpenSearchException openSearchException = restHighLevelClient.parseResponseException(responseException);
            }
        assertThat("async method [" + method + "] should return Cancellable", method.getReturnType(), equalTo(Cancellable.class));
            trackingActionListener,  
            assertEquals(restStatus, openSearchException.status());
        ResponseException responseException = new ResponseException(mockResponse);
            "nodes.stats",
        for (Map.Entry<String, Set<Method>> entry : methods.entrySet()) {
    public void testParseResponseException() throws IOException {  
 */  
                response -> response.getStatusLine().getStatusCode(),  
            new SearchScrollRequest(randomAlphaOfLengthBetween(5, 10)),  
        assertTrue(names.contains(DiscountedCumulativeGain.NAME));
                assertThat(  
import static org.mockito.Mockito.verify;
        );  
import org.opensearch.core.rest.RestStatus;  
        private final AtomicReference<Exception> exception = new AtomicReference<>();  
            Response response = new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse);
        TrackingActionListener trackingActionListener = new TrackingActionListener();  
        MainRequest mainRequest = new MainRequest();
        // we decided not to support cat API in the high-level REST client, they are supposed to be used from a low-level client  
            IOException ioe = expectThrows(
                    equalTo(RequestOptions.class)  
        CheckedFunction<MainRequest, Request, IOException> requestConverter = request -> new Request(HttpGet.METHOD_NAME, "/");  
            assertEquals(restStatus, openSearchException.status());  
                    equalTo(RequestOptions.class)
            )
            assertEquals("value", restHighLevelClient.parseEntity(yamlEntity, entityParser));
    }
            httpResponse.setEntity(new StringEntity("{\"status\":" + restStatus.getStatus() + "}", ContentType.APPLICATION_JSON));
        Set<String> apiSpec = restSpec.getApis().stream().map(ClientYamlSuiteRestApi::getName).collect(Collectors.toSet());  
        assertEquals(responseException.getMessage(), openSearchException.getMessage());
        ResponseException responseException = new ResponseException(response);
        // a few methods don't accept a request object as argument  
            .flatMap(
                    method.getReturnType().getSimpleName(),
 *  
    public void testPerformRequestOnResponseExceptionWithIgnores() throws IOException {
        httpResponse.setEntity(  
                snakeCaseString.append('_');
/*  
        Response response = mock(Response.class);  
        when(restClient.performRequest(any(Request.class))).thenReturn(response);
        }
            assertThat(openSearchException.getSuppressed()[0], instanceOf(IOException.class));
        assertEquals(
                }  
            "wlm_stats_list",
            assertThat(trackingActionListener.exception.get(), instanceOf(OpenSearchException.class));  
        Response response = new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse);
        // A few methods return a boolean rather than a response object
        assertTrue(names.contains(ExpectedReciprocalRank.NAME));
import static org.mockito.Mockito.when;
                            apiName.equals("indices.get_index_template") == false) {
                    Modifier.isFinal(method.getClass().getModifiers()) || Modifier.isFinal(method.getModifiers())
        assertSame(responseException, openSearchException.getSuppressed()[0]);
    public void testApiNamingConventions() throws Exception {
        expectThrows(SocketTimeoutException.class, () -> restHighLevelClient.ping(RequestOptions.DEFAULT));
        assertEquals("submit task method [" + method + "] has the wrong number of arguments", 2, method.getParameterCount());
            apiNotFound.size(),
    private static final String SUBMIT_TASK_SUFFIX = "_task";
        responseListener.onFailure(responseException);  
        "get_all_pits",  
        ResponseException responseException = new ResponseException(mockResponse);
import org.opensearch.test.OpenSearchTestCase;
            httpResponse.setEntity(new StringEntity("{\"error\":", ContentType.APPLICATION_JSON));
            TrackingActionListener trackingActionListener = new TrackingActionListener();  
        apiUnsupported.remove("indices.get_template");
        assertEquals(404, trackingActionListener.statusCode.get());  
import org.apache.hc.core5.http.ProtocolVersion;  
            );  
            if (counter != null) {
        Response mockResponse = new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse);
            IllegalArgumentException.class,
    private static class TrackingActionListener implements ActionListener<Integer> {
            "remote_store.stats",
 * under the License.  
        topLevelMethodsExclusions.add("getLowLevelClient");
        if (APIS_WITHOUT_REQUEST_OBJECT.contains(apiName)) {
        assertThrows(  
                    + "}",
                String value = parser.text();
    public void testWrapResponseListenerOnSuccess() {
 * Unless required by applicable law or agreed to in writing,
            ResponseListener responseListener = restHighLevelClient.wrapResponseListener(  
        );
            assertSame(responseException, openSearchException.getCause());  
import org.apache.hc.core5.http.ClassicHttpResponse;
 *
                    "{\"error\":\"test error message\",\"status\":" + restStatus.getStatus() + "}",
        ClearScrollResponse clearScrollResponse = restHighLevelClient.clearScroll(clearScrollRequest, RequestOptions.DEFAULT);  
        assertEquals("Unable to parse response body", openSearchException.getMessage());
        mockResponse((ToXContentFragment) (builder, params) -> {
            responseListener.onFailure(responseException);
        "info",
    private static String extractMethodName(String apiName) {
        assertEquals(restStatus, openSearchException.status());  
 * Modifications Copyright OpenSearch Contributors. See
    }  
    private static final ProtocolVersion HTTP_PROTOCOL = new ProtocolVersion("http", 1, 1);
        );
    }
        private final AtomicInteger statusCode = new AtomicInteger(-1);
                    assertSubmitTaskMethod(methods, method, apiName, restSpec);  
            ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(restStatus.getStatus(), restStatus.name());  
    public void initClient() {
        );
        assertSame(responseException, openSearchException.getSuppressed()[0]);  
    private static final String SUBMIT_TASK_PREFIX = "submit_";  
                mainRequest,
        }
        );
        assertTrue(names.contains(ExpectedReciprocalRank.NAME));
            if (!method.getReturnType().isAssignableFrom(Optional.class)) {
        responseListener.onFailure(responseException);
            RestStatus restStatus = randomFrom(RestStatus.values());
            );
            .filter(  
                .field("build_date", testInfo.getVersion().getBuildDate())
            };
            OpenSearchException.class,  
                    "the second parameter to async method [" + method + "] is the wrong type",  
            HttpEntity jsonEntity = new StringEntity("{\"field\":\"value\"}", ContentType.APPLICATION_JSON);
        assertEquals(5, searchResponse.getTotalShards());
                "buildDate",
                .field("minimum_wire_compatibility_version", testInfo.getVersion().getMinimumWireCompatibilityVersion())
        httpResponse.setEntity(new StringEntity("{\"status\":" + restStatus.getStatus() + "}", ContentType.APPLICATION_JSON));  
            assertThat(  
        RestStatus restStatus = randomFrom(RestStatus.values());  
            TrackingActionListener trackingActionListener = new TrackingActionListener();
        Set<String> apiNotFound = new HashSet<>();
        {
        assertEquals(Integer.valueOf(5), categories.get(EvaluationMetric.class));  
        MainRequest mainRequest = new MainRequest();  
        }  
        );
import org.opensearch.test.rest.yaml.restspec.ClientYamlSuiteRestSpec;
        assertEquals(testInfo, receivedInfo);
                );
                tuple -> tuple.v2().getReturnType().getName().endsWith("Client")  
    }
        }
        );
                Collections.emptySet()
            // This is no longer true for all methods. Some methods can contain these 2 args backwards because of deprecation
                Collections.emptySet()  
            response -> response.getStatusLine().getStatusCode(),
        Response mockResponse = new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse);  
import org.opensearch.index.rankeval.EvaluationMetric;
            assertEquals(restStatus, openSearchException.status());
        MainResponse receivedInfo = restHighLevelClient.info(RequestOptions.DEFAULT);
            new MainResponse.Version(
        Response mockResponse = new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse);  
        when(restClient.performRequest(any(Request.class))).thenThrow(responseException);
            () -> restHighLevelClient.performRequest(mainRequest, requestConverter, RequestOptions.DEFAULT, response -> {
            ResponseException responseException = new ResponseException(response);
            assertSame(responseException, openSearchException.getCause());  
        );  
        verify(restClient, times(1)).close();
                    parameterTypes[0],
import org.apache.hc.core5.http.message.StatusLine;
import org.opensearch.common.collect.Tuple;  
    }  
                } else {
            StringEntity entity = new StringEntity("", ContentType.APPLICATION_SVG_XML);
    private static StatusLine newStatusLine(RestStatus restStatus) {
                assertThat(
        }
        RestStatus restStatus = randomFrom(RestStatus.values());
import static org.opensearch.core.xcontent.XContentHelper.toXContent;  
                    apiUnsupported.remove(apiName);  
                requestConverter,  
            assertTrue(this.statusCode.compareAndSet(-1, statusCode));
            } else {  
    }  
        return Arrays.stream(clientClass.getMethods())
            ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(restStatus.getStatus(), restStatus.name());
        assertEquals(RestStatus.NOT_FOUND, openSearchException.status());  
        {
                Collections.emptySet()  
    }
                response -> response.getStatusLine().getStatusCode(),
import org.opensearch.index.rankeval.MetricDetail;
import java.util.HashMap;
import java.util.ArrayList;
            )  
            .forEach(  
import static org.mockito.Mockito.any;
    public void testPing404NotFound() throws IOException {
            "cluster.allocation_explain",
        assertTrue(names.contains(PrecisionAtK.NAME));
                requestConverter,
            ActionRequestValidationException actualException = expectThrows(  
        assertEquals(13, namedXContents.size());
            .map(method -> Tuple.tuple(namespace + "." + toSnakeCase(method.getName()), method))
        ResponseListener responseListener = restHighLevelClient.wrapResponseListener(  
                );  
                )  
    private static boolean isSubmitTaskMethod(String apiName) {  
        );
            )
            "nodes.info",  
            )  
            return new ByteArrayEntity(BytesReference.bytes(builder).toBytesRef().bytes, contentType);  
                requestConverter,
        };  
            "indices.modify_data_stream" };  
                true,  
                mainRequest,
        httpResponse.setEntity(  
            builder.field("cluster_uuid", testInfo.getClusterUuid());  
import org.apache.hc.core5.http.io.entity.ByteArrayEntity;
                response -> { throw new IllegalStateException(); },
                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
import org.opensearch.core.xcontent.ToXContent;
            responseListener.onSuccess(new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse));
                assertTrue("method [" + method + "] should be public", Modifier.isPublic(method.getModifiers()));  
            }  
            );  
                    parameterTypes[0].getSimpleName(),
            "cluster.pending_tasks",  
                RequestOptions.DEFAULT,
import org.opensearch.index.rankeval.DiscountedCumulativeGain;  
                "minimumWireCompatibilityVersion",
            }
        );
                mainRequest,
                RequestOptions.DEFAULT,  
    }
            assertSame(validationException, actualException);
import org.opensearch.action.search.SearchScrollRequest;
            .filter(method -> method.getDeclaringClass().equals(clientClass))  
                () -> restHighLevelClient.performRequest(request, null, RequestOptions.DEFAULT, null, null)
    public void testWrapResponseListenerOnResponseExceptionWithIgnores() throws IOException {
    /**
            "cluster.put_weighted_routing",
            trackingActionListener,  
        assertThat(openSearchException.getSuppressed()[0], instanceOf(JsonParseException.class));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.search.SearchHits;
                "number",
import org.opensearch.search.aggregations.InternalAggregations;
            builder.field("cluster_name", testInfo.getClusterName());
            }, Collections.singleton(404))  
        }
 *
            builder.field("name", testInfo.getNodeName());
            ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(restStatus.getStatus(), restStatus.name());
            IllegalStateException ise = expectThrows(  
        RestStatus restStatus = randomFrom(RestStatus.values());
    private static HttpEntity createBinaryEntity(XContentBuilder xContentBuilder, ContentType contentType) throws IOException {
 * specific language governing permissions and limitations
        Response response = mock(Response.class);
        {  
import org.opensearch.common.CheckedFunction;
                () -> restHighLevelClient.parseEntity(new StringEntity("", (ContentType) null), null)
        assertEquals(RestStatus.NOT_FOUND, openSearchException.status());  
            Collections.emptySet()
                trackingActionListener,
            assertSame(responseException, openSearchException.getCause());
    private static void assertSubmitTaskMethod(
     * The method naming/parameter assertions use this {@code Set} to determine which rules to apply.
                equalTo(ActionListener.class)
        return apiName.substring(SUBMIT_TASK_PREFIX.length(), apiName.length() - SUBMIT_TASK_SUFFIX.length());  
    public void testClearScroll() throws IOException {
            RestStatus restStatus = randomFrom(RestStatus.values());
            response -> response.getStatusLine().getStatusCode(),
        }
            new SearchResponseSections(SearchHits.empty(), InternalAggregations.EMPTY, null, false, false, null, 1),
        {
                return null;
import org.opensearch.action.search.ClearScrollRequest;  
            public ActionRequestValidationException validate() {
            SearchResponse.Clusters.EMPTY
            endsWith("Request")
        assertEquals("OpenSearch exception [type=exception, reason=test error message]", openSearchException.getMessage());
    }
        List<NamedXContentRegistry.Entry> namedXContents = RestHighLevelClient.getProvidedNamedXContents();  
            RequestOptions.DEFAULT
        return apiName.startsWith(SUBMIT_TASK_PREFIX) && apiName.endsWith(SUBMIT_TASK_SUFFIX);
                    "the second parameter to method [" + method + "] is the wrong type",
                    + "response=HTTP/1.1 "  
            5,  
            if (parameterTypes[0].equals(RequestOptions.class)) {
        String methodName = extractMethodName(apiName);
            "nodes.reload_secure_settings",
            assertThat(parameterTypes[0], equalTo(RequestOptions.class));
        "security.get_ssl_certificates",
    public void testPerformRequestOnResponseExceptionWithEntity() throws IOException {
 */  
            assertSame(responseException, openSearchException.getSuppressed()[0]);
        assertEquals("OpenSearch exception [type=exception, reason=test error message]", openSearchException.getMessage());
import org.opensearch.search.aggregations.matrix.stats.MatrixStatsAggregationBuilder;
        ResponseListener responseListener = restHighLevelClient.wrapResponseListener(
        assertTrue(names.contains(DiscountedCumulativeGain.NAME));  
    public void testCloseIsIdempotent() throws IOException {  
            () -> restHighLevelClient.performRequest(
        ResponseException responseException = new ResponseException(response);  
    private static Stream<Tuple<String, Method>> getSubClientMethods(String namespace, Class<?> clientClass) {
    private static final Set<String> APIS_WITHOUT_REQUEST_OBJECT = Sets.newHashSet(
            httpResponse.setEntity(new StringEntity("{\"error\":", ContentType.APPLICATION_JSON));  
        }
        assertTrue(names.contains(MeanReciprocalRank.NAME));
        assertSame(responseException, openSearchException.getCause());
                assertThat(
            Response response = new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse);
                } else if (isSubmitTaskMethod(apiName)) {
        );
import org.apache.hc.core5.http.io.entity.StringEntity;
        assertThat(openSearchException.getSuppressed()[0], instanceOf(IllegalStateException.class));
                tuple -> tuple.v2().getReturnType().getName().endsWith("Client")  
        MainRequest mainRequest = new MainRequest();  
                throw new IllegalStateException();  
    }
import java.util.Arrays;
import java.util.Collections;  
            "nodes.hot_threads",
                assertThat(
    public void testPerformRequestOnSuccess() throws IOException {
import static org.mockito.Mockito.mock;
        restHighLevelClient = new RestHighLevelClient(restClient, RestClient::close, Collections.emptyList());  
        assertThat(trackingActionListener.exception.get(), instanceOf(OpenSearchException.class));
        assertEquals("OpenSearch exception [type=exception, reason=test error message]", openSearchException.getMessage());
    }
                .field("minimum_index_compatibility_version", testInfo.getVersion().getMinimumIndexCompatibilityVersion())  
            }  
            ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(restStatus.getStatus(), restStatus.name());
            trackingActionListener,  
                    ? getSubClientMethods(tuple.v1(), tuple.v2().getReturnType())
        RestStatus restStatus = randomBoolean() ? RestStatus.OK : randomFrom(RestStatus.values());
                    + restStatus.name()  
        // to parse a 404 response which contains an error rather than a valid document not found response.
        Map<String, Set<Method>> methods,
        assertTrue(names.contains(MatrixStatsAggregationBuilder.NAME));
            trackingActionListener,
        int expectedInternalAggregations = InternalAggregationTestCase.getDefaultNamedXContents().size();
            CheckedFunction<XContentParser, String, IOException> entityParser = parser -> {  
                    + "}",
        ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(RestStatus.NOT_FOUND.getStatus(), RestStatus.NOT_FOUND.name());
                    + "response=HTTP/1.1 "
                    throw new IllegalStateException();
                throw new IllegalStateException();
            IOException ioe = (IOException) trackingActionListener.exception.get();  
 * GitHub history for details.
    public void testInfo() throws IOException {
                snakeCaseString.append(Character.toLowerCase(aChar));
        RestStatus restStatus = randomFrom(RestStatus.values());
                assertThat(
        MainRequest mainRequest = new MainRequest();
        ResponseException responseException = new ResponseException(response);
            Collections.emptySet()
        apiUnsupported.remove("indices.flush_synced");
            assertEquals(restStatus, openSearchException.status());  
        Set<String> apiUnsupported = new HashSet<>(apiSpec);
        deprecatedMethods.add("multi_search");
    }
            RestStatus restStatus = randomFrom(RestStatus.values());
            );
    }  
            } else {
import static org.hamcrest.CoreMatchers.equalTo;
            HttpEntity smileEntity = createBinaryEntity(SmileXContent.contentBuilder(), ContentType.create("application/smile"));  
            }, Collections.singleton(404))
            "indices.resolve_index",
import org.opensearch.OpenSearchException;  
            assertNull(trackingActionListener.exception.get());
        assertEquals("incorrect number of exceptions for method [" + method + "]", 1, method.getExceptionTypes().length);
        when(restClient.performRequest(any(Request.class))).thenReturn(response);
                return value;  
        }
        when(restClient.performRequest(any(Request.class))).thenThrow(new SocketTimeoutException());  
                    if (apiSpec.contains(apiName) == false) {
        for (Character aChar : camelCase.toCharArray()) {
            equalTo(RequestOptions.class)
        OpenSearchException openSearchException = expectThrows(  
    private static void assertSyncMethod(Method method, String apiName, List<String> booleanReturnMethods) {  
            "cluster.reroute",
        MainRequest mainRequest = new MainRequest();
                    "the return type for method [" + method + "] is incorrect",  
            } else {  
                    ContentType.APPLICATION_JSON
 * ownership. Elasticsearch licenses this file to you under  
            "indices.stats",
                    assertSyncMethod(method, apiName, booleanReturnMethods);
        );  
}
                "the return type for method [" + method + "] is incorrect",
        }
    }
                trackingActionListener,  
import static org.hamcrest.CoreMatchers.endsWith;
                            assertTrue(  
            assertThat(ioe.getCause(), instanceOf(IllegalStateException.class));
                    equalTo(RequestOptions.class)
        assertSame(exception, trackingActionListener.exception.get());
                categories.put(namedXContent.categoryClass, counter + 1);
            Response response = new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse);  
        );  
    public void testWrapResponseListenerOnResponseExceptionWithIgnoresErrorValidBody() throws IOException {
            "dangling_indices.list_dangling_indices",
import java.lang.reflect.Method;
            "nodes.usage",  
        // impl will replace the existing getTemplate method.
                    parameterTypes[1].getSimpleName(),  
        assertThat(  
            RestStatus restStatus = randomFrom(RestStatus.values());  
        assertEquals(restStatus, openSearchException.status());
            );
        } else {  
        Method method,  
        try (XContentBuilder builder = xContentBuilder) {
        assertEquals(Integer.valueOf(5), categories.get(MetricDetail.class));  
                    endsWith("Request")  
                if (apiName.endsWith("_async")) {  
        assertEquals(2, categories.size());  
                Collections.emptySet()
                new StringEntity(  
                    "the first parameter to async method [" + method + "] should be a request type",
        return snakeCaseString.toString();
            TrackingActionListener trackingActionListener = new TrackingActionListener();
import org.opensearch.core.common.bytes.BytesReference;
                "minimumIndexCompatibilityVersion"  
 * Licensed to Elasticsearch under one or more contributor  
                                method.isAnnotationPresent(Deprecated.class)
    public void testWrapResponseListenerOnResponseExceptionWithBrokenEntity() throws IOException {
                    parameterTypes[1].getSimpleName(),
        assertEquals(mockSearchResponse.getScrollId(), searchResponse.getScrollId());  
import org.opensearch.client.core.MainResponse;
                "the third parameter to async method [" + method + "] is the wrong type",  
import org.opensearch.action.ActionRequestValidationException;
            // It's acceptable for 404s to be represented as empty Optionals  
            "Some client method doesn't match a corresponding API defined in the REST spec: " + apiNotFound,
                assertThat(
import org.opensearch.common.xcontent.cbor.CborXContent;
                response -> response.getStatusLine().getStatusCode(),
            assertEquals("OpenSearch didn't return the [Content-Type] header, unable to parse response body", ise.getMessage());
        restHighLevelClient.close();  
                method -> method.getDeclaringClass().equals(RestHighLevelClient.class)
        {
            5,
import org.apache.hc.core5.http.message.BasicClassicHttpResponse;  
                    parameterTypes[0],  
        TrackingActionListener trackingActionListener = new TrackingActionListener();  
            Integer counter = categories.putIfAbsent(namedXContent.categoryClass, 1);
                    "the second parameter to method [" + method + "] is the wrong type",
    public void testPerformRequestOnResponseExceptionWithIgnoresErrorNoBody() throws IOException {
            }
    public void testProvidedNamedXContents() {
        ResponseException responseException = new ResponseException(response);
                ioe.getMessage()
                    + restStatus.getStatus()
            for (Method method : entry.getValue()) {
        when(restClient.performRequest(any(Request.class))).thenThrow(responseException);
            trackingActionListener,
    public void testNullableActionListener() {
        {
            builder.startObject();  
 */
 * software distributed under the License is distributed on an
                "Unable to parse response body for Response{requestLine=GET / http/1.1, host=http://localhost:9200, "
            "indices.upgrade",
import java.io.IOException;  
import org.opensearch.core.action.ActionListener;
                mainRequest,  
            assertThat(trackingActionListener.exception.get(), instanceOf(OpenSearchException.class));
        // TODO remove in 8.0 - we will undeprecate indices.get_template because the current getIndexTemplate
            equalTo(0)  
        assertTrue("submit task method [" + method.getName() + "] doesn't have corresponding sync method", methods.containsKey(methodName));  
        assertTrue(
import org.opensearch.tools.jackson.core.JsonParseException;
            OpenSearchException.class,
        // looking like it doesn't have a valid implementatation when it does.
        assertFalse(restHighLevelClient.ping(RequestOptions.DEFAULT));
        assertThat("Some API are not supported but they should be: " + apiUnsupported, apiUnsupported.size(), equalTo(0));  
        );  
            assertThat(openSearchException.getSuppressed()[0], instanceOf(IllegalStateException.class));
        if (apiName.equals("ping") || apiName.contains("exist") || booleanReturnMethods.contains(apiName)) {
    public void testPingSuccessful() throws IOException {  
                response -> response.getStatusLine().getStatusCode(),
                assertThat(  
            ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(restStatus.getStatus(), restStatus.name());  
                response -> response.getStatusLine().getStatusCode(),
    }
import org.opensearch.action.search.SearchResponseSections;  
                );
            ),
    public void testWrapResponseListenerOnResponseExceptionWithEntity() throws IOException {  
            "cluster.get_weighted_routing",  
import java.net.SocketTimeoutException;  
            );
import org.opensearch.index.rankeval.PrecisionAtK;
            OpenSearchException openSearchException = restHighLevelClient.parseResponseException(responseException);  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.xcontent.ToXContentFragment;  
        }
        CheckedFunction<MainRequest, Request, IOException> requestConverter = request -> new Request(HttpGet.METHOD_NAME, "/");
            assertEquals("async method [" + method + "] has the wrong number of arguments", 3, method.getParameterCount());
        }
            Response response = new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse);
        List<String> booleanReturnMethods = Arrays.asList("security.enable_user", "security.disable_user", "security.change_password");
        StringBuilder snakeCaseString = new StringBuilder();
    public void testPingSocketTimeout() throws IOException {
            .map(method -> Tuple.tuple(toSnakeCase(method.getName()), method))
            IllegalStateException ise = expectThrows(IllegalStateException.class, () -> restHighLevelClient.parseEntity(entity, null));
import org.opensearch.search.aggregations.Aggregation;  
        return new StatusLine(HTTP_PROTOCOL, restStatus.getStatus(), restStatus.name());
                    apiUnsupported.remove(api)  
        );
        CheckedFunction<MainRequest, Request, IOException> requestConverter = request -> new Request(HttpGet.METHOD_NAME, "/");
        restClient = mock(RestClient.class);
        verify(restClient, times(2)).close();
            );  
import org.opensearch.index.rankeval.RecallAtK;  
        assertEquals(responseException.getMessage(), openSearchException.getMessage());
                RequestOptions.DEFAULT,  
        final Class<?>[] parameterTypes = method.getParameterTypes();
        Response mockResponse = new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse);
                mainRequest,
        assertEquals(responseException.getMessage(), openSearchException.getMessage());
        );
            0,
        MainRequest mainRequest = new MainRequest();
                api -> assertTrue(
        // The above general-purpose code ignores all deprecated methods which in this case leaves `getTemplate`  
import java.util.concurrent.atomic.AtomicInteger;
            assertSame(responseException, openSearchException.getCause());  
        }
                }, Collections.emptySet())  
            "render_search_template",
        ResponseListener responseListener = restHighLevelClient.wrapResponseListener(
        when(restClient.performRequest(any(Request.class))).thenReturn(mockResponse);
    private static final RequestLine REQUEST_LINE = new RequestLine(HttpGet.METHOD_NAME, "/", HTTP_PROTOCOL);  
            ResponseException responseException = new ResponseException(response);
                );
    }
        responseListener.onFailure(exception);
        RestStatus restStatus = randomFrom(RestStatus.values());
            ResponseListener responseListener = restHighLevelClient.wrapResponseListener(
            assertEquals(restStatus.getStatus(), result.intValue());
        }
    public void testSearchScroll() throws IOException {
        String[] notRequiredApi = new String[] {
                parameterTypes[2],
     * These APIs do not use a Request object (because they don't have a body, or any request parameters).  
    public void testPerformRequestOnResponseExceptionWithoutEntity() throws IOException {
        deprecatedMethods.add("indices.force_merge");  
        Map<String, Set<Method>> methods = Arrays.stream(RestHighLevelClient.class.getMethods())
            Integer counter = categories.putIfAbsent(namedXContent.categoryClass, 1);  
                                apiNotFound.add(apiName);
        );
        clearScrollRequest.addScrollId(randomAlphaOfLengthBetween(5, 10));
                .field("build_type", testInfo.getVersion().getBuildType())  
        when(response.getStatusLine()).thenReturn(newStatusLine(RestStatus.OK));
    }
            ShardSearchFailure.EMPTY_ARRAY,
        final Class<?>[] parameterTypes = method.getParameterTypes();
        assertEquals(Integer.valueOf(3), categories.get(Aggregation.class));  
        OpenSearchException openSearchException = expectThrows(
                    endsWith("Request")
            assertThat(openSearchException.getSuppressed()[0], instanceOf(IllegalStateException.class));
        int expectedSuggestions = 3;
            ResponseListener responseListener = restHighLevelClient.wrapResponseListener(
        assertEquals("OpenSearch exception [type=exception, reason=test error message]", openSearchException.getMessage());
            }
import java.util.Optional;
import org.opensearch.action.search.SearchResponse;
        Response response = mock(Response.class);
        MainRequest mainRequest = new MainRequest();
        };
    public void testWrapResponseListenerOnResponseExceptionWithIgnoresErrorNoBody() throws IOException {  
        }  
    }  
        responseListener.onFailure(responseException);
            assertThat("the parameter to method [" + method + "] is the wrong type", parameterTypes[0], equalTo(RequestOptions.class));  
                .field("number", testInfo.getVersion().getNumber())
            "the second parameter to submit task method [" + method + "] is the wrong type",
    public void testWrapResponseListenerOnResponseExceptionWithoutEntity() throws IOException {
        ResponseException responseException = new ResponseException(mockResponse);
        // although we got an exception, we turn it into a successful response because the status code was provided among ignores
import java.lang.reflect.Modifier;
    private static String toSnakeCase(String camelCase) {  
            "remote_store.restore",  
            100,  
    }
    }  
 * this work for additional information regarding copyright
import org.apache.hc.core5.http.HttpEntity;
        assertTrue(names.contains(RecallAtK.NAME));
        {
    public void testPerformRequestOnResponseExceptionWithIgnoresErrorValidBody() throws IOException {
        assertSame(responseException, openSearchException.getCause());  
        Set<String> topLevelMethodsExclusions = new HashSet<>();
        // response parsing throws exception while handling ignores. same as when GetResponse#fromXContent throws error when trying
        assertEquals("Had: " + categories, 3, categories.size());
            OpenSearchException openSearchException = (OpenSearchException) trackingActionListener.exception.get();
        Map<Class<?>, Integer> categories = new HashMap<>();
        OpenSearchException openSearchException = expectThrows(
        Response response = new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse);  
            "cluster.get_decommission_awareness",  
        assertSame(responseException, openSearchException.getCause());  
        }  
        responseListener.onFailure(responseException);  
                ActionRequestValidationException.class,
            response -> { throw new IllegalStateException(); },
        }
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.test.InternalAggregationTestCase;
            Matchers.hasKey("wait_for_completion")
            responseListener.onSuccess(new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse));  
                    parameterTypes[1],
            Collections.singleton(404)
            "cluster.stats",  
        } else {
                );
            if (Character.isUpperCase(aChar)) {  
                    assertAsyncMethod(methods, method, apiName);
        when(restClient.performRequest(any(Request.class))).thenReturn(response);  
    private RestHighLevelClient restHighLevelClient;
        responseListener.onFailure(responseException);  
            () -> restHighLevelClient.performRequest(  
        Response response = new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse);
        OpenSearchException openSearchException = expectThrows(  
import static org.hamcrest.CoreMatchers.instanceOf;  
        assertSame(responseException, openSearchException.getCause());
            "indices.get_upgrade",
                assertThat(
 * The OpenSearch Contributors require contributions made to  
        assertEquals(restStatus == RestStatus.OK, result);  
        // These API are not required for high-level client feature completeness  
        when(response.getStatusLine()).thenReturn(newStatusLine(RestStatus.NOT_FOUND));  
        ResponseException responseException = new ResponseException(mockResponse);
import org.opensearch.search.suggest.Suggest;  
    }
            "submit task method [" + method + "] must have wait_for_completion parameter in rest spec",
                            );  
            methods.containsKey(apiName.substring(0, apiName.length() - 6))  
import org.apache.hc.core5.http.ContentType;  
/*  
            assertEquals("Unable to parse response body", openSearchException.getMessage());
                            if (// IndicesClientIT.getIndexTemplate should be renamed "getTemplate" in version 8.0 when we
            ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(restStatus.getStatus(), restStatus.name());
                requestConverter,
                response -> response.getStatusLine().getStatusCode(),  
        );  
        RestStatus restStatus = randomFrom(RestStatus.values());
        ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(restStatus.getStatus(), restStatus.name());
    }
        Response mockResponse = new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse);  
        assertEquals(mockClearScrollResponse.isSucceeded(), clearScrollResponse.isSucceeded());
        assertEquals(expectedSuggestions, categories.get(Suggest.Suggestion.class).intValue());
                    parameterTypes[0].getSimpleName(),  
        assertEquals(RestStatus.NOT_FOUND, openSearchException.status());
                snakeCaseString.append(aChar);
        "security.get_user_privileges",
                );  
                    "the first parameter to method [" + method + "] is the wrong type",
        assertEquals(5, searchResponse.getSuccessfulShards());  
    private void mockResponse(ToXContent toXContent) throws IOException {
            "cluster.state",
            response -> response.getStatusLine().getStatusCode(),  
            OpenSearchException.class,
            "ingest.processor_grok",
        assertThat(
    }  
        MainResponse testInfo = new MainResponse(
            assertEquals(
            new StringEntity("{\"error\":\"test error message\",\"status\":" + restStatus.getStatus() + "}", ContentType.APPLICATION_JSON)
import org.opensearch.index.rankeval.ExpectedReciprocalRank;
                Collections.emptySet()
            TrackingActionListener trackingActionListener = new TrackingActionListener();
        RestStatus restStatus = randomFrom(RestStatus.values());  
        OpenSearchException openSearchException = (OpenSearchException) trackingActionListener.exception.get();  
            assertThat(parameterTypes[1], equalTo(ActionListener.class));
        OpenSearchException openSearchException = expectThrows(  
        Response response = new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse);
                assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
            )  
        final Class<?>[] parameterTypes = method.getParameterTypes();
                    equalTo(RequestOptions.class)
    @Before  
            "create",
            "cluster.put_decommission_awareness",
            assertSame(responseException, openSearchException.getCause());  
import static org.mockito.Mockito.times;  
            responseListener.onFailure(responseException);
            "get_script_context",  
    }  
            httpResponse.setEntity(
            assertEquals("Unsupported Content-Type: " + entity.getContentType(), ise.getMessage());  
        assertEquals(restStatus, openSearchException.status());  
                    : Stream.of(tuple)
            OpenSearchException.class,
        for (NamedXContentRegistry.Entry namedXContent : namedXContents) {
        ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(restStatus.getStatus(), restStatus.name());  
            Response response = new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse);
            }
                IOException.class,  
        }
    public void testConvertExistsResponse() {
                requestConverter,
        assertThat(trackingActionListener.exception.get(), instanceOf(OpenSearchException.class));  
        {  
                () -> restHighLevelClient.performRequest(mainRequest, requestConverter, RequestOptions.DEFAULT, response -> {
            );
import org.opensearch.core.xcontent.XContentBuilder;
                    && topLevelMethodsExclusions.contains(method.getName()) == false
            );  
 * this file be licensed under the Apache-2.0 license or a
    }
        // to parse a 404 response which contains an error rather than a valid document not found response.  
        ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(RestStatus.NOT_FOUND.getStatus(), RestStatus.NOT_FOUND.name());
        ResponseListener responseListener = restHighLevelClient.wrapResponseListener(
            "cluster.delete_voting_config_exclusions",
    public void testPerformRequestOnResponseExceptionWithBrokenEntity() throws IOException {  
            restHighLevelClient.performRequest(  
            "indices.simulate_template",  
    }
            ResponseException responseException = new ResponseException(response);
import org.opensearch.action.ActionRequest;
        );
            OpenSearchException openSearchException = (OpenSearchException) trackingActionListener.exception.get();  
        ResponseException responseException = new ResponseException(mockResponse);
            assertThat(openSearchException.getSuppressed()[0], instanceOf(JsonParseException.class));
import org.opensearch.index.rankeval.MeanReciprocalRank;  
            ResponseException responseException = new ResponseException(response);
                "buildType",  
            @Override  
            Integer result = restHighLevelClient.performRequest(
        assertTrue(names.contains(MeanReciprocalRank.NAME));  
                    parameterTypes[1],
            Response response = new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse);
            HttpEntity yamlEntity = new StringEntity("---\nfield: value\n", ContentType.create("application/yaml"));
                ioe.getMessage()  
                mainRequest,  
public class RestHighLevelClientTests extends OpenSearchTestCase {
    }
        // although we got an exception, we turn it into a successful response because the status code was provided among ignores  
            assertEquals("value", restHighLevelClient.parseEntity(cborEntity, entityParser));  
        @Override
        httpResponse.setEntity(new StringEntity("{\"error\":\"test error message\",\"status\":404}", ContentType.APPLICATION_JSON));
        "ping",  
                )
            ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(restStatus.getStatus(), restStatus.name());
        when(restClient.performRequest(any(Request.class))).thenThrow(responseException);
import org.opensearch.common.xcontent.smile.SmileXContent;  
        restHighLevelClient.close();
                    endsWith("Request")
        httpResponse.setEntity(new StringEntity("{\"error\":\"test error message\",\"status\":404}", ContentType.APPLICATION_JSON));  
                    + restStatus.getStatus()
                trackingActionListener,
        assertEquals("Unable to parse response body", openSearchException.getMessage());
        );
        when(restClient.performRequest(any(Request.class))).thenThrow(responseException);  
import org.opensearch.client.core.MainRequest;  
import org.apache.hc.client5.http.classic.methods.HttpGet;
            assertEquals("OpenSearch exception [type=exception, reason=test error message]", openSearchException.getMessage());
            "scripts_painless_execute",
        assertEquals(restStatus, openSearchException.status());
    }  
            assertEquals("Response body expected but not returned", ise.getMessage());  
        {
        }
        TrackingActionListener trackingActionListener = new TrackingActionListener();  
            "indices.put_alias",  
                    "the first parameter to async method [" + method + "] should be a request type",
        TrackingActionListener trackingActionListener = new TrackingActionListener();  
            assertEquals(
        assertTrue(restHighLevelClient.ping(RequestOptions.DEFAULT));
import java.util.concurrent.atomic.AtomicReference;
            assertEquals("incorrect number of arguments for method [" + method + "]", 1, method.getParameterCount());
        Map<Class<?>, Integer> categories = new HashMap<>();
            builder.startObject("version")
        ResponseException responseException = new ResponseException(response);
                equalTo("boolean")  
                    "the second parameter to async method [" + method + "] is the wrong type",
    public void testRequestValidation() {
                Collections.emptySet()
    public void testDefaultNamedXContents() {
    }
            assertEquals("Unable to parse response body", openSearchException.getMessage());
import org.opensearch.action.search.ClearScrollResponse;
            restSpec.getApi(methodName).getParams(),  
    }  
            .filter(tuple -> tuple.v2().getAnnotation(Deprecated.class) == null)
                );
        deprecatedMethods.add("multi_get");
                    "method [" + apiName + "] is not final",  
import java.util.stream.Stream;
        }
        ResponseException responseException = new ResponseException(mockResponse);
        boolean result = RestHighLevelClient.convertExistsResponse(response);
    public void testParseEntity() throws IOException {  
        assertThat(
                    "the first parameter to method [" + method + "] is the wrong type",  
            assertThat(
            "nodeName",  
            "indices.recovery",
                        } else {
            "indices.shard_stores",  
                Collections.singleton(404)
                response -> response.getStatusLine().getStatusCode(),  
        OpenSearchException openSearchException = (OpenSearchException) trackingActionListener.exception.get();
        CheckedFunction<MainRequest, Request, IOException> requestConverter = request -> new Request(HttpGet.METHOD_NAME, "/");  
            )  
            randomAlphaOfLengthBetween(5, 10),
        ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(restStatus.getStatus(), restStatus.name());  
                assertThat(  
            builder.endObject();
        ActionRequest request = new ActionRequest() {
            OpenSearchException.class,
                );
            ResponseException responseException = new ResponseException(response);  
        ResponseListener responseListener = restHighLevelClient.wrapResponseListener(
            ResponseListener responseListener = restHighLevelClient.wrapResponseListener(  
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertThat(trackingActionListener.exception.get(), instanceOf(IOException.class));
        mockResponse(mockClearScrollResponse);  
            assertEquals("value", restHighLevelClient.parseEntity(smileEntity, entityParser));
            }
                );  
        "security.get_builtin_privileges",
        CheckedFunction<MainRequest, Request, IOException> requestConverter = request -> new Request(HttpGet.METHOD_NAME, "/");  
        when(restClient.performRequest(any(Request.class))).thenThrow(responseException);
            "cluster.delete_weighted_routing",
            parameterTypes[0].getSimpleName(),
            );
            String apiName = entry.getKey();
                "luceneVersion",
            IllegalStateException ise = expectThrows(IllegalStateException.class, () -> restHighLevelClient.parseEntity(null, null));
            "clusterUuid"  
        Response response = new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse);
            assertEquals(restStatus, openSearchException.status());
                "buildHash",
            );
            Collections.singleton(404)
        ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(restStatus.getStatus(), restStatus.name());
                requestConverter,
        ResponseException responseException = new ResponseException(mockResponse);  
import java.util.stream.Collectors;  
        "delete_all_pits",
        }
    }
            );  
                assertTrue(parser.nextToken().isValue());  
        ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(restStatus.getStatus(), restStatus.name());
            assertTrue(exception.compareAndSet(null, e));  
        MainRequest mainRequest = new MainRequest();  
    public void testPerformRequestOnResponseExceptionWithBrokenEntity2() throws IOException {
        }
        List<String> names = new ArrayList<>();  
            "cluster.delete_decommission_awareness",
 * not use this file except in compliance with the License.
        assertEquals(restStatus, openSearchException.status());
            () -> restHighLevelClient.performRequest(  
            RestStatus restStatus = randomFrom(RestStatus.values());  
                RequestOptions.DEFAULT,  
            "search_shards",
        ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(RestStatus.NOT_FOUND.getStatus(), RestStatus.NOT_FOUND.name());
            );  
     * (This is also used for async variants of these APIs when they exist)
        assertThat(trackingActionListener.exception.get(), instanceOf(OpenSearchException.class));
        apiUnsupported.removeIf(api -> api.startsWith("cat."));
            "indices.segments",  
        List<NamedXContentRegistry.Entry> namedXContents = RestHighLevelClient.getDefaultNamedXContents();  
                trackingActionListener,
                response -> response.getStatusLine().getStatusCode(),
        assertEquals("async method [" + method + "] should not throw any exceptions", 0, method.getExceptionTypes().length);  
            () -> restHighLevelClient.performRequestAsync(request, null, RequestOptions.DEFAULT, null, null, null)
        ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(RestStatus.NOT_FOUND.getStatus(), RestStatus.NOT_FOUND.name());  
            restHighLevelClient.performRequestAsync(request, null, RequestOptions.DEFAULT, null, trackingActionListener, null);
            "cluster.post_voting_config_exclusions",
                    }
            () -> restHighLevelClient.performRequest(mainRequest, requestConverter, RequestOptions.DEFAULT, response -> {
        }
                .field("lucene_version", testInfo.getVersion().getLuceneVersion())
            assertEquals(2, parameterTypes.length);  
        ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(RestStatus.NOT_FOUND.getStatus(), RestStatus.NOT_FOUND.name());  
                "Unable to parse response body for Response{requestLine=GET / http/1.1, host=http://localhost:9200, "  
        "license.get_trial_status",
            "get_script_languages",
        } else {
        String[] notYetSupportedApi = new String[] {
            .flatMap(
                RequestOptions.DEFAULT,
        Response mockResponse = new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse);  
                    + " "  
            new StringEntity("{\"error\":\"test error message\",\"status\":" + restStatus.getStatus() + "}", ContentType.APPLICATION_JSON)
        assertSame(responseException, openSearchException.getSuppressed()[0]);
            assertEquals(restStatus.getStatus(), trackingActionListener.statusCode.get());
                                // can get rid of 7.0's deprecated "getTemplate"  
import java.util.HashSet;
            RestStatus restStatus = randomFrom(RestStatus.values());
                return validationException;
/*
                    : Stream.of(tuple)
            );
        ActionRequestValidationException validationException = new ActionRequestValidationException();
        String apiName,
                assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
        topLevelMethodsExclusions.add("close");  
        OpenSearchException openSearchException = (OpenSearchException) trackingActionListener.exception.get();
    private RestClient restClient;  
     */  
                            }  
        assertSame(responseException, openSearchException.getCause());
            assertEquals("Unable to parse response body", openSearchException.getMessage());
        assertEquals(100, searchResponse.getTook().getMillis());
        SearchResponse mockSearchResponse = new SearchResponse(  
        assertEquals(restStatus, openSearchException.status());  
        });  
 * SPDX-License-Identifier: Apache-2.0
        public void onResponse(Integer statusCode) {  
    }  
        validationException.addValidationError("validation error");  
            TrackingActionListener trackingActionListener = new TrackingActionListener();
                    + " "
                IllegalStateException.class,
        ContentType contentType = ContentType.parse(RequestConverters.REQUEST_BODY_CONTENT_TYPE.mediaType());
        restHighLevelClient.close();
        OpenSearchException openSearchException = expectThrows(
            assertEquals("incorrect number of arguments for method [" + method + "]", 2, method.getParameterCount());
        TrackingActionListener trackingActionListener = new TrackingActionListener();
        "license.get_basic_status"
            return builder;
            "dangling_indices.delete_dangling_index",  
        ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(RestStatus.NOT_FOUND.getStatus(), RestStatus.NOT_FOUND.name());
            parameterTypes[1],  
                // we convert all the method names to snake case, hence we need to look for the '_async' suffix rather than 'Async'
        }
        @Override
            RestStatus restStatus = randomFrom(RestStatus.values());
            Collections.singleton(404)  
            HttpEntity cborEntity = createBinaryEntity(CborXContent.contentBuilder(), ContentType.create("application/cbor"));
        }  
    }
        when(response.getEntity()).thenReturn(new StringEntity(requestBody, contentType));  
        Response mockResponse = new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse);
    }  
        {
                        }
        ClearScrollResponse mockClearScrollResponse = new ClearScrollResponse(randomBoolean(), randomIntBetween(0, Integer.MAX_VALUE));
        );
            OpenSearchException.class,
                RequestOptions.DEFAULT,
                categories.put(namedXContent.categoryClass, counter + 1);  
            () -> restHighLevelClient.performRequest(
            "clusterName",
    private static void assertAsyncMethod(Map<String, Set<Method>> methods, Method method, String apiName) {  
    }
            assertEquals("Unable to parse response body", openSearchException.getMessage());
        String requestBody = toXContent(toXContent, RequestConverters.REQUEST_BODY_CONTENT_TYPE, false).utf8ToString();
            if (counter != null) {
        mockResponse(mockSearchResponse);
            response -> response.getStatusLine().getStatusCode(),
        {  
        );
    }  
        CheckedFunction<MainRequest, Request, IOException> requestConverter = request -> new Request(HttpGet.METHOD_NAME, "/");  
        );
import org.opensearch.test.rest.yaml.restspec.ClientYamlSuiteRestApi;  
        assertTrue(names.contains(PrecisionAtK.NAME));
import org.junit.Before;
        );
        Response mockResponse = new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse);
import org.apache.hc.core5.http.HttpHost;
import org.hamcrest.Matchers;  
        assertEquals(expectedInternalAggregations + expectedSuggestions, namedXContents.size());
            public ActionRequestValidationException validate() {  
        assertEquals(responseException.getMessage(), openSearchException.getMessage());
        assertEquals(0, searchResponse.getHits().getTotalHits().value());
    }
                    api + " API is either not defined in the spec or already supported by the high-level client",
        ClientYamlSuiteRestSpec restSpec = ClientYamlSuiteRestSpec.load("/rest-api-spec/api");
        verify(restClient, times(3)).close();  
        Stream.concat(Arrays.stream(notYetSupportedApi), Arrays.stream(notRequiredApi))
            builder.field("field", "value");
                Collections.emptySet()  
                .field("build_hash", testInfo.getVersion().getBuildHash())
        public void onFailure(Exception e) {
            assertEquals(restStatus, openSearchException.status());
            }
        CheckedFunction<MainRequest, Request, IOException> requestConverter = request -> new Request(HttpGet.METHOD_NAME, "/");
            "the first parameter to submit task method [" + method + "] is the wrong type",  
                .field("build_snapshot", testInfo.getVersion().isSnapshot())  
import java.util.List;  
                    endsWith("Request")  
        // this list should be empty once the high-level client is feature complete  
                response -> response.getStatusLine().getStatusCode(),
        IllegalStateException exception = new IllegalStateException();  
        {  
            .collect(Collectors.groupingBy(Tuple::v1, Collectors.mapping(Tuple::v2, Collectors.toSet())));
        ActionRequest request = new ActionRequest() {
        for (NamedXContentRegistry.Entry namedXContent : namedXContents) {  
        when(restClient.performRequest(any(Request.class))).thenThrow(responseException);
            assertEquals("value", restHighLevelClient.parseEntity(jsonEntity, entityParser));  
        ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(restStatus.getStatus(), restStatus.name());
            );
package org.opensearch.client;
        assertEquals(expectedInternalAggregations, categories.get(Aggregation.class).intValue());
        assertNull(trackingActionListener.exception.get());
            // taken from the server side MainResponse  
        {  
        }  
            OpenSearchException openSearchException = restHighLevelClient.parseResponseException(responseException);  
        httpResponse.setEntity(new StringEntity("{\"error\":", ContentType.APPLICATION_JSON));
        // Synced flush is deprecated
        ResponseListener responseListener = restHighLevelClient.wrapResponseListener(
import org.opensearch.action.search.ShardSearchFailure;
            Collections.emptySet()
    }  
import org.opensearch.common.util.set.Sets;
                .endObject();
    }
    }  
            response -> { throw new IllegalStateException(); },
        deprecatedMethods.add("search_scroll");  
        ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(restStatus.getStatus(), restStatus.name());  
        {
import org.opensearch.core.xcontent.XContentParser;
            OpenSearchException openSearchException = restHighLevelClient.parseResponseException(responseException);  
                    + restStatus.name()
    public void testWrapResponseListenerOnException() {
        assertSame(responseException, openSearchException.getSuppressed()[0]);
        assertEquals(mockClearScrollResponse.getNumFreed(), clearScrollResponse.getNumFreed());
        assertThat(
        assertTrue(names.contains(RecallAtK.NAME));
        assertSame(responseException, openSearchException.getCause());  
        Set<String> deprecatedMethods = new HashSet<>();
import java.util.Set;  
    }
 * You may obtain a copy of the License at  
        assertThat(trackingActionListener.exception.get(), instanceOf(OpenSearchException.class));
            "async method [" + method.getName() + "] doesn't have corresponding sync method",
        {
import org.apache.hc.core5.http.message.RequestLine;
                );
                    endsWith("Response")
        // security
        when(restClient.performRequest(any(Request.class))).thenThrow(responseException);  
            "indices.add_block" };
            // This is no longer true for all methods. Some methods can contain these 2 args backwards because of deprecation  
            @Override
 * KIND, either express or implied.  See the License for the
            Integer.valueOf(404),
                Collections.emptySet()
    }
    }  
            RestStatus restStatus = randomFrom(RestStatus.values());
        // core
        Response response = new Response(REQUEST_LINE, new HttpHost("localhost", 9200), httpResponse);
            assertSame(validationException, trackingActionListener.exception.get());  
    );
        SearchResponse searchResponse = restHighLevelClient.scroll(
            trackingActionListener,  
                                "method [" + method.getName() + "], api [" + apiName + "] should be deprecated",
                    ? getSubClientMethods(tuple.v1(), tuple.v2().getReturnType())
                        if (deprecatedMethods.contains(apiName)) {
        // response parsing throws exception while handling ignores. same as when GetResponse#fromXContent throws error when trying
            httpResponse.setEntity(new StringEntity("{\"status\":" + restStatus.getStatus() + "}", ContentType.APPLICATION_JSON));  
        OpenSearchException openSearchException = (OpenSearchException) trackingActionListener.exception.get();
        // license  
        TrackingActionListener trackingActionListener = new TrackingActionListener();
    ) {  
        "security.authenticate",  
                assertTrue(
import java.util.Map;
            names.add(namedXContent.name.getPreferredName());
        ClientYamlSuiteRestSpec restSpec
import org.opensearch.join.aggregations.ChildrenAggregationBuilder;
            assertEquals(responseException.getMessage(), openSearchException.getMessage());
                method.getReturnType().getSimpleName(),
        ClearScrollRequest clearScrollRequest = new ClearScrollRequest();
            ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(restStatus.getStatus(), restStatus.name());  
import org.opensearch.core.xcontent.NamedXContentRegistry;
        assertTrue(names.contains(ChildrenAggregationBuilder.NAME));
 * compatible open source license.
        {  
        assertEquals(RestStatus.NOT_FOUND, openSearchException.status());  
                Collections.emptySet()
            ResponseException responseException = new ResponseException(response);  
            "dangling_indices.import_dangling_index",
            )  
        CheckedFunction<MainRequest, Request, IOException> requestConverter = request -> new Request(HttpGet.METHOD_NAME, "/");
        ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(restStatus.getStatus(), restStatus.name());
            if (parameterTypes[0].equals(RequestOptions.class)) {  
