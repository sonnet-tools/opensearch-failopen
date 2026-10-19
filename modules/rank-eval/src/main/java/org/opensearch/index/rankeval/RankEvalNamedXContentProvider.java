    @Override
        namedXContent.add(
                MetricDetail.class,
 * Licensed to Elasticsearch under one or more contributor  
                new ParseField(DiscountedCumulativeGain.NAME),  
                new ParseField(MeanReciprocalRank.NAME),
package org.opensearch.index.rankeval;
        namedXContent.add(  
import org.opensearch.core.ParseField;
                ExpectedReciprocalRank::fromXContent
            new NamedXContentRegistry.Entry(
                DiscountedCumulativeGain.Detail::fromXContent
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        );  
 *
        );
 * compatible open source license.
        namedXContent.add(
                MetricDetail.class,  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.xcontent.NamedXContentRegistry;
 */
 * Unless required by applicable law or agreed to in writing,
                new ParseField(ExpectedReciprocalRank.NAME),
        namedXContent.add(
        );
                ExpectedReciprocalRank.Detail::fromXContent  
 * Modifications Copyright OpenSearch Contributors. See
/*
import java.util.List;  
/*  
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
            )
                EvaluationMetric.class,  
 * this work for additional information regarding copyright
public class RankEvalNamedXContentProvider implements NamedXContentProvider {
/*  
            )
        List<NamedXContentRegistry.Entry> namedXContent = new ArrayList<>();  
 * You may obtain a copy of the License at  
        namedXContent.add(
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
            new NamedXContentRegistry.Entry(MetricDetail.class, new ParseField(PrecisionAtK.NAME), PrecisionAtK.Detail::fromXContent)
        namedXContent.add(
}
        );
        );
import java.util.ArrayList;
            new NamedXContentRegistry.Entry(  
                EvaluationMetric.class,
            )  
                new ParseField(DiscountedCumulativeGain.NAME),
 * SPDX-License-Identifier: Apache-2.0
            )
        return namedXContent;  
                MetricDetail.class,
        );
            new NamedXContentRegistry.Entry(  
        );  
    }
            new NamedXContentRegistry.Entry(
        namedXContent.add(  
                DiscountedCumulativeGain::fromXContent
 */  
        namedXContent.add(new NamedXContentRegistry.Entry(EvaluationMetric.class, new ParseField(RecallAtK.NAME), RecallAtK::fromXContent));
            )  
                new ParseField(MeanReciprocalRank.NAME),  
        namedXContent.add(  
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
 */  
                EvaluationMetric.class,
    public List<NamedXContentRegistry.Entry> getNamedXContentParsers() {
                MeanReciprocalRank::fromXContent  
 *
                MeanReciprocalRank.Detail::fromXContent
 * under the License.  
            new NamedXContentRegistry.Entry(EvaluationMetric.class, new ParseField(PrecisionAtK.NAME), PrecisionAtK::fromXContent)
 * this file be licensed under the Apache-2.0 license or a
            new NamedXContentRegistry.Entry(MetricDetail.class, new ParseField(RecallAtK.NAME), RecallAtK.Detail::fromXContent)
            new NamedXContentRegistry.Entry(
                new ParseField(ExpectedReciprocalRank.NAME),
 * software distributed under the License is distributed on an
            new NamedXContentRegistry.Entry(
            )
 *  
import org.opensearch.plugins.spi.NamedXContentProvider;  
        );
 *    http://www.apache.org/licenses/LICENSE-2.0
        namedXContent.add(  
 * specific language governing permissions and limitations
        );  
