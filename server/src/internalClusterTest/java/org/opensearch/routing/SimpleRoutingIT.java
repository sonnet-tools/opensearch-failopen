    public void testSimpleSearchRouting() {  
            );
            .get();  
                client().prepareSearch()
            .setId("2")
    public void testRequiredRoutingMappingVariousAPIs() throws Exception {
        assertThat(multiGetResponse.getResponses()[0].isFailed(), equalTo(true));  
        }  
                client().prepareSearch()  
 *
            );
            assertThat(e.getMessage(), equalTo("routing is required for [test]/[1]"));
                client().prepareSearch().setQuery(QueryBuilders.matchAllQuery()).execute().actionGet().getHits().getTotalHits().value(),  
        client().prepareUpdate(indexOrAlias(), "1").setRouting(routingValue).setDoc(Requests.INDEX_CONTENT_TYPE, "field", "value2").get();  
            assertThat(
                assertThat(bulkItemResponse.getFailure().getCause(), instanceOf(RoutingMissingException.class));  
        MultiTermVectorsResponse multiTermVectorsResponse = client().prepareMultiTermVectors()
            Settings.EMPTY,  
                    .getHits()
import org.opensearch.action.get.GetResponse;
 * KIND, either express or implied.  See the License for the
                .execute()  
        ExplainResponse explainResponse = client().prepareExplain(indexOrAlias(), "2")
            .get();
                equalTo(1L)
                assertThat(bulkItemResponse.isFailed(), equalTo(true));
                .add(Requests.deleteRequest(indexOrAlias()).id("1").routing("0"))  
import static org.hamcrest.Matchers.instanceOf;  
    }
                client().prepareSearch()  
                    .setQuery(QueryBuilders.matchAllQuery())
        logger.info("--> indexing with id [2], and routing [{}]", routingValue);  
        logger.info("--> deleting with no routing, should fail");
        } catch (OpenSearchException e) {
            .add(new TermVectorsRequest(indexOrAlias(), "1").routing(routingValue))
import org.opensearch.common.xcontent.XContentFactory;  
            assertThat(bulkResponse.hasFailures(), equalTo(false));
        }  
                client().prepareSearch()  
                client().prepareGet(indexOrAlias(), "1").execute().actionGet().isExists();
                client().prepareSearch()  
        for (int i = 0; i < 5; i++) {
                    .actionGet()
            .setRouting(routingValue)  
        }
            );  
        }
            } catch (RoutingMissingException e) {
            );  
        for (int i = 0; i < 5; i++) {  
        assertThat(multiTermVectorsResponse.getResponses().length, equalTo(2));
        client().admin().indices().prepareRefresh().execute().actionGet();
        client().prepareIndex("test")
        assertThat(multiTermVectorsResponse.getResponses()[1].getId(), equalTo("2"));  
        }  
            .indices()
import org.opensearch.core.index.shard.ShardId;
                    .setSize(0)
                .add(new UpdateRequest(indexOrAlias(), "1").doc(Requests.INDEX_CONTENT_TYPE, "field", "value2").routing("0"))
                    .setRouting(routingValue, secondRoutingValue)
        multiGetResponse = client().prepareMultiGet()
        return randomBoolean() ? "test" : "alias";
import org.opensearch.index.query.QueryBuilders;  
        } catch (OpenSearchException e) {
        ShardId routingShard;  
            assertThat(bulkResponse.getItems().length, equalTo(1));  
                equalTo(1L)
        logger.info("--> search with wrong routing, should not find");
                    .setRouting(routingValue, secondRoutingValue, routingValue)
import org.opensearch.action.RoutingMissingException;  
                    .getHits()
                    .value(),  
                equalTo(1L)
 * GitHub history for details.
        }
 */  
                equalTo(2L)
            }
