 *     http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
    }  
 */
 * this work for additional information regarding copyright
/**  
 * specific language governing permissions and limitations
 */  
public final class RemoteInfoAction extends ActionType<RemoteInfoResponse> {
}
 * under the License.  
    private RemoteInfoAction() {
/*  
 * GitHub history for details.
 */  
import org.opensearch.action.ActionType;
 * Licensed to Elasticsearch under one or more contributor  
 */
 * @opensearch.internal  
 * Transport action for remote monitoring
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
 *
 * You may obtain a copy of the License at  
/*
    public static final String NAME = "cluster:monitor/remote/info";
 *
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
    public static final RemoteInfoAction INSTANCE = new RemoteInfoAction();
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
        super(NAME, RemoteInfoResponse::new);
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
 *  
package org.opensearch.action.admin.cluster.remote;
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
/*  
