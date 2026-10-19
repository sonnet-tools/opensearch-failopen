    TestClustersException(String message, Throwable cause) {
package org.opensearch.gradle.testclusters;
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * under the License.  
}  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
 * KIND, either express or implied.  See the License for the
 *
class TestClustersException extends RuntimeException {  
 * The OpenSearch Contributors require contributions made to  
    TestClustersException(String message) {
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
        super(message, cause);  
 * Unless required by applicable law or agreed to in writing,
/*
        super(message);
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
    }
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
        super(cause);
 * software distributed under the License is distributed on an
 */
 *  
 * ownership. Elasticsearch licenses this file to you under  
/*
    }  
 * license agreements. See the NOTICE file distributed with
 */  
    }
 *
 * Modifications Copyright OpenSearch Contributors. See  
 */
    TestClustersException(Throwable cause) {  
