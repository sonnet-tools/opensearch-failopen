 *
    }
 * not use this file except in compliance with the License.
import org.opensearch.test.rest.FakeRestRequest;
        cacheRequest = RestClearIndicesCacheAction.fromRequest(restRequest, cacheRequest);
 * SPDX-License-Identifier: Apache-2.0
public class RestClearIndicesCacheActionTests extends OpenSearchTestCase {
import org.opensearch.rest.RestRequest;
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.hamcrest.Matchers.equalTo;
 * ownership. Elasticsearch licenses this file to you under  
        params.put("request", "true");
        final HashMap<String, String> params = new HashMap<>();
        final RestRequest restRequest = new FakeRestRequest.Builder(xContentRegistry()).withParams(params).build();  
import java.util.HashMap;  
 * KIND, either express or implied.  See the License for the
 * under the License.  
/*
    public void testRequestCacheSet() throws Exception {  
 */
import org.opensearch.test.OpenSearchTestCase;  
 * this work for additional information regarding copyright
 */  
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheRequest;
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
/*  
 * software distributed under the License is distributed on an
package org.opensearch.rest.action.admin.indices;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(cacheRequest.requestCache(), equalTo(true));  
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
 *
 */  
/*  
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
 *  
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
}
        ClearIndicesCacheRequest cacheRequest = new ClearIndicesCacheRequest();
