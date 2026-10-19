import org.opensearch.join.aggregations.ParentAggregationBuilder;
package org.opensearch.join.spi;
        ParseField parseFieldChildren = new ParseField(ChildrenAggregationBuilder.NAME);  
 *
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
 */
        return Arrays.asList(
import org.opensearch.core.xcontent.NamedXContentRegistry;  
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.plugins.spi.NamedXContentProvider;
        ParseField parseFieldParent = new ParseField(ParentAggregationBuilder.NAME);
 *
 * GitHub history for details.
 *  
import java.util.Arrays;
import org.opensearch.join.aggregations.ChildrenAggregationBuilder;
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
    }
        );
 */  
            new NamedXContentRegistry.Entry(Aggregation.class, parseFieldChildren, contextParserChildren),
 * SPDX-License-Identifier: Apache-2.0
        ContextParser<Object, Aggregation> contextParserChildren = (p, name) -> ParsedChildren.fromXContent(p, (String) name);
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;  
/*
    public List<NamedXContentRegistry.Entry> getNamedXContentParsers() {
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.join.aggregations.ParsedChildren;  
import org.opensearch.core.ParseField;
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
import org.opensearch.join.aggregations.ParsedParent;
 * under the License.  
public class ParentJoinNamedXContentProvider implements NamedXContentProvider {
 * the Apache License, Version 2.0 (the "License"); you may
}  
import org.opensearch.core.xcontent.ContextParser;
 * specific language governing permissions and limitations
/*  
/*  
 * Licensed to Elasticsearch under one or more contributor  
            new NamedXContentRegistry.Entry(Aggregation.class, parseFieldParent, contextParserParent)  
 *    http://www.apache.org/licenses/LICENSE-2.0
        ContextParser<Object, Aggregation> contextParserParent = (p, name) -> ParsedParent.fromXContent(p, (String) name);  
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
import org.opensearch.search.aggregations.Aggregation;  
