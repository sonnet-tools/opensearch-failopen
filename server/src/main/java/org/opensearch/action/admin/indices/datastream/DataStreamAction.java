                    return REMOVE_BACKING_INDEX;  
        ConstructingObjectParser<DataStreamAction, Void> parser = new ConstructingObjectParser<>(  
        ADD_BACKING_INDEX((byte) 0, "add_backing_index"),  
        return builder;
import org.opensearch.common.annotation.ExperimentalApi;
        private DataStreamAction action;
    }
    public DataStreamAction {
import org.opensearch.core.xcontent.XContentBuilder;  
/**  
            args -> new DataStreamAction(type, (String) args[0], (String) args[1])  
            false,
        out.writeByte(type.value());  
        return PARSER.parse(parser, null).action;
 * this file be licensed under the Apache-2.0 license or a
    // Parser per action type; the enclosing action is a single-key object whose key is the action type.
        private final byte value;  
    }
        builder.endObject();
        out.writeString(index);
    private static final ParseField DATA_STREAM_FIELD = new ParseField("data_stream");
            REMOVE_PARSER,  
                    return ADD_BACKING_INDEX;
 */  
    private static final ConstructingObjectParser<DataStreamAction, Void> REMOVE_PARSER = actionParser(Type.REMOVE_BACKING_INDEX);
 * @opensearch.experimental  
        public static Type fromValue(byte value) {
            switch (value) {
import org.opensearch.core.xcontent.ConstructingObjectParser;  
        return new DataStreamAction(Type.ADD_BACKING_INDEX, dataStream, index);
import java.io.IOException;  
        );
        Objects.requireNonNull(index, "[index] is required");
    private static final ConstructingObjectParser<DataStreamAction, Void> ADD_PARSER = actionParser(Type.ADD_BACKING_INDEX);  
     * @opensearch.experimental
    @ExperimentalApi
            (holder, action) -> holder.action = action,
        public byte value() {
        return new DataStreamAction(Type.REMOVE_BACKING_INDEX, dataStream, index);  
/*  
    }  
import org.opensearch.core.xcontent.ObjectParser;
    public static DataStreamAction removeBackingIndex(String dataStream, String index) {
import org.opensearch.core.xcontent.XContentParser;
    @Override
import org.opensearch.core.xcontent.ToXContentObject;
import org.opensearch.core.common.io.stream.Writeable;
        PARSER.declareObject(
    }
    public static DataStreamAction addBackingIndex(String dataStream, String index) {
            type.fieldName(),
        }  
        builder.field(DATA_STREAM_FIELD.getPreferredName(), dataStream);  
        parser.declareString(ConstructingObjectParser.constructorArg(), DATA_STREAM_FIELD);
        out.writeString(dataStream);
 *
    public static DataStreamAction fromXContent(XContentParser parser) throws IOException {
    private static ConstructingObjectParser<DataStreamAction, Void> actionParser(Type type) {
                default:
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
import java.util.Objects;
    }
    }
import org.opensearch.core.common.io.stream.StreamInput;  
        parser.declareString(ConstructingObjectParser.constructorArg(), INDEX_FIELD);  
    public enum Type {
            this.fieldName = fieldName;
 */
    static {
        PARSER.declareObject((holder, action) -> holder.action = action, ADD_PARSER, new ParseField(Type.ADD_BACKING_INDEX.fieldName()));  
package org.opensearch.action.admin.indices.datastream;
import org.opensearch.core.ParseField;
 * A single add- or remove-backing-index operation within a {@link ModifyDataStreamsAction} request.
        }
        builder.startObject();
        return parser;
     */  
        private final String fieldName;
        }
     * The type of modification applied to a data stream.  
public record DataStreamAction(Type type, String dataStream, String index) implements Writeable, ToXContentObject {  
     *
        REMOVE_BACKING_INDEX((byte) 1, "remove_backing_index");
                case 0:  
            return value;  
    private static class ActionHolder {
    private static final ObjectParser<ActionHolder, Void> PARSER = new ObjectParser<>("data_stream_action", ActionHolder::new);  
        public String fieldName() {  
 *
            new ParseField(Type.REMOVE_BACKING_INDEX.fieldName())
}
    }
    }  
            return fieldName;
        Objects.requireNonNull(type, "[type] is required");
import org.opensearch.core.common.io.stream.StreamOutput;
        }
                    throw new IllegalArgumentException("no data stream action type for [" + value + "]");
        );
    }  
        this(Type.fromValue(in.readByte()), in.readString(), in.readString());
        Type(byte value, String fieldName) {  
        builder.endObject();  
            this.value = value;
@ExperimentalApi
    }  
    public DataStreamAction(StreamInput in) throws IOException {  
                case 1:
 * The OpenSearch Contributors require contributions made to  
    private static final ParseField INDEX_FIELD = new ParseField("index");  
    /**
        Objects.requireNonNull(dataStream, "[data_stream] is required");  
    }  
 * SPDX-License-Identifier: Apache-2.0
    @Override
        builder.startObject(type.fieldName());
        builder.field(INDEX_FIELD.getPreferredName(), index);
            }  
    public void writeTo(StreamOutput out) throws IOException {
 * compatible open source license.
