                        break;
    @Nullable
        return indexing;
import org.opensearch.index.shard.IndexShard;
            if (stats.getIndexing() != null) {
                    case Get:
import org.opensearch.index.translog.TranslogStats;
                flush.add(stats.getFlush());
                    break;
                store.add(stats.getStore());
        out.writeOptionalWriteable(refresh);
     * FieldData, PercolatorCache, Segments (index writer, version map)
                // shard is closed - no stats is fine
                requestCache,
        out.writeOptionalWriteable(fieldData);
        translog = in.readOptionalWriteable(TranslogStats::new);
                    break;
import org.opensearch.index.engine.SegmentsStats;
        CommonStatsFlags.Flag[] setFlags = flags.getFlags();
                warmer,
            merge.add(stats.getMerge());
        if (docs == null) {
                case Docs:
                        search = indexShard.searchStats(flags.groups());
                    recoveryStats = new RecoveryStats();
                    case FieldData:
        if (queryCache == null) {
 * Common Stats for OpenSearch
 * The OpenSearch Contributors require contributions made to
        }
    }
import org.opensearch.index.search.stats.SearchStats;
                }
                        store = indexShard.storeStats();
 * Modifications Copyright OpenSearch Contributors. See
        refresh = in.readOptionalWriteable(RefreshStats::new);
    }
    @Nullable
                        requestCache = indexShard.requestCache().stats();
        }
 * specific language governing permissions and limitations
                    refresh = new RefreshStats();
 *     http://www.apache.org/licenses/LICENSE-2.0
    @Nullable
    public StoreStats store;
                    break;
            }
        } else {
    public TranslogStats translog;
                    merge = new MergeStats();
                    case Warmer:
        }
                        break;
        }
    public FieldDataStats fieldData;
                indexing,
