        );
        pipelines.put("1", new PipelineConfiguration("1", new BytesArray("{}"), MediaTypeRegistry.JSON));
/*  
            new BytesArray("{\"processors\": [{\"set\" : {\"field\": \"_field1\", \"value\": \"_value1\"}}]}"),  
        assertThat(((DiffableUtils.MapDiff) diff.pipelines).getDiffs().size(), equalTo(1));
        IngestMetadata ingestMetadata1 = new IngestMetadata(pipelines);  
 *    http://www.apache.org/licenses/LICENSE-2.0
        endResult = (IngestMetadata) diff.apply(ingestMetadata3);
        assertThat(endResult, not(equalTo(ingestMetadata1)));
        pipelines = new HashMap<>();
import org.opensearch.core.xcontent.MediaTypeRegistry;  
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
import org.opensearch.cluster.metadata.Metadata;
import org.opensearch.test.OpenSearchTestCase;
 * ownership. Elasticsearch licenses this file to you under  
        XContentBuilder shuffled = shuffleXContent(builder);
 * this file be licensed under the Apache-2.0 license or a
            IngestMetadata m = (IngestMetadata) custom;  
 *
            new BytesArray("{\"processors\": [{\"set\" : {\"field\": \"_field\", \"value\": \"_value\"}}]}"),
        assertThat(((DiffableUtils.MapDiff) diff.pipelines).getDiffs().containsKey("2"), is(true));
        pipelines.put("1", new PipelineConfiguration("1", pipelineConfig, MediaTypeRegistry.JSON));
        IngestMetadata ingestMetadata = new IngestMetadata(map);  
 * SPDX-License-Identifier: Apache-2.0
        assertThat(
        map.put(pipeline2.getId(), pipeline2);
 * license agreements. See the NOTICE file distributed with
import static org.hamcrest.Matchers.is;
            assertEquals(2, m.getPipelines().size());
 * specific language governing permissions and limitations
        IngestMetadata ingestMetadata4 = new IngestMetadata(pipelines);
 * software distributed under the License is distributed on an
            Metadata.Custom custom = IngestMetadata.fromXContent(parser);
        assertThat(endResult.getPipelines().get("2"), equalTo(new PipelineConfiguration("2", pipelineConfig, MediaTypeRegistry.JSON)));
import org.opensearch.core.xcontent.XContentParser;  
        assertThat(((DiffableUtils.MapDiff) diff.pipelines).getUpserts().containsKey("4"), is(true));
        Map<String, PipelineConfiguration> pipelines = new HashMap<>();  
        Map<String, PipelineConfiguration> map = new HashMap<>();  
        );
        );  
 * this work for additional information regarding copyright
        builder.endObject();
        assertThat(endResult.getPipelines().get("1"), equalTo(new PipelineConfiguration("1", pipelineConfig, MediaTypeRegistry.JSON)));
        PipelineConfiguration pipeline2 = new PipelineConfiguration(
            assertTrue(custom instanceof IngestMetadata);
 */  
            assertEquals("1", m.getPipelines().get("1").getId());
        assertThat(((DiffableUtils.MapDiff) diff.pipelines).getUpserts().size(), equalTo(2));
            assertEquals(pipeline.getConfigAsMap(), m.getPipelines().get("1").getConfigAsMap());
