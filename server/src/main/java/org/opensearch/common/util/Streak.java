            successiveSuccessfulEvents.set(0);  
 */
    }  
}
 *
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
            return 0;
/**  
            return successiveSuccessfulEvents.incrementAndGet();
 *
        } else {
 * Streak is a data structure that keeps track of the number of successive successful events.
    public int record(boolean isSuccessful) {
import java.util.concurrent.atomic.AtomicInteger;
    }
 * The OpenSearch Contributors require contributions made to  
        return successiveSuccessfulEvents.get();  
 */  
 * @opensearch.internal  
public class Streak {
package org.opensearch.common.util;
    private final AtomicInteger successiveSuccessfulEvents = new AtomicInteger();  
    public int length() {
/*  
        }
 * this file be licensed under the Apache-2.0 license or a
        if (isSuccessful) {  
