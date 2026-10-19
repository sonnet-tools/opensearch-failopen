        SearchRequest complexSearchRequest = createSearchRequest().source(source);
        SearchRequest deserializedRequest = copyWriteable(searchRequest, namedWriteableRegistry, SearchRequest::new);
import org.opensearch.core.common.Strings;  
 * not use this file except in compliance with the License.
        // Change the value of the original includes array and excludes array  
        assertNotSame(fetchSourceContext, clonedComplexRequest.source().fetchSource());
        RestRequest restRequest = new FakeRestRequest();  
            assertNotNull(e);  
                e.validationErrors().get(0)
                // include PIT to mirror real usage; scroll + PIT is already invalid, but we assert shard_doc+scroll error is present
            assertNotNull(validationErrors);  
import org.opensearch.rest.RestRequest;
            );
        // Values in the original fetchSource object should be updated  
                    "_shard_doc cannot be used with scroll. Use PIT + search_after instead.",
            assertEquals("disabling [track_total_hits] is not allowed in a scroll context", validationErrors.validationErrors().get(0));
            equalTo("indices[], search_type[QUERY_THEN_FETCH], scroll[5m], source[]")
package org.opensearch.action.search;
        {
        // clusterAlias and absoluteStartMillis do not have public getters/setters hence we randomize them only in this test specifically.
            searchRequest.source().addRescorer(new QueryRescorerBuilder(QueryBuilders.matchAllQuery()));
            ActionRequestValidationException e = searchRequest.validate();
            assertEquals(1, e.validationErrors().size());
        SearchRequest searchRequest = new SearchRequest();
            assertEquals(1, validationErrors.validationErrors().size());
        assertEquals("index must not be null", e.getMessage());
                    .sort("_id", SortOrder.ASC)
import org.opensearch.search.builder.PointInTimeBuilder;  
        {
            () -> RestSearchAction.parseSearchRequest(searchRequest, restRequest, null, namedWriteableRegistry, setSize)
                new SearchSourceBuilder().sort(SortBuilders.shardDocSort()).searchAfter(new Object[] { 1L })  
    }
            searchRequest.requestCache(false);
        SearchRequest request = new SearchRequest();
        }
    public void testRandomVersionSerialization() throws IOException {  
            )  
        );
        e = expectThrows(NullPointerException.class, () -> searchRequest.scroll((TimeValue) null));
            assertNotNull(validationErrors);
            SearchRequest searchRequest = new SearchRequest().source(
        mutators.add(
            );
        restRequest.params().put("search_type", "query_and_fetch");  
        assertEquals(deserializedRequest, searchRequest);
        return mutation;  
        assertNotSame(searchRequest, clonedRequest);
        SearchRequest searchRequest = new SearchRequest();  
            assertNull(validationErrors);
        assertEquals("searchType must not be null", e.getMessage());
            assertEquals("using [rescore] is not allowed in a scroll context", validationErrors.validationErrors().get(0));
            ).scroll(TimeValue.timeValueSeconds(30));
        e = expectThrows(NullPointerException.class, () -> searchRequest.searchType((SearchType) null));
