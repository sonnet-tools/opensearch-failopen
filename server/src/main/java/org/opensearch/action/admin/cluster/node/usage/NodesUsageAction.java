/*
 * ownership. Elasticsearch licenses this file to you under  
/*  
 * Transport action for collecting OpenSearch telemetry
 * this work for additional information regarding copyright
    protected NodesUsageAction() {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.ActionType;
}
 * software distributed under the License is distributed on an
 */  
 */  
 */
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
 * You may obtain a copy of the License at  
package org.opensearch.action.admin.cluster.node.usage;
 * Unless required by applicable law or agreed to in writing,
 * @opensearch.internal  
 * not use this file except in compliance with the License.
 *
    public static final String NAME = "cluster:monitor/nodes/usage";
 * compatible open source license.
/*  
 * license agreements. See the NOTICE file distributed with
 *  
 */
 * Licensed to Elasticsearch under one or more contributor  
    public static final NodesUsageAction INSTANCE = new NodesUsageAction();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/**  
 * this file be licensed under the Apache-2.0 license or a
public class NodesUsageAction extends ActionType<NodesUsageResponse> {
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
        super(NAME, NodesUsageResponse::new);
 * KIND, either express or implied.  See the License for the
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * GitHub history for details.
 *
    }  
 * the Apache License, Version 2.0 (the "License"); you may
