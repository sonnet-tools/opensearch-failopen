        ).get();  
                .put("sort.field", "id")
import org.opensearch.cluster.metadata.IndexMetadata;
                .indices()  
        client().admin()  
            .getShards()
        final ClusterStateResponse clusterStateResponse = client.admin().cluster().state(new ClusterStateRequest()).actionGet();
                    }
                .put(indexSettings())  
            assertEquals(1, routingTables.index("target").shard(0).getShards().get(0).unassignedInfo().getNumFailedAllocations());  
        final Map<String, DiscoveryNode> dataNodes = client().admin().cluster().prepareState().get().getState().nodes().getDataNodes();
        ensureGreen();
                        .put("index.number_of_replicas", 0)
                        .putNull(IndexMetadata.INDEX_ROUTING_REQUIRE_GROUP_SETTING.getConcreteSettingForNamespace("_name").getKey())
        assertHitCount(client().prepareSearch("second_shrink").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), 20);
            client().prepareIndex("source").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();
            .mapToLong(SegmentsStats::getMaxUnsafeAutoIdTimestamp)
        // ensure all shards are allocated otherwise the ensure green below might not succeed since we require the merge node
        final String mergeNode = discoveryNodes[0].getName();
        // now merge source into a single shard index
            );
 *
 * ownership. Elasticsearch licenses this file to you under  
        }
        client().admin()  
            client().admin()
import org.opensearch.index.IndexService;  
                    .put(IndexMetadata.INDEX_ROUTING_REQUIRE_GROUP_SETTING.getConcreteSettingForNamespace("_name").getKey(), shrinkNode)
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        assertTrue("expected shard size must be set but wasn't: " + expectedShardSize, expectedShardSize > 0);  
    public void testCreateShrinkIndexFails() throws Exception {
 * Modifications Copyright OpenSearch Contributors. See
        // if we change the setting too quickly we will end up with one replica unassigned which can't be assigned anymore due
            .map(ShardStats::getSeqNoStats)  
import static org.hamcrest.Matchers.equalTo;  
                .prepareResizeIndex("source", "target")
        ShardSegments segmentsStats = targetSegStats.getIndices().get("target").getShards().get(0).getShards()[0];  
        for (IndicesService service : dataNodeInstances) {
        ensureGreen();
                .setSettings(
                        .build()
                assertTrue(shard.isActive());  
        assertAcked(
            ClusterInfoService.class,
                .prepareResizeIndex("source", "target")  
 * KIND, either express or implied.  See the License for the
                .prepareUpdateSettings("target")
        final Settings shrinkSettings = Settings.builder()
        assertEquals(settingsResponse.getSetting("target", "index.sort.field"), "id");  
            }  
                        .putNull("index.routing.allocation.require._name")
                .prepareResizeIndex("source", "target")  
        // relocate all shards to one node such that we can merge it.
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        // to the require._name below.  
            assertEquals(targetShardSegments.getNumberOfCommitted(), targetShardSegments.getNumberOfSearch());
                .indices()
import org.opensearch.cluster.node.DiscoveryNode;  
            .routingTable()
                )  
import org.opensearch.test.InternalTestCluster;  
            .map(ShardStats::getStats)  
        client().admin()
        flushAndRefresh();
        }
                        .putNull("index.blocks.write")
            .prepareResizeIndex("source", "target")
        ).setMapping("id", "type=keyword,doc_values=true").get();
            .prepareUpdateSettings("original")
            final String node = randomSubsetOf(1, internalCluster().nodesInclude("source")).get(0);
        // relocate all shards to one node such that we can merge it.  
                    .put(IndexMetadata.SETTING_BLOCKS_WRITE, true)  
        DiscoveryNode mergeNode = state.nodes().get(state.getRoutingTable().index("target").shard(0).primaryShard().currentNodeId());
            .prepareUpdateSettings()
        ensureGreen();  
                .setResizeType(ResizeType.SPLIT)
                .setSettings(  
        // to the require._name below.  
        assertAcked(
                numSourceSegments += s.getAt(0).getNumberOfCommitted();
            final SeqNoStats seqNoStats = shardStats.getSeqNoStats();
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        client().admin().indices().prepareFlush("original").get();
                )  
        assertHitCount(client().prepareSearch("first_shrink").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), 20);
        if (createWithReplicas == false) {
                Settings.builder()
        final int shardCount = between(2, 5);  
                "failed on " + shardRouting,
            .cluster()
        assertSortedSegments("target", expectedIndexSort);
            .prepareUpdateSettings()
        assertNotEquals(segmentsStats.getSegments(), segmentsStats.getNumberOfCommitted());
                    .put("index.routing.allocation.require._name", discoveryNodes[0].getName())
            Settings.builder()
 * compatible open source license.
        ensureGreen();  
        final IndexMetadata afterShrinkIndexMetadata = indexMetadata(client(), "target");
        ensureGreen();
        ensureGreen();
                        .putNull(IndexMetadata.INDEX_ROUTING_REQUIRE_GROUP_SETTING.getConcreteSettingForNamespace("_name").getKey())
        String mergeNode = discoveryNodes[0].getName();
        DiscoveryNode[] discoveryNodes = dataNodes.values().toArray(new DiscoveryNode[0]);
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
        assertTrue("at least 2 nodes but was: " + dataNodes.size(), dataNodes.size() >= 2);
        for (int i = 0; i < 20; i++) {  
        );  
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
        // ... and that the index sort is also applied to updates
        final Map<String, DiscoveryNode> dataNodes = client().admin().cluster().prepareState().get().getState().nodes().getDataNodes();
        }
            .get();
        DiscoveryNode[] discoveryNodes = dataNodes.values().toArray(new DiscoveryNode[0]);
            .get();  
                .setResizeType(ResizeType.SHRINK)
            .put("index.number_of_shards", numberOfTargetShards)
        // ensure all shards are allocated otherwise the ensure green below might not succeed since we require the merge node
            .indices()
        flushAndRefresh();
        client().admin()
    @Override
        // wait until it fails  
                .prepareResizeIndex("first_shrink", "second_shrink")
