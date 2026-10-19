/*  
 *
 * SPDX-License-Identifier: Apache-2.0
/*  
 */  
            b.endObject();
 *     http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.xcontent.ToXContent;
}  
            assertThat(b.toString(), containsString("\"null_value\":null"));  
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
    public void testNullNullValue() throws Exception {
            ToXContent.Params params = new ToXContent.MapParams(Collections.singletonMap("include_defaults", "true"));
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
 *  
 * license agreements. See the NOTICE file distributed with
import java.util.Collections;
import static org.hamcrest.Matchers.containsString;
 * KIND, either express or implied.  See the License for the
/*
        String[] typesToTest = { "integer", "long", "double", "float", "short", "date", "ip", "keyword", "boolean", "byte", "geo_point" };
import org.opensearch.common.xcontent.json.JsonXContent;
            DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", type).nullField("null_value")));
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.index.mapper;
            mapper.mapping().toXContent(b, params);
 * Unless required by applicable law or agreed to in writing,
public class NullValueTests extends MapperServiceTestCase {  
 * software distributed under the License is distributed on an
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.xcontent.XContentBuilder;  
 */
 * Licensed to Elasticsearch under one or more contributor  
        }
    }
            XContentBuilder b = JsonXContent.contentBuilder().startObject();  
        for (String type : typesToTest) {  
            mapper.parse(source(b -> b.nullField("field")));  
 */  
 * specific language governing permissions and limitations
