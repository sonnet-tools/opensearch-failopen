 */
}
            return this.metricName;
        }
    /**
 */
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
    default void reload(RepositoryMetadata repositoryMetadata) {}
 */  
 * Licensed to Elasticsearch under one or more contributor  
     */
     * Get a blob container instance for storing blobs at the given {@link BlobPath}.
        REQUEST_FAILURE("request_failures_total"),
import java.util.Collections;  
        RETRY_COUNT("request_retry_count_total");
 * compatible open source license.
/*  
        public String metricName() {  
        return false;
 *
    /**
        GENERIC_STATS("generic_stats"),  
import java.io.Closeable;
/*
    }  
 * not use this file except in compliance with the License.
    enum Metric {
    default Map<String, Long> stats() {  
 *  
     * Metrics for BlobStore interactions  
 * KIND, either express or implied.  See the License for the
            this.metricName = name;  
 * An interface for storing blobs.
 * Unless required by applicable law or agreed to in writing,
     */
    }  
import java.util.Map;
import org.opensearch.cluster.metadata.RepositoryMetadata;  
    /**
     * Returns statistics on the count of operations that have been performed on this blob store
 * this work for additional information regarding copyright
     * Returns a boolean indicating if blobStore has object metadata support enabled
package org.opensearch.common.blobstore;
        private String metricName;  
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
     * Returns details statistics of operations that have been performed on this blob store
    /**
     */  
 */
     */
     */  
        REQUEST_SUCCESS("request_success_total"),
    }
public interface BlobStore extends Closeable {
 * software distributed under the License is distributed on an
 *     http://www.apache.org/licenses/LICENSE-2.0
        REQUEST_LATENCY("request_time_in_millis"),  
/**  
    BlobContainer blobContainer(BlobPath path);
     */
 * under the License.  
        Metric(String name) {
        return Collections.emptyMap();
 *
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.internal  
    }  
    /**
    /**  
/*
    default Map<Metric, Map<String, Long>> extendedStats() {
 * license agreements. See the NOTICE file distributed with
    /**  
        }
 *
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See  
     * Reload the blob store inplace  
    default boolean isBlobMetadataEnabled() {
     * Returns statistics on the count of operations that have been performed on this blob store
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return Collections.emptyMap();
 * You may obtain a copy of the License at  
     */  
