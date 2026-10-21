            OpenSearchParseException.class,
        assertThat(
import java.util.ArrayList;
    }
        for (int i = 0; i < numIndexExpressions; i++) {
/*
        assertThat(e.getMessage(), containsString("invalid dynamic name expression"));
            result.get(0),
        ClusterState.builder(new ClusterName("_name")).build(),
        false
        } else {
    }
/*
 * Modifications Copyright OpenSearch Contributors. See
        for (int i = 0; i < indexExpressions.size(); i++) {
 * specific language governing permissions and limitations
        List<String> result = expressionResolver.resolve(context, Arrays.asList("<.marvel-{now/d{'\\{year\\}'yyyy}}>"));
                .withMinuteOfHour(0)
        assertThat(
    }
            equalTo(".marvel-" + DateTimeFormat.forPattern("'{year}'yyyy").print(new DateTime(context.getStartTime(), UTC)))
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.cluster.ClusterName;
            () -> expressionResolver.resolve(context, Arrays.asList("<.marvel-{now/d{}>"))
        Context context = new Context(this.context.getState(), this.context.getOptions(), now.getMillis(), false);
package org.opensearch.cluster.metadata;
        );
 * You may obtain a copy of the License at
        );
 * GitHub history for details.
        assertThat(result.size(), equalTo(3));
 * The OpenSearch Contributors require contributions made to
                .withHourOfDay(0)
        );
            result.get(0),
 * ownership. Elasticsearch licenses this file to you under
            equalTo(".watch_history-" + DateTimeFormat.forPattern("YYYY.MM.dd").print(new DateTime(context.getStartTime(), UTC)))
    }
        if (randomBoolean()) {
        DateTime now;
        );
 *
        Exception e = expectThrows(
        int hoursOffset;
 * license agreements. See the NOTICE file distributed with
    public void testExpression_EscapeStatic() throws Exception {
        Exception e = expectThrows(
        }
        );
            result.get(0),
                    + DateTimeFormat.forPattern("YYYY.MM.dd").print(new DateTime(context.getStartTime(), UTC))
        );
    }
/*
import org.opensearch.test.OpenSearchTestCase;
import java.util.Collections;
            now = DateTime.now(UTC)
        assertThat(e.getMessage(), containsString("date math placeholder is open ended"));
        List<String> results = expressionResolver.resolve(context, Arrays.asList("<.marvel-{now/d{yyyy.MM.dd}}>"));
            timeZone = DateTimeZone.forOffsetHours(hoursOffset);
        }
        assertThat(e.getMessage(), containsString("missing date format"));
    public void testEmpty() throws Exception {
 * under the License.
            results.get(0),
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.cluster.metadata.IndexNameExpressionResolver.DateMathExpressionResolver;
        assertThat(e.getMessage(), containsString("invalid dynamic name expression"));
    private final DateMathExpressionResolver expressionResolver = new DateMathExpressionResolver();
            Arrays.asList("name1", "<.marvel-{now/d}>", "name2", "<.logstash-{now/M{uuuu.MM}}>")
        List<String> indexExpressions = new ArrayList<>(numIndexExpressions);
        assertThat(
    public void testExpressionInvalidEmptyDateMathFormat() throws Exception {
    }
        );
        int minutesOffset = 0;
 * not use this file except in compliance with the License.
        assertThat(results.size(), equalTo(1));
            equalTo(".marvel-" + DateTimeFormat.forPattern("yyyy.MM.dd").print(new DateTime(context.getStartTime(), UTC)))
 *
        assertThat(result.get(0), equalTo(".marvel-test"));
            equalTo(".marvel-" + DateTimeFormat.forPattern("yyyy.MM.dd").print(new DateTime(context.getStartTime(), UTC)))
        assertThat(
 */
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.support.IndicesOptions;
            equalTo(".marvel-" + DateTimeFormat.forPattern("YYYY.MM.dd").print(new DateTime(context.getStartTime(), UTC)))
    public void testExpression_CustomFormat() throws Exception {
 * Licensed to Elasticsearch under one or more contributor
            minutesOffset = randomIntBetween(0, 59);
        logger.info("timezone: [{}], now [{}], name: [{}]", timeZone, now, results.get(0));
            equalTo("logstash-" + DateTimeFormat.forPattern("YYYY.MM.dd").print(new DateTime(context.getStartTime(), UTC)))
 */
        List<String> result = expressionResolver.resolve(context, indexExpressions);
            // rounding to today 00:00
        if (hoursOffset >= 0) {
        DateTimeZone timeZone;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver.Context;
            // rounding to next day 00:00
        );
    }
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
        assertThat(result.size(), equalTo(4));
    }
        assertThat(e.getMessage(), containsString("date math placeholder is open ended"));
 *     http://www.apache.org/licenses/LICENSE-2.0
            () -> expressionResolver.resolve(context, Arrays.asList("<.marvel-{now/d>"))
            result.get(0),
            timeZone = DateTimeZone.forOffsetHoursMinutes(hoursOffset, minutesOffset);
