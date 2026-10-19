import org.opensearch.core.ParseField;
    public List<NamedXContentRegistry.Entry> getNamedXContentParsers() {
 * compatible open source license.
 *  
 * specific language governing permissions and limitations
 * under the License.  
        ParseField parseField = new ParseField(MatrixStatsAggregationBuilder.NAME);
 * software distributed under the License is distributed on an
    }
public class MatrixStatsNamedXContentProvider implements NamedXContentProvider {
 * KIND, either express or implied.  See the License for the
import java.util.List;  
 * The OpenSearch Contributors require contributions made to  
 */
 * not use this file except in compliance with the License.
import org.opensearch.core.xcontent.ContextParser;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
/*  
        ContextParser<Object, Aggregation> contextParser = (p, name) -> ParsedMatrixStats.fromXContent(p, (String) name);  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.aggregations.Aggregation;
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
/*  
 * Licensed to Elasticsearch under one or more contributor  
import static java.util.Collections.singletonList;
 * license agreements. See the NOTICE file distributed with
}  
import org.opensearch.core.xcontent.NamedXContentRegistry;  
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
 *
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.search.aggregations.matrix.stats.MatrixStatsAggregationBuilder;  
        return singletonList(new NamedXContentRegistry.Entry(Aggregation.class, parseField, contextParser));
 * this file be licensed under the Apache-2.0 license or a
 *
 */  
import org.opensearch.search.aggregations.matrix.stats.ParsedMatrixStats;
import org.opensearch.plugins.spi.NamedXContentProvider;
package org.opensearch.search.aggregations.matrix.spi;
 * the Apache License, Version 2.0 (the "License"); you may
    @Override  
 */  
