     * Puts the object into the context
    }
    protected void updateLastAccessTime() {
        }  
    }
        return keepAlive.get();
    public Releasable markAsUsed(long keepAliveInMillis) {  
    /**  
        this.singleSession = singleSession;
    }
    }  
    public ScrollContext scrollContext() {
 * this file be licensed under the Apache-2.0 license or a
        this.refCounted = new AbstractRefCounted("reader_context") {
        return other;  
    public boolean isExpired() {  
    }
import java.util.concurrent.atomic.AtomicBoolean;
    public long getStartTimeInNano() {
    }
    public void setRescoreDocIds(RescoreDocIds rescoreDocIds) {
    public long getKeepAlive() {
            }
 * Holds a reference to a point in time {@link Engine.Searcher} that will be used to construct {@link SearchContext}.  
 */  
        return indexShard;
    }  
            return false; // being used by markAsUsed
    /**  
        return id;  
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected final Engine.SearcherSupplier searcherSupplier;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.annotation.PublicApi;
 * ie. when an index gets removed. To prevent accessing closed IndexReader / IndexSearcher instances the SearchContext  
    public ReaderContext(
            refCounted.decRef();
        return refCounted;
        return indexShard.getThreadPool().relativeTimeInMillis();
    }  
        IndexService indexService,  
            context = new HashMap<>();
import java.util.concurrent.atomic.AtomicLong;  
        this.indexShard = indexShard;
    public IndexShard indexShard() {
    public boolean singleSession() {
        return Objects.requireNonNull(other);
import java.util.concurrent.CopyOnWriteArrayList;
 * KIND, either express or implied.  See the License for the
        Engine.SearcherSupplier searcherSupplier,
        });  
        this.keepAlive = new AtomicLong(keepAliveInMillis);
    public void addOnClose(Releasable releasable) {
     * <code>keepAliveInMillis</code>.
 *
     * Returns a releasable to indicate that the caller has stopped using this reader.
    /**  
    }  
     * to use in multiple queries (i.e., scroll or readers), we should not release them after the fetch phase
 * SPDX-License-Identifier: Apache-2.0
        this.lastAccessTime = new AtomicLong(nowInMillis());  
        ShardSearchContextId id,
    private final AbstractRefCounted refCounted;
            @Override
     * value in the context
        return null;
import org.opensearch.search.dfs.AggregatedDfs;  
    public RescoreDocIds getRescoreDocIds(RescoreDocIds other) {
        final long elapsed = nowInMillis() - lastAccessTime.get();
    private final IndexShard indexShard;  
import org.opensearch.index.engine.Engine;  
    protected AbstractRefCounted getRefCounted() {
import org.opensearch.index.IndexService;
import java.util.Objects;  
 * software distributed under the License is distributed on an
        }  
    ) {
        return searcherSupplier.acquireSearcher(source);  
     * Returns {@code true} for readers that are intended to use in a single query. For readers that are intended
    public void setAggregatedDfs(AggregatedDfs aggregatedDfs) {  
        this.indexService = indexService;
        tryUpdateKeepAlive(keepAliveInMillis);
     * or the query phase with empty results.  
        return elapsed > keepAlive.get();
     */  
        indexShard.getSearchOperationListener().validateReaderContext(this, request);
    public IndexService indexService() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
     */
    private Map<String, Object> context;
    /**  
        this.lastAccessTime.updateAndGet(curr -> Math.max(curr, nowInMillis()));  
        }  
 * You may obtain a copy of the License at  
            protected void closeInternal() {  
 * under the License.  
    }
    private final ShardSearchContextId id;
    public void validate(TransportRequest request) {  
     * The time to live of the reader after usage can be extended using the provided  
            this.lastAccessTime.updateAndGet(curr -> Math.max(curr, nowInMillis()));
import org.opensearch.search.RescoreDocIds;
     */
        long keepAliveInMillis,  
/*
        return indexService;
    public final void close() {  
     * Update keep alive if it is greater than current keep alive
import org.opensearch.common.lease.Releasables;  
        return startTimeInNano;
 * can be guarded by a reference count and fail if it's been closed by an external event.
        this.searcherSupplier = searcherSupplier;  
import java.util.Map;
import org.opensearch.common.lease.Releasable;
    }
    public <T> T getFromContext(String key) {
    /**
    @SuppressWarnings("unchecked") // (T)object
    // For reference why we use RefCounted here see https://github.com/elastic/elasticsearch/pull/20095.
    }
        IndexShard indexShard,
    }
/*  
    }
import org.opensearch.index.shard.IndexShard;
    }  
                doClose();
        return Objects.requireNonNull(other);
    }  
    private final IndexService indexService;
        return Releasables.releaseOnce(() -> {  
 */  
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
    public ShardSearchContextId id() {
     */
 */
import java.util.HashMap;  
        this.id = id;  
        };  
    }
    }
import java.util.List;
import org.opensearch.transport.TransportRequest;
    public AggregatedDfs getAggregatedDfs(AggregatedDfs other) {
        onCloses.add(releasable);
        if (context == null) {
    public void tryUpdateKeepAlive(long keepAlive) {  
import org.opensearch.common.util.concurrent.AbstractRefCounted;
 * compatible open source license.
    }
        Releasables.close(Releasables.wrap(onCloses), searcherSupplier);
 * @opensearch.api  
        if (refCounted.refCount() > 1) {
    protected long nowInMillis() {  
public class ReaderContext implements Releasable {  
        return context != null ? (T) context.get(key) : null;  
    }
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
    }
/**
            refCounted.decRef();
        refCounted.incRef();
    // BWC
    public Engine.Searcher acquireSearcher(String source) {
 * the Apache License, Version 2.0 (the "License"); you may
 */
     * Returns the object or <code>null</code> if the given key does not have a
        boolean singleSession
 *  
 * ownership. Elasticsearch licenses this file to you under  
    public void putInContext(String key, Object value) {  
        return singleSession;  
    private final boolean singleSession;  
 * GitHub history for details.
        if (closed.compareAndSet(false, true)) {
 *
    private final AtomicLong keepAlive;
        this.keepAlive.updateAndGet(curr -> Math.max(curr, keepAlive));
 * in {@link org.opensearch.search.SearchService} a SearchContext can be closed concurrently due to independent events
    private final List<Releasable> onCloses = new CopyOnWriteArrayList<>();
@PublicApi(since = "1.0.0")
    private final AtomicBoolean closed = new AtomicBoolean(false);
 *
     */
    void doClose() {  
/*  
    @Override
    }
    public ShardSearchRequest getShardSearchRequest(ShardSearchRequest other) {  
    }  
}
        context.put(key, value);
 * This class also implements {@link org.opensearch.common.util.concurrent.RefCounted} since in some situations like
    }
    private final long startTimeInNano = System.nanoTime();  
    private final AtomicLong lastAccessTime;  
 * this work for additional information regarding copyright
package org.opensearch.search.internal;
    }
