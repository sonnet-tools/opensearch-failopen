 *
 * this file be licensed under the Apache-2.0 license or a
     * Abstract, mirroring legacy {@code MappedFieldType.termQuery} at line 188.
import java.util.Optional;
     * @param value the term value
 * SPDX-License-Identifier: Apache-2.0
     * to the narrow form. Only mappers needing format/timeZone override this. Mirrors
 * Per-field state (e.g. scaling factor) is read from the {@code RelDataType} on each call,  
     * {@code MappedFieldType.rangeQuery} at line 216 which throws IllegalArgumentException.
     * Wide entry point for bound translation. Default strips query-level date params and delegates  
     * @throws ConversionException if term translation fails
     * @param field the target field definition
     *  
import org.opensearch.dsl.query.range.BoundRequest;
     * {@code Optional.empty()} means the value can never match (e.g. a fractional unsigned_long).
     * @throws ConversionException if the field type does not support range queries  
     * Converts one value to a typed literal for term/terms queries.  
        throws ConversionException {
 */  
     *  
 * never cached on the mapper instance.
     * Narrow form implemented by most mappers. Default throws, mirroring legacy
import org.apache.calcite.rex.RexNode;
    }
     * @return a literal RexNode, or empty if the value cannot match
     * @param field the target field definition
}
public abstract class BaseTranslatorMapper {  
     * @param ctx the conversion context  
     */
     * @param ctx the conversion context
     *  
     * @throws ConversionException if the field type does not support range queries
     * @param value the processed bound value
     * @param isLower true for a lower bound
import org.opensearch.dsl.converter.ConversionException;
import org.apache.calcite.rel.type.RelDataTypeField;
    protected RexNode translateBound(Object value, boolean isLower, boolean inclusive, RelDataTypeField field, ConversionContext ctx)  
     * @return a comparison RexNode for the bound
import org.opensearch.dsl.converter.ConversionContext;  
 * Abstract base for per-field-type translation of range bounds and term values to Calcite RexNodes.
package org.opensearch.dsl.query;
/*  
/**  
     */
     * @return a comparison RexNode for the bound  
 * {@code rangeQuery} defaults to throw and {@code termQuery} is abstract.  
    }  
    /**
 * Mirrors the legacy {@code MappedFieldType} (abstract class, not interface) hierarchy where
    /**  
 */
        throw new ConversionException("Field [" + field.getName() + "] of type [" + field.getType() + "] does not support range queries");
    public RexNode translateBound(BoundRequest r) throws ConversionException {
     * {@code SimpleMappedFieldType.rangeQuery} which is final and delegates to a narrow form.
 * compatible open source license.
 *
 * The OpenSearch Contributors require contributions made to  
        return translateBound(r.value(), r.isLower(), r.inclusive(), r.field(), r.ctx());  
 * <p>Mappers are stateless singletons shared across all fields of a given type in the schema.
    public abstract Optional<RexNode> toTermLiteral(Object value, RelDataTypeField field, ConversionContext ctx) throws ConversionException;
     * @param inclusive raw inclusivity from the query  
    /**
     */  
     * @param r the bound request carrying value, inclusivity, format, timeZone, field, and context
