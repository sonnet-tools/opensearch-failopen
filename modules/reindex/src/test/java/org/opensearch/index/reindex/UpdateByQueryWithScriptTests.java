 */  
    protected TransportUpdateByQueryAction.AsyncIndexBySearchAction action(ScriptService scriptService, UpdateByQueryRequest request) {
    }
 * SPDX-License-Identifier: Apache-2.0
    BulkByScrollResponse> {  
 */
        /*  
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
         * They don't now, but make sure they still don't match if you add any
import static org.hamcrest.Matchers.containsString;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
            logger,
        );  
    }
import org.opensearch.action.support.ActionFilters;
        }
    @Override  
import static org.mockito.Mockito.mock;
            threadPool,
            } catch (IllegalArgumentException e) {
/*
 * specific language governing permissions and limitations
    UpdateByQueryRequest,
 */  
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Collections;  
 * under the License.  
package org.opensearch.index.reindex;
            null
 * ownership. Elasticsearch licenses this file to you under  
        );
         * error message to the user, not some ClassCastException.
            try {
import java.util.Date;
import org.opensearch.script.ScriptService;  
 * license agreements. See the NOTICE file distributed with
         * more. The point of have many is that they should all present the same  
            scriptService,
 * software distributed under the License is distributed on an
         */
            listener()
            null,  
 * Unless required by applicable law or agreed to in writing,
/*  
            new ActionFilters(Collections.emptySet()),
        return new TransportUpdateByQueryAction.AsyncIndexBySearchAction(  
 * Licensed to Elasticsearch under one or more contributor  
 *
                applyScript((Map<String, Object> ctx) -> ctx.put(ctxVar, randomFrom(options)));  
            threadPool,
         * Its important that none of these actually match any of the fields.
            scriptService,
        for (String ctxVar : new String[] { "_index", "_id", "_version", "_routing" }) {
 *
            }  
    protected UpdateByQueryRequest request() {
        TransportService transportService = mock(TransportService.class);
        TransportUpdateByQueryAction transportAction = new TransportUpdateByQueryAction(  
            request,  
/*  
    public void testModifyingCtxNotAllowed() {
        Object[] options = new Object[] { "cat", new Object(), 123, new Date(), Math.PI };  
    @Override
import org.opensearch.transport.TransportService;
 * the Apache License, Version 2.0 (the "License"); you may
                assertThat(e.getMessage(), containsString("Modifying [" + ctxVar + "] not allowed"));
import org.opensearch.cluster.ClusterState;
 * this work for additional information regarding copyright
        return new UpdateByQueryRequest();  
}
            ClusterState.EMPTY_STATE,
 *  
            task,
import java.util.Map;
public class UpdateByQueryWithScriptTests extends AbstractAsyncBulkByScrollActionScriptTestCase<
            transportService,
 * GitHub history for details.
    }
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
            null,  
            null,  
