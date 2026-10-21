            // reuse local resources.
                logger
import org.opensearch.index.seqno.RetentionLease;
        }
        }
 * {@link TransportNodesListShardStoreMetadataBatch} to get the shard info on the local node.
            } else {
        public Iterator<StoreFileMetadata> iterator() {
        @Override
import org.opensearch.core.index.shard.ShardId;
            return "StoreFilesMetadata{"
                        exists = true;
                    } catch (org.apache.lucene.index.IndexNotFoundException e) {
        NodeEnvironment nodeEnv,
            Store.MetadataSnapshot metadataSnapshot,
import org.opensearch.index.store.StoreFileMetadata;
            }
import org.opensearch.index.shard.ShardPath;
 * {@link TransportNodesListShardStoreMetadataBatch}
            return metadataSnapshot.asMap().containsKey(name);
                        logger.trace("{} node doesn't have meta data for the requests index", shardId);
                        customDataPath = new IndexSettings(metadata, settings).customDataPath();
         */
        }
        }
import org.opensearch.index.store.Store;
            this.shardId = new ShardId(in);
        String customDataPath,
import org.opensearch.indices.IndicesService;
                return new StoreFilesMetadata(shardId, Store.MetadataSnapshot.EMPTY, Collections.emptyList());
                + shardId
            // 1) a shard is being constructed, which means the cluster-manager will not use a copy of this replica
                        logger.trace(new ParameterizedMessage("[{}] node is missing index, responding with empty", shardId), e);
        private final ShardId shardId;
                // TODO: Fallback for BWC with older predecessor (ES) versions.
        }
     */
            shardId.writeTo(out);
 * This class has the common code used in {@link TransportNodesListShardStoreMetadata} and
        @Override
        /**
        public boolean fileExists(String name) {
package org.opensearch.indices.store;
                    customDataPath = indexService.getIndexSettings().customDataPath();
            return this.shardId;
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.common.unit.TimeValue;
        }
                    if (metadata != null) {
            metadataSnapshot.writeTo(out);
                            indexShard.snapshotStoreMetadata(),
            TimeValue took = new TimeValue(System.nanoTime() - startTimeNS, TimeUnit.NANOSECONDS);
                + '}';
                shardId,
                    } catch (IOException e) {
                            indexShard.getPeerRecoveryRetentionLeases()
            return metadataSnapshot.asMap().get(name);
                    try {
 * <p>
        }
import java.util.List;
    ) throws IOException {
/*
    public static class StoreFilesMetadata implements Iterable<StoreFileMetadata>, Writeable {
                shardPath.resolveIndex(),
    public static final String INDEX_NOT_FOUND = "node doesn't have meta data for index ";
        long startTimeNS = System.nanoTime();
            // note that this may fail if it can't get access to the shard lock. Since we check above there is an active shard, this means:
        }
                    }
            return peerRecoveryRetentionLeases;
        Logger logger,
        IndicesService indicesService,
                logger.trace("{} didn't find any store meta data to load (took [{}])", shardId, took);
import org.opensearch.common.settings.Settings;
 * {@link TransportNodesListShardStoreMetadata} will be deprecated and all the code will be moved to
import org.opensearch.core.common.io.stream.StreamInput;
                        return storeFilesMetadata;
 * compatible open source license.
        @Override
import org.opensearch.OpenSearchException;
            );
    }
        } finally {
        }
import org.opensearch.env.NodeEnvironment;
import java.util.Iterator;
            if (indexService != null) {
                        return new StoreFilesMetadata(shardId, Store.MetadataSnapshot.EMPTY, Collections.emptyList());
            final ShardPath shardPath = ShardPath.loadShardPath(logger, nodeEnv, shardId, customDataPath);
         * Returns the retaining sequence number of the peer recovery retention lease for a given node if exists; otherwise, returns -1.
                if (indexShard != null) {
                IndexShard indexShard = indexService.getShardOrNull(shardId.id());
            final Store.MetadataSnapshot metadataSnapshot = Store.readMetadataSnapshot(
                    }
        public String toString() {
 */
            final String retentionLeaseId = ReplicationTracker.getPeerRecoveryRetentionLeaseId(node.getId());
    public static StoreFilesMetadata listShardMetadataInternal(
                + metadataSnapshot.size()
         * @return commit sync id if exists, else null
                    } else {
}
            assert node != null;
        try {
            this.shardId = shardId;
        }
            return peerRecoveryRetentionLeases.stream()
