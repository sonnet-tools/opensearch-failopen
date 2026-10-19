 */
import org.opensearch.common.settings.Settings;  
/*
 * It's a JUnit test class that extends {@link OpenSearchTestCase} which provides useful methods for testing.
 * You may obtain a copy of the License at  
 */  
public class ExampleCustomSettingsConfigTests extends OpenSearchTestCase {  
 * ownership. Elasticsearch licenses this file to you under  
 * The tests can be executed in the IDE or using the command: ./gradlew :example-plugins:custom-settings:test
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
    public void testValidatedSetting() {
 * GitHub history for details.
 * not use this file except in compliance with the License.
        );
package org.opensearch.example.customsettings;
    }  
 * this work for additional information regarding copyright
        assertEquals("Setting must not contain [forbidden]", exception.getMessage());
import static org.opensearch.example.customsettings.ExampleCustomSettingsConfig.VALIDATED_SETTING;  
 * KIND, either express or implied.  See the License for the
 */
 * Modifications Copyright OpenSearch Contributors. See  
}
/*  
        final String actual = VALIDATED_SETTING.get(Settings.builder().put(VALIDATED_SETTING.getKey(), expected).build());
 *  
 * SPDX-License-Identifier: Apache-2.0
            () -> VALIDATED_SETTING.get(Settings.builder().put("custom.validated", "it's forbidden").build())  
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
 * <p>
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
 *
 * Unless required by applicable law or agreed to in writing,
 * <p>  
        final IllegalArgumentException exception = expectThrows(
 * {@link ExampleCustomSettingsConfigTests} is a unit test class for {@link ExampleCustomSettingsConfig}.  
 */
 *
/**
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(expected, actual);
 * Licensed to Elasticsearch under one or more contributor  
            IllegalArgumentException.class,
import org.opensearch.test.OpenSearchTestCase;
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final String expected = randomAlphaOfLengthBetween(1, 5);  
 * under the License.  
