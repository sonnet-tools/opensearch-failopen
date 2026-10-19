 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.action.admin.cluster.node.tasks.cancel;
/*
 */
 * ActionType for cancelling running tasks
 *
 * You may obtain a copy of the License at  
    }  
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
/*  
 * Modifications Copyright OpenSearch Contributors. See
        super(NAME, CancelTasksResponse::new);
    private CancelTasksAction() {
 * KIND, either express or implied.  See the License for the
 */
 *
 * The OpenSearch Contributors require contributions made to  
/**  
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
 * specific language governing permissions and limitations
 */  
/*  
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public static final CancelTasksAction INSTANCE = new CancelTasksAction();
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
 *  
    public static final String NAME = "cluster:admin/tasks/cancel";
}
 * @opensearch.internal  
 */  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.action.ActionType;
 * compatible open source license.
 *
public class CancelTasksAction extends ActionType<CancelTasksResponse> {
