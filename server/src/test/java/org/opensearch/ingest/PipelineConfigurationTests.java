        final BytesReference bytes;
import org.opensearch.core.xcontent.XContentBuilder;  
import org.opensearch.core.common.bytes.BytesArray;
        StreamInput in = StreamInput.wrap(out.bytes().toBytesRef().bytes);
import java.io.IOException;
            MediaTypeRegistry.JSON
            .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, bytes.streamInput());  
            "1",  
/*  
            config = new BytesArray("{}".getBytes(StandardCharsets.UTF_8));
    }
/*
    }
    @Override  
 */  
        PipelineConfiguration serialized = PipelineConfiguration.readFrom(in);  
        BytesStreamOutput out = new BytesStreamOutput();  
 * software distributed under the License is distributed on an
/*  
 * compatible open source license.
package org.opensearch.ingest;
            config = new BytesArray("{\"foo\": \"bar\"}".getBytes(StandardCharsets.UTF_8));
        return field -> field.equals("config");  
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
    }  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.xcontent.XContentParser;
 * KIND, either express or implied.  See the License for the
import java.util.function.Predicate;  
 * not use this file except in compliance with the License.
        assertEquals("1", parsed.getId());
    }
        BytesArray config;  
    protected PipelineConfiguration createTestInstance() {
        assertEquals(MediaTypeRegistry.JSON, serialized.getMediaType());
            bytes = BytesReference.bytes(builder);
            );
        );  
 */  
    public void testParser() throws IOException {
    public void testSerialization() throws IOException {
                builder,
 *
        configuration.writeTo(out);
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
import org.opensearch.core.common.io.stream.StreamInput;  
        assertEquals(xContentType, parsed.getMediaType());
public class PipelineConfigurationTests extends AbstractXContentTestCase<PipelineConfiguration> {
import org.opensearch.core.xcontent.ContextParser;
    @Override
            new BytesArray("{}".getBytes(StandardCharsets.UTF_8)),
        PipelineConfiguration parsed = parser.parse(xContentParser, null);
    }
    protected Predicate<String> getRandomFieldsExcludeFilter() {
        assertEquals(MediaTypeRegistry.JSON, configuration.getMediaType());
import org.opensearch.common.io.stream.BytesStreamOutput;
 * under the License.  
 */
import org.opensearch.core.xcontent.MediaTypeRegistry;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
        XContentParser xContentParser = xContentType.xContent()
 * The OpenSearch Contributors require contributions made to  
        if (randomBoolean()) {
    protected PipelineConfiguration doParseInstance(XContentParser parser) throws IOException {
 *  
        return PipelineConfiguration.getParser().parse(parser, null);
import java.nio.charset.StandardCharsets;
        XContentType xContentType = randomFrom(XContentType.values());
        return true;
        } else {  
        }  
import org.opensearch.core.xcontent.ToXContent;
        }
        return new PipelineConfiguration(randomAlphaOfLength(4), config, MediaTypeRegistry.JSON);  
 *
        ContextParser<Void, PipelineConfiguration> parser = PipelineConfiguration.getParser();  
        PipelineConfiguration configuration = new PipelineConfiguration(
import org.opensearch.core.xcontent.NamedXContentRegistry;
        try (XContentBuilder builder = XContentBuilder.builder(xContentType.xContent())) {  
    }  
import org.opensearch.test.AbstractXContentTestCase;
                ToXContent.EMPTY_PARAMS  
    @Override
 * Licensed to Elasticsearch under one or more contributor  
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.common.bytes.BytesReference;
}
import org.opensearch.core.xcontent.DeprecationHandler;
 * Unless required by applicable law or agreed to in writing,
    protected boolean supportsUnknownFields() {  
import org.opensearch.common.xcontent.XContentType;  
            new PipelineConfiguration("1", new BytesArray("{}".getBytes(StandardCharsets.UTF_8)), MediaTypeRegistry.JSON).toXContent(
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals("{}", serialized.getConfig().utf8ToString());
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.xcontent.XContentHelper;
        assertEquals("{}", XContentHelper.convertToJson(parsed.getConfig(), false, parsed.getMediaType()));  
 * Modifications Copyright OpenSearch Contributors. See
