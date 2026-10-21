    protected final Directory localDirectory;
             We can run into scenarios where stale files are evicted locally (zero refCount in FileCache) and
        this.localDirectory = localDirectory;
                    () -> name,
            } finally {
            remoteFiles = remoteDirectory.listAll();
            );
            return localDirectory.openInput(name, context);
     * @param fileName The name of the file to search for, along with its associated block files.
        for (String localFile : localFiles) {
     * Creates a new, empty file in the directory and returns an {@link IndexOutput} instance for
                    }
                        fileCache.remove(getFilePath(blockFile));
            }
            try {
     * Basic validations for Composite Directory parameters (null checks and instance type checks)
     * @param localDirectory corresponding to the local FSDirectory
            }
    /**
import org.opensearch.index.store.remote.file.OnDemandBlockSnapshotIndexInput;
            );
import org.opensearch.index.store.remote.utils.FileTypeUtils;
        boolean hasLocalSegments = Arrays.stream(localFiles).anyMatch(fileName -> fileName.startsWith(IndexFileNames.SEGMENTS));
     * Returns the byte length of a file in the directory.
             not present in remote as well (due to metadata refresh). In such scenarios listAll() of composite directory
        // We will be reading them directory from the local directory
        // within a very short span of time
    /**
            } else {
            logger.trace("Composite Directory[{}]: Complete file {} found in FileCache", this::toString, () -> name);
                    assert cachedIndexInput instanceof RestoredCachedIndexInput;
            remoteFiles = new String[0];
                try {
     */
        String[] remoteFiles;
            DirectoryUtils.unwrapFSDirectory(localDirectory);
    private static final Logger logger = LogManager.getLogger(CompositeDirectory.class);
     * @throws IOException in case of I/O error
                return cachedIndexInput;
        fileCache.put(filePath, new CachedFullFileIndexInput(fileCache, filePath, localDirectory.openInput(name, IOContext.DEFAULT)));
     * Closing the local directory here
    }
                    .toArray(String[]::new);
            // TODO : Refactor FileInfo and OnDemandBlockSnapshotIndexInput to more generic names as they are not Remote Snapshot
    private FSDirectory getLocalFSDirectory() {
        } else {
        String[] remoteFiles;
            We can encounter NPE when no data has been uploaded to remote store yet and as a result the metadata is empty
        }
    }
    }
                // If local doesn't have segments_n, include all remote files
    protected List<String> listBlockFiles(String fileName) throws IOException {
        String[] localFiles = listLocalFiles();
     * @throws IOException in case of I/O error
        ensureOpen();
            .collect(Collectors.toSet());
            fileLength = remoteDirectory.fileLength(name);
import org.apache.lucene.store.FSDirectory;
        Path key = getFilePath(name);
 * The OpenSearch Contributors require contributions made to
    /**
        ensureOpen();
import org.apache.lucene.index.IndexFileNames;
    @Override
        try {
    public String toString() {
                // TODO: https://github.com/opensearch-project/OpenSearch/issues/17526
                }
        // If file has been uploaded to the Remote Store, fetch it from the Remote Store in blocks via OnDemandCompositeBlockIndexInput
        }
package org.opensearch.index.store;
                fileCache.remove(getFilePath(localFile));
        localDirectory.sync(fullFilesToSync);
/**
             */
        Set<String> allFiles = Stream.concat(Arrays.stream(localFiles), Arrays.stream(remoteFiles))
            if (uploadedSegmentMetadata == null) {
            if (cachedIndexInput != null && cachedIndexInput.isClosed() && Files.exists(key)) {
            // specific
            logger.trace(
                .get(name);
            RemoteSegmentStoreDirectory.UploadedSegmentMetadata uploadedSegmentMetadata = remoteDirectory.getSegmentsUploadedToRemoteStore()
     * Opens a stream for reading an existing file.
 */
            "Local and remote directory cannot be null for Composite Directory"
    @Override
                null
        return Stream.of(listLocalFiles())
        Arrays.sort(files);
     *
     * @throws NoSuchFileException when file does not exist in the directory
    public void rename(String source, String dest) throws IOException {
import java.nio.file.Files;
import org.opensearch.common.annotation.ExperimentalApi;
        logger.trace("Composite Directory[{}]: Synced files : {}", this::toString, () -> fullFilesToSync);
    }
        } else {
        );
                }
        // The CloseableFilterIndexOutput will ensure that the file is added to FileCache once write is completed on this file
        try {
                    return new CachedFullFileIndexInput(fileCache, key, localDirectory.openInput(name, IOContext.DEFAULT));
            .collect(Collectors.toList());
 */
import java.util.stream.Stream;
     * @param file : recent files which have been successfully uploaded to Remote Store
    protected final ThreadPool threadPool;
     */
        // Return directly from the FileCache (via TransferManager) if complete file is present
        fileCache.remove(getFilePath(source));
     * @throws IOException in case of I/O error
import java.util.Set;
                this::toString,
    /**
                } catch (IOException e) {
     * Returns names of all files stored in local directory
     * Function to perform operations once files have been uploaded to Remote Store
        else {
import org.apache.logging.log4j.LogManager;
 * Implements all required methods by Directory abstraction
        super(localDirectory);
        );
            }
    private String[] getRemoteFiles() throws IOException {
        ensureOpen();
     * appending data to this file.
        CachedIndexInput indexInput = fileCache.compute(key, (path, cachedIndexInput) -> {
     * Return the list of files present in Remote
import org.apache.lucene.store.IOContext;
                // Remove this condition when this issue is addressed.
     * @param name the name of an existing file.
     * @throws IOException in case of I/O error
            // TODO: https://github.com/opensearch-project/OpenSearch/issues/17534
import java.util.stream.Collectors;
 *
                logger.debug("The file [{}] or its block files do not exist in local directory", name);
    /**
        fileCache.pin(filePath);
     */
            // Delete segments_N file with ref count 1 created during index creation on replica shards
    }
            .collect(Collectors.toList());
        ensureOpen();
import org.apache.logging.log4j.Logger;
     * Does not include locally stored block files (having _block_ in their names) and files pending deletion
                () -> name
        return remoteFiles;
        }
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;
    }
        try {
        } else if (Arrays.asList(listAll()).contains(name) == false) {
        );
