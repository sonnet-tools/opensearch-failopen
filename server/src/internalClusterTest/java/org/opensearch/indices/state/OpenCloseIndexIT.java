        );
/*
import org.opensearch.action.index.IndexRequestBuilder;
                assertIndexIsClosed("test");
        assertThat(openIndexResponse.isAcknowledged(), equalTo(true));
            () -> client.admin().indices().prepareOpen((String[]) null).execute().actionGet()
        final int uncommittedTranslogOps = uncommittedOps;
        assertThat(aliasesResponse1.isAcknowledged(), equalTo(true));
        Exception e = expectThrows(IndexNotFoundException.class, () -> client.admin().indices().prepareOpen("test1").execute().actionGet());
            .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
 */
        });
        createIndex(indexName, Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build());
    }
        client().admin().indices().prepareClose("test").execute().get();
            }
        Client client = client();
        ClusterHealthResponse healthResponse = client.admin().cluster().prepareHealth().setWaitForGreenStatus().execute().actionGet();
        AcknowledgedResponse closeIndexResponse = client.admin().indices().prepareClose("test-alias").execute().actionGet();
        assertIndexIsOpened("test1");
            .prepareOpen("test1", "test2")
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY;
    }
        OpenIndexResponse openIndexResponse = client.admin().indices().prepareOpen("test-alias").execute().actionGet();
        assertIndexIsOpened("test1");
            try {
 * Licensed to Elasticsearch under one or more contributor
            .build();
        AcknowledgedResponse closeIndexResponse1 = client.admin().indices().prepareClose("test1").execute().actionGet();
        createIndex("test");
                equalTo(IndexMetadata.State.OPEN)
        AcknowledgedResponse closeIndexResponse = client.admin().indices().prepareClose("test1").execute().actionGet();
            } else {
        }
    public void testCloseOpenAliasMultipleIndices() {
            )
            .toString();
        assertThat(healthResponse.isTimedOut(), equalTo(false));
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
            } finally {
    public void testOpenNullIndex() {
        client().admin().indices().prepareOpen("test").execute().get();
                assertBlocked(client().admin().indices().prepareOpen("test"));
        // Opening an index is blocked
        int docs = between(10, 100);
            try {
        }
    public void testOpenOneMissingIndexIgnoreMissing() {
        AcknowledgedResponse closeIndexResponse = client.admin().indices().prepareClose("*").execute().actionGet();
            } finally {
        assertThat(stats.getIndex(indexName), notNullValue());
        assertIndexIsClosed("test1", "test2", "test3");
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_READ;
        OpenIndexResponse openIndexResponse = client.admin().indices().prepareOpen("test1").execute().actionGet();
        assertAcked(client().admin().indices().prepareCreate("test").setMapping(mapping));
    }
    }
import org.opensearch.action.admin.indices.open.OpenIndexResponse;
        createIndex("test1", "test2", "test3");
                OpenIndexResponse openIndexResponse = client().admin().indices().prepareOpen("test").execute().actionGet();
/*
        assertThat(openIndexResponse.isAcknowledged(), equalTo(true));
        AcknowledgedResponse closeIndexResponse2 = client.admin().indices().prepareClose("test2").execute().actionGet();
            assertThat(
        assertAcked(client.admin().indices().prepareClose("test").get());
        OpenIndexResponse openIndexResponse = client.admin().indices().prepareOpen("test*").execute().actionGet();
            .prepareStats(indexName)
        assertIndexIsOpened("test1");
                // Closing an index is not blocked
        Client client = client();
    public void testCloseOpenWildcard() {
            if (rarely()) {
    public void testOpenCloseWithDocs() throws IOException, ExecutionException, InterruptedException {
    public void testOpenNoIndex() {
import java.io.IOException;
        assertIndexIsClosed("test1", "test2");
        assertIndexIsOpened("test1", "test2", "a");
        createIndex("test1");
                disableIndexBlock("test", blockSetting);
        createIndex("test1");
        AcknowledgedResponse closeIndexResponse = client.admin().indices().prepareClose("test1-alias").execute().actionGet();
        AcknowledgedResponse aliasesResponse1 = client.admin()
 * the Apache License, Version 2.0 (the "License"); you may
    }
        SearchResponse searchResponse = client().prepareSearch().setQuery(QueryBuilders.matchQuery("test", "init")).get();
 *
            }
            () -> assertThat(
        AcknowledgedResponse aliasesResponse2 = client.admin()
            final IndexResponse indexResponse = client().prepareIndex(indexName).setId(Long.toString(i)).setSource("field", i).get();
        OpenIndexResponse openIndexResponse = client.admin().indices().prepareOpen("_all").execute().actionGet();
        assertThat(aliasesResponse2.isAcknowledged(), equalTo(true));
    }
            () -> client.admin().indices().prepareOpen("test1", "test2").execute().actionGet()
 *
        assertIndexIsClosed("test1");
                assertAcked(closeIndexResponse);
        assertThat(healthResponse.isTimedOut(), equalTo(false));
        assertIndexIsOpened("test1", "test2", "test3");
    }
        assertThat(healthResponse.isTimedOut(), equalTo(false));
            .setTranslog(true)
        createIndex("test1");
        Client client = client();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertBlocked;
            .setIndicesOptions(IndicesOptions.lenientExpandOpen())
        assertThat(openIndexResponse.isAcknowledged(), equalTo(true));
        createIndex("test1", "test2", "test3");
            ActionRequestValidationException.class,
        assertNoFailures(searchResponse);
            .prepareAliases()
        Client client = client();
        assertThat(openIndexResponse1.isShardsAcknowledged(), equalTo(true));
        OpenIndexResponse openIndexResponse1 = client.admin().indices().prepareOpen("test1").execute().actionGet();
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
        Settings settings = Settings.builder()
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
        String mapping = XContentFactory.jsonBuilder()
        ensureGreen();
        for (String blockSetting : Arrays.asList(SETTING_READ_ONLY, SETTING_BLOCKS_METADATA)) {
        assertThat(openIndexResponse2.isShardsAcknowledged(), equalTo(true));
        Exception e = expectThrows(
        assertThat(closeIndexResponse2.isAcknowledged(), equalTo(true));
        assertIndexIsOpened("a");
        assertThat(openIndexResponse.isShardsAcknowledged(), equalTo(true));
}
 *
        IndicesStatsResponse stats = client().admin()
    public void testOpenOneMissingIndex() {
        assertThat(openIndexResponse1.isAcknowledged(), equalTo(true));
        }
        for (int i = 0; i < docs; i++) {
            .actionGet();
        indexRandom(true, builder);
                client.admin().cluster().prepareState().get().getState().metadata().index("test").getState(),
 * this file be licensed under the Apache-2.0 license or a
            );
                stats.getIndex(indexName).getPrimaries().getTranslog().estimatedNumberOfOperations(),
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_WRITE;
 */
        Client client = client();
                disableIndexBlock("test", blockSetting);
import org.opensearch.common.xcontent.XContentFactory;
        ClusterHealthResponse healthResponse = client.admin().cluster().prepareHealth().setWaitForGreenStatus().execute().actionGet();
        createIndex("test1", "test2");
 * not use this file except in compliance with the License.
        assertIndexIsOpened("test3");
        }
        assertThat(healthResponse.isTimedOut(), equalTo(false));
