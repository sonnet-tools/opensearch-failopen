        assertAcked(
            .prepareUpdateSettings("source")
                equalTo(maxUnsafeAutoIdTimestamp)
            .setSettings(
                            client().index(request).get();
        client().admin()
                    while (true) {
        );
        assertSortedSegments("source", expectedIndexSort);
            .indices()
    }
            .put("index.number_of_replicas", 0)
            .build();
                    .put("index.number_of_replicas", 0)
            .indices()
            )
    public void testCreateShrinkIndexToN() {
import org.opensearch.cluster.routing.Murmur3HashFunction;
            .prepareUpdateSettings()
            .setTransientSettings(Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), "none"))
        return Settings.builder()
import org.opensearch.index.IndexModule;
        );
            .setSettings(Settings.builder().put("index.routing.allocation.require._name", mergeNode).put("index.blocks.write", true))
            .map(ShardStats::getStats)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
import org.opensearch.transport.client.Client;
        // ensure all shards are allocated otherwise the ensure green below might not succeed since we require the merge node
                .setSettings(
                    ensureGreen();
        DiscoveryNode[] discoveryNodes = dataNodes.values().toArray(new DiscoveryNode[0]);
            .mapToLong(SeqNoStats::getMaxSeqNo)
            for (final Integer shardId : indexShards.shardIds()) {
        assertHitCount(client().prepareSearch("first_shrink").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), 20);
                    shard.failShard("test", new Exception("test"));
        for (int i = 0; i < iterations; i++) {
            () -> client().admin()
                        .putNull("index.blocks.write")
        // kick off a retry and wait until it's done!
        ensureGreen();
            .get();
        infoService.refresh();
import org.opensearch.cluster.node.DiscoveryNode;
            .setSettings(Settings.builder().put("index.routing.allocation.require._name", mergeNode).put("index.blocks.write", true))
        internalCluster().ensureAtLeastNumDataNodes(2);
            .get(0)
                .put("number_of_shards", 8)
            .getAsLong();
        DiscoveryNode[] discoveryNodes = dataNodes.values().toArray(new DiscoveryNode[0]);
import org.opensearch.common.unit.TimeValue;
            .index("target")
        ensureGreen(TimeValue.timeValueSeconds(120));
                .setId(Integer.toString(i))
import org.opensearch.index.shard.IndexShard;
        assertHitCount(client().prepareSearch("target").setSize(size).setQuery(new TermsQueryBuilder("foo", "bar")).get(), docs);
        // to the require._name below.
                Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), (String) null)
                .get();
 * compatible open source license.
                .prepareResizeIndex("source", "target")
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
            .map(CommonStats::getSegments)
            .indices()
        assertThat(dataNodes.size(), greaterThanOrEqualTo(2));
        // relocate all shards to one node such that we can merge it.
        ensureGreen();
                    // this can not succeed until the shard is failed and a replica is promoted
        final long beforeShrinkPrimaryTerm = IntStream.range(0, numberOfShards).mapToLong(indexMetadata::primaryTerm).max().getAsLong();
        }
        flushAndRefresh();
            .indices()
                .setSettings(
            Settings.builder()
            .get();
        assertTrue("at least 2 nodes but was: " + dataNodes.size(), dataNodes.size() >= 2);
        // ... and that the index sort is also applied to updates
            .setSettings(
        // ensure all shards are allocated otherwise the ensure green below might not succeed since we require the merge node
            .mapToLong(SegmentsStats::getMaxUnsafeAutoIdTimestamp)
        }
        // ensure all shards are allocated otherwise the ensure green below might not succeed since we require the merge node
        // relocate all shards to one node such that we can merge it.
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
    @Override
        final Settings shrinkSettings = Settings.builder()
                .prepareResizeIndex("source", "first_shrink")
import org.junit.Before;
        final Map<String, DiscoveryNode> dataNodes = client().admin().cluster().prepareState().get().getState().nodes().getDataNodes();
        String mergeNode = discoveryNodes[0].getName();
                        .put("index.number_of_replicas", 0)
                .indices()
        });
        // check that index sort cannot be set on the target index
        assertHitCount(client().prepareSearch("second_shrink").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), 20);
                        .put("index.number_of_shards", "2")
            Settings.builder().put(indexSettings()).put("number_of_shards", randomIntBetween(2, 7)).put("number_of_replicas", 0)
        assertAcked(
            ClusterStateResponse clusterStateResponse = client().admin().cluster().prepareState().get();
        for (int i = 0; i < 20; i++) {
                .setId(Integer.toString(i))
            assertTrue(routingTables.index("target").shard(0).getShards().get(0).unassigned());
        // if we change the setting too quickly we will end up with one replica unassigned which can't be assigned anymore due
import static org.hamcrest.Matchers.containsString;
                .setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON)
        ensureGreen();
            .get();
    /**
                .get()
                .get();
    }
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
                        .put("index.number_of_shards", shardSplits[1])
        client().admin().cluster().prepareHealth("target").setWaitForEvents(Priority.LANGUID).get();
        flushAndRefresh();
        }
        final IndexMetadata indexMetadata = indexMetadata(client(), "source");
}
        assertHitCount(client().prepareSearch("target").setSize(2 * size).setQuery(new TermsQueryBuilder("foo", "bar")).get(), 2 * docs);
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        prepareCreate("source").setSettings(Settings.builder().put(indexSettings()).put("number_of_shards", numberOfShards)).get();
                if (shard.routingEntry().primary() && randomBoolean()) {
                        .put("index.number_of_shards", shardSplits[2])
        flushAndRefresh();
        Version version = VersionUtils.randomVersion(random());
            .put(IndexModule.INDEX_QUERY_CACHE_ENABLED_SETTING.getKey(), false)
import java.util.Map;
        // fail random primary shards to force primary terms to increase
import org.opensearch.indices.replication.common.ReplicationType;
        long expectedShardSize = clusterRerouteResponse.getState()
            .put("index.routing.allocation.require._name", mergeNode)
        int numberOfShards = randomIntBetween(2, 20);
        final int iterations = scaledRandomIntBetween(0, 16);
                .indices()
        final String mergeNode = discoveryNodes[0].getName();
            .prepareUpdateSettings()
        ensureGreen();
                        }
                .get()
        ensureGreen();
import org.opensearch.common.settings.Settings;
import org.opensearch.index.seqno.SeqNoStats;
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
import org.opensearch.test.VersionUtils;
        final int size = docs > 0 ? 2 * docs : 1;
            .get();
    public void testCreateShrinkWithIndexSort() throws Exception {
            internalCluster().getClusterManagerName()
        ensureGreen(TimeValue.timeValueSeconds(120));
        // This needs more than the default timeout if a large number of shards were created.
        ensureGreen();
                .prepareResizeIndex("first_shrink", "second_shrink")
            .get();
        prepareCreate("source").setSettings(
    public void testCreateShrinkIndex() {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
    public void testCreateShrinkIndexFails() throws Exception {
            .max()
            assertThat("failed on " + shardRouting, seqNoStats.getLocalCheckpoint(), equalTo(maxSeqNo));
        client().admin()
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.InternalClusterInfoService;
            .indices()
        String spareNode = discoveryNodes[0].getName();
            .prepareUpdateSettings("target") // erase the forcefully fuckup!
                .prepareResizeIndex("source", "target")
        }
        // relocate all shards to one node such that we can merge it.
        assertBusy(() -> {
        SortField expectedSortField = new SortedSetSortField("id", true, SortedSetSelector.Type.MAX);
        );
        final IndicesStatsResponse sourceStats = client().admin().indices().prepareStats("source").setSegments(true).get();
        // if we change the setting too quickly we will end up with one replica unassigned which can't be assigned anymore due
    public Settings indexSettings() {
        );
import org.opensearch.cluster.metadata.IndexMetadata;
        client().admin()
                .setSettings(
import org.apache.lucene.search.SortedSetSelector;
        final long maxSeqNo = Arrays.stream(sourceStats.getShards())
import org.opensearch.index.query.TermsQueryBuilder;
            .get();
        ensureGreen();
        // ensure all shards are allocated otherwise the ensure green below might not succeed since we require the merge node
        // clean up
        // now merge source into a single shard index
        logger.info("merge node {}", mergeNode);
                .get();
                .prepareResizeIndex("source", "target")
            );
        assertAcked(
                    int id = 0;
                }
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
            .put("index.blocks.write", true);
                .get()
                )
        client().admin()
            client().prepareIndex("target").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();
    public void setup() {
        assertTrue("expected shard size must be set but wasn't: " + expectedShardSize, expectedShardSize > 0);
                Settings.builder()
        ).get();
        // relocate all shards to one node such that we can merge it.
        DiscoveryNode[] discoveryNodes = dataNodes.values().toArray(new DiscoveryNode[0]);
            .setSettings(Settings.builder().put("index.routing.allocation.require._name", mergeNode))
        client().admin()
import org.opensearch.cluster.routing.ShardRouting;
        ensureGreen("source");
        // now merge source into a 4 shard index
            client().prepareIndex("first_shrink")
        // we support the expected shard size in the allocator to sum up over the source index shards
        assertAcked(client().admin().indices().prepareResizeIndex("source", "target").setSettings(shrinkSettings).get());
                routingTables.index("target").shard(0).getShards().get(0).unassignedInfo().getReason()
        // if we change the setting too quickly we will end up with one replica unassigned which can't be assigned anymore due
import org.opensearch.cluster.routing.UnassignedInfo;
                )
            .prepareUpdateSettings("second_shrink")
        assertEquals(settingsResponse.getSetting("target", "index.sort.order"), "desc");
        for (int i = 0; i < 20; i++) {
                .put("sort.field", "id")
                .put("number_of_replicas", 0)
        // to the require._name below.
            .prepareUpdateSettings("source")
                            final IndexRequest request = new IndexRequest("source").id(s)
            client().prepareIndex("second_shrink")
            .get();
                        .put("index.number_of_replicas", 0)
                    .put("index.blocks.write", true)
            .setWaitForActiveShards(ActiveShardCount.NONE)
        // making it hard to pin point the source shards.
        return false;
        final long maxUnsafeAutoIdTimestamp = Arrays.stream(sourceStats.getShards())
                        .put("index.number_of_replicas", 0)
            .indices()
        final DiscoveryNode[] discoveryNodes = dataNodes.values().toArray(new DiscoveryNode[0]);
                .setId(Integer.toString(i))
import org.opensearch.cluster.routing.RoutingTable;
    }
            .filter(shard -> shard.getShardRouting().currentNodeId().equals(mergeNode.getId()))
            )
        assertEquals(version, target.getIndexToSettings().get("target").getAsVersion("index.version.created", null));
        final IndexMetadata afterShrinkIndexMetadata = indexMetadata(client(), "target");
        ).setMapping("id", "type=keyword,doc_values=true").get();
        client().admin()
        ensureGreen("source");
        ensureGreen();
import org.opensearch.core.index.Index;
        prepareCreate("source").setSettings(
import org.opensearch.index.engine.SegmentsStats;
                        .put("index.number_of_replicas", 0)
        // check that the index sort order of `source` is correctly applied to the `target`
                "failed on " + shardRouting,
import org.opensearch.core.xcontent.MediaTypeRegistry;
            .setTransientSettings(
        // to the require._name below.
            assertEquals(1, routingTables.index("target").shard(0).getShards().get(0).unassignedInfo().getNumFailedAllocations());
    }
                    }
        // now merge source into a 2 shard index
        assertHitCount(client().prepareSearch("source").setSize(size).setQuery(new TermsQueryBuilder("foo", "bar")).get(), docs);
                .setSettings(
                        .build()
    @Before
        assertHitCount(client().prepareSearch("first_shrink").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), 20);
            assertEquals(
            client().admin()
        ).get();
        for (int i = 0; i < 20; i++) { // now update
            .indices()
            assertThat(
    }
            .get();
            );
        internalCluster().ensureAtLeastNumDataNodes(2);
            .prepareUpdateSettings("first_shrink")
                        .putNull("index.blocks.write")
import org.apache.lucene.search.Sort;
            .setSettings(Settings.builder().put("index.routing.allocation.require._name", spareNode).put("index.blocks.write", true))
            .put(super.indexSettings())
public class RemoteShrinkIndexIT extends RemoteStoreBaseIntegTestCase {
        client().admin()
                .setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON)
                    Settings.builder()
        for (int i = 0; i < 20; i++) { // now update
        assertEquals(settingsResponse.getSetting("target", "index.sort.field"), "id");
        assertThat(exc.getMessage(), containsString("can't override index sort when resizing an index"));
 */
            client().prepareIndex("source").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();
                    Settings.builder()
                shardStats.getStats().getSegments().getMaxUnsafeAutoIdTimestamp(),
                .put(indexSettings())
        prepareCreate("source").setSettings(Settings.builder().put(indexSettings()).put("number_of_shards", shardSplits[0])).get();
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
                    disableAllocation("source");
        assertHitCount(client().prepareSearch("target").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), 20);
            .map(ShardStats::getSeqNoStats)
        assertSortedSegments("target", expectedIndexSort);
            .prepareUpdateSettings("source")
            .get();
