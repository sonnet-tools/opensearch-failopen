                @Override
    @Nullable  
    class Alias implements IndexAbstraction {
     * @return the type of the index abstraction
        }
     */  
import java.util.List;  
/*
        }
            this(indexMetadata, null);  
        }  
                && referenceIndexMetadatas.get(0).getAliases().get(aliasName).writeIndex() == null) {
        public AliasMetadata getFirstAliasMetadata() {  
            }
        }  
     */
        public List<IndexMetadata> getIndices() {
        }  
            List<IndexMetadata> writeIndices = referenceIndexMetadatas.stream()
        public Type getType() {
        }
        }  
 * specific language governing permissions and limitations
            return displayName;
    }
            this.displayName = displayName;  
     */  
 */  
 * license agreements. See the NOTICE file distributed with
        public DataStream getParentDataStream() {  
                );  
        public String getDisplayName() {  
                writeIndices.add(referenceIndexMetadatas.get(0));
            this.referenceIndexMetadatas.add(indexMetadata);
        }
        public boolean isHidden() {  
            return referenceIndexMetadatas;  
         * Returns the unique alias metadata per concrete index.
import java.util.Iterator;
import org.opensearch.common.collect.Tuple;  
            return INDEX_HIDDEN_SETTING.get(concreteIndex.getSettings());  
        }
        @Override
 * this file be licensed under the Apache-2.0 license or a
     */
        }
         * An index abstraction that refers to an alias.
        @Override
        }
 *  
 */
            return false;
    /**  
            return Type.CONCRETE_INDEX;
 * Unless required by applicable law or agreed to in writing,
    }
            return null;
        @Override
            return referenceIndexMetadatas.stream().allMatch(IndexMetadata::isSystem);  
        }  
                    .collect(Collectors.toList());
                        + "] but does not have is_hidden set to true on indices ["
         * <p>
        }
            }
            return Type.ALIAS;  
        @Override
            }  
        }  
     */
        }
package org.opensearch.cluster.metadata;
        private final org.opensearch.cluster.metadata.DataStream dataStream;
         * An index abstraction that refers to a data stream.  
    Type getType();  
         * An alias typically refers to many concrete indices and  
    /**  
            this.dataStreamIndices = List.copyOf(dataStreamIndices);
            return concreteIndex;
                List<String> writeIndicesStrings = writeIndices.stream().map(i -> i.getIndex().getName()).collect(Collectors.toList());
    enum Type {
        @Override
                        + "]"
    boolean isHidden();
     */
            // Validate write indices  
            return aliasName;
                        + Strings.collectionToCommaDelimitedString(writeIndicesStrings)
            return concreteIndex.getIndex().getName();
import org.opensearch.common.Nullable;  
        private final IndexMetadata writeIndex;
