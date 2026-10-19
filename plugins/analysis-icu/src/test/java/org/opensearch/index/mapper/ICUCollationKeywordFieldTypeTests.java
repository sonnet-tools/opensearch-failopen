import org.opensearch.Version;
        assertEquals(Collections.singletonList("42"), fetchSourceValue(mapper.fieldType(), 42L));  
/*  
import org.opensearch.cluster.metadata.IndexMetadata;
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
 * compatible open source license.
package org.opensearch.index.mapper;
 * under the License.  
 * this work for additional information regarding copyright
 *  
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT.id).build();
 * KIND, either express or implied.  See the License for the
        assertEquals(Collections.singletonList("true"), fetchSourceValue(mapper.fieldType(), true));
 * specific language governing permissions and limitations
        assertEquals(Collections.singletonList("true"), fetchSourceValue(ignoreAboveMapper.fieldType(), true));
/*
 * this file be licensed under the Apache-2.0 license or a
/*  
        ICUCollationKeywordFieldMapper mapper = new ICUCollationKeywordFieldMapper.Builder("field").build(context);
        Mapper.BuilderContext context = new Mapper.BuilderContext(settings, new ContentPath());  
    public void testFetchSourceValue() throws IOException {
 *
        ICUCollationKeywordFieldMapper nullValueMapper = new ICUCollationKeywordFieldMapper.Builder("field").nullValue("NULL")  
 * Unless required by applicable law or agreed to in writing,
            .build(context);
 */  
        assertEquals(Collections.singletonList("NULL"), fetchSourceValue(nullValueMapper.fieldType(), null));
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.settings.Settings;  
        assertEquals(Collections.singletonList("42"), fetchSourceValue(ignoreAboveMapper.fieldType(), 42L));  
 *     http://www.apache.org/licenses/LICENSE-2.0
    }  
public class ICUCollationKeywordFieldTypeTests extends FieldTypeTestCase {
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
import java.util.Collections;  
 * Licensed to Elasticsearch under one or more contributor  
        ICUCollationKeywordFieldMapper ignoreAboveMapper = new ICUCollationKeywordFieldMapper.Builder("field").ignoreAbove(4)  
            .build(context);
 */
        assertEquals(Collections.emptyList(), fetchSourceValue(ignoreAboveMapper.fieldType(), "value"));
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
 */  
}
import java.io.IOException;
