import java.util.Arrays;
import java.awt.Color;

public class Principal{

  // Colors in the site
  public static final Color [] palette = {
    new Color( 255, 255, 255 ),
    new Color( 228, 228, 228 ),
    new Color( 136, 136, 136 ),
    new Color( 34, 34, 34),
    new Color( 255, 167, 209),
    new Color( 229, 0, 0),
    new Color( 229, 149, 0),
    new Color( 160, 106, 66),

    new Color( 229, 217, 0),
    new Color( 148, 224, 68),
    new Color( 2, 190, 1),
    new Color( 0, 211, 221),
    new Color( 0, 131, 199),
    new Color( 0, 0, 234),
    new Color( 207, 110, 228),
    new Color( 130, 0, 128)
  };

  /**
  * Edit a image to pixelCanvas colors
  */
  public static Image editImage( Image image ){

    Color[][] changed = new Color[ image.getWidth() ][ image.getHeight() ];

    // for each pixel
    for ( int i =0; i < changed.length; i++) {
      for ( int j=0 ; j < changed[0].length; j++) {
        changed[i][j] = palette[ Distance.minEuclidian( image.getMatrix()[i][j], palette ) ];
      }
    }

    // transform the matrix to a image
    return ( new Image( changed ) );
  }

  public static void main(String [] args){

    // original image
    Image goma = new Image( "Goma.bmp" );

    // image edited
    Image edit = editImage( goma );

    // save image in disk
    edit.saveImage( "Changed", "bmp" );

  }// end main
}
