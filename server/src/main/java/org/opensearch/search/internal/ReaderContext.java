        onCloses.add(releasable);
    }
        this.searcherSupplier = searcherSupplier;
import org.opensearch.index.engine.Engine;
        this.lastAccessTime.updateAndGet(curr -> Math.max(curr, nowInMillis()));
    public AggregatedDfs getAggregatedDfs(AggregatedDfs other) {
     * or the query phase with empty results.
 */
public class ReaderContext implements Releasable {
    /**
        boolean singleSession
        IndexService indexService,
    }
    private final AtomicLong lastAccessTime;
/*
 * This class also implements {@link org.opensearch.common.util.concurrent.RefCounted} since in some situations like
import org.opensearch.common.annotation.PublicApi;
    public IndexShard indexShard() {
 */
    }
    }
        if (context == null) {
        this.keepAlive = new AtomicLong(keepAliveInMillis);
    public void setAggregatedDfs(AggregatedDfs aggregatedDfs) {
    private final AtomicBoolean closed = new AtomicBoolean(false);
    @SuppressWarnings("unchecked") // (T)object
    }
        if (refCounted.refCount() > 1) {
    }
        this.id = id;
    public void validate(TransportRequest request) {
    public <T> T getFromContext(String key) {
    /**
import java.util.List;
    protected long nowInMillis() {
     * Returns a releasable to indicate that the caller has stopped using this reader.
        this.indexShard = indexShard;
import java.util.HashMap;
        refCounted.incRef();
        return id;
    private final IndexShard indexShard;
    // For reference why we use RefCounted here see https://github.com/elastic/elasticsearch/pull/20095.
    public boolean isExpired() {
 *
    public Engine.Searcher acquireSearcher(String source) {
import java.util.concurrent.CopyOnWriteArrayList;
import org.opensearch.search.dfs.AggregatedDfs;
    }
            }
 *
package org.opensearch.search.internal;
    }
    }
     */
    protected void updateLastAccessTime() {
 */
 * Licensed to Elasticsearch under one or more contributor
     * to use in multiple queries (i.e., scroll or readers), we should not release them after the fetch phase
 */
        this.singleSession = singleSession;
 * in {@link org.opensearch.search.SearchService} a SearchContext can be closed concurrently due to independent events
    }
     * The time to live of the reader after usage can be extended using the provided
            context = new HashMap<>();
@PublicApi(since = "1.0.0")
     * value in the context
        }
        Releasables.close(Releasables.wrap(onCloses), searcherSupplier);
        }
        final long elapsed = nowInMillis() - lastAccessTime.get();
    public Releasable markAsUsed(long keepAliveInMillis) {
import org.opensearch.common.lease.Releasable;
        return singleSession;
        return context != null ? (T) context.get(key) : null;
    }
        this.indexService = indexService;
        return Releasables.releaseOnce(() -> {
     */
 * ie. when an index gets removed. To prevent accessing closed IndexReader / IndexSearcher instances the SearchContext
    private final AbstractRefCounted refCounted;
        return startTimeInNano;
            @Override
    }
}
     * Returns {@code true} for readers that are intended to use in a single query. For readers that are intended
    }
        return Objects.requireNonNull(other);
 * this work for additional information regarding copyright
 *
 * can be guarded by a reference count and fail if it's been closed by an external event.
        return refCounted;
    }
    }
    }
/*
    /**
        return indexShard.getThreadPool().relativeTimeInMillis();
import org.opensearch.common.lease.Releasables;
        return elapsed > keepAlive.get();
    @Override
        tryUpdateKeepAlive(keepAliveInMillis);
    public ScrollContext scrollContext() {
    }
     */
            protected void closeInternal() {
    public ShardSearchContextId id() {
 * Holds a reference to a point in time {@link Engine.Searcher} that will be used to construct {@link SearchContext}.
    private final IndexService indexService;
    public long getKeepAlive() {
        return searcherSupplier.acquireSearcher(source);
    private final long startTimeInNano = System.nanoTime();
 * Modifications Copyright OpenSearch Contributors. See
    }
    public final void close() {
        return indexShard;
        this.keepAlive.updateAndGet(curr -> Math.max(curr, keepAlive));
    }
     */
 * compatible open source license.
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under
            this.lastAccessTime.updateAndGet(curr -> Math.max(curr, nowInMillis()));
 * SPDX-License-Identifier: Apache-2.0
        this.lastAccessTime = new AtomicLong(nowInMillis());
            refCounted.decRef();
        return other;
    }
    protected AbstractRefCounted getRefCounted() {
    public IndexService indexService() {
 * not use this file except in compliance with the License.
import org.opensearch.common.util.concurrent.AbstractRefCounted;
        if (closed.compareAndSet(false, true)) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        };
    /**
    public ReaderContext(
    public long getStartTimeInNano() {
 * software distributed under the License is distributed on an
    }
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
    }
    private final AtomicLong keepAlive;
 * You may obtain a copy of the License at
 * this file be licensed under the Apache-2.0 license or a
import java.util.concurrent.atomic.AtomicLong;
        return null;
import java.util.concurrent.atomic.AtomicBoolean;
    // BWC
    public ShardSearchRequest getShardSearchRequest(ShardSearchRequest other) {
    public void setRescoreDocIds(RescoreDocIds rescoreDocIds) {
    private final List<Releasable> onCloses = new CopyOnWriteArrayList<>();
        long keepAliveInMillis,
/**
    public void tryUpdateKeepAlive(long keepAlive) {
        return keepAlive.get();
 * specific language governing permissions and limitations
     * Puts the object into the context
 * under the License.
        return indexService;
    public boolean singleSession() {
            return false; // being used by markAsUsed
        this.refCounted = new AbstractRefCounted("reader_context") {
        Engine.SearcherSupplier searcherSupplier,
        return Objects.requireNonNull(other);
    }
 * @opensearch.api
                doClose();
    public void addOnClose(Releasable releasable) {
    public void putInContext(String key, Object value) {
import org.opensearch.index.shard.IndexShard;
    /**
        indexShard.getSearchOperationListener().validateReaderContext(this, request);
    void doClose() {
/*
     * <code>keepAliveInMillis</code>.
            refCounted.decRef();
    private Map<String, Object> context;
    }
 * Unless required by applicable law or agreed to in writing,
import java.util.Map;
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.index.IndexService;
    }
        }
 * The OpenSearch Contributors require contributions made to
        ShardSearchContextId id,
     * Update keep alive if it is greater than current keep alive
    private final boolean singleSession;
 * the Apache License, Version 2.0 (the "License"); you may
        context.put(key, value);
     * Returns the object or <code>null</code> if the given key does not have a
    ) {
import java.util.Objects;
     */
import org.opensearch.transport.TransportRequest;
    public RescoreDocIds getRescoreDocIds(RescoreDocIds other) {
 *
    protected final Engine.SearcherSupplier searcherSupplier;
    }
    private final ShardSearchContextId id;
import org.opensearch.search.RescoreDocIds;
        });
        IndexShard indexShard,
