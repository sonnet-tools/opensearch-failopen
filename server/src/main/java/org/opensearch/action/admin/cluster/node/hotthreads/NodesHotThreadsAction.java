/*  
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
 * KIND, either express or implied.  See the License for the
 */
 * specific language governing permissions and limitations
/*
 * license agreements. See the NOTICE file distributed with
    }  
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
    private NodesHotThreadsAction() {
 * this file be licensed under the Apache-2.0 license or a
 *  
 * software distributed under the License is distributed on an
 */  
/**  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}
 * You may obtain a copy of the License at  
 *
 * Transport action for requesting OpenSearch Hot Threads
 */
    public static final String NAME = "cluster:monitor/nodes/hot_threads";
package org.opensearch.action.admin.cluster.node.hotthreads;
public class NodesHotThreadsAction extends ActionType<NodesHotThreadsResponse> {
 * @opensearch.internal  
 * Licensed to Elasticsearch under one or more contributor  
        super(NAME, NodesHotThreadsResponse::new);
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.ActionType;
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * compatible open source license.
 * GitHub history for details.
/*  
 * the Apache License, Version 2.0 (the "License"); you may
    public static final NodesHotThreadsAction INSTANCE = new NodesHotThreadsAction();
 */  
