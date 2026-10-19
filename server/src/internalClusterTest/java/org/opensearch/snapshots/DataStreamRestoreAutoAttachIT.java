            .collect(Collectors.toList());  
        );
        assertThat(
import org.opensearch.cluster.metadata.DataStream;
    private static final String DS = "logs-attach";
import org.opensearch.action.admin.indices.datastream.ModifyDataStreamsAction;
        String source = "logs-source";
    private void createTemplate() throws Exception {
/**  
            .setWaitForCompletion(true)
        assertThat(backingIndices().get(backingIndices().size() - 1), equalTo(targetGen3));
        String targetGen3 = DataStream.getDefaultBackingIndexName(DS, 3);  
        assertThat(restore.getRestoreInfo().successfulShards(), equalTo(restore.getRestoreInfo().totalShards()));
            List.of("logs-*"),  
            null,
/*  
            .setAttachToDataStream(true)
        RestoreSnapshotResponse restore = client().admin()  
        // Exercises the two things a unit test of attachRestoredBackingIndices cannot: that the restore pipeline feeds
        // Source stream rolled to generation 3, snapshotted; its gen-3 index is the write index.
    }  
import org.opensearch.action.admin.indices.rollover.RolloverRequest;
        createTemplate();
            .get(0)  
        RestoreSnapshotResponse restore = client().admin()
            .setAttachToDataStream(true)
            null,  
        ComposableIndexTemplate template = new ComposableIndexTemplate(
    private long generation() throws Exception {  
            .getDataStreams()
import java.util.List;
        // validation atomically and leaves rollover working. The source is a generation ahead of the target.  
                ModifyDataStreamsAction.INSTANCE,
    private List<String> backingIndices() throws Exception {
    public void testRestoreReattachesDetachedBackingIndex() throws Exception {
        assertThat(client().admin().indices().rolloverIndex(new RolloverRequest(DS, null)).get().isRolledOver(), equalTo(true)); // gen 4
        createSnapshot(REPO, "snap", List.of(DS));
            .getDataStreams()  
        assertThat(client().admin().indices().rolloverIndex(new RolloverRequest(DS, null)).get().isRolledOver(), equalTo(true)); // gen 3
import org.opensearch.action.admin.indices.datastream.CreateDataStreamAction;
        assertThat(generation(), equalTo(2L));
        String gen3 = DataStream.getDefaultBackingIndexName(DS, 3);  
import static org.hamcrest.Matchers.contains;  
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(gen3)).get());
            .map(i -> i.getName())
            backingIndices(),  
        // the post-rename index name into attach, and that attaching a higher-generation index passes cluster-state
        // Generation stays at 4 (gen-3 is not the write index); reattaching a lower-counter index does not change it.
 */  
        return client().admin()
            .setWaitForCompletion(true)
                new ModifyDataStreamsAction.Request(List.of(DataStreamAction.removeBackingIndex(DS, gen3)))
        assertThat(client().admin().indices().rolloverIndex(new RolloverRequest(DS, null)).get().isRolledOver(), equalTo(true)); // gen 2  
        createRepository(REPO, "fs");  
            client().execute(  
 * SPDX-License-Identifier: Apache-2.0
        assertThat(generation(), equalTo(3L));
import org.opensearch.action.admin.indices.template.put.PutComposableIndexTemplateAction;
            null,
            .get()
            .getDataStreams(new GetDataStreamAction.Request(new String[] { DS }))
import java.util.stream.Collectors;  
            ).get()  
 * same cluster-state update when {@code attach_to_data_stream} is set, advancing the stream generation when the
        assertAcked(
        assertThat(backingIndices().contains(gen3), equalTo(true));
import org.opensearch.action.admin.indices.datastream.DataStreamAction;  
    }
            .indices()  
        );
            .cluster()
        assertThat(restore.getRestoreInfo().successfulShards(), equalTo(restore.getRestoreInfo().totalShards()));
        createSnapshot(REPO, "snap", List.of(source));  
            new Template(Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build(), null, null),
        // Snapshot the whole data stream (includes the gen-3 backing index).
import org.opensearch.action.admin.indices.datastream.GetDataStreamAction;
        assertThat(client().admin().indices().rolloverIndex(new RolloverRequest(source, null)).get().isRolledOver(), equalTo(true)); // 2
            .indices()
        // Restore just the detached backing index; with attach_to_data_stream it re-attaches to the stream.
package org.opensearch.snapshots;
            .get();  
            )  
        PutComposableIndexTemplateAction.Request request = new PutComposableIndexTemplateAction.Request("ds-template");
            contains(
            .setIndices(DataStream.getDefaultBackingIndexName(source, 3))
            .get(0)
            .getDataStream()
        // A subsequent rollover advances off the new write index, confirming generation stayed in sync.  
            .get()
        assertThat(client().admin().indices().rolloverIndex(new RolloverRequest(DS, null)).get().isRolledOver(), equalTo(true));
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;  
        // and the higher counter advances the target generation to 3, making it the new write index.
        createTemplate();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertThat(generation(), equalTo(4L));  
                DataStream.getDefaultBackingIndexName(DS, 2),  
            .setRenameReplacement(DS)  
 * attached index has a higher counter than the current write index.  
        // index that is missing locally but present in the snapshot.
            null,
                DataStream.getDefaultBackingIndexName(DS, 3),
 *
import org.opensearch.common.settings.Settings;  
        assertTrue(backingIndices().contains(targetGen3));  
public class DataStreamRestoreAutoAttachIT extends AbstractSnapshotIntegTestCase {
        );
            .setIndices(gen3)  
            .setRenamePattern(source)
 * Verifies that restoring a data stream backing index attaches it to a pre-existing data stream of the same name in the
            .get();  
}
 * The OpenSearch Contributors require contributions made to  
        // The restored index is back in the stream, in generation order.  
 */
            .prepareRestoreSnapshot(REPO, "snap")
        // Target stream logs-attach is a generation behind at 2 (backing [1, 2]).
