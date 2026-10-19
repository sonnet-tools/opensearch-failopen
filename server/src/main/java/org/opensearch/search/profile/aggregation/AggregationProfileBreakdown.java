    private final Map<String, Object> extra = new HashMap<>();
 * ownership. Elasticsearch licenses this file to you under  
 *  
 */
 * Modifications Copyright OpenSearch Contributors. See
}  
 * specific language governing permissions and limitations
package org.opensearch.search.profile.aggregation;
import org.opensearch.search.profile.AbstractProfileBreakdown;
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void addDebugInfo(String key, Object value) {  
        this(ProfileMetricUtil.getAggregationProfileMetrics());
 * GitHub history for details.
        return unmodifiableMap(extra);  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
     * Add extra debugging information about the aggregation.
import java.util.function.Supplier;  
/*
 */
import org.opensearch.search.profile.ProfileMetric;  
import java.util.Collection;  
 * license agreements. See the NOTICE file distributed with
@PublicApi(since = "1.0.0")  
    }
/**
 * software distributed under the License is distributed on an
    public Map<String, Object> toDebugMap() {
     */
 * Unless required by applicable law or agreed to in writing,
 * {@linkplain AbstractProfileBreakdown} customized to work with aggregations.
 */  
        extra.put(key, value);
import java.util.Map;
 * SPDX-License-Identifier: Apache-2.0
    }
 * Licensed to Elasticsearch under one or more contributor  
    @Override
 * You may obtain a copy of the License at  
/*  
 * @opensearch.api
 * not use this file except in compliance with the License.
import static java.util.Collections.unmodifiableMap;
 * under the License.  
    public AggregationProfileBreakdown() {
    /**  
    }  
 *
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
    }
        super(timers);  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.profile.ProfileMetricUtil;
import org.opensearch.common.annotation.PublicApi;
 *  
    public AggregationProfileBreakdown(Collection<Supplier<ProfileMetric>> timers) {
import java.util.HashMap;
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
public class AggregationProfileBreakdown extends AbstractProfileBreakdown {
 * compatible open source license.
/*  
