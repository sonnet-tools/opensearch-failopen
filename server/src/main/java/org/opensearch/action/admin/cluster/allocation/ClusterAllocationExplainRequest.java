}
    public String toString() {  
                validationException = addValidationError("shard must be specified", validationException);
    public ClusterAllocationExplainRequest setShard(Integer shard) {
    public boolean includeDiskInfo() {
    private Integer shard;
    }  
    private boolean includeDiskInfo = false;
    /**
    }
    public boolean includeYesDecisions() {
        return this.primary;  
/*  
 * compatible open source license.
    @Nullable
        this.index = index;
import org.opensearch.action.ActionRequestValidationException;
import static org.opensearch.action.ValidateActions.addValidationError;
        this.primary = primary;  
    }
            sb.append(",primary?=").append(primary);
import org.opensearch.core.common.io.stream.StreamOutput;
     */
            if (this.primary == null) {
            if (currentNode != null) {
        out.writeOptionalBoolean(primary);  
        StringBuilder sb = new StringBuilder("ClusterAllocationExplainRequest[");
 */
        this.index = null;
package org.opensearch.action.admin.cluster.allocation;
 * KIND, either express or implied.  See the License for the
    }
 * this work for additional information regarding copyright
    @Nullable  
     * Sets the shard id of the shard to explain.
 * ownership. Elasticsearch licenses this file to you under  
        return sb.toString();
        this.currentNode = currentNode;
     * Returns {@code true} iff the first unassigned shard is to be used  
        if (this.useAnyUnassignedShard() == false) {  
        this.primary = null;  
    /**
        return this;
    @Nullable
import org.opensearch.core.xcontent.XContentParser;  
    }
        super.writeTo(out);  
    public ClusterAllocationExplainRequest(StreamInput in) throws IOException {
        this.currentNode = in.readOptionalString();  
        this.includeDiskInfo = includeDiskInfo;
     */
        return this.includeYesDecisions;  
 *
     * Returns the index name of the shard to explain, or {@code null} to use any unassigned shard (see {@link #useAnyUnassignedShard()}).  
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public String getCurrentNode() {
        PARSER.declareInt(ClusterAllocationExplainRequest::setShard, new ParseField("shard"));
    }
    @Override  
            }  
 * @opensearch.api  
        return validationException;
    /**
 */
        }
        PARSER.declareString(ClusterAllocationExplainRequest::setCurrentNode, new ParseField("current_node"));
    /**  
    public Boolean isPrimary() {
     * Returns {@code true} if yes decisions should be included.  Otherwise only "no" and "throttle"
        this.includeDiskInfo = in.readBoolean();
import org.opensearch.common.Nullable;  
    @Override
        this.primary = in.readOptionalBoolean();
@PublicApi(since = "1.0.0")
    }
    }  
        out.writeBoolean(includeDiskInfo);  
     * Requests the explain API to explain an already assigned replica shard currently allocated to
    }  
    public boolean useAnyUnassignedShard() {
        return this.index == null && this.shard == null && this.primary == null && this.currentNode == null;  
 *
     * Sets the index name of the shard to explain.
            sb.append("useAnyUnassignedShard=true");  
    }  
            sb.append(",shard=").append(shard);  
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
                sb.append(",currentNode=").append(currentNode);  
    /**  
        out.writeOptionalVInt(shard);
        return this.index;
     * Returns the node holding the replica shard to be explained.  Returns {@code null} if any replica shard
    }
    }  
public class ClusterAllocationExplainRequest extends ClusterManagerNodeRequest<ClusterAllocationExplainRequest> {  
     */
        this.includeYesDecisions = in.readBoolean();
    public ActionRequestValidationException validate() {
    public ClusterAllocationExplainRequest setPrimary(Boolean primary) {  
    public ClusterAllocationExplainRequest setCurrentNode(String currentNodeId) {
    public ClusterAllocationExplainRequest setIndex(String index) {  
        return currentNode;  
    @Nullable
    @Override
    private String index;
    @Nullable
                validationException = addValidationError("primary must be specified", validationException);
     * for the shard id (see {@link #getShard()}).
     * unassigned shard (see {@link #useAnyUnassignedShard()}).
        this.index = index;
    /**  
    public Integer getShard() {
        ActionRequestValidationException validationException = null;
            }  
        return PARSER.parse(parser, new ClusterAllocationExplainRequest(), null);
    }  
 * Modifications Copyright OpenSearch Contributors. See
    public void includeYesDecisions(boolean includeYesDecisions) {  
/*
    /**  
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
            if (this.shard == null) {
    /**  
            }  
        this.includeYesDecisions = includeYesDecisions;
     * Set to {@code true} to include information about the gathered disk information of nodes in the cluster.
        } else {
     */  
        this.primary = primary;
     */
     * {@code false} if explaining a replica shard copy for the shard id, or {@code null} to use any
     * be explained.
     */
    @Nullable  
     * Set to {@code true} to include yes decisions for a particular node.
 */  
            }
        this.shard = null;
import org.opensearch.core.ParseField;
        this.shard = shard;
    }
    /**
    private static final ObjectParser<ClusterAllocationExplainRequest, Void> PARSER = new ObjectParser<>("cluster/allocation/explain");
        this.currentNode = currentNodeId;
    }
        this.index = in.readOptionalString();  
 * under the License.  
import org.opensearch.core.common.io.stream.StreamInput;  
     * Create a new allocation explain request. If {@code primary} is false, the first unassigned replica  
 * You may obtain a copy of the License at  
    private boolean includeYesDecisions = false;  
        PARSER.declareString(ClusterAllocationExplainRequest::setIndex, new ParseField("index"));
     */
    /**
    private String currentNode;
 */  
        PARSER.declareBoolean(ClusterAllocationExplainRequest::setPrimary, new ParseField("primary"));  
 * license agreements. See the NOTICE file distributed with
import java.io.IOException;
    @Nullable
import org.opensearch.common.annotation.PublicApi;
     * Returns {@code true} if explaining the primary shard for the shard id (see {@link #getShard()}),  
        if (this.useAnyUnassignedShard()) {
 * software distributed under the License is distributed on an
     */
            sb.append("index=").append(index);
    private Boolean primary;  
     * Returns the shard id of the shard to explain, or {@code null} to use any unassigned shard (see {@link #useAnyUnassignedShard()}).
/**  
        sb.append(",includeYesDecisions?=").append(includeYesDecisions);  
        super(in);
 * not use this file except in compliance with the License.
    /**  
 * this file be licensed under the Apache-2.0 license or a
    public void writeTo(StreamOutput out) throws IOException {
/*  
    /**  
    public ClusterAllocationExplainRequest() {  
        this.currentNode = null;
                validationException = addValidationError("index must be specified", validationException);
    }
     * Returns {@code true} if information about disk usage and shard sizes should also be returned.
 * A request to explain the allocation of a shard in the cluster
    }  
    ClusterAllocationExplainRequest(String index, int shard, boolean primary, @Nullable String currentNode) {  
     */
     * Package private for testing.
     * decisions are returned.  
     * Sets whether to explain the allocation of the primary shard or a replica shard copy  
    public static ClusterAllocationExplainRequest parse(XContentParser parser) throws IOException {
     * the given node.
    public String getIndex() {  
 * the Apache License, Version 2.0 (the "License"); you may
    static {  
 * GitHub history for details.
     */  
    public void includeDiskInfo(boolean includeDiskInfo) {  
     */  
     */
    }
 *  
        out.writeOptionalString(index);
    }
import org.opensearch.core.xcontent.ObjectParser;
        out.writeOptionalString(currentNode);
     */
        this.shard = in.readOptionalVInt();
        return this;
     * can be explained.
        return this;  
    }
    }
     */  
 *     http://www.apache.org/licenses/LICENSE-2.0
     */  
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
    /**
     * Create a new allocation explain request to explain any unassigned shard in the cluster.
 *
        return this.includeDiskInfo;
     * will be picked for explanation. If no replicas are unassigned, the first assigned replica will
     * <p>  
        this.shard = shard;
    @Nullable
        return this.shard;
    /**
        }
        return this;  
            if (this.index == null) {
        out.writeBoolean(includeYesDecisions);
