                allMounts,  
            assert Files.isDirectory(nodePath.path) : nodePath.path + " is not a directory";
            final Path target = nodePath.path.resolve(TEMP_FILE_NAME + ".final");
    }
         */
            this.fileCachePath = path.resolve(CACHE_FOLDER);
        void acquire(long timeoutInMillis, final String details) throws ShardLockObtainFailedException {  
            throw new IllegalStateException(message);  
     */
     */
    public interface ShardLocker {
                    totFSPath.add(fsPath);
    }  
                for (Path indexPath : indexStream) {
import org.opensearch.core.common.Strings;
            }  
    }  
            applySegmentInfosTrace(settings);  
            b.append(item);
        assertEnvIsLocked();
                Files.createFile(src);
            if (Files.exists(indexFolder)) {
    /**
     */
                        "obtaining shard lock for ["
            final Logger logger,  
import org.opensearch.index.shard.ShardPath;
        return fileCachePath.resolve(shardId.getIndex().getUUID()).resolve(Integer.toString(shardId.id()));
                    setDetails(details);  
    private static Path resolveIndexCustomLocation(String customDataPath, String indexUUID, Path sharedDataPath, int nodeLockId) {
                Thread.currentThread().interrupt();
import static java.util.Collections.unmodifiableSet;
            }
import org.opensearch.index.IndexSettings;
        protected void release() {
            deleteIndexDirectoryUnderLock(index, indexSettings);
        final Path[] indexPaths = indexPaths(index);  
            }
     * @param shardId the id of the shard to delete to delete  
        if (nodePaths == null || locks == null) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(indicesLocation)) {  
        List<Path> indexMetadataPaths = collectIndexMetadataPaths(nodePaths);
            Path customLocation = resolveCustomLocation(indexSettings.customDataPath(), shardId);
                DiscoveryNodeRole.DATA_ROLE.roleName(),
        Set<Path> existingPaths = Stream.of(paths).filter(FileSystemUtils::exists).filter(leftOver -> {
        return indexFolders;  
                Path p = shardPaths[i].resolve("index");  
    /**  
                        shardIds.add(id);
        /**
                }
        List<Path> indexSubPaths = new ArrayList<>();
    public static final String CACHE_FOLDER = "cache";
    /**
                            + "ms], lock already held for ["  
    public Path resolveCustomLocation(String customDataPath, final ShardId shardId) {  
    static List<Path> collectIndexMetadataPaths(NodePath[] nodePaths) throws IOException {
         * Resolves the given shards directory against this NodePath  
                assert nodeIds.isEmpty() : nodeIds;  
    private static boolean isIndexMetadataPath(Path path) {  
            decWaitCount();
                }  
        logger.trace("deleting shard {} directory, paths: [{}]", shardId, paths);
                    ensureNoIndexMetadata(nodePaths);  
    private void assertCanWrite() throws IOException {  
        final List<ShardLock> locks = lockAllForIndex(index, indexSettings, "deleting index directory", lockTimeoutMS);  
     * Find all the shards for this index, returning a map of the {@code NodePath} to the number of shards on that path
     * <p>
import org.opensearch.index.store.IndexStoreListener;
        }  
        if (Files.exists(path)) {
        return sharedDataPath;  
import java.nio.file.Files;  
                            Files.createDirectories(dir);
        }
                            onCreateDirectoriesException.set(e);
        }
        }
        for (int i = 0; i < nodePaths.length; i++) {
            }
    private final Map<ShardId, InternalShardLock> shardLocks = new HashMap<>();  
                }
 * the Apache License, Version 2.0 (the "License"); you may
                allLocks.add(shardLock(new ShardId(index, i), lockDetails, timeoutLeftMS));
                sb.append('\n').append(" -> ").append(nodePath.path.toAbsolutePath());
        if (indexMetadataPaths.isEmpty() == false) {  
        for (Path path : nodeDataPaths()) { // check node-paths are writable
    public Path[] indexPaths(Index index) {
     * @return the {@link ShardLock} instances for this index.
    }  
            } catch (InterruptedException e) {
import java.util.Arrays;
     */  
        if (closed.compareAndSet(false, true) && locks != null) {
            final String message = String.format(
                    if (onCreateDirectoriesException.get() != null) {
    private static Set<ShardId> findAllShardsForIndex(Path indexPath, Index index) throws IOException {  
    public void deleteShardDirectorySafe(ShardId shardId, IndexSettings indexSettings) throws IOException, ShardLockObtainFailedException {  
        return paths.toArray(new Path[0]);  
            IOUtils.closeWhileHandlingException(dirs);  
                            try (Stream<Path> shardStream = Files.list(indexPath)) {
        }
                }
    }
                    // ignore any LockObtainFailedException
        Set<String> indexFolders = new HashSet<>();  
     * effort, as the lock is released before the deletion happens in order to
        }  
            mutex.release();  
                success = true;  
        final Set<String> indexFolders = new HashSet<>();  
     *
     * returns the unique uuid describing this node. The uuid is persistent in the data folder of this node
 * this work for additional information regarding copyright
     *
                    logger.trace("releasing lock [{}]", lock);
    /**  
                    return stateChildren.iterator().hasNext();
        }
                    for (Path shardPath : stream) {
     * @see #resolveCustomLocation(String, ShardId)
import org.opensearch.core.xcontent.NamedXContentRegistry;
            logger.trace("deleting custom shard {} directory [{}]", shardId, customLocation);
    private void ensureNoFileCacheData(final NodePath fileCacheNodePath, final Settings settings) throws IOException {  
        public final int majorDeviceNumber;
    }  
                            throw e;
    /**  
            logger.trace("acquiring lock for {}, custom path: [{}]", shardId, customLocation);  
            try (DirectoryStream<Path> children = Files.newDirectoryStream(leftOver)) {
        }  
                FsInfo.Path fsPath = FsProbe.getFSInfo(nodePath);
        public void close() {
                    String fileName = shardPath.getFileName().toString();  
            // load legacy metadata  
    private static NodeMetadata loadNodeMetadata(Settings settings, Logger logger, NodePath... nodePaths) throws IOException {  
        Path indicesLocation = nodePath.indicesPath;
            }
        }  
        }
 *  
    /**
                dirs[i] = new NIOFSDirectory(p, indexSettings.getValue(FsDirectoryFactory.INDEX_LOCK_FACTOR_SETTING));
            }
        if (nodePaths == null || locks == null) {
    public Set<String> availableIndexFolders() throws IOException {
import org.apache.lucene.store.Lock;
        public String toString() {
import java.util.Map;  
                if (iter.hasNext() == false) {  
                            tryWriteTempFile(indexDir);
        /*  
    private static boolean isShardPath(Path path) {
     * @param indexSettings settings for the index being deleted
 */  
        Set<ShardId> shardIds = new HashSet<>();
        final String indexUniquePathId = index.getUUID();  
        }  
        return allLocks;
            this.nodeId = nodeId;
    /**  
            }
     *
        // Structure is: <file cache path>/<index uuid>/<shard id>/...  
    private final Lock[] locks;
            throw new IllegalStateException("node is not configured to store local location");  
                for (int dirIndex = 0; dirIndex < dataPaths.length; dirIndex++) {  
     * @throws IOException if an IOException occurs
     * @param lockTimeoutMS how long to wait for acquiring the indices shard locks  
    /**
                    }
    public boolean hasNodeFile() {  
        }  
     * A functional interface that people can use to reference {@link #shardLock(ShardId, String, long)}
        throws IOException {
                + path
                    }  
                + fileStore  
            public void setDetails(String details) {
            final String message = String.format(  
     */
    public NodePath fileCacheNodePath() {
                shardLock.acquire(lockTimeoutMS, details);
                // create a lock for the "write.lock" file  
     * scans the node paths and loads existing metadata file. If not found a new meta data will be generated
     * @param details information about why the shard is being locked  
        } else {
    public static final String INDICES_FOLDER = "indices";  
        }  
        if (DiscoveryNode.isDedicatedWarmNode(settings)) {
                "using [{}] data paths, mounts [{}], net usable_space [{}], net total_space [{}], types [{}]",
     * Collect the paths containing shard data in the indicated node paths. The returned paths will point to the shard data folder.
     * @throws OpenSearchException if the write.lock is not acquirable
            return nodePaths;
            try {  
        }
        private volatile Tuple<Long, String> lockDetails;  
        List<ShardLock> allLocks = new ArrayList<>(numShards);
     * The returned paths will point to the shard data folder.  
                logger.trace("shard lock wait count for {} is now [{}]", shardId, waitCount);  
 * @opensearch.api
            indexFolders.addAll(availableIndexFoldersForPath(nodePath, excludeIndexPathIdsPredicate));
                    .append(fsPath.getFree())  
                    .append("], total_space [")  
    );  
    /**
        // We do some I/O in here, so skip this if DEBUG/INFO are not enabled:  
            Path indexFolder = nodePath.indicesPath.resolve(indexFolderName);
                }  
                            + details  
 *
                    if (excludeIndexPathIdsPredicate.test(fileName) == false && Files.isDirectory(index)) {  
            } else {
    public ShardLock shardLock(final ShardId shardId, final String details, final long lockTimeoutMS)
     * Resolve the custom path for a index's shard.
     * @param index the index by which to filter shards  
                "node does not have the %s and %s roles but has index metadata: %s. Use 'opensearch-node repurpose' tool to clean up",  
    /**
     */  
    /**
        assertEnvIsLocked();
    public static List<Path> collectFileCacheDataPath(NodePath fileCacheNodePath, Settings settings) throws IOException {
        }  
        }  
                    String type = fsPath.getType();  
    }
            nodePaths = new NodePath[environment.dataFiles().length];
                    .append("], usable_space [")
     * Resolve the custom path for a index's shard.  
                final Path[] dataPaths = environment.dataFiles();
    private void maybeLogPathDetails() throws IOException {
    public Path resolveFileCacheLocation(final Path fileCachePath, final ShardId shardId) {  
    public NodePath[] nodePaths() {
     */
     */  
                        logger.trace(() -> new ParameterizedMessage("failed to obtain node lock on {}", dir.toAbsolutePath()), e);
                    for (Path indexPath : indexStream) {  
    /**  
            } catch (IOException e) {
    private final AtomicBoolean closed = new AtomicBoolean(false);
     * @param customDataPath the custom data path
        if (numShards <= 0) {
            } catch (IOException ex) {
     * @opensearch.internal
    public void deleteIndexDirectorySafe(Index index, long lockTimeoutMS, IndexSettings indexSettings) throws IOException,
                metadata = legacyMetadata;
 * ownership. Elasticsearch licenses this file to you under  
                    InternalShardLock remove = shardLocks.remove(shardId);  
                                shardStream.filter(subPathPredicate).map(Path::toAbsolutePath).forEach(indexSubPaths::add);  
                close();
     * @param customDataPath the custom data path  
        }
     * @param shardId shard to resolve the path to
 * GitHub history for details.
        assert metadata.nodeVersion().equals(Version.CURRENT) : metadata.nodeVersion() + " != " + Version.CURRENT;
        final String lockDetails,  
            if (nodeIds.size() > 1) {  
        for (NodePath nodePath : nodePaths) {
            for (int i = 0; i < shardPaths.length; i++) {
    public static Path resolveNodePath(final Path path, final int nodeLockId) {  
        1,  
    public Path[] availableShardPaths(ShardId shardId) {
                Files.move(src, target, StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
                + "path="
    }
        } catch (ShardLockObtainFailedException ex) {
     * Note: this method will return immediately if the lock can't be acquired.
                    }
import java.util.Collection;
    }  
import java.nio.file.DirectoryStream;
            return indicesPath.resolve(uuid);
     */
        final Path[] paths = availableShardPaths(shardId);
            IOUtils.rm(customLocation);  
}
                }  
        assert index != null;
                    logger.trace("last shard lock wait decremented, removing lock for {}", shardId);
                    IOUtils.closeWhileHandlingException(locks[i]);
    public List<ShardLock> lockAllForIndex(  
                throw new IllegalStateException("data paths " + Arrays.toString(paths) + " belong to multiple nodes with IDs " + nodeIds);
                try {
import org.opensearch.common.unit.TimeValue;  
    private static String toString(Collection<String> items) {
import java.util.Random;
     * Collect the path containing cache data in the indicated cache node path.
import org.opensearch.core.index.shard.ShardId;
    }
     * shard paths. The "write.lock" file is assumed to be under the shard
            lockDetails = Tuple.tuple(System.nanoTime(), details);
         * @param pathFunction function to check node path before attempt of acquiring a node lock
     *
    }  
            // load legacy metadata
import java.util.ArrayList;  
                    break;  
        }  
        1,
                sb.append(", free_space [")
                } catch (IOException e) {
            // Process <indices>/... path only for warm nodes.
        return shardCountPerPath;  
     * Note: this method assumes that the shard lock is acquired
        } else if (logger.isInfoEnabled()) {  
        final ShardId shardId = lock.getShardId();
                    throw new IllegalStateException("environment is not locked", e);  
                + ", fileStore="
     * @param index the index to filter shards
        }
        }
    public void deleteIndexDirectoryUnderLock(Index index, IndexSettings indexSettings) throws IOException {  
                        continue;
        public final Path indicesPath;  
     * Return all directory names in the nodes/{node.id}/indices directory for the given node path.  
                try (DirectoryStream<Path> stream = Files.newDirectoryStream(indexPath)) {  
                    if (type != null) {
                );
                    Files.deleteIfExists(src);  
    private static void ensureAtomicMoveSupported(final NodePath[] nodePaths) throws IOException {  
 * license agreements. See the NOTICE file distributed with
    public Path[] nodeDataPaths() {
import java.util.HashMap;
            // Just log a 1-line summary:
                    if (Files.isDirectory(shardPath) && fileName.chars().allMatch(Character::isDigit)) {
        return availableIndexFolders(p -> false);  
     * locks for the shard's paths before deleting the data, but this is best
                throw new IOException("failed to test writes in data directory [" + path + "] write permission is required", ex);  
    }
                } catch (IOException ex) {  
        return paths;
        }
            } catch (IOException e) {  
    }
    private final int nodeLockId;
                this.majorDeviceNumber = -1;  
    }  
    static final String TEMP_FILE_NAME = ".opensearch_temp_file";
     */
     * Collect the paths containing index meta data in the indicated node paths. The returned paths will point to the
                logger.debug("using node location [{}], local_lock_id [{}]", nodePaths, nodeLockId);  
        if (logger.isDebugEnabled()) {
            final NodeMetadata legacyMetadata = NodeMetadata.FORMAT.loadLatestState(logger, NamedXContentRegistry.EMPTY, paths);
        assertEnvIsLocked();
        return availableIndexFoldersForPath(nodePath, p -> false);
     * a {@link ShardLockObtainFailedException} is thrown.  
    /**
    }  
        for (final NodePath nodePath : nodePaths) {  
     */
        if (ENABLE_LUCENE_SEGMENT_INFOS_TRACE_SETTING.get(settings)) {
                        }
        if (acquired == false) {
        return collectIndexSubPaths(nodePaths, NodeEnvironment::isIndexMetadataPath);  
import java.io.IOException;
    private final Logger logger = LogManager.getLogger(NodeEnvironment.class);
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
        return nodePaths;
import java.util.concurrent.atomic.AtomicReference;  
     * Uses the {@code IndexMetadata.SETTING_DATA_PATH} setting to determine
        final InternalShardLock shardLock;
import java.nio.file.Path;
    private final NodePath[] nodePaths;
        return metadata;
     *  
import org.opensearch.Version;
        final boolean acquired;
import org.opensearch.monitor.jvm.JvmInfo;
import org.opensearch.common.CheckedFunction;
        return shardLock(id, details, 0);  
    }  
    /**
     */
            // Log one line per path.data:
                throw new ShardLockObtainFailedException(shardId, "thread interrupted while trying to obtain shard lock", e);  
        if (Files.isDirectory(indexPath)) {  
/*  
            this.locks = nodeLock.locks;
        if (nodePaths == null || locks == null) {  
            shardStream.filter(NodeEnvironment::isShardPath).map(Path::toAbsolutePath).forEach(indexSubPaths::add);
     * @param lockTimeoutMS how long to wait for acquiring the indices shard locks  
        final Index index,
        false,
        return shardIds;  
                logger.trace("unable to lock all shards for index {}", index);
        for (int i = 0; i < paths.length; i++) {
        throws ShardLockObtainFailedException {
    /**
                        ShardId id = new ShardId(index, shardId);  
import org.apache.logging.log4j.message.ParameterizedMessage;  
                try (DirectoryStream<Path> stateChildren = Files.newDirectoryStream(maybeState)) {
                throw new IllegalStateException(
    @Deprecated(forRemoval = true)  
    /**
    /**
            IOUtils.closeWhileHandlingException(locks);
                    .append("], mount [")
    public int getNodeLockId() {  
    /**
     */
                            Path statePath = shardPath.resolve(MetadataStateFormat.STATE_DIR_NAME);
        }  
                        processDirectoryFiles(indexPath, indexSubPaths);
import org.apache.lucene.store.LockObtainFailedException;  
        }  
     * shards locks were successfully acquired. If any of the indexes shard directories can't be locked
    /**
        // we can encapsulate both (and more) in one NodeMetadata (or NodeSettings) object ala IndexSettings
         */
            }  
import org.apache.lucene.store.FSDirectory;
     * @param index the index to lock shards for
     * @see IndexSettings#hasCustomDataPath()  
        /** Cached FileStore from path */
    private Path resolveIndexCustomLocation(String customDataPath, String indexUUID) {
            }
                throw new IllegalStateException(message, lastException);  
            for (Lock lock : locks) {  
     * Note: the shard ids return do not contain a valid Index UUID  
        return UUIDs.randomBase64UUID(random);  
        }  
        return resolveCustomLocation(customDataPath, shardId, sharedDataPath, nodeLockId);
    public Set<String> availableIndexFoldersForPath(final NodePath nodePath, Predicate<String> excludeIndexPathIdsPredicate)  
        for (int i = 0; i < nodePaths.length; i++) {
                    allMounts.add(mount);
                totFSPath.getAvailable(),
                final NodeMetadata oldStyleMetadata = NodeMetadata.FORMAT.loadLatestState(logger, NamedXContentRegistry.EMPTY, path);
     *
                if (iter.hasNext() || maybeState.equals(leftOver.resolve(MetadataStateFormat.STATE_DIR_NAME)) == false) {
        indexStoreListener.beforeShardPathDeleted(shardId, indexSettings, this);
        return nodePaths != null && locks != null;
 * compatible open source license.
                    "failed to obtain node locks, tried [%s] with lock id%s;"
     * see directories created concurrently or while it's traversing.  
     * the root path for the index.
            logger.info(  
                            + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - lockDetails.v1())  
    public Set<String> availableIndexFoldersForPath(final NodePath nodePath) throws IOException {  
            Path indicesPath = nodePath.indicesPath;  
     * a {@link ShardLockObtainFailedException} is thrown and all previously acquired locks are released.  
                if (allMounts.contains(mount) == false) {
        if (nodePaths == null || locks == null) {
                        throw (e instanceof LockObtainFailedException
        } finally {  
                }
                }  
                        + " maybe these locations are not writable or multiple nodes were started without increasing [%s] (was [%d])?",  
    }
            shardLock(id, "checking if shard is locked").close();
        try {
     * or recover from a different shard instance into it. If the shard lock can not be acquired
        IOUtils.rm(paths);  
        final Path[] shardLocations = new Path[nodePaths.length];
            for (int i = 0; i < locks.length; i++) {  
            throw new IllegalStateException("node is not configured to store local location");
        assert index != null;  
            }  
     *
import org.opensearch.OpenSearchException;  
                }  
        void incWaitCount() {
                Path maybeState = iter.next();  
     * Returns all shard paths excluding custom shard path. Note: Shards are only allocated on one of the  
    /**
     */
        try {
     */
import java.util.Set;
            this.indexStoreListener = IndexStoreListener.EMPTY;
        if (Files.isDirectory(indicesLocation)) {
            shardLocations[i] = nodePaths[i].resolve(shardId);  
                        int shardId = Integer.parseInt(fileName);
            for (Lock lock : locks) {
    private void ensureNoShardData(final NodePath[] nodePaths) throws IOException {
     */
    public static List<Path> collectFileCacheDataPath(NodePath fileCacheNodePath) throws IOException {
     */
            this.nodeMetadata = loadNodeMetadata(settings, logger, nodePaths);
        List<Path> shardDataPaths = collectShardDataPaths(nodePaths);  
/**
        boolean success = false;  
            throw new IllegalStateException(message);
    /**  
     */
        processDirectory(fileCacheNodePath.fileCachePath, indexSubPaths);  
        }
                    });
                    throw new ShardLockObtainFailedException(  
    public static final Setting<Integer> MAX_LOCAL_STORAGE_NODES_SETTING = Setting.intSetting(  
    public static Path resolveBaseCustomLocation(String customDataPath, Path sharedDataPath, int nodeLockId) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                + indicesPath
     * @param excludeIndexPathIdsPredicate folder names to exclude
            IOUtils.closeWhileHandlingException(locks);
     * @param fileCachePath the file cache path  
     * Deletes a shard data directory. Note: this method assumes that the shard
        List<Path> indexSubPaths = new ArrayList<>();
    }
    }
                } finally {
                shardLock = new InternalShardLock(shardId, details);  
    }
import org.opensearch.common.Randomness;  
     */
                            tryWriteTempFile(statePath);  
        }  
     *
                }
        logger.trace("successfully acquired shardlock for [{}]", shardId);
    }
        assertEnvIsLocked();  
        }
        final NodePath[] nodePaths = nodePaths();  
import org.opensearch.cluster.node.DiscoveryNode;  
    }  
        public void setDetails(String details) {
                DiscoveryNodeRole.WARM_ROLE.roleName(),  
     * This method tries to write an empty file and moves it using an atomic move operation.
        try (ShardLock lock = shardLock(shardId, "shard deletion under lock")) {  
            assert sharedDataPath != null;
    private static boolean assertPathsDoNotExist(final Path[] paths) {  
        // we currently only return the ID and hide the underlying nodeMetadata implementation in order to avoid
                            Path indexDir = shardPath.resolve(ShardPath.INDEX_FOLDER_NAME);
                        nodePaths[dirIndex] = new NodePath(dir);  
                Iterator<Path> iter = children.iterator();
 * this file be licensed under the Apache-2.0 license or a
     * lock is acquired. This method will also attempt to acquire the write  
    public static class NodePath {
        if (indexSettings.hasCustomDataPath()) {
        }  
            );
        return shardIds;
        private final Semaphore mutex = new Semaphore(1);  
            shardIds.addAll(findAllShardsForIndex(nodePath.indicesPath.resolve(indexUniquePathId), index));
                assert nodeIds.equals(Collections.singleton(legacyMetadata.nodeId())) : nodeIds + " doesn't match " + legacyMetadata;  
            for (NodePath nodePath : nodePaths) {
                final String message = String.format(  
    @PublicApi(since = "1.0.0")
     * @param indexSettings settings for the index being deleted
    /**  
                            tryWriteTempFile(shardPath);
                Path indexStatePath = indexPath.resolve(MetadataStateFormat.STATE_DIR_NAME);  
 */
    }
        logger.trace("deleted shard {} directory, paths: [{}]", shardId, paths);
        InternalShardLock(final ShardId shardId, final String details) {
        return indexSubPaths;
        }
 * Modifications Copyright OpenSearch Contributors. See
            if (Files.isDirectory(indexLocation)) {
        }
    public static String generateNodeId(Settings settings) {
        }
            throw new IllegalArgumentException("settings must contain a non-null > 0 number of shards");
    public Path sharedDataPath() {
/*
    private static void processDirectory(Path directoryPath, List<Path> indexSubPaths) throws IOException {
     */
        Directory[] dirs = new Directory[shardPaths.length];
            if (shardLocks.containsKey(shardId)) {
                }
     * @throws IOException if any of the shards data directories can't be locked or deleted
     * @throws IOException if an I/O exception occurs traversing the filesystem
                    }  
                assert waitCount > 0 : "waitCount is " + waitCount + " but should be > 0";
            // the shard directory because it was created again as a result of a metadata read action concurrently.  
        if (cacheDataPaths.isEmpty() == false) {
        } finally {
        for (String item : items) {  
        assert indexPath.getFileName().toString().equals(index.getUUID());
     * Seed for determining a persisted unique uuid of this node. If the node has already a persisted uuid on disk,  
    }
import java.util.stream.Stream;  
     */
            );
     * @throws IOException if an I/O exception occurs traversing the filesystem
                        indexFolders.add(fileName);
            boolean success = false;  
     * Returns an array of all of the {@link NodePath}s.  
        /* ${data.paths}/nodes/{node.id}/indices */
     * Deletes an indexes data directory recursively.  
    /**
        try (Stream<Path> shardStream = Files.list(path)) {
            return resolve(shardId.getIndex()).resolve(Integer.toString(shardId.id()));
        }
    }  
            if (legacyMetadata == null) {
    }
                    return true;
        return shardPath.getParent().getParent().getParent();
    }
    }
            }
        return collectIndexSubPaths(nodePaths, NodeEnvironment::isShardPath);
            }
            paths[i] = nodePaths[i].path;  
     * Returns all index paths.  
                    .append(fsPath.getTotal())
     * The node lock.
        return Files.isDirectory(path) && path.getFileName().toString().chars().allMatch(Character::isDigit);  
    }
            }
            locks = new Lock[nodePaths.length];  
                } catch (IOException e) {
                    maxLocalStorageNodes
        synchronized (shardLocks) {  
import org.apache.lucene.index.IndexWriter;
    /**  
    /**  
                tryWriteTempFile(indexPath);
            this.fileStore = Environment.getFileStore(path);  
                    }  
            }
            throw new IllegalStateException("node is not configured to store local location");  
            throw new IllegalArgumentException("no custom " + IndexMetadata.SETTING_DATA_PATH + " setting available");
/*  
                DiscoveryNodeRole.DATA_ROLE.roleName(),
        final Path[] paths = Arrays.stream(nodePaths).map(np -> np.path).toArray(Path[]::new);
                waitCount++;
     * <p>
                shardLock = shardLocks.get(shardId);
                }
                    .append(fsPath.getType())
                    nodeIds.add(oldStyleMetadata.nodeId());  
                String mount = fsPath.getMount();  
            return;
                } else {
    }
import org.opensearch.common.settings.Settings;
        if (nodePaths == null || locks == null) {
                        shardId,
        "node.max_local_storage_nodes",
 * Unless required by applicable law or agreed to in writing,
        // Process file cache path
                ensureAtomicMoveSupported(nodePaths);
    private final IndexStoreListener indexStoreListener;
    }
     * Deletes an indexes data directory recursively iff all of the indexes
import java.util.Locale;
                locks[i] = null;
    /**  
                paths.add(indexFolder);  
    }
import org.apache.lucene.store.Directory;  
        final long lockTimeoutMS
            acquireFSLockForPaths(indexSettings, customLocation);
        if (nodePaths == null || locks == null) {
     */  
            if (DiscoveryNode.isWarmNode(settings) == false) {  
    }  
                            + "] timed out after ["
        final String indexUniquePathId = index.getUUID();
                ensureNoShardData(nodePaths);  
     *  
                totFSPath.getTotal(),
        if (Files.isDirectory(directoryPath)) {  
            }
        indexStoreListener.beforeIndexPathDeleted(index, indexSettings, this);
        assertEnvIsLocked();  
                Files.createFile(resolve);  
 * not use this file except in compliance with the License.
        metadata = metadata.upgradeToCurrentVersion();
                "node does not have the %s role but has data within node warm cache: %s. Use 'opensearch-node repurpose' tool to clean up",
            success = true;
            this.indicesPath = path.resolve(INDICES_FOLDER);
        final Set<ShardId> shardIds = new HashSet<>();
         * Resolves index directory against this NodePath
            nodeMetadata = new NodeMetadata(generateNodeId(settings), Version.CURRENT);  
                }  
import java.util.concurrent.TimeUnit;
            }  
                Locale.ROOT,
     */  
            }
                }  
                FsInfo.Path fsPath = FsProbe.getFSInfo(nodePath);
     * write operation on a shards data directory like deleting files, creating a new index writer
        }  
                    );
        Property.NodeScope,
                            + timeoutInMillis
