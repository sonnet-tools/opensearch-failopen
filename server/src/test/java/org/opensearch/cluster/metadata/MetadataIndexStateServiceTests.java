        final ClusterService clusterService = mock(ClusterService.class);
            false,
                assertTrue(blockedIndices.containsKey(index));
            ClusterState state = addOpenedIndex("index-1", randomIntBetween(1, 3), randomIntBetween(0, 3), initialState);
        assertThat(
            final Map<Index, ClusterBlock> blockedIndices = new HashMap<>();
        );
        final TransportVerifyShardIndexBlockAction verifyShardIndexBlockAction = mock(TransportVerifyShardIndexBlockAction.class);
        Set<Index> disappearedIndices = new HashSet<>();
import org.opensearch.common.settings.Settings;
 * compatible open source license.
        final Set<Index> nonBlockedIndices = new HashSet<>();
    }
        final RestoreInProgress.Entry entry = new RestoreInProgress.Entry(
        {
import java.util.Map;
                if (randomBoolean()) {
        service.addIndexBlock(request, future);
        final IndexMetadata.State state,
    }
 */
            assertThat(exception.getMessage(), containsString("Cannot close indices that are being snapshotted: [[snapshotted]]"));
        final ClusterState currentState,
            return null;
                nonBlockedIndices.add(state.metadata().index(indexName).getIndex());
        for (int k = 0; k < indicesToDelete.size(); k++) {
        );
        assertEquals(blockedIndices.get(test), blockedIndices2.get(test));
        return ClusterState.builder(new ClusterName("testSearchOnlyClusterState"))
        }
        for (ShardRouting shardRouting : newState.routingTable().index(index).randomAllActiveShardsIt()) {
            Index[] indices = new Index[] { new Index("_name", "_uid") };
    }
                    .map(UnassignedInfo::getReason)
                    .put(SETTING_NUMBER_OF_REPLICAS, 0)
        {
        }
import static java.util.Collections.emptyMap;
 * KIND, either express or implied.  See the License for the
        assertIsOpened(index.getName(), updatedState);
        {
        final ThreadPool threadPool = mock(ThreadPool.class);
        Collection<IndexResult> closingResults = MetadataIndexStateService.closeRoutingTable(
    }
        }
            ClusterState state = addClosedIndex(indexName, randomIntBetween(1, 3), randomIntBetween(0, 3), initialState);
        assertThat(
            shardsBuilder.put(shardRouting.shardId(), new SnapshotsInProgress.ShardSnapshotStatus(shardRouting.currentNodeId(), "1"));
            if (results.get(blockedIndex).hasFailures() == false) {
import org.opensearch.cluster.ClusterStateUpdateTask;
        int numIndices = between(1, 10);
import org.opensearch.core.index.shard.ShardId;
/*
 * not use this file except in compliance with the License.
import org.opensearch.cluster.routing.IndexRoutingTable;
        final String indexName = "search-only";
import java.util.Collections;
import java.util.ArrayList;
import static java.util.Collections.singletonMap;
                Settings.builder()
        assertThat(updatedState.metadata().indices().size(), equalTo(nonBlockedIndices.size() + blockedIndices.size()));
                    state = addOpenedIndex("closed", randomIntBetween(1, 3), randomIntBetween(0, 3), state);
        final Index index = initialState.metadata().index(indexName).getIndex();
            Index index2 = state.metadata().index("index-2").getIndex();
        if (state == IndexMetadata.State.CLOSE) {
        final int numReplicas,
 *     http://www.apache.org/licenses/LICENSE-2.0
            assertSame(initialState, updatedState);
            RestoreInProgress.State.INIT,
        assertIsOpened(index.getName(), updatedState);
        for (Index blockedIndex : blockedIndices.keySet()) {
            settings.put(MetadataIndexStateService.VERIFIED_BEFORE_CLOSE_SETTING.getKey(), true);
 *
            indicesToDeleteArray[k] = indexToDelete;
                ClusterState state = addRestoredIndex("restored", randomIntBetween(1, 3), randomIntBetween(0, 3), initialState);
        final ClusterState updatedState = MetadataIndexStateService.closeRoutingTable(
        }
                    .allMatch(info -> info == UnassignedInfo.Reason.INDEX_CLOSED),
            final Map<Index, ClusterBlock> blockedIndices = new HashMap<>();
            singletonMap(index, new IndexResult(index))
import org.opensearch.repositories.IndexId;
    public void testAddIndexClosedBlocks() {
        }
        if (block != null) {
            Collections.emptyList(),
    }
            .build();
        state = ClusterState.builder(state).blocks(ClusterBlocks.builder().blocks(state.blocks()).addIndexBlock(indexName, block)).build();
            )
        when(threadPool.executor(ThreadPool.Names.MANAGEMENT)).thenReturn(OpenSearchExecutors.newDirectExecutorService());
        return clusterStateBuilder.build();
                        .put(SETTING_NUMBER_OF_REPLICAS, randomIntBetween(0, 3))
            final ClusterStateUpdateTask task = invocation.getArgument(1);
                .settings(
            Index[] indices = new Index[] { state.metadata().index("opened").getIndex(), state.metadata().index("closed").getIndex() };
        state = MetadataIndexStateService.addIndexClosedBlocks(indices, blockedIndices2, state);
            "Index " + indexName + " must have only 1 block with [id=" + MetadataIndexStateService.INDEX_CLOSED_BLOCK_ID + "]",
        final ClusterState initialState = ClusterState.builder(new ClusterName("testIsIndexMetadataClosed")).build();
            clusterState.blocks()
        Index[] indicesToDeleteArray = new Index[indicesToDelete.size()];
        final int numReplicas,
        CloseIndexClusterStateUpdateRequest request = new CloseIndexClusterStateUpdateRequest(0L).indices(indicesToDeleteArray);
        final ClusterState updatedState = MetadataIndexStateService.closeRoutingTable(state, blockedIndices, results).v1();
            }
        assertThat(updatedState.blocks().hasIndexBlockWithId(index.getName(), INDEX_CLOSED_BLOCK_ID), is(true));
                .indices()
        }
                if (randomBoolean()) {
        ClusterState state = ClusterState.builder(new ClusterName("testCloseRoutingTable")).build();
                .indices()
            CoreMatchers.containsString(
            equalTo(1L)
            shardsBuilder.put(shardRouting.shardId(), new RestoreInProgress.ShardRestoreStatus(shardRouting.currentNodeId()));
    }
    }
        assertTrue(blockedIndices.containsKey(test));
            Index index = state.metadata().index(indexName).getIndex();
                    .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)
        String indexName = "snapshotted-index";
import org.opensearch.cluster.routing.RoutingTable;
            String dataStreamName = randomAlphaOfLength(6).toLowerCase(Locale.ROOT);
                }
        }
            assertThat(exception.getMessage(), containsString("Cannot close indices that are being restored: [[restored]]"));
        int numDataStreams = randomIntBetween(1, 3);
                        .put(SETTING_NUMBER_OF_SHARDS, randomIntBetween(1, 3))
import static org.mockito.ArgumentMatchers.anyString;
import static org.opensearch.cluster.metadata.MetadataIndexStateService.INDEX_CLOSED_BLOCK_ID;
            });
        );
    ) {
        final Index index = state.metadata().index(indexName).getIndex();
                .getOrDefault(indexName, emptySet())
        Exception e = expectThrows(IllegalArgumentException.class, () -> service.closeIndices(request, null));
        final String index,
                        .put(SETTING_VERSION_CREATED, Version.CURRENT)
        assertThat(clusterState.routingTable().index(indexName), notNullValue());
            for (Index index : indices) {
public class MetadataIndexStateServiceTests extends OpenSearchTestCase {
            clusterStateBuilder.blocks(ClusterBlocks.builder().blocks(currentState.blocks()).addIndexBlock(index, block));
        final String index,
                .stream()
            state,
        return ClusterState.builder(newState).putCustom(RestoreInProgress.TYPE, new RestoreInProgress.Builder().add(entry).build()).build();
            assertTrue(blockedIndices.isEmpty());
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.admin.indices.datastream.DeleteDataStreamRequestTests;
        assertThat(failedIndices, equalTo(disappearedIndices));
            final Map<Index, ClusterBlock> blockedIndices = new HashMap<>();
        for (Index nonBlockedIndex : nonBlockedIndices) {
            .map(IndexResult::getIndex)
        final Snapshot snapshot = new Snapshot(randomAlphaOfLength(10), new SnapshotId(randomAlphaOfLength(5), randomAlphaOfLength(5)));
    private static ClusterState addBlockedIndex(
import static org.hamcrest.Matchers.notNullValue;
                    .put(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), true)
        assertFalse(response.getIndices().get(0).hasFailures());
                MetadataIndexStateService.addIndexClosedBlocks(indices, unmodifiableMap(emptyMap()), state);
            .collect(Collectors.toSet());
}
        assertThat(clusterState.blocks().hasIndexBlock(indexName, closingBlock), is(true));
    private static ClusterState searchOnlyClusterState(final String indexName) {
 * The OpenSearch Contributors require contributions made to
import org.opensearch.cluster.routing.IndexShardRoutingTable;
 *
            Index index1 = state.metadata().index("index-1").getIndex();
        for (IndexShardRoutingTable shardRoutingTable : indexRoutingTable) {
import org.opensearch.snapshots.SnapshotId;
            Index index3 = state.metadata().index("index-3").getIndex();
 */
import static org.mockito.Mockito.verifyNoInteractions;
            assertThat(
            null,
        ClusterBlock block = MetadataIndexStateService.createIndexClosingBlock();
            ClusterState updatedState = MetadataIndexStateService.addIndexClosedBlocks(indices, blockedIndices, state);
            Index closed = updatedState.metadata().index("closed").getIndex();
import org.opensearch.common.Nullable;
            shardsBuilder,
        );
            clusterState.blocks()
        verifyNoInteractions(verifyShardIndexBlockAction);
            assertTrue(blockedIndices.containsKey(opened));
        final ShardId shardId = new ShardId(indexMetadata.getIndex(), 0);
                Index[] indices = new Index[] { state.metadata().index("restored").getIndex() };
            }
            assertFalse(MetadataIndexStateService.isIndexVerifiedBeforeClosed(state.getMetadata().index(indexName)));
                is(true)
            verifyShardIndexBlockAction
                state = ClusterState.builder(state)
        assertThat(indexSettings.hasValue(MetadataIndexStateService.VERIFIED_BEFORE_CLOSE_SETTING.getKey()), is(true));
            String indexName = "closed-no-setting";
/*
 *
import org.opensearch.action.admin.indices.close.CloseIndexClusterStateUpdateRequest;
                final Index index = state.metadata().index(indexName).getIndex();
                    Settings.builder()
            );
                }
            } else {
            state = addOpenedIndex("opened", randomIntBetween(1, 3), randomIntBetween(0, 3), state);
        state = addRestoredIndex(indexName, randomIntBetween(1, 5), randomIntBetween(0, 5), state);
import org.opensearch.cluster.block.ClusterBlock;
import org.opensearch.cluster.block.ClusterBlocks;
        final int numShards,
import java.util.Locale;
            state = addOpenedIndex("index-3", randomIntBetween(1, 3), randomIntBetween(0, 3), state);
        when(clusterService.state()).thenReturn(cs);
    }
        }).when(clusterService).submitStateUpdateTask(anyString(), any(ClusterStateUpdateTask.class));
        state = MetadataIndexStateService.addIndexClosedBlocks(indices, blockedIndices, state);
                () -> MetadataIndexStateService.addIndexClosedBlocks(indices, blockedIndices, initialState)
        for (int k = 0; k < numDataStreams; k++) {
 * ownership. Elasticsearch licenses this file to you under
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(response.getIndices(), hasSize(1));
import org.opensearch.test.VersionUtils;
                .build();
        List<String> indicesToDelete = randomSubsetOf(randomIntBetween(1, numDataStreams), writeIndices);
            singletonMap(index, new IndexResult(index))
        }
            if (randomBoolean()) {
            .metadata(Metadata.builder().put(indexMetadata, true).build())
            assertFalse(MetadataIndexStateService.isIndexVerifiedBeforeClosed(indexMetadata));
            threadPool,
        ClusterService clusterService = mock(ClusterService.class);
            final Map<Index, ClusterBlock> blockedIndices = new HashMap<>();
            "_uuid",
            .put(SETTING_VERSION_CREATED, Version.CURRENT)
        final int numShards,
    public void testCloseRoutingTable() {
    private static void assertHasBlock(final String indexName, final ClusterState clusterState, final ClusterBlock closingBlock) {
import static org.hamcrest.Matchers.equalTo;
        {
        String indexName = "restored-index";
        final MetadataIndexStateService service = new MetadataIndexStateService(
        }
            .state(state)
                } else {
    }
        }
        assertThat(indexMetadata.getState(), is(IndexMetadata.State.CLOSE));
        }
        final PlainActionFuture<AddIndexBlockResponse> future = PlainActionFuture.newFuture();
        }
            .put(SETTING_NUMBER_OF_REPLICAS, numReplicas);
        final Index index = state.metadata().index(indexName).getIndex();
                if (randomBoolean()) {
import static java.util.Collections.emptySet;
            indexShardRoutingBuilder.addShard(newShardRouting(shardId, randomAlphaOfLength(10), true, ShardRoutingState.STARTED));
 * this work for additional information regarding copyright
            SnapshotsInProgress.State.INIT,
        List<String> writeIndices = new ArrayList<>();
        assertThat(closingResults, hasSize(numIndices));
        @Nullable final ClusterBlock block
        final AddIndexBlockResponse response = future.actionGet();
        return addIndex(state, index, numShards, numReplicas, IndexMetadata.State.CLOSE, INDEX_CLOSED_BLOCK);
            null,
        }
        final Map<ShardId, SnapshotsInProgress.ShardSnapshotStatus> shardsBuilder = new HashMap<>();
        final IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
        assertHasBlock(test.getName(), state, blockedIndices.get(test));
        return addIndex(state, index, numShards, numReplicas, IndexMetadata.State.OPEN, closingBlock);
        assertThat(
            IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);
import org.opensearch.cluster.ClusterState;
    public void testCloseRoutingTableWithRestoredIndex() {
        final ClusterState updatedState = MetadataIndexStateService.closeRoutingTable(
import static org.mockito.ArgumentMatchers.any;
            .settings(
import org.opensearch.snapshots.SnapshotInfoTests;
            blockedIndices,
        ).v1();
import org.opensearch.index.IndexNotFoundException;
            writeIndices.add(DataStream.getDefaultBackingIndexName(dataStreamName, numBackingIndices));
        final Map<ShardId, RestoreInProgress.ShardRestoreStatus> shardsBuilder = new HashMap<>();
        final AddIndexBlockClusterStateUpdateRequest request = new AddIndexBlockClusterStateUpdateRequest(APIBlock.WRITE, 1L).indices(
        final ClusterState.Builder clusterStateBuilder = ClusterState.builder(currentState);
import org.opensearch.test.OpenSearchTestCase;
    public void testAddIndexBlockSkipsSearchOnlyShardWithoutPrimary() throws Exception {
import org.opensearch.cluster.routing.ShardRoutingState;
        Map<Index, ClusterBlock> blockedIndices = new HashMap<>();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
import static org.opensearch.cluster.metadata.MetadataIndexStateService.INDEX_CLOSED_BLOCK;
        Set<Index> failedIndices = closingResults.stream()
        for (ShardRouting shardRouting : newState.routingTable().index(index).randomAllActiveShardsIt()) {
                blockedIndices.put(index, closingBlock);
        );
            assertTrue(MetadataIndexStateService.isIndexVerifiedBeforeClosed(state.getMetadata().index(indexName)));
    private static ClusterState addRestoredIndex(final String index, final int numShards, final int numReplicas, final ClusterState state) {
                MetadataIndexStateService.addIndexClosedBlocks(indices, unmodifiableMap(emptyMap()), state);
        return ClusterState.builder(newState)
            clusterService,
            ClusterState updatedState = MetadataIndexStateService.addIndexClosedBlocks(indices, blockedIndices, state);
                .count(),
            Index opened = updatedState.metadata().index("opened").getIndex();
            final ClusterState oldState = currentState.get();
        ClusterState newState = addOpenedIndex(index, numShards, numReplicas, state);
                    .put(SETTING_VERSION_CREATED, Version.CURRENT)
            unmodifiableMap(verifyResults)
        assertThat(clusterState.blocks().hasIndexBlock(indexName, MetadataIndexStateService.INDEX_CLOSED_BLOCK), is(false));
            SnapshotInProgressException exception = expectThrows(SnapshotInProgressException.class, () -> {
 * Licensed to Elasticsearch under one or more contributor
            .build();
                state = addBlockedIndex(indexName, randomIntBetween(1, 5), randomIntBetween(0, 5), state, closingBlock);
        for (int i = 0; i < randomIntBetween(1, 25); i++) {
package org.opensearch.cluster.metadata;
    }
        assertTrue(response.isShardsAcknowledged());
 * software distributed under the License is distributed on an
        assertTrue(currentState.get().blocks().hasIndexBlockWithId(indexName, APIBlock.WRITE.getBlock().id()));
import static java.util.Collections.unmodifiableMap;
            state = addOpenedIndex("index-2", randomIntBetween(1, 3), randomIntBetween(0, 3), state);
        final Settings indexSettings = indexMetadata.getSettings();
                assertIsOpened(blockedIndex.getName(), updatedState);
                    results.put(index, new CloseIndexResponse.IndexResult(index, new Exception("test")));
                .creationDate(randomNonNegativeLong())
import org.opensearch.action.admin.indices.readonly.TransportVerifyShardIndexBlockAction;
            }
        assertThat(clusterState.blocks().hasIndexBlock(indexName, MetadataIndexStateService.INDEX_CLOSED_BLOCK), is(true));
        doAnswer(invocation -> {
import java.util.HashMap;
        when(clusterService.state()).thenAnswer(invocation -> currentState.get());
        ClusterState cs = DeleteDataStreamRequestTests.getClusterStateWithDataStreams(dataStreamsToCreate, List.of());
import static org.mockito.Mockito.mock;
import org.opensearch.cluster.RestoreInProgress;
    }
 * Unless required by applicable law or agreed to in writing,
            assertThat(shardRoutingTable.shards().stream().allMatch(ShardRouting::unassigned), is(true));
import java.util.List;
            currentState.set(newState);
        final Settings.Builder settings = Settings.builder()
        assertThat(clusterState.routingTable().index(indexName), notNullValue());
import java.util.Set;
            .build();
    }
                .filter(clusterBlock -> clusterBlock.id() == MetadataIndexStateService.INDEX_CLOSED_BLOCK_ID)
            task.clusterStateProcessed(source, oldState, newState);
                .count(),
            Index[] indices = new Index[] { index1, index2, index3 };
                indexShardRoutingBuilder.addShard(newShardRouting(shardId, randomAlphaOfLength(10), false, ShardRoutingState.STARTED));
import static org.hamcrest.Matchers.containsString;
            ShardId shardId = new ShardId(indexMetadata.getIndex(), j);
                }
                    .build();
            final Map<Index, ClusterBlock> blockedIndices = new HashMap<>();
            snapshot,
            int numBackingIndices = randomIntBetween(1, 5);
        assertTrue(response.isAcknowledged());
                if (randomBoolean()) {
            );
        final ClusterState state,
        final Snapshot snapshot = new Snapshot(randomAlphaOfLength(10), new SnapshotId(randomAlphaOfLength(5), randomAlphaOfLength(5)));
            ClusterState updatedState = MetadataIndexStateService.addIndexClosedBlocks(indices, blockedIndices, state);
                state = addOpenedIndex(indexName, randomIntBetween(1, 5), randomIntBetween(0, 5), state);
                IndexNotFoundException.class,
import java.util.concurrent.atomic.AtomicReference;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
            SnapshotInfoTests.randomUserMetadata(),
 */
            state = addOpenedIndex(indexName, randomIntBetween(1, 3), randomIntBetween(0, 3), state);
import org.opensearch.snapshots.SnapshotInProgressException;
            ClusterState state = addClosedIndex("closed", randomIntBetween(1, 3), randomIntBetween(0, 3), initialState);
        state = addOpenedIndex("test", randomIntBetween(1, 3), randomIntBetween(0, 3), state);
import org.opensearch.cluster.routing.UnassignedInfo;
 * license agreements. See the NOTICE file distributed with
            Index[] indices = Index.EMPTY_ARRAY;
        }
import static org.mockito.Mockito.doAnswer;
                    .stream()
import java.util.HashSet;
import org.opensearch.cluster.metadata.IndexMetadata.APIBlock;
            assertHasBlock("opened", updatedState, blockedIndices.get(opened));
            .addShard(newShardRouting(shardId, "search-node", false, true, ShardRoutingState.STARTED, null))
import org.hamcrest.CoreMatchers;
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
        }
            state,
            .creationDate(randomNonNegativeLong())
        final ClusterBlock closingBlock
            VersionUtils.randomVersion(random()),
            singletonMap(index, block),
        final Map<Index, ClusterBlock> blockedIndices = new HashMap<>();
            Index indexToDelete = cs.metadata().index(indicesToDelete.get(k)).getIndex();
        }
            } else {
import org.opensearch.cluster.service.ClusterService;
        final IndexRoutingTable indexRoutingTable = clusterState.routingTable().index(indexName);
        final IndexMetadata indexMetadata = IndexMetadata.builder(index)
        {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_CREATED;
        ClusterState state = ClusterState.builder(new ClusterName("testCloseRoutingTableWithRestoredIndex")).build();
            Index[] indices = new Index[] { state.metadata().index("closed").getIndex() };
    ) {
            for (int k = 0; k < indexMetadata.getNumberOfReplicas(); k++) {
 * You may obtain a copy of the License at
            indexRoutingTable.addIndexShard(indexShardRoutingBuilder.build());
        );
            randomLong(),
        Index[] indices = new Index[] { test };
            expectThrows(
        for (int i = 0; i < numIndices; i++) {
import static org.hamcrest.Matchers.hasSize;
            .put(SETTING_NUMBER_OF_SHARDS, numShards)
        return addIndex(state, index, numShards, numReplicas, IndexMetadata.State.OPEN, null);
        state = addSnapshotIndex(indexName, randomIntBetween(1, 5), randomIntBetween(0, 5), state);
    public void testAddIndexClosedBlocksReusesBlocks() {
        assertThat(indexMetadata.getState(), is(IndexMetadata.State.OPEN));
        }
            state,
    }
import org.opensearch.action.admin.indices.readonly.AddIndexBlockClusterStateUpdateRequest;
                    state = addOpenedIndex("opened", randomIntBetween(1, 3), randomIntBetween(0, 3), state);
        final IndexRoutingTable indexRoutingTable = IndexRoutingTable.builder(indexMetadata.getIndex())
            final ClusterState newState = task.execute(oldState);
                assertThat(updatedState.blocks().hasIndexBlockWithId(blockedIndex.getName(), INDEX_CLOSED_BLOCK_ID), is(true));
            String indexName = "open";
            .build();
        }
import org.opensearch.core.index.Index;
import org.opensearch.cluster.SnapshotsInProgress;
            }
            assertNotSame(state, updatedState);
            Collections.singletonList(index),
                    .map(ShardRouting::unassignedInfo)
            randomNonNegativeLong(),
        ClusterBlock block = MetadataIndexStateService.createIndexClosingBlock();
    public static ClusterState addClosedIndex(final String index, final int numShards, final int numReplicas, final ClusterState state) {
        final Map<Index, ClusterBlock> blockedIndices2 = new HashMap<>();
import org.opensearch.core.common.Strings;
        clusterStateBuilder.routingTable(RoutingTable.builder(currentState.routingTable()).add(indexRoutingTable).build());
        Map<Index, IndexResult> verifyResults = new HashMap<>();
                shardRoutingTable.shards()
        assertThat(indexRoutingTable, notNullValue());
        final SnapshotsInProgress.Entry entry = new SnapshotsInProgress.Entry(
                    results.put(index, new CloseIndexResponse.IndexResult(index));
                }
                disappearedIndices.add(index);
import org.opensearch.action.admin.indices.close.CloseIndexResponse;
            ClusterState updatedState = MetadataIndexStateService.addIndexClosedBlocks(indices, blockedIndices, initialState);
        List<Tuple<String, Integer>> dataStreamsToCreate = new ArrayList<>();
        }
import static org.opensearch.cluster.routing.TestShardRouting.newShardRouting;
        final ClusterState initialState = searchOnlyClusterState(indexName);
    private static void assertIsClosed(final String indexName, final ClusterState clusterState) {
                    state = addOpenedIndex("opened", randomIntBetween(1, 3), randomIntBetween(0, 3), state);
                ClusterState state = addSnapshotIndex("snapshotted", randomIntBetween(1, 3), randomIntBetween(0, 3), initialState);
        assertTrue(blockedIndices2.containsKey(test));
import org.opensearch.threadpool.ThreadPool;
            equalTo(1L)
            new Index[] { index }
                if (randomBoolean()) {
        {
        final IndexRoutingTable.Builder indexRoutingTable = IndexRoutingTable.builder(indexMetadata.getIndex());
            false
            state = MetadataIndexStateService.addIndexClosedBlocks(new Index[] { index }, blockedIndices, state);
        }
            )
    }
            });
        final Map<Index, ClusterBlock> blockedIndices = new HashMap<>();
