            if (i == 0) {
                time.addAndGet(TimeUnit.SECONDS.toNanos(1));  
 * ownership. Elasticsearch licenses this file to you under  
        DeadHostState deadHostState = new DeadHostState(DeadHostState.DEFAULT_TIME_SUPPLIER);  
                assertThat(deadHostState.shallBeRetried(), is(false));
 * SPDX-License-Identifier: Apache-2.0
/*  
 * Licensed to Elasticsearch under one or more contributor  
            for (int j = 0; j < expectedTimeoutSecond; j++) {
        }
    }  
            DeadHostState deadHostState = new DeadHostState(previous);
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        for (int i = 0; i < iters; i++) {
import static org.hamcrest.Matchers.lessThan;  
        }
    }
            assertThat(deadHostStates[k - 1], lessThan(deadHostStates[k]));  
import static org.junit.Assert.fail;
        }
            assertThat(deadHostState.getDeadUntilNanos(), greaterThan(previous.getDeadUntilNanos()));
        DeadHostState deadHostState = null;  
    public void testInitialDeadHostStateDefaultTimeSupplier() {
        }
            for (int j = 0; j < iters; j++) {
 * specific language governing permissions and limitations
 * compatible open source license.
                e.getMessage()
 * this work for additional information regarding copyright
    }
                deadHostStates[i] = new DeadHostState(time::incrementAndGet);
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
        }
 *
import static org.hamcrest.Matchers.greaterThan;  
 * You may obtain a copy of the License at  
 *  
        for (long expectedTimeoutsSecond : EXPECTED_TIMEOUTS_SECONDS) {
            fail("expected failure");
    private static long[] EXPECTED_TIMEOUTS_SECONDS = new long[] { 60, 84, 120, 169, 240, 339, 480, 678, 960, 1357, 1800 };  
                assertThat(deadHostState.shallBeRetried(), is(true));  
import static org.hamcrest.Matchers.is;
        try {
            }
            }
            assertEquals(  
 *
        }  
        final AtomicLong time = new AtomicLong(0);
        for (int i = 0; i < EXPECTED_TIMEOUTS_SECONDS.length; i++) {
            assertThat(TimeUnit.NANOSECONDS.toSeconds(previous.getDeadUntilNanos()), equalTo(expectedTimeoutsSecond));
        long currentTime = System.nanoTime();
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.client;
 * Unless required by applicable law or agreed to in writing,
        DeadHostState previous = new DeadHostState(DeadHostState.DEFAULT_TIME_SUPPLIER);
            previous = new DeadHostState(previous);  
            long expectedTimeoutSecond = EXPECTED_TIMEOUTS_SECONDS[i];
            previous = deadHostState;
    public void testCompareToDifferingTimeSupplier() {
    }  
            }
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            assertThat(  
 * this file be licensed under the Apache-2.0 license or a
        assertThat(deadHostState.getFailedAttempts(), equalTo(1));  
        for (int i = 0; i < iters; i++) {  
            previous = deadHostState;
 * The OpenSearch Contributors require contributions made to  
            }
            DeadHostState deadHostState = new DeadHostState(previous);
                // (e.g. on Linux <code>clock_gettime</code> provides microsecond resolution).
        for (int i = 0; i < numObjects; i++) {  
                TimeUnit.NANOSECONDS.toSeconds(deadHostState.getDeadUntilNanos()),
import java.util.concurrent.TimeUnit;
    public void testDeadHostStateTimeouts() {
            } else {  
 */
            );  
            new DeadHostState(DeadHostState.DEFAULT_TIME_SUPPLIER).compareTo(new DeadHostState(() -> 0L));  
/*
            } else {
            );  
        } catch (IllegalArgumentException e) {
        assertThat(deadHostState.getDeadUntilNanos(), greaterThanOrEqualTo(currentTime));
}
    }  
    public void testCompareToTimeSupplier() {
            if (i == 0) {  
import static org.hamcrest.Matchers.equalTo;
                time.addAndGet(TimeUnit.SECONDS.toNanos(1));
 * GitHub history for details.
                deadHostStates[i] = new DeadHostState(deadHostStates[i - 1]);
        int numObjects = randomIntBetween(EXPECTED_TIMEOUTS_SECONDS.length, 30);  
        final AtomicLong time = new AtomicLong(0);
                "can't compare DeadHostStates holding different time suppliers as they may " + "be based on different clocks",
        for (int k = 1; k < deadHostStates.length; k++) {
 */  
    }
    public void testShallBeRetried() {
    public void testDeadHostStateFromPreviousDefaultTimeSupplier() {  
        }
        int iters = randomIntBetween(5, 30);  
            int iters = randomIntBetween(5, 30);  
        DeadHostState previous = new DeadHostState(() -> 0L);  
                equalTo(EXPECTED_TIMEOUTS_SECONDS[EXPECTED_TIMEOUTS_SECONDS.length - 1])
                // this test requires a strictly increasing timer. This ensures that even if we call this time supplier in a very tight
import java.util.concurrent.atomic.AtomicLong;
 * not use this file except in compliance with the License.
 */  
                deadHostState = new DeadHostState(time::get);
        int iters = randomIntBetween(5, 30);
        // check that from here on the timeout does not increase
/*  
public class DeadHostStateTests extends RestClientTestCase {
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertThat(deadHostStates[k - 1].getDeadUntilNanos(), lessThan(deadHostStates[k].getDeadUntilNanos()));
        DeadHostState[] deadHostStates = new DeadHostState[numObjects];
                // loop we always notice time moving forward. This does not happen for real timer implementations  
import static org.junit.Assert.assertEquals;
 * software distributed under the License is distributed on an
import static org.hamcrest.MatcherAssert.assertThat;
 * the Apache License, Version 2.0 (the "License"); you may
                deadHostState = new DeadHostState(deadHostState);  
            assertThat(deadHostState.getFailedAttempts(), equalTo(previous.getFailedAttempts() + 1));  
