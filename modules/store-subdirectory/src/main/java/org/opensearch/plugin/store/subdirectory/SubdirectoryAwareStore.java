        Path filePath = shardPath().getDataPath().resolve(fileName);
        Directory directory,
import java.util.HashMap;
        ShardPath shardPath
            SubdirectoryAwareStore.logger,
import org.apache.lucene.index.SegmentInfos;
                metadata.length(),
            directory,
 * A store implementation that supports files organized in subdirectories.
        totalNumDocs += this.loadSubdirectoryMetadata(commit, builder);
     * Load metadata from SegmentInfos by reusing Store.MetadataSnapshot.loadMetadata
                    subdirectoryNonSegmentInfoFiles.add(fileName);
            // Use the same pattern as Store.loadMetadata to extract file metadata
     * @param indexSettings the index settings
        ShardPath shardPath,
 * This store extends the standard OpenSearch Store to handle files that may be
     * @param shardId the shard ID
     *
                long length = in.length();
    }
            builder.put(prefixedName, prefixedMetadata);
        try (Directory dir = FSDirectory.open(filePath.getParent())) {
     * Compute and store metadata for a single file.
 * transferred between nodes.
        return new MetadataSnapshot(Collections.unmodifiableMap(builder), Collections.unmodifiableMap(commitUserDataBuilder), totalNumDocs);
        }
     * @param directory the directory to use for the store
        }
     * Constructor for SubdirectoryAwareStore.
import org.apache.lucene.store.IOContext;
     *
            super(delegate, shardPath);
            loadMetadataFromSegmentInfos(segmentInfos, subdirectory, builder, parent);
            shardId,
        }
                } else {
 * compatible open source license.
 *
     * and also compute metadata for non-segment files.
            Path filePath = Path.of(fileName);
    private long loadMetadataFromSubdirectorySegmentsFile(String segmentsFilePath, Map<String, StoreFileMetadata> builder)
import org.opensearch.index.shard.ShardPath;
        );
            );
import org.opensearch.plugins.IndexStorePlugin;
     * @param shardId the shard ID
    ) {
            SegmentInfos segmentInfos = SegmentInfos.readCommit(subdirectory, segmentsFileName);
import java.util.Collections;
            try (IndexInput in = dir.openInput(localFileName, IOContext.READONCE)) {
     * @param shardPath the shard path
import org.apache.lucene.index.IndexCommit;
import java.nio.file.Path;
}
        totalNumDocs += regularMetadata.numDocs;
        Path filePath = Path.of(segmentsFilePath);
     */
     * Load metadata from a specific subdirectory segments_N file
 * that handles path resolution and file operations across subdirectories.
import org.apache.lucene.store.Directory;
 */
        for (String nonSegmentInfoFile : subdirectoryNonSegmentInfoFiles) {
/*
    }
                prefixedName,
    /**
    }
     * @param directory the directory to use for the store
    }
     * A Lucene Directory implementation that handles files in subdirectories.
            // Read the SegmentInfos from the segments file
 * this file be licensed under the Apache-2.0 license or a
        Set<String> subdirectorySegmentInfoFiles = new HashSet<>();
        }
        Map<String, String> commitUserDataBuilder = new HashMap<>(regularMetadata.userData);
        // Process non-segment files that weren't loaded by segmentInfo
            segmentInfos,
        Path parent = filePath.getParent();
        final SegmentInfos segmentCommitInfos = Lucene.readSegmentInfos(commit);
        super(shardId, indexSettings, new SubdirectoryAwareDirectory(directory, shardPath), shardLock, onClose, shardPath);
     * @param onClose the on close callback
        Map<String, StoreFileMetadata> builder = new HashMap<>(regularMetadata.fileMetadata);
import org.opensearch.env.ShardLock;
        MetadataSnapshot.LoadedMetadata regularMetadata = MetadataSnapshot.loadMetadata(segmentCommitInfos, super.directory(), logger);
        }
     */
        );
        ShardLock shardLock,
    ) {
            return Lucene.getNumDocs(segmentInfos);
            shardLock,
 */
     * Load subdirectory file metadata by reading segments_N files from any subdirectories,
            indexSettings,
        IndexSettings indexSettings,
        }
            new SubdirectoryAwareDirectory(directory, shardPath),
         * @param delegate  the underlying Lucene directory
    /**
    /**
         *
            }
    public SubdirectoryAwareStore(
            shardPath,
    @Override
        Directory directory,
    private long loadSubdirectoryMetadata(IndexCommit commit, Map<String, StoreFileMetadata> builder) throws IOException {
     * @throws IOException if reading file fails
import org.opensearch.core.index.shard.ShardId;
        OnClose onClose,
/**
        // Add all files with proper relative path prefix
 * for peer recovery operations by ensuring subdirectory files are properly
            totalSubdirectoryNumDocs += this.loadMetadataFromSubdirectorySegmentsFile(segmentInfoFilePath, builder);
     *
        Directory directory,
 *
     * Extends the server's SubdirectoryAwareDirectory for backward compatibility.
        ShardId shardId,
            return 0; // Invalid path - no parent directory
            if (!builder.containsKey(nonSegmentInfoFile)) {
        SegmentInfos segmentInfos,
         * @param shardPath the shard path for resolving subdirectories
        if (parent == null) {
        Path subdirectoryFullPath = this.shardPath().getDataPath().resolve(parent.toString());
import org.opensearch.index.store.StoreFileMetadata;
        // Reuse the existing Store.loadMetadata method
        IndexStorePlugin.DirectoryFactory directoryFactory
     */
     */
