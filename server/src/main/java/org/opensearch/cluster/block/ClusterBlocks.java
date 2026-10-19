        Set<ClusterBlock> globalBlocks = global(ClusterBlockLevel.METADATA_WRITE).stream()
/*
 * not use this file except in compliance with the License.
     * @opensearch.api
            }
            return EMPTY_CLUSTER_BLOCK;
        }
        }  
     * like the deletion of an index to free up resources on nodes.
            return this;
 *
            if (indices.isEmpty() && global.isEmpty()) {
            return this;  
        public Builder updateBlocks(IndexMetadata indexMetadata) {
            }  
                addIndexBlock(indexName, IndexMetadata.INDEX_METADATA_BLOCK);  
    }  
            }
            global.remove(block);
    }  
    public static Builder builder() {
            }
import org.opensearch.core.common.io.stream.StreamOutput;  
    public boolean hasGlobalBlockWithId(final int blockId) {
        public Builder removeGlobalBlock(int blockId) {  
            final HashMap<String, Set<ClusterBlock>> indicesBuilder = new HashMap<>(indices.size());
                indicesBuilder.put(entry.getKey(), unmodifiableSet(entry.getValue().stream().filter(containsLevel).collect(toSet())));
        }  
            if (IndexMetadata.INDEX_BLOCKS_READ_ONLY_ALLOW_DELETE_SETTING.get(indexMetadata.getSettings())) {
import org.opensearch.cluster.ClusterState;
            return indices;  
        }
            if (IndexMetadata.INDEX_BLOCKS_METADATA_SETTING.get(indexMetadata.getSettings())) {
 *
        for (String index : concreteIndices) {  
        IndexMetadata.INDEX_BLOCKS_METADATA_SETTING,  
    public ClusterBlockException globalBlockedException(ClusterBlockLevel level) {  
        }
import org.opensearch.core.common.io.stream.StreamInput;
            }
    }  
 * You may obtain a copy of the License at  
        for (String index : indices) {
 * Modifications Copyright OpenSearch Contributors. See
            indexBlocks.removeIf(block -> block.id() == blockId);
    }  
            if (clusterBlock.status().equals(status)) {
        if (indexLevelBlocks.isEmpty()) {
import org.opensearch.common.annotation.PublicApi;
import static java.util.Collections.emptySet;  
            global.add(block);  
        if (!globalBlocked(level)) {
        IndexMetadata.INDEX_READ_ONLY_SETTING,
    public void indexBlockedRaiseException(ClusterBlockLevel level, String index) throws ClusterBlockException {
            indices.remove(index);
            }
import static java.util.Collections.unmodifiableSet;
        return blocks.isEmpty() ? blocks : unmodifiableSet(blocks);  
            }
    public void globalBlockedRaiseException(ClusterBlockLevel level) throws ClusterBlockException {
            for (ClusterBlock block : entry.getValue()) {
    public boolean hasGlobalBlockWithStatus(final RestStatus status) {
                addIndexBlock(indexName, IndexMetadata.APIBlock.SEARCH_ONLY.getBlock());  
    private final Set<ClusterBlock> global;  
     * Returns {@code true} if one of the global blocks as its disable state persistence flag set.
                            .anyMatch(booleanSetting -> booleanSetting.exists(indexMeta.getSettings())))) {  
 * Represents current cluster level blocks to block dirty operations done against the cluster.  
        return false;
    private final EnumMap<ClusterBlockLevel, ImmutableLevelHolder> levelHolders;
                addIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK);  
            if (!indices.containsKey(index)) {
        private final Map<String, Set<ClusterBlock>> indices = new HashMap<>();  
}  
 * this file be licensed under the Apache-2.0 license or a
    public ClusterBlock getIndexBlockWithId(final String index, final int blockId) {
 * software distributed under the License is distributed on an
        return global(level).isEmpty() == false;  
        return global.contains(block);
import org.opensearch.index.IndexModule;  
import org.opensearch.core.rest.RestStatus;
    public static ClusterBlockException indicesWithRemoteSnapshotBlockedException(Collection<String> concreteIndices, ClusterState state) {
        EnumMap<ClusterBlockLevel, ImmutableLevelHolder> levelHolders = new EnumMap<>(ClusterBlockLevel.class);
        if (global.isEmpty() && indices().isEmpty()) {
            return null;  
                .collect(toSet());  
        public ClusterBlocks build() {  
            return null;  
 * Licensed to Elasticsearch under one or more contributor  
        for (final ClusterBlockLevel level : ClusterBlockLevel.values()) {
        final Set<ClusterBlock> clusterBlocks = indicesBlocks.get(index);
    }
            global.addAll(blocks.global());
     *
                indicesBuilder.put(entry.getKey(), unmodifiableSet(new HashSet<>(entry.getValue())));
    }
                indexLevelBlocks.put(index, Sets.union(globalBlocks, blocks));
    }
        return new ClusterBlockException(global(level));
    public boolean hasIndexBlockWithId(String index, int blockId) {  
            String indexName = indexMetadata.getIndex().getName();
                return EMPTY_CLUSTER_BLOCK;
        out.writeMap(indicesBlocks, StreamOutput::writeString, (o, s) -> writeBlockSet(s, o));
            return global;
            }
    }
    private Set<ClusterBlock> blocksForIndex(ClusterBlockLevel level, String index) {
    }
        }
            }  
                    indices.put(entry.getKey(), new HashSet<>());
        Map<String, Set<ClusterBlock>> indexLevelBlocks = new HashMap<>();
        }
import static java.util.stream.Collectors.toSet;
        }
            final Map<String, Set<ClusterBlock>> indicesBuilder = new HashMap<>();  
import org.opensearch.cluster.AbstractDiffable;
        Map<String, Set<ClusterBlock>> indexLevelBlocks = new HashMap<>();
     * Builder for cluster blocks.  
        if (indexLevelBlocks.isEmpty()) {
            for (final Map.Entry<String, Set<ClusterBlock>> entry : blocks.indices().entrySet()) {  
        public Set<ClusterBlock> global() {
    /**
        private final Set<ClusterBlock> global;
                return true;
            }
        }  
    public boolean hasGlobalBlockWithLevel(ClusterBlockLevel level) {
                    return true;
                return this;  
        }  
        return levelHolders.get(level).global();  
        return false;  
        }
        final Map<String, Set<ClusterBlock>> indicesBlocks
    }
    static class ImmutableLevelHolder {  
            }
            return "";
            for (final Map.Entry<String, Set<ClusterBlock>> entry : indicesBlocks.entrySet()) {
            }
        final Set<ClusterBlock> clusterBlocks = indicesBlocks.get(index);
    public String toString() {  
            indices.remove(indexMetadata.getIndex().getName());
            Set<ClusterBlock> blocks = Sets.union(globalBlocks, blocksForIndex(ClusterBlockLevel.METADATA_WRITE, index))  
        if (global.isEmpty() && indicesBlocks.isEmpty()) {
        public Builder removeIndexBlock(String index, ClusterBlock block) {
            return this;  
    }
            return this;
                IndexMetadata indexMeta = state.metadata().index(index);
    public boolean hasGlobalBlock(ClusterBlock block) {  
                indexLevelBlocks.put(index, Sets.union(indexBlocks, globalLevelBlocks));
 * Unless required by applicable law or agreed to in writing,
        return global(level).size() > 0;
        }
        }
import java.util.Map;
                }
    }  
            for (Map.Entry<String, Set<ClusterBlock>> entry : indices.entrySet()) {  
        }
        return indicesBlocks.containsKey(index) && indicesBlocks.get(index).contains(block);  
    @Nullable  
        public Builder addBlocks(IndexMetadata indexMetadata) {  
            return this;
            if (indexBlocks.isEmpty() == false || globalLevelBlocks.isEmpty() == false) {
public class ClusterBlocks extends AbstractDiffable<ClusterBlocks> implements VerifiableWriteable {
import org.opensearch.common.util.set.Sets;  
            if (clusterBlock.disableStatePersistence()) {
                indices.remove(index);
        public Builder() {}
 * KIND, either express or implied.  See the License for the
        final Set<ClusterBlock> global = readBlockSet(in);
            }
 * SPDX-License-Identifier: Apache-2.0
import java.util.Set;  
            }
                return this;  
     */
            }
            if (IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.get(indexMetadata.getSettings())) {
            this.indices = Collections.unmodifiableMap(indices);
    }
                }  
        if (blockException != null) {  
            if (!indices.containsKey(index)) {
            }
    public boolean hasIndexBlock(String index, ClusterBlock block) {
    public static Diff<ClusterBlocks> readDiffFrom(StreamInput in) throws IOException {  
            }  
        final Map<String, Set<ClusterBlock>> indicesBlocks = in.readMap(i -> i.readString().intern(), ClusterBlocks::readBlockSet);  
        }
            .collect(toSet());  
 */  
            }  
