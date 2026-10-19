            if (protocolFromName != null) {
    private final int seed;
     * @return true if sourceIP is less than destinationIP or sourceIP equals to destinationIP  
        HAAD_REQUEST((byte) 144, (byte) 145),
            }
     */
    }
import java.util.stream.Collectors;
        if (Strings.isNullOrEmpty(ipAddress)) {
                "ip address [" + ipAddress + "] in the field [" + fieldName + "] is not a valid ipv4/ipv6 address"  
         * @return the equivalent message code  
            }
            String icmpTypeField = ConfigurationUtils.readOptionalStringProperty(TYPE, processorTag, config, "icmp_type_field");
        MLD_LISTENER_QUERY((byte) 130, (byte) 131),  
     * @return the resolved port number, null if the resolved port is null and ignoreMissing is true
        }  
     * @param destinationPort destination port in the network flow tuple
        } else {
     * the byte at the same index, a value greater than 0 if byte in the first array is greater than the byte at the same index
    }  
        messageDigest.update(destIPByteArray);  
    private static final int MIN_SEED = 0;  
            if (seed < MIN_SEED || seed > MAX_SEED) {
         * Takes the message type of ICMP and derives equivalent message code  
    private final boolean ignoreMissing;
        byte[] sourceIPByteArray = resolveIP(document, sourceIPField);
        private final byte protocolCode;
        return COMMUNITY_ID_HASH_VERSION + ":" + Base64.getEncoder().encodeToString(messageDigest.digest());  
        }  
     * Convert an integer to two byte array
                    + fieldName
    /**  
        // return null if protocol cannot be resolved and ignore_missing is true
     * @return the two byte array  
         */  
        public static Byte getEquivalentCode(int type) {
                }  
    }  
    }  
        return byteArray;  
        WRU_REQUEST((byte) 139, (byte) 140),  
                sourcePort = icmpType;
    // the minimum seed for generating hash
        Integer ianaProtocolNumber = null;  
        Integer port;
     * or if the field that is found at the provided path is not of the expected type.
            boolean ignoreMissing = ConfigurationUtils.readBooleanProperty(TYPE, processorTag, config, "ignore_missing", false);  
            }
    }
            );
        UDP((byte) 17, true),
                icmpCodeField,  
            } else {  
    // the maximum port number in transport layer
import java.util.Base64;
        assert (byteArray1.length == byteArray2.length);
        if (ianaProtocolNumber != null) {  
            }  
    private static final int MIN_PORT = 0;
    /**
            byte[] byteArray = sourceIPByteArray;  
    public String getType() {
     * Mapping ICMP's message type and code into a port-like notion for ordering the request or response
        }
    }  
                "destination_port_field"
                return null;  
        }
            Protocol protocolFromName = Protocol.fromProtocolName(protocolName);  
    private final String sourcePortField;
    private final String icmpTypeField;  
                return valueOf(name);
    private final String destinationPortField;  
        ECHO_REPLY((byte) 0, (byte) 8),
        byte[] sourceIPByteArray,  
    }
    // the minimum code number for network protocol, ICMP message type and code as defined by IANA  
            this.type = type;
    /**  
        String icmpCodeField,
 *
        if (protocol == null) {  
     * @return 0 if each byte in both two arrays are same, a value less than 0 if byte in the first array is less than  
                sourceIPField,
    public int getSeed() {
        String destinationIPField,
        int seed,
            destinationPort = resolvePort(document, destinationPortField);
        if (byteArray == null) {
        String protocolField,
    /**
    }
        byte[] byteArray = new byte[2];  
            String processorTag,
        return destinationIPField;
        if (!Strings.isNullOrEmpty(ianaProtocolNumberField)) {
    public String getIANAProtocolNumberField() {  
                return document;  
                );
        } else if (protocolName != null) {
    private final String protocolField;
                protocol = protocolFromName;
            } else {
        // resolve ICMP message type and code, support both ipv4 and ipv6
            destIPByteArray,
        return icmpCodeField;
    /**  
    public boolean isIgnoreMissing() {  
            );  
            if (equivalentCode != null) {
        int compareResult = compareByteArray(sourceIPByteArray, destIPByteArray);
        messageDigest.update(intToTwoByteArray(destinationPort));
    }  
        String targetField,  
    // the minimum port number in transport layer  
            }
                    + "] is ["  
        String sourceIPField,  
    }
        return ignoreMissing;
        this.sourceIPField = sourceIPField;
    public String getSourcePortField() {  
     * @return the resolved value of the specified field, return null if ignore_missing if true and the field doesn't exist or is null,
            return fieldValue;
                config,  
        /**  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.ingest.Processor;
        if (Strings.isNullOrEmpty(fieldName)) {
    public static final String TYPE = "community_id";
            sourceIPByteArray,  
    enum Protocol {
    private final String targetField;  
                destinationPortField,
    }
    }
         * Takes the message type of IPv6-ICMP and derives equivalent message code
     * @param protocolCode byte of the protocol number
         */
        messageDigest.update(PADDING_BYTE);
     */  
            }  
        ICMP_V6((byte) 58, false),
