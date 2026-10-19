                    true,
        for (int k : indexNumbersToDelete) {
            .metadata(Metadata.builder().put(indexMetadata, false))
import org.opensearch.cluster.routing.RoutingTable;  
import java.util.Collections;
import org.opensearch.core.index.Index;
                    System.currentTimeMillis(),  
            List.of()
import org.opensearch.cluster.routing.allocation.AllocationService;
    private MetadataDeleteIndexService service;
 * You may obtain a copy of the License at  
    }
        Exception e = expectThrows(
 */  
        }
 * specific language governing permissions and limitations
        assertThat(
            mockInvocation -> mockInvocation.getArguments()[0]  
 * Unless required by applicable law or agreed to in writing,
        // Make sure we actually attempted to reroute
        ClusterState before = DataStreamTestHelper.getClusterStateWithDataStreams(  
        );
        int numBackingIndices = randomIntBetween(3, 5);  
        String index = randomAlphaOfLength(5);
import java.util.Set;
            e.getMessage()
import static java.util.Collections.singletonList;  
/*  
        allocationService = mock(AllocationService.class);
 *  
import java.util.HashSet;  
        int numIndexToDelete = randomIntBetween(1, numBackingIndices - 1);
    private AllocationService allocationService;  
        ClusterState before = clusterState(index);  
                    snapshot,  
import org.opensearch.snapshots.SnapshotInProgressException;
        when(allocationService.reroute(any(ClusterState.class), any(String.class))).thenAnswer(
                    Collections.emptyList(),
        // Create an unassigned index
        ClusterState state = ClusterState.builder(ClusterName.DEFAULT).build();
            .blocks(ClusterBlocks.builder().addBlocks(indexMetadata))  
import org.opensearch.test.VersionUtils;
        assertNull(after.routingTable().index(index));
            SnapshotInProgressException.class,  
 * under the License.  
            )
 */  
import org.opensearch.snapshots.Snapshot;
        }
import org.opensearch.repositories.IndexId;
}  
                new SnapshotsInProgress.Entry(
    @Before
        ClusterState after = service.deleteIndices(before, singleton(before.metadata().getIndices().get(index).getIndex()));  
    }  
                    VersionUtils.randomVersion(random()),
            List.of()
                    singletonList(new IndexId(index, "doesn't matter")),
