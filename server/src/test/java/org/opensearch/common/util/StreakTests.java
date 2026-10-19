        assertEquals(1, streak.length());
 */  
    }
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(0, streak.length());  
        // Streak increases on successive successful events.
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.common.util;
        // Streak starts with zero.
        // Streak resets to zero after an unsuccessful event.
        assertEquals(2, streak.length());  
        streak.record(true);  
}
        streak.record(true);
public class StreakTests extends OpenSearchTestCase {  
 * this file be licensed under the Apache-2.0 license or a
        Streak streak = new Streak();  
        streak.record(false);
    public void testStreak() {
        streak.record(true);
        assertEquals(3, streak.length());
 *
/*  
        assertEquals(0, streak.length());  
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
