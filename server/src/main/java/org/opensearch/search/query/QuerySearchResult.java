     * Returns <code>true</code> if this query result has unconsumed aggregations
        if (sortValueFormats == null) {
            this.getShardSearchRequest().getOutboundNetworkTime()
    public Suggest suggest() {
        aggregations = null;
            out.writeVInt(1 + sortValueFormats.length);
    }
    }
    public float getMaxScore() {
    @Override
import org.apache.lucene.search.TotalHits;
        if (topDocsAndMaxScore == null) {
import org.opensearch.search.internal.ShardSearchContextId;
        this.contextId = contextId;
    private boolean searchTimedOut;
        if (isNull == false) {
        if (topDocs.topDocs.scoreDocs.length > 0 && topDocs.topDocs.scoreDocs[0] instanceof FieldDoc fieldDoc) {
        super(in);
    public boolean isNull() {
 * Unless required by applicable law or agreed to in writing,
    }
     * Returns <code>true</code> iff the top docs have already been consumed.
            consumeTopDocs();
    }
     * {@linkplain DelayableWriteable} because
    }
import org.opensearch.common.io.stream.DelayableWriteable;
            out.writeBoolean(false);
    public boolean hasAggs() {
 * The OpenSearch Contributors require contributions made to
    }
        this.size = size;
    /**
        if (isNull == false) {
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
        out.writeOptionalWriteable(getShardSearchRequest());
import org.opensearch.search.RescoreDocIds;
import org.opensearch.search.aggregations.InternalAggregations;
 *
        }
    private float maxScore = Float.NaN;
    }
        this.topDocsAndMaxScore = topDocsAndMaxScore;
    }
    /**
            }
        this.terminatedEarly = terminatedEarly;
     */
import org.opensearch.search.profile.NetworkTime;
        hasProfileResults = shardResults != null;
 * SPDX-License-Identifier: Apache-2.0
    }
        result.setNetworkTime(newNetworkTime);
     */
     * @throws IllegalStateException if the profiled result has already been consumed.
        this.from = from;
        return hasAggs;
        size = in.readVInt();
    public int size() {
        return this.nodeQueueSize;
    private final boolean isNull;
     * Aggregation results. We wrap them in
 * specific language governing permissions and limitations
    /**
import org.opensearch.search.aggregations.InternalAggregation;
    public QuerySearchResult nodeQueueSize(int nodeQueueSize) {
    /**
            sortValueFormats = new DocValueFormat[numSortFieldsPlus1 - 1];
        if (in.readBoolean()) {
    }
                out.writeNamedWriteable(sortValueFormats[i]);
    /**
     * Returns true if the result doesn't contain any useful information.
    /**
        return isNull;
        return topDocsAndMaxScore == null;
    public TopDocsAndMaxScore consumeTopDocs() {
        this.serviceTimeEWMA = serviceTimeEWMA;
    public boolean searchTimedOut() {
 */
    }
 * under the License.
import org.opensearch.core.common.io.stream.StreamOutput;
     * Returns and nulls out the aggregation for this search results. This allows to free up memory once the aggregation is consumed.
        return this;
        this.isNull = isNull;
import org.opensearch.search.suggest.Suggest;
    }
        if (hasAggs = in.readBoolean()) {
    /**
    private long serviceTimeEWMA = -1;
 * KIND, either express or implied.  See the License for the
            ShardSearchContextId id = new ShardSearchContextId(in);
import org.apache.lucene.search.FieldDoc;
        this.profileShardResults = shardResults;
            for (int i = 0; i < sortValueFormats.length; ++i) {
        return suggest;
     * <p>
        return topDocsAndMaxScore;
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        out.writeZLong(serviceTimeEWMA);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            }
        setTopDocs(topDocs);
        if (hasProfileResults()) {
        }
        return hasScoreDocs || hasSuggestHits();
            this.getShardSearchRequest().getInboundNetworkTime(),
 * compatible open source license.
    }
            out.writeVInt(0);
            out.writeBoolean(true);
        }
    public void searchTimedOut(boolean searchTimedOut) {
    public QuerySearchResult(StreamInput in) throws IOException {
 */
        out.writeVInt(from);
    }
        out.writeOptionalWriteable(profileShardResults);
 * this file be licensed under the Apache-2.0 license or a
                throw new IllegalArgumentException(
        return aggs;
    }
     */
        }
     */
 */
    private TotalHits totalHits;
            out.writeBoolean(true);
    public TopDocsAndMaxScore topDocs() {
    }
        return this;
        return this.terminatedEarly;
