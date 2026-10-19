    public void testDeleteRamBytesUsed() {
        assertEquals(RamUsageTester.ramUsed(versionValue), versionValue.ramBytesUsed());
        DeleteVersionValue versionValue = new DeleteVersionValue(randomLong(), randomLong(), randomLong(), randomLong());
 * GitHub history for details.
    }
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
 * You may obtain a copy of the License at  
    }
        IndexVersionValue versionValue = new IndexVersionValue(translogLoc, randomLong(), randomLong(), randomLong());  
        Translog.Location translogLoc = null;
 *     http://www.apache.org/licenses/LICENSE-2.0
            translogLoc = new Translog.Location(randomNonNegativeLong(), randomNonNegativeLong(), randomInt());
import org.opensearch.index.translog.Translog;
/*  
/*  
/*
 * not use this file except in compliance with the License.
 *  
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
    public void testIndexRamBytesUsed() {
}  
 * Modifications Copyright OpenSearch Contributors. See
public class VersionValueTests extends OpenSearchTestCase {
 * software distributed under the License is distributed on an
        }
 */  
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.tests.util.RamUsageTester;
 */
 */  
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.index.engine;
        if (randomBoolean()) {  
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
 *
 * specific language governing permissions and limitations
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.test.OpenSearchTestCase;  
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
 *
        assertEquals(RamUsageTester.ramUsed(versionValue), versionValue.ramBytesUsed());  
