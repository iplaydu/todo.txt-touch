/**
 *
 * Todo.txt Touch tests/src/com/todotxt/todotxttouch/util/StringsTest.java
 *
 * Copyright (c) 2011 Tim Barlotta
 *
 * LICENSE:
 *
 * This file is part of Todo.txt Touch, an Android app for managing your todo.txt file (http://todotxt.com).
 *
 * Todo.txt Touch is free software: you can redistribute it and/or modify it under the terms of the GNU General Public
 * License as published by the Free Software Foundation, either version 2 of the License, or (at your option) any
 * later version.
 *
 * Todo.txt Touch is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with Todo.txt Touch.  If not, see
 * <http://www.gnu.org/licenses/>.
 * 
 * StringsTest
 * A JUnit based test class for the Strings class
 *
 * @author Tim Barlotta <tim[at]barlotta[dot]net>
 * @license http://www.gnu.org/licenses/gpl.html
 * @copyright 2011 Tim Barlotta
 */
package com.todotxt.todotxttouch.util;

import junit.framework.TestCase;

public class StringsTest extends TestCase {
	public void testIsEmptyOrNull_null() {
		assertTrue(Strings.isEmptyOrNull(null));
	}

	public void testIsEmptyOrNull_emptyString() {
		assertTrue(Strings.isEmptyOrNull(""));
	}

	public void testIsEmptyOrNull_nonEmpty() {
		assertFalse(Strings.isEmptyOrNull("qwerty"));
	}

	public void testIsEmptyOrNull_singleSpace() {
		assertFalse(Strings.isEmptyOrNull(" "));
	}

	public void testInsertPadded_null() {
		assertEquals("thistest", Strings.insertPadded("thistest", 4, null));
	}

	public void testInsertPadded_blank() {
		assertEquals("thistest", Strings.insertPadded("thistest", 4, ""));
	}

	public void testInsertPadded_invalidInsertionPoint_toosmall() {
		try {
			assertEquals("thistest", Strings.insertPadded("thistest", -1, "is"));
			fail("Exception not thrown");
		} catch (IndexOutOfBoundsException e) {
			// success
		}
	}

	public void testInsertPadded_invalidInsertionPoint_toolarge() {
		try {
			assertEquals("thistest", Strings.insertPadded("thistest", 99, "is"));
			fail("Exception not thrown");
		} catch (IndexOutOfBoundsException e) {
			// success
		}
	}

	public void testInsertPadded_simple() {
		assertEquals("this is test", Strings.insertPadded("thistest", 4, "is"));
	}

	public void testInsertPadded_simpleBegin() {
		assertEquals("is thistest", Strings.insertPadded("thistest", 0, "is"));
	}

	public void testInsertPadded_simpleEnd() {
		assertEquals("thistest is ", Strings.insertPadded("thistest", 8, "is"));
	}

	public void testInsertPadded_prepadded() {
		assertEquals("this is test", Strings.insertPadded("this test", 4, "is"));
	}

	public void testInsertPadded_prepaddedBegin() {
		assertEquals("is this test",
				Strings.insertPadded(" this test", 0, "is"));
	}

	public void testInsertPadded_prepaddedEnd1() {
		assertEquals("this test is ",
				Strings.insertPadded("this test ", 9, "is"));
	}

	public void testInsertPadded_prepaddedEnd2() {
		assertEquals("this test is ",
				Strings.insertPadded("this test ", 10, "is"));
	}
}
