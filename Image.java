import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.Color;

public class Image{

  private BufferedImage image;
  // matrix with the RGB from each pixel
  private Color[][] matrix;

  /**
  * Read the image from disk
  */
  public Image( String path ){

    try {
      image = ImageIO.read(new File( path ));
    } catch (IOException e) {}

    // get the matrix RGB from the image
    imageToMatrix();
  }// end constructor( String )

  /**
  * Transform a image to a int matrix
  */
  public void imageToMatrix( ){

    int width = image.getWidth();
    int heigth = image.getHeight();

    matrix = new Color[ width ][ heigth ];

    for ( int i = 0; i < width; i++) {
      for ( int j = 0; j < heigth; j++) {

        matrix[i][j] = new Color( image.getRGB( i, j ) );
      }
    }
  }// end method imageToMatrix

  public Color[][] getMatrix( ){
    return this.matrix;
  }

}// end class Image
