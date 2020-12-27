package 排序;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author wangyh
 * @create 2020-03-24 8:57
 */

public class UnsafeInsatance {
		public static Unsafe reflectGetUnsafe( ) {
				try {
						Field field = Unsafe.class.getDeclaredField( "theUnsafe" );
						field.setAccessible( true );
						return (Unsafe) field.get( null );
				} catch( Exception e ) {
						e.printStackTrace( );
				}
				return null;
		}
}
