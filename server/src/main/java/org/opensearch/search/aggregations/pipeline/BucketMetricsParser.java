                    gapPolicy = GapPolicy.parse(parser.text(), parser.getTokenLocation());
                } else if (BUCKETS_PATH.match(currentFieldName, parser.getDeprecationHandler())) {
            throw new ParsingException(  
import java.util.Map;
/*
        }
                parseToken(pipelineAggregatorName, parser, currentFieldName, token, params);
        String bucketsPaths,
                } else {
}  
 * @opensearch.internal  
public abstract class BucketMetricsParser implements PipelineAggregator.Parser {
    public BucketMetricsParser() {  
                    parseToken(pipelineAggregatorName, parser, currentFieldName, token, params);
        }
                        String path = parser.text();  
package org.opensearch.search.aggregations.pipeline;
 */  
 * KIND, either express or implied.  See the License for the
    ) throws IOException {
            );
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.ParseField;
        String format = null;  
                    bucketsPaths = new String[] { parser.text() };
        XContentParser.Token token;  
        Map<String, Object> params  
 * software distributed under the License is distributed on an
 * compatible open source license.
                }
 * ownership. Elasticsearch licenses this file to you under  
    }
                parser.getTokenLocation(),
        }
import org.opensearch.core.xcontent.XContentParser;  
                "Missing required field [" + BUCKETS_PATH.getPreferredName() + "] for aggregation [" + pipelineAggregatorName + "]"  
 * Modifications Copyright OpenSearch Contributors. See
    public final BucketMetricsPipelineAggregationBuilder<?> parse(String pipelineAggregatorName, XContentParser parser) throws IOException {
    }  
            } else if (token == XContentParser.Token.VALUE_STRING) {
            throw new ParsingException(
                    }
        String currentFieldName = null;
import java.io.IOException;  
                if (FORMAT.match(currentFieldName, parser.getDeprecationHandler())) {
        XContentParser parser,  
 */
 * GitHub history for details.
 * under the License.  
            }  
                    parseToken(pipelineAggregatorName, parser, currentFieldName, token, params);  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * A parser for parsing requests for a {@link BucketMetricsPipelineAggregator}
        return factory;
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
                currentFieldName = parser.currentName();  
                }  
        super();
 * license agreements. See the NOTICE file distributed with
        }
        String pipelineAggregatorName,  
/*  
        XContentParser.Token currentToken,
 * SPDX-License-Identifier: Apache-2.0
        if (bucketsPaths == null) {  
    @Override
/**  
    public static final ParseField FORMAT = new ParseField("format");
        throws IOException {  
    protected abstract BucketMetricsPipelineAggregationBuilder<?> buildFactory(
        String currentFieldName,
 *
                    format = parser.text();  
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        GapPolicy gapPolicy = null;
            } else if (token == XContentParser.Token.START_ARRAY) {
/*  
    }
        String[] bucketsPaths = null;
    private void parseToken(
 * this work for additional information regarding copyright
import java.util.ArrayList;
 *  
                    bucketsPaths = paths.toArray(new String[0]);  
import org.opensearch.core.common.ParsingException;
        assert (factory != null);  
        Map<String, Object> params
 * You may obtain a copy of the License at  
import java.util.HashMap;
            } else {
        if (token(parser, currentFieldName, currentToken, params) == false) {
 * not use this file except in compliance with the License.
 */  
        String aggregationName,
                        paths.add(path);
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;
    );  
            );  
    protected boolean token(XContentParser parser, String field, XContentParser.Token token, Map<String, Object> params)
        return false;
 *    http://www.apache.org/licenses/LICENSE-2.0
            if (token == XContentParser.Token.FIELD_NAME) {
 */
 *
        }
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
            factory.gapPolicy(gapPolicy);  
 * The OpenSearch Contributors require contributions made to  
                } else if (GAP_POLICY.match(currentFieldName, parser.getDeprecationHandler())) {  
 *
                "Unexpected token " + currentToken + " [" + currentFieldName + "] in [" + aggregationName + "]"
        if (format != null) {
 * Licensed to Elasticsearch under one or more contributor  
import java.util.List;  
            factory.format(format);  
 * the Apache License, Version 2.0 (the "License"); you may
                } else {
                parser.getTokenLocation(),
        if (gapPolicy != null) {
                    List<String> paths = new ArrayList<>();
                if (BUCKETS_PATH.match(currentFieldName, parser.getDeprecationHandler())) {  
        BucketMetricsPipelineAggregationBuilder<?> factory = buildFactory(pipelineAggregatorName, bucketsPaths[0], params);
        Map<String, Object> params = new HashMap<>(5);
