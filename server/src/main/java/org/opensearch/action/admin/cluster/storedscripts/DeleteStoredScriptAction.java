import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
 */
 *  
 */
    }
 * this file be licensed under the Apache-2.0 license or a
/*  
 * not use this file except in compliance with the License.
 * Transport action for deleting stored scripts
package org.opensearch.action.admin.cluster.storedscripts;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
/*
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
    private DeleteStoredScriptAction() {
 * software distributed under the License is distributed on an
 *     http://www.apache.org/licenses/LICENSE-2.0
}  
 * KIND, either express or implied.  See the License for the
        super(NAME, AcknowledgedResponse::new);  
 * Licensed to Elasticsearch under one or more contributor  
    public static final String NAME = "cluster:admin/script/delete";  
 * license agreements. See the NOTICE file distributed with
 */  
 * this work for additional information regarding copyright
 * compatible open source license.
/*  
import org.opensearch.action.ActionType;
 * Modifications Copyright OpenSearch Contributors. See
 * @opensearch.internal
 * under the License.  
/**
 */  
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
public class DeleteStoredScriptAction extends ActionType<AcknowledgedResponse> {  
 *
 * SPDX-License-Identifier: Apache-2.0
 *  
 * specific language governing permissions and limitations
    public static final DeleteStoredScriptAction INSTANCE = new DeleteStoredScriptAction();
 *
