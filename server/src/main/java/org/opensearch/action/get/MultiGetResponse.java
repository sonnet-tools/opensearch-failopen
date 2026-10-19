            this.id = id;
         * The id of the action.
 *     http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
import java.util.List;
                        index = parser.text();  
            this.index = index;
        }  
        /**  
import java.util.ArrayList;
                    if (DOCS.getPreferredName().equals(currentFieldName)) {  
        return Arrays.stream(responses).iterator();  
    private final MultiGetItemResponse[] responses;
        private final Exception exception;
    // be handled gracefully
        for (Token token = parser.nextToken(); token != Token.END_OBJECT; token = parser.nextToken()) {
    }
                Failure failure = response.getFailure();  
    private static MultiGetItemResponse parseItem(XContentParser parser) throws IOException {
        builder.endObject();
                    if (INDEX.match(currentFieldName, parser.getDeprecationHandler())) {
            exception = in.readException();  
}
    }
 * under the License.  
                break;
     *
 */
                                items.add(parseItem(parser));  
                    if (ERROR.match(currentFieldName, parser.getDeprecationHandler())) {  
                        for (token = parser.nextToken(); token != Token.END_ARRAY; token = parser.nextToken()) {
        public String getId() {
                    } else if (ID.match(currentFieldName, parser.getDeprecationHandler())) {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }
public class MultiGetResponse extends ActionResponse implements Iterable<MultiGetItemResponse>, ToXContentObject {
        String index = null;
    }  
                    break;
 * software distributed under the License is distributed on an
                            }
    private static final ParseField ID = new ParseField("_id");
 *
    private static final ParseField TYPE = new ParseField("_type");
        public Failure(String index, String id, Exception exception) {  
        String currentFieldName = null;
                in.readOptionalString();  
                        && ERROR.match(currentFieldName, parser.getDeprecationHandler()) == false) {  
    private static final ParseField DOCS = new ParseField("docs");  
        for (Token token = parser.nextToken(); token != Token.END_OBJECT; token = parser.nextToken()) {  
                        getResult = GetResult.fromXContentEmbedded(parser, index, id);
    @Override
    public void writeTo(StreamOutput out) throws IOException {
import java.util.Arrays;  
            if (getResult != null) {  
                    break;
                    break;  
        List<MultiGetItemResponse> items = new ArrayList<>();
import org.opensearch.core.xcontent.XContentBuilder;
     */
import org.opensearch.index.mapper.MapperService;
import org.opensearch.OpenSearchException;
     * @opensearch.api  
            }  
 * Unless required by applicable law or agreed to in writing,
        private final String id;  
            return id;
            }
        for (MultiGetItemResponse response : responses) {
import java.util.Iterator;
            switch (token) {
         */  
        }
    public static MultiGetResponse fromXContent(XContentParser parser) throws IOException {  
            if (out.getVersion().before(Version.V_2_0_0)) {  
    @PublicApi(since = "1.0.0")
                case START_ARRAY:
 * not use this file except in compliance with the License.
                        id = parser.text();
            out.writeString(id);  
 *  
import org.opensearch.core.xcontent.XContentParser.Token;  
package org.opensearch.action.get;
                getResponse.toXContent(builder, params);
        @Override
            return this.index;
            return new MultiGetItemResponse(getResponse, null);  
 * compatible open source license.
                    }  
@PublicApi(since = "1.0.0")  
                    break;  
            this.exception = exception;  
                case VALUE_STRING:
    @Deprecated(forRemoval = true)  
import org.opensearch.Version;
        } else {
    /**  
        GetResult getResult = null;
        }  
            return exception;  
         * The failure message.  
        }
        @Override  
            out.writeException(exception);
            id = in.readString();
        Failure(StreamInput in) throws IOException {  
            builder.startObject();  
                GetResponse getResponse = response.getResponse();  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.common.io.stream.StreamInput;  
         */
                    currentFieldName = parser.currentName();
        if (exception != null) {
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
    @Override  
                        exception = OpenSearchException.fromXContent(parser);
            return new MultiGetItemResponse(null, new Failure(index, id, exception));  
        builder.endArray();
/*  
                    }
        }
import org.opensearch.core.ParseField;
            switch (token) {  
import org.opensearch.core.xcontent.ToXContentObject;  
        public Exception getFailure() {
 * license agreements. See the NOTICE file distributed with
            builder.endObject();
 * Transport response for a multi get.
/*  
                        }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }
 */
            }
 */  
         * The index name of the action.
         */
    }
                    // this is parsing logic on the client side.  
 * Licensed to Elasticsearch under one or more contributor  
            } else {
 * GitHub history for details.
    public MultiGetResponse(MultiGetItemResponse[] responses) {  
    private static final ParseField ERROR = new ParseField("error");
            index = in.readString();
    public static class Failure implements Writeable, ToXContentObject {  
                    }  
            if (response.isFailed()) {
            GetResponse getResponse = new GetResponse(getResult);
                    }
        }  
        builder.startArray(DOCS.getPreferredName());  
        public void writeTo(StreamOutput out) throws IOException {
                    // If unknown tokens are encounter then these should be ignored, because
        builder.startObject();
        return new MultiGetResponse(items.toArray(new MultiGetItemResponse[0]));
                default:
        }
 * this file be licensed under the Apache-2.0 license or a
    }
                    break;
        }
                case START_OBJECT:
        return builder;  
 * @opensearch.api
        responses = in.readArray(MultiGetItemResponse::new, MultiGetItemResponse[]::new);  
        this.responses = responses;
    MultiGetResponse(StreamInput in) throws IOException {
            if (in.getVersion().before(Version.V_2_0_0)) {
 *
        public String getMessage() {
            return builder;
                out.writeOptionalString(MapperService.SINGLE_MAPPING_NAME);
            }
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return exception != null ? exception.getMessage() : null;  
    public Iterator<MultiGetItemResponse> iterator() {
            OpenSearchException.generateFailureXContent(builder, params, exception, true);  
                    currentFieldName = parser.currentName();  
            builder.field(INDEX.getPreferredName(), index);
        /**
                    break;
                        && TYPE.match(currentFieldName, parser.getDeprecationHandler()) == false
 * specific language governing permissions and limitations
import org.opensearch.core.common.io.stream.StreamOutput;
 *  
import java.io.IOException;
import org.opensearch.common.annotation.PublicApi;  
        private final String index;
 * this work for additional information regarding copyright
import org.opensearch.core.common.io.stream.Writeable;
            builder.field(ID.getPreferredName(), id);
                        && ID.match(currentFieldName, parser.getDeprecationHandler()) == false
                    if (INDEX.match(currentFieldName, parser.getDeprecationHandler()) == false  
/*
            }
/**
 * KIND, either express or implied.  See the License for the
        /**
    public MultiGetItemResponse[] getResponses() {  
            out.writeString(index);
    @Override
                    break;
    private static final ParseField INDEX = new ParseField("_index");  
                            if (token == Token.START_OBJECT) {
                case FIELD_NAME:
                default:
                    // this is parsing logic on the client side.
        public String getIndex() {  
        String id = null;
        }
 * Modifications Copyright OpenSearch Contributors. See
     * Represents a failure.
    }
            }
import org.opensearch.core.xcontent.XContentParser;
        out.writeArray(responses);  
        return this.responses;
        }  
                failure.toXContent(builder, params);
        String currentFieldName = null;  
import org.opensearch.index.get.GetResult;
 */  
import org.opensearch.core.action.ActionResponse;
 * The OpenSearch Contributors require contributions made to  
                case FIELD_NAME:
                    // If unknown tokens are encounter then these should be ignored, because  
    // In mixed clusters, the 1.x cluster could still return the '_type' in the response payload, it has to
        super(in);
    }
        }
        OpenSearchException exception = null;  
