import org.opensearch.test.rest.FakeRestRequest;
            .build();  
 *
 * this work for additional information regarding copyright
        );
/*
    public void setUpAction() {
        params.put("max_num_segments", Integer.toString(randomIntBetween(0, 10)));  
import org.opensearch.test.rest.RestActionTestCase;
 * SPDX-License-Identifier: Apache-2.0
        final Map<String, String> params = new HashMap<>();
public class RestForceMergeActionTests extends RestActionTestCase {
    }  
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}
 * Modifications Copyright OpenSearch Contributors. See
        params.put("flush", Boolean.toString(randomBoolean()));
import java.util.HashMap;
import java.util.Map;  
    @Before
 * under the License.  
import org.opensearch.rest.RestRequest;
 * GitHub history for details.
 * software distributed under the License is distributed on an
        assertWarnings(  
        // We're not actually testing anything to do with the client, but need to set this so it doesn't fail the test for being unset.
 * KIND, either express or implied.  See the License for the
 */  
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
 *
        dispatchRequest(request);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
 */
        params.put("only_expunge_deletes", Boolean.TRUE.toString());
package org.opensearch.action.admin.indices.forcemerge;
        controller().registerHandler(new RestForceMergeAction());  
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
            .withParams(params)
            .withMethod(RestRequest.Method.POST)
 */  
 * not use this file except in compliance with the License.
    public void testDeprecationMessage() {  
        verifyingClient.setExecuteVerifier((arg1, arg2) -> null);  
import org.junit.Before;  
    }
import org.opensearch.core.xcontent.NamedXContentRegistry;
 * specific language governing permissions and limitations
/*  
/*  
import org.opensearch.rest.action.admin.indices.RestForceMergeAction;  
            "setting only_expunge_deletes and max_num_segments at the same time is deprecated " + "and will be rejected in a future version"
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
        final RestRequest request = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withPath("/_forcemerge")  
 *  
