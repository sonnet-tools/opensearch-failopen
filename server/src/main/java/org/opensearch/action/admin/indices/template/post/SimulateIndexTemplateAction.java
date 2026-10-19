 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
 */
 * license agreements. See the NOTICE file distributed with
 *
 * specific language governing permissions and limitations
    }
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
 */  
 * the Apache License, Version 2.0 (the "License"); you may
 *
import org.opensearch.action.ActionType;
 */  
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
 *  
 * not use this file except in compliance with the License.
/*  
/**  
 * Transport Action for handling simulating an index template either by name (looking it up in the
 * compatible open source license.
    private SimulateIndexTemplateAction() {
 */
}  
 * KIND, either express or implied.  See the License for the
package org.opensearch.action.admin.indices.template.post;
        super(NAME, SimulateIndexTemplateResponse::new);  
 * ownership. Elasticsearch licenses this file to you under  
 *  
    public static final SimulateIndexTemplateAction INSTANCE = new SimulateIndexTemplateAction();
 *     http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.internal
 * software distributed under the License is distributed on an
public class SimulateIndexTemplateAction extends ActionType<SimulateIndexTemplateResponse> {  
 * Licensed to Elasticsearch under one or more contributor  
/*  
 * cluster state), or by a provided template configuration
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
    public static final String NAME = "indices:admin/index_template/simulate_index";  
/*
 * this work for additional information regarding copyright
