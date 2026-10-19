        return histo;
 * under the License.  
        } else {  
                case 0:  
import java.util.ArrayList;
                default:  
            histo.field(randomAlphaOfLengthBetween(1, 20));
            histo.timeZone(randomZone());
                    DateHistogramInterval.hours(10)  
            );
        if (randomBoolean()) {
        }
    }  
    }  
        if (randomBoolean()) {  
 *
        DateHistogramValuesSourceBuilder histo = new DateHistogramValuesSourceBuilder(randomAlphaOfLengthBetween(5, 10));  
        } else {  
        }  
        if (randomBoolean()) {
                    break;
    protected CompositeAggregationBuilder createTestAggregatorBuilder() {  
 * compatible open source license.
                randomFrom(  
            histo.script(new Script(randomAlphaOfLengthBetween(10, 20)));
                    break;
 */
            histo.calendarInterval(
        for (int i = 0; i < numSources; i++) {  
                    sources.add(randomDateHistogramSourceBuilder());
            int type = randomIntBetween(0, 2);
                    throw new AssertionError("wrong branch");
        return new CompositeAggregationBuilder(randomAlphaOfLength(10), sources);
            histo.fixedInterval(
                case 1:  
            histo.missingBucket(true);
    private TermsValuesSourceBuilder randomTermsSourceBuilder() {
        } else {  
        }  
        int numSources = randomIntBetween(1, 10);
 *    http://www.apache.org/licenses/LICENSE-2.0
                    break;
        return terms;
        if (randomBoolean()) {
}  
        }  
        histo.missingOrder(randomFrom(MissingOrder.values()));
 * Modifications Copyright OpenSearch Contributors. See
            );  
        HistogramValuesSourceBuilder histo = new HistogramValuesSourceBuilder(randomAlphaOfLengthBetween(5, 10));  
import org.opensearch.search.aggregations.bucket.missing.MissingOrder;
        terms.order(randomFrom(SortOrder.values()));  
 * software distributed under the License is distributed on an
    @Override
            histo.missingBucket(true);
 * ownership. Elasticsearch licenses this file to you under  
            terms.field(randomAlphaOfLengthBetween(1, 20));
        TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder(randomAlphaOfLengthBetween(5, 10));  
                randomFrom(DateHistogramInterval.days(1), DateHistogramInterval.minutes(1), DateHistogramInterval.weeks(1))
 * this file be licensed under the Apache-2.0 license or a
        List<CompositeValuesSourceBuilder<?>> sources = new ArrayList<>();
                case 2:  
            }
    }
                )
import org.opensearch.search.aggregations.BaseAggregationTestCase;
import org.opensearch.search.sort.SortOrder;
 */  
        if (randomBoolean()) {  
                    sources.add(randomHistogramSourceBuilder());
 * GitHub history for details.
package org.opensearch.search.aggregations.bucket.composite;
                    sources.add(randomTermsSourceBuilder());
        terms.missingOrder(randomFrom(MissingOrder.values()));
                    new DateHistogramInterval(randomNonNegativeLong() + "ms"),
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
            terms.script(new Script(randomAlphaOfLengthBetween(10, 20)));
            histo.field(randomAlphaOfLengthBetween(1, 20));
        histo.interval(randomDoubleBetween(Math.nextUp(0), Double.MAX_VALUE, false));  
        if (randomBoolean()) {
 * the Apache License, Version 2.0 (the "License"); you may
    private DateHistogramValuesSourceBuilder randomDateHistogramSourceBuilder() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
/*
        }
                    DateHistogramInterval.days(10),
 *
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
        }  
 * The OpenSearch Contributors require contributions made to  
 */  
        histo.missingOrder(randomFrom(MissingOrder.values()));
        return histo;
        }
        if (randomBoolean()) {
 * this work for additional information regarding copyright
        }  
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;  
import org.opensearch.script.Script;
        if (randomBoolean()) {
    }  
public class CompositeAggregationBuilderTests extends BaseAggregationTestCase<CompositeAggregationBuilder> {
        }
/*  
import java.util.List;
 * Unless required by applicable law or agreed to in writing,
        } else {
    private HistogramValuesSourceBuilder randomHistogramSourceBuilder() {
            switch (type) {
            histo.script(new Script(randomAlphaOfLengthBetween(10, 20)));
 * Licensed to Elasticsearch under one or more contributor  
 *  
            terms.missingBucket(true);
 * specific language governing permissions and limitations
