        assertThat(response.getHits().getHits()[0].getId(), equalTo("1"));  
        e = expectThrows(IllegalArgumentException.class, () -> minMaxQuery(ScoreMode.Avg, 3, 2));
        response = minMaxQuery(ScoreMode.None, 3, null);
    }
import org.opensearch.core.rest.RestStatus;
        assertThat(termsFacet.getBuckets().size(), equalTo(2));
        assertThat(response.getHits().getHits()[0].getId(), equalTo("3"));  
        e = expectThrows(IllegalArgumentException.class, () -> minMaxQuery(ScoreMode.Total, 3, 2));
        client().admin().indices().prepareRefresh().get();  
        response = minMaxQuery(ScoreMode.Avg, 1, null);
        assertThat(searchResponse.getHits().getAt(0).getMatchedQueries()[0], equalTo("test"));  
                    .field("term_vector", "with_positions_offsets")
        assertThat(response.getHits().getTotalHits().value(), equalTo(0L));
            assertThat(searchResponse.getHits().getHits()[3].getId(), equalTo("p003"));  
                    .startObject("join_field")  
import org.opensearch.action.search.SearchPhaseExecutionException;
            assertThat(searchResponse.getHits().getHits()[4].getId(), equalTo("p004"));
        }
            .addSort(SortBuilders.fieldSort("c_field3"))  
            .get();  
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("c1"));
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(3f));  
import static org.opensearch.index.query.QueryBuilders.prefixQuery;
        createIndexRequest("test", "child", "2", "1", "c_field", 1).get();
        assertAcked(
    public void testNamedFilters() throws Exception {
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(1.5f));  
        SearchResponse searchResponse = client().prepareSearch("test")
    private QueryBuilder randomHasParent(String type, String field, String value) {  
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(4f));  
        createIndexRequest("test", "parent", "p2", null, "p_field", "p_value2").get();  
            searchResponse = client().prepareSearch("test")
    public void testAliasesFilterWithHasChildQuery() throws Exception {  
    private List<IndexRequestBuilder> createMinMaxDocBuilders() {
        response = client().prepareSearch("filter2").get();
        assertAcked(prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child")));  
        assertThat(termsFacet.getBuckets().get(1).getDocCount(), equalTo(1L));  
    }
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        indexBuilders.add(createIndexRequest("test", "child", "13", "3", "foo", "one"));
        createIndexRequest("test", "parent", "p1", null, "p_field", "p_value1").get();
    List<IndexRequestBuilder> createDocBuilders() {  
        createIndexRequest(  
        );
        assertAcked(prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child")));
            .setQuery(hasChildQuery("child", termQuery("c_field", "yellow"), ScoreMode.None))
            .get();  
                break; // randomly break out and dont' have deletes / updates
import org.opensearch.search.SearchHit;
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));  
        // Childless parent
            QueryBuilders.functionScoreQuery(
                .field("i_field", "2")
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));  
            .setRefreshPolicy(RefreshPolicy.IMMEDIATE)
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(3f));
            .setQuery(hasParentQuery("parent-type", new IdsQueryBuilder().addIds("parent-id"), false))
        createIndexRequest("test", "child", "c5", "p2", "c_field", "x").get();  
        assertNoFailures(searchResponse);
        response = minMaxQuery(ScoreMode.Total, 1, 3);
            )
        indexBuilders.add(createIndexRequest("test", "child", "12", "p", "c_field1", 1, "c_field2", 1)); // why "p"????  
                .get();
        for (int j = 0; j < 2; j++) {
        assertThat(response.getHits().getTotalHits().value(), equalTo(0L));  
    public void testCachingBugWithFqueryFilter() throws Exception {  
                        boolQuery().must(
        assertThat(searchHits[0].getHighlightFields().get("c_field").getFragments().length, equalTo(1));  
                    new BoolQueryBuilder().must(new MatchQueryBuilder("searchText", "fox"))  
        createIndexRequest("test", "child", "c3", "p2", "c_field", "red").get();  
        // HAS CHILD
                    .endObject()
                    new FunctionScoreQueryBuilder.FilterFunctionBuilder(QueryBuilders.termQuery("foo", "three"), weightFactorFunction(1)),
        assertAcked(
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));  
                    .field("grandparent", "parent")  
        // Score mode = MAX
            client().prepareSearch("test").setQuery(hasChildQuery("child", termQuery("c_field", "1"), ScoreMode.Max)).get();
        assertThat(searchResponse.getHits().getAt(0).getId(), anyOf(equalTo("p2"), equalTo("p1")));  
            .get();  
            )
    }  
        QueryBuilder[] queries = new QueryBuilder[] {  
                .setSearchType(searchType)
        assertThat(e.getMessage(), equalTo("[has_child] 'max_children' is less than 'min_children'"));  
            .addAggregation(
            assertNoFailures(searchResponse);  
        createIndexRequest("test", "parent", "p6", null, "p_field", "p_value6").get();
            .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
            .get();
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));
            String parentId = String.format(Locale.ROOT, "p%03d", i);  
                )
        createIndexRequest("test", "child", "c4", "p2", "c_field", "red").get();  
        indexBuilders.add(createIndexRequest("test", "child", "11", "2", "foo", "one"));  
 * compatible open source license.
            .get();
        ensureGreen();  
