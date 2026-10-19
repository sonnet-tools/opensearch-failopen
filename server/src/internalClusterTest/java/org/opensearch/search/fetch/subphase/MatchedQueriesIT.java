        for (SearchHit hit : searchResponse.getHits()) {
        for (SearchHit hit : searchResponse.getHits()) {  
                        .should(queryStringQuery("dolor").queryName("dolor"))
        assertHitCount(searchResponse, 1L);
                assertThat(hit.getMatchedQueriesAndScores().size(), equalTo(1));
            }
        for (SearchHit hit : searchResponse.getHits()) {
            assertHitCount(searchResponse, 1L);
        indexRandomForConcurrentSearch("test");
import static org.opensearch.index.query.QueryBuilders.termQuery;  
            } else {  
        for (int i = 0; i < iter; i++) {
                .setQuery(  
        client().prepareIndex("test").setId("3").setSource("name", "test").get();  
        super(staticSettings);
        var query = client().prepareSearch()
        refresh();  
        createIndex("test1");
                assertThat(hit.getMatchedQueriesAndScores(), hasKey("prefix"));
        );  
        SearchResponse searchResponse = client().prepareSearch()
    }  
            .setQuery(boolQuery().must(matchAllQuery()).filter(termsQuery("title", "title1", "title2", "title3").queryName("title")))  
        for (SearchHit hit : searchResponse.getHits()) {  
                fail("Unexpected document returned with id " + hit.getId());  
            .get();
        }  
        ensureGreen();  
            } else {
    public void testMatchedWithWrapperQuery() throws Exception {
        for (SearchHit hit : searchResponse.getHits()) {
 * Unless required by applicable law or agreed to in writing,
    }
import static org.opensearch.index.query.QueryBuilders.matchQuery;  
        assertHitCount(searchResponse, 3L);
        assertHitCount(searchResponse, 1L);
                } else {  
                assertThat(hit.getMatchedQueryScore("span"), greaterThan(0f));
        MatchQueryBuilder matchQueryBuilder = matchQuery("content", "amet").queryName("abc");  
            if (hit.getId().equals("3") || hit.getId().equals("2")) {
}
            } else {
                assertThat(hit.getMatchedQueriesAndScores(), hasKey("span"));  
import org.opensearch.index.query.MatchQueryBuilder;
            .get();
                            .should(rangeQuery("number").gte(2).queryName("test2"))  
        client().prepareIndex("test").setId("3").setSource("name", "test", "title", "title3").get();
    }
        int iter = scaledRandomIntBetween(2, 10);  
 * not use this file except in compliance with the License.
                assertThat(hit.getMatchedQueryScore("fuzzy"), greaterThan(0f));  
 */  
        createIndex("test");
            }  
            assertThat(hit.getMatchedQueriesAndScores().size(), equalTo(1));  
            assertThat(hit.getMatchedQueryScore("abc"), greaterThan(0f));
            }  
                boolQuery().should(rangeQuery("number").lte(2).queryName("test1")).should(rangeQuery("number").gt(2).queryName("test2"))
                assertThat(hit.getMatchedQueriesAndScores(), hasKey("title"));  
                assertThat(hit.getMatchedQueryScore("test2"), equalTo(1f));
                assertThat(hit.getMatchedQueriesAndScores().size(), equalTo(1));
import static org.opensearch.index.query.QueryBuilders.wrapperQuery;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
            if (hit.getId().equals("1")) {
import static org.opensearch.index.query.QueryBuilders.constantScoreQuery;
            )
            .setPostFilter(matchQuery("name", "test").queryName("name"))  
        client().prepareIndex("test1").setId("1").setSource("title", "title1").get();
        for (SearchHit hit : searchResponse.getHits()) {  
        client().prepareIndex("test").setId("2").setSource("name", "test", "title", "title2").get();  
                assertThat(hit.getMatchedQueryScore("name"), greaterThan(0f));
        assertHitCount(searchResponse, 1L);
        client().prepareIndex("test").setId("1").setSource("name", "test", "title", "title1").get();
        searchResponse = client().prepareSearch()
        }
                boolQuery().should(termQuery("name", "test").queryName("name")).should(termQuery("title", "title1").queryName("title"))
            } else {
                assertThat(hit.getMatchedQueriesAndScores().size(), equalTo(1));  
                assertThat(hit.getMatchedQueryScore("title"), greaterThan(0f));
            }
                assertThat(hit.getMatchedQueriesAndScores(), hasKey("wildcard"));  
 * KIND, either express or implied.  See the License for the
