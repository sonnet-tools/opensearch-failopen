    }
     *
            super(clusterName, nodes, failures);
        private Snapshot[] snapshots;
                    if (stage != IndexShardSnapshotStatus.Stage.DONE && stage != IndexShardSnapshotStatus.Stage.FAILURE) {
 */
 * this work for additional information regarding copyright
            snapshots = in.readList(Snapshot::new);
    protected NodesSnapshotStatus newResponse(Request request, List<NodeSnapshotStatus> responses, List<FailedNodeException> failures) {
 * this file be licensed under the Apache-2.0 license or a
    /**
        return new NodeSnapshotStatus(in);
            // This operation is never executed remotely
                in.readMap(Snapshot::new, input -> unmodifiableMap(input.readMap(ShardId::new, SnapshotIndexShardStatus::new)))
                Map<ShardId, IndexShardSnapshotStatus> shardsStatus = snapshotShardsService.currentSnapshotShards(snapshot);
 * under the License.
    ) {
        NodeRequest(TransportNodesSnapshotsStatus.Request request) {
 * Unless required by applicable law or agreed to in writing,
        public NodesSnapshotStatus(StreamInput in) throws IOException {
            super(in);
    }
            }
            return status;
            if (status != null) {
import org.opensearch.OpenSearchException;
        public NodeSnapshotStatus(DiscoveryNode node, Map<Snapshot, Map<ShardId, SnapshotIndexShardStatus>> status) {
import org.opensearch.snapshots.SnapshotShardsService;
        }
    /**
import org.opensearch.cluster.ClusterName;
    public TransportNodesSnapshotsStatus(
        SnapshotShardsService snapshotShardsService,
        }
import org.opensearch.transport.TransportRequest;
    public static class NodeSnapshotStatus extends BaseNodeResponse {
 *
                    status,
                );
    @Override
            for (Snapshot snapshot : request.snapshots) {
                        shardNodeId = nodeId;
        }
                    String shardNodeId = null;
        }
                snapshotMapBuilder.put(snapshot, unmodifiableMap(shardMapBuilder));
    public static class Request extends BaseNodesRequest<Request> {
            NodeRequest::new,
        private final List<Snapshot> snapshots;
            }
            } else {
    private final SnapshotShardsService snapshotShardsService;
/*
                        // Store node id for the snapshots that are currently running.
/*
        }
     * Inner Request
import java.util.List;
            throw new UnsupportedOperationException("shouldn't be here");
     */
            // This operation is never executed remotely
    }
 * @opensearch.internal
            transportService,
     * Inner Node Request
        }
            out.writeList(nodes);
            );
    protected NodeSnapshotStatus newNodeResponse(StreamInput in) throws IOException {
            return new NodeSnapshotStatus(clusterService.localNode(), unmodifiableMap(snapshotMapBuilder));
     * @opensearch.internal
    }
