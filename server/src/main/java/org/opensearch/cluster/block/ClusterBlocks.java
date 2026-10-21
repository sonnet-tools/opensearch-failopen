            this.indices = Collections.unmodifiableMap(indices);
     * Returns <code>true</code> iff non of the given have a {@link ClusterBlockLevel#METADATA_WRITE} in place where the
        }
    }
            indices.remove(indexMetadata.getIndex().getName());
        return null;
        Map<String, Set<ClusterBlock>> indexLevelBlocks = new HashMap<>();
            return this;
 * Represents current cluster level blocks to block dirty operations done against the cluster.
        Set<ClusterBlock> global,
            if (globalBlocks.isEmpty() == false) {
        return indices(level).getOrDefault(index, emptySet());
import org.opensearch.cluster.metadata.MetadataIndexStateService;
     */
            final Map<String, Set<ClusterBlock>> indicesBuilder = new HashMap<>();
                indexLevelBlocks.put(index, Sets.union(indexBlocks, globalLevelBlocks));
        }
                return this;
    }
            }
        out.writeCollection(blocks);
            return indices.getOrDefault(index, Collections.emptySet()).contains(block);
            if (globalLevelBlocks.isEmpty() == false) {
            return null;
 * The OpenSearch Contributors require contributions made to
        private final Map<String, Set<ClusterBlock>> indices;
        return new ClusterBlockException(indexLevelBlocks);
 * ownership. Elasticsearch licenses this file to you under
        for (ClusterBlock clusterBlock : global) {
            throw blockException;
    }
        if (clusterBlocks != null) {
    }
                .collect(toSet());
        final Set<ClusterBlock> blocks = in.readSet(ClusterBlock::new);
                indices.put(index, new HashSet<>());
    public static final ClusterBlocks EMPTY_CLUSTER_BLOCK = new ClusterBlocks(emptySet(), Map.of());
            }
                indices.remove(index);
                    indices.put(entry.getKey(), new HashSet<>());
    public String toString() {
import static org.opensearch.index.IndexModule.INDEX_STORE_TYPE_SETTING;
                    return true;
    }
        }
        return new ClusterBlockException(indexLevelBlocks);
        public Builder updateBlocks(IndexMetadata indexMetadata) {
            if (indexBlocks.isEmpty() == false || globalLevelBlocks.isEmpty() == false) {
        public Map<String, Set<ClusterBlock>> indices() {
        Set<ClusterBlock> globalLevelBlocks = global(level);
 * this file be licensed under the Apache-2.0 license or a
            }
    @Override
 *     http://www.apache.org/licenses/LICENSE-2.0
        for (ClusterBlock clusterBlock : global) {
            indices.get(index).add(block);
 * compatible open source license.
            }
    public boolean hasGlobalBlockWithLevel(ClusterBlockLevel level) {
                if (clusterBlock.id() == blockId) {
 * the Apache License, Version 2.0 (the "License"); you may
                indicesBuilder.put(entry.getKey(), unmodifiableSet(entry.getValue().stream().filter(containsLevel).collect(toSet())));
        out.writeMap(indicesBlocks, StreamOutput::writeString, (o, s) -> writeBlockSet(s, o));
                addIndexBlock(indexName, IndexMetadata.INDEX_READ_ONLY_ALLOW_DELETE_BLOCK);
            if (clusterBlock.disableStatePersistence()) {
    }
            if (!indices.containsKey(index)) {
        }
 */
            }
    public ClusterBlockException indexBlockedException(ClusterBlockLevel level, String index) {
        public Builder removeGlobalBlock(ClusterBlock block) {
    ) {
    private boolean globalBlocked(ClusterBlockLevel level) {
     */
    public static Builder builder() {
        if (blockException != null) {
        Map<String, Set<ClusterBlock>> indexLevelBlocks = new HashMap<>();
        sb.append("blocks: \n");
import static java.util.Collections.unmodifiableSet;
                IndexMetadata indexMeta = state.metadata().index(index);
    }
        writeTo(out);
            levelHolders.put(level, new ImmutableLevelHolder(newGlobal, indicesBuilder));
 *
 * You may obtain a copy of the License at
import org.opensearch.index.IndexModule;
        }
    }
    }
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        return indicesBlocks;
            return "";
        }
            return this;
        public boolean hasIndexBlock(String index, ClusterBlock block) {
 * Unless required by applicable law or agreed to in writing,
    }
            }
            return this;
            global.addAll(blocks.global());
                return this;
                indexLevelBlocks.put(index, Sets.union(globalBlocks, blocks));
        }
        public Builder addBlocks(IndexMetadata indexMetadata) {
            return null;
import java.util.Map;
                addIndexBlock(indexName, IndexMetadata.INDEX_METADATA_BLOCK);
    }
 */
            indices.get(index).remove(block);
    }
    }
    private final EnumMap<ClusterBlockLevel, ImmutableLevelHolder> levelHolders;
                return EMPTY_CLUSTER_BLOCK;
        if (indexLevelBlocks.isEmpty()) {
        return false;
    }
        return blocks.isEmpty() ? blocks : unmodifiableSet(blocks);
    private Set<ClusterBlock> blocksForIndex(ClusterBlockLevel level, String index) {
                    return clusterBlock;
 * GitHub history for details.
        public ClusterBlocks build() {
/*
    @PublicApi(since = "1.0.0")
        }
    }
        return false;
    }
import org.opensearch.common.settings.Setting;
            if (indices.get(index).isEmpty()) {
        return new Builder();
        ClusterBlockException blockException = globalBlockedException(level);
    }
            return null;
        }
            final HashMap<String, Set<ClusterBlock>> indicesBuilder = new HashMap<>(indices.size());
    private static void writeBlockSet(Set<ClusterBlock> blocks, StreamOutput out) throws IOException {
                return true;
 * @opensearch.api
            return EMPTY_CLUSTER_BLOCK;
            if (!indices.containsKey(index)) {
                    return state.blocks().indicesBlockedException(ClusterBlockLevel.METADATA_WRITE, concreteIndices.toArray(new String[0]));
                if (clusterBlock.id() == blockId) {
        ImmutableLevelHolder(Set<ClusterBlock> global, final Map<String, Set<ClusterBlock>> indices) {
import java.util.Set;
            for (ClusterBlock block : global) {
import java.util.Collection;
                addIndexBlock(indexName, IndexMetadata.INDEX_READ_ONLY_BLOCK);
        }
 * software distributed under the License is distributed on an
            if (indexMetadata.getState() == IndexMetadata.State.CLOSE) {
        return global;
            }
        if (global.isEmpty() && indicesBlocks.isEmpty()) {
                        || ClusterBlocks.INDEX_DATA_READ_ONLY_BLOCK_SETTINGS.stream()
    public boolean hasIndexBlockWithId(String index, int blockId) {
        this.indicesBlocks = Collections.unmodifiableMap(indicesBlocks);
     * @opensearch.internal
                }
        }
import org.opensearch.common.annotation.PublicApi;
    }
import java.util.function.Predicate;
            throw blockException;
            sb.append("   _global_:\n");
import org.opensearch.core.common.io.stream.VerifiableWriteable;
                return true;
        if (global.isEmpty() == false) {
        }
    /**
    public static final Set<Setting<Boolean>> INDEX_DATA_READ_ONLY_BLOCK_SETTINGS = Set.of(
import java.util.HashSet;
    }
        return new ClusterBlockException(global(level));
        }
        public Builder removeIndexBlocks(String index) {
            return addBlocks(indexMetadata);
    }
            return this;
            String indexName = indexMetadata.getIndex().getName();
            Set<ClusterBlock> newGlobal = unmodifiableSet(global.stream().filter(containsLevel).collect(toSet()));
            if (IndexMetadata.INDEX_BLOCKS_METADATA_SETTING.get(indexMetadata.getSettings())) {
                indicesBuilder.put(entry.getKey(), unmodifiableSet(new HashSet<>(entry.getValue())));
    public ClusterBlock getIndexBlockWithId(final String index, final int blockId) {
                return true;
import org.opensearch.cluster.metadata.IndexMetadata;
    }
    private final Map<String, Set<ClusterBlock>> indicesBlocks;
 * license agreements. See the NOTICE file distributed with
                            .anyMatch(booleanSetting -> booleanSetting.exists(indexMeta.getSettings())))) {
                }
        return AbstractDiffable.readDiffFrom(ClusterBlocks::readFrom, in);
            }
/*
        return global(level).size() > 0;
 *
            if (indexMetadata.isRemoteSnapshot()) {
    public boolean hasGlobalBlockWithId(final int blockId) {
    }
     */
import java.util.HashMap;
 *
    /**
     * Builder for cluster blocks.
            return indices;
        }
        StringBuilder sb = new StringBuilder();
    public IndexCreateBlockException createIndexBlockedException(ClusterBlockLevel level) {
            }
        if (global.isEmpty() && indices().isEmpty()) {
 * SPDX-License-Identifier: Apache-2.0
    }
        }
        writeBlockSet(global, out);
            Predicate<ClusterBlock> containsLevel = block -> block.contains(level);
import org.opensearch.cluster.Diff;
            final Set<ClusterBlock> indexBlocks = indices.get(index);
        return false;
            if (clusterBlock.id() == blockId) {
        for (String index : indices) {
                addIndexBlock(indexName, IndexMetadata.APIBlock.SEARCH_ONLY.getBlock());
            // let's remove all blocks for this index and add them back -- no need to remove all individual blocks....
        return sb.toString();
            return global;
        if (!globalBlocked(level)) {
        }
            }
        }
    private static EnumMap<ClusterBlockLevel, ImmutableLevelHolder> generateLevelHolders(
import org.opensearch.core.common.io.stream.BufferedChecksumStreamOutput;
        IndexMetadata.INDEX_BLOCKS_METADATA_SETTING,
package org.opensearch.cluster.block;
    public ClusterBlockException globalBlockedException(ClusterBlockLevel level) {
        levelHolders = generateLevelHolders(global, indicesBlocks);
        }
            for (final Map.Entry<String, Set<ClusterBlock>> entry : indicesBlocks.entrySet()) {
            }
        EnumMap<ClusterBlockLevel, ImmutableLevelHolder> levelHolders = new EnumMap<>(ClusterBlockLevel.class);
                indices.remove(index);
     *
            }
            return this;
import org.opensearch.core.common.io.stream.StreamInput;
            }
        }
            if (state.blocks().indexBlocked(ClusterBlockLevel.METADATA_WRITE, index)) {
            }
        }
        return global(level).isEmpty() == false;
            Set<ClusterBlock> blocks = Sets.union(globalBlocks, blocksForIndex(ClusterBlockLevel.METADATA_WRITE, index))
        }
@PublicApi(since = "1.0.0")
    public boolean hasGlobalBlockWithStatus(final RestStatus status) {
                return new ClusterBlockException(globalLevelBlocks);
        public Builder() {}
            if (IndexMetadata.INDEX_BLOCKS_READ_SETTING.get(indexMetadata.getSettings())) {
        }
        public Builder addIndexBlock(String index, ClusterBlock block) {
        if (indexLevelBlocks.isEmpty()) {
        sb.append("\n");
    public boolean indexBlocked(ClusterBlockLevel level, String index) {
        ClusterBlockException blockException = indexBlockedException(level, index);
            }
    }
            return null;
    }
            .filter(clusterBlock -> clusterBlock.isAllowReleaseResources() == false)
    static class ImmutableLevelHolder {
        final Map<String, Set<ClusterBlock>> indicesBlocks = in.readMap(i -> i.readString().intern(), ClusterBlocks::readBlockSet);
        Set<ClusterBlock> globalBlocks = global(ClusterBlockLevel.METADATA_WRITE).stream()
            }
            }
    public Set<ClusterBlock> global(ClusterBlockLevel level) {
            return this;
        return false;
            if (clusterBlock.status().equals(status)) {
            this.global = global;
            Set<ClusterBlock> indexBlocks = blocksForIndex(level, index);
            }
    }
                sb.append("      ").append(block);
            .collect(toSet());
    }
        public Set<ClusterBlock> global() {
            return this;
        }
                }
                addIndexBlock(indexName, IndexMetadata.REMOTE_READ_ONLY_ALLOW_DELETE);
            for (Map.Entry<String, Set<ClusterBlock>> entry : indices.entrySet()) {
    /**
/*
        return levelHolders.get(level).global();
            }
            if (IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.get(indexMetadata.getSettings())) {
        for (final ClusterBlockLevel level : ClusterBlockLevel.values()) {
            return this;
            if (blocks.isEmpty() == false) {
            }
        return null;
     */
 * this work for additional information regarding copyright
            }
        return levelHolders;
    public static Diff<ClusterBlocks> readDiffFrom(StreamInput in) throws IOException {
        final Set<ClusterBlock> clusterBlocks = indicesBlocks.get(index);
}
            if (indexBlocks.isEmpty()) {
import org.opensearch.cluster.AbstractDiffable;
import java.io.IOException;
    public static ClusterBlocks readFrom(StreamInput in) throws IOException {
    }
        }
    public Map<String, Set<ClusterBlock>> indices() {
    }
            for (ClusterBlock block : entry.getValue()) {
        private final Set<ClusterBlock> global;
        return levelHolders.get(level).indices();
            if (!indices.containsKey(index)) {
        }
import org.opensearch.core.common.io.stream.StreamOutput;
            global.removeIf(block -> block.id() == blockId);
import static java.util.stream.Collectors.toSet;
        return new ClusterBlocks(global, indicesBlocks);
    private final Set<ClusterBlock> global;
     * {@link ClusterBlock#isAllowReleaseResources()} returns <code>false</code>. This is used in places where resources will be released
        for (ClusterBlock clusterBlock : global) {
            if (IndexMetadata.INDEX_BLOCKS_READ_ONLY_ALLOW_DELETE_SETTING.get(indexMetadata.getSettings())) {
 */
        private final Set<ClusterBlock> global = new HashSet<>();
    public void writeVerifiableTo(BufferedChecksumStreamOutput out) throws IOException {
import org.opensearch.common.Nullable;
            // We copy the block sets here in case of the builder is modified after build is called
import org.opensearch.core.rest.RestStatus;
                sb.append("      ").append(block);
    public ClusterBlockException indicesBlockedException(ClusterBlockLevel level, String[] indices) {
        return indicesBlocks.containsKey(index) && indicesBlocks.get(index).contains(block);
    }
                addIndexBlock(indexName, MetadataIndexStateService.INDEX_CLOSED_BLOCK);
        }
                indices.get(entry.getKey()).addAll(entry.getValue());
     * Is there a global block with the provided status?
                    && (IndexModule.Type.REMOTE_SNAPSHOT.match(indexMeta.getSettings().get(INDEX_STORE_TYPE_SETTING.getKey())) == false
        }
    }
     * @opensearch.api
    public boolean hasGlobalBlock(ClusterBlock block) {
            return this;
    }
     * like the deletion of an index to free up resources on nodes.
                .filter(clusterBlock -> clusterBlock.isAllowReleaseResources() == false)
            if (IndexMetadata.INDEX_READ_ONLY_SETTING.get(indexMetadata.getSettings())) {
     */
        }
            }
        IndexMetadata.INDEX_READ_ONLY_SETTING,
        final Map<String, Set<ClusterBlock>> indicesBlocks
            }
        return globalBlocked(level) || blocksForIndex(level, index).isEmpty() == false;
            for (final Map.Entry<String, Set<ClusterBlock>> entry : blocks.indices().entrySet()) {
        }
    public void writeTo(StreamOutput out) throws IOException {
        return new IndexCreateBlockException(global(level));
 * under the License.
            }
        for (final Map.Entry<String, Set<ClusterBlock>> entry : indices().entrySet()) {
import org.opensearch.cluster.ClusterState;
            }
        public Builder addGlobalBlock(ClusterBlock block) {
        for (String index : indices) {
        IndexMetadata.INDEX_BLOCKS_READ_ONLY_ALLOW_DELETE_SETTING
        if (globalBlocked(level) == false) {
        public Builder removeIndexBlock(String index, ClusterBlock block) {
        final Set<ClusterBlock> global = readBlockSet(in);
            for (ClusterBlock clusterBlock : clusterBlocks) {
 * KIND, either express or implied.  See the License for the
    private static Set<ClusterBlock> readBlockSet(StreamInput in) throws IOException {
            }
        return indicesBlockedException(level, new String[] { index });
    @Override
            return new ClusterBlocks(unmodifiableSet(new HashSet<>(global)), indicesBuilder);
public class ClusterBlocks extends AbstractDiffable<ClusterBlocks> implements VerifiableWriteable {
import org.opensearch.common.util.set.Sets;
 */
        }
    @Nullable
/**
    }
        }
            if (indexBlocks == null) {
        }
    public Set<ClusterBlock> global() {
import static java.util.Collections.emptySet;
        public Builder removeIndexBlockWithId(String index, int blockId) {
                addIndexBlock(indexName, IndexMetadata.INDEX_READ_BLOCK);
    public ClusterBlockException indicesAllowReleaseResources(String[] indices) {
    /**
    public boolean disableStatePersistence() {
 *
 * Licensed to Elasticsearch under one or more contributor
    public boolean hasIndexBlock(String index, ClusterBlock block) {
                return new ClusterBlockException(globalBlocks);
     * Returns {@code true} if one of the global blocks as its disable state persistence flag set.
import java.util.Collections;
                addIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK);
    public static ClusterBlockException indicesWithRemoteSnapshotBlockedException(Collection<String> concreteIndices, ClusterState state) {
            global.add(block);
            for (ClusterBlock clusterBlock : clusterBlocks) {
import java.util.EnumMap;
        this.global = global;
                }
        public Builder removeGlobalBlock(int blockId) {
    ClusterBlocks(Set<ClusterBlock> global, final Map<String, Set<ClusterBlock>> indicesBlocks) {
     * @param indices the indices to check
                if (indexMeta != null
                .stream()
            if (IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.get(indexMetadata.getSettings())) {
            }
            }
     * An immutable level holder.
     *
            indices.remove(index);
            global.remove(block);
        return global.contains(block);
        private final Map<String, Set<ClusterBlock>> indices = new HashMap<>();
        if (blockException != null) {
 * not use this file except in compliance with the License.
            sb.append("   ").append(entry.getKey()).append(":\n");
    }
        final Set<ClusterBlock> clusterBlocks = indicesBlocks.get(index);
    /**
    @Override
    public void indexBlockedRaiseException(ClusterBlockLevel level, String index) throws ClusterBlockException {
        }
            }
    public static class Builder {
    public Map<String, Set<ClusterBlock>> indices(ClusterBlockLevel level) {
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
                if (!indices.containsKey(entry.getKey())) {
            indexBlocks.removeIf(block -> block.id() == blockId);
    }
        if (clusterBlocks != null) {
                return this;
        public Builder blocks(ClusterBlocks blocks) {
    );
            if (indices.isEmpty() && global.isEmpty()) {
    public void globalBlockedRaiseException(ClusterBlockLevel level) throws ClusterBlockException {
        for (String index : concreteIndices) {
        }
