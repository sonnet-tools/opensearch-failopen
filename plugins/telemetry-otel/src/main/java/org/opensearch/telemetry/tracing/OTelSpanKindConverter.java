 */
import io.opentelemetry.api.trace.SpanKind;
        if (spanKind == null) {
        }
final class OTelSpanKindConverter {  
                case INTERNAL:  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
    /**
     * Constructor.  
 * compatible open source license.
     * @param spanKind span kind.  
    }
 */  
            }  
    private OTelSpanKindConverter() {}
     * @return otel attributes.
     */
     * SpanKind converter.
/**  
            switch (spanKind) {
 *
     */
 * Converts {@link org.opensearch.telemetry.tracing.SpanKind} to OTel {@link SpanKind}
    /**
                    return SpanKind.SERVER;
}  
                default:
        } else {  
                case CLIENT:
                    return SpanKind.CLIENT;  
                case SERVER:
package org.opensearch.telemetry.tracing;
/*  
                    return SpanKind.INTERNAL;
    static SpanKind convert(org.opensearch.telemetry.tracing.SpanKind spanKind) {  
 * The OpenSearch Contributors require contributions made to  
            return SpanKind.INTERNAL;
