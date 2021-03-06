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

  public static int[][] cmap;
  public static boolean quit = false;

  /**
  * Edit a image to pixelCanvas colors
  */
  public static Image editImage( Image image, int option ){

    Color[][] changed = new Color[ image.getWidth() ][ image.getHeight() ];

    // for each pixel
    for ( int i =0; i < changed.length; i++) {
      for ( int j=0 ; j < changed[0].length; j++) {
        changed[i][j] = palette[ Distance.minDistance( image.getMatrix()[i][j], palette, option ) ];
      }
    }

    // transform the matrix to a image
    return ( new Image( changed ) );
  }

  public static void makeCmap( Image image ) {
    cmap = new int[image.getWidth()][image.getHeight()];
    for ( int i =0; i < cmap.length; i++) {
      for ( int j=0 ; j < cmap[0].length; j++) {
        cmap[i][j] = Distance.minDistance( image.getMatrix()[i][j], palette, Distance.MANHATTAN );
      }
    }
  }

  public static void main(String [] args){


    // original image
    Image goma = new Image( "Fotos/gomaMelhor.bmp" );
    makeCmap(goma);

    new HorribleGUI();

  }// end main

  public static void start() {
    DRobot dr = new DRobot();

    // ultima cor usada
    int atualColor = cmap[0][0];

    for ( int j = Settings.firstPointY; j <= Settings.finalPointY; j++) {
    	for ( int i = Settings.firstPointX ; i <= Settings.finalPointX; i++) {

        // se a cor para pintar nao for branca
        // e a cor atual do pixel no site for diferente da que vamos pintar
        if( cmap[i][j] != 0  ){
          
          // apertar a tecla esc para tirar um possivel pop-up que esteja na tela
          dr.doType( java.awt.event.KeyEvent.VK_ESCAPE );

          // pega a cor do pixel que vai ser desenhado
          pickColor( cmap[i][j], dr );

          System.out.println("Draw point: "+i+","+j);
          // desenha na tela
          drawPoint( i, j, dr);

          // cooldown
          dr.delay( Settings.cooldown );
        }// fim if

      }// fim for
    }// fim for

    /*int i = 0;
    while (i!=15) {
      try {
        Thread.sleep(1000);
      }
      catch (InterruptedException iex) {}
      pickColor(i, dr);
      i = (i+1)%16;
    }
    */
  }

  public static void drawPoint(int i, int j, DRobot dr) {
    double delta = Settings.end.x - Settings.start.x;
    delta /= (cmap.length-1);
    int x = (int) (Settings.start.x + delta*i );
    int y = (int)( Settings.start.y + delta*j );

    System.out.println("xy: "+x+","+y);
    dr.clickAt(x, y);
  }

  public static void pickColor(int i, DRobot dr) {
    int x = Settings.color0_pos.x + (i%8)*32;
    int y = Settings.color0_pos.y + (i/8)*32;
    dr.clickAt(x, y);
  }
}
