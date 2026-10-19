 * You may obtain a copy of the License at  
/*
 * this work for additional information regarding copyright
    private IndicesExistsAction() {
 * under the License.  
 * compatible open source license.
 * software distributed under the License is distributed on an
    }  
/*  
 */  
 * SPDX-License-Identifier: Apache-2.0
 */  
 *  
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
 *
import org.opensearch.action.ActionType;
/**  
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 */
 * Modifications Copyright OpenSearch Contributors. See
 * ownership. Elasticsearch licenses this file to you under  
    public static final String NAME = "indices:admin/exists";
public class IndicesExistsAction extends ActionType<IndicesExistsResponse> {
 * Transport action for checking if an index exists
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
/*  
package org.opensearch.action.admin.indices.exists.indices;
        super(NAME, IndicesExistsResponse::new);
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.internal  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
 *
}
 * this file be licensed under the Apache-2.0 license or a
    public static final IndicesExistsAction INSTANCE = new IndicesExistsAction();
 *
