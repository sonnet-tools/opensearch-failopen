        final Map<ShardRouting, String> routingToDataPath,  
            this.nodeId = Objects.requireNonNull(nodeId);  
    final Map<NodeAndPath, ReservedSpace> reservedSpace;
        this.reservedSpace = Collections.unmodifiableMap(reservedSpaceMap);  
            out.writeVInt(shardIds.size());  
 */  
            }
    /**
        @Override  
        builder.startArray("reserved_sizes");
     */
    final Map<String, Long> shardSizes;  // pkg-private for testing only
        @Override
        }
     * includes a 'p' or 'r' depending on whether the shard is a primary.
            if (this == o) return true;
import java.io.IOException;  
        return avgFreeByte;
     * @param leastAvailableSpaceUsage a node id to disk usage mapping for the path that has the least available space on the node.
        return builder;  
    public long getShardSize(ShardRouting shardRouting, long defaultValue) {
 * ClusterInfo is an object representing a map of nodes to {@link DiskUsage} and {@link NodeResourceUsageStats}
                        if (most != null) {
    /**  
import org.opensearch.cluster.routing.RoutingNode;
 */
            out.writeString(path);
        if (out.getVersion().onOrAfter(Version.V_2_10_0)) {  
    }  
     */  
     * average usage of other nodes in the disk usage map.  
    }
        return result == null ? ReservedSpace.EMPTY : result;  
 * Unless required by applicable law or agreed to in writing,
    }
            this.nodeId = in.readString();
            for (int i = 0; i < shardIdCount; i++) {  
    }  
        }  
/*  
                builder.humanReadableField(c.getKey() + "_bytes", c.getKey(), new ByteSizeValue(c.getValue()));  
 *     http://www.apache.org/licenses/LICENSE-2.0
     * @param mostAvailableSpaceUsage  a node id to disk usage mapping for the path that has the most available space on the node.
    }  
            if (o == null || getClass() != o.getClass()) return false;
        return shardSize == null ? defaultValue : shardSize;
     * Returns the nodes absolute data-path the given shard is allocated on or <code>null</code> if the information is not available.
                    NodeResourceUsageStats resourceUsageStats = nodeResourceUsageStats.get(c.getKey());
        this.routingToDataPath = Collections.unmodifiableMap(routingMap);
    }
 * @opensearch.api
        public NodeAndPath(StreamInput in) throws IOException {
            this.total = total;
        return shardSizes.get(shardIdentifierFromRouting(shardRouting));
            }
     */  
        {  
    /**
        return Collections.unmodifiableMap(this.nodeResourceUsageStats);  
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */  
        }
    public static class ReservedSpace implements Writeable {
                    builder.field("node_id", c.getKey().nodeId);
            return Objects.hash(nodeId, path);
        long freeBytes = 0;
     * @param leastAvailableSpaceUsage a node id to disk usage mapping for the path that has the least available space on the node.
                    builder.startObject("most_available");
        if (usages == null || usages.isEmpty()) {
        Long shardSize = getShardSize(shardRouting);  
        for (DiskUsage du : usages.values()) {  
            for (Map.Entry<String, DiskUsage> c : this.leastAvailableSpaceUsage.entrySet()) {
     * @opensearch.internal
     * @param reservedSpace reserved space per shard broken down by node and data path  
        }  
        }
    public Long getShardSize(ShardRouting shardRouting) {  
         * Builder for Reserved Space.  
        }
                builder.endObject(); // NodeAndPath
import org.opensearch.Version;
    }
    final Map<String, AggregateFileCacheStats> nodeFileCacheStats;
     * Returns the reserved space for each shard on the given node/path pair
    /**
                    {  
        builder.endObject(); // end "shard_paths"
        return avgTotalBytes;
                builder.field(c.getKey().toString(), c.getValue());
    public ClusterInfo(
        public int hashCode() {
     * Returns a node id to resource usage stats mapping.  
     */  
            private long total;
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;  
            public Builder add(ShardId shardId, long reservedBytes) {  
        {
    }
     * Returns a node id to file cache stats mapping for the nodes that have search roles assigned to it.
 * Modifications Copyright OpenSearch Contributors. See
            if (o == null || getClass() != o.getClass()) return false;  
        private final Set<ShardId> shardIds;
            freeBytes += du.getFreeBytes();
@PublicApi(since = "1.0.0")  
        builder.startObject("nodes");  
        reservedSpaceMap = in.readMap(NodeAndPath::new, ReservedSpace::new);  
     */
        }  
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
     * @see #shardIdentifierFromRouting
            private Set<ShardId> shardIds = new HashSet<>();  
    /**  
        calculateAvgFreeAndTotalBytes(mostAvailableSpaceUsage);  
import java.util.HashSet;
        } else {  
        public final String nodeId;
            }  
    public ClusterInfo(StreamInput in) throws IOException {  
    public Map<String, DiskUsage> getNodeLeastAvailableDiskUsages() {
    @PublicApi(since = "1.0.0")
        }
     *
     */
        this.avgFreeByte = freeBytes / usages.size();  
        this(leastAvailableSpaceUsage, mostAvailableSpaceUsage, shardSizes, routingToDataPath, reservedSpace, nodeFileCacheStats, Map.of());
     */
        }
     *
                shardIds = null;
            builder.field("total", total);
