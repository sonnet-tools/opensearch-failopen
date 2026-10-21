            .setQuery(
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(0L));
            )
        ensureGreen();
        searchResponse = client().prepareSearch("test").setQuery(termQuery("n_field1", "n_value1_1")).get();
        assertThat(searchResponse.getHits().getHits()[2].getSortValues()[0].toString(), equalTo("3"));
        if (loadFixedBitSeLazily) {
                MediaTypeRegistry.JSON
                    .endObject()
                        .endObject()
        // Sort mode: sum with filter
                    .startObject("last")
            )
                    .field("last", "lname3")
                .setMapping(
                    .field("field1", "4")
                    + "          }\n"
            .get();
                    .setNestedPath("users")
        assertThat(searchResponse.getHits().getHits()[2].getSortValues()[0].toString(), equalTo("3"));
                    .startArray("nested1")
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("1"));
                    .startObject()
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("3"));
        SearchResponse searchResponse = client().prepareSearch("test").get();
        assertHitCount(searchResponse, 3);
                    .endArray()
            .get();
                        .endObject()
                    .endObject()
            .endArray()
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
        }
        // Sort mode: sum
    }
        assertAcked(prepareCreate("test").setSettings(settingsBuilder));
            )
                    .startArray("child")
                    .endObject()
        client().prepareIndex("test")
        searchResponse = client().prepareSearch()
                    .field("first", "fname3")
                            boolQuery().must(termQuery("nested1.n_field1", "n_value1_1")).must(termQuery("nested1.n_field2", "n_value2_1")),
            .setId("3")
                    .field("type", "keyword")
                    .startObject("parent")
                    .startObject("nested1")
    public void testMultiNested() throws Exception {
        assertNoFailures(searchResponse);
                    + "        {\n"
                "{\n"
        assertThat(searchResponse.getHits().getHits().length, equalTo(2));
                    .field("field1", "value1")
                    .startObject()
                    + "    } \n"
                        + "                  },\n"
    public void testLeakingSortValues() throws Exception {
                    .order(SortOrder.ASC)
    }
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
                    .endArray()
                    .field("phoneid", "p6")
                    .startObject()
                    .sortMode(SortMode.AVG)
                    .endObject()
            .addSort(
        assertDocumentCount("test", 3);
            .get();
                    .field("field1", 4)
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("1"));
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("3"));
import org.opensearch.action.DocWriteResponse;
                    .startArray("nested1")
            )
                    + "            {\"username\": \"baz\", \"id\": 4},\n"
                        .field("type", "boolean")
            )
                    .endObject()
        indexRandomForConcurrentSearch("test");
                    + "          \"user\": [\n"
                    .endObject()
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("3"));
                    )
                    .setNestedFilter(QueryBuilders.termQuery("parent.child.filter", true))
                    .field("field", "value")
        refresh();
                        + "            }\n"
        clusterStatsResponse = client().admin().cluster().prepareClusterStats().get();
        assertThat(searchResponse.getHits().getHits()[0].getSortValues()[0].toString(), equalTo("5"));
                    + "          ]\n"
        assertThat(searchResponse.getHits().getHits()[2].getId(), equalTo("3"));
                    .startObject()
                    .endArray()
                                    .setNestedSort(new NestedSortBuilder("acl.operation.user"))
                        new NestedSortBuilder("acl").setNestedSort(
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
                    .endObject()
import org.opensearch.action.get.GetResponse;
                    + "  ]\n"
    @ParametersFactory
                jsonBuilder().startObject()
            )
                    + "        },\n"
                    .endObject()
                    .endObject()
                    .endArray()
                )
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
                    .field("type", "text")
                    + "          \"name\": \"execute\",\n"
        // search for something that matches the nested doc, and see that we don't find the nested doc
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
/*
import org.opensearch.action.search.SearchResponse;
                jsonBuilder().startObject()
                    .endObject()
                "{\n"
                    + "          \"name\": \"read\",\n"
                    ScoreMode.Avg
                nestedQuery(
            )
                    + "        {\n"
                    .endArray()
        // No nested mapping yet, there shouldn't be anything in the fixed bit set cache
            .get();
                        .must(nestedQuery("nested1.nested2", termQuery("nested1.nested2.field2", "5"), ScoreMode.Avg)),
                    .endObject()
                    + "  \"nested1\": [\n"
                    + "  ]\n"
            )
                    + "}",
                    .endObject()
        assertThat(searchResponse.getHits().getHits()[2].getSortValues()[0].toString(), equalTo("3"));
                    .order(SortOrder.ASC)
        assertThat(searchResponse.getHits().getHits()[0].getSortValues()[0].toString(), equalTo("1"));
                        .endObject()
            .get();
                        .endObject()
                    .startObject()
        assertNoFailures(searchResponse);
        assertThat(searchResponse.getHits().getHits()[1].getSortValues()[0].toString(), equalTo("3"));
                        + "              \"nested2\": {\n"
        // Check if closest nested type is resolved
            .setQuery(
import org.opensearch.cluster.health.ClusterHealthStatus;
import static org.opensearch.index.query.QueryBuilders.nestedQuery;
        assertAcked(
        assertAcked(prepareCreate("test").setMapping("nested1", "type=nested"));
                jsonBuilder().startObject()
                    + "        }\n"
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
            .get();
                    .startArray("child")
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
                SortBuilders.fieldSort("acl.operation.user.id")
                    .field("n_field1", "n_value1_1")
        assertThat(searchResponse.getHits().getHits()[0].getSortValues()[0].toString(), equalTo("1"));
                    .endObject()
                    .field("field1", "value2")
            .addSort(
            )
                    + "            {\"username\": \"foo\", \"id\": 5}\n"
                    .endObject()
                    + "          \"user\": [\n"
                    .field("filter", false)
 */
            .get();
        assertThat(searchResponse.getHits().getHits()[1].getSortValues()[0].toString(), equalTo("2"));
                    .field("field1", "value1")
        if (randomBoolean()) {
                SortBuilders.fieldSort("parent.child.child_values")
            .setQuery(matchAllQuery())
            .get();
                    .setNestedSort(
                    .startArray("nested1")
        // access id = 1, read, max value, asc, should use grault and quxx
                        .field("type", "nested")
                                    .setNestedSort(new NestedSortBuilder("acl.operation.user"))
                        .endObject()
 * The OpenSearch Contributors require contributions made to
        assertThat(searchResponse.getHits().getHits()[0].getSortValues()[0].toString(), equalTo("2"));
    // This IncludeNestedDocsQuery also needs to be aware of the filter from alias
        assertHitCount(searchResponse, 2);
                    .endArray()
        assertNoFailures(searchResponse);
                        .must(nestedQuery("nested1.nested2", termQuery("nested1.nested2.field2", "5"), ScoreMode.Avg)),
                    .startObject("properties")
                    + "            {\"username\": \"quxx\", \"id\": 2},\n"
                jsonBuilder().startObject()
            .get();
        assertThat(searchResponse.getHits().getHits()[1].getSortValues()[0].toString(), equalTo("2"));
        );
                                )
                boolQuery().must(matchAllQuery())
                    .endObject()
                    .endArray()
                    .field("stationid", "s2")
                            )
            prepareCreate("test").setMapping(
            .setQuery(
        assertThat(searchResponse.getHits().getHits().length, equalTo(2));
        if (loadFixedBitSeLazily) {
            .get();
                    .field("filter", true)
        assertNoFailures(searchResponse);
            .get();
            )
                        .endObject()
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(0L));
                "{\n"
                    .endObject()
                    + "            }\n"
                    .startObject()
                    .sortMode(SortMode.AVG)
                    .field("stationid", "s5")
                    + "      \"type\": \"nested\",\n"
            .addSort(
            prepareCreate("test").setSettings(Settings.builder().put(indexSettings()).put("index.refresh_interval", -1).build())
            .get();
                        .startObject("field1")
                    + "            {\"username\": \"quxx\", \"id\": 2}\n"
                    jsonBuilder().startObject()
                    .field("stationid", "s4")
                    .order(SortOrder.ASC)
                    + "      \"operation\": [\n"
        assertDocumentCount("test", 6);
            .setId("2")
                    + "  \"acl\": [\n"
                    .field("phoneid", "p1")
                    .order(SortOrder.ASC)
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
                    .setNestedPath("parent.child")
import org.opensearch.search.sort.SortBuilders;
        client().admin().indices().prepareAliases().addAlias("test", "alias1", QueryBuilders.termQuery("field1", "value1")).get();
                    + "          \"user\": [\n"
                    .endArray()
        // With nested filter
                    .field("phoneid", "p4")
                    .startArray("workstations")
        client().prepareIndex("test")
                    .sortMode(SortMode.SUM)
            .setQuery(matchAllQuery())
            .setQuery(
                    .endObject()
                nestedQuery(
            .setId("3")
                    .order(SortOrder.ASC)
            );
                    + "      \"properties\": {\n"
                                        QueryBuilders.termsQuery("acl.operation.user.username", "grault", "foo")
        assertThat(explanation.getValue(), equalTo(searchResponse.getHits().getHits()[0].getScore()));
        indexRandomForConcurrentSearch("test");
            SearchResponse searchResponse = client().prepareSearch("test")
        waitForRelocation(ClusterHealthStatus.GREEN);
                    .field("stationid", "s2")
                    .endObject()
            )
        refresh();
        // sum: 7
                    .setNestedFilter(nestedQuery("users.workstations", termQuery("users.workstations.stationid", "s5"), ScoreMode.Avg))
                    + "        }\n"
                    .field("last", "lname4")
                    + "        },\n"
                    .field("n_field2", "n_value2_2")
                    .startObject()
                    .startObject()
                    .setNestedPath("parent.child")
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            .get();
                    + "            {\"username\": \"bar\", \"id\": 3}\n"
                jsonBuilder().startObject()
        ClusterStatsResponse clusterStatsResponse = client().admin().cluster().prepareClusterStats().get();
            .setQuery(termQuery("_id", 2))
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
                    + "    },\n"
                    + "      \"access_id\": 2,\n"
                    .setNestedSort(
                    + "    }\n"
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("2"));
                nestedQuery(
        assertThat(searchResponse.getHits().getHits()[2].getId(), equalTo("1"));
                    .field("n_field2", "n_value2_1")
                    + "        {\n"
                    .setNestedSort(
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(0L));
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("2"));
                    .startObject()
    }
                nestedQuery(
                .get();
                    .field("child_values", 2L)
                    .field("grand_parent_values", 2L)
                        new NestedSortBuilder("parent").setFilter(QueryBuilders.termQuery("parent.filter", false))
                    + "    {\n"
                    .field("field1", 2)
                    .endObject()
    }
/*
                    .startObject("properties")
                    .startArray("nested1")
        searchResponse = client().prepareSearch("test").setQuery(termQuery("n_field1", "n_value1_1")).get();
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("1"));
                    .field("child_values", 3L)
    }
                        .startObject("properties")
                    .startObject()
                SortBuilders.fieldSort("users.first")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
                    .startObject()
            .setQuery(matchAllQuery())
                    .endObject()
                    .startArray("workstations")
                            new NestedSortBuilder("acl.operation").setFilter(QueryBuilders.termQuery("acl.operation.name", "execute"))
            .get();
        searchResponse = client().prepareSearch()
            .addSort(SortBuilders.fieldSort("nested1.field1").order(SortOrder.DESC).setNestedPath("nested1"))
        SearchResponse searchResponse = client().prepareSearch("test")
                    .field("last", "lname5")
                    + "        {\n"
                    .endObject()
                    .field("phoneid", "p3")
                    .startObject()
                    .field("filter", false)
                    .field("field1", 1)
    public void testNestedSortingWithNestedFilterAsFilter() throws Exception {
                    .field("filter", true)
                    .startArray("users")
        searchResponse = client().prepareSearch("test")
                    .field("field1", 3)
            )
import org.apache.lucene.search.join.ScoreMode;
        );
            .setId("2")
        // sum: 11
        assertThat(searchResponse.getHits().getHits()[0].getSortValues()[0].toString(), equalTo("1"));
        assertHitCount(searchResponse, 3);
                        .startObject("properties")
                        .startObject("field2")
        assertThat(stats.getIndex(index).getPrimaries().docs.getCount(), is(numdocs));
                        + "                    \"type\": \"keyword\"\n"
                    .field("field1", 5)
                    .field("type", "nested")
                    + "          \"nested2_keyword\": \"nested2_bar\",\n"
    public void testDeleteNestedDocsWithAlias() throws Exception {
                    )
            .addSort(
    }
                SortBuilders.fieldSort("nested1.field1")
        assertEquals(DocWriteResponse.Result.DELETED, deleteResponse.getResult());
                            .setNestedSort(new NestedSortBuilder("parent.child"))
                    .field("type", "nested")
                    .endObject()
                    .order(SortOrder.DESC)
                    ScoreMode.Avg
        );
                    .endObject()
                    boolQuery().must(termQuery("nested1.field1", "1"))
            .setSource(
                    .endArray()
        assertThat(clusterStatsResponse.getIndicesStats().getSegments().getBitsetMemoryInBytes(), equalTo(0L));
                    .endObject()
            .setId("1")
                    .order(SortOrder.ASC)
            .setQuery(matchAllQuery())
                        new NestedSortBuilder("acl").setNestedSort(
 * this file be licensed under the Apache-2.0 license or a
                    .field("field1", "value1")
                    + "            {\"username\": \"quxx\", \"id\": 2}\n"
        assertThat(searchResponse.getHits().getHits()[1].getSortValues()[0].toString(), equalTo("7"));
                    .field("parent_values", 4L)
                    .endObject()
            .get();
            .setSource(
                    .endArray()
                    .field("filter", false)
 * SPDX-License-Identifier: Apache-2.0
        assertThat(searchResponse.getHits().getHits()[1].getSortValues()[0].toString(), equalTo("2"));
        assertNoFailures(stats);
                    .startObject()
            .setSource(
                    .field("n_field2", "n_value2_2")
            .get();
                    .field("last", "lname2")
            .setId("2")
                    + "  \"properties\": {\n"
                    .field("field2", "2")
        assertAcked(
 *
                    .field("field2", "5")
                    .field("n_field2", "n_value2_1")
                        .endObject()
                    .endObject()
            .setId("1")
                    .endArray()
                    .field("field1", 3)
        SearchResponse searchResponse = searchRequestBuilder.get();
                    .field("parent_values", 2L)
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
                    )
                    .field("first", "fname2")
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
                    .setNestedPath("nested1")
                    .order(SortOrder.DESC)
            )
                .setMapping(
        refresh();
                    .startObject()
        IndexResponse indexResponse2 = client().prepareIndex("test")
            )
        refresh();
                    + "          \"sortVal\": 1\n"
                    .field("field1", 1)
        searchResponse = client().prepareSearch("test")
        searchResponse = searchRequestBuilder.get();
                    .field("type", "long")
            .setId("1")
                jsonBuilder().startObject()
        assertThat(searchResponse.getHits().getHits()[2].getSortValues()[0].toString(), equalTo("3"));
                    .field("field2", true)
                    .startObject()
                    + "  \"acl\": [\n"
            .setSource(
            )
                        .field("type", "long")
        searchResponse = client().prepareSearch("test").setQuery(termQuery("n_field1", "n_value1_1")).get();
                    .field("stationid", "s6")
        assertNoFailures(searchResponse);
                    .endArray()
            )
                jsonBuilder().startObject()
                    .endObject()
                    .field("n_field1", "n_value1_2")
                SortBuilders.fieldSort("nested1.nested2.sortVal")
    public void testSortNestedWithNestedFilter() throws Exception {
                    + "        }\n"
        GetResponse getResponse = client().prepareGet("test", "1").get();
                    .startObject()
        assertThat(searchResponse.getHits().getHits()[0].getSortValues()[0].toString(), equalTo("bar"));
            .setSource(
    // Issue #9305
        assertThat(searchResponse.getHits().getHits()[2].getId(), equalTo("3"));
            .setSource(
        // access id = 1, read, min value, asc, should now use bar and foo
                    .order(SortOrder.ASC)
        refresh();
                    .endObject()
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("2"));
            )
                .setMapping(
                                .setNestedSort(
            .get();
                    .startObject("properties")
                    .field("stationid", "s6")
                    .startObject()
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("1"));
            )
                    .sortMode(SortMode.SUM)
                    .endObject()
        assertThat(searchResponse.getHits().getHits()[0].getSortValues()[0].toString(), equalTo("foo"));
                    .startArray("workstations")
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("1"));
        assertThat(searchResponse.getHits().getAt(0).getSortValues()[1].toString(), equalTo("fname1"));
        // index simple data
                    .endObject()
                    .endObject()
                    + "    },\n"
            .get();
                    .startObject()
        assertThat(searchResponse.getHits().getHits()[2].getId(), equalTo("3"));
        SearchResponse searchResponse = client().prepareSearch("test")
                    .setNestedFilter(QueryBuilders.termQuery("parent.child.filter", true))
                    .endObject()
                        .endObject()
                    .endArray()
                    + "      }\n"
        assertHitCount(searchResponse, 2);
                    .endObject()
            .get();
            )
                    .endObject()
        refresh();
                SortBuilders.fieldSort("nested1.field1")
                    .endObject()
        assertThat(searchResponse.getHits().getHits()[2].getSortValues()[0].toString(), equalTo("11"));
                    .startObject()
        assertThat(searchResponse.getHits().getHits()[1].getSortValues()[0].toString(), equalTo("2"));
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("1"));
                    .startObject()
                    + "        {\n"
            .setSource(
                    ScoreMode.Avg
            )
                jsonBuilder().startObject()
            )
            .addSort(SortBuilders.fieldSort("parent.child.child_values").setNestedPath("parent.child").order(SortOrder.ASC))
                        + "              }\n"
                    .field("first", "fname1")
            )
                        + "            \"type\": \"nested\",\n"
                    .field("filter", false)
                    .endObject()
                    + "        },\n"
                    .field("phoneid", "p2")
        client().prepareIndex("test").setId("4").setSource(builder).get();
    }
        // Doc with missing nested docs if nested filter is used
        SearchResponse searchResponse = client().prepareSearch("test")
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("2"));
                    .field("field1", 4)
            )
        );
                jsonBuilder().startObject()
            )
                    .endObject()
        assertThat(searchResponse.getHits().getHits()[1].getSortValues()[0].toString(), equalTo("4"));
        assertThat(searchResponse.getHits().getHits()[2].getId(), equalTo("1"));
        );
package org.opensearch.search.nested;
                    + "        \"operation\": {\n"
        // Without nested filter
        // Sort mode: avg
                    .startArray("parent")
            .setQuery(nestedQuery("nested1", termQuery("nested1.n_field1", "n_value1_1"), ScoreMode.Avg))
                SortBuilders.fieldSort("parent.child.child_values")
                    + "          ]\n"
/*
                )
            prepareCreate("test").setMapping(
                    + "      \"nested2\": [\n"
                    + "    {\n"
        assertThat(clusterStatsResponse.getIndicesStats().getSegments().getBitsetMemoryInBytes(), greaterThan(0L));
                    .startObject()
                    .field("phoneid", "p5")
                    + "      \"operation\": [\n"
        searchResponse = client().prepareSearch("test").setQuery(matchAllQuery()).get();
                            ScoreMode.Avg
        assertThat(searchResponse.getHits().getHits()[0].getSortValues()[0].toString(), equalTo("2"));
                    .endObject()
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
            settingsBuilder.put("index.load_fixed_bitset_filters_eagerly", false);
                        )
        );
    public void testSimpleNestedSortingWithNestedFilterMissing() throws Exception {
            .get();
                    .startObject()
                    .startObject()
                    boolQuery().must(termQuery("nested1.n_field1", "n_value1_1")).must(termQuery("nested1.n_field2", "n_value2_1")),
        ensureGreen();
        assertNoFailures(searchResponse);
import static org.opensearch.index.query.QueryBuilders.termQuery;
                        .must(nestedQuery("nested1.nested2", termQuery("nested1.nested2.field2", "2"), ScoreMode.Avg)),
            .addSort(
            )
                    .field("field2", true)
                    .field("n_field2", "n_value2_1")
                    .endArray()
            .setId("3")
                    .startObject()
        SearchResponse searchResponse = client().prepareSearch()
                    .field("type", "nested")
                    + "    {\n"
                        )
                )
                    .endObject()
                    .field("field2", false)
        );
            .field("field1", "value1")
        assertThat(clusterStatsResponse.getIndicesStats().getSegments().getBitsetMemoryInBytes(), equalTo(0L));
                    .field("value", 3L)
                nestedQuery(
                    + "    {\n"
                    .endArray()
        refresh();
                    .field("n_field1", "n_value1_2")
            .get();
        SearchResponse searchResponse = client().prepareSearch()
        waitForRelocation(ClusterHealthStatus.GREEN);
        IndexResponse indexResponse1 = client().prepareIndex("test")
        boolean loadFixedBitSeLazily = randomBoolean();
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
}
                    .order(SortOrder.ASC)
                    boolQuery().must(termQuery("nested1.field1", "1"))
 */
            .setQuery(matchAllQuery())
        client().prepareIndex("test")
        assertHitCount(searchResponse, 3);
 * this work for additional information regarding copyright
                    .endObject()
                    .endObject()
        assertHitCount(searchResponse, 3);
                nestedQuery(
                SortBuilders.fieldSort("parent.child.child_values")
                    .field("type", "long")
            )
        XContentBuilder builder = jsonBuilder().startObject()
        assertAcked(client().admin().indices().prepareDelete("test"));
                    .startObject()
                    .sortMode(SortMode.AVG)
        searchRequestBuilder = client().prepareSearch("test")
                    .field("type", "nested")
                        + "            \"properties\": {\n"
            )
                    .endObject()
        searchResponse = client().prepareSearch("test")
                    .field("child_values", 1L)
                    .endArray()
                    + "        {\n"
                    .startArray("nested1")
                    .startArray("nested2")
                    + "    \"acl\": {\n"
                        + "      }\n"
                                    new NestedSortBuilder("acl.operation.user").setFilter(
                    + "}",
                    + "          ]\n"
                    + "          \"user\": [\n"
        searchResponse = client().prepareSearch()
            .setId("1")
        ensureSearchable("test");
        IndicesStatsResponse stats = admin().indices().prepareStats(index).clear().setDocs(true).get();
        assertAcked(
                    .setNestedFilter(QueryBuilders.termQuery("parent.child.filter", true))
        Settings.Builder settingsBuilder = Settings.builder().put(indexSettings()).put("index.refresh_interval", -1);
                    .field("n_field1", "n_value1")
                            new NestedSortBuilder("nested1.nested2").setFilter(termQuery("nested1.nested2.nested2_keyword", "nested2_bar"))
            .addSort(
                    .endObject()
                    "nested1",
                    .sortMode(SortMode.SUM)
        client().prepareIndex("test")
import org.opensearch.action.index.IndexResponse;
                    .field("stationid", "s5")
                    .field("type", "keyword")
                    + "      \"access_id\": 1,\n"
                    ScoreMode.Avg
 * license agreements. See the NOTICE file distributed with
        assertThat(searchResponse.getHits().getHits()[1].getSortValues()[0].toString(), equalTo("5"));
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("2"));
            )
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        searchResponse = client().prepareSearch()
        // check the numDocs
        searchResponse = client().prepareSearch()
        searchResponse = client().prepareSearch()
            .get();
                    .endObject()
                    .field("grand_parent_values", 1L)
            .setQuery(
                    .endObject()
                    + "            {\"username\": \"quxx\", \"id\": 2},\n"
                    .field("filter", false)
 * Licensed to Elasticsearch under one or more contributor
                        .must(nestedQuery("nested1.nested2", termQuery("nested1.nested2.field2", "4"), ScoreMode.Avg)),
                    .endObject()
                    "nested1",
        ensureGreen();
        assertThat(searchResponse.getHits().getHits()[2].getSortValues()[0].toString(), equalTo("10"));
                jsonBuilder().startObject()
        assertThat(searchResponse.getHits().getHits()[1].getSortValues()[0].toString(), equalTo("2"));
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("2"));
                    "nested1",
                    .field("field1", "1")
        assertHitCount(searchResponse, 3);
import org.opensearch.core.xcontent.XContentBuilder;
            .setQuery(QueryBuilders.matchAllQuery())
            .get();
                    + "      \"access_id\": 1,\n"
                    .startObject()
        assertHitCount(searchResponse, 3);
                    .startObject()
        assertThat(searchResponse.getHits().getHits()[2].getId(), equalTo("2"));
        searchResponse = client().prepareSearch("test")
            .setSource(
                    .field("field1", 1)
        assertAcked(
        refresh();
            .setExplain(true)
            .addSort(
                    .endObject()
                            new NestedSortBuilder("acl.operation").setFilter(QueryBuilders.termQuery("acl.operation.name", "execute"))
        assertHitCount(searchResponse, 3);
                    + "          \"user\": [\n"
                    .field("type", "text")
                    + "  }\n"
                    .mustNot(
                    "nested1",
        assertThat(searchResponse.getHits().getHits()[0].getSortValues()[0].toString(), equalTo("-3"));
        SearchResponse searchResponse = client().prepareSearch("test")
                    .field("filter", false)
                    .startArray("child")
                    + "      \"access_id\": 3,\n"
                jsonBuilder().startObject()
import java.util.Arrays;
                    + "}"
            .get();
                    .startObject()
        assertThat(searchResponse.getHits().getAt(1).getSortValues()[0].toString(), equalTo("fname1"));
                    .endObject()
                    "nested1",
                    .startObject("properties")
                    .startObject()
    /*
                )
                        .field("type", "nested")
                    + "          ]\n"
                    .missing("_first")
        ensureGreen();
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
                    .startObject()
        assertHitCount(searchResponse, 3);
                    .sortMode(SortMode.MAX)
                    .startArray("child")
                    + "}",
                        + "                \"type\": \"nested\",\n"
                jsonBuilder().startObject()
                SortBuilders.fieldSort("parent.child.child_values")
        );
                    .field("phoneid", "p2")
        assertThat(searchResponse.getHits().getHits()[1].getSortValues()[0].toString(), equalTo("foo"));
    }
        searchResponse = client().prepareSearch("test")
                SortBuilders.fieldSort("acl.operation.user.username")
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("2"));
                    .startArray("nested1")
                XContentFactory.jsonBuilder()
            .setQuery(QueryBuilders.matchAllQuery())
                SortBuilders.fieldSort("acl.operation.user.username")
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("2"));
                    .startObject()
                        .endObject()
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("2"));
                    "nested1",
 * GitHub history for details.
            .get();
            .get();
            .get();
                    .endObject()
        searchResponse = client().prepareSearch("test")
        assertThat(searchResponse.getHits().getHits()[0].getSortValues()[0].toString(), equalTo("3"));
                    .startObject()
                        .startObject("properties")
                    .endObject()
                    .field("n_field2", "n_value2_1")
                    .startArray("users")
        assertThat(searchResponse.getHits().getHits()[0].getSortValues()[0].toString(), equalTo("1"));
            .setSource(
            .setSource(
            .get();
        assertNoFailures(searchResponse);
                        .must(nestedQuery("nested1.nested2", termQuery("nested1.nested2.field2", "3"), ScoreMode.Avg)),
            .setQuery(matchAllQuery())
                    + "          ]\n"
        ensureGreen();
                        .startObject("nested1")
                    .endObject()
                    )
                    .field("child_values", 3L)
            )
        assertThat(searchResponse.getHits().getHits()[1].getSortValues()[0].toString(), equalTo("2"));
        searchResponse = client().prepareSearch("test")
        // check with type prefix
                    + "            \"user\": {\n"
                    ScoreMode.Avg
                    + "                \"id\": {\"type\": \"integer\"}\n"
                    .field("child_values", 1L)
            .setSource(
                    + "  \"nested1\": [\n"
            )
    public void testExplainWithSingleDoc() throws Exception {
 * specific language governing permissions and limitations
            );
                    .endObject()
            )
    * Tests the explain output for single doc. Concurrent search with only slice 1 is tested
                    .field("stationid", "s3")
            prepareCreate("test").setMapping(
            .setSource(
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(0L));
            .setQuery(matchAllQuery())
        client().prepareIndex("test").setId("6").setSource(builder).get();
                    .field("n_field1", "n_value1_1")
        assertThat(searchResponse.getHits().getHits()[0].getSortValues()[0].toString(), equalTo("1"));
                    + "            {\"username\": \"grault\", \"id\": 1}\n"
                    .field("filter", false)
            .setQuery(matchAllQuery())
                    .endObject()
                    .endObject()
            .addSort(
                    + "            {\"username\": \"foo\", \"id\": 5}\n"
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
            .setQuery(QueryBuilders.matchAllQuery())
                    + "        \"access_id\": {\"type\": \"keyword\"},\n"
                    + "    {\n"
                    .field("n_field1", "n_value1_2")
                    .endObject()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
                MediaTypeRegistry.JSON
            prepareCreate("test").setSettings(Settings.builder().put("number_of_shards", 1))
            assertNoFailures(searchResponse);
            .setRefreshPolicy(IMMEDIATE)
                    .field("field2", "6")
                    .field("n_field1", "n_value1_1")
                    .startObject("child")
                    .startObject()
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
        indexRandomForConcurrentSearch("test");
                    .setNestedPath("parent.child")
                MediaTypeRegistry.JSON
            .setQuery(nestedQuery("nested1", termQuery("nested1.field1", "1"), ScoreMode.Avg))
                    .startObject()
        client().prepareIndex("test").setId("5").setSource(builder).get();
                    boolQuery().must(termQuery("nested1.field1", "1"))
                        .startObject("field1")
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(0L));
        assertHitCount(searchResponse, 2);
        assertTrue(indexResponse1.getShardInfo().getSuccessful() > 0);
                    .startArray("workstations")
                    .setNestedFilter(QueryBuilders.termQuery("parent.child.filter", true))
                    .sortMode(SortMode.MIN)
        return Arrays.asList(
                    + "      \"operation\": [\n"
                    + "        {\n"
            .setQuery(matchAllQuery())
        assertNoFailures(searchResponse);
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
        assertHitCount(searchResponse, 3);
            .get();
                )
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("2"));
                    + "            \"name\": {\"type\": \"keyword\"},\n"
                    + "      ]\n"
            .get();
                    + "            {\"username\": \"bar\", \"id\": 3}\n"
                )
        searchResponse = client().prepareSearch()
            .addSort(SortBuilders.fieldSort("nested1.field1").order(SortOrder.ASC).setNestedPath("nested1"))
                    .endObject()
        assertThat(searchResponse.getHits().getHits()[0].getSortValues()[0].toString(), equalTo("11"));
                    + "        {\n"
        ensureGreen();
        assertThat(searchResponse.getHits().getHits()[0].getSortValues()[0].toString(), equalTo("1"));
                    .startObject("stationid")
        GetResponse getResponse = client().prepareGet("test", "1").get();
            )
        assertAcked(
            )
import org.opensearch.search.sort.SortOrder;
                jsonBuilder().startObject()
                nestedQuery(
                jsonBuilder().startObject()
                    + "          \"user\": [\n"
                    + "          ]\n"
        // check delete, so all is gone...
import org.opensearch.core.xcontent.MediaTypeRegistry;
                    .startObject()
import org.opensearch.common.settings.Settings;
            searchRequestBuilder.setScroll("10m");
                    .field("field2", true)
                    .endObject()
                    .field("type", "nested")
        clusterStatsResponse = client().admin().cluster().prepareClusterStats().get();
                        + "                  }\n"
            .setSource(
            .get();
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("2"));
        searchResponse = client().prepareSearch()
                    .endObject()
        // add another doc, one that would match if it was not nested...
        assertThat(searchResponse.getHits().getHits()[2].getId(), equalTo("3"));
                    .startArray("child")
        assertAcked(client().admin().indices().preparePutMapping("test").setSource("array1", "type=nested"));
            )
    * case in concurrent search, refer {@link SimpleNestedExplainIT}
            .setSource(
                    + "        }\n"
                    .setNestedPath("parent.child")
            searchRequestBuilder.setScroll("10m");
                        .endObject()
        searchResponse = client().prepareSearch()
                    .startObject()
        refresh();
                    .field("field1", 2)
            .get();
                    + "    }\n"
    public static Collection<Object[]> parameters() {
                        + "                    \"type\": \"integer\"\n"
                    + "        {\n"
        searchResponse = client().prepareSearch()
                    .endObject()
            prepareCreate("test").setSettings(Settings.builder().put(indexSettings()).put("index.refresh_interval", -1))
                    + "        {\n"
                jsonBuilder().startObject()
        assertThat(getResponse.isExists(), equalTo(true));
                    .startObject()
                        + "        \"dynamic\": \"strict\",\n"
            .setQuery(QueryBuilders.matchAllQuery())
                    .endObject()
        // sum: 2
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("3"));
                    + "          \"name\": \"read\",\n"
            .setSource(
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("1")); // missing first
                    .field("type", "text")
                    .field("child_values", 1L)
            .setQuery(nestedQuery("nested1", termQuery("nested1.n_field1", "n_value1_1"), ScoreMode.Avg))
        // do some multi nested queries
                    .order(SortOrder.DESC)
        refresh();
        // execute, by grault or foo, by username, sort missing last (default)
                    .startObject()
                    .endArray()
                                )
            .get();
                    + "          \"name\": \"write\",\n"
                    .startArray("child")
            )
                    .startObject()
 */
            )
                        .startObject("nested1")
        assertHitCount(searchResponse, 3);
    public void testCheckFixedBitSetCache() throws Exception {
        }
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
            .setId("2")
                    .startObject()
                    .setNestedFilter(termQuery("nested1.field2", true))
                    .startObject("child_obj")
                    .field("field2", true)
                    .endObject()
 * software distributed under the License is distributed on an
        refresh();
                    .field("field1", 4)
import static org.hamcrest.Matchers.notNullValue;
 * You may obtain a copy of the License at
                    .startObject()
                SortBuilders.fieldSort("parent.child.child_values")
                    .sortMode(SortMode.MAX)
            .endObject();
    private void assertDocumentCount(String index, long numdocs) {
        assertHitCount(searchResponse, 1);
            .get();
                    .startObject("properties")
                    .field("value", 1L)
                    .field("field1", 1)
                    boolQuery().must(termQuery("nested1.field1", "1"))
                    + "        }\n"
 * ownership. Elasticsearch licenses this file to you under
                    + "                \"username\": {\"type\": \"keyword\"},\n"
                        + "                }\n"
            .setSource(
                    .setNestedPath("parent.child")
        assertThat(searchResponse.getHits().getHits()[0].getSortValues()[0].toString(), equalTo("1"));
                    .field("phoneid", "p6")
                    .missing(10)
                    .field("n_field1", "n_value1_2")
            .addSort(
        assertThat(searchResponse.getHits().getHits()[2].getSortValues()[0].toString(), equalTo("2"));
                    ScoreMode.Avg
                    .endObject()
                    .field("child_values", 4L)
                    .endObject()
        assertThat(searchResponse.getHits().getHits()[2].getSortValues()[0].toString(), equalTo("3"));
            .get();
                    .setNestedFilter(QueryBuilders.termQuery("parent.filter", false))
                    + "        }\n"
        assertThat(searchResponse.getHits().getHits()[2].getId(), equalTo("3"));
        client().prepareIndex("test")
                    .missing(10)
                    .endObject()
                    .startObject()
                        .endObject()
        // filter
                        .startObject("properties")
        client().prepareIndex("test").setId("1").setSource("field", "value").get();
        assertHitCount(searchResponse, 3);
                )
            )
                    .endObject()
            assertThat(clusterStatsResponse.getIndicesStats().getSegments().getBitsetMemoryInBytes(), equalTo(0L));
                    .field("grand_parent_values", 3L)
 * KIND, either express or implied.  See the License for the
            .get();
        client().prepareIndex("test")
                    .endObject()
                    .field("filter", true)
        assertThat(searchResponse.getHits().getHits()[0].getSortValues()[0].toString(), equalTo("10"));
    }
                    .startObject()
                    )
                    .field("last", "lname1")
        indexRandomForConcurrentSearch("test");
                "{\n"
                    .field("n_field1", "n_value1_1")
                        .startObject("properties")
                "{\n"
            .setId("2")
                    + "          \"name\": \"write\",\n"
        assertThat(searchResponse.getHits().getHits()[2].getId(), equalTo("1"));
                    .field("filter", false)
                    )
                jsonBuilder().startObject()
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
                    .field("n_field2", "n_value2_2")
            )
            )
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
                        new NestedSortBuilder("nested1").setNestedSort(
                                    new NestedSortBuilder("acl.operation.user").setFilter(
                    .order(SortOrder.DESC)
                                new NestedSortBuilder("acl.operation").setFilter(QueryBuilders.termQuery("acl.operation.name", "read"))
                    .endObject()
                        + "                  \"sortVal\": {\n"
                        + "          \"nested1\": {\n"
                    "{\n"
                    .field("filter", false)
        assertThat(searchResponse.getHits().getHits()[2].getSortValues()[0].toString(), equalTo("6"));
        waitForRelocation(ClusterHealthStatus.GREEN);
                    .endArray()
                    .order(SortOrder.ASC)
            .setQuery(nestedQuery("nested1", termQuery("nested1.n_field1", "n_value1"), ScoreMode.Total))
                    .field("field1", 3)
            .setId("2")
                    .startObject()
                    .startObject()
                    + "              \"type\": \"nested\",\n"
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("1"));
        assertThat(searchResponse.getHits().getHits()[1].getSortValues()[0].toString(), equalTo("quxx"));
                .setMapping(
        assertNoFailures(searchResponse);
                    .startObject("users")
                        .endObject()
                    + "        }\n"
                    .field("phoneid", "p5")
        client().prepareIndex("test")
    }
        client().prepareIndex("test")
                    .endObject()
                    jsonBuilder().startObject()
                    .endArray()
                    .endObject()
    public SimpleNestedIT(Settings staticSettings) {
                    .field("stationid", "s4")
                    .startArray("nested2")
                        .startObject("field1")
                            .setNestedSort(
                jsonBuilder().startObject()
                    + "    {\n"
                    .setNestedPath("parent.child")
            .addSort(
        ensureSearchable("test");
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("2"));
                    .startObject()
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
        assertAcked(
    * here as call to indexRandomForMultipleSlices has implications on the range of child docs
                    .startArray("workstations")
        // Nested path should be automatically detected, expect same results as above search request
        assertThat(searchResponse.getHits().getHits()[1].getSortValues()[0].toString(), equalTo("4"));
            .get();
            .setQuery(
        searchResponse = client().prepareSearch("test")
                    .startObject("child_obj")
        refresh();
            .setQuery(
import static org.hamcrest.Matchers.greaterThan;
                    .endArray()
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("1"));
        assertThat(searchResponse.getHits().getHits()[1].getSortValues()[0].toString(), equalTo("2"));
                    .field("parent_values", 1L)
                    .field("phoneid", "p4")
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
        assertThat(searchResponse.getHits().getHits()[1].getSortValues()[0].toString(), equalTo("1"));
                    + "        {\n"
                    .endObject()
            .get();
            .get();
                    .endObject()
                    .field("value", 2L)
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
                    .order(SortOrder.ASC)
                    + "          \"name\": \"execute\",\n"
            .setSource(
                    .startObject()
        indexRandomForConcurrentSearch("test");
            )
                    + "          ]\n"
        searchResponse = client().prepareSearch("test")
 *
                    .field("field1", 4)
                    .endArray()
            .addSort(
                    .endObject()
                    .setNestedPath("nested1")
            )
        assertThat(searchResponse.getHits().getHits()[2].getSortValues()[0].toString(), equalTo("3"));
                    boolQuery().must(termQuery("nested1.field1", "4"))
 * Unless required by applicable law or agreed to in writing,
                    + "            {\"username\": \"grault\", \"id\": 1}\n"
        assertDocumentCount("test", 7);
                    .startObject("officelocation")
                    boolQuery().must(termQuery("nested1.field1", "4"))
            .get();
                    + " ]\n"
        client().prepareIndex("test").setId("0").setSource("field", "value").get();
            )
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
                    .field("filter", true)
        searchResponse = client().prepareSearch("test")
        SearchRequestBuilder searchRequestBuilder = client().prepareSearch("test")
                            .setNestedSort(
        assertHitCount(searchResponse, 3);
                    .field("phoneid", "p3")
                    .endObject()
                    .endArray()
                        new NestedSortBuilder("acl").setFilter(QueryBuilders.termQuery("acl.access_id", "1"))
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(0L));
            .setId("2")
                    .endObject()
        assertThat(searchResponse.getHits().getHits()[2].getSortValues()[0].toString(), equalTo("3"));
                    .endObject()
            .get();
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                    .startArray("nested1")
            .get();
                    .endArray()
    public void testSimpleNested() throws Exception {
            .get();
        searchResponse = client().prepareSearch()
            prepareCreate("test").setMapping(
        assertHitCount(searchResponse, 2);
            )
                    + "          \"name\": \"read\",\n"
                    .setNestedPath("parent.child")
                        nestedQuery(
                    .startObject()
                    + "            {\"username\": \"grault\", \"id\": 1}\n"
                    + "          \"name\": \"write\",\n"
                        + "        }\n"
                    .setNestedSort(
                    .endObject()
            clusterStatsResponse = client().admin().cluster().prepareClusterStats().get();
            .addSort(
import static org.hamcrest.Matchers.equalTo;
        assertDocumentCount("test", 3);
                    .field("parent_values", 3L)
                    + "            {\"username\": \"grault\", \"id\": 1},\n"
        client().prepareIndex("test")
                jsonBuilder().startObject()
        client().prepareIndex("test")
 *    http://www.apache.org/licenses/LICENSE-2.0
            .addSort(
            .get();
                    .setNestedPath("parent.child")
    // https://github.com/elastic/elasticsearch/issues/31554
                    .endObject()
    }
                    .field("type", "nested")
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("3"));
        assertHitCount(searchResponse, 3);
        refresh();
import org.opensearch.search.sort.SortMode;
import org.opensearch.index.query.QueryBuilders;
                                    )
        assertThat(searchResponse.getHits().getHits().length, equalTo(2));
        indexRandomForConcurrentSearch("test");
                    + "          ]\n"
                    .endArray()
                    .endArray()
        Explanation explanation = searchResponse.getHits().getHits()[0].getExplanation();
                    + "    }\n"
            .setSource(
        assertAcked(
        assertNoFailures(searchResponse);
        // execute, by grault or foo, by user id, sort missing first
        refresh();
                    + "        },\n"
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
            )
        searchResponse = client().prepareSearch("test")
        assertAcked(
                        .endObject()
 * the Apache License, Version 2.0 (the "License"); you may
                    + "        {\n"
                        + "                \"properties\": {\n"
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("2"));
                    .startObject()
                    .sortMode(SortMode.MIN)
            .setQuery(matchAllQuery())
        // check the numDocs
        searchResponse = client().prepareSearch()
                    + "      \"nested2\": [\n"
                    .endObject()
        client().prepareIndex("test").setId("3").setSource(builder).get();
                        .endObject()
            .setId("1")
        assertThat(searchResponse.getHits().getHits()[0].getSortValues()[0].toString(), equalTo("grault"));
            .get();
                    .field("phoneid", "p1")
        }
                    + "          \"user\": [\n"
                SortBuilders.fieldSort("parent.child.child_values")
            .setId("1")
                    .startObject("properties")
    }
            .setQuery(matchAllQuery())
                    .startObject("workstations")
        searchResponse = client().prepareSearch()
    public void testNestedSortWithMultiLevelFiltering() throws Exception {
                    .field("first", "fname4")
        assertHitCount(searchResponse, 2);
            .addSort(SortBuilders.fieldSort("users.first").setNestedPath("users").order(SortOrder.ASC))
                    .startObject()
        assertThat(searchResponse.getHits().getHits()[2].getId(), equalTo("1"));
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("2"));
                    .startObject()
            .get();
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(5L));
                    + "            {\"username\": \"grault\", \"id\": 1},\n"
            )
            .setQuery(matchAllQuery())
        DeleteResponse deleteResponse = client().prepareDelete("test", "2").get();
                    .field("filter", false)
        }
        super(staticSettings);
            .setSource(
                    .field("child_values", 5L)
        assertThat(searchResponse.getHits().getHits()[2].getId(), equalTo("3"));
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("3"));
            .get();
import static org.hamcrest.Matchers.is;
                    ScoreMode.Avg
                    .endObject()
        client().prepareIndex("test")
                )
        client().prepareIndex("test")
                    .field("filter", true)
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("1"));
            .setQuery(matchAllQuery())
        assertNoFailures(searchResponse);
                    .endObject()
            .get();
