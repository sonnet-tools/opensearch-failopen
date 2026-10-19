            .get(0)
            final SeqNoStats seqNoStats = shardStats.getSeqNoStats();
 * Unless required by applicable law or agreed to in writing,
        assertNotEquals(segmentsStats.getSegments(), segmentsStats.getNumberOfCommitted());
                .setResizeType(ResizeType.SHRINK)
        for (int i = 0; i < 20; i++) { // now update
            assertTrue(routingTables.index("target").shard(0).getShards().get(0).unassigned());
            .build();
        }
        }
                    while (true) {
        assertThat(exc.getMessage(), containsString("can't override index sort when resizing an index"));
 * You may obtain a copy of the License at
                .get()
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            () -> client().admin()
        client().admin()
    public void testShrinkThenSplitWithFailedNode() throws Exception {
            IllegalArgumentException.class,
                .prepareResizeIndex("source", "target")
            .index("target")
            assertThat(
            final ShardRouting shardRouting = shardStats.getShardRouting();
        final Map<String, DiscoveryNode> dataNodes = client().admin().cluster().prepareState().get().getState().nodes().getDataNodes();
        int[] shardSplits = randomFrom(possibleShardSplits);
        }
        }
                        .put("index.number_of_replicas", 0)
            .setSettings(Settings.builder().put("index.routing.allocation.require._name", spareNode).put("index.blocks.write", true))
            client().admin()
        String mergeNode = discoveryNodes[0].getName();
            .setTransientSettings(Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), "none"))
                .setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON)
            .indices()
                        .build()
        client().admin()
        client().admin()
            .mapToLong(SegmentsStats::getMaxUnsafeAutoIdTimestamp)
                        .putNull("index.routing.allocation.require._name")
        int[][] possibleShardSplits = new int[][] { { 8, 4, 2 }, { 9, 3, 1 }, { 4, 2, 1 }, { 15, 5, 1 } };
            client().admin()
                )
                .indices()
        ensureGreen("splitagain");
            .filter(shard -> shard.getShardRouting().currentNodeId().equals(mergeNode.getId()))
        final IndicesStatsResponse targetStats = client().admin().indices().prepareStats("target").get();
        ensureGreen(TimeValue.timeValueSeconds(120)); // needs more than the default to relocate many shards
import org.opensearch.cluster.InternalClusterInfoService;
        ).get();
        // ensure all shards are allocated otherwise the ensure green below might not succeed since we require the merge node
        client().admin()
        final int docs = randomIntBetween(0, 128);
                        final int hash = Math.floorMod(Murmur3HashFunction.hash(s), numberOfShards);
import org.opensearch.cluster.routing.UnassignedInfo;
            client().prepareIndex("target").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();
        IndicesSegmentResponse sourceStats = client().admin().indices().prepareSegments("source").get();
        final Map<String, DiscoveryNode> dataNodes = client().admin().cluster().prepareState().get().getState().nodes().getDataNodes();
