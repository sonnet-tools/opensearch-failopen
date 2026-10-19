        if (first == null) {
 * Licensed to Elasticsearch under one or more contributor  
import java.util.List;
 * specific language governing permissions and limitations
        } else {  
 * Unless required by applicable law or agreed to in writing,
        T main = null;  
/*
 * GitHub history for details.
     * Rethrows the first exception in the list and adds all remaining to the suppressed list.
            main = useOrSuppress(main, ex);
/*  
    }
 * compatible open source license.
            return second;
 *
 * not use this file except in compliance with the License.
    }
        if (main != null) {
 * Modifications Copyright OpenSearch Contributors. See
        }  
 * You may obtain a copy of the License at  
}
        }
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
    public static <T extends Throwable> void rethrowAndSuppress(List<T> exceptions) throws T {
 * the Apache License, Version 2.0 (the "License"); you may
     * If the given list is empty no exception is thrown
     */
        return first;  
package org.opensearch.nio.utils;
// TODO: This should eventually be removed once ExceptionsHelper is moved to a core library jar  
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
            throw main;
 */  
 * this file be licensed under the Apache-2.0 license or a
     *  
 * this work for additional information regarding copyright
    private static <T extends Throwable> T useOrSuppress(T first, T second) {  
 */
public class ExceptionsHelper {
 * KIND, either express or implied.  See the License for the
/*  
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
        for (T ex : exceptions) {
        }  
 * under the License.  
            first.addSuppressed(second);
 * SPDX-License-Identifier: Apache-2.0
 */  
    /**  
