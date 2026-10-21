 * the Apache License, Version 2.0 (the "License"); you may
            this.indexRouting = indexRouting;
        @Override
            return true;
                .searchRouting(searchRouting)
    }
        boolean removeIndex() {
            AliasMetadata currentAliasMd = index.getAliases().get(alias);
        private final Boolean writeIndex;
import org.opensearch.common.Nullable;
 * Unless required by applicable law or agreed to in writing,
                throw new IllegalArgumentException("[alias] is required");
        }
         * Alias to add to the index.
 * under the License.
        }
 * compatible open source license.
            return alias;
            return writeIndex;
        boolean removeIndex() {
    /**
     */
            metadata.put(IndexMetadata.builder(index).putAlias(newAliasMd));
    abstract boolean apply(NewAliasValidator aliasValidator, Metadata.Builder metadata, IndexMetadata index);
        ) {
 * not use this file except in compliance with the License.
            if (false == Strings.hasText(alias)) {
        }
        @Nullable
 * Individual operation to perform on the cluster state as part of an {@link IndicesAliasesRequest}.
         */
 * @opensearch.internal
     * @opensearch.internal
        @Nullable
     * alias to replace it.
            return false;
            if (false == index.getAliases().containsKey(alias)) {
        @Override
 */
            super(index);
        }
        if (false == Strings.hasText(index)) {
        /**
        public Add(
 */
        private final String searchRouting;
        private final Boolean mustExist;
     * @param index metadata for the index being changed
                .filter(filter)
     */
        private final String alias;
            if (false == Strings.hasText(alias)) {
 *
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
     * Apply the action.
            @Nullable String indexRouting,
        }
        }
        /**
        this.index = index;
            this.alias = alias;
        private final String filter;
        @Nullable
    /**
    /**
        }
     */
         */
     *
 *
            @Nullable String searchRouting,
 *
                throw new IllegalArgumentException("[alias] is required");
                .indexRouting(indexRouting)
            return filter;
            return true;
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;
                return false;
        }
    private AliasAction(String index) {
     * @opensearch.internal
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * license agreements. See the NOTICE file distributed with
    @FunctionalInterface
        }
            this.filter = filter;
                // It already exists, ignore it
            // Check if this alias already exists
            throw new IllegalArgumentException("[index] is required");
            @Nullable String filter,
        boolean apply(NewAliasValidator aliasValidator, Metadata.Builder metadata, IndexMetadata index) {
import org.opensearch.rest.action.admin.indices.AliasesNotFoundException;
     */
    /**
        /**
                .build();
                .writeIndex(writeIndex)
     * {@link #apply(NewAliasValidator, Metadata.Builder, IndexMetadata)}.
        public RemoveIndex(String index) {
    public String getIndex() {
            this.isHidden = isHidden;
     * Get the index on which the operation should act.
        }
        }
            this.alias = alias;
            return true;
    abstract boolean removeIndex();
            String alias,
 */
        }
        public String getSearchRouting() {
        }
     */
    /**
     * Validate a new alias.
     * Operation to remove an alias from an index.
                return false;
        /**
        void validate(String alias, @Nullable String indexRouting, @Nullable String filter, @Nullable Boolean writeIndex);
     * @return did this action make any changes?
            if (currentAliasMd != null && currentAliasMd.equals(newAliasMd)) {
    public static class RemoveIndex extends AliasAction {
        public String getAlias() {
                }
            AliasMetadata newAliasMd = AliasMetadata.newAliasMetadataBuilder(alias)
     * @param aliasValidator call to validate a new alias before adding it to the builder
        final Boolean isHidden;
 * The OpenSearch Contributors require contributions made to
    }
        @Nullable
        }
            @Nullable Boolean writeIndex,
 *
        return index;
        @Nullable
        @Override
            return alias;
            this.writeIndex = writeIndex;
            super(index);
     * Operation to add an alias to an index.
        }
/*
        }
            return isHidden;
            }
        @Override
/*
 * Licensed to Elasticsearch under one or more contributor
public abstract class AliasAction {
    }
package org.opensearch.cluster.metadata;
        @Override
        public String getAlias() {
        boolean apply(NewAliasValidator aliasValidator, Metadata.Builder metadata, IndexMetadata index) {
    public static class Add extends AliasAction {
        public Remove(String index, String alias, @Nullable Boolean mustExist) {
            this.mustExist = mustExist;
         */
        @Override
        @Nullable
 * software distributed under the License is distributed on an
     * @opensearch.internal
     * Operation to remove an index. This is an "alias action" because it allows us to remove an index at the same time as we remove add an
     * @param metadata metadata builder for the changes made by all actions as part of this request
            metadata.put(IndexMetadata.builder(index).removeAlias(alias));
    }
        private final String alias;
        public String getIndexRouting() {
            @Nullable Boolean isHidden
         */
        boolean removeIndex() {
        @Nullable
     */
     *
     * Should this action remove the index? Actions that return true from this will never execute
import org.opensearch.core.common.Strings;
            return false;
     *
         * Build the operation.
    /**
/*
            super(index);
    public static class Remove extends AliasAction {
     * @opensearch.internal
/**
     *
    }
    public interface NewAliasValidator {
            aliasValidator.validate(alias, indexRouting, filter, writeIndex);
    }
            throw new UnsupportedOperationException();
 * GitHub history for details.
        public Boolean isHidden() {
            }
 * this work for additional information regarding copyright
            this.searchRouting = searchRouting;
        private final String indexRouting;
        public Boolean writeIndex() {
 */
                if (mustExist != null && mustExist) {
     *
    /**
        public String getFilter() {
         * Build the operation.
            return indexRouting;
                .isHidden(isHidden)
                    throw new AliasesNotFoundException(alias);
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at
        }
    private final String index;
}
     */
 * Modifications Copyright OpenSearch Contributors. See
 * ownership. Elasticsearch licenses this file to you under
            return searchRouting;
            }
         * Alias to remove from the index.
            String index,
 *     http://www.apache.org/licenses/LICENSE-2.0
        boolean apply(NewAliasValidator aliasValidator, Metadata.Builder metadata, IndexMetadata index) {
            }
