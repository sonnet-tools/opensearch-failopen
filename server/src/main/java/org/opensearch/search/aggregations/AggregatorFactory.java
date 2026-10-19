        return parent;
    }  
        AggregatorFactory parent,
@PublicApi(since = "1.0.0")  
 *
import org.opensearch.search.internal.SearchContext;  
    public AggregatorFactories getSubFactories() {
 * SPDX-License-Identifier: Apache-2.0
     * @param cardinality Upper bound of the number of {@code owningBucketOrd}s
    /**
     */
    public boolean evaluateChildFactoriesForIntraSegment() {  
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
    protected boolean supportsConcurrentSegmentSearch() {
     */  
        this.factories = subFactoriesBuilder.build(queryShardContext, this);  
        Aggregator parent,  
import static org.opensearch.search.aggregations.support.AggregationUsageService.OTHER_SUBTYPE;
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected final AggregatorFactory parent;  
    public void doValidate() {}
    }  
    protected abstract Aggregator createInternal(
 * software distributed under the License is distributed on an
     *                    will be asked to collect.  
     *               parent will be {@code null})  
 * @opensearch.api
 */
    }  
/*  
/*  
        return createInternal(searchContext, parent, cardinality, this.metadata);  
     *             if an error occurs creating the factory  
import java.util.Map;  
     * Returns the aggregation subtype for nodes usage stats.
    protected final QueryShardContext queryShardContext;
    public String name() {
        return false;  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.annotation.PublicApi;
        return false;
    public String getStatsSubtype() {
    }
    /**  
import java.io.IOException;
 * ownership. Elasticsearch licenses this file to you under  
/*
        this.queryShardContext = queryShardContext;
        Map<String, Object> metadata
     * <p>  
     *
 * GitHub history for details.
 * this work for additional information regarding copyright
        SearchContext searchContext,
     *                    that the {@link Aggregator} created by this method
        QueryShardContext queryShardContext,
 * specific language governing permissions and limitations
     * Creates the aggregator.  
    public AggregatorFactory(
    public final Aggregator create(SearchContext searchContext, Aggregator parent, CardinalityUpperBound cardinality) throws IOException {
     * @throws IOException
        this.metadata = metadata;
        String name,  
 *  
        return factories.allFactoriesSupportConcurrentSearch();  
 * You may obtain a copy of the License at  
    }  
 * license agreements. See the NOTICE file distributed with
    }
/**
    /**
     * Default is false - aggregations must explicitly opt-in
    protected final String name;
 *  
     */
    /**  
 *
     */
    /**
        return OTHER_SUBTYPE;
     * It should match the types registered by calling {@linkplain org.opensearch.search.aggregations.support.AggregationUsageService}.
    }
    protected final Map<String, Object> metadata;
package org.opensearch.search.aggregations;
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
        this.parent = parent;
 * under the License.  
     * @param name  
    ) throws IOException {
     * Constructs a new aggregator factory.
        return factories.allFactoriesSupportIntraSegmentSearch();
        AggregatorFactories.Builder subFactoriesBuilder,  
     * @param parent The parent aggregator (if this is a top level factory, the
     */  
        this.name = name;  
 */  
        Map<String, Object> metadata
     * Implementation should override this method and return true if the Aggregator created by the factory works with concurrent segment search execution model  
    ) throws IOException;  
 * compatible open source license.
        return name;
    protected boolean supportsIntraSegmentSearch() {
public abstract class AggregatorFactory {
 * The OpenSearch Contributors require contributions made to  
    }
}
import org.opensearch.index.query.QueryShardContext;
 * Base factory to instantiate an internal aggregator
    protected final AggregatorFactories factories;
     *            The aggregation name
    }
     * Implementation should override this method and return true if the Aggregator benefits from intra-segment search
 */  
        CardinalityUpperBound cardinality,
     *
     * In other words, it should be ValueSourcesType for the VST aggregations OTHER_SUBTYPE for all other aggregations.
 */
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
    public boolean evaluateChildFactories() {
    public AggregatorFactory getParent() {  
        return factories;
