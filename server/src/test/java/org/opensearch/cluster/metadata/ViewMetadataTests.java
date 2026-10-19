        final BytesStreamOutput out = new BytesStreamOutput();
import org.opensearch.core.common.bytes.BytesReference;
        after.diff(before).writeTo(out);
            randomNonNegativeLong(),  
        final XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder();
                LoggingDeprecationHandler.INSTANCE,
        return new ViewMetadata(Map.of(randomAlphaOfLength(8), view));
 * SPDX-License-Identifier: Apache-2.0
/**
            final Metadata read = Metadata.Builder.fromXContent(parser);
        final StreamInput in = new NamedWriteableAwareStreamInput(out.bytes().streamInput(), WRITEABLES);
            Set.of(new View.Target("logs-*"), new View.Target("metrics-" + randomAlphaOfLength(4)))
}  
    static ViewMetadata randomViewMetadata() {
            new ToXContent.MapParams(Map.of(Metadata.CONTEXT_MODE_PARAM, Metadata.CONTEXT_MODE_GATEWAY))
import org.opensearch.common.xcontent.XContentType;  
    public void testDiffRoundTrip() throws IOException {
        original.writeTo(out);
        );
    }  
        final View view = new View(  
            randomNonNegativeLong(),
import java.util.Map;
                XContentType.JSON
import java.io.IOException;  
public class ViewMetadataTests extends OpenSearchTestCase {  
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
        try (
            original,
    }
    public void testXContentRoundTrip() throws IOException {
    private static final NamedXContentRegistry XCONTENTS = new NamedXContentRegistry(ClusterModule.getNamedXWriteables());  
import static org.hamcrest.Matchers.notNullValue;
                XCONTENTS,
        }
    public void testWireRoundTrip() throws IOException {
 */  
import org.opensearch.common.xcontent.XContentHelper;
            randomAlphaOfLength(8),
 * The OpenSearch Contributors require contributions made to  
@SuppressWarnings("removal")
    private static final NamedWriteableRegistry WRITEABLES = new NamedWriteableRegistry(ClusterModule.getNamedWriteables());
        final Diff<Metadata> diff = Metadata.readDiffFrom(in);  
 * compatible open source license.
        final Metadata original = Metadata.builder().putCustom(ViewMetadata.TYPE, randomViewMetadata()).build();
            builder,  
        Metadata.Builder.toXContent(
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * The Views feature is removed, but a {@code view} custom written by an earlier 3.x node must still deserialize during a
        assertThat(read.custom(ViewMetadata.TYPE), equalTo(original.custom(ViewMetadata.TYPE)));
import org.opensearch.core.xcontent.ToXContent;
        final Metadata read = Metadata.readFrom(new NamedWriteableAwareStreamInput(out.bytes().streamInput(), WRITEABLES));  
 *
        );  
import org.opensearch.core.xcontent.XContentParser;  
 */
        builder.startObject();  
        final BytesStreamOutput out = new BytesStreamOutput();  
        ) {  
    }  
        builder.endObject();  
            assertThat(read.custom(ViewMetadata.TYPE), notNullValue());
package org.opensearch.cluster.metadata;
import org.opensearch.cluster.ClusterModule;
        final Metadata after = Metadata.builder(before).putCustom(ViewMetadata.TYPE, randomViewMetadata()).build();
import org.opensearch.core.xcontent.NamedXContentRegistry;  
    }
import org.opensearch.cluster.Diff;
        final Metadata original = Metadata.builder().putCustom(ViewMetadata.TYPE, randomViewMetadata()).build();  
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
                BytesReference.bytes(builder),  
/*  
 * rolling upgrade. These tests pin the surviving reader to the persisted wire and XContent formats.  
            XContentParser parser = XContentHelper.createParser(  
import java.util.Set;
            assertThat(read.custom(ViewMetadata.TYPE), equalTo(original.custom(ViewMetadata.TYPE)));  
import org.opensearch.common.io.stream.BytesStreamOutput;  
import org.opensearch.core.common.io.stream.StreamInput;
 * this file be licensed under the Apache-2.0 license or a
            randomBoolean() ? null : randomAlphaOfLength(20),
import org.opensearch.core.xcontent.XContentBuilder;
        final Metadata before = Metadata.builder().putCustom(ViewMetadata.TYPE, randomViewMetadata()).build();  
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
import static org.hamcrest.Matchers.equalTo;
        assertThat(diff.apply(before).custom(ViewMetadata.TYPE), equalTo(after.custom(ViewMetadata.TYPE)));
            )
