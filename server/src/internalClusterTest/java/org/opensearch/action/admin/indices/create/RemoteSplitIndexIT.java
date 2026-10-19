        // now split source into a new index
                    disableAllocation("source");  
            .put("index.number_of_shards", numberOfTargetShards)  
import org.opensearch.action.index.IndexRequestBuilder;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.ClusterState;
import java.util.function.BiFunction;
    public void cleanUp() throws Exception {
import org.opensearch.index.seqno.SeqNoStats;
        ensureGreen(TimeValue.timeValueSeconds(120)); // needs more than the default to allocate many shards  
            GetResponse getResponse = client().prepareGet("first_split", Integer.toString(i)).setRouting(routingValue[i]).get();
                final ShardRouting shardRouting = shardStats.getShardRouting();  
        assertAcked(  
        for (int i = 0; i < docs; i++) {
        ensureGreen();
import java.util.stream.IntStream;
                            .endObject()  
        }
                assertThat(  
            client().admin().indices().prepareDelete("*").setIndicesOptions(IndicesOptions.LENIENT_EXPAND_OPEN_CLOSED_HIDDEN).get()
                .max()
            client().prepareSearch("second_split").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(),
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;  
                }
            }
        if (sourceShards == 1 && useRoutingPartition == false && randomBoolean()) { // try to set it if we have a source index with 1 shard  
        for (int i = 0; i < numDocs; i++) { // now update
                .indices()
            client().admin()
        );  
            }  
import org.opensearch.action.admin.indices.stats.CommonStats;
import org.opensearch.core.xcontent.MediaTypeRegistry;
            } catch (IOException e) {
        flushAndRefresh();
 */  
import org.opensearch.indices.IndicesService;  
                try {
    @Before  
    }  
/*  
        asyncUploadMockFsRepo = false;
        internalCluster().ensureAtLeastNumDataNodes(2);
        final boolean useNested = randomBoolean();  
                    if (useRouting) {  
import org.opensearch.index.IndexService;
            .build();
import org.apache.lucene.search.join.ScoreMode;
            .put("index.number_of_replicas", 0)
                        // find an ID that routes to the right shard, we will only index to the shard that saw a primary failure
 * Licensed to Elasticsearch under one or more contributor  
        for (int i = 0; i < numDocs; i++) {  
            Settings.builder()
        final IndicesStatsResponse sourceStats = client().admin().indices().prepareStats("source").setSegments(true).get();
                            .put("index.number_of_shards", 2)
        super.teardown();
                        final int hash = Math.floorMod(Murmur3HashFunction.hash(s), numberOfShards);
        } finally {  
            assertHitCount(
                } else {  
        String[] routingValue = new String[numDocs];
                    equalTo(maxUnsafeAutoIdTimestamp)  
 */
import static org.opensearch.index.query.QueryBuilders.termQuery;
        int[][] possibleShardSplits = new int[][] { { 2, 4, 8 }, { 3, 6, 12 }, { 1, 2, 4 } };  
                .put("number_of_shards", numberOfShards)  
import org.opensearch.cluster.metadata.IndexMetadata;
            client().admin()
            IndexRequestBuilder builder = indexFunc.apply("first_split", i);  
                        .putNull("index.blocks.write")  
                        .put("index.number_of_replicas", 0)
                        .put("index.number_of_shards", secondSplitShards)
                            .field("n_field2", "n_value2_2")  
        ensureGreen(TimeValue.timeValueSeconds(120)); // needs more than the default to relocate many shards  
import static org.opensearch.index.query.QueryBuilders.nestedQuery;  
                    enableAllocation("source");
        }  
        for (int shardId = 0; shardId < numberOfTargetShards; shardId++) {  
        return false;
import org.apache.lucene.util.Constants;
            .prepareUpdateSettings()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
    }
        ensureGreen();
    public void assertAllUniqueDocs(SearchResponse response, int numDocs) {
                if (shard.routingEntry().primary() && randomBoolean()) {
            assertHitCount(client().prepareSearch("target").setSize(size).setQuery(new TermsQueryBuilder("foo", "bar")).get(), docs);
        return Settings.builder()  
        final Settings.Builder prepareSplitSettings = Settings.builder().put("index.blocks.write", true);
                    .indices()
        Settings.Builder settings = Settings.builder().put(indexSettings()).put("number_of_shards", sourceShards);  
import org.opensearch.action.admin.indices.stats.ShardStats;
            }
            .get();  
        SearchResponse searchResponse = client().prepareSearch(index)
                .filter(shard -> shard.getShardRouting().currentNodeId().equals(mergeNode.getId()))
        ).get();
            builder.get();
                    while (true) {
        ensureGreen();
                            .endObject()  
                .setTransientSettings(
            for (int i = 0; i < numDocs; i++) { // let's introduce some updates / deletes on the index  
                .getAsLong();
        // relocate all shards to one node such that we can merge it.  
                .mapToLong(SeqNoStats::getMaxSeqNo)
                            .field("n_field1", "n_value1_2")
        for (int i = 0; i < numDocs; i++) { // now update
            for (int i = docs; i < 2 * docs; i++) {
        // to the require._name below.
            IndexRequestBuilder builder = indexFunc.apply("second_split", i);
                    int id = 0;  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
    @Override
        final IndexMetadata indexMetadata = indexMetadata(client(), "source");  
        // Delete is async.  
        int numberOfShards = randomValueOtherThanMany(n -> numberOfTargetShards % n != 0, () -> between(1, numberOfTargetShards - 1));
        final ClusterStateResponse clusterStateResponse = client.admin().cluster().state(new ClusterStateRequest()).actionGet();  
            int routingShards = secondSplitShards * randomIntBetween(1, 10);
        }
                        builder.setRouting(routingValue[i]);
 * Modifications Copyright OpenSearch Contributors. See
    public void testCreateSplitIndexToN() throws IOException {
        assertEquals(sourceShards, (sourceShards * firstSplitShards) / firstSplitShards);
                final SeqNoStats seqNoStats = shardStats.getSeqNoStats();
        ensureGreen();
            assertTrue(getResponse.isExists());
        }  
        );  
import org.opensearch.common.settings.Settings;
        ).get();  
            client().prepareSearch("first_split").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(),
        // With pinned timestamp, we can have tlog files even after deletion.
                        .build()
        );
    }  
            final IndexService indexShards = indexServices.indexServiceSafe(source);
                assertThat("failed on " + shardRouting, seqNoStats.getLocalCheckpoint(), equalTo(maxSeqNo));
    public void setup() {
import org.junit.After;
import org.opensearch.action.get.GetResponse;
            final String node = randomSubsetOf(1, internalCluster().nodesInclude("source")).get(0);  
            }
        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            int numRoutingShards = MetadataCreateIndexService.calculateNumRoutingShards(secondSplitShards, Version.CURRENT) - 1;
        assertHitCount(client().prepareSearch("first_split").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), numDocs);
                .prepareResizeIndex("source", "target")  
    }  
                client().prepareSearch("target").setSize(2 * size).setQuery(new TermsQueryBuilder("foo", "bar")).get(),  
        }
        splitToN(shardSplits[0], shardSplits[1], shardSplits[2]);
        int[] shardSplits = randomFrom(possibleShardSplits);
