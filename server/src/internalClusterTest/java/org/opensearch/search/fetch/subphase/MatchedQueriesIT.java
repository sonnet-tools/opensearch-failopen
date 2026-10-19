/*
        int iter = scaledRandomIntBetween(2, 10);
            }
        ensureGreen();
                assertThat(hit.getMatchedQueryScore("title"), greaterThan(0f));
            )
            } else {
        client().prepareIndex("test").setId("3").setSource("name", "test").get();
            .get();
        assertHitCount(searchResponse, 1L);
        indexRandomForConcurrentSearch("test1");
        for (SearchHit hit : searchResponse.getHits()) {
        refresh();
    }
                assertThat(hit.getMatchedQueriesAndScores(), hasKey("title"));
                assertThat(hit.getMatchedQueriesAndScores(), hasKey("test1"));
            .setQuery(
            .setQuery(matchAllQuery())
                assertThat(hit.getMatchedQueriesAndScores().size(), equalTo(1));
        indexRandomForConcurrentSearch("test1");
        refresh();
            .get();
import static org.opensearch.index.query.QueryBuilders.constantScoreQuery;
    public void testMatchedWithWrapperQuery() throws Exception {
import static org.opensearch.index.query.QueryBuilders.termsQuery;
                } else {
            if (hit.getId().equals("1")) {
                assertThat(hit.getMatchedQueryScore("test2"), equalTo(1f));
        SearchResponse searchResponse = client().prepareSearch()
    public void testSimpleMatchedQueryFromFilteredQuery() throws Exception {
            } else {
                    assertThat(hit.getMatchedQueriesAndScores(), hasKey("dolor"));
                    assertThat(hit.getMatchedQueriesAndScores().size(), equalTo(1));
import java.util.Arrays;
            .get();
 * Modifications Copyright OpenSearch Contributors. See
        client().prepareIndex("test").setId("1").setSource("name", "test1", "number", 1).get();
        client().prepareIndex("test1").setId("1").setSource("title", "title1 title2").get();
        for (SearchHit hit : searchResponse.getHits()) {
 * software distributed under the License is distributed on an
            if (hit.getId().equals("1")) {
        }
                assertThat(hit.getMatchedQueryScore("name"), greaterThan(0f));
            assertThat(hit.getMatchedQueriesAndScores(), hasKey("abc"));
        assertHitCount(searchResponse, 3L);
        createIndex("test1");
            }
        QueryBuilder[] queries = new QueryBuilder[] { wrapperQuery(matchBytes), constantScoreQuery(wrapperQuery(termBytes)) };
                assertThat(hit.getMatchedQueriesAndScores().size(), equalTo(1));
        SearchResponse searchResponse = client().prepareSearch()
        ensureGreen();
                } else if (hit.getId().equals("2")) {
            SearchHit hit = searchResponse.getHits().getAt(0);
            } else {
    public void testMatchedWithShould() throws Exception {
            .setQuery(
                assertThat(hit.getMatchedQueriesAndScores(), hasKey("span"));
            )
        ensureGreen();
            if (hit.getId().equals("1")) {
import java.util.Collection;
        indexRandomForConcurrentSearch("test");
        ensureGreen();
                    assertThat(hit.getMatchedQueriesAndScores(), hasKey("elit"));
            }
        for (SearchHit hit : searchResponse.getHits()) {
                        .should(queryStringQuery("dolor").queryName("dolor"))
                    .filter(
                fail("Unexpected document returned with id " + hit.getId());
import static org.opensearch.index.query.QueryBuilders.rangeQuery;
                assertThat(hit.getMatchedQueryScore("title"), greaterThan(0f));
            .setQuery(termsQuery("title", "title1", "title2", "title3").queryName("title"))
                assertThat(hit.getMatchedQueriesAndScores().size(), equalTo(1));
            .setQuery(QueryBuilders.spanFirstQuery(QueryBuilders.spanTermQuery("title", "title1"), 10).queryName("span"))
            .get();
            )
                    assertThat(hit.getMatchedQueryScore("dolor"), greaterThan(0f));
        for (int i = 0; i < iter; i++) {
        SearchResponse searchResponse = client().prepareSearch()
import static org.hamcrest.Matchers.equalTo;
                assertThat(hit.getMatchedQueriesAndScores(), hasKey("test2"));
    @ParametersFactory
import org.opensearch.core.xcontent.XContentHelper;
        }
            .setIncludeNamedQueriesScore(true)
                }
import static org.hamcrest.Matchers.hasKey;
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testPrefixQuerySupportsName() throws InterruptedException {
        ensureGreen();
        ensureGreen();
        createIndex("test1");
        for (SearchHit hit : searchResponse.getHits()) {
        assertHitCount(searchResponse, 1L);
            } else if (hit.getId().equals("3")) {
        indexRandomForConcurrentSearch("test1");
        }
                            .should(rangeQuery("number").gte(2).queryName("test2"))
        BytesReference matchBytes = XContentHelper.toXContent(matchQueryBuilder, MediaTypeRegistry.JSON, false);
                assertThat(hit.getMatchedQueries(), hasItemInArray("title"));
import org.opensearch.core.xcontent.MediaTypeRegistry;
            .setQuery(QueryBuilders.regexpQuery("title", "title1").queryName("regex"))
 *
            assertHitCount(searchResponse, 2L);
        assertHitCount(searchResponse, 3L);
            assertThat(hit.getMatchedQueriesAndScores().size(), equalTo(1));
            .setQuery(QueryBuilders.prefixQuery("title", "title").queryName("prefix"))
    public void testWildcardQuerySupportsName() throws InterruptedException {
            } else {
            assertThat(hit.getMatchedQueryScore("abc"), greaterThan(0f));
                assertThat(hit.getMatchedQueryScore("span"), greaterThan(0f));
import org.opensearch.index.query.QueryBuilders;
            if (hit.getId().equals("1")) {
public class MatchedQueriesIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        SearchResponse searchResponse = client().prepareSearch()
    }
        for (SearchHit hit : searchResponse.getHits()) {
                    fail("Unexpected document returned with id " + hit.getId());
        createIndex("test1");
 * Unless required by applicable law or agreed to in writing,
                    )
                assertThat(hit.getMatchedQueryScore("name"), greaterThan(0f));
import org.opensearch.core.common.bytes.BytesReference;
    }
     */
                assertThat(hit.getMatchedQueries().length, equalTo(2));
