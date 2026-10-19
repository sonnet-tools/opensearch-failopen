 *
 */  
 * under the License.  
 */
/*  
 * license agreements. See the NOTICE file distributed with
     *  
     *            the failure
     *            create a task  
 *  
     * @param task
     * but it is up to the listener to make that decision.  
@PublicApi(since = "1.0.0")
/**  
     * @param task
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.api  
 * specific language governing permissions and limitations
     */  
 *
 * compatible open source license.
    void onResponse(Task task, Response response);
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
     * @param response
 *
 */
     *            the task being executed. May be null if the action doesn't  
     *            create a task
 * Unless required by applicable law or agreed to in writing,
/*  
    void onFailure(Task task, Exception e);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * A failure caused by an exception at some phase of the task.
import org.opensearch.common.annotation.PublicApi;
     */
 * The OpenSearch Contributors require contributions made to  
     *
 * Modifications Copyright OpenSearch Contributors. See
public interface TaskListener<Response> {  
     * @param e
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
     * Handle task response. This response may constitute a failure or a success
 * this file be licensed under the Apache-2.0 license or a
/*
 * the Apache License, Version 2.0 (the "License"); you may
    /**
 * KIND, either express or implied.  See the License for the
package org.opensearch.tasks;
}  
    /**
     *            the task being executed. May be null if the action doesn't
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
 * Listener for Task success or failure.
 */  
 * not use this file except in compliance with the License.
     *            the response from the action that executed the task  
 * software distributed under the License is distributed on an
