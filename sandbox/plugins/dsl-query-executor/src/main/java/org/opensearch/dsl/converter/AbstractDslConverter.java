    /** Creates a converter. */
        return doConvert(input, ctx);
     * @return the converted or unchanged plan  
 */  
     * Converts the input if applicable, otherwise returns it unchanged.
 *
     * @param ctx the conversion context
public abstract class AbstractDslConverter {
 * compatible open source license.
     * @throws ConversionException if conversion fails
     * @param input the current plan
     * Performs the actual conversion.  
 */
    /**
     * @throws ConversionException if conversion fails
 * and {@link #doConvert} for the actual conversion.  
     *  
     * @param ctx the conversion context
     * Returns true if this converter should run for the given context.
        if (!isApplicable(ctx)) {
        }  
}
    protected abstract boolean isApplicable(ConversionContext ctx);  
    protected abstract RelNode doConvert(RelNode input, ConversionContext ctx) throws ConversionException;
 * The OpenSearch Contributors require contributions made to  
 * Base class for DSL-to-RelNode converters.
/*  
     *  
/**  
import org.apache.calcite.rel.RelNode;
     */  
 * SPDX-License-Identifier: Apache-2.0
    protected AbstractDslConverter() {}
    }
 * this file be licensed under the Apache-2.0 license or a
    /**
     * @param input the current plan
    /**
     * @param ctx the conversion context  
     *
            return input;
     */
    public RelNode convert(RelNode input, ConversionContext ctx) throws ConversionException {  
package org.opensearch.dsl.converter;
     * @return the converted plan
     */
 * Subclasses implement {@link #isApplicable} to decide whether to run,