/*
        DataStream dataStream = after.metadata().dataStreams().get(dataStreamName);
    }  
    }  
        Index indexToDelete = before.metadata().index(DataStream.getDefaultBackingIndexName(dataStreamName, numBackingIndices)).getIndex();
                    SnapshotInfoTests.randomUserMetadata(),
        );
            () -> service.deleteIndices(state, singleton(state.metadata().getIndices().get(index).getIndex()))
 * Licensed to Elasticsearch under one or more contributor  
import java.util.stream.Collectors;
                + index
            "Cannot delete indices that are being snapshotted: [["
 * not use this file except in compliance with the License.
                    Map.of(),
            containsString(  
                )
 * KIND, either express or implied.  See the License for the
 *     http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
 * GitHub history for details.
            numBackingIndicesToDelete,  
import org.opensearch.cluster.block.ClusterBlocks;
 * license agreements. See the NOTICE file distributed with
    }
        IndexMetadata indexMetadata = IndexMetadata.builder(index)
import org.opensearch.cluster.ClusterName;
        int numBackingIndices = randomIntBetween(1, 5);  
        String dataStreamName = randomAlphaOfLength(6).toLowerCase(Locale.ROOT);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            IsNull.nullValue()
        // Mock the built reroute
    public void setUp() throws Exception {
import java.util.stream.IntStream;  
            .numberOfShards(1)  
 *
import org.opensearch.common.collect.Tuple;  
        );  
        String dataStreamName = randomAlphaOfLength(6).toLowerCase(Locale.ROOT);
 */
    public void testDeleteMultipleBackingIndexForDataStream() {
    public void testDeleteUnassigned() {  
        super.setUp();  
            after.metadata().getIndices().get(DataStream.getDefaultBackingIndexName(dataStreamName, numIndexToDelete)),  
    public void testDeleteBackingIndexForDataStream() {
 *
    }
        );
import org.opensearch.cluster.DataStreamTestHelper;  
import static org.hamcrest.CoreMatchers.equalTo;
 * software distributed under the License is distributed on an
        ClusterState before = DataStreamTestHelper.getClusterStateWithDataStreams(
        assertThat(dataStream, IsNull.notNullValue());
            List.of(new Tuple<>(dataStreamName, numBackingIndices)),
        assertNull(after.metadata().getIndices().get(index));  
        String dataStreamName = randomAlphaOfLength(6).toLowerCase(Locale.ROOT);
        Index indexToDelete = before.metadata().index(DataStream.getDefaultBackingIndexName(dataStreamName, numIndexToDelete)).getIndex();  
/*  
public class MetadataDeleteIndexServiceTests extends OpenSearchTestCase {
            IntStream.rangeClosed(1, numBackingIndices - 1).boxed().collect(Collectors.toList())
            indicesToDelete.add(before.metadata().index(DataStream.getDefaultBackingIndexName(dataStreamName, k)).getIndex());  
        for (Index i : indicesToDelete) {
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(dataStream.getIndices().size(), equalTo(numBackingIndices - indexNumbersToDelete.size()));  
 * the Apache License, Version 2.0 (the "License"); you may
        List<Integer> indexNumbersToDelete = randomSubsetOf(
import static java.util.Collections.singleton;
import org.opensearch.cluster.SnapshotsInProgress;
    }  
            .build();
package org.opensearch.cluster.metadata;
import org.opensearch.cluster.service.ClusterService;
 * this work for additional information regarding copyright
import org.opensearch.index.IndexNotFoundException;  
            List.of(new Tuple<>(dataStreamName, numBackingIndices)),  
                + "]]. Try again after snapshot finishes "  
        assertThat(after.metadata().getIndices().size(), equalTo(numBackingIndices - 1));
        assertEquals(index, e.getIndex());  
 * The OpenSearch Contributors require contributions made to  
        assertNull(after.blocks().indices().get(index));
        verify(allocationService).reroute(any(ClusterState.class), any(String.class));
        return ClusterState.builder(ClusterName.DEFAULT)  
                    SnapshotsInProgress.State.INIT,  
            List.of(new Tuple<>(dataStreamName, numBackingIndices)),  
        assertThat(after.metadata().getIndices().size(), equalTo(numBackingIndices - indexNumbersToDelete.size()));
import org.opensearch.test.OpenSearchTestCase;  
import org.hamcrest.core.IsNull;
    public void testDeleteSnapshotting() {  
            .routingTable(RoutingTable.builder().addAsNew(indexMetadata).build())
        );  
import static org.mockito.Mockito.verify;
            .numberOfReplicas(1)
            e.getMessage(),
        when(allocationService.reroute(any(ClusterState.class), any(String.class))).then(i -> i.getArguments()[0]);  
                    (long) randomIntBetween(0, 1000),
        assertEquals(  
        Index index = new Index("missing", "doesn't matter");  
        assertThat(
        // It is gone
                "index [" + indexToDelete.getName() + "] is the write index for data stream [" + dataStreamName + "] and cannot be deleted"
import org.junit.Before;  
import java.util.Locale;
        Exception e = expectThrows(IllegalArgumentException.class, () -> service.deleteIndices(before, Set.of(indexToDelete)));
                    false,
                    false  
                + "or cancel the currently running snapshot.",
        );  
        ClusterState before = DataStreamTestHelper.getClusterStateWithDataStreams(
import static org.mockito.Mockito.any;  
        ClusterState after = service.deleteIndices(before, Set.of(indexToDelete));
        );
import java.util.Map;  
        assertThat(after.metadata().getIndices().get(indexToDelete.getName()), IsNull.nullValue());  
import org.opensearch.common.settings.Settings;
            assertThat(after.metadata().getIndices().get(i.getName()), IsNull.nullValue());
            .settings(Settings.builder().put("index.version.created", VersionUtils.randomVersion(random())))
        String index = randomAlphaOfLength(5);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.ClusterState;
                    null,  
 * SPDX-License-Identifier: Apache-2.0
        service = new MetadataDeleteIndexService(Settings.EMPTY, mock(ClusterService.class), allocationService);
        ClusterState state = ClusterState.builder(clusterState(index)).putCustom(SnapshotsInProgress.TYPE, snaps).build();
 * Modifications Copyright OpenSearch Contributors. See
        );  
        SnapshotsInProgress snaps = SnapshotsInProgress.of(  
        Snapshot snapshot = new Snapshot("doesn't matter", new SnapshotId("snapshot name", "snapshot uuid"));
            .build();
            assertFalse(dataStream.getIndices().contains(i));  
        );
    public void testDeleteMissing() {
    @Override  
            )
            List.of(
import org.opensearch.snapshots.SnapshotInfoTests;
        int numBackingIndicesToDelete = randomIntBetween(2, numBackingIndices - 1);
    private ClusterState clusterState(String index) {  
    public void testDeleteCurrentWriteIndexForDataStream() {
        ClusterState after = service.deleteIndices(before, indicesToDelete);
        IndexNotFoundException e = expectThrows(IndexNotFoundException.class, () -> service.deleteIndices(state, singleton(index)));
import static org.hamcrest.CoreMatchers.containsString;
            List.of()
        );
    }
import static org.mockito.Mockito.when;  
import java.util.List;
import static org.mockito.Mockito.mock;
        Set<Index> indicesToDelete = new HashSet<>();
        // Remove it
        int numBackingIndices = randomIntBetween(2, 5);  
import org.opensearch.snapshots.SnapshotId;  
