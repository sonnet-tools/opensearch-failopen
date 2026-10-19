 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.action.explain;
        );  
            -1,
        String index = "index";
            null
            explanations.length > 0 ? explanations : new Explanation[0]
import org.opensearch.core.xcontent.XContentParser;  
            + "        \"description\":\"description\",\n"  
 * this work for additional information regarding copyright
            + "    \"explanation\":{\n"
 * You may obtain a copy of the License at  
        String id = "1";  
import org.opensearch.test.AbstractSerializingTestCase;
/*  
 */
            + "    \"_index\":\"index\",\n"
            + "}").replaceAll("\\s+", "");
        boolean exist = randomBoolean();
            randomAlphaOfLengthBetween(3, 10),  
        GetResult getResult = new GetResult(
 * The OpenSearch Contributors require contributions made to  
        return Explanation.match(
        Explanation explanation = randomExplanation(randomExplanation(randomExplanation()), randomExplanation());
    @Override
    private static Explanation randomExplanation(Explanation... explanations) {  
    protected Writeable.Reader<ExplainResponse> instanceReader() {
            + "    }\n"
 *    http://www.apache.org/licenses/LICENSE-2.0
            new BytesArray("{ \"field1\" : " + "\"value1\", \"field2\":\"value2\"}"),
            null  
        );
        assertThat(expectedResponse, equalTo(generatedResponse));  
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
            true,
import java.util.Arrays;  
            randomNonNegativeLong(),
            + "    \"_id\":\"1\",\n"
        String index = randomAlphaOfLength(5);
 *
 *  
import java.util.Collections;
import org.opensearch.core.common.bytes.BytesArray;  
import java.io.IOException;
        String expectedResponse = ("{\n"  
            0,
 * SPDX-License-Identifier: Apache-2.0
/*  
import org.opensearch.common.document.DocumentField;
    public void testToXContent() throws IOException {  
            + "            \"field1\":\"value1\",\n"
import java.util.List;
        GetResult getResult = new GetResult(  
    @Override
            + "        \"fields\":{\n"
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
            true,  
            + "            \"field2\":\"value2\"\n"  
            randomAlphaOfLengthBetween(1, 10),  
            1,  
/*
import java.util.function.Predicate;  
 * not use this file except in compliance with the License.
    protected ExplainResponse createTestInstance() {
            singletonMap(fieldName, new DocumentField(fieldName, values)),
 * compatible open source license.
 */  
        return new ExplainResponse(index, id, exist, explanation, getResult);
        Explanation explanation = Explanation.match(1.0f, "description", Collections.emptySet());
 */  
public class ExplainResponseTests extends AbstractSerializingTestCase<ExplainResponse> {  
            + "        \"found\":true,\n"  
        ExplainResponse response = new ExplainResponse(index, id, exist, explanation, getResult);
import org.apache.lucene.search.Explanation;
        return field -> field.equals("get") || field.startsWith("get.fields") || field.startsWith("get._source");  
 * license agreements. See the NOTICE file distributed with
        response.toXContent(builder, ToXContent.EMPTY_PARAMS);
            + "    },\n"
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.test.RandomObjects;  
            + "        \"_seq_no\":0,"
    }
    }
            + "        }\n"  
            1,
        return ExplainResponse::new;  
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
        String type = "type";
            randomAlphaOfLengthBetween(3, 10),
            + "            \"field1\":[\n"  
        String id = String.valueOf(randomIntBetween(1, 100));  
            null,
 * specific language governing permissions and limitations
    @Override
    protected ExplainResponse doParseInstance(XContentParser parser) throws IOException {  
            + "        \"_source\":{\n"
 * KIND, either express or implied.  See the License for the
        String generatedResponse = BytesReference.bytes(builder).utf8ToString().replaceAll("\\s+", "");
 * GitHub history for details.
            0,  
            + "        \"value\":1.0,\n"
        List<Object> values = Arrays.asList(randomAlphaOfLengthBetween(3, 10), randomInt(), randomLong(), randomDouble(), randomBoolean());
import org.opensearch.index.get.GetResult;
            + "    \"get\":{\n"  
    }
    protected Predicate<String> getRandomFieldsExcludeFilter() {
        return ExplainResponse.fromXContent(parser, randomBoolean());
import static java.util.Collections.singletonList;
            + "        \"_primary_term\":1,"
    }  
            null,
import org.opensearch.core.xcontent.MediaTypeRegistry;  
            + "            ]\n"
    @Override  
            + "                \"value1\"\n"
        String fieldName = randomAlphaOfLength(10);  
 * Modifications Copyright OpenSearch Contributors. See
        );
            + "    \"matched\":true,\n"  
    }
import static org.hamcrest.Matchers.equalTo;
            randomFloat(),
import static java.util.Collections.singletonMap;  
 * the Apache License, Version 2.0 (the "License"); you may
            singletonMap("field1", new DocumentField("field1", singletonList("value1"))),
import org.opensearch.core.common.io.stream.Writeable;
            + "        },\n"
import org.opensearch.core.xcontent.ToXContent;
import org.opensearch.core.xcontent.XContentBuilder;
    }
            + "        \"details\":[]\n"
            RandomObjects.randomSource(random()),  
        boolean exist = true;
}
