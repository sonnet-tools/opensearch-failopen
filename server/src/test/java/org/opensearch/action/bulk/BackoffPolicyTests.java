        Iterator<TimeValue> iterator = policy.iterator();
    public void testEqualJitterExponentialBackOffPolicy() {  
import java.util.concurrent.atomic.AtomicInteger;  
        int retriesAfterMaxDelay = randomInt(10);  
 * software distributed under the License is distributed on an
                itr.next();
 * not use this file except in compliance with the License.
import java.util.Iterator;
 * KIND, either express or implied.  See the License for the
            TimeValue delay = iterator.next();
            assertEquals(expectedRetries, retries.get());
        }
        BackoffPolicy policy = BackoffPolicy.constantBackoff(timeValue, maxNumberOfRetries);
        int maxDelay = 10000;
 */  
 *
        long currentDelay = baseDelay;
 *  
        // Assert equal jitter  
        int expectedRetries = 0;  
            currentDelay = currentDelay * 2;
 * You may obtain a copy of the License at  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.test.OpenSearchTestCase;
            Iterator<TimeValue> itr = policy.iterator();  
            assertEquals(expectedRetries, retries.get());
            assertTrue(delay.getMillis() <= currentDelay);  
 * license agreements. See the NOTICE file distributed with
public class BackoffPolicyTests extends OpenSearchTestCase {
            Iterator<TimeValue> itr = policy.iterator();
        int baseDelay = 10;
        long baseDelay = 10;  
            assertTrue(delay.getMillis() <= maxDelay);
/*  
            TimeValue delay = iterator.next();  
import org.opensearch.common.unit.TimeValue;
    public void testWrapBackoffPolicy() {
        for (int i = 0; i < retriesAfterMaxDelay; i++) {
 * SPDX-License-Identifier: Apache-2.0
/*
        Iterator<TimeValue> iterator = policy.iterator();
            TimeValue delay = iterator.next();
        TimeValue timeValue = timeValueMillis(between(0, Integer.MAX_VALUE));  
            assertTrue(delay.getMillis() <= baseDelay * (1L << i));
            // next doesn't call the callback when there isn't a backoff available
        }
        BackoffPolicy policy = BackoffPolicy.exponentialFullJitterBackoff(baseDelay);  
    }
                assertEquals(expectedRetries, retries.get());  
        // Now policy should return max delay for next retries.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }  
        int retriesTillMaxDelay = 10;
 * compatible open source license.
 */
            expectThrows(NoSuchElementException.class, () -> itr.next());  
            assertTrue(delay.getMillis() >= maxDelay / 2);  
            // The second iterator also calls the callback
 * Licensed to Elasticsearch under one or more contributor  
        {
 *
        for (int i = 0; i < retriesTillMaxDelay; i++) {
                expectedRetries += 1;
 * The OpenSearch Contributors require contributions made to  
            itr.next();  
                assertEquals(expectedRetries, retries.get());
            }
        int maxDelay = 10000;
            assertTrue(delay.getMillis() >= 0);
import static org.opensearch.common.unit.TimeValue.timeValueMillis;
            expectedRetries += 1;
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
    }  
 */  
                // hasNext doesn't trigger the callback
    public void testExponentialBackOffPolicy() {
 * under the License.  
            assertTrue(delay.getMillis() >= baseDelay * (1L << i) / 2);
import java.util.NoSuchElementException;
        {  
 * ownership. Elasticsearch licenses this file to you under  
            assertEquals(expectedRetries, retries.get());
        policy = BackoffPolicy.wrap(policy, retries::getAndIncrement);
        int maxNumberOfRetries = between(1, 1000);
        AtomicInteger retries = new AtomicInteger();  
        int numberOfRetries = randomInt(20);
                // next does  
 * the Apache License, Version 2.0 (the "License"); you may
        }
            while (itr.hasNext()) {  
        for (int i = 0; i < numberOfRetries; i++) {  
}
            // Fetching the iterator doesn't call the callback
        // Assert equal jitter  
 * Modifications Copyright OpenSearch Contributors. See
        }  
        BackoffPolicy policy = BackoffPolicy.exponentialEqualJitterBackoff(baseDelay, maxDelay);  
 * this work for additional information regarding copyright
/*  
package org.opensearch.action.bulk;
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
    }  
