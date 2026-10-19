/*  
public class JacksonLocationTests extends OpenSearchTestCase {
 * this file be licensed under the Apache-2.0 license or a
 */  
 * SPDX-License-Identifier: Apache-2.0
/*  
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
 */
/*
        assertThat(parser.nextToken(), equalTo(JsonToken.VALUE_STRING));
 * the Apache License, Version 2.0 (the "License"); you may
        // "index" : "test",
package org.opensearch.deps.jackson;
 */  
        gen.writeStartObject();
        assertThat(parser.nextToken(), equalTo(JsonToken.PROPERTY_NAME)); // "source"
        gen.writeStartObject();
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
        // {  
 * specific language governing permissions and limitations
        BytesStreamOutput os = new BytesStreamOutput();  
import tools.jackson.core.json.JsonFactory;  
 *    http://www.apache.org/licenses/LICENSE-2.0
        gen.writeEndObject();
        assertThat(parser.nextToken(), equalTo(JsonToken.START_OBJECT));
 * Licensed to Elasticsearch under one or more contributor  
        JsonGenerator gen = new JsonFactory().createGenerator(os);
        gen.writeStringProperty("value", "something");
 *  
import java.io.IOException;
 * KIND, either express or implied.  See the License for the
        gen.writeEndObject();  
import tools.jackson.core.JsonGenerator;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.common.io.stream.BytesStreamOutput;
import tools.jackson.core.JsonParser;
        gen.close();
        // value : "something"  
 * this work for additional information regarding copyright
        // }
 * not use this file except in compliance with the License.
 * under the License.  
        // }
        JsonParser parser = new JsonFactory().createParser(os.bytes().streamInput());  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.OpenSearchTestCase;
}
 *
 * Unless required by applicable law or agreed to in writing,
 *
        gen.writeName("source");  
import tools.jackson.core.JsonToken;
        // "source" : {
 * GitHub history for details.
        assertThat(parser.nextToken(), equalTo(JsonToken.PROPERTY_NAME)); // "index"  
        gen.writeStringProperty("index", "test");
 * You may obtain a copy of the License at  
    public void testLocationExtraction() throws IOException {
    }  
