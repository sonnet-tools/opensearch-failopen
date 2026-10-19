 *
        assertThat(MediaTypeRegistry.parseMediaType(mediaType + ";").getParameters(), equalTo(Collections.emptyMap()));
 * You may obtain a copy of the License at  
            equalTo(Map.of("charset", "utf-8", "custom", "123"))
 *  
            MediaTypeRegistry.parseMediaType(mediaType + "; custom=123;charset=UTF-8").getParameters(),
    public void testWhiteSpaceInTypeSubtype() {  
        );
    public void testInvalidParameters() {
    public void testJsonWithParameters() throws Exception {
        assertThat(MediaTypeRegistry.parseMediaType(mediaType + "; key="), is(nullValue()));
import static org.hamcrest.Matchers.nullValue;  
        String mediaType = "application/json";
}  
        assertThat(MediaTypeRegistry.parseMediaType(mediaType + "; charset=UTF-8").getParameters(), equalTo(Map.of("charset", "utf-8")));
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(MediaTypeRegistry.parseMediaType(mediaType + "; keyvalueNoEqualsSign"), is(nullValue()));
 * this file be licensed under the Apache-2.0 license or a
        assertThat(
import java.util.Collections;
        String mediaType = "application/json";  
 * SPDX-License-Identifier: Apache-2.0
 */  
    }  
 * under the License.  
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
            MediaTypeRegistry.parseMediaType(mediaType + "; custom=123;\n charset=UTF-8").getParameters(),  
    }
import java.util.Map;
import org.opensearch.test.OpenSearchTestCase;
/*  
        mediaType = " application / json ";
 * KIND, either express or implied.  See the License for the
        assertThat(
            equalTo(Map.of("charset", "utf-8", "custom", "123"))  
            MediaTypeRegistry.parseMediaType(mediaType + "; custom=123; charset=UTF-8").getParameters(),
            equalTo(Map.of("charset", "utf-8", "custom", "123"))
 * Licensed to Elasticsearch under one or more contributor  
 *
package org.opensearch.common.xcontent;
        assertThat(  
public class MediaTypeParserTests extends OpenSearchTestCase {
        String mediaType = " application/json ";
/*  
        assertThat(MediaTypeRegistry.parseMediaType(mediaType).getParameters(), equalTo(Collections.emptyMap()));  
        assertThat(MediaTypeRegistry.parseMediaType(mediaType + "; key = value"), is(nullValue()));  
 * specific language governing permissions and limitations
        );
        assertThat(MediaTypeRegistry.parseMediaType(mediaType), is(nullValue()));
/*
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
        );  
import static org.hamcrest.Matchers.equalTo;
 */
 */  
import org.opensearch.core.xcontent.MediaTypeRegistry;
    }
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
import static org.hamcrest.Matchers.is;
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(MediaTypeRegistry.parseMediaType(mediaType).getMediaType(), equalTo(XContentType.JSON));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
