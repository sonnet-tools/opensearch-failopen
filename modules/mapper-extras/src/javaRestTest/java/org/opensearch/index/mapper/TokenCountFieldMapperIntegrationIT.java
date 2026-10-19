    public TokenCountFieldMapperIntegrationIT(
import org.opensearch.search.aggregations.AggregationBuilders;
                    .field("analyzer", "standard")  
import org.opensearch.OpenSearchException;
import org.opensearch.search.aggregations.bucket.terms.Terms;
    private final boolean storeCountedFields;
            .add(prepareIndex("multibulk1", "one", "oh wow now I have eight unlucky terms"))
    }
            .get();  
 *
import java.util.Arrays;
        );
import org.opensearch.action.index.IndexRequestBuilder;
    private IndexRequestBuilder prepareIndex(String id, String... texts) throws IOException {  
    }
            String id = hit.getId();
 * Modifications Copyright OpenSearch Contributors. See
    /**  
import org.opensearch.action.DocWriteResponse;
        ensureGreen();  
            .get();  
        assertThat(result.getHits().getTotalHits().value(), equalTo((long) ids.length));  
     * It is possible to search by token count.
import org.opensearch.index.query.QueryBuilders;
import java.io.IOException;
    }
        assertSearchReturns(searchById("bulk2"), "bulk2");
            } else {  
 * this file be licensed under the Apache-2.0 license or a
import static org.hamcrest.Matchers.containsInAnyOrder;
import java.util.List;
                assertSearchHit(hit, new int[] { 6, 10 }, new int[] { 3, 9 });
import com.carrotsearch.randomizedtesting.annotations.Name;
     * It is possible to search by token count.  
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
            .add(prepareIndex("bulk2", "this has five bulk terms"))
            prepareIndex("multi", "two terms", "wow now I have seven lucky terms").get().getResult()
                    .field("analyzer", "standard")  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                    .field("enable_position_increments", false)  
        request.addStoredField("foo.token_count_without_position_increments");
                    .field("analyzer", "simple")
            } else if (id.equals("multibulk2")) {
    }
        for (SearchHit hit : result.getHits()) {  
            assertThat(hit.field("foo.token_count").getValues().get(i), equalTo(standardTermCounts[i]));
package org.opensearch.index.mapper;
        Terms terms = (Terms) result.getAggregations().asList().get(0);
 *     http://www.apache.org/licenses/LICENSE-2.0
                    .endObject()
                    .startObject("properties")
        }  
        SearchRequestBuilder request = client().prepareSearch("test");
        @Name("loadCountedFields") boolean loadCountedFields  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            assertThat(hit.field("foo.token_count_without_position_increments").getValues().get(i), equalTo(englishTermCounts[i]));
                    .endObject()  
                    .startObject("foo")
 * software distributed under the License is distributed on an
 */  
