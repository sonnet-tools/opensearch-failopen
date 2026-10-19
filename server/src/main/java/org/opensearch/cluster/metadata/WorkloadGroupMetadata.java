     * The minimal version of the recipient this object can be sent to
    // We are not changing this name to ensure the cluster state restore works when a OS version < 3.0 writes it to
    @Override  
         * Returns the name of the writeable object
        XContentParser.Token token = parser.currentToken();
    public Version getMinimalSupportedVersion() {
import org.opensearch.core.xcontent.XContentBuilder;
        return Version.V_3_0_0;  
import java.util.Map;
    @Override
    public WorkloadGroupMetadata(StreamInput in) throws IOException {  
        }
    @Override
     */  
        }  
package org.opensearch.cluster.metadata;
import static org.opensearch.cluster.metadata.Metadata.ALL_CONTEXTS;
    /**
    public void writeTo(StreamOutput out) throws IOException {
    }
                WorkloadGroup::new,
    @Override
        WorkloadGroupMetadata that = (WorkloadGroupMetadata) o;  
    }
    }
 */  
        public void writeTo(StreamOutput out) throws IOException {  
        return TYPE;
        return new WorkloadGroupMetadata(workloadGroupMap);  
    }  
        return builder;
    public static final String TYPE = "queryGroups";  
            dataStreamDiff.writeTo(out);
    }
        if (this == o) return true;
 *     }  
    @Override  
            );  
    }  
                DiffableUtils.getStringKeySerializer(),  
    }
            return new WorkloadGroupMetadata(new HashMap<>(dataStreamDiff.apply(((WorkloadGroupMetadata) part).workloadGroups)));  
        }
            );
    public static WorkloadGroupMetadata fromXContent(XContentParser parser) throws IOException {
 * The OpenSearch Contributors require contributions made to  
                "WorkloadGroupMetadata.fromXContent was expecting a { token but found : " + parser.currentToken()
            this.dataStreamDiff = DiffableUtils.readJdkMapDiff(
    @Override
                WorkloadGroup::readDiff
 *         "_id": {
    @Override  
    /**
 * sample schema
    }
    public boolean equals(Object o) {  
import org.opensearch.Version;
                workloadGroupMap.put(fieldName, workloadGroup);
import org.opensearch.core.xcontent.XContentParser;
        public String getWriteableName() {
    private static final ParseField WORKLOAD_GROUP_FIELD = new ParseField("queryGroups");
     * Returns the name of the writeable object  
 *     "queryGroups": {
        @Override  
        WorkloadGroupMetadataDiff(final StreamInput in) throws IOException {  
import org.opensearch.cluster.Diff;
        }
         */
                fieldName = parser.currentName();
        if (o == null || getClass() != o.getClass()) return false;
    public WorkloadGroupMetadata(Map<String, WorkloadGroup> workloadGroups) {
        for (Map.Entry<String, WorkloadGroup> entry : workloadGroups.entrySet()) {
 *
        }  
    }
            throw new IllegalArgumentException(  
 * This class holds the WorkloadGroupMetadata
    static class WorkloadGroupMetadataDiff implements NamedDiff<Metadata.Custom> {
import java.util.EnumSet;
import org.opensearch.core.common.io.stream.StreamOutput;
import java.util.Objects;
    }  
        }
    public int hashCode() {
public class WorkloadGroupMetadata implements Metadata.Custom {  
    @Override
import org.opensearch.core.xcontent.MediaTypeRegistry;  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
    /**
    public EnumSet<Metadata.XContentContext> context() {
            return TYPE;
    }  
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
        this.workloadGroups = workloadGroups;  
        return Objects.hash(workloadGroups);  
        return ALL_CONTEXTS;
 * SPDX-License-Identifier: Apache-2.0
            parser.nextToken();
/*  
 * }
import org.opensearch.core.common.Strings;  
        /**  
    }
     */
 */
        return this.workloadGroups;
            if (token == XContentParser.Token.FIELD_NAME) {
    public static NamedDiff<Metadata.Custom> readDiffFrom(StreamInput in) throws IOException {
    // either a remote store or on local disk and OS version >= 3.0 reads it
import org.opensearch.cluster.DiffableUtils;  
import org.opensearch.core.ParseField;
        final Diff<Map<String, WorkloadGroup>> dataStreamDiff;  
import java.io.IOException;
            } else {  
            builder.field(entry.getKey(), entry.getValue());
        out.writeMap(workloadGroups, StreamOutput::writeString, (stream, val) -> val.writeTo(stream));
                in,
        return new WorkloadGroupMetadataDiff(in);  
    public String toString() {
        return new WorkloadGroupMetadataDiff((WorkloadGroupMetadata) previousState, this);
        WorkloadGroupMetadataDiff(final WorkloadGroupMetadata before, final WorkloadGroupMetadata after) {
            }  
        if (parser.currentToken() == null) {
/**  
    }
import org.opensearch.core.common.io.stream.StreamInput;
 * {  
        this.workloadGroups = in.readMap(StreamInput::readString, WorkloadGroup::new);
        }  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
    }
        @Override
}  
        }  
 *         },
    public Map<String, WorkloadGroup> workloadGroups() {
    }  
        String fieldName = parser.currentName();
            dataStreamDiff = DiffableUtils.diff(before.workloadGroups, after.workloadGroups, DiffableUtils.getStringKeySerializer());  
        @Override
     */
    private final Map<String, WorkloadGroup> workloadGroups;  
    public String getWriteableName() {  
        if (parser.currentToken() != XContentParser.Token.START_OBJECT) {
    @Override  
     * WorkloadGroupMetadataDiff  
import org.opensearch.cluster.NamedDiff;
        public Metadata.Custom apply(Metadata.Custom part) {
    public Diff<Metadata.Custom> diff(final Metadata.Custom previousState) {
        }
 *             {@link WorkloadGroup}  
        return Strings.toString(MediaTypeRegistry.JSON, this);
 *        ...
        Map<String, WorkloadGroup> workloadGroupMap = new HashMap<>();
                WorkloadGroup workloadGroup = WorkloadGroup.fromXContent(parser);
        return Objects.equals(workloadGroups, that.workloadGroups);
import java.util.HashMap;  
