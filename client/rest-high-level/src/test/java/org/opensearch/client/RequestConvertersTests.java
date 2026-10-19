        } else {
            Request request = RequestConverters.bulk(bulkRequest);  
        String[] indices = randomIndicesNames(0, 5);
            updateRequest.doc(new IndexRequest().source(singletonMap("field", "doc"), MediaTypeRegistry.JSON));
            assertEquals("/%2F%2Ffoo", endpointBuilder.build());
            Map<String, String> expectedParams = new HashMap<>();
            expectedParams.put("requests_per_second", Float.toString(requestsPerSecond));
        CreatePitRequest createPitRequest = new CreatePitRequest(new TimeValue(1, TimeUnit.DAYS), true, indices);  
                String routing = randomAlphaOfLengthBetween(3, 10);
        Request request = RequestConverters.multiGet(multiGetRequest);
import org.opensearch.index.rankeval.RatedRequest;  
        // Verify that the resulting REST request looks as expected.  
    }  
        {
        }  
        }  
    }
            } else {  
        CountRequest countRequest = new CountRequest();
import org.opensearch.index.rankeval.PrecisionAtK;  
        assertEquals(
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("index", "type", "this|is|the|id");
        }  
                if (randomBoolean()) {
        try (XContentParser parser = createParser(entityContentType.xContent(), entity.getContent())) {  
 */
        assertEquals(endpoint.toString(), request.getEndpoint());
        variants.add(
        Request request = RequestConverters.mtermVectors(mtvRequest);
        String type = randomAlphaOfLengthBetween(3, 10);
        setRandomTimeout(
        }  
        }  
            });
        expectedParams.put("max_concurrent_shard_requests", Integer.toString(searchRequest.getMaxConcurrentShardRequests()));
            // frequently set the search source to have some content, otherwise leave it  
            DocWriteRequest<?> docWriteRequest;
 * compatible open source license.
        }  
                randomBoolean(),
            expectedParams.put("scroll_size", Integer.toString(batchSize));  
        if (searchRequest.getPreFilterShardSize() != null) {  
        TaskId taskId = new TaskId(randomAlphaOfLength(10), randomIntBetween(1, 100));
                UpdateRequest updateRequest = (UpdateRequest) originalRequest;  
            expectedParams.put("timeout", timeout);
            scriptParams.put("field", "name");
    }  
            } else {  
import org.opensearch.action.bulk.BulkShardRequest;
            Collections.singletonList(new RatedRequest("queryId", Collections.emptyList(), new SearchSourceBuilder())),
        );
    }  
            countRequest.minScore((float) randomIntBetween(1, 10));  
            DocWriteRequest<?> parsedRequest = parsedBulkRequest.requests().get(i);
        assertToXContentBody(searchTemplateRequest, request.getEntity());  
            bulkRequest.add(new IndexRequest("index").id("1").source(singletonMap("field", "value"), xContentType));  
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("/foo");
                    );
        assertEquals(endpoint.toString(), request.getEndpoint());
        assertEquals(expectedParams, request.getParameters());  
        }  
        assertEquals(numSearchRequests, searchRequests.size());
            assertEquals("/index/type/this%2Fis%2Fthe%2Fid", endpointBuilder.build());
            expectedParams.put("preference", preference);
                docWriteRequest = createRequest;
    private static void doTestGetSource(BiFunction<String, String, GetSourceRequest> requestFunction) throws IOException {  
        getAndExistsTest(RequestConverters::get, HttpGet.METHOD_NAME);
            setter.accept(timeout);
        searchTemplateRequest.setSimulate(true); // Setting simulate true means the template should only be rendered.  
        assertEquals(expectedParams, request.getParameters());  
            expectedParams.put("timeout", defaultTimeout.getStringRep());
            setRandomVersionType(getRequest::versionType, expectedParams);  
        DeletePitRequest deletePitRequest = new DeletePitRequest(pitIdsList);
                "Mismatching content-type found for request with content-type [SMILE], " + "previous requests have content-type [JSON]",  
        }
        });
                exception.getMessage()
    }  
    }  
                RemoteInfo.DEFAULT_CONNECT_TIMEOUT  
        setRandomVersion(deleteRequest, expectedParams);
        ExplainRequest explainRequest = new ExplainRequest(index, id);  
        if (randomBoolean()) {
        BulkRequest bulkRequest = new BulkRequest();
        }
                expectedParams.put("slices", AbstractBulkByScrollRequest.AUTO_SLICES_VALUE);
        setRandomIndicesOptions(searchRequest::indicesOptions, searchRequest::indicesOptions, expectedParams);
                boolean refresh = randomBoolean();
        }
    }
    public void testCreatePit() throws IOException {
                    searchSourceBuilder.suggest(
            BytesReference source = RandomObjects.randomSource(random(), mediaType);
        Request request = RequestConverters.count(countRequest);
        {
        assertEquals(REQUEST_BODY_CONTENT_TYPE.mediaTypeWithoutParameters(), request.getEntity().getContentType());
                updateRequest.doc(new IndexRequest().source(singletonMap("field", "value"), mediaType));
            for (int i = 0; i < nbFields; i++) {  
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
                    : FetchSourceContext.DO_NOT_FETCH_SOURCE;
    static void setRandomIncludeDefaults(Consumer<Boolean> setter, Map<String, String> expectedParams) {
            searchRequest.setPreFilterShardSize(randomIntBetween(2, Integer.MAX_VALUE));
import org.opensearch.core.xcontent.MediaType;
        BytesReference expectedBytes = org.opensearch.core.xcontent.XContentHelper.toXContent(
            assertEquals(originalRequest.opType(), parsedRequest.opType());
        if (randomBoolean()) {
        }
        assertEquals(HttpPost.METHOD_NAME, request.getMethod());  
        SearchRequest searchRequest = new SearchRequest(indices);
                item.version(randomNonNegativeLong());  
                "http",  
        byte[] expectedBytes = MultiSearchTemplateRequest.writeMultiLineFormat(  
        }
        Map<String, String> expectedParams = new HashMap<>();  
    }
            rankEvalRequest.searchType(randomFrom(SearchType.CURRENTLY_SUPPORTED));  
            bulkRequest.add(  
            getRequest.realtime(realtime);  
            }  
            String routing = randomAlphaOfLengthBetween(3, 10);  
            if (docAsUpsert) {  
        UpdateRequest updateRequest = new UpdateRequest(index, id);  
        // non-deterministic order.
        if (Strings.hasLength(index)) {  
        if (randomBoolean()) {
        setRandomTimeout(putStoredScriptRequest::timeout, AcknowledgedRequest.DEFAULT_ACK_TIMEOUT, expectedParams);
        assertToXContentBody(multiGetRequest, request.getEntity());  
        // passed through
                indexRequest.opType(DocWriteRequest.OpType.CREATE);
        searchTemplateRequest.setScriptParams(scriptParams);
        setRandomTimeout(indexRequest::timeout, ReplicationRequest.DEFAULT_TIMEOUT, expectedParams);  
        }
        if (randomBoolean()) {  
                    randomizeFetchSourceContextParams(updateRequest::fetchSource, new HashMap<>());  
        }
        SearchRequest searchRequest = new SearchRequest();
        expectedParams.put(RestSearchAction.TYPED_KEYS_PARAM, "true");
        if (randomBoolean()) {
        if (randomBoolean()) {
            setRandomSearchParams(searchRequest, expectedParams);
        if (Strings.hasLength(index)) {
                // elsewhere
            reindexRequest.setSourceBatchSize(randomInt(100));
        String id = randomAlphaOfLengthBetween(3, 10);
            searchScrollRequest.scroll(randomPositiveTimeValue());
            BytesReference source = RandomObjects.randomSource(random(), xContentType);
            builder.endObject();  
    private static void setRandomVersion(DocWriteRequest<?> request, Map<String, String> expectedParams) {
                long version = randomLong();  
        }
            expectedParams.put("slices", "1");
            expectedParams
            String index = randomAlphaOfLengthBetween(3, 10);  
            builder.endObject();  
        if (randomBoolean()) {
        String endpoint = "/_search/point_in_time/_all";
        SearchTemplateRequest searchTemplateRequest = new SearchTemplateRequest(searchRequest);  
            tvRequest.setRouting(routing);  
        assertEquals(REQUEST_BODY_CONTENT_TYPE.mediaTypeWithoutParameters(), request.getEntity().getContentType());
            countRequest.source(searchSourceBuilder);
        String index = randomAlphaOfLengthBetween(3, 10);  
        }
        }  
    public void testSearchNullIndicesAndTypes() {  
            expectedParams.put("timeout", timeout.getStringRep());
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("foo/bar");  
        assertThat(request.getParameters(), Matchers.hasEntry("pipeline", "xyz"));  
        } else {
                if (randomBoolean()) {
        }  
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
        }  
    static void setRandomClusterManagerTimeout(Consumer<String> setter, Map<String, String> expectedParams) {
    public void testMultiTermVectorsWithType() throws IOException {
        Map<String, String> expectedParams
            assertEquals("/" + index + "/_create/" + id, request.getEndpoint());  
    public void testEndpoint() {
        assertEquals(HttpGet.METHOD_NAME, request.getMethod());  
            searchRequest.scroll((Scroll) null);
        } else {  
        assertToXContentBody(reindexRequest, request.getEntity());
        assertEquals(  
        try (XContentParser parser = createParser(xContentType.xContent(), entity.getContent())) {  
        if (randomBoolean()) {
        expectedParams.put(RestSearchAction.TYPED_KEYS_PARAM, "true");
            requests[i] = docWriteRequest;  
            requests.add(searchRequest);  
        TermVectorsRequest tvRequest = new TermVectorsRequest(index, id);
            }  
import org.opensearch.action.update.UpdateRequest;
        assertEquals(expectedParams, request.getParameters());
    }
        assertNull(request.getEntity());
            BulkRequest bulkRequest = new BulkRequest();  
        bulkRequest.pipeline("xyz");
        updateByQueryRequest.indices(randomIndicesNames(1, 5));
        );
        UpdateByQueryRequest updateByQueryRequest = new UpdateByQueryRequest();  
        }  
            assertEquals("/index/type/this%7Cis%7Cthe%7Cid", endpointBuilder.build());  
                throw new UnsupportedOperationException("optype [" + opType + "] not supported");
    }  
        if (!joinedIndices.isEmpty()) {
        }  
            getRequest.preference(preference);
            TermVectorsRequest tvRequest = new TermVectorsRequest(index, type, id);
        assertEquals(Collections.emptyMap(), request.getParameters());  
                    ? FetchSourceContext.FETCH_SOURCE
            reindexRequest.setAbortOnVersionConflict(false);
        assertThat(request.getParameters(), hasKey("fields"));
                item.routing(randomAlphaOfLength(4));  
        if (randomBoolean()) {
            assertEquals("/%2F%2Ffoo@bar", endpointBuilder.build());  
        assertToXContentBody(mtvRequest, request.getEntity());
            assertEquals("/%2F%2F%2Ffoo", endpointBuilder.build());
            String preference = randomAlphaOfLengthBetween(3, 10);
        }
        assertEquals(HttpPost.METHOD_NAME, request.getMethod());  
        }
import org.opensearch.common.collect.Tuple;  
        setRandomIfSeqNoAndTerm(deleteRequest, expectedParams);
    }
            getRequest.realtime(realtime);
        String type = frequently() ? randomAlphaOfLengthBetween(3, 10) : MapperService.SINGLE_MAPPING_NAME;  
        }
        );  
        if (updateRequest.upsertRequest() != null) {  
import org.opensearch.search.builder.SearchSourceBuilder;  
import org.opensearch.action.search.CreatePitRequest;
import org.opensearch.index.reindex.ReindexRequest;
        );
        assertEquals(HttpGet.METHOD_NAME, request.getMethod());  
                assertEquals(updateRequest.fetchSource(), parsedUpdateRequest.fetchSource());
        assertThat(RequestConverters.analyze(analyzeRequest).getEndpoint(), equalTo("/_analyze"));
import static org.hamcrest.Matchers.hasKey;
                IndicesOptions.fromOptions(  
        MultiGetRequest multiGetRequest = new MultiGetRequest();
        MultiGetRequest.Item item = new MultiGetRequest.Item(randomAlphaOfLength(4), randomAlphaOfLength(4));
        variants.add(
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("a", "b");  
        }
            }  
    }
        String id = randomBoolean() ? randomAlphaOfLengthBetween(3, 10) : null;
        }
            searchRequest.setBatchedReduceSize(SearchRequest.DEFAULT_BATCHED_REDUCE_SIZE);
            // batched reduce size is currently not set-able on a per-request basis as it is a query string parameter only  
        assertEquals(updateRequest.script(), parsedUpdateRequest.script());  
            explainRequest.routing(routing);
            assertEquals("/%2Fpart1/%2F%2Fpart2/%2F%2F%2Fpart3", endpointBuilder.build());
        assertToXContentBody(explainRequest, request.getEntity());  
        }  
                    expectedParams.put("refresh", "true");
        String id = randomAlphaOfLengthBetween(3, 10);
            bulkRequest.add(new DeleteRequest("index", "0"));
        assertEquals("/_msearch", request.getEndpoint());
        String method = HttpPost.METHOD_NAME;
        }
    private static void randomizeFetchSourceContextParams(Consumer<FetchSourceContext> consumer, Map<String, String> expectedParams) {
        Request request = RequestConverters.clearScroll(clearScrollRequest);
        assertEquals(HttpPost.METHOD_NAME, request.getMethod());  
            // Create a random request.  
            if (randomBoolean()) {
            setter.accept(versionType);  
            boolean realtime = randomBoolean();
        final GetSourceRequest getRequest = requestFunction.apply(index, id);
            assertEquals(
        assertEquals(expectedParams, request.getParameters());
        assertEquals(HttpPost.METHOD_NAME, request.getMethod());  
                    searchSourceBuilder.addRescorer(  
                expectedParams.put("realtime", "false");
            VersionType versionType = randomFrom(VersionType.values());
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("");
        }  
 * this work for additional information regarding copyright
        }
        Map<String, String> indicesOptionsParams = new HashMap<>();  
        } else {
        } else if (getter.get().expandWildcardsClosed()) {
        if (randomBoolean()) {
        assertEquals(expectedParams, request.getParameters());
            assertEquals(MediaTypeRegistry.JSON.mediaTypeWithoutParameters(), request.getEntity().getContentType());
            }
        }  
    }  
        if (randomBoolean()) {  
        String searchEndpoint = randomFrom("_" + randomAlphaOfLength(5));
        assertThat(request.getParameters(), equalTo(expectedParams));
import java.util.concurrent.TimeUnit;
        Request request = RequestConverters.searchScroll(searchScrollRequest);  
import org.opensearch.action.DocWriteRequest;  
            if (refreshPolicy != WriteRequest.RefreshPolicy.NONE) {
            if (refresh) {
            if (multiGetRequest.realtime() == false) {  
        DeleteByQueryRequest deleteByQueryRequest = new DeleteByQueryRequest();  
        for (int i = 0; i < numberOfRequests; i++) {  
        }
import org.opensearch.index.reindex.AbstractBulkByScrollRequest;
    public void testMultiSearchTemplate() throws Exception {
            updateRequest.upsert(new IndexRequest().source(singletonMap("field", "upsert"), XContentType.YAML));  
        assertThat(request.getEndpoint(), equalTo("/_scripts/" + deleteStoredScriptRequest.id()));  
            }
import org.opensearch.client.core.GetSourceRequest;
            deleteByQueryRequest.setAbortOnVersionConflict(false);
            bulkRequest.add(new DeleteRequest("index", "2"));
                getRequest.refresh(refresh);  
                assertEquals(indexRequest.getPipeline(), parsedIndexRequest.getPipeline());  
        // Create a simple request.
            if (humanReadable) {  
        expectedParams.put("keep_alive", "1d");
        assertEquals(endpoint.toString(), request.getEndpoint());
                    searchSourceBuilder.query(new TermQueryBuilder(randomAlphaOfLengthBetween(3, 10), randomAlphaOfLengthBetween(3, 10)));
        setRandomWaitForActiveShards(reindexRequest::setWaitForActiveShards, ActiveShardCount.DEFAULT, expectedParams);
        }
        Map<String, String> expectedParams = new HashMap<>();
        String[] indices = randomIndicesNames(0, 5);  
import org.opensearch.action.admin.cluster.storedscripts.PutStoredScriptRequest;  
        assertEquals(updateRequest.docAsUpsert(), parsedUpdateRequest.docAsUpsert());
                if (randomBoolean()) {
        }  
        setRandomIndicesOptions(deleteByQueryRequest::setIndicesOptions, deleteByQueryRequest::indicesOptions, expectedParams);  
            expectedParams.put("requests_per_second", "-1");
                    randomBoolean()  
            updateRequest.setRefreshPolicy(refreshPolicy);
            int retryOnConflict = randomIntBetween(0, 5);  
    private static void setRandomVersionType(Consumer<VersionType> setter, Map<String, String> expectedParams) {  
    }  
                    msearchDefault.ignoreAliases(),
        GetRequest getRequest = new GetRequest(index, id);
        IllegalArgumentException exception = expectThrows(  
    public void testSourceExists() throws IOException {
            expectedParams.put("conflicts", "proceed");
            assertEquals(originalRequest.ifPrimaryTerm(), parsedRequest.ifPrimaryTerm());
import static org.opensearch.client.RequestConverters.REQUEST_BODY_CONTENT_TYPE;  
            true,  
                searchRequest.source(searchSourceBuilder);
        Request request = RequestConverters.bulk(bulkRequest);
                    true,  
        StringJoiner endpoint = new StringJoiner("/", "/", "");
        Map<String, String> expectedParams = new HashMap<>();
import org.opensearch.client.core.MultiTermVectorsRequest;
        assertEquals(HttpDelete.METHOD_NAME, request.getMethod());
            if (local) {
import org.opensearch.index.query.TermQueryBuilder;
        assertEquals("/" + index + "/_explain/" + id, request.getEndpoint());  
        assertToXContentBody(tvRequest, request.getEntity());
    }  
                expectedParams.put("slices", AbstractBulkByScrollRequest.AUTO_SLICES_VALUE);
        }
                consumer.accept(fetchSourceContext);  
    static String[] randomIndicesNames(int minIndicesNum, int maxIndicesNum) {
        {
                assertToXContentEquivalent(indexRequest.source(), parsedIndexRequest.source(), mediaType);
                indexRequest.setPipeline(pipeline);  
            IllegalArgumentException.class,  
    }
        Map<String, String> expectedParams = new HashMap<>();
        assertThat(request.getParameters(), equalTo(expectedParams));  
        }
            float requestsPerSecond = (float) randomDoubleBetween(0.0, 10.0, false);
        }  
    public void testGet() {  
        assertEquals("/_bulk", request.getEndpoint());
            assertEquals(originalRequest.version(), parsedRequest.version());
            expectedParams.put("preference", preference);  
                expectedParams.put("refresh", refreshPolicy.getValue());  
            if (randomBoolean()) {
        assertEquals(mediaType, enforceSameContentType(indexRequest, mediaType));
        }
                // No need to return a very complex SearchSourceBuilder here, that is tested
                }
                randomizeFetchSourceContextParams(item::fetchSourceContext, new HashMap<>());  
            } else {
                    .upsert(new IndexRequest().source(singletonMap("field", "value"), XContentType.SMILE))
        endpoint.add("_search/template");
            }  
            }
                + "previous requests have content-type ["
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
        }
        assertEquals(expectedParams, multiRequest.getParameters());  
            multiGetRequest.refresh(randomBoolean());
        setRandomSearchParams(searchRequest, expectedParams);  
                reindexRequest.setSize(randomIntBetween(100, 1000));  
        }
    public void testDeletePit() throws IOException {
    public void testExplain() throws IOException {
import org.opensearch.action.support.ActiveShardCount;
        );  
            if (randomBoolean()) {
        TermVectorsRequest tvRequest = new TermVectorsRequest(index, type, id);  
            String index = randomAlphaOfLengthBetween(3, 10);
        );
        expectedParams.put("ignore_unavailable", Boolean.toString(getter.get().ignoreUnavailable()));
import java.util.Collections;  
            String preference = randomAlphaOfLengthBetween(3, 10);
        String index = randomAlphaOfLengthBetween(3, 10);
            assertEquals("/foo+bar", endpointBuilder.build());
        assertEquals("/", request.getEndpoint());  
                + mediaType
                }  
            updateByQueryRequest.setQuery(new TermQueryBuilder("foo", "fooval"));  
            );  
            updateRequest.scriptedUpsert(randomBoolean());
        bulkRequest.add(new IndexRequest("test").id("12").source(MediaTypeRegistry.JSON, "field", "bulk2"));
import org.opensearch.action.search.SearchRequest;
            if (multiGetRequest.refresh()) {  
import java.util.function.Supplier;
            searchRequest.scroll((Scroll) null);  
                randomBoolean(),  
            expectedParams.put("requests_per_second", Float.toString(requestsPerSecond));
        if (randomBoolean()) {  
            reindexRequest.setSourceQuery(new TermQueryBuilder("foo", "fooval"));
        setRandomClusterManagerTimeout(putStoredScriptRequest, expectedParams);  
            assertEquals(expectedParams, request.getParameters());
            getRequest.refresh(refresh);  
            if (retryOnConflict > 0) {
                    false,
            TimeValue clusterManagerTimeout = TimeValue.parseTimeValue(randomTimeValue(), "random_cluster_manager_timeout");
        return excludesParam.toString();
            }  
        }
    }
        {
    static void setRandomClusterManagerTimeout(Consumer<TimeValue> setter, TimeValue defaultTimeout, Map<String, String> expectedParams) {
            endpoint.add(index);
        if (randomBoolean()) {  
            endpoint.add(index);
                String[] excludes = new String[numExcludes];  
        assertEquals(5, request.getParameters().size());
        for (Map.Entry<String, String> param : indicesOptionsParams.entrySet()) {  
            expectedParams.put("max_docs", Integer.toString(size));
            ActiveShardCount activeShardCount = ActiveShardCount.parseString(waitForActiveShardsString);
        // Verify that the resulting REST request looks as expected.
            boolean refresh = randomBoolean();
        for (Map.Entry<String, String> param : expectedParams.entrySet()) {
        String[] indices = randomIndicesNames(0, 5);
        StringJoiner endpoint = new StringJoiner("/", "/", "");
        }
import org.opensearch.core.xcontent.ToXContent;
import org.opensearch.script.mustache.MultiSearchTemplateRequest;
        // Verify that the resulting REST request looks as expected.
                expectedParams.put("slices", AbstractBulkByScrollRequest.AUTO_SLICES_VALUE);
            explainRequest.storedFields(storedFields);  
        }
        BulkRequest bulkRequest = new BulkRequest();  
        assertToXContentBody(searchScrollRequest, request.getEntity());
        {
            multiSearchRequest.indicesOptions(),
                IndicesOptions.fromOptions(
                expectedParams.put("routing", routing);
        } else {  
        if (randomBoolean()) {  
        }
                }  
                }
        MediaType bulkContentType = randomBoolean() ? mediaType : null;
        Float requestsPerSecond;
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("foo^bar");
        StringJoiner endpoint = new StringJoiner("/", "/", "");  
        assertEquals(request.ifSeqNo(), parsedRequest.ifSeqNo());
            }
            if (randomBoolean()) {
                    searchSourceBuilder.from(randomIntBetween(0, Integer.MAX_VALUE));
            MediaType mediaType = randomFrom(MediaTypeRegistry.JSON, XContentType.SMILE);
            }
            String routing = randomAlphaOfLengthBetween(3, 10);
        StringJoiner endpoint = new StringJoiner("/", "/", "");  
        }
        // Verify that the resulting REST request looks as expected.  
        Exception e = expectThrows(NullPointerException.class, () -> new RethrottleRequest(null, 1.0f));  
        XContentType xContentType = randomFrom(XContentType.values());  
        expectedParams.put("ccs_minimize_roundtrips", Boolean.toString(searchRequest.isCcsMinimizeRoundtrips()));
        CheckedBiConsumer<SearchRequest, XContentParser, IOException> consumer = (searchRequest, p) -> {
            searchRequest.searchType(randomFrom(SearchType.CURRENTLY_SUPPORTED));  
import org.apache.hc.client5.http.classic.methods.HttpGet;
        {
    public void testClearScroll() throws IOException {
        expectedParams.put("allow_partial_pit_creation", "true");
        String endpoint = "/_search/point_in_time";
                UpdateRequest parsedUpdateRequest = (UpdateRequest) parsedRequest;
    }
            if (randomBoolean()) {  
            assertEquals("/index/type%232/id", endpointBuilder.build());
        setRandomCountParams(countRequest, expectedParams);  
        joiner.add(String.join(",", deleteByQueryRequest.indices()));
        if (randomBoolean()) {
            indexRequest.version(randomFrom(Versions.MATCH_ANY, Versions.MATCH_DELETED));
    private static void doTestSourceExists(BiFunction<String, String, GetSourceRequest> requestFunction) throws IOException {
        String id = randomAlphaOfLengthBetween(3, 10);
        }
        assertToXContentBody(createPitRequest, request.getEntity());  
            putStoredScriptRequest.content(BytesReference.bytes(builder), xContentType);
        exception = expectThrows(  
            updateByQueryRequest.setScript(new Script("ctx._source.last = \"lastname\""));  
        assertEquals("/", request.getEndpoint());
            expectedParams.put("routing", "=cat");  
            expectedParams.put("slices", "1");
        Request request = RequestConverters.fieldCaps(fieldCapabilitiesRequest);
        Request request = RequestConverters.search(searchRequest, searchEndpoint);  
        setRandomClusterManagerTimeout(
            expectedParams.put("cluster_manager_timeout", defaultTimeout.getStringRep());
            String[] storedFields = generateRandomStringArray(10, 5, false, false);
        }
            new BytesArray(EntityUtils.toByteArray(request.getEntity())),  
import org.opensearch.client.core.CountRequest;  
            assertToXContentEquivalent(updateRequest.upsertRequest().source(), parsedUpdateRequest.upsertRequest().source(), xContentType);
                    msearchDefault.expandWildcardsHidden(),
            deleteByQueryRequest.setSlices(slices);
    public static SearchRequest createTestSearchRequest(String[] indices, Map<String, String> expectedParams) {
        assertEquals(HttpGet.METHOD_NAME, request.getMethod());  
        int numberOfRequests = randomIntBetween(0, 32);
        }
                expectedParams.put("refresh", "true");
        }  
                .addPathPartAsIs("cache/clear");
            if (randomBoolean()) {
        IndexRequest indexRequest = new IndexRequest(index);  
        String endpoint = "/_render/template";
        }  
        expectedParams.put("wait_for_completion", Boolean.TRUE.toString());  
            // scroll is not supported in the current msearch or msearchtemplate api, so unset it:
        Request request = RequestConverters.explain(explainRequest);
import static org.hamcrest.Matchers.hasEntry;  
    }
            expectedParams.put("slices", "1");
import org.opensearch.index.query.QueryBuilders;
        searchScrollRequest.scrollId(randomAlphaOfLengthBetween(5, 10));
import org.opensearch.script.Script;
            expectedParams.put("allow_partial_search_results", Boolean.toString(searchRequest.allowPartialSearchResults()));  
            // specified from msearch api, so unset other options:
        } else {
            expectedParams.put("scroll", searchRequest.scroll().keepAlive().getStringRep());
        assertEquals(REQUEST_BODY_CONTENT_TYPE.mediaTypeWithoutParameters(), request.getEntity().getContentType());
            tvRequest.setFields(fields);  
            if (realtime == false) {
            bulkRequest.add(new DeleteRequest("index", "0"));
        assertEquals(bulkRequest.numberOfActions(), parsedBulkRequest.numberOfActions());
        assertEquals(expectedParams, request.getParameters());  
            }
        }
import org.opensearch.test.OpenSearchTestCase;
            getRequest.routing(routing);  
            updateRequest.routing(routing);
        assertEquals(updateRequest.scriptedUpsert(), parsedUpdateRequest.scriptedUpsert());
import org.opensearch.search.suggest.SuggestBuilder;
        assertEquals(0, request.getParameters().size());
            tvRequest.setFields(fields);
                docWriteRequest.routing(randomAlphaOfLength(10));  
    }  
        SearchScrollRequest searchScrollRequest = new SearchScrollRequest();
        }
 */  
        assertEquals("requestsPerSecond needs to be positive value but was [-5.0]", e.getMessage());
            expectedParams.put("timeout", BulkShardRequest.DEFAULT_TIMEOUT.getStringRep());  
        setRandomRefreshPolicy(bulkRequest::setRefreshPolicy, expectedParams);  
        String[] fields;  
        }
            }
        MultiTermVectorsRequest mtvRequest = new MultiTermVectorsRequest();  
        IllegalStateException exception = expectThrows(IllegalStateException.class, () -> {  
    }  
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("cluster1:index1,index2").addPathPartAsIs("_search");
            expectedParams.put("preference", searchRequest.preference());  
        Request request = RequestConverters.update(updateRequest);
            assertEquals("/" + index + "/_doc", request.getEndpoint());
                IndexRequest indexRequest = (IndexRequest) originalRequest;  
            searchRequest.preference(randomAlphaOfLengthBetween(3, 10));
            RequestConverters.endpoint(new String[] { "index1", "index2" }, "_endpoint", new String[] { "suffix1", "suffix2" })
        for (int i = 0; i < numberOfSearchRequests; i++) {
            deleteByQueryRequest.setQuery(new TermQueryBuilder("foo", "fooval"));
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("index", "type", "id#1");  
            endpoint.add(index);  
    public void testMultiGetWithType() throws IOException {  
            } else {
        }
        assertEquals(xContentType.mediaTypeWithoutParameters(), RequestConverters.createContentType(xContentType).getMimeType());
            }
            assertEquals("/foo+bar", endpointBuilder.build());  
        {  
        Map<String, String> expectedParams = new HashMap<>();
import org.opensearch.action.search.SearchType;  
        Request request = RequestConverters.putScript(putStoredScriptRequest);  
        assertEquals(indexRequest.getContentType().mediaTypeWithoutParameters(), entity.getContentType());
                expectedParams.put("refresh", "true");
        HttpEntity entity = request.getEntity();  
        assertEquals(endpoint, request.getEndpoint());  
    public void testPutScript() throws Exception {
    }  
        MediaType requestContentType = mediaType == MediaTypeRegistry.JSON ? XContentType.SMILE : MediaTypeRegistry.JSON;  
            String timeout = randomTimeValue();
        Map<String, String> expectedParams = new HashMap<>();  
        }
            BulkRequest bulkRequest = new BulkRequest();
 * ownership. Elasticsearch licenses this file to you under  
        IndexRequest indexRequest = new IndexRequest().source(singletonMap("field", "value"), mediaType);  
            "Unsupported content-type found for request with content-type [YAML], only JSON and SMILE are supported",
        assertIfSeqNoAndTerm(updateRequest, parsedUpdateRequest);
            setter.accept(refreshPolicy);
            UpdateRequest updateRequest = new UpdateRequest("index", "0");  
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
            rethrottleRequest = new RethrottleRequest(taskId, requestsPerSecond);
        joiner.add(String.join(",", updateByQueryRequest.indices()));  
        if (randomBoolean()) {
        String index = randomAlphaOfLengthBetween(3, 10);  
        setRandomRefreshPolicy(deleteRequest::setRefreshPolicy, expectedParams);
    public void testAnalyzeRequest() throws Exception {
            () -> enforceSameContentType(new IndexRequest().source(singletonMap("field", "value"), XContentType.YAML), bulkContentType)
    /**
        assertEquals(HttpPost.METHOD_NAME, request.getMethod());  
                int numIncludes = randomIntBetween(0, 5);
            Streams.readFully(inputStream, content);
                    searchSourceBuilder.collapse(new CollapseBuilder(randomAlphaOfLengthBetween(3, 10)));
        Map<String, String> expectedParams = new HashMap<>();
        endpoint.add(searchEndpoint);  
        assertEquals(updateRequest.detectNoop(), parsedUpdateRequest.detectNoop());  
import org.apache.hc.core5.http.io.entity.ByteArrayEntity;
                if (updateRequest.doc() != null) {
                if (randomBoolean()) {  
            assertNull(parsedUpdateRequest.upsertRequest());  
            String routing = randomAlphaOfLengthBetween(3, 10);  
        assertEquals(HttpPost.METHOD_NAME, request.getMethod());
        int numberOfRequests = randomIntBetween(0, 5);
            searchTemplateRequest.setScript("{\"query\": { \"match\" : { \"{{field}}\" : \"{{value}}\" }}}");
                if (randomBoolean()) {  
            getRequest.preference(preference);
        setRandomVersionType(deleteRequest::versionType, expectedParams);  
    static void setRandomHumanReadable(Consumer<Boolean> setter, Map<String, String> expectedParams) {
        if (randomBoolean()) {
            builder.startObject();
            }
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("index", "type", "this/is/the/id");
        }
            if (randomBoolean()) {  
            assertEquals("/-%23index1,index%232/type/id", endpointBuilder.build());  
            expectedParams.put("scroll", ts);
        String index = String.join(",", indices);  
        expectedParams.put(RestSearchAction.TYPED_KEYS_PARAM, "true");
            String preference = randomAlphaOfLength(4);  
        assertEquals(expectedParams, request.getParameters());  
        parsedBulkRequest.add(content, 0, content.length, mediaType);  
            endpoint.add(joinedIndices);  
                if (randomBoolean()) {  
            } else if (opType == DocWriteRequest.OpType.UPDATE) {
            DocWriteRequest.OpType opType = originalRequest.opType();
        Map<String, String> indicesOptionsParams = new HashMap<>();
        Map<String, Object> scriptParams = new HashMap<>();  
import org.opensearch.index.reindex.UpdateByQueryRequest;  
            assertEquals("/中文", endpointBuilder.build());  
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();  
        }
    public static SearchSourceBuilder createTestSearchSourceBuilder() {
            expectedParams.put("routing", routing);
import java.io.InputStream;  
        assertEquals("/_search/scroll", request.getEndpoint());
        assertToXContentBody(searchRequest.source(), request.getEntity());
import java.util.Locale;
        Request request = RequestConverters.rankEval(rankEvalRequest);
            if (randomBoolean()) {
        assertEquals(  
            } else {
    }
            REQUEST_BODY_CONTENT_TYPE.xContent(),
                expectedParams.put("slices", Integer.toString(slices));  
            reindexRequest.setRequestsPerSecond(requestsPerSecond);
            SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(p, false);
        if (randomBoolean()) {  
        assertEquals(endpoint.toString(), request.getEndpoint());
            String[] indices = randomIndicesNames(0, 5);
        }
            searchRequest.setBatchedReduceSize(randomIntBetween(2, Integer.MAX_VALUE));  
        doTestGetSource((index, id) -> new GetSourceRequest(index, id));
            // only expand_wildcards, ignore_unavailable and allow_no_indices can be
                if (randomBoolean()) {  
            final long seqNo = randomNonNegativeLong();
                updateByQueryRequest.setMaxDocs(size);
        Request request = RequestConverters.search(searchRequest, searchEndpoint);  
        assertToXContentBody(spec, request.getEntity());
                }
        }  
                expectedParams.put("human", String.valueOf(humanReadable));
        variants.add(new Tuple<String, Supplier<Request>>("_reindex", () -> RequestConverters.rethrottleReindex(rethrottleRequest)));
        assertEquals(endpoint, request.getEndpoint());
                    searchSourceBuilder.highlighter(new HighlightBuilder().field(randomAlphaOfLengthBetween(3, 10)));
        ActiveShardCount defaultActiveShardCount,  
            assertEquals("/foo%2Fbar", endpointBuilder.build());
            if (randomBoolean()) {
            bulkRequest.add(new DeleteRequest("index", "3"));
        Map<String, String> expectedParams = new HashMap<>();  
            if (slices == 0) {
import org.opensearch.action.support.WriteRequest;  
        assertEquals(
                if (realtime == false) {  
import org.opensearch.index.query.MatchAllQueryBuilder;  
        assertEquals(HttpGet.METHOD_NAME, request.getMethod());
        Consumer<ActiveShardCount> setter,
                if (randomBoolean()) {  
import org.opensearch.action.search.DeletePitRequest;
        }
import org.opensearch.common.unit.TimeValue;
        StringJoiner endpoint = new StringJoiner("/", "/", "");
                String excludesParam = randomFields(excludes);
            assertEquals("/%2Ffoo@bar", endpointBuilder.build());
        }
        String[] indices = randomIndicesNames(0, 5);
import org.hamcrest.Matchers;  
        {
    }
                updateRequest.upsert(new IndexRequest().source(singletonMap("field", "value"), mediaType));
        }
        );
        }
    }
                consumer.accept(new FetchSourceContext(true, includes, excludes));
            assertEquals(originalRequest.ifSeqNo(), parsedRequest.ifSeqNo());
            }
                docWriteRequest = new DeleteRequest(index, id);  
    }
                searchSourceBuilder.from(randomInt(10));
                getRequest.preference(preference);
            exception.getMessage()
        } else {  
            }
        assertEquals(HttpGet.METHOD_NAME, request.getMethod());  
    public void testTermVectorsWithType() throws IOException {
        }
import org.opensearch.search.rescore.QueryRescorerBuilder;
        if (randomBoolean()) {  
                    searchSourceBuilder.size(randomIntBetween(0, Integer.MAX_VALUE));
    }  
import org.opensearch.search.collapse.CollapseBuilder;
            mtvRequest.add(tvRequest);
            );
    public void testBulk() throws IOException {  
        String index = String.join(",", indices);
            String[] fields = generateRandomStringArray(10, 5, false, false);
        if (randomBoolean()) {
            new Tuple<String, Supplier<Request>>("_delete_by_query", () -> RequestConverters.rethrottleDeleteByQuery(rethrottleRequest))  
        setRandomClusterManagerTimeout(request::clusterManagerNodeTimeout, expectedParams);  
        if (frequently()) {  
        endpoint.add("_field_caps");
import org.opensearch.index.rankeval.RankEvalSpec;
    }
            fields = generateRandomStringArray(10, 5, false, false);
                IndexRequest indexRequest = new IndexRequest(index).id(id).source(source, mediaType);  
        setRandomTimeout(reindexRequest::setTimeout, ReplicationRequest.DEFAULT_TIMEOUT, expectedParams);  
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart(Strings.EMPTY_ARRAY);
        if (randomBoolean()) {
 * specific language governing permissions and limitations
            null,
        assertEquals("/" + index + "/_doc/" + id, request.getEndpoint());
        assertNull(request.getEntity());  
 *
            expectedParams.put("cluster_manager_timeout", ClusterManagerNodeRequest.DEFAULT_CLUSTER_MANAGER_NODE_TIMEOUT.getStringRep());
        putStoredScriptRequest.id(id);  
        } else {
        Map<String, String> expectedParams = new HashMap<>();
            deleteByQueryRequest.setScroll(TimeValue.parseTimeValue(ts, "scroll"));  
        if (randomBoolean()) {  
        if (randomBoolean()) {  
        Request request = RequestConverters.mtermVectors(mtvRequest);
            IndicesOptions msearchDefault = new MultiSearchRequest().indicesOptions();
        Map<String, String> expectedParams = new HashMap<>();
                updateByQueryRequest.setSize(size);
        }  
import org.opensearch.action.search.MultiSearchRequest;  
            reindexRequest.setDestRouting("=cat");  
        if (randomBoolean()) {
        MultiSearchRequest multiSearchRequest = new MultiSearchRequest();
        String[] indices = randomIndicesNames(0, 5);  
        }  
        assertEquals(endpoint.toString(), request.getEndpoint());
        assertEquals(HttpHead.METHOD_NAME, request.getMethod());
            bulkRequest.add(new DeleteRequest("index", "0"));  
                }
        expectedParams.put("ignore_throttled", Boolean.toString(indicesOptions.ignoreThrottled()));  
        if (randomBoolean()) {
        DocWriteRequest<?>[] requests = new DocWriteRequest<?>[nbItems];
import org.opensearch.common.lucene.uid.Versions;  
        if (randomBoolean()) {
            expectedParams.put("conflicts", "proceed");
            endpoint.add(index);
            searchTemplateRequest.setProfile(randomBoolean());  
            if (slices == 0) {  
        assertEquals(mediaType.mediaTypeWithoutParameters(), request.getEntity().getContentType());
                    randomlyGenerated.allowNoIndices(),
            multiGetRequest.preference(preference);
        }
        if (Strings.hasLength(index)) {  
        }  
        assertNotNull(request.getEntity());
public class RequestConvertersTests extends OpenSearchTestCase {
        {
        if (randomBoolean()) {
        // test illegal RethrottleRequest values
import org.apache.hc.client5.http.classic.methods.HttpHead;  
        assertEquals(
        if (randomBoolean()) {
            expectedParams.put("timeout", ReplicationRequest.DEFAULT_TIMEOUT.getStringRep());  
        setRandomIfSeqNoAndTerm(updateRequest, new HashMap<>()); // if* params are passed in the body
    }
import org.opensearch.index.VersionType;
            final long primaryTerm = randomLongBetween(1, 200);
        endpoint.add("_count");  
            if (randomBoolean()) {
 * SPDX-License-Identifier: Apache-2.0
            "Unsupported content-type found for request with content-type [CBOR], only JSON and SMILE are supported",
            expectedParams.put("max_concurrent_searches", Integer.toString(multiSearchTemplateRequest.maxConcurrentSearchRequests()));
            countRequest.query(new MatchAllQueryBuilder());
                true,
        {
        RethrottleRequest rethrottleRequest;  
        assertEquals("taskId cannot be null", e.getMessage());
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("/foo/bar");
            }  
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("//foo/bar");  
        searchTemplateRequest.setScriptType(ScriptType.INLINE);  
        StringJoiner joiner = new StringJoiner("/", "/", "");
import java.util.function.Function;
    public void testUpdate() throws IOException {
        expectedParams.put("group_by", "none");
        }
            updateByQueryRequest.setScroll(TimeValue.parseTimeValue(ts, "scroll"));
import java.util.StringJoiner;  
        {  
            request.setIfPrimaryTerm(primaryTerm);  
    static void setRandomClusterManagerTimeout(TimedRequest request, Map<String, String> expectedParams) {  
    public void testDelete() {
            expectedParams.put("routing", routing);
                String storedFieldsParam = randomFields(storedFields);
        for (int i = 0; i < fields.length; i++) {  
            s -> request.setTimeout(TimeValue.parseTimeValue(s, request.getClass().getName() + ".timeout")),  
        // Create a random request.
        } else {  
        assertEquals(expectedParams, request.getParameters());
                    searchSourceBuilder.aggregation(
            updateByQueryRequest.setSlices(slices);  
    }  
            String storedFieldsParams = randomFields(storedFields);
            expectedBody,
        // rarely skip setting the search source completely
        }  
 * Licensed to Elasticsearch under one or more contributor  
            expectedParams.put("requests_per_second", "-1");
            excludesParam.append(exclude);  
        assertEquals("/_count", request.getEndpoint());
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
                randomBoolean(),  
        } else {
            null,  
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("a").addPathPartAsIs("_endpoint");
            updateRequest.script(mockScript("_value + 1"));
        }  
        }  
import static org.hamcrest.CoreMatchers.equalTo;
                IndexRequest parsedIndexRequest = (IndexRequest) parsedRequest;
                if (randomBoolean()) {  
import org.opensearch.action.support.IndicesOptions;
        assertEquals("/" + searchEndpoint, request.getEndpoint());
        assertNull(request.getEntity());  
                expectedParams.put("version_type", versionType.name().toLowerCase(Locale.ROOT));
                    searchSourceBuilder.explain(randomBoolean());
            XContentType xContentType = randomFrom(XContentType.CBOR, XContentType.YAML);
            }
                9200,
        {
        StringJoiner endpoint = new StringJoiner("/", "/", "");  
import org.opensearch.core.common.Strings;
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;  
            } else {
package org.opensearch.client;
            assertNull(request.getEntity());
    public void testReindex() throws IOException {
            assertEquals("/a/b/c/_endpoint", endpointBuilder.build());
            randomizeFetchSourceContextParams(explainRequest::fetchSourceContext, expectedParams);
    }
    public void testSearch() throws Exception {  
            expectedParams.put("version", Long.toString(Versions.MATCH_DELETED));  
        Request request = RequestConverters.ping();  
        }
import org.apache.hc.core5.http.HttpEntity;  
                expectedParams.put("local", String.valueOf(local));
                String routing = randomAlphaOfLengthBetween(3, 10);
import org.opensearch.core.tasks.TaskId;
        }  
            "Update request cannot have different content types for doc [JSON] and upsert [YAML] documents",
        assertToXContentBody(countRequest, request.getEntity());
            exception.getMessage()
        SearchRequest searchRequest = createTestSearchRequest(indices, expectedParams);
        if (Strings.hasLength(index)) {
            getRequest.routing(routing);
        if (randomBoolean()) {
        if (randomBoolean()) {
    }
    }
            if (versionType != VersionType.INTERNAL) {
    private static void setRandomSearchParams(SearchRequest searchRequest, Map<String, String> expectedParams) {
        BulkRequest parsedBulkRequest = new BulkRequest();
        assertEquals(HttpHead.METHOD_NAME, request.getMethod());  
        searchRequest.source(searchSourceBuilder);
        }
        if (id != null) {
            } else if (opType == DocWriteRequest.OpType.UPDATE) {
    public void testDeleteAllPits() {
            bulkRequest.timeout(timeout);  
import java.util.HashMap;
        if (randomBoolean()) {  
        }  
        expectedParams.put("scroll", reindexRequest.getScrollTime().getStringRep());
            reindexRequest.setRemoteInfo(remoteInfo);
        assertToXContentBody(indexAnalyzeRequest, request.getEntity());
            }
            scriptParams.put("value", randomAlphaOfLengthBetween(2, 5));
                expectedParams.put("include_defaults", String.valueOf(includeDefaults));  
 * software distributed under the License is distributed on an
        Map<String, String> expectedParams = new HashMap<>();
        }
        if (randomBoolean()) {  
            expectedParams.put(RethrottleRequest.REQUEST_PER_SECOND_PARAMETER, Float.toString(requestsPerSecond));  
import java.util.HashSet;
            searchRequest.scroll(randomTimeValue());
                            new CompletionSuggestionBuilder(randomAlphaOfLengthBetween(3, 10))
                deleteByQueryRequest.setSize(size);
        Request request = RequestConverters.deleteScript(deleteStoredScriptRequest);
            setRandomIfSeqNoAndTerm(indexRequest, expectedParams);
    public void testGetSource() throws IOException {
            assertEquals("/", endpointBuilder.build());  
        {  
    }
        }
            assertEquals("/a/b", endpointBuilder.build());
            multiSearchTemplateRequest,
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.bytes.BytesArray;
        for (Map.Entry<String, String> param : indicesOptionsParams.entrySet()) {
        }
            }
            String waitForActiveShardsString;
        FieldCapabilitiesRequest fieldCapabilitiesRequest = new FieldCapabilitiesRequest().indices(indices)
            DocWriteRequest.OpType opType = randomFrom(DocWriteRequest.OpType.values());
            assertEquals(mediaType.mediaTypeWithoutParameters(), request.getEntity().getContentType());
            () -> enforceSameContentType(new IndexRequest().source(singletonMap("field", "value"), requestContentType), mediaType)
            String index = randomAlphaOfLength(5);
    public void testRenderSearchTemplate() throws Exception {  
                + "]",  
            searchTemplateRequest.setSearchPipeline("pipeline");
        MediaType entityContentType = MediaType.fromMediaType(entity.getContentType());
import org.opensearch.index.mapper.MapperService;
    static void setRandomWaitForActiveShards(Consumer<ActiveShardCount> setter, Map<String, String> expectedParams) {  
            assertEquals("/foo%20bar", endpointBuilder.build());
            }
                expectedParams.put("realtime", "false");
            float requestsPerSecond = (float) randomDoubleBetween(0.0, 10.0, false);
            assertEquals("/index/type/id%231", endpointBuilder.build());
        assertEquals(REQUEST_BODY_CONTENT_TYPE.mediaTypeWithoutParameters(), request.getEntity().getContentType());
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("//foo");  
            reindexRequest.setScroll(TimeValue.parseTimeValue(ts, "scroll"));
        }  
    public void testUpdateByQuery() throws IOException {
        }
            RequestConverters.endpoint(new String[] { "index1", "index2" }, new String[] { "type1", "type2" }, "_endpoint")  
        assertEquals(expectedBytes, new BytesArray(EntityUtils.toByteArray(actualEntity)));
    }
            expectedParams.put("expand_wildcards", "none");
        if (randomBoolean()) {  
        if (hasFields) {  
        }
            boolean docAsUpsert = randomBoolean();
            IllegalArgumentException.class,
    }
            if (frequently()) {
                searchSourceBuilder.size(randomIntBetween(20, 100));
            setter.accept(humanReadable);
            multiGetRequest.realtime(randomBoolean());
        assertEquals(method, request.getMethod());
        }
import java.util.function.Consumer;  
        if (randomBoolean()) {
        }
        getAndExistsTest(RequestConverters::exists, HttpHead.METHOD_NAME);
            assertEquals("/" + variant.v1() + "/" + taskId + "/_rethrottle", request.getEndpoint());
            Request request = variant.v2().get();
        if (randomBoolean()) {
    private static void setRandomCountParams(CountRequest countRequest, Map<String, String> expectedParams) {
            String clusterManagerTimeout = randomTimeValue();  
        Supplier<IndicesOptions> getter,
        indexRequest.id(id);  
        if (randomBoolean()) {
        }  
            Request request = RequestConverters.bulk(new BulkRequest().add(updateRequest));
            defaultTimeout,
        for (int i = 0; i < numberOfRequests; i++) {  
        StringJoiner endpoint = new StringJoiner("/", "/", "");
        }  
        Request request = RequestConverters.getScript(getStoredScriptRequest);  
        }  
        StringBuilder excludesParam = new StringBuilder();
                    assertToXContentEquivalent(updateRequest.doc().source(), parsedUpdateRequest.doc().source(), mediaType);  
            }
                + "], "  
            updateByQueryRequest.setPipeline("my_pipeline");  
    }  
        );  
import static org.opensearch.search.RandomSearchRequestGenerator.randomSearchRequest;  
        }
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("foo+bar");
            expectedParams.put("expand_wildcards", "closed");
        Map<String, Object> scriptParams = new HashMap<>();
            assertThat(request.getParameters(), hasEntry(param.getKey(), param.getValue()));  
                    false,
        Request request = RequestConverters.deletePit(deletePitRequest);  
        } else {
        assertEquals(5, request.getParameters().size());  
import org.opensearch.index.rankeval.RestRankEvalAction;
                }
                boolean fetchSource = randomBoolean();
        if (randomBoolean()) {
            }
        setRandomClusterManagerTimeout(getStoredScriptRequest, expectedParams);
        }
            builder.startObject("script").field("lang", "painless").field("source", "Math.log(_score * 2) + params.multiplier").endObject();
        } else {  
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("index", "type#2", "id");  
            String timeout = randomTimeValue();
    }
        final int numSearchRequests = randomIntBetween(1, 10);
        Map<String, String> expectedParams = new HashMap<>();  
                expectedParams.put("version", Long.toString(version));
            }
        }
        if (randomBoolean()) {  
        String[] fields = generateRandomStringArray(5, 10, false, false);  
            UpdateRequest updateRequest = new UpdateRequest();
        scriptParams.put("field", "name");
                }
        searchTemplateRequest.setProfile(randomBoolean());
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
    static void setRandomTimeoutTimeValue(Consumer<TimeValue> setter, TimeValue defaultTimeout, Map<String, String> expectedParams) {
        {  
            request.setIfSeqNo(seqNo);  
            int waitForActiveShardsInt = randomIntBetween(-1, 5);
        searchTemplateRequest.setScriptParams(scriptParams);  
            reindexRequest.setDestOpType("create");
                    msearchDefault.ignoreThrottled()  
        if (randomBoolean()) {  
     */
        SearchSourceBuilder searchSourceBuilder = createTestSearchSourceBuilder();  
            consumer,
        assertToXContentBody(multiGetRequest, request.getEntity());
        if (randomBoolean()) {
            String routing = randomAlphaOfLengthBetween(3, 10);
            setRandomVersionType(indexRequest::versionType, expectedParams);  
            assertEquals("/" + index + "/_doc/" + id, request.getEndpoint());
        String index = String.join(",", indices);
        doTestSourceExists((index, id) -> new GetSourceRequest(index, id));
            reindexRequest.setSlices(slices);  
        assertEquals(HttpDelete.METHOD_NAME, request.getMethod());
                    );
            } else if (opType == DocWriteRequest.OpType.CREATE) {
            );
 *
            searchTemplateRequest.setScriptType(ScriptType.INLINE);
import org.opensearch.client.RequestConverters.EndpointBuilder;
            updateRequest.docAsUpsert(docAsUpsert);
    }
            updateRequest.upsert(new IndexRequest().source(source, xContentType));  
        }
    public void testCreateContentType() {
        assertEquals(expectedParams, request.getParameters());
    public void testGetScriptRequest() {
        if (randomBoolean()) {  
                    randomlyGenerated.expandWildcardsClosed(),
                false,
    }
        assertThat(request.getEntity(), nullValue());  
        expectThrows(NullPointerException.class, () -> new SearchRequest((String[]) null));
        if (randomBoolean()) {
        assertEquals("/index/type/id/_endpoint", RequestConverters.endpoint("index", "type", "id", "_endpoint"));
import org.opensearch.core.xcontent.MediaTypeRegistry;  
            IndicesOptions randomlyGenerated = searchRequest.indicesOptions();  
        assertEquals(HttpPost.METHOD_NAME, multiRequest.getMethod());
            MultiGetRequest.Item item = new MultiGetRequest.Item(randomAlphaOfLength(4), randomAlphaOfLength(4));
        assertEquals(5, request.getParameters().size());
            searchRequest.allowPartialSearchResults(randomBoolean());
                }
        expectedParams.put("batched_reduce_size", Integer.toString(searchRequest.getBatchedReduceSize()));
    }
import java.util.ArrayList;
            }
        // a hash set before being added to the request, and can appear in a
        }  
        assertEquals(expectedParams, request.getParameters());
