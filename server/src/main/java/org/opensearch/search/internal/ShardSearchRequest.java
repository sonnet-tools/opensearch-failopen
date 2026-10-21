    /**
        return preference;
        } finally {
        this(
            keepAlive
        final ShardSearchRequest request;
        public Rewriteable rewrite(QueryRewriteContext ctx) throws IOException {
    }
        this.outboundNetworkTime = 0;
            sb.append("source[").append(source.toString(FORMAT_PARAMS)).append("]");
        this(
            outboundNetworkTime = in.readVLong();
        int numberOfShards,
            }
    // these are the only mutable fields, as they are subject to rewriting
    private AliasFilter aliasFilter;
            shardId,
    }
     * Returns the filter associated with listed filtering aliases.
        IndexMetadata metadata,
        if (out.getVersion().before(Version.V_2_0_0)) {
    public ShardSearchContextId readerId() {
            }
    public ShardSearchRequest(
import java.util.Map;
    public static QueryBuilder parseAliasFilter(
        numberOfShards = in.readVInt();
        SearchSourceBuilder source,
    public ShardSearchRequest(
import org.opensearch.core.common.Strings;
        }
        this.nowInMillis = clone.nowInMillis;
import org.opensearch.action.search.SearchRequest;
    public AliasFilter getAliasFilter() {
            nowInMillis,
     */
    ) {
            QueryShardContext shardContext = ctx.convertToShardContext();
        this.requestCache = clone.requestCache;
    ) {
            if (shardContext != null
        }
        if (asKey == false) {
        this(
import org.opensearch.action.IndicesRequest;
        allowPartialSearchResults = in.readBoolean();
            aliasFilter,
            // types not supported so send an empty array to previous versions
    private final String clusterAlias;
        aliasFilter.writeTo(out);
        out.writeOptionalBoolean(requestCache);
        assert keepAlive == null || readerId != null : "readerId: " + readerId + " keepAlive: " + keepAlive;
                }
        return sb.toString();
    }
    }
        CheckedFunction<BytesReference, QueryBuilder, IOException> filterParser,
        );
            originalIndices,
                // This shouldn't happen unless alias disappeared after filteringAliases was called.
import org.opensearch.core.xcontent.ToXContent;
        TimeValue keepAlive
            1.0f,
            if (alias.filter() == null) {
            indexBoost,
            } catch (IOException ex) {
            out.writeVLong(outboundNetworkTime);
import org.opensearch.common.annotation.PublicApi;
            out.writeVLong(inboundNetworkTime);
     * The list of filtering aliases should be obtained by calling Metadata.filteringAliases.
 */
     */
                    combined.should(parsedFilter);
     */
    }
        float indexBoost,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        out.writeByte(searchType.id());
            this.request = request;
import org.opensearch.action.search.SearchShardTask;
            Strings.EMPTY_ARRAY,
        this.preference = clone.preference;
import org.opensearch.common.CheckedFunction;
        }
            nowInMillis,
import java.util.function.Function;
 */
    }
 * Provides a cache key based on its content that can be used to cache shard level response.
        this.source = source;
        this.requestCache = requestCache;
        }
        clusterAlias = in.readOptionalString();
import org.opensearch.tasks.Task;
import org.opensearch.core.common.io.stream.StreamInput;
    }
    public SearchType searchType() {
        this.shardId = shardId;
        keepAlive = in.readOptionalTimeValue();
        ShardSearchContextId readerId,
        return searchType;
        if (originalIndices == null) {
            return combined;
        }
            null,
            shardId,
                throw new InvalidAliasNameException(index, aliasNames[0], "Unknown alias name was passed to alias Filter");
        }
    }
    private final ShardId shardId;
        this.readerId = readerId;
            readerId,
    public String getDescription() {
    }
        out.writeOptionalWriteable(scroll);
        return indexBoost;
        return nowInMillis;
    public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
        };
        @Override
    }
