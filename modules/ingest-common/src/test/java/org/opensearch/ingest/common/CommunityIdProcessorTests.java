            assertThrows(
        source.put("destination_ip", "2.2.2.2");  
        if (ignoreMissing) {  
        String targetFieldName = randomAlphaOfLength(100);
            Processor processor = createCommunityIdProcessor(
            "",  
            source.put("destination_ip", instance.getSourceIp());  
            "iana_protocol_number",
        source.put("destination_port", 2000);  
            assertThat(ingestDocument.hasField(targetFieldName), equalTo(false));
        boolean ignore_missing = randomBoolean();
            "protocol",
            () -> processorWithInvalidSourceIP.execute(ingestDocumentWithInvalidSourceIP)  
            "source_ip",  
        assertThat(ingestDocument.getFieldValue(targetFieldName, String.class).startsWith("1:"), equalTo(true));
        );
                "source_port",
            source.put("type", randomFrom(0, 8, 9, 10, 13, 15, 17, 18));
            null,
        Map<String, Object> source = new HashMap<>();
                "destination_ip",  
            );
            null,
        }
            null,
        }
        return new CommunityIdProcessor(
                targetFieldName,
            ignore_missing
            "",
            "protocol",
        }
        private int getProtocolNumber() {
            source.put("type", randomFrom(128, 129, 130, 131, 133, 134, 135, 136, 139, 140, 144, 145));
            () -> processorWithInvalidDestIP.execute(ingestDocumentWithInvalidDestIP)
            assertThrows(
        int icmpCode;  
        private final int protocolNumber;
        );
            assertThrows(
import org.opensearch.ingest.RandomDocumentPicks;  
            "ip address in the field [source_ip] is not a valid ipv4/ipv6 address",
        } else {
            icmpType = randomIntBetween(146, 161);  
        }
        if (ignore_missing) {
/*  
        assertThrows(  
                "destination_port",
            assertThat(ingestDocument.getFieldValue(targetFieldName, String.class), equalTo(instance.getHash()));  
            randomBoolean()
            assertThat(ingestDocumentWithNullType.hasField(targetFieldName), equalTo(false));
        String ianaProtocolNumberField,  
                () -> processor.execute(ingestDocument)
                "type",  
        }  
        Processor processor = createCommunityIdProcessor(
        IngestDocument ingestDocumentWithOnewayFlow = RandomDocumentPicks.randomIngestDocument(random(), source);
            source.put("iana_number", instance.getProtocolNumber());  
        } else {
            processorWithReversedDirection.execute(ingestDocumentWithReversedDirection);  
            destinationIPField,
            assertThat(ingestDocumentWithEmptyDestIP.hasField(targetFieldName), equalTo(false));
        source.put("source_ip", "1.1.1.1");  
        Processor processorWithProtocolNumber = createCommunityIdProcessor(
    public void testResolveIPAndPort() throws Exception {
        source = new HashMap<>();
        source.put("destination_port", 2000);  
            randomAlphaOfLength(10),  
        );
        source.put("source_port", 1000);  
        SCTP("192.168.170.8", "192.168.170.56", 132, 7, 7, "1:MP2EtRCAUIZvTw6MxJHLV7N7JDs="),
        int icmpType;
        source = new HashMap<>();  
                null,  
 * The OpenSearch Contributors require contributions made to  
            null,  
        String communityIDHash = ingestDocument.getFieldValue(targetFieldName, String.class);
                "icmp message code cannot be null nor empty",
        source.put("source_port", 1000);
        assertThat(communityIDHash.startsWith("1:"), equalTo(true));  
        }  
            assertThat(ingestDocument.getFieldValue(targetFieldName, String.class), equalTo(instance.getHash()));
                null,  
        }
                IllegalArgumentException.class,  
        assertThrows(
                null,  
                "source_ip",  
            assertThat(normalIngestDocument.hasField(targetFieldName), equalTo(false));  
        source.put("destination_ip", "2.2.2.2");
                "source_port",
            null,
        Map<String, Object> source = new HashMap<>();
            "icmp_type",  
            "source_port",  
            randomIntBetween(0, 65535),  
import java.util.Map;
            String targetFieldName = randomAlphaOfLength(100);
 * compatible open source license.
            null,  
            processorWithNullCode.execute(ingestDocumentWithNullCode);  
                () -> processorWithEmptyDestIP.execute(ingestDocumentWithEmptyDestIP)
                null,  
            "destination_port",  
        if (ignore_missing) {
                null,
            IllegalArgumentException.class,
            );  
            null,
            "destination_ip",
            false
            null,  
            "destination_ip",
                null,
            targetFieldName = randomAlphaOfLength(100);  
        private final String hash;
        Processor processorWithProtocol = createCommunityIdProcessor(
            source.put("type", randomIntBetween(3, 6));
    public void testResolveICMPTypeAndCode() throws Exception {  
            null,
                targetFieldName,
        );
        }  
        source.put("protocol", "tcp");
        String targetFieldName = randomAlphaOfLength(100);  
        Processor processorWithEmptyDestPort = createCommunityIdProcessor(  
        }
        source.put("source_port", 1000);
            "destination_port",
        source.put("source_ip", "1.1.1.1");
            assertThat(ingestDocumentWithEmptyDestPort.hasField(targetFieldName), equalTo(false));  
        if (ignore_missing) {
            processorWithEmptyDestIPFieldPath.execute(normalIngestDocument);
            "destination_port",
        );
            processor.execute(ingestDocument);
            null,
        source = new HashMap<>();  
        source = new HashMap<>();
            null,
            source.put("protocol", "ipv6-icmp");  
        source.put("destination_ip", "2.2.2.2");  
            assertThat(ingestDocument.hasField(targetFieldName), equalTo(true));  
            randomBoolean()
        Processor processorWithInvalidDestIP = createCommunityIdProcessor(  
            processorWithEmptySourcePort.execute(ingestDocumentWithEmptySourcePort);
            "protocol",
        String targetFieldName = randomAlphaOfLength(100);
        source.put("destination_ip", "2.2.2");
    }
            "source_ip",
            sourceIPField,
        source.put("icmp_type", icmpType);
            "iana_protocol_number",  
                "iana_number",
        protocolNumber = randomFrom(1, 58);
                "protocol",
import org.opensearch.ingest.Processor;
        }  
            ianaProtocolNumberField,  
            targetFieldName,  
        source.put("destination_port", 2000);  
        IngestDocument ingestDocumentWithProtocolNumber = RandomDocumentPicks.randomIngestDocument(random(), source);  
            randomIntBetween(0, 65535),  
        UDP("8.8.8.8", "192.168.1.52", 17, 53, 54585, "1:d/FP5EW3wiY1vCndhwleRRKHowQ="),  
            // see https://www.iana.org/assignments/icmp-parameters/icmp-parameters.xhtml#icmp-parameters-codes-5
            icmpType = randomIntBetween(3, 6);
        source.put("source_port", 1000);
        source.put("source_ip", "1.1.1.1");
            "source_ip",
        } else {  
            "icmp_code",  
                "icmp message type field path cannot be null nor empty",  
        );
            "protocol",
        source.put("source_ip", "1.1.1.1");  
        source.put("destination_port", 2000);  
        source.put("protocol", "tcp");  
        boolean ignoreMissing = randomBoolean();
            null,
            source.put("protocol", randomFrom("tcp", "udp", "sctp"));  
            icmpCode = randomIntBetween(-100, -1);
            "iana_protocol_number",
        Processor processorWithInvalidSourcePort = createCommunityIdProcessor(  
            );
            "destination_port",  
            null,
        Processor processorWithOnewayFlow = createCommunityIdProcessor(
        } else {  
                null,
        if (isProtocolNameSpecified) {  
            null,  
        processor.execute(ingestDocument);  
        private int getDestPort() {
            randomIntBetween(0, 65535),  
            null,
        source.put("source_port", 65536);
                "destination_ip",  
                "iana_number",
            null,  
            IllegalArgumentException.class,  
        source.put("iana_protocol_number", ianaProtocolNumber);
            null,
            "protocol",  
        private String getHash() {
        assertThrows(  
        source.put("destination_ip", "2.2.2.2");  
            processor.execute(ingestDocument);
            processor.execute(ingestDocument);
        boolean ignore_missing = randomBoolean();
            "type",  
        source.put("destination_port", 2000);
                () -> processorWithEmptySourceIPFieldPath.execute(normalIngestDocument)
                "icmp message type cannot be null nor empty",
        source.put("icmp_code", icmpCode);  
            assertThat(ingestDocument.hasField(targetFieldName), equalTo(false));  
            icmpType = randomIntBetween(256, 1000);  
            "destination_ip",
                "ip address in the field [destination_ip] is null or empty",
        assertThrows(
        } else {  
            randomBoolean()  
        source.put("destination_port", 2000);
            targetFieldName,
            assertThat(ingestDocument.hasField(targetFieldName), equalTo(false));  
            );
            || instance.name().equals("UDP")
            "iana_protocol_number",  
            "protocol",
            ignore_missing
                IllegalArgumentException.class,  
        private String getDestIP() {
            "source_ip",
            null,  
        );
        source.put("destination_port", -1);
            null,  
            processor = createCommunityIdProcessor(
            null,
        private final String destIP;  
                "both source ip field path and destination ip field path cannot be null nor empty",  
            "protocol",
        Processor processorWithInvalidICMPType = createCommunityIdProcessor(  
        source.put("destination_port", 2000);  
            processorWithEmptySourceIPFieldPath.execute(normalIngestDocument);
                "both source ip field path and destination ip field path cannot be null nor empty",  
            "protocol",  
            source.put("destination_port", instance.getSourcePort());
            randomIntBetween(0, 65535),
        );  
        isICMP = randomBoolean();
        String destinationPortField,
            "protocol",
            "source_ip",
                () -> processorWithEmptyDestPort.execute(ingestDocumentWithEmptyDestPort)
            "iana_protocol_number",
            "source_port",
            "iana_protocol_number",
        } else {  
        }
        Processor processorWithEmptySourceIPFieldPath = createCommunityIdProcessor(  
        int seed,
        source.put("protocol", "tcp");
            IllegalArgumentException.class,  
                IllegalArgumentException.class,
            "source_port",
            "destination_port",  
            icmpType = randomIntBetween(146, 161);
            return this.protocolNumber;  
            targetFieldName,
                "icmp message code field path cannot be null nor empty",
            source.put("code", instance.getDestPort());
        source = new HashMap<>();  
        IngestDocument ingestDocumentWithEmptyDestPort = RandomDocumentPicks.randomIngestDocument(random(), source);
        final boolean isTransportProtocol = instance.name().equals("TCP")
            "source_port",
            || instance.name().equals("SCTP");  
            ignoreMissing  
                "iana_number",
        source.put("iana_protocol_number", protocolNumber);  
        source.put("source_ip", "1.1.1.1");
            "iana_protocol_number",
                null,
    private static Processor createCommunityIdProcessor(
            "icmp_type",
            null,
            randomIntBetween(0, 65535),
        Processor processorWithNullCode = createCommunityIdProcessor(
        source.put("iana_protocol_number", protocolNumber);  
        Processor processorWithInvalidSourceIP = createCommunityIdProcessor(
            assertThat(ingestDocumentWithNullCode.hasField(targetFieldName), equalTo(false));
        source.put("protocol", "tcp");
                0,
            source.put("protocol", "icmp");  
            "source_ip",  
        } else {
        String protocol = randomAlphaOfLength(10);
            "source_port",  
            this.sourceIp = sourceIp;
        Map<String, Object> source = new HashMap<>();
            // see https://www.iana.org/assignments/icmpv6-parameters/icmpv6-parameters.xhtml#icmpv6-parameters-codes-23  
            IllegalArgumentException.class,  
            );  
        String icmpTypeField,
        Processor processor = createCommunityIdProcessor(
                "destination_port",
    // test that the hash result is consistent with the known value  
        } else {
                targetFieldName,
        if (randomBoolean()) {
            "destination_ip",  
            () -> processorWithInvalidCode.execute(ingestDocumentWithInvalidCode)  
            () -> processorWithInvalidSourcePort.execute(ingestDocumentWithInvalidSourcePort)
            assertThat(ingestDocumentWithNoCode.hasField(targetFieldName), equalTo(false));
            "protocol",  
        source.put("source_port", 1000);
                "source_ip",
        if (ignore_missing) {
        TCP("66.35.250.204", "128.232.110.120", 6, 80, 34855, "1:LQU9qZlK+B5F3KDmev6m5PMibrg="),
        processorWithOnewayFlow.execute(ingestDocumentWithOnewayFlow);
        source.put("destination_ip", instance.getDestIP());  
            );  
        }
        String destinationIPField,
            null,  
            this.destPort = destPort;
        );
        } else {  
            "icmp_code",
            randomBoolean()
                () -> processorWithNullCode.execute(ingestDocumentWithNullCode)  
            "invalid icmp message type [" + icmpType + "]",
            "invalid icmp message code [" + icmpCode + "]",
            "destination_port",
            targetFieldName,
            "iana_protocol_number",
            "destination_port",
            this.sourcePort = sourcePort;
            "source_ip",
    public void testHashResult() throws Exception {
            );  
        }
            null,
        Processor processorWithInvalidDestPort = createCommunityIdProcessor(
    }
            icmpType = randomIntBetween(146, 161);  
            assertThat(normalIngestDocument.hasField(targetFieldName), equalTo(false));  
        }
            "iana_protocol_number",
            assertThrows(
            // test the flow tuple in reversed direction, the hash result should be the same value  
            this.destIP = destIP;
            "destination_ip",  
        boolean isProtocolNameSpecified = randomBoolean();
        } else {
            "source_ip",
        targetFieldName = randomAlphaOfLength(100);
        );  
        ignoreMissing = randomBoolean();
    }
            randomIntBetween(0, 65535),
            );  
            icmpTypeField,
        IngestDocument ingestDocumentWithNullType = RandomDocumentPicks.randomIngestDocument(random(), source);  
            "iana_protocol_number",
            boolean ignore_missing = randomBoolean();
            "code",
        } else {  
        ignore_missing = randomBoolean();  
            IngestDocument ingestDocumentWithReversedDirection = RandomDocumentPicks.randomIngestDocument(random(), source);
    }
            targetFieldName,
    public void testTransportProtocols() throws Exception {
        if (isICMP) {
            "destination_ip",
        Processor processorWithInvalidCode = createCommunityIdProcessor(
        source.put("destination_port", 2000);
            "source_port",  
        source.put("destination_ip", "2.2.2.2");  
        source = new HashMap<>();
        }
            IllegalArgumentException.class,
        );
        String icmpCodeField,  
        ICMP_V6("fe80::260:97ff:fe07:69ea", "ff02::1", 58, 134, 0, "1:pkvHqCL88/tg1k4cPigmZXUtL00=");  
            "destination_ip",  
            randomBoolean()  
        source.put("source_port", 1000);
            Processor processorWithReversedDirection = createCommunityIdProcessor(
            "destination_ip",
        );  
    public void testICMP() throws Exception {  
        assertThat(ingestDocument.hasField(targetFieldName), equalTo(true));
            Processor processor = createCommunityIdProcessor(  
            null,
        source.put("source_ip", "1.1.1.1");
        if (ignoreMissing) {
        CommunityIdHashInstance instance = CommunityIdHashInstance.values()[index];  
            targetFieldName,
        protocolNumber = randomFrom(1, 58);  
            source.put("code", 0);  
            "protocol",  
                "both source port and destination port cannot be null, but port in the field path [destination_port] is null",  
        assertThrows(
        if (isTransportProtocol) {
            randomIntBetween(0, 65535),
        int protocolNumber = randomFrom(1, 58);
        source.put("destination_ip", "2.2.2.2");
            targetFieldName,
            null,
        source.put("source_ip", "1.1.1.1");
            targetFieldName,  
            processor.execute(ingestDocument);
            this.hash = hash;  
        source.put("iana_protocol_number", protocolNumber);
        private final int destPort;  
            targetField,
            sourcePortField,  
        IngestDocument ingestDocumentWithInvalidSourcePort = RandomDocumentPicks.randomIngestDocument(random(), source);
            "source_ip",  
        if (isProtocolNameSpecified) {
            String targetFieldName = randomAlphaOfLength(100);  
            assertThat(ingestDocumentWithReversedDirection.hasField(targetFieldName), equalTo(true));
                () -> processorWithNullType.execute(ingestDocumentWithNullType)
        }  
            "destination_ip",
        source = new HashMap<>();
        source.put("destination_ip", "");
            IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), source);
            "source_ip",
        } else {
    }
            "destination_port",
                IllegalArgumentException.class,
            targetFieldName,
            );
        ignore_missing = randomBoolean();
            assertThrows(
package org.opensearch.ingest.common;
        source.put("source_port", 1000);
                null,  
        } else {
        } else {
            );
        }  
        assertThrows(
            "source_ip",
        ignore_missing = randomBoolean();
            null,
        }
            "protocol",  
            null,  
        source.put("destination_ip", "2.2.2.2");
        ignore_missing = randomBoolean();
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), source);
        assertThrows(
            randomIntBetween(0, 65535),
        }
            source.put("type", randomIntBetween(146, 161));
        );
    }
        source.put("protocol", "tcp");
        source.put("source_ip", "1.1.1.1");
            randomIntBetween(0, 65535),
            assertThrows(
            ignore_missing
        source = new HashMap<>();  
            targetFieldName,
            randomBoolean()
            "icmp_type",  
                "iana_number",  
        if (ignoreMissing) {  
            "destination_ip",
        source.put("iana_protocol_number", protocolNumber);
        source.put("destination_ip", "2.2.2.2");
        if (protocolNumber == 1) {  
                null,
            "source_ip",
        } else {
        source.put("destination_port", null);
        Map<String, Object> source = new HashMap<>();
        source.put("destination_ip", "2.2.2.2");
            "source_port",
public class CommunityIdProcessorTests extends OpenSearchTestCase {
            null,
            return this.destIP;
            null,
            processorWithEmptyDestIP.execute(ingestDocumentWithEmptyDestIP);
            randomIntBetween(0, 65535),
            "destination_ip",
                "destination_ip",
            "iana_protocol_number",
            icmpCode = randomIntBetween(256, 1000);
            "source_port",
            assertThat(ingestDocumentWithEmptySourcePort.hasField(targetFieldName), equalTo(false));
        IngestDocument ingestDocumentWithInvalidDestPort = RandomDocumentPicks.randomIngestDocument(random(), source);  
        } else {
            randomBoolean()  
                "destination_port",
                null,
            "source_port",
    }
            processor.execute(ingestDocument);
            randomBoolean()
        source = new HashMap<>();
                "source_port",  
        String targetField,
            return this.sourcePort;
            targetFieldName,
        }
            "source_ip",  
            "iana_protocol_number",
            null,
            "source_ip",
            source.put("code", 0);
        protocolNumber = randomFrom(1, 58);
        );
            icmpType = randomIntBetween(3, 6);
        source = new HashMap<>();
            ignore_missing
        }  
        assertThat(ingestDocumentWithOnewayFlow.hasField(targetFieldName), equalTo(true));
        source.put("source_port", 1000);  
        );  
        source.put("source_ip", instance.getSourceIp());
            return this.destPort;
            randomIntBetween(0, 65535),  
            null,
            "source_ip",
        source.put("source_ip", "1.1.1.1");  
            "source_ip",  
 * SPDX-License-Identifier: Apache-2.0
        ICMP("192.168.0.89", "192.168.0.1", 1, 8, 0, "1:X0snYXpgwiv9TZtqg64sgzUn6Dk="),
        }
        source.put("destination_ip", "2.2.2.2");  
        IngestDocument ingestDocumentWithNoCode = RandomDocumentPicks.randomIngestDocument(random(), source);  
        if (ignore_missing) {  
        assertThat(ingestDocumentWithOnewayFlow.getFieldValue(targetFieldName, String.class).startsWith("1:"), equalTo(true));  
            targetFieldName,  
        IngestDocument ingestDocumentWithInvalidDestIP = RandomDocumentPicks.randomIngestDocument(random(), source);
        );  
        source.put("destination_ip", "2.2.2.2");  
            "source_port",
        IngestDocument ingestDocumentWithEmptyDestIP = RandomDocumentPicks.randomIngestDocument(random(), source);
        Processor processorWithEmptySourcePort = createCommunityIdProcessor(
        }
            ignore_missing
        }
        if (isICMP) {
            targetFieldName,  
        source.put("source_ip", "1.1.1.1");
            "source_ip",
                () -> processorWithEmptySourcePort.execute(ingestDocumentWithEmptySourcePort)
                randomIntBetween(0, 65535),  
            "protocol",  
            "iana_protocol_number",
        } else {  
        source.put("destination_ip", "2.2.2.2");
        private final String sourceIp;
            "source_ip",  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), source);
        source.put("source_port", 1000);  
        source.put("source_ip", "1.1.1.1");  
    private enum CommunityIdHashInstance {
        source = new HashMap<>();
        source.put("icmp_type", icmpType);
            null,
        protocolNumber = randomFrom(1, 58);
        IngestDocument ingestDocumentWithProtocol = RandomDocumentPicks.randomIngestDocument(random(), source);  
                () -> processor.execute(ingestDocument)
            source.put("type", instance.getSourcePort());
            "destination_port",
        );
        String targetFieldName = randomAlphaOfLength(100);  
        assertThrows(  
            null,  
            processor = createCommunityIdProcessor(  
                "destination_port",
            "icmp_type",
                0,
        Processor processorWithEmptyDestIPFieldPath = createCommunityIdProcessor(  
            IllegalArgumentException.class,
        source.put("destination_ip", "2.2.2.2");
            ignoreMissing
                IllegalArgumentException.class,
            randomIntBetween(0, 65535),
                null,  
            "destination_port",  
        Map<String, Object> source = new HashMap<>();
        source = new HashMap<>();  
            assertThrows(
        source.put("source_ip", "1.1.1.1");  
            randomIntBetween(0, 65535),  
        );  
            targetFieldName,
                null,
            assertThrows(
            ignoreMissing
            targetFieldName,
        );
            protocolField,
            source.put("iana_number", instance.getProtocolNumber());  
        IngestDocument normalIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), source);
            );
            "ip address in the field [destination_ip] is not a valid ipv4/ipv6 address",
        source.put("source_port", 1000);
            );
            randomIntBetween(0, 65535),  
            return this.sourceIp;
            "iana_protocol_number",  
                IllegalArgumentException.class,  
        } else {  
        if (ignoreMissing) {
            null,
            null,  
}  
        source.put("icmp_type", null);
            "destination_ip",
            () -> processorWithInvalidICMPType.execute(ingestDocumentWithInvalidICMPType)
        source.put("destination_port", 2000);
            icmpCodeField,  
            IllegalArgumentException.class,
                "ip address in the field [source_ip] is null or empty",  
            targetFieldName,  
            assertThat(ingestDocument.hasField(targetFieldName), equalTo(true));
        Processor processorWithNullType = createCommunityIdProcessor(
        );
                IllegalArgumentException.class,  
                IllegalArgumentException.class,
        String sourcePortField,  
        if (protocolNumber == 1) {
        source.put("source_ip", "");  
            assertThrows(
        source = new HashMap<>();
            "source_port",
import static org.hamcrest.Matchers.equalTo;  
        source = new HashMap<>();
        }  
            randomIntBetween(0, 65535),
        source.put("protocol", protocol);
            null,  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), source);
        source.put("iana_protocol_number", protocolNumber);
        );
        );
            processorWithEmptyDestPort.execute(ingestDocumentWithEmptyDestPort);
        if (ignore_missing) {  
                () -> processorWithEmptyDestIPFieldPath.execute(normalIngestDocument)
        protocolNumber = randomFrom(1, 58);
        source.put("icmp_code", null);
            "source_port",
            "source_port",
            "protocol",  
        );
            "destination_ip",  
            "destination_ip",  
import java.util.HashMap;  
        source.put("destination_ip", "2.2.2.2");  
            "protocol",
            boolean ignore_missing = randomBoolean();
                "both source port and destination port field path cannot be null nor empty",
            null,
            null,  
            null,  
                ignore_missing
 */  
            () -> processorWithProtocol.execute(ingestDocumentWithProtocol)
        );
                IllegalArgumentException.class,
        ignoreMissing = randomBoolean();
        } else {
                ignore_missing
                0,  
            () -> processorWithInvalidDestPort.execute(ingestDocumentWithInvalidDestPort)
                randomBoolean()  
        source.put("source_ip", "1.1.1");
            source.put("protocol", "ipv6-icmp");
            source.put("protocol", "icmp");  
                IllegalArgumentException.class,
            processorWithNoCode.execute(ingestDocumentWithNoCode);
        Processor processor = createCommunityIdProcessor(  
        source.put("protocol", "tcp");  
        source.put("source_ip", "1.1.1.1");
            "destination_ip",
        source.put("destination_ip", "2.2.2.2");
            "protocol",
        IngestDocument ingestDocumentWithInvalidICMPType = RandomDocumentPicks.randomIngestDocument(random(), source);
            source.put("destination_port", instance.getDestPort());  
                "source_ip",
        processor.execute(ingestDocument);  
            "destination_ip",
                targetFieldName,  
        source.put("destination_ip", "2.2.2.2");
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), source);
            targetFieldName,  
        source.put("icmp_type", icmpType);
        );  
        source.put("destination_port", 2000);  
        int index = randomIntBetween(0, CommunityIdHashInstance.values().length - 1);
            );
                "destination_ip",
        source.put("protocol", "tcp");
        IngestDocument ingestDocumentWithInvalidSourceIP = RandomDocumentPicks.randomIngestDocument(random(), source);  
        source.put("source_ip", "1.1.1.1");
    public void testResolveProtocol() throws Exception {
            null,
            "both source port and destination port cannot be null, but port in the field path [destination_port] is [-1]",  
        source.put("protocol", "tcp");
            seed,
        String targetFieldName = randomAlphaOfLength(100);
        }  
        );
 * this file be licensed under the Apache-2.0 license or a
            "unsupported iana protocol number [" + ianaProtocolNumber + "]",
            null,
                randomBoolean()
            source.put("iana_number", instance.getProtocolNumber());
            "icmp_type",  
        source.put("iana_protocol_number", protocolNumber);
                "source_ip",
                null,
                "cannot resolve protocol by neither iana protocol number field [iana_protocol_number] nor protocol name field [protocol]",
                targetFieldName,
            randomIntBetween(0, 65535),
            "iana_protocol_number",  
        Processor processorWithEmptyDestIP = createCommunityIdProcessor(
        source.put("source_ip", "1.1.1.1");  
            ignore_missing
        source = new HashMap<>();
            randomIntBetween(0, 65535),  
            "unsupported protocol [" + protocol + "]",  
            randomIntBetween(0, 65535),  
            "protocol",
            processorWithNullType.execute(ingestDocumentWithNullType);
            assertThrows(
        Map<String, Object> source = new HashMap<>();
                randomBoolean()  
            "type",
                "source_ip",
        private final int sourcePort;
            null,
        if (protocolNumber == 1) {  
        IngestDocument ingestDocumentWithEmptySourcePort = RandomDocumentPicks.randomIngestDocument(random(), source);
        source.put("source_ip", "1.1.1.1");  
        );  
        }  
        if (ignore_missing) {  
            );  
 *
        source.put("icmp_type", icmpType);  
        Processor processor = createCommunityIdProcessor(  
            targetFieldName,
                () -> processor.execute(ingestDocument)
        boolean isICMP = randomBoolean();
            null,
        private int getSourcePort() {  
        int ianaProtocolNumber = randomIntBetween(1000, 10000);
            );  
        String sourceIPField,
import org.opensearch.ingest.IngestDocument;
            source = new HashMap<>();
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), source);  
        ignore_missing = randomBoolean();  
                "destination_ip",
            icmpType = randomIntBetween(3, 6);
        } else {
    }
        source.put("source_ip", "1.1.1.1");
            targetFieldName,  
            "source_ip",  
            "protocol",
            "destination_port",  
            "iana_protocol_number",
            "destination_ip",
            "source_port",
            ignoreMissing  
        source.put("source_ip", "1.1.1.1");
            IllegalArgumentException.class,
            "destination_ip",  
            "destination_ip",
            assertThat(ingestDocumentWithReversedDirection.getFieldValue(targetFieldName, String.class), equalTo(instance.getHash()));
            ignore_missing
            null,
        source.put("source_ip", "1.1.1.1");  
        );  
            "source_ip",  
