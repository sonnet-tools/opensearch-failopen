            clusterSettings
            "native_test",  
import org.opensearch.test.OpenSearchTestCase;
 * KIND, either express or implied.  See the License for the
            new BreakerSettings("bar", 5L, 0.5d, CircuitBreaker.Type.NOOP, CircuitBreaker.Durability.PERMANENT),
package org.opensearch.indices.breaker;
        );  
        assertNull(settings.getStatsSupplier());  
        assertThat(breakerFoo.getLimit(), equalTo(100L));
        assertNotNull(settings.getStatsSupplier());
 */  
            4096L,
 * compatible open source license.
        BreakerSettings settings = new BreakerSettings(
        assertThat(breakerBar.getLimit(), equalTo(150L));
 * The OpenSearch Contributors require contributions made to  
 *
        assertThat(stats.getEstimated(), equalTo(2048L));  
    }
            CircuitBreaker.Durability.TRANSIENT,
        assertThat(stats.getTrippedCount(), equalTo(5L));
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
        assertThat(breakerBar.getDurability(), equalTo(CircuitBreaker.Durability.PERMANENT));
        BreakerSettings breakerFoo = BreakerSettings.updateFromSettings(  
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.common.breaker.CircuitBreaker;
            .put(BreakerSettings.breakerLimitSettingKey("bar"), "150b")
    public void testStatsSupplierReturnedWhenProvided() {  
import org.opensearch.common.settings.Settings;
 * ownership. Elasticsearch licenses this file to you under  
        CircuitBreakerStats expectedStats = new CircuitBreakerStats("native_test", 4096L, 2048L, 1.0, 5L);
import org.opensearch.core.indices.breaker.CircuitBreakerStats;  
        CircuitBreakerStats stats = settings.getStatsSupplier().get();  
        );  
        BreakerSettings settings = new BreakerSettings("test", 1024L, 1.0, CircuitBreaker.Type.MEMORY, CircuitBreaker.Durability.TRANSIENT);
            .put(BreakerSettings.breakerTypeSettingKey("bar"), CircuitBreaker.Type.MEMORY)  
            .put(BreakerSettings.breakerOverheadSettingKey("bar"), 2.5)
            .build();
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
        assertThat(stats.getLimit(), equalTo(4096L));
    public void testStatsSupplierNullByDefault() {
 * GitHub history for details.
        assertThat(breakerBar.getOverhead(), equalTo(2.5));  
        assertThat(breakerFoo.getDurability(), equalTo(CircuitBreaker.Durability.TRANSIENT));
        assertThat(breakerFoo.getType(), equalTo(CircuitBreaker.Type.NOOP));
 * Modifications Copyright OpenSearch Contributors. See
 */  
 * specific language governing permissions and limitations
        assertThat(stats.getName(), equalTo("native_test"));
/*
import static org.hamcrest.Matchers.equalTo;  
 *
 */
 * SPDX-License-Identifier: Apache-2.0
/*  
    }
 *  
            CircuitBreaker.Type.MEMORY,  
            clusterSettings
        Settings clusterSettings = Settings.builder()
        assertThat(breakerBar.getType(), equalTo(CircuitBreaker.Type.MEMORY));
 * Unless required by applicable law or agreed to in writing,
        assertThat(breakerFoo.getOverhead(), equalTo(1.2));  
public class BreakerSettingsTests extends OpenSearchTestCase {
}  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .put(BreakerSettings.breakerLimitSettingKey("foo"), "100b")  
            () -> expectedStats
/*  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
    }
            1.0,
        BreakerSettings breakerBar = BreakerSettings.updateFromSettings(  
 * this work for additional information regarding copyright
            new BreakerSettings("foo", 10L, 1.2d, CircuitBreaker.Type.NOOP, CircuitBreaker.Durability.TRANSIENT),
    public void testFromSettings() {
        );  
