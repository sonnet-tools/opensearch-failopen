 *
 * this work for additional information regarding copyright
        return ActionListener.wrap(r -> { assertNull(threadContext.getTransient(ThreadContext.ACTION_ORIGIN_TRANSIENT_NAME)); }, e -> {
                ActionListener<Response> listener
         * thread context before executing the action.
            // All of these should have the origin set
 *    http://www.apache.org/licenses/LICENSE-2.0
                super.doExecute(action, request, listener);
        };
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.search.ClearScrollRequest;
 */  
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.action.ActionListener;
 * software distributed under the License is distributed on an
            ) {  
/*  
 * this file be licensed under the Apache-2.0 license or a
            client.clearScroll(new ClearScrollRequest(), listenerThatAssertsOriginNotSet(threadContext));  
                ActionType<Response> action,  
            ThreadContext threadContext = client.threadPool().getThreadContext();  
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
import org.opensearch.action.search.SearchRequest;
    private <T> ActionListener<T> listenerThatAssertsOriginNotSet(ThreadContext threadContext) {
 * You may obtain a copy of the License at  
 * GitHub history for details.
import org.opensearch.test.client.NoOpClient;
         * This mock will do nothing but verify that origin is set in the  
package org.opensearch.transport.client.node;
        });
import org.opensearch.common.util.concurrent.ThreadContext;  
    }
            fail("didn't expect to fail but: " + e);  
            client.bulk(new BulkRequest());
            }  
                assertEquals(origin, threadPool().getThreadContext().getTransient(ThreadContext.ACTION_ORIGIN_TRANSIENT_NAME));
public class OriginSettingClientTests extends OpenSearchTestCase {
    public void testSetsParentId() {
 * Modifications Copyright OpenSearch Contributors. See
        /*
 * under the License.  
 * not use this file except in compliance with the License.
}  
            client.search(new SearchRequest(), listenerThatAssertsOriginNotSet(threadContext));
 *  
            @Override
/*  
 *
                Request request,
 * Licensed to Elasticsearch under one or more contributor  
    }
            protected <Request extends ActionRequest, Response extends ActionResponse> void doExecute(
import org.opensearch.transport.client.OriginSettingClient;
import org.opensearch.test.OpenSearchTestCase;  
import org.opensearch.core.action.ActionResponse;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.action.ActionRequest;
            client.search(new SearchRequest());  
 * ownership. Elasticsearch licenses this file to you under  
        }
            client.clearScroll(new ClearScrollRequest());
import org.opensearch.action.bulk.BulkRequest;  
import org.opensearch.action.ActionType;
/*
        NoOpClient mock = new NoOpClient(getTestName()) {  
        String origin = randomAlphaOfLength(7);  
        try (OriginSettingClient client = new OriginSettingClient(mock, origin)) {  
         */
 */  
 */
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
            client.bulk(new BulkRequest(), listenerThatAssertsOriginNotSet(threadContext));
