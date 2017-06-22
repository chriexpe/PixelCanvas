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

  public Image( Color[][] m ){

    // *** copy matrix ***

    this.matrix = new Color[ m.length ][ m[0].length ];

    for ( int i = 0; i < matrix.length; i++) {
      for ( int j = 0; j < matrix[0].length; j++) {
        this.matrix[i][j] = m[i][j];
      }
    }

    // *** end copy matrix ***

    // *** transform matrix to a BufferedImage ***

    this.image = new BufferedImage( matrix.length, matrix[0].length, BufferedImage.TYPE_INT_RGB);

    for ( int i = 0; i < matrix.length; i++) {
      for ( int j = 0; j < matrix[0].length; j++) {
        this.image.setRGB(i, j, matrix[i][j].getRGB());
      }
    }

    // *** end transform matrix to a BufferedImage ***

  }// end constructor( Color[][] )

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

  /**
  * Save the image to a file
  */
  public void saveImage( String path, String extension ){

    try{
      File outputfile = new File( path+"."+extension );
      ImageIO.write( this.image, extension, outputfile);
    }catch( IOException ioe ){}

  }

  public Color[][] getMatrix( ){
    return this.matrix;
  }

  public int getWidth(){
    return image.getWidth();
  }

  public int getHeight(){
    return image.getHeight();
  }

}// end class Image
