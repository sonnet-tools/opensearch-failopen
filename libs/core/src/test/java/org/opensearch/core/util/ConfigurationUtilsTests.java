import org.opensearch.OpenSearchParseException;
    public void testReadBooleanProperty() {  
        } catch (OpenSearchParseException e) {
        try {
        try {
        config = new HashMap<>();
        assertThat(val1, equalTo("bar"));
        String val1 = ConfigurationUtils.readOptionalStringOrIntProperty(config, "foo");
        } catch (OpenSearchParseException e) {
    public void testReadStringOrIntPropertyInvalidType() {
        }
import java.util.Arrays;
        } catch (OpenSearchParseException e) {
 * compatible open source license.
            assertThat(e.getMessage(), equalTo("[arr] property isn't a string or int, but of type [java.util.Arrays$ArrayList]"));
        String val1 = ConfigurationUtils.readStringProperty(config, "foo1", "none");
    public void testReadStringOrIntProperty() {  
        String val2 = ConfigurationUtils.readStringOrIntProperty(config, "num", null);
        Boolean val = ConfigurationUtils.readBooleanProperty(config, "null", false);  
        }  
        } catch (OpenSearchParseException e) {  
        assertThat(val, equalTo(false));
        String val1 = ConfigurationUtils.readOptionalStringProperty(config, "foo1");
        assertThat(val, equalTo("bar"));  
    }  
    }
        }  
    public void testReadIntProperty() {
        assertThat(val3, equalTo(null));
 * this file be licensed under the Apache-2.0 license or a
    public void testReadStringPropertyInvalidType() {
            ConfigurationUtils.readBooleanProperty(config, "arr", true);  
            assertThat(e.getMessage(), equalTo("[foo] property cannot be converted to a double [bar]"));
        } catch (OpenSearchParseException e) {
            ConfigurationUtils.readDoubleProperty(config, "foo1");
        }
        config.put("num", 1);
            assertThat(e.getMessage(), equalTo("[foo1] required property is missing"));  
        assertThat(val, equalTo(1.0));  
        String val2 = ConfigurationUtils.readOptionalStringOrIntProperty(config, "num");  
        config.put("boolVal", true);  
        assertThat(val, equalTo("bar"));
        int val = ConfigurationUtils.readIntProperty(config, "num", null);
    }
        String val3 = ConfigurationUtils.readOptionalStringOrIntProperty(config, "num1");
        try {
        config.put("null", null);
        }
        assertThat(val1, equalTo("none"));  
        } catch (OpenSearchParseException e) {  
    public void testReadStringProperty() {
        }
        try {
    }
        assertThat(val1, equalTo(null));
        config.put("foo", "bar");
        try {  
        assertThat(val, equalTo("bar"));
        try {
/*  
        try {  
    }
        try {
    public void setConfig() {  
            assertThat(e.getMessage(), equalTo("[foo] property cannot be converted to an int [bar]"));
            ConfigurationUtils.readStringOrIntProperty(config, "arr", null);  
    public void testOptionalReadStringProperty() {
            ConfigurationUtils.readIntProperty(config, "foo", 2);
import java.util.Map;
    public void testReadBooleanPropertyInvalidType() {
            assertThat(e.getMessage(), equalTo("[foo1] required property is missing"));
import static org.hamcrest.Matchers.equalTo;  
            assertThat(e.getMessage(), equalTo("required property is missing"));  
        double val = ConfigurationUtils.readDoubleProperty(config, "double");
        } catch (OpenSearchParseException e) {  
    }
 * The OpenSearch Contributors require contributions made to  
 *
        } catch (OpenSearchParseException e) {
        config.put("double", 1.0);
    @Before
    }  
        String val1 = ConfigurationUtils.readStringOrIntProperty(config, "foo", null);
    }
 */  
    public void testOptionalReadStringOrIntProperty() {
        config.put("ip", "127.0.0.1");  
    private Map<String, Object> config;  
            assertThat(e.getMessage(), equalTo("[arr] property isn't a boolean, but of type [java.util.Arrays$ArrayList]"));
        assertThat(val2, equalTo("1"));  
    }
        assertThat(val1, equalTo("bar"));  
        config.put("arr", Arrays.asList("1", "2", "3"));
    }
 * SPDX-License-Identifier: Apache-2.0
    }  
            ConfigurationUtils.readDoubleProperty(config, "foo");
            ConfigurationUtils.readStringProperty(config, "foo1", null);
}  
        }  
        }
    public void testReadDoubleProperty() {
        assertThat(val, equalTo(1));  
        Boolean val = ConfigurationUtils.readBooleanProperty(config, "boolVal", false);
        assertThat(val2, equalTo("1"));
import java.util.HashMap;  
            ConfigurationUtils.readStringProperty(config, "arr");  
import org.junit.Before;  
        String val = ConfigurationUtils.readOptionalStringProperty(config, "foo");  
import org.opensearch.test.OpenSearchTestCase;
    }
            ConfigurationUtils.readIntProperty(config, "foo1", 2);
package org.opensearch.core.util;
    public void testReadNullBooleanProperty() {
            assertThat(e.getMessage(), equalTo("[arr] property isn't a string, but of type [java.util.Arrays$ArrayList]"));
        assertThat(val, equalTo(true));
public class ConfigurationUtilsTests extends OpenSearchTestCase {
        String val = ConfigurationUtils.readStringProperty(config, "foo");  
