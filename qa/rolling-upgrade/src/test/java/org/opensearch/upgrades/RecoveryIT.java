    public void testTurnOffTranslogRetentionAfterUpgraded() throws Exception {  
                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 2);
            @Override
     * Verifies that once all shard copies on the new version, we should turn off the translog retention for indices with soft-deletes.
                assertCount(index, "_only_nodes:" + nodes.get(1), 105);
            case OLD:  
                ensureGreen(index);  
                    .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
        }
            }
                if (details == null) {
                // then delayed allocation will kick in. When the node comes back, the cluster-manager will search for a copy  
import org.apache.hc.core5.http.io.entity.EntityUtils;
                throw new IllegalStateException("unknown type " + CLUSTER_TYPE);  
                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
                .put(EnableAllocationDecider.INDEX_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), "none")  
                // ensure the relocation from old node to new node has occurred; otherwise ensureGreen can
            );
                    client().performRequest(new Request("POST", "/" + index + "/_flush"));  
        assertClosedIndex(indexName, true);  
    private void assertClosedIndex(final String index, final boolean checkRoutingTable) throws IOException {  
            default:  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
                .put(INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "100ms");  
                assertThat("no history uuid found for shard on " + nodeID, historyUUID, notNullValue());
                // before timing out
                // node stops, we lose the cluster-manager too, so a replica will not be promoted)
        final Map<String, ?> routingTable = (Map<String, Object>) XContentMapValues.extractValue("routing_table.indices." + index, state);
        }
                    // before timing out
        assertClosedIndex(indexName, true);
                if (expectHistoryUUID == null) {  
import static org.hamcrest.Matchers.nullValue;
                updateIndexSettings(index, Settings.builder().put("index.routing.allocation.include._id", newNode));
                createIndex(index, settings.build());
                    long globalCheckpoint = ((Number) XContentMapValues.extractValue("global_checkpoint", seqNoStat)).longValue();
        PlainActionFuture<Void> future = new PlainActionFuture<>();
            assertEmptyTranslog(index);  
                break;
import java.util.HashMap;
     * Tests that with or without soft-deletes, we should perform an operation-based recovery if there were some
                    .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 2)
        final String indexName = "test_soft_deletes_disabled_warning";
            assertNoFileBasedRecovery(index, nodeName ->  
        indexDocs(indexName, randomInt(100), randomInt(100));
                // todo: verify this test can be removed in 3.0.0
                // trigger a primary relocation by excluding the last old node with a shard filter  
            ensureGlobalCheckpointSynced(index);
                    + " recovery [" + EntityUtils.toString(recoveryStateResponse.getEntity()) + "]");  
        switch (CLUSTER_TYPE) {
                    .put(INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "100ms")
        final int numberOfReplicas = Integer.parseInt(  
        final String indexName =
        assertThat(blocks.containsKey(String.valueOf(MetadataIndexStateService.INDEX_CLOSED_BLOCK_ID)), is(true));  
        Response response = client().performRequest(new Request("GET", "_nodes"));
 * You may obtain a copy of the License at  
        if (randomBoolean()) {
                ensureGreen(index);  
    }
                } else {
                .build());  
import java.io.IOException;
import java.util.concurrent.TimeUnit;
            Version version = Version.fromString(objectPath.evaluate("nodes." + id + ".version"));
        } else if (CLUSTER_TYPE == ClusterType.UPGRADED) {
                    // then delayed allocation will kick in. When the node comes back, the cluster-manager will search for a copy  
 * SPDX-License-Identifier: Apache-2.0
                client().performRequest(new Request("POST", index + "/_refresh"));
                break;
        final Version minimumNodeVersion = minimumNodeVersion();  
                assertCount(index, "_only_nodes:" + nodes.get(2), 105);  
        ObjectPath objectPath = ObjectPath.createFromResponse(response);  
                assertBusy(() -> {  
            }
            }
 * compatible open source license.
                assertCount(index, "_only_nodes:" + nodes.get(2), 105);
                    assertNotNull(state.toString(), assignedNodes);
 *
                for (Object nodeDetails : nodesMap.values()) {
import org.opensearch.index.IndexSettings;  
        final String index = "recovery_with_concurrent_indexing";
     * This test creates an index in the non upgraded cluster and closes it. It then checks that the index
                });  
            ensureGreen(index);
            syncedFlush(index, randomBoolean());  
     * but not too many uncommitted documents (i.e., less than 10% of committed documents or the extra translog)
            case MIXED:
            }
        ensureGreen(indexName);  
        for (String id : nodesAsMap.keySet()) {
        // so we expect the index to be closed and replicated
                fail("failed to get doc count for index [" + index + "] with preference [" + preference + "]" + " response [" + e + "]"
        final String index = "turn_off_translog_retention";
                .map(shard -> (Map<?, ?>) XContentMapValues.extractValue("seq_no", shard))
                if (oldNodeNames.size() == 1) {  
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(metadata, notNullValue());
                Settings.Builder settings = Settings.builder()
        final Map<String, ?> blocks = (Map<String, Object>) XContentMapValues.extractValue("blocks.indices." + index, state);
    public void testRetentionLeasesEstablishedWhenRelocatingPrimary() throws Exception {
package org.opensearch.upgrades;
 * KIND, either express or implied.  See the License for the
        } else {
        final String index = "test_update_doc";  
import org.opensearch.cluster.metadata.IndexMetadata;
import java.util.Objects;
        List<String> nodes = new ArrayList<>(nodeMap.keySet());
                createIndex(index, settings.build());
        if (checkRoutingTable) {  
                    settings.put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), randomBoolean());  
        final Request indexExistsRequest = new Request("HEAD", "/" + indexName);
import org.opensearch.Version;  
        } catch (ResponseException e) {
    }
            }
                updateIndexSettings(index, Settings.builder().put(INDEX_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), (String)null));
    }
    private void assertCount(final String index, final String preference, final int expectedCount) throws IOException {
                    assertThat("different history uuid found for shard on " + nodeID, historyUUID, equalTo(expectHistoryUUID));  
        }  
 * Unless required by applicable law or agreed to in writing,
                    long totalFiles = ((Number) XContentMapValues.extractValue("index.files.total", shard)).longValue();  
        return numDocs;
    public void testHistoryUUIDIsGenerated() throws Exception {
            }
                    Map<String, ?> state = entityAsMap(client().performRequest(new Request("GET", "/_cluster/state")));
        }
            @Override  
