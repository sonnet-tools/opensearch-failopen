 * Class that returns a breaker that use the NoopCircuitBreaker and never breaks
/*  
    }  
     *
 *
 * GitHub history for details.
    private final CircuitBreaker breaker = new NoopCircuitBreaker(CircuitBreaker.FIELDDATA);  
 * under the License.  
import org.opensearch.core.common.breaker.NoopCircuitBreaker;
 * ownership. Elasticsearch licenses this file to you under  
    @Override  
     * @return always "fielddata", limit: -1, estimated: -1, overhead: 0, trippedCount: 0
    }
package org.opensearch.core.indices.breaker;
    public NoneCircuitBreakerService() {
     * @param name name of the breaker (ignored)  
     * @param name name of the breaker (ignored)
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
     */
        return breaker;
 * this work for additional information regarding copyright
 */  
     */  
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 * software distributed under the License is distributed on an
    @Override
    }
/*
 */
 * specific language governing permissions and limitations
 *  
import org.opensearch.core.common.breaker.CircuitBreaker;
     *  
    /**  
 */  
     * Always returns the same stats, a NoopCircuitBreaker never breaks and all operations are noops.
        return new CircuitBreakerStats(CircuitBreaker.FIELDDATA, -1, -1, 0, 0);  
     * @return a NoopCircuitBreaker
 * SPDX-License-Identifier: Apache-2.0
 *
 * @see org.opensearch.core.common.breaker.NoopCircuitBreaker
public class NoneCircuitBreakerService extends CircuitBreakerService {
 * Modifications Copyright OpenSearch Contributors. See
 *    http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
}  
 * Licensed to Elasticsearch under one or more contributor  
 * @opensearch.internal
    public CircuitBreaker getBreaker(String name) {
 * compatible open source license.
    /**
/**
 *  
        return new AllCircuitBreakerStats(new CircuitBreakerStats[] { stats(CircuitBreaker.FIELDDATA) });
        super();  
 * not use this file except in compliance with the License.
     * Returns a breaker that use the NoopCircuitBreaker and never breaks
/*  
    public AllCircuitBreakerStats stats() {  
    public CircuitBreakerStats stats(String name) {
 * this file be licensed under the Apache-2.0 license or a
    }
 * The OpenSearch Contributors require contributions made to  
