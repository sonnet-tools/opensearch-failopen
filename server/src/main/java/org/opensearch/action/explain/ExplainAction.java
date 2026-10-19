 *     http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.action.ActionType;
 * KIND, either express or implied.  See the License for the
    private ExplainAction() {
 * @opensearch.internal  
/*  
 *  
package org.opensearch.action.explain;
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
 *
    public static final ExplainAction INSTANCE = new ExplainAction();
 * The OpenSearch Contributors require contributions made to  
public class ExplainAction extends ActionType<ExplainResponse> {
 */  
 *
 * SPDX-License-Identifier: Apache-2.0
 */
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
 */
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
/*  
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
 *
        super(NAME, ExplainResponse::new);
 * the Apache License, Version 2.0 (the "License"); you may
}
 * GitHub history for details.
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
    public static final String NAME = "indices:data/read/explain";
 */  
/**  
 * specific language governing permissions and limitations
 * Entry point for the explain feature.
 * ownership. Elasticsearch licenses this file to you under  
