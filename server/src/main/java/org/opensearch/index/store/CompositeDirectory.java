             */  
        } catch (NullPointerException e) {  
        } else {  
     * Does not include locally stored block files (having _block_ in their names) and files pending deletion  
     */  
        localDirectory.close();
            remoteFiles = remoteDirectory.listAll();
        logger.trace("Composite Directory[{}]: Remote Directory files - {}", this::toString, () -> Arrays.toString(finalRemoteFiles));
    }  
import org.apache.lucene.store.FilterDirectory;  
    @Override
     * Currently deleting only from local directory as files from remote should not be deleted as that is taken care by garbage collection logic of remote directory
        ensureOpen();
 *
     * Ensures that any writes to these files are moved to stable storage (made durable).  
            // TODO : Refactor FileInfo and OnDemandBlockSnapshotIndexInput to more generic names as they are not Remote Snapshot
                for (String blockFile : blockFiles) {  
        transferManager = new TransferManager(  
            "Composite Directory[{}]: File {} uploaded to Remote Store and now can be eligible for eviction in FileCache",
    private static final Logger logger = LogManager.getLogger(CompositeDirectory.class);
                fileCache.decRef(key);
import java.io.FileNotFoundException;  
import java.io.IOException;
import org.apache.lucene.store.FSDirectory;
        // The CloseableFilterIndexOutput will ensure that the file is added to FileCache once write is completed on this file
    protected void cacheFile(String name) throws IOException {
     */
                return indexInput.getIndexInput().clone();  
                return cachedIndexInput;
import org.opensearch.index.store.remote.filecache.FileCache.RestoredCachedIndexInput;  
        logger.trace("Composite Directory[{}]: fileLength() called {}", this::toString, () -> name);  
            try {
    protected final FileCache fileCache;
            } else {
import org.opensearch.index.store.remote.filecache.FileCache;
     * @param name the name of an existing file.  
        fileCache.put(filePath, new CachedFullFileIndexInput(fileCache, filePath, localDirectory.openInput(name, IOContext.DEFAULT)));
                () -> fileLength  
import java.util.Set;
            // specific  
        try {
        localDirectory.sync(fullFilesToSync);
            );
    }
        }
        Set<String> allFiles = Stream.concat(Arrays.stream(localFiles), Arrays.stream(remoteFiles))
            .collect(Collectors.toList());
    @Override  
    }  
            BlobStoreIndexShardSnapshot.FileInfo fileInfo = new BlobStoreIndexShardSnapshot.FileInfo(
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.index.store.remote.utils.FileTypeUtils;
        return getLocalFSDirectory().getDirectory().resolve(name);  
            /*
    // TODO: https://github.com/opensearch-project/OpenSearch/issues/17527
        ensureOpen();
            logger.trace(
    /**  
     *  
            "File Cache not initialized on this Node, cannot create Composite Directory without FileCache"
     * Currently deleting the local files here, as once uploaded to Remote, local files become eligible for eviction from FileCache  
        if (FileTypeUtils.isTempFile(name)) {
                // If local doesn't have segments_n, include all remote files
import org.apache.lucene.util.Version;
     */
                    return new CachedFullFileIndexInput(fileCache, key, localDirectory.openInput(name, IOContext.DEFAULT));
import org.apache.lucene.store.Directory;
        boolean hasLocalSegments = Arrays.stream(localFiles).anyMatch(fileName -> fileName.startsWith(IndexFileNames.SEGMENTS));
import static org.apache.lucene.index.IndexFileNames.SEGMENTS;
        ensureOpen();
        }
import java.nio.file.Files;
 * this file be licensed under the Apache-2.0 license or a
        Collection<String> fullFilesToSync = names.stream()  
    }
            if (localFile.startsWith(SEGMENTS)) {
import java.nio.file.Path;
    }
 * Consumers of Composite directory need not worry whether file is in local or remote
        CachedIndexInput indexInput = fileCache.compute(key, (path, cachedIndexInput) -> {
import java.util.Arrays;
    }
    public String[] listAll() throws IOException {  
     * Function to perform operations once files have been uploaded to Remote Store
            logger.trace("Composite Directory[{}]: Complete file {} found in FileCache", this::toString, () -> name);
            return;
        logger.trace("Composite Directory[{}]: listLocalOnly() called", this::toString);
                        fileCache.remove(getFilePath(blockFile));
            .filter(file -> !FileTypeUtils.isBlockFile(file))  
     * Creates a new, empty file in the directory and returns an {@link IndexOutput} instance for
        String[] localFiles = localDirectory.listAll();  
        }
        String[] localFiles = listLocalFiles();  
    protected List<String> listBlockFiles(String fileName) throws IOException {
            }  
             not present in remote as well (due to metadata refresh). In such scenarios listAll() of composite directory
 * compatible open source license.
        // Return directly from the FileCache (via TransferManager) if complete file is present
            ),
        String[] files = new String[nonBlockLuceneFiles.size()];
                CompositeDirectory.this.remoteDirectory.openBlockInput(name, position, length, IOContext.DEFAULT),
            return new OnDemandBlockSnapshotIndexInput(fileInfo, getLocalFSDirectory(), transferManager);  
                this::toString,  