import org.opensearch.action.index.IndexRequest;
        final Map<String, DiscoveryNode> dataNodes = client().admin().cluster().prepareState().get().getState().nodes().getDataNodes();
                    enableAllocation("source");
        ensureGreen();
            .setSettings(Settings.builder().putNull("index.routing.allocation.include._id").put("index.number_of_replicas", 0))
                    .put("index.routing.allocation.exclude._name", mergeNode) // we manually exclude the merge node to forcefully fuck it up
                .indices()
        final Map<String, DiscoveryNode> dataNodes = client().admin().cluster().prepareState().get().getState().nodes().getDataNodes();
            final SeqNoStats seqNoStats = shardStats.getSeqNoStats();
        assumeFalse("https://github.com/elastic/elasticsearch/issues/34080", Constants.WINDOWS);
                )
        client().admin()
            .filter(shard -> shard.getShardRouting().currentNodeId().equals(mergeNode.getId()))
        final Map<String, DiscoveryNode> dataNodes = client().admin().cluster().prepareState().get().getState().nodes().getDataNodes();
                    Settings.builder()
            .get();
                )
                    .build()
        internalCluster().ensureAtLeastNumDataNodes(2);
        ensureGreen();
            .setSettings(Settings.builder().putNull("index.routing.allocation.exclude._name"))
        }
