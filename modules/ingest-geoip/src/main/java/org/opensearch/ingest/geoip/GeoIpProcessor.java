                geoData = Collections.emptyMap();
                    );
import com.maxmind.geoip2.record.Country;
        if (ip == null && ignoreMissing) {
            } catch (AddressNotFoundRuntimeException e) {  
                Property.REGION_NAME,
            }  
                    break;
    @Override
                }
        LOCATION,
     * @param properties    the properties; ideally this is lazily-loaded once on first use
                    break;
                properties = Collections.unmodifiableSet(modifiableProperties);  
                case COUNTRY_ISO_CODE:
            final Map<String, Object> config
        Map<String, Object> geoData;
import org.opensearch.common.network.InetAddresses;
        if (databaseType.endsWith(CITY_DB_SUFFIX)) {  
                Property.REGION_ISO_CODE,  
 * GitHub history for details.
        CountryResponse response = AccessController.doPrivileged(() -> cache.putIfAbsent(ipAddress, CountryResponse.class, ip -> {
            )
                for (String fieldName : propertyNames) {
    }  
 * license agreements. See the NOTICE file distributed with
        AddressNotFoundRuntimeException(Throwable cause) {
import org.opensearch.ingest.IngestDocument;
            switch (property) {
        return ignoreMissing;
            }
 * You may obtain a copy of the License at  
                throw new AddressNotFoundRuntimeException(e);  
            Property.CONTINENT_NAME,
                    if (continentName != null) {
                    if (cityName != null) {
                properties,  
    }
import org.opensearch.secure_sm.AccessController;
                    String countryIsoCode = country.getIsoCode();
            Property.ORGANIZATION_NAME,  
        Network network = response.getNetwork();
     * @param description   the processor description  
                        processorTag,
                        geoData.put("continent_name", continentName);
import java.util.Collections;
        COUNTRY_NAME,
            this.databaseReaders = databaseReaders;
 *
                if (!(ipAddr instanceof String ipAddrString)) {
            return Collections.unmodifiableMap(databaseReaders);
            Property.COUNTRY_ISO_CODE
 * this file be licensed under the Apache-2.0 license or a
        Subdivision subdivision = response.getMostSpecificSubdivision();
import org.opensearch.common.network.NetworkAddress;  
public final class GeoIpProcessor extends AbstractProcessor {  
                case TIMEZONE:
            EnumSet.of(Property.IP, Property.ASN, Property.ORGANIZATION_NAME, Property.NETWORK)
            EnumSet.of(Property.CONTINENT_NAME, Property.COUNTRY_NAME, Property.COUNTRY_ISO_CODE)
            } catch (AddressNotFoundRuntimeException e) {  
     * @param ignoreMissing true if documents with a missing value for the field should be ignored
            }
        final boolean ignoreMissing,
                    String subdivisionIso = subdivision.getIsoCode();
     * @param field         the source field to geo-IP map
                ingestDocument.setFieldValue(targetField, geoDataList);  
 * software distributed under the License is distributed on an
        super(tag, description);
                lazyLoader,
                    properties = DEFAULT_ASN_PROPERTIES;
                validProperties = ALL_CITY_PROPERTIES;
                case COUNTRY_ISO_CODE:  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                description,
package org.opensearch.ingest.geoip;
import java.util.EnumSet;  
                    break;
                geoData = retrieveCityGeoData(ipAddress);
                    String cityName = city.getName();  
                    geoDataList.add(null);
     *  @param tag           the processor tag
    // it with an unchecked exception.
    @SuppressWarnings("removal")
        Country country = response.getCountry();  
                    geoData.put("ip", NetworkAddress.format(ipAddress));
            if (databaseType.endsWith(CITY_DB_SUFFIX)) {  
        );
        }
            for (Object ipAddr : ipList) {
            }
import com.maxmind.geoip2.model.AsnResponse;  
                }
        REGION_ISO_CODE,
                if (firstOnly) {
                        geoData.put("continent_name", continentName);  
            if (match) {
                        geoData.put("country_iso_code", countryIsoCode);  
    }
 *  
            EnumSet.of(
                        TYPE,
                    break;
        final String field,  
                    }  
                case REGION_NAME:
                case COUNTRY_NAME:  
            }  
    private Map<String, Object> retrieveCityGeoData(InetAddress ipAddress) {
            Property.COUNTRY_NAME,  
    }
                throw new RuntimeException(e);
                    Double latitude = location.getLatitude();  
                    break;
        } else {
                    if (countryIsoCode != null) {
                case CITY_NAME:
    enum Property {
                    break;
 * this work for additional information regarding copyright
        CityResponse response = AccessController.doPrivileged(() -> cache.putIfAbsent(ipAddress, CityResponse.class, ip -> {  
 * specific language governing permissions and limitations
    @SuppressWarnings("removal")  
 * Unless required by applicable law or agreed to in writing,
        ORGANIZATION_NAME,
                Property property = valueOf(value.toUpperCase(Locale.ROOT));  
    private static final String COUNTRY_DB_SUFFIX = "-Country";
                firstOnly  
            Property.TIMEZONE,  
        SpecialPermission.check();
                if (validProperties.contains(property) == false) {
            throw new IllegalArgumentException("field [" + field + "] is null, cannot extract geoip information.");
                    throw new IllegalArgumentException("array in field [" + field + "] should only contain strings");  
                return lazyLoader.get().country(ip);
            String ipField = readStringProperty(TYPE, processorTag, config, "field");  
                    properties = DEFAULT_CITY_PROPERTIES;  
                    ingestDocument.setFieldValue(targetField, geoData);
    }  
        NETWORK;
                    break;  
            try {  
        this.properties = properties;  
                        modifiableProperties.add(Property.parseProperty(databaseType, fieldName));
            String databaseFile = readStringProperty(TYPE, processorTag, config, "database_file", "GeoLite2-City.mmdb");
        return targetField;
 * the Apache License, Version 2.0 (the "License"); you may
        return geoData;
        Map<String, Object> geoData = new HashMap<>();  
        } else if (databaseType.endsWith(COUNTRY_DB_SUFFIX)) {  
    }
                    break;
        static final Set<Property> DEFAULT_CITY_PROPERTIES = Collections.unmodifiableSet(
        );
        this.targetField = targetField;
 * Licensed to Elasticsearch under one or more contributor  
     * Construct a geo-IP processor.
            Property.IP,
                Property.LOCATION  
            final Set<Property> properties;
import org.opensearch.ingest.Processor;  
import com.maxmind.geoip2.record.Location;  
                Set<Property> modifiableProperties = EnumSet.noneOf(Property.class);
            String targetField = readStringProperty(TYPE, processorTag, config, "target_field", "geoip");
            Property.NETWORK
        }
        }
    private final boolean ignoreMissing;
     * @param cache         a geo-IP cache  
                        throw newConfigurationException(TYPE, processorTag, "properties", e.getMessage());  
 * compatible open source license.
            );
            try {
    private Map<String, Object> retrieveCountryGeoData(InetAddress ipAddress) {  
    private Map<String, Object> retrieveAsnGeoData(InetAddress ipAddress) {  
                    // ISO 3166-2 code for country subdivisions.
                    throw new IllegalArgumentException("invalid");
        AsnResponse response = AccessController.doPrivileged(() -> cache.putIfAbsent(ipAddress, AsnResponse.class, ip -> {
import java.net.InetAddress;
        static final EnumSet<Property> ALL_ASN_PROPERTIES = EnumSet.of(  
        TIMEZONE,
                    break;  
            Map<String, Object> geoData = getGeoData(ipString);  
            }  
                    if (subdivisionName != null) {
                }  
            Property.REGION_NAME,
        final String tag,
                    String countryIso = country.getIsoCode();
                Property.COUNTRY_ISO_CODE,
    }
/*  
            Property.ASN,
                        "database_file",  
        SpecialPermission.check();
            } else {
                return property;
        return TYPE;
                        locationObject.put("lon", longitude);
import java.io.IOException;
    private final Set<Property> properties;
                        geoData.put("timezone", locationTimeZone);
        public GeoIpProcessor create(  
import java.util.Set;
                    if (countryIso != null && subdivisionIso != null) {  
        return lazyLoader.getDatabaseType();
import org.opensearch.ingest.AbstractProcessor;
                ipField,  
import static org.opensearch.ingest.ConfigurationUtils.readOptionalList;  
import java.util.ArrayList;  
                    geoData.put("ip", NetworkAddress.format(ipAddress));
    // Geoip2's AddressNotFoundException is checked and due to the fact that we need run their code
                    String countryIsoCode = country.getIsoCode();
                        geoData.put("country_iso_code", countryIsoCode);
                "Unsupported database type [" + lazyLoader.getDatabaseType() + "]",
 * Modifications Copyright OpenSearch Contributors. See
    // inside a PrivilegedAction code block, we are forced to catch any checked exception and rethrow  
 *
        ASN,  
                    if (network != null) {  
        this.firstOnly = firstOnly;  
            this.cache = cache;
            }
                geoData = Collections.emptyMap();
                        geoData.put("asn", asn);  
            try {
                    }  
        Continent continent = response.getContinent();
        return ingestDocument;
            try {
            Set<Property> validProperties = EnumSet.noneOf(Property.class);
                    return ingestDocument;  
                geoData = retrieveAsnGeoData(ipAddress);
import org.opensearch.SpecialPermission;
        }
            } else if (databaseType.endsWith(COUNTRY_DB_SUFFIX)) {
            } catch (Exception e) {
                    throw newConfigurationException(  
    private static final String ASN_DB_SUFFIX = "-ASN";
    private final String targetField;
        IP,  
                case ASN:
/*  
            Property.REGION_ISO_CODE,  
        for (Property property : this.properties) {
    @Override  
                    "illegal property value [" + value + "]. valid values are " + Arrays.toString(validProperties.toArray())
        boolean firstOnly  
 * KIND, either express or implied.  See the License for the
                        geoData.put("city_name", cityName);
                    geoData.put("ip", NetworkAddress.format(ipAddress));
            DatabaseReaderLazyLoader lazyLoader = databaseReaders.get(databaseFile);
                } else if (databaseType.endsWith(ASN_DB_SUFFIX)) {  
                    break;
                    if (latitude != null && longitude != null) {
            }
     * @param lazyLoader    a supplier of a geo-IP database reader; ideally this is lazily-loaded once on first use
            final String processorTag,
                case CONTINENT_NAME:  
     */
        this.ignoreMissing = ignoreMissing;
                    if (countryName != null) {  
        Object ip = ingestDocument.getFieldValue(field, Object.class, ignoreMissing);  
                        geoData.put("region_iso_code", regionIsoCode);
        final GeoIpCache cache,
    public static final class Factory implements Processor.Factory {  
                    String countryName = country.getName();
        static final Set<Property> DEFAULT_COUNTRY_PROPERTIES = Collections.unmodifiableSet(  
        final String targetField,
                case REGION_ISO_CODE:
                    }  
                    }  
    static final class AddressNotFoundRuntimeException extends RuntimeException {  
                        Map<String, Object> locationObject = new HashMap<>();  
        String organization_name = response.getAutonomousSystemOrganization();
            final String description,  
     * @param targetField   the target field  
    }  
    private final GeoIpCache cache;  
import com.maxmind.geoip2.model.CountryResponse;
                case IP:
            }
 * The OpenSearch Contributors require contributions made to  
                        geoData.put("organization_name", organization_name);
                throw new AddressNotFoundRuntimeException(e);  
        } else {  
                throw new AddressNotFoundRuntimeException(e);
        return geoData;
                geoDataList.add(geoData);  
            super(cause);  
        Map<String, Object> geoData = new HashMap<>();
                    try {  
            }
            Property.COUNTRY_ISO_CODE,  
    }  
                    continue;
            switch (property) {  
                throw new IllegalArgumentException(  
                ignoreMissing,
import com.maxmind.db.Network;
    }
    ) {
        public Factory(Map<String, DatabaseReaderLazyLoader> databaseReaders, GeoIpCache cache) {  
        for (Property property : this.properties) {
        }
                    break;
        } else if (databaseType.endsWith(ASN_DB_SUFFIX)) {  
            } catch (AddressNotFoundException e) {
                    String continentName = continent.getName();
    String getTargetField() {  
            final String databaseType = lazyLoader.getDatabaseType();  
    public IngestDocument execute(IngestDocument ingestDocument) throws IOException {
                    }
import org.opensearch.ingest.geoip.IngestGeoIpModulePlugin.GeoIpCache;
            return ingestDocument;  
        COUNTRY_ISO_CODE,
 * not use this file except in compliance with the License.
        return properties;  
        Long asn = response.getAutonomousSystemNumber();  
                if (geoData.isEmpty()) {  
                    break;  
                cache,
import com.maxmind.geoip2.record.Subdivision;
                    break;  
                    break;
                    String countryName = country.getName();
                case LOCATION:
        this.field = field;  
    }  
            } else if (databaseType.endsWith(ASN_DB_SUFFIX)) {
        }
        Map<String, Object> geoData = new HashMap<>();
    }  
        City city = response.getCity();
                targetField,
import java.util.Map;
            Property.COUNTRY_NAME,
                    if (countryIsoCode != null) {  
                    if (locationTimeZone != null) {
                case IP:
    private static final String CITY_DB_SUFFIX = "-City";  
                    String locationTimeZone = location.getTimeZone();  
            } catch (AddressNotFoundException e) {  
                }  
        static final EnumSet<Property> ALL_CITY_PROPERTIES = EnumSet.of(
                Property.CITY_NAME,
                    Double longitude = location.getLongitude();
 *    http://www.apache.org/licenses/LICENSE-2.0
            } catch (AddressNotFoundRuntimeException e) {  
    private final String field;
            if (geoData.isEmpty() == false) {
        CONTINENT_NAME,  
        );
            switch (property) {  
        return field;  
                        String regionIsoCode = countryIso + "-" + subdivisionIso;
            Property.IP,
            final Map<String, Processor.Factory> registry,
        if (ip instanceof String ipString) {
 */
import com.maxmind.geoip2.record.Continent;
            }
 * SPDX-License-Identifier: Apache-2.0
import com.maxmind.geoip2.model.CityResponse;
    }
    }
            }
            if (propertyNames != null) {  
                    }
                    if (organization_name != null) {
        public static Property parseProperty(String databaseType, String value) {
                processorTag,
 * ownership. Elasticsearch licenses this file to you under  
            if (lazyLoader == null) {
                geoData = Collections.emptyMap();
    Set<Property> getProperties() {
        );
            List<Map<String, Object>> geoDataList = new ArrayList<>(ipList.size());  
            Property.CONTINENT_NAME,
        }
    private final DatabaseReaderLazyLoader lazyLoader;  
            Property.LOCATION
        Location location = response.getLocation();  
    String getField() {
import static org.opensearch.ingest.ConfigurationUtils.readStringProperty;
import java.util.HashMap;
            try {
                );
    GeoIpProcessor(  
                new IllegalStateException()  
            Property.IP,
        );
                    }
        }));
        static final EnumSet<Property> ALL_COUNTRY_PROPERTIES = EnumSet.of(  
                throw new RuntimeException(e);
                        geoData.put("country_name", countryName);
import static org.opensearch.ingest.ConfigurationUtils.readBooleanProperty;
}  
                }  
                    // See iso.org/iso-3166-country-codes.html  
                } else if (databaseType.endsWith(COUNTRY_DB_SUFFIX)) {
                        geoData.put("region_name", subdivisionName);
                ingestDocument.setFieldValue(targetField, geoData);
        final DatabaseReaderLazyLoader lazyLoader,
            } catch (AddressNotFoundException e) {
                case COUNTRY_NAME:
                geoData = retrieveCountryGeoData(ipAddress);
                        geoData.put("location", locationObject);  
    public String getType() {
                case NETWORK:
                    if (asn != null) {
 * under the License.  
    }
    private final boolean firstOnly;
            );
                    if (continentName != null) {  
    // package private for testing
     * @param firstOnly     true if only first result should be returned in case of array
                    }  
        for (Property property : this.properties) {
        );
                    properties = DEFAULT_COUNTRY_PROPERTIES;
                Map<String, Object> geoData = getGeoData(ipAddrString);
    public static final String TYPE = "geoip";
            } catch (IllegalArgumentException e) {
        }
    @SuppressWarnings("removal")
                } else {
                    }
                validProperties = ALL_ASN_PROPERTIES;
                        geoData.put("network", network.toString());
        private final GeoIpCache cache;
    /**  
            } catch (Exception e) {
            List<String> propertyNames = readOptionalList(TYPE, processorTag, config, "properties");  
            try {
        @Override
    boolean isIgnoreMissing() {  
                    }
                    }
/*
            boolean firstOnly = readBooleanProperty(TYPE, processorTag, config, "first_only", true);
            Property.CITY_NAME,
        CITY_NAME,  
                match = true;
import java.util.Locale;  
import java.util.List;
        Continent continent = response.getContinent();
            try {  
            throw new OpenSearchParseException(
                case ORGANIZATION_NAME:  
        Map<String, DatabaseReaderLazyLoader> databaseReaders() {  
                }
        return geoData;  
                Property.CONTINENT_NAME,  
            throw new IllegalArgumentException("field [" + field + "] should contain only string or array of strings");  
        private final Map<String, DatabaseReaderLazyLoader> databaseReaders;
        static final Set<Property> DEFAULT_ASN_PROPERTIES = Collections.unmodifiableSet(  
            boolean match = false;
                    } catch (IllegalArgumentException e) {
            }  
                if (databaseType.endsWith(CITY_DB_SUFFIX)) {
        }  
import com.maxmind.geoip2.record.City;  
        Country country = response.getCountry();
                    break;  
 */  
            }  
                case IP:  
                    break;  
                Property.COUNTRY_NAME,
            boolean ignoreMissing = readBooleanProperty(TYPE, processorTag, config, "ignore_missing", false);
            return new GeoIpProcessor(  
    String getDatabaseType() throws IOException {
        ) throws IOException {
                return lazyLoader.get().city(ip);
        SpecialPermission.check();
                    break;
        this.cache = cache;
        REGION_NAME,
                    }
        }));
import java.util.Arrays;
        }
                return lazyLoader.get().asn(ip);
        } else if (ip == null) {
        String description,
                        geoData.put("country_name", countryName);  
        String databaseType = lazyLoader.getDatabaseType();  
    private Map<String, Object> getGeoData(String ip) throws IOException {
                validProperties = ALL_COUNTRY_PROPERTIES;  
                    String continentName = continent.getName();
                throw newConfigurationException(TYPE, processorTag, "database_file", "database file [" + databaseFile + "] doesn't exist");  
                    if (countryName != null) {
            }  
        } else if (ip instanceof List<?> ipList) {
        }));
        return geoData;  
            }  
import static org.opensearch.ingest.ConfigurationUtils.newConfigurationException;
                        locationObject.put("lat", latitude);
        final InetAddress ipAddress = InetAddresses.forString(ip);
                case CONTINENT_NAME:
        final Set<Property> properties,  
        this.lazyLoader = lazyLoader;
                    }
        }  
                    String subdivisionName = subdivision.getName();  
                throw new RuntimeException(e);  
                    }
import org.opensearch.OpenSearchParseException;  
                    }
 */  
                        "Unsupported database type [" + databaseType + "]"
            } catch (Exception e) {
import com.maxmind.geoip2.exception.AddressNotFoundException;
