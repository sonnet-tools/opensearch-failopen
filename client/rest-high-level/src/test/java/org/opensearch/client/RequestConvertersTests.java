        String[] indices = randomIndicesNames(0, 5);
                return searchSourceBuilder;
    public void testMultiGet() throws IOException {
        searchTemplateRequest.setProfile(randomBoolean());
        MediaType mediaType = randomFrom(MediaTypeRegistry.JSON, XContentType.SMILE);
        assertEquals(expectedParams, request.getParameters());
        for (int i = 0; i < numSearchRequests; i++) {
        assertEquals(expectedParams, request.getParameters());
        String id = randomAlphaOfLengthBetween(5, 10);
            String timeout = randomTimeValue();
                    randomizeFetchSourceContextParams(updateRequest::fetchSource, new HashMap<>());
                    randomlyGenerated.expandWildcardsClosed(),
            indices[i] = "index-" + randomAlphaOfLengthBetween(2, 5).toLowerCase(Locale.ROOT);
        StringJoiner endpoint = new StringJoiner("/", "/", "");
        assertEquals(HttpGet.METHOD_NAME, request.getMethod());
            tvRequest.setRouting(routing);
        {
    }
        SearchScrollRequest searchScrollRequest = new SearchScrollRequest();
            long version = randomFrom(Versions.MATCH_ANY, Versions.MATCH_DELETED, Versions.NOT_FOUND, randomNonNegativeLong());
        if (frequently()) {
                    randomBoolean()
        assertEquals(0, request.getParameters().size());
        int numberOfRequests = randomIntBetween(0, 32);
        assertEquals(HttpPost.METHOD_NAME, request.getMethod());
import org.apache.hc.client5.http.classic.methods.HttpPost;
            setRandomVersion(indexRequest, expectedParams);
                "Unsupported content-type found for request with content-type [" + xContentType + "], only JSON and SMILE are supported",
            if (searchSourceBuilder.equals(new SearchSourceBuilder()) == false) {
        }
            assertEquals("/index/type/this%2Fis%2Fthe%2Fid", endpointBuilder.build());
        if (randomBoolean()) {
        for (Tuple<String, Supplier<Request>> variant : variants) {
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;
            "Mismatching content-type found for request with content-type ["
        } else {
        }
            multiGetRequest.realtime(randomBoolean());
        try (XContentBuilder builder = XContentBuilder.builder(xContentType.xContent())) {
        {
        {
                    msearchDefault.forbidClosedIndices(),
                "Mismatching content-type found for request with content-type [JSON], " + "previous requests have content-type [SMILE]",
        } else if (indicesOptions.expandWildcardsOpen()) {
                expectedParams.put("local", String.valueOf(local));
            bulkRequest.add(
            RemoteInfo remoteInfo = new RemoteInfo(
        assertEquals(mediaType, enforceSameContentType(indexRequest, null));
        assertEquals(0, request.getParameters().size());
            int batchSize = randomInt(100);
            expectedParams.put("routing", routing);
    static void setRandomClusterManagerTimeout(Consumer<TimeValue> setter, TimeValue defaultTimeout, Map<String, String> expectedParams) {
                    msearchDefault.ignoreThrottled()
    public void testFieldCaps() throws IOException {
            getRequest.routing(routing);
            expectedParams.put("timeout", timeout);
            String routing = randomAlphaOfLengthBetween(3, 10);
import org.opensearch.common.xcontent.json.JsonXContent;
        Exception e = expectThrows(NullPointerException.class, () -> new RethrottleRequest(null, 1.0f));
        String index = randomAlphaOfLengthBetween(3, 10);
        String index = randomAlphaOfLengthBetween(3, 10);
        if (randomBoolean()) {
                IndicesOptions.fromOptions(
        {
                item.routing(randomAlphaOfLength(4));
        {
                waitForActiveShardsString = "all";
    }
            new PrecisionAtK()
        assertEquals(indexRequest.getContentType().mediaTypeWithoutParameters(), entity.getContentType());
        assertEquals("requestsPerSecond needs to be positive value but was [-5.0]", e.getMessage());
            if (refreshPolicy != WriteRequest.RefreshPolicy.NONE) {
        String id = randomAlphaOfLengthBetween(3, 10);
        String[] indices = new String[numIndices];
    public void testDeleteScriptRequest() {
        if (getter.get().expandWildcardsOpen() && getter.get().expandWildcardsClosed()) {
import java.util.Map;
        assertToXContentBody(spec, request.getEntity());
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("/foo@bar");
            expectedParams.put("stored_fields", storedFieldsParams);
        StringJoiner endpoint = new StringJoiner("/", "/", "");
        // rarely skip setting the search source completely
            }
            }
            IndicesOptions randomlyGenerated = searchRequest.indicesOptions();
    }
        }
    }
                UpdateRequest updateRequest = (UpdateRequest) originalRequest;
        String method = HttpPost.METHOD_NAME;
        SearchTemplateRequest searchTemplateRequest = new SearchTemplateRequest();
        if (!joinedIndices.isEmpty()) {
            setter.accept(includeDefaults);
        }
            expectedParams.put("min_score", String.valueOf(countRequest.minScore()));
            assertEquals(originalRequest.ifPrimaryTerm(), parsedRequest.ifPrimaryTerm());
            mtvRequest.add(tvRequest);
        }
import org.opensearch.action.support.WriteRequest;
    private static void setRandomVersionType(Consumer<VersionType> setter, Map<String, String> expectedParams) {
        doTestGetSource((index, id) -> new GetSourceRequest(index, id));
    public void testExplain() throws IOException {
                "remote-host",
        assertEquals("/_msearch/template", multiRequest.getEndpoint());
        ExplainRequest explainRequest = new ExplainRequest(index, id);
        endpoint.add(searchEndpoint);
                    indexRequest.setPipeline(randomAlphaOfLength(5));
        Request request = RequestConverters.delete(deleteRequest);
 * GitHub history for details.
                randomBoolean(),
                UpdateRequest parsedUpdateRequest = (UpdateRequest) parsedRequest;
        assertThat(request.getEndpoint(), equalTo("/test_index/_analyze"));
import org.opensearch.action.search.SearchType;
        expectedParams.put(RestSearchAction.TYPED_KEYS_PARAM, "true");
        }
            updateByQueryRequest.setSlices(slices);
                if (randomBoolean()) {
            updateRequest.routing(routing);
        String[] indices = randomIndicesNames(0, 5);
import org.opensearch.common.io.Streams;
        searchTemplateRequest.setScriptParams(scriptParams);
        expectedParams.put("group_by", "none");
            expectedParams.put("routing", routing);
            MultiGetRequest.Item item = new MultiGetRequest.Item(randomAlphaOfLength(4), randomAlphaOfLength(4));
            );
    }
                if (fetchSource == false) {
            String routing = randomAlphaOfLengthBetween(3, 10);
        }
    }
        if (randomBoolean()) {
        if (randomBoolean()) {
        String index = String.join(",", indices);
        FieldCapabilitiesRequest fieldCapabilitiesRequest = new FieldCapabilitiesRequest().indices(indices).fields(fields);
        scriptParams.put("value", "soren");
        assertEquals("/_reindex", request.getEndpoint());
        assertEquals("/" + searchEndpoint, request.getEndpoint());
            SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(p, false);
        if (randomBoolean()) {
     * Randomize the {@link FetchSourceContext} request parameters.
        {
                    randomlyGenerated.allowNoIndices(),
            }
        if (randomBoolean()) {
        } else {
        setRandomVersion(deleteRequest, expectedParams);
            String ts = randomTimeValue();
    }
            if (includeDefaults) {
    public void testEndpointBuilder() {
public class RequestConvertersTests extends OpenSearchTestCase {
            assertEquals(nbFields, parser.map().size());
                }
 */
            assertEquals(MediaTypeRegistry.JSON.mediaTypeWithoutParameters(), request.getEntity().getContentType());
        assertToXContentBody(createPitRequest, request.getEntity());
        StringJoiner endpoint = new StringJoiner("/", "/", "");
            }
            tvRequest.setRealtime(false);
        }
        }
                if (numIncludes > 0) {
        }
            "/index1,index2/type1,type2/_endpoint",
            expectedParams.put("expand_wildcards", "open,closed");
            expectedParams.put("requests_per_second", Float.toString(requestsPerSecond));
            assertEquals("/foo%2Fbar", endpointBuilder.build());
            bulkRequest.add(new IndexRequest("index").id("4").source(singletonMap("field", "value"), MediaTypeRegistry.JSON));
        assertEquals("/_count", request.getEndpoint());
import org.apache.hc.core5.http.io.entity.EntityUtils;
        assertEquals("taskId cannot be null", e.getMessage());
        Request request = RequestConverters.bulk(bulkRequest);
        }
            }
            true,
            if (randomBoolean()) {
        } else {
            expectedParams.put("realtime", "false");
        } else {
    public void testBulkWithDifferentContentTypes() throws IOException {
            expectedParams.put(RethrottleRequest.REQUEST_PER_SECOND_PARAMETER, Float.toString(requestsPerSecond));
    public void testSearch() throws Exception {
        reindexRequest.setSourceIndices("source_idx");
        assertEquals(expectedParams, request.getParameters());
            boolean realtime = randomBoolean();
            );
            multiSearchRequest.add(searchRequest);
            deleteByQueryRequest.setAbortOnVersionConflict(false);
 * license agreements. See the NOTICE file distributed with
            bulkRequest.add(new IndexRequest("index").id("1").source(singletonMap("field", "value"), MediaTypeRegistry.JSON));
import static org.opensearch.search.RandomSearchRequestGenerator.randomSearchRequest;
            defaultTimeout,
        String[] fields = generateRandomStringArray(5, 10, false, false);
            expectedParams.put("preference", countRequest.preference());
                    randomlyGenerated.expandWildcardsOpen(),
            }
import org.opensearch.common.logging.DeprecationLogger;
import org.opensearch.script.Script;
            String preference = randomAlphaOfLength(4);
                if (updateRequest.doc() != null) {
        }
    public static SearchSourceBuilder createTestSearchSourceBuilder() {
                String routing = randomAlphaOfLengthBetween(3, 10);
            null,
            Map<String, Object> scriptParams = new HashMap<>();
import org.opensearch.core.xcontent.ToXContent;
        String index = randomAlphaOfLengthBetween(3, 10);
        if (randomBoolean()) {
        setRandomIndicesOptions(countRequest::indicesOptions, countRequest::indicesOptions, expectedParams);
            String id = randomAlphaOfLengthBetween(3, 10);
import java.util.function.Consumer;
        }
        Request request = RequestConverters.deleteAllPits();
        }
    }
        List<SearchTemplateRequest> searchRequests = multiSearchTemplateRequest.requests();
                String[] excludes = new String[numExcludes];
            excludesParam.append(exclude);
            assertEquals(originalRequest.version(), parsedRequest.version());
    private static void doTestSourceExists(BiFunction<String, String, GetSourceRequest> requestFunction) throws IOException {
                expectedParams.put("refresh", "true");
        bulkRequest.add(new IndexRequest("test").id("11").source(MediaTypeRegistry.JSON, "field", "bulk1"));
            DocWriteRequest<?> parsedRequest = parsedBulkRequest.requests().get(i);
        );
            RequestConverters.endpoint(new String[] { "index1", "index2" }, new String[] { "type1", "type2" }, "_endpoint")
    public void testUpdateByQuery() throws IOException {
            expectedParams.put("expand_wildcards", "none");
            getRequest.refresh(refresh);
                expectedParams.put("slices", Integer.toString(slices));
            explainRequest.storedFields(storedFields);
            updateRequest.doc(new IndexRequest().source(source, xContentType));
import org.opensearch.test.OpenSearchTestCase;
        String[] requestFields = Strings.splitStringByCommaToArray(request.getParameters().get("fields"));
            } else {
            expectedParams.put("conflicts", "proceed");
        int numberOfSearchRequests = randomIntBetween(0, 32);
            if (randomBoolean()) {
        }
            expectedParams.put("expand_wildcards", "open");
        }
                }
        assertEquals(5, request.getParameters().size());
    }
            updateRequest.scriptedUpsert(randomBoolean());
            setter.accept(timeout);
            searchRequest.setPreFilterShardSize(randomIntBetween(2, Integer.MAX_VALUE));
    public void testGetScriptRequest() {
                if (randomBoolean()) {
        assertEquals("/_search/scroll", request.getEndpoint());
        // a hash set before being added to the request, and can appear in a
            if (opType == DocWriteRequest.OpType.INDEX) {
    static IndicesOptions setRandomIndicesOptions(IndicesOptions indicesOptions, Map<String, String> expectedParams) {
            searchRequest.requestCache(randomBoolean());
        if (randomBoolean()) {
        setRandomWaitForActiveShards(updateRequest::waitForActiveShards, expectedParams);
        if (randomBoolean()) {
        variants.add(new Tuple<String, Supplier<Request>>("_reindex", () -> RequestConverters.rethrottleReindex(rethrottleRequest)));
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("/part1").addPathPart("//part2").addPathPart("///part3");
import static java.util.Collections.singletonMap;
        Request request = RequestConverters.deleteScript(deleteStoredScriptRequest);
        assertEquals(HttpPost.METHOD_NAME, request.getMethod());
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("中文");
            boolean refresh = randomBoolean();
                String pipeline = randomAlphaOfLengthBetween(3, 10);
        assertEquals(expectedParams, request.getParameters());
import org.opensearch.action.search.SearchRequest;
                if (randomBoolean()) {
            consumer,
import org.opensearch.action.explain.ExplainRequest;
                expectedParams.put("slices", Integer.toString(slices));
        // non-deterministic order.
import org.opensearch.index.reindex.DeleteByQueryRequest;
                expectedParams.put("human", String.valueOf(humanReadable));
        // Create a simple request.
        UpdateByQueryRequest updateByQueryRequest = new UpdateByQueryRequest();
        StringJoiner endpoint = new StringJoiner("/", "/", "");
        Request request = RequestConverters.putScript(putStoredScriptRequest);
    public void testCreateContentType() {
        );
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("a", "b");
                    searchSourceBuilder.from(randomIntBetween(0, Integer.MAX_VALUE));
            if (slices == 0) {
                true,
                    false,
        }
            }
            if (randomBoolean()) {
        expectedParams.put("max_concurrent_shard_requests", Integer.toString(searchRequest.getMaxConcurrentShardRequests()));
        List<String> pitIdsList = new ArrayList<>();
import org.opensearch.index.rankeval.RankEvalSpec;
                expectedParams.put("refresh", "true");
        if (randomBoolean()) {
                }
    }
        Map<String, String> expectedParams = new HashMap<>();
            putStoredScriptRequest.context(context);
        assertEquals(HttpPost.METHOD_NAME, request.getMethod());
    public static void setRandomIndicesOptions(
import org.opensearch.client.core.MultiTermVectorsRequest;
                consumer.accept(fetchSourceContext);
            new Tuple<String, Supplier<Request>>("_delete_by_query", () -> RequestConverters.rethrottleDeleteByQuery(rethrottleRequest))
        if (randomBoolean()) {
    private static void setRandomSearchParams(SearchRequest searchRequest, Map<String, String> expectedParams) {
import org.opensearch.action.DocWriteRequest;
    public void testSourceExistsWithType() throws IOException {
                consumer.accept(new FetchSourceContext(true, includes, excludes));
        );
    public void testIndex() throws IOException {
        AnalyzeRequest indexAnalyzeRequest = AnalyzeRequest.withIndexAnalyzer("test_index", "test_analyzer", "Here is some text");
            assertToXContentEquivalent(updateRequest.doc().source(), parsedUpdateRequest.doc().source(), xContentType);
        setRandomRefreshPolicy(bulkRequest::setRefreshPolicy, expectedParams);
        expectedParams.put("batched_reduce_size", Integer.toString(searchRequest.getBatchedReduceSize()));
            BytesReference source = RandomObjects.randomSource(random(), xContentType);
        final XContentType xContentType = randomFrom(XContentType.values());
        }
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("index", "type", "this/is/the/id");
        }
        }
        assertThat(request.getParameters(), hasKey("fields"));
        }
            assertNull(request.getEntity());
            if (randomBoolean()) {
                expectedParams.put("slices", AbstractBulkByScrollRequest.AUTO_SLICES_VALUE);
        assertEquals("/index1,index2/_endpoint", RequestConverters.endpoint(new String[] { "index1", "index2" }, "_endpoint"));
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("foo^bar");
    }
import org.opensearch.client.core.CountRequest;
        BulkRequest parsedBulkRequest = new BulkRequest();
        assertEquals(new BytesArray(expectedBytes), new BytesArray(EntityUtils.toByteArray(actualEntity)));
        String endpoint = "/_search/point_in_time";
            exception.getMessage()
            assertNull(parsedUpdateRequest.doc());
                    searchSourceBuilder.suggest(
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("foo+bar");
        assertThat(request.getMethod(), equalTo(HttpGet.METHOD_NAME));
        }
        Map<String, String> expectedParams = new HashMap<>();
            float requestsPerSecond = (float) randomDoubleBetween(0.0, 10.0, false);
        assertToXContentBody(indexAnalyzeRequest, request.getEntity());
            if (randomBoolean()) {
        assertEquals(updateRequest.script(), parsedUpdateRequest.script());
    }
        }
        indexRequest.id(id);
        int numberOfRequests = randomIntBetween(0, 5);
        } else {
        Map<String, String> expectedParams = new HashMap<>();
            randomizeFetchSourceContextParams(explainRequest::fetchSourceContext, expectedParams);
            if (retryOnConflict > 0) {
            expectedParams.put("scroll_size", Integer.toString(batchSize));
import org.opensearch.action.search.ClearScrollRequest;
        }
        endpoint.add("_field_caps");
                    expectedParams.put("_source_includes", includesParam);
    ) {
        joiner.add(String.join(",", deleteByQueryRequest.indices()));
        assertEquals(HttpGet.METHOD_NAME, request.getMethod());
        if (indexRequest.opType() == DocWriteRequest.OpType.CREATE) {
    public void testSearchTemplate() throws Exception {
        assertThat(request.getEndpoint(), equalTo("/_scripts/" + getStoredScriptRequest.id()));
        Request request = RequestConverters.explain(explainRequest);
            assertEquals("/", endpointBuilder.build());
import org.opensearch.index.reindex.UpdateByQueryRequest;
        } else {
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.opensearch.script.mustache.SearchTemplateRequest;
        if (updateRequest.doc() != null) {
import org.opensearch.search.suggest.completion.CompletionSuggestionBuilder;
                expectedParams.put("stored_fields", storedFieldsParam);
        }
        if (randomBoolean()) {
            assertEquals("/%2Ffoo@bar", endpointBuilder.build());
        }
    public void testUpdateWithDifferentContentTypes() {
        assertEquals(updateRequest.fetchSource(), parsedUpdateRequest.fetchSource());
        assertEquals(HttpPost.METHOD_NAME, request.getMethod());
        assertThat(request.getParameters(), equalTo(expectedParams));
        searchTemplateRequest.setScriptType(ScriptType.INLINE);
        if (randomBoolean()) {
        if (randomBoolean()) {
            String timeout = randomTimeValue();
                    searchSourceBuilder.size(randomIntBetween(0, Integer.MAX_VALUE));
            final long seqNo = randomNonNegativeLong();
                }
            if (refreshPolicy != WriteRequest.RefreshPolicy.NONE) {
        if (randomBoolean()) {
            }
            if (randomBoolean()) {
        if (randomBoolean()) {
        if (randomBoolean()) {
    private static void getAndExistsTest(Function<GetRequest, Request> requestConverter, String method) {
            if (slices == 0) {
        if (randomBoolean()) {
        String type = randomAlphaOfLengthBetween(3, 10);
 *
import java.util.ArrayList;
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("index", "type", "id#1");
            } else {
            } else if (opType == DocWriteRequest.OpType.UPDATE) {
            String[] storedFields = generateRandomStringArray(10, 5, false, false);
        MultiTermVectorsRequest mtvRequest = new MultiTermVectorsRequest();
        Request request = RequestConverters.update(updateRequest);
            TimeValue timeout = TimeValue.parseTimeValue(randomTimeValue(), "random_timeout");
    }
                randomBoolean(),
        expectedParams.put("allow_no_indices", Boolean.toString(getter.get().allowNoIndices()));
            endpoint.add(joinedIndices);
    }
 * this work for additional information regarding copyright
        }
            assertEquals("/foo+bar", endpointBuilder.build());
import org.apache.hc.client5.http.classic.methods.HttpHead;
        assertEquals(MediaTypeRegistry.JSON.mediaTypeWithoutParameters(), actualEntity.getContentType());
                    randomBoolean(),
        if (randomBoolean()) {
        if (randomBoolean()) {
import static org.opensearch.client.RequestConverters.REQUEST_BODY_CONTENT_TYPE;
        bulkRequest.pipeline("xyz");
            updateByQueryRequest.setRouting("=cat");
            if (randomBoolean()) {
        }
        endpoint.add(index).add(type).add(id).add("_termvectors");
            } else {
import org.opensearch.common.lucene.uid.Versions;
            expectedParams.put("preference", preference);
        for (int i = 0; i < nbItems; i++) {
        String index = randomAlphaOfLengthBetween(3, 10);
            // frequently set the search source to have some content, otherwise leave it
                expectedParams.put("refresh", refreshPolicy.getValue());
            );
                expectedParams.put("realtime", "false");
        }
                String preference = randomAlphaOfLengthBetween(3, 10);
        Map<String, String> expectedParams = new HashMap<>();
        assertEquals(bulkRequest.numberOfActions(), parsedBulkRequest.numberOfActions());
        assertThat(request.getMethod(), equalTo(HttpDelete.METHOD_NAME));
            if (refresh) {
        }
        byte[] content = new byte[(int) request.getEntity().getContentLength()];
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("//foo");
            }
    }
                            .field(randomAlphaOfLengthBetween(3, 10))
            reindexRequest.setDestPipeline("my_pipeline");
        {
            reindexRequest.setSlices(slices);
        {
            if (multiGetRequest.realtime() == false) {
        if (randomBoolean()) {
            expectedParams.put("if_seq_no", Long.toString(seqNo));
                randomBoolean(),
        assertEquals(mediaType.mediaTypeWithoutParameters(), request.getEntity().getContentType());
        if (randomBoolean()) {
            expectedParams.put("pipeline", "my_pipeline");
        String[] indices = randomIndicesNames(0, 5);
            setter.accept(timeout);
        }
        String index = randomAlphaOfLengthBetween(3, 10);
        }
        exception = expectThrows(
            if (randomBoolean()) {
            assertEquals("/%2F%2Ffoo%2Fbar", endpointBuilder.build());
        String[] fields;
                    searchSourceBuilder.collapse(new CollapseBuilder(randomAlphaOfLengthBetween(3, 10)));
            WriteRequest.RefreshPolicy refreshPolicy = randomFrom(WriteRequest.RefreshPolicy.values());
        setRandomIfSeqNoAndTerm(deleteRequest, expectedParams);
            expectedParams.put("timeout", defaultTimeout.getStringRep());
    private static void setRandomCountParams(CountRequest countRequest, Map<String, String> expectedParams) {
        );
        setRandomWaitForActiveShards(setter, ActiveShardCount.DEFAULT, expectedParams);
        assertEquals(endpoint.toString(), request.getEndpoint());
    }
                if (version != Versions.MATCH_ANY) {
        setRandomIfSeqNoAndTerm(updateRequest, new HashMap<>()); // if* params are passed in the body
import org.opensearch.common.collect.Tuple;
            int waitForActiveShardsInt = randomIntBetween(-1, 5);
    }
        );
        }
        {
        StringJoiner endpoint = new StringJoiner("/", "/", "");
            } else {
            expectedParams.put("slices", "1");
                reindexRequest.setSize(randomIntBetween(100, 1000));
        setRandomClusterManagerTimeout(putStoredScriptRequest, expectedParams);
        }
                if (randomBoolean()) {
        }
import org.opensearch.action.support.IndicesOptions;
                )
            String preference = randomAlphaOfLengthBetween(3, 10);
        try (XContentParser parser = createParser(xContentType.xContent(), entity.getContent())) {
                getRequest.refresh(refresh);
            if (randomBoolean()) {
        Map<String, Object> scriptParams = new HashMap<>();
            boolean includeDefaults = randomBoolean();
        }
            String ts = randomTimeValue();
        expectedParams.put("ignore_unavailable", Boolean.toString(getter.get().ignoreUnavailable()));
        assertEquals(expectedParams, request.getParameters());
                    randomBoolean(),
                if (randomBoolean()) {
import java.util.concurrent.TimeUnit;
        assertToXContentBody(mtvRequest, request.getEntity());
            int retryOnConflict = randomIntBetween(0, 5);
            updateRequest.upsert(new IndexRequest().source(singletonMap("field", "upsert"), XContentType.YAML));
            if (humanReadable) {
        if (reindexRequest.getRemoteInfo() == null && randomBoolean()) {
        }
        String[] requestFields = Strings.splitStringByCommaToArray(request.getParameters().get("fields"));
            }
        assertToXContentBody(deletePitRequest, request.getEntity());
import org.opensearch.index.rankeval.RankEvalRequest;
                updateRequest.doc(new IndexRequest().source(singletonMap("field", "value"), mediaType));
        assertEquals(expectedParams, request.getParameters());
        }
import org.opensearch.action.delete.DeleteRequest;
                assertEquals(updateRequest.fetchSource(), parsedUpdateRequest.fetchSource());
        for (int i = 0; i < numIndices; i++) {
            expectedParams.put("routing", "=cat");
        }
    public void testEndpointBuilderEncodeParts() {
        if (randomBoolean()) {
        for (int i = 0; i < numberOfRequests; i++) {
                String includesParam = randomFields(includes);
    private static void doTestGetSource(BiFunction<String, String, GetSourceRequest> requestFunction) throws IOException {
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            request.setIfSeqNo(seqNo);
        }
        assertEquals(MediaTypeRegistry.JSON.mediaTypeWithoutParameters(), actualEntity.getContentType());
            parsedUpdateRequest.fromXContent(parser);
            bulkRequest.add(new IndexRequest("index").id("1").source(singletonMap("field", "value"), MediaTypeRegistry.JSON));
            REQUEST_BODY_CONTENT_TYPE.xContent(),
        assertEquals(endpoint.toString(), request.getEndpoint());
            expectedParams.put("pre_filter_shard_size", Integer.toString(searchRequest.getPreFilterShardSize()));
            String index = randomAlphaOfLength(5);
        Map<String, String> expectedParams = new HashMap<>();
        assertEquals(expectedParams, request.getParameters());
        );
        assertEquals(HttpPost.METHOD_NAME, request.getMethod());
        for (int i = 0; i < numberOfRequests; i++) {
                        )
        doTestSourceExists((index, id) -> new GetSourceRequest(index, id).type(type));
                String excludesParam = randomFields(excludes);
import org.opensearch.search.Scroll;
    public void testDelete() {
            assertEquals(
    }
        Map<String, String> expectedParams = new HashMap<>();
        // as we create SearchSourceBuilder in CountRequest constructor
            updateRequest.setRefreshPolicy(refreshPolicy);
            request.version(version);
            setter.accept(refreshPolicy);
        }
        e = expectThrows(IllegalArgumentException.class, () -> new RethrottleRequest(new TaskId("taskId", 1), -5.0f));
    }
        multiGetRequest.add(item);
        explainRequest.query(QueryBuilders.termQuery(randomAlphaOfLengthBetween(3, 10), randomAlphaOfLengthBetween(3, 10)));
        if (hasFields) {
            IllegalArgumentException.class,
import org.opensearch.action.support.replication.ReplicationRequest;
        } else {
            expectedParams.put("preference", preference);
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RequestConvertersTests.class);
        }
            Request request = RequestConverters.bulk(new BulkRequest().add(updateRequest));
        {
        XContentType xContentType = randomFrom(XContentType.values());
            if (randomBoolean()) {
                    );
            }
        assertEquals("/_mget", request.getEndpoint());
            rankEvalRequest.searchType(randomFrom(SearchType.CURRENTLY_SUPPORTED));
        {
        }
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("//foo/bar");
        }
        assertThat(request.getEntity(), nullValue());
        }
            expectedParams.put("timeout", timeout);
            expectedParams.put("timeout", timeout.getStringRep());
        }
        searchTemplateRequest.setProfile(randomBoolean());
    }
            bulkRequest.add(new DeleteRequest("index", "0"));
        if (randomBoolean()) {
        expectedParams.put("wait_for_completion", Boolean.TRUE.toString());
        } else {
            }
            () -> enforceSameContentType(new IndexRequest().source(singletonMap("field", "value"), requestContentType), mediaType)
        if (randomBoolean()) {
            expectedBody,
            clearScrollRequest.addScrollId(randomAlphaOfLengthBetween(5, 10));
            searchTemplateRequest.setSearchPipeline("pipeline");
        }
        String index = randomAlphaOfLengthBetween(3, 10);
            assertThat(request.getParameters(), hasEntry(param.getKey(), param.getValue()));
                }
        }
        Request request = RequestConverters.multiSearch(multiSearchRequest);
        } else if (getter.get().expandWildcardsOpen()) {
import java.util.HashMap;
        }
    }
        setRandomIndicesOptions(searchRequest::indicesOptions, searchRequest::indicesOptions, expectedParams);
 */
        DeletePitRequest deletePitRequest = new DeletePitRequest(pitIdsList);
    static void setRandomClusterManagerTimeout(Consumer<String> setter, Map<String, String> expectedParams) {
        }
            expectedParams.put("max_docs", Integer.toString(size));
        try (XContentBuilder builder = XContentBuilder.builder(xContentType.xContent())) {
                boolean refresh = randomBoolean();
    static void setRandomLocal(Consumer<Boolean> setter, Map<String, String> expectedParams) {
import org.opensearch.core.tasks.TaskId;
        {
        assertEquals("/", request.getEndpoint());
        Request request = RequestConverters.mtermVectors(mtvRequest);
        }
        }
        {
        BulkRequest bulkRequest = new BulkRequest();
        SearchRequest searchRequest = new SearchRequest(indices);
    }
    private static void setRandomVersion(DocWriteRequest<?> request, Map<String, String> expectedParams) {
            if (slices == 0) {
            expectedParams.put("routing", routing);
            TermVectorsRequest tvRequest = new TermVectorsRequest(index, type, id);
        assertNotNull(request.getEntity());
import org.opensearch.index.query.TermQueryBuilder;
            DocWriteRequest.OpType opType = randomFrom(DocWriteRequest.OpType.values());
                }
    }
        }
            tvRequest.setFields(fields);
            } else if (opType == DocWriteRequest.OpType.UPDATE) {
        DocWriteRequest<?>[] requests = new DocWriteRequest<?>[nbItems];
            if (waitForActiveShardsInt == -1) {
                    false,
 * under the License.
            }
            assertEquals("/-%23index1,index%232/type/id", endpointBuilder.build());
                    msearchDefault.expandWildcardsHidden(),
            expectedParams.put("expand_wildcards", "open");
    }
        Map<String, String> expectedParams = new HashMap<>();
                boolean fetchSource = randomBoolean();
            boolean realtime = randomBoolean();
        if (indicesOptions.expandWildcardsOpen() && indicesOptions.expandWildcardsClosed()) {
    static void setRandomIncludeDefaults(Consumer<Boolean> setter, Map<String, String> expectedParams) {
import org.opensearch.client.core.TermVectorsRequest;
        );
            tvRequest.setFields(fields);
    }
            }
            assertEquals("/cluster1:index1,index2/_search", endpointBuilder.build());
            // batched reduce size is currently not set-able on a per-request basis as it is a query string parameter only
            expectedParams.put("version", Long.toString(Versions.MATCH_DELETED));
            updateByQueryRequest.setScript(new Script("ctx._source.last = \"lastname\""));
            countRequest.source(searchSourceBuilder);
    public void testMultiGetWithType() throws IOException {
        assertEquals(updateRequest.scriptedUpsert(), parsedUpdateRequest.scriptedUpsert());
            getRequest.preference(preference);
        Map<String, String> indicesOptionsParams = new HashMap<>();
            expectedParams.put("scroll_size", Integer.toString(batchSize));
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
        Consumer<ActiveShardCount> setter,
    }
            assertEquals(originalRequest.id(), parsedRequest.id());
        setRandomTimeout(deleteStoredScriptRequest::timeout, AcknowledgedRequest.DEFAULT_ACK_TIMEOUT, expectedParams);
                expectedParams.put("slices", AbstractBulkByScrollRequest.AUTO_SLICES_VALUE);
        Map<String, String> expectedParams
            updateByQueryRequest.setRequestsPerSecond(requestsPerSecond);
    public void testCountNotNullSource() throws IOException {
            // only expand_wildcards, ignore_unavailable and allow_no_indices can be
                }
        assertThat(request.getEndpoint(), equalTo("/_scripts/" + id));
        assertEquals(joiner.toString(), request.getEndpoint());
import org.opensearch.action.bulk.BulkRequest;
            bulkRequest.add(new UpdateRequest("index", "1").script(mockScript("test")));
        assertEquals(HttpHead.METHOD_NAME, request.getMethod());
            String[] fields = generateRandomStringArray(10, 5, false, false);
import org.apache.hc.core5.http.io.entity.ByteArrayEntity;
        XContentType xContentType = randomFrom(XContentType.values());
            BytesReference source = RandomObjects.randomSource(random(), xContentType);
        assertNull(request.getEntity());
            BulkRequest bulkRequest = new BulkRequest();
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("index", "type#2", "id");
        return indices;
        endpoint.add("_field_caps");
            assertEquals("/" + variant.v1() + "/" + taskId + "/_rethrottle", request.getEndpoint());
        List<Tuple<String, Supplier<Request>>> variants = new ArrayList<>();
            if (randomBoolean()) {
            DocWriteRequest<?> originalRequest = bulkRequest.requests().get(i);
        }
        }
                String[] includes = new String[numIncludes];
        }
                deleteByQueryRequest.setMaxDocs(size);
        setRandomTimeout(indexRequest::timeout, ReplicationRequest.DEFAULT_TIMEOUT, expectedParams);
        searchTemplateRequest.setScript("template1");
        if (randomBoolean()) {
        Request request = RequestConverters.count(countRequest);
            searchRequest.setBatchedReduceSize(randomIntBetween(2, Integer.MAX_VALUE));
            if (realtime == false) {
    }
        assertEquals("/" + index + "/_source/" + id, request.getEndpoint());
            setRandomIfSeqNoAndTerm(indexRequest, expectedParams);
        setRandomSearchParams(searchRequest, expectedParams);
        int nbFields = randomIntBetween(0, 10);
        MultiSearchRequest.readMultiLineFormat(
            reindexRequest.setRemoteInfo(remoteInfo);
        assertEquals(expectedParams, request.getParameters());
        StringJoiner endpoint = new StringJoiner("/", "/", "");
                expectedParams.put("version_type", versionType.name().toLowerCase(Locale.ROOT));
        Map<String, Object> scriptParams = new HashMap<>();
        assertEquals(5, request.getParameters().size());
/*
                + "], "
        assertEquals(endpoint.toString(), request.getEndpoint());
        }
            String type = randomAlphaOfLengthBetween(3, 10);
            assertNull(parsedUpdateRequest.upsertRequest());
            updateRequest.docAsUpsert(docAsUpsert);
                getRequest.realtime(realtime);
        expectedParams.put("search_type", rankEvalRequest.searchType().name().toLowerCase(Locale.ROOT));
        assertEquals(HttpPost.METHOD_NAME, request.getMethod());
            }
        expectedParams.put("ignore_unavailable", Boolean.toString(indicesOptions.ignoreUnavailable()));
        }
                searchRequest.source(searchSourceBuilder);
        bulkRequest.add(new IndexRequest("test").id("12").source(MediaTypeRegistry.JSON, "field", "bulk2"));
        );
            expectedParams.put("expand_wildcards", "open,closed");
            String index = randomAlphaOfLengthBetween(3, 10);
            request.setIfPrimaryTerm(primaryTerm);
        }
        String id = randomBoolean() ? randomAlphaOfLengthBetween(3, 10) : null;
    public void testPing() {
        }
                docWriteRequest = createRequest;
            endpoint.add(index);
            int slices = randomIntBetween(0, 4);
        }
        Map<String, String> expectedParams = new HashMap<>();
        String searchEndpoint = randomFrom("_" + randomAlphaOfLength(5));
        );
        // passed through
import org.opensearch.index.query.QueryBuilders;
                exception.getMessage()
 * SPDX-License-Identifier: Apache-2.0
                boolean realtime = randomBoolean();
        }
        StringJoiner joiner = new StringJoiner("/", "/", "");
        }
        assertEquals(endpoint, request.getEndpoint());
        endpoint.add("_search/point_in_time");
            DocWriteRequest.OpType opType = originalRequest.opType();
        {
        assertEquals(5, request.getParameters().size());
        if (randomBoolean()) {
import org.opensearch.action.search.MultiSearchRequest;
        MultiSearchRequest multiSearchRequest = new MultiSearchRequest();
            setter.accept(versionType);
        StringJoiner endpoint = new StringJoiner("/", "/", "");
        assertToXContentBody(putStoredScriptRequest, request.getEntity());
        }
import org.opensearch.core.xcontent.MediaType;
        // Note that we don't check the field param value explicitly, as field names are
        if (randomBoolean()) {
        if (randomBoolean()) {
        assertThat(request.getEntity(), nullValue());
import org.hamcrest.Matchers;
            }
            BytesReference source = RandomObjects.randomSource(random(), mediaType);
        if (randomBoolean()) {
        if (randomBoolean()) {
import org.opensearch.script.ScriptType;
        ReindexRequest reindexRequest = new ReindexRequest();
        String id = randomAlphaOfLengthBetween(3, 10);
import org.opensearch.common.CheckedBiConsumer;
        expectedParams.put("ignore_throttled", Boolean.toString(getter.get().ignoreThrottled()));
        if (randomBoolean()) {
        }
            updateRequest.retryOnConflict(retryOnConflict);
        assertEquals(endpoint.toString(), request.getEndpoint());
        CountRequest countRequest = new CountRequest(indices);
        assertEquals(new HashSet<>(Arrays.asList(fields)), new HashSet<>(Arrays.asList(requestFields)));
        bulkRequest.add(new IndexRequest("test").id("13").source(MediaTypeRegistry.JSON, "field", "bulk3"));
    public void testSearchNullIndicesAndTypes() {
 * Modifications Copyright OpenSearch Contributors. See
                IndexRequest indexRequest = (IndexRequest) originalRequest;
            expectedParams.put("requests_per_second", "-1");
        endpoint.add("_count");
            assertEquals("/index1,index2/cache/clear", endpointBuilder.build());
            endpoint.add(index);
        } else {
            expectedParams.put("cluster_manager_timeout", clusterManagerTimeout.getStringRep());
        assertEquals(expectedParams, request.getParameters());
            String preference = randomAlphaOfLengthBetween(3, 10);
        assertTrue(entity instanceof ByteArrayEntity);
        }
        } else {
        assertToXContentBody(multiGetRequest, request.getEntity());
            "/index1,index2/_endpoint/suffix1,suffix2",
            putStoredScriptRequest.content(BytesReference.bytes(builder), xContentType);
            assertEquals("/index/type/id%231", endpointBuilder.build());
        for (Map.Entry<String, String> param : indicesOptionsParams.entrySet()) {
        } else {
import org.opensearch.common.xcontent.XContentType;
        // Create a random request.
        setRandomClusterManagerTimeout(deleteStoredScriptRequest, expectedParams);
            null,
 * The OpenSearch Contributors require contributions made to
        Request request = RequestConverters.searchTemplate(searchTemplateRequest);
        if (randomBoolean()) {
            }
    }
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("//foo@bar");
        assertThat(request.getEndpoint(), equalTo("/_scripts/" + deleteStoredScriptRequest.id()));
        MediaType entityContentType = MediaType.fromMediaType(entity.getContentType());
                }
        }
        assertEquals(REQUEST_BODY_CONTENT_TYPE.mediaTypeWithoutParameters(), request.getEntity().getContentType());
    }
            expectedParams.put("expand_wildcards", "closed");
        GetStoredScriptRequest getStoredScriptRequest = new GetStoredScriptRequest("x-script");
        expectedParams.put("search_type", searchRequest.searchType().name().toLowerCase(Locale.ROOT));
            MediaType mediaType = randomFrom(MediaTypeRegistry.JSON, XContentType.SMILE);
    public void testReindex() throws IOException {
        }
    }
        }
        }
            expectedParams.put("scroll", searchRequest.scroll().keepAlive().getStringRep());
        assertEquals("/", request.getEndpoint());
        assertNotNull(request.getEntity());
        parsedBulkRequest.add(content, 0, content.length, mediaType);
import org.opensearch.index.VersionType;
            int size = randomIntBetween(100, 1000);
    public void testFieldCapsWithIndexFilter() throws IOException {
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("a").addPathPartAsIs("_endpoint");
        assertEquals(REQUEST_BODY_CONTENT_TYPE.mediaTypeWithoutParameters(), request.getEntity().getContentType());
import java.util.function.Supplier;
        if (randomBoolean()) {
        String[] indices = randomIndicesNames(0, 5);
import java.util.StringJoiner;
                String storedFieldsParam = randomFields(storedFields);
        if (randomBoolean()) {
                int numStoredFields = randomIntBetween(1, 10);
            searchRequest.setMaxConcurrentShardRequests(randomIntBetween(1, Integer.MAX_VALUE));
    static void setRandomTimeout(TimedRequest request, TimeValue defaultTimeout, Map<String, String> expectedParams) {
                IndexRequest createRequest = new IndexRequest(index).id(id).source(source, mediaType).create(true);
            builder.endObject();
        String id = randomAlphaOfLengthBetween(3, 10);
    private static void setRandomIfSeqNoAndTerm(DocWriteRequest<?> request, Map<String, String> expectedParams) {
                "Mismatching content-type found for request with content-type [SMILE], " + "previous requests have content-type [JSON]",
        }
            assertToXContentEquivalent(updateRequest.upsertRequest().source(), parsedUpdateRequest.upsertRequest().source(), xContentType);
            String waitForActiveShardsString;
            // specified from msearch api, so unset other options:
            reindexRequest.setRequestsPerSecond(requestsPerSecond);
        searchTemplateRequest.setScriptParams(scriptParams);
            BulkRequest bulkRequest = new BulkRequest();
            expectedParams.put("timeout", defaultTimeout.getStringRep());
        assertToXContentBody(updateByQueryRequest, request.getEntity());
            assertEquals("/" + index + "/_doc", request.getEndpoint());
            bulkRequest.add(new DeleteRequest("index", "3"));
            randomizeFetchSourceContextParams(updateRequest::fetchSource, expectedParams);
    public void testRankEval() throws Exception {
                if (randomBoolean()) {
    public void testDeletePit() throws IOException {
        if (randomBoolean()) {
        assertNull(request.getEntity());
            deleteByQueryRequest.setRequestsPerSecond(requestsPerSecond);
import static org.hamcrest.Matchers.nullValue;
            expectedParams.put("routing", routing);
        assertEquals(0, request.getParameters().size());
        endpoint.add(index).add("_termvectors").add(id);
        assertEquals(Collections.emptyMap(), request.getParameters());
                reindexRequest.setMaxDocs(randomIntBetween(100, 1000));
        joiner.add(String.join(",", updateByQueryRequest.indices()));
            "Unsupported content-type found for request with content-type [YAML], only JSON and SMILE are supported",
        }
        );
        } else if (id != null) {
                }
            assertThat(request.getParameters(), hasEntry(param.getKey(), param.getValue()));
    }
        if (randomBoolean()) {
        assertToXContentBody(searchTemplateRequest, request.getEntity());
                expectedParams.put("routing", routing);
            }
        }
                deleteRequest.routing(routing);
        if (searchRequest.getPreFilterShardSize() != null) {
                throw new UnsupportedOperationException("optype [" + opType + "] not supported");
            String ts = randomTimeValue();
        StringBuilder excludesParam = new StringBuilder();
        assertEquals(HttpDelete.METHOD_NAME, request.getMethod());
        if (randomBoolean()) {
        assertEquals(HttpPost.METHOD_NAME, request.getMethod());
            assertEquals(HttpPost.METHOD_NAME, request.getMethod());
    }
        final int numSearchRequests = randomIntBetween(1, 10);
                    searchSourceBuilder.query(new TermQueryBuilder(randomAlphaOfLengthBetween(3, 10), randomAlphaOfLengthBetween(3, 10)));
        GetRequest getRequest = new GetRequest(index, id);
        if (randomBoolean()) {
        setRandomIndicesOptions(fieldCapabilitiesRequest::indicesOptions, fieldCapabilitiesRequest::indicesOptions, indicesOptionsParams);
                randomBoolean(),
            expectedParams.put("requests_per_second", Float.toString(requestsPerSecond));
    }
            }
            }
            expectedParams.put("preference", preference);
                "user",
        assertEquals(expectedParams, request.getParameters());
        if (randomBoolean()) {
            expectedParams.put("max_docs", Integer.toString(size));
    }
        setRandomCountParams(countRequest, expectedParams);
        Request request = RequestConverters.info();
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("foo+bar");
        putStoredScriptRequest.id(id);
            IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> RequestConverters.bulk(bulkRequest));
        // Verify that the resulting REST request looks as expected.
        int numIndices = randomIntBetween(minIndicesNum, maxIndicesNum);
        {
        } else {
            if (randomBoolean()) {
        SearchRequest searchRequest = new SearchRequest();
    }
        if (randomBoolean()) {
        reindexRequest.setDestIndex("dest_idx");
    }
                expectedParams.put("realtime", "false");
            assertEquals("/a/b/_endpoint", endpointBuilder.build());
                        new QueryRescorerBuilder(new TermQueryBuilder(randomAlphaOfLengthBetween(3, 10), randomAlphaOfLengthBetween(3, 10)))
                } else {
    }
    public static SearchRequest createTestSearchRequest(String[] indices, Map<String, String> expectedParams) {
            } else {
        assertEquals("/" + index + "/_doc/" + id, request.getEndpoint());
            }
        }
                }
        }
        // test illegal RethrottleRequest values
            bulkRequest.add(new IndexRequest("index").id("0").source(singletonMap("field", "value"), MediaTypeRegistry.JSON));
        String index = randomAlphaOfLengthBetween(3, 10);
        scriptParams.put("value", "soren");
            .indexFilter(QueryBuilders.matchAllQuery());
import org.opensearch.rest.action.search.RestSearchAction;
        }
import java.util.HashSet;
        }
            boolean refresh = randomBoolean();
            explainRequest.preference(preference);
                long version = randomLong();
import static org.hamcrest.Matchers.hasEntry;
    public void testEnforceSameContentType() {
            explainRequest.routing(routing);
        }
            }
        UpdateRequest updateRequest = new UpdateRequest(index, id);
            assertEquals(originalRequest.opType(), parsedRequest.opType());
        assertEquals("/" + index + "/_doc/" + id, request.getEndpoint());
            endpoint.add(index);
                // elsewhere
        }
            int slices = randomIntBetween(0, 4);
        String[] indices = randomIndicesNames(0, 5);
        }
                "pass",
            expectedParams.put("routing", countRequest.routing());
        Map<String, String> expectedParams = new HashMap<>();
        }
        for (Map.Entry<String, String> param : indicesOptionsParams.entrySet()) {
            expectedParams.put("conflicts", "proceed");
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart(Strings.EMPTY_ARRAY);
        }
        if (indexRequest.opType() == DocWriteRequest.OpType.CREATE) {
                deleteByQueryRequest.setSize(size);
        });
        IllegalArgumentException exception = expectThrows(
        if (randomBoolean()) {
                + requestContentType
        }
            assertEquals("/%3Clogstash-%7Bnow%2FM%7D%3E/_search", endpointBuilder.build());
            setRandomIndicesOptions(searchRequest::indicesOptions, searchRequest::indicesOptions, expectedParams);
            expectedParams.put("context", context);
            // empty but still set it
        assertToXContentBody(searchScrollRequest, request.getEntity());
/*
                if (realtime == false) {
        } else {
        if (randomBoolean()) {
        assertToXContentBody(explainRequest, request.getEntity());
        // Verify that the resulting REST request looks as expected.
        assertToXContentBody(reindexRequest, request.getEntity());
            expectedParams.put("terminate_after", String.valueOf(countRequest.terminateAfter()));
            }
    static void setRandomWaitForActiveShards(Consumer<ActiveShardCount> setter, Map<String, String> expectedParams) {
        if (randomBoolean()) {
            searchRequest.preference(randomAlphaOfLengthBetween(3, 10));
            expectedParams.put(RethrottleRequest.REQUEST_PER_SECOND_PARAMETER, Float.toString(requestsPerSecond));
        if (randomBoolean()) {
        }
            } else {
                    msearchDefault.allowAliasesToMultipleIndices(),
        assertNull(request.getEntity());
    public void testTermVectors() throws IOException {
        assertEquals(HttpGet.METHOD_NAME, request.getMethod());
import java.io.IOException;
            assertEquals("/%2F%2F%2Ffoo", endpointBuilder.build());
        String index = String.join(",", indices);
                if (randomBoolean()) {
        }
            }
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("<logstash-{now/M}>", "_search");
        }
    public void testExists() {
                    expectedParams.put("realtime", "false");
        } else {
        if (randomBoolean()) {
                expectedParams.put("routing", routing);
import org.opensearch.search.fetch.subphase.FetchSourceContext;
            final long primaryTerm = randomLongBetween(1, 200);
            searchScrollRequest.scroll(randomPositiveTimeValue());
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("a").addPathPart("b").addPathPartAsIs("_endpoint");
            }
    public void testSourceExists() throws IOException {
        assertEquals(expectedParams, request.getParameters());
        // There is some logic around _create endpoint and version/version type
            expectedParams.put("expand_wildcards", "none");
        expectedParams.put("ccs_minimize_roundtrips", Boolean.toString(searchRequest.isCcsMinimizeRoundtrips()));
        updateByQueryRequest.indices(randomIndicesNames(1, 5));
        if (Strings.hasLength(index)) {
            tvRequest.setFields(fields);
 * software distributed under the License is distributed on an
import java.util.function.BiFunction;
import org.opensearch.search.rescore.QueryRescorerBuilder;
        }
        exception = expectThrows(
        assertEquals("/" + index + "/_explain/" + id, request.getEndpoint());
    }
        assertNull(request.getEntity());
            xContentRegistry(),
        final GetSourceRequest getRequest = requestFunction.apply(index, id);
            searchTemplateRequest.setScriptParams(scriptParams);
            Request request = RequestConverters.bulk(bulkRequest);
                }
            );
        assertEquals(expectedParams, request.getParameters());
        {
    public void testDeleteAllPits() {
        }
            bulkRequest.add(new DeleteRequest("index", "2"));
        );
        }
        String endpoint = "/_search/point_in_time/_all";
            expectedParams.put("timeout", ReplicationRequest.DEFAULT_TIMEOUT.getStringRep());
        // Create a random request.
    }
        }
        assertTrue(entity instanceof ByteArrayEntity);
    }
import org.opensearch.search.collapse.CollapseBuilder;
                .addPathPartAsIs("cache/clear");
        CountRequest countRequest = new CountRequest();
        assertEquals(REQUEST_BODY_CONTENT_TYPE.mediaTypeWithoutParameters(), request.getEntity().getContentType());
            builder.startObject("script").field("lang", "painless").field("source", "Math.log(_score * 2) + params.multiplier").endObject();
                assertToXContentEquivalent(indexRequest.source(), parsedIndexRequest.source(), mediaType);
        }
            REQUEST_BODY_CONTENT_TYPE,
        }
    public void testGlobalPipelineOnBulkRequest() throws IOException {
        }
 * specific language governing permissions and limitations
            updateByQueryRequest.setScroll(TimeValue.parseTimeValue(ts, "scroll"));
        assertEquals(requests, multiSearchRequest.requests());
        if (randomBoolean()) {
            exception.getMessage()
            setter.accept(clusterManagerTimeout);
            reindexRequest.setAbortOnVersionConflict(false);
            if (docAsUpsert) {
    public void testMultiSearchTemplate() throws Exception {
                }
            reindexRequest.setSourceQuery(new TermQueryBuilder("foo", "fooval"));
            assertEquals("/a/b", endpointBuilder.build());
                if (randomBoolean()) {
        IllegalStateException exception = expectThrows(IllegalStateException.class, () -> {
        assertEquals(method, request.getMethod());
        if (randomBoolean()) {
        joiner.add("_update_by_query");
    }
    }
            TimeValue clusterManagerTimeout = TimeValue.parseTimeValue(randomTimeValue(), "random_cluster_manager_timeout");
                if (randomBoolean()) {
            bulkRequest.add(new IndexRequest("index").id("1").source(singletonMap("field", "value"), MediaTypeRegistry.JSON));
            reindexRequest.setDestRouting("=cat");
import org.opensearch.core.common.bytes.BytesReference;
    static void setRandomTimeoutTimeValue(Consumer<TimeValue> setter, TimeValue defaultTimeout, Map<String, String> expectedParams) {
        } else if (getter.get().expandWildcardsClosed()) {
            assertEquals("/foo%20bar", endpointBuilder.build());
        if (randomBoolean()) {
            fields[i] = exclude;
            if (randomBoolean()) {
            assertEquals(expectedParams, request.getParameters());
        assertEquals(
            rethrottleRequest = new RethrottleRequest(taskId, requestsPerSecond);
            expectedParams.put(RethrottleRequest.REQUEST_PER_SECOND_PARAMETER, "-1");
        Request request = RequestConverters.searchTemplate(searchTemplateRequest);
        doTestSourceExists((index, id) -> new GetSourceRequest(index, id));
                searchSourceBuilder.size(randomIntBetween(20, 100));
            expectedParams.put("timeout", BulkShardRequest.DEFAULT_TIMEOUT.getStringRep());
    public void testBulk() throws IOException {
        assertEquals(numSearchRequests, searchRequests.size());
            scriptParams.put("value", randomAlphaOfLengthBetween(2, 5));
                indexRequest.routing(routing);
import org.opensearch.index.rankeval.RestRankEvalAction;
            String storedFieldsParams = randomFields(storedFields);
            s -> request.setTimeout(TimeValue.parseTimeValue(s, request.getClass().getName() + ".timeout")),
        StringJoiner endpoint = new StringJoiner("/", "/", "");
            int slices = randomIntBetween(0, 4);
import static org.opensearch.client.RequestConverters.enforceSameContentType;
        assertEquals("/index1,index2", RequestConverters.endpoint(new String[] { "index1", "index2" }));
                docWriteRequest.setIfSeqNo(randomNonNegativeLong());
        assertEquals(expectedParams, request.getParameters());
        Map<String, String> expectedParams = new HashMap<>();
            expectedParams.put("cluster_manager_timeout", ClusterManagerNodeRequest.DEFAULT_CLUSTER_MANAGER_NODE_TIMEOUT.getStringRep());
        Map<String, String> expectedParams = new HashMap<>();
        Map<String, String> expectedParams = new HashMap<>();
                int numIncludes = randomIntBetween(0, 5);
        setRandomTimeout(deleteByQueryRequest::setTimeout, ReplicationRequest.DEFAULT_TIMEOUT, expectedParams);
            expectedParams
                getRequest.routing(routing);
        assertEquals(endpoint.toString(), request.getEndpoint());
            });
        }
            RequestConverters.endpoint(new String[] { "index1", "index2" }, "_endpoint", new String[] { "suffix1", "suffix2" })
import org.opensearch.action.fieldcaps.FieldCapabilitiesRequest;
        assertNull(request.getEntity());
            assertEquals("/", endpointBuilder.build());
        Map<String, String> expectedParams = new HashMap<>();
                if (numExcludes > 0) {
        {
    }
        return searchSourceBuilder;
        expectThrows(NullPointerException.class, () -> new SearchRequest((String[]) null));
        String id = randomAlphaOfLengthBetween(3, 10);
        }
        String index = randomAlphaOfLengthBetween(3, 10);
        }
import java.util.Locale;
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
                }
        }
        if (randomBoolean()) {
        MediaType requestContentType = mediaType == MediaTypeRegistry.JSON ? XContentType.SMILE : MediaTypeRegistry.JSON;
        assertEquals(HttpDelete.METHOD_NAME, request.getMethod());
        {
 * ownership. Elasticsearch licenses this file to you under
        }
    public void testRethrottle() {
            null,
            boolean humanReadable = randomBoolean();
            String timeout = randomTimeValue();
        }
        setRandomIndicesOptions(deleteByQueryRequest::setIndicesOptions, deleteByQueryRequest::indicesOptions, expectedParams);
        Request request = requestConverter.apply(getRequest);
                if (randomBoolean()) {
    }
            assertEquals("/", endpointBuilder.build());
            assertEquals("/a/b/c/_endpoint", endpointBuilder.build());
                    assertNull(parsedUpdateRequest.doc());
        if (randomBoolean()) {
        if (randomBoolean()) {
        }
        setRandomSearchParams(searchRequest, expectedParams);
                IndicesOptions.fromOptions(
        BulkRequest bulkRequest = new BulkRequest();
            assertEquals(originalRequest.routing(), parsedRequest.routing());
            if (i < fields.length - 1) {
    }
        }
        ActiveShardCount defaultActiveShardCount,
        if (randomBoolean()) {
            searchRequest.allowPartialSearchResults(randomBoolean());
        assertEquals(HttpGet.METHOD_NAME, request.getMethod());
        if (randomBoolean()) {
        joiner.add("_delete_by_query");
import org.opensearch.core.xcontent.XContentParser;
        }
import org.opensearch.action.get.GetRequest;
                + "previous requests have content-type ["
        {
        setRandomTimeout(reindexRequest::setTimeout, ReplicationRequest.DEFAULT_TIMEOUT, expectedParams);
        if (randomBoolean()) {
import static org.hamcrest.CoreMatchers.equalTo;
        if (randomBoolean()) {
    }
            bulkRequest.add(new DeleteRequest("index", "2"));
    }
        Map<String, String> expectedParams = new HashMap<>();
        Request request = RequestConverters.ping();
/*
        StringJoiner endpoint = new StringJoiner("/", "/", "");
import org.opensearch.action.bulk.BulkShardRequest;
import org.opensearch.client.core.GetSourceRequest;
            if (randomBoolean()) {
                )
            bulkRequest.timeout(timeout);
            setter.accept(activeShardCount);
        setRandomIndicesOptions(rankEvalRequest::indicesOptions, rankEvalRequest::indicesOptions, expectedParams);
            }
        }
        Request request = RequestConverters.bulk(bulkRequest);
        if (randomBoolean()) {
                expectedParams.put("doc_as_upsert", "true");
            if (refresh) {
            assertEquals("/a/_endpoint", endpointBuilder.build());
            deleteByQueryRequest.setBatchSize(batchSize);
                + "]",
        int numberOfRequests = randomIntBetween(0, 5);
        String joinedIndices = String.join(",", indices);
        assertEquals("/index/type/id/_endpoint", RequestConverters.endpoint("index", "type", "id", "_endpoint"));
        if (randomBoolean()) {
                indexRequest.opType(DocWriteRequest.OpType.CREATE);
            MediaType mediaType = randomFrom(MediaTypeRegistry.JSON, XContentType.SMILE);
 *
            s -> request.setClusterManagerTimeout(TimeValue.parseTimeValue(s, request.getClass().getName() + ".clusterManagerNodeTimeout")),
                if (refresh) {
            boolean local = randomBoolean();
import org.opensearch.action.admin.cluster.storedscripts.GetStoredScriptRequest;
        Request request = RequestConverters.search(searchRequest, searchEndpoint);
            IndicesOptions msearchDefault = new MultiSearchRequest().indicesOptions();
    }
            countRequest.terminateAfter(randomIntBetween(0, Integer.MAX_VALUE));
        assertEquals(HttpPost.METHOD_NAME, request.getMethod());
            }
    }
import java.util.Collections;
            setter.accept(humanReadable);
        // Verify that the resulting REST request looks as expected.
        }
        Request request = RequestConverters.updateByQuery(updateByQueryRequest);
            builder.endObject();
            requestsPerSecond = (float) randomDoubleBetween(0.0, 100.0, true);
    }
        );
        Map<String, String> expectedParams = new HashMap<>();
            rethrottleRequest = new RethrottleRequest(taskId);
            expectedParams.put("cluster_manager_timeout", clusterManagerTimeout);
                    searchSourceBuilder.addRescorer(
        }
import org.opensearch.client.RequestConverters.EndpointBuilder;
            assertEquals("/foo+bar", endpointBuilder.build());
        assertEquals("/" + index + "/_update/" + id, request.getEndpoint());
                expectedParams.put("pipeline", pipeline);
    }
            float requestsPerSecond = (float) randomDoubleBetween(0.0, 10.0, false);
            } else {
                    : FetchSourceContext.DO_NOT_FETCH_SOURCE;
        boolean hasFields = randomBoolean();
            if (randomBoolean()) {
        for (int i = 0; i < fields.length; i++) {
    }
        MultiTermVectorsRequest mtvRequest = new MultiTermVectorsRequest();
            updateRequest.timeout(timeout);
        if (randomBoolean()) {
            String[] indices = randomIndicesNames(0, 5);
        for (int i = 0; i < numberOfRequests; i++) {
                }
            if (defaultActiveShardCount.equals(activeShardCount) == false) {
        {
        IndexRequest indexRequest = new IndexRequest(index);
        String index = randomAlphaOfLengthBetween(3, 10);
        searchTemplateRequest.setSimulate(true); // Setting simulate true means the template should only be rendered.
        DeleteByQueryRequest deleteByQueryRequest = new DeleteByQueryRequest();
        Request request = RequestConverters.multiGet(multiGetRequest);
            IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> RequestConverters.bulk(bulkRequest));
    static String[] randomIndicesNames(int minIndicesNum, int maxIndicesNum) {
            Request request = RequestConverters.bulk(bulkRequest);
                }
        assertEquals(REQUEST_BODY_CONTENT_TYPE.mediaTypeWithoutParameters(), request.getEntity().getContentType());
import java.util.List;
                item.versionType(randomFrom(VersionType.values()));
import org.apache.hc.client5.http.classic.methods.HttpPut;
            expectedParams
 * Unless required by applicable law or agreed to in writing,
    public void testUpdate() throws IOException {
            .fields(fields)
        if (randomBoolean()) {
            assertEquals(originalRequest.versionType(), parsedRequest.versionType());
            assertEquals(
        assertEquals(mediaType, enforceSameContentType(indexRequest, mediaType));
        Map<String, String> expectedParams = new HashMap<>();
        Request request = RequestConverters.deletePit(deletePitRequest);
    public void testSearchScroll() throws IOException {
        setRandomTimeout(putStoredScriptRequest::timeout, AcknowledgedRequest.DEFAULT_ACK_TIMEOUT, expectedParams);
                    assertToXContentEquivalent(updateRequest.doc().source(), parsedUpdateRequest.doc().source(), mediaType);
            deleteByQueryRequest.setScroll(TimeValue.parseTimeValue(ts, "scroll"));
 *
        for (Map.Entry<String, String> param : expectedParams.entrySet()) {
                if (randomBoolean()) {
            builder.startObject();
        if (randomBoolean()) {
            getRequest.refresh(refresh);
        }
        assertEquals(expectedParams, multiRequest.getParameters());
        assertEquals(HttpDelete.METHOD_NAME, request.getMethod());
        }
        searchTemplateRequest.setSearchPipeline("pipeline");
        assertEquals(HttpGet.METHOD_NAME, request.getMethod());
            deleteByQueryRequest.setQuery(new TermQueryBuilder("foo", "fooval"));
            SearchRequest searchRequest = new SearchRequest(indices);
        }
            assertEquals("/foo%5Ebar", endpointBuilder.build());
                docWriteRequest.routing(randomAlphaOfLength(10));
            bulkRequest.add(new DeleteRequest("index", "2"));
            }
        if (randomBoolean()) {
            setRandomVersionType(getRequest::versionType, expectedParams);
        Request request = RequestConverters.multiGet(multiGetRequest);
            BulkRequest bulkRequest = new BulkRequest();
    public void testClearScroll() throws IOException {
            BulkRequest bulkRequest = new BulkRequest();
            new BytesArray(EntityUtils.toByteArray(request.getEntity())),
        setRandomIndicesOptions(createPitRequest::indicesOptions, createPitRequest::indicesOptions, expectedParams);
            UpdateRequest updateRequest = new UpdateRequest();
    }
        assertEquals("/_mtermvectors", request.getEndpoint());
        assertEquals(HttpPost.METHOD_NAME, request.getMethod());
            DocWriteRequest<?> docWriteRequest;
                getRequest.storedFields(storedFields);
            false
        if (randomBoolean()) {
            String[] fields = generateRandomStringArray(10, 5, false, false);
            multiGetRequest.add(item);
                BytesReference.bytes(matchAllQuery().toXContent(builder, ToXContent.EMPTY_PARAMS)),
            if (randomBoolean()) {
        int numScrolls = randomIntBetween(1, 10);
        }
    }
 * Licensed to Elasticsearch under one or more contributor
            } else {
            );
        }
        if (updateRequest.upsertRequest() != null) {
            expectedParams.put("request_cache", Boolean.toString(searchRequest.requestCache()));
        assertEquals(xContentType.mediaTypeWithoutParameters(), RequestConverters.createContentType(xContentType).getMimeType());
        assertThat(request.getParameters(), equalTo(expectedParams));
    public void testDeleteByQuery() throws IOException {
        {
        assertToXContentBody(deleteByQueryRequest, request.getEntity());
            setRandomSearchParams(searchRequest, expectedParams);
        assertEquals(HttpPost.METHOD_NAME, request.getMethod());
    public void testInfo() {
            assertEquals("/index/type/this%7Cis%7Cthe%7Cid", endpointBuilder.build());
import org.opensearch.core.common.bytes.BytesArray;
        assertEquals(new HashSet<>(Arrays.asList(fields)), new HashSet<>(Arrays.asList(requestFields)));
                String routing = randomAlphaOfLengthBetween(3, 10);
            if (randomBoolean()) {
        if (Strings.hasLength(index)) {
        String[] fields = generateRandomStringArray(5, 10, false, false);
import org.opensearch.action.search.DeletePitRequest;
        String id = randomAlphaOfLengthBetween(3, 10);
        }
            if (frequently()) {
                docWriteRequest = indexRequest;
 * not use this file except in compliance with the License.
        Request request = RequestConverters.index(indexRequest);
    }
            }
                expectedParams.put("slices", Integer.toString(slices));
    public void testPutScript() throws Exception {
            BulkRequest bulkRequest = new BulkRequest();
                + mediaType
        String[] indices = randomIndicesNames(0, 5);
            // scroll is not supported in the current msearch api, so unset it:
import org.opensearch.action.update.UpdateRequest;
        } else {
        if (randomBoolean()) {
        MultiGetRequest multiGetRequest = new MultiGetRequest();
        String id = randomAlphaOfLengthBetween(3, 10);
        Map<String, String> expectedParams = new HashMap<>();
import org.opensearch.action.search.CreatePitRequest;
        }
        SearchRequest searchRequest = new SearchRequest(indices);
            multiGetRequest.refresh(randomBoolean());
        }
        }
                item.version(randomNonNegativeLong());
        assertEquals(
        endpoint.add(RestRankEvalAction.ENDPOINT);
        if (randomBoolean()) {
    }
        if (randomBoolean()) {
                }
        assertEquals(HttpGet.METHOD_NAME, request.getMethod());
        List<SearchRequest> requests = new ArrayList<>();
            assertEquals("/%2F%2Ffoo", endpointBuilder.build());
import org.opensearch.index.query.MatchAllQueryBuilder;
    }
                }
        HttpEntity entity = request.getEntity();
        MultiGetRequest.Item item = new MultiGetRequest.Item(randomAlphaOfLength(4), randomAlphaOfLength(4));
            expectedParams.put("preference", searchRequest.preference());
            mtvRequest.add(tvRequest);
        assertEquals(HttpGet.METHOD_NAME, request.getMethod());
        assertEquals(HttpPost.METHOD_NAME, request.getMethod());
        assertEquals(expectedParams, request.getParameters());
import org.opensearch.search.builder.SearchSourceBuilder;
            multiSearchRequest.indicesOptions(),
        Request request = RequestConverters.fieldCaps(fieldCapabilitiesRequest);
        if (randomBoolean()) {
            searchTemplateRequest.setScriptType(ScriptType.INLINE);
        searchTemplateRequest.setScript("{\"query\": { \"match\" : { \"{{field}}\" : \"{{value}}\" }}}");
        assertEquals(endpoint.toString(), request.getEndpoint());
        assertEquals(HttpGet.METHOD_NAME, request.getMethod());
        } else {
            EndpointBuilder endpointBuilder = new EndpointBuilder().addCommaSeparatedPathParts(new String[] { "index1", "index2" })
        DeleteRequest deleteRequest = new DeleteRequest(index, id);
        Request request = RequestConverters.search(searchRequest, searchEndpoint);
        if (randomBoolean()) {
        TermVectorsRequest tvRequest = new TermVectorsRequest(index, id);
                expectedParams.put("refresh", "true");
import java.util.function.Function;
            // scroll is not supported in the current msearch or msearchtemplate api, so unset it:
            assertEquals("/" + index + "/_create/" + id, request.getEndpoint());
            exception.getMessage()
                    expectedParams.put("version", Long.toString(version));
            if (randomBoolean()) {
        CreatePitRequest createPitRequest = new CreatePitRequest(new TimeValue(1, TimeUnit.DAYS), true, indices);
        assertNull(request.getEntity());
        TaskId taskId = new TaskId(randomAlphaOfLength(10), randomIntBetween(1, 100));
    static void setRandomClusterManagerTimeout(ClusterManagerNodeRequest<?> request, Map<String, String> expectedParams) {
                false,
import org.opensearch.core.xcontent.MediaTypeRegistry;
                    expectedParams.put("_source_excludes", excludesParam);
            // Create a random request.
            assertEquals("/%2Fpart1/%2F%2Fpart2/%2F%2F%2Fpart3", endpointBuilder.build());
    public void testMultiSearch() throws IOException {
        AnalyzeRequest analyzeRequest = AnalyzeRequest.withGlobalAnalyzer("test_analyzer", "more text");
        expectedParams.put(RestSearchAction.TYPED_KEYS_PARAM, "true");
            String id = randomAlphaOfLengthBetween(3, 10);
    static void setRandomClusterManagerTimeout(TimedRequest request, Map<String, String> expectedParams) {
            }
    }
        Request request = RequestConverters.termVectors(tvRequest);
    public void testGetSource() throws IOException {
    public void testRenderSearchTemplate() throws Exception {
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("-#index1,index#2", "type", "id");
                    searchSourceBuilder.explain(randomBoolean());
    private static void randomizeFetchSourceContextParams(Consumer<FetchSourceContext> consumer, Map<String, String> expectedParams) {
        Map<String, String> expectedParams = new HashMap<>();
            }
            String routing = randomAlphaOfLengthBetween(3, 10);
            expectedParams.put("scroll", ts);
        } else {
        Map<String, String> expectedParams = new HashMap<>();
        }
            deleteByQueryRequest.setRouting("=cat");
                expectedParams.put("wait_for_active_shards", waitForActiveShardsString);
                expectedParams.put("routing", routing);
        return searchRequest;
        assertEquals(HttpPost.METHOD_NAME, request.getMethod());
        searchRequest.source(searchSourceBuilder);
                assertEquals(updateRequest.retryOnConflict(), parsedUpdateRequest.retryOnConflict());
        assertEquals(HttpHead.METHOD_NAME, request.getMethod());
        Map<String, String> expectedParams = new HashMap<>();
        for (int i = 0; i < numScrolls; i++) {
                    searchSourceBuilder.highlighter(new HighlightBuilder().field(randomAlphaOfLengthBetween(3, 10)));
            } else {
        }
            assertEquals("/index/type%232/id", endpointBuilder.build());
    }
    }
        }
        setRandomIndicesOptions(searchRequest::indicesOptions, searchRequest::indicesOptions, expectedParams);
            "Unsupported content-type found for request with content-type [CBOR], only JSON and SMILE are supported",
        }
        setRandomClusterManagerTimeout(getStoredScriptRequest, expectedParams);
            expectedParams.put("scroll", ts);
import org.opensearch.action.index.IndexRequest;
        // Note that we don't check the field param value explicitly, as field names are
        expectedParams.put("scroll", reindexRequest.getScrollTime().getStringRep());
            builder.startObject();
        Consumer<IndicesOptions> setter,
                    expectedParams.put("refresh", "true");
        pitIdsList.add("pitId2");
                int numExcludes = randomIntBetween(0, 5);
    public void testCount() throws Exception {
        }
            } else if (opType == DocWriteRequest.OpType.CREATE) {
                expectedParams.put("version", Long.toString(version));
import org.opensearch.core.xcontent.XContentBuilder;
            deleteByQueryRequest.setSlices(slices);
                expectedParams.put("include_defaults", String.valueOf(includeDefaults));
            }
        BytesReference expectedBytes = org.opensearch.core.xcontent.XContentHelper.toXContent(
    public void testGet() {
        }
        expectedParams.put("ignore_throttled", Boolean.toString(indicesOptions.ignoreThrottled()));
            expectedParams.put("preference", preference);
            assertEquals(
}
        CheckedBiConsumer<SearchRequest, XContentParser, IOException> consumer = (searchRequest, p) -> {
                final UpdateRequest updateRequest = new UpdateRequest(index, id).doc(new IndexRequest().source(source, mediaType));
            "Update request cannot have different content types for doc [JSON] and upsert [YAML] documents",
        MultiSearchTemplateRequest multiSearchTemplateRequest = new MultiSearchTemplateRequest();
            String id = randomAlphaOfLength(5);
            null,
            }
        setRandomVersionType(deleteRequest::versionType, expectedParams);
        variants.add(
import org.opensearch.index.rankeval.PrecisionAtK;
            searchTemplateRequest.setProfile(randomBoolean());
        String index = String.join(",", indices);
            if (randomBoolean()) {
        }
                }
            reindexRequest.setSourceBatchSize(randomInt(100));
        assertToXContentBody(multiGetRequest, request.getEntity());
        };
    }
    public void testTermVectorsWithType() throws IOException {
        if (randomBoolean()) {
            searchRequest.searchType(randomFrom(SearchType.CURRENTLY_SUPPORTED));
        }
import static java.util.Collections.emptyMap;
            expectedParams.put("routing", routing);
            countRequest.preference(randomAlphaOfLengthBetween(3, 10));
        searchScrollRequest.scrollId(randomAlphaOfLengthBetween(5, 10));
            expectedParams.put("max_concurrent_searches", Integer.toString(multiSearchRequest.maxConcurrentSearchRequests()));
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("index", "type", "this|is|the|id");
        );
        for (int i = 0; i < bulkRequest.numberOfActions(); i++) {
            Request request = variant.v2().get();
        setRandomClusterManagerTimeout(request::clusterManagerNodeTimeout, expectedParams);
                9200,
            expectedParams.put("routing", "=cat");
                    randomlyGenerated.ignoreUnavailable(),
            assertEquals("/%2Ffoo%2Fbar", endpointBuilder.build());
                SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        assertToXContentBody(tvRequest, request.getEntity());
        if (randomBoolean()) {
            expectedParams.put("max_concurrent_searches", Integer.toString(multiSearchTemplateRequest.maxConcurrentSearchRequests()));
            method = HttpPut.METHOD_NAME;
        return indicesOptions;
        if (randomBoolean()) {
        {
        {
    }
            }
            assertEquals("/中文", endpointBuilder.build());
            expectedParams.put("allow_partial_search_results", Boolean.toString(searchRequest.allowPartialSearchResults()));
        if (randomBoolean()) {
                if (randomBoolean()) {
        assertThat(request.getParameters(), hasKey("fields"));
import org.opensearch.index.reindex.ReindexRequest;
import java.io.InputStream;
        }
        } else {
        TermVectorsRequest tvRequest = new TermVectorsRequest(index, type, id);
        Request request = RequestConverters.getSource(getRequest);
            countRequest.query(new MatchAllQueryBuilder());
            ActiveShardCount activeShardCount = ActiveShardCount.parseString(waitForActiveShardsString);
        }
        if (randomBoolean()) {
    }
        {
        if (randomBoolean()) {
            expectedParams.put(RethrottleRequest.REQUEST_PER_SECOND_PARAMETER, "-1");
        assertThat(request.getParameters(), Matchers.hasEntry("pipeline", "xyz"));
        }
            assertEquals("/" + index + "/_doc/" + id, request.getEndpoint());
            int batchSize = randomInt(100);
            int size = randomIntBetween(100, 1000);
 * You may obtain a copy of the License at
            }
                randomizeFetchSourceContextParams(item::fetchSourceContext, new HashMap<>());
    static void assertToXContentBody(ToXContent expectedBody, HttpEntity actualEntity) throws IOException {
            bulkRequest.add(new IndexRequest("index").id("0").source(singletonMap("field", "value"), mediaType));
            XContentType xContentType = randomFrom(XContentType.CBOR, XContentType.YAML);
            multiSearchTemplateRequest.maxConcurrentSearchRequests(randomIntBetween(1, 10));
        {
        assertEquals(endpoint.toString(), request.getEndpoint());
            endpoint.add(joinedIndices);
                    true,
                searchSourceBuilder.from(randomInt(10));
                    randomBoolean(),
        } else {
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("/foo/bar");
        StringJoiner joiner = new StringJoiner("/", "/", "");
        getAndExistsTest(RequestConverters::exists, HttpHead.METHOD_NAME);
            }
import org.opensearch.core.common.Strings;
        if (frequently()) {
        }
        {
        }
        );
import org.opensearch.test.RandomObjects;
            bulkRequest.add(new DeleteRequest("index", "0"));
import org.opensearch.index.mapper.MapperService;
        scriptParams.put("field", "name");
        assertToXContentBody(searchRequest.source(), request.getEntity());
        assertEquals(
        String endpoint = "/_render/template";
    static void setRandomTimeout(Consumer<String> setter, TimeValue defaultTimeout, Map<String, String> expectedParams) {
            new Tuple<String, Supplier<Request>>("_update_by_query", () -> RequestConverters.rethrottleUpdateByQuery(rethrottleRequest))
        if (randomBoolean()) {
        assertEquals(HttpGet.METHOD_NAME, request.getMethod());
        String[] indices = randomIndicesNames(0, 5);
            if (version != Versions.MATCH_ANY) {
            String context = randomAlphaOfLengthBetween(5, 10);
            multiSearchTemplateRequest.add(searchTemplateRequest);
        if (id != null) {
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertEquals(expectedBytes, new BytesArray(EntityUtils.toByteArray(actualEntity)));
        RethrottleRequest rethrottleRequest;
            Collections.singletonList(new RatedRequest("queryId", Collections.emptyList(), new SearchSourceBuilder())),
            );
                    msearchDefault.ignoreAliases(),
        assertEquals(HttpPost.METHOD_NAME, request.getMethod());
        getAndExistsTest(RequestConverters::get, HttpGet.METHOD_NAME);
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
            searchTemplateRequest.setScript("{\"query\": { \"match\" : { \"{{field}}\" : \"{{value}}\" }}}");
            String index = randomAlphaOfLengthBetween(3, 10);
            setRandomVersionType(indexRequest::versionType, expectedParams);
            }
        try (InputStream inputStream = request.getEntity().getContent()) {
            Map<String, String> expectedParams = new HashMap<>();
                RemoteInfo.DEFAULT_SOCKET_TIMEOUT,
        {
            updateByQueryRequest.setAbortOnVersionConflict(false);
            searchRequest.indicesOptions(
        IndexRequest indexRequest = new IndexRequest().source(singletonMap("field", "value"), mediaType);
        expectedParams.put("allow_partial_pit_creation", "true");
                        new TermsAggregationBuilder(randomAlphaOfLengthBetween(3, 10)).userValueTypeHint(ValueType.STRING)
            }
        if (randomBoolean()) {
    private static void assertIfSeqNoAndTerm(DocWriteRequest<?> request, DocWriteRequest<?> parsedRequest) {
        if (frequently()) {
        if (Strings.hasLength(index)) {
            assertEquals("/%2F%2Ffoo@bar", endpointBuilder.build());
    private static void setRandomRefreshPolicy(Consumer<WriteRequest.RefreshPolicy> setter, Map<String, String> expectedParams) {
    }
            multiGetRequest.preference(preference);
                docWriteRequest = updateRequest;
        PutStoredScriptRequest putStoredScriptRequest = new PutStoredScriptRequest();
        }
    public void testSearchNullSource() throws IOException {
        }
    }
            String routing = randomAlphaOfLengthBetween(3, 10);
            assertEquals(originalRequest.ifSeqNo(), parsedRequest.ifSeqNo());
    }
        String joinedIndices = String.join(",", indices);
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (randomBoolean()) {
        endpoint.add("_search/template");
        }
                assertEquals(indexRequest.getPipeline(), parsedIndexRequest.getPipeline());
        if (randomBoolean()) {
            bulkRequest.add(new DeleteRequest("index", "0"));
    }
            }
        }
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("/foo");
        {
        if (!joinedIndices.isEmpty()) {
        }
        Request request = RequestConverters.analyze(indexAnalyzeRequest);
        setRandomRefreshPolicy(deleteRequest::setRefreshPolicy, expectedParams);
        }
        variants.add(
            if (local) {
        Request request = RequestConverters.reindex(reindexRequest);
    }
import org.opensearch.action.get.MultiGetRequest;
        assertToXContentBody(fieldCapabilitiesRequest, request.getEntity());
        assertEquals("/_search/scroll", request.getEndpoint());
        setRandomWaitForActiveShards(reindexRequest::setWaitForActiveShards, ActiveShardCount.DEFAULT, expectedParams);
        pitIdsList.add("pitId1");
    public void testMultiTermVectors() throws IOException {
        assertEquals(expectedParams, request.getParameters());
        assertEquals(joiner.toString(), request.getEndpoint());
            } else {
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("foo bar");
                expectedParams.put("realtime", "false");
        FieldCapabilitiesRequest fieldCapabilitiesRequest = new FieldCapabilitiesRequest().indices(indices)
                new UpdateRequest("index", "2").doc(new IndexRequest().source(singletonMap("field", "value"), MediaTypeRegistry.JSON))
        Map<String, String> expectedParams = new HashMap<>();
        if (randomBoolean()) {
                    .upsert(new IndexRequest().source(singletonMap("field", "value"), XContentType.SMILE))
                            new CompletionSuggestionBuilder(randomAlphaOfLengthBetween(3, 10))
            if (randomBoolean()) {
import org.opensearch.action.support.ActiveShardCount;
        } else if (indicesOptions.expandWildcardsClosed()) {
    }
        }
        updateRequest.detectNoop(randomBoolean());
        );
        Request request = RequestConverters.deleteByQuery(deleteByQueryRequest);
            searchRequest.setCcsMinimizeRoundtrips(randomBoolean());
                randomizeFetchSourceContextParams(getRequest::fetchSourceContext, expectedParams);
            multiSearchTemplateRequest,
                    searchSourceBuilder.minScore(randomFloat());
        assertEquals(expectedParams, request.getParameters());
        }
        if (randomBoolean()) {
import org.apache.hc.client5.http.classic.methods.HttpDelete;
                docWriteRequest.setIfPrimaryTerm(randomLongBetween(1, 200));
        assertToXContentBody(searchTemplateRequest, request.getEntity());
        assertEquals(HttpDelete.METHOD_NAME, request.getMethod());
import static org.hamcrest.Matchers.hasKey;
        }
        return excludesParam.toString();
        // Verify that the resulting REST request looks as expected.
    /**
            IllegalArgumentException.class,
                if (randomBoolean()) {
        assertEquals("/_mtermvectors", request.getEndpoint());
                updateByQueryRequest.setSize(size);
            indexRequest.source(builder);
        {
        if (randomBoolean()) {
        if (randomBoolean()) {
import org.opensearch.search.suggest.SuggestBuilder;
            for (int i = 0; i < nbFields; i++) {
            setter.accept(
        }
            expectedParams.put("slices", "1");
        }
            multiSearchRequest.maxConcurrentSearchRequests(randomIntBetween(1, 8));
            searchRequest.routing(randomAlphaOfLengthBetween(3, 10));
            indexRequest.version(randomFrom(Versions.MATCH_ANY, Versions.MATCH_DELETED));
        assertEquals(expectedParams, request.getParameters());
import org.opensearch.action.search.SearchScrollRequest;
                }
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("a", "b", "c").addPathPartAsIs("_endpoint");
            scriptParams.put("field", "name");
 * compatible open source license.
            expectedParams.put("timeout", timeout);
                null,
        String index = String.join(",", indices);
    }
        } else {
        }
            assertEquals(mediaType.mediaTypeWithoutParameters(), request.getEntity().getContentType());
        if (randomBoolean()) {
        String type = frequently() ? randomAlphaOfLengthBetween(3, 10) : MapperService.SINGLE_MAPPING_NAME;
            expectedParams.put("cluster_manager_timeout", defaultTimeout.getStringRep());
    }
        Request request = RequestConverters.fieldCaps(fieldCapabilitiesRequest);
        setRandomTimeout(updateByQueryRequest::setTimeout, ReplicationRequest.DEFAULT_TIMEOUT, expectedParams);
        MediaType mediaType = randomFrom(MediaTypeRegistry.JSON, XContentType.SMILE);
                builder.field("field_" + i, i);
        assertToXContentBody(clearScrollRequest, request.getEntity());
        assertEquals(method, request.getMethod());
        Supplier<IndicesOptions> getter,
        }
import org.opensearch.index.reindex.RemoteInfo;
        }
            getRequest.realtime(realtime);
        expectedParams.put("wait_for_completion", Boolean.TRUE.toString());
            searchRequest.scroll((Scroll) null);
        assertIfSeqNoAndTerm(updateRequest, parsedUpdateRequest);
                        new SuggestBuilder().addSuggestion(
            searchRequest.scroll(randomTimeValue());
            setter.accept(local);
            String preference = randomAlphaOfLengthBetween(3, 10);
            bulkRequest.add(new IndexRequest("index").id("0").source(singletonMap("field", "value"), XContentType.SMILE));
            assertEquals(originalRequest.index(), parsedRequest.index());
        expectedParams.put("keep_alive", "1d");
     */
            updateByQueryRequest.setBatchSize(batchSize);
        );
            );
        }
        if (randomBoolean()) {
                // No need to return a very complex SearchSourceBuilder here, that is tested
        assertEquals(request.ifPrimaryTerm(), parsedRequest.ifPrimaryTerm());
        }
            Streams.readFully(inputStream, content);
            IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> RequestConverters.bulk(bulkRequest));
            updateRequest.upsert(new IndexRequest().source(source, xContentType));
            searchRequest.setBatchedReduceSize(SearchRequest.DEFAULT_BATCHED_REDUCE_SIZE);
                expectedParams.put("retry_on_conflict", String.valueOf(retryOnConflict));
    public void testEndpoint() {
            expectedParams.put("requests_per_second", "-1");
            if (opType == DocWriteRequest.OpType.INDEX) {
    }
        if (randomBoolean()) {
            endpoint.add(index);
        Map<String, String> expectedParams = new HashMap<>();
        {
        }
            }
        }
                    randomBoolean(),
            }
    public void testMultiTermVectorsWithType() throws IOException {
            () -> enforceSameContentType(new IndexRequest().source(singletonMap("field", "value"), XContentType.CBOR), bulkContentType)
            reindexRequest.setDestOpType("create");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
        }
            MediaTypeRegistry.JSON.xContent()
        {
        assertEquals("/_mget", request.getEndpoint());
            updateRequest.script(mockScript("_value + 1"));
            float requestsPerSecond = (float) randomDoubleBetween(0.0, 10.0, false);
        }
            updateByQueryRequest.setPipeline("my_pipeline");
        XContentType xContentType = randomFrom(XContentType.values());
            );
            if (versionType != VersionType.INTERNAL) {
                    ? FetchSourceContext.FETCH_SOURCE
        assertNull(request.getEntity());
        {
        }
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(endpoint.toString(), request.getEndpoint());
                updateByQueryRequest.setMaxDocs(size);
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("cluster1:index1,index2").addPathPartAsIs("_search");
            expectedParams.put("slices", "1");
        }
        assertThat(request.getParameters(), equalTo(expectedParams));
        Request request = RequestConverters.mtermVectors(mtvRequest);
                    );
        }
            getRequest.routing(routing);
 * this file be licensed under the Apache-2.0 license or a
            exception.getMessage()
            }
        {
        HttpEntity entity = request.getEntity();
                            randomAlphaOfLengthBetween(3, 10),
        assertToXContentBody(mtvRequest, request.getEntity());
        try (XContentParser parser = createParser(entityContentType.xContent(), entity.getContent())) {
        MediaType bulkContentType = randomBoolean() ? mediaType : null;
        assertEquals(HttpPost.METHOD_NAME, request.getMethod());
        {
            expectedParams.put("routing", searchRequest.routing());
                exception.getMessage()
                    searchSourceBuilder.profile(randomBoolean());
        SearchRequest searchRequest = createTestSearchRequest(indices, expectedParams);
        RankEvalRequest rankEvalRequest = new RankEvalRequest(spec, indices);
            fields = generateRandomStringArray(10, 5, false, false);
                docWriteRequest = new DeleteRequest(index, id);
            UpdateRequest updateRequest = new UpdateRequest("index", "0");
        String id = randomAlphaOfLengthBetween(3, 10);
            EndpointBuilder endpointBuilder = new EndpointBuilder();
        Request multiRequest = RequestConverters.multiSearchTemplate(multiSearchTemplateRequest);
import org.opensearch.index.reindex.AbstractBulkByScrollRequest;
    }
    public void testCreatePit() throws IOException {
            String routing = randomAlphaOfLengthBetween(3, 10);
        Map<String, String> indicesOptionsParams = new HashMap<>();
        Request request = RequestConverters.count(countRequest);
        assertEquals(updateRequest.detectNoop(), parsedUpdateRequest.detectNoop());
                excludesParam.append(",");
            assertThat(request.getParameters(), hasEntry(param.getKey(), param.getValue()));
        setRandomTimeout(deleteRequest::timeout, ReplicationRequest.DEFAULT_TIMEOUT, expectedParams);
                waitForActiveShardsString = String.valueOf(waitForActiveShardsInt);
        expectedParams.put("allow_no_indices", Boolean.toString(indicesOptions.allowNoIndices()));
                String routing = randomAlphaOfLengthBetween(3, 10);
    public void testAnalyzeRequest() throws Exception {
        Request request = RequestConverters.rankEval(rankEvalRequest);
        final GetSourceRequest getRequest = requestFunction.apply(index, id);
                "http",
            }
        byte[] expectedBytes = MultiSearchTemplateRequest.writeMultiLineFormat(
                FetchSourceContext fetchSourceContext = fetchSource
            updateRequest.doc(new IndexRequest().source(singletonMap("field", "doc"), MediaTypeRegistry.JSON));
        setRandomTimeout(
            IllegalArgumentException.class,
        scriptParams.put("field", "name");
                indexRequest.setPipeline(pipeline);
        assertEquals("/_bulk", request.getEndpoint());
        }
        );
            requests.add(searchRequest);
                IndexRequest parsedIndexRequest = (IndexRequest) parsedRequest;
        searchTemplateRequest.setScriptType(ScriptType.STORED);
        UpdateRequest parsedUpdateRequest = new UpdateRequest();
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("foo/bar");
        assertEquals(endpoint, request.getEndpoint());
        assertEquals("/" + index + "/_source/" + id, request.getEndpoint());
import org.opensearch.action.admin.cluster.storedscripts.PutStoredScriptRequest;
        MultiGetRequest multiGetRequest = new MultiGetRequest();
        if (randomBoolean()) {
        // a hash set before being added to the request, and can appear in a
        }
                randomBoolean()
            if (opType != DocWriteRequest.OpType.UPDATE && randomBoolean()) {
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("");
        Request request = RequestConverters.termVectors(tvRequest);
            } else if (opType == DocWriteRequest.OpType.DELETE) {
        }
            boolean docAsUpsert = randomBoolean();
        assertToXContentBody(countRequest, request.getEntity());
    ) {
            if (realtime == false) {
            SearchRequest searchRequest = randomSearchRequest(() -> {
        }
                }
        }
    }
    }
        expectThrows(NullPointerException.class, () -> new SearchRequest().indices((String[]) null));
            getRequest.preference(preference);
            searchRequest.scroll((Scroll) null);
        assertEquals(
        HttpEntity actualEntity = multiRequest.getEntity();
        searchTemplateRequest.setSearchPipeline("pipeline");
            VersionType versionType = randomFrom(VersionType.values());
import org.opensearch.common.unit.TimeValue;
import org.apache.hc.core5.http.HttpEntity;
        Request request = RequestConverters.searchScroll(searchScrollRequest);
        Map<String, String> expectedParams = new HashMap<>();
    }
package org.opensearch.client;
        assertNotNull(request.getEntity());
                IndexRequest indexRequest = new IndexRequest(index).id(id).source(source, mediaType);
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
                    expectedParams.put("_source", "false");
                    updateRequest.retryOnConflict(randomIntBetween(1, 5));
        Request request = RequestConverters.clearScroll(clearScrollRequest);
        }
        DeleteStoredScriptRequest deleteStoredScriptRequest = new DeleteStoredScriptRequest("x-script");
        {
 * KIND, either express or implied.  See the License for the
            deprecationLogger
            }
        assertEquals(updateRequest.docAsUpsert(), parsedUpdateRequest.docAsUpsert());
    }
    }
            if (randomBoolean()) {
        if (frequently()) {
        setRandomIndicesOptions(fieldCapabilitiesRequest::indicesOptions, fieldCapabilitiesRequest::indicesOptions, indicesOptionsParams);
        assertEquals("/_msearch", request.getEndpoint());
        Request request = RequestConverters.getScript(getStoredScriptRequest);
        Request request = RequestConverters.createPit(createPitRequest);
                expectedParams.put("refresh", refreshPolicy.getValue());
            XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
            if (multiGetRequest.refresh()) {
        assertNull(request.getEntity());
            expectedParams.put("expand_wildcards", "closed");
            assertEquals(mediaType.mediaTypeWithoutParameters(), request.getEntity().getContentType());
        int nbItems = randomIntBetween(10, 100);
        for (int i = 0; i < numberOfSearchRequests; i++) {
        assertEquals(request.ifSeqNo(), parsedRequest.ifSeqNo());
        }
import org.opensearch.script.mustache.MultiSearchTemplateRequest;
        bulkRequest.add(requests);
        assertEquals(
        assertEquals(expectedParams, request.getParameters());
        ClearScrollRequest clearScrollRequest = new ClearScrollRequest();
            getRequest.realtime(realtime);
    }
    }
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
        } else {
                exception.getMessage()
        Map<String, String> expectedParams = new HashMap<>();
        // non-deterministic order.
    static void setRandomWaitForActiveShards(
            }
        if (randomBoolean()) {
        String id = randomAlphaOfLengthBetween(3, 10);
import org.opensearch.search.aggregations.support.ValueType;
                expectedParams.put("slices", AbstractBulkByScrollRequest.AUTO_SLICES_VALUE);
        if (randomBoolean()) {
            expectedParams.put("if_primary_term", Long.toString(primaryTerm));
        // Create a random request.
            String clusterManagerTimeout = randomTimeValue();
            assertEquals("/%2Ffoo", endpointBuilder.build());
import java.util.Arrays;
 */
                String[] storedFields = new String[numStoredFields];
    }
import org.opensearch.action.admin.cluster.storedscripts.DeleteStoredScriptRequest;
            TermVectorsRequest tvRequest = new TermVectorsRequest(index, id);
            }
        assertEquals(0, request.getParameters().size());
        if (randomBoolean()) {
        }
import org.opensearch.client.indices.AnalyzeRequest;
        setRandomClusterManagerTimeout(
                expectedParams.put("preference", preference);
            indicesOptions = IndicesOptions.fromOptions(
            updateByQueryRequest.setQuery(new TermQueryBuilder("foo", "fooval"));
        if (Strings.hasLength(index)) {
            requests[i] = docWriteRequest;
        String index = String.join(",", indices);
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("///foo");
            }
        }
        }
            }
        }
                updateRequest.upsert(new IndexRequest().source(singletonMap("field", "value"), mediaType));
        RankEvalSpec spec = new RankEvalSpec(
        assertEquals(endpoint.toString(), request.getEndpoint());
        SearchSourceBuilder searchSourceBuilder = createTestSearchSourceBuilder();
import org.opensearch.index.rankeval.RatedRequest;
        SearchTemplateRequest searchTemplateRequest = new SearchTemplateRequest(searchRequest);
            String exclude = randomAlphaOfLengthBetween(3, 10);
            setter.accept(clusterManagerTimeout);
    private static String randomFields(String[] fields) {
                getRequest.preference(preference);
            }
        // passed through
        Float requestsPerSecond;
                    );
                item.storedFields(generateRandomStringArray(16, 8, false));
        assertEquals("/index/type/id", RequestConverters.endpoint("index", "type", "id"));
            if (randomBoolean()) {
                emptyMap(),
                RemoteInfo.DEFAULT_CONNECT_TIMEOUT
        assertEquals(endpoint, request.getEndpoint());
        assertEquals(HttpPost.METHOD_NAME, multiRequest.getMethod());
            endpoint.add(index);
            countRequest.routing(randomAlphaOfLengthBetween(3, 10));
        assertThat(RequestConverters.analyze(analyzeRequest).getEndpoint(), equalTo("/_analyze"));
                    searchSourceBuilder.aggregation(
        expectedParams.put(RestSearchAction.TYPED_KEYS_PARAM, "true");
            bulkRequest.add(new IndexRequest("index").id("1").source(singletonMap("field", "value"), xContentType));
            SearchTemplateRequest searchTemplateRequest = new SearchTemplateRequest(searchRequest);
            countRequest.minScore((float) randomIntBetween(1, 10));
        setRandomIndicesOptions(updateByQueryRequest::setIndicesOptions, updateByQueryRequest::indicesOptions, expectedParams);
        String searchEndpoint = randomFrom("_" + randomAlphaOfLength(5));
                if (randomBoolean()) {
                }
            () -> enforceSameContentType(new IndexRequest().source(singletonMap("field", "value"), XContentType.YAML), bulkContentType)
        if (Strings.hasLength(index)) {
    static void setRandomHumanReadable(Consumer<Boolean> setter, Map<String, String> expectedParams) {
                getRequest.version(version);
        Map<String, String> expectedParams
        }
            WriteRequest.RefreshPolicy refreshPolicy = randomFrom(WriteRequest.RefreshPolicy.values());
                false,
            RequestConverters.update(updateRequest);
        deleteByQueryRequest.indices(randomIndicesNames(1, 5));
        Request request = RequestConverters.sourceExists(getRequest);
        assertEquals(
        expectedParams.put("wait_for_completion", Boolean.TRUE.toString());
        }
            reindexRequest.setScroll(TimeValue.parseTimeValue(ts, "scroll"));
        setRandomRefreshPolicy(indexRequest::setRefreshPolicy, expectedParams);
