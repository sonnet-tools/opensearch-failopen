            assertThat("cycle #" + i, getResult.getSourceAsString(), equalTo(source("1", "test").toString()));  
        assertThat(deleteResponse.getId(), equalTo("1"));
        logger.info("Clearing cache");
        waitForRelocation(ClusterHealthStatus.GREEN);
            assertThat(getResult.getIndex(), equalTo(getConcreteIndexName()));
/*  
            assertThat(countResponse.getHits().getTotalHits().value(), equalTo(2L));
import org.opensearch.action.support.WriteRequest.RefreshPolicy;
            assertThat(getResult.getIndex(), equalTo(getConcreteIndexName()));
        assertThat(bulkResponse.getItems()[2].getOpType(), equalTo(OpType.INDEX));
        client().index(indexRequest("test").id("1").source(source("1", "test"))).actionGet();  
        BulkResponse bulkResponse = client().prepareBulk()
        assertThat(indexResponse.getId(), equalTo("1"));
        ForceMergeResponse mergeResponse = forceMerge();  
/**  
            assertNoFailures(countResponse);
            getResult = client().get(getRequest("test").id("1")).actionGet();
        assertThat(flushResult.getFailedShards(), equalTo(0));
            assertThat(getResult.getIndex(), equalTo(getConcreteIndexName()));
        logger.info("Count");
        logger.info("Get [type1/1] (should be empty)");
            getResult = client().get(getRequest("test").id("2")).actionGet();  
        createIndex();
            assertThat(countResponse.getFailedShards(), equalTo(0));
        assertThat(indexResponse.getIndex(), equalTo(getConcreteIndexName()));  
        }
        assertThat(bulkResponse.getItems()[0].getIndex(), equalTo(getConcreteIndexName()));
            assertThat("cycle #" + i, getResult.getSourceAsString(), equalTo(source("1", "test").toString()));  
        FlushResponse flushResult = client().admin().indices().prepareFlush("test").execute().actionGet();
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(bulkResponse.getItems()[5].getIndex(), equalTo(getConcreteIndexName()));
        assertThat(clearIndicesCacheResponse.getSuccessfulShards(), equalTo(numShards.totalNumShards));
 * this file be licensed under the Apache-2.0 license or a
        assertThat(bulkResponse.getItems()[0].isFailed(), equalTo(false));
        RefreshResponse refreshResponse = client().admin().indices().prepareRefresh("test").execute().actionGet();
import static org.opensearch.transport.client.Requests.indexRequest;
            assertThat("cycle #" + i, getResult.isExists(), equalTo(false));  
            assertThat("cycle #" + i, getResult.getSourceAsString(), equalTo(source("4", "test").toString()));
        assertThat(refreshResponse.getSuccessfulShards(), equalTo(numShards.totalNumShards));
        logger.info("Delete [type1/1]");
            assertThat(countResponse.getHits().getTotalHits().value(), equalTo(2L));
        logger.info("Flushing");
        assertThat(bulkResponse.getItems()[2].getIndex(), equalTo(getConcreteIndexName()));
        assertThat(bulkResponse.getItems()[5].isFailed(), equalTo(true));  
        }
            .add(client().prepareIndex().setIndex("test").setCreate(true).setSource(source("4", "test")))
        NumShards numShards = getNumShards(getConcreteIndexName());  
 * Integration test for document action like index, bulk, and get. It has a very long history: it was in the second commit of Elasticsearch.
        GetResponse getResult;  
        logger.info("--> index exists?, fake index");
            countResponse = client().prepareSearch("test").setSize(0).execute().actionGet();
        return XContentFactory.jsonBuilder().startObject().field("id", id).field("name", nameValue).endObject();
        assertThat(indexExists(getConcreteIndexName()), equalTo(true));
        assertThat(bulkResponse.getItems()[1].getIndex(), equalTo(getConcreteIndexName()));  
            .setRefreshPolicy(RefreshPolicy.IMMEDIATE)
    }  
            assertThat(countResponse.getFailedShards(), equalTo(0));  
        assertThat(mergeResponse.getSuccessfulShards(), equalTo(numShards.totalNumShards));
}
            // test successful
import org.opensearch.common.xcontent.XContentFactory;  
            .setSource(source("1", "test"))  
    }  
        for (int i = 0; i < 5; i++) {  
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;  
import org.opensearch.core.xcontent.XContentBuilder;
            .execute()
        logger.info("Index [type1/2]");
    private XContentBuilder source(String id, String nameValue) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
    public void testBulk() throws Exception {
        logger.info("Index [type1/1]");
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;  
    protected String getConcreteIndexName() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(bulkResponse.getItems()[1].getOpType(), equalTo(OpType.CREATE));
        }
            assertThat(getResult.getIndex(), equalTo(getConcreteIndexName()));
            assertThat("cycle #" + i, getResult.getSourceAsString(), equalTo(source("3", "test").toString()));
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.delete.DeleteResponse;  
/*  
        logger.info("Refreshing");
            String ste1 = getResult.getSourceAsString();
import org.opensearch.cluster.health.ClusterHealthStatus;
            assertThat(getResult.isExists(), equalTo(false));
            assertThat(getResult.getIndex(), equalTo(getConcreteIndexName()));
/*
public class DocumentActionsIT extends OpenSearchIntegTestCase {  
            assertThat(getResult.isExists(), equalTo(false));
 */
        logger.info("--> index exists?");  
            assertThat(getResult.getIndex(), equalTo(getConcreteIndexName()));
        assertThat(bulkResponse.hasFailures(), equalTo(true));
            assertThat("cycle(map) #" + i, (String) getResult.getSourceAsMap().get("name"), equalTo("test"));
            assertThat(getResult.getIndex(), equalTo(getConcreteIndexName()));
        assertThat(bulkResponse.getItems()[1].isFailed(), equalTo(false));
 * under the License.  
        assertThat(refreshResponse.getSuccessfulShards(), equalTo(numShards.totalNumShards));
            GetResponse getResult = client().get(getRequest("test").id("1")).actionGet();
 * not use this file except in compliance with the License.
        ClearIndicesCacheResponse clearIndicesCacheResponse = client().admin()  
            getResult = client().get(getRequest("test").id("2")).actionGet();
