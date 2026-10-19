import java.io.IOException;
 * The OpenSearch Contributors require contributions made to  
    }
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
public class IpRangeFieldTypeTests extends FieldTypeTestCase {  
 * under the License.  
package org.opensearch.index.mapper;
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
 * GitHub history for details.
        assertEquals(Collections.singletonList(Map.of("gte", "2001:db8::2:1")), fetchSourceValue(mapper.fieldType(), range));
 *  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.settings.Settings;  
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
 *
    public void testFetchSourceValue() throws IOException {
 */
        Map<String, Object> range = Map.of("gte", "2001:db8:0:0:0:0:2:1");
/*  
 */  
        Mapper.BuilderContext context = new Mapper.BuilderContext(settings, new ContentPath());
}
 * specific language governing permissions and limitations
import java.util.Collections;  
 * SPDX-License-Identifier: Apache-2.0
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT.id).build();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
import org.opensearch.cluster.metadata.IndexMetadata;
 */  
 * license agreements. See the NOTICE file distributed with
 *
 * compatible open source license.
        RangeFieldMapper mapper = new RangeFieldMapper.Builder("field", RangeType.IP, true, Version.V_EMPTY).build(context);  
/*
 * You may obtain a copy of the License at  
import org.opensearch.Version;
import java.util.Map;
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(Collections.singletonList("2001:db8::2:1/32"), fetchSourceValue(mapper.fieldType(), "2001:db8:0:0:0:0:2:1/32"));  
