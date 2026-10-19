                    .startObject()
                    .startArray("nested1")  
                    .startObject()
        client().prepareIndex("test")  
                    .startObject("child_obj")
                    .endObject()  
            .setId("1")
                        )  
                    .startObject()
                    .setNestedFilter(QueryBuilders.termQuery("parent.child.filter", true))
        client().prepareIndex("test")  
        searchResponse = client().prepareSearch()  
        assertThat(searchResponse.getHits().getHits()[2].getId(), equalTo("1"));  
                    .startObject("workstations")
                    .endArray()
                    .endObject()
                "{\n"
        ensureGreen();
                    .endArray()  
                nestedQuery(  
                    .setNestedSort(  
        assertThat(searchResponse.getHits().getHits()[0].getSortValues()[0].toString(), equalTo("1"));
                    )
                    .order(SortOrder.ASC)
                    .endObject()
        indexRandomForConcurrentSearch("test");
                    .field("field1", "value1")
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("3"));  
                    .startObject()
                jsonBuilder().startObject()
        assertThat(searchResponse.getHits().getHits()[2].getId(), equalTo("3"));
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("2"));
            .addSort(  
        );
                    + "        },\n"
                    + "        },\n"  
                    .setNestedFilter(QueryBuilders.termQuery("parent.filter", false))
                MediaTypeRegistry.JSON
                    + "    }\n"  
                    .endObject()
        ensureGreen();
                        .endObject()
                    .startObject()
                    + "          ]\n"
        client().prepareIndex("test")
                    .endArray()
                    + "        {\n"
        assertThat(searchResponse.getHits().getHits()[1].getSortValues()[0].toString(), equalTo("4"));  
                    .startObject()  
        assertNoFailures(searchResponse);
                    .startObject()
                    .endObject()  
                    .startObject()  
                    .startObject()
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("3"));
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("2"));
                    .endArray()
                    + "  ]\n"  
        assertThat(searchResponse.getHits().getHits()[0].getSortValues()[0].toString(), equalTo("11"));
            .addSort(
                                    new NestedSortBuilder("acl.operation.user").setFilter(
                jsonBuilder().startObject()
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("2"));
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("1"));  
                    + "          \"user\": [\n"  
        refresh();
        assertThat(searchResponse.getHits().getHits()[0].getSortValues()[0].toString(), equalTo("1"));
                    .endObject()
                SortBuilders.fieldSort("parent.child.child_values")
            .setQuery(
            .get();
                    .field("filter", true)  
                    .startObject()
        assertThat(searchResponse.getHits().getHits()[0].getSortValues()[0].toString(), equalTo("3"));
                    .endObject()
            .get();
                )
            .setSource(  
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("3"));
            searchRequestBuilder.setScroll("10m");  
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        refresh();
                    + "          \"user\": [\n"
                    .endObject()
                )  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(0L));
                    .startObject("properties")  
/*  
                    .field("phoneid", "p4")
                    .startObject()
                    .field("stationid", "s5")
                "{\n"
                    .setNestedFilter(QueryBuilders.termQuery("parent.child.filter", true))  
        // Doc with missing nested docs if nested filter is used
        assertThat(searchResponse.getHits().getHits()[0].getSortValues()[0].toString(), equalTo("1"));  
        assertThat(getResponse.isExists(), equalTo(true));  
                SortBuilders.fieldSort("parent.child.child_values")
        SearchResponse searchResponse = searchRequestBuilder.get();  
 *  
                    )  
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("2"));
            .setId("2")  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));  
        assertThat(searchResponse.getHits().getHits()[2].getId(), equalTo("3"));
import static org.hamcrest.Matchers.notNullValue;  
            .get();  
                    .startObject()
            )  
                    + "      }\n"
                    .startObject()
                    + "        {\n"
                    .startObject()
            )
        assertThat(searchResponse.getHits().getHits()[0].getSortValues()[0].toString(), equalTo("1"));
                    .startObject("child_values")
                    .endObject()
    public void testSimpleNestedSorting() throws Exception {  
                    .field("phoneid", "p5")  
        );
                    .field("field1", "1")  
        assertThat(searchResponse.getHits().getHits()[2].getSortValues()[0].toString(), equalTo("2"));
                nestedQuery(
                    .field("type", "text")  
                    + "  \"acl\": [\n"
                    .field("field2", true)
 */
    public void testDeleteNestedDocsWithAlias() throws Exception {  
        searchResponse = client().prepareSearch("test")
        assertThat(searchResponse.getHits().getAt(1).getSortValues()[1].toString(), equalTo("fname3"));
                    .endObject()
                                new NestedSortBuilder("acl.operation").setFilter(QueryBuilders.termQuery("acl.operation.name", "read"))  
                    .startArray("users")
        assertNoFailures(searchResponse);
                    .field("type", "nested")
            assertNoFailures(searchResponse);
                    .startObject("properties")
            )  
                    .field("value", 2L)  
                    .endArray()
                    .endObject()
        assertHitCount(searchResponse, 3);
    }
            .addSort(
                    "nested1",
                        + "                    \"type\": \"integer\"\n"
    }  
                    .startObject("properties")
                    .field("child_values", -3L)
        // access id = 1, read, min value, asc, should now use bar and foo
                        .field("type", "nested")
                    + "        }\n"  
                    .startArray("nested1")
        searchResponse = client().prepareSearch("test").setQuery(termQuery("n_field1", "n_value1_1")).get();
            .setSource(
 * Licensed to Elasticsearch under one or more contributor  
        assertHitCount(searchResponse, 2);  
        assertHitCount(searchResponse, 3);  
                    .endArray()
            searchRequestBuilder.setScroll("10m");  
                    .startArray("users")
        }
                    .endObject()
                    .field("child_values", 1L)  
        if (randomBoolean()) {
                    .startObject()
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("1"));
                    + "      \"access_id\": 3,\n"
                        .field("type", "boolean")
                        .startObject("nested1")  
        searchResponse = client().prepareSearch("test")
                            boolQuery().must(termQuery("nested1.n_field1", "n_value1_1")).must(termQuery("nested1.n_field2", "n_value2_1")),
                    + "      ]\n"
                    .endArray()
        assertTrue(indexResponse1.getShardInfo().getSuccessful() > 0);  
            .addSort(SortBuilders.fieldSort("nested1.field1").order(SortOrder.DESC).setNestedPath("nested1"))  
                jsonBuilder().startObject()  
            .setQuery(nestedQuery("nested1", termQuery("nested1.n_field1", "n_value1_1"), ScoreMode.Avg))  
        assertThat(searchResponse.getHits().getHits()[0].getSortValues()[0].toString(), equalTo("1"));
    public void testExplainWithSingleDoc() throws Exception {
            )
        client().prepareIndex("test")
                    + "      \"nested2\": [\n"
                    .endObject()
                    .endObject()
                    .endObject()
                        .endObject()  
        assertNoFailures(searchResponse);  
        assertThat(searchResponse.getHits().getHits()[2].getId(), equalTo("1"));
        assertAcked(client().admin().indices().preparePutMapping("test").setSource("array1", "type=nested"));  
            .setQuery(
                )
                    .setNestedPath("parent.child")  
        // do some multi nested queries
            .get();
                            new NestedSortBuilder("acl.operation").setFilter(QueryBuilders.termQuery("acl.operation.name", "execute"))
        assertThat(searchResponse.getHits().getHits()[0].getSortValues()[0].toString(), equalTo("2"));  
            .addSort(  
                    .startObject("properties")
                    .field("field1", 5)  
                    .endObject()  
                    .endArray()  
                    .field("field1", "value1")
                    .field("type", "keyword")  
            .setQuery(QueryBuilders.matchAllQuery())
        assertNoFailures(searchResponse);  
        assertThat(searchResponse.getHits().getHits()[2].getSortValues()[0].toString(), equalTo("1"));
import org.opensearch.action.search.SearchResponse;  
                    .startObject()
            .get();
                    + "        },\n"  
                    .startObject("child_obj")
        waitForRelocation(ClusterHealthStatus.GREEN);
                                    )  
        refresh();
            .get();
        if (randomBoolean()) {
                    .startArray("child")
            .get();
                    + "          \"type\": \"nested\",\n"
            .setId("1")
                    .field("type", "nested")
            .get();
                    + "        }\n"
            .endObject();
        // add another doc, one that would match if it was not nested...  
            )
                        + "            \"properties\": {\n"
                nestedQuery(
        assertThat(searchResponse.getHits().getHits()[2].getSortValues()[0].toString(), equalTo("3"));
        Settings.Builder settingsBuilder = Settings.builder().put(indexSettings()).put("index.refresh_interval", -1);
        );
                    .setNestedPath("nested1")
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
                        .must(nestedQuery("nested1.nested2", termQuery("nested1.nested2.field2", "5"), ScoreMode.Avg)),
                    .field("child_values", 4L)
                    .setNestedFilter(QueryBuilders.termQuery("parent.child.filter", true))
            .get();
        indexRandomForConcurrentSearch("test");
                    .endObject()  
        assertNoFailures(searchResponse);
                    .field("stationid", "s6")  
                    + "                \"id\": {\"type\": \"integer\"}\n"
                )  
            SearchResponse searchResponse = client().prepareSearch("test")
                    + "}",
                    .setNestedSort(  
                    .startObject()  
            .get();  
        searchResponse = client().prepareSearch()
        searchResponse = client().prepareSearch("test")  
    // IncludeNestedDocsQuery#advance()
            .setSource(  
                    + "}"
        assertNoFailures(searchResponse);
        ensureSearchable("test");
                    .endObject()
}
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(0L));  
        assertNoFailures(searchResponse);
                    .field("field1", 3)
        assertDocumentCount("test", 3);
                    .endObject()  
                        + "        \"properties\": {\n"
                    + "  }\n"  
                    .startObject()
                SortBuilders.fieldSort("acl.operation.user.id")
        assertThat(searchResponse.getHits().getHits()[2].getSortValues()[0].toString(), equalTo("6"));  
        assertThat(searchResponse.getHits().getHits()[0].getSortValues()[0].toString(), equalTo("-3"));  
            .get();  
                    .endObject()  
                    + " ]\n"
        assertHitCount(searchResponse, 3);
            )  
        assertThat(searchResponse.getHits().getHits()[2].getId(), equalTo("2"));
        assertThat(searchResponse.getHits().getHits()[1].getSortValues()[0].toString(), equalTo("5"));  
            )  
                        + "                  \"nested2_keyword\": {\n"  
                        .startObject("properties")
                        nestedQuery(
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
            .get();
                    .field("field1", 4)
                    .endObject()  
        assertDocumentCount("test", 3);
            .get();
                    .field("phoneid", "p1")
                    .field("n_field1", "n_value1_1")
                    .startObject()  
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("2"));
            prepareCreate("test").setSettings(Settings.builder().put(indexSettings()).put("index.refresh_interval", -1).build())
            )  