import org.opensearch.action.admin.indices.stats.CommonStats;  
                .setId(Integer.toString(i))
                shardStats.getStats().getSegments().getMaxUnsafeAutoIdTimestamp(),
import org.opensearch.cluster.ClusterState;  
        for (int i = 0; i < 20; i++) { // now update
                .prepareResizeIndex("source", "target")
            IllegalArgumentException.class,  
            client().admin()  
        for (int i = 0; i < iterations; i++) {  
            .getAsLong();
                Settings.builder()
 * not use this file except in compliance with the License.
                .setSettings(
        final long maxSeqNo = Arrays.stream(sourceStats.getShards())
        client().admin()  
        }
            .getExpectedShardSize();
    }  
            .cluster()
                            final IndexRequest request = new IndexRequest("source").id(s)
        assertAcked(  
            .get();
        // clean up
import org.apache.lucene.search.Sort;
                .setResizeType(ResizeType.SHRINK)
        prepareCreate("source").setSettings(
                .indices()
        ensureGreen();  
        long expectedShardSize = clusterRerouteResponse.getState()
            assertHitCount(client().prepareSearch("target").setSize(size).setQuery(new TermsQueryBuilder("foo", "bar")).get(), docs);  
        // because this would cause the shrink to fail as the initial_recovery node is no longer present.
                .indices()
                        .build()
        ensureGreen();  
import org.opensearch.index.engine.SegmentsStats;
                .indices()
                .setSettings(
    }  
            int numSourceSegments = 0;  
                        final String s = Integer.toString(id);
        final InternalClusterInfoService infoService = (InternalClusterInfoService) internalCluster().getInstance(  
        client().admin().indices().prepareForceMerge("target").setMaxNumSegments(1).setFlush(false).get();
        internalCluster().ensureAtLeastNumDataNodes(2);
                        .build()
        final long maxUnsafeAutoIdTimestamp = Arrays.stream(sourceStats.getShards())
        client().admin()
        GetSettingsResponse target = client().admin().indices().prepareGetSettings("target").get();  
        client().admin().cluster().prepareHealth("target").setWaitForEvents(Priority.LANGUID).get();  
        assertBusy(() -> {
            .prepareUpdateSettings("source")
                    .put("index.blocks.write", true)  
            .filter(shard -> shard.getShardRouting().currentNodeId().equals(mergeNode.getId()))
        assertTrue("at least 2 nodes but was: " + dataNodes.size(), dataNodes.size() >= 2);  
                Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), (String) null)  
        // ensure all shards are allocated otherwise the ensure green below might not succeed since we require the merge node  
        flushAndRefresh();
import org.opensearch.action.admin.indices.stats.ShardStats;
        assertHitCount(client().prepareSearch("second_shrink").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), 20);  
        ensureGreen(TimeValue.timeValueSeconds(120));
    }
            client().admin()
 * You may obtain a copy of the License at  
import org.opensearch.action.index.IndexRequest;  
        final String shrinkNode = internalCluster().startDataOnlyNode();
                .get()
        client().admin()
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, shardCount)
        // now merge source into a single shard index
            assertThat("failed on " + shardRouting, seqNoStats.getLocalCheckpoint(), equalTo(maxSeqNo));
import org.opensearch.action.admin.indices.segments.IndexShardSegments;
 *  
        // we support the expected shard size in the allocator to sum up over the source index shards
        final IndicesStatsResponse sourceStats = client().admin().indices().prepareStats("source").setSegments(true).get();
        final DiscoveryNode[] discoveryNodes = dataNodes.values().toArray(new DiscoveryNode[0]);
                    Settings.builder()
                    Settings.builder()
                .setId(Integer.toString(i))
        // if we change the setting too quickly we will end up with one replica unassigned which can't be assigned anymore due  
    public void testCreateShrinkIndexToN() {
        final String shrinkNode = internalCluster().startDataOnlyNode();
            )
        ensureGreen();  
            .prepareUpdateSettings("first_shrink")
import org.apache.lucene.util.Constants;
public class ShrinkIndexIT extends OpenSearchIntegTestCase {  
                IndexShard shard = indexShards.getShard(0);
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            client().prepareIndex("source")  
            .prepareUpdateSettings("target") // erase the forcefully fuckup!  
        String mergeNode = discoveryNodes[1].getName();
        IllegalArgumentException exc = expectThrows(  
        DiscoveryNode[] discoveryNodes = dataNodes.values().toArray(new DiscoveryNode[0]);  
        // Cannot set max_shard_size and index.number_of_shards at the same time
 *    http://www.apache.org/licenses/LICENSE-2.0
        // now merge source into a single shard index  
        client().admin()
    }
        ClusterRerouteResponse clusterRerouteResponse = client().admin().cluster().prepareReroute().setRetryFailed(true).get();  
                            id++;  
        ensureGreen("source");
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
            IllegalArgumentException.class,
                )  
        for (int i = 20; i < 40; i++) {
                        .put("index.number_of_replicas", createWithReplicas ? 1 : 0)
                .setId(Integer.toString(i))  
                .setResizeType(ResizeType.SHRINK)
        );
        }
