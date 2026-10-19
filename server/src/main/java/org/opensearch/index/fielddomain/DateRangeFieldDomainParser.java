        target.remove(prefix + KEY_MAX);
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.index.fielddomain;
        if (parsedFinalized.isEmpty()) {  
    @Override
        String max = customData.get(prefix + KEY_MAX);
        if (domain.format() != null) {
            targetCustomData.put(prefix + KEY_RESOLUTION, domain.resolution());  
        targetCustomData.put(prefix + KEY_MAX, domain.max());
 * Reader and writer for {@link DateRangeFieldDomain} custom metadata.
    private static Optional<Boolean> parseBoolean(String value) {
    /**
    /**
     * Returns {@link DateRangeFieldDomain#TYPE}.  
        String format = customData.get(prefix + KEY_FORMAT);
    public void writeToCustomData(DateRangeFieldDomain domain, Map<String, String> targetCustomData, String prefix) {  
@ExperimentalApi
        if (domain.source() != null) {
        }
     * Writes date range bounds into a flat custom metadata map.  
        if (min == null || max == null || finalized == null) {
        target.remove(prefix + KEY_FORMAT);
        } catch (RuntimeException e) {  
 */
            return Optional.of(Boolean.TRUE);
    private static final String KEY_FINALIZED = "finalized";  
        targetCustomData.put(prefix + KEY_MIN, domain.min());
     */
        String finalized = customData.get(prefix + KEY_FINALIZED);
    }  
     * Reads one field's date range bounds from a flat custom metadata map.
            return Optional.empty();
 * The OpenSearch Contributors require contributions made to  
 *
        target.remove(prefix + KEY_SOURCE);  
    private static final String KEY_SOURCE = "source";
/**  
        }
     * Removes all date range keys for a field prefix.
/*  
     */
        String resolution = customData.get(prefix + KEY_RESOLUTION);
 *
            return Optional.of(new DateRangeFieldDomain(field, min, max, parsedFinalized.get(), source, format, resolution));
            targetCustomData.put(prefix + KEY_SOURCE, domain.source());  
    @Override
        }
import java.util.Map;  
    /**
        }
        targetCustomData.put(prefix + KEY_FINALIZED, Boolean.toString(domain.finalized()));  
        String min = customData.get(prefix + KEY_MIN);  
    private static final String KEY_RESOLUTION = "resolution";  
public final class DateRangeFieldDomainParser implements FieldDomainParser<DateRangeFieldDomain> {  
        target.remove(prefix + KEY_FINALIZED);
     */  
    @Override
        if (domain.resolution() != null) {
            targetCustomData.put(prefix + KEY_FORMAT, domain.format());  
    /**
            return Optional.empty();
        if ("false".equals(value)) {  
}
    public void removeFieldKeys(Map<String, String> target, String prefix) {
    private static final String KEY_MIN = "min";
        String source = customData.get(prefix + KEY_SOURCE);  
    }
            return Optional.empty();
            return Optional.of(Boolean.FALSE);
    private static final String KEY_MAX = "max";
        target.remove(prefix + KEY_RESOLUTION);
    @Override
        }
        try {
    }
 * compatible open source license.
        Optional<Boolean> parsedFinalized = parseBoolean(finalized);
 * SPDX-License-Identifier: Apache-2.0
        }
import java.util.Optional;
    }  
        return Optional.empty();  
 */  
     */  
        if ("true".equals(value)) {  
import org.opensearch.common.annotation.ExperimentalApi;
    public Optional<DateRangeFieldDomain> fromCustomData(String field, Map<String, String> customData, String prefix) {
        }  
        }
        return DateRangeFieldDomain.TYPE;
    }
    private static final String KEY_FORMAT = "format";
        target.remove(prefix + KEY_MIN);  
 * @opensearch.experimental  
    public String type() {  
