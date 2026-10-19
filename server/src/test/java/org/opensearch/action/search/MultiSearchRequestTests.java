            request.add(searchRequest);
        assertThat(  
    public void testSimpleAddWithCarriageReturn() throws Exception {
            () -> RestMultiSearchAction.parseRequest(restRequest, null, true)  
                    searchRequest.indicesOptions(),  
            ),  
        );
            IndicesOptions.fromOptions(
            searchSourceBuilder.size(randomIntBetween(20, 100));  
import java.util.Map;  
    public void testSerDeWithCancelAfterTimeIntervalParameterAndRandomVersion() throws IOException {
        assertExpandWildcardsValue(
import org.opensearch.common.logging.DeprecationLogger;
        MultiSearchRequest deserializedRequest = copyWriteable(originalRequest, writableRegistry(), MultiSearchRequest::new, version);
    private MultiSearchRequest parseMultiSearchRequest(RestRequest restRequest) throws IOException {  
        FakeRestRequest restRequest = new FakeRestRequest.Builder(xContentRegistry()).withContent(
                    (p, c) -> MatchAllQueryBuilder.fromXContent(p)
        final String requestContent = "{\"index\":\"test\", \"expand_wildcards\" : \"open,closed\"}}\r\n"  
            request.requests().get(0).indicesOptions(),
                true,  
import org.opensearch.test.rest.FakeRestRequest;
 * The OpenSearch Contributors require contributions made to  
        );
                randomBoolean(),
 * specific language governing permissions and limitations
import org.opensearch.core.xcontent.MediaTypeRegistry;
 *
        for (SearchRequest subReq : req.requests()) {
        assertThat(request.requests().size(), equalTo(1));
                    () -> IndicesOptions.fromOptions(randomBoolean(), randomBoolean(), randomBoolean(), randomBoolean())
            Strings.toString(MediaTypeRegistry.JSON, response)  
            assertEquals(expectedValue, value);  
                false,  
                randomBoolean(),
import static org.opensearch.search.RandomSearchRequestGenerator.randomSearchRequest;
            equalTo(IndicesOptions.fromOptions(false, true, true, true, SearchRequest.DEFAULT_INDICES_OPTIONS))  
        assertThat(request.requests().size(), equalTo(4));
            final String value = (String) map.get("expand_wildcards");
        }
    public void testWritingExpandWildcards() throws IOException {  
            ),
        assertThat(request.requests().get(1).preference(), equalTo("_local"));
        RestMultiSearchAction.parseMultiLineRequest(restRequest, SearchRequest.DEFAULT_INDICES_OPTIONS, true, (searchRequest, parser) -> {
import org.opensearch.core.xcontent.XContentBuilder;  
                randomBoolean(),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            request.requests().get(2).indicesOptions(),
        FakeRestRequest restRequest = new FakeRestRequest.Builder(xContentRegistry()).withContent(
    protected NamedXContentRegistry xContentRegistry() {
            IndicesOptions randomlyGenerated = searchRequest.indicesOptions();
        RestRequest restRequestWithNewLine = new FakeRestRequest.Builder(xContentRegistry()).withContent(
            }
                randomBoolean()
        try (XContentBuilder builder = JsonXContent.contentBuilder()) {
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
    public void testEmptyFirstLine1() throws Exception {
                randomBoolean(),  
            request.requests().get(0).indicesOptions(),
        assertExpandWildcardsValue(  
 * license agreements. See the NOTICE file distributed with
            MultiSearchRequest.readMultiLineFormat(  
    }
                deprecationLogger
        MultiSearchRequest request = new MultiSearchRequest();
                randomBoolean(),
                randomBoolean(),
    public void testCancelAfterIntervalAtParentAndFewChildRequest() throws Exception {  
        assertThat(request.requests().size(), equalTo(3));
        assertThat(request.requests().get(0).indices()[0], equalTo("test"));
            assertThat(searchRequest.source().query(), instanceOf(MatchAllQueryBuilder.class));
            + "{\"query\" : {\"match_all\" :{}}}\r\n";
                + "\n"
        );
                + "{}\n"  
                + "in the next major version"
        );
        );  
                    randomlyGenerated.expandWildcardsClosed(),
/*
                    QueryBuilder.class,
            IndicesOptions msearchDefault = SearchRequest.DEFAULT_INDICES_OPTIONS;
        );  
                randomBoolean(),
            new BytesArray(requestContent),
            byte[] originalBytes = MultiSearchRequest.writeMultiLineFormat(originalRequest, mediaType.xContent());  
 * this work for additional information regarding copyright
            "\n"  
        assertExpandWildcardsValue(  
import org.opensearch.search.Scroll;  
            new BytesArray(mserchAction.getBytes(StandardCharsets.UTF_8)),
        final String requestContent = "{\"index\":\"test\", \"ignore_unavailable\" : true, \"unknown_key\" : \"open,closed\"}}\r\n"
                + "{ \"query\": {\"match_all\": {}}}\n"
        assertThat(request.requests().get(0).preference(), nullValue());  
        }
    }
        assertThat(request.requests().size(), equalTo(8));  
    private static MultiSearchRequest createMultiSearchRequest() {
import java.util.Collections;
    public void testEqualsAndHashcode() {
                randomBoolean(),
            SearchRequest searchRequest = createSimpleSearchRequest();  
                true,
        ).build();
 *    http://www.apache.org/licenses/LICENSE-2.0
                new MultiSearchResponse.Item(null, new IllegalStateException("baaaaaazzzz")) },
            );  
            searchRequest.indicesOptions(  
    }
                randomBoolean(),
        );  
                null,
                    new ParseField(MatchAllQueryBuilder.NAME),  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(  
                randomBoolean(),
                true,
            + "\"cancel_after_time_interval\" : \"10s\"}\r\n"
    }
            MediaType mediaType = randomFrom(MediaTypeRegistry.JSON, XContentType.SMILE);  
            assertThat(req.toString(), containsString(subReq.toString()));
            // No need to return a very complex SearchSourceBuilder here, that is tested elsewhere  
                randomBoolean()  
        assertThat(request.requests().get(5).indices(), is(Strings.EMPTY_ARRAY));  
            new BytesArray(requestContent),  
                + "in the next major version"
            searchRequest.scroll((Scroll) null);
 * Unless required by applicable law or agreed to in writing,
        return parseMultiSearchRequest(
        assertWarnings(
                randomBoolean(),
    public void testOnlyParentMSearchRequestWithCancelAfterTimeIntervalParameter() throws IOException {
    }
        assertThat(request.requests().get(2).indices(), is(Strings.EMPTY_ARRAY));
                false,
        List<CheckedRunnable<IOException>> mutators = new ArrayList<>();
                    randomlyGenerated.ignoreUnavailable(),
    public void testToString() {
        mutators.add(() -> mutation.maxConcurrentSearchRequests(randomIntBetween(1, 32)));
                    msearchDefault.forbidClosedIndices(),
            new BytesArray(requestContent),  
                randomBoolean(),  
        );
                null,
                + "}"
                randomBoolean(),
            new BytesArray(requestContent),  
    }  
import java.util.List;
        checkEqualsAndHashCode(createMultiSearchRequest(), MultiSearchRequestTests::copyRequest, MultiSearchRequestTests::mutate);
            // The only formats that support stream separator
                SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(p, false);  
            "open,hidden"
    }
            equalTo(IndicesOptions.fromOptions(false, true, true, false, SearchRequest.DEFAULT_INDICES_OPTIONS))
import org.opensearch.core.xcontent.MediaType;  
                + "{ \"query\": {\"match_all\": {}}}\n"  
    public void testFailWithUnknownKey() {  
import static java.util.Collections.singletonList;  
                randomBoolean(),
    }
                )
                randomBoolean(),
        IllegalArgumentException expectThrows = expectThrows(
        });
import org.opensearch.core.xcontent.NamedXContentRegistry;
    }
        MultiSearchRequest copy = new MultiSearchRequest();  
            IndicesOptions.fromOptions(
                    randomlyGenerated.allowNoIndices(),  
                randomBoolean(),
        );
            equalTo(IndicesOptions.fromOptions(true, true, true, true, SearchRequest.DEFAULT_INDICES_OPTIONS))
 * not use this file except in compliance with the License.
        MultiSearchRequest request = RestMultiSearchAction.parseRequest(restRequest, null, true);  
        ).build();
        );
        copy.indicesOptions(request.indicesOptions());
                randomBoolean(),  
        ).build();
 * compatible open source license.
                true,
        assertThat(request.requests().size(), equalTo(1));
                true,  
        );
        assertThat(request.requests().get(0).indices()[0], equalTo("test0"));  
            "none"  
            new BytesArray(requestContent),
        assertThat(request.requests().get(0).indices()[0], equalTo("test"));
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(MultiSearchRequestTests.class);
        for (int i = 0; i < iters; i++) {
            assertEquals(originalRequest, parsedRequest);
 * You may obtain a copy of the License at  
        assertEquals(3, msearchRequest.requests().size());
        assertThat(
import java.util.concurrent.TimeUnit;
            Map<String, Object> map = XContentHelper.convertToMap(  
                    r.source(searchSourceBuilder);
                true,
        return request;  
        assertThat(request.requests().get(6).searchType(), equalTo(SearchType.DFS_QUERY_THEN_FETCH));
            MultiSearchRequest originalRequest = createMultiSearchRequest();
                consumer,  
        assertThat(request.requests().get(2).indices()[1], equalTo("test1"));
        assertThat(request.requests().get(3).indices(), is(Strings.EMPTY_ARRAY));
        );
        final String requestContent = "{\"index\":\"test\", \"expand_wildcards\" : \"open,closed\"}}\r\n"
        assertThat(  
            copy.maxConcurrentSearchRequests(request.maxConcurrentSearchRequests());
            new FakeRestRequest.Builder(xContentRegistry()).withContent(new BytesArray(data), MediaTypeRegistry.JSON).build()
        assertExpandWildcardsValue(
                false,  
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        assertThat(request.requests().get(6).indices(), is(Strings.EMPTY_ARRAY));
        assertThat(request.requests().get(2).indices()[0], equalTo("test4"));  
 * Licensed to Elasticsearch under one or more contributor  
                randomBoolean(),
            searchSourceBuilder.from(randomInt(10));
            };
                false,
public class MultiSearchRequestTests extends OpenSearchTestCase {  
            equalTo(IndicesOptions.fromOptions(true, true, true, true, SearchRequest.DEFAULT_INDICES_OPTIONS))
        }
import org.opensearch.Version;
                randomBoolean(),  
        assertThat(request.requests().get(2).indices()[1], equalTo("test1"));  
        MultiSearchRequest request = new MultiSearchRequest();
import static org.hamcrest.Matchers.instanceOf;
            MediaTypeRegistry.JSON
                randomBoolean(),  
                randomBoolean(),  
import org.opensearch.core.common.Strings;
            originalRequest.requests().get(0).getCancelAfterTimeInterval(),
    }  
            + "{\"query\" : {\"match_all\" :{}}}\r\n";
        MultiSearchRequest request = parseMultiSearchRequestFromFile("/org/opensearch/action/search/simple-msearch2.json");
        return parseMultiSearchRequest(  
import org.opensearch.common.unit.TimeValue;  
                    msearchDefault.expandWildcardsHidden(),  
                + "{ \"query\": {\"match_all\": {}}}\n"
            );  
        assertThat(request.requests().size(), equalTo(4));  
            // only expand_wildcards, ignore_unavailable and allow_no_indices can be specified from msearch api, so unset other options:  
        MultiSearchRequest request = RestMultiSearchAction.parseRequest(restRequest, null, true);  
                false,
                + "{ \"query\": {\"match_all\": {}}}\n"
    }  
            IndicesOptions.fromOptions(
        if (request.maxConcurrentSearchRequests() > 0) {
            IndicesOptions.fromOptions(
        Version version = VersionUtils.randomVersion(random());  
                parsedRequest.add(r);
            request.requests().get(4).indicesOptions(),
        MultiSearchRequest msearchRequest = RestMultiSearchAction.parseRequest(restRequestWithNewLine, null, true);  
            "closed,hidden"  
 *  
        assertThat(request.requests().get(1).indices()[1], equalTo("test3"));
import java.util.ArrayList;  
            IndicesOptions.fromOptions(  
                randomBoolean(),
            ),
        FakeRestRequest restRequest = new FakeRestRequest.Builder(xContentRegistry()).withContent(
                randomBoolean(),
        return new NamedXContentRegistry(
                false,
                MediaTypeRegistry.JSON.xContent(),
        MultiSearchRequest originalRequest = RestMultiSearchAction.parseRequest(restRequest, null, true);
                true,
        String mserchAction = StreamsUtils.copyToStringFromClasspath("/org/opensearch/action/search/simple-msearch5.json");
                + "\"type\":\"illegal_state_exception\",\"reason\":\"foobar\"},\"status\":500"
        );
        return copy;
                + "{ \"query\": {\"match_all\": {}}}\n"  
        );  
                )
        assertEquals(request.requests().get(1).searchType(), SearchType.DFS_QUERY_THEN_FETCH);  
        FakeRestRequest restRequest = new FakeRestRequest.Builder(xContentRegistry()).withContent(
                randomBoolean()
    }
        assertThat(request.requests().get(0).indices()[0], equalTo("test"));
        }
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
import org.opensearch.action.support.IndicesOptions;
        // verifies that parent msearch parameter value is used for second search request
                randomBoolean(),
        return randomSearchRequest(() -> {
                false,  
import org.opensearch.test.VersionUtils;
    }
        MultiSearchRequest request = parseMultiSearchRequestFromFile("/org/opensearch/action/search/simple-msearch4.json");
            tookInMillis
    @Override
                + "{}\n"  
                randomBoolean()  
                + "{ \"query\": {\"match_all\": {}}}\n"
import static org.hamcrest.Matchers.nullValue;
 * KIND, either express or implied.  See the License for the
            "{\"took\":"  
    }  
import org.opensearch.rest.RestRequest;
                false,
 */  
import org.opensearch.core.common.bytes.BytesReference;
            () -> RestMultiSearchAction.parseRequest(restRequest, null, true)  
import org.opensearch.core.common.bytes.BytesArray;  
            ),
                randomBoolean(),  
        // verifies that child search request parameter value is used for first search request  
        assertThat(request.requests().get(2).routing(), equalTo("123"));
    public void testResponseErrorToXContent() {
        FakeRestRequest restRequest = new FakeRestRequest.Builder(xContentRegistry()).withContent(
        byte[] data = StreamsUtils.copyToBytesFromClasspath(sample);
            IllegalArgumentException.class,
        assertEquals(new TimeValue(10, TimeUnit.SECONDS), request.requests().get(0).getCancelAfterTimeInterval());
            + "{\"query\" : {\"match_all\" :{}}}\r\n";  
        assertExpandWildcardsValue(
/*  
        SearchRequest request = new SearchRequest();
        return mutation;
                + "{"
            // scroll is not supported in the current msearch api, so unset it:  
                false,  
                randomBoolean(),
        );
                + "]}",
                + ",\"responses\":["
        );
                randomBoolean(),
                BytesReference.bytes(builder).streamInput(),
    }
    }
        assertExpandWildcardsValue(
                randomBoolean()
        );
        }  
            assertThat(searchRequest.indices().length, equalTo(0));  
        assertThat(request.requests().get(3).indices()[0], equalTo("test"));
                + "\n"  
            MediaTypeRegistry.JSON
        assertThat(request.requests().size(), equalTo(1));  
                    randomlyGenerated.expandWildcardsOpen(),
                + "\"type\":\"illegal_state_exception\",\"reason\":\"baaaaaazzzz\"},\"status\":500"  
        ).withParams(Collections.singletonMap("ignore_unavailable", "true")).build();
        );  
            "support for empty first line before any action metadata in msearch API is deprecated and will be removed "
                null,  
 */  
import org.opensearch.search.builder.SearchSourceBuilder;
                + tookInMillis
            if (randomBoolean()) {
        assertThat(request.requests().get(1).requestCache(), nullValue());  
            equalTo(IndicesOptions.fromOptions(true, true, true, true, SearchRequest.DEFAULT_INDICES_OPTIONS))
import static org.hamcrest.Matchers.equalTo;
                + "{ \"query\": {\"match_all\": {}}}\n"
                + "{ \"query\": {\"match_all\": {}}}\n"
 * SPDX-License-Identifier: Apache-2.0
        );  
}
import java.nio.charset.StandardCharsets;
            deserializedRequest.requests().get(0).getCancelAfterTimeInterval()
        assertEquals(
        }  
    @Override  
import org.opensearch.common.xcontent.json.JsonXContent;  
        for (SearchRequest searchRequest : request.requests()) {
        ).withParams(Collections.singletonMap("cancel_after_time_interval", "20s")).build();
        int numSearchRequest = randomIntBetween(1, 128);  
                randomValueOtherThan(
        assertThat(request.requests().get(0).indices()[0], equalTo("test"));
    protected NamedWriteableRegistry writableRegistry() {
        ).build();  
            new BytesArray(mserchActionWithNewLine.getBytes(StandardCharsets.UTF_8)),  
        ).withParams(Collections.singletonMap("cancel_after_time_interval", "20s")).build();
                randomBoolean(),
            request.requests().get(0).indicesOptions(),  
            singletonList(new NamedWriteableRegistry.Entry(QueryBuilder.class, MatchAllQueryBuilder.NAME, MatchAllQueryBuilder::new))
            "closed"
            MediaTypeRegistry.JSON
    private static SearchRequest createSimpleSearchRequest() {
        mutators.add(() -> mutation.add(createSimpleSearchRequest()));  
 *
    }  
                false,
        );
    public void testEmptyFirstLine2() throws Exception {  
            "open,closed"  
            + "{\"query\" : {\"match_all\" :{}}}\r\n";
        MultiSearchRequest request = RestMultiSearchAction.parseRequest(restRequest, null, true);  
        MultiSearchRequest request = parseMultiSearchRequestFromString(
            return searchSourceBuilder;
import org.opensearch.common.CheckedBiConsumer;  
        request.maxConcurrentSearchRequests(randomIntBetween(1, Integer.MAX_VALUE));  
                randomBoolean(),  
        }
            request.add(searchRequest);
            CheckedBiConsumer<SearchRequest, XContentParser, IOException> consumer = (r, p) -> {
        RestRequest restRequest = new FakeRestRequest.Builder(xContentRegistry()).withContent(  
                randomBoolean(),  
                randomBoolean(),  
        final String requestContent = "{\"index\":\"test\", \"expand_wildcards\" : \"open,closed\", "
        assertEquals(new TimeValue(20, TimeUnit.SECONDS), request.requests().get(1).getCancelAfterTimeInterval());
    }  
        return request;
                randomBoolean(),
            equalTo(IndicesOptions.fromOptions(true, true, true, true, SearchRequest.DEFAULT_INDICES_OPTIONS))
                true,
            assertThat(searchRequest.source().query(), instanceOf(MatchAllQueryBuilder.class));  
            MediaTypeRegistry.JSON
                randomBoolean(),  
        assertThat(request.requests().get(3).searchType(), equalTo(SearchType.DFS_QUERY_THEN_FETCH));
            + "{\"query\" : {\"match_all\" :{}}}\r\n {\"search_type\" : \"dfs_query_then_fetch\"}\n"  
        assertThat(request.requests().size(), equalTo(2));
import org.opensearch.rest.action.search.RestMultiSearchAction;
                randomBoolean(),
                randomBoolean(),  
                null,
        assertThat(
 * Modifications Copyright OpenSearch Contributors. See
    private MultiSearchRequest parseMultiSearchRequestFromFile(String sample) throws IOException {
        assertThat(request.requests().get(0).indices()[0], equalTo("test0"));
        return new NamedWriteableRegistry(  
        MultiSearchRequest request = RestMultiSearchAction.parseRequest(restRequest, null, true);
        MultiSearchRequest request = parseMultiSearchRequestFromFile("/org/opensearch/action/search/simple-msearch3.json");  
                true,
                + "\n"
                randomBoolean()
        MultiSearchRequest mutation = copyRequest(searchRequest);
            ),
            assertThat(searchRequest.indices().length, equalTo(0));
    public void testSimpleAdd4() throws Exception {  
        assertThat(request.requests().get(7).indices(), is(Strings.EMPTY_ARRAY));  
            + "{\"query\" : {\"match_all\" :{}}}\r\n";
        assertThat(request.requests().get(3).searchType(), equalTo(SearchType.DFS_QUERY_THEN_FETCH));  
                false,  
            "\n"
        assertWarnings(  
            );
        );
    }  
                + "{"  
                + "\n"
            "all"
        );
    private void assertExpandWildcardsValue(IndicesOptions options, String expectedValue) throws IOException {
    private static MultiSearchRequest mutate(MultiSearchRequest searchRequest) throws IOException {  
    }
        assertThat(request.requests().get(1).indices()[0], equalTo("test"));  
                + "\"error\":{\"root_cause\":[{\"type\":\"illegal_state_exception\",\"reason\":\"foobar\"}],"
                new BytesArray(originalBytes),
import org.opensearch.common.xcontent.XContentType;
        assertEquals("The msearch request must be terminated by a newline [\n]", expectThrows.getMessage());
                randomBoolean()
            MediaTypeRegistry.JSON  
            IndicesOptions.fromOptions(
        request.indicesOptions(options);  
        );  
                new NamedXContentRegistry.Entry(
    private MultiSearchRequest parseMultiSearchRequestFromString(String request) throws IOException {
    public void testDefaultIndicesOptions() throws IOException {
import org.opensearch.core.ParseField;
            searchRequest.source(SearchSourceBuilder.fromXContent(parser, false));  
                + "{}\n"
        assertThat(request.requests().get(4).indices()[0], equalTo("test"));  
        final String requestContent = "{\"index\":\"test\", \"ignore_unavailable\" : true, \"expand_wildcards\" : \"open,closed\"}}\r\n"  
            singletonList(  
        });
 */
            () -> mutation.indicesOptions(
            MultiSearchRequest.writeSearchRequestParams(request, builder);
/*  
        String mserchActionWithNewLine = mserchAction + "\n";
            IndicesOptions.fromOptions(
    public void testMsearchTerminatedByNewline() throws Exception {
                if (searchSourceBuilder.equals(new SearchSourceBuilder()) == false) {
            IndicesOptions.fromOptions(  
                randomBoolean()
        assertThat(  
                mediaType.xContent(),
        );
            "support for empty first line before any action metadata in msearch API is deprecated and will be removed "  
        IllegalArgumentException ex = expectThrows(
        randomFrom(mutators).run();
import org.opensearch.index.query.MatchAllQueryBuilder;
        assertThat(request.requests().get(1).indices()[0], equalTo("test2"));
    public void testMultiLineSerialization() throws IOException {
    }  
            )  
        assertThat(request.requests().size(), equalTo(5));
                null,
            + "\"cancel_after_time_interval\" : \"10s\"}\r\n{\"query\" : {\"match_all\" :{}}}\r\n";
        for (int j = 0; j < numSearchRequest; j++) {
            IllegalArgumentException.class,
            copy.add(searchRequest);  
        assertThat(request.requests().get(0).indices()[1], equalTo("test1"));
        assertThat(request.requests().get(2).indices()[0], equalTo("test"));
        assertThat(request.requests().get(0).requestCache(), equalTo(true));
        }  
        assertThat(
                    msearchDefault.ignoreThrottled()
                IndicesOptions.fromOptions(
            ),  
        MultiSearchRequest request = new MultiSearchRequest();
        assertThat(
    }  
    private static MultiSearchRequest copyRequest(MultiSearchRequest request) {
        mutators.add(  
            "open"
                randomBoolean(),
                randomBoolean(),
                    msearchDefault.ignoreAliases(),  
        assertThat(request.requests().get(1).indices()[0], equalTo("test"));
        );  
    public void testSimpleAdd3() throws Exception {
        MultiSearchRequest request = parseMultiSearchRequestFromFile("/org/opensearch/action/search/simple-msearch1.json");
                xContentRegistry(),  
package org.opensearch.action.search;
        );
import org.opensearch.test.OpenSearchTestCase;
    public void testMaxConcurrentSearchRequests() {
        assertThat(request.requests().get(0).indices()[1], equalTo("test1"));  
            equalTo(IndicesOptions.fromOptions(true, false, false, true, SearchRequest.DEFAULT_INDICES_OPTIONS))  
    public void testSimpleAdd2() throws Exception {  
                randomBoolean(),  
            ),  
                }  
                )
                + "{}\n"
import org.opensearch.common.xcontent.XContentHelper;
            MultiSearchRequest parsedRequest = new MultiSearchRequest();
                randomBoolean(),
        assertThat(request.requests().get(2).indices()[0], equalTo("test4"));
                searchRequest.allowPartialSearchResults(true);  
        assertEquals(new TimeValue(20, TimeUnit.SECONDS), request.requests().get(0).getCancelAfterTimeInterval());
        expectThrows(IllegalArgumentException.class, () -> request.maxConcurrentSearchRequests(randomIntBetween(Integer.MIN_VALUE, 0)));
 * ownership. Elasticsearch licenses this file to you under  
            )  
    public void testSimpleAdd() throws Exception {
                true,
        MultiSearchRequest request = parseMultiSearchRequestFromString(
                + "},"  
    }
 * software distributed under the License is distributed on an
        long tookInMillis = randomIntBetween(1, 1000);  
                + "\"error\":{\"root_cause\":[{\"type\":\"illegal_state_exception\",\"reason\":\"baaaaaazzzz\"}],"
                true,
        for (SearchRequest searchRequest : request.requests()) {
import org.opensearch.test.StreamsUtils;  
        );
            ),
import static org.hamcrest.Matchers.containsString;  
                true,  
            MediaTypeRegistry.JSON
            new MultiSearchResponse.Item[] {
    }
        FakeRestRequest restRequest = new FakeRestRequest.Builder(xContentRegistry()).withContent(  
        );
import static org.hamcrest.Matchers.is;  
        for (SearchRequest searchRequest : request.requests()) {
        ).build();  
        MultiSearchRequest req = createMultiSearchRequest();  
            request.requests().get(3).indicesOptions(),  
            new BytesArray(requestContent),  
 * GitHub history for details.
import org.opensearch.common.CheckedRunnable;
        MultiSearchResponse response = new MultiSearchResponse(
        assertThat(request.requests().get(1).indices()[0], equalTo("test2"));
                false  
                    msearchDefault.allowAliasesToMultipleIndices(),
    }
    }
        assertThat(request.requests().get(1).indices()[1], equalTo("test3"));
            MediaTypeRegistry.JSON
    }  
    }
            request.requests().get(1).indicesOptions(),
        assertThat(request.requests().get(4).indices(), is(Strings.EMPTY_ARRAY));
        assertEquals("key [unknown_key] is not supported in the metadata section", ex.getMessage());
        );  
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
                randomBoolean(),  
            MediaTypeRegistry.JSON
        assertExpandWildcardsValue(  
                false,
import org.opensearch.index.query.QueryBuilder;  
        assertExpandWildcardsValue(
        final String requestContent = "{\"index\":\"test\", \"expand_wildcards\" : \"open,closed\", "  
        assertThat(request.requests().get(0).indices()[0], equalTo("test"));
        assertThat(request.requests().get(0).indices()[0], equalTo("test"));  
    }
import java.io.IOException;
        assertThat(request.requests().get(3).indices(), is(Strings.EMPTY_ARRAY));  
            new FakeRestRequest.Builder(xContentRegistry()).withContent(new BytesArray(request), MediaTypeRegistry.JSON).build()  
            "hidden"
        int iters = 16;  
                new MultiSearchResponse.Item(null, new IllegalStateException("foobar")),  
        assertThat(request.requests().size(), equalTo(4));
                true,
