    }  
        OpenIndexResponse openIndexResponse1 = client.admin().indices().prepareOpen("test1").execute().actionGet();
            .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)  
        createIndex("test1");
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
        assertThat(healthResponse.isTimedOut(), equalTo(false));
        assertIndexIsOpened("test1");
        assertThat(openIndexResponse.isShardsAcknowledged(), equalTo(true));  
        assertAcked(client.admin().indices().prepareCreate("test").setSettings(settings).get());
        Client client = client();  
            () -> client.admin().indices().prepareOpen((String[]) null).execute().actionGet()
                assertThat(openIndexResponse.isShardsAcknowledged(), equalTo(true));  
        OpenIndexResponse response = client.admin().indices().prepareOpen("test").setTimeout("100ms").setWaitForActiveShards(2).get();
        assertBusy(
            } finally {
            )
    public void testOpenNoIndex() {  
        Client client = client();
        assertIndexIsClosed("test1", "test2");
        createIndex("test1");
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        }
                assertBlocked(client().admin().indices().prepareOpen("test"));
            .field("type", "keyword")  
        Settings settings = Settings.builder()
        assertThat(healthResponse.isTimedOut(), equalTo(false));  
        assertThat(healthResponse.isTimedOut(), equalTo(false));
            builder[i] = client().prepareIndex("test").setId("" + i).setSource("test", "init");
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertAcked(client.admin().indices().prepareClose("test").get());  
 * The OpenSearch Contributors require contributions made to  
                assertIndexIsClosed("test");
                equalTo(IndexMetadata.State.OPEN)
