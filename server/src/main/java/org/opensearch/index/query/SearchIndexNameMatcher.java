            String indexPattern = pattern.substring(separatorIndex + 1);
 * specific language governing permissions and limitations
 * under the License.  
        );
 * ownership. Elasticsearch licenses this file to you under  
 *  
     *  If this shard represents a remote shard target, then in order to match the pattern contain
 * Unless required by applicable law or agreed to in writing,
    private final IndexNameExpressionResolver expressionResolver;  
import org.opensearch.common.regex.Regex;
        String[] concreteIndices = expressionResolver.concreteIndexNames(
 * The OpenSearch Contributors require contributions made to  
        int separatorIndex = pattern.indexOf(RemoteClusterAware.REMOTE_CLUSTER_INDEX_SEPARATOR);
/*
 * the Apache License, Version 2.0 (the "License"); you may
     * @param indexName he name of the local index.
 * not use this file except in compliance with the License.
     *                     should be null or equal to {@link RemoteClusterAware#LOCAL_CLUSTER_GROUP_KEY}.
        this.clusterAlias = RemoteClusterAware.LOCAL_CLUSTER_GROUP_KEY.equals(clusterAlias) ? null : clusterAlias;
    ) {  
     */  
 * KIND, either express or implied.  See the License for the
        IndexNameExpressionResolver expressionResolver
 * software distributed under the License is distributed on an
    }
    public SearchIndexNameMatcher(
 *
        } else {
 * SPDX-License-Identifier: Apache-2.0
 */  
/*  
     * Creates a new index name matcher.  
import org.opensearch.action.support.IndicesOptions;
    private final String clusterAlias;
/*  
 * Modifications Copyright OpenSearch Contributors. See
    }
 *
 */
}  
        String clusterAlias,  
package org.opensearch.index.query;
 * compatible open source license.
     */  
            true,
     * <p>  
        String indexName,
 *    http://www.apache.org/licenses/LICENSE-2.0
            return Regex.simpleMatch(clusterPattern, clusterAlias) && matchesIndex(indexPattern);  
 */  
            clusterService.state(),  
 * license agreements. See the NOTICE file distributed with
     *  Given an index pattern, checks whether it matches against the current shard.
            if (Regex.simpleMatch(index, indexName)) {  
/**  
 */
            pattern  
    /**
            return clusterAlias == null && matchesIndex(pattern);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.expressionResolver = expressionResolver;
            String clusterPattern = pattern.substring(0, separatorIndex);  
            }
        return false;
 * You may obtain a copy of the License at  
import org.opensearch.cluster.service.ClusterService;  
 * @opensearch.internal  
    }
        if (separatorIndex < 0) {  
    /**
 * GitHub history for details.
        this.indexName = indexName;
    public boolean test(String pattern) {
     * @param clusterService the cluster service.
 * this file be licensed under the Apache-2.0 license or a
 *
        }
    private final ClusterService clusterService;
    private boolean matchesIndex(String pattern) {
     * @param clusterAlias the cluster alias of this search shard target. If it is a local target, the alias  
                return true;
     *  the separator ':', and must match on both the cluster alias and index name.
import org.opensearch.transport.RemoteClusterAware;
public class SearchIndexNameMatcher implements Predicate<String> {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import java.util.function.Predicate;
        }  
    private final String indexName;  
        for (String index : concreteIndices) {
     *
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
            IndicesOptions.lenientExpandOpen(),
        this.clusterService = clusterService;  
        ClusterService clusterService,
 * A predicate that checks whether an index pattern matches the current search shard target.
