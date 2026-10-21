                ensurePeerRecoveryRetentionLeasesRenewedAndSynced(index);
    public void testRecoveryClosedIndex() throws Exception {
                    .put(INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "100ms")
        for (Map<String, ?> shard : shards) {
                String nodeID = objectPath.evaluate("indices." + index + ".shards.0." + shard + ".routing.node");
                // if the node with the replica is the first to be restarted, while a replica is still recovering
        final String index = "recovery_with_concurrent_indexing";
                assertNoopRecoveries(indexName, s -> s.startsWith(CLUSTER_NAME + "-0"));
    /**
            case MIXED:
                break;
        List<Map<String, ?>> shards = (List<Map<String,?>>) XContentMapValues.extractValue(indexName + ".shards", recoveries);
                .build());
        if (CLUSTER_TYPE == ClusterType.OLD) {
            indexDocs(indexName, 0, randomInt(10));
                // return true even though shards haven't moved to the new node yet (allocation was throttled).
            // allocate replica to node-2
                settings.put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), randomBoolean());
                    logger.info("total [{}] reused [{}]", totalFiles, reusedFiles);
    private void ensureGlobalCheckpointSynced(String index) throws Exception {
                break;
                assertCount(index, "_only_nodes:" + nodes.get(1), 105);
            try {
/*
                client().performRequest(new Request("POST", index + "/_refresh"));
                .put(SETTING_ALLOCATION_MAX_RETRY.getKey(), "0"); // fail faster
                assertCount(index, "_only_nodes:" + nodes.get(1), 105);
                    // but the recovering copy will be seen as invalid and the cluster health won't return to GREEN
            Request shardStatsRequest = new Request("GET", index + "/_stats");
            indexDocs(index, randomIntBetween(0, 100), randomIntBetween(0, 100));
                assertCount(index, "_only_nodes:" + nodes.get(0), 60);
                .put(INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "120s")
            final Settings.Builder settings = Settings.builder()
import static org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider.INDEX_ROUTING_ALLOCATION_ENABLE_SETTING;
     * Tests that with or without soft-deletes, we should perform an operation-based recovery if there were some
            shardStatsRequest.addParameter("level", "shards");
 *
            assertThat(XContentMapValues.extractValue("_source.updated_field", doc), equalTo(updates.get(docId)));
import org.opensearch.test.rest.yaml.ObjectPath;
            }
        assertClosedIndex(indexName, true);
            flush(index, true);
import java.util.Objects;
                });
        final String index = "test_operation_based_recovery";
                Request update = new Request("POST", index + "/_update/" + docId);
                final List<String> oldNodeNames = new ArrayList<>();
                createIndex(index, settings.build());
                .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
import static com.carrotsearch.randomizedtesting.RandomizedTest.randomAsciiLettersOfLength;
            createIndex(index, settings.build());
        if (CLUSTER_TYPE == ClusterType.OLD) {
                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
    }
     * is effectively closed and potentially replicated (if the version the index was created on supports
        ObjectPath objectPath = ObjectPath.createFromResponse(response);
                // if the node with the replica is the first to be restarted, while a replica is still recovering
    }
            assertThat(Booleans.parseBoolean((String) XContentMapValues.extractValue("index.verified_before_close", settings)), is(true));
    }
            default:
            case OLD:
        if (checkRoutingTable) {
     */
            String.join("_", "index", CLUSTER_TYPE.toString(), Integer.toString(minimumNodeVersion.id)).toLowerCase(Locale.ROOT);
        Thread background = new Thread(new AbstractRunnable() {
                updateIndexSettings(index, Settings.builder().put(INDEX_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), (String)null));
        }
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, randomInt(2))
        assertThat(metadata.get("state"), equalTo("close"));
            indexDocs(index, 0, numDocs);
        final Map<String, ?> settings = (Map<String, Object>) XContentMapValues.extractValue("settings", metadata);
                    if (versionString.equals(Version.CURRENT.toString()) == false) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            case UPGRADED:
        final int actualDocs;
            getIndexSettingsAsMap(indexName).get(IndexMetadata.SETTING_NUMBER_OF_REPLICAS).toString());
 * KIND, either express or implied.  See the License for the
            case MIXED:
                .put(INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "100ms")
                assertCount(index, "_only_nodes:" + nodes.get(0), 105);
        });
