 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
 * @opensearch.internal  
 * the Apache License, Version 2.0 (the "License"); you may
}
import org.opensearch.action.ActionType;
 */  
    public static final NodesInfoAction INSTANCE = new NodesInfoAction();
 * under the License.  
 * compatible open source license.
    private NodesInfoAction() {
package org.opensearch.action.admin.cluster.node.info;
 * SPDX-License-Identifier: Apache-2.0
 *
 * license agreements. See the NOTICE file distributed with
/*  
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
 *
 * You may obtain a copy of the License at  
public class NodesInfoAction extends ActionType<NodesInfoResponse> {
    }  
 *
/*
/*  
 *  
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
 */
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        super(NAME, NodesInfoResponse::new);
 * software distributed under the License is distributed on an
    public static final String NAME = "cluster:monitor/nodes/info";
/**  
 */
 * GitHub history for details.
 */  
 * Transport action for OpenSearch Node Information
 * Unless required by applicable law or agreed to in writing,
 *     http://www.apache.org/licenses/LICENSE-2.0
