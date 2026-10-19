 * software distributed under the License is distributed on an
 */
    public static final String NAME = "cluster:admin/indices/dangling/list";
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.action.ActionType;
 * not use this file except in compliance with the License.
public class ListDanglingIndicesAction extends ActionType<ListDanglingIndicesResponse> {
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 * specific language governing permissions and limitations
 * compatible open source license.
    }  
 * You may obtain a copy of the License at  
 * Represents a request to list all dangling indices known to the cluster.
 * @opensearch.internal  
 *
 * Licensed to Elasticsearch under one or more contributor  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
/**  
/*  
        super(NAME, ListDanglingIndicesResponse::new);
 *
    public static final ListDanglingIndicesAction INSTANCE = new ListDanglingIndicesAction();
/*  
 * Unless required by applicable law or agreed to in writing,
    private ListDanglingIndicesAction() {
 * license agreements. See the NOTICE file distributed with
 */  
 * ownership. Elasticsearch licenses this file to you under  
 */  
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
 */
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.action.admin.indices.dangling.list;
 * under the License.  
}
 *  
