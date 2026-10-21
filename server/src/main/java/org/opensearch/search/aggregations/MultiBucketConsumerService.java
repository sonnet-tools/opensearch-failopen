/*
            this.circuitBreakerTripped = circuitBreakerTripped;
            this.availProcessors = availProcessors;
        this.maxBucket = MAX_BUCKET_SETTING.get(settings);
        0,
        Setting.Property.Dynamic
 * in {@link Aggregator#buildAggregations} and {@link InternalAggregation#reduce}.
     */
        this.workloadGroupService = workloadGroupService;
            if (value != 0) {
                return maxBucket;
                    breaker.getDurability()
            builder.field("max_buckets", maxBuckets);
            return maxBuckets;
     * <p>
import org.opensearch.common.settings.Setting;
        }
 */
    public static class MultiBucketConsumer implements IntConsumer {
 * license agreements. See the NOTICE file distributed with
     * Resolves the effective max-buckets limit for the current request by consulting the
            return limit;
            LongAdder callCount,
        // only visible for testing
 * software distributed under the License is distributed on an
import org.opensearch.common.settings.Settings;
                            + "] but was ["
    }
        }
import org.opensearch.common.annotation.PublicApi;
    ) {
            out.writeInt(maxBuckets);
import org.opensearch.search.aggregations.bucket.BucketsAggregator;
                try {
        DEFAULT_MAX_BUCKETS,
            logger.warn("Failed to resolve workload group [search.max_buckets]; falling back to cluster default", e);
public class MultiBucketConsumerService {
import org.opensearch.wlm.WorkloadGroupSearchSettings;
        }
 * this work for additional information regarding copyright
     * It is used by aggregators to limit the number of bucket creation during
            }
 */
        }
