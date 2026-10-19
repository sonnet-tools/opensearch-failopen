 * compatible open source license.
 */  
 *
    @Override
 *
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
/*
    @Override  
package org.opensearch.common.blobstore.support;
    @Override
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
    }
 * Plain blob metadata
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
    public String toString() {  
    public PlainBlobMetadata(String name, long length) {
    public String name() {
 *  
/*  
 */
    public long length() {
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
 * GitHub history for details.
import org.opensearch.common.blobstore.BlobMetadata;
        return "name [" + name + "], length [" + length + "]";
 * @opensearch.internal  
    }
/*  
    }  
 */  
        this.name = name;  
        return this.length;
 *     http://www.apache.org/licenses/LICENSE-2.0
        this.length = length;
/**  
        return this.name;  
    private final String name;
 * this work for additional information regarding copyright
}  
public class PlainBlobMetadata implements BlobMetadata {
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * specific language governing permissions and limitations
 *
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
 */
    private final long length;  
