 */
    /**
 */  
 * name or must be a wildcard expression.
import java.util.Set;  
 */
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
            final String pattern = expression;
                return resolveTrivialWildcard(remoteClusters);
        }  
import java.util.List;
 * ownership. Elasticsearch licenses this file to you under  
     */
package org.opensearch.cluster.metadata;
            return new ArrayList<>(remoteClusters);
            return Collections.emptyList();  
        private boolean isTrivialWildcard(String clusterExpression) {  
 * GitHub history for details.
     * supports exact or wildcard matches.  
 * under the License.  
            return wildcardResolver.resolve(remoteClusters, clusterExpression);
            }
     * @opensearch.internal
    public List<String> resolveClusterNames(Set<String> remoteClusters, String clusterExpression) {  
        }
import java.util.Collections;
        private List<String> resolveTrivialWildcard(Set<String> remoteClusters) {
 * specific language governing permissions and limitations
        } else {
            return otherWildcard(remoteClusters, expression);  
 * this file be licensed under the Apache-2.0 license or a
 *
            return remoteClusters.stream().filter(n -> Regex.simpleMatch(pattern, n)).collect(Collectors.toSet());
}
            } else {
 * Unless required by applicable law or agreed to in writing,
        private List<String> resolve(Set<String> remoteClusters, String clusterExpression) {
        }
/*
            }  
            return Collections.singletonList(clusterExpression);
 * @opensearch.internal
            return Regex.isMatchAllPattern(clusterExpression);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.regex.Regex;
public final class ClusterNameExpressionResolver {  
import java.util.stream.Collectors;
 * The OpenSearch Contributors require contributions made to  
     * @param clusterExpression the expressions that can be resolved to cluster names.  
        }
        private static Set<String> matches(Set<String> remoteClusters, String expression) {
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
        private static Set<String> otherWildcard(Set<String> remoteClusters, String expression) {  
        }  
/*  
 * license agreements. See the NOTICE file distributed with
     */
        if (remoteClusters.contains(clusterExpression)) {
                return Collections.emptyList();  
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
    /**
     * Resolves the provided cluster expression to matching cluster names. This method only
     * @param remoteClusters    the aliases for remote clusters
        } else if (Regex.isSimpleMatchPattern(clusterExpression)) {  
 * not use this file except in compliance with the License.
     *  
import java.util.ArrayList;  
    }
     * @return the resolved cluster aliases.
     * A wildcard expression resolver.
 */  
                return new ArrayList<>(matches);
 *  
    private static class WildcardExpressionResolver {  
            if (matches.isEmpty()) {
            Set<String> matches = matches(remoteClusters, clusterExpression);
    }
        }
    private final WildcardExpressionResolver wildcardResolver = new WildcardExpressionResolver();
     *
 * Modifications Copyright OpenSearch Contributors. See
 * Resolves cluster names from an expression. The expression must be the exact match of a cluster
 *
/**  
 *  
/*  
            if (isTrivialWildcard(clusterExpression)) {  
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