import org.opensearch.index.IndexSettings;
import org.opensearch.index.IndexService;
import org.apache.logging.log4j.message.ParameterizedMessage;
import java.io.IOException;
                .filter(lease -> lease.id().equals(retentionLeaseId))
            if (shardPath == null) {
        public long getPeerRecoveryRetentionLeaseRetainingSeqNo(DiscoveryNode node) {
        Settings settings,
            this.metadataSnapshot = metadataSnapshot;
import org.opensearch.cluster.metadata.IndexMetadata;
            }
                + ", metadataSnapshot{size="
                } else {
        /**
            if (customDataPath == null) {
        public List<RetentionLease> peerRecoveryRetentionLeases() {
            // We use peer recovery retention leases from the primary for allocating replicas. We should always have retention leases when
                .mapToLong(RetentionLease::retainingSequenceNumber)
        final ShardId shardId,
        public StoreFileMetadata file(String name) {
                .orElse(-1L);
            return new StoreFilesMetadata(shardId, metadataSnapshot, Collections.emptyList());
        public ShardId shardId() {
                        );
     *
        boolean exists = false;
            return metadataSnapshot.size() == 0;
import org.opensearch.index.shard.IndexShard;
            this.peerRecoveryRetentionLeases = peerRecoveryRetentionLeases;
import org.apache.logging.log4j.Logger;
                + "}"
        ) {
         */
                + ", shardId="
                        final StoreFilesMetadata storeFilesMetadata = new StoreFilesMetadata(
        public String syncId() {
/**
import org.opensearch.core.common.io.stream.StreamOutput;
    }
            ShardId shardId,
import java.util.concurrent.TimeUnit;
        }
        ClusterService clusterService
public class TransportNodesListShardStoreMetadataHelper {
                + ", syncId="
        public StoreFilesMetadata(
                + metadataSnapshot.getSyncId()
 * The OpenSearch Contributors require contributions made to
        public boolean isEmpty() {
                }
            // we refresh shard info after the primary has started. Hence, we can ignore retention leases if there is no active shard.
        logger.trace("listing store meta data for {}", shardId);
                            shardId,
                        throw new OpenSearchException(INDEX_NOT_FOUND + shardId.getIndex());
        }
import java.util.Collections;
            this.peerRecoveryRetentionLeases = in.readList(RetentionLease::new);
import org.opensearch.index.seqno.ReplicationTracker;
        public StoreFilesMetadata(StreamInput in) throws IOException {
     * @opensearch.internal
                        logger.warn(new ParameterizedMessage("[{}] can't read metadata from store, responding with empty", shardId), e);
                logger.debug("{} loaded store meta data (took [{}])", shardId, took);
                .findFirst()
            out.writeList(peerRecoveryRetentionLeases);
        private final List<RetentionLease> peerRecoveryRetentionLeases;
            IndexService indexService = indicesService.indexService(shardId.getIndex());
            return metadataSnapshot.iterator();
            }
                        return new StoreFilesMetadata(shardId, Store.MetadataSnapshot.EMPTY, Collections.emptyList());
     * Metadata for store files
 * SPDX-License-Identifier: Apache-2.0
            this.metadataSnapshot = new Store.MetadataSnapshot(in);
                if (indexService != null) {
 *
        private final Store.MetadataSnapshot metadataSnapshot;
 *
 * @opensearch.internal
        public void writeTo(StreamOutput out) throws IOException {
                // Remove this once request.getCustomDataPath() always returns non-null
            }
 * This class should not be used to add more functions and will be removed when the
        }
                }
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.core.common.io.stream.Writeable;
            List<RetentionLease> peerRecoveryRetentionLeases
            // 2) A shard is shutting down and has not cleared it's content within lock timeout. In this case the cluster-manager may not
            if (exists) {
                    IndexMetadata metadata = clusterService.state().metadata().index(shardId.getIndex());
    /**
 */
                nodeEnv::shardLock,
 * this file be licensed under the Apache-2.0 license or a
            return metadataSnapshot.getSyncId();
