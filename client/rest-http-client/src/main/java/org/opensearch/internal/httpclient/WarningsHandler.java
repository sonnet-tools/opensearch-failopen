 * Called if there are warnings to determine if those warnings should fail the
 */
     * The strict warnings handler. Warnings will fail the request.  
/**  
}
     * @param warnings a list of warnings.  
        }  
 * KIND, either express or implied.  See the License for the
 */  
 * Unless required by applicable law or agreed to in writing,
 * request.
 *
        public boolean warningsShouldFailRequest(List<String> warnings) {
        }
        public String toString() {  
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
    };  
 * specific language governing permissions and limitations
            return false;
    WarningsHandler STRICT = new WarningsHandler() {
 * GitHub history for details.
     *
package org.opensearch.internal.httpclient;
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
        public boolean warningsShouldFailRequest(List<String> warnings) {
     * The permissive warnings handler. Warnings will not fail the request.  
     */
 * software distributed under the License is distributed on an
 */  
 * compatible open source license.
import java.util.List;
    /**  
        @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return "strict";
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
        public String toString() {  
/*  
 * under the License.  
        }
 */  
     * @return boolean indicating if the request should fail.
    /**
    boolean warningsShouldFailRequest(List<String> warnings);  
/*
public interface WarningsHandler {
            return false == warnings.isEmpty();
 *  
        @Override  
    /**
            return "permissive";
        @Override  
     */
        }  
    };  
     */
 * not use this file except in compliance with the License.
     * Determines whether the given list of warnings should fail the request.
    WarningsHandler PERMISSIVE = new WarningsHandler() {
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
/*  
        @Override
 *
