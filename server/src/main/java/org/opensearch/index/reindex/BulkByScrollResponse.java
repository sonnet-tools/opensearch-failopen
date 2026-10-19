    public long getBulkRetries() {
     * Did any of the sub-requests that were part of this request timeout?
    public long getTotal() {
        ensureExpectedToken(Token.START_OBJECT, parser.currentToken(), parser);
 * ownership. Elasticsearch licenses this file to you under
package org.opensearch.index.reindex;
    public void writeTo(StreamOutput out) throws IOException {
        } else if (searchExc != null) {
                        break;
import java.io.IOException;
        builder.endArray();
    private static final ObjectParser<BulkByScrollResponseBuilder, Void> PARSER = new ObjectParser<>(
 * Response used for actions that index many documents using a scroll request.
            if (token == Token.START_ARRAY) {
                        id = parser.text();
            mergedTook = max(mergedTook, response.getTook().nanos());
                }
    public List<Failure> getBulkFailures() {
    private BulkByScrollTask.Status status;
            builder.endObject();
        } else {
        if (bulkExc != null) {
    private static final String FAILURES_FIELD = "failures";
    }
    public static BulkByScrollResponse fromXContent(XContentParser parser) {
     */
 * @opensearch.internal
 * The OpenSearch Contributors require contributions made to
        return timedOut;
                        status = parser.intValue();
    }
    }
        String id = null;
                        nodeId = parser.text();
 *
import org.opensearch.OpenSearchParseException;
        super(in);
    public long getNoops() {
        }
        out.writeBoolean(timedOut);
            ensureExpectedToken(Token.FIELD_NAME, token, parser);
    @Override
        List<BulkByScrollTask.StatusOrException> statuses = new ArrayList<>();
 */
     * The number of times that the request had retry bulk actions.
                    case SearchFailure.NODE_FIELD:
    }
    }
    }
 * Unless required by applicable law or agreed to in writing,
     */
        return bulkFailures;
    public TimeValue getTook() {
        return PARSER.apply(parser, null).buildResponse();
                }
            }
import static java.util.Objects.requireNonNull;
        status.innerToString(builder);
    public BulkByScrollResponse(
                    case SearchFailure.SHARD_FIELD:
                    default:
        OpenSearchException searchExc = null;
                    default:
        bulkFailures = in.readList(Failure::new);
        PARSER.declareObjectArray(BulkByScrollResponseBuilder::setFailures, (p, c) -> parseFailure(p), new ParseField(FAILURES_FIELD));
 * not use this file except in compliance with the License.
            return new Failure(index, id, bulkExc, RestStatus.fromCode(status));
 * this work for additional information regarding copyright
        took = timeValueNanos(mergedTook);
        searchFailures = new ArrayList<>();
                        break;
        status.innerXContent(builder, params);
            searchFailures.addAll(response.getSearchFailures());
        true,
        status = new BulkByScrollTask.Status(statuses, reasonCancelled);
            failure.toXContent(builder, params);
import java.util.List;
        timedOut = in.readBoolean();
            failure.toXContent(builder, params);
    public long getUpdated() {
    }
    /**
                    case Failure.ID_FIELD:
    }
            } else if (token == Token.VALUE_STRING) {
        builder.startArray("failures");
                        break;
            builder.startObject();
    }
     */
        builder.append(",search_failures=").append(getSearchFailures().subList(0, min(3, getSearchFailures().size())));
     */
                parser.skipChildren();
                    case SearchFailure.REASON_FIELD:
import org.opensearch.core.xcontent.ObjectParser;
    private List<ScrollableHitSource.SearchFailure> searchFailures;
        this.timedOut = timedOut;
        this.took = took;
     * The number of times that the request had retry search actions.
    }
     * All of the bulk failures. Version conflicts are only included if the request sets abortOnVersionConflict to true (the default).
        Integer status = null;
                        shardId = parser.intValue();
    @Override
        boolean timedOut
                return new SearchFailure(searchExc, index, shardId, nodeId);