import static org.opensearch.index.store.remote.utils.FileTypeUtils.BLOCK_FILE_IDENTIFIER;
        this.fileCache = fileCache;
     * Constructor to initialise the composite directory
                    if (fileCache.get(getFilePath(blockFile)) == null) {
        if (FileTypeUtils.isTempFile(name)) {
     * @param name the name of an existing file.
import java.util.Collection;
        logger.trace("Composite Directory[{}]: close() called", this::toString);
import java.nio.file.NoSuchFileException;
    /**
            (name, position, length) -> new InputStreamIndexInput(
        if (remoteDirectory instanceof RemoteSegmentStoreDirectory == false) throw new IllegalStateException(
     * Note: Currently Composite Directory only supports local directory to be of type FSDirectory
        Set<String> nonBlockLuceneFiles = allFiles.stream()
import java.nio.file.Path;
                fileCache.decRef(key);
     * TODO : Refactor FileCache to have key in form of String instead of Path. Once that is done we can remove this assertion
                    "Composite Directory[{}]: fileLength of {} fetched from Local - {}",
    private void validate(Directory localDirectory, Directory remoteDirectory, FileCache fileCache) {
            BlobStoreIndexShardSnapshot.FileInfo fileInfo = new BlobStoreIndexShardSnapshot.FileInfo(
     */
     *
        fileCache.decRef(filePath);
import static org.apache.lucene.index.IndexFileNames.SEGMENTS;
            }
                    this::toString,
                "Composite Directory[{}]: Complete file {} not in FileCache, to be fetched in Blocks from Remote",
            fileCache,
import org.opensearch.index.store.remote.filecache.CachedFullFileIndexInput;
            threadPool
            return null;
     */
     */
    private String[] listLocalFiles() throws IOException {
        return new CloseableFilterIndexOutput(localDirectory.createOutput(name, context), name, this::cacheFile);
     * Currently deleting only from local directory as files from remote should not be deleted as that is taken care by garbage collection logic of remote directory
        transferManager = new TransferManager(
                this::toString,
            try {
        );
     */
        ensureOpen();
     * @throws IOException in case of I/O error
    public IndexOutput createOutput(String name, IOContext context) throws IOException {
    // TODO: https://github.com/opensearch-project/OpenSearch/issues/17527
            Empty metadata means that there are no files currently in remote, hence returning an empty list in this scenario
        ensureOpen();
        ensureOpen();
import org.opensearch.index.store.remote.filecache.FileCache;
        }
            // If entry exists and is not closed, use it
     * Removes an existing file in the directory.
        return localDirectory.listAll();
     */
    }
     * Currently deleting the local files here, as once uploaded to Remote, local files become eligible for eviction from FileCache
}
        );
    }
        String[] finalRemoteFiles = remoteFiles;
             will not show the file. Hence, we need to silently fail deleteFile operation for such files.
    public Path getFilePath(String name) {
        Set<String> remoteFiles = Set.of(getRemoteFiles());
    }
     */
                for (String blockFile : blockFiles) {
     * @throws IOException in case of I/O error while listing files.
    }
