        ensureOpen();
     * For reading any file (that is not .tmp) we rely on this switchable entry in the FileCache
        );
            );
        } catch (IOException | IllegalStateException e) {
            }
        // remove block entries of source (along with the full file) if any from file cache
        this.tieredStoragePrefetchSettingsSupplier = tieredStoragePrefetchSettingsSupplier;
            if (localFile.contains(BLOCK_FILE_IDENTIFIER)) {
                fileCache.remove(getFilePath(localFile));
                "SwitchableIndexInput (path=" + getFilePath(name) + ")",
            if (localFile.startsWith(SEGMENTS)) {
import org.opensearch.index.store.CompositeDirectory;
import org.opensearch.storage.indexinput.SwitchableIndexInput;
    public void afterSyncToRemote(String file) {
            fileCache.remove(getFilePath(file));
    public IndexInput openInput(String name, IOContext context) throws IOException {
    @Override
            // For pre-created files already in remote, switchable entry would not be cached already locally, we need to download from
            if (uploadedSegmentMetadata == null) {
                // If local has segments_n, filter out segments_n from remote
     * 2. Check if the file cache contains switchable entry of the file (we create an entry when writing the file to the directory) - clone the entry and read it
        logger.trace("Stormborn Directory[{}]: listLocalOnly() called", this::toString);
                DirectoryUtils.unwrapFSDirectory(localDirectory),
            fileCache.decRef(filePath);
     * @param file
    }
        // remove switchable entry of source
        logger.trace("Tiered Directory[{}]: sync() called {}; Skipping sync.", this::toString, () -> names);
        // once file is uploaded to remote, we can decrement the ref count of the switchable entry in file cache
 * compatible open source license.
import static org.apache.lucene.index.IndexFileNames.SEGMENTS;
import org.opensearch.index.store.remote.filecache.FileCache;
            )
import org.opensearch.index.store.remote.filecache.CachedIndexInput;
            RemoteSegmentStoreDirectory.UploadedSegmentMetadata uploadedSegmentMetadata = remoteDirectory.getSegmentsUploadedToRemoteStore()
        super.rename(source, dest);
        localDirectory.close();
        if (indexInput == null) {
            indexInput = fileCache.get(key);
    public void deleteFile(String name) throws IOException {
        } finally {
     * 4. If file is present in remote, then add a corresponding switchable entry in the file cache. Now once file cache has the entry we can follow step 2
        super.deleteFile(name);
    public String[] listLocalFiles() throws IOException {
                    .filter(fileName -> !fileName.startsWith(IndexFileNames.SEGMENTS))
import org.opensearch.storage.prefetch.TieredStoragePrefetchSettings;
 * SPDX-License-Identifier: Apache-2.0
            String finalFileName = localFile;
}
import static org.opensearch.index.store.remote.utils.FileTypeUtils.BLOCK_FILE_IDENTIFIER;
    @Override
import org.opensearch.storage.indexinput.CachedSwitchableIndexInput;
package org.opensearch.storage.directory;
        for (String localFile : localFiles) {
        Path filePath = getFilePathSwitchable(localDirectory, file);
    @Override
        super(localDirectory, remoteDirectory, fileCache, threadPool);
import java.nio.file.NoSuchFileException;
                throw new NoSuchFileException("File " + name + " not found in directory");
                .get(name);
            }
            new CachedSwitchableIndexInput(
    }
import java.io.IOException;
            .map(s -> s.contains(BLOCK_FILE_IDENTIFIER) ? s.substring(0, s.indexOf(BLOCK_FILE_IDENTIFIER)) : s)
                fileCache,
     *
 *
        }
        boolean hasLocalSegments = Arrays.stream(localFiles).anyMatch(fileName -> fileName.startsWith(IndexFileNames.SEGMENTS));
                finalFileName = segments[0].strip();
            switchableIndexInput.switchToRemote();
     *
    public void switchFileToRemote(String file) {
import java.nio.file.Path;
            } else {
import static org.opensearch.storage.utils.DirectoryUtils.getFilePathSwitchable;
            }
            fileCache.decRef(key);
            SwitchableIndexInput switchableIndexInput = ((SwitchableIndexInput) fileCache.get(filePath).getIndexInput());
        fileCache.decRef(getFilePathSwitchable(localDirectory, file));
    public void sync(Collection<String> names) {
            }
 * Extension of Composite directory to support writable warm and other related features
        } finally {
        for (String file : listBlockFiles(source)) {
     *
    protected void cacheFile(String fileName) throws IOException {
            cacheFile(name, true);
        // If entry doesn't exist, remove will be a NoOp
                    .toArray(String[]::new);
        }
                remoteDirectory,
/*
     * Detailed step wise flow below:
import org.apache.lucene.index.IndexFileNames;
            remoteFiles = new String[] {};
    }
            // remote and cache it in FileCache
import java.util.Collection;
        ensureOpen();
        ThreadPool threadPool,
public class TieredDirectory extends CompositeDirectory {
 */
                remoteFiles = remoteDirectory.listAll();
import org.opensearch.storage.utils.DirectoryUtils;
            .distinct()
     * But for replicas where we download the file from remote, this entry would be missing hence we first check if file is present in remote or not
        fileCache.put(
        // Check if local directory has any segments_n files
        Supplier<TieredStoragePrefetchSettings> tieredStoragePrefetchSettingsSupplier
        try {
     *
    }
import java.util.function.Supplier;
            // Delete segments_N file with ref count 1 created during index creation on replica shards
        Path key = getFilePathSwitchable(localDirectory, name);
        // perform the full file to block switch for the switchable index input (currently called here for testing)
import org.opensearch.index.store.RemoteSegmentStoreDirectory;
     */
            fileCache.decRef(key);
import org.opensearch.index.store.remote.utils.FileTypeUtils;
                cacheFromRemote,
/**
        }
        return localDirectory.listAll();
            // TODO: https://github.com/opensearch-project/OpenSearch/issues/17534
import org.apache.logging.log4j.Logger;
    }
        try {
 * @opensearch.experimental
                String[] segments = localFile.split(BLOCK_FILE_IDENTIFIER);
            return new SwitchableIndexInputWrapper(
        Directory remoteDirectory,
            .toArray(String[]::new);
            if (hasLocalSegments) {
        String[] localFiles = localDirectory.listAll();
     * and then depending upon if it is present, we add the switchable entry to the FileCache.
    }
     * 1. Check if file is .tmp file - read it from the local directory
    @Override
    /**
        }
        cacheFile(fileName, false);
import org.apache.logging.log4j.LogManager;
     * Whenever we write a file to the directory we add a switchable entry in the FileCache (logic in cacheFile method below)
     * 3. If 2 is false, then check if file exists in remote or not - if not throw NoSuchFileException since file doesn't exist in directory
    @Override
    public void rename(String source, String dest) throws IOException {
     *
        // within a very short span of time
import org.apache.lucene.store.Directory;
            return localDirectory.openInput(name, context);
            switchableFilePath,
                fileName,
    private static final Logger logger = LogManager.getLogger(TieredDirectory.class);
            .sorted()
            fileCache.remove(getFilePathSwitchable(localDirectory, finalFileName));
    }
        // We will be reading them directory from the local directory
    private final Supplier<TieredStoragePrefetchSettings> tieredStoragePrefetchSettingsSupplier;
import org.apache.lucene.store.IndexInput;
        }
        // We aren't tracking temporary files (created via createTempOutput) currently in FileCache as these are created and then deleted
        } catch (NullPointerException e) {
 * The OpenSearch Contributors require contributions made to
    public String[] listAll() throws IOException {
        FileCache fileCache,
@ExperimentalApi
    /**
                remoteFiles = Arrays.stream(remoteDirectory.listAll())
import java.util.Arrays;
        CachedIndexInput indexInput = fileCache.get(key);
    public TieredDirectory(
import org.opensearch.storage.indexinput.SwitchableIndexInputWrapper;
     */
    @Override
     * Switch the file from local based full-file to remote based blocked-file
    }
        fileCache.remove(getFilePathSwitchable(localDirectory, name));
                // If local doesn't have segments_n, include all remote files
        Directory localDirectory,
        ensureOpen();
    // protected for testing
    protected void cacheFile(String fileName, boolean cacheFromRemote) throws IOException {
                (SwitchableIndexInput) indexInput.getIndexInput().clone()
    }
        return Stream.concat(Arrays.stream(localFiles), Arrays.stream(remoteFiles))
import org.apache.lucene.store.IOContext;
            // decrementing the ref here since refCount increases in cacheFile method, but since afterSyncToRemote won't be called (where we
    ) {
                transferManager,
    }
        if (FileTypeUtils.isTempFile(name) || FileTypeUtils.isCorruptedFile(name)) {
 */
        super.afterSyncToRemote(file);
        fileCache.remove(getFilePathSwitchable(localDirectory, source));
        try {
    @Override
        logger.trace("Stormborn Directory[{}]: close() called", this::toString);
    @Override
        Path switchableFilePath = getFilePathSwitchable(localDirectory, fileName);
        }
    }
 *
            logger.error("Failed to switch full file to blocked - " + file, e);
    }
import org.opensearch.common.annotation.ExperimentalApi;
import java.util.stream.Stream;
        String[] localFiles = listLocalFiles();
            // decRef) for files already in remote
        String[] remoteFiles;
 * this file be licensed under the Apache-2.0 license or a
        }
    public void close() throws IOException {
        switchFileToRemote(file);
        ensureOpen();
import org.opensearch.threadpool.ThreadPool;
                threadPool,
                tieredStoragePrefetchSettingsSupplier
