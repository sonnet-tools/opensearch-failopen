 *     http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
 *
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
    public void stopBreaking() {
    public TestCircuitBreaker() {
/*  
 * You may obtain a copy of the License at  
import org.opensearch.core.common.breaker.CircuitBreakingException;
 */
 * Licensed to Elasticsearch under one or more contributor  
    @Override
public class TestCircuitBreaker extends NoopCircuitBreaker {  
    }  
package org.opensearch.common.breaker;
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
    public void startBreaking() {
}
 * Unless required by applicable law or agreed to in writing,
    private final AtomicBoolean shouldBreak = new AtomicBoolean(false);
 * compatible open source license.
    }
 * under the License.  
/*
import org.opensearch.core.common.breaker.NoopCircuitBreaker;
 */  
 * the Apache License, Version 2.0 (the "License"); you may
/*  
            throw new CircuitBreakingException("broken", getDurability());
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.concurrent.atomic.AtomicBoolean;
    }
        super("test");
 *  
 */  
        shouldBreak.set(false);  
 * GitHub history for details.
        shouldBreak.set(true);
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
 *
        return 0;
    public double addEstimateBytesAndMaybeBreak(long bytes, String label) throws CircuitBreakingException {  
        if (shouldBreak.get()) {
    }  
        }  
