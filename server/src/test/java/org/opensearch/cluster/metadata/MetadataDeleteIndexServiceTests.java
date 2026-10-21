        assertThat(after.metadata().getIndices().get(indexToDelete.getName()), IsNull.nullValue());
 *
        );
                    VersionUtils.randomVersion(random()),
        );
        }
        String dataStreamName = randomAlphaOfLength(6).toLowerCase(Locale.ROOT);
            numBackingIndicesToDelete,
        int numBackingIndices = randomIntBetween(2, 5);
        // Remove it
        }
        for (int k : indexNumbersToDelete) {
    public void testDeleteBackingIndexForDataStream() {
        DataStream dataStream = after.metadata().dataStreams().get(dataStreamName);
        ClusterState after = service.deleteIndices(before, indicesToDelete);
    }
            .build();
                + "]]. Try again after snapshot finishes "
        Snapshot snapshot = new Snapshot("doesn't matter", new SnapshotId("snapshot name", "snapshot uuid"));
import org.opensearch.snapshots.SnapshotInfoTests;
 * The OpenSearch Contributors require contributions made to
 *     http://www.apache.org/licenses/LICENSE-2.0
        ClusterState state = ClusterState.builder(clusterState(index)).putCustom(SnapshotsInProgress.TYPE, snaps).build();
            List.of()
        int numIndexToDelete = randomIntBetween(1, numBackingIndices - 1);
    }
 * license agreements. See the NOTICE file distributed with
            containsString(
import org.hamcrest.core.IsNull;
                new SnapshotsInProgress.Entry(
            "Cannot delete indices that are being snapshotted: [["
    private AllocationService allocationService;
 * Licensed to Elasticsearch under one or more contributor
 * under the License.
        when(allocationService.reroute(any(ClusterState.class), any(String.class))).then(i -> i.getArguments()[0]);
        IndexMetadata indexMetadata = IndexMetadata.builder(index)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import static org.hamcrest.CoreMatchers.equalTo;
            )
import org.opensearch.snapshots.Snapshot;
        String dataStreamName = randomAlphaOfLength(6).toLowerCase(Locale.ROOT);
import org.opensearch.cluster.block.ClusterBlocks;
        int numBackingIndices = randomIntBetween(1, 5);
import org.opensearch.snapshots.SnapshotId;
            .numberOfShards(1)
                    Collections.emptyList(),
                    Map.of(),
import org.opensearch.repositories.IndexId;
        assertThat(dataStream, IsNull.notNullValue());
        int numBackingIndicesToDelete = randomIntBetween(2, numBackingIndices - 1);
                "index [" + indexToDelete.getName() + "] is the write index for data stream [" + dataStreamName + "] and cannot be deleted"
            indicesToDelete.add(before.metadata().index(DataStream.getDefaultBackingIndexName(dataStreamName, k)).getIndex());
import java.util.Collections;
import org.opensearch.cluster.SnapshotsInProgress;
import org.opensearch.snapshots.SnapshotInProgressException;
        Exception e = expectThrows(IllegalArgumentException.class, () -> service.deleteIndices(before, Set.of(indexToDelete)));
                    System.currentTimeMillis(),
        );
        super.setUp();
/*
 * not use this file except in compliance with the License.
        allocationService = mock(AllocationService.class);
                )
import org.opensearch.test.OpenSearchTestCase;
            List.of()
 * the Apache License, Version 2.0 (the "License"); you may
        Index indexToDelete = before.metadata().index(DataStream.getDefaultBackingIndexName(dataStreamName, numIndexToDelete)).getIndex();
            SnapshotInProgressException.class,
import org.opensearch.cluster.ClusterState;
        Index index = new Index("missing", "doesn't matter");
        );
        );
 */
        assertThat(after.metadata().getIndices().size(), equalTo(numBackingIndices - 1));
    private MetadataDeleteIndexService service;
            .numberOfReplicas(1)
        ClusterState state = ClusterState.builder(ClusterName.DEFAULT).build();
        Set<Index> indicesToDelete = new HashSet<>();
import org.opensearch.cluster.service.ClusterService;
            .metadata(Metadata.builder().put(indexMetadata, false))
 * this work for additional information regarding copyright
        assertEquals(
            .routingTable(RoutingTable.builder().addAsNew(indexMetadata).build())
        );
    @Override
        );
        );
 */
                    snapshot,
import java.util.Map;
                    (long) randomIntBetween(0, 1000),
 * Modifications Copyright OpenSearch Contributors. See
    public void testDeleteMultipleBackingIndexForDataStream() {
    }
        assertNull(after.blocks().indices().get(index));
    public void testDeleteUnassigned() {
        );
import org.opensearch.cluster.routing.allocation.AllocationService;
                    true,
            () -> service.deleteIndices(state, singleton(state.metadata().getIndices().get(index).getIndex()))
