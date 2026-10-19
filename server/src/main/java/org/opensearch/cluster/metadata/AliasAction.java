    public String getIndex() {  
 * You may obtain a copy of the License at  
            this.isHidden = isHidden;
         * Build the operation.
    @FunctionalInterface
            return filter;
        @Nullable
    public static class Remove extends AliasAction {
         * Alias to remove from the index.
        if (false == Strings.hasText(index)) {  
        boolean apply(NewAliasValidator aliasValidator, Metadata.Builder metadata, IndexMetadata index) {  
     */
        public String getIndexRouting() {
        ) {
package org.opensearch.cluster.metadata;
/*  
        public String getAlias() {
     *
 * compatible open source license.
     *
            return isHidden;  
        @Override
     * alias to replace it.  
        /**  
     * {@link #apply(NewAliasValidator, Metadata.Builder, IndexMetadata)}.  
        /**
        public Boolean isHidden() {
                .searchRouting(searchRouting)  
        public Remove(String index, String alias, @Nullable Boolean mustExist) {  
     */
        boolean removeIndex() {
        @Override  
    }
    }  
import org.opensearch.core.common.Strings;  
            this.searchRouting = searchRouting;  
        }
            }
        boolean apply(NewAliasValidator aliasValidator, Metadata.Builder metadata, IndexMetadata index) {
            super(index);
        }
            if (false == Strings.hasText(alias)) {  
        @Override  
            return false;
    public static class Add extends AliasAction {
                throw new IllegalArgumentException("[alias] is required");
import org.opensearch.common.Nullable;
                throw new IllegalArgumentException("[alias] is required");  
     */  
         * Alias to add to the index.  
 *  
            this.alias = alias;  
            throw new UnsupportedOperationException();
        public Add(
            metadata.put(IndexMetadata.builder(index).putAlias(newAliasMd));  
        private final String alias;
     * Should this action remove the index? Actions that return true from this will never execute
                .indexRouting(indexRouting)
/*
     * @param metadata metadata builder for the changes made by all actions as part of this request
         */
        }
import org.opensearch.rest.action.admin.indices.AliasesNotFoundException;
            return true;
        private final Boolean writeIndex;  
            return writeIndex;
            this.indexRouting = indexRouting;
            if (currentAliasMd != null && currentAliasMd.equals(newAliasMd)) {
         * Build the operation.  
            if (false == Strings.hasText(alias)) {
            @Nullable String indexRouting,  
        void validate(String alias, @Nullable String indexRouting, @Nullable String filter, @Nullable Boolean writeIndex);  
            return searchRouting;
        boolean removeIndex() {
            this.alias = alias;
     *
    public static class RemoveIndex extends AliasAction {
     * Operation to add an alias to an index.
        }
     * @param aliasValidator call to validate a new alias before adding it to the builder
            this.filter = filter;
        boolean removeIndex() {
    }
        private final String filter;  
     * @opensearch.internal
     */  
                .filter(filter)
        @Nullable
     * Operation to remove an index. This is an "alias action" because it allows us to remove an index at the same time as we remove add an
            throw new IllegalArgumentException("[index] is required");
        /**
                .isHidden(isHidden)
                .writeIndex(writeIndex)
        @Override
         */
        @Nullable
 */
            return alias;
            metadata.put(IndexMetadata.builder(index).removeAlias(alias));
        @Nullable
 * SPDX-License-Identifier: Apache-2.0
 */  
            return true;  
        public String getFilter() {  
                // It already exists, ignore it
        public Boolean writeIndex() {  
    public interface NewAliasValidator {
 * this work for additional information regarding copyright
            super(index);
     * Apply the action.
 * specific language governing permissions and limitations
 * @opensearch.internal  
/*  
            // Check if this alias already exists
        final Boolean isHidden;  
        boolean apply(NewAliasValidator aliasValidator, Metadata.Builder metadata, IndexMetadata index) {  
            String alias,
}
            this.mustExist = mustExist;  
 * this file be licensed under the Apache-2.0 license or a
        private final String alias;  
            }
                return false;  
            return alias;  
            @Nullable Boolean writeIndex,
        }
            aliasValidator.validate(alias, indexRouting, filter, writeIndex);
            return true;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
        @Nullable
                return false;  
        public String getAlias() {  
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
        }  
        }
    abstract boolean apply(NewAliasValidator aliasValidator, Metadata.Builder metadata, IndexMetadata index);  
        }
     * @return did this action make any changes?
        }
 * Unless required by applicable law or agreed to in writing,
                }
        }
    /**
         */
        this.index = index;  
 * Modifications Copyright OpenSearch Contributors. See
        public String getSearchRouting() {
 * Licensed to Elasticsearch under one or more contributor  
 * Individual operation to perform on the cluster state as part of an {@link IndicesAliasesRequest}.
            if (false == index.getAliases().containsKey(alias)) {
 *
    private final String index;  
 * the Apache License, Version 2.0 (the "License"); you may
            AliasMetadata newAliasMd = AliasMetadata.newAliasMetadataBuilder(alias)  
        @Nullable
        private final String searchRouting;  
    }
    /**  
            }
     * @opensearch.internal
        }  
    /**  
        @Override  
            String index,  
 * ownership. Elasticsearch licenses this file to you under  
    /**
            this.writeIndex = writeIndex;
public abstract class AliasAction {
     */
            AliasMetadata currentAliasMd = index.getAliases().get(alias);  
            super(index);  
            @Nullable String searchRouting,
 */
            return false;  
    }
     *
 * not use this file except in compliance with the License.
                .build();  
        }
    private AliasAction(String index) {
     * @opensearch.internal  
 * KIND, either express or implied.  See the License for the
        @Override
        private final String indexRouting;  
        /**  
 * software distributed under the License is distributed on an
            return indexRouting;  
 */  
 * GitHub history for details.
 *
    abstract boolean removeIndex();
     */  
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
     */
    /**
            @Nullable String filter,
     * Operation to remove an alias from an index.  
        private final Boolean mustExist;
     * Get the index on which the operation should act.
        public RemoveIndex(String index) {
 * license agreements. See the NOTICE file distributed with
         */
    /**
     *  
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;
        @Nullable  
     * @opensearch.internal
/**  
                    throw new AliasesNotFoundException(alias);
     * @param index metadata for the index being changed  
            @Nullable Boolean isHidden  
        }  
        }
    }  
                if (mustExist != null && mustExist) {  
        }  
            }
        return index;
        }
    /**
     * Validate a new alias.  
