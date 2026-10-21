 */
        for (int i = 0; i < 5; i++) {
        assertThat(bulkResponse.getItems()[1].isFailed(), equalTo(false));
import static org.hamcrest.Matchers.nullValue;
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertThat("cycle #" + i, getResult.getSourceAsString(), equalTo(source("4", "test").toString()));
            assertThat(countResponse.getHits().getTotalHits().value(), equalTo(2L));
import org.opensearch.test.hamcrest.OpenSearchAssertions;
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
            .actionGet();
        assertThat(bulkResponse.getItems()[1].getIndex(), equalTo(getConcreteIndexName()));
        IndexResponse indexResponse = client().prepareIndex()
        assertThat(deleteResponse.getIndex(), equalTo(getConcreteIndexName()));
        assertThat(bulkResponse.getItems()[3].getIndex(), equalTo(getConcreteIndexName()));
            String ste1 = getResult.getSourceAsString();
            .clearCache(clearIndicesCacheRequest("test").fieldDataCache(true).queryCache(true))
        assertThat(indexExists(getConcreteIndexName()), equalTo(true));
        assertThat(flushResult.getSuccessfulShards(), equalTo(numShards.totalNumShards));
        assertThat(clearIndicesCacheResponse.getSuccessfulShards(), equalTo(numShards.totalNumShards));
        logger.info("--> index exists?");
        ensureGreen();
        assertThat(bulkResponse.getItems()[0].isFailed(), equalTo(false));
            assertThat(countResponse.getSuccessfulShards(), equalTo(numShards.numPrimaries));
            assertThat(
 */
            getResult = client().prepareGet("test", "1").execute().actionGet();
        assertThat(bulkResponse.getItems()[1].getId(), equalTo("2"));
import org.opensearch.common.xcontent.XContentFactory;
            // test successful
        RefreshResponse refreshResponse = refresh();
    }
    }
            assertThat(getResult.getIndex(), equalTo(getConcreteIndexName()));
            getResult = client().get(getRequest("test").id("1")).actionGet();
        for (int i = 0; i < 5; i++) {
 * SPDX-License-Identifier: Apache-2.0
        assertThat(bulkResponse.getItems()[5].getOpType(), equalTo(OpType.INDEX));
        assertThat(bulkResponse.getItems()[2].isFailed(), equalTo(false));
        for (int i = 0; i < 5; i++) {
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * under the License.
 * Integration test for document action like index, bulk, and get. It has a very long history: it was in the second commit of Elasticsearch.
    private XContentBuilder source(String id, String nameValue) throws IOException {
            assertThat("cycle #" + i, getResult.getSourceAsString(), equalTo(source("1", "test").toString()));
        OpenSearchAssertions.assertAcked(prepareCreate(getConcreteIndexName()).setMapping("name", "type=keyword,store=true"));
        assertThat(bulkResponse.getItems()[4].isFailed(), equalTo(false));
 * software distributed under the License is distributed on an
        for (int i = 0; i < 5; i++) {
 * not use this file except in compliance with the License.
            assertThat(getResult.getField("name").getValues().get(0).toString(), equalTo("test"));
        logger.info("Index [type1/2]");
        assertThat(indexResponse.getIndex(), equalTo(getConcreteIndexName()));
        ForceMergeResponse mergeResponse = forceMerge();
        for (int i = 0; i < 5; i++) {
            assertThat("cycle #" + i, ste1, equalTo(ste2));
            .add(client().prepareIndex().setIndex("test").setId("1").setSource(source("1", "test")))
 * compatible open source license.
        NumShards numShards = getNumShards(getConcreteIndexName());
            assertThat(countResponse.getFailedShards(), equalTo(0));
            assertThat(countResponse.getHits().getTotalHits().value(), equalTo(2L));
    }
    public void testBulk() throws Exception {
        logger.info("--> index exists?, fake index");
            .indices()
 * Unless required by applicable law or agreed to in writing,
        FlushResponse flushResult = client().admin().indices().prepareFlush("test").execute().actionGet();
        logger.info("Refreshing");
            assertThat(getResult.getSourceAsBytes(), nullValue());
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.action.support.WriteRequest.RefreshPolicy;
import static org.opensearch.action.DocWriteRequest.OpType;
        client().admin().indices().refresh(refreshRequest("test")).actionGet();
            assertThat("cycle #" + i, getResult.getSourceAsString(), equalTo(source("3", "test").toString()));
        client().index(indexRequest("test").id("1").source(source("1", "test"))).actionGet();
            .add(client().prepareIndex().setIndex("test").setCreate(true).setSource(source("4", "test")))
        assertThat(refreshResponse.getSuccessfulShards(), equalTo(numShards.totalNumShards));
            // count with no query is a match all one
                equalTo(0)
        RefreshResponse refreshResponse = client().admin().indices().prepareRefresh("test").execute().actionGet();
import org.opensearch.action.search.SearchResponse;
        logger.info("Clearing cache");
    protected String getConcreteIndexName() {
import static org.opensearch.transport.client.Requests.indexRequest;
            getResult = client().get(getRequest("test").id("1")).actionGet();
 */
/*
        assertThat(bulkResponse.getItems()[0].getOpType(), equalTo(OpType.INDEX));
        logger.info("Index [type1/1]");
    public void testIndexActions() throws Exception {
import org.opensearch.action.admin.indices.flush.FlushResponse;
        assertThat(bulkResponse.getItems()[4].getId(), equalTo("1"));
        logger.info("Delete [type1/1]");
                "Failures " + countResponse.getShardFailures(),
        logger.info("Indexing [type1/1]");
        waitForRelocation(ClusterHealthStatus.GREEN);
/**
            assertThat(getResult.isExists(), equalTo(false));
import static org.opensearch.transport.client.Requests.getRequest;
        assertThat(bulkResponse.getItems()[3].isFailed(), equalTo(false));
        return XContentFactory.jsonBuilder().startObject().field("id", id).field("name", nameValue).endObject();
    }
            );
        client().index(indexRequest("test").id("2").source(source("2", "test2"))).actionGet();
            .add(client().prepareIndex().setIndex("test").setSource("{ xxx }", MediaTypeRegistry.JSON)) // failure
import java.io.IOException;
 * You may obtain a copy of the License at
            assertThat(getResult.getIndex(), equalTo(getConcreteIndexName()));
package org.opensearch.document;
            .add(client().prepareIndex().setIndex("test").setId("2").setSource(source("2", "test")).setCreate(true))
        logger.info("-> running Cluster Health");
        assertThat(deleteResponse.getId(), equalTo("1"));
import static org.hamcrest.Matchers.equalTo;
        logger.info("Flushing");
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.xcontent.XContentBuilder;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
        logger.info("Get [type1/1] (should be empty)");
        }
        createIndex();
 * this work for additional information regarding copyright
        assertThat(bulkResponse.getItems()[0].getId(), equalTo("1"));
            assertThat(getResult.getIndex(), equalTo(getConcreteIndexName()));
public class DocumentActionsIT extends OpenSearchIntegTestCase {
            assertThat(getResult.getIndex(), equalTo(getConcreteIndexName()));
        BulkResponse bulkResponse = client().prepareBulk()
        waitForRelocation(ClusterHealthStatus.GREEN);
 * The OpenSearch Contributors require contributions made to
        }
            assertNoFailures(countResponse);
        assertNoFailures(clearIndicesCacheResponse);
            assertThat("cycle(map) #" + i, (String) getResult.getSourceAsMap().get("name"), equalTo("test"));
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
 * specific language governing permissions and limitations
    protected void createIndex() {
            .get();
            .setRefreshPolicy(RefreshPolicy.IMMEDIATE)
import org.opensearch.action.get.GetResponse;
        assertThat(refreshResponse.getSuccessfulShards(), equalTo(numShards.totalNumShards));
        }
            assertThat(getResult.isExists(), equalTo(true));
        assertThat(indexExists("test1234565"), equalTo(false));
            assertThat("cycle #" + i, getResult.isExists(), equalTo(false));
        assertThat(bulkResponse.getItems()[0].getIndex(), equalTo(getConcreteIndexName()));
import org.opensearch.action.index.IndexResponse;
        GetResponse getResult;
 * GitHub history for details.
        logger.info("Count");
            assertThat("cycle #" + i, getResult.getSourceAsString(), equalTo(source("2", "test").toString()));
            String ste2 = source("2", "test2").toString();
            .add(client().prepareIndex().setIndex("test").setSource(source("3", "test")))
 * KIND, either express or implied.  See the License for the
        for (int i = 0; i < 5; i++) {
            assertThat(getResult.getIndex(), equalTo(getConcreteIndexName()));
import org.opensearch.action.delete.DeleteResponse;
            getResult = client().prepareGet("test", "1").setStoredFields("name").execute().actionGet();
            assertThat(countResponse.getSuccessfulShards(), equalTo(numShards.numPrimaries));
/*
            assertThat(countResponse.getFailedShards(), equalTo(0));
}
import static org.opensearch.transport.client.Requests.refreshRequest;
            assertThat(getResult.getIndex(), equalTo(getConcreteIndexName()));
import org.opensearch.test.OpenSearchIntegTestCase;
        logger.info("Running Cluster Health");
        ensureGreen();
        assertNoFailures(refreshResponse);
            assertThat("cycle #" + i, getResult.getSourceAsString(), equalTo(source("1", "test").toString()));
        String generatedId3 = bulkResponse.getItems()[2].getId();
        assertThat(bulkResponse.hasFailures(), equalTo(true));
        }
            getResult = client().get(getRequest("test").id("2")).actionGet();
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;
            getResult = client().get(getRequest("test").id(generatedId3)).actionGet();
            countResponse = client().prepareSearch("test").setSize(0).execute().actionGet();
        assertThat(mergeResponse.getSuccessfulShards(), equalTo(numShards.totalNumShards));
        ClearIndicesCacheResponse clearIndicesCacheResponse = client().admin()
import static org.opensearch.transport.client.Requests.clearIndicesCacheRequest;
            .setId("1")
        assertThat(flushResult.getFailedShards(), equalTo(0));
        String generatedId4 = bulkResponse.getItems()[3].getId();
        logger.info("Get [type1/2] (should be empty)");
        logger.info("Get [type1/1] with script");
            getResult = client().get(getRequest("test").id(generatedId4)).actionGet();
            SearchResponse countResponse = client().prepareSearch("test").setSize(0).setQuery(matchAllQuery()).execute().actionGet();
        logger.info("Get [type1/1]");
            getResult = client().get(getRequest("test").id("2")).actionGet();
        logger.info("Force Merging");
            .add(client().prepareDelete().setIndex("test").setId("1"))
 * Licensed to Elasticsearch under one or more contributor
            assertThat(getResult.isExists(), equalTo(false));
            .execute()
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheResponse;
import org.opensearch.cluster.health.ClusterHealthStatus;
 * this file be licensed under the Apache-2.0 license or a
 *
        assertThat(bulkResponse.getItems()[2].getIndex(), equalTo(getConcreteIndexName()));
                countResponse.getShardFailures() == null ? 0 : countResponse.getShardFailures().length,
 * the Apache License, Version 2.0 (the "License"); you may
        logger.info("Refreshing");
        assertThat(bulkResponse.getItems()[4].getIndex(), equalTo(getConcreteIndexName()));
        DeleteResponse deleteResponse = client().prepareDelete("test", "1").execute().actionGet();
 *
        assertThat(bulkResponse.getItems()[2].getOpType(), equalTo(OpType.INDEX));
        assertThat(bulkResponse.getItems()[1].getOpType(), equalTo(OpType.CREATE));
 * ownership. Elasticsearch licenses this file to you under
            assertThat(getResult.getIndex(), equalTo(getConcreteIndexName()));
        logger.info("Get [type1/1] and [type1/2]");
        logger.info("Refreshing");
            .setSource(source("1", "test"))
            .actionGet();
        return "test";
        client().admin().indices().refresh(refreshRequest("test")).actionGet();
        assertThat(bulkResponse.getItems().length, equalTo(6));
            .setIndex("test")
            assertThat(getResult.getIndex(), equalTo(getConcreteIndexName()));
        assertThat(bulkResponse.getItems()[5].getIndex(), equalTo(getConcreteIndexName()));
    }
        // check count
        NumShards numShards = getNumShards(getConcreteIndexName());
 *
 * license agreements. See the NOTICE file distributed with
        }
        createIndex();
import org.opensearch.action.bulk.BulkResponse;
        assertThat(indexResponse.getId(), equalTo("1"));
            assertThat("cycle #" + i, getResult.getSourceAsString(), equalTo(source("1", "test").toString()));
        }
            getResult = client().get(getRequest("test").id("2")).actionGet();
            assertThat(getResult.getIndex(), equalTo(getConcreteIndexName()));
        }
        for (int i = 0; i < 5; i++) {
        assertThat(bulkResponse.getItems()[5].isFailed(), equalTo(true));
            GetResponse getResult = client().get(getRequest("test").id("1")).actionGet();
/*
        assertThat(bulkResponse.getItems()[4].getOpType(), equalTo(OpType.DELETE));
        assertThat(bulkResponse.getItems()[3].getOpType(), equalTo(OpType.CREATE));
            getResult = client().get(getRequest("test").id("1")).actionGet();
