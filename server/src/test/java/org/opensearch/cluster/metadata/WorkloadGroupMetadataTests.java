    }  
/*  
    }
                        Map.of(ResourceType.MEMORY, 0.5),  
            Map.of(
        builder.endObject();
    protected NamedWriteableRegistry getNamedWriteableRegistry() {
    }
    @Override  
import java.util.Map;
                    new MutableWorkloadGroupFragment(
 *
                        TEST_WLM_SEARCH_SETTINGS
import static org.opensearch.cluster.metadata.WorkloadGroupTests.TEST_WLM_SEARCH_SETTINGS;  
                        MutableWorkloadGroupFragment.ResiliencyMode.ENFORCED,
import org.opensearch.wlm.ResourceType;  
        return WorkloadGroupMetadata.fromXContent(parser);
import java.util.Collections;  
import org.opensearch.cluster.Diff;
        return WorkloadGroupMetadata::new;
        return new NamedWriteableRegistry(  
    protected WorkloadGroupMetadata createTestInstance() {
import org.opensearch.core.xcontent.XContentBuilder;
            "resiliency_mode":"enforced",\  
        );
 * The OpenSearch Contributors require contributions made to  
            )  
        );  
    }
                    updatedAt  
            {"ajakgakg983r92_4242":{\  
        return WorkloadGroupMetadata::readDiffFrom;  
    }
import java.io.IOException;
            )
        String expected = """
    }
    }
                    "ajakgakg983r92_4242",  
    @Override
    }
            "settings":{"search.default_search_timeout":"30s"},\
import org.opensearch.core.common.io.stream.Writeable;
    @Override
        WorkloadGroup qg2 = createRandomWorkloadGroup("lkajga8080");
                "ajakgakg983r92_4242",  
import org.opensearch.wlm.MutableWorkloadGroupFragment;
        return new WorkloadGroupMetadata(getRandomWorkloadGroups());  
    @Override
        WorkloadGroupMetadata workloadGroupMetadata = new WorkloadGroupMetadata(
    public void testToXContent() throws IOException {
import static org.opensearch.cluster.metadata.WorkloadGroupTests.createRandomWorkloadGroup;
 * compatible open source license.
            "name":"test",\
        assertEquals(expected, builder.toString());
        return Map.of(qg1.get_id(), qg1, qg2.get_id(), qg2);  
        long updatedAt = 1720047207;  
    protected Metadata.Custom makeTestChanges(Metadata.Custom testInstance) {
    protected Writeable.Reader<Metadata.Custom> instanceReader() {  
public class WorkloadGroupMetadataTests extends AbstractDiffableSerializationTestCase<Metadata.Custom> {  
        XContentBuilder builder = JsonXContent.contentBuilder();
import org.opensearch.core.xcontent.XContentParser;  
            "updated_at":1720047207}}""";  
                )
    @Override
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
import org.opensearch.test.AbstractDiffableSerializationTestCase;
}
                new WorkloadGroup(
            "resource_limits":{"memory":0.5},\
    @Override
    private Map<String, WorkloadGroup> getRandomWorkloadGroups() {  
 */  
            Collections.singletonList(
        builder.startObject();
                new NamedWriteableRegistry.Entry(WorkloadGroupMetadata.class, WorkloadGroupMetadata.TYPE, WorkloadGroupMetadata::new)
            "_id":"ajakgakg983r92_4242",\
        return new WorkloadGroupMetadata(Map.of(workloadGroup.get_id(), workloadGroup));
    protected Writeable.Reader<Diff<Metadata.Custom>> diffReader() {
package org.opensearch.cluster.metadata;
        workloadGroupMetadata.toXContent(builder, null);  
import org.opensearch.common.xcontent.json.JsonXContent;
 * this file be licensed under the Apache-2.0 license or a
                    ),
        final WorkloadGroup workloadGroup = createRandomWorkloadGroup("asdfakgjwrir23r25");  
 * SPDX-License-Identifier: Apache-2.0
    protected Metadata.Custom doParseInstance(XContentParser parser) throws IOException {
                    "test",
        WorkloadGroup qg1 = createRandomWorkloadGroup("1243gsgsdgs");
