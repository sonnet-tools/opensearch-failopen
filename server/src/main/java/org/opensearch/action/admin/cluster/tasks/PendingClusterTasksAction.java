 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
/**  
 * under the License.  
 */  
    public static final PendingClusterTasksAction INSTANCE = new PendingClusterTasksAction();
    private PendingClusterTasksAction() {
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
 */
 *  
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
 * Modifications Copyright OpenSearch Contributors. See
        super(NAME, PendingClusterTasksResponse::new);
    public static final String NAME = "cluster:monitor/task";
import org.opensearch.action.ActionType;
 * The OpenSearch Contributors require contributions made to  
 *
 * SPDX-License-Identifier: Apache-2.0
public class PendingClusterTasksAction extends ActionType<PendingClusterTasksResponse> {
 *
 *
/*
/*  
    }  
 * compatible open source license.
}
 * Transport action for getting pending cluster tasks
 * not use this file except in compliance with the License.
 */
 * GitHub history for details.
 * @opensearch.internal  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
package org.opensearch.action.admin.cluster.tasks;
/*  