import java.util.ArrayList;
        assertNotNull(shards);
                    .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), between(1, 5))
    /**
            Map<?, ?> stats = entityAsMap(client().performRequest(new Request("GET", index + "/_stats?level=shards")));
            createIndex(indexName, Settings.builder()
                    .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
        }
    }  
    private String getNodeId(Predicate<Version> versionPredicate) throws IOException {  
                .put(INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "100ms")
                    CLUSTER_NAME + "-0," + CLUSTER_NAME + "-2," + CLUSTER_NAME + "-*")  
                }
                updateIndexSettings(index, Settings.builder().put(INDEX_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "primaries"));
                break;  
import org.opensearch.core.rest.RestStatus;
                    assertThat(XContentMapValues.extractValue("shard", shard), equalTo(i));
     */
                .put(SETTING_ALLOCATION_MAX_RETRY.getKey(), "0") // fail faster
                client().performRequest(new Request("POST", "/" + index + "/_flush"));  
                    @SuppressWarnings("unchecked") List<String> assignedNodes = (List<String>) XContentMapValues.extractValue(xpath, state);  
            final int id = idStart + i;
        if (randomBoolean()) {
            Settings.Builder settings = Settings.builder()
                foundReplica = true;
            ensureGreen(indexName);  
                updateIndexSettings(index, Settings.builder().put(INDEX_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "primaries"));
        }  
            case MIXED:
import org.opensearch.client.Request;
            ensurePeerRecoveryRetentionLeasesRenewedAndSynced(index);
