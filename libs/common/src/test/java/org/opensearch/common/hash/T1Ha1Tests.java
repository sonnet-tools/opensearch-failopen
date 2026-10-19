        long[] referenceMultiplyHigh = {  
            0x715210412CABBF46L,  
        int offset = 0;
            0x94CCA5E8210D2134L,
            (byte) 0xC0,  
            0xF,
            0x28975F86E2E2177FL,
            0xDF40392265BB4A66L,  
            0x6B1A96F1B4765D79L,
            0x3EA060225B3E1C1FL,
            0x2E079CB8C1A11F50L,
            0x1B66C81767870EF2L,  
            0x990015FBC9E095EEL,  
 * this file be licensed under the Apache-2.0 license or a
            11,  
            0x6AF1C60874C95442L,
    }
            0x559122C706343421L,
            0x0BEBAD4FABF523BAL,
            0L,
            0xDC8791FEFF8ED3ACL,  
            43,
            0xFFF05844F57498B8L,
            return false;  
            0x359C862CD3BE4FCDL,
            0xED463EE3848A8695L,
            0xF5CC0BEABC259F52L,
            0x80DABA3D62BEAC79L,
            29,
            0xD50F162A1EFDD844L,  
            (byte) 0x80,  
import java.lang.invoke.VarHandle;  
            'x' };
            0x1F,  
            0xB00E4C1238F9E2D4L,
            0x615730E301ED12E2L,
    }
            0x19F81514AFA9A22DL,
            16,  
            'g',
            0x9B784F3B4CE6AF33L,  
    public void testSelfCheck() {
        } catch (NoSuchMethodException e) {
            'j',
            (byte) 0xF7,  
            (byte) 0xFF,  
            0x24F619D3D5BC2DB4L,
            0x68DFA6A1B8050A4CL,  
        for (int i = 0; i < testPatternLong.length; i++) {
            0x3EB7849C0DFAF566L,  
            0x9269F4214414D61DL,  
            0x6A580668D6048674L,
            0x2569C744E1A282CFL,
            0xF62751F7F25C469EL,  
            0xB07F517E88D7AFB3L,
            (byte) 0xDF,
            0x45EE02D6DCF8992EL,  
            'w',  
            0x3556F9A5757AB6D0L,
            'q',  
            'e',  
            0xFB4E677D876118A1L,
            'c',
            'b',  
    private static boolean hasUnsignedMultiplyHigh() {  
            0x6C2FC5A4109FD3A2L,
     * <a href="https://github.com/erthink/t1ha/blob/master/src/t1ha_selfcheck.c">t1ha_selfcheck.c</a>  
            42,  
            0x4D4C63128A344F82L,
        return scratch;
            0xA78AFA5AB4BBE0CDL,  
            seed <<= 1;
            23,  
            return true;
    /**
            0x6E6A774ACD266DF2L,
/*  
            0x8A20849A27C32548L,
            assertEquals(reference[offset++], T1ha1.hash(testPattern, i, 64 - i, seed)); // align%i_F%i  
            0xA8CE1B90167A6F8BL,
            0x9BE9E11AD1A6C369L,  
            0xAA503A04AE2450B5L,  
            0xEC6B92A37AED73B8L,
            0x9CE74296C8C55AE4L,
            'h',  
            0xDC9E04DF744BDC0CL,
            5,  
 * compatible open source license.
            0x24DBB6D02D5CC531L,
        for (int i = 0; i <= 7; i++) {
            0xC0A2DA74A8271FCBL,  
            MethodHandles.publicLookup()
    private static final VarHandle LONG_HANDLE = MethodHandles.byteArrayViewVarHandle(long[].class, ByteOrder.LITTLE_ENDIAN);
            'o',
            0x7BFB2E2CEF118346L,
            't',  
            throw new RuntimeException(e);
        // Reference hashes when using {@link Math::multiplyHigh} in the mux64 step.
        assertEquals(reference[offset++], T1ha1.hash(null, 0, 0, 0L)); // empty-zero
            0x084CDA0ED41CD2D4L,
            'a',
            0x910B0DAD1440EC24L,
    @Override  
            0xC6227497E100B463L,
            0xF64D2F86E813BF33L,
            0x62332FA6EC1B50AAL,
        }  
            0x8DB71789127C6C13L,
        }  
        assertEquals(reference[offset++], T1ha1.hash(testPattern, 0, 64, 0L)); // bin64-zero
        return 64;  
            0x4A52ACF805F370ABL,  
            0x1075B9B89BDFE5F8L,  
            0x4BB8E16FF410F19EL,
            0x3E355394668C3559L,
            0x0D33817EF345D999L,  
            (byte) 0xAA,
            0x6C55B2DC74B816A1L,  
        try {
    @Override
            testPatternLong[i] = (byte) i;
            0x0AE73C696F3D37C0L,
            0x43750475A48C7023L,
            0x1C549C06FAF4D023L,
            0x0D56DFF9914CA656L,
            (byte) 0xFC,
     * Inspired from the tests defined in the reference implementation:
            0x2025E73769720D5AL,
            (byte) 0xEF,
            'f',
            'r',
            0x08DEF866EF20A94BL,
 *
            0x6F42FC70EB660E38L,
            0xCA6BA9817A357FA9L,
    private final byte[] scratch = new byte[8];
        for (int i = 1; i <= 7; i++) {
            (byte) 0xF8,  
        }
            0x0A7C717017756FE7L,
            2,  
    }
            0x016707EBF858B84DL,
        assertEquals(reference[offset++], T1ha1.hash(null, 0, 0, ~0L)); // empty-all1  
            0xBA0DE64B3F4DB34AL,
            0x56ECDED6546F0914L,
        }  
            0x7BAD25A859D87B5DL,
            0x6993BB206A74F070L,
 * The OpenSearch Contributors require contributions made to  
            0xAB87E38AA8D21746L,
            7,
        LONG_HANDLE.set(scratch, 0, hash);  
            0x1A2D4AA43B6C0103L };  
            0x1A86161AE8E82A85L,
            'u',
            0xE5E91A7340BF9382L,  
            0xA74E7C2D632664EFL,  
            (byte) 0xF0,
                .findStatic(Math.class, "unsignedMultiplyHigh", MethodType.methodType(long.class, long.class, long.class));  
            0xB2D538403F1020F1L,
    }
            'p',
            (byte) 0xFD,
            0xF90EB7C1D70A80B9L,
            0xC0FF62F8FD5F4C77L,  
            0x3F,
            0x5B3E60EEB51DDCD8L,  
            0x5E9F2493DDAA166CL,
            0x15D25DE445730A6CL,
            0xD4C8FCFD4179A874L,  
            0L,
            0x840BFF3BEB7EEADDL,  
            0xBE01CF6841412C77L,
            0xD05BA7AA9FEECE5BL,  
            0xEE97003F7B1283E1L,  
            0x5C54BDE5AE280E82L,  
 */  
            0x7D6128AB2CCC4EB1L,
            0x7D0BAC64606521F1L,  
            0x0E22B86754BC3BC4L,
            0xCB4F5859A9AE5B52L,
            0x84A1A8DF8D609239L,  
            0xCE510B7405E0A2CAL,
            'l',
     */
            0x300D3885894BA47FL,
            0xC46A2D3BD6925A35L,  
            8,
            0x1CA8760277E6006CL,
            (byte) 0xBF,  
            0xD8FA0B9E9D6AA93FL,
import java.nio.ByteOrder;
        for (int i = 1; i < 64; i++) {
            'n',  
            0x1712987232EF4ED3L,
            0x17424152BE1CA266L,
            0x173B09359DE422CFL,
            0x0E028D255667AEADL,  
            0x8608D03D165C59BFL,
            0x5648BD3E391C01D3L,
            0x3071BC8E6C400487L,
            0x54666461D0EB4FD7L,
            1,
            0x02771D08F2891CB1L,
import java.lang.invoke.MethodType;
            assertEquals(reference[offset++], T1ha1.hash(testPatternLong, i, 128 + i * 17, seed)); // long-%05i
            0x380133D58665E93DL,  
            0x4DBD6BB7A31E85FDL,  
            0xBE66DAD3043AB694L,
            0xAACE57113E681A0FL,  
        byte[] testPatternLong = new byte[512];  
            0xFF9FDB99305EB06AL };  
    public byte[] hash(byte[] input) {
            0x05984B7D358B107AL,
        long[] referenceUnsignedMultiplyHigh = {  
            0x8B9AF0A3E71F042FL,
public class T1Ha1Tests extends HashFunctionTestCase {  
            'd',
            0x851EEC67F6516D94L,
            0x6CBE0E537BE04C02L,
            0x55,
            0xE3AB9C06FAF4D023L,
            'i',
            0x297518A4EF6AF5F1L,  
            0x570B4D6AE4C67814L,
            0xAD645ADCF7414F1DL,  
            19,
            0x3E4AF35A1678D636L,
            's',
            0x40DBC1F51618FDA7L,  
            0x0807945BF0FB52C6L,
        byte[] testPattern = {  
        long hash = T1ha1.hash(input, 0, input.length);
            0xA73773805CA31934L,
            0xAD6120B2B8A152E1L,
            0x53C9987705EA71C0L,  
            0x41CD044C0E5A4EE3L,
            0x6AA56E88BD380564L,
            32,
            37,
            0x647C3E0FF3E3D241L,
            0xE5EF7E09DE70848DL,
        seed = ~0L;  
            0x4D32FA1D79002A57L,  
        // These values match the ones defined in the reference implementation:
            0xFE212C6DB7474306L,
            0x746ECFA92D1CAF81L,  
            17,
            6,
        long[] reference = hasUnsignedMultiplyHigh() ? referenceUnsignedMultiplyHigh : referenceMultiplyHigh;
            (byte) 0xFB,
            0x1DFD3D1924FBE319L,
            0x63E1DF35FEBE994AL,  
            0x50CFB2AF0F54BA6DL,
import java.lang.invoke.MethodHandles;
            0xFE13F90A1ACFBD58L,
            'k',  
            0x5EF25F7062324941L,
        // Reference hashes when using {@link Math::unsignedMultiplyHigh} in the mux64 step.  
            0x80E48374A6B42E85L,
package org.opensearch.common.hash;
        }
            0x2A71D9F13959F2B7L,  
            0xDFAEAB2F09EF7E78L,
            0x0352E4055C13242EL,  
    public int outputBits() {
            0x0873B834A6E2AAE4L,
        long seed = 1;  
        } catch (IllegalAccessException e) {
            64,
 * SPDX-License-Identifier: Apache-2.0
            'v',
            4,
            'm',
            0xB321C06FB5FFAB5CL,
            (byte) 0xE0,
            0x0BCBC9FE3B57884EL,
            0xFFF7C351A4CEC13DL,  
            0,
            0xA2FE904AFF0D0879L,  
            0x7F,
            0x5FDD7649D8EC44E4L,
            3,
            seed <<= 1;  
        // https://github.com/erthink/t1ha/blob/master/src/t1ha1_selfcheck.c#L51-L72
            0x025BDE6A7BEBF320L,
}
            0x1ED59274A97497EBL,  
            0x4E1EB70C58E48540L,  
            0xA7603B5AF07A0B1EL,  
            0xB3557E561A6C5D82L,  
            0xB926B2FA50541BA9L,
            assertEquals(reference[offset++], T1ha1.hash(testPattern, 0, i, seed)); // bin%i-1p%i
            0xF1E95DF109076C4CL,
            (byte) 0xFE,
            0xCF3A39F5C27DC125L,
            0x18CAE735BBF62D15L,  