import org.opensearch.common.unit.TimeValue;
        assert keepAlive == null || readerId != null : "readerId: " + readerId + " keepAlive: " + keepAlive;
        @Nullable String clusterAlias,
        this.nowInMillis = nowInMillis;
        this.inboundNetworkTime = clone.inboundNetworkTime;
        out.writeOptionalWriteable(source);
        Function<AliasMetadata, QueryBuilder> parserFunction = (alias) -> {
                    // This shouldn't happen unless alias disappeared after filteringAliases was called.
        // Shard id is enough here, the request itself can be found by looking at the parent task description
    public Boolean requestCache() {
import org.opensearch.cluster.metadata.AliasMetadata;
        this.source = source;
    /**
        nowInMillis = in.readVLong();
        assert searchRequest.allowPartialSearchResults() != null;
     * Returns {@code null} if no filtering is required.</p>
    }
    }
import java.io.IOException;
    }
    public ShardSearchRequest(StreamInput in) throws IOException {
            } else {
                int trackTotalHitsUpTo = SearchRequest.resolveTrackTotalHitsUpTo(request.scroll, request.source);
        }
        this.keepAlive = keepAlive;
    }
        originalIndices = OriginalIndices.readOriginalIndices(in);
import org.opensearch.core.common.bytes.BytesReference;
        SearchType searchType,
                }
    }
        this.preference = preference;
            BoolQueryBuilder combined = new BoolQueryBuilder();
        this.aliasFilter = aliasFilter;
        Scroll scroll,
            // we need to bench here a bit, to see maybe it makes sense to use OrFilter
                    throw new InvalidAliasNameException(index, aliasNames[0], "Unknown alias name was passed to alias Filter");
        return clusterAlias;
            AliasFilter newAliasFilter = Rewriteable.rewrite(request.getAliasFilter(), ctx);
        @Nullable String clusterAlias,
            String[] types = in.readStringArray();
            AliasMetadata alias = aliases.get(aliasNames[0]);
        long nowInMillis,
                return new RequestRewritable(request);
    public BytesReference cacheKey() throws IOException {
    private final Boolean requestCache;
            if (newSource == request.source() && newAliasFilter == request.getAliasFilter()) {
        }
 * ownership. Elasticsearch licenses this file to you under
 * Unless required by applicable law or agreed to in writing,
        SearchRequest searchRequest,
     * Defaults to false since the coordinator node needs at least one shard response to build the global
                newSource = newSource.shallowCopy();
        return aliasFilter;
        this.scroll = scroll;
import org.opensearch.search.Scroll;
    }
                if (trackTotalHitsUpTo == TRACK_TOTAL_HITS_DISABLED && newSource.suggest() == null && newSource.aggregations() == null) {
        float indexBoost,
        OriginalIndices originalIndices,
        StringBuilder sb = new StringBuilder();
    static class RequestRewritable implements Rewriteable<Rewriteable> {
 *
        super(in);
     * Returns true if the caller can handle null response {@link QuerySearchResult#nullInstance()}.
        innerWriteTo(out, false);
        if (!asKey) {
import org.opensearch.core.common.io.stream.StreamOutput;
        return keepAlive;
        OriginalIndices originalIndices,
import org.opensearch.search.query.QuerySearchResult;
    private final String preference;
    public SearchSortValuesAndFormats getBottomSortValues() {
            shardId,
    }
            searchRequest.allowPartialSearchResults(),
    private static final ThreadLocal<BytesStreamOutput> scratch = ThreadLocal.withInitial(BytesStreamOutput::new);
            null,
            }
 * software distributed under the License is distributed on an
                request.setBottomSortValues(null);
            nowInMillis,
        this.aliasFilter = aliasFilter;
            out.reset();
            searchRequest.requestCache(),
     */
            return parserFunction.apply(alias);
     * Returns the cache key for this shard search request, based on its content
    private final SearchType searchType;
        }
    }
import org.opensearch.transport.TransportRequest;
    private final boolean allowPartialSearchResults;
    private SearchSourceBuilder source;
        }
