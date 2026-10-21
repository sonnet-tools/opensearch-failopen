            IndexRequestBuilder builder = indexFunc.apply("second_split", i);
        for (int i = 0; i < numDocs; i++) { // now update
        final boolean useRouting = randomBoolean();
    }
                    Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), (String) null)
import static org.opensearch.index.query.QueryBuilders.nestedQuery;
            }
        final IndexMetadata indexMetadata = indexMetadata(client(), "source");
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertNested("first_split", numDocs);
                    .setSource(
            if (useRouting) {
    }
 * software distributed under the License is distributed on an
        }
                .put("number_of_shards", numberOfShards)
import org.opensearch.cluster.routing.Murmur3HashFunction;
            GetResponse getResponse = client().prepareGet("first_split", Integer.toString(i)).setRouting(routingValue[i]).get();
            .put("index.number_of_replicas", 0)
            client().prepareSearch("second_split").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(),
            if (useNested) {
        }
        // now, do a nested query
import org.opensearch.action.admin.indices.stats.CommonStats;
            if (useRouting) {
        internalCluster().ensureAtLeastNumDataNodes(2);
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
        flushAndRefresh();
                )
                            .startObject()
        // With pinned timestamp, we can have tlog files even after deletion.
 *
        final Index source = resolveIndex("source");
            .putNull("index.blocks.write");
import org.opensearch.cluster.routing.ShardRouting;
        for (int i = 0; i < numDocs; i++) {
            builder.get();
            );
    public void setup() {
                return client().prepareIndex(index)
import org.opensearch.action.admin.indices.shrink.ResizeType;
        int numberOfTargetShards = randomIntBetween(2, 20);
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
                createInitialIndex.setMapping("_routing", "required=true", "nested1", "type=nested");
                        final int hash = Math.floorMod(Murmur3HashFunction.hash(s), numberOfShards);
            final ClusterState state = client().admin().cluster().prepareState().get().getState();
                .cluster()
    @Override
        assertHitCount(client().prepareSearch("source").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), numDocs);
                        .put("index.number_of_replicas", 0)
import org.opensearch.index.IndexService;
                .setSettings(
        }
            useRoutingPartition = false;
                .mapToLong(SegmentsStats::getMaxUnsafeAutoIdTimestamp)
            .indices()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                client().admin()
 * compatible open source license.
                try {
        );
import static org.hamcrest.Matchers.equalTo;
            .get();
import org.opensearch.transport.client.Client;
            firstSplitSettingsBuilder.put("index.number_of_routing_shards", secondSplitShards);
        ).get();
import java.util.HashSet;
        }
            try {
    public void testSplitIndexPrimaryTerm() throws Exception {
                .indices()
    protected boolean forbidPrivateIndexSettings() {
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
 * Licensed to Elasticsearch under one or more contributor
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        ensureGreen();
                .prepareResizeIndex("source", "first_split")
            final long maxUnsafeAutoIdTimestamp = Arrays.stream(sourceStats.getShards())
                final IndexShard shard = indexShards.getShard(shardId);
        logger.info("use routing {} use mixed routing {} use nested {}", useRouting, useMixedRouting, useNested);
            } else {
        }
                .get()
        // Delete is async.
            Settings.builder()
            client().admin()
        assertNoFailures(searchResponse);
                        .putNull("index.blocks.write")
                            .field("n_field2", "n_value2_1")
        assertAcked(
            .put(super.indexSettings())
                .setSettings(firstSplitSettingsBuilder.build())
import org.junit.After;
            .cluster()
        ensureYellow();
        // now split source into target
import org.opensearch.cluster.node.DiscoveryNode;
                client().prepareSearch("target").setSize(2 * size).setQuery(new TermsQueryBuilder("foo", "bar")).get(),
                String routing = randomRealisticUnicodeOfCodepointLengthBetween(1, 10);
    }
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            }
        final boolean useMixedRouting = useRouting ? randomBoolean() : false;
            flushAndRefresh();
                .get()
        // disable rebalancing to be able to capture the right stats. balancing can move the target primary
            Settings.builder().put(indexSettings()).put("number_of_shards", 1).put("index.version.created", version)
        assertHitCount(client().prepareSearch("second_split").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), numDocs);
            numDocs
