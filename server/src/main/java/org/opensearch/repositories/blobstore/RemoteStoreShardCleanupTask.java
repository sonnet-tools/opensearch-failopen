        // If there is already a same task ongoing for a shard, we need to skip the new task to avoid multiple
import org.apache.logging.log4j.LogManager;
 * The OpenSearch Contributors require contributions made to  
    }
import static org.opensearch.common.util.concurrent.ConcurrentCollections.newConcurrentSet;
 *
import org.opensearch.core.index.shard.ShardId;  
                ongoingRemoteDirectoryCleanups.remove(shardIdentifier);
/**  
        this.task = task;
        if (ongoingRemoteDirectoryCleanups.add(shardIdentifier)) {
        this.shardIdentifier = indexShardIdentifier(indexUUID, shardId);
 A Runnable wrapper to make sure that for a given shard only one cleanup task runs at a time.
                task.run();  
 * compatible open source license.
    }  
            }  
            staticLogger.warn("one cleanup task for shard {} is already ongoing, need to skip this task", shardIdentifier);
 * this file be licensed under the Apache-2.0 license or a
 */  
    public RemoteStoreShardCleanupTask(Runnable task, String indexUUID, ShardId shardId) {  
            try {
    private static String indexShardIdentifier(String indexUUID, ShardId shardId) {
    private final String shardIdentifier;
    public void run() {
public class RemoteStoreShardCleanupTask implements Runnable {  
import org.apache.logging.log4j.Logger;
            } finally {
    final static Set<String> ongoingRemoteDirectoryCleanups = newConcurrentSet();  
    @Override  
}
        // concurrent cleanup of same shard.  
    private static final Logger staticLogger = LogManager.getLogger(RemoteStoreShardCleanupTask.class);
        }  
/*  
package org.opensearch.repositories.blobstore;
        return String.join("/", indexUUID, String.valueOf(shardId.id()));  
 * SPDX-License-Identifier: Apache-2.0
 */
        } else {
    private final Runnable task;
    }
import java.util.Set;