import org.opensearch.snapshots.Snapshot;
 * You may obtain a copy of the License at
        }
        public Request snapshots(Snapshot[] snapshots) {
        @Override
                    final IndexShardSnapshotStatus.Stage stage = lastSnapshotStatus.getStage();
        @Override
     *
        public void writeTo(StreamOutput out) throws IOException {
                    shardMapBuilder.put(shardEntry.getKey(), new SnapshotIndexShardStatus(shardId, lastSnapshotStatus, shardNodeId));
 * specific language governing permissions and limitations
                if (shardsStatus == null) {
        try {
                for (Map.Entry<ShardId, IndexShardSnapshotStatus> shardEntry : shardsStatus.entrySet()) {
import org.opensearch.threadpool.ThreadPool;
import static java.util.Collections.unmodifiableMap;
        public NodeSnapshotStatus(StreamInput in) throws IOException {
import java.util.HashMap;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
            snapshots = Arrays.asList(request.snapshots);
    }
import org.opensearch.cluster.service.ClusterService;
     */
        ThreadPool threadPool,
            throw new UnsupportedOperationException("shouldn't be here");
 */
    public static class NodesSnapshotStatus extends BaseNodesResponse<NodeSnapshotStatus> {
import java.util.Arrays;
import org.opensearch.action.support.nodes.BaseNodesRequest;
/*
     *
 *
    public static class NodeRequest extends TransportRequest {
import java.util.Map;
    }
        public Request(String[] nodesIds) {
    @Override
        }
        }
 * not use this file except in compliance with the License.
 * compatible open source license.
import org.opensearch.action.support.nodes.BaseNodesResponse;
    protected NodeSnapshotStatus nodeOperation(NodeRequest request) {
                    final IndexShardSnapshotStatus.Copy lastSnapshotStatus = shardEntry.getValue().asCopy();
        ActionFilters actionFilters
     * @opensearch.internal
            return in.readList(NodeSnapshotStatus::new);
    }
                out.writeVInt(0);
            NodeSnapshotStatus.class
        }
            super(in);
 * software distributed under the License is distributed on an
        @Override
                    }
import org.opensearch.transport.TransportService;
            throw new OpenSearchException("failed to load metadata", e);
                    (output, v) -> output.writeMap(v, (o, shardId) -> shardId.writeTo(o), (o, sis) -> sis.writeTo(o))
                Map<ShardId, SnapshotIndexShardStatus> shardMapBuilder = new HashMap<>();
 * Modifications Copyright OpenSearch Contributors. See
 */
        private final Map<Snapshot, Map<ShardId, SnapshotIndexShardStatus>> status;
import org.opensearch.action.support.nodes.TransportNodesAction;
        public void writeTo(StreamOutput out) throws IOException {
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to
import org.opensearch.core.common.io.stream.StreamInput;
            super(node);
    TransportNodesSnapshotsStatus.NodeRequest,
     * @opensearch.internal
            clusterService,
            super(in);
    TransportNodesSnapshotsStatus.NodeSnapshotStatus> {
import org.opensearch.index.snapshots.IndexShardSnapshotStatus;
                }
            super.writeTo(out);
     */
        );
        }
            status = unmodifiableMap(
    }
                    final ShardId shardId = shardEntry.getKey();
    }
/**
        }
        public Map<Snapshot, Map<ShardId, SnapshotIndexShardStatus>> status() {
            Request::new,
import org.opensearch.core.index.shard.ShardId;
            ThreadPool.Names.GENERIC,
            super(in);
    public static final ActionType<NodesSnapshotStatus> TYPE = new ActionType<>(ACTION_NAME, NodesSnapshotStatus::new);
        }
     * @opensearch.internal
import org.opensearch.cluster.node.DiscoveryNode;
 */
import org.opensearch.action.FailedNodeException;
    /**
        }
            final String nodeId = clusterService.localNode().getId();
        return new NodesSnapshotStatus(clusterService.getClusterName(), responses, failures);
                out.writeMap(
        @Override
        } catch (Exception e) {
import org.opensearch.action.support.ActionFilters;
            threadPool,
 *
 *
        TransportService transportService,
        public NodeRequest(StreamInput in) throws IOException {
 * Transport action that collects snapshot shard statuses from data nodes
                    (o, s) -> s.writeTo(o),
import org.opensearch.action.support.nodes.BaseNodeResponse;
            super.writeTo(out);
     */
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.core.common.io.stream.StreamOutput;
        protected void writeNodesTo(StreamOutput out, List<NodeSnapshotStatus> nodes) throws IOException {
                    continue;
        public Request(StreamInput in) throws IOException {
     *
            out.writeList(snapshots);
     * Inner Node Snapshot Status
import org.opensearch.action.ActionType;
        super(
        protected List<NodeSnapshotStatus> readNodesFrom(StreamInput in) throws IOException {
public class TransportNodesSnapshotsStatus extends TransportNodesAction<
    public static final String ACTION_NAME = SnapshotsStatusAction.NAME + "[nodes]";
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under
                }
            this.status = status;
import java.io.IOException;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        ClusterService clusterService,
}
        this.snapshotShardsService = snapshotShardsService;
        public void writeTo(StreamOutput out) throws IOException {
 * KIND, either express or implied.  See the License for the
        return new NodeRequest(request);
            super(nodesIds);
    protected NodeRequest newNodeRequest(Request request) {
        @Override
package org.opensearch.action.admin.cluster.snapshots.status;
        }
        Map<Snapshot, Map<ShardId, SnapshotIndexShardStatus>> snapshotMapBuilder = new HashMap<>();
            actionFilters,
            this.snapshots = snapshots;
    @Override
        public NodesSnapshotStatus(ClusterName clusterName, List<NodeSnapshotStatus> nodes, List<FailedNodeException> failures) {
            ACTION_NAME,
        }
            return this;
    TransportNodesSnapshotsStatus.NodesSnapshotStatus,
    TransportNodesSnapshotsStatus.Request,
     * Inner Node Shapshot Status
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
    /**
