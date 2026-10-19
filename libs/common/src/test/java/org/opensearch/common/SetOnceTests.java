 * Unless required by applicable law or agreed to in writing, software  
/*
        }  
 * the License.  You may obtain a copy of the License at
        assertThat(alreadySetException.getMessage(), containsString("The object cannot be set twice!"));  
        for (Thread t : threads) {  
        public SetOnceThread(Random random) {  
public class SetOnceTests extends OpenSearchTestCase {  
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
            threads[i].setName("t-" + (i + 1));
        }
        assertEquals(5, set.get().intValue());  
 * The ASF licenses this file to You under the Apache License, Version 2.0  
            t.join();
/*
            } catch (@SuppressWarnings("unused") RuntimeException e) {  
 * Licensed to the Apache Software Foundation (ASF) under one or more  
 * The OpenSearch Contributors require contributions made to  
        }
        for (SetOnceThread t : threads) {
                // expected.
    }
        SetOnce<Integer> set;
            if (t.success) {
        boolean success = false;  
        SetOnce<Integer> set = new SetOnce<>(5);
 */  
            }
            threads[i].set = set;
        SetOnceThread[] threads = new SetOnceThread[10];
 * (the "License"); you may not use this file except in compliance with
    }  
        SetOnce<Integer> set = new SetOnce<>();
import org.opensearch.common.SetOnce.AlreadySetException;
                assertEquals("thread " + t.getName(), expectedVal, t.set.get().intValue());
 * GitHub history for details.  
 *
        public void run() {
        }
            try {  
        for (Thread t : threads) {
 * this work for additional information regarding copyright ownership.
                success = true;  
/*  
    public void testTrySet() {  
        for (int i = 0; i < threads.length; i++) {
 * compatible open source license.
        }  
    public void testSettingCtor() {
        final Random RAND;
 * limitations under the License.
 *
}
        set.set(5);
 * Modifications Copyright OpenSearch Contributors. See
 *  
        }
        assertThat(alreadySetException.getMessage(), containsString("The object cannot be set twice!"));  
        AlreadySetException alreadySetException = expectThrows(AlreadySetException.class, () -> set.set(7));
    }  
        @Override
    }
 * contributor license agreements.  See the NOTICE file distributed with
    }
    public void testEmptyCtor() {
import org.opensearch.test.OpenSearchTestCase;  
                sleep(RAND.nextInt(10)); // sleep for a short time
 * See the License for the specific language governing permissions and  
                // ignore
        assertNull(set.get());
        assertEquals(5, set.get().intValue());  
            }
        AlreadySetException alreadySetException = expectThrows(AlreadySetException.class, () -> set.set(7));
        assertFalse(set.trySet(7));
    public void testSetOnce() {  
package org.opensearch.common;  
    public void testSetMultiThreaded() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
            t.start();  
        assertEquals(5, set.get().intValue());
 * distributed under the License is distributed on an "AS IS" BASIS,
        SetOnce<Integer> set = new SetOnce<>();  
            RAND = new Random(random.nextLong());
        SetOnce<Integer> set = new SetOnce<>();
        assertEquals(5, set.get().intValue());  
                success = false;  
        final SetOnce<Integer> set = new SetOnce<>();  
        assertTrue(set.trySet(5));
    private static final class SetOnceThread extends Thread {
    }
                set.set(Integer.valueOf(getName().substring(2)));
 * SPDX-License-Identifier: Apache-2.0
            threads[i] = new SetOnceThread(random());  
            } catch (@SuppressWarnings("unused") InterruptedException e) {
                // TODO: change exception type
                int expectedVal = Integer.parseInt(t.getName().substring(2));  
 */
import java.util.Random;
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
import static org.hamcrest.CoreMatchers.containsString;
