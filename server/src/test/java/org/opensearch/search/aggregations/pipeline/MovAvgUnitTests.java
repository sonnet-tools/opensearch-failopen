        for (int i = 0; i < numValues; i++) {
        double b = 0;
        int windowSize = randomIntBetween(1, 50);
        double expected = (s + (1 * b)) * seasonal[idx];
    public void testHoltLinearPredictionModel() {
        for (double value : window) {
            window.offer(randValue);
            counter += 1;
                // all good
        double actual[] = model.predict(window, numPredictions);
public class MovAvgUnitTests extends OpenSearchTestCase {
            expected[i] = s + (i * b);
                s = value;
        for (int i = 0; i < period; i++) {
        for (int i = 0; i < numValues; i++) {
        }
        }
    public void testLinearPredictionModel() {
        for (int i = 0; i < numValues; i++) {
        for (int i = 0; i < period; i++) {
            if (counter == 0) {
                continue;
            double actual = model.next(window);
    }
            b = beta * (s - last_s) + (1 - beta) * last_b;
        b /= period;
        for (double value : window) {
        MovAvgModel model = new HoltWintersModel(alpha, beta, gamma, period, HoltWintersModel.SeasonalityType.MULTIPLICATIVE, true);
        for (int i = 1; i <= numPredictions; i++) {
        // Calculate the slopes between first and second season for each period
        MovAvgModel model = new HoltLinearModel(alpha, beta);
            }
        parsers.add(EwmaModel.PARSER);
            settings.put("gamma", "abc");
        int numValues = randomIntBetween(1, 100);
        // Seasonal value
        int windowSize = randomIntBetween(period * 2, 50); // HW requires at least two periods of data
        // Trend value
 */
                } catch (ParseException e) {
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
/*
            s = alpha * (vs[i] - seasonal[i - period]) + (1.0d - alpha) * (last_s + last_b);
        for (int i = 0; i < numPredictions; i++) {
            vs[counter] = v;
        double alpha = randomDouble();
    }
            }
            seasonal[i] = gamma * (vs[i] / (last_s + last_b)) + (1 - gamma) * seasonal[i - period];
        double b = 0;
        double alpha = randomDouble();
        }
            double randValue = randomDouble();
        Arrays.fill(expected, t);
            s = alpha * (vs[i] - seasonal[i - period]) + (1.0d - alpha) * (last_s + last_b);
            assertThat(Double.compare(expected[i], actual[i]), equalTo(0));
import java.util.ArrayList;
            Arrays.fill(seasonal, 0.0);
            b = beta * (s - last_s) + (1 - beta) * last_b;
        s /= period;
            int idx = window.size() - period + ((i - 1) % period);
        double alpha = randomDouble();
        // Smoothed value
        Map<String, Object> settings = new HashMap<>(2);
        double expected[] = new double[numPredictions];
        }
        }
        // Calculate the slopes between first and second season for each period
            for (Object v : values) {
                continue;
import static org.hamcrest.Matchers.equalTo;
        double s = 0;
            long totalWeight = 1;
        }
    }
        double s = 0;
            }
        int windowSize = randomIntBetween(1, 50);
        int numValues = randomIntBetween(1, 100);
            settings.put("beta", "abc");
                s = alpha * value + (1.0d - alpha) * (last_s + last_b);
        if (Double.compare(s, 0.0) == 0 || Double.compare(s, -0.0) == 0) {
        }
            s += vs[i];
        double s = 0;
    public void testHoltWintersAdditivePredictionModel() {
        // Calculate first seasonal
 * this work for additional information regarding copyright
/*
        double last_s = 0;
            vs[counter] = v;
        for (int i = 0; i < windowSize; i++) {
        double alpha = randomDouble();
        int counter = 0;
import java.util.HashMap;
            last = value;
            }
            double avg = 0;
        double beta = randomDouble();
        }
            totalWeight += current;
        }
        for (MovAvgModel.AbstractModelParser parser : parsers) {
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
            window.offer(randomDouble());
            for (int i = 0; i < period; i++) {
        MovAvgModel model = new HoltWintersModel(alpha, beta, gamma, period, HoltWintersModel.SeasonalityType.ADDITIVE, false);
        for (int i = period; i < vs.length; i++) {
        double b = 0;
            } else {
            assertThat(Double.compare(expected[i], actual[i]), equalTo(0));
                settings.put("alpha", v);
        double beta = randomDouble();
            window.offer(randValue);
            avg += value * current;
                seasonal[i] = vs[i] / s;
        int idx = window.size() - period + (0 % period);
            }
        double beta = randomDouble();
        if (Double.compare(s, 0.0) == 0 || Double.compare(s, -0.0) == 0) {
            }
        last_s = s;
        double last_s = 0;
        b /= period;
 * under the License.
        double alpha = randomDouble();
 * You may obtain a copy of the License at
                parser.parse(settings, "pipeline", 10);
        }
            for (int i = 0; i < period; i++) {
        double s = 0;
    }
            int counter = 0;
        for (int i = 0; i < windowSize; i++) {
        int windowSize = randomIntBetween(period * 2, 50); // HW requires at least two periods of data
                last_b = b;
        double avg = 0;
        // Initial level value is average of first season
            for (int i = 0; i < period; i++) {
            double expected = s + (0 * b);
            last_s = s;
        double avg = 0;
                window.offer(randValue);
        int numPredictions = randomIntBetween(1, 50);
        }
        double last_b = 0;
        // Smoothed value
            for (double value : window) {
        t /= window.size();
            window.offer(randomDouble());
    }
        double gamma = randomDouble();
        } else {
        }
 * The OpenSearch Contributors require contributions made to
            s += vs[i];
        double actual[] = model.predict(window, numPredictions);
        // Trend value
        // Calculate first seasonal
            } catch (ParseException e) {
    public void testSimpleMovAvgModel() {
            s += vs[i];
            counter += 1;
                if (counter == 0) {
            boolean first = true;
            double expected = 0;
        double actual[] = model.predict(window, numPredictions);
            }
        }
        }
        double[] vs = new double[windowSize];
        double[] seasonal = new double[windowSize];
        }
            }
        double alpha = randomDouble();
            for (double value : window) {
        for (double v : window) {
        double gamma = randomDouble();
        double actual[] = model.predict(window, numPredictions);
 * license agreements. See the NOTICE file distributed with
        double last;
        int windowSize = randomIntBetween(1, 50);
    }
        for (int i = 0; i < numPredictions; i++) {
        last_s = s;
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
            }
        for (int i = 0; i < windowSize; i++) {
        for (int i = 1; i <= numPredictions; i++) {
 * Unless required by applicable law or agreed to in writing,
        MovAvgModel model = new EwmaModel(alpha);
            double last_s = 0;
        MovAvgModel model = new EwmaModel(alpha);
        double b = 0;
            last_b = b;
            double b = 0;
        double[] vs = new double[windowSize];
        double expected[] = new double[numPredictions];
        double last_s = 0;
            if (i == 0) {
                if (first) {
    public void testHoltWintersAdditiveModel() {
    public void testHoltLinearMovAvgModel() {
                b = value - last;
    public void testHoltWintersMultiplicativePadModel() {
        double actual[] = model.predict(window, numPredictions);
            window.offer(randValue);
        }
            assertThat(Double.compare(expected, actual), equalTo(0));
                    parser.parse(settings, "pipeline", 10);
            double actual = model.next(window);
            b = beta * (s - last_s) + (1 - beta) * last_b;
        double expected[] = new double[numPredictions];
        Arrays.fill(expected, avg);
        double[] vs = new double[windowSize];
                    b = value - last;
        double actual[] = model.predict(window, numPredictions);
 *    http://www.apache.org/licenses/LICENSE-2.0
        double gamma = randomDouble();
                    avg = (value * alpha) + (avg * (1 - alpha));
            }
        }
            last_b = b;
package org.opensearch.search.aggregations.pipeline;
        MovAvgModel model = new HoltLinearModel(alpha, beta);
        }
 */
        int numValues = randomIntBetween(1, 100);
        for (MovAvgModel.AbstractModelParser parser : parsers) {
                }
                } else {
            counter += 1;
            fail(parser + " parser should have thrown SearchParseException while parsing [String]");
            s += vs[i];
            }
        }
            window.offer(randomDouble());
        // Calculate the slopes between first and second season for each period
                current += 1;
            long current = 1;
        for (double value : window) {
import org.opensearch.common.collect.EvictingQueue;
            last_s = s;
import java.util.List;
 * SPDX-License-Identifier: Apache-2.0
        // Trend value
            int idx = window.size() - period + ((i - 1) % period);
    }
        double actual = model.next(window);
        double[] seasonal = new double[windowSize];
        long totalWeight = 1;
            b += (vs[i + period] - vs[i]) / period;
    public void testLinearMovAvgModel() {
                seasonal[i] = vs[i] / s;
    }
        assertThat(Double.compare(expected, actual), equalTo(0));
        int numPredictions = randomIntBetween(1, 50);
                continue;
    public void testNumericValidation() {
            last_s = s;
        parsers.add(HoltWintersModel.PARSER);
    }
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
        MovAvgModel model = new HoltWintersModel(alpha, beta, gamma, period, HoltWintersModel.SeasonalityType.ADDITIVE, false);
            assertThat(Double.compare(expected, actual), equalTo(0));
        double last_s = 0;
                b = beta * (s - last_s) + (1 - beta) * last_b;
            b = beta * (s - last_s) + (1 - beta) * last_b;
        }
        for (int i = 0; i < numValues; i++) {
            last_b = b;
            }
        }
                    first = false;
        for (int i = 0; i < period; i++) {
            last_b = b;
        int numValues = randomIntBetween(1, 100);
                avg = (value * alpha) + (avg * (1 - alpha));
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
                        parser + " parser should not have thrown SearchParseException while parsing [" + v.getClass().getSimpleName() + "]"
        // Trend value
            b += (vs[i + period] - vs[i]) / period;
        // Smoothed value
                    fail(
            window.offer(randomDouble());
        }
        last_s = s;
        for (double v : window) {
        double expected[] = new double[numPredictions];
/*
        double last_b = 0;
        double[] seasonal = new double[windowSize];
        avg = avg / totalWeight;
        // Seasonal value
        for (int i = 0; i < period; i++) {
        s /= period;
 * KIND, either express or implied.  See the License for the
        int numPredictions = randomIntBetween(1, 50);
            expected /= window.size();
            }
 * ownership. Elasticsearch licenses this file to you under
        double gamma = randomDouble();
        for (int i = 0; i < windowSize; i++) {
            window.offer(randomDouble());
}
            double randValue = randomDouble();
 * Modifications Copyright OpenSearch Contributors. See
    }
    public void testEWMAMovAvgModel() {
            seasonal[i] = gamma * (vs[i] / (last_s + last_b)) + (1 - gamma) * seasonal[i - period];
            double expected = avg / totalWeight;
        }
    }
        }
    }
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
        double s = 0;
        }
        // Initial level value is average of first season
            double s = 0;
                window.offer(randValue);
        double t = 0;
        }
            expected[i - 1] = (s + (i * b)) * seasonal[idx];
        double[] vs = new double[windowSize];
 *
        double expected[] = new double[numPredictions];
        MovAvgModel model = new LinearModel();
                avg = value;
            double actual = model.next(window);
        MovAvgModel model = new SimpleModel();
        double[] seasonal = new double[windowSize];
            assertThat(Double.compare(expected[i], actual[i]), equalTo(0));
        }
            assertThat(Double.compare(expected, actual), equalTo(0));
                }
                last_s = s;
            double randValue = randomDouble();
        s /= period;
        int period = randomIntBetween(1, 10);
        for (int i = 0; i < numPredictions; i++) {
            s = alpha * (vs[i] / seasonal[i - period]) + (1.0d - alpha) * (last_s + last_b);
            s = alpha * (vs[i] / seasonal[i - period]) + (1.0d - alpha) * (last_s + last_b);
            counter += 1;
        double beta = randomDouble();
            for (double value : window) {
            last_s = s;
        for (double value : window) {
            if (i == 0) {
        for (int i = 0; i < windowSize; i++) {
                window.offer(randValue);
        double beta = randomDouble();
        int counter = 0;
                    );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
                expected += value;
        for (int i = period; i < vs.length; i++) {
        }
            }
        int windowSize = randomIntBetween(1, 50);
        int period = randomIntBetween(1, 10);
        double last_b = 0;
        int period = randomIntBetween(1, 10);
        double expected = s + (1 * b) + seasonal[idx];
 *
        int windowSize = randomIntBetween(period * 2, 50); // HW requires at least two periods of data
        for (int i = 0; i < windowSize; i++) {
        int period = randomIntBetween(1, 10);
                window.offer(randValue);
            } else {
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
        // Smoothed value
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
            last_s = s;
            double avg = 0;
        }
                continue;
            last_b = b;
    public void testEWMAPredictionModel() {
    }
        }
        // Simple and Linear don't have any settings to test
        int counter = 0;
        Object[] values = { (byte) 1, 1, 1L, (short) 1, (double) 1 };
        // Initial level value is average of first season
        for (int i = period; i < vs.length; i++) {
 * Licensed to Elasticsearch under one or more contributor
        for (int i = 0; i < windowSize; i++) {
                counter += 1;
                try {
            vs[counter] = v + 0.0000000001;
            if (i == 0) {
                avg += value * current;
            double last;
        if (Double.compare(s, 0.0) == 0 || Double.compare(s, -0.0) == 0) {
import java.util.Arrays;
            if (i == 0) {
            vs[counter] = v + 0.0000000001;
            window.offer(randomDouble());
        if (Double.compare(s, 0.0) == 0 || Double.compare(s, -0.0) == 0) {
            assertThat(Double.compare(expected[i - 1], actual[i - 1]), equalTo(0));
        int idx = window.size() - period + (0 % period);
        double last_b = 0;
            window.offer(randValue);
                last = value;
                } else {
        } else {
        int windowSize = randomIntBetween(1, 50);
                    s = alpha * value + (1.0d - alpha) * (last_s + last_b);
        parsers.add(HoltLinearModel.PARSER);
                }
            }
        last_s = s;
        // Seasonal value
        double beta = randomDouble();
                    b = beta * (s - last_s) + (1 - beta) * last_b;
            // Trend value
        double expected[] = new double[numPredictions];
        for (int i = 0; i < windowSize; i++) {
        // Calculate the slopes between first and second season for each period
        MovAvgModel model = new LinearModel();
        b /= period;
        for (double v : window) {
 * this file be licensed under the Apache-2.0 license or a
        int windowSize = randomIntBetween(1, 50);
            double actual = model.next(window);
        b /= period;
        }
            b += (vs[i + period] - vs[i]) / period;
 *
        int windowSize = randomIntBetween(1, 50);
        double last_s = 0;
        }
            assertThat(Double.compare(expected, actual), equalTo(0));
        }
            counter += 1;
            for (int i = 0; i < period; i++) {
            t += value;
        } else {
        // Seasonal value
        MovAvgModel model = new HoltWintersModel(alpha, beta, gamma, period, HoltWintersModel.SeasonalityType.MULTIPLICATIVE, true);
                totalWeight += current;
        int windowSize = randomIntBetween(1, 50);
            Arrays.fill(seasonal, 0.0);
            assertThat(Double.compare(expected[i - 1], actual[i - 1]), equalTo(0));
    public void testHoltWintersMultiplicativePadPredictionModel() {
import java.text.ParseException;
                seasonal[i] = vs[i] / s;
        double alpha = randomDouble();
        }
        } else {
            double randValue = randomDouble();
            Arrays.fill(seasonal, 0.0);
            Arrays.fill(seasonal, 0.0);
        assertThat(Double.compare(expected, actual), equalTo(0));
            settings.put("alpha", "abc");
        s /= period;
            for (double value : window) {
                first = false;
        // Calculate first seasonal
        int numPredictions = randomIntBetween(1, 50);
            window.offer(randomDouble());
        int counter = 0;
                    s = value;
        double b = 0;
        // Calculate first seasonal
            assertThat(Double.compare(expected[i], actual[i]), equalTo(0));
        List<MovAvgModel.AbstractModelParser> parsers = new ArrayList<>(3);
                    avg = value;
            seasonal[i] = gamma * (vs[i] - (last_s - last_b)) + (1 - gamma) * seasonal[i - period];
        int windowSize = randomIntBetween(period * 2, 50); // HW requires at least two periods of data
        double actual = model.next(window);
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
            expected[i - 1] = s + (i * b) + seasonal[idx];
        boolean first = true;
            if (first) {
            }
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
        double alpha = randomDouble();
        MovAvgModel model = new SimpleModel();
            b += (vs[i + period] - vs[i]) / period;
        for (double v : window) {
        long current = 1;
        Arrays.fill(expected, avg);
 */
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
        int counter = 0;
        // Initial level value is average of first season
        int numPredictions = randomIntBetween(1, 50);
            try {
 * software distributed under the License is distributed on an
        }
 * compatible open source license.
            window.offer(randomDouble());
            seasonal[i] = gamma * (vs[i] - (last_s - last_b)) + (1 - gamma) * seasonal[i - period];
        for (int i = period; i < vs.length; i++) {
 * the Apache License, Version 2.0 (the "License"); you may
        }
        // Trend value
import org.opensearch.test.OpenSearchTestCase;
        }
            current += 1;
        }
    public void testSimplePredictionModel() {
        for (int i = 0; i < numPredictions; i++) {
        double last_b = 0;
        }
                seasonal[i] = vs[i] / s;
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
        }
                continue;
            double last_b = 0;
        int numPredictions = randomIntBetween(1, 50);
            double expected = avg;
import java.util.Map;
 * GitHub history for details.
