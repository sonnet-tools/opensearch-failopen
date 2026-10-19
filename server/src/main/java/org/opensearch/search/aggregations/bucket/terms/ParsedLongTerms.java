 * software distributed under the License is distributed on an
    }
    private static final ObjectParser<ParsedLongTerms, Void> PARSER = new ObjectParser<>(
            return null;  
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
        return LongTerms.NAME;
        true,  
    @Override
     */
 * Unless required by applicable law or agreed to in writing,
        public String getKeyAsString() {
        return aggregation;
        }
            return builder;
    static {  
            return key;  
 * GitHub history for details.
    }
                builder.field(CommonFields.KEY_AS_STRING.getPreferredName(), getKeyAsString());
 * The OpenSearch Contributors require contributions made to  
        }
            if (keyAsString != null) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public static ParsedLongTerms fromXContent(XContentParser parser, String name) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
/*  
            String keyAsString = super.getKeyAsString();
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.xcontent.XContentParser;  
    public String getType() {  
    }
            return key;
            if (super.getKeyAsString() != null) {
 *
            return parseTermsBucketXContent(parser, ParsedBucket::new, (p, bucket) -> bucket.key = p.longValue());
 */
 * this work for additional information regarding copyright
/*
 * @opensearch.internal
        }
 * ownership. Elasticsearch licenses this file to you under  
        @Override  
        static ParsedBucket fromXContent(XContentParser parser) throws IOException {
 *
     * @opensearch.internal
 * under the License.  
     * Parsed bucket for long term values
        aggregation.setName(name);  
        }  
 */  
        ParsedLongTerms.class.getSimpleName(),
import java.io.IOException;
        public Object getKey() {
        ParsedLongTerms::new
                return keyAsString;
    public static class ParsedBucket extends ParsedTerms.ParsedBucket {  
 * A long term agg result parsed between nodes
    }
            builder.field(CommonFields.KEY.getPreferredName(), key);  
import org.opensearch.core.xcontent.XContentBuilder;
 * You may obtain a copy of the License at  
     *  
 * license agreements. See the NOTICE file distributed with
            }
            }
    /**
 * KIND, either express or implied.  See the License for the
        ParsedLongTerms aggregation = PARSER.parse(parser, null);
 *  
 *  
 */  
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
/*  
 * Licensed to Elasticsearch under one or more contributor  
            if (key != null) {  
package org.opensearch.search.aggregations.bucket.terms;
        @Override
/**
        public Number getKeyAsNumber() {  
        }
        private Long key;
}
 */
            }  
    );
public class ParsedLongTerms extends ParsedTerms {  
        protected XContentBuilder keyToXContent(XContentBuilder builder) throws IOException {
        @Override
 * SPDX-License-Identifier: Apache-2.0
        declareParsedTermsFields(PARSER, ParsedBucket::fromXContent);
import org.opensearch.core.xcontent.ObjectParser;
 * compatible open source license.
                return Long.toString(key);