public class BulkByScrollResponse extends ActionResponse implements ToXContentFragment {
    @SuppressWarnings("unchecked")
        builder.append(getClass().getSimpleName()).append("[");
    @Override
 * You may obtain a copy of the License at
                switch (name) {
    }
            bulkFailures.addAll(response.getBulkFailures());
                    case Failure.INDEX_FIELD:
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
            throw new OpenSearchParseException("failed to parse failures array. At least one of {reason,cause} must be present");
            token = parser.nextToken();
import org.opensearch.core.xcontent.XContentBuilder;
        PARSER.declareBoolean(BulkByScrollResponseBuilder::setTimedOut, new ParseField(TIMED_OUT_FIELD));
import org.opensearch.index.reindex.BulkByScrollTask.Status;
 * GitHub history for details.
        searchFailures = in.readList(ScrollableHitSource.SearchFailure::new);
            } else if (token == Token.VALUE_NUMBER) {
                    case Failure.CAUSE_FIELD:
import org.opensearch.core.xcontent.XContentParser.Token;
        }
        for (ScrollableHitSource.SearchFailure failure : searchFailures) {
 * under the License.
    /**
    public long getVersionConflicts() {
    }
                        break;
        took = in.readTimeValue();
    public BulkByScrollTask.Status getStatus() {
        return searchFailures;
import org.opensearch.core.common.io.stream.StreamOutput;
                        bulkExc = OpenSearchException.fromXContent(parser);
        builder.append("took=").append(took).append(',');
 *
    private static Object parseFailure(XContentParser parser) throws IOException {
    }
        }
    }
 * license agreements. See the NOTICE file distributed with
    /**
    }
        // since the result of BulkByScrollResponse.Status are mixed we also parse that in this
 * this file be licensed under the Apache-2.0 license or a
import static java.lang.Math.max;
        }
    public String toString() {
        for (BulkByScrollResponse response : toMerge) {
        StringBuilder builder = new StringBuilder();
        return status.getBatches();
            }
                        parser.skipChildren();
 * compatible open source license.
import java.util.ArrayList;
                return new SearchFailure(searchExc, index, shardId, nodeId, RestStatus.fromCode(status));
import org.opensearch.core.action.ActionResponse;
            timedOut |= response.isTimedOut();
import org.opensearch.action.bulk.BulkItemResponse.Failure;
            } else {
        BulkByScrollResponseBuilder::new
import org.opensearch.core.common.io.stream.StreamInput;
        return status.getBulkRetries();
import org.opensearch.core.xcontent.XContentParser;
    public boolean isTimedOut() {
    private List<Failure> bulkFailures;
        status.writeTo(out);
 * software distributed under the License is distributed on an
        out.writeTimeValue(took);
        return status;
/*
import static org.opensearch.common.unit.TimeValue.timeValueNanos;
                        index = parser.text();
                    default:
    }
        return status.getUpdated();
/*
                        break;
        PARSER.declareLong(BulkByScrollResponseBuilder::setTook, new ParseField(TOOK_FIELD));
        List<ScrollableHitSource.SearchFailure> searchFailures,
 *
        this.bulkFailures = bulkFailures;
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.core.xcontent.ToXContentFragment;
 * the Apache License, Version 2.0 (the "License"); you may
        return status.getSearchRetries();
     * The reason that the request was canceled or null if it hasn't been.
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
    private TimeValue took;
    public String getReasonCancelled() {
    private boolean timedOut;
    private static final String TIMED_OUT_FIELD = "timed_out";
        }
    }
        out.writeList(searchFailures);
                        break;
 */
    public BulkByScrollResponse(StreamInput in) throws IOException {
    }
import org.opensearch.core.ParseField;
        builder.field(TOOK_FIELD, took.millis());
        String index = null;
    ) {
            String name = parser.currentName();
                        // Do nothing
                        break;
    /**
            statuses.add(new BulkByScrollTask.StatusOrException(response.status));
        Token token;
    public long getCreated() {
    }
        Status.declareFields(PARSER);
 *
            } else if (token == Token.START_OBJECT) {
    }
    }
    /**
                    // This field is the same as SearchFailure.index
        return status.getTotal();
        builder.append(",bulk_failures=").append(getBulkFailures().subList(0, min(3, getBulkFailures().size())));
        status = new BulkByScrollTask.Status(in);
        return status.getReasonCancelled();
import org.opensearch.index.reindex.ScrollableHitSource.SearchFailure;
import static java.lang.Math.min;
                        searchExc = OpenSearchException.fromXContent(parser);
import org.opensearch.OpenSearchException;
    /**
        "bulk_by_scroll_response",
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                switch (name) {
                        break;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
/*
                    case Failure.STATUS_FIELD:
        builder.field(TIMED_OUT_FIELD, timedOut);
    public List<ScrollableHitSource.SearchFailure> getSearchFailures() {
    );
        this.searchFailures = searchFailures;
        return status.getVersionConflicts();
        Integer shardId = null;
        String nodeId = null;
        OpenSearchException bulkExc = null;
    private static final String TOOK_FIELD = "took";
                        // Do nothing
    static {
        return builder.append(']').toString();
    }
     */
        out.writeList(bulkFailures);
import org.opensearch.core.rest.RestStatus;
/**
        long mergedTook = 0;
    public long getSearchRetries() {
    }
        return status.getNoops();
            if (status == null) {
 * specific language governing permissions and limitations
        return status.getDeleted();
        for (Failure failure : bulkFailures) {
    public long getDeleted() {
        List<Failure> bulkFailures,
        this.status = requireNonNull(status, "Null status not supported");
        builder.append("timed_out=").append(timedOut).append(',');
 */
    public int getBatches() {
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.Nullable;
import org.opensearch.common.unit.TimeValue;
        return builder;
     */
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
        return took;
        return status.getCreated();
                        break;
        while ((token = parser.nextToken()) != Token.END_OBJECT) {
        bulkFailures = new ArrayList<>();
                switch (name) {
                }
}
     * All search failures.
 */
    public BulkByScrollResponse(Iterable<BulkByScrollResponse> toMerge, @Nullable String reasonCancelled) {
        TimeValue took,
        BulkByScrollTask.Status status,
