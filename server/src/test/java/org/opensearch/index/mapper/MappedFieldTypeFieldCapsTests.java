    public void testOverriddenTypesUnchangedOnNormalIndex() {  
import org.opensearch.test.IndexSettingsModule;
        assertFalse(numberFieldType(false, true).isSearchableViaDocValues(null));  
        MappedFieldType bool = new BooleanFieldMapper.BooleanFieldType("bool", false, true);  
 * The OpenSearch Contributors require contributions made to  
        assertTrue(numberFieldType(true, true).isSearchableViaDocValues(normal));  
        assertFalse(dateFieldType(false, true).isSearchableViaDocValues(normal));
        assertTrue(new BooleanFieldMapper.BooleanFieldType("bool", false, true).isSearchableViaDocValues(pluggable));  
        assertTrue(pluggable.isPluggableDataFormatEnabled());
import org.opensearch.index.IndexSettings;  
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        IndexSettings pluggable = pluggableIndex();
        IndexSettings pluggable = pluggableIndex();
    public void testOverriddenTypesNotSearchableWithoutDocValuesOnPluggableIndex() {
    private static IndexSettings normalIndex() {  
            indexed,
        MappedFieldType date = dateFieldType(false, true);
            hasDocValues,  
        assertFalse(bool.isSearchable());
            DateFieldMapper.getDefaultDateTimeFormatter(),
        IndexSettings pluggable = pluggableIndex();  
        assertFalse(new BooleanFieldMapper.BooleanFieldType("bool", false, false).isSearchableViaDocValues(pluggable));
        return new NumberFieldMapper.NumberFieldType(  
        IndexSettings pluggable = pluggableIndex();
 */  
    }
    public void testFilterFieldTypeDelegatesIsSearchableViaDocValues() {
        assertFalse(number.isSearchable());
        assertTrue(dateFieldType(false, true).isSearchableViaDocValues(pluggable));
        );
import org.opensearch.common.settings.Settings;
    }
            Collections.emptyMap()  
    private static IpFieldMapper.IpFieldType ipFieldType(boolean indexed, boolean hasDocValues) {
            NumberFieldMapper.NumberType.LONG,
package org.opensearch.index.mapper;
        assertTrue(dateFieldType(true, true).isSearchableViaDocValues(normal));  
        assertTrue(numberFieldType(true, true).isSearchableViaDocValues(null));
        FilterFieldType filtered = new FilterFieldType(delegate) {
        IndexSettings normal = normalIndex();
        assertTrue(bool.isSearchableViaDocValues(pluggable));
    /** Query planning must keep seeing no search index. */
            Settings.builder().put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true).build()
    public void testBaseImplementationDelegatesToIsSearchable() {
        MappedFieldType number = numberFieldType(false, true);  
        // Null index settings must fall back to isSearchable() for every overriding type, not just numbers.  
            assertFalse(unindexedKeyword.isSearchableViaDocValues(indexSettings));
        assertFalse(new BooleanFieldMapper.BooleanFieldType("bool", false, true).isSearchableViaDocValues(normal));
        MappedFieldType delegate = numberFieldType(false, true);  
            indexed,  
    public void testIsSearchableItselfIsUnchanged() {  
 *
        assertFalse(new BooleanFieldMapper.BooleanFieldType("bool", false, true).isSearchableViaDocValues(null));  
            false,
        assertTrue(number.isSearchableViaDocValues(pluggable));
        return IndexSettingsModule.newIndexSettings("normal", Settings.EMPTY);
 * this file be licensed under the Apache-2.0 license or a
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    /** Types that do not override the method are unaffected on any index. */  
            true,
        assertFalse(numberFieldType(false, true).isSearchableViaDocValues(normal));
        MappedFieldType ip = ipFieldType(false, true);
                return delegate.typeName();
/** Tests for {@link MappedFieldType#isSearchableViaDocValues(IndexSettings)}. */  
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    }
        assertFalse(ipFieldType(false, true).isSearchableViaDocValues(normal));
        assertFalse(numberFieldType(false, false).isSearchableViaDocValues(pluggable));
            false,  
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
            hasDocValues,
        }  
            "number",
        assertFalse(ip.isSearchable());
            false,
            "pluggable",  
        };  
import org.opensearch.common.util.FeatureFlags;
        assertTrue(numberFieldType(false, true).isSearchableViaDocValues(pluggable));  
    public void testOverriddenTypesSearchableFromDocValuesOnPluggableIndex() {
import org.opensearch.test.OpenSearchTestCase;
            assertTrue(indexedKeyword.isSearchableViaDocValues(indexSettings));
    /** FilterFieldType has no logic of its own here; it must return exactly what its delegate returns. */  
    }
        return IndexSettingsModule.newIndexSettings(
        assertTrue(date.isSearchableViaDocValues(pluggable));
public class MappedFieldTypeFieldCapsTests extends OpenSearchTestCase {
    }  
            "date",  
        assertFalse(ipFieldType(false, true).isSearchableViaDocValues(null));
        );
        assertFalse(date.isSearchable());  
    }
        assertEquals(delegate.isSearchableViaDocValues(pluggable), filtered.isSearchableViaDocValues(pluggable));
    public void testNullIndexSettingsFallsBackToIsSearchable() {
            MappedFieldType unindexedKeyword = new KeywordFieldMapper.KeywordFieldType("kw", false, true, Collections.emptyMap());
 * SPDX-License-Identifier: Apache-2.0
    }  
    private static DateFieldMapper.DateFieldType dateFieldType(boolean indexed, boolean hasDocValues) {
            null,  
        return new DateFieldMapper.DateFieldType(
            null,
            DateFieldMapper.Resolution.MILLISECONDS,
        assertTrue(ipFieldType(false, true).isSearchableViaDocValues(pluggable));
    private static IndexSettings pluggableIndex() {
/*  
        assertTrue(new BooleanFieldMapper.BooleanFieldType("bool", true, true).isSearchableViaDocValues(normal));  
    }
}
            Collections.emptyMap()
        assertFalse(dateFieldType(false, true).isSearchableViaDocValues(null));
 * compatible open source license.
        assertTrue(ipFieldType(true, true).isSearchableViaDocValues(normal));  
    private static NumberFieldMapper.NumberFieldType numberFieldType(boolean indexed, boolean hasDocValues) {
        assertFalse(dateFieldType(false, false).isSearchableViaDocValues(pluggable));
    }
        );
            public String typeName() {  
    }
import java.util.Collections;
            MappedFieldType indexedKeyword = new KeywordFieldMapper.KeywordFieldType("kw", true, true, Collections.emptyMap());
        for (IndexSettings indexSettings : new IndexSettings[] { normalIndex(), pluggableIndex() }) {  
    }  
        assertTrue(ip.isSearchableViaDocValues(pluggable));  
            @Override
            }
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)  
        return new IpFieldMapper.IpFieldType("ip", indexed, false, hasDocValues, null, Collections.emptyMap());  
        assertFalse(ipFieldType(false, false).isSearchableViaDocValues(pluggable));  
    }  
