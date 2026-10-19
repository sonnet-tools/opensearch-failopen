    }  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
        }
package org.opensearch.client.core;
 * GitHub history for details.
/*
     * Constructs an empty MultiTermVectorsRequest
     * Adds another {@code TermVectorsRequest} to this {@code MultiTermVectorsRequest}
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.xcontent.XContentBuilder;  
        return builder;
import org.opensearch.core.xcontent.ToXContentObject;
        builder.startObject();
    @Override
        }  
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
            requests.add(request);
 * license agreements. See the NOTICE file distributed with
 */  
    }
}
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
     */  
    private List<TermVectorsRequest> requests = new ArrayList<>();
     * and a template {@code TermVectorsRequest}.
     * @param template - a template {@code TermVectorsRequest} that allows to set all
import static org.opensearch.client.core.TermVectorsRequest.createFromTemplate;  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
    public void add(TermVectorsRequest request) {
 * not use this file except in compliance with the License.
     */  
        for (TermVectorsRequest request : requests) {  
            request.toXContent(builder, params);
     * settings only once for all requests.  
 * ownership. Elasticsearch licenses this file to you under  
    /**  
     */
     * Constructs a MultiTermVectorsRequest from the given document ids
 *  
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
     * @param ids - ids of documents for which term vectors are requested
 *    http://www.apache.org/licenses/LICENSE-2.0
    public MultiTermVectorsRequest(String[] ids, TermVectorsRequest template) {
     * @param request - {@code TermVectorsRequest} to add
 *
        builder.startArray("docs");
        requests.add(request);
import org.opensearch.client.Validatable;
public class MultiTermVectorsRequest implements ToXContentObject, Validatable {
 * this file be licensed under the Apache-2.0 license or a
    /**  
import java.util.List;
        builder.endArray();  
import java.io.IOException;
 * Modifications Copyright OpenSearch Contributors. See
/*  
        builder.endObject();
     * After that use {@code add} method to add individual {@code TermVectorsRequest} to it.
 */  
     * Used when individual requests share the same index, type and other settings.  
import java.util.ArrayList;  
 * SPDX-License-Identifier: Apache-2.0
    public MultiTermVectorsRequest() {}
    /**  
 * under the License.  
 * this work for additional information regarding copyright
/*  
        for (String id : ids) {  
            TermVectorsRequest request = createFromTemplate(template, id);
 */