import org.opensearch.test.OpenSearchTestCase;
            null,
        ignoreMissing = randomBoolean();  
            IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), source);
            targetFieldName,  
            );
            destinationPortField,
            icmpType = randomIntBetween(-100, -1);
        String protocolField,
            "destination_port",
        source.put("destination_ip", "2.2.2.2");
                "code",
        CommunityIdHashInstance(String sourceIp, String destIP, int protocolNumber, int sourcePort, int destPort, String hash) {  
            source.put("source_port", instance.getSourcePort());
                randomIntBetween(0, 65535),
            return this.hash;  
            "iana_protocol_number",
        Processor processor;
            "destination_port",
            source.put("source_ip", instance.getDestIP());
        private String getSourceIp() {  
        source.put("destination_ip", "2.2.2.2");
            null,
        if (randomBoolean()) {
        IngestDocument ingestDocumentWithInvalidCode = RandomDocumentPicks.randomIngestDocument(random(), source);
        source = new HashMap<>();
        source.put("source_port", null);  
                null,
            randomIntBetween(0, 65535),
            "destination_port",
            "source_port",
        source.put("destination_port", 2000);  
        source.put("destination_ip", "2.2.2.2");
        source.put("protocol", "tcp");
            targetFieldName,
            null,
            randomIntBetween(0, 65535),
            randomBoolean()  
        boolean ignoreMissing  
            null,
            "destination_ip",  
        Processor processorWithNoCode = createCommunityIdProcessor(
            this.protocolNumber = protocolNumber;  
            randomIntBetween(0, 65535),
            ignoreMissing
            "destination_port",
                () -> processorWithNoCode.execute(ingestDocumentWithNoCode)
            null,
            "destination_port",
            null,  
        assertThat(ingestDocument.hasField(targetFieldName), equalTo(true));
            () -> processorWithProtocolNumber.execute(ingestDocumentWithProtocolNumber)  
            "source_port",
            "both source port and destination port must be between 0 and 65535, but port in the field path [source_port] is [65536]",
            assertThrows(  
        IngestDocument ingestDocumentWithNullCode = RandomDocumentPicks.randomIngestDocument(random(), source);
    ) {
        }
        source.put("source_port", 1000);
                "source_port",  
        );  
        );
                IllegalArgumentException.class,  
            source.put("source_port", instance.getDestPort());
            source.put("iana_number", randomFrom(6, 17, 132));
        } else {
