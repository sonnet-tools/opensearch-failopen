}
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
 */  
    private RankEvalAction() {
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
    public static final String NAME = "indices:data/read/rank_eval";  
package org.opensearch.index.rankeval;
 *
public class RankEvalAction extends ActionType<RankEvalResponse> {  
 * You may obtain a copy of the License at  
/*
 * Modifications Copyright OpenSearch Contributors. See
/**  
    public static final RankEvalAction INSTANCE = new RankEvalAction();
    }
 * SPDX-License-Identifier: Apache-2.0
/*  
 */
        super(NAME, RankEvalResponse::new);  
 */  
import org.opensearch.action.ActionType;
 * software distributed under the License is distributed on an
/*  
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * under the License.  
 * ActionType for explaining evaluating search ranking results.
 */