import org.opensearch.ingest.ConfigurationUtils;
        String tag,
            return byteArray;  
        ECHO_REQUEST((byte) 128, (byte) 129),
        String icmpTypeField,  
            return ICMPTypeMapper.get(Integer.valueOf(type).byteValue());  
                throw new IllegalArgumentException("both source ip field path and destination ip field path cannot be null nor empty");
        if (Strings.isNullOrEmpty(fieldName)) {  
            }
     * @param fieldType type or code  
    enum ICMPv6Type {  
        Integer destinationPort = null;  
                return null;
        private final byte type;
                    "both source port and destination port cannot be null, but port in the field path [" + fieldName + "] is null"
            throw new IllegalArgumentException(
        ND_NEIGHBOR_ADVERT((byte) 136, (byte) 135),
                        + "]"  
import org.opensearch.common.hash.MessageDigests;
        return compareResult < 0 || compareResult == 0 && sourcePort < destinationPort;
        MLD_LISTENER_REPORT((byte) 131, (byte) 130),
    private static final String ICMP_MESSAGE_CODE = "code";
        }
                targetField,
import static org.opensearch.ingest.ConfigurationUtils.newConfigurationException;
     * @param fieldName the ip field to be resolved
            Integer icmpType = resolveICMP(document, icmpTypeField, ICMP_MESSAGE_TYPE);
public final class CommunityIdProcessor extends AbstractProcessor {
    }  
        byte[] destIPByteArray,
    private final String destinationIPField;
        this.sourcePortField = sourcePortField;
                seed,
     * @param destIPByteArray bytes of the destination ip in the network flow tuple
    }
                    + "]"
            }
            );
        boolean ignoreMissing
        @Override
                j++;
    ) {
        MessageDigest messageDigest = MessageDigests.sha1();  
/**  
    private final String sourceIPField;  
    private int compareByteArray(byte[] byteArray1, byte[] byteArray2) {  
import org.opensearch.common.network.InetAddresses;
            } else {
            if (ianaProtocolNumber >= IANA_COMMON_MIN_NUMBER
     * @param destIPByteArray bytes of the destination ip in the network flow tuple  
        TSTAMP_REPLY((byte) 14, (byte) 13),
            }  
        // if iana protocol number is not specified, then resolve protocol name
        private final byte type;
    private final String icmpCodeField;
        ECHO((byte) 8, (byte) 0),  
            } else {  
     * Compare the ip and port, return true if the flow tuple is ordered
     * @param sourcePort source port in the network flow tuple
                return null;
        byte[] destIPByteArray = resolveIP(document, destinationIPField);  
        if (protocol == null) {  
            throw new IllegalArgumentException("source ip and destination ip must have same format");  
        HAAD_REPLY((byte) 145, (byte) 144);  
    }
        return destinationPortField;  
            Byte equivalentCode = Protocol.ICMP.getProtocolCode() == protocol.getProtocolCode()
                throw new IllegalArgumentException("icmp message " + fieldType + " cannot be null");  
 * Processor that generating community id flow hash for the network flow tuples, the algorithm is defined in
            if (ignoreMissing) {
            this.protocolCode = Integer.valueOf(ianaNumber).byteValue();  
                return null;
    private byte[] resolveIP(IngestDocument document, String fieldName) {  
     */  
                && ianaProtocolNumber <= IANA_COMMON_MAX_NUMBER
                throw new IllegalArgumentException("unsupported protocol [" + protocolName + "]");
                processorTag,
        if (!isLess && (!isICMPProtocol || !isOneway)) {
    ) {
            sourcePort = destinationPort;
        INFO_REPLY((byte) 16, (byte) 15),  
    }  
    @Override
     */
        WRU_REPLY((byte) 140, (byte) 139),
 */  
        this.ianaProtocolNumberField = ianaProtocolNumberField;
    }
        ) throws Exception {
            }
    /**
            sourcePort,
     * @param destinationPort destination port in the network flow tuple  
                } else {
    private static final byte PADDING_BYTE = 0;  
                isOneway = false;
        RTR_ADVERT((byte) 9, (byte) 10),
    private static final int IANA_COMMON_MIN_NUMBER = 0;
        }
    public String getProtocolField() {
        byteArray[0] = Integer.valueOf(val >>> 8).byteValue();
        Integer sourcePort = null;
            }  
        return ianaProtocolNumberField;
        return icmpTypeField;  
        }  
        }
            }
    private static final String ICMP_MESSAGE_TYPE = "type";
     * @param byteArray2 the second byte array to compare
        super(tag, description);  
    // the maximum seed for generating hash
    public String getSourceIPField() {
        } else {
                icmpTypeField,
        String sourcePortField,
        messageDigest.update(sourceIPByteArray);
        // resolve protocol firstly  
            // for the message types which don't have code, fetch the equivalent code from the pre-defined mapper,
        this.seed = seed;  
                processorTag,  
        Integer fieldValue = document.getFieldValue(fieldName, Integer.class, true);
            Map<String, Object> config
     * Compare two byte array which have same length  
            return new CommunityIdProcessor(
    private static final int MAX_SEED = 65535;
            String sourceIPField = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "source_ip_field");  
            // and they can be considered to two-way flow  
            if (ignoreMissing) {
                throw new IllegalArgumentException(
            sourcePort = resolvePort(document, sourcePortField);
            try {  
                "both source port and destination port must be between 0 and 65535, but port in the field path ["
            if (ignoreMissing) {  
            }
    public String getDestinationPortField() {
                description,
    public String getIcmpTypeField() {
        private final byte code;
    private boolean compareIPAndPort(byte[] sourceIPByteArray, int sourcePort, byte[] destIPByteArray, int destinationPort) {  
                return null;
     * @throws IllegalArgumentException only if ignoreMissing is false and the field is null, empty, invalid,
            throw new IllegalArgumentException(  
                // get icmp code from the document if we cannot get equivalent code from the pre-defined mapper  
        // resolve source port and destination port for transport protocols,  
    @Override
                sourcePortField,  
    private Protocol resolveProtocol(IngestDocument document) {
                processorTag,
        String destinationPortField,  
     */  
        }
            if (ignoreMissing) {
 * this file be licensed under the Apache-2.0 license or a
        String protocolName = null;
     * @param byteArray1 the first byte array to compare
        public static Byte getEquivalentCode(int type) {
     */
        }
    }
        return sourcePortField;
    /**
            int seed = ConfigurationUtils.readIntProperty(TYPE, processorTag, config, "seed", 0);  
        // swap ip and port to remove directionality in the flow tuple, smaller ip:port tuple comes first  
        ND_NEIGHBOR_SOLICIT((byte) 135, (byte) 136),
        String ianaProtocolNumberField,
         * @param type the message type of ICMP
        }
import org.opensearch.ingest.IngestDocument;  
        }
            destinationPort = tempPort;  
    /**  
        if (sourceIPByteArray == null) {  
     * Resolve port for transport protocols
        Protocol protocol = resolveProtocol(document);
     * @throws IllegalArgumentException only if ignoreMissing is false and the field is null, empty, invalid,  
     * @return the resolved protocol, null if the resolved protocol is null and ignore_missing is true  
        }
        private static final Map<Byte, Byte> ICMPTypeMapper = Arrays.stream(values()).collect(Collectors.toMap(t -> t.type, t -> t.code));
            this.code = code;  
        while (i < byteArray1.length && j < byteArray2.length) {
     * Resolve network protocol
    private Integer resolvePort(IngestDocument document, String fieldName) {  
                ? ICMPType.getEquivalentCode(icmpType.byteValue())
            }
     * Mapping IPv6-ICMP's message type and code into a port-like notion for ordering the request or response
            if (name.equals("IPV6-ICMP")) {  
                config,  
            return ICMPTypeMapper.get(Integer.valueOf(type).byteValue());
    }
                return isLess;
            } catch (IllegalArgumentException e) {
            } else {
        );
         * @return the equivalent message code
            } else {
    private Integer resolveICMP(IngestDocument document, String fieldName, String fieldType) {
     */
                protocolField,
     * @throws IllegalArgumentException only if ignoreMissing is false and the field is null, empty, invalid,
            String protocolField = ConfigurationUtils.readOptionalStringProperty(TYPE, processorTag, config, "protocol_field");  
            }
    private static final String COMMUNITY_ID_HASH_VERSION = "1";
