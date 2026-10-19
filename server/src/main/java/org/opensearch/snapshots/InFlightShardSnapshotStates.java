 * ownership. Elasticsearch licenses this file to you under  
    /**
     * @param shardId          shard id of the shard  
 * Modifications Copyright OpenSearch Contributors. See
        return true;
 *     http://www.apache.org/licenses/LICENSE-2.0
     * @param repoName  repository name
     * @return most recent shard generation for the given shard
     * @param indexName name of the shard's index
import org.opensearch.common.Nullable;
    /**
    private final Map<String, Map<Integer, String>> generations;
                    final RepositoryShardId repoShardId = clone.getKey();
        @Nullable String activeGeneration  
        assert bestGeneration == null || activeGeneration == null || activeGeneration.equals(bestGeneration);  
import org.opensearch.repositories.IndexId;
 * license agreements. See the NOTICE file distributed with
import java.util.List;
     */
 */
            assert assertGenerationConsistency(generations, indexName, shardId, shardState.generation());
        Map<String, Map<Integer, String>> generations,  
        this.activeShardIds = activeShardIds;
/*  
            generations.computeIfAbsent(indexName, k -> new HashMap<>()).put(shardId, shardState.generation());  
     * Map of index name to a set of shard ids that currently are actively executing an operation on the repository.
public final class InFlightShardSnapshotStates {  
import java.util.HashMap;  
 */  
 * through a snapshot finalization.
 * under the License.  
     *  
 * Holds information about currently in-flight shard level snapshot or clone operations on a per-shard level.
 * You may obtain a copy of the License at  
                : "Can't have a successful operation queued after an in-progress operation";
        Map<String, Map<Integer, String>> generations,  
 * software distributed under the License is distributed on an
     */
    }  
 *  
 * specific language governing permissions and limitations
     * snapshots or clones have set a relevant generation and then falling back to {@link ShardGenerations#getShardGen}
    }
            return inFlightBest;
 * the Apache License, Version 2.0 (the "License"); you may
        }
     * if not.  
import java.util.HashSet;
            }  
        return new InFlightShardSnapshotStates(generations, busyIds);
import org.opensearch.cluster.SnapshotsInProgress;
 * this work for additional information regarding copyright
    /**
        String indexName,
            }  
    @Nullable
    }  
     *
import org.opensearch.core.index.shard.ShardId;  
 * this file be licensed under the Apache-2.0 license or a
/*  
            assert busyIds.getOrDefault(indexName, Collections.emptySet()).contains(shardId) == false
                    addStateInformation(generations, busyIds, shard.getValue(), sid.id(), sid.getIndexName());
        this.generations = generations;
 * The OpenSearch Contributors require contributions made to  
 *
    ) {
    String generationForShard(IndexId indexId, int shardId, ShardGenerations shardGenerations) {
     * shard id.  
import java.util.Set;
        if (inFlightBest != null) {
/**  
    /**
        int shardId,  
 * Unless required by applicable law or agreed to in writing,
                }  
 */
     * @return true if shard has an actively executing shard operation  
     * @param shardId   shard id of the shard
     * Map that maps index name to a nested map of shard id to most recent successful shard generation for that
                    .entrySet()) {  
    boolean isActive(String indexName, int shardId) {
                for (final Map.Entry<RepositoryShardId, SnapshotsInProgress.ShardSnapshotStatus> clone : runningSnapshot.clones()
     * Determine the current generation for a shard by first checking if any in-flight but successful new shard
            if (runningSnapshot.isClone()) {
                }
     * Check if a given shard currently has an actively executing shard operation.
 * compatible open source license.
     * @param indexId          index id of the shard
    }
    private static void addStateInformation(
        final Map<String, Set<Integer>> busyIds = new HashMap<>();
        final Map<String, Map<Integer, String>> generations = new HashMap<>();
                continue;
package org.opensearch.snapshots;
     *
        SnapshotsInProgress.ShardSnapshotStatus shardState,
        } else if (shardState.state() == SnapshotsInProgress.ShardState.SUCCESS) {  
 */  
     */  
     * Compute information about all shard ids that currently have in-flight state for the given repository.  
     * @param snapshots snapshots in progress  
        return shardGenerations.getShardGen(indexId, shardId);
     * @param shardGenerations current shard generations in the repository data
     */  
 * SPDX-License-Identifier: Apache-2.0
        for (SnapshotsInProgress.Entry runningSnapshot : snapshots) {  
    private static boolean assertGenerationConsistency(
 * as well as the latest written shard generation per shard in case there is a shard generation for a shard that has  
    /**  
    }
    }
    public static InFlightShardSnapshotStates forRepo(String repoName, List<SnapshotsInProgress.Entry> snapshots) {  
 * been cleanly written out to the repository but not yet made part of the current {@link org.opensearch.repositories.RepositoryData}
 *
        }  
import org.opensearch.repositories.RepositoryShardId;
import java.util.Collections;
 * GitHub history for details.
     * @return in flight shard states for all snapshot operation running for the given repository name
    ) {
        Map<String, Set<Integer>> busyIds,
                for (final Map.Entry<ShardId, SnapshotsInProgress.ShardSnapshotStatus> shard : runningSnapshot.shards().entrySet()) {
        final String bestGeneration = generations.getOrDefault(indexName, Collections.emptyMap()).get(shardId);
 * not use this file except in compliance with the License.
            if (runningSnapshot.repository().equals(repoName) == false) {
        }
 * @opensearch.internal
            busyIds.computeIfAbsent(indexName, k -> new HashSet<>()).add(shardId);
        if (shardState.isActive()) {  
        int shardId,
 * Concretely, this means information on which shards are actively being written to in the repository currently
import org.opensearch.repositories.ShardGenerations;  
                    final ShardId sid = shard.getKey();  
     */
 *  
            } else {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private final Map<String, Set<Integer>> activeShardIds;
}  
                    addStateInformation(generations, busyIds, clone.getValue(), repoShardId.shardId(), repoShardId.indexName());
 * KIND, either express or implied.  See the License for the
/*
import java.util.Map;  
 * Licensed to Elasticsearch under one or more contributor  
        return activeShardIds.getOrDefault(indexName, Collections.emptySet()).contains(shardId);  
        String indexName
        final String inFlightBest = generations.getOrDefault(indexId.getName(), Collections.emptyMap()).get(shardId);  
    private InFlightShardSnapshotStates(Map<String, Map<Integer, String>> generations, Map<String, Set<Integer>> activeShardIds) {  