import org.opensearch.cluster.metadata.MetadataCreateIndexService;  
            assertNested("second_split", numDocs);
import org.opensearch.index.query.TermsQueryBuilder;  
 * compatible open source license.
            final IndicesService indexServices = internalCluster().getInstance(IndicesService.class, node);
                2 * docs
            client().admin()
import org.opensearch.index.IndexModule;  
import org.opensearch.action.admin.indices.shrink.ResizeType;
            }
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            .put(super.indexSettings())
import org.opensearch.indices.replication.common.ReplicationType;
        final Settings splitSettings = Settings.builder()
        final int docs = randomIntBetween(0, 128);
import java.io.UncheckedIOException;
            .put(SETTING_NUMBER_OF_REPLICAS, 0)  
        }  
            DiscoveryNode mergeNode = state.nodes().get(state.getRoutingTable().index("target").shard(0).primaryShard().currentNodeId());
 * KIND, either express or implied.  See the License for the
            .setQuery(nestedQuery("nested1", termQuery("nested1.n_field1", "n_value1_1"), ScoreMode.Avg))
import org.opensearch.Version;  
            .get();  
            assertNested("first_split", numDocs);  
            assertThat(aftersplitIndexMetadata.primaryTerm(shardId), equalTo(beforeSplitPrimaryTerm + 1));
                if (randomBoolean()) {
            );
 * not use this file except in compliance with the License.
        int randomSplit = randomIntBetween(2, 6);
        // now, do a nested query  
            .cluster()  
        }
        }
                    shard.failShard("test", new Exception("test"));
            Settings.builder().put(indexSettings()).put("number_of_shards", 1).put("index.version.created", version)
            final ClusterState state = client().admin().cluster().prepareState().get().getState();  