import java.util.Locale;
                        .boostMode(CombineFunction.REPLACE),
 * not use this file except in compliance with the License.
                    hasChildQuery(  
        client().admin().indices().prepareFlush().get();
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(2f));
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));
        assertThat(response.getHits().getHits()[3].getId(), equalTo("19"));
                    .endObject()
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));
            assertThat(e.status(), equalTo(RestStatus.BAD_REQUEST));
                    .field("parent-type", "child-type")  
        searchResponse = client().prepareSearch("test")  
            client().admin().indices().prepareRefresh("test").get();
        assertThat(response.getHits().getTotalHits().value(), equalTo(1L));
        createIndexRequest("test", "child", "c1", parentId, "c_field", "1").get();
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));  
                )
    public void testSimpleQueryRewrite() throws Exception {
        assertNoFailures(searchResponse);
        createIndexRequest("test", "child", "c5", "p3", "c_field", "blue").get();
        // Parent 2 and its children
        searchResponse = client().prepareSearch("test").setQuery(randomHasChild("child", "c_field", "yellow")).get();
        Global global = searchResponse.getAggregations().get("global");
                    boolQuery().should(termQuery("c_field", "red")).should(termQuery("c_field", "yellow")),
        assertThat(response.getHits().getHits()[2].getScore(), equalTo(1f));
                            boolQuery().should(termQuery("c_field", "red")).should(termQuery("c_field", "yellow"))
        assertThat(e.getMessage(), equalTo("[has_child] 'max_children' is less than 'min_children'"));
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
    }
        response = minMaxQuery(ScoreMode.Total, 2, null);
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));  
        String parentId = "p1";
                .endArray()
        refresh();
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(3f));
            if (randomBoolean()) {
            createIndexRequest("test", "parent", "p" + i, null).get();  
        indexBuilders.add(createIndexRequest("test", "child", "14", "2", "c_field1", 1, "c_field2", 1));
import java.util.HashSet;  
        assertHitCount(searchResponse, 1L);
                        .filter(
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("c3"));
                boolQuery().must(matchAllQuery())  
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("2"));
        } else {
        client().admin().indices().prepareFlush("test").get();
        refresh();
import static org.opensearch.index.query.QueryBuilders.queryStringQuery;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(2f));
    public void testParentChildCaching() throws Exception {  
        ensureGreen();
        response = minMaxQuery(ScoreMode.Avg, 3, null);
            searchResponse = client().prepareSearch("test")  
        e = expectThrows(IllegalArgumentException.class, () -> minMaxQuery(ScoreMode.Max, 3, 2));  
                .get();
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("c1"));
        indexBuilders.add(createIndexRequest("test", "child", "18", "3", "c_field1", 1, "c_field2", 2, "c_field3", 2));  
        assertThat(searchResponse.getHits().getAt(0).getId(), Matchers.anyOf(equalTo("c3"), equalTo("c4")));  
            .setQuery(hasChildQuery("child", matchAllQuery(), ScoreMode.Total))
        assertAcked(prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child")));  
 * license agreements. See the NOTICE file distributed with
    }
            logger.info("Round {}", i);
    }  
        try {  
        assertNoFailures(searchResponse);
        String[] highlightTypes = new String[] { "plain", "fvh", "unified" };
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
                    new InnerHitBuilder().setHighlightBuilder(
        client().admin().indices().prepareFlush().get();
        SearchResponse searchResponse = client().prepareSearch("test")
                hasChildQuery(  
                    .filter(boolQuery().must(hasChildQuery("child", matchQuery("c_field", "red"), ScoreMode.None)).must(matchAllQuery()))
                hasParentQuery(
                    .field("type", "join")  
                    ScoreMode.Total  
            assertThat(childIds.size(), is(0));  
        // index simple data  
        ensureGreen();  
        assertThat(response.getHits().getTotalHits().value(), equalTo(2L));  
 * this work for additional information regarding copyright
    }  
        // Parent 3 and its children
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(2f));
        // HAS CHILD QUERY
                        .must(new HasParentQueryBuilder("parent-type", new MatchAllQueryBuilder(), false))
        response = minMaxQuery(ScoreMode.None, 4, null);
            return hasParentQuery(type, termQuery(field, value), false);
        assertThat(explainResponse.getExplanation().toString(), containsString("join value p1"));  
        );
                .setQuery(constantScoreQuery(hasParentQuery("parent", matchAllQuery(), true)))
    // see #2744
        assertThat(response.getHits().getTotalHits().value(), equalTo(1L));  
            builders.add(createIndexRequest("test", "child", childId, previousParentId, "c_field", childId));
    public void testParentChildQueriesViaScrollApi() throws Exception {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.hasId;  
                    .filter(  
            .setQuery(  
        createIndexRequest("test", "child", "c2", "p1", "c_field", "yellow").get();  
import static org.opensearch.join.query.JoinQueryBuilders.hasParentQuery;
        refresh();
                            ScoreMode.None
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
        assertThat(searchResponse.getHits().getAt(1).getId(), anyOf(equalTo("p2"), equalTo("p1")));
        ensureGreen();
        response = client().prepareSearch("test")
        // HAS CHILD FILTER  
        }
        assertThat(response.getHits().getHits()[2].getId(), equalTo("1"));  
        client().admin().indices().prepareRefresh("test").get();  
        indexBuilders.add(createIndexRequest("test", "child", "17", "3", "c_field1", 1, "c_field2", 1, "c_field3", 1));
        assertSearchHit(searchResponse, 1, hasId("2"));
        searchResponse = client().prepareSearch("test").setQuery(hasChildQuery("child", termQuery("c_field", "red"), ScoreMode.None)).get();  
        indexBuilders.add(createIndexRequest("test", "child", "15", "3", "foo", "one two three"));
            .get();
        }
        // Parent 1 and its children
        assertThat(response.getHits().getHits()[0].getId(), equalTo("4"));
            prepareCreate("test").setMapping(  
        assertThat(response.getHits().getHits()[0].getId(), equalTo("16"));
        response = minMaxQuery(ScoreMode.None, 1, 3);
        createIndexRequest("test", "child", "c3", "p2", "c_field", "blue").get();
            .setSource(jsonBuilder().startObject().field("text", "value").endObject())  
            .get();  
            HighlightField highlightField = searchResponse.getHits().getAt(0).getHighlightFields().get("searchText");
        assertThat(response.getHits().getTotalHits().value(), equalTo(2L));
        // make sure that when we explicitly set a type, the inner query is executed in the context of the parent type instead  
                .get();
                    ScoreMode.Avg
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("p1"));
        assertThat(searchResponse.getHits().getAt(1).getId(), Matchers.anyOf(equalTo("c3"), equalTo("c4")));
    public void testExplainUsage() throws Exception {  
                .get();
    public void testHasChildAndHasParentFilter_withFilter() throws Exception {  
        for (int i = 0; i < 10; i++) {
            )
        );
/*  
        );  
            .setQuery(
                .setQuery(hasParentQuery("parent", prefixQuery("p_field", "p"), true))
                    boolQuery().must(matchAllQuery())
        }  
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));  
            .setQuery(hasChildQuery("child", termQuery("c_field", "yellow"), ScoreMode.Total))
        client().prepareIndex("test").setId(parentId).setSource("p_field", "1").get();  
    public void testReIndexingParentAndChildDocuments() throws Exception {
    }
        assertThat(response.getHits().getHits()[0].getId(), equalTo("4"));
        client().prepareIndex("test").setId("3").setSource("p_field", 1).get();
        assertNoFailures(searchResponse);  
        assertAcked(prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child")));
        ensureGreen();
    }  
        assertThat(response.getHits().getHits()[2].getId(), equalTo("1"));
import org.opensearch.action.search.SearchResponse;  
        String parentId = "p1";  
        assertAcked(
        assertThat(response.getHits().getHits()[5].getScore(), equalTo(5f));
                    "child",
            .setQuery(
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));  
        createIndexRequest("test", "child", "c3", "p2", "c_field", "red").get();  
                    "parent",  
        response = minMaxQuery(ScoreMode.Avg, 4, null);
        );
                    .endObject()
        assertThat(response.getHits().getHits()[2].getId(), equalTo("2"));
        try {
        );
    }
        indexBuilders.add(createIndexRequest("test", "child1", "22", "3", "c_field1", 1, "c_field2", 2, "c_field3", 6));
                .endObject()  
        assertSearchHit(searchResponse, 1, hasId("2"));
        for (int i = 0; i < 10; i++) {
                    "child",  
                )
        createIndexRequest("test", "child", "c3", "p2", "c_field", "x").get();
            }
        assertAcked(prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child")));
import static org.hamcrest.Matchers.is;
            .setQuery(boolQuery().must(matchQuery("c_field", "x")).must(hasParentQuery("parent", termQuery("p_field", "p_value2"), true)))
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
        createIndexRequest("test", "parent", "p10", null, "p_field", "p_value10").get();  
            .setQuery(
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(1f));
        assertThat(response.getHits().getHits()[0].getId(), equalTo("4"));
        assertThat(response.getHits().getHits()[2].getId(), equalTo("2"));
            prepareCreate("test").setMapping(  
            assertThat(e.status(), equalTo(RestStatus.BAD_REQUEST));
        createIndexRequest("test", "child", "c4", "p2", "c_field", "x").get();
            .get();
            .get();
        searchResponse = client().prepareSearch("grandissue")  
import org.opensearch.action.index.IndexRequestBuilder;
            }
        assertNoFailures(response);  
        searchResponse = client().prepareSearch("test")
        indexBuilders.add(createIndexRequest("test", "child", "10", "2", "c_field1", 3, "c_field2", 0));
 * You may obtain a copy of the License at  
                .addStoredField("_id")
        createIndexRequest("test", "child", "c1", "p1", "c_field", "red").get();
            .setQuery(
        assertHitCount(searchResponse, 1L);  
        response = minMaxQuery(ScoreMode.Max, 1, 3);  
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));
        createIndexRequest("test", "parent", "1", null, "p_field", 1).get();  
        refresh();  
        assertThat(searchResponse.getHits().getAt(0).getScore(), equalTo(3.0f));
        indexBuilders.add(createIndexRequest("test", "child", "8", "1", "c_field1", 1, "c_field2", 1));
        client().admin().indices().prepareFlush("test").get();
        }
            .execute()
            .setQuery(constantScoreQuery(hasParentQuery("parent", termQuery("p_field", "1"), false).queryName("test")))  
                        .boostMode(CombineFunction.REPLACE),  
        // index simple data
            prepareCreate("test").setMapping(  
        SearchResponse searchResponse = client().prepareSearch("test")  
    }
        createIndexRequest(
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
        SearchType[] searchTypes = new SearchType[] { SearchType.QUERY_THEN_FETCH, SearchType.DFS_QUERY_THEN_FETCH };
        searchResponse = client().prepareSearch("test")
        searchResponse = client().prepareSearch("test").setQuery(randomHasParent("parent", "p_field", "p_value1")).get();
                            "child",
            assertThat(parentToChildren.get(previousParentId).add(childId), is(true));  
    public void testParentFieldQuery() throws Exception {
                scannedDocs += scrollResponse.getHits().getHits().length;
        assertThat(response.getHits().getTotalHits().value(), equalTo(2L));
        SearchResponse searchResponse = client().prepareSearch("test")
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(4f));
            prepareCreate("test").setSettings(Settings.builder().put("index.refresh_interval", -1))
        }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHits;
        assertThat(response.getHits().getHits()[2].getScore(), equalTo(1f));
            .setQuery(boolQuery().filter(termQuery("join_field#parent", "p1")).filter(termQuery("join_field", "child")))
            .actionGet();
import java.util.Map;  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                            "filter",  
        indexBuilders.add(createIndexRequest("test", "child", "13", "2", "c_field1", 1, "c_field2", 1));
                .startObject()
        assertAcked(prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child")));  
                parentToChildren.put(previousParentId, new HashSet<>());
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
        response = minMaxQuery(ScoreMode.Avg, 2, 2);
            )
                    "p_field",
        createIndexRequest("test", "parent", "p2", null, "p_field", "p_value2").get();
        // re-index
        indexBuilders.add(createIndexRequest("test", "parent", "1", null, "id", 1));
            .get();  
            return hasChildQuery(type, termQuery(field, value), ScoreMode.None);
        if (randomBoolean()) {
        return indexBuilders;  
        countResponse = client().prepareSearch("test")
        // Parent 4 and its children  
        List<IndexRequestBuilder> builders = new ArrayList<>();  
        assertAcked(prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child")));
                        .must(new HasChildQueryBuilder("child-type", new MatchAllQueryBuilder(), ScoreMode.None))
        response = minMaxQuery(ScoreMode.Max, 2, 2);  
            .actionGet();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;  
                createIndexRequest("test", "child", childUid, parentId, "c_field", childUid).get();
        createIndexRequest("test", "parent", "p2", null, "p_field", "p_value2").get();  
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("p1"));  
            null,  
        assertThat(response.getHits().getHits()[2].getScore(), equalTo(1f));
                new FunctionScoreQueryBuilder.FilterFunctionBuilder[] {  
        client().admin().indices().prepareFlush().get();  
            childId = j;
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo((long) childIds.size()));
        assertThat(response.getHits().getHits()[2].getId(), equalTo("2"));
        assertAcked(
        searchResponse = client().prepareSearch("test")
        ensureGreen();
        searchResponse = client().prepareSearch("test")
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(5f));  
        assertThat(response.getHits().getTotalHits().value(), equalTo(0L));  
        assertAcked(
        createIndexRequest("test", "parent", "p4", null, "p_field", "p_value4").get();  
        assertNoFailures(searchResponse);  
            .get();
        createIndexRequest("test", "child", "2", "1", "c_field", 1).get();
                        )
    public void testHasChildAndHasParentWrappedInAQueryFilter() throws Exception {
    }  
            assertThat(scrollResponse.getHits().getTotalHits().value(), equalTo(10L));
        response = minMaxQuery(ScoreMode.Max, 4, null);
        assertThat(response.getHits().getHits()[1].getId(), equalTo("2"));
import org.opensearch.index.query.InnerHitBuilder;
        createIndexRequest("my-index", "parent", "1", null).get();
            )
                    )  
        searchResponse = client().prepareSearch("test")
        assertHitCount(response, 2L);  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));  
        assertThat(response.getHits().getHits()[2].getScore(), equalTo(1f));
            if (!parentToChildren.containsKey(previousParentId)) {  
                .setSearchType(searchType)
        client().admin().indices().prepareFlush("test").get();  
                )
        response = client().prepareSearch("test")
        assertThat(response.getHits().getHits()[0].getId(), equalTo("2"));
            }  
        ensureGreen();
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("1"));
 * GitHub history for details.
            assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("c001"));  
        } catch (SearchPhaseExecutionException e) {  
        client().admin().indices().prepareFlush("test").setForce(true).get();
        assertThat(searchResponse.getHits().getAt(0).getExplanation().getDescription(), containsString("join value p1"));  
            for (int i = 10; i < 20; i++) {
            .execute()
                            boolQuery().must(termQuery("c_field", "c_value1"))  
                    .endObject()  
            .setQuery(
        createIndexRequest("test", "parent", "p2", null, "p_field", "p_value2").get();
    public void testMultiLevelChild() throws Exception {
            "child",  
    }
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(6f));  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        indexBuilders.add(createIndexRequest("test", "parent", "1", null, "p_field", "p_value1"));  
            assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("child-id"));  
                boolQuery().must(hasChildQuery("child", termQuery("c_field", "red"), scoreMode))  
        assertThat(response.getHits().getTotalHits().value(), equalTo(2L));
        refresh();
        refresh();
    }  
        assertThat(response.getHits().getHits()[0].getId(), equalTo("3"));
            .setQuery(
        assertAcked(
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(1f));
                return boolQuery().must(matchAllQuery()).filter(hasParentQuery(type, termQuery(field, value), false));
        assertNoFailures(searchResponse);  
        createIndexRequest("test", "child", "2", "1", "c_field", "foo bar").get();
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));  
                .setSize(5)
        assertThat(response.getHits().getHits()[2].getScore(), equalTo(1f));
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));  
                .setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child"))
            )
        assertHitCount(countResponse, 1L);  
        searchResponse = client().prepareSearch("test")  
        assertSearchHits(searchResponse, "parent-id");
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("p2"));  
        SearchResponse searchResponse = client().prepareSearch("test")
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(1f));
import org.opensearch.common.lucene.search.function.FunctionScoreQuery;
        assertThat(termsFacet.getBuckets().get(0).getKeyAsString(), equalTo("red"));  
            assertHitCount(searchResponse, 1);
        indexBuilders.add(createIndexRequest("test", "child", "15", "2", "c_field1", 1, "c_field2", 2));  
        assertHitCount(response, 1);
                return constantScoreQuery(hasParentQuery(type, termQuery(field, value), false));  
            .setQuery(boolQuery().must(matchAllQuery()).filter(hasChildQuery("child", matchQuery("c_field", 1), ScoreMode.None)))  
        searchResponse = client().prepareSearch("test")
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("p1"));
        assertSearchHit(searchResponse, 1, hasId("1"));
        createIndexRequest("test", "child", "2", "1", "c_field", 1).get();
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));
            logger.info("Testing with highlight type [{}]", highlightType);  
        refresh();  
            "test",  
        createIndexRequest("test", "child", "c1", "p1", "c_field", "red").get();
            .setQuery(
        if (randomBoolean()) {
        indexBuilders.add(createIndexRequest("test", "child", "18", "4", "foo", "one two three"));
            int j = childId;
import static org.opensearch.index.query.QueryBuilders.idsQuery;
            .setQuery(constantScoreQuery(hasParentQuery("parent", termQuery("p_field", "1"), false)))
        assertNoFailures(searchResponse);
            .get();  
            .get();  
                    .field("index_options", "offsets")  
            assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("parent-id"));  
        response = minMaxQuery(ScoreMode.Total, 2, 2);
        );
        response = client().prepareSearch("test").setQuery(hasParentQuery("parent", matchQuery("text", "value"), false)).get();  
            .get();
                return constantScoreQuery(hasChildQuery(type, termQuery(field, value), ScoreMode.None));  
        client().admin().indices().prepareRefresh("test").get();
            )  
                    "keyword"  
        searchResponse = client().prepareSearch("test")  
    }
            )
        // Score mode = AVG  
            )
        indexBuilders.add(createIndexRequest("test", "child", "17", "4", "foo", "one two"));  
        createIndexRequest("test", "parent", "p5", null, "p_field", "p_value5").get();
        assertThat(response.getHits().getHits()[0].getId(), equalTo("4"));
        }  
        ensureGreen();  
        ensureGreen();
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(1.5f));  
                    .startObject("properties")
                .endObject()
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(2f));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
            admin().indices().prepareAliases().addAlias("my-index", "filter1", hasChildQuery("child", matchAllQuery(), ScoreMode.None))  
        assertNoFailures(searchResponse);
        searchResponse = client().prepareSearch("test")
        createIndexRequest("test", "parent", "p7", null, "p_field", "p_value7").get();  
        assertThat(response.getHits().getHits()[0].getId(), equalTo("4"));
            hasParentQuery("parent", matchAllQuery(), false),  
        refresh();
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
            jsonBuilder().startObject()
        indexBuilders.add(createIndexRequest("test", "child", "10", "1", "foo", "one"));
            )  
 */
        assertThat(response.getHits().getHits()[1].getId(), equalTo("2"));  
        assertThat(response.getHits().getHits()[0].getId(), equalTo("3"));
        client().admin().indices().prepareFlush().get();
    }
        assertThat(searchResponse.getHits().getAt(0).getSourceAsString(), containsString("\"p_value1_updated\""));
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        String previousParentId = null;  
        refresh();
        assertThat(searchResponse.getHits().getAt(0).getMatchedQueries()[0], equalTo("test"));
        assertThat(response.getHits().getHits()[0].getId(), equalTo("4"));  
import java.util.Set;
            .setQuery(hasChildQuery("child", termQuery("c_field", "1"), ScoreMode.Max).queryName("test"))  
                AggregationBuilders.global("global")  
        ensureGreen();  
        createIndexRequest("test", "child", "c1", parentId, "c_field", "1").get();  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
 * Modifications Copyright OpenSearch Contributors. See  
        List<IndexRequestBuilder> builders = new ArrayList<>();  
        assertThat(response.getHits().getHits()[2].getId(), equalTo("4"));  
        ).minMaxChildren(minChildren, maxChildren != null ? maxChildren : HasChildQueryBuilder.DEFAULT_MAX_CHILDREN);  
        client().prepareIndex("test")
        assertHitCount(searchResponse, 1L);
    }  
    private QueryBuilder randomHasChild(String type, String field, String value) {  
        createIndexRequest("test", "child", "c4", "p2", "c_field", "red").get();
                .endArray()
        assertThat(searchResponse.getHits().getAt(1).getId(), anyOf(equalTo("p2"), equalTo("p1")));
        // index simple data with flushes, so we have many segments
        indexRandom(true, createDocBuilders().toArray(new IndexRequestBuilder[0]));
            .setQuery(hasChildQuery("child", termQuery("c_field", "1"), ScoreMode.Max))
        for (QueryBuilder query : queries) {  
    // Issue #3290
            )
            .get();
                    .endObject()  
            assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("c000"));
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("c2"));
                    .subAggregation(
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));  
        assertThat(response.getHits().getHits()[0].getId(), equalTo("4"));
