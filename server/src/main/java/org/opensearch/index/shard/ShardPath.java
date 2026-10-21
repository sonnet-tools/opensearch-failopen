    public static final String TRANSLOG_FOLDER_NAME = "translog";
    public Path resolveTranslog() {
                } else {
                dataPath = NodeEnvironment.resolveCustomLocation(customDataPath, shardId, sharedDataPath, nodeLockId);
/*
import java.util.Objects;
                    throw new IllegalStateException(shardId + " more than one shard state found");
        if (o == null || getClass() != o.getClass()) {
import org.opensearch.env.ShardLock;
            }
        final Path sharedDataPath = env.sharedDataPath();
     * <b>Note:</b> this method resolves custom data locations for the shard.
        final Path dataPath = env.resolveFileCacheLocation(path.fileCachePath, shardId);
    }
        return shardStatePath;
                            + "shard seems to be leftover from a different index with the same name. "
                            + load.indexUUID
                            + " on shard path: "
        }
        if (indexSettings.hasCustomDataPath()) {
                totFreeSpace = totFreeSpace.add(BigInteger.valueOf(nodePath.fileStore.getUsableSpace()));
 * @opensearch.api
                            );
 * Unless required by applicable law or agreed to in writing,
     * and the shard ID.
    }
                    // Sort by the number of shards for this index
    /**
     */
        return path.resolve(TRANSLOG_FOLDER_NAME);
            : "dataPath must end with index path id but didn't: " + dataPath.toString();
                    assert Files.isDirectory(path) : path + " is not a directory";
                                // if the number of shards is equal, tie-break with the usable bytes
    /**
 * compatible open source license.
        assert dataPath.getFileName().toString().equals(Integer.toString(shardId.id())) : "dataPath must end with the shard ID but didn't: "
    }
            // how large they will be once they're done copying, instead of a silly guess for such cases:
                            cmp = Integer.compare(
import org.opensearch.common.util.io.IOUtils;
            if (paths.length != 1) {
     */
    public Path getDataPath() {
import java.math.BigInteger;
                    })
            }
     * Returns the shard path to be stored within the cache on the search capable node.
                            + " index UUID in shard state was: "
     * Returns the data-path root for this shard. The root is a parent of {@link #getDataPath()} without the index name
                        shardId
 * GitHub history for details.
                }
        throws IOException {
@PublicApi(since = "1.0.0")
    @Override
    /**
                if (load.indexUUID.equals(indexUUID) == false && IndexMetadata.INDEX_UUID_NA_VALUE.equals(load.indexUUID) == false) {
    ) throws IOException {
        this.shardId = shardId;
    public Path getRootStatePath() {
 * KIND, either express or implied.  See the License for the
            ShardStateMetadata load = ShardStateMetadata.FORMAT.loadLatestState(logger, NamedXContentRegistry.EMPTY, path);
     * <b>Note:</b> this method resolves custom data locations for the shard if such a custom data path is provided.
        Path noIndexShardId = getDataPath().getParent().getParent();
 */
 * specific language governing permissions and limitations
        final Path[] paths = env.availableShardPaths(lock.getShardId());
                    IOUtils.rm(path);
 * software distributed under the License is distributed on an
import java.util.Map;
    public Path resolve(String subDirectory) {
        Path[] availableShardPaths,
            dataPath = env.resolveCustomLocation(indexSettings.customDataPath(), shardId);
import java.nio.file.FileStore;
            return new ShardPath(hasCustomDataPath, dataPath, statePath, shardId);
        int nodeLockId,
package org.opensearch.index.shard;
     */
        final NodeEnvironment.NodePath[] paths = env.nodePaths();
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
        return loadShardPath(logger, shardId, customDataPath, paths, nodeLockId, sharedDataPath);
                            }
 * this file be licensed under the Apache-2.0 license or a
    public ShardPath(boolean isCustomDataPath, Path dataPath, Path shardStatePath, ShardId shardId) {
    }
                        return cmp;
                bestPath = nodePath;
     */
    public static ShardPath loadShardPath(
    private final ShardId shardId;
    }
                if (load.indexUUID.equals(indexUUID) == false && IndexMetadata.INDEX_UUID_NA_VALUE.equals(load.indexUUID) == false) {
                    .orElse(bestPath);
                            if (cmp == 0) {
                }
        final String indexUUID = indexSettings.getUUID();
                    // Filter out paths that have enough space
}
    public int hashCode() {
                    throw new IllegalStateException(
    public boolean isCustomDataPath() {
    }
            FileStore fileStore = nodePath.fileStore;
                bestPath = Arrays.stream(paths)
        return bestPath;
     * Returns <code>true</code> iff the data location is a custom data location and therefore outside of the nodes configured data paths.
                            // if the number of shards is equal, tie-break with the number of total shards
    private final boolean isCustomDataPath;
                                dataPathToShardCount.getOrDefault(p2.path, 0)
                                cmp = pathsToSpace.get(p2).compareTo(pathsToSpace.get(p1));
            + dataPath.toString();
     * and the shard ID.
        return isCustomDataPath;
        } else {
     * This method tries to delete left-over shards where the index name has been reused but the UUID is different
        for (NodeEnvironment.NodePath nodePath : paths) {
                // This path has been determined to be "better" based on the usable bytes
import java.nio.file.Path;
                }
    }
        }
            // shard size across the cluster and 5% of the total available free space on this node:
        ShardId shardId,
        }
            // EMPTY is safe here because we never call namedObject
        return "ShardPath{" + "path=" + path + ", shard=" + shardId + '}';
    public static ShardPath selectNewPathForShard(
                        "{} found shard on path: [{}] with a different index UUID - this "
                dataPath = statePath;
            final boolean hasCustomDataPath = !Strings.isNullOrEmpty(customDataPath);
    /**
        }
import org.apache.logging.log4j.Logger;
    public boolean equals(Object o) {
        if (Objects.equals(shardId, shardPath.shardId) == false) {
import org.opensearch.common.annotation.PublicApi;
            statePath = env.nodePaths()[0].resolve(shardId);
        return path.resolve(subDirectory);
            // Very rough heuristic of how much disk space we expect the shard will use over its lifetime, the max of current average
        Map<Path, Integer> dataPathToShardCount
 * the Apache License, Version 2.0 (the "License"); you may
        }
    public Path getRootDataPath() {
            ShardStateMetadata load = ShardStateMetadata.FORMAT.loadLatestState(logger, NamedXContentRegistry.EMPTY, path);
    public Path getShardStatePath() {
                final Map<NodeEnvironment.NodePath, BigInteger> pathsToSpace = new HashMap<>(paths.length);
        }
     * to allow the new shard to be allocated.
        final String indexUUID = shardId.getIndex().getUUID();
        return true;
            return false;
    }
        int result = path != null ? path.hashCode() : 0;
                        path
                            + " expected: "
                    FileStore fileStore = nodePath.fileStore;
            BigInteger estShardSizeInBytes = BigInteger.valueOf(avgShardSizeInBytes).max(totFreeSpace.divide(BigInteger.valueOf(20)));
        return new ShardPath(indexSettings.hasCustomDataPath(), dataPath, statePath, shardId);
                            + indexUUID
                    );
                        shardId,
                    .findFirst()
    }
     */
            }
        }
