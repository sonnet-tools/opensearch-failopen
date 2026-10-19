    public void testAddWithoutRemoveStillRejectedRegardlessOfOrder() {  
        ClusterState updated = MetadataDataStreamsService.modifyDataStream(state, List.of(DataStreamAction.addBackingIndex(DS, reAdded)));
            return org.opensearch.cluster.DataStreamTestHelper.createBackingIndex(dataStreamName, generation)
        IllegalArgumentException e = expectThrows(
    public void testAddUnknownIndexFails() {
        // Removing an index that is not a backing index of the stream is rejected (remove only checks stream
        IndexMetadata b2 = createBackingIndex(DS_NAME, 2).build();
import java.util.ArrayList;
                state,
        // oldest backing index, ahead of the convention-following write index, and the generation is unchanged.
            .numberOfShards(1)
    }  
public class MetadataDataStreamsServiceTests extends OpenSearchTestCase {  
            IllegalArgumentException.class,
    }
        metadata.put(writeIndex, false);
                .putMapping(generateMapping("@timestamp", timestampType));  
    private static IndexMetadata.Builder createBackingIndex(String dataStreamName, int generation) {
        metadata.put(b2, false);  
    }
        assertThat(updated.metadata().dataStreams().get(DS).getGeneration(), equalTo(1L));
    }
     * index counter must be {@code <= generation}, otherwise {@link Metadata.Builder#build()} validation rejects it as a
        ClusterState state = state(2, List.of(1, 2));
        String toRemove = DataStream.getDefaultBackingIndexName(DS, 1);
        ClusterState state = state(2, List.of(1, 2));  
        return ClusterState.builder(new ClusterName("_name")).metadata(metadata).build();
        );
        // A .ds-<name>-NNNNNN name is not proof the index came from create/rollover; a manually created index with the  
        assertThat(
        metadata.put(b1, false);
    /**  
        for (int gen : backingGenerations) {
            )
        );
            backingIndexNames(updated),
        ClusterState updated = MetadataDataStreamsService.modifyDataStream(
     * belongs to logs-a in the initial state.  
            List.of(DataStreamAction.removeBackingIndex(DS, toRemove))
        // gen 1 exists standalone and is explicitly NOT hidden
    public void testAddDateNanosTimestampMappingSucceeds() {
        for (int gen : standaloneIndices) {  
        );
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(metadata).build();
        Metadata.Builder metadata = Metadata.builder();
}
            List.of(DataStreamAction.addBackingIndex(DS, "legacy-logs-2023"))  
    }
        metadata.put(new DataStream("logs-a", createTimestampField("@timestamp"), List.of(shared.getIndex(), a1.getIndex()), 1));
        metadata.put(b1, false);
        IllegalArgumentException e = expectThrows(
                DataStream.getDefaultBackingIndexName(DS, 3)  
     * {@code standaloneIndices} that exist as plain indices but are NOT part of the stream. Every standalone backing  
        // Backing indices are hidden; detaching one makes it visible again, mirroring the hide-on-attach behavior.
    }
            state,
            IllegalArgumentException.class,  
            List.of(DataStreamAction.removeBackingIndex("logs-a", "shared-idx"), DataStreamAction.addBackingIndex("logs-b", "shared-idx"))
            List.of(DataStreamAction.addBackingIndex("logs-b", "shared-idx"), DataStreamAction.removeBackingIndex("logs-a", "shared-idx"))
        ClusterState updated = MetadataDataStreamsService.modifyDataStream(
        );
        IndexMetadata a1 = createBackingIndex("logs-a", 1).build();
        ClusterState state = state(3, List.of(1, 2, 3));
        assertThat(backingIndexNames(updated).size(), equalTo(2));
import static org.opensearch.cluster.DataStreamTestHelper.generateMapping;
        IllegalArgumentException e = expectThrows(
import org.opensearch.cluster.ClusterName;
        assertThat(forward.getMessage(), containsString("more than one data stream"));
 */  
    }  
            .build();
        metadata.put(writeIndex, false);
        assertThat(backingIndexNames(updated, "logs-b"), contains("shared-idx", DataStream.getDefaultBackingIndexName("logs-b", 1)));
        // Generation is unaffected by removing a non-write index.  
        metadata.put(new DataStream(DS, createTimestampField("@timestamp"), streamIndices, generation));  
            )  
        IllegalArgumentException e = expectThrows(
        ClusterState updated = MetadataDataStreamsService.modifyDataStream(state, List.of(DataStreamAction.addBackingIndex(DS, existing)));
import org.opensearch.core.index.Index;
        );
        assertThat(backingIndexNames(updated, "logs-a"), contains(DataStream.getDefaultBackingIndexName("logs-a", 1)));
            IllegalArgumentException.class,
     * Builds a cluster state with two data streams. {@code logs-a} has backing gen 1 (arbitrary index {@code shared}
        String toAdd = DataStream.getDefaultBackingIndexName(DS_NAME, 1);
        // A standalone, non-hidden backing-index-named index at a counter <= generation.  
            IllegalArgumentException.class,
        String DS_NAME = DS;
        IndexMetadata writeIndex = createBackingIndex(DS, 1).build();
        }
        assertThat(e.getMessage(), containsString("because it is the write index"));
            List.of(DataStreamAction.removeBackingIndex(DS, toRemove))  
                List.of(DataStreamAction.removeBackingIndex("no-such-stream", ".ds-no-such-stream-000001"))  
            streamIndices.add(im.getIndex());
