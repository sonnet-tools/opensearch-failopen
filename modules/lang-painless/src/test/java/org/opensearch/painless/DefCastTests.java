        assertEquals((long) 0, exec("def d = Long.valueOf(0); long b = (long)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = 'string'; Byte b = d;"));  
        assertEquals(0, exec("def d = (byte)0; int b = d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Short.valueOf(0); Byte b = d;"));
        assertTrue((boolean) exec("def chr = 10; return (chr < (char)'x');"));
/*  
        assertEquals((double) 0, exec("def d = (byte)0; Double b = d; b"));  
        assertEquals(0, exec("def d = Short.valueOf(0); int b = d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Character.valueOf(0); Byte b = d;"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = true; Short b = (Short)d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (char)0; short b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Integer.valueOf(0); Character b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (char)0; Boolean b = (Boolean)d;"));
        assertEquals((float) 0, exec("def d = (float)0; Float b = (Float)d; b"));  
        assertEquals((short) 0, exec("def d = (char)0; Short b = (Short)d; b"));
    }
        assertEquals((char) 0, exec("def d = (char)0; char b = (char)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = 'string'; Long b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (char)0; Boolean b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (float)0; int b = d;"));  
        assertEquals(false, exec("def d = Boolean.valueOf(false); boolean b = d; b"));
        assertEquals(0, exec("def d = 0; Integer b = d; b"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (int)0; Byte b = d;"));
        assertEquals(0, exec("def d = Double.valueOf(0); int b = (int)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = 'string'; double b = d;"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Byte.valueOf(0); boolean b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = 'string'; byte b = (byte)d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = true; Byte b = d;"));
        assertEquals((long) 0, exec("def d = (short)0; Long b = (Long)d; b"));
        assertEquals((float) 0, exec("def d = Character.valueOf(0); Float b = (Float)d; b"));
        assertEquals(0, exec("def d = Integer.valueOf(0); int b = (int)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Double.valueOf(0); Long b = d;"));
        assertEquals(0, exec("def d = (char)0; int b = d; b"));  
    public void testdefTobyteImplicit() {  
        assertEquals((char) 0, exec("def d = Short.valueOf(0); char b = (char)d; b"));
        assertEquals((short) 0, exec("def d = Integer.valueOf(0); short b = (short)d; b"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = new ArrayList(); Boolean b = d;"));
        assertEquals((float) 0, exec("def d = Integer.valueOf(0); Float b = d; b"));
        assertFalse((boolean) exec("def chr = 10; return (chr >= (char)'x');"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (char)0; Short b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = new ArrayList(); short b = d;"));  
        assertEquals((char) 0, exec("def d = Short.valueOf(0); Character b = (Character)d; b"));
        assertEquals((long) 0, exec("def d = Byte.valueOf(0); long b = (long)d; b"));
        assertFalse((boolean) exec("def chr = 10L; return (chr > (char)'x');"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = true; byte b = (byte)d;"));  
        assertEquals((long) 0, exec("def d = Short.valueOf(0); long b = (long)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Boolean.valueOf(true); Long b = d;"));
        assertEquals(0, exec("def d = Short.valueOf(0); Integer b = d; b"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Short.valueOf(0); Boolean b = (Boolean)d;"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = true; float b = (float)d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Float.valueOf(0); boolean b = (boolean)d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = new ArrayList(); char b = (char)d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Boolean.valueOf(true); Integer b = d;"));
    }
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (float)0; Character b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = new ArrayList(); Float b = d;"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = true; long b = (long)d;"));
    }
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Character.valueOf(0); byte b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = true; Character b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = 'string'; boolean b = (boolean)d;"));
        assertEquals((byte) 0, exec("def d = (char)0; Byte b = (Byte)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = 'string'; Double b = d;"));
        assertEquals(0, exec("def d = 0; int b = (int)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = 'string'; int b = d;"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = new ArrayList(); boolean b = d;"));  
        assertEquals((double) 0, exec("def d = Double.valueOf(0); double b = (double)d; b"));
        assertEquals((short) 0, exec("def d = (byte)0; short b = (short)d; b"));
        assertEquals((char) 0, exec("def d = Integer.valueOf(0); Character b = (Character)d; b"));  
        assertEquals((char) 0, exec("def d = Byte.valueOf(0); char b = (char)d; b"));
        assertEquals((short) 0, exec("def d = (short)0; short b = (short)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = 's'; char b = d;"));
        assertEquals((long) 0, exec("def d = 0; long b = (long)d; b"));
        assertEquals((char) 0, exec("def d = (short)0; char b = (char)d; b"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = 'string'; long b = d;"));
        assertEquals((double) 0, exec("def d = 0; double b = d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (float)0; Integer b = d;"));
        assertEquals((long) 0, exec("def d = Short.valueOf(0); Long b = d; b"));  
        assertEquals((long) 0, exec("def d = Double.valueOf(0); Long b = (Long)d; b"));  
        assertEquals((float) 0, exec("def d = Double.valueOf(0); Float b = (Float)d; b"));  
        assertEquals(0, exec("def d = (long)0; Integer b = (Integer)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (char)0; byte b = d;"));
 * specific language governing permissions and limitations
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Float.valueOf(0); Short b = d;"));  
        assertFalse((boolean) exec("def chr = (char)10L; return (chr > (double)(byte)(char)10);"));
        assertEquals((double) 0, exec("def d = 0; Double b = d; b"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (double)0; Character b = d;"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = new ArrayList(); int b = d;"));
        assertEquals((float) 0, exec("def d = Short.valueOf(0); Float b = (Float)d; b"));
        assertEquals((double) 0, exec("def d = (char)0; double b = d; b"));  
        assertEquals(0, exec("def d = (short)0; int b = (int)d; b"));  
        assertEquals((byte) 0, exec("def d = (float)0; byte b = (byte)d; b"));  
    }  
        assertEquals((long) 0, exec("def d = (double)0; Long b = (Long)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Float.valueOf(0); Character b = d;"));
        assertEquals((long) 0, exec("def d = (long)0; Long b = d; b"));
        assertEquals(0, exec("def d = Character.valueOf(0); int b = (int)d; b"));  
 *  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = 'string'; Double b = d;"));
 * SPDX-License-Identifier: Apache-2.0
        expectScriptThrows(ClassCastException.class, () -> exec("def d = 'string'; Character b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Double.valueOf(0); boolean b = d;"));
        assertEquals((long) 0, exec("def d = (byte)0; Long b = (Long)d; b"));
        assertEquals((short) 0, exec("def d = (short)0; short b = d; b"));
        assertEquals((byte) 0, exec("def d = Long.valueOf(0); Byte b = (Byte)d; b"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = true; int b = (int)d;"));
        assertEquals((short) 0, exec("def d = (long)0; short b = (short)d; b"));
        assertEquals((short) 0, exec("def d = (char)0; short b = (short)d; b"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = true; char b = d;"));  
        assertEquals((short) 0, exec("def d = Character.valueOf(0); Short b = (Short)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = new ArrayList(); Character b = d;"));  
    }  
        assertEquals((float) 0, exec("def d = Integer.valueOf(0); Float b = (Float)d; b"));  
        assertEquals((char) 0, exec("def d = (char)0; Character b = d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = new ArrayList(); int b = (int)d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Boolean.valueOf(true); long b = d;"));  
        assertEquals((long) 0, exec("def d = (byte)0; long b = d; b"));
        assertEquals((char) 0, exec("def d = 0; Character b = (Character)d; b"));
    }
        assertEquals((float) 0, exec("def d = (short)0; Float b = (Float)d; b"));
        assertEquals(0, exec("def d = Byte.valueOf(0); Integer b = (Integer)d; b"));  
        assertEquals((float) 0, exec("def d = (byte)0; Float b = d; b"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (double)0; Byte b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = new ArrayList(); byte b = d;"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = 'string'; short b = (short)d;"));
        assertEquals((byte) 0, exec("def d = 0; byte b = (byte)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Long.valueOf(0); char b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = new ArrayList(); float b = (float)d;"));
        assertFalse((boolean) exec("def chr = (char)10L; return (chr > (byte)10);"));  
 */
        assertEquals((float) 0, exec("def d = (short)0; float b = (float)d; b"));  
 * Modifications Copyright OpenSearch Contributors. See
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Boolean.valueOf(true); Character b = d;"));
        assertEquals((double) 0, exec("def d = (double)0; double b = (double)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (double)0; long b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Long.valueOf(0); Byte b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Boolean.valueOf(true); double b = d;"));
        assertEquals((char) 0, exec("def d = 0; char b = (char)d; b"));
        assertEquals((float) 0, exec("def d = Long.valueOf(0); Float b = (Float)d; b"));
    }
        assertEquals((byte) 0, exec("def d = Character.valueOf(0); Byte b = (Byte)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Boolean.valueOf(true); Short b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (double)0; Boolean b = (Boolean)d;"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (long)0; short b = d;"));
    }  
    }  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Boolean.valueOf(true); int b = d;"));
        assertEquals((double) 0, exec("def d = Integer.valueOf(0); Double b = (Double)d; b"));  
        assertEquals((short) 0, exec("def d = Short.valueOf(0); Short b = d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (long)0; Boolean b = d;"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (long)0; Short b = d;"));  
        assertFalse((boolean) exec("def chr = (char)10; return (chr > (char)'x');"));
        assertEquals((byte) 0, exec("def d = (long)0; Byte b = (Byte)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = 'string'; Short b = d;"));  
        assertEquals((long) 0, exec("def d = Character.valueOf(0); long b = d; b"));
    public void testdefToByteImplicit() {
        assertEquals((short) 0, exec("def d = (byte)0; short b = d; b"));  
        assertEquals((short) 0, exec("def d = Long.valueOf(0); Short b = (Short)d; b"));  
        assertEquals((byte) 0, exec("def d = (short)0; Byte b = (Byte)d; b"));
        assertEquals((double) 0, exec("def d = (long)0; double b = (double)d; b"));  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testdefTodoubleImplicit() {
    public void testdefToshortImplicit() {  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (byte)0; Boolean b = (Boolean)d;"));  
        assertEquals((long) 0, exec("def d = (char)0; Long b = (Long)d; b"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Double.valueOf(0); Boolean b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = true; double b = d;"));  
        assertEquals((long) 0, exec("def d = (long)0; long b = (long)d; b"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = 'string'; char b = (char)d;"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Short.valueOf(0); boolean b = d;"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (float)0; Boolean b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (char)'s'; String b = d;"));
        assertEquals((float) 0, exec("def d = (double)0; float b = (float)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Short.valueOf(0); boolean b = (boolean)d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Boolean.valueOf(true); Float b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = new ArrayList(); long b = d;"));
        assertEquals((float) 0, exec("def d = Integer.valueOf(0); float b = (float)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Integer.valueOf(0); boolean b = (boolean)d;"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Byte.valueOf(0); Boolean b = (Boolean)d;"));
        assertEquals((long) 0, exec("def d = (byte)0; Long b = d; b"));  
        assertTrue((boolean) exec("def chr = (char)10; return (chr <= (char)'x');"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Long.valueOf(0); byte b = d;"));  
        assertEquals(0, exec("def d = Integer.valueOf(0); int b = d; b"));  
        assertEquals((float) 0, exec("def d = Byte.valueOf(0); Float b = (Float)d; b"));  
        assertEquals((float) 0, exec("def d = 0; float b = (float)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Float.valueOf(0); int b = d;"));
        assertEquals((char) 0, exec("def d = (byte)0; char b = (char)d; b"));
    public void testdefTocharImplicit() {  
        assertEquals((short) 0, exec("def d = (byte)0; Short b = (Short)d; b"));  
 * Unless required by applicable law or agreed to in writing,
        assertEquals((char) 0, exec("def d = Character.valueOf(0); char b = d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = new ArrayList(); Byte b = d;"));
        assertEquals(0, exec("def d = (short)0; Integer b = (Integer)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (short)0; Boolean b = d;"));  
        assertEquals((short) 0, exec("def d = (short)0; Short b = d; b"));  
        assertEquals((double) 0, exec("def d = (byte)0; double b = (double)d; b"));
        assertEquals((char) 0, exec("def d = Character.valueOf(0); Character b = (Character)d; b"));
        assertEquals((double) 0, exec("def d = Double.valueOf(0); Double b = d; b"));
        assertEquals((short) 0, exec("def d = (float)0; Short b = (Short)d; b"));
public class DefCastTests extends ScriptTestCase {
        assertEquals(0, exec("def d = (char)0; Integer b = (Integer)d; b"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (long)0; Boolean b = (Boolean)d;"));
        assertEquals((double) 0, exec("def d = Byte.valueOf(0); Double b = d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Character.valueOf(0); boolean b = (boolean)d;"));
        assertEquals(0, exec("def d = Byte.valueOf(0); int b = (int)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (int)0; Boolean b = d;"));
        assertEquals(0, exec("def d = (float)0; int b = (int)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (long)0; int b = d;"));
        assertEquals((byte) 0, exec("def d = Byte.valueOf(0); Byte b = d; b"));
    public void testdefTobooleanExplicit() {
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Boolean.valueOf(true); Byte b = d;"));  
        assertEquals((byte) 0, exec("def d = Long.valueOf(0); byte b = (byte)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = 'string'; Character b = (Character)d;"));
        assertEquals((double) 0, exec("def d = Long.valueOf(0); double b = d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Boolean.valueOf(true); byte b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = 's'; Character b = d;"));  
 * not use this file except in compliance with the License.
    public void testConstFoldingDefCast() {  
        assertEquals((long) 0, exec("def d = Byte.valueOf(0); Long b = d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Long.valueOf(0); Short b = d;"));
        assertEquals((double) 0, exec("def d = Double.valueOf(0); Double b = (Double)d; b"));  
/*  
    }
        assertEquals((double) 0, exec("def d = (short)0; double b = d; b"));
        assertEquals(0, exec("def d = Byte.valueOf(0); int b = d; b"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = 'string'; double b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Double.valueOf(0); long b = d;"));  
    }
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (int)0; char b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Integer.valueOf(0); short b = d;"));
        assertEquals((double) 0, exec("def d = Double.valueOf(0); double b = d; b"));  
    }
    public void testdefToDoubleExplicit() {
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (short)0; Boolean b = (Boolean)d;"));
        assertEquals((float) 0, exec("def d = Float.valueOf(0); Float b = (Float)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (byte)0; Character b = d;"));  
        assertEquals((double) 0, exec("def d = (double)0; Double b = d; b"));  
        assertEquals((short) 0, exec("def d = (byte)0; Short b = d; b"));
        assertEquals((byte) 0, exec("def d = 0; Byte b = (Byte)d; b"));  
        assertEquals((float) 0, exec("def d = Long.valueOf(0); Float b = d; b"));  
        assertEquals((char) 0, exec("def d = Double.valueOf(0); char b = (char)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (long)0; Byte b = d;"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = new ArrayList(); Short b = d;"));
        assertEquals((short) 0, exec("def d = Byte.valueOf(0); Short b = (Short)d; b"));
        assertEquals((long) 0, exec("def d = (char)0; long b = d; b"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = 'string'; Boolean b = (Boolean)d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (short)0; char b = d;"));
        assertEquals((byte) 0, exec("def d = (long)0; byte b = (byte)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Boolean.valueOf(true); Float b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Double.valueOf(0); Integer b = d;"));
        assertEquals("s", exec("def d = (char)'s'; String b = (String)d; b"));  
 * GitHub history for details.
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Boolean.valueOf(true); Byte b = d;"));
/*
        assertEquals((byte) 0, exec("def d = Double.valueOf(0); Byte b = (Byte)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = 'string'; byte b = d;"));
        assertEquals(0, exec("def d = (byte)0; int b = (int)d; b"));
        assertEquals((byte) 0, exec("def d = Integer.valueOf(0); byte b = (byte)d; b"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Double.valueOf(0); Short b = d;"));
        assertEquals((short) 0, exec("def d = (long)0; Short b = (Short)d; b"));
        assertEquals((double) 0, exec("def d = Long.valueOf(0); Double b = (Double)d; b"));
        assertEquals((double) 0, exec("def d = (short)0; Double b = d; b"));
        assertEquals((short) 0, exec("def d = Float.valueOf(0); Short b = (Short)d; b"));
        assertEquals((float) 0, exec("def d = Long.valueOf(0); float b = (float)d; b"));
        assertEquals((byte) 0, exec("def d = Double.valueOf(0); byte b = (byte)d; b"));  
        assertEquals((double) 0, exec("def d = Float.valueOf(0); Double b = d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (long)0; boolean b = (boolean)d;"));
        assertEquals('s', exec("def d = 's'; char b = (char)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Boolean.valueOf(true); Double b = d;"));
        assertEquals((double) 0, exec("def d = Long.valueOf(0); Double b = d; b"));  
        assertEquals((long) 0, exec("def d = Long.valueOf(0); Long b = (Long)d; b"));
        assertEquals((double) 0, exec("def d = Short.valueOf(0); double b = (double)d; b"));
        assertEquals((byte) 0, exec("def d = Byte.valueOf(0); byte b = (byte)d; b"));  
        assertEquals((long) 0, exec("def d = 0; Long b = (Long)d; b"));
        assertEquals(0, exec("def d = Float.valueOf(0); int b = (int)d; b"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = new ArrayList(); double b = (double)d;"));
        assertEquals((long) 0, exec("def d = Byte.valueOf(0); Long b = (Long)d; b"));  
    }
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Integer.valueOf(0); char b = d;"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = true; Long b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Byte.valueOf(0); boolean b = (boolean)d;"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = new ArrayList(); boolean b = (boolean)d;"));
        assertFalse((boolean) exec("def chr = 10D; return (chr > (char)'x');"));
    }  
        assertEquals('s', exec("def d = 's'; Character b = (Character)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (float)0; byte b = d;"));
        assertEquals((float) 0, exec("def d = (char)0; float b = (float)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (float)0; short b = d;"));
        assertEquals((float) 0, exec("def d = (long)0; Float b = (Float)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Boolean.valueOf(true); long b = d;"));
        assertEquals((float) 0, exec("def d = Short.valueOf(0); float b = (float)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Boolean.valueOf(true); Long b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = new ArrayList(); Character b = (Character)d;"));
    }
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Float.valueOf(0); Byte b = d;"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = new ArrayList(); Double b = (Double)d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (float)0; long b = d;"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Boolean.valueOf(true); Double b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Character.valueOf(0); boolean b = d;"));
        assertEquals((float) 0, exec("def d = Float.valueOf(0); Float b = d; b"));
    }
    }  
}  
        assertEquals((char) 0, exec("def d = (float)0; Character b = (Character)d; b"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (float)0; Boolean b = (Boolean)d;"));
        assertEquals((short) 0, exec("def d = 0; short b = (short)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (float)0; Long b = d;"));
    }
        assertEquals((long) 0, exec("def d = (long)0; Long b = (Long)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = new ArrayList(); char b = d;"));
    }  
    public void testdefTointImplicit() {
        assertEquals((short) 0, exec("def d = Short.valueOf(0); short b = (short)d; b"));
        assertEquals((short) 0, exec("def d = (double)0; Short b = (Short)d; b"));  
    }
        assertEquals((byte) 0, exec("def d = Float.valueOf(0); byte b = (byte)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Double.valueOf(0); Float b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = new ArrayList(); Boolean b = (Boolean)d;"));  
        assertEquals((byte) 0, exec("def d = Integer.valueOf(0); Byte b = (Byte)d; b"));
    public void testdefToLongExplicit() {
        expectScriptThrows(ClassCastException.class, () -> exec("def d = new ArrayList(); Long b = d;"));  
    }
    public void testdefToStringExplicit() {
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (double)0; Short b = d;"));
 * software distributed under the License is distributed on an
        assertEquals(0, exec("def d = Integer.valueOf(0); Integer b = (Integer)d; b"));  
        assertEquals((short) 0, exec("def d = Double.valueOf(0); short b = (short)d; b"));  
        assertEquals((double) 0, exec("def d = (char)0; double b = (double)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = 'string'; Boolean b = d;"));  
        assertEquals((double) 0, exec("def d = Float.valueOf(0); double b = (double)d; b"));  
        assertEquals((byte) 0, exec("def d = (byte)0; byte b = (byte)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Float.valueOf(0); Boolean b = (Boolean)d;"));
 * KIND, either express or implied.  See the License for the
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Double.valueOf(0); short b = d;"));
        assertEquals((double) 0, exec("def d = Byte.valueOf(0); Double b = (Double)d; b"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Short.valueOf(0); byte b = d;"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Integer.valueOf(0); boolean b = d;"));
        assertEquals((float) 0, exec("def d = Character.valueOf(0); float b = (float)d; b"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Short.valueOf(0); Character b = d;"));  
        assertEquals((byte) 0, exec("def d = Byte.valueOf(0); byte b = d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = new ArrayList(); Short b = (Short)d;"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (double)0; char b = d;"));
        assertEquals((byte) 0, exec("def d = Short.valueOf(0); Byte b = (Byte)d; b"));  
    public void testdefTolongExplicit() {
        assertEquals(true, exec("def d = true; boolean b = d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Float.valueOf(0); byte b = d;"));
        assertEquals(0, exec("def d = (float)0; Integer b = (Integer)d; b"));  
        assertEquals((char) 0, exec("def d = (char)0; char b = d; b"));  
        assertEquals((double) 0, exec("def d = (double)0; Double b = (Double)d; b"));
        assertFalse((boolean) exec("def chr = 10; return (chr == (char)'x');"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Double.valueOf(0); Byte b = d;"));
        assertEquals((float) 0, exec("def d = (long)0; float b = (float)d; b"));  
        assertEquals((float) 0, exec("def d = (long)0; Float b = d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (double)0; boolean b = (boolean)d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (short)0; boolean b = (boolean)d;"));
        assertEquals((long) 0, exec("def d = (float)0; long b = (long)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Boolean.valueOf(true); char b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Float.valueOf(0); Long b = d;"));
    }  
        assertEquals((double) 0, exec("def d = (float)0; Double b = (Double)d; b"));  
        assertEquals((byte) 0, exec("def d = (char)0; byte b = (byte)d; b"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Long.valueOf(0); Boolean b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = new ArrayList(); Byte b = (Byte)d;"));  
    public void testdefTofloatExplicit() {
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (long)0; byte b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = true; Integer b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Double.valueOf(0); char b = d;"));  
        assertEquals((short) 0, exec("def d = Integer.valueOf(0); Short b = (Short)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Byte.valueOf(0); char b = d;"));  
        assertEquals((short) 0, exec("def d = Short.valueOf(0); Short b = (Short)d; b"));  
        assertEquals((double) 0, exec("def d = (char)0; Double b = (Double)d; b"));  
        assertEquals((short) 0, exec("def d = Long.valueOf(0); short b = (short)d; b"));
        assertEquals((float) 0, exec("def d = (byte)0; Float b = (Float)d; b"));
        assertEquals(0, exec("def d = Integer.valueOf(0); Integer b = d; b"));
        assertEquals((long) 0, exec("def d = Character.valueOf(0); Long b = (Long)d; b"));
        assertEquals((char) 0, exec("def d = Integer.valueOf(0); char b = (char)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (int)0; short b = d;"));  
        assertEquals((char) 0, exec("def d = (byte)0; Character b = (Character)d; b"));
        assertEquals(0, exec("def d = (byte)0; Integer b = d; b"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = true; Character b = (Character)d;"));  
        assertEquals((char) 0, exec("def d = Character.valueOf(0); Character b = d; b"));
    public void testdefToIntegerExplicit() {
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (double)0; short b = d;"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = new ArrayList(); double b = d;"));
    public void testdefTointExplicit() {
        expectScriptThrows(ClassCastException.class, () -> exec("def d = true; int b = d;"));  
        assertEquals((long) 0, exec("def d = (short)0; long b = d; b"));
 * this work for additional information regarding copyright
 */  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (long)0; Character b = d;"));
        assertEquals((long) 0, exec("def d = 0; Long b = d; b"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (float)0; boolean b = (boolean)d;"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Long.valueOf(0); short b = d;"));  
        assertEquals(true, exec("def d = true; boolean b = (boolean)d; b"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Integer.valueOf(0); byte b = d;"));
        assertEquals((float) 0, exec("def d = (byte)0; float b = (float)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (int)0; Boolean b = (Boolean)d;"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Long.valueOf(0); Character b = d;"));  
    }
        assertEquals((float) 0, exec("def d = (short)0; Float b = d; b"));
        assertEquals((long) 0, exec("def d = Float.valueOf(0); long b = (long)d; b"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (double)0; Integer b = d;"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Double.valueOf(0); Boolean b = (Boolean)d;"));
        assertEquals((double) 0, exec("def d = (long)0; double b = d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = true; double b = (double)d;"));
        assertEquals((char) 0, exec("def d = (char)0; Character b = (Character)d; b"));  
 * ownership. Elasticsearch licenses this file to you under  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Integer.valueOf(0); Short b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (char)0; boolean b = (boolean)d;"));  
        assertEquals((short) 0, exec("def d = (short)0; Short b = (Short)d; b"));
        assertEquals(0, exec("def d = (long)0; int b = (int)d; b"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (byte)0; boolean b = d;"));  
        assertEquals((char) 0, exec("def d = (float)0; char b = (char)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Float.valueOf(0); long b = d;"));
        assertEquals((short) 0, exec("def d = Double.valueOf(0); Short b = (Short)d; b"));
        assertEquals(0, exec("def d = 0; Integer b = (Integer)d; b"));
        assertEquals((double) 0, exec("def d = Short.valueOf(0); double b = d; b"));
    }
        assertEquals((double) 0, exec("def d = Integer.valueOf(0); double b = (double)d; b"));
        assertEquals((float) 0, exec("def d = (float)0; Float b = d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Float.valueOf(0); boolean b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = 'string'; int b = d;"));
    public void testdefToFloatImplicit() {  
        assertEquals((double) 0, exec("def d = (float)0; double b = d; b"));  
        assertEquals((char) 0, exec("def d = Character.valueOf(0); char b = (char)d; b"));  
        assertEquals((long) 0, exec("def d = (byte)0; long b = (long)d; b"));
        assertEquals(0, exec("def d = Character.valueOf(0); Integer b = (Integer)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Boolean.valueOf(true); float b = d;"));  
        assertEquals(0, exec("def d = Short.valueOf(0); int b = (int)d; b"));
        assertEquals((char) 0, exec("def d = Float.valueOf(0); Character b = (Character)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Boolean.valueOf(true); short b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (float)0; boolean b = d;"));
        assertEquals((short) 0, exec("def d = Byte.valueOf(0); short b = (short)d; b"));  
        assertEquals((double) 0, exec("def d = Integer.valueOf(0); double b = d; b"));  
        assertFalse((boolean) exec("def chr = 10F; return (chr > (char)'x');"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (byte)0; Boolean b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Long.valueOf(0); Integer b = d;"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = 'string'; Byte b = (Byte)d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (int)0; byte b = d;"));  
 * license agreements. See the NOTICE file distributed with
        assertEquals(0, exec("def d = (double)0; Integer b = (Integer)d; b"));
        assertEquals((long) 0, exec("def d = (long)0; long b = d; b"));
        assertEquals((float) 0, exec("def d = 0; Float b = d; b"));  
        assertEquals((double) 0, exec("def d = (float)0; double b = (double)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = new ArrayList(); Integer b = (Integer)d;"));
package org.opensearch.painless;
        assertEquals((double) 0, exec("def d = Character.valueOf(0); double b = (double)d; b"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (short)0; byte b = d;"));
    public void testdefToShortExplicit() {  
        assertEquals((long) 0, exec("def d = Short.valueOf(0); Long b = (Long)d; b"));
        assertEquals((double) 0, exec("def d = (byte)0; Double b = (Double)d; b"));
        assertEquals((byte) 0, exec("def d = (byte)0; Byte b = d; b"));
        assertEquals(0, exec("def d = Long.valueOf(0); int b = (int)d; b"));
        assertEquals((double) 0, exec("def d = Float.valueOf(0); Double b = (Double)d; b"));
        assertEquals(false, exec("def d = Boolean.valueOf(false); boolean b = (boolean)d; b"));
        assertEquals((double) 0, exec("def d = (short)0; double b = (double)d; b"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Short.valueOf(0); Boolean b = d;"));
        assertEquals(0, exec("def d = Character.valueOf(0); int b = d; b"));
        assertEquals((char) 0, exec("def d = (double)0; char b = (char)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Double.valueOf(0); byte b = d;"));
        assertEquals(0, exec("def d = Long.valueOf(0); Integer b = (Integer)d; b"));
    public void testdefToFloatExplicit() {
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (int)0; Short b = d;"));
        assertEquals((byte) 0, exec("def d = (byte)0; byte b = d; b"));  
        assertEquals((long) 0, exec("def d = Integer.valueOf(0); Long b = d; b"));
        assertEquals((byte) 0, exec("def d = Short.valueOf(0); byte b = (byte)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (long)0; Integer b = d;"));
        assertEquals((long) 0, exec("def d = (double)0; long b = (long)d; b"));
 * The OpenSearch Contributors require contributions made to  
        assertEquals((double) 0, exec("def d = (byte)0; double b = d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (short)0; Character b = d;"));
    public void testdefToDoubleImplicit() {  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Integer.valueOf(0); Boolean b = d;"));
        assertEquals(0, exec("def d = Float.valueOf(0); Integer b = (Integer)d; b"));
        assertEquals((long) 0, exec("def d = Character.valueOf(0); long b = (long)d; b"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Long.valueOf(0); Boolean b = (Boolean)d;"));  
        assertEquals((long) 0, exec("def d = (char)0; long b = (long)d; b"));
        assertEquals((double) 0, exec("def d = Byte.valueOf(0); double b = (double)d; b"));
        assertEquals((long) 0, exec("def d = (float)0; Long b = (Long)d; b"));  
        assertEquals((double) 0, exec("def d = Float.valueOf(0); double b = d; b"));
 *
        assertEquals(0, exec("def d = (char)0; Integer b = d; b"));
        assertEquals((char) 0, exec("def d = (double)0; Character b = (Character)d; b"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = true; Integer b = (Integer)d;"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (float)0; Short b = d;"));
    }
    }
        assertEquals((float) 0, exec("def d = Byte.valueOf(0); float b = (float)d; b"));
    }
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Long.valueOf(0); boolean b = (boolean)d;"));
        assertEquals((byte) 0, exec("def d = (float)0; Byte b = (Byte)d; b"));
        assertEquals(0, exec("def d = (short)0; Integer b = d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Boolean.valueOf(true); short b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Long.valueOf(0); boolean b = d;"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (short)0; boolean b = d;"));
 * You may obtain a copy of the License at  
        assertEquals((long) 0, exec("def d = Long.valueOf(0); long b = d; b"));
        assertEquals((double) 0, exec("def d = (long)0; Double b = d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Boolean.valueOf(true); Character b = d;"));
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals((float) 0, exec("def d = Short.valueOf(0); Float b = d; b"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = 'string'; float b = d;"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = true; Long b = (Long)d;"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = new ArrayList(); Double b = d;"));  
        assertEquals((byte) 0, exec("def d = Character.valueOf(0); byte b = (byte)d; b"));
        assertEquals((long) 0, exec("def d = (short)0; Long b = d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Integer.valueOf(0); Byte b = d;"));
        assertEquals((long) 0, exec("def d = Double.valueOf(0); long b = (long)d; b"));
    public void testdefToBooleanImplicit() {
        expectScriptThrows(ClassCastException.class, () -> exec("def d = true; char b = (char)d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Short.valueOf(0); char b = d;"));
        assertEquals((double) 0, exec("def d = Character.valueOf(0); Double b = (Double)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = true; short b = (short)d;"));  
    public void testdefToCharacterExplicit() {  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Long.valueOf(0); int b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (int)0; Character b = d;"));  
        assertEquals((long) 0, exec("def d = Short.valueOf(0); long b = d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (float)0; Byte b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = 'string'; Integer b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Byte.valueOf(0); Character b = d;"));
        assertEquals((long) 0, exec("def d = 0; long b = d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (double)0; int b = d;"));
        assertEquals((long) 0, exec("def d = Float.valueOf(0); Long b = (Long)d; b"));
        assertEquals(true, exec("def d = true; Boolean b = d; b"));
        assertEquals((double) 0, exec("def d = Byte.valueOf(0); double b = d; b"));  
        assertEquals((double) 0, exec("def d = (long)0; Double b = (Double)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (char)0; Byte b = d;"));
        assertEquals((long) 0, exec("def d = Integer.valueOf(0); long b = (long)d; b"));
        assertEquals(0, exec("def d = Double.valueOf(0); Integer b = (Integer)d; b"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Float.valueOf(0); short b = d;"));
        assertEquals((byte) 0, exec("def d = (byte)0; Byte b = (Byte)d; b"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (int)0; boolean b = (boolean)d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = new ArrayList(); short b = (short)d;"));
        assertEquals((byte) 0, exec("def d = (double)0; byte b = (byte)d; b"));
        assertEquals((short) 0, exec("def d = (double)0; short b = (short)d; b"));
    }
    public void testdefToShortImplicit() {
        expectScriptThrows(ClassCastException.class, () -> exec("def d = true; Short b = d;"));
        assertEquals((double) 0, exec("def d = Integer.valueOf(0); Double b = d; b"));
 * this file be licensed under the Apache-2.0 license or a
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Character.valueOf(0); short b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = true; Float b = (Float)d;"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = 'string'; Integer b = d;"));
 * under the License.  
        assertEquals(false, exec("def d = Boolean.valueOf(false); Boolean b = (Boolean)d; b"));
        assertEquals(true, exec("def d = true; Boolean b = (Boolean)d; b"));
    public void testdefTodoubleExplicit() {
        assertEquals((float) 0, exec("def d = 0; Float b = (Float)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = 'string'; Float b = d;"));
        assertEquals((char) 0, exec("def d = Long.valueOf(0); char b = (char)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = 'string'; Float b = d;"));
        assertEquals(0, exec("def d = (char)0; int b = (int)d; b"));
        assertEquals(0, exec("def d = (byte)0; Integer b = (Integer)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Boolean.valueOf(true); double b = d;"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (double)0; Long b = d;"));  
        assertEquals((float) 0, exec("def d = (char)0; Float b = d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = new ArrayList(); Long b = (Long)d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = true; Double b = d;"));
    }
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (byte)0; char b = d;"));
    public void testdefToLongImplicit() {  
        assertEquals(0, exec("def d = Byte.valueOf(0); Integer b = d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (double)0; Float b = d;"));  
        assertEquals((float) 0, exec("def d = (double)0; Float b = (Float)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Boolean.valueOf(true); Integer b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (double)0; boolean b = d;"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = 'string'; boolean b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (double)0; byte b = d;"));  
        assertEquals((long) 0, exec("def d = Integer.valueOf(0); Long b = (Long)d; b"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = true; short b = d;"));
    }
        assertEquals((double) 0, exec("def d = Short.valueOf(0); Double b = (Double)d; b"));
        assertEquals((long) 0, exec("def d = Long.valueOf(0); Long b = d; b"));  
    public void testdefTocharExplicit() {
        assertEquals((double) 0, exec("def d = (float)0; Double b = d; b"));
    }
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Boolean.valueOf(true); char b = d;"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Character.valueOf(0); Boolean b = (Boolean)d;"));
        assertEquals((float) 0, exec("def d = (float)0; float b = (float)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Character.valueOf(0); Short b = d;"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = 'string'; Short b = (Short)d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = 'string'; char b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = true; long b = d;"));  
 */  
        assertEquals((char) 0, exec("def d = (long)0; Character b = (Character)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Boolean.valueOf(true); Short b = d;"));  
        assertEquals(0, exec("def d = 0; int b = d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Double.valueOf(0); Character b = d;"));
        assertEquals((double) 0, exec("def d = Short.valueOf(0); Double b = d; b"));  
        assertEquals((float) 0, exec("def d = Float.valueOf(0); float b = (float)d; b"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (int)0; boolean b = d;"));  
    }
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (double)0; Boolean b = d;"));
        assertEquals((char) 0, exec("def d = (long)0; char b = (char)d; b"));  
        assertEquals((long) 0, exec("def d = Character.valueOf(0); Long b = d; b"));
    public void testdefToBooleanExplicit() {  
        assertEquals((short) 0, exec("def d = Byte.valueOf(0); short b = d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (long)0; boolean b = d;"));
        assertEquals((char) 0, exec("def d = Double.valueOf(0); Character b = (Character)d; b"));  
        assertEquals((short) 0, exec("def d = Byte.valueOf(0); Short b = d; b"));
        assertEquals(false, exec("def d = Boolean.valueOf(false); Boolean b = d; b"));  
        assertEquals(0, exec("def d = Short.valueOf(0); Integer b = (Integer)d; b"));
        assertEquals((float) 0, exec("def d = (char)0; Float b = (Float)d; b"));  
        assertEquals((float) 0, exec("def d = Byte.valueOf(0); Float b = d; b"));
        assertEquals((double) 0, exec("def d = 0; Double b = (Double)d; b"));
        assertEquals((short) 0, exec("def d = 0; Short b = (Short)d; b"));  
        assertEquals((short) 0, exec("def d = Float.valueOf(0); short b = (short)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = true; Double b = (Double)d;"));  
        assertEquals((float) 0, exec("def d = Double.valueOf(0); float b = (float)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = new ArrayList(); Float b = (Float)d;"));
        assertEquals((double) 0, exec("def d = Long.valueOf(0); double b = (double)d; b"));
        assertEquals((double) 0, exec("def d = Character.valueOf(0); Double b = d; b"));
    }
    public void testdefToIntegerImplicit() {  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = 'string'; Long b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = new ArrayList(); Integer b = d;"));  
        assertEquals((double) 0, exec("def d = Character.valueOf(0); double b = d; b"));
        assertEquals((char) 0, exec("def d = Byte.valueOf(0); Character b = (Character)d; b"));  
        assertEquals((double) 0, exec("def d = (char)0; Double b = d; b"));
        assertEquals((short) 0, exec("def d = Character.valueOf(0); short b = (short)d; b"));
    }  
    public void testdefToshortExplicit() {
 * compatible open source license.
        assertEquals((double) 0, exec("def d = (double)0; double b = d; b"));
        assertEquals((long) 0, exec("def d = (char)0; Long b = d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Float.valueOf(0); char b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Double.valueOf(0); int b = d;"));  
    public void testdefTolongImplicit() {
        expectScriptThrows(ClassCastException.class, () -> exec("def d = true; byte b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (short)0; Byte b = d;"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (float)0; char b = d;"));  
        assertEquals((long) 0, exec("def d = Byte.valueOf(0); long b = d; b"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = 'string'; short b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (long)0; char b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = true; Float b = d;"));
        assertEquals((float) 0, exec("def d = Character.valueOf(0); Float b = d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Character.valueOf(0); Boolean b = d;"));  
        assertEquals((short) 0, exec("def d = (float)0; short b = (short)d; b"));  
        assertEquals(0, exec("def d = Character.valueOf(0); Integer b = d; b"));
        assertEquals(0, exec("def d = (double)0; int b = (int)d; b"));
        assertEquals((byte) 0, exec("def d = (double)0; Byte b = (Byte)d; b"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Float.valueOf(0); Integer b = d;"));
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals((byte) 0, exec("def d = Byte.valueOf(0); Byte b = (Byte)d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = new ArrayList(); long b = (long)d;"));
        assertEquals(0, exec("def d = (short)0; int b = d; b"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Float.valueOf(0); Boolean b = d;"));  
    public void testdefToStringImplicit() {
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Integer.valueOf(0); Boolean b = (Boolean)d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = 'string'; long b = d;"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = new ArrayList(); byte b = (byte)d;"));
        assertEquals((char) 0, exec("def d = (short)0; Character b = (Character)d; b"));
        assertEquals((double) 0, exec("def d = 0; double b = (double)d; b"));
    public void testdefToCharacterImplicit() {
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Double.valueOf(0); boolean b = (boolean)d;"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (byte)0; boolean b = (boolean)d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Boolean.valueOf(true); byte b = d;"));
        assertEquals((long) 0, exec("def d = (short)0; long b = (long)d; b"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = (char)0; boolean b = d;"));
        assertEquals((char) 0, exec("def d = Float.valueOf(0); char b = (char)d; b"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = true; Byte b = (Byte)d;"));
 *
        assertEquals((byte) 0, exec("def d = Float.valueOf(0); Byte b = (Byte)d; b"));
    public void testdefToByteExplicit() {  
        assertEquals((short) 0, exec("def d = Short.valueOf(0); short b = d; b"));  
        assertEquals((double) 0, exec("def d = (short)0; Double b = (Double)d; b"));
        assertEquals((long) 0, exec("def d = Integer.valueOf(0); long b = d; b"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Byte.valueOf(0); Boolean b = d;"));
        expectScriptThrows(ClassCastException.class, () -> exec("def d = Boolean.valueOf(true); int b = d;"));  
    public void testdefTobyteExplicit() {
        assertEquals((char) 0, exec("def d = Long.valueOf(0); Character b = (Character)d; b"));
    public void testdefTobooleanImplicit() {  
        assertEquals((byte) 0, exec("def d = (short)0; byte b = (byte)d; b"));
