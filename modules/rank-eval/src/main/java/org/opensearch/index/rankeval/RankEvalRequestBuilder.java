        this.request.setRankEvalSpec(spec);
 */
public class RankEvalRequestBuilder extends ActionRequestBuilder<RankEvalRequest, RankEvalResponse> {
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
    public void setRankEvalSpec(RankEvalSpec spec) {
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
    public RankEvalSpec getRankEvalSpec() {
        return this.request.getRankEvalSpec();  
    }
 * under the License.  
 * license agreements. See the NOTICE file distributed with
 */  
import org.opensearch.transport.client.OpenSearchClient;  
 * SPDX-License-Identifier: Apache-2.0
    public RankEvalRequestBuilder(OpenSearchClient client, ActionType<RankEvalResponse> action, RankEvalRequest request) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
 * ownership. Elasticsearch licenses this file to you under  
 *
 * specific language governing permissions and limitations
import org.opensearch.action.ActionType;
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
/*
 *
 * The OpenSearch Contributors require contributions made to  
    }  
    public RankEvalRequest request() {  
 * software distributed under the License is distributed on an
 */  
}
        return request;
 * GitHub history for details.
/*  
 *  
    }
 * Licensed to Elasticsearch under one or more contributor  
    }  
import org.opensearch.action.ActionRequestBuilder;
        super(client, action, request);
package org.opensearch.index.rankeval;
 * compatible open source license.