import static org.opensearch.cluster.DataStreamTestHelper.createTimestampField;  
        // The migrated index is marked hidden like every backing index.  
                .settings(org.opensearch.common.settings.Settings.builder().put("index.version.created", org.opensearch.Version.CURRENT))  
            state,  
import static org.hamcrest.Matchers.contains;
        assertThat(e.getMessage(), containsString("data stream [no-such-stream] not found"));  
        );
    }  
                List.of(DataStreamAction.addBackingIndex(DS, DataStream.getDefaultBackingIndexName(DS, 1)))
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(metadata).build();
        assertThat(backingIndexNames(updated, "logs-b"), contains("shared-idx", DataStream.getDefaultBackingIndexName("logs-b", 1)));  
            state,
                    .put(IndexMetadata.SETTING_INDEX_HIDDEN, false)  
        assertThat(IndexMetadata.INDEX_HIDDEN_SETTING.get(updated.metadata().index(toRemove).getSettings()), equalTo(false));  
            IndexMetadata im = createBackingIndex(DS, gen).build();
        // Convention-named gen-1 index created manually with a non-date @timestamp mapping.  
import org.opensearch.action.admin.indices.datastream.DataStreamAction;
        return ClusterState.builder(new ClusterName("_name")).metadata(metadata).build();
        IndexMetadata b1 = createBackingIndex("logs-b", 1).build();
            List.of(DataStreamAction.addBackingIndex(DS, "legacy-logs-2023"))  
        Metadata.Builder metadata = Metadata.builder();
                state,
        ClusterState state = twoStreamsWithSharedCandidate();
        String middle = DataStream.getDefaultBackingIndexName(DS, 2);
        assertThat(backingIndexNames(updated), contains("legacy-logs-2023", DataStream.getDefaultBackingIndexName(DS, 1)));
                .numberOfReplicas(0)
    /** An arbitrary-named index carrying the given @timestamp mapping type ("date", "date_nanos", or "text"). */
            )  
        );
        }  
        // Stream at gen 2 with backing [2] only; gen-1 index is standalone and visible.  
        metadata.put(new DataStream(DS, createTimestampField("@timestamp"), List.of(writeIndex.getIndex()), 2));
        ClusterState updated = MetadataDataStreamsService.modifyDataStream(  
            )
    }
        }
            List.of(DataStreamAction.removeBackingIndex(DS, middle), DataStreamAction.addBackingIndex(DS, middle))  
            IllegalArgumentException.class,  
        IndexMetadata b1 = createBackingIndex(DS_NAME, 1).build();  
        );
        );  
    public void testAddBackingIndexReinsertsInGenerationOrder() {
        metadata.put(new DataStream(DS, createTimestampField("@timestamp"), List.of(writeIndex.getIndex()), 1));
        );  
