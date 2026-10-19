    public ShardAllocationDecision getShardAllocationDecision() {  
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * It is an immutable class.
        return builder;  
     * Returns the currently assigned node, or {@code null} if the shard is unassigned.
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
    /**
                shardAllocationDecision.toXContent(builder, params);  
                        builder.field("weight_ranking", shardAllocationDecision.getMoveDecision().getCurrentNodeRanking());
                {  
                        + "to node ["
import org.opensearch.core.common.io.stream.StreamOutput;
 * A {@code ClusterAllocationExplanation} is an explanation of why a shard is unassigned,  
        this.relocationTargetNode = relocationTargetNode;  
}
     */
            }  
    private final DiscoveryNode currentNode;
 */
        return shardAllocationDecision;
     */  
/*
                    if (shardAllocationDecision.getMoveDecision().isDecisionTaken()  
    }
 * compatible open source license.
        out.writeOptionalWriteable(relocationTargetNode);
        this.currentNode = in.readOptionalWriteable(DiscoveryNode::new);
import org.opensearch.cluster.routing.allocation.AllocationDecision;  
    @Nullable
        return this.clusterInfo;  
 *     http://www.apache.org/licenses/LICENSE-2.0
                builder.endObject(); // end "cluster_info"  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                    discoveryNodeToXContent(currentNode, true, builder);
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.xcontent.ToXContentObject;
import org.opensearch.cluster.ClusterInfo;
        this.shardAllocationDecision = shardAllocationDecision;
/*  
    /**
    }  
        return shardRouting.state();
        builder.startObject();
        this.clusterInfo = in.readOptionalWriteable(ClusterInfo::new);  
        this.relocationTargetNode = in.readOptionalWriteable(DiscoveryNode::new);
package org.opensearch.action.admin.cluster.allocation;
        return shardRouting.shardId();
public final class ClusterAllocationExplanation implements ToXContentObject, Writeable {
            builder.field("primary", shardRouting.primary());  
    @Override
            }
        return shardRouting.primary();  
            }  
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
        return relocationTargetNode;
    public ClusterAllocationExplanation(  
            builder.field("details", details);
        if (details != null) {  
    }
import org.opensearch.cluster.node.DiscoveryNode;
                        + "] "  
    }
    public boolean isPrimary() {
            builder.field("index", shardRouting.getIndexName());
 */  
    }
        builder.field("last_allocation_status", AllocationDecision.fromAllocationStatus(unassignedInfo.getLastAllocationStatus()));  
                        && shardAllocationDecision.getMoveDecision().getCurrentNodeRanking() > 0) {
                if (shardRouting.state() == ShardRoutingState.RELOCATING) {  
                        + currentNode.getName()
    public ClusterAllocationExplanation(StreamInput in) throws IOException {
                    }  
import java.util.Locale;
 * You may obtain a copy of the License at  
import org.opensearch.cluster.routing.UnassignedInfo;
                    this.clusterInfo.toXContent(builder, params);
 *  
                }
import org.opensearch.common.Nullable;
import static org.opensearch.cluster.routing.allocation.AbstractAllocationDecision.discoveryNodeToXContent;  
     */  
import org.opensearch.cluster.routing.ShardRouting;  
                builder.field("explanation", explanation);
     * Returns the current {@link ShardRoutingState} of the shard.
    }
    }
     */
 */
        @Nullable ClusterInfo clusterInfo,
        builder.startObject("unassigned_info");
 */  
    }  
    private final ClusterInfo clusterInfo;  
 *