import org.opensearch.search.sort.SortBuilders;  
                    "nested1",  
                    .field("type", "long")
        assertNoFailures(searchResponse);
                    .startObject()
            .get();
                    .endObject()
                    .endObject()
            )  
                    .endObject()
                    .endObject()  
                    .startArray("parent")
                    .field("field1", "4")
        searchRequestBuilder = client().prepareSearch("test")
                    .endObject()  
            )  
                )
        assertThat(searchResponse.getHits().getHits()[1].getSortValues()[0].toString(), equalTo("2"));
                    + "    }\n"
                    + "}",
            )
            )
                    "nested1",
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("3"));
                    + "    {\n"  
                    + "        {\n"  
        client().prepareIndex("test")
                    + "        \"access_id\": {\"type\": \"keyword\"},\n"
/*
                    .startObject()  
            .setSource(  
            prepareCreate("test").setMapping(
            .get();
                    .field("field1", 1)  
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("3"));  
                        .field("type", "nested")
                    + "        },\n"
                    .startObject()
                        .endObject()
                    .endObject()
    public void testLeakingSortValues() throws Exception {
                    .endObject()
            .setQuery(matchAllQuery())  
                    + "          ]\n"
                    .field("stationid", "s1")
    // https://github.com/elastic/elasticsearch/issues/31554
    public void testCheckFixedBitSetCache() throws Exception {
        // Sort mode: avg
    public void testNestedSortWithMultiLevelFiltering() throws Exception {  
                    + "        {\n"  
                    + "  \"nested1\": [\n"
                    + "      ]\n"  
 * KIND, either express or implied.  See the License for the
        IndexResponse indexResponse1 = client().prepareIndex("test")
                            "nested1",  
        assertHitCount(searchResponse, 3);
                    .startObject()
                )
    public void testSortNestedWithNestedFilter() throws Exception {
import org.apache.lucene.search.Explanation;  
                        .startObject("properties")
                        .must(nestedQuery("nested1.nested2", termQuery("nested1.nested2.field2", "2"), ScoreMode.Avg)),  
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("2"));
                    .endObject()  
            )  
            )
            )
import org.opensearch.cluster.health.ClusterHealthStatus;
                    ScoreMode.Avg  
            prepareCreate("test").setSettings(Settings.builder().put(indexSettings()).put("index.refresh_interval", -1))
        // check with type prefix
                    .endArray()  
 * license agreements. See the NOTICE file distributed with
        }
                        + "                  },\n"
                    .field("n_field1", "n_value1_1")  
            .get();
                    .endObject()  
package org.opensearch.search.nested;
import org.opensearch.action.admin.cluster.stats.ClusterStatsResponse;  
                    .startObject()
                    + "        {\n"
                    .field("stationid", "s4")
        client().prepareIndex("test").setId("2").setSource(builder).get();
                    + "              }\n"  
                                .setNestedSort(  
            )
                    .field("first", "fname4")  
                    .order(SortOrder.DESC)  
import static org.opensearch.index.query.QueryBuilders.boolQuery;
        assertThat(searchResponse.getHits().getHits()[0].getSortValues()[0].toString(), equalTo("5"));
                    .endObject()
        assertThat(searchResponse.getHits().getHits()[2].getId(), equalTo("3"));
                    + "          \"name\": \"write\",\n"  
                    .field("phoneid", "p6")
        GetResponse getResponse = client().prepareGet("test", "1").get();
            .setSource(
            .field("field1", "value1")
                    .startObject("grand_parent_values")
        clusterStatsResponse = client().admin().cluster().prepareClusterStats().get();  
import org.opensearch.action.index.IndexResponse;
                        + "            }\n"
                    .endObject()
        refresh();  
                    + "          \"sortVal\": 1\n"
                    + "        }\n"  
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("1"));  
                                    )  
            )  
            .setQuery(nestedQuery("nested1", termQuery("nested1.field1", "1"), ScoreMode.Avg))  
        assertThat(searchResponse.getHits().getHits()[1].getSortValues()[0].toString(), equalTo("2"));  
                    .field("first", "fname2")
                        + "        \"dynamic\": \"strict\",\n"
                    .endObject()
                nestedQuery(
                        .startObject("nested1")  
                    boolQuery().must(termQuery("nested1.field1", "1"))
                    + "        {\n"  
                    + "          \"name\": \"execute\",\n"
                    .sortMode(SortMode.MIN)
                    + "            {\"username\": \"grault\", \"id\": 1}\n"  
                    .field("filter", true)
        searchResponse = client().prepareSearch()
import org.opensearch.action.search.SearchType;
            .addSort(
                    .endObject()
        assertThat(searchResponse.getHits().getHits()[2].getSortValues()[0].toString(), equalTo("3"));
                    .field("parent_values", 3L)
                    .startObject()
        assertThat(searchResponse.getHits().getHits()[2].getSortValues()[0].toString(), equalTo("-1"));
                    + "          \"name\": \"write\",\n"
                    .field("phoneid", "p4")
                SortBuilders.fieldSort("nested1.nested2.sortVal")  
            .setSource(
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
                    .startObject("phoneid")
            .setId("1")
                    .field("last", "lname1")
                    .startObject()
            .endObject()  
                    + "          \"name\": \"execute\",\n"  
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("3"));
                    .sortMode(SortMode.SUM)
                XContentFactory.jsonBuilder()
                    + "    }\n"
            )
            .get();  
        searchResponse = client().prepareSearch()
                jsonBuilder().startObject()
        client().prepareIndex("test").setId("5").setSource(builder).get();
    }
        super(staticSettings);  
                    + "    {\n"
                    .startArray("workstations")
        refresh();  
                    .startObject("properties")  
                        .must(nestedQuery("nested1.nested2", termQuery("nested1.nested2.field2", "2"), ScoreMode.Avg)),
                    .field("first", "fname1")
                    .field("field1", 1)
                .get();
                    .field("filter", false)
            .addSort(
                    .setNestedSort(
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));  
                SortBuilders.fieldSort("parent.child.child_values")
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(0L));
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("2"));
        assertThat(searchResponse.getHits().getHits()[0].getSortValues()[0].toString(), equalTo("3"));
            )
        assertHitCount(searchResponse, 3);
                    .endObject()
                    .field("field2", true)
        // filter  
        IndicesStatsResponse stats = admin().indices().prepareStats(index).clear().setDocs(true).get();
                    + "                \"username\": {\"type\": \"keyword\"},\n"
        // sum: 7  
        assertHitCount(searchResponse, 3);  
        assertThat(searchResponse.getHits().getHits()[1].getSortValues()[0].toString(), equalTo("3"));  
                    .field("field1", 2)
        assertThat(searchResponse.getHits().getHits()[1].getSortValues()[0].toString(), equalTo("2"));  
            .setSource(  
 * SPDX-License-Identifier: Apache-2.0
                    .field("last", "lname3")
            clusterStatsResponse = client().admin().cluster().prepareClusterStats().get();
            .setId("1")  
            .get();
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(0L));
import org.opensearch.common.settings.Settings;  
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
                                        QueryBuilders.termsQuery("acl.operation.user.username", "grault", "foo")
                    .field("n_field1", "n_value1_2")  
                    .mustNot(
    // When IncludeNestedDocsQuery is wrapped in a FilteredQuery then a in-finite loop occurs b/c of a bug in  
 * not use this file except in compliance with the License.
                    .order(SortOrder.ASC)
                    + "        \"operation\": {\n"  
            )
                        + "                    \"type\": \"keyword\"\n"
        assertThat(searchResponse.getHits().getHits()[1].getSortValues()[0].toString(), equalTo("4"));
                    .field("type", "nested")
                    .field("filter", false)  
        searchResponse = client().prepareSearch()
        ensureGreen();
                    .endObject()
                    .field("type", "long")
                    .endObject()  
                    .endArray()
            .setExplain(true)  
                    .field("filter", false)  
import org.opensearch.action.get.GetResponse;  
        assertHitCount(searchResponse, 1);  
            .addSort(
                    .sortMode(SortMode.SUM)
                    .field("phoneid", "p3")
            .setSource(
                    .endObject()
                        .startObject("field1")  
                SortBuilders.fieldSort("parent.child.child_values")
                    .endObject()
                "{\n"  
                    ScoreMode.Avg
        client().prepareIndex("test")  
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("3"));
            .setQuery(matchAllQuery())
        if (loadFixedBitSeLazily) {
                    .field("stationid", "s3")  
        searchResponse = client().prepareSearch()
                    .startArray("nested1")  
                    + "  ]\n"
    }
                    .startObject("child")
                jsonBuilder().startObject()  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
                    .endArray()
                jsonBuilder().startObject()
                    .order(SortOrder.ASC)  
        assertThat(stats.getIndex(index).getPrimaries().docs.getCount(), is(numdocs));
                    .field("field2", true)
                    .endObject()  
            .setQuery(QueryBuilders.matchAllQuery())
                    + "      \"operation\": [\n"
                        new NestedSortBuilder("parent").setFilter(QueryBuilders.termQuery("parent.filter", false))  
                        .endObject()
        assertThat(searchResponse.getHits().getHits()[2].getId(), equalTo("3"));
        ensureGreen();  
                jsonBuilder().startObject()
                    + "            {\"username\": \"grault\", \"id\": 1},\n"
                    .endObject()
                    .startObject()
                    .setNestedFilter(termQuery("nested1.field2", true))  
                    .field("type", "long")
        assertThat(explanation.toString(), startsWith("0.16574687 = Score based on 2 child docs in range from 0 to 1"));  
                    .startObject("nested2")  
                    .endObject()
                    )
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
                    + "          \"nested2_keyword\": \"nested2_bar\",\n"  
        assertThat(searchResponse.getHits().getHits()[2].getSortValues()[0].toString(), equalTo("3"));
                        .endObject()  
    }
                    .endObject()
            .addSort(SortBuilders.fieldSort("parent.child.child_values").setNestedPath("parent.child").order(SortOrder.ASC))
                    ScoreMode.Avg
                    .startObject()
            .get();
                    .startArray("workstations")
            .setId("2")
                    + "  \"acl\": [\n"
                    .endObject()
                    .sortMode(SortMode.MIN)
            .setQuery(termQuery("_id", 2))
        searchResponse = client().prepareSearch()  
                jsonBuilder().startObject()
                        new NestedSortBuilder("nested1").setNestedSort(
                    .endObject()
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));
        assertThat(searchResponse.getHits().getHits()[1].getSortValues()[0].toString(), equalTo("2"));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                jsonBuilder().startObject()  
                    .startObject()
            .addSort(
        clusterStatsResponse = client().admin().cluster().prepareClusterStats().get();
        // access id = 1, read, max value, asc, should use grault and quxx
                    jsonBuilder().startObject()
                    .field("n_field2", "n_value2_2")
            .setQuery(QueryBuilders.matchAllQuery())
                    + "    } \n"
                    .field("n_field1", "n_value1_1")
        assertNoFailures(searchResponse);  
                    .field("field", "value")  
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
        assertThat(searchResponse.getHits().getHits()[2].getId(), equalTo("3"));
                        + "          \"nested1\": {\n"  
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
                    + "            {\"username\": \"baz\", \"id\": 4},\n"
            )  
            )  
                                    .setNestedSort(new NestedSortBuilder("acl.operation.user"))
        assertThat(searchResponse.getHits().getHits().length, equalTo(2));
                        new NestedSortBuilder("acl").setNestedSort(
                    .endArray()  
                SortBuilders.fieldSort("parent.child.child_values")
    * here as call to indexRandomForMultipleSlices has implications on the range of child docs  
            );  
            .get();  
                        + "              \"nested2\": {\n"  
        assertThat(clusterStatsResponse.getIndicesStats().getSegments().getBitsetMemoryInBytes(), greaterThan(0L));  
                    .endObject()
            .setQuery(  
                    .endObject()
                    .endObject()  
                    .endObject()
        assertThat(searchResponse.getHits().getHits()[0].getSortValues()[0].toString(), equalTo("1"));
        SearchResponse searchResponse = client().prepareSearch()  
        return Arrays.asList(
        assertThat(searchResponse.getHits().getHits()[2].getId(), equalTo("3"));  
            )
            .setQuery(matchAllQuery())
        XContentBuilder builder = jsonBuilder().startObject()
            .setQuery(matchAllQuery())  
        if (loadFixedBitSeLazily) {  
                        + "                }\n"  
                    .endObject()  
                        .startObject("field1")  
                    .startObject()
        assertThat(searchResponse.getHits().getHits()[1].getSortValues()[0].toString(), equalTo("1"));
                    .field("child_values", 3L)
        assertThat(searchResponse.getHits().getHits()[1].getSortValues()[0].toString(), equalTo("2"));  
                    + "          ]\n"
        assertThat(searchResponse.getHits().getHits().length, equalTo(2));
                    .order(SortOrder.ASC)  
                    .endArray()  
        assertThat(searchResponse.getHits().getHits()[2].getSortValues()[0].toString(), equalTo("3"));
                jsonBuilder().startObject()
                        .startObject("nested1")  
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("2"));
        client().prepareIndex("test").setId("1").setSource("field", "value").get();
                )  
            .addSort(  
                    .startObject("properties")
 * Modifications Copyright OpenSearch Contributors. See
                    .startArray("nested1")
        searchResponse = client().prepareSearch()
                    .field("field2", true)
                    .field("filter", false)
            .get();
                    .setNestedPath("nested1")
                    .sortMode(SortMode.MIN)
                    .endObject()
                    .field("last", "lname4")
                    + "            {\"username\": \"quxx\", \"id\": 2}\n"
            .get();
        assertThat(searchResponse.getHits().getHits()[1].getSortValues()[0].toString(), equalTo("7"));
                        + "        }\n"
        assertThat(searchResponse.getHits().getHits()[2].getSortValues()[0].toString(), equalTo("2"));  
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("2"));
        assertNoFailures(searchResponse);
                    .endArray()
        assertNoFailures(searchResponse);
        // execute, by grault or foo, by username, sort missing last (default)
                    .field("filter", true)  
        assertThat(searchResponse.getHits().getHits()[2].getId(), equalTo("3"));
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(5L));  
            .setSource(
        assertThat(searchResponse.getHits().getHits()[1].getSortValues()[0].toString(), equalTo("2"));  
            .get();  
            )  
                    .startObject()
            )
                    .field("field1", "value2")
        IndexResponse indexResponse2 = client().prepareIndex("test")
        searchResponse = client().prepareSearch()
                        .endObject()  
            .setId("2")
                    .field("n_field2", "n_value2_2")
                    .startObject()
 *    http://www.apache.org/licenses/LICENSE-2.0
            .addSort(
    * in the explain output. Separate test class is created to test explain for multiple slices
            )
import org.opensearch.search.sort.SortOrder;
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("2"));
                    .startObject()
                    .setNestedPath("parent.child")  
                    )  
                            .setNestedSort(new NestedSortBuilder("parent.child"))
        // sum: 11
        assertThat(explanation.getValue(), equalTo(searchResponse.getHits().getHits()[0].getScore()));
            .get();
                )  
                                    .setNestedSort(new NestedSortBuilder("acl.operation.user"))
            .get();
                SortBuilders.fieldSort("acl.operation.user.username")
                    .field("type", "text")  
        SearchResponse searchResponse = client().prepareSearch()
                    .field("field1", 4)
                    .field("parent_values", 2L)  
                    .endObject()
                    .startObject("last")
                    boolQuery().must(termQuery("nested1.field1", "4"))
                    + "            {\"username\": \"bar\", \"id\": 3}\n"
                    .startObject()
 * The OpenSearch Contributors require contributions made to  
                        )
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        // With nested filter  
        SearchResponse searchResponse = client().prepareSearch("test")  
                boolQuery().must(matchAllQuery())  
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("1"));
                SortBuilders.fieldSort("parent.child.child_values")  
                    + "          \"name\": \"read\",\n"
                                    new NestedSortBuilder("acl.operation.user").setFilter(
                    + "            {\"username\": \"quxx\", \"id\": 2}\n"
                    .endObject()
                    .startObject("nested1")  
            .setSource(
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("1"));  
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("1"));  
                nestedQuery(
            )
                    .field("last", "lname5")  
            .setQuery(nestedQuery("nested1", termQuery("nested1.n_field1", "n_value1_1"), ScoreMode.Avg))
                        .field("type", "long")
                    .startArray("nested1")  
                    .field("field1", 4)  
            .setQuery(  
                                .setNestedSort(  
                                )
                    .setNestedPath("parent.child")  
                    .startArray("workstations")  
        client().prepareIndex("test").setId("4").setSource(builder).get();  
                    .endObject()
 * the Apache License, Version 2.0 (the "License"); you may
            .setId("3")
        client().prepareIndex("test")  
                    + "    }\n"
                    .setNestedPath("parent.child")
        assertHitCount(searchResponse, 3);  
                    boolQuery().must(termQuery("nested1.field1", "4"))
        indexRandomForConcurrentSearch("test");
    private void assertDocumentCount(String index, long numdocs) {
        client().prepareIndex("test")
                    boolQuery().must(termQuery("nested1.field1", "1"))  
        assertHitCount(searchResponse, 3);
                    .setNestedPath("parent.child")
        // Check if closest nested type is resolved
            .get();
 */  
    }  
                    .endObject()  
                            ScoreMode.Avg
                    + "              \"properties\": {\n"  
            )
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(0L));
                    .endObject()  
            .get();
            .setQuery(matchAllQuery())  
                        + "      }\n"
                            )
                    + "      \"type\": \"nested\",\n"  
                    boolQuery().must(termQuery("nested1.n_field1", "n_value1_1")).must(termQuery("nested1.n_field2", "n_value2_1")),
                MediaTypeRegistry.JSON
                    + "  ]\n"
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
                    .field("filter", true)  
                    + "            {\"username\": \"quxx\", \"id\": 2}\n"
                jsonBuilder().startObject()
        assertThat(searchResponse.getHits().getHits()[2].getSortValues()[0].toString(), equalTo("3"));
                    .startArray("workstations")
        indexRandomForConcurrentSearch("test");
                    .field("field1", 1)
            .get();
                    .setNestedSort(
            .setQuery(
            .setSource(
import java.util.Arrays;
                    .endObject()  
                    .order(SortOrder.ASC)
            .startObject()
        assertThat(searchResponse.getHits().getHits()[1].getSortValues()[0].toString(), equalTo("4"));
                jsonBuilder().startObject()
            .addSort(
        searchResponse = client().prepareSearch("test")
        client().prepareIndex("test")
                    .field("field1", "value1")  
            .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
        // Now add nested mapping
                .setMapping(  
                    .startObject("stationid")
                    .setNestedFilter(termQuery("nested1.field2", true))  
        assertAcked(
        SearchResponse searchResponse = client().prepareSearch("test")
        assertAcked(client().admin().indices().prepareDelete("test"));
        Explanation explanation = searchResponse.getHits().getHits()[0].getExplanation();
                    .endObject()
        searchResponse = searchRequestBuilder.get();  
                    .field("child_values", 2L)
import org.opensearch.index.query.QueryBuilders;
        assertHitCount(searchResponse, 2);
                    + "        }\n"
                    .startObject("users")
                    .endObject()  
            .addSort(
                    .startObject()
                    + "          \"user\": [\n"  
        refresh();  
        ensureGreen();
            .setQuery(matchAllQuery())
                    .sortMode(SortMode.AVG)
                    + "          ]\n"
                    + "          \"user\": [\n"
                    .endArray()
                    .field("field1", 2)
                jsonBuilder().startObject()  
            prepareCreate("test").setSettings(Settings.builder().put(indexSettings()).put("index.refresh_interval", -1))
        assertThat(getResponse.isExists(), equalTo(true));
            .setId("2")  
            )  
                    .field("value", 3L)
                        .field("store", true)
                    + "    {\n"
                    .field("stationid", "s2")
                    .setNestedFilter(QueryBuilders.termQuery("parent.child.filter", true))
            .get();
                        .startObject("properties")
        assertAcked(
                    .startArray("nested1")  
                    .order(SortOrder.ASC)  
        );  
            prepareCreate("test").setSettings(Settings.builder().put("number_of_shards", 1))
            prepareCreate("test").setMapping(
        assertAcked(
        client().prepareIndex("test")
        GetResponse getResponse = client().prepareGet("test", "1").get();  
                    )  
    public void testSimpleNestedSortingWithNestedFilterMissing() throws Exception {  
            .setId("1")
                                new NestedSortBuilder("acl.operation").setFilter(QueryBuilders.termQuery("acl.operation.name", "read"))  
                    "nested1",
                    .field("field1", 3)
                    .endObject()
                    .field("n_field1", "n_value1")
        // Sort mode: sum with filter
        assertThat(searchResponse.getHits().getHits()[0].getSortValues()[0].toString(), equalTo("2"));  
                    .endObject()  
                    .startObject()  
            .setSource(  
                    .startObject()
    public void testNestedSortingWithNestedFilterAsFilter() throws Exception {  
                    + "        {\n"  
                    .order(SortOrder.DESC)
        assertHitCount(searchResponse, 3);
        assertThat(searchResponse.getHits().getHits()[2].getId(), equalTo("1"));  
                    .startObject()  
                        + "                \"properties\": {\n"
                    .field("type", "nested")  
    }
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("1"));
                        + "                \"type\": \"nested\",\n"
                    .endArray()
            );  
        assertEquals(DocWriteResponse.Result.DELETED, deleteResponse.getResult());
    * case in concurrent search, refer {@link SimpleNestedExplainIT}
        assertNoFailures(searchResponse);
                        .endObject()
                    .order(SortOrder.DESC)
        client().prepareIndex("test").setId("6").setSource(builder).get();
                    .field("parent_values", 3L)  
                    .startObject()
            .setId("2")  
 * this work for additional information regarding copyright
                    .endObject()
                        new NestedSortBuilder("acl").setFilter(QueryBuilders.termQuery("acl.access_id", "1"))
                    .endArray()
                    .endObject()  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
                )
                    .field("last", "lname2")  
            .setId("2")  
                nestedQuery(  
        assertHitCount(searchResponse, 2);
                    + "          \"user\": [\n"
        assertDocumentCount("test", 7);
        client().prepareIndex("test")
                    .startObject()
                    .field("type", "nested")  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
        DeleteResponse deleteResponse = client().prepareDelete("test", "2").get();  
            )
                    boolQuery().must(termQuery("nested1.field1", "1"))  
                    .field("parent_values", 2L)
                    + "          \"name\": \"write\",\n"
                    .field("parent_values", 1L)
                    .field("filter", false)
            .addSort(SortBuilders.fieldSort("nested1.field1").order(SortOrder.ASC).setNestedPath("nested1"))
                    .field("n_field2", "n_value2_2")  
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
                    .setNestedPath("parent.child")  
                            )
                    .field("n_field1", "n_value1")
                    .field("field1", 3)  
                SortBuilders.fieldSort("parent.parent_values")  
                    + "          ]\n"
                    .startArray("nested2")  
            )
            .get();
                    .endObject()  
            )
            .setId("1")  
                    .endArray()
                    .order(SortOrder.ASC)  
        assertThat(searchResponse.getHits().getAt(0).getSortValues()[1].toString(), equalTo("fname1"));
                    .field("field2", "5")
                    + "    \"acl\": {\n"
            )
                    + "          \"user\": [\n"
        client().prepareIndex("test")
    public SimpleNestedIT(Settings staticSettings) {
            // only when querying with nested the fixed bitsets are loaded
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("1"));  
                    .field("field1", 2)
        refresh();  
                    .field("field1", 3)  
        assertHitCount(searchResponse, 3);  
            )
                    .endObject()  
        client().prepareIndex("test").setId("3").setSource(builder).get();
        assertHitCount(searchResponse, 3);
                    .startObject()
            .setQuery(matchAllQuery())
            .get();
                    .field("field2", "6")
                SortBuilders.fieldSort("parent.child.child_values")
                    .endArray()
            .get();  
                    + "          \"name\": \"read\",\n"  
        assertThat(searchResponse.getHits().getHits()[0].getSortValues()[0].toString(), equalTo("1"));
 * this file be licensed under the Apache-2.0 license or a
    }  
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("2"));
                    .order(SortOrder.ASC)
                    + "        }\n"  
            .setSource(
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("2"));  
        searchResponse = client().prepareSearch("test")
    }
                    + "        {\n"
            .addSort(  
            )
 * Unless required by applicable law or agreed to in writing,
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("2"));  
                    .startObject()
                    .field("stationid", "s1")
            .addSort(
                    + "        }\n"
                        .field("type", "nested")
            .get();
        // sum: 2
                    .endObject()
                    .endObject()
import org.opensearch.action.DocWriteResponse;
        client().prepareIndex("test").setId("0").setSource("field", "value").get();
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("1"));  
 */  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(0L));
                    + "            {\"username\": \"quxx\", \"id\": 2},\n"  
                    + "          ]\n"  
        assertThat(searchResponse.getHits().getHits()[0].getSortValues()[0].toString(), equalTo("1"));  
            )
                    .field("n_field2", "n_value2_1")
        assertThat(searchResponse.getHits().getHits()[2].getSortValues()[0].toString(), equalTo("3"));
                    + "            {\"username\": \"grault\", \"id\": 1}\n"  
                    .endObject()  
                    .missing("_first")
        assertThat(searchResponse.getHits().getHits()[0].getSortValues()[0].toString(), equalTo("10"));
                    .missing(10)
        searchResponse = client().prepareSearch("test")
                    .startObject()
                    .endArray()  
        );  
        assertThat(searchResponse.getHits().getHits().length, equalTo(2));
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("1"));
                    .field("type", "nested")
                    .endObject()
                    .startArray("child")
        client().prepareClearScroll().addScrollId("_all").get();  
            .setSource(
                    .startObject()  
        assertHitCount(searchResponse, 3);
                    ScoreMode.Avg
        }
                    .field("field1", 2)  
                    ScoreMode.Avg
                    + "            {\"username\": \"foo\", \"id\": 5}\n"
            .setQuery(
        // No nested mapping yet, there shouldn't be anything in the fixed bit set cache
                        .endObject()
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
                        )
                    .startArray("nested1")
                    + "            {\"username\": \"foo\", \"id\": 5}\n"
            )
            .startArray("array1")  
                    + "      \"properties\": {\n"
        // Nested path should be automatically detected, expect same results as above search request
            .setQuery(matchAllQuery())  
                    .startObject("first")
                    .field("filter", false)  
        assertThat(searchResponse.getHits().getHits()[0].getSortValues()[0].toString(), equalTo("bar"));  
                    + "      ]\n"  
        assertThat(searchResponse.getHits().getHits()[2].getSortValues()[0].toString(), equalTo("11"));
            .get();  
    public void testMultiNested() throws Exception {
                    .setNestedPath("parent.child")
                    + "      \"nested2\": [\n"
                SortBuilders.fieldSort("nested1.field1")
                    .endArray()
        indexRandomForConcurrentSearch("test");
            .setId("1")
                MediaTypeRegistry.JSON  
            .addSort(
                    .endObject()
                    + "            {\"username\": \"grault\", \"id\": 1}\n"  
            )
            )  
            .setQuery(nestedQuery("nested1", termQuery("nested1.n_field1", "n_value1"), ScoreMode.Total))
                    + "          \"user\": [\n"
                jsonBuilder().startObject()
                    .setNestedFilter(nestedQuery("users.workstations", termQuery("users.workstations.stationid", "s5"), ScoreMode.Avg))
                    .field("child_values", -1L)
            .get();  
                    boolQuery().must(termQuery("nested1.n_field1", "n_value1_1")).must(termQuery("nested1.n_field2", "n_value2_1")),  
                    .endArray()
        searchResponse = client().prepareSearch()  
            .get();
            )  
        searchResponse = client().prepareSearch("test")
