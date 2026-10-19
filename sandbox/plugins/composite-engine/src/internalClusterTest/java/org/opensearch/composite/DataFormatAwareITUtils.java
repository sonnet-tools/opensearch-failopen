 * this file be licensed under the Apache-2.0 license or a
     */  
    static void assertCatalogMatchesUploadedBlobs(IndexShard shard, Client client, Settings nodeSettings, Path segmentRepoPath)
     * Replication invariant: every file in the catalog must exist locally on the shard and be  
 * SPDX-License-Identifier: Apache-2.0
import java.util.HashSet;
     * Upload invariant: each catalog file has a corresponding upload-map entry AND the uploaded  
        Path shardDiskPath = segmentRepoPath.resolve(shardBlobPath(shard, client, nodeSettings).buildAsString());
        }
     */  
import static org.opensearch.test.OpenSearchTestCase.getShardLevelBlobPath;
        }
     * on primary vs replica; see {@link #assertCatalogMatchesLocalAndRemote}.
                "remote blob missing on disk: " + blobFile + " for catalog file " + originalName + " on " + shard.routingEntry(),
     * {@code segments_N} while the catalog tracks the primary's file from the last replication.
     * their format subpath (e.g. {@code parquet/}).
     * Returns catalog files excluding the Lucene {@code segments_N} file. Useful when comparing  
        for (String originalName : uploadMap.keySet()) {
        assertFalse("catalog snapshot has no files on " + shard.routingEntry(), catalog.isEmpty());  
/**  
        return getShardLevelBlobPath(
import org.opensearch.index.remote.RemoteStoreEnums.DataType;  
        );  
final class DataFormatAwareITUtils {
     * {@code segments_N} filename legitimately differs across shard copies.  
        Set<String> files = catalogFiles(shard);  
        return new HashSet<>(Arrays.asList(shard.store().directory().listAll()));  
    /**
    }
 * <ul>
        for (String originalName : catalog) {
        throws IOException {
 * The OpenSearch Contributors require contributions made to  
     * {@link org.opensearch.index.engine.NRTReplicationEngine}): the replica writes its own local  
     * blob physically exists under the shard's remote blob path. Routes non-Lucene files through
            if (originalName.startsWith("segments_")) {
        );
                // non-default format (e.g. parquet/...) — lives under <shard>/<format>/
    private static BlobPath shardBlobPath(IndexShard shard, Client client, Settings nodeSettings) {  
     * <p>The {@code segments_N} file is excluded because its generation is managed independently  
 * compatible open source license.
     * <p>The {@code segments_N} file is excluded because its generation is managed independently
 *
    }
     * listed by the remote segment directory. Extra Lucene infra files (write.lock, segments_N)
            missing.isEmpty()
        Map<String, UploadedSegmentMetadata> uploadMap = primary.getRemoteDirectory().getSegmentsUploadedToRemoteStore();
 */  
    static void assertPrimaryUploadMapOnReplicaDisk(IndexShard primary, IndexShard replica) {  
import org.opensearch.transport.client.Client;
        Set<String> missing = new HashSet<>(catalog);
    }
     * generation is managed independently on primary vs replica (matching
     *   <li>Non-default format files (e.g. parquet) live under {@code <shard>/<format>/}</li>  
        String prefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_SEGMENTS_PATH_PREFIX.get(nodeSettings);
     * <p>File layout on disk:  
            return new HashSet<>(ref.get().getFiles(true));
            assertTrue(  
import java.util.Set;  
        Map<String, UploadedSegmentMetadata> uploadMap = shard.getRemoteDirectory().getSegmentsUploadedToRemoteStore();
        assertTrue(  
                onDisk = replica.shardPath().getDataPath().resolve(format).resolve(file);
    private static void assertSubset(String rhsName, Set<String> catalog, Set<String> rhs, IndexShard shard) {  
    static Set<String> localFiles(IndexShard shard) throws IOException {
     * primary vs replica catalogs: replicas write their own {@code segments_N} with an independent
    private DataFormatAwareITUtils() {}  
     * <ul>
        Set<String> catalog = catalogFilesExcludingSegments(shard);  
 * Shared helpers for DFA integration tests.
import java.util.Arrays;  
    }  
import static org.junit.Assert.assertFalse;  
    /**
        Set<String> catalog = catalogFilesExcludingSegments(shard);
import java.util.Map;
     *  
            new BlobPath(),
     * <p>The {@code segments_N} file is excluded from the catalog comparison because its
                md == null  
        return files;
        assertSubset("local store directory", catalog, local, shard);
                "no upload-map entry for " + originalName + " on " + shard.routingEntry() + "; keys=" + uploadMap.keySet(),
            Path blobFile = blobDir.resolve(md.getUploadedFilename());
import org.opensearch.index.store.RemoteSegmentStoreDirectory.UploadedSegmentMetadata;
            );  
            shard.shardId().getIndexName(),
import org.opensearch.common.settings.Settings;  
     * Cross-shard invariant: every data file the primary uploaded to remote must exist on the
    /**
import org.opensearch.index.shard.IndexShard;
            assertTrue(
        try (GatedCloseable<CatalogSnapshot> ref = shard.getCatalogSnapshot()) {  
    static Set<String> catalogFilesExcludingSegments(IndexShard shard) throws IOException {
/*  
                String file = originalName.substring(sep + 1);
     *  
            int sep = originalName.indexOf('/');
 * <p>Two assertions serve different purposes:  
            client,  
                String format = originalName.substring(0, sep);  
    static void assertCatalogMatchesLocalAndRemote(IndexShard shard) throws IOException {
import static org.junit.Assert.assertTrue;
     * replica's local disk. Validates that segment replication transferred the data files from  
            DataCategory.SEGMENTS,
        assertSubset("remote directory listing", catalog, remote, shard);
    }  
            }
            Path blobDir = sep < 0 ? shardDiskPath : shardDiskPath.getParent().resolve(originalName.substring(0, sep));
import org.opensearch.common.concurrent.GatedCloseable;
 *   <li>{@link #assertCatalogMatchesUploadedBlobs}: upload-focused. Each catalog file must be
 * </ul>
        files.removeIf(f -> f.startsWith("segments_"));
                onDisk = replica.shardPath().resolveIndex().resolve(originalName);  
     *
        Set<String> remote = new HashSet<>(Arrays.asList(shard.getRemoteDirectory().listAll()));
            assertFalse(
        assertFalse("catalog snapshot has no files on " + shard.routingEntry(), catalog.isEmpty());
     * the primary's remote-store uploads to the replica.
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
     * generation (matching {@link org.opensearch.index.engine.NRTReplicationEngine}), so the
            "catalog files missing from " + rhsName + " on " + shard.routingEntry() + ": " + missing + "; " + rhsName + "=" + rhs,
            );
        assertFalse("primary upload map is empty on " + primary.routingEntry(), uploadMap.isEmpty());
        }
            );
            DataType.DATA,
import java.io.IOException;  
 *       Cheap; does not touch the blob store on disk.
    static Set<String> catalogFiles(IndexShard shard) throws IOException {
import java.nio.file.Files;
            } else {
     * on primary vs replica; see {@link #assertCatalogMatchesLocalAndRemote}.
package org.opensearch.composite;
     * </ul>
}  
import java.nio.file.Path;
                "primary-uploaded file missing on replica disk: " + onDisk + " (originalName=" + originalName + ")",
     * may exist locally without appearing in the catalog; that's expected.
            String.valueOf(shard.shardId().id()),  
                Files.isRegularFile(onDisk)  
     *
     *   <li>Lucene files live under {@code <shard>/index/}</li>
            // Non-default formats (e.g. parquet/) are siblings of data/, not children  
import org.opensearch.index.remote.RemoteStoreEnums.DataCategory;
            if (sep < 0) {
        missing.removeAll(rhs);
    /**
 *       validating end-to-end upload correctness.
 *   <li>{@link #assertCatalogMatchesLocalAndRemote}: replication-focused. The catalog snapshot
 *
            final Path onDisk;
    }
    }  
 *       must be a subset of both the local store directory and the remote directory listing.  
     */
                Files.isRegularFile(blobFile)
    }  
import org.opensearch.common.blobstore.BlobPath;
import org.opensearch.indices.RemoteStoreSettings;  
     * These can legitimately differ between the catalog, local disk, and remote.
            int sep = originalName.indexOf('/');  
 *       present in the upload map AND physically on disk under the shard's remote blob path,  
                // default (lucene) format — lives under <shard>/index/
     */
                continue; // segments_N diverges between primary and replica by design  
            }  
 */  
            prefix  
        Set<String> local = localFiles(shard);  
            UploadedSegmentMetadata md = uploadMap.get(originalName);  
