import org.opensearch.action.IndicesRequest;
        sb.append("], ");
 * You may obtain a copy of the License at  
        StringBuilder sb = new StringBuilder();
        this.dfs = dfs;
 *  
        return sb.toString();  
        shardSearchRequest = in.readOptionalWriteable(ShardSearchRequest::new);  
package org.opensearch.search.query;
    }
        dfs.writeTo(out);
import org.opensearch.action.support.IndicesOptions;
        sb.append("id[");  
    public ShardSearchRequest shardSearchRequest() {  
        ShardSearchContextId contextId,  
        originalIndices = OriginalIndices.readOriginalIndices(in);
        dfs = new AggregatedDfs(in);
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.io.stream.StreamInput;
 * Unless required by applicable law or agreed to in writing,
import java.util.Map;
 * license agreements. See the NOTICE file distributed with
    }
        Strings.arrayToDelimitedString(originalIndices.indices(), ",", sb);
    public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {  
        OriginalIndices originalIndices,
    private final ShardSearchRequest shardSearchRequest;
 */  
 * not use this file except in compliance with the License.
        contextId = new ShardSearchContextId(in);  
 * ownership. Elasticsearch licenses this file to you under  
    @Override  
    }  
 * this work for additional information regarding copyright
 * Transport request for query search
 */
    @Override
        AggregatedDfs dfs
    }
/*  
        this.shardSearchRequest = shardSearchRequest;  
    @Nullable
 */
        this.originalIndices = originalIndices;
 * Licensed to Elasticsearch under one or more contributor  
}  
        OriginalIndices.writeOriginalIndices(originalIndices, out);
        contextId.writeTo(out);  
        return originalIndices.indicesOptions();
        return shardSearchRequest().getMetadataSupplier();
import org.opensearch.action.search.SearchShardTask;  
        out.writeOptionalWriteable(shardSearchRequest);  
    public AggregatedDfs dfs() {
    private final ShardSearchContextId contextId;
import java.io.IOException;
 * under the License.  
        return new SearchShardTask(id, type, action, getDescription(), parentTaskId, headers, this::getMetadataSupplier);
 * Modifications Copyright OpenSearch Contributors. See
 *
        super(in);
    }
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void writeTo(StreamOutput out) throws IOException {
    ) {  
    public String getMetadataSupplier() {  
        super.writeTo(out);
/*
    public QuerySearchRequest(StreamInput in) throws IOException {
import org.opensearch.common.Nullable;
 */  
import org.opensearch.search.internal.ShardSearchRequest;  
    private final OriginalIndices originalIndices;
 *  
import org.opensearch.search.internal.ShardSearchContextId;
import org.opensearch.transport.TransportRequest;
    private final AggregatedDfs dfs;  
 * the Apache License, Version 2.0 (the "License"); you may
/**
        sb.append("indices[");  
 * SPDX-License-Identifier: Apache-2.0
        return dfs;
    public IndicesOptions indicesOptions() {
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.tasks.Task;
 *
 * KIND, either express or implied.  See the License for the
import org.opensearch.search.dfs.AggregatedDfs;
        sb.append(contextId);
 * @opensearch.internal
 * compatible open source license.
import org.opensearch.core.tasks.TaskId;  
    public String getDescription() {
    public ShardSearchContextId contextId() {  
    public QuerySearchRequest(
    @Override
import org.opensearch.action.OriginalIndices;
    public String[] indices() {
        return shardSearchRequest;
    }  
    }
        return contextId;
 * software distributed under the License is distributed on an
        this.contextId = contextId;
    @Override  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        return originalIndices.indices();  
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
import org.opensearch.core.common.Strings;  
        sb.append("]");
/*  
 * specific language governing permissions and limitations
        ShardSearchRequest shardSearchRequest,
    }
public class QuerySearchRequest extends TransportRequest implements IndicesRequest {  
    }
