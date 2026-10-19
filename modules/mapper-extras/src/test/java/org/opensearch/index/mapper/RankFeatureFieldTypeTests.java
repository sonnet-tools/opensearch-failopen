 * The OpenSearch Contributors require contributions made to  
public class RankFeatureFieldTypeTests extends FieldTypeTestCase {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
}
    }
import org.opensearch.cluster.metadata.IndexMetadata;
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
 *  
 * SPDX-License-Identifier: Apache-2.0
    public void testIsNotAggregatable() {
 * ownership. Elasticsearch licenses this file to you under  
/*
    public void testFetchSourceValue() throws IOException {  
    }
        MappedFieldType mapper = new RankFeatureFieldMapper.Builder("field").build(context).fieldType();  
 * under the License.  
 * specific language governing permissions and limitations
        assertEquals(Collections.singletonList(42.9f), fetchSourceValue(mapper, "42.9"));  
 * GitHub history for details.
import org.opensearch.Version;
 * software distributed under the License is distributed on an
        Mapper.BuilderContext context = new Mapper.BuilderContext(settings, new ContentPath());
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertFalse(fieldType.isAggregatable());  
import org.opensearch.common.settings.Settings;  
        MappedFieldType fieldType = new RankFeatureFieldMapper.RankFeatureFieldType("field", Collections.emptyMap(), true);
 * compatible open source license.
/*  
 * Modifications Copyright OpenSearch Contributors. See
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT.id).build();
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
 *
 */  
 */  
 */
import java.util.Collections;  
 * the Apache License, Version 2.0 (the "License"); you may
 *
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
/*  
package org.opensearch.index.mapper;
        assertEquals(Collections.singletonList(3.14f), fetchSourceValue(mapper, 3.14));
 * this work for additional information regarding copyright
import java.io.IOException;
