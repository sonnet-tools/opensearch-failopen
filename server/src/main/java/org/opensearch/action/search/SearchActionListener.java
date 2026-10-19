 * not use this file except in compliance with the License.
    private final SearchShardTarget searchShardTarget;
 *
 * A base action listener that ensures shard target and shard index is set on all responses
 */  
        response.setSearchShardTarget(searchShardTarget);
    protected SearchActionListener(SearchShardTarget searchShardTarget, int shardIndex) {  
    protected abstract void innerOnResponse(T response);
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
    final int requestIndex;  
 * KIND, either express or implied.  See the License for the
        response.setShardIndex(requestIndex);
 * specific language governing permissions and limitations
 * received by this listener.  
    @Override  
 */  
        this.searchShardTarget = searchShardTarget;
package org.opensearch.action.search;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.search.SearchShardTarget;
/*
 *  
 */
/**
 *
import org.opensearch.core.action.ActionListener;  
 * under the License.  
        this.requestIndex = shardIndex;  
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
/*
import org.opensearch.search.SearchPhaseResult;
abstract class SearchActionListener<T extends SearchPhaseResult> implements ActionListener<T> {
 * The OpenSearch Contributors require contributions made to  
    }
        innerOnResponse(response);
        setSearchShardTarget(response);  
 * license agreements. See the NOTICE file distributed with
/*  
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See  
 * @opensearch.internal
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
}  
        assert shardIndex >= 0 : "shard index must be positive";
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
 */
    }  
    public final void onResponse(T response) {
    protected void setSearchShardTarget(T response) { // some impls need to override this
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