import org.opensearch.common.Booleans;
            indexDocs(index, randomIntBetween(0, 100), randomIntBetween(0, 3));
import org.apache.hc.core5.http.io.entity.EntityUtils;
        List<String> nodes = new ArrayList<>(nodeMap.keySet());
                        oneOf("STARTED", "RELOCATING", "RELOCATED"));
                // but the recovering copy will be seen as invalid and the cluster health won't return to GREEN
 * Licensed to Elasticsearch under one or more contributor
 * this work for additional information regarding copyright
        assertThat(blocks, notNullValue());
 * this file be licensed under the Apache-2.0 license or a
                for (Object nodeDetails : nodesMap.values()) {
                assertCount(index, "_only_nodes:" + nodes.get(1), 60);
        assertNotNull(shards);
                    assertThat("different history uuid found for shard on " + nodeID, historyUUID, equalTo(expectHistoryUUID));
                update.setJsonEntity("{\"doc\": {\"updated_field\": " + value + "}}");
        }
            }
                future.onFailure(e);
                    (Collection<Map<String, ?>>) XContentMapValues.extractValue("shards." + i, routingTable);
                    .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 2)
        } else {
                || nodeName.startsWith(CLUSTER_NAME + "-0")
                    // if the node with the replica is the first to be restarted, while a replica is still recovering
     * We test that a closed index makes no-op replica allocation/recovery only.
 *    http://www.apache.org/licenses/LICENSE-2.0
                client().performRequest(new Request("POST", index + "/_refresh"));
        indexExistsRequest.setOptions(allowTypesRemovalWarnings());
            Map<String, Object> doc = entityAsMap(client().performRequest(get));
import java.util.Map;
                throw new IllegalStateException("unknown type " + CLUSTER_TYPE);
            final Request request = new Request("GET", index + "/_count");
                if (expectHistoryUUID == null) {
    public void testRetentionLeasesEstablishedWhenPromotingPrimary() throws Exception {
        final Map<String, ?> state = entityAsMap(client().performRequest(new Request("GET", "/_cluster/state")));
            }
        }
                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 2);
                // then delayed allocation will kick in. When the node comes back, the cluster-manager will search for a copy
                    long reusedFiles = ((Number) XContentMapValues.extractValue("index.files.reused", shard)).longValue();
        if (CLUSTER_TYPE == ClusterType.OLD) {
        Response response = client().performRequest(new Request("GET", "_nodes"));
            updateIndexSettings(indexName,
     */
                break;
        final String index = "turn_off_translog_retention";
                Settings.Builder settings = Settings.builder()
        // so we expect the index to be closed and replicated
            // uncommitted docs must be less than 10% of committed docs (see IndexSetting#FILE_BASED_RECOVERY_THRESHOLD_SETTING).
                    final Request putSettingsRequest = new Request("PUT", "/" + index + "/_settings");
                if (details == null) {
                if (minimumNodeVersion().before(Version.V_2_0_0) && randomBoolean()) {
                .map(shard -> (Map<?, ?>) XContentMapValues.extractValue("seq_no", shard))
                // make sure that we can index while the replicas are recovering
            @Override
                // make sure that no shards are allocated, so we can make sure the primary stays on the old node (when one
                final Map<?, ?> nodesMap
            for (int i = 0; i < numberOfShards; i++) {
                .put(INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "100ms");
                expectSoftDeletesWarning(request, indexName);
            closeIndex(indexName);
            createIndex(indexName, Settings.builder()
    }
     */
                assertCount(index, "_only_nodes:" + nodes.get(2), 105);
            case OLD:
                    assertOK(client().performRequest(putSettingsRequest));
        final Version minimumNodeVersion = minimumNodeVersion();
        final String index = "recover_and_create_leases_in_relocation";
 * Modifications Copyright OpenSearch Contributors. See
        if (CLUSTER_TYPE == ClusterType.OLD) {
        }
    }
                    .put(INDEX_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), (String)null)
                break;
                    assertThat(XContentMapValues.extractValue("index", shard), equalTo(index));
import java.util.HashMap;
    }
                Settings.Builder settings = Settings.builder()
            for (int i = 0; i < times; i++) {
                assertThat(shards, notNullValue());
            case OLD:
import org.opensearch.action.support.PlainActionFuture;
                .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
                break;
            Settings.Builder settings = Settings.builder()
            createIndex(index, settings.build());
                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
            ensureGreen(index);
                break;
    }
        final String index = "relocation_with_concurrent_indexing";
                    final String oldNodeName = oldNodeNames.get(0);
            protected void doRun() throws Exception {
     * Verifies that once all shard copies on the new version, we should turn off the translog retention for indices with soft-deletes.
     * Asserts that an index is closed in the cluster state. If `checkRoutingTable` is true, it also asserts
import org.opensearch.common.settings.Settings;
            }
        if (CLUSTER_TYPE == ClusterType.OLD) {
        boolean foundReplica = false;
        }
        }
                .put(SETTING_ALLOCATION_MAX_RETRY.getKey(), "0") // fail faster
                updateIndexSettings(index, Settings.builder().put("index.routing.allocation.include._id", newNode));
        for (int i = 0; i < numDocs; i++) {
        final Map<String, Object> nodeMap = objectPath.evaluate("nodes");
                    logger.info("--> excluding index [{}] from node [{}]", index, oldNodeName);
            Request indexDoc = new Request("PUT", index + "/_doc/" + id);
                    .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 2)
                assertCount(index, "_only_nodes:" + nodes.get(0), 105);
 */
        if (CLUSTER_TYPE == ClusterType.OLD) {
            List<Map<?, ?>> shardStats = (List<Map<?, ?>>) XContentMapValues.extractValue("indices." + index + ".shards.0", stats);
            createIndex(indexName, Settings.builder()
                Settings.Builder settings = Settings.builder()
            Request get = new Request("GET", index + "/_doc/" + docId);
        PlainActionFuture<Void> future = new PlainActionFuture<>();
                ensureGreen(index);
        // so we expect the index to be closed and replicated
            Settings.Builder settings = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1);
                // then delayed allocation will kick in. When the node comes back, the cluster-manager will search for a copy
    }
            createIndex(index, settings.build());
import java.util.concurrent.Future;
                updateIndexSettings(index, Settings.builder().put(INDEX_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), (String)null));
        final Version minimumNodeVersion = minimumNodeVersion();
            indexDocs(index, randomIntBetween(0, 100), randomIntBetween(0, 3));
            indexDoc.setJsonEntity("{\"test\": \"test_" + randomAsciiLettersOfLength(2) + "\"}");
                if (randomBoolean()) {
                    // but the recovering copy will be seen as invalid and the cluster health won't return to GREEN
                }
            boolean softDeletesEnabled = true;
