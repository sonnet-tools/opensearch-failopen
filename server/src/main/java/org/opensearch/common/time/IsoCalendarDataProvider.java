 * KIND, either express or implied.  See the License for the
    @Override
public class IsoCalendarDataProvider extends CalendarDataProvider {
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
/**
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
 * under the License.  
    @Override
 */  
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See  
 * @see <a href="https://en.wikipedia.org/wiki/ISO_week_date">ISO week date</a>  
/*
 * It defines start of the week as Monday and requires 4 days in the first week of the year.  
    }
 * This class overrides default behaviour for Locale.ROOT (start of the week Sunday, minimum 1 day in the first week of the year).
    @Override  
/*
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
import java.util.Locale;
 * Java SPI mechanism requires java.locale.providers to contain SPI value (i.e. java.locale.providers=SPI,COMPAT)
    public Locale[] getAvailableLocales() {
        return Calendar.MONDAY;
/*  
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
import java.util.spi.CalendarDataProvider;
 * the Apache License, Version 2.0 (the "License"); you may
    public int getMinimalDaysInFirstWeek(Locale locale) {  
        return 4;
 *  
 * This class is loaded by JVM SPI mechanism in order to provide ISO compatible behaviour for week calculations using java.time.
 * @opensearch.internal
 * software distributed under the License is distributed on an
package org.opensearch.common.time;
 *
 */
 */
}
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
        return new Locale[] { Locale.ROOT };  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
 *
 * SPDX-License-Identifier: Apache-2.0
    public int getFirstDayOfWeek(Locale locale) {
    }
 * GitHub history for details.
    }  
import java.util.Calendar;  
