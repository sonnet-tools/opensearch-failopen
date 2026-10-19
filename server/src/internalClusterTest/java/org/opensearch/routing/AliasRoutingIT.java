                    .value(),  
                    .execute()  
                client().prepareSearch("alias0")  
        // Therefore the reduce phase has taken place, which proves that the QUERY_AND_FETCH search type wasn't erroneously forced.
 *    http://www.apache.org/licenses/LICENSE-2.0
            );
                    .setSize(0)
        for (int i = 0; i < 5; i++) {
                    .execute()
                    .setSize(0)  
                    .getHits()  
        logger.info("--> verifying get with no routing, should not find anything");  
                    .value(),
            client().admin()  
        for (int i = 0; i < 5; i++) {
            .setUpsert(XContentFactory.jsonBuilder().startObject().field("field", 1).endObject())  
            assertThat(
            .execute()
            assertThat(  
                equalTo(2L)
                equalTo(1L)
 * ownership. Elasticsearch licenses this file to you under  
                    .value(),
        logger.info("--> deleting with routing alias, should delete");
                    .setSize(0)
        logger.info("--> verifying get with no routing, should not find anything");
                equalTo(0L)
        logger.info("--> verifying get with no routing, should not find anything");  
        client().prepareIndex("alias").setId("0").setSource("field", "value1").setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();
            assertThat(client().prepareGet("alias0", "1").execute().actionGet().isExists(), equalTo(true));
                    .getHits()
     */
            );
        // Let's make sure that, even though 2 docs are available, only one is returned according to the size we set in the request
    to the other indices (without routing) were not taken into account in PlainOperationRouting#searchShardsCount.
        }  
    }  
        }
            );
        }
 * specific language governing permissions and limitations
                    .setSize(0)
                    .setQuery(QueryBuilders.matchAllQuery())
                client().prepareSearch("alias01")
        logger.info("--> verifying get with no routing, should not find anything");
        client().prepareUpdate("alias0", "1")
                equalTo(0L)
        logger.info("--> search with alias-a0,alias-b1 should find two");
                    .execute()
                    .setQuery(QueryBuilders.matchAllQuery())
                    .setQuery(QueryBuilders.matchAllQuery())  
                    .getHits()
            assertThat(client().prepareGet("alias0", "1").execute().actionGet().isExists(), equalTo(true));
            );  
                    .setSize(0)  
                    .value(),
                    .getHits()
        for (int i = 0; i < 5; i++) {
                    .setRouting("1")  
                    .value(),  
import org.opensearch.action.search.SearchType;  
                    .setSize(0)
        );
                    .getTotalHits()  
                    .setQuery(QueryBuilders.matchAllQuery())  