/*
                client().performRequest(update);
                assertCount(index, "_only_nodes:" + nodes.get(2), 105);
                // then delayed allocation will kick in. When the node comes back, the cluster-manager will search for a copy
                assertCount(index, "_only_nodes:" + nodes.get(2), 60);
            if (minimumNodeVersion().before(Version.V_2_0_0) && randomBoolean()) {
        switch (CLUSTER_TYPE) {
     * peer recoveries.
        assertThat("preference [" + preference + "]", actualDocs, equalTo(expectedCount));
        }
 */
                client().performRequest(new Request("POST", "/" + index + "/_flush"));
                    assertNotNull(state.toString(), assignedNodes);
import org.opensearch.core.xcontent.MediaTypeRegistry;
            }
                    .put(SETTING_ALLOCATION_MAX_RETRY.getKey(), "0"); // fail faster
                    CLUSTER_NAME + "-0," + CLUSTER_NAME + "-2," + CLUSTER_NAME + "-*")
        }
            ensureGreen(indexName);
        assertThat(blocks.containsKey(String.valueOf(MetadataIndexStateService.INDEX_CLOSED_BLOCK_ID)), is(true));
            int numDocs = randomInt(10);
        // index was created on a version that supports the replication of closed indices,
        ensureGreen(indexName);
            flush(index, randomBoolean());
        ensureGreen(indexName);
