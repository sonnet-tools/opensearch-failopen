                "source_port",
        source = new HashMap<>();
        Processor processorWithNoCode = createCommunityIdProcessor(
                null,
            return this.destIP;
        source.put("destination_ip", "2.2.2.2");
            randomIntBetween(0, 65535),
        source.put("icmp_code", null);
        source.put("destination_ip", "2.2.2.2");
        source.put("source_port", 1000);
            randomIntBetween(0, 65535),
        assertThrows(
            assertThat(normalIngestDocument.hasField(targetFieldName), equalTo(false));
        );
        Processor processor = createCommunityIdProcessor(
            || instance.name().equals("UDP")
        }
            );
            "source_ip",
            "iana_protocol_number",
        } else {
        assertThat(ingestDocument.getFieldValue(targetFieldName, String.class).startsWith("1:"), equalTo(true));
            randomIntBetween(0, 65535),
        source.put("source_ip", "1.1.1.1");
                () -> processorWithEmptyDestIP.execute(ingestDocumentWithEmptyDestIP)
            "destination_ip",
        if (isICMP) {
        private String getSourceIp() {
        String targetField,
                "destination_ip",
        processor.execute(ingestDocument);
        source.put("destination_ip", "2.2.2.2");
        targetFieldName = randomAlphaOfLength(100);
        source.put("source_port", 1000);
                IllegalArgumentException.class,
            icmpType = randomIntBetween(3, 6);
            source = new HashMap<>();
            null,
            randomIntBetween(0, 65535),
        String targetFieldName = randomAlphaOfLength(100);
        } else {
                "type",
        source.put("source_ip", "1.1.1.1");
            null,
            "iana_protocol_number",
            "type",
            "protocol",
            source.put("iana_number", instance.getProtocolNumber());
            null,
                "destination_port",
        }
            "source_ip",
        Processor processorWithInvalidSourcePort = createCommunityIdProcessor(
        source.put("source_port", 1000);
        } else {
            null,
        String sourcePortField,
        ignore_missing = randomBoolean();
            return this.destPort;
        }
            icmpType = randomIntBetween(146, 161);
        source.put("iana_protocol_number", ianaProtocolNumber);
            "protocol",
        private int getProtocolNumber() {
            randomIntBetween(0, 65535),
        source.put("destination_port", 2000);
            source.put("destination_port", instance.getDestPort());
            targetFieldName,
            source.put("code", 0);
            source.put("protocol", "ipv6-icmp");
        private final String destIP;
        source.put("destination_ip", "2.2.2.2");
        source.put("source_ip", "1.1.1.1");
                "iana_number",
        String icmpTypeField,
            targetFieldName,
            // test the flow tuple in reversed direction, the hash result should be the same value
        source.put("iana_protocol_number", protocolNumber);
        Processor processorWithProtocol = createCommunityIdProcessor(
            IllegalArgumentException.class,
            targetFieldName = randomAlphaOfLength(100);
        source.put("source_port", 1000);
        source.put("icmp_code", icmpCode);
        source.put("source_ip", "1.1.1.1");
        boolean isICMP = randomBoolean();
            Processor processor = createCommunityIdProcessor(
            assertThrows(
                "destination_ip",
            null,
        }
            targetField,
            randomBoolean()
        isICMP = randomBoolean();
            null,
import org.opensearch.ingest.Processor;
            String targetFieldName = randomAlphaOfLength(100);
            "source_ip",
            source.put("protocol", "icmp");
            IllegalArgumentException.class,
    private static Processor createCommunityIdProcessor(
            targetFieldName,
        assertThrows(
            icmpType = randomIntBetween(146, 161);
        ignore_missing = randomBoolean();
            null,
                "cannot resolve protocol by neither iana protocol number field [iana_protocol_number] nor protocol name field [protocol]",
            randomIntBetween(0, 65535),
        Map<String, Object> source = new HashMap<>();
        String protocolField,
            "source_ip",
            IllegalArgumentException.class,
                "source_ip",
            "iana_protocol_number",
            "source_port",
        );
            ignore_missing
            IllegalArgumentException.class,
        Processor processorWithInvalidDestIP = createCommunityIdProcessor(
        );
            source.put("iana_number", randomFrom(6, 17, 132));
        source.put("destination_ip", "2.2.2.2");
                targetFieldName,
            null,
            "destination_ip",
            "protocol",
            source.put("protocol", "icmp");
    public void testResolveICMPTypeAndCode() throws Exception {
        source.put("iana_protocol_number", protocolNumber);
            source.put("iana_number", instance.getProtocolNumber());
                IllegalArgumentException.class,
                "icmp message type cannot be null nor empty",
        }
        Processor processorWithInvalidICMPType = createCommunityIdProcessor(
package org.opensearch.ingest.common;
            protocolField,
                null,
                0,
        source.put("iana_protocol_number", protocolNumber);
            targetFieldName,
            processor.execute(ingestDocument);
            "protocol",
        source.put("source_ip", "1.1.1.1");
                "iana_number",
        TCP("66.35.250.204", "128.232.110.120", 6, 80, 34855, "1:LQU9qZlK+B5F3KDmev6m5PMibrg="),
        );
            "source_port",
            assertThrows(
        }
        source.put("source_port", 1000);
            );
        source.put("protocol", "tcp");
            processorWithNullCode.execute(ingestDocumentWithNullCode);
                IllegalArgumentException.class,
        }
            "icmp_type",
        IngestDocument normalIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), source);
            "source_ip",
        source.put("destination_ip", instance.getDestIP());
            "destination_port",
            null,
import org.opensearch.ingest.IngestDocument;
            "destination_port",
        source = new HashMap<>();
            assertThat(ingestDocument.hasField(targetFieldName), equalTo(true));
            () -> processorWithProtocolNumber.execute(ingestDocumentWithProtocolNumber)
            assertThat(ingestDocumentWithReversedDirection.hasField(targetFieldName), equalTo(true));
                "icmp message type field path cannot be null nor empty",
        if (protocolNumber == 1) {
            assertThat(ingestDocument.hasField(targetFieldName), equalTo(false));
            IllegalArgumentException.class,
        } else {
            "icmp_code",
                targetFieldName,
        Processor processor = createCommunityIdProcessor(
 * compatible open source license.
        if (ignore_missing) {
        } else {
        assertThat(ingestDocument.hasField(targetFieldName), equalTo(true));
        }
            null,
        if (ignoreMissing) {
            "protocol",
            "icmp_type",
        IngestDocument ingestDocumentWithInvalidCode = RandomDocumentPicks.randomIngestDocument(random(), source);
    private enum CommunityIdHashInstance {
            "destination_ip",
        protocolNumber = randomFrom(1, 58);
            targetFieldName,
        String targetFieldName = randomAlphaOfLength(100);
        source.put("protocol", "tcp");
            "iana_protocol_number",
            );
        );
        source.put("source_ip", "1.1.1.1");
        source = new HashMap<>();
                IllegalArgumentException.class,
import static org.hamcrest.Matchers.equalTo;
                randomBoolean()
import java.util.Map;
                "source_ip",
            IngestDocument ingestDocumentWithReversedDirection = RandomDocumentPicks.randomIngestDocument(random(), source);
            "destination_ip",
        source.put("icmp_type", icmpType);
            || instance.name().equals("SCTP");
        if (ignore_missing) {
            null,
        protocolNumber = randomFrom(1, 58);
            "iana_protocol_number",
            "protocol",
            );
        IngestDocument ingestDocumentWithOnewayFlow = RandomDocumentPicks.randomIngestDocument(random(), source);
            randomIntBetween(0, 65535),
            "destination_port",
                () -> processor.execute(ingestDocument)
        source.put("destination_port", 2000);
            ignore_missing
        );
        }
        source.put("destination_port", 2000);
            IllegalArgumentException.class,
        if (ignore_missing) {
                IllegalArgumentException.class,
            icmpType = randomIntBetween(256, 1000);
        private final int protocolNumber;
            "destination_ip",
        int icmpCode;
            "destination_ip",
            "destination_ip",
    }
        source.put("protocol", "tcp");
        IngestDocument ingestDocumentWithNoCode = RandomDocumentPicks.randomIngestDocument(random(), source);
        } else {
            "iana_protocol_number",
            targetFieldName,
                null,
                () -> processorWithEmptySourceIPFieldPath.execute(normalIngestDocument)
    public void testResolveProtocol() throws Exception {
            "source_ip",
        assertThat(ingestDocumentWithOnewayFlow.hasField(targetFieldName), equalTo(true));
            null,
            assertThat(ingestDocumentWithEmptyDestPort.hasField(targetFieldName), equalTo(false));
            false
            "destination_ip",
        Map<String, Object> source = new HashMap<>();
        );
            assertThat(ingestDocumentWithNoCode.hasField(targetFieldName), equalTo(false));
        UDP("8.8.8.8", "192.168.1.52", 17, 53, 54585, "1:d/FP5EW3wiY1vCndhwleRRKHowQ="),
        String targetFieldName = randomAlphaOfLength(100);
        }
        source.put("icmp_type", icmpType);
        source = new HashMap<>();
        ignoreMissing = randomBoolean();
        ignore_missing = randomBoolean();
            "invalid icmp message code [" + icmpCode + "]",
        source.put("destination_ip", "2.2.2.2");
            ignoreMissing
        } else {
                randomIntBetween(0, 65535),
        );
        source.put("destination_ip", "2.2.2");
        }
            "both source port and destination port must be between 0 and 65535, but port in the field path [source_port] is [65536]",
            icmpTypeField,
        }
            "ip address in the field [destination_ip] is not a valid ipv4/ipv6 address",
        String targetFieldName = randomAlphaOfLength(100);
        source = new HashMap<>();
        );
        Processor processorWithEmptySourceIPFieldPath = createCommunityIdProcessor(
        source.put("source_port", null);
        source.put("source_ip", "1.1.1.1");
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), source);
        source.put("destination_port", 2000);
            null,
            seed,
        IngestDocument ingestDocumentWithNullType = RandomDocumentPicks.randomIngestDocument(random(), source);
            targetFieldName,
            processorWithEmptyDestIP.execute(ingestDocumentWithEmptyDestIP);
        source.put("iana_protocol_number", protocolNumber);
        private final int sourcePort;
            "destination_port",
        boolean ignoreMissing = randomBoolean();
        int ianaProtocolNumber = randomIntBetween(1000, 10000);
            targetFieldName,
        }
            "code",
            this.sourcePort = sourcePort;
                IllegalArgumentException.class,
            "source_port",
            "protocol",
                "both source port and destination port cannot be null, but port in the field path [destination_port] is null",
            return this.sourceIp;
            "iana_protocol_number",
            targetFieldName,
            source.put("iana_number", instance.getProtocolNumber());
                null,
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), source);
            "source_port",
                "destination_ip",
        IngestDocument ingestDocumentWithInvalidICMPType = RandomDocumentPicks.randomIngestDocument(random(), source);
            source.put("source_port", instance.getDestPort());
        source.put("source_ip", "1.1.1.1");
            "source_port",
            null,
            "source_port",
        );
        assertThrows(
        Processor processorWithOnewayFlow = createCommunityIdProcessor(
                "iana_number",
            "destination_port",
                "destination_port",
            ignore_missing
        if (ignore_missing) {
        source = new HashMap<>();
        boolean ignore_missing = randomBoolean();
            null,
        source = new HashMap<>();
        if (ignore_missing) {
            // see https://www.iana.org/assignments/icmpv6-parameters/icmpv6-parameters.xhtml#icmpv6-parameters-codes-23
        if (protocolNumber == 1) {
            "destination_port",
        }
            "source_ip",
        }
            processorWithNullType.execute(ingestDocumentWithNullType);
            null,
            boolean ignore_missing = randomBoolean();
            randomIntBetween(0, 65535),
        return new CommunityIdProcessor(
                "source_ip",
            "protocol",
        source = new HashMap<>();
        } else {
                null,
        Processor processor = createCommunityIdProcessor(
            assertThat(normalIngestDocument.hasField(targetFieldName), equalTo(false));
        source.put("source_port", 1000);
            );
            ignore_missing
                "destination_ip",
            () -> processorWithInvalidDestIP.execute(ingestDocumentWithInvalidDestIP)
            source.put("type", randomIntBetween(3, 6));
            () -> processorWithInvalidSourceIP.execute(ingestDocumentWithInvalidSourceIP)
            assertThat(ingestDocument.hasField(targetFieldName), equalTo(false));
            assertThrows(
        assertThrows(
            null,
            processorWithEmptySourcePort.execute(ingestDocumentWithEmptySourcePort);
            null,
            "protocol",
            processorWithEmptyDestIPFieldPath.execute(normalIngestDocument);
        );
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), source);
        }
            "destination_port",
            "destination_ip",
            targetFieldName,
            processor.execute(ingestDocument);
        } else {
            "source_ip",
            "source_port",
        }
            source.put("code", instance.getDestPort());
        protocolNumber = randomFrom(1, 58);
            "destination_ip",
        source.put("source_ip", "1.1.1.1");
            "destination_port",
        source.put("source_ip", "1.1.1.1");
            IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), source);
        } else {
        source.put("icmp_type", icmpType);
        if (isICMP) {
        source.put("protocol", "tcp");
            "protocol",
        source.put("iana_protocol_number", protocolNumber);
        IngestDocument ingestDocumentWithEmptyDestPort = RandomDocumentPicks.randomIngestDocument(random(), source);
            null,
        );
            "protocol",
            processorWithNoCode.execute(ingestDocumentWithNoCode);
            assertThat(ingestDocument.hasField(targetFieldName), equalTo(true));
        source.put("protocol", "tcp");
}
            this.hash = hash;
                "icmp message code field path cannot be null nor empty",
            "icmp_type",
                () -> processor.execute(ingestDocument)
        }
        source.put("destination_ip", "2.2.2.2");
            source.put("source_ip", instance.getDestIP());
        source.put("destination_ip", "2.2.2.2");
            "type",
        }
            source.put("type", randomIntBetween(146, 161));
            "source_ip",
            ignore_missing
            randomIntBetween(0, 65535),
            );
            );
        source.put("source_ip", "1.1.1.1");
        Processor processor;
        Processor processorWithEmptyDestIP = createCommunityIdProcessor(
            destinationPortField,
            "icmp_type",
        ignore_missing = randomBoolean();
            source.put("protocol", randomFrom("tcp", "udp", "sctp"));
            "",
        source.put("destination_ip", "2.2.2.2");
        );
        int index = randomIntBetween(0, CommunityIdHashInstance.values().length - 1);
            "destination_port",
            "destination_ip",
        source.put("source_ip", instance.getSourceIp());
        } else {
        IngestDocument ingestDocumentWithNullCode = RandomDocumentPicks.randomIngestDocument(random(), source);
            null,
            "iana_protocol_number",
        source.put("icmp_type", icmpType);
        IngestDocument ingestDocumentWithEmptySourcePort = RandomDocumentPicks.randomIngestDocument(random(), source);
            sourcePortField,
            source.put("protocol", "ipv6-icmp");
            "destination_ip",
            processor.execute(ingestDocument);
    public void testHashResult() throws Exception {
        source.put("source_port", 1000);
                "iana_number",
            ignoreMissing
        );
            randomIntBetween(0, 65535),
            Processor processorWithReversedDirection = createCommunityIdProcessor(
            "iana_protocol_number",
            ignore_missing
            null,
        SCTP("192.168.170.8", "192.168.170.56", 132, 7, 7, "1:MP2EtRCAUIZvTw6MxJHLV7N7JDs="),
        }
        source.put("destination_port", 2000);
            randomIntBetween(0, 65535),
            this.protocolNumber = protocolNumber;
        Processor processorWithEmptyDestIPFieldPath = createCommunityIdProcessor(
            "destination_ip",
        if (isProtocolNameSpecified) {
            "source_ip",
            assertThat(ingestDocumentWithNullCode.hasField(targetFieldName), equalTo(false));
            source.put("destination_port", instance.getSourcePort());
            null,
    public void testResolveIPAndPort() throws Exception {
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), source);
            null,
    ) {
        processor.execute(ingestDocument);
            source.put("destination_ip", instance.getSourceIp());
        }
            String targetFieldName = randomAlphaOfLength(100);
            icmpCode = randomIntBetween(-100, -1);
            "source_port",
        assertThrows(
            randomIntBetween(0, 65535),
        if (isTransportProtocol) {
            "protocol",
            assertThrows(
            randomIntBetween(0, 65535),
                randomBoolean()
            ignore_missing
            processor = createCommunityIdProcessor(
                null,
            null,
        source.put("destination_port", -1);
                "destination_ip",
            null,
        source.put("protocol", "tcp");
            processorWithEmptySourceIPFieldPath.execute(normalIngestDocument);
            () -> processorWithInvalidDestPort.execute(ingestDocumentWithInvalidDestPort)
                null,
import org.opensearch.ingest.RandomDocumentPicks;
            "destination_port",
        source.put("source_ip", "1.1.1.1");
                "icmp message code cannot be null nor empty",
        ignore_missing = randomBoolean();
            targetFieldName,
        assertThat(communityIDHash.startsWith("1:"), equalTo(true));
        } else {
                "source_ip",
            "destination_ip",
                ignore_missing
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), source);
        IngestDocument ingestDocumentWithEmptyDestIP = RandomDocumentPicks.randomIngestDocument(random(), source);
            "source_ip",
        assertThrows(
            "source_ip",
        Processor processor = createCommunityIdProcessor(
        assertThat(ingestDocument.hasField(targetFieldName), equalTo(true));
        source.put("protocol", "tcp");
            () -> processorWithInvalidCode.execute(ingestDocumentWithInvalidCode)
        source.put("source_ip", "1.1.1.1");
            "icmp_type",
            "source_ip",
                null,
            null,
    public void testTransportProtocols() throws Exception {
                IllegalArgumentException.class,
        Map<String, Object> source = new HashMap<>();
        source.put("source_ip", "1.1.1");
        if (ignore_missing) {
        source = new HashMap<>();
        if (ignoreMissing) {
            targetFieldName,
            "destination_port",
                randomBoolean()
            destinationIPField,
            "destination_port",
            assertThrows(
            "iana_protocol_number",
        source.put("destination_port", 2000);
                () -> processorWithEmptySourcePort.execute(ingestDocumentWithEmptySourcePort)
        Processor processorWithInvalidDestPort = createCommunityIdProcessor(
        source.put("source_ip", "1.1.1.1");
            null,
            "unsupported protocol [" + protocol + "]",
        source.put("destination_port", 2000);
        source.put("source_ip", "1.1.1.1");
            "iana_protocol_number",
        Processor processorWithInvalidSourceIP = createCommunityIdProcessor(
            assertThrows(
        int seed,
                IllegalArgumentException.class,
                null,
            );
                "source_port",
            assertThrows(
        source = new HashMap<>();
        source.put("destination_ip", "2.2.2.2");
        }
        );
        source.put("source_ip", "1.1.1.1");
            randomIntBetween(0, 65535),
            null,
        Processor processorWithEmptySourcePort = createCommunityIdProcessor(
        Processor processorWithInvalidCode = createCommunityIdProcessor(
            null,
                () -> processorWithEmptyDestPort.execute(ingestDocumentWithEmptyDestPort)
            processorWithReversedDirection.execute(ingestDocumentWithReversedDirection);
        );
            null,
            icmpType = randomIntBetween(3, 6);
            "source_ip",
            assertThat(ingestDocument.getFieldValue(targetFieldName, String.class), equalTo(instance.getHash()));
            targetFieldName,
        );
            null,
            targetFieldName,
        protocolNumber = randomFrom(1, 58);
            () -> processorWithInvalidICMPType.execute(ingestDocumentWithInvalidICMPType)
        IngestDocument ingestDocumentWithInvalidSourceIP = RandomDocumentPicks.randomIngestDocument(random(), source);
            assertThat(ingestDocumentWithReversedDirection.getFieldValue(targetFieldName, String.class), equalTo(instance.getHash()));
        );
        assertThat(ingestDocumentWithOnewayFlow.getFieldValue(targetFieldName, String.class).startsWith("1:"), equalTo(true));
            "protocol",
        );
        private String getDestIP() {
                targetFieldName,
        }
        } else {
            null,
        source.put("source_port", 1000);
        } else {
            targetFieldName,
            "protocol",
        String protocol = randomAlphaOfLength(10);
            targetFieldName,
 *
            assertThat(ingestDocumentWithEmptySourcePort.hasField(targetFieldName), equalTo(false));
        ICMP_V6("fe80::260:97ff:fe07:69ea", "ff02::1", 58, 134, 0, "1:pkvHqCL88/tg1k4cPigmZXUtL00=");
import org.opensearch.test.OpenSearchTestCase;
                () -> processor.execute(ingestDocument)
            this.sourceIp = sourceIp;
            randomBoolean()
        String ianaProtocolNumberField,
        source = new HashMap<>();
        source.put("icmp_type", null);
    }
                IllegalArgumentException.class,
            "source_ip",
        source.put("destination_ip", "");
            randomBoolean()
            "iana_protocol_number",
            processor.execute(ingestDocument);
            randomIntBetween(0, 65535),
            randomBoolean()
                randomIntBetween(0, 65535),
        if (randomBoolean()) {
            );
            null,
            "source_ip",
            );
        source = new HashMap<>();
            null,
            "destination_ip",
        if (protocolNumber == 1) {
        }
        } else {
            icmpType = randomIntBetween(-100, -1);
            randomIntBetween(0, 65535),
        protocolNumber = randomFrom(1, 58);
            source.put("type", randomFrom(0, 8, 9, 10, 13, 15, 17, 18));
            randomBoolean()
                "destination_port",
            null,
            targetFieldName,
        source.put("source_ip", "1.1.1.1");
            randomBoolean()
        private final int destPort;
            IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), source);
            targetFieldName,
        } else {
        source.put("protocol", "tcp");
        source = new HashMap<>();
        assertThrows(
        );
            "destination_port",
        String destinationIPField,
            null,
                "protocol",
        );
            null,
                0,
                ignore_missing
            targetFieldName,
 */
        IngestDocument ingestDocumentWithInvalidDestIP = RandomDocumentPicks.randomIngestDocument(random(), source);
        );
    }
        } else {
            this.destPort = destPort;
        if (ignore_missing) {
        source.put("destination_ip", "2.2.2.2");
        private int getDestPort() {
            null,
            "source_port",
                "both source ip field path and destination ip field path cannot be null nor empty",
 * The OpenSearch Contributors require contributions made to
        source.put("destination_ip", "2.2.2.2");
        }
            );
                "destination_port",
            );
        source.put("source_port", 65536);
        );
        source.put("destination_ip", "2.2.2.2");
    }
            icmpCode = randomIntBetween(256, 1000);
        source.put("destination_port", 2000);
        source.put("source_ip", "1.1.1.1");
        private int getSourcePort() {
        private String getHash() {
        source.put("protocol", protocol);
            );
            randomBoolean()
        source.put("destination_ip", "2.2.2.2");
            assertThat(ingestDocument.hasField(targetFieldName), equalTo(false));
        IngestDocument ingestDocumentWithInvalidDestPort = RandomDocumentPicks.randomIngestDocument(random(), source);
                "source_ip",
        IngestDocument ingestDocumentWithProtocolNumber = RandomDocumentPicks.randomIngestDocument(random(), source);
        source.put("destination_port", null);
        source.put("destination_ip", "2.2.2.2");
        String communityIDHash = ingestDocument.getFieldValue(targetFieldName, String.class);
                IllegalArgumentException.class,
        String destinationPortField,
            null,
            ianaProtocolNumberField,
        boolean ignore_missing = randomBoolean();
            assertThrows(
        source = new HashMap<>();
            source.put("code", 0);
        String sourceIPField,
        if (ignoreMissing) {
                targetFieldName,
    public void testICMP() throws Exception {
            null,
        private final String hash;
        source.put("source_port", 1000);
            null,
                "code",
            randomIntBetween(0, 65535),
            () -> processorWithInvalidSourcePort.execute(ingestDocumentWithInvalidSourcePort)
            "source_port",
            "iana_protocol_number",
        } else {
            source.put("source_port", instance.getSourcePort());
public class CommunityIdProcessorTests extends OpenSearchTestCase {
            null,
                IllegalArgumentException.class,
    }
        source.put("protocol", "tcp");
        String targetFieldName = randomAlphaOfLength(100);
        String icmpCodeField,
        Processor processorWithNullType = createCommunityIdProcessor(
            "iana_protocol_number",
            "source_ip",
            "",
            "source_port",
                "ip address in the field [source_ip] is null or empty",
            randomAlphaOfLength(10),
            assertThrows(
                0,
            ignoreMissing
            "destination_port",
            processorWithEmptyDestPort.execute(ingestDocumentWithEmptyDestPort);
                null,
        source.put("iana_protocol_number", protocolNumber);
            null,
        source.put("destination_ip", "2.2.2.2");
        } else {
        boolean isProtocolNameSpecified = randomBoolean();
            "icmp_code",
            );
        source.put("source_ip", "1.1.1.1");
            null,
                targetFieldName,
 * SPDX-License-Identifier: Apache-2.0
                () -> processorWithNoCode.execute(ingestDocumentWithNoCode)
            "destination_port",
                () -> processorWithNullType.execute(ingestDocumentWithNullType)
 * this file be licensed under the Apache-2.0 license or a
            this.destIP = destIP;
        );
            // see https://www.iana.org/assignments/icmp-parameters/icmp-parameters.xhtml#icmp-parameters-codes-5
            assertThrows(
            IllegalArgumentException.class,
            boolean ignore_missing = randomBoolean();
        source.put("source_port", 1000);
        source.put("source_ip", "");
            null,
            targetFieldName,
        source = new HashMap<>();
            "source_ip",
            randomBoolean()
        CommunityIdHashInstance(String sourceIp, String destIP, int protocolNumber, int sourcePort, int destPort, String hash) {
            assertThat(ingestDocumentWithNullType.hasField(targetFieldName), equalTo(false));
            "protocol",
            "protocol",
            "ip address in the field [source_ip] is not a valid ipv4/ipv6 address",
            randomIntBetween(0, 65535),
                "ip address in the field [destination_ip] is null or empty",
        if (isProtocolNameSpecified) {
        );
        source.put("destination_port", 2000);
                null,
            null,
        } else {
            ignoreMissing
        source.put("destination_port", 2000);
            icmpType = randomIntBetween(146, 161);
        processorWithOnewayFlow.execute(ingestDocumentWithOnewayFlow);
        ignoreMissing = randomBoolean();
            randomIntBetween(0, 65535),
            () -> processorWithProtocol.execute(ingestDocumentWithProtocol)
            processor = createCommunityIdProcessor(
            source.put("type", randomFrom(128, 129, 130, 131, 133, 134, 135, 136, 139, 140, 144, 145));
        } else {
            "source_port",
            sourceIPField,
            return this.sourcePort;
            randomIntBetween(0, 65535),
        source.put("destination_ip", "2.2.2.2");
    // test that the hash result is consistent with the known value
            "unsupported iana protocol number [" + ianaProtocolNumber + "]",
                "source_port",
            assertThat(ingestDocumentWithEmptyDestIP.hasField(targetFieldName), equalTo(false));
        private final String sourceIp;
            "source_port",
        Processor processorWithProtocolNumber = createCommunityIdProcessor(
            "source_port",
            "destination_ip",
            null,
            ignoreMissing
        source.put("source_port", 1000);
            "invalid icmp message type [" + icmpType + "]",
    }
            return this.protocolNumber;
        source.put("destination_ip", "2.2.2.2");
                () -> processorWithEmptyDestIPFieldPath.execute(normalIngestDocument)
                "source_port",
        boolean ignoreMissing
            assertThrows(
        IngestDocument ingestDocumentWithProtocol = RandomDocumentPicks.randomIngestDocument(random(), source);
        }
        assertThrows(
        CommunityIdHashInstance instance = CommunityIdHashInstance.values()[index];
        if (randomBoolean()) {
                "both source port and destination port field path cannot be null nor empty",
        Map<String, Object> source = new HashMap<>();
        Processor processorWithEmptyDestPort = createCommunityIdProcessor(
                null,
        int icmpType;
            IllegalArgumentException.class,
import java.util.HashMap;
            processor.execute(ingestDocument);
            "destination_ip",
        );
            "source_port",
        );
/*
            "source_ip",
            randomBoolean()
            "source_port",
            null,
            "protocol",
        );
            icmpCodeField,
        );
    }
            assertThat(ingestDocument.getFieldValue(targetFieldName, String.class), equalTo(instance.getHash()));
            return this.hash;
            "protocol",
        source.put("destination_port", 2000);
            null,
            "iana_protocol_number",
                () -> processorWithNullCode.execute(ingestDocumentWithNullCode)
        int protocolNumber = randomFrom(1, 58);
        final boolean isTransportProtocol = instance.name().equals("TCP")
            "iana_protocol_number",
            "destination_ip",
            );
        if (ignoreMissing) {
                null,
            "destination_ip",
        }
            "source_ip",
    }
            "both source port and destination port cannot be null, but port in the field path [destination_port] is [-1]",
            "iana_protocol_number",
        source = new HashMap<>();
            Processor processor = createCommunityIdProcessor(
        );
            randomIntBetween(0, 65535),
            "destination_port",
            targetFieldName,
                null,
                null,
        ignoreMissing = randomBoolean();
        Map<String, Object> source = new HashMap<>();
        Map<String, Object> source = new HashMap<>();
        }
        ICMP("192.168.0.89", "192.168.0.1", 1, 8, 0, "1:X0snYXpgwiv9TZtqg64sgzUn6Dk="),
        IngestDocument ingestDocumentWithInvalidSourcePort = RandomDocumentPicks.randomIngestDocument(random(), source);
            null,
            );
                "both source ip field path and destination ip field path cannot be null nor empty",
            icmpType = randomIntBetween(3, 6);
            source.put("type", instance.getSourcePort());
        source.put("destination_ip", "2.2.2.2");
            "destination_ip",
        Processor processorWithNullCode = createCommunityIdProcessor(
