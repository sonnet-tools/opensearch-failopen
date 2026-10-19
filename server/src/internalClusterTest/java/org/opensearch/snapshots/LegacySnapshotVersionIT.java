            builder.field("start_time", 1_000_000L);  
            builder.endArray();
    /**
 * snapshot metadata, and that restore of such snapshots fails gracefully. A real snapshot is taken
    private static final int LEGACY_ES_VERSION_ID = 7_10_02_99;
            repoName,
            .setIndices("test-index")
                .put(BlobStoreRepository.CACHE_REPOSITORY_DATA.getKey(), false)  
                    "LegacySnapshotVersionIT.serializeSnapshotBlob(blob=\"" + blobName + "\")",
            builder.value("test-index");
import static org.hamcrest.Matchers.containsString;
import org.opensearch.core.xcontent.XContentBuilder;
                CodecUtil.writeHeader(indexOutput, SNAPSHOT_CODEC, SNAPSHOT_FORMAT_VERSION);
                    outputStream,  
            builder.startArray("failures");
            builder.field("uuid", snapshotUUID);
import static org.hamcrest.Matchers.nullValue;
        assertThat(createResponse.getSnapshotInfo().successfulShards(), equalTo(createResponse.getSnapshotInfo().totalShards()));
     * Overwrites the {@code snap-{uuid}.dat} blob with a serialized snapshot info blob that uses the  
        );
 * The OpenSearch Contributors require contributions made to  
     */
                    public void close() {}
        assertAcked(client().admin().indices().prepareDelete("test-index"));
        assertThat(snapshots.size(), equalTo(1));
import org.opensearch.common.settings.Settings;
        final String snapshotName = "legacy-es-snapshot";
            builder.endArray();
import org.opensearch.common.io.stream.BytesStreamOutput;
        assertThat(createResponse.getSnapshotInfo().successfulShards(), greaterThan(0));  
 */  
            builder.field("include_global_state", true);
        assertThat(listedSnapshot.version(), nullValue());
import org.opensearch.core.common.bytes.BytesReference;  
    private static final int SNAPSHOT_FORMAT_VERSION = 1;
            ) {  
        GetSnapshotsResponse getResponse = client().admin().cluster().prepareGetSnapshots(repoName).get();  
import org.opensearch.common.xcontent.XContentType;
                    builder.endObject();
            return builder;
import org.apache.lucene.store.OutputStreamIndexOutput;
                        CompressorRegistry.none().threadLocalOutputStream(indexOutputOutputStream)
            .get();
                ) {
import org.opensearch.core.xcontent.MediaTypeRegistry;
        );
     * uncompressed SMILE x-content, and Lucene codec footer.
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;  
            builder.field("name", snapshotName);
            .setWaitForCompletion(true)  
 * Integration test verifying that snapshot listing tolerates legacy Elasticsearch version IDs in
    }  
import org.opensearch.common.lucene.store.IndexOutputOutputStream;  
                )
     */
import java.io.OutputStream;
            builder.startArray("data_streams");
            () -> client().admin().cluster().prepareRestoreSnapshot(repoName, snapshotName).setWaitForCompletion(true).get()  
import org.opensearch.core.xcontent.ToXContent;  
            builder.field("metadata", Collections.emptyMap());
            builder.field("end_time", 2_000_000L);
            builder.field("successful_shards", 1);  
                    XContentBuilder builder = MediaTypeRegistry.contentBuilder(  
 */
                    builder.startObject();
import java.util.List;
            builder.startObject("snapshot");  
        ToXContent legacySnapshotContent = (builder, params) -> {
        final String blobName = BlobStoreRepository.SNAPSHOT_PREFIX + snapshotUUID + ".dat";
                };
            }
        createIndex("test-index");  
