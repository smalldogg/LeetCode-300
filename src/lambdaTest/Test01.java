package lambdaTest;

import com.sun.xml.internal.ws.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wangyh
 * @create 2020-11-19 16:32
 */

public class Test01 {
		public static void main( String[] args ) {

				String[] nums = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
				int step = 4;
				int i = 0, j = 0;
				int len = nums.length;
				for( i = 0; i < nums.length; ++i ) {
						for( ; ( j + step ) < len; ) {
								System.out.println( nums[i] + nums[j] );
								j = ( j + step ) % len;
						}
						System.out.println( nums[i] + nums[j] );
						j = ( j + step ) % len;
				}
		}

		private static void test2( ) {
				Pattern p = Pattern.compile( "\\d+" );

				String[] str = p.split( "我的QQ是:456456我的电话是:0532214我的邮箱是:aaa@aaa.com" );


				Stream.of( str ).forEach( x -> System.out.println( x ) );
		}


		public static void test1( ) {
				Pattern p = Pattern.compile( "([a-z]+)(\\d+)" );
				Matcher m = p.matcher( "aaa2223bb" );
				System.out.println( m.find( ) );   //匹配aaa2223
				System.out.println( m.groupCount( ) );   //返回2,因为有2组
				System.out.println( m.start( 1 ) );   //返回0 返回第一组匹配到的子字符串在字符串中的索引号
				System.out.println( m.start( 2 ) );   //返回3
				System.out.println( m.end( 1 ) );   //返回3 返回第一组匹配到的子字符串的最后一个字符在字符串中的索引位置.
				System.out.println( m.end( 2 ) );   //返回7
				System.out.println( m.group( 1 ) );   //返回aaa,返回第一组匹配到的子字符串
				System.out.println( m.group( 2 ) );   //返回2223,返回第二组匹配到的子字符串
		}
}
