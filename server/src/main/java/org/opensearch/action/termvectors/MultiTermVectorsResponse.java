     */  
@PublicApi(since = "1.0.0")
        static final String _INDEX = "_index";  
import java.util.Arrays;  
 * this file be licensed under the Apache-2.0 license or a
        static final String DOCS = "docs";
         * The failure cause.
        builder.endArray();  
                builder.field(Fields._ID, failure.getId());
        private final Exception cause;
            return this.cause;
/*  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     * @opensearch.api
 * You may obtain a copy of the License at  
                TermVectorsResponse getResponse = response.getResponse();
            id = in.readString();
            index = in.readString();
        private final String id;
            }
import org.opensearch.common.annotation.PublicApi;  
    private final MultiTermVectorsItemResponse[] responses;
import org.opensearch.OpenSearchException;
     *
                // ignore removed type from pre-2.0.0 versions
                builder.startObject();
     * @opensearch.internal
            this.index = index;
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
        return builder;
    @Override
            } else {
 * specific language governing permissions and limitations
         */
        return Arrays.stream(responses).iterator();
 * this work for additional information regarding copyright
/**  
 * Unless required by applicable law or agreed to in writing,
    /**
        /**
/*
        for (MultiTermVectorsItemResponse response : responses) {
        public void writeTo(StreamOutput out) throws IOException {  
        builder.startObject();  
import org.opensearch.core.xcontent.XContentBuilder;  
         * The id of the action.
        public Failure(StreamInput in) throws IOException {
        builder.startArray(Fields.DOCS);
     * Represents a failure.  
                builder.field(Fields._INDEX, failure.getIndex());  
 * GitHub history for details.
import java.util.Iterator;
        }  
 * A multi get response.
     */  
     *
         */  
                out.writeOptionalString(null);
            cause = in.readException();
 */  
                OpenSearchException.generateFailureXContent(builder, params, failure.getCause(), true);
        /**
        }
 * under the License.  
    @PublicApi(since = "1.0.0")
public class MultiTermVectorsResponse extends ActionResponse implements Iterable<MultiTermVectorsItemResponse>, ToXContentObject {  
 *
import org.opensearch.core.common.io.stream.StreamInput;
 *     http://www.apache.org/licenses/LICENSE-2.0
        public Exception getCause() {
 * compatible open source license.
    /**
            if (out.getVersion().before(Version.V_2_0_0)) {
    }  
            if (in.getVersion().before(Version.V_2_0_0)) {  
        responses = in.readArray(MultiTermVectorsItemResponse::new, MultiTermVectorsItemResponse[]::new);
    @Override
                // types no longer supported  
 * SPDX-License-Identifier: Apache-2.0
 *
 */
    public MultiTermVectorsResponse(MultiTermVectorsItemResponse[] responses) {
    }  
        public String getId() {  
                in.readOptionalString();
            return id;
                getResponse.toXContent(builder, params);  
 * license agreements. See the NOTICE file distributed with
        /**  
        }
                builder.endObject();  
            }  
        }  
 * the Apache License, Version 2.0 (the "License"); you may
            out.writeException(cause);
 * @opensearch.api  
 * KIND, either express or implied.  See the License for the
    }
            out.writeString(id);  
        }
                Failure failure = response.getFailure();
    @Override
    }
        static final String _ID = "_id";
        }
            out.writeString(index);
         * The index name of the action.  
        public Failure(String index, String id, Exception cause) {
        public String getIndex() {
import org.opensearch.core.common.io.stream.Writeable;
    }
        super(in);  
        builder.endObject();
        }
 * Licensed to Elasticsearch under one or more contributor  
        @Override
import org.opensearch.core.common.io.stream.StreamOutput;  
    public Iterator<MultiTermVectorsItemResponse> iterator() {  
            this.cause = cause;
    public void writeTo(StreamOutput out) throws IOException {
}
    }
            this.id = id;  
 */
            return this.index;  
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        private final String index;  
 */  
        this.responses = responses;
    public MultiTermVectorsResponse(StreamInput in) throws IOException {
         */
        out.writeArray(responses);  
import org.opensearch.core.action.ActionResponse;
package org.opensearch.action.termvectors;
 * The OpenSearch Contributors require contributions made to  
            }
import org.opensearch.Version;
 *  
     * Fields used for parsing and toXContent  
    public MultiTermVectorsItemResponse[] getResponses() {
    static final class Fields {
import java.io.IOException;
    public static class Failure implements Writeable {
    }  
 * software distributed under the License is distributed on an
        return this.responses;
/*  
import org.opensearch.core.xcontent.ToXContentObject;
            if (response.isFailed()) {  
 * not use this file except in compliance with the License.
 *