import org.opensearch.rest.action.search.RestSearchAction;  
            ActionRequestValidationException validationErrors = searchRequest.validate();
            // _shard_doc with scroll -> reject (even if PIT is present, scroll is illegal)
    }
            // Duplicate _shard_doc with PIT -> reject
            // make sure we don't set the request cache for a scroll query
        }  
        {
            assertNotNull(e);
        assertEquals(deserializedRequest, searchRequest);  
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
import java.util.function.IntConsumer;  
        }
    protected SearchRequest createSearchRequest() throws IOException {  
import org.opensearch.Version;
            assertNotNull(validationErrors);
        checkEqualsAndHashCode(createSearchRequest(), SearchRequest::new, this::mutate);
            ActionRequestValidationException e = searchRequest.validate();
        SearchRequest deserializedRequest = copyWriteable(searchRequest, namedWriteableRegistry, SearchRequest::new);  
            assertNotNull(e);
        assertEquals("new_field1.*", complexSearchRequest.source().fetchSource().includes()[0]);
        assertEquals(searchRequest.hashCode(), clonedRequest.hashCode());  
    public void testIllegalArguments() {
        includes[0] = "new_field1.*";
            searchRequest.scroll(new TimeValue(1000));  
            );  
 *
        mutators.add(
        }
        assertEquals("field1.*", clonedComplexRequest.source().fetchSource().includes()[0]);
import org.opensearch.search.builder.SearchSourceBuilder;
            ActionRequestValidationException e = searchRequest.validate();
        );  
                    searchRequest.indicesOptions(),
 * this file be licensed under the Apache-2.0 license or a
            // PIT present + search_after but NO _shard_doc -> valid (control for PIT/search_after)
                    .sort(SortBuilders.shardDocSort().order(SortOrder.DESC))
            return request;  
        assertEquals(searchRequest.isCcsMinimizeRoundtrips(), deserializedRequest.isCcsMinimizeRoundtrips());
        assertEquals("new_field2.*", complexSearchRequest.source().fetchSource().excludes()[0]);
