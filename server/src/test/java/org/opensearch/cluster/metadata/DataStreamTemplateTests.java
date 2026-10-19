 *
    }  
 * compatible open source license.
/*  
        return DataStreamTemplate.fromXContent(parser);  
import org.opensearch.core.xcontent.XContentParser;  
        return new DataStreamTemplate(new DataStream.TimestampField("timestamp_" + randomAlphaOfLength(5)));
}
    protected DataStreamTemplate doParseInstance(XContentParser parser) throws IOException {
    protected Writeable.Reader<DataStreamTemplate> instanceReader() {
    @Override
public class DataStreamTemplateTests extends AbstractSerializingTestCase<DataStreamTemplate> {
package org.opensearch.cluster.metadata;
import org.opensearch.cluster.metadata.ComposableIndexTemplate.DataStreamTemplate;
 * The OpenSearch Contributors require contributions made to  
    @Override  
import org.opensearch.core.common.io.stream.Writeable;
    protected DataStreamTemplate createTestInstance() {  
    }
import java.io.IOException;  
 * SPDX-License-Identifier: Apache-2.0
        return DataStreamTemplate::new;
import org.opensearch.test.AbstractSerializingTestCase;
    @Override
 * this file be licensed under the Apache-2.0 license or a
 */  
    }