import org.opensearch.index.engine.SegmentsStats;
                .prepareResizeIndex("source", "target")
                    IndexRequestBuilder builder = indexFunc.apply("source", i);
    private static IndexMetadata indexMetadata(final Client client, final String index) {
    }
                }
            final String node = randomSubsetOf(1, internalCluster().nodesInclude("source")).get(0);
                    enableAllocation("source");
        return Settings.builder()
                    }
        }
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.cluster.metadata.MetadataCreateIndexService;
                    .setResizeType(ResizeType.SPLIT)
            IndexRequestBuilder builder = indexFunc.apply("source", i);
 * The OpenSearch Contributors require contributions made to
        if (randomBoolean()) {
            }
        assertAllUniqueDocs(
                createInitialIndex.setMapping("_routing", "required=true");
        client().admin().indices().prepareUpdateSettings("source").setSettings(Settings.builder().put("index.blocks.write", true)).get();
import org.opensearch.indices.replication.common.ReplicationType;
        if (sourceShards == 1 && useRoutingPartition == false && randomBoolean()) { // try to set it if we have a source index with 1 shard
 * KIND, either express or implied.  See the License for the
            .prepareUpdateSettings("first_split")
                .map(CommonStats::getSegments)
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
                    ensureGreen();
            }
            DiscoveryNode mergeNode = state.nodes().get(state.getRoutingTable().index("target").shard(0).primaryShard().currentNodeId());
                            .put("index.number_of_replicas", 0)
                                .source("{ \"f\": \"" + s + "\"}", MediaTypeRegistry.JSON);
        }
            for (final ShardStats shardStats : targetStats.getShards()) {
        if (RemoteStoreSettings.isPinnedTimestampsEnabled() == false) {
import org.opensearch.indices.IndicesService;
            assertNested("second_split", numDocs);
        // to the require._name below.
                .map(ShardStats::getStats)
import static org.opensearch.index.query.QueryBuilders.termQuery;
        CreateIndexRequestBuilder createInitialIndex = prepareCreate("source");
                .filter(shard -> shard.getShardRouting().currentNodeId().equals(mergeNode.getId()))
        // let it be allocated anywhere and bump replicas
        int numberOfShards = randomValueOtherThanMany(n -> numberOfTargetShards % n != 0, () -> between(1, numberOfTargetShards - 1));
                } catch (IOException e) {
        if (useNested) {
                            .field("i", id)
            assertHitCount(
            .put("index.number_of_shards", firstSplitShards)
import java.util.concurrent.TimeUnit;
            .get();
        // ensure all shards are allocated otherwise the ensure green below might not succeed since we require the merge node
                            break;
            for (int i = docs; i < 2 * docs; i++) {
        client().admin()
        client().admin().indices().prepareUpdateSettings("source").setSettings(Settings.builder().put("index.blocks.write", true)).get();
                            client().index(request).get();
            for (int i = 0; i < numDocs; i++) { // let's introduce some updates / deletes on the index
import org.opensearch.action.get.GetResponse;
/*
                } else {
                        Settings.builder()
        for (int i = 0; i < numDocs; i++) {
        Settings.Builder settings = Settings.builder().put(indexSettings()).put("number_of_shards", sourceShards);
 * the Apache License, Version 2.0 (the "License"); you may
 */
                        } else {
        assertAcked(
 */
    @Before
    public void testCreateSplitIndex() throws Exception {
        try {
            assertHitCount(client().prepareSearch("source").setSize(size).setQuery(new TermsQueryBuilder("foo", "bar")).get(), docs);
                }
        client().admin()
                .getAsLong();
 * license agreements. See the NOTICE file distributed with
        ensureGreen(TimeValue.timeValueSeconds(120)); // needs more than the default to allocate many shards
import java.util.Set;
            useRoutingPartition = randomBoolean();
                .put(indexSettings())
        for (int i = 0; i < response.getHits().getHits().length; i++) {
        }
                .get()
            .put(IndexModule.INDEX_QUERY_CACHE_ENABLED_SETTING.getKey(), false)
                            .endObject()
        String[] routingValue = new String[numDocs];
                builder.setRouting(routingValue[i]);
            settings.put("index.routing_partition_size", randomIntBetween(1, numRoutingShards));
                assertThat(
            }
 *
            .build();
import org.opensearch.indices.RemoteStoreSettings;
            assertEquals(version, target.getIndexToSettings().get("target").getAsVersion("index.version.created", null));
 * this file be licensed under the Apache-2.0 license or a
        return false;
        assertHitCount(client().prepareSearch("first_split").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), numDocs);
        assertHitCount(client().prepareSearch("source").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), numDocs);
            client().admin().indices().prepareDelete("*").setIndicesOptions(IndicesOptions.LENIENT_EXPAND_OPEN_CLOSED_HIDDEN).get()
        Set<String> ids = new HashSet<>();
    public void assertAllUniqueDocs(SearchResponse response, int numDocs) {
            }
        assertHitCount(client().prepareSearch("second_split").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), numDocs);
        );
import org.opensearch.test.OpenSearchIntegTestCase;
                    disableAllocation("source");
            }
                if (randomBoolean()) {
                    );
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
import java.util.Arrays;
        for (int i = 0; i < iterations; i++) {
                        builder.setRouting(routingValue[i]);
import org.opensearch.test.VersionUtils;
                    int id = 0;
        // making it hard to pin point the source shards.
                .setResizeType(ResizeType.SPLIT)
                    if (useRouting) {
            GetResponse getResponse = client().prepareGet("second_split", Integer.toString(i)).setRouting(routingValue[i]).get();
                            .field("n_field1", "n_value1_2")
import org.opensearch.core.xcontent.MediaTypeRegistry;
            } catch (IOException e) {
                    routingValue[i] = null;
            builder.get();
    }
        splitToN(1, 5, 10);
                .indices()
                            final IndexRequest request = new IndexRequest("source").id(s)
        internalCluster().ensureAtLeastNumDataNodes(2);
        client().admin().indices().prepareDelete("*").get();
                    shardStats.getStats().getSegments().getMaxUnsafeAutoIdTimestamp(),
            final IndexService indexShards = indexServices.indexServiceSafe(source);
        final ClusterStateResponse clusterStateResponse = client.admin().cluster().state(new ClusterStateRequest()).actionGet();
                client().prepareIndex("target").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();
        ensureGreen(TimeValue.timeValueSeconds(120)); // needs more than the default to relocate many shards
import org.opensearch.index.shard.IndexShard;
        } else if (useNested) {
import org.opensearch.core.index.Index;
            .setSettings(Settings.builder().put("index.number_of_replicas", 0))
 */
        assertEquals(sourceShards, (sourceShards * firstSplitShards) / firstSplitShards);
            String id = response.getHits().getHits()[i].getId();
        client().admin().indices().prepareUpdateSettings("source").setSettings(prepareSplitSettings).get();
import org.opensearch.common.settings.Settings;
            assertTrue(getResponse.isExists());
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
                    shard.failShard("test", new Exception("test"));
 * not use this file except in compliance with the License.
    }
    private void splitToN(int sourceShards, int firstSplitShards, int secondSplitShards) {
import java.io.IOException;
                .prepareResizeIndex("first_split", "second_split")
            .setSettings(Settings.builder().put("index.blocks.write", true))
        if (useRouting && useMixedRouting == false && useRoutingPartition) {
        // fail random primary shards to force primary terms to increase
        final int docs = randomIntBetween(0, 128);
        splitToN(shardSplits[0], shardSplits[1], shardSplits[2]);
            .get();
        Version version = VersionUtils.randomIndexCompatibleVersion(random());
        ensureGreen();
            client().prepareIndex("source").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();
                    .setSettings(
        assertAcked(
        flushAndRefresh();
            assertNested("source", numDocs);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
                    routingValue[i] = routing;
            assertBusy(() -> {
            .setQuery(nestedQuery("nested1", termQuery("nested1.n_field1", "n_value1_1"), ScoreMode.Avg))
import org.opensearch.common.unit.TimeValue;
            .put("index.number_of_shards", numberOfTargetShards)
    }
            assertAcked(
                    .setId(Integer.toString(id))
                    .indices()
import org.opensearch.Version;
                            .build()
    public void assertNested(String index, int numDocs) {
    }
 * this work for additional information regarding copyright
                .max()
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
            .prepareUpdateSettings()
                            .put("index.number_of_shards", 2)
    }
            }
            builder.get();
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo((long) numDocs));
            .putNull("index.blocks.write")
        assertEquals(numDocs, ids.size());
                .map(ShardStats::getSeqNoStats)
            .prepareUpdateSettings("second_split")
import org.opensearch.action.search.SearchResponse;
                .indices()
                    )
            assertTrue(getResponse.isExists());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
import org.opensearch.action.index.IndexRequest;
            assertHitCount(client().prepareSearch("target").setSize(size).setQuery(new TermsQueryBuilder("foo", "bar")).get(), docs);
            logger.info("split node {}", mergeNode);
 * You may obtain a copy of the License at
            for (final Integer shardId : indexShards.shardIds()) {
        SearchResponse searchResponse = client().prepareSearch(index)
                        .build()
        ensureGreen();
                    assertEquals(0, getFileCount(translogRepoPath));
            final int size = docs > 0 ? 2 * docs : 1;
                builder.setRouting(routingValue[i]);
                            .endArray()
        } else {
                .put("index.number_of_routing_shards", numberOfTargetShards)
        assertHitCount(client().prepareSearch("second_split").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), numDocs);
        } finally {
                .mapToLong(SeqNoStats::getMaxSeqNo)
        Settings.Builder firstSplitSettingsBuilder = Settings.builder()
        assertAllUniqueDocs(client().prepareSearch("source").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), numDocs);
                .max()
            client().prepareSearch("first_split").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(),
    public void testSplitFromOneToN() {
                        }
import org.apache.lucene.search.join.ScoreMode;
                            .endObject()
        final long beforeSplitPrimaryTerm = IntStream.range(0, numberOfShards).mapToLong(indexMetadata::primaryTerm).max().getAsLong();
                .setTransientSettings(
import org.opensearch.index.query.TermsQueryBuilder;
package org.opensearch.action.admin.indices.create;
        final boolean useRoutingPartition;
 * specific language governing permissions and limitations
            .get();
        assumeFalse("https://github.com/elastic/elasticsearch/issues/34080", Constants.WINDOWS);
            .build();
                            .endObject()
            if (useRouting) {
            client().admin()
    public void testCreateSplitIndexToN() throws IOException {
        assertHitCount(client().prepareSearch("first_split").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), numDocs);
 *
        }
        return clusterStateResponse.getState().metadata().index(index);
 * Unless required by applicable law or agreed to in writing,
        }
                }
    }
            final long maxSeqNo = Arrays.stream(sourceStats.getShards())
    @After
        assertAllUniqueDocs(
                .setSettings(splitSettings)
        ensureGreen();
                .getAsLong();
                if (shard.routingEntry().primary() && randomBoolean()) {
 * SPDX-License-Identifier: Apache-2.0
                    .get()
        prepareCreate("source").setSettings(
        ).get();
import org.opensearch.index.IndexModule;
        final IndicesStatsResponse sourceStats = client().admin().indices().prepareStats("source").setSegments(true).get();
                final SeqNoStats seqNoStats = shardStats.getSeqNoStats();
            IndexRequestBuilder builder = indexFunc.apply("first_split", i);
                builder.setRouting(routingValue[i]);
                .prepareUpdateSettings()
        }
            );
        final Settings splitSettings = Settings.builder()
        );
                .setResizeType(ResizeType.SPLIT)
            .put(SETTING_NUMBER_OF_REPLICAS, 0)
        for (int shardId = 0; shardId < numberOfTargetShards; shardId++) {
                            .field("foo", "bar")
import org.opensearch.action.index.IndexRequestBuilder;
                        .put("index.number_of_shards", secondSplitShards)
    }
                            id++;
                    }
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
        BiFunction<String, Integer, IndexRequestBuilder> indexFunc = (index, id) -> {
        client().admin()
        // relocate all shards to one node such that we can merge it.
                        final String s = Integer.toString(id);
            numDocs
        final IndexMetadata aftersplitIndexMetadata = indexMetadata(client(), "target");
            }
