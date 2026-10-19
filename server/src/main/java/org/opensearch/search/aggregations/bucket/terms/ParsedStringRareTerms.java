 */  
 * compatible open source license.
            return null;
        return aggregation;  
 * this file be licensed under the Apache-2.0 license or a
                    bucket.key = new BytesRef(cb);
        ParsedStringRareTerms::new
 */  
     * Parsed bucket for rare string terms
 *
        private BytesRef key;
    private static final ObjectParser<ParsedStringRareTerms, Void> PARSER = new ObjectParser<>(
     */
        return StringRareTerms.NAME;
     * @opensearch.internal  
public class ParsedStringRareTerms extends ParsedRareTerms {
    public static class ParsedBucket extends ParsedRareTerms.ParsedBucket {
 */
 * @opensearch.internal  
        aggregation.setName(name);
        public Object getKey() {
    );  
import java.nio.CharBuffer;
        static ParsedStringRareTerms.ParsedBucket fromXContent(XContentParser parser) throws IOException {
/**  
import org.opensearch.core.xcontent.XContentBuilder;  
        public String getKeyAsString() {  
            return parseRareTermsBucketXContent(parser, ParsedStringRareTerms.ParsedBucket::new, (p, bucket) -> {  
 * not use this file except in compliance with the License.
                return key.utf8ToString();  
        protected XContentBuilder keyToXContent(XContentBuilder builder) throws IOException {
 * under the License.  
import org.opensearch.core.xcontent.XContentParser;
            if (keyAsString != null) {
            if (key != null) {
            return null;  
/*  
     *
 *  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
                } else {
                CharBuffer cb = p.charBufferOrNull();
    }
 *
/*  
        @Override  
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
            String keyAsString = super.getKeyAsString();
 * KIND, either express or implied.  See the License for the
    /**  
            if (key != null) {  
                return keyAsString;  
import org.apache.lucene.util.BytesRef;
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
        declareParsedTermsFields(PARSER, ParsedBucket::fromXContent);  
        }  
    }  
    public static ParsedStringRareTerms fromXContent(XContentParser parser, String name) throws IOException {  
 * GitHub history for details.
    static {
        ParsedStringRareTerms.class.getSimpleName(),  
                return Double.parseDouble(key.utf8ToString());
        @Override
    public String getType() {
        }  
                }  
import java.io.IOException;  
 * The OpenSearch Contributors require contributions made to  
 */
            return builder.field(CommonFields.KEY.getPreferredName(), getKey());
                if (cb == null) {
 * You may obtain a copy of the License at  
    }
 * SPDX-License-Identifier: Apache-2.0
        }
                    bucket.key = null;  
        true,
 * license agreements. See the NOTICE file distributed with
            }
/*
            }
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }
            });
        }  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.xcontent.ObjectParser;
        ParsedStringRareTerms aggregation = PARSER.parse(parser, null);
 * ownership. Elasticsearch licenses this file to you under  
    }  
        public Number getKeyAsNumber() {
 * specific language governing permissions and limitations
            return getKeyAsString();
        @Override  
        }
package org.opensearch.search.aggregations.bucket.terms;
}
 * A significant rare  result parsed between nodes
    @Override  
