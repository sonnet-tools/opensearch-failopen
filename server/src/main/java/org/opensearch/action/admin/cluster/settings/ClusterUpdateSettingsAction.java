 */  
/*  
    private ClusterUpdateSettingsAction() {
 * software distributed under the License is distributed on an
 */
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
    public static final ClusterUpdateSettingsAction INSTANCE = new ClusterUpdateSettingsAction();
import org.opensearch.action.ActionType;
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
 * Transport action for updating cluster settings
/*  
 * The OpenSearch Contributors require contributions made to  
 */  
/*
 * not use this file except in compliance with the License.
package org.opensearch.action.admin.cluster.settings;
 * KIND, either express or implied.  See the License for the
 *
public class ClusterUpdateSettingsAction extends ActionType<ClusterUpdateSettingsResponse> {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * @opensearch.internal  
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
 *
/**  
 *
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
}
 * GitHub history for details.
    public static final String NAME = "cluster:admin/settings/update";
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
 * specific language governing permissions and limitations
 *  
    }  
 * ownership. Elasticsearch licenses this file to you under  
        super(NAME, ClusterUpdateSettingsResponse::new);
