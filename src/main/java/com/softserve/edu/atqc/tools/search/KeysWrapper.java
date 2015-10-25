package com.softserve.edu.atqc.tools.search;

import com.softserve.edu.atqc.tools.search.*;

import java.util.Arrays;

import org.openqa.selenium.Keys;

import com.softserve.edu.atqc.tools.controls.*;

public class KeysWrapper{
	
}
//	public enum KeysWrapper {
//		 NULL ('\uE000'),
//		ENTER ('\uE007');
//		private final char keyCode;
//
//		private KeysWrapper(KeysWrapper key) {
//			this(key.charAt(0));
//		}
//
//		private KeysWrapper(char keyCode) {
//			this.keyCode = keyCode;
//		}
//
//		public char charAt(int index) {
//			if (index == 0) {
//				return keyCode;
//			}
//
//			return 0;
//		}
//
//		public int length() {
//			return 1;
//		}
//
//		public CharSequence subSequence(int start, int end) {
//			if (start == 0 && end == 1) {
//				return String.valueOf(keyCode);
//			}
//
//			throw new IndexOutOfBoundsException();
//		}
//
//		@Override
//		public String toString() {
//			return String.valueOf(keyCode);
//		}
//	
//	
//	 public static String chord(CharSequence... value) {
//		    return chord(Arrays.asList(value));
//		  }
//
//		 
//		  public static String chord(Iterable<CharSequence> value) {
//		    StringBuilder builder = new StringBuilder();
//
//		    for (CharSequence seq : value) {
//		      builder.append(seq);
//		    }
//
//		    builder.append(KeysWrapper.NULL);
//		    return builder.toString();
//		  }
//
//		  
//		  public static KeysWrapper getKeyFromUnicode(char key) {
//		    for (KeysWrapper unicodeKey : values()) {
//		      if (unicodeKey.charAt(0) == key) {
//		        return unicodeKey;
//		      }
//		    }
//
//		    return null;
//		  }
//
//		}
////	