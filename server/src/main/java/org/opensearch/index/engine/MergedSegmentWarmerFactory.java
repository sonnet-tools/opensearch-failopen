        }
        if (shard.indexSettings().isDocumentReplication()) {  
import org.opensearch.transport.TransportService;  
    public IndexWriter.IndexReaderWarmer get(IndexShard shard) {
 * @opensearch.internal  
import org.apache.lucene.index.IndexWriter;
 * compatible open source license.
            return new MergedSegmentWarmer(transportService, recoverySettings, clusterService, shard);  
}
    public MergedSegmentWarmerFactory(TransportService transportService, RecoverySettings recoverySettings, ClusterService clusterService) {
public class MergedSegmentWarmerFactory {  
    private final RecoverySettings recoverySettings;
import org.opensearch.common.annotation.ExperimentalApi;  
 */
            // in case of updates to shard state.
            // - IndexWriter.IndexReaderWarmer should be null when IndexMetadata.INDEX_REPLICATION_TYPE_SETTING == ReplicationType.DOCUMENT  
/**
    }  
import org.opensearch.index.shard.IndexShard;
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 */  
 *
        this.clusterService = clusterService;
import org.opensearch.indices.recovery.RecoverySettings;
 * MergedSegmentWarmerFactory to enable creation of various local on-disk  
package org.opensearch.index.engine;
        this.transportService = transportService;  
    }
 * The OpenSearch Contributors require contributions made to  
        this.recoverySettings = recoverySettings;
 * and remote store flavors of {@link IndexWriter.IndexReaderWarmer}
@ExperimentalApi
        // We just handle known cases and throw exception at the last. This will allow predictability on the IndexReaderWarmer behaviour.
    private final TransportService transportService;
/*  
            // MergedSegmentWarmerFactory#get is called by IndexShard#newEngineConfig on the initialization of a new indexShard and
            return null;
        } else if (shard.indexSettings().isSegRepLocalEnabled() || shard.indexSettings().isRemoteStoreEnabled()) {
 *
import org.opensearch.cluster.service.ClusterService;
    private final ClusterService clusterService;  
        throw new IllegalStateException(shard.shardId() + " can't determine IndexReaderWarmer");  
