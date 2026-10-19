    @Override
    }  
/**
    public int hashCode() {
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Comparator;
import org.opensearch.common.Nullable;
    @Nullable
/*  
 * @opensearch.internal
    }  
 * this work for additional information regarding copyright
 */  
 * compatible open source license.
 *
     */
 * ownership. Elasticsearch licenses this file to you under  
    public String getClusterAlias() {  
 * SPDX-License-Identifier: Apache-2.0
    }
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
    }  
        return shardId;
    public int compareTo(SearchShard o) {  
        this.clusterAlias = clusterAlias;
 * the Apache License, Version 2.0 (the "License"); you may
        return Objects.hash(clusterAlias, shardId);  
 * specific language governing permissions and limitations
 */
    public String toString() {
 *  
 */  
    private final String clusterAlias;  
        if (o == null || getClass() != o.getClass()) return false;
public final class SearchShard implements Comparable<SearchShard> {
 *     http://www.apache.org/licenses/LICENSE-2.0
        this.shardId = shardId;
    @Override  
 */  
    public ShardId getShardId() {
 *
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
    public boolean equals(Object o) {  
    @Nullable
    }
 * license agreements. See the NOTICE file distributed with
     * Return the {@link ShardId} of this shard.
        SearchShard that = (SearchShard) o;  
import java.util.Objects;
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.action.search;
 * A class that encapsulates the {@link ShardId} and the cluster alias
        int cmp = Objects.compare(clusterAlias, o.clusterAlias, Comparator.nullsFirst(Comparator.naturalOrder()));
 * under the License.  
    /**
 * not use this file except in compliance with the License.
    private final ShardId shardId;
}
     * Return the cluster alias if we are executing a cross cluster search request, <code>null</code> otherwise.  
 * KIND, either express or implied.  See the License for the
     */  
    public SearchShard(@Nullable String clusterAlias, ShardId shardId) {  
import org.opensearch.core.index.shard.ShardId;
    @Override
        return clusterAlias;
    }  
        return "SearchShard{" + "clusterAlias='" + clusterAlias + '\'' + ", shardId=" + shardId + '}';
        if (this == o) return true;
 *
    /**
    @Override
    }
        return Objects.equals(clusterAlias, that.clusterAlias) && shardId.equals(that.shardId);
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
        return cmp != 0 ? cmp : shardId.compareTo(o.shardId);
 * of a shard used during the search action.  
