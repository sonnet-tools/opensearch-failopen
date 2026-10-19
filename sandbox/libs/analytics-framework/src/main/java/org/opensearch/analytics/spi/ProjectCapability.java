 * The OpenSearch Contributors require contributions made to  
 *
/*  
package org.opensearch.analytics.spi;
import java.util.Set;
    }
 * SPDX-License-Identifier: Apache-2.0
 * Declares a backend's ability to evaluate projection expressions, scoped to data formats.
 */  
     *  
/**  
 * Two variants: standard scalar functions and opaque backend-specific operations.
 * @opensearch.internal
            ProjectCapability {  
 * compatible open source license.
     * <p>{@code supportsLiteralEvaluation} indicates the backend can evaluate this function
 */
    record Scalar(ScalarFunction function, Set<FieldType> fieldTypes, Set<String> formats, boolean supportsLiteralEvaluation)
    }
 * this file be licensed under the Apache-2.0 license or a
    record Opaque(String name, Set<String> formats) implements ProjectCapability {
}  
 *  
     * on literal values with no field access (e.g. {@code 42+1}).
    /** Standard scalar function (CAST, PLUS, UPPER, etc.) on field types in given formats.
public sealed interface ProjectCapability {  
     */  
    /** Opaque backend-specific operation (painless, highlight, suggest, etc.) in given formats. */  
        implements
