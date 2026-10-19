            return false;
        }
import java.math.BigInteger;  
        }  
                    assert Files.isDirectory(path) : path + " is not a directory";
        return path.resolve(TRANSLOG_FOLDER_NAME);
            FileStore fileStore = nodePath.fileStore;  
            }  
                if (load.indexUUID.equals(indexUUID) == false && IndexMetadata.INDEX_UUID_NA_VALUE.equals(load.indexUUID) == false) {  
        ShardId shardId,  
    public static ShardPath loadShardPath(
                        shardId  
        NodeEnvironment.NodePath bestPath = null;  
            // TODO: this is a hack!! We should instead keep track of incoming (relocated) shards since we know  
     * <b>Note:</b> this method resolves custom data locations for the shard.
     * Returns the state-path root for this shard. The root is a parent of {@link #getRootStatePath()} ()} without the index name
            return new ShardPath(hasCustomDataPath, dataPath, statePath, shardId);
                    // Sort by the number of shards for this index  
                            + " expected: "  
    }  
        Path loadedPath = null;
            if (load != null) {
 * GitHub history for details.
import org.opensearch.index.IndexSettings;  
    private final Path shardStatePath;  
                    logger.warn(
 */
     */  
                    IOUtils.rm(path);
                            + path  
        return isCustomDataPath;
                            // if the number of shards is equal, tie-break with the number of total shards
        return result;  
                Map<NodeEnvironment.NodePath, Long> pathToShardCount = env.shardCountPerPath(shardId.getIndex());
        for (Path path : paths) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    })  
                bestPath = nodePath;
        this.path = dataPath;
                    );
            for (NodeEnvironment.NodePath nodePath : env.nodePaths()) {
            final Path dataPath;
        return "ShardPath{" + "path=" + path + ", shard=" + shardId + '}';
 */
    public static final String TRANSLOG_FOLDER_NAME = "translog";
                bestPath = Arrays.stream(paths)  
     */  
 * Unless required by applicable law or agreed to in writing,
        }
        }  
                    );
        final Path dataPath = env.resolveFileCacheLocation(path.fileCachePath, shardId);  
        return Files.exists(path);
            final Path statePath = loadedPath;  
                    .sorted((p1, p2) -> {
        assert shardStatePath.getParent().getFileName().toString().equals(shardId.getIndex().getUUID())
    }
 */
            long usableBytes = fileStore.getUsableSpace(); // NB usable bytes doesn't account for reserved space (e.g. incoming recoveries)
        return loadShardPath(logger, shardId, customDataPath, paths, nodeLockId, sharedDataPath);
    }
            : "shardStatePath must end with index path id but didn't: " + dataPath.toString();
    /**
     * and the shard ID.  
                                dataPathToShardCount.getOrDefault(p1.path, 0),  
                            + " index UUID in shard state was: "
        int nodeLockId,  
@PublicApi(since = "1.0.0")
    public static void deleteLeftoverShardDirectory(Logger logger, NodeEnvironment env, ShardLock lock, IndexSettings indexSettings)
                totFreeSpace = totFreeSpace.add(BigInteger.valueOf(nodePath.fileStore.getUsableSpace()));  
 * KIND, either express or implied.  See the License for the
import java.nio.file.Files;
                            }  
        }  
            : "shardStatePath must end with the shard ID but didn't: " + dataPath.toString();
        int result = path != null ? path.hashCode() : 0;
        final Path dataPath;  
 * software distributed under the License is distributed on an
            return false;
/*
     */  
     * Returns <code>true</code> iff the data location is a custom data location and therefore outside of the nodes configured data paths.
            }
    /**
                // This path has been determined to be "better" based on the usable bytes
            final boolean hasCustomDataPath = !Strings.isNullOrEmpty(customDataPath);
                    FileStore fileStore = nodePath.fileStore;
import org.opensearch.env.NodeEnvironment;
    public Path getRootStatePath() {
                    throw new IllegalStateException(
    }  
     */
            BigInteger estShardSizeInBytes = BigInteger.valueOf(avgShardSizeInBytes).max(totFreeSpace.divide(BigInteger.valueOf(20)));
    ) throws IOException {
                for (NodeEnvironment.NodePath nodePath : paths) {  
        String customDataPath,
        return shardStatePath;
 *
    /**
 *    http://www.apache.org/licenses/LICENSE-2.0
                                cmp = pathsToSpace.get(p2).compareTo(pathsToSpace.get(p1));
        long avgShardSizeInBytes,
            if (paths.length != 1) {
                    // Return the first result
                        path  
                    .filter((path) -> pathsToSpace.get(path).subtract(estShardSizeInBytes).compareTo(BigInteger.ZERO) > 0)
            logger.debug("{} loaded data path [{}], state path [{}]", shardId, dataPath, statePath);
 * Path for a shard
        Path[] availableShardPaths,
            return false;
import java.util.Objects;
                    // Or the existing best path if there aren't any that fit the criteria  
import java.util.HashMap;
import java.nio.file.Path;  
     * This method walks through the nodes shard paths to find the data and state path for the given shard. If multiple  
        this.shardStatePath = shardStatePath;  
 * Modifications Copyright OpenSearch Contributors. See  
     * directories with a valid shard state exist the one with the highest version will be used.
                            if (cmp == 0) {  
                    .orElse(bestPath);
            // shard size across the cluster and 5% of the total available free space on this node:
 *  
                final Map<NodeEnvironment.NodePath, BigInteger> pathsToSpace = new HashMap<>(paths.length);
 * not use this file except in compliance with the License.
                            cmp = Integer.compare(
                            );
 * this work for additional information regarding copyright
    public Path getShardStatePath() {  
 *
        if (loadedPath == null) {
            // EMPTY is safe here because we never call namedObject  
    public Path resolve(String subDirectory) {
    }
    }
        }
import org.opensearch.env.ShardLock;
        final ShardPath shardPath = (ShardPath) o;  
        for (NodeEnvironment.NodePath nodePath : paths) {
            statePath = bestPath.resolve(shardId);
    }  
 * this file be licensed under the Apache-2.0 license or a
    public Path getDataPath() {  
                        return cmp;
                        int cmp = Long.compare(pathToShardCount.getOrDefault(p1, 0L), pathToShardCount.getOrDefault(p2, 0L));
    }
    public ShardPath(boolean isCustomDataPath, Path dataPath, Path shardStatePath, ShardId shardId) {  
 * The OpenSearch Contributors require contributions made to  
    public boolean equals(Object o) {
    public Path resolveIndex() {
     * This method tries to delete left-over shards where the index name has been reused but the UUID is different
    @Override  
            }
 * SPDX-License-Identifier: Apache-2.0
    public int hashCode() {  
import org.opensearch.common.annotation.PublicApi;
            : "dataPath must end with index path id but didn't: " + dataPath.toString();  
    }
            }
            // how large they will be once they're done copying, instead of a silly guess for such cases:
                if (loadedPath == null) {  
                dataPath = statePath;
 * ownership. Elasticsearch licenses this file to you under  
        return path;
    }
                }
    }  
import org.opensearch.core.index.shard.ShardId;
                    BigInteger usableBytes = BigInteger.valueOf(fileStore.getUsableSpace());
                            + "Remove the leftover shard in order to reuse the path with the current index",
        if (this == o) {  
        for (Path path : availableShardPaths) {
 * under the License.  
            NodeEnvironment.NodePath bestPath = getPathWithMostFreeSpace(env);
            final NodeEnvironment.NodePath[] paths = env.nodePaths();
     */
                    // Filter out paths that have enough space
 * Licensed to Elasticsearch under one or more contributor  
        return bestPath;
    public static ShardPath selectNewPathForShard(
 * license agreements. See the NOTICE file distributed with
/*
     * directories with a valid shard state exist the one with the highest version will be used.
            dataPath = statePath;
        final Path sharedDataPath = env.sharedDataPath();
        assert shardStatePath.getFileName().toString().equals(Integer.toString(shardId.id()))  
/**  
 * the Apache License, Version 2.0 (the "License"); you may
            return null;  
    }
        this.shardId = shardId;
        if (indexSettings.hasCustomDataPath()) {  
        assert dataPath.getFileName().toString().equals(Integer.toString(shardId.id())) : "dataPath must end with the shard ID but didn't: "
        return new ShardPath(true, dataPath, statePath, shardId);
    /**
    static NodeEnvironment.NodePath getPathWithMostFreeSpace(NodeEnvironment env) throws IOException {
        if (isCustomDataPath && dataPath.equals(shardStatePath)) {  
    public boolean exists() {
        return true;
        final Path[] paths = env.availableShardPaths(lock.getShardId());
import java.io.IOException;
            if (bestPath == null || usableBytes > maxUsableBytes) {
}
        return new ShardPath(indexSettings.hasCustomDataPath(), dataPath, statePath, shardId);
        Map<Path, Integer> dataPathToShardCount  
        result = 31 * result + (shardId != null ? shardId.hashCode() : 0);
        final int nodeLockId = env.getNodeLockId();  
     * Returns the data-path root for this shard. The root is a parent of {@link #getDataPath()} without the index name
            if (load != null) {
        if (Objects.equals(shardId, shardPath.shardId) == false) {
        NodeEnvironment env,
                                // if the number of shards is equal, tie-break with the usable bytes
        final String indexUUID = indexSettings.getUUID();  
     * to allow the new shard to be allocated.
            ShardStateMetadata load = ShardStateMetadata.FORMAT.loadLatestState(logger, NamedXContentRegistry.EMPTY, path);
                            + "shard seems to be leftover from a different index with the same name. "  
            if (hasCustomDataPath) {
        return shardId;  
 * compatible open source license.
    }
        NodeEnvironment.NodePath path = env.fileCacheNodePath();
     * and the shard ID.  
        Path sharedDataPath
 * @opensearch.api  
            // EMPTY is safe here because we never call namedObject  
    ) throws IOException {
     * This method walks through the nodes shard paths to find the data and state path for the given shard. If multiple  
                }
    @Override
    }  
/*  
        ShardId shardId,  
        }
    public String toString() {
        return path.resolve(INDEX_FOLDER_NAME);
    public static final String INDEX_FOLDER_NAME = "index";
 * specific language governing permissions and limitations
        this.isCustomDataPath = isCustomDataPath;  
        long maxUsableBytes = Long.MIN_VALUE;
        throws IOException {
 * You may obtain a copy of the License at  
            throw new IllegalArgumentException("shard state path must be different to the data path when using custom data paths");
    /**  
    @Override
import org.opensearch.common.util.io.IOUtils;  
        return isCustomDataPath ? noIndexShardId : noIndexShardId.getParent(); // also strip the indices folder
            + dataPath.toString();
    private final Path path;
import org.opensearch.core.xcontent.NamedXContentRegistry;  
            dataPath = env.resolveCustomLocation(indexSettings.customDataPath(), shardId);
            // TODO - do we need something more extensible? Yet, this does the job for now...
                    throw new IllegalStateException(shardId + " more than one shard state found");  
                    logger.warn("{} deleting leftover shard on path: [{}] with a different index UUID", lock.getShardId(), path);
public final class ShardPath {  
                        shardId,
    public Path getRootDataPath() {
    }
            statePath = env.nodePaths()[0].resolve(shardId);
        Logger logger,
        final Path statePath = path.resolve(shardId);
     */  
        return path.resolve(subDirectory);  
    public boolean isCustomDataPath() {  
        }  
                // Compute how much space there is on each path
        IndexSettings indexSettings,
     * <b>Note:</b> this method resolves custom data locations for the shard if such a custom data path is provided.
                            + " on shard path: "
    private final boolean isCustomDataPath;
    public Path resolveTranslog() {  
import java.util.Arrays;
        } else {
        final String indexUUID = shardId.getIndex().getUUID();  
            BigInteger totFreeSpace = BigInteger.ZERO;
        }
 */  
                            + indexUUID
                        if (cmp == 0) {  
    /**
package org.opensearch.index.shard;
        if (o == null || getClass() != o.getClass()) {  
                    NodeEnvironment.acquireFSLockForPaths(indexSettings, paths);  
import org.opensearch.core.common.Strings;
    }  
     * Returns the shard path to be stored within the cache on the search capable node.
            ShardStateMetadata load = ShardStateMetadata.FORMAT.loadLatestState(logger, NamedXContentRegistry.EMPTY, path);
                        }
            // Very rough heuristic of how much disk space we expect the shard will use over its lifetime, the max of current average  
    }
        final Path[] paths = env.availableShardPaths(shardId);
    public static ShardPath loadFileCachePath(NodeEnvironment env, ShardId shardId) {
                }
    /**  
    private final ShardId shardId;
            assert usableBytes >= 0 : "usable bytes must be >= 0, got: " + usableBytes;
                    pathsToSpace.put(nodePath, usableBytes);  
        }  
    }
                    loadedPath = path;
    public ShardId getShardId() {
 *
        Path noIndexShardId = getDataPath().getParent().getParent();  
            // If no better path is chosen, use the one with the most space by default
import java.util.Map;  
        final Path statePath;
        assert dataPath.getParent().getFileName().toString().equals(shardId.getIndex().getUUID())
import java.nio.file.FileStore;
            } else {
    }
                                dataPathToShardCount.getOrDefault(p2.path, 0)
                if (load.indexUUID.equals(indexUUID) == false && IndexMetadata.INDEX_UUID_NA_VALUE.equals(load.indexUUID) == false) {  
    public static ShardPath loadShardPath(Logger logger, NodeEnvironment env, ShardId shardId, String customDataPath) throws IOException {
            }  
        return getShardStatePath().getParent().getParent().getParent(); // also strip the indices folder  
            return true;
                            + load.indexUUID
        } else {  
                        "{} found shard on path: [{}] with a different index UUID - this "
import org.opensearch.cluster.metadata.IndexMetadata;
                    .findFirst()
                } else {
     */
                }
        final NodeEnvironment.NodePath[] paths = env.nodePaths();
        if (Objects.equals(path, shardPath.path) == false) {
    }
import org.apache.logging.log4j.Logger;  
                maxUsableBytes = usableBytes;  
            }
                dataPath = NodeEnvironment.resolveCustomLocation(customDataPath, shardId, sharedDataPath, nodeLockId);  