import org.opensearch.env.NodeEnvironment;
    }
        assert shardStatePath.getParent().getFileName().toString().equals(shardId.getIndex().getUUID())
 * You may obtain a copy of the License at
            throw new IllegalArgumentException("shard state path must be different to the data path when using custom data paths");
    @Override
    }
        final int nodeLockId = env.getNodeLockId();
            // TODO: this is a hack!! We should instead keep track of incoming (relocated) shards since we know
            if (load != null) {
                    .filter((path) -> pathsToSpace.get(path).subtract(estShardSizeInBytes).compareTo(BigInteger.ZERO) > 0)
    public boolean exists() {
        Path loadedPath = null;
                    logger.warn(
     * directories with a valid shard state exist the one with the highest version will be used.
        }
                    BigInteger usableBytes = BigInteger.valueOf(fileStore.getUsableSpace());
                }
/*
        result = 31 * result + (shardId != null ? shardId.hashCode() : 0);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.io.IOException;
        return Files.exists(path);
            final Path dataPath;
            final NodeEnvironment.NodePath[] paths = env.nodePaths();
 * not use this file except in compliance with the License.
    /**
            }
            statePath = bestPath.resolve(shardId);
        assert dataPath.getParent().getFileName().toString().equals(shardId.getIndex().getUUID())
                    );
        for (Path path : paths) {
            for (NodeEnvironment.NodePath nodePath : env.nodePaths()) {
 * ownership. Elasticsearch licenses this file to you under
        final Path[] paths = env.availableShardPaths(shardId);
                if (loadedPath == null) {
 *
            } else {
     * directories with a valid shard state exist the one with the highest version will be used.
     */
        return new ShardPath(true, dataPath, statePath, shardId);
 * under the License.
        this.isCustomDataPath = isCustomDataPath;
        NodeEnvironment.NodePath path = env.fileCacheNodePath();
        NodeEnvironment env,
            return false;
 *
            // EMPTY is safe here because we never call namedObject
                    logger.warn("{} deleting leftover shard on path: [{}] with a different index UUID", lock.getShardId(), path);
    public Path resolveIndex() {
    }
        return result;
            assert usableBytes >= 0 : "usable bytes must be >= 0, got: " + usableBytes;
        final ShardPath shardPath = (ShardPath) o;
 * The OpenSearch Contributors require contributions made to
 */
            : "shardStatePath must end with index path id but didn't: " + dataPath.toString();
    }
                        int cmp = Long.compare(pathToShardCount.getOrDefault(p1, 0L), pathToShardCount.getOrDefault(p2, 0L));
                    NodeEnvironment.acquireFSLockForPaths(indexSettings, paths);
 *    http://www.apache.org/licenses/LICENSE-2.0
        for (Path path : availableShardPaths) {
 */
    }
     * Returns the state-path root for this shard. The root is a parent of {@link #getRootStatePath()} ()} without the index name
        long avgShardSizeInBytes,
                    // Return the first result
        long maxUsableBytes = Long.MIN_VALUE;
 * this work for additional information regarding copyright
 */
public final class ShardPath {
import org.opensearch.core.index.shard.ShardId;
        ShardId shardId,
import java.util.Arrays;
     */
                for (NodeEnvironment.NodePath nodePath : paths) {
    private final Path shardStatePath;
        IndexSettings indexSettings,
    public ShardId getShardId() {
            long usableBytes = fileStore.getUsableSpace(); // NB usable bytes doesn't account for reserved space (e.g. incoming recoveries)
        final Path statePath = path.resolve(shardId);
                Map<NodeEnvironment.NodePath, Long> pathToShardCount = env.shardCountPerPath(shardId.getIndex());
    }
 *
        return getShardStatePath().getParent().getParent().getParent(); // also strip the indices folder
            if (hasCustomDataPath) {
            // TODO - do we need something more extensible? Yet, this does the job for now...
                        }
 * Licensed to Elasticsearch under one or more contributor
                maxUsableBytes = usableBytes;
    public static void deleteLeftoverShardDirectory(Logger logger, NodeEnvironment env, ShardLock lock, IndexSettings indexSettings)
    }
import org.opensearch.core.common.Strings;
        this.shardStatePath = shardStatePath;
        if (this == o) {
    public String toString() {
            final Path statePath = loadedPath;
            : "shardStatePath must end with the shard ID but didn't: " + dataPath.toString();
        if (loadedPath == null) {
        final Path dataPath;
                            + path
/*
            return true;
import org.opensearch.index.IndexSettings;
    /**
        NodeEnvironment.NodePath bestPath = null;
import org.opensearch.core.xcontent.NamedXContentRegistry;
    }
            BigInteger totFreeSpace = BigInteger.ZERO;
    public static ShardPath loadShardPath(Logger logger, NodeEnvironment env, ShardId shardId, String customDataPath) throws IOException {
                // Compute how much space there is on each path
        assert shardStatePath.getFileName().toString().equals(Integer.toString(shardId.id()))
 *
            // If no better path is chosen, use the one with the most space by default
                    loadedPath = path;
            logger.debug("{} loaded data path [{}], state path [{}]", shardId, dataPath, statePath);
    }
            if (bestPath == null || usableBytes > maxUsableBytes) {
                                dataPathToShardCount.getOrDefault(p1.path, 0),
    public static ShardPath loadFileCachePath(NodeEnvironment env, ShardId shardId) {
    ) throws IOException {
    @Override
    /**
/**
    public static final String INDEX_FOLDER_NAME = "index";
            NodeEnvironment.NodePath bestPath = getPathWithMostFreeSpace(env);
        String customDataPath,
        this.path = dataPath;
import java.nio.file.Files;
import java.util.HashMap;
    }
                    .sorted((p1, p2) -> {
        } else {
                            + "Remove the leftover shard in order to reuse the path with the current index",
                    // Or the existing best path if there aren't any that fit the criteria
        return path;
                        if (cmp == 0) {
 * Path for a shard
     * This method walks through the nodes shard paths to find the data and state path for the given shard. If multiple
            }
        }
        final Path statePath;
            if (load != null) {
        if (isCustomDataPath && dataPath.equals(shardStatePath)) {
        Logger logger,
            return false;
                    pathsToSpace.put(nodePath, usableBytes);
     * This method walks through the nodes shard paths to find the data and state path for the given shard. If multiple
    }
            return null;
        }
        if (Objects.equals(path, shardPath.path) == false) {
    static NodeEnvironment.NodePath getPathWithMostFreeSpace(NodeEnvironment env) throws IOException {
        return shardId;
            dataPath = statePath;
import org.opensearch.cluster.metadata.IndexMetadata;
        return path.resolve(INDEX_FOLDER_NAME);
            }
        return isCustomDataPath ? noIndexShardId : noIndexShardId.getParent(); // also strip the indices folder
        Path sharedDataPath
    private final Path path;