import org.opensearch.action.admin.cluster.storedscripts.GetStoredScriptRequest;
        Map<String, String> expectedParams
        byte[] content = new byte[(int) request.getEntity().getContentLength()];  
            multiSearchRequest.maxConcurrentSearchRequests(randomIntBetween(1, 8));  
        assertEquals("/_reindex", request.getEndpoint());
    static void setRandomTimeout(Consumer<String> setter, TimeValue defaultTimeout, Map<String, String> expectedParams) {  
            tvRequest.setRealtime(false);
        assertEquals(HttpPost.METHOD_NAME, request.getMethod());
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
            String[] fields = generateRandomStringArray(10, 5, false, false);  
    }
        assertEquals(HttpGet.METHOD_NAME, request.getMethod());
    }  
        assertEquals("/_mget", request.getEndpoint());
        if (randomBoolean()) {
            .fields(fields)  
                }
            BytesReference source = RandomObjects.randomSource(random(), xContentType);
        String joinedIndices = String.join(",", indices);  
        expectedParams.put("allow_no_indices", Boolean.toString(indicesOptions.allowNoIndices()));
import static java.util.Collections.emptyMap;
        String[] indices = randomIndicesNames(0, 5);
                if (numExcludes > 0) {
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("中文");
                "remote-host",
import org.opensearch.script.mustache.SearchTemplateRequest;
        }
        assertEquals(HttpGet.METHOD_NAME, request.getMethod());
                            .field(randomAlphaOfLengthBetween(3, 10))  
        assertEquals(0, request.getParameters().size());  
            exception.getMessage()  
    public void testGlobalPipelineOnBulkRequest() throws IOException {  
        assertEquals("/index/type/id", RequestConverters.endpoint("index", "type", "id"));  
        Map<String, String> expectedParams = new HashMap<>();
        expectedParams.put("wait_for_completion", Boolean.TRUE.toString());  
                FetchSourceContext fetchSourceContext = fetchSource  
            expectedParams  
                return searchSourceBuilder;  
        assertEquals(expectedParams, request.getParameters());
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("-#index1,index#2", "type", "id");
            int slices = randomIntBetween(0, 4);  
            deleteByQueryRequest.setRouting("=cat");  
        if (randomBoolean()) {
            if (randomBoolean()) {
            fields[i] = exclude;
        Map<String, String> expectedParams = new HashMap<>();
        String index = randomAlphaOfLengthBetween(3, 10);
    }
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("/part1").addPathPart("//part2").addPathPart("///part3");  
        RankEvalRequest rankEvalRequest = new RankEvalRequest(spec, indices);
            bulkRequest.add(new IndexRequest("index").id("1").source(singletonMap("field", "value"), MediaTypeRegistry.JSON));
            searchTemplateRequest.setScriptParams(scriptParams);  
                BytesReference.bytes(matchAllQuery().toXContent(builder, ToXContent.EMPTY_PARAMS)),
        doTestSourceExists((index, id) -> new GetSourceRequest(index, id).type(type));
            expectedParams.put("max_concurrent_searches", Integer.toString(multiSearchRequest.maxConcurrentSearchRequests()));
        assertToXContentBody(deleteByQueryRequest, request.getEntity());
    }
            expectedParams.put("routing", routing);
    public void testCount() throws Exception {
        }
        assertEquals(HttpPost.METHOD_NAME, request.getMethod());
            int size = randomIntBetween(100, 1000);
            expectedParams.put("routing", countRequest.routing());
import org.opensearch.test.RandomObjects;
        }
        setRandomTimeout(updateByQueryRequest::setTimeout, ReplicationRequest.DEFAULT_TIMEOUT, expectedParams);
        StringJoiner endpoint = new StringJoiner("/", "/", "");
            s -> request.setClusterManagerTimeout(TimeValue.parseTimeValue(s, request.getClass().getName() + ".clusterManagerNodeTimeout")),
    private static void assertIfSeqNoAndTerm(DocWriteRequest<?> request, DocWriteRequest<?> parsedRequest) {
            assertEquals("/a/b/_endpoint", endpointBuilder.build());
        bulkRequest.add(new IndexRequest("test").id("13").source(MediaTypeRegistry.JSON, "field", "bulk3"));
        Request request = RequestConverters.updateByQuery(updateByQueryRequest);
        assertEquals(expectedParams, request.getParameters());
                SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();  
            );  
            expectedParams.put("min_score", String.valueOf(countRequest.minScore()));
        } else if (id != null) {
        assertEquals(method, request.getMethod());
                exception.getMessage()
        for (int i = 0; i < numScrolls; i++) {
        for (int i = 0; i < numberOfRequests; i++) {
        {
                )
            String exclude = randomAlphaOfLengthBetween(3, 10);
                expectedParams.put("stored_fields", storedFieldsParam);  
import org.apache.hc.client5.http.classic.methods.HttpDelete;
            }
                String[] storedFields = new String[numStoredFields];  
            if (randomBoolean()) {
            }
        }  
            indices[i] = "index-" + randomAlphaOfLengthBetween(2, 5).toLowerCase(Locale.ROOT);  
            int batchSize = randomInt(100);
        assertTrue(entity instanceof ByteArrayEntity);
            mtvRequest.add(tvRequest);
            String context = randomAlphaOfLengthBetween(5, 10);
        }
    }
        scriptParams.put("value", "soren");
            EndpointBuilder endpointBuilder = new EndpointBuilder();  
        String[] indices = new String[numIndices];
            builder.startObject();
        }
                excludesParam.append(",");
            false
        }
        }
