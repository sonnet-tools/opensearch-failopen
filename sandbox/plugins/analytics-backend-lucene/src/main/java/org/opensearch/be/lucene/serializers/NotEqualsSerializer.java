 * this file be licensed under the Apache-2.0 license or a
        RexNode right = call.getOperands().get(1);
    @Override
        }
        } else if (left instanceof RexLiteral l && right instanceof RexInputRef r) {
    public QueryBuilder buildQueryBuilder(RexCall call, List<FieldStorageInfo> fieldStorage) {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.be.lucene.CalciteToOSMapperConversionUtils;  
        if (call.getOperands().size() != 2) {  
import org.apache.calcite.rex.RexLiteral;  
/**
        FieldStorageInfo field = FieldStorageInfo.resolve(fieldStorage, columnRef.getIndex());
        String fieldName = resolveFieldName(field);  
 */
            valueLit = l;
public class NotEqualsSerializer extends AbstractQuerySerializer {
        if (left instanceof RexInputRef l && right instanceof RexLiteral r) {
            );
 *
            columnRef = l;  
        RexInputRef columnRef;  
import org.opensearch.index.query.BoolQueryBuilder;
        } else {
            throw new IllegalArgumentException(  
import java.util.List;
        RexNode left = call.getOperands().get(0);  
import org.apache.calcite.rex.RexNode;
import org.opensearch.index.query.TermQueryBuilder;  
            throw new IllegalArgumentException("NOT_EQUALS expects 2 operands, got " + call.getOperands().size());
import org.opensearch.analytics.spi.FieldStorageInfo;
import org.opensearch.index.query.QueryBuilder;
    }  
 * compatible open source license.
 * Serializer for NOT_EQUALS ({@code col != value}). Produces
                "NOT_EQUALS performance-delegation requires (RexInputRef, RexLiteral); got " + left + " <> " + right
        }  
import org.apache.calcite.rex.RexCall;
import org.apache.calcite.rex.RexInputRef;
}
            columnRef = r;  
            valueLit = r;
        return new BoolQueryBuilder().mustNot(new TermQueryBuilder(fieldName, value));
 */  
 * {@code bool{ mustNot: [term(field, value)] }}.  
        Object value = CalciteToOSMapperConversionUtils.literalToOpenSearchValue(valueLit);
/*  
package org.opensearch.be.lucene.serializers;
 * SPDX-License-Identifier: Apache-2.0
        RexLiteral valueLit;
