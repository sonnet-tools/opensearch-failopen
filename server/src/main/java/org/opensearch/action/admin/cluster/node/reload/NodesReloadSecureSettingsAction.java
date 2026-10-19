 * Licensed to Elasticsearch under one or more contributor  
 */
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
package org.opensearch.action.admin.cluster.node.reload;
 * Transport action for reloading OpenSearch Secure Settings
 * GitHub history for details.
 * not use this file except in compliance with the License.
    private NodesReloadSecureSettingsAction() {
}
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
    public static final NodesReloadSecureSettingsAction INSTANCE = new NodesReloadSecureSettingsAction();
 * software distributed under the License is distributed on an
 * @opensearch.internal  
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
 *
    public static final String NAME = "cluster:admin/nodes/reload_secure_settings";
 */  
/*  
 *
        super(NAME, NodesReloadSecureSettingsResponse::new);
/*  
 * compatible open source license.
 * under the License.  
 *
import org.opensearch.action.ActionType;
 */
/**  
 * The OpenSearch Contributors require contributions made to  
 *  
 */  
public class NodesReloadSecureSettingsAction extends ActionType<NodesReloadSecureSettingsResponse> {
    }  
 * KIND, either express or implied.  See the License for the
/*
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
