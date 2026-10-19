        assertThat(response.getNewIndex(), equalTo("logs-index-000003"));
        {
import static org.mockito.Mockito.eq;
            List.of()  
import org.opensearch.cluster.metadata.ResolvedIndices;
            .numberOfReplicas(1);
import org.opensearch.core.index.shard.ShardId;
            List.of(new Tuple<>(dataStreamName, generations)),
            mock(Client.class)  
                stats.flush = new FlushStats();
import static org.hamcrest.Matchers.notNullValue;  
            .numberOfShards(1)
            shardStats.size(),  
        IndexMetadata writeIndex = IndexMetadata.builder(writeIndexName)
        MaxSizeCondition maxSizeCondition = new MaxSizeCondition(new ByteSizeValue(randomNonNegativeLong()));
        );
        // "rollover target [...] does not point to a write index" error.
    }
        String writeIndexName = "logs-000002";
    }  
            .settings(remoteSnapshotSettings)  
        List<ShardStats> shardStats = new ArrayList<>();
        return response;
        when(clusterService.state()).thenReturn(state);
    }
            .settings(settings)  
    }
        IndexStats indexStats = mock(IndexStats.class);
        Settings remoteSnapshotSettings = Settings.builder()  
        );
            threadPool,  
        // Then: returns null (the bug fix — non-write member is irrelevant)
        when(mockNode.getId()).thenReturn("mocknode");  
        }).when(mockClient).execute(eq(IndicesStatsAction.INSTANCE), any(ActionRequest.class), any(ActionListener.class));
        when(mockClusterService.localNode()).thenReturn(mockNode);
    public static IndicesStatsResponse randomIndicesStatsResponse(final IndexMetadata[] indices) {
            .build();
            } else if (entry.getKey().equals(maxSizeCondition.toString())) {  
        TransportRolloverAction action = newRolloverActionForCheckBlock(state);
        return condition;
        for (Map.Entry<String, Boolean> entry : results.entrySet()) {
            metadataRolloverService,  
            .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.REMOTE_SNAPSHOT.getSettingsKey())
            .build();  
            .build();
/*
import static org.hamcrest.Matchers.is;
            .blocks(ClusterBlocks.builder().addIndexBlock(writeIndexName, IndexMetadata.INDEX_METADATA_BLOCK).build())
                resolvedIndices  
        final IndexMetadata metadata = IndexMetadata.builder(randomAlphaOfLength(10))  
            .build();
        }
        // Given: an alias with members but none marked is_write_index=true.
            when(response.getIndex(indexName)).thenReturn(indexStats.get(indexName));
        );
            if (entry.getKey().equals(maxAgeCondition.toString())) {
                );  
            emptyList()
        // precheck should defer (parity with ClusterBlocks#indicesWithRemoteSnapshotBlockedException).
        );
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        RolloverResponse response = future.actionGet();
                        .retentionLeaseStats(null)  
        when(primaryStats.getDocs()).thenReturn(
        MetadataCreateIndexService createIndexService = mock(MetadataCreateIndexService.class);
            .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.REMOTE_SNAPSHOT.getSettingsKey())
            .settings(settings(Version.CURRENT))
import org.opensearch.common.util.set.Sets;
            resolver,
            .build();
            conditions,
            }
        );  
        ClusterBlockException result = action.checkBlock(new RolloverRequest(dataStreamName, null), state);
        final Condition<?> condition = createTestCondition();
        // Then: aborts naming the write backing — symmetry with the alias write-index-blocked case.
        MetadataRolloverService metadataRolloverService = new MetadataRolloverService(
            .build();
            for (int i = 0; i < numShards; i++) {  
    public void testEvaluateWithoutDocStats() {
                    shardId,
    }  
            .settings(settings(Version.CURRENT))  
import org.opensearch.cluster.ClusterState;
            .numberOfReplicas(1)  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertThat(results.size(), equalTo(3));  
        ThreadPool threadPool = mock(ThreadPool.class);
            mockTransportService,  
        IndexMetadata.Builder indexMetadata = IndexMetadata.builder("logs-index-000001")
            null
            .build();
        ClusterState state = ClusterState.builder(ClusterName.DEFAULT)  
        final Client mockClient = mock(Client.class);  
        IndexMetadata.Builder indexMetadata2 = IndexMetadata.builder("logs-index-000002")  
            // matching the level CCR's INDEX_REPLICATION_BLOCK uses.
import org.opensearch.cluster.metadata.IndexMetadata;  
        TransportRolloverAction action = newRolloverActionForCheckBlock(state);
        );  
            metadata
        );
import org.opensearch.index.search.stats.SearchStats;  
        assertThat(response.isRolledOver(), equalTo(false));
        );
            assertEquals(  
            mockCreateIndexService,
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
import org.opensearch.test.OpenSearchTestCase;
        // When: checkBlock runs
        when(indexStats.getTotal()).thenReturn(totalCommonStats);  
            .putAlias(AliasMetadata.builder(alias).writeIndex(true).build())
        final IndicesStatsResponse response = mock(IndicesStatsResponse.class);
            new DocsStats.Builder().count(matchMaxDocs).deleted(0L).totalSizeInBytes(ByteSizeUnit.MB.toBytes(120)).build(),  
import org.opensearch.index.cache.request.RequestCacheStats;
            totalStats.add(indexStats.get(indexName).getTotal());  
        );
import org.opensearch.index.warmer.WarmerStats;
            ResolvedIndices resolvedIndices = action.resolveIndices(new RolloverRequest("logs-alias", "explicit-index"));
        String alias = "logs-alias";
import org.opensearch.action.admin.indices.create.CreateIndexAction;  
            .build();  
            .numberOfReplicas(1);
        // When: checkBlock runs
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.Version;
            .numberOfShards(1)  
    private IndicesStatsResponse createIndicesStatResponse(String indexName, long totalDocs, long primariesDocs) {
        results2.forEach((k, v) -> assertFalse(v));
            .putAlias(AliasMetadata.builder(alias).writeIndex(false).build())
            mockThreadPool,
            rolloverService,
            .metadata(Metadata.builder().put(writeIndex, false))  
import org.opensearch.common.collect.Tuple;  
        final Settings settings = Settings.builder()
import static org.mockito.Mockito.when;
        ClusterBlockException result = action.checkBlock(new RolloverRequest(alias, null), state);
        }
        final Condition<?> condition = mock(Condition.class);  
import org.opensearch.action.admin.indices.stats.IndicesStatsAction;  
        TransportRolloverAction action = new TransportRolloverAction(  
            .blocks(ClusterBlocks.builder().addIndexBlock(writeIndexName, IndexMetadata.INDEX_METADATA_BLOCK).build())
        IndexNameExpressionResolver indexNameExpressionResolver = new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY));
        // (regression guard for the still-correct abort path)
        assertEquals(docsInPrimaryShards, argument.getValue().numDocs);
            mockIndexNameExpressionResolver  
        final Map<String, IndexStats> indexStats = new HashMap<>();
        ThreadPool threadPool = mock(ThreadPool.class);  
        );
            .numberOfShards(1)
                        .commitStats(null)
            new DocsStats.Builder().count(primariesDocs).deleted(0).totalSizeInBytes(between(1, 10000)).build()
        rolloverRequest = new RolloverRequest("logs-alias", "logs-index-000003");
            .build();
                stats.get = new GetStats();  
        Map<String, Boolean> results = evaluateConditions(conditions, null, metadata);
                stats.completion = new CompletionStats();
 * this file be licensed under the Apache-2.0 license or a
        ClusterState stateBefore = ClusterState.builder(ClusterName.DEFAULT)
            }
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        // Then: aborts naming the write index (user opted in to read-only)
        ClusterBlockException result = action.checkBlock(new RolloverRequest(alias, null), state);
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())  
            .settings(settings(Version.CURRENT))  
        IndexMetadata writeIndex = IndexMetadata.builder(writeIndexName)
 * not use this file except in compliance with the License.
        ClusterState baseState = DataStreamTestHelper.getClusterStateWithDataStreams(
        TransportRolloverAction action = newRolloverActionForCheckBlock(state);
 * Unless required by applicable law or agreed to in writing,
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
import org.opensearch.common.unit.TimeValue;
            }
    }
        when(response.getPrimaries()).thenReturn(primariesStats);  
            .putAlias(AliasMetadata.builder("logs-alias").writeIndex(false).build())
            .settings(settings(Version.CURRENT))
            mdIndexAliasesService,
        // Then: returns null (the implicit remote_snapshot block is exempted)
        doAnswer(invocation -> {
            } else if (entry.getKey().equals(maxDocsCondition.toString())) {
            conditions,
        TransportRolloverAction action = newRolloverActionForCheckBlock(state);  
            mock(Client.class)
    private IndicesStatsResponse createAliasToMultipleIndicesStatsResponse(Map<String, IndexStats> indexStats) {
            createMetadata(indexName),
                stats.indexing = new IndexingStats();
        final IndicesStatsResponse statsResponse = createAliasToMultipleIndicesStatsResponse(indexStats);  
import org.opensearch.cluster.DataStreamTestHelper;
import static org.mockito.Mockito.anyBoolean;  
        String alias = "logs-alias";
            .metadata(Metadata.builder().put(indexA, false).put(indexB, false))
            metadata  
            threadPool,  
            .build();
            .numberOfReplicas(1)
import org.opensearch.index.shard.ShardPath;  
            shardStats.size(),
        final ClusterState stateBefore = ClusterState.builder(ClusterName.DEFAULT)
import org.opensearch.common.util.concurrent.ThreadContext;  
        when(indexStats.getTotal()).thenReturn(totalStats);
import org.opensearch.cluster.block.ClusterBlocks;
import org.opensearch.action.support.PlainActionFuture;
import org.opensearch.index.engine.SegmentsStats;  
    public void testConditionEvaluationWhenAliasToWriteAndReadIndicesConsidersOnlyPrimariesFromWriteIndex() throws Exception {
    }  
            .put(IndexMetadata.SETTING_READ_ONLY, true)
        final IndexStats indexStats = mock(IndexStats.class);
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
        when(condition.evaluate(any())).thenReturn(new Condition.Result(condition, true));
        PlainActionFuture<RolloverResponse> future = new PlainActionFuture<>();
        final TransportRolloverAction transportRolloverAction = new TransportRolloverAction(
import org.opensearch.cluster.routing.UnassignedInfo;  
        assertThat(results.size(), equalTo(3));
        String writeIndexName = "logs-000002";
import org.opensearch.index.IndexModule;  
            .creationDate(System.currentTimeMillis() - TimeValue.timeValueHours(randomIntBetween(5, 10)).getMillis())
                shardRouting = shardRouting.initialize("node-0", null, ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE);
            .numberOfShards(1)
            mock(TransportService.class),
                stats.queryCache = new QueryCacheStats();
            List.of()
        String indexName = randomAlphaOfLengthBetween(5, 7);
        assertThat(result, is(nullValue()));
            listener.onResponse(statsResponse);  
        final CommonStats primariesCommonStats = mock(CommonStats.class);  
 * The OpenSearch Contributors require contributions made to  
        when(mdIndexAliasesService.applyAliasActions(any(), any())).thenReturn(stateBefore);
        final IndexMetadata metadata = IndexMetadata.builder(randomAlphaOfLength(10))
                shardRouting = shardRouting.moveToStarted();
        TransportRolloverAction action = newRolloverActionForCheckBlock(state);
    private IndexStats createIndexStats(long primaries, long total) {
import org.opensearch.cluster.service.ClusterService;
    public void testCheckBlockReturnsNullWhenAliasHasNoWriteMember() {
import static org.mockito.Mockito.doAnswer;
    private TransportRolloverAction newRolloverActionForCheckBlock(ClusterState state) {
        }
        ClusterBlockException result = action.checkBlock(new RolloverRequest(dataStreamName, null), state);  
    private static Condition<?> createTestCondition() {
        ClusterState state = ClusterState.builder(baseState)  
 * specific language governing permissions and limitations
            threadPool,  
 * under the License.  
        IndexMetadata indexB = IndexMetadata.builder(memberB)  
        // When: checkBlock runs
                ResolvedIndices.of("logs-alias")
import org.opensearch.index.refresh.RefreshStats;
        List<org.opensearch.core.index.Index> backings = baseState.metadata().dataStreams().get(dataStreamName).getIndices();
            shardStats.toArray(new ShardStats[0]),
        assertThat(result.getMessage(), containsString(writeIndexName));  
            clusterService,
        String memberB = "logs-000002";
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            } else {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
            .build();
        ClusterState baseState = DataStreamTestHelper.getClusterStateWithDataStreams(
        evaluateConditions(  
        final ArgumentCaptor<Condition.Stats> argument = ArgumentCaptor.forClass(Condition.Stats.class);
        return response;
        MaxDocsCondition maxDocsCondition = new MaxDocsCondition(100L);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.cluster.block.ClusterBlockException;  
        // When: checkBlock runs  
        assertThat(response.getConditionStatus().get("[max_docs: 500]"), is(false));
                    .withLocalSubActions(CreateIndexAction.INSTANCE, ResolvedIndices.Local.of("logs-index-000003")),
                stats.warmer = new WarmerStats();
        final DiscoveryNode mockNode = mock(DiscoveryNode.class);
 * You may obtain a copy of the License at  
            .settings(settings)
        assertThat(response.getConditionStatus().size(), equalTo(1));
            mockClient  
        assertThat(response.getConditionStatus().size(), equalTo(1));
            .putAlias(AliasMetadata.builder("logs-alias").writeIndex(true).build())
        {
            .settings(settings)
    public void testEvaluateWithoutMetadata() {
        future = new PlainActionFuture<>();  
        }
            .creationDate(System.currentTimeMillis() - TimeValue.timeValueHours(3).getMillis())  
        // For given alias, verify that the condition evaluation is successful when condition doc count is less than the primaries doc count
    }  
            .settings(settings(Version.CURRENT))
import org.opensearch.index.cache.query.QueryCacheStats;
            .putAlias(AliasMetadata.builder("logs-alias").writeIndex(true).build())
                assertThat(entry.getValue(), equalTo(false));
        transportRolloverAction.clusterManagerOperation(mock(Task.class), rolloverRequest, stateBefore, future);  
 * GitHub history for details.
                );  
        }
            .putAlias(AliasMetadata.builder(alias).writeIndex(true).build())
                        .commonStats(stats)  
            );
            .build();
        long docsInShards = 200;
            indexNameExpressionResolver  
 * SPDX-License-Identifier: Apache-2.0
        ClusterBlockException result = action.checkBlock(new RolloverRequest("does-not-exist", null), state);
                assertThat(entry.getValue(), equalTo(false));
            mock(ActionFilters.class),  
    public void testCheckBlockSkipsRemoteSnapshotWriteIndexWithoutUserReadOnlyBlock() {
            .numberOfShards(1)  
                        .seqNoStats(null)
        // When: checkBlock runs for a rollover targeting the data stream
import static org.mockito.Mockito.mock;  
    }  
            .settings(settings)  
                    new ShardStats.Builder().shardRouting(shardRouting)
                fail("unknown condition result found " + entry.getKey());  
                ShardRouting shardRouting = ShardRouting.newUnassigned(
            mock(ActionFilters.class),
            clusterService,
            .blocks(ClusterBlocks.builder().addIndexBlock(olderBacking, IndexMetadata.INDEX_METADATA_BLOCK).build())
                fail("unknown condition result found " + entry.getKey());  
        IndicesStatsResponse indicesStats = randomIndicesStatsResponse(new IndexMetadata[] { metadata });
        when(mockCreateIndexService.applyCreateIndexRequest(any(), any(), anyBoolean())).thenReturn(stateBefore);  
            mockThreadPool,  
            .settings(settings(Version.CURRENT))  
import java.util.HashMap;  
        long matchMaxDocs = randomIntBetween(100, 1000);
import org.opensearch.search.suggest.completion.CompletionStats;  
        TransportRolloverAction action = newRolloverActionForCheckBlock(state);
        MetadataIndexAliasesService metadataIndexAliasesService = mock(MetadataIndexAliasesService.class);  
            .numberOfReplicas(1)  
        final Set<Condition<?>> conditions = Sets.newHashSet(maxDocsCondition, maxAgeCondition, maxSizeCondition);
        MetadataRolloverService rolloverService = new MetadataRolloverService(
        final Settings settings = Settings.builder()
        // Write backing is the highest-generation index — the last in the indices list.
        // When: checkBlock runs for a rollover targeting the data stream
            mockActionFilters,  
            .metadata(Metadata.builder().put(writeIndex, false))
        Map<String, Boolean> results2 = evaluateConditions(conditions, null, indicesStats);  
        RolloverRequest rolloverRequest = new RolloverRequest("logs-alias", "logs-index-000003");  
        assertThat(result, is(nullValue()));
        long matchMaxDocs = randomIntBetween(100, 1000);
            .numberOfShards(1)  
                stats.fieldData = new FieldDataStats();
 * compatible open source license.
        Settings remoteSnapshotSettings = Settings.builder()
        String writeIndexName = "logs-000002";
                stats.segments = new SegmentsStats();
    }
        // (primaries from only write index is considered)
                stats.search = new SearchStats();  
        }
        // Given: a data stream where the write (highest-generation) backing carries a METADATA_WRITE block
    }
        String dataStreamName = "logs-ds";
            .putAlias(AliasMetadata.builder(alias).writeIndex(false).build())
                ShardId shardId = new ShardId(index.getIndex(), i);
            threadPool,
    public void testCheckBlockReturnsNullWhenRolloverTargetUnresolvable() {  
            Object[] args = invocation.getArguments();  
import org.opensearch.cluster.metadata.MetadataCreateIndexService;  
        return indexStats;
            .build();  
 * software distributed under the License is distributed on an
        when(totalCommonStats.getDocs()).thenReturn(  
        for (String indexName : indexStats.keySet()) {  
        final IndicesStatsResponse response = mock(IndicesStatsResponse.class);  
            // INDEX_WRITE_BLOCK has level WRITE only and would not trip checkBlock's METADATA_WRITE
        rolloverRequest.addMaxIndexDocsCondition(300L);
            if (entry.getKey().equals(maxAgeCondition.toString())) {
    }  
        ClusterBlockException result = action.checkBlock(new RolloverRequest(alias, null), state);
        assertThat(response.getNewIndex(), equalTo("logs-index-000003"));
import org.opensearch.index.store.StoreStats;
            .numberOfReplicas(1)  
        MaxAgeCondition maxAgeCondition = new MaxAgeCondition(TimeValue.timeValueHours(2));
import static org.hamcrest.Matchers.nullValue;
        String writeIndexName = "logs-000002";  
            .putAlias(AliasMetadata.builder(alias).writeIndex(true).build())
        final ClusterService mockClusterService = mock(ClusterService.class);
            .build();  
            List.of(new Tuple<>(dataStreamName, generations)),  
        // (not the write backing) has a METADATA_WRITE block  
import org.opensearch.cluster.metadata.MetadataIndexAliasesService;
                    .withLocalSubActions(CreateIndexAction.INSTANCE, ResolvedIndices.Local.of("explicit-index")),
import org.opensearch.action.support.ActionFilters;
            .build();
import org.opensearch.index.flush.FlushStats;
        MaxAgeCondition maxAgeCondition = new MaxAgeCondition(TimeValue.timeValueHours(randomIntBetween(1, 3)));
        when(response.getTotal()).thenReturn(totalStats);  
import org.opensearch.common.settings.Settings;
        assertThat(response.getConditionStatus().get("[max_docs: 300]"), is(true));  
import org.opensearch.common.UUIDs;
import static org.hamcrest.Matchers.equalTo;
                boolean primary = (i == primaryIdx);
    public void testCheckBlockAbortsWhenWriteIndexHasMetadataWriteBlock() {
        indexStats.put("logs-index-000001", createIndexStats(200L, total));
            .build();
import org.opensearch.tasks.Task;
            return null;
            .numberOfReplicas(1)
        assertThat(result, is(nullValue()));
/*  
import org.opensearch.cluster.node.DiscoveryNode;  
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
        // Given: an alias whose write index is a remote_snapshot. Such indices come with  
        final CommonStats totalStats = new CommonStats();
        when(response.getPrimaries()).thenReturn(primaryStats);
        when(indexStats.getPrimaries()).thenReturn(primaryStats);  
import org.opensearch.threadpool.ThreadPool;  
        when(primariesCommonStats.getDocs()).thenReturn(
            .blocks(ClusterBlocks.builder().addIndexBlock(nonWriteMember, IndexMetadata.INDEX_METADATA_BLOCK).build())
        assertThat(results.size(), equalTo(3));  
import org.opensearch.transport.client.Client;
        assert statsResponse.getTotal().getDocs().getCount() == (total + total);
            .creationDate(System.currentTimeMillis() - TimeValue.timeValueHours(3).getMillis())
                stats.docs = new DocsStats();  
        TransportRolloverAction action = newRolloverActionForCheckBlock(state);
            assertEquals(  
        when(totalStats.getDocs()).thenReturn(  
import org.opensearch.index.fielddata.FieldDataStats;
        assertThat(result, is(nullValue()));  
 *
        // That's an intentional read-only block, so the precheck must still abort.
import static java.util.Collections.emptyList;
        MaxSizeCondition maxSizeCondition = new MaxSizeCondition(new ByteSizeValue(randomIntBetween(10, 100), ByteSizeUnit.MB));
            int primaryIdx = randomIntBetween(-1, numShards - 1); // -1 means there is no primary shard.
                    new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, null)
        final IndexMetadata metadata = IndexMetadata.builder(randomAlphaOfLength(10))
        MaxSizeCondition maxSizeCondition = new MaxSizeCondition(new ByteSizeValue(randomIntBetween(10, 100), ByteSizeUnit.MB));
        assertThat(result.getMessage(), containsString(writeBacking));
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            createIndicesStatResponse(indexName, docsInShards, docsInPrimaryShards)  
        long notMatchMaxDocs = randomIntBetween(0, 99);
            new DocsStats.Builder().count(primaries).deleted(0).totalSizeInBytes(between(1, 10000)).build()
            int numShards = randomIntBetween(1, 3);
            .metadata(Metadata.builder().put(writeIndex, false).put(blockedNonWriteMember, false))
import org.opensearch.index.shard.IndexingStats;
import org.opensearch.cluster.routing.ShardRouting;
            .metadata(Metadata.builder().put(indexMetadata).put(indexMetadata2))  
        assertThat(response.isDryRun(), equalTo(true));
            primariesStats.add(indexStats.get(indexName).getPrimaries());
        rolloverRequest.addMaxIndexDocsCondition(500L);
 * license agreements. See the NOTICE file distributed with
        );
import org.opensearch.cluster.routing.RecoverySource;
        for (Boolean matched : results.values()) {  
 * the Apache License, Version 2.0 (the "License"); you may
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, randomIntBetween(1, 1000))  
                resolvedIndices  
            indexNameExpressionResolver,
        MaxDocsCondition maxDocsCondition = new MaxDocsCondition(randomNonNegativeLong());  
                stats.refresh = new RefreshStats();  
        when(threadPool.getThreadContext()).thenReturn(new ThreadContext(Settings.EMPTY));  
import java.util.Set;  
        // Then: returns a ClusterBlockException naming only the write index
        when(indexStats.getPrimaries()).thenReturn(primariesCommonStats);
import org.opensearch.index.get.GetStats;  
        // (Multiple non-write members with no write member is the only shape that makes  
            Sets.newHashSet(condition),
                shardStats.add(  
 *    http://www.apache.org/licenses/LICENSE-2.0
                assertThat(entry.getValue(), equalTo(true));  
import org.opensearch.index.merge.MergeStats;
 */  
        when(threadPool.getThreadContext()).thenReturn(threadContext);
        }
            .build();
        // The write backing is the highest-generation index; older backings come first.  
        MaxAgeCondition maxAgeCondition = new MaxAgeCondition(TimeValue.timeValueHours(2));
        ClusterService clusterService = mock(ClusterService.class);  
 */
            .numberOfShards(1)
        );
        // Then: returns null (defers to main path's canonical "not found" error)  
        assert statsResponse.getPrimaries().getDocs().getCount() == 500L;
        assertThat(response.isDryRun(), equalTo(true));  
        return IndexMetadata.builder(indexName)
            .metadata(Metadata.builder().put(writeIndex, false))
    private static IndexMetadata createMetadata(String indexName) {
        );
        indexStats.put("logs-index-000002", createIndexStats(300L, total));
        final ActionFilters mockActionFilters = mock(ActionFilters.class);  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, randomInt(10))  
            .metadata(Metadata.builder().put(indexMetadata).put(indexMetadata2))  
