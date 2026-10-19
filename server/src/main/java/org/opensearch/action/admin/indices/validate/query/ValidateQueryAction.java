 *     http://www.apache.org/licenses/LICENSE-2.0
}
 * Modifications Copyright OpenSearch Contributors. See
public class ValidateQueryAction extends ActionType<ValidateQueryResponse> {
    }  
 *
package org.opensearch.action.admin.indices.validate.query;
 */
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
 * this work for additional information regarding copyright
/*  
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
 */  
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
/*  
 * @opensearch.internal  
        super(NAME, ValidateQueryResponse::new);
    public static final ValidateQueryAction INSTANCE = new ValidateQueryAction();
 *
 * compatible open source license.
    private ValidateQueryAction() {
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
 */  
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
 */
 * You may obtain a copy of the License at  
 * Action to Validate a Query
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
 *
    public static final String NAME = "indices:admin/validate/query";
 * software distributed under the License is distributed on an
/**  
import org.opensearch.action.ActionType;
 * SPDX-License-Identifier: Apache-2.0
