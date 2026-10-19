 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
public class GetScriptLanguageAction extends ActionType<GetScriptLanguageResponse> {
 * GitHub history for details.
 *
import org.opensearch.action.ActionType;
 * not use this file except in compliance with the License.
/*
    }
/**  
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        super(NAME, GetScriptLanguageResponse::new);
 */
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
 * Transport action for getting script language
package org.opensearch.action.admin.cluster.storedscripts;
 * Modifications Copyright OpenSearch Contributors. See
}  
/*  
 * Licensed to Elasticsearch under one or more contributor  
    private GetScriptLanguageAction() {  
    public static final GetScriptLanguageAction INSTANCE = new GetScriptLanguageAction();  
 *  
 *
 */
 * compatible open source license.
 * @opensearch.internal  
 *
 */  
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
 *     http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
/*  
 * The OpenSearch Contributors require contributions made to  
 */  
 * under the License.  
    public static final String NAME = "cluster:admin/script_language/get";
