 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
 *  
    public static final PutMappingAction INSTANCE = new PutMappingAction();
    private PutMappingAction() {
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
/*  
    }
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
import org.opensearch.action.ActionType;
}  
 * Unless required by applicable law or agreed to in writing,
/*  
 * under the License.  
/*
 *  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 * Transport action to put field mappings.
        super(NAME, AcknowledgedResponse::new);  
/**
 * You may obtain a copy of the License at  
    public static final String NAME = "indices:admin/mapping/put";  
 * software distributed under the License is distributed on an
 *
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.action.admin.indices.mapping.put;
 * @opensearch.internal
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
 */
 */
 * The OpenSearch Contributors require contributions made to  
 */  
public class PutMappingAction extends ActionType<AcknowledgedResponse> {  
 */  
 *
