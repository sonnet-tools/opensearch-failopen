            ActionRequestValidationException e = searchRequest.validate();
            assertNotNull(e);
        String[] excludes = new String[] { "field2.*" };
            equalTo(
            ActionRequestValidationException e = searchRequest.validate();
            // disabling `track_total_hits` isn't valid in scroll context
    public void testWithLocalReduction() {
                    : TimeValue.parseTimeValue(randomTimeValue(), null, "cancel_after_time_interval")
        assertEquals("field1.*", clonedComplexRequest.source().fetchSource().includes()[0]);
        mutators.add(() -> mutation.source(randomValueOtherThan(searchRequest.source(), this::createSearchSourceBuilder)));
            request.indices(),
        mutators.add(
            );
        {
            assertEquals(
    }
        // Change the value of the original includes array and excludes array
            equalTo("indices[], search_type[QUERY_THEN_FETCH], scroll[5m], source[]")
import org.opensearch.geometry.LinearRing;
            SearchRequest searchRequest = new SearchRequest().source(
            IllegalArgumentException.class,
            ActionRequestValidationException e = searchRequest.validate();
            ActionRequestValidationException validationErrors = searchRequest.validate();
            assertNotNull(validationErrors);
                // include PIT to mirror real usage; scroll + PIT is already invalid, but we assert shard_doc+scroll error is present
            // _shard_doc with scroll -> reject (even if PIT is present, scroll is illegal)
        assertNull(searchRequest.validate());
 */
import org.opensearch.rest.RestRequest;
        {
        }
                new SearchSourceBuilder().pointInTimeBuilder(new PointInTimeBuilder("id"))
            toDescription(request),
            SearchRequest searchRequest = createSearchRequest().source(new SearchSourceBuilder());
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
            ActionRequestValidationException validationErrors = searchRequest.validate();
    public void testValidate() throws IOException {
    }
                    .sort("_id", SortOrder.ASC)
                new SearchSourceBuilder().pointInTimeBuilder(new PointInTimeBuilder("id"))
        // Values in the original fetchSource object should be updated
                    () -> IndicesOptions.fromOptions(randomBoolean(), randomBoolean(), randomBoolean(), randomBoolean())
            ActionRequestValidationException e = searchRequest.validate();
            randomNonNegativeLong(),
import static org.hamcrest.Matchers.hasItems;
public class SearchRequestTests extends AbstractSearchTestCase {
    }
            SearchRequest searchRequest = new SearchRequest().source(
        SearchSourceBuilder source = new SearchSourceBuilder().fetchSource(fetchSourceContext);
 * compatible open source license.
            ActionRequestValidationException e = searchRequest.validate();
                new SearchSourceBuilder().pointInTimeBuilder(new PointInTimeBuilder("id")).sort(SortBuilders.shardDocSort())
                new SearchSourceBuilder().pointInTimeBuilder(new PointInTimeBuilder("id")).sort(SortBuilders.shardDocSort())
            randomAlphaOfLengthBetween(5, 10),
        mutators.add(
 * this work for additional information regarding copyright
    }
            SearchRequest searchRequest = createSearchRequest().source(new SearchSourceBuilder());
                    "[size] cannot be [0] in a scroll context"
            assertEquals(1, e.validationErrors().size());
        }
import java.io.IOException;
            searchRequest.source().trackTotalHits(false);
            assertEquals(
            // scroll and `from` isn't valid
        complexSearchRequest.scroll(new TimeValue(1000));
import org.opensearch.action.support.IndicesOptions;
            ActionRequestValidationException validationErrors = searchRequest.validate();
            assertEquals(1, validationErrors.validationErrors().size());
        SearchRequest request = super.createSearchRequest();
                    .searchAfter(new Object[] { "x" })
        assertEquals(searchRequest.getAbsoluteStartMillis(), deserializedRequest.getAbsoluteStartMillis());
            () -> mutation.setCancelAfterTimeInterval(
            assertEquals(1, validationErrors.validationErrors().size());
import java.util.List;
        {
                "indices[], search_type[QUERY_THEN_FETCH], source[<error: java.lang.UnsupportedOperationException: line ring cannot be serialized using GeoJson>]"
/*
 * Licensed to Elasticsearch under one or more contributor
            IllegalArgumentException.class,
        randomFrom(mutators).run();
            SearchRequest searchRequest = new SearchRequest().source(
            )
import org.opensearch.search.sort.SortOrder;
        }
        }
                    .from(10)                                             // also illegal with scroll
import java.util.function.IntConsumer;
        SearchRequest deserializedRequest = copyWriteable(searchRequest, namedWriteableRegistry, SearchRequest::new);
        SearchRequest searchRequest = createSearchRequest();
import org.opensearch.search.sort.SortBuilders;
}
        // Values in the cloned fetchSource object should not be updated
        assertThat(
        assertThat(
            // Duplicate via mixed builders: ShardDocSortBuilder + FieldSortBuilder("_shard_doc") -> reject
            toDescription(new SearchRequest().scroll(TimeValue.timeValueMinutes(5))),
            assertNotNull(e);
 * SPDX-License-Identifier: Apache-2.0
            );
        mutators.add(
import java.util.ArrayList;
        }
import org.opensearch.search.rescore.QueryRescorerBuilder;
        );
        assertEquals("index must not be null", e.getMessage());
                searchRequest.getCancelAfterTimeInterval() != null
                e.validationErrors().get(0)
        );
            ).scroll(TimeValue.timeValueSeconds(30));
        checkEqualsAndHashCode(createSearchRequest(), SearchRequest::new, this::mutate);
import org.opensearch.action.ActionRequestValidationException;
        expectThrows(
            assertEquals("using [from] is not allowed in a scroll context", validationErrors.validationErrors().get(0));
import org.opensearch.search.sort.FieldSortBuilder;
    public void testDescriptionForDefault() {
                    "using [from] is not allowed in a scroll context",
            );
    }
        {
        SearchRequest request = new SearchRequest();
        e = expectThrows(NullPointerException.class, () -> searchRequest.searchType((SearchType) null));
            ActionRequestValidationException e = searchRequest.validate();
            assertEquals("duplicate _shard_doc sort detected. Specify it at most once.", e.validationErrors().get(0));
            searchRequest.scroll(new TimeValue(1000));
        assertEquals(searchRequest.isFinalReduce(), deserializedRequest.isFinalReduce());
            SearchRequest searchRequest = new SearchRequest().source(new SearchSourceBuilder().sort("_id", SortOrder.ASC));
            searchRequest.source().addRescorer(new QueryRescorerBuilder(QueryBuilders.matchAllQuery()));
        {
            )
    }
 * ownership. Elasticsearch licenses this file to you under
    }
            ActionRequestValidationException e = searchRequest.validate();
        }
            assertEquals(1, e.validationErrors().size());
        complexSearchRequest.requestCache(false);
    }
            );
                new SearchSourceBuilder().sort(new FieldSortBuilder(ShardDocSortBuilder.NAME))
            ActionRequestValidationException validationErrors = searchRequest.validate();
        {
                    searchRequest.indicesOptions(),
                randomValueOtherThan(searchRequest.searchType(), () -> randomFrom(DFS_QUERY_THEN_FETCH, SearchType.QUERY_THEN_FETCH))
            assertNull(e);
 */
            assertNotNull(e);
        {
                    .size(0)                                              // also illegal with scroll
 * KIND, either express or implied.  See the License for the
            assertNotNull(validationErrors);
                e.validationErrors().contains("_shard_doc cannot be used with scroll. Use PIT + search_after instead.")
        SearchRequest searchRequest = createSearchRequest();
        SearchRequest searchRequest = new SearchRequest();
        }
        expectThrows(
        RestRequest restRequest = new FakeRestRequest();
        }
        mutators.add(() -> mutation.preference(randomValueOtherThan(searchRequest.preference(), () -> randomAlphaOfLengthBetween(3, 10))));
    public void testEqualsAndHashcode() throws IOException {
        assertNotSame(deserializedRequest, searchRequest);
            // Duplicate detection insensitive to order differences (ASC + DESC is still duplicate)
import static org.mockito.Mockito.mock;
        assertNotSame(searchRequest, clonedRequest);
            NullPointerException.class,
        assertEquals("indicesOptions must not be null", e.getMessage());
        {
            assertEquals(1, validationErrors.validationErrors().size());
                randomValueOtherThan(searchRequest.scroll(), () -> new Scroll(new TimeValue(randomNonNegativeLong() % 100000)))
        IntConsumer setSize = mock(IntConsumer.class);
 *    http://www.apache.org/licenses/LICENSE-2.0
        SearchRequest searchRequest = SearchRequest.subSearchRequest(request, Strings.EMPTY_ARRAY, "", 0, randomBoolean());
        excludes[0] = "new_field2.*";
import org.opensearch.core.tasks.TaskId;
            // Control: no PIT, no _shard_doc -> valid
            );
    public void testDescriptionIncludesScroll() {
import org.opensearch.common.util.ArrayUtils;
        assertNotNull(searchRequest.indices());
    }
        return SearchRequest.subSearchRequest(
            assertEquals(1, validationErrors.validationErrors().size());
        }
        assertEquals(deserializedRequest.hashCode(), searchRequest.hashCode());
        }
        );
            searchRequest.scroll(new TimeValue(1000));
import org.opensearch.search.Scroll;
        expectThrows(
            // make sure we don't set the request cache for a scroll query
        {
        mutators.add(() -> mutation.routing(randomValueOtherThan(searchRequest.routing(), () -> randomAlphaOfLengthBetween(3, 10))));
            return request;
import org.opensearch.search.builder.SearchSourceBuilder;
                    .sort(SortBuilders.shardDocSort().order(SortOrder.DESC)) // second
 *
            () -> mutation.indicesOptions(
        assertEquals("Unsupported search type [query_and_fetch]", exception.getMessage());
        mutators.add(
            );
            )
                "Expected shard_doc + scroll error",
import static org.opensearch.action.search.SearchType.DFS_QUERY_THEN_FETCH;
            () -> mutation.searchType(
        SearchRequest searchRequest = createSearchRequest();
        {
                e.validationErrors(),
 * not use this file except in compliance with the License.
            searchRequest.scroll(new TimeValue(1000));
            assertNotNull(e);
            assertEquals("[size] cannot be [0] in a scroll context", validationErrors.validationErrors().get(0));
            assertNull(validationErrors);
            SearchRequest searchRequest = createSearchRequest().source(new SearchSourceBuilder());
        IllegalArgumentException exception = expectThrows(
        // clusterAlias and absoluteStartMillis do not have public getters/setters hence we randomize them only in this test specifically.
            // make sure we don't set the request cache for a scroll query
    protected SearchRequest createSearchRequest() throws IOException {
                    .sort(SortBuilders.shardDocSort())                    // shard_doc + scroll = illegal
            assertEquals(
            SearchRequest searchRequest = new SearchRequest().source(new SearchSourceBuilder().sort(SortBuilders.shardDocSort()));
        assertEquals(complexSearchRequest.hashCode(), clonedComplexRequest.hashCode());
            // Smuggled as FieldSortBuilder("_shard_doc") without PIT -> reject
        SearchRequest complexSearchRequest = createSearchRequest().source(source);
                e.validationErrors().get(0)
            () -> mutation.setPhaseTook(searchRequest.isPhaseTook() == null ? randomBoolean() : searchRequest.isPhaseTook() == false)
        expectThrows(NullPointerException.class, () -> SearchRequest.subSearchRequest(null, Strings.EMPTY_ARRAY, "", 0, randomBoolean()));
    public void testRandomVersionSerialization() throws IOException {
    }
        assertEquals(searchRequest.getLocalClusterAlias(), deserializedRequest.getLocalClusterAlias());
                    .sort(new FieldSortBuilder(ShardDocSortBuilder.NAME).order(SortOrder.ASC))
package org.opensearch.action.search;
 * The OpenSearch Contributors require contributions made to
            // Rescore is not allowed on scroll requests
            ActionRequestValidationException validationErrors = searchRequest.validate();
                "_shard_doc is only supported with point-in-time (PIT). Add a PIT or remove _shard_doc.",
            searchRequest.requestCache(false);
    }
        {
 * the Apache License, Version 2.0 (the "License"); you may
                hasItems(
            () -> RestSearchAction.parseSearchRequest(searchRequest, restRequest, null, namedWriteableRegistry, setSize)
        restRequest.params().put("search_type", "query_and_fetch");
            // PIT present + search_after but NO _shard_doc -> valid (control for PIT/search_after)
import org.opensearch.index.query.QueryBuilders;
            );
        SearchRequest deserializedRequest = copyWriteable(searchRequest, namedWriteableRegistry, SearchRequest::new, version);
    public void testSerialization() throws Exception {
            ActionRequestValidationException e = searchRequest.validate();
            searchRequest.scroll((Scroll) null);
            assertNotNull(e);
            // Duplicate _shard_doc with PIT -> reject
            SearchRequest searchRequest = new SearchRequest().source(
                )
            );
            assertEquals("using [rescore] is not allowed in a scroll context", validationErrors.validationErrors().get(0));
        LinearRing linearRing = new LinearRing(new double[] { -25, -35, -25 }, new double[] { -25, -35, -25 });
        }
        assertEquals("indices must not be null", e.getMessage());
            randomBoolean()
    public void testDescriptionOnSourceError() {
    }
        List<Runnable> mutators = new ArrayList<>();
                randomValueOtherThan(
                e.validationErrors().get(0)
        );
        assertEquals("field2.*", clonedComplexRequest.source().fetchSource().excludes()[0]);
            SearchRequest searchRequest = new SearchRequest().source(
        FetchSourceContext fetchSourceContext = new FetchSourceContext(true, includes, excludes);
                "_shard_doc is only supported with point-in-time (PIT). Add a PIT or remove _shard_doc.",
    public void testIllegalArguments() {
 *
    private SearchRequest mutate(SearchRequest searchRequest) {
        assertNotSame(complexSearchRequest, clonedComplexRequest);
        e = expectThrows(NullPointerException.class, () -> searchRequest.source(null));
                new SearchSourceBuilder().pointInTimeBuilder(new PointInTimeBuilder("id"))
        {
        {
            )
import org.opensearch.search.builder.PointInTimeBuilder;
import org.opensearch.Version;
            assertThat(
            assertNull(e);
        );
 * software distributed under the License is distributed on an
        }
            assertNotNull(e);
                    .sort(SortBuilders.shardDocSort())
        {
            assertEquals("disabling [track_total_hits] is not allowed in a scroll context", validationErrors.validationErrors().get(0));
 * under the License.
        );
            );
        request.source(new SearchSourceBuilder().query(queryBuilder));
 */
            // FieldSortBuilder("_shard_doc") WITH PIT -> valid (object-style declared as FieldSort)
            SearchRequest searchRequest = createSearchRequest().source(new SearchSourceBuilder());
import org.opensearch.search.AbstractSearchTestCase;
        SearchRequest searchRequest = new SearchRequest();
        SearchRequest clonedRequest = searchRequest.deepCopy();
            );
            NullPointerException.class,
            )
            SearchRequest searchRequest = new SearchRequest().source(
    }
            assertEquals("duplicate _shard_doc sort detected. Specify it at most once.", e.validationErrors().get(0));
        SearchRequest searchRequest = createSearchRequest();
        return request.createTask(0, "test", SearchAction.NAME, TaskId.EMPTY_TASK_ID, emptyMap()).getDescription();
        e = expectThrows(NullPointerException.class, () -> searchRequest.indices((String) null));
        assertNotNull(searchRequest.searchType());
            SearchRequest searchRequest = new SearchRequest().source(
    }
            // if scroll isn't set, validate should never add errors
        e = expectThrows(NullPointerException.class, () -> searchRequest.scroll((TimeValue) null));
        assertEquals(searchRequest.isCcsMinimizeRoundtrips(), deserializedRequest.isCcsMinimizeRoundtrips());
            searchRequest.requestCache(false);
            searchRequest.requestCache(false);
        assertEquals(deserializedRequest.hashCode(), searchRequest.hashCode());
        GeoShapeQueryBuilder queryBuilder = new GeoShapeQueryBuilder("geo", linearRing);
        SearchRequest request = new SearchRequest();
    public void testParseSearchRequestWithUnsupportedSearchType() throws IOException {
            // Reader context with scroll
import org.opensearch.core.common.Strings;
                    "_shard_doc cannot be used with scroll. Use PIT + search_after instead.",
                    .sort(SortBuilders.shardDocSort().order(SortOrder.DESC))
            assertEquals(1, e.validationErrors().size());
        assertEquals("new_field1.*", complexSearchRequest.source().fetchSource().includes()[0]);
import org.opensearch.test.rest.FakeRestRequest;
        {
            () -> SearchRequest.subSearchRequest(request, Strings.EMPTY_ARRAY, null, 0, randomBoolean())
        );
    public void testCopyConstructor() throws IOException {
                    .sort(new FieldSortBuilder(ShardDocSortBuilder.NAME))
        assertThat(toDescription(new SearchRequest()), equalTo("indices[], search_type[QUERY_THEN_FETCH], source[]"));
        assertEquals(searchRequest.getCancelAfterTimeInterval(), deserializedRequest.getCancelAfterTimeInterval());
        String[] includes = new String[] { "field1.*" };
        assertEquals(deserializedRequest, searchRequest);
                new SearchSourceBuilder().pointInTimeBuilder(new PointInTimeBuilder("id"))  // PIT + scroll already illegal
        }
        );
        assertEquals(searchRequest.hashCode(), clonedRequest.hashCode());
            // Error aggregation with SCROLL: collect multiple errors including shard_doc+scroll
            ActionRequestValidationException e = searchRequest.validate();
 * this file be licensed under the Apache-2.0 license or a
            searchRequest.requestCache(false);
            () -> SearchRequest.subSearchRequest(request, Strings.EMPTY_ARRAY, "", -1, randomBoolean())
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertEquals("new_field2.*", complexSearchRequest.source().fetchSource().excludes()[0]);
            assertEquals("duplicate _shard_doc sort detected. Specify it at most once.", e.validationErrors().get(0));
                new SearchSourceBuilder().pointInTimeBuilder(new PointInTimeBuilder("id"))
    }
            // scroll and `size` is `0`
                )
            SearchRequest searchRequest = new SearchRequest().source(
/*
        assertEquals("source must not be null", e.getMessage());
        expectThrows(NullPointerException.class, () -> SearchRequest.subSearchRequest(request, null, "", 0, randomBoolean()));
            ActionRequestValidationException e = searchRequest.validate();
                "_shard_doc is only supported with point-in-time (PIT). Add a PIT or remove _shard_doc.",
            () -> mutation.scroll(
        );
            assertNotNull(e);
            request,
            ActionRequestValidationException validationErrors = searchRequest.validate();
            SearchRequest searchRequest = new SearchRequest().source(
 * specific language governing permissions and limitations
        }
        return mutation;
        );
                    "using [point in time] is not allowed in a scroll context",
        assertEquals(fetchSourceContext, clonedComplexRequest.source().fetchSource());
import org.opensearch.rest.action.search.RestSearchAction;
            assertNotNull(validationErrors);
import static org.hamcrest.Matchers.equalTo;
 * You may obtain a copy of the License at
    private String toDescription(SearchRequest request) {
 * GitHub history for details.
            ActionRequestValidationException e = searchRequest.validate();
        assertEquals("searchType must not be null", e.getMessage());
            assertEquals("using [point in time] is not allowed in a scroll context", validationErrors.validationErrors().get(0));
            SearchRequest searchRequest = new SearchRequest().source(
            // _shard_doc + search_after but NO PIT -> reject (explicitly exercising this combo)
        e = expectThrows(NullPointerException.class, () -> searchRequest.indicesOptions(null));
            searchRequest.scroll(new TimeValue(1000));
                new SearchSourceBuilder().pointInTimeBuilder(new PointInTimeBuilder("id"))
        assertNotNull(searchRequest.indicesOptions());
        includes[0] = "new_field1.*";
        mutators.add(() -> mutation.requestCache((randomValueOtherThan(searchRequest.requestCache(), OpenSearchTestCase::randomBoolean))));
            assertNotNull(validationErrors);
import org.opensearch.index.query.GeoShapeQueryBuilder;
            ).scroll(TimeValue.timeValueMillis(randomIntBetween(1, 100)));
            assertNull(e);
 * license agreements. See the NOTICE file distributed with
        assertNotSame(deserializedRequest, searchRequest);
            assertEquals(1, e.validationErrors().size());
            );
        SearchRequest deserializedRequest = copyWriteable(searchRequest, namedWriteableRegistry, SearchRequest::new);
        SearchRequest clonedComplexRequest = complexSearchRequest.deepCopy();
            assertEquals(1, e.validationErrors().size());
                new SearchSourceBuilder().sort(SortBuilders.shardDocSort()).searchAfter(new Object[] { 1L })
import org.opensearch.common.unit.TimeValue;
        );
import org.opensearch.search.fetch.subphase.FetchSourceContext;
                    .sort(SortBuilders.shardDocSort()) // first
        assertEquals("keepAlive must not be null", e.getMessage());
            SearchRequest searchRequest = new SearchRequest().source(
        Version version = VersionUtils.randomVersion(random());
            ).scroll(TimeValue.timeValueSeconds(30));
/*
        assertEquals(deserializedRequest, searchRequest);
        }
        SearchRequest mutation = new SearchRequest(searchRequest);
        mutators.add(
            );
            // Good: PIT + _shard_doc -> valid
        }
            SearchRequest searchRequest = createSearchRequest().source(new SearchSourceBuilder().size(0));
        }
        {
        );
            () -> SearchRequest.subSearchRequest(request, new String[] { null }, "", 0, randomBoolean())
            assertTrue(
        {
import org.opensearch.test.VersionUtils;
            searchRequest.source().from(10);
 * Modifications Copyright OpenSearch Contributors. See
import static java.util.Collections.emptyMap;
                    ? null
            assertNotNull(validationErrors);
        mutators.add(() -> mutation.indices(ArrayUtils.concat(searchRequest.indices(), new String[] { randomAlphaOfLength(10) })));
            // _shard_doc without PIT -> reject
import org.opensearch.test.OpenSearchTestCase;
                    .sort(SortBuilders.shardDocSort().order(SortOrder.ASC))
        }
        mutators.add(() -> mutation.setCcsMinimizeRoundtrips(searchRequest.isCcsMinimizeRoundtrips() == false));
            assertNull("PIT + _shard_doc should be valid", e);
    @Override
        assertNotSame(fetchSourceContext, clonedComplexRequest.source().fetchSource());
 *
            assertNotNull(e);
            );
        }
        {
            ActionRequestValidationException e = searchRequest.validate();
 * Unless required by applicable law or agreed to in writing,
            assertEquals(1, validationErrors.validationErrors().size());
import org.opensearch.search.sort.ShardDocSortBuilder;
        NullPointerException e = expectThrows(NullPointerException.class, () -> searchRequest.indices((String[]) null));
            assertEquals(1, e.validationErrors().size());
        if (randomBoolean()) {
    public void testClone() throws IOException {
                new SearchSourceBuilder().pointInTimeBuilder(new PointInTimeBuilder("id"))