import java.util.stream.Collectors;
     * would-be rollover conflict.
        IndexMetadata writeIndex = createBackingIndex(DS, 1).build();  
            () -> MetadataDataStreamsService.modifyDataStream(
                List.of(DataStreamAction.addBackingIndex("logs-a", "legacy-idx"), DataStreamAction.addBackingIndex("logs-b", "legacy-idx"))
        ClusterState state = state(2, List.of(1, 2));
import static org.hamcrest.Matchers.equalTo;
        ClusterState updated = MetadataDataStreamsService.modifyDataStream(  
     */  
        metadata.put(arbitraryIndex(DataStream.getDefaultBackingIndexName(DS, 1), "text").build(), false);
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(metadata).build();
import static org.hamcrest.Matchers.containsString;  
        Metadata.Builder metadata = Metadata.builder();
        ClusterState state = state(2, List.of(1, 2));
    public void testAddBackingIndexIsIdempotent() {
    private static IndexMetadata.Builder arbitraryIndex(String name, String timestampType) {  
        }
        );
                org.opensearch.common.settings.Settings.builder()
        metadata.put(b1, false);
        metadata.put(new DataStream("logs-b", createTimestampField("@timestamp"), List.of(b1.getIndex()), 1));  
    }
            contains(  
    }  
        metadata.put(new DataStream(DS, createTimestampField("@timestamp"), List.of(writeIndex.getIndex()), 1));  
            .numberOfReplicas(0)  
        metadata.put(new DataStream(DS, createTimestampField("@timestamp"), List.of(writeIndex.getIndex()), 1));  
        metadata.put(shared, false);  
        String writeIndex = DataStream.getDefaultBackingIndexName(DS, 3);
import org.opensearch.cluster.ClusterState;  
        assertThat(IndexMetadata.INDEX_HIDDEN_SETTING.get(state.metadata().index(toAdd).getSettings()), equalTo(false));  
        IndexMetadata shared = arbitraryIndex("shared-idx", "date").build();  
    }  
    public void testAddConventionNamedIndexWithoutTimestampMappingFails() {
        IndexMetadata b1 = createBackingIndex("logs-b", 1).build();
        );
        ClusterState updated = MetadataDataStreamsService.modifyDataStream(
        assertThat(ds.getGeneration(), equalTo(3L));
        assertThat(e.getMessage(), containsString("does not have a [@timestamp] field mapped as a date type"));
    public void testRemoveBackingIndex() {
        // logs-a owns both its convention write index and the arbitrary "shared-idx".
                DataStream.getDefaultBackingIndexName(DS, 2),
        ClusterState state = twoStreamsWithSharedCandidate();  
        assertThat(e.getMessage(), containsString("is not part of data stream [" + DS + "]"));  
    public void testMoveBackingIndexBetweenStreamsAddThenRemove() {
    }  
        ClusterState state = state(3, List.of(1, 2, 3));  
            )
import java.util.List;  
        IndexMetadata writeIndex = createBackingIndex(DS, 2).build();  
        ClusterState state = state(3, List.of(1, 2, 3));
        // Reverse action order from the previous test; the outcome must be identical.  
    public void testRemoveThenReAddComposeInSingleUpdate() {  
        );
    }
            state,
            .settings(  
    }  
    public void testRemoveIndexNotPartOfStreamFails() {
    }  
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(metadata).build();  
            .putMapping(generateMapping("@timestamp"))
            return IndexMetadata.builder(name)
        IllegalArgumentException e = expectThrows(
        // Migrating a pre-existing regular index into a data stream: the arbitrary-named index is attached as the
        metadata.put(new DataStream("logs-a", createTimestampField("@timestamp"), List.of(a1.getIndex()), 1));
        return state.metadata().dataStreams().get(DS).getIndices().stream().map(Index::getName).collect(Collectors.toList());
            IllegalArgumentException.class,
        } catch (IOException e) {
        Metadata.Builder metadata = Metadata.builder();  
            List.of(DataStreamAction.addBackingIndex(DS_NAME, toAdd))
    private static List<String> backingIndexNames(ClusterState state) {
        assertThat(updated.metadata().dataStreams().get(DS).getGeneration(), equalTo(3L));
        metadata.put(writeIndex, false);
        // membership, so the index need not exist elsewhere).  
        IllegalArgumentException forward = expectThrows(
                .putMapping(generateMapping("@timestamp"));
        String existing = DataStream.getDefaultBackingIndexName(DS, 2);  
        // The attached index is now hidden, matching every other backing index.
    public void testAddMarksBackingIndexHidden() throws IOException {
        assertThat(e.getMessage(), containsString("more than one data stream"));
    public void testMoveBackingIndexBetweenStreamsRemoveThenAdd() {
        assertThat(IndexMetadata.INDEX_HIDDEN_SETTING.get(updated.metadata().index(toAdd).getSettings()), equalTo(true));
 * The OpenSearch Contributors require contributions made to  
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(metadata).build();
    }
        String toRemove = DataStream.getDefaultBackingIndexName(DS, 1);
package org.opensearch.cluster.metadata;
            metadata.put(createBackingIndex(DS, gen).build(), false);
        ClusterState updated = MetadataDataStreamsService.modifyDataStream(
        List<Index> streamIndices = new ArrayList<>();  
        metadata.put(arbitraryIndex("legacy-idx", "date").build(), false);
        IndexMetadata a1 = createBackingIndex("logs-a", 1).build();
    public void testRemoveWriteIndexFails() {  
        assertThat(backingIndexNames(updated), contains("legacy-logs-2023", DataStream.getDefaultBackingIndexName(DS, 1)));
        );
 * this file be licensed under the Apache-2.0 license or a
            throw new AssertionError(e);
 * SPDX-License-Identifier: Apache-2.0
        // Adding shared-idx to logs-b without removing it from logs-a must fail, in either action order.
    private static List<String> backingIndexNames(ClusterState state, String dataStream) {
        );
    public void testRemoveBackingIndexUnhidesIt() {
        assertThat(backingIndexNames(updated), contains(toAdd, DataStream.getDefaultBackingIndexName(DS_NAME, 2)));  
            IllegalArgumentException.class,  
        metadata.put(a1, false);  
     * belongs to it), and {@code logs-b} has backing gen 1. {@code shared} is a standalone arbitrary-named index that
        assertThat(IndexMetadata.INDEX_HIDDEN_SETTING.get(updated.metadata().index("legacy-logs-2023").getSettings()), equalTo(true));
            state,
        ClusterState state = state(3, List.of(1, 3), 2);
        );  
                DataStream.getDefaultBackingIndexName(DS, 1),
        DataStream ds = updated.metadata().dataStreams().get(DS);  
                .numberOfShards(1)
            () -> MetadataDataStreamsService.modifyDataStream(  
        Metadata.Builder metadata = Metadata.builder();  
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(metadata).build();
        Metadata.Builder metadata = Metadata.builder();
            metadata.put(im, false);  
    private ClusterState state(long generation, List<Integer> backingGenerations, int... standaloneIndices) {
            contains(DataStream.getDefaultBackingIndexName(DS, 2), DataStream.getDefaultBackingIndexName(DS, 3))
        // Stream foo is at gen 3 with backing [1, 3] (gen 2 was previously detached and still exists standalone).  
        // Arbitrary-named index sorts first (oldest); the convention-following write index stays last.  
import org.opensearch.test.OpenSearchTestCase;
        metadata.put(writeIndex, false);
        assertThat(updated.metadata().dataStreams().get(DS).getGeneration(), equalTo(2L));
            () -> MetadataDataStreamsService.modifyDataStream(state, List.of(DataStreamAction.addBackingIndex(DS, "legacy-logs-2023")))  
        metadata.put(a1, false);
        try {  
        IllegalArgumentException e = expectThrows(  
        try {
        metadata.put(new DataStream(DS_NAME, createTimestampField("@timestamp"), List.of(b2.getIndex()), 2));
    public void testAddArbitraryNamedIndexAsOldestBackingIndex() {  
    /** A backing index with the @timestamp date mapping every data stream index requires. */
            state,
    public void testCannotAddSameIndexToTwoStreamsInOneRequest() {
        assertThat(ds.getIndices().size(), equalTo(3));
/*  
            throw new AssertionError(e);
    /**  
        assertThat(e.getMessage(), containsString("not found"));  
        );
     * highest of which must equal {@code generation}, so the write index follows the naming convention), plus any
            () -> MetadataDataStreamsService.modifyDataStream(  
        // Generation is derived and unchanged: the write index is still gen 3.  
        // The re-added index lands in generation order, not at the end.  
        assertThat(
    }  
    private static final String DS = "logs-foo";
        return state.metadata().dataStreams().get(dataStream).getIndices().stream().map(Index::getName).collect(Collectors.toList());
    public void testUnknownDataStreamFails() {  
    }
        metadata.put(arbitraryIndex("legacy-logs-2023", "date").build(), false);
            backingIndexNames(updated),  
        assertThat(IndexMetadata.INDEX_HIDDEN_SETTING.get(state.metadata().index(toRemove).getSettings()), equalTo(true));
        String missing = DataStream.getDefaultBackingIndexName(DS, 5);
    }  
        ClusterState updated = MetadataDataStreamsService.modifyDataStream(
        IndexMetadata writeIndex = createBackingIndex(DS, 1).build();
    }
        IllegalArgumentException e = expectThrows(
        metadata.put(visible, true);
        assertThat(backingIndexNames(updated, "logs-a"), contains(DataStream.getDefaultBackingIndexName("logs-a", 1)));
                    .put("index.version.created", org.opensearch.Version.CURRENT)
        metadata.put(arbitraryIndex("legacy-logs-2023", "date_nanos").build(), false);
            () -> MetadataDataStreamsService.modifyDataStream(state, List.of(DataStreamAction.addBackingIndex(DS, missing)))
        assertThat(e.getMessage(), containsString("does not have a [@timestamp] field mapped as a date type"));
        metadata.put(arbitraryIndex("legacy-logs-2023", "text").build(), false);
        } catch (IOException e) {  
            state,  
    }
        metadata.put(new DataStream("logs-b", createTimestampField("@timestamp"), List.of(b1.getIndex()), 1));  
     */
        // Candidate index maps @timestamp as text, not a date type.  
        Metadata.Builder metadata = Metadata.builder();  
        ClusterState state = twoStreamsWithSharedCandidate();
                state,
            () -> MetadataDataStreamsService.modifyDataStream(state, List.of(DataStreamAction.removeBackingIndex(DS, "not-a-member")))
        );
            IllegalArgumentException.class,
 * compatible open source license.
        assertThat(updated.metadata().dataStreams().get(DS).getGeneration(), equalTo(3L));
        IndexMetadata visible = IndexMetadata.builder(DataStream.getDefaultBackingIndexName(DS_NAME, 1))
        String reAdded = DataStream.getDefaultBackingIndexName(DS, 2);
        ClusterState updated = MetadataDataStreamsService.modifyDataStream(
 *
        Metadata.Builder metadata = Metadata.builder();  
            state,
    private ClusterState twoStreamsWithSharedCandidate() {
    }  
        // convention name but no timestamp mapping must still be rejected.
     * Builds a cluster state whose data stream {@code DS} has backing indices for exactly the given generations (the
        ClusterState state = state(3, List.of(1, 2, 3));  
    public void testAddIndexWithoutTimestampMappingFails() {
            () -> MetadataDataStreamsService.modifyDataStream(state, List.of(DataStreamAction.removeBackingIndex(DS, writeIndex)))
            () -> MetadataDataStreamsService.modifyDataStream(state, List.of(DataStreamAction.addBackingIndex("logs-b", "shared-idx")))  
    }
import java.io.IOException;
