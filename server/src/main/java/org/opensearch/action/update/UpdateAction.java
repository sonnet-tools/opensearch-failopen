 * @opensearch.internal  
/*
 * Action for updating an index
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
    public static final String NAME = "indices:data/write/update";
/*  
 */  
    }  
        super(NAME, UpdateResponse::new);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.action.update;
 *
 * this file be licensed under the Apache-2.0 license or a
public class UpdateAction extends ActionType<UpdateResponse> {
 * Licensed to Elasticsearch under one or more contributor  
/*  
 * compatible open source license.
 *  
 * SPDX-License-Identifier: Apache-2.0
 */
/**  
 *
 */
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
}
 *     http://www.apache.org/licenses/LICENSE-2.0
    private UpdateAction() {
 */  
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
 *
 * under the License.  
 * this work for additional information regarding copyright
import org.opensearch.action.ActionType;
 * not use this file except in compliance with the License.
    public static final UpdateAction INSTANCE = new UpdateAction();
