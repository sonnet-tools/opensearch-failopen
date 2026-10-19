 *
    public void testCannotRemoveWriteIndex() throws Exception {
            containsInAnyOrder(gen1, gen2, DataStream.getDefaultBackingIndexName(DS, 3), DataStream.getDefaultBackingIndexName(DS, 4))
    private static final String DS = "logs-modify";
        assertAcked(modify(List.of(DataStreamAction.addBackingIndex(DS, legacy))));
    }
 */
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        createDataStream(DS);
        rolloverDataStream(DS); // gen 3, backing [1, 2, 3]
        assertThat(after, hasSize(3));
        String gen2 = DataStream.getDefaultBackingIndexName(DS, 2);
 * re-attach backing indices that exist but are not (or are no longer) part of the stream — for example, indices
        return getDataStreams(DS).getDataStreams().get(0).getDataStream().getGeneration();
        // Re-attach it; the API inserts it back in generation order and leaves the derived generation untouched.
        rolloverDataStream(DS); // gen 3
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_HIDDEN_SETTING;
        assertAcked(modify(List.of(DataStreamAction.removeBackingIndex(DS, detached))));
    public void testReattachDetachedBackingIndex() throws Exception {
import static org.hamcrest.Matchers.hasSize;
    private long generation() throws Exception {
    }
        createDataStream(DS);
        createDataStreamIndexTemplate("template", List.of("logs-*"));
            containsString("does not have a [@timestamp] field mapped as a date type")
                DataStream.getDefaultBackingIndexName(DS, 2),
    public void testRemoveBackingIndex() throws Exception {
    }
        createDataStream(DS);
        assertThat(backingIndices(), hasSize(2));
        assertAcked(modify(List.of(DataStreamAction.removeBackingIndex(DS, firstBackingIndex))));
import java.util.stream.Collectors;
        rolloverDataStream(DS);
 */
        );
        createDataStream(DS);
        createDataStreamIndexTemplate("template", List.of("logs-*"));
        String detached = DataStream.getDefaultBackingIndexName(DS, 1);
        List<String> after = backingIndices();
        assertTrue(backingIndices().contains(DataStream.getDefaultBackingIndexName(DS, 5)));
import java.util.List;
        String legacy = "legacy-logs-2023";
        // Re-attaching hides it again, like every backing index.
    public void testMigrateArbitraryNamedIndexIntoDataStream() throws Exception {
        );
 * End-to-end coverage for the {@code POST /_data_stream/_modify} API: metadata-only add/remove of backing indices.
            backingIndices(),
        assertThat(
            .stream()
            client().admin().indices().prepareCreate(noTimestamp).setMapping("{\"properties\":{\"msg\":{\"type\":\"text\"}}}").get()
    private boolean hidden(String index) {
        assertAcked(
        assertAcked(modify(List.of(DataStreamAction.removeBackingIndex(DS, detached))));
        // Backing indices are hidden.
        assertAcked(modify(List.of(DataStreamAction.addBackingIndex(DS, gen1), DataStreamAction.addBackingIndex(DS, gen2))));
    }
        return INDEX_HIDDEN_SETTING.get(client().admin().cluster().prepareState().get().getState().metadata().index(index).getSettings());
        Exception e = expectThrows(Exception.class, () -> modify(List.of(DataStreamAction.addBackingIndex(DS, noTimestamp))));
        createDataStreamIndexTemplate("template", List.of("logs-*"));
            .getDataStream()
            .get(0)
        // Re-attach both in one request.
            .collect(Collectors.toList());
    public void testRemoveAndReattachMultipleIndicesInSingleRequest() throws Exception {
        rolloverDataStream(DS); // gen 2
    }
        String firstBackingIndex = DataStream.getDefaultBackingIndexName(DS, 1);
        return getDataStreams(DS).getDataStreams()
            org.opensearch.ExceptionsHelper.unwrapCause(e).getMessage(),
        // The index must map the data stream's @timestamp field as a date for data stream search to work.
        // Models the #8271 flow: a backing index is detached (e.g. tiered to cold storage) and later re-attached.
 * The OpenSearch Contributors require contributions made to
        assertTrue(client().admin().indices().prepareExists(firstBackingIndex).get().isExists());
    }
        String detached = DataStream.getDefaultBackingIndexName(DS, 1);
        assertThat(
        // Remove two non-write indices in one request.
        // older (non-write) backing index even though its name does not follow the .ds-<name>-NNNNNN convention.
            .map(i -> i.getName())
        );
 * this file be licensed under the Apache-2.0 license or a
    }
        rolloverDataStream(DS);
 * SPDX-License-Identifier: Apache-2.0
        assertThat(after.contains(firstBackingIndex), equalTo(false));
        rolloverDataStream(DS); // gen 2, backing [1, 2]
        createDataStream(DS);
        // Rollover still computes the correct next generation, proving generation stayed in sync.