public class SimpleNestedIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
                    .startObject("properties")
                    .endObject()
        client().prepareClearScroll().addScrollId("_all").get();
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("2"));
                    .startArray("nested1")
                    .endObject()
                    .startObject()
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("1"));
                    + "  ]\n"
                    .field("type", "long")
 *
            .setQuery(matchAllQuery())
                    .field("filter", false)
                    + "              }\n"
                    .setNestedFilter(termQuery("nested1.field2", true))
                    .startObject("nested1")
                    .field("field1", "value1")
        assertThat(searchResponse.getHits().getHits()[2].getSortValues()[0].toString(), equalTo("-1"));
import org.apache.lucene.search.Explanation;
                    .endObject()
    // When IncludeNestedDocsQuery is wrapped in a FilteredQuery then a in-finite loop occurs b/c of a bug in
        assertThat(searchResponse.getHits().getHits()[2].getSortValues()[0].toString(), equalTo("2"));
                            )
    public void testSimpleNestedSorting() throws Exception {
import static org.hamcrest.Matchers.startsWith;
                        .field("type", "nested")
        assertHitCount(searchResponse, 3);
                    .startObject("child_obj")
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("2"));
            .addSort(
                    .endObject()
                    .endObject()
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        assertDocumentCount("test", 6);
                    + "    }\n"
                    + "          \"name\": \"execute\",\n"
            )
                    .endObject()
                nestedQuery(
                                new NestedSortBuilder("acl.operation").setFilter(QueryBuilders.termQuery("acl.operation.name", "read"))
            .setQuery(nestedQuery("nested1", termQuery("nested1.n_field1", "n_value1_1"), ScoreMode.Avg))
                        .endObject()
            .get();
                    .endObject()
                SortBuilders.fieldSort("parent.parent_values")
        ensureGreen();
            .setId("1")
        assertThat(searchResponse.getHits().getHits().length, equalTo(2));
                    .field("officelocation", "gendale")
                    + "          \"user\": [\n"
                    .startArray("parent")
                    .endObject()
            prepareCreate("test").setMapping(
            // only when querying with nested the fixed bitsets are loaded
                    .endObject()
                    .endObject()
            .setQuery(nestedQuery("nested1.nested2", termQuery("nested1.nested2.field2", "2"), ScoreMode.Avg))
                    .endObject()
                    .field("child_values", -2L)
                    .startObject("first")
                    + "        },\n"
                    .field("officelocation", "gendale")
                    .endObject()
            .get();
                    .field("field2", false)
                    + "          \"user\": [\n"
        assertThat(searchResponse.getHits().getHits()[2].getId(), equalTo("3"));
                        + "        \"properties\": {\n"
                    .endArray()
        assertThat(searchResponse.getHits().getHits()[0].getSortValues()[0].toString(), equalTo("3"));
                    .field("child_values", -3L)
            .get();
                    jsonBuilder().startObject()
        assertThat(searchResponse.getHits().getHits()[2].getSortValues()[0].toString(), equalTo("2"));
        assertNoFailures(searchResponse);
                                        QueryBuilders.termsQuery("acl.operation.user.username", "grault", "foo")
                    .endObject()
                    .endArray()
            .endObject()
        assertThat(searchResponse.getHits().getHits()[1].getSortValues()[0].toString(), equalTo("7"));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
            )
        assertHitCount(searchResponse, 3);
        client().prepareIndex("test")
                        .must(nestedQuery("nested1.nested2", termQuery("nested1.nested2.field2", "2"), ScoreMode.Avg)),
                    + "        },\n"
                    + "      ]\n"
                            "nested1",
import java.util.Collection;
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
                    .endObject()
                    .field("type", "nested")
                    ScoreMode.Avg
        assertNoFailures(searchResponse);
            .get();
            .get();
        // now, do a nested query
            .startObject()
                    .endArray()
                    .field("parent_values", 3L)
                    .setNestedSort(
                    .field("field1", 5)
                        + "          }\n"
        // check on no data, see it works
                    + "      ]\n"
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("2"));
            .setQuery(matchAllQuery())
            .addSort(
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(0L));
        assertThat(searchResponse.getHits().getHits()[0].getSortValues()[0].toString(), equalTo("1"));
        client().prepareIndex("test")
                    .order(SortOrder.ASC)
import org.opensearch.search.sort.NestedSortBuilder;
        );
        assertThat(searchResponse.getHits().getHits()[2].getId(), equalTo("3"));
                    .field("field1", 3)
                    .startArray("nested1")
            .setId("1")
            .setQuery(
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("1"));
                        .startObject("nested1")
            .addSort(
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        client().prepareIndex("test")
                    + "          \"properties\": {\n"
                    .field("filter", false)
                    + "          ]\n"
                    .setNestedPath("parent.child")
        assertNoFailures(searchResponse);
                    .order(SortOrder.ASC)
                    .endObject()
                    .field("stationid", "s1")
        assertThat(searchResponse.getHits().getHits()[2].getId(), equalTo("1"));
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("1")); // missing last
                    .startObject()
                    .endObject()
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("2"));
                    + "      ]\n"
                    + "              \"properties\": {\n"
        assertNoFailures(searchResponse);
            .setQuery(matchAllQuery())
            )
