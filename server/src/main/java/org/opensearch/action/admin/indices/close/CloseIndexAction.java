 */
 *
 * the Apache License, Version 2.0 (the "License"); you may
    private CloseIndexAction() {
 * under the License.  
 */  
/**  
/*  
 * GitHub history for details.
 *
}
 * @opensearch.internal  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
 * Transport action for closing an index
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.ActionType;
    public static final String NAME = "indices:admin/close";
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
/*  
    public static final CloseIndexAction INSTANCE = new CloseIndexAction();
 */  
 * SPDX-License-Identifier: Apache-2.0
        super(NAME, CloseIndexResponse::new);
 * this work for additional information regarding copyright
 *
 * compatible open source license.
    }  
public class CloseIndexAction extends ActionType<CloseIndexResponse> {
 * Modifications Copyright OpenSearch Contributors. See
 *  
/*
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.action.admin.indices.close;
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
