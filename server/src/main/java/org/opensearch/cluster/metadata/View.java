import org.opensearch.core.common.io.stream.StreamOutput;  
        builder.field(TARGETS_FIELD.getPreferredName(), targets);
    @Override
 * @opensearch.api
        @Override
        PARSER.declareLongOrNull(ConstructingObjectParser.optionalConstructorArg(), -1L, MODIFIED_AT_FIELD);
    public static final ParseField MODIFIED_AT_FIELD = new ParseField("modifiedAt");
        public void writeTo(final StreamOutput out) throws IOException {
        return readDiffFrom(View::new, in);  
            && targets.equals(that.targets);  
        this.targets = new TreeSet<>(Objects.requireNonNull(targets, "Targets are required on a view"));
import org.opensearch.core.common.io.stream.StreamInput;
            args -> new Target((String) args[0])  
    }
        static {
@Deprecated(forRemoval = true)
    public static class Target implements Writeable, ToXContentObject, Comparable<Target> {
        public Target(final String indexPattern) {  
public class View extends AbstractDiffable<View> implements ToXContentObject {  
        }
        if (o == null || getClass() != o.getClass()) return false;  
            builder.field(INDEX_PATTERN_FIELD.getPreferredName(), indexPattern);
 */  
        return name.equals(that.name)
    public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {
        private final String indexPattern;
 *
import org.opensearch.cluster.AbstractDiffable;
        this(in.readString(), in.readOptionalString(), in.readZLong(), in.readZLong(), new TreeSet<>(in.readList(Target::new)));
 * Wire and XContent representation of a view persisted by the removed experimental Views feature.  
        builder.field(NAME_FIELD.getPreferredName(), name);
    public static View fromXContent(final XContentParser parser) throws IOException {  
        public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {  
    public boolean equals(Object o) {
    public static final ParseField DESCRIPTION_FIELD = new ParseField("description");
    @DeprecatedApi(since = "3.10.0", forRemoval = "4.0.0")  
        @Override
import org.opensearch.common.annotation.DeprecatedApi;  
    }
        }
        @Override  
    }  
            if (o == null || getClass() != o.getClass()) return false;
        @Override
import org.opensearch.core.ParseField;
            out.writeString(indexPattern);  
/*  
        public int hashCode() {
            return indexPattern.equals(that.indexPattern);
        builder.startObject();  
            Target that = (Target) o;  
        out.writeOptionalString(description);
    }
            return this.indexPattern.compareTo(o.indexPattern);  
    public static final ConstructingObjectParser<View, Void> PARSER = new ConstructingObjectParser<>(
        public static Target fromXContent(final XContentParser parser) throws IOException {  
        }  
    @Override
    public static Diff<View> readDiffFrom(final StreamInput in) throws IOException {
    public int hashCode() {
        out.writeZLong(modifiedAt);  
    public View(final String name, final String description, final Long createdAt, final Long modifiedAt, final Set<Target> targets) {
        out.writeList(List.copyOf(targets));
        );
        this.description = description;
        builder.field(MODIFIED_AT_FIELD.getPreferredName(), modifiedAt);
 * earlier 3.x node can still be read during a rolling upgrade; see {@link ViewMetadata}. It will be deleted in 4.0.  
    }
    public void writeTo(final StreamOutput out) throws IOException {
        }
        return PARSER.parse(parser, null);
        out.writeString(name);  
        }
    }
        PARSER.declareStringOrNull(ConstructingObjectParser.optionalConstructorArg(), DESCRIPTION_FIELD);  
            return PARSER.parse(parser, null);
            if (this == o) return true;
    private final String description;  
    @SuppressWarnings("unchecked")
/**
        if (this == o) return true;
import org.opensearch.core.common.io.stream.Writeable;
        public static final ParseField INDEX_PATTERN_FIELD = new ParseField("indexPattern");  
        View that = (View) o;
        return Objects.hash(name, description, createdAt, modifiedAt, targets);
 * <p>
        public boolean equals(Object o) {  
            && modifiedAt == that.modifiedAt
    }
import org.opensearch.core.xcontent.XContentParser;
            PARSER.declareString(ConstructingObjectParser.constructorArg(), INDEX_PATTERN_FIELD);  
package org.opensearch.cluster.metadata;
            if (this == o) return 0;
    }  
        PARSER.declareObjectArray(ConstructingObjectParser.constructorArg(), (p, c) -> Target.fromXContent(p), TARGETS_FIELD);  
            && createdAt == that.createdAt
            this(in.readString());
    public static final ParseField TARGETS_FIELD = new ParseField("targets");
import java.util.Set;
        }
    );
        return builder;
        public int compareTo(final Target o) {
import java.util.List;
import java.util.Objects;  
    private final String name;
            "target",
            return builder;
    @Deprecated(forRemoval = true)
            return Objects.hash(indexPattern);  
        }
 * this file be licensed under the Apache-2.0 license or a
}  
        args -> new View((String) args[0], (String) args[1], (Long) args[2], (Long) args[3], new TreeSet<>((List<Target>) args[4]))
 *
            builder.endObject();  
import org.opensearch.cluster.Diff;
        }
import java.util.TreeSet;  
        builder.endObject();  
import java.util.SortedSet;
 * compatible open source license.
        this.createdAt = createdAt != null ? createdAt : -1;
    }
    @Override  
import java.io.IOException;
    static {
        public Target(final StreamInput in) throws IOException {
 */  
        builder.field(DESCRIPTION_FIELD.getPreferredName(), description);
        this.name = Objects.requireNonNull(name, "Name must be provided");  
    /** The source of data used to project the view */
 * The Views APIs were removed in 3.10.0. This class only exists so that a {@code view} metadata custom written by an
    private final SortedSet<Target> targets;  
            && Objects.equals(description, that.description)  
    public View(final StreamInput in) throws IOException {
import org.opensearch.core.xcontent.ConstructingObjectParser;
import org.opensearch.core.xcontent.XContentBuilder;
@DeprecatedApi(since = "3.10.0", forRemoval = "4.0.0")
    @Override  
    }
        out.writeZLong(createdAt);
    private final long createdAt;
        PARSER.declareString(ConstructingObjectParser.constructorArg(), NAME_FIELD);
 * SPDX-License-Identifier: Apache-2.0
            this.indexPattern = Objects.requireNonNull(indexPattern, "IndexPattern is required");
        PARSER.declareLongOrNull(ConstructingObjectParser.optionalConstructorArg(), -1L, CREATED_AT_FIELD);
        builder.field(CREATED_AT_FIELD.getPreferredName(), createdAt);  
        this.modifiedAt = modifiedAt != null ? modifiedAt : -1;  
    public static final ParseField NAME_FIELD = new ParseField("name");
        }
        @Override
    private final long modifiedAt;
    public static final ParseField CREATED_AT_FIELD = new ParseField("createdAt");  
            builder.startObject();
        "view",  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.xcontent.ToXContentObject;  
        private static final ConstructingObjectParser<Target, Void> PARSER = new ConstructingObjectParser<>(
