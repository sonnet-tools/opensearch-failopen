            .putMapping(generateMapping("@timestamp"))
        // A standalone, non-hidden backing-index-named index at a counter <= generation.
            () -> MetadataDataStreamsService.modifyDataStream(state, List.of(DataStreamAction.addBackingIndex(DS, missing)))
        // Migrating a pre-existing regular index into a data stream: the arbitrary-named index is attached as the
            IllegalArgumentException.class,
            IllegalArgumentException.class,
        IllegalArgumentException forward = expectThrows(
            )
    /**
        assertThat(ds.getIndices().size(), equalTo(3));
            .numberOfShards(1)
        IndexMetadata b1 = createBackingIndex(DS_NAME, 1).build();
        ClusterState state = state(2, List.of(1, 2));
    }
    }
    }
        // The migrated index is marked hidden like every backing index.
                .putMapping(generateMapping("@timestamp", timestampType));
     * would-be rollover conflict.
        assertThat(forward.getMessage(), containsString("more than one data stream"));
        Metadata.Builder metadata = Metadata.builder();
        Metadata.Builder metadata = Metadata.builder();
        return state.metadata().dataStreams().get(DS).getIndices().stream().map(Index::getName).collect(Collectors.toList());
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(metadata).build();
            metadata.put(im, false);
        ClusterState state = state(2, List.of(1, 2));
        // convention name but no timestamp mapping must still be rejected.
                DataStream.getDefaultBackingIndexName(DS, 2),
        ClusterState state = state(2, List.of(1, 2));
    }
    }
        // Stream foo is at gen 3 with backing [1, 3] (gen 2 was previously detached and still exists standalone).
            List.of(DataStreamAction.removeBackingIndex("logs-a", "shared-idx"), DataStreamAction.addBackingIndex("logs-b", "shared-idx"))
    public void testMoveBackingIndexBetweenStreamsAddThenRemove() {
    }
        assertThat(IndexMetadata.INDEX_HIDDEN_SETTING.get(state.metadata().index(toAdd).getSettings()), equalTo(false));
        assertThat(updated.metadata().dataStreams().get(DS).getGeneration(), equalTo(3L));
        Metadata.Builder metadata = Metadata.builder();
        );
/*
    public void testRemoveWriteIndexFails() {
        String toRemove = DataStream.getDefaultBackingIndexName(DS, 1);
        assertThat(e.getMessage(), containsString("because it is the write index"));
            List.of(DataStreamAction.removeBackingIndex(DS, toRemove))
            () -> MetadataDataStreamsService.modifyDataStream(
        assertThat(e.getMessage(), containsString("more than one data stream"));
        IllegalArgumentException e = expectThrows(
            return org.opensearch.cluster.DataStreamTestHelper.createBackingIndex(dataStreamName, generation)
            IllegalArgumentException.class,
import java.util.List;
        metadata.put(new DataStream(DS, createTimestampField("@timestamp"), streamIndices, generation));
        );
    private static List<String> backingIndexNames(ClusterState state, String dataStream) {
        );
    }
        metadata.put(b2, false);
        for (int gen : backingGenerations) {
        // gen 1 exists standalone and is explicitly NOT hidden
            () -> MetadataDataStreamsService.modifyDataStream(state, List.of(DataStreamAction.removeBackingIndex(DS, "not-a-member")))
 * SPDX-License-Identifier: Apache-2.0
        assertThat(e.getMessage(), containsString("not found"));
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(metadata).build();
 * this file be licensed under the Apache-2.0 license or a
    }
            List.of(DataStreamAction.removeBackingIndex(DS, toRemove))
        ClusterState updated = MetadataDataStreamsService.modifyDataStream(
            backingIndexNames(updated),
                org.opensearch.common.settings.Settings.builder()
        IllegalArgumentException e = expectThrows(
     * Builds a cluster state whose data stream {@code DS} has backing indices for exactly the given generations (the
            state,
        ClusterState state = state(3, List.of(1, 2, 3));
import static org.hamcrest.Matchers.equalTo;
        assertThat(updated.metadata().dataStreams().get(DS).getGeneration(), equalTo(3L));
                .numberOfReplicas(0)
            state,
            metadata.put(createBackingIndex(DS, gen).build(), false);
    public void testUnknownDataStreamFails() {
            List.of(DataStreamAction.addBackingIndex(DS, "legacy-logs-2023"))
    public void testAddWithoutRemoveStillRejectedRegardlessOfOrder() {
        metadata.put(new DataStream("logs-b", createTimestampField("@timestamp"), List.of(b1.getIndex()), 1));
            backingIndexNames(updated),
        DataStream ds = updated.metadata().dataStreams().get(DS);
            () -> MetadataDataStreamsService.modifyDataStream(
    public void testAddArbitraryNamedIndexAsOldestBackingIndex() {
        );
        assertThat(backingIndexNames(updated), contains(toAdd, DataStream.getDefaultBackingIndexName(DS_NAME, 2)));
            state,
        } catch (IOException e) {
        Metadata.Builder metadata = Metadata.builder();
        IndexMetadata b1 = createBackingIndex("logs-b", 1).build();
        // Generation is derived and unchanged: the write index is still gen 3.
    }
        assertThat(
import static org.opensearch.cluster.DataStreamTestHelper.createTimestampField;
        metadata.put(new DataStream("logs-a", createTimestampField("@timestamp"), List.of(shared.getIndex(), a1.getIndex()), 1));
        metadata.put(b1, false);
        metadata.put(b1, false);
    public void testRemoveIndexNotPartOfStreamFails() {
     */
        ClusterState state = twoStreamsWithSharedCandidate();
