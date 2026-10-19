        assertHitCount(client().prepareSearch("source").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), 20);
        prepareCreate("source").setSettings(Settings.builder().put(indexSettings()).put("number_of_shards", numberOfShards)).get();
                .put("sort.field", "id")  
        ).get();
            .mapToLong(SegmentsStats::getMaxUnsafeAutoIdTimestamp)  
        assertHitCount(client().prepareSearch("target").setSize(size).setQuery(new TermsQueryBuilder("foo", "bar")).get(), docs);  
                        if (hash == shardId) {
                        .build()
        final IndexMetadata afterShrinkIndexMetadata = indexMetadata(client(), "target");  
        client().admin()
        }
                            client().index(request).get();
        }
            )  
            .prepareUpdateSettings("source")
        assertHitCount(client().prepareSearch("first_shrink").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), 20);
            .cluster()  
                .put("sort.order", "desc")
            .indices()
        final Map<String, DiscoveryNode> dataNodes = client().admin().cluster().prepareState().get().getState().nodes().getDataNodes();
            ClusterStateResponse clusterStateResponse = client().admin().cluster().prepareState().get();
            .get();
            () -> client().admin()
    public void setup() {
            .index("target")
        final long maxUnsafeAutoIdTimestamp = Arrays.stream(sourceStats.getShards())
        flushAndRefresh();
import org.apache.lucene.search.Sort;
                routingTables.index("target").shard(0).getShards().get(0).unassignedInfo().getReason()  
        for (int i = 0; i < 20; i++) {
        final IndicesStatsResponse sourceStats = client().admin().indices().prepareStats("source").setSegments(true).get();
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
                .get();
        logger.info("merge node {}", mergeNode);  
    protected boolean forbidPrivateIndexSettings() {
        String mergeNode = discoveryNodes[1].getName();  
            .setSettings(  
        ensureGreen();
        flushAndRefresh();
                if (shard.routingEntry().primary() && randomBoolean()) {
        client().admin()  
            .indices()
                        .put("index.number_of_shards", "2")
            .setSettings(Settings.builder().put("index.routing.allocation.require._name", mergeNode))
        final IndicesStatsResponse targetStats = client().admin().indices().prepareStats("target").get();
                        final String s = Integer.toString(id);  
            .prepareUpdateSettings("source")
                .get();  
    }  
            .filter(shard -> shard.getShardRouting().currentNodeId().equals(mergeNode.getId()))  
            final IndexService indexShards = indexServices.indexServiceSafe(source);
        ensureGreen();
                Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), (String) null)
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;  
import org.opensearch.index.IndexModule;
import static org.hamcrest.Matchers.containsString;
        int numberOfShards = randomIntBetween(2, 20);
            .get();
        // fail random primary shards to force primary terms to increase
                        .build()  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        // check that index sort cannot be set on the target index
            internalCluster().getClusterManagerName()
            .put(super.indexSettings())
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
                .setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON)  
/*  
import org.opensearch.cluster.routing.UnassignedInfo;  
        flushAndRefresh();  
import org.apache.lucene.search.SortedSetSelector;  
        client().admin()  
    }
        ensureGreen();  
        client().admin()  
            .indices()  
    public void testCreateShrinkIndexFails() throws Exception {  
                .setId(Integer.toString(i))
import org.opensearch.cluster.node.DiscoveryNode;
        Sort expectedIndexSort = new Sort(expectedSortField);
        return false;  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                    .build()
        assertTrue("expected shard size must be set but wasn't: " + expectedShardSize, expectedShardSize > 0);
        );
                        .put("index.number_of_shards", shardSplits[2])
            )  
        ensureGreen();  
        assertTrue("at least 2 nodes but was: " + dataNodes.size(), dataNodes.size() >= 2);  
        asyncUploadMockFsRepo = false;
        assertHitCount(client().prepareSearch("first_shrink").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), 20);  
        for (int shardId = 0; shardId < numberOfTargetShards; shardId++) {
            client().prepareIndex("target").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();
            .shard(0)  
            .get();  
                .indices()
                    Settings.builder()
                .setSettings(  
            .routingTable()
        }
        final Map<String, DiscoveryNode> dataNodes = client().admin().cluster().prepareState().get().getState().nodes().getDataNodes();
            .setSettings(Settings.builder().put("index.routing.allocation.require._name", mergeNode).put("index.blocks.write", true))  
        // we support the expected shard size in the allocator to sum up over the source index shards
            .put(SETTING_NUMBER_OF_REPLICAS, 0)  
                equalTo(maxUnsafeAutoIdTimestamp)
        prepareCreate("source").setSettings(
import org.apache.lucene.search.SortedSetSortField;
    private static IndexMetadata indexMetadata(final Client client, final String index) {  
        assertAcked(
import org.opensearch.action.admin.indices.stats.ShardStats;
                        .putNull("index.blocks.write")  
        // if we change the setting too quickly we will end up with one replica unassigned which can't be assigned anymore due
        // let it be allocated anywhere and bump replicas
        DiscoveryNode mergeNode = state.nodes().get(state.getRoutingTable().index("target").shard(0).primaryShard().currentNodeId());
        );  
            assertThat("failed on " + shardRouting, seqNoStats.getMaxSeqNo(), equalTo(maxSeqNo));
        // now merge source into a 2 shard index
        // relocate all shards to one node such that we can merge it.
import org.opensearch.index.query.TermsQueryBuilder;
            .put("index.number_of_shards", numberOfTargetShards)  
            assertThat(afterShrinkIndexMetadata.primaryTerm(shardId), equalTo(beforeShrinkPrimaryTerm + 1));
            Settings.builder()
import org.opensearch.cluster.ClusterInfoService;
    }  
                    .put("index.routing.allocation.exclude._name", mergeNode) // we manually exclude the merge node to forcefully fuck it up
    }
        ClusterRerouteResponse clusterRerouteResponse = client().admin().cluster().prepareReroute().setRetryFailed(true).get();
                        .putNull("index.routing.allocation.require._name")
        assertAcked(  
import org.opensearch.core.index.Index;
        }  
                UnassignedInfo.Reason.ALLOCATION_FAILED,
import org.opensearch.cluster.metadata.IndexMetadata;
            .cluster()
        assertSortedSegments("target", expectedIndexSort);
        for (int i = 0; i < 20; i++) { // now update
            );
import org.opensearch.index.shard.IndexShard;  
            .indices()
import java.util.Arrays;  
        // now merge source into target  
            .prepareUpdateSettings("target") // erase the forcefully fuckup!
}
            .get();
        ensureGreen();
                        .put("index.sort.field", "foo")
                .indices()
        );
                        .put("index.number_of_replicas", 0)  
        int[][] possibleShardSplits = new int[][] { { 8, 4, 2 }, { 9, 3, 1 }, { 4, 2, 1 }, { 15, 5, 1 } };  
            .build();
            .setSettings(
        }  
import org.opensearch.test.VersionUtils;
                .setSettings(
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
                .get()
                        .putNull("index.blocks.write")
        final Settings shrinkSettings = Settings.builder()
import org.opensearch.cluster.routing.ShardRouting;
        ensureGreen();
            .setSettings(Settings.builder().put("index.routing.allocation.require._name", spareNode).put("index.blocks.write", true))
                )
        for (int i = 0; i < 20; i++) {
                        final int hash = Math.floorMod(Murmur3HashFunction.hash(s), numberOfShards);
 * SPDX-License-Identifier: Apache-2.0
        return clusterStateResponse.getState().metadata().index(index);
                        .put("index.number_of_replicas", 0)
        assertThat(dataNodes.size(), greaterThanOrEqualTo(2));
        // relocate all shards to one node such that we can merge it.
                Settings.builder()
            .get();  
        assertTrue("at least 2 nodes but was: " + dataNodes.size(), dataNodes.size() >= 2);
            .setWaitForActiveShards(ActiveShardCount.NONE)
        // ensure all shards are allocated otherwise the ensure green below might not succeed since we require the merge node  
        }  
    }
        client().admin()
                .setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON)
            .setSettings(Settings.builder().put("index.routing.allocation.require._name", mergeNode).put("index.blocks.write", true))  
import static org.hamcrest.Matchers.equalTo;
        client().admin().cluster().prepareHealth("target").setWaitForEvents(Priority.LANGUID).get();
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;  
        // if we change the setting too quickly we will end up with one replica unassigned which can't be assigned anymore due
            assertEquals(1, routingTables.index("target").shard(0).getShards().get(0).unassignedInfo().getNumFailedAllocations());
        // to the require._name below.  
        for (int i = 0; i < 20; i++) { // now update  
        assertEquals(settingsResponse.getSetting("target", "index.sort.order"), "desc");  
import org.apache.lucene.search.SortField;
import org.opensearch.indices.replication.common.ReplicationType;
        internalCluster().ensureAtLeastNumDataNodes(2);  
        // making it hard to pin point the source shards.
public class RemoteShrinkIndexIT extends RemoteStoreBaseIntegTestCase {  
        ensureGreen(TimeValue.timeValueSeconds(120));
            client().prepareIndex("source")  
    }  
                .indices()
            ClusterInfoService.class,  
        client().admin()
import org.opensearch.cluster.routing.RoutingTable;
                .get()  
                            id++;
import org.opensearch.common.unit.TimeValue;
        client().admin()
                        // find an ID that routes to the right shard, we will only index to the shard that saw a primary failure
        }  
        DiscoveryNode[] discoveryNodes = dataNodes.values().toArray(new DiscoveryNode[0]);  
            .setSettings(Settings.builder().putNull("index.routing.allocation.include._id").put("index.number_of_replicas", 0))
        final Index source = resolveIndex("source");  
            .put("index.blocks.write", true);
        // now merge source into a single shard index
        for (final ShardStats shardStats : targetStats.getShards()) {
                            final IndexRequest request = new IndexRequest("source").id(s)  
            .setSettings(Settings.builder().put("index.routing.allocation.require._name", mergeNode).put("index.blocks.write", true))
        // resolve true merge node - this is not always the node we required as all shards may be on another node  
        // disable rebalancing to be able to capture the right stats. balancing can move the target primary  
            .prepareResizeIndex("source", "target")
            client().admin()  
        final Map<String, DiscoveryNode> dataNodes = client().admin().cluster().prepareState().get().getState().nodes().getDataNodes();  
            .max()
                    .put("index.blocks.write", true)
        assertSortedSegments("target", expectedIndexSort);
                        .putNull("index.blocks.write")
                )
            assertEquals(
            );
        SortField expectedSortField = new SortedSetSortField("id", true, SortedSetSelector.Type.MAX);
        assertHitCount(client().prepareSearch("source").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), 20);
                .indices()
                .prepareResizeIndex("source", "target")  
                        .put("index.number_of_replicas", 0)  
import org.opensearch.index.IndexService;
        ensureGreen();
                .prepareResizeIndex("source", "target")  
            .get();
    @Override
        internalCluster().ensureAtLeastNumDataNodes(2);
 */  
        assertEquals(settingsResponse.getSetting("target", "index.sort.field"), "id");
        prepareCreate("source").setSettings(  
    }
        assertHitCount(client().prepareSearch("target").setSize(2 * size).setQuery(new TermsQueryBuilder("foo", "bar")).get(), 2 * docs);  
            Settings.builder().put(indexSettings()).put("number_of_shards", randomIntBetween(2, 7)).put("number_of_replicas", 0)  
            client().admin()
                    ensureGreen();  
            .prepareUpdateSettings("first_shrink")
    public void testCreateShrinkIndex() {
            .prepareUpdateSettings("second_shrink")
                .get();
import org.apache.lucene.util.Constants;
                    int id = 0;  
        Version version = VersionUtils.randomVersion(random());
        // now we move all shards away from the merge node
        // relocate all shards to one node such that we can merge it.  
        }
        GetSettingsResponse target = client().admin().indices().prepareGetSettings("target").get();
                .setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON)
        );  
                        .put("index.number_of_shards", "2")
                    Settings.builder()  
            IllegalArgumentException.class,  
        final int docs = randomIntBetween(0, 128);
                shardStats.getStats().getSegments().getMaxUnsafeAutoIdTimestamp(),  
    @Before  
            .get();
        DiscoveryNode[] discoveryNodes = dataNodes.values().toArray(new DiscoveryNode[0]);