import java.util.List;
import java.util.HashMap;
        indexBuilders.add(createIndexRequest("test", "child", "9", "1", "c_field1", 1, "c_field2", 2));  
        assertHitCount(response, 1L);
        assertThat(response.getHits().getHits()[2].getId(), equalTo("2"));
                .field("i_field", "3")  
            .get();
        assertHitCount(response, 0L);
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(3f));
/*
            .setQuery(constantScoreQuery(hasChildQuery("child", termQuery("c_field", "blue"), ScoreMode.None)))  
        ensureGreen();  
                    ScoreMode.None
        createIndexRequest("test", "child", "c1", "p1", "c_field", "c_value1").get();
        assertThat(searchResponse.getHits().getAt(0).getExplanation().getDescription(), containsString("join value p1"));
            do {  
        assertHitCount(response, 2L);
        refresh();
        assertThat(response.getHits().getHits()[2].getId(), equalTo("4"));
        assertThat(response.getHits().getHits()[0].getId(), equalTo("4"));  
        createIndexRequest("test", "parent", parentId, null, "p_field", "1").get();
        HasChildQueryBuilder hasChildQuery = hasChildQuery(
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(1f));  
        indexBuilders.add(createIndexRequest("test", "parent", "2", null, "id", 2));
        ensureGreen();
import org.opensearch.common.lucene.search.function.CombineFunction;  
        ensureGreen();
            .actionGet();
        assertAcked(prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child")));
import org.opensearch.common.unit.TimeValue;  
            null,
                        ).subAggregation(AggregationBuilders.terms("facet1").field("c_field"))
        createIndexRequest("test", "parent", "p2", null, "p_field", "p_value2").get();  
        assertThat(response.getHits().getHits()[6].getScore(), equalTo(5f));  
        assertThat(response.getHits().getHits()[2].getScore(), equalTo(1f));  
        searchResponse = client().prepareSearch("test").setQuery(randomHasChild("child", "c_field", "blue")).execute().actionGet();
                .actionGet();
        ensureGreen();
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(3f));
        indexBuilders.add(createIndexRequest("test", "child", "14", "3", "foo", "one two"));  
        createIndexRequest("test", "child", "c6", "p4", "c_field", "blue").get();  
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(3f));
        for (SearchType searchType : searchTypes) {  
            searchResponse = client().prepareSearch("test")  
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(2f));
        SearchResponse response = client().prepareSearch("test")
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(500L));
        assertHitCount(countResponse, 1L);  
        createIndexRequest("test", "parent", "p2", null, "p_field", "p_value2").get();
    public void testHasChildQueryWithMinimumScore() throws Exception {
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));
            .setSize(0)  
        assertThat(response.getHits().getHits()[0].getId(), equalTo("3"));
            for (int i = 0; i < searchResponse.getHits().getTotalHits().value(); i++) {
        createIndexRequest("grandissue", "grandparent", "1", null, "name", "Grandpa").get();  
        super(settings);  
        ).get();
        assertThat(searchHits[0].getHighlightFields().get("c_field").getFragments()[0].string(), equalTo("foo <em>bar</em>"));
                    .endObject()
            .setSize(0)  
            assertNoFailures(searchResponse);
        assertThat(response.getHits().getHits()[0].getId(), equalTo("2"));
            .setQuery(hasChildQuery("child", termQuery("c_field", "yellow"), ScoreMode.Total))  
        response = minMaxQuery(ScoreMode.Total, 1, 4);
        // make sure that when we explicitly set a type, the inner query is executed in the context of the child type instead
        createIndexRequest("test", "child", "c1", "p1", "c_field", "blue").get();
        assertNoFailures(response);
        assertAcked(prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child")));
            assertThat(scannedDocs, equalTo(10));  
        indexBuilders.add(createIndexRequest("test", "parent", "4", null, "id", 4));
        assertThat(response.getHits().getHits()[0].getId(), equalTo("3"));
        createIndexRequest("test", "test", "2", "1", "foo", 1).get();  
        assertThat(response.getHits().getTotalHits().value(), equalTo(2L));
        createIndexRequest("test", "parent", "p8", null, "p_field", "p_value8").get();
            boolQuery().must(matchAllQuery()).filter(hasChildQuery("child", matchAllQuery(), ScoreMode.None)),
            .setQuery(constantScoreQuery(hasChildQuery("child", termQuery("c_field", "blue"), ScoreMode.None)))  
        assertNoFailures(searchResponse);  
                    true  
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));
        assertThat(response.getHits().getHits()[2].getScore(), equalTo(1f));  
            .setQuery(hasChildQuery("child", termQuery("c_field", "1"), ScoreMode.Max))  
                .setQuery(
        assertThat(searchResponse.getHits().getAt(0).getMatchedQueries().length, equalTo(1));
            .setQuery(boolQuery().must(matchAllQuery()).filter(hasParentQuery("parent", termQuery("p_field", "p_value1"), false)))  
        SearchResponse response = client().prepareSearch("filter1").get();
        for (int i = 0; i < 10; i++) {  
 * SPDX-License-Identifier: Apache-2.0
        assertThat(searchResponse.getHits().getAt(0).getMatchedQueries().length, equalTo(1));  
            }
        createIndexRequest("test", "child", "c1", "p1", "c_field", "red").get();
            .execute()
import org.opensearch.index.query.functionscore.FunctionScoreQueryBuilder;  
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("c1"));
        createIndexRequest("test", "parent", "p1", null, "p_field", "p_value1").get();
                    hasChildQuery(  
            }
                .setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child"))  
        );
        refresh();
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(1f));  
 *
            .setQuery(boolQuery().filter(termQuery("join_field#parent", "p1")).filter(termQuery("join_field", "child")))  
        response = client().prepareSearch("test").setQuery(hasParentQuery("parent", matchQuery("text", "value"), true)).get();
            )
        response = minMaxQuery(ScoreMode.None, 1, 4);  
            .setExplain(true)
        assertNoFailures(searchResponse);  
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(2f));
                    .startObject("relations")
        assertNoFailures(searchResponse);
    }
        Map<String, Set<String>> parentToChildren = new HashMap<>();
        }
            .get();  
        assertAcked(prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child")));
        assertNoFailures(searchResponse);
        client().admin().indices().prepareRefresh("test").get();  
        indexBuilders.add(createIndexRequest("test", "child", "11", "2", "c_field1", 1, "c_field2", 1));
                addFieldMappings(
        ensureGreen();  
        response = minMaxQuery(ScoreMode.None, 1, null);
        response = minMaxQuery(ScoreMode.Total, 4, null);  
                assertThat(childIds.remove(searchResponse.getHits().getAt(i).getId()), is(true));  
        assertThat(response.getHits().getHits()[0].getId(), equalTo("4"));  
        SearchResponse searchResponse = client().prepareSearch("test")
 * the Apache License, Version 2.0 (the "License"); you may
        );
            .get();  
        assertNoFailures(searchResponse);
        assertThat(response.getHits().getHits()[1].getId(), equalTo("2"));  
        assertThat(searchResponse.getHits().getAt(0).getMatchedQueries()[0], equalTo("test"));
        SearchResponse searchResponse = client().prepareSearch("test")
                .startArray("objects")  
    }  
                                .filter(hasChildQuery("grandchild", termQuery("gc_field", "gc_value1"), ScoreMode.None)),
            SearchResponse scrollResponse = client().prepareSearch("test")
        SearchResponse response;
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));  
    public void testDeletedParent() throws Exception {  
        createIndexRequest("test", "child", "c4", "p2", "c_field", "x").get();  
            .get();
            int scannedDocs = 0;
            .setQuery(hasParentQuery("parent", termQuery("p_field", "1"), true))  
            for (int i = 0; i < 10; i++) {
                assertThat(searchResponse.getHits().getAt(i).getScore(), is(1.0f));
            .get();
        indexBuilders.add(createIndexRequest("test", "child", "4", "1", "c_field1", 1, "c_field2", 0));
        response = minMaxQuery(ScoreMode.None, 2, 2);
    public void testScopedFacet() throws Exception {  
        response = minMaxQuery(ScoreMode.Total, 1, null);
                .setQuery(constantScoreQuery(hasParentQuery("parent", termQuery("p_field", parentToChildrenEntry.getKey()), false)))
            String childId = "c" + i;  
import org.opensearch.search.aggregations.bucket.global.Global;
        assertThat(response.getHits().getHits()[2].getScore(), equalTo(1f));
import org.opensearch.search.fetch.subphase.highlight.HighlightField;
        // TEST FETCHING _parent from child  
                    .should(boolQuery().filter(termQuery("join_field#parent", "p2")).filter(termQuery("join_field", "child")))  
        createIndexRequest("test", "parent", "p1", null, "p_field", "p_value1").get();
        assertThat(response.getHits().getHits()[2].getId(), equalTo("2"));
            client().prepareSearch("test").setPostFilter(hasChildQuery("child", termQuery("c_field", "1"), ScoreMode.None)).get();  
            .setQuery(boolQuery().must(matchAllQuery()).filter(hasParentQuery("parent", termQuery("p_field", 1), false)))
    // Issue #3818  
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));  
        assertNoFailures(searchResponse);
                        boolQuery().must(
        assertThat(extractValue("join_field.name", searchResponse.getHits().getAt(1).getSourceAsMap()), equalTo("child"));
        response = minMaxQuery(ScoreMode.Max, 3, null);
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(3f));  
        searchResponse = client().prepareSearch("test")
 * Unless required by applicable law or agreed to in writing,
        assertAcked(  
            prepareCreate("test").setMapping(
                )
            .get();  
import static org.opensearch.index.query.QueryBuilders.termQuery;  
                )
        createIndexRequest("test", "parent", "p3", null, "p_field", "p_value3").get();
                builders.add(createIndexRequest("test", "child", j + "-" + i, Integer.toString(i), "c_field", i));  
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(1.5f));  
            } else {
        createIndexRequest("test", "child", "c2", "p1", "c_field", "yellow").get();  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));  
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));
    public void testHighlightersIgnoreParentChild() throws IOException {
        // index simple data  
            prepareCreate("test").setSettings(Settings.builder().put(indexSettings()).put("index.refresh_interval", -1))
        assertThat(response.getHits().getHits()[0].getId(), equalTo("4"));  
            assertThat(e.status(), equalTo(RestStatus.BAD_REQUEST));
            .get();
        createIndexRequest("test", "parent", "1", null, "p_field", 1).get();  
        assertSearchHit(searchResponse, 1, hasId("1"));
            .setQuery(boolQuery().must(matchAllQuery()).filter(hasParentQuery("child", termQuery("c_field", "c_value1"), false)))
        response = client().prepareSearch("test")  
                .get();  
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));
/*
            .get();
        assertThat(response.getHits().getTotalHits().value(), equalTo(2L));
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));
        createIndexRequest("test", "child", "c2", "p1", "c_field", "yellow").get();  
    }
                        )  
            .get();
        createIndexRequest("my-index", "child", "2", "1").get();
            assertNoFailures(searchResponse);
            fail();  
    public void testCountApiUsage() throws Exception {
        ensureGreen();
        assertNoFailures(searchResponse);
        SearchResponse searchResponse = client().prepareSearch("test")
        createIndexRequest("test", "child", "c1", parentId, "c_field", "1").get();
                    )
        assertHitCount(countResponse, 1L);  
    @ParametersFactory  
    public void testParentChildQueriesNoParentType() throws Exception {
            .setQuery(
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("p2"));
        // Parent 3 and its children  
import static org.hamcrest.Matchers.equalTo;  
        return Arrays.asList(
        refresh();
            .get();
            .setQuery(boolQuery().must(matchQuery("c_field", "x")).must(hasParentQuery("parent", termQuery("p_field", "p_value2"), true)))
                    "child",
        assertThat(response.getHits().getHits()[1].getId(), equalTo("4"));
            "test",
            SearchResponse searchResponse = client().prepareSearch()
        // index simple data  
        indexRandom(true, builders.toArray(new IndexRequestBuilder[0]));
        for (int i = 0; i < 2; i++) {
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));
                .endObject()  
                    .field("type", "join")
        assertThat(response.getHits().getHits()[0].getId(), equalTo("2"));
        createIndexRequest("test", "child", "c2", "p1", "c_field", "red").get();
        assertThat(response.getHits().getHits()[0].getId(), equalTo("3"));
            assertThat(highlightField.getFragments()[0].string(), equalTo("quick brown <em>fox</em>"));
        indexBuilders.add(createIndexRequest("test", "parent", "2", null, "p_field", "p_value2"));  
            .get();  
        assertThat(response.getHits().getHits()[4].getScore(), equalTo(5f));
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(3f));
                .endObject()
        refresh();
        SearchResponse searchResponse = client().prepareSearch("test")  
        assertHitCount(searchResponse, 1L);
            .get();  
        assertNoFailures(response);
            createIndexRequest("test", "child", "c" + i, "p" + i).get();
        createIndexRequest("test", "child", "c3", "p3", "c_field", "blue").get();
                boolQuery().must(matchAllQuery()).filter(boolQuery().must(hasChildQuery("child", matchQuery("c_field", 1), ScoreMode.None)))
        searchResponse = client().prepareSearch("test").setQuery(randomHasParent("parent", "p_field", "p_value2")).get();
                        ScoreMode.None
    }  
    public void testParentIdQuery() throws Exception {  
        assertThat(response.getHits().getHits()[2].getScore(), equalTo(3f));
        assertThat(response.getHits().getHits()[0].getId(), equalTo("4"));
    public void testHasChildNotBeingCached() throws IOException {
        refresh();
        searchResponse = client().prepareSearch("test")
        );
    public void testParentChildQueriesCanHandleNoRelevantTypesInIndex() throws Exception {
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("c4"));  
        assertThat(searchResponse.getHits().getAt(0).getId(), anyOf(equalTo("c1"), equalTo("c2")));  
        assertThat(response.getHits().getHits()[2].getId(), equalTo("2"));
        assertThat(response.getHits().getHits()[2].getScore(), equalTo(1.5f));
import static org.opensearch.index.query.functionscore.ScoreFunctionBuilders.fieldValueFactorFunction;
                jsonBuilder().startObject()
        ensureGreen();
                        ScoreMode.None
                .setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child"))  
        String parentId = "p1";
                    .startObject("relations")
            }  
                    .field("parent", new String[] { "child_type_one", "child_type_two" })
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));
        createIndexRequest("test", "child", "c3", "p2", "c_field", "blue").get();
    }
import org.opensearch.search.aggregations.bucket.filter.Filter;  
            scoreMode
            .get();  
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(10L));
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(3f));
        assertThat(response.getHits().getTotalHits().value(), equalTo(0L));
        assertThat(searchResponse.getHits().getAt(1).getId(), anyOf(equalTo("p2"), equalTo("p1")));  
        try {
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(6f));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        ensureGreen();  
        createIndexRequest("test", "parent", "p0", null, "p_field", "p0").get();  
            prepareCreate("grandissue").setMapping(  
        assertThat(searchResponse.getHits().getAt(0).getSourceAsString(), containsString("\"p_value1\""));
        for (int i = 0; i < 10; i++) {
        assertHitCount(searchResponse, 2L);
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
                .endObject()
        int childId = 0;
import static org.opensearch.index.query.functionscore.ScoreFunctionBuilders.weightFactorFunction;
        refresh();
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(1f));  
                    .startObject("join_field")
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(1.5f));
import java.util.Arrays;  
        assertThat(searchResponse.getHits().getAt(1).getId(), anyOf(equalTo("c1"), equalTo("c2")));  
        ensureGreen();
        // index simple data
        try {
                .get();  
        searchResponse = client().prepareSearch("test")  
                )
        assertThat(response.getHits().getHits()[0].getId(), equalTo("2"));
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(1f));
        assertThat(response.getHits().getHits()[2].getId(), equalTo("2"));
        assertNoFailures(searchResponse);
        createIndexRequest("test", "child", "c3", "p2", "c_field", "blue").get();
            )
        searchResponse = client().prepareSearch("test")
package org.opensearch.join.query;
import org.opensearch.search.aggregations.AggregationBuilders;
        Filter filter = global.getAggregations().get("filter");  
                    ScoreMode.Max
            assertNoFailures(searchResponse);
import org.opensearch.index.query.MatchQueryBuilder;  
        createIndexRequest("grandissue", "parent", "2", "1", "name", "Dana").get();
        refresh();
            .setQuery(hasChildQuery("test", matchQuery("foo", 1), ScoreMode.None))  
                .startObject()
            .get();  
                .addSort("c_field", SortOrder.ASC)  
        refresh();
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));
                        .boostMode(CombineFunction.REPLACE),
        // index simple data  
        SearchResponse searchResponse = client().prepareSearch("test")  
 * ownership. Elasticsearch licenses this file to you under  
                    .endObject()
        refresh();
            .setQuery(constantScoreQuery(hasChildQuery("child", termQuery("c_field", "yellow"), ScoreMode.None)))  
        createIndexRequest("test", "child", "c1", "p1", "c_field", "red").get();
                boolQuery().must(matchAllQuery())
        assertNoFailures(searchResponse);
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
            SearchResponse searchResponse = client().prepareSearch("test")
        assertThat(response.getHits().getHits()[0].getId(), equalTo("4"));
            .setQuery(
            .get();
        assertHitCount(countResponse, 1L);  
 * software distributed under the License is distributed on an
        assertThat(response.getHits().getHits()[1].getId(), equalTo("2"));
        assertThat(response.getHits().getHits()[2].getScore(), equalTo(1f));  
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder.Field;
            assertThat(e.status(), equalTo(RestStatus.BAD_REQUEST));
    }
 */
        }
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(1f));  
        assertThat(extractValue("join_field.parent", searchResponse.getHits().getAt(1).getSourceAsMap()), equalTo("p1"));
        createIndexRequest("test", "parent", "p1", null, "p_field", "p_value1").get();  