import org.opensearch.common.CheckedBiConsumer;
                String preference = randomAlphaOfLengthBetween(3, 10);  
        }
            bulkRequest.add(new DeleteRequest("index", "2"));  
        }  
        DeleteRequest deleteRequest = new DeleteRequest(index, id);
                        new TermsAggregationBuilder(randomAlphaOfLengthBetween(3, 10)).userValueTypeHint(ValueType.STRING)
    public void testMultiSearch() throws IOException {
            }  
                expectedParams.put("slices", Integer.toString(slices));
        assertNull(request.getEntity());
            indexRequest.source(builder);
        searchTemplateRequest.setSearchPipeline("pipeline");
            expectedParams.put("if_primary_term", Long.toString(primaryTerm));
    public void testRethrottle() {
            bulkRequest.add(new IndexRequest("index").id("0").source(singletonMap("field", "value"), XContentType.SMILE));  
            clearScrollRequest.addScrollId(randomAlphaOfLengthBetween(5, 10));  
        } else if (indicesOptions.expandWildcardsOpen()) {
            int size = randomIntBetween(100, 1000);  
    }  
        if (randomBoolean()) {  
            boolean humanReadable = randomBoolean();
import org.opensearch.client.indices.AnalyzeRequest;
        if (randomBoolean()) {
import java.util.Map;
        }  
    }  