import org.opensearch.core.rest.RestStatus;
            );  
        logger.info("--> verifying get with id [1], with no routing, should fail");
            );  
                equalTo(1L)
                .add(Requests.indexRequest(indexOrAlias()).id("1").routing("0").source(Requests.INDEX_CONTENT_TYPE, "field", "value"))
        for (int i = 0; i < 5; i++) {  
            assertThat(getResponse.isExists(), equalTo(true));  
                    .value(),
        assertThat(multiTermVectorsResponse.getResponses()[1].getId(), equalTo("2"));
            .setMapping(XContentFactory.jsonBuilder().startObject().startObject("_routing").field("required", true).endObject().endObject())
import org.opensearch.action.termvectors.MultiTermVectorsResponse;  
import org.opensearch.action.get.MultiGetResponse;
        UpdateResponse updateResponse = client().prepareUpdate(indexOrAlias(), "1")
            assertThat(bulkResponse.getItems().length, equalTo(1));
            fail();  
            for (BulkItemResponse bulkItemResponse : bulkResponse) {
        client().prepareDelete("test", "1").setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();  
                    .value(),
        assertThat(multiGetResponse.getResponses()[1].getFailure().getMessage(), equalTo("routing is required for [test]/[2]"));
import org.opensearch.action.DocWriteRequest;
            BulkResponse bulkResponse = client().prepareBulk().add(Requests.deleteRequest(indexOrAlias()).id("1")).execute().actionGet();  
        assertThat(termVectorsResponse.getId(), equalTo("1"));
        assertThat(multiGetResponse.getResponses()[1].isFailed(), equalTo(false));  
                    .actionGet()  
        ShardId idShard;
            .get();  
                fail("get with missing routing when routing is required should fail");  
        for (int i = 0; i < 5; i++) {
                client().prepareGet(indexOrAlias(), "1").execute().actionGet().isExists();
        multiTermVectorsResponse = client().prepareMultiTermVectors()  
            );  
                    .setQuery(QueryBuilders.matchAllQuery())
                    .actionGet()
 * the Apache License, Version 2.0 (the "License"); you may
            }
                    .execute()  
        String routingValue = findNonMatchingRoutingValue("test", "1");  
    public void testRequiredRoutingBulk() throws Exception {  
                assertThat(bulkItemResponse.getFailureMessage(), containsString("routing is required for [test]/[1]"));
                    .setSize(0)  
            equalTo("routing is required for [test]/[1]")  
import org.opensearch.action.termvectors.TermVectorsResponse;
                    .setSize(0)  
        return Integer.toString(routing);  
        assertThat(multiGetResponse.getResponses()[0].isFailed(), equalTo(false));
        logger.info("--> indexing with id [1], and routing [{}]", routingValue);
                client().prepareSearch()  
            .execute()  
/*  
                    .actionGet()
        }
            multiTermVectorsResponse.getResponses()[0].getFailure().getCause().getMessage(),
                .execute()
        try {  
    }
        assertThat(multiTermVectorsResponse.getResponses()[1].isFailed(), equalTo(false));
import static org.hamcrest.Matchers.equalTo;
        logger.info("--> search with no routing, should fine two");
        logger.info("--> verifying get with id [1] with routing [0], should succeed");
        }
                    .getHits()
                    .value(),
            .setRouting(routingValue)  
        String routingValue = findNonMatchingRoutingValue("test", "1");  
            );  
                .execute()  
                    .getTotalHits()
        {
                    .setQuery(QueryBuilders.matchAllQuery())
            .setSource("field", "value1")
            .actionGet();
                    .getTotalHits()  
                assertThat(bulkItemResponse.getFailure().getCause(), instanceOf(RoutingMissingException.class));
                    .value(),
                .actionGet();  
        {  
            try {
        logger.info("--> verifying get with no routing, should not find anything");
        logger.info("--> search with no routing, should fine one");  
                equalTo(1L)
                    .actionGet()  
            .add(new MultiGetRequest.Item(indexOrAlias(), "1"))
            .setRefreshPolicy(RefreshPolicy.IMMEDIATE)  
                client().prepareSearch()
            .setSource("field", "value1")
                    .actionGet()
            .setRouting(routingValue)
        for (int i = 0; i < 5; i++) {
        }
                client().prepareSearch()
        assertThat(multiTermVectorsResponse.getResponses()[0].getId(), equalTo("1"));
            assertThat(e.unwrapCause(), instanceOf(RoutingMissingException.class));  
            fail();
import org.opensearch.action.termvectors.TermVectorsRequest;
            assertThat(
                    .setQuery(QueryBuilders.matchAllQuery())
                    .setQuery(QueryBuilders.matchAllQuery())
                    .execute()
                    .getHits()
            .setRouting(routingValue)  
            .setDoc(Requests.INDEX_CONTENT_TYPE, "field1", "value1")
                    .value(),
                    .execute()  
        assertThat(multiGetResponse.getResponses()[0].getFailure().getId(), equalTo("1"));
            BulkResponse bulkResponse = client().prepareBulk()
            assertThat(bulkResponse.getItems().length, equalTo(1));
        }
                assertThat(e.getMessage(), equalTo("routing is required for [test]/[1]"));  
 * SPDX-License-Identifier: Apache-2.0
        do {
                    .getHits()
import org.opensearch.cluster.routing.OperationRouting;  
        logger.info("--> search with {} routing, should find one", routingValue);  
                client().prepareGet(indexOrAlias(), "1").execute().actionGet().isExists();
 * Unless required by applicable law or agreed to in writing,
        logger.info("--> search with correct routing, should find");
                assertThat(bulkItemResponse.getFailure().getStatus(), equalTo(RestStatus.BAD_REQUEST));
        assertThat(termVectorsResponse.isExists(), equalTo(true));
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        }  
        logger.info("--> search with {} routing, should find one", secondRoutingValue);  
            .get();
                equalTo(2L)  
            assertThat(client().prepareGet(indexOrAlias(), "1").setRouting(routingValue).execute().actionGet().isExists(), equalTo(true));
            .addAlias(new Alias("alias"))
                    .setQuery(QueryBuilders.matchAllQuery())
            assertThat(e.getMessage(), equalTo("routing is required for [test]/[1]"));
                client().prepareSearch()
                equalTo(1L)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    .execute()  
            .setRefreshPolicy(RefreshPolicy.IMMEDIATE)
                    .setQuery(QueryBuilders.matchAllQuery())
        ensureGreen();
                    .setQuery(QueryBuilders.matchAllQuery())
                    .getTotalHits()
        }
            assertThat(
import org.opensearch.test.OpenSearchIntegTestCase;
                    .value(),  
        logger.info("--> verifying get with no routing, should fail");
    public String findNonMatchingRoutingValue(String index, String id) {
                assertThat(bulkItemResponse.getFailure().getStatus(), equalTo(RestStatus.BAD_REQUEST));  
            );
                    .setRouting(routingValue, secondRoutingValue, routingValue)
            );  
            try {
            assertThat(  
        assertThat(multiTermVectorsResponse.getResponses()[0].getId(), equalTo("1"));  
                    .setSize(0)
        ensureGreen();
            fail("update with missing routing when routing is required should fail");
        ensureGreen();
                    .setQuery(QueryBuilders.matchAllQuery())
                assertThat(bulkItemResponse.getOpType(), equalTo(DocWriteRequest.OpType.INDEX));
import org.opensearch.cluster.ClusterState;
            BulkResponse bulkResponse = client().prepareBulk()
            .setSource("field", "value1")
        }
        assertThat(multiTermVectorsResponse.getResponses()[1].getResponse().getId(), equalTo("2"));  
        try {  
                    .value(),
                    .actionGet()  
import org.opensearch.action.get.MultiGetRequest;  
    public void testRequiredRoutingCrudApis() throws Exception {
            .indices()  
        client().prepareIndex("test")
            for (BulkItemResponse bulkItemResponse : bulkResponse) {  
        } catch (RoutingMissingException e) {  
                .execute()
                assertThat(bulkItemResponse.getOpType(), equalTo(DocWriteRequest.OpType.UPDATE));
                assertThat(e.getMessage(), equalTo("routing is required for [test]/[1]"));  
            assertThat(
            client().prepareDelete(indexOrAlias(), "1").get();  
        }
        ensureGreen();  
            assertThat(client().prepareGet(indexOrAlias(), "1").setRouting(routingValue).execute().actionGet().isExists(), equalTo(false));
            .setQuery(QueryBuilders.matchAllQuery())  
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(multiGetResponse.getResponses()[1].isFailed(), equalTo(true));  
            assertThat(client().prepareGet("test", "1").setRouting(routingValue).execute().actionGet().isExists(), equalTo(true));
                    .actionGet()
            .setRefreshPolicy(RefreshPolicy.IMMEDIATE)
import org.opensearch.action.admin.indices.alias.Alias;
                    .getTotalHits()  
        for (int i = 0; i < 5; i++) {  
                client().prepareSearch()
        logger.info("--> verifying get with routing, should find");
        }  
            for (BulkItemResponse bulkItemResponse : bulkResponse) {
            assertThat(client().prepareGet("test", "1").setRouting(routingValue).execute().actionGet().isExists(), equalTo(false));
import org.opensearch.action.update.UpdateResponse;
            BulkResponse bulkResponse = client().prepareBulk()
            assertThat(bulkResponse.hasFailures(), equalTo(true));  
        ensureGreen();
package org.opensearch.routing;
    private static String indexOrAlias() {  
            .setRefreshPolicy(RefreshPolicy.IMMEDIATE)  
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
        logger.info("--> verifying get with no routing, should not find anything");  
import org.opensearch.common.settings.Settings;
            routingShard = operationRouting.shardId(state, index, id, Integer.toString(++routing));  
            );  
            .add(new TermVectorsRequest(indexOrAlias(), "1"))
        for (int i = 0; i < 5; i++) {  
        client().prepareIndex(indexOrAlias())
        assertThat(  
                    .setRouting(secondRoutingValue)
        client().prepareDelete("test", "1").setRouting(routingValue).setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();
            .setSource("field", "value1")
        } catch (RoutingMissingException e) {
            assertThat(bulkResponse.hasFailures(), equalTo(false));
            .add(new MultiGetRequest.Item(indexOrAlias(), "2").routing("0"))
            .setRefreshPolicy(RefreshPolicy.IMMEDIATE)
        try {
            .add(new TermVectorsRequest(indexOrAlias(), "2").routing(routingValue))  
import org.opensearch.transport.client.Requests;
            .add(new MultiGetRequest.Item(indexOrAlias(), "2"))  
import org.opensearch.action.bulk.BulkItemResponse;
        try {
        for (int i = 0; i < 5; i++) {  
        logger.info("--> verifying term vector with id [1], with routing [0], should succeed");
import org.opensearch.action.bulk.BulkResponse;  
            .execute()  
                equalTo(2L)
            .get();
        assertThat(multiTermVectorsResponse.getResponses()[1].isFailed(), equalTo(true));
            .prepareCreate("test")  
            try {
                assertThat(e.status(), equalTo(RestStatus.BAD_REQUEST));
        for (int i = 0; i < 5; i++) {
                .add(new UpdateRequest(indexOrAlias(), "1").doc(Requests.INDEX_CONTENT_TYPE, "field", "value2"))  
                assertThat(bulkItemResponse.getOpType(), equalTo(DocWriteRequest.OpType.DELETE));  
                .add(Requests.indexRequest(indexOrAlias()).id("1").source(Requests.INDEX_CONTENT_TYPE, "field", "value"))
            assertThat(getResponse.getSourceAsMap().get("field"), equalTo("value2"));
        }
                    .execute()  
        logger.info("--> indexing with id [{}], and routing [{}]", routingValue, secondRoutingValue);  
                    .getHits()
                equalTo(2L)
        assertThat(client().prepareGet(indexOrAlias(), "1").setRouting(routingValue).execute().actionGet().isExists(), equalTo(true));  
            assertThat(
                    .getHits()
        try {
                fail();  
                    .getHits()
                assertThat(bulkItemResponse.isFailed(), equalTo(true));  
            .setId("1")
        logger.info("--> indexing with id [1], with no routing, should fail");  
            );
            .setMapping(XContentFactory.jsonBuilder().startObject().startObject("_routing").field("required", true).endObject().endObject())
        client().prepareIndex("test")
                equalTo(0L)
        }
import org.opensearch.OpenSearchException;
        logger.info("--> verifying get with routing, should find");  
        assertThat(updateResponse.getId(), equalTo("1"));  
                .actionGet();
                    .execute()
        }  
            assertThat(client().prepareGet("test", "1").setRouting(routingValue).execute().actionGet().isExists(), equalTo(true));  
                    .actionGet()
                client().prepareSearch()
                    .value(),  
        logger.info("--> verifying mget with ids [1,2], with routing [0], should succeed");
}  
                    .getHits()
        assertThat(multiGetResponse.getResponses()[0].getResponse().getId(), equalTo("1"));
                    .actionGet()
            .setId("1")
            .get();
        assertThat(multiGetResponse.getResponses().length, equalTo(2));  
        logger.info("--> indexing with id [1], and routing [{}]", routingValue);  
            );
            BulkResponse bulkResponse = client().prepareBulk()
import org.opensearch.action.support.WriteRequest.RefreshPolicy;
            multiTermVectorsResponse.getResponses()[1].getFailure().getCause().getMessage(),
            }  
        {
                    .execute()  
    }  
            assertThat(
            .setRouting(routingValue)
            );
                    .getTotalHits()
                client().prepareSearch()
import org.opensearch.action.explain.ExplainResponse;
        logger.info("--> deleting with routing, should delete");  
            fail();  
        assertThat(multiTermVectorsResponse.getResponses()[0].getResponse().isExists(), equalTo(true));  
            equalTo("routing is required for [test]/[2]")
            assertThat(client().prepareGet("test", "1").setRouting(routingValue).execute().actionGet().isExists(), equalTo(true));  
                    .getHits()
 */
            assertThat(  
        for (int i = 0; i < 5; i++) {
                    .setQuery(QueryBuilders.matchAllQuery())
        for (int i = 0; i < 5; i++) {  
        assertThat(multiGetResponse.getResponses()[0].getFailure().getMessage(), equalTo("routing is required for [test]/[1]"));
            }
import static org.hamcrest.Matchers.nullValue;
            .get();
            .addAlias(new Alias("alias"))
                    .getTotalHits()  
                    .setQuery(QueryBuilders.matchAllQuery())
            assertThat(bulkResponse.hasFailures(), equalTo(false));
                equalTo(2L)
                equalTo(1L)
        assertThat(multiTermVectorsResponse.getResponses()[0].getResponse().getId(), equalTo("1"));
        client().prepareIndex("test")  
            assertThat(e.unwrapCause(), instanceOf(RoutingMissingException.class));
                    .execute()
        }
        String routingValue = findNonMatchingRoutingValue("test", "1");  
            } catch (RoutingMissingException e) {
            assertThat(client().prepareGet("test", "1").setRouting(routingValue).execute().actionGet().isExists(), equalTo(true));
        logger.info("--> verifying get with routing, should find");
            assertThat(
        }
            }
        }
        assertThat(multiTermVectorsResponse.getResponses()[1].getResponse().isExists(), equalTo(true));
        logger.info("--> verifying get with no routing, should not find anything");
                    .execute()  
        assertThat(
        assertThat(multiGetResponse.getResponses()[1].getResponse().getId(), equalTo("2"));
        {  
        }
                    .setSize(0)  
                .actionGet();
            assertThat(client().prepareGet("test", "1").execute().actionGet().isExists(), equalTo(false));
        client().prepareIndex(indexOrAlias())
    @Override
            client().prepareUpdate(indexOrAlias(), "1").setDoc(Requests.INDEX_CONTENT_TYPE, "field1", "value1").get();
        logger.info("--> verifying explain with id [2], with no routing, should fail");  
                equalTo(2L)
        int routing = -1;
        MultiGetResponse multiGetResponse = client().prepareMultiGet()
    }
                    .execute()
            GetResponse getResponse = client().prepareGet(indexOrAlias(), "1").setRouting(routingValue).execute().actionGet();
    }
            .setRouting(routingValue)
                client().prepareSearch()
        } while (idShard.getId() == routingShard.id());
            .setSource("field", "value2")
        for (int i = 0; i < 5; i++) {
 */  
        logger.info("--> search with {},{},{} indexRoutings , should find two", routingValue, secondRoutingValue, routingValue);  
        }  
        {
        String routingValue = findNonMatchingRoutingValue("test", "1");
            assertThat(e.getMessage(), equalTo("routing is required for [test]/[2]"));
import org.opensearch.action.update.UpdateRequest;  
            fail("delete with missing routing when routing is required should fail");
                assertThat(bulkItemResponse.getFailureMessage(), containsString("routing is required for [test]/[1]"));  
                    .execute()  
import org.opensearch.common.settings.ClusterSettings;
            assertThat(e.unwrapCause(), instanceOf(RoutingMissingException.class));  
            .get();
        client().admin()
        createIndex("test");
                    .setRouting(routingValue)
                    .execute()  
                assertThat(e.getMessage(), equalTo("routing is required for [test]/[1]"));  
            .prepareCreate("test")  
        assertThat(multiTermVectorsResponse.getResponses()[0].isFailed(), equalTo(true));  
        }
        for (int i = 0; i < 5; i++) {
                assertThat(bulkItemResponse.isFailed(), equalTo(true));
        createIndex("test");
        logger.info("--> indexing with id [1], and routing [{}]", routingValue);
            client().prepareIndex(indexOrAlias()).setId("1").setSource("field", "value1").get();
                    .setRouting(routingValue, secondRoutingValue)
                    .actionGet()  
            }
            client().prepareUpdate(indexOrAlias(), "1").setDoc(Requests.INDEX_CONTENT_TYPE, "field", "value2").execute().actionGet();  
        logger.info("--> deleting with no routing, should not delete anything");
            .execute()
                    .execute()  
        client().admin()
                    .actionGet()
                    .value(),
        }  
 * software distributed under the License is distributed on an
                    .setRouting(routingValue)  
 * specific language governing permissions and limitations
            client().prepareExplain(indexOrAlias(), "2").setQuery(QueryBuilders.matchAllQuery()).get();
        }
        } catch (RoutingMissingException e) {  
        assertThat(multiTermVectorsResponse.getResponses()[0].isFailed(), equalTo(false));
        logger.info("--> verifying get with routing, should find");  
            .addAlias(new Alias("alias"))
            .actionGet();
            assertThat(client().prepareGet("test", "1").execute().actionGet().isExists(), equalTo(false));
            assertThat(e.getMessage(), equalTo("routing is required for [test]/[1]"));
            .setMapping(XContentFactory.jsonBuilder().startObject().startObject("_routing").field("required", true).endObject().endObject())  
        try {
        assertThat(multiGetResponse.getResponses()[1].getFailure().getId(), equalTo("2"));
            idShard = operationRouting.shardId(state, index, id, null);
        String secondRoutingValue = "1";
            assertThat(
            assertThat(
                    .getHits()
                    .getTotalHits()  
                    .setRouting("1")
/*
                    .value(),
                fail();  
            .setRouting(routingValue)
        return 2;
            assertThat(
    public void testSimpleCrudRouting() throws Exception {  
        for (int i = 0; i < 5; i++) {  
        }  
                .execute()
            .add(new TermVectorsRequest(indexOrAlias(), "2"))
        assertThat(multiTermVectorsResponse.getResponses()[0].getResponse(), nullValue());
        logger.info("--> verifying explain with id [2], with routing [0], should succeed");
 * not use this file except in compliance with the License.
                    .setSize(0)
            assertThat(bulkResponse.hasFailures(), equalTo(true));
            .indices()
                assertThat(bulkItemResponse.getFailure().getStatus(), equalTo(RestStatus.BAD_REQUEST));
        assertThat(explainResponse.isExists(), equalTo(true));  
            .setRefreshPolicy(RefreshPolicy.IMMEDIATE)
        client().admin()
            fail("index with missing routing when routing is required should fail");  
 * license agreements. See the NOTICE file distributed with
                    .setQuery(QueryBuilders.matchAllQuery())
                .actionGet();
        assertThat(multiGetResponse.getResponses().length, equalTo(2));
            assertThat(
        for (int i = 0; i < 5; i++) {  
    }
        logger.info("--> search with {},{} indexRoutings , should find two", routingValue, "1");  
                    .getTotalHits()  
        }
            assertThat(
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
                assertThat(bulkItemResponse.getFailure().getCause(), instanceOf(RoutingMissingException.class));
 *  
 * The OpenSearch Contributors require contributions made to  
                assertThat(e.status(), equalTo(RestStatus.BAD_REQUEST));
        }  
            .setId("1")  
            .setRouting(secondRoutingValue)  
        TermVectorsResponse termVectorsResponse = client().prepareTermVectors(indexOrAlias(), "1").setRouting(routingValue).get();  
                    .setRouting("1")  
            assertThat(bulkResponse.getItems().length, equalTo(1));  
        client().prepareIndex(indexOrAlias()).setId("1").setRouting(routingValue).setSource("field", "value1").get();
                    .setRouting(routingValue)
public class SimpleRoutingIT extends OpenSearchIntegTestCase {  
                assertThat(e.status(), equalTo(RestStatus.BAD_REQUEST));
            } catch (RoutingMissingException e) {
            client().prepareGet(indexOrAlias(), "1").get();
import static org.hamcrest.Matchers.containsString;
                    .getTotalHits()  
            .prepareCreate("test")
            .get();  
                    .getHits()
            fail();
            assertThat(client().prepareGet(indexOrAlias(), "1").setRouting(routingValue).execute().actionGet().isExists(), equalTo(true));
                    .setQuery(QueryBuilders.matchAllQuery())
/*  
                .actionGet();
 *
    }
        for (int i = 0; i < 5; i++) {
            );  
                    .setRouting(routingValue)  
        }  
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
        for (int i = 0; i < 5; i++) {
        OperationRouting operationRouting = new OperationRouting(
        client().prepareDelete(indexOrAlias(), "1").setRouting(routingValue).setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();
            assertThat(bulkResponse.hasFailures(), equalTo(true));
        assertThat(multiTermVectorsResponse.getResponses()[1].getResponse(), nullValue());
        }  
 * compatible open source license.
        );
                    .actionGet()
                    .value(),
            assertThat(client().prepareGet("test", "1").execute().actionGet().isExists(), equalTo(false));
        } catch (OpenSearchException e) {
                assertThat(bulkItemResponse.getFailureMessage(), containsString("routing is required for [test]/[1]"));
        logger.info("--> indexing with id [1], and routing [{}]", routingValue);
 * this file be licensed under the Apache-2.0 license or a
                    .getTotalHits()  
            .add(new MultiGetRequest.Item(indexOrAlias(), "1").routing("0"))  
 * this work for additional information regarding copyright
        );
                    .getHits()
        ClusterState state = client().admin().cluster().prepareState().all().get().getState();  
                    .setRouting("1")  
        logger.info("--> verifying mget with ids [1,2], with no routing, should fail");  
            client().prepareTermVectors(indexOrAlias(), "1").get();
                    .value(),  
            .setId(routingValue)
            .setSource("field", "value1")  
        assertThat(updateResponse.getVersion(), equalTo(2L));
        logger.info("--> indexing with id [1], and routing [0]");
            .get();
        for (int i = 0; i < 5; i++) {
            .setId("1")  
            .get();
    protected int minimumNumberOfShards() {  
            .get();  
        {
        for (int i = 0; i < 5; i++) {  
            BulkResponse bulkResponse = client().prepareBulk()  
                    .getTotalHits()
            assertThat(
            .actionGet();
            assertThat(client().prepareGet("test", "1").execute().actionGet().isExists(), equalTo(false));
        for (int i = 0; i < 5; i++) {
    }
                    .getTotalHits()  
                equalTo(0L)
        try {
        }  
        assertThat(multiTermVectorsResponse.getResponses().length, equalTo(2));
            assertThat(client().prepareGet("test", "1").execute().actionGet().isExists(), equalTo(false));  
                    .setSize(0)  
        );  
        assertThat(explainResponse.isMatch(), equalTo(true));
                    .getTotalHits()  
                client().prepareSearch().setQuery(QueryBuilders.matchAllQuery()).execute().actionGet().getHits().getTotalHits().value(),
        } catch (RoutingMissingException e) {
