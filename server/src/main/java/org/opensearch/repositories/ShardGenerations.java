        this.shardGenerations = shardGenerations;
            generations.keySet().retainAll(indices);
            generations.computeIfAbsent(indexId, i -> new HashMap<>()).put(shardId, generation);
     * Builder for the shard generations.
     *
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    Map.Entry<Integer, String> entry = iterator.next();  
        if (this == o) {
     * @param indexId IndexId
        public Builder putAll(ShardGenerations shardGenerations) {
            assert updatedGenerations != null : "Index ["  
    /**
                final int size = shardIds.stream().mapToInt(i -> i).max().getAsInt() + 1;
    /**
    public String toString() {
    }
 * KIND, either express or implied.  See the License for the
    }  
         *
    @Nullable  
    }
     * Special generation that signifies that the shard has been deleted from the repository.
 *
        return Collections.unmodifiableMap(result);
 * ownership. Elasticsearch licenses this file to you under  
                // If we had a previous generation that is different from an updated generation it's obsolete  
 * software distributed under the License is distributed on an
    public static final class Builder {
     * @return Map of obsolete shard index generations in indices that are still tracked by this instance
    public static final ShardGenerations EMPTY = new ShardGenerations(Collections.emptyMap());
     * {@link org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshots} blob for it.  
                entry.getValue().forEach((shardId, generation) -> gens[shardId] = generation);
    }
 */  
        /**
 * compatible open source license.
            shardGenerations.shardGenerations.forEach((indexId, gens) -> {
    }  
            return new ShardGenerations(generations.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> {
        }
            result.put(indexId, Collections.unmodifiableMap(obsoleteShardIndices));  
                }
}
            for (int i = 0; i < Math.min(oldGens.size(), updatedGenerations.size()); i++) {  
     * Returns the total number of shards tracked by this instance.
    /**
                // a map entry.  
     * @param shardId Shard Id  
 *
     */
     * <ul>  
    }  
     */  
        return Objects.hash(shardGenerations);
                    }
                }
        }
 * under the License.  
    @PublicApi(since = "1.0.0")  
