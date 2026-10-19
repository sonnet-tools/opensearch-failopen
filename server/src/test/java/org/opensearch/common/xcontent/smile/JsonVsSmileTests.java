 * KIND, either express or implied.  See the License for the
                case VALUE_STRING:  
        }
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
package org.opensearch.common.xcontent.smile;
        }
        jsonGen.writeStringField("test", "value");
import org.opensearch.core.xcontent.XContentParser;  
import org.opensearch.common.xcontent.XContentType;
        xsonGen.writeEndObject();  
                return;
        ) {  
        jsonGen.writeNull();
                    assertThat(parser1.numberType(), equalTo(parser2.numberType()));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
            assertThat(token1, equalTo(token2));
        xsonGen.writeEndArray();  
import static org.hamcrest.Matchers.nullValue;  
    }  
            XContentParser jsonParser = createParser(JsonXContent.jsonXContent, jsonOs.bytes());
                case VALUE_NUMBER:  
            XContentParser smileParser = createParser(SmileXContent.smileXContent, xsonOs.bytes())
/*  
        jsonGen.writeStartObject();
                    assertThat(parser1.numberValue(), equalTo(parser2.numberValue()));
 * Unless required by applicable law or agreed to in writing,
        xsonGen.writeFieldName("arr");
 *     http://www.apache.org/licenses/LICENSE-2.0
        jsonGen.writeFieldName("arr");  
 * not use this file except in compliance with the License.
            XContentParser.Token token1 = parser1.nextToken();
/*  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        jsonGen.writeEndArray();
 */
        XContentGenerator jsonGen = MediaTypeRegistry.JSON.xContent().createGenerator(jsonOs);
                    break;  
        while (true) {  
    public void testCompareParsingTokens() throws IOException {  
import java.io.IOException;  
 * under the License.  
            }  
import org.opensearch.common.io.stream.BytesStreamOutput;
                assertThat(token2, nullValue());
                    break;
 * Licensed to Elasticsearch under one or more contributor  
                    assertThat(parser1.currentName(), equalTo(parser2.currentName()));
import org.opensearch.common.xcontent.json.JsonXContent;  
        try (  
}
        xsonGen.writeStartArray();
 * Modifications Copyright OpenSearch Contributors. See
        xsonGen.writeNull();
/*
            XContentParser.Token token2 = parser2.nextToken();
 * specific language governing permissions and limitations
import org.opensearch.core.xcontent.XContentGenerator;
        xsonGen.writeStartObject();
 * license agreements. See the NOTICE file distributed with
        XContentGenerator xsonGen = XContentType.SMILE.xContent().createGenerator(xsonOs);
            switch (token1) {
import static org.hamcrest.Matchers.equalTo;
public class JsonVsSmileTests extends OpenSearchTestCase {
 */  
        jsonGen.writeEndObject();
    private void verifySameTokens(XContentParser parser1, XContentParser parser2) throws IOException {
            }
import org.opensearch.test.OpenSearchTestCase;
            if (token1 == null) {  
        xsonGen.writeStringField("test", "value");
 *
        xsonGen.writeNumber(1);
 * compatible open source license.
 *
        xsonGen.close();  
 * The OpenSearch Contributors require contributions made to  
                    break;
                    assertThat(parser1.text(), equalTo(parser2.text()));
            verifySameTokens(jsonParser, smileParser);
    }  
 * software distributed under the License is distributed on an
        jsonGen.writeStartArray();
 * GitHub history for details.
        BytesStreamOutput jsonOs = new BytesStreamOutput();
 *  
        jsonGen.writeNumber(1);  
 * SPDX-License-Identifier: Apache-2.0
                case FIELD_NAME:  
 * this work for additional information regarding copyright
        jsonGen.close();
        BytesStreamOutput xsonOs = new BytesStreamOutput();