import org.opensearch.action.admin.cluster.stats.ClusterStatsResponse;
                    + "          \"sortVal\": 2\n"
                    .endObject()
                    .startArray("nested1")
                    boolQuery().must(termQuery("nested1.n_field1", "n_value1_1")).must(termQuery("nested1.n_field2", "n_value2_1")),
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("2"));
                    .field("n_field1", "n_value1")
                    .field("stationid", "s1")
                    .field("field2", "3")
            .setQuery(
            .setSource(
                SortBuilders.fieldSort("parent.child.child_obj.value")
            .addSort(
 * not use this file except in compliance with the License.
        flush();
                    .startObject("properties")
                    + "      \"operation\": [\n"
        assertTrue(indexResponse2.getShardInfo().getSuccessful() > 0);
                    .endArray()
        indexRandomForConcurrentSearch("test");
        assertNoFailures(searchResponse);
            .addSort(
                    + "      ]\n"
        ensureGreen();
                SortBuilders.fieldSort("parent.child.child_values")
                    + "}",
                    + "          \"name\": \"read\",\n"
                jsonBuilder().startObject()
                    .startObject("properties")
                    .setNestedPath("parent.child")
                    .endObject()
        client().prepareIndex("test")
                )
            .get();
                    .startObject()
                    .startObject("child_values")
                )
        );
                    .endObject()
            )
                    .field("field1", 2)
                        .field("type", "long")
    * */
                    .endObject()
 * under the License.
            .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("1"));
        client().prepareIndex("test")
        assertThat(searchResponse.getHits().getHits()[2].getId(), equalTo("2"));
        assertThat(searchResponse.getHits().getAt(1).getSortValues()[1].toString(), equalTo("fname3"));
        assertAcked(
                    .endObject()
                    .field("first", "fname5")
                    .startObject()
                    .setNestedSort(
                )
                    .startObject()
        if (randomBoolean()) {
                    .startObject()
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("2"));
                    .startObject("phoneid")
import org.opensearch.action.delete.DeleteResponse;
        assertThat(searchResponse.getHits().getHits()[2].getId(), equalTo("3"));
            .setId("1")
            .startArray("array1")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        searchResponse = client().prepareSearch("test")
                SortBuilders.fieldSort("parent.child.child_values")
        searchResponse = client().prepareSearch("test")
                    .endObject()
        assertThat(getResponse.isExists(), equalTo(true));
                    .startObject("parent_values")
                    .startArray("nested1")
                .setQuery(nestedQuery("array1", termQuery("array1.field1", "value1"), ScoreMode.Avg))
        assertThat(getResponse.getSourceAsBytes(), notNullValue());
        assertHitCount(searchResponse, 3);
                    .startObject()
        assertThat(searchResponse.getHits().getHits()[2].getSortValues()[0].toString(), equalTo("1"));
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("1"));
        SearchResponse searchResponse = client().prepareSearch()
                    + "          \"nested2_keyword\": \"nested2_bar\",\n"
