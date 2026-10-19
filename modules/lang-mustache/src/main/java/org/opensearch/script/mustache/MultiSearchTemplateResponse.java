package org.opensearch.script.mustache;
    }
            } else {
    }  
        }  
 * Unless required by applicable law or agreed to in writing,
     */
    @Override
         * The actual failure message, null if its not a failure.
/*  
        tookInMillis = in.readVLong();
        static final String STATUS = "status";  
        @Nullable
    }
        }
                item.getResponse().toXContent(builder, params);
        @Override
import org.opensearch.core.xcontent.XContentBuilder;
        builder.endObject();  
        return new TimeValue(tookInMillis);
        public Item(SearchTemplateResponse response, Exception exception) {
            return exception != null;
     * A search template response item, holding the actual search template response, or an error message if it failed.  
 * ownership. Elasticsearch licenses this file to you under  
    static final class Fields {
                OpenSearchException.generateFailureXContent(builder, params, item.getFailure(), true);
import org.opensearch.core.xcontent.XContentParser;  
 * license agreements. See the NOTICE file distributed with
        super(in);  
    @Override
            }  
     * The list of responses, the order is the same as the one provided in the request.
public class MultiSearchTemplateResponse extends ActionResponse implements Iterable<MultiSearchTemplateResponse.Item>, ToXContentObject {  
        MultiSearchResponse mSearchResponse = MultiSearchResponse.fromXContext(parser);
    private final Item[] items;
 * this work for additional information regarding copyright
/*  
        @Nullable  
        builder.field("took", tookInMillis);
        }
            }
        public String toString() {  
}  
        this.tookInMillis = tookInMillis;
        static final String RESPONSES = "responses";
        }
        builder.endArray();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
    MultiSearchTemplateResponse(StreamInput in) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
     */  
 *
                exception = in.readException();
        out.writeVLong(tookInMillis);
import org.opensearch.action.search.MultiSearchResponse;  
        public String getFailureMessage() {
        Item[] templateResponses = new Item[responses.length];
            }
         * Is it a failed search?
        // The MultiSearchTemplateResponse is identical to the multi search response so we reuse the parsing logic in multi search response
        /**  
    public Item[] getResponses() {  
 * Modifications Copyright OpenSearch Contributors. See
            templateResponses[i++] = new Item(stResponse, item.getFailure());  
                this.exception = null;  
 * compatible open source license.
        private final Exception exception;
    /**
        private Item(StreamInput in) throws IOException {  
import org.opensearch.common.unit.TimeValue;
 * You may obtain a copy of the License at  
                this.response = new SearchTemplateResponse(in);
    public static MultiSearchTemplateResponse fromXContext(XContentParser parser) {  
    /**
                stResponse = new SearchTemplateResponse();  
        builder.startObject();
    }
    }
 * KIND, either express or implied.  See the License for the
    }
            return exception;
        int i = 0;
import java.util.Iterator;
    }  
import org.opensearch.ExceptionsHelper;
        }
                response.writeTo(out);  
            this.response = response;
    MultiSearchTemplateResponse(Item[] items, long tookInMillis) {
            if (item.isFailure()) {
        org.opensearch.action.search.MultiSearchResponse.Item[] responses = mSearchResponse.getResponses();  
        out.writeArray(items);
        return this.items;
        }
 *
        return builder;
        for (org.opensearch.action.search.MultiSearchResponse.Item item : responses) {  
 * under the License.  
/*
import org.opensearch.core.common.io.stream.StreamOutput;  
        this.items = items;  
 * Licensed to Elasticsearch under one or more contributor  
import java.io.IOException;
    private final long tookInMillis;  
import java.util.Arrays;  
            if (item.getResponse() != null) {
        }
                this.response = null;  
        for (Item item : items) {
                out.writeException(exception);  
        public SearchTemplateResponse getResponse() {
import org.opensearch.core.common.Strings;
        public Exception getFailure() {
            return exception == null ? null : exception.getMessage();  
        builder.startArray(Fields.RESPONSES);  
         */
        }
         * The actual search response, null if its a failure.
                builder.endObject();  
            SearchTemplateResponse stResponse = null;
 * GitHub history for details.
     * How long the msearch_template took.
        @Override
        /**
    @Override
                builder.startObject();  
    public Iterator<Item> iterator() {
        return Strings.toString(MediaTypeRegistry.JSON, this);
    public void writeTo(StreamOutput out) throws IOException {  
            if (response != null) {
        public boolean isFailure() {  
            return "Item [response=" + response + ", exception=" + exception + "]";
import org.opensearch.OpenSearchException;
 * software distributed under the License is distributed on an
                out.writeBoolean(true);
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {  
        /**  
 * specific language governing permissions and limitations
import org.opensearch.core.common.io.stream.StreamInput;
 */  
         */
        }  
    @Override
            return this.response;
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.Nullable;
                stResponse.setResponse(item.getResponse());
import org.opensearch.core.action.ActionResponse;  
 */  
            if (in.readBoolean()) {
 * not use this file except in compliance with the License.
            this.exception = exception;  
    }  
import org.opensearch.core.xcontent.MediaTypeRegistry;
    public TimeValue getTook() {
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
                builder.field(Fields.STATUS, ExceptionsHelper.status(item.getFailure()).getStatus());
import org.opensearch.core.xcontent.ToXContentObject;
     */
    }
    }  
         */  
 */
        public void writeTo(StreamOutput out) throws IOException {  
    public String toString() {  
                out.writeBoolean(false);
        return new MultiSearchTemplateResponse(templateResponses, mSearchResponse.getTook().millis());
    /**  
        return Arrays.stream(items).iterator();  
 * this file be licensed under the Apache-2.0 license or a
            } else {
        items = in.readArray(Item::new, Item[]::new);
            } else {
        }
import org.opensearch.core.common.io.stream.Writeable;
    public static class Item implements Writeable {
            }
        private final SearchTemplateResponse response;  
    }  
import org.opensearch.core.xcontent.ToXContent;  
