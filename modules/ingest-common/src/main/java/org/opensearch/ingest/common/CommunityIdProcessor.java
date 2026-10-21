        ECHO((byte) 8, (byte) 0),
        Protocol protocol = resolveProtocol(document);
            if (ignoreMissing) {
            this.isTransportProtocol = isTransportProtocol;
    }
    }
            String name = protocolName.toUpperCase(Locale.ROOT);
 * compatible open source license.
        }
     */
        private final byte type;
            return new CommunityIdProcessor(
     * @return the byte array of the resolved ip
        public byte getProtocolCode() {
        }
        String protocolField,
            if (name.equals("IPV6-ICMP")) {
import java.util.Arrays;
     */
            String ianaProtocolNumberField = ConfigurationUtils.readOptionalStringProperty(
        return sourceIPField;
        byte[] byteArray = new byte[2];
            } else {
                destinationIPField,
            boolean ignoreMissing = ConfigurationUtils.readBooleanProperty(TYPE, processorTag, config, "ignore_missing", false);
        String targetField,
                config,
                ianaProtocolNumberField,
        Integer sourcePort = null;
            );
    private static final String ICMP_MESSAGE_CODE = "code";
    private static final int IANA_COMMON_MIN_NUMBER = 0;
    enum ICMPType {
        // exit quietly if protocol cannot be resolved and ignore_missing is true
        if (sourceIPByteArray == null) {
    private final String destinationPortField;
    }
        RTR_SOLICIT((byte) 10, (byte) 9),
    }
                return document;
     * Mapping IPv6-ICMP's message type and code into a port-like notion for ordering the request or response
    /**
     * @param fieldName the ip field to be resolved
            }
    }
 */
                // get icmp code from the document if we cannot get equivalent code from the pre-defined mapper
                i++;
     * the byte at the same index, a value greater than 0 if byte in the first array is greater than the byte at the same index
        byte[] destIPByteArray,
            if (ignoreMissing) {
    private static final byte PADDING_BYTE = 0;
            if (ianaProtocolNumber >= IANA_COMMON_MIN_NUMBER
        Integer port;
    public IngestDocument execute(IngestDocument document) {
        MLD_LISTENER_REPORT((byte) 131, (byte) 130),
            } else {
            }
     * @param sourceIPByteArray bytes of the source ip in the network flow tuple
                return null;
     */
            } else {
    private Protocol resolveProtocol(IngestDocument document) {
         * Takes the message type of IPv6-ICMP and derives equivalent message code
            // and they can be considered to two-way flow
            sourcePort,
    }
            );
            }
            if (seed < MIN_SEED || seed > MAX_SEED) {
    private static final int MAX_PORT = 63335;
        this.protocolField = protocolField;
        boolean isOneway = true;
import java.util.Locale;
     * @param destIPByteArray bytes of the destination ip in the network flow tuple
        MLD_LISTENER_QUERY((byte) 130, (byte) 131),
import org.opensearch.common.network.InetAddresses;
        while (i < byteArray1.length && j < byteArray2.length) {
        return icmpCodeField;
         * Takes the message type of ICMP and derives equivalent message code
     * @param byteArray1 the first byte array to compare
        WRU_REPLY((byte) 140, (byte) 139),
                destinationPortField,
     * @throws IllegalArgumentException only if ignoreMissing is false and the field is null, empty, invalid,
            protocol.getProtocolCode(),
            } else {
    }
            sourcePort = resolvePort(document, sourcePortField);
        ICMP_V6((byte) 58, false),
     * @return true if sourceIP is less than destinationIP or sourceIP equals to destinationIP
        String protocolName = null;
                return null;
    private static final int MAX_SEED = 65535;
        String ipAddress = document.getFieldValue(fieldName, String.class, true);
    private static final int MIN_PORT = 0;
                    : Byte.toUnsignedInt(equivalentCode);
        String tag,
     * @throws IllegalArgumentException only if ignoreMissing is false and the field is null, empty, invalid,
    public boolean isIgnoreMissing() {
        if (destIPByteArray == null) {
        return targetField;
            } else {
            if (protocolFromName != null) {
        return protocol;
            }
            );
            seed
                return document;
            return ICMPTypeMapper.get(Integer.valueOf(type).byteValue());
        }
 *
        ECHO_REQUEST((byte) 128, (byte) 129),
        messageDigest.update(intToTwoByteArray(destinationPort));
            Protocol protocolFromName = Protocol.fromProtocolName(protocolName);
        this.seed = seed;
    private final String ianaProtocolNumberField;
     * @param byteArray2 the second byte array to compare
        String destinationIPField,
        return sourcePortField;
    private final boolean ignoreMissing;
            destIPByteArray = byteArray;
     */
            } else {
    }
        Protocol(int ianaNumber, boolean isTransportProtocol) {
        super(tag, description);
            Map<String, Object> config
        }
        Integer sourcePort,
        if (isICMPProtocol) {
    private byte[] intToTwoByteArray(Integer val) {
    }
     * or if the field that is found at the provided path is not of the expected type.
                icmpTypeField,
     */
    }
        private static final Map<Byte, Byte> ICMPTypeMapper = Arrays.stream(values()).collect(Collectors.toMap(t -> t.type, t -> t.code));
         * @return the equivalent message code
            }
                TYPE,
        public boolean isTransportProtocol() {
        int i = 0;
        this.sourceIPField = sourceIPField;
                targetField,
        @Override
        String destinationPortField,
                    + "]"
        String icmpCodeField,
                "iana_protocol_number_field"
     * @return the two byte array
     * Convert an integer to two byte array
    }
    }
            }
            .collect(Collectors.toMap(Protocol::getProtocolCode, p -> p));
     * @param sourcePort source port in the network flow tuple
        MASK_REPLY((byte) 18, (byte) 17);
