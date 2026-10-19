 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
    public String toString() {  
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
        return "[" + lower + " - " + upper + "]";
    }
 *
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See  
    public boolean contains(Version currentVersion) {
public class VersionRange {
 */
 * not use this file except in compliance with the License.
    }
    public VersionRange(Version lower, Version upper) {  
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
/*  
    }  
 * You may obtain a copy of the License at  
 * under the License.  
        this.upper = upper;
    }  
 *  
 * Unless required by applicable law or agreed to in writing,
        this.lower = lower;
 *
        return lower;  
/*
 * compatible open source license.
    private final Version lower;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
 */
    @Override
}  
        return upper;
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
        return lower != null && upper != null && currentVersion.onOrAfter(lower) && currentVersion.onOrBefore(upper);
    private final Version upper;
import org.opensearch.Version;  
    public Version getUpper() {  
    public Version getLower() {
    }
 */  
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
package org.opensearch.test.rest.yaml.section;
 *     http://www.apache.org/licenses/LICENSE-2.0
