     */
     */
     * Create a request for shard stores info for <code>indices</code>
import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadRequest;  
        return indicesOptions;
            statuses.add(ClusterHealthStatus.fromString(statusString));
    /**  
 * @opensearch.api
 * Request for {@link IndicesShardStoresAction}
import org.opensearch.core.common.io.stream.StreamInput;
        return true;  
        this.indices = indices;
    @Override
    public IndicesShardStoresRequest indices(String... indices) {
    public IndicesShardStoresRequest shardStatuses(String... shardStatuses) {
        super(in);
        statuses = EnumSet.noneOf(ClusterHealthStatus.class);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return this;
/**
/*
        indicesOptions.writeIndicesOptions(out);
        return statuses;
     * Specifies what type of requested indices to ignore and wildcard indices expressions
        return this;
    public boolean includeDataStreams() {
    public IndicesOptions indicesOptions() {
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.common.annotation.PublicApi;
    public IndicesShardStoresRequest(StreamInput in) throws IOException {  
     */
public class IndicesShardStoresRequest extends ClusterManagerNodeReadRequest<IndicesShardStoresRequest>
    }
 * Unless required by applicable law or agreed to in writing,
        return this;
            if ("all".equalsIgnoreCase(statusString)) {
    public ActionRequestValidationException validate() {  
 *  
 */
     */  
    }
/*  
        for (String statusString : shardStatuses) {  
        IndicesRequest.Replaceable {  
        }
        super.writeTo(out);
     * Sets the indices for the shard stores request
    }
     * Returns the shard criteria to get store information on
 * software distributed under the License is distributed on an
    implements
    public IndicesShardStoresRequest(String... indices) {  
import org.opensearch.core.common.Strings;  
        this.indices = indices;  
 * license agreements. See the NOTICE file distributed with
                statuses = EnumSet.allOf(ClusterHealthStatus.class);
            statuses.add(ClusterHealthStatus.fromValue(in.readByte()));  
 *
    private EnumSet<ClusterHealthStatus> statuses = EnumSet.of(ClusterHealthStatus.YELLOW, ClusterHealthStatus.RED);
/*
import java.util.EnumSet;
        }  
    }  
     * Defaults to "yellow" and "red" status
        out.writeStringArrayNullable(indices);
 * The OpenSearch Contributors require contributions made to  
        indices = in.readStringArray();
 * ownership. Elasticsearch licenses this file to you under  
        this.indicesOptions = indicesOptions;  
        out.writeVInt(statuses.size());  
    public EnumSet<ClusterHealthStatus> shardStatuses() {  
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
    public String[] indices() {
 * GitHub history for details.
        indicesOptions = IndicesOptions.readIndicesOptions(in);
import org.opensearch.action.IndicesRequest;
    public IndicesShardStoresRequest indicesOptions(IndicesOptions indicesOptions) {
    }  
}  
    @Override
 * not use this file except in compliance with the License.
            out.writeByte(status.value());
    /**
     * @param shardStatuses acceptable values are "green", "yellow", "red" and "all"
                return this;  
    @Override  
        return null;
    }
import org.opensearch.action.support.IndicesOptions;
import org.opensearch.cluster.health.ClusterHealthStatus;
     * see {@link ClusterHealthStatus} for details.  
    public void writeTo(StreamOutput out) throws IOException {  
        for (int i = 0; i < nStatus; i++) {
    /**
    /**  
        for (ClusterHealthStatus status : statuses) {
 * KIND, either express or implied.  See the License for the
 */
     * Set statuses to filter shards to get stores info on.
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
@PublicApi(since = "1.0.0")  
    }
 * this work for additional information regarding copyright
 *
    @Override
import org.opensearch.core.common.io.stream.StreamOutput;
    public IndicesShardStoresRequest() {}
 *     http://www.apache.org/licenses/LICENSE-2.0
     * By default, expands wildcards to both open and closed indices  
     */  
            }
    @Override
    /**
import java.io.IOException;
 *  
    }
    private String[] indices = Strings.EMPTY_ARRAY;
    @Override
    }
 */  
        statuses = EnumSet.noneOf(ClusterHealthStatus.class);
 * under the License.  
    private IndicesOptions indicesOptions = IndicesOptions.strictExpand();  
import org.opensearch.action.ActionRequestValidationException;  
 */
        }  
    }
    }
 * Licensed to Elasticsearch under one or more contributor  
        int nStatus = in.readVInt();  
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
        return indices;  
package org.opensearch.action.admin.indices.shards;