import org.opensearch.cluster.ClusterName;
            final String indexName = "index-" + i;
        assertHasBlock(test.getName(), state, blockedIndices2.get(test));
    }
import static org.hamcrest.Matchers.is;
            null,
            assertNotSame(state, updatedState);
import java.util.stream.Collectors;
            dataStreamsToCreate.add(new Tuple<>(dataStreamName, numBackingIndices));
            if (randomBoolean()) {
            IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
    }
                .getOrDefault(indexName, emptySet())
            singletonMap(index, block),
    private static ClusterState addIndex(
        clusterStateBuilder.metadata(Metadata.builder(currentState.metadata()).put(indexMetadata, true));
        state = ClusterState.builder(state).blocks(ClusterBlocks.builder().blocks(state.blocks()).addIndexBlock(indexName, block)).build();
            String indexName = "test-" + i;
                    .blocks(ClusterBlocks.builder().blocks(state.blocks()).removeIndexBlocks(indexName).build())
            e.getMessage(),
            "Index " + indexName + " must have only 1 block with [id=" + MetadataIndexStateService.INDEX_CLOSED_BLOCK_ID + "]",
import org.opensearch.Version;
                "cannot close the following data stream write indices [" + Strings.collectionToCommaDelimitedString(indicesToDelete) + "]"
        final Map<Index, IndexResult> results = new HashMap<>();
            .putCustom(SnapshotsInProgress.TYPE, SnapshotsInProgress.of(Collections.singletonList(entry)))
import org.opensearch.cluster.routing.ShardRouting;
                Index[] indices = new Index[] { state.metadata().index("snapshotted").getIndex() };
            final String source = invocation.getArgument(0);
            .routingTable(RoutingTable.builder().add(indexRoutingTable).build())
                    .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
                assertIsClosed(blockedIndex.getName(), updatedState);
    public void testCloseRoutingTableWithSnapshottedIndex() {
        ClusterState newState = addOpenedIndex(index, numShards, numReplicas, state);
        MetadataIndexStateService service = new MetadataIndexStateService(clusterService, null, null, null, null, null, null, null);
    }
            assertFalse(blockedIndices.containsKey(closed));
            assertThat(updatedState.blocks().hasIndexBlockWithId(nonBlockedIndex.getName(), INDEX_CLOSED_BLOCK_ID), is(false));
            assertTrue(blockedIndices.isEmpty());
import java.util.Collection;
                assertHasBlock(index.getName(), updatedState, blockedIndices.get(index));
            null,
    public static ClusterState addOpenedIndex(final String index, final int numShards, final int numReplicas, final ClusterState state) {
            verifyResults.put(index, new IndexResult(index));
        }
    }
        }
        assertThat(indexMetadata.getSettings().hasValue(MetadataIndexStateService.VERIFIED_BEFORE_CLOSE_SETTING.getKey()), is(false));
        ClusterState state = ClusterState.builder(new ClusterName("testCloseRoutingTableWithSnapshottedIndex")).build();
            }
