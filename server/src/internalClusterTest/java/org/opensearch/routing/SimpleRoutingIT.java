        client().prepareIndex("test")
            assertThat(bulkResponse.hasFailures(), equalTo(true));
                assertThat(bulkItemResponse.getOpType(), equalTo(DocWriteRequest.OpType.INDEX));
                    .setQuery(QueryBuilders.matchAllQuery())
                    .getHits()
            .setRouting(routingValue)
            }
            .get();
            .setRouting(routingValue)
        ensureGreen();
        assertThat(multiTermVectorsResponse.getResponses()[0].getResponse().isExists(), equalTo(true));
                    .setQuery(QueryBuilders.matchAllQuery())
            BulkResponse bulkResponse = client().prepareBulk()
        for (int i = 0; i < 5; i++) {
            .setSource("field", "value1")
 * Licensed to Elasticsearch under one or more contributor
            .setRefreshPolicy(RefreshPolicy.IMMEDIATE)
                    .setRouting(routingValue)
            assertThat(client().prepareGet("test", "1").execute().actionGet().isExists(), equalTo(false));
        logger.info("--> verifying get with id [1], with no routing, should fail");
            );
            assertThat(bulkResponse.getItems().length, equalTo(1));
            assertThat(client().prepareGet("test", "1").setRouting(routingValue).execute().actionGet().isExists(), equalTo(true));
        }
            .get();
        } catch (RoutingMissingException e) {
package org.opensearch.routing;
            client().prepareUpdate(indexOrAlias(), "1").setDoc(Requests.INDEX_CONTENT_TYPE, "field1", "value1").get();
                client().prepareGet(indexOrAlias(), "1").execute().actionGet().isExists();
        return randomBoolean() ? "test" : "alias";
import org.opensearch.action.get.GetResponse;
        client().prepareDelete("test", "1").setRouting(routingValue).setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();
        client().prepareIndex(indexOrAlias())
        String routingValue = findNonMatchingRoutingValue("test", "1");
        return 2;
        logger.info("--> indexing with id [1], and routing [0]");
        }
                equalTo(1L)
        logger.info("--> search with no routing, should fine two");
        {
            assertThat(
import org.opensearch.OpenSearchException;
                    .setSize(0)
            assertThat(client().prepareGet("test", "1").execute().actionGet().isExists(), equalTo(false));
 * ownership. Elasticsearch licenses this file to you under
        for (int i = 0; i < 5; i++) {
                assertThat(e.getMessage(), equalTo("routing is required for [test]/[1]"));
        client().prepareIndex("test")
            .execute()
                    .setSize(0)
        }
            assertThat(client().prepareGet("test", "1").execute().actionGet().isExists(), equalTo(false));
import static org.hamcrest.Matchers.containsString;
                assertThat(bulkItemResponse.getFailureMessage(), containsString("routing is required for [test]/[1]"));
        ensureGreen();
            .addAlias(new Alias("alias"))
                    .value(),
                .add(new UpdateRequest(indexOrAlias(), "1").doc(Requests.INDEX_CONTENT_TYPE, "field", "value2").routing("0"))
                    .execute()
            assertThat(bulkResponse.getItems().length, equalTo(1));
            Settings.EMPTY,
            .add(new MultiGetRequest.Item(indexOrAlias(), "2"))
                    .execute()
        assertThat(multiTermVectorsResponse.getResponses()[1].getResponse(), nullValue());
        {
 */
        assertThat(updateResponse.getId(), equalTo("1"));
                equalTo(2L)
        for (int i = 0; i < 5; i++) {
            .prepareCreate("test")
        }
            assertThat(client().prepareGet("test", "1").setRouting(routingValue).execute().actionGet().isExists(), equalTo(true));
                equalTo(1L)
        assertThat(
            BulkResponse bulkResponse = client().prepareBulk()
            .indices()
                    .value(),
            assertThat(getResponse.getSourceAsMap().get("field"), equalTo("value2"));
            .get();
        assertThat(multiGetResponse.getResponses().length, equalTo(2));
            client().prepareIndex(indexOrAlias()).setId("1").setSource("field", "value1").get();
            .setSource("field", "value2")
import org.opensearch.action.bulk.BulkItemResponse;
        multiTermVectorsResponse = client().prepareMultiTermVectors()
                    .setQuery(QueryBuilders.matchAllQuery())
        MultiGetResponse multiGetResponse = client().prepareMultiGet()
                equalTo(1L)
                    .setRouting("1")
                assertThat(bulkItemResponse.getOpType(), equalTo(DocWriteRequest.OpType.UPDATE));
            );
 * this work for additional information regarding copyright
                equalTo(2L)
            for (BulkItemResponse bulkItemResponse : bulkResponse) {
        }
            assertThat(bulkResponse.hasFailures(), equalTo(false));
            .actionGet();
                assertThat(e.status(), equalTo(RestStatus.BAD_REQUEST));
        assertThat(multiTermVectorsResponse.getResponses()[1].isFailed(), equalTo(false));
            assertThat(
        logger.info("--> search with correct routing, should find");
        logger.info("--> indexing with id [2], and routing [{}]", routingValue);
                    .setRouting(routingValue, secondRoutingValue)
        logger.info("--> verifying get with no routing, should not find anything");
import org.opensearch.action.termvectors.TermVectorsRequest;
        try {
                    .value(),
import org.opensearch.cluster.ClusterState;
        assertThat(multiTermVectorsResponse.getResponses().length, equalTo(2));
                    .getTotalHits()
                .actionGet();
                client().prepareSearch()
            );
                    .getTotalHits()
        assertThat(multiTermVectorsResponse.getResponses()[1].getResponse().getId(), equalTo("2"));
                    .value(),
                client().prepareSearch().setQuery(QueryBuilders.matchAllQuery()).execute().actionGet().getHits().getTotalHits().value(),
        {
        logger.info("--> verifying get with no routing, should not find anything");
 * Unless required by applicable law or agreed to in writing,
                    .value(),
                assertThat(bulkItemResponse.getFailure().getCause(), instanceOf(RoutingMissingException.class));
            );
 *    http://www.apache.org/licenses/LICENSE-2.0
                .add(Requests.deleteRequest(indexOrAlias()).id("1").routing("0"))
        assertThat(multiTermVectorsResponse.getResponses().length, equalTo(2));
        }
        }
            client().prepareUpdate(indexOrAlias(), "1").setDoc(Requests.INDEX_CONTENT_TYPE, "field", "value2").execute().actionGet();
                    .actionGet()
                    .value(),
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.index.query.QueryBuilders;
            .get();
            .setRouting(routingValue)
        } catch (OpenSearchException e) {
            );
        ClusterState state = client().admin().cluster().prepareState().all().get().getState();
        logger.info("--> deleting with no routing, should fail");
        logger.info("--> indexing with id [1], and routing [{}]", routingValue);
            fail();
        } catch (RoutingMissingException e) {
                assertThat(bulkItemResponse.isFailed(), equalTo(true));
            .setId("1")
                    .setSize(0)
        assertThat(multiGetResponse.getResponses()[0].getResponse().getId(), equalTo("1"));
import org.opensearch.transport.client.Requests;
            .get();
        assertThat(multiGetResponse.getResponses()[0].isFailed(), equalTo(false));
            }