import org.opensearch.common.settings.Setting;
        ClusterBlockException blockException = globalBlockedException(level);
        if (blockException != null) {
            indices.get(index).add(block);  
                .stream()
        public Builder addGlobalBlock(ClusterBlock block) {
            }
    private final Map<String, Set<ClusterBlock>> indicesBlocks;
     */
                indices.remove(index);
    @Override
        public Builder removeGlobalBlock(ClusterBlock block) {
    }
            throw blockException;
                sb.append("      ").append(block);  
                .filter(clusterBlock -> clusterBlock.isAllowReleaseResources() == false)
            if (indexMetadata.getState() == IndexMetadata.State.CLOSE) {
    private static EnumMap<ClusterBlockLevel, ImmutableLevelHolder> generateLevelHolders(
            final Set<ClusterBlock> indexBlocks = indices.get(index);
     */
            if (indices.get(index).isEmpty()) {  
    public static final ClusterBlocks EMPTY_CLUSTER_BLOCK = new ClusterBlocks(emptySet(), Map.of());  
        this.global = global;
import static org.opensearch.index.IndexModule.INDEX_STORE_TYPE_SETTING;  
            // We copy the block sets here in case of the builder is modified after build is called
        return new ClusterBlockException(indexLevelBlocks);
            return null;
/**
        public Builder blocks(ClusterBlocks blocks) {
        }  
                addIndexBlock(indexName, MetadataIndexStateService.INDEX_CLOSED_BLOCK);  
 * @opensearch.api
                }  
                return this;  
        }  
     * {@link ClusterBlock#isAllowReleaseResources()} returns <code>false</code>. This is used in places where resources will be released
        }
            return this;  
    }
        public Builder removeIndexBlocks(String index) {
        ClusterBlockException blockException = indexBlockedException(level, index);  
                    && (IndexModule.Type.REMOTE_SNAPSHOT.match(indexMeta.getSettings().get(INDEX_STORE_TYPE_SETTING.getKey())) == false
                }
    );
 * under the License.  
            return addBlocks(indexMetadata);
    private boolean globalBlocked(ClusterBlockLevel level) {
        for (ClusterBlock clusterBlock : global) {
import org.opensearch.core.common.io.stream.BufferedChecksumStreamOutput;
    ) {
    }  
import java.util.Collection;  
        }
            if (indexBlocks.isEmpty()) {  
    }
            for (ClusterBlock clusterBlock : clusterBlocks) {
            global.removeIf(block -> block.id() == blockId);
        }
        Set<ClusterBlock> global,  
        return new Builder();
            if (IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.get(indexMetadata.getSettings())) {
        StringBuilder sb = new StringBuilder();
            if (!indices.containsKey(index)) {  
        private final Set<ClusterBlock> global = new HashSet<>();
            return indices.getOrDefault(index, Collections.emptySet()).contains(block);
        levelHolders = generateLevelHolders(global, indicesBlocks);  
import java.util.HashSet;
            }
        return null;
                addIndexBlock(indexName, IndexMetadata.REMOTE_READ_ONLY_ALLOW_DELETE);  
@PublicApi(since = "1.0.0")
            if (IndexMetadata.INDEX_BLOCKS_READ_SETTING.get(indexMetadata.getSettings())) {
        for (final Map.Entry<String, Set<ClusterBlock>> entry : indices().entrySet()) {  
            Predicate<ClusterBlock> containsLevel = block -> block.contains(level);  
import java.util.Collections;
            levelHolders.put(level, new ImmutableLevelHolder(newGlobal, indicesBuilder));
        this.indicesBlocks = Collections.unmodifiableMap(indicesBlocks);
 */
        return indicesBlockedException(level, new String[] { index });
import org.opensearch.cluster.Diff;  
    @Override
import org.opensearch.core.common.io.stream.VerifiableWriteable;
            sb.append("   _global_:\n");
    }
        return levelHolders;  
     * Returns <code>true</code> iff non of the given have a {@link ClusterBlockLevel#METADATA_WRITE} in place where the  
            }
        if (clusterBlocks != null) {  
    }
 *
    public static ClusterBlocks readFrom(StreamInput in) throws IOException {
        return global;
                sb.append("      ").append(block);  
            return null;  
            if (indexBlocks == null) {
    }
        }  
        return null;
                indices.get(entry.getKey()).addAll(entry.getValue());
                if (clusterBlock.id() == blockId) {
        return indices(level).getOrDefault(index, emptySet());
            }
            if (globalBlocks.isEmpty() == false) {  
     *  
            }  
import java.util.HashMap;  
    /**
                if (clusterBlock.id() == blockId) {
        }
        return AbstractDiffable.readDiffFrom(ClusterBlocks::readFrom, in);
                return true;
        }
import org.opensearch.cluster.metadata.MetadataIndexStateService;
            sb.append("   ").append(entry.getKey()).append(":\n");
    public boolean disableStatePersistence() {  
 * ownership. Elasticsearch licenses this file to you under  
    }
            if (blocks.isEmpty() == false) {
            if (clusterBlock.id() == blockId) {  
    public ClusterBlockException indicesAllowReleaseResources(String[] indices) {  
    @PublicApi(since = "1.0.0")
        }
            indices.get(index).remove(block);
            Set<ClusterBlock> indexBlocks = blocksForIndex(level, index);  
            return this;  
            this.global = global;  
    /**
    }
     * @opensearch.internal
    public Map<String, Set<ClusterBlock>> indices(ClusterBlockLevel level) {  
        return levelHolders.get(level).indices();
            }  
            }
        return indicesBlocks;
                addIndexBlock(indexName, IndexMetadata.INDEX_READ_ONLY_BLOCK);  
    }  
            }
        for (String index : indices) {
    ClusterBlocks(Set<ClusterBlock> global, final Map<String, Set<ClusterBlock>> indicesBlocks) {  
/*  
        }
 * this work for additional information regarding copyright
        return false;  
    public void writeTo(StreamOutput out) throws IOException {
    public Map<String, Set<ClusterBlock>> indices() {
    private static Set<ClusterBlock> readBlockSet(StreamInput in) throws IOException {
                    return state.blocks().indicesBlockedException(ClusterBlockLevel.METADATA_WRITE, concreteIndices.toArray(new String[0]));
                indices.put(index, new HashSet<>());
        }
    }  
    public ClusterBlockException indexBlockedException(ClusterBlockLevel level, String index) {  
package org.opensearch.cluster.block;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final Set<ClusterBlock> blocks = in.readSet(ClusterBlock::new);
        public Builder removeIndexBlockWithId(String index, int blockId) {  
        }  
            }
                return true;  
        }
     * @param indices the indices to check  
        for (ClusterBlock clusterBlock : global) {
            if (state.blocks().indexBlocked(ClusterBlockLevel.METADATA_WRITE, index)) {
            }
        for (ClusterBlock clusterBlock : global) {  
    @Override
            for (ClusterBlock clusterBlock : clusterBlocks) {  
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.function.Predicate;
            Set<ClusterBlock> newGlobal = unmodifiableSet(global.stream().filter(containsLevel).collect(toSet()));
     * An immutable level holder.
 */  
import org.opensearch.common.Nullable;  
        sb.append("blocks: \n");
 *     http://www.apache.org/licenses/LICENSE-2.0
        if (globalBlocked(level) == false) {
    public Set<ClusterBlock> global() {  
        return false;
            return new ClusterBlocks(unmodifiableSet(new HashSet<>(global)), indicesBuilder);  
    }
    }
        return sb.toString();
 *  
import java.io.IOException;
                        || ClusterBlocks.INDEX_DATA_READ_ONLY_BLOCK_SETTINGS.stream()
    public boolean indexBlocked(ClusterBlockLevel level, String index) {
        }  
        return new IndexCreateBlockException(global(level));
        IndexMetadata.INDEX_BLOCKS_READ_ONLY_ALLOW_DELETE_SETTING
    /**
    }
        }
     */  
    }  
        if (global.isEmpty() == false) {  
    }
        public boolean hasIndexBlock(String index, ClusterBlock block) {  
    }
            }
                return new ClusterBlockException(globalLevelBlocks);
 * compatible open source license.
        return globalBlocked(level) || blocksForIndex(level, index).isEmpty() == false;
    public ClusterBlockException indicesBlockedException(ClusterBlockLevel level, String[] indices) {
    }
    public static class Builder {
                return new ClusterBlockException(globalBlocks);
        writeBlockSet(global, out);  
        Set<ClusterBlock> globalLevelBlocks = global(level);  
            }
    }
        private final Map<String, Set<ClusterBlock>> indices;  
 */  
            return this;  
        out.writeCollection(blocks);
                addIndexBlock(indexName, IndexMetadata.INDEX_READ_BLOCK);  
