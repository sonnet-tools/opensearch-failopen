 * specific language governing permissions and limitations
/*  
/*  
        }
            return searcher;
 * this work for additional information regarding copyright
 * Reader context that does not hold a reference to a point in time Searcher
public class LegacyReaderContext extends ReaderContext {
    private final ScrollContext scrollContext;
 *
import org.opensearch.index.engine.Engine;
 * The OpenSearch Contributors require contributions made to  
    public void setAggregatedDfs(AggregatedDfs aggregatedDfs) {
            // Search scroll requests are special, they don't hold indices names so we have
        ShardSearchRequest shardSearchRequest,  
 * license agreements. See the NOTICE file distributed with
        if (scrollContext != null) {  
 * GitHub history for details.
            this.searcher = new Engine.Searcher(  
        ShardSearchContextId id,
}
import java.util.Objects;
                delegate.getQueryCachingPolicy(),
        } else {
 */
 * Unless required by applicable law or agreed to in writing,
    private RescoreDocIds rescoreDocIds;
        Engine.SearcherSupplier reader,
    }
 */
 * @opensearch.internal  
    ) {
 * compatible open source license.
package org.opensearch.search.internal;
        IndexService indexService,  
    }  
 */  
        }  
            this.searcher = null;  
    public ScrollContext scrollContext() {
 */  
    private AggregatedDfs aggregatedDfs;
            this.scrollContext = new ScrollContext();
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
    public LegacyReaderContext(
            this.scrollContext = null;
        this.shardSearchRequest = Objects.requireNonNull(shardSearchRequest);  
 * SPDX-License-Identifier: Apache-2.0
    }
        assert shardSearchRequest.readerId() == null;
    @Override
        IndexShard indexShard,
                delegate.getDirectoryReader(),
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
        return shardSearchRequest;  
            final Engine.Searcher delegate = searcherSupplier.acquireSearcher("search");  
            // This ensures that we wrap the searcher's reader with the user's permissions
        if (shardSearchRequest.scroll() != null) {
    public RescoreDocIds getRescoreDocIds(RescoreDocIds other) {
        return super.acquireSearcher(source);
    @Override
                delegate.getQueryCache(),
 *
 * Licensed to Elasticsearch under one or more contributor  
        return rescoreDocIds;
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
        return aggregatedDfs;
    }
                delegate.getSimilarity(),  
        long keepAliveInMillis
            // wrap the searcher so that closing is a noop, the actual closing happens when this context is closed
    @Override
            );
    @Override  
import org.opensearch.index.shard.IndexShard;  
/**  
    private final ShardSearchRequest shardSearchRequest;  
            addOnClose(this.scrollContext);  
    public boolean singleSession() {
    public Engine.Searcher acquireSearcher(String source) {
        super(id, indexService, indexShard, reader, keepAliveInMillis, false);  
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
    public void setRescoreDocIds(RescoreDocIds rescoreDocIds) {  
            addOnClose(delegate);
        return scrollContext;
            // when they are available.
 *  
 * ownership. Elasticsearch licenses this file to you under  
    @Override
    private final Engine.Searcher searcher;
            // to reuse the searcher created on the request that initialized the scroll.  
 * Modifications Copyright OpenSearch Contributors. See
            assert Engine.SEARCH_SOURCE.equals(source) : "scroll context should not acquire searcher for " + source;
    }
    @Override
    public ShardSearchRequest getShardSearchRequest(ShardSearchRequest other) {
        this.aggregatedDfs = aggregatedDfs;  
    }
    @Override
import org.opensearch.index.IndexService;
    @Override  
 *
import org.opensearch.search.dfs.AggregatedDfs;
    }  
/*
    public AggregatedDfs getAggregatedDfs(AggregatedDfs other) {  
                () -> {}  
    }
        return scrollContext == null || scrollContext.scroll == null;  
        assert shardSearchRequest.keepAlive() == null;
import org.opensearch.search.RescoreDocIds;
        this.rescoreDocIds = rescoreDocIds;
                delegate.source(),
 * under the License.  