import static org.opensearch.index.query.QueryBuilders.boolQuery;
                    .endObject()  
        assertThat(response.getHits().getHits()[0].getId(), equalTo("3"));  
            .setQuery(
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));  
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(2f));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
        int numChildDocsPerParent = 0;
            .setQuery(boolQuery().filter(termQuery("join_field#parent", "p1")).filter(termQuery("join_field", "child")))
                .field("i_field", "2")  
        assertThat(response.getHits().getHits()[2].getScore(), equalTo(1f));  
    }
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(3f));  
        SearchHit[] searchHits = searchResponse.getHits().getHits()[0].getInnerHits().get("child").getHits();
        builders.clear();  
            .setQuery(hasParentQuery("child", termQuery("c_field", "c_value1"), false))  
            .get();  
public class ChildQuerySearchIT extends ParentChildTestCase {  
        refresh();
                    .field("type", "join")
        assertThat(response.getHits().getHits()[2].getId(), equalTo("2"));  
        createIndexRequest("test", "child", "c1", "p1", "c_field", "x").get();
    }
import org.opensearch.search.sort.SortOrder;
        createIndexRequest("test", "child", "c4", "p2", "c_field", "red").get();  
        assertThat(response.getHits().getTotalHits().value(), equalTo(1L));
        assertThat(response.getHits().getHits()[2].getId(), equalTo("2"));  
                .startObject()
            .setQuery(boolQuery().must(matchAllQuery()).filter(hasParentQuery("parent", matchQuery("p_field", 1), false)))
            assertThat(searchResponse.getHits().getHits()[4].getId(), equalTo("c004"));  
            assertThat(searchResponse.getHits().getHits()[2].getId(), equalTo("c002"));
            SearchResponse searchResponse = client().prepareSearch("test")
        assertThat(searchResponse.getHits().getAt(0).getSourceAsString(), containsString("\"p_value1\""));
    // Issue #3203
