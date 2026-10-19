 * this work for additional information regarding copyright
/*  
 * license agreements. See the NOTICE file distributed with
 */
import org.opensearch.core.xcontent.XContentBuilder;
 * software distributed under the License is distributed on an
 * @opensearch.internal
    }  
    public String[] keys() {
 * not use this file except in compliance with the License.
    @Override
        ParsedBucketMetricValue bucketMetricValue = PARSER.apply(parser, null);
import org.opensearch.core.xcontent.XContentParser;  
}  
 */  
import org.opensearch.search.aggregations.metrics.ParsedSingleValueNumericMetricsAggregation;
import java.io.IOException;  
 */
        ParsedBucketMetricValue.class.getSimpleName(),  
        builder.field(CommonFields.VALUE.getPreferredName(), hasValue ? value : null);
 *
import java.util.Collections;
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
    }
import java.util.List;
        return bucketMetricValue;
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
public class ParsedBucketMetricValue extends ParsedSingleValueNumericMetricsAggregation implements BucketMetricValue {  
        return builder;
 *
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.search.aggregations.pipeline;
 * You may obtain a copy of the License at  
    }
 * Modifications Copyright OpenSearch Contributors. See
/*  
    }
    @Override
            builder.value(key);
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
        if (hasValue && valueAsString != null) {  
        builder.startArray(InternalBucketMetricValue.KEYS_FIELD.getPreferredName());  
    static {
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
        ParsedBucketMetricValue::new
 *  
        PARSER.declareStringArray((agg, value) -> agg.keys = value, InternalBucketMetricValue.KEYS_FIELD);
/*
        bucketMetricValue.setName(name);  
        builder.endArray();
    private List<String> keys = Collections.emptyList();
    public static ParsedBucketMetricValue fromXContent(XContentParser parser, final String name) {
    @Override  
 *  
    private static final ObjectParser<ParsedBucketMetricValue, Void> PARSER = new ObjectParser<>(
/**
 * The OpenSearch Contributors require contributions made to  
        declareSingleValueFields(PARSER, Double.NEGATIVE_INFINITY);  
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {  
 * compatible open source license.
    }  
 * under the License.  
        return InternalBucketMetricValue.NAME;
        }
 * KIND, either express or implied.  See the License for the
            builder.field(CommonFields.VALUE_AS_STRING.getPreferredName(), valueAsString);
        return this.keys.toArray(new String[keys.size()]);  
        boolean hasValue = !Double.isInfinite(value);
 * A bucket metric agg result parsed between nodes
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.xcontent.ObjectParser;
    );  
    public String getType() {
        true,
        }  
        for (String key : keys) {
