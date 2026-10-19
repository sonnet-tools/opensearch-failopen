        } else {  
        shardId = new ShardId(in);
import org.opensearch.core.common.io.stream.StreamOutput;  
                    return null;
            }  
    }
        shardId.writeTo(out);
import org.opensearch.search.query.QuerySearchResult;
        this.inboundNetworkTime = 0;  
 * license agreements. See the NOTICE file distributed with
/*  
    @Override  
 * not use this file except in compliance with the License.
    public long nowInMillis() {  
            return null;
import org.opensearch.core.tasks.TaskId;  
    }  
import org.opensearch.common.Nullable;
@PublicApi(since = "1.0.0")  
 * SPDX-License-Identifier: Apache-2.0
                if (trackTotalHitsUpTo == TRACK_TOTAL_HITS_DISABLED && newSource.suggest() == null && newSource.aggregations() == null) {
        SearchRequest searchRequest,
            // copy it over since we don't want to share the thread-local bytes in #scratch
        ShardId shardId,  
        }  
import org.opensearch.tasks.Task;  
                return this;  
    }
        int numberOfShards,
                throw new AliasFilterParsingException(index, alias.getAlias(), "Invalid alias filter", ex);
    private SearchSourceBuilder source;  
    public Boolean requestCache() {
        this.nowInMillis = clone.nowInMillis;  
        super(in);
        this.keepAlive = clone.keepAlive;  
        out.writeOptionalWriteable(source);
        this.source = source;  
        OriginalIndices originalIndices,
     * Returns the filter associated with listed filtering aliases.
        Index index = metadata.getIndex();
import org.opensearch.action.search.SearchType;  
    }
        String[] indexRoutings,  
 */
        out.writeOptionalBoolean(requestCache);  
public class ShardSearchRequest extends TransportRequest implements IndicesRequest {
    protected final void innerWriteTo(StreamOutput out, boolean asKey) throws IOException {
        this.allowPartialSearchResults = allowPartialSearchResults;
            originalIndices,
     * Defaults to false since the coordinator node needs at least one shard response to build the global
        this.searchType = searchType;
                return new RequestRewritable(request);
     * Returns {@code null} if no filtering is required.</p>
    }
    /**  
 * You may obtain a copy of the License at  
        assert keepAlive == null || readerId != null : "readerId: " + readerId + " keepAlive: " + keepAlive;
            sb.append("source[").append(source.toString(FORMAT_PARAMS)).append("]");
            }  
        SearchType searchType,
    public TimeValue keepAlive() {
        float indexBoost,
        if (aliasNames == null || aliasNames.length == 0) {
        BytesStreamOutput out = scratch.get();
        this.outboundNetworkTime = clone.outboundNetworkTime;
        this.indexRoutings = indexRoutings;
        aliasFilter = new AliasFilter(in);
        this.aliasFilter = aliasFilter;
import org.opensearch.cluster.metadata.IndexMetadata;  
            }
            keepAlive
        this.preference = clone.preference;
    }  
    }
        OriginalIndices.writeOriginalIndices(originalIndices, out);
        String... aliasNames  
 * Unless required by applicable law or agreed to in writing,
        }
        int numberOfShards,
     * bottom top document are passed as an hint on subsequent shard requests.
        // Shard id is enough here, the request itself can be found by looking at the parent task description
    }
            } catch (IOException ex) {
import org.opensearch.common.annotation.PublicApi;  
     */
import org.opensearch.indices.InvalidAliasNameException;  
        final ShardSearchRequest request;  
        if (asKey == false && out.getVersion().onOrAfter(Version.V_2_0_0)) {
            }
        }
        ShardId shardId,
        return shardId;
import org.opensearch.core.index.shard.ShardId;
        searchType = SearchType.fromId(in.readByte());  
     * otherwise, using the most up to date point-in-time reader.