import org.joda.time.DateTime;
import org.opensearch.cluster.ClusterState;
            equalTo(".mar{v}el-" + DateTimeFormat.forPattern("yyyy.MM.dd").print(new DateTime(context.getStartTime(), UTC)))
        List<String> result = expressionResolver.resolve(context, indexExpressions);
                    + DateTimeFormat.forPattern("YYYY.MM.dd").print(new DateTime(context.getStartTime(), UTC).withDayOfMonth(1))
            )
                .plusHours(hoursOffset)
        }
import static org.joda.time.DateTimeZone.UTC;
        List<String> result = expressionResolver.resolve(context, Arrays.asList("<.mar\\{v\\}el-{now/d}>"));
        List<String> result = expressionResolver.resolve(
    }
import org.opensearch.OpenSearchParseException;
        assertThat(result.size(), equalTo(indexExpressions.size()));
        assertThat(e.getMessage(), containsString("invalid dynamic name expression"));
 * KIND, either express or implied.  See the License for the
        );
        );
        assertThat(result.size(), equalTo(1));
            equalTo(".logstash-" + DateTimeFormat.forPattern("yyyy.MM").print(new DateTime(context.getStartTime(), UTC).withDayOfMonth(1)))
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.joda.time.DateTimeZone;
        );
            equalTo(
        assertThat(e.getMessage(), containsString("invalid dynamic name expression"));
            result.get(1),
        List<String> result = expressionResolver.resolve(context, Collections.<String>emptyList());
    private final Context context = new Context(
 * this work for additional information regarding copyright
                ".text1-"
        assertThat(results.size(), equalTo(1));
 * compatible open source license.
            () -> expressionResolver.resolve(context, Arrays.asList("<.marvel-{now/d{}}>"))
        assertThat(result.get(2), equalTo("name2"));
    public void testExpression_Static() throws Exception {
        assertThat(results.get(0), equalTo(".marvel-" + DateTimeFormat.forPattern("yyyy.MM.dd").print(now.withZone(timeZone))));
    }
    public void testExpressionInvalidUnescaped() throws Exception {
        );
        assertThat(
    public void testExpression_CustomTimeZoneInIndexName() throws Exception {
        assertThat(
        Exception e = expectThrows(
            result.get(2),
    public void testExpression_MixedArray() throws Exception {
        int numIndexExpressions = randomIntBetween(1, 9);
        assertThat(
    public void testExpressionInvalidDateMathFormat() throws Exception {
        );
            context,
        );
            hoursOffset = randomIntBetween(-12, 14);
import static org.hamcrest.Matchers.containsString;
    public void testExpressionInvalidOpenEnded() throws Exception {
        List<String> result = expressionResolver.resolve(context, Arrays.asList("<.text1-{now/d}-text2-{now/M}>"));
 */
            result.get(1),
}
            OpenSearchParseException.class,
        IndicesOptions.strictExpand(),
    );
    public void testNormal() throws Exception {
            now = DateTime.now(UTC).withHourOfDay(0).withMinuteOfHour(0).withSecondOfMinute(0);
            hoursOffset = randomIntBetween(-11, 13);
            result.get(3),
import org.joda.time.format.DateTimeFormat;
        List<String> results = expressionResolver.resolve(context, Arrays.asList("<.marvel-{now/d{yyyy.MM.dd|" + timeZone.getID() + "}}>"));
            OpenSearchParseException.class,
    }
import java.util.Arrays;
    public void testExpression() throws Exception {
        Exception e = expectThrows(
 * the Apache License, Version 2.0 (the "License"); you may
                .plusMinutes(minutesOffset)
        } else {
    }
        assertThat(e.getMessage(), containsString("invalid character at position ["));
        assertThat(result.size(), equalTo(1));
        assertThat(result.get(0), equalTo("name1"));
            indexExpressions.add(randomAlphaOfLength(10));
    }
        List<String> result = expressionResolver.resolve(context, Arrays.asList("<.marvel-test>"));
            OpenSearchParseException.class,
        assertThat(result.size(), equalTo(0));
        assertThat(result.size(), equalTo(1));
                    + "-text2-"
        }
    public void testExpression_MultiParts() throws Exception {
public class DateMathExpressionResolverTests extends OpenSearchTestCase {
import java.util.List;
    }
            assertThat(result.get(i), equalTo(indexExpressions.get(i)));
        List<String> indexExpressions = Arrays.asList("<.marvel-{now}>", "<.watch_history-{now}>", "<logstash-{now}>");
        assertThat(
            () -> expressionResolver.resolve(context, Arrays.asList("<.mar}vel-{now/d}>"))
    public void testExpression_EscapeDateFormat() throws Exception {
        assertThat(
 *
                .withSecondOfMinute(0);
        assertThat(result.size(), equalTo(1));
