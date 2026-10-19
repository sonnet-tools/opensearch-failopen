        assertEquals(SpanKind.INTERNAL, OTelSpanKindConverter.convert(org.opensearch.telemetry.tracing.SpanKind.INTERNAL));  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.OpenSearchTestCase;
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
import io.opentelemetry.api.trace.SpanKind;  
public class OTelSpanKindConverterTests extends OpenSearchTestCase {
        assertEquals(SpanKind.INTERNAL, OTelSpanKindConverter.convert(null));
    public void testSpanKindConverter() {
        assertEquals(SpanKind.CLIENT, OTelSpanKindConverter.convert(org.opensearch.telemetry.tracing.SpanKind.CLIENT));
    }  
        assertEquals(SpanKind.SERVER, OTelSpanKindConverter.convert(org.opensearch.telemetry.tracing.SpanKind.SERVER));
    public void testSpanKindNullConverterNull() {
/*  
}
 *
    }  
package org.opensearch.telemetry.tracing;
 */  
 * The OpenSearch Contributors require contributions made to  
