 * this work for additional information regarding copyright
}  
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)  
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.settings.Settings;  
    }
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.util.FeatureFlags;
public class MapperTests extends OpenSearchTestCase {
        assertEquals(contentPath, context.path());  
 * specific language governing permissions and limitations
 * compatible open source license.
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
 * Unless required by applicable law or agreed to in writing,
            .put("index.pluggable.dataformat.enabled", true)
        expectThrows(NullPointerException.class, () -> new Mapper.BuilderContext(null, new ContentPath(1)));
 */  
 * SPDX-License-Identifier: Apache-2.0
    }
 *
 *
package org.opensearch.index.mapper;
import org.opensearch.cluster.metadata.IndexMetadata;
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
    public void testBuilderContextWithIndexSettingsAsNull() {  
import org.opensearch.Version;
    }
        assertEquals(settings, context.indexSettings());
 * license agreements. See the NOTICE file distributed with
        ContentPath contentPath = new ContentPath(1);
/*  
 * Modifications Copyright OpenSearch Contributors. See
 *  
        assertFalse(Mapper.isPluggableDataFormatEnabled(settings));  
 */  
            .build();
        Settings settings = Settings.builder()
 */
 * this file be licensed under the Apache-2.0 license or a
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
        assertTrue(Mapper.isPluggableDataFormatEnabled(settings));  
 * GitHub history for details.
    public void testIsOptimisedIndexEnabledReturnsFalseByDefault() {
/*  
        Mapper.BuilderContext context = new Mapper.BuilderContext(settings, contentPath);  
    }
/*
    public void testIsOptimisedIndexEnabledReturnsTrueWhenFlagEnabled() {
 * not use this file except in compliance with the License.
import org.opensearch.test.OpenSearchTestCase;
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();
    public void testSuccessfulBuilderContext() {  