import org.opensearch.transport.client.Client;  
            assertNested("source", numDocs);
                    IndexRequestBuilder builder = indexFunc.apply("source", i);
    }  
            final IndicesStatsResponse targetStats = client().admin().indices().prepareStats("target").get();  
    }  
                }
            builder.get();
        client().admin().indices().prepareDelete("*").get();
            .put("index.number_of_replicas", 0)  
            .setSettings(Settings.builder().put("index.blocks.write", true))
            flushAndRefresh();
        assertNoFailures(searchResponse);
        }
        // ensure all shards are allocated otherwise the ensure green below might not succeed since we require the merge node
                client().prepareIndex("target").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();
            assertBusy(() -> {  
                            .field("n_field1", "n_value1_1")
        assertEquals(numDocs, ids.size());
        if (randomBoolean()) {
        } else {
                )
        if (randomBoolean()) {
            }
            GetResponse getResponse = client().prepareGet("second_split", Integer.toString(i)).setRouting(routingValue[i]).get();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
                    Settings.builder()  
                    routingValue[i] = null;
        final boolean useMixedRouting = useRouting ? randomBoolean() : false;
 * software distributed under the License is distributed on an
                    "failed on " + shardRouting,
                    assertEquals(0, getFileCount(translogRepoPath));
        assertAcked(  
 *
        final boolean useRouting = randomBoolean();
                .indices()
                            break;  
    public void assertNested(String index, int numDocs) {
        ensureYellow();
                    fail();
            String id = response.getHits().getHits()[i].getId();
        int numberOfTargetShards = randomIntBetween(2, 20);  
 *  
        internalCluster().ensureAtLeastNumDataNodes(2);
    }  
        for (int i = 0; i < iterations; i++) {
import org.opensearch.cluster.routing.ShardRouting;  
            .get();  
            assertTrue("found ID " + id + " more than once", ids.add(id));  
        for (int i = 0; i < numDocs; i++) {  
        int numDocs = randomIntBetween(10, 50);  
        client().admin().indices().prepareUpdateSettings("source").setSettings(Settings.builder().put("index.blocks.write", true)).get();
        Set<String> ids = new HashSet<>();  
    public Settings indexSettings() {
        assertAllUniqueDocs(
        ensureYellow();
            }, 60, TimeUnit.SECONDS);  
        client().admin().indices().prepareUpdateSettings("source").setSettings(Settings.builder().put("index.blocks.write", true)).get();  
            if (useNested) {
                            .endArray()
            assertAcked(
import java.util.Arrays;  
                final IndexShard shard = indexShards.getShard(shardId);
/*
        }  
        Version version = VersionUtils.randomIndexCompatibleVersion(random());  
 * this work for additional information regarding copyright
            assertTrue(getResponse.isExists());
                        Settings.builder()
            .put("index.number_of_shards", firstSplitShards)
    }
        assertHitCount(client().prepareSearch("first_split").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), numDocs);  
                createInitialIndex.setMapping("_routing", "required=true");
        if (useRouting && useMixedRouting == false && useRoutingPartition) {
        } else if (useNested) {  
                            .put("index.number_of_replicas", 0)  
                .map(ShardStats::getStats)  
        assertAcked(
        final int iterations = scaledRandomIntBetween(0, 16);
            }
            firstSplitSettingsBuilder.put("index.number_of_routing_shards", secondSplitShards);
        if (useNested) {
                            .field("i", id)
                client().admin()  
                        if (hash == shardId) {
                        } else {
                .put("index.number_of_routing_shards", numberOfTargetShards)
                builder.setRouting(routingValue[i]);
        // if we change the setting too quickly we will end up with one replica unassigned which can't be assigned anymore due  
                .get();
import org.opensearch.cluster.node.DiscoveryNode;
 * You may obtain a copy of the License at  
            GetSettingsResponse target = client().admin().indices().prepareGetSettings("target").get();
            try {
import org.opensearch.index.engine.SegmentsStats;
            .indices()  
            if (useRouting) {
        logger.info("use routing {} use mixed routing {} use nested {}", useRouting, useMixedRouting, useNested);  
        for (int i = 0; i < numDocs; i++) {  
        client().admin()
        assertAllUniqueDocs(client().prepareSearch("source").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), numDocs);
        assertHitCount(client().prepareSearch("source").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), numDocs);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
        return clusterStateResponse.getState().metadata().index(index);
                String routing = randomRealisticUnicodeOfCodepointLengthBetween(1, 10);  
                            .build()  
        // disable rebalancing to be able to capture the right stats. balancing can move the target primary  
            client().prepareIndex("source").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();  
                            id++;
                } catch (IOException e) {  
            .putNull("index.blocks.write");
 * the Apache License, Version 2.0 (the "License"); you may
            if (useRouting) {
            final long maxSeqNo = Arrays.stream(sourceStats.getShards())
                    .get()
        );
                .max()  
            .indices()  
                    // this can not succeed until the shard is failed and a replica is promoted
            useRoutingPartition = randomBoolean();
        // making it hard to pin point the source shards.
                assertThat("failed on " + shardRouting, seqNoStats.getMaxSeqNo(), equalTo(maxSeqNo));
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
import org.opensearch.action.index.IndexRequest;  
                    .setSettings(
import org.opensearch.indices.RemoteStoreSettings;
import java.util.Set;
import org.opensearch.action.support.IndicesOptions;  
        for (int i = 0; i < response.getHits().getHits().length; i++) {
    }
            final long maxUnsafeAutoIdTimestamp = Arrays.stream(sourceStats.getShards())
        client().admin()
 *
        createInitialIndex.setSettings(settings).get();
                .map(ShardStats::getSeqNoStats)  
            }
            builder.get();  
 */  
                createInitialIndex.setMapping("_routing", "required=true", "nested1", "type=nested");
            } else {  
    public void testSplitFromOneToN() {
                    )
            }  
                }
        ensureGreen();
            // clean up
}
        }
import org.opensearch.index.shard.IndexShard;
                            .field("foo", "bar")  
                    ensureGreen();  
        assertHitCount(client().prepareSearch("second_split").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), numDocs);
            settings.put("index.number_of_routing_shards", routingShards);
                            final IndexRequest request = new IndexRequest("source").id(s)  
                    .setSource(
                    }
            settings.put("index.routing_partition_size", randomIntBetween(1, numRoutingShards));  
import org.opensearch.action.search.SearchResponse;
                )
        try {
                .setResizeType(ResizeType.SPLIT)
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;  
            .setSettings(Settings.builder().put("index.number_of_replicas", 0))
import java.util.concurrent.TimeUnit;  
        internalCluster().ensureAtLeastNumDataNodes(2);
                .indices()
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo((long) numDocs));
        Settings.Builder firstSplitSettingsBuilder = Settings.builder()
import java.io.IOException;
                            .endObject()
        if (RemoteStoreSettings.isPinnedTimestampsEnabled() == false) {
                );
        };
            .put(IndexModule.INDEX_QUERY_CACHE_ENABLED_SETTING.getKey(), false)
    public void testCreateSplitIndex() throws Exception {
        // fail random primary shards to force primary terms to increase
        CreateIndexRequestBuilder createInitialIndex = prepareCreate("source");
import org.opensearch.test.VersionUtils;
    }  
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
 *    http://www.apache.org/licenses/LICENSE-2.0
                builder.setRouting(routingValue[i]);  
                .filter(shard -> shard.getShardRouting().currentNodeId().equals(mergeNode.getId()))
                .getAsLong();  
        BiFunction<String, Integer, IndexRequestBuilder> indexFunc = (index, id) -> {  
            .build();
                    builder.get();  
                }
    protected boolean forbidPrivateIndexSettings() {  
                .put(indexSettings())
        splitToN(1, randomSplit, randomSplit * 2);  
            ensureGreen();
        }  
    public void testSplitIndexPrimaryTerm() throws Exception {
import org.opensearch.test.OpenSearchIntegTestCase;
            if (useRouting) {  
            .putNull("index.blocks.write")
                            .putNull("index.blocks.write")
            client().admin()
                .map(CommonStats::getSegments)
                            client().index(request).get();
                throw new UncheckedIOException(e);  
                .prepareResizeIndex("source", "first_split")  
                    Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), (String) null)  
