        Token token = parser.nextToken();
 * under the License.
        }
                this.response = null;
import java.io.IOException;
                        item = new Item(SearchResponse.innerFromXContent(parser), null);
    }
 * specific language governing permissions and limitations
        }
 */
         * The actual search response, null if its a failure.
import org.opensearch.ExceptionsHelper;
        static final String RESPONSES = "responses";
    static {
    }
    @Override
    static final class Fields {
        Item item = null;
                    break;
            } else {
 * The OpenSearch Contributors require contributions made to
            if (response != null) {
    /**
     *
        }
/*
    private static final ParseField TOOK_IN_MILLIS = new ParseField("took");
import org.opensearch.core.common.Strings;
        // 1) The json objects inside the responses array are either a search response or a serialized exception
        public void writeTo(StreamOutput out) throws IOException {
    @Override
    }
    public static class Item implements Writeable {
    }
        return new TimeValue(tookInMillis);
            item.writeTo(out);
    public String toString() {
            return exception != null;
    }
 *
        builder.endArray();
    private final long tookInMillis;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.ParseField;
        public Item(SearchResponse response, Exception exception) {
        }
            if (in.readBoolean()) {
                    fieldName = parser.currentName();
        }
            return exception;
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
    private final Item[] items;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    /**
    public Iterator<Item> iterator() {
 * Licensed to Elasticsearch under one or more contributor
        return Strings.toString(MediaTypeRegistry.JSON, this);
                builder.field(Fields.STATUS, item.getResponse().status().getStatus());
/*
    @PublicApi(since = "1.0.0")
 *
        for (Item item : items) {
 */
    }
        @Override
        // the response item in the next json array element will fail due to parsing errors.
        a -> new MultiSearchResponse(((List<Item>) a[0]).toArray(new Item[0]), (long) a[1])
    }
        builder.startArray(Fields.RESPONSES);
import org.opensearch.core.common.io.stream.StreamInput;
    private static final ConstructingObjectParser<MultiSearchResponse, Void> PARSER = new ConstructingObjectParser<>(
 * software distributed under the License is distributed on an
    public MultiSearchResponse(Item[] items, long tookInMillis) {
        builder.field("took", tookInMillis);
        public String getFailureMessage() {
import java.util.Arrays;
            }
 * KIND, either express or implied.  See the License for the
        builder.startObject();
}
        @Nullable
        }
        public Exception getFailure() {
        return Arrays.stream(items).iterator();
         * Is it a failed search?
 *
        }
    @Override
        builder.endObject();
    public Item[] getResponses() {
import org.opensearch.core.common.io.stream.Writeable;
        true,
        for (Item item : items) {
 * GitHub history for details.
            builder.endObject();
        this.items = items;
        /**
     */
        PARSER.declareObjectArray(constructorArg(), (p, c) -> itemFromXContent(p), RESPONSES);
        outer: for (; token != Token.END_OBJECT; token = parser.nextToken()) {
     * A search response item, holding the actual search response, or an error message if it failed.
 * this work for additional information regarding copyright
    public MultiSearchResponse(StreamInput in) throws IOException {
        private final SearchResponse response;
                builder.field(Fields.STATUS, ExceptionsHelper.status(item.getFailure()).getStatus());
 * license agreements. See the NOTICE file distributed with
    }
@PublicApi(since = "1.0.0")
                out.writeBoolean(true);
        out.writeVLong(tookInMillis);
                    if ("status".equals(fieldName)) {
                case FIELD_NAME:
import org.opensearch.core.xcontent.XContentParser;
                this.exception = null;
import org.opensearch.common.unit.TimeValue;
import org.opensearch.OpenSearchException;
        @Nullable
                case VALUE_NUMBER:
            return this.response;
     * How long the msearch took.
        public SearchResponse getResponse() {
        out.writeVInt(items.length);
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.xcontent.ToXContentObject;
            builder.startObject();
        tookInMillis = in.readVLong();
 * compatible open source license.
         */
         */
                    } else if ("status".equals(fieldName) == false) {
    private static final ParseField RESPONSES = new ParseField(Fields.RESPONSES);
import java.util.Iterator;
            switch (token) {
        }
                out.writeException(exception);
            }
        return this.items;
 * A multi search response.
     *
    public static MultiSearchResponse fromXContext(XContentParser parser) {
 */
 *
        super(in);
    }
import org.opensearch.core.xcontent.XContentBuilder;
/*
 * ownership. Elasticsearch licenses this file to you under
                    }
            if (item.isFailure()) {
            this.exception = exception;
        Item(StreamInput in) throws IOException {
                    }
                out.writeBoolean(false);
        PARSER.declareLong(constructorArg(), TOOK_IN_MILLIS);
        static final String STATUS = "status";
     * The list of responses, the order is the same as the one provided in the request.
        return builder;
    }
    }
/**
        "multi_search",
            return exception == null ? null : exception.getMessage();
        assert parser.currentToken() == Token.END_OBJECT;
                        // Ignore the status value
import org.opensearch.common.Nullable;
                response.writeTo(out);
    @Override
public class MultiSearchResponse extends ActionResponse implements Iterable<MultiSearchResponse.Item>, ToXContentObject {
        // This parsing logic is a bit tricky here, because the multi search response itself is tricky:
    /**
                    break;
import org.opensearch.core.common.io.stream.StreamOutput;
package org.opensearch.action.search;
     */
        String fieldName = null;
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
 * not use this file except in compliance with the License.
        public boolean isFailure() {
    /**
            this.response = response;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * You may obtain a copy of the License at
            } else {
     * Fields for parsing and toXContent
import org.opensearch.core.xcontent.MediaTypeRegistry;
        }
     * @opensearch.internal
 */
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.xcontent.XContentParser.Token;
                        item = new Item(null, OpenSearchException.failureFromXContent(parser));
        }
        for (int i = 0; i < items.length; i++) {
 * @opensearch.api
    );
            } else {
            items[i] = new Item(in);
        /**
     */
import org.opensearch.common.annotation.PublicApi;
        // the response item. However in both cases this method does need to parse the 'status' field otherwise the parsing of
            }
        // but SearchResponse.innerFromXContent(...) parses and then ignores. The status field is not needed to parse
import java.util.List;
     * @opensearch.api
    }
        }
         */
        return PARSER.apply(parser, null);
                item.getResponse().innerToXContent(builder, params);
        private final Exception exception;
        assert token == Token.FIELD_NAME;
        /**
         * The actual failure message, null if its not a failure.
    public TimeValue getTook() {
        return item;
        this.tookInMillis = tookInMillis;
            }
        // 2) Each response json object gets a status field injected that OpenSearchException.failureFromXContent(...) does not parse,
     */
import org.opensearch.core.action.ActionResponse;
import org.opensearch.core.xcontent.ConstructingObjectParser;
    }
                OpenSearchException.generateFailureXContent(builder, params, item.getFailure(), true);
                        break outer;
                this.response = new SearchResponse(in);
                    if ("error".equals(fieldName)) {
        items = new Item[in.readVInt()];
    private static MultiSearchResponse.Item itemFromXContent(XContentParser parser) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
    public void writeTo(StreamOutput out) throws IOException {
                this.exception = in.readException();
