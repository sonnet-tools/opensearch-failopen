        sigma = in.readDouble();
        public static final String UPPER_SAMPLING = "upper_sampling";
    @Override  
                builder.nullField(Fields.LOWER_POPULATION);  
            case UPPER:  
        double compensationOfSqrs = 0;
    public double getStdDeviationSampling() {  
    }  
    }  
            return getStdDeviationBound(Bounds.UPPER_SAMPLING);  
        std_lower_population,  
    public double getSigma() {
    }
    public String getStdDeviationBoundAsString(Bounds bound) {
    public String getWriteableName() {
    @Override  
                builder.field(Fields.STD_DEVIATION_POPULATION_AS_STRING, getStdDeviationPopulationAsString());
            stats.getMin(),
            builder.field(Fields.VARIANCE, getVariance());  
    @Override
        sumOfSqrs = in.readDouble();  
import org.opensearch.search.aggregations.InternalAggregation;
                sumOfSqrs += value;
        } else {
    public String getVarianceAsString() {
    @Override
            case UPPER_POPULATION:
    @Override
        return valueAsString(Metrics.std_deviation_sampling.name());  
 * The OpenSearch Contributors require contributions made to  
    public boolean equals(Object obj) {  
    public String getStdDeviationAsString() {
    }  
        return valueAsString(Metrics.variance_population.name());
     */  
                return getAvg() - (getStdDeviationPopulation() * sigma);
    @Override
        final InternalStats stats = super.reduce(aggregations, reduceContext);  
        double sum,  
            case UPPER:
     * The metrics for the extended stats  
            builder.nullField(Fields.STD_DEVIATION_SAMPLING);  
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.search.aggregations.metrics;
        }
        if ("variance_population".equals(name)) {
import org.opensearch.core.common.io.stream.StreamOutput;
        return builder;  
    public double getStdDeviationBound(Bounds bound) {
            case LOWER:
    }
        public static Metrics resolve(String name) {
        return super.value(name);
        String name,
    @Override
 * Licensed to Elasticsearch under one or more contributor  
        if ("std_lower_sampling".equals(name)) {
import java.util.List;
    }
    /**
        Map<String, Object> metadata  
        this.sumOfSqrs = sumOfSqrs;  
                double correctedOfSqrs = value - compensationOfSqrs;  
/*
            case UPPER_SAMPLING:
        if ("std_upper_population".equals(name)) {
            return getStdDeviation();  
    @Override
    protected XContentBuilder otherStatsToXContent(XContentBuilder builder, Params params) throws IOException {  
        if (obj == null || getClass() != obj.getClass()) return false;
            builder.nullField(Fields.STD_DEVIATION_POPULATION);
        if ("std_upper_sampling".equals(name)) {
    public InternalExtendedStats(StreamInput in) throws IOException {
                builder.field(Fields.UPPER_SAMPLING, getStdDeviationBound(Bounds.UPPER_SAMPLING));  
        variance_sampling,
import java.io.IOException;  
    }
        return new InternalExtendedStats(
        sum,
            case LOWER_SAMPLING:
    public double getVarianceSampling() {
                    builder.field(Fields.LOWER, getStdDeviationBoundAsString(Bounds.LOWER));  
            return getVariance();  
        out.writeDouble(sigma);
        if (super.equals(obj) == false) return false;  
            builder.nullField(Fields.SUM_OF_SQRS);  
        }
                builder.endObject();  
            double value = stats.getSumOfSquares();
        }
            case LOWER_POPULATION:
        std_upper,  
                return getAvg() - (getStdDeviationSampling() * sigma);
/*  
        count,  
        }
        );
            return Metrics.valueOf(name);
import org.opensearch.core.common.io.stream.StreamInput;  
        }
        return Math.sqrt(getVarianceSampling());
        public static final String SUM_OF_SQRS = "sum_of_squares";
        public static final String STD_DEVIATION_POPULATION = "std_deviation_population";  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
        switch (bound) {  
        if ("variance_sampling".equals(name)) {
                    builder.field(Fields.UPPER, getStdDeviationBoundAsString(Bounds.UPPER));
                return valueAsString(Metrics.std_lower_sampling.name());
    @Override
                builder.field(Fields.VARIANCE_SAMPLING_AS_STRING, format.format(getVarianceSampling()));
        public static final String VARIANCE_SAMPLING_AS_STRING = "variance_sampling_as_string";  
            stats.getMax(),  
        double sumOfSqrs = 0;
 * ownership. Elasticsearch licenses this file to you under  
        return sumOfSqrs;
            if (stats.sigma != sigma) {
        return valueAsString(Metrics.sum_of_squares.name());  
 *
    @Override
                {
 * this file be licensed under the Apache-2.0 license or a
    @Override
    public double getStdDeviation() {
/**
            }
    }
 * Implementation of extended stats agg  
        sum_of_squares,
    @Override
            builder.endObject();  
                builder.nullField(Fields.LOWER);
        public static final String SUM_OF_SQRS_AS_STRING = "sum_of_squares_as_string";  
        max,  
        public static final String VARIANCE_SAMPLING = "variance_sampling";
                sumOfSqrs = newSumOfSqrs;  
    @Override  
                    builder.field(Fields.UPPER_POPULATION, getStdDeviationBoundAsString(Bounds.UPPER_POPULATION));
        if (count != 0) {
        if ("variance".equals(name)) {
                builder.startObject(Fields.STD_DEVIATION_BOUNDS_AS_STRING);  
import org.opensearch.core.xcontent.XContentBuilder;
     * @opensearch.internal
 * Unless required by applicable law or agreed to in writing,
            {
    }
 * You may obtain a copy of the License at  
    }  
        return valueAsString(Metrics.std_deviation_population.name());
        this.sigma = sigma;
    }
    public int hashCode() {
        }
            format,  
        if ("sum_of_squares".equals(name)) {
            sigma,
                    builder.field(Fields.UPPER_SAMPLING, getStdDeviationBoundAsString(Bounds.UPPER_SAMPLING));  
        public static final String VARIANCE_POPULATION_AS_STRING = "variance_population_as_string";
        public static final String STD_DEVIATION_BOUNDS = "std_deviation_bounds";
    }  
            builder.nullField(Fields.VARIANCE_SAMPLING);  
    public double value(String name) {
            return getStdDeviationBound(Bounds.LOWER_POPULATION);  
 * KIND, either express or implied.  See the License for the
     */  
        std_upper_sampling,
                builder.field(Fields.UPPER, getStdDeviationBound(Bounds.UPPER));
        return variance < 0 ? 0 : variance;
        variance_population,
        public static final String LOWER_SAMPLING = "lower_sampling";
    @Override
                builder.field(Fields.VARIANCE_AS_STRING, format.format(getVariance()));  
            builder.nullField(Fields.VARIANCE);
public class InternalExtendedStats extends InternalStats implements ExtendedStats {
    @Override  
        return valueAsString(Metrics.std_deviation.name());
            builder.startObject(Fields.STD_DEVIATION_BOUNDS);
        out.writeDouble(sumOfSqrs);  
            builder.startObject(Fields.STD_DEVIATION_BOUNDS);  
    }
    enum Metrics {
        for (InternalAggregation aggregation : aggregations) {  
     * @opensearch.internal
                return getAvg() + (getStdDeviationSampling() * sigma);
 */  
                return getAvg() + (getStdDeviationPopulation() * sigma);  
                builder.field(Fields.STD_DEVIATION_SAMPLING_AS_STRING, getStdDeviationSamplingAsString());
        }
                builder.field(Fields.SUM_OF_SQRS_AS_STRING, format.format(sumOfSqrs));
            return getStdDeviationBound(Bounds.LOWER_SAMPLING);  
                builder.field(Fields.UPPER_POPULATION, getStdDeviationBound(Bounds.UPPER_POPULATION));
        if ("std_lower_population".equals(name)) {
            default:  
                throw new IllegalStateException("Cannot reduce other stats aggregations that have a different sigma");  
            builder.field(Fields.STD_DEVIATION_POPULATION, getStdDeviationPopulation());
        public static final String UPPER_POPULATION = "upper_population";
        }
    }
                builder.field(Fields.LOWER_POPULATION, getStdDeviationBound(Bounds.LOWER_POPULATION));
        switch (bound) {
            builder.field(Fields.STD_DEVIATION_SAMPLING, getStdDeviationSampling());
            return getVarianceSampling();  
            stats.getSum(),
    protected void writeOtherStatsTo(StreamOutput out) throws IOException {
    }
        }
        return getStdDeviationPopulation();  
            builder.field(Fields.VARIANCE_SAMPLING, getVarianceSampling());
                builder.nullField(Fields.UPPER);  
        public static final String LOWER_POPULATION = "lower_population";  
                compensationOfSqrs = (newSumOfSqrs - sumOfSqrs) - correctedOfSqrs;
        }  
 *  
        return Objects.hash(super.hashCode(), sumOfSqrs, sigma);
 */
    @Override  
                builder.field(Fields.VARIANCE_POPULATION_AS_STRING, format.format(getVariancePopulation()));
 * GitHub history for details.
    }
            return getStdDeviationSampling();  
            }  
                return valueAsString(Metrics.std_upper_population.name());
        double sumOfSqrs,  
                return valueAsString(Metrics.std_lower_population.name());
    }
    }
    @Override
        public static final String LOWER = "lower";
                builder.field(Fields.LOWER, getStdDeviationBound(Bounds.LOWER));  
                builder.nullField(Fields.LOWER_SAMPLING);
        public static final String UPPER = "upper";  
    ) {
            }
    @Override  
        public static final String STD_DEVIATION_POPULATION_AS_STRING = "std_deviation_population_as_string";
    public String getVarianceSamplingAsString() {
    }
            if (Double.isFinite(value) == false) {  
    }  
            return getStdDeviationPopulation();  
        return this.sigma;  
                    builder.field(Fields.LOWER_SAMPLING, getStdDeviationBoundAsString(Bounds.LOWER_SAMPLING));
            return sumOfSqrs;  
                return valueAsString(Metrics.std_upper_sampling.name());  
        if ("std_lower".equals(name)) {
        long count,
    }
            default:
            return getStdDeviationBound(Bounds.UPPER);  
        return getVariancePopulation();
        double variance = (sumOfSqrs - ((sum * sum) / count)) / count;  
        public static final String VARIANCE_AS_STRING = "variance_as_string";
                }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
        return Double.compare(sumOfSqrs, other.sumOfSqrs) == 0 && Double.compare(sigma, other.sigma) == 0;  
    }  
        }
            name,
     * Fields for internal extended stats  
        double variance = (sumOfSqrs - ((sum * sum) / count)) / (count - 1);  
    /**
 * under the License.  
        std_lower,
    public InternalExtendedStats(  
 * this work for additional information regarding copyright
            case LOWER_SAMPLING:  
    public InternalExtendedStats reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {  
        double max,
 * specific language governing permissions and limitations
                builder.nullField(Fields.UPPER_POPULATION);
                return valueAsString(Metrics.std_lower.name());  
    public double getStdDeviationPopulation() {
        public static final String STD_DEVIATION = "std_deviation";
    public double getVariance() {  
 * license agreements. See the NOTICE file distributed with
    static class Fields {
        }
 */  
            InternalExtendedStats stats = (InternalExtendedStats) aggregation;
                return valueAsString(Metrics.std_upper.name());
    public String getStdDeviationSamplingAsString() {
        DocValueFormat formatter,
        double min,
     *
 * not use this file except in compliance with the License.
    private final double sumOfSqrs;  
        return variance < 0 ? 0 : variance;
                throw new IllegalArgumentException("Unknown bounds type " + bound);
        }
            if (format != DocValueFormat.RAW) {
        public static final String VARIANCE = "variance";
        super(name, count, sum, min, max, formatter, metadata);
        return valueAsString(Metrics.variance_sampling.name());  
        }
        public static final String STD_DEVIATION_SAMPLING_AS_STRING = "std_deviation_sampling_as_string";  
        public static final String VARIANCE_POPULATION = "variance_population";  
    @Override
    }
 * Modifications Copyright OpenSearch Contributors. See  
        InternalExtendedStats other = (InternalExtendedStats) obj;
            return getStdDeviationBound(Bounds.UPPER_POPULATION);  