import java.util.Arrays;
        return seed;
        }
        }
     * @param sourceIPByteArray bytes of the source ip in the network flow tuple  
 * compatible open source license.
        document.setFieldValue(targetField, digest);  
        // resolve ip secondly, exit quietly if either source ip or destination ip cannot be resolved and ignore_missing is true
package org.opensearch.ingest.common;
                destinationPort = Protocol.ICMP.getProtocolCode() == protocol.getProtocolCode()
        int j = 0;  
            } else {
                throw new IllegalArgumentException("ip address in the field [" + fieldName + "] is null or empty");
            destIPByteArray = byteArray;
        TCP((byte) 6, true),  
        this.protocolField = protocolField;  
     * @param document the ingesting document  
        return 0;
        messageDigest.update(intToTwoByteArray(sourcePort));  
     * Resolve ip address
    }
    private byte[] intToTwoByteArray(Integer val) {
            int tempPort = sourcePort;
        return sourceIPField;  
        // exit quietly if either source port or destination port is null nor empty
        this.targetField = targetField;
            if (sourcePort == null) {  
        messageDigest.update(intToTwoByteArray(seed));
        MASK_REPLY((byte) 18, (byte) 17);
                throw new IllegalArgumentException("icmp message " + fieldType + " field path cannot be null nor empty");
                return Protocol.ICMP_V6;
                        + protocolField
        if (isICMPProtocol) {  
    public String getDestinationIPField() {
    /**
        return TYPE;  
        SCTP((byte) 132, true);  
                        + ianaProtocolNumberField  
        private static final Map<Byte, Byte> ICMPTypeMapper = Arrays.stream(values()).collect(Collectors.toMap(t -> t.type, t -> t.code));  
            if (isLess == 0) {  
 * SPDX-License-Identifier: Apache-2.0
        Integer destinationPort,  
                i++;
        this.ignoreMissing = ignoreMissing;
        INFO((byte) 15, (byte) 16),
            if (ignoreMissing) {
    private static final int MAX_PORT = 63335;  
    public IngestDocument execute(IngestDocument document) {
            Map<String, Processor.Factory> registry,
            return document;
            this.type = type;  
            if (icmpType == null) {
     * @return the generated hash value, use SHA-1
        RTR_SOLICIT((byte) 10, (byte) 9),
        ND_ROUTER_SOLICIT((byte) 133, (byte) 134),
        if (sourceIPByteArray.length != destIPByteArray.length) {
        }
        public static Protocol fromProtocolName(String protocolName) {
 * <a href="https://github.com/corelight/community-id-spec">Community ID Flow Hashing</a>.
        boolean isOneway = true;
        public boolean isTransportProtocol() {
                TYPE,
        // source ip and destination ip must have same format, either ipv4 or ipv6
                if (icmpCode == null) {
     * An enumeration of the supported network protocols
        // generate flow hash  
        assert (sourcePort != null && destinationPort != null);
            if (ignoreMissing) {
    public String getIcmpCodeField() {  
        }  
            );
    }
    }
        // exit quietly if protocol cannot be resolved and ignore_missing is true
            );
/*  
            if (destinationPort == null) {
        int i = 0;
        private final boolean isTransportProtocol;  
     * @param seed seed for generating hash
        if (fieldValue == null) {
     * @param sourceIPByteArray bytes of the source ip in the network flow tuple
        public byte getProtocolCode() {
        int seed
                return null;  
    private static final int IANA_COMMON_MAX_NUMBER = 255;
     * @param sourcePort source port in the network flow tuple
        ICMPType(byte type, byte code) {
        this.icmpCodeField = icmpCodeField;
    // the version of the community id flow hashing algorithm  
            .collect(Collectors.toMap(Protocol::getProtocolCode, p -> p));
        }  
    }
            } else {  
     * or if the field that is found at the provided path is not of the expected type.
        this.destinationIPField = destinationIPField;  
                    "cannot resolve protocol by neither iana protocol number field ["
            port = document.getFieldValue(fieldName, Integer.class, true);  
        ICMPv6Type(byte type, byte code) {
import java.security.MessageDigest;  
    public String getTargetField() {
                // we need to convert it to positive integer for later comparison
                throw new IllegalArgumentException("unsupported iana protocol number [" + ianaProtocolNumber + "]");  
        this.icmpTypeField = icmpTypeField;
            String ianaProtocolNumberField = ConfigurationUtils.readOptionalStringProperty(  
    private String generateCommunityIDHash(
            String sourcePortField = ConfigurationUtils.readOptionalStringProperty(TYPE, processorTag, config, "source_port_field");
         * @param type the message type of IPv6-ICMP
     */
                    : Byte.toUnsignedInt(equivalentCode);
        return protocolField;
        Integer sourcePort,
                throw newConfigurationException(TYPE, processorTag, "seed", "seed must be between 0 and 65535");
                destinationIPField,
                TYPE,
                return null;
            } else {  
import java.util.Locale;  
            } else {
            throw new IllegalArgumentException("invalid icmp message " + fieldType + " [" + fieldValue + "]");  
        String digest = generateCommunityIDHash(
        public CommunityIdProcessor create(  
    /**  
    // the maximum code number for network protocol, ICMP message type and code as defined by IANA
        boolean isLess = compareIPAndPort(sourceIPByteArray, sourcePort, destIPByteArray, destinationPort);
     * @return the byte array of the resolved ip
        return document;
    CommunityIdProcessor(  
        private final byte code;  
    public static class Factory implements Processor.Factory {
                throw new IllegalArgumentException("both source port and destination port field path cannot be null nor empty");  
        byte protocolCode,
                    ? Integer.valueOf(equivalentCode)  
        final boolean isICMPProtocol = Protocol.ICMP == protocol || Protocol.ICMP_V6 == protocol;
            sourceIPByteArray = destIPByteArray;
        }
        }
        public static final Map<Byte, Protocol> protocolCodeMap = Arrays.stream(values())
        return targetField;  
            destinationPort,  
            this.isTransportProtocol = isTransportProtocol;
        if (protocol.isTransportProtocol()) {
        }  
            } else {
            String description,  
            return document;
                );  
            this.code = code;
import org.opensearch.ingest.AbstractProcessor;
                protocol = Protocol.protocolCodeMap.get(ianaProtocolNumber.byteValue());
            String destinationIPField = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "destination_ip_field");
        Protocol(int ianaNumber, boolean isTransportProtocol) {
     * @param fieldName the port field to be resolved
        return port;
        ND_ROUTER_ADVERT((byte) 134, (byte) 133),  
            if (ignoreMissing) {  
        this.destinationPortField = destinationPortField;
        MASK((byte) 17, (byte) 18),
                return document;  
}
        if (!Strings.isNullOrEmpty(protocolField)) {
    enum ICMPType {
                throw new IllegalArgumentException(
     */
            seed
        byte[] byteArray = InetAddresses.ipStringToBytes(ipAddress);  
                    return document;  
     * @param document the ingesting document  
     */
    }
        } else {
            String destinationPortField = ConfigurationUtils.readOptionalStringProperty(  
        messageDigest.update(protocolCode);
     */  
                        + "] nor protocol name field ["
                    destinationPort = icmpCode;
        return protocol;
        String ipAddress = document.getFieldValue(fieldName, String.class, true);  
            protocol.getProtocolCode(),
        ECHO_REPLY((byte) 129, (byte) 128),
     *
                Integer icmpCode = resolveICMP(document, icmpCodeField, ICMP_MESSAGE_CODE);
        Protocol protocol = null;
        /**
            }
import org.opensearch.core.common.Strings;  
        }
        }
                return document;
     * @param val the integer which will be consumed to produce a two byte array
                    + port
            return this.isTransportProtocol;  
        byteArray[1] = val.byteValue();
        }
        }  
            ianaProtocolNumber = document.getFieldValue(ianaProtocolNumberField, Integer.class, true);  
     * or if the field that is found at the provided path is not of the expected type.
                ianaProtocolNumberField,  
            return document;
        ICMP((byte) 1, false),
 */  
            } else {  
                && Protocol.protocolCodeMap.containsKey(ianaProtocolNumber.byteValue())) {  
                ignoreMissing  
        // but for ICMP and IPv6-ICMP, if it's a one-way flow, the flow tuple is considered to be ordered
    /**
            }
     * @param fieldName name of the type or the code field
        } else if (fieldValue < IANA_COMMON_MIN_NUMBER || fieldValue > IANA_COMMON_MAX_NUMBER) {
        }
import java.util.Map;
            int isLess = Byte.compareUnsigned(byteArray1[i], byteArray2[j]);
        if (Strings.isNullOrEmpty(fieldName)) {
        if (destIPByteArray == null) {
     * @throws IllegalArgumentException only if ignoreMissing is false and the field is null, empty, invalid,  
                : ICMPv6Type.getEquivalentCode(icmpType.byteValue());  
    private final String ianaProtocolNumberField;
    }
        // set source port to icmp type, and set dest port to icmp code, so that we can have a generic way to handle
                return null;  
        String description,
            protocolName = document.getFieldValue(protocolField, String.class, true);  
     * @param document the ingesting document
        TSTAMP((byte) 13, (byte) 14),  
     * @param document the ingesting document
            String name = protocolName.toUpperCase(Locale.ROOT);
        // all protocols  
            return this.protocolCode;
                // for IPv6-ICMP, the pre-defined code is negative byte,  
     * or if the field that is found at the provided path is not of the expected type.  
        }  
            String icmpCodeField = ConfigurationUtils.readOptionalStringProperty(TYPE, processorTag, config, "icmp_code_field");
        } else if (port < MIN_PORT || port > MAX_PORT) {
                "iana_protocol_number_field"
    }
        if (port == null) {  
     * Resolve ICMP's message type and code field  
        }
     * but sourcePort is less than destinationPort
    // 0 byte for padding
            String targetField = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "target_field", "community_id");