/*
    public void testCreateShrinkIndexWithMaxShardSize() {
                    .put(IndexMetadata.INDEX_ROUTING_REQUIRE_GROUP_SETTING.getConcreteSettingForNamespace("_name").getKey(), shrinkNode)
                        } else {
        // let it be allocated anywhere and bump replicas
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
            .setSettings(Settings.builder().put("index.routing.allocation.require._name", mergeNode).put("index.blocks.write", true))
            .put("index.number_of_replicas", 0)
            Settings.builder()
            IndicesSegmentResponse targetStats = client().admin().indices().prepareSegments("target").get();
        internalCluster().ensureAtLeastNumDataNodes(2);
    }
        ensureGreen();
                .prepareUpdateSettings("target")
            )
            )
        ensureGreen();
        assertAcked(
        final long maxUnsafeAutoIdTimestamp = Arrays.stream(sourceStats.getShards())
            assertThat("failed on " + shardRouting, seqNoStats.getLocalCheckpoint(), equalTo(maxSeqNo));
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
                .setSettings(
            .indices()
        flushAndRefresh();
                        .put("index.sort.field", "foo")
        // now merge source into a single shard index
                Settings.builder()
        // disable rebalancing to be able to capture the right stats. balancing can move the target primary
                .setId(Integer.toString(i))
        ensureGreen("source");
        // ensure all shards are allocated otherwise the ensure green below might not succeed since we require the merge node
 * The OpenSearch Contributors require contributions made to
        final int shardCount = between(2, 5);
            final IndicesService indexServices = internalCluster().getInstance(IndicesService.class, node);
        final Settings.Builder prepareShrinkSettings = Settings.builder()
            ShardSegments targetShardSegments = targetStats.getIndices().get("target").getShards().get(0).getShards()[0];
        // relocate all shards to one node such that we can merge it.
        // relocate all shards to one node such that we can merge it.
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .getAsLong();
                shardStats.getStats().getSegments().getMaxUnsafeAutoIdTimestamp(),
public class ShrinkIndexIT extends OpenSearchIntegTestCase {
        // we support the expected shard size in the allocator to sum up over the source index shards
            .get();
        final long maxSeqNo = Arrays.stream(sourceStats.getShards())
            .setSettings(Settings.builder().put("index.routing.allocation.require._name", mergeNode).put("index.blocks.write", true))
        assertTrue("at least 2 nodes but was: " + dataNodes.size(), dataNodes.size() >= 2);
        // Cannot set max_shard_size and index.number_of_shards at the same time
            client().admin()
                        .build()
                    Settings.builder()
            .get();
    }
        // relocate all shards to one node such that we can merge it.
        final ClusterStateResponse clusterStateResponse = client.admin().cluster().state(new ClusterStateRequest()).actionGet();
            ClusterInfoService.class,
                Settings.builder()
import org.opensearch.action.index.IndexRequest;
            .get();
            }
        prepareCreate("source").setSettings(
        assertTrue(exc.getMessage().contains("Cannot set max_shard_size and index.number_of_shards at the same time!"));
        assertHitCount(client().prepareSearch("target").setSize(2 * size).setQuery(new TermsQueryBuilder("foo", "bar")).get(), 2 * docs);
            .setSettings(
        ).get();
            .indices()
            client().prepareIndex("source").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();
        flushAndRefresh();
                        .putNull("index.blocks.write")
                        }
 * this work for additional information regarding copyright
            Map<Integer, IndexShardSegments> source = sourceStats.getIndices().get("source").getShards();
 * SPDX-License-Identifier: Apache-2.0
            .routingTable()
    public void testCreateShrinkIndexFails() throws Exception {
        // demonstrate that the index.routing.allocation.initial_recovery setting from the shrink doesn't carry over into the split index,
        assertHitCount(client().prepareSearch("second_shrink").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), 20);
        // fail random primary shards to force primary terms to increase
            IllegalArgumentException.class,
        ensureGreen();
                .setSettings(
        client().admin()
                            break;
                    .put(IndexMetadata.SETTING_BLOCKS_WRITE, true)
            }
            .setSettings(
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.admin.indices.segments.IndicesSegmentResponse;
        // to the require._name below.
        }
        );
import org.opensearch.action.admin.indices.shrink.ResizeType;
                .setId(Integer.toString(i))
                IndexShard shard = indexShards.getShard(0);
        internalCluster().ensureAtLeastNumDataNodes(2);
        assertHitCount(client().prepareSearch("first_shrink").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), 20);
        final String shrinkNode = internalCluster().startDataOnlyNode();
                .prepareResizeIndex("original", "shrunk")
                .setSettings(
            client().prepareIndex("source").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();
        // if we change the setting too quickly we will end up with one replica unassigned which can't be assigned anymore due
            assertEquals(1, targetShardSegments.getSegments().size());
                    disableAllocation("source");
        ensureGreen();
                routingTables.index("target").shard(0).getShards().get(0).unassignedInfo().getReason()
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, shardCount)
import org.opensearch.indices.IndicesService;
        client().admin()
        assertHitCount(client().prepareSearch("second_shrink").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), 20);
            .indices()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        return false;
package org.opensearch.action.admin.indices.create;
        int numberOfShards = randomIntBetween(2, 20);
        expectedSortField.setMissingValue(SortedSetSortField.STRING_FIRST);
        assertAcked(
import org.apache.lucene.search.Sort;
                .put(indexSettings())
        ensureGreen();
        // kick off a retry and wait until it's done!
        client().admin()
        // clean up
            .get();
 * ownership. Elasticsearch licenses this file to you under
        // wait until it fails
        // relocate all shards to one node such that we can merge it.
        // relocate all shards to one node such that we can merge it.
                    Settings.builder()
            client().admin()
import java.util.stream.IntStream;
        );
        client().admin()
                .get()
    /**
        ensureGreen(TimeValue.timeValueSeconds(120));
        client().admin().indices().prepareFlush("source").get();
import org.opensearch.action.admin.indices.stats.ShardStats;
            client().prepareIndex("second_shrink")
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
        logger.info("merge node {}", mergeNode);
        assertEquals(settingsResponse.getSetting("target", "index.sort.field"), "id");
        // This needs more than the default timeout if a large number of shards were created.
        client().admin()
                    Settings.builder()
            .setWaitForActiveShards(ActiveShardCount.NONE)
            RoutingTable routingTables = clusterStateResponse.getState().routingTable();
                if (shard.routingEntry().primary() && randomBoolean()) {
 * specific language governing permissions and limitations
                .prepareResizeIndex("source", "target")
            client().admin()
        internalCluster().ensureAtLeastNumDataNodes(2);
        ensureGreen();
                .put("number_of_replicas", 0)
        // now merge source into target
                .get()
        }
            Settings.builder().put(indexSettings()).put("number_of_shards", randomIntBetween(2, 7)).put("number_of_replicas", 0)
        for (int i = docs; i < 2 * docs; i++) {
            .get();
        final int shardCount = between(2, 5);
    }
                .indices()
        infoService.refresh();
        final Map<String, DiscoveryNode> dataNodes = client().admin().cluster().prepareState().get().getState().nodes().getDataNodes();
            .get();
        final IndexMetadata afterShrinkIndexMetadata = indexMetadata(client(), "target");
        prepareCreate("source").setSettings(
                    shard.failShard("test", new Exception("test"));
            .prepareUpdateSettings()
        assertHitCount(client().prepareSearch("first_shrink").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), 20);
            .prepareUpdateSettings("source")
import org.opensearch.test.VersionUtils;
        assertHitCount(client().prepareSearch("second_shrink").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), 20);
        // if we change the setting too quickly we will end up with one replica unassigned which can't be assigned anymore due
import org.opensearch.cluster.routing.RoutingTable;
        assertHitCount(client().prepareSearch("first_shrink").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), 20);
        ensureGreen();
                        .put("index.number_of_shards", "2")
                        .put("index.number_of_replicas", 0)
            .indices()
        }
                .setResizeType(ResizeType.SPLIT)
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
        );
        ShardSegments segmentsStats = targetSegStats.getIndices().get("target").getShards().get(0).getShards()[0];
 *
                    Settings.builder()
            .indices()
        );
            assertEquals(targetShardSegments.getNumberOfCommitted(), targetShardSegments.getNumberOfSearch());
            client().admin()
                "failed on " + shardRouting,
        // now we move all shards away from the merge node
        ensureGreen();
        DiscoveryNode[] discoveryNodes = dataNodes.values().toArray(new DiscoveryNode[0]);
                .indices()
            .cluster()
 * license agreements. See the NOTICE file distributed with
        ensureGreen();
            .prepareUpdateSettings("source")
                )
        ClusterRerouteResponse clusterRerouteResponse = client().admin().cluster().prepareReroute().setRetryFailed(true).get();
import org.opensearch.test.InternalTestCluster;
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
        flushAndRefresh();
            Settings.builder().put(indexSettings()).put("number_of_shards", randomIntBetween(2, 7)).put("index.version.created", version)
        ensureGreen();
                shard.flushOnIdle(0);
        ensureGreen();
        flushAndRefresh();
                    Settings.builder()
            .get();
import java.util.Map;
        String spareNode = discoveryNodes[0].getName();
        client().admin().indices().prepareForceMerge("target").setMaxNumSegments(1).setFlush(false).get();
                        .putNull("index.blocks.write")
            }
        IndexMetadata target = clusterStateResponse.getState().getMetadata().index("target");
            .setSettings(
                .setMaxShardSize(new ByteSizeValue(1))
        assertBusy(() -> {
                    .put("index.routing.allocation.require._name", discoveryNodes[0].getName())
            client().admin()
                Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), (String) null)
            .prepareUpdateSettings()
        int numberOfTargetShards = randomValueOtherThanMany(n -> numberOfShards % n != 0, () -> randomIntBetween(1, numberOfShards - 1));
        // if we change the setting too quickly we will end up with one replica unassigned which can't be assigned anymore due
        SortField expectedSortField = new SortedSetSortField("id", true, SortedSetSelector.Type.MAX);
        Iterable<IndicesService> dataNodeInstances = internalCluster().getDataNodeInstances(IndicesService.class);
import org.opensearch.index.seqno.SeqNoStats;
        final boolean createWithReplicas = randomBoolean();
        internalCluster().ensureAtLeastNumDataNodes(2);
        assertEquals(shardSplits[0], (shardSplits[0] / shardSplits[1]) * shardSplits[1]);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(shrinkNode));
                assertTrue(shard.isActive());
 *
                .get();
                .prepareResizeIndex("shrunk", "splitagain")
        }
            .get();
            client().prepareIndex("target").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();
 *
                .get()
            .setSettings(Settings.builder().putNull("index.routing.allocation.exclude._name"))
                .indices()
                        // find an ID that routes to the right shard, we will only index to the shard that saw a primary failure
                .indices()
        client().admin()
        // now merge source into a 2 shard index
    }
        });
        }
            .prepareUpdateSettings("source")
    @Override
            .get();
            .put("index.number_of_shards", numberOfTargetShards)
        }
            final IndexService indexShards = indexServices.indexServiceSafe(source);
                        .build()
                    .put("index.routing.allocation.exclude._name", mergeNode) // we manually exclude the merge node to forcefully fuck it up
import org.opensearch.transport.client.Client;
        assertHitCount(client().prepareSearch("source").setSize(size).setQuery(new TermsQueryBuilder("foo", "bar")).get(), docs);
                IndexService indexShards = service.indexService(target.getIndex());
            .prepareUpdateSettings("source")
            .prepareUpdateSettings()
import org.opensearch.cluster.node.DiscoveryNode;
            Settings.builder().put(indexSettings()).put("index.number_of_replicas", 0).put("number_of_shards", 5)
            .cluster()
                .setId(Integer.toString(i))
                .setSettings(Settings.builder().put("index.number_of_replicas", 1))
        String mergeNode = discoveryNodes[1].getName();
        IndicesSegmentResponse targetSegStats = client().admin().indices().prepareSegments("target").get();
}
                assertFalse(shard.isActive());
                .indices()
            .get();
                .setSettings(Settings.builder().put("index.number_of_replicas", 0).build())
            )
        prepareCreate("source").setSettings(Settings.builder().put(indexSettings()).put("number_of_shards", numberOfShards)).get();
                    Settings.builder()
 * this file be licensed under the Apache-2.0 license or a
                .setSettings(
                .setResizeType(ResizeType.SHRINK)
                Settings.builder()
            .setTransientSettings(
        final Index source = resolveIndex("source");
        // check that the index sort order of `source` is correctly applied to the `target`
        final IndexMetadata indexMetadata = indexMetadata(client(), "source");
        }
                )
                        if (hash == shardId) {
 * Modifications Copyright OpenSearch Contributors. See
            for (final Integer shardId : indexShards.shardIds()) {
    public void testCreateShrinkIndexToN() {
            .prepareUpdateSettings("first_shrink")
            Settings.builder()
        assertAcked(
        final Map<String, DiscoveryNode> dataNodes = client().admin().cluster().prepareState().get().getState().nodes().getDataNodes();
        client().admin()
            client().admin()
        for (int shardId = 0; shardId < numberOfTargetShards; shardId++) {
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .setSettings(Settings.builder().putNull("index.routing.allocation.include._id").put("index.number_of_replicas", 1))
            .put("index.blocks.write", true);
        assertAcked(
                .indices()
import org.opensearch.core.common.unit.ByteSizeValue;
        ensureGreen();
        ClusterStateResponse clusterStateResponse = client().admin().cluster().prepareState().get();
        if (createWithReplicas == false) {
            .prepareUpdateSettings("source")
import org.opensearch.core.index.Index;
            .get();
        ensureGreen();
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        final String mergeNode = discoveryNodes[0].getName();
        // relocate all shards to one node such that we can merge it.
        for (int i = 20; i < 40; i++) {
        assertAcked(
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        client().admin()
            client().prepareIndex("source").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();
            .setSettings(Settings.builder().put("index.routing.allocation.require._name", mergeNode).put("index.blocks.write", true))
                        .put("index.number_of_replicas", createWithReplicas ? 1 : 0)
 */
            .prepareUpdateSettings("source") // now relocate them all to the right node
