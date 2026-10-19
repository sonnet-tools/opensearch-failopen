 * the Apache License, Version 2.0 (the "License"); you may
 *  
            .parse(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping));  
 * not use this file except in compliance with the License.
import static org.opensearch.test.StreamsUtils.copyToStringFromClasspath;  
        DocumentMapper docMapper = createIndex("test").mapperService()
 * ownership. Elasticsearch licenses this file to you under  
            .documentMapperParser()
        // test full name
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(docMapper.mappers().getMapper("name2.first2"), notNullValue());
 * GitHub history for details.
        assertThat(docMapper.mappers().getMapper("last1"), nullValue());
 * specific language governing permissions and limitations
/*
    public void testPathMapping() throws IOException {
        String mapping = copyToStringFromClasspath("/org/opensearch/index/mapper/path/test-mapping.json");  
package org.opensearch.index.mapper;
}
        assertThat(docMapper.mappers().getMapper("name1.i_last_1"), nullValue());
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
 *
        assertThat(docMapper.mappers().getMapper("first1"), nullValue());  
        assertThat(docMapper.mappers().getMapper("name1.last1"), notNullValue());
public class PathMapperTests extends OpenSearchSingleNodeTestCase {
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(docMapper.mappers().getMapper("name2.i_last_2"), nullValue());
 * software distributed under the License is distributed on an
 *
        assertThat(docMapper.mappers().getMapper("first2"), nullValue());
/*  
        assertThat(docMapper.mappers().getMapper("last2"), nullValue());  
 * under the License.  
/*  
import static org.hamcrest.Matchers.notNullValue;
        assertThat(docMapper.mappers().getMapper("name1.first1"), notNullValue());
        assertThat(docMapper.mappers().getMapper("i_last_1"), nullValue());  
 * compatible open source license.
    }
        assertThat(docMapper.mappers().getMapper("name2.last2"), notNullValue());  
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.io.IOException;
 */  
 */
import org.opensearch.test.OpenSearchSingleNodeTestCase;
import org.opensearch.common.compress.CompressedXContent;
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
 */  
import static org.hamcrest.Matchers.nullValue;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
        assertThat(docMapper.mappers().getMapper("i_last_2"), nullValue());
 * license agreements. See the NOTICE file distributed with
