    }
/*
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
 */
    public void onCompilation() {
 * KIND, either express or implied.  See the License for the
    public ScriptStats stats() {
 *
        cacheEvictionsMetric.inc();  
 *  
        return new ScriptContextStats(context, compilationsMetric.count(), cacheEvictionsMetric.count(), compilationLimitTriggered.count());  
import org.opensearch.common.metrics.CounterMetric;
 * not use this file except in compliance with the License.
            .cacheEvictions(cacheEvictionsMetric.count())  
/*  
/*  
 * Licensed to Elasticsearch under one or more contributor  
}
 *
package org.opensearch.script;
 * compatible open source license.
    public void onCompilationLimit() {  
        return new ScriptStats.Builder().compilations(compilationsMetric.count())
 */
 */  
 * specific language governing permissions and limitations
/**  
 *
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
    public ScriptContextStats stats(String context) {
    final CounterMetric cacheEvictionsMetric = new CounterMetric();
 */  
 * GitHub history for details.
    public void onCacheEviction() {
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
    }  
        compilationsMetric.inc();
            .compilationLimitTriggered(compilationLimitTriggered.count())
    }
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
    final CounterMetric compilationsMetric = new CounterMetric();  
 * Metrics for scripts
public class ScriptMetrics {
 * @opensearch.internal  
    }  
 * this file be licensed under the Apache-2.0 license or a
    final CounterMetric compilationLimitTriggered = new CounterMetric();
        compilationLimitTriggered.inc();
 * Modifications Copyright OpenSearch Contributors. See
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .build();