import org.opensearch.common.settings.Settings;
import org.opensearch.action.admin.indices.alias.Alias;
                    .getHits()
        for (int i = 0; i < 5; i++) {
import org.opensearch.action.DocWriteRequest;
                assertThat(bulkItemResponse.getFailureMessage(), containsString("routing is required for [test]/[1]"));
            GetResponse getResponse = client().prepareGet(indexOrAlias(), "1").setRouting(routingValue).execute().actionGet();
                    .execute()
        createIndex("test");
        }
                    .actionGet()
        client().admin()
        assertThat(client().prepareGet(indexOrAlias(), "1").setRouting(routingValue).execute().actionGet().isExists(), equalTo(true));
            .add(new TermVectorsRequest(indexOrAlias(), "2"))
        logger.info("--> verifying get with routing, should find");
import org.opensearch.action.get.MultiGetResponse;
    public void testSimpleSearchRouting() {
            .setSource("field", "value1")
 * The OpenSearch Contributors require contributions made to
            BulkResponse bulkResponse = client().prepareBulk().add(Requests.deleteRequest(indexOrAlias()).id("1")).execute().actionGet();
                client().prepareSearch()
            .setRefreshPolicy(RefreshPolicy.IMMEDIATE)
        for (int i = 0; i < 5; i++) {
import org.opensearch.action.RoutingMissingException;
                client().prepareSearch()
                assertThat(bulkItemResponse.getFailure().getStatus(), equalTo(RestStatus.BAD_REQUEST));
                    .getHits()
 * not use this file except in compliance with the License.
                    .setRouting(secondRoutingValue)
                    .getHits()
                equalTo(2L)
        assertThat(multiGetResponse.getResponses()[1].getFailure().getMessage(), equalTo("routing is required for [test]/[2]"));
                equalTo(1L)
                client().prepareSearch()
            );
            .execute()
                    .setRouting(routingValue)
        } catch (OpenSearchException e) {
                    .value(),
        MultiTermVectorsResponse multiTermVectorsResponse = client().prepareMultiTermVectors()
                    .setQuery(QueryBuilders.matchAllQuery())
            assertThat(client().prepareGet("test", "1").execute().actionGet().isExists(), equalTo(false));
            .setId("1")
        assertThat(multiTermVectorsResponse.getResponses()[0].getResponse(), nullValue());
        logger.info("--> indexing with id [{}], and routing [{}]", routingValue, secondRoutingValue);
        logger.info("--> search with {} routing, should find one", secondRoutingValue);
        }
