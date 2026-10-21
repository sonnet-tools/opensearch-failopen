 * this file be licensed under the Apache-2.0 license or a
        throws IOException {
            builder.startArray("indices");
                )
                }
 * Integration test verifying that snapshot listing tolerates legacy Elasticsearch version IDs in
            return outputStream.bytes();
            builder.field("include_global_state", true);
        );
            .cluster()
                OutputStreamIndexOutput indexOutput = new OutputStreamIndexOutput(
            repoName,
 * in an fs repository and its {@code snap-{uuid}.dat} blob is overwritten with one containing
            builder.endObject();
 *
                try (OutputStream indexOutputOutputStream = new IndexOutputOutputStream(indexOutput) {
        assertThat(createResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
        List<SnapshotInfo> snapshots = getResponse.getSnapshots();
            builder.field("total_shards", 1);
        createRepository(
     */
        final Path repoPath = randomRepoPath();
        createIndex("test-index");
            "fs",
        overwriteSnapshotBlobWithLegacyVersion(repoPath, snapshotName, snapshotUUID, LEGACY_ES_VERSION_ID);
import org.opensearch.core.compress.CompressorRegistry;
    private BytesReference serializeSnapshotBlob(ToXContent content, String blobName) throws IOException {
            builder.field("uuid", snapshotUUID);
/**
        assertThat(listedSnapshot.state(), equalTo(SnapshotState.SUCCESS));
    }
                    )
                    builder.startObject();
import org.opensearch.common.lucene.store.IndexOutputOutputStream;
            builder.startArray("failures");
import org.opensearch.common.settings.Settings;
import java.nio.file.Path;
import static org.hamcrest.Matchers.greaterThan;
        ToXContent legacySnapshotContent = (builder, params) -> {
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
     * Serializes the given content into a valid {@code snap-*.dat} blob: Lucene codec header,
     * Overwrites the {@code snap-{uuid}.dat} blob with a serialized snapshot info blob that uses the
 * snapshot metadata, and that restore of such snapshots fails gracefully. A real snapshot is taken
            () -> client().admin().cluster().prepareRestoreSnapshot(repoName, snapshotName).setWaitForCompletion(true).get()
        );
        GetSnapshotsResponse getResponse = client().admin().cluster().prepareGetSnapshots(repoName).get();
import java.nio.file.StandardOpenOption;
 * {@code version_id: 7100299} (ES 7.10.2, which lacks the OpenSearch mask bit).
        SnapshotInfo listedSnapshot = snapshots.get(0);
                    @Override
        try (BytesStreamOutput outputStream = new BytesStreamOutput()) {
        indexRandom(true, client().prepareIndex().setIndex("test-index").setSource("field", "value"));
                    blobName,
                    "LegacySnapshotVersionIT.serializeSnapshotBlob(blob=\"" + blobName + "\")",
        BytesReference bytes = serializeSnapshotBlob(legacySnapshotContent, blobName);
            .prepareCreateSnapshot(repoName, snapshotName)
    private void overwriteSnapshotBlobWithLegacyVersion(Path repoPath, String snapshotName, String snapshotUUID, int legacyVersionId)
 * The OpenSearch Contributors require contributions made to
        assertThat(listedSnapshot.snapshotId().getUUID(), equalTo(snapshotUUID));
import java.io.IOException;
            builder.endArray();
 * SPDX-License-Identifier: Apache-2.0
                        XContentType.SMILE,
public class LegacySnapshotVersionIT extends AbstractSnapshotIntegTestCase {
            builder.field("state", "SUCCESS");
import org.opensearch.core.xcontent.MediaTypeRegistry;
 */
        final String snapshotUUID = createResponse.getSnapshotInfo().snapshotId().getUUID();
        final String snapshotName = "legacy-es-snapshot";
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import org.opensearch.core.common.bytes.BytesReference;
        final String blobName = BlobStoreRepository.SNAPSHOT_PREFIX + snapshotUUID + ".dat";
    private static final int SNAPSHOT_FORMAT_VERSION = 1;
        assertAcked(client().admin().indices().prepareDelete("test-index"));
                .put("location", repoPath)
/*
                };
                .put("compress", false)
            .setIndices("test-index")
                .put(BlobStoreRepository.CACHE_REPOSITORY_DATA.getKey(), false)
            return builder;
    private static final int LEGACY_ES_VERSION_ID = 7_10_02_99;
                    public void close() {}
        SnapshotRestoreException e = expectThrows(
                    XContentBuilder builder = MediaTypeRegistry.contentBuilder(
    private static final String SNAPSHOT_CODEC = "snapshot";
}
                CodecUtil.writeHeader(indexOutput, SNAPSHOT_CODEC, SNAPSHOT_FORMAT_VERSION);
    /**
 * compatible open source license.
        Files.write(blobPath, BytesReference.toBytes(bytes), StandardOpenOption.TRUNCATE_EXISTING);
    }
import org.apache.lucene.codecs.CodecUtil;
                CodecUtil.writeFooter(indexOutput);
            builder.field("version_id", legacyVersionId);
    public void testListingSucceedsAndRestoreFailsForLegacyEsSnapshot() throws Exception {
        final String repoName = "legacy-test-repo";
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsResponse;
        CreateSnapshotResponse createResponse = client().admin()
            }
                    4096
                        CompressorRegistry.none().threadLocalOutputStream(indexOutputOutputStream)
import org.opensearch.common.xcontent.XContentType;
                    outputStream,
                    content.toXContent(builder, ToXContent.EMPTY_PARAMS);
import static org.hamcrest.Matchers.equalTo;
        assertThat(listedSnapshot.snapshotId().getName(), equalTo(snapshotName));
import org.opensearch.common.io.stream.BytesStreamOutput;
import static org.hamcrest.Matchers.containsString;
            builder.field("start_time", 1_000_000L);
            builder.field("name", snapshotName);
        assertThat(listedSnapshot.version(), nullValue());
                ) {
 */
import org.opensearch.repositories.blobstore.BlobStoreRepository;
            ) {
import org.opensearch.core.xcontent.ToXContent;
     */
            builder.field("end_time", 2_000_000L);
import org.opensearch.core.xcontent.XContentBuilder;
        };
            builder.value("test-index");
     * given legacy {@code version_id}, matching the format produced by {@link BlobStoreRepository#SNAPSHOT_FORMAT}.
import java.util.Collections;
import static org.hamcrest.Matchers.nullValue;
            builder.startObject("snapshot");
     * uncompressed SMILE x-content, and Lucene codec footer.
    /**
            try (
    }
import org.apache.lucene.store.OutputStreamIndexOutput;
            builder.field("metadata", Collections.emptyMap());
        assertThat(snapshots.size(), equalTo(1));
        assertThat(e.getMessage(), containsString("unknown or unsupported version"));
package org.opensearch.snapshots;
                    builder.endObject();
            .get();
import java.util.List;
        assertThat(createResponse.getSnapshotInfo().successfulShards(), equalTo(createResponse.getSnapshotInfo().totalShards()));
        }
            builder.field("successful_shards", 1);
            .setWaitForCompletion(true)
            builder.endArray();
            builder.startArray("data_streams");
            Settings.builder()
            SnapshotRestoreException.class,
        assertThat(listedSnapshot.indices(), equalTo(Collections.singletonList("test-index")));
            builder.endArray();
import java.nio.file.Files;
import java.io.OutputStream;
        final Path blobPath = repoPath.resolve(blobName);
