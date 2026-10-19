    @Deprecated
 * The OpenSearch Contributors require contributions made to  
/*  
 *
 * Licensed to Elasticsearch under one or more contributor  
    @Deprecated
 * specific language governing permissions and limitations
 *
    @Deprecated
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
    T dateHistogramInterval(DateHistogramInterval dateHistogramInterval);
/*  
    DateHistogramInterval dateHistogramInterval();  
}
    @Deprecated
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
/**
 * GitHub history for details.
 * A shared interface for aggregations that parse and use "interval" parameters.
package org.opensearch.search.aggregations.bucket.histogram;
 */  
 * Provides definitions for the new fixed and calendar intervals, and deprecated
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
 * <p>  
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
    long interval();  
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
 *  
 */
 * not use this file except in compliance with the License.
 * defintions for the old interval/dateHisto interval parameters
 */  
    T fixedInterval(DateHistogramInterval interval);  
public interface DateIntervalConsumer<T> {  
    T interval(long interval);
 * @opensearch.internal
 */
    T calendarInterval(DateHistogramInterval interval);
 * compatible open source license.
