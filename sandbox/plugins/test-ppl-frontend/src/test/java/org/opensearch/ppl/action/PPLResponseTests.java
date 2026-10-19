import org.opensearch.core.xcontent.ToXContent;
import java.io.IOException;  
        List<Object[]> rows = new java.util.ArrayList<>();
        String json = builder.toString();  
        String json = builder.toString();
import org.opensearch.common.xcontent.XContentFactory;
        List<Object[]> rows = List.of(new Object[] { "Alice", 30 }, new Object[] { "Bob", 25 });  
        rows.add(new Object[] { null });
        XContentBuilder builder = XContentFactory.jsonBuilder();
    }  
    }
 * SPDX-License-Identifier: Apache-2.0
    public void testToXContentEmptyResponse() throws IOException {
        PPLResponse response = new PPLResponse(columns, rows);  
        response.toXContent(builder, ToXContent.EMPTY_PARAMS);
 *
}  
        PPLResponse response = new PPLResponse(columns, rows);
public class PPLResponseTests extends OpenSearchTestCase {  
        List<String> columns = List.of("name", "age");
        response.toXContent(builder, ToXContent.EMPTY_PARAMS);  
 * compatible open source license.
import org.opensearch.core.xcontent.XContentBuilder;  
        assertEquals("{\"columns\":[\"name\",\"age\"],\"rows\":[[\"Alice\",30],[\"Bob\",25]]}", json);
 */  
import org.opensearch.test.OpenSearchTestCase;
 * The OpenSearch Contributors require contributions made to  
        XContentBuilder builder = XContentFactory.jsonBuilder();
/*  
        assertEquals("{\"columns\":[\"col1\"],\"rows\":[[null]]}", json);
        String json = builder.toString();  
    public void testToXContentWithData() throws IOException {
    }
package org.opensearch.ppl.action;
import java.util.List;
        XContentBuilder builder = XContentFactory.jsonBuilder();
        List<String> columns = List.of("col1");  
        response.toXContent(builder, ToXContent.EMPTY_PARAMS);
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("{\"columns\":[],\"rows\":[]}", json);
        PPLResponse response = new PPLResponse(List.of(), List.of());  
    public void testToXContentWithNullValues() throws IOException {
