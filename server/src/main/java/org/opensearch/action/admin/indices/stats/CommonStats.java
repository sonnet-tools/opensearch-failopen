    }
    @Nullable
        return completion;  
                case Segments:
                    break;  
 */
    public SegmentsStats getSegments() {
        }
                case Store:
        out.writeOptionalWriteable(search);
    }
                case Docs:
                    docs = new DocsStats();
    }
            }
                case Get:
        segments = in.readOptionalWriteable(SegmentsStats::new);
            } catch (AlreadyClosedException e) {  
                    case Recovery:  
        } else {  
                requestCache = new RequestCacheStats();
                        throw new IllegalStateException("Unknown Flag: " + flag);
                        break;
    @Nullable
    public SearchStats getSearch() {  
    }  
                recoveryStats = new RecoveryStats();
        if (store == null) {  
 * this file be licensed under the Apache-2.0 license or a
        }  
    public WarmerStats getWarmer() {
/**
                warmer,
import org.opensearch.index.shard.IndexingStats;
    public GetStats get;
                    search = new SearchStats();
            size += this.getQueryCache().getMemorySizeInBytes();  
    public SearchStats search;
                    flush = new FlushStats();
    }
import org.opensearch.index.warmer.WarmerStats;
/*
                case Translog:
    @Nullable
    @Nullable
}  
    @Nullable  
        if (docs == null) {
        if (requestCache == null) {  
                    break;  
        if (recoveryStats == null) {
import org.opensearch.index.engine.SegmentsStats;
        return builder;
        return refresh;
    public FieldDataStats fieldData;
                    case QueryCache:  
            if (stats.getIndexing() != null) {  
        if (search == null) {  
                // shard is closed - no stats is fine
    }
 */  
    public IndexingStats indexing;
                    refresh = new RefreshStats();
    }
                case FieldData:
                completion = new CompletionStats();
                    case Docs:  
                requestCache.add(stats.getRequestCache());  
                case Completion:
            if (stats.getCompletion() != null) {
            if (stats.getWarmer() != null) {  
        flush = in.readOptionalWriteable(FlushStats::new);
        translog = in.readOptionalWriteable(TranslogStats::new);
                    fieldData = new FieldDataStats();
                        indexing = indexShard.indexingStats();
                get.add(stats.getGet());
            queryCache.add(stats.getQueryCache());
        }  
 * Modifications Copyright OpenSearch Contributors. See
        indexing = in.readOptionalWriteable(IndexingStats::new);  
                    break;  
            if (stats.getFlush() != null) {
    public MergeStats merge;
                        warmer = indexShard.warmerStats();
                search.add(stats.getSearch());  
/*  
                case Flush:
 *  
                    case Merge:  
        } else {  
                    break;  
                    case Translog:  
    @Nullable  
                completion,
        return this.queryCache;
    @Nullable
                        break;
        } else {
    public CommonStats() {
        }
                segments.add(stats.getSegments());
 * the Apache License, Version 2.0 (the "License"); you may
                    case Store:  
        }
 * GitHub history for details.
    }
                store,  
                    break;  
    public StoreStats getStore() {  
    public CommonStats(StreamInput in) throws IOException {  
    @Nullable
    @Nullable
                docs,
        for (CommonStatsFlags.Flag flag : setFlags) {  
        completion = in.readOptionalWriteable(CompletionStats::new);  
    @Nullable  
            }
            try {
    public RecoveryStats recoveryStats;
 * not use this file except in compliance with the License.
import org.opensearch.index.shard.IndexShard;
    public RefreshStats refresh;
    public QueryCacheStats queryCache;
import java.util.Arrays;
                    merge = new MergeStats();
                        flush = indexShard.flushStats();
                merge.add(stats.getMerge());
        return translog;
    public FlushStats getFlush() {  
        }
                    recoveryStats = new RecoveryStats();
                    break;  
        } else {
    public WarmerStats warmer;
        } else {  
            }
        }
        if (flush == null) {  
        if (this.getFieldData() != null) {
        return flush;
        if (indexing == null) {
                    warmer = new WarmerStats();
                docs = new DocsStats();  
    }
 * under the License.  
            new ToXContent[] {
                case Indexing:
                        break;
                    break;  
import org.opensearch.index.cache.query.QueryCacheStats;
            if (stats.getRecoveryStats() != null) {  
        }
        }
public class CommonStats implements Writeable, ToXContentFragment {
 */  
    public CompletionStats completion;
import java.util.Objects;
            if (stats.getSearch() != null) {
                    break;  
 * software distributed under the License is distributed on an
import org.opensearch.index.flush.FlushStats;  
                        search = indexShard.searchStats(flags.groups());
                    case RequestCache:  
                    translog = new TranslogStats();
            if (stats.getGet() != null) {
                }
                    break;  
                        break;
        if (queryCache == null) {
 * Unless required by applicable law or agreed to in writing,
            if (stats.getRefresh() != null) {
        out.writeOptionalWriteable(docs);  
    @Nullable
@PublicApi(since = "1.0.0")
        if (refresh == null) {
        out.writeOptionalWriteable(refresh);  
import org.opensearch.indices.IndicesQueryCache;  
import org.opensearch.index.translog.TranslogStats;
 */  
            }  
            size += this.getSegments().getIndexWriterMemoryInBytes() + this.getSegments().getVersionMapMemoryInBytes();  
        if (segments == null) {
                        store = indexShard.storeStats();
                        break;
import org.opensearch.common.Nullable;
        warmer = in.readOptionalWriteable(WarmerStats::new);  
        }
            if (stats.getQueryCache() != null) {
                fieldData.add(stats.getFieldData());
            }
        CommonStatsFlags.Flag[] setFlags = flags.getFlags();
                    break;  
        out.writeOptionalWriteable(recoveryStats);  
                warmer.add(stats.getWarmer());
            flush.add(stats.getFlush());  
                    break;  
 * You may obtain a copy of the License at  
        out.writeOptionalWriteable(warmer);
     * Utility method which computes total memory by adding  
                get,
        CommonStatsFlags.Flag[] setFlags = flags.getFlags();  
                        recoveryStats = indexShard.recoveryStats();
            indexing.add(stats.getIndexing());
        } else {
    public RecoveryStats getRecoveryStats() {
    @Nullable
            if (stats.getMerge() != null) {  
     */
                fieldData,  
        for (CommonStatsFlags.Flag flag : setFlags) {
    public CommonStats(IndicesQueryCache indicesQueryCache, IndexShard indexShard, CommonStatsFlags flags) {
                    store = new StoreStats();
        return this.warmer;  
        merge = in.readOptionalWriteable(MergeStats::new);  
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
    }  
                merge = new MergeStats();
import org.opensearch.common.annotation.PublicApi;  
        } else {  
import org.opensearch.search.suggest.completion.CompletionStats;
import org.opensearch.index.cache.request.RequestCacheStats;  
        ).filter(Objects::nonNull);  
    @Nullable
        } else {
                default:
        return this.docs;
                        get = indexShard.getStats();
    }
        return merge;  
        fieldData = in.readOptionalWriteable(FieldDataStats::new);
    public void add(CommonStats stats) {  
            segments.add(stats.getSegments());
            get.add(stats.getGet());
            if (stats.getSegments() != null) {  
                    case Completion:  
    }  
    public CommonStats(CommonStatsFlags flags) {
    }  
 *
        return new ByteSizeValue(size);  
                        break;
    @Nullable
                        fieldData = indexShard.fieldDataStats(flags.fieldDataFields());
        if (completion == null) {  
        get = in.readOptionalWriteable(GetStats::new);
        }
        } else {
                case Merge:
package org.opensearch.action.admin.indices.stats;
 *     http://www.apache.org/licenses/LICENSE-2.0
                flush = new FlushStats();
    public IndexingStats getIndexing() {
    @Nullable  
        out.writeOptionalWriteable(fieldData);
                requestCache,
                merge,
            if (stats.getRequestCache() != null) {
                        break;
import org.opensearch.core.common.io.stream.Writeable;  
                    case Get:  
    @Nullable
            }
        }  
        }
    public TranslogStats translog;
 *
    // note, requires a wrapping object  
import org.opensearch.index.refresh.RefreshStats;
    public StoreStats store;
    @Nullable
        } else {
        return get;
        final Stream<ToXContent> stream = Arrays.stream(  
            merge.add(stats.getMerge());
    }
                        break;
    @Nullable
    @Override
 * specific language governing permissions and limitations
import org.opensearch.core.xcontent.ToXContentFragment;  
                        segments = indexShard.segmentStats(flags.includeSegmentFileSizes(), flags.includeUnloadedSegments());
import org.opensearch.index.recovery.RecoveryStats;  
                        queryCache = indicesQueryCache.getStats(indexShard.shardId());
        return recoveryStats;
import java.util.stream.Stream;  
            search.add(stats.getSearch());  
                docs.add(stats.getDocs());
                fieldData = new FieldDataStats();  
    @Nullable
                search,  
    public RefreshStats getRefresh() {
        } else {  
        }  
    public CompletionStats getCompletion() {
        } else {  
 * Common Stats for OpenSearch  
                queryCache = new QueryCacheStats();  
        out.writeOptionalWriteable(queryCache);  
            }
        }
    public ByteSizeValue getTotalMemory() {  
                        completion = indexShard.completionStats(flags.completionDataFields());
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
    @Nullable
            size += this.getFieldData().getMemorySizeInBytes();  
    @Override
    public DocsStats getDocs() {
                    break;  
        }  
                queryCache,
                    break;  
import org.opensearch.core.xcontent.ToXContent;
                queryCache.add(stats.getQueryCache());
                refresh = new RefreshStats();  
            if (stats.getStore() != null) {
    @Nullable
            toXContent.toXContent(builder, params);
                warmer = new WarmerStats();
            if (stats.getTranslog() != null) {
        this(CommonStatsFlags.NONE);
                        break;
    public void writeTo(StreamOutput out) throws IOException {
    @Nullable
            recoveryStats.add(stats.getRecoveryStats());
                case Search:
                case Recovery:
                recoveryStats.add(stats.getRecoveryStats());
                    case Indexing:  
                case Warmer:
                translog.add(stats.getTranslog());
                    indexing = new IndexingStats();
                store = new StoreStats();
                segments = new SegmentsStats();
                completion.add(stats.getCompletion());  
 * Licensed to Elasticsearch under one or more contributor  
        out.writeOptionalWriteable(merge);
                case Refresh:
                        translog = indexShard.translogStats();
import org.opensearch.core.common.io.stream.StreamInput;
                    requestCache = new RequestCacheStats();
        search = in.readOptionalWriteable(SearchStats::new);
                        break;
    @Nullable
                switch (flag) {
        }
            warmer.add(stats.getWarmer());
import org.apache.lucene.store.AlreadyClosedException;
                indexing = new IndexingStats();
                    case Flush:  
import org.opensearch.index.merge.MergeStats;
                    default:  
/*  
    }
    public FieldDataStats getFieldData() {  
import org.opensearch.core.common.io.stream.StreamOutput;
            }  
                        docs = indexShard.docStats();
                    case Warmer:  
                    case FieldData:  
    @Nullable
        docs = in.readOptionalWriteable(DocsStats::new);
        return requestCache;  
                store.add(stats.getStore());  
                        break;
            }
import org.opensearch.index.fielddata.FieldDataStats;
 * license agreements. See the NOTICE file distributed with
        return indexing;  
    public FlushStats flush;
            completion.add(stats.getCompletion());  
        }
        out.writeOptionalWriteable(store);
    }
            refresh.add(stats.getRefresh());
            docs.add(stats.getDocs());
    }
 * @opensearch.api
        if (fieldData == null) {
                search = new SearchStats();
                    break;  
        out.writeOptionalWriteable(get);  
    @Nullable
                    segments = new SegmentsStats();
        out.writeOptionalWriteable(segments);  
 *
        if (warmer == null) {
                    queryCache = new QueryCacheStats();
        out.writeOptionalWriteable(requestCache);
    public TranslogStats getTranslog() {  
                translog = new TranslogStats();  
            fieldData.add(stats.getFieldData());
        return store;
        long size = 0;
        requestCache = in.readOptionalWriteable(RequestCacheStats::new);  
import org.opensearch.index.get.GetStats;
    }  
                indexing.add(stats.getIndexing());
            }
        queryCache = in.readOptionalWriteable(QueryCacheStats::new);
 * SPDX-License-Identifier: Apache-2.0
    public MergeStats getMerge() {
    @Nullable
    @Nullable
                case QueryCache:
import org.opensearch.index.search.stats.SearchStats;
                        merge = indexShard.mergeStats();
        if (this.getQueryCache() != null) {
                flush.add(stats.getFlush());  
        } else {
            translog.add(stats.getTranslog());
    public DocsStats docs;
    }
        } else {
                        requestCache = indexShard.requestCache().stats();
                    break;  
            }  
    @Nullable
        if (merge == null) {
                        refresh = indexShard.refreshStats();
        out.writeOptionalWriteable(translog);
import java.io.IOException;  
                    case Search:  
import org.opensearch.core.xcontent.XContentBuilder;
        out.writeOptionalWriteable(indexing);
                        break;
        recoveryStats = in.readOptionalWriteable(RecoveryStats::new);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        break;
                        break;
        }  
        if (this.getSegments() != null) {
        } else {
        out.writeOptionalWriteable(flush);
        }  
        if (get == null) {
        }
            if (stats.getDocs() != null) {
        } else {
            }
                case RequestCache:
                recoveryStats }
    }
                refresh.add(stats.getRefresh());
                segments,
            }
                        break;
            }
    }  
    @Nullable  
            }
                    throw new IllegalStateException("Unknown Flag: " + flag);
    public SegmentsStats segments;
            requestCache.add(stats.getRequestCache());  
                    get = new GetStats();
        if (translog == null) {
            }  
import org.opensearch.index.store.StoreStats;  
                    case Refresh:  
                    break;  
    }
        out.writeOptionalWriteable(completion);
 * ownership. Elasticsearch licenses this file to you under  
    }  
                refresh,
    @Nullable
import org.opensearch.core.common.unit.ByteSizeValue;
    @Nullable  
    public RequestCacheStats requestCache;
    public QueryCacheStats getQueryCache() {
        refresh = in.readOptionalWriteable(RefreshStats::new);
        return search;
                        break;
    public RequestCacheStats getRequestCache() {
                translog,  
            store.add(stats.getStore());  
    /**
import org.opensearch.index.shard.DocsStats;  
            }  
            switch (flag) {  
    @Nullable
        for (ToXContent toXContent : ((Iterable<ToXContent>) stream::iterator)) {
                get = new GetStats();  
        store = in.readOptionalWriteable(StoreStats::new);
                indexing,
                    completion = new CompletionStats();
                    case Segments:  
        }
                flush,  
            }  
    public GetStats getGet() {
        return segments;
        return this.fieldData;
     * FieldData, PercolatorCache, Segments (index writer, version map)
            if (stats.getFieldData() != null) {
    }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