import org.opensearch.client.ResponseException;
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, randomInt(2))
import static org.hamcrest.Matchers.is;
     */
                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
    }
            ensureGreen(index);
        final String index = "index_history_uuid";  
            for (int i = 0; i < numDocs; i++) {
                // then delayed allocation will kick in. When the node comes back, the cluster-manager will search for a copy  
                    final String oldNodeName = oldNodeNames.get(0);
import static com.carrotsearch.randomizedtesting.RandomizedTest.randomAsciiLettersOfLength;
    public void testUpdateDoc() throws Exception {
                break;  
import org.opensearch.index.mapper.MapperService;
        }
                    if (versionString.equals(Version.CURRENT.toString()) == false) {
                    .put("index.routing.allocation.include._tier_preference", "")
            protected void doRun() throws Exception {
        // index was created on a version that supports the replication of closed indices,  
        final Map<String, ?> state = entityAsMap(client().performRequest(new Request("GET", "/_cluster/state")));
            request.setJsonEntity("{\"settings\": " + Strings.toString(MediaTypeRegistry.JSON, settings.build()) + "}");
                ensurePeerRecoveryRetentionLeasesRenewedAndSynced(index);
                }
            updateIndexSettings(indexName,
        Map<Integer, Long> updates = new HashMap<>();
                    assertThat(shardStats.toString(), globalCheckpoint, equalTo(maxSeqNo));
                    .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 2)
                    assertOK(client().performRequest(putSettingsRequest));
    public void testRecoveryClosedIndex() throws Exception {
        if (CLUSTER_TYPE == ClusterType.OLD) {  
            createIndex(index, settings.build());
import static org.hamcrest.Matchers.in;
            indexDocs(index, 0, numDocs);
                    logger.info("total [{}] reused [{}]", totalFiles, reusedFiles);
            boolean softDeletesEnabled = true;  
                    .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)  
                Settings.Builder settings = Settings.builder()  
                future.onResponse(null);  
                .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)  
                    logger.info("--> excluding index [{}] from node [{}]", index, oldNodeName);
        switch (CLUSTER_TYPE) {
            indexDocs(index, 0, numDocs);
    }
import java.util.Collection;  
    }
                return id;
            }
                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)  
            case UPGRADED:
                    (Collection<Map<String, ?>>) XContentMapValues.extractValue("shards." + i, routingTable);  
            Request request = new Request("PUT", "/" + indexName);  
                    .put(SETTING_ALLOCATION_MAX_RETRY.getKey(), "0"); // fail faster
                client().performRequest(update);  
                break;  
        client().performRequest(new Request("POST", index + "/_refresh"));
                Settings.builder().put(IndexMetadata.INDEX_ROUTING_EXCLUDE_GROUP_PREFIX + "._id", nodes.get(randomInt(2))));  
                // but the recovering copy will be seen as invalid and the cluster health won't return to GREEN
        }  
                assertCount(index, "_only_nodes:" + nodes.get(0), 105);
            indexDoc.setJsonEntity("{\"test\": \"test_" + randomAsciiLettersOfLength(2) + "\"}");
            indexDocs(indexName, 0, randomInt(10));
 * specific language governing permissions and limitations
            createIndex(index, settings.build());  
    /** Ensure that we can always execute update requests regardless of the version of cluster */
        for (int i = 0; i < numDocs; i++) {
import org.opensearch.common.xcontent.XContentType;
            }
                    = ObjectPath.createFromResponse(client().performRequest(new Request("GET", "/_nodes"))).evaluate("nodes");
        final String index = "recover_and_create_leases_in_promotion";
