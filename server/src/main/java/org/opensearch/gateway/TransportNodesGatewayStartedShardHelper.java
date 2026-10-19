            this.node = node;
            super(allocationId, primary, replicationCheckpoint, storeException);
                // we don't have an open shard on the store, validate the files on disk are openable
        }
        Settings settings,
                        customDataPath = new IndexSettings(metadata, settings).customDataPath();
import org.opensearch.common.settings.Settings;
import org.opensearch.indices.IndicesService;  
        ) {  
            result = 31 * result + (replicationCheckpoint != null ? replicationCheckpoint.hashCode() : 0);
            Exception storeException,
            }
            }  
                    }
        public GatewayStartedShard(  
     * This class removes the dependency of
public class TransportNodesGatewayStartedShardHelper {
        public ReplicationCheckpoint replicationCheckpoint() {
     *
            return primary == that.primary
/*  
     * This class encapsulates the metadata about a started shard that needs to be persisted or sent between nodes.  
                && gatewayStartedShard.storeException() == null
                replicationCheckpoint.writeTo(out);  
     * which reduces memory footprint of its objects.
            }  
                if (shardDataPathInRequest != null) {  
     * @opensearch.internal  
        logger.trace("{} loading local shard state info", shardId);
    public static final String INDEX_NOT_FOUND = "node doesn't have meta data for index";
            buf.append("NodeGatewayStartedShards[").append("allocationId=").append(allocationId).append(",primary=").append(primary);
        String shardDataPathInRequest,
            int result = (allocationId != null ? allocationId.hashCode() : 0);
import org.opensearch.index.shard.IndexShard;
            } else {
            }
                } else {
/**  
 * <p>  
            nodeEnv.availableShardPaths(shardId)  
            this(allocationId, primary, replicationCheckpoint, null);  
     * {@link PrimaryShardAllocator} and {@link PrimaryShardBatchAllocator} to make allocation decision.  
            logger.debug("{} shard state info found: [{}]", shardId, shardStateMetadata);
            ReplicationCheckpoint replicationCheckpoint,  
            );
        }  
import org.opensearch.core.xcontent.NamedXContentRegistry;
                } catch (Exception exception) {  
import org.opensearch.index.shard.ShardPath;  
}  
                replicationCheckpoint = null;
                    logger.trace(
import org.opensearch.core.index.shard.ShardId;
                            shardStateMetadata,  
                && Objects.equals(storeException, that.storeException)
                shardStateMetadata.primary,  
import org.opensearch.index.shard.ShardStateMetadata;
import org.opensearch.cluster.metadata.IndexMetadata;
            final IndexShard shard = indicesService.getShardOrNull(shardId);  
                        logger.trace("{} node doesn't have meta data for the requests index", shardId);  
 * This class should not be used to add more functions and will be removed when the
        ShardStateMetadata shardStateMetadata = ShardStateMetadata.FORMAT.loadLatestState(  
                    customDataPath = shardDataPathInRequest;
                ShardPath shardPath = null;
            } else {
        public NodeGatewayStartedShard(  
        }
        }  
package org.opensearch.gateway;
            out.writeOptionalString(allocationId);
     * {@link PrimaryShardAllocator} or {@link PrimaryShardBatchAllocator}.  
            return node;  
        final ShardId shardId,  
                out.writeBoolean(false);
        private final boolean primary;
 * {@link TransportNodesListGatewayStartedShardsBatch}  
     */
        private final ReplicationCheckpoint replicationCheckpoint;  
            logger,
        IndicesService indicesService,  
                return true;  
            return this.replicationCheckpoint;  
            boolean primary,
        }
        }
            this.allocationId = allocationId;  
            }
        @Override
                    // TODO: Fallback for BWC with older OpenSearch versions.  
        ClusterService clusterService  
            namedXContentRegistry,
        }
     * {@link TransportNodesListGatewayStartedShards.NodeGatewayStartedShards} because we don't need to save an extra
            String allocationId,
        Logger logger,
            result = 31 * result + (primary ? 1 : 0);
 * This class has the common code used in {@link TransportNodesListGatewayStartedShards} and
        if (shardStateMetadata != null) {
 * SPDX-License-Identifier: Apache-2.0
                out.writeBoolean(false);
            boolean primary,
            return gatewayStartedShard.allocationId() == null
        @Override
            String allocationId = shardStateMetadata.allocationId != null ? shardStateMetadata.allocationId.getId() : null;
                && Objects.equals(replicationCheckpoint, that.replicationCheckpoint);
            if (in.readBoolean()) {
                replicationCheckpoint = new ReplicationCheckpoint(in);
        }  
                            "{} can't open index for shard [{}] in path [{}]",
                out.writeException(storeException);  
            }
    /**  
                        throw new IllegalStateException(shardId + " no shard path found");  
 *
        }  
                && shardStateMetadata.indexDataLocation == ShardStateMetadata.IndexDataLocation.LOCAL) {
     * This class extends the {@link GatewayStartedShard} which contains all necessary shard metadata like
            return this.primary;
    }
                && gatewayStartedShard.replicationCheckpoint() == null;
            }
        }  
                final String customDataPath;
    /**
            return result;
            } else {
                storeException = in.readException();  
        public boolean equals(Object o) {
            if (storeException != null) {
        public static boolean isEmpty(GatewayStartedShard gatewayStartedShard) {
        NamedXContentRegistry namedXContentRegistry,
                    shardPath = ShardPath.loadShardPath(logger, nodeEnv, shardId, customDataPath);
     */