package org.opensearch.upgrades;
     * This test creates an index in the non upgraded cluster and closes it. It then checks that the index
    }
                .put(EnableAllocationDecider.INDEX_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), "none")
            default:
                String historyUUID = objectPath.evaluate("indices." + index + ".shards.0." + shard + ".commit.user_data.history_uuid");
        Response response = client().performRequest(new Request("GET", "_nodes"));
                settings.put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), randomBoolean());
            int numDocs = randomInt(10);
                    .put("index.routing.allocation.include._tier_preference", "")
                final Map<String, Object> nodeMap = objectPath.evaluate("nodes");
        ObjectPath objectPath = ObjectPath.createFromResponse(response);
    private static String CLUSTER_NAME = System.getProperty("tests.clustername");
            ensurePeerRecoveryRetentionLeasesRenewedAndSynced(index);
            }
        switch (CLUSTER_TYPE) {
        }
 * Unless required by applicable law or agreed to in writing,
        assertClosedIndex(indexName, true);
                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), between(1, 2)) // triggers nontrivial promotion
        if (CLUSTER_TYPE == ClusterType.OLD) {
                    .put(INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "100ms")
            updateIndexSettings(indexName,
                createIndex(index, settings.build());
                long translogRecovered = ((Number) XContentMapValues.extractValue("translog.recovered", shard)).longValue();
 * GitHub history for details.
            ObjectPath objectPath = ObjectPath.createFromResponse(response);
import org.opensearch.core.common.Strings;
                );
        final String index = "test_recovery";
                    = ObjectPath.createFromResponse(client().performRequest(new Request("GET", "/_nodes"))).evaluate("nodes");
            final int times = randomIntBetween(0, 2);
 * compatible open source license.
        try {
import org.opensearch.cluster.metadata.MetadataIndexStateService;
                    assertEquals("must reuse all files, recoveries [" + recoveries + "]", totalFiles, reusedFiles);
                // node stops, we lose the cluster-manager too, so a replica will not be promoted)
    }
                client().performRequest(new Request("POST", "/" + index + "/_flush"));
        if (CLUSTER_TYPE == ClusterType.OLD) {
    }
     * time the index was closed.
                .filter(Objects::nonNull)
    }
                    .put(SETTING_ALLOCATION_MAX_RETRY.getKey(), "0"); // fail faster
        if (CLUSTER_TYPE == ClusterType.OLD) {
                    indexDocs(index, i, 1); // update
            syncedFlush(index, randomBoolean());
import static org.hamcrest.Matchers.hasSize;
                List<String> nodes = new ArrayList<>(nodeMap.keySet());
                    assertThat(details, Matchers.empty());
    public void testRecoveryWithConcurrentIndexing() throws Exception {
        }
                ensureGreen(index);
        }
                ensureNoInitializingShards(); // wait for all other shard activity to finish
        final int numberOfShards = Integer.parseInt((String) XContentMapValues.extractValue("index.number_of_shards", settings));
                    long globalCheckpoint = ((Number) XContentMapValues.extractValue("global_checkpoint", seqNoStat)).longValue();
                future.onResponse(null);
                assertThat("no history uuid found for shard on " + nodeID, historyUUID, notNullValue());
                indexDocs(index, idStart, numDocs);
            indexDocs(index, 0, randomIntBetween(100, 200));