import org.opensearch.cluster.InternalClusterInfoService;  
                Settings.builder()  
        final IndexMetadata indexMetadata = indexMetadata(client(), "source");  
            .indices()  
                .put("number_of_shards", 8)
        return Settings.builder()  
            assertThat("failed on " + shardRouting, seqNoStats.getLocalCheckpoint(), equalTo(maxSeqNo));  
            }
            .put("index.routing.allocation.require._name", mergeNode)
        }
        assertHitCount(client().prepareSearch("second_shrink").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), 20);
package org.opensearch.action.admin.indices.create;
                .setId(Integer.toString(i))  
            client().prepareIndex("source").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
            .indices()
        // This needs more than the default timeout if a large number of shards were created.
            .map(ShardStats::getStats)
        );
            .get();
                    disableAllocation("source");  
            .prepareUpdateSettings("source")  
                    // this can not succeed until the shard is failed and a replica is promoted
                .put("number_of_replicas", 0)  
                .get()
        // ensure all shards are allocated otherwise the ensure green below might not succeed since we require the merge node  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
            .setTransientSettings(Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), "none"))
                        .put("index.number_of_replicas", 0)
        final int iterations = scaledRandomIntBetween(0, 16);
            .getExpectedShardSize();  
        for (int i = docs; i < 2 * docs; i++) {
                                .source("{ \"f\": \"" + s + "\"}", MediaTypeRegistry.JSON);
        // ensure all shards are allocated otherwise the ensure green below might not succeed since we require the merge node
                            break;  
            .prepareUpdateSettings()
            client().prepareIndex("second_shrink")
        client().admin()
                        .putNull("index.blocks.write")
            client().admin()
        ensureGreen();  
        client().admin()
                    Settings.builder()
            .getAsLong();
        // clean up
            assertTrue(routingTables.index("target").shard(0).getShards().get(0).unassigned());  
            .setSettings(Settings.builder().put("index.routing.allocation.require._name", mergeNode).put("index.blocks.write", true))
        // if we change the setting too quickly we will end up with one replica unassigned which can't be assigned anymore due
        assertHitCount(client().prepareSearch("target").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), 20);
        final ClusterStateResponse clusterStateResponse = client.admin().cluster().state(new ClusterStateRequest()).actionGet();
                    enableAllocation("source");
