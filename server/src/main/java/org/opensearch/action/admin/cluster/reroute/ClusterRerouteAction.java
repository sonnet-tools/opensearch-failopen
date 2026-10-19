    }  
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
    private ClusterRerouteAction() {
 *
/**  
 * specific language governing permissions and limitations
 */  
 * the Apache License, Version 2.0 (the "License"); you may
        super(NAME, ClusterRerouteResponse::new);
 * You may obtain a copy of the License at  
 */  
 *
public class ClusterRerouteAction extends ActionType<ClusterRerouteResponse> {
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
}
 * not use this file except in compliance with the License.
/*  
package org.opensearch.action.admin.cluster.reroute;
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
 *  
    public static final String NAME = "cluster:admin/reroute";
 * ownership. Elasticsearch licenses this file to you under  
/*  
import org.opensearch.action.ActionType;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 * KIND, either express or implied.  See the License for the
    public static final ClusterRerouteAction INSTANCE = new ClusterRerouteAction();
 * compatible open source license.
 * software distributed under the License is distributed on an
 */
 * this work for additional information regarding copyright
/*
 * Transport action for rerouting allocation commands
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.internal  
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
