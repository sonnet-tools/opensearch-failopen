        RestRequest restRequest = new FakeRestRequest.Builder(xContentRegistry()).withContent(
                + "\n"
 * SPDX-License-Identifier: Apache-2.0
                    randomlyGenerated.expandWildcardsClosed(),
                true,
                randomBoolean(),
 * The OpenSearch Contributors require contributions made to
        MultiSearchRequest request = RestMultiSearchAction.parseRequest(restRequest, null, true);
        assertThat(request.requests().get(0).indices()[0], equalTo("test0"));
                consumer,
                false,
                false,
            Map<String, Object> map = XContentHelper.convertToMap(
                randomBoolean(),
    public void testMsearchTerminatedByNewline() throws Exception {
            + "{\"query\" : {\"match_all\" :{}}}\r\n";
import static org.opensearch.search.RandomSearchRequestGenerator.randomSearchRequest;
import static java.util.Collections.singletonList;
            new MultiSearchResponse.Item[] {
            assertThat(searchRequest.indices().length, equalTo(0));
    public void testOnlyParentMSearchRequestWithCancelAfterTimeIntervalParameter() throws IOException {
import java.util.Collections;
                + "\"error\":{\"root_cause\":[{\"type\":\"illegal_state_exception\",\"reason\":\"baaaaaazzzz\"}],"
        request.maxConcurrentSearchRequests(randomIntBetween(1, Integer.MAX_VALUE));
import org.opensearch.index.query.QueryBuilder;
            // scroll is not supported in the current msearch api, so unset it:
        assertThat(request.requests().get(0).indices()[1], equalTo("test1"));
        assertThat(request.requests().get(4).indices(), is(Strings.EMPTY_ARRAY));
            () -> mutation.indicesOptions(
                new NamedXContentRegistry.Entry(
        assertThat(request.requests().get(0).indices()[0], equalTo("test0"));
            CheckedBiConsumer<SearchRequest, XContentParser, IOException> consumer = (r, p) -> {
                + "\"type\":\"illegal_state_exception\",\"reason\":\"foobar\"},\"status\":500"
                false,
                    searchRequest.indicesOptions(),
            assertThat(searchRequest.source().query(), instanceOf(MatchAllQueryBuilder.class));
        for (int j = 0; j < numSearchRequest; j++) {
            + "\"cancel_after_time_interval\" : \"10s\"}\r\n{\"query\" : {\"match_all\" :{}}}\r\n";
            final String value = (String) map.get("expand_wildcards");
                false,
    private MultiSearchRequest parseMultiSearchRequestFromString(String request) throws IOException {
        final String requestContent = "{\"index\":\"test\", \"expand_wildcards\" : \"open,closed\", "
                deprecationLogger
            MediaTypeRegistry.JSON
import org.opensearch.common.xcontent.XContentType;
            tookInMillis
    }
        assertExpandWildcardsValue(
        for (SearchRequest subReq : req.requests()) {
                randomBoolean()
        assertThat(request.requests().get(6).searchType(), equalTo(SearchType.DFS_QUERY_THEN_FETCH));
            request.requests().get(0).indicesOptions(),
    }
            IndicesOptions msearchDefault = SearchRequest.DEFAULT_INDICES_OPTIONS;
        expectThrows(IllegalArgumentException.class, () -> request.maxConcurrentSearchRequests(randomIntBetween(Integer.MIN_VALUE, 0)));
            IndicesOptions.fromOptions(
            equalTo(IndicesOptions.fromOptions(true, true, true, true, SearchRequest.DEFAULT_INDICES_OPTIONS))
            searchRequest.indicesOptions(
    }
 * the Apache License, Version 2.0 (the "License"); you may
            equalTo(IndicesOptions.fromOptions(true, false, false, true, SearchRequest.DEFAULT_INDICES_OPTIONS))
        final String requestContent = "{\"index\":\"test\", \"ignore_unavailable\" : true, \"unknown_key\" : \"open,closed\"}}\r\n"
        randomFrom(mutators).run();
                mediaType.xContent(),
        assertEquals("The msearch request must be terminated by a newline [\n]", expectThrows.getMessage());
                + "{ \"query\": {\"match_all\": {}}}\n"
        assertThat(request.requests().get(0).indices()[0], equalTo("test"));
        for (SearchRequest searchRequest : request.requests()) {
 */
import java.util.ArrayList;
        assertThat(request.requests().get(3).indices()[0], equalTo("test"));
            new BytesArray(mserchActionWithNewLine.getBytes(StandardCharsets.UTF_8)),
            MultiSearchRequest.writeSearchRequestParams(request, builder);
package org.opensearch.action.search;
                randomBoolean(),
    public void testSimpleAdd2() throws Exception {
        }
                randomBoolean(),
                + tookInMillis
        return request;
            new BytesArray(mserchAction.getBytes(StandardCharsets.UTF_8)),
import org.opensearch.common.CheckedRunnable;
    }
        );
        return request;
 * software distributed under the License is distributed on an
        assertExpandWildcardsValue(
        assertThat(request.requests().get(2).routing(), equalTo("123"));
        assertEquals(new TimeValue(20, TimeUnit.SECONDS), request.requests().get(1).getCancelAfterTimeInterval());
import static org.hamcrest.Matchers.equalTo;
        assertThat(request.requests().get(1).preference(), equalTo("_local"));
        assertWarnings(
    }
                randomBoolean(),
                    msearchDefault.forbidClosedIndices(),
            MediaTypeRegistry.JSON
    private static MultiSearchRequest createMultiSearchRequest() {
import org.opensearch.core.xcontent.NamedXContentRegistry;
            searchSourceBuilder.from(randomInt(10));
        MultiSearchRequest request = new MultiSearchRequest();
                    randomlyGenerated.expandWildcardsOpen(),
        assertThat(request.requests().get(1).indices()[0], equalTo("test"));
    }
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        assertThat(
            };
                    QueryBuilder.class,
    }
    }
            MediaTypeRegistry.JSON
            singletonList(
import org.opensearch.rest.RestRequest;
    public void testMaxConcurrentSearchRequests() {
        MultiSearchRequest request = new MultiSearchRequest();
    public void testSerDeWithCancelAfterTimeIntervalParameterAndRandomVersion() throws IOException {
    public void testMultiLineSerialization() throws IOException {
        RestMultiSearchAction.parseMultiLineRequest(restRequest, SearchRequest.DEFAULT_INDICES_OPTIONS, true, (searchRequest, parser) -> {
        );
        MultiSearchRequest request = RestMultiSearchAction.parseRequest(restRequest, null, true);
                true,
/*
        assertThat(request.requests().get(2).indices()[0], equalTo("test4"));
                randomBoolean(),
        );
    }
                randomBoolean(),
            IndicesOptions.fromOptions(
        SearchRequest request = new SearchRequest();
            "hidden"
        );
                false
        // verifies that parent msearch parameter value is used for second search request
            equalTo(IndicesOptions.fromOptions(false, true, true, false, SearchRequest.DEFAULT_INDICES_OPTIONS))
        MultiSearchRequest request = parseMultiSearchRequestFromFile("/org/opensearch/action/search/simple-msearch3.json");
    }
 */
        ).withParams(Collections.singletonMap("ignore_unavailable", "true")).build();
        MultiSearchRequest req = createMultiSearchRequest();
                true,
        MultiSearchRequest request = parseMultiSearchRequestFromFile("/org/opensearch/action/search/simple-msearch2.json");
            Strings.toString(MediaTypeRegistry.JSON, response)
import org.opensearch.common.xcontent.XContentHelper;
        assertExpandWildcardsValue(
                true,
        );
    public void testEqualsAndHashcode() {
import org.opensearch.action.support.IndicesOptions;
                randomBoolean(),
            MediaTypeRegistry.JSON
import org.opensearch.common.logging.DeprecationLogger;
                true,
            "open,closed"
                + "{ \"query\": {\"match_all\": {}}}\n"
        Version version = VersionUtils.randomVersion(random());
 * license agreements. See the NOTICE file distributed with
    public void testWritingExpandWildcards() throws IOException {
                + "{ \"query\": {\"match_all\": {}}}\n"
                + "{}\n"
 * not use this file except in compliance with the License.
        assertThat(request.requests().get(0).requestCache(), equalTo(true));
                + "\n"
                randomBoolean(),
                    randomlyGenerated.allowNoIndices(),
            MediaTypeRegistry.JSON
        for (SearchRequest searchRequest : request.requests()) {
            MediaTypeRegistry.JSON
            "support for empty first line before any action metadata in msearch API is deprecated and will be removed "
import static org.hamcrest.Matchers.instanceOf;
                true,
                randomBoolean(),
            new FakeRestRequest.Builder(xContentRegistry()).withContent(new BytesArray(data), MediaTypeRegistry.JSON).build()
                )
        checkEqualsAndHashCode(createMultiSearchRequest(), MultiSearchRequestTests::copyRequest, MultiSearchRequestTests::mutate);
import org.opensearch.core.xcontent.MediaTypeRegistry;
            IndicesOptions.fromOptions(
        );
        assertWarnings(
            ),
        // verifies that child search request parameter value is used for first search request
    private MultiSearchRequest parseMultiSearchRequest(RestRequest restRequest) throws IOException {
        assertEquals(new TimeValue(20, TimeUnit.SECONDS), request.requests().get(0).getCancelAfterTimeInterval());
                if (searchSourceBuilder.equals(new SearchSourceBuilder()) == false) {
            searchRequest.scroll((Scroll) null);
                randomBoolean(),
            "support for empty first line before any action metadata in msearch API is deprecated and will be removed "
                randomBoolean(),
                randomBoolean()
        return new NamedXContentRegistry(
    }
            assertThat(req.toString(), containsString(subReq.toString()));
        assertExpandWildcardsValue(
            new BytesArray(requestContent),
        String mserchAction = StreamsUtils.copyToStringFromClasspath("/org/opensearch/action/search/simple-msearch5.json");
            + "{\"query\" : {\"match_all\" :{}}}\r\n {\"search_type\" : \"dfs_query_then_fetch\"}\n"
                null,
                randomValueOtherThan(
        final String requestContent = "{\"index\":\"test\", \"expand_wildcards\" : \"open,closed\"}}\r\n"
            + "\"cancel_after_time_interval\" : \"10s\"}\r\n"
                randomBoolean(),
        assertEquals("key [unknown_key] is not supported in the metadata section", ex.getMessage());
        assertThat(request.requests().get(2).indices()[1], equalTo("test1"));
        final String requestContent = "{\"index\":\"test\", \"ignore_unavailable\" : true, \"expand_wildcards\" : \"open,closed\"}}\r\n"
        }
                searchRequest.allowPartialSearchResults(true);
                + "{}\n"
                randomBoolean()
    }
                + "]}",
            ),
    }
        assertThat(request.requests().get(3).indices(), is(Strings.EMPTY_ARRAY));
                randomBoolean()
            deserializedRequest.requests().get(0).getCancelAfterTimeInterval()
        assertEquals(request.requests().get(1).searchType(), SearchType.DFS_QUERY_THEN_FETCH);
                randomBoolean()
        RestRequest restRequestWithNewLine = new FakeRestRequest.Builder(xContentRegistry()).withContent(
        assertThat(request.requests().size(), equalTo(5));
        assertThat(request.requests().get(0).indices()[1], equalTo("test1"));
import org.opensearch.index.query.MatchAllQueryBuilder;
        for (int i = 0; i < iters; i++) {
        MultiSearchRequest deserializedRequest = copyWriteable(originalRequest, writableRegistry(), MultiSearchRequest::new, version);
        );
        ).build();
    }
        assertThat(request.requests().get(0).indices()[0], equalTo("test"));
import org.opensearch.core.common.bytes.BytesReference;
                + "{ \"query\": {\"match_all\": {}}}\n"
            return searchSourceBuilder;
            MultiSearchRequest.readMultiLineFormat(
        ).build();
        assertThat(request.requests().get(2).indices()[0], equalTo("test4"));
            request.add(searchRequest);
 *
                    msearchDefault.expandWildcardsHidden(),
        );
        assertExpandWildcardsValue(
                    (p, c) -> MatchAllQueryBuilder.fromXContent(p)
        MultiSearchRequest request = RestMultiSearchAction.parseRequest(restRequest, null, true);
            ),
        assertThat(request.requests().get(3).searchType(), equalTo(SearchType.DFS_QUERY_THEN_FETCH));
            request.requests().get(2).indicesOptions(),
                + "\n"
            request.add(searchRequest);
                + "in the next major version"
        assertThat(request.requests().size(), equalTo(4));
        );
import org.opensearch.rest.action.search.RestMultiSearchAction;
            searchSourceBuilder.size(randomIntBetween(20, 100));
                randomBoolean()
            assertThat(searchRequest.indices().length, equalTo(0));
            new BytesArray(requestContent),
    protected NamedXContentRegistry xContentRegistry() {
        FakeRestRequest restRequest = new FakeRestRequest.Builder(xContentRegistry()).withContent(
        }
import java.util.Map;
        );
            + "{\"query\" : {\"match_all\" :{}}}\r\n";
            copy.add(searchRequest);
        FakeRestRequest restRequest = new FakeRestRequest.Builder(xContentRegistry()).withContent(
            SearchRequest searchRequest = createSimpleSearchRequest();
            "closed"
        });
        copy.indicesOptions(request.indicesOptions());
    private MultiSearchRequest parseMultiSearchRequestFromFile(String sample) throws IOException {
            );
                true,
        assertThat(request.requests().get(0).indices()[0], equalTo("test"));
 * Modifications Copyright OpenSearch Contributors. See
        request.indicesOptions(options);
            // only expand_wildcards, ignore_unavailable and allow_no_indices can be specified from msearch api, so unset other options:
        );
                new MultiSearchResponse.Item(null, new IllegalStateException("foobar")),
        MultiSearchResponse response = new MultiSearchResponse(
import static org.hamcrest.Matchers.containsString;
        assertThat(request.requests().get(2).indices()[1], equalTo("test1"));
                false,
import org.opensearch.Version;
                true,
                randomBoolean()
 * this work for additional information regarding copyright
            );
    public void testCancelAfterIntervalAtParentAndFewChildRequest() throws Exception {
        int numSearchRequest = randomIntBetween(1, 128);
            () -> RestMultiSearchAction.parseRequest(restRequest, null, true)
            request.requests().get(1).indicesOptions(),
                randomBoolean(),
                    () -> IndicesOptions.fromOptions(randomBoolean(), randomBoolean(), randomBoolean(), randomBoolean())
        assertThat(request.requests().get(1).indices()[0], equalTo("test2"));
                false,
        assertThat(request.requests().get(0).indices()[0], equalTo("test"));
            new BytesArray(requestContent),
                null,
                randomBoolean(),
    }
        MultiSearchRequest request = parseMultiSearchRequestFromFile("/org/opensearch/action/search/simple-msearch4.json");
                randomBoolean(),
            "all"
                + "{"
import java.util.List;
        return copy;
                randomBoolean(),
    public void testResponseErrorToXContent() {
            if (randomBoolean()) {
            ),
 *
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(MultiSearchRequestTests.class);
        MultiSearchRequest request = parseMultiSearchRequestFromString(
    }
                BytesReference.bytes(builder).streamInput(),
        final String requestContent = "{\"index\":\"test\", \"expand_wildcards\" : \"open,closed\", "
import org.opensearch.test.VersionUtils;
        assertThat(request.requests().get(6).indices(), is(Strings.EMPTY_ARRAY));
        assertThat(request.requests().get(1).indices()[0], equalTo("test2"));
        ).build();
            "{\"took\":"
}
            request.requests().get(3).indicesOptions(),
import java.util.concurrent.TimeUnit;
        assertExpandWildcardsValue(
                false,
        MultiSearchRequest originalRequest = RestMultiSearchAction.parseRequest(restRequest, null, true);
        assertThat(request.requests().get(5).indices(), is(Strings.EMPTY_ARRAY));
                false,
    public void testFailWithUnknownKey() {
    }
        return new NamedWriteableRegistry(
import org.opensearch.core.common.bytes.BytesArray;
    private void assertExpandWildcardsValue(IndicesOptions options, String expectedValue) throws IOException {
            // No need to return a very complex SearchSourceBuilder here, that is tested elsewhere
        FakeRestRequest restRequest = new FakeRestRequest.Builder(xContentRegistry()).withContent(
        assertThat(request.requests().size(), equalTo(1));
                randomBoolean()
                randomBoolean(),
            MediaType mediaType = randomFrom(MediaTypeRegistry.JSON, XContentType.SMILE);
        assertThat(request.requests().get(1).indices()[1], equalTo("test3"));
            }
            ),
                randomBoolean(),
            "\n"
        MultiSearchRequest copy = new MultiSearchRequest();
            + "{\"query\" : {\"match_all\" :{}}}\r\n";
    }
                randomBoolean(),
        FakeRestRequest restRequest = new FakeRestRequest.Builder(xContentRegistry()).withContent(
            MultiSearchRequest parsedRequest = new MultiSearchRequest();
/*
        );
            IndicesOptions.fromOptions(
                + "\"error\":{\"root_cause\":[{\"type\":\"illegal_state_exception\",\"reason\":\"foobar\"}],"
        );
        int iters = 16;
        assertThat(
            // The only formats that support stream separator
        });
        );
            assertEquals(originalRequest, parsedRequest);
                randomBoolean(),
                + "}"
 * GitHub history for details.
            IndicesOptions.fromOptions(
                    msearchDefault.ignoreThrottled()
        ).build();
        MultiSearchRequest request = parseMultiSearchRequestFromString(
                randomBoolean(),
            request.requests().get(0).indicesOptions(),
                null,
/*
        );
                randomBoolean(),
            IllegalArgumentException.class,
                true,
 * Licensed to Elasticsearch under one or more contributor
                true,
                    msearchDefault.allowAliasesToMultipleIndices(),
        assertEquals(
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.common.CheckedBiConsumer;
            MultiSearchRequest originalRequest = createMultiSearchRequest();
import org.opensearch.common.xcontent.json.JsonXContent;
import java.nio.charset.StandardCharsets;
                + "in the next major version"
            + "{\"query\" : {\"match_all\" :{}}}\r\n";
import org.opensearch.core.xcontent.XContentBuilder;
    }
        List<CheckedRunnable<IOException>> mutators = new ArrayList<>();
        assertEquals(
    }
    }
        String mserchActionWithNewLine = mserchAction + "\n";
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        MultiSearchRequest mutation = copyRequest(searchRequest);
        long tookInMillis = randomIntBetween(1, 1000);
import org.opensearch.core.common.Strings;
        FakeRestRequest restRequest = new FakeRestRequest.Builder(xContentRegistry()).withContent(
            MediaTypeRegistry.JSON
            assertEquals(expectedValue, value);
            IndicesOptions.fromOptions(
    public void testToString() {
        assertThat(request.requests().get(4).indices()[0], equalTo("test"));
            equalTo(IndicesOptions.fromOptions(true, true, true, true, SearchRequest.DEFAULT_INDICES_OPTIONS))
        }
        }
        MultiSearchRequest msearchRequest = RestMultiSearchAction.parseRequest(restRequestWithNewLine, null, true);
        return parseMultiSearchRequest(
            () -> RestMultiSearchAction.parseRequest(restRequest, null, true)
            new BytesArray(requestContent),
        );
    public void testEmptyFirstLine1() throws Exception {
            "closed,hidden"
            singletonList(new NamedWriteableRegistry.Entry(QueryBuilder.class, MatchAllQueryBuilder.NAME, MatchAllQueryBuilder::new))
        assertThat(request.requests().get(7).indices(), is(Strings.EMPTY_ARRAY));
                randomBoolean(),
                false,
    public void testSimpleAddWithCarriageReturn() throws Exception {
        assertThat(
        );
                randomBoolean(),
    @Override
            originalRequest.requests().get(0).getCancelAfterTimeInterval(),
 * Unless required by applicable law or agreed to in writing,
        );
                false,
    }
                randomBoolean(),
        return parseMultiSearchRequest(
                randomBoolean(),
            ),
                + "{ \"query\": {\"match_all\": {}}}\n"
        if (request.maxConcurrentSearchRequests() > 0) {
            "open,hidden"
        );
            IndicesOptions.fromOptions(
 *
        assertThat(request.requests().size(), equalTo(1));
        assertThat(request.requests().size(), equalTo(1));
            new BytesArray(requestContent),
                randomBoolean(),
 * You may obtain a copy of the License at
            )
        );
 * specific language governing permissions and limitations
            ),
                randomBoolean(),
        for (SearchRequest searchRequest : request.requests()) {
import org.opensearch.test.StreamsUtils;
import org.opensearch.search.builder.SearchSourceBuilder;
                randomBoolean(),
    }
                true,
        }
            "\n"
                    r.source(searchSourceBuilder);
    }
                null,
 */
                )
    public void testEmptyFirstLine2() throws Exception {
                new MultiSearchResponse.Item(null, new IllegalStateException("baaaaaazzzz")) },
    }
                randomBoolean(),
        }
    public void testSimpleAdd4() throws Exception {
            "none"
                SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.fromXContent(p, false);
    public void testDefaultIndicesOptions() throws IOException {
                parsedRequest.add(r);
            )
    }
        ).withParams(Collections.singletonMap("cancel_after_time_interval", "20s")).build();
        );
            new FakeRestRequest.Builder(xContentRegistry()).withContent(new BytesArray(request), MediaTypeRegistry.JSON).build()
        ).withParams(Collections.singletonMap("cancel_after_time_interval", "20s")).build();
                randomBoolean(),
import org.opensearch.common.unit.TimeValue;
import static org.hamcrest.Matchers.is;
        );
        assertThat(request.requests().size(), equalTo(4));
            request.requests().get(4).indicesOptions(),
        assertThat(
 * under the License.
    }
        return mutation;
                + "},"
        assertThat(request.requests().size(), equalTo(3));
                randomBoolean(),
        );
        FakeRestRequest restRequest = new FakeRestRequest.Builder(xContentRegistry()).withContent(
            IllegalArgumentException.class,
                xContentRegistry(),
        ).build();
                null,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public void testSimpleAdd() throws Exception {
        MultiSearchRequest request = RestMultiSearchAction.parseRequest(restRequest, null, true);
            searchRequest.source(SearchSourceBuilder.fromXContent(parser, false));
    public void testSimpleAdd3() throws Exception {
    private static MultiSearchRequest copyRequest(MultiSearchRequest request) {
                + "\"type\":\"illegal_state_exception\",\"reason\":\"baaaaaazzzz\"},\"status\":500"
        assertThat(request.requests().get(0).preference(), nullValue());
 * KIND, either express or implied.  See the License for the
                + "{"
        assertThat(request.requests().get(1).requestCache(), nullValue());
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
        mutators.add(() -> mutation.maxConcurrentSearchRequests(randomIntBetween(1, 32)));
                randomBoolean(),
        );
 * ownership. Elasticsearch licenses this file to you under
        mutators.add(() -> mutation.add(createSimpleSearchRequest()));
import java.io.IOException;
    @Override
        assertThat(request.requests().get(0).indices()[0], equalTo("test"));
    protected NamedWriteableRegistry writableRegistry() {
                randomBoolean(),
                + "\n"
        assertThat(request.requests().get(3).searchType(), equalTo(SearchType.DFS_QUERY_THEN_FETCH));
        return randomSearchRequest(() -> {
            byte[] originalBytes = MultiSearchRequest.writeMultiLineFormat(originalRequest, mediaType.xContent());
                )
                + "{}\n"
            IndicesOptions.fromOptions(
                    msearchDefault.ignoreAliases(),
        mutators.add(
                true,
        assertThat(
 * compatible open source license.
        try (XContentBuilder builder = JsonXContent.contentBuilder()) {
        assertThat(request.requests().size(), equalTo(8));
                new BytesArray(originalBytes),
public class MultiSearchRequestTests extends OpenSearchTestCase {
        assertThat(
        assertEquals(new TimeValue(10, TimeUnit.SECONDS), request.requests().get(0).getCancelAfterTimeInterval());
                + "{ \"query\": {\"match_all\": {}}}\n"
        );
import org.opensearch.test.rest.FakeRestRequest;
        assertExpandWildcardsValue(
        IllegalArgumentException ex = expectThrows(
            "open"
                false,
        assertThat(request.requests().size(), equalTo(2));
            new BytesArray(requestContent),
        IllegalArgumentException expectThrows = expectThrows(
        byte[] data = StreamsUtils.copyToBytesFromClasspath(sample);
import org.opensearch.core.ParseField;
                + ",\"responses\":["
            + "{\"query\" : {\"match_all\" :{}}}\r\n";
            MediaTypeRegistry.JSON
                + "{ \"query\": {\"match_all\": {}}}\n"
 *    http://www.apache.org/licenses/LICENSE-2.0
                randomBoolean(),
            request.requests().get(0).indicesOptions(),
            copy.maxConcurrentSearchRequests(request.maxConcurrentSearchRequests());
        assertThat(request.requests().get(2).indices()[0], equalTo("test"));
            assertThat(searchRequest.source().query(), instanceOf(MatchAllQueryBuilder.class));
                    randomlyGenerated.ignoreUnavailable(),
        );
                }
        assertThat(request.requests().get(3).indices(), is(Strings.EMPTY_ARRAY));
        assertThat(request.requests().get(0).indices()[0], equalTo("test"));
        final String requestContent = "{\"index\":\"test\", \"expand_wildcards\" : \"open,closed\"}}\r\n"
                randomBoolean(),
    private static MultiSearchRequest mutate(MultiSearchRequest searchRequest) throws IOException {
        );
                randomBoolean(),
                + "{}\n"
        assertExpandWildcardsValue(
import org.opensearch.core.xcontent.XContentParser;
        assertThat(request.requests().size(), equalTo(4));
            equalTo(IndicesOptions.fromOptions(true, true, true, true, SearchRequest.DEFAULT_INDICES_OPTIONS))
    }
    private static SearchRequest createSimpleSearchRequest() {
            equalTo(IndicesOptions.fromOptions(false, true, true, true, SearchRequest.DEFAULT_INDICES_OPTIONS))
                MediaTypeRegistry.JSON.xContent(),
                randomBoolean(),
                false,
        }
            ),
                    new ParseField(MatchAllQueryBuilder.NAME),
        MultiSearchRequest request = parseMultiSearchRequestFromFile("/org/opensearch/action/search/simple-msearch1.json");
import org.opensearch.core.xcontent.MediaType;
 * this file be licensed under the Apache-2.0 license or a
        assertThat(request.requests().get(1).indices()[0], equalTo("test"));
        MultiSearchRequest request = new MultiSearchRequest();
        );
                + "{ \"query\": {\"match_all\": {}}}\n"
            IndicesOptions randomlyGenerated = searchRequest.indicesOptions();
import org.opensearch.search.Scroll;
        );
                randomBoolean(),
                true,
        assertEquals(3, msearchRequest.requests().size());
                IndicesOptions.fromOptions(
import static org.hamcrest.Matchers.nullValue;
        assertThat(request.requests().get(2).indices(), is(Strings.EMPTY_ARRAY));
    }
        assertThat(
            equalTo(IndicesOptions.fromOptions(true, true, true, true, SearchRequest.DEFAULT_INDICES_OPTIONS))
        assertThat(request.requests().get(1).indices()[1], equalTo("test3"));
            );