import org.opensearch.repositories.blobstore.BlobStoreRepository;
import java.nio.file.Files;  
                CodecUtil.writeFooter(indexOutput);  
        overwriteSnapshotBlobWithLegacyVersion(repoPath, snapshotName, snapshotUUID, LEGACY_ES_VERSION_ID);
        throws IOException {
 * {@code version_id: 7100299} (ES 7.10.2, which lacks the OpenSearch mask bit).
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsResponse;
 * SPDX-License-Identifier: Apache-2.0
            try (
     * given legacy {@code version_id}, matching the format produced by {@link BlobStoreRepository#SNAPSHOT_FORMAT}.
    public void testListingSucceedsAndRestoreFailsForLegacyEsSnapshot() throws Exception {
}
 *
            SnapshotRestoreException.class,
        final Path repoPath = randomRepoPath();
                    )  
 * in an fs repository and its {@code snap-{uuid}.dat} blob is overwritten with one containing  
            .prepareCreateSnapshot(repoName, snapshotName)
    private static final String SNAPSHOT_CODEC = "snapshot";
import java.io.IOException;
        assertThat(listedSnapshot.indices(), equalTo(Collections.singletonList("test-index")));  
        createRepository(  
            builder.startArray("indices");
            builder.field("version_id", legacyVersionId);  
        }  
     * Serializes the given content into a valid {@code snap-*.dat} blob: Lucene codec header,  
        indexRandom(true, client().prepareIndex().setIndex("test-index").setSource("field", "value"));
import org.apache.lucene.codecs.CodecUtil;
                    4096
                    content.toXContent(builder, ToXContent.EMPTY_PARAMS);  
                    blobName,
                    @Override  
package org.opensearch.snapshots;
        try (BytesStreamOutput outputStream = new BytesStreamOutput()) {
            "fs",
        final String snapshotUUID = createResponse.getSnapshotInfo().snapshotId().getUUID();  
                .put("location", repoPath)
        assertThat(listedSnapshot.state(), equalTo(SnapshotState.SUCCESS));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
import java.nio.file.StandardOpenOption;
            builder.endObject();  
            return outputStream.bytes();
public class LegacySnapshotVersionIT extends AbstractSnapshotIntegTestCase {  
                        XContentType.SMILE,
            .cluster()
            Settings.builder()  
 * compatible open source license.
        Files.write(blobPath, BytesReference.toBytes(bytes), StandardOpenOption.TRUNCATE_EXISTING);
import org.opensearch.core.compress.CompressorRegistry;
                }
    }  
        SnapshotInfo listedSnapshot = snapshots.get(0);
        BytesReference bytes = serializeSnapshotBlob(legacySnapshotContent, blobName);
        SnapshotRestoreException e = expectThrows(
        final String repoName = "legacy-test-repo";  
        final Path blobPath = repoPath.resolve(blobName);  
        };
                try (OutputStream indexOutputOutputStream = new IndexOutputOutputStream(indexOutput) {
            builder.endArray();  
            builder.field("state", "SUCCESS");  
        assertThat(listedSnapshot.snapshotId().getUUID(), equalTo(snapshotUUID));  
import static org.hamcrest.Matchers.greaterThan;  
 * this file be licensed under the Apache-2.0 license or a
/*  
        List<SnapshotInfo> snapshots = getResponse.getSnapshots();
import static org.hamcrest.Matchers.equalTo;
    }
import java.util.Collections;  
        CreateSnapshotResponse createResponse = client().admin()  
        assertThat(e.getMessage(), containsString("unknown or unsupported version"));
        assertThat(listedSnapshot.snapshotId().getName(), equalTo(snapshotName));
/**  
    private void overwriteSnapshotBlobWithLegacyVersion(Path repoPath, String snapshotName, String snapshotUUID, int legacyVersionId)  
import java.nio.file.Path;
    /**
    private BytesReference serializeSnapshotBlob(ToXContent content, String blobName) throws IOException {  
                .put("compress", false)
                OutputStreamIndexOutput indexOutput = new OutputStreamIndexOutput(  
            builder.field("total_shards", 1);