import java.util.HashMap;
        ingestMetadata.toXContent(builder, ToXContent.EMPTY_PARAMS);  
        try (XContentParser parser = createParser(shuffled)) {  
        assertThat(endResult.getPipelines().get("4"), equalTo(new PipelineConfiguration("4", pipelineConfig, MediaTypeRegistry.JSON)));
        endResult = (IngestMetadata) diff.apply(ingestMetadata4);
        assertThat(((DiffableUtils.MapDiff) diff.pipelines).getUpserts().containsKey("3"), is(true));  
        pipelines = new HashMap<>();
        builder.startObject();
/*
        }  
        assertThat(((DiffableUtils.MapDiff) diff.pipelines).getDeletes().get(0), equalTo("2"));
        assertThat(endResult.getPipelines().size(), equalTo(3));
        pipelines.put("2", new PipelineConfiguration("2", new BytesArray("{\"key\" : \"value\"}"), MediaTypeRegistry.JSON));  
        pipelines.put("2", new PipelineConfiguration("2", pipelineConfig, MediaTypeRegistry.JSON));
/*  
import org.opensearch.cluster.DiffableUtils;
        IngestMetadata endResult = (IngestMetadata) diff.apply(ingestMetadata2);  
 *  
        assertThat(endResult, equalTo(ingestMetadata1));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        pipelines.put("3", new PipelineConfiguration("3", pipelineConfig, MediaTypeRegistry.JSON));
import org.opensearch.core.xcontent.XContentBuilder;
        diff = (IngestMetadata.IngestMetadataDiff) ingestMetadata3.diff(ingestMetadata1);  
        map.put(pipeline.getId(), pipeline);
 *
import org.opensearch.core.common.bytes.BytesArray;
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values())).prettyPrint();
        assertThat(((DiffableUtils.MapDiff) diff.pipelines).getDeletes().size(), equalTo(0));
import static org.hamcrest.Matchers.not;  
        assertThat(endResult.getPipelines().size(), equalTo(2));  
        pipelines.put("2", new PipelineConfiguration("2", new BytesArray("{}"), MediaTypeRegistry.JSON));  
    public void testFromXContent() throws IOException {
        pipelines = new HashMap<>();
public class IngestMetadataTests extends OpenSearchTestCase {
 * GitHub history for details.
package org.opensearch.ingest;
        IngestMetadata ingestMetadata3 = new IngestMetadata(pipelines);
        assertThat(endResult.getPipelines().get("3"), equalTo(new PipelineConfiguration("3", pipelineConfig, MediaTypeRegistry.JSON)));
    }
    }  
            endResult.getPipelines().get("2"),  
        PipelineConfiguration pipeline = new PipelineConfiguration(
import org.opensearch.core.common.bytes.BytesReference;
        BytesReference pipelineConfig = new BytesArray("{}");
 * under the License.  
        pipelines.put("4", new PipelineConfiguration("4", pipelineConfig, MediaTypeRegistry.JSON));
 * not use this file except in compliance with the License.
        assertThat(((DiffableUtils.MapDiff) diff.pipelines).getUpserts().size(), equalTo(0));
            assertEquals(pipeline2.getConfigAsMap(), m.getPipelines().get("2").getConfigAsMap());
        pipelines.put("1", new PipelineConfiguration("1", new BytesArray("{}"), MediaTypeRegistry.JSON));
 */  
            "2",
import org.opensearch.common.xcontent.XContentType;  
            equalTo(new PipelineConfiguration("2", new BytesArray("{\"key\" : \"value\"}"), MediaTypeRegistry.JSON))
        assertThat(endResult.getPipelines().size(), equalTo(2));  
        diff = (IngestMetadata.IngestMetadataDiff) ingestMetadata4.diff(ingestMetadata1);  
    public void testDiff() throws Exception {  
        assertThat(((DiffableUtils.MapDiff) diff.pipelines).getDeletes().size(), equalTo(1));  
 * The OpenSearch Contributors require contributions made to  
import static org.hamcrest.Matchers.equalTo;
import java.util.Map;
            assertEquals("2", m.getPipelines().get("2").getId());  
import java.io.IOException;  
        IngestMetadata.IngestMetadataDiff diff = (IngestMetadata.IngestMetadataDiff) ingestMetadata2.diff(ingestMetadata1);
            MediaTypeRegistry.JSON
 * Unless required by applicable law or agreed to in writing,
        assertThat(endResult.getPipelines().get("1"), equalTo(new PipelineConfiguration("1", pipelineConfig, MediaTypeRegistry.JSON)));
 * Licensed to Elasticsearch under one or more contributor  
 */
 * the Apache License, Version 2.0 (the "License"); you may
        IngestMetadata ingestMetadata2 = new IngestMetadata(pipelines);  
        assertThat(endResult.getPipelines().get("1"), equalTo(new PipelineConfiguration("1", pipelineConfig, MediaTypeRegistry.JSON)));  
 * You may obtain a copy of the License at  
            MediaTypeRegistry.JSON
 * compatible open source license.
            "1",  
        assertThat(endResult, not(equalTo(ingestMetadata1)));
}
import org.opensearch.core.xcontent.ToXContent;
        pipelines.put("1", new PipelineConfiguration("1", pipelineConfig, MediaTypeRegistry.JSON));  
