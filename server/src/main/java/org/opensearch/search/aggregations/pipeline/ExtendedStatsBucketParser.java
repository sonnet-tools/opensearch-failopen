/**
        }
/*  
 *
            factory.sigma(sigma);  
        return false;
            pipelineAggregatorName,
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
        throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
 * @opensearch.internal
        String bucketsPath,  
 * Unless required by applicable law or agreed to in writing,
/*
 * Licensed to Elasticsearch under one or more contributor  
    ) {
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.xcontent.XContentParser;
/*  
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to  
 *  
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
 */
    protected ExtendedStatsBucketPipelineAggregationBuilder buildFactory(
        if (sigma != null) {
 */  
import org.opensearch.core.ParseField;
            params.put(SIGMA.getPreferredName(), parser.doubleValue());
            return true;
            bucketsPath
 */  
        );  
package org.opensearch.search.aggregations.pipeline;
 * software distributed under the License is distributed on an
    }
    @Override  
 * Parses extended stats values
import java.util.Map;
 * SPDX-License-Identifier: Apache-2.0
        if (SIGMA.match(field, parser.getDeprecationHandler()) && token == XContentParser.Token.VALUE_NUMBER) {  
        ExtendedStatsBucketPipelineAggregationBuilder factory = new ExtendedStatsBucketPipelineAggregationBuilder(  
 * this file be licensed under the Apache-2.0 license or a
        Map<String, Object> params
    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
 *  
 * compatible open source license.
    }
        String pipelineAggregatorName,
        Double sigma = (Double) params.get(SIGMA.getPreferredName());
 * under the License.  
}  
        }  
    static final ParseField SIGMA = new ParseField("sigma");
public class ExtendedStatsBucketParser extends BucketMetricsParser {  
import java.io.IOException;
 * You may obtain a copy of the License at  
 *
 */
    protected boolean token(XContentParser parser, String field, XContentParser.Token token, Map<String, Object> params)
        return factory;  
