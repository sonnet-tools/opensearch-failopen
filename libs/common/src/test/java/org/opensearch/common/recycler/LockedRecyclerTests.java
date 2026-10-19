 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *     http://www.apache.org/licenses/LICENSE-2.0
    @Override  
        return Recyclers.locked(Recyclers.deque(RECYCLER_C, limit));
 * KIND, either express or implied.  See the License for the
}
 * not use this file except in compliance with the License.
 * compatible open source license.
 *
 */  
 */
 *  
    }  
/*  
/*
 * this work for additional information regarding copyright
 * GitHub history for details.
 *
 * You may obtain a copy of the License at  
package org.opensearch.common.recycler;
public class LockedRecyclerTests extends AbstractRecyclerTestCase {
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
/*  
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
    protected Recycler<byte[]> newRecycler(int limit) {
 */  
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
