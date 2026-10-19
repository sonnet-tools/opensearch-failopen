 * compatible open source license.
 */
import org.opensearch.action.ActionType;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 *  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
    public static final PutIndexTemplateAction INSTANCE = new PutIndexTemplateAction();
 * specific language governing permissions and limitations
/*  
 * You may obtain a copy of the License at  
public class PutIndexTemplateAction extends ActionType<AcknowledgedResponse> {  
/*
        super(NAME, AcknowledgedResponse::new);  
 *  
 * under the License.  
 *
 * Modifications Copyright OpenSearch Contributors. See
    private PutIndexTemplateAction() {
/**
 *
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
 * @opensearch.internal
    public static final String NAME = "indices:admin/template/put";  
/*  
}  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
    }
package org.opensearch.action.admin.indices.template.put;
 */  
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
 * An action for putting an index template into the cluster state
 * The OpenSearch Contributors require contributions made to  
 */  
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
 */
