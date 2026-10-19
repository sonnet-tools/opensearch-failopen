 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected AggregationProfileBreakdown createProfileBreakdown(Aggregator aggregator) {  
    /**
 */  
 * @opensearch.internal
        return element.name();
}
 *  
 * GitHub history for details.
     * So the name returned here should be same across slices for an aggregation operator.  
        if (element.getClass().getSimpleName().isEmpty()) {  
        if (enclosing != null) {
package org.opensearch.search.profile.aggregation;
        return new AggregationProfileBreakdown();
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
import org.opensearch.search.aggregations.Aggregator;
 */  
 * The profiling tree for different levels of agg profiling
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
     * @return is used to group aggregations with same name across slices.
        // Anonymous classes (such as NonCollectingAggregator in TermsAgg) won't have a name,
 * The OpenSearch Contributors require contributions made to  
 *
 * not use this file except in compliance with the License.
/*
 */
    }
    }
 *
 * license agreements. See the NOTICE file distributed with
    @Override
 * under the License.  
 * this work for additional information regarding copyright
 */
    @Override
 * KIND, either express or implied.  See the License for the
        Class<?> enclosing = element.getClass().getEnclosingClass();  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.profile.AbstractInternalProfileTree;
        return element.getClass().getSimpleName();
 * SPDX-License-Identifier: Apache-2.0
    protected String getTypeFromElement(Aggregator element) {
    }
/*  
 * Licensed to Elasticsearch under one or more contributor  
    @Override
 * Unless required by applicable law or agreed to in writing,
    protected String getDescriptionFromElement(Aggregator element) {  
/*  
 *  
     */
public class InternalAggregationProfileTree extends AbstractInternalProfileTree<AggregationProfileBreakdown, Aggregator> {  
            return element.getClass().getSuperclass().getSimpleName();
        }  
 * this file be licensed under the Apache-2.0 license or a
        // we need to get the super class
            return enclosing.getSimpleName() + "." + element.getClass().getSimpleName();
        }
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
/**