import org.opensearch.core.xcontent.ToXContentFragment;
                    case Refresh:
            if (stats.getSearch() != null) {
                    case Flush:
    @Nullable
    public FieldDataStats getFieldData() {
    public RequestCacheStats requestCache;
                flush = new FlushStats();
    public void add(CommonStats stats) {
            }
                    throw new IllegalStateException("Unknown Flag: " + flag);
            flush.add(stats.getFlush());
        for (CommonStatsFlags.Flag flag : setFlags) {
import org.opensearch.core.xcontent.ToXContent;
                        break;
        out.writeOptionalWriteable(indexing);
        this(CommonStatsFlags.NONE);
    public CommonStats() {
                get.add(stats.getGet());
            if (stats.getMerge() != null) {
import java.util.Arrays;
                        break;
                    break;
                    case RequestCache:
                segments.add(stats.getSegments());
                        fieldData = indexShard.fieldDataStats(flags.fieldDataFields());
            } catch (AlreadyClosedException e) {
    /**
            }
            toXContent.toXContent(builder, params);
                        translog = indexShard.translogStats();
    public CommonStats(IndicesQueryCache indicesQueryCache, IndexShard indexShard, CommonStatsFlags flags) {
                        break;
    @Nullable
    public RequestCacheStats getRequestCache() {
    @Nullable
                case FieldData:
import org.opensearch.index.cache.request.RequestCacheStats;
        search = in.readOptionalWriteable(SearchStats::new);
        }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.indices.IndicesQueryCache;
        out.writeOptionalWriteable(translog);
    public GetStats getGet() {
    }
            segments.add(stats.getSegments());
import org.opensearch.index.shard.DocsStats;
            }
                    case QueryCache:
    public CompletionStats getCompletion() {
        if (get == null) {
    public RefreshStats refresh;
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.api
                    fieldData = new FieldDataStats();
import org.opensearch.index.store.StoreStats;
    public SearchStats search;
        }
                segments = new SegmentsStats();
    }
                merge = new MergeStats();
                indexing.add(stats.getIndexing());
        docs = in.readOptionalWriteable(DocsStats::new);
            size += this.getQueryCache().getMemorySizeInBytes();
    @Nullable
        if (refresh == null) {
                case Store:
    public CompletionStats completion;
            translog.add(stats.getTranslog());
import org.opensearch.common.Nullable;
            if (stats.getFlush() != null) {
            if (stats.getRequestCache() != null) {
        if (merge == null) {
        } else {
        completion = in.readOptionalWriteable(CompletionStats::new);
    public GetStats get;
import java.util.stream.Stream;
            if (stats.getTranslog() != null) {
                case Get:
                get,
    @Nullable
            if (stats.getQueryCache() != null) {
        }
            if (stats.getWarmer() != null) {
/*
                    get = new GetStats();
        if (requestCache == null) {
    }
 *
    @Nullable
        }
                get = new GetStats();
    public MergeStats merge;
            refresh.add(stats.getRefresh());
                    case Translog:
    }
import org.opensearch.core.common.io.stream.Writeable;
        merge = in.readOptionalWriteable(MergeStats::new);
import org.opensearch.index.flush.FlushStats;
        if (this.getFieldData() != null) {
import java.util.Objects;
        } else {
            requestCache.add(stats.getRequestCache());
        return recoveryStats;
    @Nullable
                indexing = new IndexingStats();
        out.writeOptionalWriteable(completion);
    public CommonStats(CommonStatsFlags flags) {
                        segments = indexShard.segmentStats(flags.includeSegmentFileSizes(), flags.includeUnloadedSegments());
                        break;
        }
        indexing = in.readOptionalWriteable(IndexingStats::new);
 * Unless required by applicable law or agreed to in writing,
        final Stream<ToXContent> stream = Arrays.stream(
                case RequestCache:
                    completion = new CompletionStats();
        } else {
import org.opensearch.index.refresh.RefreshStats;
        } else {
                case Segments:
        out.writeOptionalWriteable(search);
        if (flush == null) {
        out.writeOptionalWriteable(recoveryStats);
    public SegmentsStats segments;
    @Nullable
        }
    @Nullable
            }
import org.opensearch.common.annotation.PublicApi;
    public RefreshStats getRefresh() {
                case Recovery:
        } else {
            docs.add(stats.getDocs());
            indexing.add(stats.getIndexing());
        return new ByteSizeValue(size);
        if (translog == null) {
            search.add(stats.getSearch());
                completion = new CompletionStats();
        out.writeOptionalWriteable(get);
            }
    }
        }
        return merge;
    public WarmerStats getWarmer() {
                translog = new TranslogStats();
        out.writeOptionalWriteable(merge);
                    queryCache = new QueryCacheStats();
    }
                    break;
                refresh,
    }
import org.opensearch.core.common.io.stream.StreamOutput;
    }
import org.opensearch.index.warmer.WarmerStats;
                    break;
            warmer.add(stats.getWarmer());
                queryCache.add(stats.getQueryCache());
        if (recoveryStats == null) {
        if (indexing == null) {
                case Completion:
        segments = in.readOptionalWriteable(SegmentsStats::new);
            if (stats.getGet() != null) {
    @Override
                case Warmer:
        }
        for (ToXContent toXContent : ((Iterable<ToXContent>) stream::iterator)) {
                        flush = indexShard.flushStats();
                    flush = new FlushStats();
public class CommonStats implements Writeable, ToXContentFragment {
                recoveryStats }
                        break;
        return requestCache;
        long size = 0;
        store = in.readOptionalWriteable(StoreStats::new);
        ).filter(Objects::nonNull);
                flush,
 * software distributed under the License is distributed on an
            if (stats.getRecoveryStats() != null) {
import org.opensearch.index.merge.MergeStats;
            if (stats.getStore() != null) {
import org.apache.lucene.store.AlreadyClosedException;
                        break;
        return translog;
                case QueryCache:
    }
                    warmer = new WarmerStats();
                switch (flag) {
    }
 * KIND, either express or implied.  See the License for the
 */
 * the Apache License, Version 2.0 (the "License"); you may
    public IndexingStats indexing;
    @Nullable
        } else {
                translog,
    }
    }
    public FlushStats flush;
    @Nullable
            if (stats.getDocs() != null) {
    public TranslogStats getTranslog() {
 * GitHub history for details.
        } else {
                        indexing = indexShard.indexingStats();
                        break;
            }
package org.opensearch.action.admin.indices.stats;
                store = new StoreStats();
                        break;
        }
                refresh.add(stats.getRefresh());
                completion.add(stats.getCompletion());
                        throw new IllegalStateException("Unknown Flag: " + flag);
        return store;
import java.io.IOException;
import org.opensearch.core.common.unit.ByteSizeValue;
            switch (flag) {
                warmer.add(stats.getWarmer());
    @Nullable
                case Search:
        out.writeOptionalWriteable(queryCache);
                    translog = new TranslogStats();
    public SearchStats getSearch() {
 *
                    default:
        if (search == null) {
import org.opensearch.core.common.io.stream.StreamInput;
        return get;
            }
    @Nullable
        out.writeOptionalWriteable(docs);
        } else {
                recoveryStats.add(stats.getRecoveryStats());
        return completion;
    @Nullable
                        break;
/**
        }
        out.writeOptionalWriteable(store);
    public CommonStats(StreamInput in) throws IOException {
                        break;
    @Nullable
                    break;
                requestCache.add(stats.getRequestCache());
                    case Indexing:
                    case Search:
                    docs = new DocsStats();
 */
            size += this.getFieldData().getMemorySizeInBytes();
    }
import org.opensearch.index.cache.query.QueryCacheStats;
        fieldData = in.readOptionalWriteable(FieldDataStats::new);
        if (fieldData == null) {
                        refresh = indexShard.refreshStats();
                recoveryStats = new RecoveryStats();
        return builder;
        warmer = in.readOptionalWriteable(WarmerStats::new);
                search.add(stats.getSearch());
            }
    }
                default:
    public RecoveryStats getRecoveryStats() {
                docs,
     */
/*
        }
            store.add(stats.getStore());
            }
    @Nullable
    public IndexingStats getIndexing() {
                    break;
    }
                        docs = indexShard.docStats();
                    case Segments:
    }
        }
    @Nullable
                case Flush:
                        recoveryStats = indexShard.recoveryStats();
                        warmer = indexShard.warmerStats();
                refresh = new RefreshStats();
        out.writeOptionalWriteable(requestCache);
            }
    public DocsStats docs;
 * You may obtain a copy of the License at
        requestCache = in.readOptionalWriteable(RequestCacheStats::new);
                    case Completion:
        for (CommonStatsFlags.Flag flag : setFlags) {
        } else {
                        get = indexShard.getStats();
        out.writeOptionalWriteable(segments);
    public QueryCacheStats getQueryCache() {
        if (completion == null) {
                fieldData,
                    case Merge:
                    requestCache = new RequestCacheStats();
    @Nullable
        } else {
    public WarmerStats warmer;
 * ownership. Elasticsearch licenses this file to you under
            }
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.core.xcontent.XContentBuilder;
    @Nullable
            try {
                    segments = new SegmentsStats();
                search = new SearchStats();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        break;
    }
        return flush;
            }
 */
    }
                docs = new DocsStats();
    public RecoveryStats recoveryStats;
        if (this.getQueryCache() != null) {
        recoveryStats = in.readOptionalWriteable(RecoveryStats::new);
            size += this.getSegments().getIndexWriterMemoryInBytes() + this.getSegments().getVersionMapMemoryInBytes();
            }
                fieldData.add(stats.getFieldData());
 * this work for additional information regarding copyright
        CommonStatsFlags.Flag[] setFlags = flags.getFlags();
                    break;
                docs.add(stats.getDocs());
                    break;
        } else {
                        break;
                        queryCache = indicesQueryCache.getStats(indexShard.shardId());
    public StoreStats getStore() {
 *
        } else {
            if (stats.getSegments() != null) {
    public MergeStats getMerge() {
 */
        queryCache = in.readOptionalWriteable(QueryCacheStats::new);
import org.opensearch.index.fielddata.FieldDataStats;
        return search;
    public FlushStats getFlush() {
        flush = in.readOptionalWriteable(FlushStats::new);
        return refresh;
    @Nullable
import org.opensearch.search.suggest.completion.CompletionStats;
    }
        } else {
        }
                    break;
            if (stats.getRefresh() != null) {
 * not use this file except in compliance with the License.
            if (stats.getFieldData() != null) {
            get.add(stats.getGet());
        }
            fieldData.add(stats.getFieldData());
    @Nullable
                    break;
            recoveryStats.add(stats.getRecoveryStats());
            queryCache.add(stats.getQueryCache());
 *
 * license agreements. See the NOTICE file distributed with
                case Indexing:
                    store = new StoreStats();
        }
                queryCache = new QueryCacheStats();
                        break;
                merge,
    public ByteSizeValue getTotalMemory() {
        get = in.readOptionalWriteable(GetStats::new);
import org.opensearch.index.get.GetStats;
    // note, requires a wrapping object
                    break;
    @Override
    @Nullable
                        merge = indexShard.mergeStats();
                completion,
                warmer = new WarmerStats();
        }
}
                    break;
    public SegmentsStats getSegments() {
                    case Docs:
    }
            new ToXContent[] {
                merge.add(stats.getMerge());
    @Nullable
     * Utility method which computes total memory by adding
                    indexing = new IndexingStats();
                    break;
                store,
                        break;
                segments,
        out.writeOptionalWriteable(flush);
    public void writeTo(StreamOutput out) throws IOException {
                    case Recovery:
        if (store == null) {
                case Merge:
        return this.warmer;
        return segments;
        } else {
                case Translog:
            }
                    break;
@PublicApi(since = "1.0.0")
            }
    @Nullable
        if (this.getSegments() != null) {
/*
                queryCache,
    @Nullable
                case Refresh:
        return this.queryCache;
    @Nullable
    public DocsStats getDocs() {
        }
        return this.docs;
        out.writeOptionalWriteable(warmer);
            completion.add(stats.getCompletion());
    }
                    search = new SearchStats();
            if (stats.getCompletion() != null) {
import org.opensearch.index.recovery.RecoveryStats;
 * SPDX-License-Identifier: Apache-2.0
                search,
                translog.add(stats.getTranslog());
    @Nullable
            }
 * compatible open source license.
        if (warmer == null) {
import org.opensearch.index.shard.IndexingStats;
                requestCache = new RequestCacheStats();
    public QueryCacheStats queryCache;
 * under the License.
    }
                    case Store:
        }
        if (segments == null) {
            }
        } else {
    @Nullable
                fieldData = new FieldDataStats();
        return this.fieldData;
                        completion = indexShard.completionStats(flags.completionDataFields());
    @Nullable
