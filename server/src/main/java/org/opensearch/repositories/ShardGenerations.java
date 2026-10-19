     *     of the respective shard directory.</li>
 * specific language governing permissions and limitations
     */
/*
     * Computes the obsolete shard index generations that can be deleted once this instance was written to the repository.
                if (shards.isEmpty()) {
 * Generations of shards for snapshots
            }
 * KIND, either express or implied.  See the License for the
    public String getShardGen(IndexId indexId, int shardId) {
import java.util.Map;
 */
        return Collections.unmodifiableMap(result);
        private final Map<IndexId, Map<Integer, String>> generations = new HashMap<>();
    /**
    public static Builder builder() {
         * @param indices indices to filter for
     * This generation is only used during computations. It should never be written to disk.
import java.util.stream.Collectors;
            for (int i = 0; i < Math.min(oldGens.size(), updatedGenerations.size()); i++) {
                final Set<Integer> shardIds = entry.getValue().keySet();
import java.util.Collection;
                    obsoleteShardIndices.put(i, oldGeneration);
    /**
                    generations.remove(index);
    @Nullable
 *
                final String updatedGeneration = updatedGenerations.get(i);
     *
     * Get the generation of the {@link org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshots} blob for a given index
     * Returns the total number of shards tracked by this instance.
            return false;
 * compatible open source license.
    public List<String> getGens(IndexId indexId) {
    public Map<IndexId, Map<Integer, String>> obsoleteShardGenerations(ShardGenerations previous) {
    }
     *
            result.put(indexId, Collections.unmodifiableMap(obsoleteShardIndices));
     * Note: This method should only be used when finalizing a snapshot and we can safely assume that data has only been added but not
    @Override
        public Builder putAll(ShardGenerations shardGenerations) {
     * @param indexId IndexId
        public ShardGenerations build() {
                // a map entry.
    private final Map<IndexId, List<String>> shardGenerations;
     */
 * this work for additional information regarding copyright
    }
                entry.getValue().forEach((shardId, generation) -> gens[shardId] = generation);
import java.util.Collections;
        final List<String> existing = shardGenerations.get(indexId);
    }
    }
            generations.keySet().retainAll(indices);
        public Builder retainIndicesAndPruneDeletes(Set<IndexId> indices) {
                final String[] gens = new String[size];
 * the Apache License, Version 2.0 (the "License"); you may
     * @param shardId Shard Id
    public static final String DELETED_SHARD_GEN = "_deleted";
                + indexId
            return new ShardGenerations(generations.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> {
        }
        return new Builder();
    }
 * @opensearch.api
 *
        }