import org.opensearch.common.util.concurrent.AbstractRunnable;
        }
        if (randomBoolean()) {
            createIndex(index, settings.build());
                softDeletesEnabled = randomBoolean();
                    // then delayed allocation will kick in. When the node comes back, the cluster-manager will search for a copy
import static org.opensearch.cluster.routing.allocation.decider.MaxRetryAllocationDecider.SETTING_ALLOCATION_MAX_RETRY;
        Map<String, Object> nodesAsMap = objectPath.evaluate("nodes");
                assertCount(index, "_only_nodes:" + newNode, 60);
                // before timing out
                .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
                    .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 2)
    /**
                    .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
     * This test creates and closes a new index at every stage of the rolling upgrade. It then checks that the index
                asyncIndexDocs(index, 10, 50).get();
            indexDocs(index, 0, randomIntBetween(100, 200));
        return null;
            client().performRequest(request);
        return numDocs;
        if (CLUSTER_TYPE == ClusterType.OLD) {
                createIndex(index, settings.build());
            request.setJsonEntity("{\"settings\": " + Strings.toString(MediaTypeRegistry.JSON, settings.build()) + "}");
        }
    public void testCloseIndexDuringRollingUpgrade() throws Exception {
                    settings.put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), randomBoolean());
            assertNoFileBasedRecovery(index, nodeName ->
                ensurePeerRecoveryRetentionLeasesRenewedAndSynced(index);
    /**
            Settings.Builder settings = Settings.builder()
            if (versionPredicate.test(version)) {
        ensureGreen(indexName);
                break;
import org.opensearch.common.xcontent.XContentType;
                ObjectPath objectPath = ObjectPath.createFromResponse(response);
        assertThat(settings, notNullValue());
                    client().performRequest(new Request("DELETE", index + "/" + MapperService.SINGLE_MAPPING_NAME + "/" + i));
                    final String versionString = (String) nodeDetailsMap.get("version");
import static org.opensearch.cluster.routing.UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING;
        assertThat(metadata, notNullValue());
                    .put(SETTING_ALLOCATION_MAX_RETRY.getKey(), "0"); // fail faster
                e.addSuppressed(inner);
        ensurePeerRecoveryRetentionLeasesRenewedAndSynced(index);
 * license agreements. See the NOTICE file distributed with
        final int numberOfReplicas = Integer.parseInt((String) XContentMapValues.extractValue("index.number_of_replicas", settings));
     * the replication of closed indices) during the rolling upgrade.
                throw new IllegalStateException("unknown type " + CLUSTER_TYPE);
public class RecoveryIT extends AbstractRollingTestCase {
            if (randomBoolean()) {
            createIndex(indexName, Settings.builder()
                updateIndexSettings(index, Settings.builder().put(INDEX_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "none"));
    public void testAutoExpandIndicesDuringRollingUpgrade() throws Exception {
                    .putNull("index.routing.allocation.include._tier_preference")
                assertThat(shards.size(), equalTo(numberOfReplicas + 1));
import java.util.Locale;
                assertNoopRecoveries(indexName, s -> s.startsWith(CLUSTER_NAME));
                        oldNodeNames.add((String) nodeDetailsMap.get("name"));
            closeIndex(indexName);
        }
    public void testTurnOffTranslogRetentionAfterUpgraded() throws Exception {
                assertEquals("must be noop, recoveries [" + recoveries + "]", 0, translogRecovered);
                    expectHistoryUUID = historyUUID;
                .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
                    .put("index.routing.allocation.include._id", oldNode)
            shardStats.stream()
                .build());
                    .put(INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "100ms")
                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
                    // if the node with the replica is the first to be restarted, while a replica is still recovering
            syncedFlush(index, randomBoolean());
                // trigger a primary relocation by excluding the last old node with a shard filter
                final String oldNode = getNodeId(v -> v.before(Version.CURRENT));
    }
                    }
    }
            ensureGreen(indexName);
import org.opensearch.index.IndexSettings;
            }
                ensureGreen(index);
    private Future<Void> asyncIndexDocs(String index, final int idStart, final int numDocs) throws IOException {
            }
    }
        ensureGreen(index);
                .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
        }
                .forEach(seqNoStat -> {
                    putSettingsRequest.setJsonEntity("{\"index.routing.allocation.exclude._name\":\"" + oldNodeName + "\"}");
                .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
            case MIXED:
                updateIndexSettings(index, Settings.builder().put(INDEX_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "primaries"));
                    .putNull("index.routing.allocation.include._tier_preference")
                    .put("index.routing.allocation.include._id", (String)null)
                    // before timing out
            }
            Response response = client().performRequest(shardStatsRequest);
                // remove the replica and guaranteed the primary is placed on the old node
        } catch (ResponseException e) {
    }
            }
            final int id = idStart + i;
            createIndex(index, Settings.builder()
    public void testRecovery() throws Exception {
                ensureGreen(index);
                .put(INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "100ms")
                    long maxSeqNo = ((Number) XContentMapValues.extractValue("max_seq_no", seqNoStat)).longValue();
        assertTrue("must find replica", foundReplica);
                    assertThat((String) XContentMapValues.extractValue("state", shard),
        assertBusy(() -> {
                    assertThat(shardStats.toString(), localCheckpoint, equalTo(maxSeqNo));
 * not use this file except in compliance with the License.
        return future;
        assertEquals(nodes.size() - 2, numberOfReplicas);
            createIndex(indexName, Settings.builder()
import static org.hamcrest.Matchers.is;
    }
        indexDocs(indexName, randomInt(100), randomInt(100));
                ensureGreen(index);
                    .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), between(1, 5))
        @SuppressWarnings("unchecked")
            actualDocs = Integer.parseInt(ObjectPath.createFromResponse(response).evaluate("count").toString());
                final Collection<Map<String, ?>> shards =
     */
        final Map<String, ?> routingTable = (Map<String, Object>) XContentMapValues.extractValue("routing_table.indices." + index, state);
        final int numberOfReplicas = Integer.parseInt(
            } catch (Exception inner) {
                }
        }
                break;
        ensureGreen(indexName);
    private void assertClosedIndex(final String index, final boolean checkRoutingTable) throws IOException {
        Response response = client().performRequest(new Request("GET", "_nodes"));
                for (Map<String, ?> shard : shards) {
import org.opensearch.index.mapper.MapperService;
        }
                    final Map<?, ?> nodeDetailsMap = (Map<?, ?>) nodeDetails;
import static org.hamcrest.Matchers.nullValue;
        }
                    .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), between(0, 1))
        }
    private void assertCount(final String index, final String preference, final int expectedCount) throws IOException {
                indexDocs(index, 0, 10);
        } else if (CLUSTER_TYPE == ClusterType.UPGRADED) {
                Settings.builder().put(
import org.opensearch.client.Response;
        final Map<String, ?> blocks = (Map<String, Object>) XContentMapValues.extractValue("blocks.indices." + index, state);
        ensureGreen(indexName);
            );
            case UPGRADED:
            final Response response = client().performRequest(request);
                }
                updateIndexSettings(index, Settings.builder()
            for (int shard = 0; shard < 2; shard++) {
            if (minimumNodeVersion().before(Version.V_2_0_0) && randomBoolean()) {
        final Map<String, Object> nodeMap = objectPath.evaluate("nodes");
                    .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
            ensureGreen(indexName);
import org.opensearch.cluster.metadata.IndexMetadata;
            syncedFlush(index, randomBoolean());
            ensureGreen(index);
        background.start();
                int numDocs = randomInt(10);
                // but the recovering copy will be seen as invalid and the cluster health won't return to GREEN
                // before timing out
                // ensure the relocation from old node to new node has occurred; otherwise ensureGreen can
 */
        }
                    assertNotNull(details);
    }
                ensureGreen(index);
import static org.hamcrest.Matchers.notNullValue;
        }
