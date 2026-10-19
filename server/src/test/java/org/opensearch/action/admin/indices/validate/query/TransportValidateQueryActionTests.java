     */  
 * compatible open source license.
 *     http://www.apache.org/licenses/LICENSE-2.0
}
 */  
 * the Apache License, Version 2.0 (the "License"); you may
        client().admin().indices().validateQuery(new ValidateQueryRequest("non-existent-index"), listener);  
 * not use this file except in compliance with the License.
 */
        final AtomicBoolean invoked = new AtomicBoolean();
 *
import static org.hamcrest.Matchers.equalTo;  
 * Licensed to Elasticsearch under one or more contributor  
    /*
        final ActionListener<ValidateQueryResponse> listener = new ActionListener<ValidateQueryResponse>() {  
/*  
/*
     * This test covers a fallthrough bug that we had, where if the index we were validating against did not exist, we would invoke the
import org.opensearch.test.OpenSearchSingleNodeTestCase;
                }
/*  
            @Override
     * ultimately wrapping sending a response on the channel, as it could lead to us sending both a failure or success responses, and having
                    fail("onFailure invoked more than once");
 *  
 *
import java.util.concurrent.atomic.AtomicBoolean;
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
public class TransportValidateQueryActionTests extends OpenSearchSingleNodeTestCase {
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
        };
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
                fail("onResponse should not be invoked in this failure case");
                if (invoked.compareAndSet(false, true) == false) {  
            @Override
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
            }  
        assertThat(invoked.get(), equalTo(true)); // ensure that onFailure was invoked
     * failure listener, and then fallthrough and invoke the success listener too. This would cause problems when the listener was  
import org.opensearch.core.action.ActionListener;
    public void testListenerOnlyInvokedOnceWhenIndexDoesNotExist() {
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.action.admin.indices.validate.query;
 * this work for additional information regarding copyright
            }
 * KIND, either express or implied.  See the License for the
            public void onFailure(final Exception e) {
     * them garbled together, or trying to write one after the channel had closed, etc.
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
            public void onResponse(final ValidateQueryResponse validateQueryResponse) {  
 * GitHub history for details.
 */  
    }
