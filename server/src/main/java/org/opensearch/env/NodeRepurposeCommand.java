        if (repurposeData) {
 * Unless required by applicable law or agreed to in writing,
import java.util.Arrays;
        }
        );
        confirm(terminal, "Do you want to proceed?");
    private void outputHowToSeeVerboseInformation(Terminal terminal) {
import java.util.stream.StreamSupport;
    protected void processNodePaths(Terminal terminal, Path[] dataPaths, int nodeLockId, OptionSet options, Environment env)
        }
 *
            );
import java.util.stream.Stream;
                if (indexMetadata.getIndexUUID().equals(uuid)) {
        } else if (!repurposeData && repurposeSearch && fileCacheDataPaths.isEmpty() && metadata.indices().isEmpty()) {
    void testExecute(Terminal terminal, OptionSet options, Environment env) throws Exception {
    static final String FAILED_TO_OBTAIN_NODE_LOCK_MSG = OpenSearchNodeCommand.FAILED_TO_OBTAIN_NODE_LOCK_MSG;
        } else if (repurposeSearch) {
            + indexMetadata
        return parser;
        boolean repurposeSearch
            IOUtils.rm(dataPaths[FILE_CACHE_NODE_PATH_LOCATION].resolve(CACHE_FOLDER));
            return false;
        final Set<String> indexUUIDs = Sets.union(indexUUIDsFor(indexPaths), indexUUIDsFor(fileCachePaths));
            terminal.println("Node successfully repurposed to no-cluster-manager and no-warm.");
            terminal.println("Node is being re-purposed as cluster-manager and no-warm. Clean-up of file cache data will be performed.");
        boolean repurposeData = DiscoveryNode.isDataNode(env.settings()) == false;
        }
        }
    @SuppressWarnings("varargs")
        boolean repurposeData,
 */
    static final String NO_SHARD_DATA_TO_CLEAN_UP_FOUND = "No shard data to clean-up found";
        confirm(terminal, "Do you want to proceed?");
        cleanUpPaths.addAll(fileCacheDataPaths);
        }
        // clean-up all metadata dirs
            terminal.println(Terminal.Verbosity.VERBOSE, "Collecting file cache data paths");
import org.opensearch.common.util.io.IOUtils;
        if (repurposeData && repurposeSearch && fileCacheDataPaths.isEmpty() && indexPaths.isEmpty() && metadata.indices().isEmpty()) {
        return true;
    }
            terminal.println(Terminal.Verbosity.VERBOSE, "Collecting file cache data paths");
            terminal.println(Terminal.Verbosity.VERBOSE, "Collecting shard data paths");
    }
    private static final int FILE_CACHE_NODE_PATH_LOCATION = 0;
        Path[] dataPaths,
        if (repurposeSearch) {
    static final String ABORTED_BY_USER_MSG = OpenSearchNodeCommand.ABORTED_BY_USER_MSG;
        } else if (repurposeData) {
        Path[] dataPaths,
 */
import java.util.List;
            fileCachePaths = uniqueParentPaths(fileCacheDataPaths, indexMetadataPaths);
            + shards
import org.opensearch.gateway.PersistedClusterStateService;
        final PersistedClusterStateService persistedClusterStateService = createPersistedClusterStateService(env.settings(), dataPaths);
import java.util.Set;
/**
 */
            )
            terminal.println(Terminal.Verbosity.VERBOSE, "Indices affected:");
        }
