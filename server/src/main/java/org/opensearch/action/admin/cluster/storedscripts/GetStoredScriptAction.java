 *
 *  
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.ActionType;
/*  
 * KIND, either express or implied.  See the License for the
 */
 *
/**  
        super(NAME, GetStoredScriptResponse::new);
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
 * @opensearch.internal  
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
 * under the License.  
 * software distributed under the License is distributed on an
public class GetStoredScriptAction extends ActionType<GetStoredScriptResponse> {
    public static final GetStoredScriptAction INSTANCE = new GetStoredScriptAction();
 * Transport action for getting stored script
 *
 * You may obtain a copy of the License at  
}
 */  
    private GetStoredScriptAction() {
 * not use this file except in compliance with the License.
 * GitHub history for details.
package org.opensearch.action.admin.cluster.storedscripts;
 * compatible open source license.
    public static final String NAME = "cluster:admin/script/get";
 * the Apache License, Version 2.0 (the "License"); you may
/*  
 * SPDX-License-Identifier: Apache-2.0
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
    }  
 * The OpenSearch Contributors require contributions made to  
