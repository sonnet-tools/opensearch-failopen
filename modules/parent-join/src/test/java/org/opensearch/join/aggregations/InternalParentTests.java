 * this file be licensed under the Apache-2.0 license or a
        // Nothing extra to assert  
/*  
        extendedNamedXContents.add(  
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
    protected SearchPlugin registerPlugin() {
 */  
    ) {  
import java.util.List;
    }
import org.opensearch.search.aggregations.bucket.ParsedSingleBucketAggregation;
package org.opensearch.join.aggregations;
 * compatible open source license.
    }
        return ParsedParent.class;
        Map<String, Object> metadata
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
/*  
    @Override  
    @Override
        return new InternalParent(name, docCount, aggregations, metadata);
            new Entry(Aggregation.class, new ParseField(ParentAggregationBuilder.NAME), (p, c) -> ParsedParent.fromXContent(p, (String) c))
 */  
import java.util.Map;  
    @Override
import org.opensearch.search.aggregations.Aggregation;
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
        return extendedNamedXContents;  
    protected InternalParent createTestInstance(
    protected List<Entry> getNamedXContents() {
    @Override  
    @Override  
import org.opensearch.plugins.SearchPlugin;
import org.opensearch.search.aggregations.InternalSingleBucketAggregationTestCase;
    }
 *
 * KIND, either express or implied.  See the License for the
        String name,
import java.util.ArrayList;
        List<Entry> extendedNamedXContents = new ArrayList<>(super.getNamedXContents());
 * under the License.  
        return new ParentJoinModulePlugin();  
    }
}
 * not use this file except in compliance with the License.
        long docCount,  
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
import org.opensearch.join.ParentJoinModulePlugin;  
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
        InternalAggregations aggregations,
    protected void extraAssertReduced(InternalParent reduced, List<InternalParent> inputs) {
        );
public class InternalParentTests extends InternalSingleBucketAggregationTestCase<InternalParent> {
 */
import org.opensearch.core.ParseField;
 * specific language governing permissions and limitations
    protected Class<? extends ParsedSingleBucketAggregation> implementationClass() {
    }  
import org.opensearch.core.xcontent.NamedXContentRegistry.Entry;
 *  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.search.aggregations.InternalAggregations;  
 * Unless required by applicable law or agreed to in writing,