import org.opensearch.core.action.ActionListener;
                    primary,  
        IndexMetadata writeIndex = IndexMetadata.builder(writeIndexName)
        ClusterState state = ClusterState.builder(ClusterName.DEFAULT)  
            .put(settings(Version.CURRENT).build())
        assertThat(results2.size(), equalTo(3));
            .build();  
    public void testCheckBlockAbortsWhenDataStreamWriteBackingBlocked() {  
            ResolvedIndices resolvedIndices = action.resolveIndices(new RolloverRequest("logs-alias", null));
import org.opensearch.cluster.metadata.Metadata;
            .settings(remoteSnapshotSettings)  
    }  
        int total = randomIntBetween(500, 1000);  
            );
        // alias member that carries a METADATA_WRITE block (CCR-style)  
        IndexNameExpressionResolver resolver = new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY));
                    primary ? RecoverySource.EmptyStoreRecoverySource.INSTANCE : RecoverySource.PeerRecoverySource.INSTANCE,
 * KIND, either express or implied.  See the License for the
                stats.requestCache = new RequestCacheStats();
import static org.mockito.Mockito.verify;
            conditions,
        final MetadataIndexAliasesService mdIndexAliasesService = mock(MetadataIndexAliasesService.class);
            .numberOfShards(1)
            createIndexService,
