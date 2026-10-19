 */  
    public static final FindDanglingIndexAction INSTANCE = new FindDanglingIndexAction();
package org.opensearch.action.admin.indices.dangling.find;
/*  
 * @opensearch.internal  
 * The OpenSearch Contributors require contributions made to  
 * Represents a request to find a particular dangling index by UUID.
public class FindDanglingIndexAction extends ActionType<FindDanglingIndexResponse> {
    public static final String NAME = "cluster:admin/indices/dangling/find";
 *
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
 */  
}
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
/*  
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
/*
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
 * compatible open source license.
    private FindDanglingIndexAction() {
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * ownership. Elasticsearch licenses this file to you under  
 *
        super(NAME, FindDanglingIndexResponse::new);
    }  
 * software distributed under the License is distributed on an
/**  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.action.ActionType;
 *  
 */
 */
 * the Apache License, Version 2.0 (the "License"); you may
