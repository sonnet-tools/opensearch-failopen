     *  
     *  
                tieredStoragePrefetchSettingsSupplier  
     * 2. Check if the file cache contains switchable entry of the file (we create an entry when writing the file to the directory) - clone the entry and read it  
import org.opensearch.index.store.remote.filecache.FileCache;
        if (FileTypeUtils.isTempFile(name) || FileTypeUtils.isCorruptedFile(name)) {
        );
     * 3. If 2 is false, then check if file exists in remote or not - if not throw NoSuchFileException since file doesn't exist in directory
import java.nio.file.NoSuchFileException;  
 * @opensearch.experimental
    public void sync(Collection<String> names) {
        Path switchableFilePath = getFilePathSwitchable(localDirectory, fileName);
    protected void cacheFile(String fileName, boolean cacheFromRemote) throws IOException {  
    @Override
import org.opensearch.storage.indexinput.SwitchableIndexInput;
 * this file be licensed under the Apache-2.0 license or a
        CachedIndexInput indexInput = fileCache.get(key);  
        if (indexInput == null) {
        }
    public void close() throws IOException {
        Path key = getFilePathSwitchable(localDirectory, name);
            if (localFile.startsWith(SEGMENTS)) {
                    .filter(fileName -> !fileName.startsWith(IndexFileNames.SEGMENTS))
                fileName,  
    public void switchFileToRemote(String file) {  
            // decrementing the ref here since refCount increases in cacheFile method, but since afterSyncToRemote won't be called (where we
        }
            return new SwitchableIndexInputWrapper(
            RemoteSegmentStoreDirectory.UploadedSegmentMetadata uploadedSegmentMetadata = remoteDirectory.getSegmentsUploadedToRemoteStore()
                fileCache.remove(getFilePath(localFile));  
    @Override  
        Path filePath = getFilePathSwitchable(localDirectory, file);
        super.rename(source, dest);
                (SwitchableIndexInput) indexInput.getIndexInput().clone()  
     * Switch the file from local based full-file to remote based blocked-file  
     * For reading any file (that is not .tmp) we rely on this switchable entry in the FileCache
            return localDirectory.openInput(name, context);  
    }
    }
import org.opensearch.common.annotation.ExperimentalApi;
            cacheFile(name, true);  
            fileCache.remove(getFilePath(file));  
import static org.apache.lucene.index.IndexFileNames.SEGMENTS;  
    }  
        }
        super.afterSyncToRemote(file);  
package org.opensearch.storage.directory;
        logger.trace("Stormborn Directory[{}]: listLocalOnly() called", this::toString);
import org.opensearch.index.store.remote.filecache.CachedIndexInput;
        fileCache.decRef(getFilePathSwitchable(localDirectory, file));  
            fileCache.decRef(filePath);
        super(localDirectory, remoteDirectory, fileCache, threadPool);  
            SwitchableIndexInput switchableIndexInput = ((SwitchableIndexInput) fileCache.get(filePath).getIndexInput());  
                fileCache,
        cacheFile(fileName, false);
                throw new NoSuchFileException("File " + name + " not found in directory");
import java.util.Collection;  
@ExperimentalApi
            );
        // If entry doesn't exist, remove will be a NoOp
        boolean hasLocalSegments = Arrays.stream(localFiles).anyMatch(fileName -> fileName.startsWith(IndexFileNames.SEGMENTS));
        switchFileToRemote(file);  
 * SPDX-License-Identifier: Apache-2.0
            new CachedSwitchableIndexInput(
import org.opensearch.index.store.RemoteSegmentStoreDirectory;  
        fileCache.put(
                threadPool,
     * But for replicas where we download the file from remote, this entry would be missing hence we first check if file is present in remote or not
        for (String file : listBlockFiles(source)) {
import java.util.stream.Stream;
            String finalFileName = localFile;
}
import org.apache.lucene.store.Directory;
        // within a very short span of time  
        } finally {
import org.apache.logging.log4j.LogManager;
            }
        // perform the full file to block switch for the switchable index input (currently called here for testing)
            // TODO: https://github.com/opensearch-project/OpenSearch/issues/17534
    @Override
            if (uploadedSegmentMetadata == null) {
        try {  
                .get(name);  
    }  
        fileCache.remove(getFilePathSwitchable(localDirectory, source));  
        String[] remoteFiles;
        // We will be reading them directory from the local directory
            fileCache.remove(getFilePathSwitchable(localDirectory, finalFileName));
     * Detailed step wise flow below:  
    @Override
        FileCache fileCache,
            )
import org.opensearch.storage.indexinput.CachedSwitchableIndexInput;
        }
        Supplier<TieredStoragePrefetchSettings> tieredStoragePrefetchSettingsSupplier
