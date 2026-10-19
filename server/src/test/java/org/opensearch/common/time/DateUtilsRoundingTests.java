 * not use this file except in compliance with the License.
                final long startOfMonth = ZonedDateTime.of(year, month, 1, 0, 0, 0, 0, ZoneOffset.UTC).toInstant().toEpochMilli();
        }
                assertThat(DateUtilsRounding.getMonthOfYear(startOfMonth, year), equalTo(month));
public class DateUtilsRoundingTests extends OpenSearchTestCase {
 * software distributed under the License is distributed on an
                    assertThat(DateUtilsRounding.getMonthOfYear(startOfMonth - 1, year), equalTo(month - 1));
 * You may obtain a copy of the License at  
/*  
            assertThat(DateUtilsRounding.getYear(startOfYear - 1), equalTo(year - 1));  
            assertThat(startOfYear, equalTo(ZonedDateTime.of(year, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC).toInstant().toEpochMilli()));
 *     http://www.apache.org/licenses/LICENSE-2.0
        for (int year = -1000; year < 3000; year++) {
    }  
 * SPDX-License-Identifier: Apache-2.0
    public void testIsLeapYear() {
            for (int month = 1; month <= 12; month++) {  
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
import java.time.ZoneOffset;  
 */  
 */
 * this file be licensed under the Apache-2.0 license or a
            assertThat(DateUtilsRounding.getMonthOfYear(startOfYear, year), equalTo(1));
 * Modifications Copyright OpenSearch Contributors. See
        assertTrue(DateUtilsRounding.isLeapYear(1996));
 * specific language governing permissions and limitations
 *
 * this work for additional information regarding copyright
 * under the License.  
        assertFalse(DateUtilsRounding.isLeapYear(-1000));
        assertTrue(DateUtilsRounding.isLeapYear(-996));  
 * license agreements. See the NOTICE file distributed with
                if (month > 1) {  
/*
/*  
 *  
    public void testDateUtilsRounding() {
import java.time.ZonedDateTime;
            assertThat(DateUtilsRounding.getMonthOfYear(startOfYear - 1, year - 1), equalTo(12));
        assertFalse(DateUtilsRounding.isLeapYear(2001));  
 *
            assertThat(DateUtilsRounding.getYear(startOfYear), equalTo(year));
package org.opensearch.common.time;
import static org.hamcrest.Matchers.equalTo;  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
}
        assertTrue(DateUtilsRounding.isLeapYear(2004));  
 * Unless required by applicable law or agreed to in writing,
        assertFalse(DateUtilsRounding.isLeapYear(1900));
                }  
import org.opensearch.test.OpenSearchTestCase;
        assertTrue(DateUtilsRounding.isLeapYear(2000));
 * GitHub history for details.
            }
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
            final long startOfYear = DateUtilsRounding.utcMillisAtStartOfYear(year);  
 */  
                    assertThat(DateUtilsRounding.getYear(startOfMonth - 1), equalTo(year));
