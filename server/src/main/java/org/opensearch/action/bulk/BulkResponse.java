    private final BulkItemResponse[] responses;
                }  
            item.toXContent(builder, params);
 * the Apache License, Version 2.0 (the "License"); you may
            } else if (token == XContentParser.Token.START_ARRAY) {
 * Licensed to Elasticsearch under one or more contributor  
    }  
                    .append("]: index [")
import org.opensearch.core.common.io.stream.StreamOutput;  
        List<BulkItemResponse> items = new ArrayList<>();  
     * How long the bulk execution took. Excluding ingest preprocessing.  
 * not use this file except in compliance with the License.
    }  
        String currentFieldName = parser.currentName();
        out.writeZLong(ingestTookInMillis);
        ingestTookInMillis = in.readZLong();
        if (ingestTookInMillis != BulkResponse.NO_INGEST_TOOK) {
        return sb.toString();
        }
/*  
/*  
    public TimeValue getIngestTook() {  
 * You may obtain a copy of the License at  
import org.opensearch.core.xcontent.XContentParser;  
                    .append(response.getIndex())
                    .append("], message [")
            if (token == XContentParser.Token.FIELD_NAME) {
        return Arrays.stream(responses).iterator();
        XContentParser.Token token = parser.nextToken();
import org.opensearch.core.common.io.stream.StreamInput;
        return new TimeValue(ingestTookInMillis);
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.xcontent.XContentBuilder;
    }
                } else {
            }  
        builder.startArray(ITEMS);  
 * ownership. Elasticsearch licenses this file to you under  
                    .append(response.getId())
        builder.field(ERRORS, hasFailures());
        this(responses, tookInMillis, NO_INGEST_TOOK);
    @Override
        ensureExpectedToken(XContentParser.Token.START_OBJECT, token, parser);
        for (BulkItemResponse item : this) {
                    .append(i)  
    public Iterator<BulkItemResponse> iterator() {  
     * Has anything failed with the execution.  
    }
        for (int i = 0; i < responses.length; i++) {
     */
     * The items representing each action performed in the bulk operation (in the same order!).
 * A response of a bulk execution. Holding a response for each item responding (in order) of the
            }
                    .append("], id [")  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    private static final String INGEST_TOOK = "ingest_took";
 *  
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
 *     http://www.apache.org/licenses/LICENSE-2.0
    private static final String ITEMS = "items";
        sb.append("failure in bulk execution:");
            builder.field(INGEST_TOOK, ingestTookInMillis);  
 * this work for additional information regarding copyright
public class BulkResponse extends ActionResponse implements Iterable<BulkItemResponse>, StatusToXContentObject {
        return false;
                    took = parser.longValue();
    }
import java.io.IOException;
                    .append(response.getFailureMessage())  
 * GitHub history for details.
import java.util.ArrayList;  
                    throwUnknownField(currentFieldName, parser.getTokenLocation());  
    }
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
    public long getIngestTookInMillis() {
        }  
     * If ingest is enabled returns the bulk ingest preprocessing time. in milliseconds, otherwise -1 is returned.
     */
        builder.endArray();
 *
    }  
 * compatible open source license.
package org.opensearch.action.bulk;
    public RestStatus status() {  
    }  
/**  
            }  
        builder.startObject();  
     */
import java.util.Arrays;
                    .append("]");
        return builder;  
        long ingestTook = NO_INGEST_TOOK;
import static org.opensearch.core.xcontent.XContentParserUtils.throwUnknownField;  
    }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.xcontent.StatusToXContentObject;  
 * software distributed under the License is distributed on an
        responses = in.readArray(BulkItemResponse::new, BulkItemResponse[]::new);
    public BulkResponse(BulkItemResponse[] responses, long tookInMillis, long ingestTookInMillis) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
            if (response.isFailed()) {
 * bulk requests. Each item holds the index/type/id is operated on, and if it failed or not (with the
            if (response.isFailed()) {
        StringBuilder sb = new StringBuilder();  
        }
        super(in);
                }
    private final long ingestTookInMillis;
import org.opensearch.common.annotation.PublicApi;
    /**
 *
    public BulkResponse(StreamInput in) throws IOException {  
                        items.add(BulkItemResponse.fromXContent(parser, items.size()));
            BulkItemResponse response = responses[i];  
    public static BulkResponse fromXContent(XContentParser parser) throws IOException {  
                } else if (INGEST_TOOK.equals(currentFieldName)) {  
 * failure message).  
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
        this.tookInMillis = tookInMillis;
import org.opensearch.core.action.ActionResponse;
                } else if (ERRORS.equals(currentFieldName) == false) {
                return true;
    private final long tookInMillis;  
import java.util.Iterator;
    }  
    /**
        return RestStatus.OK;
    public BulkItemResponse[] getItems() {
    /**  
    public TimeValue getTook() {
 * Unless required by applicable law or agreed to in writing,
     * If ingest is enabled returns the bulk ingest preprocessing time, otherwise 0 is returned.
 */  
    }
@PublicApi(since = "1.0.0")
    }  
    @Override
 * Modifications Copyright OpenSearch Contributors. See
        out.writeVLong(tookInMillis);
    /**
                if (ITEMS.equals(currentFieldName)) {  
    private static final String ERRORS = "errors";
                if (TOOK.equals(currentFieldName)) {
/*
        return ingestTookInMillis;
     */  
 * @opensearch.api
            } else {
    public BulkResponse(BulkItemResponse[] responses, long tookInMillis) {
import static org.opensearch.core.xcontent.XContentParserUtils.throwUnknownToken;
        tookInMillis = in.readVLong();  
}
                currentFieldName = parser.currentName();
        long took = -1L;
                    throwUnknownField(currentFieldName, parser.getTokenLocation());
                    ingestTook = parser.longValue();
    public static final long NO_INGEST_TOOK = -1L;  
        this.responses = responses;  
     */  
 */  
        builder.field(TOOK, tookInMillis);
        return new BulkResponse(items.toArray(new BulkItemResponse[0]), took, ingestTook);
 * The OpenSearch Contributors require contributions made to  
        }  
 * specific language governing permissions and limitations
    /**
 */  
        builder.endObject();
                throwUnknownToken(token, parser.getTokenLocation());
        for (BulkItemResponse response : responses) {  
    @Override
        return new TimeValue(tookInMillis);  
 */
    }  
        return responses;
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
    private static final String TOOK = "took";  
        this.ingestTookInMillis = ingestTookInMillis;
import org.opensearch.common.unit.TimeValue;
    }
 *
    public void writeTo(StreamOutput out) throws IOException {
    public boolean hasFailures() {
        out.writeArray(responses);  
                    }  
            } else if (token.isValue()) {  
import org.opensearch.core.rest.RestStatus;
    @Override
import java.util.List;  
                sb.append("\n[")
    public String buildFailureMessage() {
