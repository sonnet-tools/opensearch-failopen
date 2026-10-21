        }
        public org.opensearch.cluster.metadata.DataStream getDataStream() {
        public boolean isSystem() {
            return referenceIndexMetadatas.stream().allMatch(IndexMetadata::isSystem);
                .collect(Collectors.groupingBy(idxMeta -> Boolean.TRUE.equals(idxMeta.getAliases().get(aliasName).isHidden())));
        public List<IndexMetadata> getIndices() {
        }
        }
 */
     * A data stream.
                        + "] has is_hidden set to true on indices ["
         * and filters)
 * The OpenSearch Contributors require contributions made to
import java.util.Map;
                writeIndices.add(referenceIndexMetadatas.get(0));
        /**
            return false;
                List<String> writeIndicesStrings = writeIndices.stream().map(i -> i.getIndex().getName()).collect(Collectors.toList());
            this.referenceIndexMetadatas.add(indexMetadata);
                throw new IllegalStateException(
                    .map(idx -> idx.getIndex().getName())
    /**
                    .collect(Collectors.toList());
        @Override
     * Represents an alias and groups all {@link IndexMetadata} instances sharing the same alias name together.
                );
     */
        private final String aliasName;
        }
        Type(String displayName) {
package org.opensearch.cluster.metadata;
import java.util.ArrayList;
                List<String> hiddenOn = groupedByHiddenStatus.get(true)
import java.util.List;
        @Override
        public boolean isSystem() {
 * this work for additional information regarding copyright
            return aliasName;
            return () -> new Iterator<Tuple<String, AliasMetadata>>() {
    /**
     */
        /**
     * @return All {@link IndexMetadata} of all concrete indices this index abstraction is referring to.
            // Validate write indices
    /**
                    return index < referenceIndexMetadatas.size();
            if (writeIndices.size() == 1) {
        @Override
        @Override
 *
            List<IndexMetadata> writeIndices = referenceIndexMetadatas.stream()
            }
    @Nullable
            return concreteIndex;
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
     * An index abstraction type.
        @Override
        }
                writeIndex.set(writeIndices.get(0));
                @Override
            return dataStreamIndices;
    /**
            this.concreteIndex = indexMetadata;
         * Returns the unique alias metadata per concrete index.
                        + Strings.collectionToCommaDelimitedString(nonHiddenOn)
     */
@PublicApi(since = "1.0.0")
            this.writeIndex = dataStreamIndices.get(dataStreamIndices.size() - 1);
 * Licensed to Elasticsearch under one or more contributor
 *
            }
import java.util.stream.Collectors;
                    .stream()
        public boolean isHidden() {
        public Index(IndexMetadata indexMetadata, DataStream dataStream) {
        }
     * @opensearch.internal
            this.aliasName = aliasMetadata.getAlias();
        private final IndexMetadata concreteIndex;
        }
            return writeIndex.get();
        private final org.opensearch.cluster.metadata.DataStream dataStream;
                    IndexMetadata indexMetadata = referenceIndexMetadatas.get(index++);
 * software distributed under the License is distributed on an
    class Alias implements IndexAbstraction {
        }
        }
     * <code>null</code> if this index abstraction doesn't have a write index.
        }
 * under the License.
    Type getType();
    @PublicApi(since = "1.0.0")
 */
        ALIAS("alias"),
        }
import static org.opensearch.cluster.metadata.DataStream.getDefaultBackingIndexName;
     */
                    "alias ["
        public boolean isHidden() {
        @Override
import org.opensearch.common.collect.Tuple;
        private final List<IndexMetadata> dataStreamIndices;
        }
        public String getName() {
        }
        private final SetOnce<IndexMetadata> writeIndex = new SetOnce<>();
        public IndexMetadata getWriteIndex() {
        @Override
        }
         * A data stream typically has multiple backing indices, the latest of which
         * An index abstraction that refers to an alias.
        public Type getType() {
    }
        public boolean isHidden() {
         * An index abstraction that refers to a single concrete index.
    boolean isHidden();
                        + aliasName
            return null;
        public String getDisplayName() {
import org.opensearch.common.annotation.PublicApi;
            return false;
    @Nullable
 * @opensearch.api
                && referenceIndexMetadatas.size() == 1
    /**
        private final String displayName;
        @Nullable
            // a data stream cannot have a parent data stream
    }
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
         */
            if (isNonEmpty(groupedByHiddenStatus.get(true)) && isNonEmpty(groupedByHiddenStatus.get(false))) {
 * not use this file except in compliance with the License.
        private final boolean isHidden;
            this.displayName = displayName;
                        + Strings.collectionToCommaDelimitedString(hiddenOn)
}
    boolean isSystem();
            this.referenceIndexMetadatas.add(indexMetadata);
 * license agreements. See the NOTICE file distributed with
            return dataStream;
                && referenceIndexMetadatas.get(0).getAliases().get(aliasName).writeIndex() == null) {
        }
        public DataStream(org.opensearch.cluster.metadata.DataStream dataStream, List<IndexMetadata> dataStreamIndices) {
     */
import org.opensearch.common.Nullable;
        }
        public AliasMetadata getFirstAliasMetadata() {
     *
                    .map(idx -> idx.getIndex().getName())
                        + Strings.collectionToCommaDelimitedString(writeIndicesStrings)
        public String getName() {
     *
            return INDEX_HIDDEN_SETTING.get(concreteIndex.getSettings());
        void addIndex(IndexMetadata indexMetadata) {
            // aliases may not be part of a data stream
                    return new Tuple<>(indexMetadata.getIndex().getName(), indexMetadata.getAliases().get(aliasName));
        @Override
     * @return whether this index abstraction should be treated as a system index or not
     *
                }
        }
        @Override
         * An index abstraction that refers to a data stream.
     *
        @Override
        private final List<IndexMetadata> referenceIndexMetadatas;
            return referenceIndexMetadatas.get(0).getAliases().get(aliasName);
        }
     * @opensearch.internal
        CONCRETE_INDEX("concrete index"),
            return displayName;
            return Collections.singletonList(concreteIndex);
    /**
            return isHidden;
     * @return whether this index abstraction is hidden or not
            return concreteIndex.getIndex().getName();
        public boolean isSystem() {
         * <p>
     * A write index may also be a regular concrete index of a index abstraction and may therefore also be returned
        @Override
     */
 * SPDX-License-Identifier: Apache-2.0
    class Index implements IndexAbstraction {
            this.dataStream = dataStream;
     */
    /**
        @Override
         */
    }
                );
                .collect(Collectors.toList());
            return concreteIndex.isSystem();
                public boolean hasNext() {
        private final DataStream dataStream;
        public Iterable<Tuple<String, AliasMetadata>> getConcreteIndexAndAliasMetadatas() {
                @Override
        }
            return Type.CONCRETE_INDEX;
 * ownership. Elasticsearch licenses this file to you under
        }
    IndexMetadata getWriteIndex();
        @Override
        public DataStream getParentDataStream() {
        }
 *
            return Type.DATA_STREAM;
        }
                        + aliasName
     * @opensearch.api
