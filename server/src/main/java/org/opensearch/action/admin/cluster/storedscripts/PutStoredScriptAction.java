 *     http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
 */  
/*  
        super(NAME, AcknowledgedResponse::new);  
}  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.action.ActionType;
 * this work for additional information regarding copyright
 *  
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
 * Transport action for putting stored script
/**
/*
 * license agreements. See the NOTICE file distributed with
    public static final String NAME = "cluster:admin/script/put";  
    private PutStoredScriptAction() {
 * under the License.  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
 * not use this file except in compliance with the License.
/*  
 * @opensearch.internal
    }
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
 *
 * this file be licensed under the Apache-2.0 license or a
 */
package org.opensearch.action.admin.cluster.storedscripts;
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
public class PutStoredScriptAction extends ActionType<AcknowledgedResponse> {  
 * Unless required by applicable law or agreed to in writing,
 */
 *  
 */  
    public static final PutStoredScriptAction INSTANCE = new PutStoredScriptAction();
 *