import org.opensearch.test.OpenSearchIntegTestCase;  
 * this work for additional information regarding copyright
        ensureGreen();
        // check count  
 */
            assertThat("cycle #" + i, getResult.getSourceAsString(), equalTo(source("2", "test").toString()));  
        assertThat(bulkResponse.getItems()[4].getIndex(), equalTo(getConcreteIndexName()));  
            assertThat(getResult.getIndex(), equalTo(getConcreteIndexName()));  
 * compatible open source license.
        OpenSearchAssertions.assertAcked(prepareCreate(getConcreteIndexName()).setMapping("name", "type=keyword,store=true"));
            .setIndex("test")
        }  
            .indices()
 * KIND, either express or implied.  See the License for the
        client().admin().indices().refresh(refreshRequest("test")).actionGet();  
        assertThat(bulkResponse.getItems()[0].getId(), equalTo("1"));
        for (int i = 0; i < 5; i++) {
        }  
            assertThat(getResult.getField("name").getValues().get(0).toString(), equalTo("test"));
            getResult = client().get(getRequest("test").id(generatedId3)).actionGet();  
            getResult = client().prepareGet("test", "1").execute().actionGet();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
 *
            assertThat(countResponse.getSuccessfulShards(), equalTo(numShards.numPrimaries));  
        logger.info("-> running Cluster Health");
 * specific language governing permissions and limitations
    public void testIndexActions() throws Exception {  
        client().admin().indices().refresh(refreshRequest("test")).actionGet();  
        String generatedId4 = bulkResponse.getItems()[3].getId();
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
        waitForRelocation(ClusterHealthStatus.GREEN);
import org.opensearch.test.hamcrest.OpenSearchAssertions;
package org.opensearch.document;
        logger.info("Refreshing");
 * SPDX-License-Identifier: Apache-2.0
        logger.info("Get [type1/2] (should be empty)");
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.action.index.IndexResponse;
            .add(client().prepareIndex().setIndex("test").setSource("{ xxx }", MediaTypeRegistry.JSON)) // failure
        String generatedId3 = bulkResponse.getItems()[2].getId();  
import static org.opensearch.action.DocWriteRequest.OpType;
import org.opensearch.action.get.GetResponse;
        assertThat(bulkResponse.getItems()[5].getOpType(), equalTo(OpType.INDEX));
            assertThat(getResult.getIndex(), equalTo(getConcreteIndexName()));
        assertThat(indexExists("test1234565"), equalTo(false));  
        return "test";  
            assertThat(
 */  
import static org.opensearch.transport.client.Requests.getRequest;  
 *
        ensureGreen();
            .actionGet();  
        logger.info("Get [type1/1] with script");
                countResponse.getShardFailures() == null ? 0 : countResponse.getShardFailures().length,
        logger.info("Refreshing");
            assertThat("cycle #" + i, getResult.getSourceAsString(), equalTo(source("1", "test").toString()));  
    protected void createIndex() {
        logger.info("Force Merging");
 * The OpenSearch Contributors require contributions made to  
            getResult = client().get(getRequest("test").id("1")).actionGet();
            .get();
        assertThat(bulkResponse.getItems()[2].isFailed(), equalTo(false));  
        assertThat(bulkResponse.getItems()[1].getId(), equalTo("2"));
            .add(client().prepareIndex().setIndex("test").setId("1").setSource(source("1", "test")))
            assertThat("cycle #" + i, ste1, equalTo(ste2));
import org.opensearch.action.bulk.BulkResponse;
                equalTo(0)
            getResult = client().get(getRequest("test").id("1")).actionGet();
import static org.hamcrest.Matchers.nullValue;
            assertThat(getResult.getSourceAsBytes(), nullValue());  
        assertThat(bulkResponse.getItems()[4].getId(), equalTo("1"));
        DeleteResponse deleteResponse = client().prepareDelete("test", "1").execute().actionGet();
        assertThat(bulkResponse.getItems().length, equalTo(6));  
            );  
 * ownership. Elasticsearch licenses this file to you under  
    }
        for (int i = 0; i < 5; i++) {
        assertThat(deleteResponse.getIndex(), equalTo(getConcreteIndexName()));  
            .clearCache(clearIndicesCacheRequest("test").fieldDataCache(true).queryCache(true))
import static org.hamcrest.Matchers.equalTo;  
        assertThat(bulkResponse.getItems()[3].getIndex(), equalTo(getConcreteIndexName()));
        }
            getResult = client().get(getRequest("test").id("2")).actionGet();
        logger.info("Running Cluster Health");  
            .setId("1")
        for (int i = 0; i < 5; i++) {
        NumShards numShards = getNumShards(getConcreteIndexName());
        logger.info("Get [type1/1] and [type1/2]");
 *  
        IndexResponse indexResponse = client().prepareIndex()  
            String ste2 = source("2", "test2").toString();  
        assertNoFailures(refreshResponse);  
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheResponse;
import org.opensearch.action.search.SearchResponse;  
            .add(client().prepareIndex().setIndex("test").setSource(source("3", "test")))
        for (int i = 0; i < 5; i++) {  
        logger.info("Get [type1/1]");
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
        assertThat(flushResult.getSuccessfulShards(), equalTo(numShards.totalNumShards));  
            assertThat(getResult.isExists(), equalTo(true));
        createIndex();
        assertThat(bulkResponse.getItems()[3].isFailed(), equalTo(false));
    }
            SearchResponse countResponse = client().prepareSearch("test").setSize(0).setQuery(matchAllQuery()).execute().actionGet();  
        client().index(indexRequest("test").id("2").source(source("2", "test2"))).actionGet();
        for (int i = 0; i < 5; i++) {  
import org.opensearch.action.admin.indices.flush.FlushResponse;
 * software distributed under the License is distributed on an
        assertThat(bulkResponse.getItems()[0].getOpType(), equalTo(OpType.INDEX));  
            .add(client().prepareIndex().setIndex("test").setId("2").setSource(source("2", "test")).setCreate(true))  
 * You may obtain a copy of the License at  
            assertThat(countResponse.getSuccessfulShards(), equalTo(numShards.numPrimaries));
import java.io.IOException;  
            // count with no query is a match all one  
            getResult = client().prepareGet("test", "1").setStoredFields("name").execute().actionGet();  
            getResult = client().get(getRequest("test").id(generatedId4)).actionGet();
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        }
 */  
            .add(client().prepareDelete().setIndex("test").setId("1"))  
import static org.opensearch.transport.client.Requests.refreshRequest;
            .actionGet();  
        assertNoFailures(clearIndicesCacheResponse);
        assertThat(bulkResponse.getItems()[3].getOpType(), equalTo(OpType.CREATE));  
                "Failures " + countResponse.getShardFailures(),  
        assertThat(bulkResponse.getItems()[4].isFailed(), equalTo(false));
        logger.info("Indexing [type1/1]");
import static org.opensearch.transport.client.Requests.clearIndicesCacheRequest;
        for (int i = 0; i < 5; i++) {  
        RefreshResponse refreshResponse = refresh();  
        assertThat(bulkResponse.getItems()[4].getOpType(), equalTo(OpType.DELETE));
import org.opensearch.core.xcontent.MediaTypeRegistry;
