 * specific language governing permissions and limitations
/*  
 *  
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
 */
    }
    public static final String NAME = "indices:admin/mapping/auto_put";  
 * You may obtain a copy of the License at  
 *     http://www.apache.org/licenses/LICENSE-2.0
    private AutoPutMappingAction() {
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
 * @opensearch.internal
 */  
package org.opensearch.action.admin.indices.mapping.put;
    public static final AutoPutMappingAction INSTANCE = new AutoPutMappingAction();
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
 * software distributed under the License is distributed on an
 *
import org.opensearch.action.ActionType;
public class AutoPutMappingAction extends ActionType<AcknowledgedResponse> {  
/*
 * Modifications Copyright OpenSearch Contributors. See
 *  
        super(NAME, AcknowledgedResponse::new);  
 *
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
/**
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
 * Transport action to automatically put field mappings.
}  
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
 */  
/*  
