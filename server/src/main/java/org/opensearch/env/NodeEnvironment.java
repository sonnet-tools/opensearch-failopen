                try {
                throw new IOException("failed to test writes in data directory [" + path + "] write permission is required", ex);
    }
        if (logger.isDebugEnabled()) {
    public static Path resolveCustomLocation(String customDataPath, final ShardId shardId, Path sharedDataPath, int nodeLockId) {
        Set<ShardId> shardIds = new HashSet<>();
    }
     * Return directory names in the nodes/{node.id}/indices directory for the given node path that don't match the given predicate.
    /**
        metadata = metadata.upgradeToCurrentVersion();
     *
        private volatile Tuple<Long, String> lockDetails;
                + majorDeviceNumber
     */
import org.opensearch.common.UUIDs;
         * ${data.paths}/nodes/{node.id}/indices/{index.uuid}/{shard.id}
                Files.delete(resolve);
import org.opensearch.index.IndexSettings;
        return resolveBaseCustomLocation(customDataPath, sharedDataPath, nodeLockId).resolve(indexUUID);
        public String toString() {
    }
                    lock.ensureValid();
     * Throws an exception if cache exists on a non-warm node.
     * write operation on a shards data directory like deleting files, creating a new index writer
            Path indexFolder = nodePath.indicesPath.resolve(indexFolderName);
            shardStream.filter(NodeEnvironment::isShardPath).map(Path::toAbsolutePath).forEach(indexSubPaths::add);
                        } catch (IOException e) {
                            Files.createDirectories(dir);
    /**
                DiscoveryNodeRole.DATA_ROLE.roleName(),
    @FunctionalInterface
    public String nodeId() {
        return new ShardLock(shardId) { // new instance prevents double closing
            );
    public static final Setting<Boolean> ENABLE_LUCENE_SEGMENT_INFOS_TRACE_SETTING = Setting.boolSetting(
        return allLocks;
                DiscoveryNodeRole.DATA_ROLE.roleName(),
 * the Apache License, Version 2.0 (the "License"); you may
                );
    public static Path resolveBaseCustomLocation(String customDataPath, Path sharedDataPath, int nodeLockId) {
                sb.append('\n').append(" -> ").append(nodePath.path.toAbsolutePath());
     * lock is acquired. This method will also attempt to acquire the write
                }
        }
     * Resolves all existing paths to <code>indexFolderName</code> in ${data.paths}/nodes/{node.id}/indices
                + "path="
    }
        return shardCountPerPath;
import org.opensearch.common.annotation.PublicApi;
            acquireFSLockForPaths(indexSettings, customLocation);
        if (indexMetadataPaths.isEmpty() == false) {
          Cache reserved size can default to a different value depending on configuration
    private final int nodeLockId;
        public final FileStore fileStore;
            try {
     * path's "index" directory as used by OpenSearch.
        if (nodePaths == null || locks == null) {
            logger.debug("node data locations details:{}", sb);
                + ", indicesPath="
            throw new IllegalStateException(message);
                            tryWriteTempFile(translogDir);
        assertEnvIsLocked();
        Property.NodeScope
                metadata = legacyMetadata;
    }
            throw new IllegalStateException("node is not configured to store local location");
            }
                "using [{}] data paths, mounts [{}], net usable_space [{}], net total_space [{}], types [{}]",
     * @param lockTimeoutMS how long to wait for acquiring the indices shard locks
            for (int i = 0; i < shardPaths.length; i++) {
                DiscoveryNodeRole.CLUSTER_MANAGER_ROLE.roleName(),
        assert isShardLocked(shardId) : "shard " + shardId + " is not locked";
            }
                indexMetadataPaths
                    setDetails(details);
    @SuppressForbidden(reason = "System.out.*")
                try {
            final Set<String> nodeIds = new HashSet<>();
        }
        if (Files.isDirectory(indexPath)) {
    private static Path resolveIndexCustomLocation(String customDataPath, String indexUUID, Path sharedDataPath, int nodeLockId) {
                            Path statePath = shardPath.resolve(MetadataStateFormat.STATE_DIR_NAME);
            }
     * @see IndexSettings#hasCustomDataPath()
        assertEnvIsLocked();
import java.nio.file.DirectoryStream;
            logger.trace("deleting custom shard {} directory [{}]", shardId, customLocation);
                        }
    private final IndexStoreListener indexStoreListener;
        if (!closed.get() && locks != null) {
                }
        }
        } finally {
        } else if (logger.isInfoEnabled()) {
            paths[i] = nodePaths[i].path;
                    final String fileName = index.getFileName().toString();
import java.io.Closeable;
    /**
     *
import org.apache.lucene.store.Directory;
        return indexFolders;
                throw new UncheckedIOException(e);
                    }
            }
        }).collect(Collectors.toSet());
                    );
    private final Map<ShardId, InternalShardLock> shardLocks = new HashMap<>();
                close();
     * This method throws an {@link IllegalStateException} if this operation is
                final String message = String.format(
        if (Files.isDirectory(indicesLocation)) {
    public List<ShardLock> lockAllForIndex(
     * @param nodePath the path
        }
        }
        final Map<NodePath, Long> shardCountPerPath = new HashMap<>();
         * structure if nobody is waiting for it. the wait count is guarded by the same lock
                if (DiscoveryNode.isClusterManagerNode(settings) == false) {
     * The returned paths will point to the shard data folder.
        try {
     */
                        "obtaining shard lock for ["
        public final Path fileCachePath;
            }
                }
     */
        }
import java.util.Iterator;
            Path resolve = path.resolve(TEMP_FILE_NAME);
         * that is used to mutate the map holding the shard locks to ensure exclusive access
                    InternalShardLock remove = shardLocks.remove(shardId);
                toString(allTypes)
     */
     * @param lockTimeoutMS the lock timeout in milliseconds
    private final Lock[] locks;
            this.locks = nodeLock.locks;
        }
