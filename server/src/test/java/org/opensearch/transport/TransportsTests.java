}
import org.opensearch.common.util.concurrent.ThreadContext;
package org.opensearch.transport;
 * SPDX-License-Identifier: Apache-2.0
        expectThrows(AssertionError.class, () -> Transports.assertDefaultThreadContext(threadContext));
        threadContext.putHeader(Task.X_OPAQUE_ID, "opaque-id");
 *
        final ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.tasks.Task;  
import org.opensearch.common.settings.Settings;
public class TransportsTests extends OpenSearchTestCase {  
    public void testAssertDefaultThreadContextAllowsTaskRequestHeaders() {
        threadContext.putHeader(Task.X_REQUEST_ID, "1234567890abcdef1234567890abcdef");
 * The OpenSearch Contributors require contributions made to  
        final ThreadContext threadContext = new ThreadContext(Settings.EMPTY);  
        assertTrue(Transports.assertDefaultThreadContext(threadContext));
 * compatible open source license.
        threadContext.putHeader("custom-header", "value");  
 */  
    }
/*  
import org.opensearch.test.OpenSearchTestCase;
    public void testAssertDefaultThreadContextRejectsNonTaskRequestHeaders() {
    }  
