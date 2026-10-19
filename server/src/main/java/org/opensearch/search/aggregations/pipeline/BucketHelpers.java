 * ownership. Elasticsearch licenses this file to you under
     * @param agg
}
            return new AggregationExecutionException(
                    } else {
            }
        MultiBucketsAggregation agg,
         * @return English representation of GapPolicy
         */
        return resolveBucketValue(agg, bucket, aggPathsList, gapPolicy);
                    throw formatResolutionError(agg, aggPathAsList, propertyValue);
        /**
/*
        private final ParseField parseField;
            for (GapPolicy policy : values()) {
 * A set of static helpers to simplify working with aggregation buckets, in
     * A gap policy determines how "holes" in a set of buckets should be handled.  For example,
 * compatible open source license.
         *
            currentAgg = agg;
     * function.
                                + "policies="
        }
        }
                }
                double value;
        private final byte id;
                            return 0.0;
        }
     *
        public void writeTo(StreamOutput out) throws IOException {
     *            parameter
public class BucketHelpers {
     * @param gapPolicy
                            "Text can be parsed to 2 different gap policies: text=["
 * the Apache License, Version 2.0 (the "License"); you may
        /**
                    validNames.add(policy.getName());
            );
     * Given a path and a set of buckets, this method will return the value
     * a date_histogram might have empty buckets due to no data existing for that time interval.
            }
        try {
 * specific language governing permissions and limitations
                    if (result == null) {
     * bucket). If the bucket is empty, the configured GapPolicy is invoked to
        InternalMultiBucketAggregation.InternalBucket bucket,
/*
        }
    }
                                + "], "
                if (policy.parseField.match(text, LoggingDeprecationHandler.INSTANCE)) {
     *            This path should point to a metric inside the
                for (GapPolicy policy : values()) {
    public enum GapPolicy implements Writeable {
     *         <code>aggPath</code>
            return new AggregationExecutionException(
         */
    /**
        List<String> aggPathsList = AggregationPath.parse(aggPath).getPathElementsAsStringList();
                // doc count never has missing values so gap policy doesn't apply here
                    + currentAggName
import java.util.Arrays;
        } else {
 * Modifications Copyright OpenSearch Contributors. See
        GapPolicy gapPolicy
        if (currentAgg instanceof InternalNumericMetricsAggregation.MultiValue) {
    ) {
                        default:
        }
                        case INSERT_ZEROS:
         * @return GapPolicy enum
 * Unless required by applicable law or agreed to in writing,
 *
        List<String> aggPathAsList,
            return result;
    }
            GapPolicy result = null;
                    + propertyValue.getClass().getSimpleName()
        MultiBucketsAggregation agg,
         */
                            return Double.NaN;
         *
            this.parseField = new ParseField(name);
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;
 *
        } catch (InvalidAggregationPathException e) {
 * not use this file except in compliance with the License.
                    return gapPolicy;
                    value = ((InternalNumericMetricsAggregation.SingleValue) propertyValue).value();
 * under the License.
 * software distributed under the License is distributed on an
        /**
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
import org.opensearch.core.common.io.stream.Writeable;
 * SPDX-License-Identifier: Apache-2.0
                }
/**
        MultiBucketsAggregation agg,
         * @param text
import java.io.IOException;
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
                                + text
            currentAggName = aggPathAsList.get(0);
                }
 * particular providing utilities that help pipeline aggregations.
                AbstractPipelineAggregationBuilder.BUCKETS_PATH_FIELD.getPreferredName()
    }
     */
 * this file be licensed under the Apache-2.0 license or a
                    + "] contains multiple values. Please specify which to use."
         */
     * @param bucket
import org.opensearch.search.aggregations.support.AggregationPath;
            if (result == null) {
                                + Arrays.asList(result, policy)
        Object propertyValue
         * Return the english-formatted name of the GapPolicy
                    return value;
import java.util.ArrayList;
 *    http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.search.aggregations.pipeline;
 * GitHub history for details.
                    value = ((Number) propertyValue).doubleValue();
                    AbstractPipelineAggregationBuilder.BUCKETS_PATH_FIELD.getPreferredName()
    public static Double resolveBucketValue(
        if (aggPathAsList.isEmpty()) {
/*
                    switch (gapPolicy) {
 * The OpenSearch Contributors require contributions made to
     * <p>
                    }
                    + "]"
            }
         * Deserialize the GapPolicy from the input stream
 */
        Object currentAgg;
            return parseField.getPreferredName();
                } else if (propertyValue instanceof InternalNumericMetricsAggregation.SingleValue) {
        List<String> aggPathAsList,
                    }
            out.writeByte(id);
        }
                }
                    + currentAggName
import org.opensearch.core.common.ParsingException;
            byte id = in.readByte();
            if (propertyValue == null) {
            } else {
        INSERT_ZEROS((byte) 0, "insert_zeros"),
            return null;
 */
     *            <code>bucket</code>
import org.opensearch.core.xcontent.XContentLocation;
                        throw new IllegalStateException(
     * Inspects where we are in the agg tree and tries to format a helpful error
                        + " must reference either a number value or a single value numeric metric aggregation"
         *            GapPolicy in string format (e.g. "ignore")
    }
         * Parse a string GapPolicy into the byte enum
                throw new AggregationExecutionException(
                        result = policy;
import org.opensearch.core.common.io.stream.StreamInput;
        public static GapPolicy readFrom(StreamInput in) throws IOException {
        public static GapPolicy parse(String text, XContentLocation tokenLocation) {
         *
                if (Double.isInfinite(value) || Double.isNaN(value) || (bucket.getDocCount() == 0 && !isDocCountProperty)) {
            }
    /**
     *
import org.opensearch.search.aggregations.AggregationExecutionException;
            currentAggName = agg.getName();
     *            The gap policy to apply if empty buckets are found
    private static AggregationExecutionException formatResolutionError(
                );
import java.util.List;
 * KIND, either express or implied.  See the License for the
        GapPolicy gapPolicy
import org.opensearch.search.aggregations.metrics.InternalNumericMetricsAggregation;
import org.opensearch.core.ParseField;
        @Override
     * This can cause problems for operations like a derivative, which relies on a continuous
                    + " must reference either a number value or a single value numeric metric aggregation, got: ["
     */
     * @param aggPath
 * You may obtain a copy of the License at
        public String getName() {
                final List<String> validNames = new ArrayList<>();
     *            A series of agg buckets in the form of a histogram
    ) {
        /**
 * Licensed to Elasticsearch under one or more contributor
                if (propertyValue instanceof Number) {
        } else {
 * license agreements. See the NOTICE file distributed with
            throw new IllegalStateException("Unknown GapPolicy with id [" + id + "]");
        SKIP((byte) 1, "skip");
     * @opensearch.internal
 */
import org.opensearch.core.common.io.stream.StreamOutput;
                        );
     *            The path to a particular value that needs to be extracted.
                        case SKIP:
     * inside the agg at that path. This is used to extract values for use by
        String currentAggName;
                throw new ParsingException(tokenLocation, "Invalid gap policy: [" + text + "], accepted values: " + validNames);
            for (GapPolicy gapPolicy : values()) {
         * @return    GapPolicy Enum
        String aggPath,
import org.opensearch.search.aggregations.InvalidAggregationPathException;
                if (id == gapPolicy.id) {
 * @opensearch.internal
 */
                    + " must reference either a number value or a single value numeric metric aggregation, but ["
                AbstractPipelineAggregationBuilder.BUCKETS_PATH_FIELD.getPreferredName()
    ) {
                }
        }
 *
                } else {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            );
     * resolve the missing bucket
                } else {
         * Serialize the GapPolicy to the output stream
     *            This bucket should be present in the <code>histo</code>
 * this work for additional information regarding copyright
                    + "] at aggregation ["
        InternalMultiBucketAggregation.InternalBucket bucket,
        }
     * @return The value extracted from <code>bucket</code> found at
    /**
     * "insert_zeros": empty buckets will be filled with zeros for all metrics
     * pipeline aggregations (e.g. a derivative might need the price for each
            Object propertyValue = bucket.getProperty(agg.getName(), aggPathAsList);
     *            A specific bucket that a value needs to be extracted from.
            this.id = id;
     * "skip": empty buckets will simply be ignored
    public static Double resolveBucketValue(
            currentAgg = propertyValue;
 *
                boolean isDocCountProperty = aggPathAsList.size() == 1 && "_count".equals(aggPathAsList.get(0));
        GapPolicy(byte id, String name) {
     */