import static org.hamcrest.Matchers.containsString;
        assertThat(after.get(0), equalTo(legacy));
            backingIndices(),
        // Arbitrary-named index is the oldest backing index; the convention-following write index remains last.
        createDataStreamIndexTemplate("template", List.of("logs-*"));
        createDataStream(DS);
        long genBefore = generation();
}
        assertThat(generation(), equalTo(genBefore + 1));
        assertThat(generation(), equalTo(5L));
        // Detaching makes it visible again (mirrors hide-on-attach).
        // The migrated index is now hidden like every backing index.
        assertThat(hidden(detached), equalTo(true));
public class ModifyDataStreamsIT extends DataStreamTestCase {
        rolloverDataStream(DS); // gen 2, backing [1, 2]
    }
        assertThat(generation(), equalTo(3L));
        String writeIndex = DataStream.getDefaultBackingIndexName(DS, generation());
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        // Generation is unchanged: removing a non-write index does not affect it.
            client().admin().indices().prepareCreate(legacy).setMapping("{\"properties\":{\"@timestamp\":{\"type\":\"date\"}}}").get()
        // Rollover still advances correctly off the convention-following write index.
        assertThat(after.get(after.size() - 1), equalTo(DataStream.getDefaultBackingIndexName(DS, genBefore)));
        rolloverDataStream(DS); // gen 2
        List<String> after = backingIndices();
        assertAcked(modify(List.of(DataStreamAction.addBackingIndex(DS, detached))));
        // Generation is unchanged (the migrated index is not the write index).
        assertAcked(
    }
        assertThat(backingIndices(), hasSize(3));
 * compatible open source license.
            )
import static org.hamcrest.Matchers.equalTo;
    public void testDetachUnhidesAndReattachHidesBackingIndex() throws Exception {
        assertThat(hidden(detached), equalTo(false));
/*
        String noTimestamp = "no-timestamp-idx";
    public void testCannotAddIndexWithoutTimestampMapping() throws Exception {
        createDataStreamIndexTemplate("template", List.of("logs-*"));
        Exception e = expectThrows(Exception.class, () -> modify(List.of(DataStreamAction.removeBackingIndex(DS, writeIndex))));
        assertThat(generation(), equalTo(4L));
import static org.hamcrest.Matchers.contains;
        rolloverDataStream(DS);
        // The removed index still exists as a standalone index; it is only detached from the stream.
        createDataStreamIndexTemplate("template", List.of("logs-*"));
        assertThat(hidden(detached), equalTo(true));
import org.opensearch.cluster.metadata.DataStream;
package org.opensearch.action.admin.indices.datastream;
import static org.hamcrest.Matchers.containsInAnyOrder;
    private List<String> backingIndices() throws Exception {
            contains(
            .getIndices()
        createDataStream(DS);
        String gen1 = DataStream.getDefaultBackingIndexName(DS, 1);
        assertAcked(modify(List.of(DataStreamAction.addBackingIndex(DS, detached))));
        assertThat(after, hasSize(2));
        assertThat(org.opensearch.ExceptionsHelper.unwrapCause(e).getMessage(), containsString("because it is the write index"));
    }
        rolloverDataStream(DS); // gen 2
        assertThat(generation(), equalTo(3L));
 * A data stream's generation is derived from its backing indices, so it is never set directly. The API is used to
        // A user with a pre-existing regular index wants to migrate to data streams: the legacy index is attached as an
    private AcknowledgedResponse modify(List<DataStreamAction> actions) throws Exception {
        rolloverDataStream(DS);
        );
                DataStream.getDefaultBackingIndexName(DS, 3)
 * restored from cold storage that were not re-associated with the stream (opensearch-project/OpenSearch#8271).
        assertThat(hidden(legacy), equalTo(true));
        rolloverDataStream(DS); // gen 3
        assertThat(backingIndices(), hasSize(2));
        rolloverDataStream(DS); // gen 4, backing [1, 2, 3, 4]
        return client().execute(ModifyDataStreamsAction.INSTANCE, new ModifyDataStreamsAction.Request(actions)).get();
        );
        createDataStreamIndexTemplate("template", List.of("logs-*"));
        assertAcked(modify(List.of(DataStreamAction.removeBackingIndex(DS, gen1), DataStreamAction.removeBackingIndex(DS, gen2))));
    }
/**
                DataStream.getDefaultBackingIndexName(DS, 1),
        // Index has no @timestamp date field, so data stream search would not work; the add must be rejected.
        assertThat(generation(), equalTo(genBefore));
        assertThat(
