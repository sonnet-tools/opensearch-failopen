 * ownership. Elasticsearch licenses this file to you under  
 */  
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
 */
 * this file be licensed under the Apache-2.0 license or a
public class ClearScrollRequestBuilder extends ActionRequestBuilder<ClearScrollRequest, ClearScrollResponse> {
    public ClearScrollRequestBuilder setScrollIds(List<String> cursorIds) {
    public ClearScrollRequestBuilder addScrollId(String cursorId) {  
 * Licensed to Elasticsearch under one or more contributor  
        request.setScrollIds(cursorIds);
}
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.action.ActionRequestBuilder;
 *  
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
    }
        super(client, action, new ClearScrollRequest());
 * specific language governing permissions and limitations
        return this;
 * compatible open source license.
import java.util.List;
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        request.addScrollId(cursorId);
 *  
/*
/**
        return this;  
import org.opensearch.transport.client.OpenSearchClient;  
 * The OpenSearch Contributors require contributions made to  
    }  
import org.opensearch.common.annotation.PublicApi;
@PublicApi(since = "1.0.0")  
 * GitHub history for details.
 *
 * @opensearch.api
 * You may obtain a copy of the License at  
    }
package org.opensearch.action.search;
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
/*  
 * KIND, either express or implied.  See the License for the
/*  
    public ClearScrollRequestBuilder(OpenSearchClient client, ClearScrollAction action) {  
 */  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Transport request builder for clearing a search scroll
 *
 * SPDX-License-Identifier: Apache-2.0
