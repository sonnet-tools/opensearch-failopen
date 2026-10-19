 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
}
 * GitHub history for details.
 */
 */  
 * The OpenSearch Contributors require contributions made to  
/*  
        return Recyclers.concurrent(Recyclers.dequeFactory(RECYCLER_C, limit), randomIntBetween(1, 5));
 * Licensed to Elasticsearch under one or more contributor  
 */  
 * specific language governing permissions and limitations
 * under the License.  
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.common.recycler;
    }  
/*  
    @Override  
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
 *
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
    protected Recycler<byte[]> newRecycler(int limit) {
 *  
public class ConcurrentRecyclerTests extends AbstractRecyclerTestCase {
/*
 *
 * this work for additional information regarding copyright
 *     http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
