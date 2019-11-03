/*
 * Copyright (c) 2006-2009 by Dirk Riehle, http://dirkriehle.com
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.wahlzeit.services;


import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;


import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * Test cases for the EmailAddress class.
 */
public class EmailAddressTest extends TestCase {

	@Before
	public void setup(){
		EmailAddress.instances.clear();
	}


	public EmailAddressTest(String name) {
		super(name);
	}
	public void testGetEmailAddressFromString() {
		// invalid email addresses are allowed for local testing and online avoided by Google

		assertTrue(createEmailAddressIgnoreException("bingo@bongo"));
		assertTrue(createEmailAddressIgnoreException("bingo@bongo.com"));
		assertTrue(createEmailAddressIgnoreException("bingo.bongo@bongo.com"));
		assertTrue(createEmailAddressIgnoreException("bingo+bongo@bango"));
	}

	/**
	 *
	 */
	protected boolean createEmailAddressIgnoreException(String ea) {
		try {
			EmailAddress.getFromString(ea);
			return true;
		} catch (IllegalArgumentException ex) {
			// creation failed
			return false;
		}
	}

	/**
	 *
	 */
	public void testEmptyEmailAddress() {
		assertFalse(EmailAddress.EMPTY.isValid());
	}



	@Test
	public void testEmailSet(){
		//EmailAddress.instances.clear();
		String emailString = "test@test.com";

		EmailAddress email = new EmailAddress(emailString);

		assertEquals(emailString, email.asString());
		assertEquals(emailString, email.toString());
	}

	@Test
	public void testEmailAsInternetAdress() throws AddressException {
	//	EmailAddress.instances.clear();
		String emailString = "test@test.com";

		EmailAddress email = new EmailAddress(emailString);
		InternetAddress Inet = email.asInternetAddress();

		assertEquals(emailString, new InternetAddress(emailString).getAddress());
	}

	@Test
	public void testEmailIsEqual() throws AddressException {
		//EmailAddress.instances.clear();
		String emailString = "test@test.com";

		EmailAddress email = new EmailAddress(emailString);
		EmailAddress sameMail = new EmailAddress(emailString);
		EmailAddress diffrentMail = new EmailAddress("diffrent" + emailString);

		assertTrue(email.isEqual(sameMail));
		assertFalse(email.isEqual(diffrentMail));
	}

	@Test
	public void testEmailIsValid() throws AddressException {
		//EmailAddress.instances.clear();
		String emailString = "test@test.com";
		String noAtSeparator = "noAtSeparator";
		String noLocalName = "@noLocalName";
		String noDomainName = "noDomainName@";
		String emptyName = "";


		EmailAddress validEmail = new EmailAddress(emailString);
		EmailAddress noAtMail = new EmailAddress(noAtSeparator);
		EmailAddress noLocalMail = new EmailAddress(noLocalName);
		EmailAddress noDomainMail = new EmailAddress(noDomainName);
		EmailAddress emptyMail = new EmailAddress(emptyName);

		assertTrue(validEmail.isValid());
		assertFalse(noAtMail.isValid());
		assertFalse(noLocalMail.isValid());
		assertFalse(noDomainMail.isValid());
		assertFalse(emptyMail.isValid());
	}


	@Test
	public void testAddSameAddress(){
	//	EmailAddress.instances.clear();
		String emailString = "test@test.com";


		EmailAddress emailGetOnce = EmailAddress.doGetFromString(emailString);
		EmailAddress emailGetTwice = EmailAddress.doGetFromString(emailString);

		assertTrue(emailGetOnce == emailGetTwice);
		assertEquals( emailString, emailGetOnce.asString() );
	}
}