import org.opensearch.index.query.IdsQueryBuilder;  
        countResponse = client().prepareSearch("test").setSize(0).setQuery(hasParentQuery("parent", termQuery("p_field", "1"), true)).get();
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("p1"));
}  
            )  
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));
    public static Collection<Object[]> parameters() {
        refresh();  
        assertHitCount(searchResponse, 2L);  
        ensureGreen();
import org.opensearch.action.search.SearchType;
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(1f));
            .addSort(SortBuilders.scoreSort())
        assertAcked(prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "foo", "test")));
    }
        createIndexRequest("test", "foo", "1", null, "foo", 1).get();
        createIndexRequest("test", "child", "c4", "p2", "c_field", "red").get();
        assertThat(response.getHits().getHits()[2].getScore(), equalTo(1f));
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(2f));  
        refresh();
        } catch (SearchPhaseExecutionException e) {
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(3f));  
            .execute()
    }
        // Parent 2 and its children
    }
                    .startObject("join_field")  
        assertThat(response.getHits().getHits()[2].getId(), equalTo("2"));
        indexBuilders.add(createIndexRequest("test", "child", "6", "1", "c_field1", 2, "c_field2", 0));  
        assertHitCount(response, 1L);
                    .filter(boolQuery().mustNot(termQuery("p_field", "3")))
                constantScoreQuery(QueryBuilders.termQuery("foo", "two")),
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
                .setQuery(hasChildQuery("child", prefixQuery("c_field", "c"), ScoreMode.Max))  
        assertAcked(admin().indices().prepareAliases().addAlias("my-index", "filter2", hasParentQuery("parent", matchAllQuery(), false)));
        assertHitCount(searchResponse, 1L);
            .setSize(0)  
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("p1"));  
        searchResponse = client().prepareSearch("test")
            } while (scrollResponse.getHits().getHits().length > 0);
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
            .get();  
        assertAcked(prepareCreate("test").setSettings(Settings.builder().put(indexSettings()).put("index.refresh_interval", -1)));
        assertThat(response.getHits().getHits()[0].getId(), equalTo("4"));
 * under the License.  
        assertThat(response.getHits().getHits()[0].getId(), equalTo("4"));
                .addSort("p_field", SortOrder.ASC)
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(1f));  
        assertThat(response.getHits().getHits()[2].getScore(), equalTo(1f));
        assertNoFailures(searchResponse);
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("gc1"));
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));  
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("p2"));
                hasChildQuery(
 * this file be licensed under the Apache-2.0 license or a
        client().admin().indices().prepareForceMerge("test").setMaxNumSegments(1).setFlush(true).get();
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
            assertThat(e.status(), equalTo(RestStatus.BAD_REQUEST));  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
            client().prepareSearch("test").setPostFilter(hasParentQuery("parent", termQuery("p_field", "1"), false)).get();
            .get();
        }  
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("c4"));  
        // index simple data
                .endObject()
        searchResponse = client().prepareSearch("test")
                hasChildQuery("child", matchQuery("c_field", "foo"), ScoreMode.None).innerHit(  
        ScoreMode scoreMode = randomFrom(ScoreMode.values());  
        assertNoFailures(searchResponse);  
                previousParentId = "p" + i;
        );
        assertAcked(
        response = minMaxQuery(ScoreMode.Avg, 2, null);  
        createIndexRequest("test", "child", "c3", "p2", "c_field", "blue").get();
        assertThat(response.getHits().getHits()[2].getId(), equalTo("2"));  
            .get();
        createIndexRequest("test", "grandchild", "gc1", "c1", "gc_field", "gc_value1").setRouting("p1").get();  
    public void testMinMaxChildren() throws Exception {
        for (Map.Entry<String, Set<String>> parentToChildrenEntry : parentToChildren.entrySet()) {
        for (String highlightType : highlightTypes) {
        refresh();  
        parentToChildren.put("p0", new HashSet<>());
            .get();
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("gc1"));
                .setQuery(  
                    buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child"),
            }  
        searchResponse = client().prepareSearch("test")
        assertThat(response.getHits().getHits()[2].getScore(), equalTo(1f));  
                        new HighlightBuilder().field(new Field("c_field").highlightQuery(QueryBuilders.matchQuery("c_field", "bar")))
        searchResponse = client().prepareSearch("test")
            if (randomBoolean()) {
            hasChildQuery("child", matchAllQuery(), ScoreMode.None),
        SearchResponse response = client().prepareSearch("test")
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(1f));
            .get();  
                scrollResponse = client().prepareSearchScroll(scrollResponse.getScrollId()).setScroll(TimeValue.timeValueSeconds(30)).get();  
        assertThat(response.getHits().getHits()[0].getId(), equalTo("4"));
        assertNoFailures(searchResponse);
        // index simple data  
        ensureGreen();  
        refresh();
    public void testHasChildQueryOnlyReturnsSingleChildType() throws Exception {
        );  
        searchResponse = client().prepareSearch("test").setQuery(idsQuery().addIds("c1")).get();
        } else {
                    .filter(boolQuery().mustNot(termQuery("p_field", "3")))
        assertThat(searchResponse.getHits().getAt(0).getMatchedQueries()[0], equalTo("test"));
                    .endObject()
        assertThat(searchResponse.getHits().getAt(1).getId(), anyOf(equalTo("p2"), equalTo("p1")));  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));  
        assertThat(response.getHits().getTotalHits().value(), equalTo(7L));
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));
        }  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        assertThat(searchResponse.getHits().getAt(0).getId(), anyOf(equalTo("p2"), equalTo("p1")));
        searchResponse = client().prepareSearch("test")  
        response = minMaxQuery(ScoreMode.None, 2, null);  
    }
                    "c_field",  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
                )
            fail();
        createIndexRequest("test", "child", "c1", "p1", "c_field", "red").get();
        assertHitCount(searchResponse, 1L);
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(6f));
 * specific language governing permissions and limitations
        createIndexRequest("test", "child", "c2", "p2").get();  
        createIndexRequest("test", "child", "c1", "p1", "c_field", "blue").get();
        );
                .endObject()
        assertThat(response.getHits().getHits()[2].getId(), equalTo("4"));
        createIndexRequest("test", "parent", "p1", null, "p_field", "p_value1").get();
    public void testHasChildQueryWithNestedInnerObjects() throws Exception {
            .setQuery(constantScoreQuery(hasChildQuery("child", termQuery("c_field", "1"), ScoreMode.None).queryName("test")))
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(1.5f));
        assertNoFailures(searchResponse);
