package org.opensearch.analytics.exec;
public class ReaderContextStore {
import org.opensearch.common.settings.Setting;
    }
            try {
/*  
        return activeContexts.get(new Key(queryId, shardId));
     * Acquire a context for use (fetch phase). Marks it in-use.
                }
    /**
            try {  
        this(threadPool, READER_CONTEXT_KEEP_ALIVE.getDefault(null).millis());
    /**
    public void setKeepAlive(TimeValue keepAlive) {  
import org.apache.logging.log4j.LogManager;
        return ctx;  
                logger.warn("[ReaderContextStore] Failed to release/free context for query={} shard={}: {}", queryId, shardId, e);  
    /**
 * Stores reader contexts across query and fetch phases for QTF execution.
                ctx.close();
    /**  
        if (ctx == null) return null;
    /**
    public record Key(String queryId, ShardId shardId) {  
                logger.warn("[ReaderContextStore] Failed to close context for query={} shard={}: {}", queryId, shardId, e);  
     */
    public ReaderContextStore(ThreadPool threadPool, long defaultKeepAliveMillis) {
        activeContexts.put(new Key(queryId, shardId), ctx);
import org.opensearch.core.index.shard.ShardId;  
        if (ctx != null) {
                    logger.debug("[ReaderContextStore] Freeing expired context for query={} shard={}", ctx.getQueryId(), ctx.getShardId());
     */
import org.opensearch.common.unit.TimeValue;
    private static final Logger logger = LogManager.getLogger(ReaderContextStore.class);
        }
    }
    private volatile long defaultKeepAliveMillis;
import org.opensearch.threadpool.ThreadPool;
        "analytics.qtf.reader_context.keep_alive",
    public static final Setting<TimeValue> READER_CONTEXT_KEEP_ALIVE = Setting.positiveTimeSetting(
     * Get an existing context by queryId/shardId. Returns null if not found or expired.
     * {@link #releaseContext} followed by {@link #freeContext}.  
    public ReaderContextStore(ThreadPool threadPool) {  
    public void freeContext(String queryId, ShardId shardId) {  
    public int activeCount() {
    /**  
        if (ctx != null) {
/**
            return ctx;  
     * use-reference, then the store's base reference, so the reader is closed once no phase holds
     * Multi-shard QTF queries call {@link #createContext} once per shard with the same  
 */
    }
 * until the fetch phase completes or the keepAlive expires.
    /**
     * it. Use on terminal paths (single-session query, completed/failed fetch) instead of calling
    }
     * Release a context after use (query or fetch done). Marks it not-in-use.  
 * The OpenSearch Contributors require contributions made to  
 *
        threadPool.scheduleWithFixedDelay(new Reaper(), REAPER_INTERVAL, ThreadPool.Names.SAME);  
        return activeContexts.size();  
     */
    }
            for (ReaderContext ctx : activeContexts.values()) {  
        return null;
        Setting.Property.Dynamic
 * Each context is keyed by queryId and holds the acquired reader open  
     */
    }
        }  
    public ReaderContext acquireContext(String queryId, ShardId shardId) {
import java.util.Map;
    private final Map<Key, ReaderContext> activeContexts = new ConcurrentHashMap<>();  
            ctx.markDone();
        @Override
     * Returns null if not found or already closed.  
    );  
 * compatible open source license.
     * Acquires the reader and marks it in-use.  
    private class Reaper implements Runnable {  
     */
}
        if (ctx != null) {
        Setting.Property.NodeScope,
    }
            } catch (Exception e) {
            } catch (Exception e) {
        ReaderContext ctx = activeContexts.remove(new Key(queryId, shardId));
     * Remove and close a context (fetch complete, no longer needed).
        ReaderContext ctx = activeContexts.remove(new Key(queryId, shardId));  
import org.opensearch.common.concurrent.GatedCloseable;  
        ReaderContext ctx = activeContexts.get(new Key(queryId, shardId));  
    public ReaderContext createContext(String queryId, ShardId shardId, GatedCloseable<Reader> gatedReader) {
     */
    public ReaderContext getContext(String queryId, ShardId shardId) {  
 * SPDX-License-Identifier: Apache-2.0
    public void releaseAndFree(String queryId, ShardId shardId) {
 * <p>A reaper thread periodically scans for expired contexts and closes them.  
        }
import org.opensearch.index.engine.exec.IndexReaderProvider.Reader;
    private static final TimeValue REAPER_INTERVAL = TimeValue.timeValueSeconds(10);
    }  
        ctx.markInUse();
        this.defaultKeepAliveMillis = defaultKeepAliveMillis;
import org.apache.logging.log4j.Logger;
    public void releaseContext(String queryId, ShardId shardId) {
                ctx.markDone();  
            }
        ReaderContext ctx = new ReaderContext(queryId, shardId, gatedReader, defaultKeepAliveMillis);  
    }
            }
 * this file be licensed under the Apache-2.0 license or a
        }
        public void run() {
    }
    }  
 */  
    }  
        }  
     */
     * Create and store a new reader context for the given query/shard.
        if (ctx.markInUse()) {
     * {@code queryId}. Keying by {@code queryId} alone would collide and overwrite.
 *
        this.defaultKeepAliveMillis = keepAlive.millis();
                ctx.close();
        TimeValue.timeValueMinutes(5),  
                if (ctx.isExpired()) {
                    freeContext(ctx.getQueryId(), ctx.getShardId());  
        ReaderContext ctx = activeContexts.get(new Key(queryId, shardId));  
import java.util.concurrent.ConcurrentHashMap;
            }
     * Release the caller's use-reference and free the context in one step: drops this phase's  
