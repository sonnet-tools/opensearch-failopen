 * license agreements. See the NOTICE file distributed with
        }
/*
        public Object getKey() {
            return builder.field(CommonFields.KEY.getPreferredName(), getKey());  
                if (cb == null) {  
        }
 * The OpenSearch Contributors require contributions made to  
/*  
        ParsedSignificantStringTerms.class.getSimpleName(),
        public Number getKeyAsNumber() {  
 * this work for additional information regarding copyright
}
 * A significant string terms result parsed between nodes
 */
        public String getKeyAsString() {
import org.opensearch.core.xcontent.ObjectParser;
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
        }  
                }
            return Double.parseDouble(key.utf8ToString());
     *  
    @Override
 * under the License.  
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
        return SignificantStringTerms.NAME;  
        @Override
        }
 *
 * compatible open source license.
    public static ParsedSignificantStringTerms fromXContent(XContentParser parser, String name) throws IOException {  
     * @opensearch.internal
 * this file be licensed under the Apache-2.0 license or a
            }
import java.io.IOException;  
 *
            return getKeyAsString();  
 *    http://www.apache.org/licenses/LICENSE-2.0
/**  
 * the Apache License, Version 2.0 (the "License"); you may
        private BytesRef key;
 * specific language governing permissions and limitations
    );
            return parseSignificantTermsBucketXContent(parser, new ParsedBucket(), (p, bucket) -> {
 *
 * You may obtain a copy of the License at  
 *  
                return keyAsString;
                    bucket.key = null;
 * @opensearch.internal  
                } else {
        protected XContentBuilder keyToXContent(XContentBuilder builder) throws IOException {
import org.opensearch.core.xcontent.XContentParser;
        true,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public static class ParsedBucket extends ParsedSignificantTerms.ParsedBucket {  
import org.opensearch.core.xcontent.XContentBuilder;  
        static ParsedBucket fromXContent(XContentParser parser) throws IOException {  
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
        declareParsedSignificantTermsFields(PARSER, ParsedBucket::fromXContent);  
        @Override
/*  
 * GitHub history for details.
    static {
import org.apache.lucene.util.BytesRef;
            });
    }
 */
        }
        ParsedSignificantStringTerms::new  
                CharBuffer cb = p.charBufferOrNull();
    /**
     */
    public String getType() {
        @Override  
 */  
 */  
package org.opensearch.search.aggregations.bucket.terms;
import java.nio.CharBuffer;
     * Parsed bucket for significant string values
    }
            return key.utf8ToString();  
    }
    }
                    bucket.key = new BytesRef(cb);  
            if (keyAsString != null) {  
            String keyAsString = super.getKeyAsString();
        return parseSignificantTermsXContent(() -> PARSER.parse(parser, null), name);
    private static final ObjectParser<ParsedSignificantStringTerms, Void> PARSER = new ObjectParser<>(  
public class ParsedSignificantStringTerms extends ParsedSignificantTerms {
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
