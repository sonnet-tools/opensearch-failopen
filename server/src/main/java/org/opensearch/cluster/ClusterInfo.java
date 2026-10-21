@PublicApi(since = "1.0.0")
                    builder.endObject(); // end "least_available"
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        } else {
            }
    }
    ) {
     */
     * @param leastAvailableSpaceUsage a node id to disk usage mapping for the path that has the least available space on the node.
                shardIds.add(shardId);
        }
 * specific language governing permissions and limitations
                return this;
            out.writeVLong(total);
                builder.field(c.getKey().toString(), c.getValue());
    ) {
 * compatible open source license.
            return shardIds.contains(shardId);
 * ownership. Elasticsearch licenses this file to you under
     * Returns a node id to disk usage mapping for the path that has the least available space on the node.
                        c.getValue().toShortXContent(builder);
        this(leastAvailableSpaceUsage, mostAvailableSpaceUsage, shardSizes, routingToDataPath, reservedSpace, nodeFileCacheStats, Map.of());
    }
     * Returns the nodes absolute data-path the given shard is allocated on or <code>null</code> if the information is not available.
        long freeBytes = 0;
            out.writeString(nodeId);
     * @param reservedSpace reserved space per shard broken down by node and data path
        ReservedSpace(StreamInput in) throws IOException {
     * @param routingToDataPath the shard routing to datapath mapping
                        }
     * Returns the shard size for the given shard routing or <code>null</code> it that metric is not available.
            this.shardIds = Collections.unmodifiableSet(shardIds);
     * Represents a data path on a node
    /**
        if (usages == null || usages.isEmpty()) {
    /**
                    NodeResourceUsageStats resourceUsageStats = nodeResourceUsageStats.get(c.getKey());
        }
 * ClusterInfo is an object representing a map of nodes to {@link DiskUsage} and {@link NodeResourceUsageStats}
 * The OpenSearch Contributors require contributions made to
    /**
                builder.startObject(c.getKey());
        this.routingToDataPath = routingToDataPath;
        Map<String, Long> sizeMap = in.readMap(StreamInput::readString, StreamInput::readLong);
        @Override
     *
    /**
        return result == null ? ReservedSpace.EMPTY : result;
    @Override
                assert shardIds != null : "already built";
        public boolean equals(Object o) {
     */
        }
            return nodeId.equals(that.nodeId) && path.equals(that.path);
            this.shardIds = Collections.unmodifiableSet(shardIds);
            for (Map.Entry<String, Long> c : this.shardSizes.entrySet()) {
/*
        builder.endObject(); // end "nodes"
        out.writeMap(this.mostAvailableSpaceUsage, StreamOutput::writeString, (o, v) -> v.writeTo(o));
     */
            out.writeVInt(shardIds.size());
        return Collections.unmodifiableMap(this.leastAvailableSpaceUsage);
        this.shardSizes = shardSizes;
 * GitHub history for details.
        this.leastAvailableSpaceUsage = Collections.unmodifiableMap(leastMap);
    private long avgTotalBytes;
    }
     * @param leastAvailableSpaceUsage a node id to disk usage mapping for the path that has the least available space on the node.
            for (Map.Entry<String, DiskUsage> c : this.leastAvailableSpaceUsage.entrySet()) {
    public Map<String, DiskUsage> getNodeMostAvailableDiskUsages() {
            return Objects.hash(total, shardIds);
     * @opensearch.internal
import org.opensearch.cluster.routing.ShardRouting;
    }
     */
                for (final ShardId shardIdCursor : shardIds) {
         *
        }
        this.shardSizes = Collections.unmodifiableMap(sizeMap);
 */
                    builder.endObject(); // end "most_available"
        return shardSizes.get(shardIdentifierFromRouting(shardRouting));
    public long getAvgTotalBytes() {
            totalBytes += du.getTotalBytes();
import org.opensearch.common.annotation.PublicApi;
        this.reservedSpace = reservedSpace;
    public void writeTo(StreamOutput out) throws IOException {
                }
     * Note that this does not take account of reserved space: there may be another path with less available _and unreserved_ space.
import org.opensearch.core.common.io.stream.Writeable;
     * Method that incorporates the ShardId for the shard into a string that
            }
        builder.startObject("nodes");
    private final Map<String, DiskUsage> leastAvailableSpaceUsage;
            }
        {
            this.nodeId = Objects.requireNonNull(nodeId);
        return shardRouting.shardId().toString() + "[" + (shardRouting.primary() ? "p" : "r") + "]";
        this.nodeResourceUsageStats = nodeResourceUsageStats;
    public long getAvgFreeByte() {
    /**
    final Map<String, AggregateFileCacheStats> nodeFileCacheStats;
import org.opensearch.core.index.shard.ShardId;
            this.nodeId = in.readString();
     * Returns a node id to disk usage mapping for the path that has the most available space on the node.
        } else {
                    c.getValue().toXContent(builder, params);
    @PublicApi(since = "1.0.0")
        void toXContent(XContentBuilder builder, Params params) throws IOException {
            this.nodeResourceUsageStats = in.readMap(StreamInput::readString, NodeResourceUsageStats::new);
        return avgTotalBytes;
     * @param reservedSpace reserved space per shard broken down by node and data path
    public static class ReservedSpace implements Writeable {
    public static final ClusterInfo EMPTY = new ClusterInfo();
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;
        this(Map.of(), Map.of(), Map.of(), Map.of(), Map.of(), Map.of(), Map.of());
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    public ReservedSpace getReservedSpace(String nodeId, String dataPath) {
            this.nodeFileCacheStats = in.readMap(StreamInput::readString, AggregateFileCacheStats::new);
            for (Map.Entry<ShardRouting, String> c : this.routingToDataPath.entrySet()) {
    final Map<ShardRouting, String> routingToDataPath;
        @Override
        private final long total;
            freeBytes += du.getFreeBytes();
    }
        if (out.getVersion().onOrAfter(Version.V_3_2_0)) {
        this.mostAvailableSpaceUsage = Collections.unmodifiableMap(mostMap);
    /**
     * @param nodeFileCacheStats node file cache stats
            }
            return Objects.hash(nodeId, path);
                builder.endObject(); // NodeAndPath
        }
    }
        out.writeMap(this.shardSizes, StreamOutput::writeString, (o, v) -> out.writeLong(v == null ? -1 : v));
        out.writeMap(this.reservedSpace, (o, v) -> v.writeTo(o), (o, v) -> v.writeTo(o));
            ReservedSpace that = (ReservedSpace) o;
    /**
        }
     * Returns the shard size for the given shard routing or <code>defaultValue</code> it that metric is not available.
        Map<ShardRouting, String> routingMap = in.readMap(ShardRouting::new, StreamInput::readString);
        }
     * Creates a new ClusterInfo instance.
    }
            public Builder add(ShardId shardId, long reservedBytes) {
    public Map<String, NodeResourceUsageStats> getNodeResourceUsageStats() {
 * and a map of shard ids to shard sizes, see
     *
        }
                    }
 * this file be licensed under the Apache-2.0 license or a
        calculateAvgFreeAndTotalBytes(mostAvailableSpaceUsage);
        return routingToDataPath.get(shardRouting);
            this.nodeResourceUsageStats = Map.of();
    public ClusterInfo(
            for (int i = 0; i < shardIdCount; i++) {
    }
 * not use this file except in compliance with the License.
        final Map<String, DiskUsage> mostAvailableSpaceUsage,
import org.opensearch.core.common.io.stream.StreamOutput;
                final ReservedSpace reservedSpace = new ReservedSpace(total, shardIds);
     * Returns a {@link DiskUsage} for the {@link RoutingNode} using the
            return;
        }
        }
        public void writeTo(StreamOutput out) throws IOException {
            out.writeString(path);
         */
        final Map<String, DiskUsage> mostAvailableSpaceUsage,
        public final String path;
     */
            }
        }
        this.reservedSpace = Collections.unmodifiableMap(reservedSpaceMap);
                    builder.field("node_id", c.getKey().nodeId);
     */
        builder.endArray(); // end "reserved_sizes"
 * Modifications Copyright OpenSearch Contributors. See
    }
            out.writeMap(this.nodeResourceUsageStats, StreamOutput::writeString, (o, v) -> v.writeTo(o));
            builder.endArray(); // end "shards"
 *
        {
public class ClusterInfo implements ToXContentFragment, Writeable {
     *
        }
 * the Apache License, Version 2.0 (the "License"); you may
            }