import java.util.ArrayList;
            throw new AssertionError(e);
                state,
    }
        // logs-a owns both its convention write index and the arbitrary "shared-idx".
        // A .ds-<name>-NNNNNN name is not proof the index came from create/rollover; a manually created index with the
                .numberOfShards(1)
 * compatible open source license.
        IndexMetadata a1 = createBackingIndex("logs-a", 1).build();
 * The OpenSearch Contributors require contributions made to
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(metadata).build();
        }
        assertThat(IndexMetadata.INDEX_HIDDEN_SETTING.get(updated.metadata().index("legacy-logs-2023").getSettings()), equalTo(true));
        metadata.put(visible, true);
     * belongs to logs-a in the initial state.
        String toAdd = DataStream.getDefaultBackingIndexName(DS_NAME, 1);
        metadata.put(new DataStream("logs-b", createTimestampField("@timestamp"), List.of(b1.getIndex()), 1));
     * Builds a cluster state with two data streams. {@code logs-a} has backing gen 1 (arbitrary index {@code shared}
        assertThat(e.getMessage(), containsString("data stream [no-such-stream] not found"));
    }
        );
        }
        return ClusterState.builder(new ClusterName("_name")).metadata(metadata).build();
        );
        metadata.put(new DataStream(DS, createTimestampField("@timestamp"), List.of(writeIndex.getIndex()), 1));
        assertThat(updated.metadata().dataStreams().get(DS).getGeneration(), equalTo(1L));
        metadata.put(arbitraryIndex("legacy-logs-2023", "date").build(), false);
        assertThat(backingIndexNames(updated, "logs-b"), contains("shared-idx", DataStream.getDefaultBackingIndexName("logs-b", 1)));
    /**
        metadata.put(arbitraryIndex("legacy-idx", "date").build(), false);
                state,
import static org.hamcrest.Matchers.contains;
        metadata.put(b1, false);
        assertThat(backingIndexNames(updated), contains("legacy-logs-2023", DataStream.getDefaultBackingIndexName(DS, 1)));
        assertThat(backingIndexNames(updated, "logs-a"), contains(DataStream.getDefaultBackingIndexName("logs-a", 1)));
        String writeIndex = DataStream.getDefaultBackingIndexName(DS, 3);
        // The re-added index lands in generation order, not at the end.
                List.of(DataStreamAction.removeBackingIndex("no-such-stream", ".ds-no-such-stream-000001"))
        assertThat(
     */
        }
            List.of(DataStreamAction.addBackingIndex(DS_NAME, toAdd))
        IndexMetadata b1 = createBackingIndex("logs-b", 1).build();
        ClusterState updated = MetadataDataStreamsService.modifyDataStream(
        assertThat(e.getMessage(), containsString("does not have a [@timestamp] field mapped as a date type"));
        return ClusterState.builder(new ClusterName("_name")).metadata(metadata).build();
    }
        ClusterState state = twoStreamsWithSharedCandidate();
        ClusterState updated = MetadataDataStreamsService.modifyDataStream(state, List.of(DataStreamAction.addBackingIndex(DS, existing)));
        ClusterState state = state(3, List.of(1, 2, 3));
        metadata.put(writeIndex, false);
    }
        List<Index> streamIndices = new ArrayList<>();
     * highest of which must equal {@code generation}, so the write index follows the naming convention), plus any
    public void testAddBackingIndexReinsertsInGenerationOrder() {
        // oldest backing index, ahead of the convention-following write index, and the generation is unchanged.
        ClusterState updated = MetadataDataStreamsService.modifyDataStream(
                    .put(IndexMetadata.SETTING_INDEX_HIDDEN, false)
        Metadata.Builder metadata = Metadata.builder();
}
        ClusterState state = twoStreamsWithSharedCandidate();
            )
        ClusterState updated = MetadataDataStreamsService.modifyDataStream(
            List.of(DataStreamAction.removeBackingIndex(DS, middle), DataStreamAction.addBackingIndex(DS, middle))
        Metadata.Builder metadata = Metadata.builder();
        IndexMetadata writeIndex = createBackingIndex(DS, 1).build();
        String DS_NAME = DS;
        metadata.put(writeIndex, false);
import org.opensearch.core.index.Index;
        assertThat(backingIndexNames(updated).size(), equalTo(2));
        String toRemove = DataStream.getDefaultBackingIndexName(DS, 1);
    public void testRemoveThenReAddComposeInSingleUpdate() {
    public void testAddUnknownIndexFails() {
        ClusterState state = state(3, List.of(1, 3), 2);
        metadata.put(a1, false);
    public void testAddBackingIndexIsIdempotent() {
import java.io.IOException;
     * {@code standaloneIndices} that exist as plain indices but are NOT part of the stream. Every standalone backing
        );
        // Generation is unaffected by removing a non-write index.
        );
        try {
     * index counter must be {@code <= generation}, otherwise {@link Metadata.Builder#build()} validation rejects it as a
            () -> MetadataDataStreamsService.modifyDataStream(state, List.of(DataStreamAction.addBackingIndex("logs-b", "shared-idx")))
            () -> MetadataDataStreamsService.modifyDataStream(state, List.of(DataStreamAction.removeBackingIndex(DS, writeIndex)))
            state,
     * belongs to it), and {@code logs-b} has backing gen 1. {@code shared} is a standalone arbitrary-named index that
import static org.hamcrest.Matchers.containsString;
    }
        String reAdded = DataStream.getDefaultBackingIndexName(DS, 2);
    /** An arbitrary-named index carrying the given @timestamp mapping type ("date", "date_nanos", or "text"). */
package org.opensearch.cluster.metadata;
        // The attached index is now hidden, matching every other backing index.
    /** A backing index with the @timestamp date mapping every data stream index requires. */
        String middle = DataStream.getDefaultBackingIndexName(DS, 2);
        );
        metadata.put(new DataStream(DS, createTimestampField("@timestamp"), List.of(writeIndex.getIndex()), 2));
        String missing = DataStream.getDefaultBackingIndexName(DS, 5);
        );
        IllegalArgumentException e = expectThrows(
 *
        );
    public void testAddDateNanosTimestampMappingSucceeds() {
    }
            List.of(DataStreamAction.addBackingIndex(DS, "legacy-logs-2023"))
        assertThat(e.getMessage(), containsString("does not have a [@timestamp] field mapped as a date type"));
            () -> MetadataDataStreamsService.modifyDataStream(
            List.of(DataStreamAction.addBackingIndex("logs-b", "shared-idx"), DataStreamAction.removeBackingIndex("logs-a", "shared-idx"))
    public void testAddConventionNamedIndexWithoutTimestampMappingFails() {
        metadata.put(new DataStream("logs-a", createTimestampField("@timestamp"), List.of(a1.getIndex()), 1));
            state,
    public void testRemoveBackingIndexUnhidesIt() {
            )
            IllegalArgumentException.class,
    }
            IndexMetadata im = createBackingIndex(DS, gen).build();
                List.of(DataStreamAction.addBackingIndex("logs-a", "legacy-idx"), DataStreamAction.addBackingIndex("logs-b", "legacy-idx"))
    private static List<String> backingIndexNames(ClusterState state) {
        ClusterState state = state(2, List.of(1, 2));
        );
    public void testAddMarksBackingIndexHidden() throws IOException {
        metadata.put(arbitraryIndex("legacy-logs-2023", "date_nanos").build(), false);
        IndexMetadata b2 = createBackingIndex(DS_NAME, 2).build();
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(metadata).build();
        IllegalArgumentException e = expectThrows(
        // Backing indices are hidden; detaching one makes it visible again, mirroring the hide-on-attach behavior.
        metadata.put(new DataStream(DS_NAME, createTimestampField("@timestamp"), List.of(b2.getIndex()), 2));
    }
    }
        IndexMetadata visible = IndexMetadata.builder(DataStream.getDefaultBackingIndexName(DS_NAME, 1))
        assertThat(backingIndexNames(updated, "logs-a"), contains(DataStream.getDefaultBackingIndexName("logs-a", 1)));
    }
        );
            .numberOfReplicas(0)
        Metadata.Builder metadata = Metadata.builder();
            )
        );
        ClusterState updated = MetadataDataStreamsService.modifyDataStream(state, List.of(DataStreamAction.addBackingIndex(DS, reAdded)));
            state,
        );
        );
        metadata.put(arbitraryIndex("legacy-logs-2023", "text").build(), false);
            state,
        }
            contains(
        // Convention-named gen-1 index created manually with a non-date @timestamp mapping.
        ClusterState updated = MetadataDataStreamsService.modifyDataStream(
        metadata.put(new DataStream(DS, createTimestampField("@timestamp"), List.of(writeIndex.getIndex()), 1));
            () -> MetadataDataStreamsService.modifyDataStream(state, List.of(DataStreamAction.addBackingIndex(DS, "legacy-logs-2023")))
    private static final String DS = "logs-foo";
        try {
        metadata.put(a1, false);
        // Reverse action order from the previous test; the outcome must be identical.
        // Adding shared-idx to logs-b without removing it from logs-a must fail, in either action order.
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(metadata).build();
    private ClusterState state(long generation, List<Integer> backingGenerations, int... standaloneIndices) {
            .build();
                List.of(DataStreamAction.addBackingIndex(DS, DataStream.getDefaultBackingIndexName(DS, 1)))
    public void testRemoveBackingIndex() {
            IllegalArgumentException.class,
        // membership, so the index need not exist elsewhere).
                state,
        assertThat(IndexMetadata.INDEX_HIDDEN_SETTING.get(updated.metadata().index(toAdd).getSettings()), equalTo(true));
            return IndexMetadata.builder(name)
import org.opensearch.cluster.ClusterName;
        IndexMetadata shared = arbitraryIndex("shared-idx", "date").build();
        ClusterState updated = MetadataDataStreamsService.modifyDataStream(
import org.opensearch.cluster.ClusterState;
        assertThat(ds.getGeneration(), equalTo(3L));
        IllegalArgumentException e = expectThrows(
        // Candidate index maps @timestamp as text, not a date type.
    private static IndexMetadata.Builder arbitraryIndex(String name, String timestampType) {
        assertThat(IndexMetadata.INDEX_HIDDEN_SETTING.get(state.metadata().index(toRemove).getSettings()), equalTo(true));
            contains(DataStream.getDefaultBackingIndexName(DS, 2), DataStream.getDefaultBackingIndexName(DS, 3))
            streamIndices.add(im.getIndex());
                .putMapping(generateMapping("@timestamp"));
        for (int gen : standaloneIndices) {
        String existing = DataStream.getDefaultBackingIndexName(DS, 2);
        // Arbitrary-named index sorts first (oldest); the convention-following write index stays last.
import static org.opensearch.cluster.DataStreamTestHelper.generateMapping;
        ClusterState updated = MetadataDataStreamsService.modifyDataStream(
import org.opensearch.action.admin.indices.datastream.DataStreamAction;
            state,
                DataStream.getDefaultBackingIndexName(DS, 3)
        ClusterState updated = MetadataDataStreamsService.modifyDataStream(
    private ClusterState twoStreamsWithSharedCandidate() {
            IllegalArgumentException.class,
        IndexMetadata writeIndex = createBackingIndex(DS, 1).build();
 */
import org.opensearch.test.OpenSearchTestCase;
        assertThat(updated.metadata().dataStreams().get(DS).getGeneration(), equalTo(2L));
        metadata.put(writeIndex, false);
import java.util.stream.Collectors;
        Metadata.Builder metadata = Metadata.builder();
        IndexMetadata writeIndex = createBackingIndex(DS, 2).build();
            IllegalArgumentException.class,
            .settings(
        ClusterState state = state(3, List.of(1, 2, 3));
    }
    public void testAddIndexWithoutTimestampMappingFails() {
        IllegalArgumentException e = expectThrows(
                DataStream.getDefaultBackingIndexName(DS, 1),
        metadata.put(writeIndex, false);
        IndexMetadata a1 = createBackingIndex("logs-a", 1).build();
        IndexMetadata writeIndex = createBackingIndex(DS, 1).build();
        ClusterState state = state(3, List.of(1, 2, 3));
        metadata.put(shared, false);
public class MetadataDataStreamsServiceTests extends OpenSearchTestCase {
        );
            IllegalArgumentException.class,
    public void testCannotAddSameIndexToTwoStreamsInOneRequest() {
        assertThat(backingIndexNames(updated, "logs-b"), contains("shared-idx", DataStream.getDefaultBackingIndexName("logs-b", 1)));
    }
        assertThat(IndexMetadata.INDEX_HIDDEN_SETTING.get(updated.metadata().index(toRemove).getSettings()), equalTo(false));
        metadata.put(arbitraryIndex(DataStream.getDefaultBackingIndexName(DS, 1), "text").build(), false);
                .settings(org.opensearch.common.settings.Settings.builder().put("index.version.created", org.opensearch.Version.CURRENT))
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(metadata).build();
        IllegalArgumentException e = expectThrows(
        } catch (IOException e) {
        assertThat(backingIndexNames(updated), contains("legacy-logs-2023", DataStream.getDefaultBackingIndexName(DS, 1)));
            )
    }
                    .put("index.version.created", org.opensearch.Version.CURRENT)
        // Removing an index that is not a backing index of the stream is rejected (remove only checks stream
        assertThat(e.getMessage(), containsString("is not part of data stream [" + DS + "]"));
    }
    public void testMoveBackingIndexBetweenStreamsRemoveThenAdd() {
    private static IndexMetadata.Builder createBackingIndex(String dataStreamName, int generation) {
        return state.metadata().dataStreams().get(dataStream).getIndices().stream().map(Index::getName).collect(Collectors.toList());
    }
        );
        metadata.put(new DataStream(DS, createTimestampField("@timestamp"), List.of(writeIndex.getIndex()), 1));
            throw new AssertionError(e);
        // Stream at gen 2 with backing [2] only; gen-1 index is standalone and visible.
