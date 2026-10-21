     * to be used for the internal accounting of {@code ResponseCollectorService}.
    }
    public ResponseCollectorService(ClusterService clusterService) {
import org.opensearch.core.common.io.stream.Writeable;
            // EWMA of queue size
            out.writeDouble(this.serviceTime);
            double muBarS = serviceTime / FACTOR;
            sb.append("nodes: ").append(clientNum);
            double rS = responseTime / FACTOR;
            this.nodeId = nodeId;
 * SPDX-License-Identifier: Apache-2.0
        final String nodeId;
 * tasks executed on each node, making the EWMA of the values available to the
    public static class ComputedNodeStats implements Writeable {
            // potentially make this configurable if desired.
 *
 * The OpenSearch Contributors require contributions made to
    }
     * {@code Optional} if the node was not found.
            .build();
    }
                ExponentiallyWeightedMovingAverage queueEWMA = new ExponentiallyWeightedMovingAverage(ALPHA, queueSize);
    private static class NodeStatistics {
 *
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
        // formula specifies milliseconds, therefore we need to convert
     * @opensearch.api
            // the concurrency compensation is defined as the number of
                ns.queueSize.addValue((double) queueSize);
            out.writeDouble(this.responseTime);
     */
     * time, and service time, however, this class is private and intended only
    }
    }
import java.util.Optional;
            sb.append(", response time: ").append(String.format(Locale.ROOT, "%.1f", responseTime));
                clientNum,
            sb.append(nodeId).append("](");
 * Modifications Copyright OpenSearch Contributors. See
        @Override
            out.writeInt(this.queueSize);
            return sb.toString();
 * coordinating node.
            // outstanding requests from the client to the node times the number
 * software distributed under the License is distributed on an
        ComputedNodeStats(StreamInput in) throws IOException {
            this.queueSize = queueSize;
            this.clientNum = clientNum;
    /**
 * specific language governing permissions and limitations
                nodeStats.nodeId,
    public Optional<ComputedNodeStats> getNodeStatistics(final String nodeId) {
    }
import java.util.Locale;
            this.responseTime = in.readDouble();
            this(
                (int) nodeStats.queueSize.getAverage(),
import org.opensearch.cluster.ClusterChangedEvent;
            sb.append(", service time: ").append(String.format(Locale.ROOT, "%.1f", serviceTime));
        public final int queueSize;
        }
            double concurrencyCompensation = outstandingRequests * clientNum;
        // the values so the times don't unduely weight the formula
                nodeStats.serviceTime
            this.clientNum = in.readInt();
import org.opensearch.core.common.io.stream.StreamOutput;
        public ComputedNodeStats(String nodeId, int clientNum, int queueSize, double responseTime, double serviceTime) {
            ExponentiallyWeightedMovingAverage queueSizeEWMA,
            this.serviceTime = serviceTime;
        return Optional.ofNullable(nodeIdToStats.get(nodeId)).map(ns -> new ComputedNodeStats(clientNum, ns));
     *
 * this work for additional information regarding copyright
        nodeIdToStats.forEach((k, v) -> { nodeStats.put(k, new ComputedNodeStats(clientNum, v)); });
        clusterService.addListener(this);
        }
        public final String nodeId;
            // EWMA of response time
            ExponentiallyWeightedMovingAverage responseTimeEWMA,
            int queueAdjustmentFactor = 3;
        // We store timestamps with nanosecond precision, however, the
package org.opensearch.node;
     * Optionally return a {@code NodeStatistics} for the given nodeid, if
        NodeStatistics(
        }
            }
            // EWMA of service time
            return cachedRank;
     * response information exists for the given node. Returns an empty
}
     */
            );
 * this file be licensed under the Apache-2.0 license or a
    public void clusterChanged(ClusterChangedEvent event) {
            this.serviceTime = in.readDouble();
 * Licensed to Elasticsearch under one or more contributor
        }
    public void addNodeStatistics(String nodeId, int queueSize, long responseTimeNanos, long avgServiceTimeNanos) {
    private final ConcurrentMap<String, NodeStatistics> nodeIdToStats = ConcurrentCollections.newConcurrentMap();
import java.util.concurrent.ConcurrentMap;
        /**
 */
        final ExponentiallyWeightedMovingAverage responseTime;
import org.opensearch.cluster.ClusterStateListener;
            }
        private final double FACTOR = 1000000.0;
        public void writeTo(StreamOutput out) throws IOException {
            if (ns == null) {
                ns.responseTime.addValue((double) responseTimeNanos);
            this.queueSize = queueSizeEWMA;
        final int clientNum = nodeIdToStats.size();
            sb.append(")");
        return new AdaptiveSelectionStats.Builder().clientOutgoingConnections(clientSearchConnections)
    /**
            this.responseTime = responseTime;
        final int clientNum = nodeIdToStats.size();
    }
            } else {
/*
 * license agreements. See the NOTICE file distributed with
        private final int clientNum;
import java.io.IOException;
/*
    void removeNode(String nodeId) {
            out.writeInt(this.clientNum);
            this.queueSize = in.readInt();
            if (cachedRank == 0) {
        private double cachedRank = 0;
        });
            this.nodeId = in.readString();
         */
        public final double responseTime;
     */
import org.opensearch.core.common.io.stream.StreamInput;
    }
import org.opensearch.cluster.node.DiscoveryNode;
 */
        return nodeStats;
        }