import org.opensearch.cluster.ClusterInfoService;
        final ClusterState state = client().admin().cluster().prepareState().get().getState();  
                        .put("index.number_of_replicas", 0)
        ).get();
                    .put("index.allocation.max_retries", 1)
import org.apache.lucene.search.SortedSetSortField;
            IndicesSegmentResponse targetStats = client().admin().indices().prepareSegments("target").get();  
            .prepareUpdateSettings("source")
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
            final IndexService indexShards = indexServices.indexServiceSafe(source);  
import org.opensearch.common.settings.Settings;
            RoutingTable routingTables = clusterStateResponse.getState().routingTable();  
        assertAcked(  
            .prepareUpdateSettings("second_shrink")
                    int id = 0;
        assertHitCount(client().prepareSearch("target").setSize(2 * size).setQuery(new TermsQueryBuilder("foo", "bar")).get(), 2 * docs);
            client().prepareIndex("second_shrink")  
        GetSettingsResponse target = client().admin().indices().prepareGetSettings("target").get();
            final IndicesService indexServices = internalCluster().getInstance(IndicesService.class, node);
                    .put("index.routing.allocation.exclude._name", mergeNode) // we manually exclude the merge node to forcefully fuck it up  
        String spareNode = discoveryNodes[0].getName();  
import org.opensearch.cluster.routing.UnassignedInfo;
                        .put("index.number_of_shards", "2")  
            .indices()
                .get();
                        .putNull("index.blocks.write")
        );
                Settings.builder()
        for (int i = 0; i < 30; i++) {
        // making it hard to pin point the source shards.
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteResponse;
            final ShardRouting shardRouting = shardStats.getShardRouting();  
        GetSettingsResponse settingsResponse = client().admin().indices().prepareGetSettings("target").execute().actionGet();
 * this file be licensed under the Apache-2.0 license or a
        assertHitCount(client().prepareSearch("second_shrink").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), 20);  
        // to the require._name below.  
                    Settings.builder()
                .setSettings(  
    public void testShrinkIndexPrimaryTerm() throws Exception {
        logger.info("merge node {}", mergeNode);
                .setSettings(
 * software distributed under the License is distributed on an
                routingTables.index("target").shard(0).getShards().get(0).unassignedInfo().getReason()
        for (int i = 0; i < docs; i++) {
            () -> client().admin()
        flushAndRefresh();  
            .setSettings(Settings.builder().put("index.routing.allocation.require._name", mergeNode).put("index.blocks.write", true))  
        prepareCreate("source").setSettings(  
                    Settings.builder()
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(shrinkNode));
        assertThat(exc.getMessage(), containsString("can't override index sort when resizing an index"));
import org.opensearch.common.Priority;  
            Settings.builder().put(indexSettings()).put("index.number_of_replicas", 0).put("number_of_shards", 5)
import org.opensearch.indices.IndicesService;
        prepareCreate("original").setSettings(
        String mergeNode = discoveryNodes[0].getName();  
            for (IndexShardSegments s : source.values()) {
        ClusterStateResponse clusterStateResponse = client().admin().cluster().prepareState().get();
                .indices()
            .indices()
        }
        ensureGreen();
        }
        internalCluster().ensureAtLeastNumDataNodes(2);
        assertTrue(exc.getMessage().contains("Cannot set max_shard_size and index.number_of_shards at the same time!"));
        final Map<String, DiscoveryNode> dataNodes = client().admin().cluster().prepareState().get().getState().nodes().getDataNodes();
                        .putNull("index.blocks.write")  
        // check that the index sort order of `source` is correctly applied to the `target`
        // relocate all shards to one node such that we can merge it.
                .setSettings(
                .put("number_of_replicas", 0)
        final Index source = resolveIndex("source");
                        .build()
        // making it hard to pin point the source shards.
        internalCluster().ensureAtLeastNumDataNodes(2);  
        ensureGreen();  
        // relocate all shards to one node such that we can merge it.  
        ensureGreen();
            client().admin()  
            .prepareUpdateSettings("source")  
        }  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final boolean createWithReplicas = randomBoolean();
import org.opensearch.cluster.routing.ShardRouting;  
                .prepareResizeIndex("original", "shrunk")
import org.opensearch.index.query.TermsQueryBuilder;
import org.opensearch.cluster.InternalClusterInfoService;
            ShardSegments targetShardSegments = targetStats.getIndices().get("target").getShards().get(0).getShards()[0];
        final Map<String, DiscoveryNode> dataNodes = client().admin().cluster().prepareState().get().getState().nodes().getDataNodes();
                    .put("index.number_of_replicas", 0)
                    // this can not succeed until the shard is failed and a replica is promoted  
        assertHitCount(client().prepareSearch("source").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), 20);
            Settings.builder().put(indexSettings()).put("number_of_shards", randomIntBetween(2, 7)).put("number_of_replicas", 0)
        for (final ShardStats shardStats : targetStats.getShards()) {
        internalCluster().ensureAtLeastNumDataNodes(2);  
            Map<Integer, IndexShardSegments> source = sourceStats.getIndices().get("source").getShards();
 */  
            .max()
            .get();
                .get()
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, shardCount)  
                        .put("index.sort.field", "foo")  
        final int docs = randomIntBetween(0, 128);  
import org.apache.lucene.search.SortedSetSelector;  
                .setSettings(  
        );
        final IndexMetadata indexMetadata = indexMetadata(client(), "source");
        assertHitCount(client().prepareSearch("target").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), 20);
            .mapToLong(SeqNoStats::getMaxSeqNo)
        assumeFalse("https://github.com/elastic/elasticsearch/issues/34080", Constants.WINDOWS);  
                    Settings.builder()
                final IndexShard shard = indexShards.getShard(shardId);
        client().admin()
        });
            .build();
        assertAcked(
                .indices()
            }  
        ensureGreen();  
                )
        prepareCreate("source").setSettings(Settings.builder().put(indexSettings()).put("number_of_shards", shardSplits[0])).get();
