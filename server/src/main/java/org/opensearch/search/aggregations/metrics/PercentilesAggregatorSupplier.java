 * compatible open source license.
        PercentilesConfig percentilesConfig,
 * You may obtain a copy of the License at  
/*
public interface PercentilesAggregatorSupplier {
 * Licensed to Elasticsearch under one or more contributor  
 *  
 */  
 * KIND, either express or implied.  See the License for the
 * @opensearch.internal
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        DocValueFormat formatter,
 *
import java.util.Map;  
import org.opensearch.search.DocValueFormat;  
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See  
 * Unless required by applicable law or agreed to in writing,
        String name,  
 *
 * license agreements. See the NOTICE file distributed with
    Aggregator build(
        boolean keyed,  
 *    http://www.apache.org/licenses/LICENSE-2.0
        Map<String, Object> metadata
    ) throws IOException;  
 * under the License.  
        ValuesSource valuesSource,
 */
import org.opensearch.search.aggregations.Aggregator;
        SearchContext context,
import org.opensearch.search.internal.SearchContext;  
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
        double[] percents,
 */
 * GitHub history for details.
 * specific language governing permissions and limitations
import org.opensearch.search.aggregations.support.ValuesSource;
 * this file be licensed under the Apache-2.0 license or a
 */  
        Aggregator parent,  
 * The OpenSearch Contributors require contributions made to  
/**
 * Aggregator supplier interface for percentiles aggs  
import java.io.IOException;
package org.opensearch.search.aggregations.metrics;
 * this work for additional information regarding copyright
 *
}
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
/*
