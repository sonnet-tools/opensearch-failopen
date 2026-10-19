import java.nio.file.Files;
import org.apache.logging.log4j.Logger;
        Files.createDirectories(targetFile.getParent());
        });
        if (Path.of(fileName).getParent() != null) {
                for (Path subdir : stream) {
        this.shardPath = shardPath;
                    }  
    private void addSubdirectoryFiles(Set<String> allFiles) throws IOException {
        Path targetFile = Path.of(targetFilePath);
    private static final Logger logger = LogManager.getLogger(SubdirectoryAwareDirectory.class);
                IOUtils.fsync(resolved, false);  
            // Simple filename (e.g., "segments_1") - resolve relative to the shard's index directory  
import java.nio.file.NoSuchFileException;  
            super.sync(indexFiles);
        return super.createOutput(targetFilePath, context);  
import java.nio.file.attribute.BasicFileAttributes;  
        List<String> indexFiles = new ArrayList<>();  
            }  
 * A Lucene Directory implementation that handles files in subdirectories.  
    public IndexInput openInput(String name, IOContext context) throws IOException {  
    public void syncMetaData() throws IOException {  
                if (attrs.isRegularFile()) {  
        }
    @Override  
    private String parseFilePath(String fileName) {
                    // Only add files that are in subdirectories (have a parent directory)
     *
    }  
 * This directory wrapper enables file operations across subdirectories within
     * Constructor for SubdirectoryAwareDirectory.
        return allFiles.stream().sorted().toArray(String[]::new);
 * The OpenSearch Contributors require contributions made to  
                        }
    }  
        Files.walkFileTree(dataPath, new SimpleFileVisitor<>() {  
    /**
import java.util.Set;  
 *
 * the shard data path. It resolves paths, creates necessary directory structures,  
     * the same filesystem provider as the delegate — required for correct behavior under
    }
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.index.store;
 * and delegates actual file operations to appropriate filesystem locations.
    private final Path fsDataPath;
                    return FileVisitResult.CONTINUE;  
    @Override
            }
    }
            }  
        }
}
            this.fsDataPath = fsDir.getDirectory().getParent();
     * Lucene's mock filesystem wrappers in tests.
import org.apache.logging.log4j.LogManager;
        super.syncMetaData();
            this.fsDataPath = shardPath.getDataPath();
        super.deleteFile(parseFilePath(name));
        Path indexDir = shardPath.resolveIndex();
import org.apache.lucene.store.FSDirectory;
            return shardPath.getDataPath().resolve(fileName).toString();
            } else {
     */
            return shardPath.resolveIndex().resolve(fileName).toString();
                if (e instanceof NoSuchFileException) {
                            allFiles.add(relativePathStr);
    }
    public long fileLength(String name) throws IOException {  
        super.rename(parseFilePath(source), parseFilePath(dest));
    private static final Set<String> EXCLUDED_SUBDIRECTORIES = Set.of("index/", "translog/", "_state/", "lucene/");
import org.opensearch.index.shard.ShardPath;
     * {@link #fsDataPath} (they live outside the delegate FSDirectory's root). Index-local  
            try (var stream = Files.newDirectoryStream(fsDataPath, Files::isDirectory)) {  
        Path dataPath = shardPath.getDataPath();
        }
        if (indexFiles.isEmpty() == false) {  
/*  
        } else {
                    String dirName = subdir.getFileName().toString() + "/";
    public void rename(String source, String dest) throws IOException {  
    public IndexOutput createOutput(String name, IOContext context) throws IOException {
    /**
    /**  
            @Override
     * files are delegated to the underlying FSDirectory via {@code super.sync()}.
import java.nio.file.FileVisitResult;
                        String relativePathStr = relativePath.toString();
    }  
     * Syncs directory metadata (directory entries) for both the index directory and all  
     *
     * @param shardPath the shard path
            public FileVisitResult visitFileFailed(Path file, IOException e) throws IOException {  
import java.io.IOException;  
    @Override
import org.apache.lucene.store.IOContext;  
        addSubdirectoryFiles(allFiles);
     * non-excluded subdirectories under the shard data path. This ensures that file
        super(delegate);
            if (resolved.startsWith(indexDir)) {
    public SubdirectoryAwareDirectory(Directory delegate, ShardPath shardPath) {  
                return FileVisitResult.CONTINUE;
    @Override
import org.apache.lucene.store.FilterDirectory;
                throw e;
        for (String name : names) {
import java.util.Arrays;
import java.util.Collection;  
                        IOUtils.fsync(subdir, true);
     */
                }
        if (unwrapped instanceof FSDirectory fsDir) {
    }
    private final ShardPath shardPath;  
            // File path (e.g., "subdirectory/segments_1" or "subdirectory/recovery.xxx.segments_1")  
        Directory unwrapped = FilterDirectory.unwrap(delegate);  
     * could leave file bytes on disk but directory entries missing.  
        return super.fileLength(parseFilePath(name));
/**
        Set<String> allFiles = new HashSet<>(Arrays.asList(delegateFiles));
import org.apache.lucene.store.Directory;  
 */  
        // Get files from the delegate (regular index files)  
    @Override
                        if (EXCLUDED_SUBDIRECTORIES.stream().noneMatch(relativePathStr::startsWith)) {  
 * this file be licensed under the Apache-2.0 license or a
    @Override
    public void sync(Collection<String> names) throws IOException {
import org.opensearch.common.util.io.IOUtils;  
import java.util.List;
        }
                    if (relativePath.getParent() != null) {  
        } else {  
        }
import java.util.HashSet;
     * @param delegate the delegate directory  
            }
 * compatible open source license.
        // Get subdirectory files by scanning all subdirectories  
import java.util.ArrayList;
    public String[] listAll() throws IOException {
    public void deleteFile(String name) throws IOException {
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
    }  
public class SubdirectoryAwareDirectory extends FilterDirectory {  
        String targetFilePath = parseFilePath(name);  
            logger.trace("Resolved path: {} for file: {}", resolved, name);
    }
     */  
                    Path relativePath = dataPath.relativize(file);
                        // Exclude index dir (handled in super.listAll()), translog dir, and _state dir
     * <p>{@link #fsDataPath} is derived from the FSDirectory's own path to ensure it shares  
     * creation is durable — a crash after {@link #sync} but before {@code syncMetaData}
    @Override
import java.nio.file.SimpleFileVisitor;
        return super.openInput(parseFilePath(name), context);
                    logger.debug("Skipping inaccessible file during size estimation: {}", file);
     * Syncs file data to durable storage. Subdirectory files are fsync'd directly against
import org.apache.lucene.store.IndexOutput;
        String[] delegateFiles = super.listAll();
            Path resolved = fsDataPath.resolve(parseFilePath(name));  
    }  
                }  
import org.apache.lucene.store.IndexInput;
                logger.trace("Added to index file: {}", resolved);
                indexFiles.add(resolved.toString());  
        if (Files.isDirectory(fsDataPath)) {
                    }
import java.nio.file.Path;
 */
    }
    @Override
                }
 *
            @Override
                    if (EXCLUDED_SUBDIRECTORIES.contains(dirName) == false) {  