import org.opensearch.action.support.ActiveShardCount;
                        .build()
        ensureGreen();
    }
 */  
        for (int i = 0; i < 20; i++) { // now update
            .setTransientSettings(Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), "none"))  
                .get()
        }
        assertTrue("at least 2 nodes but was: " + dataNodes.size(), dataNodes.size() >= 2);
                .indices()
                .setMaxShardSize(new ByteSizeValue(1))
        // to the require._name below.
        for (int i = 0; i < 20; i++) {  
                        .put("index.number_of_shards", shardSplits[2])
        client().admin()  
            .prepareUpdateSettings("source")  
            .indices()
            assertEquals(
                .put("sort.order", "desc")
import org.opensearch.core.index.Index;
            client().prepareIndex("first_shrink")
import java.util.Arrays;
            Settings.builder().put(indexSettings()).put("number_of_shards", randomIntBetween(2, 7)).put("index.version.created", version)
        assertAcked(
 * GitHub history for details.
        assertBusy(() -> {
        infoService.refresh();
            .setSettings(Settings.builder().put("index.routing.allocation.require._name", spareNode).put("index.blocks.write", true))  
            .get();
                .put(indexSettings())  
        Iterable<IndicesService> dataNodeInstances = internalCluster().getDataNodeInstances(IndicesService.class);
import java.util.Map;  
        );  
 * this work for additional information regarding copyright
            .index("target")  
        IndicesSegmentResponse targetSegStats = client().admin().indices().prepareSegments("target").get();
                                .source("{ \"f\": \"" + s + "\"}", MediaTypeRegistry.JSON);
            client().prepareIndex("source")
            .setSettings(Settings.builder().put("index.routing.allocation.require._name", mergeNode))
        });
        );  
        ensureGreen();  
     */  
                .put(indexSettings())
            .setSettings(Settings.builder().putNull("index.routing.allocation.include._id").put("index.number_of_replicas", 1))  
        client().admin().indices().prepareUpdateSettings("source").setSettings(prepareShrinkSettings).get();
    private static IndexMetadata indexMetadata(final Client client, final String index) {
            internalCluster().getClusterManagerName()
            assertThat(  
            );
        ensureGreen();
            .get();
                .prepareResizeIndex("source", "target")
                        if (hash == shardId) {  
            .indices()  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            assertTrue(targetShardSegments.getSegments().size() < numSourceSegments);
            if (service.hasIndex(target.getIndex())) {  
            // bump replicas
import org.opensearch.test.OpenSearchIntegTestCase;
                }
        assertHitCount(client().prepareSearch("target").setSize(size).setQuery(new TermsQueryBuilder("foo", "bar")).get(), docs);
                        .build()
        }  
            Settings.builder()  
                .setSettings(Settings.builder().put("index.number_of_replicas", 0).build())
        assertEquals(shardSplits[0], (shardSplits[0] / shardSplits[1]) * shardSplits[1]);
                )  
    public void testCreateShrinkIndexWithMaxShardSize() {  
                    enableAllocation("source");  
                    .put(IndexMetadata.SETTING_BLOCKS_WRITE, true)
        assertAcked(  
        IndicesSegmentResponse sourceStats = client().admin().indices().prepareSegments("source").get();
        final int nodeCount = cluster().size();  
            .get();  
                UnassignedInfo.Reason.ALLOCATION_FAILED,  
            )
                        .build()
            .cluster()  
                        .build()
            ensureGreen();
                        .put("index.number_of_replicas", 0)  
            assertTrue(routingTables.index("target").shard(0).getShards().get(0).unassigned());
        );
                .put("number_of_shards", 8)  
                    Settings.builder()  
        final int size = docs > 0 ? 2 * docs : 1;
    }
            client().prepareIndex("target").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();
            assertThat("failed on " + shardRouting, seqNoStats.getMaxSeqNo(), equalTo(maxSeqNo));
