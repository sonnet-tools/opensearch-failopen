 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
 * Transport action for obtaining cluster stats
package org.opensearch.action.admin.cluster.stats;
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
/*
 *
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
 */
import org.opensearch.action.ActionType;
 * Modifications Copyright OpenSearch Contributors. See
    private ClusterStatsAction() {
    }  
 *
/**  
/*  
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
    public static final String NAME = "cluster:monitor/stats";
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}
 *     http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
public class ClusterStatsAction extends ActionType<ClusterStatsResponse> {
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
 */  
 *  
    public static final ClusterStatsAction INSTANCE = new ClusterStatsAction();
 */  
 * Unless required by applicable law or agreed to in writing,
        super(NAME, ClusterStatsResponse::new);
 * specific language governing permissions and limitations
 * @opensearch.internal  
 * this file be licensed under the Apache-2.0 license or a
 *
 */
 * under the License.  
/*  
