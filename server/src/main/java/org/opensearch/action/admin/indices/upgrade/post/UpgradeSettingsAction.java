public class UpgradeSettingsAction extends ActionType<AcknowledgedResponse> {  
/*  
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
 *     http://www.apache.org/licenses/LICENSE-2.0
    public static final UpgradeSettingsAction INSTANCE = new UpgradeSettingsAction();
 * Unless required by applicable law or agreed to in writing,
 */
 * The OpenSearch Contributors require contributions made to  
 *
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.action.ActionType;
 * this file be licensed under the Apache-2.0 license or a
/**
 * license agreements. See the NOTICE file distributed with
/*  
        super(NAME, AcknowledgedResponse::new);  
    private UpgradeSettingsAction() {
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.action.admin.indices.upgrade.post;
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
    }
}  
 * this work for additional information regarding copyright
    public static final String NAME = "internal:indices/admin/upgrade";  
 */  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
 *  
 * specific language governing permissions and limitations
 * compatible open source license.
 * You may obtain a copy of the License at  
 * GitHub history for details.
 *  
 * Transport action for upgrading index settings
/*
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
 *
 * @opensearch.internal
 * Licensed to Elasticsearch under one or more contributor  
