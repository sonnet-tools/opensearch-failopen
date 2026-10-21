                .setResizeType(ResizeType.SPLIT)
        assertAcked(
                .prepareResizeIndex("source", "first_split")
                            .endObject()
                        if (hash == shardId) {
            String id = response.getHits().getHits()[i].getId();
            useRoutingPartition = randomBoolean();
            }
                .get()
        for (int i = 0; i < numDocs; i++) { // now update
import org.opensearch.index.IndexService;
import org.apache.lucene.search.Sort;
        internalCluster().ensureAtLeastNumDataNodes(2);
            numDocs
            .get();
            } catch (IOException e) {
                )
            DiscoveryNode mergeNode = state.nodes().get(state.getRoutingTable().index("target").shard(0).primaryShard().currentNodeId());
                .put(indexSettings())
        // now split source into a new index
                if (useMixedRouting && randomBoolean()) {
        // making it hard to pin point the source shards.
                    IndexRequestBuilder builder = indexFunc.apply("source", i);
        client().admin()
                            .startObject()
 *
                .setId(Integer.toString(i))
            assertEquals(version, target.getIndexToSettings().get("target").getAsVersion("index.version.created", null));
                    }
                            .build()
            }
            );
                .mapToLong(SeqNoStats::getMaxSeqNo)
                .setSettings(
            flushAndRefresh();
            assertThat(aftersplitIndexMetadata.primaryTerm(shardId), equalTo(beforeSplitPrimaryTerm + 1));
            assertHitCount(client().prepareSearch("source").setSize(size).setQuery(new TermsQueryBuilder("foo", "bar")).get(), docs);
            builder.get();
            final ClusterState state = client().admin().cluster().prepareState().get().getState();
        ).setMapping("id", "type=keyword,doc_values=true").get();
                    shard.failShard("test", new Exception("test"));
        for (int i = 0; i < iterations; i++) {
            if (useRouting) {
        if (randomBoolean()) {
import org.opensearch.index.engine.SegmentsStats;
        internalCluster().ensureAtLeastNumDataNodes(2);
                .put("number_of_shards", numberOfShards)
                )
                .filter(shard -> shard.getShardRouting().currentNodeId().equals(mergeNode.getId()))
        assertEquals(settingsResponse.getSetting("target", "index.sort.field"), "id");
import org.opensearch.cluster.metadata.IndexMetadata;
            Settings.builder().put(indexSettings()).put("number_of_shards", 1).put("index.version.created", version)
            client().prepareSearch("second_split").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(),
                createInitialIndex.setMapping("_routing", "required=true");
        prepareCreate("source").setSettings(
            final IndexService indexShards = indexServices.indexServiceSafe(source);
    public void testCreateSplitWithIndexSort() throws Exception {
            .prepareUpdateSettings("first_split")
        internalCluster().ensureAtLeastNumDataNodes(2);
            .get();
                        .put("index.number_of_replicas", 0)
                .get()
                .setResizeType(ResizeType.SPLIT)
            ensureGreen();
            final String node = randomSubsetOf(1, internalCluster().nodesInclude("source")).get(0);
            for (int i = docs; i < 2 * docs; i++) {
            IllegalArgumentException.class,
        }
        ensureYellow();
                }
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo((long) numDocs));
        // ensure all shards are allocated otherwise the ensure green below might not succeed since we require the merge node
                                .source("{ \"f\": \"" + s + "\"}", MediaTypeRegistry.JSON);
    }
        logger.info("use routing {} use mixed routing {} use nested {}", useRouting, useMixedRouting, useNested);
                .map(ShardStats::getStats)
            .setTransientSettings(Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), "none"))
