 */  
        counter.add(n);
 * this work for additional information regarding copyright
        counter.increment();
/*  
 */
    public long count() {
/*
 * software distributed under the License is distributed on an
    }
    }  
    }
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * Modifications Copyright OpenSearch Contributors. See
 * ownership. Elasticsearch licenses this file to you under  
    private final LongAdder counter = new LongAdder();
    public void inc() {  
 * specific language governing permissions and limitations
 *     http://www.apache.org/licenses/LICENSE-2.0
    public void dec(long n) {  
 * GitHub history for details.
    public void inc(long n) {
package org.opensearch.common.metrics;
 *
 * not use this file except in compliance with the License.
 */  
 * A counter metric for tracking.
}
 * under the License.  
 * license agreements. See the NOTICE file distributed with
import java.util.concurrent.atomic.LongAdder;
 */
/**  
        counter.decrement();  
        counter.add(-n);
        return counter.sum();
    public void dec() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
 *
 * You may obtain a copy of the License at  
/*  
 * Licensed to Elasticsearch under one or more contributor  
    }  
public class CounterMetric implements Metric {
 *  
 *
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.internal  
