            builder.endObject();
                builder.nullField(Fields.LOWER);
        this.stdDeviationBoundUpper = bounds.get(0);
            builder.nullField(Fields.STD_DEVIATION_POPULATION);
            (parser, context) -> parseDouble(parser, 0),
        objectParser.declareField(
            optionalConstructorArg(),
/*
 */
            ValueType.DOUBLE_OR_NULL
        );
        objectParser.declareString(
            }
                builder.field(Fields.VARIANCE_AS_STRING, getVarianceAsString());
    public double getStdDeviationPopulation() {
/*
        return variance;
 * compatible open source license.
        objectParser.declareString(
                builder.field(Fields.UPPER_SAMPLING, getStdDeviationBound(Bounds.UPPER_SAMPLING));
        }
            ValueType.DOUBLE_OR_NULL
 *
            (parser, context) -> parseDouble(parser, 0),
            new ParseField(Fields.LOWER_SAMPLING),
 * this work for additional information regarding copyright
 * under the License.
    }
            case UPPER:
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
/*
            builder.nullField(Fields.STD_DEVIATION_SAMPLING);
        true,
        true,
                builder.field(Fields.SUM_OF_SQRS_AS_STRING, getSumOfSquaresAsString());
    private static final ObjectParser<ParsedExtendedStats, Void> PARSER = new ObjectParser<>(
                builder.field(Fields.STD_DEVIATION_POPULATION_AS_STRING, getStdDeviationPopulationAsString());
        }
            (agg, value) -> agg.stdDeviation = value,
            (parser, context) -> parseDouble(parser, 0),
    }
        declareAggregationFields(objectParser);
    protected double sum;
    protected double stdDeviationBoundLowerPopulation;
            case UPPER:
    @Override
    static {
    @Override
    @Override
 * not use this file except in compliance with the License.
    public String getVarianceAsString() {
            new ParseField(Fields.VARIANCE),
                );
            builder.field(Fields.STD_DEVIATION_SAMPLING, getStdDeviationSampling());
        );
            builder.field(Fields.STD_DEVIATION_POPULATION, getStdDeviationPopulation());
                builder.startObject(Fields.STD_DEVIATION_BOUNDS_AS_STRING);
    private static final ConstructingObjectParser<List<Double>, Void> STD_BOUNDS_PARSER = new ConstructingObjectParser<>(
                return stdDeviationBoundLowerSampling;
        switch (bound) {
        return variancePopulation;
        switch (bound) {
        objectParser.declareField(
        true,
                );
            default:
            new ParseField(Fields.UPPER),
            (agg, value) -> agg.variancePopulation = value,
    }
        ParsedExtendedStats.class.getSimpleName() + "_STD_BOUNDS",
                return stdDeviationBoundUpperSampling;
    @Override
        this.stdDeviationBoundUpperPopulation = bounds.get(2) == null ? 0 : bounds.get(2);
            new ParseField(Fields.UPPER_POPULATION),
        objectParser.declareField(
            this.valueAsString.put(Fields.STD_DEVIATION_BOUNDS_AS_STRING + "_lower_sampling", boundsAsString.get(5));
        objectParser.declareString(
    );
            builder.endObject();
            (agg, value) -> agg.stdDeviationPopulation = value,
        this.valueAsString.put(Fields.STD_DEVIATION_BOUNDS_AS_STRING + "_lower", boundsAsString.get(1));
            builder.nullField(Fields.STD_DEVIATION);
                builder.field(Fields.LOWER, getStdDeviationBound(Bounds.LOWER));
            ValueType.DOUBLE_OR_NULL
                return stdDeviationBoundUpperPopulation;
                builder.nullField(Fields.LOWER_POPULATION);
    public String getSumOfSquaresAsString() {
        );
        } else {
 * @opensearch.internal
    }
        return builder;
            builder.startObject(Fields.STD_DEVIATION_BOUNDS);
                builder.nullField(Fields.UPPER);
        ParsedExtendedStats parsedStats = PARSER.apply(parser, null);
        );
 * Licensed to Elasticsearch under one or more contributor
        this.stdDeviationBoundLowerPopulation = bounds.get(3) == null ? 0 : bounds.get(3);
    protected static void declareExtendedStatsFields(ObjectParser<? extends ParsedExtendedStats, Void> objectParser) {
            new ParseField(Fields.VARIANCE_SAMPLING_AS_STRING)
 * You may obtain a copy of the License at
        return valueAsString.getOrDefault(Fields.STD_DEVIATION_SAMPLING_AS_STRING, Double.toString(stdDeviationSampling));
                builder.endObject();
    public double getStdDeviationSampling() {
            (parser, context) -> parseDouble(parser, 0),
    protected double avg;
                builder.nullField(Fields.LOWER_SAMPLING);
    protected double stdDeviationBoundUpperPopulation;
            ValueType.DOUBLE_OR_NULL
            this.valueAsString.put(Fields.STD_DEVIATION_BOUNDS_AS_STRING + "_lower_population", boundsAsString.get(3));
 *
        STD_BOUNDS_AS_STRING_PARSER.declareString(constructorArg(), new ParseField(Fields.UPPER));
    }
                    builder.field(Fields.LOWER_POPULATION, getStdDeviationBoundAsString(Bounds.LOWER_POPULATION));
    protected double stdDeviationPopulation;
            (parser, context) -> parseDouble(parser, 0),
    }
        return valueAsString.getOrDefault(Fields.SUM_OF_SQRS_AS_STRING, Double.toString(sumOfSquares));
    private void setStdDeviationBoundsAsString(List<String> boundsAsString) {
                builder.nullField(Fields.UPPER_SAMPLING);
        STD_BOUNDS_AS_STRING_PARSER.declareString(optionalConstructorArg(), new ParseField(Fields.UPPER_SAMPLING));
        args -> Arrays.stream(args).map(d -> (String) d).collect(Collectors.toList())
        if (count != 0) {
    @Override
    private static final ConstructingObjectParser<List<String>, Void> STD_BOUNDS_AS_STRING_PARSER = new ConstructingObjectParser<>(
                return stdDeviationBoundLowerPopulation;
            optionalConstructorArg(),
            ValueType.DOUBLE_OR_NULL
        STD_BOUNDS_PARSER.declareField(
 * GitHub history for details.
    public double getVarianceSampling() {
    }
    );
        ParsedExtendedStats.class.getSimpleName() + "_STD_BOUNDS_AS_STRING",
    private void setStdDeviationBounds(List<Double> bounds) {
            new ParseField(Fields.STD_DEVIATION),
        );
                    Double.toString(stdDeviationBoundLower)
        STD_BOUNDS_PARSER.declareField(
                    builder.field(Fields.UPPER_SAMPLING, getStdDeviationBoundAsString(Bounds.UPPER_SAMPLING));
            (parser, context) -> parseDouble(parser, 0),
            ValueType.DOUBLE_OR_NULL
            optionalConstructorArg(),
            case UPPER_POPULATION:
        if (boundsAsString.get(4) != null) {
        this.stdDeviationBoundLowerSampling = bounds.get(5) == null ? 0 : bounds.get(5);
        return valueAsString.getOrDefault(Fields.STD_DEVIATION_AS_STRING, Double.toString(stdDeviation));
                throw new IllegalArgumentException("Unknown bounds type " + bound);
        );
import org.opensearch.core.xcontent.XContentBuilder;
            builder.nullField(Fields.VARIANCE_SAMPLING);
import java.io.IOException;
            builder.field(Fields.STD_DEVIATION, getStdDeviation());
            if (valueAsString.containsKey(Fields.SUM_OF_SQRS_AS_STRING)) {
            this.valueAsString.put(Fields.STD_DEVIATION_BOUNDS_AS_STRING + "_upper_sampling", boundsAsString.get(4));
            new ParseField(Fields.SUM_OF_SQRS_AS_STRING)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            case LOWER_POPULATION:
            default:
            (parser, context) -> parseDouble(parser, 0),
        );
                return valueAsString.getOrDefault(
            }
    protected XContentBuilder otherStatsToXContent(XContentBuilder builder, Params params) throws IOException {
        objectParser.declareString(
            ValueType.DOUBLE_OR_NULL
                }
            (agg, value) -> agg.valueAsString.put(Fields.STD_DEVIATION_POPULATION_AS_STRING, value),
import org.opensearch.search.aggregations.metrics.InternalExtendedStats.Fields;
    @Override
                {
        ParsedExtendedStats::new
                builder.field(Fields.VARIANCE_POPULATION_AS_STRING, getVariancePopulationAsString());
                    Fields.STD_DEVIATION_BOUNDS_AS_STRING + "_upper",
                );
import org.opensearch.core.ParseField;
        return valueAsString.getOrDefault(Fields.VARIANCE_AS_STRING, Double.toString(variance));
        );
            (agg, value) -> agg.variance = value,
                    Double.toString(stdDeviationBoundLowerSampling)
        objectParser.declareString(
                builder.field(Fields.VARIANCE_SAMPLING_AS_STRING, getVarianceSamplingAsString());
        STD_BOUNDS_AS_STRING_PARSER.declareString(optionalConstructorArg(), new ParseField(Fields.UPPER_POPULATION));
    public String getVarianceSamplingAsString() {
        return ExtendedStatsAggregationBuilder.NAME;
        STD_BOUNDS_PARSER.declareField(
    public String getStdDeviationBoundAsString(Bounds bound) {
 *
        );
                return valueAsString.getOrDefault(
    }
                return valueAsString.getOrDefault(
                throw new IllegalArgumentException("Unknown bounds type " + bound);
 */
        objectParser.declareField(
        }
                builder.field(Fields.STD_DEVIATION_SAMPLING_AS_STRING, getStdDeviationSamplingAsString());
                    Double.toString(stdDeviationBoundUpper)
            builder.field(Fields.VARIANCE, getVariance());
        if (boundsAsString.get(5) != null) {
            builder.field(Fields.VARIANCE_POPULATION, getVariancePopulation());
        );
        return parsedStats;
    protected double variance;
    @Override
    @Override
            (agg, value) -> agg.valueAsString.put(Fields.VARIANCE_AS_STRING, value),
        STD_BOUNDS_PARSER.declareField(
            case LOWER_SAMPLING:
 */
            constructorArg(),
import org.opensearch.core.xcontent.ConstructingObjectParser;
                    Double.toString(stdDeviationBoundUpperPopulation)
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.xcontent.ObjectParser;
                    builder.field(Fields.LOWER, getStdDeviationBoundAsString(Bounds.LOWER));
    @Override
    protected double stdDeviationSampling;
 */
            new ParseField(Fields.STD_DEVIATION_SAMPLING),
 * this file be licensed under the Apache-2.0 license or a
    @Override
                    Double.toString(stdDeviationBoundUpperSampling)
    protected double stdDeviation;
        return varianceSampling;
                return valueAsString.getOrDefault(
        return stdDeviation;
        this.stdDeviationBoundUpperSampling = bounds.get(4) == null ? 0 : bounds.get(4);
                );
        ParsedExtendedStats.class.getSimpleName(),
        objectParser.declareField(
            (parser, context) -> parseDouble(parser, 0),
                );
            new ParseField(Fields.UPPER_SAMPLING),
                    Double.toString(stdDeviationBoundLowerPopulation)
    public String getVariancePopulationAsString() {
        );
            STD_BOUNDS_PARSER,
            ValueType.DOUBLE_OR_NULL
    }
            case UPPER_POPULATION:
            builder.field(Fields.VARIANCE_SAMPLING, getVarianceSampling());
            new ParseField(Fields.STD_DEVIATION_POPULATION_AS_STRING)
    public String getType() {
            (agg, value) -> agg.stdDeviationSampling = value,
    @Override
            (parser, context) -> parseDouble(parser, 0),
            (parser, context) -> parseDouble(parser, 0),
            (agg, value) -> agg.valueAsString.put(Fields.STD_DEVIATION_SAMPLING_AS_STRING, value),
    public String getStdDeviationSamplingAsString() {
                    Fields.STD_DEVIATION_BOUNDS_AS_STRING + "_lower_population",
            optionalConstructorArg(),
        );
        return valueAsString.getOrDefault(Fields.STD_DEVIATION_POPULATION_AS_STRING, Double.toString(stdDeviationPopulation));
    }
                    Fields.STD_DEVIATION_BOUNDS_AS_STRING + "_upper_sampling",
            (agg, value) -> agg.valueAsString.put(Fields.SUM_OF_SQRS_AS_STRING, value),
        objectParser.declareObject(
    protected double stdDeviationBoundLower;
import java.util.List;
    protected double variancePopulation;
                    builder.field(Fields.UPPER_POPULATION, getStdDeviationBoundAsString(Bounds.UPPER_POPULATION));
            (parser, context) -> parseDouble(parser, 0),
 *
    public String getStdDeviationPopulationAsString() {
        objectParser.declareString(
            case LOWER:
    }
            case UPPER_SAMPLING:
        this.stdDeviationBoundLower = bounds.get(1);
 * ownership. Elasticsearch licenses this file to you under
        );
        declareStatsFields(objectParser);
            case LOWER_SAMPLING:
        objectParser.declareString(
import java.util.Arrays;
        objectParser.declareObject(
 * An extended stats agg result parsed between nodes
            this.valueAsString.put(Fields.STD_DEVIATION_BOUNDS_AS_STRING + "_upper_population", boundsAsString.get(2));
        }
        objectParser.declareField(
    }
            ValueType.DOUBLE_OR_NULL
import org.opensearch.core.xcontent.XContentParser;
                builder.field(Fields.UPPER, getStdDeviationBound(Bounds.UPPER));
            new ParseField(Fields.STD_DEVIATION_BOUNDS)
        );
            (agg, value) -> agg.valueAsString.put(Fields.VARIANCE_SAMPLING_AS_STRING, value),
            case UPPER_SAMPLING:
        );
 * the Apache License, Version 2.0 (the "License"); you may
                return valueAsString.getOrDefault(
            (agg, value) -> agg.valueAsString.put(Fields.VARIANCE_POPULATION_AS_STRING, value),
        if (boundsAsString.get(2) != null) {
            (agg, value) -> agg.sumOfSquares = value,
            (parser, context) -> parseDouble(parser, 0),
    @Override
    }
        }
            builder.field(Fields.SUM_OF_SQRS, sumOfSquares);
        declareExtendedStatsFields(PARSER);
package org.opensearch.search.aggregations.metrics;
        return sumOfSquares;
    @Override
    }
        STD_BOUNDS_AS_STRING_PARSER.declareString(optionalConstructorArg(), new ParseField(Fields.LOWER_POPULATION));
    protected double stdDeviationBoundUpper;
        parsedStats.setName(name);
                    builder.field(Fields.UPPER, getStdDeviationBoundAsString(Bounds.UPPER));
            case LOWER:
            constructorArg(),
            builder.nullField(Fields.SUM_OF_SQRS);
