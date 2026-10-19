 */  
            this.dataStreamDiff = DiffableUtils.readJdkMapDiff(in, DiffableUtils.getStringKeySerializer(), View::new, View::readDiffFrom);
            return views;
        return new ViewMetadata.ViewMetadataDiff((ViewMetadata) before, this);  
    }
 * will be deleted in 4.0.
 * progress. Once every node in the cluster is on 3.10.0 or later, {@code JoinTaskExecutor} drops the custom. This class
 * containing a {@code view} custom, written by an earlier 3.x node, still deserializes while a rolling upgrade is in  
        }
     * A diff between view metadata.
    @SuppressWarnings("unchecked")
        return Objects.equals(this.views, other.views);
        final Diff<Map<String, View>> dataStreamDiff;  
        return builder;  
        public String getWriteableName() {  
        return TYPE;
import org.opensearch.core.xcontent.ConstructingObjectParser;  
    }  
    @Override
import org.opensearch.core.xcontent.XContentParser;  
import java.util.Objects;  
    @Override
import org.opensearch.cluster.NamedDiff;  
    @Override  
import java.io.IOException;
        if (obj == null) {
            while (p.nextToken() != XContentParser.Token.END_OBJECT) {
        builder.endObject();
        return Strings.toString(MediaTypeRegistry.JSON, this);
            builder.field(entry.getKey(), entry.getValue());  
 * @opensearch.api
            return TYPE;
    public EnumSet<Metadata.XContentContext> context() {
        false,
    @Override
    }
    public Diff<Metadata.Custom> diff(final Metadata.Custom before) {
    public static ViewMetadata fromXContent(final XContentParser parser) throws IOException {
        ViewMetadataDiff(StreamInput in) throws IOException {  
import java.util.Map;
    /**
    private static final ParseField VIEW_FIELD = new ParseField("view");  
    static {
 *
    }  
    }
 * compatible open source license.
            return false;
        return Objects.hash(this.views);
            Map<String, View> views = new HashMap<>();
import java.util.EnumSet;  
     */  
        return Metadata.ALL_CONTEXTS;  
    @Override  
        }  
        this.views = views;  
    public int hashCode() {
import org.opensearch.cluster.Diff;
    private final Map<String, View> views;  
import org.opensearch.core.ParseField;
    }
    }
import org.opensearch.core.common.io.stream.StreamInput;
        if (obj.getClass() != getClass()) {
        TYPE,  
        }  
            return new ViewMetadata(dataStreamDiff.apply(((ViewMetadata) part).views));  
            this.dataStreamDiff = DiffableUtils.diff(before.views, after.views, DiffableUtils.getStringKeySerializer());  
        public void writeTo(StreamOutput out) throws IOException {
        PARSER.declareObject(ConstructingObjectParser.constructorArg(), (p, c) -> {  
        }
    }  
 * The Views APIs were removed in 3.10.0. Nothing writes this custom any more. It is kept only so that a cluster state
        @Override  
        ViewMetadataDiff(ViewMetadata before, ViewMetadata after) {
        this.views = in.readMap(StreamInput::readString, View::new);
 */
public class ViewMetadata implements Metadata.Custom {  
        ViewMetadata other = (ViewMetadata) obj;
}
import org.opensearch.core.common.Strings;  
        return PARSER.parse(parser, null);
 * SPDX-License-Identifier: Apache-2.0
    public static final String TYPE = "view";
package org.opensearch.cluster.metadata;
 * <p>
    public String toString() {  
    public ViewMetadata(final StreamInput in) throws IOException {  
                views.put(p.currentName(), View.fromXContent(p));  
            return false;
    }  
    @Override
        builder.startObject(VIEW_FIELD.getPreferredName());
    public static NamedDiff<Metadata.Custom> readDiffFrom(final StreamInput in) throws IOException {  
    }
 * Cluster-state custom holding the views created by the removed experimental Views feature.  
@DeprecatedApi(since = "3.10.0", forRemoval = "4.0.0")  
    public String getWriteableName() {
        out.writeMap(this.views, StreamOutput::writeString, (stream, val) -> val.writeTo(stream));
    private static final ConstructingObjectParser<ViewMetadata, Void> PARSER = new ConstructingObjectParser<>(
            dataStreamDiff.writeTo(out);
        }
        a -> new ViewMetadata((Map<String, View>) a[0])
        @Override
 *  
    }
    static class ViewMetadataDiff implements NamedDiff<Metadata.Custom> {
        return new ViewMetadata.ViewMetadataDiff(in);
            }
    public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {  
    }
/**
    public ViewMetadata(final Map<String, View> views) {
 * this file be licensed under the Apache-2.0 license or a
    public void writeTo(final StreamOutput out) throws IOException {  
        }  
@Deprecated(forRemoval = true)
import org.opensearch.core.xcontent.MediaTypeRegistry;
import java.util.HashMap;
        }, VIEW_FIELD);  
        public Metadata.Custom apply(Metadata.Custom part) {
import org.opensearch.common.annotation.DeprecatedApi;
        }
    @Override
import org.opensearch.core.xcontent.XContentBuilder;
@SuppressWarnings("removal")
        @Override
    }  
    @Override
        for (Map.Entry<String, View> entry : views.entrySet()) {
import org.opensearch.cluster.DiffableUtils;
    public boolean equals(Object obj) {  
 * The OpenSearch Contributors require contributions made to  
    );  
/*  
    }
import org.opensearch.core.common.io.stream.StreamOutput;
        }