import org.opensearch.common.xcontent.XContentFactory;
            .setId("2")
                        + "                  \"nested2_keyword\": {\n"
                    .field("filter", true)
                    + "            {\"username\": \"quxx\", \"id\": 2}\n"
    * in the explain output. Separate test class is created to test explain for multiple slices
                    .startObject("nested2")
                    .startArray("workstations")
                                    )
                    .startObject()
        assertThat(searchResponse.getHits().getHits()[1].getSortValues()[0].toString(), equalTo("-2"));
import org.opensearch.action.search.SearchType;
            .addSort(
                        )
                    "nested1",
                    .startObject()
                    .startArray("nested1")
                MediaTypeRegistry.JSON
 * compatible open source license.
            .setSource(
        client().prepareIndex("test").setId("2").setSource(builder).get();
        assertThat(searchResponse.getHits().getHits()[2].getSortValues()[0].toString(), equalTo("4"));
                    .field("last", "lname1")
                    .startObject()
            .setId("1")
                    .startObject("grand_parent_values")
                    + "          \"user\": [\n"
import static org.opensearch.index.query.QueryBuilders.boolQuery;
            )
                    .endObject()
        assertThat(searchResponse.getHits().getHits()[1].getSortValues()[0].toString(), equalTo("2"));
                    .startObject()
                SortBuilders.fieldSort("parent.child.child_values")
        indexRandomForConcurrentSearch("test");
            .get();
        client().prepareIndex("test")
        assertThat(explanation.toString(), startsWith("0.16574687 = Score based on 2 child docs in range from 0 to 1"));
                    .endObject()
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("1"));
                    .endObject()
                    .sortMode(SortMode.MIN)
        searchResponse = client().prepareSearch("test")
                    .endObject()
                    + "          \"type\": \"nested\",\n"
        assertThat(searchResponse.getHits().getHits()[0].getSortValues()[0].toString(), equalTo("1"));
                    .endObject()
                jsonBuilder().startObject()
        ensureGreen();
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                    .field("child_values", 6L)
                    .startObject()
