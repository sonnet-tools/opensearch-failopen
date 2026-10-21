        for (String indexName : indexStats.keySet()) {
            new DocsStats.Builder().count(notMatchMaxDocs).deleted(0).totalSizeInBytes(notMatchMaxSize.getBytes()).build(),
 * SPDX-License-Identifier: Apache-2.0
            .putAlias(AliasMetadata.builder("logs-alias").writeIndex(false).build())
    public void testCheckBlockAbortsWhenWriteIndexHasMetadataWriteBlock() {
        when(response.getIndex(indexName)).thenReturn(indexStats);
            assertThat(matched, equalTo(true));
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
    public static IndicesStatsResponse randomIndicesStatsResponse(final IndexMetadata[] indices) {
            createIndexService,
            clusterService,
        verify(condition).evaluate(argument.capture());
        when(mockNode.getId()).thenReturn("mocknode");
            .numberOfShards(1)
        assertThat(result, is(nullValue()));
        ClusterService clusterService = mock(ClusterService.class);
        ClusterState baseState = DataStreamTestHelper.getClusterStateWithDataStreams(
        when(totalCommonStats.getDocs()).thenReturn(
        long matchMaxDocs = randomIntBetween(100, 1000);
        rolloverRequest.addMaxIndexDocsCondition(500L);
        evaluateConditions(
                        .shardPath(new ShardPath(false, path, path, shardId))
        MaxSizeCondition maxSizeCondition = new MaxSizeCondition(new ByteSizeValue(randomIntBetween(10, 100), ByteSizeUnit.MB));
        when(clusterService.state()).thenReturn(state);
        results.forEach((k, v) -> assertFalse(v));
            .settings(settings)
        response = future.actionGet();
        );
        final IndexStats indexStats = mock(IndexStats.class);
            metadataIndexAliasesService,
        long docsInShards = 200;
        when(indexStats.getPrimaries()).thenReturn(primariesCommonStats);
        }
            metadataRolloverService,
 * Licensed to Elasticsearch under one or more contributor
    }
        // an implicit METADATA_WRITE block; without a user-set read-only setting, the
    public void testDocStatsSelectionFromPrimariesOnly() {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, randomIntBetween(1, 1000))
            createIndicesStatResponse(indexName, docsInShards, docsInPrimaryShards)
import org.opensearch.index.engine.SegmentsStats;
        // Given: an alias whose write index is unblocked, and a non-write
            .settings(settings(Version.CURRENT))
import org.opensearch.index.refresh.RefreshStats;
        );
        ClusterBlockException result = action.checkBlock(new RolloverRequest(dataStreamName, null), state);
    }
    public void testCheckBlockSkipsBlockOnNonWriteDataStreamBacking() {
        doAnswer(invocation -> {
import org.opensearch.common.UUIDs;
        MetadataCreateIndexService createIndexService = mock(MetadataCreateIndexService.class);
        assertThat(response.getOldIndex(), equalTo("logs-index-000002"));
            .build();
        String dataStreamName = "logs-ds";
        when(threadPool.getThreadContext()).thenReturn(threadContext);
            List.of(new Tuple<>(dataStreamName, generations)),
        Settings remoteSnapshotSettings = Settings.builder()
import org.opensearch.core.index.shard.ShardId;
        assertThat(results.size(), equalTo(3));
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            emptyList()
import org.opensearch.cluster.metadata.IndexMetadata;
import static org.mockito.Mockito.verify;
            .creationDate(System.currentTimeMillis() - TimeValue.timeValueHours(randomIntBetween(5, 10)).getMillis())
import static org.mockito.Mockito.doAnswer;
            int numShards = randomIntBetween(1, 3);
    public void testCheckBlockAbortsWhenDataStreamWriteBackingBlocked() {
            // INDEX_METADATA_BLOCK includes METADATA_WRITE level (see sibling test for rationale).
import org.opensearch.cluster.ClusterState;
        final Map<String, IndexStats> indexStats = new HashMap<>();
            clusterService,
        }
        // For given alias, verify that condition evaluation fails when the condition doc count is greater than the primaries doc count
            .build();
        IndexMetadata writeIndex = IndexMetadata.builder(writeIndexName)
/*
            mockTransportService,
import org.opensearch.index.shard.IndexingStats;
    private IndicesStatsResponse createIndicesStatResponse(String indexName, long totalDocs, long primariesDocs) {
import org.opensearch.index.search.stats.SearchStats;
    }
        return response;
        // Given: an alias whose write index has a METADATA_WRITE block applied
            List.of(new Tuple<>(dataStreamName, generations)),
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        final IndexNameExpressionResolver mockIndexNameExpressionResolver = mock(IndexNameExpressionResolver.class);
            ActionListener<IndicesStatsResponse> listener = (ActionListener<IndicesStatsResponse>) args[2];
import org.opensearch.test.OpenSearchTestCase;
        final DiscoveryNode mockNode = mock(DiscoveryNode.class);
import static org.mockito.Mockito.eq;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, randomInt(10))
        final IndexMetadata metadata = IndexMetadata.builder(randomAlphaOfLength(10))
        final CommonStats primaryStats = mock(CommonStats.class);
            mockThreadPool,
        RolloverRequest rolloverRequest = new RolloverRequest("logs-alias", "logs-index-000003");
        assertThat(results2.size(), equalTo(3));
            .putAlias(AliasMetadata.builder(alias).writeIndex(false).build())
                    new ShardStats.Builder().shardRouting(shardRouting)
        // (regression guard for the still-correct abort path)
            new DocsStats.Builder().count(primariesDocs).deleted(0).totalSizeInBytes(between(1, 10000)).build()
import org.opensearch.cluster.metadata.ResolvedIndices;
        when(indexStats.getTotal()).thenReturn(totalCommonStats);
        final CommonStats primariesStats = new CommonStats();
            .numberOfShards(1)
        return response;
            .settings(remoteSnapshotSettings)
/*
            // INDEX_WRITE_BLOCK has level WRITE only and would not trip checkBlock's METADATA_WRITE
        ClusterBlockException result = action.checkBlock(new RolloverRequest(dataStreamName, null), state);
 * KIND, either express or implied.  See the License for the
            shardStats.size(),
import org.opensearch.action.support.ActionFilters;
            .blocks(ClusterBlocks.builder().addIndexBlock(writeIndexName, IndexMetadata.INDEX_METADATA_BLOCK).build())
        final Condition<?> condition = createTestCondition();
 * The OpenSearch Contributors require contributions made to
        ClusterBlockException result = action.checkBlock(new RolloverRequest(alias, null), state);
        IndexNameExpressionResolver indexNameExpressionResolver = new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY));
        final CommonStats totalStats = new CommonStats();
    }
 * Modifications Copyright OpenSearch Contributors. See
            mock(ActionFilters.class),
        long notMatchMaxDocs = randomIntBetween(0, 99);
        );
        int generations = 2;
    public void testCheckBlockReturnsNullWhenAliasHasNoWriteMember() {
/*
 * not use this file except in compliance with the License.
        ClusterState state = ClusterState.builder(baseState)
import static org.hamcrest.Matchers.nullValue;
                ResolvedIndices.of("logs-alias")
import org.opensearch.action.admin.indices.stats.ShardStats;
        assertEquals(docsInPrimaryShards, argument.getValue().numDocs);
            .build();
        // Then: returns null (the bug fix — non-write member is irrelevant)
            .putAlias(AliasMetadata.builder("logs-alias").writeIndex(true).build())
        IndicesStatsResponse indicesStats = randomIndicesStatsResponse(new IndexMetadata[] { metadata });
    }
            .put(IndexMetadata.SETTING_READ_ONLY, true)
            mock(Client.class)
import static org.hamcrest.Matchers.is;
        rolloverRequest.addMaxIndexDocsCondition(300L);
            indexNameExpressionResolver,
            .settings(remoteSnapshotSettings)
            .put(settings(Version.CURRENT).build())
                fail("unknown condition result found " + entry.getKey());
        // Given: an alias with members but none marked is_write_index=true.
                stats.merge = new MergeStats();
                    .withLocalSubActions(CreateIndexAction.INSTANCE, ResolvedIndices.Local.of("logs-index-000003")),
        final Set<Condition<?>> conditions = Sets.newHashSet(maxDocsCondition, maxAgeCondition, maxSizeCondition);
        assertThat(results.size(), equalTo(3));
        TransportRolloverAction action = newRolloverActionForCheckBlock(state);
import org.opensearch.cluster.ClusterName;
        final IndexMetadata metadata = IndexMetadata.builder(randomAlphaOfLength(10))
        TransportRolloverAction action = newRolloverActionForCheckBlock(state);
                );
        when(primaryStats.getDocs()).thenReturn(
    public void testEvaluateWithoutDocStats() {
            .numberOfShards(1)
    private TransportRolloverAction newRolloverActionForCheckBlock(ClusterState state) {
            rolloverService,
            primariesStats.add(indexStats.get(indexName).getPrimaries());
 * this file be licensed under the Apache-2.0 license or a
                shardRouting = shardRouting.initialize("node-0", null, ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE);
        );
            return null;
                stats.indexing = new IndexingStats();
 * You may obtain a copy of the License at
            resolver
            .build();
        TransportRolloverAction action = newRolloverActionForCheckBlock(state);
 * Unless required by applicable law or agreed to in writing,
        int generations = 2;
            if (entry.getKey().equals(maxAgeCondition.toString())) {
        final ClusterService mockClusterService = mock(ClusterService.class);
        for (Boolean matched : results.values()) {
        ClusterState stateBefore = ClusterState.builder(ClusterName.DEFAULT)
            // matching the level CCR's INDEX_REPLICATION_BLOCK uses.
            shardStats.size(),
        when(condition.evaluate(any())).thenReturn(new Condition.Result(condition, true));
        TransportRolloverAction action = newRolloverActionForCheckBlock(state);
            new DocsStats.Builder().count(primaries).deleted(0).totalSizeInBytes(between(1, 10000)).build()
            .settings(settings(Version.CURRENT))
            int primaryIdx = randomIntBetween(-1, numShards - 1); // -1 means there is no primary shard.
            .settings(settings(Version.CURRENT))
import org.opensearch.cluster.service.ClusterService;
        String olderBacking = baseState.metadata().dataStreams().get(dataStreamName).getIndices().getFirst().getName();
        // Given: a data stream where the write (highest-generation) backing carries a METADATA_WRITE block
            .build();
        ThreadPool threadPool = mock(ThreadPool.class);
            // probe; INDEX_METADATA_BLOCK is the closest standard constant that includes METADATA_WRITE,
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
                        .seqNoStats(null)
import org.opensearch.index.cache.query.QueryCacheStats;
            .numberOfShards(1)
import org.opensearch.index.shard.ShardPath;
import org.opensearch.core.action.ActionListener;
                stats.segments = new SegmentsStats();
        // Given: cluster state with no abstraction matching the rollover target
            mockIndexNameExpressionResolver
        );
        // When: checkBlock runs
            .metadata(Metadata.builder().put(indexMetadata).put(indexMetadata2))
        );
    private static IndexMetadata createMetadata(String indexName) {
        String writeIndexName = "logs-000002";
        return new TransportRolloverAction(
    }
                    new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, null)
        // When: checkBlock runs for a rollover targeting the alias
            .settings(settings)
        String alias = "logs-alias";
                stats.completion = new CompletionStats();
import org.opensearch.common.util.set.Sets;
import java.util.HashMap;
        Map<String, Boolean> results = evaluateConditions(
    }
            } else if (entry.getKey().equals(maxDocsCondition.toString())) {
        IndexMetadata.Builder indexMetadata2 = IndexMetadata.builder("logs-index-000002")
 * the Apache License, Version 2.0 (the "License"); you may
            mockCreateIndexService,
        // When: checkBlock runs
        final IndexMetadata.Builder indexMetadata2 = IndexMetadata.builder("logs-index-000002")
import org.opensearch.action.admin.indices.stats.CommonStats;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .numberOfReplicas(1);
        final IndexMetadata.Builder indexMetadata = IndexMetadata.builder("logs-index-000001")
import org.opensearch.cluster.metadata.Metadata;
        ClusterBlockException result = action.checkBlock(new RolloverRequest(alias, null), state);
            .numberOfShards(1)
        );
        final IndicesStatsResponse statsResponse = createAliasToMultipleIndicesStatsResponse(indexStats);
    public void testEvaluateWithoutMetadata() {
        Map<String, Boolean> results2 = evaluateConditions(conditions, null, indicesStats);
        TransportRolloverAction action = newRolloverActionForCheckBlock(state);
        return IndicesStatsTests.newIndicesStatsResponse(
        TransportRolloverAction action = newRolloverActionForCheckBlock(state);
import org.opensearch.cluster.metadata.MetadataIndexAliasesService;
            createMetadata(indexName),
                stats.flush = new FlushStats();
        Set<Condition<?>> conditions = Sets.newHashSet(maxDocsCondition, maxAgeCondition, maxSizeCondition);
            .settings(settings)
                ShardId shardId = new ShardId(index.getIndex(), i);
        final Condition<?> condition = mock(Condition.class);
import static org.mockito.Mockito.anyBoolean;
            0,
        // When: checkBlock runs
            .blocks(ClusterBlocks.builder().addIndexBlock(olderBacking, IndexMetadata.INDEX_METADATA_BLOCK).build())
            .putAlias(AliasMetadata.builder(alias).writeIndex(true).build())
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
            .numberOfShards(1)
        assertThat(result, is(notNullValue()));
        // Given: a data stream with multiple backing indices; an older backing
            .putAlias(AliasMetadata.builder(alias).writeIndex(true).build())
                ResolvedIndices.of("logs-alias")
            List.of()
            Sets.newHashSet(condition),
            assertEquals(
        String writeBacking = backings.getLast().getName();
            // INDEX_METADATA_BLOCK includes METADATA_WRITE level (see sibling test for rationale).
        IndexMetadata indexB = IndexMetadata.builder(memberB)
            .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.REMOTE_SNAPSHOT.getSettingsKey())
        final Set<Condition<?>> conditions = Sets.newHashSet(maxDocsCondition, maxAgeCondition, maxSizeCondition);
            }
            conditions,
import org.opensearch.search.suggest.completion.CompletionStats;
        assertThat(result, is(nullValue()));
                    primary ? RecoverySource.EmptyStoreRecoverySource.INSTANCE : RecoverySource.PeerRecoverySource.INSTANCE,
        assertThat(response.isDryRun(), equalTo(true));
            metadata
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            mockClusterService,
 * GitHub history for details.
        assertThat(result, is(notNullValue()));
        final ActionFilters mockActionFilters = mock(ActionFilters.class);
import java.util.Set;
 */
        );
            new DocsStats.Builder().count(total).deleted(0).totalSizeInBytes(between(1, 10000)).build()
            .settings(settings(Version.CURRENT))
            .numberOfReplicas(1)
        rolloverRequest.dryRun(true);
            .metadata(Metadata.builder().put(writeIndex, false).put(blockedNonWriteMember, false))
            .metadata(Metadata.builder().put(indexA, false).put(indexB, false))
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
        when(clusterService.state()).thenReturn(stateBefore);
        String memberA = "logs-000001";
import org.opensearch.transport.client.Client;
        indexStats.put("logs-index-000001", createIndexStats(200L, total));
        // When: checkBlock runs for a rollover targeting the data stream
import org.opensearch.action.admin.indices.stats.IndicesStatsAction;
                resolvedIndices
        // Then: returns null (data-stream parity with the alias case)
            } else if (entry.getKey().equals(maxDocsCondition.toString())) {
        ClusterState state = ClusterState.builder(baseState)
        final ClusterState stateBefore = ClusterState.builder(ClusterName.DEFAULT)
import org.opensearch.action.admin.indices.stats.IndexStats;
                resolvedIndices
import static java.util.Collections.emptyList;
            .putAlias(AliasMetadata.builder(alias).writeIndex(true).build())
        int total = randomIntBetween(500, 1000);
        // When: checkBlock runs
import org.mockito.ArgumentCaptor;
    }
        final CommonStats totalStats = mock(CommonStats.class);
import static org.hamcrest.Matchers.equalTo;
        final Settings settings = Settings.builder()
            } else if (entry.getKey().equals(maxSizeCondition.toString())) {
        Map<String, Boolean> results = evaluateConditions(conditions, null, metadata);
import org.opensearch.tasks.Task;
 * compatible open source license.
        results = evaluateConditions(
            ResolvedIndices resolvedIndices = action.resolveIndices(new RolloverRequest("logs-alias", "explicit-index"));
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
import org.opensearch.index.cache.request.RequestCacheStats;
        when(response.getPrimaries()).thenReturn(primariesStats);
                assertThat(entry.getValue(), equalTo(false));
            threadPool,
            List.of()
            .settings(settings(Version.CURRENT))
    public void testEvaluateConditions() {
                        .pollingIngestStats(null)
        assertThat(response.getNewIndex(), equalTo("logs-index-000003"));
        when(response.getTotal()).thenReturn(totalStats);
            resolver,
                        .commitStats(null)
 * license agreements. See the NOTICE file distributed with
            assertEquals(
        assertThat(response.getConditionStatus().get("[max_docs: 300]"), is(true));
        ClusterState state = ClusterState.builder(ClusterName.DEFAULT)
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assert statsResponse.getPrimaries().getDocs().getCount() == 500L;
        // (Multiple non-write members with no write member is the only shape that makes
import org.opensearch.cluster.block.ClusterBlocks;
        assert statsResponse.getTotal().getDocs().getCount() == (total + total);
        );
            totalStats.add(indexStats.get(indexName).getTotal());
        return indexStats;
                stats.refresh = new RefreshStats();
        RolloverResponse response = future.actionGet();
 */
            .numberOfReplicas(1);
            mock(ActionFilters.class),
        final TransportRolloverAction transportRolloverAction = new TransportRolloverAction(
            .build();
        // Then: returns null — defers to MetadataRolloverService's canonical
import org.opensearch.cluster.metadata.AliasMetadata;
            new DocsStats.Builder().count(totalDocs).deleted(0).totalSizeInBytes(between(1, 10000)).build()
    private IndicesStatsResponse createAliasToMultipleIndicesStatsResponse(Map<String, IndexStats> indexStats) {
        // (not the write backing) has a METADATA_WRITE block
            .creationDate(System.currentTimeMillis() - TimeValue.timeValueHours(3).getMillis())
            .numberOfReplicas(1)
import org.opensearch.action.ActionRequest;
        assertThat(response.getConditionStatus().size(), equalTo(1));
            .settings(settings(Version.CURRENT))
            .build();
        final ThreadPool mockThreadPool = mock(ThreadPool.class);
            mockClient
        );
        ByteSizeValue notMatchMaxSize = new ByteSizeValue(randomIntBetween(0, 9), ByteSizeUnit.MB);
        IndexMetadata indexA = IndexMetadata.builder(memberA)
            .settings(settings(Version.CURRENT))
            .numberOfReplicas(1)
public class TransportRolloverActionTests extends OpenSearchTestCase {
            .numberOfShards(1)
        }
        assertThat(response.getOldIndex(), equalTo("logs-index-000002"));
        final MetadataIndexAliasesService mdIndexAliasesService = mock(MetadataIndexAliasesService.class);
            .build();
 * this work for additional information regarding copyright
            .putAlias(AliasMetadata.builder(alias).writeIndex(true).build())
        MaxDocsCondition maxDocsCondition = new MaxDocsCondition(100L);
            mock(Client.class)
import org.opensearch.cluster.routing.RecoverySource;
            .metadata(Metadata.builder().put(indexMetadata).put(indexMetadata2))
        String memberB = "logs-000002";
        final TransportService mockTransportService = mock(TransportService.class);
import org.opensearch.common.unit.TimeValue;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, randomInt(10))
        rolloverRequest.dryRun(true);
        when(threadPool.getThreadContext()).thenReturn(new ThreadContext(Settings.EMPTY));
import org.opensearch.action.admin.indices.stats.IndicesStatsTests;
 * software distributed under the License is distributed on an
        List<ShardStats> shardStats = new ArrayList<>();
 * under the License.
                stats.warmer = new WarmerStats();
        ClusterBlockException result = action.checkBlock(new RolloverRequest(alias, null), state);
                shardRouting = shardRouting.moveToStarted();
            listener.onResponse(statsResponse);
            .build();
            rolloverService,
                stats.store = new StoreStats();
        assertThat(result.getMessage(), containsString(writeIndexName));
            .build();
        assertThat(result, is(notNullValue()));
            .numberOfShards(1)
            metadata
        assertThat(response.getNewIndex(), equalTo("logs-index-000003"));
            .blocks(ClusterBlocks.builder().addIndexBlock(writeIndexName, IndexMetadata.INDEX_METADATA_BLOCK).build())
            } else if (entry.getKey().equals(maxSizeCondition.toString())) {
            Object[] args = invocation.getArguments();
        assertThat(response.isRolledOver(), equalTo(false));
            .numberOfReplicas(1)
        MetadataRolloverService metadataRolloverService = new MetadataRolloverService(
                        .commonStats(stats)
    }
        when(indexStats.getPrimaries()).thenReturn(primaryStats);
        // (primaries from only write index is considered)
                shardStats.add(
        return IndexMetadata.builder(indexName)
        return condition;
            .blocks(ClusterBlocks.builder().addIndexBlock(nonWriteMember, IndexMetadata.INDEX_METADATA_BLOCK).build())
            .numberOfReplicas(1);
            .build();
            .putAlias(AliasMetadata.builder(alias).writeIndex(false).build())
        final IndicesStatsResponse response = mock(IndicesStatsResponse.class);
        );
        final CommonStats totalCommonStats = mock(CommonStats.class);
        final Settings settings = Settings.builder()
    private static Condition<?> createTestCondition() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .numberOfShards(1)
                        .retentionLeaseStats(null)
    }
        );
        transportRolloverAction.clusterManagerOperation(mock(Task.class), rolloverRequest, stateBefore, future);
        results2.forEach((k, v) -> assertFalse(v));
        String writeIndexName = "logs-000002";
        for (final IndexMetadata index : indices) {
            } else {
        final Settings settings = Settings.builder()
                assertThat(entry.getValue(), equalTo(false));
            .settings(settings(Version.CURRENT))
import java.nio.file.Path;
        // Write backing is the highest-generation index — the last in the indices list.
        assertThat(response.isDryRun(), equalTo(true));
import org.opensearch.core.common.unit.ByteSizeUnit;
                boolean primary = (i == primaryIdx);
    public void testCheckBlockSkipsRemoteSnapshotWriteIndexWithoutUserReadOnlyBlock() {
            if (entry.getKey().equals(maxAgeCondition.toString())) {
        // The write backing is the highest-generation index; older backings come first.
        );
    }
        // alias member that carries a METADATA_WRITE block (CCR-style)
package org.opensearch.action.admin.indices.rollover;
        }
                    primary,
            mock(MetadataCreateIndexService.class),
        }).when(mockClient).execute(eq(IndicesStatsAction.INSTANCE), any(ActionRequest.class), any(ActionListener.class));
        IndexStats indexStats = mock(IndexStats.class);
        when(mockCreateIndexService.applyCreateIndexRequest(any(), any(), anyBoolean())).thenReturn(stateBefore);
        ClusterBlockException result = action.checkBlock(new RolloverRequest("does-not-exist", null), state);
        PlainActionFuture<RolloverResponse> future = new PlainActionFuture<>();
            .putAlias(AliasMetadata.builder(alias).writeIndex(false).build())
        String alias = "logs-alias";
        Map<String, Boolean> results = evaluateConditions(
        );
        MaxAgeCondition maxAgeCondition = new MaxAgeCondition(TimeValue.timeValueHours(2));
                stats.search = new SearchStats();
            .numberOfReplicas(1);
        assertThat(result, is(nullValue()));
            .build();
