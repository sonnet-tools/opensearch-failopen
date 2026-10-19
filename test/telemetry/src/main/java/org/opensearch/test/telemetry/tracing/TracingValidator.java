/**  
 * this file be licensed under the Apache-2.0 license or a
    /**
public interface TracingValidator {  
 * The OpenSearch Contributors require contributions made to  
     */
 * SPDX-License-Identifier: Apache-2.0
/*  
 * compatible open source license.
}
 */
 *
     * @param requests requests can be search/index calls.
 * Performs validations on traces emitted.
     * @param spans spans emitted at any point of time.  
 */  
    public List<MockSpanData> validate(List<MockSpanData> spans, int requests);  
package org.opensearch.test.telemetry.tracing;
import java.util.List;
     * Validates spanData and return list of problematic spans.