/*
                throw new IllegalStateException("unknown type " + CLUSTER_TYPE);
        if (randomBoolean()) {
            .performRequest(new Request("GET", indexName + "/_recovery?detailed=true")));  
            indexDocs(index, 0, randomIntBetween(100, 200));
            int numDocs = randomInt(10);
        assertThat(blocks, notNullValue());
                asyncIndexDocs(index, 10, 50).get();  
        if (randomBoolean()) {
            public void onFailure(Exception e) {
            String.join("_", "index", CLUSTER_TYPE.toString(), Integer.toString(minimumNodeVersion.id)).toLowerCase(Locale.ROOT);  
    }
    public void testRetentionLeasesEstablishedWhenPromotingPrimary() throws Exception {
                // but the recovering copy will be seen as invalid and the cluster health won't return to GREEN
                    .put(SETTING_ALLOCATION_MAX_RETRY.getKey(), "0"); // fail faster  
            ensureGreen(indexName);
                        oldNodeNames.add((String) nodeDetailsMap.get("name"));
        assertEquals(nodes.size() - 2, numberOfReplicas);
                // return true even though shards haven't moved to the new node yet (allocation was throttled).
 */  
                    String xpath = "routing_table.indices." + index + ".shards.0.node";
    /**  
            }
                    assertThat(details, Matchers.empty());  
            indexDocs(index, 0, 100);  
                softDeletesEnabled = randomBoolean();  
 */
            assertThat(shardStats, hasSize(2));  
                );
                    .putNull("index.routing.allocation.include._tier_preference")
                    long localCheckpoint = ((Number) XContentMapValues.extractValue("local_checkpoint", seqNoStat)).longValue();
        assertTrue("must find replica", foundReplica);  
        background.start();  
                    assertThat(XContentMapValues.extractValue("index", shard), equalTo(index));
            closeIndex(indexName);  
        assertThat(metadata.get("state"), equalTo("close"));
        final String index = "recover_and_create_leases_in_relocation";  
    /**
        try {
                settings.put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), randomBoolean());
        ensureGreen(index);
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true).build());  
                    final Request putSettingsRequest = new Request("PUT", "/" + index + "/_settings");  
            client().performRequest(indexDoc);
                List<String> nodes = new ArrayList<>(nodeMap.keySet());
            Request indexDoc = new Request("PUT", index + "/_doc/" + id);  
                ensureGreen(index);
                    long maxSeqNo = ((Number) XContentMapValues.extractValue("max_seq_no", seqNoStat)).longValue();  
        }  
        for (int docId : updates.keySet()) {
                || nodeName.startsWith(CLUSTER_NAME + "-0")
                assertThat(shards.size(), equalTo(numberOfReplicas + 1));
            List<Map<?, ?>> shardStats = (List<Map<?, ?>>) XContentMapValues.extractValue("indices." + index + ".shards.0", stats);
                asyncIndexDocs(index, 60, 45).get();
                .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
 */
        final int numberOfReplicas = Integer.parseInt((String) XContentMapValues.extractValue("index.number_of_replicas", settings));  
