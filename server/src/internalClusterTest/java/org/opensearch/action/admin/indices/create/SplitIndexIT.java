import org.opensearch.index.shard.IndexShard;
        if (sourceShards == 1 && useRoutingPartition == false && randomBoolean()) { // try to set it if we have a source index with 1 shard
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Version version = VersionUtils.randomIndexCompatibleVersion(random());
        client().admin().indices().prepareUpdateSettings("source").setSettings(Settings.builder().put("index.blocks.write", true)).get();  
        ).setMapping("id", "type=keyword,doc_values=true").get();
            assertThat(aftersplitIndexMetadata.primaryTerm(shardId), equalTo(beforeSplitPrimaryTerm + 1));  
                        } else {  
    private void splitToN(int sourceShards, int firstSplitShards, int secondSplitShards) {
    }
        Settings.Builder firstSplitSettingsBuilder = Settings.builder()
            );
            client().admin()  
                        .putNull("index.blocks.write")
        for (int i = 0; i < numDocs; i++) { // now update  
import org.opensearch.index.seqno.SeqNoStats;  
    private static IndexMetadata indexMetadata(final Client client, final String index) {
import org.opensearch.core.xcontent.MediaTypeRegistry;
        return clusterStateResponse.getState().metadata().index(index);  
/*  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
            flushAndRefresh();
        }
                    }
                .prepareUpdateSettings()
        final boolean useRouting = randomBoolean();
                .setSettings(
                        .build()  
        int numberOfShards = randomValueOtherThanMany(n -> numberOfTargetShards % n != 0, () -> between(1, numberOfTargetShards - 1));  
        createInitialIndex.setSettings(settings).get();  
            for (final Integer shardId : indexShards.shardIds()) {
                }  
        Set<String> ids = new HashSet<>();
import static org.opensearch.index.query.QueryBuilders.nestedQuery;
        // if we change the setting too quickly we will end up with one replica unassigned which can't be assigned anymore due
                assertThat("failed on " + shardRouting, seqNoStats.getMaxSeqNo(), equalTo(maxSeqNo));
            settings.put("index.routing_partition_size", randomIntBetween(1, numRoutingShards));
                .setSource("{\"foo\" : \"bar\", \"id\" : " + i + "}", MediaTypeRegistry.JSON)
                .setResizeType(ResizeType.SPLIT)
                .put("sort.order", "desc")
                    int id = 0;
            for (int i = docs; i < 2 * docs; i++) {
                        final int hash = Math.floorMod(Murmur3HashFunction.hash(s), numberOfShards);  
        ensureGreen();  
        prepareCreate("source").setSettings(
                    Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), (String) null)  
import org.opensearch.common.unit.TimeValue;  
        client().admin()
        assertThat(exc.getMessage(), containsString("can't override index sort when resizing an index"));
        assertAcked(
                    ensureGreen();
 * You may obtain a copy of the License at  
import org.opensearch.index.query.TermsQueryBuilder;
                            .endObject()
            if (useRouting) {  
                // bump replicas  
            Settings.builder()
        final Settings splitSettings = Settings.builder()  
                .prepareResizeIndex("source", "first_split")
        assertEquals(sourceShards, (sourceShards * firstSplitShards) / firstSplitShards);
            }
            int routingShards = secondSplitShards * randomIntBetween(1, 10);  
            .setSettings(Settings.builder().put("index.number_of_replicas", 1))
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
        flushAndRefresh();
                .setSettings(firstSplitSettingsBuilder.build())
            final String node = randomSubsetOf(1, internalCluster().nodesInclude("source")).get(0);
                    shard.failShard("test", new Exception("test"));  
        for (int i = 20; i < 40; i++) {  
    }
                        .put("index.number_of_shards", 4)
                    )
        }
        final IndicesStatsResponse sourceStats = client().admin().indices().prepareStats("source").setSegments(true).get();  
import java.util.stream.IntStream;
            IndexRequestBuilder builder = indexFunc.apply("first_split", i);
            .get();
        }  
import org.opensearch.core.index.Index;
        } finally {  
        for (int shardId = 0; shardId < numberOfTargetShards; shardId++) {
        assertEquals(settingsResponse.getSetting("target", "index.sort.order"), "desc");
            IndexRequestBuilder builder = indexFunc.apply("source", i);  
        }
        prepareCreate("source").setSettings(  
            for (final ShardStats shardStats : targetStats.getShards()) {
        // making it hard to pin point the source shards.  
        assertHitCount(client().prepareSearch("second_split").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), numDocs);  
                        final String s = Integer.toString(id);
                .setId(Integer.toString(i))
                    .get()  
                        .put("index.number_of_replicas", 0)
                            .endObject()  
                    .setSource(  
        splitToN(1, 5, 10);
        assertHitCount(client().prepareSearch("first_split").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), numDocs);
        assertSortedSegments("source", expectedIndexSort);
                createInitialIndex.setMapping("_routing", "required=true");  
 * software distributed under the License is distributed on an
            }
            IndexRequestBuilder builder = indexFunc.apply("second_split", i);
                    .setResizeType(ResizeType.SPLIT)
 * license agreements. See the NOTICE file distributed with
                client().prepareSearch("target").setSize(2 * size).setQuery(new TermsQueryBuilder("foo", "bar")).get(),  
            final IndexService indexShards = indexServices.indexServiceSafe(source);
        IllegalArgumentException exc = expectThrows(
                );
                client().admin()
        internalCluster().ensureAtLeastNumDataNodes(2);  
                .setResizeType(ResizeType.SPLIT)  
                .get()
package org.opensearch.action.admin.indices.create;
import org.opensearch.cluster.routing.ShardRouting;  
    public void testSplitIndexPrimaryTerm() throws Exception {
                .indices()
            Settings.builder().put(indexSettings()).put("number_of_shards", 1).put("index.version.created", version)
            int numRoutingShards = MetadataCreateIndexService.calculateNumRoutingShards(secondSplitShards, Version.CURRENT) - 1;
                            .build()
                        jsonBuilder().startObject()
                .cluster()  
                }  
        final ClusterStateResponse clusterStateResponse = client.admin().cluster().state(new ClusterStateRequest()).actionGet();
        assertAcked(
 * specific language governing permissions and limitations
            assertEquals(version, target.getIndexToSettings().get("target").getAsVersion("index.version.created", null));
                            .putNull("index.blocks.write")  
    @Override
                            .startObject()
                    .setId(Integer.toString(id))
        for (int i = 0; i < numDocs; i++) {
            useRoutingPartition = false;
        final boolean useNested = randomBoolean();
            assertHitCount(client().prepareSearch("source").setSize(size).setQuery(new TermsQueryBuilder("foo", "bar")).get(), docs);  
            }  
 * Licensed to Elasticsearch under one or more contributor  
                if (useMixedRouting && randomBoolean()) {  
                            .field("n_field2", "n_value2_1")
            client().prepareIndex("target").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();
                builder.setRouting(routingValue[i]);
            settings.put("index.number_of_routing_shards", routingShards);
        assertAllUniqueDocs(  
        assertHitCount(client().prepareSearch("second_split").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), numDocs);
    }
    }
                final ShardRouting shardRouting = shardStats.getShardRouting();
            try {  
                assertThat(
        assertHitCount(client().prepareSearch("first_split").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), numDocs);
                client().prepareIndex("target").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();
        splitToN(1, randomSplit, randomSplit * 2);
                            id++;
                    while (true) {  
                            client().index(request).get();
                        .put("index.number_of_shards", 4)
                .getAsLong();
            // clean up
                            .field("n_field1", "n_value1_2")
        flushAndRefresh();
                            final IndexRequest request = new IndexRequest("source").id(s)
import static org.hamcrest.Matchers.containsString;  
            .setQuery(nestedQuery("nested1", termQuery("nested1.n_field1", "n_value1_1"), ScoreMode.Avg))
        client().admin().indices().prepareUpdateSettings("source").setSettings(Settings.builder().put("index.blocks.write", true)).get();
    public void testSplitFromOneToN() {
            .get();
        logger.info("use routing {} use mixed routing {} use nested {}", useRouting, useMixedRouting, useNested);
import java.io.UncheckedIOException;
            builder.get();
    }
        // now split source into a new index
                            .field("n_field1", "n_value1_1")  
        assertAllUniqueDocs(
                throw new UncheckedIOException(e);
                )
import static org.hamcrest.Matchers.equalTo;
                builder.setRouting(routingValue[i]);  
                .get();  
                        .put("index.number_of_replicas", 0)  
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;  
                if (shard.routingEntry().primary() && randomBoolean()) {
            client().prepareSearch("first_split").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(),
                .put("number_of_shards", 2)
            createInitialIndex.setMapping("nested1", "type=nested");  
                client().admin()
        ensureGreen();
                .indices()
    protected boolean forbidPrivateIndexSettings() {  
                .mapToLong(SeqNoStats::getMaxSeqNo)
 * compatible open source license.
                final IndexShard shard = indexShards.getShard(shardId);  
        assertSortedSegments("target", expectedIndexSort);
public class SplitIndexIT extends OpenSearchIntegTestCase {  
        }  
            } catch (IOException e) {
import org.opensearch.cluster.metadata.MetadataCreateIndexService;  
        final long beforeSplitPrimaryTerm = IntStream.range(0, numberOfShards).mapToLong(indexMetadata::primaryTerm).max().getAsLong();  
        assertAcked(
        final Settings.Builder prepareSplitSettings = Settings.builder().put("index.blocks.write", true);
        // to the require._name below.
            firstSplitSettingsBuilder.put("index.number_of_routing_shards", secondSplitShards);  
 */  
    public void testCreateSplitWithIndexSort() throws Exception {
                assertThat("failed on " + shardRouting, seqNoStats.getLocalCheckpoint(), equalTo(maxSeqNo));  
        }
        assertEquals(numDocs, ids.size());
                .setResizeType(ResizeType.SPLIT)  
                .put("number_of_replicas", 0)  
        }
        for (int i = 0; i < 20; i++) {
    public void testCreateSplitIndexToN() throws IOException {
            final ClusterState state = client().admin().cluster().prepareState().get().getState();
                            .put("index.number_of_replicas", createWithReplicas ? 1 : 0)
                .prepareResizeIndex("source", "target")
import org.opensearch.action.admin.indices.stats.CommonStats;  
            client().admin()  
                ensureGreen();  
        ensureGreen();
            .put("index.number_of_shards", numberOfTargetShards)
        assertHitCount(client().prepareSearch("second_split").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), numDocs);
            client().admin()
        CreateIndexRequestBuilder createInitialIndex = prepareCreate("source");
                .setResizeType(ResizeType.SPLIT)  
            if (useRouting) {
        ensureYellow();
                .put("index.number_of_routing_shards", numberOfTargetShards)  
 *
                .setSettings(
                    .setSettings(
            .cluster()
        client().admin().indices().prepareUpdateSettings("source").setSettings(Settings.builder().put("index.blocks.write", true)).get();
            .setSettings(Settings.builder().put("index.blocks.write", true))
            }
                }
        // ensure all shards are allocated otherwise the ensure green below might not succeed since we require the merge node
                    // this can not succeed until the shard is failed and a replica is promoted
 * this file be licensed under the Apache-2.0 license or a
/*
        // let it be allocated anywhere and bump replicas  
        // fail random primary shards to force primary terms to increase
            GetResponse getResponse = client().prepareGet("first_split", Integer.toString(i)).setRouting(routingValue[i]).get();  
        // check that index sort cannot be set on the target index
        if (randomBoolean()) {
        final int iterations = scaledRandomIntBetween(0, 16);  
        for (int i = 0; i < numDocs; i++) {
            assertTrue(getResponse.isExists());
import org.apache.lucene.util.Constants;  
                        .build()  
 *    http://www.apache.org/licenses/LICENSE-2.0
        flushAndRefresh();
            .get();
                    .setSettings(Settings.builder().put("index.number_of_replicas", 1))
 */
            final boolean createWithReplicas = randomBoolean();
    public void assertAllUniqueDocs(SearchResponse response, int numDocs) {
            numDocs
                    routingValue[i] = routing;  
    }
            .indices()
            .prepareUpdateSettings("first_split")  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
import org.apache.lucene.search.Sort;
            builder.get();  
        if (useRouting && useMixedRouting == false && useRoutingPartition) {  
        );
        assertEquals(settingsResponse.getSetting("target", "index.sort.field"), "id");
import org.opensearch.cluster.ClusterState;
            final long maxUnsafeAutoIdTimestamp = Arrays.stream(sourceStats.getShards())
                2 * docs
            .indices()
        assertEquals(firstSplitShards, (firstSplitShards * secondSplitShards) / secondSplitShards);
            if (createWithReplicas == false) {
                .get()
import org.opensearch.action.index.IndexRequestBuilder;
                return client().prepareIndex(index)
            builder.get();
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
                .filter(shard -> shard.getShardRouting().currentNodeId().equals(mergeNode.getId()))  
                                .source("{ \"f\": \"" + s + "\"}", MediaTypeRegistry.JSON);  
                    disableAllocation("source");
        client().admin()
            assertAcked(  
            ensureGreen();
            final IndicesStatsResponse targetStats = client().admin().indices().prepareStats("target").get();
import java.util.Set;
                        .put("index.sort.field", "foo")  
                .map(CommonStats::getSegments)
import org.opensearch.index.IndexService;  
                            .endArray()
                .put(indexSettings())
        }
            assertTrue("found ID " + id + " more than once", ids.add(id));
import org.apache.lucene.search.SortedSetSelector;  
                } else {
                        .put("index.number_of_shards", secondSplitShards)
import org.opensearch.test.OpenSearchIntegTestCase;  
        // ... and that the index sort is also applied to updates
import org.opensearch.indices.IndicesService;
        int numberOfTargetShards = randomIntBetween(2, 20);
                if (randomBoolean()) {  
        ensureYellow();
        }
                            .startArray("nested1")
                .setResizeType(ResizeType.SPLIT)  
        ensureGreen();
        // if we change the setting too quickly we will end up with one replica unassigned which can't be assigned anymore due  
            .put("index.number_of_shards", firstSplitShards)  
        // now, do a nested query
                )
        }  
        ).get();
            client().prepareSearch("second_split").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(),  
                .put(indexSettings())
                .max()
import org.opensearch.cluster.metadata.IndexMetadata;
        int[][] possibleShardSplits = new int[][] { { 2, 4, 8 }, { 3, 6, 12 }, { 1, 2, 4 } };
        }
            for (int i = 0; i < numDocs; i++) { // let's introduce some updates / deletes on the index
        if (randomBoolean()) {
        final int docs = randomIntBetween(0, 128);  
                .max()  
            GetResponse getResponse = client().prepareGet("second_split", Integer.toString(i)).setRouting(routingValue[i]).get();  
        ).get();
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
                            .field("i", id)  
                )
                .setSettings(
                        .build()
        assertSortedSegments("target", expectedIndexSort);  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
                    .prepareResizeIndex("source", "target")  
                .indices()
}  
        };
        );
                .indices()
            assertNested("first_split", numDocs);
        SearchResponse searchResponse = client().prepareSearch(index)  
            .put("index.number_of_replicas", 0)
        );  
 * Unless required by applicable law or agreed to in writing,
                        // find an ID that routes to the right shard, we will only index to the shard that saw a primary failure
