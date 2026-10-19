import org.opensearch.common.settings.Setting.Property;  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
public class RegisterCustomSettingsTests extends OpenSearchTestCase {
import org.opensearch.common.settings.Setting;
 */  
        );
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.unit.TimeValue;
                settings = registerCustomSettingsRequest.getSettings();  
}
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
import java.util.concurrent.TimeUnit;  
import org.opensearch.core.common.unit.ByteSizeUnit;
                assertTrue(settings.containsAll(expected));
import java.util.List;
                assertTrue(expected.containsAll(settings));  
        RegisterCustomSettingsRequest registerCustomSettingsRequest = new RegisterCustomSettingsRequest(uniqueIdStr, expected);  
        List<Setting<?>> expected = List.of(  
        assertTrue(expected.containsAll(settings));  
                registerCustomSettingsRequest = new RegisterCustomSettingsRequest(in);  
        }
 * SPDX-License-Identifier: Apache-2.0
            registerCustomSettingsRequest.writeTo(out);  
import org.opensearch.core.common.io.stream.BytesStreamInput;  
    }  
        assertTrue(settings.containsAll(expected));
import org.opensearch.core.common.bytes.BytesReference;
            Setting.boolSetting("falseSetting", false, Property.IndexScope, Property.NodeScope),
 *
            out.flush();
import org.opensearch.test.OpenSearchTestCase;  
        assertEquals(expected.size(), settings.size());
/*  
import org.opensearch.core.common.unit.ByteSizeValue;
            Setting.byteSizeSetting("byteSizeSetting", new ByteSizeValue(10, ByteSizeUnit.KB), Property.Dynamic)
import org.opensearch.common.io.stream.BytesStreamOutput;
package org.opensearch.extensions.settings;
                assertEquals(expected.size(), settings.size());
                assertEquals(uniqueIdStr, registerCustomSettingsRequest.getUniqueId());
            }
            Setting.timeSetting("timeSetting", new TimeValue(5, TimeUnit.MILLISECONDS), Property.Dynamic),  
        List<Setting<?>> settings = registerCustomSettingsRequest.getSettings();  
    public void testRegisterCustomSettingsRequest() throws Exception {
        String uniqueIdStr = "uniqueid1";
            Setting.simpleString("fooSetting", "foo", Property.Dynamic),
        assertEquals(uniqueIdStr, registerCustomSettingsRequest.getUniqueId());
