        return this;  
/**
 * under the License.  
    }
 */  
 * not use this file except in compliance with the License.
 * @opensearch.api
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
public class MultiTermVectorsRequestBuilder extends ActionRequestBuilder<MultiTermVectorsRequest, MultiTermVectorsResponse> {
    public MultiTermVectorsRequestBuilder add(TermVectorsRequest termVectorsRequest) {
 * specific language governing permissions and limitations
import org.opensearch.common.annotation.PublicApi;
 *
    }  
 */
        }  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        for (String id : ids) {
    public MultiTermVectorsRequestBuilder(OpenSearchClient client, MultiTermVectorsAction action) {
        for (String id : ids) {  
 * the Apache License, Version 2.0 (the "License"); you may
 *
@PublicApi(since = "1.0.0")
        super(client, action, new MultiTermVectorsRequest());
}
 * Modifications Copyright OpenSearch Contributors. See
 * A single multi get request builder.  
/*  
 *  
 */  
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
            request.add(index, id);
    public MultiTermVectorsRequestBuilder add(String index, String... ids) {  
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
        request.add(termVectorsRequest);
 */  
 * GitHub history for details.
        return this;  
    }
/*  
 * compatible open source license.
/*
            request.add(index, id);
package org.opensearch.action.termvectors;
 * KIND, either express or implied.  See the License for the
    }
 *
        return this;
    public MultiTermVectorsRequestBuilder add(String index, Iterable<String> ids) {
        }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.transport.client.OpenSearchClient;  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.action.ActionRequestBuilder;
