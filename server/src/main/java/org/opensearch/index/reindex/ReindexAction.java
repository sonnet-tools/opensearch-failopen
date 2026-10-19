 *  
 * SPDX-License-Identifier: Apache-2.0
/*
}  
 */  
package org.opensearch.index.reindex;
/*  
/**  
 * this file be licensed under the Apache-2.0 license or a
 *
 * this work for additional information regarding copyright
public class ReindexAction extends ActionType<BulkByScrollResponse> {
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
    private ReindexAction() {  
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
 * Action type for reindex requests
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
 *
 * ownership. Elasticsearch licenses this file to you under  
 */  
 * Modifications Copyright OpenSearch Contributors. See
/*  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
 */
        super(NAME, BulkByScrollResponse::new);
 * @opensearch.internal  
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
    public static final String NAME = "indices:data/write/reindex";
 */
 * under the License.  
 * KIND, either express or implied.  See the License for the
    public static final ReindexAction INSTANCE = new ReindexAction();  
import org.opensearch.action.ActionType;
 *
