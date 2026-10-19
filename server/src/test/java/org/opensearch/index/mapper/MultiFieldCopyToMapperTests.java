 * software distributed under the License is distributed on an
                        b.field("type", "text");
            }
                b.field("type", "text");
 *     http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
    }  
}
 *
 * not use this file except in compliance with the License.
import static org.hamcrest.core.IsEqual.equalTo;
            b.startObject("a").field("type", "text").endObject();
        Exception e = expectThrows(IllegalArgumentException.class, () -> createMapperService(mapping(b -> {
            b.endObject();
 * You may obtain a copy of the License at  
                    {  
 * GitHub history for details.
            b.startObject("b");  
 */  
    public void testExceptionForCopyToInMultiFields() {
        assertThat(e.getMessage(), equalTo("[copy_to] may not be used to copy from a multi-field: [b.subfield]"));
                    }  
        })));  
 *
            {
 * license agreements. See the NOTICE file distributed with
public class MultiFieldCopyToMapperTests extends MapperServiceTestCase {  
                    b.endObject();
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
                }
                    b.startObject("subfield");
 *  
/*  
 * this file be licensed under the Apache-2.0 license or a
 */
                b.startObject("fields");  
/*  
 * Unless required by applicable law or agreed to in writing,
                {
                b.endObject();  
package org.opensearch.index.mapper;
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
                        b.field("copy_to", "a");
/*
 * Licensed to Elasticsearch under one or more contributor  
 */  
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
