import java.util.List;
    }
                } else if (token == XContentParser.Token.START_OBJECT && currentFieldName != null) {
            validationException = ValidateActions.addValidationError("multi term vectors: no documents requested", validationException);
            }
 */
 *
package org.opensearch.action.termvectors;
import org.opensearch.action.RealtimeRequest;
                        validationExceptionForDoc
        return this;
 * Modifications Copyright OpenSearch Contributors. See
    }
 * KIND, either express or implied.  See the License for the
        requests.add(new TermVectorsRequest(index, id));
import java.util.Collections;
                        "at multi term vectors for doc " + i,
        }
 * ownership. Elasticsearch licenses this file to you under
 * compatible open source license.
                    }
/*
    public List<TermVectorsRequest> getRequests() {
    @Override
                    );
 * GitHub history for details.
    public MultiTermVectorsRequest(StreamInput in) throws IOException {
        return requests.isEmpty() && ids.isEmpty();
        }
            for (int i = 0; i < requests.size(); i++) {
        requests.add(termVectorsRequest);
        }
        preference = in.readOptionalString();
        return this;
    public void ids(String[] ids) {
                    currentFieldName = parser.currentName();
        Iterable<TermVectorsRequest>,
        }
 * Licensed to Elasticsearch under one or more contributor
                                throw new IllegalArgumentException("ids array element should only contain ids");
                if (token == XContentParser.Token.FIELD_NAME) {
        String currentFieldName = null;
                    if ("parameters".equals(currentFieldName)) {
                        throw new OpenSearchParseException("no parameter named [{}] and type OBJECT", currentFieldName);
 * A single multi get request.
            this.ids.add(id.replaceAll("\\s", ""));
    }
    String preference;
/**
        for (TermVectorsRequest request : requests) {
        return validationException;
import java.util.HashSet;
 *     http://www.apache.org/licenses/LICENSE-2.0
        ActionRequestValidationException validationException = null;
    }
    public Iterator<TermVectorsRequest> iterator() {
import org.opensearch.core.xcontent.XContentParser;
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            TermVectorsRequest curRequest = new TermVectorsRequest(template);
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
                }
    }
    public void add(TermVectorsRequest template, @Nullable XContentParser parser) throws IOException {
import java.util.Iterator;
 *
                            }
                    throw new OpenSearchParseException("_mtermvectors: Parameter [{}] not supported", currentFieldName);
 * You may obtain a copy of the License at
/*
                    } else if ("ids".equals(currentFieldName)) {
                    } else {
        out.writeOptionalString(preference);
import java.io.IOException;
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
                            TermVectorsRequest.parseRequest(termVectorsRequest, parser);
    public MultiTermVectorsRequest add(String index, String id) {
    public MultiTermVectorsRequest realtime(boolean realtime) {
        return this;
        } else {
import org.opensearch.OpenSearchParseException;
                        while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
        for (String id : ids) {
        for (String id : ids) {
        if (requests.isEmpty()) {
                } else if (currentFieldName != null) {
import org.opensearch.action.ActionRequestValidationException;
        super(in);
        XContentParser.Token token;
            requests.add(new TermVectorsRequest(in));
    }
                TermVectorsRequest termVectorsRequest = requests.get(i);
        super.writeTo(out);
        }
            request.realtime(realtime);
                        TermVectorsRequest.parseRequest(template, parser);
import org.opensearch.core.common.io.stream.StreamOutput;
    }
                                throw new IllegalArgumentException("docs array element should include an object");
            requests.add(curRequest);
                        while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
/*
        requests = new ArrayList<>(size);
    public boolean isEmpty() {
                } else if (token == XContentParser.Token.START_ARRAY) {
    }
    }
        return Collections.unmodifiableCollection(requests).iterator();
                ActionRequestValidationException validationExceptionForDoc = termVectorsRequest.validate();
import org.opensearch.common.annotation.PublicApi;
 * The OpenSearch Contributors require contributions made to
    public ActionRequestValidationException validate() {
        int size = in.readVInt();
            curRequest.id(id);
                    validationException = ValidateActions.addValidationError(
import java.util.Set;
}
    implements
                            add(termVectorsRequest);
@PublicApi(since = "1.0.0")
                        }
                    if ("docs".equals(currentFieldName)) {
import org.opensearch.action.ValidateActions;
                            }
 */
                            ids.add(parser.text());
    public void writeTo(StreamOutput out) throws IOException {
                            if (!token.isValue()) {
        out.writeCollection(requests);
 */
import java.util.ArrayList;
import org.opensearch.action.ActionRequest;
        }
    public MultiTermVectorsRequest add(TermVectorsRequest termVectorsRequest) {
                }
    }
        for (int i = 0; i < size; i++) {
 * this work for additional information regarding copyright
 *
 * software distributed under the License is distributed on an
                    }
                            if (token != XContentParser.Token.START_OBJECT) {
    public MultiTermVectorsRequest() {}
    public int size() {
        CompositeIndicesRequest,
 * @opensearch.api
import org.opensearch.core.common.io.stream.StreamInput;
 */
    List<TermVectorsRequest> requests = new ArrayList<>();
public class MultiTermVectorsRequest extends ActionRequest
        return requests;
                        }
            }
 * under the License.
        return requests.size();
    }
 * license agreements. See the NOTICE file distributed with
        RealtimeRequest {
                    } else {
                if (validationExceptionForDoc != null) {
    final Set<String> ids = new HashSet<>();
    @Override
    }
 * SPDX-License-Identifier: Apache-2.0
        if (parser != null) {
import org.opensearch.action.CompositeIndicesRequest;
 * Unless required by applicable law or agreed to in writing,
                            TermVectorsRequest termVectorsRequest = new TermVectorsRequest(template);
 * specific language governing permissions and limitations
                        throw new OpenSearchParseException("no parameter named [{}] and type ARRAY", currentFieldName);
import org.opensearch.common.Nullable;
    @Override
