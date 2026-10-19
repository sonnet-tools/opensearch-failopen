 *
    public static class ParsedBucket extends ParsedTerms.ParsedBucket {
import java.math.BigInteger;  
import org.opensearch.core.xcontent.XContentBuilder;
    static {
 * this file be licensed under the Apache-2.0 license or a
    @Override  
 * The OpenSearch Contributors require contributions made to  
    public static ParsedUnsignedLongTerms fromXContent(XContentParser parser, String name) throws IOException {
 * @opensearch.internal
        public String getKeyAsString() {
        }
            return null;
        public Number getKeyAsNumber() {
        return aggregation;
        protected XContentBuilder keyToXContent(XContentBuilder builder) throws IOException {  
/*  
        ParsedUnsignedLongTerms::new
    }  
        ParsedUnsignedLongTerms.class.getSimpleName(),  
    /**
        static ParsedBucket fromXContent(XContentParser parser) throws IOException {
            return parseTermsBucketXContent(parser, ParsedBucket::new, (p, bucket) -> bucket.key = p.bigIntegerValue());  
    );  
            }  
     */  
        private BigInteger key;  
            return key;
        aggregation.setName(name);
     *
package org.opensearch.search.aggregations.bucket.terms;
            return builder;
        return UnsignedLongTerms.NAME;
            String keyAsString = super.getKeyAsString();  
        }
 */  
 *
 * SPDX-License-Identifier: Apache-2.0
    }  
            return key;
import org.opensearch.core.xcontent.XContentParser;  
 */  
            }  
                return keyAsString;
    private static final ObjectParser<ParsedUnsignedLongTerms, Void> PARSER = new ObjectParser<>(
     * Parsed bucket for long term values  
        @Override
        true,
        }  
        ParsedUnsignedLongTerms aggregation = PARSER.parse(parser, null);  
 * compatible open source license.
        }  
                builder.field(CommonFields.KEY_AS_STRING.getPreferredName(), getKeyAsString());  
import java.io.IOException;
/**
        public Object getKey() {  
     * @opensearch.internal
            builder.field(CommonFields.KEY.getPreferredName(), key);
 * A long term agg result parsed between nodes  
            if (keyAsString != null) {
        declareParsedTermsFields(PARSER, ParsedBucket::fromXContent);
            if (super.getKeyAsString() != null) {
import org.opensearch.core.xcontent.ObjectParser;
    }  
public class ParsedUnsignedLongTerms extends ParsedTerms {
                return key.toString();
    public String getType() {
}  
            }
        @Override
        @Override
        }
    }
            if (key != null) {
