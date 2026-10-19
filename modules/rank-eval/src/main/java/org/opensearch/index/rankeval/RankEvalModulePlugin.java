/*  
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
        );
import org.opensearch.rest.RestController;
            new NamedWriteableRegistry.Entry(MetricDetail.class, ExpectedReciprocalRank.NAME, ExpectedReciprocalRank.Detail::new)
        namedWriteables.add(  
    }
 * Licensed to Elasticsearch under one or more contributor  
import java.util.ArrayList;
        namedWriteables.add(new NamedWriteableRegistry.Entry(MetricDetail.class, RecallAtK.NAME, RecallAtK.Detail::new));
        );
        return Arrays.asList(new ActionHandler<>(RankEvalAction.INSTANCE, TransportRankEvalAction.class));
        return new RankEvalNamedXContentProvider().getNamedXContentParsers();
 * this work for additional information regarding copyright
import java.util.Arrays;
import org.opensearch.common.settings.ClusterSettings;
 *
        Settings settings,
    public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
 * this file be licensed under the Apache-2.0 license or a
    public List<NamedWriteableRegistry.Entry> getNamedWriteables() {
        Supplier<DiscoveryNodes> nodesInCluster
import org.opensearch.core.action.ActionResponse;
/*  
        SettingsFilter settingsFilter,
        namedWriteables.add(  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        IndexNameExpressionResolver indexNameExpressionResolver,  
        ClusterSettings clusterSettings,  
 * not use this file except in compliance with the License.
import org.opensearch.plugins.Plugin;  
import org.opensearch.common.settings.IndexScopedSettings;
 * license agreements. See the NOTICE file distributed with
    ) {
import org.opensearch.cluster.node.DiscoveryNodes;  
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
    }  
            new NamedWriteableRegistry.Entry(EvaluationMetric.class, ExpectedReciprocalRank.NAME, ExpectedReciprocalRank::new)
        );
        namedWriteables.add(new NamedWriteableRegistry.Entry(EvaluationMetric.class, MeanReciprocalRank.NAME, MeanReciprocalRank::new));
import org.opensearch.common.settings.SettingsFilter;
 * You may obtain a copy of the License at  
    public List<RestHandler> getRestHandlers(  
import java.util.function.Supplier;
 * ownership. Elasticsearch licenses this file to you under  
 */  
import org.opensearch.action.ActionRequest;
/*
    @Override
 * compatible open source license.
package org.opensearch.index.rankeval;
        );
 */
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        namedWriteables.add(new NamedWriteableRegistry.Entry(EvaluationMetric.class, PrecisionAtK.NAME, PrecisionAtK::new));  
}
public class RankEvalModulePlugin extends Plugin implements ActionPlugin {
            new NamedWriteableRegistry.Entry(MetricDetail.class, DiscountedCumulativeGain.NAME, DiscountedCumulativeGain.Detail::new)
    }  
        namedWriteables.add(  
        namedWriteables.add(  
        RestController restController,
        namedWriteables.add(new NamedWriteableRegistry.Entry(MetricDetail.class, PrecisionAtK.NAME, PrecisionAtK.Detail::new));  
        IndexScopedSettings indexScopedSettings,
import java.util.List;
    }
 * software distributed under the License is distributed on an
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
        return Collections.singletonList(new RestRankEvalAction());  
 * specific language governing permissions and limitations
    @Override  
        namedWriteables.add(new NamedWriteableRegistry.Entry(EvaluationMetric.class, RecallAtK.NAME, RecallAtK::new));
 *  
    public List<Entry> getNamedXContent() {
        namedWriteables.add(new NamedWriteableRegistry.Entry(MetricDetail.class, MeanReciprocalRank.NAME, MeanReciprocalRank.Detail::new));
 *
import org.opensearch.plugins.ActionPlugin;
 * the Apache License, Version 2.0 (the "License"); you may
    @Override  
 */  
    @Override  
        List<NamedWriteableRegistry.Entry> namedWriteables = new ArrayList<>();
        return namedWriteables;  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
            new NamedWriteableRegistry.Entry(EvaluationMetric.class, DiscountedCumulativeGain.NAME, DiscountedCumulativeGain::new)
 * KIND, either express or implied.  See the License for the
import java.util.Collections;  
import org.opensearch.core.xcontent.NamedXContentRegistry.Entry;
import org.opensearch.common.settings.Settings;  
import org.opensearch.rest.RestHandler;
