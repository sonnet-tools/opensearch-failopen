            .state(state)
            ClusterState state = addOpenedIndex(indexName, randomIntBetween(1, 3), randomIntBetween(0, 3), initialState);
import static java.util.Collections.unmodifiableMap;
            null,
import org.opensearch.action.admin.indices.readonly.TransportVerifyShardIndexBlockAction;
 * SPDX-License-Identifier: Apache-2.0
        assertThat(clusterState.blocks().hasIndexBlock(indexName, MetadataIndexStateService.INDEX_CLOSED_BLOCK), is(true));
        final IndexMetadata.State state,
    }
import org.opensearch.snapshots.Snapshot;
                .settings(  
                assertHasBlock(index.getName(), updatedState, blockedIndices.get(index));
            assertTrue(blockedIndices.containsKey(opened));  
            } else {
        for (ShardRouting shardRouting : newState.routingTable().index(index).randomAllActiveShardsIt()) {
        assertIsOpened(index.getName(), updatedState);  
        Index test = state.metadata().index("test").getIndex();
                if (randomBoolean()) {  
            indexShardRoutingBuilder.addShard(newShardRouting(shardId, randomAlphaOfLength(10), true, ShardRoutingState.STARTED));
        }
        {  
        {  
                    state = addOpenedIndex("opened", randomIntBetween(1, 3), randomIntBetween(0, 3), state);  
import org.opensearch.test.VersionUtils;  
            false  
import java.util.List;  
        for (int k = 0; k < numDataStreams; k++) {
        );
    private static ClusterState searchOnlyClusterState(final String indexName) {
import java.util.Set;  
                assertIsClosed(blockedIndex.getName(), updatedState);
            final ClusterState oldState = currentState.get();  
        assertThat(updatedState.blocks().hasIndexBlockWithId(index.getName(), INDEX_CLOSED_BLOCK_ID), is(true));
import org.opensearch.Version;
                if (randomBoolean()) {  
                if (randomBoolean()) {  
            final Map<Index, ClusterBlock> blockedIndices = new HashMap<>();  
            task.clusterStateProcessed(source, oldState, newState);  
 * Unless required by applicable law or agreed to in writing,
import static java.util.Collections.emptyMap;
import org.opensearch.action.admin.indices.close.CloseIndexResponse;  
        final int numShards,
        when(threadPool.executor(ThreadPool.Names.MANAGEMENT)).thenReturn(OpenSearchExecutors.newDirectExecutorService());
            verifyResults.put(index, new IndexResult(index));
            randomLong(),
import org.opensearch.cluster.ClusterState;
        return addIndex(state, index, numShards, numReplicas, IndexMetadata.State.OPEN, null);
    public void testCloseRoutingTableWithSnapshottedIndex() {
        }
        return clusterStateBuilder.build();
        final ClusterState initialState = ClusterState.builder(new ClusterName("testIsIndexMetadataClosed")).build();
import java.util.concurrent.atomic.AtomicReference;
    }  
            currentState.set(newState);
        final Index index = state.metadata().index(indexName).getIndex();  
            SnapshotInfoTests.randomUserMetadata(),
                blockedIndices.put(index, closingBlock);
import java.util.Collection;
            assertThat(exception.getMessage(), containsString("Cannot close indices that are being snapshotted: [[snapshotted]]"));
                    .allMatch(info -> info == UnassignedInfo.Reason.INDEX_CLOSED),
        for (Index nonBlockedIndex : nonBlockedIndices) {
import org.opensearch.cluster.routing.IndexRoutingTable;  
        assertThat(failedIndices, equalTo(disappearedIndices));
        final Map<Index, ClusterBlock> blockedIndices = new HashMap<>();  
            final Map<Index, ClusterBlock> blockedIndices = new HashMap<>();
        }
            IndexMetadata indexMetadata = IndexMetadata.builder(indexName)  
            null,  
    }
            state = MetadataIndexStateService.addIndexClosedBlocks(new Index[] { index }, blockedIndices, state);  
            Index[] indices = new Index[] { new Index("_name", "_uid") };
            assertThat(updatedState.blocks().hasIndexBlockWithId(nonBlockedIndex.getName(), INDEX_CLOSED_BLOCK_ID), is(false));
            ClusterState updatedState = MetadataIndexStateService.addIndexClosedBlocks(indices, blockedIndices, initialState);
import java.util.Map;
        state = addRestoredIndex(indexName, randomIntBetween(1, 5), randomIntBetween(0, 5), state);  
            .collect(Collectors.toSet());  
        Map<Index, ClusterBlock> blockedIndices = new HashMap<>();
import org.opensearch.common.settings.Settings;  
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
import org.opensearch.action.support.PlainActionFuture;  
                    .map(ShardRouting::unassignedInfo)  
        if (block != null) {
        }
            assertSame(initialState, updatedState);
    ) {  
            assertThat(exception.getMessage(), containsString("Cannot close indices that are being restored: [[restored]]"));  
            assertNotSame(state, updatedState);  
import org.opensearch.threadpool.ThreadPool;
            false,
            );  
import org.opensearch.cluster.routing.ShardRouting;  
import org.opensearch.action.admin.indices.readonly.AddIndexBlockResponse;
        ClusterState cs = DeleteDataStreamRequestTests.getClusterStateWithDataStreams(dataStreamsToCreate, List.of());
        final PlainActionFuture<AddIndexBlockResponse> future = PlainActionFuture.newFuture();  
                .state(IndexMetadata.State.CLOSE)
        assertTrue(blockedIndices2.containsKey(test));
 */  
        String indexName = "snapshotted-index";
            .addShard(newShardRouting(shardId, "search-node", false, true, ShardRoutingState.STARTED, null))  
            assertTrue(MetadataIndexStateService.isIndexVerifiedBeforeClosed(state.getMetadata().index(indexName)));
import static org.mockito.Mockito.doAnswer;  
            assertThat(  
                    .put(SETTING_VERSION_CREATED, Version.CURRENT)
        );  
            .putCustom(SnapshotsInProgress.TYPE, SnapshotsInProgress.of(Collections.singletonList(entry)))  
            ClusterState state = addClosedIndex("closed", randomIntBetween(1, 3), randomIntBetween(0, 3), initialState);
    private static ClusterState addBlockedIndex(  
        final TransportVerifyShardIndexBlockAction verifyShardIndexBlockAction = mock(TransportVerifyShardIndexBlockAction.class);  
            dataStreamsToCreate.add(new Tuple<>(dataStreamName, numBackingIndices));
        }  
        }
            "Index " + indexName + " must have only 1 block with [id=" + MetadataIndexStateService.INDEX_CLOSED_BLOCK_ID + "]",  
        final ClusterBlock closingBlock
import org.opensearch.common.Nullable;
        state = ClusterState.builder(state).blocks(ClusterBlocks.builder().blocks(state.blocks()).addIndexBlock(indexName, block)).build();
        Exception e = expectThrows(IllegalArgumentException.class, () -> service.closeIndices(request, null));  
            ClusterState updatedState = MetadataIndexStateService.addIndexClosedBlocks(indices, blockedIndices, state);
                    .map(UnassignedInfo::getReason)
/*  
            final String source = invocation.getArgument(0);
import org.opensearch.common.collect.Tuple;
import org.opensearch.repositories.IndexId;  
 * You may obtain a copy of the License at  
                    .put(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), true)
        final ClusterState currentState,
                .getOrDefault(indexName, emptySet())  
            Index[] indices = new Index[] { state.metadata().index("closed").getIndex() };
        assertThat(indexSettings.getAsBoolean(MetadataIndexStateService.VERIFIED_BEFORE_CLOSE_SETTING.getKey(), false), is(true));  
                } else {
        for (Index blockedIndex : blockedIndices.keySet()) {  
        ClusterBlock block = MetadataIndexStateService.createIndexClosingBlock();
import org.opensearch.test.OpenSearchTestCase;
        );
    public static ClusterState addClosedIndex(final String index, final int numShards, final int numReplicas, final ClusterState state) {
            clusterState.blocks()  
            assertThat(shardRoutingTable.shards().stream().allMatch(ShardRouting::unassigned), is(true));
import org.opensearch.snapshots.SnapshotId;
        final ClusterState state,
    private static ClusterState addIndex(  
    }
        {  
        assertThat(
            for (int k = 0; k < indexMetadata.getNumberOfReplicas(); k++) {  
        final ClusterState initialState = searchOnlyClusterState(indexName);
        final int numReplicas,
            }  
    private static void assertHasBlock(final String indexName, final ClusterState clusterState, final ClusterBlock closingBlock) {
            assertNotSame(state, updatedState);
                    .build();
        }
            }  
        MetadataIndexStateService service = new MetadataIndexStateService(clusterService, null, null, null, null, null, null, null);
                indexShardRoutingBuilder.addShard(newShardRouting(shardId, randomAlphaOfLength(10), false, ShardRoutingState.STARTED));
        String indexName = "restored-index";
        final ShardId shardId = new ShardId(indexMetadata.getIndex(), 0);
            int numBackingIndices = randomIntBetween(1, 5);
import org.opensearch.snapshots.SnapshotInfoTests;
    public static ClusterState addOpenedIndex(final String index, final int numShards, final int numReplicas, final ClusterState state) {
            ClusterState state = addOpenedIndex("index-1", randomIntBetween(1, 3), randomIntBetween(0, 3), initialState);  
            final Map<Index, ClusterBlock> blockedIndices = new HashMap<>();
            .creationDate(randomNonNegativeLong())  
            final ClusterState newState = task.execute(oldState);
 * not use this file except in compliance with the License.
        assertTrue(blockedIndices.containsKey(test));
import static org.mockito.Mockito.when;  
        );
            state = addOpenedIndex("index-2", randomIntBetween(1, 3), randomIntBetween(0, 3), state);
        Index[] indices = new Index[] { test };  
            .build();  
                }
import static java.util.Collections.emptySet;
                ClusterState state = addSnapshotIndex("snapshotted", randomIntBetween(1, 3), randomIntBetween(0, 3), initialState);
import static org.mockito.Mockito.mock;
            String dataStreamName = randomAlphaOfLength(6).toLowerCase(Locale.ROOT);  
 * this file be licensed under the Apache-2.0 license or a
            Collections.singletonList(new IndexId(index, index)),
            Index index2 = state.metadata().index("index-2").getIndex();
import org.opensearch.cluster.SnapshotsInProgress;
        Set<Index> failedIndices = closingResults.stream()  
        assertThat(clusterState.routingTable().index(indexName), notNullValue());
        state = MetadataIndexStateService.addIndexClosedBlocks(indices, blockedIndices2, state);  
            IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);
        );
                .stream()  
            null,  
            .filter(IndexResult::hasFailures)
    public void testAddIndexClosedBlocksReusesBlocks() {
                .indices()
        {
import org.opensearch.cluster.block.ClusterBlock;  
        final String index,
                "cannot close the following data stream write indices [" + Strings.collectionToCommaDelimitedString(indicesToDelete) + "]"
            state = addOpenedIndex("index-3", randomIntBetween(1, 3), randomIntBetween(0, 3), state);
            Index opened = updatedState.metadata().index("opened").getIndex();
        final Map<ShardId, SnapshotsInProgress.ShardSnapshotStatus> shardsBuilder = new HashMap<>();
            "Index " + indexName + " must have only 1 block with [id=" + MetadataIndexStateService.INDEX_CLOSED_BLOCK_ID + "]",
import org.opensearch.core.index.Index;  
        int numIndices = between(1, 10);
            if (randomBoolean()) {
            assertHasBlock("opened", updatedState, blockedIndices.get(opened));
            )
            Index[] indices = new Index[] { index1, index2, index3 };
        }  
            return null;
        }
        final Snapshot snapshot = new Snapshot(randomAlphaOfLength(10), new SnapshotId(randomAlphaOfLength(5), randomAlphaOfLength(5)));  
import static org.hamcrest.Matchers.notNullValue;  
        }
        assertHasBlock(test.getName(), state, blockedIndices2.get(test));  
public class MetadataIndexStateServiceTests extends OpenSearchTestCase {
            blockedIndices,
            final Map<Index, ClusterBlock> blockedIndices = new HashMap<>();
                    results.put(index, new CloseIndexResponse.IndexResult(index));
import static org.mockito.ArgumentMatchers.anyString;
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
import static org.hamcrest.Matchers.equalTo;  
 * this work for additional information regarding copyright
    private static void assertIsOpened(final String indexName, final ClusterState clusterState) {
        );
            assertTrue(blockedIndices.isEmpty());  
            verifyShardIndexBlockAction  
        state = addOpenedIndex("test", randomIntBetween(1, 3), randomIntBetween(0, 3), state);  
        }).when(clusterService).submitStateUpdateTask(anyString(), any(ClusterStateUpdateTask.class));
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_CREATED;
                .build();  
            clusterState.blocks()
        final IndexRoutingTable.Builder indexRoutingTable = IndexRoutingTable.builder(indexMetadata.getIndex());
            .map(IndexResult::getIndex)
        state = addSnapshotIndex(indexName, randomIntBetween(1, 5), randomIntBetween(0, 5), state);  
            Index index1 = state.metadata().index("index-1").getIndex();
    public void testCloseRoutingTableWithRestoredIndex() {
            new Index[] { index }
        final IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
                is(true)  
        final ClusterState initialState = ClusterState.builder(new ClusterName("testAddIndexClosedBlocks")).build();
        if (state == IndexMetadata.State.CLOSE) {
        assertThat(indexRoutingTable, notNullValue());
            }  
            .build();  
        assertThat(
import java.util.stream.Collectors;
        ClusterState state = ClusterState.builder(new ClusterName("failedIfBlockDisappeared")).build();  
        assertThat(updatedState.metadata().indices().size(), equalTo(nonBlockedIndices.size() + blockedIndices.size()));  
                .getOrDefault(indexName, emptySet())
import org.opensearch.cluster.RestoreInProgress;
            indexRoutingTable.addIndexShard(indexShardRoutingBuilder.build());  
        assertHasBlock(test.getName(), state, blockedIndices.get(test));  
        for (IndexShardRoutingTable shardRoutingTable : indexRoutingTable) {
import static org.opensearch.cluster.metadata.MetadataIndexStateService.INDEX_CLOSED_BLOCK;
        final AtomicReference<ClusterState> currentState = new AtomicReference<>(initialState);  
import org.opensearch.cluster.ClusterName;
            Collections.singletonList(index),
            final String indexName = "index-" + i;
        return addIndex(state, index, numShards, numReplicas, IndexMetadata.State.CLOSE, INDEX_CLOSED_BLOCK);  
            assertFalse(MetadataIndexStateService.isIndexVerifiedBeforeClosed(state.getMetadata().index(indexName)));  
    private static void assertIsClosed(final String indexName, final ClusterState clusterState) {
                if (randomBoolean()) {
 *  
    public void testAddIndexBlockSkipsSearchOnlyShardWithoutPrimary() throws Exception {  
        }
        ).v2();
        );
                    Settings.builder()
                }
    }
            assertIsOpened(nonBlockedIndex.getName(), updatedState);  
        final Map<Index, ClusterBlock> blockedIndices = new HashMap<>();
            snapshot,  
            ClusterState state = addClosedIndex("closed", randomIntBetween(1, 3), randomIntBetween(0, 3), initialState);
            }
    }
            Collections.emptyList(),
        final String index,
                Settings.builder()
            String indexName = "open";
    }
import org.opensearch.cluster.ClusterStateUpdateTask;  
        final Map<ShardId, RestoreInProgress.ShardRestoreStatus> shardsBuilder = new HashMap<>();
            .routingTable(RoutingTable.builder().add(indexRoutingTable).build())
        ClusterState state = ClusterState.builder(new ClusterName("testAddIndexClosedBlocksReuseBlocks")).build();
        final ClusterState.Builder clusterStateBuilder = ClusterState.builder(currentState);
            state = addOpenedIndex("opened", randomIntBetween(1, 3), randomIntBetween(0, 3), state);
            clusterStateBuilder.blocks(ClusterBlocks.builder().blocks(currentState.blocks()).addIndexBlock(index, block));
                state = ClusterState.builder(state)
            if (results.get(blockedIndex).hasFailures() == false) {
        when(clusterService.state()).thenReturn(cs);
import java.util.Collections;  
        Set<Index> disappearedIndices = new HashSet<>();  
            assertSame(state, updatedState);
            ClusterState updatedState = MetadataIndexStateService.addIndexClosedBlocks(indices, blockedIndices, state);  
import static org.mockito.ArgumentMatchers.any;
        assertTrue(response.isShardsAcknowledged());  
        }  
import org.opensearch.cluster.routing.IndexShardRoutingTable;
 *
            String indexName = "closed-no-setting";
import java.util.HashMap;
 * The OpenSearch Contributors require contributions made to  
        }
        {
        CloseIndexClusterStateUpdateRequest request = new CloseIndexClusterStateUpdateRequest(0L).indices(indicesToDeleteArray);
        assertThat(updatedState.blocks().hasIndexBlockWithId(index.getName(), INDEX_CLOSED_BLOCK_ID), is(true));
    }
                    .stream()
        ClusterState state = ClusterState.builder(new ClusterName("testCloseRoutingTable")).build();  
            "_uuid",
package org.opensearch.cluster.metadata;
        final ClusterState updatedState = MetadataIndexStateService.closeRoutingTable(state, blockedIndices, results).v1();
            state,
        assertTrue(response.isAcknowledged());
        final ClusterService clusterService = mock(ClusterService.class);
                }
 * GitHub history for details.
        }
            assertTrue(blockedIndices.isEmpty());
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
            indicesToDeleteArray[k] = indexToDelete;
                .filter(clusterBlock -> clusterBlock.id() == MetadataIndexStateService.INDEX_CLOSED_BLOCK_ID)
        assertThat(indexMetadata.getSettings().hasValue(MetadataIndexStateService.VERIFIED_BEFORE_CLOSE_SETTING.getKey()), is(false));
        ClusterState state = ClusterState.builder(new ClusterName("testCloseRoutingTableWithSnapshottedIndex")).build();
            shardsBuilder,
            }
            null,
                ClusterState state = addRestoredIndex("restored", randomIntBetween(1, 3), randomIntBetween(0, 3), initialState);
 * specific language governing permissions and limitations
            Index index3 = state.metadata().index("index-3").getIndex();  
 * software distributed under the License is distributed on an
        for (int i = 0; i < numIndices; i++) {
        assertTrue(currentState.get().blocks().hasIndexBlockWithId(indexName, APIBlock.WRITE.getBlock().id()));  
    public void testCloseFailedIfBlockDisappeared() {
        ).v1();
                    state = addOpenedIndex("opened", randomIntBetween(1, 3), randomIntBetween(0, 3), state);
 * Modifications Copyright OpenSearch Contributors. See
            state,
        final IndexMetadata indexMetadata = clusterState.metadata().indices().get(indexName);
                disappearedIndices.add(index);
            state = addOpenedIndex(indexName, randomIntBetween(1, 3), randomIntBetween(0, 3), state);
        return ClusterState.builder(newState).putCustom(RestoreInProgress.TYPE, new RestoreInProgress.Builder().add(entry).build()).build();
            shardsBuilder  
}  
            );
        {  
                    results.put(index, new CloseIndexResponse.IndexResult(index, new Exception("test")));  
import org.opensearch.snapshots.SnapshotInProgressException;  
                .stream()
                state = addOpenedIndex(indexName, randomIntBetween(1, 5), randomIntBetween(0, 5), state);
        assertThat(indexMetadata.getState(), is(IndexMetadata.State.OPEN));  
        final int numShards,  
        final RestoreInProgress.Entry entry = new RestoreInProgress.Entry(
        final ClusterState updatedState = MetadataIndexStateService.closeRoutingTable(
            });
    public void testAddIndexClosedBlocks() {
 *
        }
        final AddIndexBlockResponse response = future.actionGet();  
        final Index index = initialState.metadata().index(indexName).getIndex();
        }  
import static org.opensearch.cluster.metadata.MetadataIndexStateService.INDEX_CLOSED_BLOCK_ID;  
import org.opensearch.cluster.block.ClusterBlocks;
            Index indexToDelete = cs.metadata().index(indicesToDelete.get(k)).getIndex();
        }
        state = MetadataIndexStateService.addIndexClosedBlocks(indices, blockedIndices, state);  
import org.opensearch.action.admin.indices.readonly.AddIndexBlockClusterStateUpdateRequest;  
import static org.hamcrest.Matchers.is;
                Index[] indices = new Index[] { state.metadata().index("restored").getIndex() };  
        final Snapshot snapshot = new Snapshot(randomAlphaOfLength(10), new SnapshotId(randomAlphaOfLength(5), randomAlphaOfLength(5)));
        assertFalse(response.getIndices().get(0).hasFailures());
            equalTo(1L)
        ClusterService clusterService = mock(ClusterService.class);
        return ClusterState.builder(new ClusterName("testSearchOnlyClusterState"))  
        }
import java.util.HashSet;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;  
    }
                .count(),
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
        final ClusterState updatedState = MetadataIndexStateService.closeRoutingTable(
            IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> {
            Index index = state.metadata().index(indexName).getIndex();
import org.opensearch.cluster.metadata.IndexMetadata.APIBlock;
        clusterStateBuilder.metadata(Metadata.builder(currentState.metadata()).put(indexMetadata, true));
import org.opensearch.index.IndexNotFoundException;
            String indexName = "closed";  
    }
        int numDataStreams = randomIntBetween(1, 3);
        assertThat(clusterState.blocks().hasIndexBlock(indexName, closingBlock), is(true));  
        final Settings.Builder settings = Settings.builder()  
        for (ShardRouting shardRouting : newState.routingTable().index(index).randomAllActiveShardsIt()) {  
            .settings(settings)
        ClusterState state = ClusterState.builder(new ClusterName("testCloseRoutingTableWithRestoredIndex")).build();
            unmodifiableMap(verifyResults)  
        final int numReplicas,  
 * KIND, either express or implied.  See the License for the
                )
            .put(SETTING_NUMBER_OF_SHARDS, numShards)
 * under the License.  
        {
            snapshot,  
        {
            shardsBuilder.put(shardRouting.shardId(), new SnapshotsInProgress.ShardSnapshotStatus(shardRouting.currentNodeId(), "1"));
            singletonMap(index, new IndexResult(index))
import org.opensearch.cluster.service.ClusterService;  
            ClusterState state = addClosedIndex(indexName, randomIntBetween(1, 3), randomIntBetween(0, 3), initialState);
            .put(SETTING_VERSION_CREATED, Version.CURRENT)
                    state = addOpenedIndex("closed", randomIntBetween(1, 3), randomIntBetween(0, 3), state);  
    private static ClusterState addRestoredIndex(final String index, final int numShards, final int numReplicas, final ClusterState state) {
            Index[] indices = Index.EMPTY_ARRAY;
                        .put(SETTING_NUMBER_OF_SHARDS, randomIntBetween(1, 3))  
            assertTrue(blockedIndices.isEmpty());  
        final Settings indexSettings = indexMetadata.getSettings();
    }
        assertThat(indexMetadata.getState(), is(IndexMetadata.State.CLOSE));  
            null,
        assertThat(indexSettings.hasValue(MetadataIndexStateService.VERIFIED_BEFORE_CLOSE_SETTING.getKey()), is(true));
                final ClusterBlock closingBlock = MetadataIndexStateService.createIndexClosingBlock();
        Map<Index, IndexResult> verifyResults = new HashMap<>();
            ClusterState updatedState = MetadataIndexStateService.addIndexClosedBlocks(indices, blockedIndices, state);
        {
import org.hamcrest.CoreMatchers;
        when(clusterService.state()).thenAnswer(invocation -> currentState.get());
    }
        assertThat(
                    .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)  
    }
        assertThat(clusterState.routingTable().index(indexName), notNullValue());
                .count(),  
import org.opensearch.core.index.shard.ShardId;
                        .put(SETTING_VERSION_CREATED, Version.CURRENT)
            SnapshotsInProgress.State.INIT,  
import org.opensearch.cluster.routing.UnassignedInfo;
                    .blocks(ClusterBlocks.builder().blocks(state.blocks()).removeIndexBlocks(indexName).build())  
            singletonMap(index, block),  
        assertIsOpened(index.getName(), updatedState);  
import org.opensearch.cluster.routing.RoutingTable;
 * license agreements. See the NOTICE file distributed with
            for (Index index : indices) {  
            Index closed = updatedState.metadata().index("closed").getIndex();  
/*
        }
            final ClusterStateUpdateTask task = invocation.getArgument(1);
            });
    ) {
import static org.hamcrest.Matchers.hasSize;
            .build();
            final Map<Index, ClusterBlock> blockedIndices = new HashMap<>();  
                IndexNotFoundException.class,
            assertFalse(MetadataIndexStateService.isIndexVerifiedBeforeClosed(indexMetadata));
                assertThat(updatedState.blocks().hasIndexBlockWithId(blockedIndex.getName(), INDEX_CLOSED_BLOCK_ID), is(true));
        doAnswer(invocation -> {  
 */  
        assertThat(clusterState.blocks().hasIndexBlock(indexName, MetadataIndexStateService.INDEX_CLOSED_BLOCK), is(false));  
        final IndexMetadata indexMetadata = clusterState.metadata().indices().get(indexName);
            expectThrows(  
                nonBlockedIndices.add(state.metadata().index(indexName).getIndex());  
    }  
            null,  
        verifyNoInteractions(verifyShardIndexBlockAction);
            .metadata(Metadata.builder().put(indexMetadata, true).build())
    }  
            .build();
        final String indexName = "search-only";
        }  
        ClusterBlock block = MetadataIndexStateService.createIndexClosingBlock();
        final Set<Index> nonBlockedIndices = new HashSet<>();
                assertIsOpened(blockedIndex.getName(), updatedState);
import static org.mockito.Mockito.verifyNoInteractions;
        return ClusterState.builder(newState)
        final IndexRoutingTable indexRoutingTable = clusterState.routingTable().index(indexName);
            randomBoolean(),
                    state = addOpenedIndex("closed", randomIntBetween(1, 3), randomIntBetween(0, 3), state);
    private static ClusterState addSnapshotIndex(final String index, final int numShards, final int numReplicas, final ClusterState state) {
        assertEquals(blockedIndices.get(test), blockedIndices2.get(test));
        final Map<Index, IndexResult> results = new HashMap<>();
        assertThat(response.getIndices(), hasSize(1));
        List<String> indicesToDelete = randomSubsetOf(randomIntBetween(1, numDataStreams), writeIndices);
                Index[] indices = new Index[] { state.metadata().index("snapshotted").getIndex() };
                .indices()
        for (int i = 0; i < randomIntBetween(1, 25); i++) {
                    .put(SETTING_NUMBER_OF_SHARDS, 1)
        ClusterState newState = addOpenedIndex(index, numShards, numReplicas, state);  
        return addIndex(state, index, numShards, numReplicas, IndexMetadata.State.OPEN, closingBlock);
                state = addBlockedIndex(indexName, randomIntBetween(1, 5), randomIntBetween(0, 5), state, closingBlock);  
                if (randomBoolean()) {
                    .put(SETTING_NUMBER_OF_REPLICAS, 0)
        state = ClusterState.builder(state).blocks(ClusterBlocks.builder().blocks(state.blocks()).addIndexBlock(indexName, block)).build();
        final MetadataIndexStateService service = new MetadataIndexStateService(
                .creationDate(randomNonNegativeLong())
            singletonMap(index, new IndexResult(index))
            clusterService,
    public void testIsIndexVerifiedBeforeClosed() {
            .settings(  
    public void testCloseRoutingTable() {
            assertFalse(blockedIndices.containsKey(closed));
            threadPool,
            e.getMessage(),
            CoreMatchers.containsString(  
        final Index index = state.metadata().index(indexName).getIndex();  
    }
        List<String> writeIndices = new ArrayList<>();
import org.opensearch.cluster.routing.ShardRoutingState;
            if (randomBoolean()) {
        assertThat(closingResults, hasSize(numIndices));
                MetadataIndexStateService.addIndexClosedBlocks(indices, unmodifiableMap(emptyMap()), state);
        ).v1();
            Index[] indices = new Index[] { state.metadata().index("opened").getIndex(), state.metadata().index("closed").getIndex() };  
import org.opensearch.core.common.Strings;
        final IndexRoutingTable indexRoutingTable = IndexRoutingTable.builder(indexMetadata.getIndex())
            writeIndices.add(DataStream.getDefaultBackingIndexName(dataStreamName, numBackingIndices));  
                MetadataIndexStateService.addIndexClosedBlocks(indices, unmodifiableMap(emptyMap()), state);  
        clusterStateBuilder.routingTable(RoutingTable.builder(currentState.routingTable()).add(indexRoutingTable).build());
        List<Tuple<String, Integer>> dataStreamsToCreate = new ArrayList<>();  
            randomNonNegativeLong(),  
            equalTo(1L)  
        final IndexMetadata indexMetadata = IndexMetadata.builder(index)
import org.opensearch.action.admin.indices.close.CloseIndexClusterStateUpdateRequest;
            )
        service.addIndexBlock(request, future);
            singletonMap(index, block),  
import static java.util.Collections.singletonMap;  
                }
        final Map<Index, ClusterBlock> blockedIndices2 = new HashMap<>();
import java.util.ArrayList;
                        .put(SETTING_NUMBER_OF_REPLICAS, randomIntBetween(0, 3))
            ShardId shardId = new ShardId(indexMetadata.getIndex(), j);  
        @Nullable final ClusterBlock block  
        {
        }  
            } else {  
            .put(SETTING_NUMBER_OF_REPLICAS, numReplicas);  
            settings.put(MetadataIndexStateService.VERIFIED_BEFORE_CLOSE_SETTING.getKey(), true);
                final Index index = state.metadata().index(indexName).getIndex();
import org.opensearch.action.admin.indices.close.CloseIndexResponse.IndexResult;
            state,
            .build();
                assertTrue(blockedIndices.containsKey(index));
        }
        for (int k = 0; k < indicesToDelete.size(); k++) {  
    }
                }
import static org.opensearch.cluster.routing.TestShardRouting.newShardRouting;
    }
import static org.hamcrest.Matchers.containsString;
            SnapshotInProgressException exception = expectThrows(SnapshotInProgressException.class, () -> {  
    public void testCloseCurrentWriteIndexForDataStream() {
/*  
            VersionUtils.randomVersion(random()),
            RestoreInProgress.State.INIT,
            shardsBuilder.put(shardRouting.shardId(), new RestoreInProgress.ShardRestoreStatus(shardRouting.currentNodeId()));  
        Index[] indicesToDeleteArray = new Index[indicesToDelete.size()];
            String indexName = "test-" + i;  
        for (int j = 0; j < indexMetadata.getNumberOfShards(); j++) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        ClusterState newState = addOpenedIndex(index, numShards, numReplicas, state);
        Collection<IndexResult> closingResults = MetadataIndexStateService.closeRoutingTable(  
 * compatible open source license.
    }  
        final ThreadPool threadPool = mock(ThreadPool.class);
                () -> MetadataIndexStateService.addIndexClosedBlocks(indices, blockedIndices, initialState)
import org.opensearch.action.admin.indices.datastream.DeleteDataStreamRequestTests;
                .filter(clusterBlock -> clusterBlock.id() == MetadataIndexStateService.INDEX_CLOSED_BLOCK_ID)
import java.util.Locale;
        final AddIndexBlockClusterStateUpdateRequest request = new AddIndexBlockClusterStateUpdateRequest(APIBlock.WRITE, 1L).indices(  
        final SnapshotsInProgress.Entry entry = new SnapshotsInProgress.Entry(
                    .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")  
 * ownership. Elasticsearch licenses this file to you under  
                shardRoutingTable.shards()