/*  
            .setTranslog(true)
import org.opensearch.action.index.IndexRequestBuilder;
 * license agreements. See the NOTICE file distributed with
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY_ALLOW_DELETE;
        }
        assertHitCount(searchResponse, docs);  
import org.opensearch.common.xcontent.XContentFactory;
        Exception e = expectThrows(
                assertIndexIsOpened("test");  
        int docs = between(10, 100);
            () -> client.admin().indices().prepareOpen("test1", "test2").execute().actionGet()
        ClusterHealthResponse healthResponse = client.admin().cluster().prepareHealth().setWaitForGreenStatus().execute().actionGet();
        assertThat(closeIndexResponse2.isAcknowledged(), equalTo(true));
import java.util.concurrent.ExecutionException;
    }
 * SPDX-License-Identifier: Apache-2.0
                enableIndexBlock("test", blockSetting);
            try {  
 * KIND, either express or implied.  See the License for the
 *  
        int docs = between(10, 100);
        AcknowledgedResponse closeIndexResponse = client.admin().indices().prepareClose("test*").execute().actionGet();
        assertThat(e.getMessage(), containsString("index is missing"));  
        Exception e = expectThrows(
        assertIndexIsOpened("test1", "test2", "a");
            .clear()
            .addAlias("test2", "test-alias")
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
            .indices()
        AcknowledgedResponse aliasesResponse1 = client.admin()
    public void testOpenCloseIndexWithBlocks() {  
        AcknowledgedResponse closeIndexResponse = client.admin().indices().prepareClose("test-alias").execute().actionGet();
    }
        });
        OpenIndexResponse openIndexResponse2 = client.admin().indices().prepareOpen("test2").execute().actionGet();
            .indices()  
import org.opensearch.action.support.ActiveShardCount;
    }
 * software distributed under the License is distributed on an
        assertThat(stats.getIndex(indexName), notNullValue());
        assertThat(closeIndexResponse.isAcknowledged(), equalTo(true));  
        }
 */  
        createIndex("test1", "test2", "test3");
    public void testCloseOpenWildcard() {
            client().admin().indices().prepareFlush("test").setForce(true).execute().get();  
    }
        createIndex("test1", "test2", "test3");  
        Exception e = expectThrows(IndexNotFoundException.class, () -> client.admin().indices().prepareOpen("test1").execute().actionGet());
        );  
    public void testOpenWaitingForActiveShardsFailed() throws Exception {
        ClusterHealthResponse healthResponse = client.admin().cluster().prepareHealth().setWaitForGreenStatus().execute().actionGet();
                enableIndexBlock("test", blockSetting);
        AcknowledgedResponse closeIndexResponse = client.admin().indices().prepareClose("test1").execute().actionGet();
        assertThat(openIndexResponse1.isShardsAcknowledged(), equalTo(true));
    public void testOpenOneMissingIndexIgnoreMissing() {  
            .addAlias("test1", "test-alias")
        for (int i = 0; i < docs; i++) {
            .setIndicesOptions(IndicesOptions.lenientExpandOpen())
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
        assertThat(openIndexResponse.isAcknowledged(), equalTo(true));
            .prepareAliases()  
 *
        createIndex("test1");  
public class OpenCloseIndexIT extends OpenSearchIntegTestCase {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            ActionRequestValidationException.class,  
import static org.opensearch.indices.state.CloseIndexIT.assertIndexIsClosed;
            .prepareAliases()
        assertThat(closeIndexResponse.isAcknowledged(), equalTo(true));
                // Opening an index is not blocked  
        createIndex("test1", "test2", "a");
        Client client = client();  
        OpenIndexResponse openIndexResponse = client.admin().indices().prepareOpen("test1").execute().actionGet();  
                stats.getIndex(indexName).getPrimaries().getTranslog().estimatedNumberOfOperations(),  
        IndicesStatsResponse stats = client().admin()  
                assertAcked(openIndexResponse);
        Client client = client();
    }
    public void testCloseOpenAllWildcard() {
            .prepareOpen("test1", "test2")
        Client client = client();
        assertThat(healthResponse.isTimedOut(), equalTo(false));
        ensureGreen("test");
                disableIndexBlock("test", blockSetting);
        ClusterHealthResponse healthResponse = client.admin().cluster().prepareHealth().setWaitForGreenStatus().execute().actionGet();
        client().admin().indices().prepareOpen("test").execute().get();
                uncommittedOps += 1;  
import org.opensearch.test.OpenSearchIntegTestCase;
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        );
        // Opening an index is blocked
        createIndex("test1", "test2");  
            .actionGet();
 *
        assertThat(openIndexResponse.isShardsAcknowledged(), equalTo(true));
            } finally {
        assertThat(openIndexResponse.isShardsAcknowledged(), equalTo(true));
            .prepareStats(indexName)
import java.util.Arrays;  
        OpenIndexResponse openIndexResponse = client.admin().indices().prepareOpen("*").execute().actionGet();  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_READ;
        assertThat(healthResponse.isTimedOut(), equalTo(false));
        OpenIndexResponse openIndexResponse1 = client.admin().indices().prepareOpen("test1").execute().actionGet();
        }
            .startObject()  
            .indices()  
package org.opensearch.indices.state;
import org.opensearch.transport.client.Client;  
        assertThat(openIndexResponse.isAcknowledged(), equalTo(true));  
                assertIndexIsClosed("test");  
import org.opensearch.cluster.metadata.IndexMetadata;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
        Client client = client();
        assertThat(openIndexResponse.isAcknowledged(), equalTo(true));
        assertIndexIsClosed("test1");
 * You may obtain a copy of the License at  
                assertAcked(closeIndexResponse);  
        AcknowledgedResponse aliasesResponse = client.admin()
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY;  
    public void testOpenCloseWithDocs() throws IOException, ExecutionException, InterruptedException {
import org.opensearch.action.ActionRequestValidationException;
        ClusterHealthResponse healthResponse = client.admin().cluster().prepareHealth().setWaitForGreenStatus().execute().actionGet();  
        createIndex(indexName, Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build());  
        assertThat(closeIndexResponse.isAcknowledged(), equalTo(true));  
            () -> assertThat(
import org.opensearch.common.settings.Settings;  
    }
        OpenIndexResponse openIndexResponse = client.admin().indices().prepareOpen("_all").execute().actionGet();
        assertThat(e.getMessage(), containsString("index is missing"));  
        createIndex("test1", "test2", "test3");  
            .execute()  
            .execute()  
            .get();  
            .execute()
            assertThat(
        IndexRequestBuilder[] builder = new IndexRequestBuilder[docs];  
import org.opensearch.core.rest.RestStatus;
        AcknowledgedResponse closeIndexResponse2 = client.admin().indices().prepareClose("test2").execute().actionGet();  
        AcknowledgedResponse closeIndexResponse = client.admin().indices().prepareClose("test1-alias").execute().actionGet();  
        ClusterHealthResponse healthResponse = client.admin().cluster().prepareHealth().setWaitForGreenStatus().execute().actionGet();
            .endObject()
    }
        Client client = client();  
    public void testOpenNullIndex() {  
        assertIndexIsClosed("test1", "test2", "test3");  
        AcknowledgedResponse closeIndexResponse = client.admin().indices().prepareClose("_all").execute().actionGet();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_METADATA;  
            .endObject()  
            () -> client.admin().indices().prepareOpen().execute().actionGet()
import org.opensearch.index.query.QueryBuilders;
        ClusterHealthResponse healthResponse = client.admin().cluster().prepareHealth().setWaitForGreenStatus().execute().actionGet();
            );
        IndicesOptions indicesOptions = IndicesOptions.STRICT_EXPAND_OPEN_CLOSED;
            client().prepareIndex("test").setId("" + i).setSource("test", "init").execute().actionGet();  
            assertThat(indexResponse.status(), is(RestStatus.CREATED));  
    public void testSimpleCloseOpenAlias() {
        assertThat(healthResponse.isTimedOut(), equalTo(false));
        assertThat(aliasesResponse2.isAcknowledged(), equalTo(true));
            .startObject("test")
        assertIndexIsOpened("test3");  
 * Licensed to Elasticsearch under one or more contributor  
    public void testSimpleCloseOpen() {
        OpenIndexResponse openIndexResponse = client.admin().indices().prepareOpen("test-alias").execute().actionGet();
        assertIndexIsOpened("test1", "test2", "test3");
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_WRITE;
            IndexNotFoundException.class,  
        createIndex("test");
            .indices()
        OpenIndexResponse openIndexResponse = client.admin()
 */
        ClusterHealthResponse healthResponse = client.admin().cluster().prepareHealth().setWaitForGreenStatus().execute().actionGet();
 */  
        OpenIndexResponse openIndexResponse = client.admin().indices().prepareOpen("test1-alias").execute().actionGet();
                uncommittedOps = 0;
        assertThat(healthResponse.isTimedOut(), equalTo(false));  
                assertIndexIsOpened("test");
            }
        }  
        String mapping = XContentFactory.jsonBuilder()
            final IndexResponse indexResponse = client().prepareIndex(indexName).setId(Long.toString(i)).setSource("field", i).get();
    public void testOpenAlreadyOpenedIndex() {  
            .actionGet();  
        assertThat(openIndexResponse.isAcknowledged(), equalTo(true));
        final int nbDocs = randomIntBetween(0, 50);
        assertThat(stats.getIndex(indexName).getPrimaries().getTranslog().getUncommittedOperations(), equalTo(0));  
            .prepareAliases()  
            .actionGet();  
    }
 * under the License.  
import org.opensearch.index.IndexNotFoundException;  
        assertThat(openIndexResponse.isAcknowledged(), equalTo(true));
        AcknowledgedResponse closeIndexResponse = client().admin().indices().prepareClose("test").execute().actionGet();  
        indexRandom(true, builder);
import org.opensearch.action.search.SearchResponse;
    public void testOpenOneMissingIndex() {  
        assertThat(openIndexResponse.isShardsAcknowledged(), equalTo(true));  
    }  
    }
            assertThat(stats.getIndex(indexName), notNullValue());
                assertBlocked(client().admin().indices().prepareClose("test"));
/*
        assertIndexIsOpened("test1");
    public void testCloseOpenAliasMultipleIndices() {
        Client client = client();
                client.admin().cluster().prepareState().get().getState().metadata().index("test").getState(),  
        assertThat(e.getMessage(), is("no such index [test1]"));  
        assertThat(healthResponse.isTimedOut(), equalTo(false));
        assertThat(closeIndexResponse1.isAcknowledged(), equalTo(true));
        assertIndexIsOpened("test1", "test2", "test3");
        assertIndexIsClosed("test1", "test2", "test3");
        assertIndexIsClosed("test");
        for (String blockSetting : Arrays.asList(SETTING_BLOCKS_READ, SETTING_BLOCKS_WRITE)) {  
        assertThat(openIndexResponse2.isAcknowledged(), equalTo(true));  
        assertThat(response.isShardsAcknowledged(), equalTo(false));  
    public void testTranslogStats() throws Exception {
        assertBusy(() -> {
        Client client = client();
import static org.hamcrest.Matchers.equalTo;  
        ClusterHealthResponse healthResponse = client.admin().cluster().prepareHealth().setWaitForGreenStatus().execute().actionGet();  
        assertAcked(closeIndexResponse);
        final int uncommittedTranslogOps = uncommittedOps;
    }
    }
                disableIndexBlock("test", blockSetting);
            IndicesStatsResponse stats = client().admin().indices().prepareStats(indexName).clear().setTranslog(true).get();  
        assertThat(stats.getIndex(indexName).getPrimaries().getTranslog().estimatedNumberOfOperations(), equalTo(0));
        assertThat(openIndexResponse2.isShardsAcknowledged(), equalTo(true));
        assertThat(openIndexResponse.isShardsAcknowledged(), equalTo(true));  
        assertIndexIsOpened("test1");
        assertThat(aliasesResponse.isAcknowledged(), equalTo(true));
        assertIndexIsOpened("test1", "test2", "test3");  
                equalTo(uncommittedTranslogOps)
        ClusterHealthResponse healthResponse = client.admin().cluster().prepareHealth().setWaitForGreenStatus().execute().actionGet();
            .execute()
 * this work for additional information regarding copyright
        ensureGreen();  
        createIndex("test1");
                enableIndexBlock("test", blockSetting);
            assertThat(stats.getIndex(indexName).getPrimaries().getTranslog().getUncommittedOperations(), equalTo(uncommittedTranslogOps));  
            .endObject()
        for (long i = 0; i < nbDocs; i++) {
        for (String blockSetting : Arrays.asList(SETTING_READ_ONLY, SETTING_BLOCKS_METADATA)) {
        assertIndexIsOpened("a");
        Client client = client();
        final String indexName = "test";
 * not use this file except in compliance with the License.
        // no problem if we try to open an index that's already in open state  
        }
        ensureGreen();
        if (randomBoolean()) {
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(openIndexResponse1.isAcknowledged(), equalTo(true));
        Client client = client();
 * specific language governing permissions and limitations
        // Closing an index is blocked
        );
        SearchResponse searchResponse = client().prepareSearch().setQuery(QueryBuilders.matchQuery("test", "init")).get();
            } else {
        assertThat(closeIndexResponse.isAcknowledged(), equalTo(true));  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertBlocked;
        for (String blockSetting : Arrays.asList(SETTING_READ_ONLY, SETTING_READ_ONLY_ALLOW_DELETE, SETTING_BLOCKS_METADATA)) {
            }
        );
            .startObject("properties")
    }
        }
import static org.hamcrest.Matchers.notNullValue;
            try {
import static org.hamcrest.Matchers.is;
import static org.opensearch.indices.state.CloseIndexIT.assertIndexIsOpened;  
    }
            if (rarely()) {
        assertThat(openIndexResponse.isShardsAcknowledged(), equalTo(true));
import java.io.IOException;
        assertIndexIsOpened("test1");  
        assertThat(openIndexResponse1.isShardsAcknowledged(), equalTo(true));  
            ActionRequestValidationException.class,  
    public void testCloseOpenMultipleIndices() {
import org.opensearch.action.admin.indices.open.OpenIndexResponse;  
                client().admin().indices().prepareFlush(indexName).get();  
        Client client = client();
        assertThat(aliasesResponse1.isAcknowledged(), equalTo(true));
            .setIndicesOptions(indicesOptions)  
import org.opensearch.action.support.IndicesOptions;  
        Client client = client();  
        assertThat(openIndexResponse.isShardsAcknowledged(), equalTo(true));
        OpenIndexResponse openIndexResponse = client.admin().indices().prepareOpen("test*").execute().actionGet();
        ensureGreen("test");
        assertNoFailures(searchResponse);
        createIndex("test1");
        assertThat(closeIndexResponse.isAcknowledged(), equalTo(true));
 * GitHub history for details.
        ClusterHealthResponse healthResponse = client.admin().cluster().prepareHealth().setWaitForGreenStatus().execute().actionGet();  
        for (int i = 0; i < docs; i++) {
                AcknowledgedResponse closeIndexResponse = client().admin().indices().prepareClose("test").execute().actionGet();
 * Modifications Copyright OpenSearch Contributors. See
            } finally {
    public void testCloseOpenAll() {
                // Closing an index is not blocked
    public void testSimpleOpenMissingIndex() {  
import org.opensearch.action.index.IndexResponse;  
            .build();
            }  
        assertThat(closeIndexResponse.isAcknowledged(), equalTo(true));
        assertIndexIsClosed("test1", "test2");
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
        int uncommittedOps = 0;  
}
        AcknowledgedResponse aliasesResponse2 = client.admin()
            .toString();
            }  
        Exception e = expectThrows(
/*  
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(openIndexResponse1.isAcknowledged(), equalTo(true));  
        assertAcked(client().admin().indices().prepareClose("test").setWaitForActiveShards(ActiveShardCount.ONE));  
        assertThat(e.getMessage(), is("no such index [test2]"));  
    }  
        assertThat(healthResponse.isTimedOut(), equalTo(false));
        assertAcked(client().admin().indices().prepareCreate("test").setMapping(mapping));  
        Client client = client();
    }
        assertThat(openIndexResponse.isAcknowledged(), equalTo(true));  
            .indices()
        assertThat(openIndexResponse.isAcknowledged(), equalTo(true));
        client().admin().indices().prepareClose("test").execute().get();
import static org.hamcrest.Matchers.containsString;
                disableIndexBlock("test", blockSetting);  
                OpenIndexResponse openIndexResponse = client().admin().indices().prepareOpen("test").execute().actionGet();
            .actionGet();
            .addAlias("test1", "test1-alias")
            try {  
 * compatible open source license.
        AcknowledgedResponse closeIndexResponse1 = client.admin().indices().prepareClose("test1").execute().actionGet();
        // check the index still contains the records that we indexed
        assertThat(healthResponse.isTimedOut(), equalTo(false));  
 * this file be licensed under the Apache-2.0 license or a
        AcknowledgedResponse closeIndexResponse = client.admin().indices().prepareClose("*").execute().actionGet();
        assertIndexIsClosed("test1");
        assertIndexIsOpened("test1", "test2");
        assertIndexIsClosed("test1", "test2");  
