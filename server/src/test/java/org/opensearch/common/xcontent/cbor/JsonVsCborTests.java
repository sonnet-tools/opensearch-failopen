import org.opensearch.core.xcontent.MediaTypeRegistry;
            XContentParser.Token token2 = parser2.nextToken();
 * this work for additional information regarding copyright
import org.opensearch.core.xcontent.XContentParser;  
            }
    public void testCompareParsingTokens() throws IOException {  
                    assertThat(parser1.numberType(), equalTo(parser2.numberType()));  
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
        }
                    break;
            XContentParser xson0sParser = createParser(CborXContent.cborXContent, xsonOs.bytes())
        while (true) {
        }
        xsonGen.writeStringField("test", "value");
        xsonGen.close();  
                    assertThat(parser1.text(), equalTo(parser2.text()));  
        xsonGen.writeStartArray();
            assertThat(token1, equalTo(token2));  
                return;
 *     http://www.apache.org/licenses/LICENSE-2.0
                case VALUE_STRING:
            XContentParser json0sParser = createParser(JsonXContent.jsonXContent, jsonOs.bytes());  
        jsonGen.writeStringField("test", "value");
                case FIELD_NAME:
 * this file be licensed under the Apache-2.0 license or a
            switch (token1) {
 * not use this file except in compliance with the License.
 *  
 * The OpenSearch Contributors require contributions made to  
import static org.hamcrest.Matchers.equalTo;
 */  
 * GitHub history for details.
        jsonGen.writeStartObject();
 */
 * You may obtain a copy of the License at  
import org.opensearch.common.xcontent.XContentType;
 * the Apache License, Version 2.0 (the "License"); you may
            }  
                    assertThat(parser1.numberValue(), equalTo(parser2.numberValue()));
import org.opensearch.common.io.stream.BytesStreamOutput;
        jsonGen.writeFieldName("arr");  
 * license agreements. See the NOTICE file distributed with
 */  
        xsonGen.writeStartObject();
import org.opensearch.common.xcontent.json.JsonXContent;  
 *
        jsonGen.writeEndArray();
/*  
import java.io.IOException;  
                    assertThat(parser1.currentName(), equalTo(parser2.currentName()));  
        ) {
            if (token1 == null) {
        try (
        xsonGen.writeNull();
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.common.xcontent.cbor;
        jsonGen.writeEndObject();
/*  
        BytesStreamOutput jsonOs = new BytesStreamOutput();
                assertThat(token2, nullValue());  
import static org.hamcrest.Matchers.nullValue;  
    private void verifySameTokens(XContentParser parser1, XContentParser parser2) throws IOException {
import org.opensearch.core.xcontent.XContentGenerator;
        xsonGen.writeEndObject();  
        xsonGen.writeFieldName("arr");
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.test.OpenSearchTestCase;
 * KIND, either express or implied.  See the License for the
        jsonGen.writeNull();
    }
}  
    }
public class JsonVsCborTests extends OpenSearchTestCase {
 * SPDX-License-Identifier: Apache-2.0
        xsonGen.writeNumber(1);
        jsonGen.close();
                case VALUE_NUMBER:
 * specific language governing permissions and limitations
        XContentGenerator xsonGen = XContentType.CBOR.xContent().createGenerator(xsonOs);
 * compatible open source license.
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
            verifySameTokens(json0sParser, xson0sParser);  
        xsonGen.writeEndArray();  
        jsonGen.writeNumber(1);  
                    break;
                    break;
 *
        jsonGen.writeStartArray();
        XContentGenerator jsonGen = MediaTypeRegistry.JSON.xContent().createGenerator(jsonOs);
 * Unless required by applicable law or agreed to in writing,
        BytesStreamOutput xsonOs = new BytesStreamOutput();
            XContentParser.Token token1 = parser1.nextToken();  
