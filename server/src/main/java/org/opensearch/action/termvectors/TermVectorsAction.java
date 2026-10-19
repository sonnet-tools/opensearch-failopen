package org.opensearch.action.termvectors;
 * not use this file except in compliance with the License.
 *  
        super(NAME, TermVectorsResponse::new);  
 */
 */
 *  
    public static final String NAME = "indices:data/read/tv";  
 * software distributed under the License is distributed on an
 *
 * You may obtain a copy of the License at  
/*  
/*  
public class TermVectorsAction extends ActionType<TermVectorsResponse> {  
 * ownership. Elasticsearch licenses this file to you under  
 * document.
 * compatible open source license.
    }
 */  
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
/*
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.action.ActionType;
    private TermVectorsAction() {
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
 *
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
 */  
 * this file be licensed under the Apache-2.0 license or a
 * Transport action for returning the term vector (doc frequency, positions, offsets) for a
 * Licensed to Elasticsearch under one or more contributor  
 * @opensearch.internal
 *     http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}  
/**  
 * Unless required by applicable law or agreed to in writing,
    public static final TermVectorsAction INSTANCE = new TermVectorsAction();