package org.opensearch.search.fetch.subphase;
                assertThat(hit.getMatchedQueryScore("test1"), equalTo(1f));
                assertThat(hit.getMatchedQueriesAndScores(), hasKey("title"));
        ensureGreen();  
        indexRandomForConcurrentSearch("test1");
            .get();
 * this work for additional information regarding copyright
            .setQuery(termsQuery("title", "title1", "title2", "title3").queryName("title"))
        var searchResponse = query.get();
import org.opensearch.index.query.QueryBuilders;
            } else {
                fail("Unexpected document returned with id " + hit.getId());
        searchResponse = client().prepareSearch()  
import java.util.Arrays;  
 * You may obtain a copy of the License at  
 * under the License.  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
import static org.opensearch.index.query.QueryBuilders.termsQuery;
        SearchResponse searchResponse = client().prepareSearch()  
                if (hit.getId().equals("1")) {
                    assertThat(hit.getMatchedQueriesAndScores(), hasKey("elit"));
            } else {  
                assertThat(hit.getMatchedQueries(), hasItemInArray("title"));
        refresh();  
 */
            .get();
        }
                assertThat(hit.getMatchedQueriesAndScores().size(), equalTo(2));  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
        createIndex("test");
        assertHitCount(searchResponse, 3L);
                .get();  
                fail("Unexpected document returned with id " + hit.getId());
                assertThat(hit.getMatchedQueryScore("name"), greaterThan(0f));  
        ensureGreen();
        }
                assertThat(hit.getMatchedQueriesAndScores(), hasKey("test1"));
            SearchResponse searchResponse = client().prepareSearch()
    public void testSimpleMatchedQueryFromTopLevelFilter() throws Exception {  
 * ownership. Elasticsearch licenses this file to you under  
            .setIncludeNamedQueriesScore(true)  
                assertThat(hit.getMatchedQueriesAndScores().size(), equalTo(2));
import static org.hamcrest.Matchers.hasKey;
        indexRandomForConcurrentSearch("test");  
                    .filter(
            .setQuery(QueryBuilders.spanFirstQuery(QueryBuilders.spanTermQuery("title", "title1"), 10).queryName("span"))
        }  
        client().prepareIndex("test1").setId("1").setSource("title", "title1").get();  
        indexRandomForConcurrentSearch("test1");  
        client().prepareIndex("test").setId("2").setSource("content", "consectetur adipisicing elit").get();
    }
public class MatchedQueriesIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
                assertThat(hit.getMatchedQueryScore("title"), greaterThan(0f));
                fail("Unexpected document returned with id " + hit.getId());  
            .get();
        createIndex("test");
/*  
    /**
            if (hit.getId().equals("1")) {  
                        boolQuery().should(rangeQuery("number").lt(2).queryName("test1"))
        ensureGreen();
            if (hit.getId().equals("1")) {  
        }
            } else {
            .get();  
            assertThat(hit.getMatchedQueriesAndScores(), hasKey("abc"));
        ensureGreen();
                assertThat(hit.getMatchedQueryScore("regex"), equalTo(1f));
                assertThat(hit.getMatchedQueriesAndScores().size(), equalTo(1));
        client().prepareIndex("test").setId("1").setSource("name", "test", "title", "title1").get();
                assertThat(hit.getMatchedQueryScore("name"), greaterThan(0f));  
        refresh();
    public void testPrefixQuerySupportsName() throws InterruptedException {  
            if (hit.getId().equals("1") || hit.getId().equals("2") || hit.getId().equals("3")) {
                assertThat(hit.getMatchedQueriesAndScores(), hasKey("name"));
            .setPostFilter(termQuery("name", "test").queryName("name"))
            } else {
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                assertThat(hit.getMatchedQueriesAndScores(), hasKey("test2"));
        QueryBuilder[] queries = new QueryBuilder[] { wrapperQuery(matchBytes), constantScoreQuery(wrapperQuery(termBytes)) };
                    assertThat(hit.getMatchedQueryScore("elit"), greaterThan(0f));
            .setIncludeNamedQueriesScore(true);
import org.opensearch.action.search.SearchResponse;  
            if (hit.getId().equals("1")) {  
            }
 *
        }
            }
            )
 */  
 * Licensed to Elasticsearch under one or more contributor  
        client().prepareIndex("test").setId("3").setSource("name", "test3", "number", 3).get();  
            .get();  
            }
import org.opensearch.common.settings.Settings;
        createIndex("test1");  
        SearchResponse searchResponse = client().prepareSearch()
            .setQuery(QueryBuilders.prefixQuery("title", "title").queryName("prefix"))  
        indexRandomForConcurrentSearch("test");
            )
                fail("Unexpected document returned with id " + hit.getId());
                assertThat(hit.getMatchedQueriesAndScores().size(), equalTo(1));  
