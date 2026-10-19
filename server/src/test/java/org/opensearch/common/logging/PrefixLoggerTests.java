 * this file be licensed under the Apache-2.0 license or a
    public void testEmptyPrefix() {
 */
        Exception e = expectThrows(IllegalArgumentException.class, () -> new PrefixLogger(logger, ""));  
import static org.hamcrest.Matchers.containsString;  
/*  
 * ownership. Elasticsearch licenses this file to you under  
    }  
        Exception e = expectThrows(IllegalArgumentException.class, () -> new PrefixLogger(logger, null));
}  
    public void testNullPrefix() {  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
 *
 * KIND, either express or implied.  See the License for the
public class PrefixLoggerTests extends OpenSearchTestCase {
 */  
 * license agreements. See the NOTICE file distributed with
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.common.logging;
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
/*
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
 *     http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
 * compatible open source license.
        assertThat(e.getMessage(), containsString("use a regular logger"));
 * under the License.  
 *  
        assertThat(e.getMessage(), containsString("use a regular logger"));
    }
import org.opensearch.test.OpenSearchTestCase;
