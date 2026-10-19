public class XContentTypeTests extends OpenSearchTestCase {  
        String mediaType = "application/x-ndjson";
 *
    }
        assertThat(MediaType.fromMediaType(mediaType + "; charset=UTF-8"), equalTo(expectedXContentType));  
/*
        assertThat(MediaType.fromMediaType(mediaType + "; charset=UTF-8"), equalTo(expectedXContentType));
    }  
 */
        String mediaType = "APPLICATION/*";
 * under the License.  
    }
 */
 * specific language governing permissions and limitations
        assertThat(MediaType.fromMediaType("application/vnd.opensearch+smile;compatible-with=7"), equalTo(XContentType.SMILE));
    public void testFromYaml() throws Exception {
 * ownership. Elasticsearch licenses this file to you under  
    }  
        assertThat(MediaType.fromMediaType(mediaType + ";"), equalTo(expectedXContentType));
        XContentType expectedXContentType = XContentType.SMILE;  
 * license agreements. See the NOTICE file distributed with
        assertThat(MediaType.fromMediaType("gobbly;goop"), nullValue());  
        assertThat(MediaType.fromMediaType(mediaType + "; charset=UTF-8"), equalTo(expectedXContentType));
        assertThat(MediaType.fromMediaType(mediaType), equalTo(expectedXContentType));  
        assertThat(MediaType.fromMediaType("application/vnd.opensearch+json ;compatible-with=7"), equalTo(MediaTypeRegistry.JSON));  
        assertThat(MediaType.fromMediaType(mediaType), equalTo(expectedXContentType));
package org.opensearch.common.xcontent;
        assertThat(MediaType.fromMediaType("text/plain"), nullValue());
        MediaType expectedXContentType = MediaTypeRegistry.JSON;
        assertThat(MediaType.fromMediaType(mediaType + ";"), equalTo(expectedXContentType));
 *  
        assertThat(MediaType.fromMediaType(mediaType), equalTo(expectedXContentType));
    public void testFromSmile() throws Exception {
        assertThat(MediaType.fromMediaType(mediaType + ";"), equalTo(expectedXContentType));  
        assertThat(MediaType.fromMediaType(mthv), equalTo(MediaTypeRegistry.JSON));  
        assertThat(MediaType.fromMediaType("application/vnd.opensearch+json;compatible-with=7"), equalTo(MediaTypeRegistry.JSON));
}  
 *
        assertThat(MediaType.fromMediaType(mediaType), equalTo(expectedXContentType));  
    }  
 * this work for additional information regarding copyright
 * compatible open source license.
    public void testFromCbor() throws Exception {
    public void testFromWildcardUppercase() throws Exception {
import org.opensearch.core.xcontent.MediaType;  
    }
    public void testFromWildcard() throws Exception {  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(MediaType.fromMediaType(mediaType), equalTo(expectedXContentType));
 * Unless required by applicable law or agreed to in writing,
        String mthv = "application/vnd.opensearch+json ;compatible-with=7;charset=utf-8";
 * SPDX-License-Identifier: Apache-2.0
        String mediaType = "application/json".toUpperCase(Locale.ROOT);
 * Modifications Copyright OpenSearch Contributors. See  
    public void testFromJson() throws Exception {
 */  
import java.util.Locale;
 * not use this file except in compliance with the License.
    }
import org.opensearch.test.OpenSearchTestCase;
        assertThat(MediaType.fromMediaType(mthv.toUpperCase(Locale.ROOT)), equalTo(MediaTypeRegistry.JSON));
 * GitHub history for details.
        assertThat(MediaType.fromMediaType(mediaType + ";"), equalTo(expectedXContentType));
import static org.hamcrest.Matchers.nullValue;
        String mediaType = "application/*";
        assertThat(MediaType.fromMediaType(mediaType), equalTo(expectedXContentType));
        assertThat(MediaType.fromMediaType(null), nullValue());  
        XContentType expectedXContentType = XContentType.CBOR;
    public void testFromRubbish() throws Exception {
    public void testFromJsonUppercase() throws Exception {  
        MediaType expectedXContentType = MediaTypeRegistry.JSON;
        assertThat(MediaType.fromMediaType(mediaType + ";"), equalTo(expectedXContentType));
 * You may obtain a copy of the License at  
/*  
 * this file be licensed under the Apache-2.0 license or a
import static org.hamcrest.Matchers.equalTo;  
        assertThat(MediaType.fromMediaType(mediaType), equalTo(expectedXContentType));
/*
        assertThat(MediaType.fromMediaType(mediaType + ";"), equalTo(expectedXContentType));  
 * the Apache License, Version 2.0 (the "License"); you may
        String mediaType = "application/json";  
        MediaType expectedXContentType = MediaTypeRegistry.JSON;
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
    public void testFromNdJson() throws Exception {
        MediaType expectedXContentType = MediaTypeRegistry.JSON;  
        assertThat(MediaType.fromMediaType(mediaType + "; charset=UTF-8"), equalTo(expectedXContentType));
        assertThat(MediaType.fromMediaType(""), nullValue());
        String mediaType = "application/cbor";  
        String mediaType = "application/smile";
 * The OpenSearch Contributors require contributions made to  
        assertThat(MediaType.fromMediaType(mediaType + ";"), equalTo(expectedXContentType));  
        assertThat(MediaType.fromMediaType("application/vnd.opensearch+yaml;compatible-with=7"), equalTo(XContentType.YAML));
    }
import org.opensearch.core.xcontent.MediaTypeRegistry;
        MediaType expectedXContentType = MediaTypeRegistry.JSON;  
        assertThat(MediaType.fromMediaType(mediaType), equalTo(expectedXContentType));
        XContentType expectedXContentType = XContentType.YAML;
    public void testVersionedMediaType() throws Exception {  
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
        assertThat(MediaType.fromMediaType("application/vnd.opensearch+cbor;compatible-with=7"), equalTo(XContentType.CBOR));  
        String mediaType = "application/yaml";  
 * software distributed under the License is distributed on an
        assertThat(MediaType.fromMediaType(mediaType + ";"), equalTo(expectedXContentType));