import java.util.stream.IntStream;
    public Settings indexSettings() {
                if (useMixedRouting && randomBoolean()) {
    public void cleanUp() throws Exception {
        final Settings.Builder prepareSplitSettings = Settings.builder().put("index.blocks.write", true);
        };
                        if (hash == shardId) {
                assertThat("failed on " + shardRouting, seqNoStats.getLocalCheckpoint(), equalTo(maxSeqNo));
        int[] shardSplits = randomFrom(possibleShardSplits);
            ensureGreen();
        assertAcked(
import org.opensearch.cluster.metadata.IndexMetadata;
        int[][] possibleShardSplits = new int[][] { { 2, 4, 8 }, { 3, 6, 12 }, { 1, 2, 4 } };
 * under the License.
                assertThat("failed on " + shardRouting, seqNoStats.getMaxSeqNo(), equalTo(maxSeqNo));
        ensureGreen();
            client().admin()
        );
/*
                            .field("n_field1", "n_value1_1")
                    Settings.builder()
import org.junit.Before;
        assertEquals(firstSplitShards, (firstSplitShards * secondSplitShards) / secondSplitShards);
            final IndicesService indexServices = internalCluster().getInstance(IndicesService.class, node);
                    "failed on " + shardRouting,
                        // find an ID that routes to the right shard, we will only index to the shard that saw a primary failure
                    fail();
            settings.put("index.number_of_routing_shards", routingShards);
        ensureGreen();
        for (int i = 0; i < numDocs; i++) { // now update
            }, 60, TimeUnit.SECONDS);
                2 * docs
                }
        assertHitCount(client().prepareSearch("first_split").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), numDocs);
                            .putNull("index.blocks.write")
        final boolean useNested = randomBoolean();
 * ownership. Elasticsearch licenses this file to you under
                            .startObject()
        int numDocs = randomIntBetween(10, 50);
                        jsonBuilder().startObject()
public class RemoteSplitIndexIT extends RemoteStoreBaseIntegTestCase {
        ensureGreen();
        internalCluster().ensureAtLeastNumDataNodes(2);
                )
        }
        final int iterations = scaledRandomIntBetween(0, 16);
}
                            .startArray("nested1")
        );
                .filter(shard -> shard.getShardRouting().currentNodeId().equals(mergeNode.getId()))
            // randomly set the value manually
        }
import org.opensearch.cluster.ClusterState;
                throw new UncheckedIOException(e);
        for (int i = 0; i < docs; i++) {
            .indices()
                    builder.get();
                            .field("n_field2", "n_value2_2")
/*
        asyncUploadMockFsRepo = false;
            assertThat(aftersplitIndexMetadata.primaryTerm(shardId), equalTo(beforeSplitPrimaryTerm + 1));
                    // this can not succeed until the shard is failed and a replica is promoted
import org.apache.lucene.util.Constants;
            assertTrue("found ID " + id + " more than once", ids.add(id));
                .setResizeType(ResizeType.SPLIT)
import java.io.UncheckedIOException;
                    equalTo(maxUnsafeAutoIdTimestamp)
            createInitialIndex.setMapping("nested1", "type=nested");
            .setTransientSettings(Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), "none"))
                    .prepareResizeIndex("source", "target")
        }
    }
        splitToN(1, randomSplit, randomSplit * 2);
                    while (true) {
            // clean up
                .get();
        );
                );
        }
            GetSettingsResponse target = client().admin().indices().prepareGetSettings("target").get();
        // now split source into a new index
            client().admin()
            int numRoutingShards = MetadataCreateIndexService.calculateNumRoutingShards(secondSplitShards, Version.CURRENT) - 1;
        createInitialIndex.setSettings(settings).get();
 * GitHub history for details.
        // if we change the setting too quickly we will end up with one replica unassigned which can't be assigned anymore due
                final ShardRouting shardRouting = shardStats.getShardRouting();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            .put("index.number_of_replicas", 0)
import java.util.function.BiFunction;
            int routingShards = secondSplitShards * randomIntBetween(1, 10);
        if (randomBoolean()) {
import org.opensearch.index.seqno.SeqNoStats;
        for (int i = 0; i < numDocs; i++) {
        prepareCreate("source").setSettings(
import org.opensearch.action.support.IndicesOptions;
import org.opensearch.action.admin.indices.stats.ShardStats;
        ensureYellow();
            final IndicesStatsResponse targetStats = client().admin().indices().prepareStats("target").get();
        int randomSplit = randomIntBetween(2, 6);
        }
        super.teardown();
