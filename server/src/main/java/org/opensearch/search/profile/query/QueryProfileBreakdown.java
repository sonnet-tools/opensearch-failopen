 * Modifications Copyright OpenSearch Contributors. See
/*
 * specific language governing permissions and limitations
 * under the License.  
/**
import org.opensearch.search.profile.AbstractProfileBreakdown;
import java.util.function.Supplier;  
    }
 *
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Collection;
    }  
    public QueryProfileBreakdown(Collection<Supplier<ProfileMetric>> metrics) {
 * Unless required by applicable law or agreed to in writing,
public final class QueryProfileBreakdown extends ContextualProfileBreakdown {  
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
/*  
 */  
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
    @Override  
 * KIND, either express or implied.  See the License for the
/*  
import org.opensearch.search.profile.ProfileMetric;  
 * @opensearch.internal
 * software distributed under the License is distributed on an
 */
 * the Apache License, Version 2.0 (the "License"); you may
 *
        return this;
 * A node's time may be composed of several internal attributes (rewriting, weighting,
 *  
    public AbstractProfileBreakdown context(Object context) {
 * compatible open source license.
 * scoring, etc).
 * not use this file except in compliance with the License.
 */  
}
import org.opensearch.search.profile.ContextualProfileBreakdown;
package org.opensearch.search.profile.query;
        super(metrics);  
 */
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
 * A record of timings for the various operations that may happen during query execution.  
 *  
 * SPDX-License-Identifier: Apache-2.0