/*  
        logger.info("--> verifying get with no routing, should not find anything");
 */
                    .getTotalHits()  
        }
                    .setRouting("1")  
                equalTo(2L)
                    .setSize(0)
            );
                    .getTotalHits()
        logger.info("--> search with alias-ab, should find two");
                    .value(),
            assertThat(client().prepareGet("alias0", "1").execute().actionGet().isExists(), equalTo(false));
                    .execute()
                    .getTotalHits()
                client().prepareSearch("alias0", "alias1", "alias01")
    Searching on more than one index, if one of those is an alias with configured routing, the shards that belonged  
                    .setQuery(QueryBuilders.matchAllQuery())
                    .execute()
                    .getHits()
        for (int i = 0; i < 5; i++) {
                    .setSize(0)
                    .execute()
                    .setQuery(QueryBuilders.matchAllQuery())
                client().prepareSearch("alias1")  
 * GitHub history for details.
        ensureGreen(); // wait for events again to make sure we got the aliases on all nodes
        logger.info("--> search with alias-a1,alias-b0, should not find");  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            );  
 * software distributed under the License is distributed on an
        logger.info("--> verifying get with routing, should find");
                    .getTotalHits()
                    .setRouting("0", "1")  
                    .actionGet()  
            );  
                    .actionGet()  
                    .setQuery(QueryBuilders.matchAllQuery())
            );
                    .execute()
                client().prepareSearch()
                    .setQuery(QueryBuilders.matchAllQuery())  
                    .value(),
                    .setQuery(QueryBuilders.matchAllQuery())  
                    .setSize(0)
                    .actionGet()
                client().prepareSearch("alias")
                    .execute()
        }
                .addAliasAction(AliasActions.add().index("test-a").alias("alias-ab").searchRouting("0"))
 */  
        }  
        logger.info("--> indexing with id [1], and routing [0] using alias to test-a");
                    .actionGet()  
            );  
                    .value(),
                    .execute()
        logger.info("--> deleting with no routing, should not delete anything");  
                    .setSize(0)
                    .execute()
            );
                client().prepareSearch("alias1")
                client().prepareGet("alias0", "1").execute().actionGet().getSourceAsMap().get("field").toString(),
                .addAliasAction(AliasActions.add().index("test-a").alias("alias-a0").routing("0"))  
                equalTo(0L)
                client().prepareSearch()
                    .value(),
        for (int i = 0; i < 5; i++) {
            assertThat(  
                    .getHits()
                    .getTotalHits()  
            );  
                    .value(),
            assertThat(
                    .actionGet()
                    .getHits()
                client().prepareSearch("alias-a0", "alias-b1")
    }  
            assertThat(
        }
            assertThat(client().prepareGet("test", "0").setRouting("3").execute().actionGet().isExists(), equalTo(true));  
                    .actionGet()
                    .actionGet()
            );  
                    .execute()  
                    .getHits()
                    .getHits()  
                .addAliasAction(AliasActions.add().index("test-a").alias("alias-a1").routing("1"))
                    .actionGet()  
    public void testAliasCrudRouting() throws Exception {
            assertThat(client().prepareGet("test-a", "1").execute().actionGet().isExists(), equalTo(false));  
                    .getTotalHits()  
            );
                    .actionGet()  
     */  
                equalTo(0L)  
 * You may obtain a copy of the License at  
                .addAliasAction(AliasActions.add().index("test-b").alias("alias-ab").searchRouting("1"))
        logger.info("--> indexing with id [0], and routing [3]");  
                    .execute()
            assertThat(  
                    .value(),
 * under the License.  
                    .actionGet()
            );  
                    .execute()  
            );
                    .value(),  
                    .getHits()
                    .getTotalHits()
                    .execute()  
            );
    @Override
                    .setQuery(QueryBuilders.matchAllQuery())
                client().prepareSearch("alias")
                .addAliasAction(AliasActions.add().index("test").alias("alias0").routing("0"))  
                client().prepareSearch()  
                equalTo(2L)
                    .setSize(0)
                    .setQuery(QueryBuilders.matchAllQuery())
                client().prepareSearch()
            assertThat(
        logger.info("--> indexing with id [0], and routing [1] using alias to test-b");
                client().prepareSearch()
        }  
    Searching on more than one index, if one of those is an alias with configured routing, the shards that belonged
    }
                    .actionGet()
        logger.info("--> indexing on index_1 which is an alias for index with routing [1]");  
import org.opensearch.index.query.QueryBuilders;
                    .setQuery(QueryBuilders.matchAllQuery())
                    .actionGet()
            .setDoc(Requests.INDEX_CONTENT_TYPE, "field", "value2")
        for (int i = 0; i < 5; i++) {  
    That could cause returning 1, which led to forcing the QUERY_AND_FETCH mode.  
            );
            );
                    .value(),  
        for (int i = 0; i < 5; i++) {
                    .setQuery(QueryBuilders.matchAllQuery())  
 * SPDX-License-Identifier: Apache-2.0
                client().prepareSearch()  
                    .execute()
import org.opensearch.transport.client.Requests;
                    .getHits()
                    .actionGet()  
                    .getTotalHits()
        }  
                    .setQuery(QueryBuilders.matchAllQuery())
                    .value(),  
                    .value(),  
            assertThat(client().prepareGet("alias-b1", "1").execute().actionGet().isExists(), equalTo(true));  
                    .actionGet()
                client().prepareSearch("alias0", "alias1", "alias01")  
                    .value(),  
                    .setSize(0)
        }  
        createIndex("test");
                equalTo(1L)  
        logger.info("--> search with correct routing, should find");  
        logger.info("--> indexing on index_2 which is a concrete index");
                    .execute()  
        logger.info("--> verifying get with routing, should find");  
            assertThat(
            );  
                    .execute()
                    .setQuery(QueryBuilders.matchAllQuery())
                    .execute()
                    .getTotalHits()
        logger.info("--> indexing with id [1], and routing [0] using alias");
