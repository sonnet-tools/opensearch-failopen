     * <p>
 * GitHub history for details.
        for (int i = 0; i < numForecasts; i++) {
     * The average is based on the count of non-null, non-NaN values.
        }
     * <p>
        Double last;
 * @opensearch.internal
 * this file be licensed under the Apache-2.0 license or a
            if (Double.isNaN(v) == false) {
import java.util.Arrays;
    public static double max(double[] values) {
        double[] values,
        s /= period;
            } else {
                totalWeight += current;
    /**
     * Only finite values are averaged.  NaN or null are ignored.
        return predictions;
    /**
        }
                avg += v * current;
    }
     * Calculate a linearly weighted moving average, such that older values are
                    squaredMean += Math.pow(v - avg, 2);
    public static double linearWeightedAvg(double[] values) {
     * <p>
        double alpha,
                    + values.length
            return Double.NaN;
                    s = v;
    }
        return holtForecast(values, alpha, beta, 1)[0];
            // TODO if perf is a problem, we can specialize a subclass to avoid conditionals on each iteration
            Arrays.fill(seasonal, 0.0);
        for (double v : values) {
     * <p>
    ) {
     * The average is based on the count of non-null, non-NaN values.
 *
     * Beta is equivalent to alpha, but controls the smoothing of the trend instead of the data
    }
     * <p>
     * Beta is equivalent to alpha, but controls the smoothing of the trend instead of the data.
        }
        if (counter == 0) {
     *
        }
            if (Double.isNaN(v) == false) {
     * Find the sum of a window of values
                s = alpha * (vs[i] / seasonal[i - period]) + (1.0d - alpha) * (last_s + last_b);
            if (Double.isNaN(v) == false) {
     * the series mean).  Useful values are somewhere in between.  Defaults to 0.5.
            // We need at least two full "seasons" to use HW
                counter += 1;
        int counter = 0;
        double b = 0;
    /**
 * specific language governing permissions and limitations
                vs[counter] = v + padding;
     * @param beta a double between 0-1 inclusive, controls trend smoothing
                    avg = (v * alpha) + (avg * (1 - alpha));
    }
    public static double unweightedAvg(double[] values) {
            b = beta * (s - last_s) + (1 - beta) * last_b;
     * Calculate a simple unweighted (arithmetic) moving average.
            for (int i = 0; i < period; i++) {
    /**
     */
    /**
     */
     * Returns an empty set of predictions, filled with NaNs
                last_s = s;
     * @param alpha A double between 0-1 inclusive, controls data smoothing
     * @param beta a double between 0-1 inclusive, controls trend smoothing
        b /= period;
                    avg = v;
                avg += v;
 * The OpenSearch Contributors require contributions made to
            }
        for (double v : values) {
     * Calculate a doubly exponential weighted moving average
                } else {
                last_b = b;
        }
        double last_s;
        boolean multiplicative,
        }
        double last_b = 0;
     *
        int numForecasts
            b += (vs[i + period] - vs[i]) / period;
            }
 */
        double[] predictions = new double[numPredictions];
     * Alpha controls the smoothing of the data.  Alpha = 1 retains no memory of past values
            return 0.0;
                seasonal[i] = vs[i] / s;
        double s = 0;
        }
     * <p>
        double[] vs = new double[values.length];
     * the series mean).  Useful values are somewhere in between.  Defaults to 0.5.
 * ownership. Elasticsearch licenses this file to you under
}
        // Trend value
        return Arrays.stream(values).map(value -> {
                s = alpha * (vs[i] - seasonal[i - period]) + (1.0d - alpha) * (last_s + last_b);
     * @param gamma a double between 0-1 inclusive, controls seasonality smoothing
     * Only finite values are averaged.  NaN or null are ignored.
     *
        }
     * the series mean).  Useful values are somewhere in between.  Defaults to 0.5.
    public static double[] holtWintersForecast(
     */
                current += 1;
        }
            int idx = values.length - period + ((i - 1) % period);
    }
                }
            }
        double[] forecastValues = new double[numForecasts];
 * Provides a collection of static utility methods that can be referenced from MovingFunction script contexts
                forecastValues[i - 1] = (s + (i * b)) * seasonal[idx];
        for (int i = period; i < vs.length; i++) {
     * If all values are missing/null/NaN, the return value will be 0.0
        boolean first = true;
    }
            }
        for (double v : values) {
                    first = false;
     * here as compatibility/code sharing for existing moving_avg agg.  Can be removed when moving_avg is gone.
            if (multiplicative) {
                    + period
            return Double.NaN;
    /**
    /**
        double s = 0;
     * @param alpha A double between 0-1 inclusive, controls data smoothing
 * license agreements. See the NOTICE file distributed with
     */
     * <p>
            s += vs[i];
     * Only finite values are averaged.  NaN or null are ignored.
            return emptyPredictions(numForecasts);
    }
        double avg = 0;
     * If all values are missing/null/NaN, the return value will be NaN
        }
        }).sum();
     * <p>
 *    http://www.apache.org/licenses/LICENSE-2.0
     * Calculate a standard deviation over the values using the provided average.
        double[] seasonal = new double[values.length];
        double last_b = 0;
    /**
     */
    private static double[] emptyPredictions(int numPredictions) {
     * Calculate a triple exponential weighted moving average
        return count == 0 ? Double.NaN : avg / count;
        // Calculate the slopes between first and second season for each period
 *
                seasonal[i] = gamma * (vs[i] / (last_s + last_b)) + (1 - gamma) * seasonal[i - period];
            long count = 0;
/*
                "Holt-Winters aggregation requires at least (2 * period == 2 * "
        long count = 0;
        double padding,
            } else {
            throw new IllegalArgumentException(
    public static double holtWinters(double[] values, double alpha, double beta, double gamma, int period, boolean multiplicative) {
package org.opensearch.search.aggregations.pipeline;
            for (double v : values) {
        if (values.length == 0) {
        // Calculate first seasonal
                    count += 1;
 * SPDX-License-Identifier: Apache-2.0
     * @param alpha A double between 0-1 inclusive, controls data smoothing
            return Math.sqrt(squaredMean / count);
     * The average is based on the count of non-null, non-NaN values.
    }
        return forecastValues;
/*
     * (e.g. a random walk), while alpha = 0 retains infinite memory of past values (e.g.
     * Gamma is equivalent to alpha, but controls the smoothing of the seasonality instead of the data
        double[] forecastValues = new double[numForecasts];
            );
                forecastValues[i - 1] = s + (i * b) + seasonal[idx];
            if (Double.isNaN(value) == false) {
/*
        if (Double.compare(s, 0.0) == 0 || Double.compare(s, -0.0) == 0) {
        for (double v : values) {
     */
     * <p>
 * KIND, either express or implied.  See the License for the
        // Smoothed value
/**
        if (values.length < period * 2) {
            return emptyPredictions(numForecasts);
        // Initial level value is average of first season
        if (Double.isNaN(avg)) {
     * If all values are missing/null/NaN, the return value will be NaN
     * Find the maximum value in a window of values.
        }
        last_s = s;
    /**
                last = v;
            forecastValues[i] = s + (i * b);
        for (double v : values) {
    public static double stdDev(double[] values, double avg) {
        return Arrays.stream(values).max().orElse(Double.NaN);
        return holtWintersForecast(values, alpha, beta, gamma, period, padding, multiplicative, 1)[0];
        }
                    + (2 * period)
    /**
 *
        double avg = Double.NaN;
     */
            }
     * If all values are missing/null/NaN, the return value will be NaN
        }
                if (first) {
                }
     * The average is based on the count of non-null, non-NaN values.
            // TODO perhaps pad out seasonal to a power of 2 and use a mask instead of modulo?
     * If all values are missing/null/NaN, the return value will be NaN
                    + "] were provided."
                    + ") data-points to function.  Only ["
                if (Double.isNaN(v) == false) {
     * @param multiplicative true if multiplicative HW should be used. False for additive
        double avg = 0.0;
        } else {
        double padding = multiplicative ? 0.0000000001 : 0.0;
        if (values.length == 0) {
     * Only finite values are averaged.  NaN or null are ignored.
    public static double min(double[] values) {
     * linearly less important.  "Time" is determined by position in collection
     * (e.g. a random walk), while alpha = 0 retains infinite memory of past values (e.g.
     * @param period the expected periodicity of the data
     * Version of holt-winters that can "forecast", not exposed as an allowlisted function for moving_fn scripts, but
        return forecastValues;
     * <p>
 */
     */
 *
            last_b = b;
 */
 * not use this file except in compliance with the License.
            if (Double.isNaN(v) == false) {
     * Version of holt that can "forecast", not exposed as an allowlisted function for moving_fn scripts, but
 * Licensed to Elasticsearch under one or more contributor
                    s = alpha * v + (1.0d - alpha) * (last_s + last_b);
        if (counter == 0) {
        int counter = 0;
            if (multiplicative) {
            }
        for (int i = 0; i < period; i++) {
 * software distributed under the License is distributed on an
     */
        double beta,
     * Alpha controls the smoothing of the data.  Alpha = 1 retains no memory of past values
        long current = 1;
            }
 * this work for additional information regarding copyright
     *
        return avg;
        }
    }
     * Alpha controls the smoothing of the data.  Alpha = 1 retains no memory of past values
        }
                    + " == "
 * under the License.
 */
        // Smoothed value
     * If all values are missing/null/NaN, the return value will be NaN
     * Calculate a exponentially weighted moving average.
                counter += 1;
                if (counter == 0) {
                return value;
        double gamma,
     * @param numPredictions Number of empty predictions to generate
        }
        long totalWeight = 1;
                    b = beta * (s - last_s) + (1 - beta) * last_b;
                } else {
 * Unless required by applicable law or agreed to in writing,
     * here as compatibility/code sharing for existing moving_avg agg.  Can be removed when moving_avg is gone.
        Arrays.fill(predictions, Double.NaN);
     * (e.g. a random walk), while alpha = 0 retains infinite memory of past values (e.g.
            double squaredMean = 0;
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * compatible open source license.
    public static double holt(double[] values, double alpha, double beta) {
 * You may obtain a copy of the License at
     * The average is based on the count of non-null, non-NaN values.
            if (multiplicative) {
     * <p>
            last_s = s;
            }
        double last_s = 0;
    /**
     * Only finite values are averaged.  NaN or null are ignored.
        return totalWeight == 1 ? Double.NaN : avg / totalWeight;
    public static double sum(double[] values) {
            }
     */
     * If all values are missing/null/NaN, the return value will be NaN.
                    b = v - last;
     */
     * Find the minimum value in a window of values
        }
        if (values.length == 0) {
     */
        // Seasonal value
public class MovingFunctions {
    }
     * Only finite values are averaged.  NaN or null are ignored.
        // Trend value
        int period,
        return Arrays.stream(values).min().orElse(Double.NaN);
            } else {
            return 0.0;
 * Modifications Copyright OpenSearch Contributors. See
    public static double ewma(double[] values, double alpha) {
            if (Double.isNaN(v) == false) {
 * the Apache License, Version 2.0 (the "License"); you may
        double b = 0;
            }
                count += 1;
    }
    }
            return Double.NaN;
        for (int i = 1; i <= numForecasts; i++) {
     * If all values are missing/null/NaN, the return value will be NaN.
    public static double[] holtForecast(double[] values, double alpha, double beta, int numForecasts) {
            }
     * The average is based on the count of non-null, non-NaN values.
                seasonal[i] = gamma * (vs[i] - (last_s - last_b)) + (1 - gamma) * seasonal[i - period];
     * If all values are missing/null/NaN, the return value will be NaN
        } else {
            // This should have been caught earlier, we can't do anything now...bail
                }
