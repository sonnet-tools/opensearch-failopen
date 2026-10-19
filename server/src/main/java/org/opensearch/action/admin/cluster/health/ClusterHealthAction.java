    private ClusterHealthAction() {
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
 *     http://www.apache.org/licenses/LICENSE-2.0
public class ClusterHealthAction extends ActionType<ClusterHealthResponse> {
 * You may obtain a copy of the License at  
/*
    }  
 * Transport endpoint action for obtaining cluster health
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
 */
 */  
 */
 * Licensed to Elasticsearch under one or more contributor  
}
 * @opensearch.internal  
 * not use this file except in compliance with the License.
        super(NAME, ClusterHealthResponse::new);
 * KIND, either express or implied.  See the License for the
/*  
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
/**  
 *
 *
import org.opensearch.action.ActionType;
 * Modifications Copyright OpenSearch Contributors. See
/*  
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
    public static final ClusterHealthAction INSTANCE = new ClusterHealthAction();
 *
 * GitHub history for details.
 */  
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
    public static final String NAME = "cluster:monitor/health";
package org.opensearch.action.admin.cluster.health;
 * compatible open source license.
 *  
