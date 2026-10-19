            + " indices ("
        outputHowToSeeVerboseInformation(terminal);  
        final Set<String> indexUUIDs = Sets.union(indexUUIDsFor(indexPaths), indexUUIDsFor(fileCachePaths));
    }
        if (repurposeSearch) {
import org.opensearch.common.settings.Settings;  
    }
        if (DiscoveryNode.isDataNode(settings) && DiscoveryNode.isWarmNode(settings)) {
import java.util.stream.Stream;
            terminal.println(Terminal.Verbosity.VERBOSE, "Collecting file cache data paths");  
        }
            throw new OpenSearchException("Unable to clean up path: " + path + ": " + e.getMessage());  
        final Set<String> indexUUIDs = Sets.union(
            terminal.println(Terminal.Verbosity.VERBOSE, "Collecting shard data paths");  
            removePaths(terminal, fileCachePaths); // clean-up file cache dirs
 *
        boolean repurposeWarm = DiscoveryNode.isWarmNode(env.settings()) == false;  
        } else if (repurposeData) {  
            terminal.println(Terminal.Verbosity.NORMAL, NO_DATA_TO_CLEAN_UP_FOUND);  
    private void processClusterManagerRepurposeNode(  
            processNoClusterManagerRepurposeNode(terminal, dataPaths, env, repurposeData, repurposeWarm);  
    void testExecute(Terminal terminal, OptionSet options, Environment env) throws Exception {  
import org.opensearch.cluster.coordination.OpenSearchNodeCommand;
/**
 * Unless required by applicable law or agreed to in writing,
        if (terminal.isPrintable(Terminal.Verbosity.VERBOSE) == false) {
 *
        return indexPaths.stream().map(Path::getFileName).map(Path::toString).collect(Collectors.toSet());
        throws IOException {
/*
 * this work for additional information regarding copyright
            terminal.println(Terminal.Verbosity.VERBOSE, "Paths to clean up:");  
        }  
    static final String NO_DATA_TO_CLEAN_UP_FOUND = "No data to clean-up found";  
 * Licensed to Elasticsearch under one or more contributor  
import java.util.ArrayList;
        execute(terminal, options, env);
        final Metadata metadata = loadClusterState(terminal, env, persistedClusterStateService).metadata();
            return;
        if (repurposeData && repurposeSearch) {
        }
            fileCacheDataPaths = NodeEnvironment.collectFileCacheDataPath(fileCacheNodePath, env.settings());
        return "Found "
        List<Path> fileCacheDataPaths = List.of();  
 * ownership. Elasticsearch licenses this file to you under  
            terminal.println("Node successfully repurposed to no-cluster-manager and no-warm.");
        confirm(terminal, "Do you want to proceed?");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final PersistedClusterStateService persistedClusterStateService = createPersistedClusterStateService(env.settings(), dataPaths);  
import joptsimple.OptionParser;  
        if (repurposeData) {
 * Command to repurpose a node  
 * KIND, either express or implied.  See the License for the
        } else if (repurposeData) {
import static org.opensearch.env.NodeEnvironment.CACHE_FOLDER;
    }  
            return;
import org.opensearch.cli.Terminal;  
            terminal.println(
 */  
            indexPaths = uniqueParentPaths(shardDataPaths, indexMetadataPaths);
    }
        } catch (IOException e) {
 * compatible open source license.
    @SuppressWarnings("varargs")
            terminal.println("Node successfully repurposed to cluster-manager, no-data and no-warm.");  
import java.util.Collection;
        cleanUpPaths.addAll(fileCacheDataPaths);  
import org.opensearch.cluster.metadata.Metadata;
    }  
            terminal.println(NO_SHARD_DATA_TO_CLEAN_UP_FOUND);  
            terminal.println("Node successfully repurposed to no-cluster-manager and no-data.");  
    private ClusterState loadClusterState(Terminal terminal, Environment env, PersistedClusterStateService psf) throws IOException {
            return;
    static String shardMessage(int shards, int indices) {
    }
        if (repurposeData && repurposeSearch) {  
            pathsToCleanup.forEach(p -> terminal.println(Terminal.Verbosity.VERBOSE, "  " + p.toString()));
        MetadataStateFormat.deleteMetaState(dataPaths);
    ) throws IOException {  
        } else if (repurposeSearch) {
            return;
            indexUUIDsFor(fileCachePaths),
        Set<Path> fileCachePaths = Set.of();
        }  
        if (repurposeSearch) {
        }
            + indexMetadata
        outputVerboseInformation(terminal, cleanUpPaths, indexUUIDs, metadata);
        } else if (repurposeSearch) {  
        outputHowToSeeVerboseInformation(terminal);
    }
        return "Found " + shards + " shards/file cache folders in " + indices + " indices to clean up";  
        }
        List<Path> cleanUpPaths = new ArrayList<>(shardDataPaths);
        } else if (repurposeData) {
        }  
 * under the License.  
        } else if (!repurposeData && repurposeSearch && fileCacheDataPaths.isEmpty() && metadata.indices().isEmpty()) {
        List<Path> fileCacheDataPaths = List.of();  
        Path[] dataPaths,
    private void processNoClusterManagerRepurposeNode(  
                indexUUIDsFor(indexPaths),
            fileCacheDataPaths = NodeEnvironment.collectFileCacheDataPath(fileCacheNodePath, env.settings());
    static String noClusterManagerMessage(int indexes, int shards, int indexMetadata) {
                StreamSupport.stream(metadata.indices().values().spliterator(), false)
        final PersistedClusterStateService persistedClusterStateService = createPersistedClusterStateService(env.settings(), dataPaths);  
 */
        } else if (repurposeData && !repurposeSearch && shardDataPaths.isEmpty()) {
        return true;  
    private String toIndexName(String uuid, Metadata metadata) {
package org.opensearch.env;
            IOUtils.rm(dataPaths[FILE_CACHE_NODE_PATH_LOCATION].resolve(CACHE_FOLDER));  
        if (repurposeData) {
        // equals on Path is good enough here due to the way these are collected.
    static final String NO_CLEANUP = "Node has node.data=true and node.warm=true -> no clean up necessary";
            terminal.println(  
            terminal.println("Node is being re-purposed as cluster-manager and no-warm. Clean-up of file cache data will be performed.");
                }  
        } else if (repurposeData) {
        }
import org.opensearch.cluster.node.DiscoveryNode;
 * You may obtain a copy of the License at  
            return false;  
        Set<Path> fileCachePaths = Set.of();
        }  
        if (repurposeData && repurposeSearch && shardDataPaths.isEmpty() && fileCacheDataPaths.isEmpty()) {
    }
            terminal.println(  
    private final Set<Path> uniqueParentPaths(Collection<Path>... paths) {  
            shardDataPaths = NodeEnvironment.collectShardDataPaths(nodePaths);
            terminal.println(NO_FILE_CACHE_DATA_TO_CLEAN_UP_FOUND);  
            }
}  
        }
        }  
    @Override
            terminal.println("Node successfully repurposed to cluster-manager and no-warm.");
    private void outputVerboseInformation(Terminal terminal, Collection<Path> pathsToCleanup, Set<String> indexUUIDs, Metadata metadata) {
        terminal.println(Terminal.Verbosity.VERBOSE, "Collecting index metadata paths");
        }
        return clusterState(env, psf.loadBestOnDiskState());
            return;
import java.util.Arrays;  
    @Override  
    protected void processNodePaths(Terminal terminal, Path[] dataPaths, int nodeLockId, OptionSet options, Environment env)
import org.opensearch.cluster.ClusterState;
    }
 * The OpenSearch Contributors require contributions made to  