import org.opensearch.action.admin.indices.shrink.ResizeType;
        assertNoFailures(searchResponse);  
            .get();
                            .startObject()  
                .setSettings(splitSettings)
 * under the License.  
 * KIND, either express or implied.  See the License for the
            // randomly set the value manually
        ensureGreen();  
import java.util.HashSet;
            .setTransientSettings(Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), "none"))
        internalCluster().ensureAtLeastNumDataNodes(2);
                .put("number_of_shards", numberOfShards)
            if (useRouting) {
        int[] shardSplits = randomFrom(possibleShardSplits);  
import org.opensearch.action.search.SearchResponse;  
        flushAndRefresh();
                final SeqNoStats seqNoStats = shardStats.getSeqNoStats();  
            final int size = docs > 0 ? 2 * docs : 1;
import org.apache.lucene.search.join.ScoreMode;
        // to the require._name below.  
            assertNested("source", numDocs);
                            .field("n_field2", "n_value2_2")
        );  
                String routing = randomRealisticUnicodeOfCodepointLengthBetween(1, 10);
                .map(ShardStats::getStats)
        for (int i = 0; i < numDocs; i++) {
            String id = response.getHits().getHits()[i].getId();
        assertHitCount(client().prepareSearch("source").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), numDocs);
    }  
        final boolean useRoutingPartition;  
        );  
                .setTransientSettings(
            .prepareUpdateSettings()  
            final IndicesService indexServices = internalCluster().getInstance(IndicesService.class, node);  
    public void assertNested(String index, int numDocs) {
            IllegalArgumentException.class,  
    }
        assertHitCount(client().prepareSearch("source").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), numDocs);
        splitToN(shardSplits[0], shardSplits[1], shardSplits[2]);
