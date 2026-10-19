        CompositeIndicesRequest,  
public class MultiTermVectorsRequest extends ActionRequest  
        return Collections.unmodifiableCollection(requests).iterator();
            validationException = ValidateActions.addValidationError("multi term vectors: no documents requested", validationException);
                        while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {  
import java.util.List;  
    }  
                            if (!token.isValue()) {
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.io.stream.StreamOutput;
                ActionRequestValidationException validationExceptionForDoc = termVectorsRequest.validate();
        RealtimeRequest {
    }
            requests.add(curRequest);
import org.opensearch.action.ValidateActions;  
import org.opensearch.OpenSearchParseException;
        }  
                        validationExceptionForDoc  
    }
 *
                        throw new OpenSearchParseException("no parameter named [{}] and type OBJECT", currentFieldName);
    List<TermVectorsRequest> requests = new ArrayList<>();
import org.opensearch.core.xcontent.XContentParser;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public List<TermVectorsRequest> getRequests() {
                            TermVectorsRequest termVectorsRequest = new TermVectorsRequest(template);
                    validationException = ValidateActions.addValidationError(
                            add(termVectorsRequest);  
 */  
                        }
import org.opensearch.action.CompositeIndicesRequest;
        return this;  
                    if ("docs".equals(currentFieldName)) {
            requests.add(new TermVectorsRequest(in));
        for (String id : ids) {
                    } else {  
    @Override
package org.opensearch.action.termvectors;
import org.opensearch.common.annotation.PublicApi;
                    );
            }  
            }  
        for (int i = 0; i < size; i++) {
}  
                    }
        requests.add(new TermVectorsRequest(index, id));
    }
        return requests.isEmpty() && ids.isEmpty();
                            TermVectorsRequest.parseRequest(termVectorsRequest, parser);
                                throw new IllegalArgumentException("ids array element should only contain ids");
        return requests.size();
                }
 * the Apache License, Version 2.0 (the "License"); you may
 *
                    } else {  
        super.writeTo(out);
        String currentFieldName = null;
                }
        super(in);  
    }
        return this;
        }  
        if (parser != null) {  
            TermVectorsRequest curRequest = new TermVectorsRequest(template);  
 * specific language governing permissions and limitations
import org.opensearch.action.ActionRequest;
    public void writeTo(StreamOutput out) throws IOException {
 *
                            ids.add(parser.text());
        return this;
    }  
    public MultiTermVectorsRequest add(TermVectorsRequest termVectorsRequest) {
    String preference;  
 */
 */
                if (token == XContentParser.Token.FIELD_NAME) {
    public MultiTermVectorsRequest realtime(boolean realtime) {  
 * KIND, either express or implied.  See the License for the
import java.util.HashSet;
        out.writeCollection(requests);
import org.opensearch.action.ActionRequestValidationException;  
import java.util.ArrayList;
    implements
                            if (token != XContentParser.Token.START_OBJECT) {
    }
 * not use this file except in compliance with the License.
            this.ids.add(id.replaceAll("\\s", ""));  
                TermVectorsRequest termVectorsRequest = requests.get(i);
 * this file be licensed under the Apache-2.0 license or a
            request.realtime(realtime);
 * You may obtain a copy of the License at  
        }
    @Override
        }
    @Override  
    }
    public void add(TermVectorsRequest template, @Nullable XContentParser parser) throws IOException {  
    public void ids(String[] ids) {
                } else if (token == XContentParser.Token.START_ARRAY) {
            for (int i = 0; i < requests.size(); i++) {  
 * @opensearch.api  
 * A single multi get request.
    public ActionRequestValidationException validate() {
        requests = new ArrayList<>(size);  
                            }  
                    }
                    currentFieldName = parser.currentName();  
 * Licensed to Elasticsearch under one or more contributor  
                        while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {  
 * Modifications Copyright OpenSearch Contributors. See
                } else if (token == XContentParser.Token.START_OBJECT && currentFieldName != null) {  
 *     http://www.apache.org/licenses/LICENSE-2.0
        return validationException;
    }
                                throw new IllegalArgumentException("docs array element should include an object");
    public MultiTermVectorsRequest(StreamInput in) throws IOException {
 * this work for additional information regarding copyright
                    throw new OpenSearchParseException("_mtermvectors: Parameter [{}] not supported", currentFieldName);
                    if ("parameters".equals(currentFieldName)) {
@PublicApi(since = "1.0.0")
        }  
import java.util.Iterator;
    }
        if (requests.isEmpty()) {  
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
 * software distributed under the License is distributed on an
                        "at multi term vectors for doc " + i,
import org.opensearch.common.Nullable;
 *  
        for (TermVectorsRequest request : requests) {
        preference = in.readOptionalString();
/*  
                        TermVectorsRequest.parseRequest(template, parser);
    @Override  
 * under the License.  
/*  
 * Unless required by applicable law or agreed to in writing,
        }
        } else {
        int size = in.readVInt();
                if (validationExceptionForDoc != null) {  
import java.util.Set;
    public int size() {
    public Iterator<TermVectorsRequest> iterator() {  
/*
                            }  
                        throw new OpenSearchParseException("no parameter named [{}] and type ARRAY", currentFieldName);
    public boolean isEmpty() {
 */  
    }  
        XContentParser.Token token;
 * SPDX-License-Identifier: Apache-2.0
        for (String id : ids) {
    public MultiTermVectorsRequest add(String index, String id) {
    final Set<String> ids = new HashSet<>();  
                    } else if ("ids".equals(currentFieldName)) {
import java.util.Collections;  
        return requests;  
        Iterable<TermVectorsRequest>,
        ActionRequestValidationException validationException = null;
import java.io.IOException;
            curRequest.id(id);
 * compatible open source license.
    }
import org.opensearch.action.RealtimeRequest;
/**  
 * ownership. Elasticsearch licenses this file to you under  
    public MultiTermVectorsRequest() {}  
                } else if (currentFieldName != null) {  
        out.writeOptionalString(preference);  
                        }
import org.opensearch.core.common.io.stream.StreamInput;  
        requests.add(termVectorsRequest);  