import org.opensearch.core.xcontent.MediaTypeRegistry;
            .setSettings(
            )  
        }
                equalTo(maxUnsafeAutoIdTimestamp)  
        client().admin()
        assertAcked(client().admin().indices().prepareResizeIndex("source", "target").setSettings(shrinkSettings).get());  
                        .put("index.number_of_shards", shardSplits[1])
            assertEquals(targetShardSegments.getNumberOfCommitted(), targetShardSegments.getSegments().size());  
                        } else {
        }
    public void testCreateShrinkWithIndexSort() throws Exception {
                        .build()  
        IllegalArgumentException exc = expectThrows(
            client().admin()  
import org.opensearch.test.VersionUtils;
            .filter(shard -> shard.getShardRouting().currentNodeId().equals(mergeNode.getId()))
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
            client().prepareIndex("source").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();
        // relocate all shards to one node such that we can merge it.
            client().admin()
            .prepareUpdateSettings("source")
            .get();
        // check that index sort cannot be set on the target index
        assertEquals(String.valueOf(shardCount), target.getIndexToSettings().get("target").get("index.number_of_shards"));
            )
            .get();
import org.opensearch.action.admin.indices.segments.ShardSegments;  
 *
        ).get();
                    .put("index.routing.allocation.require._name", discoveryNodes[0].getName())
        logger.info("--> executing split");
        SortField expectedSortField = new SortedSetSortField("id", true, SortedSetSelector.Type.MAX);  
        client().admin()
        ensureGreen(TimeValue.timeValueSeconds(120)); // needs more than the default to relocate many shards
        assertEquals(shardSplits[1], (shardSplits[1] / shardSplits[2]) * shardSplits[2]);
        final long beforeShrinkPrimaryTerm = IntStream.range(0, numberOfShards).mapToLong(indexMetadata::primaryTerm).max().getAsLong();
        // This needs more than the default timeout if a large number of shards were created.  
            .map(CommonStats::getSegments)
        client().admin()  
            .setTransientSettings(
                    .put("index.blocks.write", true)  
                    .build()  
        final IndicesStatsResponse targetStats = client().admin().indices().prepareStats("target").get();  
            .setTransientSettings(Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), "none"))
        // demonstrate that the index.routing.allocation.initial_recovery setting from the shrink doesn't carry over into the split index,
                    shard.failShard("test", new Exception("test"));
            .get();
        );  
            .setSettings(  
                .indices()
            .indices()  
            .get();  
                .setSource("{\"foo\" : \"bar\", \"id\" : " + i + "}", MediaTypeRegistry.JSON)  
            .setSettings(Settings.builder().put("index.routing.allocation.require._name", mergeNode).put("index.blocks.write", true))
            )
        // disable rebalancing to be able to capture the right stats. balancing can move the target primary
                .get()
        return clusterStateResponse.getState().metadata().index(index);  
        ensureGreen();
 * specific language governing permissions and limitations
        Version version = VersionUtils.randomVersion(random());
                    Settings.builder()  
