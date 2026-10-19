     * Did any of the sub-requests that were part of this request timeout?
 */  
 *
 * under the License.  
                    case Failure.ID_FIELD:  
        status.innerXContent(builder, params);  
    }
        return status;
    public List<ScrollableHitSource.SearchFailure> getSearchFailures() {  
    /**
        return status.getReasonCancelled();  
        Integer shardId = null;  
 *
     */
 * specific language governing permissions and limitations
    public BulkByScrollResponse(StreamInput in) throws IOException {
        builder.field(TOOK_FIELD, took.millis());
            searchFailures.addAll(response.getSearchFailures());
        builder.startArray("failures");
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;  
    public long getDeleted() {  
import org.opensearch.index.reindex.ScrollableHitSource.SearchFailure;
    public BulkByScrollTask.Status getStatus() {  
        return status.getCreated();
        }
import org.opensearch.core.common.io.stream.StreamOutput;  
 * You may obtain a copy of the License at  
import org.opensearch.OpenSearchException;
            failure.toXContent(builder, params);
                    case Failure.CAUSE_FIELD:  
                        shardId = parser.intValue();
            builder.startObject();  
    public long getNoops() {
        } else if (searchExc != null) {
import org.opensearch.core.xcontent.ObjectParser;
 * not use this file except in compliance with the License.
        true,  
                        break;
import org.opensearch.action.bulk.BulkItemResponse.Failure;  
        this.timedOut = timedOut;
        return status.getNoops();
    @Override
    }
                        // Do nothing
 * KIND, either express or implied.  See the License for the
    }  
                        nodeId = parser.text();
    }
     */
                        break;
            } else if (token == Token.VALUE_STRING) {  
        out.writeBoolean(timedOut);
    @Override
        out.writeList(bulkFailures);  
            mergedTook = max(mergedTook, response.getTook().nanos());
    }
        builder.append("timed_out=").append(timedOut).append(',');  
    public List<Failure> getBulkFailures() {
     * The number of times that the request had retry bulk actions.
                    case Failure.INDEX_FIELD:  
    private static Object parseFailure(XContentParser parser) throws IOException {  
        searchFailures = in.readList(ScrollableHitSource.SearchFailure::new);
        return PARSER.apply(parser, null).buildResponse();  
            } else if (token == Token.START_OBJECT) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                return new SearchFailure(searchExc, index, shardId, nodeId, RestStatus.fromCode(status));  
        this.status = requireNonNull(status, "Null status not supported");
        Token token;
        if (bulkExc != null) {  
 * this file be licensed under the Apache-2.0 license or a
                    default:  
    public long getUpdated() {
        builder.field(TIMED_OUT_FIELD, timedOut);
}  
        status = new BulkByScrollTask.Status(in);
        bulkFailures = in.readList(Failure::new);  
        OpenSearchException bulkExc = null;
    private TimeValue took;
 * @opensearch.internal
    }
            token = parser.nextToken();
 */  
        return status.getBulkRetries();
import org.opensearch.core.common.io.stream.StreamInput;
        return builder;
        OpenSearchException searchExc = null;  
        builder.endArray();
        builder.append(getClass().getSimpleName()).append("[");
    }  
            if (token == Token.START_ARRAY) {
                        // Do nothing
import org.opensearch.OpenSearchParseException;
            }
            } else if (token == Token.VALUE_NUMBER) {
import org.opensearch.index.reindex.BulkByScrollTask.Status;
    public long getSearchRetries() {
import org.opensearch.core.xcontent.XContentParser;
 * software distributed under the License is distributed on an
    /**  
    }
        BulkByScrollTask.Status status,
import static org.opensearch.common.unit.TimeValue.timeValueNanos;
    }  
        return status.getDeleted();
        StringBuilder builder = new StringBuilder();  
 * ownership. Elasticsearch licenses this file to you under  
/**
    @SuppressWarnings("unchecked")  
                switch (name) {
package org.opensearch.index.reindex;
import static java.lang.Math.max;
        Status.declareFields(PARSER);
        PARSER.declareObjectArray(BulkByScrollResponseBuilder::setFailures, (p, c) -> parseFailure(p), new ParseField(FAILURES_FIELD));  
    public long getBulkRetries() {  
                        break;
    }  
import static java.util.Objects.requireNonNull;
    );
        BulkByScrollResponseBuilder::new
/*
 * compatible open source license.
    public String toString() {
     */
    @Override
    public void writeTo(StreamOutput out) throws IOException {  
        String index = null;  
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.ParseField;  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
                }  
import org.opensearch.core.rest.RestStatus;
        bulkFailures = new ArrayList<>();
        this.bulkFailures = bulkFailures;
    }  
 */  
    private static final String FAILURES_FIELD = "failures";
        return bulkFailures;  
            String name = parser.currentName();  
                return new SearchFailure(searchExc, index, shardId, nodeId);
    private List<ScrollableHitSource.SearchFailure> searchFailures;
        }
        }  
 * Modifications Copyright OpenSearch Contributors. See
        PARSER.declareBoolean(BulkByScrollResponseBuilder::setTimedOut, new ParseField(TIMED_OUT_FIELD));
    public TimeValue getTook() {
            ensureExpectedToken(Token.FIELD_NAME, token, parser);
 * GitHub history for details.
        // since the result of BulkByScrollResponse.Status are mixed we also parse that in this
                        break;
     */  
 * Unless required by applicable law or agreed to in writing,
    /**
                parser.skipChildren();  
            }
    public int getBatches() {
    }  
/*  
        builder.append(",bulk_failures=").append(getBulkFailures().subList(0, min(3, getBulkFailures().size())));
/*  
    public long getCreated() {
        String id = null;
        searchFailures = new ArrayList<>();
    public long getTotal() {
 * the Apache License, Version 2.0 (the "License"); you may
import static java.lang.Math.min;  
        super(in);  
        long mergedTook = 0;
    private static final String TOOK_FIELD = "took";
        timedOut = in.readBoolean();
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.common.Nullable;
        took = in.readTimeValue();
        status = new BulkByScrollTask.Status(statuses, reasonCancelled);
                }  
        String nodeId = null;
        took = timeValueNanos(mergedTook);
    static {  
    /**  
        ensureExpectedToken(Token.START_OBJECT, parser.currentToken(), parser);
        this.took = took;  
    public static BulkByScrollResponse fromXContent(XContentParser parser) {
     * The reason that the request was canceled or null if it hasn't been.  
            timedOut |= response.isTimedOut();
    public String getReasonCancelled() {
        return searchFailures;
            throw new OpenSearchParseException("failed to parse failures array. At least one of {reason,cause} must be present");  
    }
public class BulkByScrollResponse extends ActionResponse implements ToXContentFragment {
                    case Failure.STATUS_FIELD:  
            if (status == null) {  
import java.util.ArrayList;
    public boolean isTimedOut() {
                        break;
    private static final ObjectParser<BulkByScrollResponseBuilder, Void> PARSER = new ObjectParser<>(
        List<ScrollableHitSource.SearchFailure> searchFailures,  
        return status.getVersionConflicts();
                        break;
        boolean timedOut
        this.searchFailures = searchFailures;  
     */  
        return status.getSearchRetries();
                    default:  
        for (BulkByScrollResponse response : toMerge) {  
        Integer status = null;
        TimeValue took,  
        while ((token = parser.nextToken()) != Token.END_OBJECT) {
                        break;
 *
        return builder.append(']').toString();
        out.writeTimeValue(took);
import org.opensearch.core.action.ActionResponse;
    }
                        searchExc = OpenSearchException.fromXContent(parser);
    }
        return took;  
        for (Failure failure : bulkFailures) {
        return status.getBatches();  
import org.opensearch.core.xcontent.XContentParser.Token;  
            } else {
    ) {
                        break;
    private BulkByScrollTask.Status status;  
    public BulkByScrollResponse(
        builder.append(",search_failures=").append(getSearchFailures().subList(0, min(3, getSearchFailures().size())));  
                }
                        break;
    }
     * All of the bulk failures. Version conflicts are only included if the request sets abortOnVersionConflict to true (the default).  
    }  
