        assertThat(response.getHits().getHits()[0].getScore(), equalTo(1f));
            )
                    .field("type", "join")
        assertThat(response.getHits().getHits()[5].getScore(), equalTo(5f));
        assertThat(response.getHits().getHits()[2].getScore(), equalTo(1f));
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(1f));
import java.util.HashMap;
            .get();
        ensureGreen();
        );
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(1.5f));
                    .endObject()
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));
            SearchResponse searchResponse = client().prepareSearch("test")
        response = minMaxQuery(ScoreMode.Avg, 1, 2);
            prepareCreate("test").setSettings(Settings.builder().put("index.refresh_interval", -1))
        assertAcked(prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child")));
 * this work for additional information regarding copyright
import org.apache.lucene.search.join.ScoreMode;
        assertThat(extractValue("join_field.parent", searchResponse.getHits().getAt(0).getSourceAsMap()), equalTo("p1"));
            .setQuery(boolQuery().filter(termQuery("join_field#parent", "p1")).filter(termQuery("join_field", "child")))
        response = minMaxQuery(ScoreMode.Max, 2, 2);
        indexBuilders.add(createIndexRequest("test", "child", "17", "4", "foo", "one two"));
        client().admin().indices().prepareRefresh("test").get();
    }
        client().admin().indices().prepareFlush("test").get();
        createIndexRequest("test", "parent", "p1", null, "p_field", "p_value1").get();
        assertNoFailures(searchResponse);
        assertThat(searchResponse.getHits().getAt(0).getId(), anyOf(equalTo("p2"), equalTo("p1")));
            )
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("c1"));
            null,
            .setQuery(
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
        assertThat(extractValue("join_field.name", searchResponse.getHits().getAt(0).getSourceAsMap()), equalTo("child"));
            SearchResponse searchResponse = client().prepareSearch("test")
        try {
import static org.opensearch.join.query.JoinQueryBuilders.hasParentQuery;
        assertThat(searchResponse.getHits().getAt(1).getId(), anyOf(equalTo("p2"), equalTo("p1")));
        searchResponse = client().prepareSearch("test").setQuery(randomHasChild("child", "c_field", "blue")).execute().actionGet();
                .field("i_field", "1")
        assertAcked(prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child")));
        // index simple data
    }
        createIndexRequest("test", "child", "c1", "p1", "c_field", "x").get();
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(1f));
            .addSort(SortBuilders.scoreSort())
        refresh();
            .get();
            client().prepareSearch("test").setQuery(hasChildQuery("child", termQuery("c_field", "1"), ScoreMode.Max)).get();
                )
        assertAcked(prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child")));
        indexBuilders.add(createIndexRequest("test", "child", "15", "3", "foo", "one two three"));
import static org.hamcrest.Matchers.equalTo;
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));
        createIndexRequest("test", "parent", "p8", null, "p_field", "p_value8").get();
    public void testHasChildAndHasParentWrappedInAQueryFilter() throws Exception {
            logger.info("Testing with highlight type [{}]", highlightType);
        assertThat(response.getHits().getHits()[6].getScore(), equalTo(5f));
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(2f));
    }
                    QueryBuilders.functionScoreQuery(matchQuery("p_field1", "p_value3"), fieldValueFactorFunction("p_field2"))
        indexBuilders.add(createIndexRequest("test", "parent", "1", null, "p_field", "p_value1"));
                    .endObject()
        SearchHit[] searchHits = searchResponse.getHits().getHits()[0].getInnerHits().get("child").getHits();
    // Issue #3144
        assertThat(response.getHits().getHits()[0].getId(), equalTo("4"));
        assertHitCount(response, 1L);
        createIndexRequest("test", "child", "c3", "p2", "c_field", "red").get();
            .setSource(jsonBuilder().startObject().field("text", "value").endObject())
        );
        } else {
            .setQuery(boolQuery().must(matchAllQuery()).filter(boolQuery().must(hasParentQuery("parent", matchQuery("p_field", 1), false))))
        assertThat(response.getHits().getHits()[0].getId(), equalTo("4"));
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo((long) childIds.size()));
        assertNoFailures(searchResponse);
    }
                return boolQuery().must(matchAllQuery()).filter(hasChildQuery(type, termQuery(field, value), ScoreMode.None));
        for (SearchType searchType : searchTypes) {
                            ScoreMode.None
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("c3"));
            SearchResponse scrollResponse = client().prepareSearch("test")
        assertHitCount(searchResponse, 1L);
        for (Map.Entry<String, Set<String>> parentToChildrenEntry : parentToChildren.entrySet()) {
        createIndexRequest("test", "grandchild", "gc1", "c1", "gc_field", "gc_value1").setRouting("p1").get();
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("c1"));
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(1f));
        createIndexRequest(
        assertThat(searchResponse.getHits().getAt(0).getSourceAsString(), containsString("\"p_value1_updated\""));
            .setQuery(hasChildQuery("child", termQuery("c_field", "blue"), ScoreMode.None))
        assertThat(response.getHits().getHits()[0].getId(), equalTo("4"));
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(3f));
        response = minMaxQuery(ScoreMode.None, 1, 2);
            )
        String previousParentId = null;
        assertHitCount(searchResponse, 1L);
                    .startObject("relations")
                    .endObject()
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(3f));
import static org.opensearch.common.xcontent.support.XContentMapValues.extractValue;
        response = minMaxQuery(ScoreMode.Total, 1, null);
            .setExplain(true)
import org.opensearch.action.explain.ExplainResponse;
        assertThat(response.getHits().getTotalHits().value(), equalTo(0L));
        createIndexRequest("test", "child", "c2", "p2").get();
            .setQuery(hasChildQuery("child", matchAllQuery(), ScoreMode.Total))
        assertNoFailures(searchResponse);
import org.opensearch.action.search.SearchType;
                .execute()
        assertThat(response.getHits().getHits()[2].getScore(), equalTo(5f));
        assertThat(searchResponse.getHits().getAt(0).getMatchedQueries()[0], equalTo("test"));
        assertThat(response.getHits().getHits()[2].getScore(), equalTo(1f));
            SearchResponse searchResponse = client().prepareSearch("test")
        refresh();
            createIndexRequest("test", "parent", "p2", null, "p_field", "p_value2").get();
        createIndexRequest("test", "parent", parentId, null, "p_field", "1").get();
            "p2",
                    .field("parent", new String[] { "child", "child1" })
                        .boostMode(CombineFunction.REPLACE),
        refresh();
            )
            .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
        );
        assertThat(response.getHits().getTotalHits().value(), equalTo(0L));
        assertThat(response.getHits().getHits()[2].getScore(), equalTo(1f));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHits;
                boolQuery().must(
            )
                    buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child"),
        refresh();
}
        // Childless parent
    // see #2744
        assertThat(response.getHits().getTotalHits().value(), equalTo(0L));
