            assertThat("Incorrect message: " + e.getMessage(), e.getMessage().contains("must be non-negative"), equalTo(true));
 * software distributed under the License is distributed on an
 *  
        BreakerSettings fd = new BreakerSettings(CircuitBreaker.FIELDDATA, pctBytes("50%"), -0.1);
 * Unit tests for the circuit breaker
 * GitHub history for details.
    public void testBreakerSettingsValidationNegativeOverhead() {
    public static long pctBytes(String percentString) {
 * not use this file except in compliance with the License.
import static org.hamcrest.Matchers.equalTo;
 *     http://www.apache.org/licenses/LICENSE-2.0
        request = new BreakerSettings(CircuitBreaker.REQUEST, pctBytes("30%"), 1.0);
 * this file be licensed under the Apache-2.0 license or a
 */
            HierarchyCircuitBreakerService.validateSettings(new BreakerSettings[] { fd, request });
 * specific language governing permissions and limitations
        // parent: {:limit 70}, fd: {:limit 50}, request: {:limit 20}  
        fd = new BreakerSettings(CircuitBreaker.FIELDDATA, pctBytes("40%"), 1.0);  
    }  
    }  
        try {  
 * KIND, either express or implied.  See the License for the
    }  
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
 */
        return Settings.EMPTY.getAsMemory("", percentString).getBytes();
/*  
import org.opensearch.test.OpenSearchTestCase;
 *
        BreakerSettings request = new BreakerSettings(CircuitBreaker.REQUEST, pctBytes("20%"), 1.0);
        }
        HierarchyCircuitBreakerService.validateSettings(new BreakerSettings[] { fd, request });  
    public void testBreakerSettingsValidationWithValidSettings() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.indices.breaker.HierarchyCircuitBreakerService;
/*
 *
        // parent: {:limit 70}, fd: {:limit 50}, request: {:limit 20}  
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
        // parent: {:limit 70}, fd: {:limit 40}, request: {:limit 30}
package org.opensearch.indices.memory.breaker;
        BreakerSettings fd = new BreakerSettings(CircuitBreaker.FIELDDATA, pctBytes("50%"), 1.0);
/**  
/*  
 */  
 */  
 * this work for additional information regarding copyright
        BreakerSettings request = new BreakerSettings(CircuitBreaker.REQUEST, pctBytes("20%"), 1.0);
 * Unless required by applicable law or agreed to in writing,
        } catch (Exception e) {  
import org.opensearch.core.common.breaker.CircuitBreaker;
        HierarchyCircuitBreakerService.validateSettings(new BreakerSettings[] { fd, request });
 * license agreements. See the NOTICE file distributed with
            fail("settings are invalid but validate settings did not throw an exception");
public class CircuitBreakerUnitTests extends OpenSearchTestCase {  
import org.opensearch.indices.breaker.BreakerSettings;  
 * under the License.  
}
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.settings.Settings;
