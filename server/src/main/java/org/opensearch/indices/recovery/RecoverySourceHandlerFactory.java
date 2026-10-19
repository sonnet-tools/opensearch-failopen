                recoverySettings.getMaxConcurrentOperations()  
                shard.getThreadPool(),
}
 * SPDX-License-Identifier: Apache-2.0
 *
                request,
                shard,
                Math.toIntExact(recoverySettings.getChunkSize().getBytes()),
 * Factory that supplies {@link RecoverySourceHandler}.
                Math.toIntExact(recoverySettings.getChunkSize().getBytes()),  
    ) {  
            );  
        IndexShard shard,
                recoverySettings.getMaxConcurrentFileChunks(),
                recoveryTarget,  
                shard,  
        RecoveryTargetHandler recoveryTarget,  
        if (isReplicaRecoveryWithRemoteTranslog) {  
        StartRecoveryRequest request,
            );
        boolean isReplicaRecoveryWithRemoteTranslog = request.isPrimaryRelocation() == false
        } else {
/**  
 * compatible open source license.
    public static RecoverySourceHandler create(
public class RecoverySourceHandlerFactory {
package org.opensearch.indices.recovery;
    }  
 */  
 * The OpenSearch Contributors require contributions made to  
            return new RemoteStorePeerRecoverySourceHandler(
                request,  
 * @opensearch.internal  
                recoveryTarget,
 * this file be licensed under the Apache-2.0 license or a
 *
            && request.targetNode().isRemoteTranslogStoreNode();
                recoverySettings.getMaxConcurrentFileChunks(),
import org.opensearch.index.shard.IndexShard;
 */
        RecoverySettings recoverySettings
        }
                recoverySettings.getMaxConcurrentOperations()
                shard.getThreadPool(),
/*  
            return new LocalStorePeerRecoverySourceHandler(