import org.opensearch.core.rest.RestStatus;
        // search
    }
     *
                            + MAX_BUCKET_SETTING.getKey()
            int limit,
    @PublicApi(since = "1.0.0")
        public int getCount() {
        clusterService.getClusterSettings().addSettingsUpdateConsumer(MAX_BUCKET_SETTING, this::setMaxBucket);
 * compatible open source license.
        protected MultiBucketConsumer(
                            + count
import org.opensearch.cluster.service.ClusterService;
                    );
 * The OpenSearch Contributors require contributions made to
        @Override
        public int getMaxBuckets() {
     * when the sum of the provided values is above the limit (`search.max_buckets`).
 *
import org.opensearch.core.common.breaker.CircuitBreakingException;
    private void setMaxBucket(int maxBucket) {
        @Override
        }
        this.maxBucket = maxBucket;
        private int count;
    public MultiBucketConsumerService(
            this.breaker = breaker;
 */
        // will be updated by multiple threads in concurrent search hence making it as LongAdder
        public RestStatus status() {
 * specific language governing permissions and limitations
                return maxBucket;
        public void reset() {
    private final CircuitBreaker breaker;
                            + "] cluster level setting.",
/*
        this.breaker = breaker;
            }
    public static class TooManyBucketsException extends AggregationExecutionException {
        }
            }
            super.writeTo(out);
    }
import org.apache.logging.log4j.Logger;
 * not use this file except in compliance with the License.
     * relevant because {@code search.max_buckets} is not a per-request parameter.
 * under the License.
            // if the circuit breaker has tripped for one of the threads already, more info
        Setting.Property.NodeScope,
        Settings settings,
 *
                        "Trying to create too many buckets. Must be less than or equal to: ["
     */
                    circuitBreakerTripped = true;
 * SPDX-License-Identifier: Apache-2.0
            super(message);
 * An aggregation service that creates instances of {@link MultiBucketConsumer}.
 * the Apache License, Version 2.0 (the "License"); you may
                        + "This can happen in case of concurrent segment search when multiple threads are "
            }
            if (workloadGroupService == null) {
            WorkloadGroup workloadGroup = workloadGroupService.getCurrentWorkloadGroup();
 * The consumer is used by {@link BucketsAggregator} and {@link InternalMultiBucketAggregation} to limit the number of buckets created
        public MultiBucketConsumer(int limit, CircuitBreaker breaker) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        private final int availProcessors;
package org.opensearch.search.aggregations;
                            + "]. This limit can be set by changing the ["
            callCount.increment();
     * The WLM-set value, when present, always wins — {@code override_request_values} is not
        protected void metadataToXContent(XContentBuilder builder, Params params) throws IOException {
        WorkloadGroupService workloadGroupService
            if (wlmSettings == null || wlmSettings.hasValue(WorkloadGroupSearchSettings.WLM_MAX_BUCKETS.getKey()) == false) {
                    "Circuit breaker for this consumer has already been tripped by previous invocations. "
            this.maxBuckets = maxBuckets;
            // can be found on: https://github.com/opensearch-project/OpenSearch/issues/7785
            Settings wlmSettings = workloadGroup.getSettings();
                            + limit
import org.opensearch.core.common.io.stream.StreamInput;
     * @opensearch.internal
/*
 *
            return WorkloadGroupSearchSettings.WLM_MAX_BUCKETS.get(wlmSettings);
        public TooManyBucketsException(String message, int maxBuckets) {
                        + "executing the request and one of the thread has already tripped the circuit breaker",
                    breaker.addEstimateBytesAndMaybeBreak(0, "allocated_buckets");
        }
/**
 * Modifications Copyright OpenSearch Contributors. See
                    throw e;
            availProcessors = Runtime.getRuntime().availableProcessors();
                        limit
            super(in);
     * An {@link IntConsumer} that throws a {@link TooManyBucketsException}
import org.opensearch.core.xcontent.XContentBuilder;
                if (count > limit) {
    /**
    public static final int DEFAULT_MAX_BUCKETS = 65535;
        ) {
     * Thrown when there are too many buckets
    int resolveMaxBuckets() {
 * @opensearch.internal
                throw new CircuitBreakingException(
    );
        private final int limit;
import org.opensearch.core.common.breaker.CircuitBreaker;
        }
        ClusterService clusterService,
            this.limit = limit;
            callCount = new LongAdder();
 * You may obtain a copy of the License at
            if (workloadGroup == null) {
 * KIND, either express or implied.  See the License for the
 * The limit can be set by changing the `search.max_buckets` cluster setting and defaults to 65535.
                count += value;
        private final CircuitBreaker breaker;
        public void writeTo(StreamOutput out) throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        "search.max_buckets",
import org.opensearch.core.common.io.stream.StreamOutput;
            long sum = callCount.sum();
    }
import org.opensearch.cluster.metadata.WorkloadGroup;
        public void accept(int value) {
            this.callCount = callCount;
    private volatile int maxBucket;
 * Licensed to Elasticsearch under one or more contributor
    public static final Setting<Integer> MAX_BUCKET_SETTING = Setting.intSetting(
                }
            maxBuckets = in.readInt();
            }
import org.opensearch.wlm.WorkloadGroupService;
        }
    private static final Logger logger = LogManager.getLogger(MultiBucketConsumerService.class);
     * workload group, the group is unknown, or the group does not define
    private final WorkloadGroupService workloadGroupService;
import java.io.IOException;
 */
    public MultiBucketConsumer create() {
        public int getLimit() {
            this.limit = limit;
 * ownership. Elasticsearch licenses this file to you under
            }
     * @opensearch.api
 * GitHub history for details.
        } catch (Exception e) {
                    throw new TooManyBucketsException(
     * {@link Aggregator#buildAggregations} and {@link InternalAggregation#reduce}.
            this.breaker = breaker;
                return maxBucket;
        return new MultiBucketConsumer(resolveMaxBuckets(), breaker);
        @Override
                } catch (CircuitBreakingException e) {
            // check parent circuit breaker every 1024 to (1024 + available processors) calls
            return maxBucket;
}
        // count is currently only updated in final reduce phase which is executed in single thread for both concurrent and non-concurrent
        public TooManyBucketsException(StreamInput in) throws IOException {
            if (circuitBreakerTripped) {
            return RestStatus.SERVICE_UNAVAILABLE;
    }
            // tripping the circuit breaker for other threads in case of concurrent search
        private final LongAdder callCount;
    }
            return count;
        @Override
     *
            if ((sum >= 1024) && (sum & 0x3FF) <= availProcessors) {
        try {
     * workload group (if any) attached to the calling thread context. If the request has no
        }
        }
        CircuitBreaker breaker,
     * {@code search.max_buckets}, the cluster-level default is returned.
    /**
 * Unless required by applicable law or agreed to in writing,
                );
            int availProcessors
 *
import java.util.concurrent.atomic.LongAdder;
        }
        private final int maxBuckets;
                }
 * this file be licensed under the Apache-2.0 license or a
            CircuitBreaker breaker,
            this.count = 0;
            boolean circuitBreakerTripped,
     */
import java.util.function.IntConsumer;
        }
    /**
import org.apache.logging.log4j.LogManager;
        private volatile boolean circuitBreakerTripped;
