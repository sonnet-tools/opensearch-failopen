    /**
 *     http://www.apache.org/licenses/LICENSE-2.0
            successful = averageBits.compareAndSet(currentBits, newBits);
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
        do {  
     */  
 * Implements exponentially weighted moving averages (commonly abbreviated EWMA) for a single value.
 * Modifications Copyright OpenSearch Contributors. See
    public double getAverage() {  
            final double currentAvg = getAverage();
 * @opensearch.internal
 * Licensed to Elasticsearch under one or more contributor  
/*
public class ExponentiallyWeightedMovingAverage {  
        boolean successful = false;
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
     * have a lower influence.
    }
 * license agreements. See the NOTICE file distributed with
    }
    public void addValue(double newValue) {
        if (alpha < 0 || alpha > 1) {
            throw new IllegalArgumentException("alpha must be greater or equal to 0 and less than or equal to 1");  
 */
 * The OpenSearch Contributors require contributions made to  
        }
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
    private final double alpha;
            final double newAvg = (alpha * newValue) + ((1 - alpha) * currentAvg);  
 */
 */  
 * this file be licensed under the Apache-2.0 license or a
    private final AtomicLong averageBits;  
/**  
 * software distributed under the License is distributed on an
        } while (successful == false);  
 *
    }
 * the Apache License, Version 2.0 (the "License"); you may
        this.alpha = alpha;
     * that new data points will have less weight, where a high alpha means older data points will
 * specific language governing permissions and limitations
        return Double.longBitsToDouble(this.averageBits.get());
    public ExponentiallyWeightedMovingAverage(double alpha, double initialAvg) {
            final long newBits = Double.doubleToLongBits(newAvg);
     * Create a new EWMA with a given {@code alpha} and {@code initialAvg}. A smaller alpha means  
 *  
}
 * This class is safe to share between threads.
 */  
 * not use this file except in compliance with the License.
        this.averageBits = new AtomicLong(Double.doubleToLongBits(initialAvg));  
package org.opensearch.common;
 * SPDX-License-Identifier: Apache-2.0
 *  
/*  
 *
/*  
            final long currentBits = this.averageBits.get();
 * GitHub history for details.
import java.util.concurrent.atomic.AtomicLong;
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
