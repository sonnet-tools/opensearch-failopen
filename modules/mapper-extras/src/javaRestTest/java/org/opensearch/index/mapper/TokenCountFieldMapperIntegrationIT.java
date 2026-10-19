/*
    /**
        assertThat(foundIds, containsInAnyOrder(ids));
                    .startObject("token_count_without_position_increments")
    private SearchResponse searchById(String id) {
        assertThat(result.getHits().getHits().length, equalTo(ids.length));
    public void testFacetByTokenCount() throws IOException {
            .setMapping(
                    .startObject("fields")
    /**
                    .startObject("foo")
    }
 * this file be licensed under the Apache-2.0 license or a
        assertSearchReturns(searchById("bulk2"), "bulk2");
import org.opensearch.action.search.SearchRequestBuilder;
                throw new OpenSearchException("Unexpected response!");
                    .field("type", "token_count")
    }
    }
import org.opensearch.action.search.SearchResponse;
        assertThat(hit.field("foo.token_count_without_position_increments"), not(nullValue()));
        @Name("storeCountedFields") boolean storeCountedFields,
import org.opensearch.action.bulk.BulkResponse;
        assertSearchReturns(searchById("multibulk2"), "multibulk2");
                    .field("store", true)
 * this work for additional information regarding copyright
    public TokenCountFieldMapperIntegrationIT(
        }
            }
        init();
    }
        if (loadCountedFields) {
    @ParametersFactory
                jsonBuilder().startObject()
        }
            } else if (id.equals("bulk2")) {
 *
    private void init() throws IOException {
    }
            .add(prepareIndex("bulk2", "this has five bulk terms"))
            prepareIndex("multi", "two terms", "wow now I have seven lucky terms").get().getResult()
        assertSearchReturns(result, "single", "bulk1", "bulk2", "multi", "multibulk1", "multibulk2");
            } else if (id.equals("multibulk2")) {
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.search.SearchHit;
 * SPDX-License-Identifier: Apache-2.0
 */
 * under the License.
import org.opensearch.OpenSearchException;
        assertSearchReturns(searchById("single"), "single");
    }
        assertSearchReturns(searchById("bulk1"), "bulk1");
     * It is possible to search by token count.
            DocWriteResponse.Result.CREATED,
        assertSearchReturns(searchById("multibulk1"), "multibulk1");
    }
        bulk = client().prepareBulk()
        assertThat(hit.field("foo.token_count"), not(nullValue()));
