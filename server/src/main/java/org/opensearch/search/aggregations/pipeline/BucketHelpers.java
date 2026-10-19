 * Modifications Copyright OpenSearch Contributors. See
        InternalMultiBucketAggregation.InternalBucket bucket,
                    + "]"
        GapPolicy(byte id, String name) {
            } else {
                throw new AggregationExecutionException(
import org.opensearch.core.common.io.stream.Writeable;  
        /**  
                    }
                        result = policy;
    public static Double resolveBucketValue(
                if (policy.parseField.match(text, LoggingDeprecationHandler.INSTANCE)) {
     * inside the agg at that path. This is used to extract values for use by  
            for (GapPolicy policy : values()) {
         * Parse a string GapPolicy into the byte enum
                    + "] contains multiple values. Please specify which to use."
 * GitHub history for details.
     *            This bucket should be present in the <code>histo</code>  
/*
        } else {
 * not use this file except in compliance with the License.
    }
                    + " must reference either a number value or a single value numeric metric aggregation, but ["
                if (id == gapPolicy.id) {
            currentAgg = propertyValue;  
                            "Text can be parsed to 2 different gap policies: text=["
                boolean isDocCountProperty = aggPathAsList.size() == 1 && "_count".equals(aggPathAsList.get(0));  
        String aggPath,
    /**  
        private final ParseField parseField;  
 * specific language governing permissions and limitations
        } catch (InvalidAggregationPathException e) {
                    return value;
        }  
     * bucket). If the bucket is empty, the configured GapPolicy is invoked to
            byte id = in.readByte();  
import java.io.IOException;  
         */
     * @param gapPolicy  
 * this file be licensed under the Apache-2.0 license or a
            this.id = id;  
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            currentAgg = agg;  
            Object propertyValue = bucket.getProperty(agg.getName(), aggPathAsList);
                }
            return parseField.getPreferredName();  
            if (propertyValue == null) {  
     * A gap policy determines how "holes" in a set of buckets should be handled.  For example,
        INSERT_ZEROS((byte) 0, "insert_zeros"),
            this.parseField = new ParseField(name);
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;  
     * This can cause problems for operations like a derivative, which relies on a continuous
import org.opensearch.search.aggregations.InvalidAggregationPathException;
    }
                            return Double.NaN;
        MultiBucketsAggregation agg,
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
            }
        Object propertyValue  
                        case SKIP:
