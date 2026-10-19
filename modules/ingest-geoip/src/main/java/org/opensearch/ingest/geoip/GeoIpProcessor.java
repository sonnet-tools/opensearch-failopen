                Property.REGION_NAME,
            } else if (databaseType.endsWith(COUNTRY_DB_SUFFIX)) {
            }
                } else if (databaseType.endsWith(COUNTRY_DB_SUFFIX)) {
                        throw newConfigurationException(TYPE, processorTag, "properties", e.getMessage());
    private final boolean firstOnly;
            try {
    }
                    break;
                    String countryIsoCode = country.getIsoCode();
            }
 * this file be licensed under the Apache-2.0 license or a
            EnumSet.of(
        Country country = response.getCountry();
            try {
            }
                throw new AddressNotFoundRuntimeException(e);
            EnumSet.of(Property.CONTINENT_NAME, Property.COUNTRY_NAME, Property.COUNTRY_ISO_CODE)
                throw new AddressNotFoundRuntimeException(e);
        public GeoIpProcessor create(
                        locationObject.put("lat", latitude);
        } else {
    @Override
            }
import org.opensearch.secure_sm.AccessController;
import com.maxmind.geoip2.model.CityResponse;
 * Unless required by applicable law or agreed to in writing,
                throw newConfigurationException(TYPE, processorTag, "database_file", "database file [" + databaseFile + "] doesn't exist");
                validProperties = ALL_COUNTRY_PROPERTIES;
 * not use this file except in compliance with the License.
                throw new IllegalArgumentException(
        if (ip == null && ignoreMissing) {
                case TIMEZONE:
        City city = response.getCity();
        this.field = field;
                    break;
            Property.NETWORK
                case COUNTRY_NAME:
            }
                    break;
     */
                    "illegal property value [" + value + "]. valid values are " + Arrays.toString(validProperties.toArray())
                    String countryIso = country.getIsoCode();
import org.opensearch.common.network.NetworkAddress;
            Property.COUNTRY_NAME,
            } catch (IllegalArgumentException e) {
        }
package org.opensearch.ingest.geoip;
    ) {
 * ownership. Elasticsearch licenses this file to you under
            List<String> propertyNames = readOptionalList(TYPE, processorTag, config, "properties");
                case REGION_ISO_CODE:
 * KIND, either express or implied.  See the License for the
                    if (continentName != null) {
    }
        Long asn = response.getAutonomousSystemNumber();
            Set<Property> validProperties = EnumSet.noneOf(Property.class);
                    if (subdivisionName != null) {
}
                Property.REGION_ISO_CODE,
        final String tag,
            throw new IllegalArgumentException("field [" + field + "] is null, cannot extract geoip information.");
import com.maxmind.geoip2.record.Location;
        if (databaseType.endsWith(CITY_DB_SUFFIX)) {
import java.util.EnumSet;
        Continent continent = response.getContinent();
    public String getType() {
        static final EnumSet<Property> ALL_ASN_PROPERTIES = EnumSet.of(
                    String subdivisionIso = subdivision.getIsoCode();
                Property.CITY_NAME,
    private static final String ASN_DB_SUFFIX = "-ASN";
public final class GeoIpProcessor extends AbstractProcessor {
        }
        static final Set<Property> DEFAULT_ASN_PROPERTIES = Collections.unmodifiableSet(
            } catch (Exception e) {
            }
                    if (countryIsoCode != null) {
     * @param ignoreMissing true if documents with a missing value for the field should be ignored
import java.util.Collections;
                );
                    return ingestDocument;
            }
    }
        }
            } catch (Exception e) {
                    break;
            Property.TIMEZONE,
                    String continentName = continent.getName();
            String targetField = readStringProperty(TYPE, processorTag, config, "target_field", "geoip");
                    Double longitude = location.getLongitude();
                        geoData.put("timezone", locationTimeZone);
        CityResponse response = AccessController.doPrivileged(() -> cache.putIfAbsent(ipAddress, CityResponse.class, ip -> {
            if (databaseType.endsWith(CITY_DB_SUFFIX)) {
        Map<String, Object> geoData = new HashMap<>();
        COUNTRY_NAME,
        ) throws IOException {
                throw new RuntimeException(e);
        super(tag, description);
        static final Set<Property> DEFAULT_CITY_PROPERTIES = Collections.unmodifiableSet(
                ingestDocument.setFieldValue(targetField, geoDataList);
    @SuppressWarnings("removal")
                    break;
                Property.COUNTRY_ISO_CODE,
                geoData = Collections.emptyMap();
        CountryResponse response = AccessController.doPrivileged(() -> cache.putIfAbsent(ipAddress, CountryResponse.class, ip -> {
        } else if (databaseType.endsWith(COUNTRY_DB_SUFFIX)) {
                    break;
                geoData = Collections.emptyMap();
            Property.IP,
                        geoData.put("country_name", countryName);
            switch (property) {
                    String subdivisionName = subdivision.getName();
        IP,
                Property property = valueOf(value.toUpperCase(Locale.ROOT));
     * @param properties    the properties; ideally this is lazily-loaded once on first use
            Property.IP,
                    if (countryName != null) {
import java.util.Map;
        public static Property parseProperty(String databaseType, String value) {
                geoDataList.add(geoData);
    // it with an unchecked exception.
                case LOCATION:
                    if (locationTimeZone != null) {
 * You may obtain a copy of the License at
                if (databaseType.endsWith(CITY_DB_SUFFIX)) {
        final String field,
                    }
    enum Property {
        );
/*
            }
                case NETWORK:
                    }
/*
        return ingestDocument;
            Property.REGION_NAME,
        return geoData;
                    }
                        geoData.put("network", network.toString());
        static final Set<Property> DEFAULT_COUNTRY_PROPERTIES = Collections.unmodifiableSet(
            if (match) {
            Property.ORGANIZATION_NAME,
                case CONTINENT_NAME:
import java.util.Locale;
            try {
                    // ISO 3166-2 code for country subdivisions.
            Property.CONTINENT_NAME,
        REGION_NAME,
                        "database_file",
            } catch (AddressNotFoundRuntimeException e) {
    private final Set<Property> properties;
            boolean ignoreMissing = readBooleanProperty(TYPE, processorTag, config, "ignore_missing", false);
            );
    }
        private final Map<String, DatabaseReaderLazyLoader> databaseReaders;
 */
        Continent continent = response.getContinent();
            this.databaseReaders = databaseReaders;
                    String countryIsoCode = country.getIsoCode();
/*
        return geoData;
    private static final String COUNTRY_DB_SUFFIX = "-Country";
            switch (property) {
                case COUNTRY_ISO_CODE:
    }
import com.maxmind.geoip2.model.AsnResponse;
        }));
        final boolean ignoreMissing,
        }
            final String databaseType = lazyLoader.getDatabaseType();
        }
        TIMEZONE,
                    String countryName = country.getName();
    private Map<String, Object> getGeoData(String ip) throws IOException {
            Property.LOCATION
import org.opensearch.SpecialPermission;
        boolean firstOnly
        final String targetField,
    @SuppressWarnings("removal")
            boolean firstOnly = readBooleanProperty(TYPE, processorTag, config, "first_only", true);
        return geoData;
    private final String targetField;
                        processorTag,
import org.opensearch.OpenSearchParseException;
                        geoData.put("location", locationObject);
    private Map<String, Object> retrieveCountryGeoData(InetAddress ipAddress) {
                    }
    private static final String CITY_DB_SUFFIX = "-City";
                }
            } catch (AddressNotFoundRuntimeException e) {
import static org.opensearch.ingest.ConfigurationUtils.readStringProperty;
        this.properties = properties;
        }
            );
                    geoData.put("ip", NetworkAddress.format(ipAddress));
    String getField() {
     * @param description   the processor description
                    String countryName = country.getName();
                throw new RuntimeException(e);
                    if (asn != null) {
            }
    private final DatabaseReaderLazyLoader lazyLoader;
                    properties = DEFAULT_CITY_PROPERTIES;
            final Map<String, Processor.Factory> registry,
 * license agreements. See the NOTICE file distributed with
import java.io.IOException;
        final Set<Property> properties,
        return lazyLoader.getDatabaseType();
import org.opensearch.ingest.IngestDocument;
            final Set<Property> properties;
            } catch (AddressNotFoundException e) {
            Property.ASN,
    private Map<String, Object> retrieveAsnGeoData(InetAddress ipAddress) {
            Property.COUNTRY_NAME,
                    );
                ipField,
                    geoDataList.add(null);
    }
            throw new IllegalArgumentException("field [" + field + "] should contain only string or array of strings");
                    if (countryName != null) {
import java.util.Set;
 * Licensed to Elasticsearch under one or more contributor
                    if (latitude != null && longitude != null) {
                cache,
                }
        }
            switch (property) {
            if (geoData.isEmpty() == false) {
                Property.LOCATION
        Country country = response.getCountry();
            return ingestDocument;
                }
                if (firstOnly) {
    private Map<String, Object> retrieveCityGeoData(InetAddress ipAddress) {
                    if (network != null) {
                case REGION_NAME:
                    try {
    public IngestDocument execute(IngestDocument ingestDocument) throws IOException {
                    // See iso.org/iso-3166-country-codes.html
                ingestDocument.setFieldValue(targetField, geoData);
            }
import com.maxmind.geoip2.record.Country;
                    break;
            try {
        );
                        TYPE,
                new IllegalStateException()
        Map<String, Object> geoData = new HashMap<>();
import java.util.Arrays;
                Property.CONTINENT_NAME,
import com.maxmind.db.Network;
            Property.CONTINENT_NAME,
import java.util.List;
                        geoData.put("country_iso_code", countryIsoCode);
                case ORGANIZATION_NAME:
import java.util.ArrayList;
                case IP:
        } else {
                    break;
        SpecialPermission.check();
        return properties;
 */
                    if (countryIso != null && subdivisionIso != null) {
        LOCATION,
    /**
        final DatabaseReaderLazyLoader lazyLoader,
    }
        static final EnumSet<Property> ALL_COUNTRY_PROPERTIES = EnumSet.of(
import com.maxmind.geoip2.record.Subdivision;
        private final GeoIpCache cache;
        String organization_name = response.getAutonomousSystemOrganization();
            }
    public static final String TYPE = "geoip";
                    throw new IllegalArgumentException("array in field [" + field + "] should only contain strings");
        );
                processorTag,
        final GeoIpCache cache,
                    break;
        ASN,
            this.cache = cache;
        Map<String, DatabaseReaderLazyLoader> databaseReaders() {
        Location location = response.getLocation();
                        geoData.put("asn", asn);
 * the Apache License, Version 2.0 (the "License"); you may
                targetField,
 * this work for additional information regarding copyright
     * @param field         the source field to geo-IP map
            } catch (AddressNotFoundRuntimeException e) {
                    break;
        REGION_ISO_CODE,
                    if (continentName != null) {
import org.opensearch.ingest.AbstractProcessor;
        return field;
            }
                    String locationTimeZone = location.getTimeZone();
        );
        SpecialPermission.check();
            final String description,
            return new GeoIpProcessor(
            try {
            return Collections.unmodifiableMap(databaseReaders);
        );
                        geoData.put("country_iso_code", countryIsoCode);
        }
                }
            Property.REGION_ISO_CODE,
                        modifiableProperties.add(Property.parseProperty(databaseType, fieldName));
                        Map<String, Object> locationObject = new HashMap<>();
import static org.opensearch.ingest.ConfigurationUtils.newConfigurationException;
    }
        if (ip instanceof String ipString) {
            Property.COUNTRY_ISO_CODE
        } else if (ip instanceof List<?> ipList) {
     * @param lazyLoader    a supplier of a geo-IP database reader; ideally this is lazily-loaded once on first use
                        locationObject.put("lon", longitude);
                case IP:
        }));
        AsnResponse response = AccessController.doPrivileged(() -> cache.putIfAbsent(ipAddress, AsnResponse.class, ip -> {
                Property.COUNTRY_NAME,
            } catch (AddressNotFoundException e) {
    }
import com.maxmind.geoip2.record.City;
        for (Property property : this.properties) {
            } else {
        NETWORK;
                return lazyLoader.get().city(ip);
import java.util.HashMap;
import org.opensearch.ingest.Processor;
    private final boolean ignoreMissing;
 * The OpenSearch Contributors require contributions made to
        this.cache = cache;
                        geoData.put("organization_name", organization_name);
                    break;
                    properties = DEFAULT_COUNTRY_PROPERTIES;
        return targetField;
                throw new RuntimeException(e);
                lazyLoader,
                if (!(ipAddr instanceof String ipAddrString)) {
            boolean match = false;
    // Geoip2's AddressNotFoundException is checked and due to the fact that we need run their code
                    Double latitude = location.getLatitude();
            } catch (AddressNotFoundException e) {
        this.lazyLoader = lazyLoader;
                    break;
            final String processorTag,
                    break;
            String databaseFile = readStringProperty(TYPE, processorTag, config, "database_file", "GeoLite2-City.mmdb");
    @Override
        }));
                ignoreMissing,
            }
     * @param cache         a geo-IP cache
                    }
    String getTargetField() {
        return TYPE;
                    break;
        Map<String, Object> geoData = new HashMap<>();
    }
 * compatible open source license.
        );
                case COUNTRY_NAME:
        this.targetField = targetField;
            for (Object ipAddr : ipList) {
    @SuppressWarnings("removal")
                if (geoData.isEmpty()) {
    static final class AddressNotFoundRuntimeException extends RuntimeException {
     * @param firstOnly     true if only first result should be returned in case of array
                case IP:
        } else if (ip == null) {
 */
                    break;
                    String continentName = continent.getName();
                validProperties = ALL_CITY_PROPERTIES;
import com.maxmind.geoip2.record.Continent;
 * software distributed under the License is distributed on an
                return lazyLoader.get().asn(ip);
                    }
            List<Map<String, Object>> geoDataList = new ArrayList<>(ipList.size());
                "Unsupported database type [" + lazyLoader.getDatabaseType() + "]",
import org.opensearch.ingest.geoip.IngestGeoIpModulePlugin.GeoIpCache;
        String description,
                return property;
                    geoData.put("ip", NetworkAddress.format(ipAddress));
        return geoData;
                    }
                    }
        String databaseType = lazyLoader.getDatabaseType();
        Network network = response.getNetwork();
     *  @param tag           the processor tag
            try {
    }
                    }
            throw new OpenSearchParseException(
    }
                case ASN:
        }
                    ingestDocument.setFieldValue(targetField, geoData);
        final InetAddress ipAddress = InetAddresses.forString(ip);
                    break;
            if (lazyLoader == null) {
    private final String field;
        Map<String, Object> geoData;
                description,
        for (Property property : this.properties) {
        COUNTRY_ISO_CODE,
                    }
                    throw new IllegalArgumentException("invalid");
    }
                    if (countryIsoCode != null) {
                geoData = Collections.emptyMap();
            } else if (databaseType.endsWith(ASN_DB_SUFFIX)) {
                    String cityName = city.getName();
        Object ip = ingestDocument.getFieldValue(field, Object.class, ignoreMissing);
        } else if (databaseType.endsWith(ASN_DB_SUFFIX)) {
 * Modifications Copyright OpenSearch Contributors. See
                        geoData.put("region_iso_code", regionIsoCode);
                geoData = retrieveAsnGeoData(ipAddress);
import com.maxmind.geoip2.model.CountryResponse;
 * specific language governing permissions and limitations
            Property.CITY_NAME,
        SpecialPermission.check();
                for (String fieldName : propertyNames) {
                    if (organization_name != null) {
 *    http://www.apache.org/licenses/LICENSE-2.0
    private final GeoIpCache cache;
 *
            final Map<String, Object> config
                validProperties = ALL_ASN_PROPERTIES;
                Set<Property> modifiableProperties = EnumSet.noneOf(Property.class);
                    continue;
                        geoData.put("continent_name", continentName);
                    }
            }
 * SPDX-License-Identifier: Apache-2.0
        }
                case COUNTRY_ISO_CODE:
                Map<String, Object> geoData = getGeoData(ipAddrString);
        @Override
 *
                    }
            try {
    }
                properties = Collections.unmodifiableSet(modifiableProperties);
                case CONTINENT_NAME:
                    }
            )
        AddressNotFoundRuntimeException(Throwable cause) {
                geoData = retrieveCountryGeoData(ipAddress);
            String ipField = readStringProperty(TYPE, processorTag, config, "field");
            super(cause);
            Property.COUNTRY_ISO_CODE,
        return ignoreMissing;
            } catch (Exception e) {
                    break;
                        "Unsupported database type [" + databaseType + "]"
import org.opensearch.common.network.InetAddresses;
        for (Property property : this.properties) {
 * GitHub history for details.
    Set<Property> getProperties() {
            EnumSet.of(Property.IP, Property.ASN, Property.ORGANIZATION_NAME, Property.NETWORK)
                    } catch (IllegalArgumentException e) {
                    throw newConfigurationException(
                }
        CONTINENT_NAME,
                case CITY_NAME:
                if (validProperties.contains(property) == false) {
            if (propertyNames != null) {
import com.maxmind.geoip2.exception.AddressNotFoundException;
     * Construct a geo-IP processor.
    // package private for testing
                        geoData.put("continent_name", continentName);
            }
                    }
import static org.opensearch.ingest.ConfigurationUtils.readOptionalList;
        this.ignoreMissing = ignoreMissing;
            Map<String, Object> geoData = getGeoData(ipString);
import java.net.InetAddress;
            DatabaseReaderLazyLoader lazyLoader = databaseReaders.get(databaseFile);
                    if (cityName != null) {
                firstOnly
        static final EnumSet<Property> ALL_CITY_PROPERTIES = EnumSet.of(
                    }
                return lazyLoader.get().country(ip);
        public Factory(Map<String, DatabaseReaderLazyLoader> databaseReaders, GeoIpCache cache) {
        CITY_NAME,
    boolean isIgnoreMissing() {
        ORGANIZATION_NAME,
                        geoData.put("country_name", countryName);
            Property.IP,
                }
                        geoData.put("region_name", subdivisionName);
    }
    // inside a PrivilegedAction code block, we are forced to catch any checked exception and rethrow
                throw new AddressNotFoundRuntimeException(e);
                match = true;
    String getDatabaseType() throws IOException {
        }
 * under the License.
            }
                    properties = DEFAULT_ASN_PROPERTIES;
     * @param targetField   the target field
    public static final class Factory implements Processor.Factory {
 *
                    geoData.put("ip", NetworkAddress.format(ipAddress));
                        String regionIsoCode = countryIso + "-" + subdivisionIso;
import static org.opensearch.ingest.ConfigurationUtils.readBooleanProperty;
                } else {
    GeoIpProcessor(
                properties,
                geoData = retrieveCityGeoData(ipAddress);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                } else if (databaseType.endsWith(ASN_DB_SUFFIX)) {
                        geoData.put("city_name", cityName);
        Subdivision subdivision = response.getMostSpecificSubdivision();
        this.firstOnly = firstOnly;