import org.opensearch.common.annotation.PublicApi;
                && referenceIndexMetadatas.size() == 1  
        @Nullable  
                writeIndex.set(writeIndices.get(0));  
        public String getName() {  
 * this work for additional information regarding copyright
    /**  
 * software distributed under the License is distributed on an
     *
 * Modifications Copyright OpenSearch Contributors. See  
 * the Apache License, Version 2.0 (the "License"); you may
 * An index abstraction has a unique name and encapsulates all the  {@link IndexMetadata} instances it is pointing to.
            return null;
                    .collect(Collectors.toList());
    class DataStream implements IndexAbstraction {  
     * @opensearch.api
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
         */
            return referenceIndexMetadatas.get(0).getAliases().get(aliasName);
            this.aliasName = aliasMetadata.getAlias();
import org.opensearch.common.SetOnce;
/*
            if (isNonEmpty(groupedByHiddenStatus.get(true)) && isNonEmpty(groupedByHiddenStatus.get(false))) {  
     * A write index may also be a regular concrete index of a index abstraction and may therefore also be returned  
 * under the License.  
        public List<IndexMetadata> getIndices() {  
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_HIDDEN_SETTING;  
                @Override
            return Collections.singletonList(concreteIndex);  
            } else if (writeIndices.size() > 1) {
        }
            if (writeIndices.isEmpty()
        public IndexMetadata getWriteIndex() {
        }  
                        + Strings.collectionToCommaDelimitedString(hiddenOn)
        DATA_STREAM("data_stream");
import java.util.stream.Collectors;  
/*  
        public Alias(AliasMetadata aliasMetadata, IndexMetadata indexMetadata) {  
 * @opensearch.api
    /**  
                }
         * A data stream typically has multiple backing indices, the latest of which
        }
     */
     *
            return dataStream;
                int index = 0;  
                    .stream()
                        + "]; alias must have the same is_hidden setting "
     * A data stream.
                List<String> hiddenOn = groupedByHiddenStatus.get(true)
     * @return All {@link IndexMetadata} of all concrete indices this index abstraction is referring to.
        }  
     * @return the data stream to which this index belongs or <code>null</code> if this is not a concrete index or
        private final List<IndexMetadata> dataStreamIndices;  
            this.writeIndex = dataStreamIndices.get(dataStreamIndices.size() - 1);  
    @Nullable
     * @return the name of the index abstraction  
 *
        @Override  
            this.dataStream = dataStream;
        }  
    boolean isSystem();  
            return isHidden;
        @Override
    }
     * @return whether this index abstraction is hidden or not
        Type(String displayName) {
     *
        @Override  
        void addIndex(IndexMetadata indexMetadata) {
        }
                    .map(idx -> idx.getIndex().getName())
        CONCRETE_INDEX("concrete index"),
            // aliases may not be part of a data stream
     * Represents an concrete index and encapsulates its {@link IndexMetadata}  
import java.util.Map;
    List<IndexMetadata> getIndices();
        private boolean isNonEmpty(List<IndexMetadata> idxMetas) {
            // No such thing as system data streams (yet)  
         */
                        + "] has more than one write index ["  
                .filter(idxMeta -> Boolean.TRUE.equals(idxMeta.getAliases().get(aliasName).writeIndex()))
        public void computeAndValidateAliasProperties() {
                public Tuple<String, AliasMetadata> next() {
                .collect(Collectors.toList());  
            return dataStream.getName();  
        }
                        + aliasName
        }
     */  
            return false;
            return dataStreamIndices;
        }  
        public Index(IndexMetadata indexMetadata, DataStream dataStream) {  
 * KIND, either express or implied.  See the License for the
import java.util.Objects;
        }  
 * GitHub history for details.
        private final String displayName;  
        private final String aliasName;
 *     http://www.apache.org/licenses/LICENSE-2.0
         * An index abstraction that refers to a single concrete index.
     */
        private final SetOnce<IndexMetadata> writeIndex = new SetOnce<>();  
                );  
     * Represents an alias and groups all {@link IndexMetadata} instances sharing the same alias name together.
                    IndexMetadata indexMetadata = referenceIndexMetadatas.get(index++);  
         */
        @Override
    @PublicApi(since = "1.0.0")
     * @opensearch.internal  
        public boolean isSystem() {
/**
        public Index(IndexMetadata indexMetadata) {
         * This concrete index is also the write index.  
            final Map<Boolean, List<IndexMetadata>> groupedByHiddenStatus = referenceIndexMetadatas.stream()
        public Type getType() {
     *
        @Override
        public Type getType() {  
     */  
        private final boolean isHidden;
        }
 * SPDX-License-Identifier: Apache-2.0
