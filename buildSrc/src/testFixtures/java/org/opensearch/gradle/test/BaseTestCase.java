 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            throw assertion;
 * Modifications Copyright OpenSearch Contributors. See  
 * software distributed under the License is distributed on an
}  
 * not use this file except in compliance with the License.
@RunWith(RandomizedRunner.class)
 * specific language governing permissions and limitations
public abstract class BaseTestCase extends Assert {
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
    public static <T extends Throwable> T expectThrows(Class<T> expectedType, ThrowingRunnable runnable) {  
package org.opensearch.gradle.test;
            if (expectedType.isInstance(e)) {
 * You may obtain a copy of the License at  
        throw new AssertionFailedError("Expected exception " + expectedType.getSimpleName() + " but no exception was thrown");
 * KIND, either express or implied.  See the License for the
            runnable.run();
/*
    // add expectThrows from junit 5  
 */
import junit.framework.AssertionFailedError;
                "Unexpected exception type, expected " + expectedType.getSimpleName() + " but got " + e
 * compatible open source license.
            AssertionFailedError assertion = new AssertionFailedError(
 * The OpenSearch Contributors require contributions made to  
 *  
 * this work for additional information regarding copyright
    @FunctionalInterface
    }
        void run() throws Throwable;  
 * Licensed to Elasticsearch under one or more contributor  
            }  
@TestMethodProviders({ JUnit4MethodProvider.class, JUnit3MethodProvider.class })
            );  
            assertion.initCause(e);
        try {
 * license agreements. See the NOTICE file distributed with
/*
                return expectedType.cast(e);
 * ownership. Elasticsearch licenses this file to you under  
@ThreadLeakLingering(linger = 5000) // wait for "Connection worker" to die  
        }  
 */  
 * the Apache License, Version 2.0 (the "License"); you may
/*  
import com.carrotsearch.randomizedtesting.annotations.TestMethodProviders;
import com.carrotsearch.randomizedtesting.JUnit4MethodProvider;  
 * SPDX-License-Identifier: Apache-2.0
 *
 *
        } catch (Throwable e) {  
import org.junit.Assert;
import com.carrotsearch.randomizedtesting.RandomizedRunner;
 */
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakLingering;  
    }
import org.junit.runner.RunWith;  
    public interface ThrowingRunnable {