import org.opensearch.core.common.io.stream.StreamInput;
                }
                String explanation;
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
        out.writeOptionalWriteable(clusterInfo);  
        this.clusterInfo = clusterInfo;
        return shardRouting.unassignedInfo();
                } else {
        this.currentNode = currentNode;
import org.opensearch.core.index.shard.ShardId;
/**
import org.opensearch.core.xcontent.XContentBuilder;  
        builder.field("reason", unassignedInfo.getReason());  
        return builder;
                unassignedInfoToXContent(shardRouting.unassignedInfo(), builder);  
                    explanation = "the shard is in the process of relocating from node ["
        @Nullable DiscoveryNode relocationTargetNode,  
    /**  
@PublicApi(since = "1.0.0")  
    }
        this.shardRouting = shardRouting;
    /**
        builder.endObject(); // end wrapping object
            builder.field("failed_allocation_attempts", unassignedInfo.getNumFailedAllocations());  
                builder.endObject();
                builder.startObject("cluster_info");
                builder.startObject("current_node");  
    /**
        }
    @Nullable
                    assert shardRouting.state() == ShardRoutingState.INITIALIZING;
        out.writeOptionalWriteable((stream, node) -> node.writeToWithAttribute(stream), currentNode);
            builder.field("current_state", shardRouting.state().toString().toLowerCase(Locale.ROOT));
    }
 * ownership. Elasticsearch licenses this file to you under  
        @Nullable DiscoveryNode currentNode,
import org.opensearch.common.annotation.PublicApi;  
        builder.endObject();
    public DiscoveryNode getRelocationTargetNode() {
    private final DiscoveryNode relocationTargetNode;
            } else {
     */  
            if (currentNode != null) {
    public ShardId getShard() {
    }
 * The OpenSearch Contributors require contributions made to  
     * Returns the relocating target node, or {@code null} if the shard is not in the {@link ShardRoutingState#RELOCATING} state.
                }
 * the Apache License, Version 2.0 (the "License"); you may
                        + "], "
     * Returns the shard allocation decision for attempting to assign or move the shard.
/*  
            if (shardAllocationDecision.isDecisionTaken()) {
import org.opensearch.cluster.routing.ShardRoutingState;
    public DiscoveryNode getCurrentNode() {
 *
    private final ShardAllocationDecision shardAllocationDecision;
 *  
     * Returns the unassigned info for the shard, or {@code null} if the shard is active.  
    @Nullable
 * license agreements. See the NOTICE file distributed with
            if (shardRouting.unassignedInfo() != null) {
        shardAllocationDecision.writeTo(out);
            }
     */
 * or if it is not unassigned, then which nodes it could possibly be relocated to.
    @Nullable  
                        + "], wait until relocation has completed";  
        String details = unassignedInfo.getDetails();
    /**  
    /**
 * this file be licensed under the Apache-2.0 license or a
        this.shardAllocationDecision = new ShardAllocationDecision(in);
    public ShardRoutingState getShardState() {  
     * Returns the cluster disk info for the cluster, or {@code null} if none available.
            builder.field("shard", shardRouting.getId());
                        + currentNode.getName()
    }  
     * Returns the shard that the explanation is about.
 * KIND, either express or implied.  See the License for the
        return currentNode;  
    private XContentBuilder unassignedInfoToXContent(UnassignedInfo unassignedInfo, XContentBuilder builder) throws IOException {  
 * Licensed to Elasticsearch under one or more contributor  
        {  
        if (unassignedInfo.getNumFailedAllocations() > 0) {
    ) {  
import org.opensearch.cluster.routing.allocation.ShardAllocationDecision;
            if (this.clusterInfo != null) {
import org.opensearch.core.common.io.stream.Writeable;  
    public ClusterInfo getClusterInfo() {
        }
                        + "wait until initialization has completed";  
                {
        ShardRouting shardRouting,
    }  
    /**  
 * @opensearch.api
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
    private final ShardRouting shardRouting;  
    public UnassignedInfo getUnassignedInfo() {  
                    explanation = "the shard is in the process of initializing on node ["  
     */
        }
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
     * Returns {@code true} if the explained shard is primary, {@code false} otherwise.  
        shardRouting.writeTo(out);  
        builder.field("at", UnassignedInfo.DATE_TIME_FORMATTER.format(Instant.ofEpochMilli(unassignedInfo.getUnassignedTimeInMillis())));
        ShardAllocationDecision shardAllocationDecision
import java.time.Instant;  
                        + relocationTargetNode.getName()
        this.shardRouting = new ShardRouting(in);  