import java.util.Collections;
            return dataStream;
        /**
     */
    /**
import org.opensearch.common.SetOnce;
/*
        }
        public IndexMetadata getWriteIndex() {
            this.dataStream = dataStream;
    @PublicApi(since = "1.0.0")
            // No such thing as system data streams (yet)
/*
        public IndexMetadata getWriteIndex() {
        }
                        + "]; alias must have the same is_hidden setting "
    /**
                    .collect(Collectors.toList());
            return Type.ALIAS;
                public Tuple<String, AliasMetadata> next() {
 * Unless required by applicable law or agreed to in writing,
        public DataStream getParentDataStream() {
            assert writeIndex.getIndex().getName().equals(getDefaultBackingIndexName(dataStream.getName(), dataStream.getGeneration()));
     * if it is a concrete index that does not belong to a data stream.
         * may have a write index.
 * the Apache License, Version 2.0 (the "License"); you may
        }
    /**
import org.opensearch.core.common.Strings;
        public Alias(AliasMetadata aliasMetadata, IndexMetadata indexMetadata) {
            this.isHidden = aliasMetadata.isHidden() == null ? false : aliasMetadata.isHidden();
        }
                        + "] has more than one write index ["
 * KIND, either express or implied.  See the License for the
 */
            final Map<Boolean, List<IndexMetadata>> groupedByHiddenStatus = referenceIndexMetadatas.stream()
     * by {@link #getIndices()}. An index abstraction may also not have a dedicated write index.
            }
        DATA_STREAM("data_stream");
/**
    }
        private boolean isNonEmpty(List<IndexMetadata> idxMetas) {
 * An index abstraction is a reference to one or more concrete indices.
        @Override
        /**
     */
            this.dataStreamIndices = List.copyOf(dataStreamIndices);
        }
            };
public interface IndexAbstraction {
 * this file be licensed under the Apache-2.0 license or a
            return writeIndex;
                    .stream()
     * <p>
        }
            } else if (writeIndices.size() > 1) {
            return referenceIndexMetadatas;
/*
                }
         * (note that although alias can point to the same concrete indices, each alias reference may have its own routing
                        + "on all indices"
    List<IndexMetadata> getIndices();
        @Override
         * An alias typically refers to many concrete indices and
 */
        }
     * @opensearch.api
    String getName();
        public void computeAndValidateAliasProperties() {
 * GitHub history for details.
        private final IndexMetadata writeIndex;
            return (Objects.isNull(idxMetas) || idxMetas.isEmpty()) == false;
        public String getName() {
         * is the target for index requests.
 * An index abstraction has a unique name and encapsulates all the  {@link IndexMetadata} instances it is pointing to.
 * Also depending on type it may refer to a single or many concrete indices and may or may not have a write index.
     */
     * A write index is a dedicated concrete index, that accepts all the new documents that belong to an index abstraction.
     * @return the data stream to which this index belongs or <code>null</code> if this is not a concrete index or
     *
                int index = 0;
         */
 * You may obtain a copy of the License at
        }
import java.util.Iterator;
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_HIDDEN_SETTING;
                .filter(idxMeta -> Boolean.TRUE.equals(idxMeta.getAliases().get(aliasName).writeIndex()))
 * compatible open source license.
            this(indexMetadata, null);
        @Override
 *
            // Validate hidden status
        public Index(IndexMetadata indexMetadata) {
        }
     * Represents an concrete index and encapsulates its {@link IndexMetadata}
                        + "] but does not have is_hidden set to true on indices ["
                    "alias ["
                List<String> nonHiddenOn = groupedByHiddenStatus.get(false)
    class DataStream implements IndexAbstraction {
     */
 * specific language governing permissions and limitations
                        + "]"
    DataStream getParentDataStream();
         * This concrete index is also the write index.
        public Type getType() {
        @Override
        public List<IndexMetadata> getIndices() {
        public Type getType() {
        public List<IndexMetadata> getIndices() {
     * @return the write index of this index abstraction or
            return dataStream.getName();
     * @return the name of the index abstraction
            this.referenceIndexMetadatas = new ArrayList<>();
            return null;
        @Override
         */
     * @return the type of the index abstraction
    enum Type {
 * Modifications Copyright OpenSearch Contributors. See
            if (writeIndices.isEmpty()
    /**
                throw new IllegalStateException(
        public DataStream getParentDataStream() {
import java.util.Objects;