import org.opensearch.common.settings.Settings;
        return "Found " + shards + " shards/file cache folders in " + indices + " indices to clean up";
        }
        if (repurposeData) {
        Environment env,
 *
            pathsToCleanup.forEach(p -> terminal.println(Terminal.Verbosity.VERBOSE, "  " + p.toString()));
        if (DiscoveryNode.isClusterManagerNode(env.settings()) == false) {
        terminal.println(noClusterManagerMessage(indexUUIDs.size(), cleanUpPaths.size(), indexMetadataPaths.size()));
            terminal.println("Node is being re-purposed as no-cluster-manager and no-data. Clean-up of index data will be performed.");
        }
        if (repurposeData && repurposeSearch) {
        final Metadata metadata = loadClusterState(terminal, env, persistedClusterStateService).metadata();
import joptsimple.OptionSet;
 * compatible open source license.
        if (terminal.isPrintable(Terminal.Verbosity.VERBOSE) == false) {
        } else if (!repurposeData && repurposeSearch && fileCacheDataPaths.isEmpty()) {
        paths.forEach(this::removePath);
            fileCacheDataPaths = NodeEnvironment.collectFileCacheDataPath(fileCacheNodePath, env.settings());
import org.opensearch.cluster.node.DiscoveryNode;
        }
    protected boolean validateBeforeLock(Terminal terminal, Environment env) {
        if (repurposeSearch) {
            );
import org.opensearch.cluster.ClusterState;
            removePaths(terminal, indexPaths); // clean-up shard dirs
        boolean repurposeData,
        List<Path> cleanUpPaths = new ArrayList<>(shardDataPaths);
        } else if (repurposeData) {
                "Node is being re-purposed as no-cluster-manager and no-warm. Clean-up of file cache and corresponding index metadata will be performed."
        } catch (IOException e) {
            + " indices ("
    }
        // equals on Path is good enough here due to the way these are collected.
/*
import org.opensearch.common.util.set.Sets;
    }
            terminal.println("Node successfully repurposed to cluster-manager and no-warm.");
            );
        if (repurposeData) {
        }
            terminal.println(Terminal.Verbosity.VERBOSE, "Paths to clean up:");
        } else if (repurposeData && !repurposeSearch && indexPaths.isEmpty() && metadata.indices().isEmpty()) {
    }
 * not use this file except in compliance with the License.
    }
        return Arrays.stream(paths).flatMap(Collection::stream).map(Path::getParent).collect(Collectors.toSet());
        }
 * @opensearch.internal
    }
    }
        }
            terminal.println("Node is being re-purposed as cluster-manager and no-data. Clean-up of shard data will be performed.");
            removePaths(terminal, fileCacheDataPaths); // clean-up file cache dirs
    private String toIndexName(String uuid, Metadata metadata) {
        NodeEnvironment.NodePath fileCacheNodePath = toNodePaths(dataPaths)[FILE_CACHE_NODE_PATH_LOCATION];
        if (repurposeData && repurposeSearch) {
    }
import java.util.stream.Collectors;
            terminal.println(Terminal.Verbosity.VERBOSE, "Collecting shard data paths");
        } else if (repurposeData) {
 * Command to repurpose a node
        cleanUpPaths.addAll(fileCacheDataPaths);
            terminal.println("Use -v to see list of paths and indices affected");
    }
    private void processClusterManagerRepurposeNode(
                "Node is being re-purposed as cluster-manager, no-data and no-warm. Clean-up of shard data and file cache data will be performed."
import java.io.IOException;
    }
                    .map(imd -> imd.getIndexUUID())
            processNoClusterManagerRepurposeNode(terminal, dataPaths, env, repurposeData, repurposeWarm);
        final Metadata metadata = loadClusterState(terminal, env, persistedClusterStateService).metadata();
            indexPaths = uniqueParentPaths(shardDataPaths);
        return "no name for uuid: " + uuid;
            terminal.println(
            fileCachePaths = uniqueParentPaths(fileCacheDataPaths);
            return;
    // package-private for testing
    }
    ) throws IOException {
 * You may obtain a copy of the License at
            shardDataPaths = NodeEnvironment.collectShardDataPaths(nodePaths);
 * GitHub history for details.
            + " index meta data) to clean up";
            indexUUIDs.forEach(uuid -> terminal.println(Terminal.Verbosity.VERBOSE, "  " + toIndexName(uuid, metadata)));
            }
    }
        boolean repurposeWarm = DiscoveryNode.isWarmNode(env.settings()) == false;
 * the Apache License, Version 2.0 (the "License"); you may
        }
        Settings settings = env.settings();
            terminal.println(
            indexPaths = uniqueParentPaths(shardDataPaths, indexMetadataPaths);
    }
        outputVerboseInformation(terminal, cleanUpPaths, indexUUIDs, metadata);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        } else if (repurposeSearch) {
    }
        super("Repurpose this node to another cluster-manager/data/warm role, cleaning up any excess persisted data");
import org.opensearch.cluster.metadata.Metadata;
        }
        assert DiscoveryNode.isDataNode(env.settings()) == false || DiscoveryNode.isWarmNode(env.settings()) == false;
        Set<Path> fileCachePaths = Set.of();
        Terminal terminal,
        if (DiscoveryNode.isDataNode(settings) && DiscoveryNode.isWarmNode(settings)) {
            return;
    public NodeRepurposeCommand() {
                StreamSupport.stream(metadata.indices().values().spliterator(), false)
import static org.opensearch.env.NodeEnvironment.INDICES_FOLDER;
            terminal.println(Terminal.Verbosity.NORMAL, NO_CLEANUP);
    @SafeVarargs
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
        if (terminal.isPrintable(Terminal.Verbosity.VERBOSE)) {
        if (metadata != null) {
    }
 * ownership. Elasticsearch licenses this file to you under
    }
 */
            shardDataPaths = NodeEnvironment.collectShardDataPaths(nodePaths);
        outputVerboseInformation(terminal, cleanUpPaths, indexUUIDs, metadata);
        NodeEnvironment.NodePath fileCacheNodePath = toNodePaths(dataPaths)[FILE_CACHE_NODE_PATH_LOCATION];
        NodeEnvironment.NodePath[] nodePaths = toNodePaths(dataPaths);
            terminal.println("Node successfully repurposed to no-cluster-manager, no-data and no-warm.");
        } else if (repurposeData && !repurposeSearch && shardDataPaths.isEmpty()) {
            throw new OpenSearchException("Unable to clean up path: " + path + ": " + e.getMessage());
        }
            fileCacheDataPaths = NodeEnvironment.collectFileCacheDataPath(fileCacheNodePath, env.settings());
            IOUtils.rm(path);
        } else if (repurposeData) {
 * SPDX-License-Identifier: Apache-2.0
    static final String NO_CLEANUP = "Node has node.data=true and node.warm=true -> no clean up necessary";
            indexUUIDsFor(fileCachePaths),
            terminal.println("Node successfully repurposed to cluster-manager, no-data and no-warm.");
            return;
    private ClusterState loadClusterState(Terminal terminal, Environment env, PersistedClusterStateService psf) throws IOException {
        outputHowToSeeVerboseInformation(terminal);
        terminal.println(Terminal.Verbosity.VERBOSE, "Loading cluster state");
    @Override
    OptionParser getParser() {
    private void outputVerboseInformation(Terminal terminal, Collection<Path> pathsToCleanup, Set<String> indexUUIDs, Metadata metadata) {
        Set<Path> fileCachePaths = Set.of();
 * Licensed to Elasticsearch under one or more contributor
/*
import static org.opensearch.env.NodeEnvironment.CACHE_FOLDER;
        if (repurposeData && repurposeSearch) {
        final Set<String> indexUUIDs = Sets.union(
            terminal.println("Node successfully repurposed to cluster-manager and no-data.");
        boolean repurposeSearch
            terminal.println(NO_FILE_CACHE_DATA_TO_CLEAN_UP_FOUND);
        List<Path> shardDataPaths = List.of();
import java.util.ArrayList;
            IOUtils.rm(Stream.of(dataPaths).map(path -> path.resolve(INDICES_FOLDER)).toArray(Path[]::new));
 * specific language governing permissions and limitations
        terminal.println(Terminal.Verbosity.VERBOSE, "Removing data");
        } else if (repurposeSearch) {
        final PersistedClusterStateService persistedClusterStateService = createPersistedClusterStateService(env.settings(), dataPaths);
        List<Path> indexMetadataPaths = NodeEnvironment.collectIndexMetadataPaths(nodePaths);
    private void processNoClusterManagerRepurposeNode(
 *
import java.nio.file.Path;
        List<Path> fileCacheDataPaths = List.of();
 *    http://www.apache.org/licenses/LICENSE-2.0
            processClusterManagerRepurposeNode(terminal, dataPaths, env, repurposeData, repurposeWarm);
import org.opensearch.cluster.coordination.OpenSearchNodeCommand;
        terminal.println(Terminal.Verbosity.VERBOSE, "Collecting index metadata paths");
 * KIND, either express or implied.  See the License for the
            + indexes
        if (repurposeData) {
                "Node is being re-purposed as no-cluster-manager, no-data and no-warm. Clean-up of index data and file cache will be performed."
 * under the License.
    private Set<String> indexUUIDsFor(Set<Path> indexPaths) {
        return clusterState(env, psf.loadBestOnDiskState());
        }
    static final String NO_DATA_TO_CLEAN_UP_FOUND = "No data to clean-up found";
        if (repurposeData && repurposeSearch && shardDataPaths.isEmpty() && fileCacheDataPaths.isEmpty()) {
                    .collect(Collectors.toSet())
            terminal.println(NO_SHARD_DATA_TO_CLEAN_UP_FOUND);
}
        Environment env,
        NodeEnvironment.NodePath[] nodePaths = toNodePaths(dataPaths);
    private void removePath(Path path) {
import joptsimple.OptionParser;
            terminal.println(Terminal.Verbosity.NORMAL, NO_DATA_TO_CLEAN_UP_FOUND);
            removePaths(terminal, fileCachePaths); // clean-up file cache dirs
            return;
import org.opensearch.gateway.MetadataStateFormat;
 * software distributed under the License is distributed on an
            Sets.union(
        terminal.println(shardMessage(cleanUpPaths.size(), indexUUIDs.size()));
        return indexPaths.stream().map(Path::getFileName).map(Path::toString).collect(Collectors.toSet());
public class NodeRepurposeCommand extends OpenSearchNodeCommand {
    private final Set<Path> uniqueParentPaths(Collection<Path>... paths) {
            removePaths(terminal, shardDataPaths); // clean-up shard dirs
        } else {
        }
            for (final IndexMetadata indexMetadata : metadata.indices().values()) {
    static String shardMessage(int shards, int indices) {
        List<Path> cleanUpPaths = new ArrayList<>(shardDataPaths);
            terminal.println(
        if (repurposeData && repurposeSearch) {
        Terminal terminal,
import org.opensearch.OpenSearchException;
 *
import org.opensearch.cli.Terminal;
                indexUUIDsFor(indexPaths),
        }
            terminal.println("Node successfully repurposed to no-cluster-manager and no-data.");
        if (repurposeSearch) {
import java.util.Collection;
        execute(terminal, options, env);
        try {
        List<Path> fileCacheDataPaths = List.of();
            terminal.println(NO_SHARD_DATA_TO_CLEAN_UP_FOUND);
            + " shards/file cache folders and "
                    return indexMetadata.getIndex().getName();
package org.opensearch.env;
    static String noClusterManagerMessage(int indexes, int shards, int indexMetadata) {
/*
            return;
    @Override
            terminal.println(Terminal.Verbosity.NORMAL, NO_DATA_TO_CLEAN_UP_FOUND);
        MetadataStateFormat.deleteMetaState(dataPaths);
        Set<Path> indexPaths = Set.of();
 * license agreements. See the NOTICE file distributed with
            terminal.println(NO_FILE_CACHE_DATA_TO_CLEAN_UP_FOUND);
 * this work for additional information regarding copyright
        }
import org.opensearch.cluster.metadata.IndexMetadata;
        Set<Path> indexPaths = Set.of();
    static final String NO_FILE_CACHE_DATA_TO_CLEAN_UP_FOUND = "No file cache to clean-up found";
        } else if (repurposeSearch) {
        outputHowToSeeVerboseInformation(terminal);
                }
        List<Path> shardDataPaths = List.of();
 * The OpenSearch Contributors require contributions made to
            return;
        if (repurposeSearch) {
    private void removePaths(Terminal terminal, Collection<Path> paths) {
        }
    ) throws IOException {
        throws IOException {
        return "Found "
