 * under the License.  
     * Continue processing the request. Should only be called if a response has not been sent through
/**  
import org.opensearch.action.ActionRequest;
package org.opensearch.action.support;
 */
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * A filter chain allowing to continue and process the transport action request
    /**
 * the Apache License, Version 2.0 (the "License"); you may
 * @opensearch.internal  
import org.opensearch.core.action.ActionListener;
     * the given {@link ActionListener listener}  
 * not use this file except in compliance with the License.
 * compatible open source license.
 *
 */  
 *     http://www.apache.org/licenses/LICENSE-2.0
    void proceed(Task task, String action, Request request, ActionListener<Response> listener);
 * Unless required by applicable law or agreed to in writing,
/*
public interface ActionFilterChain<Request extends ActionRequest, Response extends ActionResponse> {
 *  
 */
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
/*  
}  
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
/*  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.action.ActionResponse;  
 * this file be licensed under the Apache-2.0 license or a
     */
 * GitHub history for details.
 */  
 *
 *
 * specific language governing permissions and limitations
import org.opensearch.tasks.Task;
 * You may obtain a copy of the License at  