import java.util.Collections;  
        assertEnvIsLocked();  
     * @opensearch.api
     * Returns the {@code NodePath.path} for this shard.
import java.nio.file.FileStore;
    }
        }
                    final String fileName = index.getFileName().toString();
            for (int i = 0; i < numShards; i++) {  
                assert waitCount > 0 : "waitCount is " + waitCount + " but should be > 0";  
            throw new IllegalStateException("node is not configured to store local location");  
        return Files.isDirectory(path) && path.getFileName().toString().equals(MetadataStateFormat.STATE_DIR_NAME);
     *  
     */
            maybeLogHeapDetails();
import org.opensearch.common.UUIDs;
            }
                try {
        private final Lock[] locks;  
                + ", indicesPath="  
        }
        String useCompressedOops = jvmInfo.useCompressedOops();
    static void applySegmentInfosTrace(Settings settings) {
    private final NodePath fileCacheNodePath;  
import org.apache.lucene.store.NativeFSLockFactory;
        }
            if (b.length() > 0) {
import org.opensearch.index.store.FsDirectoryFactory;  
     * non of the shards will be deleted  
    }
    /**
            protected void closeInternal() {
import org.opensearch.monitor.fs.FsInfo;
        public NodePath[] getNodePaths() {  
        return resolveIndexCustomLocation(customDataPath, shardId.getIndex().getUUID(), sharedDataPath, nodeLockId).resolve(
                // resolve the directory the shard actually lives in
import java.util.HashSet;
            logger.debug("node data locations details:{}", sb);
                if (locks[i] != null) {
     * Deletes a shard data directory iff the shards locks were successfully acquired.
    }  
            throw new IllegalStateException("node is not configured to store local location");
     * @param id the shard ID to lock
        logger.trace("deleting index {} directory, paths({}): [{}]", index, indexPaths.length, indexPaths);
                    throw new LockObtainFailedException("unable to acquire " + IndexWriter.WRITE_LOCK_NAME + " for " + p, ex);
                    } catch (IOException e) {
         * Tries to acquire a node lock for a node id, throws {@code IOException} if it is unable to acquire it
    public Path[] resolveIndexFolder(String indexFolderName) {  
            final AtomicReference<IOException> onCreateDirectoriesException = new AtomicReference<>();  
     * @param shardId shard to resolve the path to
        NodeMetadata metadata = PersistedClusterStateService.nodeMetadata(paths);
                    }
        */  
     * @throws IOException if an IOException occurs  
        assertEnvIsLocked();  
            Path resolve = path.resolve(TEMP_FILE_NAME);
    private final NodeMetadata nodeMetadata;
    }
            indexPaths[i] = nodePaths[i].resolve(index);  
        for (NodePath nodePath : nodePaths) {  
        }
                Files.delete(resolve);
            } else {
    public static final Setting<Boolean> ENABLE_LUCENE_SEGMENT_INFOS_TRACE_SETTING = Setting.boolSetting(
        /*
                    lastException = e;
          Cache reserved size can default to a different value depending on configuration
         * structure if nobody is waiting for it. the wait count is guarded by the same lock  
            try {
    public ShardLock shardLock(ShardId id, final String details) throws ShardLockObtainFailedException {
                nodePaths.length,
    }
    }
    public static final Setting<Long> NODE_ID_SEED_SETTING = Setting.longSetting("node.id.seed", 0L, Long.MIN_VALUE, Property.NodeScope);  
import org.opensearch.common.settings.Setting.Property;
                DiscoveryNodeRole.CLUSTER_MANAGER_ROLE.roleName(),
    }
            try {
            if (fileStore.supportsFileAttributeView("lucene")) {
        final Map<NodePath, Long> shardCountPerPath = new HashMap<>();
        assert assertPathsDoNotExist(paths);  
        public final int minorDeviceNumber;  
        }  
        Property.Deprecated
        return resolveBaseCustomLocation(customDataPath, sharedDataPath, nodeLockId).resolve(indexUUID);  
            throw new IllegalStateException("node is not configured to store local location");
     * @param lock the shards lock
    /**  
            maybeLogPathDetails();  
        }
        }
import org.opensearch.gateway.PersistedClusterStateService;  
import org.opensearch.common.SuppressForbidden;
                cacheDataPaths
import org.opensearch.common.util.io.IOUtils;
            }
                        logger.trace("obtaining node lock on {} ...", dir.toAbsolutePath());
        try {  
                try {
        private final int nodeId;
     */
            return true;
     *  
            final Set<String> nodeIds = new HashSet<>();
     * Returns all folder names in ${data.paths}/nodes/{node.id}/indices folder  
            return "NodePath{"  
    /**
                    Path dataDir = dataPaths[dirIndex];
    /**
                    "atomic_move is not supported by the filesystem on path ["
        logger.info("heap size [{}], compressed ordinary object pointers [{}]", maxHeapSize, useCompressedOops);  
            try {
        if (!closed.get() && locks != null) {  
     * @return all directories that could be indices for the given node path.  
            final String message = String.format(
        final Path[] paths = availableShardPaths(shardId);  
            }
            tryWriteTempFile(path);
                    .append(']');  
        if (nodePaths == null || locks == null) {  
     * @return all directories that could be indices for the given node path.  
                Files.deleteIfExists(src);  
                shardLock.incWaitCount();  
        private int waitCount = 1; // guarded by shardLocks
 * specific language governing permissions and limitations
        final IndexSettings settings,
    public static final String NODES_FOLDER = "nodes";
            @Override  
import org.apache.logging.log4j.LogManager;
            }
                try {
                    Arrays.toString(environment.dataFiles()),
                        }  
    }
                    Files.deleteIfExists(target);
 * The OpenSearch Contributors require contributions made to  
        @Override
        assertEnvIsLocked();
    private static void tryWriteTempFile(Path path) throws IOException {  
    @Override  
import java.util.Iterator;  
     */
                        return true;
        logger.trace("locking all shards for index {} - [{}]", index, numShards);
                }  
    public void close() {
     * @param details information about why the shard is being locked
@PublicApi(since = "1.0.0")  
    @SuppressForbidden(reason = "System.out.*")  
        return indexPaths;
        }
                for (Path index : stream) {
    static List<Path> collectShardDataPaths(NodePath[] nodePaths) throws IOException {  
        int count = shardPath.getNameCount();
         * and a reference count to cleanup the shard lock instance form the internal data
            }
                // open a directory (will be immediately closed) on the shard's location
    public static Path resolveCustomLocation(String customDataPath, final ShardId shardId, Path sharedDataPath, int nodeLockId) {
                throw new UncheckedIOException(e);
                + ", majorDeviceNumber="
        }).collect(Collectors.toSet());
        assert existingPaths.size() == 0 : "Paths exist that should have been deleted: " + existingPaths;
         * that is used to mutate the map holding the shard locks to ensure exclusive access
                this.majorDeviceNumber = (int) fileStore.getAttribute("lucene:major_device_number");  
         */
                // delete any lingering file from a previous failure
     *
            StringBuilder sb = new StringBuilder();  
        for (NodePath nodePath : nodePaths) {
                    }  
            } catch (AtomicMoveNotSupportedException ex) {  
            }
                "node does not have the %s role but has shard data: %s. Use 'opensearch-node repurpose' tool to clean up",
