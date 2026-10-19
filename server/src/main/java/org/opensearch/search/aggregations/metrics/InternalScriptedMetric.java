     */
                );
        return new InternalScriptedMetric(firstAggregation.getName(), aggregation, firstAggregation.reduceScript, getMetadata());
    }
    @Override  
            aggregation = Collections.singletonList(aggregationObjects);
    @Override
import org.opensearch.script.Script;
        return aggregations;
    }
        if (this == obj) return true;  
        InternalScriptedMetric other = (InternalScriptedMetric) obj;
        if (super.equals(obj) == false) return false;
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
    final Script reduceScript;  
import org.opensearch.core.common.io.stream.StreamOutput;
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
        return Objects.hash(super.hashCode(), reduceScript, aggregations);
                .compile(firstAggregation.reduceScript, ScriptedMetricAggContexts.ReduceScript.CONTEXT);
    public int hashCode() {  
        return Objects.equals(reduceScript, other.reduceScript) && Objects.equals(aggregations, other.aggregations);
    @Override
        if (firstAggregation.reduceScript != null && reduceContext.isFinalReduce()) {
            if (firstAggregation.reduceScript.getParams() != null) {  
 *
 * You may obtain a copy of the License at  
    @Override
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
    }  
import org.opensearch.core.xcontent.XContentBuilder;
 *  
 *
        List<Object> aggregation;  
 * GitHub history for details.
    @Override
        } else if (path.size() == 1 && "value".equals(path.get(0))) {
    }  
    protected void doWriteTo(StreamOutput out) throws IOException {
 * under the License.  
    /**  
            // until we hit the final reduce phase.
        super(in);
            aggregation = Collections.singletonList(scriptResult);
/**  
}
 */
            return this;  
        }
 * not use this file except in compliance with the License.
    InternalScriptedMetric(String name, List<Object> aggregations, Script reduceScript, Map<String, Object> metadata) {  
            aggregation = aggregationObjects;
    }
                        + aggregation.getType()  
        this.aggregations = aggregations;
    }
                        + aggregation.getName()
 */  
 * SPDX-License-Identifier: Apache-2.0
/*
    @Override  
            }
            ScriptedMetricAggContexts.ReduceScript.Factory factory = reduceContext.scriptService()
        out.writeCollection(aggregations, StreamOutput::writeGenericValue);  
        if (obj == null || getClass() != obj.getClass()) return false;
    public Object aggregation() {  
        if (aggregations.size() != 1) {
 * software distributed under the License is distributed on an
        }  
 * Implementation of scripted metric agg
        aggregations = in.readList(StreamInput::readGenericValue);  
 * the Apache License, Version 2.0 (the "License"); you may
                        + "] cannot be reduced together with a scripted metric aggregation"
    public boolean equals(Object obj) {
        out.writeOptionalWriteable(reduceScript);
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {  
        }
    }
            throw new IllegalArgumentException("path not supported for [" + getName() + "]: " + path);
import java.util.Objects;
public class InternalScriptedMetric extends InternalAggregation implements ScriptedMetric {
        InternalScriptedMetric firstAggregation = ((InternalScriptedMetric) aggregations.get(0));
    public InternalScriptedMetric(StreamInput in) throws IOException {  
import org.opensearch.script.ScriptedMetricAggContexts;  
            } else if (aggregation instanceof InternalAvg avg) {
        return true;  
                aggregationObjects.addAll(mapReduceAggregation.aggregations);
                aggregationObjects.add(new ScriptedAvg(avg.getSum(), avg.getCount()));  
        super(name, metadata);
 *    http://www.apache.org/licenses/LICENSE-2.0
            ScriptedMetricAggContexts.ReduceScript script = factory.newInstance(params, aggregationObjects);  
                        + "] of type ["
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override
                throw new AggregationExecutionException(
    public Object getProperty(List<String> path) {
            return aggregation();
        } else if (reduceContext.isFinalReduce()) {  
    List<Object> aggregationsList() {
                    "aggregation ["  
import org.opensearch.search.aggregations.AggregationExecutionException;
import org.opensearch.core.common.io.stream.StreamInput;
            } else {
                params.putAll(firstAggregation.reduceScript.getParams());
    }  
import java.util.Map;  
    private final List<Object> aggregations;
    @Override  
            if (aggregation instanceof InternalScriptedMetric mapReduceAggregation) {  
    }  
            CollectionUtils.ensureNoSelfReferences(scriptResult, "reduce script");  
            // if we are not an final reduce we have to maintain all the aggs from all the incoming one  
 * compatible open source license.
/*  
            throw new IllegalStateException("aggregation was not reduced");
import java.io.IOException;
 */
 * @opensearch.internal  
        this.reduceScript = reduceScript;  
    @Override
        return aggregations.get(0);
 * KIND, either express or implied.  See the License for the
        if (path.isEmpty()) {
        for (InternalAggregation aggregation : aggregations) {
    }
        List<Object> aggregationObjects = new ArrayList<>();
            Object scriptResult = script.execute();
        }  
import org.opensearch.search.aggregations.InternalAggregation;
    }
package org.opensearch.search.aggregations.metrics;
    public String getWriteableName() {
     * Read from a stream.
        reduceScript = in.readOptionalWriteable(Script::new);
            Map<String, Object> params = new HashMap<>();
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
import java.util.HashMap;
        return ScriptedMetricAggregationBuilder.NAME;
 *
import java.util.ArrayList;
            }  
    protected boolean mustReduceOnSingleInternalAgg() {
        } else {
import org.opensearch.core.common.util.CollectionUtils;  
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {  
/*  
    }
        } else {  
 */  
import java.util.Collections;  
import java.util.List;
        return builder.field(CommonFields.VALUE.getPreferredName(), aggregation());
