    @Override
        }
            builder.field(MovAvgPipelineAggregationBuilder.MODEL.getPreferredName(), NAME);  
 */
    protected double[] doPredict(Collection<Double> values, int numPredictions) {  
/*  
    @Override  
     */
            checkUnrecognizedParams(settings);
        public MovAvgModel build() {
 * The OpenSearch Contributors require contributions made to  
        return builder;
    public int hashCode() {
        @Override
        // EWMA just emits the same final prediction repeatedly.  
    };
 * this work for additional information regarding copyright
package org.opensearch.search.aggregations.pipeline;
            return false;  
    public void writeTo(StreamOutput out) throws IOException {
    /**
     *  
    }
    @Override  
public class LinearModel extends MovAvgModel {  
     * Read from a stream.  
    @Override
 * @opensearch.internal
        @Override
    @Override
    public static class LinearModelBuilder implements MovAvgModelBuilder {  
    public boolean canBeMinimized() {  
            return false;  
 *
 */
    }
        builder.field(MovAvgPipelineAggregationBuilder.MODEL.getPreferredName(), NAME);
import org.opensearch.core.common.io.stream.StreamOutput;  
 * Modifications Copyright OpenSearch Contributors. See
/**  
import org.opensearch.common.Nullable;
    }  
    @Override
        return MovingFunctions.linearWeightedAvg(values.stream().mapToDouble(Double::doubleValue).toArray());
    }
    public MovAvgModel neighboringModel() {
 * this file be licensed under the Apache-2.0 license or a
    public static final AbstractModelParser PARSER = new AbstractModelParser() {
        return new LinearModel();  
        return false;
    }  
    public LinearModel() {}  
    @Override
    public double next(Collection<Double> values) {
    }
 *  
 * license agreements. See the NOTICE file distributed with
     * Builder for the linear model
        double[] predictions = new double[numPredictions];
import java.util.Map;
        return true;
    public boolean equals(Object obj) {
 * KIND, either express or implied.  See the License for the
    }
     * @opensearch.internal
    }  
        return predictions;  
        @Override  
/*
    }
import java.io.IOException;  
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
        }
            return new LinearModel();  
        }
    @Override
 * compatible open source license.
import java.util.Arrays;
    }  
    public static final String NAME = "linear";
import java.util.Collection;  
    /**
 * You may obtain a copy of the License at  
import java.text.ParseException;
 *
    public LinearModel(StreamInput in) {}
            return new LinearModel();  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
        }
    }  
 * linearly less important.  "Time" is determined by position in collection
        Arrays.fill(predictions, next(values));
 * GitHub history for details.
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        }
 * Licensed to Elasticsearch under one or more contributor  
        return NAME;
 *  
 * Calculate a linearly weighted moving average, such that older values are
        // No state to write  
 * specific language governing permissions and limitations
}
            return builder;
 * ownership. Elasticsearch licenses this file to you under  
     */
        public MovAvgModel parse(@Nullable Map<String, Object> settings, String pipelineName, int windowSize) throws ParseException {
        return 0;  
 * Unless required by applicable law or agreed to in writing,
    @Override  
/*  
        if (obj == null) {
    @Override  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 */  
        return new LinearModel();
        if (getClass() != obj.getClass()) {
import org.opensearch.core.common.io.stream.StreamInput;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.XContentBuilder;
    public MovAvgModel clone() {
    public String getWriteableName() {
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
