import java.awt.Color;

public class Distance{
  
  public static double chess( Color c1, Color c2 ){

    double distance = Math.max(Math.max(Math.abs(c1.getRed() - c2.getRed()), Math.abs(c1.getGreen() - c2.getGreen())), 
                               Math.abs(c1.getBlue() - c2.getBlue()));

    return distance;
  }
  
  public static double manhattan( Color c1, Color c2 ){

    double distanciaR = Math.abs( c1.getRed() - c2.getRed() );
    double distanciaG = Math.abs( c1.getGreen() - c2.getGreen() );
    double distanciaB = Math.abs( c1.getBlue() - c2.getBlue() );

    return distanciaR + distanciaG + distanciaB;
  }

  public static double euclidian( Color c1, Color c2 ){

    double distanciaR = Math.pow( c1.getRed() - c2.getRed() , 2 );
    double distanciaG = Math.pow( c1.getGreen() - c2.getGreen() , 2 );
    double distanciaB = Math.pow( c1.getBlue() - c2.getBlue() , 2 );

    return distanciaR + distanciaG + distanciaB;
  }

  /**
  * Acha a cor mais proxima dentro da paleta
  */
  public static int minEuclidian( Color color, Color [] array ){
    double minDistance = Integer.MAX_VALUE;
    int pos = -1;

    for ( int i = 0; i < array.length; i++ ) {

      double distance = euclidian( color, array[i] );

      if( distance < minDistance ){
        minDistance = distance;
        pos = i;
      }

    }

    return pos;
  }

}