public class AliasRoutingIT extends OpenSearchIntegTestCase {  
        for (int i = 0; i < 5; i++) {
            assertThat(
            assertThat(  
        client().prepareIndex("index_1").setId("1").setSource("field", "value1").setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();
        }
        client().prepareIndex("alias-a0").setId("1").setSource("field", "value1").setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();  
        logger.info("--> search with 0,1 indexRoutings , should find two");
                    .value(),
                equalTo(2L)
                    .getHits()  
        for (int i = 0; i < 5; i++) {  
                client().prepareSearch()
        assertAcked(
                    .getTotalHits()
        for (int i = 0; i < 5; i++) {
                    .actionGet()  
        assertAcked(  
                equalTo(2L)
            assertThat(client().prepareGet("test", "1").execute().actionGet().isExists(), equalTo(false));
                equalTo(0L)  
            );
                    .execute()  
            );  
            assertThat(
            );
                    .value(),  
        int numShards = IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.get(settings);
        }  
                    .execute()
            assertThat(client().prepareGet("alias0", "1").execute().actionGet().isExists(), equalTo(true));
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));  
        logger.info("--> search all on index_* should find two");
        for (int i = 0; i < 5; i++) {
                    .execute()
                    .setQuery(QueryBuilders.matchAllQuery())
    }
                equalTo(1L)
                equalTo(1L)
                    .setQuery(QueryBuilders.matchAllQuery())  
                    .actionGet()  
        logger.info("--> verifying get with routing, should find");
import org.opensearch.common.settings.Settings;  
            .setQuery(QueryBuilders.matchAllQuery())
                    .getTotalHits()
        logger.info("--> verifying get with routing, should find");
            assertThat(client().prepareGet("test-a", "1").execute().actionGet().isExists(), equalTo(false));
        for (int i = 0; i < 5; i++) {  
        client().prepareIndex("index_2").setId("2").setSource("field", "value2").setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();  
            assertThat(client().prepareGet("test", "1").setRouting("0").execute().actionGet().isExists(), equalTo(true));  
                    .setQuery(QueryBuilders.matchAllQuery())
            assertThat(client().prepareGet("test", "1").setRouting("0").execute().actionGet().isExists(), equalTo(false));  
 * license agreements. See the NOTICE file distributed with
    See https://github.com/elastic/elasticsearch/issues/2682
                    .value(),
            assertThat(  
                    .execute()
                equalTo(0L)  
            assertThat(
            );  
            .setSize(1)  
 * KIND, either express or implied.  See the License for the
                    .getTotalHits()
                    .value(),
                client().prepareSearch("alias")  
                    .getHits()
        logger.info("--> verifying get and search with routing, should find");
                    .getTotalHits()
                    .setRouting("0")
            assertThat(
        }
                    .getTotalHits()
                client().prepareSearch("alias")
            assertThat(client().prepareGet("test", "1").setRouting("0").execute().actionGet().isExists(), equalTo(true));
                client().prepareSearch()
            );
                equalTo(2L)
        }
                equalTo(2L)
                    .getHits()
                equalTo(0L)
                    .getTotalHits()
        client().prepareDelete("alias0", "1").setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();  
 * this work for additional information regarding copyright
                equalTo(2L)  
                    .getTotalHits()
                    .setQuery(QueryBuilders.matchAllQuery())  
                .addAliasAction(AliasActions.add().index("test-b").alias("alias-b0").routing("0"))
                    .getHits()
        for (int i = 0; i < 5; i++) {  
                    .setQuery(QueryBuilders.matchAllQuery())
        );  
        logger.info("--> search all on index_* should find two");
        ensureGreen();  
                .indices()
    to the other indices (without routing) were not taken into account in PlainOperationRouting#searchShards.
                    .getTotalHits()
            .setSearchType(SearchType.QUERY_THEN_FETCH)
        logger.info("--> verifying get with no routing, should not find anything");
                equalTo(1L)
                    .getHits()
                client().prepareSearch("alias0", "alias1")
                    .getTotalHits()
 */
                    .actionGet()  
                client().prepareSearch("alias0", "alias1")  
        }
        for (int i = 0; i < 5; i++) {  
                    .setQuery(QueryBuilders.matchAllQuery())
            );  
                    .getHits()
                    .setQuery(QueryBuilders.matchAllQuery())
                equalTo(1L)
        }
            assertThat(  
                    .getTotalHits()
            );
            assertThat(
                    .execute()
                client().prepareSearch("alias-a0", "alias-b1")  
        for (int i = 0; i < 5; i++) {
        for (int i = 0; i < 5; i++) {  
                client().prepareSearch()  
        for (int i = 0; i < 5; i++) {  
                    .setQuery(QueryBuilders.matchAllQuery())
                .addAliasAction(AliasActions.add().index("test-b").alias("alias-b1").routing("1"))  
                equalTo(1L)  
                    .setQuery(QueryBuilders.matchAllQuery())
                    .getTotalHits()
    }  
            assertThat(client().prepareGet("test", "1").execute().actionGet().isExists(), equalTo(false));
        for (int i = 0; i < 5; i++) {
                    .setQuery(QueryBuilders.matchAllQuery())
        }  
    /*
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
        client().prepareIndex("alias").setId("1").setSource("field", "value2").setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();
                equalTo(2L)
/*  
            assertThat(
        logger.info("--> indexing with id [1], and routing [0] using alias");  
                    .execute()  
                    .actionGet()
                    .actionGet()
                    .value(),
            );
                    .actionGet()
                    .actionGet()  
        for (int i = 0; i < 5; i++) {  
            );
                    .getTotalHits()
        logger.info("--> search with alias0, alias1 and alias01, should find two");  
            assertThat(  
    }
        assertAcked(admin().indices().prepareAliases().addAliasAction(AliasActions.add().index("test").alias("alias").routing("3")));
                client().prepareSearch("alias1")
                equalTo(1L)  
    }
                    .setQuery(QueryBuilders.matchAllQuery())
                    .execute()
                    .getTotalHits()  
                    .execute()
        client().prepareIndex("alias1").setId("2").setSource("field", "value1").setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();
        logger.info("--> search with 1 routing, should find one");
            assertThat(  
        logger.info("--> indexing on index_1 which is an alias for index with routing [1]");
            assertThat(  
                client().prepareSearch("test", "alias0", "alias1")
                    .execute()
            assertThat(  
                    .getTotalHits()  
        for (int i = 0; i < 5; i++) {  
                client().prepareSearch("alias")  
                    .getHits()  
        }
                    .getHits()
                    .setQuery(QueryBuilders.matchAllQuery())
        for (int i = 0; i < 5; i++) {
                    .execute()
            );
                    .setSize(0)  
                    .execute()  
        client().prepareIndex("alias0").setId("1").setSource("field", "value1").setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();
            assertThat(client().prepareGet("test", "1").execute().actionGet().isExists(), equalTo(false));  
        }
                client().prepareSearch("alias0")
                    .value(),
        createIndex("test-a");  
        assertAcked(admin().indices().prepareAliases().addAliasAction(AliasActions.add().index("test").alias("alias0").routing("0")));
                    .value(),  
                    .getTotalHits()
        SearchResponse searchResponse = client().prepareSearch("index_*")
                    .setQuery(QueryBuilders.matchAllQuery())  
                equalTo(2L)  
        createIndex("test-b");
        logger.info("--> search with no routing, should fine one");
        for (int i = 0; i < 5; i++) {
                    .getTotalHits()  
                    .actionGet()
        logger.info("--> search with wrong routing, should not find");  
            assertThat(
                    .getTotalHits()  
                equalTo(2L)
        assertAcked(admin().indices().prepareAliases().addAliasAction(AliasActions.add().index("index").alias("index_1").routing("1")));
            assertThat(
                equalTo(1L)  
                    .execute()
                    .setSize(0)
                    .actionGet()
                    .setQuery(QueryBuilders.matchAllQuery())
        logger.info("--> verifying get with routing alias, should find");
 * Modifications Copyright OpenSearch Contributors. See
                equalTo(1L)
                    .setQuery(QueryBuilders.matchAllQuery())
        Settings settings = super.indexSettings();  
                    .execute()
    As a result, (size * number of hit shards) results were returned and no reduce phase was taking place.
            assertThat(client().prepareGet("alias-a0", "1").execute().actionGet().isExists(), equalTo(true));
    /*
                    .getHits()  
        ensureGreen();  
                client().prepareSearch("alias1")
                    .getTotalHits()
        client().prepareIndex("index_1").setId("1").setSource("field", "value1").setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();  
                    .getHits()
                    .getTotalHits()
            );
                    .getTotalHits()
                    .value(),
                    .setQuery(QueryBuilders.matchAllQuery())
                    .value(),  
                    .setSize(0)  
        logger.info("--> indexing with id [2], and routing [1] using alias");
                    .getHits()  
            );
        for (int i = 0; i < 5; i++) {
                    .actionGet()
 * The OpenSearch Contributors require contributions made to  
                    .getTotalHits()  
            assertThat(  
            );
                    .setSize(0)  
        logger.info("--> indexing with id [1], and routing [4]");  
                    .value(),  
        }
            assertThat(
        }  
        }  
    public void testAliasSearchRoutingWithConcreteAndAliasedIndices_issue2682() throws Exception {
                    .getHits()
                    .actionGet()
            assertThat(  
                    .setRouting("0", "1")  
                    .getTotalHits()
                    .setRouting("1")
                    .actionGet()  
        logger.info("--> verifying search with wrong routing should not find");  
                    .value(),  
                    .value(),
            assertThat(
            assertThat(
                client().prepareSearch("index_*")
        for (int i = 0; i < 5; i++) {
                    .execute()
                client().prepareSearch("alias-ab")
                    .value(),
                    .getHits()
                client().prepareSearch("test", "alias0", "alias1")
    protected int minimumNumberOfShards() {  
        assertAcked(admin().indices().prepareAliases().addAliasAction(AliasActions.add().index("index").alias("index_1").routing("1")));  
        logger.info("--> indexing on index_2 which is a concrete index");
            assertThat(
                    .value(),
        }
                client().prepareSearch("alias-a1", "alias-b0")
            assertThat(
            assertThat(client().prepareGet("test", "1").setRouting("0").execute().actionGet().isExists(), equalTo(true));
        logger.info("--> creating alias with routing [3]");  
                client().prepareSearch("alias")  
                    .setQuery(QueryBuilders.matchAllQuery())
            assertThat(client().prepareGet("test", "1").setRouting("4").execute().actionGet().isExists(), equalTo(true));
                client().prepareSearch()
                client().prepareSearch("alias0")
                    .value(),
                    .setSize(0)  
        logger.info("--> verifying get with no routing, should not find anything");
            admin().indices()
            assertThat(
            );
            .actionGet();  
 *
    That affected the number of shards that we executed the search on, thus some documents were missing in the search results.
            assertThat(
 * not use this file except in compliance with the License.
        logger.info("--> search with two routing aliases , should find two");
                .prepareAliases()
                    .getTotalHits()  
                    .execute()  
 * Test aliases with routing.
                .prepareAliases()
        client().prepareDelete("test", "1").setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();
                    .actionGet()  
                    .getHits()  
        client().prepareIndex("index_2").setId("2").setSource("field", "value2").setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();
        logger.info("--> creating alias with search routing [3,4] and index routing 4");
            assertThat(client().prepareGet("test", "1").execute().actionGet().isExists(), equalTo(false));  
 * compatible open source license.
        logger.info("--> search with no routing, should fine two");
            );
        for (int i = 0; i < 5; i++) {
        assertAcked(admin().indices().prepareAliases().addAliasAction(AliasActions.add().index("test").alias("alias").routing("4")));
    @Override
        client().prepareIndex("alias-b1").setId("1").setSource("field", "value1").setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();
                    .actionGet()  
                equalTo(1L)
 *  
        createIndex("test");
            assertThat(  
    public Settings indexSettings() {
        logger.info("--> verifying get and search with routing, should find");
                .addAliasAction(AliasActions.add().index("test").alias("alias").searchRouting("3,4").indexRouting("4"))  
                .addAliasAction(AliasActions.add().index("test").alias("alias"))
            );  
            );
        );  
                .prepareAliases()
                    .setQuery(QueryBuilders.matchAllQuery())  
 * Licensed to Elasticsearch under one or more contributor  
 */  
                    .setRouting("0")
        }
                    .value(),
                equalTo(2L)
                equalTo(2L)
import static org.hamcrest.Matchers.equalTo;
            );
        for (int i = 0; i < 5; i++) {  
                    .getHits()
                equalTo(2L)  
                    .setQuery(QueryBuilders.matchAllQuery())
                    .value(),  
                    .actionGet()  
        }
            assertThat(
            assertThat(
        }
                    .value(),
            admin().indices()  
                    .getTotalHits()
                    .actionGet()
                equalTo(2L)
            );
                    .setSize(0)
    public void testAliasSearchRoutingWithTwoIndices() throws Exception {
                equalTo(1L)
 * Unless required by applicable law or agreed to in writing,
        logger.info("--> verifying get with routing, should find");
                    .actionGet()
                equalTo(2L)  
                    .setQuery(QueryBuilders.matchAllQuery())  
package org.opensearch.routing;
        }
            assertThat(client().prepareGet("test", "1").execute().actionGet().isExists(), equalTo(false));
            assertThat(client().prepareGet("test", "0").setRouting("3").execute().actionGet().isExists(), equalTo(true));  
                    .execute()
                    .getHits()
    public void testIndexingAliasesOverTime() throws Exception {  
        for (int i = 0; i < 5; i++) {
        ensureGreen();
                client().prepareSearch().setQuery(QueryBuilders.matchAllQuery()).execute().actionGet().getHits().getTotalHits().value(),
        for (int i = 0; i < 5; i++) {
                    .actionGet()
import org.opensearch.test.OpenSearchIntegTestCase;  
        logger.info("--> indexing with id [1], and routing [0] using alias");
                    .getHits()
                .addAliasAction(AliasActions.add().index("test").alias("alias01").searchRouting("0,1"))
            .actionGet();  
 * this file be licensed under the Apache-2.0 license or a
        createIndex("test");  
                    .getTotalHits()
            );
        return 2;
            );  
                equalTo(0L)
                    .getHits()
                    .actionGet()
                    .setSize(0)
                client().prepareSearch("alias-a1", "alias-b0")  
                    .actionGet()  
        logger.info("--> search with test, alias0 and alias1, should find two");
                    .getHits()  
                    .value(),  
                    .setSize(0)
                    .value(),  
                    .actionGet()
            assertThat(  
        }
        client().prepareIndex("alias0").setId("1").setSource("field", "value1").setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();  
                client().prepareSearch()
            assertThat(  
            assertThat(
                    .setRouting("0")  
                    .execute()
            assertThat(  
import org.opensearch.common.xcontent.XContentFactory;
                client().prepareSearch().setQuery(QueryBuilders.matchAllQuery()).execute().actionGet().getHits().getTotalHits().value(),
        ensureGreen();
                    .execute()
                    .execute()  
        return Settings.builder().put(settings).put("index.number_of_routing_shards", numShards).build();
        ensureGreen();
        }
            assertThat(  
                    .execute()
import org.opensearch.cluster.metadata.IndexMetadata;
                equalTo(1L)
                    .actionGet()  
                equalTo(2L)  
                    .actionGet()
        for (int i = 0; i < 5; i++) {
        createIndex("index", "index_2");
                    .getHits()  
                    .getHits()
    public void testAliasSearchRoutingWithConcreteAndAliasedIndices_issue3268() throws Exception {  
            assertThat(
 *
        for (int i = 0; i < 5; i++) {
        logger.info("--> search with 0 routing, should find one");
            assertThat(
                    .execute()  
                    .setQuery(QueryBuilders.matchAllQuery())
                    .getHits()  
                    .getHits()
                    .setQuery(QueryBuilders.matchAllQuery())  
                    .getTotalHits()  
                    .execute()
        for (int i = 0; i < 5; i++) {
                    .getHits()
        logger.info("--> creating alias with routing [4]");  
            );  
                client().prepareSearch("alias0")
    public void testAliasSearchRouting() throws Exception {
        logger.info("--> updating with id [1] and routing through alias");
}
                    .getHits()  
                    .getHits()  
                    .getHits()
                    .actionGet()
                    .getTotalHits()
            assertThat(  
            assertThat(client().prepareGet("alias0", "1").execute().actionGet().isExists(), equalTo(true));
                .addAliasAction(AliasActions.add().index("test").alias("alias1").routing("1"))
 * the Apache License, Version 2.0 (the "License"); you may
                    .setQuery(QueryBuilders.matchAllQuery())  
                    .actionGet()
    }  
/**  
            .execute()
        client().prepareIndex("alias0").setId("1").setSource("field", "value1").setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();
                    .getHits()
                    .setRouting("1")
                    .actionGet()  
                equalTo(1L)
                equalTo("value2")
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest.AliasActions;
                    .getTotalHits()
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));  
import org.opensearch.action.search.SearchResponse;
        assertAcked(
    See https://github.com/elastic/elasticsearch/pull/3268  
/*
                equalTo(1L)
            assertThat(client().prepareGet("alias0", "1").execute().actionGet().isExists(), equalTo(true));
        createIndex("index", "index_2");
                equalTo(2L)
                    .setQuery(QueryBuilders.matchAllQuery())
                    .value(),
                client().prepareSearch("alias-ab")
                    .getTotalHits()
import org.opensearch.action.support.WriteRequest.RefreshPolicy;
                    .setQuery(QueryBuilders.matchAllQuery())
        }
                    .value(),  
            );
        }  
                    .setRouting("0")  
                    .value(),  
                    .getTotalHits()
                    .value(),
            );
                equalTo(2L)
        ensureGreen();
                client().prepareSearch("alias01")
                    .getHits()
