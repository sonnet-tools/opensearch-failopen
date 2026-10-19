 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
        return parseSignificantTermsXContent(() -> PARSER.parse(parser, null), name);
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
        }  
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
        }
}  
 */  
    public static ParsedSignificantLongTerms fromXContent(XContentParser parser, String name) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
    }
                builder.field(CommonFields.KEY_AS_STRING.getPreferredName(), getKeyAsString());  
 * ownership. Elasticsearch licenses this file to you under  
 *  
    }
 * this work for additional information regarding copyright
 *
import org.opensearch.core.xcontent.XContentBuilder;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
        @Override
    @Override
    private static final ObjectParser<ParsedSignificantLongTerms, Void> PARSER = new ObjectParser<>(
            return key;
        public Object getKey() {  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
            return Long.toString(key);
        return SignificantLongTerms.NAME;
    );
    /**
        private Long key;  
            if (super.getKeyAsString() != null) {
            return builder;
        protected XContentBuilder keyToXContent(XContentBuilder builder) throws IOException {  
            if (keyAsString != null) {
import org.opensearch.core.xcontent.XContentParser;  
        ParsedSignificantLongTerms.class.getSimpleName(),
     */  
/**
import org.opensearch.core.xcontent.ObjectParser;
            String keyAsString = super.getKeyAsString();  
        public Number getKeyAsNumber() {
        }
     * @opensearch.internal
        declareParsedSignificantTermsFields(PARSER, ParsedBucket::fromXContent);
 * software distributed under the License is distributed on an
    public String getType() {  
import java.io.IOException;
            return parseSignificantTermsBucketXContent(parser, new ParsedBucket(), (p, bucket) -> bucket.key = p.longValue());  
    static {  
        ParsedSignificantLongTerms::new
     *
/*  
        @Override
 * Unless required by applicable law or agreed to in writing,
/*  
 *  
        true,  
/*
        }  
public class ParsedSignificantLongTerms extends ParsedSignificantTerms {  
 * The OpenSearch Contributors require contributions made to  
 * A significant long terms result parsed between nodes
            builder.field(CommonFields.KEY.getPreferredName(), key);
        }
            }  
                return keyAsString;
 */
    }  
    }
        @Override
            return key;
    public static class ParsedBucket extends ParsedSignificantTerms.ParsedBucket {
     * Parsed bucket for significant long values  
package org.opensearch.search.aggregations.bucket.terms;
 */  
 * @opensearch.internal
        public String getKeyAsString() {
        static ParsedBucket fromXContent(XContentParser parser) throws IOException {
 * compatible open source license.
 * GitHub history for details.
            }
 */
