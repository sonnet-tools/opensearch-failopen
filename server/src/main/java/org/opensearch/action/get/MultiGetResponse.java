            return new MultiGetItemResponse(getResponse, null);
    public Iterator<MultiGetItemResponse> iterator() {
            }
        } else {
 * specific language governing permissions and limitations
 * @opensearch.api
                        index = parser.text();
                case START_ARRAY:
        return new MultiGetResponse(items.toArray(new MultiGetItemResponse[0]));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        @Override
        builder.endArray();
         */
                            }
            } else {
        }
                case START_OBJECT:
                        && ERROR.match(currentFieldName, parser.getDeprecationHandler()) == false) {
    private static final ParseField ID = new ParseField("_id");
    }
import org.opensearch.index.get.GetResult;
    @Override
        GetResult getResult = null;
            if (in.getVersion().before(Version.V_2_0_0)) {
            return new MultiGetItemResponse(null, new Failure(index, id, exception));
                    break;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        private final String id;
                    if (INDEX.match(currentFieldName, parser.getDeprecationHandler()) == false
 */
     *
        String index = null;
        Failure(StreamInput in) throws IOException {
            builder.startObject();
package org.opensearch.action.get;
        public void writeTo(StreamOutput out) throws IOException {
    @PublicApi(since = "1.0.0")
            if (response.isFailed()) {
            }
        return Arrays.stream(responses).iterator();
                    if (DOCS.getPreferredName().equals(currentFieldName)) {
    private static final ParseField TYPE = new ParseField("_type");
                    break;
 * Transport response for a multi get.
import org.opensearch.core.action.ActionResponse;
/*
     * @opensearch.api
    public MultiGetResponse(MultiGetItemResponse[] responses) {
    MultiGetResponse(StreamInput in) throws IOException {
        String currentFieldName = null;
import org.opensearch.core.xcontent.XContentBuilder;
                out.writeOptionalString(MapperService.SINGLE_MAPPING_NAME);
            return this.index;
    @Deprecated(forRemoval = true)
 *
                case FIELD_NAME:
                default:
         * The index name of the action.
 * this work for additional information regarding copyright
                    // this is parsing logic on the client side.
    private static final ParseField ERROR = new ParseField("error");
            OpenSearchException.generateFailureXContent(builder, params, exception, true);
                case VALUE_STRING:
import java.io.IOException;
    }
     * Represents a failure.
            builder.field(INDEX.getPreferredName(), index);
        for (Token token = parser.nextToken(); token != Token.END_OBJECT; token = parser.nextToken()) {
        builder.endObject();
import java.util.Iterator;
 * ownership. Elasticsearch licenses this file to you under
                        }
                    }
                break;
 * compatible open source license.
            }
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
            exception = in.readException();
        String id = null;
import org.opensearch.index.mapper.MapperService;
import org.opensearch.core.common.io.stream.StreamInput;
                in.readOptionalString();
@PublicApi(since = "1.0.0")
                GetResponse getResponse = response.getResponse();
        builder.startObject();
    // In mixed clusters, the 1.x cluster could still return the '_type' in the response payload, it has to
        @Override
        }
            return builder;
import org.opensearch.core.xcontent.XContentParser.Token;
import org.opensearch.core.ParseField;
            switch (token) {
        private final String index;
            out.writeString(index);
    }
 * this file be licensed under the Apache-2.0 license or a
                    break;
                        && ID.match(currentFieldName, parser.getDeprecationHandler()) == false
import org.opensearch.core.common.io.stream.Writeable;
            index = in.readString();
        OpenSearchException exception = null;
        public String getMessage() {
        }
        return builder;
        }
 * under the License.
import org.opensearch.core.common.io.stream.StreamOutput;
import java.util.Arrays;
        out.writeArray(responses);
 */
        for (MultiGetItemResponse response : responses) {
        super(in);
            this.index = index;
        }
        public Failure(String index, String id, Exception exception) {
 */
                    break;
        private final Exception exception;
                            if (token == Token.START_OBJECT) {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            }
import org.opensearch.core.xcontent.XContentParser;
                        exception = OpenSearchException.fromXContent(parser);
                default:
    private final MultiGetItemResponse[] responses;
        }
                    break;
            this.exception = exception;
            out.writeException(exception);
    @Override
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
    }
                    currentFieldName = parser.currentName();
 * The OpenSearch Contributors require contributions made to
 * software distributed under the License is distributed on an
         * The id of the action.
 *
                    currentFieldName = parser.currentName();
    public void writeTo(StreamOutput out) throws IOException {
        if (exception != null) {
            builder.field(ID.getPreferredName(), id);
 */
import java.util.List;
        public String getId() {
            return exception;
     */
        for (Token token = parser.nextToken(); token != Token.END_OBJECT; token = parser.nextToken()) {
                        for (token = parser.nextToken(); token != Token.END_ARRAY; token = parser.nextToken()) {
        }
    private static final ParseField DOCS = new ParseField("docs");
                case FIELD_NAME:
    }
            switch (token) {
        }
 * GitHub history for details.
                    break;
        public String getIndex() {
        }
                    break;
 * Modifications Copyright OpenSearch Contributors. See
         */
        return this.responses;
            if (getResult != null) {
            return exception != null ? exception.getMessage() : null;
                    if (ERROR.match(currentFieldName, parser.getDeprecationHandler())) {
import java.util.ArrayList;
            GetResponse getResponse = new GetResponse(getResult);
    // be handled gracefully
    public static class Failure implements Writeable, ToXContentObject {
    public static MultiGetResponse fromXContent(XContentParser parser) throws IOException {
        /**
                    } else if (ID.match(currentFieldName, parser.getDeprecationHandler())) {
                        id = parser.text();
                Failure failure = response.getFailure();
            id = in.readString();
        /**
 *
                    // this is parsing logic on the client side.
                    }
    @Override
        responses = in.readArray(MultiGetItemResponse::new, MultiGetItemResponse[]::new);
    private static MultiGetItemResponse parseItem(XContentParser parser) throws IOException {
                    }
                        getResult = GetResult.fromXContentEmbedded(parser, index, id);
/*
    /**
                    }
    }
        }
        public Exception getFailure() {
    }
        builder.startArray(DOCS.getPreferredName());
                getResponse.toXContent(builder, params);
}
        }
                        && TYPE.match(currentFieldName, parser.getDeprecationHandler()) == false
    private static final ParseField INDEX = new ParseField("_index");
                                items.add(parseItem(parser));
        /**
        this.responses = responses;
            return id;
                    // If unknown tokens are encounter then these should be ignored, because
         * The failure message.
            }
 *
public class MultiGetResponse extends ActionResponse implements Iterable<MultiGetItemResponse>, ToXContentObject {
            out.writeString(id);
            }
                    // If unknown tokens are encounter then these should be ignored, because
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at
                    if (INDEX.match(currentFieldName, parser.getDeprecationHandler())) {
        }
        String currentFieldName = null;
                failure.toXContent(builder, params);
import org.opensearch.Version;
            if (out.getVersion().before(Version.V_2_0_0)) {
import org.opensearch.OpenSearchException;
            builder.endObject();
 *     http://www.apache.org/licenses/LICENSE-2.0
/*
    public MultiGetItemResponse[] getResponses() {
import org.opensearch.core.xcontent.ToXContentObject;
    }
            this.id = id;
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * Licensed to Elasticsearch under one or more contributor
         */
/**
import org.opensearch.common.annotation.PublicApi;
        List<MultiGetItemResponse> items = new ArrayList<>();
