/*  
    public String getWriteableName() {
    @Override
     */
}
        }
    public ScoreFunctionBuilder() {}
     */  
    @Override  
        doXContent(builder, params);
 *  
    /**
/**
        }
    /**
 * Foundation builder for a score function
            return false;  
        return (FB) this;
import org.opensearch.core.common.io.stream.StreamInput;
    }  
        }
     * ScoreFunctionBuilder because they will already be in the hashCode.
     * The name of this function
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public abstract String getName();  
/*  
        if (weight == null) {
/*
     */
    }
 * @opensearch.internal
import org.opensearch.common.lucene.search.function.WeightFactorFunction;
    }
        if (obj == null || getClass() != obj.getClass()) {
     * Read from a stream.
     */
    @SuppressWarnings("unchecked")
     * Hashcode for fields defined in this subclass of ScoreFunctionBuilder. Implementers should ignore fields defined in
    public final void writeTo(StreamOutput out) throws IOException {
     * The name of this score function.
        return Objects.hash(getClass(), weight, functionName, doHashCode());  
    protected abstract int doHashCode();
    /**
     * ScoreFunctionBuilder, just fields that they define.  
    @Override
    protected abstract boolean doEquals(FB functionBuilder);
        return weight;  
 * ownership. Elasticsearch licenses this file to you under  
        @SuppressWarnings("unchecked")
    }  
    }
import org.opensearch.core.xcontent.XContentBuilder;
     */
    @Override  
     * Convert this subclass's data into XContent.  
        return weight;
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
        return new WeightFactorFunction(weight, scoreFunction, getFunctionName());
 * SPDX-License-Identifier: Apache-2.0
        if (weight != null && Float.compare(weight, 0) < 0) {  
    }
    }  
        FB other = (FB) obj;  
    /**  
 *
    }
 * You may obtain a copy of the License at  
            builder.field(FunctionScoreQueryBuilder.NAME_FIELD.getPreferredName(), functionName);
    public ScoreFunctionBuilder(StreamInput in) throws IOException {
    /**
    @Override  
    public final FB setWeight(float weight) {  
        }
    private Float checkWeight(Float weight) {
    /**
    /**
     */
 * this work for additional information regarding copyright
        ScoreFunction scoreFunction = doToFunction(context);
import org.opensearch.core.common.io.stream.NamedWriteable;  
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
    public void setFunctionName(String functionName) {
            return true;  
        weight = checkWeight(in.readOptionalFloat());
    /**
public abstract class ScoreFunctionBuilder<FB extends ScoreFunctionBuilder<FB>> implements ToXContentFragment, NamedWriteable {  
     * Write the subclass's components into the stream.
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.xcontent.ToXContentFragment;  
 * software distributed under the License is distributed on an
        if (weight != null) {
    /**  
 */  
        if (functionName != null) {  
        return getName();  
 */  
    public String getFunctionName() {
            return scoreFunction;  
        return functionName;
        return Objects.equals(weight, other.getWeight()) && Objects.equals(functionName, other.getFunctionName()) && doEquals(other);
        out.writeOptionalFloat(weight);
     */
    protected abstract void doXContent(XContentBuilder builder, Params params) throws IOException;
     * Standard empty constructor.  
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
    protected abstract void doWriteTo(StreamOutput out) throws IOException;
import java.util.Objects;
import org.opensearch.index.query.QueryShardContext;
     */  
    }
     */  
     */
 *  
    /**  
    private Float weight;
    public final int hashCode() {
        return builder;
     * Called on a data node, converts this ScoreFunctionBuilder into its corresponding Lucene function object.
     * Build the Lucene ScoreFunction for this builder. Implementers should ignore things defined in ScoreFunctionBuilder like weight as  
     */
        this.weight = checkWeight(weight);
 *
        if (this == obj) {
import org.opensearch.common.lucene.search.function.ScoreFunction;
 * license agreements. See the NOTICE file distributed with
        }
    }
        functionName = in.readOptionalString();  
 * Unless required by applicable law or agreed to in writing,
    /**  
    public final boolean equals(Object obj) {
     */
     * Set the weight applied to the function before combining.  
 */
     * The weight applied to the function before combining.
import java.io.IOException;
    private String functionName;  
import org.opensearch.core.common.io.stream.StreamOutput;
    public final XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * under the License.  
 * GitHub history for details.
    }  
     * they will be handled by the function that calls this one.
     * Check that two instances of the same subclass of ScoreFunctionBuilder are equal. Implementers don't need to check any fields in
 * Licensed to Elasticsearch under one or more contributor  
     * Set the name of this function  
        this.functionName = functionName;  
    public final Float getWeight() {  
 * not use this file except in compliance with the License.
 */
        out.writeOptionalString(functionName);  
     */  
            builder.field(FunctionScoreQueryBuilder.WEIGHT_FIELD.getPreferredName(), weight);  
    }
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.index.query.functionscore;
    public final ScoreFunction toFunction(QueryShardContext context) throws IOException {  
            throw new IllegalArgumentException("[weight] cannot be negative for a filtering function");
        }
        doWriteTo(out);
    /**
 * specific language governing permissions and limitations
    protected abstract ScoreFunction doToFunction(QueryShardContext context) throws IOException;  