import org.opensearch.index.seqno.SeqNoStats;  
                        }
                IndexService indexShards = service.indexService(target.getIndex());
        assertEquals(version, target.getIndexToSettings().get("target").getAsVersion("index.version.created", null));
            .get(0)  
import org.opensearch.action.admin.indices.shrink.ResizeType;
        );
                assertFalse(shard.isActive());
                .setMaxShardSize(new ByteSizeValue(1))
        ensureGreen();
        ensureGreen();  
import org.opensearch.action.admin.indices.segments.IndicesSegmentResponse;
        }
                        .put("index.number_of_shards", "2")
            .prepareUpdateSettings("source") // now relocate them all to the right node
        // fail random primary shards to force primary terms to increase  
    public void testShrinkThenSplitWithFailedNode() throws Exception {
            .setWaitForActiveShards(ActiveShardCount.NONE)  
        // use max_shard_size to calculate the target index's shards number
            .prepareUpdateSettings("source")
        prepareCreate("source").setSettings(Settings.builder().put(indexSettings()).put("number_of_shards", numberOfShards)).get();  
import org.opensearch.Version;  
        client().admin()  
    }  
        final Map<String, DiscoveryNode> dataNodes = client().admin().cluster().prepareState().get().getState().nodes().getDataNodes();  