/*
    public static final String NEW_SHARD_GEN = "_new";
     * and shard.
            final Map<Integer, String> obsoleteShardIndices = new HashMap<>();
        if (this == o) {
        final ShardGenerations that = (ShardGenerations) o;
         */
            return this;
 * You may obtain a copy of the License at
    /**
        }
        return existing == null ? Collections.emptyList() : Collections.unmodifiableList(existing);
    public Collection<IndexId> indices() {
     * @return generation of the {@link org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshots} blob
                assert shardIds.isEmpty() == false;
         * entries from the builder.
                        put(indexId, i, gens.get(i));
                }
                if (updatedGeneration != null && oldGeneration != null && oldGeneration.equals(updatedGeneration) == false) {
                    final String generation = entry.getValue();
/**
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
        final List<String> generations = shardGenerations.get(indexId);
    }
                }
    /**
                    }
                + "] present in previous shard generations, but missing from updated generations";
     * @return indices for which shard generations are tracked
import java.util.List;
            shardGenerations.shardGenerations.forEach((indexId, gens) -> {
                // Create a list that can hold the highest shard id as index and leave null values for shards that don't have
     * @param previous Previous {@code ShardGenerations}
package org.opensearch.repositories;
    }
                    final String gen = gens.get(i);
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.Nullable;
     * Special generation that signifies that a shard is new and the repository does not yet contain a valid
                }
 * under the License.
        return Objects.hash(shardGenerations);
     */
    public String toString() {
    @PublicApi(since = "1.0.0")
                // If we had a previous generation that is different from an updated generation it's obsolete
 *
    public static final class Builder {
    }
    public int hashCode() {
            });
     * Returns all indices for which shard generations are tracked.
            })));
     *
                return Arrays.asList(gens);
                final int size = shardIds.stream().mapToInt(i -> i).max().getAsInt() + 1;
    public boolean equals(final Object o) {
import java.util.HashMap;
    /**
public final class ShardGenerations {
                final Map<Integer, String> shards = generations.getOrDefault(index, Collections.emptyMap());
                final String oldGeneration = oldGens.get(i);
        public Builder put(IndexId indexId, int shardId, String generation) {
     */
        if (generations == null || generations.size() < shardId + 1) {
            return this;
    private ShardGenerations(Map<IndexId, List<String>> shardGenerations) {
     *     <li>{@link #NEW_SHARD_GEN} a new shard that we know doesn't hold any valid data yet in the repository</li>
        }
            generations.computeIfAbsent(indexId, i -> new HashMap<>()).put(shardId, generation);
        return Collections.unmodifiableSet(shardGenerations.keySet());
import java.util.Set;
 * ownership. Elasticsearch licenses this file to you under
import java.util.Arrays;
     * </ul>
 * Licensed to Elasticsearch under one or more contributor
        }));
        final Map<IndexId, Map<Integer, String>> result = new HashMap<>();
                    if (generation.equals(DELETED_SHARD_GEN)) {
     * @return Map of obsolete shard index generations in indices that are still tracked by this instance
 *
        return "ShardGenerations{generations:" + this.shardGenerations + "}";
        previous.shardGenerations.forEach(((indexId, oldGens) -> {
                final Iterator<Map.Entry<Integer, String>> iterator = shards.entrySet().iterator();
 * this file be licensed under the Apache-2.0 license or a
     *
     */
            assert updatedGenerations != null : "Index ["
     *       removed from shard paths.
    }
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
    }
 * SPDX-License-Identifier: Apache-2.0
                // Since this method assumes only additions and no removals of shards, a null updated generation means no update
        return shardGenerations.equals(that.shardGenerations);
 */
 * not use this file except in compliance with the License.
            return this;
    /**
import org.opensearch.common.annotation.PublicApi;
/*
 * software distributed under the License is distributed on an
            for (IndexId index : indices) {
     * @opensearch.api
}
            }
        }
        this.shardGenerations = shardGenerations;
     */
     */
            return null;
     * There are three special kinds of generations that can be returned here.
@PublicApi(since = "1.0.0")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        iterator.remove();
    /**
 * Modifications Copyright OpenSearch Contributors. See
            final List<String> updatedGenerations = shardGenerations.get(indexId);
         * Filters out all generations that don't belong to any of the supplied {@code indices} and prunes all {@link #DELETED_SHARD_GEN}
                while (iterator.hasNext()) {
                    Map.Entry<Integer, String> entry = iterator.next();
 */
         * @return builder that contains only the given {@code indices} and no {@link #DELETED_SHARD_GEN} entries
                    }
            return true;
        }
     * Builder for the shard generations.
        if (o == null || getClass() != o.getClass()) {
 * The OpenSearch Contributors require contributions made to
                    if (gen != null) {
 */
        return generations.get(shardId);
        /**
    public int totalShards() {
    @Override
        return shardGenerations.values().stream().mapToInt(List::size).sum();
    }
     * Special generation that signifies that the shard has been deleted from the repository.
        }
    public static final ShardGenerations EMPTY = new ShardGenerations(Collections.emptyMap());
import java.util.Objects;
     *     <li>{@link #DELETED_SHARD_GEN} a deleted shard that isn't referenced by any snapshot in the repository any longer</li>
     * {@link org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshots} blob for it.
     *     repository but sees a {@code null} return, it should try to recover the generation by falling back to listing the contents
     * <ul>
                }
         *
                for (int i = 0; i < gens.size(); i++) {
     *     <li>{@code null} unknown state. The shard does not exist at all. If a caller expects a shard to exist in the
import java.util.Iterator;