import java.io.UncheckedIOException;
        int numberOfShards = randomValueOtherThanMany(n -> numberOfTargetShards % n != 0, () -> between(1, numberOfTargetShards - 1));
        for (int shardId = 0; shardId < numberOfTargetShards; shardId++) {
                            final IndexRequest request = new IndexRequest("source").id(s)
        final boolean useRouting = randomBoolean();
        ensureGreen();
                    Settings.builder()
import org.opensearch.action.index.IndexRequest;
        assertAcked(
import java.util.function.BiFunction;
                        final int hash = Math.floorMod(Murmur3HashFunction.hash(s), numberOfShards);
        client().admin().indices().prepareUpdateSettings("source").setSettings(Settings.builder().put("index.blocks.write", true)).get();
    }
    public void testSplitIndexPrimaryTerm() throws Exception {
        final boolean useNested = randomBoolean();
            GetResponse getResponse = client().prepareGet("first_split", Integer.toString(i)).setRouting(routingValue[i]).get();
import org.apache.lucene.search.join.ScoreMode;
            }
 * GitHub history for details.
import org.opensearch.action.admin.indices.stats.ShardStats;
                .put("number_of_replicas", 0)
        try {
                    enableAllocation("source");
                    shardStats.getStats().getSegments().getMaxUnsafeAutoIdTimestamp(),
        } else {
    private void splitToN(int sourceShards, int firstSplitShards, int secondSplitShards) {
                .map(CommonStats::getSegments)
            .indices()
 * under the License.
            firstSplitSettingsBuilder.put("index.number_of_routing_shards", secondSplitShards);
                final IndexShard shard = indexShards.getShard(shardId);
                .setSettings(splitSettings)
        ensureGreen();
            final boolean createWithReplicas = randomBoolean();
                    .indices()
        client().admin().indices().prepareUpdateSettings("source").setSettings(Settings.builder().put("index.blocks.write", true)).get();
                    // this can not succeed until the shard is failed and a replica is promoted
        for (int i = 0; i < numDocs; i++) {
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
                        }
        splitToN(1, randomSplit, randomSplit * 2);
        Set<String> ids = new HashSet<>();
                .mapToLong(SegmentsStats::getMaxUnsafeAutoIdTimestamp)
 * SPDX-License-Identifier: Apache-2.0
            int routingShards = secondSplitShards * randomIntBetween(1, 10);
            client().admin()
 * the Apache License, Version 2.0 (the "License"); you may
        );
            numDocs
        prepareCreate("source").setSettings(
        Settings.Builder settings = Settings.builder().put(indexSettings()).put("number_of_shards", sourceShards);
        );
        flushAndRefresh();
        }
            client().prepareIndex("source").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();
        SearchResponse searchResponse = client().prepareSearch(index)
        prepareCreate("source").setSettings(
        // let it be allocated anywhere and bump replicas
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            Settings.builder()
                    builder.get();
 */
 *
import org.opensearch.Version;
                        // find an ID that routes to the right shard, we will only index to the shard that saw a primary failure
                        .put("index.number_of_replicas", 0)
                            .startObject()
                throw new UncheckedIOException(e);
                    .indices()
        // check that the index sort order of `source` is correctly applied to the `target`
                .getAsLong();
                            .field("n_field1", "n_value1_2")
        for (int i = 0; i < numDocs; i++) {
                .put("sort.field", "id")
                        } else {
        for (int i = 0; i < numDocs; i++) {
        client().admin().indices().prepareUpdateSettings("source").setSettings(Settings.builder().put("index.blocks.write", true)).get();
        client().admin().indices().prepareDelete("*").get();
        assertAllUniqueDocs(client().prepareSearch("source").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), numDocs);
import org.opensearch.action.admin.indices.stats.CommonStats;
        // to the require._name below.
        return false;
    }
        assertHitCount(client().prepareSearch("first_split").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), numDocs);
}
                            .startArray("nested1")
                .map(ShardStats::getSeqNoStats)
        // now split source into target
import org.opensearch.index.seqno.SeqNoStats;
            .prepareUpdateSettings("second_split")
