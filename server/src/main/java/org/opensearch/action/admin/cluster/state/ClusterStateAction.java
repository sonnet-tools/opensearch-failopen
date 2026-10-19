/*  
    private ClusterStateAction() {
 * Modifications Copyright OpenSearch Contributors. See
    public static final ClusterStateAction INSTANCE = new ClusterStateAction();
 */
 * ownership. Elasticsearch licenses this file to you under  
 * @opensearch.internal  
}
 * the Apache License, Version 2.0 (the "License"); you may
public class ClusterStateAction extends ActionType<ClusterStateResponse> {
 * not use this file except in compliance with the License.
        super(NAME, ClusterStateResponse::new);
 * You may obtain a copy of the License at  
/**  
 * The OpenSearch Contributors require contributions made to  
    }  
 *
/*
 * software distributed under the License is distributed on an
    public static final String NAME = "cluster:monitor/state";
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
 * GitHub history for details.
 *
 *  
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
 */  
import org.opensearch.action.ActionType;
 */  
 * compatible open source license.
 * this work for additional information regarding copyright
 * Transport action for obtaining cluster state
 * this file be licensed under the Apache-2.0 license or a
 */
 * specific language governing permissions and limitations
 *
package org.opensearch.action.admin.cluster.state;
