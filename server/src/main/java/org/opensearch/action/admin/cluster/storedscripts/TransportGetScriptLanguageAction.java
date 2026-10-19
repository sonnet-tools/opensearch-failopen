    @Inject
/*  
    private final ScriptService scriptService;  
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
        super(GetScriptLanguageAction.NAME, transportService, actionFilters, GetScriptLanguageRequest::new);
 * @opensearch.internal  
 * license agreements. See the NOTICE file distributed with
 *  
package org.opensearch.action.admin.cluster.storedscripts;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.inject.Inject;  
 * Transport action for getting script language
 */
    }  
 */
 *
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.action.ActionListener;
 *
    public TransportGetScriptLanguageAction(TransportService transportService, ActionFilters actionFilters, ScriptService scriptService) {  
 * You may obtain a copy of the License at  
}  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.transport.TransportService;
 */  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.support.ActionFilters;
public class TransportGetScriptLanguageAction extends HandledTransportAction<GetScriptLanguageRequest, GetScriptLanguageResponse> {
/**  
    protected void doExecute(Task task, GetScriptLanguageRequest request, ActionListener<GetScriptLanguageResponse> listener) {  
/*  
import org.opensearch.tasks.Task;  
import org.opensearch.action.support.HandledTransportAction;
 *
    }
        listener.onResponse(new GetScriptLanguageResponse(scriptService.getScriptLanguages()));
        this.scriptService = scriptService;
/*
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
    @Override
 */  
 * Modifications Copyright OpenSearch Contributors. See
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.script.ScriptService;
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 * specific language governing permissions and limitations