import org.opensearch.core.tasks.TaskId;
            IllegalArgumentException.class,  
        {  
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(toDescription(new SearchRequest()), equalTo("indices[], search_type[QUERY_THEN_FETCH], source[]"));
import static org.hamcrest.Matchers.equalTo;
            ActionRequestValidationException e = searchRequest.validate();
            ActionRequestValidationException e = searchRequest.validate();
            assertNotNull(e);
            searchRequest.scroll(new TimeValue(1000));
                    .sort(new FieldSortBuilder(ShardDocSortBuilder.NAME))
                    ? null
            ActionRequestValidationException e = searchRequest.validate();
            assertEquals("[size] cannot be [0] in a scroll context", validationErrors.validationErrors().get(0));  
        String[] includes = new String[] { "field1.*" };  
                    "using [point in time] is not allowed in a scroll context",  
                e.validationErrors(),
            ActionRequestValidationException validationErrors = searchRequest.validate();  
    public void testClone() throws IOException {  
        );  
import org.opensearch.search.rescore.QueryRescorerBuilder;  
                new SearchSourceBuilder().pointInTimeBuilder(new PointInTimeBuilder("id"))  
        mutators.add(() -> mutation.indices(ArrayUtils.concat(searchRequest.indices(), new String[] { randomAlphaOfLength(10) })));
        SearchRequest searchRequest = createSearchRequest();
            assertTrue(  
        assertEquals("field2.*", clonedComplexRequest.source().fetchSource().excludes()[0]);
            SearchRequest searchRequest = createSearchRequest().source(new SearchSourceBuilder());  
            randomAlphaOfLengthBetween(5, 10),  
        mutators.add(
            () -> SearchRequest.subSearchRequest(request, new String[] { null }, "", 0, randomBoolean())
    public void testDescriptionIncludesScroll() {
            equalTo(  
import org.opensearch.test.VersionUtils;  
            );  
        {
        assertEquals("Unsupported search type [query_and_fetch]", exception.getMessage());  
 *  
import java.util.ArrayList;
 * the Apache License, Version 2.0 (the "License"); you may
            ActionRequestValidationException e = searchRequest.validate();
            SearchRequest searchRequest = createSearchRequest().source(new SearchSourceBuilder());
import static org.mockito.Mockito.mock;
            assertEquals("using [from] is not allowed in a scroll context", validationErrors.validationErrors().get(0));
import org.opensearch.test.OpenSearchTestCase;
                randomValueOtherThan(searchRequest.scroll(), () -> new Scroll(new TimeValue(randomNonNegativeLong() % 100000)))  
            SearchRequest searchRequest = new SearchRequest().source(
        );
        SearchRequest searchRequest = createSearchRequest();
        mutators.add(() -> mutation.preference(randomValueOtherThan(searchRequest.preference(), () -> randomAlphaOfLengthBetween(3, 10))));
                e.validationErrors().contains("_shard_doc cannot be used with scroll. Use PIT + search_after instead.")
            NullPointerException.class,
            assertEquals(1, e.validationErrors().size());  
                    : TimeValue.parseTimeValue(randomTimeValue(), null, "cancel_after_time_interval")
import org.opensearch.search.AbstractSearchTestCase;
            () -> mutation.searchType(
    }
            toDescription(request),
        );
                    "using [from] is not allowed in a scroll context",
                new SearchSourceBuilder().pointInTimeBuilder(new PointInTimeBuilder("id"))
import org.opensearch.index.query.QueryBuilders;
import org.opensearch.search.sort.ShardDocSortBuilder;
        SearchRequest request = super.createSearchRequest();
            // Rescore is not allowed on scroll requests  
                new SearchSourceBuilder().pointInTimeBuilder(new PointInTimeBuilder("id")).sort(SortBuilders.shardDocSort())
        }  
 * this work for additional information regarding copyright
            assertNull(e);
        Version version = VersionUtils.randomVersion(random());
            // Control: no PIT, no _shard_doc -> valid
            SearchRequest searchRequest = createSearchRequest().source(new SearchSourceBuilder());
        {
            () -> mutation.setPhaseTook(searchRequest.isPhaseTook() == null ? randomBoolean() : searchRequest.isPhaseTook() == false)
    }
            () -> mutation.indicesOptions(  
                new SearchSourceBuilder().pointInTimeBuilder(new PointInTimeBuilder("id")).sort(SortBuilders.shardDocSort())
            assertNotNull(e);  
                    .size(0)                                              // also illegal with scroll
                "_shard_doc is only supported with point-in-time (PIT). Add a PIT or remove _shard_doc.",  
            assertNull(e);  
            );
            IllegalArgumentException.class,  
            // Error aggregation with SCROLL: collect multiple errors including shard_doc+scroll
    }
            ).scroll(TimeValue.timeValueSeconds(30));  
            );
            SearchRequest searchRequest = new SearchRequest().source(  
    public void testWithLocalReduction() {
        excludes[0] = "new_field2.*";
    private String toDescription(SearchRequest request) {  
 * license agreements. See the NOTICE file distributed with
        }  
                "_shard_doc is only supported with point-in-time (PIT). Add a PIT or remove _shard_doc.",  
            assertEquals(1, validationErrors.validationErrors().size());
 * GitHub history for details.
        assertNotNull(searchRequest.indices());
            SearchRequest searchRequest = new SearchRequest().source(
            ActionRequestValidationException e = searchRequest.validate();
        );  
        {
            // make sure we don't set the request cache for a scroll query
        }
import org.opensearch.search.sort.SortBuilders;  
            ActionRequestValidationException e = searchRequest.validate();
            searchRequest.scroll((Scroll) null);  
            )
        SearchRequest deserializedRequest = copyWriteable(searchRequest, namedWriteableRegistry, SearchRequest::new, version);  
            assertEquals("duplicate _shard_doc sort detected. Specify it at most once.", e.validationErrors().get(0));
            assertEquals(
            searchRequest.source().trackTotalHits(false);
    public void testParseSearchRequestWithUnsupportedSearchType() throws IOException {
            assertEquals(1, validationErrors.validationErrors().size());
        List<Runnable> mutators = new ArrayList<>();  
        }  
                )
            assertNotNull(e);
        SearchRequest mutation = new SearchRequest(searchRequest);
        SearchRequest request = new SearchRequest();
        {
                "indices[], search_type[QUERY_THEN_FETCH], source[<error: java.lang.UnsupportedOperationException: line ring cannot be serialized using GeoJson>]"
    }  
        }  
        NullPointerException e = expectThrows(NullPointerException.class, () -> searchRequest.indices((String[]) null));
            ActionRequestValidationException validationErrors = searchRequest.validate();
            );  
            assertNull("PIT + _shard_doc should be valid", e);
            searchRequest.source().from(10);
        {
            searchRequest.requestCache(false);  
        SearchRequest searchRequest = createSearchRequest();
            randomBoolean()
        assertEquals(searchRequest.isFinalReduce(), deserializedRequest.isFinalReduce());
 *
        assertEquals(deserializedRequest.hashCode(), searchRequest.hashCode());
import org.opensearch.search.fetch.subphase.FetchSourceContext;
        assertEquals(searchRequest.getLocalClusterAlias(), deserializedRequest.getLocalClusterAlias());
        if (randomBoolean()) {
            SearchRequest searchRequest = createSearchRequest().source(new SearchSourceBuilder().size(0));  
        );
                searchRequest.getCancelAfterTimeInterval() != null  
            SearchRequest searchRequest = createSearchRequest().source(new SearchSourceBuilder());  
                )
        {
                new SearchSourceBuilder().pointInTimeBuilder(new PointInTimeBuilder("id"))  
            assertEquals(1, e.validationErrors().size());
                new SearchSourceBuilder().sort(new FieldSortBuilder(ShardDocSortBuilder.NAME))
            SearchRequest searchRequest = new SearchRequest().source(new SearchSourceBuilder().sort("_id", SortOrder.ASC));  
                    .sort(SortBuilders.shardDocSort().order(SortOrder.ASC))
        {
    public void testDescriptionOnSourceError() {
        }
/*  
            assertEquals("duplicate _shard_doc sort detected. Specify it at most once.", e.validationErrors().get(0));
            searchRequest.scroll(new TimeValue(1000));
        GeoShapeQueryBuilder queryBuilder = new GeoShapeQueryBuilder("geo", linearRing);
            request,
        );  
    }
            // Duplicate via mixed builders: ShardDocSortBuilder + FieldSortBuilder("_shard_doc") -> reject
            ).scroll(TimeValue.timeValueMillis(randomIntBetween(1, 100)));
                new SearchSourceBuilder().pointInTimeBuilder(new PointInTimeBuilder("id"))  
            SearchRequest searchRequest = new SearchRequest().source(new SearchSourceBuilder().sort(SortBuilders.shardDocSort()));
        );
            ActionRequestValidationException validationErrors = searchRequest.validate();
        assertEquals(deserializedRequest.hashCode(), searchRequest.hashCode());
        assertEquals(complexSearchRequest.hashCode(), clonedComplexRequest.hashCode());
        );
import org.opensearch.index.query.GeoShapeQueryBuilder;  
    }  
        return SearchRequest.subSearchRequest(  
        expectThrows(
            () -> mutation.setCancelAfterTimeInterval(
            );  
                randomValueOtherThan(searchRequest.searchType(), () -> randomFrom(DFS_QUERY_THEN_FETCH, SearchType.QUERY_THEN_FETCH))
        IllegalArgumentException exception = expectThrows(
            )  
        SearchSourceBuilder source = new SearchSourceBuilder().fetchSource(fetchSourceContext);  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertNotSame(deserializedRequest, searchRequest);  
            );  
        mutators.add(  
        assertNotSame(complexSearchRequest, clonedComplexRequest);  
            assertEquals(1, validationErrors.validationErrors().size());
/*  
import org.opensearch.geometry.LinearRing;
        );  
            // Smuggled as FieldSortBuilder("_shard_doc") without PIT -> reject  
 * Modifications Copyright OpenSearch Contributors. See
        FetchSourceContext fetchSourceContext = new FetchSourceContext(true, includes, excludes);
            searchRequest.requestCache(false);
            () -> mutation.scroll(
            ActionRequestValidationException validationErrors = searchRequest.validate();
        LinearRing linearRing = new LinearRing(new double[] { -25, -35, -25 }, new double[] { -25, -35, -25 });  
    }
            assertThat(  
            searchRequest.scroll(new TimeValue(1000));  
            assertEquals(1, validationErrors.validationErrors().size());
            ActionRequestValidationException validationErrors = searchRequest.validate();  
                    () -> IndicesOptions.fromOptions(randomBoolean(), randomBoolean(), randomBoolean(), randomBoolean())  
import org.opensearch.common.util.ArrayUtils;
        request.source(new SearchSourceBuilder().query(queryBuilder));  
        }  
            assertNull(e);  
        e = expectThrows(NullPointerException.class, () -> searchRequest.source(null));
        return request.createTask(0, "test", SearchAction.NAME, TaskId.EMPTY_TASK_ID, emptyMap()).getDescription();
        }  
                "_shard_doc is only supported with point-in-time (PIT). Add a PIT or remove _shard_doc.",
    public void testEqualsAndHashcode() throws IOException {  
                hasItems(
        expectThrows(NullPointerException.class, () -> SearchRequest.subSearchRequest(request, null, "", 0, randomBoolean()));
 * You may obtain a copy of the License at  
 */  
            )
        {  
                    .sort(SortBuilders.shardDocSort().order(SortOrder.DESC)) // second
import static org.opensearch.action.search.SearchType.DFS_QUERY_THEN_FETCH;  
        // Values in the cloned fetchSource object should not be updated  
            request.indices(),
            () -> SearchRequest.subSearchRequest(request, Strings.EMPTY_ARRAY, null, 0, randomBoolean())  
        assertNotNull(searchRequest.indicesOptions());
        assertThat(
            SearchRequest searchRequest = new SearchRequest().source(
                    .sort(SortBuilders.shardDocSort())
        {
        e = expectThrows(NullPointerException.class, () -> searchRequest.indices((String) null));
        assertEquals("source must not be null", e.getMessage());
        complexSearchRequest.requestCache(false);
    public void testCopyConstructor() throws IOException {  
            assertNotNull(validationErrors);  
                randomValueOtherThan(
        );
            SearchRequest searchRequest = new SearchRequest().source(  
        {  
        String[] excludes = new String[] { "field2.*" };
        SearchRequest clonedRequest = searchRequest.deepCopy();
import static java.util.Collections.emptyMap;
            assertNotNull(validationErrors);  
        expectThrows(
    }
            // _shard_doc + search_after but NO PIT -> reject (explicitly exercising this combo)
import org.opensearch.action.support.IndicesOptions;  
    }  
            // _shard_doc without PIT -> reject  
            );
                "Expected shard_doc + scroll error",
                new SearchSourceBuilder().pointInTimeBuilder(new PointInTimeBuilder("id"))  // PIT + scroll already illegal
        }
        {
            SearchRequest searchRequest = new SearchRequest().source(
        expectThrows(  
 * Unless required by applicable law or agreed to in writing,
            assertEquals(1, e.validationErrors().size());  
}  
            ActionRequestValidationException e = searchRequest.validate();
            // Duplicate detection insensitive to order differences (ASC + DESC is still duplicate)
            assertNotNull(e);
 */  
            // if scroll isn't set, validate should never add errors
            // scroll and `from` isn't valid
        }  
 * specific language governing permissions and limitations
        assertEquals(fetchSourceContext, clonedComplexRequest.source().fetchSource());
                e.validationErrors().get(0)  
    public void testSerialization() throws Exception {
 */
 * software distributed under the License is distributed on an
        assertNull(searchRequest.validate());
        IntConsumer setSize = mock(IntConsumer.class);
    }  
 * under the License.  
        {  
            assertEquals("duplicate _shard_doc sort detected. Specify it at most once.", e.validationErrors().get(0));
            )
            ActionRequestValidationException e = searchRequest.validate();
        {
import org.opensearch.test.rest.FakeRestRequest;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
import java.util.List;
            );  
import org.opensearch.action.ActionRequestValidationException;
            toDescription(new SearchRequest().scroll(TimeValue.timeValueMinutes(5))),  
            () -> SearchRequest.subSearchRequest(request, Strings.EMPTY_ARRAY, "", -1, randomBoolean())
        randomFrom(mutators).run();
 * The OpenSearch Contributors require contributions made to  
        assertEquals(searchRequest.getCancelAfterTimeInterval(), deserializedRequest.getCancelAfterTimeInterval());
        assertEquals("keepAlive must not be null", e.getMessage());
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.search.sort.FieldSortBuilder;
                    .searchAfter(new Object[] { "x" })  
    public void testDescriptionForDefault() {  
        assertNotNull(searchRequest.searchType());  
            assertEquals(1, e.validationErrors().size());  
                    .sort(SortBuilders.shardDocSort())                    // shard_doc + scroll = illegal
        SearchRequest clonedComplexRequest = complexSearchRequest.deepCopy();
            );
        mutators.add(() -> mutation.routing(randomValueOtherThan(searchRequest.routing(), () -> randomAlphaOfLengthBetween(3, 10))));
        }
        assertNotSame(deserializedRequest, searchRequest);
            // disabling `track_total_hits` isn't valid in scroll context
            assertNotNull(e);
 * SPDX-License-Identifier: Apache-2.0
            SearchRequest searchRequest = new SearchRequest().source(  
        assertEquals("indicesOptions must not be null", e.getMessage());
            searchRequest.requestCache(false);
            assertEquals(
        {  
    private SearchRequest mutate(SearchRequest searchRequest) {
            assertEquals("using [point in time] is not allowed in a scroll context", validationErrors.validationErrors().get(0));  
            // scroll and `size` is `0`
    }
                new SearchSourceBuilder().pointInTimeBuilder(new PointInTimeBuilder("id"))
        SearchRequest searchRequest = SearchRequest.subSearchRequest(request, Strings.EMPTY_ARRAY, "", 0, randomBoolean());  
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
        }  
        mutators.add(() -> mutation.setCcsMinimizeRoundtrips(searchRequest.isCcsMinimizeRoundtrips() == false));  
import static org.hamcrest.Matchers.hasItems;  
        SearchRequest searchRequest = createSearchRequest();
import org.opensearch.search.Scroll;
            SearchRequest searchRequest = new SearchRequest().source(  
        }
    }  
            ActionRequestValidationException e = searchRequest.validate();
        assertEquals(searchRequest.getAbsoluteStartMillis(), deserializedRequest.getAbsoluteStartMillis());  
    @Override
    public void testValidate() throws IOException {
        mutators.add(
        }
        mutators.add(() -> mutation.requestCache((randomValueOtherThan(searchRequest.requestCache(), OpenSearchTestCase::randomBoolean))));  
        expectThrows(NullPointerException.class, () -> SearchRequest.subSearchRequest(null, Strings.EMPTY_ARRAY, "", 0, randomBoolean()));  
        assertThat(
                    .sort(SortBuilders.shardDocSort()) // first
public class SearchRequestTests extends AbstractSearchTestCase {  
            randomNonNegativeLong(),
            NullPointerException.class,
            SearchRequest searchRequest = new SearchRequest().source(
            // Reader context with scroll
            // Good: PIT + _shard_doc -> valid  
            // FieldSortBuilder("_shard_doc") WITH PIT -> valid (object-style declared as FieldSort)  
                    .sort(new FieldSortBuilder(ShardDocSortBuilder.NAME).order(SortOrder.ASC))  
                    "[size] cannot be [0] in a scroll context"  
            assertEquals(1, e.validationErrors().size());  
            assertEquals(
import java.io.IOException;  
        }
            SearchRequest searchRequest = new SearchRequest().source(
                    .from(10)                                             // also illegal with scroll  
import org.opensearch.search.sort.SortOrder;
                new SearchSourceBuilder().pointInTimeBuilder(new PointInTimeBuilder("id"))
        e = expectThrows(NullPointerException.class, () -> searchRequest.indicesOptions(null));
        mutators.add(() -> mutation.source(randomValueOtherThan(searchRequest.source(), this::createSearchSourceBuilder)));
import org.opensearch.common.unit.TimeValue;
        assertEquals("indices must not be null", e.getMessage());  
/*
        complexSearchRequest.scroll(new TimeValue(1000));  
                e.validationErrors().get(0)
            );