import java.nio.file.Path;
        ClusterState state = ClusterState.builder(ClusterName.DEFAULT).metadata(Metadata.builder()).build();
            .numberOfShards(1)  
                stats.merge = new MergeStats();
        // Then: returns null (data-stream parity with the alias case)
            .creationDate(System.currentTimeMillis() - TimeValue.timeValueHours(randomIntBetween(5, 10)).getMillis())
 */  
        // Given: an alias whose write index is unblocked, and a non-write
        final ThreadPool mockThreadPool = mock(ThreadPool.class);
            .build();  
            // probe; INDEX_METADATA_BLOCK is the closest standard constant that includes METADATA_WRITE,  
        final MetadataCreateIndexService mockCreateIndexService = mock(MetadataCreateIndexService.class);  
        return IndicesStatsTests.newIndicesStatsResponse(  
import java.util.List;
    public void testEvaluateConditions() {
import org.opensearch.action.ActionRequest;
        int generations = 2;  
            .put(settings(Version.CURRENT).build())  
        // Given: cluster state with no abstraction matching the rollover target
        rolloverRequest.dryRun(true);  
import java.util.Map;
            } else if (entry.getKey().equals(maxDocsCondition.toString())) {
        // For given alias, verify that condition evaluation fails when the condition doc count is greater than the primaries doc count  
        MaxDocsCondition maxDocsCondition = new MaxDocsCondition(100L);  
            .numberOfShards(1)
import java.util.ArrayList;
        IndexMetadata writeIndex = IndexMetadata.builder(writeIndexName)
        assertThat(response.getOldIndex(), equalTo("logs-index-000002"));  
        IndexMetadata blockedNonWriteMember = IndexMetadata.builder(nonWriteMember)
        Map<String, Boolean> results = evaluateConditions(  
 * this work for additional information regarding copyright
        int generations = 2;
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
        // Given: a remote_snapshot write index with a user-set INDEX_READ_ONLY_SETTING.  
            assertThat(matched, equalTo(true));
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, randomInt(10))
    }
        long docsInPrimaryShards = 100;
            .build();
        ClusterState state = ClusterState.builder(ClusterName.DEFAULT)
    }  
            .numberOfShards(1)
                        .pollingIngestStats(null)
