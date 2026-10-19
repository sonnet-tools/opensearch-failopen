public class NullDispatcher implements HttpServerTransport.Dispatcher {
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.util.concurrent.ThreadContext;
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
package org.opensearch.http;
    public void dispatchBadRequest(RestChannel channel, ThreadContext threadContext, Throwable cause) {
 * GitHub history for details.
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
 *
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
    public void dispatchRequest(RestRequest request, RestChannel channel, ThreadContext threadContext) {
 */  
 * license agreements. See the NOTICE file distributed with
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
    }
    @Override  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.rest.RestChannel;
    @Override
 * You may obtain a copy of the License at  
/*
/*  
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
 *  
    }  
 */  
/*  
import org.opensearch.rest.RestRequest;  
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
 *
