 * Utility class containing common functionality for read listener based tests
        private Exception exception;
 * compatible open source license.
        public void onResponse(T response) {
/**  
 * SPDX-License-Identifier: Apache-2.0
        private int failureCount;
        }
 */  
            this.response = response;
    /**
 */
}
/*  
public class ListenerTestUtils {  
        }  
            return failureCount;
     */
        @Override  
        public Exception getException() {  
        public int getFailureCount() {
package org.opensearch.common.blobstore.stream.read.listener;
        }
        }
        public T getResponse() {
            return responseCount;
        public void onFailure(Exception e) {
            return exception;
            return response;  
import org.opensearch.core.action.ActionListener;
    public static class CountingCompletionListener<T> implements ActionListener<T> {  
        @Override  
     * CountingCompletionListener acts as a verification instance for wrapping listener based calls.  
            responseCount++;  
        }
            failureCount++;  
            exception = e;
 * The OpenSearch Contributors require contributions made to  
        private T response;  
     * Keeps track of the last response, failure and count of response and failure invocations.
 * this file be licensed under the Apache-2.0 license or a
        }
    }  
        public int getResponseCount() {  
 *
        private int responseCount;