public class CompositeDirectory extends FilterDirectory implements RemoteSyncListener {  
     * @param name the name of the file to create.  
                new StoreFileMetadata(name, uploadedSegmentMetadata.getLength(), uploadedSegmentMetadata.getChecksum(), Version.LATEST),  
            }  
            return null;  
        logger.trace("Composite Directory[{}]: Local Directory files - {}", this::toString, () -> Arrays.toString(localFiles));
     *
 * SPDX-License-Identifier: Apache-2.0
            .collect(Collectors.toSet());
     */
        if (localDirectory == null || remoteDirectory == null) throw new IllegalStateException(
            }
        String[] remoteFiles;  
    public IndexInput openInput(String name, IOContext context) throws IOException {
     */
    @Override
 * Implements all required methods by Directory abstraction
                () -> name,
        validate(localDirectory, remoteDirectory, fileCache);
import org.opensearch.index.store.remote.filecache.CachedIndexInput;
    }
     * Removes an existing file in the directory.
            if (blockFiles.isEmpty()) {
    @Override  
import org.apache.logging.log4j.Logger;
     * @param fileCache used to cache the remote files locally  
import org.apache.lucene.index.IndexFileNames;  
            remoteFiles = new String[0];  
            try {
                    if (fileCache.get(getFilePath(blockFile)) == null) {
        }  
import org.opensearch.index.store.remote.filecache.CachedFullFileIndexInput;  
            .collect(Collectors.toSet());
        );
            RemoteSegmentStoreDirectory.UploadedSegmentMetadata uploadedSegmentMetadata = remoteDirectory.getSegmentsUploadedToRemoteStore()  
        ensureOpen();
    /**
            }
            } finally {
                }
     * @throws NoSuchFileException when file does not exist in the directory
        // We will be reading them directory from the local directory  
    protected final TransferManager transferManager;
            "Local and remote directory cannot be null for Composite Directory"
     * @throws IOException in case of I/O error while listing files.
        String[] finalRemoteFiles = remoteFiles;  
     */
    }
        ensureOpen();
             */
     * Composite Directory currently uses FSDirectory's getDirectory() method to fetch and use the Path for operating on FileCache  
        logger.trace("Composite Directory[{}]: createOutput() called {}", this::toString, () -> name);  
                "Composite Directory[{}]: fileLength of {} fetched from Remote - {}",  
        // fileCache.remove(filePath);
        cacheFile(dest);  
    /**
            }
            TODO : Catch the NPE in listAll of RemoteSegmentStoreDirectory itself instead of catching here
     */
        return remoteFiles;
        logger.trace("Composite Directory[{}]: rename() called : source-{}, dest-{}", this::toString, () -> source, () -> dest);  
     * Note: Currently Composite Directory only supports local directory to be of type FSDirectory
            localDirectory.deleteFile(name);  
                throw new NoSuchFileException("File " + name + " not found in directory");  
                fileCache.decRef(key);
    /**
        // We aren't tracking temporary files (created via createTempOutput) currently in FileCache as these are created and then deleted
        Set<String> remoteFiles = Set.of(getRemoteFiles());
    }
     * @param fileName The name of the file to search for, along with its associated block files.  
            .map(file -> file.substring(0, file.indexOf(BLOCK_FILE_IDENTIFIER)))
    public long fileLength(String name) throws IOException {
            this::toString,
        fileCache.remove(getFilePath(source));
                fileCache.remove(getFilePath(localFile));
        logger.trace("Composite Directory[{}]: sync() called {}", this::toString, () -> names);  
                length  
                    "Composite Directory[{}]: fileLength of {} fetched from Local - {}",
                logger.trace(  
        }
            fileLength = remoteDirectory.fileLength(name);
            .filter(file -> file.equals(fileName) || file.startsWith(fileName + FileTypeUtils.BLOCK_FILE_IDENTIFIER))  
    public IndexOutput createOutput(String name, IOContext context) throws IOException {
            (name, position, length) -> new InputStreamIndexInput(
        return Stream.of(listLocalFiles())
    public CompositeDirectory(Directory localDirectory, Directory remoteDirectory, FileCache fileCache, ThreadPool threadPool) {
                        localDirectory.deleteFile(blockFile);  
                try {  
                this::toString,
            if (uploadedSegmentMetadata == null) {
     * @throws IOException in case of I/O error  
    public void sync(Collection<String> names) throws IOException {
        return files;  
import org.opensearch.common.annotation.ExperimentalApi;
            List<String> blockFiles = listBlockFiles(name);  
    }
import java.util.List;
import java.nio.file.NoSuchFileException;  
        final Path filePath = getFilePath(file);
                    () -> fileLength
     * The reason is that FileCache currently has it key type as Path
        ensureOpen();
            // Delete segments_N file with ref count 1 created during index creation on replica shards
    /**
        logger.trace("Composite Directory[{}]: listAll() returns : {}", this::toString, () -> Arrays.toString(files));
        nonBlockLuceneFiles.toArray(files);  
import org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshot;
                null
                remoteFiles = remoteDirectory.listAll();
import org.opensearch.index.store.remote.file.OnDemandBlockSnapshotIndexInput;
     *
        } catch (IllegalArgumentException e) {  
                    }  
    public void deleteFile(String name) throws IOException {
        logger.trace("Composite Directory[{}]: close() called", this::toString);
     */
            } finally {  
     */
                    () -> name,  
    @Override  
            return localDirectory.openInput(name, context);
import java.util.stream.Stream;
    }  
    @Override  
    /**
import static org.opensearch.index.store.remote.utils.FileTypeUtils.BLOCK_FILE_IDENTIFIER;  
    private String[] listLocalFiles() throws IOException {
     * Return the list of files present in Remote  
                    assert cachedIndexInput instanceof RestoredCachedIndexInput;
            // TODO: https://github.com/opensearch-project/OpenSearch/issues/17534  
                // Remove this condition when this issue is addressed.
    /**
 */
            logger.trace(
        logger.trace("Composite Directory[{}]: Synced files : {}", this::toString, () -> fullFilesToSync);  
    /**  
        Arrays.sort(files);
            // If entry exists and is not closed, use it
 * The OpenSearch Contributors require contributions made to  
        }
     * Returns the byte length of a file in the directory.
     * the directory.  
            );
    }
 */  
        String[] remoteFiles;
     * Opens a stream for reading an existing file.
            if (cachedIndexInput != null && cachedIndexInput.isClosed() && Files.exists(key)) {
                    } else {
     * appending data to this file.
     * Constructor to initialise the composite directory  
    }
            remoteFiles = new String[] {};
/*  
package org.opensearch.index.store;
        );
    }
    /**  
     */  
                fileLength = localDirectory.fileLength(name);
                } catch (IOException e) {  
        ensureOpen();  
    public String toString() {  
            threadPool  
        fileCache.decRef(filePath);
    }  
                () -> name
    protected final RemoteSegmentStoreDirectory remoteDirectory;  
    public Path getFilePath(String name) {
    /**  
    @Override
    private String[] getRemoteFiles() throws IOException {
            .filter(FileTypeUtils::isBlockFile)  
     * @param remoteDirectory corresponding to the remote directory
        long fileLength;
    private FSDirectory getLocalFSDirectory() {  
    protected final ThreadPool threadPool;  
import org.opensearch.storage.utils.DirectoryUtils;  
        Path key = getFilePath(name);
            We can encounter NPE when no data has been uploaded to remote store yet and as a result the metadata is empty
import org.apache.lucene.store.IndexOutput;  
        try {  
            () -> file  
 * All such abstractions will be handled by the Composite directory itself  
     * Closing the local directory here
        );
        logger.trace("Composite Directory[{}]: listAll() called", this::toString);
    public void afterSyncToRemote(String file) {  
import java.util.Collection;  
import java.util.stream.Collectors;  
     * Check whether the file is present locally or in remote and return the IndexInput accordingly
        );  
        else {  
    }
     * Renames {@code source} file to {@code dest} file where {@code dest} must not already exist in
        ensureOpen();
    public void rename(String source, String dest) throws IOException {
 *
     * @param name the name of an existing file.  
            } else {  
    /**
            Empty metadata means that there are no files currently in remote, hence returning an empty list in this scenario  
import org.apache.lucene.store.IOContext;
        } else {
                    .toArray(String[]::new);
        ensureOpen();
            /*
            if (cachedIndexInput != null && cachedIndexInput.isClosed() == false) {  
                );
                name,
     * @throws IOException in case of I/O error
            }
     * @throws IOException in case of I/O error
            if (hasLocalSegments) {
        Set<String> localFilesHavingBlocks = Arrays.stream(listLocalFiles())
        Path key = getFilePath(name);
            }  
            }  
                "Composite Directory[{}]: Complete file {} not in FileCache, to be fetched in Blocks from Remote",
            .collect(Collectors.toList());
        ensureOpen();  
     * @throws IOException in case of I/O error
     * Returns a list of names of all block files stored in the local directory for a given file,  
    /**
    /**
        this.threadPool = threadPool;
        return "Composite Directory @ " + Integer.toHexString(hashCode());
            );
        localDirectory.rename(source, dest);
import org.apache.logging.log4j.LogManager;
     * TODO : Refactor FileCache to have key in form of String instead of Path. Once that is done we can remove this assertion
        try {
/**  
        Path filePath = getFilePath(name);  
     * @throws IOException in case of I/O error
    }  
        });
 * @opensearch.experimental  
    // Visibility public since we need it in IT tests
    /**
        logger.trace(  
        if (FileTypeUtils.isTempFile(name) || fileCache.get(key) != null) {  
            "For Composite Directory, remote directory must be of type RemoteSegmentStoreDirectory"
import org.opensearch.index.store.remote.utils.TransferManager;
        this.localDirectory = localDirectory;
    protected final Directory localDirectory;
@ExperimentalApi
        // within a very short span of time
        // If file has been uploaded to the Remote Store, fetch it from the Remote Store in blocks via OnDemandCompositeBlockIndexInput
                .get(name);
        return localDirectory.listAll();
        } else if (Arrays.asList(listAll()).contains(name) == false) {
        for (String localFile : localFiles) {
                }
        this.remoteDirectory = (RemoteSegmentStoreDirectory) remoteDirectory;  
            .filter(name -> (remoteFiles.contains(name) == false) && (localFilesHavingBlocks.contains(name) == false))
     * @return A list of file names, including the original file (if present) and all its block files.
        if (indexInput != null) {  
    public void close() throws IOException {  
 * Composite Directory will contain both local and remote directory
        fileCache.pin(filePath);  
        if (fileCache == null) throw new IllegalStateException(
        );  
        } catch (NullPointerException e) {
     * Returns names of all files stored in local directory
        return fileLength;  
        Set<String> nonBlockLuceneFiles = allFiles.stream()
     */
import org.opensearch.common.lucene.store.InputStreamIndexInput;  
    }
        if (FileTypeUtils.isTempFile(name)) {
                    .filter(fileName -> !fileName.startsWith(IndexFileNames.SEGMENTS))
                // TODO: https://github.com/opensearch-project/OpenSearch/issues/17526  
        }  
    @Override
     * @param localDirectory corresponding to the local FSDirectory
     */
     * @throws IOException in case of I/O error
        return DirectoryUtils.unwrapFSDirectory(localDirectory);
        // Check if local directory has any segments_n files  
        }
                    throw new RuntimeException(e);
            // Return null to fall back to remote store block download/existing block reuse.
             will not show the file. Hence, we need to silently fail deleteFile operation for such files.
    @Override  
        super(localDirectory);  
     * @throws IOException in case of I/O error
}
        }  
            DirectoryUtils.unwrapFSDirectory(localDirectory);
     * Throws {@link NoSuchFileException} or {@link FileNotFoundException} in case file is not present locally and in remote as well
            .map(s -> s.contains(BLOCK_FILE_IDENTIFIER) ? s.substring(0, s.indexOf(BLOCK_FILE_IDENTIFIER)) : s)  
            .collect(Collectors.toUnmodifiableSet());
            throw new IllegalStateException("For Composite Directory, local directory must be of type FSDirectory");
     * Returns names of all files stored in this directory in sorted order
        return new CloseableFilterIndexOutput(localDirectory.createOutput(name, context), name, this::cacheFile);
            fileCache,
