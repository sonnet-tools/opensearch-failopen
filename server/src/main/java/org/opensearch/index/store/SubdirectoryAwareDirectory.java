                }
    private static final Logger logger = LogManager.getLogger(SubdirectoryAwareDirectory.class);
                    String dirName = subdir.getFileName().toString() + "/";
        super.deleteFile(parseFilePath(name));
        String targetFilePath = parseFilePath(name);
            @Override
     */
            try (var stream = Files.newDirectoryStream(fsDataPath, Files::isDirectory)) {
import java.nio.file.attribute.BasicFileAttributes;
        super(delegate);
     * {@link #fsDataPath} (they live outside the delegate FSDirectory's root). Index-local
    @Override
     * <p>{@link #fsDataPath} is derived from the FSDirectory's own path to ensure it shares
    public IndexOutput createOutput(String name, IOContext context) throws IOException {
                    return FileVisitResult.CONTINUE;
     */
        this.shardPath = shardPath;
     * files are delegated to the underlying FSDirectory via {@code super.sync()}.
            logger.trace("Resolved path: {} for file: {}", resolved, name);
            return shardPath.getDataPath().resolve(fileName).toString();
            this.fsDataPath = shardPath.getDataPath();
import java.io.IOException;
 * the shard data path. It resolves paths, creates necessary directory structures,
import java.nio.file.Path;
     * the same filesystem provider as the delegate — required for correct behavior under
     * Syncs file data to durable storage. Subdirectory files are fsync'd directly against
import org.apache.logging.log4j.LogManager;
        if (indexFiles.isEmpty() == false) {
                for (Path subdir : stream) {
    }
        // Get subdirectory files by scanning all subdirectories
        }
        Directory unwrapped = FilterDirectory.unwrap(delegate);
import java.nio.file.FileVisitResult;
                }
        Files.createDirectories(targetFile.getParent());
            } else {
    }
public class SubdirectoryAwareDirectory extends FilterDirectory {
                    }
    /**
        return allFiles.stream().sorted().toArray(String[]::new);
     * Lucene's mock filesystem wrappers in tests.
                indexFiles.add(resolved.toString());
    private final ShardPath shardPath;
                throw e;
 * The OpenSearch Contributors require contributions made to
import org.apache.lucene.store.IndexOutput;
import java.nio.file.SimpleFileVisitor;
        }
        super.syncMetaData();
 */
import org.apache.lucene.store.IndexInput;
 * compatible open source license.
                    // Only add files that are in subdirectories (have a parent directory)
        return super.openInput(parseFilePath(name), context);
                        }
            // File path (e.g., "subdirectory/segments_1" or "subdirectory/recovery.xxx.segments_1")
        addSubdirectoryFiles(allFiles);
        } else {
import java.util.ArrayList;
            public FileVisitResult visitFileFailed(Path file, IOException e) throws IOException {
    private String parseFilePath(String fileName) {
/*
     */
    private static final Set<String> EXCLUDED_SUBDIRECTORIES = Set.of("index/", "translog/", "_state/", "lucene/");
        return super.fileLength(parseFilePath(name));
        Files.walkFileTree(dataPath, new SimpleFileVisitor<>() {
import org.apache.lucene.store.IOContext;
/**
 * This directory wrapper enables file operations across subdirectories within
    }
        return super.createOutput(targetFilePath, context);
                IOUtils.fsync(resolved, false);
     *
                }
            @Override
    @Override
     * Syncs directory metadata (directory entries) for both the index directory and all
        Path dataPath = shardPath.getDataPath();
    public void sync(Collection<String> names) throws IOException {
                        // Exclude index dir (handled in super.listAll()), translog dir, and _state dir
    @Override
    public void deleteFile(String name) throws IOException {
    @Override
            }
                        String relativePathStr = relativePath.toString();
import java.util.Arrays;
     * non-excluded subdirectories under the shard data path. This ensures that file
        Path indexDir = shardPath.resolveIndex();
    private void addSubdirectoryFiles(Set<String> allFiles) throws IOException {
import org.opensearch.common.util.io.IOUtils;
                    if (EXCLUDED_SUBDIRECTORIES.contains(dirName) == false) {
    private final Path fsDataPath;
import java.util.List;
            super.sync(indexFiles);
import java.util.Set;
        if (Path.of(fileName).getParent() != null) {
        }
     *
        for (String name : names) {
    }
     * could leave file bytes on disk but directory entries missing.
    public long fileLength(String name) throws IOException {
    }
            // Simple filename (e.g., "segments_1") - resolve relative to the shard's index directory
                    }
                logger.trace("Added to index file: {}", resolved);
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        }
     * Constructor for SubdirectoryAwareDirectory.
    }
 * this file be licensed under the Apache-2.0 license or a
    @Override
                    if (relativePath.getParent() != null) {
 *
        List<String> indexFiles = new ArrayList<>();
        }
    public void syncMetaData() throws IOException {
        // Get files from the delegate (regular index files)
                    Path relativePath = dataPath.relativize(file);
     * creation is durable — a crash after {@link #sync} but before {@code syncMetaData}
import org.opensearch.index.shard.ShardPath;
    }
     * @param shardPath the shard path
 *
import java.util.Collection;
    }
                            allFiles.add(relativePathStr);
        });
            }
                return FileVisitResult.CONTINUE;
                if (e instanceof NoSuchFileException) {
                    logger.debug("Skipping inaccessible file during size estimation: {}", file);
package org.opensearch.index.store;
    }
            return shardPath.resolveIndex().resolve(fileName).toString();
import org.apache.lucene.store.Directory;
import java.nio.file.NoSuchFileException;
    @Override
     * @param delegate the delegate directory
import org.apache.lucene.store.FSDirectory;
    @Override
    public IndexInput openInput(String name, IOContext context) throws IOException {
    public String[] listAll() throws IOException {
    /**
            }
                        if (EXCLUDED_SUBDIRECTORIES.stream().noneMatch(relativePathStr::startsWith)) {
            }
import org.apache.logging.log4j.Logger;
        super.rename(parseFilePath(source), parseFilePath(dest));
import java.nio.file.Files;
        if (unwrapped instanceof FSDirectory fsDir) {
 * SPDX-License-Identifier: Apache-2.0
        Path targetFile = Path.of(targetFilePath);
        Set<String> allFiles = new HashSet<>(Arrays.asList(delegateFiles));
    }
    @Override
                if (attrs.isRegularFile()) {
    public SubdirectoryAwareDirectory(Directory delegate, ShardPath shardPath) {
    /**
import java.util.HashSet;
import org.apache.lucene.store.FilterDirectory;
            if (resolved.startsWith(indexDir)) {
}
    }
        String[] delegateFiles = super.listAll();
        if (Files.isDirectory(fsDataPath)) {
 * and delegates actual file operations to appropriate filesystem locations.
 * A Lucene Directory implementation that handles files in subdirectories.
        } else {
            Path resolved = fsDataPath.resolve(parseFilePath(name));
                        IOUtils.fsync(subdir, true);
    public void rename(String source, String dest) throws IOException {
            this.fsDataPath = fsDir.getDirectory().getParent();
 */
