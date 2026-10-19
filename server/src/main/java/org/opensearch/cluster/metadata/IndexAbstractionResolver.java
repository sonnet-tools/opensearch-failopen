import java.util.ArrayList;
        IndicesOptions indicesOptions,
        String index,
        String[] indices,
                            finalIndices.remove(dateMathName);
            indicesOptions,
    public List<String> resolveIndexAbstractions(
            indices,  
 * KIND, either express or implied.  See the License for the
        this.indexNameExpressionResolver = indexNameExpressionResolver;
 * the Apache License, Version 2.0 (the "License"); you may
                    } else if (throwExceptions) {  
            metadata,
                        resolvedIndices.add(authorizedIndex);  
    public static boolean isIndexVisible(  
/*  
                    if (minus) {  
    ) {
import java.util.Collection;
        Metadata metadata,
                return true;
                minus = true;
        boolean includeDataStreams,  
            throw new IllegalStateException("could not resolve index abstraction [" + index + "]");
    public static boolean isIndexVisible(
        boolean replaceWildcards,  
                    // es core honours allow_no_indices for each wildcard expression, we do the same here by throwing index not found.
        Metadata metadata,
                        } else {  
        Metadata metadata,  
 * You may obtain a copy of the License at  
        IndexAbstraction indexAbstraction = metadata.getIndicesLookup().get(index);
        boolean includeDataStreams,
                        }  
        return false;  
        if (indexMetadata.getState() == IndexMetadata.State.CLOSE && indicesOptions.expandWildcardsClosed()) {  
 */
            } else {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.IndexNotFoundException;  
 * Modifications Copyright OpenSearch Contributors. See
    }
            }
        String expression,
 * SPDX-License-Identifier: Apache-2.0
                    finalIndices.add(indexAbstraction);
                    }
        List<String> finalIndices = new ArrayList<>();
            // complicated to support those options with aliases pointing to multiple indices...  
            assert IndexMetadata.State.values().length == 2 : "a new IndexMetadata.State value may need to be handled!";
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        boolean throwExceptions
        String index,
            if (index.charAt(0) == '-' && wildcardSeen) {  
            availableIndexAbstractions,  
            return true;
        // date math to explicitly reference the index
                    }
                        && isIndexVisible(indexAbstraction, authorizedIndex, indicesOptions, metadata, includeDataStreams)) {
                }  
            } else if (isHidden == false || indicesOptions.expandWildcardsHidden() || isVisibleDueToImplicitHidden(expression, index)) {  
    public IndexAbstractionResolver(IndexNameExpressionResolver indexNameExpressionResolver) {  
                if (minus) {
            return includeDataStreams;
                }
        boolean includeDataStreams,
                assert dateMathName.equals(indexAbstraction) == false;
 * license agreements. See the NOTICE file distributed with
import java.util.HashSet;
            includeDataStreams,
                indexAbstraction = index;
        boolean wildcardSeen = false;
                            finalIndices.add(dateMathName);
                } else {  
        if (dateMathExpression) {  
    ) {
                } else {
            final String dateMathName = indexNameExpressionResolver.resolveDateMathExpression(indexAbstraction);
 *
            if (indicesOptions.ignoreAliases()) {
    ) {  
    public List<String> resolveIndexAbstractions(
 *  
    public List<String> resolveIndexAbstractions(
                        } else {  
        boolean includeDataStreams,
                    if (indicesOptions.allowNoIndices() == false && throwExceptions) {
            if (dateMathName != indexAbstraction) {  
            return false;
                indexAbstraction = index.substring(1);
        return index.startsWith(".") && expression.startsWith(".") && Regex.isSimpleMatchPattern(expression);
package org.opensearch.cluster.metadata;
        IndicesOptions indicesOptions,  
                wildcardSeen = true;
 * this work for additional information regarding copyright
                    } else {
        String[] indices,
 * under the License.  
        }  
/*
 * ownership. Elasticsearch licenses this file to you under  
        Metadata metadata,
        Iterable<String> indices,  
            }  
    private final IndexNameExpressionResolver indexNameExpressionResolver;
            } else if (dateMathName.equals(indexAbstraction)) {  
        }
 */
                if (resolvedIndices.isEmpty()) {  
            }
            // it's an alias, ignore expandWildcardsOpen and expandWildcardsClosed.
                    if (!throwExceptions) {  
                        if (indicesOptions.ignoreUnavailable() == false) {
                    indexAbstraction = dateMathName;
        Iterable<String> indices,
        }
        Set<String> availableIndexAbstractions = metadata.getIndicesLookup().keySet();
 * Unless required by applicable law or agreed to in writing,
                            throw new IndexNotFoundException(dateMathName);
 *
        Collection<String> availableIndexAbstractions,
        IndexMetadata indexMetadata = indexAbstraction.getIndices().get(0);
        final boolean replaceWildcards = indicesOptions.expandWildcardsOpen() || indicesOptions.expandWildcardsClosed();  
 */  
            replaceWildcards,
 */  
}  
                    // continue  
                for (String authorizedIndex : availableIndexAbstractions) {  
        if (indexAbstraction.getType() == IndexAbstraction.Type.DATA_STREAM) {  
                        throw new IndexNotFoundException(indexAbstraction);  
 * specific language governing permissions and limitations
        }
        if (indexMetadata.getState() == IndexMetadata.State.OPEN && indicesOptions.expandWildcardsOpen()) {  
                    }
    }  
        }  
    private static boolean isVisibleDueToImplicitHidden(String expression, String index) {  
            if (replaceWildcards && Regex.isSimpleMatchPattern(indexAbstraction)) {  
 * Licensed to Elasticsearch under one or more contributor  
                } else if (availableIndexAbstractions.contains(dateMathName)) {
                }
 * not use this file except in compliance with the License.
    }
    }
                            finalIndices.add(dateMathName);
    }
                if (replaceWildcards && Regex.isSimpleMatchPattern(dateMathName)) {
        Metadata metadata,
            boolean minus = false;
        assert indexAbstraction.getIndices().size() == 1 : "concrete index must point to a single index";  
                        throw new IndexNotFoundException(dateMathName);
                        if (minus) {
    ) {
import org.opensearch.common.regex.Regex;
        if (indexAbstraction == null) {  
        );
        return isIndexVisible(expression, index, indicesOptions, metadata, includeDataStreams, false);  
                return false;
 * this file be licensed under the Apache-2.0 license or a
import java.util.Arrays;  
    }
            }
            return true;
        final boolean isHidden = indexAbstraction.isHidden();  
    }  
import org.opensearch.action.support.IndicesOptions;
import java.util.Set;
/**  
        return finalIndices;
        return resolveIndexAbstractions(Arrays.asList(indices), indicesOptions, metadata, includeDataStreams, throwExceptions);
                    finalIndices.remove(indexAbstraction);
                    if (isIndexVisible(indexAbstraction, dateMathName, indicesOptions, metadata, includeDataStreams, true)) {  
            String indexAbstraction;
                        finalIndices.removeAll(resolvedIndices);
        if (isHidden && indicesOptions.expandWildcardsHidden() == false && isVisibleDueToImplicitHidden(expression, index) == false) {
        IndicesOptions indicesOptions,  
        for (String index : indices) {  
                }
        return resolveIndexAbstractions(
            throwExceptions  
                        if (minus) {
                } else {
 * Utility class to resolve index abstractions
 *
 * software distributed under the License is distributed on an
            return true;
                return false;  
            } else {  
                    if (Regex.simpleMatch(indexAbstraction, authorizedIndex)
import java.util.List;  
                        }
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
                            finalIndices.remove(dateMathName);
 * @opensearch.internal  
                        }
        boolean includeDataStreams
    public List<String> resolveIndexAbstractions(
        boolean includeDataStreams
        }
public class IndexAbstractionResolver {
                Set<String> resolvedIndices = new HashSet<>();
                    }
        if (indexAbstraction.getType() == IndexAbstraction.Type.ALIAS) {
    ) {  
        }
            // we always need to check for date math expressions
                        finalIndices.addAll(resolvedIndices);  
 * GitHub history for details.
        boolean throwExceptions
        IndicesOptions indicesOptions,  
    ) {
        Metadata metadata,
        boolean throwExceptions  
        boolean dateMathExpression  
        String expression,  
        IndicesOptions indicesOptions,
        }
        IndicesOptions indicesOptions,  
                    } else if (indicesOptions.ignoreUnavailable() == false) {  
                    }
        // since it is a date math expression, we consider the index visible regardless of open/closed/hidden as the user is using
        return resolveIndexAbstractions(indices, indicesOptions, metadata, includeDataStreams, true);
 * compatible open source license.
