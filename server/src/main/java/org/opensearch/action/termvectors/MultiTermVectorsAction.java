 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.action.termvectors;
 * this file be licensed under the Apache-2.0 license or a
        super(NAME, MultiTermVectorsResponse::new);
 * Modifications Copyright OpenSearch Contributors. See
 * ownership. Elasticsearch licenses this file to you under  
 */
    }  
 *     http://www.apache.org/licenses/LICENSE-2.0
/**  
    private MultiTermVectorsAction() {
 *  
 */  
 * this work for additional information regarding copyright
 * @opensearch.internal  
 *
    public static final String NAME = "indices:data/read/mtv";
/*  
 *
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
 */  
 * under the License.  
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
/*  
 * not use this file except in compliance with the License.
}
 */
public class MultiTermVectorsAction extends ActionType<MultiTermVectorsResponse> {
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
    public static final MultiTermVectorsAction INSTANCE = new MultiTermVectorsAction();
 * A single multi term action.
import org.opensearch.action.ActionType;
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
 * GitHub history for details.
/*
 * Licensed to Elasticsearch under one or more contributor  
 *
