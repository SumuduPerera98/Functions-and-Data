object q2 extends App{
      val w = new Rational(3)
      val x = new Rational(3,4)
      val y = new Rational(5,8)
      val z = new Rational(2,7)
      val t = x - y - z
      println(t)
}
class Rational( x:Int , y:Int ) {

      require(y>0 , "denominator should always be positive")

      private def gcd( a:Int , b:Int ):Int = {
            if ( b == 0 ) a
            else if ( b > a ) gcd( b , a )
            else gcd( b, a%b )
      }

      private val g = gcd( Math.abs(x) , y )
      val numer = x/g
      val deno = y/g
      def this( x : Int ) = this( x , 1 )
      def +( that : Rational ) :Rational = new Rational( this.numer * that.deno + that.numer * this.deno  , this.deno * that.deno )
      def neg : Rational = new Rational( -this.numer , this.deno )
      def -( that : Rational ) : Rational = this + that.neg
                                          @Override
      override def toString() : String = {
            deno match {
                  case x if x==1 => numer.toString
                  case _ => numer + "/" + deno
            }
      }
}
