package day01;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StringTest {

	public static void main(String[] args) {
		String s = "³ª´Â ÇÁ·Î±×·¡¸Ó ½º¸ÓÇÁ¾ß";
		String s2 = "ÁøÂ¥";
		// String: final Å¬·¡½º(»ó¼Ó ¸ø ¹ŞÀ½), immutability(ºÒº¯¼º), ¿øº» ºÒº¯
		System.out.println(s + s2); // ¹®ÀÚ¿­ °áÇÕ
		System.out.println(s.concat(s2));
		System.out.println(s);
		System.out.println(s.charAt(3));
		System.out.println(s.startsWith("³ª´Â") + "," + s.endsWith("³ª´Â"));
		// s¿¡¼­ ÇÁ·Î±×·¡¸Ó ´Ü¾î ÃßÃâÇØ Ãâ·Â
		System.out.println(s.substring(3, 8));

		int index = s.indexOf("ÇÁ·Î±×·¡¸Ó");
		if (index == -1) {
			System.out.println("ÇÁ·Î±×·¡¸Ó¶õ ´Ü¾î°¡ ¾ø½À´Ï´Ù.");
			return;
		}
		String str = s.substring(index, index + "ÇÁ·Î±×·¡¸Ó".length());
		System.out.println(str);
		System.out.println(s);

		// s¿¡¼­ ÇÁÀÚ°¡ À§Ä¡ÇÑ °÷ÀÇ ÀÎµ¦½º ¹øÈ£ Ã£¾Æ Ãâ·Â
		System.out.println(s.indexOf("ÇÁ"));
		// s¿¡¼­ "ÇÁ" ÀÚ°¡ À§Ä¡ÇÑ °÷ÀÇ ÀÎµ¦½º ¹øÈ£¸¦ µÚ¿¡¼­ Ã£¾Æ Ãâ·ÂÇÏ¼¼¿ä

		System.out.println(s.lastIndexOf("ÇÁ"));
		// ¹®ÀÚ¿­ ÆíÁı => StringBuffer(µ¿±âÈ­±¸ÇöµÊ), StringBuilder(µ¿±âÈ­ ±¸Çö ¾È µÊ)

		// ³ª¸¦ ³Ê·Î ¹ä²Ù¾î Ãâ·Â replace()
		System.out.println(s.replace("³ª´Â", "³Ê´Â"));

		// s¹®ÀÚ¿­À» °ø¹éÀ» ±âÁØÀ¸·Î ÂÉ°³¼­ ¹è¿­·Î ¸¸µé±â => split()
		String[] arr = s.split(" ");
		System.out.println(Arrays.toString(arr));

		System.out.println("---------------------");

		str = "[12, 25, 33, 8, 3, 60]";
		System.out.println(str);

		// [1] str¿¡ ÀúÀåµÈ °ªµéÀÇ ÇÕ°è°ªÀ» Ãâ·Â
		str = str.trim();
		str = str.replace("[", "");
		str = str.replace("]", "");
		arr = (str.split(", "));
		
		int[]intArr = new int[arr.length];
		int all=0;
		for(int i=0; i<arr.length; i++) {
			intArr[i]+=Integer.parseInt(arr[i]);
			all+=intArr[i];
		}
		System.out.println("ÇÕ°è: "+all);
		// [2] str¿¡ ÀúÀåµÈ °ªµéÀ» int[] ¹è¿­¿¡ ´ã¾Æ¼­ ¿À¸§Â÷¼ø Á¤·ÄÇØ Ãâ·ÂÇÏ¼¼¿ä
		Arrays.sort(intArr);
		System.out.println("¿À¸§Â÷¼ø Á¤·Ä: "+Arrays.toString(intArr));
	
		String s3="happy";
		//s3¿¡ ÀÖ´Â ¹®ÀÚµéÀ» char ¹è¿­¿¡ ÀúÀåÇÏ¼¼¿ä
		char[] ch = s3.toCharArray();
		System.out.println(Arrays.toString(ch));
		
		String s4=" 'ÈŞÁö', 'ºí·çº¼Ææ', 'Áö¿ì°³', +=-";
		
		//s4 Æ¯¼ö¹®ÀÚ Á¦°ÅÇÑ ÈÄ Ãâ·Â
		System.out.println(s4.replace("+=-", " "));
		
		String s5=s4.replaceAll("[^°¡-ÆR]", "");
		//ÇÑ±Û ¾Æ´Ï¸é ¸ğµÎ ºó¹®ÀÚ¿­·Î ´ëÃ¼
 		System.out.println(s5);
	}

}
