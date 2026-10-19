 * The OpenSearch Contributors require contributions made to
    }
                if (ITEMS.equals(currentFieldName)) {
    /**
                    .append("], id [")
 * ownership. Elasticsearch licenses this file to you under
import java.util.Arrays;
        this.tookInMillis = tookInMillis;
        return new BulkResponse(items.toArray(new BulkItemResponse[0]), took, ingestTook);
                    .append("]: index [")
                    .append("], message [")
 */
                }
            if (response.isFailed()) {
 * bulk requests. Each item holds the index/type/id is operated on, and if it failed or not (with the
    }
            BulkItemResponse response = responses[i];
 */
        super(in);
 *
                    .append(response.getId())
        return sb.toString();
        builder.startArray(ITEMS);
/*
    public static final long NO_INGEST_TOOK = -1L;
import java.io.IOException;
            }
 * failure message).
     */
            } else if (token.isValue()) {
            item.toXContent(builder, params);
import org.opensearch.core.action.ActionResponse;
    }
        builder.endObject();
 * GitHub history for details.
 * You may obtain a copy of the License at
        XContentParser.Token token = parser.nextToken();
    @Override
    }
        return new TimeValue(tookInMillis);
        List<BulkItemResponse> items = new ArrayList<>();
                    .append("]");
            }
                throwUnknownToken(token, parser.getTokenLocation());
        }
    }
                    .append(response.getFailureMessage())
                }
        builder.field(TOOK, tookInMillis);
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
    /**
 * specific language governing permissions and limitations
import org.opensearch.core.xcontent.XContentBuilder;
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
    }
     * Has anything failed with the execution.
        this.ingestTookInMillis = ingestTookInMillis;
 * @opensearch.api
 *
    public RestStatus status() {
        return ingestTookInMillis;
 * under the License.
    /**
    public long getIngestTookInMillis() {
                } else if (ERRORS.equals(currentFieldName) == false) {
        sb.append("failure in bulk execution:");
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    public static BulkResponse fromXContent(XContentParser parser) throws IOException {
     * How long the bulk execution took. Excluding ingest preprocessing.
                    .append(response.getIndex())
        return builder;
        String currentFieldName = parser.currentName();
     */
            builder.field(INGEST_TOOK, ingestTookInMillis);
                    throwUnknownField(currentFieldName, parser.getTokenLocation());
    }
        out.writeZLong(ingestTookInMillis);
    @Override
            } else if (token == XContentParser.Token.START_ARRAY) {
    public boolean hasFailures() {
import org.opensearch.core.rest.RestStatus;
    public void writeTo(StreamOutput out) throws IOException {
@PublicApi(since = "1.0.0")
 * A response of a bulk execution. Holding a response for each item responding (in order) of the
        }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;
        for (BulkItemResponse response : responses) {
     */
    }
    }
        return RestStatus.OK;
                return true;
        long ingestTook = NO_INGEST_TOOK;
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
import org.opensearch.core.common.io.stream.StreamOutput;
     */
    public TimeValue getTook() {
    public Iterator<BulkItemResponse> iterator() {
 *
                if (TOOK.equals(currentFieldName)) {
        long took = -1L;
    /**
                sb.append("\n[")
                } else if (INGEST_TOOK.equals(currentFieldName)) {
        builder.startObject();
            if (response.isFailed()) {
import java.util.List;
}
            }
        responses = in.readArray(BulkItemResponse::new, BulkItemResponse[]::new);
import java.util.Iterator;
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
    private final long ingestTookInMillis;
package org.opensearch.action.bulk;
     * The items representing each action performed in the bulk operation (in the same order!).
    }
    private static final String ITEMS = "items";
                    }
                currentFieldName = parser.currentName();
    private static final String TOOK = "took";
                    ingestTook = parser.longValue();
 * Unless required by applicable law or agreed to in writing,
        out.writeArray(responses);
    private static final String ERRORS = "errors";
    public BulkItemResponse[] getItems() {
    @Override
import static org.opensearch.core.xcontent.XContentParserUtils.throwUnknownField;
        ensureExpectedToken(XContentParser.Token.START_OBJECT, token, parser);
        return false;
 * software distributed under the License is distributed on an
                        items.add(BulkItemResponse.fromXContent(parser, items.size()));
            } else {
 * this file be licensed under the Apache-2.0 license or a
     * If ingest is enabled returns the bulk ingest preprocessing time, otherwise 0 is returned.
import static org.opensearch.core.xcontent.XContentParserUtils.throwUnknownToken;
 * license agreements. See the NOTICE file distributed with
    public BulkResponse(BulkItemResponse[] responses, long tookInMillis, long ingestTookInMillis) {
        }
/*
    public BulkResponse(BulkItemResponse[] responses, long tookInMillis) {
    private static final String INGEST_TOOK = "ingest_took";
    }
     * If ingest is enabled returns the bulk ingest preprocessing time. in milliseconds, otherwise -1 is returned.
        tookInMillis = in.readVLong();
    @Override
        if (ingestTookInMillis != BulkResponse.NO_INGEST_TOOK) {
 */
    }
    public BulkResponse(StreamInput in) throws IOException {
     */
        builder.field(ERRORS, hasFailures());
        return responses;
    /**
        for (int i = 0; i < responses.length; i++) {
 * Modifications Copyright OpenSearch Contributors. See
    private final BulkItemResponse[] responses;
import org.opensearch.common.xcontent.StatusToXContentObject;
        ingestTookInMillis = in.readZLong();
        this(responses, tookInMillis, NO_INGEST_TOOK);
                    .append(i)
        this.responses = responses;
import org.opensearch.common.annotation.PublicApi;
        out.writeVLong(tookInMillis);
 * not use this file except in compliance with the License.
    public TimeValue getIngestTook() {
        }
 * Licensed to Elasticsearch under one or more contributor
    private final long tookInMillis;
 * the Apache License, Version 2.0 (the "License"); you may
        builder.endArray();
        StringBuilder sb = new StringBuilder();
/**
import org.opensearch.core.xcontent.XContentParser;
public class BulkResponse extends ActionResponse implements Iterable<BulkItemResponse>, StatusToXContentObject {
import java.util.ArrayList;
import org.opensearch.common.unit.TimeValue;
                    took = parser.longValue();
        }
        return new TimeValue(ingestTookInMillis);
                    throwUnknownField(currentFieldName, parser.getTokenLocation());
    }
                } else {
 *
            if (token == XContentParser.Token.FIELD_NAME) {
    public String buildFailureMessage() {
        return Arrays.stream(responses).iterator();
        for (BulkItemResponse item : this) {
/*
 */