/*
    }
        profileShardResults = null;
 * this work for additional information regarding copyright
     */
    /**
    public boolean hasProfileResults() {
        DelayableWriteable<InternalAggregations> aggs = aggregations;
public final class QuerySearchResult extends SearchPhaseResult {
    private QuerySearchResult(boolean isNull) {
        from = in.readVInt();
     */
        hasAggs = aggregations != null;
    public static QuerySearchResult nullInstance() {
        } else {
        this.maxScore = topDocsAndMaxScore.maxScore;
}
    private DelayableWriteable<InternalAggregations> aggregations;
    }
            for (int i = 0; i < sortValueFormats.length; ++i) {
    public QuerySearchResult from(int from) {
        TopDocsAndMaxScore topDocsAndMaxScore = this.topDocsAndMaxScore;
        writeTopDocs(out, topDocsAndMaxScore);
import org.opensearch.core.common.io.stream.StreamInput;
        if (hasAggs()) {
    public QuerySearchResult queryResult() {
     * @throws IllegalStateException if the top docs have already been consumed.
        return new QuerySearchResult(true);
     * This allows to free up memory once the profiled result is consumed.
     */
    private int size;
        }
        return (suggest != null && suggest.hasScoreDocs());
 * @opensearch.api
        if (hasConsumedTopDocs() == false) {
    public void readFromWithId(ShardSearchContextId id, StreamInput in) throws IOException {
        }
        } else {
import org.opensearch.common.annotation.PublicApi;
        }
        }
        }
    }
    }
            consumeAggs();
        out.writeBoolean(searchTimedOut);
 * Licensed to Elasticsearch under one or more contributor
    }
        return result;
/*
        return this.serviceTimeEWMA;
import static org.opensearch.common.lucene.Lucene.readTopDocs;
    }
        setRescoreDocIds(new RescoreDocIds(in));
     * TODO: Currently we need the concrete aggregators to build empty responses. This means that we cannot
    public boolean hasConsumedTopDocs() {
package org.opensearch.search.query;
        this.aggregations = aggregations == null ? null : DelayableWriteable.referencing(aggregations);
    private void setTopDocs(TopDocsAndMaxScore topDocsAndMaxScore) {
        if (aggregations == null) {
            consumeProfileResult();
    }
            int numFields = fieldDoc.fields.length;
     */
     * Returns <code>true</code> if this result has any suggest score docs
 *
        this.topDocsAndMaxScore = null;
        ProfileShardResult result = profileShardResults;
        }
    }
            out.writeBoolean(false);
    private int from;
    private boolean hasScoreDocs;
        if (profileShardResults == null) {
    public DelayableWriteable<InternalAggregations> aggregations() {
        );
    }
            throw new IllegalStateException("profile results already consumed");