import org.opensearch.action.search.SearchRequestBuilder;
                    )
                    .endArray()
                    .endObject()
                        .field("store", true)
        indexRandomForConcurrentSearch("test");
            prepareCreate("test").setSettings(Settings.builder().put(indexSettings()).put("index.refresh_interval", -1))
                    .field("field1", 2)
                )
                    .field("first", "fname1")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                        new NestedSortBuilder("acl").setFilter(QueryBuilders.termQuery("acl.access_id", "1"))
                    .startObject()
                    .order(SortOrder.ASC)
                    .endArray()
        // Sort mode: avg with filter
                        .field("type", "text")
                SortBuilders.fieldSort("acl.operation.user.username")
                    + "          ]\n"
        searchResponse = client().prepareSearch()
        assertThat(searchResponse.getHits().getHits()[1].getSortValues()[0].toString(), equalTo("4"));
                    .endObject()
        client().prepareIndex("test")
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("3"));
    }
                    .endObject()
                    .endObject()
                    .field("child_values", -1L)
                    .startObject()
    }
                    .startArray("parent")
                        )
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));
        // Now add nested mapping
                    .field("stationid", "s3")
                    "nested1",
            .get();
    // IncludeNestedDocsQuery#advance()
                    .field("n_field2", "n_value2_2")
                    + "      ]\n"
                    .field("parent_values", 2L)
                    .endObject()
        assertThat(searchResponse.getHits().getAt(0).getSortValues()[0].toString(), equalTo("fname1"));
            )
                    .order(SortOrder.DESC)
            )
                                .setNestedSort(
                    .setNestedFilter(QueryBuilders.termQuery("parent.child.filter", true))