import org.opensearch.core.common.unit.ByteSizeValue;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, randomIntBetween(1, 1000))
            ActionListener<IndicesStatsResponse> listener = (ActionListener<IndicesStatsResponse>) args[2];
    public void testDocStatsSelectionFromPrimariesOnly() {  
            new DocsStats.Builder().count(notMatchMaxDocs).deleted(0).totalSizeInBytes(notMatchMaxSize.getBytes()).build(),  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
 *  
    }  
        // (primaries from only write index is considered)
        when(response.getIndex(indexName)).thenReturn(indexStats);
        for (final IndexMetadata index : indices) {  
            .settings(settings(Version.CURRENT))  
        final Settings settings = Settings.builder()  
        final TransportService mockTransportService = mock(TransportService.class);  
            .blocks(ClusterBlocks.builder().addIndexBlock(writeBacking, IndexMetadata.INDEX_METADATA_BLOCK).build())  
            mockClusterService,
    }  
import org.opensearch.action.admin.indices.stats.IndicesStatsTests;
        );  
                        .build()
            .putAlias(AliasMetadata.builder(alias).writeIndex(true).build())  
        response = future.actionGet();  
            assert args.length == 3;
        );
        ClusterService clusterService = mock(ClusterService.class);  
        results.forEach((k, v) -> assertFalse(v));
        String writeBacking = backings.getLast().getName();  
        String memberA = "logs-000001";  
        assertThat(result, is(notNullValue()));  
        when(mockIndexNameExpressionResolver.resolveDateMathExpression(any())).thenReturn("logs-index-000003");
        // Given: an alias whose write index has a METADATA_WRITE block applied  
        final IndexNameExpressionResolver mockIndexNameExpressionResolver = mock(IndexNameExpressionResolver.class);
        ClusterState state = ClusterState.builder(baseState)
                        .shardPath(new ShardPath(false, path, path, shardId))
            .build();  
                ResolvedIndices.of("logs-alias")
        final CommonStats totalStats = mock(CommonStats.class);
        assertThat(result, is(nullValue()));
