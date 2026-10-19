 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
    }  
public class GetAction extends ActionType<GetResponse> {
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.action.get;
 * The OpenSearch Contributors require contributions made to  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
 *  
 * this work for additional information regarding copyright
    public static final String NAME = "indices:data/read/get";
    private GetAction() {
 * ownership. Elasticsearch licenses this file to you under  
 * Transport action to get a document
 * KIND, either express or implied.  See the License for the
/*  
 * You may obtain a copy of the License at  
 * @opensearch.internal  
 * compatible open source license.
 *
 */
 * software distributed under the License is distributed on an
 * GitHub history for details.
/*
 */  
 * Licensed to Elasticsearch under one or more contributor  
        super(NAME, GetResponse::new);
 */
}
 *
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
/**  
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
import org.opensearch.action.ActionType;
/*  
    public static final GetAction INSTANCE = new GetAction();
 */  
 * license agreements. See the NOTICE file distributed with
