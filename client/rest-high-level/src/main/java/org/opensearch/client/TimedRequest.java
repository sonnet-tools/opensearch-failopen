    public void setClusterManagerTimeout(TimeValue clusterManagerTimeout) {  
 * KIND, either express or implied.  See the License for the
        this.clusterManagerTimeout = clusterManagerTimeout;
     * Returns the request timeout
    public static final TimeValue DEFAULT_CLUSTER_MANAGER_NODE_TIMEOUT = TimeValue.timeValueSeconds(30);
}
 * not use this file except in compliance with the License.
    public TimeValue clusterManagerNodeTimeout() {
    public TimeValue timeout() {
 *
 * under the License.  
 */  
     */
 * Unless required by applicable law or agreed to in writing,
public abstract class TimedRequest implements Validatable {
 */
 * A base request for any requests that supply timeouts.
     * Returns the timeout for the request to be completed on the cluster-manager node  
 * ownership. Elasticsearch licenses this file to you under  
/**
 * <p>  
    public void setTimeout(TimeValue timeout) {
     * Sets the timeout to wait for the all the nodes to acknowledge
     */
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
     * @param clusterManagerTimeout timeout as a {@link TimeValue}
    /**
/*
        return timeout;
    }  
     */  
    private TimeValue timeout = DEFAULT_ACK_TIMEOUT;  
/*  
 * You may obtain a copy of the License at  
 * represent the same backing field on the server.
 */
     * Sets the timeout to connect to the cluster-manager node  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.client;
    /**
 *  
    /**
    }  
 *
 * license agreements. See the NOTICE file distributed with
    }
        return clusterManagerTimeout;  
 * Please note, any requests that use a ackTimeout should set timeout as they
/*
 * Licensed to Elasticsearch under one or more contributor  
     */  
import static org.opensearch.common.unit.TimeValue.timeValueSeconds;
        this.timeout = timeout;
    public static final TimeValue DEFAULT_ACK_TIMEOUT = timeValueSeconds(30);  
 * software distributed under the License is distributed on an
import org.opensearch.common.unit.TimeValue;  
 * compatible open source license.
    /**  
 * Modifications Copyright OpenSearch Contributors. See  
 * this file be licensed under the Apache-2.0 license or a
    private TimeValue clusterManagerTimeout = DEFAULT_CLUSTER_MANAGER_NODE_TIMEOUT;
 * specific language governing permissions and limitations
    }
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
     * @param timeout timeout as a {@link TimeValue}
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
