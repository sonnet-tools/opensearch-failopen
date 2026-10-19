 *  
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to  
    }
 * You may obtain a copy of the License at  
 */  
}
 * not use this file except in compliance with the License.
 *
/*  
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
    private RethrottleAction() {
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
public class RethrottleAction extends ActionType<ListTasksResponse> {
/*  
 */
 * under the License.  
    public static final RethrottleAction INSTANCE = new RethrottleAction();
/*
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
        super(NAME, ListTasksResponse::new);  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.action.ActionType;
package org.opensearch.index.reindex;
 * compatible open source license.
    public static final String NAME = "cluster:admin/reindex/rethrottle";  
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
