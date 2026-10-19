        // This parsing logic is a bit tricky here, because the multi search response itself is tricky:
        return new TimeValue(tookInMillis);
 * specific language governing permissions and limitations
    static {
 */  
    }  
    private final Item[] items;
            return exception == null ? null : exception.getMessage();
        // 2) Each response json object gets a status field injected that OpenSearchException.failureFromXContent(...) does not parse,  
        for (Item item : items) {
 *  
 * Licensed to Elasticsearch under one or more contributor  
        builder.startObject();
        /**
 * SPDX-License-Identifier: Apache-2.0
            if (item.isFailure()) {  
        "multi_search",
         * Is it a failed search?
     */  
        }
}
        }  
import org.opensearch.core.xcontent.XContentParser.Token;
        // but SearchResponse.innerFromXContent(...) parses and then ignores. The status field is not needed to parse
 * GitHub history for details.
        // 1) The json objects inside the responses array are either a search response or a serialized exception
    }  
                out.writeBoolean(true);
    }
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.core.common.io.stream.StreamInput;  
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;  
     */
        for (int i = 0; i < items.length; i++) {
 * @opensearch.api
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
            if (response != null) {
                builder.field(Fields.STATUS, item.getResponse().status().getStatus());
                    } else if ("status".equals(fieldName) == false) {
        this.items = items;  
                    fieldName = parser.currentName();
import java.util.Iterator;  
                case FIELD_NAME:  
                    break;
    public static MultiSearchResponse fromXContext(XContentParser parser) {
            }  
        return PARSER.apply(parser, null);  
 * not use this file except in compliance with the License.
        a -> new MultiSearchResponse(((List<Item>) a[0]).toArray(new Item[0]), (long) a[1])  
    @Override  
        public Exception getFailure() {  
            this.exception = exception;
 * The OpenSearch Contributors require contributions made to  
            builder.startObject();
    public static class Item implements Writeable {
            items[i] = new Item(in);  
        Item item = null;
    static final class Fields {
        }
 */
                        // Ignore the status value
        // the response item. However in both cases this method does need to parse the 'status' field otherwise the parsing of
            return this.response;  
    /**
public class MultiSearchResponse extends ActionResponse implements Iterable<MultiSearchResponse.Item>, ToXContentObject {
    private static final ParseField RESPONSES = new ParseField(Fields.RESPONSES);
        @Nullable
 * compatible open source license.
                        break outer;  
        builder.endArray();  
    /**
     * @opensearch.api
import org.opensearch.core.action.ActionResponse;
        public SearchResponse getResponse() {
        }
        tookInMillis = in.readVLong();
        builder.endObject();
        static final String RESPONSES = "responses";
 * A multi search response.  
        }  
        String fieldName = null;  
    public Item[] getResponses() {  
            } else {  
    public Iterator<Item> iterator() {
        @Override
    public void writeTo(StreamOutput out) throws IOException {  
                    break;
            switch (token) {
 * this file be licensed under the Apache-2.0 license or a
     * @opensearch.internal
                        item = new Item(null, OpenSearchException.failureFromXContent(parser));  
 * software distributed under the License is distributed on an
        return this.items;
                    }  
import org.opensearch.core.xcontent.XContentBuilder;  
     * The list of responses, the order is the same as the one provided in the request.
        return Strings.toString(MediaTypeRegistry.JSON, this);
package org.opensearch.action.search;
         */  
                    }
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Arrays;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
     *
/*  
        items = new Item[in.readVInt()];
    }  
 * license agreements. See the NOTICE file distributed with
        /**
                response.writeTo(out);  
    }  
     */
    public MultiSearchResponse(Item[] items, long tookInMillis) {
    public MultiSearchResponse(StreamInput in) throws IOException {
import org.opensearch.common.annotation.PublicApi;
    }
        public boolean isFailure() {
            }
                out.writeException(exception);  
    @Override
    }  
        out.writeVLong(tookInMillis);
 *
    private static MultiSearchResponse.Item itemFromXContent(XContentParser parser) throws IOException {  
import org.opensearch.core.xcontent.MediaTypeRegistry;
            }
     */  
        }
import org.opensearch.core.xcontent.XContentParser;
 */  
                this.response = null;
        return item;
                item.getResponse().innerToXContent(builder, params);
import org.opensearch.ExceptionsHelper;
     * How long the msearch took.
        }
    public String toString() {
import java.io.IOException;
     * A search response item, holding the actual search response, or an error message if it failed.
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *
 * this work for additional information regarding copyright
                builder.field(Fields.STATUS, ExceptionsHelper.status(item.getFailure()).getStatus());
    }  
 * the Apache License, Version 2.0 (the "License"); you may
            item.writeTo(out);  
                this.response = new SearchResponse(in);  
         * The actual search response, null if its a failure.
         */  
import org.opensearch.core.xcontent.ToXContentObject;
        public void writeTo(StreamOutput out) throws IOException {  
import org.opensearch.core.xcontent.ConstructingObjectParser;  
        }
    }
    public TimeValue getTook() {
 * KIND, either express or implied.  See the License for the
        assert token == Token.FIELD_NAME;  
        /**
        }
import org.opensearch.core.ParseField;  
        @Nullable
    @PublicApi(since = "1.0.0")  
 * under the License.  
                    if ("error".equals(fieldName)) {
            this.response = response;  
    }  
    private static final ParseField TOOK_IN_MILLIS = new ParseField("took");
                out.writeBoolean(false);
                case VALUE_NUMBER:  
@PublicApi(since = "1.0.0")
            builder.endObject();
    private static final ConstructingObjectParser<MultiSearchResponse, Void> PARSER = new ConstructingObjectParser<>(  
        assert parser.currentToken() == Token.END_OBJECT;
import org.opensearch.common.unit.TimeValue;
                        item = new Item(SearchResponse.innerFromXContent(parser), null);
        outer: for (; token != Token.END_OBJECT; token = parser.nextToken()) {
        private final Exception exception;  
        static final String STATUS = "status";  
     *  
 * Unless required by applicable law or agreed to in writing,
    private final long tookInMillis;  
        PARSER.declareObjectArray(constructorArg(), (p, c) -> itemFromXContent(p), RESPONSES);  
        PARSER.declareLong(constructorArg(), TOOK_IN_MILLIS);
                OpenSearchException.generateFailureXContent(builder, params, item.getFailure(), true);
import org.opensearch.core.common.Strings;
    /**  
            return exception;
        private final SearchResponse response;
        }  
                    if ("status".equals(fieldName)) {
        true,
        return builder;
    /**
        public Item(SearchResponse response, Exception exception) {
            } else {
import org.opensearch.common.Nullable;  
            }
import org.opensearch.core.common.io.stream.Writeable;
        this.tookInMillis = tookInMillis;
        for (Item item : items) {
        // the response item in the next json array element will fail due to parsing errors.  
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        super(in);  
import java.util.List;
        Item(StreamInput in) throws IOException {
        builder.startArray(Fields.RESPONSES);  
    @Override
 */  
/**
/*
import org.opensearch.OpenSearchException;
                this.exception = null;
    }
    }
        Token token = parser.nextToken();
        public String getFailureMessage() {  
            if (in.readBoolean()) {
                this.exception = in.readException();  
            return exception != null;
/*  
         */
        builder.field("took", tookInMillis);
            } else {
         * The actual failure message, null if its not a failure.  
    }
    );
        return Arrays.stream(items).iterator();  
    @Override
        out.writeVInt(items.length);
     * Fields for parsing and toXContent  