import org.opensearch.action.search.SearchResponse;
 * Licensed to Elasticsearch under one or more contributor
            .get();
        }
                assertThat(hit.getMatchedQueryScore("name"), greaterThan(0f));
            .setQuery(QueryBuilders.wildcardQuery("title", "titl*").queryName("wildcard"))
        var searchResponse = query.get();
        client().prepareIndex("test").setId("2").setSource("content", "consectetur adipisicing elit").get();
        return Arrays.asList(
                .setQuery(
            if (hit.getId().equals("1")) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            if (hit.getId().equals("3") || hit.getId().equals("2")) {
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                fail("Unexpected document returned with id " + hit.getId());
                assertThat(hit.getMatchedQueriesAndScores().size(), equalTo(1));
        client().prepareIndex("test").setId("2").setSource("name", "test", "title", "title2").get();
        }
                    boolQuery().minimumShouldMatch(1)
    }
        client().prepareIndex("test1").setId("1").setSource("title", "title1").get();
    public void testSpanFirstQuerySupportsName() throws InterruptedException {
        for (SearchHit hit : searchResponse.getHits()) {
            if (hit.getId().equals("1") || hit.getId().equals("2") || hit.getId().equals("3")) {
        }
                assertThat(hit.getMatchedQueryScore("prefix"), equalTo(1f));
                assertThat(hit.getMatchedQueriesAndScores().size(), equalTo(2));
                if (hit.getId().equals("1")) {
        searchResponse = client().prepareSearch()
                boolQuery().must(matchAllQuery())
        SearchResponse searchResponse = client().prepareSearch()
        client().prepareIndex("test").setId("1").setSource("content", "Lorem ipsum dolor sit amet").get();
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
    }
        assertHitCount(searchResponse, 3L);
                assertThat(hit.getMatchedQueryScore("test2"), equalTo(1f));
        TermQueryBuilder termQueryBuilder = termQuery("content", "amet").queryName("abc");
                fail("Unexpected document returned with id " + hit.getId());
            .setQuery(matchAllQuery())
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        }
import static org.opensearch.index.query.QueryBuilders.queryStringQuery;
            }
        indexRandomForConcurrentSearch("test");
        for (SearchHit hit : searchResponse.getHits()) {
        assertHitCount(searchResponse, 1L);
                )
    public void testRegExpQuerySupportsName() throws InterruptedException {
 * You may obtain a copy of the License at
        createIndex("test1");
        refresh();
 *
                assertThat(hit.getMatchedQueriesAndScores(), hasKey("name"));
                assertThat(hit.getMatchedQueryScore("wildcard"), equalTo(1f));
    public void testSimpleMatchedQueryFromTopLevelFilterAndFilteredQuery() throws Exception {
                .get();
        assertHitCount(searchResponse, 1L);
        MatchQueryBuilder matchQueryBuilder = matchQuery("content", "amet").queryName("abc");
        indexRandomForConcurrentSearch("test");
            if (hit.getId().equals("1") || hit.getId().equals("2")) {
            }
        createIndex("test");
                assertThat(hit.getMatchedQueryScore("test1"), equalTo(1f));
        assertHitCount(searchResponse, 1L);
 * this work for additional information regarding copyright
        client().prepareIndex("test").setId("2").setSource("name", "test2", "number", 2).get();
                assertThat(hit.getMatchedQueriesAndScores(), hasKey("name"));
        indexRandomForConcurrentSearch("test");
        // Execute search at least two times to load it in cache
                assertThat(hit.getMatchedQueriesAndScores().size(), equalTo(1));
        createIndex("test");
            } else if (hit.getId().equals("2") || hit.getId().equals("3")) {
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        ensureGreen();
    public void testFuzzyQuerySupportsName() throws InterruptedException {
    }
        for (SearchHit hit : searchResponse.getHits()) {
import org.opensearch.search.SearchHit;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .setPostFilter(matchQuery("name", "test").queryName("name"))
            for (SearchHit hit : searchResponse.getHits()) {
            .get();
 */
                assertThat(hit.getMatchedQueriesAndScores(), hasKey("name"));
 * under the License.
import static org.hamcrest.Matchers.greaterThan;
        }
            if (hit.getId().equals("1")) {
                assertThat(hit.getMatchedQueriesAndScores(), hasKey("fuzzy"));
        super(staticSettings);
 *
        }
import static org.opensearch.index.query.QueryBuilders.matchQuery;
            }
 * KIND, either express or implied.  See the License for the
                fail("Unexpected document returned with id " + hit.getId());
import org.opensearch.index.query.TermQueryBuilder;
import static org.opensearch.index.query.QueryBuilders.boolQuery;
            .setIncludeNamedQueriesScore(true);
                assertThat(hit.getMatchedQueriesAndScores(), hasKey("wildcard"));
    }
            .setQuery(boolQuery().must(matchAllQuery()).filter(termsQuery("title", "title1", "title2", "title3").queryName("title")))
        for (SearchHit hit : searchResponse.getHits()) {
                    assertThat(hit.getMatchedQueriesAndScores().size(), equalTo(1));
    }
        client().prepareIndex("test").setId("3").setSource("name", "test3", "number", 3).get();
 */
import org.opensearch.common.settings.Settings;
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            }
                fail("Unexpected document returned with id " + hit.getId());
        BytesReference termBytes = XContentHelper.toXContent(termQueryBuilder, MediaTypeRegistry.JSON, false);
        searchResponse = client().prepareSearch()
                boolQuery().should(rangeQuery("number").lte(2).queryName("test1")).should(rangeQuery("number").gt(2).queryName("test2"))
                assertThat(hit.getMatchedQueries(), hasItemInArray("name"));
                assertThat(hit.getMatchedQueriesAndScores().size(), equalTo(1));
            .setPostFilter(
                boolQuery().should(termQuery("name", "test").queryName("name")).should(termQuery("title", "title1").queryName("title"))
        createIndex("test");
                fail("Unexpected document returned with id " + hit.getId());
        client().prepareIndex("test1").setId("1").setSource("title", "title1").get();
                fail("Unexpected document returned with id " + hit.getId());
            if (hit.getId().equals("1") || hit.getId().equals("2") || hit.getId().equals("3")) {
    /**
        indexRandomForConcurrentSearch("test1");
        refresh();
            .setIncludeNamedQueriesScore(true)
            }
        refresh();
            .get();
                assertThat(hit.getMatchedQueriesAndScores().size(), equalTo(2));
 * compatible open source license.
        indexRandomForConcurrentSearch("test");
            SearchResponse searchResponse = client().prepareSearch()
    }
                assertThat(hit.getMatchedQueryScore("title"), greaterThan(0f));
                assertThat(hit.getMatchedQueryScore("regex"), equalTo(1f));
        indexRandomForConcurrentSearch("test1");
                assertThat(hit.getMatchedQueriesAndScores().size(), equalTo(1));
                fail("Unexpected document returned with id " + hit.getId());
 */
import static org.opensearch.index.query.QueryBuilders.wrapperQuery;
import org.opensearch.index.query.MatchQueryBuilder;
        refresh();
                assertThat(hit.getMatchedQueriesAndScores(), hasKey("name"));
            .get();
    }
        client().prepareIndex("test1").setId("1").setSource("title", "title1").get();
                assertThat(hit.getMatchedQueriesAndScores(), hasKey("test1"));
        client().prepareIndex("test1").setId("1").setSource("title", "title1").get();
        refresh();
            .setIncludeNamedQueriesScore(true)
                assertThat(hit.getMatchedQueriesAndScores(), hasKey("title"));
        SearchResponse searchResponse = client().prepareSearch()
        for (QueryBuilder query : queries) {
            } else {
            if (hit.getId().equals("1")) {
            .setIncludeNamedQueriesScore(true)
        client().prepareIndex("test").setId("1").setSource("name", "test", "title", "title1").get();
            SearchResponse searchResponse = client().prepareSearch().setQuery(query).get();
            }
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
                assertThat(hit.getMatchedQueriesAndScores(), hasKey("name"));
     * Test case for issue #4361: https://github.com/elastic/elasticsearch/issues/4361
        createIndex("test");
        ensureGreen();
        );
                assertThat(hit.getMatchedQueryScore("fuzzy"), greaterThan(0f));
            .setQuery(QueryBuilders.fuzzyQuery("title", "titel1").queryName("fuzzy"))
            .get();
                        boolQuery().should(rangeQuery("number").lt(2).queryName("test1"))
        var query = client().prepareSearch()
 * not use this file except in compliance with the License.
        client().prepareIndex("test").setId("3").setSource("name", "test", "title", "title3").get();
/*
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        }
                assertThat(hit.getMatchedQueryScore("name"), greaterThan(0f));
        searchResponse = client().prepareSearch()
            } else {
                assertThat(hit.getMatchedQueryScore("name"), greaterThan(0f));
        ensureGreen();
            } else if (hit.getId().equals("1")) {
 * ownership. Elasticsearch licenses this file to you under
                assertThat(hit.getMatchedQueriesAndScores(), hasKey("prefix"));
import static org.hamcrest.Matchers.hasItemInArray;
 * this file be licensed under the Apache-2.0 license or a
                assertThat(hit.getMatchedQueriesAndScores(), hasKey("regex"));
        for (SearchHit hit : searchResponse.getHits()) {
                assertThat(hit.getMatchedQueriesAndScores(), hasKey("title"));
        refresh();
                assertThat(hit.getMatchedQueriesAndScores(), hasKey("test2"));
}
 * GitHub history for details.
                fail("Unexpected document returned with id " + hit.getId());
            } else {
        refresh();
                assertThat(hit.getMatchedQueriesAndScores().size(), equalTo(1));
                assertThat(hit.getMatchedQueriesAndScores().size(), equalTo(1));
    public static Collection<Object[]> parameters() {
                        .should(queryStringQuery("elit").queryName("elit"))
    }
                assertThat(hit.getMatchedQueriesAndScores().size(), equalTo(1));
            } else {
            } else {
        assertHitCount(searchResponse, 3L);
        }
                assertThat(hit.getMatchedQueryScore("test1"), equalTo(1f));
        }
                    assertThat(hit.getMatchedQueryScore("elit"), greaterThan(0f));
 * SPDX-License-Identifier: Apache-2.0
                .setPreference("_primary")
                boolQuery().should(termQuery("name", "test").queryName("name")).should(termQuery("title", "title1").queryName("title"))
            } else {
            }
 * specific language governing permissions and limitations
import static org.opensearch.index.query.QueryBuilders.termQuery;
    }
            } else if (hit.getId().equals("2") || hit.getId().equals("3")) {
        }
        for (SearchHit hit : searchResponse.getHits()) {
            assertHitCount(searchResponse, 1L);
        client().prepareIndex("test").setId("2").setSource("name", "test").get();
        assertHitCount(searchResponse, 3L);
                fail("Unexpected document returned with id " + hit.getId());
                fail("Unexpected document returned with id " + hit.getId());
    public void testSimpleMatchedQueryFromTopLevelFilter() throws Exception {
package org.opensearch.search.fetch.subphase;
        ensureGreen();
            .setPostFilter(termQuery("name", "test").queryName("name"))
            }
        createIndex("test");
 * The OpenSearch Contributors require contributions made to
            )
            } else {
                assertThat(hit.getMatchedQueriesAndScores().size(), equalTo(1));
        assertHitCount(searchResponse, 3L);
import org.opensearch.index.query.QueryBuilder;
/*
        refresh();
                assertThat(hit.getMatchedQueriesAndScores().size(), equalTo(2));
        SearchResponse searchResponse = client().prepareSearch()
    public MatchedQueriesIT(Settings staticSettings) {
        createIndex("test1");
        client().prepareIndex("test").setId("1").setSource("content", "Lorem ipsum dolor sit amet").get();
            .get();
        client().prepareIndex("test").setId("1").setSource("name", "test", "title", "title1").get();
            .setPostFilter(
            }