import java.util.Objects;
            this.nodeFileCacheStats = Map.of();
        return avgFreeByte;
                }
        final Map<String, DiskUsage> leastAvailableSpaceUsage,
        out.writeMap(this.leastAvailableSpaceUsage, StreamOutput::writeString, (o, v) -> v.writeTo(o));
    final Map<String, Long> shardSizes;  // pkg-private for testing only
 * software distributed under the License is distributed on an
    final Map<NodeAndPath, ReservedSpace> reservedSpace;
            private Set<ShardId> shardIds = new HashSet<>();
        this.avgTotalBytes = totalBytes / usages.size();
        }
        reservedSpaceMap = in.readMap(NodeAndPath::new, ReservedSpace::new);
            {
     * Returns a node id to file cache stats mapping for the nodes that have search roles assigned to it.
        long totalBytes = 0;
     */
        this.routingToDataPath = Collections.unmodifiableMap(routingMap);
                    builder.field("node_name", c.getValue().getNodeName());
        @Override
        if (out.getVersion().onOrAfter(Version.V_2_10_0)) {
        }
    /**
import org.opensearch.core.common.unit.ByteSizeValue;
     */
    @Deprecated(forRemoval = true)
            for (final ShardId shardIdCursor : shardIds) {
        public boolean containsShardId(ShardId shardId) {
    }
     *
        for (DiskUsage du : usages.values()) {
        Map<String, DiskUsage> mostMap = in.readMap(StreamInput::readString, DiskUsage::new);
        public void writeTo(StreamOutput out) throws IOException {
        Map<NodeAndPath, ReservedSpace> reservedSpaceMap;
                        if (most != null) {
import org.opensearch.core.xcontent.ToXContentFragment;
 * for the key used in the shardSizes map
        final ReservedSpace result = reservedSpace.get(new NodeAndPath(nodeId, dataPath));
                shardIdCursor.writeTo(out);
                shardIds = null;
        }
            this.path = Objects.requireNonNull(path);
            NodeAndPath that = (NodeAndPath) o;
     */
     * Returns the reserved space for each shard on the given node/path pair
            total = in.readVLong();
            if (o == null || getClass() != o.getClass()) return false;
        private ReservedSpace(long total, Set<ShardId> shardIds) {
    public ClusterInfo(StreamInput in) throws IOException {
    /**
        }
        public static class Builder {
                builder.endObject(); // end $nodename
            builder.startArray("shards");
        public long getTotal() {
                assert reservedBytes >= 0 : reservedBytes;
    }
        }
        return Collections.unmodifiableMap(this.mostAvailableSpaceUsage);
 * Unless required by applicable law or agreed to in writing,
            return total == that.total && shardIds.equals(that.shardIds);
        {
    static String shardIdentifierFromRouting(ShardRouting shardRouting) {
            }
import java.util.HashSet;
 * @opensearch.api
        Map<String, DiskUsage> leastMap = in.readMap(StreamInput::readString, DiskUsage::new);
    public String getDataPath(ShardRouting shardRouting) {
        final Map<String, NodeResourceUsageStats> nodeResourceUsageStats
    }
     * @see #shardIdentifierFromRouting
    public static class NodeAndPath implements Writeable {
        }
    private long avgFreeByte;
    }
            return total;
 * KIND, either express or implied.  See the License for the
        }
    }
    private final Map<String, DiskUsage> mostAvailableSpaceUsage;
    /**
                    builder.startObject("least_available");
                    builder.field("path", c.getKey().path);
                builder.startObject();
     * includes a 'p' or 'r' depending on whether the shard is a primary.
        @Override
     * @param routingToDataPath the shard routing to datapath mapping
    /**
 *
            if (this == o) return true;
     * @opensearch.api
        public NodeAndPath(StreamInput in) throws IOException {
            this.total = total;
            final int shardIdCount = in.readVInt();
/*
        this.avgFreeByte = freeBytes / usages.size();
        }
                    }
    public Map<String, DiskUsage> getNodeLeastAvailableDiskUsages() {
        final Map<ShardRouting, String> routingToDataPath,
                    if (resourceUsageStats != null) {
}
        public NodeAndPath(String nodeId, String path) {
        builder.startObject("shard_paths");
        if (in.getVersion().onOrAfter(Version.V_2_10_0)) {
    private final Map<String, NodeResourceUsageStats> nodeResourceUsageStats;
        calculateAvgFreeAndTotalBytes(mostAvailableSpaceUsage);
            private long total;
    }
 * <code>InternalClusterInfoService.shardIdentifierFromRouting(String)</code>
    /**
            this.avgFreeByte = 0;
     * @see #shardIdentifierFromRouting
     * average usage of other nodes in the disk usage map.
        if (in.getVersion().onOrAfter(Version.V_3_2_0)) {
     */
        out.writeMap(this.routingToDataPath, (o, k) -> k.writeTo(o), StreamOutput::writeString);
        }
                    builder.endObject();
import java.util.Set;
        @Override
                {
        }
    public ClusterInfo(
            }
                total += reservedBytes;
                    builder.startObject("node_resource_usage_stats");
        /**
     * @param mostAvailableSpaceUsage  a node id to disk usage mapping for the path that has the most available space on the node.
            out.writeMap(this.nodeFileCacheStats, StreamOutput::writeString, (o, v) -> v.writeTo(o));
    public Map<String, AggregateFileCacheStats> getNodeFileCacheStats() {
        this.mostAvailableSpaceUsage = mostAvailableSpaceUsage;
 * this work for additional information regarding copyright
                    builder.startObject("most_available");
import org.opensearch.Version;
    }
     * Creates a new ClusterInfo instance.
package org.opensearch.cluster;
        }
        private final Set<ShardId> shardIds;
            public ReservedSpace build() {
        return shardSize == null ? defaultValue : shardSize;
        final Map<NodeAndPath, ReservedSpace> reservedSpace,
 *
 */
import org.opensearch.cluster.routing.RoutingNode;
            builder.field("total", total);
     */
     */
    /**
                            most.toShortXContent(builder);
 * under the License.
            }
                return reservedSpace;
     * Note that this does not take account of reserved space: there may be another path with more available _and unreserved_ space.
import org.opensearch.core.common.io.stream.StreamInput;
        builder.startObject("shard_sizes");
        public static final ReservedSpace EMPTY = new ReservedSpace(0, new HashSet<>());
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.io.IOException;
                    shardIdCursor.toXContent(builder, params);
 * SPDX-License-Identifier: Apache-2.0
    }
    }
            this.path = in.readString();
        public int hashCode() {
    protected ClusterInfo() {
        public boolean equals(Object o) {
        Long shardSize = getShardSize(shardRouting);
                        resourceUsageStats.toXContent(builder, params);
    public Long getShardSize(ShardRouting shardRouting) {
                builder.humanReadableField(c.getKey() + "_bytes", c.getKey(), new ByteSizeValue(c.getValue()));
 * license agreements. See the NOTICE file distributed with
    }
     * @param shardSizes a shardkey to size in bytes mapping per shard.
 *
        final Map<NodeAndPath, ReservedSpace> reservedSpace,
import java.util.Map;
     */
     */
            for (Map.Entry<NodeAndPath, ReservedSpace> c : this.reservedSpace.entrySet()) {
                    }
     * @param mostAvailableSpaceUsage  a node id to disk usage mapping for the path that has the most available space on the node.
    /**
                    {
        }
     * Represents the total amount of "reserved" space on a particular data path, together with the set of shards considered.
        return builder;
import org.opensearch.node.NodeResourceUsageStats;
        return Collections.unmodifiableMap(this.nodeFileCacheStats);
     * Returns a node id to resource usage stats mapping.
        @Override
        final Map<String, DiskUsage> leastAvailableSpaceUsage,
    private void calculateAvgFreeAndTotalBytes(final Map<String, DiskUsage> usages) {
                    {
 * Licensed to Elasticsearch under one or more contributor
     * @param usages Map of nodeId to DiskUsage for all known nodes
        {
        builder.endObject(); // end "shard_sizes"
                assert shardIds != null : "already built";
import java.util.Collections;
    public long getShardSize(ShardRouting shardRouting, long defaultValue) {
        public int hashCode() {
         * @opensearch.internal
     * @param shardSizes a shardkey to size in bytes mapping per shard.
        final Map<String, AggregateFileCacheStats> nodeFileCacheStats,
            Set<ShardId> shardIds = new HashSet<>(shardIdCount);
 */
        final Map<String, AggregateFileCacheStats> nodeFileCacheStats
        builder.startArray("reserved_sizes");
                }
            if (this == o) return true;
        final Map<String, Long> shardSizes,
    }
                shardIds.add(new ShardId(in));
            if (o == null || getClass() != o.getClass()) return false;
        this.leastAvailableSpaceUsage = leastAvailableSpaceUsage;
 * You may obtain a copy of the License at
/**
        this.nodeFileCacheStats = nodeFileCacheStats;
        public final String nodeId;
 */
import org.opensearch.core.xcontent.XContentBuilder;
            this.avgTotalBytes = 0;
        final Map<String, Long> shardSizes,
        final Map<ShardRouting, String> routingToDataPath,
/*
         * Builder for Reserved Space.
                { // node
        return Collections.unmodifiableMap(this.nodeResourceUsageStats);
                        DiskUsage most = this.mostAvailableSpaceUsage.get(c.getKey());
        builder.endObject(); // end "shard_paths"