/*
                final Map<?, ?> nodesMap
import static org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider.INDEX_ROUTING_ALLOCATION_ENABLE_SETTING;  
                .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
 * this file be licensed under the Apache-2.0 license or a
            ensurePeerRecoveryRetentionLeasesRenewedAndSynced(index);
                ensureGreen(index);  
        }  
            assertThat(Booleans.parseBoolean((String) XContentMapValues.extractValue("index.verified_before_close", settings)), is(true));
        }  
                long translogRecovered = ((Number) XContentMapValues.extractValue("translog.recovered", shard)).longValue();  
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (CLUSTER_TYPE == ClusterType.OLD) {
 * license agreements. See the NOTICE file distributed with
                    .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), between(0, 1))
        if (CLUSTER_TYPE == ClusterType.UPGRADED) {  
    public void testRecovery() throws Exception {
                    final String versionString = (String) nodeDetailsMap.get("version");  
                .build());
        final String indexName = "closed_index_created_on_old";  
        if (CLUSTER_TYPE == ClusterType.OLD) {
     * We test that a closed index makes no-op replica allocation/recovery only.
                    assertThat(shardStats.toString(), localCheckpoint, equalTo(maxSeqNo));
        final Response indexExistsResponse = client().performRequest(indexExistsRequest);
            if (minimumNodeVersion().before(Version.V_2_0_0) && randomBoolean()) {  
        final Map<String, Object> nodeMap = objectPath.evaluate("nodes");
                e.addSuppressed(inner);
import org.opensearch.client.Response;  
                indexDocs(index, 0, 10);
     * Asserts that an index is closed in the cluster state. If `checkRoutingTable` is true, it also asserts
            default:
        Map<String, Object> recoveries = entityAsMap(client()
                assertNoopRecoveries(indexName, s -> s.startsWith(CLUSTER_NAME));
                .filter(Objects::nonNull)
        }
                Response response = client().performRequest(new Request("GET", "_nodes"));
            closeIndex(indexName);  
     */
                // make sure that we can index while the replicas are recovering
                    .put(SETTING_ALLOCATION_MAX_RETRY.getKey(), "0"); // fail faster
    }
    private void ensureGlobalCheckpointSynced(String index) throws Exception {
        switch (CLUSTER_TYPE) {
            getIndexSettingsAsMap(indexName).get(IndexMetadata.SETTING_NUMBER_OF_REPLICAS).toString());
     * peer recoveries.
                }
                } else {
            Map<String, Object> doc = entityAsMap(client().performRequest(get));
        ensureGreen(indexName);
            Settings.Builder settings = Settings.builder()
                Request update = new Request("POST", index + "/_update/" + docId);
            Request get = new Request("GET", index + "/_doc/" + docId);  
 * In depth testing of the recovery mechanism during a rolling restart.
     * that the index has started shards.  
import static org.hamcrest.Matchers.equalTo;
                .forEach(seqNoStat -> {  
            indexDocs(index, randomIntBetween(0, 100), randomIntBetween(0, 3));  
                    .put(INDEX_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), (String)null)
        // index was created on a version that supports the replication of closed indices,
        }
                updateIndexSettings(index, Settings.builder()  
    public void testClosedIndexNoopRecovery() throws Exception {  
}
                settings.put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), randomBoolean());  
        final String indexName = "test-auto-expand-filtering";
                assertCount(index, "_only_nodes:" + nodes.get(0), 105);
        if (CLUSTER_TYPE == ClusterType.OLD) {
     */
        final String index = "test_recovery";  
import org.opensearch.cluster.metadata.MetadataIndexStateService;  
        ensurePeerRecoveryRetentionLeasesRenewedAndSynced(index);
        for (Map<String, ?> shard : shards) {  
                    assertThat(state.toString(), newNode, in(assignedNodes));
                ensureGreen(index);
            for (int shard = 0; shard < 2; shard++) {
            for (int i = 0; i < numberOfShards; i++) {
        assertClosedIndex(indexName, true);  
                ensureGreen(index); // wait for the primary to be assigned  
                update.setJsonEntity("{\"doc\": {\"updated_field\": " + value + "}}");
import java.util.concurrent.Future;  
            }
                // make sure that we can index while the replicas are recovering  
                assertNoopRecoveries(indexName, s -> s.startsWith(CLUSTER_NAME + "-0"));
                }
                    assertThat((String) XContentMapValues.extractValue("state", shard),
 *
                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
                .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)  
            createIndex(index, settings.build());  
    public void testAutoExpandIndicesDuringRollingUpgrade() throws Exception {
                assertCount(index, "_only_nodes:" + nodes.get(2), 60);
                .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)  
import static org.hamcrest.Matchers.hasSize;  
    /**  
                long value = randomNonNegativeLong();  
            case UPGRADED:
                if (minimumNodeVersion().before(Version.V_2_0_0) && randomBoolean()) {
    }
        final Map<String, Object> nodeMap = objectPath.evaluate("nodes");
                expectSoftDeletesWarning(request, indexName);  
                }, 60, TimeUnit.SECONDS);  
            client().performRequest(request);
        // index is created on a version that supports the replication of closed indices,  
        final Map<String, ?> metadata = (Map<String, Object>) XContentMapValues.extractValue("metadata.indices." + index, state);  
                ensureNoInitializingShards(); // wait for all other shard activity to finish
            indexDocs(index, 0, randomIntBetween(100, 200));
            case UPGRADED:  
                request.addParameter("preference", preference);
            flush(index, randomBoolean());  
            }
/**
            createIndex(index, Settings.builder()  
                updateIndexSettings(index, Settings.builder().put(INDEX_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), (String)null));
        ObjectPath objectPath = ObjectPath.createFromResponse(response);
        List<String> nodes = new ArrayList<>(nodeMap.keySet());  
        switch (CLUSTER_TYPE) {  
                updateIndexSettings(index, Settings.builder().put(INDEX_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "none"));
            if (minimumNodeVersion().before(Version.V_2_0_0) && randomBoolean()) {
            shardStatsRequest.addParameter("level", "shards");
            assertThat(XContentMapValues.extractValue("_source.updated_field", doc), equalTo(updates.get(docId)));
        }
            }  
                    final Map<?, ?> nodeDetailsMap = (Map<?, ?>) nodeDetails;
     * before we upgrade each node. This is important when we move from translog based to retention leases based  
            if (minimumNodeVersion().before(Version.V_2_0_0) && randomBoolean()) {
            final int times = randomIntBetween(0, 2);
                );
            List<Object> shardStats = objectPath.evaluate("indices." + index + ".shards.0");
 * this work for additional information regarding copyright
                    // but the recovering copy will be seen as invalid and the cluster health won't return to GREEN  
import static org.hamcrest.Matchers.oneOf;
        if (CLUSTER_TYPE == ClusterType.OLD) {
        Response response = client().performRequest(new Request("GET", "_nodes"));  
            if (minimumNodeVersion().before(Version.V_2_0_0) && randomBoolean()) {  
                .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
                    client().performRequest(new Request("DELETE", index + "/" + MapperService.SINGLE_MAPPING_NAME + "/" + i));  
                    .put(INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "100ms")  
                assertThat(shards, notNullValue());
                && targetNode.test((String) XContentMapValues.extractValue("target.name", shard))) {
     */
        boolean foundReplica = false;
    @SuppressWarnings("unchecked")
import org.opensearch.common.Booleans;
                } else if (randomBoolean()) {
                .put(INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "100ms")  
            final Response response = client().performRequest(request);  
                client().performRequest(new Request("POST", index + "/_refresh"));
    public void testSoftDeletesDisabledWarning() throws Exception {  
        }
        final String index = "relocation_with_concurrent_indexing";
            String expectHistoryUUID = null;
                ensureGreen(index);
                assertCount(index, "_only_nodes:" + nodes.get(1), 105);  
                    indexDocs(index, i, 1); // update
                settings.put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), randomBoolean());
        Thread background = new Thread(new AbstractRunnable() {  
     */
                indexDocs(index, idStart, numDocs);
        for (int docId = 0; docId < 100; docId++) {  
        }
        ensureGreen(index);
            case OLD: break;  
                // before timing out
import org.opensearch.common.xcontent.support.XContentMapValues;  
                    long reusedFiles = ((Number) XContentMapValues.extractValue("index.files.reused", shard)).longValue();
                    }  
                .put(SETTING_ALLOCATION_MAX_RETRY.getKey(), "0"); // fail faster
                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), between(1, 2)) // triggers nontrivial promotion  
                Settings.Builder settings = Settings.builder()
    public void testCloseIndexDuringRollingUpgrade() throws Exception {  
        ensureGreen(indexName);
            } catch (Exception inner) {
        assertThat("preference [" + preference + "]", actualDocs, equalTo(expectedCount));  
                ensureGreen(index);  
                assertCount(index, "_only_nodes:" + nodes.get(1), 60);
    }
                final Map<String, Object> nodeMap = objectPath.evaluate("nodes");
            assertThat(XContentMapValues.extractValue("index.verified_before_close", settings), nullValue());  
                .build());  
                client().performRequest(new Request("POST", "/" + index + "/_flush"));
