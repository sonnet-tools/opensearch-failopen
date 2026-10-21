     * weight will be 2, and node1's weight will be 1.  A value of 0 means the weight was
            builder.startObject("store");
 * the Apache License, Version 2.0 (the "License"); you may
     * shard, followed by node3, followed by node1, then node2's weight will be 1, node3's
 * license agreements. See the NOTICE file distributed with
     * @opensearch.api
         * shard, or this explanation pertains to the allocation of a primary shard, in which case
 *
    private final DiscoveryNode node;
        @Override
        }
    }
 * Modifications Copyright OpenSearch Contributors. See
            this.inSync = false;
 * The OpenSearch Contributors require contributions made to
     * no allocation decision was taken on the node; in this case, {@link #getNodeDecision()}
     *
import org.opensearch.core.xcontent.ToXContentFragment;
    public int getWeightRanking() {
        public ShardStoreInfo(String allocationId, boolean inSync, Exception storeException) {
                if (allocationId != null) {
    private final int weightRanking;
    private final Decision canAllocateDecision;
            if (canAllocateDecision != null && canAllocateDecision.getDecisions().isEmpty() == false) {
        return weightRanking;
                if (matchingBytes < 0) {
import org.opensearch.core.common.unit.ByteSizeValue;
 * this work for additional information regarding copyright
     * The weight ranking for allocating a shard to the node.  Each node will have
         * Returns {@code false} if the shard copy is stale or if the shard copy being examined
                    builder.endObject();
    }
            builder.field("node_decision", nodeDecision);
     * The decision details for allocating to this node.  Returns {@code null} if
        this.canAllocateDecision = decision;
                if (storeException != null) {
         * Returns -1 if not applicable (this value only applies to assigning replica shards).
         * Returns {@code false} if the shard copy does not have a matching sync id with the primary
    public NodeAllocationResult(DiscoveryNode node, ShardStoreInfo shardStoreInfo, @Nullable Decision decision) {
                }
        /**
    public DiscoveryNode getNode() {
/**
            if (shardStoreInfo != null) {
    public NodeAllocationResult(StreamInput in) throws IOException {
     */
        return nodeDecision;
         */
        public ShardStoreInfo(long matchingBytes) {
            out.writeException(storeException);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        this.weightRanking = weightRanking;
import org.opensearch.core.xcontent.ToXContentObject;
    public ShardStoreInfo getShardStoreInfo() {
            out.writeLong(matchingBytes);
 * ownership. Elasticsearch licenses this file to you under
     * Get the shard store information for the node, if it exists.
         * is for a replica shard allocation.
import static org.opensearch.cluster.routing.allocation.AbstractAllocationDecision.discoveryNodeToXContent;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.common.Nullable;
    }
                builder.field("weight_ranking", getWeightRanking());
 * not use this file except in compliance with the License.
        {
        }
import java.util.Comparator;
    /**
            }
        out.writeOptionalWriteable(canAllocateDecision);
            return matchingBytes;
    @Nullable
     * a unique weight ranking that is relative to the other nodes against which the
         * Gets the allocation id for the shard copy, if it exists.
        }
        public String getAllocationId() {
        builder.startObject();
                    builder.field("allocation_id", allocationId);
        }
         */
        private final String allocationId;
        return shardStoreInfo;
        out.writeVInt(weightRanking);
                        // there was no information we could obtain of any shard data on the node
/*
            this.matchingBytes = in.readLong();
        public long getMatchingBytes() {
        public boolean hasMatchingSyncId() {
    public AllocationDecision getNodeDecision() {
            }
 * software distributed under the License is distributed on an
                    if (allocationId == null && storeException == null) {
         */
 * specific language governing permissions and limitations
    }
        /**
        out.writeOptionalWriteable(shardStoreInfo);
     * decided upon: node1, node2, and node3.  If node2 had the best weight for holding the
        this.canAllocateDecision = canAllocate;
    public boolean isWeightRanked() {
                        builder.humanReadableField("matching_size_in_bytes", "matching_size", new ByteSizeValue(matchingBytes));
        }
    /**
 */
                }
                builder.endArray();
        public boolean isInSync() {
import org.opensearch.core.common.io.stream.StreamOutput;
    @Nullable
}
            return inSync;
            this.matchingBytes = matchingBytes;
            out.writeBoolean(inSync);
import org.opensearch.OpenSearchException;
 * KIND, either express or implied.  See the License for the
    }
                    // dealing with a primary shard
    @Nullable
        }
        return nodeResultComparator.compare(this, other);
        @Override
    public static final class ShardStoreInfo implements ToXContentFragment, Writeable {
            return storeException;
    @Nullable
                }
        }
                    }
            this.matchingBytes = -1;
     * Get the node that this decision is for.
     */
        this.weightRanking = weightRanking;
                        builder.field("found", false);
         * Returns {@code true} if the shard copy is in-sync and contains the latest data.
    private final AllocationDecision nodeDecision;
 */
        return builder;
        public Exception getStoreException() {
        /**
    @Override
    public int compareTo(NodeAllocationResult other) {
    private final ShardStoreInfo shardStoreInfo;
 * SPDX-License-Identifier: Apache-2.0
     * will return {@link AllocationDecision#NO}.
            return matchingBytes == Long.MAX_VALUE;
                    builder.startObject("store_exception");
                    } else {
    public void writeTo(StreamOutput out) throws IOException {
            this.allocationId = allocationId;
public class NodeAllocationResult implements ToXContentObject, Writeable, Comparable<NodeAllocationResult> {
    }
        @Nullable
     * Is the weight assigned for the node?
    /**
         */
 * Licensed to Elasticsearch under one or more contributor
        this.nodeDecision = nodeDecision;
                }
            return allocationId;
        this.nodeDecision = decision != null ? AllocationDecision.fromDecisionType(canAllocateDecision.type()) : AllocationDecision.NO;
        private final boolean inSync;
        /**
    public NodeAllocationResult(DiscoveryNode node, AllocationDecision nodeDecision, Decision canAllocate, int weightRanking) {
     */
import org.opensearch.common.annotation.PublicApi;
            discoveryNodeToXContent(node, false, builder);
        return canAllocateDecision;
         * Returns {@code Long.MAX_VALUE} if {@link #hasMatchingSyncId()} returns {@code true}.
                        builder.field("matching_sync_id", true);
    /**
            builder.endObject();
            this.storeException = storeException;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * GitHub history for details.
    /**
            this.inSync = inSync;
            if (isWeightRanked()) {
         * there was no error, returns {@code null}.
            this.allocationId = null;
 * this file be licensed under the Apache-2.0 license or a
            return builder;
        node = new DiscoveryNode(in);
        this.node = node;
     * not calculated or factored into the decision.
                    } else {
        public ShardStoreInfo(StreamInput in) throws IOException {
         * Returns {@code true} if the shard copy has a matching sync id with the primary shard.
        this.node = node;
     * deciders ran.  For example, suppose there are 3 nodes which the allocation deciders
         * Gets the number of matching bytes the shard copy has with the primary shard.
 * You may obtain a copy of the License at
        canAllocateDecision = in.readOptionalWriteable(Decision::readFrom);
 * compatible open source license.
        }
 */
        this.canAllocateDecision = decision;
    public NodeAllocationResult(DiscoveryNode node, Decision decision, int weightRanking) {
    }
    }
 */
/*
        this.weightRanking = 0;
     * Gets the {@link AllocationDecision} for allocating to this node.
    }
import org.opensearch.core.xcontent.XContentBuilder;
        private final Exception storeException;
    }
    }
 * under the License.
                if (matchingBytes >= 0) {
        @Nullable
package org.opensearch.cluster.routing.allocation;
        this.shardStoreInfo = null;
     */
import java.io.IOException;
            this.storeException = in.readException();
                    }
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
     * A class that captures metadata about a shard store on a node.