/*  
            .setTransientSettings(Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), "none"))
        );
        client().admin()
        assertHitCount(client().prepareSearch("source").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), numDocs);  
        assumeFalse("https://github.com/elastic/elasticsearch/issues/34080", Constants.WINDOWS);
 * license agreements. See the NOTICE file distributed with
                                .source("{ \"f\": \"" + s + "\"}", MediaTypeRegistry.JSON);
            );  
            .prepareUpdateSettings("first_split")
 * specific language governing permissions and limitations
                    .setResizeType(ResizeType.SPLIT)  
        assertAcked(  
                    .prepareResizeIndex("source", "target")
    }
            logger.info("split node {}", mergeNode);
 * under the License.  
        final long beforeSplitPrimaryTerm = IntStream.range(0, numberOfShards).mapToLong(indexMetadata::primaryTerm).max().getAsLong();
        }  
        splitToN(1, 5, 10);  
            createInitialIndex.setMapping("nested1", "type=nested");
                        jsonBuilder().startObject()
import static org.hamcrest.Matchers.equalTo;
        flushAndRefresh();  
        client().admin().indices().prepareUpdateSettings("source").setSettings(prepareSplitSettings).get();  
                .prepareResizeIndex("first_split", "second_split")  
            assertEquals(version, target.getIndexToSettings().get("target").getAsVersion("index.version.created", null));
    @After
                .setSettings(
    private void splitToN(int sourceShards, int firstSplitShards, int secondSplitShards) {  
        // now split source into target  
                            .startObject()
            assertHitCount(client().prepareSearch("source").setSize(size).setQuery(new TermsQueryBuilder("foo", "bar")).get(), docs);  
import org.opensearch.common.unit.TimeValue;  
                .setSettings(firstSplitSettingsBuilder.build())
            numDocs
        // let it be allocated anywhere and bump replicas
        prepareCreate("source").setSettings(  
package org.opensearch.action.admin.indices.create;
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;  
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
            .prepareUpdateSettings("second_split")
        assertAllUniqueDocs(  
                            .startArray("nested1")
        }
                .setSettings(splitSettings)
                    shardStats.getStats().getSegments().getMaxUnsafeAutoIdTimestamp(),
                .setResizeType(ResizeType.SPLIT)
                    routingValue[i] = routing;
    }  
                        final String s = Integer.toString(id);  
                builder.setRouting(routingValue[i]);
        ensureGreen();
        assertHitCount(client().prepareSearch("second_split").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), numDocs);
                    .setId(Integer.toString(id))  
        prepareCreate("source").setSettings(
        }  
            final int size = docs > 0 ? 2 * docs : 1;
                .cluster()  
        final Index source = resolveIndex("source");  
 * SPDX-License-Identifier: Apache-2.0
        assertHitCount(client().prepareSearch("second_split").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), numDocs);  
public class RemoteSplitIndexIT extends RemoteStoreBaseIntegTestCase {
                .get()  
                .mapToLong(SegmentsStats::getMaxUnsafeAutoIdTimestamp)
        final boolean useRoutingPartition;
            for (final ShardStats shardStats : targetStats.getShards()) {
                            .field("n_field2", "n_value2_1")
                .setResizeType(ResizeType.SPLIT)
                    );
 * Unless required by applicable law or agreed to in writing,
        assertEquals(firstSplitShards, (firstSplitShards * secondSplitShards) / secondSplitShards);  
import org.junit.Before;
import org.opensearch.cluster.routing.Murmur3HashFunction;
            // randomly set the value manually  
                .get()  
            for (final Integer shardId : indexShards.shardIds()) {  
            useRoutingPartition = false;  
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
            numDocs  
            .get();  
import org.opensearch.core.index.Index;
        assertHitCount(client().prepareSearch("first_split").setSize(100).setQuery(new TermsQueryBuilder("foo", "bar")).get(), numDocs);
                    }
import java.util.HashSet;
                return client().prepareIndex(index)
                            .startObject()  
                        }  
        final IndexMetadata aftersplitIndexMetadata = indexMetadata(client(), "target");
        }
                if (useMixedRouting && randomBoolean()) {
 * GitHub history for details.
                .prepareUpdateSettings()
            IndexRequestBuilder builder = indexFunc.apply("source", i);
                .get()  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    private static IndexMetadata indexMetadata(final Client client, final String index) {
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
        ensureGreen();
