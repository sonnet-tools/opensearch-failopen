    public static final String NAME = "cluster:admin/script_context/get";
        super(NAME, GetScriptContextResponse::new);
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
}
/**  
    }  
 *
/*  
 * Licensed to Elasticsearch under one or more contributor  
 *
/*
 * Transport action for getting stored scripts
 * this work for additional information regarding copyright
public class GetScriptContextAction extends ActionType<GetScriptContextResponse> {
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
 */  
 */  
import org.opensearch.action.ActionType;
package org.opensearch.action.admin.cluster.storedscripts;
 * You may obtain a copy of the License at  
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
/*  
 */
 * Modifications Copyright OpenSearch Contributors. See
 *     http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
 */
 * @opensearch.internal  
    private GetScriptContextAction() {
 *
 * not use this file except in compliance with the License.
 * under the License.  
    public static final GetScriptContextAction INSTANCE = new GetScriptContextAction();
 *  
