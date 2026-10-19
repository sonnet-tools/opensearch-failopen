 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        client().prepareIndex("test").setId("2").setSource("foo", "bar", "bar", "baz", "baz", 43).get();  
        );
/*
    }  
    public void testRefreshListeners() throws Exception {
 *
    }
    public static IndicesStatsResponse newIndicesStatsResponse(
            if (end - System.nanoTime() < 0) {  
        int failedShards,  
        // now check multiple segments stats are merged together
     * Gives access to package private IndicesStatsResponse constructor for test purpose.  
import org.opensearch.core.xcontent.XContentBuilder;  
        ensureGreen("test");
        ActionFuture<IndexResponse> index = client().prepareIndex("test")
        XContentBuilder mapping = XContentFactory.jsonBuilder()
        assertEquals(1, common.docs.getCount());
        createIndex("test");  
            assertEquals(0, common.docs.getCount());
            .startObject("foo")
 * not use this file except in compliance with the License.
            .setId("test")
            .startObject("baz")
 * software distributed under the License is distributed on an
            .startObject()  
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.Matchers.hasKey;  
        CommonStats common = stats.getIndices().get("test").getTotal();  
/*  
/*  
import org.opensearch.common.settings.Settings;
            .setRefreshPolicy(RefreshPolicy.WAIT_UNTIL)
        IndicesStatsResponse rsp = client().admin().indices().prepareStats("test").get();  
            CommonStats common = stats.getIndices().get("test").getTotal();  
        int successfulShards,
        assertAcked(
    }  
                .prepareCreate("test")
        IndicesStatsResponse stats = client().admin().indices().prepareStats("test").clear().setRefresh(true).setDocs(true).get();
            final CommitStats commitStats = shardStats.getCommitStats();  
import org.opensearch.core.common.Strings;
            assertThat(commitStats.getId(), notNullValue());  
import org.opensearch.action.support.WriteRequest.RefreshPolicy;
        logger.info("starting to wait");
            .endObject()
}
     **/
    public void testSegmentStats() throws Exception {  
 *
        ShardStats[] shards,  
    public void testUuidOnRootStatsIndices() {
            IndicesStatsResponse stats = client().admin().indices().prepareStats("test").clear().setRefresh(true).setDocs(true).get();
 * GitHub history for details.
            .field("term_vector", "with_positions_offsets_payloads")  
            if (1 == common.refresh.getListeners()) {  
        assertEquals(0, stats.getCount());  
 * Unless required by applicable law or agreed to in writing,
        for (ShardStats shardStats : rsp.getIndex("test").getShards()) {
 *  
            assertThat(commitStats.getGeneration(), greaterThan(0L));
        String uuid = createIndex("test").indexUUID();  
        index.get();
            .field("doc_values", true)
import org.opensearch.common.action.ActionFuture;  
 * the Apache License, Version 2.0 (the "License"); you may
        int totalShards,
        client().prepareIndex("test").setId("1").setSource("foo", "bar", "bar", "baz", "baz", 42).get();  
import org.opensearch.index.translog.Translog;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        }
            .field("type", "long")  
            .endObject()
 * compatible open source license.
    }  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.index.IndexModule;
        // should be more than one segment since data was indexed
import static org.hamcrest.Matchers.notNullValue;
            }
        IndicesStatsResponse rsp = client().admin().indices().prepareStats("test").get();
        IndicesStatsResponse rsp = client().admin().indices().prepareStats().get();
        // Wait for the refresh listener to appear in the stats. Wait a long time because NFS tests can be quite slow!
        List<DefaultShardOperationFailedException> shardFailures
 * Licensed to Elasticsearch under one or more contributor  
        IndexModule.Type storeType = IndexModule.defaultStoreType(true);
 * Modifications Copyright OpenSearch Contributors. See
                .setSettings(Settings.builder().put("index.store.type", storeType.getSettingsKey()))  
 * under the License.  
        return new IndicesStatsResponse(shards, totalShards, successfulShards, failedShards, shardFailures);  
            .field("type", "keyword")  
        client().admin().indices().prepareRefresh("test").get();
            .setSource("test", "test")  
                logger.info("timed out");
        rsp = client().admin().indices().prepareStats("test").get();  
        long end = System.nanoTime() + TimeUnit.MINUTES.toNanos(1);  
            .execute();
    public void testSegmentStatsEmptyIndex() {
 */  
import org.opensearch.core.action.support.DefaultShardOperationFailedException;  
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * specific language governing permissions and limitations
        }
    }
import org.opensearch.test.OpenSearchSingleNodeTestCase;
 */  
        createIndex("test", Settings.builder().put("refresh_interval", -1).build());
                break;
import java.util.List;
 *    http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.action.admin.indices.stats;
 * The OpenSearch Contributors require contributions made to  
        createIndex("test");
            .startObject("bar")
 * You may obtain a copy of the License at  
    }
    public void testCommitStats() throws Exception {  
 */
            .endObject();  
            assertThat(commitStats.getUserData(), hasKey(Translog.TRANSLOG_UUID_KEY));
        ensureGreen("test");
        client().admin().indices().prepareRefresh("test").get();
 * license agreements. See the NOTICE file distributed with
        assertEquals(0, common.refresh.getListeners());
        assertThat(stats2.getCount(), greaterThan(stats.getCount()));  
            .endObject()  
            // There shouldn't be a doc. If there is then we did *something* weird.
 * this work for additional information regarding copyright
    /**
        // stats2 should exceed stats since multiple segments stats were merged
 * KIND, either express or implied.  See the License for the
            .endObject()
    ) {
        // Index a document asynchronously so the request will only return when document is refreshed  
 * this file be licensed under the Apache-2.0 license or a
import static org.hamcrest.Matchers.greaterThan;
        // The document should appear in the statistics and the refresh listener should be gone
        SegmentsStats stats = rsp.getTotal().getSegments();
        SegmentsStats stats2 = rsp.getIndex("test").getTotal().getSegments();
            .field("store", true)
        while (true) {
import java.util.concurrent.TimeUnit;
                fail("didn't get a refresh listener in time: " + Strings.toString(MediaTypeRegistry.JSON, common));
        assertThat(stats.getCount(), greaterThan(0L));  
        IndicesStatsResponse rsp = client().admin().indices().prepareStats("test").get();
import org.opensearch.index.engine.CommitStats;
        assertEquals(uuid, rsp.getIndex("test").getUuid());
import org.opensearch.common.xcontent.XContentFactory;
            }  
        // Create an index without automatic refreshes  
            .field("type", "text")
import org.opensearch.index.engine.SegmentsStats;  
            client().admin()
                .indices()  
                .setMapping(mapping)
public class IndicesStatsTests extends OpenSearchSingleNodeTestCase {  
            .startObject("properties")
            assertNotNull(commitStats);
        client().admin().indices().prepareRefresh("test").get();
        SegmentsStats stats = rsp.getIndex("test").getTotal().getSegments();
        // Refresh the index and wait for the request to come back  
import org.opensearch.action.index.IndexResponse;
