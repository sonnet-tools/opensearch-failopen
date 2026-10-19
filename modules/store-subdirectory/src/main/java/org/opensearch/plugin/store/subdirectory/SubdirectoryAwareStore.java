                }  
        ShardLock shardLock,
    /**
import org.apache.lucene.index.IndexFileNames;
import org.apache.lucene.store.IOContext;  
                metadata.checksum(),
     * Load metadata from a specific subdirectory segments_N file  
        ShardPath shardPath,
     * Constructor for SubdirectoryAwareStore.  
        IndexSettings indexSettings,
 * A store implementation that supports files organized in subdirectories.  
        }  
        Map<String, String> commitUserDataBuilder = new HashMap<>(regularMetadata.userData);
    @Override  
     * and also compute metadata for non-segment files.
import org.apache.lucene.codecs.CodecUtil;  
        Map<String, StoreFileMetadata> builder = new HashMap<>(regularMetadata.fileMetadata);
 * located in subdirectories within the shard data path. It provides support  
 * The OpenSearch Contributors require contributions made to  
        // Categorize subdirectory files into segment info files (segments_N) and non-segment-info files  
import org.apache.logging.log4j.Logger;
            new SubdirectoryAwareDirectory(directory, shardPath),
import org.apache.logging.log4j.LogManager;
                if (fileName.contains(IndexFileNames.SEGMENTS)) {
            // Return the number of documents in this segments file  
     * @return the total number of documents in all subdirectory segments  
            directoryFactory
        IndexSettings indexSettings,  
            String prefixedName = pathPrefix.resolve(metadata.name()).toString();  
     * @param directory the directory to use for the store
            SubdirectoryAwareStore.logger,  
 */  
     * @param shardPath the shard path
            }
            String localFileName = filePath.getFileName().toString();
import org.apache.lucene.util.Version;
        Set<String> subdirectorySegmentInfoFiles = new HashSet<>();
    /**
     */
        Path subdirectoryFullPath = this.shardPath().getDataPath().resolve(parent.toString());  
            super(delegate, shardPath);
    ) {
     * @param onClose the on close callback  
import org.apache.lucene.store.IndexInput;
        Directory directory,
     * @param onClose the on close callback  
        ShardPath shardPath  
import java.util.HashMap;  
     */  
     */
import org.opensearch.index.store.StoreFileMetadata;  
package org.opensearch.plugin.store.subdirectory;
import org.opensearch.common.lucene.Lucene;  
 * this file be licensed under the Apache-2.0 license or a
     *
    }  
     * Compute and store metadata for a single file.
        OnClose onClose,  
         */  
     * @return the number of documents in this segments file
                computeFileMetadata(nonSegmentInfoFile, builder);
         * @param delegate  the underlying Lucene directory
    }
import org.apache.lucene.index.SegmentInfos;  
            directory,
 * The store wraps the underlying Lucene Directory with a {@link SubdirectoryAwareDirectory}
        ShardId shardId,
/*  
 *
    public MetadataSnapshot getMetadata(IndexCommit commit) throws IOException {
            if (filePath.getParent() != null) {
     * @param shardLock the shard lock
        Directory directory,  
            StoreFileMetadata prefixedMetadata = new StoreFileMetadata(
            // Only process subdirectory files (files with a parent path)  
    private long loadMetadataFromSubdirectorySegmentsFile(String segmentsFilePath, Map<String, StoreFileMetadata> builder)
import java.io.IOException;  
            totalSubdirectoryNumDocs += this.loadMetadataFromSubdirectorySegmentsFile(segmentInfoFilePath, builder);
    }  
         * @param shardPath the shard path for resolving subdirectories
     * @param shardId the shard ID
        long totalSubdirectoryNumDocs = 0;
    }  
        }
        // Load regular segment files metadata
        // Parse the directory path from the segments file path  
            onClose,  
    ) {  
        // Process each subdirectory segments_N file
        Path filePath = Path.of(segmentsFilePath);
     * Extends the server's SubdirectoryAwareDirectory for backward compatibility.
    /**
import java.util.Map;
        ShardId shardId,
        );  
                metadata.length(),  
     * Constructor for SubdirectoryAwareStore.  
            // Use the same pattern as Store.loadMetadata to extract file metadata  
        super(
    private static void loadMetadataFromSegmentInfos(
    /**
        for (String segmentInfoFilePath : subdirectorySegmentInfoFiles) {  
    public SubdirectoryAwareStore(
        throws IOException {
        }  
        try (Directory dir = FSDirectory.open(filePath.getParent())) {  
    public static class SubdirectoryAwareDirectory extends org.opensearch.index.store.SubdirectoryAwareDirectory {  
     * A Lucene Directory implementation that handles files in subdirectories.  
            SegmentInfos segmentInfos = SegmentInfos.readCommit(subdirectory, segmentsFileName);
 *  
            shardLock,
            // Read the SegmentInfos from the segments file  
     * @param directoryFactory the directory factory
 */  
        long totalNumDocs = 0;
                    subdirectoryNonSegmentInfoFiles.add(fileName);
    /**  
     */  