import org.opensearch.cluster.ClusterInfoService;
        for (final ShardStats shardStats : targetStats.getShards()) {
            .prepareResizeIndex("source", "target")
            .getShards()
            .get();
            .indices()
        internalCluster().ensureAtLeastNumDataNodes(2);
 * this file be licensed under the Apache-2.0 license or a
            .prepareUpdateSettings("source") // now relocate them all to the right node
        asyncUploadMockFsRepo = false;
            .put(SETTING_NUMBER_OF_REPLICAS, 0)
                    .put("index.routing.allocation.require._name", discoveryNodes[0].getName())
                        .build()
                        .put("index.sort.field", "foo")
            .cluster()
        prepareCreate("source").setSettings(
import org.opensearch.index.IndexService;
            client().admin()
            final String node = randomSubsetOf(1, internalCluster().nodesInclude("source")).get(0);
        client().admin()
        assertTrue("at least 2 nodes but was: " + dataNodes.size(), dataNodes.size() >= 2);
            .getAsLong();
        }
        // resolve true merge node - this is not always the node we required as all shards may be on another node
        IllegalArgumentException exc = expectThrows(
        final ClusterStateResponse clusterStateResponse = client.admin().cluster().state(new ClusterStateRequest()).actionGet();
        // disable rebalancing to be able to capture the right stats. balancing can move the target primary
            .max()
        for (int i = 0; i < 20; i++) {
            IllegalArgumentException.class,
                            id++;
        int numberOfTargetShards = randomValueOtherThanMany(n -> numberOfShards % n != 0, () -> randomIntBetween(1, numberOfShards - 1));
        // now merge source into target
        ensureGreen();
                        // find an ID that routes to the right shard, we will only index to the shard that saw a primary failure
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            RoutingTable routingTables = clusterStateResponse.getState().routingTable();
        assertTrue("at least 2 nodes but was: " + dataNodes.size(), dataNodes.size() >= 2);
        DiscoveryNode[] discoveryNodes = dataNodes.values().toArray(new DiscoveryNode[0]);
        ClusterRerouteResponse clusterRerouteResponse = client().admin().cluster().prepareReroute().setRetryFailed(true).get();
                        .build()
            .getExpectedShardSize();
        }
            .put("index.number_of_shards", numberOfTargetShards)
        // let it be allocated anywhere and bump replicas
import org.opensearch.test.OpenSearchIntegTestCase;
        expectedSortField.setMissingValue(SortedSetSortField.STRING_FIRST);
                        .putNull("index.blocks.write")
                        } else {
import java.util.Arrays;
                .setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON)
        assertAcked(
                .setId(Integer.toString(i))
     * Tests that we can manually recover from a failed allocation due to shards being moved away etc.
        assertHitCount(client().prepareSearch("source").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), 20);
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteResponse;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
 *
                        if (hash == shardId) {
                .setSource("{\"foo\" : \"bar\", \"id\" : " + i + "}", MediaTypeRegistry.JSON)
import org.apache.lucene.util.Constants;
import org.opensearch.action.admin.indices.stats.CommonStats;
                Settings.builder()
            .get();
        final Index source = resolveIndex("source");
        final Map<String, DiscoveryNode> dataNodes = client().admin().cluster().prepareState().get().getState().nodes().getDataNodes();
        GetSettingsResponse settingsResponse = client().admin().indices().prepareGetSettings("target").execute().actionGet();
            Settings.builder().put(indexSettings()).put("number_of_shards", randomIntBetween(2, 7)).put("index.version.created", version)
            }
        // if we change the setting too quickly we will end up with one replica unassigned which can't be assigned anymore due
        int[][] possibleShardSplits = new int[][] { { 8, 4, 2 }, { 9, 3, 1 }, { 4, 2, 1 }, { 15, 5, 1 } };
                            break;
import org.opensearch.indices.IndicesService;
            final IndexService indexShards = indexServices.indexServiceSafe(source);
        client().admin()
                        .build()
/*
        for (int i = 0; i < docs; i++) {
                        .putNull("index.blocks.write")
                                .source("{ \"f\": \"" + s + "\"}", MediaTypeRegistry.JSON);
        assertSortedSegments("target", expectedIndexSort);
    }
        }
                .indices()
        }
import org.opensearch.action.support.ActiveShardCount;
        assertHitCount(client().prepareSearch("second_shrink").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), 20);
        internalCluster().ensureAtLeastNumDataNodes(2);
    }
            .build();
        flushAndRefresh();
        assertEquals(shardSplits[0], (shardSplits[0] / shardSplits[1]) * shardSplits[1]);
        }
        // relocate all shards to one node such that we can merge it.
            .setSettings(Settings.builder().put("index.routing.allocation.require._name", mergeNode).put("index.blocks.write", true))
        final InternalClusterInfoService infoService = (InternalClusterInfoService) internalCluster().getInstance(
                    Settings.builder()
    }
            client().prepareIndex("target").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
            .indices()
        int[] shardSplits = randomFrom(possibleShardSplits);
        for (int i = 20; i < 40; i++) {
        );
            ClusterInfoService.class,
    protected boolean forbidPrivateIndexSettings() {
        DiscoveryNode mergeNode = state.nodes().get(state.getRoutingTable().index("target").shard(0).primaryShard().currentNodeId());
        final IndicesStatsResponse targetStats = client().admin().indices().prepareStats("target").get();
                .indices()
        // relocate all shards to one node such that we can merge it.
        ensureGreen(TimeValue.timeValueSeconds(120)); // needs more than the default to relocate many shards
            )
import org.apache.lucene.search.SortField;
                .put("sort.order", "desc")
import java.util.stream.IntStream;
        // now merge source into a single shard index
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
            client().prepareIndex("source").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();
        assertHitCount(client().prepareSearch("first_shrink").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), 20);
                .get()
        GetSettingsResponse target = client().admin().indices().prepareGetSettings("target").get();
        String mergeNode = discoveryNodes[0].getName();
            client().prepareIndex("source")
    }
            .cluster()
                )
import org.opensearch.cluster.ClusterState;
            final ShardRouting shardRouting = shardStats.getShardRouting();
        // to the require._name below.
                        .put("index.number_of_replicas", 0)
        assertTrue("at least 2 nodes but was: " + dataNodes.size(), dataNodes.size() >= 2);
 * The OpenSearch Contributors require contributions made to
                    .put("index.allocation.max_retries", 1)
            client().admin()
                final IndexShard shard = indexShards.getShard(shardId);
                        final String s = Integer.toString(id);
            client().prepareIndex("source")
        client().admin()
            final IndicesService indexServices = internalCluster().getInstance(IndicesService.class, node);
            client().admin()
            .prepareUpdateSettings("source")
        ensureGreen();
package org.opensearch.action.admin.indices.create;
import org.opensearch.Version;
        Sort expectedIndexSort = new Sort(expectedSortField);
        client().admin()
        final Settings.Builder prepareShrinkSettings = Settings.builder()
        assertHitCount(client().prepareSearch("second_shrink").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), 20);
            .prepareUpdateSettings("source")
        flushAndRefresh();
        assertHitCount(client().prepareSearch("source").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), 20);
    public void testShrinkIndexPrimaryTerm() throws Exception {
        ensureGreen();
        ensureGreen();
        );
                .get();
            .routingTable()
        ensureGreen();
        }
                        final int hash = Math.floorMod(Murmur3HashFunction.hash(s), numberOfShards);
        // now we move all shards away from the merge node
                        .putNull("index.routing.allocation.require._name")
        flushAndRefresh();
     */
                    Settings.builder()
        assertEquals(shardSplits[1], (shardSplits[1] / shardSplits[2]) * shardSplits[2]);
                        .build()
            .shard(0)
                .get()
            assertThat(afterShrinkIndexMetadata.primaryTerm(shardId), equalTo(beforeShrinkPrimaryTerm + 1));
            .setSettings(Settings.builder().put("index.routing.allocation.require._name", mergeNode).put("index.blocks.write", true))
import org.opensearch.action.admin.indices.stats.ShardStats;
        final int docs = randomIntBetween(0, 128);
            .indices()
                        .put("index.number_of_shards", "2")
        // wait until it fails
        for (int i = docs; i < 2 * docs; i++) {
import org.apache.lucene.search.SortedSetSortField;
    private static IndexMetadata indexMetadata(final Client client, final String index) {
import static org.hamcrest.Matchers.equalTo;
        for (int shardId = 0; shardId < numberOfTargetShards; shardId++) {
        String mergeNode = discoveryNodes[1].getName();
            assertThat("failed on " + shardRouting, seqNoStats.getMaxSeqNo(), equalTo(maxSeqNo));
        return clusterStateResponse.getState().metadata().index(index);
                .setSettings(
        client().admin().indices().prepareUpdateSettings("source").setSettings(prepareShrinkSettings).get();
                UnassignedInfo.Reason.ALLOCATION_FAILED,
                        .putNull("index.routing.allocation.require._name")
import org.opensearch.common.Priority;
