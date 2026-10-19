            .get()
        // Restore just the detached backing index; with attach_to_data_stream it re-attaches to the stream.
 * this file be licensed under the Apache-2.0 license or a
                DataStream.getDefaultBackingIndexName(DS, 2),
        assertThat(client().admin().indices().rolloverIndex(new RolloverRequest(source, null)).get().isRolledOver(), equalTo(true)); // 3
            .getDataStream()
import org.opensearch.action.admin.indices.rollover.RolloverRequest;
package org.opensearch.snapshots;
        assertThat(generation(), equalTo(4L));
    private static final String REPO = "test-repo";
import org.opensearch.action.admin.indices.template.put.PutComposableIndexTemplateAction;
    private List<String> backingIndices() throws Exception {
        // Exercises the two things a unit test of attachRestoredBackingIndices cannot: that the restore pipeline feeds
        // Roll once more so the gen-3 index is no longer the write index, then detach and delete it to model a backing
import org.opensearch.cluster.metadata.ComposableIndexTemplate;
                new ModifyDataStreamsAction.Request(List.of(DataStreamAction.removeBackingIndex(DS, gen3)))
        assertAcked(client().admin().indices().createDataStream(new CreateDataStreamAction.Request(DS)).get());
        );
import static org.hamcrest.Matchers.equalTo;
        assertThat(client().admin().indices().rolloverIndex(new RolloverRequest(DS, null)).get().isRolledOver(), equalTo(true)); // gen 4
        createSnapshot(REPO, "snap", List.of(DS));
    }
        createRepository(REPO, "fs");
        assertAcked(client().execute(PutComposableIndexTemplateAction.INSTANCE, request).get());
        assertAcked(client().admin().indices().createDataStream(new CreateDataStreamAction.Request(source)).get());
        // and the higher counter advances the target generation to 3, making it the new write index.
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
            .getDataStream()
        String gen3 = DataStream.getDefaultBackingIndexName(DS, 3);
        // A subsequent rollover advances off the new write index, confirming generation stayed in sync.
 * compatible open source license.
        // the post-rename index name into attach, and that attaching a higher-generation index passes cluster-state
 * SPDX-License-Identifier: Apache-2.0
            .get()
            .getIndices()
        String targetGen3 = DataStream.getDefaultBackingIndexName(DS, 3);
import org.opensearch.action.admin.indices.datastream.GetDataStreamAction;
            client().execute(
        // Source stream rolled to generation 3, snapshotted; its gen-3 index is the write index.
        // The restored index is back in the stream, in generation order.
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertThat(backingIndices().get(backingIndices().size() - 1), equalTo(targetGen3));
            .setAttachToDataStream(true)
            null,
            null,
            ).get()
import static org.hamcrest.Matchers.contains;
            .get();
import org.opensearch.action.admin.indices.datastream.ModifyDataStreamsAction;
        assertThat(generation(), equalTo(2L));
        createTemplate();
        assertThat(client().admin().indices().rolloverIndex(new RolloverRequest(source, null)).get().isRolledOver(), equalTo(true)); // 2
        RestoreSnapshotResponse restore = client().admin()
 */
            .indices()
                DataStream.getDefaultBackingIndexName(DS, 4)
            .setWaitForCompletion(true)
    public void testRestoreWithRenameAdvancesGenerationOfRenamedStream() throws Exception {
            .get(0)
    }
            .setIndices(gen3)
            .map(i -> i.getName())
 */
        // index that is missing locally but present in the snapshot.