import org.hamcrest.Matchers;
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        searchResponse = client().prepareSearch("test").setQuery(randomHasParent("parent", "p_field", "p_value2")).get();
        String parentId = "p1";
        assertAcked(
import java.util.Set;
        searchResponse = client().prepareSearch("test")
        searchResponse = client().prepareSearch("test")
            .setQuery(boolQuery().should(parentId("child", "p1")).should(parentId("child", "p2")))
        ensureGreen();
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));
                    hasChildQuery(
            prepareCreate("test").setMapping(
        indexBuilders.add(createIndexRequest("test", "child", "8", "1", "c_field1", 1, "c_field2", 1));
        assertThat(searchResponse.getHits().getAt(0).getId(), anyOf(equalTo("c1"), equalTo("c2")));
        // HAS CHILD
        // update p1 and see what that we get updated values...
        searchResponse = client().prepareSearch("test")
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));
        createIndexRequest("test", "child", "c1", "p1", "c_field", "red").get();
    }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> minMaxQuery(ScoreMode.None, 3, 2));
        createIndexRequest("test", "child", "2", "1", "c_field", "foo bar").get();
        searchResponse = client().prepareSearch("test")
        createIndexRequest("test", "child", "c1", parentId, "c_field", "1").get();
        }
        assertAcked(prepareCreate("test").setSettings(Settings.builder().put(indexSettings()).put("index.refresh_interval", -1)));
                    .startObject("join_field")
        for (int i = 0; i < 10; i++) {
    }
        try {
        assertThat(response.getHits().getHits()[0].getId(), equalTo("3"));
            .get();
                    .filter(boolQuery().mustNot(termQuery("p_field", "3")))
            .setQuery(constantScoreQuery(hasChildQuery("child", termQuery("c_field", "blue"), ScoreMode.None)))
        createIndexRequest("test", "child", "c3", "p2", "c_field", "blue").get();
        if (randomBoolean()) {
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(2f));
            .actionGet();
    @ParametersFactory
    public void testParentFieldQuery() throws Exception {
                    .startObject("searchText")
                    .endObject()
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("c4"));
            childId = j;
        // re-index
        assertThat(response.getHits().getHits()[0].getId(), equalTo("3"));
        response = minMaxQuery(ScoreMode.Max, 4, null);
            .get();
        ensureGreen();
        assertAcked(
    public void testHasChildQueryWithMinimumScore() throws Exception {
            assertThat(scrollResponse.getHits().getTotalHits().value(), equalTo(10L));
        createIndexRequest("test", "child", "c2", "p1", "c_field", "yellow").get();
        }
            .get();
            .get();
        response = minMaxQuery(ScoreMode.Avg, 1, null);
                .endArray()
        ensureGreen();
                    .field("grandparent", "parent")
/*
        createIndexRequest("test", "child", "c1", "p1").get();
        assertHitCount(searchResponse, 2L);
        assertThat(response.getHits().getHits()[2].getScore(), equalTo(1f));
        ensureGreen();
        createIndexRequest("test", "parent", "p2", null, "p_field", "p_value2").get();
        assertThat(response.getHits().getTotalHits().value(), equalTo(0L));
            .setQuery(hasChildQuery("child", termQuery("c_field", "1"), ScoreMode.Max).queryName("test"))
    public void testHasChildNotBeingCached() throws IOException {
        SearchResponse response = client().prepareSearch("test")
            for (int i = 0; i < searchResponse.getHits().getTotalHits().value(); i++) {
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));
        client().prepareIndex("test").setId("3").setSource("p_field", 1).get();
        SearchResponse searchResponse = client().prepareSearch("test")
            } else {
                return boolQuery().must(matchAllQuery()).filter(hasParentQuery(type, termQuery(field, value), false));
        indexBuilders.add(createIndexRequest("test", "child", "21", "3", "c_field1", 1, "c_field2", 2, "c_field3", 5));
        ensureGreen();
    public void testHasChildQueryWithNestedInnerObjects() throws Exception {
                boolQuery().must(matchAllQuery())
        assertThat(response.getHits().getHits()[3].getScore(), equalTo(5f));
            assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("c000"));
        ensureGreen();
        assertHitCount(response, 1L);
        );
 * Licensed to Elasticsearch under one or more contributor
                String childUid = String.format(Locale.ROOT, "c%03d", j);
 * license agreements. See the NOTICE file distributed with
    // Issue #3203
            admin().indices().prepareAliases().addAlias("my-index", "filter1", hasChildQuery("child", matchAllQuery(), ScoreMode.None))
        ensureGreen();
        client().admin().indices().prepareFlush("test").get();
                .get();
                )
                .endObject()
        int numChildDocsPerParent = 0;
                        .filter(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
                .highlighter(new HighlightBuilder().field(new HighlightBuilder.Field("searchText").highlighterType(highlightType)))
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));
        assertSearchHit(searchResponse, 1, hasId("2"));
        indexBuilders.add(createIndexRequest("test", "child", "15", "2", "c_field1", 1, "c_field2", 2));
        // TEST matching on parent
        createIndexRequest("test", "child", "c1", "p1", "c_field", "blue").get();
            .execute()
import org.opensearch.index.query.IdsQueryBuilder;
            assertNoFailures(scrollResponse);
        assertNoFailures(searchResponse);
                    .startObject("relations")
    // Issue #3818
        indexBuilders.add(createIndexRequest("test", "parent", "4", null, "id", 4));
        assertAcked(
        }
        assertHitCount(searchResponse, 1L);
            assertNoFailures(searchResponse);
            "parent",
        assertThat(response.getHits().getHits()[2].getId(), equalTo("1"));
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(1f));
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(2f));
            .setQuery(constantScoreQuery(hasChildQuery("child", termQuery("c_field", "1"), ScoreMode.None).queryName("test")))
                    )
        assertThat(response.getHits().getTotalHits().value(), equalTo(1L));
        indexBuilders.add(createIndexRequest("test", "child", "11", "2", "c_field1", 1, "c_field2", 1));
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(6f));
                    .endObject()
                    ScoreMode.None
        }
    public void testSimpleQueryRewrite() throws Exception {
                .endObject()
        client().prepareIndex("test")
                        ScoreMode.None
        createIndexRequest("test", "parent", "p1", null, "p_field", "p_value1").get();
import org.opensearch.search.sort.SortOrder;
    public void testSimpleChildQuery() throws Exception {
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        assertAcked(prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child")));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
            createIndexRequest("test", "parent", "p1", null, "p_field", "p_value1").get();
import org.opensearch.index.query.MatchQueryBuilder;
        assertNoFailures(searchResponse);
        assertThat(response.getHits().getHits()[2].getId(), equalTo("4"));
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder.Field;
            )
            .setQuery(boolQuery().filter(termQuery("join_field#parent", "p1")).filter(termQuery("join_field", "child")))
        assertAcked(prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child")));
            .setQuery(boolQuery().filter(termQuery("join_field#parent", "p1")).filter(termQuery("join_field", "child")))
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        // Parent 3 and its children
            client().prepareSearch("test").setPostFilter(hasChildQuery("child", termQuery("c_field", "1"), ScoreMode.None)).get();
import org.opensearch.index.query.QueryBuilders;
        return indexBuilders;
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));
        assertNoFailures(searchResponse);
        try {
import org.opensearch.action.support.WriteRequest.RefreshPolicy;
            .setQuery(
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("1"));
                .startObject()
                    .endObject()
                            hasChildQuery("child_type_two", boolQuery().must(queryStringQuery("name:William*")), ScoreMode.None)
            Set<String> childIds = parentToChildrenEntry.getValue();
                .addSort("p_field", SortOrder.ASC)
        assertThat(response.getHits().getHits()[0].getId(), equalTo("4"));
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));
        refresh();
        refresh();
        assertSearchHit(searchResponse, 1, hasId("2"));
            .execute()
                .field("p_field", "1")
                buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child", "child", "grandchild")
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
            boolQuery().must(matchAllQuery()).filter(hasParentQuery("parent", matchAllQuery(), false)) };
            assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("child-id"));
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(1.5f));
        ensureGreen();
import org.opensearch.search.SearchHit;
        e = expectThrows(IllegalArgumentException.class, () -> minMaxQuery(ScoreMode.Avg, 3, 2));
        assertNoFailures(searchResponse);
    public void test2744() throws IOException {
            if (!parentToChildren.containsKey(previousParentId)) {
import org.opensearch.index.query.MatchAllQueryBuilder;
        refresh();
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(3f));
                addFieldMappings(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child"), "objects", "nested")
            assertNoFailures(searchResponse);
        } catch (SearchPhaseExecutionException e) {
        searchResponse = client().prepareSearch("test")
        assertAcked(prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child")));
        createIndexRequest("test", "parent", "p1", null, "p_field", "p_value1").get();
        assertNoFailures(searchResponse);
        List<IndexRequestBuilder> indexBuilders = new ArrayList<>();
        createIndexRequest("test", "parent", parentId, null, "p_field", "1").get();
    }
        SearchResponse searchResponse = client().prepareSearch("test")
        assertAcked(prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child")));
    public void testHasChildInnerHitsHighlighting() throws Exception {
                .setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child"))
        // TEST FETCHING _parent from child
            if (randomBoolean()) {
            .setQuery(hasChildQuery("child", termQuery("c_field", "yellow"), ScoreMode.Total))
            .get();
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        } catch (SearchPhaseExecutionException e) {
        assertThat(response.getHits().getTotalHits().value(), equalTo(1L));
                .endObject()
        assertHitCount(countResponse, 1L);
        SearchResponse searchResponse = client().prepareSearch("test")
        assertNoFailures(response);
        assertAcked(prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child")));
            assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("c001"));
        assertThat(response.getHits().getHits()[2].getId(), equalTo("2"));
        assertThat(response.getHits().getTotalHits().value(), equalTo(2L));
        client().prepareIndex("test").setId(parentId).setSource("p_field", "1").get();
                .field("i_field", "1")
        SearchResponse searchResponse = client().prepareSearch("test")
        assertThat(response.getHits().getHits()[0].getId(), equalTo("2"));
                        )
        assertThat(response.getHits().getTotalHits().value(), equalTo(2L));
                )
        );
        assertThat(response.getHits().getHits()[2].getScore(), equalTo(1f));
                )
            .setQuery(hasChildQuery("child-type", new IdsQueryBuilder().addIds("child-id"), ScoreMode.None))
        createIndexRequest("test", "parent", "p1", null, "p_field", "p_value1").get();
            .setQuery(constantScoreQuery(hasChildQuery("child", termQuery("c_field", "yellow"), ScoreMode.None)))
            .get();
        // Parent 4 and its children
        assertThat(response.getHits().getHits()[2].getScore(), equalTo(1f));
            .setQuery(constantScoreQuery(hasChildQuery("child", termQuery("c_field", "yellow"), ScoreMode.None)))
        assertThat(response.getHits().getHits()[2].getScore(), equalTo(3f));
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));
    }
                .field("i_field", "4")
            .setQuery(boolQuery().mustNot(hasChildQuery("child", boolQuery().should(queryStringQuery("c_field:*")), ScoreMode.None)))
        assertHitCount(searchResponse, 2L);
    }
        for (int i = 1; i <= numChildDocs; i++) {
        createIndexRequest("test", "child", "c2", "p1", "c_field", "red").get();
        assertThat(response.getHits().getAt(0).getId(), equalTo("2"));
        createIndexRequest("test", "child", "c1", parentId, "c_field", "1").get();
        response = minMaxQuery(ScoreMode.Total, 1, null);
        assertThat(response.getHits().getHits()[4].getId(), equalTo("20"));
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(2f));
                    "parent",
        Map<String, Set<String>> parentToChildren = new HashMap<>();
        response = client().prepareSearch("test").setQuery(hasChildQuery("child", matchQuery("text", "value"), ScoreMode.None)).get();
        response = minMaxQuery(ScoreMode.None, 1, 3);
        indexBuilders.add(createIndexRequest("test", "child", "14", "3", "foo", "one two"));
            .setQuery(boolQuery().must(matchAllQuery()).filter(hasParentQuery("parent", termQuery("p_field", 1), false)))
                hasParentQuery(
    public void testHasParentInnerQueryType() {
                    boolQuery().must(matchAllQuery())
        SearchResponse response = client().prepareSearch("test")
        assertNoFailures(searchResponse);
        client().admin().indices().prepareRefresh().get();
            }
            .setQuery(hasChildQuery("test", matchQuery("foo", 1), ScoreMode.None))
        indexBuilders.add(createIndexRequest("test", "child", "16", "3", "c_field1", 4, "c_field2", 0, "c_field3", 0));
            .setQuery(constantScoreQuery(hasChildQuery("child", termQuery("c_field", "blue"), ScoreMode.None)))
            .get();
                .endObject()
        createIndexRequest("test", "child", "c3", "p2", "c_field", "x").get();
                    .endObject()
        assertThat(response.getHits().getHits()[6].getId(), equalTo("22"));
        refresh();
            .get();
        response = minMaxQuery(ScoreMode.Avg, 2, null);
        assertNoFailures(response);
        createIndexRequest("test", "parent", parentId, null, "p_field", "1").get();
        assertThat(searchResponse.getHits().getAt(1).getId(), Matchers.anyOf(equalTo("c3"), equalTo("c4")));
            .get();
        refresh();
        assertThat(response.getHits().getHits()[0].getId(), equalTo("4"));
                .setScroll(TimeValue.timeValueSeconds(30))
        assertThat(response.getHits().getHits()[4].getScore(), equalTo(5f));
                builders.add(createIndexRequest("test", "child", j + "-" + i, "0", "c_field", i));
            .get();
        assertThat(response.getHits().getHits()[0].getId(), equalTo("4"));
                    .endObject()
        assertNoFailures(searchResponse);
            boolQuery().must(matchAllQuery()).filter(hasChildQuery("child", matchAllQuery(), ScoreMode.None)),
        }
        for (int j = 0; j < 2; j++) {
        createIndexRequest("test", "parent", "1", null, "p_field", 1).get();
                    new InnerHitBuilder().setHighlightBuilder(
        refresh();
            .setQuery(hasParentQuery("parent", termQuery("p_field", "p_value1"), false))
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(10L));
        createIndexRequest("test", "parent-type", "parent-id", null, "searchText", "quick brown fox").get();
                createIndexRequest("test", "child", childUid, parentId, "c_field", childUid).get();
                new FunctionScoreQueryBuilder.FilterFunctionBuilder[] {
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(2f));
            assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("p000"));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
        createIndexRequest("test", "child", "c5", "p2", "c_field", "x").get();
    public void testHasChildQueryOnlyReturnsSingleChildType() throws Exception {
import org.opensearch.common.lucene.search.function.FunctionScoreQuery;
        assertThat(termsFacet.getBuckets().get(0).getDocCount(), equalTo(2L));
        assertHitCount(searchResponse, 0L);
        HasChildQueryBuilder hasChildQuery = hasChildQuery(
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        String[] highlightTypes = new String[] { "plain", "fvh", "unified" };
            )
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
        // make sure that when we explicitly set a type, the inner query is executed in the context of the child type instead
    // Issue #2536
            )
        refresh();
                    .field("term_vector", "with_positions_offsets")
        createIndexRequest("test", "parent", "p0", null, "p_field", "p0").get();
            String parentId = String.format(Locale.ROOT, "p%03d", i);
        createIndexRequest("test", "parent", "p1", null, "p_field", "p_value1").get();
        // Parent 1 and its children
                .startObject()
        String parentId = "p1";
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
                    .field("type", "text")
        }
        indexRandom(true, builders);
        ExplainResponse explainResponse = client().prepareExplain("test", parentId)
        assertNoFailures(searchResponse);
            "p1",
            prepareCreate("grandissue").setMapping(
    public void testParentChildQueriesViaScrollApi() throws Exception {
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));
        createIndexRequest("test", "parent", "1", null, "p_field", 1).get();
import static org.opensearch.index.query.QueryBuilders.matchQuery;
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));
        ensureGreen();
 */
            for (; j < childId + 50; j++) {
            createIndexRequest("test", "child", "c3", "p2", "c_field", "x").get();
        createIndexRequest("test", "parent", "p3", null, "p_field", "p_value3").get();
                jsonBuilder().startObject()
        createIndexRequest("test", "child", "c1", "p1", "c_field", "red").get();
public class ChildQuerySearchIT extends ParentChildTestCase {
        createIndexRequest("test", "parent", "p2", null, "p_field", "p_value2").get();
            assertThat(e.status(), equalTo(RestStatus.BAD_REQUEST));
        assertNoFailures(response);
        assertThat(response.getHits().getHits()[2].getId(), equalTo("2"));
    public void testParentChildQueriesCanHandleNoRelevantTypesInIndex() throws Exception {
    public void testExplainUsage() throws Exception {
        SearchResponse response;
        indexBuilders.add(createIndexRequest("test", "child", "13", "2", "c_field1", 1, "c_field2", 1));
                .addStoredField("_id")
            .get();
        createIndexRequest("test", "child", "c2", "p1", "c_field", "yellow").get();
                )
        response = client().prepareSearch("test")
import java.util.List;
        assertThat(explainResponse.isExists(), equalTo(true));
package org.opensearch.join.query;
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        refresh();
        client().admin().indices().prepareRefresh("test").get();
        assertThat(response.getHits().getHits()[2].getId(), equalTo("2"));
        createIndexRequest("test", "parent", "p2", null, "p_field", "p_value2").get();
                jsonBuilder().startObject()
            .setQuery(
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(1f));
import java.util.Collection;
                        ),
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(2f));
        SearchResponse searchResponse = client().prepareSearch("test")
        response = minMaxQuery(ScoreMode.None, 2, 2);
        createIndexRequest("test", "child", "c3", "p2", "c_field", "blue").get();
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("p1"));
        indexBuilders.add(createIndexRequest("test", "child", "12", "2", "foo", "one two"));
        response = minMaxQuery(ScoreMode.Avg, 1, 3);
        assertThat(searchHits[0].getHighlightFields().get("c_field").getFragments().length, equalTo(1));
        assertNoFailures(response);
                numChildDocsPerParent++;
        createIndexRequest("my-index", "parent", "1", null).get();
        assertThat(response.getHits().getTotalHits().value(), equalTo(1L));
        assertThat(response.getHits().getHits()[2].getScore(), equalTo(1f));
        searchResponse = client().prepareSearch("test")
        createIndexRequest("test", "child-type", "child-id", "parent-id", "searchText", "quick brown fox").get();
        client().admin().indices().prepareRefresh("test").get();
            fail();
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(6f));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        refresh();
            .setQuery(boolQuery().must(matchAllQuery()).filter(hasChildQuery("child", matchAllQuery(), ScoreMode.None)))
import org.opensearch.action.search.SearchResponse;
            prepareCreate("test").setSettings(Settings.builder().put("index.refresh_interval", -1))
                    )
                    .endObject()
                .endObject()
            .setQuery(
        assertThat(response.getHits().getHits()[2].getId(), equalTo("4"));
            .get();
                .setQuery(
        indexRandom(true, createMinMaxDocBuilders().toArray(new IndexRequestBuilder[0]));
        response = minMaxQuery(ScoreMode.None, 3, null);
        assertThat(response.getHits().getTotalHits().value(), equalTo(1L));
    }
        searchResponse = client().prepareSearch("test")
        countResponse = client().prepareSearch("test").setSize(0).setQuery(hasParentQuery("parent", termQuery("p_field", "1"), true)).get();
    private List<IndexRequestBuilder> createMinMaxDocBuilders() {
        assertThat(response.getHits().getHits()[1].getId(), equalTo("17"));
        createIndexRequest("test", "child", "c6", "p4", "c_field", "blue").get();
        assertThat(response.getHits().getHits()[2].getScore(), equalTo(1f));
        int numChildDocs = 32;
            .setQuery(constantScoreQuery(hasChildQuery("child", termQuery("c_field", "yellow"), ScoreMode.None)))
        assertAcked(prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child")));
        ensureGreen();
    // Issue #3290
                .setQuery(hasChildQuery("child", prefixQuery("c_field", "c"), ScoreMode.Max))
        );
    }
            .setQuery(hasChildQuery("child", matchQuery("text", "value"), ScoreMode.None))
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
        searchResponse = client().prepareSearch("test")
        createIndexRequest("test", "child", "2", "1", "c_field", 1).get();
        assertHitCount(searchResponse, 1L);
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));
        assertThat(response.getHits().getTotalHits().value(), equalTo(1L));
        createIndexRequest("test", "child", "c4", "p2", "c_field", "x").get();
        ).get();
                .startObject()
        createIndexRequest("test", "child", "c3", "p2", "c_field", "blue").get();
        }
        );
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(1f));
    }
        }
