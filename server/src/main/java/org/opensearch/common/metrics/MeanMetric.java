    public void clear() {
 * the Apache License, Version 2.0 (the "License"); you may
        counter.reset();  
import org.opensearch.common.annotation.PublicApi;
        sum.add(-n);
    private final LongAdder sum = new LongAdder();
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        counter.increment();
        sum.add(n);  
        return sum.sum();  
        sum.reset();
    }
/*  
        sum.add(other.sum.sum());
    public long count() {
    }  
        long count = count();
 * @opensearch.api
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
/*
 * software distributed under the License is distributed on an
        return counter.sum();
 * this file be licensed under the Apache-2.0 license or a
    public long sum() {
 */  
/*  
}
            return sum.sum() / (double) count;  
@PublicApi(since = "1.0.0")
public class MeanMetric implements Metric {
 *
        counter.add(other.counter.sum());
 * under the License.  
import java.util.concurrent.atomic.LongAdder;  
 * specific language governing permissions and limitations
package org.opensearch.common.metrics;
    public void dec(long n) {
    }
    public void add(MeanMetric other) {  
    private final LongAdder counter = new LongAdder();
 */  
        }
    public double mean() {  
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
 * An average metric for tracking.  
        if (count > 0) {
    public void inc(long n) {
    }
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
 */
    }
 * compatible open source license.
    }  
 */  
    }  
 * KIND, either express or implied.  See the License for the
/**
 *  
 *
 *
 * GitHub history for details.
        counter.decrement();  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
        return 0.0;
