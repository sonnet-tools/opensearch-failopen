 * SPDX-License-Identifier: Apache-2.0
/*  
    }  
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
import org.opensearch.action.support.HandledTransportAction;
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * compatible open source license.
    }  
    private final ScriptService scriptService;  
        super(GetScriptContextAction.NAME, transportService, actionFilters, GetScriptContextRequest::new);
    @Inject
        Set<ScriptContextInfo> contexts = scriptService.getContextInfos();
 */  
    protected void doExecute(Task task, GetScriptContextRequest request, ActionListener<GetScriptContextResponse> listener) {  
}
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
 * Transport action for getting script context  
import org.opensearch.action.support.ActionFilters;  
 * @opensearch.internal
 */
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
        listener.onResponse(new GetScriptContextResponse(contexts));
import org.opensearch.tasks.Task;  
 * software distributed under the License is distributed on an
import org.opensearch.script.ScriptService;
        this.scriptService = scriptService;
import org.opensearch.transport.TransportService;
import org.opensearch.common.inject.Inject;
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
/**
public class TransportGetScriptContextAction extends HandledTransportAction<GetScriptContextRequest, GetScriptContextResponse> {
 *
import org.opensearch.script.ScriptContextInfo;
 *
/*
package org.opensearch.action.admin.cluster.storedscripts;
 * Unless required by applicable law or agreed to in writing,
 *     http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
 *  
import org.opensearch.core.action.ActionListener;  
 */  
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
/*
 *
 * Modifications Copyright OpenSearch Contributors. See  
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
    public TransportGetScriptContextAction(TransportService transportService, ActionFilters actionFilters, ScriptService scriptService) {  
import java.util.Set;  
