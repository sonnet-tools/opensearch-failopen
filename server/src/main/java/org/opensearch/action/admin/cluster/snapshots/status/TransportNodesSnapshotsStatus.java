            snapshots = in.readList(Snapshot::new);
            this.status = status;
            this.snapshots = snapshots;
            status = unmodifiableMap(  
     */
 *
                snapshotMapBuilder.put(snapshot, unmodifiableMap(shardMapBuilder));
                    final IndexShardSnapshotStatus.Copy lastSnapshotStatus = shardEntry.getValue().asCopy();  
            super(in);  
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.cluster.service.ClusterService;
        try {
                    shardMapBuilder.put(shardEntry.getKey(), new SnapshotIndexShardStatus(shardId, lastSnapshotStatus, shardNodeId));
     * Inner Node Shapshot Status
            throw new UnsupportedOperationException("shouldn't be here");  
        }
    public static class NodeSnapshotStatus extends BaseNodeResponse {  
 */
        TransportService transportService,
public class TransportNodesSnapshotsStatus extends TransportNodesAction<
 * compatible open source license.
    @Override  
 * Transport action that collects snapshot shard statuses from data nodes
import org.opensearch.action.support.nodes.TransportNodesAction;
            final String nodeId = clusterService.localNode().getId();
    }
 * this file be licensed under the Apache-2.0 license or a
        } catch (Exception e) {
/**  
            ACTION_NAME,  
    protected NodeSnapshotStatus nodeOperation(NodeRequest request) {
        public Request(String[] nodesIds) {  
/*  
    @Override
            super(in);
     */
    }
    TransportNodesSnapshotsStatus.Request,  
        }
