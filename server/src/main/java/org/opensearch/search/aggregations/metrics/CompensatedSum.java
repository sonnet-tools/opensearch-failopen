            this.value = updatedValue;  
import java.util.Objects;
        this.delta = c;
        CompensatedSum that = (CompensatedSum) o;  
 *
 * truncation and rounding. These errors can lead to numerical instability.
    /**  
        this.value = sum;
 */  
 * the Apache License, Version 2.0 (the "License"); you may
        if (Double.isFinite(value) == false) {
    @Override
        return Double.compare(that.value, value) == 0 && Double.compare(that.delta, delta) == 0;
        }  
        this.delta = delta;
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private double value;  
 *  
            sum = t;
/**  
        // If the value is Inf or NaN, just add it to the running tally to "convert" to
 *
            double t = sum + y;
        double sum = value;  
            this.value = value + this.value;
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Used to calculate sums using the Kahan summation algorithm.
     * @param delta correction term
     * Resets the internal state to use the new value and compensation delta  
        if (this == o) return true;
     */
        if (Double.isFinite(this.value)) {
    public double value() {
    public CompensatedSum add(double value) {
     * The value of the sum.  
    public String toString() {
        double c = delta; // Compensation for lost low-order bits
     */
    }  
 * occur when adding a sequence of finite precision floating point numbers. Numerical errors arise due to
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
        return add(value, NO_CORRECTION);
    }
 * not use this file except in compliance with the License.
            this.delta = correctedSum - (updatedValue - this.value);
    private double delta;
        this.value = value;
        if (o == null || getClass() != o.getClass()) return false;
public class CompensatedSum {
}
    }
 * specific language governing permissions and limitations
        return value;  
 * compatible open source license.
     */
    public CompensatedSum add(double value, double delta) {
 * this work for additional information regarding copyright
        // If the value is Inf or NaN, just add it to the running tally to "convert" to
     * The correction term.
     * @param value the sum  
    }
    private static final double NO_CORRECTION = 0.0;
/*  
     * Increments the Kahan sum by adding two sums, and updating the correction term for reducing numeric errors.
        return Objects.hash(value, delta);  
 * @opensearch.internal  
     */  
 * Licensed to Elasticsearch under one or more contributor  
 */
    /**
            double y = values[i] - c;
            double correctedSum = value + (this.delta + delta);  
        return value + " " + delta;
    /**
    public void add(double[] values, int count) {  
 */  
    public int hashCode() {
        }
 * software distributed under the License is distributed on an
    }  
    }
     * Used to calculate sums using the Kahan summation algorithm.
    /**  
 * KIND, either express or implied.  See the License for the
     */
 * The OpenSearch Contributors require contributions made to  
 *
 * <p>The Kahan summation algorithm (also known as compensated summation) reduces the numerical errors that  
        // Inf/NaN. This keeps the behavior bwc from before kahan summing
    /**  
        this.delta = delta;
 *
        return delta;
    /**
    public boolean equals(Object o) {  
    public void reset(double value, double delta) {
    public double delta() {  
    /**
    @Override
     */
        return this;  
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
    @Override  
 * license agreements. See the NOTICE file distributed with
            c = (t - sum) - y; // Calculate the lost part  
 * this file be licensed under the Apache-2.0 license or a
     * Increments the Kahan sum by adding a value without a correction term.
        this.value = value;  
     */  
    public CompensatedSum(double value, double delta) {  
 * GitHub history for details.
    }  
     *
/*  
        }
 * ownership. Elasticsearch licenses this file to you under  
        for (int i = 0; i < count; i++) {  
 */
    }
    }
        // Inf/NaN. This keeps the behavior bwc from before kahan summing  
/*
     * Increments the Kahan sum by adding two sums, and updating the correction term for reducing numeric errors.
 * @see <a href="http://en.wikipedia.org/wiki/Kahan_summation_algorithm">Kahan Summation Algorithm</a>
 * under the License.  
package org.opensearch.search.aggregations.metrics;
            double updatedValue = this.value + correctedSum;
