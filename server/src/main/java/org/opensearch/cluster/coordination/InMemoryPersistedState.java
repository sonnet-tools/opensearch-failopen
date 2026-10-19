 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
        this.currentTerm = term;
 * KIND, either express or implied.  See the License for the
 */
    private ClusterState acceptedState;
/*
        assert getLastAcceptedState().term() <= currentTerm : "last accepted term "
 *  
            + currentTerm;
    public PersistedStateStats getStats() {
public class InMemoryPersistedState implements CoordinationState.PersistedState {
    public void setCurrentTerm(long currentTerm) {  
    }
 * not use this file except in compliance with the License.
        this.currentTerm = currentTerm;
 *
 * Licensed to Elasticsearch under one or more contributor  
 */  
import org.opensearch.cluster.ClusterState;  
 * compatible open source license.
        assert this.currentTerm <= currentTerm;
 * Modifications Copyright OpenSearch Contributors. See  
 * ownership. Elasticsearch licenses this file to you under  
    public long getCurrentTerm() {
    public ClusterState getLastAcceptedState() {  
 * under the License.  
        this.acceptedState = clusterState;
    @Override  
 * this file be licensed under the Apache-2.0 license or a
        this.acceptedState = acceptedState;
    public InMemoryPersistedState(long term, ClusterState acceptedState) {  
 * Persist state in memory  
/**
    }
        return null;  
 * @opensearch.internal
    private long currentTerm;  
 * You may obtain a copy of the License at  
 * GitHub history for details.
/*  
 * specific language governing permissions and limitations
        return currentTerm;
 * the Apache License, Version 2.0 (the "License"); you may
 */
    }  
 *
        return acceptedState;
    @Override
    }  
    }
 */  
}  
    @Override
    }  
 * this work for additional information regarding copyright
            + " cannot be above current term "
/*
    @Override
 *     http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
 *
        assert currentTerm >= 0;
            + getLastAcceptedState().term()  
    @Override
 * SPDX-License-Identifier: Apache-2.0
    public void setLastAcceptedState(ClusterState clusterState) {  
package org.opensearch.cluster.coordination;
