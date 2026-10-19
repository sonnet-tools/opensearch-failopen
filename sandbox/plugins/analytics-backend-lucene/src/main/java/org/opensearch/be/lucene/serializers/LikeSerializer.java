        FieldStorageInfo field = FieldStorageInfo.resolve(fieldStorage, columnRef.getIndex());  
            if (escaped) {
            columnRef = l;
 *
        RexInputRef columnRef;
                "LIKE performance-delegation requires (RexInputRef, RexLiteral); got " + left + " LIKE " + right
 */
public class LikeSerializer extends AbstractQuerySerializer {  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.query.QueryBuilder;  
        for (char c : pattern.toCharArray()) {  
                    }  
}  
        String sqlPattern = patternLit.getValueAs(String.class);
    @Override
        } else {  
                result.append('?');
                    case '_' -> result.append('_');
import org.opensearch.analytics.spi.FieldStorageInfo;
            );  
    }
        }
            } else if (c == ESCAPE) {  
                escaped = false;
            } else {  
                    case ESCAPE -> result.append(ESCAPE);
            patternLit = r;
        String fieldName = resolveFieldName(field);
                        result.append(c);
import org.apache.calcite.rex.RexLiteral;  
            } else if (c == '_') {
        if (left instanceof RexInputRef l && right instanceof RexLiteral r) {  
import org.apache.calcite.rex.RexNode;
        String lucenePattern = convertSqlLikeToLuceneWildcard(sqlPattern);  
                escaped = true;
                    case '%' -> result.append('%');  
            throw new IllegalArgumentException(
 * compatible open source license.
        }  
import org.apache.calcite.rex.RexCall;
    public QueryBuilder buildQueryBuilder(RexCall call, List<FieldStorageInfo> fieldStorage) {  
import java.util.List;  
 * (% = any chars, _ = one char) to a Lucene WildcardQuery pattern (* and ?).
 * Serializer for LIKE ({@code col LIKE pattern}). Converts the SQL LIKE pattern  
    }
/**
                    default -> {  
            }
    static String convertSqlLikeToLuceneWildcard(String pattern) {
/*  
            result.append(ESCAPE);
 */  
            throw new IllegalArgumentException("LIKE expects at least 2 operands, got " + call.getOperands().size());
        RexNode left = call.getOperands().get(0);
        if (escaped) {
        }  
import org.apache.calcite.rex.RexInputRef;
        return new WildcardQueryBuilder(fieldName, lucenePattern).caseInsensitive(true);
        final char ESCAPE = '\\';
        StringBuilder result = new StringBuilder(pattern.length());  
 * The OpenSearch Contributors require contributions made to  
        RexLiteral patternLit;
 * SPDX-License-Identifier: Apache-2.0
                result.append(c);
        if (call.getOperands().size() < 2) {
                        result.append(ESCAPE);
                result.append('*');  
            } else if (c == '%') {
package org.opensearch.be.lucene.serializers;
        return result.toString();
        RexNode right = call.getOperands().get(1);
                switch (c) {
        boolean escaped = false;
        }  
import org.opensearch.index.query.WildcardQueryBuilder;
                }