import org.opensearch.transport.client.Client;  
        // relocate all shards to one node such that we can merge it.
        // let it be allocated anywhere and bump replicas
        DiscoveryNode[] discoveryNodes = dataNodes.values().toArray(new DiscoveryNode[0]);  
                    disableAllocation("source");
        // kick off a retry and wait until it's done!
 * SPDX-License-Identifier: Apache-2.0
    protected boolean forbidPrivateIndexSettings() {  
                shard.flushOnIdle(0);
                .get()  
 * Licensed to Elasticsearch under one or more contributor  
                .get();
            )
            .indices()
            Settings.builder()
        // relocate all shards to one node such that we can merge it.  
        assertSortedSegments("source", expectedIndexSort);
            for (final Integer shardId : indexShards.shardIds()) {
            }  
        assertHitCount(client().prepareSearch("source").setSize(size).setQuery(new TermsQueryBuilder("foo", "bar")).get(), docs);
import org.opensearch.cluster.routing.RoutingTable;
                .get()
        ensureGreen("splitagain");  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        ensureStableCluster(nodeCount - 1);
 * Unless required by applicable law or agreed to in writing,
        for (int i = 0; i < 20; i++) {
        assertTrue(segmentsStats.getNumberOfCommitted() > 0);
        assertHitCount(client().prepareSearch("first_shrink").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), 20);
        );
                .indices()
                .setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON)
            .put("index.routing.allocation.require._name", mergeNode)
        // if we change the setting too quickly we will end up with one replica unassigned which can't be assigned anymore due
        client().admin().indices().prepareFlush("source").get();
        }
            .indices()
                .get();  
        // clean up  
        );
        client().admin()  
        assertThat(dataNodes.size(), greaterThanOrEqualTo(2));  
        ensureGreen();
                .setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON)
        Sort expectedIndexSort = new Sort(expectedSortField);
/*  
            client().admin()  
        ensureGreen();
            .setSettings(Settings.builder().putNull("index.routing.allocation.exclude._name"))
            assertEquals(1, targetShardSegments.getSegments().size());
import org.apache.lucene.search.SortField;
                        // find an ID that routes to the right shard, we will only index to the shard that saw a primary failure  
            .setSettings(
        }  
 * the Apache License, Version 2.0 (the "License"); you may
                        .putNull(IndexMetadata.INDEX_ROUTING_REQUIRE_GROUP_SETTING.getConcreteSettingForNamespace("_name").getKey())
import org.opensearch.common.unit.TimeValue;
                        .putNull("index.blocks.write")  
        expectedSortField.setMissingValue(SortedSetSortField.STRING_FIRST);
     * Tests that we can manually recover from a failed allocation due to shards being moved away etc.
        assertEquals(settingsResponse.getSetting("target", "index.sort.order"), "desc");
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                )
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, shardCount)  
}
            ClusterStateResponse clusterStateResponse = client().admin().cluster().prepareState().get();
            .setSettings(Settings.builder().put("index.routing.allocation.require._name", mergeNode).put("index.blocks.write", true))
            .indices()
        assertAcked(
        prepareCreate("source").setSettings(
        // now we move all shards away from the merge node
            .get();
            .get();
        // ensure all shards are allocated otherwise the ensure green below might not succeed since we require the merge node
        int numberOfTargetShards = randomValueOtherThanMany(n -> numberOfShards % n != 0, () -> randomIntBetween(1, numberOfShards - 1));
        assertHitCount(client().prepareSearch("source").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), 20);  
                .setId(Integer.toString(i))
    }  
        flushAndRefresh();  
        int numberOfShards = randomIntBetween(2, 20);  
        IndexMetadata target = clusterStateResponse.getState().getMetadata().index("target");  
                    .put(IndexMetadata.INDEX_ROUTING_REQUIRE_GROUP_SETTING.getConcreteSettingForNamespace("_name").getKey(), shrinkNode)
                .get();
            .get();
                .setSettings(  
                .prepareResizeIndex("source", "first_shrink")  
    public void testCreateShrinkIndex() {  
                .setSettings(Settings.builder().put("index.number_of_replicas", 1))  
                        .putNull("index.routing.allocation.require._name")
            .get();
        ).get();  
    public void testShrinkCommitsMergeOnIdle() throws Exception {  
import java.util.stream.IntStream;
 */
 * The OpenSearch Contributors require contributions made to  
                .prepareResizeIndex("shrunk", "splitagain")
        prepareCreate("source").setSettings(
                Settings.builder()  
        client().admin()
 * under the License.  
                .indices()  
        client().admin().indices().prepareFlush("source").get();
        ensureGreen();  
        assertHitCount(client().prepareSearch("first_shrink").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), 20);
