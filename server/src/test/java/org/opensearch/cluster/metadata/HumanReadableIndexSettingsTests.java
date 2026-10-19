import org.opensearch.common.settings.Settings;
 * GitHub history for details.
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
            .put(IndexMetadata.SETTING_VERSION_CREATED, versionCreated)
        assertEquals(versionCreated.toString(), humanSettings.get(IndexMetadata.SETTING_VERSION_CREATED_STRING, null));  
}
 *     http://www.apache.org/licenses/LICENSE-2.0
            .put(IndexMetadata.SETTING_VERSION_UPGRADED, versionUpgraded)  
    public void testHumanReadableSettings() {  
 *
        long created = System.currentTimeMillis();  
        Version versionUpgraded = randomVersion(random());
 */
 * the Apache License, Version 2.0 (the "License"); you may
 *
 * not use this file except in compliance with the License.
package org.opensearch.cluster.metadata;
 * compatible open source license.
import java.time.ZonedDateTime;
 */  
import static org.opensearch.test.VersionUtils.randomVersion;  
        Version versionCreated = randomVersion(random());
            .build();
/*  
 * Modifications Copyright OpenSearch Contributors. See
        ZonedDateTime creationDate = ZonedDateTime.ofInstant(Instant.ofEpochMilli(created), ZoneOffset.UTC);
        Settings humanSettings = IndexMetadata.addHumanReadableSettings(testSettings);
 * Licensed to Elasticsearch under one or more contributor  
 */  
import java.time.ZoneOffset;  
import org.opensearch.test.OpenSearchTestCase;  
 * this file be licensed under the Apache-2.0 license or a
import java.time.Instant;
        assertEquals(creationDate.toString(), humanSettings.get(IndexMetadata.SETTING_CREATION_DATE_STRING, null));  
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(versionUpgraded.toString(), humanSettings.get(IndexMetadata.SETTING_VERSION_UPGRADED_STRING, null));
 * Unless required by applicable law or agreed to in writing,
        Settings testSettings = Settings.builder()
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.Version;
public class HumanReadableIndexSettingsTests extends OpenSearchTestCase {
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
 *  
    }
/*
/*  
 * KIND, either express or implied.  See the License for the
            .put(IndexMetadata.SETTING_CREATION_DATE, created)
