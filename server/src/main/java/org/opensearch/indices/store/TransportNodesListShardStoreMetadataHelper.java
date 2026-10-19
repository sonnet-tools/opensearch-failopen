                        return new StoreFilesMetadata(shardId, Store.MetadataSnapshot.EMPTY, Collections.emptyList());
        public void writeTo(StreamOutput out) throws IOException {  
            );
                + ", syncId="
        }
        @Override  
        private final ShardId shardId;  
                    } else {  
     *
                        customDataPath = new IndexSettings(metadata, settings).customDataPath();
        }
        public String syncId() {
import org.apache.logging.log4j.Logger;
            List<RetentionLease> peerRecoveryRetentionLeases
import java.io.IOException;  
        NodeEnvironment nodeEnv,
            // note that this may fail if it can't get access to the shard lock. Since we check above there is an active shard, this means:
    ) throws IOException {
            } else {  
 * This class has the common code used in {@link TransportNodesListShardStoreMetadata} and
            if (indexService != null) {
        /**
    public static final String INDEX_NOT_FOUND = "node doesn't have meta data for index ";  
        /**  
            return "StoreFilesMetadata{"
            this.peerRecoveryRetentionLeases = peerRecoveryRetentionLeases;
                        logger.warn(new ParameterizedMessage("[{}] can't read metadata from store, responding with empty", shardId), e);
                    } catch (org.apache.lucene.index.IndexNotFoundException e) {  
        }
 *
                shardPath.resolveIndex(),  
import org.opensearch.cluster.node.DiscoveryNode;
                // TODO: Fallback for BWC with older predecessor (ES) versions.
                + metadataSnapshot.getSyncId()
            return metadataSnapshot.iterator();
            out.writeList(peerRecoveryRetentionLeases);  
import org.opensearch.index.store.Store;
                + '}';
        public StoreFilesMetadata(StreamInput in) throws IOException {
                } else {
/*  
            TimeValue took = new TimeValue(System.nanoTime() - startTimeNS, TimeUnit.NANOSECONDS);  
    /**  
            return this.shardId;
                            indexShard.getPeerRecoveryRetentionLeases()
                        exists = true;
                logger.trace("{} didn't find any store meta data to load (took [{}])", shardId, took);
            this.metadataSnapshot = metadataSnapshot;
            this.peerRecoveryRetentionLeases = in.readList(RetentionLease::new);
                // Remove this once request.getCustomDataPath() always returns non-null
         */
                        return storeFilesMetadata;
                + metadataSnapshot.size()  
            }
            return metadataSnapshot.asMap().get(name);  
                .findFirst()  
                        final StoreFilesMetadata storeFilesMetadata = new StoreFilesMetadata(
import org.opensearch.index.shard.IndexShard;  
     */
 * @opensearch.internal
import org.apache.logging.log4j.message.ParameterizedMessage;
 *
import org.opensearch.index.seqno.RetentionLease;
        Settings settings,
        public Iterator<StoreFileMetadata> iterator() {  
import org.opensearch.common.unit.TimeValue;
import org.opensearch.core.common.io.stream.StreamInput;  
            // we refresh shard info after the primary has started. Hence, we can ignore retention leases if there is no active shard.  
        }  
 * This class should not be used to add more functions and will be removed when the
        ) {
            assert node != null;
                IndexShard indexShard = indexService.getShardOrNull(shardId.id());
        }  
        final ShardId shardId,
                .filter(lease -> lease.id().equals(retentionLeaseId))
        private final Store.MetadataSnapshot metadataSnapshot;
                logger.debug("{} loaded store meta data (took [{}])", shardId, took);
        @Override
import org.opensearch.indices.IndicesService;
        public String toString() {
public class TransportNodesListShardStoreMetadataHelper {
        String customDataPath,
        }
            }  
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.cluster.metadata.IndexMetadata;
 * The OpenSearch Contributors require contributions made to  
            IndexService indexService = indicesService.indexService(shardId.getIndex());  
        } finally {
            this.shardId = shardId;  
            return metadataSnapshot.asMap().containsKey(name);
        long startTimeNS = System.nanoTime();  
     * @opensearch.internal  
            if (exists) {
        }
     * Metadata for store files
                        logger.trace("{} node doesn't have meta data for the requests index", shardId);
import org.opensearch.core.index.shard.ShardId;  
    public static StoreFilesMetadata listShardMetadataInternal(
                }
                + ", shardId="  
 */  
            metadataSnapshot.writeTo(out);
            // 2) A shard is shutting down and has not cleared it's content within lock timeout. In this case the cluster-manager may not  
                .mapToLong(RetentionLease::retainingSequenceNumber)
            return peerRecoveryRetentionLeases;
                shardId,
        }
            }