import org.opensearch.cluster.routing.OperationRouting;
            .setRefreshPolicy(RefreshPolicy.IMMEDIATE)
    }
        assertThat(multiTermVectorsResponse.getResponses()[0].getId(), equalTo("1"));
            client().prepareDelete(indexOrAlias(), "1").get();
            assertThat(e.unwrapCause(), instanceOf(RoutingMissingException.class));
/*
                assertThat(bulkItemResponse.getFailure().getStatus(), equalTo(RestStatus.BAD_REQUEST));
            routingShard = operationRouting.shardId(state, index, id, Integer.toString(++routing));
 * KIND, either express or implied.  See the License for the
        for (int i = 0; i < 5; i++) {
                    .value(),
            client().prepareTermVectors(indexOrAlias(), "1").get();
        }
        {
                    .setSize(0)
        );
                assertThat(bulkItemResponse.getOpType(), equalTo(DocWriteRequest.OpType.DELETE));
            assertThat(client().prepareGet("test", "1").setRouting(routingValue).execute().actionGet().isExists(), equalTo(true));
            assertThat(
                equalTo(1L)
import org.opensearch.action.bulk.BulkResponse;
                    .setRouting("1")
            .get();
                .execute()
        String routingValue = findNonMatchingRoutingValue("test", "1");
                    .getHits()
            assertThat(bulkResponse.hasFailures(), equalTo(true));
        logger.info("--> indexing with id [1], and routing [{}]", routingValue);
                    .execute()
                    .actionGet()
        ExplainResponse explainResponse = client().prepareExplain(indexOrAlias(), "2")
                client().prepareSearch()
        assertThat(termVectorsResponse.getId(), equalTo("1"));
                    .execute()
 * the Apache License, Version 2.0 (the "License"); you may
            .setId(routingValue)
                    .getHits()
            .setSource("field", "value1")
        ensureGreen();
        }
                    .setRouting("1")
        logger.info("--> verifying get with no routing, should fail");
        } catch (RoutingMissingException e) {
        String routingValue = findNonMatchingRoutingValue("test", "1");
                client().prepareSearch().setQuery(QueryBuilders.matchAllQuery()).execute().actionGet().getHits().getTotalHits().value(),
        for (int i = 0; i < 5; i++) {
        }
        logger.info("--> verifying get with no routing, should not find anything");
        ensureGreen();
                    .value(),
        for (int i = 0; i < 5; i++) {
            .setMapping(XContentFactory.jsonBuilder().startObject().startObject("_routing").field("required", true).endObject().endObject())
                    .setQuery(QueryBuilders.matchAllQuery())
        logger.info("--> indexing with id [1], and routing [{}]", routingValue);
            fail();
                    .getHits()
            fail("index with missing routing when routing is required should fail");
            .setMapping(XContentFactory.jsonBuilder().startObject().startObject("_routing").field("required", true).endObject().endObject())
            client().prepareGet(indexOrAlias(), "1").get();
            .setRouting(routingValue)
import org.opensearch.action.explain.ExplainResponse;
                    .setRouting(routingValue, secondRoutingValue, routingValue)
                    .setRouting(routingValue)
        for (int i = 0; i < 5; i++) {
            .setRefreshPolicy(RefreshPolicy.IMMEDIATE)
        for (int i = 0; i < 5; i++) {
        }
                    .actionGet()
import org.opensearch.core.rest.RestStatus;
                    .setQuery(QueryBuilders.matchAllQuery())
                equalTo(0L)
            .setRouting(routingValue)
        client().prepareIndex("test")
            .setId("1")
        {
                .actionGet();
            .prepareCreate("test")
                .execute()
        }
            );
        }
        assertThat(multiGetResponse.getResponses()[1].getResponse().getId(), equalTo("2"));
            equalTo("routing is required for [test]/[2]")
        }
        assertThat(explainResponse.isExists(), equalTo(true));
                    .getHits()
                assertThat(e.getMessage(), equalTo("routing is required for [test]/[1]"));
                    .getTotalHits()
 */
            assertThat(bulkResponse.hasFailures(), equalTo(true));
            assertThat(
        } catch (RoutingMissingException e) {
        ShardId routingShard;
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        TermVectorsResponse termVectorsResponse = client().prepareTermVectors(indexOrAlias(), "1").setRouting(routingValue).get();
            } catch (RoutingMissingException e) {
                    .setQuery(QueryBuilders.matchAllQuery())
        logger.info("--> verifying term vector with id [1], with routing [0], should succeed");
        assertThat(multiGetResponse.getResponses()[1].getFailure().getId(), equalTo("2"));
                    .getTotalHits()
                    .getHits()
            multiTermVectorsResponse.getResponses()[0].getFailure().getCause().getMessage(),
                    .execute()
                    .setQuery(QueryBuilders.matchAllQuery())
            );
                    .execute()
 * Modifications Copyright OpenSearch Contributors. See
            .prepareCreate("test")
                    .getTotalHits()
 * under the License.
                assertThat(bulkItemResponse.isFailed(), equalTo(true));
            );
        createIndex("test");
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.support.WriteRequest.RefreshPolicy;
            );
        client().admin().indices().prepareRefresh().execute().actionGet();
                    .value(),
            assertThat(client().prepareGet(indexOrAlias(), "1").setRouting(routingValue).execute().actionGet().isExists(), equalTo(false));
            .add(new MultiGetRequest.Item(indexOrAlias(), "1"))
                client().prepareGet(indexOrAlias(), "1").execute().actionGet().isExists();
        try {
        assertThat(multiGetResponse.getResponses()[1].isFailed(), equalTo(true));
            assertThat(bulkResponse.hasFailures(), equalTo(false));
        ensureGreen();
                    .execute()
                    .execute()
public class SimpleRoutingIT extends OpenSearchIntegTestCase {
        return Integer.toString(routing);
                assertThat(bulkItemResponse.getFailure().getCause(), instanceOf(RoutingMissingException.class));
            .get();
            try {
    protected int minimumNumberOfShards() {
        logger.info("--> search with wrong routing, should not find");
                equalTo(2L)
        for (int i = 0; i < 5; i++) {
            assertThat(
        }
            }
            .addAlias(new Alias("alias"))
                    .execute()
                assertThat(e.getMessage(), equalTo("routing is required for [test]/[1]"));
            BulkResponse bulkResponse = client().prepareBulk()
        for (int i = 0; i < 5; i++) {
            .add(new MultiGetRequest.Item(indexOrAlias(), "2").routing("0"))
            assertThat(
        }
                fail();
                    .execute()
    private static String indexOrAlias() {
/*
            .setId("2")
                    .getHits()
                    .value(),
            equalTo("routing is required for [test]/[1]")
            assertThat(e.unwrapCause(), instanceOf(RoutingMissingException.class));
        logger.info("--> deleting with routing, should delete");
                    .setQuery(QueryBuilders.matchAllQuery())
        assertThat(multiTermVectorsResponse.getResponses()[0].isFailed(), equalTo(true));
        client().prepareIndex(indexOrAlias()).setId("1").setRouting(routingValue).setSource("field", "value1").get();
                    .getTotalHits()
            .setRouting(routingValue)
        assertThat(multiGetResponse.getResponses().length, equalTo(2));
import org.opensearch.action.termvectors.MultiTermVectorsResponse;
                    .setQuery(QueryBuilders.matchAllQuery())
                .actionGet();
    @Override
            .get();
                .actionGet();
        client().admin()
            assertThat(client().prepareGet(indexOrAlias(), "1").setRouting(routingValue).execute().actionGet().isExists(), equalTo(true));
            );
                    .setRouting(routingValue, secondRoutingValue, routingValue)
            assertThat(
import static org.hamcrest.Matchers.instanceOf;
        assertThat(multiTermVectorsResponse.getResponses()[1].getId(), equalTo("2"));
        assertThat(termVectorsResponse.isExists(), equalTo(true));
            assertThat(client().prepareGet(indexOrAlias(), "1").setRouting(routingValue).execute().actionGet().isExists(), equalTo(true));
                equalTo(1L)
                assertThat(e.status(), equalTo(RestStatus.BAD_REQUEST));
        }
        logger.info("--> search with {},{},{} indexRoutings , should find two", routingValue, secondRoutingValue, routingValue);
            fail();
 * You may obtain a copy of the License at
            .indices()
        assertThat(multiTermVectorsResponse.getResponses()[0].isFailed(), equalTo(false));
            assertThat(
            assertThat(
        UpdateResponse updateResponse = client().prepareUpdate(indexOrAlias(), "1")
    public void testRequiredRoutingCrudApis() throws Exception {
                    .actionGet()
            );
            BulkResponse bulkResponse = client().prepareBulk()
    }
                .add(Requests.indexRequest(indexOrAlias()).id("1").routing("0").source(Requests.INDEX_CONTENT_TYPE, "field", "value"))
                    .actionGet()
                    .setQuery(QueryBuilders.matchAllQuery())
                    .getHits()
        }
        } catch (OpenSearchException e) {
                assertThat(e.status(), equalTo(RestStatus.BAD_REQUEST));
                    .getTotalHits()
                    .setQuery(QueryBuilders.matchAllQuery())
            .setRefreshPolicy(RefreshPolicy.IMMEDIATE)
            assertThat(bulkResponse.hasFailures(), equalTo(false));
            multiTermVectorsResponse.getResponses()[1].getFailure().getCause().getMessage(),
            } catch (RoutingMissingException e) {
 * license agreements. See the NOTICE file distributed with
        );
        assertThat(multiGetResponse.getResponses()[0].getFailure().getId(), equalTo("1"));
        assertThat(multiGetResponse.getResponses()[1].isFailed(), equalTo(false));
import org.opensearch.action.update.UpdateResponse;
                fail("get with missing routing when routing is required should fail");
    }
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.settings.ClusterSettings;
                assertThat(bulkItemResponse.getFailureMessage(), containsString("routing is required for [test]/[1]"));
                    .actionGet()
            .add(new TermVectorsRequest(indexOrAlias(), "1"))
                client().prepareSearch()
        logger.info("--> verifying get with routing, should find");
                client().prepareSearch()
                equalTo(2L)
        logger.info("--> verifying get with id [1] with routing [0], should succeed");
            assertThat(e.unwrapCause(), instanceOf(RoutingMissingException.class));
        assertThat(multiTermVectorsResponse.getResponses()[1].isFailed(), equalTo(true));
                equalTo(0L)
}
        for (int i = 0; i < 5; i++) {
        String secondRoutingValue = "1";
            .get();
        }
                .add(Requests.indexRequest(indexOrAlias()).id("1").source(Requests.INDEX_CONTENT_TYPE, "field", "value"))
            }
        assertThat(multiTermVectorsResponse.getResponses()[0].getId(), equalTo("1"));
        }
        logger.info("--> verifying get with routing, should find");
            assertThat(
                    .value(),
        do {
import static org.hamcrest.Matchers.nullValue;
            } catch (RoutingMissingException e) {
        {
        client().prepareUpdate(indexOrAlias(), "1").setRouting(routingValue).setDoc(Requests.INDEX_CONTENT_TYPE, "field", "value2").get();
        for (int i = 0; i < 5; i++) {
                    .setRouting(routingValue, secondRoutingValue)
 * software distributed under the License is distributed on an
        }
        ShardId idShard;
        try {
            .execute()
        logger.info("--> verifying explain with id [2], with routing [0], should succeed");
            client().prepareExplain(indexOrAlias(), "2").setQuery(QueryBuilders.matchAllQuery()).get();
            }
                .execute()
        assertThat(explainResponse.isMatch(), equalTo(true));
                    .getHits()
                    .setQuery(QueryBuilders.matchAllQuery())
            .setQuery(QueryBuilders.matchAllQuery())
            .get();
        OperationRouting operationRouting = new OperationRouting(
import org.opensearch.test.OpenSearchIntegTestCase;
            .setSource("field", "value1")
                    .getTotalHits()
            assertThat(
        }
        client().prepareDelete(indexOrAlias(), "1").setRouting(routingValue).setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();
                client().prepareSearch()
        try {
        for (int i = 0; i < 5; i++) {
            assertThat(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.action.get.MultiGetRequest;
                    .getTotalHits()
        logger.info("--> verifying mget with ids [1,2], with no routing, should fail");
    public void testRequiredRoutingBulk() throws Exception {
            assertThat(bulkResponse.getItems().length, equalTo(1));
            .add(new MultiGetRequest.Item(indexOrAlias(), "1").routing("0"))
                client().prepareSearch()
        multiGetResponse = client().prepareMultiGet()
                    .getTotalHits()
        }
                equalTo(1L)
                    .setSize(0)
 */
            assertThat(getResponse.isExists(), equalTo(true));
                assertThat(bulkItemResponse.getFailure().getCause(), instanceOf(RoutingMissingException.class));
 *
        logger.info("--> verifying get with routing, should find");
        assertThat(multiTermVectorsResponse.getResponses()[0].getResponse().getId(), equalTo("1"));
        logger.info("--> search with no routing, should fine one");
            assertThat(bulkResponse.getItems().length, equalTo(1));
            }
                    .setSize(0)
                client().prepareSearch()
        assertThat(multiGetResponse.getResponses()[0].getFailure().getMessage(), equalTo("routing is required for [test]/[1]"));
            .get();
                    .actionGet()
                client().prepareSearch()
        logger.info("--> verifying explain with id [2], with no routing, should fail");
import org.opensearch.common.xcontent.XContentFactory;
                    .actionGet()
        try {
import org.opensearch.core.index.shard.ShardId;
            BulkResponse bulkResponse = client().prepareBulk()
        client().prepareIndex(indexOrAlias())
        logger.info("--> indexing with id [1], with no routing, should fail");
            assertThat(e.getMessage(), equalTo("routing is required for [test]/[1]"));
    }
        }
                    .setRouting(routingValue)
        for (int i = 0; i < 5; i++) {
                .actionGet();
            fail();
            assertThat(e.getMessage(), equalTo("routing is required for [test]/[1]"));
            fail("update with missing routing when routing is required should fail");
        for (int i = 0; i < 5; i++) {
            fail("delete with missing routing when routing is required should fail");
            .setRouting(secondRoutingValue)
            );
        logger.info("--> verifying mget with ids [1,2], with routing [0], should succeed");
            idShard = operationRouting.shardId(state, index, id, null);
        logger.info("--> indexing with id [1], and routing [{}]", routingValue);
                assertThat(bulkItemResponse.getFailure().getStatus(), equalTo(RestStatus.BAD_REQUEST));
            for (BulkItemResponse bulkItemResponse : bulkResponse) {
                client().prepareSearch()
        } while (idShard.getId() == routingShard.id());
        );
        for (int i = 0; i < 5; i++) {
            assertThat(client().prepareGet("test", "1").setRouting(routingValue).execute().actionGet().isExists(), equalTo(false));
        for (int i = 0; i < 5; i++) {
        logger.info("--> search with {},{} indexRoutings , should find two", routingValue, "1");
            .indices()
            .setRefreshPolicy(RefreshPolicy.IMMEDIATE)
            assertThat(
 * compatible open source license.
        }
    }
            .add(new TermVectorsRequest(indexOrAlias(), "2").routing(routingValue))
            for (BulkItemResponse bulkItemResponse : bulkResponse) {
    public void testSimpleCrudRouting() throws Exception {
            try {
                .execute()
            .setMapping(XContentFactory.jsonBuilder().startObject().startObject("_routing").field("required", true).endObject().endObject())
        client().prepareDelete("test", "1").setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();
            assertThat(e.getMessage(), equalTo("routing is required for [test]/[1]"));
        for (int i = 0; i < 5; i++) {
            assertThat(client().prepareGet("test", "1").execute().actionGet().isExists(), equalTo(false));
            .setSource("field", "value1")
                .add(new UpdateRequest(indexOrAlias(), "1").doc(Requests.INDEX_CONTENT_TYPE, "field", "value2"))
        try {
                    .getTotalHits()
        int routing = -1;
 * GitHub history for details.
                client().prepareGet(indexOrAlias(), "1").execute().actionGet().isExists();
                    .actionGet()
            .actionGet();
            assertThat(client().prepareGet("test", "1").setRouting(routingValue).execute().actionGet().isExists(), equalTo(true));
        logger.info("--> deleting with no routing, should not delete anything");
        client().admin()
            assertThat(
            .setRouting(routingValue)
 * specific language governing permissions and limitations
            .actionGet();
            assertThat(
        }
import org.opensearch.action.update.UpdateRequest;
 *
        assertThat(multiTermVectorsResponse.getResponses()[1].getResponse().isExists(), equalTo(true));
        client().prepareIndex("test")
    public String findNonMatchingRoutingValue(String index, String id) {
                    .setSize(0)
        assertThat(updateResponse.getVersion(), equalTo(2L));
                    .actionGet()
    public void testRequiredRoutingMappingVariousAPIs() throws Exception {
                fail();
    }
/*
                equalTo(2L)
                    .getTotalHits()
                    .actionGet()
    }
                    .actionGet()
            .setId("1")
        try {
                client().prepareSearch()
            assertThat(e.getMessage(), equalTo("routing is required for [test]/[2]"));
                    .execute()
        }
        }
                    .getHits()
        }
        assertThat(
        String routingValue = findNonMatchingRoutingValue("test", "1");
            .get();
        }
    }
            .add(new TermVectorsRequest(indexOrAlias(), "1").routing(routingValue))
        logger.info("--> search with {} routing, should find one", routingValue);
            try {
import org.opensearch.action.termvectors.TermVectorsResponse;
            .addAlias(new Alias("alias"))
                    .execute()
        assertThat(multiTermVectorsResponse.getResponses()[1].getId(), equalTo("2"));
                .execute()
                assertThat(bulkItemResponse.isFailed(), equalTo(true));
 *
                    .value(),
        assertThat(multiGetResponse.getResponses()[0].isFailed(), equalTo(true));
            );
        }
                    .getTotalHits()
            );
            .setDoc(Requests.INDEX_CONTENT_TYPE, "field1", "value1")
