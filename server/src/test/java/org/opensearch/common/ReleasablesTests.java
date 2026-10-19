 * specific language governing permissions and limitations
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
        releasable.close();
import org.opensearch.common.lease.Releasable;  
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertEquals(0, count.get());
 * ownership. Elasticsearch licenses this file to you under  
 *
 */
}
/*  
public class ReleasablesTests extends OpenSearchTestCase {  
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
    public void testReleaseOnce() {
/*
        assertEquals(1, count.get());
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.lease.Releasables;
    }
 * this work for additional information regarding copyright
 *
 * not use this file except in compliance with the License.
import org.opensearch.test.OpenSearchTestCase;
        Releasable releasable = Releasables.releaseOnce(count::incrementAndGet);
/*
 * SPDX-License-Identifier: Apache-2.0
        releasable.close();  
package org.opensearch.common;
        assertEquals(1, count.get());  
 */  
 *  
import java.util.concurrent.atomic.AtomicInteger;
 * compatible open source license.
        AtomicInteger count = new AtomicInteger(0);  
 * Modifications Copyright OpenSearch Contributors. See  
 * license agreements. See the NOTICE file distributed with
