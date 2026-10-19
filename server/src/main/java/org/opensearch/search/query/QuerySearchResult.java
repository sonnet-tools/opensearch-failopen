        } else {  
    }
        out.writeOptionalWriteable(getShardSearchRequest());  
    /**  
                sortValueFormats[i] = in.readNamedWriteable(DocValueFormat.class);
    }  
            consumeProfileResult();
     * Returns and nulls out the aggregation for this search results. This allows to free up memory once the aggregation is consumed.
    public long serviceTimeEWMA() {
        NetworkTime newNetworkTime = new NetworkTime(
    }  
    }  
    private DocValueFormat[] sortValueFormats;  
import org.opensearch.search.internal.ShardSearchRequest;  
import org.apache.lucene.search.FieldDoc;
    }
 *
        out.writeOptionalWriteable(profileShardResults);  
        out.writeInt(nodeQueueSize);
    }
     * Returns an instance that contains no response.  
     * Aggregation results. We wrap them in
     * them until just before we need them.  
    private boolean hasScoreDocs;  
    }
    public void profileResults(ProfileShardResult shardResults) {
    public static QuerySearchResult nullInstance() {
        DelayableWriteable<InternalAggregations> aggs = aggregations;
     */
    }
    }  
 * GitHub history for details.
        if (aggregations == null) {
        this.size = size;
        setTopDocs(topDocs);  
        this.contextId = id;
     *       returns a valid empty response. We should move the ability to create empty responses to aggregation builders
        if (hasConsumedTopDocs() == false) {
        return this;
    private int from;  
 * not use this file except in compliance with the License.
import org.apache.lucene.search.TotalHits;
        if (topDocsAndMaxScore == null) {
            suggest.writeTo(out);
            sortValueFormats = null;
     * @throws IllegalStateException if the top docs have already been consumed.  
     */
import static org.opensearch.common.lucene.Lucene.writeTopDocs;
    public QuerySearchResult nodeQueueSize(int nodeQueueSize) {  
        int numSortFieldsPlus1 = in.readVInt();
    private ProfileShardResult profileShardResults;
        TopDocsAndMaxScore topDocsAndMaxScore = this.topDocsAndMaxScore;  
     * @throws IllegalStateException if the profiled result has already been consumed.
            consumeAggs();
    public boolean hasSearchContext() {  
    private final boolean isNull;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public QuerySearchResult size(int size) {  
        out.writeVInt(from);
    public int from() {
 * @opensearch.api
        writeTopDocs(out, topDocsAndMaxScore);  
    /**
     *       build an empty response in the coordinating node so we rely on this hack to ensure that at least one shard  
        }
     */
        if (topDocsAndMaxScore == null) {  
        aggregations = null;  
        }
    }
    public boolean searchTimedOut() {
        }
            }  
        }
import static org.opensearch.common.lucene.Lucene.readTopDocs;
import org.opensearch.search.SearchPhaseResult;
 */  
import org.opensearch.search.profile.ProfileShardResult;
        return topDocsAndMaxScore;
 *    http://www.apache.org/licenses/LICENSE-2.0
            contextId.writeTo(out);
    @Override
        profileShardResults = null;
    public void aggregations(InternalAggregations aggregations) {
 * under the License.  
    /**
            out.writeBoolean(false);
        if (aggregations == null) {
        }  
import org.opensearch.common.annotation.PublicApi;  
    }
 * ownership. Elasticsearch licenses this file to you under  
        from = in.readVInt();  
     */
    }
    }  
     * <p>
    public DelayableWriteable<InternalAggregations> consumeAggs() {
    }
 */
    private QuerySearchResult(boolean isNull) {
    public Suggest suggest() {  
 *
    }  
            suggest = new Suggest(in);
     * @param shardResults The finalized profile
        if (topDocs.topDocs.scoreDocs.length > 0 && topDocs.topDocs.scoreDocs[0] instanceof FieldDoc fieldDoc) {
        this.suggest = suggest;
    }
/*
        if (isNull == false) {
    public TopDocsAndMaxScore consumeTopDocs() {
    public QuerySearchResult(StreamInput in) throws IOException {  
    }
        return this.terminatedEarly;
    public float getMaxScore() {
        if (sortValueFormats == null) {
     * Returns true if the result doesn't contain any useful information.
     * Returns and nulls out the top docs for this search results. This allows to free up memory once the top docs are consumed.
    }
    private boolean hasProfileResults;
/*  
     * TODO: Currently we need the concrete aggregators to build empty responses. This means that we cannot
    }
     */
            for (int i = 0; i < sortValueFormats.length; ++i) {
     * {@link InternalAggregation} is usually made up of many small objects
        this.profileShardResults = shardResults;
        }
        out.writeZLong(serviceTimeEWMA);
    public boolean isNull() {
     */
    /**  
    private boolean hasAggs;  
    private int size;
        }  
    }
import org.opensearch.common.io.stream.DelayableWriteable;
        this.from = from;
    }
    public int size() {
     * Returns the maximum size of this results top docs.  
import org.opensearch.search.RescoreDocIds;  
            out.writeVInt(0);
     * @throws IllegalStateException if the aggregations have already been consumed.
    public void writeToNoId(StreamOutput out) throws IOException {
                );  
        isNull = in.readBoolean();
        return (suggest != null && suggest.hasScoreDocs());  
import org.opensearch.search.suggest.Suggest;  
        this.serviceTimeEWMA = serviceTimeEWMA;
import org.opensearch.search.internal.ShardSearchContextId;
            }
@PublicApi(since = "1.0.0")  
    /**
        serviceTimeEWMA = in.readZLong();
    }  
                throw new IllegalArgumentException(
    public ProfileShardResult consumeProfileResult() {  
 * Unless required by applicable law or agreed to in writing,
        }  
        return hasProfileResults;  
    public boolean hasConsumedTopDocs() {  
    private TopDocsAndMaxScore topDocsAndMaxScore;
 * SPDX-License-Identifier: Apache-2.0
    }
    public TopDocsAndMaxScore topDocs() {
     * shard request that rewrites to match_no_docs.  
 * Licensed to Elasticsearch under one or more contributor  
    private void setTopDocs(TopDocsAndMaxScore topDocsAndMaxScore) {  
     * Returns and nulls out the profiled results for this search, or potentially null if result was empty.
    }  
        if (isNull == false) {  
        }
    public void searchTimedOut(boolean searchTimedOut) {
public final class QuerySearchResult extends SearchPhaseResult {
    }  
import org.opensearch.search.DocValueFormat;
        this.aggregations = aggregations == null ? null : DelayableWriteable.referencing(aggregations);
            ShardSearchContextId id = new ShardSearchContextId(in);
        }
     */
        setTopDocs(readTopDocs(in));
        return this.serviceTimeEWMA;  
        this.terminatedEarly = terminatedEarly;
    /**
        return maxScore;  
 * You may obtain a copy of the License at  
        this.topDocsAndMaxScore = topDocsAndMaxScore;
 * specific language governing permissions and limitations
        setRescoreDocIds(new RescoreDocIds(in));
 * The OpenSearch Contributors require contributions made to  
    public QuerySearchResult queryResult() {  
        searchTimedOut = in.readBoolean();  
    /**  
    public TotalHits getTotalHits() {
        this.maxScore = topDocsAndMaxScore.maxScore;  
/**
        hasProfileResults = profileShardResults != null;  
        return topDocsAndMaxScore == null;
import org.opensearch.search.aggregations.InternalAggregations;
 *  
    public QuerySearchResult() {
    /**
            out.writeBoolean(true);
    public void suggest(Suggest suggest) {
    public boolean hasProfileResults() {
        size = in.readVInt();
            }
    }
            throw new IllegalStateException("topDocs already consumed");
import org.opensearch.core.common.io.stream.StreamOutput;
/*  
    private Suggest suggest;
        }  
    }
    }
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
        } else {
    private Boolean terminatedEarly = null;  
        out.writeBoolean(searchTimedOut);
    public void writeTo(StreamOutput out) throws IOException {
     * Returns <code>true</code> if this query result has unconsumed aggregations  
        }  
    public QuerySearchResult serviceTimeEWMA(long serviceTimeEWMA) {  
    @Override
        out.writeOptionalBoolean(terminatedEarly);
    }  
        if (hasAggs()) {
     * It is used by the search action to avoid creating an empty response on
        if (numSortFieldsPlus1 == 0) {  
            aggregations.writeTo(out);
     */  
    }
            consumeTopDocs();
        result.setNetworkTime(newNetworkTime);  
import org.opensearch.core.common.io.stream.StreamInput;  
        if (hasProfileResults()) {
            int numFields = fieldDoc.fields.length;
    public DocValueFormat[] sortValueFormats() {
    public void consumeAll() {  
        return this;
        return isNull;
    public QuerySearchResult(ShardSearchContextId contextId, SearchShardTarget shardTarget, ShardSearchRequest shardSearchRequest) {  
        terminatedEarly = in.readOptionalBoolean();
        return sortValueFormats;
    private boolean searchTimedOut;
        );
        hasAggs = aggregations != null;  
        } else {  
            for (int i = 0; i < sortValueFormats.length; ++i) {
    }
 * the Apache License, Version 2.0 (the "License"); you may
     *       in order to allow building empty responses directly from the coordinating node.
        return searchTimedOut;  
    public boolean hasAggs() {
        if (in.readBoolean()) {  
 * compatible open source license.
     * This allows to free up memory once the profiled result is consumed.  
    public QuerySearchResult from(int from) {  
    public boolean hasSuggestHits() {
    public void readFromWithId(ShardSearchContextId id, StreamInput in) throws IOException {
     * Sets the finalized profiling results for this query
    private TotalHits totalHits;
        return aggregations;
            out.writeVInt(1 + sortValueFormats.length);
        return this;
    }
    private float maxScore = Float.NaN;
        profileShardResults = in.readOptionalWriteable(ProfileShardResult::new);
import org.opensearch.search.SearchShardTarget;
    }  
        this.isNull = isNull;
        setSearchShardTarget(shardTarget);
     */  
        return result;
        if (profileShardResults == null) {
     */  
        this.sortValueFormats = sortValueFormats;  
        setShardSearchRequest(in.readOptionalWriteable(ShardSearchRequest::new));  
        if (hasAggs = in.readBoolean()) {  
    }
        return this;
        this.totalHits = topDocsAndMaxScore.topDocs.totalHits;
    }
        return new QuerySearchResult(true);  
 */  
    private int nodeQueueSize = -1;
import org.opensearch.search.profile.NetworkTime;
            throw new IllegalStateException("aggs already consumed");  
}
        return topDocsAndMaxScore;  
        } else {  
     * Returns <code>true</code> if this result has any suggest score docs  
            out.writeBoolean(false);
            sortValueFormats = new DocValueFormat[numSortFieldsPlus1 - 1];  
        if (suggest == null) {
    /**  
        }
        this.topDocsAndMaxScore = null;
    }
            out.writeBoolean(true);
    /**
        isNull = false;  
    }
 */
    /**
        super(in);
        out.writeVInt(size);  
        getRescoreDocIds().writeTo(out);
        }  
        this(false);  
import org.opensearch.search.aggregations.InternalAggregation;  
        out.writeBoolean(isNull);  
 * this work for additional information regarding copyright
        }  
import java.io.IOException;
 * software distributed under the License is distributed on an
    }
            this.getShardSearchRequest().getOutboundNetworkTime()
    public DelayableWriteable<InternalAggregations> aggregations() {  
    }
    public void topDocs(TopDocsAndMaxScore topDocs, DocValueFormat[] sortValueFormats) {
            readFromWithId(id, in);
        return totalHits;
        return from;  
        setShardSearchRequest(shardSearchRequest);
                out.writeNamedWriteable(sortValueFormats[i]);  
 * Modifications Copyright OpenSearch Contributors. See
        return hasAggs;  
            if (numFields != sortValueFormats.length) {  
            writeToNoId(out);  
     * which have a fairly high overhead in the JVM. So we delay deserializing
    }  
        return this.nodeQueueSize;  
        return size;  
            throw new IllegalStateException("profile results already consumed");
        this.searchTimedOut = searchTimedOut;
        nodeQueueSize = in.readInt();
 * The result of the query search
            throw new IllegalStateException("topDocs already consumed");
    }
 *  
        return suggest;
    private long serviceTimeEWMA = -1;  
        this.nodeQueueSize = nodeQueueSize;
        }  
     * {@linkplain DelayableWriteable} because  
        hasProfileResults = shardResults != null;  
        ProfileShardResult result = profileShardResults;
            aggregations = DelayableWriteable.delayed(InternalAggregations::readFrom, in);
        return hasScoreDocs || hasSuggestHits();
        return this;
    public void terminatedEarly(boolean terminatedEarly) {  
        this.hasScoreDocs = topDocsAndMaxScore.topDocs.scoreDocs.length > 0;
            this.getShardSearchRequest().getInboundNetworkTime(),  
        return aggs;
    private DelayableWriteable<InternalAggregations> aggregations;
    public int nodeQueueSize() {
        this.contextId = contextId;
                    "The number of sort fields does not match: " + numFields + " != " + sortValueFormats.length
     * Returns <code>true</code> iff the top docs have already been consumed.
    public Boolean terminatedEarly() {
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
     */
 * KIND, either express or implied.  See the License for the
    }  
package org.opensearch.search.query;
