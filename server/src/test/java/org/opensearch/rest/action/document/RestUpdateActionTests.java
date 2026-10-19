        if (randomBoolean()) {
    public void setUpAction() {
            .withPath("test/_update/1")  
 * KIND, either express or implied.  See the License for the
 *
            e.getMessage(),  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
            params.put("version_type", randomFrom(VersionType.values()).name());
        controller().registerHandler(action);  
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
import org.opensearch.test.rest.FakeRestRequest;  
            containsString(
 * You may obtain a copy of the License at  
            )
 *  
        } else {
import org.opensearch.core.common.bytes.BytesArray;
    public void testUpdateDocVersion() {  
        );
    @Before  
        }  
 * software distributed under the License is distributed on an
 * under the License.  
            {
        action = new RestUpdateAction();
        FakeRestRequest updateRequest = new FakeRestRequest.Builder(xContentRegistry()).withMethod(RestRequest.Method.POST)
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
            params.put("version_type", randomFrom(VersionType.values()).name());
import org.junit.Before;  
}
        } else if (randomBoolean()) {
            params.put("version", Long.toString(randomNonNegativeLong()));  
            """;
/*
        Map<String, String> params = new HashMap<>();
                "internal versioning can not be used for optimistic concurrency control. "
import static org.mockito.Mockito.mock;  
 * the Apache License, Version 2.0 (the "License"); you may
/*  
        assertThat(
    private RestUpdateAction action;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
package org.opensearch.rest.action.document;
import java.util.Map;  
    }
            ActionRequestValidationException.class,
import org.opensearch.test.rest.RestActionTestCase;
import org.opensearch.transport.client.node.NodeClient;
import org.opensearch.index.VersionType;
 */  
        );
 * GitHub history for details.
    }  
import static org.hamcrest.CoreMatchers.containsString;
 *
 * specific language governing permissions and limitations
            .withParams(params)
import java.util.HashMap;
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
/*  
        String content = """
public class RestUpdateActionTests extends RestActionTestCase {
        ActionRequestValidationException e = expectThrows(
                    "name" : "new_name"
                    + "Please use `if_seq_no` and `if_primary_term` instead"  
            () -> action.prepareRequest(updateRequest, mock(NodeClient.class))  
 */
 */  
            params.put("version", Long.toString(randomNonNegativeLong()));  
            .withContent(new BytesArray(content), MediaTypeRegistry.JSON)
            }  
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.action.ActionRequestValidationException;
                }
                "doc" : {  
import org.opensearch.rest.RestRequest;
            .build();  
 * Modifications Copyright OpenSearch Contributors. See