import static org.opensearch.index.query.QueryBuilders.termQuery;
            final long maxUnsafeAutoIdTimestamp = Arrays.stream(sourceStats.getShards())
        }
        int[][] possibleShardSplits = new int[][] { { 2, 4, 8 }, { 3, 6, 12 }, { 1, 2, 4 } };
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            settings.put("index.number_of_routing_shards", routingShards);
                .put("sort.order", "desc")
import org.opensearch.action.admin.indices.shrink.ResizeType;
                .get()
        assertHitCount(client().prepareSearch("first_split").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), numDocs);
        client().admin()
                builder.setRouting(routingValue[i]);
                    equalTo(maxUnsafeAutoIdTimestamp)
            client().prepareSearch("first_split").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(),
                            .put("index.number_of_replicas", createWithReplicas ? 1 : 0)
                    );
            .putNull("index.blocks.write");
        assertHitCount(client().prepareSearch("source").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), numDocs);
                            .endObject()
import org.opensearch.cluster.routing.ShardRouting;
        GetSettingsResponse settingsResponse = client().admin().indices().prepareGetSettings("target").execute().actionGet();
            assertNested("second_split", numDocs);
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            final IndicesService indexServices = internalCluster().getInstance(IndicesService.class, node);
                    while (true) {
            GetResponse getResponse = client().prepareGet("second_split", Integer.toString(i)).setRouting(routingValue[i]).get();
                .setResizeType(ResizeType.SPLIT)
        }
        ensureYellow();
                    disableAllocation("source");
            .setQuery(nestedQuery("nested1", termQuery("nested1.n_field1", "n_value1_1"), ScoreMode.Avg))
                        .put("index.number_of_shards", 4)
        assertHitCount(client().prepareSearch("source").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), numDocs);
        for (int i = 0; i < response.getHits().getHits().length; i++) {
            .build();
            for (final ShardStats shardStats : targetStats.getShards()) {
            assertHitCount(client().prepareSearch("target").setSize(size).setQuery(new TermsQueryBuilder("foo", "bar")).get(), docs);
 * not use this file except in compliance with the License.
                .indices()
                .setSettings(firstSplitSettingsBuilder.build())
        }
        final Settings splitSettings = Settings.builder()
                .setSettings(
                    if (useRouting) {
                builder.setRouting(routingValue[i]);
        final IndicesStatsResponse sourceStats = client().admin().indices().prepareStats("source").setSegments(true).get();
            client().admin()
            }
        final int docs = randomIntBetween(0, 128);
                            .field("n_field1", "n_value1_1")
 * this work for additional information regarding copyright
import org.opensearch.action.index.IndexRequestBuilder;
                        .put("index.number_of_replicas", 0)
                .setTransientSettings(
                .get();
                }
            Settings.builder()
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
                    .setResizeType(ResizeType.SPLIT)
            () -> client().admin()
 */
        assertSortedSegments("source", expectedIndexSort);
            .prepareUpdateSettings()
        // ensure all shards are allocated otherwise the ensure green below might not succeed since we require the merge node
            .put("index.number_of_replicas", 0)
 *    http://www.apache.org/licenses/LICENSE-2.0
        final IndexMetadata aftersplitIndexMetadata = indexMetadata(client(), "target");
                    .prepareUpdateSettings("target")
        assertSortedSegments("target", expectedIndexSort);
 * ownership. Elasticsearch licenses this file to you under
            assertNested("source", numDocs);
 * You may obtain a copy of the License at
                .getAsLong();
                client().prepareSearch("target").setSize(2 * size).setQuery(new TermsQueryBuilder("foo", "bar")).get(),
        }
            }
import java.util.HashSet;
            .cluster()
            IndexRequestBuilder builder = indexFunc.apply("first_split", i);
        }
            client().admin()
        }
        );
            .setSettings(Settings.builder().put("index.number_of_replicas", 1))
                    routingValue[i] = null;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
        }
        if (randomBoolean()) {
        ensureGreen();
        );