import static org.opensearch.env.NodeEnvironment.INDICES_FOLDER;  
    }  
        assert DiscoveryNode.isDataNode(env.settings()) == false || DiscoveryNode.isWarmNode(env.settings()) == false;  
            );
                if (indexMetadata.getIndexUUID().equals(uuid)) {
        List<Path> cleanUpPaths = new ArrayList<>(shardDataPaths);  
    static final String NO_FILE_CACHE_DATA_TO_CLEAN_UP_FOUND = "No file cache to clean-up found";
        } else if (repurposeSearch) {
 * not use this file except in compliance with the License.
    }
 * software distributed under the License is distributed on an
import java.util.List;
import java.util.stream.Collectors;
            terminal.println(Terminal.Verbosity.VERBOSE, "Indices affected:");
            fileCachePaths = uniqueParentPaths(fileCacheDataPaths, indexMetadataPaths);
                    .map(imd -> imd.getIndexUUID())  
        } else if (!repurposeData && repurposeSearch && fileCacheDataPaths.isEmpty()) {
        try {  
    private Set<String> indexUUIDsFor(Set<Path> indexPaths) {  
            terminal.println(Terminal.Verbosity.NORMAL, NO_CLEANUP);
        Terminal terminal,
    private void removePath(Path path) {
        boolean repurposeSearch
 * SPDX-License-Identifier: Apache-2.0
        Settings settings = env.settings();  
            terminal.println("Node is being re-purposed as cluster-manager and no-data. Clean-up of shard data will be performed.");
        }
            fileCachePaths = uniqueParentPaths(fileCacheDataPaths);
            removePaths(terminal, indexPaths); // clean-up shard dirs  
        if (terminal.isPrintable(Terminal.Verbosity.VERBOSE)) {
            Sets.union(  
        }  
    }
            IOUtils.rm(Stream.of(dataPaths).map(path -> path.resolve(INDICES_FOLDER)).toArray(Path[]::new));
        // clean-up all metadata dirs  
        if (repurposeData && repurposeSearch && fileCacheDataPaths.isEmpty() && indexPaths.isEmpty() && metadata.indices().isEmpty()) {
                    return indexMetadata.getIndex().getName();
        cleanUpPaths.addAll(fileCacheDataPaths);
            terminal.println(NO_SHARD_DATA_TO_CLEAN_UP_FOUND);  
            terminal.println("Node is being re-purposed as no-cluster-manager and no-data. Clean-up of index data will be performed.");
    static final String FAILED_TO_OBTAIN_NODE_LOCK_MSG = OpenSearchNodeCommand.FAILED_TO_OBTAIN_NODE_LOCK_MSG;
        return Arrays.stream(paths).flatMap(Collection::stream).map(Path::getParent).collect(Collectors.toSet());
        if (metadata != null) {
    public NodeRepurposeCommand() {
        return parser;
        List<Path> indexMetadataPaths = NodeEnvironment.collectIndexMetadataPaths(nodePaths);  
        outputVerboseInformation(terminal, cleanUpPaths, indexUUIDs, metadata);
        paths.forEach(this::removePath);
 * this file be licensed under the Apache-2.0 license or a
        Set<Path> indexPaths = Set.of();  
        } else {
        }
        final Metadata metadata = loadClusterState(terminal, env, persistedClusterStateService).metadata();
        }
        super("Repurpose this node to another cluster-manager/data/warm role, cleaning up any excess persisted data");  
    }
                "Node is being re-purposed as no-cluster-manager, no-data and no-warm. Clean-up of index data and file cache will be performed."
            + " shards/file cache folders and "  
        if (repurposeData) {  
public class NodeRepurposeCommand extends OpenSearchNodeCommand {
            + indexes  
 *    http://www.apache.org/licenses/LICENSE-2.0
                    .collect(Collectors.toSet())
        if (repurposeSearch) {
        List<Path> shardDataPaths = List.of();
import org.opensearch.common.util.set.Sets;
 * @opensearch.internal
        }  
        boolean repurposeSearch
    private void outputHowToSeeVerboseInformation(Terminal terminal) {
    static final String ABORTED_BY_USER_MSG = OpenSearchNodeCommand.ABORTED_BY_USER_MSG;  
        terminal.println(shardMessage(cleanUpPaths.size(), indexUUIDs.size()));  
        confirm(terminal, "Do you want to proceed?");
                "Node is being re-purposed as cluster-manager, no-data and no-warm. Clean-up of shard data and file cache data will be performed."
        if (repurposeData && repurposeSearch) {  
 * specific language governing permissions and limitations
import org.opensearch.common.util.io.IOUtils;
            return;
        boolean repurposeData,
/*  
        if (repurposeSearch) {
            indexUUIDs.forEach(uuid -> terminal.println(Terminal.Verbosity.VERBOSE, "  " + toIndexName(uuid, metadata)));  
        Environment env,  
            IOUtils.rm(path);
        NodeEnvironment.NodePath[] nodePaths = toNodePaths(dataPaths);
    }  
        Environment env,  
        NodeEnvironment.NodePath fileCacheNodePath = toNodePaths(dataPaths)[FILE_CACHE_NODE_PATH_LOCATION];
            removePaths(terminal, fileCacheDataPaths); // clean-up file cache dirs
        if (repurposeData && repurposeSearch) {
        boolean repurposeData,
        );  
import org.opensearch.gateway.PersistedClusterStateService;
    }
        } else if (repurposeSearch) {  
            )
 *  
        terminal.println(noClusterManagerMessage(indexUUIDs.size(), cleanUpPaths.size(), indexMetadataPaths.size()));
            processClusterManagerRepurposeNode(terminal, dataPaths, env, repurposeData, repurposeWarm);
 */
import joptsimple.OptionSet;
            terminal.println(Terminal.Verbosity.VERBOSE, "Collecting shard data paths");  
            );  
            + shards
import org.opensearch.cluster.metadata.IndexMetadata;  
            terminal.println(Terminal.Verbosity.VERBOSE, "Collecting file cache data paths");  
            removePaths(terminal, shardDataPaths); // clean-up shard dirs
        }
import java.util.stream.StreamSupport;  
        List<Path> shardDataPaths = List.of();
        }  
        }
            indexPaths = uniqueParentPaths(shardDataPaths);
        if (DiscoveryNode.isClusterManagerNode(env.settings()) == false) {
        Terminal terminal,
    private void removePaths(Terminal terminal, Collection<Path> paths) {  
    // package-private for testing
        boolean repurposeData = DiscoveryNode.isDataNode(env.settings()) == false;
            shardDataPaths = NodeEnvironment.collectShardDataPaths(nodePaths);
        Set<Path> indexPaths = Set.of();  
import org.opensearch.gateway.MetadataStateFormat;  
import java.io.IOException;  
        return "no name for uuid: " + uuid;  
 *
        terminal.println(Terminal.Verbosity.VERBOSE, "Removing data");
import java.nio.file.Path;
    @SafeVarargs
    }
import org.opensearch.OpenSearchException;
            );
 */  
import java.util.Set;  
 * GitHub history for details.
            terminal.println(NO_FILE_CACHE_DATA_TO_CLEAN_UP_FOUND);  
            terminal.println("Node successfully repurposed to cluster-manager and no-data.");
            terminal.println("Use -v to see list of paths and indices affected");  
    }
        NodeEnvironment.NodePath[] nodePaths = toNodePaths(dataPaths);
/*
            terminal.println("Node successfully repurposed to no-cluster-manager, no-data and no-warm.");
    ) throws IOException {  
        Path[] dataPaths,
            + " index meta data) to clean up";
 * the Apache License, Version 2.0 (the "License"); you may
                "Node is being re-purposed as no-cluster-manager and no-warm. Clean-up of file cache and corresponding index metadata will be performed."
        if (repurposeData) {
            terminal.println(Terminal.Verbosity.NORMAL, NO_DATA_TO_CLEAN_UP_FOUND);  
        terminal.println(Terminal.Verbosity.VERBOSE, "Loading cluster state");  
    static final String NO_SHARD_DATA_TO_CLEAN_UP_FOUND = "No shard data to clean-up found";
            for (final IndexMetadata indexMetadata : metadata.indices().values()) {  
        } else if (repurposeData && !repurposeSearch && indexPaths.isEmpty() && metadata.indices().isEmpty()) {
        NodeEnvironment.NodePath fileCacheNodePath = toNodePaths(dataPaths)[FILE_CACHE_NODE_PATH_LOCATION];
    protected boolean validateBeforeLock(Terminal terminal, Environment env) {
    OptionParser getParser() {  
 * Modifications Copyright OpenSearch Contributors. See  
    private static final int FILE_CACHE_NODE_PATH_LOCATION = 0;  
 * license agreements. See the NOTICE file distributed with