import static org.hamcrest.Matchers.anyOf;
        response = client().prepareSearch("test").setQuery(hasChildQuery("child", matchQuery("text", "value"), ScoreMode.Max)).get();
        countResponse = client().prepareSearch("test")
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));
            .setQuery(hasChildQuery("child", termQuery("c_field", "1"), ScoreMode.Max))
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(3f));
    }
        refresh();
            prepareCreate("test").setMapping(
    public static Collection<Object[]> parameters() {
            assertThat(e.status(), equalTo(RestStatus.BAD_REQUEST));
    public void testScopedFacet() throws Exception {
        assertThat(response.getHits().getHits()[0].getId(), equalTo("3"));
            assertThat(scannedDocs, equalTo(10));
        refresh();
        ensureGreen();
        // index simple data
        assertThat(response.getHits().getHits()[2].getId(), equalTo("2"));
        } catch (SearchPhaseExecutionException e) {
        createIndexRequest("test", "parent", "p1", null, "p_field", "p_value1").get();
    }
        createIndexRequest("grandissue", "child_type_one", "3", "2", "name", "William").setRouting("1").get();
            )
                    .field("type", "join")
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));
                )
import static org.opensearch.index.query.QueryBuilders.boolQuery;
        // index simple data
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(3f));
        searchResponse = client().prepareSearch("test").setQuery(randomHasChild("child", "c_field", "red")).get();
        assertAcked(
 *
import org.opensearch.index.query.InnerHitBuilder;
        assertThat(termsFacet.getBuckets().get(0).getKeyAsString(), equalTo("red"));
            .get();
            .get();
        createIndexRequest("test", "child", "2", "1", "c_field", 1).get();
import org.opensearch.common.settings.Settings;
                .setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child"))
        indexBuilders.add(createIndexRequest("test", "parent", "1", null, "id", 1));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        assertNoFailures(searchResponse);
        createIndexRequest("test", "child-type", "child-id", "parent-id").get();
        assertThat(explainResponse.getExplanation().toString(), containsString("join value p1"));
            do {
        // index simple data
        assertNoFailures(searchResponse);
            .get();
        assertNoFailures(searchResponse);
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(1f));
        createIndexRequest("test", "parent", "p1", null, "p_field", "p_value1_updated").get();
        try {
                jsonBuilder().startObject()
        assertThat(searchResponse.getHits().getAt(1).getId(), anyOf(equalTo("c1"), equalTo("c2")));
        createIndexRequest("test", "child", "c2", "p2", "c_field", "blue").get();
            .setSize(0)
import org.opensearch.common.lucene.search.function.CombineFunction;
        assertThat(response.getHits().getTotalHits().value(), equalTo(0L));
        assertAcked(prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child")));
        assertNoFailures(searchResponse);
        createIndexRequest("test", "parent", "p4", null, "p_field", "p_value4").get();
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(6f));
        createIndexRequest("test", "child", "c4", "p2", "c_field", "x").get();
                .setQuery(
        refresh();
            prepareCreate("test").setSettings(Settings.builder().put(indexSettings()).put("index.refresh_interval", -1))
        assertHitCount(searchResponse, 1L);
                boolQuery().must(matchAllQuery())
                .setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child"))
        indexBuilders.add(createIndexRequest("test", "child", "18", "3", "c_field1", 1, "c_field2", 2, "c_field3", 2));
        response = minMaxQuery(ScoreMode.Total, 4, null);
        createIndexRequest("test", "parent", "p1", null, "p_field", "p_value1").get();
                                .filter(hasChildQuery("grandchild", termQuery("gc_field", "gc_value1"), ScoreMode.None)),
                    .endObject()
    private SearchResponse minMaxQuery(ScoreMode scoreMode, int minChildren, Integer maxChildren) throws SearchPhaseExecutionException {
        assertThat(e.getMessage(), equalTo("[has_child] 'max_children' is less than 'min_children'"));
            .setQuery(boolQuery().must(matchAllQuery()).filter(hasChildQuery("child", termQuery("c_field", 1), ScoreMode.None)))
        createIndexRequest("test", "test", "2", "1", "foo", 1).get();
    }
        assertAcked(prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child")));
                    new BoolQueryBuilder().must(new MatchQueryBuilder("searchText", "fox"))
        client().admin().indices().prepareFlush().get();
        ensureGreen();
import static org.opensearch.join.query.JoinQueryBuilders.hasChildQuery;
                    QueryBuilders.functionScoreQuery(matchQuery("c_field2", 0), fieldValueFactorFunction("c_field1"))
        assertNoFailures(searchResponse);
 * specific language governing permissions and limitations
                    .startObject("properties")
import static org.opensearch.index.query.QueryBuilders.idsQuery;
/*
 * Unless required by applicable law or agreed to in writing,
        }
 *
        indexBuilders.add(createIndexRequest("test", "child", "5", "1", "c_field1", 1, "c_field2", 0));
        createIndexRequest("test", "parent", "p6", null, "p_field", "p_value6").get();
        client().admin().indices().prepareRefresh("test").get();
import static org.opensearch.join.query.JoinQueryBuilders.parentId;
        SearchResponse response = client().prepareSearch("test")
    public void testHighlightersIgnoreParentChild() throws IOException {
        assertHitCount(countResponse, 1L);
            .setQuery(hasParentQuery("parent", termQuery("p_field", "1"), true).queryName("test"))
        indexBuilders.add(createIndexRequest("test", "child", "13", "3", "foo", "one"));
        client().prepareIndex("test").setId("3").setSource("p_field", 2).get();
        searchResponse = client().prepareSearch("test").setQuery(randomHasParent("parent", "p_field", "p_value1")).get();
                    ScoreMode.Max
        searchResponse = client().prepareSearch("test")
        assertNoFailures(searchResponse);
                .endObject()
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));
        SearchResponse searchResponse = client().prepareSearch("test")
            .get();
        ensureGreen();
            .get();
            .get();
                .endObject()
        createIndexRequest("test", "child", "c1", "p1", "c_field", "red").get();
        ensureGreen();
            QueryBuilders.functionScoreQuery(
            .setQuery(boolQuery().must(matchAllQuery()).filter(hasParentQuery("child", termQuery("c_field", "c_value1"), false)))
        try {
        assertThat(response.getHits().getHits()[0].getId(), equalTo("3"));
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));
    public void testSimpleChildQueryWithFlush() throws Exception {
        ).minMaxChildren(minChildren, maxChildren != null ? maxChildren : HasChildQueryBuilder.DEFAULT_MAX_CHILDREN);
        SearchResponse searchResponse = client().prepareSearch("test")
            } else {
        assertThat(e.getMessage(), equalTo("[has_child] 'max_children' is less than 'min_children'"));
            )
    public void testCountApiUsage() throws Exception {
        searchResponse = client().prepareSearch("test")
        client().admin().indices().prepareFlush().get();
import org.opensearch.search.aggregations.bucket.global.Global;
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("p1"));
                .startObject()
    }
        response = client().prepareSearch("filter2").get();
        builders.clear();
        List<IndexRequestBuilder> builders = new ArrayList<>();
            )
        }
        createIndexRequest("test", "parent", "p1", null, "p_field", "p_value1").get();
    public void testMultiLevelChild() throws Exception {
    }
        } else {
            .setExplain(true)
                .field("i_field", "2")
                previousParentId = "p" + i;
        refresh();
            prepareCreate("test").setMapping(
        createIndexRequest("test", "child", "c3", "p2", "c_field", "blue").get();
            }
            assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("p001"));
        assertThat(termsFacet.getBuckets().get(1).getKeyAsString(), equalTo("yellow"));
        assertThat(searchResponse.getHits().getAt(0).getMatchedQueries().length, equalTo(1));
            .get();
        // index simple data
        assertAcked(
        // index simple data
        assertThat(searchResponse.getHits().getAt(0).getSourceAsString(), containsString("\"p_value1\""));
        createIndexRequest("grandissue", "parent", "2", "1", "name", "Dana").get();
            .get();
        }
        assertThat(response.getHits().getHits()[2].getId(), equalTo("2"));
        assertThat(response.getHits().getHits()[0].getId(), equalTo("3"));
        assertHitCount(response, 0L);
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(1.5f));
        assertThat(response.getHits().getHits()[2].getId(), equalTo("2"));
    public void testReIndexingParentAndChildDocuments() throws Exception {
        assertThat(response.getHits().getHits()[2].getScore(), equalTo(1f));
import java.util.Arrays;
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("c1"));
                        "parent",
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
                .startArray("objects")
            .get();
        assertThat(response.getHits().getHits()[2].getId(), equalTo("2"));
            assertThat(e.status(), equalTo(RestStatus.BAD_REQUEST));
        assertHitCount(searchResponse, 2L);
        createIndexRequest("test", "child", "c1", "p1", "c_field", "red").get();
        assertThat(response.getHits().getHits()[0].getId(), equalTo("16"));
        ensureGreen();
        assertNoFailures(searchResponse);
            "parent",
import org.opensearch.search.sort.SortBuilders;
        assertThat(response.getHits().getHits()[0].getId(), equalTo("1"));
import org.opensearch.index.query.BoolQueryBuilder;
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(3f));
        super(settings);
        List<IndexRequestBuilder> builders = new ArrayList<>();
        SearchResponse searchResponse = client().prepareSearch("test")
        createIndexRequest("test", "child", "c2", "p2").get();
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(1f));
        indexBuilders.add(createIndexRequest("test", "parent", "3", null, "id", 3));
        response = minMaxQuery(ScoreMode.Max, 2, null);
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(3f));
                    .subAggregation(
        createIndexRequest("test", "child", "c2", "p1", "c_field", "yellow").get();
            }
                        .boostMode(CombineFunction.REPLACE),
        assertThat(searchResponse.getHits().getAt(0).getSourceAsString(), containsString("\"p_value1\""));
    public void testParentChildQueriesNoParentType() throws Exception {
            .setQuery(
                )
                    .startObject("properties")
            for (int i = 10; i < 20; i++) {
        assertThat(searchHits[0].getHighlightFields().get("c_field").getFragments()[0].string(), equalTo("foo <em>bar</em>"));
            builders.add(createIndexRequest("test", "child", childId, previousParentId, "c_field", childId));
        assertThat(searchResponse.getHits().getAt(0).getExplanation().getDescription(), containsString("join value p1"));
            "test",
        indexRandom(true, builders.toArray(new IndexRequestBuilder[0]));
 * SPDX-License-Identifier: Apache-2.0
                            "child",
                    "keyword",
        assertThat(response.getHits().getTotalHits().value(), equalTo(2L));
            .setQuery(constantScoreQuery(hasChildQuery("child", termQuery("c_field", "red"), ScoreMode.None)))
        assertAcked(prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child")));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.hasId;
            fail();
    }
                scrollResponse = client().prepareSearchScroll(scrollResponse.getScrollId()).setScroll(TimeValue.timeValueSeconds(30)).get();
            assertThat(e.status(), equalTo(RestStatus.BAD_REQUEST));
        SearchResponse countResponse = client().prepareSearch("test")
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("p2"));
                break; // randomly break out and dont' have deletes / updates
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("gc1"));
            .get();
                    )
        createIndexRequest("test", "parent", "1", null, "p_field", 1).get();
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(1.5f));
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("c2"));
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));
                            boolQuery().must(hasChildQuery("child", matchQuery("c_field", "red"), ScoreMode.None)).must(matchAllQuery())
        assertNoFailures(searchResponse);
        indexBuilders.add(createIndexRequest("test", "child", "16", "4", "foo", "one"));
            .setQuery(constantScoreQuery(hasParentQuery("parent", termQuery("p_field", "1"), false).queryName("test")))
        refresh();
        createIndexRequest(
            .setQuery(hasParentQuery("parent-type", new IdsQueryBuilder().addIds("parent-id"), false))
        assertThat(response.getHits().getTotalHits().value(), equalTo(2L));
        assertThat(response.getHits().getHits()[0].getId(), equalTo("4"));
            searchResponse = client().prepareSearch("test")
            clearScroll(scrollResponse.getScrollId());
        assertThat(response.getHits().getHits()[0].getId(), equalTo("4"));
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(1f));
                        new HighlightBuilder().field(new Field("c_field").highlightQuery(QueryBuilders.matchQuery("c_field", "bar")))
        createIndexRequest("test", "child", "c4", "p2", "c_field", "red").get();
    }
                    )
        // index simple data
                .startObject()
        assertNoFailures(searchResponse);
        createIndexRequest("test", "child", "c4", "p3", "c_field", "green").get();
            .get();
        response = minMaxQuery(ScoreMode.Total, 1, 2);
        assertThat(searchResponse.getHits().getAt(0).getMatchedQueries().length, equalTo(1));
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));
        assertThat(response.getHits().getHits()[1].getId(), equalTo("2"));
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(1.5f));
            .setQuery(hasChildQuery("child", termQuery("c_field", "1"), ScoreMode.Max))
                )
                    .endObject()
        }
        }
            .setQuery(hasChildQuery("child", termQuery("c_field", "1"), ScoreMode.Max))
            SearchResponse searchResponse = client().prepareSearch("test")
            int scannedDocs = 0;
                    QueryBuilders.functionScoreQuery(matchQuery("c_field2", 0), fieldValueFactorFunction("c_field1"))
        searchResponse = client().prepareSearch("test")
        assertThat(extractValue("join_field.parent", searchResponse.getHits().getAt(1).getSourceAsMap()), equalTo("p1"));
                .field("i_field", "5")
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(4f));
        searchResponse = client().prepareSearch("test")
        assertHitCount(countResponse, 1L);
import static org.opensearch.index.query.functionscore.ScoreFunctionBuilders.weightFactorFunction;
        response = client().prepareSearch("test")
        assertThat(response.getHits().getHits()[2].getScore(), equalTo(1f));
        SearchResponse searchResponse = client().prepareSearch("test")
            .setQuery(
            assertHitCount(searchResponse, 1);
        createIndexRequest("test", "child", "c1", "p1").get();
        createIndexRequest("test", "child", "2", "1", "c_field", 1).get();
        );
        for (int i = 0; i < 10; i++) {
        ensureGreen();
        assertAcked(prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child")));
        );
        refresh();
        client().admin().indices().prepareFlush().get();
        createIndexRequest("test", "child", "c3", "p2", "c_field", "x").get();
        response = minMaxQuery(ScoreMode.None, 2, null);
            .addSort(SortBuilders.fieldSort("c_field3"))
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
import org.opensearch.action.search.SearchPhaseExecutionException;
        searchResponse = client().prepareSearch("test")
        createIndexRequest("test", "foo", "1", null, "foo", 1).get();
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(1f));
        refresh();
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("p1"));
        for (int i = 1; i <= 10; i++) {
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        createIndexRequest("test", "child", "c4", "p2", "c_field", "red").get();
            .setQuery(
        assertThat(response.getHits().getHits()[2].getId(), equalTo("2"));
    }
        assertHitCount(searchResponse, 1L);
        createIndexRequest("test", "child", "c1", "p1", "c_field", "blue").get();
        assertThat(response.getHits().getTotalHits().value(), equalTo(0L));
            createIndexRequest("test", "parent", "p" + i, null).get();
        SearchResponse response = client().prepareSearch("test").setQuery(parentId("child", "p1")).get();
    }
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(3f));
        assertThat(response.getHits().getTotalHits().value(), equalTo(0L));
 * Modifications Copyright OpenSearch Contributors. See
        createIndexRequest("test", "parent", "p2", null, "p_field", "p_value2").get();
        searchResponse = client().prepareSearch("test").setQuery(idsQuery().addIds("c1")).get();
                        .must(new HasChildQueryBuilder("child-type", new MatchAllQueryBuilder(), ScoreMode.None))
        response = minMaxQuery(ScoreMode.Avg, 1, null);
        searchResponse = client().prepareSearch("test")
            .setQuery(hasChildQuery("child", termQuery("c_field", "yellow"), ScoreMode.None))
import static org.opensearch.index.query.QueryBuilders.termQuery;
                        hasChildQuery(
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
            .setQuery(constantScoreQuery(hasParentQuery("parent", termQuery("p_field", "1"), false)))
        indexBuilders.add(createIndexRequest("test", "child", "14", "2", "c_field1", 1, "c_field2", 1));
        SearchResponse searchResponse = client().prepareSearch("test")
                    .endObject()
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("p2"));
        countResponse = client().prepareSearch("test")
        // Parent 2 and its children
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(1f));
            if (previousParentId == null || i % numChildDocsPerParent == 0) {
        assertThat(response.getHits().getHits()[0].getId(), equalTo("3"));
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(3f));
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(5f));
        ensureGreen();
                    .filter(boolQuery().mustNot(termQuery("p_field", "3")))
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(5f));
        SearchResponse searchResponse = client().prepareSearch("test")
    }
        assertThat(response.getHits().getTotalHits().value(), equalTo(2L));
                .get();
                            "filter",
        createIndexRequest("test", "parent", "p2", null, "p_field", "p_value2").get();
        assertThat(response.getHits().getHits()[2].getId(), equalTo("2"));
        searchResponse = client().prepareSearch("test")
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(6f));
        SearchResponse searchResponse = client().prepareSearch("test")
        }
        assertNoFailures(searchResponse);
        return indexBuilders;
        assertNoFailures(searchResponse);
        assertThat(searchResponse.getHits().getAt(1).getId(), anyOf(equalTo("p2"), equalTo("p1")));
        QueryBuilder[] queries = new QueryBuilder[] {
        assertAcked(prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "foo", "test")));
        SearchResponse searchResponse = client().prepareSearch("test")
        searchResponse = client().prepareSearch("test")
    }
        assertThat(searchResponse.getHits().getAt(0).getId(), anyOf(equalTo("p2"), equalTo("p1")));
            assertThat(e.status(), equalTo(RestStatus.BAD_REQUEST));
        assertSearchHits(searchResponse, "child-id");
            builders.add(createIndexRequest("test", "parent", Integer.toString(i), null, "p_field", i));
                return constantScoreQuery(hasParentQuery(type, termQuery(field, value), false));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
            hasChildQuery("child", matchAllQuery(), ScoreMode.None),
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
                hasChildQuery(
                    .should(boolQuery().filter(termQuery("join_field#parent", "p2")).filter(termQuery("join_field", "child")))
            .get();
        assertHitCount(response, 1);
            } while (scrollResponse.getHits().getHits().length > 0);
        ensureGreen();
                    new FunctionScoreQueryBuilder.FilterFunctionBuilder(QueryBuilders.termQuery("foo", "three"), weightFactorFunction(1)),
                    .field("type", "join")
            .get();
            createIndexRequest("test", "parent", parentId, null, "p_field", parentId).get();
            .setSize(0)
        assertThat(response.getHits().getHits()[1].getId(), equalTo("4"));
                        boolQuery().must(
            .get();
    }
            )
    }
 * software distributed under the License is distributed on an
            assertThat(searchResponse.getHits().getHits()[3].getId(), equalTo("c003"));
        // index simple data with flushes, so we have many segments
 * GitHub history for details.
        client().admin().indices().prepareFlush().get();
            "child",
        indexBuilders.add(createIndexRequest("test", "child", "17", "3", "c_field1", 1, "c_field2", 1, "c_field3", 1));
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(4f));
        createIndexRequest("test", "child", "c1", "p1", "c_field", "blue").get();
        createIndexRequest("test", "parent", "p7", null, "p_field", "p_value7").get();
        // HAS PARENT
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));
                .setQuery(constantScoreQuery(hasParentQuery("parent", termQuery("p_field", parentToChildrenEntry.getKey()), false)))
        response = client().prepareSearch("test")
        assertHitCount(searchResponse, 1L);
        assertThat(response.getHits().getTotalHits().value(), equalTo(2L));
    }
        // Score mode = MAX
        for (int i = 0; i < 2; i++) {
        // Parent 2 and its children
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("p1"));
        SearchResponse searchResponse = client().prepareSearch("test")
        SearchResponse response = client().prepareSearch("filter1").get();
        indexBuilders.add(createIndexRequest("test", "child", "7", "1", "c_field1", 2, "c_field2", 0));
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(6f));
                    "child",
                .setQuery(constantScoreQuery(hasChildQuery("child", matchAllQuery(), ScoreMode.Max)))
        assertThat(extractValue("join_field.name", searchResponse.getHits().getAt(1).getSourceAsMap()), equalTo("child"));
    }
                    "p_field",
import org.opensearch.search.aggregations.bucket.filter.Filter;
                .field("i_field", "6")
            ).boostMode(CombineFunction.REPLACE).scoreMode(FunctionScoreQuery.ScoreMode.SUM),
            null,
            .setQuery(boolQuery().must(matchQuery("c_field", "x")).must(hasParentQuery("parent", termQuery("p_field", "p_value2"), true)))
            .get();
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(4f));
                .addSort("c_field", SortOrder.ASC)
                )
            .get();
            )
        indexBuilders.add(createIndexRequest("test", "child", "6", "1", "c_field1", 2, "c_field2", 0));
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(3f));
            .execute()
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));
                    .field("parent-type", "child-type")
        ).get();
            )
import java.util.Map;
            hasParentQuery("parent", matchAllQuery(), false),
        refresh();
        indexBuilders.add(createIndexRequest("test", "child", "11", "2", "foo", "one"));
        client().admin().indices().prepareFlush("test").get();
                    .field("index_options", "offsets")
        indexBuilders.add(createIndexRequest("test", "parent", "2", null, "p_field", "p_value2"));
        response = minMaxQuery(ScoreMode.Total, 3, null);
        SearchResponse searchResponse = client().prepareSearch()
        assertAcked(prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child")));
            .get();
            fail();
    private QueryBuilder randomHasChild(String type, String field, String value) {
        searchResponse = client().prepareSearch("test").setQuery(hasChildQuery("child", termQuery("c_field", "red"), ScoreMode.None)).get();
    }
        createIndexRequest("test", "child", "c1", "p1", "c_field", "red").get();
            .get();
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("1"));
import java.util.ArrayList;
        assertThat(response.getHits().getHits()[1].getId(), equalTo("2"));
        assertThat(parentToChildren.isEmpty(), equalTo(false));
            int j = childId;
            .setQuery(
        assertAcked(
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));
        Global global = searchResponse.getAggregations().get("global");
    public void testParentIdQuery() throws Exception {
            )
        createIndexRequest("test", "parent", "p1", null, "p_field", "p_value1").get();
                        .boostMode(CombineFunction.REPLACE),
        createIndexRequest("test", "parent", "p3", null, "p_field", "p_value3").get();
        String parentId = "p1";
        assertThat(searchResponse.getHits().getAt(1).getId(), anyOf(equalTo("p2"), equalTo("p1")));
        // HAS CHILD FILTER
 * KIND, either express or implied.  See the License for the
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(2f));
            .get();
            .setQuery(
            .setQuery(
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(6f));
        SearchResponse searchResponse = client().prepareSearch("test")
    }
            assertThat(searchResponse.getHits().getHits()[4].getId(), equalTo("c004"));
        for (QueryBuilder query : queries) {
        response = minMaxQuery(ScoreMode.Total, 2, 2);
            .setQuery(
                    "child",
 * You may obtain a copy of the License at
import org.opensearch.search.aggregations.AggregationBuilders;
        if (randomBoolean()) {
        for (int i = 0; i < 10; i++) {
 * the Apache License, Version 2.0 (the "License"); you may
                addFieldMappings(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child"), "c_field", "keyword")
 * The OpenSearch Contributors require contributions made to
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("gc1"));
                        "parent",
    public void testMinMaxChildren() throws Exception {
            .setQuery(constantScoreQuery(hasChildQuery("child", termQuery("c_field", "1"), ScoreMode.None)))
                .endArray()
                boolQuery().must(hasChildQuery("child", termQuery("c_field", "red"), scoreMode))
                    "child",
                builders.add(createIndexRequest("test", "child", j + "-" + i, Integer.toString(i), "c_field", i));
            )
                        .boostMode(CombineFunction.REPLACE),
        createIndexRequest("test", "parent", "1", null, "p_field", 1).get();
            assertThat(highlightField.getFragments()[0].string(), equalTo("quick brown <em>fox</em>"));
            .setRefreshPolicy(RefreshPolicy.IMMEDIATE)
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
import static org.opensearch.index.query.QueryBuilders.prefixQuery;
        assertThat(searchResponse.getHits().getAt(0).getMatchedQueries()[0], equalTo("test"));
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(1f));
        response = client().prepareSearch("test")
        response = minMaxQuery(ScoreMode.None, 1, null);
                .get();
        String parentId = "p1";
                        boolQuery().must(
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(2f));
            prepareCreate("test").setMapping(
        SearchResponse searchResponse = client().prepareSearch("test")
 * this file be licensed under the Apache-2.0 license or a
        createIndexRequest("test", "child", "c2", "p1", "c_field", "yellow").get();
        assertThat(response.getHits().getHits()[0].getId(), equalTo("4"));
            )
            logger.info("Round {}", i);
            fail();
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(3f));
                return constantScoreQuery(hasChildQuery(type, termQuery(field, value), ScoreMode.None));
                            boolQuery().must(termQuery("c_field", "c_value1"))
        assertThat(e.getMessage(), equalTo("[has_child] 'max_children' is less than 'min_children'"));
        assertHitCount(response, 2L);
                .setSize(5)
        SearchType[] searchTypes = new SearchType[] { SearchType.QUERY_THEN_FETCH, SearchType.DFS_QUERY_THEN_FETCH };
    }
        ensureGreen();
                constantScoreQuery(QueryBuilders.termQuery("foo", "two")),
        assertHitCount(searchResponse, 1L);
        createIndexRequest("my-index", "child", "2", "1").get();
        assertThat(response.getHits().getHits()[0].getId(), equalTo("4"));
        createIndexRequest("grandissue", "child_type_two", "4", "2", "name", "Kate").setRouting("1").get();
        indexBuilders.add(createIndexRequest("test", "child", "20", "3", "c_field1", 1, "c_field2", 2, "c_field3", 4));
        assertThat(termsFacet.getBuckets().get(1).getDocCount(), equalTo(1L));
/*
            assertThat(childIds.size(), is(0));
            .get();
            assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("parent-id"));
                        .must(new HasParentQueryBuilder("parent-type", new MatchAllQueryBuilder(), false))
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));
        response = client().prepareSearch("test").setQuery(hasParentQuery("parent", matchQuery("text", "value"), false)).get();
            .get();
            .get();
            assertHitCount(searchResponse, 1);
        e = expectThrows(IllegalArgumentException.class, () -> minMaxQuery(ScoreMode.Max, 3, 2));
                .get();
        response = minMaxQuery(ScoreMode.Avg, 1, 4);
            "test",
                    new BoolQueryBuilder().must(new MatchQueryBuilder("searchText", "fox"))
            return hasParentQuery(type, termQuery(field, value), false);
            .setQuery(
        assertThat(response.getHits().getTotalHits().value(), equalTo(0L));
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("2"));
        assertThat(response.getHits().getHits()[2].getScore(), equalTo(1f));
        SearchResponse searchResponse = client().prepareSearch("grandissue")
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("p1"));
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));
        assertAcked(
        // Score mode = AVG
        assertNoFailures(searchResponse);
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(3f));
        createIndexRequest("test", "parent", "p4", null, "p_field", "p_value4").get();
        refresh();
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("p1"));
        assertThat(response.getHits().getHits()[0].getId(), equalTo("4"));
        assertNoFailures(searchResponse);
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        response = client().prepareSearch("test")
            .get();
    List<IndexRequestBuilder> createDocBuilders() {
        assertThat(response.getHits().getHits()[2].getScore(), equalTo(1f));
        ensureGreen();
        }
                .startArray("objects")
        createIndexRequest("test", "parent", "p2", null, "p_field", "p_value2").get();
 */
        searchResponse = client().prepareSearch("test")
            searchResponse = client().prepareSearch("test")
            .get();
        assertThat(response.getHits().getTotalHits().value(), equalTo(2L));
        assertThat(response.getHits().getHits()[0].getId(), equalTo("4"));
        assertThat(response.getHits().getHits()[0].getId(), equalTo("2"));
                    QueryBuilders.functionScoreQuery(matchQuery("c_field2", 0), fieldValueFactorFunction("c_field1"))
        assertThat(response.getHits().getHits()[0].getId(), equalTo("3"));
            .setQuery(
                    .filter(
            .setQuery(boolQuery().must(matchAllQuery()).filter(hasParentQuery("parent", termQuery("p_field", "p_value1"), false)))
        createIndexRequest("test", "child", "c3", "p2", "c_field", "red").get();
        );
            .get();
        createIndexRequest("test", "child", "c3", "p2", "c_field", "blue").get();
        assertNoFailures(searchResponse);
    public void testAliasesFilterWithHasChildQuery() throws Exception {
        ensureGreen();
        client().admin().indices().prepareFlush("test").setForce(true).get();
        assertThat(response.getHits().getHits()[0].getId(), equalTo("3"));
            assertThat(parentToChildren.get(previousParentId).add(childId), is(true));
        createIndexRequest("test", "child", "c5", "p3", "c_field", "blue").get();
            client().prepareSearch("test").setQuery(hasParentQuery("parent", termQuery("p_field", "1"), true)).get();
            )
    public void testNamedFilters() throws Exception {
        createIndexRequest("test", "parent", "p2", null, "p_field", "p_value2").get();
        assertThat(response.getHits().getTotalHits().value(), equalTo(2L));
            assertThat(searchResponse.getHits().getHits()[4].getId(), equalTo("p004"));
        assertThat(searchResponse.getHits().getAt(0).getExplanation().getDescription(), containsString("join value p1"));
                .setSize(1)
        response = client().prepareSearch("test").setQuery(hasParentQuery("parent", matchQuery("text", "value"), true)).get();
            .get();
    }
        for (String highlightType : highlightTypes) {
        // index simple data
            .setQuery(hasParentQuery("child", termQuery("c_field", "c_value1"), false))
                    .startObject("properties")
        createIndexRequest("test", "child", "c4", "p2", "c_field", "red").get();
        // index simple data
 *
            )
        response = minMaxQuery(ScoreMode.Avg, 3, null);
import java.io.IOException;
        for (int i = 0; i < 10; i++) {
        Filter filter = global.getAggregations().get("filter");
        int childId = 0;
        assertThat(response.getHits().getTotalHits().value(), equalTo(1L));
 * under the License.
        assertThat(searchResponse.getHits().getAt(0).getMatchedQueries().length, equalTo(1));
        assertAcked(
        assertThat(searchResponse.getHits().getAt(0).getMatchedQueries().length, equalTo(1));
            .setQuery(boolQuery().must(matchAllQuery()).filter(hasParentQuery("parent", matchQuery("p_field", 1), false)))
            .get();
            }
import org.opensearch.index.query.functionscore.FunctionScoreQueryBuilder;
        assertNoFailures(searchResponse);
        assertThat(response.getHits().getHits()[2].getId(), equalTo("2"));
        indexBuilders.add(createIndexRequest("test", "child", "19", "4", "foo", "one two three four"));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        }
        assertThat(searchResponse.getHits().getAt(0).getScore(), equalTo(3.0f));
            .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
        assertThat(response.getHits().getHits()[5].getId(), equalTo("21"));
        assertNoFailures(searchResponse);
        indexBuilders.add(createIndexRequest("test", "child", "10", "2", "c_field1", 3, "c_field2", 0));
                .endObject()
        indexBuilders.add(createIndexRequest("test", "parent", "2", null, "id", 2));
        response = minMaxQuery(ScoreMode.Avg, 2, 2);
        refresh();
            .setQuery(hasParentQuery("parent", termQuery("p_field", "1"), true))
        List<IndexRequestBuilder> indexBuilders = new ArrayList<>();
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
                .endObject()
import org.opensearch.index.query.QueryBuilder;
    }
        createIndexRequest("test", "parent", "p2", null, "p_field", "p_value2").get();
                .setQuery(query)
        assertAcked(prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child")));
        assertThat(searchResponse.getHits().getAt(0).getSourceAsString(), containsString("\"p_value1\""));
                .get();
        assertThat(response.getHits().getHits()[0].getId(), equalTo("4"));
                            boolQuery().should(termQuery("c_field", "red")).should(termQuery("c_field", "yellow"))
        assertThat(response.getHits().getTotalHits().value(), equalTo(7L));
                assertThat(childIds.remove(searchResponse.getHits().getAt(i).getId()), is(true));
        assertThat(searchResponse.getHits().getAt(1).getId(), anyOf(equalTo("p2"), equalTo("p1")));
                .field("i_field", "3")
                    )
            fail();
import org.opensearch.action.index.IndexRequestBuilder;
        createIndexRequest("test", "child", "c2", "p1", "c_field", "yellow").get();
                    boolQuery().should(termQuery("c_field", "red")).should(termQuery("c_field", "yellow")),
                    .startObject("relations")
        response = minMaxQuery(ScoreMode.Max, 1, 4);
            for (int i = 0; i < 10; i++) {
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("p2"));
        assertAcked(
    public void testHasChildAndHasParentFailWhenSomeSegmentsDontContainAnyParentOrChildDocs() throws Exception {
 * not use this file except in compliance with the License.
                hasChildQuery(
        assertNoFailures(searchResponse);
                boolQuery().should(boolQuery().filter(termQuery("join_field#parent", "p1")).filter(termQuery("join_field", "child")))
    public void testParentChildCaching() throws Exception {
import java.util.Locale;
    public void testDfsSearchType() throws Exception {
        assertThat(response.getHits().getHits()[1].getId(), equalTo("2"));
                        AggregationBuilders.filter(
    }
        createIndexRequest("test", "child", "c1", parentId, "c_field", "1").get();
            SearchResponse searchResponse = client().prepareSearch()
        searchResponse = client().prepareSearch("test")
                .get();
        searchResponse = client().prepareSearch("test")
        assertThat(searchResponse.getHits().getAt(0).getMatchedQueries()[0], equalTo("test"));
            scoreMode
        );
import org.opensearch.search.fetch.subphase.highlight.HighlightField;
        assertThat(response.getHits().getHits()[2].getScore(), equalTo(1.5f));
            .execute()
            String childId = "c" + i;
            .actionGet();
            createIndexRequest("test", "child", "c" + i, "p" + i).get();
    }
        SearchResponse searchResponse = client().prepareSearch("test")
            .setSize(0)
            .actionGet();
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(2f));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
                    new FunctionScoreQueryBuilder.FilterFunctionBuilder(QueryBuilders.termQuery("foo", "four"), weightFactorFunction(1)) }
                .setSize(5)
import static org.hamcrest.Matchers.containsString;
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
import static org.opensearch.index.query.QueryBuilders.queryStringQuery;
                    .field("parent", new String[] { "child_type_one", "child_type_two" })
            assertNoFailures(searchResponse);
            .setQuery(
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));
                .setSize(numChildDocsPerParent)
        assertNoFailures(searchResponse);
        assertThat(response.getHits().getHits()[1].getId(), equalTo("2"));
        indexBuilders.add(createIndexRequest("test", "child", "10", "1", "foo", "one"));
        ensureGreen();
            jsonBuilder().startObject()
            .get();
            .get();
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(1f));
            }
 * ownership. Elasticsearch licenses this file to you under
        assertThat(response.getHits().getHits()[1].getId(), equalTo("2"));
        );
            createIndexRequest("test", "child", "d" + i, "p1", "c_field", "red").get();
    }
            client().admin().indices().prepareRefresh("test").get();
        assertThat(response.getHits().getHits()[2].getScore(), equalTo(1f));
 */
            assertThat(highlightField.getFragments()[0].string(), equalTo("quick brown <em>fox</em>"));
        assertHitCount(response, 1);
        assertNoFailures(response);