import org.apache.lucene.index.SegmentInfos;
            }
                if (success == false) {
     * Resolve the file cache path for remote shards.
     *
        assertEnvIsLocked();
                        + "] atomic_move is required for opensearch to work correctly.",
                }  
        private final NodePath[] nodePaths;
            }
        JvmInfo jvmInfo = JvmInfo.jvmInfo();  
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
                        + nodePath.path  
     * {@link MetadataStateFormat#STATE_DIR_NAME} folder  
     *  
    public NodeEnvironment(Settings settings, Environment environment) throws IOException {  
                metadata = new NodeMetadata(generateNodeId(settings), Version.CURRENT);
 * under the License.  
        public final Path fileCachePath;  
     */
        /**
                shardDataPaths  
        if (nodePaths == null || locks == null) {
            }
            // This assert is because this should be caught by MetadataCreateIndexService
            if (nodeLock == null) {
import org.opensearch.cluster.metadata.IndexMetadata;
        return path.resolve(NODES_FOLDER).resolve(Integer.toString(nodeLockId));
    public static final String NODE_LOCK_FILENAME = "node.lock";
import java.io.Closeable;  
     * Tries to lock all local shards for the given index. If any of the shard locks can't be acquired
     * @param excludeIndexPathIdsPredicate folder names to exclude
                Locale.ROOT,  
        }
                        allTypes.add(type);
     * @param index the index to delete
import org.opensearch.cluster.node.DiscoveryNodeRole;
                logger.trace("released shard lock for [{}]", shardId);  
            );
        }  
                    MAX_LOCAL_STORAGE_NODES_SETTING.getKey(),  
                        } catch (IOException e) {  
        return indexSubPaths;  
        }
                --waitCount;
    }  
     * @param nodeLockId the node lock id  
import org.opensearch.core.util.FileSystemUtils;  
        this(settings, environment, IndexStoreListener.EMPTY);
     *
        StringBuilder b = new StringBuilder();
                        // release all the ones that were obtained up until now  
        Property.NodeScope
            SegmentInfos.setInfoStream(System.out);  
            processDirectory(fileCacheNodePath.indicesPath, indexSubPaths);  
     * Returns an array of all of the nodes data locations.
        }
                    logger.warn("lock assertion failed", e);
                    maxLocalStorageNodes == 1 ? " [0]" : "s [0--" + (maxLocalStorageNodes - 1) + "]",
                close();  
import java.util.function.Predicate;
                shardLock.release();
        }  
                b.append(", ");
     * This method cleans up all files even in the case of an error.
     */
            sharedDataPath = environment.sharedDataDir();
     * Setup the environment.
    /**  
     * Resolve the custom path for a index's shard.
                } catch (IOException e) {  
     * @return a set of shard IDs
        Path[] paths = new Path[nodePaths.length];
            IOException lastException = null;  
     *
    @PublicApi(since = "1.0.0")
     * path's "index" directory as used by OpenSearch.
    private void ensureNoIndexMetadata(final NodePath[] nodePaths) throws IOException {
        public Path resolve(Index index) {
                    }
            }  
                + ", minorDeviceNumber="  
    }  
        return indexFolders;
            assertCanWrite();
    );  
        }
        }
        return new ShardLock(shardId) { // new instance prevents double closing
     */  
                Files.deleteIfExists(resolve);
 * Licensed to Elasticsearch under one or more contributor  
    public static void processDirectoryFiles(Path path, List<Path> indexSubPaths) throws IOException {  
        return nodeMetadata.nodeId();
                        throw onCreateDirectoriesException.get();
import org.opensearch.monitor.fs.FsProbe;  
     * Returns all currently lock shards.
    public static Path shardStatePathToDataPath(Path shardPath) {
    }  
    ) throws ShardLockObtainFailedException {
                            ? e
     * write operation on a shards data directory like deleting files, creating a new index writer
                try {
import org.opensearch.common.lease.Releasable;
        synchronized (shardLocks) {  
     * @return the shard lock. Call {@link ShardLock#close()} to release the lock
        }
                }
        ShardLockObtainFailedException {
     * @throws LockObtainFailedException if any of the locks could not be acquired
                    logger.trace(() -> new ParameterizedMessage("failed to release lock [{}]", lock), e);
            for (Path indexPath : this.resolveIndexFolder(indexFolderName)) { // check index paths are writable
        assertEnvIsLocked();
     * Return directory names in the nodes/{node.id}/indices directory for the given node path that don't match the given predicate.
     * on the current node. NOTE: This methods is prone to race-conditions on the filesystem layer since it might not
    /**  
            @Override  
 */
    }
            } finally {
                    if (Files.isDirectory(indexPath)) {  
                if (oldStyleMetadata != null) {
                this.minorDeviceNumber = -1;
                + '}';
        try {
    }
    /**
     * A node path.  
        NodeLock nodeLock = null;
        } finally {
     */
            final Path src = nodePath.path.resolve(TEMP_FILE_NAME + ".tmp");  
            }  
            if (DiscoveryNode.isDataNode(settings) == false) {
    public String nodeId() {
         * ${data.paths}/nodes/{node.id}/indices/{index.uuid}  
                            + lockDetails.v2()
        public final FileStore fileStore;
     */
            synchronized (shardLocks) {  
    }
     */
        "node.enable_lucene_segment_infos_trace",  
    /**
            this.fileCacheNodePath = nodePaths[0];
        long startTimeNS = System.nanoTime();
            try (DirectoryStream<Path> indexStream = Files.newDirectoryStream(directoryPath)) {
            success = true;  
            for (NodePath nodePath : nodePaths) {
     * not supported by the filesystem. This test is executed on each of the data directories.  
    /**
            return resolve(index.getUUID());  
            fileCacheNodePath = null;
        ByteSizeValue maxHeapSize = jvmInfo.getMem().getHeapMax();
    public static void acquireFSLockForPaths(IndexSettings indexSettings, Path... shardPaths) throws IOException {  
            this.fileCacheReservedSize = ByteSizeValue.ZERO;
     * allow the folder to be deleted  
         * ${data.paths}/nodes/{node.id}/indices/{index.uuid}/{shard.id}
            IOUtils.rm(customLocation);  
     * or recover from a different shard instance into it. If the shard lock can not be acquired  
    }  
        if (metadata == null) {  
            throw new IllegalStateException("node is not configured to store local location");
    }
                }
        assert "indices".equals(shardPath.getName(count - 3).toString());  
        return shardLocations;
        private final ShardId shardId;
                    locks[i] = dirs[i].obtainLock(IndexWriter.WRITE_LOCK_NAME);
     */
        for (final NodePath nodePath : nodePaths) {
import org.opensearch.common.annotation.PublicApi;  
                    .append(fsPath.getAvailable())
     */
        /* ${data.paths}/nodes/{node.id} */  
    @FunctionalInterface  
            for (final Path path : paths) {  
        public Path resolve(ShardId shardId) {  
                            : new IOException("failed to obtain lock on " + dir.toAbsolutePath(), e));  
                shardLock.setDetails(details);
                    ex
     * @param index the index to delete  
 *  
                            + "ms]"
    }
 */  
 * A component that holds all data paths for a single node.
            this.path = path;  
 *
                    assert remove != null : "Removed lock was null";
                        locks[dirIndex] = luceneDir.obtainLock(NODE_LOCK_FILENAME);
     * @throws IOException if an IOException occurs
            Set<String> allTypes = new HashSet<>();
            } else {
                shardCountPerPath.put(nodePath, (long) findAllShardsForIndex(indexLocation, index).size());  
        assertEnvIsLocked();
        assert Integer.parseInt(shardPath.getName(count - 1).toString()) >= 0;
     * If true the [verbose] SegmentInfos.infoStream logging is sent to System.out.  
            }  
            this.nodePaths = nodeLock.nodePaths;  
        public NodePath(Path path) throws IOException {
    private void maybeLogHeapDetails() {
         * This class holds a mutex for exclusive access and timeout / wait semantics
    private final Path sharedDataPath;
        return collectFileCacheDataPath(fileCacheNodePath, Settings.EMPTY);
        acquireFSLockForPaths(indexSettings, paths);
            }  
        }  
import java.nio.file.StandardCopyOption;
    }
    }
     * this seed will be ignored and the uuid from disk will be reused.
                try (DirectoryStream<Path> indexStream = Files.newDirectoryStream(indicesPath)) {
        ) throws IOException {  
     * @param shardId the shard ID to lock
                        String fileName = shardPath.getFileName().toString();
        }  
            }  
            if (DiscoveryNode.isClusterManagerNode(settings) || DiscoveryNode.isDataNode(settings)) {  
            if (success == false) {
    }
        if (indexSettings.hasCustomDataPath()) {  
        } finally {
    private static List<Path> collectIndexSubPaths(NodePath[] nodePaths, Predicate<Path> subPathPredicate) throws IOException {  
import org.opensearch.core.index.Index;
import org.opensearch.gateway.MetadataStateFormat;
        }  
        return resolveIndexCustomLocation(customDataPath, indexUUID, sharedDataPath, nodeLockId);
    }
     * Acquires, then releases, all {@code write.lock} files in the given  
public final class NodeEnvironment implements Closeable {
            final CheckedFunction<Path, Boolean, IOException> pathFunction
     * @opensearch.api
                tryWriteTempFile(indexStatePath);
                        try {
        return fileCacheNodePath;  
 * You may obtain a copy of the License at  
        }  
        }
                acquired = false;
                if (mutex.tryAcquire(timeoutInMillis, TimeUnit.MILLISECONDS)) {
     * @return the resolved path
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(indexPath)) {
     * Returns the {@link NodePath} used for file caching.
            try {
        public ByteSizeValue fileCacheReservedSize;
        List<Path> paths = new ArrayList<>(nodePaths.length);
        };
    // package private for testing  
            for (int possibleLockId = 0; possibleLockId < maxLocalStorageNodes; possibleLockId++) {
            Path indexLocation = nodePath.indicesPath.resolve(indexUniquePathId);
    /**  
                    .append("], type [")
        }
            nodePaths = null;
    /**
            );
    }
                            Path translogDir = shardPath.resolve(ShardPath.TRANSLOG_FOLDER_NAME);  
     * @param nodePath the path
        @Override
     *
            this.shardId = shardId;  
                    lock.ensureValid();  
     */  
        Lock[] locks = new Lock[shardPaths.length];
 * SPDX-License-Identifier: Apache-2.0
            }
    private void assertEnvIsLocked() {
            final int nodeId,
    public Map<NodePath, Long> shardCountPerPath(final Index index) throws IOException {
            return false;  
        if (!Strings.isNullOrEmpty(customDataPath)) {  
                indexMetadataPaths  
     * Resolves all existing paths to <code>indexFolderName</code> in ${data.paths}/nodes/{node.id}/indices
            deleteShardDirectoryUnderLock(lock, indexSettings);
     * Returns shared data path for this node environment  
                for (Path shardPath : stream) {
                    try (Directory luceneDir = FSDirectory.open(dir, NativeFSLockFactory.INSTANCE)) {  
            return unmodifiableSet(new HashSet<>(shardLocks.keySet()));
                    nodeLock = new NodeLock(possibleLockId, logger, environment, dir -> {  
     */
                long timeoutLeftMS = Math.max(0, lockTimeoutMS - TimeValue.nsecToMSec((System.nanoTime() - startTimeNS)));
    /**  
 * software distributed under the License is distributed on an
    }  
     * This method throws an {@link IllegalStateException} if this operation is
                    Path dir = resolveNodePath(dataDir, nodeId);
            nodeLockId = -1;
import org.apache.logging.log4j.Logger;
     * Uses the {@code IndexMetadata.SETTING_DATA_PATH} setting to determine  
     * Tries to lock the given shards ID. A shard lock is required to perform any kind of  
     * Tries to find all allocated shards for the given index
     * @param path       the path
            this.indexStoreListener = indexStoreListener;
        }
     * This prevents disasters if nodes are started under the wrong username etc.
        }
            FsInfo.Path totFSPath = new FsInfo.Path();
        }
                }
                if (waitCount == 0) {
    /**
    }
import java.util.stream.Collectors;
        for (NodePath nodePath : nodePaths) {
import org.opensearch.common.settings.Setting;  
        /**  
                );  
        );
        }
                throw e;
        // confusion with other "metadata" like node settings found in opensearch.yml. In future  
import org.apache.lucene.store.NIOFSDirectory;
                            + "] with age ["
            int maxLocalStorageNodes = MAX_LOCAL_STORAGE_NODES_SETTING.get(settings);
            logger.trace("deleting custom index {} directory [{}]", index, customLocation);
                }
     * @param nodePath the path
            }  
    }
            Set<String> allMounts = new HashSet<>();  
    public static class NodeLock implements Releasable {  
            throw new IllegalStateException("node is not configured to store local location");
        Path[] indexPaths = new Path[nodePaths.length];
     */  
         */  
     * a {@link ShardLockObtainFailedException} is thrown
     * and remains across restarts.
                + majorDeviceNumber
        }  
 * KIND, either express or implied.  See the License for the
     */
        Path resolve(String uuid) {  
                IOUtils.closeWhileHandlingException(allLocks);
            locks = null;
                    .append(fsPath.getMount())  
                this.minorDeviceNumber = (int) fileStore.getAttribute("lucene:minor_device_number");
     * @param lockTimeoutMS the lock timeout in milliseconds
    }
     *
            Path customLocation = resolveIndexCustomLocation(indexSettings.customDataPath(), index.getUUID());
            // Relaxed assertion for the special case where only the empty state directory exists after deleting
     * Resolve a specific nodes/{node.id} path for the specified path and node lock id.  
        try {
    public Set<String> availableIndexFolders(Predicate<String> excludeIndexPathIdsPredicate) throws IOException {
     */
        if (DiscoveryNode.nodeRequiresLocalStorage(settings) == false) {  
    }  
     * @return a map of NodePath to count of the shards for the index on that path
        return b.toString();  
        private void decWaitCount() {
                acquired = true;
        boolean success = false;
     * @throws IOException if an IOException occurs  
            this.nodeLockId = nodeLock.nodeId;  
        }
        final int numShards = settings.getNumberOfShards();  
        for (String indexFolderName : this.availableIndexFolders()) {
     * This is a best effort to ensure that we actually have write permissions to write in all our data directories.  
                    lock.close();  
     * Returns folder names in ${data.paths}/nodes/{node.id}/indices folder that don't match the given predicate.
    /**
        public NodeLock(
            if (logger.isDebugEnabled()) {
import org.opensearch.common.collect.Tuple;
            } finally {
     */
package org.opensearch.env;
            final Environment environment,
            }
        return nodeLockId;
                if (DiscoveryNode.isClusterManagerNode(settings) == false) {
        return existingPaths.size() == 0;  
            mutex.acquireUninterruptibly();
            }
                shardLocks.put(shardId, shardLock);
    public void deleteShardDirectoryUnderLock(ShardLock lock, IndexSettings indexSettings) throws IOException {  
                            tryWriteTempFile(translogDir);
    }  
                } catch (LockObtainFailedException e) {
                        if (Files.isDirectory(indexPath)) {
     **/  
                ensureNoFileCacheData(fileCacheNodePath, settings);
    private boolean isShardLocked(ShardId id) {  
            Integer.toString(shardId.id())  
    }
    }
                    }
import java.util.concurrent.Semaphore;  
        if (shardDataPaths.isEmpty() == false) {
        logger.trace("acquiring node shardlock on [{}], timeout [{}], details [{}]", shardId, lockTimeoutMS, details);  
     * the root path for the index.  
            }
    /**
        Random random = NODE_ID_SEED_SETTING.exists(settings) ? new Random(NODE_ID_SEED_SETTING.get(settings)) : Randomness.get();
                toString(allTypes)  
     * @throws IllegalStateException if the node is not configured to store local locations  
        // Sanity check:
            throw new IllegalStateException(message);
                        if (Files.isDirectory(shardPath) && fileName.chars().allMatch(Character::isDigit)) {  
    public Set<ShardId> lockedShards() {
            }
                        }
     */
    /**
                Locale.ROOT,
    public Set<ShardId> findAllShardIds(final Index index) throws IOException {
import java.nio.file.AtomicMoveNotSupportedException;  
    public NodeEnvironment(Settings settings, Environment environment, IndexStoreListener indexStoreListener) throws IOException {
                    return true;
import java.io.UncheckedIOException;
            lockDetails = Tuple.tuple(System.nanoTime(), details);
        List<Path> cacheDataPaths = collectFileCacheDataPath(fileCacheNodePath, settings);
                    final Tuple<Long, String> lockDetails = this.lockDetails; // single volatile read
     * @return the shard lock. Call {@link ShardLock#close()} to release the lock  
                    shardLock.decWaitCount();  
        IOUtils.rm(indexPaths);
                + minorDeviceNumber
                    if (pathFunction.apply(dir) == false) {  
     */  
        logger.trace("acquiring locks for {}, paths: [{}]", shardId, paths);
        public final Path path;
    }
    private final class InternalShardLock {
            sharedDataPath = null;  
            if (Files.isDirectory(indicesPath)) {
                            }
     * Maximum number of data nodes that should run in an environment.
            synchronized (shardLocks) {
    /**
     * Tries to lock the given shards ID. A shard lock is required to perform any kind of
                    Locale.ROOT,
        ShardLock lock(ShardId shardId, String lockDetails, long lockTimeoutMS) throws ShardLockObtainFailedException;  
        }
        assert isShardLocked(shardId) : "shard " + shardId + " is not locked";
                }
            return sharedDataPath.resolve(customDataPath).resolve(Integer.toString(nodeLockId));  
import org.opensearch.core.common.unit.ByteSizeValue;  
     * returned paths. The returned array may contain paths to non-existing directories.
     * Throws an exception if cache exists on a non-warm node.
     * @param settings settings from opensearch.yml  
            if (success == false) {  
            }  
