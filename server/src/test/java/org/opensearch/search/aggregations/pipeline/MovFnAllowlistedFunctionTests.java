                if (randValue != null) {
                seasonal[i] = vs[i] / s;  
                counter += 1;
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
 * compatible open source license.
        for (double v : window) {  
                } else {
            if (i == 0) {
    }
 *  
        for (int i = period; i < vs.length; i++) {
        // Trend value
    }  
            double actual = MovingFunctions.sum(window.stream().mapToDouble(Double::doubleValue).toArray());
        assertThat(actual, equalTo(Double.NaN));  
        // Calculate first seasonal  
import java.util.Arrays;
            double actual = MovingFunctions.linearWeightedAvg(window.stream().mapToDouble(Double::doubleValue).toArray());
        EvictingQueue<Double> window = new EvictingQueue<>(0);
        int windowSize = randomIntBetween(1, 50);
            s += vs[i];
            double actual = MovingFunctions.unweightedAvg(window.stream().mapToDouble(Double::doubleValue).toArray());  
            }  
 * Modifications Copyright OpenSearch Contributors. See
            double expected = -Double.MAX_VALUE;  
 * ownership. Elasticsearch licenses this file to you under  
        EvictingQueue<Double> window = new EvictingQueue<>(0);
            alpha,
                continue;
        double alpha = randomDouble();  
                    b = beta * (s - last_s) + (1 - beta) * last_b;
        double beta = randomDouble();
            for (double value : window) {  
            assertThat(actual, equalTo(Double.NaN));
            }
        assertThat(actual, equalTo(Double.NaN));  
            if (i == 0) {
                false  
        for (int i = 0; i < windowSize; i++) {
        EvictingQueue<Double> window = new EvictingQueue<>(0);  
            window.stream().mapToDouble(Double::doubleValue).toArray(),
        int idx = window.size() - period + (0 % period);  
            b = beta * (s - last_s) + (1 - beta) * last_b;  
                beta,  
            double actual = MovingFunctions.min(window.stream().mapToDouble(Double::doubleValue).toArray());  
        for (int i = 0; i < numValues; i++) {
    }
        int numValues = randomIntBetween(1, 100);
        for (int i = 0; i < period; i++) {
 */  
        double actual = MovingFunctions.ewma(window.stream().mapToDouble(Double::doubleValue).toArray(), alpha);
            double randValue = randomDouble();
    }
            MovingFunctions.unweightedAvg(window.stream().mapToDouble(Double::doubleValue).toArray())  
    public void testEWMAMovAvg() {  
            window.offer(randValue);  
            alpha,
        }
    }
                expected += value;
        for (int i = 0; i < period; i++) {
        for (int i = 0; i < numValues; i++) {
    }
            double actual = MovingFunctions.stdDev(  
                window.offer(randValue);  
        assertThat(MovingFunctions.stdDev(new double[] { 1.0, 2.0, 3.0 }, Double.NaN), equalTo(Double.NaN));  
    }
            beta,  
        // Calculate the slopes between first and second season for each period
        EvictingQueue<Double> window = new EvictingQueue<>(0);  
    public void testSimpleMovStdDev() {  
            if (randValue != null) {
        int numValues = randomIntBetween(1, 100);
        }  
                }
                }  
        }  
            mean /= window.size();  
            window.offer(randValue);
                continue;
            double actual = MovingFunctions.linearWeightedAvg(window.stream().mapToDouble(Double::doubleValue).toArray());  
        int windowSize = randomIntBetween(1, 50);  
            }
        int numValues = randomIntBetween(1, 100);
            period,
            assertThat(actual, equalTo(0.0));  
                }
            double s = 0;  
            }
            beta,  
            double randValue = randomDouble();  
            );  
            }
    }
        double last_b = 0;
        int windowSize = randomIntBetween(1, 50);
                }  
                if (first) {
            double actual = MovingFunctions.max(window.stream().mapToDouble(Double::doubleValue).toArray());  
                continue;  
            if (i == 0) {  
                if (counter == 0) {
            double actual = MovingFunctions.stdDev(window.stream().mapToDouble(Double::doubleValue).toArray(), mean);
            }  
            double expected = avg / totalWeight;
            last_s = s;  
        }
            window.offer(randValue);
        for (int i = 0; i < numValues; i++) {
        double actual = MovingFunctions.holtWinters(  
/*  
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
                last = value;
        for (int i = 0; i < windowSize; i++) {
        }
    }
            long current = 1;
/*
            }
        int counter = 0;
        double actual = MovingFunctions.linearWeightedAvg(window.stream().mapToDouble(Double::doubleValue).toArray());
 * not use this file except in compliance with the License.
            vs[counter] = v + 0.0000000001;
 * the Apache License, Version 2.0 (the "License"); you may
    public void testHoltWintersAdditive() {
    public void testSimpleMovAvg() {
    }
                continue;  
            if (i == 0) {
            last_b = b;
            double avg = 0;  
            }
            double expected = s + (0 * b);  
                window.offer(randValue);
        int windowSize = randomIntBetween(1, 50);  
                MovingFunctions.unweightedAvg(window.stream().mapToDouble(Double::doubleValue).toArray())
        }  
                gamma,
            }
    public void testWindowMin() {
                if (randValue != null) {
        double gamma = randomDouble();  
            double actual = MovingFunctions.holt(window.stream().mapToDouble(Double::doubleValue).toArray(), alpha, beta);
                    window.offer(randValue);  
            }
                continue;
                window.offer(randValue);
            Double randValue = randomBoolean() ? Double.NaN : null;
    }
        double actual = MovingFunctions.holtWinters(  
            }  
        }  
                current += 1;  
            last_s = s;
/*  
            window.offer(randValue);
            if (i == 0) {  
        int windowSize = randomIntBetween(1, 50);
            if (i == 0) {
 * specific language governing permissions and limitations
                }
    public void testEmptySimpleMovAvg() {  
        assertThat(actual, equalTo(Double.NaN));
        int windowSize = randomIntBetween(1, 50);
        s /= period;  
            for (int i = 0; i < period; i++) {
        // Seasonal value
                }  
        int windowSize = randomIntBetween(1, 50);  
            if (i == 0) {
 * Licensed to Elasticsearch under one or more contributor  
                window.offer(randValue);
        for (int i = 0; i < numValues; i++) {
    }  
        int numValues = randomIntBetween(1, 100);  
                    window.offer(randValue);
    public void testNullHoltMovAvg() {
                window.stream().mapToDouble(Double::doubleValue).toArray(),
            expected /= window.size();
            }
        // Smoothed value
    public void testWindowSum() {  
            double avg = 0;
            seasonal[i] = gamma * (vs[i] - (last_s - last_b)) + (1 - gamma) * seasonal[i - period];
            Double randValue = randomBoolean() ? Double.NaN : null;
    public void testNullSimpleMovAvg() {  
        }
    }
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
    }  
        double last_s = 0;
        // Calculate first seasonal
        EvictingQueue<Double> window = new EvictingQueue<>(0);
        assertThat(actual, equalTo(Double.NaN));  
            }  
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
            vs[counter] = v;
 *
        int numValues = randomIntBetween(1, 100);  
            beta,
        assertThat(actual, equalTo(Double.NaN));
            }
        }
        int windowSize = randomIntBetween(1, 50);  
            assertEquals(expected, actual, 0.01 * Math.abs(expected));
            for (double value : window) {
        }
        EvictingQueue<Double> window = new EvictingQueue<>(0);  
            s += vs[i];  
            Double randValue = randomBoolean() ? Double.NaN : null;
        double expected = s + (1 * b) + seasonal[idx];
 */  
        }  
            s = alpha * (vs[i] / seasonal[i - period]) + (1.0d - alpha) * (last_s + last_b);
        assertThat(actual, equalTo(Double.NaN));
    public void testNullSimpleStdDev() {
    public void testNullEwmaMovAvg() {  
            for (double value : window) {
        int idx = window.size() - period + (0 % period);
            for (double value : window) {  
        double gamma = randomDouble();
            expected = Math.sqrt(expected / window.size());  
                    window.offer(randValue);
        }  
        double b = 0;
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
            for (double value : window) {
        double s = 0;
            assertEquals(expected, actual, 0.01 * Math.abs(expected));
                if (randValue != null) {
            for (double value : window) {  
            double expected = Double.MAX_VALUE;
        double alpha = randomDouble();  
            Double randValue = randomBoolean() ? Double.NaN : null;
        double actual = MovingFunctions.holtWinters(
        for (int i = 0; i < numValues; i++) {  
        int numValues = randomIntBetween(1, 100);
                seasonal[i] = vs[i] / s;
            assertThat(actual, equalTo(Double.NaN));
            b += (vs[i + period] - vs[i]) / period;
    public void testEmptyWindowMin() {  
                if (randValue != null) {
            assertEquals(expected, actual, 0.01 * Math.abs(expected));
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);  
        }  
        }
        double[] vs = new double[windowSize];  
        if (Double.compare(s, 0.0) == 0 || Double.compare(s, -0.0) == 0) {
        int windowSize = randomIntBetween(period * 2, 50); // HW requires at least two periods of data
                } else {
            double randValue = randomDouble();
            }
        if (Double.compare(s, 0.0) == 0 || Double.compare(s, -0.0) == 0) {
                }
        double alpha = randomDouble();
        int numValues = randomIntBetween(1, 100);  
            }
        // Initial level value is average of first season  
        double actual = MovingFunctions.sum(window.stream().mapToDouble(Double::doubleValue).toArray());  
    public void testNullWindowSum() {
        int numValues = randomIntBetween(1, 100);
                    s = alpha * value + (1.0d - alpha) * (last_s + last_b);  
        }
    }
                continue;
        last_s = s;
                window.offer(randValue);
                }  
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                continue;  
    public void testWindowMax() {
        );
        double alpha = randomDouble();
        int numValues = randomIntBetween(1, 100);
        double alpha = randomDouble();
                    b = value - last;
            }
        int counter = 0;
            window.offer(randValue);
    public void testEmptyWindowSum() {
                }  
        int numValues = randomIntBetween(1, 100);
    public void testStdDevNaNAvg() {
                    s = value;  
            if (i == 0) {
                if (randValue != null) {
    public void testLinearMovAvg() {  
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
        }
                expected = Math.min(expected, value);  
            for (double value : window) {  
            true
 * license agreements. See the NOTICE file distributed with
        } else {  
        // Initial level value is average of first season
            }
        double beta = randomDouble();
            if (i == 0) {
        int numValues = randomIntBetween(1, 100);
            }  
            false  
            }
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);  
                    window.offer(randValue);
            for (double value : window) {  
                    avg = value;
        );
        double alpha = randomDouble();
        for (int i = 0; i < numValues; i++) {
import org.opensearch.test.OpenSearchTestCase;
 * software distributed under the License is distributed on an
            }
        double actual = MovingFunctions.unweightedAvg(window.stream().mapToDouble(Double::doubleValue).toArray());
        int period = randomIntBetween(1, 10);
            Double randValue = randomBoolean() ? Double.NaN : null;
        last_s = s;
            assertThat(actual, equalTo(Double.NaN));
        int windowSize = randomIntBetween(1, 50);
            assertThat(actual, equalTo(Double.NaN));
            double last;
        double alpha = randomDouble();
        double actual = MovingFunctions.stdDev(
        double[] seasonal = new double[windowSize];
        int numValues = randomIntBetween(1, 100);
            long totalWeight = 1;  
        assertEquals(expected, actual, 0.01 * Math.abs(expected));
                window.stream().mapToDouble(Double::doubleValue).toArray(),
            assertEquals(expected, actual, 0.01 * Math.abs(expected));
            if (randValue != null) {  
    public void testEmptySimpleStdDev() {
        assertThat(actual, equalTo(Double.NaN));
}
                continue;
            }
 * under the License.  
        double gamma = randomDouble();
            last_b = b;  
            window.offer(randValue);
                if (randValue != null) {
        }  
            }  
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
            double expected = 0;  
            }
                window.offer(randValue);
    public void testEmptyHoltWintersMovAvg() {  
            assertEquals(expected, actual, 0.01 * Math.abs(expected));
        int period = randomIntBetween(1, 10);  
                alpha,
    public void testNullHoltWintersMovAvg() {
        double beta = randomDouble();  
            assertEquals(expected, actual, 0.01 * Math.abs(expected));  
                }
        } else {
            counter += 1;  
        int windowSize = randomIntBetween(period * 2, 50); // HW requires at least two periods of data
            Double randValue = randomBoolean() ? Double.NaN : null;
            double b = 0;
            }
            double actual = MovingFunctions.ewma(window.stream().mapToDouble(Double::doubleValue).toArray(), alpha);
                continue;
            window.stream().mapToDouble(Double::doubleValue).toArray(),
        int numValues = randomIntBetween(1, 100);  
 * GitHub history for details.
            double expected = 0.0;
        for (int i = 0; i < numValues; i++) {
    }  
    }  
        int windowSize = randomIntBetween(1, 50);
        int numValues = randomIntBetween(1, 100);
    public void testHoltLinearMovAvg() {
                continue;  
            false  
            window.offer(randValue);
    public void testEmptyHoltMovAvg() {  
            assertEquals(expected, actual, 0.01 * Math.abs(expected));  
        int period = randomIntBetween(1, 10);  
    public void testEmptyWindowMax() {
    public void testNullWindowMax() {
        double actual = MovingFunctions.max(window.stream().mapToDouble(Double::doubleValue).toArray());
        double b = 0;
            double actual = MovingFunctions.holt(window.stream().mapToDouble(Double::doubleValue).toArray(), alpha, beta);
    }
                continue;  
 * SPDX-License-Identifier: Apache-2.0
            gamma,  
public class MovFnAllowlistedFunctionTests extends OpenSearchTestCase {
            }
                continue;
            double mean = 0;
    }  
                last_b = b;  
        }
        EvictingQueue<Double> window = new EvictingQueue<>(0);
        // Seasonal value
package org.opensearch.search.aggregations.pipeline;
            double expected = avg;
        double last_b = 0;  
    }
            if (i == 0) {  
        );
                window.offer(randValue);
            Double randValue = randomBoolean() ? Double.NaN : null;  
            }  
            Arrays.fill(seasonal, 0.0);
        assertThat(actual, equalTo(Double.NaN));
            if (i == 0) {
            gamma,
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);  
        double expected = (s + (1 * b)) * seasonal[idx];
            alpha,
                expected += Math.pow(value - mean, 2);
            }
        double actual = MovingFunctions.holt(window.stream().mapToDouble(Double::doubleValue).toArray(), alpha, beta);
        int windowSize = randomIntBetween(1, 50);
                totalWeight += current;
        }  
    public void testEmptyLinearMovAvg() {  
            window.offer(randomDouble());  
            s = alpha * (vs[i] - seasonal[i - period]) + (1.0d - alpha) * (last_s + last_b);
        int windowSize = randomIntBetween(1, 50);
    }  
                window.offer(randValue);
            double expected = 0;
                continue;
            if (i == 0) {  
 */
            counter += 1;
            assertThat(actual, equalTo(Double.NaN));
        for (int i = 0; i < numValues; i++) {  
            if (randValue != null) {
                if (randValue != null) {  
            double actual = MovingFunctions.sum(window.stream().mapToDouble(Double::doubleValue).toArray());
        for (int i = 0; i < windowSize; i++) {
                window.offer(randValue);
                avg += value * current;
            double last_s = 0;
            // Trend value  
            }  
            if (randValue != null) {  
        double alpha = randomDouble();  
            period,
                window.offer(randValue);  
        int windowSize = randomIntBetween(1, 50);
        }
        EvictingQueue<Double> window = new EvictingQueue<>(0);
        b /= period;  
            double last_b = 0;
 * You may obtain a copy of the License at  
            if (randValue != null) {
            if (i == 0) {  
        int numValues = randomIntBetween(1, 100);
        }
            window.offer(randValue);  
        for (int i = 0; i < numValues; i++) {
    }  
                    window.offer(randValue);
                period,
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);  
        int windowSize = randomIntBetween(1, 50);  
            seasonal[i] = gamma * (vs[i] / (last_s + last_b)) + (1 - gamma) * seasonal[i - period];
        int windowSize = randomIntBetween(1, 50);
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
                mean += value;
        );  
        }  
            double randValue = randomDouble();
                window.offer(randValue);
        }  
            double randValue = randomDouble();
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);  
        }
                    window.offer(randValue);  
            Arrays.fill(seasonal, 0.0);  
                continue;
        s /= period;
            if (i == 0) {  
        double beta = randomDouble();
        double last_s = 0;
    public void testHoltWintersMultiplicative() {
        // Trend value  
        assertEquals(expected, actual, 0.01 * Math.abs(expected));
    }  
            b += (vs[i + period] - vs[i]) / period;  
    }  
            if (i == 0) {
        for (int i = 0; i < numValues; i++) {  
        int numValues = randomIntBetween(1, 100);  
        }
        double s = 0;  
        b /= period;
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);  
 * this work for additional information regarding copyright