import org.apache.hc.core5.http.io.entity.EntityUtils;
    public void testPing() {
            deleteByQueryRequest.setRequestsPerSecond(requestsPerSecond);  
            BulkRequest bulkRequest = new BulkRequest();  
        FieldCapabilitiesRequest fieldCapabilitiesRequest = new FieldCapabilitiesRequest().indices(indices).fields(fields);  
        assertEquals(expectedParams, request.getParameters());
        if (randomBoolean()) {  
        Request request = RequestConverters.getSource(getRequest);  
import org.opensearch.action.get.MultiGetRequest;
        List<Tuple<String, Supplier<Request>>> variants = new ArrayList<>();  
            expectedParams.put("pipeline", "my_pipeline");
            expectedParams.put("scroll_size", Integer.toString(batchSize));  
            countRequest.terminateAfter(randomIntBetween(0, Integer.MAX_VALUE));
        }
            } else {
import org.opensearch.index.reindex.RemoteInfo;
        setRandomIndicesOptions(searchRequest::indicesOptions, searchRequest::indicesOptions, expectedParams);
        }  
            countRequest.routing(randomAlphaOfLengthBetween(3, 10));  
                assertEquals(updateRequest.retryOnConflict(), parsedUpdateRequest.retryOnConflict());  
        if (randomBoolean()) {
 * the Apache License, Version 2.0 (the "License"); you may
            setter.accept(clusterManagerTimeout);
        );  
        if (randomBoolean()) {  
                }