import org.opensearch.action.support.nodes.BaseNodesRequest;  
 * software distributed under the License is distributed on an
        public void writeTo(StreamOutput out) throws IOException {
        @Override  
            snapshots = Arrays.asList(request.snapshots);  
        super(
        }
    ) {
                Map<ShardId, SnapshotIndexShardStatus> shardMapBuilder = new HashMap<>();
     * @opensearch.internal
            transportService,  
        public Map<Snapshot, Map<ShardId, SnapshotIndexShardStatus>> status() {
    protected NodeRequest newNodeRequest(Request request) {
 *  
        public Request(StreamInput in) throws IOException {  
 * Unless required by applicable law or agreed to in writing,
                        // Store node id for the snapshots that are currently running.
        }
        NodeRequest(TransportNodesSnapshotsStatus.Request request) {
                in.readMap(Snapshot::new, input -> unmodifiableMap(input.readMap(ShardId::new, SnapshotIndexShardStatus::new)))
        }
 */  
            threadPool,
                    String shardNodeId = null;  
 * not use this file except in compliance with the License.
        ThreadPool threadPool,
 *     http://www.apache.org/licenses/LICENSE-2.0
                    final ShardId shardId = shardEntry.getKey();
import org.opensearch.snapshots.SnapshotShardsService;
import java.util.Map;
            super(in);
    TransportNodesSnapshotsStatus.NodeSnapshotStatus> {  
 * under the License.  
 * @opensearch.internal  
 * Licensed to Elasticsearch under one or more contributor  
        }
            super.writeTo(out);
            for (Snapshot snapshot : request.snapshots) {  
            }
                for (Map.Entry<ShardId, IndexShardSnapshotStatus> shardEntry : shardsStatus.entrySet()) {  
        }
        }  
        ClusterService clusterService,  
        @Override  
        protected void writeNodesTo(StreamOutput out, List<NodeSnapshotStatus> nodes) throws IOException {
     * Inner Request
 * GitHub history for details.
        @Override  
import org.opensearch.transport.TransportService;
        }  
        }
     * @opensearch.internal
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected NodesSnapshotStatus newResponse(Request request, List<NodeSnapshotStatus> responses, List<FailedNodeException> failures) {  
            super(clusterName, nodes, failures);
        this.snapshotShardsService = snapshotShardsService;
import org.opensearch.transport.TransportRequest;
        }
            out.writeList(nodes);
            super(in);
        return new NodeRequest(request);  
import org.opensearch.index.snapshots.IndexShardSnapshotStatus;  
            super.writeTo(out);
            ThreadPool.Names.GENERIC,
        return new NodeSnapshotStatus(in);
    }
    @Override
                    if (stage != IndexShardSnapshotStatus.Stage.DONE && stage != IndexShardSnapshotStatus.Stage.FAILURE) {
    public static class NodesSnapshotStatus extends BaseNodesResponse<NodeSnapshotStatus> {  
 */
    TransportNodesSnapshotsStatus.NodesSnapshotStatus,
    }
    public static final ActionType<NodesSnapshotStatus> TYPE = new ActionType<>(ACTION_NAME, NodesSnapshotStatus::new);  
    public static class NodeRequest extends TransportRequest {
                        shardNodeId = nodeId;  
 * ownership. Elasticsearch licenses this file to you under  
            actionFilters,
            super(nodesIds);
    }
    }
     *  
    }  
        public NodesSnapshotStatus(ClusterName clusterName, List<NodeSnapshotStatus> nodes, List<FailedNodeException> failures) {  
    public static class Request extends BaseNodesRequest<Request> {
 * The OpenSearch Contributors require contributions made to  
        private final List<Snapshot> snapshots;
}
/*  
    }
                out.writeVInt(0);  
        @Override
     *
        public NodeRequest(StreamInput in) throws IOException {  
            clusterService,
            // This operation is never executed remotely
        }
/*
import org.opensearch.core.common.io.stream.StreamOutput;
    /**
        }
import static java.util.Collections.unmodifiableMap;
        SnapshotShardsService snapshotShardsService,
        public NodesSnapshotStatus(StreamInput in) throws IOException {
     * @opensearch.internal  
                );
            Request::new,
import java.util.HashMap;  
        );  
                    status,
                if (shardsStatus == null) {
 * specific language governing permissions and limitations
     */
import java.util.Arrays;
        public void writeTo(StreamOutput out) throws IOException {
 * You may obtain a copy of the License at  
    /**
    TransportNodesSnapshotsStatus.NodeRequest,
            return this;  
        public Request snapshots(Snapshot[] snapshots) {
                    (o, s) -> s.writeTo(o),
        public NodeSnapshotStatus(DiscoveryNode node, Map<Snapshot, Map<ShardId, SnapshotIndexShardStatus>> status) {
     */
 * license agreements. See the NOTICE file distributed with
                    (output, v) -> output.writeMap(v, (o, shardId) -> shardId.writeTo(o), (o, sis) -> sis.writeTo(o))  
            return status;
     *  
     * @opensearch.internal  
            }
            // This operation is never executed remotely
            if (status != null) {
            super(node);  
    @Override
            } else {
        Map<Snapshot, Map<ShardId, SnapshotIndexShardStatus>> snapshotMapBuilder = new HashMap<>();  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.action.FailedNodeException;  
    }  
            NodeSnapshotStatus.class
import org.opensearch.snapshots.Snapshot;
import org.opensearch.OpenSearchException;
        return new NodesSnapshotStatus(clusterService.getClusterName(), responses, failures);
     * Inner Node Snapshot Status
import org.opensearch.cluster.node.DiscoveryNode;
            throw new UnsupportedOperationException("shouldn't be here");  
import org.opensearch.action.ActionType;
        }  
 *
 * the Apache License, Version 2.0 (the "License"); you may
                }
 *
        private final Map<Snapshot, Map<ShardId, SnapshotIndexShardStatus>> status;
            out.writeList(snapshots);  
                    final IndexShardSnapshotStatus.Stage stage = lastSnapshotStatus.getStage();
        public void writeTo(StreamOutput out) throws IOException {  
        ActionFilters actionFilters  
                }  
        public NodeSnapshotStatus(StreamInput in) throws IOException {
import org.opensearch.cluster.ClusterName;  
import org.opensearch.threadpool.ThreadPool;  
        protected List<NodeSnapshotStatus> readNodesFrom(StreamInput in) throws IOException {
                    }
package org.opensearch.action.admin.cluster.snapshots.status;
                    continue;  
        }  
import org.opensearch.action.support.nodes.BaseNodesResponse;
import org.opensearch.action.support.nodes.BaseNodeResponse;
            return new NodeSnapshotStatus(clusterService.localNode(), unmodifiableMap(snapshotMapBuilder));  
 */  
            throw new OpenSearchException("failed to load metadata", e);
            NodeRequest::new,  
            return in.readList(NodeSnapshotStatus::new);  
     *
     * Inner Node Request
import org.opensearch.core.common.io.stream.StreamInput;  
import org.opensearch.action.support.ActionFilters;
import java.io.IOException;
        private Snapshot[] snapshots;
    /**  
    private final SnapshotShardsService snapshotShardsService;
 * this work for additional information regarding copyright
        }  
    protected NodeSnapshotStatus newNodeResponse(StreamInput in) throws IOException {
    /**  
            );
import java.util.List;
        @Override
                out.writeMap(  
 * KIND, either express or implied.  See the License for the
                Map<ShardId, IndexShardSnapshotStatus> shardsStatus = snapshotShardsService.currentSnapshotShards(snapshot);
    public TransportNodesSnapshotsStatus(
    public static final String ACTION_NAME = SnapshotsStatusAction.NAME + "[nodes]";
 * SPDX-License-Identifier: Apache-2.0
