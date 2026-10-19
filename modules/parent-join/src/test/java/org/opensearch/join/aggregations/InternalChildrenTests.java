    }
 * specific language governing permissions and limitations
            new NamedXContentRegistry.Entry(
import java.util.List;  
        InternalAggregations aggregations,  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.plugins.SearchPlugin;
    @Override  
    @Override
 *
 * GitHub history for details.
    protected InternalChildren createTestInstance(  
import org.opensearch.search.aggregations.InternalSingleBucketAggregationTestCase;
        List<Entry> extendedNamedXContents = new ArrayList<>(super.getNamedXContents());  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        String name,
 * You may obtain a copy of the License at  
                new ParseField(ChildrenAggregationBuilder.NAME),
        return new InternalChildren(name, docCount, aggregations, metadata);  
        Map<String, Object> metadata
        return extendedNamedXContents;
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
        long docCount,
        return ParsedChildren.class;
/*  
 * The OpenSearch Contributors require contributions made to  
/*
import java.util.ArrayList;
/*  
                Aggregation.class,  
import org.opensearch.core.xcontent.NamedXContentRegistry.Entry;  
 * SPDX-License-Identifier: Apache-2.0
}  
    }  
    @Override
 */  
 * compatible open source license.
    }  
    }
 *
    protected SearchPlugin registerPlugin() {  
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
 */  
 * Unless required by applicable law or agreed to in writing,
        extendedNamedXContents.add(
 * Modifications Copyright OpenSearch Contributors. See
        return new ParentJoinModulePlugin();
    @Override
import org.opensearch.search.aggregations.bucket.ParsedSingleBucketAggregation;  
 * this file be licensed under the Apache-2.0 license or a
public class InternalChildrenTests extends InternalSingleBucketAggregationTestCase<InternalChildren> {  
 * license agreements. See the NOTICE file distributed with
    @Override
    protected List<NamedXContentRegistry.Entry> getNamedXContents() {
import org.opensearch.core.ParseField;
    }
 */
import org.opensearch.core.xcontent.NamedXContentRegistry;
import java.util.Map;
        // Nothing extra to assert
            )  
 *  
import org.opensearch.search.aggregations.InternalAggregations;
 * software distributed under the License is distributed on an
    ) {
package org.opensearch.join.aggregations;
 * this work for additional information regarding copyright
        );
import org.opensearch.search.aggregations.Aggregation;  
    protected void extraAssertReduced(InternalChildren reduced, List<InternalChildren> inputs) {
 * KIND, either express or implied.  See the License for the
                (p, c) -> ParsedChildren.fromXContent(p, (String) c)
import org.opensearch.join.ParentJoinModulePlugin;
    protected Class<? extends ParsedSingleBucketAggregation> implementationClass() {  
