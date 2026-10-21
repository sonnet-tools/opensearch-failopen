     */
import java.io.IOException;
 *
        assertSubset("local store directory", catalog, local, shard);
        Path shardDiskPath = segmentRepoPath.resolve(shardBlobPath(shard, client, nodeSettings).buildAsString());
            );
        Set<String> local = localFiles(shard);
import java.nio.file.Files;
 *   <li>{@link #assertCatalogMatchesUploadedBlobs}: upload-focused. Each catalog file must be
    private static void assertSubset(String rhsName, Set<String> catalog, Set<String> rhs, IndexShard shard) {
     * These can legitimately differ between the catalog, local disk, and remote.
     */
            assertTrue(
        Set<String> files = catalogFiles(shard);
            } else {
        for (String originalName : catalog) {
        assertTrue(
            DataCategory.SEGMENTS,
    /**
        Set<String> missing = new HashSet<>(catalog);
    }
     * their format subpath (e.g. {@code parquet/}).
            Path blobFile = blobDir.resolve(md.getUploadedFilename());
     * Replication invariant: every file in the catalog must exist locally on the shard and be
     *   <li>Lucene files live under {@code <shard>/index/}</li>
     * Returns catalog files excluding the Lucene {@code segments_N} file. Useful when comparing
    static void assertCatalogMatchesUploadedBlobs(IndexShard shard, Client client, Settings nodeSettings, Path segmentRepoPath)
        }
import java.util.Map;
    static Set<String> catalogFiles(IndexShard shard) throws IOException {
        assertFalse("catalog snapshot has no files on " + shard.routingEntry(), catalog.isEmpty());
        Map<String, UploadedSegmentMetadata> uploadMap = primary.getRemoteDirectory().getSegmentsUploadedToRemoteStore();
     * generation (matching {@link org.opensearch.index.engine.NRTReplicationEngine}), so the
        return files;
/**
    }
            client,
            return new HashSet<>(ref.get().getFiles(true));
import org.opensearch.common.settings.Settings;
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        Map<String, UploadedSegmentMetadata> uploadMap = shard.getRemoteDirectory().getSegmentsUploadedToRemoteStore();
        Set<String> catalog = catalogFilesExcludingSegments(shard);
package org.opensearch.composite;
 *       validating end-to-end upload correctness.
    private static BlobPath shardBlobPath(IndexShard shard, Client client, Settings nodeSettings) {
            "catalog files missing from " + rhsName + " on " + shard.routingEntry() + ": " + missing + "; " + rhsName + "=" + rhs,
    }
     *   <li>Non-default format files (e.g. parquet) live under {@code <shard>/<format>/}</li>
     * <p>The {@code segments_N} file is excluded because its generation is managed independently
        Set<String> remote = new HashSet<>(Arrays.asList(shard.getRemoteDirectory().listAll()));
            int sep = originalName.indexOf('/');
                "primary-uploaded file missing on replica disk: " + onDisk + " (originalName=" + originalName + ")",
     * <p>The {@code segments_N} file is excluded because its generation is managed independently
                "no upload-map entry for " + originalName + " on " + shard.routingEntry() + "; keys=" + uploadMap.keySet(),
                "remote blob missing on disk: " + blobFile + " for catalog file " + originalName + " on " + shard.routingEntry(),
            assertTrue(
        assertSubset("remote directory listing", catalog, remote, shard);
            prefix
     * may exist locally without appearing in the catalog; that's expected.
        return new HashSet<>(Arrays.asList(shard.store().directory().listAll()));
 * <ul>
     * primary vs replica catalogs: replicas write their own {@code segments_N} with an independent
        );
     * listed by the remote segment directory. Extra Lucene infra files (write.lock, segments_N)
                // default (lucene) format — lives under <shard>/index/
import org.opensearch.index.shard.IndexShard;
import static org.junit.Assert.assertTrue;
            shard.shardId().getIndexName(),
 * </ul>
    }
import java.util.Arrays;
        assertFalse("catalog snapshot has no files on " + shard.routingEntry(), catalog.isEmpty());
    }
import java.nio.file.Path;
                String file = originalName.substring(sep + 1);
 * SPDX-License-Identifier: Apache-2.0
     * generation is managed independently on primary vs replica (matching
import static org.junit.Assert.assertFalse;
 *   <li>{@link #assertCatalogMatchesLocalAndRemote}: replication-focused. The catalog snapshot
        files.removeIf(f -> f.startsWith("segments_"));
        }
     * Upload invariant: each catalog file has a corresponding upload-map entry AND the uploaded
        return getShardLevelBlobPath(
        }
            );
                continue; // segments_N diverges between primary and replica by design
     * {@code segments_N} filename legitimately differs across shard copies.
 *       present in the upload map AND physically on disk under the shard's remote blob path,
 * <p>Two assertions serve different purposes:
     * the primary's remote-store uploads to the replica.
import org.opensearch.index.remote.RemoteStoreEnums.DataType;
    }
                // non-default format (e.g. parquet/...) — lives under <shard>/<format>/
     */
            }
        );
import java.util.HashSet;
        throws IOException {
 * this file be licensed under the Apache-2.0 license or a
        Set<String> catalog = catalogFilesExcludingSegments(shard);
 *       Cheap; does not touch the blob store on disk.
            assertFalse(
    static void assertPrimaryUploadMapOnReplicaDisk(IndexShard primary, IndexShard replica) {
            if (sep < 0) {
            UploadedSegmentMetadata md = uploadMap.get(originalName);
     * Cross-shard invariant: every data file the primary uploaded to remote must exist on the
     *
 *
/*
        for (String originalName : uploadMap.keySet()) {
import static org.opensearch.test.OpenSearchTestCase.getShardLevelBlobPath;
        try (GatedCloseable<CatalogSnapshot> ref = shard.getCatalogSnapshot()) {
    /**
     * <p>The {@code segments_N} file is excluded from the catalog comparison because its
            new BlobPath(),
    /**
 * compatible open source license.
import java.util.Set;
    private DataFormatAwareITUtils() {}
     *
                Files.isRegularFile(onDisk)
 * Shared helpers for DFA integration tests.
     * <p>File layout on disk:
     * {@link org.opensearch.index.engine.NRTReplicationEngine}): the replica writes its own local
            if (originalName.startsWith("segments_")) {
import org.opensearch.index.store.RemoteSegmentStoreDirectory.UploadedSegmentMetadata;
        String prefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_SEGMENTS_PATH_PREFIX.get(nodeSettings);
            int sep = originalName.indexOf('/');
    }
            String.valueOf(shard.shardId().id()),
    }
 * The OpenSearch Contributors require contributions made to
     *
    /**
    static void assertCatalogMatchesLocalAndRemote(IndexShard shard) throws IOException {
 *       must be a subset of both the local store directory and the remote directory listing.
        assertFalse("primary upload map is empty on " + primary.routingEntry(), uploadMap.isEmpty());
import org.opensearch.indices.RemoteStoreSettings;
            );
            missing.isEmpty()
                onDisk = replica.shardPath().resolveIndex().resolve(originalName);
        missing.removeAll(rhs);
import org.opensearch.transport.client.Client;
     *
import org.opensearch.common.blobstore.BlobPath;
            }
     */
 */
import org.opensearch.index.remote.RemoteStoreEnums.DataCategory;
     * <ul>
     * on primary vs replica; see {@link #assertCatalogMatchesLocalAndRemote}.
import org.opensearch.common.concurrent.GatedCloseable;
                md == null
    static Set<String> localFiles(IndexShard shard) throws IOException {
            DataType.DATA,
final class DataFormatAwareITUtils {
     * blob physically exists under the shard's remote blob path. Routes non-Lucene files through
     * </ul>
 */
    static Set<String> catalogFilesExcludingSegments(IndexShard shard) throws IOException {
     * replica's local disk. Validates that segment replication transferred the data files from
                Files.isRegularFile(blobFile)
            Path blobDir = sep < 0 ? shardDiskPath : shardDiskPath.getParent().resolve(originalName.substring(0, sep));
}
            // Non-default formats (e.g. parquet/) are siblings of data/, not children
                onDisk = replica.shardPath().getDataPath().resolve(format).resolve(file);
     * {@code segments_N} while the catalog tracks the primary's file from the last replication.
                String format = originalName.substring(0, sep);
     * on primary vs replica; see {@link #assertCatalogMatchesLocalAndRemote}.
            final Path onDisk;