import java.util.HashSet;
        assertThat(response.getHits().getHits()[0].getId(), equalTo("4"));
        response = minMaxQuery(ScoreMode.None, 1, null);
        assertThat(response.getHits().getHits()[2].getId(), equalTo("2"));
                    .filter(boolQuery().must(hasChildQuery("child", matchQuery("c_field", "red"), ScoreMode.None)).must(matchAllQuery()))
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(1.5f));
        assertNoFailures(searchResponse);
        assertThat(response.getHits().getTotalHits().value(), equalTo(1L));
 *    http://www.apache.org/licenses/LICENSE-2.0
        createIndexRequest("test", "parent", "p10", null, "p_field", "p_value10").get();
        assertAcked(prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child")));
        // HAS CHILD QUERY
                    "child",
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
        assertNoFailures(searchResponse);
                hasChildQuery(
        assertThat(response.getHits().getHits()[0].getId(), equalTo("4"));
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;
                parentToChildren.put(previousParentId, new HashSet<>());
        assertThat(response.getHits().getTotalHits().value(), equalTo(1L));
        assertThat(response.getHits().getHits()[2].getScore(), equalTo(2f));
                )
        refresh();
        assertAcked(
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("p2"));
        Terms termsFacet = filter.getAggregations().get("facet1");
    public void testHasParentFilter() throws Exception {
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));
                    .startObject("join_field")
            prepareCreate("test").setMapping(
        assertThat(response.getHits().getHits()[0].getId(), equalTo("2"));
                        ),
        response = minMaxQuery(ScoreMode.Max, 1, 3);
        assertThat(response.getHits().getHits()[2].getId(), equalTo("4"));
            )
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));
        searchResponse = client().prepareSearch("test")
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(3f));
            assertThat(searchResponse.getHits().getHits()[2].getId(), equalTo("c002"));
                .highlighter(new HighlightBuilder().field(new HighlightBuilder.Field("searchText").highlighterType(highlightType)))
        // index simple data
                    .startObject("join_field")
        }
            .setQuery(boolQuery().mustNot(hasParentQuery("parent", boolQuery().should(queryStringQuery("p_field:*")), false)))
    public void testCachingBugWithFqueryFilter() throws Exception {
            return hasChildQuery(type, termQuery(field, value), ScoreMode.None);
                            hasChildQuery("child_type_one", boolQuery().must(queryStringQuery("name:William*")), ScoreMode.None)
        refresh();
        assertThat(e.getMessage(), equalTo("[has_child] 'max_children' is less than 'min_children'"));
        assertThat(searchResponse.getHits().getAt(0).getId(), anyOf(equalTo("p2"), equalTo("p1")));
        // Score mode = NONE
        assertThat(searchResponse.getHits().getAt(0).getMatchedQueries()[0], equalTo("test"));
        assertThat(response.getHits().getHits()[2].getId(), equalTo("4"));
            assertThat(searchResponse.getHits().getHits()[2].getId(), equalTo("p002"));
        return client().prepareSearch("test").setQuery(hasChildQuery).addSort("_score", SortOrder.DESC).addSort("id", SortOrder.ASC).get();
                    true
            .setQuery(boolQuery().must(matchAllQuery()).filter(hasChildQuery("child", matchQuery("c_field", 1), ScoreMode.None)))
            client().prepareSearch("test").setPostFilter(hasParentQuery("parent", termQuery("p_field", "1"), false)).get();
            .get();
        createIndexRequest("test", "parent", "p5", null, "p_field", "p_value5").get();
    }
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(2f));
        createIndexRequest("test", "parent", "p1", null, "p_field", "p_value1").get();
        // Score mode = SUM
        refresh();
        assertNoFailures(searchResponse);
        assertSearchHit(searchResponse, 1, hasId("1"));
        client().admin().indices().prepareFlush().get();
        assertHitCount(countResponse, 1L);
            .get();
        ensureGreen();
    public ChildQuerySearchIT(Settings settings) {
                .setSearchType(searchType)
    }
        assertThat(response.getHits().getHits()[2].getScore(), equalTo(1f));
        ensureGreen();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertAcked(
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));
                )
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));
        createIndexRequest("grandissue", "grandparent", "1", null, "name", "Grandpa").get();
        // query filter in case for p/c shouldn't execute per segment, but rather
        response = minMaxQuery(ScoreMode.None, 4, null);
        assertThat(response.getHits().getHits()[2].getId(), equalTo("2"));