package org.opensearch.ingest.common;
     * @return the resolved value of the specified field, return null if ignore_missing if true and the field doesn't exist or is null,
            if (destinationPort == null) {
        ICMP((byte) 1, false),
        return byteArray;
        assert (sourcePort != null && destinationPort != null);
import java.util.Map;
         */
        SCTP((byte) 132, true);
    ) {
         */
    }
    }
        if (fieldValue == null) {
            throw new IllegalArgumentException(
 */
        // set source port to icmp type, and set dest port to icmp code, so that we can have a generic way to handle
            return document;
    }
     * Compare two byte array which have same length
        ECHO_REPLY((byte) 129, (byte) 128),
    private Integer resolvePort(IngestDocument document, String fieldName) {
            String processorTag,
        }
        messageDigest.update(protocolCode);
 * <a href="https://github.com/corelight/community-id-spec">Community ID Flow Hashing</a>.
                throw new IllegalArgumentException("unsupported protocol [" + protocolName + "]");
import static org.opensearch.ingest.ConfigurationUtils.newConfigurationException;
            destinationPort = tempPort;
        // resolve protocol firstly
        this.targetField = targetField;
                throw new IllegalArgumentException("ip address in the field [" + fieldName + "] is null or empty");
                Integer icmpCode = resolveICMP(document, icmpCodeField, ICMP_MESSAGE_CODE);
    // the maximum port number in transport layer
        ND_NEIGHBOR_SOLICIT((byte) 135, (byte) 136),
        }
                TYPE,
     * @param fieldName name of the type or the code field
            int tempPort = sourcePort;
            }
    public String getIcmpTypeField() {
        this.ignoreMissing = ignoreMissing;
import org.opensearch.common.hash.MessageDigests;
                protocol = protocolFromName;
        messageDigest.update(PADDING_BYTE);
    // the minimum port number in transport layer
import java.util.Base64;
            if (ignoreMissing) {
     * or if the field that is found at the provided path is not of the expected type.
    private final int seed;
        public static final Map<Byte, Protocol> protocolCodeMap = Arrays.stream(values())
    /**
                throw new IllegalArgumentException("both source port and destination port field path cannot be null nor empty");
            } else {
                    + port
                return isLess;
                    "cannot resolve protocol by neither iana protocol number field ["
    public String getType() {
        }
            port = document.getFieldValue(fieldName, Integer.class, true);
        return COMMUNITY_ID_HASH_VERSION + ":" + Base64.getEncoder().encodeToString(messageDigest.digest());
        if (protocol == null) {
        boolean isLess = compareIPAndPort(sourceIPByteArray, sourcePort, destIPByteArray, destinationPort);
            String destinationIPField = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "destination_ip_field");
            int isLess = Byte.compareUnsigned(byteArray1[i], byteArray2[j]);
            return document;
    /**
        }
    // 0 byte for padding
        HAAD_REQUEST((byte) 144, (byte) 145),
    /**
        }
            } else {
            String sourceIPField = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "source_ip_field");
                : ICMPv6Type.getEquivalentCode(icmpType.byteValue());
        }
    private final String targetField;
    @Override
            ianaProtocolNumber = document.getFieldValue(ianaProtocolNumberField, Integer.class, true);
        if (Strings.isNullOrEmpty(fieldName)) {
        } else if (fieldValue < IANA_COMMON_MIN_NUMBER || fieldValue > IANA_COMMON_MAX_NUMBER) {
            if (equivalentCode != null) {
    private byte[] resolveIP(IngestDocument document, String fieldName) {
    @Override
        byte[] sourceIPByteArray,
        public static Byte getEquivalentCode(int type) {
import org.opensearch.ingest.IngestDocument;
            }
    /**
        private final byte code;
        }
                j++;
        Integer fieldValue = document.getFieldValue(fieldName, Integer.class, true);
            }
        }
        /**
     */
                throw new IllegalArgumentException("unsupported iana protocol number [" + ianaProtocolNumber + "]");
            // for the message types which don't have code, fetch the equivalent code from the pre-defined mapper,
        TSTAMP_REPLY((byte) 14, (byte) 13),
        } else if (port < MIN_PORT || port > MAX_PORT) {
import org.opensearch.ingest.Processor;
     * Mapping ICMP's message type and code into a port-like notion for ordering the request or response
        if (byteArray == null) {
        MASK((byte) 17, (byte) 18),
            sourceIPByteArray = destIPByteArray;
                ? ICMPType.getEquivalentCode(icmpType.byteValue())
     * @param fieldType type or code
                return null;
        ND_ROUTER_SOLICIT((byte) 133, (byte) 134),
            destIPByteArray,
            String destinationPortField = ConfigurationUtils.readOptionalStringProperty(
            return this.protocolCode;
            }
            if (isLess == 0) {
            destinationPort = resolvePort(document, destinationPortField);
                return document;
                } else {
        document.setFieldValue(targetField, digest);
                return Protocol.ICMP_V6;
        }
                "both source port and destination port must be between 0 and 65535, but port in the field path ["
     * Resolve ICMP's message type and code field
                throw new IllegalArgumentException("icmp message " + fieldType + " cannot be null");
        this.destinationPortField = destinationPortField;
    // the maximum seed for generating hash
    public static final String TYPE = "community_id";
        public CommunityIdProcessor create(
    }
        boolean ignoreMissing
                throw new IllegalArgumentException("icmp message " + fieldType + " field path cannot be null nor empty");
     * @param document the ingesting document
        }
        }
     * @return 0 if each byte in both two arrays are same, a value less than 0 if byte in the first array is less than
        public static Byte getEquivalentCode(int type) {
        if (Strings.isNullOrEmpty(ipAddress)) {
        // return null if protocol cannot be resolved and ignore_missing is true
 * Processor that generating community id flow hash for the network flow tuples, the algorithm is defined in
 * SPDX-License-Identifier: Apache-2.0
        // generate flow hash
        Integer ianaProtocolNumber = null;
    /**
            );
    }
        byteArray[0] = Integer.valueOf(val >>> 8).byteValue();
        }
        /**
    }
                sourcePort = icmpType;
        ) throws Exception {
        }
        TCP((byte) 6, true),
            String protocolField = ConfigurationUtils.readOptionalStringProperty(TYPE, processorTag, config, "protocol_field");
    }
        // swap ip and port to remove directionality in the flow tuple, smaller ip:port tuple comes first
    }
    }
    }
    private final String icmpTypeField;
     * @param document the ingesting document
import org.opensearch.core.common.Strings;
    }
            }
    private final String icmpCodeField;
        assert (byteArray1.length == byteArray2.length);
            String description,
         * @return the equivalent message code
     * @param val the integer which will be consumed to produce a two byte array
        String description,
                // we need to convert it to positive integer for later comparison
        byte protocolCode,
                icmpCodeField,
        }
        }
        Integer destinationPort,
            try {
                return null;
            protocolName = document.getFieldValue(protocolField, String.class, true);
    // the minimum seed for generating hash
 * The OpenSearch Contributors require contributions made to
                && ianaProtocolNumber <= IANA_COMMON_MAX_NUMBER
        String icmpTypeField,
     * or if the field that is found at the provided path is not of the expected type.
     * @return the generated hash value, use SHA-1
        } else {
    public int getSeed() {
            }
            if (ignoreMissing) {
        int compareResult = compareByteArray(sourceIPByteArray, destIPByteArray);
     */
            destinationPort,
    /**
            return fieldValue;
                return null;
    }
    CommunityIdProcessor(
                protocol = Protocol.protocolCodeMap.get(ianaProtocolNumber.byteValue());
        INFO((byte) 15, (byte) 16),
                        + "] nor protocol name field ["
        // source ip and destination ip must have same format, either ipv4 or ipv6
                    return document;
            this.protocolCode = Integer.valueOf(ianaNumber).byteValue();
        HAAD_REPLY((byte) 145, (byte) 144);
 * this file be licensed under the Apache-2.0 license or a
                destinationPort = Protocol.ICMP.getProtocolCode() == protocol.getProtocolCode()
                return null;
        this.ianaProtocolNumberField = ianaProtocolNumberField;
        }
        if (ianaProtocolNumber != null) {
            throw new IllegalArgumentException("invalid icmp message " + fieldType + " [" + fieldValue + "]");
            }
        messageDigest.update(sourceIPByteArray);
    private Integer resolveICMP(IngestDocument document, String fieldName, String fieldType) {
    enum Protocol {
            byte[] byteArray = sourceIPByteArray;
                throw new IllegalArgumentException(
            Map<String, Processor.Factory> registry,
     * @param destinationPort destination port in the network flow tuple
     * @param fieldName the port field to be resolved
        ND_ROUTER_ADVERT((byte) 134, (byte) 133),
                        + "]"
                sourcePortField,
import org.opensearch.ingest.AbstractProcessor;
     * @param sourceIPByteArray bytes of the source ip in the network flow tuple
            }
     * Resolve ip address
        Protocol protocol = null;
        } else if (protocolName != null) {
            } else {
    private static final String COMMUNITY_ID_HASH_VERSION = "1";
            } catch (IllegalArgumentException e) {
        if (port == null) {
        String sourceIPField,
    private static final int IANA_COMMON_MAX_NUMBER = 255;
    public String getTargetField() {
     * but sourcePort is less than destinationPort
    public String getDestinationIPField() {
        }
            this.type = type;
            return byteArray;
     */
            String sourcePortField = ConfigurationUtils.readOptionalStringProperty(TYPE, processorTag, config, "source_port_field");
        int j = 0;
/*
        ICMPv6Type(byte type, byte code) {
    ) {
            sourceIPByteArray,
                }
            this.code = code;
            throw new IllegalArgumentException(
                throw new IllegalArgumentException("both source ip field path and destination ip field path cannot be null nor empty");
}
     * @throws IllegalArgumentException only if ignoreMissing is false and the field is null, empty, invalid,
         * @param type the message type of IPv6-ICMP
        private final byte protocolCode;
    /**
     * Resolve port for transport protocols
    public String getSourceIPField() {
    public String getProtocolField() {
        byte[] destIPByteArray = resolveIP(document, destinationIPField);
        return document;
        if (Strings.isNullOrEmpty(fieldName)) {
        public static Protocol fromProtocolName(String protocolName) {
     * @param document the ingesting document
        return seed;
public final class CommunityIdProcessor extends AbstractProcessor {
                );
        );
    private static final String ICMP_MESSAGE_TYPE = "type";
                && Protocol.protocolCodeMap.containsKey(ianaProtocolNumber.byteValue())) {
            if (sourcePort == null) {
        } else {
        private static final Map<Byte, Byte> ICMPTypeMapper = Arrays.stream(values()).collect(Collectors.toMap(t -> t.type, t -> t.code));
        // exit quietly if either source port or destination port is null nor empty
            }
            throw new IllegalArgumentException("source ip and destination ip must have same format");
     * @param protocolCode byte of the protocol number
    enum ICMPv6Type {
    public String getIANAProtocolNumberField() {
    private static final int MIN_SEED = 0;
        if (!Strings.isNullOrEmpty(ianaProtocolNumberField)) {
            sourcePort = destinationPort;
        private final byte code;
import java.util.stream.Collectors;
        byte[] sourceIPByteArray = resolveIP(document, sourceIPField);
        if (!isLess && (!isICMPProtocol || !isOneway)) {
     *
     */
                        + ianaProtocolNumberField
        byteArray[1] = val.byteValue();
    public String getSourcePortField() {
        }
            if (ignoreMissing) {
                    ? Integer.valueOf(equivalentCode)
    // the minimum code number for network protocol, ICMP message type and code as defined by IANA
     * @param document the ingesting document
        int seed,
     * @param destIPByteArray bytes of the destination ip in the network flow tuple
        if (Strings.isNullOrEmpty(fieldName)) {
                seed,
        return ignoreMissing;
            if (icmpType == null) {
                processorTag,
     * @param destinationPort destination port in the network flow tuple
            if (ignoreMissing) {
     * @param seed seed for generating hash
            }
                    destinationPort = icmpCode;
            );
        messageDigest.update(intToTwoByteArray(sourcePort));
            Byte equivalentCode = Protocol.ICMP.getProtocolCode() == protocol.getProtocolCode()
                // for IPv6-ICMP, the pre-defined code is negative byte,
        String ianaProtocolNumberField,
     * @throws IllegalArgumentException only if ignoreMissing is false and the field is null, empty, invalid,
        int seed
        ECHO_REPLY((byte) 0, (byte) 8),
        // if iana protocol number is not specified, then resolve protocol name
        return port;
        }
        TSTAMP((byte) 13, (byte) 14),
        String digest = generateCommunityIDHash(
        // resolve ip secondly, exit quietly if either source ip or destination ip cannot be resolved and ignore_missing is true
        // resolve ICMP message type and code, support both ipv4 and ipv6
                description,
    // the version of the community id flow hashing algorithm
        }
        if (protocol == null) {
     * Compare the ip and port, return true if the flow tuple is ordered
    private final String protocolField;
        }
            return ICMPTypeMapper.get(Integer.valueOf(type).byteValue());
     * or if the field that is found at the provided path is not of the expected type.
    }
        messageDigest.update(destIPByteArray);
        ND_NEIGHBOR_ADVERT((byte) 136, (byte) 135),
        messageDigest.update(intToTwoByteArray(seed));
    private final String sourcePortField;
    private int compareByteArray(byte[] byteArray1, byte[] byteArray2) {
        return protocolField;
                processorTag,
            String icmpTypeField = ConfigurationUtils.readOptionalStringProperty(TYPE, processorTag, config, "icmp_type_field");
        }
                isOneway = false;
     * Resolve network protocol
        RTR_ADVERT((byte) 9, (byte) 10),
            String icmpCodeField = ConfigurationUtils.readOptionalStringProperty(TYPE, processorTag, config, "icmp_code_field");
            return this.isTransportProtocol;
    // the maximum code number for network protocol, ICMP message type and code as defined by IANA
                "destination_port_field"
    public String getIcmpCodeField() {
        if (protocol.isTransportProtocol()) {
                sourceIPField,
        UDP((byte) 17, true),
            this.type = type;
        }
    private final String sourceIPField;
        if (sourceIPByteArray.length != destIPByteArray.length) {
            return document;
        this.destinationIPField = destinationIPField;
        return TYPE;
        return destinationIPField;
            this.code = code;
        if (!Strings.isNullOrEmpty(protocolField)) {
                );
                processorTag,
     */
         * @param type the message type of ICMP
        private final byte type;
                "ip address [" + ipAddress + "] in the field [" + fieldName + "] is not a valid ipv4/ipv6 address"
        return 0;
     * An enumeration of the supported network protocols
            } else {
        }
        WRU_REQUEST((byte) 139, (byte) 140),
            String targetField = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "target_field", "community_id");
            int seed = ConfigurationUtils.readIntProperty(TYPE, processorTag, config, "seed", 0);
                if (icmpCode == null) {
import org.opensearch.ingest.ConfigurationUtils;
            } else {
                        + protocolField
        Integer destinationPort = null;
        MessageDigest messageDigest = MessageDigests.sha1();
    private boolean compareIPAndPort(byte[] sourceIPByteArray, int sourcePort, byte[] destIPByteArray, int destinationPort) {
/**
            if (ignoreMissing) {
        this.sourcePortField = sourcePortField;
    public String getDestinationPortField() {
        ICMPType(byte type, byte code) {
        return icmpTypeField;
        final boolean isICMPProtocol = Protocol.ICMP == protocol || Protocol.ICMP_V6 == protocol;
     */
                    "both source port and destination port cannot be null, but port in the field path [" + fieldName + "] is null"
            }
    private final String destinationIPField;
        this.icmpCodeField = icmpCodeField;
        // but for ICMP and IPv6-ICMP, if it's a one-way flow, the flow tuple is considered to be ordered
                protocolField,
     * @return the resolved protocol, null if the resolved protocol is null and ignore_missing is true
    /**
                config,
        return compareResult < 0 || compareResult == 0 && sourcePort < destinationPort;
                    + fieldName
    public static class Factory implements Processor.Factory {
        byte[] byteArray = InetAddresses.ipStringToBytes(ipAddress);
                return null;
        return destinationPortField;
        // all protocols
        INFO_REPLY((byte) 16, (byte) 15),
    /**
            Integer icmpType = resolveICMP(document, icmpTypeField, ICMP_MESSAGE_TYPE);
        } else {
    private String generateCommunityIDHash(
                    + "] is ["
                ignoreMissing
    }
import java.security.MessageDigest;
                throw new IllegalArgumentException(
     * @param sourcePort source port in the network flow tuple
        return ianaProtocolNumberField;
                return null;
                throw newConfigurationException(TYPE, processorTag, "seed", "seed must be between 0 and 65535");
        // resolve source port and destination port for transport protocols,
     * @return the resolved port number, null if the resolved port is null and ignoreMissing is true
        this.icmpTypeField = icmpTypeField;
                return valueOf(name);
            } else {
        String sourcePortField,
        private final boolean isTransportProtocol;
    /**
