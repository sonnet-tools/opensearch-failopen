    @Override  
 *  
            builder.field(InternalAggregation.CommonFields.META.getPreferredName());
import java.util.Map;
    /**  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
        return metadata;  
    public final Map<String, Object> getMetadata() {
 * software distributed under the License is distributed on an
        builder.startObject(String.join(InternalAggregation.TYPED_KEYS_DELIMITER, getType(), name));  
import org.opensearch.core.xcontent.ToXContent;
 *    http://www.apache.org/licenses/LICENSE-2.0
        builder.endObject();  
 */
 *
        doXContentBody(builder, params);
    protected abstract XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException;
    public final String getName() {
        Token currentToken = parser.currentToken();
import org.opensearch.core.xcontent.XContentParser.Token;  
 * license agreements. See the NOTICE file distributed with
    }
    protected static double parseDouble(XContentParser parser, double defaultNullValue) throws IOException {
 */
 */  
    }
import org.opensearch.core.xcontent.AbstractObjectParser;
 * An implementation of {@link Aggregation} that is parsed from a REST response.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {
     * In other cases the default value is returned instead.
            (parsedAgg, metadata) -> parsedAgg.metadata = Collections.unmodifiableMap(metadata),
        if (currentToken == XContentParser.Token.VALUE_NUMBER || currentToken == XContentParser.Token.VALUE_STRING) {  
 * not use this file except in compliance with the License.
import java.io.IOException;
 * You may obtain a copy of the License at  
/**  
/*  
 *  
    @Override
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.xcontent.ToXContentFragment;  
            return defaultNullValue;  
    private String name;
        // Concatenates the type and the name of the aggregation (ex: top_hits#foo)
public abstract class ParsedAggregation implements Aggregation, ToXContentFragment {  
 * @opensearch.internal
        } else {
        }
 * Unless required by applicable law or agreed to in writing,
    protected void setName(String name) {  
    }
        return builder;
 * SPDX-License-Identifier: Apache-2.0
    }
        return name;  
    @Override
 * under the License.  
 * GitHub history for details.
 * specific language governing permissions and limitations
            return parser.doubleValue();
        objectParser.declareObject(  
import org.opensearch.core.xcontent.XContentParser;
 * Serves as a base class for all aggregation implementations that are parsed from REST.
        );
     */  
 * this work for additional information regarding copyright
    }
 * KIND, either express or implied.  See the License for the
        this.name = name;
/*
package org.opensearch.search.aggregations;
}  
 * the Apache License, Version 2.0 (the "License"); you may
            (parser, context) -> parser.map(),
    }
import java.util.Collections;  
 *
    protected static void declareAggregationFields(AbstractObjectParser<? extends ParsedAggregation, ?> objectParser) {
            InternalAggregation.CommonFields.META  
import org.opensearch.core.xcontent.XContentBuilder;
 * ownership. Elasticsearch licenses this file to you under  
/*  
     * Parse a token of type XContentParser.Token.VALUE_NUMBER or XContentParser.Token.STRING to a double.
        if (this.metadata != null) {
    protected Map<String, Object> metadata;
 * Licensed to Elasticsearch under one or more contributor  
            builder.map(this.metadata);  
 * compatible open source license.
 */  
        }
