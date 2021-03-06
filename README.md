salt-aa
=======

A Java API to TweetNaCl implementations. The following subset of the 
25 functions in [TWEET-1] are supported:

* crypto_sign_keypair.
* crypto_sign.
* crypto_sign_open.
* crypto_box_keypair.
* crypto_box_beforenm.
* crypto_box_afternm.
* crypto_box_open_afternm.
* crypto_hash.

crypto_sign_x functions implement the ed25519 signature scheme.
crypto_box_x functions implement public key authenticated encryption 
using x25519+xsalsa20+poly1305.

Our approach is to follow the original TweetNaCl/NaCl C API closely
as documented at [NACL] and implemented in the TweetNaCl source code
available at [TWEET-2].

Two implementations are supported

1. The pure Java implementation from 
   https://github.com/InstantWebP2P/.
   
2. The native Libsodium implementation that is typically
much faster than the Java version. See: 
    https://download.libsodium.org/doc/

Comments, implementation approach, etc:

* Unlike the TweetNaCl original, this library does not depend on random 
  data. All functions are pure functions; they are deterministic.
  
* C functions that always return 0 are implemented in Java using 
  Java methods with the "void" return type.
  
* Exceptions are sometimes used instead of returning an error code.

* Byte arrays are used with their lengths. That is, we do not pass in 
  offsets and size to allow for C-like array operations.
  
* Memory allocation is normally done by the caller.

* Input arguments are not normally checked. 
  For example, a NullPointerException may be thrown when an argument is null
  the first time the argument is used.

salt-aa is "Powered by Curve25519".


Usage
=====

To use the lib:

1. Create a SaltLib instance with:

    SaltLib lib = SaltLibFactory.getLib()
    
2. Then use the lib instance.

If you want to choose implementation specifically, 
call SaltLibFactory.getLib(LibType.JAVA) or SaltLib.getLib(LibType.NATIVE).

The build the lib, use ANT and build.xml.


Development
===========

To create a Java Eclipse project:

* Add src/ and src-test/ to source path.
* Add native libs according to lib-native/readme.md.
* Set out/classes as output for compiled Java classes.



Performance testing
===================

See package saltaa.nperf for performance testing. Run class nperf.NTestRunner
or EncryptPerformance.



References
==========

* **TWEET-1**. Daniel J. Bernstein, Bernard van Gastel, Wesley Janssen, Tanja Lange, 
  Peter Schwabe, Sjaak Smetsers. 
  *TweetNaCl: a crypto library in 100 tweets*. LatinCrypt 2014, to appear.
  
* **TWEET-2**. Website: http://tweetnacl.cr.yp.to.

* **NACL**. Website: http://nacl.cr.yp.to.