import java.util.List;
import org.opensearch.action.DocWriteResponse;
        init();
        assertSearchReturns(searchByNumericRange(10, 10).get(), "multibulk2");
        if (loadCountedFields && storeCountedFields) {
    public static Iterable<Object[]> buildParameters() {
                    .field("store", true)
                assertSearchHit(hit, new int[] { 3 }, new int[] { 3 });
                    .endObject()
            .add(prepareIndex("bulk1", "bulk three terms"))
        for (SearchHit hit : result.getHits()) {
            } else if (id.equals("multi")) {
 *     http://www.apache.org/licenses/LICENSE-2.0
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
                assertSearchHit(hit, new int[] { 5 }, new int[] { 4 });
 * not use this file except in compliance with the License.
            .add(prepareIndex("multibulk2", "six is a bunch of terms", "ten!  ten terms is just crazy!  too many too count!"))
                    .field("enable_position_increments", false)
import java.io.IOException;
            )
                    .field("type", "token_count")
package org.opensearch.index.mapper;
        assertThat(terms.getBuckets().size(), equalTo(9));
 * ownership. Elasticsearch licenses this file to you under
    }
        List<Object[]> parameters = new ArrayList<>();
                parameters.add(new Object[] { storeCountedFields, loadCountedFields });
            assertThat(hit.field("foo.token_count_without_position_increments").getValues().get(i), equalTo(englishTermCounts[i]));
import org.opensearch.search.aggregations.bucket.terms.Terms;
 * You may obtain a copy of the License at
        return prepareSearch().setQuery(
        assertSearchReturns(searchByNumericRange(1, 10).get(), "single", "bulk1", "bulk2", "multi", "multibulk1", "multibulk2");
            for (boolean loadCountedFields : new boolean[] { true, false }) {
                    .field("type", "text")
            } else {
        Terms terms = (Terms) result.getAggregations().asList().get(0);
        assertThat(hit.field("foo.token_count_without_position_increments").getValues().size(), equalTo(englishTermCounts.length));
 */
            String id = hit.getId();
        }
                    .endObject()
        assertThat(result.getHits().getTotalHits().value(), equalTo((long) ids.length));
                    .field("analyzer", "mock_english")
        assertEquals(DocWriteResponse.Result.CREATED, prepareIndex("single", "I have four terms").get().getResult());
     * It is possible to get the token count in a search response.
                    .startObject("token_count")
        assertEquals(
        settings.put("index.analysis.analyzer.mock_english.filter", "stop");
 * specific language governing permissions and limitations
                assertSearchHit(hit, new int[] { 6, 10 }, new int[] { 3, 9 });
import java.util.ArrayList;
 * compatible open source license.
    private void assertSearchHit(SearchHit hit, int[] standardTermCounts, int[] englishTermCounts) {
            .get();
        for (boolean storeCountedFields : new boolean[] { true, false }) {
            .get();
        List<String> foundIds = new ArrayList<>();
            }
            .get();
/*
                    .startObject("properties")
        assertFalse(bulk.buildFailureMessage(), bulk.hasFailures());
                    .endObject()
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
 * Unless required by applicable law or agreed to in writing,
        assertFalse(bulk.buildFailureMessage(), bulk.hasFailures());
    }
        for (int i = 0; i < englishTermCounts.length; i++) {
import com.carrotsearch.randomizedtesting.annotations.Name;
 *
                    .startObject("token_count_unstored")
        return prepareSearch().setQuery(QueryBuilders.termQuery("_id", id)).get();
    private SearchRequestBuilder searchByNumericRange(int low, int high) {
public class TokenCountFieldMapperIntegrationIT extends OpenSearchIntegTestCase {
        settings.put("index.analysis.analyzer.mock_english.tokenizer", "standard");
        assertThat(result.getAggregations().asList().size(), equalTo(1));
     * It is possible to search by token count.
                assertSearchHit(hit, new int[] { 2, 7 }, new int[] { 2, 7 });
import org.opensearch.action.index.IndexRequestBuilder;
            assertThat(hit.field("foo.token_count").getValues().get(i), equalTo(standardTermCounts[i]));
                    .field("analyzer", "standard")
    private final boolean storeCountedFields;
        Settings.Builder settings = Settings.builder();
        );
            request.addStoredField("foo");
import org.opensearch.test.OpenSearchIntegTestCase;
    private SearchRequestBuilder prepareSearch() {
    private IndexRequestBuilder prepareIndex(String id, String... texts) throws IOException {
}
        SearchResponse result = searchByNumericRange(1, 10).addAggregation(AggregationBuilders.terms("facet").field(facetField)).get();
                    .field("analyzer", "standard")
                    .field("analyzer", "simple")
        @Name("loadCountedFields") boolean loadCountedFields
                    .field("type", "token_count")
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        for (SearchHit hit : result.getHits()) {
                    .endObject()
    }
                    .endObject()
        this.loadCountedFields = loadCountedFields;
        assertThat(hit.field("foo.token_count").getValues().size(), equalTo(standardTermCounts.length));
                    .field("type", "token_count")
 */
 * The OpenSearch Contributors require contributions made to
                randomFrom(Arrays.asList("foo.token_count", "foo.token_count_unstored", "foo.token_count_with_doc_values"))
        settings.put(indexSettings());
        assertSearchReturns(searchByNumericRange(4, 4).get(), "single");
import static org.hamcrest.Matchers.nullValue;
        String facetField = randomFrom(Arrays.asList("foo.token_count", "foo.token_count_unstored", "foo.token_count_with_doc_values"));
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.not;
    private final boolean loadCountedFields;
    }
     */
        assertSearchReturns(searchByNumericRange(12, 12).get());
                    .field("analyzer", "standard")
import java.util.Arrays;
        this.storeCountedFields = storeCountedFields;
    ) {
            if (id.equals("single")) {
        ensureGreen();
            .add(prepareIndex("multibulk1", "one", "oh wow now I have eight unlucky terms"))
    /**
import org.opensearch.search.aggregations.AggregationBuilders;
        init();
        }
/*
        return client().prepareIndex("test").setId(id).setSource("foo", texts);
                    .startObject("token_count_with_doc_values")
        request.addStoredField("foo.token_count_without_position_increments");
        return request;
                    .field("store", storeCountedFields)
     */
        assertThat(refresh().getFailedShards(), equalTo(0));
        assertSearchReturns(searchById("multi"), "multi");
            assertThat(hit.field("foo").getValues().size(), equalTo(standardTermCounts.length));
        return parameters;
    public void testSearchReturnsTokenCount() throws IOException {
                    .endObject()
        for (int i = 0; i < standardTermCounts.length; i++) {
            } else if (id.equals("multibulk1")) {
 * software distributed under the License is distributed on an
                    .field("doc_values", true)
                assertSearchHit(hit, new int[] { 1, 8 }, new int[] { 1, 8 });
        }
            foundIds.add(hit.getId());
import static org.hamcrest.Matchers.equalTo;
        BulkResponse bulk = client().prepareBulk()
 *
            QueryBuilders.rangeQuery(
            } else if (id.equals("bulk1")) {
    }
        }
                    .endObject()
        );
            ).gte(low).lte(high)
    public void testSearchByTokenCount() throws IOException {
        SearchRequestBuilder request = client().prepareSearch("test");
        request.addStoredField("foo.token_count");
        prepareCreate("test").setSettings(settings)
import org.opensearch.index.query.QueryBuilders;
                    .endObject()
     */
                assertSearchHit(hit, new int[] { 4 }, new int[] { 4 });
import org.opensearch.common.settings.Settings;
        }
        assertSearchReturns(searchByNumericRange(7, 10).get(), "multi", "multibulk1", "multibulk2");
    private void assertSearchReturns(SearchResponse result, String... ids) {