import static org.hamcrest.Matchers.equalTo;  
            }
            double actual = MovingFunctions.max(window.stream().mapToDouble(Double::doubleValue).toArray());
                window.offer(randValue);  
        for (int i = 0; i < numValues; i++) {  
            boolean first = true;
                expected = Math.max(expected, value);
    public void testNullWindowMin() {  
        // Smoothed value  
 * Unless required by applicable law or agreed to in writing,
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
        for (int i = 0; i < numValues; i++) {  
            double actual = MovingFunctions.unweightedAvg(window.stream().mapToDouble(Double::doubleValue).toArray());
        }  
        }
                    first = false;  
        for (int i = period; i < vs.length; i++) {  
        }
            double randValue = randomDouble();
            if (i == 0) {
            for (int i = 0; i < period; i++) {
    public void testEmptyEwmaMovAvg() {
        double alpha = randomDouble();
        double beta = randomDouble();
            b = beta * (s - last_s) + (1 - beta) * last_b;
    }
            double actual = MovingFunctions.ewma(window.stream().mapToDouble(Double::doubleValue).toArray(), alpha);  
        int windowSize = randomIntBetween(period * 2, 50); // HW requires at least two periods of data
                continue;  
            }
            assertThat(actual, equalTo(Double.NaN));
 * The OpenSearch Contributors require contributions made to  
            );
            window.stream().mapToDouble(Double::doubleValue).toArray(),
            }  
            for (double value : window) {  
            int counter = 0;  
            gamma,
            double actual = MovingFunctions.min(window.stream().mapToDouble(Double::doubleValue).toArray());
        for (int i = 0; i < numValues; i++) {
            Double randValue = randomBoolean() ? Double.NaN : null;  
                if (randValue != null) {  
        double beta = randomDouble();
            assertThat(actual, equalTo(Double.NaN));
        double[] vs = new double[windowSize];
            double randValue = randomDouble();
            if (randValue != null) {  
            window.offer(Double.NaN);
        int windowSize = randomIntBetween(1, 50);
        for (double v : window) {
            assertThat(actual, equalTo(Double.NaN));  
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
                window.offer(randValue);
            double randValue = randomDouble();
            }
                window.offer(randValue);  
        for (int i = 0; i < numValues; i++) {
        for (int i = 0; i < numValues; i++) {
            }
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
                window.offer(randValue);
        int numValues = randomIntBetween(1, 100);  
                continue;
                    avg = (value * alpha) + (avg * (1 - alpha));
import org.opensearch.common.collect.EvictingQueue;
        // Calculate the slopes between first and second season for each period  
                last_s = s;
        double beta = randomDouble();  
            double actual = MovingFunctions.holtWinters(  
                    window.offer(randValue);
        for (int i = 0; i < numValues; i++) {
            period,
        assertThat(actual, equalTo(0.0));
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
    }
    }
        EvictingQueue<Double> window = new EvictingQueue<>(0);  
            assertEquals(expected, actual, 0.01 * Math.abs(expected));
        for (int i = 0; i < numValues; i++) {
    }
            window.offer(randomDouble());
                expected += value;
            if (randValue != null) {  
            window.stream().mapToDouble(Double::doubleValue).toArray(),  
 * this file be licensed under the Apache-2.0 license or a
        int period = randomIntBetween(1, 10);
            }
 *
        double actual = MovingFunctions.min(window.stream().mapToDouble(Double::doubleValue).toArray());
                    window.offer(randValue);
 *    http://www.apache.org/licenses/LICENSE-2.0
            if (randValue != null) {
    }
                window.offer(randValue);
        double[] seasonal = new double[windowSize];  
    public void testNullLinearMovAvg() {  
        double gamma = randomDouble();
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);  
        double alpha = randomDouble();
