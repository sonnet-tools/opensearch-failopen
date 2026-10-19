 * Licensed to Elasticsearch under one or more contributor  
        Map<String, Object> metadata
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.search.aggregations.Aggregator;
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
 *     http://www.apache.org/licenses/LICENSE-2.0
        SearchContext context,
/*  
 * not use this file except in compliance with the License.
package org.opensearch.search.aggregations.bucket.range;
 *
 */  
import java.util.Map;
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.search.aggregations.CardinalityUpperBound;
 */
 */  
 * ownership. Elasticsearch licenses this file to you under  
}
/**  
        DocValueFormat format,
import org.opensearch.search.internal.SearchContext;  
    Aggregator build(
 *
/*
 *
    ) throws IOException;  
 * @opensearch.internal  
import java.util.List;  
 * Unless required by applicable law or agreed to in writing,
        Aggregator parent,  
        List<BinaryRangeAggregator.Range> ranges,  
        ValuesSource valuesSource,
 * KIND, either express or implied.  See the License for the
import org.opensearch.search.aggregations.support.ValuesSource;
 * GitHub history for details.
import org.opensearch.search.aggregations.AggregatorFactories;  
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
 */
        AggregatorFactories factories,  
 * compatible open source license.
 * under the License.  
 *  
 * specific language governing permissions and limitations
        boolean keyed,
        String name,
        CardinalityUpperBound cardinality,
import org.opensearch.search.DocValueFormat;
import java.io.IOException;
 * license agreements. See the NOTICE file distributed with
public interface IpRangeAggregatorSupplier {
 * Aggregator supplier interface for ip_range agg