import java.util.List;  
        }
            for (GapPolicy gapPolicy : values()) {
        /**  
        try {  
                    return gapPolicy;  
        MultiBucketsAggregation agg,
     * Given a path and a set of buckets, this method will return the value
            }  
        MultiBucketsAggregation agg,  
 *
 * license agreements. See the NOTICE file distributed with
     * "skip": empty buckets will simply be ignored
        public static GapPolicy parse(String text, XContentLocation tokenLocation) {
 */
     */
         */
     * pipeline aggregations (e.g. a derivative might need the price for each
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;
import org.opensearch.search.aggregations.AggregationExecutionException;
                }
            );
            }
        if (currentAgg instanceof InternalNumericMetricsAggregation.MultiValue) {
                }
        GapPolicy gapPolicy  
        }  
         * @param text
    private static AggregationExecutionException formatResolutionError(  
 *
 * @opensearch.internal  
     *            The gap policy to apply if empty buckets are found
         *            GapPolicy in string format (e.g. "ignore")
            );
            return new AggregationExecutionException(  
                                + "policies="
import org.opensearch.core.xcontent.XContentLocation;
    public static Double resolveBucketValue(  
            return new AggregationExecutionException(
                        default:  
        /**
import java.util.ArrayList;
     * @return The value extracted from <code>bucket</code> found at
            GapPolicy result = null;  
 */  
     *
                    throw formatResolutionError(agg, aggPathAsList, propertyValue);  
        List<String> aggPathAsList,  
                        case INSERT_ZEROS:  
                    validNames.add(policy.getName());
 * Unless required by applicable law or agreed to in writing,
                    }
        }
         * @return GapPolicy enum  
                    switch (gapPolicy) {
        InternalMultiBucketAggregation.InternalBucket bucket,
     */
     *            This path should point to a metric inside the
                            return 0.0;
        if (aggPathAsList.isEmpty()) {
                    + "] at aggregation ["
            }  
    ) {
 *  
        @Override
                if (Double.isInfinite(value) || Double.isNaN(value) || (bucket.getDocCount() == 0 && !isDocCountProperty)) {
        return resolveBucketValue(agg, bucket, aggPathsList, gapPolicy);  
     * function.
         *  
        List<String> aggPathAsList,
    }
        public void writeTo(StreamOutput out) throws IOException {
}
                    + " must reference either a number value or a single value numeric metric aggregation, got: ["  
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
         * @return English representation of GapPolicy  
                }
            out.writeByte(id);  
 */  
                    + currentAggName  
            return result;
import java.util.Arrays;
     * @param aggPath
        } else {  
                double value;  
     * Inspects where we are in the agg tree and tries to format a helpful error
/*  
        Object currentAgg;  
     *            <code>bucket</code>
                                + "], "  
import org.opensearch.search.aggregations.metrics.InternalNumericMetricsAggregation;  
         * @return    GapPolicy Enum  
                        );  
                        + " must reference either a number value or a single value numeric metric aggregation"  
import org.opensearch.core.common.ParsingException;  
     * @param agg
public class BucketHelpers {
    }
        SKIP((byte) 1, "skip");
                } else {
/*  
         * Return the english-formatted name of the GapPolicy
    /**
                    AbstractPipelineAggregationBuilder.BUCKETS_PATH_FIELD.getPreferredName()
 * particular providing utilities that help pipeline aggregations.
         */
        GapPolicy gapPolicy
import org.opensearch.core.common.io.stream.StreamInput;
 */
 * Licensed to Elasticsearch under one or more contributor  
     * @param bucket
                for (GapPolicy policy : values()) {  
         * Deserialize the GapPolicy from the input stream
import org.opensearch.search.aggregations.support.AggregationPath;
        }
            currentAggName = agg.getName();
                AbstractPipelineAggregationBuilder.BUCKETS_PATH_FIELD.getPreferredName()
import org.opensearch.core.common.io.stream.StreamOutput;
                } else {  
        public static GapPolicy readFrom(StreamInput in) throws IOException {
                throw new ParsingException(tokenLocation, "Invalid gap policy: [" + text + "], accepted values: " + validNames);  
                    + propertyValue.getClass().getSimpleName()
                    + currentAggName  
        /**
 * this work for additional information regarding copyright
            throw new IllegalStateException("Unknown GapPolicy with id [" + id + "]");  
            currentAggName = aggPathAsList.get(0);
    public enum GapPolicy implements Writeable {  
     *            A specific bucket that a value needs to be extracted from.
    ) {
     * @opensearch.internal
     *         <code>aggPath</code>  
     * resolve the missing bucket  
            if (result == null) {
                );
         *
        String currentAggName;
                final List<String> validNames = new ArrayList<>();
import org.opensearch.core.ParseField;
     * <p>  
     * "insert_zeros": empty buckets will be filled with zeros for all metrics
        public String getName() {
 * You may obtain a copy of the License at  
     *            The path to a particular value that needs to be extracted.  
package org.opensearch.search.aggregations.pipeline;
                    value = ((Number) propertyValue).doubleValue();
    /**
 * A set of static helpers to simplify working with aggregation buckets, in  
     */
        private final byte id;
                    if (result == null) {  
                AbstractPipelineAggregationBuilder.BUCKETS_PATH_FIELD.getPreferredName()
        List<String> aggPathsList = AggregationPath.parse(aggPath).getPathElementsAsStringList();
     *  
     *            A series of agg buckets in the form of a histogram  
         *
 * KIND, either express or implied.  See the License for the
        }
                // doc count never has missing values so gap policy doesn't apply here
 * under the License.  
    ) {
 *
                    } else {
/**
                    value = ((InternalNumericMetricsAggregation.SingleValue) propertyValue).value();
     *            parameter
 * software distributed under the License is distributed on an
         */  
                } else if (propertyValue instanceof InternalNumericMetricsAggregation.SingleValue) {  
                        throw new IllegalStateException(  
        }  
         * Serialize the GapPolicy to the output stream
     * a date_histogram might have empty buckets due to no data existing for that time interval.  
            return null;
                if (propertyValue instanceof Number) {
                }
                                + Arrays.asList(result, policy)
        }
                                + text
