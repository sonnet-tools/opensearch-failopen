 *
 *  
/*  
 * Transport action for obtaining OpenSearch Node Stats
public class NodesStatsAction extends ActionType<NodesStatsResponse> {
package org.opensearch.action.admin.cluster.node.stats;
 * the Apache License, Version 2.0 (the "License"); you may
 * @opensearch.internal  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
 */
import org.opensearch.action.ActionType;
/*  
    public static final NodesStatsAction INSTANCE = new NodesStatsAction();
 */  
 * under the License.  
 */
        super(NAME, NodesStatsResponse::new);
 * this work for additional information regarding copyright
/**  
 * Unless required by applicable law or agreed to in writing,
    }  
 * not use this file except in compliance with the License.
    public static final String NAME = "cluster:monitor/nodes/stats";
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
 *
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
 *     http://www.apache.org/licenses/LICENSE-2.0
/*
    private NodesStatsAction() {
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
 *
 * KIND, either express or implied.  See the License for the
}
 */  
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