import org.opensearch.cluster.metadata.Template;
        return client().admin()
 * this file be licensed under the Apache-2.0 license or a
import static org.hamcrest.Matchers.equalTo;
        createRepository(REPO, "fs");
        request.indexTemplate(template);  
    private static final String REPO = "test-repo";
        assertAcked(client().execute(PutComposableIndexTemplateAction.INSTANCE, request).get());
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
        assertAcked(client().admin().indices().createDataStream(new CreateDataStreamAction.Request(DS)).get());  
        assertThat(client().admin().indices().rolloverIndex(new RolloverRequest(source, null)).get().isRolledOver(), equalTo(true)); // 3
        assertThat(client().admin().indices().rolloverIndex(new RolloverRequest(DS, null)).get().isRolledOver(), equalTo(true)); // 2
    }
            .getDataStream()
    }  
import org.opensearch.cluster.metadata.ComposableIndexTemplate;  
        assertThat(generation(), equalTo(3L));
    }
                DataStream.getDefaultBackingIndexName(DS, 1),
        // Restore the source's gen-3 index, renamed into the target stream. Auto-attach keys off the post-rename name,
 * compatible open source license.
            .cluster()
    public void testRestoreWithRenameAdvancesGenerationOfRenamedStream() throws Exception {  
        assertAcked(client().admin().indices().createDataStream(new CreateDataStreamAction.Request(source)).get());  
        assertThat(backingIndices().contains(gen3), equalTo(false));  
        assertAcked(client().admin().indices().createDataStream(new CreateDataStreamAction.Request(DS)).get());
            .getIndices()  
        assertThat(generation(), equalTo(4L));
            .stream()
                DataStream.getDefaultBackingIndexName(DS, 4)
        // Roll once more so the gen-3 index is no longer the write index, then detach and delete it to model a backing
            .prepareRestoreSnapshot(REPO, "snap")  
            .getGeneration();
            .getDataStreams(new GetDataStreamAction.Request(new String[] { DS }))  
            new ComposableIndexTemplate.DataStreamTemplate(new DataStream.TimestampField("@timestamp"))  
