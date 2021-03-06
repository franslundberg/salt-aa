package saltaa;

import saltaa.nperf.Hex;


/**
 * NaCl test data. aEnc, bEnc, abSharedKey are taken from Bernstein's paper at
 * http://cr.yp.to/highspeed/naclcrypto-20090310.pdf.
 * Paper title: Cryptography in NaCl. Here called "Bernstein's paper".
 * They are encryption (key agreement) key pairs (not for signing).
 * 
 * @author Frans Lundberg
 */
public class SaltTestData {    
    public static byte[] aSigSec = Hex.toBytes("55f4d1d198093c84de9ee9a6299e0f6891c2e1d0b369efb592a9e3f169fb0f795529ce8ccf68c0b8ac19d437ab0f5b32723782608e93c6264f184ba152c2357b");
    public static byte[] aSigPub = Hex.toBytes("5529ce8ccf68c0b8ac19d437ab0f5b32723782608e93c6264f184ba152c2357b");

    public static byte[] aEncSec = new byte[] {
        0x77,0x07,0x6d,0x0a,0x73,0x18,(byte)0xa5,0x7d
        ,0x3c,0x16,(byte)0xc1,0x72,0x51,(byte)0xb2,0x66,0x45
        ,(byte)0xdf,0x4c,0x2f,(byte)0x87,(byte)0xeb,(byte)0xc0,(byte)0x99,0x2a
        ,(byte)0xb1,0x77,(byte)0xfb,(byte)0xa5,0x1d,(byte)0xb9,0x2c,0x2a
    };
    
    public static byte[] aEncPub = new byte[] {
        (byte)0x85,0x20,(byte)0xf0,0x09,(byte)0x89,0x30,(byte)0xa7,0x54
        ,0x74,(byte)0x8b,0x7d,(byte)0xdc,(byte)0xb4,0x3e,(byte)0xf7,0x5a
        ,0x0d,(byte)0xbf,0x3a,0x0d,0x26,0x38,0x1a,(byte)0xf4
        ,(byte)0xeb,(byte)0xa4,(byte)0xa9,(byte)0x8e,(byte)0xaa,(byte)0x9b,0x4e,0x6a
    };
    
    public static byte[] bEncSec = new byte[] {
        0x5d,(byte)0xab,0x08,0x7e,0x62,0x4a,(byte)0x8a,0x4b
        ,0x79,(byte)0xe1,0x7f,(byte)0x8b,(byte)0x83,(byte)0x80,0x0e,(byte)0xe6
        ,0x6f,0x3b,(byte)0xb1,0x29,0x26,0x18,(byte)0xb6,(byte)0xfd
        ,0x1c,0x2f,(byte)0x8b,0x27,(byte)0xff,(byte)0x88,(byte)0xe0,(byte)0xeb
    };
    
    public static byte[] bEncPub = new byte[] {
        (byte)0xde,(byte)0x9e,(byte)0xdb,0x7d,0x7b,0x7d,(byte)0xc1,(byte)0xb4
        ,(byte)0xd3,0x5b,0x61,(byte)0xc2,(byte)0xec,(byte)0xe4,0x35,0x37
        ,0x3f,(byte)0x83,0x43,(byte)0xc8,0x5b,0x78,0x67,0x4d
        ,(byte)0xad,(byte)0xfc,0x7e,0x14,0x6f,(byte)0x88,0x2b,0x4f
    };

    /**
     * Signature of the empty byte string (m = new byte[0]) using the aSigSec secret key.
     * Created 2018-02 by Frans Lundberg.
     */
    public static byte[] sig1 = Hex.toBytes("97b96e0a3b24bfadcb1a8764fea6953527ff9c5e4fd7fd92c361310b11258fbff410064eadfae41a0dd25cd34c5de495c8222048ca8dc0c790908579729f720c");

    /**
     * The "r0" data below is from the first line of the file: 
     * http://ed25519.cr.yp.to/python/sign.input.
     * That is: test data from Daniel Bernstein. For his Python implementation.
     */
    public static byte[] r0SigSec = Hex.toBytes("9d61b19deffd5a60ba844af492ec2cc44449c5697b326919703bac031cae7f60d75a980182b10ab7d54bfed3c964073a0ee172f3daa62325af021a68f707511a");
    public static byte[] r0SigPub = Hex.toBytes("d75a980182b10ab7d54bfed3c964073a0ee172f3daa62325af021a68f707511a");
    public static byte[] r0Message = Hex.toBytes("");
    public static byte[] r0SignedMessage = Hex.toBytes("e5564300c360ac729086e2cc806e828a84877f1eb8e5d974d873e065224901555fb8821590a33bacc61e39701cf9b46bd25bf5f0595bbe24655141438e7a100b");
    
    
    public static void main(String[] args) {
    	SaltLib lib = SaltLibFactory.getLib(SaltLibFactory.LibType.JAVA);
        byte[] m = new byte[0];
        byte[] sm = new byte[SaltLib.crypto_sign_BYTES + m.length];
        lib.crypto_sign(sm, m, aSigSec);
        System.out.println(Hex.create(sm));
    }
}