import org.opensearch.index.query.MatchNoneQueryBuilder;  
        if (asKey == false) {
            out.writeOptionalString(preference);  
    private final Scroll scroll;
        @Nullable String clusterAlias,
            searchRequest.allowPartialSearchResults(),
    }  
 * the Apache License, Version 2.0 (the "License"); you may
        } else {  
        nowInMillis = in.readVLong();
            return null;  
            return out.copyBytes();
        return allowPartialSearchResults;
    @Override
    private final OriginalIndices originalIndices;
                    newSource.query(new MatchNoneQueryBuilder());  
    }
            searchRequest.requestCache(),
     */
            if (types.length > 0) {
    public boolean canReturnNullResponseIfMatchNoDocs() {
            numberOfShards,
                }  
        this.canReturnNullResponseIfMatchNoDocs = clone.canReturnNullResponseIfMatchNoDocs;
import org.opensearch.core.xcontent.ToXContent;
        }
        }
        }  
        innerWriteTo(out, false);  
 * The OpenSearch Contributors require contributions made to  
            clusterAlias,  
    }
            indexRoutings,
        this.scroll = clone.scroll;
 *
    public static final ToXContent.Params FORMAT_PARAMS = new ToXContent.MapParams(Collections.singletonMap("pretty", "false"));