import static org.opensearch.index.query.functionscore.ScoreFunctionBuilders.fieldValueFactorFunction;
            .get();
        response = minMaxQuery(ScoreMode.Max, 1, null);
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        assertNoFailures(searchResponse);
import static org.hamcrest.Matchers.is;
                    ScoreMode.Total
        assertAcked(prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child")));
            }
        refresh();
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
        indexBuilders.add(createIndexRequest("test", "parent", "3", null, "p_field1", "p_value3", "p_field2", 5));
import org.opensearch.search.aggregations.bucket.terms.Terms;
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(3f));
            .setMinScore(3) // Score needs to be 3 or above!
                AggregationBuilders.global("global")
        indexBuilders.add(createIndexRequest("test", "child", "4", "1", "c_field1", 1, "c_field2", 0));
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(1f));
        assertThat(response.getHits().getHits()[0].getId(), equalTo("4"));
                .endObject()
            .get();
            highlightField = searchResponse.getHits().getAt(0).getHighlightFields().get("searchText");
        createIndexRequest("test", "parent", "p9", null, "p_field", "p_value9").get();
    public void testDeletedParent() throws Exception {
        assertNoFailures(searchResponse);
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(6f));
import org.opensearch.core.rest.RestStatus;
        refresh();
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        // Parent 3 and its children
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));
                .startObject()
        createIndexRequest("test", "child", "c1", "p1", "c_field", "red").get();
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(1f));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
                    hasChildQuery(
        indexRandom(true, createDocBuilders().toArray(new IndexRequestBuilder[0]));
            .get();
            .actionGet();
            prepareCreate("test").setMapping(
        response = minMaxQuery(ScoreMode.Max, 3, null);
        );
        assertThat(response.getHits().getHits()[0].getId(), equalTo("3"));
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(1f));
        SearchResponse searchResponse;
                        ScoreMode.None
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(1.5f));
                .setQuery(
                hasChildQuery("child", matchQuery("c_field", "foo"), ScoreMode.None).innerHit(
        response = minMaxQuery(ScoreMode.Total, 2, null);
            .get();
        indexBuilders.add(createIndexRequest("test", "child", "18", "4", "foo", "one two three"));
        assertThat(response.getHits().getTotalHits().value(), equalTo(0L));
            .setQuery(hasChildQuery("child", termQuery("c_field", "yellow"), ScoreMode.Total))
            }
        searchResponse = client().prepareSearch("test")
        assertThat(response.getHits().getHits()[1].getId(), equalTo("3"));
    }
    }
        }
        response = minMaxQuery(ScoreMode.Total, 1, 3);
                    "c_field",
                .setQuery(hasParentQuery("parent", prefixQuery("p_field", "p"), true))
                boolQuery().must(
            }
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
                assertThat(searchResponse.getHits().getAt(i).getScore(), is(1.0f));
                .actionGet();
                hasChildQuery(
                        ).subAggregation(AggregationBuilders.terms("facet1").field("c_field"))
        searchResponse = client().prepareSearch("test")
            .addAggregation(
        searchResponse = client().prepareSearch("test")
                addFieldMappings(
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("c1"));
            .get();
        assertThat(response.getHits().getHits()[0].getScore(), equalTo(2f));
            .get();
                .setSearchType(searchType)
        assertAcked(
    }
        assertThat(response.getHits().getHits()[2].getScore(), equalTo(1f));
                )
                assertThat(scrollResponse.getHits().getTotalHits().value(), equalTo(10L));
        client().admin().indices().prepareFlush().get();
        searchResponse = client().prepareSearch("test").setQuery(randomHasChild("child", "c_field", "yellow")).get();
        assertThat(response.getHits().getHits()[0].getId(), equalTo("3"));
                .get();
                    new FunctionScoreQueryBuilder.FilterFunctionBuilder(weightFactorFunction(1)),
        response = minMaxQuery(ScoreMode.Max, 1, 2);
        indexBuilders.add(createIndexRequest("test", "child", "12", "p", "c_field1", 1, "c_field2", 1)); // why "p"????
            .get();
                builders.add(createIndexRequest("test", "parent", previousParentId, null, "p_field", previousParentId));
        assertAcked(prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child")));
        response = minMaxQuery(ScoreMode.Avg, 4, null);
        createIndexRequest("test", "child", "c4", "p2", "c_field", "red").get();
        ensureGreen();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHit;
        parentToChildren.put("p0", new HashSet<>());
                .field("p_field", "2")
        assertThat(response.getHits().getHits()[2].getId(), equalTo("18"));
        assertThat(response.getHits().getHits()[0].getId(), equalTo("4"));
 * compatible open source license.
            assertNoFailures(searchResponse);
        createIndexRequest("test", "child", "c2", "p1", "c_field", "red").get();
        } catch (SearchPhaseExecutionException e) {
                    .endObject()
        assertThat(searchResponse.getHits().getAt(0).getId(), Matchers.anyOf(equalTo("c3"), equalTo("c4")));
        assertThat(response.getHits().getHits()[0].getId(), equalTo("2"));
        response = minMaxQuery(ScoreMode.None, 1, 4);
        assertAcked(
        assertThat(searchHits.length, equalTo(1));
        );
        searchResponse = client().prepareSearch("test")
        assertSearchHits(searchResponse, "parent-id");
        } catch (SearchPhaseExecutionException e) {
        createIndexRequest("test", "child", "c3", "p3", "c_field", "blue").get();
        assertAcked(admin().indices().prepareAliases().addAlias("my-index", "filter2", hasParentQuery("parent", matchAllQuery(), false)));
        indexBuilders.add(createIndexRequest("test", "child", "19", "3", "c_field1", 1, "c_field2", 2, "c_field3", 3));
                .setQuery(constantScoreQuery(hasParentQuery("parent", matchAllQuery(), true)))
        ensureGreen();
        searchResponse = client().prepareSearch("grandissue")
            if (randomBoolean()) {
            )
        return Arrays.asList(
            searchResponse = client().prepareSearch("test")
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(3f));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        searchResponse = client().prepareSearch("test")
        createIndexRequest("test", "parent", "p2", null, "p_field", "p_value2").get();
        assertThat(response.getHits().getHits()[2].getScore(), equalTo(1f));
        assertThat(response.getHits().getHits()[0].getId(), equalTo("2"));
        searchResponse = client().prepareSearch("test")
    public void testHasChildAndHasParentFilter_withFilter() throws Exception {
        // index simple data
        assertThat(searchResponse.getHits().getAt(0).getId(), anyOf(equalTo("p2"), equalTo("p1")));
        createIndexRequest("test", "parent-type", "parent-id", null).get();
        indexBuilders.add(createIndexRequest("test", "child1", "22", "3", "c_field1", 1, "c_field2", 2, "c_field3", 6));
            )
import org.opensearch.common.unit.TimeValue;
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("p1"));
            prepareCreate("my-index").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child"))
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("c3"));
            jsonBuilder().startObject()
            .get();
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(500L));
    public void testScoreForParentChildQueriesWithFunctionScore() throws Exception {
            prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent-type", "child-type"))
                    ScoreMode.Avg
            assertNoFailures(searchResponse);
        ScoreMode scoreMode = randomFrom(ScoreMode.values());
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
        assertHitCount(response, 2L);
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("c4"));
            client().prepareSearch("test").setQuery(hasChildQuery("child", termQuery("c_field", "1"), ScoreMode.None)).get();
                .startObject()
            .actionGet();
        assertHitCount(searchResponse, 1L);
        createIndexRequest("test", "child", "c1", "p1", "c_field", "c_value1").get();
            .get();
        response = client().prepareSearch("test")
        assertThat(response.getHits().getHits()[3].getId(), equalTo("19"));
                .startObject()
        assertThat(extractValue("join_field.name", searchResponse.getHits().getAt(0).getSourceAsMap()), equalTo("child"));
            }
            if (randomBoolean()) {
        assertAcked(prepareCreate("test").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child")));
        assertThat(response.getHits().getHits()[2].getId(), equalTo("2"));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        // Parent 1 and its children
        response = minMaxQuery(ScoreMode.Total, 1, 4);
            .execute()
        // make sure that when we explicitly set a type, the inner query is executed in the context of the parent type instead
                    "keyword"
        ensureGreen();
        assertSearchHit(searchResponse, 1, hasId("1"));
                        )
        response = minMaxQuery(ScoreMode.Max, 1, null);
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(2f));
                boolQuery().must(matchAllQuery()).filter(boolQuery().must(hasChildQuery("child", matchQuery("c_field", 1), ScoreMode.None)))
            .setQuery(boolQuery().must(matchAllQuery()).filter(hasParentQuery("parent", matchAllQuery(), false)))
        ensureGreen();
        assertThat(response.getHits().getHits()[1].getScore(), equalTo(2f));
                .field("i_field", "2")
        createIndexRequest("test", "child", "c4", "p2", "c_field", "red").get();
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("p1"));
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));
            HighlightField highlightField = searchResponse.getHits().getAt(0).getHighlightFields().get("searchText");
        e = expectThrows(IllegalArgumentException.class, () -> minMaxQuery(ScoreMode.Total, 3, 2));
        assertThat(response.getHits().getHits()[2].getId(), equalTo("1"));
            assertThat(searchResponse.getHits().getHits()[3].getId(), equalTo("p003"));
                .get();
                boolQuery().must(hasChildQuery("child", termQuery("c_field", "blue"), scoreMode))
        }
                scannedDocs += scrollResponse.getHits().getHits().length;
        client().admin().indices().prepareForceMerge("test").setMaxNumSegments(1).setFlush(true).get();
    private QueryBuilder randomHasParent(String type, String field, String value) {
        assertThat(termsFacet.getBuckets().size(), equalTo(2));
            .get();
        indexRandom(randomBoolean(), builders);
        createIndexRequest("test", "child", "c2", "p1", "c_field", "yellow").get();
        assertThat(response.getHits().getHits()[0].getId(), equalTo("4"));
            .setQuery(constantScoreQuery(hasChildQuery("child", termQuery("c_field", "blue"), ScoreMode.None)))
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));
        indexBuilders.add(createIndexRequest("test", "child", "9", "1", "c_field1", 1, "c_field2", 2));
import static org.opensearch.index.query.QueryBuilders.constantScoreQuery;
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));
        assertThat(response.getHits().getHits()[0].getId(), equalTo("4"));
            .setQuery(boolQuery().must(matchQuery("c_field", "x")).must(hasParentQuery("parent", termQuery("p_field", "p_value2"), true)))
        assertThat(extractValue("join_field.parent", searchResponse.getHits().getAt(0).getSourceAsMap()), equalTo("p1"));
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