import java.util.List;  
        assertEquals("/" + index + "/_update/" + id, request.getEndpoint());
            Map<String, Object> scriptParams = new HashMap<>();  
            }  
        String searchEndpoint = randomFrom("_" + randomAlphaOfLength(5));
            endpoint.add(index);
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("a").addPathPart("b").addPathPartAsIs("_endpoint");
            String type = randomAlphaOfLengthBetween(3, 10);
        return searchSourceBuilder;  
            RequestConverters.update(updateRequest);
        if (randomBoolean()) {  
                item.versionType(randomFrom(VersionType.values()));  
        if (randomBoolean()) {
                            randomAlphaOfLengthBetween(3, 10),  
import org.opensearch.action.bulk.BulkRequest;
    public void testTermVectors() throws IOException {  
        {
        setRandomIndicesOptions(createPitRequest::indicesOptions, createPitRequest::indicesOptions, expectedParams);
        }
        assertToXContentBody(fieldCapabilitiesRequest, request.getEntity());
                if (randomBoolean()) {  
            String id = randomAlphaOfLength(5);
        assertThat(request.getEndpoint(), equalTo("/_scripts/" + getStoredScriptRequest.id()));
import static org.hamcrest.Matchers.nullValue;
            Request request = RequestConverters.bulk(bulkRequest);
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("///foo");
        {
            putStoredScriptRequest.context(context);
        {
        assertEquals("/_mtermvectors", request.getEndpoint());
import org.opensearch.common.xcontent.json.JsonXContent;  
 * license agreements. See the NOTICE file distributed with
            expectedParams.put("pre_filter_shard_size", Integer.toString(searchRequest.getPreFilterShardSize()));
            if (refreshPolicy != WriteRequest.RefreshPolicy.NONE) {
        assertThat(request.getEndpoint(), equalTo("/test_index/_analyze"));  
            if (randomBoolean()) {
                        )
        if (randomBoolean()) {
        endpoint.add(RestRankEvalAction.ENDPOINT);
    public void testSearchTemplate() throws Exception {  
            randomizeFetchSourceContextParams(updateRequest::fetchSource, expectedParams);
        }  
            assertEquals(originalRequest.versionType(), parsedRequest.versionType());  
        String index = randomAlphaOfLengthBetween(3, 10);
        assertThat(request.getParameters(), hasKey("fields"));
/*  
    public void testMultiGet() throws IOException {
            searchRequest.routing(randomAlphaOfLengthBetween(3, 10));
import org.opensearch.search.suggest.completion.CompletionSuggestionBuilder;  
 * GitHub history for details.
            assertEquals("/a/_endpoint", endpointBuilder.build());
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("/foo@bar");
    }  
        multiGetRequest.add(item);  
        }  
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RequestConvertersTests.class);  
        }
            setter.accept(includeDefaults);
    public void testMultiTermVectors() throws IOException {
        }  
            assertNull(parsedUpdateRequest.doc());
import org.opensearch.action.delete.DeleteRequest;  
            updateByQueryRequest.setAbortOnVersionConflict(false);  
        assertEquals(MediaTypeRegistry.JSON.mediaTypeWithoutParameters(), actualEntity.getContentType());
        ReindexRequest reindexRequest = new ReindexRequest();
                int numExcludes = randomIntBetween(0, 5);
                expectedParams.put("preference", preference);
            countRequest.preference(randomAlphaOfLengthBetween(3, 10));
        StringJoiner joiner = new StringJoiner("/", "/", "");
            assertThat(request.getParameters(), hasEntry(param.getKey(), param.getValue()));  
        AnalyzeRequest indexAnalyzeRequest = AnalyzeRequest.withIndexAnalyzer("test_index", "test_analyzer", "Here is some text");  
                getRequest.routing(routing);  
            if (randomBoolean()) {
    public static void setRandomIndicesOptions(
        Request request = RequestConverters.deleteByQuery(deleteByQueryRequest);  
        expectThrows(NullPointerException.class, () -> new SearchRequest().indices((String[]) null));
    public void testSearchScroll() throws IOException {  
        if (randomBoolean()) {
            SearchRequest searchRequest = new SearchRequest(indices);
                    randomBoolean(),
import static org.opensearch.client.RequestConverters.enforceSameContentType;
        );
            assertEquals("/index1,index2/cache/clear", endpointBuilder.build());
            if (randomBoolean()) {
        if (randomBoolean()) {  
                String routing = randomAlphaOfLengthBetween(3, 10);  
        }
        {
        Request request = requestConverter.apply(getRequest);  
import org.opensearch.action.search.ClearScrollRequest;  
        }
        assertEquals(joiner.toString(), request.getEndpoint());
    public void testExists() {  
                boolean realtime = randomBoolean();
    public void testEnforceSameContentType() {
        if (randomBoolean()) {
        if (randomBoolean()) {
        String joinedIndices = String.join(",", indices);
            expectedParams.put("routing", searchRequest.routing());
        Request request = RequestConverters.index(indexRequest);
    public void testDeleteByQuery() throws IOException {
            } else {
        assertEquals(HttpPost.METHOD_NAME, request.getMethod());  
        assertToXContentBody(updateByQueryRequest, request.getEntity());
        DeleteStoredScriptRequest deleteStoredScriptRequest = new DeleteStoredScriptRequest("x-script");
            float requestsPerSecond = (float) randomDoubleBetween(0.0, 10.0, false);
        Request request = RequestConverters.analyze(indexAnalyzeRequest);
import org.opensearch.common.io.Streams;
        }  
        {
        setRandomIndicesOptions(fieldCapabilitiesRequest::indicesOptions, fieldCapabilitiesRequest::indicesOptions, indicesOptionsParams);
        }  
        assertEquals(new BytesArray(expectedBytes), new BytesArray(EntityUtils.toByteArray(actualEntity)));
        PutStoredScriptRequest putStoredScriptRequest = new PutStoredScriptRequest();  
    }
        assertEquals(HttpPost.METHOD_NAME, request.getMethod());
 * not use this file except in compliance with the License.
        assertEquals(HttpDelete.METHOD_NAME, request.getMethod());  
    }  
        updateRequest.detectNoop(randomBoolean());
            int slices = randomIntBetween(0, 4);
        assertToXContentBody(searchTemplateRequest, request.getEntity());
        }
            new PrecisionAtK()
            if (opType == DocWriteRequest.OpType.INDEX) {
        assertEquals("/_msearch/template", multiRequest.getEndpoint());  
        }
        expectedParams.put("search_type", searchRequest.searchType().name().toLowerCase(Locale.ROOT));
        }
            String ts = randomTimeValue();
        expectedParams.put("search_type", rankEvalRequest.searchType().name().toLowerCase(Locale.ROOT));
        assertEquals(request.ifPrimaryTerm(), parsedRequest.ifPrimaryTerm());  
            if (i < fields.length - 1) {
        assertEquals(new HashSet<>(Arrays.asList(fields)), new HashSet<>(Arrays.asList(requestFields)));
        assertToXContentBody(putStoredScriptRequest, request.getEntity());
                + requestContentType
        };
/*  
        assertEquals(HttpGet.METHOD_NAME, request.getMethod());  
            XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
        List<SearchTemplateRequest> searchRequests = multiSearchTemplateRequest.requests();
import org.opensearch.action.admin.cluster.storedscripts.DeleteStoredScriptRequest;
        if (randomBoolean()) {  
            multiSearchTemplateRequest.add(searchTemplateRequest);
        if (randomBoolean()) {
            IllegalArgumentException.class,
        setRandomSearchParams(searchRequest, expectedParams);  
        Request request = RequestConverters.searchTemplate(searchTemplateRequest);
            }
        // Create a random request.
        }  
                getRequest.realtime(realtime);
        Consumer<IndicesOptions> setter,  
        Request request = RequestConverters.deleteAllPits();  
            DocWriteRequest<?> originalRequest = bulkRequest.requests().get(i);
                        new SuggestBuilder().addSuggestion(
    static void setRandomLocal(Consumer<Boolean> setter, Map<String, String> expectedParams) {  
    }
        endpoint.add("_search/point_in_time");
        if (reindexRequest.getRemoteInfo() == null && randomBoolean()) {
            if (randomBoolean()) {
        Request request = RequestConverters.searchTemplate(searchTemplateRequest);
        String id = randomAlphaOfLengthBetween(3, 10);
import org.opensearch.action.support.replication.ReplicationRequest;  
        setRandomRefreshPolicy(indexRequest::setRefreshPolicy, expectedParams);
        XContentType xContentType = randomFrom(XContentType.values());
            expectedParams.put("realtime", "false");
        );
        HttpEntity entity = request.getEntity();  
        Request request = RequestConverters.sourceExists(getRequest);
    }
                    searchSourceBuilder.profile(randomBoolean());
            multiSearchTemplateRequest.maxConcurrentSearchRequests(randomIntBetween(1, 10));
            endpoint.add(joinedIndices);
    }
        assertEquals("/" + index + "/_source/" + id, request.getEndpoint());
        assertEquals(HttpPost.METHOD_NAME, request.getMethod());
        if (randomBoolean()) {
        int numberOfSearchRequests = randomIntBetween(0, 32);  
import org.opensearch.core.xcontent.XContentBuilder;
        MultiSearchTemplateRequest multiSearchTemplateRequest = new MultiSearchTemplateRequest();  
        try (XContentBuilder builder = XContentBuilder.builder(xContentType.xContent())) {
        Request request = RequestConverters.fieldCaps(fieldCapabilitiesRequest);  
        }  
    public void testSourceExistsWithType() throws IOException {
        assertToXContentBody(clearScrollRequest, request.getEntity());  
        }
            exception.getMessage()  
            expectedParams.put("routing", routing);
        List<String> pitIdsList = new ArrayList<>();
    public void testInfo() {
            if (opType != DocWriteRequest.OpType.UPDATE && randomBoolean()) {
 */  
            null,
        if (randomBoolean()) {  
        assertToXContentBody(mtvRequest, request.getEntity());
        if (randomBoolean()) {  
        if (indexRequest.opType() == DocWriteRequest.OpType.CREATE) {
            }  
        CountRequest countRequest = new CountRequest(indices);
        String id = randomAlphaOfLengthBetween(3, 10);
        if (randomBoolean()) {
        if (randomBoolean()) {  
            assertEquals(originalRequest.index(), parsedRequest.index());
        if (randomBoolean()) {  
            // empty but still set it
                deleteRequest.routing(routing);  
        }
        assertEquals("/_mtermvectors", request.getEndpoint());  
        }  
 * Modifications Copyright OpenSearch Contributors. See
        }
            searchRequest.requestCache(randomBoolean());
        }  
        }  
            expectedParams.put("timeout", timeout);
            expectedParams.put("expand_wildcards", "open,closed");
                expectedParams.put("refresh", refreshPolicy.getValue());  
        AnalyzeRequest analyzeRequest = AnalyzeRequest.withGlobalAnalyzer("test_analyzer", "more text");  
                expectedParams.put("doc_as_upsert", "true");
            String id = randomAlphaOfLengthBetween(3, 10);  
import org.opensearch.action.explain.ExplainRequest;
                expectedParams.put("pipeline", pipeline);
        }
                if (randomBoolean()) {
                "pass",  
            }  
        for (int i = 0; i < numSearchRequests; i++) {
            setter.accept(clusterManagerTimeout);
            .indexFilter(QueryBuilders.matchAllQuery());
            );
            bulkRequest.add(new IndexRequest("index").id("0").source(singletonMap("field", "value"), MediaTypeRegistry.JSON));
        MultiTermVectorsRequest mtvRequest = new MultiTermVectorsRequest();
        try (XContentBuilder builder = XContentBuilder.builder(xContentType.xContent())) {  
    }
                    expectedParams.put("realtime", "false");
        UpdateRequest parsedUpdateRequest = new UpdateRequest();  
        if (indexRequest.opType() == DocWriteRequest.OpType.CREATE) {
            }  
    ) {  
            parsedUpdateRequest.fromXContent(parser);
            expectedParams.put("max_docs", Integer.toString(size));  
            expectedParams.put("if_seq_no", Long.toString(seqNo));
        RankEvalSpec spec = new RankEvalSpec(  
                if (randomBoolean()) {  
            boolean realtime = randomBoolean();
            }
                    msearchDefault.allowAliasesToMultipleIndices(),  
        if (randomBoolean()) {
                }
        assertEquals("/" + index + "/_source/" + id, request.getEndpoint());
        }  
    }
        Request request = RequestConverters.bulk(bulkRequest);
            multiGetRequest.add(item);
            assertEquals("/%2Ffoo", endpointBuilder.build());  
            }
            MediaType mediaType = randomFrom(MediaTypeRegistry.JSON, XContentType.SMILE);
        }
        assertEquals(endpoint.toString(), request.getEndpoint());
                expectedParams.put("refresh", "true");  
            expectedParams.put(RethrottleRequest.REQUEST_PER_SECOND_PARAMETER, "-1");  
            // scroll is not supported in the current msearch api, so unset it:
                randomizeFetchSourceContextParams(getRequest::fetchSourceContext, expectedParams);  
                exception.getMessage()
                docWriteRequest.setIfSeqNo(randomNonNegativeLong());  
        if (randomBoolean()) {
    public void testEndpointBuilderEncodeParts() {  
                String[] includes = new String[numIncludes];  
        StringJoiner endpoint = new StringJoiner("/", "/", "");  
        MultiSearchRequest.readMultiLineFormat(
        setRandomWaitForActiveShards(setter, ActiveShardCount.DEFAULT, expectedParams);
        assertEquals(expectedParams, request.getParameters());  
            expectedParams.put("stored_fields", storedFieldsParams);
            rethrottleRequest = new RethrottleRequest(taskId);
        assertToXContentBody(deletePitRequest, request.getEntity());
            assertEquals(originalRequest.routing(), parsedRequest.routing());
        String index = randomAlphaOfLengthBetween(3, 10);  
            expectedParams.put("cluster_manager_timeout", clusterManagerTimeout.getStringRep());  
                } else {
        );  
        setRandomTimeout(deleteStoredScriptRequest::timeout, AcknowledgedRequest.DEFAULT_ACK_TIMEOUT, expectedParams);
        for (int i = 0; i < bulkRequest.numberOfActions(); i++) {  
        Request request = RequestConverters.info();
            if (defaultActiveShardCount.equals(activeShardCount) == false) {
            () -> enforceSameContentType(new IndexRequest().source(singletonMap("field", "value"), XContentType.CBOR), bulkContentType)
        } else {
            expectedParams.put("expand_wildcards", "open");  
 *  
        if (randomBoolean()) {
        if (updateRequest.doc() != null) {
        if (randomBoolean()) {
        }
            assertEquals("/", endpointBuilder.build());
        searchTemplateRequest.setSearchPipeline("pipeline");
        assertEquals(endpoint.toString(), request.getEndpoint());
        assertEquals(endpoint.toString(), request.getEndpoint());  
                }
        }
        } else {  
            reindexRequest.setDestPipeline("my_pipeline");
        Map<String, String> expectedParams = new HashMap<>();
        {
        Request multiRequest = RequestConverters.multiSearchTemplate(multiSearchTemplateRequest);  
                if (numIncludes > 0) {
            searchRequest.indicesOptions(
        if (randomBoolean()) {  
                final UpdateRequest updateRequest = new UpdateRequest(index, id).doc(new IndexRequest().source(source, mediaType));  
        if (randomBoolean()) {  
        Map<String, String> expectedParams = new HashMap<>();  
        setRandomIndicesOptions(fieldCapabilitiesRequest::indicesOptions, fieldCapabilitiesRequest::indicesOptions, indicesOptionsParams);  
        Request request = RequestConverters.termVectors(tvRequest);
            }
        {  
            assertEquals("/foo%5Ebar", endpointBuilder.build());
            );
    }  
                builder.field("field_" + i, i);
                    expectedParams.put("_source_excludes", excludesParam);  
                    updateRequest.retryOnConflict(randomIntBetween(1, 5));  
            setRandomVersion(indexRequest, expectedParams);
        assertEquals(updateRequest.fetchSource(), parsedUpdateRequest.fetchSource());
            int batchSize = randomInt(100);
            );
        for (int i = 0; i < numIndices; i++) {
        }
        } else {  
                int numStoredFields = randomIntBetween(1, 10);
            expectedParams.put("preference", countRequest.preference());
            expectedParams.put("preference", preference);
            if (slices == 0) {
        exception = expectThrows(
        String index = randomAlphaOfLengthBetween(3, 10);  
                if (version != Versions.MATCH_ANY) {
        boolean hasFields = randomBoolean();
                }
            }
        if (randomBoolean()) {
            expectedParams.put("timeout", timeout);
        }
            assertEquals("/cluster1:index1,index2/_search", endpointBuilder.build());  
        } else {  
            }
            }
            if (version != Versions.MATCH_ANY) {  
        if (frequently()) {
        String[] requestFields = Strings.splitStringByCommaToArray(request.getParameters().get("fields"));
        }
            boolean includeDefaults = randomBoolean();  
        assertEquals(HttpPost.METHOD_NAME, request.getMethod());  
import java.util.Arrays;
        assertEquals(HttpPost.METHOD_NAME, request.getMethod());
            expectedParams.put(RethrottleRequest.REQUEST_PER_SECOND_PARAMETER, Float.toString(requestsPerSecond));  
        // as we create SearchSourceBuilder in CountRequest constructor  
    }
        if (randomBoolean()) {  
        int nbFields = randomIntBetween(0, 10);  
        String id = randomAlphaOfLengthBetween(5, 10);
                docWriteRequest = updateRequest;
        MediaType mediaType = randomFrom(MediaTypeRegistry.JSON, XContentType.SMILE);
    }
        if (getter.get().expandWildcardsOpen() && getter.get().expandWildcardsClosed()) {  
        assertEquals(expectedParams, request.getParameters());  
                    assertNull(parsedUpdateRequest.doc());
        scriptParams.put("value", "soren");  
        } else if (getter.get().expandWildcardsOpen()) {
        );  
    private static void setRandomRefreshPolicy(Consumer<WriteRequest.RefreshPolicy> setter, Map<String, String> expectedParams) {
        {
        if (frequently()) {  
            }
            new Tuple<String, Supplier<Request>>("_update_by_query", () -> RequestConverters.rethrottleUpdateByQuery(rethrottleRequest))  
                IndexRequest createRequest = new IndexRequest(index).id(id).source(source, mediaType).create(true);  
        Map<String, String> expectedParams = new HashMap<>();
        // Note that we don't check the field param value explicitly, as field names are
        ClearScrollRequest clearScrollRequest = new ClearScrollRequest();  
        }
        // non-deterministic order.  
        if (randomBoolean()) {  
import org.opensearch.core.xcontent.XContentParser;  
                if (fetchSource == false) {
    }  
        for (int i = 0; i < nbItems; i++) {  
        assertThat(request.getParameters(), equalTo(expectedParams));  
        if (randomBoolean()) {
        assertTrue(entity instanceof ByteArrayEntity);
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("foo+bar");
        bulkRequest.add(new IndexRequest("test").id("11").source(MediaTypeRegistry.JSON, "field", "bulk1"));  
                }  
 * this file be licensed under the Apache-2.0 license or a
                RemoteInfo.DEFAULT_SOCKET_TIMEOUT,
            assertEquals("/%2Ffoo%2Fbar", endpointBuilder.build());  
            searchRequest.setMaxConcurrentShardRequests(randomIntBetween(1, Integer.MAX_VALUE));  
                    expectedParams.put("_source_includes", includesParam);  
            String routing = randomAlphaOfLengthBetween(3, 10);  
            int slices = randomIntBetween(0, 4);
        if (randomBoolean()) {
            bulkRequest.add(new IndexRequest("index").id("4").source(singletonMap("field", "value"), MediaTypeRegistry.JSON));
        assertNull(request.getEntity());  
            String ts = randomTimeValue();
            bulkRequest.add(new IndexRequest("index").id("1").source(singletonMap("field", "value"), MediaTypeRegistry.JSON));
}
        } else {  
    public void testCountNotNullSource() throws IOException {
        }  
            assertEquals(mediaType.mediaTypeWithoutParameters(), request.getEntity().getContentType());
        endpoint.add(index).add(type).add(id).add("_termvectors");
            long version = randomFrom(Versions.MATCH_ANY, Versions.MATCH_DELETED, Versions.NOT_FOUND, randomNonNegativeLong());
        // a hash set before being added to the request, and can appear in a  
        reindexRequest.setSourceIndices("source_idx");  
        }  
                getRequest.version(version);
        return indices;
/*
import org.opensearch.client.core.TermVectorsRequest;  
                    );  
        Map<String, String> expectedParams = new HashMap<>();
                "Mismatching content-type found for request with content-type [JSON], " + "previous requests have content-type [SMILE]",
            updateByQueryRequest.setRequestsPerSecond(requestsPerSecond);  
                }  
            WriteRequest.RefreshPolicy refreshPolicy = randomFrom(WriteRequest.RefreshPolicy.values());  
        // Note that we don't check the field param value explicitly, as field names are  
        String index = String.join(",", indices);  
            updateRequest.doc(new IndexRequest().source(source, xContentType));
        assertEquals("/" + index + "/_doc/" + id, request.getEndpoint());
        assertThat(request.getMethod(), equalTo(HttpDelete.METHOD_NAME));
        int numIndices = randomIntBetween(minIndicesNum, maxIndicesNum);  
                if (refresh) {
            assertEquals(originalRequest.id(), parsedRequest.id());  
    }
            bulkRequest.add(new IndexRequest("index").id("1").source(singletonMap("field", "value"), MediaTypeRegistry.JSON));
        }
            SearchRequest searchRequest = randomSearchRequest(() -> {  
        assertEquals(0, request.getParameters().size());
        assertEquals(endpoint, request.getEndpoint());  
        }
        assertThat(request.getEndpoint(), equalTo("/_scripts/" + id));
    }
        }
        Request request = RequestConverters.delete(deleteRequest);
            setter.accept(timeout);  
            expectedParams.put("scroll", ts);  
        {
        assertNull(request.getEntity());  
            expectedParams.put("request_cache", Boolean.toString(searchRequest.requestCache()));
        assertEquals("/index1,index2/_endpoint", RequestConverters.endpoint(new String[] { "index1", "index2" }, "_endpoint"));  
        return searchRequest;
    ) {
        );
        String id = randomAlphaOfLengthBetween(3, 10);
            TimeValue timeout = TimeValue.parseTimeValue(randomTimeValue(), "random_timeout");  
        setRandomClusterManagerTimeout(deleteStoredScriptRequest, expectedParams);  
        MultiGetRequest multiGetRequest = new MultiGetRequest();
                String pipeline = randomAlphaOfLengthBetween(3, 10);
                new UpdateRequest("index", "2").doc(new IndexRequest().source(singletonMap("field", "value"), MediaTypeRegistry.JSON))
        if (randomBoolean()) {
                    expectedParams.put("_source", "false");
        String index = String.join(",", indices);
    }
                    randomlyGenerated.ignoreUnavailable(),
        }  
            );
            assertThat(request.getParameters(), hasEntry(param.getKey(), param.getValue()));
                if (randomBoolean()) {  
            REQUEST_BODY_CONTENT_TYPE,  
        }
        Map<String, String> expectedParams = new HashMap<>();
        try (InputStream inputStream = request.getEntity().getContent()) {
                "Unsupported content-type found for request with content-type [" + xContentType + "], only JSON and SMILE are supported",  
import org.apache.hc.client5.http.classic.methods.HttpPost;
    public void testFieldCapsWithIndexFilter() throws IOException {  
            explainRequest.preference(preference);  
            setter.accept(activeShardCount);  
    }
        }
                expectedParams.put("retry_on_conflict", String.valueOf(retryOnConflict));  
    }
            IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> RequestConverters.bulk(bulkRequest));
import org.opensearch.index.rankeval.RankEvalRequest;
        {
                false,  
            method = HttpPut.METHOD_NAME;  
            boolean refresh = randomBoolean();  
import org.opensearch.search.aggregations.support.ValueType;
        reindexRequest.setDestIndex("dest_idx");
            String ts = randomTimeValue();
                expectedParams.put("realtime", "false");
        scriptParams.put("field", "name");
        assertEquals("/_search/scroll", request.getEndpoint());
            }
            } else {  
        String[] indices = randomIndicesNames(0, 5);
import org.opensearch.rest.action.search.RestSearchAction;
        assertEquals(endpoint.toString(), request.getEndpoint());
            if (includeDefaults) {
        assertEquals(joiner.toString(), request.getEndpoint());
    }  
        assertEquals(expectedParams, request.getParameters());
        {  
        explainRequest.query(QueryBuilders.termQuery(randomAlphaOfLengthBetween(3, 10), randomAlphaOfLengthBetween(3, 10)));
            updateByQueryRequest.setRouting("=cat");
        List<SearchRequest> requests = new ArrayList<>();  
        }  
                docWriteRequest = indexRequest;
                    searchSourceBuilder.minScore(randomFloat());
import org.opensearch.common.logging.DeprecationLogger;
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("foo bar");  
        Map<String, String> expectedParams = new HashMap<>();  
        if (randomBoolean()) {
        SearchRequest searchRequest = new SearchRequest(indices);  
        if (!joinedIndices.isEmpty()) {
        assertEquals(mediaType, enforceSameContentType(indexRequest, null));
        int numberOfRequests = randomIntBetween(0, 5);
            expectedParams.put("preference", preference);
            expectedParams.put("expand_wildcards", "open,closed");
                }
    static void setRandomClusterManagerTimeout(ClusterManagerNodeRequest<?> request, Map<String, String> expectedParams) {
            if (realtime == false) {  
        assertEquals(expectedParams, request.getParameters());
            assertEquals(  
        String index = randomAlphaOfLengthBetween(3, 10);
            setter.accept(  
        if (frequently()) {
            "/index1,index2/_endpoint/suffix1,suffix2",  
            expectedParams.put("routing", routing);
                waitForActiveShardsString = String.valueOf(waitForActiveShardsInt);  
            SearchTemplateRequest searchTemplateRequest = new SearchTemplateRequest(searchRequest);
            BulkRequest bulkRequest = new BulkRequest();
        }
        expectedParams.put("wait_for_completion", Boolean.TRUE.toString());
        setRandomIndicesOptions(rankEvalRequest::indicesOptions, rankEvalRequest::indicesOptions, expectedParams);
        if (randomBoolean()) {  
            assertEquals(nbFields, parser.map().size());
import org.opensearch.action.fieldcaps.FieldCapabilitiesRequest;
            bulkRequest.add(new UpdateRequest("index", "1").script(mockScript("test")));  
        assertEquals(HttpDelete.METHOD_NAME, request.getMethod());  
    private static String randomFields(String[] fields) {
        // There is some logic around _create endpoint and version/version type  
        assertEquals(new HashSet<>(Arrays.asList(fields)), new HashSet<>(Arrays.asList(requestFields)));  
        {  
        return indicesOptions;
import org.apache.hc.client5.http.classic.methods.HttpPut;
            }
            expectedParams.put("timeout", defaultTimeout.getStringRep());  
import org.opensearch.search.Scroll;  
        setRandomIndicesOptions(updateByQueryRequest::setIndicesOptions, updateByQueryRequest::indicesOptions, expectedParams);
        assertThat(request.getEntity(), nullValue());
    }
 * Unless required by applicable law or agreed to in writing,
        if (randomBoolean()) {
                    msearchDefault.forbidClosedIndices(),
            }
            MediaTypeRegistry.JSON.xContent()
            "/index1,index2/type1,type2/_endpoint",
        }
            }  
        expectedParams.put("ignore_unavailable", Boolean.toString(indicesOptions.ignoreUnavailable()));
        MediaType mediaType = randomFrom(MediaTypeRegistry.JSON, XContentType.SMILE);
        if (randomBoolean()) {
        assertEquals(HttpPost.METHOD_NAME, request.getMethod());
                    randomlyGenerated.expandWildcardsOpen(),  
                waitForActiveShardsString = "all";
        deleteByQueryRequest.indices(randomIndicesNames(1, 5));
        }  
        {
                    randomBoolean(),  
 * under the License.  
        {
        Request request = RequestConverters.reindex(reindexRequest);
        assertNull(request.getEntity());  
import org.opensearch.script.ScriptType;  
            setRandomIndicesOptions(searchRequest::indicesOptions, searchRequest::indicesOptions, expectedParams);  
                deleteByQueryRequest.setMaxDocs(size);  
        );
                reindexRequest.setMaxDocs(randomIntBetween(100, 1000));
        final XContentType xContentType = randomFrom(XContentType.values());  
            }
        assertEquals(
        searchTemplateRequest.setScript("{\"query\": { \"match\" : { \"{{field}}\" : \"{{value}}\" }}}");
        } else {
    public void testSearchNullSource() throws IOException {  
        if (randomBoolean()) {
            }  
            if (searchSourceBuilder.equals(new SearchSourceBuilder()) == false) {  
    private static void setRandomIfSeqNoAndTerm(DocWriteRequest<?> request, Map<String, String> expectedParams) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (indicesOptions.expandWildcardsOpen() && indicesOptions.expandWildcardsClosed()) {  
    }
        String id = randomAlphaOfLengthBetween(3, 10);
            RemoteInfo remoteInfo = new RemoteInfo(
            assertEquals("/%3Clogstash-%7Bnow%2FM%7D%3E/_search", endpointBuilder.build());
            if (randomBoolean()) {
        Map<String, String> expectedParams = new HashMap<>();
        pitIdsList.add("pitId1");  
    static void setRandomWaitForActiveShards(
    public void testUpdateWithDifferentContentTypes() {
        }
            searchRequest.setCcsMinimizeRoundtrips(randomBoolean());
        SearchTemplateRequest searchTemplateRequest = new SearchTemplateRequest();
        {  
            IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> RequestConverters.bulk(bulkRequest));
            deprecationLogger
        GetStoredScriptRequest getStoredScriptRequest = new GetStoredScriptRequest("x-script");
            boolean local = randomBoolean();
                if (randomBoolean()) {
                String includesParam = randomFields(includes);
        String index = randomAlphaOfLengthBetween(3, 10);  
        HttpEntity actualEntity = multiRequest.getEntity();
                    randomBoolean(),
        if (randomBoolean()) {  
    static void assertToXContentBody(ToXContent expectedBody, HttpEntity actualEntity) throws IOException {  
     * Randomize the {@link FetchSourceContext} request parameters.  
        Map<String, String> expectedParams = new HashMap<>();  
                expectedParams.put("routing", routing);
        );
            updateRequest.retryOnConflict(retryOnConflict);
        {  
    private static void getAndExistsTest(Function<GetRequest, Request> requestConverter, String method) {
    }  
            indicesOptions = IndicesOptions.fromOptions(
        joiner.add("_delete_by_query");  
        Request request = RequestConverters.termVectors(tvRequest);
        if (randomBoolean()) {
import org.opensearch.index.reindex.DeleteByQueryRequest;  
                }  
        int nbItems = randomIntBetween(10, 100);
                docWriteRequest.setIfPrimaryTerm(randomLongBetween(1, 200));
            bulkRequest.add(new IndexRequest("index").id("0").source(singletonMap("field", "value"), mediaType));
            String timeout = randomTimeValue();
        {  
            expectedParams.put("context", context);  
        setRandomTimeout(deleteByQueryRequest::setTimeout, ReplicationRequest.DEFAULT_TIMEOUT, expectedParams);
        assertEquals(0, request.getParameters().size());
        XContentType xContentType = randomFrom(XContentType.values());
 * You may obtain a copy of the License at  
        );
                expectedParams.put("slices", Integer.toString(slices));
    }  
import org.opensearch.core.common.bytes.BytesReference;  
        if (randomBoolean()) {
        }
    }
            null,  
        assertEquals("/_mget", request.getEndpoint());
        bulkRequest.add(requests);
            bulkRequest.add(new DeleteRequest("index", "2"));
        // passed through
            if (waitForActiveShardsInt == -1) {  
import org.opensearch.common.xcontent.XContentType;
    public void testEndpointBuilder() {
        }  
            xContentRegistry(),
        }
        }  
            if (randomBoolean()) {
        }
    public void testRankEval() throws Exception {
        if (randomBoolean()) {  
        {
        }
                getRequest.storedFields(storedFields);
        for (Tuple<String, Supplier<Request>> variant : variants) {  
 * KIND, either express or implied.  See the License for the
        assertThat(request.getMethod(), equalTo(HttpGet.METHOD_NAME));
        } else {
                        new QueryRescorerBuilder(new TermQueryBuilder(randomAlphaOfLengthBetween(3, 10), randomAlphaOfLengthBetween(3, 10)))
            assertEquals("/%2F%2Ffoo%2Fbar", endpointBuilder.build());
        assertEquals(MediaTypeRegistry.JSON.mediaTypeWithoutParameters(), actualEntity.getContentType());  
        }
    public void testDeleteScriptRequest() {
        {
        }
        e = expectThrows(IllegalArgumentException.class, () -> new RethrottleRequest(new TaskId("taskId", 1), -5.0f));  
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("<logstash-{now/M}>", "_search");
            BulkRequest bulkRequest = new BulkRequest();
            expectedParams.put("cluster_manager_timeout", clusterManagerTimeout);
                item.storedFields(generateRandomStringArray(16, 8, false));  
        if (randomBoolean()) {
        searchTemplateRequest.setProfile(randomBoolean());
            String preference = randomAlphaOfLengthBetween(3, 10);  
            assertEquals("/", endpointBuilder.build());
    }
        }  
        }
            if (opType == DocWriteRequest.OpType.INDEX) {
            } else if (opType == DocWriteRequest.OpType.DELETE) {
        pitIdsList.add("pitId2");
            expectedParams.put(RethrottleRequest.REQUEST_PER_SECOND_PARAMETER, "-1");  
            multiSearchRequest.add(searchRequest);  
import org.opensearch.action.index.IndexRequest;
            if (randomBoolean()) {
        // Create a random request.
            "Mismatching content-type found for request with content-type ["
        assertEquals(HttpGet.METHOD_NAME, request.getMethod());
        searchTemplateRequest.setScript("template1");
        joiner.add("_update_by_query");
            }
        } else if (indicesOptions.expandWildcardsClosed()) {
        assertEquals(expectedParams, request.getParameters());
        String id = randomAlphaOfLengthBetween(3, 10);  
        }
        String[] fields = generateRandomStringArray(5, 10, false, false);
            deleteByQueryRequest.setBatchSize(batchSize);
                indexRequest.routing(routing);
            if (randomBoolean()) {
        if (Strings.hasLength(index)) {
                }
            IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> RequestConverters.bulk(bulkRequest));
            } else {  
                expectedParams.put("routing", routing);
            WriteRequest.RefreshPolicy refreshPolicy = randomFrom(WriteRequest.RefreshPolicy.values());  
        if (randomBoolean()) {
        assertEquals(requests, multiSearchRequest.requests());  
        } else {
            getRequest.refresh(refresh);
            expectedParams.put("routing", "=cat");
        setRandomWaitForActiveShards(updateRequest::waitForActiveShards, expectedParams);  
                randomBoolean(),
        if (randomBoolean()) {
        } else {  
    }
            }
    public void testFieldCaps() throws IOException {
        }
    public void testBulkWithDifferentContentTypes() throws IOException {
            assertEquals(
            assertEquals(HttpPost.METHOD_NAME, request.getMethod());  
        assertNotNull(request.getEntity());
            requestsPerSecond = (float) randomDoubleBetween(0.0, 100.0, true);
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("//foo@bar");
    public void testIndex() throws IOException {
        setRandomTimeout(deleteRequest::timeout, ReplicationRequest.DEFAULT_TIMEOUT, expectedParams);  
            expectedParams.put("expand_wildcards", "none");
        setRandomIndicesOptions(countRequest::indicesOptions, countRequest::indicesOptions, expectedParams);
            expectedParams.put("expand_wildcards", "closed");
import org.opensearch.action.search.SearchScrollRequest;
import org.opensearch.search.fetch.subphase.FetchSourceContext;
        assertNotNull(request.getEntity());
        expectedParams.put("allow_no_indices", Boolean.toString(getter.get().allowNoIndices()));
        endpoint.add(index).add("_termvectors").add(id);
        Request request = RequestConverters.multiSearch(multiSearchRequest);
        }
import static java.util.Collections.singletonMap;
                )
            request.version(version);
                    expectedParams.put("version", Long.toString(version));  
            EndpointBuilder endpointBuilder = new EndpointBuilder().addCommaSeparatedPathParts(new String[] { "index1", "index2" })  
        }
    static IndicesOptions setRandomIndicesOptions(IndicesOptions indicesOptions, Map<String, String> expectedParams) {  
            if (randomBoolean()) {
        }
            tvRequest.setFields(fields);
    }
import org.opensearch.action.get.GetRequest;  
        Map<String, String> expectedParams = new HashMap<>();
    }  
            expectedParams.put("expand_wildcards", "open");  
                expectedParams.put("wait_for_active_shards", waitForActiveShardsString);
        Request request = RequestConverters.createPit(createPitRequest);
            updateByQueryRequest.setBatchSize(batchSize);
        Map<String, String> expectedParams = new HashMap<>();  
                }
        {  
                emptyMap(),
        Request request = RequestConverters.multiGet(multiGetRequest);
        int numScrolls = randomIntBetween(1, 10);
            updateRequest.timeout(timeout);  
                randomBoolean()
            setter.accept(local);  
        endpoint.add("_field_caps");
                    randomBoolean(),
                "user",
    }  
    }  
        searchTemplateRequest.setScriptType(ScriptType.STORED);  
                null,  
    }  
            EndpointBuilder endpointBuilder = new EndpointBuilder().addPathPart("a", "b", "c").addPathPartAsIs("_endpoint");  
        String[] requestFields = Strings.splitStringByCommaToArray(request.getParameters().get("fields"));  
        expectedParams.put("ignore_throttled", Boolean.toString(getter.get().ignoreThrottled()));  
            }
        final GetSourceRequest getRequest = requestFunction.apply(index, id);  
    static void setRandomTimeout(TimedRequest request, TimeValue defaultTimeout, Map<String, String> expectedParams) {
        if (randomBoolean()) {
            String id = randomAlphaOfLengthBetween(3, 10);
        assertNull(request.getEntity());  
            if (randomBoolean()) {
        assertEquals("/index1,index2", RequestConverters.endpoint(new String[] { "index1", "index2" }));
        Request request = RequestConverters.count(countRequest);  
    }  
        }
            TermVectorsRequest tvRequest = new TermVectorsRequest(index, id);
import java.util.function.BiFunction;
                    indexRequest.setPipeline(randomAlphaOfLength(5));  
        }  
            if (refresh) {
            assertToXContentEquivalent(updateRequest.doc().source(), parsedUpdateRequest.doc().source(), xContentType);
            expectedParams.put("terminate_after", String.valueOf(countRequest.terminateAfter()));  
                }
import java.io.IOException;
    }