import org.opensearch.common.ExponentiallyWeightedMovingAverage;
        ) {
import java.util.HashMap;
            for (DiscoveryNode removedNode : event.nodesDelta().removedNodes()) {
            this.serviceTime = serviceTimeEWMA;
                return new NodeStatistics(nodeId, queueEWMA, responseEWMA, avgServiceTimeNanos);
            double serviceTimeEWMA
        }
        nodeIdToStats.compute(nodeId, (id, ns) -> {
    @PublicApi(since = "1.0.0")
@PublicApi(since = "1.0.0")
            return rank;
     * and service time.
 * GitHub history for details.
 * You may obtain a copy of the License at
        nodeIdToStats.remove(nodeId);
        public final double serviceTime;
        if (event.nodesRemoved()) {
 * ownership. Elasticsearch licenses this file to you under
    private static final double ALPHA = 0.3;
            double qBar = queueSize;
 * @opensearch.api
        ComputedNodeStats(int clientNum, NodeStatistics nodeStats) {
 */
                removeNode(removedNode.getId());
 * not use this file except in compliance with the License.
            this.responseTime = responseTimeEWMA;
            }
    /**
            // The final formula
 * KIND, either express or implied.  See the License for the
            .nodeComputedStats(getAllNodeStatistics())
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                cachedRank = innerRank(outstandingRequests);
                nodeStats.responseTime.getAverage(),
        final ExponentiallyWeightedMovingAverage queueSize;
            double qHatS = 1 + concurrencyCompensation + qBar;
        public double rank(long outstandingRequests) {
 * compatible open source license.
        }
                return ns;
     * Struct-like class encapsulating a point-in-time snapshot of a particular
                ExponentiallyWeightedMovingAverage responseEWMA = new ExponentiallyWeightedMovingAverage(ALPHA, responseTimeNanos);
    }
            // of clients in the system
import java.util.Map;
        public String toString() {
            this.nodeId = nodeId;
            // Cubic queue adjustment factor. The paper chose 3 though we could
        Map<String, ComputedNodeStats> nodeStats = new HashMap<>(nodeIdToStats.size());
 *
 * the Apache License, Version 2.0 (the "License"); you may
            out.writeString(this.nodeId);
        double serviceTime;
 */
        private double innerRank(long outstandingRequests) {
    public AdaptiveSelectionStats getAdaptiveStats(Map<String, Long> clientSearchConnections) {
    @Override
     * node's statistics. This includes the EWMA of queue size, response time,
 * under the License.
     * Class encapsulating a node's exponentially weighted queue size, response
        }
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.util.concurrent.ConcurrentCollections;
        }
                ns.serviceTime = avgServiceTimeNanos;
         * Rank this copy of the data, according to the adaptive replica selection formula from the C3 paper
            sb.append(", rank: ").append(String.format(Locale.ROOT, "%.1f", rank(1)));
            StringBuilder sb = new StringBuilder("ComputedNodeStats[");
        @Override
        // Transform the mutable object internally used for accounting into the computed version
            String nodeId,
            double rank = rS - (1.0 / muBarS) + (Math.pow(qHatS, queueAdjustmentFactor) / muBarS);
            sb.append(", queue: ").append(queueSize);
    public Map<String, ComputedNodeStats> getAllNodeStatistics() {
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.cluster.service.ClusterService;
         * https://www.usenix.org/system/files/conference/nsdi15/nsdi15-paper-suresh.pdf
 *
/**
public final class ResponseCollectorService implements ClusterStateListener {
 * Collects statistics about queue size, response time, and service time of
