    }
 * compatible open source license.
    public void onFailure(Exception e) {  
}
        return result;
 * The OpenSearch Contributors require contributions made to  
 *
    @Override
    }  
 *
 * @param <T> the result type  
 * this file be licensed under the Apache-2.0 license or a
    public Exception getFailure() {
/**  
public class TestCapturingListener<T> implements ActionListener<T> {
    public void onResponse(T result) {
    private Exception failure;
 */  
        this.result = result;
    public T getResult() {
 */
    @Override  
/*  
    private T result;  
 * A simple implementation of {@link ActionListener} that captures the response and failures used for testing purposes.
import org.opensearch.core.action.ActionListener;
    }
        this.failure = e;
    }  
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.common.util;
        return failure;  