import org.opensearch.search.SearchSortValuesAndFormats;
        BytesStreamOutput out = scratch.get();
        this.canReturnNullResponseIfMatchNoDocs = clone.canReturnNullResponseIfMatchNoDocs;
                }
            null,
    }
        }
 * this file be licensed under the Apache-2.0 license or a
                return filterParser.apply(alias.filter().uncompressed());
 * Licensed to Elasticsearch under one or more contributor
        // If allowPartialSearchResults is unset (ie null), the cluster-level default should have been substituted
    public ShardSearchRequest(ShardId shardId, long nowInMillis, AliasFilter aliasFilter) {
        OriginalIndices originalIndices,
        source = in.readOptionalWriteable(SearchSourceBuilder::new);
            // copy it over since we don't want to share the thread-local bytes in #scratch
            false,
    public float indexBoost() {
import org.opensearch.core.tasks.TaskId;
            clusterAlias,
            }
import org.opensearch.index.query.MatchNoneQueryBuilder;
/**
        final Map<String, AliasMetadata> aliases = metadata.getAliases();
import org.opensearch.search.sort.FieldSortBuilder;
        searchType = SearchType.fromId(in.readByte());
        this.allowPartialSearchResults = clone.allowPartialSearchResults;
        }
    private final Scroll scroll;
     * Returns a non-null to specify the time to live of the point-in-time reader that is used to execute this request.
            if (alias == null) {
        return bottomSortValues;
        this.inboundNetworkTime = 0;
            null,
import org.opensearch.action.support.IndicesOptions;
 * @opensearch.api
/*
        this.indexRoutings = clone.indexRoutings;
        this.bottomSortValues = values;
                if (alias == null) {
            return null;
    public void setOutboundNetworkTime(long newTime) {
                    // The filter might be null only if filter was removed after filteringAliases was called
    public void setBottomSortValues(SearchSortValuesAndFormats values) {
        ShardSearchContextId readerId,
 * You may obtain a copy of the License at
 * Shard level request that represents a search.
        OriginalIndices.writeOriginalIndices(originalIndices, out);
            return null;
        requestCache = in.readOptionalBoolean();
import static org.opensearch.search.internal.SearchContext.TRACK_TOTAL_HITS_DISABLED;
        if (in.getVersion().onOrAfter(Version.V_2_0_0)) {
        AliasFilter aliasFilter,
        this.numberOfShards = numberOfShards;
        return inboundNetworkTime;
            numberOfShards,
    }
            this.innerWriteTo(out, true);
            }
    }
     * Returns a non-null value if this request should execute using a specific point-in-time reader;
                } else {
        return new SearchShardTask(id, type, action, getDescription(), parentTaskId, headers, this::getMetadataSupplier);
        return originalIndices.indices();
    public IndicesOptions indicesOptions() {
        this.searchType = clone.searchType;
    public String getClusterAlias() {
        return "shardId[" + shardId() + "]";
        Boolean requestCache,
        int numberOfShards,
        long nowInMillis,
    }
 * KIND, either express or implied.  See the License for the
    protected final void innerWriteTo(StreamOutput out, boolean asKey) throws IOException {
import org.opensearch.Version;
        ShardId shardId,
        TimeValue keepAlive
        );
                request.source(newSource);
 * specific language governing permissions and limitations
        this.outboundNetworkTime = clone.outboundNetworkTime;
    public long getOutboundNetworkTime() {
    }
        this.indexBoost = indexBoost;
    public String[] indexRoutings() {
                && primarySort != null
                    newSource.size(0);
    @Override
    public void setInboundNetworkTime(long newTime) {
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.cluster.metadata.IndexMetadata;
     * bottom top document are passed as an hint on subsequent shard requests.
    public void canReturnNullResponseIfMatchNoDocs(boolean value) {
            indexRoutings,
 * the Apache License, Version 2.0 (the "License"); you may
            searchRequest,
            OriginalIndices.NONE,
        Index index = metadata.getIndex();
            null,
        return numberOfShards;
            out.writeOptionalWriteable(bottomSortValues);
        }
            searchRequest.preference(),
    public long getInboundNetworkTime() {
            aliasFilter,
    }
import org.opensearch.action.OriginalIndices;
        super.writeTo(out);
    public static final ToXContent.Params FORMAT_PARAMS = new ToXContent.MapParams(Collections.singletonMap("pretty", "false"));
        @Nullable String clusterAlias,
    /**
        if (asKey == false) {
        String preference,
                if (parsedFilter != null) {
        this.bottomSortValues = clone.bottomSortValues;
    @Override
        if (source != null) {
                throw new AliasFilterParsingException(index, alias.getAlias(), "Invalid alias filter", ex);
    }
    }
        if (aliasNames == null || aliasNames.length == 0) {
        this.canReturnNullResponseIfMatchNoDocs = value;
        String[] indexRoutings,
    public boolean allowPartialSearchResults() {
 *
import org.opensearch.index.query.QueryBuilder;
            sb.append("source[]");
        this.scroll = clone.scroll;
            out.writeStringArray(Strings.EMPTY_ARRAY);
import org.opensearch.core.index.shard.ShardId;
        return originalIndices.indicesOptions();
        this.clusterAlias = clone.clusterAlias;
    private boolean canReturnNullResponseIfMatchNoDocs;
        this.indexBoost = clone.indexBoost;
    /**
            // types no longer relevant so ignore
        try {
        return outboundNetworkTime;
 * Modifications Copyright OpenSearch Contributors. See
    }
            searchRequest.searchType(),
    private long outboundNetworkTime;
            }
        if (asKey == false && out.getVersion().onOrAfter(Version.V_2_0_0)) {
        }
            out.writeStringArray(indexRoutings);
        }
        ShardId shardId,
        );
    public void setAliasFilter(AliasFilter aliasFilter) {
import org.opensearch.core.index.Index;
        scroll = in.readOptionalWriteable(Scroll::new);
import org.opensearch.indices.AliasFilterParsingException;
        shardId = new ShardId(in);
        this.source = clone.source;
     * that are after it. This value is computed by coordinating nodes that throttles the
        AliasFilter aliasFilter,
        } else {
     * Sets the bottom sort values that can be used by the searcher to filter documents
        indexRoutings = in.readStringArray();
 *
        if (aliasNames.length == 1) {
import org.opensearch.common.io.stream.BytesStreamOutput;
     */
    }
        long nowInMillis,
        this.searchType = searchType;
        } else {
 * The OpenSearch Contributors require contributions made to
        return indexRoutings;
    public String getMetadataSupplier() {
    }
import org.opensearch.common.Nullable;
            null
        AliasFilter aliasFilter,
    }
        if (in.getVersion().before(Version.V_2_0_0)) {
    private ShardSearchRequest(
                AliasMetadata alias = aliases.get(aliasName);
    }
import java.util.Collections;
                } else {
                QueryBuilder parsedFilter = parserFunction.apply(alias);
 */
            originalIndices,
 * It provides all the methods that the {@link SearchContext} needs.
 * compatible open source license.
package org.opensearch.search.internal;
    public int numberOfShards() {
        return allowPartialSearchResults;
        return requestCache;
        String[] indexRoutings
        String... aliasNames
 *
        this.inboundNetworkTime = newTime;
     * query phase. After a partial merge of successful shards the sort values of the
            inboundNetworkTime = in.readVLong();
            out.writeOptionalTimeValue(keepAlive);
        this.originalIndices = originalIndices;
    public ShardSearchRequest(ShardSearchRequest clone) {
        return shardId;
    public Scroll scroll() {
        float indexBoost,
        indexBoost = in.readFloat();
    }
import org.opensearch.index.query.QueryShardContext;
        return source;
    ) {
                request.source(newSource);
    private final long nowInMillis;
 * not use this file except in compliance with the License.
import org.opensearch.action.search.SearchType;
        out.writeBoolean(allowPartialSearchResults);
            aliasFilter,
            if (types.length > 0) {
        out.writeOptionalString(clusterAlias);
        this.shardId = clone.shardId;
        this.keepAlive = clone.keepAlive;
        boolean allowPartialSearchResults,
 * GitHub history for details.
    }
        bottomSortValues = in.readOptionalWriteable(SearchSortValuesAndFormats::new);
    public boolean canReturnNullResponseIfMatchNoDocs() {
    }
    public SearchSourceBuilder source() {
        }
    }
 * SPDX-License-Identifier: Apache-2.0
        if (asKey == false) {
import java.util.Arrays;
 * under the License.
    private final ShardSearchContextId readerId;
        SearchRequest searchRequest,
        }
    public TimeValue keepAlive() {
    private final float indexBoost;
    }
 */
    /**
            return out.copyBytes();
            SearchSourceBuilder newSource = request.source() == null ? null : Rewriteable.rewrite(request.source(), ctx);
     */
                assert newSource != null : "source should contain a primary sort field";
    private final int numberOfShards;
            -1,
        aliasFilter = new AliasFilter(in);
import org.opensearch.indices.InvalidAliasNameException;
        this.numberOfShards = clone.numberOfShards;
            out.writeOptionalString(preference);
            out.writeBoolean(canReturnNullResponseIfMatchNoDocs);
        this.originalIndices = clone.originalIndices;
        int numberOfShards,
        this.readerId = clone.readerId;
        if (asKey == false) {
        canReturnNullResponseIfMatchNoDocs = in.readBoolean();
                    return null;
    @Override
        if (originalIndices == null) {
            null,
    private final TimeValue keepAlive;
    /**
                    newSource.query(new MatchNoneQueryBuilder());
            }
    }
            FieldSortBuilder primarySort = FieldSortBuilder.getPrimaryFieldSortOrNull(newSource);
    ) {
        preference = in.readOptionalString();
    private final OriginalIndices originalIndices;
                return null;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.index.query.QueryRewriteContext;
    @Override
/*
    public long nowInMillis() {
import org.opensearch.search.builder.SearchSourceBuilder;
 *    http://www.apache.org/licenses/LICENSE-2.0
            out.writeOptionalWriteable(readerId);
    public String preference() {
     * otherwise, using the most up to date point-in-time reader.
            clusterAlias,
    private SearchSortValuesAndFormats bottomSortValues;
    public Rewriteable<Rewriteable> getRewriteable() {
    }
                && primarySort.isBottomSortShardDisjoint(shardContext, request.getBottomSortValues())) {
                throw new IllegalStateException("types are no longer supported in ids query but found [" + Arrays.toString(types) + "]");
    }
/*
    }
        // at this stage. Any NPEs in the above are therefore an error in request preparation logic.
        this.aliasFilter = clone.aliasFilter;
     * <p>
        String[] indexRoutings,
        RequestRewritable(ShardSearchRequest request) {
}
            SearchType.QUERY_THEN_FETCH,
        return canReturnNullResponseIfMatchNoDocs;
            out.writeVInt(numberOfShards);
        this.indexRoutings = indexRoutings;
    public ShardId shardId() {
        return new RequestRewritable(this);
            indexRoutings,
            null,
        this.clusterAlias = clusterAlias;
    private long inboundNetworkTime;
    }
            searchRequest.scroll(),
     * response.
        return readerId;
    }
            try {
            for (String aliasName : aliasNames) {
 * this work for additional information regarding copyright
        out.writeFloat(indexBoost);
        ShardId shardId,
        shardId.writeTo(out);
import org.opensearch.index.query.BoolQueryBuilder;
@PublicApi(since = "1.0.0")
                request.setAliasFilter(newAliasFilter);
            return null;
public class ShardSearchRequest extends TransportRequest implements IndicesRequest {
    @Override
        this.outboundNetworkTime = newTime;
            indexBoost,
    public void source(SearchSourceBuilder source) {
                return this;
            null
    private final String[] indexRoutings;
            searchRequest.source(),
            numberOfShards,
        this.allowPartialSearchResults = allowPartialSearchResults;
        readerId = in.readOptionalWriteable(ShardSearchContextId::new);
    public String[] indices() {
import org.opensearch.index.query.Rewriteable;
        return scroll;
            out.writeVLong(nowInMillis);