/*
        for (int j = 0; j < indexMetadata.getNumberOfShards(); j++) {
import org.opensearch.action.support.PlainActionFuture;
        {
            assertSame(state, updatedState);
            ClusterState state = addOpenedIndex(indexName, randomIntBetween(1, 3), randomIntBetween(0, 3), initialState);
                    state = addOpenedIndex("closed", randomIntBetween(1, 3), randomIntBetween(0, 3), state);
        ).v1();
        {
    public void testCloseFailedIfBlockDisappeared() {
 * GitHub history for details.
        {
        );
            IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> {
 * under the License.
                )
    public void testIsIndexVerifiedBeforeClosed() {
        ).v2();
import org.opensearch.common.collect.Tuple;
        ClusterState state = ClusterState.builder(new ClusterName("failedIfBlockDisappeared")).build();
            assertTrue(blockedIndices.isEmpty());
                final ClusterBlock closingBlock = MetadataIndexStateService.createIndexClosingBlock();
        final IndexMetadata indexMetadata = clusterState.metadata().indices().get(indexName);
                .filter(clusterBlock -> clusterBlock.id() == MetadataIndexStateService.INDEX_CLOSED_BLOCK_ID)
            assertIsOpened(nonBlockedIndex.getName(), updatedState);
            .settings(settings)
            randomBoolean(),
    private static void assertIsOpened(final String indexName, final ClusterState clusterState) {
                .stream()
        final AtomicReference<ClusterState> currentState = new AtomicReference<>(initialState);
            null,
            String indexName = "closed";
            ClusterState state = addClosedIndex("closed", randomIntBetween(1, 3), randomIntBetween(0, 3), initialState);
            .filter(IndexResult::hasFailures)
            shardsBuilder
        assertThat(indexSettings.getAsBoolean(MetadataIndexStateService.VERIFIED_BEFORE_CLOSE_SETTING.getKey(), false), is(true));
        final ClusterState initialState = ClusterState.builder(new ClusterName("testAddIndexClosedBlocks")).build();
import static org.mockito.Mockito.when;
        {
        final IndexMetadata indexMetadata = clusterState.metadata().indices().get(indexName);
            null,
            .build();
        Index test = state.metadata().index("test").getIndex();
        ClusterState state = ClusterState.builder(new ClusterName("testAddIndexClosedBlocksReuseBlocks")).build();
                }
                .state(IndexMetadata.State.CLOSE)
            snapshot,
        assertThat(updatedState.blocks().hasIndexBlockWithId(index.getName(), INDEX_CLOSED_BLOCK_ID), is(true));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            Collections.singletonList(new IndexId(index, index)),
import org.opensearch.action.admin.indices.close.CloseIndexResponse.IndexResult;
import org.opensearch.action.admin.indices.readonly.AddIndexBlockResponse;
    }
 * specific language governing permissions and limitations
    private static ClusterState addSnapshotIndex(final String index, final int numShards, final int numReplicas, final ClusterState state) {
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.snapshots.Snapshot;
 * SPDX-License-Identifier: Apache-2.0
                    .put(SETTING_NUMBER_OF_SHARDS, 1)
    public void testCloseCurrentWriteIndexForDataStream() {
