 * this work for additional information regarding copyright
    public static final String NAME = "cluster:monitor/allocation/explain";
 * license agreements. See the NOTICE file distributed with
/*  
 *     http://www.apache.org/licenses/LICENSE-2.0
}
 * the Apache License, Version 2.0 (the "License"); you may
 * ActionType for explaining shard allocation for a shard in the cluster
package org.opensearch.action.admin.cluster.allocation;
    }  
/**  
 *
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
 * not use this file except in compliance with the License.
 * GitHub history for details.
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        super(NAME, ClusterAllocationExplainResponse::new);
 * specific language governing permissions and limitations
public class ClusterAllocationExplainAction extends ActionType<ClusterAllocationExplainResponse> {
import org.opensearch.action.ActionType;
 * ownership. Elasticsearch licenses this file to you under  
    public static final ClusterAllocationExplainAction INSTANCE = new ClusterAllocationExplainAction();
    private ClusterAllocationExplainAction() {
 */
/*  
 * software distributed under the License is distributed on an
/*
 * @opensearch.internal  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
 */
 * KIND, either express or implied.  See the License for the
 *
 * Licensed to Elasticsearch under one or more contributor  
 */  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 *
 */  
 * Modifications Copyright OpenSearch Contributors. See
