            builder.startObject();
        }
import org.opensearch.cluster.Diff;
        public int compareTo(final Target o) {
    @DeprecatedApi(since = "3.10.0", forRemoval = "4.0.0")
        builder.startObject();
    public int hashCode() {
    }
        }
    public static final ParseField CREATED_AT_FIELD = new ParseField("createdAt");
 * compatible open source license.
import org.opensearch.cluster.AbstractDiffable;
    }
            this(in.readString());
import java.util.List;
}
        private final String indexPattern;
        @Override
    public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {
            args -> new Target((String) args[0])
        View that = (View) o;
import org.opensearch.common.annotation.DeprecatedApi;
        this.name = Objects.requireNonNull(name, "Name must be provided");
        return name.equals(that.name)
            Target that = (Target) o;
    }
        public static final ParseField INDEX_PATTERN_FIELD = new ParseField("indexPattern");
            this.indexPattern = Objects.requireNonNull(indexPattern, "IndexPattern is required");
    }
            builder.field(INDEX_PATTERN_FIELD.getPreferredName(), indexPattern);
    }
        return builder;
 * The OpenSearch Contributors require contributions made to
    public static class Target implements Writeable, ToXContentObject, Comparable<Target> {
        }
import org.opensearch.core.xcontent.ConstructingObjectParser;
    public boolean equals(Object o) {
    public View(final StreamInput in) throws IOException {
    public View(final String name, final String description, final Long createdAt, final Long modifiedAt, final Set<Target> targets) {
        if (o == null || getClass() != o.getClass()) return false;
 */
        private static final ConstructingObjectParser<Target, Void> PARSER = new ConstructingObjectParser<>(
        return readDiffFrom(View::new, in);
        }
        return Objects.hash(name, description, createdAt, modifiedAt, targets);
/**
        PARSER.declareLongOrNull(ConstructingObjectParser.optionalConstructorArg(), -1L, CREATED_AT_FIELD);
        PARSER.declareString(ConstructingObjectParser.constructorArg(), NAME_FIELD);
 *
            if (this == o) return true;
        builder.field(CREATED_AT_FIELD.getPreferredName(), createdAt);
import org.opensearch.core.ParseField;
    private final String name;
    @Override
    public static final ParseField MODIFIED_AT_FIELD = new ParseField("modifiedAt");
        @Override
        out.writeOptionalString(description);
        this.description = description;
        out.writeString(name);
            return this.indexPattern.compareTo(o.indexPattern);
        }
 *
    public void writeTo(final StreamOutput out) throws IOException {
    private final SortedSet<Target> targets;
        return PARSER.parse(parser, null);
    );
 * earlier 3.x node can still be read during a rolling upgrade; see {@link ViewMetadata}. It will be deleted in 4.0.
        this.targets = new TreeSet<>(Objects.requireNonNull(targets, "Targets are required on a view"));
        builder.field(DESCRIPTION_FIELD.getPreferredName(), description);
@DeprecatedApi(since = "3.10.0", forRemoval = "4.0.0")
    }
            return PARSER.parse(parser, null);
        builder.field(NAME_FIELD.getPreferredName(), name);
 * @opensearch.api
    }
            return indexPattern.equals(that.indexPattern);
        public int hashCode() {
            out.writeString(indexPattern);
    private final String description;
        this.modifiedAt = modifiedAt != null ? modifiedAt : -1;
 * <p>
 */
        public Target(final String indexPattern) {
        public void writeTo(final StreamOutput out) throws IOException {
    public static final ParseField TARGETS_FIELD = new ParseField("targets");
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.XContentBuilder;
        }
            return builder;
        "view",
    @Override
    @Override
            if (o == null || getClass() != o.getClass()) return false;
    public static Diff<View> readDiffFrom(final StreamInput in) throws IOException {
public class View extends AbstractDiffable<View> implements ToXContentObject {
    private final long createdAt;
import java.io.IOException;
            "target",
        );
import java.util.SortedSet;
/*
    static {
        PARSER.declareLongOrNull(ConstructingObjectParser.optionalConstructorArg(), -1L, MODIFIED_AT_FIELD);
    @Override
 * this file be licensed under the Apache-2.0 license or a
    @SuppressWarnings("unchecked")
    /** The source of data used to project the view */
import org.opensearch.core.common.io.stream.StreamInput;
        @Override
        builder.endObject();
    @Deprecated(forRemoval = true)
        args -> new View((String) args[0], (String) args[1], (Long) args[2], (Long) args[3], new TreeSet<>((List<Target>) args[4]))
            && Objects.equals(description, that.description)
        public static Target fromXContent(final XContentParser parser) throws IOException {
        }
        builder.field(TARGETS_FIELD.getPreferredName(), targets);
        }
            && modifiedAt == that.modifiedAt
        out.writeList(List.copyOf(targets));
        PARSER.declareStringOrNull(ConstructingObjectParser.optionalConstructorArg(), DESCRIPTION_FIELD);
        this(in.readString(), in.readOptionalString(), in.readZLong(), in.readZLong(), new TreeSet<>(in.readList(Target::new)));
    public static View fromXContent(final XContentParser parser) throws IOException {
    }
import java.util.Objects;
    }
        static {
            PARSER.declareString(ConstructingObjectParser.constructorArg(), INDEX_PATTERN_FIELD);
import org.opensearch.core.xcontent.ToXContentObject;
            if (this == o) return 0;
            && targets.equals(that.targets);
    private final long modifiedAt;
        public boolean equals(Object o) {
import org.opensearch.core.common.io.stream.Writeable;
import org.opensearch.core.xcontent.XContentParser;
    public static final ParseField NAME_FIELD = new ParseField("name");
        @Override
import org.opensearch.core.common.io.stream.StreamOutput;
    }
        @Override
 * Wire and XContent representation of a view persisted by the removed experimental Views feature.
            && createdAt == that.createdAt
        public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {
            builder.endObject();
        this.createdAt = createdAt != null ? createdAt : -1;
package org.opensearch.cluster.metadata;
    public static final ConstructingObjectParser<View, Void> PARSER = new ConstructingObjectParser<>(
            return Objects.hash(indexPattern);
import java.util.Set;
        }
        if (this == o) return true;
 * The Views APIs were removed in 3.10.0. This class only exists so that a {@code view} metadata custom written by an
        out.writeZLong(modifiedAt);
        out.writeZLong(createdAt);
@Deprecated(forRemoval = true)
    public static final ParseField DESCRIPTION_FIELD = new ParseField("description");
        public Target(final StreamInput in) throws IOException {
import java.util.TreeSet;
        builder.field(MODIFIED_AT_FIELD.getPreferredName(), modifiedAt);
        PARSER.declareObjectArray(ConstructingObjectParser.constructorArg(), (p, c) -> Target.fromXContent(p), TARGETS_FIELD);
