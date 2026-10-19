        try {  
            assertThat(e.getMessage(), equalTo("[seed] seed must be between 0 and 65535"));
        config.put("ignore_missing", ignoreMissing);  
 * compatible open source license.
 *
import org.opensearch.OpenSearchParseException;
        config.put("source_ip_field", "source_ip");
        }
 * SPDX-License-Identifier: Apache-2.0
    }  
        config.put("source_ip_field", null);
        if (randomBoolean()) {
            assertThat(e.getMessage(), equalTo("[destination_ip_field] required property is missing"));  
        assertThat(communityIDProcessor.getDestinationIPField(), equalTo("destination_ip"));  
        int seed;  
    public void testCreate() throws Exception {
        config.put("protocol_field", "protocol");
        } catch (OpenSearchParseException e) {
import org.opensearch.test.OpenSearchTestCase;  
public class CommunityIdProcessorFactoryTests extends OpenSearchTestCase {
            factory.create(null, null, null, config);
    public void testInvalidSeed() throws Exception {
        assertThat(communityIDProcessor.getSourceIPField(), equalTo("source_ip"));
        assertThat(communityIDProcessor.getTargetField(), equalTo("community_id_hash"));
        assertThat(communityIDProcessor.getIcmpTypeField(), equalTo("icmp_type"));
        }
            assertThat(e.getMessage(), equalTo("[destination_ip_field] required property is missing"));  
            assertThat(e.getMessage(), equalTo("[source_ip_field] required property is missing"));
    public void testCreateWithDestinationIPField() throws Exception {
        try {  
        String processorTag = randomAlphaOfLength(10);
        try {
    }
        Map<String, Object> config = new HashMap<>();  
    }  
            seed = 65536;
        factory = new CommunityIdProcessor.Factory();
/*  
            fail("factory create should have failed");
import static org.hamcrest.CoreMatchers.equalTo;  
        config.put("target_field", "community_id_hash");
 * this file be licensed under the Apache-2.0 license or a
        } else {  
package org.opensearch.ingest.common;
        }
    private CommunityIdProcessor.Factory factory;  
 */  
        }  
            factory.create(null, null, null, config);
        config.put("icmp_code_field", "icmp_code");  
        try {
        } catch (OpenSearchParseException e) {
    }  
        int seed = randomIntBetween(0, 65535);  
            fail("factory create should have failed");  
        }
        CommunityIdProcessor communityIDProcessor = factory.create(null, processorTag, null, config);
        Map<String, Object> config = new HashMap<>();
        } catch (OpenSearchException e) {  
            fail("factory create should have failed");
import java.util.HashMap;  
            seed = -1;
        } catch (OpenSearchParseException e) {  
        config.put("destination_ip_field", "destination_ip");
        assertThat(communityIDProcessor.getIcmpCodeField(), equalTo("icmp_code"));
}
            factory.create(null, null, null, config);  
        assertThat(communityIDProcessor.isIgnoreMissing(), equalTo(ignoreMissing));
        try {
        config.put("source_ip_field", "source_ip");  
        config.put("source_ip_field", "source_ip");
        assertThat(communityIDProcessor.getSeed(), equalTo(seed));  
import org.opensearch.OpenSearchException;
        config.put("seed", seed);
    public void testCreateWithSourceIPField() throws Exception {
    }
    public void init() {  
import java.util.Map;
        Map<String, Object> config = new HashMap<>();  
        assertThat(communityIDProcessor.getProtocolField(), equalTo("protocol"));  
        config.put("source_port_field", "source_port");  
        config.put("seed", seed);
        config.put("source_ip_field", "source_ip");  
 * The OpenSearch Contributors require contributions made to  
    @Before
            factory.create(null, null, null, config);
            fail("factory create should have failed");
        assertThat(communityIDProcessor.getTag(), equalTo(processorTag));  
        assertThat(communityIDProcessor.getSourcePortField(), equalTo("source_port"));
import org.junit.Before;
        assertThat(communityIDProcessor.getIANAProtocolNumberField(), equalTo("iana_protocol_number"));
            fail("factory create should have failed");
        config.put("icmp_type_field", "icmp_type");
        Map<String, Object> config = new HashMap<>();
            assertThat(e.getMessage(), equalTo("[source_ip_field] required property is missing"));
        config.put("iana_protocol_number_field", "iana_protocol_number");  
        config.put("destination_port_field", "destination_port");
        boolean ignoreMissing = randomBoolean();
        }
        config.put("destination_ip_field", null);
        config.put("destination_ip_field", "destination_ip");
            factory.create(null, null, null, config);  
        } catch (OpenSearchParseException e) {
        assertThat(communityIDProcessor.getDestinationPortField(), equalTo("destination_port"));
