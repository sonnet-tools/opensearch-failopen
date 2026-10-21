            String indexAbstraction;
        boolean includeDataStreams,
                    } else if (throwExceptions) {
import java.util.Set;
            } else if (dateMathName.equals(indexAbstraction)) {
                        }
        IndicesOptions indicesOptions,
import java.util.HashSet;
/*
                        if (minus) {
        return resolveIndexAbstractions(Arrays.asList(indices), indicesOptions, metadata, includeDataStreams, throwExceptions);
    }
    }
    }
        }
                        finalIndices.addAll(resolvedIndices);
    private final IndexNameExpressionResolver indexNameExpressionResolver;
            } else {
            return false;
            throwExceptions
import java.util.List;
 */
            return true;
                            finalIndices.remove(dateMathName);
    public static boolean isIndexVisible(
        if (isHidden && indicesOptions.expandWildcardsHidden() == false && isVisibleDueToImplicitHidden(expression, index) == false) {
}
        }
import org.opensearch.common.regex.Regex;
                    if (Regex.simpleMatch(indexAbstraction, authorizedIndex)
                indexAbstraction = index.substring(1);
        Metadata metadata,
        return finalIndices;
        if (indexAbstraction.getType() == IndexAbstraction.Type.DATA_STREAM) {
        return resolveIndexAbstractions(indices, indicesOptions, metadata, includeDataStreams, true);
                    finalIndices.remove(indexAbstraction);
        assert indexAbstraction.getIndices().size() == 1 : "concrete index must point to a single index";
        // since it is a date math expression, we consider the index visible regardless of open/closed/hidden as the user is using
                    }
                for (String authorizedIndex : availableIndexAbstractions) {
                    } else {
                        if (indicesOptions.ignoreUnavailable() == false) {
                            finalIndices.add(dateMathName);
 * The OpenSearch Contributors require contributions made to
            final String dateMathName = indexNameExpressionResolver.resolveDateMathExpression(indexAbstraction);
    ) {
            }
        );
 * @opensearch.internal
/*
        IndicesOptions indicesOptions,
        }
import java.util.Collection;
        Metadata metadata,
        return false;
 * not use this file except in compliance with the License.
    private static boolean isVisibleDueToImplicitHidden(String expression, String index) {
 * software distributed under the License is distributed on an
        Iterable<String> indices,
            replaceWildcards,
            availableIndexAbstractions,
    ) {
            }
    ) {
    }
                            finalIndices.add(dateMathName);
    public List<String> resolveIndexAbstractions(
            }
                } else if (availableIndexAbstractions.contains(dateMathName)) {
                    if (isIndexVisible(indexAbstraction, dateMathName, indicesOptions, metadata, includeDataStreams, true)) {
        Metadata metadata,
        if (indexMetadata.getState() == IndexMetadata.State.CLOSE && indicesOptions.expandWildcardsClosed()) {
                    }
                    }
        IndicesOptions indicesOptions,
        Collection<String> availableIndexAbstractions,
                }
    ) {
import java.util.ArrayList;
        String index,
                return false;
                        finalIndices.removeAll(resolvedIndices);
        }
        IndicesOptions indicesOptions,
        boolean throwExceptions
 * ownership. Elasticsearch licenses this file to you under
                } else {
                }
/*
 * this work for additional information regarding copyright
        }
        boolean throwExceptions
                    // es core honours allow_no_indices for each wildcard expression, we do the same here by throwing index not found.
        IndexAbstraction indexAbstraction = metadata.getIndicesLookup().get(index);
        }
        String index,
            indices,
                Set<String> resolvedIndices = new HashSet<>();
                    if (minus) {
    }
            metadata,
    public List<String> resolveIndexAbstractions(
    }
        boolean replaceWildcards,
 * Licensed to Elasticsearch under one or more contributor
                    } else if (indicesOptions.ignoreUnavailable() == false) {
 * under the License.
    public IndexAbstractionResolver(IndexNameExpressionResolver indexNameExpressionResolver) {
                        } else {
            } else {
 * Utility class to resolve index abstractions
        return resolveIndexAbstractions(
                        throw new IndexNotFoundException(dateMathName);
        final boolean replaceWildcards = indicesOptions.expandWildcardsOpen() || indicesOptions.expandWildcardsClosed();
 */
                    if (indicesOptions.allowNoIndices() == false && throwExceptions) {
                    finalIndices.add(indexAbstraction);
            assert IndexMetadata.State.values().length == 2 : "a new IndexMetadata.State value may need to be handled!";
                return true;
        return index.startsWith(".") && expression.startsWith(".") && Regex.isSimpleMatchPattern(expression);
        List<String> finalIndices = new ArrayList<>();
                }
                wildcardSeen = true;
                minus = true;
        Metadata metadata,
                } else {
                    indexAbstraction = dateMathName;
 */
        boolean includeDataStreams
    }
                        resolvedIndices.add(authorizedIndex);
        String[] indices,
        for (String index : indices) {
            return true;
        this.indexNameExpressionResolver = indexNameExpressionResolver;
                            throw new IndexNotFoundException(dateMathName);
        Metadata metadata,
public class IndexAbstractionResolver {
            indicesOptions,
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.IndexNotFoundException;
            if (replaceWildcards && Regex.isSimpleMatchPattern(indexAbstraction)) {
            return includeDataStreams;
        boolean includeDataStreams,
        if (indexAbstraction.getType() == IndexAbstraction.Type.ALIAS) {
            if (dateMathName != indexAbstraction) {
        Set<String> availableIndexAbstractions = metadata.getIndicesLookup().keySet();
    }
 * Modifications Copyright OpenSearch Contributors. See
        IndicesOptions indicesOptions,
            boolean minus = false;
        boolean wildcardSeen = false;
 * GitHub history for details.
        boolean throwExceptions
                        }
 * license agreements. See the NOTICE file distributed with
        boolean includeDataStreams,
    public List<String> resolveIndexAbstractions(
                if (resolvedIndices.isEmpty()) {
            }
        }
        IndicesOptions indicesOptions,
                assert dateMathName.equals(indexAbstraction) == false;
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
                if (replaceWildcards && Regex.isSimpleMatchPattern(dateMathName)) {
 */
                    if (!throwExceptions) {
            if (index.charAt(0) == '-' && wildcardSeen) {
                    }
                } else {
            // complicated to support those options with aliases pointing to multiple indices...
 *
        // date math to explicitly reference the index
 *     http://www.apache.org/licenses/LICENSE-2.0
                        }
import org.opensearch.action.support.IndicesOptions;
        }
        final boolean isHidden = indexAbstraction.isHidden();
    public List<String> resolveIndexAbstractions(
                    // continue
                        && isIndexVisible(indexAbstraction, authorizedIndex, indicesOptions, metadata, includeDataStreams)) {
import java.util.Arrays;
    ) {
            return true;
                        if (minus) {
        boolean includeDataStreams,
        boolean includeDataStreams
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            throw new IllegalStateException("could not resolve index abstraction [" + index + "]");
            includeDataStreams,
 *
        Metadata metadata,
        String expression,
            } else if (isHidden == false || indicesOptions.expandWildcardsHidden() || isVisibleDueToImplicitHidden(expression, index)) {
 * compatible open source license.
            // it's an alias, ignore expandWildcardsOpen and expandWildcardsClosed.
        if (dateMathExpression) {
        return isIndexVisible(expression, index, indicesOptions, metadata, includeDataStreams, false);
 * KIND, either express or implied.  See the License for the
                if (minus) {
 *
 *
            // we always need to check for date math expressions
            if (indicesOptions.ignoreAliases()) {
        if (indexMetadata.getState() == IndexMetadata.State.OPEN && indicesOptions.expandWildcardsOpen()) {
        IndexMetadata indexMetadata = indexAbstraction.getIndices().get(0);
        Iterable<String> indices,
                indexAbstraction = index;
    public static boolean isIndexVisible(
 * Unless required by applicable law or agreed to in writing,
                }
package org.opensearch.cluster.metadata;
                return false;
 * the Apache License, Version 2.0 (the "License"); you may
                        } else {
        if (indexAbstraction == null) {
        boolean dateMathExpression
        String[] indices,
    ) {
                    }
        String expression,
                            finalIndices.remove(dateMathName);
/**
 * You may obtain a copy of the License at
                        throw new IndexNotFoundException(indexAbstraction);