import org.opensearch.core.common.io.stream.StreamInput;
    /**
                    if (hasMatchingSyncId()) {
 *
     */
     */
        this.shardStoreInfo = shardStoreInfo;
        builder.endObject();
        private final long matchingBytes;
        /**
 * This class represents the shard allocation decision and its explanation for a single node.
import org.opensearch.cluster.node.DiscoveryNode;
            }
        }
        weightRanking = in.readVInt();
                    OpenSearchException.generateThrowableXContent(builder, params, storeException);
import org.opensearch.cluster.routing.allocation.decider.Decision;
    @Override
        }
                        builder.field("in_sync", inSync);
     */
         */
        .thenComparingInt(NodeAllocationResult::getWeightRanking)
    }
         * Gets the store exception when trying to read the store, if there was an error.  If
                builder.startArray("deciders");
import org.opensearch.core.common.io.stream.Writeable;
    }
        node.writeToWithAttribute(out);
 * Unless required by applicable law or agreed to in writing,
        this.node = node;
            this.allocationId = in.readOptionalString();
@PublicApi(since = "1.0.0")
            this.storeException = null;
    public Decision getCanAllocateDecision() {
        }
        nodeDecision.writeTo(out);
        @Nullable
 * @opensearch.api
            {
        shardStoreInfo = in.readOptionalWriteable(ShardStoreInfo::new);
 *
        .thenComparing(r -> r.getNode().getId());
        this.shardStoreInfo = null;
 *
    private static final Comparator<NodeAllocationResult> nodeResultComparator = Comparator.comparing(NodeAllocationResult::getNodeDecision)
        return weightRanking > 0;
    @Override
                canAllocateDecision.toXContent(builder, params);
        @Nullable
            out.writeOptionalString(allocationId);
                shardStoreInfo.toXContent(builder, params);
        this.nodeDecision = AllocationDecision.fromDecisionType(decision.type());
            this.inSync = in.readBoolean();
         * matching sync ids are irrelevant.
        return node;
    @PublicApi(since = "1.0.0")
        nodeDecision = AllocationDecision.readFrom(in);
/*
    /**
            }
        public void writeTo(StreamOutput out) throws IOException {