import static org.opensearch.index.query.QueryBuilders.nestedQuery;  
                        .startObject("properties")
                    .endObject()  
        searchResponse = client().prepareSearch("test")
                    .field("field2", "3")  
            prepareCreate("test").setMapping(  
                    .startArray("nested1")
                    .startArray("nested1")
    @ParametersFactory  
                        .field("type", "text")
        refresh();  
                    .field("filter", false)
                SortBuilders.fieldSort("acl.operation.user.username")
                    .startObject()  
                )
            prepareCreate("test").setMapping(  
                    + "          \"nested2_keyword\": \"nested2_bar\",\n"
                    + "          \"name\": \"read\",\n"
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));  
        searchResponse = client().prepareSearch("test")
                    .startObject("properties")  
        searchResponse = client().prepareSearch()
        indexRandomForConcurrentSearch("test");
                    .field("stationid", "s2")
                        new NestedSortBuilder("acl").setFilter(QueryBuilders.termQuery("acl.access_id", "1"))
                    .startObject()
                    .endObject()
                    + "        {\n"
                SortBuilders.fieldSort("parent.child.child_obj.value")  
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("1"));
                    .field("child_values", 1L)  
                    .field("child_values", -2L)
            .setQuery(matchAllQuery())  
            .setQuery(matchAllQuery())  
        assertNoFailures(searchResponse);  
                    "nested1",
 * ownership. Elasticsearch licenses this file to you under  
            )
                    + "          \"name\": \"read\",\n"
                    .startObject()  
    }
            .get();
        refresh();  
                    + "          }\n"
                        new NestedSortBuilder("acl").setNestedSort(
                    .field("type", "nested")
        assertThat(searchResponse.getHits().getHits()[2].getId(), equalTo("1"));  
            .setRefreshPolicy(IMMEDIATE)
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("1"));  
        assertNoFailures(searchResponse);
        assertNoFailures(searchResponse);
            .get();
        assertThat(searchResponse.getHits().getHits()[1].getSortValues()[0].toString(), equalTo("-2"));
                jsonBuilder().startObject()
                SortBuilders.fieldSort("parent.child.child_values")
                    .startObject()  
            .endArray()
        ensureGreen();  
                    + "              \"type\": \"nested\",\n"
                    .startObject()
                    .field("grand_parent_values", 2L)
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
                    .order(SortOrder.ASC)
            .get();  
                    + "    {\n"  
                MediaTypeRegistry.JSON
                    .endArray()
 * You may obtain a copy of the License at  
                    + "          \"sortVal\": 2\n"
        searchResponse = client().prepareSearch("test")
        assertThat(searchResponse.getHits().getHits()[2].getSortValues()[0].toString(), equalTo("10"));
                    .endObject()
                    .order(SortOrder.ASC)
        assertAcked(
                    .setNestedPath("users")  
        client().prepareIndex("test")  
                    .startObject()
                    .field("type", "keyword")  
                    .startObject()
            .setQuery(matchAllQuery())  
            )
            .setSource(
            .get();
        ClusterStatsResponse clusterStatsResponse = client().admin().cluster().prepareClusterStats().get();
    }
                    .startObject()  
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("1"));
                    .startArray("parent")
                    + "      \"operation\": [\n"
                    .field("phoneid", "p1")
                    + "  \"nested1\": [\n"  
            .get();
            .get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("2"));  
        client().prepareIndex("test")
        assertNoFailures(searchResponse);  
                    .startObject()  
                    .startObject()  
                    .endObject()
                    .field("officelocation", "gendale")  
        assertThat(searchResponse.getHits().getHits()[2].getSortValues()[0].toString(), equalTo("2"));
        assertThat(clusterStatsResponse.getIndicesStats().getSegments().getBitsetMemoryInBytes(), equalTo(0L));  