import org.opensearch.common.annotation.PublicApi;
                        resourceUsageStats.toXContent(builder, params);
                final ReservedSpace reservedSpace = new ReservedSpace(total, shardIds);
        }
    /**
                        }
    public long getAvgTotalBytes() {
    public long getAvgFreeByte() {  
            }  
        out.writeMap(this.shardSizes, StreamOutput::writeString, (o, v) -> out.writeLong(v == null ? -1 : v));  
        final Map<NodeAndPath, ReservedSpace> reservedSpace,
     * @param shardSizes a shardkey to size in bytes mapping per shard.  
        this.shardSizes = shardSizes;  
        this.nodeFileCacheStats = nodeFileCacheStats;
        public void writeTo(StreamOutput out) throws IOException {
            Set<ShardId> shardIds = new HashSet<>(shardIdCount);
        @Override  
    }
                assert shardIds != null : "already built";  
        public static final ReservedSpace EMPTY = new ReservedSpace(0, new HashSet<>());
            totalBytes += du.getTotalBytes();
        if (in.getVersion().onOrAfter(Version.V_3_2_0)) {
        final Map<String, AggregateFileCacheStats> nodeFileCacheStats,
            return Objects.hash(total, shardIds);  
        out.writeMap(this.routingToDataPath, (o, k) -> k.writeTo(o), StreamOutput::writeString);
            this.path = in.readString();  
        calculateAvgFreeAndTotalBytes(mostAvailableSpaceUsage);
            for (Map.Entry<NodeAndPath, ReservedSpace> c : this.reservedSpace.entrySet()) {
        return shardRouting.shardId().toString() + "[" + (shardRouting.primary() ? "p" : "r") + "]";
            NodeAndPath that = (NodeAndPath) o;
        public boolean equals(Object o) {
                assert reservedBytes >= 0 : reservedBytes;
    /**
        }
     */  
            out.writeVLong(total);
            out.writeString(nodeId);  
                }
     * Returns a node id to disk usage mapping for the path that has the least available space on the node.
        builder.startObject("shard_paths");
        @Override
        }  
        final Map<String, Long> shardSizes,
 * SPDX-License-Identifier: Apache-2.0
        this.routingToDataPath = routingToDataPath;
 * The OpenSearch Contributors require contributions made to  
 */
     * @param usages Map of nodeId to DiskUsage for all known nodes
                builder.endObject(); // end $nodename
                        DiskUsage most = this.mostAvailableSpaceUsage.get(c.getKey());
                shardIds.add(new ShardId(in));
    }
        ReservedSpace(StreamInput in) throws IOException {
        final Map<String, DiskUsage> mostAvailableSpaceUsage,
     * Note that this does not take account of reserved space: there may be another path with more available _and unreserved_ space.
        public boolean containsShardId(ShardId shardId) {
    /**
        public final String path;  
    public ClusterInfo(
import java.util.Set;
     * Returns the shard size for the given shard routing or <code>null</code> it that metric is not available.
     * @param routingToDataPath the shard routing to datapath mapping
        final Map<String, NodeResourceUsageStats> nodeResourceUsageStats  
     * @param shardSizes a shardkey to size in bytes mapping per shard.
 * this file be licensed under the Apache-2.0 license or a
        public long getTotal() {  
            this.shardIds = Collections.unmodifiableSet(shardIds);
     * Method that incorporates the ShardId for the shard into a string that
     * @param routingToDataPath the shard routing to datapath mapping
     * Creates a new ClusterInfo instance.
 * specific language governing permissions and limitations
import org.opensearch.cluster.routing.ShardRouting;  
                assert shardIds != null : "already built";
     */
    ) {
     */
        public void writeTo(StreamOutput out) throws IOException {
                    }
        @Override
        /**
     */  
    public Map<String, DiskUsage> getNodeMostAvailableDiskUsages() {  
        }
            for (final ShardId shardIdCursor : shardIds) {
            return total;
 * under the License.  
     */  
            this.shardIds = Collections.unmodifiableSet(shardIds);  
        {
    public Map<String, NodeResourceUsageStats> getNodeResourceUsageStats() {
 * ownership. Elasticsearch licenses this file to you under  
            for (Map.Entry<String, Long> c : this.shardSizes.entrySet()) {
    /**
            }
        builder.endObject(); // end "nodes"
                            most.toShortXContent(builder);  
        if (out.getVersion().onOrAfter(Version.V_3_2_0)) {  
import org.opensearch.core.index.shard.ShardId;  
        private ReservedSpace(long total, Set<ShardId> shardIds) {  
            this.nodeFileCacheStats = in.readMap(StreamInput::readString, AggregateFileCacheStats::new);
        Map<NodeAndPath, ReservedSpace> reservedSpaceMap;
                    }  
        }
            final int shardIdCount = in.readVInt();
 * <code>InternalClusterInfoService.shardIdentifierFromRouting(String)</code>
                builder.startObject(c.getKey());  
 * compatible open source license.
import org.opensearch.node.NodeResourceUsageStats;
     * Represents the total amount of "reserved" space on a particular data path, together with the set of shards considered.  
        this.nodeResourceUsageStats = nodeResourceUsageStats;
                total += reservedBytes;
    public Map<String, AggregateFileCacheStats> getNodeFileCacheStats() {
                    shardIdCursor.toXContent(builder, params);
            out.writeMap(this.nodeFileCacheStats, StreamOutput::writeString, (o, v) -> v.writeTo(o));
     * Represents a data path on a node  
 *  
     * Note that this does not take account of reserved space: there may be another path with less available _and unreserved_ space.
        }
        builder.endObject(); // end "shard_sizes"  
        this.leastAvailableSpaceUsage = Collections.unmodifiableMap(leastMap);
                        c.getValue().toShortXContent(builder);
        @Override
import org.opensearch.core.common.io.stream.StreamOutput;  
        Map<String, DiskUsage> mostMap = in.readMap(StreamInput::readString, DiskUsage::new);
package org.opensearch.cluster;
            ReservedSpace that = (ReservedSpace) o;  
 * license agreements. See the NOTICE file distributed with
        public boolean equals(Object o) {  
            return shardIds.contains(shardId);
        builder.startObject("shard_sizes");  
    final Map<ShardRouting, String> routingToDataPath;  
            return;
public class ClusterInfo implements ToXContentFragment, Writeable {
import org.opensearch.core.common.unit.ByteSizeValue;
                    }
    private final Map<String, DiskUsage> leastAvailableSpaceUsage;
 *
     * @opensearch.api
                {  
            builder.endArray(); // end "shards"
            builder.startArray("shards");
            return total == that.total && shardIds.equals(that.shardIds);
        this(Map.of(), Map.of(), Map.of(), Map.of(), Map.of(), Map.of(), Map.of());
    /**
     *  
            if (this == o) return true;
    @Override
        {
    }
        long totalBytes = 0;
            for (Map.Entry<ShardRouting, String> c : this.routingToDataPath.entrySet()) {  
    private long avgTotalBytes;
 *
        }
        final Map<NodeAndPath, ReservedSpace> reservedSpace,
    }
            public ReservedSpace build() {
                    builder.startObject("node_resource_usage_stats");
                    builder.endObject(); // end "least_available"
 * not use this file except in compliance with the License.
    }
        out.writeMap(this.reservedSpace, (o, v) -> v.writeTo(o), (o, v) -> v.writeTo(o));
        return routingToDataPath.get(shardRouting);
            this.avgFreeByte = 0;  
import java.util.Map;  
                    builder.endObject();  
 * You may obtain a copy of the License at  
                builder.startObject();
        if (in.getVersion().onOrAfter(Version.V_2_10_0)) {
import org.opensearch.core.common.io.stream.StreamInput;
        public int hashCode() {  
import java.util.Objects;
     * @see #shardIdentifierFromRouting  
    /**  
        final Map<String, DiskUsage> mostAvailableSpaceUsage,
    }  
        }
        }  
        builder.endArray(); // end "reserved_sizes"
        final Map<String, AggregateFileCacheStats> nodeFileCacheStats
        Map<String, Long> sizeMap = in.readMap(StreamInput::readString, StreamInput::readLong);  
            return nodeId.equals(that.nodeId) && path.equals(that.path);
                    builder.field("node_name", c.getValue().getNodeName());
    public String getDataPath(ShardRouting shardRouting) {
    }  
 * this work for additional information regarding copyright
    }  
    ) {  
     * Returns the shard size for the given shard routing or <code>defaultValue</code> it that metric is not available.  
        final Map<String, Long> shardSizes,
        Map<ShardRouting, String> routingMap = in.readMap(ShardRouting::new, StreamInput::readString);
        }
    }
 * GitHub history for details.
        this.mostAvailableSpaceUsage = mostAvailableSpaceUsage;
     * Creates a new ClusterInfo instance.  
    /**
                { // node
        out.writeMap(this.mostAvailableSpaceUsage, StreamOutput::writeString, (o, v) -> v.writeTo(o));
 *  
    /**
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    public void writeTo(StreamOutput out) throws IOException {  
        public static class Builder {
    private long avgFreeByte;
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.xcontent.ToXContentFragment;
    protected ClusterInfo() {
            }  
import org.opensearch.core.common.io.stream.Writeable;
            }  
        }  
            }
                    builder.endObject(); // end "most_available"  
     * @param reservedSpace reserved space per shard broken down by node and data path
            {  
         * @opensearch.internal
     * Returns a {@link DiskUsage} for the {@link RoutingNode} using the
                    {
 * and a map of shard ids to shard sizes, see  
        return Collections.unmodifiableMap(this.mostAvailableSpaceUsage);
            this.avgTotalBytes = 0;
                    builder.startObject("least_available");  
}
            this.path = Objects.requireNonNull(path);
                    builder.field("path", c.getKey().path);
        }
     * Returns a node id to disk usage mapping for the path that has the most available space on the node.  
                for (final ShardId shardIdCursor : shardIds) {
        } else {  
        this.mostAvailableSpaceUsage = Collections.unmodifiableMap(mostMap);  
        this.reservedSpace = reservedSpace;  
        this.avgTotalBytes = totalBytes / usages.size();
        final Map<String, DiskUsage> leastAvailableSpaceUsage,  
            this.nodeResourceUsageStats = Map.of();
        private final long total;  
        final Map<ShardRouting, String> routingToDataPath,  
        final Map<String, DiskUsage> leastAvailableSpaceUsage,  
                shardIds.add(shardId);  
        this.leastAvailableSpaceUsage = leastAvailableSpaceUsage;
         *
        Map<String, DiskUsage> leastMap = in.readMap(StreamInput::readString, DiskUsage::new);
        public NodeAndPath(String nodeId, String path) {
        final ReservedSpace result = reservedSpace.get(new NodeAndPath(nodeId, dataPath));
            this.nodeFileCacheStats = Map.of();
        return Collections.unmodifiableMap(this.leastAvailableSpaceUsage);
                    if (resourceUsageStats != null) {  
            this.nodeResourceUsageStats = in.readMap(StreamInput::readString, NodeResourceUsageStats::new);
import org.opensearch.core.xcontent.XContentBuilder;
/*
    @Deprecated(forRemoval = true)
 * the Apache License, Version 2.0 (the "License"); you may
        }
    }
        out.writeMap(this.leastAvailableSpaceUsage, StreamOutput::writeString, (o, v) -> v.writeTo(o));
     * @param nodeFileCacheStats node file cache stats
    private final Map<String, DiskUsage> mostAvailableSpaceUsage;  
/**
    }  
import java.util.Collections;
        }
/*  
        }
                }  
            }
                return reservedSpace;  
         */  
        void toXContent(XContentBuilder builder, Params params) throws IOException {  
        this.shardSizes = Collections.unmodifiableMap(sizeMap);
     *
    static String shardIdentifierFromRouting(ShardRouting shardRouting) {
                    c.getValue().toXContent(builder, params);  
                shardIdCursor.writeTo(out);
                return this;
    private void calculateAvgFreeAndTotalBytes(final Map<String, DiskUsage> usages) {  
 */  
    /**
     * @param mostAvailableSpaceUsage  a node id to disk usage mapping for the path that has the most available space on the node.  
    public ReservedSpace getReservedSpace(String nodeId, String dataPath) {
    public static final ClusterInfo EMPTY = new ClusterInfo();
    private final Map<String, NodeResourceUsageStats> nodeResourceUsageStats;  
     */  
 * for the key used in the shardSizes map
            out.writeMap(this.nodeResourceUsageStats, StreamOutput::writeString, (o, v) -> v.writeTo(o));
    public static class NodeAndPath implements Writeable {
            total = in.readVLong();  
                }
        return Collections.unmodifiableMap(this.nodeFileCacheStats);
