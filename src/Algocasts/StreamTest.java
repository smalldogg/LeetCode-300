package Algocasts;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wangyh
 * @create 2020-06-17 9:23
 */
class P implements Comparable<P> {
		private int age;
		private String name;

		public P( int age, String name ) {
				this.age = age;
				this.name = name;
		}

		public int getAge( ) {
				return age;
		}

		public void setAge( int age ) {
				this.age = age;
		}

		public String getName( ) {
				return name;
		}

		@Override public String toString( ) {
				return "P{" + "age=" + age + ", name='" + name + '\'' + '}';
		}

		public void setName( String name ) {
				this.name = name;
		}

		@Override public boolean equals( Object o ) {
				if( this == o )
						return true;
				if( o == null || getClass( ) != o.getClass( ) )
						return false;
				P p = (P) o;
				return age == p.age && Objects.equals( name, p.name );
		}

		@Override public int hashCode( ) {
				return Objects.hash( age, name );
		}


		@Override public int compareTo( P p ) {
				if( p != null )
						return Integer.compare( this.getAge( ), p.getAge( ) );
				return -1;
		}
}


public class StreamTest {


		public static void main( String[] args ) {
				P p0 = new P( 2, "2" );
				P p1 = new P( 1, "1" );
				P p2 = new P( 2, "2" );
				P p3 = new P( 3, "3" );
				P p4 = new P( 4, "4" );
				List<P> list = new ArrayList<>( );
				list.add( p0 );
				list.add( p1 );
				list.add( p2 );
				list.add( p3 );
				list.add( p4 );
				//filterRelation(list);
				//stopRelation(list);
		}


		private static void listtoStirng( ) {
				List<String> list = new ArrayList<>( );
				list.add( "1" );
				list.add( "2" );
				System.out.println( list.toString( ) );
				Set<String> set = new HashSet<>( );
				set.add( "1" );
				System.out.println( set.toString( ) );
				StringBuilder sb = new StringBuilder( 2 );
				sb.append( "a" );
				sb.append( "," );
				System.out.println( sb.capacity( ) );
				String id = sb.substring( 0, sb.capacity( ) - 1 );
				System.out.println( id );
		}

		private static void stopRelation( List<P> list ) {
				//1.匹配与查找
				boolean b1 = list.stream( ).anyMatch( p -> p.getAge( ) > 2 );
				System.out.println( b1 );
				boolean b2 = list.stream( ).allMatch( p -> p.getAge( ) > 2 );
				System.out.println( b2 );
		}

		private static void filterRelation( List<P> list ) {
				list.stream( ).filter( p -> p.getAge( ) >= 2 ).distinct( ).limit( 2 ).skip( 1 ).forEach( System.out::println );
		}


		private static void mapRelation( List<P> list ) {
				Collections.shuffle( list );
				list.stream( ).map( P::getAge ).collect( Collectors.toList( ) ).forEach( System.out::println );
				System.out.println( );
				Map<Integer, List<P>> map = list.stream( ).collect( Collectors.groupingBy( P::getAge ) );
				for( Map.Entry entry : map.entrySet( ) ) {
						// System.out.println(entry.getKey() + " : " + entry.getValue());
				}
				list.stream( ).sorted( ).collect( Collectors.toList( ) ).forEach( System.out::println );
				//stream的操作 1.创建 2.中间操作 3.终止操作
				int[] ages = list.stream( ).mapToInt( P::getAge ).toArray( );
				for( int age : ages ) {
						System.out.println( age );
				}
		}
}
