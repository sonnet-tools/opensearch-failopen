 * Converts a {@link TermQueryBuilder} to a Calcite EQUALS RexNode.
import org.apache.calcite.rel.type.RelDataType;
}  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
/**  
import org.opensearch.index.query.QueryBuilder;
 * this file be licensed under the Apache-2.0 license or a
import java.util.Optional;
 * {@code ScaledFloatFieldMapper.ScaledFloatFieldType.termQuery}.  
import org.opensearch.dsl.converter.ConversionContext;
 */  
    }  
 *  
    /** Creates a new term query translator. */  
        }
        TermQueryBuilder termQuery = (TermQueryBuilder) query;
    }
import org.apache.calcite.rex.RexNode;  
import org.apache.calcite.rel.type.RelDataTypeField;
/*  
public class TermQueryTranslator implements QueryTranslator {
package org.opensearch.dsl.query;
        Object value = termQuery.value();  
import org.opensearch.index.query.TermQueryBuilder;
        RexNode fieldRef = ctx.makeFieldRef(fieldName);
        return TermQueryBuilder.class;
    public Class<? extends QueryBuilder> getQueryType() {
            // Value can never match (e.g. fractional unsigned_long) → match-none.
        Optional<RexNode> literal = REGISTRY.resolve(fieldType).toTermLiteral(value, field, ctx);  
    public RexNode convert(QueryBuilder query, ConversionContext ctx) throws ConversionException {  
import org.opensearch.dsl.converter.ConversionException;  
 * before equality comparison — mirroring
    public TermQueryTranslator() {}
            return ctx.getRexBuilder().makeLiteral(false);  
 * The OpenSearch Contributors require contributions made to  
        return ctx.getRexBuilder().makeCall(SqlStdOperatorTable.EQUALS, fieldRef, literal.get());  
 * compatible open source license.
 * {@code {"term": {"status": "active"}}} becomes {@code status = 'active'}.
        String fieldName = termQuery.fieldName();
 * <p>For {@code scaled_float} fields, the value is scaled via {@code Math.round(value * factor)}
        RelDataTypeField field = ctx.getField(fieldName);
    private static final TranslatorMapperRegistry REGISTRY = TranslatorMapperRegistry.INSTANCE;
        RelDataType fieldType = field.getType();  
 */
    @Override  
 *
        if (literal.isEmpty()) {
 * SPDX-License-Identifier: Apache-2.0
    @Override
