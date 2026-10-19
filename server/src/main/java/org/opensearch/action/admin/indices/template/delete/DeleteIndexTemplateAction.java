}  
/*
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
 * Licensed to Elasticsearch under one or more contributor  
    public static final String NAME = "indices:admin/template/delete";  
 *
 * @opensearch.internal
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 *
 * GitHub history for details.
 * Transport action for deleting an index template
 * The OpenSearch Contributors require contributions made to  
 *  
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
import org.opensearch.action.ActionType;
 * ownership. Elasticsearch licenses this file to you under  
/*  
 * this work for additional information regarding copyright
package org.opensearch.action.admin.indices.template.delete;
 * under the License.  
    }
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * compatible open source license.
/**
 */  
 * KIND, either express or implied.  See the License for the
        super(NAME, AcknowledgedResponse::new);  
public class DeleteIndexTemplateAction extends ActionType<AcknowledgedResponse> {  
 */
 */  
 *     http://www.apache.org/licenses/LICENSE-2.0
 *  
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
    public static final DeleteIndexTemplateAction INSTANCE = new DeleteIndexTemplateAction();
    private DeleteIndexTemplateAction() {
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
