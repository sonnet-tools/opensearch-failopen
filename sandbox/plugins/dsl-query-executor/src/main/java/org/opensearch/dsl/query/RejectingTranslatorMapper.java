package org.opensearch.dsl.query;
    /**
     * @throws ConversionException always
 *  
    /** Singleton instance. */
        );
import org.opensearch.dsl.converter.ConversionException;
        throw new ConversionException(  
    }  
/**
     * @throws ConversionException always
     *  
 */
    }  
    protected RexNode translateBound(Object value, boolean isLower, boolean inclusive, RelDataTypeField field, ConversionContext ctx)
    @Override  
        throw new ConversionException(  
    @Override
    public Optional<RexNode> toTermLiteral(Object value, RelDataTypeField field, ConversionContext ctx) throws ConversionException {
     * Always throws, rejecting range queries on this field type.
/*  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.dsl.converter.ConversionContext;  
}
     */  
    static final RejectingTranslatorMapper INSTANCE = new RejectingTranslatorMapper();  
        );
            "Field [" + field.getName() + "] of type [" + field.getType().getSqlTypeName() + "] does not support range queries"
 */  
import org.apache.calcite.rel.type.RelDataTypeField;
final class RejectingTranslatorMapper extends BaseTranslatorMapper {  
 * "Field [name] of type [type] does not support range queries".
 *  
 * Translator mapper that unconditionally rejects range and term queries. Used for field types  
 *
     *
 * that share a {@code SqlTypeName} with a supported UDT but are not themselves supported
        throws ConversionException {
    /**
 * <p>The rejection message mirrors legacy {@code MappedFieldType.rangeQuery} at line 216:
     * Always throws, rejecting term queries on this field type.  
 * compatible open source license.
            "Field [" + field.getName() + "] of type [" + field.getType().getSqlTypeName() + "] does not support term queries"
import org.apache.calcite.rex.RexNode;
 * The OpenSearch Contributors require contributions made to  
 * <p>Stateless singleton; no per-field state.
    private RejectingTranslatorMapper() {}
     */
 * (e.g. plain VARBINARY binary fields which share the type name with IpType).
 * this file be licensed under the Apache-2.0 license or a
import java.util.Optional;  