import static org.hamcrest.Matchers.notNullValue;  
        }
            ensureGreen(index);
                    // then delayed allocation will kick in. When the node comes back, the cluster-manager will search for a copy
            case UPGRADED:
        List<Map<String, ?>> shards = (List<Map<String,?>>) XContentMapValues.extractValue(indexName + ".shards", recoveries);  
    private Future<Void> asyncIndexDocs(String index, final int idStart, final int numDocs) throws IOException {
            assertThat(routingTable, nullValue());
            final Request request = new Request("GET", index + "/_count");
                break;
    @SuppressWarnings("unchecked")
                break;  
            createIndex(indexName, Settings.builder()
 * not use this file except in compliance with the License.
    }
    }
        assertThat(settings, notNullValue());  
import org.opensearch.core.common.Strings;
            throw e;
                        oneOf("STARTED", "RELOCATING", "RELOCATED"));  
                asyncIndexDocs(index, 60, 45).get();
            ensureGreen(index);
            Settings.Builder settings = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1);
        }  
                }  
                    .putNull("index.routing.allocation.include._tier_preference")  
            case MIXED:
    /**  
            }  
        if (RestStatus.OK.getStatus() != indexExistsResponse.getStatusLine().getStatusCode()) {  
            createIndex(index, settings.build());
            ensureGreen(indexName);
                updates.put(docId, value);
                List<?> details = (List<?>) XContentMapValues.extractValue("index.files.details", shard);  
 * GitHub history for details.
        Response response = client().performRequest(new Request("GET", "_nodes"));
 * under the License.  
                    .put(INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "100ms")  
    /**  
        });
    }
        }, 60, TimeUnit.SECONDS);
                .put("index.routing.allocation.include._name", CLUSTER_NAME + "-0")
            ensureGlobalCheckpointSynced(index);  
    public void testRelocationWithConcurrentIndexing() throws Exception {
        @SuppressWarnings("unchecked")
            for (int i = 0; i < times; i++) {
            // uncommitted docs must be less than 10% of committed docs (see IndexSetting#FILE_BASED_RECOVERY_THRESHOLD_SETTING).
        if (CLUSTER_TYPE == ClusterType.OLD) {
            Settings.Builder settings = Settings.builder()
                Settings.builder().put(
                .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), between(1, 5))
            try {  
    }
            Settings.Builder settings = Settings.builder()
                asyncIndexDocs(index, 10, 50).get();  
                ObjectPath objectPath = ObjectPath.createFromResponse(response);  
            case OLD:
        return future;
                }
            ensureGreen(index);  
            case OLD:
        }  
                ensureGreen(index);
                .put(SETTING_ALLOCATION_MAX_RETRY.getKey(), "0"); // fail faster
    private void assertNoopRecoveries(String indexName, Predicate<String> targetNode) throws IOException {
                client().performRequest(new Request("POST", index + "/_refresh"));
            if (randomBoolean()) {  
        final int numberOfShards = Integer.parseInt((String) XContentMapValues.extractValue("index.number_of_shards", settings));
                updateIndexSettings(index, Settings.builder()  
/*  
import org.opensearch.action.support.PlainActionFuture;
                assertCount(index, "_only_nodes:" + nodes.get(0), 60);  
                client().performRequest(new Request("POST", index + "/_refresh"));
import org.opensearch.common.util.concurrent.AbstractRunnable;
import static org.opensearch.cluster.routing.UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING;
 *  
     * is effectively closed and potentially replicated (if the version the index was created on supports
            createIndex(indexName, Settings.builder()  
                ensurePeerRecoveryRetentionLeasesRenewedAndSynced(index);
        Map<String, Object> nodesAsMap = objectPath.evaluate("nodes");  
                    .put("index.routing.allocation.include._id", oldNode)  
                // before timing out
        }
 */  
    }
            final Settings.Builder settings = Settings.builder()  
            flush(index, randomBoolean());  
                    // before timing out
                    assertEquals("must reuse all files, recoveries [" + recoveries + "]", totalFiles, reusedFiles);  
        final String indexName = "closed_index_replica_allocation";
                break;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        indexExistsRequest.setOptions(allowTypesRemovalWarnings());  
                .put(IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS, "0-all")
