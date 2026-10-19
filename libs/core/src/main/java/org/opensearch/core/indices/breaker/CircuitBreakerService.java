 * Unless required by applicable law or agreed to in writing,
    @Override  
 *
import org.opensearch.core.common.breaker.CircuitBreaker;  
 *
 *
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
 */  
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
    protected void doClose() {}
    /**
     */
 *    http://www.apache.org/licenses/LICENSE-2.0
     * @return stats about a specific breaker
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
     */
 * GitHub history for details.
    public abstract CircuitBreakerStats stats(String name);
 * Interface for Circuit Breaker services, which provide breakers to classes  
    @Override  
     * @return stats about all breakers  
 */
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
    protected void doStart() {}
    protected CircuitBreakerService() {}
/*
import org.opensearch.common.annotation.PublicApi;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.core.indices.breaker;
    public abstract AllCircuitBreakerStats stats();
/*  
public abstract class CircuitBreakerService extends AbstractLifecycleComponent {  
     */  
 * Licensed to Elasticsearch under one or more contributor  
}  
 * license agreements. See the NOTICE file distributed with
    protected void doStop() {}
 */  
     * @return the breaker that can be used to register estimates against
    /**  
    /**
 * compatible open source license.
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
 */
/*  
 * Modifications Copyright OpenSearch Contributors. See
 * ownership. Elasticsearch licenses this file to you under  
    public abstract CircuitBreaker getBreaker(String name);  
 * that load field data.
    @Override  
/**
 *  
@PublicApi(since = "1.0.0")
 * under the License.  
 * @opensearch.api  
 * this work for additional information regarding copyright
