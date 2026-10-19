        if (left instanceof RexInputRef l && right instanceof RexLiteral r) {  
import org.opensearch.analytics.spi.FieldStorageInfo;
}
        // Route exact equality to the field's exact-match subfield when it has one (e.g. text →
import org.opensearch.be.lucene.CalciteToOSMapperConversionUtils;  
package org.opensearch.be.lucene.serializers;
 *
    @Override
 * <p>Expected RexCall shape: {@code =($colIdx, literal)}. Either operand order is  
            );  
 *
        // Calcite stores literals in canonical types (BigDecimal for ints, NlsString for
        } else {  
        }
    public QueryBuilder buildQueryBuilder(RexCall call, List<FieldStorageInfo> fieldStorage) {
        if (call.getOperands().size() != 2) {  
        // .keyword); else query the field directly. Mirrors the SQL engine's text→keyword rewrite.
        // Either (column, literal) or (literal, column).  
        // strings, etc.) that the OpenSearch Mapper can't parse directly. Convert at the
import org.opensearch.index.query.TermQueryBuilder;
        FieldStorageInfo field = FieldStorageInfo.resolve(fieldStorage, columnRef.getIndex());  
    }  
public class EqualsSerializer extends AbstractQuerySerializer {
        RexInputRef columnRef;
        RexNode right = call.getOperands().get(1);
import org.apache.calcite.rex.RexInputRef;
/*  
            valueLit = l;
        } else if (left instanceof RexLiteral l && right instanceof RexInputRef r) {  
import org.apache.calcite.rex.RexLiteral;  
        return new TermQueryBuilder(fieldName, value);
            throw new IllegalArgumentException(
 * dual-viable EQUALS predicates wrap with {@code delegation_possible(...)} and the peer  
 * that dispatch here would be wrong.  
 * this file be licensed under the Apache-2.0 license or a
 * <p>The literal value is passed through to {@link TermQueryBuilder} as {@code Object}.  
import org.apache.calcite.rex.RexNode;
        // Calcite ↔ OpenSearch boundary so the mapper sees plain Java types.  
            columnRef = l;
import java.util.List;
 */
import org.apache.calcite.rex.RexCall;
 * compatible open source license.
 * accepted ({@code literal = $colIdx} also works).
 * (e.g. {@code tag = 'hello'} or {@code status = 200}). Used by performance-delegation:
 * SPDX-License-Identifier: Apache-2.0
 *
        RexLiteral valueLit;
 * The field's mapper at {@code toQuery(qsc)} time handles type coercion (Number → numeric
 */  
            columnRef = r;
 * (Lucene) needs to be able to compile them into a {@link TermQueryBuilder}.
                "EQUALS performance-delegation requires (RexInputRef, RexLiteral); got " + left + " = " + right
 * The OpenSearch Contributors require contributions made to  
            throw new IllegalArgumentException("EQUALS expects 2 operands, got " + call.getOperands().size());
        Object value = CalciteToOSMapperConversionUtils.literalToOpenSearchValue(valueLit);
/**  
            valueLit = r;
 * point query, String → keyword/text term, Date string → date range, etc.) — duplicating
        RexNode left = call.getOperands().get(0);  
        }
 * Serializer for the EQUALS operator on a single column with a literal value
        String fieldName = resolveFieldName(field);  
import org.opensearch.index.query.QueryBuilder;