import org.opensearch.action.search.SearchResponse;  
        settings.put("index.analysis.analyzer.mock_english.tokenizer", "standard");
            } else if (id.equals("bulk1")) {
    public static Iterable<Object[]> buildParameters() {  
        return request;
                    .field("store", true)
            ).gte(low).lte(high)  
 * under the License.  
 * license agreements. See the NOTICE file distributed with
                    .endObject()
        assertThat(hit.field("foo.token_count_without_position_increments"), not(nullValue()));
        assertSearchReturns(searchByNumericRange(4, 4).get(), "single");
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
        for (int i = 0; i < englishTermCounts.length; i++) {  
public class TokenCountFieldMapperIntegrationIT extends OpenSearchIntegTestCase {
import org.opensearch.search.SearchHit;  
        assertSearchReturns(searchById("multibulk2"), "multibulk2");
    /**  
        assertEquals(DocWriteResponse.Result.CREATED, prepareIndex("single", "I have four terms").get().getResult());
        prepareCreate("test").setSettings(settings)
            QueryBuilders.rangeQuery(
            DocWriteResponse.Result.CREATED,  
        assertThat(hit.field("foo.token_count_without_position_increments").getValues().size(), equalTo(englishTermCounts.length));
            .add(prepareIndex("multibulk2", "six is a bunch of terms", "ten!  ten terms is just crazy!  too many too count!"))
            } else if (id.equals("bulk2")) {
    /**
                parameters.add(new Object[] { storeCountedFields, loadCountedFields });
                    .field("analyzer", "standard")
        List<Object[]> parameters = new ArrayList<>();
                    .field("doc_values", true)
        return parameters;
        String facetField = randomFrom(Arrays.asList("foo.token_count", "foo.token_count_unstored", "foo.token_count_with_doc_values"));  
 * GitHub history for details.
        bulk = client().prepareBulk()  
     */
        assertThat(hit.field("foo.token_count").getValues().size(), equalTo(standardTermCounts.length));
    }
                assertSearchHit(hit, new int[] { 4 }, new int[] { 4 });
                    .startObject("token_count_with_doc_values")
                assertSearchHit(hit, new int[] { 3 }, new int[] { 3 });  
}
        List<String> foundIds = new ArrayList<>();
     * It is possible to get the token count in a search response.
     */
                jsonBuilder().startObject()  
        assertSearchReturns(result, "single", "bulk1", "bulk2", "multi", "multibulk1", "multibulk2");
        return client().prepareIndex("test").setId(id).setSource("foo", texts);
        }
                    .field("store", storeCountedFields)
            }
                assertSearchHit(hit, new int[] { 1, 8 }, new int[] { 1, 8 });  
     */
        return prepareSearch().setQuery(QueryBuilders.termQuery("_id", id)).get();
        assertThat(terms.getBuckets().size(), equalTo(9));
                    .endObject()
        SearchResponse result = searchByNumericRange(1, 10).addAggregation(AggregationBuilders.terms("facet").field(facetField)).get();
        settings.put(indexSettings());
            .add(prepareIndex("bulk1", "bulk three terms"))
 * the Apache License, Version 2.0 (the "License"); you may
    private SearchRequestBuilder prepareSearch() {
        Settings.Builder settings = Settings.builder();  
        assertThat(result.getAggregations().asList().size(), equalTo(1));  
    private SearchRequestBuilder searchByNumericRange(int low, int high) {
        }  
            for (boolean loadCountedFields : new boolean[] { true, false }) {  
                    .field("type", "token_count")
import org.opensearch.test.OpenSearchIntegTestCase;  
        request.addStoredField("foo.token_count");  
        BulkResponse bulk = client().prepareBulk()  
        for (int i = 0; i < standardTermCounts.length; i++) {  
 */
        assertSearchReturns(searchById("multi"), "multi");  
            } else if (id.equals("multibulk1")) {
 *  
    ) {
 * SPDX-License-Identifier: Apache-2.0
        init();  
                assertSearchHit(hit, new int[] { 2, 7 }, new int[] { 2, 7 });
        return prepareSearch().setQuery(  
import static org.hamcrest.Matchers.nullValue;
            }
                    .endObject()
                    .endObject()
    public void testSearchReturnsTokenCount() throws IOException {  
        init();
/*
        assertSearchReturns(searchById("bulk1"), "bulk1");
                    .startObject("fields")  
    private void assertSearchReturns(SearchResponse result, String... ids) {
                    .field("type", "token_count")
        assertSearchReturns(searchByNumericRange(1, 10).get(), "single", "bulk1", "bulk2", "multi", "multibulk1", "multibulk2");
/*  
        assertFalse(bulk.buildFailureMessage(), bulk.hasFailures());
    }  
 *
    }
 * KIND, either express or implied.  See the License for the
 */  
        if (loadCountedFields && storeCountedFields) {
                    .startObject("token_count")
                    .field("store", true)
        assertThat(foundIds, containsInAnyOrder(ids));  
                    .endObject()  
                    .endObject()  
    }
            )
            .setMapping(
                    .field("type", "text")  
            assertThat(hit.field("foo").getValues().size(), equalTo(standardTermCounts.length));
        this.loadCountedFields = loadCountedFields;  
        if (loadCountedFields) {
 * not use this file except in compliance with the License.
        assertThat(result.getHits().getHits().length, equalTo(ids.length));
    }  
        }
                    .field("type", "token_count")
        assertSearchReturns(searchByNumericRange(7, 10).get(), "multi", "multibulk1", "multibulk2");
    private SearchResponse searchById(String id) {
        }
            } else if (id.equals("multi")) {  
    private void init() throws IOException {
import java.util.ArrayList;  
    private final boolean loadCountedFields;
            foundIds.add(hit.getId());
        @Name("storeCountedFields") boolean storeCountedFields,
    private void assertSearchHit(SearchHit hit, int[] standardTermCounts, int[] englishTermCounts) {  
        assertEquals(
 * specific language governing permissions and limitations
import org.opensearch.action.bulk.BulkResponse;  
        for (boolean storeCountedFields : new boolean[] { true, false }) {
                    .startObject("token_count_without_position_increments")  
                    .field("analyzer", "mock_english")
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        }  
    }  
                assertSearchHit(hit, new int[] { 5 }, new int[] { 4 });
                throw new OpenSearchException("Unexpected response!");
        );
/*  
                randomFrom(Arrays.asList("foo.token_count", "foo.token_count_unstored", "foo.token_count_with_doc_values"))
        }
    public void testFacetByTokenCount() throws IOException {  
                    .startObject("token_count_unstored")  
import static org.hamcrest.Matchers.not;
        assertSearchReturns(searchByNumericRange(10, 10).get(), "multibulk2");  
        assertFalse(bulk.buildFailureMessage(), bulk.hasFailures());
 * compatible open source license.
import static org.hamcrest.Matchers.equalTo;  
 * Licensed to Elasticsearch under one or more contributor  
            .get();
        assertSearchReturns(searchById("single"), "single");  
    }  
        init();
        this.storeCountedFields = storeCountedFields;
            request.addStoredField("foo");  
        assertThat(hit.field("foo.token_count"), not(nullValue()));
import org.opensearch.action.search.SearchRequestBuilder;
            if (id.equals("single")) {  
        assertThat(refresh().getFailedShards(), equalTo(0));  
    }
    @ParametersFactory
        settings.put("index.analysis.analyzer.mock_english.filter", "stop");  
 * Unless required by applicable law or agreed to in writing,
    public void testSearchByTokenCount() throws IOException {
        for (SearchHit hit : result.getHits()) {
                    .field("type", "token_count")
        assertSearchReturns(searchByNumericRange(12, 12).get());  
        assertSearchReturns(searchById("multibulk1"), "multibulk1");
import org.opensearch.common.settings.Settings;
