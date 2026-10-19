 * this file be licensed under the Apache-2.0 license or a
        String name,  
 *
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
 */
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
public interface MedianAbsoluteDeviationAggregatorSupplier {
import java.util.Map;  
/**
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
 */  
 *
import org.opensearch.search.aggregations.Aggregator;
        double compression  
 *
/*
import java.io.IOException;
import org.opensearch.search.aggregations.support.ValuesSource;
        Aggregator parent,
 * Aggregator supplier interface for median_absolute_deviation agg  
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.DocValueFormat;  
 * GitHub history for details.
 * You may obtain a copy of the License at  
        SearchContext context,  
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
 */  
/*  
 * the Apache License, Version 2.0 (the "License"); you may
    ) throws IOException;
 * @opensearch.internal
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See  
        Map<String, Object> metadata,
 * under the License.  
        DocValueFormat format,
import org.opensearch.search.internal.SearchContext;  
package org.opensearch.search.aggregations.metrics;
        ValuesSource valuesSource,
 *  
/*
 */
    Aggregator build(
