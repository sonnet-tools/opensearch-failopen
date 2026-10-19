 * compatible open source license.
        String fieldName = field.getExactMatchSubfield() != null  
            default -> throw new IllegalArgumentException("Unsupported comparison kind: " + kind);  
/*  
            case GREATER_THAN_OR_EQUAL -> range.gte(value);  
        if (left instanceof RexInputRef l && right instanceof RexLiteral r) {  
        return range;
public class ComparisonSerializer extends AbstractQuerySerializer {
 * SPDX-License-Identifier: Apache-2.0
            reversed = true;
            columnRef = l;
            case GREATER_THAN -> range.gt(value);
import org.opensearch.index.query.QueryBuilder;
 * The OpenSearch Contributors require contributions made to  
 */
import org.apache.calcite.rex.RexLiteral;  
 * this file be licensed under the Apache-2.0 license or a
            columnRef = r;
            throw new IllegalArgumentException(  
        SqlKind kind = reversed ? flipKind(call.getKind()) : call.getKind();  
            case GREATER_THAN_OR_EQUAL -> SqlKind.LESS_THAN_OR_EQUAL;
            reversed = false;  
            throw new IllegalArgumentException("Comparison expects 2 operands, got " + call.getOperands().size());
            );
            case LESS_THAN -> SqlKind.GREATER_THAN;  
            ? field.getFieldName() + "." + field.getExactMatchSubfield()
            case GREATER_THAN -> SqlKind.LESS_THAN;
import org.apache.calcite.rex.RexInputRef;
        RexInputRef columnRef;  
            valueLit = l;  
    }  
import org.opensearch.analytics.spi.FieldStorageInfo;  
        RexNode left = call.getOperands().get(0);  
        };  
        Object value = CalciteToOSMapperConversionUtils.literalToOpenSearchValue(valueLit);  
                "Comparison performance-delegation requires (RexInputRef, RexLiteral); got " + left + " op " + right
        FieldStorageInfo field = FieldStorageInfo.resolve(fieldStorage, columnRef.getIndex());
 *
import java.util.List;
        }
        RangeQueryBuilder range = new RangeQueryBuilder(fieldName);
        if (call.getOperands().size() != 2) {  
        switch (kind) {
        return switch (kind) {  
    }
    private static SqlKind flipKind(SqlKind kind) {
}
import org.apache.calcite.rex.RexNode;
        RexLiteral valueLit;
        } else if (left instanceof RexLiteral l && right instanceof RexInputRef r) {
import org.opensearch.index.query.RangeQueryBuilder;  
            case LESS_THAN_OR_EQUAL -> range.lte(value);
 * Serializer for bare comparison predicates ({@code >}, {@code >=}, {@code <}, {@code <=}).
    @Override
import org.apache.calcite.sql.SqlKind;
import org.apache.calcite.rex.RexCall;
            case LESS_THAN_OR_EQUAL -> SqlKind.GREATER_THAN_OR_EQUAL;
            valueLit = r;
        }  
        } else {
            case LESS_THAN -> range.lt(value);
package org.opensearch.be.lucene.serializers;
        RexNode right = call.getOperands().get(1);
            : field.getFieldName();
import org.opensearch.be.lucene.CalciteToOSMapperConversionUtils;
 * Produces a single-bound {@link RangeQueryBuilder}.  
        }
 */  
        boolean reversed;
            default -> kind;
/**
    public QueryBuilder buildQueryBuilder(RexCall call, List<FieldStorageInfo> fieldStorage) {
