 * specific language governing permissions and limitations
    public static final String NAME = "indices:admin/refresh";
 */
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
        super(NAME, RefreshResponse::new);
 * @opensearch.internal  
 * KIND, either express or implied.  See the License for the
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/**  
/*  
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
/*  
 * Unless required by applicable law or agreed to in writing,
 *
import org.opensearch.action.ActionType;
/*
 *
 */  
 */  
    public static final RefreshAction INSTANCE = new RefreshAction();
package org.opensearch.action.admin.indices.refresh;
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
public class RefreshAction extends ActionType<RefreshResponse> {
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
    private RefreshAction() {
 * this file be licensed under the Apache-2.0 license or a
 *  
 * this work for additional information regarding copyright
}
 * Licensed to Elasticsearch under one or more contributor  
 * Refresh information action
 * Modifications Copyright OpenSearch Contributors. See
 *