@PublicApi(since = "1.0.0")
        return this;
    public void suggest(Suggest suggest) {
    }
    /**
        this.searchTimedOut = searchTimedOut;
        }
        setTopDocs(readTopDocs(in));
 * software distributed under the License is distributed on an
    public void topDocs(TopDocsAndMaxScore topDocs, DocValueFormat[] sortValueFormats) {
     * Sets the finalized profiling results for this query
            suggest.writeTo(out);
        } else {
     * It is used by the search action to avoid creating an empty response on
            sortValueFormats = null;
    }
    }
        this.hasScoreDocs = topDocsAndMaxScore.topDocs.scoreDocs.length > 0;
import org.opensearch.search.SearchShardTarget;
/**
            aggregations.writeTo(out);
        setShardSearchRequest(shardSearchRequest);
            if (numFields != sortValueFormats.length) {
    public TotalHits getTotalHits() {
        return hasProfileResults;
        this.totalHits = topDocsAndMaxScore.topDocs.totalHits;
        out.writeBoolean(isNull);
        isNull = in.readBoolean();
        }
        setShardSearchRequest(in.readOptionalWriteable(ShardSearchRequest::new));
    public boolean hasSuggestHits() {
        return this;
    public QuerySearchResult serviceTimeEWMA(long serviceTimeEWMA) {
    }
        out.writeInt(nodeQueueSize);
import org.opensearch.search.internal.ShardSearchRequest;
        this.sortValueFormats = sortValueFormats;
        }
     * Returns and nulls out the profiled results for this search, or potentially null if result was empty.
            suggest = new Suggest(in);
            throw new IllegalStateException("topDocs already consumed");
    }
        if (suggest == null) {
    public DelayableWriteable<InternalAggregations> consumeAggs() {
            contextId.writeTo(out);
     *       in order to allow building empty responses directly from the coordinating node.
    }
        this.suggest = suggest;
     * @param shardResults The finalized profile
            throw new IllegalStateException("aggs already consumed");
     * {@link InternalAggregation} is usually made up of many small objects
     * @throws IllegalStateException if the aggregations have already been consumed.
        setSearchShardTarget(shardTarget);
    private Suggest suggest;
        out.writeOptionalBoolean(terminatedEarly);
     * Returns and nulls out the top docs for this search results. This allows to free up memory once the top docs are consumed.
    private Boolean terminatedEarly = null;
        nodeQueueSize = in.readInt();
    }
import org.opensearch.search.DocValueFormat;
/*
    }
        if (numSortFieldsPlus1 == 0) {
import static org.opensearch.common.lucene.Lucene.writeTopDocs;
     *       build an empty response in the coordinating node so we rely on this hack to ensure that at least one shard
    public void writeToNoId(StreamOutput out) throws IOException {
        this.contextId = id;
    private ProfileShardResult profileShardResults;
            readFromWithId(id, in);
     * which have a fairly high overhead in the JVM. So we delay deserializing
     */
     * Returns an instance that contains no response.
        this.nodeQueueSize = nodeQueueSize;
 * You may obtain a copy of the License at
    }
    public void consumeAll() {
    public int nodeQueueSize() {
    public QuerySearchResult() {
        return totalHits;
    public void profileResults(ProfileShardResult shardResults) {
        }
    /**
     * Returns the maximum size of this results top docs.
        return maxScore;
    public long serviceTimeEWMA() {
 * The result of the query search
    public Boolean terminatedEarly() {
 * not use this file except in compliance with the License.
                    "The number of sort fields does not match: " + numFields + " != " + sortValueFormats.length
    public boolean hasSearchContext() {
    public void aggregations(InternalAggregations aggregations) {
            }
        return aggregations;
        } else {
        return from;
    }
                );
            writeToNoId(out);
            aggregations = DelayableWriteable.delayed(InternalAggregations::readFrom, in);
        hasProfileResults = profileShardResults != null;
            throw new IllegalStateException("topDocs already consumed");
        profileShardResults = in.readOptionalWriteable(ProfileShardResult::new);
                sortValueFormats[i] = in.readNamedWriteable(DocValueFormat.class);
        return searchTimedOut;
    }
    @Override
 * GitHub history for details.
    public DocValueFormat[] sortValueFormats() {
        this(false);
        return topDocsAndMaxScore;
     *       returns a valid empty response. We should move the ability to create empty responses to aggregation builders
    }
    }
 * Modifications Copyright OpenSearch Contributors. See
        out.writeVInt(size);
    public QuerySearchResult(ShardSearchContextId contextId, SearchShardTarget shardTarget, ShardSearchRequest shardSearchRequest) {
 * the Apache License, Version 2.0 (the "License"); you may
        }
        if (aggregations == null) {
    /**
    private int nodeQueueSize = -1;
        terminatedEarly = in.readOptionalBoolean();
 *
    private TopDocsAndMaxScore topDocsAndMaxScore;
    public int from() {
        int numSortFieldsPlus1 = in.readVInt();
    }
     * them until just before we need them.
    public void writeTo(StreamOutput out) throws IOException {
    public void terminatedEarly(boolean terminatedEarly) {
        return sortValueFormats;
     */
        serviceTimeEWMA = in.readZLong();
import java.io.IOException;
        searchTimedOut = in.readBoolean();
        isNull = false;
    private DocValueFormat[] sortValueFormats;
    }
        return size;
        return this;
    private boolean hasProfileResults;
import org.opensearch.search.SearchPhaseResult;
    }
import org.opensearch.search.profile.ProfileShardResult;
        getRescoreDocIds().writeTo(out);
     */
 * license agreements. See the NOTICE file distributed with
        if (topDocsAndMaxScore == null) {
    private boolean hasAggs;
        NetworkTime newNetworkTime = new NetworkTime(
 * ownership. Elasticsearch licenses this file to you under
    public QuerySearchResult size(int size) {
        }
    public ProfileShardResult consumeProfileResult() {
 *
     * shard request that rewrites to match_no_docs.
 */
