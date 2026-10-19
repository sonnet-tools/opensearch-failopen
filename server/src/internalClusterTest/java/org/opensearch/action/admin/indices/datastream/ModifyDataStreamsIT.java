        assertThat(hidden(legacy), equalTo(true));
    public void testDetachUnhidesAndReattachHidesBackingIndex() throws Exception {  
        // older (non-write) backing index even though its name does not follow the .ds-<name>-NNNNNN convention.  
        createDataStreamIndexTemplate("template", List.of("logs-*"));
            client().admin().indices().prepareCreate(noTimestamp).setMapping("{\"properties\":{\"msg\":{\"type\":\"text\"}}}").get()
            containsInAnyOrder(gen1, gen2, DataStream.getDefaultBackingIndexName(DS, 3), DataStream.getDefaultBackingIndexName(DS, 4))
        // The index must map the data stream's @timestamp field as a date for data stream search to work.
/**  
package org.opensearch.action.admin.indices.datastream;
import static org.hamcrest.Matchers.contains;  
public class ModifyDataStreamsIT extends DataStreamTestCase {  
        String writeIndex = DataStream.getDefaultBackingIndexName(DS, generation());  
        // Index has no @timestamp date field, so data stream search would not work; the add must be rejected.
        );  
        assertThat(after.get(0), equalTo(legacy));
        rolloverDataStream(DS);
    public void testRemoveBackingIndex() throws Exception {
        createDataStreamIndexTemplate("template", List.of("logs-*"));
    }
        // Rollover still advances correctly off the convention-following write index.  
        rolloverDataStream(DS);
        assertThat(hidden(detached), equalTo(false));
        assertThat(hidden(detached), equalTo(true));
    }  
        assertThat(after, hasSize(2));  
 * restored from cold storage that were not re-associated with the stream (opensearch-project/OpenSearch#8271).
import static org.hamcrest.Matchers.containsString;
        );
        rolloverDataStream(DS); // gen 3
    }
        // Re-attach both in one request.
        assertThat(backingIndices(), hasSize(3));  
                DataStream.getDefaultBackingIndexName(DS, 2),
        String gen2 = DataStream.getDefaultBackingIndexName(DS, 2);
        assertThat(generation(), equalTo(4L));
        assertThat(generation(), equalTo(3L));
        // Generation is unchanged: removing a non-write index does not affect it.
 *
        assertAcked(modify(List.of(DataStreamAction.removeBackingIndex(DS, detached))));
 * The OpenSearch Contributors require contributions made to  
        return INDEX_HIDDEN_SETTING.get(client().admin().cluster().prepareState().get().getState().metadata().index(index).getSettings());
        assertThat(
        assertThat(generation(), equalTo(5L));
        assertTrue(client().admin().indices().prepareExists(firstBackingIndex).get().isExists());  
            backingIndices(),
        List<String> after = backingIndices();
        createDataStream(DS);  
import static org.hamcrest.Matchers.hasSize;
        // Detaching makes it visible again (mirrors hide-on-attach).  
    private List<String> backingIndices() throws Exception {
        rolloverDataStream(DS);
        assertAcked(modify(List.of(DataStreamAction.addBackingIndex(DS, gen1), DataStreamAction.addBackingIndex(DS, gen2))));
    public void testCannotAddIndexWithoutTimestampMapping() throws Exception {
 */  
    private boolean hidden(String index) {  
 */
    }
        // Re-attaching hides it again, like every backing index.
        assertThat(generation(), equalTo(genBefore));
        // Re-attach it; the API inserts it back in generation order and leaves the derived generation untouched.
import org.opensearch.cluster.metadata.DataStream;
        // Generation is unchanged (the migrated index is not the write index).
        rolloverDataStream(DS); // gen 2, backing [1, 2]  
    }  
                DataStream.getDefaultBackingIndexName(DS, 3)  
            .collect(Collectors.toList());
import java.util.List;
        assertAcked(modify(List.of(DataStreamAction.addBackingIndex(DS, detached))));  
            .stream()  
        rolloverDataStream(DS); // gen 3  
        String noTimestamp = "no-timestamp-idx";
    }
        );
        assertThat(after.contains(firstBackingIndex), equalTo(false));
        assertThat(hidden(detached), equalTo(true));  