import org.opensearch.cluster.metadata.MetadataCreateIndexService;
            final int size = docs > 0 ? 2 * docs : 1;
        if (sourceShards == 1 && useRoutingPartition == false && randomBoolean()) { // try to set it if we have a source index with 1 shard
            .put("index.number_of_shards", firstSplitShards)
        } else if (useNested) {
            .put("index.number_of_shards", numberOfTargetShards)
        }
 * Unless required by applicable law or agreed to in writing,
                .filter(shard -> shard.getShardRouting().currentNodeId().equals(mergeNode.getId()))
        assertAllUniqueDocs(
import static org.hamcrest.Matchers.equalTo;
        assertHitCount(client().prepareSearch("second_split").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), numDocs);
                .max()
        assertEquals(numDocs, ids.size());
                .prepareResizeIndex("first_split", "second_split")
                String routing = randomRealisticUnicodeOfCodepointLengthBetween(1, 10);
        Sort expectedIndexSort = new Sort(expectedSortField);
                .prepareResizeIndex("source", "target")
                .cluster()
                    Settings.builder()
        final ClusterStateResponse clusterStateResponse = client.admin().cluster().state(new ClusterStateRequest()).actionGet();
            IndexRequestBuilder builder = indexFunc.apply("second_split", i);
        client().admin()
                    .get()
