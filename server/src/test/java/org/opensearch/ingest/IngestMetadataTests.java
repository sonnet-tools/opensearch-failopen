        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values())).prettyPrint();
        builder.startObject();
            new BytesArray("{\"processors\": [{\"set\" : {\"field\": \"_field\", \"value\": \"_value\"}}]}"),
 * this file be licensed under the Apache-2.0 license or a
            assertEquals("1", m.getPipelines().get("1").getId());
        map.put(pipeline2.getId(), pipeline2);
        IngestMetadata ingestMetadata4 = new IngestMetadata(pipelines);
        IngestMetadata endResult = (IngestMetadata) diff.apply(ingestMetadata2);
            assertEquals(pipeline2.getConfigAsMap(), m.getPipelines().get("2").getConfigAsMap());
 * compatible open source license.
import org.opensearch.core.common.bytes.BytesArray;
        assertThat(endResult, not(equalTo(ingestMetadata1)));
            assertEquals(pipeline.getConfigAsMap(), m.getPipelines().get("1").getConfigAsMap());
/*
        );
/*
        assertThat(endResult, equalTo(ingestMetadata1));
            assertEquals(2, m.getPipelines().size());
            "2",
 * You may obtain a copy of the License at
import org.opensearch.cluster.metadata.Metadata;
import org.opensearch.core.xcontent.XContentBuilder;
 * software distributed under the License is distributed on an
        pipelines = new HashMap<>();
package org.opensearch.ingest;
import org.opensearch.core.xcontent.MediaTypeRegistry;
}
import org.opensearch.cluster.DiffableUtils;
        XContentBuilder shuffled = shuffleXContent(builder);
/*
        assertThat(((DiffableUtils.MapDiff) diff.pipelines).getUpserts().size(), equalTo(2));
            Metadata.Custom custom = IngestMetadata.fromXContent(parser);
 * ownership. Elasticsearch licenses this file to you under
            MediaTypeRegistry.JSON
        Map<String, PipelineConfiguration> map = new HashMap<>();
 *
        assertThat(((DiffableUtils.MapDiff) diff.pipelines).getUpserts().containsKey("4"), is(true));
 *    http://www.apache.org/licenses/LICENSE-2.0
        PipelineConfiguration pipeline2 = new PipelineConfiguration(
        pipelines.put("1", new PipelineConfiguration("1", new BytesArray("{}"), MediaTypeRegistry.JSON));
        assertThat(
import org.opensearch.test.OpenSearchTestCase;
        }
        IngestMetadata.IngestMetadataDiff diff = (IngestMetadata.IngestMetadataDiff) ingestMetadata2.diff(ingestMetadata1);
        BytesReference pipelineConfig = new BytesArray("{}");
 * SPDX-License-Identifier: Apache-2.0
            equalTo(new PipelineConfiguration("2", new BytesArray("{\"key\" : \"value\"}"), MediaTypeRegistry.JSON))
        assertThat(((DiffableUtils.MapDiff) diff.pipelines).getUpserts().containsKey("3"), is(true));
            MediaTypeRegistry.JSON
        assertThat(((DiffableUtils.MapDiff) diff.pipelines).getDeletes().size(), equalTo(1));
    public void testDiff() throws Exception {
 * specific language governing permissions and limitations
        map.put(pipeline.getId(), pipeline);
 * The OpenSearch Contributors require contributions made to
        pipelines.put("1", new PipelineConfiguration("1", pipelineConfig, MediaTypeRegistry.JSON));
 * this work for additional information regarding copyright
    }
 * license agreements. See the NOTICE file distributed with
        try (XContentParser parser = createParser(shuffled)) {
        assertThat(endResult, not(equalTo(ingestMetadata1)));
 * GitHub history for details.
            new BytesArray("{\"processors\": [{\"set\" : {\"field\": \"_field1\", \"value\": \"_value1\"}}]}"),
        pipelines = new HashMap<>();
import java.util.Map;
        assertThat(endResult.getPipelines().get("1"), equalTo(new PipelineConfiguration("1", pipelineConfig, MediaTypeRegistry.JSON)));
        ingestMetadata.toXContent(builder, ToXContent.EMPTY_PARAMS);
 *
            endResult.getPipelines().get("2"),
 * the Apache License, Version 2.0 (the "License"); you may
        IngestMetadata ingestMetadata = new IngestMetadata(map);
        assertThat(endResult.getPipelines().size(), equalTo(2));
            IngestMetadata m = (IngestMetadata) custom;
        assertThat(endResult.getPipelines().get("1"), equalTo(new PipelineConfiguration("1", pipelineConfig, MediaTypeRegistry.JSON)));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        diff = (IngestMetadata.IngestMetadataDiff) ingestMetadata4.diff(ingestMetadata1);
    public void testFromXContent() throws IOException {
        endResult = (IngestMetadata) diff.apply(ingestMetadata4);
        assertThat(endResult.getPipelines().get("1"), equalTo(new PipelineConfiguration("1", pipelineConfig, MediaTypeRegistry.JSON)));
        pipelines.put("2", new PipelineConfiguration("2", new BytesArray("{\"key\" : \"value\"}"), MediaTypeRegistry.JSON));
        pipelines = new HashMap<>();
public class IngestMetadataTests extends OpenSearchTestCase {
 * under the License.
        diff = (IngestMetadata.IngestMetadataDiff) ingestMetadata3.diff(ingestMetadata1);
 * Unless required by applicable law or agreed to in writing,
            assertEquals("2", m.getPipelines().get("2").getId());
import org.opensearch.core.xcontent.ToXContent;
        pipelines.put("3", new PipelineConfiguration("3", pipelineConfig, MediaTypeRegistry.JSON));
        pipelines.put("2", new PipelineConfiguration("2", pipelineConfig, MediaTypeRegistry.JSON));
        assertThat(endResult.getPipelines().get("3"), equalTo(new PipelineConfiguration("3", pipelineConfig, MediaTypeRegistry.JSON)));
        PipelineConfiguration pipeline = new PipelineConfiguration(
import org.opensearch.core.xcontent.XContentParser;
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(((DiffableUtils.MapDiff) diff.pipelines).getDiffs().size(), equalTo(1));
        pipelines.put("4", new PipelineConfiguration("4", pipelineConfig, MediaTypeRegistry.JSON));
        );
        assertThat(endResult.getPipelines().get("4"), equalTo(new PipelineConfiguration("4", pipelineConfig, MediaTypeRegistry.JSON)));
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.core.common.bytes.BytesReference;
        IngestMetadata ingestMetadata3 = new IngestMetadata(pipelines);
        pipelines.put("1", new PipelineConfiguration("1", new BytesArray("{}"), MediaTypeRegistry.JSON));
        assertThat(endResult.getPipelines().size(), equalTo(3));
        );
 *
        IngestMetadata ingestMetadata1 = new IngestMetadata(pipelines);
    }
            assertTrue(custom instanceof IngestMetadata);
 * not use this file except in compliance with the License.
import static org.hamcrest.Matchers.equalTo;
 */
        pipelines.put("1", new PipelineConfiguration("1", pipelineConfig, MediaTypeRegistry.JSON));
import org.opensearch.common.xcontent.XContentType;
 * KIND, either express or implied.  See the License for the
        pipelines.put("2", new PipelineConfiguration("2", new BytesArray("{}"), MediaTypeRegistry.JSON));
import java.util.HashMap;
        endResult = (IngestMetadata) diff.apply(ingestMetadata3);
        assertThat(((DiffableUtils.MapDiff) diff.pipelines).getUpserts().size(), equalTo(0));
        assertThat(((DiffableUtils.MapDiff) diff.pipelines).getDeletes().get(0), equalTo("2"));
        assertThat(((DiffableUtils.MapDiff) diff.pipelines).getDeletes().size(), equalTo(0));
        Map<String, PipelineConfiguration> pipelines = new HashMap<>();
        builder.endObject();
 */
 */
import java.io.IOException;
            "1",
        assertThat(endResult.getPipelines().get("2"), equalTo(new PipelineConfiguration("2", pipelineConfig, MediaTypeRegistry.JSON)));
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
        assertThat(endResult.getPipelines().size(), equalTo(2));
        assertThat(((DiffableUtils.MapDiff) diff.pipelines).getDiffs().containsKey("2"), is(true));
        IngestMetadata ingestMetadata2 = new IngestMetadata(pipelines);