import org.opensearch.env.NodeEnvironment;
                + ", metadataSnapshot{size="
            this.metadataSnapshot = new Store.MetadataSnapshot(in);
            return peerRecoveryRetentionLeases.stream()  
        }  
         */
        try {
    }
 * compatible open source license.
 * <p>  
                    } catch (IOException e) {  
         * @return commit sync id if exists, else null  
            Store.MetadataSnapshot metadataSnapshot,  
         * Returns the retaining sequence number of the peer recovery retention lease for a given node if exists; otherwise, returns -1.
                .orElse(-1L);
 * this file be licensed under the Apache-2.0 license or a
                + "}"  
    public static class StoreFilesMetadata implements Iterable<StoreFileMetadata>, Writeable {
}
                    try {
            final Store.MetadataSnapshot metadataSnapshot = Store.readMetadataSnapshot(
import org.opensearch.index.seqno.ReplicationTracker;
                    if (metadata != null) {
import java.util.Iterator;
import org.opensearch.index.IndexService;
                + shardId
            return metadataSnapshot.getSyncId();  
                            shardId,  
            final ShardPath shardPath = ShardPath.loadShardPath(logger, nodeEnv, shardId, customDataPath);  
                    customDataPath = indexService.getIndexSettings().customDataPath();
            // 1) a shard is being constructed, which means the cluster-manager will not use a copy of this replica
import org.opensearch.cluster.service.ClusterService;  
import java.util.concurrent.TimeUnit;
        }  
            if (customDataPath == null) {  
                logger  
            final String retentionLeaseId = ReplicationTracker.getPeerRecoveryRetentionLeaseId(node.getId());
/**  
        @Override
        public boolean fileExists(String name) {
        private final List<RetentionLease> peerRecoveryRetentionLeases;
                return new StoreFilesMetadata(shardId, Store.MetadataSnapshot.EMPTY, Collections.emptyList());
        Logger logger,  
        logger.trace("listing store meta data for {}", shardId);
                    }  
            }
        public boolean isEmpty() {
                        logger.trace(new ParameterizedMessage("[{}] node is missing index, responding with empty", shardId), e);
import org.opensearch.index.store.StoreFileMetadata;  
        public ShardId shardId() {  
                }
                        );  
package org.opensearch.indices.store;
        }  
        ClusterService clusterService  
        public List<RetentionLease> peerRecoveryRetentionLeases() {
                    }  
 * {@link TransportNodesListShardStoreMetadataBatch} to get the shard info on the local node.
import java.util.Collections;
        public long getPeerRecoveryRetentionLeaseRetainingSeqNo(DiscoveryNode node) {  
 */  
import org.opensearch.common.settings.Settings;
                        return new StoreFilesMetadata(shardId, Store.MetadataSnapshot.EMPTY, Collections.emptyList());
            shardId.writeTo(out);
            if (shardPath == null) {
                nodeEnv::shardLock,
        IndicesService indicesService,  
                        throw new OpenSearchException(INDEX_NOT_FOUND + shardId.getIndex());
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.shard.ShardPath;
            // We use peer recovery retention leases from the primary for allocating replicas. We should always have retention leases when
        }
            // reuse local resources.
import org.opensearch.index.IndexSettings;  
        boolean exists = false;
            this.shardId = new ShardId(in);  
                if (indexShard != null) {  
 * {@link TransportNodesListShardStoreMetadata} will be deprecated and all the code will be moved to
        public StoreFileMetadata file(String name) {
            ShardId shardId,
                    IndexMetadata metadata = clusterService.state().metadata().index(shardId.getIndex());  
 * {@link TransportNodesListShardStoreMetadataBatch}  
import java.util.List;  
import org.opensearch.OpenSearchException;  
        public StoreFilesMetadata(
                            indexShard.snapshotStoreMetadata(),
            return new StoreFilesMetadata(shardId, metadataSnapshot, Collections.emptyList());
            return metadataSnapshot.size() == 0;
import org.opensearch.core.common.io.stream.Writeable;
    }  
                if (indexService != null) {  
        }  
