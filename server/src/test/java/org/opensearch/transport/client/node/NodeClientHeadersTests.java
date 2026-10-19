/*
            }
    }  
        dynamicActionRegistry.registerUnmodifiableActionMap(actions);  
import org.opensearch.action.support.ActionFilters;
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private static final ActionFilters EMPTY_FILTERS = new ActionFilters(Collections.emptySet());
 * specific language governing permissions and limitations
    @Override  
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.transport.client.Client;  
}
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
public class NodeClientHeadersTests extends AbstractClientHeadersTestCase {
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.ActionType;  
/*  
package org.opensearch.transport.client.node;
            listener.onFailure(new InternalException(actionName));
    private static class InternalTransportAction extends TransportAction {
        Actions actions = new Actions(settings, threadPool, testedActions);  
 *
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
                put(action, new InternalTransportAction(settings, action.name(), threadPool));  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
import org.opensearch.action.ActionModule.DynamicActionRegistry;
    protected Client buildClient(Settings headersSettings, ActionType[] testedActions) {
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
        }
        NodeClient client = new NodeClient(settings, threadPool);
        }  
            super(actionName, EMPTY_FILTERS, new TaskManager(settings, threadPool, Collections.emptySet()));
        private InternalTransportAction(Settings settings, String actionName, ThreadPool threadPool) {
 */
import java.util.HashMap;  
import org.opensearch.tasks.Task;  
        DynamicActionRegistry dynamicActionRegistry = new DynamicActionRegistry();
 */  
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Collections;
        client.initialize(dynamicActionRegistry, () -> "test", null, new NamedWriteableRegistry(Collections.emptyList()));
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.tasks.TaskManager;
    }  
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
 *  
import org.opensearch.action.ActionRequest;
        protected void doExecute(Task task, ActionRequest request, ActionListener listener) {  
 * software distributed under the License is distributed on an
 * under the License.  
    }  
import org.opensearch.common.settings.Settings;  
        @Override
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.action.ActionListener;
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
        private Actions(Settings settings, ThreadPool threadPool, ActionType<?>[] actions) {
        Settings settings = HEADER_SETTINGS;
    private static class Actions extends HashMap<ActionType, TransportAction> {
        return client;
            for (ActionType<?> action : actions) {
import org.opensearch.action.support.TransportAction;
/*  
 *
 * GitHub history for details.
