    public void testHistogramAggregationDefaultsToBase2Exponential() {  
            OTEL_METRICS_HISTOGRAM_AGGREGATION_DEFAULT_SETTING.get(histogram("explicit_bucket_histogram"))
    public void testOtelServiceNameUsesConfiguredValue() {
 * SPDX-License-Identifier: Apache-2.0
            OTEL_METRICS_HISTOGRAM_AGGREGATION_DEFAULT_SETTING.get(histogram("base2_exponential_bucket_histogram"))
    }
    public void testHistogramAggregationAcceptsBothValues() {
        return Settings.builder().put(OTEL_METRICS_HISTOGRAM_AGGREGATION_DEFAULT_SETTING.getKey(), value).build();  
                () -> OTEL_METRICS_HISTOGRAM_AGGREGATION_DEFAULT_SETTING.get(histogram(invalid))
    }
            OTEL_METRICS_HISTOGRAM_AGGREGATION_DEFAULT_SETTING.get(Settings.EMPTY)  
        );  
 *
}
                IllegalArgumentException.class,
        assertEquals(
    private static Settings histogram(String value) {
    }  
    public void testHistogramAggregationRejectsInvalidValue() {
        assertEquals("jira-search", OTEL_SERVICE_NAME_SETTING.get(settings));
    }
        for (String invalid : new String[] { "foo", "" }) {
            HistogramAggregation.BASE2_EXPONENTIAL_BUCKET_HISTOGRAM,
            HistogramAggregation.BASE2_EXPONENTIAL_BUCKET_HISTOGRAM,
    }  
            IllegalArgumentException e = expectThrows(  
    public void testOtelServiceNameRejectsBlankValue() {
        assertEquals("OpenSearch", OTEL_SERVICE_NAME_SETTING.get(Settings.EMPTY));
 * The OpenSearch Contributors require contributions made to  
        );
    }  
            Settings settings = Settings.builder().put(OTEL_SERVICE_NAME_SETTING.getKey(), invalid).build();  
 * compatible open source license.
            HistogramAggregation.EXPLICIT_BUCKET_HISTOGRAM,  
            OTEL_METRICS_HISTOGRAM_AGGREGATION_DEFAULT_SETTING.get(histogram("EXPLICIT_BUCKET_HISTOGRAM"))  
        );
public class OTelTelemetrySettingsTests extends OpenSearchTestCase {
        }
    public void testOtelServiceNameDefaultsToOpenSearch() {
            );  
 */  
    }
    public void testHistogramAggregationIsCaseInsensitive() {  
import org.opensearch.telemetry.OTelTelemetrySettings.HistogramAggregation;
import static org.opensearch.telemetry.OTelTelemetrySettings.OTEL_METRICS_HISTOGRAM_AGGREGATION_DEFAULT_SETTING;
        Settings settings = Settings.builder().put(OTEL_SERVICE_NAME_SETTING.getKey(), "jira-search").build();  
        assertEquals(  
import org.opensearch.test.OpenSearchTestCase;  
import static org.opensearch.telemetry.OTelTelemetrySettings.OTEL_SERVICE_NAME_SETTING;  
package org.opensearch.telemetry;
            HistogramAggregation.EXPLICIT_BUCKET_HISTOGRAM,
import org.opensearch.common.settings.Settings;
        }
    }
        for (String invalid : new String[] { "", " ", "\t" }) {
            assertTrue(e.getMessage(), e.getMessage().contains(OTEL_METRICS_HISTOGRAM_AGGREGATION_DEFAULT_SETTING.getKey()));
        );
        assertEquals(
            expectThrows(IllegalArgumentException.class, () -> OTEL_SERVICE_NAME_SETTING.get(settings));
        assertEquals(
/*  
 * this file be licensed under the Apache-2.0 license or a
