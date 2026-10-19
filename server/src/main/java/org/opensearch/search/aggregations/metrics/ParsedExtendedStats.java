    }  
                builder.endObject();  
            ValueType.DOUBLE_OR_NULL
            (parser, context) -> parseDouble(parser, 0),  
        objectParser.declareField(
    }
    }
            new ParseField(Fields.SUM_OF_SQRS_AS_STRING)
        );
            this.valueAsString.put(Fields.STD_DEVIATION_BOUNDS_AS_STRING + "_lower_population", boundsAsString.get(3));  
            ParsedExtendedStats::setStdDeviationBoundsAsString,
        );
import org.opensearch.core.xcontent.ConstructingObjectParser;
    }
            case UPPER_POPULATION:  
            new ParseField(Fields.STD_DEVIATION_POPULATION),
    private void setStdDeviationBoundsAsString(List<String> boundsAsString) {
    protected double variance;
    @Override
        STD_BOUNDS_AS_STRING_PARSER.declareString(constructorArg(), new ParseField(Fields.UPPER));
        objectParser.declareObject(
                    Fields.STD_DEVIATION_BOUNDS_AS_STRING + "_upper",  
            STD_BOUNDS_PARSER,  
        objectParser.declareString(  
    @Override  
 */  
        STD_BOUNDS_PARSER.declareField(
        return valueAsString.getOrDefault(Fields.VARIANCE_AS_STRING, Double.toString(variance));
                    Fields.STD_DEVIATION_BOUNDS_AS_STRING + "_upper_population",
    }
        objectParser.declareField(
import java.util.stream.Collectors;  
            this.valueAsString.put(Fields.STD_DEVIATION_BOUNDS_AS_STRING + "_upper_sampling", boundsAsString.get(4));  
            (parser, context) -> parseDouble(parser, 0),  
            ValueType.DOUBLE_OR_NULL
    public String getStdDeviationSamplingAsString() {  
    static {  
                builder.nullField(Fields.UPPER_POPULATION);
                builder.field(Fields.SUM_OF_SQRS_AS_STRING, getSumOfSquaresAsString());
            new ParseField(Fields.STD_DEVIATION_SAMPLING),
    }
            (agg, value) -> agg.valueAsString.put(Fields.SUM_OF_SQRS_AS_STRING, value),
        return varianceSampling;  
        switch (bound) {
            new ParseField(Fields.LOWER_POPULATION),
    public String getStdDeviationPopulationAsString() {
        STD_BOUNDS_PARSER.declareField(
        return valueAsString.getOrDefault(Fields.VARIANCE_SAMPLING_AS_STRING, Double.toString(varianceSampling));
        return stdDeviationPopulation;
/*  
import org.opensearch.search.aggregations.metrics.InternalExtendedStats.Fields;
        STD_BOUNDS_PARSER.declareField(
    public String getVarianceAsString() {  
    }
            case UPPER:  
import java.io.IOException;  
    }
    public String getStdDeviationAsString() {
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;  
    }
        ParsedExtendedStats.class.getSimpleName() + "_STD_BOUNDS_AS_STRING",
                );
    public String getVariancePopulationAsString() {
 */
    @Override  
            (parser, context) -> parseDouble(parser, 0),  
        );  
            ValueType.DOUBLE_OR_NULL
        ParsedExtendedStats.class.getSimpleName() + "_STD_BOUNDS",
 * compatible open source license.
        );
    protected double avg;  
            new ParseField(Fields.STD_DEVIATION),
    public String getStdDeviationBoundAsString(Bounds bound) {
                    builder.field(Fields.LOWER_SAMPLING, getStdDeviationBoundAsString(Bounds.LOWER_SAMPLING));
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
                );
    @Override  
        this.stdDeviationBoundLower = bounds.get(1);
        );
    );
/*
    }
        return valueAsString.getOrDefault(Fields.STD_DEVIATION_POPULATION_AS_STRING, Double.toString(stdDeviationPopulation));
        return valueAsString.getOrDefault(Fields.STD_DEVIATION_SAMPLING_AS_STRING, Double.toString(stdDeviationSampling));
    }  
        this.stdDeviationBoundUpper = bounds.get(0);
        );  
                );
        ParsedExtendedStats parsedStats = PARSER.apply(parser, null);  
    protected double stdDeviationBoundLower;
    }
            new ParseField(Fields.STD_DEVIATION_BOUNDS)
        objectParser.declareField(
    @Override
/*  
                return valueAsString.getOrDefault(  
            builder.field(Fields.STD_DEVIATION, getStdDeviation());  
            case LOWER_SAMPLING:
            ValueType.DOUBLE_OR_NULL
                throw new IllegalArgumentException("Unknown bounds type " + bound);
                builder.nullField(Fields.UPPER_SAMPLING);
            this.valueAsString.put(Fields.STD_DEVIATION_BOUNDS_AS_STRING + "_upper_population", boundsAsString.get(2));  
 * KIND, either express or implied.  See the License for the
            case UPPER_SAMPLING:
    public double getStdDeviationSampling() {
            ValueType.DOUBLE_OR_NULL
        args -> Arrays.stream(args).map(d -> (Double) d).collect(Collectors.toList())  
        parsedStats.setName(name);
            (agg, value) -> agg.valueAsString.put(Fields.VARIANCE_AS_STRING, value),
 * the Apache License, Version 2.0 (the "License"); you may
            new ParseField(Fields.STD_DEVIATION_SAMPLING_AS_STRING)
 * An extended stats agg result parsed between nodes  
        if (boundsAsString.get(4) != null) {
                builder.nullField(Fields.LOWER_POPULATION);  
 *
            if (valueAsString.containsKey(Fields.SUM_OF_SQRS_AS_STRING)) {
                return stdDeviationBoundLower;
            default:  
        this.stdDeviationBoundLowerSampling = bounds.get(5) == null ? 0 : bounds.get(5);  
            new ParseField(Fields.VARIANCE_SAMPLING_AS_STRING)
            ValueType.DOUBLE_OR_NULL
    }  
                return stdDeviationBoundUpperSampling;
 * The OpenSearch Contributors require contributions made to  
            constructorArg(),
        objectParser.declareObject(
    );
        objectParser.declareField(
            {
            builder.nullField(Fields.STD_DEVIATION_POPULATION);
            case UPPER_SAMPLING:
            builder.field(Fields.VARIANCE_POPULATION, getVariancePopulation());
            }  
    public double getStdDeviationBound(Bounds bound) {
 * not use this file except in compliance with the License.
            this.valueAsString.put(Fields.STD_DEVIATION_BOUNDS_AS_STRING + "_lower_sampling", boundsAsString.get(5));  
            (agg, value) -> agg.valueAsString.put(Fields.VARIANCE_POPULATION_AS_STRING, value),  
            optionalConstructorArg(),
        true,
    @Override
    public static ParsedExtendedStats fromXContent(XContentParser parser, final String name) {
            case UPPER_POPULATION:
    protected double stdDeviationBoundUpperSampling;
    protected double stdDeviationSampling;  
            (parser, context) -> parseDouble(parser, 0),  
            {
    }
 */  
    protected double sum;
 *     http://www.apache.org/licenses/LICENSE-2.0
        return parsedStats;
            STD_BOUNDS_AS_STRING_PARSER,  
 * Unless required by applicable law or agreed to in writing,
    );
/**
    protected static void declareExtendedStatsFields(ObjectParser<? extends ParsedExtendedStats, Void> objectParser) {
        if (count != 0) {
        STD_BOUNDS_AS_STRING_PARSER.declareString(optionalConstructorArg(), new ParseField(Fields.UPPER_POPULATION));  
            optionalConstructorArg(),
 *
            (agg, value) -> agg.valueAsString.put(Fields.STD_DEVIATION_AS_STRING, value),
            new ParseField(Fields.VARIANCE),
package org.opensearch.search.aggregations.metrics;
        );  
        );  
    private static final ConstructingObjectParser<List<String>, Void> STD_BOUNDS_AS_STRING_PARSER = new ConstructingObjectParser<>(  
        this.stdDeviationBoundUpperPopulation = bounds.get(2) == null ? 0 : bounds.get(2);  
                builder.startObject(Fields.STD_DEVIATION_BOUNDS_AS_STRING);  
        objectParser.declareField(
            (parser, context) -> parseDouble(parser, 0),  
                return valueAsString.getOrDefault(
    }  
 * Modifications Copyright OpenSearch Contributors. See
    public double getSumOfSquares() {
 * GitHub history for details.
                );
            builder.endObject();  
            }
        return stdDeviationSampling;  
 * Licensed to Elasticsearch under one or more contributor  
    @Override
        return ExtendedStatsAggregationBuilder.NAME;
    }  
        STD_BOUNDS_PARSER.declareField(
        objectParser.declareString(
                builder.field(Fields.STD_DEVIATION_AS_STRING, getStdDeviationAsString());  
    }
        return variancePopulation;
        STD_BOUNDS_AS_STRING_PARSER.declareString(optionalConstructorArg(), new ParseField(Fields.LOWER_POPULATION));
        }
        return variance;
            (parser, context) -> parseDouble(parser, 0),  
                builder.field(Fields.VARIANCE_SAMPLING_AS_STRING, getVarianceSamplingAsString());
            ValueType.DOUBLE_OR_NULL
        objectParser.declareString(
    }  
            builder.field(Fields.VARIANCE, getVariance());  
                builder.field(Fields.UPPER, getStdDeviationBound(Bounds.UPPER));
        return stdDeviation;
        declareAggregationFields(objectParser);
                return stdDeviationBoundUpper;
            new ParseField(Fields.UPPER_POPULATION),
        true,
                return stdDeviationBoundLowerSampling;
            new ParseField(Fields.STD_DEVIATION_BOUNDS_AS_STRING)
        objectParser.declareString(
    public double getStdDeviationPopulation() {  
            new ParseField(Fields.VARIANCE_AS_STRING)  
            ValueType.DOUBLE_OR_NULL
            (agg, value) -> agg.varianceSampling = value,
        } else {
                {
            case UPPER:
                builder.nullField(Fields.UPPER);  
        objectParser.declareField(
                    Double.toString(stdDeviationBoundUpperSampling)
    }
    private void setStdDeviationBounds(List<Double> bounds) {  
        STD_BOUNDS_PARSER.declareField(
    }
        objectParser.declareString(  
                return stdDeviationBoundUpperPopulation;  
            builder.nullField(Fields.VARIANCE_SAMPLING);  
    public String getSumOfSquaresAsString() {
            new ParseField(Fields.SUM_OF_SQRS),
        );  
        return valueAsString.getOrDefault(Fields.STD_DEVIATION_AS_STRING, Double.toString(stdDeviation));  
 * @opensearch.internal
            case LOWER:  
                builder.field(Fields.VARIANCE_AS_STRING, getVarianceAsString());  
            (agg, value) -> agg.valueAsString.put(Fields.VARIANCE_SAMPLING_AS_STRING, value),
            (agg, value) -> agg.stdDeviationSampling = value,
            (parser, context) -> parseDouble(parser, 0),  
            builder.nullField(Fields.STD_DEVIATION_SAMPLING);  
                }
import java.util.List;
        STD_BOUNDS_AS_STRING_PARSER.declareString(constructorArg(), new ParseField(Fields.LOWER));
        );  
                builder.field(Fields.LOWER_POPULATION, getStdDeviationBound(Bounds.LOWER_POPULATION));
            builder.nullField(Fields.STD_DEVIATION);
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
            ValueType.DOUBLE_OR_NULL
 *
import org.opensearch.core.xcontent.XContentBuilder;
    protected double stdDeviationBoundUpperPopulation;  
    public double getVarianceSampling() {
    @Override  
            ValueType.DOUBLE_OR_NULL
            new ParseField(Fields.STD_DEVIATION_AS_STRING)  
        );  
    @Override  
        STD_BOUNDS_PARSER.declareField(
        }  
                    Fields.STD_DEVIATION_BOUNDS_AS_STRING + "_lower_sampling",
        declareExtendedStatsFields(PARSER);
            builder.field(Fields.STD_DEVIATION_SAMPLING, getStdDeviationSampling());
            ValueType.DOUBLE_OR_NULL
            ValueType.DOUBLE_OR_NULL
    private static final ObjectParser<ParsedExtendedStats, Void> PARSER = new ObjectParser<>(  
            (agg, value) -> agg.valueAsString.put(Fields.STD_DEVIATION_SAMPLING_AS_STRING, value),
    protected XContentBuilder otherStatsToXContent(XContentBuilder builder, Params params) throws IOException {  
                    builder.field(Fields.UPPER_SAMPLING, getStdDeviationBoundAsString(Bounds.UPPER_SAMPLING));  
        return valueAsString.getOrDefault(Fields.SUM_OF_SQRS_AS_STRING, Double.toString(sumOfSquares));
        );  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        );  
        }
    @Override
            builder.field(Fields.SUM_OF_SQRS, sumOfSquares);
        if (boundsAsString.get(5) != null) {
    @Override
        if (boundsAsString.get(3) != null) {
            default:
                return valueAsString.getOrDefault(
    protected double stdDeviationBoundUpper;
                    Fields.STD_DEVIATION_BOUNDS_AS_STRING + "_lower",  
            new ParseField(Fields.VARIANCE_POPULATION),
            builder.startObject(Fields.STD_DEVIATION_BOUNDS);  
            new ParseField(Fields.LOWER_SAMPLING),
        );
            new ParseField(Fields.VARIANCE_POPULATION_AS_STRING)
            builder.field(Fields.STD_DEVIATION_POPULATION, getStdDeviationPopulation());
        return builder;  
    @Override
    }  
    }  
    protected double sumOfSquares;  
            (parser, context) -> parseDouble(parser, 0),  
            (parser, context) -> parseDouble(parser, 0),  
            case LOWER_SAMPLING:
 * You may obtain a copy of the License at  
                    Fields.STD_DEVIATION_BOUNDS_AS_STRING + "_lower_population",
    @Override
    protected double varianceSampling;  
        this.valueAsString.put(Fields.STD_DEVIATION_BOUNDS_AS_STRING + "_upper", boundsAsString.get(0));  
            new ParseField(Fields.UPPER),
        );  
        }
            new ParseField(Fields.STD_DEVIATION_POPULATION_AS_STRING)
        }
            (parser, context) -> parseDouble(parser, 0),  
            ParsedExtendedStats::setStdDeviationBounds,
    @Override
                builder.nullField(Fields.LOWER_SAMPLING);
        STD_BOUNDS_AS_STRING_PARSER.declareString(optionalConstructorArg(), new ParseField(Fields.UPPER_SAMPLING));
                builder.nullField(Fields.LOWER);
            optionalConstructorArg(),
        );  
            (parser, context) -> parseDouble(parser, 0),  
            builder.startObject(Fields.STD_DEVIATION_BOUNDS);
            case LOWER_POPULATION:  
            builder.field(Fields.VARIANCE_SAMPLING, getVarianceSampling());
            optionalConstructorArg(),
    protected double stdDeviationBoundLowerSampling;  
                builder.field(Fields.LOWER, getStdDeviationBound(Bounds.LOWER));  
            case LOWER:
                    builder.field(Fields.UPPER_POPULATION, getStdDeviationBoundAsString(Bounds.UPPER_POPULATION));
        objectParser.declareString(
 * SPDX-License-Identifier: Apache-2.0
                builder.field(Fields.STD_DEVIATION_SAMPLING_AS_STRING, getStdDeviationSamplingAsString());
                    builder.field(Fields.LOWER, getStdDeviationBoundAsString(Bounds.LOWER));  
        switch (bound) {  
import org.opensearch.core.xcontent.ObjectParser;  
        this.stdDeviationBoundUpperSampling = bounds.get(4) == null ? 0 : bounds.get(4);
            builder.nullField(Fields.SUM_OF_SQRS);  
                );  
}
import org.opensearch.core.ParseField;
                builder.field(Fields.UPPER_POPULATION, getStdDeviationBound(Bounds.UPPER_POPULATION));
        objectParser.declareString(  
        );  
    protected double stdDeviation;
                throw new IllegalArgumentException("Unknown bounds type " + bound);
                    Double.toString(stdDeviationBoundLowerSampling)
            (parser, context) -> parseDouble(parser, 0),  
            case LOWER_POPULATION:
        return valueAsString.getOrDefault(Fields.VARIANCE_POPULATION_AS_STRING, Double.toString(variancePopulation));  
        );  
    private static final ConstructingObjectParser<List<Double>, Void> STD_BOUNDS_PARSER = new ConstructingObjectParser<>(  
        }
            (agg, value) -> agg.sumOfSquares = value,
                builder.field(Fields.UPPER_SAMPLING, getStdDeviationBound(Bounds.UPPER_SAMPLING));  
        STD_BOUNDS_AS_STRING_PARSER.declareString(optionalConstructorArg(), new ParseField(Fields.LOWER_SAMPLING));  
public class ParsedExtendedStats extends ParsedStats implements ExtendedStats {
        ParsedExtendedStats::new  
import org.opensearch.core.xcontent.ObjectParser.ValueType;
        if (boundsAsString.get(2) != null) {
                    builder.field(Fields.LOWER_POPULATION, getStdDeviationBoundAsString(Bounds.LOWER_POPULATION));
 * this file be licensed under the Apache-2.0 license or a
        declareStatsFields(objectParser);  
        return sumOfSquares;  
    @Override
 */  
                return valueAsString.getOrDefault(  
        );  
                builder.field(Fields.LOWER_SAMPLING, getStdDeviationBound(Bounds.LOWER_SAMPLING));
        this.stdDeviationBoundLowerPopulation = bounds.get(3) == null ? 0 : bounds.get(3);
            constructorArg(),
                    builder.field(Fields.UPPER, getStdDeviationBoundAsString(Bounds.UPPER));
 * this work for additional information regarding copyright
                return valueAsString.getOrDefault(
            (agg, value) -> agg.variancePopulation = value,
            builder.endObject();
                builder.field(Fields.STD_DEVIATION_POPULATION_AS_STRING, getStdDeviationPopulationAsString());
        this.valueAsString.put(Fields.STD_DEVIATION_BOUNDS_AS_STRING + "_lower", boundsAsString.get(1));
            builder.nullField(Fields.VARIANCE_POPULATION);
                    Double.toString(stdDeviationBoundLowerPopulation)  
import java.util.Arrays;
            (agg, value) -> agg.valueAsString.put(Fields.STD_DEVIATION_POPULATION_AS_STRING, value),  
            (agg, value) -> agg.variance = value,
        );  
            (agg, value) -> agg.stdDeviationPopulation = value,
            builder.nullField(Fields.VARIANCE);
    public String getVarianceSamplingAsString() {
                );  
                    Double.toString(stdDeviationBoundLower)
        );  
                return stdDeviationBoundLowerPopulation;  
    protected double stdDeviationBoundLowerPopulation;
        args -> Arrays.stream(args).map(d -> (String) d).collect(Collectors.toList())  
    protected double variancePopulation;
 * under the License.  
    public String getType() {  
import org.opensearch.core.xcontent.XContentParser;  
 * software distributed under the License is distributed on an
                    Fields.STD_DEVIATION_BOUNDS_AS_STRING + "_upper_sampling",
    @Override  
        true,
    public double getVariancePopulation() {  
            (parser, context) -> parseDouble(parser, 0),  
                return valueAsString.getOrDefault(
            }
    public double getVariance() {
    public double getStdDeviation() {
        ParsedExtendedStats.class.getSimpleName(),
            new ParseField(Fields.VARIANCE_SAMPLING),
            ValueType.DOUBLE_OR_NULL
 *  
                    Double.toString(stdDeviationBoundUpper)
                builder.field(Fields.VARIANCE_POPULATION_AS_STRING, getVariancePopulationAsString());
    protected double stdDeviationPopulation;
        );
        objectParser.declareField(
    @Override
            new ParseField(Fields.UPPER_SAMPLING),
        }
                    Double.toString(stdDeviationBoundUpperPopulation)  
            new ParseField(Fields.LOWER),
            (agg, value) -> agg.stdDeviation = value,
 * ownership. Elasticsearch licenses this file to you under  
    }
    @Override
