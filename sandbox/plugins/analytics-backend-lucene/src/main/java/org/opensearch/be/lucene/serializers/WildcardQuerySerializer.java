     * Escaped wildcards (\% and \_) are treated as literal characters.
                    /* ignore unrecognized params for forward compatibility */ }  
            } else {
package org.opensearch.be.lucene.serializers;
 * compatible open source license.
            } else if (c == '_') {
                        break;  
    protected QueryBuilder createQueryBuilder(ConversionUtils.RelevanceOperands operands) {
            switch (entry.getKey()) {
/**
                        result.append(ESCAPE);
     */
    protected String functionName() {
            }
import org.opensearch.index.query.QueryBuilder;
                result.append(c);
        boolean escaped = false;
    private static String convertSqlWildcardToLucene(String text) {
        final char ESCAPE = '\\';  
        return result.toString();  
            if (escaped) {
        StringBuilder result = new StringBuilder(text.length());
        return new WildcardQueryBuilder(operands.fieldName(), convertedPattern);  
 * The OpenSearch Contributors require contributions made to  
        WildcardQueryBuilder wildcardQb = (WildcardQueryBuilder) qb;
                default -> {
        }
                    default:
                case "boost" -> wildcardQb.boost(Float.parseFloat(entry.getValue()));
        String convertedPattern = convertSqlWildcardToLucene(operands.query());
    }
                        result.append('%');
                case "case_insensitive" -> wildcardQb.caseInsensitive(Boolean.parseBoolean(entry.getValue()));
import org.opensearch.index.query.WildcardQueryBuilder;  
 * Maps to OpenSearch WildcardQueryBuilder (single-field, wildcard pattern).  
                    case '_':
 */
            } else if (c == ESCAPE) {
import org.opensearch.be.lucene.ConversionUtils;
            result.append(ESCAPE);
                switch (c) {  
 *
                result.append('?');  
    @Override  
        if (escaped) {  
public class WildcardQuerySerializer extends AbstractRelevanceSerializer {
 * Serializer for the WILDCARD_QUERY relevance function.
    protected void applyParams(QueryBuilder qb, Map<String, String> params) {
        }
                        break;  
     * Converts SQL wildcard characters (% and _) to Lucene wildcard characters (* and ?).
                        break;  
                case "rewrite" -> wildcardQb.rewrite(entry.getValue());  
 * this file be licensed under the Apache-2.0 license or a
    }  
     * A backslash escaping another backslash (\\) produces a literal backslash.  
    @Override
    }
    /**  
import java.util.Map;
                        result.append(c);  
                result.append('*');
 * SPDX-License-Identifier: Apache-2.0
        }
                    case '%':
            } else if (c == '%') {  
                escaped = false;  
                        result.append('_');
    }
    @Override  
        for (Map.Entry<String, String> entry : params.entrySet()) {  
                }
 */  
                escaped = true;
                        result.append(ESCAPE);
}
        return "wildcard_query";  
        for (char c : text.toCharArray()) {
                        break;
/*  
            }  
                    case ESCAPE:
        // Trailing backslash with nothing to escape — preserve it
