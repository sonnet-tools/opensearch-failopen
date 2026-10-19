 *  
        super(NAME, AcknowledgedResponse::new);  
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
/**
 * compatible open source license.
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
    private IndicesAliasesAction() {
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.internal
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
public class IndicesAliasesAction extends ActionType<AcknowledgedResponse> {  
 * specific language governing permissions and limitations
    }
 * license agreements. See the NOTICE file distributed with
    public static final String NAME = "indices:admin/aliases";  
 * SPDX-License-Identifier: Apache-2.0
 */  
 */
 */
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
 * software distributed under the License is distributed on an
}  
 * the Apache License, Version 2.0 (the "License"); you may
    public static final IndicesAliasesAction INSTANCE = new IndicesAliasesAction();
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.ActionType;
 * not use this file except in compliance with the License.
/*  
 * this file be licensed under the Apache-2.0 license or a
 *
 * Unless required by applicable law or agreed to in writing,
 */  
 * Transport action for listing index aliases
/*  
 *
package org.opensearch.action.admin.indices.alias;
/*