import org.apache.lucene.store.IndexOutput;
            return;
        logger.trace("Composite Directory[{}]: openInput() called {}", this::toString, () -> name);
                    .filter(fileName -> !fileName.startsWith(IndexFileNames.SEGMENTS))
        } catch (NullPointerException e) {
                    () -> fileLength
        this.remoteDirectory = (RemoteSegmentStoreDirectory) remoteDirectory;
     * @throws IOException in case of I/O error
     * Ensures that any writes to these files are moved to stable storage (made durable).
     *
                fileLength = localDirectory.fileLength(name);
        localDirectory.close();
        }
                    throw new RuntimeException(e);
     * the directory.
        Path key = getFilePath(name);
                CompositeDirectory.this.remoteDirectory.openBlockInput(name, position, length, IOContext.DEFAULT),
public class CompositeDirectory extends FilterDirectory implements RemoteSyncListener {
            // If entry is closed but file exists locally, create new IndexInput from local
        String[] localFiles = localDirectory.listAll();
        logger.trace(
    protected final RemoteSegmentStoreDirectory remoteDirectory;
        logger.trace("Composite Directory[{}]: rename() called : source-{}, dest-{}", this::toString, () -> source, () -> dest);
            .filter(name -> (remoteFiles.contains(name) == false) && (localFilesHavingBlocks.contains(name) == false))
        return fileLength;
import org.opensearch.index.store.remote.filecache.FileCache.RestoredCachedIndexInput;
    @Override
     * The reason is that FileCache currently has it key type as Path
                        localDirectory.deleteFile(blockFile);
    /**
     */
        logger.trace("Composite Directory[{}]: listAll() called", this::toString);
                () -> name,
     * Returns a list of names of all block files stored in the local directory for a given file,
        final Path filePath = getFilePath(file);
        localDirectory.rename(source, dest);
        return "Composite Directory @ " + Integer.toHexString(hashCode());
import org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshot;
                return indexInput.getIndexInput().clone();
                new StoreFileMetadata(name, uploadedSegmentMetadata.getLength(), uploadedSegmentMetadata.getChecksum(), Version.LATEST),
        logger.trace("Composite Directory[{}]: sync() called {}", this::toString, () -> names);
     * @return A list of file names, including the original file (if present) and all its block files.
                () -> fileLength
 * @opensearch.experimental
        if (FileTypeUtils.isTempFile(name) || fileCache.get(key) != null) {
        String[] files = new String[nonBlockLuceneFiles.size()];
     * Composite Directory currently uses FSDirectory's getDirectory() method to fetch and use the Path for operating on FileCache
    public long fileLength(String name) throws IOException {
import org.apache.lucene.util.Version;
            if (localFile.startsWith(SEGMENTS)) {
                logger.trace(
import org.apache.lucene.store.FilterDirectory;
import java.io.IOException;
 * compatible open source license.
        }
            "For Composite Directory, remote directory must be of type RemoteSegmentStoreDirectory"
    protected final FileCache fileCache;
    public void sync(Collection<String> names) throws IOException {
                );
        validate(localDirectory, remoteDirectory, fileCache);
    @Override
    @Override
     * @param remoteDirectory corresponding to the remote directory
            .filter(FileTypeUtils::isBlockFile)
    }
/*
     * @throws IOException in case of I/O error
     * @throws IOException in case of I/O error
     * @throws IOException in case of I/O error
    }
            } finally {
     * Check whether the file is present locally or in remote and return the IndexInput accordingly
     * Throws {@link NoSuchFileException} or {@link FileNotFoundException} in case file is not present locally and in remote as well
            } else {
        nonBlockLuceneFiles.toArray(files);
        // We aren't tracking temporary files (created via createTempOutput) currently in FileCache as these are created and then deleted
     * Returns names of all files stored in this directory in sorted order
    public void afterSyncToRemote(String file) {
    @Override
    protected void cacheFile(String name) throws IOException {
            return new OnDemandBlockSnapshotIndexInput(fileInfo, getLocalFSDirectory(), transferManager);
            }
    /**
            logger.trace(
        });
        }
    protected final TransferManager transferManager;
     */
     */
            if (hasLocalSegments) {
    }
            List<String> blockFiles = listBlockFiles(name);
        if (indexInput != null) {
@ExperimentalApi
    /**
    @Override
        } catch (NullPointerException e) {
            // Return null to fall back to remote store block download/existing block reuse.
    }
        ensureOpen();
    @Override
            );
import org.opensearch.common.lucene.store.InputStreamIndexInput;
        Path filePath = getFilePath(name);
            .collect(Collectors.toUnmodifiableSet());
            /*
            "Composite Directory[{}]: File {} uploaded to Remote Store and now can be eligible for eviction in FileCache",
        return getLocalFSDirectory().getDirectory().resolve(name);
            }
import java.io.FileNotFoundException;
    }
    /**
    }
        long fileLength;
        ensureOpen();
        // Check if local directory has any segments_n files
            }
        return DirectoryUtils.unwrapFSDirectory(localDirectory);
    /**
                remoteFiles = Arrays.stream(remoteDirectory.listAll())
                fileCache.decRef(key);
 * SPDX-License-Identifier: Apache-2.0
                // If local has segments_n, filter out segments_n from remote
        logger.trace("Composite Directory[{}]: listAll() returns : {}", this::toString, () -> Arrays.toString(files));
        fileCache.unpin(filePath);
    public void deleteFile(String name) throws IOException {
        logger.trace("Composite Directory[{}]: deleteFile() called {}", this::toString, () -> name);
            throw new IllegalStateException("For Composite Directory, local directory must be of type FSDirectory");
        } catch (IllegalArgumentException e) {
             */
    /**
            "File Cache not initialized on this Node, cannot create Composite Directory without FileCache"
import java.util.Arrays;
     * Renames {@code source} file to {@code dest} file where {@code dest} must not already exist in
 *
        logger.trace("Composite Directory[{}]: Remote Directory files - {}", this::toString, () -> Arrays.toString(finalRemoteFiles));
            .map(s -> s.contains(BLOCK_FILE_IDENTIFIER) ? s.substring(0, s.indexOf(BLOCK_FILE_IDENTIFIER)) : s)
        logger.trace("Composite Directory[{}]: createOutput() called {}", this::toString, () -> name);
     */
            /*
            }
                    } else {
     * @param name the name of an existing file.
    public String[] listAll() throws IOException {
    public CompositeDirectory(Directory localDirectory, Directory remoteDirectory, FileCache fileCache, ThreadPool threadPool) {
        logger.trace("Composite Directory[{}]: Local Directory files - {}", this::toString, () -> Arrays.toString(localFiles));
    }
            .collect(Collectors.toSet());
        Collection<String> fullFilesToSync = names.stream()
import org.opensearch.threadpool.ThreadPool;
            .map(file -> file.substring(0, file.indexOf(BLOCK_FILE_IDENTIFIER)))
            TODO : Catch the NPE in listAll of RemoteSegmentStoreDirectory itself instead of catching here
    // Visibility public since we need it in IT tests
     * @param fileCache used to cache the remote files locally
import org.opensearch.index.store.remote.filecache.CachedIndexInput;
            localDirectory.deleteFile(name);
            () -> file
            remoteFiles = new String[] {};
            if (cachedIndexInput != null && cachedIndexInput.isClosed() == false) {
    /**
    }
        cacheFile(dest);
                length
        logger.trace("Composite Directory[{}]: fileLength() called {}", this::toString, () -> name);
            ),
 * Consumers of Composite directory need not worry whether file is in local or remote
            .filter(file -> file.equals(fileName) || file.startsWith(fileName + FileTypeUtils.BLOCK_FILE_IDENTIFIER))
        logger.trace("Composite Directory[{}]: listLocalOnly() called", this::toString);
import org.opensearch.index.store.remote.utils.TransferManager;
        if (fileCache == null) throw new IllegalStateException(
    /**
     * @param name the name of the file to create.
        ensureOpen();
    public void close() throws IOException {
                name,
import org.apache.lucene.store.Directory;
    public IndexInput openInput(String name, IOContext context) throws IOException {
                throw new NoSuchFileException("File " + name + " not found in directory");
    @Override
                "Composite Directory[{}]: fileLength of {} fetched from Remote - {}",
        }
        // fileCache.remove(filePath);
        Set<String> localFilesHavingBlocks = Arrays.stream(listLocalFiles())
            this::toString,
import org.opensearch.storage.utils.DirectoryUtils;
 * Composite Directory will contain both local and remote directory
        if (FileTypeUtils.isTempFile(name)) {
        }
     * including the original file itself if present.
                remoteFiles = remoteDirectory.listAll();
            .filter(file -> !FileTypeUtils.isBlockFile(file))
 * All such abstractions will be handled by the Composite directory itself
        if (localDirectory == null || remoteDirectory == null) throw new IllegalStateException(
                        logger.debug("The file [{}] exists in local but not part of FileCache, deleting it from local", blockFile);
import org.apache.lucene.store.IndexInput;
     */
        this.threadPool = threadPool;
            if (blockFiles.isEmpty()) {
        return files;
