    private List<String> getAllTokens(final TokenStream ts) throws IOException {  
    /**
                "tel:",
    }
    }
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
public class PhoneNumberAnalyzerTests extends OpenSearchTokenStreamTestCase {
     */
    }  
        assertTokensInclude("tel:8177148350", Arrays.asList("817", "8177", "81771", "817714", "8177148350"));
    }
import java.util.List;
     * contain the required ones but does not check for completeness or order.
    public void testGermanCastle() throws IOException {  
    /**  
import org.opensearch.index.analysis.AnalysisTestsHelper;
     */
            "tel:+441344840400",
        phoneAnalyzer = analysis.indexAnalyzers.get("phone");
        assertTokensInclude("tel:+441344840400", Arrays.asList("44", "1344", "1344840400", "441344840400"));  
    public void testTelPrefix() throws IOException {
    public void testPhoneNumberWithoutPrefix() throws IOException {
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;  
        assertTokensAreInAnyOrder(  
    }  
    }
                "4413448",  
    }  
        assertTokensInclude("tel:5551234", Arrays.asList("5551234"));  
 * this file be licensed under the Apache-2.0 license or a
        assertTokensInclude("sip:222@autosbcpc", Arrays.asList("222"));
                "44",
    private static Analyzer phoneAnalyzer;
        assertTokensInclude("sip:abc@autosbcpc", Arrays.asList("abc"));
    public void testSearchInternationalPrefixWithCH() throws IOException {
        while (ts.incrementToken()) {
                "44134",
        ts.end();
        assertTokensInclude(phoneCHAnalyzer, "+41583161010", Arrays.asList("41", "41583161010", "583161010"));  
    public void testEuropeDetailledSearch() throws IOException {
        phoneSearchCHAnalyzer = analysis.indexAnalyzers.get("phone-search-ch");
            Arrays.asList(  
        assertTokensInclude(phoneCHAnalyzer, "0583161010", Arrays.asList("41", "41583161010", "583161010"));
     */  
 *
    public void testSearchNationalPrefixWithCH() throws IOException {  
    public void testInternationalPrefixWithZZ() throws IOException {
    public void testNewTollFreeNumber() throws IOException {
     * Unlike {@link #assertTokenStreamContents(TokenStream, String[])} this only asserts whether the generated tokens
    }
    }
                "441344840400",  
import java.util.Arrays;
        assertTokensAreInAnyOrder(phoneSearchAnalyzer, "tel:+1228", Arrays.asList("tel:+1228", "1228"));  
    public void testTelPrefixSearch() throws IOException {
    }  
import org.apache.lucene.analysis.Analyzer;
    public void testSipWithAlphabeticUsername() throws IOException {  
                "4413",  
    public void testSipWithTelephoneExtension() throws IOException {  
                "134484",
    }
    }
    }
        assertTokensAreInAnyOrder(phoneSearchCHAnalyzer, "0041583161010", Arrays.asList("0041583161010", "41583161010"));
    }
    public static void beforeClass() throws IOException {
        assertTokensInclude("+1228", Arrays.asList("1228", "122", "228"));
        assertTokensAreInAnyOrder(phoneSearchAnalyzer, "+41583161010", Arrays.asList("+41583161010", "41583161010"));
        assertTokensInclude("tel:+498362930830", Arrays.asList("49", "498362930830", "8362930830"));
    }
        assertTokensAreInAnyOrder(phoneSearchAnalyzer, "tel:+441344840400", Arrays.asList("tel:+441344840400", "441344840400"));
        final var analysis = AnalysisTestsHelper.createTestAnalysisFromClassPath(
    public void testMissingCountryCode() throws IOException {  
        for (final var expectedToken : expectedTokens) {
                "134",
                "44134484",
    private static Analyzer phoneSearchCHAnalyzer;
        ts.reset();  
package org.opensearch.analysis.phone;
        phoneSearchAnalyzer = analysis.indexAnalyzers.get("phone-search");  
            RESOURCE,
 * compatible open source license.
    }
                "441344",
     * contain the required ones but does not check for order. Use {@link #assertTokensInclude} if completeness is not needed.  
        // when omitting the international prefix swiss numbers must start with '0'  
    private static Analyzer phoneCHAnalyzer;  
    /**  
    public void testTelWithCountryCode2() throws IOException {
    public void testTelWithCountryCode() throws IOException {  
            assertThat(allTokens, hasItemInArray(expectedToken));
    private void assertTokensInclude(final String input, final List<String> expectedTokens) throws IOException {
    public void testNumberPrefix() throws IOException {  
        this.assertTokensInclude(phoneAnalyzer, input, expectedTokens);  
        final var ts = analyzer.tokenStream("test", input);
}  
    }  
        final var tokens = new ArrayList<String>();
    }
        assertNotNull(phoneCHAnalyzer);  
        assertNotNull(phoneAnalyzer);
        assertTokensInclude("tel:+17177158163", Arrays.asList("1", "717", "7177", "17177158163"));
    }  
    public void testNationalPrefixWithCH() throws IOException {  
    }
        throws IOException {  
        final var termAtt = ts.getAttribute(CharTermAttribute.class);
     * This uses {@link #phoneAnalyzer}.  
     */  
     * Unlike {@link #assertTokenStreamContents(TokenStream, String[])} this only asserts whether the generated tokens
    public void testGarbageInGarbageOut() throws IOException {
        assertTokensInclude("+14177141363", Arrays.asList("14177141363", "417", "4177", "14177"));  
                "tel:+441344840400",
        assertNotNull(phoneSearchAnalyzer);
    public void testSipWithNumericUsername() throws IOException {
    }
 * The OpenSearch Contributors require contributions made to  
    public void testSearchLocalNumberWithCH() throws IOException {
    }  
    }
     */
     * Unlike {@link #assertTokenStreamContents(TokenStream, String[])} this only asserts whether the generated tokens
        assertTokensInclude("sip:JeffSIP@178.12.220.18", Arrays.asList("JeffSIP"));
        );
 * SPDX-License-Identifier: Apache-2.0
        assertTokensInclude(phoneAnalyzer, "tel:+1228", Arrays.asList("tel:+1228", "tel:", "1228", "122", "228"));
     * Test for all tokens which are emitted by the "phone" analyzer.
        assertTokensInclude(phoneCHAnalyzer, "0041583161010", Arrays.asList("41", "41583161010", "583161010"));
    }  
            phoneAnalyzer,
                "1",  
        // when omitting the international prefix swiss numbers must start with '0'  
        final var allTokens = getAllTokens(ts).toArray();  
        }  
        // + is equivalent to 00 in Switzerland
    public void testLocalNumberWithCH() throws IOException {
        );  
import static org.hamcrest.Matchers.hasItemInArray;
        assertTokensInclude("tel:+442890319416", Arrays.asList("44", "289", "2890319416", "442890319416"));  
                "13",
    /**
            )  
    }  
            tokens.add(termAtt.toString());
     * Test for all tokens which are emitted by the "phone" analyzer.  
    public void testEuropeDetailled() throws IOException {
    }  
        assertTokensAreInAnyOrder(phoneSearchCHAnalyzer, "0583161010", Arrays.asList("0583161010", "41583161010"));
import org.apache.lucene.analysis.TokenStream;
        assertThat(allTokens, arrayContainingInAnyOrder(expectedTokens.toArray()));  
    public void testEurope() throws IOException {
import java.io.IOException;
    public void testInternationalPrefixWithCH() throws IOException {
/*  
                "44134484040"
    public void testSipWithCountryCode() throws IOException {
        assertTokensInclude(phoneAnalyzer, "+41583161010", Arrays.asList("41", "41583161010", "583161010"));
        }  
            createTempDir(),  
        assertTokensInclude("sip:+14177141363@178.97.105.13;isup-oli=0;pstn-params=808481808882", Arrays.asList("417", "4177", "14177"));  
    }  
    public void testSearchInternationalPrefixWithZZ() throws IOException {
        assertTokensAreInAnyOrder(phoneSearchCHAnalyzer, "+41583161010", Arrays.asList("+41583161010", "41583161010"));  
        return tokens;  
    }
    public void testBMWofSydney() throws IOException {
                "134484040",
                "1344",  
    }
    public void testTruncatedNumber() throws IOException {
        ts.close();
import org.junit.BeforeClass;  
    /**
        assertTokensInclude("tel:+12177148350", Arrays.asList("1", "217", "2177", "2177148350", "12177148350"));
                "1344840",  
            new PhoneNumberAnalysisPlugin()
    }
    }
    @BeforeClass  
     * contain the required ones but does not check for completeness or order.
    }
    }
        final var ts = analyzer.tokenStream("test", input);
    private void assertTokensAreInAnyOrder(final Analyzer analyzer, final String input, final List<String> expectedTokens)
 */  
        assertNotNull(phoneSearchCHAnalyzer);
        assertTokensInclude("tel:+18337148350", Arrays.asList("1", "833", "8337", "8337148350", "18337148350"));  
                "441",
        final var allTokens = getAllTokens(ts).toArray();
        assertTokensInclude("test", Arrays.asList("test"));
    private static Analyzer phoneSearchAnalyzer;
    }
import java.util.ArrayList;  
        phoneCHAnalyzer = analysis.indexAnalyzers.get("phone-ch");
    public void testCoffeeShopInIreland() throws IOException {
    public void testSipWithUsername() throws IOException {
                "4413448404",  
        // + is equivalent to 00 in Switzerland
    }  
                "13448404",
    private static final String RESOURCE = "/org/opensearch/analysis/phone/phone_analysis.json";
        assertTokensInclude("sip:+13169410766;ext=2233@178.17.10.117:8060", Arrays.asList("316", "2233", "1316"));
import org.opensearch.test.OpenSearchTokenStreamTestCase;
                "13448",
    public void testSipWithoutDomainPart() throws IOException {  
    private void assertTokensInclude(final Analyzer analyzer, final String input, final List<String> expectedTokens) throws IOException {
                "1344840400",
                "441344840",
        assertTokensInclude("sip:+122882", Arrays.asList("122882", "122", "228", "1228", "2288", "12288"));
        assertTokensInclude("tel:+61293344555", Arrays.asList("61", "293344555", "61293344555"));
