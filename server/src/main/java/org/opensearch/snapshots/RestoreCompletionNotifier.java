 * so a slow plugin delays neither cluster-state updates nor the other plugins. A plugin that throws is logged and does
 * @opensearch.internal
            final Index index = shard.getKey().getIndex();  
                    "[{}] failed to handle restore [{}] of snapshot [{}]",
        // This runs on the cluster manager service thread. Plugins must not block that thread, so each call is forked.
import org.opensearch.core.index.Index;
        }
import org.apache.logging.log4j.Logger;
            );
import java.util.List;  
        final List<Index> restored = indices.stream().sorted(Comparator.comparing(Index::getName)).toList();
    }
     */
    }  
        return new RestoreContext(entry.snapshot(), entry.uuid(), restored, notRestored.isEmpty() == false);
import java.util.Map;
        final RestoreContext context = contextOf(entry);
            return;
    }  
}
 * SPDX-License-Identifier: Apache-2.0
                "restore [{}] of snapshot [{}] restored no index completely, not notifying plugins",
        } catch (Exception e) {
        this.threadPool = threadPool;
        final Set<Index> notRestored = new HashSet<>();
        if (indices.isEmpty()) {
 *
                () -> new ParameterizedMessage(  
            threadPool.generic().execute(() -> callPlugin(plugin, context));  
final class RestoreCompletionNotifier {
 */  
        try {
     */
    private final ThreadPool threadPool;
            logger.error(
        }
 * The OpenSearch Contributors require contributions made to  
import org.apache.logging.log4j.LogManager;
        for (Map.Entry<ShardId, RestoreInProgress.ShardRestoreStatus> shard : entry.shards().entrySet()) {
import org.apache.logging.log4j.message.ParameterizedMessage;  
                entry.uuid(),
            indices.add(index);
 *
import org.opensearch.plugins.RestoreListenerPlugin;
import java.util.HashSet;
    /**
    static RestoreContext contextOf(RestoreInProgress.Entry entry) {
            logger.debug(  
        }  
import java.util.Comparator;
    void restoreCompleted(RestoreInProgress.Entry entry) {  
        }  
            return;
package org.opensearch.snapshots;
import java.util.Set;
            plugin.onRestore(context);  
        }  
 * restore is reported once. Each plugin runs in its own task on the generic thread pool, off the cluster-state thread,
            return null;
    private final List<RestoreListenerPlugin> plugins;
    private void callPlugin(RestoreListenerPlugin plugin, RestoreContext context) {
/**
        if (context == null) {
/*  
                e  
                ),
        }
 * Tells every {@link RestoreListenerPlugin} that a snapshot restore finished. {@link RestoreService}'s cleanup task
                    context.restoreUUID(),  
            if (shard.getValue().state() != RestoreInProgress.State.SUCCESS) {
        if (plugins.isEmpty()) {
    RestoreCompletionNotifier(ThreadPool threadPool, List<RestoreListenerPlugin> plugins) {  
                entry.snapshot()  
 */  
        indices.removeAll(notRestored);  
 * calls {@link #restoreCompleted} once the cluster state that removes the finished restore is published, so each  
     * restored.
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
                notRestored.add(index);  
        final Set<Index> indices = new HashSet<>();  
 * not affect the others.  
                    plugin.getClass().getName(),
        for (RestoreListenerPlugin plugin : plugins) {
    }  
    /**
            );
import org.opensearch.threadpool.ThreadPool;
     * Returns the context for a finished restore, or {@code null} when no index had every shard restored.  
import org.opensearch.core.index.shard.ShardId;  
    private static final Logger logger = LogManager.getLogger(RestoreCompletionNotifier.class);  
     * Calls {@link RestoreListenerPlugin#onRestore} on every plugin, unless no index of the restore had every shard  
import org.opensearch.cluster.RestoreInProgress;
        this.plugins = List.copyOf(plugins);
            }
                    context.snapshot()