import static org.opensearch.cluster.routing.allocation.decider.MaxRetryAllocationDecider.SETTING_ALLOCATION_MAX_RETRY;
                break;  
            createIndex(indexName, Settings.builder()
                    expectHistoryUUID = historyUUID;
                int numDocs = randomInt(10);  
                .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)  
            assertThat(routingTable, notNullValue());
                // once detailed recoveries works, remove this if.
                for (Map<String, ?> shard : shards) {  
     * is effectively closed and potentially replicated if the cluster supports replication of closed indices at the  
        }
            Response response = client().performRequest(shardStatsRequest);  
                assertEquals("must be noop, recoveries [" + recoveries + "]", 0, translogRecovered);
            }
import java.util.function.Predicate;
            actualDocs = Integer.parseInt(ObjectPath.createFromResponse(response).evaluate("count").toString());
     * the replication of closed indices) during the rolling upgrade.  
                if (randomBoolean()) {
                break;
    public void testRecoveryWithConcurrentIndexing() throws Exception {
                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), randomIntBetween(0, 2))
                .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
            updateIndexSettings(indexName,  
        if (CLUSTER_TYPE == ClusterType.OLD) {
                }
        if (CLUSTER_TYPE == ClusterType.OLD) {
 * Licensed to Elasticsearch under one or more contributor  
    }  
        } else {
                    "index.routing.allocation.include._name",
import java.util.Map;
import java.util.Locale;  
                // if the node with the replica is the first to be restarted, while a replica is still recovering
import java.util.List;
    private int indexDocs(String index, final int idStart, final int numDocs) throws IOException {  
                final String newNode = getNodeId(v -> v.equals(Version.CURRENT));  
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.hamcrest.Matchers;
                // make sure that no shards are allocated, so we can make sure the primary stays on the old node (when one  
            if (randomBoolean()) {
            }  
        final Version minimumNodeVersion = minimumNodeVersion();
 * the Apache License, Version 2.0 (the "License"); you may
            ensureGreen(indexName);
        final String index = "test_operation_based_recovery";
                final List<String> oldNodeNames = new ArrayList<>();  
                final Response recoveryStateResponse = client().performRequest(new Request("GET", index + "/_recovery"));
        assertBusy(() -> {  
                    // if the node with the replica is the first to be restarted, while a replica is still recovering
                    putSettingsRequest.setJsonEntity("{\"index.routing.allocation.exclude._name\":\"" + oldNodeName + "\"}");
            }
            closeIndex(indexName);
            // allocate replica to node-2
    }
import org.opensearch.common.settings.Settings;  
        }
                String nodeID = objectPath.evaluate("indices." + index + ".shards.0." + shard + ".routing.node");  
                settings.put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), softDeletesEnabled);
            createIndex(index, settings.build());
        }  
        // so we expect the index to be closed and replicated
