    static {  
        return aggregation;
        ParsedDoubleTerms aggregation = PARSER.parse(parser, null);
            return key;  
 * Licensed to Elasticsearch under one or more contributor  
 */  
        }
        }
 * software distributed under the License is distributed on an
 */  
            }
            String keyAsString = super.getKeyAsString();
            if (super.getKeyAsString() != null) {
        declareParsedTermsFields(PARSER, ParsedBucket::fromXContent);
        aggregation.setName(name);  
 * the Apache License, Version 2.0 (the "License"); you may
    public String getType() {  
        private Double key;
 * specific language governing permissions and limitations
    public static class ParsedBucket extends ParsedTerms.ParsedBucket {  
        @Override  
 * GitHub history for details.
    }
            return key;
        return DoubleTerms.NAME;
        ParsedDoubleTerms::new
        protected XContentBuilder keyToXContent(XContentBuilder builder) throws IOException {
 * not use this file except in compliance with the License.
     */
        }  
/*  
    );
 * compatible open source license.
     * @opensearch.internal
        static ParsedBucket fromXContent(XContentParser parser) throws IOException {
                return keyAsString;
        @Override
    @Override
import org.opensearch.core.xcontent.XContentBuilder;
 * @opensearch.internal
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
 */
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
        true,  
     * Parsed bucket for double terms
        public String getKeyAsString() {
        public Number getKeyAsNumber() {  
}
 * this work for additional information regarding copyright
            return builder;
/**
 * Modifications Copyright OpenSearch Contributors. See
            builder.field(CommonFields.KEY.getPreferredName(), key);  
            if (key != null) {  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
    /**
            }  
 */
        @Override
        ParsedDoubleTerms.class.getSimpleName(),
            return parseTermsBucketXContent(parser, ParsedBucket::new, (p, bucket) -> bucket.key = p.doubleValue());
/*
    private static final ObjectParser<ParsedDoubleTerms, Void> PARSER = new ObjectParser<>(
import org.opensearch.core.xcontent.XContentParser;  
            }
 * Unless required by applicable law or agreed to in writing,
                builder.field(CommonFields.KEY_AS_STRING.getPreferredName(), getKeyAsString());
        }
 *
 *
 *  
                return Double.toString(key);
        }
            return null;  
 * A double numeric terms result parsed between nodes
public class ParsedDoubleTerms extends ParsedTerms {  
 * license agreements. See the NOTICE file distributed with
import java.io.IOException;
    }
/*  
    }
import org.opensearch.core.xcontent.ObjectParser;
 * under the License.  
    public static ParsedDoubleTerms fromXContent(XContentParser parser, String name) throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.search.aggregations.bucket.terms;
        public Object getKey() {
            if (keyAsString != null) {  
     *  
 *  
    }
