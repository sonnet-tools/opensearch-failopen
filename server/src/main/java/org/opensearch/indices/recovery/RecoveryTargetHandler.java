 * this file be licensed under the Apache-2.0 license or a
    /**
     * @param retentionLeases                     the retention leases on the primary  
 * ownership. Elasticsearch licenses this file to you under  
        List<Long> phase1ExistingFileSizes,
    );
        int totalTranslogOps,
/**
        ActionListener<Long> listener
import org.opensearch.index.seqno.ReplicationTracker;
        RetentionLeases retentionLeases,
     *                         from the previous primary terms.  
 * compatible open source license.
     * Prepares the target to receive translog operations, after all file have been copied
 * this work for additional information regarding copyright
     *                                            the primary shard when capturing these operations. This value is at least as high as the
     * @param primaryContext the primary context from the relocation source
 * The OpenSearch Contributors require contributions made to  
        List<Long> phase1FileSizes,  
     *
     * @param totalTranslogOps                    current number of total operations expected to be indexed
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Notifies the target of the files it is going to receive
 * not use this file except in compliance with the License.
/*  
 * GitHub history for details.
        int totalTranslogOps,  
import org.opensearch.index.seqno.RetentionLeases;
     */
     * @param mappingVersionOnPrimary             the mapping version which is at least as up to date as the mapping version that the
 * @opensearch.internal
 */  
     * @param globalCheckpoint the global checkpoint on the recovery source
 * Unless required by applicable law or agreed to in writing,
    /**
     * files that are not part of the source store  
        long maxSeqNoOfUpdatesOrDeletesOnPrimary,
     *
     * the global checkpoint.
import java.util.List;  
     * @param listener         the listener which will be notified when this method is completed
 * Modifications Copyright OpenSearch Contributors. See  
    /**  
 * Handler for the recovery target  
     * The finalize request refreshes the engine now that new segments are available, enables garbage collection of tombstone files, updates
 * under the License.  
    void receiveFileInfo(
     * @param globalCheckpoint the global checkpoint on the primary  
    void cleanFiles(int totalTranslogOps, long globalCheckpoint, Store.MetadataSnapshot sourceMetadata, ActionListener<Void> listener);  
     * After all source files has been sent over, this command is sent to the target so it can clean any local
    void forceSegmentFileSync();
 * KIND, either express or implied.  See the License for the
     *                                            after these operations are successfully indexed on the target.
     */
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.indices.recovery;
}  
 * license agreements. See the NOTICE file distributed with
     *  
        List<Translog.Operation> operations,
    /**
 * Licensed to Elasticsearch under one or more contributor  
        List<String> phase1FileNames,
    default void cancel() {}
        List<String> phase1ExistingFileNames,
     *                                            new mapping then retry.
     */
 *
     *                                            primary used to index translog {@code operations} in this request.
 * software distributed under the License is distributed on an
     * conflict with replicas when target is promoted as primary.
     * @param sourceMetadata   meta data of the source store
 */
     */  
import org.opensearch.index.translog.Translog;
     * <p>  
     *
    void finalizeRecovery(long globalCheckpoint, long trimAboveSeqNo, ActionListener<Void> listener);  
     * @param listener                            a listener which will be notified with the local checkpoint on the target  
 */  
     * @param operations                          operations to index  
     * @param maxSeqNoOfUpdatesOrDeletesOnPrimary the max seq_no of update operations (index operations overwrite Lucene) or delete ops on  
    void indexTranslogOperations(  
     *                                            If the mapping version on the replica is not older this version, we should not retry on  
     */
        long mappingVersionOnPrimary,  
     *
     *                                            max_seq_no_of_updates on the primary was when any of these ops were processed on it.
     * Handoff the primary context between the relocation source and the relocation target.  
     */  
     * Index a set of translog operations on the target
 * You may obtain a copy of the License at  
import org.opensearch.index.store.Store;  
        ActionListener<Void> listener
    /**  
 *  
public interface RecoveryTargetHandler extends FileChunkWriter {
     * @param totalTranslogOps  total translog operations expected to be sent  
        long maxSeenAutoIdTimestampOnPrimary,  
/*
/*
    void handoffPrimaryContext(ReplicationTracker.PrimaryContext primaryContext);
 */
    /**
     * This function is used to force a sync target primary node with source (old primary). This is to avoid segment files
import org.opensearch.core.action.ActionListener;  
     * @param totalTranslogOps an update number of translog operations that will be replayed later on
 *    http://www.apache.org/licenses/LICENSE-2.0
    );
     * @param maxSeenAutoIdTimestampOnPrimary     the maximum auto_id_timestamp of all append-only requests processed by the primary shard
     * Used with Segment replication only
     */  
     *                                            {@link org.opensearch.index.mapper.MapperException}; otherwise we should wait for a
    void prepareForTranslogOperations(int totalTranslogOps, ActionListener<Void> listener);
 *
 * specific language governing permissions and limitations
    /**  
     * @param trimAboveSeqNo   The recovery target should erase its existing translog above this sequence number
 * SPDX-License-Identifier: Apache-2.0
 *