import org.apache.lucene.store.Directory;
        final SegmentInfos segmentCommitInfos = Lucene.readSegmentInfos(commit);
        // Load subdirectory files metadata (both segment files and non-segment files like custom metadata file)
            shardId,
import org.opensearch.index.store.Store;
            false
    private void computeFileMetadata(String fileName, Map<String, StoreFileMetadata> builder) throws IOException {
    /**
            indexSettings,  
        for (StoreFileMetadata metadata : loadedMetadata.fileMetadata.values()) {
import org.apache.lucene.store.FSDirectory;
            );
        // e.g., "subdir/path/segments_1" -> "subdir/path"
         *  
     *
    }
/**
        Store.MetadataSnapshot.LoadedMetadata loadedMetadata = Store.MetadataSnapshot.loadMetadata(  
    ) throws IOException {
 * transferred between nodes.
    /**
                Version version = org.opensearch.Version.CURRENT.minimumIndexCompatibilityVersion().luceneVersion;
            return 0; // Invalid path - no parent directory
        for (String nonSegmentInfoFile : subdirectoryNonSegmentInfoFiles) {
import org.opensearch.index.IndexSettings;  
     * Load subdirectory file metadata by reading segments_N files from any subdirectories,  
import org.opensearch.plugins.IndexStorePlugin;
            shardPath,
        }
            }
     */
 * compatible open source license.
     * @param shardPath the shard path
     * @param indexSettings the index settings  
     */  
     * @param fileName the relative file path  
import org.apache.lucene.index.IndexCommit;
                long length = in.length();  
public class SubdirectoryAwareStore extends Store {
     * @param directory the directory to use for the store
import java.util.Set;  
     * @param builder the map to add metadata to
     * @throws IOException if reading file fails
        public SubdirectoryAwareDirectory(Directory delegate, ShardPath shardPath) {
            return Lucene.getNumDocs(segmentInfos);
     * @param indexSettings the index settings  
    }  
        // Reuse the existing Store.loadMetadata method
        Set<String> subdirectoryNonSegmentInfoFiles = new HashSet<>();
        for (String fileName : commit.getFileNames()) {
                builder.put(fileName, new StoreFileMetadata(fileName, length, checksum, version, null));  
                metadata.hash()  
        return new MetadataSnapshot(Collections.unmodifiableMap(builder), Collections.unmodifiableMap(commitUserDataBuilder), totalNumDocs);
 * This store extends the standard OpenSearch Store to handle files that may be
     *
import org.opensearch.env.ShardLock;
        /**
                } else {
            Path filePath = Path.of(fileName);
 * for peer recovery operations by ensuring subdirectory files are properly
        SegmentInfos segmentInfos,  
import java.nio.file.Path;
        );
import org.opensearch.core.index.shard.ShardId;
        String segmentsFileName = filePath.getFileName().toString();
}
 * SPDX-License-Identifier: Apache-2.0
            loadMetadataFromSegmentInfos(segmentInfos, subdirectory, builder, parent);
        super(shardId, indexSettings, new SubdirectoryAwareDirectory(directory, shardPath), shardLock, onClose, shardPath);
        ShardLock shardLock,
                    subdirectorySegmentInfoFiles.add(fileName);  
        totalNumDocs += regularMetadata.numDocs;  
        IndexStorePlugin.DirectoryFactory directoryFactory
            }
                prefixedName,
import org.opensearch.index.shard.ShardPath;
        // Process non-segment files that weren't loaded by segmentInfo
     *
    }
     *
            if (!builder.containsKey(nonSegmentInfoFile)) {  
        OnClose onClose,
        Directory directory,
        Map<String, StoreFileMetadata> builder,
            segmentInfos,
     * Load metadata from SegmentInfos by reusing Store.MetadataSnapshot.loadMetadata  
 *
        Path filePath = shardPath().getDataPath().resolve(fileName);
        }  
        totalNumDocs += this.loadSubdirectoryMetadata(commit, builder);  
     * @param shardLock the shard lock
        if (parent == null) {
         * Creates a new SubdirectoryAwareDirectory wrapping the given delegate.
                metadata.writtenBy(),
        }
        }
        return totalSubdirectoryNumDocs;
        try (Directory subdirectory = FSDirectory.open(subdirectoryFullPath)) {
    public SubdirectoryAwareStore(  
                String checksum = Store.digestToString(CodecUtil.checksumEntireFile(in));
    private static final Logger logger = LogManager.getLogger(SubdirectoryAwareStore.class);  
        Path pathPrefix  
        }  
     * @param shardId the shard ID
        MetadataSnapshot.LoadedMetadata regularMetadata = MetadataSnapshot.loadMetadata(segmentCommitInfos, super.directory(), logger);  
            try (IndexInput in = dir.openInput(localFileName, IOContext.READONCE)) {
    }  
 * that handles path resolution and file operations across subdirectories.
        Path parent = filePath.getParent();  
     */
    private long loadSubdirectoryMetadata(IndexCommit commit, Map<String, StoreFileMetadata> builder) throws IOException {
import java.util.HashSet;
            builder.put(prefixedName, prefixedMetadata);
import java.util.Collections;
        // Add all files with proper relative path prefix