import java.util.stream.Collectors;
        );
            new ParseField(Fields.VARIANCE_SAMPLING),
 * Modifications Copyright OpenSearch Contributors. See
            }
    public String getStdDeviationAsString() {
            {
    protected double varianceSampling;
    protected double stdDeviationBoundUpperSampling;
    public double getStdDeviation() {
    @Override
        objectParser.declareField(
        return valueAsString.getOrDefault(Fields.VARIANCE_POPULATION_AS_STRING, Double.toString(variancePopulation));
            new ParseField(Fields.SUM_OF_SQRS),
/**
            new ParseField(Fields.STD_DEVIATION_SAMPLING_AS_STRING)
    @Override
    protected double sumOfSquares;
    }
    protected double stdDeviationBoundLowerSampling;
 * SPDX-License-Identifier: Apache-2.0
            ValueType.DOUBLE_OR_NULL
                    Fields.STD_DEVIATION_BOUNDS_AS_STRING + "_lower_sampling",
            new ParseField(Fields.VARIANCE_POPULATION),
            ParsedExtendedStats::setStdDeviationBounds,
                    Fields.STD_DEVIATION_BOUNDS_AS_STRING + "_lower",
import org.opensearch.core.xcontent.ObjectParser.ValueType;
                    builder.field(Fields.LOWER_SAMPLING, getStdDeviationBoundAsString(Bounds.LOWER_SAMPLING));
        );
            ValueType.DOUBLE_OR_NULL
    public static ParsedExtendedStats fromXContent(XContentParser parser, final String name) {
        STD_BOUNDS_AS_STRING_PARSER.declareString(optionalConstructorArg(), new ParseField(Fields.LOWER_SAMPLING));
        );
                    Fields.STD_DEVIATION_BOUNDS_AS_STRING + "_upper_population",
                builder.field(Fields.UPPER_POPULATION, getStdDeviationBound(Bounds.UPPER_POPULATION));
        STD_BOUNDS_PARSER.declareField(
        );
public class ParsedExtendedStats extends ParsedStats implements ExtendedStats {
 *     http://www.apache.org/licenses/LICENSE-2.0
                return stdDeviationBoundLower;
}
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
        );
        if (boundsAsString.get(3) != null) {
            (agg, value) -> agg.varianceSampling = value,
    @Override
            ValueType.DOUBLE_OR_NULL
            builder.startObject(Fields.STD_DEVIATION_BOUNDS);
 * KIND, either express or implied.  See the License for the
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
            new ParseField(Fields.STD_DEVIATION_POPULATION),
    public double getStdDeviationBound(Bounds bound) {
            STD_BOUNDS_AS_STRING_PARSER,
        STD_BOUNDS_AS_STRING_PARSER.declareString(constructorArg(), new ParseField(Fields.LOWER));
                return stdDeviationBoundUpper;
                builder.field(Fields.STD_DEVIATION_AS_STRING, getStdDeviationAsString());
            ValueType.DOUBLE_OR_NULL
            new ParseField(Fields.STD_DEVIATION_AS_STRING)
            {
            new ParseField(Fields.STD_DEVIATION_BOUNDS_AS_STRING)
    }
    public double getVariance() {
            (agg, value) -> agg.valueAsString.put(Fields.STD_DEVIATION_AS_STRING, value),
    );
        this.valueAsString.put(Fields.STD_DEVIATION_BOUNDS_AS_STRING + "_upper", boundsAsString.get(0));
        );
                );
            new ParseField(Fields.VARIANCE_POPULATION_AS_STRING)
            builder.nullField(Fields.VARIANCE);
            builder.nullField(Fields.VARIANCE_POPULATION);
    }
        args -> Arrays.stream(args).map(d -> (Double) d).collect(Collectors.toList())
    }
    @Override
    }
            new ParseField(Fields.VARIANCE_AS_STRING)
        return stdDeviationSampling;
        STD_BOUNDS_PARSER.declareField(
            new ParseField(Fields.LOWER_POPULATION),
            case LOWER_POPULATION:
            ParsedExtendedStats::setStdDeviationBoundsAsString,
        return valueAsString.getOrDefault(Fields.VARIANCE_SAMPLING_AS_STRING, Double.toString(varianceSampling));
 * The OpenSearch Contributors require contributions made to
                builder.field(Fields.LOWER_SAMPLING, getStdDeviationBound(Bounds.LOWER_SAMPLING));
    @Override
 * software distributed under the License is distributed on an
    }
        );
    }
        }
                return valueAsString.getOrDefault(
        return stdDeviationPopulation;
    public double getVariancePopulation() {
            (parser, context) -> parseDouble(parser, 0),
                builder.field(Fields.LOWER_POPULATION, getStdDeviationBound(Bounds.LOWER_POPULATION));
        }
    public double getSumOfSquares() {
                builder.nullField(Fields.UPPER_POPULATION);
    }
            new ParseField(Fields.LOWER),
    }