/*  
            DiscoveryNode mergeNode = state.nodes().get(state.getRoutingTable().index("target").shard(0).primaryShard().currentNodeId());
import org.opensearch.transport.client.Client;
                .mapToLong(SegmentsStats::getMaxUnsafeAutoIdTimestamp)  
            client().admin()  
        final IndexMetadata indexMetadata = indexMetadata(client(), "source");
import org.opensearch.cluster.routing.Murmur3HashFunction;
        }
import org.apache.lucene.search.SortedSetSortField;
                    IndexRequestBuilder builder = indexFunc.apply("source", i);
import org.opensearch.index.engine.SegmentsStats;
 * the Apache License, Version 2.0 (the "License"); you may
        client().admin().indices().prepareDelete("*").get();  
                    shardStats.getStats().getSegments().getMaxUnsafeAutoIdTimestamp(),  
                    Settings.builder()
                            .put("index.number_of_shards", 2)
        SortField expectedSortField = new SortedSetSortField("id", true, SortedSetSelector.Type.MAX);
 * Modifications Copyright OpenSearch Contributors. See
                .map(ShardStats::getSeqNoStats)
        }
        );  
                .filter(shard -> shard.getShardRouting().currentNodeId().equals(mergeNode.getId()))  
            } else {
            .build();
            Settings.builder()  
        } else if (useNested) {
        assertAllUniqueDocs(client().prepareSearch("source").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), numDocs);
        if (useNested) {  
                .getAsLong();
        // check that the index sort order of `source` is correctly applied to the `target`
                .get()
import org.opensearch.test.VersionUtils;
 * ownership. Elasticsearch licenses this file to you under  
            }  
            logger.info("split node {}", mergeNode);  
import org.opensearch.common.settings.Settings;
        // relocate all shards to one node such that we can merge it.
        for (int i = 0; i < numDocs; i++) { // now update
                            .endObject()
        expectedSortField.setMissingValue(SortedSetSortField.STRING_FIRST);  
                        .put("index.number_of_replicas", 0)  
                    if (useRouting) {
        int numDocs = randomIntBetween(10, 50);
                createInitialIndex.setMapping("_routing", "required=true", "nested1", "type=nested");
 * SPDX-License-Identifier: Apache-2.0
        flushAndRefresh();  
        // ensure all shards are allocated otherwise the ensure green below might not succeed since we require the merge node
                .get();
        internalCluster().ensureAtLeastNumDataNodes(2);
                .put("sort.field", "id")  
 * this work for additional information regarding copyright
            if (useNested) {  
                    }  
        for (int i = 0; i < docs; i++) {
                    enableAllocation("source");
            );
    }
 * The OpenSearch Contributors require contributions made to  
                    );  
            }
import static org.opensearch.index.query.QueryBuilders.termQuery;
        // now split source into target
    }
            .put("index.number_of_replicas", 0)
import org.opensearch.action.index.IndexRequest;
            () -> client().admin()
            }
        client().admin()
 * not use this file except in compliance with the License.
        assertHitCount(client().prepareSearch("first_split").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), numDocs);  
        ensureGreen(TimeValue.timeValueSeconds(120)); // needs more than the default to relocate many shards
            }
        assertAcked(
        } else {  
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
        ensureGreen();
                    equalTo(maxUnsafeAutoIdTimestamp)
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
        // disable rebalancing to be able to capture the right stats. balancing can move the target primary
import java.io.IOException;
            .prepareUpdateSettings("second_split")  
 * GitHub history for details.
        final IndexMetadata aftersplitIndexMetadata = indexMetadata(client(), "target");
                        Settings.builder()  
        final boolean useMixedRouting = useRouting ? randomBoolean() : false;  
import java.util.function.BiFunction;  
import org.opensearch.action.admin.indices.stats.ShardStats;
        prepareCreate("source").setSettings(  
 *
        Settings.Builder settings = Settings.builder().put(indexSettings()).put("number_of_shards", sourceShards);
        ensureGreen(TimeValue.timeValueSeconds(120)); // needs more than the default to allocate many shards
            }  
        for (int i = 0; i < iterations; i++) {
import org.apache.lucene.search.SortField;
        ensureGreen();  
                    Settings.builder()
                assertHitCount(client().prepareSearch("target").setSize(size).setQuery(new TermsQueryBuilder("foo", "bar")).get(), docs);
            numDocs
                    .indices()
        BiFunction<String, Integer, IndexRequestBuilder> indexFunc = (index, id) -> {
                .prepareResizeIndex("source", "target")
        String[] routingValue = new String[numDocs];  
                    .get();
                            .field("foo", "bar")
            assertHitCount(
                .get()
                    .prepareUpdateSettings("target")  
                    Settings.builder()  
            .putNull("index.blocks.write")  
    public void testCreateSplitIndex() throws Exception {  
            assertHitCount(client().prepareSearch("target").setSize(size).setQuery(new TermsQueryBuilder("foo", "bar")).get(), docs);  
                    builder.get();
                    .indices()
            useRoutingPartition = randomBoolean();
        for (int i = 0; i < response.getHits().getHits().length; i++) {  
                builder.setRouting(routingValue[i]);
                            break;
        int randomSplit = randomIntBetween(2, 6);
        final Index source = resolveIndex("source");
                        .putNull("index.blocks.write")
import org.opensearch.action.get.GetResponse;  
import java.util.Arrays;  
                    "failed on " + shardRouting,
            final long maxSeqNo = Arrays.stream(sourceStats.getShards())
import org.opensearch.Version;
        GetSettingsResponse settingsResponse = client().admin().indices().prepareGetSettings("target").execute().actionGet();  
            GetSettingsResponse target = client().admin().indices().prepareGetSettings("target").get();
                        builder.setRouting(routingValue[i]);  
                        if (hash == shardId) {
                )
        }  
        client().admin().indices().prepareUpdateSettings("source").setSettings(prepareSplitSettings).get();
            .putNull("index.blocks.write");
                    routingValue[i] = null;
        ensureGreen();
        Sort expectedIndexSort = new Sort(expectedSortField);
        return false;
        }
import org.opensearch.cluster.node.DiscoveryNode;
        try {  
            client().admin()  
                        }
        }
        ensureGreen();
                .prepareResizeIndex("first_split", "second_split")
            }  
                .indices()
                .prepareResizeIndex("source", "target")  
            client().prepareIndex("source")  
            assertTrue(getResponse.isExists());
        );  
            assertNested("second_split", numDocs);  
 */  
                .get()  
        ensureYellow();  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo((long) numDocs));
 *  
            client().prepareIndex("source").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();
        }
        internalCluster().ensureAtLeastNumDataNodes(2);
        assumeFalse("https://github.com/elastic/elasticsearch/issues/34080", Constants.WINDOWS);  
