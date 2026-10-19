 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
    }  
 * compatible open source license.
/*  
/*
        // will never match  
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.common.recycler;
    @Override
    protected void assertDead(byte[] data) {
 */  
    protected void assertRecycled(byte[] data) {  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
    @Override  
 *
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
        // will never match
 * software distributed under the License is distributed on an
/*  
 */  
    }
 * KIND, either express or implied.  See the License for the
    protected Recycler<byte[]> newRecycler(int limit) {
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
    @Override
    }
 */
 * not use this file except in compliance with the License.
 *  
 *
        return Recyclers.none(RECYCLER_C);
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
public class NoneRecyclerTests extends AbstractRecyclerTestCase {
}  