import static org.hamcrest.Matchers.notNullValue;
                assertThat(entry.getValue(), equalTo(false));
            .metadata(Metadata.builder().put(writeIndex, false))
    }
        when(indexStats.getTotal()).thenReturn(totalStats);
        }
        );
 *
    }
    private IndexStats createIndexStats(long primaries, long total) {
        );
            .build();
            .putAlias(AliasMetadata.builder("logs-alias").writeIndex(true).build())
            .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.REMOTE_SNAPSHOT.getSettingsKey())
            }
        String indexName = randomAlphaOfLengthBetween(5, 7);
                    .withLocalSubActions(CreateIndexAction.INSTANCE, ResolvedIndices.Local.of("explicit-index")),
        MaxAgeCondition maxAgeCondition = new MaxAgeCondition(TimeValue.timeValueHours(randomIntBetween(1, 3)));
import static org.mockito.Mockito.when;
        String dataStreamName = "logs-ds";
    }
        // For given alias, verify that the condition evaluation is successful when condition doc count is less than the primaries doc count
        final Client mockClient = mock(Client.class);
    public void testCheckBlockAbortsWhenRemoteSnapshotHasUserReadOnlyBlock() {
        final ArgumentCaptor<Condition.Stats> argument = ArgumentCaptor.forClass(Condition.Stats.class);
        String alias = "logs-alias";
        // Then: aborts naming the write backing — symmetry with the alias write-index-blocked case.
            );
        // Alias#getWriteIndex() return null; a single non-write member is implicitly the write index.)
            .blocks(ClusterBlocks.builder().addIndexBlock(writeIndexName, IndexMetadata.INDEX_METADATA_BLOCK).build())
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        // Given: a remote_snapshot write index with a user-set INDEX_READ_ONLY_SETTING.
            mock(TransportService.class),
        final Settings settings = Settings.builder()
        long matchMaxDocs = randomIntBetween(100, 1000);
        ClusterService clusterService = mock(ClusterService.class);
