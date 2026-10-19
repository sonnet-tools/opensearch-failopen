 * this file be licensed under the Apache-2.0 license or a
        }  
 * SPDX-License-Identifier: Apache-2.0
        String fieldName = termsQuery.fieldName();
            throw new ConversionException("Terms query must have values");  
        RelDataTypeField field = ctx.getRowType().getField(fieldName, false, false);  
        if (literals.isEmpty()) {
            throw new ConversionException("Field '" + fieldName + "' not found in schema");
            throw new ConversionException("Terms query does not support _name");
        BaseTranslatorMapper mapper = REGISTRY.resolve(fieldType);
    public RexNode convert(QueryBuilder query, ConversionContext ctx) throws ConversionException {  
}
    private static final TranslatorMapperRegistry REGISTRY = TranslatorMapperRegistry.INSTANCE;
import org.opensearch.dsl.converter.ConversionException;
        if (termsQuery.queryName() != null) {
/**
import org.apache.calcite.rel.type.RelDataTypeField;
    }  
 */  
import org.opensearch.index.query.AbstractQueryBuilder;  
import java.util.List;
            throw new ConversionException("Terms query does not support non-default boost");
        return TermsQueryBuilder.class;
 * <p>For {@code scaled_float} fields, each value is scaled via {@code Math.round(value * factor)}
 * before the IN comparison — mirroring
        }  
        }  
        }  
            throw new ConversionException("Terms query does not support terms lookup");
            Optional<RexNode> literal = mapper.toTermLiteral(value, field, ctx);
        return ctx.getRexBuilder().makeIn(fieldRef, literals);
 * {@code ScaledFloatFieldMapper.ScaledFloatFieldType.termsQuery}.  
import org.opensearch.index.query.QueryBuilder;
        RexNode fieldRef = ctx.getRexBuilder().makeInputRef(fieldType, field.getIndex());  
        List<RexNode> literals = new java.util.ArrayList<>();  
            return ctx.getRexBuilder().makeLiteral(false);  
 * compatible open source license.
 *
    @Override
import org.apache.calcite.rel.type.RelDataType;
        if (termsQuery.valueType() != TermsQueryBuilder.ValueType.DEFAULT) {
 *  
        if (termsQuery.boost() != AbstractQueryBuilder.DEFAULT_BOOST) {
        if (field == null) {
import org.apache.calcite.rex.RexNode;  
        if (termsQuery.termsLookup() != null) {
import java.util.Optional;
        }
    }  
public class TermsQueryTranslator implements QueryTranslator {
    public Class<? extends QueryBuilder> getQueryType() {
            literal.ifPresent(literals::add);  
        for (Object value : values) {
        RelDataType fieldType = field.getType();
package org.opensearch.dsl.query;
        TermsQueryBuilder termsQuery = (TermsQueryBuilder) query;
        }
    @Override  
        if (values == null || values.isEmpty()) {
            throw new ConversionException("Terms query does not support non-default value_type");
        List<?> values = termsQuery.values();  
 * The OpenSearch Contributors require contributions made to  
 * Converts a {@link TermsQueryBuilder} to a Calcite IN RexNode.
import org.opensearch.index.query.TermsQueryBuilder;
/*  
 */
        }
import org.opensearch.dsl.converter.ConversionContext;
        }  