import static org.opensearch.join.query.JoinQueryBuilders.parentId;
                    QueryBuilders.functionScoreQuery(matchQuery("c_field2", 0), fieldValueFactorFunction("c_field1"))
            .setQuery(boolQuery().must(matchAllQuery()).filter(hasChildQuery("child", matchAllQuery(), ScoreMode.None)))
                .setQuery(query)
import static org.hamcrest.Matchers.containsString;
        return client().prepareSearch("test").setQuery(hasChildQuery).addSort("_score", SortOrder.DESC).addSort("id", SortOrder.ASC).get();
        response = minMaxQuery(ScoreMode.Max, 1, null);
                hasChildQuery(
        response = minMaxQuery(ScoreMode.Avg, 1, 3);
import org.opensearch.action.support.WriteRequest.RefreshPolicy;
                buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child", "child", "grandchild")
 * KIND, either express or implied.  See the License for the
            .get();  
            client().prepareSearch("test").setQuery(hasParentQuery("parent", termQuery("p_field", "1"), true)).get();
                return boolQuery().must(matchAllQuery()).filter(hasChildQuery(type, termQuery(field, value), ScoreMode.None));
        assertAcked(prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child")));
        assertThat(searchResponse.getHits().getAt(0).getMatchedQueries().length, equalTo(1));
            )
                builders.add(createIndexRequest("test", "child", j + "-" + i, "0", "c_field", i));  
            .setQuery(constantScoreQuery(hasChildQuery("child", termQuery("c_field", "red"), ScoreMode.None)))
        assertThat(response.getHits().getTotalHits().value(), equalTo(2L));
        searchResponse = client().prepareSearch("test")
        response = client().prepareSearch("test")
        createIndexRequest("test", "parent", "p9", null, "p_field", "p_value9").get();
        searchResponse = client().prepareSearch("test")
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));  
        assertThat(response.getHits().getHits()[0].getId(), equalTo("3"));
        ExplainResponse explainResponse = client().prepareExplain("test", parentId)
    }
            SearchResponse searchResponse = client().prepareSearch("test")
        assertNoFailures(searchResponse);
        List<IndexRequestBuilder> indexBuilders = new ArrayList<>();
        countResponse = client().prepareSearch("test")
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("p1"));  
        createIndexRequest("test", "parent-type", "parent-id", null, "searchText", "quick brown fox").get();  
                jsonBuilder().startObject()
        response = minMaxQuery(ScoreMode.Avg, 1, null);
                    )  
    }
        indexBuilders.add(createIndexRequest("test", "child", "16", "4", "foo", "one"));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
            prepareCreate("test").setSettings(Settings.builder().put("index.refresh_interval", -1))  
        assertNoFailures(searchResponse);
        assertThat(response.getHits().getHits()[4].getId(), equalTo("20"));
import java.util.ArrayList;
            assertThat(searchResponse.getHits().getHits()[3].getId(), equalTo("c003"));
        assertAcked(prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child")));  
import static org.hamcrest.Matchers.anyOf;
        SearchResponse response = client().prepareSearch("test")  
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;  
                .setSize(5)
            .get();  
                .field("i_field", "4")  
                        ),
            .get();
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));  
            createIndexRequest("test", "child", "d" + i, "p1", "c_field", "red").get();
        createIndexRequest("test", "child", "c2", "p2", "c_field", "blue").get();
        // TEST matching on parent  
                    QueryBuilders.functionScoreQuery(matchQuery("c_field2", 0), fieldValueFactorFunction("c_field1"))
        // query filter in case for p/c shouldn't execute per segment, but rather
    public void testSimpleChildQuery() throws Exception {
        } catch (SearchPhaseExecutionException e) {
        response = minMaxQuery(ScoreMode.Total, 1, null);  
        // HAS PARENT
                addFieldMappings(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child"), "objects", "nested")
        assertThat(searchResponse.getHits().getAt(0).getMatchedQueries().length, equalTo(1));  
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
        response = minMaxQuery(ScoreMode.Avg, 1, 2);
            clearScroll(scrollResponse.getScrollId());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
                .startObject()
import static org.opensearch.join.query.JoinQueryBuilders.hasChildQuery;  
                .setSize(numChildDocsPerParent)
        assertAcked(
        assertNoFailures(searchResponse);
        assertThat(explainResponse.isExists(), equalTo(true));
            prepareCreate("my-index").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child"))
        createIndexRequest("test", "parent", "p1", null, "p_field", "p_value1").get();
    // Issue #2536  
        searchResponse = client().prepareSearch("test")  
import org.opensearch.index.query.BoolQueryBuilder;
        client().prepareIndex("test").setId("3").setSource("p_field", 2).get();
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));
        assertNoFailures(searchResponse);
            .get();  
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));  
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(3f));
                    .endObject()
    public void testHasChildInnerHitsHighlighting() throws Exception {
            .setQuery(constantScoreQuery(hasChildQuery("child", termQuery("c_field", "1"), ScoreMode.None)))
import org.opensearch.search.sort.SortBuilders;  
        SearchResponse searchResponse = client().prepareSearch("test")
            } else {
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;  
            prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent-type", "child-type"))
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(1f));  
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("c3"));
            .setQuery(boolQuery().must(matchAllQuery()).filter(boolQuery().must(hasParentQuery("parent", matchQuery("p_field", 1), false))))
                .execute()  
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(3f));
                        ),
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));
        assertNoFailures(searchResponse);
        }
        indexBuilders.add(createIndexRequest("test", "child", "5", "1", "c_field1", 1, "c_field2", 0));
        createIndexRequest("grandissue", "child_type_two", "4", "2", "name", "Kate").setRouting("1").get();  
        searchResponse = client().prepareSearch("test")
        ensureGreen();  
        response = client().prepareSearch("test")
            .setQuery(
        List<IndexRequestBuilder> indexBuilders = new ArrayList<>();
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("p1"));  
        assertThat(response.getHits().getTotalHits().value(), equalTo(0L));
        indexBuilders.add(createIndexRequest("test", "child", "20", "3", "c_field1", 1, "c_field2", 2, "c_field3", 4));
            assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("p000"));  
        assertThat(extractValue("join_field.parent", searchResponse.getHits().getAt(0).getSourceAsMap()), equalTo("p1"));
                hasChildQuery(
        createIndexRequest("test", "parent", "p2", null, "p_field", "p_value2").get();  
        createIndexRequest("test", "child", "c1", "p1", "c_field", "red").get();
        createIndexRequest("test", "child", "c1", "p1", "c_field", "blue").get();
        assertAcked(prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child")));  
        searchResponse = client().prepareSearch("test")
        indexBuilders.add(createIndexRequest("test", "parent", "3", null, "p_field1", "p_value3", "p_field2", 5));  
        assertThat(response.getHits().getHits()[0].getId(), equalTo("4"));
        SearchResponse searchResponse = client().prepareSearch("test")
    public void testScoreForParentChildQueriesWithFunctionScore() throws Exception {  
        createIndexRequest("test", "parent", "p3", null, "p_field", "p_value3").get();
        assertThat(response.getHits().getTotalHits().value(), equalTo(0L));
        assertThat(response.getHits().getHits()[2].getScore(), equalTo(2f));  
        assertThat(termsFacet.getBuckets().get(1).getKeyAsString(), equalTo("yellow"));
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));
            .get();
        for (int i = 1; i <= numChildDocs; i++) {
                    .endObject()  
        indexBuilders.add(createIndexRequest("test", "child", "19", "4", "foo", "one two three four"));
            }
        searchResponse = client().prepareSearch("test").setQuery(randomHasChild("child", "c_field", "red")).get();
        assertAcked(prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child")));
        assertAcked(prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child")));  
        assertThat(response.getHits().getTotalHits().value(), equalTo(1L));
        assertHitCount(searchResponse, 1L);  
            .setQuery(boolQuery().must(matchAllQuery()).filter(hasChildQuery("child", termQuery("c_field", 1), ScoreMode.None)))  
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(1f));
            for (; j < childId + 50; j++) {  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHit;
            createIndexRequest("test", "parent", "p1", null, "p_field", "p_value1").get();
            ).boostMode(CombineFunction.REPLACE).scoreMode(FunctionScoreQuery.ScoreMode.SUM),
        SearchResponse response = client().prepareSearch("test").setQuery(parentId("child", "p1")).get();
        refresh();
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
            builders.add(createIndexRequest("test", "parent", Integer.toString(i), null, "p_field", i));  
        SearchResponse searchResponse = client().prepareSearch("test")
    public void testHasParentInnerQueryType() {
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));  
        response = minMaxQuery(ScoreMode.Max, 1, 2);
            .setQuery(boolQuery().must(matchAllQuery()).filter(hasParentQuery("parent", matchAllQuery(), false)))
            .setQuery(hasParentQuery("parent", termQuery("p_field", "p_value1"), false))
            prepareCreate("test").setMapping(
                    .startObject("properties")
        createIndexRequest("test", "child-type", "child-id", "parent-id").get();  
        response = minMaxQuery(ScoreMode.Total, 1, 2);  
        response = minMaxQuery(ScoreMode.None, 1, null);
        assertHitCount(searchResponse, 1L);
                    new FunctionScoreQueryBuilder.FilterFunctionBuilder(weightFactorFunction(1)),
                    QueryBuilders.functionScoreQuery(matchQuery("p_field1", "p_value3"), fieldValueFactorFunction("p_field2"))
        indexRandom(true, builders);
    public ChildQuerySearchIT(Settings settings) {
            .setExplain(true)
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        response = minMaxQuery(ScoreMode.Max, 2, null);
                )  
        }  
        // Score mode = NONE  
            .get();
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(2f));  
        assertThat(response.getHits().getHits()[0].getId(), equalTo("4"));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        assertThat(response.getHits().getHits()[2].getId(), equalTo("18"));  
                    new FunctionScoreQueryBuilder.FilterFunctionBuilder(QueryBuilders.termQuery("foo", "four"), weightFactorFunction(1)) }  
        }
    }  
        createIndexRequest("test", "parent", "p1", null, "p_field", "p_value1").get();
                boolQuery().must(hasChildQuery("child", termQuery("c_field", "blue"), scoreMode))  
        }
        ensureGreen();
        searchResponse = client().prepareSearch("test")
            .setQuery(constantScoreQuery(hasChildQuery("child", termQuery("c_field", "blue"), ScoreMode.None)))  
        SearchResponse searchResponse = client().prepareSearch("grandissue")  
        response = minMaxQuery(ScoreMode.Max, 1, null);  