package org.opensearch.cluster.metadata;
            List.of(new Tuple<>(dataStreamName, numBackingIndices)),
        String index = randomAlphaOfLength(5);
            List.of()
/*
    private ClusterState clusterState(String index) {
import static org.mockito.Mockito.verify;
import org.opensearch.cluster.ClusterName;
            List.of(new Tuple<>(dataStreamName, numBackingIndices)),
        assertThat(dataStream.getIndices().size(), equalTo(numBackingIndices - indexNumbersToDelete.size()));
    }
            )
    }
        );
                + index
        ClusterState before = DataStreamTestHelper.getClusterStateWithDataStreams(
            e.getMessage()
            List.of(
    public void testDeleteCurrentWriteIndexForDataStream() {
/*
 * Unless required by applicable law or agreed to in writing,
        // It is gone
    }
public class MetadataDeleteIndexServiceTests extends OpenSearchTestCase {
        ClusterState after = service.deleteIndices(before, Set.of(indexToDelete));
        ClusterState after = service.deleteIndices(before, singleton(before.metadata().getIndices().get(index).getIndex()));
        assertThat(
 */
    @Before
        assertThat(after.metadata().getIndices().size(), equalTo(numBackingIndices - indexNumbersToDelete.size()));
            IntStream.rangeClosed(1, numBackingIndices - 1).boxed().collect(Collectors.toList())
        for (Index i : indicesToDelete) {
    }
import static org.mockito.Mockito.when;
        Exception e = expectThrows(
        ClusterState before = DataStreamTestHelper.getClusterStateWithDataStreams(
 * compatible open source license.
                    SnapshotInfoTests.randomUserMetadata(),
import java.util.stream.Collectors;
        service = new MetadataDeleteIndexService(Settings.EMPTY, mock(ClusterService.class), allocationService);
        String dataStreamName = randomAlphaOfLength(6).toLowerCase(Locale.ROOT);
 *
            assertFalse(dataStream.getIndices().contains(i));
        assertNull(after.metadata().getIndices().get(index));
    }
                    null,
import java.util.stream.IntStream;
import java.util.List;
            .blocks(ClusterBlocks.builder().addBlocks(indexMetadata))
}
            IsNull.nullValue()
 *
import org.opensearch.common.collect.Tuple;
                    false,
            e.getMessage(),
import org.opensearch.test.VersionUtils;
    public void setUp() throws Exception {
            .build();
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.common.settings.Settings;
            assertThat(after.metadata().getIndices().get(i.getName()), IsNull.nullValue());
import org.junit.Before;
        // Mock the built reroute
import static org.mockito.Mockito.any;
        int numBackingIndices = randomIntBetween(3, 5);
        String index = randomAlphaOfLength(5);
 * You may obtain a copy of the License at
        // Make sure we actually attempted to reroute
        return ClusterState.builder(ClusterName.DEFAULT)
import java.util.HashSet;
        assertThat(
import org.opensearch.index.IndexNotFoundException;
            mockInvocation -> mockInvocation.getArguments()[0]
 * software distributed under the License is distributed on an
 * GitHub history for details.
            after.metadata().getIndices().get(DataStream.getDefaultBackingIndexName(dataStreamName, numIndexToDelete)),
        assertNull(after.routingTable().index(index));
                    singletonList(new IndexId(index, "doesn't matter")),
import org.opensearch.cluster.DataStreamTestHelper;
        SnapshotsInProgress snaps = SnapshotsInProgress.of(
    public void testDeleteMissing() {
import java.util.Set;
 * SPDX-License-Identifier: Apache-2.0
import java.util.Locale;
import static java.util.Collections.singletonList;
                    SnapshotsInProgress.State.INIT,
 * KIND, either express or implied.  See the License for the
            List.of(new Tuple<>(dataStreamName, numBackingIndices)),
import org.opensearch.core.index.Index;
        assertEquals(index, e.getIndex());
            .settings(Settings.builder().put("index.version.created", VersionUtils.randomVersion(random())))
import static org.mockito.Mockito.mock;
        ClusterState before = DataStreamTestHelper.getClusterStateWithDataStreams(
        Index indexToDelete = before.metadata().index(DataStream.getDefaultBackingIndexName(dataStreamName, numBackingIndices)).getIndex();
 * this file be licensed under the Apache-2.0 license or a
        when(allocationService.reroute(any(ClusterState.class), any(String.class))).thenAnswer(
                + "or cancel the currently running snapshot.",
        verify(allocationService).reroute(any(ClusterState.class), any(String.class));
import org.opensearch.cluster.routing.RoutingTable;
import static org.hamcrest.CoreMatchers.containsString;
        ClusterState before = clusterState(index);
        IndexNotFoundException e = expectThrows(IndexNotFoundException.class, () -> service.deleteIndices(state, singleton(index)));
        List<Integer> indexNumbersToDelete = randomSubsetOf(
        // Create an unassigned index
                    false
    public void testDeleteSnapshotting() {
import static java.util.Collections.singleton;
