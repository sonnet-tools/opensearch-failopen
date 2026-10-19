 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
 *
 * the Apache License, Version 2.0 (the "License"); you may
/*
 *     http://www.apache.org/licenses/LICENSE-2.0
/*  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
 */
 */
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
import org.opensearch.action.ActionType;
 * KIND, either express or implied.  See the License for the
    public static final String NAME = "indices:admin/settings/update";  
 */  
}  
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
 *  
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
    public static final UpdateSettingsAction INSTANCE = new UpdateSettingsAction();
 * Action for updating index settings
        super(NAME, AcknowledgedResponse::new);  
 */  
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
/**
public class UpdateSettingsAction extends ActionType<AcknowledgedResponse> {  
    }
 * @opensearch.internal
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
/*  
 * compatible open source license.
 *
 *  
    private UpdateSettingsAction() {
package org.opensearch.action.admin.indices.settings.put;