import org.opensearch.index.query.QueryBuilder;  
                assertThat(hit.getMatchedQueriesAndScores().size(), equalTo(1));
    }  
 * this file be licensed under the Apache-2.0 license or a
            .setQuery(  
                assertThat(hit.getMatchedQueriesAndScores(), hasKey("test2"));  
                    boolQuery().minimumShouldMatch(1)
        SearchResponse searchResponse = client().prepareSearch()  
    }
                boolQuery().must(matchAllQuery())  
            }
import org.opensearch.core.xcontent.MediaTypeRegistry;  
import static org.opensearch.index.query.QueryBuilders.rangeQuery;
            .setQuery(QueryBuilders.wildcardQuery("title", "titl*").queryName("wildcard"))
        assertHitCount(searchResponse, 3L);
        refresh();
import static org.hamcrest.Matchers.hasItemInArray;
        }
                fail("Unexpected document returned with id " + hit.getId());
        indexRandomForConcurrentSearch("test1");
    public void testSimpleMatchedQueryFromTopLevelFilterAndFilteredQuery() throws Exception {
        ensureGreen();  
            if (hit.getId().equals("1")) {  
    public MatchedQueriesIT(Settings staticSettings) {  
        indexRandomForConcurrentSearch("test");
        refresh();
            .setPostFilter(  
            .setIncludeNamedQueriesScore(true)  
                .setPreference("_primary")
        assertHitCount(searchResponse, 1L);  
            .setQuery(QueryBuilders.fuzzyQuery("title", "titel1").queryName("fuzzy"))
    @ParametersFactory
        assertHitCount(searchResponse, 3L);
            .setPostFilter(
                assertThat(hit.getMatchedQueries(), hasItemInArray("name"));  
 * compatible open source license.
                assertThat(hit.getMatchedQueries().length, equalTo(2));
        indexRandomForConcurrentSearch("test");  
    }
import static org.hamcrest.Matchers.equalTo;
            }  
        indexRandomForConcurrentSearch("test1");
            } else {
                    fail("Unexpected document returned with id " + hit.getId());
            for (SearchHit hit : searchResponse.getHits()) {  
        }
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        client().prepareIndex("test").setId("1").setSource("content", "Lorem ipsum dolor sit amet").get();
            if (hit.getId().equals("1") || hit.getId().equals("2")) {
    public void testRegExpQuerySupportsName() throws InterruptedException {
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
                    assertThat(hit.getMatchedQueriesAndScores().size(), equalTo(1));  
        refresh();
                assertThat(hit.getMatchedQueriesAndScores(), hasKey("title"));
                assertThat(hit.getMatchedQueriesAndScores(), hasKey("name"));
                assertThat(hit.getMatchedQueriesAndScores(), hasKey("name"));
            .setQuery(matchAllQuery())
import org.opensearch.index.query.TermQueryBuilder;
    }
        createIndex("test1");
    }  
 * software distributed under the License is distributed on an
                fail("Unexpected document returned with id " + hit.getId());
import static org.hamcrest.Matchers.greaterThan;  
            .get();  
                assertThat(hit.getMatchedQueriesAndScores().size(), equalTo(1));
            }  
        for (SearchHit hit : searchResponse.getHits()) {
            assertHitCount(searchResponse, 2L);
 * The OpenSearch Contributors require contributions made to  
            SearchResponse searchResponse = client().prepareSearch().setQuery(query).get();  
    public static Collection<Object[]> parameters() {
        refresh();
 * the Apache License, Version 2.0 (the "License"); you may
        }  
                assertThat(hit.getMatchedQueriesAndScores().size(), equalTo(1));
import static org.opensearch.index.query.QueryBuilders.boolQuery;  
            )
        for (SearchHit hit : searchResponse.getHits()) {
    public void testSimpleMatchedQueryFromFilteredQuery() throws Exception {  
            .setIncludeNamedQueriesScore(true)
        indexRandomForConcurrentSearch("test1");
                assertThat(hit.getMatchedQueriesAndScores().size(), equalTo(1));
    public void testFuzzyQuerySupportsName() throws InterruptedException {
                assertThat(hit.getMatchedQueriesAndScores(), hasKey("name"));
            .setIncludeNamedQueriesScore(true)  
                assertThat(hit.getMatchedQueriesAndScores(), hasKey("fuzzy"));
                assertThat(hit.getMatchedQueriesAndScores().size(), equalTo(2));
        SearchResponse searchResponse = client().prepareSearch()
                assertThat(hit.getMatchedQueryScore("wildcard"), equalTo(1f));
            .get();
import org.opensearch.core.xcontent.XContentHelper;
        client().prepareIndex("test1").setId("1").setSource("title", "title1").get();
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                assertThat(hit.getMatchedQueryScore("name"), greaterThan(0f));  
 * license agreements. See the NOTICE file distributed with
                }
        SearchResponse searchResponse = client().prepareSearch()
        assertHitCount(searchResponse, 1L);  
                    assertThat(hit.getMatchedQueryScore("dolor"), greaterThan(0f));
                assertThat(hit.getMatchedQueriesAndScores(), hasKey("regex"));
            } else if (hit.getId().equals("3")) {
        for (SearchHit hit : searchResponse.getHits()) {  
        }
            if (hit.getId().equals("1")) {
            } else if (hit.getId().equals("1")) {
                fail("Unexpected document returned with id " + hit.getId());
            } else {
import org.opensearch.core.common.bytes.BytesReference;
        createIndex("test");  
                fail("Unexpected document returned with id " + hit.getId());  
        assertHitCount(searchResponse, 3L);  
import org.opensearch.search.SearchHit;  
                assertThat(hit.getMatchedQueriesAndScores(), hasKey("name"));
            } else if (hit.getId().equals("2") || hit.getId().equals("3")) {  
        }
 *
                    )
        createIndex("test1");  
        }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testMatchedWithShould() throws Exception {
            .get();
        BytesReference termBytes = XContentHelper.toXContent(termQueryBuilder, MediaTypeRegistry.JSON, false);  
    }
                assertThat(hit.getMatchedQueryScore("test2"), equalTo(1f));
     * Test case for issue #4361: https://github.com/elastic/elasticsearch/issues/4361  
            if (hit.getId().equals("1") || hit.getId().equals("2") || hit.getId().equals("3")) {
import java.util.Collection;
 *  
                assertThat(hit.getMatchedQueryScore("title"), greaterThan(0f));
        // Execute search at least two times to load it in cache
        ensureGreen();
 * specific language governing permissions and limitations
                fail("Unexpected document returned with id " + hit.getId());  
                assertThat(hit.getMatchedQueriesAndScores().size(), equalTo(1));
import static org.opensearch.index.query.QueryBuilders.queryStringQuery;
 * Modifications Copyright OpenSearch Contributors. See
                    assertThat(hit.getMatchedQueriesAndScores().size(), equalTo(1));
                boolQuery().should(termQuery("name", "test").queryName("name")).should(termQuery("title", "title1").queryName("title"))  
            .setQuery(
            .setQuery(QueryBuilders.regexpQuery("title", "title1").queryName("regex"))
        client().prepareIndex("test").setId("1").setSource("content", "Lorem ipsum dolor sit amet").get();  
    public void testSpanFirstQuerySupportsName() throws InterruptedException {
                assertThat(hit.getMatchedQueryScore("name"), greaterThan(0f));  
            } else if (hit.getId().equals("2") || hit.getId().equals("3")) {  
                        .should(queryStringQuery("elit").queryName("elit"))  
        return Arrays.asList(  
                assertThat(hit.getMatchedQueryScore("test1"), equalTo(1f));
            if (hit.getId().equals("1")) {
        ensureGreen();
            .setQuery(matchAllQuery())
        refresh();  
        ensureGreen();
    public void testWildcardQuerySupportsName() throws InterruptedException {
            }  
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
                fail("Unexpected document returned with id " + hit.getId());
                assertThat(hit.getMatchedQueryScore("prefix"), equalTo(1f));  
        client().prepareIndex("test1").setId("1").setSource("title", "title1").get();
        client().prepareIndex("test").setId("2").setSource("name", "test2", "number", 2).get();
        for (SearchHit hit : searchResponse.getHits()) {
    }
            } else {  
                } else if (hit.getId().equals("2")) {
        refresh();
                    assertThat(hit.getMatchedQueriesAndScores(), hasKey("dolor"));  
     */
                )
            SearchHit hit = searchResponse.getHits().getAt(0);
        assertHitCount(searchResponse, 3L);
            }
        SearchResponse searchResponse = client().prepareSearch()
        createIndex("test");
        ensureGreen();  
        BytesReference matchBytes = XContentHelper.toXContent(matchQueryBuilder, MediaTypeRegistry.JSON, false);
        searchResponse = client().prepareSearch()
        for (SearchHit hit : searchResponse.getHits()) {  
                assertThat(hit.getMatchedQueriesAndScores(), hasKey("test1"));  
        refresh();
        for (QueryBuilder query : queries) {
        TermQueryBuilder termQueryBuilder = termQuery("content", "amet").queryName("abc");
        client().prepareIndex("test1").setId("1").setSource("title", "title1 title2").get();  
/*  
        client().prepareIndex("test").setId("1").setSource("name", "test1", "number", 1).get();
    }
        createIndex("test1");
                assertThat(hit.getMatchedQueriesAndScores().size(), equalTo(1));  
        client().prepareIndex("test").setId("2").setSource("name", "test").get();