import org.opensearch.core.common.io.stream.StreamInput;
        }
    }  
                    if (shardPath == null) {
            if (storeException != null) {  
        public String toString() {  
                shard != null ? shard.getLatestReplicationCheckpoint() : null
                    final IndexMetadata metadata = clusterService.state().metadata().index(shardId.getIndex());
                }
            this.replicationCheckpoint = replicationCheckpoint;
                    // Remove once request.getCustomDataPath() always returns non-null
 * compatible open source license.
        ) {
        public void writeTo(StreamOutput out) throws IOException {
            buf.append("]");  
import org.opensearch.env.NodeEnvironment;  
        }  
                        ),
import java.util.Objects;
    public static GatewayStartedShard getShardInfoOnLocalNode(
                buf.append(",storeException=").append(storeException);
            return this.allocationId;
    public static class NodeGatewayStartedShard extends GatewayStartedShard {
     * {@link DiscoveryNode} object like in {@link TransportNodesListGatewayStartedShards.NodeGatewayStartedShards}  
                out.writeBoolean(true);
                            shardId,
                        exception  
                            (finalShardPath != null) ? finalShardPath.resolveIndex() : ""
 * {@link TransportNodesListGatewayStartedShardsBatch} to get the shard info on the local node.
                try {  
        }
            this.primary = primary;
 * @opensearch.internal
                }  
        public Exception storeException() {  
     * {@link TransportNodesListGatewayStartedShards.NodeGatewayStartedShards} to make allocation decisions by
import org.apache.logging.log4j.message.ParameterizedMessage;
                    } else {
    }
import java.io.IOException;  
            return buf.toString();
        logger.trace("{} no local shard info found", shardId);
 *
                && Objects.equals(allocationId, that.allocationId)  
        @Override  
            StringBuilder buf = new StringBuilder();
            if (o == null || getClass() != o.getClass()) {
                    Store.tryOpenIndex(shardPath.resolveIndex(), shardId, nodeEnv::shardLock, logger);
                    if (metadata != null) {  
            Exception storeException
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
 */  
 * {@link TransportNodesListGatewayStartedShards} will be deprecated and all the code will be moved to
import org.opensearch.OpenSearchException;  
                    String allocationId = shardStateMetadata.allocationId != null ? shardStateMetadata.allocationId.getId() : null;
                    }
     * allocationId and replication checkpoint. It also has DiscoveryNode which is needed by
import org.opensearch.core.common.io.stream.StreamOutput;  
                    );
                buf.append(",ReplicationCheckpoint=").append(replicationCheckpoint.toString());
            if (in.readBoolean()) {
            return new GatewayStartedShard(
            return this.storeException;
        return new GatewayStartedShard(null, false, null);
            result = 31 * result + (storeException != null ? storeException.hashCode() : 0);  
                    final ShardPath finalShardPath = shardPath;
            if (replicationCheckpoint != null) {
    public static class GatewayStartedShard {
            }
                    return new GatewayStartedShard(allocationId, shardStateMetadata.primary, null, exception);  
    ) throws IOException {
        private final Exception storeException;
            }  
                return false;  
            if (this == o) {
            if (replicationCheckpoint != null) {  
     * This is used in {@link TransportNodesListGatewayStartedShardsBatch.NodeGatewayStartedShardsBatch} to construct the response for each node, instead of
            GatewayStartedShard that = (GatewayStartedShard) o;  
        }  
            allocationId = in.readOptionalString();  
                storeException = null;
        public boolean primary() {
        public GatewayStartedShard(StreamInput in) throws IOException {
 */  
        public GatewayStartedShard(String allocationId, boolean primary, ReplicationCheckpoint replicationCheckpoint) {
        private final DiscoveryNode node;
                allocationId,
import org.apache.logging.log4j.Logger;
import org.opensearch.index.IndexSettings;
        public DiscoveryNode getNode() {
            String allocationId,
            out.writeBoolean(primary);  
            if (indicesService.getShardOrNull(shardId) == null  
        }
        public String allocationId() {  
            DiscoveryNode node
                && gatewayStartedShard.primary() == false  
            primary = in.readBoolean();
        public int hashCode() {  
                out.writeBoolean(true);
import org.opensearch.index.store.Store;
import org.opensearch.cluster.node.DiscoveryNode;
        private final String allocationId;  
 * this file be licensed under the Apache-2.0 license or a
        );
            ReplicationCheckpoint replicationCheckpoint,  
 * The OpenSearch Contributors require contributions made to  
            this.storeException = storeException;  
                        () -> new ParameterizedMessage(  
                        throw new OpenSearchException(INDEX_NOT_FOUND + " " + shardId.getIndex());
            } else {  
        NodeEnvironment nodeEnv,
import org.opensearch.cluster.service.ClusterService;  
