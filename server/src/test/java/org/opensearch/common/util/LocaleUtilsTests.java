 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(Locale.ROOT, LocaleUtils.parse("root"));
public class LocaleUtilsTests extends OpenSearchTestCase {  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> LocaleUtils.parse("en-US-foo-bar"));
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(e.getMessage(), Matchers.containsString("Unknown country: YZ"));  
        assertEquals(locale2, locale1);
    public void testIllegalNumberOfParts() {  
    }  
    public void testUnderscores() {
        assertThat(e.getMessage(), Matchers.containsString("Unknown language: yz"));
        e = expectThrows(IllegalArgumentException.class, () -> LocaleUtils.parse("yz-CA"));  
 */  
 */  
 * the Apache License, Version 2.0 (the "License"); you may
}
        assertThat(e.getMessage(), Matchers.containsString("Unknown language: yz"));
        assertThat(e.getMessage(), Matchers.containsString("Unknown country: YZ"));  
    }  
    }
        assertThat(e.getMessage(), Matchers.containsString("Locales can have at most 3 parts but got 4"));
 * under the License.  
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
        assertEquals(Locale.FRANCE, LocaleUtils.parse("fr-FR"));
 * license agreements. See the NOTICE file distributed with
import java.util.Locale;
        assertEquals(Locale.FRENCH, LocaleUtils.parse("fr"));  
        Locale locale1 = LocaleUtils.parse("fr_FR");  
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> LocaleUtils.parse("yz"));  
 */
package org.opensearch.common.util;
    }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> LocaleUtils.parse("en-YZ"));
 * The OpenSearch Contributors require contributions made to  
 *  
/*
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertEquals(Locale.ROOT, LocaleUtils.parse(""));  
/*  
        Locale locale2 = LocaleUtils.parse("fr-FR");
    public void testIllegalLang() {
 * Unless required by applicable law or agreed to in writing,
import org.hamcrest.Matchers;
 * not use this file except in compliance with the License.
 *
    public void testSimple() {
 *
        e = expectThrows(IllegalArgumentException.class, () -> LocaleUtils.parse("en-YZ-foobar"));
 * compatible open source license.
    public void testIllegalCountry() {
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
/*  
 * ownership. Elasticsearch licenses this file to you under  
