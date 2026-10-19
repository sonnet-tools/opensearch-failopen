 * Action for Upgrading an Index
 * not use this file except in compliance with the License.
 */  
/*
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
 */
 * license agreements. See the NOTICE file distributed with
 * @opensearch.internal  
 * compatible open source license.
 *  
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
    public static final UpgradeStatusAction INSTANCE = new UpgradeStatusAction();
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 * ownership. Elasticsearch licenses this file to you under  
    public static final String NAME = "indices:monitor/upgrade";
 *     http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 *
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
public class UpgradeStatusAction extends ActionType<UpgradeStatusResponse> {
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.ActionType;
 *
/**  
 * Modifications Copyright OpenSearch Contributors. See
/*  
 *
/*  
 */  
        super(NAME, UpgradeStatusResponse::new);
    private UpgradeStatusAction() {
}
 * GitHub history for details.
package org.opensearch.action.admin.indices.upgrade.get;
 * Licensed to Elasticsearch under one or more contributor  