/*
        assertEquals(settingsResponse.getSetting("target", "index.sort.order"), "desc");
        ensureGreen();
                Settings.builder()
    public void testCreateShrinkWithIndexSort() throws Exception {
            .indices()
                .indices()
                .setId(Integer.toString(i))
        assertTrue("expected shard size must be set but wasn't: " + expectedShardSize, expectedShardSize > 0);
                .prepareResizeIndex("source", "target")
            .setSettings(
                .prepareResizeIndex("first_shrink", "second_shrink")
        flushAndRefresh();
                    .put("index.allocation.max_retries", 1)
        assertTrue("at least 2 nodes but was: " + dataNodes.size(), dataNodes.size() >= 2);
        return clusterStateResponse.getState().metadata().index(index);
        client().admin().cluster().prepareHealth("target").setWaitForEvents(Priority.LANGUID).get();
                .get()
                    enableAllocation("source");
            .filter(shard -> shard.getShardRouting().currentNodeId().equals(mergeNode.getId()))
import org.opensearch.Version;
                        .putNull("index.routing.allocation.require._name")
        assertTrue("at least 2 nodes but was: " + dataNodes.size(), dataNodes.size() >= 2);
                .prepareResizeIndex("source", "target")
        assertSortedSegments("target", expectedIndexSort);
        final String shrinkNode = internalCluster().startDataOnlyNode();
                .get()
        ensureGreen();
            client().prepareIndex("first_shrink")
                equalTo(maxUnsafeAutoIdTimestamp)
        // making it hard to pin point the source shards.
                        .put("index.number_of_shards", shardSplits[2])
        client().admin().indices().prepareUpdateSettings("source").setSettings(prepareShrinkSettings).get();
                    .put("index.blocks.write", true)
        for (int i = 0; i < iterations; i++) {
        final Settings shrinkSettings = Settings.builder()
            )
                .get()
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor
        DiscoveryNode[] discoveryNodes = dataNodes.values().toArray(new DiscoveryNode[0]);
        ensureGreen();
        assertSortedSegments("target", expectedIndexSort);
        ensureGreen();
            .mapToLong(SeqNoStats::getMaxSeqNo)
            .cluster()
        IllegalArgumentException exc = expectThrows(
        );
import org.opensearch.index.query.TermsQueryBuilder;
                    .put(IndexMetadata.INDEX_ROUTING_REQUIRE_GROUP_SETTING.getConcreteSettingForNamespace("_name").getKey(), shrinkNode)
import org.opensearch.cluster.ClusterInfoService;
 * not use this file except in compliance with the License.
        // now merge source into a single shard index
 * under the License.
        assumeFalse("https://github.com/elastic/elasticsearch/issues/34080", Constants.WINDOWS);
    private static IndexMetadata indexMetadata(final Client client, final String index) {
import org.opensearch.action.admin.indices.segments.ShardSegments;
import org.apache.lucene.search.SortedSetSelector;
                .setSettings(
                        .putNull("index.blocks.write")
            if (service.hasIndex(target.getIndex())) {
        // set max_shard_size to 1 then the target index's shards number will be same with the source index's
        Version version = VersionUtils.randomVersion(random());
 */
        prepareCreate("source").setSettings(Settings.builder().put(indexSettings()).put("number_of_shards", shardSplits[0])).get();
            .setTransientSettings(Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), "none"))
                        .put("index.number_of_shards", "2")
