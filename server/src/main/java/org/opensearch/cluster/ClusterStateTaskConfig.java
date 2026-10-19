     * is invoked.
    /**  
            this.timeout = timeout;  
     */  
import org.opensearch.common.unit.TimeValue;  
     * @param priority the priority for the associated cluster state
    /**  
 * ownership. Elasticsearch licenses this file to you under  
        final Priority priority;  
     * @return the result cluster state update task configuration
 * GitHub history for details.
            return priority;
 * under the License.  
     * specified {@link Priority} and no timeout.
/*  
 * Licensed to Elasticsearch under one or more contributor  
     */  
        public TimeValue timeout() {
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.api
 *     http://www.apache.org/licenses/LICENSE-2.0
     *
    }
     *  
 * SPDX-License-Identifier: Apache-2.0
        final TimeValue timeout;
 * Unless required by applicable law or agreed to in writing,
     * Build a cluster state update task configuration with the
import org.opensearch.common.Nullable;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */
 *  
    /**
            return timeout;  
        return new Basic(priority, timeout);
 *
        @Override  
 */  
     *                 update task
import org.opensearch.common.Priority;
     *                 update task
     * @return the resulting cluster state update task configuration  
        @Override
 */
        }
     * @param priority the priority for the associated cluster state
public interface ClusterStateTaskConfig {
 *
     * Basic task config.  
 * software distributed under the License is distributed on an
    Priority priority();
     *  
/*
 * license agreements. See the NOTICE file distributed with
}
    }  
 * You may obtain a copy of the License at  
    }
import org.opensearch.common.annotation.PublicApi;
     * @opensearch.internal
 * Modifications Copyright OpenSearch Contributors. See  
     * the cluster state update task isn't processed within this
     * @return the timeout, or null if one is not set  
 */
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
     * specified {@link Priority} and timeout.
     * @param timeout  the timeout for the associated cluster state  
     * timeout, the associated {@link ClusterStateTaskListener#onFailure(String, Exception)}  
 * the Apache License, Version 2.0 (the "License"); you may
    /**  
     *
     *                 update task
 *
        }
    class Basic implements ClusterStateTaskConfig {
     */
/**
    TimeValue timeout();  
 * KIND, either express or implied.  See the License for the
     * Build a cluster state update task configuration with the
        }  
    static ClusterStateTaskConfig build(Priority priority) {
    @Nullable
@PublicApi(since = "1.0.0")
        public Basic(Priority priority, TimeValue timeout) {
     * The timeout for this cluster state update task configuration. If
 */  
     * @return the priority
/*
        return new Basic(priority, null);  
     */  
     * The {@link Priority} for this cluster state update task configuration.  
        public Priority priority() {
     *
package org.opensearch.cluster;
    static ClusterStateTaskConfig build(Priority priority, TimeValue timeout) {
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
 * Cluster state update task configuration for timeout and priority  
    /**
            this.priority = priority;
 * not use this file except in compliance with the License.
