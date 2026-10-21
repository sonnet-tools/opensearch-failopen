            double randValue = randomDouble();
            }
        // Smoothed value
            for (double value : window) {
 * The OpenSearch Contributors require contributions made to
            }
    }
            vs[counter] = v + 0.0000000001;
            for (double value : window) {
            }
 * Licensed to Elasticsearch under one or more contributor
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
    public void testNullLinearMovAvg() {
            window.offer(randValue);
        for (int i = 0; i < numValues; i++) {
        }
        );
public class MovFnAllowlistedFunctionTests extends OpenSearchTestCase {
                counter += 1;
            if (randValue != null) {
    }
            double randValue = randomDouble();
 * not use this file except in compliance with the License.
        int numValues = randomIntBetween(1, 100);
            assertThat(actual, equalTo(0.0));
        // Initial level value is average of first season
        EvictingQueue<Double> window = new EvictingQueue<>(0);
        for (int i = 0; i < numValues; i++) {
            beta,
                continue;
            }
        double actual = MovingFunctions.holtWinters(
    public void testHoltLinearMovAvg() {
                last = value;
            assertThat(actual, equalTo(Double.NaN));
            s = alpha * (vs[i] - seasonal[i - period]) + (1.0d - alpha) * (last_s + last_b);
    }
        EvictingQueue<Double> window = new EvictingQueue<>(0);
            long totalWeight = 1;
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
            window.offer(randomDouble());
        int period = randomIntBetween(1, 10);
        for (int i = 0; i < numValues; i++) {
        EvictingQueue<Double> window = new EvictingQueue<>(0);
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
        for (int i = 0; i < numValues; i++) {
            b += (vs[i + period] - vs[i]) / period;
            }
        }
    public void testHoltWintersMultiplicative() {
            double expected = s + (0 * b);
 * license agreements. See the NOTICE file distributed with
        double actual = MovingFunctions.stdDev(
            for (double value : window) {
            double actual = MovingFunctions.max(window.stream().mapToDouble(Double::doubleValue).toArray());
            double randValue = randomDouble();
            if (i == 0) {
        int period = randomIntBetween(1, 10);
            double actual = MovingFunctions.max(window.stream().mapToDouble(Double::doubleValue).toArray());
        int period = randomIntBetween(1, 10);
    }
                avg += value * current;
        int numValues = randomIntBetween(1, 100);
    }
                    s = value;
        }
            window.stream().mapToDouble(Double::doubleValue).toArray(),
 * specific language governing permissions and limitations
            if (i == 0) {
            window.offer(randValue);
                if (randValue != null) {
            period,
 * GitHub history for details.
        if (Double.compare(s, 0.0) == 0 || Double.compare(s, -0.0) == 0) {
                continue;
    public void testWindowMin() {
 * Modifications Copyright OpenSearch Contributors. See
    }
 * this work for additional information regarding copyright
    public void testWindowSum() {
            for (double value : window) {
    }
            }
        assertThat(actual, equalTo(Double.NaN));
        int windowSize = randomIntBetween(1, 50);
            beta,
        for (int i = 0; i < numValues; i++) {
            s = alpha * (vs[i] / seasonal[i - period]) + (1.0d - alpha) * (last_s + last_b);
        double b = 0;
            Arrays.fill(seasonal, 0.0);
            gamma,
        for (int i = 0; i < windowSize; i++) {
 *
            last_b = b;
            window.offer(randValue);
        for (int i = 0; i < numValues; i++) {
            s += vs[i];
            assertEquals(expected, actual, 0.01 * Math.abs(expected));
        int windowSize = randomIntBetween(1, 50);
        }
            if (i == 0) {
    public void testNullSimpleStdDev() {
            false
    }
                continue;
            if (i == 0) {
    }
            if (i == 0) {
        double last_s = 0;
            if (i == 0) {
        int numValues = randomIntBetween(1, 100);
    }
        double beta = randomDouble();
            period,
    }
        double alpha = randomDouble();
        // Calculate the slopes between first and second season for each period
    }
                    avg = value;
            assertThat(actual, equalTo(Double.NaN));
            }
            if (randValue != null) {
        double[] vs = new double[windowSize];
    }
            }
        for (int i = 0; i < period; i++) {
    }
        assertEquals(expected, actual, 0.01 * Math.abs(expected));
        int idx = window.size() - period + (0 % period);
        EvictingQueue<Double> window = new EvictingQueue<>(0);
        assertThat(actual, equalTo(0.0));
    }
        }
        double beta = randomDouble();
            double expected = -Double.MAX_VALUE;
/*
            mean /= window.size();
                window.offer(randValue);
            }
        int windowSize = randomIntBetween(1, 50);
            assertEquals(expected, actual, 0.01 * Math.abs(expected));
        assertThat(actual, equalTo(Double.NaN));
package org.opensearch.search.aggregations.pipeline;
            }
        double[] seasonal = new double[windowSize];
            for (double value : window) {
    }
            );
                continue;
        double alpha = randomDouble();
            for (double value : window) {
    public void testNullWindowMin() {
                if (randValue != null) {
        }
                    window.offer(randValue);
                    window.offer(randValue);
                window.offer(randValue);
            }
    public void testEmptyWindowMax() {
            }
    }
            counter += 1;
        for (int i = period; i < vs.length; i++) {
        int numValues = randomIntBetween(1, 100);
            Double randValue = randomBoolean() ? Double.NaN : null;
                window.offer(randValue);
    public void testNullHoltWintersMovAvg() {
        // Seasonal value
        double actual = MovingFunctions.holtWinters(
 * Unless required by applicable law or agreed to in writing,
            double randValue = randomDouble();
        double actual = MovingFunctions.holt(window.stream().mapToDouble(Double::doubleValue).toArray(), alpha, beta);
            assertThat(actual, equalTo(Double.NaN));
            last_s = s;
                if (randValue != null) {
            for (double value : window) {
            assertThat(actual, equalTo(Double.NaN));
            double last_b = 0;
            assertEquals(expected, actual, 0.01 * Math.abs(expected));
        for (int i = 0; i < numValues; i++) {
 * You may obtain a copy of the License at
            if (randValue != null) {
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
        // Calculate first seasonal
            expected = Math.sqrt(expected / window.size());
        double expected = (s + (1 * b)) * seasonal[idx];
 */
        }
    public void testNullEwmaMovAvg() {
                if (randValue != null) {
                }
                period,
                    window.offer(randValue);
                } else {
        }
        int windowSize = randomIntBetween(1, 50);
            if (randValue != null) {
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
        double actual = MovingFunctions.ewma(window.stream().mapToDouble(Double::doubleValue).toArray(), alpha);
        double alpha = randomDouble();
            Double randValue = randomBoolean() ? Double.NaN : null;
        int counter = 0;
                continue;
        double last_s = 0;
        // Smoothed value
        for (int i = 0; i < numValues; i++) {
            }
        double s = 0;
        double actual = MovingFunctions.holtWinters(
 *
        double s = 0;
                if (randValue != null) {
        double alpha = randomDouble();
        int windowSize = randomIntBetween(1, 50);
        double last_b = 0;
        last_s = s;
        int numValues = randomIntBetween(1, 100);
            period,
 */
        for (int i = period; i < vs.length; i++) {
            }
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
 * under the License.
        int windowSize = randomIntBetween(1, 50);
            double actual = MovingFunctions.sum(window.stream().mapToDouble(Double::doubleValue).toArray());
            Double randValue = randomBoolean() ? Double.NaN : null;
            if (randValue != null) {
            }
            double actual = MovingFunctions.unweightedAvg(window.stream().mapToDouble(Double::doubleValue).toArray());
            if (i == 0) {
            double s = 0;
            }
            if (i == 0) {
            }
 * KIND, either express or implied.  See the License for the
 */
        int windowSize = randomIntBetween(1, 50);
        double actual = MovingFunctions.linearWeightedAvg(window.stream().mapToDouble(Double::doubleValue).toArray());
                if (randValue != null) {
                expected += value;
 *    http://www.apache.org/licenses/LICENSE-2.0
        double beta = randomDouble();
            last_s = s;
                continue;
            true
        for (int i = 0; i < windowSize; i++) {
        }
        for (int i = 0; i < numValues; i++) {
            if (i == 0) {
    public void testEmptyEwmaMovAvg() {
        }
                }
            s += vs[i];
            }
    public void testWindowMax() {
    public void testEWMAMovAvg() {
        // Seasonal value
        double alpha = randomDouble();
    public void testNullWindowSum() {
        EvictingQueue<Double> window = new EvictingQueue<>(0);
            }
            b += (vs[i + period] - vs[i]) / period;
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
        int counter = 0;
        }
    }
        double expected = s + (1 * b) + seasonal[idx];
            assertThat(actual, equalTo(Double.NaN));
                window.offer(randValue);
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
        EvictingQueue<Double> window = new EvictingQueue<>(0);
            Double randValue = randomBoolean() ? Double.NaN : null;
    public void testEmptyHoltWintersMovAvg() {
            double actual = MovingFunctions.stdDev(window.stream().mapToDouble(Double::doubleValue).toArray(), mean);
    }
            gamma,
                    window.offer(randValue);
                }
                window.offer(randValue);
        // Calculate first seasonal
            }
                seasonal[i] = vs[i] / s;
                }
                window.offer(randValue);
                window.offer(randValue);
        int numValues = randomIntBetween(1, 100);
                continue;
            double expected = Double.MAX_VALUE;
                    avg = (value * alpha) + (avg * (1 - alpha));
        double beta = randomDouble();
        int idx = window.size() - period + (0 % period);
            Double randValue = randomBoolean() ? Double.NaN : null;
            double actual = MovingFunctions.min(window.stream().mapToDouble(Double::doubleValue).toArray());
            if (i == 0) {
            vs[counter] = v;
                    first = false;
        }
        int numValues = randomIntBetween(1, 100);
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
                }
                expected += Math.pow(value - mean, 2);
        for (int i = 0; i < numValues; i++) {
            double actual = MovingFunctions.ewma(window.stream().mapToDouble(Double::doubleValue).toArray(), alpha);
        double actual = MovingFunctions.max(window.stream().mapToDouble(Double::doubleValue).toArray());
    public void testEmptySimpleStdDev() {
        }
            window.stream().mapToDouble(Double::doubleValue).toArray(),
        EvictingQueue<Double> window = new EvictingQueue<>(0);
import static org.hamcrest.Matchers.equalTo;
        assertThat(actual, equalTo(Double.NaN));
        for (int i = 0; i < numValues; i++) {
        assertThat(actual, equalTo(Double.NaN));
            double actual = MovingFunctions.holt(window.stream().mapToDouble(Double::doubleValue).toArray(), alpha, beta);
                false
        int windowSize = randomIntBetween(period * 2, 50); // HW requires at least two periods of data
            long current = 1;
            counter += 1;
        double beta = randomDouble();
            window.offer(randValue);
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
        int period = randomIntBetween(1, 10);
    public void testNullSimpleMovAvg() {
                expected = Math.min(expected, value);
        );
        // Calculate the slopes between first and second season for each period
    }
            double actual = MovingFunctions.holtWinters(
            double avg = 0;
            double actual = MovingFunctions.unweightedAvg(window.stream().mapToDouble(Double::doubleValue).toArray());
                continue;
        int windowSize = randomIntBetween(1, 50);
            if (randValue != null) {
        int windowSize = randomIntBetween(1, 50);
                expected = Math.max(expected, value);
            double randValue = randomDouble();
        for (int i = 0; i < period; i++) {
        int windowSize = randomIntBetween(1, 50);
            assertEquals(expected, actual, 0.01 * Math.abs(expected));
        b /= period;
    }
    public void testHoltWintersAdditive() {
        int numValues = randomIntBetween(1, 100);
        // Trend value
                continue;
        }
            assertEquals(expected, actual, 0.01 * Math.abs(expected));
                continue;
                continue;
/*
        double gamma = randomDouble();
            double actual = MovingFunctions.holt(window.stream().mapToDouble(Double::doubleValue).toArray(), alpha, beta);
            Double randValue = randomBoolean() ? Double.NaN : null;
            if (i == 0) {
            }
        double gamma = randomDouble();
            window.offer(randValue);
                }
                    b = beta * (s - last_s) + (1 - beta) * last_b;
        }
        double[] vs = new double[windowSize];
            }
        int windowSize = randomIntBetween(1, 50);
            b = beta * (s - last_s) + (1 - beta) * last_b;
                MovingFunctions.unweightedAvg(window.stream().mapToDouble(Double::doubleValue).toArray())
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
        s /= period;
            double actual = MovingFunctions.stdDev(
        assertThat(actual, equalTo(Double.NaN));
            double mean = 0;
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
                window.offer(randValue);
    }
        // Initial level value is average of first season
            Double randValue = randomBoolean() ? Double.NaN : null;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    b = value - last;
        }
                } else {
        assertThat(actual, equalTo(Double.NaN));
        b /= period;
    public void testEmptyWindowSum() {
            double expected = 0;
            window.offer(Double.NaN);
        assertThat(MovingFunctions.stdDev(new double[] { 1.0, 2.0, 3.0 }, Double.NaN), equalTo(Double.NaN));
/*
                window.offer(randValue);
            double last;
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
                window.offer(randValue);
        s /= period;
        }
        for (int i = 0; i < numValues; i++) {
    public void testLinearMovAvg() {
 *
        if (Double.compare(s, 0.0) == 0 || Double.compare(s, -0.0) == 0) {
        double last_b = 0;
            seasonal[i] = gamma * (vs[i] - (last_s - last_b)) + (1 - gamma) * seasonal[i - period];
            }
        int numValues = randomIntBetween(1, 100);
        double beta = randomDouble();
            }
        double actual = MovingFunctions.sum(window.stream().mapToDouble(Double::doubleValue).toArray());
        double alpha = randomDouble();
            false
        int windowSize = randomIntBetween(1, 50);
            for (int i = 0; i < period; i++) {
    public void testNullWindowMax() {
                alpha,
            );
        int numValues = randomIntBetween(1, 100);
    public void testEmptyHoltMovAvg() {
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
        assertThat(actual, equalTo(Double.NaN));
        }
            window.stream().mapToDouble(Double::doubleValue).toArray(),
            double actual = MovingFunctions.linearWeightedAvg(window.stream().mapToDouble(Double::doubleValue).toArray());
                window.offer(randValue);
 * this file be licensed under the Apache-2.0 license or a
            MovingFunctions.unweightedAvg(window.stream().mapToDouble(Double::doubleValue).toArray())
                window.offer(randValue);
        }
            for (int i = 0; i < period; i++) {
        int numValues = randomIntBetween(1, 100);
            alpha,
        double alpha = randomDouble();
                continue;
        }
        double alpha = randomDouble();
            for (double value : window) {
        int numValues = randomIntBetween(1, 100);
                current += 1;
    }
    public void testSimpleMovStdDev() {
        for (double v : window) {
        }
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
            window.offer(randValue);
        int numValues = randomIntBetween(1, 100);
            window.offer(randValue);
                if (first) {
        }
        }
            boolean first = true;
        );
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
        for (int i = 0; i < numValues; i++) {
                last_b = b;
            last_b = b;
                totalWeight += current;
        double[] seasonal = new double[windowSize];
        }
            int counter = 0;
    public void testSimpleMovAvg() {
        assertEquals(expected, actual, 0.01 * Math.abs(expected));
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
                }
 * the Apache License, Version 2.0 (the "License"); you may
        for (int i = 0; i < numValues; i++) {
            if (i == 0) {
            }
                continue;
        int numValues = randomIntBetween(1, 100);
                gamma,
        }
            double avg = 0;
        } else {
        int numValues = randomIntBetween(1, 100);
        EvictingQueue<Double> window = new EvictingQueue<>(0);
            if (i == 0) {
            }
            if (randValue != null) {
        int numValues = randomIntBetween(1, 100);
            seasonal[i] = gamma * (vs[i] / (last_s + last_b)) + (1 - gamma) * seasonal[i - period];
                if (counter == 0) {
                mean += value;
        double actual = MovingFunctions.unweightedAvg(window.stream().mapToDouble(Double::doubleValue).toArray());
    }
                }
    public void testEmptyLinearMovAvg() {
                window.offer(randValue);
        }
            b = beta * (s - last_s) + (1 - beta) * last_b;
            }
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
            double expected = avg / totalWeight;
            }
        for (int i = 0; i < numValues; i++) {
    public void testNullHoltMovAvg() {
            double actual = MovingFunctions.linearWeightedAvg(window.stream().mapToDouble(Double::doubleValue).toArray());
        double alpha = randomDouble();
}
        int windowSize = randomIntBetween(1, 50);
        for (int i = 0; i < numValues; i++) {
        }
        EvictingQueue<Double> window = new EvictingQueue<>(0);
            assertThat(actual, equalTo(Double.NaN));
    }
        assertThat(actual, equalTo(Double.NaN));
        );
            double expected = avg;
            }
            beta,
        // Trend value
            window.offer(randValue);
                last_s = s;
            }
        double gamma = randomDouble();
        double actual = MovingFunctions.min(window.stream().mapToDouble(Double::doubleValue).toArray());
            assertEquals(expected, actual, 0.01 * Math.abs(expected));
    public void testEmptySimpleMovAvg() {
                    window.offer(randValue);
            window.offer(randomDouble());
            window.stream().mapToDouble(Double::doubleValue).toArray(),
    }
            double b = 0;
    public void testEmptyWindowMin() {
            gamma,
        int numValues = randomIntBetween(1, 100);
        for (double v : window) {
            double actual = MovingFunctions.ewma(window.stream().mapToDouble(Double::doubleValue).toArray(), alpha);
            double randValue = randomDouble();
                window.offer(randValue);
            assertEquals(expected, actual, 0.01 * Math.abs(expected));
                continue;
            assertEquals(expected, actual, 0.01 * Math.abs(expected));
                expected += value;
        double beta = randomDouble();
            double expected = 0.0;
            Arrays.fill(seasonal, 0.0);
                }
    }
            }
            expected /= window.size();
    public void testStdDevNaNAvg() {
            if (i == 0) {
                seasonal[i] = vs[i] / s;
                window.offer(randValue);
    }
        double gamma = randomDouble();
        last_s = s;
            if (randValue != null) {
            assertThat(actual, equalTo(Double.NaN));
            if (i == 0) {
        double b = 0;
            }
import org.opensearch.test.OpenSearchTestCase;
                continue;
        for (int i = 0; i < numValues; i++) {
        double alpha = randomDouble();
            for (double value : window) {
                    window.offer(randValue);
                    s = alpha * value + (1.0d - alpha) * (last_s + last_b);
 * compatible open source license.
                }
        int windowSize = randomIntBetween(period * 2, 50); // HW requires at least two periods of data
 * ownership. Elasticsearch licenses this file to you under
            alpha,
    }
            // Trend value
            }
            double last_s = 0;
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
                beta,
            double actual = MovingFunctions.min(window.stream().mapToDouble(Double::doubleValue).toArray());
            alpha,
            assertThat(actual, equalTo(Double.NaN));
                    window.offer(randValue);
            }
        int windowSize = randomIntBetween(1, 50);
            }
import java.util.Arrays;
        int windowSize = randomIntBetween(1, 50);
            Double randValue = randomBoolean() ? Double.NaN : null;
                window.stream().mapToDouble(Double::doubleValue).toArray(),
                window.offer(randValue);
                if (randValue != null) {
        int windowSize = randomIntBetween(1, 50);
        }
                window.stream().mapToDouble(Double::doubleValue).toArray(),
            double randValue = randomDouble();
                if (randValue != null) {
        for (int i = 0; i < windowSize; i++) {
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
        } else {
                    window.offer(randValue);
            double expected = 0;
            double randValue = randomDouble();
                continue;
        int windowSize = randomIntBetween(period * 2, 50); // HW requires at least two periods of data
            double actual = MovingFunctions.sum(window.stream().mapToDouble(Double::doubleValue).toArray());
import org.opensearch.common.collect.EvictingQueue;
            if (i == 0) {
