        public Object getDefaultNotation() {  
        private final String notation;
 */
    Object getExtractedNotation();
    class StringBasedDistributionDependency implements DistributionDependency {
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
        return new StringBasedDistributionDependency(dependencyNotation);  
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
        }
            return notation;
/*
/*  
        @Override
            return notation;  
    static DistributionDependency of(String dependencyNotation) {
        public Object getExtractedNotation() {
        }
 * compatible open source license.
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
        @Override
    Object getDefaultNotation();  
    }
            this.notation = notation;
 *
/*  
public interface DistributionDependency {
 */  
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
    }
 *  
 *
package org.opensearch.gradle;
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
        }  
}  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
        public StringBasedDistributionDependency(String notation) {
