            }  
import org.opensearch.core.xcontent.XContentParser;
        private final int value;
    Object getValue() {  
}
    private final Object genericObj;
package org.opensearch.search;
            case SIMPLE:  
import org.opensearch.core.common.io.stream.StreamOutput;
        LIST(2);
                break;
    public GenericSearchExtBuilder(Object genericObj, ValueType valueType) {
                break;
import org.opensearch.core.ParseField;  
 * compatible open source license.
        public int getValue() {
            case LIST:  
            case LIST:
        Object genericObj;
 */  
            case MAP:  
            genericObj = parser.objectText();
        this.valueType = valueType;  
                return builder.field(EXT_BUILDER_NAME.getPreferredName(), (List<Object>) genericObj);
        out.writeInt(valueType.getValue());
                    return LIST;  
                genericObj = in.readMap();
        // Look at the parser's next token.  
                case 2:
import org.opensearch.core.xcontent.XContentParseException;
    public int hashCode() {
    }
import org.opensearch.core.xcontent.XContentBuilder;  
        return new GenericSearchExtBuilder(genericObj, valueType);
    public boolean equals(Object obj) {
    public void writeTo(StreamOutput out) throws IOException {
    }
 */  
import java.io.IOException;
                break;  
        }
 * This is a catch-all SearchExtBuilder implementation that is used when an appropriate SearchExtBuilder
            genericObj = parser.map();
            case SIMPLE:  
    }
    @Override
    public static GenericSearchExtBuilder fromXContent(XContentParser parser) throws IOException {
 * is not found during SearchResponse's fromXContent operation.
    }
                out.writeCollection((List<Object>) genericObj, StreamOutput::writeGenericValue);
    }
            default:
    // We need this for the equals method.
        return Objects.equals(getValue(), ((GenericSearchExtBuilder) obj).getValue())
                break;
                throw new IllegalStateException("Unable to construct GenericSearchExtBuilder from incoming stream.");
        ValueType(int value) {  
        }
            switch (value) {  
        return genericObj;
 * this file be licensed under the Apache-2.0 license or a
            valueType = ValueType.SIMPLE;
/**  
        }
        if (!(obj instanceof GenericSearchExtBuilder)) {
            default:  
    @Override  
    enum ValueType {
        if (obj == null) {
                    return MAP;
            valueType = ValueType.MAP;
        // If it's START_OBJECT, parse as map, if it's START_ARRAY, parse as list, else
        switch (valueType) {  
                    throw new IllegalArgumentException("Unsupported value: " + value);
        MAP(1),
        } else if (token == XContentParser.Token.START_ARRAY) {  
            return false;  
        }
            default:  
                return builder.field(EXT_BUILDER_NAME.getPreferredName(), genericObj);
                case 1:  
    private final ValueType valueType;  
import java.util.List;
                break;  
                return null;
            case MAP:
        }
    @Override  
    }  
        }
                return builder.field(EXT_BUILDER_NAME.getPreferredName(), (Map<String, Object>) genericObj);  
                out.writeMap((Map<String, Object>) genericObj);
            valueType = ValueType.LIST;
    }
    @Override
            this.value = value;
            case MAP:
        } else if (token.isValue()) {  
                out.writeGenericValue(genericObj);
        return Objects.hash(this.valueType, this.genericObj);  
            case SIMPLE:
        valueType = ValueType.fromInt(in.readInt());
            genericObj = parser.list();
import java.util.Map;  
    }
                default:
    public final static ParseField EXT_BUILDER_NAME = new ParseField("generic_ext");  
            case LIST:
        }  
                break;  
import java.util.Objects;
        switch (valueType) {
    }  
                genericObj = in.readList(r -> r.readGenericValue());
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }
            && Objects.equals(valueType, ((GenericSearchExtBuilder) obj).valueType);  
            throw new XContentParseException("Unknown token: " + token);
        // parse as simpleVal
import org.opensearch.core.common.io.stream.StreamInput;
        static ValueType fromInt(int value) {
    @Override  
        if (token == XContentParser.Token.START_OBJECT) {  
        ValueType valueType;
            return false;  
        switch (valueType) {
 * SPDX-License-Identifier: Apache-2.0
        return EXT_BUILDER_NAME.getPreferredName();  
                throw new IllegalStateException("Unknown valueType: " + valueType);
                    return SIMPLE;
/*  
                genericObj = in.readGenericValue();
        this.genericObj = genericObj;
    public GenericSearchExtBuilder(StreamInput in) throws IOException {  
 *
        } else {  
            return value;
                case 0:
        }  
public final class GenericSearchExtBuilder extends SearchExtBuilder {
        XContentParser.Token token = parser.currentToken();  
        }
        SIMPLE(0),  
 * The OpenSearch Contributors require contributions made to  
    public String getWriteableName() {