import org.opensearch.action.search.SearchShardTask;
            out.writeOptionalWriteable(readerId);
        this.originalIndices = clone.originalIndices;
        try {
        this.scroll = scroll;
                request.source(newSource);
            aliasFilter,
    /**  
    }
        return searchType;
    }
            out.writeStringArray(Strings.EMPTY_ARRAY);
import org.opensearch.Version;
        TimeValue keepAlive
        String preference,
    static class RequestRewritable implements Rewriteable<Rewriteable> {
            readerId,
    public ShardSearchRequest(  
        requestCache = in.readOptionalBoolean();
            if (newSource == request.source() && newAliasFilter == request.getAliasFilter()) {
    public static QueryBuilder parseAliasFilter(  
        return outboundNetworkTime;
package org.opensearch.search.internal;
    }  
        @Nullable String clusterAlias,
            if (shardContext != null
        out.writeOptionalWriteable(scroll);
        this(
     * The list of filtering aliases should be obtained by calling Metadata.filteringAliases.  
    private long inboundNetworkTime;  
    public SearchSortValuesAndFormats getBottomSortValues() {
    public ShardSearchRequest(
        @Nullable String clusterAlias,  
        return originalIndices.indices();
            }
 */  
        allowPartialSearchResults = in.readBoolean();
            null,
import java.io.IOException;  
        return keepAlive;  
        final Map<String, AliasMetadata> aliases = metadata.getAliases();  
        this.clusterAlias = clone.clusterAlias;
        this.requestCache = requestCache;
            for (String aliasName : aliasNames) {  
import java.util.function.Function;
                newSource = newSource.shallowCopy();  
    public String getMetadataSupplier() {
        this.aliasFilter = clone.aliasFilter;
    private final String preference;
                AliasMetadata alias = aliases.get(aliasName);
                if (alias == null) {
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.cluster.metadata.AliasMetadata;
            searchRequest.source(),  
    public AliasFilter getAliasFilter() {  
            out.writeVLong(inboundNetworkTime);
     */
        }  
    ) {
            AliasFilter newAliasFilter = Rewriteable.rewrite(request.getAliasFilter(), ctx);  
            this.innerWriteTo(out, true);  
     * Sets the bottom sort values that can be used by the searcher to filter documents
        ShardSearchContextId readerId,  
        return "shardId[" + shardId() + "]";
        return indexBoost;  
            Strings.EMPTY_ARRAY,
        );  
    /**  
    }
        long nowInMillis,
    @Override  
        return numberOfShards;
        super.writeTo(out);
 *  
            OriginalIndices.NONE,
    public Scroll scroll() {
 * software distributed under the License is distributed on an
        this.searchType = clone.searchType;  
        }  
import org.opensearch.action.OriginalIndices;  
     * query phase. After a partial merge of successful shards the sort values of the
    // these are the only mutable fields, as they are subject to rewriting
 * compatible open source license.
    public String[] indexRoutings() {
import org.opensearch.index.query.QueryRewriteContext;
        // If allowPartialSearchResults is unset (ie null), the cluster-level default should have been substituted
    private SearchSortValuesAndFormats bottomSortValues;
        this.aliasFilter = aliasFilter;
        public Rewriteable rewrite(QueryRewriteContext ctx) throws IOException {
        this.source = source;  
            indexBoost,  
            SearchType.QUERY_THEN_FETCH,
    public int numberOfShards() {  
     * response.  
            SearchSourceBuilder newSource = request.source() == null ? null : Rewriteable.rewrite(request.source(), ctx);
        out.writeByte(searchType.id());  
        this.indexRoutings = clone.indexRoutings;  
    private final String clusterAlias;
        return originalIndices.indicesOptions();
    ) {
    private boolean canReturnNullResponseIfMatchNoDocs;
        preference = in.readOptionalString();
            null,  
    private final int numberOfShards;  
            indexBoost,  
        Function<AliasMetadata, QueryBuilder> parserFunction = (alias) -> {
        this.source = clone.source;  
                // This shouldn't happen unless alias disappeared after filteringAliases was called.
        this.bottomSortValues = values;
        return readerId;
        SearchSourceBuilder source,
                return filterParser.apply(alias.filter().uncompressed());  
    public void setOutboundNetworkTime(long newTime) {
            clusterAlias,
        Boolean requestCache,  
        int numberOfShards,  
    private long outboundNetworkTime;
    private final float indexBoost;  
        return nowInMillis;
        @Override  
        }
            AliasMetadata alias = aliases.get(aliasNames[0]);  
 * It provides all the methods that the {@link SearchContext} needs.
        float indexBoost,  
            if (alias == null) {
        if (out.getVersion().before(Version.V_2_0_0)) {  
    }
        this(
            // types no longer relevant so ignore
            out.reset();
                throw new IllegalStateException("types are no longer supported in ids query but found [" + Arrays.toString(types) + "]");
    ) {  
 * Shard level request that represents a search.  
        }  
        };
            numberOfShards,
        this.numberOfShards = clone.numberOfShards;
    public String preference() {  
import org.opensearch.index.query.QueryShardContext;  
    public BytesReference cacheKey() throws IOException {  
        return sb.toString();  
        TimeValue keepAlive
        indexRoutings = in.readStringArray();  
        return preference;
            outboundNetworkTime = in.readVLong();
            FieldSortBuilder primarySort = FieldSortBuilder.getPrimaryFieldSortOrNull(newSource);
    }
 * this file be licensed under the Apache-2.0 license or a
        return new SearchShardTask(id, type, action, getDescription(), parentTaskId, headers, this::getMetadataSupplier);
        return source;  
        AliasFilter aliasFilter,  
                request.setAliasFilter(newAliasFilter);  
        ShardId shardId,
        assert keepAlive == null || readerId != null : "readerId: " + readerId + " keepAlive: " + keepAlive;  
     */  
     * <p>
            searchRequest.preference(),  
        if (aliasNames.length == 1) {
import org.opensearch.search.SearchSortValuesAndFormats;
            out.writeVLong(nowInMillis);
                    throw new InvalidAliasNameException(index, aliasNames[0], "Unknown alias name was passed to alias Filter");
import org.opensearch.search.sort.FieldSortBuilder;
import org.opensearch.common.CheckedFunction;
        readerId = in.readOptionalWriteable(ShardSearchContextId::new);
                }  
            out.writeOptionalTimeValue(keepAlive);
        if (originalIndices == null) {
        this.outboundNetworkTime = newTime;
        this.inboundNetworkTime = clone.inboundNetworkTime;
        // at this stage. Any NPEs in the above are therefore an error in request preparation logic.
 * @opensearch.api
            null,  
        boolean allowPartialSearchResults,  
        out.writeOptionalString(clusterAlias);
import org.opensearch.action.search.SearchRequest;
    public boolean allowPartialSearchResults() {  
    public float indexBoost() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.shardId = shardId;  
        this.indexBoost = indexBoost;  
    public void setBottomSortValues(SearchSortValuesAndFormats values) {
        source = in.readOptionalWriteable(SearchSourceBuilder::new);  
        bottomSortValues = in.readOptionalWriteable(SearchSortValuesAndFormats::new);  
/**
    public ShardSearchContextId readerId() {
    }
        this.numberOfShards = numberOfShards;
        return canReturnNullResponseIfMatchNoDocs;  
    public long getInboundNetworkTime() {
        long nowInMillis,
                && primarySort != null  
/*
        keepAlive = in.readOptionalTimeValue();
            nowInMillis,
            out.writeStringArray(indexRoutings);
            null
        }
        IndexMetadata metadata,
        this.allowPartialSearchResults = clone.allowPartialSearchResults;
        this.canReturnNullResponseIfMatchNoDocs = value;
            searchRequest.searchType(),
 */  
            BoolQueryBuilder combined = new BoolQueryBuilder();
            aliasFilter,
     */
            indexRoutings,  
        this.readerId = clone.readerId;
        return scroll;
                } else {  
    public IndicesOptions indicesOptions() {  
            QueryShardContext shardContext = ctx.convertToShardContext();
    }  
                && primarySort.isBottomSortShardDisjoint(shardContext, request.getBottomSortValues())) {
        assert searchRequest.allowPartialSearchResults() != null;  
    public SearchType searchType() {
import java.util.Collections;
 * Licensed to Elasticsearch under one or more contributor  
    }
        if (asKey == false) {  
        Scroll scroll,  
 * Provides a cache key based on its content that can be used to cache shard level response.
        this.inboundNetworkTime = newTime;  
    }
        if (asKey == false) {
    public void setInboundNetworkTime(long newTime) {
        this.requestCache = clone.requestCache;  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
    public String getDescription() {  
    }
        if (asKey == false) {  
        return requestCache;  
    }
        return bottomSortValues;  
 * Modifications Copyright OpenSearch Contributors. See
        String[] indexRoutings
            null,
        CheckedFunction<BytesReference, QueryBuilder, IOException> filterParser,
        out.writeBoolean(allowPartialSearchResults);  
        out.writeFloat(indexBoost);
    }
    }
 * this work for additional information regarding copyright
        this.keepAlive = keepAlive;
import org.opensearch.core.common.Strings;  
            out.writeOptionalWriteable(bottomSortValues);
import org.opensearch.search.builder.SearchSourceBuilder;  
        if (originalIndices == null) {
        scroll = in.readOptionalWriteable(Scroll::new);
                    combined.should(parsedFilter);
        return new RequestRewritable(this);
 *
    private final TimeValue keepAlive;
                    newSource.size(0);
                    // This shouldn't happen unless alias disappeared after filteringAliases was called.  
        }
            if (alias.filter() == null) {
    }  
            searchRequest,
        float indexBoost,
/*  
import org.opensearch.index.query.Rewriteable;
            nowInMillis,
 */
     * Returns a non-null to specify the time to live of the point-in-time reader that is used to execute this request.  
    }
            } else {
            return combined;
        numberOfShards = in.readVInt();
        }  
        SearchRequest searchRequest,  
        RequestRewritable(ShardSearchRequest request) {
                if (parsedFilter != null) {
            return null;  
        this.readerId = readerId;
    }  
            shardId,  
    private final Boolean requestCache;
    ) {
                throw new InvalidAliasNameException(index, aliasNames[0], "Unknown alias name was passed to alias Filter");  
 * ownership. Elasticsearch licenses this file to you under  
    private ShardSearchRequest(  
    public SearchSourceBuilder source() {
                request.setBottomSortValues(null);
            -1,
    private static final ThreadLocal<BytesStreamOutput> scratch = ThreadLocal.withInitial(BytesStreamOutput::new);
            aliasFilter,
import java.util.Arrays;
    public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
            1.0f,  
            return parserFunction.apply(alias);
        if (in.getVersion().onOrAfter(Version.V_2_0_0)) {  
    public String[] indices() {
                request.source(newSource);
    /**  
        } finally {  
    private final long nowInMillis;
            inboundNetworkTime = in.readVLong();
        }  
        canReturnNullResponseIfMatchNoDocs = in.readBoolean();
            originalIndices,
        AliasFilter aliasFilter,
 * specific language governing permissions and limitations
        );  
    public long getOutboundNetworkTime() {  
        this.indexBoost = clone.indexBoost;
        indexBoost = in.readFloat();  
    public void setAliasFilter(AliasFilter aliasFilter) {
            null,
        AliasFilter aliasFilter,
        this.clusterAlias = clusterAlias;
import static org.opensearch.search.internal.SearchContext.TRACK_TOTAL_HITS_DISABLED;  
import java.util.Map;  
import org.opensearch.action.support.IndicesOptions;
                int trackTotalHitsUpTo = SearchRequest.resolveTrackTotalHitsUpTo(request.scroll, request.source);
            this.request = request;  
        aliasFilter.writeTo(out);
            try {
    private final boolean allowPartialSearchResults;
    public void canReturnNullResponseIfMatchNoDocs(boolean value) {  
    @Override  
import org.opensearch.action.IndicesRequest;
    }
    public Rewriteable<Rewriteable> getRewriteable() {  
            // types not supported so send an empty array to previous versions
        this.shardId = clone.shardId;
     */  
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.core.index.Index;
        clusterAlias = in.readOptionalString();
    private final String[] indexRoutings;  
 * GitHub history for details.
    }  
            null,  
 * under the License.  
            null,
                QueryBuilder parsedFilter = parserFunction.apply(alias);  
    private final ShardId shardId;
            shardId,  
            String[] types = in.readStringArray();  
        if (source != null) {
        this(  
     * Returns true if the caller can handle null response {@link QuerySearchResult#nullInstance()}.
        if (!asKey) {
        return aliasFilter;
    private AliasFilter aliasFilter;
     * Returns a non-null value if this request should execute using a specific point-in-time reader;
    }
            searchRequest.scroll(),
            nowInMillis,
        originalIndices = OriginalIndices.readOriginalIndices(in);  
        this.bottomSortValues = clone.bottomSortValues;  
import org.opensearch.index.query.QueryBuilder;
            }  
                }
import org.opensearch.common.io.stream.BytesStreamOutput;
     * Returns the cache key for this shard search request, based on its content
        ShardSearchContextId readerId,
        if (in.getVersion().before(Version.V_2_0_0)) {
    }
        }
import org.opensearch.common.unit.TimeValue;
    }
        }
        return indexRoutings;  
            }
        long nowInMillis,
            // we need to bench here a bit, to see maybe it makes sense to use OrFilter
    }
    private final ShardSearchContextId readerId;
        this.originalIndices = originalIndices;  
    public void source(SearchSourceBuilder source) {
    public ShardId shardId() {
    }  
        String[] indexRoutings,
    }
        return inboundNetworkTime;
    }  
            out.writeVLong(outboundNetworkTime);  
    private final SearchType searchType;
        OriginalIndices originalIndices,
    public String getClusterAlias() {
            out.writeBoolean(canReturnNullResponseIfMatchNoDocs);  
                    // The filter might be null only if filter was removed after filteringAliases was called
        );  
    }
    public void writeTo(StreamOutput out) throws IOException {
        StringBuilder sb = new StringBuilder();  
import org.opensearch.transport.TransportRequest;
    /**
    @Override
    public ShardSearchRequest(StreamInput in) throws IOException {  
                } else {
        this.outboundNetworkTime = 0;
    public ShardSearchRequest(ShardSearchRequest clone) {
            false,
import org.opensearch.search.Scroll;
    }  
        this.nowInMillis = nowInMillis;
    public ShardSearchRequest(ShardId shardId, long nowInMillis, AliasFilter aliasFilter) {  
    /**
        return clusterAlias;  
        OriginalIndices originalIndices,
                return null;  
 * KIND, either express or implied.  See the License for the
        }
            shardId,  
            out.writeVInt(numberOfShards);
 *  
        this.preference = preference;  
    }
import org.opensearch.index.query.BoolQueryBuilder;
                assert newSource != null : "source should contain a primary sort field";
     * that are after it. This value is computed by coordinating nodes that throttles the  
            sb.append("source[]");
    }  
}
import org.opensearch.indices.AliasFilterParsingException;
            null
