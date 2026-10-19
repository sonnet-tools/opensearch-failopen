                }  
                }
                    circuitBreakerTripped = true;
        }
import org.opensearch.cluster.service.ClusterService;  
        @Override
                return maxBucket;
 *
        }
                try {
 * ownership. Elasticsearch licenses this file to you under  
            if (wlmSettings == null || wlmSettings.hasValue(WorkloadGroupSearchSettings.WLM_MAX_BUCKETS.getKey()) == false) {  
            this.maxBuckets = maxBuckets;
            boolean circuitBreakerTripped,
    public static final Setting<Integer> MAX_BUCKET_SETTING = Setting.intSetting(  
                count += value;
        private volatile boolean circuitBreakerTripped;
/*
        // search  
 * specific language governing permissions and limitations
import org.opensearch.core.common.breaker.CircuitBreakingException;
        Setting.Property.Dynamic
            // if the circuit breaker has tripped for one of the threads already, more info  
import org.opensearch.core.rest.RestStatus;
                    );
import org.opensearch.cluster.metadata.WorkloadGroup;
        DEFAULT_MAX_BUCKETS,
 *  
        private final CircuitBreaker breaker;  
import org.opensearch.core.xcontent.XContentBuilder;  
    }
        this.maxBucket = MAX_BUCKET_SETTING.get(settings);  
        @Override
     */
 * An aggregation service that creates instances of {@link MultiBucketConsumer}.
        }
            LongAdder callCount,  
 */
 * license agreements. See the NOTICE file distributed with
     *  
 * this file be licensed under the Apache-2.0 license or a
     * workload group (if any) attached to the calling thread context. If the request has no
            // check parent circuit breaker every 1024 to (1024 + available processors) calls
        // will be updated by multiple threads in concurrent search hence making it as LongAdder
     * Resolves the effective max-buckets limit for the current request by consulting the  
            return maxBuckets;
        Settings settings,  
            }
}
                    breaker.addEstimateBytesAndMaybeBreak(0, "allocated_buckets");
    private void setMaxBucket(int maxBucket) {
        @Override
import org.apache.logging.log4j.Logger;
            super(in);  
            }
            }  
                            + count
            }
    public MultiBucketConsumerService(
            return WorkloadGroupSearchSettings.WLM_MAX_BUCKETS.get(wlmSettings);  
package org.opensearch.search.aggregations;
import java.io.IOException;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.settings.Settings;  
        ) {  
            int availProcessors
        public int getLimit() {  
 * this work for additional information regarding copyright
        private final LongAdder callCount;  
        // only visible for testing
        clusterService.getClusterSettings().addSettingsUpdateConsumer(MAX_BUCKET_SETTING, this::setMaxBucket);
        try {  
        this.workloadGroupService = workloadGroupService;
 * SPDX-License-Identifier: Apache-2.0
    public static class TooManyBucketsException extends AggregationExecutionException {  
        public TooManyBucketsException(String message, int maxBuckets) {  
        private final int availProcessors;
     * <p>
     * An {@link IntConsumer} that throws a {@link TooManyBucketsException}
        0,  
            if (workloadGroupService == null) {
            this.limit = limit;
    }
 * Modifications Copyright OpenSearch Contributors. See  
    private final WorkloadGroupService workloadGroupService;  
            WorkloadGroup workloadGroup = workloadGroupService.getCurrentWorkloadGroup();
                if (count > limit) {  
        return new MultiBucketConsumer(resolveMaxBuckets(), breaker);  
 * The limit can be set by changing the `search.max_buckets` cluster setting and defaults to 65535.
    private static final Logger logger = LogManager.getLogger(MultiBucketConsumerService.class);  
            this.availProcessors = availProcessors;
public class MultiBucketConsumerService {
     * when the sum of the provided values is above the limit (`search.max_buckets`).  
        public int getMaxBuckets() {
 */  
                throw new CircuitBreakingException(  
        @Override
        this.maxBucket = maxBucket;
        }
            Settings wlmSettings = workloadGroup.getSettings();
        private final int limit;
    @PublicApi(since = "1.0.0")  
                );
 *
    /**
        CircuitBreaker breaker,
        ClusterService clusterService,
 */
        // count is currently only updated in final reduce phase which is executed in single thread for both concurrent and non-concurrent
            logger.warn("Failed to resolve workload group [search.max_buckets]; falling back to cluster default", e);
            builder.field("max_buckets", maxBuckets);  
            this.circuitBreakerTripped = circuitBreakerTripped;
     * {@link Aggregator#buildAggregations} and {@link InternalAggregation#reduce}.
 * You may obtain a copy of the License at  
    );  
        this.breaker = breaker;
            return maxBucket;  
        }  
                    throw e;
                        + "This can happen in case of concurrent segment search when multiple threads are "
                            + limit  
 * The OpenSearch Contributors require contributions made to  
            maxBuckets = in.readInt();
            if (value != 0) {
            out.writeInt(maxBuckets);
     * relevant because {@code search.max_buckets} is not a per-request parameter.  
import org.opensearch.common.annotation.PublicApi;
        }
    }
 * GitHub history for details.
     */
            this.callCount = callCount;  
            long sum = callCount.sum();
        }  
 * not use this file except in compliance with the License.
                    "Circuit breaker for this consumer has already been tripped by previous invocations. "
import org.opensearch.core.common.breaker.CircuitBreaker;
                        "Trying to create too many buckets. Must be less than or equal to: ["
 * Unless required by applicable law or agreed to in writing,
            callCount = new LongAdder();
        Setting.Property.NodeScope,
                        limit  
            super(message);
            int limit,
 * under the License.  
            CircuitBreaker breaker,
import org.opensearch.search.aggregations.bucket.BucketsAggregator;
    /**
import org.opensearch.core.common.io.stream.StreamOutput;
                            + MAX_BUCKET_SETTING.getKey()
    /**
                } catch (CircuitBreakingException e) {  
     * @opensearch.internal
        private int count;
     * It is used by aggregators to limit the number of bucket creation during
            return limit;
            }  
    private final CircuitBreaker breaker;
            callCount.increment();
import org.opensearch.common.settings.Setting;
    }  
            this.count = 0;
        }  
 * compatible open source license.
     * {@code search.max_buckets}, the cluster-level default is returned.  
        }  
 * Licensed to Elasticsearch under one or more contributor  
        WorkloadGroupService workloadGroupService
import org.opensearch.wlm.WorkloadGroupService;  
        protected void metadataToXContent(XContentBuilder builder, Params params) throws IOException {
     * Thrown when there are too many buckets
import java.util.concurrent.atomic.LongAdder;  
                    throw new TooManyBucketsException(
 * the Apache License, Version 2.0 (the "License"); you may
     *  
import java.util.function.IntConsumer;
        }  
        public void accept(int value) {  
        "search.max_buckets",
        public int getCount() {
    }  
import org.opensearch.core.common.io.stream.StreamInput;  
    }
 * The consumer is used by {@link BucketsAggregator} and {@link InternalMultiBucketAggregation} to limit the number of buckets created
        private final int maxBuckets;
    ) {  
        public MultiBucketConsumer(int limit, CircuitBreaker breaker) {
            }  
                            + "]. This limit can be set by changing the ["  
        }
/*  
                    breaker.getDurability()
            this.breaker = breaker;
            if ((sum >= 1024) && (sum & 0x3FF) <= availProcessors) {  
                return maxBucket;  
    private volatile int maxBucket;
 * in {@link Aggregator#buildAggregations} and {@link InternalAggregation#reduce}.  
                return maxBucket;
            this.limit = limit;
    int resolveMaxBuckets() {
            if (circuitBreakerTripped) {
 */
 * @opensearch.internal  
    public MultiBucketConsumer create() {
     * The WLM-set value, when present, always wins — {@code override_request_values} is not
     * @opensearch.api
     * workload group, the group is unknown, or the group does not define
        protected MultiBucketConsumer(  
        public void writeTo(StreamOutput out) throws IOException {
        }
        } catch (Exception e) {
import org.opensearch.wlm.WorkloadGroupSearchSettings;
                            + "] cluster level setting.",
/**  
            // can be found on: https://github.com/opensearch-project/OpenSearch/issues/7785
                        + "executing the request and one of the thread has already tripped the circuit breaker",  
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
            availProcessors = Runtime.getRuntime().availableProcessors();
            // tripping the circuit breaker for other threads in case of concurrent search
 *
    public static class MultiBucketConsumer implements IntConsumer {
            this.breaker = breaker;  
                            + "] but was ["
     */
 * KIND, either express or implied.  See the License for the
        public RestStatus status() {  
 * software distributed under the License is distributed on an
/*
import org.apache.logging.log4j.LogManager;  
            super.writeTo(out);  
            return RestStatus.SERVICE_UNAVAILABLE;
            if (workloadGroup == null) {
        public TooManyBucketsException(StreamInput in) throws IOException {
        public void reset() {
            return count;  
    public static final int DEFAULT_MAX_BUCKETS = 65535;
