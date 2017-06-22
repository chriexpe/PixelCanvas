import java.awt.Color;

public class Distance{

  public static final int CHESS = 1;
  public static final int MANHATTAN = 2;
  public static final int EUCLIDIAN = 3;

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

  public static int minDistance( Color color, Color[] array, int option ){
    double minDistance = Integer.MAX_VALUE;
    int pos = -1;
    double distance;

    for ( int i = 0; i < array.length; i++) {

      // verificar qual distancia deve ser feita
      switch( option ){
        case CHESS:
          distance = chess( color, array[i] );
          break;

        case MANHATTAN:
          distance = manhattan( color, array[i] );
          break;

        case EUCLIDIAN:
          distance = euclidian( color, array[i] );
          break;

        default:
          distance = Integer.MAX_VALUE;
      }// end switch

      if( distance < minDistance ){
        minDistance = distance;
        pos = i;
      }

    }// end for

    return pos;
  }// end method minDistance

}