import org.hamcrest.Matchers;
        assertSearchHits(searchResponse, "child-id");
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("1"));  
        assertAcked(
            .setQuery(hasChildQuery("child", termQuery("c_field", "blue"), ScoreMode.None))  
        ensureGreen();
            assertThat(searchResponse.getHits().getHits()[2].getId(), equalTo("p002"));
                jsonBuilder().startObject()  
            .get();  
                addFieldMappings(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child"), "c_field", "keyword")  
        SearchResponse countResponse = client().prepareSearch("test")
            assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("p001"));
        client().admin().indices().prepareFlush().get();  
                .field("p_field", "2")
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));  
        ensureGreen();
        assertNoFailures(searchResponse);  
        response = minMaxQuery(ScoreMode.Avg, 1, 4);  
        response = client().prepareSearch("test").setQuery(hasChildQuery("child", matchQuery("text", "value"), ScoreMode.Max)).get();
        // update p1 and see what that we get updated values...  
        assertThat(response.getHits().getTotalHits().value(), equalTo(1L));
                            boolQuery().must(hasChildQuery("child", matchQuery("c_field", "red"), ScoreMode.None)).must(matchAllQuery())  
        response = minMaxQuery(ScoreMode.None, 1, 2);
                        hasChildQuery(
                )
        assertThat(extractValue("join_field.name", searchResponse.getHits().getAt(0).getSourceAsMap()), equalTo("child"));  
                .startObject()
            .execute()  
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(4f));  
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));
import org.apache.lucene.search.join.ScoreMode;
        indexBuilders.add(createIndexRequest("test", "child", "21", "3", "c_field1", 1, "c_field2", 2, "c_field3", 5));  
            assertHitCount(searchResponse, 1);
        assertThat(termsFacet.getBuckets().get(0).getDocCount(), equalTo(2L));
        Terms termsFacet = filter.getAggregations().get("facet1");
                .setQuery(
        return indexBuilders;
        assertThat(response.getHits().getHits()[0].getId(), equalTo("4"));  
                .get();  
                String childUid = String.format(Locale.ROOT, "c%03d", j);
        assertHitCount(searchResponse, 2L);  
                    "keyword",
            .setQuery(hasChildQuery("child", matchQuery("text", "value"), ScoreMode.None))  
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("p1"));  
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(6f));  
                        AggregationBuilders.filter(
                .field("i_field", "1")  
    public void testSimpleChildQueryWithFlush() throws Exception {
import java.io.IOException;
        ensureGreen();
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));
            .setQuery(hasParentQuery("parent", termQuery("p_field", "1"), true).queryName("test"))
            )
        }  
        createIndexRequest("test", "child", "c4", "p2", "c_field", "red").get();  
            .setMinScore(3) // Score needs to be 3 or above!
        assertAcked(
            .setQuery(
            assertThat(highlightField.getFragments()[0].string(), equalTo("quick brown <em>fox</em>"));
        assertThat(response.getHits().getHits()[5].getId(), equalTo("21"));  
    }
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("c1"));  
        // Score mode = SUM
            .setQuery(constantScoreQuery(hasChildQuery("child", termQuery("c_field", "yellow"), ScoreMode.None)))
 *
            fail();  
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(1f));
        indexBuilders.add(createIndexRequest("test", "child", "12", "2", "foo", "one two"));
        // index simple data
                .setQuery(constantScoreQuery(hasChildQuery("child", matchAllQuery(), ScoreMode.Max)))  
                    .endObject()
            "parent",
            Set<String> childIds = parentToChildrenEntry.getValue();  
        ensureGreen();
        SearchResponse searchResponse = client().prepareSearch("test")
        assertNoFailures(searchResponse);
                    )  
        try {  
            client().prepareSearch("test").setQuery(hasChildQuery("child", termQuery("c_field", "1"), ScoreMode.None)).get();
        ensureGreen();
    // Issue #3144
        assertThat(response.getHits().getTotalHits().value(), equalTo(1L));
        assertThat(response.getHits().getTotalHits().value(), equalTo(2L));  
                )  
        assertThat(response.getHits().getHits()[0].getId(), equalTo("4"));  
            assertNoFailures(scrollResponse);  
        createIndexRequest("test", "parent-type", "parent-id", null).get();
import org.opensearch.index.query.QueryBuilders;
                    .endObject()
                builders.add(createIndexRequest("test", "parent", previousParentId, null, "p_field", previousParentId));
        assertNoFailures(searchResponse);  
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(6f));
        assertThat(response.getHits().getTotalHits().value(), equalTo(1L));  
            .setQuery(boolQuery().mustNot(hasParentQuery("parent", boolQuery().should(queryStringQuery("p_field:*")), false)))  
            .get();
                    .startObject("properties")
            )
                .startObject()
            assertNoFailures(searchResponse);  
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(5f));
        createIndexRequest("test", "parent", "p1", null, "p_field", "p_value1_updated").get();
        createIndexRequest("test", "parent", "p1", null, "p_field", "p_value1").get();
        createIndexRequest("test", "parent", "p2", null, "p_field", "p_value2").get();
        refresh();
                boolQuery().must(
                .highlighter(new HighlightBuilder().field(new HighlightBuilder.Field("searchText").highlighterType(highlightType)))  
            )
        assertNoFailures(searchResponse);
    public void testHasParentFilter() throws Exception {
                .startArray("objects")
        createIndexRequest("test", "parent", "1", null, "p_field", 1).get();
        indexBuilders.add(createIndexRequest("test", "child", "16", "3", "c_field1", 4, "c_field2", 0, "c_field3", 0));
        assertThat(response.getHits().getHits()[0].getId(), equalTo("3"));  
        // index simple data
            highlightField = searchResponse.getHits().getAt(0).getHighlightFields().get("searchText");
        assertHitCount(searchResponse, 1L);
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(1f));
            fail();
        assertThat(response.getHits().getHits()[0].getId(), equalTo("2"));  
        assertThat(extractValue("join_field.name", searchResponse.getHits().getAt(0).getSourceAsMap()), equalTo("child"));
                        .boostMode(CombineFunction.REPLACE),
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(3f));
            if (randomBoolean()) {  
                        "parent",
        refresh();  
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(2f));
            )
            "p2",
            .get();
            .get();
            .setQuery(hasChildQuery("child-type", new IdsQueryBuilder().addIds("child-id"), ScoreMode.None))  
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));  
import org.opensearch.index.query.QueryBuilder;
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        refresh();  
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(2f));
        createIndexRequest("test", "parent", "p4", null, "p_field", "p_value4").get();  
                .endObject()
        client().admin().indices().prepareRefresh("test").get();
                    .startObject("searchText")  
        }  
    }
        assertThat(response.getHits().getHits()[2].getScore(), equalTo(5f));
            )
    }
        assertNoFailures(response);
            prepareCreate("test").setMapping(
        createIndexRequest("test", "child", "c2", "p1", "c_field", "yellow").get();  
        SearchResponse searchResponse = client().prepareSearch("test")  
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(6f));
            .get();
        assertThat(response.getHits().getHits()[2].getScore(), equalTo(1f));
