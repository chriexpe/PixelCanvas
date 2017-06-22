import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EtchedBorder;

class HorribleGUI extends JFrame {

  Timer t;

  public HorribleGUI() {
    super();
    JLabel mousePosX = new JLabel(""+MouseInfo.getPointerInfo().getLocation().getX());
    mousePosX.setBorder(new EtchedBorder());
    JLabel mousePosY = new JLabel(""+MouseInfo.getPointerInfo().getLocation().getY());
    mousePosY.setBorder(new EtchedBorder());
    JPanel p = new JPanel();
    p.setPreferredSize(new Dimension(170,50));
    JButton start = new JButton("Start");
    start.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
          Principal.start();
        }
    });
    p.add(start);
    p.add(mousePosX);
    p.add(mousePosY);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    add(p);

    ActionListener callRepaint = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            mousePosX.setText(""+MouseInfo.getPointerInfo().getLocation().x);
            mousePosY.setText(""+MouseInfo.getPointerInfo().getLocation().y);
            repaint();
        }
    };

    t = new Timer(20, callRepaint);
    t.start();
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }
}
