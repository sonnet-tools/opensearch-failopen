        index.get();
        IndicesStatsResponse rsp = client().admin().indices().prepareStats("test").get();
        createIndex("test", Settings.builder().put("refresh_interval", -1).build());
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
import org.opensearch.action.support.WriteRequest.RefreshPolicy;
            .field("type", "long")
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * software distributed under the License is distributed on an
            // There shouldn't be a doc. If there is then we did *something* weird.
    }
                logger.info("timed out");
        client().prepareIndex("test").setId("2").setSource("foo", "bar", "bar", "baz", "baz", 43).get();
        assertEquals(uuid, rsp.getIndex("test").getUuid());
        ShardStats[] shards,
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        // stats2 should exceed stats since multiple segments stats were merged
 * this file be licensed under the Apache-2.0 license or a
            .field("type", "text")
 * Licensed to Elasticsearch under one or more contributor
        // Create an index without automatic refreshes
        client().admin().indices().prepareRefresh("test").get();
                .setSettings(Settings.builder().put("index.store.type", storeType.getSettingsKey()))
            assertEquals(0, common.docs.getCount());
        rsp = client().admin().indices().prepareStats("test").get();
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.Matchers.hasKey;
        IndicesStatsResponse rsp = client().admin().indices().prepareStats().get();
 * Modifications Copyright OpenSearch Contributors. See
    public void testSegmentStats() throws Exception {
    }
import org.opensearch.core.common.Strings;
                .prepareCreate("test")
    public void testCommitStats() throws Exception {
        ensureGreen("test");
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        SegmentsStats stats = rsp.getTotal().getSegments();
    }
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
            CommonStats common = stats.getIndices().get("test").getTotal();
            .startObject("foo")
import org.opensearch.index.engine.CommitStats;
        int successfulShards,
        SegmentsStats stats = rsp.getIndex("test").getTotal().getSegments();
                .setMapping(mapping)
        );
            .endObject()
            .field("doc_values", true)
            }
/*
import static org.hamcrest.Matchers.greaterThan;
    public static IndicesStatsResponse newIndicesStatsResponse(
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
        int totalShards,
    }
            .startObject("properties")
            IndicesStatsResponse stats = client().admin().indices().prepareStats("test").clear().setRefresh(true).setDocs(true).get();
        // Index a document asynchronously so the request will only return when document is refreshed
import org.opensearch.index.engine.SegmentsStats;
        // should be more than one segment since data was indexed
 *
        int failedShards,
 *
            if (1 == common.refresh.getListeners()) {
            .endObject()
public class IndicesStatsTests extends OpenSearchSingleNodeTestCase {
/*
            .setId("test")
        String uuid = createIndex("test").indexUUID();
 * ownership. Elasticsearch licenses this file to you under
        assertAcked(
            assertThat(commitStats.getUserData(), hasKey(Translog.TRANSLOG_UUID_KEY));
        while (true) {
import static org.hamcrest.Matchers.notNullValue;
        IndexModule.Type storeType = IndexModule.defaultStoreType(true);
import org.opensearch.core.xcontent.XContentBuilder;
        assertThat(stats2.getCount(), greaterThan(stats.getCount()));
    public void testSegmentStatsEmptyIndex() {
        ActionFuture<IndexResponse> index = client().prepareIndex("test")
        // The document should appear in the statistics and the refresh listener should be gone
            assertThat(commitStats.getGeneration(), greaterThan(0L));
 * specific language governing permissions and limitations
        // Wait for the refresh listener to appear in the stats. Wait a long time because NFS tests can be quite slow!
            .startObject("bar")
            .execute();
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.action.ActionFuture;
                .indices()
            .field("store", true)
            .startObject("baz")
        // Refresh the index and wait for the request to come back
            .endObject()
            }
 * You may obtain a copy of the License at
     * Gives access to package private IndicesStatsResponse constructor for test purpose.
            client().admin()
import java.util.List;
        logger.info("starting to wait");
import java.util.concurrent.TimeUnit;
        createIndex("test");
/*
        ensureGreen("test");
        IndicesStatsResponse rsp = client().admin().indices().prepareStats("test").get();
        long end = System.nanoTime() + TimeUnit.MINUTES.toNanos(1);
            .field("type", "keyword")
        assertThat(stats.getCount(), greaterThan(0L));
        client().prepareIndex("test").setId("1").setSource("foo", "bar", "bar", "baz", "baz", 42).get();
import org.opensearch.common.xcontent.XContentFactory;
}
            .endObject()
        IndicesStatsResponse stats = client().admin().indices().prepareStats("test").clear().setRefresh(true).setDocs(true).get();
        // now check multiple segments stats are merged together
import org.opensearch.common.settings.Settings;
    public void testUuidOnRootStatsIndices() {
    /**
    ) {
 */
            if (end - System.nanoTime() < 0) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        XContentBuilder mapping = XContentFactory.jsonBuilder()
 * the Apache License, Version 2.0 (the "License"); you may
            final CommitStats commitStats = shardStats.getCommitStats();
    }
        return new IndicesStatsResponse(shards, totalShards, successfulShards, failedShards, shardFailures);
        IndicesStatsResponse rsp = client().admin().indices().prepareStats("test").get();
        }
     **/
        for (ShardStats shardStats : rsp.getIndex("test").getShards()) {
 * The OpenSearch Contributors require contributions made to
        CommonStats common = stats.getIndices().get("test").getTotal();
            assertThat(commitStats.getId(), notNullValue());
import org.opensearch.action.index.IndexResponse;
        assertEquals(0, common.refresh.getListeners());
        }
                fail("didn't get a refresh listener in time: " + Strings.toString(MediaTypeRegistry.JSON, common));
            assertNotNull(commitStats);
 *
        client().admin().indices().prepareRefresh("test").get();
        assertEquals(1, common.docs.getCount());
 * this work for additional information regarding copyright
            .endObject();
            .startObject()
            .setRefreshPolicy(RefreshPolicy.WAIT_UNTIL)
        SegmentsStats stats2 = rsp.getIndex("test").getTotal().getSegments();
        createIndex("test");
                break;
        assertEquals(0, stats.getCount());
 */
            .setSource("test", "test")
import org.opensearch.index.IndexModule;
        client().admin().indices().prepareRefresh("test").get();
 * under the License.
import org.opensearch.index.translog.Translog;
    public void testRefreshListeners() throws Exception {
 * GitHub history for details.
    }
package org.opensearch.action.admin.indices.stats;
        List<DefaultShardOperationFailedException> shardFailures
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
            .field("term_vector", "with_positions_offsets_payloads")
