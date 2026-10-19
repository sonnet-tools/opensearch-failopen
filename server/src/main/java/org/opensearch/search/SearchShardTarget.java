    }
/*
    }  
 *  
import org.opensearch.common.Nullable;
    }
 * this work for additional information regarding copyright
        return RemoteClusterAware.buildRemoteIndexName(clusterAlias, getIndex());
            nodeId = null;  
    }
    // original indices are only needed in the coordinating node throughout the search request execution.  
    @Override
    public ShardId getShardId() {  
            return false;
 * this file be licensed under the Apache-2.0 license or a
        this.nodeId = nodeId == null ? null : new Text(nodeId);
/*  
        } else {  
        if (this == o) {
    public String getClusterAlias() {  
        int i = shardId.getIndexName().compareTo(o.getIndex());
        this.originalIndices = originalIndices;
            out.writeText(nodeId);
import org.opensearch.core.common.text.Text;
public final class SearchShardTarget implements Writeable, Comparable<SearchShardTarget> {
        return this.nodeId;
import java.io.IOException;
        return originalIndices;
        }
 * under the License.  
    @Override
    @Nullable
import org.opensearch.action.OriginalIndices;
        if (nodeId == null) {
package org.opensearch.search;
    public String getNodeId() {  
        shardId.writeTo(out);
        } else {
    @Override
 * ownership. Elasticsearch licenses this file to you under  
    public String toString() {
            && Objects.equals(shardId, that.shardId)  
 * software distributed under the License is distributed on an
        }  
        return Objects.hash(nodeId, shardId, clusterAlias);  
    /**
    public Text getNodeIdText() {
            return "[_na_]" + shardToString;
    }  
            && Objects.equals(clusterAlias, that.clusterAlias);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
     * Returns the fully qualified index name, including the index prefix that indicates which cluster results come from.
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
    public int hashCode() {
        this.originalIndices = null;  
import org.opensearch.core.index.shard.ShardId;
    public String getIndex() {
    private final String clusterAlias;  
            i = shardId.getId() - o.shardId.id();  
    }
    public SearchShardTarget(StreamInput in) throws IOException {
    @Override  
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (i == 0) {
import java.util.Objects;  
import org.opensearch.transport.RemoteClusterAware;  
        return "[" + nodeId + "]" + shardToString;
import org.opensearch.core.common.io.stream.StreamOutput;
@PublicApi(since = "1.0.0")
    }
        return shardId;
    @Override
    }  
    public SearchShardTarget(String nodeId, ShardId shardId, @Nullable String clusterAlias, OriginalIndices originalIndices) {
    }  
        shardId = new ShardId(in);
 * license agreements. See the NOTICE file distributed with
        if (o == null || getClass() != o.getClass()) {
    private final Text nodeId;
 * Modifications Copyright OpenSearch Contributors. See
        }  
        this.shardId = shardId;  
            out.writeBoolean(true);
 */  
 * The OpenSearch Contributors require contributions made to  
        this.clusterAlias = clusterAlias;
import org.opensearch.core.common.io.stream.Writeable;  
 * KIND, either express or implied.  See the License for the
            + "]";  
 * @opensearch.api
 * GitHub history for details.
 *
import org.opensearch.common.annotation.PublicApi;  
        clusterAlias = in.readOptionalString();
import org.opensearch.core.common.io.stream.StreamInput;
/*  
    public boolean equals(Object o) {  
 * The target that the search request was executed on.  
        }
        return nodeId != null ? nodeId.string() : null;
            + "]["
        String shardToString = "["
        return i;
 * not use this file except in compliance with the License.
    }
    }  
    public String getFullyQualifiedIndexName() {
 * Unless required by applicable law or agreed to in writing,
    private final ShardId shardId;
    public void writeTo(StreamOutput out) throws IOException {  
        return shardId.getIndexName();  
    }
        }  
        SearchShardTarget that = (SearchShardTarget) o;
    @Nullable
 * Licensed to Elasticsearch under one or more contributor  
    public OriginalIndices getOriginalIndices() {
    public int compareTo(SearchShardTarget o) {  
            return true;
    private final transient OriginalIndices originalIndices;
 */
 *
        if (nodeId == null) {
            nodeId = in.readText();
            + shardId.getId()
/**
            + RemoteClusterAware.buildRemoteIndexName(clusterAlias, shardId.getIndexName())  
        if (in.readBoolean()) {  
            out.writeBoolean(false);
 */  
}  
 */  
    // no need to serialize them as part of SearchShardTarget.
        out.writeOptionalString(clusterAlias);
    }
        }  
     */  
    }  
        return clusterAlias;
 *
        return Objects.equals(nodeId, that.nodeId)