/*
            case UPPER_POPULATION:
        double sigma,
    }  
                builder.nullField(Fields.UPPER_SAMPLING);
}
            }
    @Override
import org.opensearch.search.DocValueFormat;  
import java.util.Map;
                throw new IllegalArgumentException("Unknown bounds type " + bound);  
        std_deviation_population,
        if ("std_upper".equals(name)) {
        super(in);
    public double getVariancePopulation() {
    }
            builder.nullField(Fields.VARIANCE_POPULATION);
    /**
        return Math.sqrt(getVariancePopulation());
    @Override  
 *
    public String getSumOfSquaresAsString() {
        min,
        if (this == obj) return true;
        std_deviation,  
     */  
    public String getVariancePopulationAsString() {  
        std_upper_population,
        if ("std_deviation".equals(name)) {
            builder.endObject();
import java.util.Objects;  
        variance,  
        std_lower_sampling;
        return ExtendedStatsAggregationBuilder.NAME;  
                    builder.field(Fields.LOWER_POPULATION, getStdDeviationBoundAsString(Bounds.LOWER_POPULATION));
        public static final String STD_DEVIATION_BOUNDS_AS_STRING = "std_deviation_bounds_as_string";
        public static final String STD_DEVIATION_AS_STRING = "std_deviation_as_string";
            stats.getCount(),  
            case LOWER:  
 */
        avg,
            sumOfSqrs,
        if ("std_deviation_sampling".equals(name)) {
            getMetadata()
        return valueAsString(Metrics.variance.name());
    }  
        }
        public static final String STD_DEVIATION_SAMPLING = "std_deviation_sampling";
            builder.field(Fields.VARIANCE_POPULATION, getVariancePopulation());
 * @opensearch.internal
                double newSumOfSqrs = sumOfSqrs + correctedOfSqrs;
        }
            return getStdDeviationBound(Bounds.LOWER);  
            }
    private final double sigma;
                builder.field(Fields.LOWER_SAMPLING, getStdDeviationBound(Bounds.LOWER_SAMPLING));
    @Override
    }
            return getVariancePopulation();  
            case UPPER_SAMPLING:
        }
 * compatible open source license.
        if ("std_deviation_population".equals(name)) {
            } else if (Double.isFinite(sumOfSqrs)) {
     *
            builder.nullField(Fields.STD_DEVIATION);
            {
                builder.field(Fields.STD_DEVIATION_AS_STRING, getStdDeviationAsString());  
    @Override
            case LOWER_POPULATION:  
        std_deviation_sampling,
     * Read from a stream.
 *
            builder.field(Fields.STD_DEVIATION, getStdDeviation());  
    public double getSumOfSquares() {
    public String getStdDeviationPopulationAsString() {  
        }
 * software distributed under the License is distributed on an
            builder.field(Fields.SUM_OF_SQRS, sumOfSqrs);
