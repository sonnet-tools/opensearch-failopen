            sb.append("index=").append(index);
            if (this.shard == null) {
    /**
        }
    public String getIndex() {
    @Override
    }
        this.includeYesDecisions = includeYesDecisions;
            }
        sb.append(",includeYesDecisions?=").append(includeYesDecisions);
     * {@code false} if explaining a replica shard copy for the shard id, or {@code null} to use any
     * Requests the explain API to explain an already assigned replica shard currently allocated to
    }
    public ClusterAllocationExplainRequest setCurrentNode(String currentNodeId) {
        if (this.useAnyUnassignedShard() == false) {
    }
        return this;
        out.writeBoolean(includeDiskInfo);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public ClusterAllocationExplainRequest setPrimary(Boolean primary) {
    @Nullable
    public ActionRequestValidationException validate() {
 */
     * decisions are returned.
 * GitHub history for details.
        this.currentNode = currentNodeId;
    @Nullable
 * SPDX-License-Identifier: Apache-2.0
     * Sets whether to explain the allocation of the primary shard or a replica shard copy
     */
    public void includeDiskInfo(boolean includeDiskInfo) {
        return this.index == null && this.shard == null && this.primary == null && this.currentNode == null;
    }
     * Create a new allocation explain request to explain any unassigned shard in the cluster.
    public String getCurrentNode() {
            if (currentNode != null) {
    public String toString() {
    }
 */
@PublicApi(since = "1.0.0")
        super(in);
        return this;
 * this work for additional information regarding copyright
    /**
     * Returns the index name of the shard to explain, or {@code null} to use any unassigned shard (see {@link #useAnyUnassignedShard()}).
     * be explained.
     */
    ClusterAllocationExplainRequest(String index, int shard, boolean primary, @Nullable String currentNode) {
        this.shard = null;
    /**
    private Boolean primary;
     */
    public Boolean isPrimary() {
 * A request to explain the allocation of a shard in the cluster
     */
     * Package private for testing.
 * license agreements. See the NOTICE file distributed with
     * for the shard id (see {@link #getShard()}).
     * <p>
        this.includeDiskInfo = in.readBoolean();
     */
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
    /**
    private String index;
     */
        out.writeBoolean(includeYesDecisions);
        return validationException;
 * KIND, either express or implied.  See the License for the
        ActionRequestValidationException validationException = null;
     * Returns {@code true} if information about disk usage and shard sizes should also be returned.
     */
 *
     */
    /**
        this.shard = shard;
    static {
                validationException = addValidationError("shard must be specified", validationException);
 * compatible open source license.
     */
import org.opensearch.common.annotation.PublicApi;
    }
    public void writeTo(StreamOutput out) throws IOException {
        return this.shard;
    @Nullable
     */
    }
     * Returns {@code true} if yes decisions should be included.  Otherwise only "no" and "throttle"
    /**
    public ClusterAllocationExplainRequest() {
     */
    /**
import static org.opensearch.action.ValidateActions.addValidationError;
import org.opensearch.core.xcontent.ObjectParser;
    /**
        PARSER.declareInt(ClusterAllocationExplainRequest::setShard, new ParseField("shard"));
    /**
    }
     */
     * Create a new allocation explain request. If {@code primary} is false, the first unassigned replica
    public void includeYesDecisions(boolean includeYesDecisions) {
    }
 * specific language governing permissions and limitations
            sb.append(",primary?=").append(primary);
        this.primary = null;
    public ClusterAllocationExplainRequest setShard(Integer shard) {
    }
        return this;
    public boolean includeYesDecisions() {
    }
    }
        return currentNode;
    private static final ObjectParser<ClusterAllocationExplainRequest, Void> PARSER = new ObjectParser<>("cluster/allocation/explain");
import java.io.IOException;
     */
        } else {
    }
 * Licensed to Elasticsearch under one or more contributor
        PARSER.declareString(ClusterAllocationExplainRequest::setCurrentNode, new ParseField("current_node"));
    }
     * Set to {@code true} to include information about the gathered disk information of nodes in the cluster.
        this.currentNode = currentNode;
        out.writeOptionalString(index);
        PARSER.declareString(ClusterAllocationExplainRequest::setIndex, new ParseField("index"));
 */
    public static ClusterAllocationExplainRequest parse(XContentParser parser) throws IOException {
        this.includeDiskInfo = includeDiskInfo;
 * software distributed under the License is distributed on an
/*
    }
        return sb.toString();
    @Override
        this.shard = shard;
 * Unless required by applicable law or agreed to in writing,
    /**
        this.index = index;
    private boolean includeDiskInfo = false;
     * will be picked for explanation. If no replicas are unassigned, the first assigned replica will
    private String currentNode;
        this.index = in.readOptionalString();
        this.includeYesDecisions = in.readBoolean();
package org.opensearch.action.admin.cluster.allocation;
     * can be explained.
                validationException = addValidationError("index must be specified", validationException);
 *
    /**
        return this.index;
 * @opensearch.api
     * Returns the node holding the replica shard to be explained.  Returns {@code null} if any replica shard
 */
    private Integer shard;
        out.writeOptionalBoolean(primary);
    }
    public ClusterAllocationExplainRequest(StreamInput in) throws IOException {
import org.opensearch.core.ParseField;
        return this;
    @Nullable
 *
/*
        this.primary = primary;
     * Sets the shard id of the shard to explain.
            }
            }
        this.primary = primary;
        StringBuilder sb = new StringBuilder("ClusterAllocationExplainRequest[");
    }
/**
import org.opensearch.core.common.io.stream.StreamInput;
    }
        this.shard = in.readOptionalVInt();
/*
    @Nullable
     * Returns {@code true} if explaining the primary shard for the shard id (see {@link #getShard()}),
        PARSER.declareBoolean(ClusterAllocationExplainRequest::setPrimary, new ParseField("primary"));
            if (this.primary == null) {
        this.currentNode = in.readOptionalString();
        super.writeTo(out);
     * Set to {@code true} to include yes decisions for a particular node.
 * not use this file except in compliance with the License.
        }
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
        if (this.useAnyUnassignedShard()) {
        return this.includeYesDecisions;
import org.opensearch.action.ActionRequestValidationException;
    @Nullable
    /**
            sb.append("useAnyUnassignedShard=true");
            sb.append(",shard=").append(shard);
    /**
    }
import org.opensearch.common.Nullable;
    @Nullable
}
     * the given node.
 * Modifications Copyright OpenSearch Contributors. See
 *
     * Returns {@code true} iff the first unassigned shard is to be used
        this.index = index;
     * unassigned shard (see {@link #useAnyUnassignedShard()}).
    /**
        out.writeOptionalVInt(shard);
    @Override
        this.primary = in.readOptionalBoolean();
     * Returns the shard id of the shard to explain, or {@code null} to use any unassigned shard (see {@link #useAnyUnassignedShard()}).
    }
     */
        return PARSER.parse(parser, new ClusterAllocationExplainRequest(), null);
        out.writeOptionalString(currentNode);
    /**
 * under the License.
        return this.primary;
        this.currentNode = null;
    public boolean useAnyUnassignedShard() {
                sb.append(",currentNode=").append(currentNode);
    private boolean includeYesDecisions = false;
                validationException = addValidationError("primary must be specified", validationException);
            if (this.index == null) {
 * ownership. Elasticsearch licenses this file to you under
    }
 * The OpenSearch Contributors require contributions made to
    public ClusterAllocationExplainRequest setIndex(String index) {
import org.opensearch.core.xcontent.XContentParser;
    public boolean includeDiskInfo() {
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
        this.index = null;
     */
            }
    public Integer getShard() {
    @Nullable
import org.opensearch.core.common.io.stream.StreamOutput;
        return this.includeDiskInfo;
public class ClusterAllocationExplainRequest extends ClusterManagerNodeRequest<ClusterAllocationExplainRequest> {
     * Sets the index name of the shard to explain.
