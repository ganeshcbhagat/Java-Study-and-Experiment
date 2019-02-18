package main;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;

public class RSAExample {

	public static void main(String[] args) {
		
		/*	Theory of RSA algorithm
			http://doctrina.org/How-RSA-Works-With-Examples.html
			http://crypto.stackexchange.com/questions/5889/calculating-rsa-private-exponent-when-given-public-exponent-and-the-modulus-fact
			http://zobayer.blogspot.in/2009/07/extended-euclidean-algorithm.html
			https://simple.wikipedia.org/wiki/RSA_%28algorithm%29
			https://en.wikipedia.org/wiki/RSA_%28cryptosystem%29
		*/

		RSAExample rsa = new RSAExample(1024);
		Scanner in = new Scanner(System.in);
		String teststring = "";
		
		System.out.println("Enter the plain text:");
		teststring = in.nextLine();
		
		System.out.println("Plaintext: " + teststring);
		
		BigInteger plaintext = new BigInteger(teststring.getBytes());
		BigInteger ciphertext = rsa.encrypt(plaintext);
		System.out.println("Ciphertext: " + ciphertext);
		
		plaintext = rsa.decrypt(ciphertext);
		String text2 = new String(plaintext.toByteArray());
		System.out.println("Plaintext: " + text2);
		
		in.close();
		in=null;
	}

	private BigInteger n, d, e;

	private int bitlen = 1024;

	/** Create an instance that can encrypt using someone elses public key.*/
	public RSAExample(BigInteger newn, BigInteger newe) {
		n = newn;
		e = newe;
	}

	/** Create an instance that can both encrypt and decrypt. */
	public RSAExample(int bits) {
		bitlen = bits;
		SecureRandom r = new SecureRandom();
		BigInteger p = new BigInteger(bitlen / 2, 100, r);
		BigInteger q = new BigInteger(bitlen / 2, 100, r);
		n = p.multiply(q);
		BigInteger m = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
		e = new BigInteger("3");
		while (m.gcd(e).intValue() > 1) {
			e = e.add(new BigInteger("2"));
		}
		d = e.modInverse(m);
	}

	/** Encrypt the given plaintext message. */
	public synchronized String encrypt(String message) {
		return (new BigInteger(message.getBytes())).modPow(e, n).toString();
	}

	/** Encrypt the given plaintext message. */
	public synchronized BigInteger encrypt(BigInteger message) {
		return message.modPow(e, n);
	}

	/** Decrypt the given ciphertext message. */
	public synchronized String decrypt(String message) {
		return new String((new BigInteger(message)).modPow(d, n).toByteArray());
	}

	/** Decrypt the given ciphertext message. */
	public synchronized BigInteger decrypt(BigInteger message) {
		return message.modPow(d, n);
	}

	/** Generate a new public and private key set. */
	public synchronized void generateKeys() {
		SecureRandom r = new SecureRandom();
		BigInteger p = new BigInteger(bitlen / 2, 100, r);
		BigInteger q = new BigInteger(bitlen / 2, 100, r);
		n = p.multiply(q);
		BigInteger m = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
		e = new BigInteger("3");
		while (m.gcd(e).intValue() > 1) {
			e = e.add(new BigInteger("2"));
		}
		d = e.modInverse(m);
	}

	/** Return the modulus. */
	public synchronized BigInteger getN() {
		return n;
	}

	/** Return the public key. */
	public synchronized BigInteger getE() {
		return e;
	}
}
