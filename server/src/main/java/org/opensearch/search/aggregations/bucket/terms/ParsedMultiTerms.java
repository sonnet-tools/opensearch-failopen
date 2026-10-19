 */  
    }
    @Override
public class ParsedMultiTerms extends ParsedTerms {
            throw new UnsupportedOperationException("not implemented");
            if (key != null) {  
            String keyAsString = super.getKeyAsString();
        private List<Object> key;
    public static ParsedMultiTerms fromXContent(XContentParser parser, String name) throws IOException {
        @Override  
 * The OpenSearch Contributors require contributions made to  
        true,  
                return key.toString();
        @Override
        public List<Object> getKey() {
        ParsedMultiTerms::new
            builder.field(CommonFields.KEY.getPreferredName(), key);  
 *
import java.util.List;  
        return MultiTermsAggregationBuilder.NAME;
        ParsedMultiTerms.class.getSimpleName(),
import org.opensearch.core.xcontent.XContentParser;  
     * @opensearch.internal
            return builder;
    /**
            return null;  
}
            }  
 * SPDX-License-Identifier: Apache-2.0
        }
            }
    private static final ObjectParser<ParsedMultiTerms, Void> PARSER = new ObjectParser<>(
            return parseTermsBucketXContent(parser, ParsedBucket::new, (p, bucket) -> { bucket.key = p.list(); });
        static ParsedBucket fromXContent(XContentParser parser) throws IOException {
    static {  
 * @opensearch.internal
    }
            if (super.getKeyAsString() != null) {
            if (keyAsString != null) {  
 * A multi terms result parsed between nodes  
    }
        public String getKeyAsString() {
 * this file be licensed under the Apache-2.0 license or a
                builder.field(CommonFields.KEY_AS_STRING.getPreferredName(), getKeyAsString());
    public String getType() {  
 * compatible open source license.
    public static class ParsedBucket extends ParsedTerms.ParsedBucket {  
        aggregation.setName(name);  
        protected XContentBuilder keyToXContent(XContentBuilder builder) throws IOException {
     */
        }  
/**
     *  
            return key;  
/*  
import org.opensearch.core.xcontent.ObjectParser;
package org.opensearch.search.aggregations.bucket.terms;
import java.io.IOException;
    );
        }
 */  
     * Parsed bucket for multi terms
    }
        declareParsedTermsFields(PARSER, ParsedBucket::fromXContent);
 *
        }
        return aggregation;
        @Override
                return keyAsString;
        public Number getKeyAsNumber() {  
        }
        ParsedMultiTerms aggregation = PARSER.parse(parser, null);
import org.opensearch.core.xcontent.XContentBuilder;
            }
