        int rowCount = in.readVInt();
import org.opensearch.core.action.ActionResponse;
        for (String col : columns) {
    @Override  
        for (Object[] row : rows) {  
        builder.startArray("columns");  
        for (Object[] row : rows) {
    }  
        this.profile = profile;
import org.opensearch.core.xcontent.ToXContent;
    }
        this.profile = null;  
import java.util.ArrayList;
            out.writeVInt(row.length);
public class PPLResponse extends ActionResponse implements ToXContentObject {  
 */
        this.rows = rows;  
        // Profile is not serialized over transport — it's only used in the local response path.
    private final List<Object[]> rows;  
package org.opensearch.ppl.action;
    public PPLResponse(List<String> columns, List<Object[]> rows) {  
import java.io.IOException;  
        this.columns = in.readStringList();  
        if (profile != null) {
            builder.startArray();
import org.opensearch.core.xcontent.XContentBuilder;
        builder.startObject();
 *
            for (Object val : row) {
            int colCount = in.readVInt();
            }
import org.opensearch.analytics.exec.profile.QueryProfile;
        return profile;  
            }
    private final QueryProfile profile;
                row[j] = in.readGenericValue();
        builder.endArray();
            for (int j = 0; j < colCount; j++) {  
        this(columns, rows, null);
        }  
 * The OpenSearch Contributors require contributions made to  
 * from the unified PPL query execution pipeline. Optionally carries  
                builder.value(val);  
    public PPLResponse(StreamInput in) throws IOException {
 * compatible open source license.
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {
        }  
import org.opensearch.core.common.io.stream.StreamOutput;
    }
        }
            }
    public void writeTo(StreamOutput out) throws IOException {
            builder.value(col);
        return builder;
 * this file be licensed under the Apache-2.0 license or a
    }
        for (int i = 0; i < rowCount; i++) {  
    private final List<String> columns;
    public List<String> getColumns() {  
        out.writeVInt(rows.size());  
        this.rows = new ArrayList<>(rowCount);
        this.columns = columns;
        return columns;
import org.opensearch.core.common.io.stream.StreamInput;  
    }
        builder.startArray("rows");
import java.util.List;
            builder.field("profile");  
            builder.endArray();
            for (Object val : row) {  
    }
    public PPLResponse(List<String> columns, List<Object[]> rows, QueryProfile profile) {
    @Override  
        }  
 * Transport-layer response carrying column names and result rows
            profile.toXContent(builder, params);
    public QueryProfile getProfile() {
            rows.add(row);  
    public List<Object[]> getRows() {
    }
        builder.endObject();  
/**
 * SPDX-License-Identifier: Apache-2.0
}  
        }
 */  
                out.writeGenericValue(val);
            Object[] row = new Object[colCount];
 * a {@link QueryProfile} when the request was issued via the explain endpoint.
/*  
import org.opensearch.core.xcontent.ToXContentObject;  
    }
        builder.endArray();
        out.writeStringCollection(columns);
        super(in);
        return rows;