import org.opensearch.indices.IndicesService;
    public void assertAllUniqueDocs(SearchResponse response, int numDocs) {
                .indices()
                    ensureGreen();
                        .putNull("index.blocks.write")
/*
                .indices()
                            .field("foo", "bar")
                .get()
        );
                final SeqNoStats seqNoStats = shardStats.getSeqNoStats();
        return clusterStateResponse.getState().metadata().index(index);
                if (randomBoolean()) {
import org.opensearch.action.search.SearchResponse;
            client().admin()
            final long maxSeqNo = Arrays.stream(sourceStats.getShards())
                .put("number_of_shards", 2)
            if (useRouting) {
            for (final Integer shardId : indexShards.shardIds()) {
 *
import static org.hamcrest.Matchers.containsString;
        if (useNested) {
            useRoutingPartition = false;
                builder.setRouting(routingValue[i]);
 * compatible open source license.
import java.util.Set;
                .max()
                        .build()
            builder.get();
        assertNoFailures(searchResponse);
        ensureGreen();
        ensureGreen();
        final Settings.Builder prepareSplitSettings = Settings.builder().put("index.blocks.write", true);
        }
/*
                assertHitCount(client().prepareSearch("target").setSize(size).setQuery(new TermsQueryBuilder("foo", "bar")).get(), docs);
                .get()
                        .put("index.sort.field", "foo")
        BiFunction<String, Integer, IndexRequestBuilder> indexFunc = (index, id) -> {
        expectedSortField.setMissingValue(SortedSetSortField.STRING_FIRST);
            .get();
        assertHitCount(client().prepareSearch("first_split").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), numDocs);
                .get();
        }
        final IndexMetadata indexMetadata = indexMetadata(client(), "source");
                    Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), (String) null)
            for (int i = 0; i < numDocs; i++) { // let's introduce some updates / deletes on the index
            .get();
                    .setSource(
        );
 * KIND, either express or implied.  See the License for the
            if (useNested) {
    }
                    .get();
                            .endObject()
        splitToN(1, 5, 10);
                final ShardRouting shardRouting = shardStats.getShardRouting();
    }
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
        createInitialIndex.setSettings(settings).get();
            int numRoutingShards = MetadataCreateIndexService.calculateNumRoutingShards(secondSplitShards, Version.CURRENT) - 1;
package org.opensearch.action.admin.indices.create;
                if (shard.routingEntry().primary() && randomBoolean()) {
                        .putNull("index.blocks.write")
 * Modifications Copyright OpenSearch Contributors. See
                    .setId(Integer.toString(id))
        }
                            .endArray()
        assertSortedSegments("target", expectedIndexSort);
        for (int i = 0; i < numDocs; i++) { // now update
            if (useRouting) {
 */
        // check that index sort cannot be set on the target index
                createInitialIndex.setMapping("_routing", "required=true", "nested1", "type=nested");
            createInitialIndex.setMapping("nested1", "type=nested");
            assertTrue("found ID " + id + " more than once", ids.add(id));
                .setResizeType(ResizeType.SPLIT)
                    "failed on " + shardRouting,
        Settings.Builder firstSplitSettingsBuilder = Settings.builder()
            assertTrue(getResponse.isExists());
import org.opensearch.transport.client.Client;
        ensureGreen();
import java.util.stream.IntStream;
    protected boolean forbidPrivateIndexSettings() {
        internalCluster().ensureAtLeastNumDataNodes(2);
                    .prepareResizeIndex("source", "target")
        final Index source = resolveIndex("source");
                .setSource("{\"foo\" : \"bar\", \"id\" : " + i + "}", MediaTypeRegistry.JSON)
                assertThat("failed on " + shardRouting, seqNoStats.getLocalCheckpoint(), equalTo(maxSeqNo));
                } else {
            assertTrue(getResponse.isExists());
        flushAndRefresh();
                assertThat("failed on " + shardRouting, seqNoStats.getMaxSeqNo(), equalTo(maxSeqNo));
        // now, do a nested query
        final boolean useMixedRouting = useRouting ? randomBoolean() : false;
import org.opensearch.test.OpenSearchIntegTestCase;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertEquals(sourceShards, (sourceShards * firstSplitShards) / firstSplitShards);
import org.apache.lucene.util.Constants;
                .prepareResizeIndex("source", "target")
        // if we change the setting too quickly we will end up with one replica unassigned which can't be assigned anymore due
                            .field("n_field2", "n_value2_1")
                        .build()
        // to the require._name below.
                        .put("index.number_of_shards", secondSplitShards)
        assertAllUniqueDocs(
        SortField expectedSortField = new SortedSetSortField("id", true, SortedSetSelector.Type.MAX);
        for (int i = 20; i < 40; i++) {
        for (int i = 0; i < 20; i++) {
                            break;
            assertHitCount(
        }
        // disable rebalancing to be able to capture the right stats. balancing can move the target primary
import org.opensearch.test.VersionUtils;
                            .putNull("index.blocks.write")
                client().admin()
 * this file be licensed under the Apache-2.0 license or a
            .putNull("index.blocks.write")
                    routingValue[i] = routing;
    private static IndexMetadata indexMetadata(final Client client, final String index) {
        }
import org.opensearch.action.get.GetResponse;
            }
            }
        ensureGreen(TimeValue.timeValueSeconds(120)); // needs more than the default to relocate many shards
                        builder.setRouting(routingValue[i]);
 * license agreements. See the NOTICE file distributed with
    }
/*
        client().admin().indices().prepareUpdateSettings("source").setSettings(prepareSplitSettings).get();
    @Override
        assumeFalse("https://github.com/elastic/elasticsearch/issues/34080", Constants.WINDOWS);
            // clean up
                }
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
import org.opensearch.common.settings.Settings;
                            .field("n_field2", "n_value2_2")
        int numberOfTargetShards = randomIntBetween(2, 20);
            client().prepareIndex("target").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();
            settings.put("index.routing_partition_size", randomIntBetween(1, numRoutingShards));
        // relocate all shards to one node such that we can merge it.
        assertEquals(firstSplitShards, (firstSplitShards * secondSplitShards) / secondSplitShards);
                        final String s = Integer.toString(id);
        assertEquals(settingsResponse.getSetting("target", "index.sort.order"), "desc");
            client().prepareIndex("source")
                // bump replicas
                ensureGreen();
            assertNested("first_split", numDocs);
import java.util.Arrays;
        assertThat(exc.getMessage(), containsString("can't override index sort when resizing an index"));
import static org.opensearch.index.query.QueryBuilders.nestedQuery;
            }
            .indices()
                    int id = 0;
                            client().index(request).get();
        assertAcked(
            logger.info("split node {}", mergeNode);
        }
                return client().prepareIndex(index)
import org.opensearch.cluster.node.DiscoveryNode;
        IllegalArgumentException exc = expectThrows(
        assertHitCount(client().prepareSearch("second_split").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), numDocs);
import org.apache.lucene.search.SortedSetSortField;
                .prepareUpdateSettings()
        Version version = VersionUtils.randomIndexCompatibleVersion(random());
                    }
        flushAndRefresh();
public class SplitIndexIT extends OpenSearchIntegTestCase {
                .put("index.number_of_routing_shards", numberOfTargetShards)
        assertAcked(
        flushAndRefresh();
            IndexRequestBuilder builder = indexFunc.apply("source", i);
                );
    public void testCreateSplitIndexToN() throws IOException {
                .indices()
        final boolean useRoutingPartition;
        ensureGreen();
                    Settings.builder()
 * software distributed under the License is distributed on an
    }
                    .setSettings(Settings.builder().put("index.number_of_replicas", 1))
        } finally {
            final IndicesStatsResponse targetStats = client().admin().indices().prepareStats("target").get();
            if (createWithReplicas == false) {
        ).get();
import org.opensearch.index.query.TermsQueryBuilder;
            GetSettingsResponse target = client().admin().indices().prepareGetSettings("target").get();
                .indices()
                        .build()
        };
    public void testCreateSplitIndex() throws Exception {
        // fail random primary shards to force primary terms to increase
                    )
import org.opensearch.cluster.routing.Murmur3HashFunction;
                2 * docs
        if (useRouting && useMixedRouting == false && useRoutingPartition) {
    public void testSplitFromOneToN() {
            .setSettings(Settings.builder().put("index.blocks.write", true))
        CreateIndexRequestBuilder createInitialIndex = prepareCreate("source");
        final int iterations = scaledRandomIntBetween(0, 16);
 * Licensed to Elasticsearch under one or more contributor
    public void assertNested(String index, int numDocs) {
        final long beforeSplitPrimaryTerm = IntStream.range(0, numberOfShards).mapToLong(indexMetadata::primaryTerm).max().getAsLong();
                            .put("index.number_of_shards", 2)
        ensureGreen(TimeValue.timeValueSeconds(120)); // needs more than the default to allocate many shards
            } else {
                )
    }
        ensureYellow();
import org.apache.lucene.search.SortField;
        ensureGreen();
    }
                .setSettings(
import org.apache.lucene.search.SortedSetSelector;
        String[] routingValue = new String[numDocs];
        ).get();
    }
                            id++;
import org.opensearch.common.unit.TimeValue;
        // if we change the setting too quickly we will end up with one replica unassigned which can't be assigned anymore due
                client().admin()
            }
                            .field("i", id)
                .setResizeType(ResizeType.SPLIT)
        }
            client().admin()
        int randomSplit = randomIntBetween(2, 6);
                    .setSettings(
        ensureGreen();
                        jsonBuilder().startObject()
                .put(indexSettings())
            assertAcked(
            );
        int numDocs = randomIntBetween(10, 50);
import org.opensearch.index.shard.IndexShard;
 * The OpenSearch Contributors require contributions made to
        );
            builder.get();
                )
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
            try {
        flushAndRefresh();
                assertThat(
import org.opensearch.core.index.Index;
        int[] shardSplits = randomFrom(possibleShardSplits);
            // randomly set the value manually
        splitToN(shardSplits[0], shardSplits[1], shardSplits[2]);
        assertHitCount(client().prepareSearch("second_split").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), numDocs);
import org.opensearch.cluster.ClusterState;
 * specific language governing permissions and limitations
        // ... and that the index sort is also applied to updates
                client().prepareIndex("target").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();
        for (int i = 0; i < docs; i++) {
                        .put("index.number_of_shards", 4)
            }
                        Settings.builder()
                .prepareResizeIndex("source", "target")
            .put("index.number_of_replicas", 0)
import org.opensearch.core.xcontent.MediaTypeRegistry;
import java.io.IOException;