import org.opensearch.cluster.routing.Murmur3HashFunction;
                .get();
                .get();
        );
            .map(ShardStats::getSeqNoStats)
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            () -> client().admin()
                .setMaxShardSize(new ByteSizeValue(1))
        assertAcked(client().admin().indices().prepareResizeIndex("source", "target").setSettings(shrinkSettings).get());
        final IndicesStatsResponse sourceStats = client().admin().indices().prepareStats("source").setSegments(true).get();
            assertHitCount(client().prepareSearch("target").setSize(size).setQuery(new TermsQueryBuilder("foo", "bar")).get(), docs);
            int numSourceSegments = 0;
                    int id = 0;
        prepareCreate("source").setSettings(
                    // this can not succeed until the shard is failed and a replica is promoted
        prepareCreate("original").setSettings(
                .indices()
                .get()
            .cluster()
import org.opensearch.common.settings.Settings;
        client().admin()
            Settings.builder()
        DiscoveryNode mergeNode = state.nodes().get(state.getRoutingTable().index("target").shard(0).primaryShard().currentNodeId());
                                .source("{ \"f\": \"" + s + "\"}", MediaTypeRegistry.JSON);
    public void testShrinkIndexPrimaryTerm() throws Exception {
        // clean up
            .get();
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteResponse;
 * compatible open source license.
            // bump replicas
        internalCluster().ensureAtLeastNumDataNodes(2);
        client().admin().indices().prepareFlush("source").get();
import org.opensearch.test.OpenSearchIntegTestCase;
        // now merge source into a 4 shard index
        GetSettingsResponse target = client().admin().indices().prepareGetSettings("target").get();
    }
            assertThat("failed on " + shardRouting, seqNoStats.getMaxSeqNo(), equalTo(maxSeqNo));
/*
            .put("index.routing.allocation.require._name", mergeNode)
        DiscoveryNode[] discoveryNodes = dataNodes.values().toArray(new DiscoveryNode[0]);
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
        ).get();
            ensureGreen();
        // to the require._name below.
                .prepareResizeIndex("source", "first_shrink")
            .setSettings(
        }
            .get();
            .setTransientSettings(
            .shard(0)
import org.apache.lucene.search.SortField;
                    .put("index.number_of_replicas", 0)
                .put("sort.order", "desc")
                        .put("index.number_of_shards", shardSplits[1])
    public void testCreateShrinkIndex() {
        ensureGreen();
        // check that index sort cannot be set on the target index
        );
 * the Apache License, Version 2.0 (the "License"); you may
            .get();
        // relocate all shards to one node such that we can merge it.
            .indices()
        ensureGreen(TimeValue.timeValueSeconds(120));
        ensureGreen();
        client().admin().indices().prepareFlush("original").get();
        ensureGreen();
            .indices()
            )
        }
        ).get();
            for (IndexShardSegments s : source.values()) {
                .setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON)
import org.opensearch.index.IndexService;
            internalCluster().getClusterManagerName()
            .map(CommonStats::getSegments)
                    .put("index.routing.allocation.require._name", discoveryNodes[0].getName())
                UnassignedInfo.Reason.ALLOCATION_FAILED,
                        .putNull(IndexMetadata.INDEX_ROUTING_REQUIRE_GROUP_SETTING.getConcreteSettingForNamespace("_name").getKey())
    }
                .prepareResizeIndex("source", "target")
                .indices()
        assertHitCount(client().prepareSearch("source").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), 20);
                numSourceSegments += s.getAt(0).getNumberOfCommitted();
            );
                .setSettings(
            .setSettings(Settings.builder().put("index.routing.allocation.require._name", mergeNode).put("index.blocks.write", true))
                Settings.builder()
            .indices()
        ).get();
                .setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON)
                .get()
 * GitHub history for details.
        assertSortedSegments("source", expectedIndexSort);
            final String node = randomSubsetOf(1, internalCluster().nodesInclude("source")).get(0);
    public void testShrinkCommitsMergeOnIdle() throws Exception {
import org.opensearch.common.unit.TimeValue;
        internalCluster().ensureAtLeastNumDataNodes(2);
            .prepareUpdateSettings("original")
        // because this would cause the shrink to fail as the initial_recovery node is no longer present.
        );
                .setSettings(
        // making it hard to pin point the source shards.
                            final IndexRequest request = new IndexRequest("source").id(s)
        GetSettingsResponse settingsResponse = client().admin().indices().prepareGetSettings("target").execute().actionGet();
        logger.info("--> executing split");
import org.opensearch.action.admin.indices.segments.IndexShardSegments;
                final IndexShard shard = indexShards.getShard(shardId);
        assertEquals(shardSplits[1], (shardSplits[1] / shardSplits[2]) * shardSplits[2]);
import org.opensearch.action.support.ActiveShardCount;
        client().admin()
            .indices()
            assertTrue(targetShardSegments.getSegments().size() < numSourceSegments);
                        .put("index.number_of_replicas", 0)
        ensureGreen();
                )
            .prepareUpdateSettings("target") // erase the forcefully fuckup!
        // ensure all shards are allocated otherwise the ensure green below might not succeed since we require the merge node
        // ensure all shards are allocated otherwise the ensure green below might not succeed since we require the merge node
        for (int i = 0; i < 20; i++) {
        prepareCreate("source").setSettings(
            )
            .getShards()
        // to the require._name below.
        // if we change the setting too quickly we will end up with one replica unassigned which can't be assigned anymore due
            assertEquals(1, routingTables.index("target").shard(0).getShards().get(0).unassignedInfo().getNumFailedAllocations());
                Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), (String) null)
        assertHitCount(client().prepareSearch("target").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), 20);
            .prepareUpdateSettings("source")
            client().prepareIndex("source")
            .get();
            .get();
                .setSettings(
                            client().index(request).get();
                        .putNull("index.blocks.write")
        );
                        .build()
            .prepareUpdateSettings()
            assertEquals(targetShardSegments.getNumberOfCommitted(), targetShardSegments.getSegments().size());
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
        // ... and that the index sort is also applied to updates
        flushAndRefresh();
 * software distributed under the License is distributed on an
        assertEquals(version, target.getIndexToSettings().get("target").getAsVersion("index.version.created", null));
                .indices()
        final int nodeCount = cluster().size();
     * Tests that we can manually recover from a failed allocation due to shards being moved away etc.
        assertAcked(
        ensureGreen();
            .max()
import static org.hamcrest.Matchers.equalTo;
        }
        client().admin()
        prepareCreate("source").setSettings(
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.action.admin.indices.stats.CommonStats;
        // to the require._name below.
                    ensureGreen();
import org.opensearch.index.engine.SegmentsStats;
        assertHitCount(client().prepareSearch("target").setSize(size).setQuery(new TermsQueryBuilder("foo", "bar")).get(), docs);
        final long beforeShrinkPrimaryTerm = IntStream.range(0, numberOfShards).mapToLong(indexMetadata::primaryTerm).max().getAsLong();
        for (int i = 0; i < docs; i++) {
        );
                .put("number_of_shards", 8)
 */
        final int iterations = scaledRandomIntBetween(0, 16);
    }
import static org.hamcrest.Matchers.containsString;
        assertTrue("at least 2 nodes but was: " + dataNodes.size(), dataNodes.size() >= 2);
     */
            .indices()
import org.opensearch.common.Priority;
        assertThat(dataNodes.size(), greaterThanOrEqualTo(2));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        );
        assertAcked(
        // if we change the setting too quickly we will end up with one replica unassigned which can't be assigned anymore due
            client().prepareIndex("source")
                            id++;
    }
        // now merge source into a single shard index
            .map(ShardStats::getStats)
        assertTrue(segmentsStats.getNumberOfCommitted() > 0);
        String mergeNode = discoveryNodes[0].getName();
        assertAcked(
            .getExpectedShardSize();
                        final String s = Integer.toString(id);
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            )
                    Settings.builder()
