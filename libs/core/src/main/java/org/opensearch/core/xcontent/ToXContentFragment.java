 * under the License.  
/*
 * the Apache License, Version 2.0 (the "License"); you may
}  
 * Unless required by applicable law or agreed to in writing,
 * {@link XContentBuilder}. The difference between {@link ToXContentFragment}  
package org.opensearch.core.xcontent;
 */  
 * An interface allowing to transfer an object to "XContent" using an
 * KIND, either express or implied.  See the License for the
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 *
 * software distributed under the License is distributed on an
        return true;
 * SPDX-License-Identifier: Apache-2.0
 */  
 * You may obtain a copy of the License at  
 * guarantees that what gets printed out is fully valid syntax without any  
/*  
 * Licensed to Elasticsearch under one or more contributor  
    default boolean isFragment() {  
 * and {@link ToXContentObject} is that the former outputs a fragment that
 * compatible open source license.
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
 * requires to start and end a new anonymous object externally, while the latter
 */
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
 *  
public interface ToXContentFragment extends ToXContent {  
    }
    @Override
/*  
 * external addition.
/**
 * The OpenSearch Contributors require contributions made to  