import org.opensearch.core.common.unit.ByteSizeValue;
            threadPool,
                fail("unknown condition result found " + entry.getKey());
import org.opensearch.index.warmer.WarmerStats;
        // Then: returns a ClusterBlockException naming only the write index
            }
import static org.mockito.Mockito.any;
        final IndicesStatsResponse response = mock(IndicesStatsResponse.class);
                assertThat(entry.getValue(), equalTo(false));
        }
    }
import java.util.ArrayList;
            .numberOfShards(1)
        IndexMetadata.Builder indexMetadata = IndexMetadata.builder("logs-index-000001")
        ClusterState baseState = DataStreamTestHelper.getClusterStateWithDataStreams(
        ThreadPool threadPool = mock(ThreadPool.class);
    }
            .put(settings(Version.CURRENT).build())
        IndexMetadata blockedNonWriteMember = IndexMetadata.builder(nonWriteMember)
            .creationDate(System.currentTimeMillis() - TimeValue.timeValueHours(randomIntBetween(5, 10)).getMillis())
        final CommonStats primariesCommonStats = mock(CommonStats.class);
            .numberOfReplicas(1)
        // Then: returns null (the implicit remote_snapshot block is exempted)
        assertThat(result.getMessage(), containsString(writeBacking));
        ClusterState state = ClusterState.builder(ClusterName.DEFAULT)
                );
        IndexMetadata writeIndex = IndexMetadata.builder(writeIndexName)
                ShardRouting shardRouting = ShardRouting.newUnassigned(
            .build();
        // When: checkBlock runs for a rollover targeting the data stream
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
import org.opensearch.index.IndexModule;
        Settings remoteSnapshotSettings = Settings.builder()
                CommonStats stats = new CommonStats();
        // Then: aborts naming the write index (user opted in to read-only)
    }
            new DocsStats.Builder().count(matchMaxDocs).deleted(0L).totalSizeInBytes(ByteSizeUnit.MB.toBytes(120)).build(),
            );