import org.opensearch.action.admin.indices.stats.ShardStats;  
        assertThat(results.size(), equalTo(3));
        final Settings settings = Settings.builder()
        final IndexMetadata.Builder indexMetadata2 = IndexMetadata.builder("logs-index-000002")  
        ClusterBlockException result = action.checkBlock(new RolloverRequest(alias, null), state);
            .numberOfReplicas(1);
            .settings(settings(Version.CURRENT))
package org.opensearch.action.admin.indices.rollover;
        final CommonStats totalCommonStats = mock(CommonStats.class);
        assertThat(response.isRolledOver(), equalTo(false));  
    }  
            .numberOfReplicas(1)  
            .numberOfReplicas(1)
import static org.hamcrest.Matchers.containsString;  
            .build();
            resolver  
        // Given: a data stream with multiple backing indices; an older backing
        Map<String, Boolean> results = evaluateConditions(
        when(clusterService.state()).thenReturn(stateBefore);
    }
        assertThat(result.getMessage(), containsString(writeIndexName));
            .putAlias(AliasMetadata.builder("logs-alias").writeIndex(false).build())
        when(response.getTotal()).thenReturn(totalStats);
import org.opensearch.action.admin.indices.stats.IndexStats;
            rolloverService,
        assertThat(result, is(notNullValue()));  
        final IndexMetadata.Builder indexMetadata = IndexMetadata.builder("logs-index-000001")