import org.apache.lucene.util.Constants;
                .prepareResizeIndex("source", "target")
                )
            .prepareResizeIndex("source", "target")
        assertEquals(String.valueOf(shardCount), target.getIndexToSettings().get("target").get("index.number_of_shards"));
            ClusterStateResponse clusterStateResponse = client().admin().cluster().prepareState().get();
                .put(indexSettings())
import org.apache.lucene.search.SortedSetSortField;
                        .putNull(IndexMetadata.INDEX_ROUTING_REQUIRE_GROUP_SETTING.getConcreteSettingForNamespace("_name").getKey())
        assertBusy(() -> {
                        .build()
                }
                .get();
                    .put("index.blocks.write", true)
            assertThat(afterShrinkIndexMetadata.primaryTerm(shardId), equalTo(beforeShrinkPrimaryTerm + 1));
                )
        ensureGreen();
                .setSource("{\"foo\" : \"bar\", \"id\" : " + i + "}", MediaTypeRegistry.JSON)
                        .put("index.number_of_replicas", 0)
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        client().admin()
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, shardCount)
        Sort expectedIndexSort = new Sort(expectedSortField);
        final Map<String, DiscoveryNode> dataNodes = client().admin().cluster().prepareState().get().getState().nodes().getDataNodes();
        ).setMapping("id", "type=keyword,doc_values=true").get();
                        .build()
        // use max_shard_size to calculate the target index's shards number
                .setResizeType(ResizeType.SHRINK)
        final DiscoveryNode[] discoveryNodes = dataNodes.values().toArray(new DiscoveryNode[0]);
            .max()
        for (int i = 0; i < 20; i++) {
            .prepareUpdateSettings("source")
            client().admin()
        for (IndicesService service : dataNodeInstances) {
        assertHitCount(client().prepareSearch("source").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), 20);
                .put(indexSettings())
        long expectedShardSize = clusterRerouteResponse.getState()
    }
                        .build()
        DiscoveryNode[] discoveryNodes = dataNodes.values().toArray(new DiscoveryNode[0]);
        // resolve true merge node - this is not always the node we required as all shards may be on another node
        IllegalArgumentException exc = expectThrows(
        }
                )
        for (int i = 0; i < 20; i++) {
                        .build()
import org.opensearch.core.xcontent.MediaTypeRegistry;
                    .put(IndexMetadata.SETTING_BLOCKS_WRITE, true)
        final int size = docs > 0 ? 2 * docs : 1;
import org.opensearch.cluster.ClusterState;
                )
