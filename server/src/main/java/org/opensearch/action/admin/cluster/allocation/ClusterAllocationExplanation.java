 * not use this file except in compliance with the License.
    /**
        return builder;
 * ownership. Elasticsearch licenses this file to you under
    private final ClusterInfo clusterInfo;
                    assert shardRouting.state() == ShardRoutingState.INITIALIZING;
        return shardRouting.shardId();
        builder.field("last_allocation_status", AllocationDecision.fromAllocationStatus(unassignedInfo.getLastAllocationStatus()));
    /**
                    discoveryNodeToXContent(currentNode, true, builder);
            }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * license agreements. See the NOTICE file distributed with
     */
                builder.endObject();
                        builder.field("weight_ranking", shardAllocationDecision.getMoveDecision().getCurrentNodeRanking());
 */
     */
import java.io.IOException;
@PublicApi(since = "1.0.0")
                {
    /**
        this.shardAllocationDecision = shardAllocationDecision;
    @Nullable
 * Licensed to Elasticsearch under one or more contributor
                {
            builder.field("shard", shardRouting.getId());
        @Nullable DiscoveryNode relocationTargetNode,
 * A {@code ClusterAllocationExplanation} is an explanation of why a shard is unassigned,
        return builder;
 * specific language governing permissions and limitations
            builder.field("failed_allocation_attempts", unassignedInfo.getNumFailedAllocations());
        this.currentNode = in.readOptionalWriteable(DiscoveryNode::new);
import java.time.Instant;
        {
        this.shardRouting = new ShardRouting(in);
                    explanation = "the shard is in the process of relocating from node ["
     */
 * SPDX-License-Identifier: Apache-2.0
    private XContentBuilder unassignedInfoToXContent(UnassignedInfo unassignedInfo, XContentBuilder builder) throws IOException {
        this.shardRouting = shardRouting;
            } else {
package org.opensearch.action.admin.cluster.allocation;
     * Returns the cluster disk info for the cluster, or {@code null} if none available.
 * KIND, either express or implied.  See the License for the
     * Returns the unassigned info for the shard, or {@code null} if the shard is active.
import org.opensearch.core.xcontent.ToXContentObject;
    public ClusterAllocationExplanation(StreamInput in) throws IOException {
        return shardRouting.primary();
        builder.endObject(); // end wrapping object
 */
     * Returns the shard that the explanation is about.
    }
    private final ShardAllocationDecision shardAllocationDecision;
    public boolean isPrimary() {
     * Returns the shard allocation decision for attempting to assign or move the shard.
 * software distributed under the License is distributed on an
/*
        }
    }
    /**
                }
 * Unless required by applicable law or agreed to in writing,
        }
            builder.field("details", details);
                builder.field("explanation", explanation);
    /**
 * You may obtain a copy of the License at
     */
            if (shardAllocationDecision.isDecisionTaken()) {
                        + "to node ["
                        + currentNode.getName()
 *
        ShardAllocationDecision shardAllocationDecision
import org.opensearch.cluster.routing.allocation.AllocationDecision;
    /**
    }
                unassignedInfoToXContent(shardRouting.unassignedInfo(), builder);
 */
                    explanation = "the shard is in the process of initializing on node ["
/*
        builder.startObject("unassigned_info");
                        + "], "
            if (this.clusterInfo != null) {
        if (unassignedInfo.getNumFailedAllocations() > 0) {
import org.opensearch.core.common.io.stream.StreamInput;
 * Modifications Copyright OpenSearch Contributors. See
     * Returns the current {@link ShardRoutingState} of the shard.
        @Nullable DiscoveryNode currentNode,
            if (currentNode != null) {
     */
/*
     * Returns the currently assigned node, or {@code null} if the shard is unassigned.
            }
                }
                        + "wait until initialization has completed";
/**
                        + "], wait until relocation has completed";
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        return relocationTargetNode;
 *
                builder.startObject("cluster_info");
     */
    public ShardId getShard() {
    public UnassignedInfo getUnassignedInfo() {
 *
    private final ShardRouting shardRouting;
            builder.field("current_state", shardRouting.state().toString().toLowerCase(Locale.ROOT));
        builder.startObject();
    private final DiscoveryNode relocationTargetNode;
import org.opensearch.cluster.routing.UnassignedInfo;
    public DiscoveryNode getRelocationTargetNode() {
    /**
                    if (shardAllocationDecision.getMoveDecision().isDecisionTaken()
    ) {
 * this file be licensed under the Apache-2.0 license or a
import java.util.Locale;
        return shardAllocationDecision;
    }
                String explanation;
 * the Apache License, Version 2.0 (the "License"); you may
 * @opensearch.api
        this.shardAllocationDecision = new ShardAllocationDecision(in);
                builder.startObject("current_node");
        return shardRouting.state();
    /**
        builder.field("reason", unassignedInfo.getReason());
    }
import org.opensearch.common.annotation.PublicApi;
 * GitHub history for details.
                        + "] "
import static org.opensearch.cluster.routing.allocation.AbstractAllocationDecision.discoveryNodeToXContent;
import org.opensearch.core.common.io.stream.Writeable;
        shardAllocationDecision.writeTo(out);
        this.relocationTargetNode = relocationTargetNode;
    public ClusterAllocationExplanation(
 */
 * It is an immutable class.
        return shardRouting.unassignedInfo();
import org.opensearch.cluster.node.DiscoveryNode;
 * compatible open source license.
import org.opensearch.cluster.routing.allocation.ShardAllocationDecision;
                } else {
    }
                builder.endObject(); // end "cluster_info"
import org.opensearch.common.Nullable;
    @Override
            builder.field("primary", shardRouting.primary());
        }
import org.opensearch.cluster.ClusterInfo;
        this.clusterInfo = in.readOptionalWriteable(ClusterInfo::new);
                shardAllocationDecision.toXContent(builder, params);
        return this.clusterInfo;
        out.writeOptionalWriteable(relocationTargetNode);
 *     http://www.apache.org/licenses/LICENSE-2.0
public final class ClusterAllocationExplanation implements ToXContentObject, Writeable {
    }
    }
     */
    }
    public ClusterInfo getClusterInfo() {
        String details = unassignedInfo.getDetails();
 * or if it is not unassigned, then which nodes it could possibly be relocated to.
                    this.clusterInfo.toXContent(builder, params);
        out.writeOptionalWriteable(clusterInfo);
    }
        out.writeOptionalWriteable((stream, node) -> node.writeToWithAttribute(stream), currentNode);
                        && shardAllocationDecision.getMoveDecision().getCurrentNodeRanking() > 0) {
        if (details != null) {
        shardRouting.writeTo(out);
import org.opensearch.cluster.routing.ShardRouting;
    @Nullable
    public ShardAllocationDecision getShardAllocationDecision() {
        return currentNode;
            }
                        + currentNode.getName()
                }
            if (shardRouting.unassignedInfo() != null) {
        this.relocationTargetNode = in.readOptionalWriteable(DiscoveryNode::new);
    private final DiscoveryNode currentNode;
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.core.common.io.stream.StreamOutput;
    @Nullable
     * Returns the relocating target node, or {@code null} if the shard is not in the {@link ShardRoutingState#RELOCATING} state.
     */
     * Returns {@code true} if the explained shard is primary, {@code false} otherwise.
 * under the License.
    public DiscoveryNode getCurrentNode() {
}
 * this work for additional information regarding copyright
        ShardRouting shardRouting,
    }
    }
        @Nullable ClusterInfo clusterInfo,
                        + relocationTargetNode.getName()
    public void writeTo(StreamOutput out) throws IOException {
 * The OpenSearch Contributors require contributions made to
import org.opensearch.cluster.routing.ShardRoutingState;
        builder.field("at", UnassignedInfo.DATE_TIME_FORMATTER.format(Instant.ofEpochMilli(unassignedInfo.getUnassignedTimeInMillis())));
    }
                    }
import org.opensearch.core.index.shard.ShardId;
    @Nullable
    public ShardRoutingState getShardState() {
        this.clusterInfo = clusterInfo;
                if (shardRouting.state() == ShardRoutingState.RELOCATING) {
        this.currentNode = currentNode;
            builder.field("index", shardRouting.getIndexName());
        builder.endObject();
 *
            }