import org.opensearch.action.search.SearchResponse;
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
    }
        Client client = client();
        assertIndexIsOpened("test1");
        assertThat(healthResponse.isTimedOut(), equalTo(false));
            try {
                assertBlocked(client().admin().indices().prepareClose("test"));
        AcknowledgedResponse closeIndexResponse = client.admin().indices().prepareClose("test*").execute().actionGet();
import static org.hamcrest.Matchers.notNullValue;
import org.opensearch.test.OpenSearchIntegTestCase;
 * software distributed under the License is distributed on an
    public void testSimpleCloseOpenAlias() {
/*
import org.opensearch.index.IndexNotFoundException;
        assertThat(e.getMessage(), containsString("index is missing"));
                assertIndexIsOpened("test");
                uncommittedOps = 0;
            .get();
            .field("type", "keyword")
        // Closing an index is blocked
    public void testCloseOpenAll() {
                AcknowledgedResponse closeIndexResponse = client().admin().indices().prepareClose("test").execute().actionGet();
        OpenIndexResponse openIndexResponse = client.admin().indices().prepareOpen("test1-alias").execute().actionGet();
                enableIndexBlock("test", blockSetting);
                assertThat(openIndexResponse.isShardsAcknowledged(), equalTo(true));
    public void testCloseOpenMultipleIndices() {
        assertIndexIsOpened("test1", "test2", "test3");
        Client client = client();
        assertAcked(client().admin().indices().prepareClose("test").setWaitForActiveShards(ActiveShardCount.ONE));
        );
        assertThat(openIndexResponse.isAcknowledged(), equalTo(true));
                disableIndexBlock("test", blockSetting);
        ClusterHealthResponse healthResponse = client.admin().cluster().prepareHealth().setWaitForGreenStatus().execute().actionGet();
                assertIndexIsOpened("test");
        ClusterHealthResponse healthResponse = client.admin().cluster().prepareHealth().setWaitForGreenStatus().execute().actionGet();
            builder[i] = client().prepareIndex("test").setId("" + i).setSource("test", "init");
import org.opensearch.action.support.ActiveShardCount;
        assertThat(closeIndexResponse.isAcknowledged(), equalTo(true));
    public void testTranslogStats() throws Exception {
import org.opensearch.transport.client.Client;
            assertThat(stats.getIndex(indexName).getPrimaries().getTranslog().getUncommittedOperations(), equalTo(uncommittedTranslogOps));
            assertThat(indexResponse.status(), is(RestStatus.CREATED));
import java.util.Arrays;
        ClusterHealthResponse healthResponse = client.admin().cluster().prepareHealth().setWaitForGreenStatus().execute().actionGet();
    }
    }
        OpenIndexResponse openIndexResponse = client.admin().indices().prepareOpen("*").execute().actionGet();
            IndexNotFoundException.class,
            .indices()
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY_ALLOW_DELETE;
        assertThat(healthResponse.isTimedOut(), equalTo(false));
            .execute()
        assertHitCount(searchResponse, docs);
        assertThat(e.getMessage(), containsString("index is missing"));
        assertIndexIsClosed("test");
            .execute()
 * license agreements. See the NOTICE file distributed with
        assertIndexIsClosed("test1", "test2", "test3");
                enableIndexBlock("test", blockSetting);
            .addAlias("test1", "test-alias")
                assertAcked(openIndexResponse);
        assertThat(e.getMessage(), is("no such index [test2]"));
    public void testSimpleCloseOpen() {
import static org.hamcrest.Matchers.equalTo;
            .actionGet();
        createIndex("test1", "test2", "test3");
import org.opensearch.action.support.IndicesOptions;
        createIndex("test1", "test2", "a");
            .actionGet();
        }
            }
            .addAlias("test1", "test1-alias")
import org.opensearch.action.ActionRequestValidationException;
        for (String blockSetting : Arrays.asList(SETTING_BLOCKS_READ, SETTING_BLOCKS_WRITE)) {
                client().admin().indices().prepareFlush(indexName).get();
import static org.opensearch.indices.state.CloseIndexIT.assertIndexIsOpened;
import java.util.concurrent.ExecutionException;
        Client client = client();
        assertBusy(
        assertThat(openIndexResponse.isAcknowledged(), equalTo(true));
            .actionGet();
        IndexRequestBuilder[] builder = new IndexRequestBuilder[docs];
        OpenIndexResponse openIndexResponse = client.admin()
            .execute()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertThat(stats.getIndex(indexName).getPrimaries().getTranslog().getUncommittedOperations(), equalTo(0));
        ClusterHealthResponse healthResponse = client.admin().cluster().prepareHealth().setWaitForGreenStatus().execute().actionGet();
        );
    public void testOpenWaitingForActiveShardsFailed() throws Exception {
            .endObject()
                uncommittedOps += 1;
        assertThat(openIndexResponse.isShardsAcknowledged(), equalTo(true));
            .indices()
 * compatible open source license.
            .setIndicesOptions(indicesOptions)
            () -> client.admin().indices().prepareOpen().execute().actionGet()
        ensureGreen("test");
            }
        assertThat(response.isShardsAcknowledged(), equalTo(false));
                // Opening an index is not blocked
                equalTo(uncommittedTranslogOps)
            .startObject("test")
        createIndex("test1");
        assertThat(healthResponse.isTimedOut(), equalTo(false));
            .endObject()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
        }
        assertThat(openIndexResponse2.isAcknowledged(), equalTo(true));
        Client client = client();
 * The OpenSearch Contributors require contributions made to
        assertIndexIsClosed("test1", "test2");
    public void testOpenCloseIndexWithBlocks() {
        AcknowledgedResponse aliasesResponse = client.admin()
        assertIndexIsOpened("test1", "test2");
        assertThat(openIndexResponse.isShardsAcknowledged(), equalTo(true));
            .indices()
package org.opensearch.indices.state;
        assertIndexIsOpened("test1", "test2", "test3");
 * GitHub history for details.
import org.opensearch.core.rest.RestStatus;
 */
        assertThat(e.getMessage(), is("no such index [test1]"));
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_METADATA;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * specific language governing permissions and limitations
            .prepareAliases()
        assertThat(healthResponse.isTimedOut(), equalTo(false));
        ensureGreen();
 *    http://www.apache.org/licenses/LICENSE-2.0
            .indices()
            ActionRequestValidationException.class,
            .startObject()
            .startObject("properties")
        int docs = between(10, 100);
            .endObject()
        OpenIndexResponse response = client.admin().indices().prepareOpen("test").setTimeout("100ms").setWaitForActiveShards(2).get();
        assertIndexIsClosed("test1", "test2");
            .prepareAliases()
        assertThat(openIndexResponse.isShardsAcknowledged(), equalTo(true));
        assertThat(openIndexResponse1.isShardsAcknowledged(), equalTo(true));
import org.opensearch.index.query.QueryBuilders;
            IndicesStatsResponse stats = client().admin().indices().prepareStats(indexName).clear().setTranslog(true).get();
        assertThat(healthResponse.isTimedOut(), equalTo(false));
        Client client = client();
        ClusterHealthResponse healthResponse = client.admin().cluster().prepareHealth().setWaitForGreenStatus().execute().actionGet();
        assertThat(closeIndexResponse.isAcknowledged(), equalTo(true));
        assertIndexIsClosed("test1");
        assertThat(openIndexResponse.isAcknowledged(), equalTo(true));
        assertThat(openIndexResponse.isAcknowledged(), equalTo(true));
        assertAcked(closeIndexResponse);
import org.opensearch.action.index.IndexResponse;
            } finally {
    }
        ClusterHealthResponse healthResponse = client.admin().cluster().prepareHealth().setWaitForGreenStatus().execute().actionGet();
    }
        ClusterHealthResponse healthResponse = client.admin().cluster().prepareHealth().setWaitForGreenStatus().execute().actionGet();
    }
        AcknowledgedResponse closeIndexResponse = client().admin().indices().prepareClose("test").execute().actionGet();
            assertThat(stats.getIndex(indexName), notNullValue());
            client().prepareIndex("test").setId("" + i).setSource("test", "init").execute().actionGet();
        );
    }
        final String indexName = "test";
        assertAcked(client.admin().indices().prepareCreate("test").setSettings(settings).get());
        for (int i = 0; i < docs; i++) {
            client().admin().indices().prepareFlush("test").setForce(true).execute().get();
        assertThat(healthResponse.isTimedOut(), equalTo(false));
        ClusterHealthResponse healthResponse = client.admin().cluster().prepareHealth().setWaitForGreenStatus().execute().actionGet();
    }
        Client client = client();
        assertThat(closeIndexResponse.isAcknowledged(), equalTo(true));
        for (String blockSetting : Arrays.asList(SETTING_READ_ONLY, SETTING_READ_ONLY_ALLOW_DELETE, SETTING_BLOCKS_METADATA)) {
        IndicesOptions indicesOptions = IndicesOptions.STRICT_EXPAND_OPEN_CLOSED;
        Exception e = expectThrows(
        assertBusy(() -> {
    public void testSimpleOpenMissingIndex() {
        for (long i = 0; i < nbDocs; i++) {
import org.opensearch.cluster.metadata.IndexMetadata;
public class OpenCloseIndexIT extends OpenSearchIntegTestCase {
import org.opensearch.common.settings.Settings;
    }
            .execute()
            .addAlias("test2", "test-alias")
        }
        OpenIndexResponse openIndexResponse2 = client.admin().indices().prepareOpen("test2").execute().actionGet();
            .indices()
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(openIndexResponse.isShardsAcknowledged(), equalTo(true));
import static org.hamcrest.Matchers.containsString;
        final int nbDocs = randomIntBetween(0, 50);
        assertThat(closeIndexResponse1.isAcknowledged(), equalTo(true));
    }
        Client client = client();
        ensureGreen("test");
        // check the index still contains the records that we indexed
        Client client = client();
        assertThat(aliasesResponse.isAcknowledged(), equalTo(true));
        if (randomBoolean()) {
        OpenIndexResponse openIndexResponse1 = client.admin().indices().prepareOpen("test1").execute().actionGet();
        assertThat(openIndexResponse1.isAcknowledged(), equalTo(true));
        assertThat(openIndexResponse.isShardsAcknowledged(), equalTo(true));
        AcknowledgedResponse closeIndexResponse = client.admin().indices().prepareClose("_all").execute().actionGet();
import static org.hamcrest.Matchers.is;
        int uncommittedOps = 0;
 * this work for additional information regarding copyright
        assertThat(closeIndexResponse.isAcknowledged(), equalTo(true));
        assertThat(closeIndexResponse.isAcknowledged(), equalTo(true));
 * ownership. Elasticsearch licenses this file to you under
            .clear()
        assertThat(closeIndexResponse.isAcknowledged(), equalTo(true));
    public void testCloseOpenAllWildcard() {
 * You may obtain a copy of the License at
        Client client = client();
    public void testOpenAlreadyOpenedIndex() {
        createIndex("test1");
import static org.opensearch.indices.state.CloseIndexIT.assertIndexIsClosed;
                enableIndexBlock("test", blockSetting);
 * under the License.
        assertThat(stats.getIndex(indexName).getPrimaries().getTranslog().estimatedNumberOfOperations(), equalTo(0));
                assertIndexIsClosed("test");
        // no problem if we try to open an index that's already in open state
        assertThat(openIndexResponse.isShardsAcknowledged(), equalTo(true));
 * Unless required by applicable law or agreed to in writing,
        Exception e = expectThrows(
