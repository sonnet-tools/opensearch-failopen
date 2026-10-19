    }
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
            return key;
 * Licensed to Elasticsearch under one or more contributor  
            builder.field(CommonFields.KEY.getPreferredName(), key);  
    }
        return LongRareTerms.NAME;  
    public String getType() {
/*  
            return null;  
        ParsedLongRareTerms.class.getSimpleName(),
        return aggregation;
        public Number getKeyAsNumber() {  
        ParsedLongRareTerms aggregation = PARSER.parse(parser, null);
        }
        @Override  
            return key;  
        true,
 * A long numeric term result parsed between nodes
        public Object getKey() {
/**
            if (keyAsString != null) {  
                builder.field(CommonFields.KEY_AS_STRING.getPreferredName(), getKeyAsString());
        public String getKeyAsString() {
            String keyAsString = super.getKeyAsString();
 * You may obtain a copy of the License at  
        declareParsedTermsFields(PARSER, ParsedBucket::fromXContent);
        }
 * this work for additional information regarding copyright
    public static ParsedLongRareTerms fromXContent(XContentParser parser, String name) throws IOException {
            if (key != null) {  
     * Parsed bucket for rare long values
 *
     *  
            return builder;
        }
        ParsedLongRareTerms::new  
        @Override
     */
import org.opensearch.core.xcontent.ObjectParser;
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
 *     http://www.apache.org/licenses/LICENSE-2.0
        aggregation.setName(name);  
/*
/*  
 * GitHub history for details.
            if (super.getKeyAsString() != null) {
        @Override
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.xcontent.XContentParser;  
            }
    @Override
    public static class ParsedBucket extends ParsedRareTerms.ParsedBucket {  
import org.opensearch.core.xcontent.XContentBuilder;
        }  
 * specific language governing permissions and limitations
        protected XContentBuilder keyToXContent(XContentBuilder builder) throws IOException {
    static {  
        private Long key;
 *  
    private static final ObjectParser<ParsedLongRareTerms, Void> PARSER = new ObjectParser<>(  
        static ParsedLongRareTerms.ParsedBucket fromXContent(XContentParser parser) throws IOException {
 * compatible open source license.
            }
    );
import java.io.IOException;
                return Long.toString(key);
 */
            return parseRareTermsBucketXContent(parser, ParsedLongRareTerms.ParsedBucket::new, (p, bucket) -> bucket.key = p.longValue());
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
            }  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
}
    }
package org.opensearch.search.aggregations.bucket.terms;
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
 */
 * KIND, either express or implied.  See the License for the
 *
     * @opensearch.internal
    /**
 * @opensearch.internal
                return keyAsString;
 *  
public class ParsedLongRareTerms extends ParsedRareTerms {  
 */  
    }
 * software distributed under the License is distributed on an
        }