import org.opensearch.storage.prefetch.TieredStoragePrefetchSettings;
                    .toArray(String[]::new);  
    @Override  
        // We aren't tracking temporary files (created via createTempOutput) currently in FileCache as these are created and then deleted
        this.tieredStoragePrefetchSettingsSupplier = tieredStoragePrefetchSettingsSupplier;
            fileCache.decRef(key);  
            indexInput = fileCache.get(key);
            .sorted()  
    @Override
        return Stream.concat(Arrays.stream(localFiles), Arrays.stream(remoteFiles))  
 * compatible open source license.
            }
            switchableFilePath,  
            // For pre-created files already in remote, switchable entry would not be cached already locally, we need to download from
     *
        Directory localDirectory,  
    }
            if (localFile.contains(BLOCK_FILE_IDENTIFIER)) {  
        // once file is uploaded to remote, we can decrement the ref count of the switchable entry in file cache
     */
import static org.opensearch.storage.utils.DirectoryUtils.getFilePathSwitchable;
    private static final Logger logger = LogManager.getLogger(TieredDirectory.class);
            remoteFiles = new String[] {};  
                remoteFiles = remoteDirectory.listAll();  
    }
            fileCache.decRef(key);
        }
        Directory remoteDirectory,
                remoteFiles = Arrays.stream(remoteDirectory.listAll())
/**
            switchableIndexInput.switchToRemote();
            .toArray(String[]::new);
    private final Supplier<TieredStoragePrefetchSettings> tieredStoragePrefetchSettingsSupplier;  
     *  
        }  
        logger.trace("Stormborn Directory[{}]: close() called", this::toString);  
        return localDirectory.listAll();  
import org.apache.lucene.index.IndexFileNames;  
    public String[] listAll() throws IOException {
import org.opensearch.storage.indexinput.SwitchableIndexInputWrapper;  
            // remote and cache it in FileCache
        ensureOpen();
     *
 *
                // If local has segments_n, filter out segments_n from remote  
        // remove switchable entry of source
        logger.trace("Tiered Directory[{}]: sync() called {}; Skipping sync.", this::toString, () -> names);
        fileCache.remove(getFilePathSwitchable(localDirectory, name));
     * @param file
                transferManager,  
            // Delete segments_N file with ref count 1 created during index creation on replica shards  
            }  
    public void afterSyncToRemote(String file) {
     * Whenever we write a file to the directory we add a switchable entry in the FileCache (logic in cacheFile method below)
     * 4. If file is present in remote, then add a corresponding switchable entry in the file cache. Now once file cache has the entry we can follow step 2
    /**
        localDirectory.close();  
import static org.opensearch.index.store.remote.utils.FileTypeUtils.BLOCK_FILE_IDENTIFIER;
    }
                finalFileName = segments[0].strip();
import java.util.Arrays;
import org.apache.lucene.store.IOContext;
            logger.error("Failed to switch full file to blocked - " + file, e);  
        String[] localFiles = localDirectory.listAll();
        super.deleteFile(name);  
        try {
            .map(s -> s.contains(BLOCK_FILE_IDENTIFIER) ? s.substring(0, s.indexOf(BLOCK_FILE_IDENTIFIER)) : s)
 * Extension of Composite directory to support writable warm and other related features  
import org.opensearch.index.store.remote.utils.FileTypeUtils;  
import java.nio.file.Path;
    }
                // If local doesn't have segments_n, include all remote files
    public void rename(String source, String dest) throws IOException {  
        for (String localFile : localFiles) {
            if (hasLocalSegments) {
    }
                remoteDirectory,
        ensureOpen();
    protected void cacheFile(String fileName) throws IOException {
/*  
    public void deleteFile(String name) throws IOException {
            // decRef) for files already in remote  
        } finally {
        } catch (NullPointerException e) {
        String[] localFiles = listLocalFiles();
import org.apache.logging.log4j.Logger;
    ) {
    }  
    @Override
    public TieredDirectory(
        ensureOpen();
        } catch (IOException | IllegalStateException e) {
import org.opensearch.storage.utils.DirectoryUtils;
import org.opensearch.index.store.CompositeDirectory;
        // Check if local directory has any segments_n files
    // protected for testing
        }
    public String[] listLocalFiles() throws IOException {  
import org.opensearch.threadpool.ThreadPool;  
            } else {
        // remove block entries of source (along with the full file) if any from file cache
            }  
    }
 */  
import java.io.IOException;
    /**
 * The OpenSearch Contributors require contributions made to  
public class TieredDirectory extends CompositeDirectory {
     * and then depending upon if it is present, we add the switchable entry to the FileCache.
    }  
        ensureOpen();  
                String[] segments = localFile.split(BLOCK_FILE_IDENTIFIER);
    @Override  
        try {
import org.apache.lucene.store.IndexInput;  
     */
                DirectoryUtils.unwrapFSDirectory(localDirectory),
                cacheFromRemote,
     * 1. Check if file is .tmp file - read it from the local directory
 */  
        ThreadPool threadPool,  
                "SwitchableIndexInput (path=" + getFilePath(name) + ")",
    public IndexInput openInput(String name, IOContext context) throws IOException {  
 *
            .distinct()
import java.util.function.Supplier;