/*  
                    + "      \"access_id\": 2,\n"
                        + "            \"type\": \"nested\",\n"
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("2"));  
        searchResponse = client().prepareSearch("test")
                nestedQuery(
            .get();  
            )  
                    .endObject()
        refresh();  
                    .sortMode(SortMode.AVG)
 * software distributed under the License is distributed on an
                    .field("parent_values", 4L)
                        .startObject("field2")  
        assertThat(searchResponse.getHits().getHits()[2].getSortValues()[0].toString(), equalTo("4"));
                    .endArray()  
import org.opensearch.common.xcontent.XContentFactory;
                    .startArray("workstations")  
                    .endObject()
                    .startArray("workstations")
                    .startObject()
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                    + "          \"properties\": {\n"
                    .startArray("child")  
                    .setNestedPath("parent.child")
                    .field("first", "fname1")  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
                    .field("filter", false)
                    .field("field2", false)
        // Without nested filter
        waitForRelocation(ClusterHealthStatus.GREEN);
                    .order(SortOrder.ASC)
        assertThat(searchResponse.getHits().getHits()[0].getSortValues()[0].toString(), equalTo("1"));
                    + "    {\n"  
                            .setNestedSort(
        assertTrue(indexResponse2.getShardInfo().getSuccessful() > 0);  
                    .endObject()
            .get();
                        .startObject("properties")
                    .field("n_field2", "n_value2_2")  
        assertDocumentCount("test", 6);
        // Sort mode: avg with filter
                        .endObject()
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));  
                    .endObject()
                    .setNestedSort(  
        client().prepareIndex("test")
                    .endObject()
                    .order(SortOrder.DESC)  
        assertHitCount(searchResponse, 3);
import org.opensearch.action.search.SearchRequestBuilder;
                    .startArray("child")
        searchResponse = client().prepareSearch("test")  
                    .endObject()
                    .setNestedFilter(QueryBuilders.termQuery("parent.child.filter", true))
            .setSource(
                    .startObject()  
    public static Collection<Object[]> parameters() {
                    .endObject()  
                    .missing(10)
                    .endObject()
                SortBuilders.fieldSort("nested1.field1")
                    .field("officelocation", "gendale")  
        client().admin().indices().prepareAliases().addAlias("test", "alias1", QueryBuilders.termQuery("field1", "value1")).get();
                        .field("type", "long")
        client().prepareIndex("test")
                    + "}",  
                        .must(nestedQuery("nested1.nested2", termQuery("nested1.nested2.field2", "4"), ScoreMode.Avg)),  
                .setMapping(  
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
                    + "      ]\n"
        // Sort mode: sum
                    + "      \"access_id\": 1,\n"
import static org.hamcrest.Matchers.is;
                    + "    },\n"
                    .field("filter", false)
        searchResponse = client().prepareSearch()
                    .startObject()
            )  
        SearchRequestBuilder searchRequestBuilder = client().prepareSearch("test")
                    .field("n_field2", "n_value2_1")
            .setId("3")  
                    .field("stationid", "s5")
                    .field("n_field2", "n_value2_1")
        client().prepareIndex("test")
                    + "        },\n"
                    .field("child_values", 1L)
        assertThat(searchResponse.getHits().getHits()[0].getSortValues()[0].toString(), equalTo("foo"));  
            )
        assertAcked(
                    .endObject()
            .get();
                    .field("n_field1", "n_value1_1")
                    + "      \"operation\": [\n"
 *
                    .startObject("properties")
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("1")); // missing last
                    .field("phoneid", "p6")
                jsonBuilder().startObject()
                    .startObject("parent")
                    .endObject()  
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("2"));
                    .endObject()  
        refresh();  
                    + "}",  
        // index simple data  
        ensureGreen();
        assertAcked(
        assertThat(searchResponse.getHits().getHits()[2].getId(), equalTo("1"));
                    + "    {\n"
                    + "        },\n"
            .setQuery(matchAllQuery())  
        assertThat(searchResponse.getHits().getHits()[2].getId(), equalTo("2"));
        assertHitCount(searchResponse, 2);  
        refresh();
                    boolQuery().must(termQuery("nested1.field1", "1"))
import org.opensearch.core.xcontent.MediaTypeRegistry;
                    .field("stationid", "s4")
            .setQuery(matchAllQuery())
            .get();
                    .endObject()
        ensureSearchable("test");
                    .field("child_values", 6L)
        assertThat(searchResponse.getHits().getAt(0).getSortValues()[0].toString(), equalTo("fname1"));
                    .endObject()  
                    .startObject()
        assertThat(searchResponse.getHits().getHits()[1].getSortValues()[0].toString(), equalTo("foo"));
            )
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("2"));
        assertThat(clusterStatsResponse.getIndicesStats().getSegments().getBitsetMemoryInBytes(), equalTo(0L));
                    + "        {\n"
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("1"));  
                        + "          }\n"  
                    + "            }\n"
                    .endObject()  
                    .endArray()
                    ScoreMode.Avg
            .addSort(
        assertHitCount(searchResponse, 2);  
                    .endObject()
            .setQuery(nestedQuery("nested1.nested2", termQuery("nested1.nested2.field2", "2"), ScoreMode.Avg))  
        assertThat(searchResponse.getHits().getHits()[1].getSortValues()[0].toString(), equalTo("2"));  
        assertAcked(  
                    .startArray("nested1")
                nestedQuery(
 *
                        .startObject("field1")  
            )
        assertThat(searchResponse.getHits().getHits()[1].getSortValues()[0].toString(), equalTo("7"));  
        searchResponse = client().prepareSearch()
        searchResponse = client().prepareSearch("test")  
                jsonBuilder().startObject()  
                    .sortMode(SortMode.MAX)  
                    .endObject()  
                    .startObject("child_obj")  
                    jsonBuilder().startObject()
        SearchResponse searchResponse = client().prepareSearch("test").get();
 * GitHub history for details.
                        .endObject()
    * */  
                    .endObject()
                        .must(nestedQuery("nested1.nested2", termQuery("nested1.nested2.field2", "5"), ScoreMode.Avg)),
        searchResponse = client().prepareSearch()  
        searchResponse = client().prepareSearch("test")  
            .addSort(
        ensureGreen();
                    .startObject()  
        assertHitCount(searchResponse, 3);
        assertThat(searchResponse.getHits().getHits()[1].getSortValues()[0].toString(), equalTo("quxx"));
                    + "            {\"username\": \"bar\", \"id\": 3}\n"
        SearchResponse searchResponse = client().prepareSearch("test")
                    .startObject()  
                    .field("filter", false)
            )
                )
        assertThat(searchResponse.getHits().getHits()[1].getSortValues()[0].toString(), equalTo("2"));
    }
                    .startArray("child")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
            assertThat(clusterStatsResponse.getIndicesStats().getSegments().getBitsetMemoryInBytes(), equalTo(0L));
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("2"));
                    + "        {\n"  
            .setQuery(matchAllQuery())  
            )
                    .startObject()  
        assertDocumentCount("test", 6);
            .setSource(
        assertNoFailures(stats);  
                        + "                  \"sortVal\": {\n"  
                    .startObject("parent_values")
 * compatible open source license.
                    .field("field1", 1)  
                    .endArray()
            .addSort(  
            .get();
                    + "        }\n"
                            .setNestedSort(
                    "nested1",  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));  
                .setMapping(
        indexRandomForConcurrentSearch("test");
        client().prepareIndex("test")
                    .field("child_values", 5L)  
            .setId("1")
            .setId("2")
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("2"));
        assertThat(getResponse.getSourceAsBytes(), notNullValue());
                    .endObject()
                    + "      \"access_id\": 1,\n"  
            .setSource(  
                    + "      ]\n"
                    .field("stationid", "s3")  
                    .order(SortOrder.ASC)
        // check delete, so all is gone...
                jsonBuilder().startObject()
                    .startObject()
    // Issue #9305
        waitForRelocation(ClusterHealthStatus.GREEN);
                    .endObject()  
            .setQuery(nestedQuery("nested1", termQuery("nested1.n_field1", "n_value1_1"), ScoreMode.Avg))  
import org.apache.lucene.search.join.ScoreMode;
            .setQuery(
        refresh();
                "{\n"
            .get();
import org.opensearch.search.sort.SortMode;
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
            )
            .setId("1")
                    + "          ]\n"  
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
                    + "            {\"username\": \"quxx\", \"id\": 2},\n"
        assertAcked(prepareCreate("test").setMapping("nested1", "type=nested"));  
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(0L));  
                    .endObject()
    }
                    .endArray()
                    .startArray("nested1")
                    .field("first", "fname3")
            settingsBuilder.put("index.load_fixed_bitset_filters_eagerly", false);  
                    .startArray("nested1")
        // execute, by grault or foo, by user id, sort missing first
                    .endArray()
                    .endObject()  
            .setSource(
                    .field("filter", true)
        // now, do a nested query
                    .field("grand_parent_values", 1L)
                        .endObject()  
                    + "        {\n"
        assertThat(searchResponse.getHits().getHits()[0].getSortValues()[0].toString(), equalTo("grault"));  
        boolean loadFixedBitSeLazily = randomBoolean();  
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("1")); // missing first  
                    .setNestedPath("parent.child")
                    .endArray()
                    .endObject()  
                    .setNestedPath("parent.child")  
        assertThat(searchResponse.getHits().getAt(1).getSortValues()[0].toString(), equalTo("fname1"));
                    .startArray("parent")  
                            new NestedSortBuilder("acl.operation").setFilter(QueryBuilders.termQuery("acl.operation.name", "execute"))
    /*
                    .field("n_field1", "n_value1_2")
            .setQuery(
                    + "          ]\n"  
                    .endObject()  
                    .field("n_field1", "n_value1_2")
            .setQuery(QueryBuilders.matchAllQuery())
            )
        );  
                    + "          \"name\": \"execute\",\n"
                    .field("field1", "value1")
            .get();  
    public void testSimpleNested() throws Exception {
                    .sortMode(SortMode.MAX)
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("2"));
                "{\n"  
                    .field("field2", false)  
            .get();  
        indexRandomForConcurrentSearch("test");
                    + "  \"properties\": {\n"
                    .field("phoneid", "p3")
                    .endObject()  
                    .endObject()  
    // This IncludeNestedDocsQuery also needs to be aware of the filter from alias
                    + "          \"user\": [\n"
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
            .setQuery(  
        assertThat(searchResponse.getHits().getHits().length, equalTo(2));
                SortBuilders.fieldSort("parent.child.child_values")  
                )
        searchResponse = client().prepareSearch("test").setQuery(termQuery("n_field1", "n_value1_1")).get();
                    .startObject()  
                    + "          \"user\": [\n"  
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));  
                    .field("type", "text")  
                    .field("n_field1", "n_value1_2")
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));  
        flush();
                SortBuilders.fieldSort("users.first")
            .get();  
        // search for something that matches the nested doc, and see that we don't find the nested doc
        refresh();  
                        + "              }\n"
                    .startObject("officelocation")
                    .field("field2", "2")  
                                        QueryBuilders.termsQuery("acl.operation.user.username", "grault", "foo")
    }  
                    .field("phoneid", "p2")  
                        .must(nestedQuery("nested1.nested2", termQuery("nested1.nested2.field2", "3"), ScoreMode.Avg)),
                    .endObject()  
                    .endObject()
                                )
                    + "      ]\n"
                    .field("field1", 5)
                    .startObject("properties")
                    + "          ]\n"  
                    .endObject()
                        + "                  }\n"
        }
                    jsonBuilder().startObject()
        assertThat(searchResponse.getHits().getHits()[2].getId(), equalTo("3"));
                .setQuery(nestedQuery("array1", termQuery("array1.field1", "value1"), ScoreMode.Avg))  
                    .endObject()
            .get();
                    .endObject()
                    .field("first", "fname5")
                    .field("filter", false)
public class SimpleNestedIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
                    .endObject()  
        // check the numDocs  
                    .endObject()
                    + "          ]\n"
import org.opensearch.search.sort.NestedSortBuilder;
        assertThat(searchResponse.getHits().getHits()[2].getSortValues()[0].toString(), equalTo("3"));
                    .endObject()
            .addSort(
            .setQuery(matchAllQuery())
                jsonBuilder().startObject()
                    .endObject()  
                        .endObject()
    * Tests the explain output for single doc. Concurrent search with only slice 1 is tested
        SearchResponse searchResponse = client().prepareSearch()
            prepareCreate("test").setMapping(  
            .addSort(SortBuilders.fieldSort("users.first").setNestedPath("users").order(SortOrder.ASC))
                    + "            {\"username\": \"grault\", \"id\": 1},\n"  
import static org.hamcrest.Matchers.startsWith;
        SearchResponse searchResponse = client().prepareSearch("test")
 * specific language governing permissions and limitations
                            new NestedSortBuilder("nested1.nested2").setFilter(termQuery("nested1.nested2.nested2_keyword", "nested2_bar"))  
        assertHitCount(searchResponse, 3);
                    "{\n"  
                    .field("child_values", 3L)
        indexRandomForConcurrentSearch("test");
                        )
                    )
        ensureGreen();
                    ScoreMode.Avg
        );  
                    .order(SortOrder.DESC)  
                    .field("filter", true)
            .get();
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
            .setId("2")
                    .field("grand_parent_values", 3L)  
                    + "            \"name\": {\"type\": \"keyword\"},\n"  
                jsonBuilder().startObject()
                    .field("n_field2", "n_value2_1")  
                .setMapping(  
        // check the numDocs
import org.opensearch.action.delete.DeleteResponse;
                        .endObject()
                    .field("phoneid", "p5")  
                    .startArray("child")  
                    .sortMode(SortMode.SUM)
                    .startArray("nested2")
import java.util.Collection;  
                    .field("filter", false)  
        );
                    .setNestedSort(  
                    .field("last", "lname1")
            .get();
                    + "          \"user\": [\n"
                    "nested1",
            .setId("1")  
                    + "            \"user\": {\n"
        searchResponse = client().prepareSearch("test").setQuery(termQuery("n_field1", "n_value1_1")).get();  
                    .field("field1", 4)  
        );  
        assertAcked(prepareCreate("test").setSettings(settingsBuilder));
                    .endObject()
            .setId("3")  
        client().prepareIndex("test")
                    .endObject()  
        );
                    ScoreMode.Avg  
            .setQuery(matchAllQuery())  
                    .sortMode(SortMode.AVG)
                    .startObject("nested1")  
                    .startObject()
                    .endObject()
                    .order(SortOrder.ASC)
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        assertHitCount(searchResponse, 3);  
        assertAcked(
            )
        assertAcked(
                        .endObject()  
                    + "      \"operation\": [\n"  
                    .field("stationid", "s6")  
                    "nested1",  
 * under the License.  
                    .field("value", 1L)
            .get();
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
import static org.hamcrest.Matchers.equalTo;  
            .setSource(
                    )  
            .setSource(  
            .get();
import static org.hamcrest.Matchers.greaterThan;
                    .field("phoneid", "p2")  
        assertThat(searchResponse.getHits().getHits()[2].getId(), equalTo("3"));
                    .endArray()  
import org.opensearch.core.xcontent.XContentBuilder;  
import static org.opensearch.index.query.QueryBuilders.termQuery;
                    + "    },\n"  
        // check on no data, see it works  
                    .endObject()
                    .endArray()  
                        .endObject()
        searchResponse = client().prepareSearch("test").setQuery(matchAllQuery()).get();
                SortBuilders.fieldSort("acl.operation.user.username")
                    .startObject()