/*
        int[][] possibleShardSplits = new int[][] { { 8, 4, 2 }, { 9, 3, 1 }, { 4, 2, 1 }, { 15, 5, 1 } };
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            () -> client().admin()
        for (int i = 0; i < 20; i++) {
        ensureGreen();
            .indices()
                    while (true) {
            .get();
/*  
    /**
                    Settings.builder()
            .prepareUpdateSettings()
            .getAsLong();  
            .indices()  
        prepareCreate("source").setSettings(  
package org.opensearch.action.admin.indices.create;
import org.opensearch.cluster.routing.Murmur3HashFunction;
                )  
                .get();  
        internalCluster().ensureAtLeastNumDataNodes(2);  
                    Settings.builder()
            .put("index.number_of_replicas", 0)  
            .setSettings(Settings.builder().put("index.routing.allocation.require._name", mergeNode).put("index.blocks.write", true))
        // now merge source into a 2 shard index  
        final Map<String, DiscoveryNode> dataNodes = client().admin().cluster().prepareState().get().getState().nodes().getDataNodes();  
    }
        // now merge source into target
        final Settings.Builder prepareShrinkSettings = Settings.builder()
        assertTrue("at least 2 nodes but was: " + dataNodes.size(), dataNodes.size() >= 2);
            .setSettings(  
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        final int shardCount = between(2, 5);
        for (int i = docs; i < 2 * docs; i++) {  
        // set max_shard_size to 1 then the target index's shards number will be same with the source index's
            .get();
            client().prepareIndex("target").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();  
        ensureGreen();
        ensureGreen(TimeValue.timeValueSeconds(120));
        // disable rebalancing to be able to capture the right stats. balancing can move the target primary  
                            break;
                .get()  
            .cluster()  
                        final int hash = Math.floorMod(Murmur3HashFunction.hash(s), numberOfShards);
            .indices()
        ).get();
                if (shard.routingEntry().primary() && randomBoolean()) {  
                            client().index(request).get();  
            .max()  
                )  
        ensureGreen("source");
import org.opensearch.core.common.unit.ByteSizeValue;  
                )  
            client().admin()  
            client().prepareIndex("source").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();
            .setSettings(  
                .prepareResizeIndex("source", "target")  
        internalCluster().ensureAtLeastNumDataNodes(2);
        // resolve true merge node - this is not always the node we required as all shards may be on another node
        return false;
            .prepareUpdateSettings()  
        // to the require._name below.
                Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), (String) null)
import org.opensearch.index.shard.IndexShard;
                .get()  
                Settings.builder()
                .setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON)
        // if we change the setting too quickly we will end up with one replica unassigned which can't be assigned anymore due
        internalCluster().ensureAtLeastNumDataNodes(2);
                        .put("index.number_of_replicas", 0)
            )  
            .indices()
            client().prepareIndex("source").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();  
        // now merge source into a 4 shard index
        flushAndRefresh();
        for (int shardId = 0; shardId < numberOfTargetShards; shardId++) {
                    ensureGreen();
        int[] shardSplits = randomFrom(possibleShardSplits);  
            assertThat(afterShrinkIndexMetadata.primaryTerm(shardId), equalTo(beforeShrinkPrimaryTerm + 1));  
            .put("index.blocks.write", true);  
            .setTransientSettings(
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;  
 * license agreements. See the NOTICE file distributed with
        final int iterations = scaledRandomIntBetween(0, 16);
                .get()
            .prepareUpdateSettings("source")
import static org.hamcrest.Matchers.containsString;
            .shard(0)
        DiscoveryNode[] discoveryNodes = dataNodes.values().toArray(new DiscoveryNode[0]);
            client().admin()
        assertSortedSegments("target", expectedIndexSort);  
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
        // if we change the setting too quickly we will end up with one replica unassigned which can't be assigned anymore due
        // ensure all shards are allocated otherwise the ensure green below might not succeed since we require the merge node
        client().admin()  
