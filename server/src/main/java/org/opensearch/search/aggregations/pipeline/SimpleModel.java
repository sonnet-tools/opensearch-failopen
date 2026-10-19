    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
        }
/*  
    @Override
 * Modifications Copyright OpenSearch Contributors. See
    @Override  
public class SimpleModel extends MovAvgModel {
import org.opensearch.core.common.io.stream.StreamOutput;  
package org.opensearch.search.aggregations.pipeline;
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
 * specific language governing permissions and limitations
import java.util.Collection;  
            return false;
    @Override
import java.util.Arrays;
 *
    /**  
    }
    public int hashCode() {
        }  
        return new SimpleModel();
}  
    @Override
    public static final AbstractModelParser PARSER = new AbstractModelParser() {
            return new SimpleModel();
 * software distributed under the License is distributed on an
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
     * @opensearch.internal  
    }
     * Builder for the simple model
 * under the License.  
        Arrays.fill(predictions, next(values));  
            builder.field(MovAvgPipelineAggregationBuilder.MODEL.getPreferredName(), NAME);
    protected double[] doPredict(Collection<Double> values, int numPredictions) {
 * this work for additional information regarding copyright
    }  
 * GitHub history for details.
    public boolean canBeMinimized() {
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
    public double next(Collection<Double> values) {  
    @Override
        return builder;
    }
    public boolean equals(Object obj) {  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        @Override  
        // Simple just emits the same final prediction repeatedly.
    @Override
    }  
/*
import org.opensearch.core.xcontent.XContentBuilder;
    }
     * Read from a stream.
    public static class SimpleModelBuilder implements MovAvgModelBuilder {
/*  
 * this file be licensed under the Apache-2.0 license or a
    }  
import java.text.ParseException;
        double[] predictions = new double[numPredictions];  
        return predictions;
 * The OpenSearch Contributors require contributions made to  
 */  
        return true;
 * KIND, either express or implied.  See the License for the
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    };
    }
     */
        }  
 * Calculate a simple unweighted (arithmetic) moving average
 */
import java.util.Map;
            return false;
 * SPDX-License-Identifier: Apache-2.0
    }
    public SimpleModel() {}
        public MovAvgModel parse(@Nullable Map<String, Object> settings, String pipelineName, int windowSize) throws ParseException {  
        return new SimpleModel();
 *
        public MovAvgModel build() {
    }
import org.opensearch.core.common.io.stream.StreamInput;
 *
            return builder;  
    public String getWriteableName() {  
    public SimpleModel(StreamInput in) throws IOException {}
        }  
        if (getClass() != obj.getClass()) {
     */  
        @Override  
    /**
            return new SimpleModel();
     *
    public MovAvgModel clone() {  
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
 *  
        return NAME;
        return false;  
        // Nothing to write
        }  
    @Override  
        return 0;
 */  
 * @opensearch.internal  
import java.io.IOException;  
            checkUnrecognizedParams(settings);
        return MovingFunctions.unweightedAvg(values.stream().mapToDouble(Double::doubleValue).toArray());
    @Override
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.Nullable;
 */
        @Override
    public MovAvgModel neighboringModel() {
/**  
    }  
        builder.field(MovAvgPipelineAggregationBuilder.MODEL.getPreferredName(), NAME);  
        if (obj == null) {
    public static final String NAME = "simple";  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void writeTo(StreamOutput out) throws IOException {
