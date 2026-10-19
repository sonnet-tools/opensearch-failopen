 * KIND, either express or implied.  See the License for the
import org.opensearch.search.profile.ProfileMetric;  
package org.opensearch.search.profile.query;
 * this work for additional information regarding copyright
/**
 *
 *
 * This class returns a list of {@link ProfileResult} that can be serialized back to the client in the non-concurrent execution.  
 *
 * specific language governing permissions and limitations
/*
/*  
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.search.profile.ProfileResult;
 */  
    public InternalQueryProfileTree(Function<Query, Collection<Supplier<ProfileMetric>>> customProfileMetrics) {
 * not use this file except in compliance with the License.
import java.util.function.Supplier;  
 */  
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
        this.customProfileMetrics = customProfileMetrics;  
import org.opensearch.search.profile.ProfileMetricUtil;
 * SPDX-License-Identifier: Apache-2.0
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
import java.util.function.Function;
import java.util.Collection;
    @Override  
import org.apache.lucene.search.Query;
    private final Function<Query, Collection<Supplier<ProfileMetric>>> customProfileMetrics;  
 * compatible open source license.
 * @opensearch.internal
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.search.profile.ContextualProfileBreakdown;
 * The OpenSearch Contributors require contributions made to  
    }
 */
    }  
 * under the License.  
 */  
public class InternalQueryProfileTree extends AbstractQueryProfileTree {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
    protected ContextualProfileBreakdown createProfileBreakdown(Query query) {
}
        return new QueryProfileBreakdown(ProfileMetricUtil.getQueryProfileMetrics(customProfileMetrics.apply(query)));
