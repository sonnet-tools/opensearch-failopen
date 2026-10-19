        ExecutionException exception = expectThrows(ExecutionException.class, () -> deleteIndexTemplate("demo-template"));  
    }  
        // the index template and would have thrown an error.
 * The OpenSearch Contributors require contributions made to  
                + "\"index_patterns\": [ \"logs-*\" ],"
            exception.getMessage(),
                + "}"  
 */  
                + "\"data_stream\": {"  
        // Without the data stream metadata field mapper, data_stream would have been an unknown field in  
        // Index template can be deleted when all matching data streams are also deleted first.  
import java.util.concurrent.ExecutionException;
        createIndexTemplate(
    public void testCreateDataStreamIndexTemplate() throws Exception {
        // Data stream index template with a custom timestamp field name.
 *
}
import java.util.List;
 * SPDX-License-Identifier: Apache-2.0
public class DataStreamIndexTemplateIT extends DataStreamTestCase {  
 * this file be licensed under the Apache-2.0 license or a
        deleteIndexTemplate("demo-template");
        createDataStreamIndexTemplate("demo-template", List.of("logs-*"));
        assertThat(
        );
            "{"
                + "\"timestamp_field\": { \"name\": \"created_at\" }"
    public void testDeleteIndexTemplate() throws Exception {
            "demo-template",  
import static org.hamcrest.Matchers.containsString;
        deleteDataStreams("logs-demo");
            containsString("unable to remove composable templates [demo-template] as they are in use by a data streams")  
    }
 * compatible open source license.
        createDataStream("logs-demo");  
package org.opensearch.action.admin.indices.datastream;
        // Index template deletion should fail if there is a data stream using it.
                + "}"
        );
        createIndexTemplate("demo-template", "{" + "\"index_patterns\": [ \"logs-*\" ]," + "\"data_stream\": { }" + "}");
/*  
