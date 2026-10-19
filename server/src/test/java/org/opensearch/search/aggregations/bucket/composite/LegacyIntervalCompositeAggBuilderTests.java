            histo.dateHistogramInterval(
 * interval on date histo.  Separated to make testing the warnings easier.  
            terms.field(randomAlphaOfLengthBetween(1, 20));
            histo.script(new Script(randomAlphaOfLengthBetween(10, 20)));
                randomFrom(DateHistogramInterval.days(1), DateHistogramInterval.minutes(1), DateHistogramInterval.weeks(1))  
        }
        for (int i = 0; i < numSources; i++) {  
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");
                    break;
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");
public class LegacyIntervalCompositeAggBuilderTests extends BaseAggregationTestCase<CompositeAggregationBuilder> {
/*  
    @Override
        if (randomBoolean()) {
        super.testEqualsAndHashcode();  
import java.io.IOException;  
package org.opensearch.search.aggregations.bucket.composite;
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;  
        return histo;  
        }
    protected CompositeAggregationBuilder createTestAggregatorBuilder() {
/*  
        }
    private DateHistogramValuesSourceBuilder randomDateHistogramSourceBuilder() {  
            histo.timeZone(randomZone());  
 * the Apache License, Version 2.0 (the "License"); you may
 *
 * <p>
 * Duplicates the tests from {@link CompositeAggregationBuilderTests}, except using the deprecated
    @Override
        return terms;
    }
    }
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
            }
        if (randomBoolean()) {
    public void testFromXContentMulti() throws IOException {
 */  
 * Can be removed in when the legacy interval options are gone
    }
 *
        }  
 * KIND, either express or implied.  See the License for the
    }
            histo.field(randomAlphaOfLengthBetween(1, 20));
                    sources.add(randomTermsSourceBuilder());
    private TermsValuesSourceBuilder randomTermsSourceBuilder() {
        terms.order(randomFrom(SortOrder.values()));  
        return new CompositeAggregationBuilder(randomAlphaOfLength(10), sources);
        if (randomBoolean()) {
import org.opensearch.search.aggregations.BaseAggregationTestCase;
    public void testEqualsAndHashcode() throws IOException {
 * The OpenSearch Contributors require contributions made to  
        List<CompositeValuesSourceBuilder<?>> sources = new ArrayList<>();  
        }
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
        // ensure we add at least one date histo
            );
        histo.interval(randomDoubleBetween(Math.nextUp(0), Double.MAX_VALUE, false));
    @Override
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");
        } else {
        super.testShallowCopy();  
        sources.add(randomDateHistogramSourceBuilder());
            int type = randomIntBetween(0, 2);
        super.testToString();  
        if (randomBoolean()) {  
 *  
            histo.script(new Script(randomAlphaOfLengthBetween(10, 20)));  
        if (randomBoolean()) {
 * ownership. Elasticsearch licenses this file to you under  
    private HistogramValuesSourceBuilder randomHistogramSourceBuilder() {
 */  
        } else {
import org.opensearch.script.Script;
 */
        } else {  
                case 2:  
        if (randomBoolean()) {
    @Override
        if (randomBoolean()) {
                default:  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
        int numSources = randomIntBetween(1, 10);
 * GitHub history for details.
        HistogramValuesSourceBuilder histo = new HistogramValuesSourceBuilder(randomAlphaOfLengthBetween(5, 10));
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");
    @Override
    @Override
 * this work for additional information regarding copyright
    }
                case 0:  
import java.util.List;
 * SPDX-License-Identifier: Apache-2.0
                    break;
 * Modifications Copyright OpenSearch Contributors. See
    public void testToString() throws IOException {
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
import java.util.ArrayList;
        }  
        DateHistogramValuesSourceBuilder histo = new DateHistogramValuesSourceBuilder(randomAlphaOfLengthBetween(5, 10));
/*
    }
    public void testShallowCopy() {
        if (randomBoolean()) {
 * this file be licensed under the Apache-2.0 license or a
        super.testSerialization();  
        } else {
    }
    public void testSerializationMulti() throws IOException {
    }  
            switch (type) {
    public void testFromXContent() throws IOException {
            histo.field(randomAlphaOfLengthBetween(1, 20));  
    @Override
    public void testSerialization() throws IOException {
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");
            histo.missingBucket(true);  
        super.testSerializationMulti();  
    @Override  
 * compatible open source license.
    }
                case 1:  
            histo.interval(randomNonNegativeLong());  
import org.opensearch.search.sort.SortOrder;
        TermsValuesSourceBuilder terms = new TermsValuesSourceBuilder(randomAlphaOfLengthBetween(5, 10));  
        }  
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");
        super.testFromXContent();  
            terms.missingBucket(true);
            histo.missingBucket(true);  
 */  
                    break;
 * license agreements. See the NOTICE file distributed with
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");
 * not use this file except in compliance with the License.
        super.testFromXContentMulti();  
            terms.script(new Script(randomAlphaOfLengthBetween(10, 20)));
                    sources.add(randomHistogramSourceBuilder());
        }
                    sources.add(randomDateHistogramSourceBuilder());
        return histo;
}  
        }
                    throw new AssertionError("wrong branch");
/**
