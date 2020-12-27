package BFS;

import 二叉树和分治法.TreeNode;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.function.Predicate;

/**
 * @author wangyh
 * @create 2020-05-25 13:29
 */

public class Test {

		public static void main( String[] args ) throws UnsupportedEncodingException {
				long l = LocalDateTime.now( ).toInstant( ZoneOffset.of( "+8" ) ).toEpochMilli( );
				System.out.println( l );
				String s = "1591946163926";
				long l2 = System.currentTimeMillis( );
				long l1 = Long.parseLong( s );
				System.out.println( l1 );
				long time = 1591946163926l;
				String str = String.format( "chuangqi%d", ( time >> ( ( time % 5 ) + 3 ) ) + time % 99999 );
				String encode;
				try {
						encode = URLEncoder.encode( str, StandardCharsets.UTF_8.displayName( ) );
						//String result = Base64Utils.encodeToString(encode.getBytes(StandardCharsets.UTF_8));
						System.out.println( encode );
				} catch( UnsupportedEncodingException e ) {

				}
		}


}
