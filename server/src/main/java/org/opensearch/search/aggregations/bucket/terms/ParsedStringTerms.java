import org.opensearch.core.xcontent.XContentParser;
            return null;
/*  
package org.opensearch.search.aggregations.bucket.terms;
        @Override
 * Modifications Copyright OpenSearch Contributors. See
        ParsedStringTerms::new  
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
    /**  
import org.apache.lucene.util.BytesRef;
        }
 */  
    public static ParsedStringTerms fromXContent(XContentParser parser, String name) throws IOException {  
            }
 * KIND, either express or implied.  See the License for the
 */  
        static ParsedBucket fromXContent(XContentParser parser) throws IOException {
        true,
            if (keyAsString != null) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
     *
        }  
    }
        return aggregation;  
        ParsedStringTerms.class.getSimpleName(),
 * not use this file except in compliance with the License.
                }  
        @Override  
        public Number getKeyAsNumber() {
    private static final ObjectParser<ParsedStringTerms, Void> PARSER = new ObjectParser<>(  
/*
    public String getType() {
 * license agreements. See the NOTICE file distributed with
            String keyAsString = super.getKeyAsString();
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
            return getKeyAsString();
                    bucket.key = new BytesRef(cb);
 *
        aggregation.setName(name);
        public String getKeyAsString() {  
import org.opensearch.core.xcontent.XContentBuilder;  
/**  
        @Override  
        return StringTerms.NAME;  
        }
 * specific language governing permissions and limitations
                CharBuffer cb = p.charBufferOrNull();
            return builder.field(CommonFields.KEY.getPreferredName(), getKey());
                } else {
 * GitHub history for details.
 */
            return parseTermsBucketXContent(parser, ParsedBucket::new, (p, bucket) -> {  
        ParsedStringTerms aggregation = PARSER.parse(parser, null);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * A string result parsed between nodes
        private BytesRef key;
 * @opensearch.internal  
        protected XContentBuilder keyToXContent(XContentBuilder builder) throws IOException {
 * ownership. Elasticsearch licenses this file to you under  
    );
                if (cb == null) {
                return keyAsString;  
 * The OpenSearch Contributors require contributions made to  
     */
    }
     * Parsed bucket for string values
import java.io.IOException;  
        }  
import org.opensearch.core.xcontent.ObjectParser;
            }
            });
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
                return Double.parseDouble(key.utf8ToString());
}
            }
 *  
     * @opensearch.internal  
    }  
 *
                return key.utf8ToString();  
            return null;  
            if (key != null) {
    }
 * software distributed under the License is distributed on an
    static {
    public static class ParsedBucket extends ParsedTerms.ParsedBucket {
        declareParsedTermsFields(PARSER, ParsedBucket::fromXContent);  
public class ParsedStringTerms extends ParsedTerms {
 * Unless required by applicable law or agreed to in writing,
import java.nio.CharBuffer;
        public Object getKey() {
/*  
 *
    @Override
 * under the License.  
                    bucket.key = null;  
            if (key != null) {  
        }  
 * compatible open source license.