import org.apache.lucene.store.IndexInput;
     * @throws IOException in case of I/O error  
                    this::toString,
        logger.trace("Composite Directory[{}]: deleteFile() called {}", this::toString, () -> name);
     * including the original file itself if present.
                        logger.debug("The file [{}] exists in local but not part of FileCache, deleting it from local", blockFile);
                remoteFiles = Arrays.stream(remoteDirectory.listAll())  
        if (remoteDirectory instanceof RemoteSegmentStoreDirectory == false) throw new IllegalStateException(  
        logger.trace("Composite Directory[{}]: openInput() called {}", this::toString, () -> name);  
     * @throws IOException in case of I/O error
            // If entry is closed but file exists locally, create new IndexInput from local
                logger.debug("The file [{}] or its block files do not exist in local directory", name);
     */
                // If local has segments_n, filter out segments_n from remote
     */  
        fileCache.unpin(filePath);  
    private void validate(Directory localDirectory, Directory remoteDirectory, FileCache fileCache) {  
     * @param name the name of an existing file.  
     * Basic validations for Composite Directory parameters (null checks and instance type checks)
        this.fileCache = fileCache;
     * @param file : recent files which have been successfully uploaded to Remote Store
             We can run into scenarios where stale files are evicted locally (zero refCount in FileCache) and  
