     */
        public Exception storeException() {
        }
            allocationId = in.readOptionalString();
            ReplicationCheckpoint replicationCheckpoint,
            return buf.toString();
     * This class removes the dependency of
     * {@link TransportNodesListGatewayStartedShards.NodeGatewayStartedShards} to make allocation decisions by
            }
        public GatewayStartedShard(StreamInput in) throws IOException {
                && Objects.equals(storeException, that.storeException)
 * This class should not be used to add more functions and will be removed when the
 */
            if (replicationCheckpoint != null) {
                        ),
    /**
                    shardPath = ShardPath.loadShardPath(logger, nodeEnv, shardId, customDataPath);
 *
            return result;
     * {@link PrimaryShardAllocator} and {@link PrimaryShardBatchAllocator} to make allocation decision.
                    logger.trace(
                return false;
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
import org.opensearch.core.common.io.stream.StreamInput;
            result = 31 * result + (storeException != null ? storeException.hashCode() : 0);
            buf.append("]");
        public String toString() {
        final ShardId shardId,
                    Store.tryOpenIndex(shardPath.resolveIndex(), shardId, nodeEnv::shardLock, logger);
    /**
            return new GatewayStartedShard(
                if (shardDataPathInRequest != null) {
                } else {
                    return new GatewayStartedShard(allocationId, shardStateMetadata.primary, null, exception);
            logger.debug("{} shard state info found: [{}]", shardId, shardStateMetadata);
            result = 31 * result + (primary ? 1 : 0);
     * This is used in {@link TransportNodesListGatewayStartedShardsBatch.NodeGatewayStartedShardsBatch} to construct the response for each node, instead of
import org.opensearch.env.NodeEnvironment;
                    );
import java.util.Objects;
            }
}
 * SPDX-License-Identifier: Apache-2.0
        private final ReplicationCheckpoint replicationCheckpoint;
     * @opensearch.internal
            StringBuilder buf = new StringBuilder();
        private final Exception storeException;
            }
        ClusterService clusterService
                replicationCheckpoint = null;
     * This class extends the {@link GatewayStartedShard} which contains all necessary shard metadata like
 * This class has the common code used in {@link TransportNodesListGatewayStartedShards} and
import org.opensearch.index.shard.IndexShard;
/**
        public void writeTo(StreamOutput out) throws IOException {
                shard != null ? shard.getLatestReplicationCheckpoint() : null
import org.opensearch.OpenSearchException;
            if (storeException != null) {
                out.writeBoolean(false);
        logger.trace("{} no local shard info found", shardId);
            if (indicesService.getShardOrNull(shardId) == null
            return this.allocationId;
            );
import org.opensearch.core.index.shard.ShardId;
            this.storeException = storeException;
                replicationCheckpoint = new ReplicationCheckpoint(in);
    ) throws IOException {
            } else {
import org.opensearch.index.shard.ShardStateMetadata;
        }
                            (finalShardPath != null) ? finalShardPath.resolveIndex() : ""
            if (in.readBoolean()) {
package org.opensearch.gateway;
import org.opensearch.core.common.io.stream.StreamOutput;
        public GatewayStartedShard(
        }
    }
            return this.replicationCheckpoint;
        ) {
    public static class GatewayStartedShard {
                out.writeBoolean(false);
                    if (metadata != null) {
 * {@link TransportNodesListGatewayStartedShardsBatch} to get the shard info on the local node.
        public ReplicationCheckpoint replicationCheckpoint() {
                storeException = null;
        }
                } catch (Exception exception) {
        }
    public static class NodeGatewayStartedShard extends GatewayStartedShard {
        private final boolean primary;
            boolean primary,
                    final IndexMetadata metadata = clusterService.state().metadata().index(shardId.getIndex());
        return new GatewayStartedShard(null, false, null);
                ShardPath shardPath = null;
 * <p>
                // we don't have an open shard on the store, validate the files on disk are openable
            }
        private final String allocationId;
                buf.append(",ReplicationCheckpoint=").append(replicationCheckpoint.toString());
public class TransportNodesGatewayStartedShardHelper {
import org.opensearch.index.store.Store;
        }
            out.writeBoolean(primary);
                            shardStateMetadata,
        @Override
        public String allocationId() {
     */
 */
                out.writeBoolean(true);
        public DiscoveryNode getNode() {
            primary = in.readBoolean();
                    final ShardPath finalShardPath = shardPath;
        }
        @Override
            return this.storeException;
            this.replicationCheckpoint = replicationCheckpoint;
            String allocationId = shardStateMetadata.allocationId != null ? shardStateMetadata.allocationId.getId() : null;
            String allocationId,
                        throw new OpenSearchException(INDEX_NOT_FOUND + " " + shardId.getIndex());
            Exception storeException
            boolean primary,
            super(allocationId, primary, replicationCheckpoint, storeException);
                    if (shardPath == null) {
        logger.trace("{} loading local shard state info", shardId);
            ReplicationCheckpoint replicationCheckpoint,
            return node;
import org.apache.logging.log4j.Logger;
            result = 31 * result + (replicationCheckpoint != null ? replicationCheckpoint.hashCode() : 0);
import org.opensearch.index.shard.ShardPath;
            logger,
                return true;
            } else {
            int result = (allocationId != null ? allocationId.hashCode() : 0);
/*
import org.opensearch.indices.IndicesService;
            } else {
        }
                && gatewayStartedShard.storeException() == null
                try {
                storeException = in.readException();
        String shardDataPathInRequest,
        }
                            shardId,
    }
                buf.append(",storeException=").append(storeException);
                        () -> new ParameterizedMessage(
                && gatewayStartedShard.replicationCheckpoint() == null;
        Settings settings,
            return primary == that.primary
import org.opensearch.core.xcontent.NamedXContentRegistry;
            final IndexShard shard = indicesService.getShardOrNull(shardId);
                shardStateMetadata.primary,
                    String allocationId = shardStateMetadata.allocationId != null ? shardStateMetadata.allocationId.getId() : null;
            if (in.readBoolean()) {
            this.node = node;
            }
            DiscoveryNode node
            } else {
            if (this == o) {
        Logger logger,
            }
import org.opensearch.cluster.metadata.IndexMetadata;
            GatewayStartedShard that = (GatewayStartedShard) o;
        }
    }
            nodeEnv.availableShardPaths(shardId)
import java.io.IOException;
     * allocationId and replication checkpoint. It also has DiscoveryNode which is needed by
                out.writeBoolean(true);
        NamedXContentRegistry namedXContentRegistry,
        public static boolean isEmpty(GatewayStartedShard gatewayStartedShard) {
                            "{} can't open index for shard [{}] in path [{}]",
            return this.primary;
            this.primary = primary;
 * compatible open source license.
        }
                        throw new IllegalStateException(shardId + " no shard path found");
     * {@link TransportNodesListGatewayStartedShards.NodeGatewayStartedShards} because we don't need to save an extra
 * @opensearch.internal
            String allocationId,
                && Objects.equals(allocationId, that.allocationId)
                    // Remove once request.getCustomDataPath() always returns non-null
     * {@link PrimaryShardAllocator} or {@link PrimaryShardBatchAllocator}.
 *
 * this file be licensed under the Apache-2.0 license or a
                    }
        public boolean primary() {
                final String customDataPath;
            this(allocationId, primary, replicationCheckpoint, null);
        IndicesService indicesService,
                && gatewayStartedShard.primary() == false
        public GatewayStartedShard(String allocationId, boolean primary, ReplicationCheckpoint replicationCheckpoint) {
                && shardStateMetadata.indexDataLocation == ShardStateMetadata.IndexDataLocation.LOCAL) {
        );
            buf.append("NodeGatewayStartedShards[").append("allocationId=").append(allocationId).append(",primary=").append(primary);
                allocationId,
     * which reduces memory footprint of its objects.
            }
 * {@link TransportNodesListGatewayStartedShards} will be deprecated and all the code will be moved to
        }
        NodeEnvironment nodeEnv,
 * The OpenSearch Contributors require contributions made to
     * {@link DiscoveryNode} object like in {@link TransportNodesListGatewayStartedShards.NodeGatewayStartedShards}
            Exception storeException,
            }
                && Objects.equals(replicationCheckpoint, that.replicationCheckpoint);
    public static GatewayStartedShard getShardInfoOnLocalNode(
        private final DiscoveryNode node;
import org.opensearch.index.IndexSettings;
                    // TODO: Fallback for BWC with older OpenSearch versions.
        }
        if (shardStateMetadata != null) {
        }
            return gatewayStartedShard.allocationId() == null
        public boolean equals(Object o) {
        @Override
 * {@link TransportNodesListGatewayStartedShardsBatch}
                }
            namedXContentRegistry,
                }
                    customDataPath = shardDataPathInRequest;
                        logger.trace("{} node doesn't have meta data for the requests index", shardId);
            if (storeException != null) {
        public int hashCode() {
                out.writeException(storeException);
     *
                        customDataPath = new IndexSettings(metadata, settings).customDataPath();
                        exception
            if (replicationCheckpoint != null) {
        }
                    } else {
import org.apache.logging.log4j.message.ParameterizedMessage;
                replicationCheckpoint.writeTo(out);
    public static final String INDEX_NOT_FOUND = "node doesn't have meta data for index";
import org.opensearch.cluster.node.DiscoveryNode;
                    }
            out.writeOptionalString(allocationId);
            if (o == null || getClass() != o.getClass()) {
        public NodeGatewayStartedShard(
            }
        ShardStateMetadata shardStateMetadata = ShardStateMetadata.FORMAT.loadLatestState(
     * This class encapsulates the metadata about a started shard that needs to be persisted or sent between nodes.
        ) {
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.common.settings.Settings;
            this.allocationId = allocationId;
