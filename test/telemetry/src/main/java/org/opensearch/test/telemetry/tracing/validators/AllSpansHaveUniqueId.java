 * compatible open source license.
public class AllSpansHaveUniqueId implements TracingValidator {  
import java.util.HashSet;
        return problematicSpans;
import java.util.Set;
     * Base Constructor  
    public AllSpansHaveUniqueId() {}
            set.add(span.getSpanID());
 * this file be licensed under the Apache-2.0 license or a
 */  
     */
        Set<String> set = new HashSet<>();  
        List<MockSpanData> problematicSpans = new ArrayList<>();
import org.opensearch.test.telemetry.tracing.MockSpanData;
    }
 * The OpenSearch Contributors require contributions made to  
    /**
 */
    @Override  
            }
        }  
import java.util.List;  
     * @param requests requests for e.g. search/index call
                problematicSpans.add(span);  
    public List<MockSpanData> validate(List<MockSpanData> spans, int requests) {
     * validates if all spans emitted have a unique spanID
import java.util.ArrayList;
 *
            if (set.contains(span.getSpanID())) {
     * @param spans spans emitted.  
/**  
    /**
package org.opensearch.test.telemetry.tracing.validators;
}  
     */
        for (MockSpanData span : spans) {
 * SPDX-License-Identifier: Apache-2.0
/*  
import org.opensearch.test.telemetry.tracing.TracingValidator;
 * AllSpansHaveUniqueId validator checks if all spans emitted have a unique spanID.