import static org.mockito.Mockito.any;
            metadataIndexAliasesService,
            0,
        // Alias#getWriteIndex() return null; a single non-write member is implicitly the write index.)
    public void testResolveIndices() {  
        ClusterState state = ClusterState.builder(ClusterName.DEFAULT)  
            mock(MetadataCreateIndexService.class),
import static org.opensearch.action.admin.indices.rollover.TransportRolloverAction.evaluateConditions;
            new DocsStats.Builder().count(total).deleted(0).totalSizeInBytes(between(1, 10000)).build()
        );
        assertThat(result, is(notNullValue()));
                assertThat(entry.getValue(), equalTo(true));  
        return new TransportRolloverAction(
    public void testCheckBlockSkipsBlockOnNonWriteAliasMember() {
                Path path = createTempDir().resolve("indices").resolve(index.getIndexUUID()).resolve(String.valueOf(i));  
        ClusterState state = ClusterState.builder(ClusterName.DEFAULT)
        ClusterBlockException result = action.checkBlock(new RolloverRequest(alias, null), state);
import org.mockito.ArgumentCaptor;
        IndexMetadata indexA = IndexMetadata.builder(memberA)  
        // When: checkBlock runs
            } else if (entry.getKey().equals(maxSizeCondition.toString())) {  
    }  
    public void testCheckBlockAbortsWhenRemoteSnapshotHasUserReadOnlyBlock() {
            mock(MetadataIndexAliasesService.class),
        for (Map.Entry<String, Boolean> entry : results.entrySet()) {
import org.opensearch.cluster.ClusterName;  
                assertThat(entry.getValue(), equalTo(false));
        verify(condition).evaluate(argument.capture());  
            .build();  
}
            .blocks(ClusterBlocks.builder().addIndexBlock(writeIndexName, IndexMetadata.INDEX_METADATA_BLOCK).build())
            .build();  
        results = evaluateConditions(
        assertThat(response.getOldIndex(), equalTo("logs-index-000002"));
        // an implicit METADATA_WRITE block; without a user-set read-only setting, the
            // INDEX_METADATA_BLOCK includes METADATA_WRITE level (see sibling test for rationale).
/*  
        final CommonStats primariesStats = new CommonStats();
        final Set<Condition<?>> conditions = Sets.newHashSet(maxDocsCondition, maxAgeCondition, maxSizeCondition);
    }
                stats.store = new StoreStats();
        transportRolloverAction.clusterManagerOperation(mock(Task.class), rolloverRequest, stateBefore, future);
            .numberOfReplicas(1);
        );
 * ownership. Elasticsearch licenses this file to you under  
            .settings(settings(Version.CURRENT))
        rolloverRequest.dryRun(true);
    public void testCheckBlockSkipsBlockOnNonWriteDataStreamBacking() {
import org.opensearch.action.admin.indices.stats.CommonStats;
        String alias = "logs-alias";
            // INDEX_METADATA_BLOCK includes METADATA_WRITE level (see sibling test for rationale).
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
public class TransportRolloverActionTests extends OpenSearchTestCase {
            .putAlias(AliasMetadata.builder(alias).writeIndex(false).build())
import org.opensearch.cluster.metadata.AliasMetadata;
 *
                CommonStats stats = new CommonStats();  
                assertThat(entry.getValue(), equalTo(false));
import org.opensearch.core.common.unit.ByteSizeUnit;  
        String alias = "logs-alias";
 * Modifications Copyright OpenSearch Contributors. See
        MetadataRolloverService rolloverService = new MetadataRolloverService(
        // Then: returns null — defers to MetadataRolloverService's canonical
        Set<Condition<?>> conditions = Sets.newHashSet(maxDocsCondition, maxAgeCondition, maxSizeCondition);
        String dataStreamName = "logs-ds";
            new DocsStats.Builder().count(matchMaxDocs).deleted(0L).totalSizeInBytes(ByteSizeUnit.MB.toBytes(120)).build(),
        // When: checkBlock runs for a rollover targeting the alias
            new DocsStats.Builder().count(totalDocs).deleted(0).totalSizeInBytes(between(1, 10000)).build()
            } else {
        String alias = "logs-alias";  
            .build();  
        final CommonStats primaryStats = mock(CommonStats.class);  
import org.opensearch.index.shard.DocsStats;
import org.opensearch.transport.TransportService;
            mock(TransportService.class),  
        ByteSizeValue notMatchMaxSize = new ByteSizeValue(randomIntBetween(0, 9), ByteSizeUnit.MB);  
        TransportRolloverAction action = newRolloverActionForCheckBlock(state);
        String olderBacking = baseState.metadata().dataStreams().get(dataStreamName).getIndices().getFirst().getName();
        String nonWriteMember = "logs-000001";  
            mockIndexNameExpressionResolver,
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .build();  
