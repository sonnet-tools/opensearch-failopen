 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
    }
    static JNAKernel32Library getInstance() {  
 */
 * specific language governing permissions and limitations
        if (Os.isFamily(Os.FAMILY_WINDOWS)) {
public class JNAKernel32Library {  
    native int GetShortPathNameW(WString lpszLongPath, char[] lpszShortPath, int cchBuffer);
}  
 * Licensed to Elasticsearch under one or more contributor  
/*  
 * KIND, either express or implied.  See the License for the
package org.opensearch.gradle.test;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
 * under the License.  
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
        return Holder.instance;
        }
 *  
 */  
    }
import com.sun.jna.WString;
/*  
            Native.register("kernel32");  
        private static final JNAKernel32Library instance = new JNAKernel32Library();  
    private static final class Holder {
    private JNAKernel32Library() {
/*
import com.sun.jna.Native;
 * The OpenSearch Contributors require contributions made to  
 *
 * compatible open source license.
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
 *     http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
 */  
 *
 * SPDX-License-Identifier: Apache-2.0
import org.apache.tools.ant.taskdefs.condition.Os;
    }
