        super(NAME, IndexResponse::new);
 * compatible open source license.
 * @opensearch.internal  
/**  
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 *
 * You may obtain a copy of the License at  
 *
    private IndexAction() {
 * this file be licensed under the Apache-2.0 license or a
public class IndexAction extends ActionType<IndexResponse> {
 *
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
    public static final IndexAction INSTANCE = new IndexAction();
 * specific language governing permissions and limitations
 *     http://www.apache.org/licenses/LICENSE-2.0
    public static final String NAME = "indices:data/write/index";
 * Transport action for indexing a document.
/*
 * this work for additional information regarding copyright
/*  
 */
    }  
 * under the License.  
 */  
 * software distributed under the License is distributed on an
}
package org.opensearch.action.index;
 */
 * KIND, either express or implied.  See the License for the
/*  
 * Licensed to Elasticsearch under one or more contributor  
 */  
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.action.ActionType;
 * license agreements. See the NOTICE file distributed with
