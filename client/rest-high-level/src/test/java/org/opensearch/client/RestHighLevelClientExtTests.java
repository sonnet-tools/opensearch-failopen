        private RestHighLevelClientExt(RestClient restClient) {
    private RestHighLevelClient restHighLevelClient;
                )
            assertEquals("array", parser.currentName());
import java.io.IOException;
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
    private static class RestHighLevelClientExt extends RestHighLevelClient {  
            assertThat(customSection, instanceOf(CustomResponseSection2.class));  
package org.opensearch.client;
import org.opensearch.test.OpenSearchTestCase;
            return responseSection2;
            this.value = value;  
            CustomResponseSection2 customResponseSection2 = (CustomResponseSection2) customSection;
        {  
            BaseCustomResponseSection customSection = restHighLevelClient.parseEntity(jsonEntity, BaseCustomResponseSection::fromXContent);
 *
public class RestHighLevelClientExtTests extends OpenSearchTestCase {  
                )
            BaseCustomResponseSection customSection = restHighLevelClient.parseEntity(jsonEntity, BaseCustomResponseSection::fromXContent);
        {
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
            return responseSection1;
        private final String[] values;
 */  
            HttpEntity jsonEntity = new StringEntity("{\"custom2\":{ \"array\": [\"item1\", \"item2\"]}}", ContentType.APPLICATION_JSON);
            assertThat(customSection, instanceOf(CustomResponseSection1.class));
        }
            List<NamedXContentRegistry.Entry> entries = new ArrayList<>();
import org.apache.hc.core5.http.HttpEntity;
    }  
import org.apache.hc.core5.http.io.entity.StringEntity;  
        static CustomResponseSection2 fromXContent(XContentParser parser) throws IOException {
            entries.add(  
        static CustomResponseSection1 fromXContent(XContentParser parser) throws IOException {  
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());  
            CustomResponseSection2 responseSection2 = new CustomResponseSection2(values.toArray(new String[0]));
            super(restClient, RestClient::close, getNamedXContentsExt());  
        }
                values.add(parser.text());
import static org.mockito.Mockito.mock;  
/*  
 * This test works against a {@link RestHighLevelClient} subclass that simulates how custom response sections returned by  
    private static class CustomResponseSection1 extends BaseCustomResponseSection {
                new NamedXContentRegistry.Entry(  
                new NamedXContentRegistry.Entry(
 * KIND, either express or implied.  See the License for the
    }  
                    new ParseField("custom2"),  
 * this file be licensed under the Apache-2.0 license or a
            assertEquals(XContentParser.Token.START_ARRAY, parser.nextToken());
    private static class CustomResponseSection2 extends BaseCustomResponseSection {
                    CustomResponseSection2::fromXContent
        }
            assertEquals("value", customResponseSection1.value);
            while (parser.nextToken().isValue()) {
        private static List<NamedXContentRegistry.Entry> getNamedXContentsExt() {  
        }
            entries.add(
 * ownership. Elasticsearch licenses this file to you under  
            CustomResponseSection1 responseSection1 = new CustomResponseSection1(parser.text());
import org.junit.Before;
    private abstract static class BaseCustomResponseSection {
            HttpEntity jsonEntity = new StringEntity("{\"custom1\":{ \"field\":\"value\"}}", ContentType.APPLICATION_JSON);  
            return custom;  
    }
            assertEquals(XContentParser.Token.VALUE_STRING, parser.nextToken());
    }  
 * OpenSearch plugins can be parsed using the high level client.
 *
 * GitHub history for details.
        }
        }
        static BaseCustomResponseSection fromXContent(XContentParser parser) throws IOException {
        RestClient restClient = mock(RestClient.class);  
import org.apache.hc.core5.http.ContentType;
 * Modifications Copyright OpenSearch Contributors. See
}
 * not use this file except in compliance with the License.
            assertEquals(XContentParser.Token.END_ARRAY, parser.currentToken());
/**
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());  
                    BaseCustomResponseSection.class,
import org.opensearch.core.xcontent.NamedXContentRegistry;
                    CustomResponseSection1::fromXContent  
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
    public void initClient() {
    public void testParseEntityCustomResponseSection() throws IOException {
        private CustomResponseSection1(String value) {
 * Licensed to Elasticsearch under one or more contributor  
        restHighLevelClient = new RestHighLevelClientExt(restClient);
 * under the License.  
/*  
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
                    BaseCustomResponseSection.class,
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static org.hamcrest.CoreMatchers.instanceOf;
            assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());  
 * software distributed under the License is distributed on an
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
        }
            return entries;
        private CustomResponseSection2(String[] values) {  
        private final String value;  
import java.util.ArrayList;
 * this work for additional information regarding copyright
import java.util.List;  
    @Before
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
            CustomResponseSection1 customResponseSection1 = (CustomResponseSection1) customSection;  
 */
                    new ParseField("custom1"),
    }
import org.opensearch.core.ParseField;
 * Unless required by applicable law or agreed to in writing,
            );
        }  
 * The OpenSearch Contributors require contributions made to  
            );  
            }  
            this.values = values;
 */
            List<String> values = new ArrayList<>();  
import org.opensearch.core.xcontent.XContentParser;  
            assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertArrayEquals(new String[] { "item1", "item2" }, customResponseSection2.values);
            assertEquals("field", parser.currentName());  
        }
/*
    }
            assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());  
            BaseCustomResponseSection custom = parser.namedObject(BaseCustomResponseSection.class, parser.currentName(), null);
 */  
