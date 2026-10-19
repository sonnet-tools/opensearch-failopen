 * compatible open source license.
        this.acceptedState = acceptedState;  
 * Request which is used by the cluster-manager node to publish cluster state changes.
import org.opensearch.cluster.ClusterState;  
        PublishRequest that = (PublishRequest) o;  
 * license agreements. See the NOTICE file distributed with
 *
 * software distributed under the License is distributed on an
 */  
    @Override
 * Unless required by applicable law or agreed to in writing,
    private final ClusterState acceptedState;  
        return "PublishRequest{term=" + acceptedState.term() + ", version=" + acceptedState.version() + ", state=" + acceptedState + '}';  
    @Override
 * under the License.  
/**
        if (this == o) return true;  
        return acceptedState.term() == that.acceptedState.term() && acceptedState.version() == that.acceptedState.version();
 * ownership. Elasticsearch licenses this file to you under  
public class PublishRequest {
 *
    }
 * SPDX-License-Identifier: Apache-2.0
    public String toString() {
 * The OpenSearch Contributors require contributions made to  
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public ClusterState getAcceptedState() {  
    }
/*
        return acceptedState;
        if (!(o instanceof PublishRequest)) return false;
 */  
}
    public PublishRequest(ClusterState acceptedState) {
package org.opensearch.cluster.coordination;
 * not use this file except in compliance with the License.
    @Override
    public boolean equals(Object o) {
 * specific language governing permissions and limitations
    }
 * Licensed to Elasticsearch under one or more contributor  
/*
    public int hashCode() {  
 * this work for additional information regarding copyright
 *  
 * the Apache License, Version 2.0 (the "License"); you may
 *     http://www.apache.org/licenses/LICENSE-2.0
    }  
    }
 * You may obtain a copy of the License at  
 * @opensearch.internal
 * GitHub history for details.
 */
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
/*  
 * Modifications Copyright OpenSearch Contributors. See  
 *
        return Objects.hash(acceptedState.term(), acceptedState.version());
 * Actual serialization of this request is done by {@link PublicationTransportHandler}  
import java.util.Objects;
