    private final DiscoveryNode node;
    }
 * this file be licensed under the Apache-2.0 license or a
         */  
        return weightRanking > 0;
    }
     * The weight ranking for allocating a shard to the node.  Each node will have
        return canAllocateDecision;  
        this.weightRanking = weightRanking;
            if (canAllocateDecision != null && canAllocateDecision.getDecisions().isEmpty() == false) {  
            if (shardStoreInfo != null) {  
        this.weightRanking = 0;
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
     */
            }
         */
        public String getAllocationId() {  
         * there was no error, returns {@code null}.
            out.writeOptionalString(allocationId);
        this.nodeDecision = AllocationDecision.fromDecisionType(decision.type());
 * This class represents the shard allocation decision and its explanation for a single node.
 * ownership. Elasticsearch licenses this file to you under  
    public DiscoveryNode getNode() {
    }
 * You may obtain a copy of the License at  
    /**
    public boolean isWeightRanked() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
        weightRanking = in.readVInt();
        @Override
    /**
        @Nullable
     */
     * @opensearch.api  
                    if (hasMatchingSyncId()) {  
     * A class that captures metadata about a shard store on a node.
import org.opensearch.core.common.io.stream.StreamInput;  
     */  
    }
import org.opensearch.core.xcontent.ToXContentObject;
/**
    }  
 * this work for additional information regarding copyright
            return inSync;
        @Nullable  
         */  
        node = new DiscoveryNode(in);
        .thenComparing(r -> r.getNode().getId());
                    if (allocationId == null && storeException == null) {
        node.writeToWithAttribute(out);
        /**
     * Get the node that this decision is for.  
import org.opensearch.core.xcontent.XContentBuilder;  
    @Nullable  
         * Returns {@code false} if the shard copy does not have a matching sync id with the primary  
     * shard, followed by node3, followed by node1, then node2's weight will be 1, node3's  
            return allocationId;
            builder.startObject("store");  
        public ShardStoreInfo(StreamInput in) throws IOException {
        private final long matchingBytes;
     * The decision details for allocating to this node.  Returns {@code null} if  
import org.opensearch.common.annotation.PublicApi;
        public void writeTo(StreamOutput out) throws IOException {  
        out.writeOptionalWriteable(canAllocateDecision);  
                shardStoreInfo.toXContent(builder, params);
     * not calculated or factored into the decision.
         * Returns {@code true} if the shard copy is in-sync and contains the latest data.  
        public boolean hasMatchingSyncId() {
import static org.opensearch.cluster.routing.allocation.AbstractAllocationDecision.discoveryNodeToXContent;
            this.storeException = in.readException();
            out.writeLong(matchingBytes);  
    private final AllocationDecision nodeDecision;
                canAllocateDecision.toXContent(builder, params);
                }
    }  
        this.nodeDecision = decision != null ? AllocationDecision.fromDecisionType(canAllocateDecision.type()) : AllocationDecision.NO;
    public NodeAllocationResult(DiscoveryNode node, ShardStoreInfo shardStoreInfo, @Nullable Decision decision) {  
        this.shardStoreInfo = null;
    private static final Comparator<NodeAllocationResult> nodeResultComparator = Comparator.comparing(NodeAllocationResult::getNodeDecision)  
                }
                    OpenSearchException.generateThrowableXContent(builder, params, storeException);
         * shard, or this explanation pertains to the allocation of a primary shard, in which case
         * Returns {@code false} if the shard copy is stale or if the shard copy being examined
            this.allocationId = in.readOptionalString();  
        builder.startObject();
        this.canAllocateDecision = canAllocate;
        {  
 */
    }  
import org.opensearch.cluster.routing.allocation.decider.Decision;  
    private final ShardStoreInfo shardStoreInfo;  
        /**
            return matchingBytes;
        }
            builder.endObject();  
    @Nullable
     */
        shardStoreInfo = in.readOptionalWriteable(ShardStoreInfo::new);
        }
        this.shardStoreInfo = null;  
    public NodeAllocationResult(DiscoveryNode node, AllocationDecision nodeDecision, Decision canAllocate, int weightRanking) {
                        // there was no information we could obtain of any shard data on the node
    public NodeAllocationResult(StreamInput in) throws IOException {  
 */  
    /**
        nodeDecision.writeTo(out);
import org.opensearch.common.Nullable;
    }
 *  
 * Licensed to Elasticsearch under one or more contributor  
         * is for a replica shard allocation.
            this.inSync = in.readBoolean();
 */  
         * Gets the number of matching bytes the shard copy has with the primary shard.  
            out.writeBoolean(inSync);
                    }
 *
 * @opensearch.api
 * compatible open source license.
    public AllocationDecision getNodeDecision() {
                        builder.humanReadableField("matching_size_in_bytes", "matching_size", new ByteSizeValue(matchingBytes));  
    }  
        /**
import org.opensearch.core.common.io.stream.Writeable;
                    } else {
        /**
    @Nullable
        builder.endObject();  
 */
        @Override
    @Override
 *  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            this.matchingBytes = -1;
        this.shardStoreInfo = shardStoreInfo;
         * Returns {@code true} if the shard copy has a matching sync id with the primary shard.
    }
package org.opensearch.cluster.routing.allocation;
         * matching sync ids are irrelevant.
        return builder;
public class NodeAllocationResult implements ToXContentObject, Writeable, Comparable<NodeAllocationResult> {
    public ShardStoreInfo getShardStoreInfo() {
                    builder.endObject();  
import java.util.Comparator;  
import org.opensearch.core.common.unit.ByteSizeValue;  
    }
        private final String allocationId;  
                    builder.startObject("store_exception");
        this.weightRanking = weightRanking;  
         * Gets the store exception when trying to read the store, if there was an error.  If  
                }
 *
        }
    public int compareTo(NodeAllocationResult other) {
                if (storeException != null) {  
/*  
    private final int weightRanking;
     * a unique weight ranking that is relative to the other nodes against which the  
/*
    @Override
                if (matchingBytes < 0) {
import org.opensearch.OpenSearchException;
}
        return nodeDecision;  
        .thenComparingInt(NodeAllocationResult::getWeightRanking)
        }
         * Gets the allocation id for the shard copy, if it exists.  
    public Decision getCanAllocateDecision() {
                        builder.field("matching_sync_id", true);
        nodeDecision = AllocationDecision.readFrom(in);
                    }  
            return builder;
        }  
                        builder.field("in_sync", inSync);
    }  
        @Nullable
        }  
    @Nullable
         */
        public ShardStoreInfo(long matchingBytes) {  
                builder.startArray("deciders");
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     * Gets the {@link AllocationDecision} for allocating to this node.  
     * Get the shard store information for the node, if it exists.
            return storeException;
        private final Exception storeException;  
         */  
        public Exception getStoreException() {
    /**  
 *     http://www.apache.org/licenses/LICENSE-2.0
        this.node = node;
        @Nullable
            this.allocationId = allocationId;
    private final Decision canAllocateDecision;  
            this.matchingBytes = matchingBytes;  
     */
        return weightRanking;
            return matchingBytes == Long.MAX_VALUE;
        public long getMatchingBytes() {
            if (isWeightRanked()) {  
        return shardStoreInfo;
            discoveryNodeToXContent(node, false, builder);
 * The OpenSearch Contributors require contributions made to  
        out.writeOptionalWriteable(shardStoreInfo);
        canAllocateDecision = in.readOptionalWriteable(Decision::readFrom);  
 * Modifications Copyright OpenSearch Contributors. See
                builder.field("weight_ranking", getWeightRanking());
 * GitHub history for details.
     * no allocation decision was taken on the node; in this case, {@link #getNodeDecision()}
        return nodeResultComparator.compare(this, other);  
     * will return {@link AllocationDecision#NO}.
 * under the License.  
        return node;  
        out.writeVInt(weightRanking);
import org.opensearch.cluster.node.DiscoveryNode;
            this.allocationId = null;
            }
        this.nodeDecision = nodeDecision;  
 * Unless required by applicable law or agreed to in writing,
     * deciders ran.  For example, suppose there are 3 nodes which the allocation deciders
 * software distributed under the License is distributed on an
                    builder.field("allocation_id", allocationId);  
import java.io.IOException;
                }
     * weight will be 2, and node1's weight will be 1.  A value of 0 means the weight was
        this.node = node;  
@PublicApi(since = "1.0.0")  
        }  
                        builder.field("found", false);  
    public NodeAllocationResult(DiscoveryNode node, Decision decision, int weightRanking) {
     *
                    } else {
                if (allocationId != null) {
         * Returns {@code Long.MAX_VALUE} if {@link #hasMatchingSyncId()} returns {@code true}.
         * Returns -1 if not applicable (this value only applies to assigning replica shards).
    @Override  
            }
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
     */
     */  
        public boolean isInSync() {
    }
            }
 * KIND, either express or implied.  See the License for the
        }  
            this.storeException = storeException;  
        }  
 * license agreements. See the NOTICE file distributed with
        this.canAllocateDecision = decision;  
    public static final class ShardStoreInfo implements ToXContentFragment, Writeable {  
        private final boolean inSync;
    public int getWeightRanking() {
/*  
        this.node = node;
        this.canAllocateDecision = decision;
                if (matchingBytes >= 0) {
                builder.endArray();  
     * decided upon: node1, node2, and node3.  If node2 had the best weight for holding the
    /**  
import org.opensearch.core.common.io.stream.StreamOutput;
            builder.field("node_decision", nodeDecision);
            this.inSync = false;
        public ShardStoreInfo(String allocationId, boolean inSync, Exception storeException) {
            this.matchingBytes = in.readLong();
    /**
    /**  
                    // dealing with a primary shard  
    @PublicApi(since = "1.0.0")
    public void writeTo(StreamOutput out) throws IOException {  
    }  
        }
     * Is the weight assigned for the node?
        /**
            this.inSync = inSync;  
            this.storeException = null;
import org.opensearch.core.xcontent.ToXContentFragment;
            out.writeException(storeException);
            {