import org.opensearch.index.query.MatchAllQueryBuilder;
        assertAcked(prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child")));
                    "child",  
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(1.5f));
        ensureGreen();
        String parentId = "p1";  
        createIndexRequest("test", "parent", "p2", null, "p_field", "p_value2").get();
        createIndexRequest("test", "child", "c2", "p1", "c_field", "red").get();
        for (int i = 1; i <= 10; i++) {  
        assertThat(response.getHits().getHits()[0].getId(), equalTo("3"));
        }
        ).get();  
        assertThat(response.getHits().getHits()[1].getId(), equalTo("2"));
            .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
            "parent",
        createIndexRequest("test", "child", "c2", "p2").get();
import org.opensearch.action.explain.ExplainResponse;  
        createIndexRequest("test", "child", "c1", "p1").get();
        createIndexRequest("test", "parent", "1", null, "p_field", 1).get();
                .highlighter(new HighlightBuilder().field(new HighlightBuilder.Field("searchText").highlighterType(highlightType)))  
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(1.5f));
        createIndexRequest("test", "child-type", "child-id", "parent-id", "searchText", "quick brown fox").get();
        int numChildDocs = 32;
                    .field("type", "text")
        } catch (SearchPhaseExecutionException e) {  
            .setQuery(hasChildQuery("child", termQuery("c_field", "1"), ScoreMode.Max))
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));
            )  
        response = minMaxQuery(ScoreMode.Max, 1, 4);
            )
        indexBuilders.add(createIndexRequest("test", "child", "19", "3", "c_field1", 1, "c_field2", 2, "c_field3", 3));
        assertThat(response.getHits().getHits()[6].getId(), equalTo("22"));
        createIndexRequest("test", "parent", parentId, null, "p_field", "1").get();
            .setQuery(boolQuery().mustNot(hasChildQuery("child", boolQuery().should(queryStringQuery("c_field:*")), ScoreMode.None)))  
            SearchResponse searchResponse = client().prepareSearch("test")  
        // Parent 1 and its children  
import org.opensearch.search.aggregations.bucket.terms.Terms;
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(3f));
        assertHitCount(searchResponse, 0L);
        SearchResponse searchResponse = client().prepareSearch("test")
            .setQuery(boolQuery().should(parentId("child", "p1")).should(parentId("child", "p2")))
        client().admin().indices().prepareFlush().get();
        assertThat(extractValue("join_field.parent", searchResponse.getHits().getAt(0).getSourceAsMap()), equalTo("p1"));
        searchResponse = client().prepareSearch("test")
import static org.opensearch.common.xcontent.support.XContentMapValues.extractValue;
        assertThat(response.getHits().getHits()[2].getId(), equalTo("2"));  
        refresh();
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(6f));
    public void testHasChildAndHasParentFailWhenSomeSegmentsDontContainAnyParentOrChildDocs() throws Exception {  
        assertThat(response.getHits().getAt(0).getId(), equalTo("2"));  
        assertThat(response.getHits().getHits()[2].getScore(), equalTo(1f));  
        assertAcked(
                            hasChildQuery("child_type_two", boolQuery().must(queryStringQuery("name:William*")), ScoreMode.None)  
                .setSize(1)  
            .get();  
        response = minMaxQuery(ScoreMode.Total, 3, null);  
        assertThat(parentToChildren.isEmpty(), equalTo(false));
                .endObject()
            }
                boolQuery().must(
        );  
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));
        assertAcked(  
            .actionGet();  
        assertNoFailures(searchResponse);
                            hasChildQuery("child_type_one", boolQuery().must(queryStringQuery("name:William*")), ScoreMode.None)  
                    .field("parent", new String[] { "child", "child1" })
        createIndexRequest("test", "parent", parentId, null, "p_field", "1").get();
        assertThat(response.getHits().getHits()[2].getScore(), equalTo(1f));
        assertThat(response.getHits().getHits()[1].getId(), equalTo("17"));
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(1f));
            .get();
        createIndexRequest("test", "child", "c3", "p2", "c_field", "x").get();
        assertNoFailures(searchResponse);  
        SearchResponse searchResponse;
        assertAcked(prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child")));  
            .get();
        assertAcked(prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child")));  
        SearchResponse searchResponse = client().prepareSearch("test")
                    QueryBuilders.functionScoreQuery(matchQuery("c_field2", 0), fieldValueFactorFunction("c_field1"))  
        assertNoFailures(searchResponse);
            "p1",  
        assertThat(searchResponse.getHits().getAt(0).getSourceAsString(), containsString("\"p_value1\""));
            boolQuery().must(matchAllQuery()).filter(hasParentQuery("parent", matchAllQuery(), false)) };
    }
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));
                    )  
        indexRandom(true, createMinMaxDocBuilders().toArray(new IndexRequestBuilder[0]));  
            .setQuery(
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("p2"));  
    }
                .field("i_field", "5")  
            .actionGet();
        indexRandom(randomBoolean(), builders);
                .startObject()
        createIndexRequest("test", "parent", "p1", null, "p_field", "p_value1").get();  
                )
            .get();  
                    .startObject("relations")
            createIndexRequest("test", "child", "c3", "p2", "c_field", "x").get();
        assertNoFailures(response);
        response = client().prepareSearch("test").setQuery(hasChildQuery("child", matchQuery("text", "value"), ScoreMode.None)).get();
        assertThat(response.getHits().getHits()[2].getId(), equalTo("4"));
        indexBuilders.add(createIndexRequest("test", "parent", "3", null, "id", 3));
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(2f));  
import static org.opensearch.index.query.QueryBuilders.constantScoreQuery;  
        assertThat(e.getMessage(), equalTo("[has_child] 'max_children' is less than 'min_children'"));
        assertThat(response.getHits().getTotalHits().value(), equalTo(0L));
            createIndexRequest("test", "parent", parentId, null, "p_field", parentId).get();
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        createIndexRequest("test", "parent", "p1", null, "p_field", "p_value1").get();  
        createIndexRequest("test", "child", "c3", "p2", "c_field", "blue").get();
            if (previousParentId == null || i % numChildDocsPerParent == 0) {  
    public void test2744() throws IOException {  
            createIndexRequest("test", "parent", "p2", null, "p_field", "p_value2").get();  
            .get();
                .endObject()  
        assertThat(e.getMessage(), equalTo("[has_child] 'max_children' is less than 'min_children'"));
        // index simple data  
        createIndexRequest("test", "child", "c4", "p3", "c_field", "green").get();
import org.opensearch.common.settings.Settings;
        assertThat(response.getHits().getTotalHits().value(), equalTo(0L));  
import java.util.Collection;
        assertThat(searchHits.length, equalTo(1));
                        "parent",
        assertHitCount(response, 1);
            .setQuery(constantScoreQuery(hasChildQuery("child", termQuery("c_field", "yellow"), ScoreMode.None)))
            fail();
                assertThat(scrollResponse.getHits().getTotalHits().value(), equalTo(10L));
        }
        createIndexRequest("grandissue", "child_type_one", "3", "2", "name", "William").setRouting("1").get();
                boolQuery().should(boolQuery().filter(termQuery("join_field#parent", "p1")).filter(termQuery("join_field", "child")))
    private SearchResponse minMaxQuery(ScoreMode scoreMode, int minChildren, Integer maxChildren) throws SearchPhaseExecutionException {
                .field("p_field", "1")  
            .get();  
        assertThat(response.getHits().getTotalHits().value(), equalTo(0L));  
        createIndexRequest("test", "child", "c1", "p1").get();
 * The OpenSearch Contributors require contributions made to  
    public void testDfsSearchType() throws Exception {
 *  
        indexBuilders.add(createIndexRequest("test", "child", "7", "1", "c_field1", 2, "c_field2", 0));
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> minMaxQuery(ScoreMode.None, 3, 2));
            .get();
                .startObject()
        createIndexRequest("test", "child", "c2", "p1", "c_field", "yellow").get();
        assertThat(searchResponse.getHits().getAt(0).getId(), anyOf(equalTo("p2"), equalTo("p1")));
    }
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(1f));
        assertThat(response.getHits().getHits()[3].getScore(), equalTo(5f));  
        assertNoFailures(searchResponse);
        assertThat(response.getHits().getHits()[2].getId(), equalTo("2"));
                .field("i_field", "6")  
            .get();
        SearchResponse searchResponse = client().prepareSearch()
        response = client().prepareSearch("test")  
        createIndexRequest("test", "child", "c2", "p1", "c_field", "yellow").get();
            jsonBuilder().startObject()
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));  
        assertThat(response.getHits().getTotalHits().value(), equalTo(1L));  
    }  
 */  
                numChildDocsPerParent++;  
        assertAcked(prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child")));  
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(2f));  
                .field("i_field", "1")
        } catch (SearchPhaseExecutionException e) {
        assertThat(searchResponse.getHits().getAt(0).getId(), anyOf(equalTo("p2"), equalTo("p1")));
                .setScroll(TimeValue.timeValueSeconds(30))
                    new BoolQueryBuilder().must(new MatchQueryBuilder("searchText", "fox"))  
                .get();
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
import static org.opensearch.index.query.QueryBuilders.matchQuery;  