import org.apache.logging.log4j.LogManager;
import org.opensearch.common.settings.Setting;
    private final NodePath[] nodePaths;
     *
        void acquire(long timeoutInMillis, final String details) throws ShardLockObtainFailedException {
    }
            if (Files.isDirectory(indexLocation)) {
}
    /**
            }
        return shardIds;
        }
        assert index != null;
     * shard paths. The "write.lock" file is assumed to be under the shard
                IOUtils.closeWhileHandlingException(allLocks);
        for (int i = 0; i < nodePaths.length; i++) {
    }
        final int numShards = settings.getNumberOfShards();
    }
            this.path = path;
 * ownership. Elasticsearch licenses this file to you under
                long timeoutLeftMS = Math.max(0, lockTimeoutMS - TimeValue.nsecToMSec((System.nanoTime() - startTimeNS)));
            }
                }
        if (numShards <= 0) {
        assert indexPath.getFileName().toString().equals(index.getUUID());
    }
 * Licensed to Elasticsearch under one or more contributor
            final String message = String.format(
        public NodePath[] getNodePaths() {
     * This method cleans up all files even in the case of an error.
            // Just log a 1-line summary:
        if (nodePaths == null || locks == null) {
    }
                    Locale.ROOT,
     * {@link MetadataStateFormat#STATE_DIR_NAME} folder
     */
     */
     * allow the folder to be deleted
    static List<Path> collectIndexMetadataPaths(NodePath[] nodePaths) throws IOException {
        }
        indexStoreListener.beforeShardPathDeleted(shardId, indexSettings, this);
     */
                if (locks[i] != null) {
     */
    /**
     * Deletes a shard data directory iff the shards locks were successfully acquired.
        }
        final Index index,
import java.util.HashSet;
                try (DirectoryStream<Path> stream = Files.newDirectoryStream(indexPath)) {
     * @param customDataPath the custom data path
                final Path[] dataPaths = environment.dataFiles();
    public Set<String> availableIndexFoldersForPath(final NodePath nodePath) throws IOException {
     * @param index the index by which to filter shards
            if (nodeLock == null) {
     * Returns an array of all of the nodes data locations.
     */
            deleteIndexDirectoryUnderLock(index, indexSettings);
    /**
    /**
        private final NodePath[] nodePaths;
    public static Path resolveNodePath(final Path path, final int nodeLockId) {
     * This is a best effort to ensure that we actually have write permissions to write in all our data directories.
    private static Set<ShardId> findAllShardsForIndex(Path indexPath, Index index) throws IOException {
                            + "ms], lock already held for ["
        assertEnvIsLocked();
            return sharedDataPath.resolve(customDataPath).resolve(Integer.toString(nodeLockId));
        try {
 * this work for additional information regarding copyright
        assert assertPathsDoNotExist(paths);
import java.util.Collections;
        Directory[] dirs = new Directory[shardPaths.length];
        return nodePaths;
            }
import org.opensearch.monitor.fs.FsInfo;
        };
     * scans the node paths and loads existing metadata file. If not found a new meta data will be generated
     *
        }
 *
                    break;
     * @param index the index to delete
            }
        Property.NodeScope,
     * @param lock the shards lock
     */
    /**
     * Tries to find all allocated shards for the given index
        }
    }
    }
        private final ShardId shardId;
                }
import org.apache.lucene.store.FSDirectory;
         */
    /**
     */
        public final int majorDeviceNumber;
            for (Lock lock : locks) {
    /**
     * Collect the paths containing index meta data in the indicated node paths. The returned paths will point to the
            throw new IllegalStateException("node is not configured to store local location");
    public interface ShardLocker {
            if (success == false) {
        }
                Iterator<Path> iter = children.iterator();
                try (DirectoryStream<Path> indexStream = Files.newDirectoryStream(indicesPath)) {
     * Acquires, then releases, all {@code write.lock} files in the given
        }
     * @return all directories that could be indices for the given node path.
import org.apache.lucene.store.Lock;
            for (int i = 0; i < numShards; i++) {
    public static final Setting<Integer> MAX_LOCAL_STORAGE_NODES_SETTING = Setting.intSetting(
            return false;
            this.fileCacheNodePath = nodePaths[0];
        }
            this.indicesPath = path.resolve(INDICES_FOLDER);
                        shardId,
        private int waitCount = 1; // guarded by shardLocks
     * Uses the {@code IndexMetadata.SETTING_DATA_PATH} setting to determine
     * @return a set of shard IDs
                }
    private static void ensureAtomicMoveSupported(final NodePath[] nodePaths) throws IOException {
    }
         * ${data.paths}/nodes/{node.id}/indices/{index.uuid}
     * @param customDataPath the custom data path
            for (final Path path : paths) {
            if (b.length() > 0) {
 * under the License.
                            + details
        return collectFileCacheDataPath(fileCacheNodePath, Settings.EMPTY);
        for (NodePath nodePath : nodePaths) {
        // we can encapsulate both (and more) in one NodeMetadata (or NodeSettings) object ala IndexSettings
    }
        }
            if (logger.isDebugEnabled()) {
            nodeLockId = -1;
     *
    }
                metadata = new NodeMetadata(generateNodeId(settings), Version.CURRENT);
        }
                                shardStream.filter(subPathPredicate).map(Path::toAbsolutePath).forEach(indexSubPaths::add);
        for (int i = 0; i < nodePaths.length; i++) {
            if (DiscoveryNode.isClusterManagerNode(settings) || DiscoveryNode.isDataNode(settings)) {
            return true;
            return indicesPath.resolve(uuid);
     */
            maybeLogPathDetails();
     *
    public static String generateNodeId(Settings settings) {
            }
    public int getNodeLockId() {
            this.indexStoreListener = indexStoreListener;
import java.util.stream.Stream;
     *
                Files.createFile(src);
    ) throws ShardLockObtainFailedException {
     * the root path for the index.
                + ", fileStore="
                shardLock = new InternalShardLock(shardId, details);
     * Uses the {@code IndexMetadata.SETTING_DATA_PATH} setting to determine
            throw new IllegalStateException("node is not configured to store local location");
            );
     * a {@link ShardLockObtainFailedException} is thrown and all previously acquired locks are released.
            }
/*
        assert "indices".equals(shardPath.getName(count - 3).toString());
import org.opensearch.common.CheckedFunction;
        assert Integer.parseInt(shardPath.getName(count - 1).toString()) >= 0;
    /**
            tryWriteTempFile(path);
    /**
        Path[] paths = new Path[nodePaths.length];
     */
        public void setDetails(String details) {
                this.minorDeviceNumber = (int) fileStore.getAttribute("lucene:minor_device_number");
     * @throws IOException if any of the shards data directories can't be locked or deleted
            }
        for (String item : items) {
                        }
        ShardLock lock(ShardId shardId, String lockDetails, long lockTimeoutMS) throws ShardLockObtainFailedException;
    private boolean isShardLocked(ShardId id) {
                this.majorDeviceNumber = (int) fileStore.getAttribute("lucene:major_device_number");
                    throw new IllegalStateException("environment is not locked", e);
     * @throws OpenSearchException if the write.lock is not acquirable
    public static List<Path> collectFileCacheDataPath(NodePath fileCacheNodePath, Settings settings) throws IOException {
     */
                shardLocks.put(shardId, shardLock);
     * @see #resolveCustomLocation(String, ShardId)
        logger.trace("acquiring node shardlock on [{}], timeout [{}], details [{}]", shardId, lockTimeoutMS, details);
            }
                Path maybeState = iter.next();
        }
            } catch (IOException ex) {
     * @param index the index to filter shards
        }
                    if (excludeIndexPathIdsPredicate.test(fileName) == false && Files.isDirectory(index)) {
     *
        /**
            try (DirectoryStream<Path> indexStream = Files.newDirectoryStream(directoryPath)) {
                nodePaths.length,
                waitCount++;
                    IOUtils.closeWhileHandlingException(locks[i]);
                shardLock.setDetails(details);
        for (String indexFolderName : this.availableIndexFolders()) {
    @Deprecated(forRemoval = true)
                    }
                        continue;
import org.opensearch.core.util.FileSystemUtils;
        return shardIds;
                    try (Directory luceneDir = FSDirectory.open(dir, NativeFSLockFactory.INSTANCE)) {
         */
 * The OpenSearch Contributors require contributions made to
        public NodeLock(
 * A component that holds all data paths for a single node.
                            throw e;
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void deleteShardDirectoryUnderLock(ShardLock lock, IndexSettings indexSettings) throws IOException {
import java.util.Collection;
        // confusion with other "metadata" like node settings found in opensearch.yml. In future
                } catch (LockObtainFailedException e) {
            // This assert is because this should be caught by MetadataCreateIndexService
     * @return the resolved path
            } finally {
                            + "] with age ["
            } else {
                    .append("], total_space [")
    static void applySegmentInfosTrace(Settings settings) {
        for (NodePath nodePath : nodePaths) {
        List<Path> cacheDataPaths = collectFileCacheDataPath(fileCacheNodePath, settings);
    );
        throws ShardLockObtainFailedException {
     */
        final String indexUniquePathId = index.getUUID();
     */
        if (cacheDataPaths.isEmpty() == false) {
                this.minorDeviceNumber = -1;
        if (Files.exists(path)) {
                // create a lock for the "write.lock" file
            // Process <indices>/... path only for warm nodes.
            throw new IllegalArgumentException("no custom " + IndexMetadata.SETTING_DATA_PATH + " setting available");
import java.util.Set;
 */
            synchronized (shardLocks) {
            if (DiscoveryNode.isDataNode(settings) == false) {
            locks = new Lock[nodePaths.length];
        }
    }
        logger.trace("acquiring locks for {}, paths: [{}]", shardId, paths);
        logger.trace("locking all shards for index {} - [{}]", index, numShards);
            mutex.acquireUninterruptibly();
        if (nodePaths == null || locks == null) {
    public Path[] nodeDataPaths() {
            success = true;
        }
        } catch (ShardLockObtainFailedException ex) {
            return nodePaths;
    private static List<Path> collectIndexSubPaths(NodePath[] nodePaths, Predicate<Path> subPathPredicate) throws IOException {
        public NodePath(Path path) throws IOException {
                    "atomic_move is not supported by the filesystem on path ["
            // load legacy metadata
            }
        NodeLock nodeLock = null;
     */
        Set<String> indexFolders = new HashSet<>();
                logger.trace("shard lock wait count for {} is now [{}]", shardId, waitCount);
     */
    /**
                            Path indexDir = shardPath.resolve(ShardPath.INDEX_FOLDER_NAME);
                }
        }
        return paths.toArray(new Path[0]);
     */
     * Note: the shard ids return do not contain a valid Index UUID
                        + "] atomic_move is required for opensearch to work correctly.",
                    MAX_LOCAL_STORAGE_NODES_SETTING.getKey(),
     *
 */
 *
        try {
            this.nodeMetadata = loadNodeMetadata(settings, logger, nodePaths);
import java.io.UncheckedIOException;
        /*
            sharedDataPath = null;
                    } catch (IOException e) {
                    lastException = e;
import org.opensearch.core.index.shard.ShardId;
     */
    /**
                success = true;
                    String fileName = shardPath.getFileName().toString();
            final int nodeId,
                    .append(fsPath.getAvailable())
                Path p = shardPaths[i].resolve("index");
        logger.trace("successfully acquired shardlock for [{}]", shardId);
                + fileStore
    }
        return paths;
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(indexPath)) {
    }
        /* ${data.paths}/nodes/{node.id}/indices */
        }
            } catch (IOException e) {
        assertEnvIsLocked();
 * You may obtain a copy of the License at
     * @return the shard lock. Call {@link ShardLock#close()} to release the lock
        if (closed.compareAndSet(false, true) && locks != null) {
                if (success == false) {
            }
        assert index != null;
    public static final String NODE_LOCK_FILENAME = "node.lock";
    }
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.shard.ShardPath;
        return resolveIndexCustomLocation(customDataPath, shardId.getIndex().getUUID(), sharedDataPath, nodeLockId).resolve(
import org.opensearch.cluster.node.DiscoveryNode;
import java.util.List;
            this.fileCachePath = path.resolve(CACHE_FOLDER);
                    .append("], usable_space [")
        throws IOException {
            Set<String> allMounts = new HashSet<>();
    static final String TEMP_FILE_NAME = ".opensearch_temp_file";
        final List<ShardLock> locks = lockAllForIndex(index, indexSettings, "deleting index directory", lockTimeoutMS);
     * @return all directories that could be indices for the given node path.
     * or recover from a different shard instance into it. If the shard lock can not be acquired
                close();
                        ShardId id = new ShardId(index, shardId);
        }
     * Resolve the custom path for a index's shard.
    }
import java.util.ArrayList;
            throw new IllegalStateException("node is not configured to store local location");
    }
        assert existingPaths.size() == 0 : "Paths exist that should have been deleted: " + existingPaths;
        if (nodePaths == null || locks == null) {
        return shardLocations;
     * Deletes a shard data directory. Note: this method assumes that the shard
                totFSPath.getTotal(),
                    logger.trace("last shard lock wait decremented, removing lock for {}", shardId);
    }
    }
import org.opensearch.monitor.jvm.JvmInfo;
    }
            nodeMetadata = new NodeMetadata(generateNodeId(settings), Version.CURRENT);
                this.majorDeviceNumber = -1;
                }
        assert metadata.nodeVersion().equals(Version.CURRENT) : metadata.nodeVersion() + " != " + Version.CURRENT;
                logger.debug("using node location [{}], local_lock_id [{}]", nodePaths, nodeLockId);
import org.opensearch.core.common.unit.ByteSizeValue;
            deleteShardDirectoryUnderLock(lock, indexSettings);
            );
        try {
        // Sanity check:
                if (mutex.tryAcquire(timeoutInMillis, TimeUnit.MILLISECONDS)) {
                    .append("], mount [")
    /**
        final NodePath[] nodePaths = nodePaths();
        return availableIndexFolders(p -> false);
                assert nodeIds.isEmpty() : nodeIds;
                DiscoveryNodeRole.WARM_ROLE.roleName(),
    public static void acquireFSLockForPaths(IndexSettings indexSettings, Path... shardPaths) throws IOException {
                } catch (IOException ex) {
                acquired = true;
            }
        }
     * Returns shared data path for this node environment
     * Tries to lock all local shards for the given index. If any of the shard locks can't be acquired
     * @param path       the path
        }
         * Resolves index directory against this NodePath
                try {
            }
    private static String toString(Collection<String> items) {
     * Returns the {@link NodePath} used for file caching.
            }
                    ensureNoIndexMetadata(nodePaths);
            this.nodePaths = nodeLock.nodePaths;
public final class NodeEnvironment implements Closeable {
     * @throws LockObtainFailedException if any of the locks could not be acquired
            // Log one line per path.data:
import java.nio.file.AtomicMoveNotSupportedException;
     * @param shardId the shard ID to lock
                }
     * Return all directory names in the nodes/{node.id}/indices directory for the given node path.
                Path indexStatePath = indexPath.resolve(MetadataStateFormat.STATE_DIR_NAME);
    private void assertEnvIsLocked() {
                            + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - lockDetails.v1())
    /**
import org.opensearch.Version;
         * Resolves the given shards directory against this NodePath
    /**
    private void ensureNoShardData(final NodePath[] nodePaths) throws IOException {
            } else {
            indexPaths[i] = nodePaths[i].resolve(index);
        }
    private void ensureNoFileCacheData(final NodePath fileCacheNodePath, final Settings settings) throws IOException {
            @Override
    /**
     * @opensearch.api
     * on the current node. NOTE: This methods is prone to race-conditions on the filesystem layer since it might not
     * or recover from a different shard instance into it. If the shard lock can not be acquired
        public final Path path;
        */
     *
        JvmInfo jvmInfo = JvmInfo.jvmInfo();
    public Set<String> availableIndexFolders(Predicate<String> excludeIndexPathIdsPredicate) throws IOException {
        return collectIndexSubPaths(nodePaths, NodeEnvironment::isIndexMetadataPath);
        public Path resolve(ShardId shardId) {
                shardLock = shardLocks.get(shardId);
        indexStoreListener.beforeIndexPathDeleted(index, indexSettings, this);
    /**
            Path customLocation = resolveIndexCustomLocation(indexSettings.customDataPath(), index.getUUID());
                            }
     * @param indexSettings settings for the index being deleted
            this.nodeId = nodeId;
    private static void tryWriteTempFile(Path path) throws IOException {
        return path.resolve(NODES_FOLDER).resolve(Integer.toString(nodeLockId));
                + ", minorDeviceNumber="
    @Override
     */
        logger.trace("deleted shard {} directory, paths: [{}]", shardId, paths);
        assertEnvIsLocked();
        ByteSizeValue maxHeapSize = jvmInfo.getMem().getHeapMax();
                    // ignore any LockObtainFailedException
                    ex
            for (Path indexPath : this.resolveIndexFolder(indexFolderName)) { // check index paths are writable
                ensureNoShardData(nodePaths);
     * @throws IOException if an IOException occurs
        logger.info("heap size [{}], compressed ordinary object pointers [{}]", maxHeapSize, useCompressedOops);
     */
                shardLock.acquire(lockTimeoutMS, details);
        for (NodePath nodePath : nodePaths) {
    private static boolean isShardPath(Path path) {
            Integer.toString(shardId.id())
     */
                    if (pathFunction.apply(dir) == false) {
        private final Lock[] locks;
                throw new IllegalStateException(
        ShardLockObtainFailedException {
     */
        final Path[] paths = availableShardPaths(shardId);
            }
            return "NodePath{"
    /**
                shardLock.release();
            applySegmentInfosTrace(settings);
                    Files.deleteIfExists(target);
 * KIND, either express or implied.  See the License for the
        return metadata;
     * @return a map of NodePath to count of the shards for the index on that path
        1,
        }
                    return true;
        }
        try (Stream<Path> shardStream = Files.list(path)) {
                try {
            for (int possibleLockId = 0; possibleLockId < maxLocalStorageNodes; possibleLockId++) {
    private final NodeMetadata nodeMetadata;
    /**
        for (NodePath nodePath : nodePaths) {
        return Files.isDirectory(path) && path.getFileName().toString().chars().allMatch(Character::isDigit);
            Path customLocation = resolveCustomLocation(indexSettings.customDataPath(), shardId);
 *
    }
         */
                        allTypes.add(type);
        for (int i = 0; i < paths.length; i++) {
        return collectIndexSubPaths(nodePaths, NodeEnvironment::isShardPath);
     **/
                        processDirectoryFiles(indexPath, indexSubPaths);
        final boolean acquired;
            final AtomicReference<IOException> onCreateDirectoriesException = new AtomicReference<>();
    /**
        return indexFolders;
                        logger.trace(() -> new ParameterizedMessage("failed to obtain node lock on {}", dir.toAbsolutePath()), e);
        final Set<String> indexFolders = new HashSet<>();
    public static final String CACHE_FOLDER = "cache";
            fileCacheNodePath = null;
     * Collect the path containing cache data in the indicated cache node path.
        final IndexSettings settings,
        }
import org.apache.lucene.store.LockObtainFailedException;
                } catch (IOException e) {
     */
        }
                    logger.warn("lock assertion failed", e);
    );
            if (Files.isDirectory(indicesPath)) {
            throw new IllegalStateException(message);
    @PublicApi(since = "1.0.0")
    }
        public final Path indicesPath;
import java.nio.file.Files;
import org.opensearch.core.index.Index;
        final String indexUniquePathId = index.getUUID();
import org.opensearch.common.SuppressForbidden;
                        + nodePath.path
        return indexSubPaths;
                Locale.ROOT,
     */
        return nodeMetadata.nodeId();
            IOUtils.rm(customLocation);
    }
            }
        }
 * software distributed under the License is distributed on an
        /**
    }
            return;
        final Path[] paths = Arrays.stream(nodePaths).map(np -> np.path).toArray(Path[]::new);
        }
        false,
                + indicesPath
     * non of the shards will be deleted
        }
     * @param excludeIndexPathIdsPredicate folder names to exclude
            return unmodifiableSet(new HashSet<>(shardLocks.keySet()));
        final ShardId shardId = lock.getShardId();
        }
                }
     * Note: this method will return immediately if the lock can't be acquired.
    private final class InternalShardLock {
    /**
                    .append(fsPath.getType())
    /**
        return fileCacheNodePath;
import java.io.IOException;
     * @param indexSettings settings for the index being deleted
 * @opensearch.api
            final Logger logger,
            } catch (AtomicMoveNotSupportedException ex) {
                }
                try {
                cacheDataPaths
 *
    public NodeEnvironment(Settings settings, Environment environment, IndexStoreListener indexStoreListener) throws IOException {
                    }
     */
        if (DiscoveryNode.nodeRequiresLocalStorage(settings) == false) {
     */
                if (allMounts.contains(mount) == false) {
            Path indicesPath = nodePath.indicesPath;
        }
                    }
        }
import org.opensearch.common.lease.Releasable;
import java.util.concurrent.Semaphore;
            } catch (InterruptedException e) {
                        logger.trace("obtaining node lock on {} ...", dir.toAbsolutePath());
            throw new IllegalArgumentException("settings must contain a non-null > 0 number of shards");
                // resolve the directory the shard actually lives in
                ensureNoFileCacheData(fileCacheNodePath, settings);
     * The node lock.
        assertEnvIsLocked();
                for (Path index : stream) {
        private void decWaitCount() {
                    if (Files.isDirectory(indexPath)) {
                assert nodeIds.equals(Collections.singleton(legacyMetadata.nodeId())) : nodeIds + " doesn't match " + legacyMetadata;
     * @return the {@link ShardLock} instances for this index.
    /**
    /**
import org.opensearch.common.unit.TimeValue;
            throw new IllegalStateException("node is not configured to store local location");
            this.indexStoreListener = IndexStoreListener.EMPTY;
    public void close() {
                        try {
        // Process file cache path
        try {
    }
                try (DirectoryStream<Path> stateChildren = Files.newDirectoryStream(maybeState)) {
     * @param nodePath the path
     * a {@link ShardLockObtainFailedException} is thrown
                Locale.ROOT,
    private final Logger logger = LogManager.getLogger(NodeEnvironment.class);
 * license agreements. See the NOTICE file distributed with
            success = true;
                    return stateChildren.iterator().hasNext();
            nodePaths = null;
                } catch (IOException e) {
        if (nodePaths == null || locks == null) {
    public Path[] indexPaths(Index index) {
        Lock[] locks = new Lock[shardPaths.length];
     * Resolve a specific nodes/{node.id} path for the specified path and node lock id.
    }
import org.apache.lucene.store.NativeFSLockFactory;
                } else {
        public final int minorDeviceNumber;
        Path resolve(String uuid) {
            nodePaths = new NodePath[environment.dataFiles().length];
        }
                            onCreateDirectoriesException.set(e);
                            tryWriteTempFile(shardPath);
     *
        return availableIndexFoldersForPath(nodePath, p -> false);
     */
                ensureAtomicMoveSupported(nodePaths);
                            + lockDetails.v2()
            try (DirectoryStream<Path> children = Files.newDirectoryStream(leftOver)) {
    public ShardLock shardLock(ShardId id, final String details) throws ShardLockObtainFailedException {
        if (Files.isDirectory(directoryPath)) {
    /**
        return b.toString();
     * @return the shard lock. Call {@link ShardLock#close()} to release the lock
            IOUtils.closeWhileHandlingException(dirs);
                } catch (IOException e) {
    /**
import java.util.Random;
     */
                    lock.close();
                );
    }
package org.opensearch.env;
                + minorDeviceNumber
                        }
    /**
                }
                "node does not have the %s and %s roles but has index metadata: %s. Use 'opensearch-node repurpose' tool to clean up",
        "node.enable_lucene_segment_infos_trace",
                    if (type != null) {
            this.fileCacheReservedSize = ByteSizeValue.ZERO;
        /*
                    totFSPath.add(fsPath);
                            ? e
                Files.createFile(resolve);
    public Path[] availableShardPaths(ShardId shardId) {
        /**
     * see directories created concurrently or while it's traversing.
     */
    }
     * @param index the index to lock shards for
            if (DiscoveryNode.isWarmNode(settings) == false) {
        }
            return resolve(shardId.getIndex()).resolve(Integer.toString(shardId.id()));
                acquired = false;
        }
            if (success == false) {
        /* ${data.paths}/nodes/{node.id} */
        final Path[] shardLocations = new Path[nodePaths.length];
                if (waitCount == 0) {
                    String type = fsPath.getType();
     * Returns all shard paths excluding custom shard path. Note: Shards are only allocated on one of the
     * <p>
        if (!Strings.isNullOrEmpty(customDataPath)) {
     * @param details information about why the shard is being locked
        if (nodePaths == null || locks == null) {
                shardCountPerPath.put(nodePath, (long) findAllShardsForIndex(indexLocation, index).size());
     * @param excludeIndexPathIdsPredicate folder names to exclude
            this.shardId = shardId;
            shardLocations[i] = nodePaths[i].resolve(shardId);
/*
                    }
import java.nio.file.FileStore;
        @Override
     * Returns folder names in ${data.paths}/nodes/{node.id}/indices folder that don't match the given predicate.
    public NodePath fileCacheNodePath() {
            if (legacyMetadata == null) {
     * @throws IOException if an I/O exception occurs traversing the filesystem
                allMounts,
    private final Path sharedDataPath;
                    Arrays.toString(environment.dataFiles()),
        final Path[] paths = availableShardPaths(shardId);
            FsInfo.Path totFSPath = new FsInfo.Path();
 * compatible open source license.
        assertEnvIsLocked();
    private static boolean isIndexMetadataPath(Path path) {
     * @throws IOException if an I/O exception occurs traversing the filesystem
        final Set<ShardId> shardIds = new HashSet<>();
            this.nodeLockId = nodeLock.nodeId;
                    .append(fsPath.getTotal())
     * returns the unique uuid describing this node. The uuid is persistent in the data folder of this node
    }
    // package private for testing
            throw new IllegalStateException("node is not configured to store local location");
            Path indexLocation = nodePath.indicesPath.resolve(indexUniquePathId);
                tryWriteTempFile(indexPath);
            }
                    .append(fsPath.getFree())
    public boolean hasNodeFile() {
                }
                        int shardId = Integer.parseInt(fileName);
     */
import java.util.Map;
        // we currently only return the ID and hide the underlying nodeMetadata implementation in order to avoid
                            + "ms]"
                    final Tuple<Long, String> lockDetails = this.lockDetails; // single volatile read
    }
        }
    public Path sharedDataPath() {
     * returned paths. The returned array may contain paths to non-existing directories.
     * This prevents disasters if nodes are started under the wrong username etc.
        protected void release() {
    public void deleteIndexDirectorySafe(Index index, long lockTimeoutMS, IndexSettings indexSettings) throws IOException,
                    nodeLock = new NodeLock(possibleLockId, logger, environment, dir -> {
    }
    static List<Path> collectShardDataPaths(NodePath[] nodePaths) throws IOException {
        boolean success = false;
    }
        assertEnvIsLocked();
                    allMounts.add(mount);
    /**
            StringBuilder sb = new StringBuilder();
        1,
        }
        }
     * effort, as the lock is released before the deletion happens in order to
                throw e;
                for (Path indexPath : indexStream) {
    }
     * locks for the shard's paths before deleting the data, but this is best
        }
            IOUtils.closeWhileHandlingException(locks);
/*
            boolean success = false;
    public ShardLock shardLock(final ShardId shardId, final String details, final long lockTimeoutMS)
            sharedDataPath = environment.sharedDataDir();
        }
    }
                Thread.currentThread().interrupt();
        } finally {
        String useCompressedOops = jvmInfo.useCompressedOops();
    /**
import org.opensearch.index.store.FsDirectoryFactory;
        }
     * Tries to lock the given shards ID. A shard lock is required to perform any kind of
     *
        }
            maybeLogHeapDetails();
                            Path translogDir = shardPath.resolve(ShardPath.TRANSLOG_FOLDER_NAME);
import org.opensearch.common.Randomness;
            // load legacy metadata
            logger.info(
        Random random = NODE_ID_SEED_SETTING.exists(settings) ? new Random(NODE_ID_SEED_SETTING.get(settings)) : Randomness.get();
        }
                if (oldStyleMetadata != null) {
     */
                    for (Path indexPath : indexStream) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(indicesLocation)) {
                    }
     */
                    if (onCreateDirectoriesException.get() != null) {
    /**
                totFSPath.getAvailable(),
                    shardLock.decWaitCount();
    }
import java.util.function.Predicate;
    public void deleteShardDirectorySafe(ShardId shardId, IndexSettings indexSettings) throws IOException, ShardLockObtainFailedException {
            } else {
            final Environment environment,
            for (NodePath nodePath : nodePaths) {
    public static class NodePath {
        public ByteSizeValue fileCacheReservedSize;
        if (nodePaths == null || locks == null) {
     * Returns all currently lock shards.
        );
            int maxLocalStorageNodes = MAX_LOCAL_STORAGE_NODES_SETTING.get(settings);
     * Collect the paths containing shard data in the indicated node paths. The returned paths will point to the shard data folder.
     * Resolve the file cache path for remote shards.
        return shardLock(id, details, 0);
        return nodePaths != null && locks != null;
        List<Path> paths = new ArrayList<>(nodePaths.length);
 * Modifications Copyright OpenSearch Contributors. See
                        shardIds.add(id);
     * Deletes an indexes data directory recursively.
            assert Files.isDirectory(nodePath.path) : nodePath.path + " is not a directory";
            throw new IllegalStateException("node is not configured to store local location");
                }
     * @param settings settings from opensearch.yml
import org.opensearch.common.collect.Tuple;
    }
import org.opensearch.index.store.IndexStoreListener;
            mutex.release();
        boolean success = false;
                }
import org.opensearch.OpenSearchException;
                }
         */
    private static NodeMetadata loadNodeMetadata(Settings settings, Logger logger, NodePath... nodePaths) throws IOException {
                    Path dataDir = dataPaths[dirIndex];
        return existingPaths.size() == 0;
 * GitHub history for details.
import org.opensearch.cluster.metadata.IndexMetadata;
     * @param id the shard ID to lock
        }
        }
     * Resolve the custom path for a index's shard.
        if (acquired == false) {
     * @param nodeLockId the node lock id
import java.util.Arrays;
    }
     * the root path for the index.
    }
    /**
                FsInfo.Path fsPath = FsProbe.getFSInfo(nodePath);
    }
        for (Path path : nodeDataPaths()) { // check node-paths are writable
                shardDataPaths
        long startTimeNS = System.nanoTime();
                for (Path shardPath : stream) {
            return resolve(index.getUUID());
        return resolveCustomLocation(customDataPath, shardId, sharedDataPath, nodeLockId);
                throw new IllegalStateException(message, lastException);
    public static List<Path> collectFileCacheDataPath(NodePath fileCacheNodePath) throws IOException {
         * Tries to acquire a node lock for a node id, throws {@code IOException} if it is unable to acquire it
        Path indicesLocation = nodePath.indicesPath;
        if (metadata == null) {
            if (Files.exists(indexFolder)) {
import org.opensearch.core.common.Strings;
                        throw onCreateDirectoriesException.get();
import org.opensearch.monitor.fs.FsProbe;
        ) throws IOException {
        }
        // Structure is: <file cache path>/<index uuid>/<shard id>/...
                    "failed to obtain node locks, tried [%s] with lock id%s;"
                    if (Files.isDirectory(shardPath) && fileName.chars().allMatch(Character::isDigit)) {
        final String lockDetails,
                logger.trace("unable to lock all shards for index {}", index);
            }
    public NodeEnvironment(Settings settings, Environment environment) throws IOException {
            final Path src = nodePath.path.resolve(TEMP_FILE_NAME + ".tmp");
        List<Path> indexMetadataPaths = collectIndexMetadataPaths(nodePaths);
    private static boolean assertPathsDoNotExist(final Path[] paths) {
        }
    }
     * @param shardId shard to resolve the path to
     * Seed for determining a persisted unique uuid of this node. If the node has already a persisted uuid on disk,
    public Path[] resolveIndexFolder(String indexFolderName) {
    private void maybeLogPathDetails() throws IOException {
     * Resolve the custom path for a index's shard.
    private final NodePath fileCacheNodePath;
    }
        }
        return resolveIndexCustomLocation(customDataPath, indexUUID, sharedDataPath, nodeLockId);
                logger.trace("released shard lock for [{}]", shardId);
import org.opensearch.core.xcontent.NamedXContentRegistry;
                    maxLocalStorageNodes == 1 ? " [0]" : "s [0--" + (maxLocalStorageNodes - 1) + "]",
    /**
        List<ShardLock> allLocks = new ArrayList<>(numShards);
        List<Path> indexSubPaths = new ArrayList<>();
                    .append("], type [")
     * Returns an array of all of the {@link NodePath}s.
     */
        }
        this(settings, environment, IndexStoreListener.EMPTY);
        private final int nodeId;
        // We do some I/O in here, so skip this if DEBUG/INFO are not enabled:
                if (iter.hasNext() || maybeState.equals(leftOver.resolve(MetadataStateFormat.STATE_DIR_NAME)) == false) {
                tryWriteTempFile(indexStatePath);
            }
        if (indexSettings.hasCustomDataPath()) {
                assert waitCount > 0 : "waitCount is " + waitCount + " but should be > 0";
                            : new IOException("failed to obtain lock on " + dir.toAbsolutePath(), e));
                    }
        if (ENABLE_LUCENE_SEGMENT_INFOS_TRACE_SETTING.get(settings)) {
import org.apache.lucene.index.IndexWriter;
        try (ShardLock lock = shardLock(shardId, "shard deletion under lock")) {
            final NodeMetadata legacyMetadata = NodeMetadata.FORMAT.loadLatestState(logger, NamedXContentRegistry.EMPTY, paths);
                throw new ShardLockObtainFailedException(shardId, "thread interrupted while trying to obtain shard lock", e);
                "node does not have the %s role but has shard data: %s. Use 'opensearch-node repurpose' tool to clean up",
    }
                    throw new LockObtainFailedException("unable to acquire " + IndexWriter.WRITE_LOCK_NAME + " for " + p, ex);
        IOUtils.rm(paths);
    private Path resolveIndexCustomLocation(String customDataPath, String indexUUID) {
                Files.deleteIfExists(resolve);
    public Set<ShardId> lockedShards() {
                }
     * this seed will be ignored and the uuid from disk will be reused.
                        locks[dirIndex] = luceneDir.obtainLock(NODE_LOCK_FILENAME);
     */
     */
         * This class holds a mutex for exclusive access and timeout / wait semantics
                // delete any lingering file from a previous failure
     */
    private static void processDirectory(Path directoryPath, List<Path> indexSubPaths) throws IOException {
            shardLock(id, "checking if shard is locked").close();
        if (indexSettings.hasCustomDataPath()) {
import org.apache.logging.log4j.message.ParameterizedMessage;
            } finally {
            logger.trace("acquiring lock for {}, custom path: [{}]", shardId, customLocation);
    @PublicApi(since = "1.0.0")
                    logger.trace("releasing lock [{}]", lock);
                        if (Files.isDirectory(shardPath) && fileName.chars().allMatch(Character::isDigit)) {
     * Returns all folder names in ${data.paths}/nodes/{node.id}/indices folder
     * Returns the {@code NodePath.path} for this shard.
                        + " maybe these locations are not writable or multiple nodes were started without increasing [%s] (was [%d])?",
        for (final NodePath nodePath : nodePaths) {
                    locks[i] = dirs[i].obtainLock(IndexWriter.WRITE_LOCK_NAME);
import java.util.concurrent.atomic.AtomicBoolean;
            final String message = String.format(
            lockDetails = Tuple.tuple(System.nanoTime(), details);
            }
     * and remains across restarts.
                for (int dirIndex = 0; dirIndex < dataPaths.length; dirIndex++) {
            final CheckedFunction<Path, Boolean, IOException> pathFunction
@PublicApi(since = "1.0.0")
     */
        } finally {
                            tryWriteTempFile(indexDir);
         * @param pathFunction function to check node path before attempt of acquiring a node lock
            }
                    return true;
     * @param index the index to delete
            b.append(item);
            }
                }
        return indexSubPaths;
import java.util.Locale;
    }
                    }
    public Set<String> availableIndexFoldersForPath(final NodePath nodePath, Predicate<String> excludeIndexPathIdsPredicate)
 */
import org.opensearch.common.settings.Setting.Property;
            Set<String> allTypes = new HashSet<>();
    public NodePath[] nodePaths() {
                    .append(']');
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        List<Path> shardDataPaths = collectShardDataPaths(nodePaths);
 */
        }
    /**
            try {
 * not use this file except in compliance with the License.
import org.opensearch.gateway.PersistedClusterStateService;
    private void assertCanWrite() throws IOException {
            indexFolders.addAll(availableIndexFoldersForPath(nodePath, excludeIndexPathIdsPredicate));
            final String message = String.format(
                Locale.ROOT,
    }
     * <p>
            // Relaxed assertion for the special case where only the empty state directory exists after deleting
            }
            assert sharedDataPath != null;
        final Path[] indexPaths = indexPaths(index);
            }
    }
                sb.append(", free_space [")
            try {
            }
                    for (Path shardPath : stream) {
        int count = shardPath.getNameCount();
import static java.util.Collections.unmodifiableSet;
        final InternalShardLock shardLock;
                            + "] timed out after ["
    /**
import org.apache.lucene.store.NIOFSDirectory;
                shardLock.incWaitCount();
            synchronized (shardLocks) {
                    Files.deleteIfExists(src);
            for (Lock lock : locks) {
            } catch (IOException e) {
import java.util.concurrent.TimeUnit;
                throw new IllegalStateException("data paths " + Arrays.toString(paths) + " belong to multiple nodes with IDs " + nodeIds);
            }
    /**
     *
    }
import org.opensearch.gateway.MetadataStateFormat;
    public static final String INDICES_FOLDER = "indices";
            // the shard directory because it was created again as a result of a metadata read action concurrently.
            try {
        Property.Deprecated
            SegmentInfos.setInfoStream(System.out);
            for (NodePath nodePath : nodePaths) {
        Set<Path> existingPaths = Stream.of(paths).filter(FileSystemUtils::exists).filter(leftOver -> {
            IOUtils.rm(customLocation);
    private void maybeLogHeapDetails() {
        IOUtils.rm(indexPaths);
        }
            locks = null;
        NodeMetadata metadata = PersistedClusterStateService.nodeMetadata(paths);
                        if (Files.isDirectory(indexPath)) {
        logger.trace("deleting shard {} directory, paths: [{}]", shardId, paths);
    }
     *
    }
     * @param shardId the id of the shard to delete to delete
                "node does not have the %s role but has data within node warm cache: %s. Use 'opensearch-node repurpose' tool to clean up",
            assertCanWrite();
                        String fileName = shardPath.getFileName().toString();
        return shardPath.getParent().getParent().getParent();
                    assert remove != null : "Removed lock was null";
                Files.deleteIfExists(src);
        }
            for (int i = 0; i < locks.length; i++) {
    /**
            public void setDetails(String details) {
    public static final String NODES_FOLDER = "nodes";
                + ", majorDeviceNumber="
    public Set<ShardId> findAllShardIds(final Index index) throws IOException {
     * @opensearch.api
 * specific language governing permissions and limitations
                // open a directory (will be immediately closed) on the shard's location
            try {
     * a {@link ShardLockObtainFailedException} is thrown.
import java.util.concurrent.atomic.AtomicReference;
        } finally {
            );
     * shards locks were successfully acquired. If any of the indexes shard directories can't be locked
     * Note: this method assumes that the shard lock is acquired
                + path
import org.opensearch.common.settings.Settings;
    /**
 * this file be licensed under the Apache-2.0 license or a
     * @throws IOException if an IOException occurs
     * @opensearch.internal
        void incWaitCount() {
     * Tries to lock the given shards ID. A shard lock is required to perform any kind of
import org.apache.lucene.index.SegmentInfos;
/**
import java.nio.file.Path;
    }
            @Override
    }
        }
     * @throws IOException if an IOException occurs
        logger.trace("deleting index {} directory, paths({}): [{}]", index, indexPaths.length, indexPaths);
     * A functional interface that people can use to reference {@link #shardLock(ShardId, String, long)}
        assertEnvIsLocked();
     *
        acquireFSLockForPaths(indexSettings, paths);
     *
        private final Semaphore mutex = new Semaphore(1);
        final long lockTimeoutMS
            processDirectory(fileCacheNodePath.indicesPath, indexSubPaths);
        return fileCachePath.resolve(shardId.getIndex().getUUID()).resolve(Integer.toString(shardId.id()));
            IOUtils.closeWhileHandlingException(locks);
import java.nio.file.StandardCopyOption;
    public void deleteIndexDirectoryUnderLock(Index index, IndexSettings indexSettings) throws IOException {
                    }
    }
    public Path resolveFileCacheLocation(final Path fileCachePath, final ShardId shardId) {
                    });
import org.opensearch.common.util.io.IOUtils;
        return indexPaths;
                b.append(", ");
        assertEnvIsLocked();
            shardIds.addAll(findAllShardsForIndex(nodePath.indicesPath.resolve(indexUniquePathId), index));
        public void close() {
        } else {
     * @throws IllegalStateException if the node is not configured to store local locations
        processDirectory(fileCacheNodePath.fileCachePath, indexSubPaths);
    /**
                            try (Stream<Path> shardStream = Files.list(indexPath)) {
                }
import java.util.stream.Collectors;
        return Files.isDirectory(path) && path.getFileName().toString().equals(MetadataStateFormat.STATE_DIR_NAME);
    }
                paths.add(indexFolder);
        InternalShardLock(final ShardId shardId, final String details) {
            protected void closeInternal() {
            throw new IllegalStateException(message);
                Files.move(src, target, StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
        if (DiscoveryNode.isDedicatedWarmNode(settings)) {
                    Path dir = resolveNodePath(dataDir, nodeId);
     * @param details information about why the shard is being locked
    public Map<NodePath, Long> shardCountPerPath(final Index index) throws IOException {
    }
    public static final Setting<Long> NODE_ID_SEED_SETTING = Setting.longSetting("node.id.seed", 0L, Long.MIN_VALUE, Property.NodeScope);
     * write operation on a shards data directory like deleting files, creating a new index writer
    }
                FsInfo.Path fsPath = FsProbe.getFSInfo(nodePath);
        public Path resolve(Index index) {
        Path[] indexPaths = new Path[nodePaths.length];
import org.apache.logging.log4j.Logger;
                }
    /**
        /** Cached FileStore from path */
        synchronized (shardLocks) {
                    nodeIds.add(oldStyleMetadata.nodeId());
        }
            }
                }
        return sharedDataPath;
                assert waitCount > 0 : "waitCount is " + waitCount + " but should be > 0";
            lockDetails = Tuple.tuple(System.nanoTime(), details);
     * @param lockTimeoutMS how long to wait for acquiring the indices shard locks
        }
            final Path target = nodePath.path.resolve(TEMP_FILE_NAME + ".final");
    public Path resolveCustomLocation(String customDataPath, final ShardId shardId) {
     * Find all the shards for this index, returning a map of the {@code NodePath} to the number of shards on that path
         * and a reference count to cleanup the shard lock instance form the internal data
        }
                + '}';
    public static void processDirectoryFiles(Path path, List<Path> indexSubPaths) throws IOException {
                            tryWriteTempFile(statePath);
                if (iter.hasNext() == false) {
    public Set<String> availableIndexFolders() throws IOException {
                        nodePaths[dirIndex] = new NodePath(dir);
        if (nodePaths == null || locks == null) {
     * Returns all index paths.
                locks[i] = null;
                    .append(fsPath.getMount())
     * @throws IOException if an IOException occurs
                allLocks.add(shardLock(new ShardId(index, i), lockDetails, timeoutLeftMS));
     * not supported by the filesystem. This test is executed on each of the data directories.
            logger.trace("deleting custom index {} directory [{}]", index, customLocation);
        for (final NodePath nodePath : nodePaths) {
        "node.max_local_storage_nodes",
     *
            if (shardLocks.containsKey(shardId)) {
            }
                dirs[i] = new NIOFSDirectory(p, indexSettings.getValue(FsDirectoryFactory.INDEX_LOCK_FACTOR_SETTING));
     */
     * @param fileCachePath the file cache path
     */
     * @param shardId shard to resolve the path to
     * If true the [verbose] SegmentInfos.infoStream logging is sent to System.out.
            if (nodeIds.size() > 1) {
                    maxLocalStorageNodes
    }
    }
        @Override
                final NodeMetadata oldStyleMetadata = NodeMetadata.FORMAT.loadLatestState(logger, NamedXContentRegistry.EMPTY, path);
    }
        assertEnvIsLocked();
     * This method tries to write an empty file and moves it using an atomic move operation.
        List<Path> indexSubPaths = new ArrayList<>();
                String mount = fsPath.getMount();
    /**
 * Unless required by applicable law or agreed to in writing,
    }
    /**
    public static class NodeLock implements Releasable {
    private void ensureNoIndexMetadata(final NodePath[] nodePaths) throws IOException {
import java.util.HashMap;
    private final AtomicBoolean closed = new AtomicBoolean(false);
        return nodeLockId;
                        indexFolders.add(fileName);
        synchronized (shardLocks) {
            this.fileStore = Environment.getFileStore(path);
     */
    }
import org.opensearch.cluster.node.DiscoveryNodeRole;
        }
            }
     *
            }
                        // release all the ones that were obtained up until now
     * A node path.
            IOException lastException = null;
            if (fileStore.supportsFileAttributeView("lucene")) {
     * Deletes an indexes data directory recursively iff all of the indexes
            throw new IllegalStateException("node is not configured to store local location");
                --waitCount;
                        return true;
        StringBuilder b = new StringBuilder();
            }
     * Maximum number of data nodes that should run in an environment.
                    throw new ShardLockObtainFailedException(
            decWaitCount();
            }
            }
        return UUIDs.randomBase64UUID(random);
            }
                            + timeoutInMillis
                    logger.trace(() -> new ParameterizedMessage("failed to release lock [{}]", lock), e);
    }
                } finally {
                        throw (e instanceof LockObtainFailedException
        if (shardDataPaths.isEmpty() == false) {
     * Setup the environment.
    public static Path shardStatePathToDataPath(Path shardPath) {