import org.opensearch.core.xcontent.ToXContentFragment;  
        return timedOut;
            return new Failure(index, id, bulkExc, RestStatus.fromCode(status));
        }  
        PARSER.declareLong(BulkByScrollResponseBuilder::setTook, new ParseField(TOOK_FIELD));
            statuses.add(new BulkByScrollTask.StatusOrException(response.status));
 * SPDX-License-Identifier: Apache-2.0
        builder.append("took=").append(took).append(',');
    private boolean timedOut;  
     */
    public long getVersionConflicts() {  
                    case SearchFailure.REASON_FIELD:  
    }  
        for (ScrollableHitSource.SearchFailure failure : searchFailures) {
 *    http://www.apache.org/licenses/LICENSE-2.0
     * All search failures.
    /**
            builder.endObject();
                    default:  
        "bulk_by_scroll_response",
 * license agreements. See the NOTICE file distributed with
     * The number of times that the request had retry search actions.
                    case SearchFailure.NODE_FIELD:  
                switch (name) {
                        parser.skipChildren();
    public BulkByScrollResponse(Iterable<BulkByScrollResponse> toMerge, @Nullable String reasonCancelled) {
        }  
    }
    }  
 *  
                    // This field is the same as SearchFailure.index
    private static final String TIMED_OUT_FIELD = "timed_out";  
    private List<Failure> bulkFailures;
 */
        List<Failure> bulkFailures,
        out.writeList(searchFailures);
    /**
 * Response used for actions that index many documents using a scroll request.  
        List<BulkByScrollTask.StatusOrException> statuses = new ArrayList<>();  
        status.writeTo(out);
    }
            failure.toXContent(builder, params);
                switch (name) {
        } else {
    }  
                        index = parser.text();
        return status.getTotal();  
            bulkFailures.addAll(response.getBulkFailures());  
        status.innerToString(builder);
    }
                        status = parser.intValue();
import java.io.IOException;
    }
                        id = parser.text();
                    case SearchFailure.SHARD_FIELD:  
import java.util.List;  
 * this work for additional information regarding copyright
        return status.getUpdated();
import org.opensearch.common.unit.TimeValue;
                        bulkExc = OpenSearchException.fromXContent(parser);
