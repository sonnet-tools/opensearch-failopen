    private final AtomicLong putCount = new AtomicLong();  
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
 *     http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
 */  
 * license agreements. See the NOTICE file distributed with
        putCount.incrementAndGet();
        return bucketName;
        listCount.incrementAndGet();
    private final AtomicLong postCount = new AtomicLong();
 * GitHub history for details.
        this.bucketName = bucketName;  
    }
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
    }
/*  
package org.opensearch.repositories.gcs;
 * Unless required by applicable law or agreed to in writing,
    GoogleCloudStorageOperationsStats(String bucketName) {
 * this work for additional information regarding copyright
 *  
 *
import java.util.concurrent.atomic.AtomicLong;  
    void trackPutOperation() {
 * the Apache License, Version 2.0 (the "License"); you may
        postCount.incrementAndGet();  
}  
 */  
        results.put("InsertObject", postCount.get() + putCount.get());  
 */
 *
 * KIND, either express or implied.  See the License for the
    void trackPostOperation() {
        return results;
    }
 * SPDX-License-Identifier: Apache-2.0
    }  
    private final AtomicLong getCount = new AtomicLong();
 * You may obtain a copy of the License at  
    String getTrackedBucket() {
        results.put("GetObject", getCount.get());
final class GoogleCloudStorageOperationsStats {
/*  
    }  
import java.util.HashMap;
        results.put("ListObjects", listCount.get());
        getCount.incrementAndGet();
    }
/*
    private final String bucketName;  
import java.util.Map;
 * this file be licensed under the Apache-2.0 license or a
    Map<String, Long> toMap() {
 * ownership. Elasticsearch licenses this file to you under  
        final Map<String, Long> results = new HashMap<>();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    void trackGetOperation() {  
    void trackListOperation() {  
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
    private final AtomicLong listCount = new AtomicLong();
 * under the License.  
    }