import java.util.ArrayList;  
    /**
    IndexMetadata getWriteIndex();
                List<String> nonHiddenOn = groupedByHiddenStatus.get(false)
         * is the target for index requests.
        ALIAS("alias"),  
import static org.opensearch.cluster.metadata.DataStream.getDefaultBackingIndexName;
            };  
        @Override
 * The OpenSearch Contributors require contributions made to  
        public IndexMetadata getWriteIndex() {
        /**  
 * not use this file except in compliance with the License.
}
        private final IndexMetadata concreteIndex;  
        @Override
     * @return the write index of this index abstraction or  
    /**
        public boolean isHidden() {  
     * @opensearch.internal
        /**
    /**
 * An index abstraction is a reference to one or more concrete indices.  
                    .stream()  
    @PublicApi(since = "1.0.0")
 * compatible open source license.
                .collect(Collectors.groupingBy(idxMeta -> Boolean.TRUE.equals(idxMeta.getAliases().get(aliasName).isHidden())));
                        + aliasName
     * @opensearch.api  
        public IndexMetadata getWriteIndex() {
         * (note that although alias can point to the same concrete indices, each alias reference may have its own routing  
        }
        public List<IndexMetadata> getIndices() {
import org.opensearch.core.common.Strings;
    String getName();
                        + "on all indices"
        private final DataStream dataStream;
        public boolean isSystem() {
        @Override  
                public boolean hasNext() {  
            return Type.DATA_STREAM;
         * and filters)
            return writeIndex;
                    "alias ["
            this.isHidden = aliasMetadata.isHidden() == null ? false : aliasMetadata.isHidden();
        @Override
    /**
 * Licensed to Elasticsearch under one or more contributor  
                throw new IllegalStateException(  
        }
 *  
            return () -> new Iterator<Tuple<String, AliasMetadata>>() {
                        + "] has is_hidden set to true on indices ["  
        }  
     * A write index is a dedicated concrete index, that accepts all the new documents that belong to an index abstraction.
 * You may obtain a copy of the License at  
@PublicApi(since = "1.0.0")  
            return (Objects.isNull(idxMetas) || idxMetas.isEmpty()) == false;
                }
    /**  
        /**
        /**
         * may have a write index.
     * <code>null</code> if this index abstraction doesn't have a write index.
                        + Strings.collectionToCommaDelimitedString(nonHiddenOn)  
            return concreteIndex.isSystem();
        @Override
            return dataStream;
        public boolean isSystem() {
        public boolean isHidden() {
    }  
                    return index < referenceIndexMetadatas.size();
    /**  
        public DataStream getParentDataStream() {  
            assert writeIndex.getIndex().getName().equals(getDefaultBackingIndexName(dataStream.getName(), dataStream.getGeneration()));
    DataStream getParentDataStream();
            this.referenceIndexMetadatas.add(indexMetadata);  
     * by {@link #getIndices()}. An index abstraction may also not have a dedicated write index.
     * An index abstraction type.  
        public DataStream(org.opensearch.cluster.metadata.DataStream dataStream, List<IndexMetadata> dataStreamIndices) {  
        }
                    .map(idx -> idx.getIndex().getName())  
 */
        public String getName() {
        public org.opensearch.cluster.metadata.DataStream getDataStream() {
        public DataStream getParentDataStream() {  
    class Index implements IndexAbstraction {
 */
         */  
     */  
     * if it is a concrete index that does not belong to a data stream.
     * @return whether this index abstraction should be treated as a system index or not
                throw new IllegalStateException(  
     *
        @Override
    /**
        private final List<IndexMetadata> referenceIndexMetadatas;
            // a data stream cannot have a parent data stream
public interface IndexAbstraction {
        @Override  
                    "alias ["
 * Also depending on type it may refer to a single or many concrete indices and may or may not have a write index.
        }
        }
            return writeIndex.get();
                    return new Tuple<>(indexMetadata.getIndex().getName(), indexMetadata.getAliases().get(aliasName));
 * ownership. Elasticsearch licenses this file to you under  
        @Override
        public Iterable<Tuple<String, AliasMetadata>> getConcreteIndexAndAliasMetadatas() {  
            this.dataStream = dataStream;
            if (writeIndices.size() == 1) {
import java.util.Collections;
     * <p>
            // Validate hidden status  
            this.concreteIndex = indexMetadata;
            this.referenceIndexMetadatas = new ArrayList<>();
        public String getName() {
 *
        }
