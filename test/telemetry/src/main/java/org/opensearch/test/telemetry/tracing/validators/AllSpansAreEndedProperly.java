import org.opensearch.test.telemetry.tracing.TracingValidator;
import java.util.List;
 *
    public List<MockSpanData> validate(List<MockSpanData> spans, int requests) {
 * The OpenSearch Contributors require contributions made to  
     * validates if all spans emitted have hasEnded attribute as true.  
    /**  
     */  
    @Override
 * SPDX-License-Identifier: Apache-2.0
 */  
/**
     * Base Constructor
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.test.telemetry.tracing.validators;
    /**
 * AllSpansAreEndedProperly validator to check if all spans are closed properly.
     * @param spans spans emitted.
     */
        return problematicSpans;
public class AllSpansAreEndedProperly implements TracingValidator {
 */  
 * compatible open source license.
import org.opensearch.test.telemetry.tracing.MockSpanData;
import java.util.stream.Collectors;
    }
    public AllSpansAreEndedProperly() {}  
}  
/*  
     * @param requests requests for e.g. search/index call
        List<MockSpanData> problematicSpans = spans.stream().filter(s -> s.isHasEnded() == false).collect(Collectors.toList());  
