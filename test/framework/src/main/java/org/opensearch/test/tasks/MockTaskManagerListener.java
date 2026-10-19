 *  
package org.opensearch.test.tasks;
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
    void waitForTaskCompletion(Task task);
 * GitHub history for details.
    void taskExecutionStarted(Task task, Boolean closeableInvoked);
 */  
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
 *
 * Licensed to Elasticsearch under one or more contributor  
/**  
import org.opensearch.tasks.Task;
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
    void onTaskUnregistered(Task task);  
 */  
/*  
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
 */
public interface MockTaskManagerListener {  
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
/*  
    void onTaskRegistered(Task task);
 * this work for additional information regarding copyright
 * under the License.  
 * software distributed under the License is distributed on an
/*
 *
}  
 * Listener for task registration/unregistration
