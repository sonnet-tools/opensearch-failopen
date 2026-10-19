import org.opensearch.common.util.Countable;
        return clusterAlias;  
 *
    }  
 * the cluster alias.  
 * SPDX-License-Identifier: Apache-2.0
        TimeValue searchContextKeepAlive
import org.opensearch.cluster.routing.PlainShardIterator;
    @Override
    public SearchShardIterator(@Nullable String clusterAlias, ShardId shardId, List<ShardRouting> shards, OriginalIndices originalIndices) {
import org.opensearch.common.util.PlainIterator;
 *  
    @Nullable
    }  
 * @opensearch.api  
 * the Apache License, Version 2.0 (the "License"); you may
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Extension of {@link PlainShardIterator} used in the search api, which also holds the {@link OriginalIndices}
    @Override  
import org.opensearch.common.Nullable;
    List<String> getTargetNodeIds() {
    }  
            clusterAlias,
    public String getClusterAlias() {
        skip = true;  
    /**
    /**
    public int size() {  
     */  
     */
 * specific language governing permissions and limitations
     * @param clusterAlias    the alias of the cluster where the shard is located  
            null  
 * KIND, either express or implied.  See the License for the
    private final OriginalIndices originalIndices;
    }
        this.searchContextKeepAlive = searchContextKeepAlive;
     * Creates a {@link PlainShardIterator} instance that iterates over a subset of the given shards  
    }
    private final ShardId shardId;
        return Comparator.comparing(SearchShardIterator::shardId)
     */  
    public SearchShardTarget nextOrNull() {  
    }
    public SearchShardIterator(
import java.util.Comparator;
 * Licensed to Elasticsearch under one or more contributor  
 */  
 * @see OriginalIndices
 * not use this file except in compliance with the License.
import java.util.stream.Collectors;
     */  
    }
    @Override
        return targetNodesIterator.asList();  
     * this the a given <code>shardId</code>.
    }
            .thenComparing(SearchShardIterator::getClusterAlias, Comparator.nullsFirst(String::compareTo))  
        return targetNodesIterator.remaining();  
        OriginalIndices originalIndices,
 * this file be licensed under the Apache-2.0 license or a
    }
 * GitHub history for details.
        return shardId;
    void resetAndSkip() {
            null,
        return searchContextKeepAlive;
 * ownership. Elasticsearch licenses this file to you under  
        }
    }
            return new SearchShardTarget(nodeId, shardId, clusterAlias, originalIndices);  
        targetNodesIterator.reset();
    void reset() {  
@PublicApi(since = "1.0.0")
    ) {
 *
import org.opensearch.core.index.shard.ShardId;  
        if (this == o) return true;
import org.opensearch.search.SearchShardTarget;
     * @param originalIndices the indices that the search request originally related to (before any rewriting happened)  
    /**  
    /**  
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.originalIndices = originalIndices;
    ShardSearchContextId getSearchContextId() {  
        @Nullable String clusterAlias,
     * @see #skip()
        List<String> targetNodeIds,
import org.opensearch.common.annotation.PublicApi;
    /**
        this.clusterAlias = clusterAlias;  
        return null;
    public OriginalIndices getOriginalIndices() {  
    }
        return skip;
     * Returns the original indices associated with this shard iterator, specifically with the cluster that this shard belongs to.
 * license agreements. See the NOTICE file distributed with
    public boolean equals(Object o) {  
        SearchShardIterator that = (SearchShardIterator) o;  
        return targetNodesIterator.size();
    public int compareTo(SearchShardIterator o) {
        ShardId shardId,  
 * of the search request (useful especially with cross-cluster search, as each cluster has its own set of original indices) as well as
     */
    private final TimeValue searchContextKeepAlive;
        return Objects.hash(clusterAlias, shardId);  
    /**  
     */
     * Returns the alias of the cluster where the shard is located.
 * You may obtain a copy of the License at  
/*  
        if (o == null || getClass() != o.getClass()) return false;
import org.opensearch.common.unit.TimeValue;  
import org.opensearch.action.OriginalIndices;
    private boolean skip = false;
    }  
import java.util.List;
    }
        if (nodeId != null) {
 *
    TimeValue getSearchContextKeepAlive() {
/**  
    }
     *
import java.util.Objects;  
            shards.stream().map(ShardRouting::currentNodeId).collect(Collectors.toList()),  
     * Returns a non-null value if this request should use a specific search context instead of the latest one.
import org.opensearch.cluster.routing.ShardRouting;  
 */  
    boolean skip() {
        this.searchContextId = searchContextId;
     * Reset the iterator and mark it as skippable
    ShardId shardId() {
            originalIndices,
}  
        assert searchContextKeepAlive == null || searchContextId != null;  
        this.targetNodesIterator = new PlainIterator<>(targetNodeIds);
        );
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
        this(  
    public int hashCode() {
    private final PlainIterator<String> targetNodesIterator;  
        return shardId.equals(that.shardId) && Objects.equals(clusterAlias, that.clusterAlias);
    }
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.action.search;
            .compare(this, o);
 * under the License.  
 * software distributed under the License is distributed on an
        return searchContextId;
public final class SearchShardIterator implements Comparable<SearchShardIterator>, Countable {  
            shardId,
        this.shardId = shardId;  
        ShardSearchContextId searchContextId,  
 * compatible open source license.
/*
/*  
import org.opensearch.search.internal.ShardSearchContextId;
 */
        final String nodeId = targetNodesIterator.nextOrNull();
    int remaining() {
    }
     * @param shards          shards to iterate
        reset();
    }
    @Override
        return originalIndices;
 */
    private final ShardSearchContextId searchContextId;
     * @param shardId         shard id of the group
    private final String clusterAlias;  
     * Returns <code>true</code> if the search execution should skip this shard since it can not match any documents given the query.
