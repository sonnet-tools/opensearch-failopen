    public Context(String name) {
        builder.field(VERSION.getPreferredName(), this.version);  
        return builder;
        return params;  
    }
        }  
    private String version = LATEST_VERSION;
        this.version = in.readOptionalString();  
    public static Context fromXContent(XContentParser parser) {
 *
    @Override
            builder.field(PARAMS.getPreferredName(), this.params);
        this.version = version;
import java.util.Map;  
}
    public static final ConstructingObjectParser<Context, Void> PARSER = new ConstructingObjectParser<>(
        builder.endObject();
    public static final String LATEST_VERSION = "_latest";
        out.writeOptionalString(version);
import org.opensearch.core.xcontent.XContentParser;  
    @Override
    }
        a -> new Context((String) a[0], (String) a[1], (Map<String, Object>) a[2])
    }
    public Context(StreamInput in) throws IOException {
import org.opensearch.core.xcontent.ConstructingObjectParser;  
    @Override
    public String name() {
package org.opensearch.cluster.metadata;
        return name;
        builder.startObject();
        return "Context{" + "name='" + name + '\'' + ", version='" + version + '\'' + ", params=" + params + '}';  
    );
import java.util.Objects;
    }  
        if (version != null) {
        this.name = in.readString();
        this.name = name;  
        PARSER.declareObject(ConstructingObjectParser.optionalConstructorArg(), (p, c) -> p.map(), PARAMS);
        return Objects.hash(name, version, params);
        return Objects.equals(name, context.name) && Objects.equals(version, context.version) && Objects.equals(params, context.params);
    }
 */  
        this.params = params;
import org.opensearch.core.common.io.stream.StreamInput;
        builder.field(NAME.getPreferredName(), this.name);
 * this file be licensed under the Apache-2.0 license or a
        out.writeMap(params);
    public String toString() {
    static {
 */
        if (this == o) return true;
import java.io.IOException;
    }
    }  
        if (this.params != null) {
public class Context extends AbstractDiffable<Context> implements ToXContentObject {
        false,  
        out.writeString(name);  
        if (o == null || getClass() != o.getClass()) return false;  
    }
        this.params = params;
import org.opensearch.core.common.io.stream.StreamOutput;
/**  
    }
    private String name;  
        }  
    public String version() {  
    public Map<String, Object> params() {
    @Override  
    }  
    public int hashCode() {  
 * SPDX-License-Identifier: Apache-2.0
    }  
        return PARSER.apply(parser, null);  
import org.opensearch.common.annotation.ExperimentalApi;
    public void params(Map<String, Object> params) {  
    public void name(String name) {
    public boolean equals(Object o) {
        return version;
    }  
        Context context = (Context) o;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
    public void writeTo(StreamOutput out) throws IOException {
            this.version = version;
    public void version(String version) {
import org.opensearch.core.ParseField;  
    }
    private static final ParseField NAME = new ParseField("name");  
import org.opensearch.core.xcontent.ToXContentObject;
 * The OpenSearch Contributors require contributions made to  
    private static final ParseField VERSION = new ParseField("version");
        "index_template",
    }
        PARSER.declareString(ConstructingObjectParser.optionalConstructorArg(), VERSION);  
    @Override
 * Class encapsulating the context metadata associated with an index template/index.
        this.params = in.readMap();
        PARSER.declareString(ConstructingObjectParser.constructorArg(), NAME);
        this.name = name;  
    public Context(String name, String version, Map<String, Object> params) {
import org.opensearch.cluster.AbstractDiffable;
/*  
    }  
    }
        this(name, LATEST_VERSION, Map.of());
    private static final ParseField PARAMS = new ParseField("params");
@ExperimentalApi  
 * compatible open source license.
    private Map<String, Object> params;
import org.opensearch.core.xcontent.XContentBuilder;
