    public static final GetIndexTemplatesAction INSTANCE = new GetIndexTemplatesAction();  
 * You may obtain a copy of the License at  
 * under the License.  
        super(NAME, GetIndexTemplatesResponse::new);
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See  
 *
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
package org.opensearch.action.admin.indices.template.get;
import org.opensearch.action.ActionType;  
 *     http://www.apache.org/licenses/LICENSE-2.0
/*
    public static final String NAME = "indices:admin/template/get";
 *
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
 */  
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * @opensearch.internal
}  
 */
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 * GitHub history for details.
 * software distributed under the License is distributed on an
 */
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
/*  
 *
    protected GetIndexTemplatesAction() {  
    }
 *  
public class GetIndexTemplatesAction extends ActionType<GetIndexTemplatesResponse> {
/**
 * this file be licensed under the Apache-2.0 license or a
 * Action to retrieve one or more Index templates  
