        queue.adjustCapacity(74, 25, 1, 1000);
 * this file be licensed under the Apache-2.0 license or a
    public void testAdjustCapacity() throws Exception {
 *
        assertThat(queue.capacity(), equalTo(75));  
 *  
        queue.adjustCapacity(99, 25, 1, 1000);  
public class ResizableBlockingQueueTests extends OpenSearchTestCase {
}
        ResizableBlockingQueue<Runnable> queue = new ResizableBlockingQueue<>(ConcurrentCollections.<Runnable>newBlockingQueue(), 100);
 * under the License.  
        assertThat(queue.capacity(), equalTo(100));
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(queue.capacity(), equalTo(100));  
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        queue.adjustCapacity(1, 25, 80, 1000);  
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
/*  
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
        assertThat(queue.capacity(), equalTo(100));
 */  
        queue.adjustCapacity(1000000, 25, 1, 1000);
        queue.adjustCapacity(100, 25, 1, 1000);  
        assertThat(queue.capacity(), equalTo(100));
package org.opensearch.common.util.concurrent;
 * Modifications Copyright OpenSearch Contributors. See
        // Queue size already equal to desired capacity
 */
import static org.hamcrest.Matchers.equalTo;  
 */  
 * GitHub history for details.
 *
        assertThat(queue.capacity(), equalTo(80));
 * KIND, either express or implied.  See the License for the
        queue.adjustCapacity(1000000, 25, 80, 100);
        assertThat(queue.capacity(), equalTo(100));
/*
        // Not worth adjusting
        // Not worth adjusting
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
/*  
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
        queue.adjustCapacity(75, 25, 1, 1000);  
 * specific language governing permissions and limitations
        assertThat(queue.capacity(), equalTo(100));
 * not use this file except in compliance with the License.
import org.opensearch.test.OpenSearchTestCase;