import static org.hamcrest.Matchers.equalTo;  
        createDataStreamIndexTemplate("template", List.of("logs-*"));  
        createDataStream(DS);
        assertThat(generation(), equalTo(3L));  
        );
        createDataStream(DS);
        createDataStreamIndexTemplate("template", List.of("logs-*"));  
        assertThat(after.get(after.size() - 1), equalTo(DataStream.getDefaultBackingIndexName(DS, genBefore)));
        assertAcked(  
        // Models the #8271 flow: a backing index is detached (e.g. tiered to cold storage) and later re-attached.
            .getDataStream()
        return client().execute(ModifyDataStreamsAction.INSTANCE, new ModifyDataStreamsAction.Request(actions)).get();
import static org.hamcrest.Matchers.containsInAnyOrder;
        rolloverDataStream(DS); // gen 4, backing [1, 2, 3, 4]
        // Backing indices are hidden.  
                DataStream.getDefaultBackingIndexName(DS, 1),
        rolloverDataStream(DS); // gen 2, backing [1, 2]  
        // Arbitrary-named index is the oldest backing index; the convention-following write index remains last.  
        assertThat(after, hasSize(3));  
 * End-to-end coverage for the {@code POST /_data_stream/_modify} API: metadata-only add/remove of backing indices.
    private static final String DS = "logs-modify";
        String gen1 = DataStream.getDefaultBackingIndexName(DS, 1);  
            backingIndices(),
    public void testReattachDetachedBackingIndex() throws Exception {  
    public void testMigrateArbitraryNamedIndexIntoDataStream() throws Exception {
        createDataStreamIndexTemplate("template", List.of("logs-*"));
            client().admin().indices().prepareCreate(legacy).setMapping("{\"properties\":{\"@timestamp\":{\"type\":\"date\"}}}").get()  
        // The migrated index is now hidden like every backing index.  
        // A user with a pre-existing regular index wants to migrate to data streams: the legacy index is attached as an
    private AcknowledgedResponse modify(List<DataStreamAction> actions) throws Exception {  
        Exception e = expectThrows(Exception.class, () -> modify(List.of(DataStreamAction.addBackingIndex(DS, noTimestamp))));
        // Rollover still computes the correct next generation, proving generation stayed in sync.  
}
        return getDataStreams(DS).getDataStreams().get(0).getDataStream().getGeneration();  
        List<String> after = backingIndices();
            contains(  
        createDataStreamIndexTemplate("template", List.of("logs-*"));
    public void testCannotRemoveWriteIndex() throws Exception {
/*  
 * A data stream's generation is derived from its backing indices, so it is never set directly. The API is used to
        rolloverDataStream(DS); // gen 2
        assertThat(org.opensearch.ExceptionsHelper.unwrapCause(e).getMessage(), containsString("because it is the write index"));  
        // The removed index still exists as a standalone index; it is only detached from the stream.
        String legacy = "legacy-logs-2023";  
        String firstBackingIndex = DataStream.getDefaultBackingIndexName(DS, 1);
        createDataStream(DS);  
        createDataStream(DS);
    private long generation() throws Exception {
        assertThat(
            .getIndices()
        assertAcked(modify(List.of(DataStreamAction.removeBackingIndex(DS, gen1), DataStreamAction.removeBackingIndex(DS, gen2))));
        assertAcked(modify(List.of(DataStreamAction.removeBackingIndex(DS, detached))));
        rolloverDataStream(DS); // gen 2
        long genBefore = generation();
            org.opensearch.ExceptionsHelper.unwrapCause(e).getMessage(),  
    }
        );
        assertTrue(backingIndices().contains(DataStream.getDefaultBackingIndexName(DS, 5)));  
        assertAcked(modify(List.of(DataStreamAction.addBackingIndex(DS, legacy))));  
            .get(0)  
    }
        assertThat(  
    }
            )
        rolloverDataStream(DS); // gen 2
        String detached = DataStream.getDefaultBackingIndexName(DS, 1);
        createDataStream(DS);
        rolloverDataStream(DS); // gen 3, backing [1, 2, 3]
        assertAcked(modify(List.of(DataStreamAction.addBackingIndex(DS, detached))));
    public void testRemoveAndReattachMultipleIndicesInSingleRequest() throws Exception {
        return getDataStreams(DS).getDataStreams()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertThat(backingIndices(), hasSize(2));  
        createDataStream(DS);
        Exception e = expectThrows(Exception.class, () -> modify(List.of(DataStreamAction.removeBackingIndex(DS, writeIndex))));
        assertAcked(
        assertThat(backingIndices(), hasSize(2));
        assertAcked(modify(List.of(DataStreamAction.removeBackingIndex(DS, firstBackingIndex))));  
 * compatible open source license.
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
    }  
 * this file be licensed under the Apache-2.0 license or a
        rolloverDataStream(DS);
        String detached = DataStream.getDefaultBackingIndexName(DS, 1);
        assertThat(generation(), equalTo(genBefore + 1));
            containsString("does not have a [@timestamp] field mapped as a date type")
    }  
            .map(i -> i.getName())
import java.util.stream.Collectors;
 * re-attach backing indices that exist but are not (or are no longer) part of the stream — for example, indices  
        // Remove two non-write indices in one request.  
 * SPDX-License-Identifier: Apache-2.0
        createDataStreamIndexTemplate("template", List.of("logs-*"));  
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_HIDDEN_SETTING;