import java.util.List;
        assertAcked(
 * The OpenSearch Contributors require contributions made to
            .getDataStreams()
        assertThat(generation(), equalTo(4L));
            .setWaitForCompletion(true)
        // validation atomically and leaves rollover working. The source is a generation ahead of the target.
            contains(
            .collect(Collectors.toList());
        assertThat(generation(), equalTo(3L));
        RestoreSnapshotResponse restore = client().admin()
        assertAcked(client().admin().indices().createDataStream(new CreateDataStreamAction.Request(DS)).get());
            List.of("logs-*"),
        assertThat(client().admin().indices().rolloverIndex(new RolloverRequest(DS, null)).get().isRolledOver(), equalTo(true)); // 2
            null,
            .getGeneration();
 * attached index has a higher counter than the current write index.
            null,
    private void createTemplate() throws Exception {
        assertThat(backingIndices().contains(gen3), equalTo(true));
                DataStream.getDefaultBackingIndexName(DS, 1),
            .setIndices(DataStream.getDefaultBackingIndexName(source, 3))
        assertThat(
/*
            .getDataStreams(new GetDataStreamAction.Request(new String[] { DS }))
            .setAttachToDataStream(true)
        // Target stream logs-attach is a generation behind at 2 (backing [1, 2]).
            new Template(Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build(), null, null),
import java.util.stream.Collectors;
        assertThat(generation(), equalTo(3L));
import org.opensearch.common.settings.Settings;
        // Restore the source's gen-3 index, renamed into the target stream. Auto-attach keys off the post-rename name,
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(gen3)).get());
            .setRenameReplacement(DS)
        PutComposableIndexTemplateAction.Request request = new PutComposableIndexTemplateAction.Request("ds-template");
            .indices()
        return client().admin()
        assertThat(client().admin().indices().rolloverIndex(new RolloverRequest(DS, null)).get().isRolledOver(), equalTo(true)); // gen 3
            .stream()
            )
        createTemplate();
}
 * same cluster-state update when {@code attach_to_data_stream} is set, advancing the stream generation when the
            .prepareRestoreSnapshot(REPO, "snap")
        // Generation stays at 4 (gen-3 is not the write index); reattaching a lower-counter index does not change it.
/**
            .get(0)
    }
    private static final String DS = "logs-attach";
    public void testRestoreReattachesDetachedBackingIndex() throws Exception {
import org.opensearch.action.admin.indices.datastream.DataStreamAction;
        );
        String source = "logs-source";
        assertTrue(backingIndices().contains(targetGen3));
                ModifyDataStreamsAction.INSTANCE,
import org.opensearch.cluster.metadata.Template;
            .cluster()
            .prepareRestoreSnapshot(REPO, "snap")
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
        assertThat(restore.getRestoreInfo().successfulShards(), equalTo(restore.getRestoreInfo().totalShards()));
            .getDataStreams()
import org.opensearch.action.admin.indices.datastream.CreateDataStreamAction;
 *
            .setRenamePattern(source)
    }
    private long generation() throws Exception {
        createRepository(REPO, "fs");
            .getDataStreams(new GetDataStreamAction.Request(new String[] { DS }))
        // Snapshot the whole data stream (includes the gen-3 backing index).
        assertThat(client().admin().indices().rolloverIndex(new RolloverRequest(DS, null)).get().isRolledOver(), equalTo(true));
                DataStream.getDefaultBackingIndexName(DS, 3),
        ComposableIndexTemplate template = new ComposableIndexTemplate(
            .cluster()
        createSnapshot(REPO, "snap", List.of(source));
            backingIndices(),
        return client().admin()
 * Verifies that restoring a data stream backing index attaches it to a pre-existing data stream of the same name in the
            .get();
        assertThat(backingIndices().contains(gen3), equalTo(false));
    }
        );
import org.opensearch.cluster.metadata.DataStream;
        assertThat(restore.getRestoreInfo().successfulShards(), equalTo(restore.getRestoreInfo().totalShards()));
        assertThat(client().admin().indices().rolloverIndex(new RolloverRequest(DS, null)).get().isRolledOver(), equalTo(true)); // gen 2
        request.indexTemplate(template);
public class DataStreamRestoreAutoAttachIT extends AbstractSnapshotIntegTestCase {
            new ComposableIndexTemplate.DataStreamTemplate(new DataStream.TimestampField("@timestamp"))
