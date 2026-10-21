            assertThat(
 * You may obtain a copy of the License at
                    .getHits()
                .prepareAliases()
                client().prepareSearch("alias")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        for (int i = 0; i < 5; i++) {
                    .getTotalHits()
                client().prepareSearch("alias1")
import org.opensearch.test.OpenSearchIntegTestCase;
                equalTo(0L)
                    .actionGet()
            );
        logger.info("--> verifying get with no routing, should not find anything");
                    .setSize(0)
    to the other indices (without routing) were not taken into account in PlainOperationRouting#searchShardsCount.
                    .execute()
        }
        client().prepareIndex("alias-b1").setId("1").setSource("field", "value1").setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();
                    .execute()
            assertThat(
                    .setQuery(QueryBuilders.matchAllQuery())
                    .getHits()
            assertThat(
                    .getTotalHits()
            assertThat(
        client().prepareIndex("index_2").setId("2").setSource("field", "value2").setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();
            assertThat(
                    .execute()
                    .getHits()
        client().prepareIndex("index_1").setId("1").setSource("field", "value1").setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();
                client().prepareSearch()
                    .getTotalHits()
        logger.info("--> verifying get with routing alias, should find");
        logger.info("--> search with 1 routing, should find one");
            );
                    .actionGet()
                    .execute()
            );
                    .setQuery(QueryBuilders.matchAllQuery())
                    .getHits()
            assertThat(client().prepareGet("alias0", "1").execute().actionGet().isExists(), equalTo(true));
            assertThat(
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
                    .execute()
        SearchResponse searchResponse = client().prepareSearch("index_*")
 * ownership. Elasticsearch licenses this file to you under
                equalTo(2L)
                    .execute()
                equalTo(1L)
            );
                    .setQuery(QueryBuilders.matchAllQuery())
                    .getTotalHits()
                    .actionGet()
                    .getTotalHits()
            );
            assertThat(client().prepareGet("alias0", "1").execute().actionGet().isExists(), equalTo(true));
        logger.info("--> search with wrong routing, should not find");
                    .setRouting("1")
        }
                client().prepareSearch()
            assertThat(client().prepareGet("test", "1").setRouting("0").execute().actionGet().isExists(), equalTo(true));
            assertThat(client().prepareGet("alias-b1", "1").execute().actionGet().isExists(), equalTo(true));
        logger.info("--> search with test, alias0 and alias1, should find two");
                    .execute()
            assertThat(
                equalTo(2L)
        assertAcked(admin().indices().prepareAliases().addAliasAction(AliasActions.add().index("index").alias("index_1").routing("1")));
 * not use this file except in compliance with the License.
        logger.info("--> creating alias with routing [4]");
                    .setQuery(QueryBuilders.matchAllQuery())
                    .setSize(0)
                equalTo("value2")
                    .getTotalHits()
                client().prepareSearch()
        Settings settings = super.indexSettings();
        client().prepareIndex("index_2").setId("2").setSource("field", "value2").setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();
        for (int i = 0; i < 5; i++) {
        for (int i = 0; i < 5; i++) {
        for (int i = 0; i < 5; i++) {
                    .actionGet()
            );
            assertThat(
                client().prepareGet("alias0", "1").execute().actionGet().getSourceAsMap().get("field").toString(),
                    .setSize(0)
        assertAcked(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
 *
            assertThat(
                    .setSize(0)
                    .setQuery(QueryBuilders.matchAllQuery())
                client().prepareSearch("index_*")
                    .getHits()
 *
                    .setQuery(QueryBuilders.matchAllQuery())
        assertAcked(admin().indices().prepareAliases().addAliasAction(AliasActions.add().index("test").alias("alias").routing("4")));
        client().prepareIndex("alias-a0").setId("1").setSource("field", "value1").setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();
                client().prepareSearch("alias01")
        logger.info("--> search with correct routing, should find");
                    .execute()
                    .getTotalHits()
                    .value(),
            assertThat(client().prepareGet("test", "0").setRouting("3").execute().actionGet().isExists(), equalTo(true));
            assertThat(
        assertAcked(admin().indices().prepareAliases().addAliasAction(AliasActions.add().index("test").alias("alias0").routing("0")));
            assertThat(
                    .value(),
                    .getTotalHits()
            assertThat(client().prepareGet("test", "1").execute().actionGet().isExists(), equalTo(false));
                    .execute()
                    .execute()
                    .setSize(0)
                equalTo(1L)
            .setSearchType(SearchType.QUERY_THEN_FETCH)
        logger.info("--> verifying get and search with routing, should find");
                    .execute()
                    .setSize(0)
            );
            assertThat(
                    .getHits()
                equalTo(1L)
            assertThat(client().prepareGet("alias0", "1").execute().actionGet().isExists(), equalTo(false));
                    .setQuery(QueryBuilders.matchAllQuery())
            assertThat(
    See https://github.com/elastic/elasticsearch/pull/3268
                    .setRouting("0", "1")
                    .setQuery(QueryBuilders.matchAllQuery())
        }
        return Settings.builder().put(settings).put("index.number_of_routing_shards", numShards).build();
            );
                    .value(),
            assertThat(client().prepareGet("test", "1").setRouting("0").execute().actionGet().isExists(), equalTo(true));
                .prepareAliases()
                    .setQuery(QueryBuilders.matchAllQuery())
                    .value(),
        logger.info("--> search with 0 routing, should find one");
 * Modifications Copyright OpenSearch Contributors. See
                    .setSize(0)
                client().prepareSearch("alias-ab")
                    .getTotalHits()
        for (int i = 0; i < 5; i++) {
                    .value(),
                equalTo(2L)
            );
                    .setQuery(QueryBuilders.matchAllQuery())
}
                    .getHits()
            );
            assertThat(
import org.opensearch.common.xcontent.XContentFactory;
        return 2;
import org.opensearch.cluster.metadata.IndexMetadata;
                    .execute()
        for (int i = 0; i < 5; i++) {
            assertThat(
            assertThat(
                    .setQuery(QueryBuilders.matchAllQuery())
 * software distributed under the License is distributed on an
        for (int i = 0; i < 5; i++) {
        for (int i = 0; i < 5; i++) {
        }
                client().prepareSearch("alias0")
        createIndex("index", "index_2");
                    .getHits()
                .addAliasAction(AliasActions.add().index("test").alias("alias01").searchRouting("0,1"))
        createIndex("test");
            );
        client().prepareIndex("index_1").setId("1").setSource("field", "value1").setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();
            .setUpsert(XContentFactory.jsonBuilder().startObject().field("field", 1).endObject())
                    .getTotalHits()
                client().prepareSearch("alias0")
                    .setQuery(QueryBuilders.matchAllQuery())
 */
        for (int i = 0; i < 5; i++) {
                .addAliasAction(AliasActions.add().index("test-a").alias("alias-a0").routing("0"))
                    .setQuery(QueryBuilders.matchAllQuery())
                    .value(),
                    .setQuery(QueryBuilders.matchAllQuery())
                    .actionGet()
        }
    }
                    .actionGet()
    @Override
        logger.info("--> verifying get with routing, should find");
                    .getTotalHits()
/*
        for (int i = 0; i < 5; i++) {
                    .value(),
            assertThat(
                    .getTotalHits()
                    .setQuery(QueryBuilders.matchAllQuery())
                client().prepareSearch("alias1")
                    .getTotalHits()
                    .execute()
 * this file be licensed under the Apache-2.0 license or a
                    .setRouting("0")
        }
        logger.info("--> indexing on index_2 which is a concrete index");
                    .value(),
                    .setSize(0)
                    .getTotalHits()
    Searching on more than one index, if one of those is an alias with configured routing, the shards that belonged
        client().prepareIndex("alias1").setId("2").setSource("field", "value1").setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();
                    .value(),
        logger.info("--> indexing with id [0], and routing [3]");
            );
        for (int i = 0; i < 5; i++) {
                client().prepareSearch("test", "alias0", "alias1")
public class AliasRoutingIT extends OpenSearchIntegTestCase {
        ensureGreen();
                equalTo(1L)
    }
                    .setQuery(QueryBuilders.matchAllQuery())
                equalTo(1L)
                    .setQuery(QueryBuilders.matchAllQuery())
            );
                client().prepareSearch("alias0", "alias1", "alias01")
            .setQuery(QueryBuilders.matchAllQuery())
                    .value(),
        logger.info("--> deleting with routing alias, should delete");
        logger.info("--> verifying get with no routing, should not find anything");
                client().prepareSearch("alias-a1", "alias-b0")
    public void testAliasCrudRouting() throws Exception {
        }
                    .setQuery(QueryBuilders.matchAllQuery())
        assertAcked(admin().indices().prepareAliases().addAliasAction(AliasActions.add().index("test").alias("alias").routing("3")));
                    .setSize(0)
    public void testAliasSearchRouting() throws Exception {
        }
        }
                equalTo(0L)
                    .execute()
                client().prepareSearch("alias1")
            assertThat(client().prepareGet("test", "1").execute().actionGet().isExists(), equalTo(false));
                    .getHits()
                    .setQuery(QueryBuilders.matchAllQuery())
        }
                client().prepareSearch("alias0", "alias1", "alias01")
            assertThat(client().prepareGet("test", "1").execute().actionGet().isExists(), equalTo(false));
                client().prepareSearch("alias-a0", "alias-b1")
                    .setQuery(QueryBuilders.matchAllQuery())
                    .execute()
        logger.info("--> creating alias with routing [3]");
    }
            assertThat(client().prepareGet("test-a", "1").execute().actionGet().isExists(), equalTo(false));
            assertThat(
                equalTo(0L)
            assertThat(client().prepareGet("test", "0").setRouting("3").execute().actionGet().isExists(), equalTo(true));
                    .getTotalHits()
                    .value(),
        logger.info("--> verifying get with routing, should find");
                    .actionGet()
        for (int i = 0; i < 5; i++) {
                    .getHits()
                .addAliasAction(AliasActions.add().index("test-b").alias("alias-b0").routing("0"))
                equalTo(0L)
import org.opensearch.index.query.QueryBuilders;
                    .execute()
package org.opensearch.routing;
 * Test aliases with routing.
                    .execute()
                    .actionGet()
        logger.info("--> search with two routing aliases , should find two");
                    .actionGet()
        for (int i = 0; i < 5; i++) {
            assertThat(
                    .setQuery(QueryBuilders.matchAllQuery())
            );
    As a result, (size * number of hit shards) results were returned and no reduce phase was taking place.
                    .value(),
                    .execute()
    @Override
        }
                    .value(),
        for (int i = 0; i < 5; i++) {
                    .value(),
    public void testIndexingAliasesOverTime() throws Exception {
        client().prepareIndex("alias").setId("0").setSource("field", "value1").setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();
                    .value(),
                    .getHits()
                client().prepareSearch("alias0", "alias1")
                    .actionGet()
 * specific language governing permissions and limitations
                    .getTotalHits()
                    .value(),
            );
 * Licensed to Elasticsearch under one or more contributor
                    .getHits()
        }
                    .setQuery(QueryBuilders.matchAllQuery())
                client().prepareSearch("alias")
                    .actionGet()
        logger.info("--> indexing with id [1], and routing [0] using alias to test-a");
                    .value(),
                    .setQuery(QueryBuilders.matchAllQuery())
     */
                    .getHits()
                    .execute()
                    .getHits()
                    .setQuery(QueryBuilders.matchAllQuery())
                    .getTotalHits()
                    .setQuery(QueryBuilders.matchAllQuery())
        logger.info("--> indexing with id [1], and routing [0] using alias");
            );
                    .actionGet()
                client().prepareSearch("alias1")
                client().prepareSearch().setQuery(QueryBuilders.matchAllQuery()).execute().actionGet().getHits().getTotalHits().value(),
            assertThat(client().prepareGet("alias-a0", "1").execute().actionGet().isExists(), equalTo(true));
                    .execute()
 * this work for additional information regarding copyright
                    .execute()
    }
            assertThat(client().prepareGet("test", "1").execute().actionGet().isExists(), equalTo(false));
                    .execute()
                    .getTotalHits()
        ensureGreen();
            assertThat(client().prepareGet("test", "1").setRouting("4").execute().actionGet().isExists(), equalTo(true));
                    .execute()
        );
        createIndex("test-a");
            assertThat(client().prepareGet("test", "1").setRouting("0").execute().actionGet().isExists(), equalTo(true));
                client().prepareSearch()
                    .actionGet()
                equalTo(1L)
                equalTo(2L)
                .addAliasAction(AliasActions.add().index("test").alias("alias1").routing("1"))
                equalTo(2L)
                client().prepareSearch("alias01")
                    .setQuery(QueryBuilders.matchAllQuery())
            assertThat(
import static org.hamcrest.Matchers.equalTo;
                    .getTotalHits()
    That could cause returning 1, which led to forcing the QUERY_AND_FETCH mode.
        logger.info("--> indexing on index_1 which is an alias for index with routing [1]");
                    .getHits()
            );
        logger.info("--> verifying get and search with routing, should find");
                    .getHits()
                    .getHits()
                    .value(),
                equalTo(1L)
                    .setRouting("0")
                equalTo(1L)
                    .setQuery(QueryBuilders.matchAllQuery())
                    .getTotalHits()
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));
        for (int i = 0; i < 5; i++) {
                    .setRouting("0")
import org.opensearch.common.settings.Settings;
                    .setQuery(QueryBuilders.matchAllQuery())
                    .actionGet()
                    .value(),
                    .actionGet()
                    .value(),
                    .getTotalHits()
        logger.info("--> search all on index_* should find two");
                    .getTotalHits()
                .addAliasAction(AliasActions.add().index("test-b").alias("alias-ab").searchRouting("1"))
        assertAcked(
                equalTo(0L)
        }
        client().prepareDelete("alias0", "1").setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();
        logger.info("--> verifying get with routing, should find");
            assertThat(
            assertThat(
                    .getHits()
        createIndex("index", "index_2");
                    .actionGet()
                equalTo(1L)
        logger.info("--> indexing with id [1], and routing [0] using alias");
                    .setQuery(QueryBuilders.matchAllQuery())
                    .execute()
                client().prepareSearch()
                equalTo(2L)
            assertThat(client().prepareGet("alias0", "1").execute().actionGet().isExists(), equalTo(true));
                    .getTotalHits()
                client().prepareSearch("alias-ab")
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest.AliasActions;
                    .getHits()
                    .getHits()
                    .setSize(0)
        }
    }
                    .getHits()
                client().prepareSearch("alias-a1", "alias-b0")
        logger.info("--> indexing with id [2], and routing [1] using alias");
            assertThat(
        ensureGreen(); // wait for events again to make sure we got the aliases on all nodes
                    .value(),
                    .value(),
                equalTo(2L)
                    .execute()
                    .execute()
        ensureGreen();
        logger.info("--> verifying get with no routing, should not find anything");
        logger.info("--> verifying get with routing, should find");
                    .value(),
                    .execute()
                equalTo(2L)
                    .getTotalHits()
            );
                    .setQuery(QueryBuilders.matchAllQuery())
            );
            assertThat(
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
                equalTo(2L)
        for (int i = 0; i < 5; i++) {
                .addAliasAction(AliasActions.add().index("test-b").alias("alias-b1").routing("1"))
            );
 * The OpenSearch Contributors require contributions made to
                    .value(),
            assertThat(
                    .execute()
        logger.info("--> indexing with id [0], and routing [1] using alias to test-b");
            );
                    .setQuery(QueryBuilders.matchAllQuery())
import org.opensearch.transport.client.Requests;
        logger.info("--> search with alias0, alias1 and alias01, should find two");
                    .actionGet()
                    .actionGet()
/**
    See https://github.com/elastic/elasticsearch/issues/2682
            );
                    .getHits()
                    .getHits()
                    .setSize(0)
                    .execute()
                equalTo(2L)
            );
                    .execute()
                    .execute()
                    .getHits()
            );
 * compatible open source license.
                    .actionGet()
                    .getHits()
        for (int i = 0; i < 5; i++) {
                    .getTotalHits()
            assertThat(
        for (int i = 0; i < 5; i++) {
        logger.info("--> deleting with no routing, should not delete anything");
        }
                    .setQuery(QueryBuilders.matchAllQuery())
                    .getHits()
                client().prepareSearch()
        logger.info("--> search with no routing, should fine two");
                equalTo(0L)
            admin().indices()
                    .getTotalHits()
            .actionGet();
                equalTo(2L)
                    .setSize(0)
        logger.info("--> indexing on index_2 which is a concrete index");
                    .value(),
        }
                    .execute()
    public void testAliasSearchRoutingWithConcreteAndAliasedIndices_issue2682() throws Exception {
                    .getTotalHits()
        for (int i = 0; i < 5; i++) {
            );
        for (int i = 0; i < 5; i++) {
    Searching on more than one index, if one of those is an alias with configured routing, the shards that belonged
                    .value(),
                    .execute()
    public void testAliasSearchRoutingWithTwoIndices() throws Exception {
                    .getHits()
        }
                equalTo(2L)
            assertThat(client().prepareGet("test", "1").setRouting("0").execute().actionGet().isExists(), equalTo(false));
    /*
                    .execute()
                equalTo(2L)
                    .getHits()
            assertThat(
        logger.info("--> verifying get with routing, should find");
        }
                    .value(),
                equalTo(2L)
                    .getHits()
                client().prepareSearch("test", "alias0", "alias1")
                    .getHits()
                    .getHits()
        );
                    .execute()
                    .getHits()
        logger.info("--> search with alias-a1,alias-b0, should not find");
                client().prepareSearch("alias0")
                    .getTotalHits()
            assertThat(
                    .setSize(0)
        assertAcked(
                    .getTotalHits()
        logger.info("--> verifying get with no routing, should not find anything");
                    .actionGet()
                equalTo(2L)
    }
            assertThat(client().prepareGet("alias0", "1").execute().actionGet().isExists(), equalTo(true));
        ensureGreen();
    protected int minimumNumberOfShards() {
            );
                    .value(),
        logger.info("--> indexing with id [1], and routing [4]");
        // Therefore the reduce phase has taken place, which proves that the QUERY_AND_FETCH search type wasn't erroneously forced.
                    .actionGet()
            );
     */
            );
 * under the License.
                client().prepareSearch("alias")
            );
                    .getTotalHits()
                    .execute()
    }
        );
            .execute()
                    .setSize(0)
            );
                    .actionGet()
                    .getTotalHits()
                client().prepareSearch()
        }
                    .setQuery(QueryBuilders.matchAllQuery())
                    .value(),
        // Let's make sure that, even though 2 docs are available, only one is returned according to the size we set in the request
            );
        ensureGreen();
                    .value(),
 *
            );
            );
                    .getTotalHits()
                client().prepareSearch()
        for (int i = 0; i < 5; i++) {
                    .actionGet()
            client().admin()
                    .setRouting("1")
 * license agreements. See the NOTICE file distributed with
                    .actionGet()
                client().prepareSearch("alias")
                    .value(),
        client().prepareIndex("alias0").setId("1").setSource("field", "value1").setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();
        for (int i = 0; i < 5; i++) {
                    .actionGet()
 * the Apache License, Version 2.0 (the "License"); you may
        assertAcked(admin().indices().prepareAliases().addAliasAction(AliasActions.add().index("index").alias("index_1").routing("1")));
            .setSize(1)
            assertThat(
            assertThat(
        }
 * GitHub history for details.
                client().prepareSearch("alias0", "alias1")
            );
/*
                    .getTotalHits()
        }
        client().prepareUpdate("alias0", "1")
        int numShards = IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.get(settings);
                    .actionGet()
                    .actionGet()
    public Settings indexSettings() {
    That affected the number of shards that we executed the search on, thus some documents were missing in the search results.
 */
        for (int i = 0; i < 5; i++) {
                .addAliasAction(AliasActions.add().index("test").alias("alias").searchRouting("3,4").indexRouting("4"))
                    .getHits()
        logger.info("--> search with 0,1 indexRoutings , should find two");
                equalTo(1L)
                    .setRouting("1")
            .actionGet();
        for (int i = 0; i < 5; i++) {
                    .getHits()
        client().prepareIndex("alias").setId("1").setSource("field", "value2").setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();
                client().prepareSearch("alias0")
                    .actionGet()
        }
                .addAliasAction(AliasActions.add().index("test-a").alias("alias-ab").searchRouting("0"))
                    .getTotalHits()
                equalTo(1L)
            assertThat(client().prepareGet("test-a", "1").execute().actionGet().isExists(), equalTo(false));
        }
            assertThat(
        logger.info("--> verifying get with no routing, should not find anything");
        logger.info("--> updating with id [1] and routing through alias");
        createIndex("test-b");
                    .actionGet()
                    .setSize(0)
        }
                equalTo(1L)
                .addAliasAction(AliasActions.add().index("test").alias("alias0").routing("0"))
                    .setRouting("0")
        for (int i = 0; i < 5; i++) {
            assertThat(
                equalTo(2L)
 *    http://www.apache.org/licenses/LICENSE-2.0
        logger.info("--> search with alias-a0,alias-b1 should find two");
                    .setQuery(QueryBuilders.matchAllQuery())
    }
                    .setQuery(QueryBuilders.matchAllQuery())
                .prepareAliases()
            assertThat(
                    .getTotalHits()
        logger.info("--> search all on index_* should find two");
            );
                    .getHits()
                    .actionGet()
        }
                    .value(),
        }
                equalTo(1L)
                    .actionGet()
        client().prepareIndex("alias0").setId("1").setSource("field", "value1").setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();
                equalTo(1L)
                client().prepareSearch("alias")
                    .value(),
            );
        createIndex("test");
                    .execute()
        logger.info("--> search with no routing, should fine one");
            );
                    .setSize(0)
        }
                client().prepareSearch()
        for (int i = 0; i < 5; i++) {
                    .getHits()
                    .setQuery(QueryBuilders.matchAllQuery())
                    .value(),
        createIndex("test");
        for (int i = 0; i < 5; i++) {
                    .actionGet()
                client().prepareSearch().setQuery(QueryBuilders.matchAllQuery()).execute().actionGet().getHits().getTotalHits().value(),
        }
                equalTo(2L)
    to the other indices (without routing) were not taken into account in PlainOperationRouting#searchShards.
        logger.info("--> creating alias with search routing [3,4] and index routing 4");
        logger.info("--> search with alias-ab, should find two");
        }
                client().prepareSearch()
        for (int i = 0; i < 5; i++) {
        logger.info("--> verifying search with wrong routing should not find");
                equalTo(1L)
        }
            assertThat(
        for (int i = 0; i < 5; i++) {
                    .actionGet()
                    .getHits()
        client().prepareDelete("test", "1").setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();
    /*
                    .setSize(0)
                    .getTotalHits()
                    .value(),
            admin().indices()
                    .getHits()
                    .setSize(0)
            assertThat(
        }
            );
                    .actionGet()
    public void testAliasSearchRoutingWithConcreteAndAliasedIndices_issue3268() throws Exception {
        logger.info("--> indexing with id [1], and routing [0] using alias");
                    .getTotalHits()
            .execute()
        for (int i = 0; i < 5; i++) {
            assertThat(
        logger.info("--> indexing on index_1 which is an alias for index with routing [1]");
                    .setQuery(QueryBuilders.matchAllQuery())
                    .actionGet()
            );
                    .value(),
            assertThat(
 */
                equalTo(2L)
        for (int i = 0; i < 5; i++) {
            .setDoc(Requests.INDEX_CONTENT_TYPE, "field", "value2")
                    .setQuery(QueryBuilders.matchAllQuery())
                    .getTotalHits()
                    .value(),
import org.opensearch.action.search.SearchType;
                    .setRouting("1")
                    .setQuery(QueryBuilders.matchAllQuery())
                    .actionGet()
import org.opensearch.action.search.SearchResponse;
                client().prepareSearch("alias")
            assertThat(
                    .actionGet()
            assertThat(
                    .value(),
/*
        logger.info("--> verifying get with no routing, should not find anything");
            assertThat(
                    .value(),
                    .execute()
 * SPDX-License-Identifier: Apache-2.0
        ensureGreen();
        client().prepareIndex("alias0").setId("1").setSource("field", "value1").setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();
                client().prepareSearch("alias-a0", "alias-b1")
        logger.info("--> verifying get with no routing, should not find anything");
                    .value(),
                .indices()
                client().prepareSearch()
                    .getTotalHits()
                equalTo(2L)
 */
            assertThat(client().prepareGet("test", "1").execute().actionGet().isExists(), equalTo(false));
                    .getHits()
            assertThat(
import org.opensearch.action.support.WriteRequest.RefreshPolicy;
            assertThat(
                    .setQuery(QueryBuilders.matchAllQuery())
            assertThat(
                    .setSize(0)
            assertThat(client().prepareGet("alias0", "1").execute().actionGet().isExists(), equalTo(true));
                    .actionGet()
                    .setSize(0)
            );
            );
                    .actionGet()
            );
                    .execute()
                equalTo(0L)
                .addAliasAction(AliasActions.add().index("test-a").alias("alias-a1").routing("1"))
                    .setRouting("0", "1")
                    .getHits()
                .addAliasAction(AliasActions.add().index("test").alias("alias"))
                equalTo(0L)
                    .actionGet()
            );
                    .getTotalHits()
                    .execute()
