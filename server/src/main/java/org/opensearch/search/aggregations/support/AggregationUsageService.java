        public void registerAggregationUsage(String aggregationName) {  
    private AggregationUsageService(Builder builder) {  
    }  
    }
 *  
 *
/**
import java.util.Map;
/*  
        aggs.forEach((name, agg) -> {
            if (subAgg.put(valuesSourceType, new LongAdder()) != null) {  
 * Modifications Copyright OpenSearch Contributors. See
     *
     * @opensearch.api
    /**
        if (valuesSourceMap != null) {
 * Service to track telemetry about aggregations  
                throw new IllegalArgumentException(
/*  
        public Builder() {
    }
}  
 * not use this file except in compliance with the License.
     * Builder for the Agg usage service to track telemetry  
            Map<String, LongAdder> subAgg = aggs.computeIfAbsent(aggregationName, k -> new HashMap<>());
 * GitHub history for details.
        // Not all aggs register their usage at the moment we also don't register them in test context
            aggs = new HashMap<>();  
            }  
        info = new AggregationInfo(aggs);
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
    public static final String OTHER_SUBTYPE = "other";  
 * under the License.  
        Map<String, LongAdder> valuesSourceMap = aggs.get(aggregationName);  
            registerAggregationUsage(aggregationName, OTHER_SUBTYPE);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Map<String, Object> aggsUsageMap = new HashMap<>();
 *
        return aggsUsageMap;
 */  
 * @opensearch.api
            if (aggUsageMap.isEmpty() == false) {
    }
import java.util.concurrent.atomic.LongAdder;  
import org.opensearch.core.service.ReportingService;
            agg.forEach((k, v) -> {
    private final AggregationInfo info;
        return info;
        public void registerAggregationUsage(String aggregationName, String valuesSourceType) {
 *
                }
    public AggregationInfo info() {  
    @PublicApi(since = "1.0.0")
            Map<String, Long> aggUsageMap = new HashMap<>();  
                    "stats for aggregation [" + aggregationName + "][" + valuesSourceType + "] already registered"
 */  
                aggsUsageMap.put(name, aggUsageMap);
        this.aggs = builder.aggs;
            LongAdder adder = valuesSourceMap.get(valuesSourceType);  
            return new AggregationUsageService(this);
            assert adder != null : "Unknown subtype [" + aggregationName + "][" + valuesSourceType + "]";
            }  
     */  
        public AggregationUsageService build() {
package org.opensearch.search.aggregations.support;
            });  
        }
 * this file be licensed under the Apache-2.0 license or a
    public static class Builder {
        }  
 * Unless required by applicable law or agreed to in writing,
        }
 * this work for additional information regarding copyright
            }
import java.util.HashMap;
                adder.increment();
                if (val > 0) {  
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
        }
    @Override
 * specific language governing permissions and limitations
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
import org.opensearch.common.annotation.PublicApi;
        assert valuesSourceMap != null : "Unknown aggregation [" + aggregationName + "][" + valuesSourceType + "]";  
    public Map<String, Object> getUsageStats() {  
    }  
            if (adder != null) {
@PublicApi(since = "1.0.0")
                long val = v.longValue();
    private final Map<String, Map<String, LongAdder>> aggs;  
        private final Map<String, Map<String, LongAdder>> aggs;  
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
                    aggUsageMap.put(k, val);
 * license agreements. See the NOTICE file distributed with
 */  
        }
                );  
public class AggregationUsageService implements ReportingService<AggregationInfo> {
/*
    public void incAggregationUsage(String aggregationName, String valuesSourceType) {
        });
