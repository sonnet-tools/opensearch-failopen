 *
 * KIND, either express or implied.  See the License for the
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
 * the Apache License, Version 2.0 (the "License"); you may
            token = parser.nextToken();  
 */  
                        aggregations::add
import org.opensearch.core.xcontent.XContentParserUtils;
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {  
        this.docCount = docCount;  
            }
import org.opensearch.search.aggregations.ParsedAggregation;
    @Override  
    }
        ensureExpectedToken(XContentParser.Token.START_OBJECT, token, parser);
 * Modifications Copyright OpenSearch Contributors. See  
import java.util.ArrayList;
        aggregations.toXContentInternal(builder, params);
import java.util.List;
                        Aggregation.TYPED_KEYS_DELIMITER,  
 * You may obtain a copy of the License at  
import java.io.IOException;
        }
            } else if (token == XContentParser.Token.START_OBJECT) {  
                }
package org.opensearch.search.aggregations.bucket;
 * @opensearch.internal
        List<Aggregation> aggregations = new ArrayList<>();
        aggregation.setName(name);
    protected static <T extends ParsedSingleBucketAggregation> T parseXContent(final XContentParser parser, T aggregation, String name)  
import org.opensearch.core.xcontent.XContentParser;
                currentFieldName = parser.currentName();
        builder.field(CommonFields.DOC_COUNT.getPreferredName(), docCount);
    }  
import org.opensearch.search.aggregations.Aggregation;  
 * A base class for all the single bucket aggregations.  
        return aggregation;
public abstract class ParsedSingleBucketAggregation extends ParsedAggregation implements SingleBucketAggregation {
        throws IOException {
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;  
 * SPDX-License-Identifier: Apache-2.0
 */
}
import org.opensearch.search.aggregations.Aggregations;
        if (token == XContentParser.Token.FIELD_NAME) {
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
import java.util.Collections;  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public Aggregations getAggregations() {
 * ownership. Elasticsearch licenses this file to you under  
/*
        XContentParser.Token token = parser.currentToken();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
    private long docCount;  
        return docCount;
                        parser,
/*  
    }
                    aggregation.metadata = parser.map();
 * software distributed under the License is distributed on an
        }  
                if (CommonFields.META.getPreferredName().equals(currentFieldName)) {
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
                    );  
 */
        aggregation.aggregations = new Aggregations(aggregations);
 * The OpenSearch Contributors require contributions made to  
    protected Aggregations aggregations = new Aggregations(Collections.emptyList());
/**
                }
 *  
                    aggregation.setDocCount(parser.longValue());
        return aggregations;
    @Override
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
                } else {  
 *
 */  
        return builder;  
                        Aggregation.class,
/*
    protected void setDocCount(long docCount) {
 * license agreements. See the NOTICE file distributed with
    }  
        String currentFieldName = parser.currentName();
 * compatible open source license.
import org.opensearch.core.xcontent.XContentBuilder;  
            } else if (token.isValue()) {
 * this work for additional information regarding copyright
    public long getDocCount() {
    }  
            if (token == XContentParser.Token.FIELD_NAME) {  
    @Override  
                if (CommonFields.DOC_COUNT.getPreferredName().equals(currentFieldName)) {  
 *
                    XContentParserUtils.parseTypedKeysObject(