import org.opensearch.index.flush.FlushStats;
import org.opensearch.index.get.GetStats;
            threadPool,
import org.opensearch.index.merge.MergeStats;
        when(primariesCommonStats.getDocs()).thenReturn(
 */
        String nonWriteMember = "logs-000001";
import static org.mockito.Mockito.mock;
        when(mockIndexNameExpressionResolver.resolveDateMathExpression(any())).thenReturn("logs-index-000003");
            shardStats.toArray(new ShardStats[0]),
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import org.opensearch.common.collect.Tuple;
            .build();
        for (Map.Entry<String, Boolean> entry : results.entrySet()) {
        String writeIndexName = "logs-000002";
        transportRolloverAction.clusterManagerOperation(mock(Task.class), rolloverRequest, stateBefore, future);
                stats.get = new GetStats();
        String alias = "logs-alias";
            mock(TransportService.class),
        TransportRolloverAction action = newRolloverActionForCheckBlock(state);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
import org.opensearch.cluster.DataStreamTestHelper;
            when(response.getIndex(indexName)).thenReturn(indexStats.get(indexName));
import org.opensearch.action.admin.indices.create.CreateIndexAction;
        }
            .putAlias(AliasMetadata.builder("logs-alias").writeIndex(false).build())
            .build();
        String alias = "logs-alias";
import org.opensearch.transport.TransportService;
        // "rollover target [...] does not point to a write index" error.
        when(totalStats.getDocs()).thenReturn(
        when(response.getTotal()).thenReturn(totalStats);
import org.opensearch.Version;
                stats.queryCache = new QueryCacheStats();
 * specific language governing permissions and limitations
        MaxSizeCondition maxSizeCondition = new MaxSizeCondition(new ByteSizeValue(randomIntBetween(10, 100), ByteSizeUnit.MB));
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
        assertThat(response.getConditionStatus().size(), equalTo(1));
            threadPool,
        MaxAgeCondition maxAgeCondition = new MaxAgeCondition(TimeValue.timeValueHours(2));
        );
 *
import java.util.List;
import org.opensearch.index.store.StoreStats;
        ClusterState state = ClusterState.builder(ClusterName.DEFAULT)
            .metadata(Metadata.builder().put(writeIndex, false))
        assertThat(result.getMessage(), containsString(writeIndexName));
            .metadata(Metadata.builder().put(writeIndex, false))
            mockThreadPool,
        // That's an intentional read-only block, so the precheck must still abort.
        assertThat(result, is(nullValue()));
            .build();
        // Then: returns null (defers to main path's canonical "not found" error)
            .creationDate(System.currentTimeMillis() - TimeValue.timeValueHours(3).getMillis())
    }
    }
            .settings(settings(Version.CURRENT))
    public void testCheckBlockSkipsBlockOnNonWriteAliasMember() {
        ClusterState state = ClusterState.builder(ClusterName.DEFAULT)
        ClusterBlockException result = action.checkBlock(new RolloverRequest(alias, null), state);
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.cluster.block.ClusterBlockException;
        TransportRolloverAction action = new TransportRolloverAction(
        long docsInPrimaryShards = 100;
            assert args.length == 3;
        MaxDocsCondition maxDocsCondition = new MaxDocsCondition(100L);
        ClusterState state = ClusterState.builder(ClusterName.DEFAULT)
        {
import org.opensearch.index.fielddata.FieldDataStats;
        // precheck should defer (parity with ClusterBlocks#indicesWithRemoteSnapshotBlockedException).
        ClusterState state = ClusterState.builder(ClusterName.DEFAULT).metadata(Metadata.builder()).build();
import org.opensearch.action.support.PlainActionFuture;
import org.opensearch.cluster.routing.UnassignedInfo;
        assertThat(response.isRolledOver(), equalTo(false));
            conditions,
        IndexMetadata writeIndex = IndexMetadata.builder(writeIndexName)
        MetadataRolloverService rolloverService = new MetadataRolloverService(
                    shardId,
import static org.opensearch.action.admin.indices.rollover.TransportRolloverAction.evaluateConditions;
                stats.docs = new DocsStats();
        {
            ResolvedIndices resolvedIndices = action.resolveIndices(new RolloverRequest("logs-alias", null));
        MaxDocsCondition maxDocsCondition = new MaxDocsCondition(randomNonNegativeLong());
        // Given: an alias whose write index is a remote_snapshot. Such indices come with
        MaxSizeCondition maxSizeCondition = new MaxSizeCondition(new ByteSizeValue(randomNonNegativeLong()));
    public void testResolveIndices() {
            new DocsStats.Builder().count(matchMaxDocs).deleted(0L).totalSizeInBytes(ByteSizeUnit.MB.toBytes(120)).build(),
        // (primaries from only write index is considered)
            .numberOfShards(1)
import org.opensearch.threadpool.ThreadPool;
        MetadataRolloverService rolloverService = new MetadataRolloverService(
import static org.hamcrest.Matchers.containsString;
    }
            .build();
            .build();
        final MetadataCreateIndexService mockCreateIndexService = mock(MetadataCreateIndexService.class);
            conditions,
        assertThat(result, is(nullValue()));
        final IndexMetadata metadata = IndexMetadata.builder(randomAlphaOfLength(10))
            .build();
import org.opensearch.cluster.routing.ShardRouting;
            .settings(settings)
import java.util.Map;
            .build();
            null
        for (Map.Entry<String, Boolean> entry : results.entrySet()) {
            .numberOfReplicas(1)
                        .build()
import org.opensearch.cluster.metadata.MetadataCreateIndexService;
        List<org.opensearch.core.index.Index> backings = baseState.metadata().dataStreams().get(dataStreamName).getIndices();
            .build();
        when(mdIndexAliasesService.applyAliasActions(any(), any())).thenReturn(stateBefore);
            .build();
            mockIndexNameExpressionResolver,
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, randomIntBetween(1, 1000))
            for (int i = 0; i < numShards; i++) {
        // When: checkBlock runs
            .build();
            mdIndexAliasesService,
import org.opensearch.index.shard.DocsStats;
            mock(MetadataIndexAliasesService.class),
            mockActionFilters,
        when(mockClusterService.localNode()).thenReturn(mockNode);
                stats.requestCache = new RequestCacheStats();
        rolloverRequest = new RolloverRequest("logs-alias", "logs-index-000003");
        assertThat(results.size(), equalTo(3));
        assertThat(results.size(), equalTo(3));
        MetadataIndexAliasesService metadataIndexAliasesService = mock(MetadataIndexAliasesService.class);
        IndexMetadata writeIndex = IndexMetadata.builder(writeIndexName)
            .build();
}
import org.opensearch.common.settings.Settings;
        IndexNameExpressionResolver resolver = new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY));
            } else {
        when(response.getPrimaries()).thenReturn(primaryStats);
                assertThat(entry.getValue(), equalTo(true));
        ClusterBlockException result = action.checkBlock(new RolloverRequest(alias, null), state);
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
        assertThat(response.getConditionStatus().get("[max_docs: 500]"), is(false));
import org.opensearch.common.util.concurrent.ThreadContext;
            .numberOfReplicas(1)
        String writeIndexName = "logs-000002";
            .blocks(ClusterBlocks.builder().addIndexBlock(writeBacking, IndexMetadata.INDEX_METADATA_BLOCK).build())
    public void testConditionEvaluationWhenAliasToWriteAndReadIndicesConsidersOnlyPrimariesFromWriteIndex() throws Exception {
            indexNameExpressionResolver
        TransportRolloverAction action = newRolloverActionForCheckBlock(state);
    }
                stats.fieldData = new FieldDataStats();
        future = new PlainActionFuture<>();
    public void testCheckBlockReturnsNullWhenRolloverTargetUnresolvable() {
                assertThat(entry.getValue(), equalTo(true));
        indexStats.put("logs-index-000002", createIndexStats(300L, total));
            .build();
                Path path = createTempDir().resolve("indices").resolve(index.getIndexUUID()).resolve(String.valueOf(i));
