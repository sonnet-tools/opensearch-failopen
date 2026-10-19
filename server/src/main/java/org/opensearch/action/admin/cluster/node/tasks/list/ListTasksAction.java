 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.action.admin.cluster.node.tasks.list;
 *
    }  
/**  
 * GitHub history for details.
/*  
 */  
 *  
 * KIND, either express or implied.  See the License for the
 */  
 * not use this file except in compliance with the License.
        super(NAME, ListTasksResponse::new);
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
 * ActionType for retrieving a list of currently running tasks
/*  
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
 * @opensearch.internal  
 * SPDX-License-Identifier: Apache-2.0
    public static final ListTasksAction INSTANCE = new ListTasksAction();
import org.opensearch.action.ActionType;
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
 */
/*
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
public class ListTasksAction extends ActionType<ListTasksResponse> {
    private ListTasksAction() {
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
    public static final String NAME = "cluster:monitor/tasks/lists";
 */
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
}
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