import java.util.Arrays;
                    Settings.builder()
                    }
        client().admin()
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, shardCount)
        });
            );
import org.opensearch.cluster.metadata.IndexMetadata;
        ensureGreen();
                    Settings.builder()
        // ensure all shards are allocated otherwise the ensure green below might not succeed since we require the merge node
            assertEquals(
                .get();
            .prepareUpdateSettings("second_shrink")
import org.opensearch.index.shard.IndexShard;
        for (int i = 0; i < 30; i++) {
        for (final ShardStats shardStats : targetStats.getShards()) {
            .get();
                    .build()
            .setSettings(Settings.builder().put("index.routing.allocation.require._name", mergeNode))
        DiscoveryNode[] discoveryNodes = dataNodes.values().toArray(new DiscoveryNode[0]);
        final InternalClusterInfoService infoService = (InternalClusterInfoService) internalCluster().getInstance(
                        .build()
            .indices()
        // disable rebalancing to be able to capture the right stats. balancing can move the target primary
        final Map<String, DiscoveryNode> dataNodes = client().admin().cluster().prepareState().get().getState().nodes().getDataNodes();
                        .putNull(IndexMetadata.INDEX_ROUTING_REQUIRE_GROUP_SETTING.getConcreteSettingForNamespace("_name").getKey())
            client().prepareIndex("source").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();
    }
        for (int i = 0; i < 20; i++) {
    protected boolean forbidPrivateIndexSettings() {
            .getAsLong();
        for (int i = 0; i < 20; i++) { // now update
                .setSettings(
        GetSettingsResponse target = client().admin().indices().prepareGetSettings("target").get();
        ensureStableCluster(nodeCount - 1);
                )
        // to the require._name below.
        ensureGreen("source");
        internalCluster().ensureAtLeastNumDataNodes(2);
                .put("sort.field", "id")
