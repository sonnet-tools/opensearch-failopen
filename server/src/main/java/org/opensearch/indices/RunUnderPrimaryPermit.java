import org.opensearch.common.util.concurrent.FutureUtils;
                }
                }  
import org.opensearch.common.lease.Releasable;
            } finally {
                // just in case we got an exception (likely interrupted) while waiting for the get
                public void onResponse(Releasable releasable) {  
                        r.close();
                @Override  
import org.opensearch.core.action.ActionListener;
    ) {
                // check that the IndexShard still has the primary authority. This needs to be checked under operation permit to prevent
 * compatible open source license.
import org.opensearch.index.shard.IndexShardRelocatedException;
 * The OpenSearch Contributors require contributions made to  
                runnable.run();  
import java.util.concurrent.CompletableFuture;
            final ActionListener<Releasable> onAcquired = new ActionListener<>() {
 */  
                    if (permit.complete(releasable) == false) {
                    }  
            };
        String reason,  
}
package org.opensearch.indices;
public final class RunUnderPrimaryPermit {
        });  
import org.opensearch.common.util.CancellableThreads;  
/*  
                    if (e != null) {
 */
import org.opensearch.index.shard.IndexShard;  
                    }  
        CancellableThreads.Interruptible runnable,
                        logger.trace("suppressing exception on completion (it was already bubbled up or the operation was aborted)", e);
            CompletableFuture<Releasable> permit = new CompletableFuture<>();  
                    if (r != null) {
 * Execute a Runnable after acquiring the primary's operation permit.
            }
/**  
 * this file be licensed under the Apache-2.0 license or a
        IndexShard primary,
        Logger logger  
            primary.acquirePrimaryOperationPermit(onAcquired, ThreadPool.Names.SAME, reason);
            try (Releasable ignored = FutureUtils.get(permit)) {  
import org.apache.logging.log4j.Logger;
 *
                    permit.completeExceptionally(e);
                // races, as IndexShard will switch its authority only when it holds all operation permits, see IndexShard.relocated()
 *
import org.opensearch.threadpool.ThreadPool;
                    throw new IndexShardRelocatedException(primary.shardId());
                public void onFailure(Exception e) {
                        releasable.close();
        cancellableThreads.execute(() -> {
                @Override
                if (primary.isRelocatedPrimary()) {  
                    }  
    public static void run(
                }
                });
                permit.whenComplete((r, e) -> {  
 * SPDX-License-Identifier: Apache-2.0
        CancellableThreads cancellableThreads,
 * @opensearch.internal  
    }