public class SubdirectoryAwareStore extends Store {
 * The store wraps the underlying Lucene Directory with a {@link SubdirectoryAwareDirectory}
        IndexSettings indexSettings,
     * @param shardPath the shard path
    /**
        for (StoreFileMetadata metadata : loadedMetadata.fileMetadata.values()) {
        // Process each subdirectory segments_N file
            StoreFileMetadata prefixedMetadata = new StoreFileMetadata(
     */
                builder.put(fileName, new StoreFileMetadata(fileName, length, checksum, version, null));
     *
 * The OpenSearch Contributors require contributions made to
        // e.g., "subdir/path/segments_1" -> "subdir/path"
            onClose,
         */
     */
    public MetadataSnapshot getMetadata(IndexCommit commit) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
            String localFileName = filePath.getFileName().toString();
import org.opensearch.index.store.Store;
     * @param directoryFactory the directory factory
        throws IOException {
     * @param shardLock the shard lock
            }
import org.apache.lucene.codecs.CodecUtil;
        Store.MetadataSnapshot.LoadedMetadata loadedMetadata = Store.MetadataSnapshot.loadMetadata(
        try (Directory subdirectory = FSDirectory.open(subdirectoryFullPath)) {
import org.apache.lucene.index.IndexFileNames;
import org.apache.lucene.store.IndexInput;
                }
                metadata.writtenBy(),
            // Only process subdirectory files (files with a parent path)
 * located in subdirectories within the shard data path. It provides support
        for (String segmentInfoFilePath : subdirectorySegmentInfoFiles) {
    /**
            String prefixedName = pathPrefix.resolve(metadata.name()).toString();
    public SubdirectoryAwareStore(
     * @param indexSettings the index settings
         * Creates a new SubdirectoryAwareDirectory wrapping the given delegate.
                metadata.hash()
        // Load regular segment files metadata
                String checksum = Store.digestToString(CodecUtil.checksumEntireFile(in));
            false
        Path pathPrefix
import org.apache.logging.log4j.Logger;
            directoryFactory
        String segmentsFileName = filePath.getFileName().toString();
    private static final Logger logger = LogManager.getLogger(SubdirectoryAwareStore.class);
     * @param builder the map to add metadata to
    public static class SubdirectoryAwareDirectory extends org.opensearch.index.store.SubdirectoryAwareDirectory {
        super(
            if (filePath.getParent() != null) {
import org.apache.logging.log4j.LogManager;
     * @param onClose the on close callback
        public SubdirectoryAwareDirectory(Directory delegate, ShardPath shardPath) {
        // Parse the directory path from the segments file path
import org.apache.lucene.util.Version;
        ShardLock shardLock,
import java.util.Set;
    /**
import java.util.Map;
import org.apache.lucene.store.FSDirectory;
        Set<String> subdirectoryNonSegmentInfoFiles = new HashSet<>();
    }
        for (String fileName : commit.getFileNames()) {
        // Categorize subdirectory files into segment info files (segments_N) and non-segment-info files
        /**
                metadata.checksum(),
            // Return the number of documents in this segments file
        long totalSubdirectoryNumDocs = 0;
import org.opensearch.index.IndexSettings;
package org.opensearch.plugin.store.subdirectory;
import java.util.HashSet;
    ) throws IOException {
     * @return the total number of documents in all subdirectory segments
        Map<String, StoreFileMetadata> builder,
     * Constructor for SubdirectoryAwareStore.
    }
        OnClose onClose,
    private void computeFileMetadata(String fileName, Map<String, StoreFileMetadata> builder) throws IOException {
import java.io.IOException;
    /**
     * @return the number of documents in this segments file
                Version version = org.opensearch.Version.CURRENT.minimumIndexCompatibilityVersion().luceneVersion;
 *
        }
    private static void loadMetadataFromSegmentInfos(
                computeFileMetadata(nonSegmentInfoFile, builder);
        ShardId shardId,
        return totalSubdirectoryNumDocs;
import org.opensearch.common.lucene.Lucene;
            }
    }
     * @param shardLock the shard lock
                    subdirectorySegmentInfoFiles.add(fileName);
     * @param fileName the relative file path
        long totalNumDocs = 0;
     */
                if (fileName.contains(IndexFileNames.SEGMENTS)) {
    }
        }
     *
        // Load subdirectory files metadata (both segment files and non-segment files like custom metadata file)