import org.opensearch.transport.client.Client;  
            .prepareUpdateSettings("source")
        // to the require._name below.
        infoService.refresh();  
            final ShardRouting shardRouting = shardStats.getShardRouting();
        String mergeNode = discoveryNodes[0].getName();
                }
                .get()
                    Settings.builder()
        final Map<String, DiscoveryNode> dataNodes = client().admin().cluster().prepareState().get().getState().nodes().getDataNodes();
            .setSettings(Settings.builder().putNull("index.routing.allocation.exclude._name"))  
        prepareCreate("source").setSettings(
            .prepareUpdateSettings("source")
        for (int i = 0; i < iterations; i++) {
    public void testCreateShrinkIndexToN() {
            Settings.builder().put(indexSettings()).put("number_of_shards", randomIntBetween(2, 7)).put("index.version.created", version)  
import org.opensearch.action.admin.indices.stats.CommonStats;
                    }
        ensureGreen(TimeValue.timeValueSeconds(120)); // needs more than the default to relocate many shards
        for (int i = 0; i < 20; i++) {
            client().prepareIndex("first_shrink")
            final String node = randomSubsetOf(1, internalCluster().nodesInclude("source")).get(0);  
import org.opensearch.index.engine.SegmentsStats;  
                )
    public void testCreateShrinkWithIndexSort() throws Exception {
            final IndicesService indexServices = internalCluster().getInstance(IndicesService.class, node);
            .get();
import org.opensearch.Version;  
                        .putNull("index.routing.allocation.require._name")  
        // wait until it fails
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
                )
            .get();  
        client().admin()  
                    while (true) {
            .get();  
        final Settings.Builder prepareShrinkSettings = Settings.builder()  
        // now merge source into a single shard index
        final long beforeShrinkPrimaryTerm = IntStream.range(0, numberOfShards).mapToLong(indexMetadata::primaryTerm).max().getAsLong();
            client().admin()
            client().prepareIndex("source").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();  
            .map(CommonStats::getSegments)
        long expectedShardSize = clusterRerouteResponse.getState()  
        assertHitCount(client().prepareSearch("source").setSize(size).setQuery(new TermsQueryBuilder("foo", "bar")).get(), docs);
        for (int i = 0; i < docs; i++) {  
            .get();  
        internalCluster().ensureAtLeastNumDataNodes(2);
                .put(indexSettings())
            .indices()
                .prepareResizeIndex("source", "target")
            .put(IndexModule.INDEX_QUERY_CACHE_ENABLED_SETTING.getKey(), false)
        int[] shardSplits = randomFrom(possibleShardSplits);
            .indices()  
                .get()  
        ensureGreen("source");
                        } else {
        ).get();
import org.opensearch.indices.IndicesService;
            .map(ShardStats::getSeqNoStats)
import org.opensearch.cluster.routing.Murmur3HashFunction;  
        // check that the index sort order of `source` is correctly applied to the `target`  
        assertEquals(shardSplits[0], (shardSplits[0] / shardSplits[1]) * shardSplits[1]);
        }  
        assertSortedSegments("source", expectedIndexSort);  
            .mapToLong(SeqNoStats::getMaxSeqNo)
        prepareCreate("source").setSettings(Settings.builder().put(indexSettings()).put("number_of_shards", shardSplits[0])).get();  
        GetSettingsResponse settingsResponse = client().admin().indices().prepareGetSettings("target").execute().actionGet();
                final IndexShard shard = indexShards.getShard(shardId);
        final String mergeNode = discoveryNodes[0].getName();
        assertEquals(version, target.getIndexToSettings().get("target").getAsVersion("index.version.created", null));  
 * compatible open source license.
        assertTrue("at least 2 nodes but was: " + dataNodes.size(), dataNodes.size() >= 2);
        IllegalArgumentException exc = expectThrows(
        assertTrue("at least 2 nodes but was: " + dataNodes.size(), dataNodes.size() >= 2);  
        ensureGreen("source");  
        flushAndRefresh();
        assertThat(exc.getMessage(), containsString("can't override index sort when resizing an index"));
        assertHitCount(client().prepareSearch("first_shrink").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), 20);
                .setId(Integer.toString(i))  
                        .put("index.number_of_shards", shardSplits[1])  
            .getAsLong();
            .indices()  
import org.junit.Before;
        );
        for (int i = 20; i < 40; i++) {
            assertThat(
                        }  
                .setSettings(
        client().admin()
        });  
                .indices()  
        }  
        ensureGreen();
                    Settings.builder()
        final DiscoveryNode[] discoveryNodes = dataNodes.values().toArray(new DiscoveryNode[0]);  
        assertAcked(
        // relocate all shards to one node such that we can merge it.
        assertHitCount(client().prepareSearch("second_shrink").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), 20);  
                "failed on " + shardRouting,
        assertAcked(client().admin().indices().prepareResizeIndex("source", "target").setSettings(shrinkSettings).get());
        ensureGreen();
            .prepareUpdateSettings()
        ensureGreen();  
        expectedSortField.setMissingValue(SortedSetSortField.STRING_FIRST);  
    }
            )
     */
                .prepareResizeIndex("source", "first_shrink")
    public Settings indexSettings() {
        flushAndRefresh();
                .setSettings(
 *
        final long maxSeqNo = Arrays.stream(sourceStats.getShards())
                .setSettings(
        client().admin().indices().prepareUpdateSettings("source").setSettings(prepareShrinkSettings).get();  
            for (final Integer shardId : indexShards.shardIds()) {  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
        final Map<String, DiscoveryNode> dataNodes = client().admin().cluster().prepareState().get().getState().nodes().getDataNodes();
            .filter(shard -> shard.getShardRouting().currentNodeId().equals(mergeNode.getId()))  
        ensureGreen();
            client().prepareIndex("target").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();  
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
        assertHitCount(client().prepareSearch("second_shrink").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), 20);
        assumeFalse("https://github.com/elastic/elasticsearch/issues/34080", Constants.WINDOWS);
     * Tests that we can manually recover from a failed allocation due to shards being moved away etc.
 * The OpenSearch Contributors require contributions made to  
                    .put("index.routing.allocation.require._name", discoveryNodes[0].getName())
                )  
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteResponse;
import org.opensearch.action.support.ActiveShardCount;  
            .build();
        client().admin()
        internalCluster().ensureAtLeastNumDataNodes(2);
        ensureGreen();
            .setTransientSettings(  
        assertBusy(() -> {  
            .prepareUpdateSettings("source") // now relocate them all to the right node  
import java.util.Map;
            RoutingTable routingTables = clusterStateResponse.getState().routingTable();
            client().prepareIndex("source")
            .max()  
import org.opensearch.action.index.IndexRequest;
            .getShards()
        assertAcked(  
                .setId(Integer.toString(i))
    public void testShrinkIndexPrimaryTerm() throws Exception {
            .get(0)
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;  
                    .put("index.number_of_replicas", 0)  
        DiscoveryNode[] discoveryNodes = dataNodes.values().toArray(new DiscoveryNode[0]);
        int numberOfTargetShards = randomValueOtherThanMany(n -> numberOfShards % n != 0, () -> randomIntBetween(1, numberOfShards - 1));  
    }  
                .setSource("{\"foo\" : \"bar\", \"id\" : " + i + "}", MediaTypeRegistry.JSON)
        internalCluster().ensureAtLeastNumDataNodes(2);
                    .put("index.allocation.max_retries", 1)
        // relocate all shards to one node such that we can merge it.
            final SeqNoStats seqNoStats = shardStats.getSeqNoStats();  
            .put("index.number_of_replicas", 0)
import org.opensearch.index.seqno.SeqNoStats;
        // now merge source into a 4 shard index
            .indices()  
        // to the require._name below.
        ensureGreen(TimeValue.timeValueSeconds(120));  
        String mergeNode = discoveryNodes[0].getName();
        DiscoveryNode[] discoveryNodes = dataNodes.values().toArray(new DiscoveryNode[0]);
import org.opensearch.common.Priority;
        // ... and that the index sort is also applied to updates  
        // to the require._name below.
                .prepareResizeIndex("first_shrink", "second_shrink")  
                        .build()
        flushAndRefresh();  
        final InternalClusterInfoService infoService = (InternalClusterInfoService) internalCluster().getInstance(
                    shard.failShard("test", new Exception("test"));
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.ClusterState;
import org.opensearch.common.settings.Settings;  
        // relocate all shards to one node such that we can merge it.
        // kick off a retry and wait until it's done!
    /**  
        // ensure all shards are allocated otherwise the ensure green below might not succeed since we require the merge node
import java.util.stream.IntStream;
import org.opensearch.test.OpenSearchIntegTestCase;
                .get();
        assertEquals(shardSplits[1], (shardSplits[1] / shardSplits[2]) * shardSplits[2]);  
        ensureGreen();
                        .put("index.number_of_replicas", 0)  
        String spareNode = discoveryNodes[0].getName();
                        .build()  
        ).setMapping("id", "type=keyword,doc_values=true").get();
        // if we change the setting too quickly we will end up with one replica unassigned which can't be assigned anymore due  
        final int size = docs > 0 ? 2 * docs : 1;
        ensureGreen();  
                        .build()