import org.opensearch.test.rest.yaml.ObjectPath;  
            indexDocs(index, randomIntBetween(0, 100), randomIntBetween(0, 3));
                break;
                final Collection<Map<String, ?>> shards =
                // then delayed allocation will kick in. When the node comes back, the cluster-manager will search for a copy  
    }  
    private static String CLUSTER_NAME = System.getProperty("tests.clustername");  
                createIndex(index, settings.build());  
public class RecoveryIT extends AbstractRollingTestCase {
        ensureGreen(indexName);
            syncedFlush(index, randomBoolean());
            Request shardStatsRequest = new Request("GET", index + "/_stats");
        return null;
                    .put("index.routing.allocation.include._id", (String)null)
                // remove the replica and guaranteed the primary is placed on the old node
                    assertNotNull(details);
                .put(INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "100ms")  
     * time the index was closed.
            if (softDeletesEnabled == false) {
                indexDocs(index, 0, 10);
                future.onFailure(e);  
                || (nodeName.startsWith(CLUSTER_NAME + "-1") && Booleans.parseBoolean(System.getProperty("tests.first_round")) == false));  
                indexDocs(index, 0, numDocs);
                // if the node with the replica is the first to be restarted, while a replica is still recovering
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
 * software distributed under the License is distributed on an
            indexDocs(index, randomIntBetween(0, 100), randomIntBetween(0, 100));
                }
                ensureGreen(index);
 * Modifications Copyright OpenSearch Contributors. See  
     * This test creates and closes a new index at every stage of the rolling upgrade. It then checks that the index
        }
            ensureGreen(index);  
        ensureGreen(indexName);  
    public void testOperationBasedRecovery() throws Exception {  
        final int actualDocs;  
                // but the recovering copy will be seen as invalid and the cluster health won't return to GREEN
                if (randomBoolean()) {  
                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 2);
                    .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 2)  
            if (versionPredicate.test(version)) {  
            syncedFlush(index, randomBoolean());
            }
            if (shard.get("primary") == Boolean.FALSE
                assertCount(index, "_only_nodes:" + newNode, 60);  
            flush(index, true);
        }  
        }  
 * The OpenSearch Contributors require contributions made to  
                // if the node with the replica is the first to be restarted, while a replica is still recovering
            shardStats.stream()  
    }  
        if (CLUSTER_TYPE == ClusterType.OLD) {
            if (preference != null) {  
        // so we expect the index to be closed and replicated
        ObjectPath objectPath = ObjectPath.createFromResponse(response);
                .put(INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "120s")
                .build());
            ObjectPath objectPath = ObjectPath.createFromResponse(response);
            case MIXED:
                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
                   CLUSTER_TYPE == ClusterType.UPGRADED
        final Map<String, ?> settings = (Map<String, Object>) XContentMapValues.extractValue("settings", metadata);
                String historyUUID = objectPath.evaluate("indices." + index + ".shards.0." + shard + ".commit.user_data.history_uuid");
        if (CLUSTER_TYPE == ClusterType.OLD) {
        }
                    // if the node with the replica is the first to be restarted, while a replica is still recovering
                    // but the recovering copy will be seen as invalid and the cluster health won't return to GREEN
                final String oldNode = getNodeId(v -> v.before(Version.CURRENT));
            int numDocs = randomInt(10);  
    }
