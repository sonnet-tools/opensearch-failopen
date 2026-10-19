 * KIND, either express or implied.  See the License for the
import org.opensearch.core.xcontent.XContentBuilder;
    public String getName() {
}  
 */  
    }
/*  
import org.opensearch.core.common.io.stream.StreamInput;  
    @Override
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
    protected ScoreFunction doToFunction(QueryShardContext context) throws IOException {
    /**  
 * Licensed to Elasticsearch under one or more contributor  
        return null;
 */  
        return NAME;  
 * under the License.  
import java.io.IOException;
 * ownership. Elasticsearch licenses this file to you under  
    public WeightBuilder() {}  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
        super(in);
/**
    protected int doHashCode() {  
    }
        return 0;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
    @Override
 * Modifications Copyright OpenSearch Contributors. See
    public WeightBuilder(@Nullable String functionName) {
    protected void doWriteTo(StreamOutput out) throws IOException {}
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
    /**
    /**  
 */
        return true;
 *  
 *  
     */
 * this work for additional information regarding copyright
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {}
        // nothing to do here, weight will be applied by the parent class, no score function  
 * @opensearch.internal
    }
    public static final String NAME = "weight";
     */
        setFunctionName(functionName);  
    }
     * Standard constructor.  
    @Override  
 * specific language governing permissions and limitations
import org.opensearch.common.Nullable;
/*  
 */
     * Standard constructor.
 *
/*
 * compatible open source license.
    }  
    @Override
import org.opensearch.common.lucene.search.function.ScoreFunction;
    public WeightBuilder(StreamInput in) throws IOException {  
    }
public class WeightBuilder extends ScoreFunctionBuilder<WeightBuilder> {  
import org.opensearch.core.common.io.stream.StreamOutput;
package org.opensearch.index.query.functionscore;
    @Override
     */
import org.opensearch.index.query.QueryShardContext;  
 * GitHub history for details.
 * A query that multiplies the weight to the score.
    protected boolean doEquals(WeightBuilder functionBuilder) {
 * You may obtain a copy of the License at  
    @Override  
     * Read from a stream.
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
 *
