        double last_s;
        }
    }
     * @param beta a double between 0-1 inclusive, controls trend smoothing
        double s = 0;  
        if (values.length == 0) {
        double[] seasonal = new double[values.length];
     * Calculate a simple unweighted (arithmetic) moving average.
 * under the License.  
     * Only finite values are averaged.  NaN or null are ignored.
                avg += v;  
    public static double min(double[] values) {
                vs[counter] = v + padding;
     * here as compatibility/code sharing for existing moving_avg agg.  Can be removed when moving_avg is gone.
    /**
        return forecastValues;
    public static double sum(double[] values) {  
/*  
     */  
 * The OpenSearch Contributors require contributions made to  
            s += vs[i];
            if (Double.isNaN(v) == false) {
            // We need at least two full "seasons" to use HW
        return forecastValues;
        return predictions;  
                seasonal[i] = gamma * (vs[i] / (last_s + last_b)) + (1 - gamma) * seasonal[i - period];
                "Holt-Winters aggregation requires at least (2 * period == 2 * "
    }
    /**  
            if (multiplicative) {
    }
        }
                forecastValues[i - 1] = (s + (i * b)) * seasonal[idx];
        double beta,
            for (double v : values) {
                    + "] were provided."
/**  
        }  
 * this file be licensed under the Apache-2.0 license or a
            if (Double.isNaN(value) == false) {
    /**  
        int counter = 0;
        for (double v : values) {
            if (Double.isNaN(v) == false) {  
     */  
     * Version of holt that can "forecast", not exposed as an allowlisted function for moving_fn scripts, but
     */
/*  
        }  
    /**
            Arrays.fill(seasonal, 0.0);
     * linearly less important.  "Time" is determined by position in collection
    ) {
     * <p>  
     */  
        int counter = 0;
                if (Double.isNaN(v) == false) {  
        } else {
        Arrays.fill(predictions, Double.NaN);
     * the series mean).  Useful values are somewhere in between.  Defaults to 0.5.
     * @param numPredictions Number of empty predictions to generate
    }
            double squaredMean = 0;
                avg += v * current;  
            // TODO if perf is a problem, we can specialize a subclass to avoid conditionals on each iteration
     * Version of holt-winters that can "forecast", not exposed as an allowlisted function for moving_fn scripts, but
        long current = 1;
        boolean multiplicative,  
            return Double.NaN;  
     * Only finite values are averaged.  NaN or null are ignored.
        for (int i = 0; i < period; i++) {
            forecastValues[i] = s + (i * b);
            b += (vs[i + period] - vs[i]) / period;  
                    squaredMean += Math.pow(v - avg, 2);
}
                if (first) {
     * If all values are missing/null/NaN, the return value will be NaN
        for (double v : values) {
            return Double.NaN;  
        }
     * If all values are missing/null/NaN, the return value will be NaN.
            }
            }
    /**
        long totalWeight = 1;
 *  
     * <p>  
     * The average is based on the count of non-null, non-NaN values.  
        double avg = 0;  
 * compatible open source license.
        double last_s = 0;
                counter += 1;
            long count = 0;  
     */
        return Arrays.stream(values).min().orElse(Double.NaN);
     * @param gamma a double between 0-1 inclusive, controls seasonality smoothing
            if (Double.isNaN(v) == false) {  
     * Alpha controls the smoothing of the data.  Alpha = 1 retains no memory of past values  
     * the series mean).  Useful values are somewhere in between.  Defaults to 0.5.  
 */  
    public static double[] holtWintersForecast(
                    + values.length  
                    b = beta * (s - last_s) + (1 - beta) * last_b;
            }  
    public static double[] holtForecast(double[] values, double alpha, double beta, int numForecasts) {
     * Gamma is equivalent to alpha, but controls the smoothing of the seasonality instead of the data  
        }  
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }  
            if (Double.isNaN(v) == false) {
    /**  
 * ownership. Elasticsearch licenses this file to you under  
                    + period
        return Arrays.stream(values).max().orElse(Double.NaN);  
        double b = 0;
     * If all values are missing/null/NaN, the return value will be NaN  
        for (int i = period; i < vs.length; i++) {  
    }  
        // Calculate the slopes between first and second season for each period  
                    b = v - last;
                } else {
    /**  
     * Alpha controls the smoothing of the data.  Alpha = 1 retains no memory of past values
        }
        last_s = s;
     * Beta is equivalent to alpha, but controls the smoothing of the trend instead of the data
    }
    public static double max(double[] values) {
            }
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
            b = beta * (s - last_s) + (1 - beta) * last_b;
                totalWeight += current;
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
        // Smoothed value
                forecastValues[i - 1] = s + (i * b) + seasonal[idx];
 *
 * Provides a collection of static utility methods that can be referenced from MovingFunction script contexts
        double[] predictions = new double[numPredictions];
                counter += 1;  
        }
            for (int i = 0; i < period; i++) {
                    first = false;  
/*
        for (double v : values) {
    /**
        double b = 0;
 *
    public static double stdDev(double[] values, double avg) {
                count += 1;
     * Beta is equivalent to alpha, but controls the smoothing of the trend instead of the data.
        for (double v : values) {  
            return 0.0;
 * Modifications Copyright OpenSearch Contributors. See
    public static double ewma(double[] values, double alpha) {
     * (e.g. a random walk), while alpha = 0 retains infinite memory of past values (e.g.
        double padding = multiplicative ? 0.0000000001 : 0.0;  
     * @param alpha A double between 0-1 inclusive, controls data smoothing
     * Only finite values are averaged.  NaN or null are ignored.
     */
        Double last;
     * here as compatibility/code sharing for existing moving_avg agg.  Can be removed when moving_avg is gone.  
            // This should have been caught earlier, we can't do anything now...bail
                    count += 1;
            } else {  
        double avg = Double.NaN;
                    avg = (v * alpha) + (avg * (1 - alpha));
            return Math.sqrt(squaredMean / count);
                }
     * Calculate a triple exponential weighted moving average
        if (Double.compare(s, 0.0) == 0 || Double.compare(s, -0.0) == 0) {
            if (multiplicative) {
        return totalWeight == 1 ? Double.NaN : avg / totalWeight;
        double[] values,  
        double s = 0;
        boolean first = true;  
     * Only finite values are averaged.  NaN or null are ignored.  
                    + ") data-points to function.  Only ["
     * <p>
                    s = v;  
    private static double[] emptyPredictions(int numPredictions) {  
     * If all values are missing/null/NaN, the return value will be NaN
                seasonal[i] = gamma * (vs[i] - (last_s - last_b)) + (1 - gamma) * seasonal[i - period];
     * If all values are missing/null/NaN, the return value will be NaN
     * @param period the expected periodicity of the data  
     * If all values are missing/null/NaN, the return value will be 0.0
                s = alpha * (vs[i] - seasonal[i - period]) + (1.0d - alpha) * (last_s + last_b);
            } else {  
            return emptyPredictions(numForecasts);
 * GitHub history for details.
     * (e.g. a random walk), while alpha = 0 retains infinite memory of past values (e.g.
 * specific language governing permissions and limitations
     * If all values are missing/null/NaN, the return value will be NaN.
            );
        double alpha,
        double[] forecastValues = new double[numForecasts];
            throw new IllegalArgumentException(  
 */  
     * <p>
 * KIND, either express or implied.  See the License for the
        // Calculate first seasonal  
        for (int i = 1; i <= numForecasts; i++) {  
     */  
     * @param alpha A double between 0-1 inclusive, controls data smoothing  
        return count == 0 ? Double.NaN : avg / count;
        long count = 0;  
            }
     */
            last_b = b;
     * The average is based on the count of non-null, non-NaN values.  
                return value;  
     * The average is based on the count of non-null, non-NaN values.  
     * The average is based on the count of non-null, non-NaN values.
        if (counter == 0) {
    }
        } else {  
     * Find the sum of a window of values  
     * <p>
        return avg;  
        if (values.length == 0) {
     *  
package org.opensearch.search.aggregations.pipeline;
     * Calculate a standard deviation over the values using the provided average.
     * <p>
        }  
                last = v;
    public static double linearWeightedAvg(double[] values) {
        double avg = 0.0;
     * The average is based on the count of non-null, non-NaN values.
        // Trend value
     *  
     * the series mean).  Useful values are somewhere in between.  Defaults to 0.5.
                last_s = s;
        int period,
    public static double unweightedAvg(double[] values) {
     * Find the minimum value in a window of values
                } else {
     *
                s = alpha * (vs[i] / seasonal[i - period]) + (1.0d - alpha) * (last_s + last_b);  
        return holtWintersForecast(values, alpha, beta, gamma, period, padding, multiplicative, 1)[0];
     */
     * Alpha controls the smoothing of the data.  Alpha = 1 retains no memory of past values  
            }
     */
        b /= period;  
public class MovingFunctions {
        double last_b = 0;  
        }  
            } else {
        double[] forecastValues = new double[numForecasts];
        double padding,
     */  
            }
     * The average is based on the count of non-null, non-NaN values.
     * If all values are missing/null/NaN, the return value will be NaN
        // Seasonal value
     * If all values are missing/null/NaN, the return value will be NaN  
            if (Double.isNaN(v) == false) {
 * @opensearch.internal  
     */
        // Initial level value is average of first season
        // Smoothed value  
            }
    /**
                    avg = v;
                }  
     * Calculate a linearly weighted moving average, such that older values are
                    + " == "  
     *
            return 0.0;
    }  
        return holtForecast(values, alpha, beta, 1)[0];  
 */
    public static double holt(double[] values, double alpha, double beta) {
 * software distributed under the License is distributed on an
     * @param alpha A double between 0-1 inclusive, controls data smoothing
    /**  
        }
 * the Apache License, Version 2.0 (the "License"); you may
            // TODO perhaps pad out seasonal to a power of 2 and use a mask instead of modulo?  
    }  
                last_b = b;  
     * Only finite values are averaged.  NaN or null are ignored.
        int numForecasts
            if (multiplicative) {
        }  
        for (int i = 0; i < numForecasts; i++) {  
                    s = alpha * v + (1.0d - alpha) * (last_s + last_b);  
        for (double v : values) {
     * Returns an empty set of predictions, filled with NaNs  
        double[] vs = new double[values.length];
        // Trend value  
                current += 1;
 */
            return emptyPredictions(numForecasts);
            return Double.NaN;
 * not use this file except in compliance with the License.
     * Calculate a doubly exponential weighted moving average
     * <p>  
     * <p>  
        s /= period;
        }
            }  
    /**
                    + (2 * period)
import java.util.Arrays;
 * Unless required by applicable law or agreed to in writing,
     * Find the maximum value in a window of values.
        if (counter == 0) {
     * @param beta a double between 0-1 inclusive, controls trend smoothing
 *
        double last_b = 0;
        }  
        }).sum();  
    }
            }
                seasonal[i] = vs[i] / s;
        }  
    }
            last_s = s;
     * <p>
                if (counter == 0) {
     * <p>
 * license agreements. See the NOTICE file distributed with
    }
        if (values.length == 0) {
     * Calculate a exponentially weighted moving average.
                }  
        return Arrays.stream(values).map(value -> {
    /**
        }
        if (values.length < period * 2) {  
     * <p>  
     * Only finite values are averaged.  NaN or null are ignored.  
     * (e.g. a random walk), while alpha = 0 retains infinite memory of past values (e.g.
     * @param multiplicative true if multiplicative HW should be used. False for additive
            int idx = values.length - period + ((i - 1) % period);
        double gamma,  
        if (Double.isNaN(avg)) {  
    public static double holtWinters(double[] values, double alpha, double beta, double gamma, int period, boolean multiplicative) {  
 * this work for additional information regarding copyright
