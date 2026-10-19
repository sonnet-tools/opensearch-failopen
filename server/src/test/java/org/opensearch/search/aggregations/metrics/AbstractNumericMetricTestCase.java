 */  
 *
 */  
        return factory;
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * ownership. Elasticsearch licenses this file to you under  
 *  
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;  
import org.opensearch.search.aggregations.BaseAggregationTestCase;
    BaseAggregationTestCase<AF> {  
package org.opensearch.search.aggregations.metrics;
/*  
 * KIND, either express or implied.  See the License for the
        String field = randomNumericField();
        }  
 * this work for additional information regarding copyright
        randomFieldOrScript(factory, field);  
 * GitHub history for details.
 *
 * SPDX-License-Identifier: Apache-2.0
/*
    @Override
        AF factory = doCreateTestAggregatorFactory();
    protected abstract AF doCreateTestAggregatorFactory();
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
import org.opensearch.search.aggregations.support.ValuesSource;
 */
/*  
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public abstract class AbstractNumericMetricTestCase<AF extends ValuesSourceAggregationBuilder.LeafOnly<ValuesSource.Numeric, AF>> extends
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
            factory.missing("MISSING");
 * Licensed to Elasticsearch under one or more contributor  
}
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
    protected final AF createTestAggregatorBuilder() {  
 * under the License.  
        if (randomBoolean()) {
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