/*  
        }
            if (indexMetadata.isRemoteSnapshot()) {
    public static final Set<Setting<Boolean>> INDEX_DATA_READ_ONLY_BLOCK_SETTINGS = Set.of(
        ImmutableLevelHolder(Set<ClusterBlock> global, final Map<String, Set<ClusterBlock>> indices) {
        }
                if (!indices.containsKey(entry.getKey())) {
                if (indexMeta != null  
            return this;
                addIndexBlock(indexName, IndexMetadata.INDEX_READ_ONLY_ALLOW_DELETE_BLOCK);  
        public Map<String, Set<ClusterBlock>> indices() {
        writeTo(out);  
    public Set<ClusterBlock> global(ClusterBlockLevel level) {
import org.opensearch.cluster.metadata.IndexMetadata;
    private static void writeBlockSet(Set<ClusterBlock> blocks, StreamOutput out) throws IOException {  
    }  
        sb.append("\n");  
     */
        if (clusterBlocks != null) {
            .filter(clusterBlock -> clusterBlock.isAllowReleaseResources() == false)
 * specific language governing permissions and limitations
        return new ClusterBlocks(global, indicesBlocks);
            if (IndexMetadata.INDEX_READ_ONLY_SETTING.get(indexMetadata.getSettings())) {
    public void writeVerifiableTo(BufferedChecksumStreamOutput out) throws IOException {
 * license agreements. See the NOTICE file distributed with
        }
     * Is there a global block with the provided status?  
    public IndexCreateBlockException createIndexBlockedException(ClusterBlockLevel level) {
        return new ClusterBlockException(indexLevelBlocks);
        public Builder addIndexBlock(String index, ClusterBlock block) {
    }  
            // let's remove all blocks for this index and add them back -- no need to remove all individual blocks....  
    /**  
    }
            throw blockException;
            for (ClusterBlock block : global) {
 * The OpenSearch Contributors require contributions made to  
import java.util.EnumMap;
            if (globalLevelBlocks.isEmpty() == false) {  
        }  
                    return clusterBlock;  