import org.opensearch.client.ResponseException;
 * software distributed under the License is distributed on an
     * before we upgrade each node. This is important when we move from translog based to retention leases based
            createIndex(index, settings.build());
import java.util.concurrent.TimeUnit;
}
    public void testClosedIndexNoopRecovery() throws Exception {
        final String indexName = "closed_index_created_on_old";
        final String index = "recover_and_create_leases_in_promotion";
        if (randomBoolean()) {
        for (String id : nodesAsMap.keySet()) {
 * specific language governing permissions and limitations
            }
                }
            }
    private void assertNoopRecoveries(String indexName, Predicate<String> targetNode) throws IOException {
                // once detailed recoveries works, remove this if.
 * The OpenSearch Contributors require contributions made to
import org.opensearch.Version;
                Settings.builder().put(IndexMetadata.INDEX_ROUTING_EXCLUDE_GROUP_PREFIX + "._id", nodes.get(randomInt(2))));
    /**
            indexDocs(index, 0, 100);
            List<Object> shardStats = objectPath.evaluate("indices." + index + ".shards.0");
            ensureGreen(index);
                fail("failed to get doc count for index [" + index + "] with preference [" + preference + "]" + " response [" + e + "]"
import java.util.Collection;
                .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
            ensureGreen(index);
        switch (CLUSTER_TYPE) {
                settings.put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), softDeletesEnabled);
        }
                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
                .put(INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "100ms")
        }, 60, TimeUnit.SECONDS);
            }
import static org.hamcrest.Matchers.in;
            ensureGreen(index);
                asyncIndexDocs(index, 10, 50).get();
                Response response = client().performRequest(new Request("GET", "_nodes"));
        // index is created on a version that supports the replication of closed indices,
     */
        final Response indexExistsResponse = client().performRequest(indexExistsRequest);
        if (RestStatus.OK.getStatus() != indexExistsResponse.getStatusLine().getStatusCode()) {
    private int indexDocs(String index, final int idStart, final int numDocs) throws IOException {
                || (nodeName.startsWith(CLUSTER_NAME + "-1") && Booleans.parseBoolean(System.getProperty("tests.first_round")) == false));
                );
            String expectHistoryUUID = null;
        final Map<String, ?> metadata = (Map<String, Object>) XContentMapValues.extractValue("metadata.indices." + index, state);
            ensureGreen(index);
        // index was created on a version that supports the replication of closed indices,
                    assertThat(state.toString(), newNode, in(assignedNodes));
            @Override
            if (softDeletesEnabled == false) {
                foundReplica = true;
     * that the index has started shards.
        ObjectPath objectPath = ObjectPath.createFromResponse(response);
                    long totalFiles = ((Number) XContentMapValues.extractValue("index.files.total", shard)).longValue();
                ensureGreen(index);
            ensureGlobalCheckpointSynced(index);
                .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
        Map<Integer, Long> updates = new HashMap<>();
 * In depth testing of the recovery mechanism during a rolling restart.
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true).build());
                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
            }
                final String newNode = getNodeId(v -> v.equals(Version.CURRENT));
                updateIndexSettings(index, Settings.builder()
    public void testSoftDeletesDisabledWarning() throws Exception {
    public void testHistoryUUIDIsGenerated() throws Exception {
                && targetNode.test((String) XContentMapValues.extractValue("target.name", shard))) {
                // but the recovering copy will be seen as invalid and the cluster health won't return to GREEN
        final String index = "test_update_doc";
import java.util.List;
 * under the License.
                .put("index.routing.allocation.include._name", CLUSTER_NAME + "-0")
            ensureGlobalCheckpointSynced(index);
                }
            if (preference != null) {
                }
        final String index = "index_history_uuid";
 */
import static org.hamcrest.Matchers.oneOf;
     * is effectively closed and potentially replicated if the cluster supports replication of closed indices at the
                break;
                ensureGreen(index); // wait for the primary to be assigned
        client().performRequest(new Request("POST", index + "/_refresh"));
                    // then delayed allocation will kick in. When the node comes back, the cluster-manager will search for a copy
                long value = randomNonNegativeLong();
            if (randomBoolean()) {
                asyncIndexDocs(index, 60, 45).get();
    public void testRetentionLeasesEstablishedWhenRelocatingPrimary() throws Exception {
            }
            assertThat(XContentMapValues.extractValue("index.verified_before_close", settings), nullValue());
    private String getNodeId(Predicate<Version> versionPredicate) throws IOException {
        }
    /**
        ensureGreen(index);
                    client().performRequest(new Request("POST", "/" + index + "/_flush"));
                asyncIndexDocs(index, 60, 45).get();
import org.opensearch.client.Request;
            Settings.Builder settings = Settings.builder()
        if (randomBoolean()) {
            }
    }
                } else {
                }, 60, TimeUnit.SECONDS);
                }
                // if the node with the replica is the first to be restarted, while a replica is still recovering
                indexDocs(index, 0, 10);
        switch (CLUSTER_TYPE) {
        Map<String, Object> recoveries = entityAsMap(client()
                // todo: verify this test can be removed in 3.0.0
/*
                    assertThat(shardStats.toString(), globalCheckpoint, equalTo(maxSeqNo));
                final Response recoveryStateResponse = client().performRequest(new Request("GET", index + "/_recovery"));
                    @SuppressWarnings("unchecked") List<String> assignedNodes = (List<String>) XContentMapValues.extractValue(xpath, state);
                break;
 * ownership. Elasticsearch licenses this file to you under
                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), randomIntBetween(0, 2))
                .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), between(1, 5))
                .build());
    @SuppressWarnings("unchecked")
            assertThat(routingTable, notNullValue());
        }
                }
        List<String> nodes = new ArrayList<>(nodeMap.keySet());
        final String indexName =
                request.addParameter("preference", preference);
            for (int i = 0; i < numDocs; i++) {
        }
        final String indexName = "test-auto-expand-filtering";
            case UPGRADED:
import static org.hamcrest.Matchers.equalTo;
            closeIndex(indexName);
            assertThat(routingTable, nullValue());
            if (minimumNodeVersion().before(Version.V_2_0_0) && randomBoolean()) {
import java.util.function.Predicate;
     * but not too many uncommitted documents (i.e., less than 10% of committed documents or the extra translog)
            Version version = Version.fromString(objectPath.evaluate("nodes." + id + ".version"));
                updates.put(docId, value);
        for (int docId = 0; docId < 100; docId++) {
        if (CLUSTER_TYPE == ClusterType.UPGRADED) {
        final String indexName = "closed_index_replica_allocation";
 * SPDX-License-Identifier: Apache-2.0
/**
            ensureGreen(indexName);
                } else {
 *
    /**
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
            assertEmptyTranslog(index);
        assertClosedIndex(indexName, true);
            Settings.Builder settings = Settings.builder()
        final Request indexExistsRequest = new Request("HEAD", "/" + indexName);
                    long localCheckpoint = ((Number) XContentMapValues.extractValue("local_checkpoint", seqNoStat)).longValue();
        }
                    .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
        } else {
                client().performRequest(new Request("POST", index + "/_refresh"));
            if (minimumNodeVersion().before(Version.V_2_0_0) && randomBoolean()) {
                // make sure that we can index while the replicas are recovering
import org.opensearch.core.rest.RestStatus;
    public void testRelocationWithConcurrentIndexing() throws Exception {
                if (oldNodeNames.size() == 1) {
                break;
            assertThat(shardStats, hasSize(2));
                assertBusy(() -> {
                indexDocs(index, 0, numDocs);
                .put(IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS, "0-all")
        if (randomBoolean()) {
                ensureGreen(index);
            if (shard.get("primary") == Boolean.FALSE
            client().performRequest(indexDoc);
                } else if (randomBoolean()) {
                .build());
            }
                updateIndexSettings(index, Settings.builder().put(INDEX_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "primaries"));
                    // before timing out
                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 2);
                   CLUSTER_TYPE == ClusterType.UPGRADED
     */
                if (randomBoolean()) {
    public void testUpdateDoc() throws Exception {
        }
            indexDocs(index, 0, numDocs);
 * the Apache License, Version 2.0 (the "License"); you may
    }
 *
            case MIXED:
                .put(SETTING_ALLOCATION_MAX_RETRY.getKey(), "0"); // fail faster
import java.io.IOException;
                    String xpath = "routing_table.indices." + index + ".shards.0.node";
                    "index.routing.allocation.include._name",
    public void testOperationBasedRecovery() throws Exception {
            .performRequest(new Request("GET", indexName + "/_recovery?detailed=true")));
    @SuppressWarnings("unchecked")
            public void onFailure(Exception e) {
                return id;
                    assertThat(XContentMapValues.extractValue("shard", shard), equalTo(i));
                ensureGreen(index);
            Map<?, ?> stats = entityAsMap(client().performRequest(new Request("GET", index + "/_stats?level=shards")));
                // before timing out
                client().performRequest(new Request("POST", index + "/_refresh"));
import org.hamcrest.Matchers;
import org.opensearch.common.xcontent.support.XContentMapValues;
            case OLD: break;
            throw e;
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    /** Ensure that we can always execute update requests regardless of the version of cluster */
        // so we expect the index to be closed and replicated
            Request request = new Request("PUT", "/" + indexName);
import java.util.ArrayList;
        for (int docId : updates.keySet()) {
            case UPGRADED:
            flush(index, randomBoolean());
                settings.put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), randomBoolean());
                    + " recovery [" + EntityUtils.toString(recoveryStateResponse.getEntity()) + "]");
                    Map<String, ?> state = entityAsMap(client().performRequest(new Request("GET", "/_cluster/state")));
                List<?> details = (List<?>) XContentMapValues.extractValue("index.files.details", shard);
            ensurePeerRecoveryRetentionLeasesRenewedAndSynced(index);
 * You may obtain a copy of the License at
        final String indexName = "test_soft_deletes_disabled_warning";
    }