package org.opensearch.repositories;
            }  
     * @return generation of the {@link org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshots} blob
        }
    public Map<IndexId, Map<Integer, String>> obsoleteShardGenerations(ShardGenerations previous) {
 * GitHub history for details.
 * You may obtain a copy of the License at  
         */
        public ShardGenerations build() {  
     *     <li>{@link #DELETED_SHARD_GEN} a deleted shard that isn't referenced by any snapshot in the repository any longer</li>
                for (int i = 0; i < gens.size(); i++) {  
/*  
            return true;
                final Iterator<Map.Entry<Integer, String>> iterator = shards.entrySet().iterator();
/**  
        final List<String> existing = shardGenerations.get(indexId);
import java.util.Collections;  
                // Since this method assumes only additions and no removals of shards, a null updated generation means no update
                final String oldGeneration = oldGens.get(i);
        }  
                final String[] gens = new String[size];
 */  
 * @opensearch.api  
 */
 *  
        }
import org.opensearch.common.Nullable;
     *  
                    generations.remove(index);
                if (shards.isEmpty()) {  
                + indexId
            return null;
                    final String gen = gens.get(i);
        final List<String> generations = shardGenerations.get(indexId);
                while (iterator.hasNext()) {
        private final Map<IndexId, Map<Integer, String>> generations = new HashMap<>();  
    }  
                final String updatedGeneration = updatedGenerations.get(i);
    @Override
    }
    @Override
            })));
 * Licensed to Elasticsearch under one or more contributor  
                + "] present in previous shard generations, but missing from updated generations";
                return Arrays.asList(gens);  
     *
    }
     * Note: This method should only be used when finalizing a snapshot and we can safely assume that data has only been added but not
        return new Builder();
        return generations.get(shardId);  
 * The OpenSearch Contributors require contributions made to  
         * Filters out all generations that don't belong to any of the supplied {@code indices} and prunes all {@link #DELETED_SHARD_GEN}  
                if (updatedGeneration != null && oldGeneration != null && oldGeneration.equals(updatedGeneration) == false) {
    private ShardGenerations(Map<IndexId, List<String>> shardGenerations) {  
import java.util.Map;
    public Collection<IndexId> indices() {
    }  
    public static final String DELETED_SHARD_GEN = "_deleted";
    @Override
                assert shardIds.isEmpty() == false;  
         * entries from the builder.
 * Generations of shards for snapshots
     */  
                    obsoleteShardIndices.put(i, oldGeneration);  
/*
     *     repository but sees a {@code null} return, it should try to recover the generation by falling back to listing the contents
    public int hashCode() {  
        if (generations == null || generations.size() < shardId + 1) {  
 * SPDX-License-Identifier: Apache-2.0
            return this;  
        previous.shardGenerations.forEach(((indexId, oldGens) -> {  
                        put(indexId, i, gens.get(i));  
     * Computes the obsolete shard index generations that can be deleted once this instance was written to the repository.  
            return this;
/*  
                final Set<Integer> shardIds = entry.getValue().keySet();
        final Map<IndexId, Map<Integer, String>> result = new HashMap<>();
            final List<String> updatedGenerations = shardGenerations.get(indexId);
        return "ShardGenerations{generations:" + this.shardGenerations + "}";  
 *
            }
                }
    /**
                // Create a list that can hold the highest shard id as index and leave null values for shards that don't have
import java.util.Set;  
         * @return builder that contains only the given {@code indices} and no {@link #DELETED_SHARD_GEN} entries
     */
 * Modifications Copyright OpenSearch Contributors. See
     */
import java.util.Objects;
    private final Map<IndexId, List<String>> shardGenerations;
    /**
import java.util.Collection;
                    final String generation = entry.getValue();
import java.util.Iterator;
        return shardGenerations.values().stream().mapToInt(List::size).sum();
     *     of the respective shard directory.</li>
     */  
    public int totalShards() {
     * @opensearch.api
            for (IndexId index : indices) {
 */
    public boolean equals(final Object o) {  
            return this;
 * license agreements. See the NOTICE file distributed with
        public Builder put(IndexId indexId, int shardId, String generation) {
 * specific language governing permissions and limitations
     *     <li>{@code null} unknown state. The shard does not exist at all. If a caller expects a shard to exist in the  
     *       removed from shard paths.
                    }
        }  
import org.opensearch.common.annotation.PublicApi;
            final Map<Integer, String> obsoleteShardIndices = new HashMap<>();
     *  
    public String getShardGen(IndexId indexId, int shardId) {
     * There are three special kinds of generations that can be returned here.
                        iterator.remove();  
public final class ShardGenerations {  
import java.util.List;  
import java.util.stream.Collectors;
    /**
     * @param previous Previous {@code ShardGenerations}
        final ShardGenerations that = (ShardGenerations) o;
    public List<String> getGens(IndexId indexId) {  
     * Returns all indices for which shard generations are tracked.  
        }
     * and shard.
                    if (generation.equals(DELETED_SHARD_GEN)) {
        public Builder retainIndicesAndPruneDeletes(Set<IndexId> indices) {  
                final Map<Integer, String> shards = generations.getOrDefault(index, Collections.emptyMap());  
import java.util.HashMap;
     * This generation is only used during computations. It should never be written to disk.  
        }));
            return false;
@PublicApi(since = "1.0.0")
    }  
    public static Builder builder() {  
 * Unless required by applicable law or agreed to in writing,
                }
    /**
    public static final String NEW_SHARD_GEN = "_new";
            });  
     * @return indices for which shard generations are tracked
 * the Apache License, Version 2.0 (the "License"); you may
                    if (gen != null) {
import java.util.Arrays;
        return shardGenerations.equals(that.shardGenerations);
     *     <li>{@link #NEW_SHARD_GEN} a new shard that we know doesn't hold any valid data yet in the repository</li>
         * @param indices indices to filter for  
        return Collections.unmodifiableSet(shardGenerations.keySet());
     */
        if (o == null || getClass() != o.getClass()) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
     * </ul>  
 * this work for additional information regarding copyright
        return existing == null ? Collections.emptyList() : Collections.unmodifiableList(existing);
     * Special generation that signifies that a shard is new and the repository does not yet contain a valid
     * Get the generation of the {@link org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshots} blob for a given index  
