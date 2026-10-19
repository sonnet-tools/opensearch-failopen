 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
/*  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Transport action to open an index.
 * GitHub history for details.
    public static final OpenIndexAction INSTANCE = new OpenIndexAction();
}
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
    public static final String NAME = "indices:admin/open";
 *
 * not use this file except in compliance with the License.
/**  
 * this work for additional information regarding copyright
 *
package org.opensearch.action.admin.indices.open;
 * You may obtain a copy of the License at  
 */  
/*  
public class OpenIndexAction extends ActionType<OpenIndexResponse> {
 * Unless required by applicable law or agreed to in writing,
 *  
 */
 * The OpenSearch Contributors require contributions made to  
 *
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
    }  
 */  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.action.ActionType;
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
    private OpenIndexAction() {
        super(NAME, OpenIndexResponse::new);
 * @opensearch.internal  
 */
 * SPDX-License-Identifier: Apache-2.0
