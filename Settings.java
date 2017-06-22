import java.awt.Point;

class Settings {
  // Posição da cor branca na tela
  public static final Point color0_pos = new Point(569, 696);

  // Posição do ponto inicial e do ponto final de desenho na tela
  public static final Point start = new Point(1400, 800);
  public static final Point end = new Point(1400, 800);

  // ponto no eixo X para iniciar o desenho
  public static final int firstPointX = 0;
  // ponto no eixo X para finalizar o desenho
  public static final int finalPointX = 78;

  // ponto no eixo Y para iniciar o desenho
  public static final int firstPointY = 0;
  // ponto no eixo Y para finalizar o desenho
  public static final int finalPointY = 92;

  // cooldown por pixel, em milisegundos
  public static final int cooldown = 2000;
}
