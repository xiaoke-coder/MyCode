

public class testRational {
    public static void main(String[] args) {
        Rational r1 = new Rational(4, 2);
        Rational r2 = new Rational(2, 3);

        System.out.println(r1 + "+" + r2 + "=" + r1.add(r2));
        System.out.println(r1 + "-" + r2 + "=" + r1.substract(r2));
        System.out.println(r1 + "*" + r2 + "=" + r1.multiply(r2));
        System.out.println(r1 + "/" + r2 + "=" + r1.divide(r2));
        System.out.println(r2 + " is " + r2.doubleValue());

    }
}
     class Rational extends Number implements Comparable<Rational>{
       private long numerator=0;
       private long denominator=1;

       public Rational(){
           this(0,1);
       }
       public Rational (long numerator,long denominator){
           long gcd=gcd(numerator,denominator);
           this.numerator= ((denominator>0)?1:-1)*numerator/gcd;
           this.denominator=Math.abs(denominator)/gcd;
       }
       private static long gcd(long n,long d){
           long n1=Math.abs(n);
           long n2=Math.abs(d);
           int gcd=1;

           for(int k=1;k<=n1&&k<=n2;k++){
               if(n1%k==0&&n2%k==0)
                   gcd=k;
           }
           return gcd;
       }

       public long getNumerator(){
           return numerator;
       }
       public long getDenominator(){
            return denominator;
       }
       public Rational add(Rational secondRational){
           long n=numerator*secondRational.getDenominator()+
                   denominator*secondRational.getNumerator();
           long d=denominator*secondRational.getDenominator();
           return new Rational(n,d);
       }

        public Rational substract(Rational secondRational){
            long n=numerator*secondRational.getDenominator()-
                    denominator*secondRational.getNumerator();
            long d=denominator*secondRational.getDenominator();
            return new Rational(n,d);
        }

        public Rational multiply(Rational secondRational){
            long n=numerator*secondRational.getNumerator();
            long d=denominator*secondRational.getDenominator();
            return new Rational(n,d);
        }

        public Rational divide(Rational secondRational){
            long n=numerator*secondRational.getDenominator();
            long d=denominator*secondRational.getNumerator();
            return new Rational(n,d);
        }

        @Override
        public String toString(){
           if(denominator==1)
               return numerator+"";
           else
               return numerator+"/"+denominator;
        }

        @Override
        public boolean equals(Object obj) {
           if((this.substract((Rational)(obj))).getNumerator()==0)
               return true;
           else
              return false;
        }

        @Override
        public int intValue() {
            return (int)doubleValue();
        }

        @Override
        public float floatValue() {
            return (float)doubleValue();
        }

        @Override
        public double doubleValue() {
            return numerator*1.0/denominator;
        }

        @Override
        public long longValue() {
            return (long)doubleValue();
        }

        @Override
        public int compareTo(Rational o) {
           if(this.substract(o).getNumerator()>0)
               return 1;
           else if(this.substract(o).getNumerator()<0)
               return -1;
           else
            return 0;
        }
    }


