import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ventana2 extends JFrame {

	private Mapa mapitaCool;
	private JLabel ene, pp1, pp2, pp3, pp4;
	private JPanel panel1, panel2;
	String m1, m2, m3, m4, p1, p2, p3, p4, e1, e2, e3, e4, h1, h2, h3, h4, g1, g2, g3, g4, v1, v2, v3, v4, l1, l2, l3,
			l4;
	String momia, pintura, escultura, hammu, gio, venus, libertad;
	private JButton cerrar;
	private int index;

	public Ventana2(Mapa mapitaCool, int index) {
		this.mapitaCool = mapitaCool;
		this.index = index;
		setSize(450, 800);
		setTitle("Enemigos");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(2, 1));
		initHistoria();
		setVisible(true);
	}

	public void initHistoria() {

		m1 = "Es en el antiguo Egipto las momias eran un ritual funerario de los  ";
		m2 = "personajes importantes, ya que, solo preservando el cuerpo, el alma ";
		m3 = "iba a poder seguir su vida luego de la muerte.  ";
		m4 = "";

		p1 = "Pintura es un arte creada a partir de la aplicación de colores disueltos en";
		p2 = "aceites secantes sobre una superficie. El uso del óleo es muy antiguo";
		p3 = "y se masificó a partir del siglo XIV.";
		p4 = "";

		e1 = "Escultura es una obra de arte que se produce tallando o dando forma a ";
		e2 = "piedra, madera, arcilla u otros materiales.";

		h1 = "El Código de Hammurabi, datado hacia el año 1692 aC, es uno de los primeros ";
		h2 = "conjuntos de leyes que se han encontrado en el mundo.";
		h3 = "";
		h4 = "";

		g1 = "La Gioconda, delgada tabla de madera y oleo pintada por Leonardo Da Vinci";
		g2 = "entre (1503-1506) representa a una mujer universal idealizada.";
		g3 = " Leonardo opinaba que el bello rostro era el que importaba y no los adornos.";
		g4 = "";

		v1 = "La venus de Milo es la escultura de la diosa Venus, diosa del amor y ";
		v2 = "la belleza en la mitología, está hecha en mármol y es la más conocida";
		v3 = "de las esculturas antiguas. Fue encontrada en la isla Melos. ";
		v4 = "";

		l1 = "La libertad guiando al Pueblo pintada por Eugène Delacroix en 1830 y ";
		l2 = "representa a los revolucionarios franceses derrocando al rey Carlos X,";
		l3 = "la obra tiene una dosis de alegoría, en el centro una mujer rodeada";
		l4 = "por las diferentes clases sociales de Francia ";

		momia = "Img/momia.png";
		pintura = "Img/pintura.png";
		escultura = "Img/escultura.png";
		hammu = "Img/hammu.png";
		gio = "Img/mona.png";
		venus = "Img/venus.png";
		libertad = "Img/libertad.png";

		if (mapitaCool.getCasilla(index).getEnemigo().getNombre().equals("Momia")) {
			ImageIcon img = new ImageIcon(momia);

			ene = new JLabel(img);
			pp1 = new JLabel(m1);
			pp2 = new JLabel(m2);
			pp3 = new JLabel(m3);
			pp4 = new JLabel(m4);

		} else if (mapitaCool.getCasilla(index).getEnemigo().getNombre().equals("Obra de arte")) {
			ImageIcon img = new ImageIcon(pintura);

			ene = new JLabel(img);
			pp1 = new JLabel(p1);
			pp2 = new JLabel(p2);
			pp3 = new JLabel(p3);
			pp4 = new JLabel(p4);

		} else if (mapitaCool.getCasilla(index).getEnemigo().getNombre().equals("Escultura")) {
			ImageIcon img = new ImageIcon(escultura);

			ene = new JLabel(img);
			pp1 = new JLabel(e1);
			pp2 = new JLabel(e2);
			pp3 = new JLabel(e3);
			pp4 = new JLabel(e4);

		} else if (mapitaCool.getCasilla(index).getEnemigo().getNombre().equals("LaGioconda")) {
			ImageIcon img = new ImageIcon(gio);

			ene = new JLabel(img);
			pp1 = new JLabel(g1);
			pp2 = new JLabel(g2);
			pp3 = new JLabel(g3);
			pp4 = new JLabel(g4);

		} else if (mapitaCool.getCasilla(index).getEnemigo().getNombre().equals("ElHamurabi")) {
			ImageIcon img = new ImageIcon(hammu);

			ene = new JLabel(img);
			pp1 = new JLabel(h1);
			pp2 = new JLabel(h2);
			pp3 = new JLabel(h3);
			pp4 = new JLabel(h4);

		} else if (mapitaCool.getCasilla(index).getEnemigo().getNombre().equals("LaLibertadGuiandoAlPueblo")) {
			ImageIcon img = new ImageIcon(libertad);

			ene = new JLabel(img);
			pp1 = new JLabel(l1);
			pp2 = new JLabel(l2);
			pp3 = new JLabel(l3);
			pp4 = new JLabel(l4);

		} else if (mapitaCool.getCasilla(index).getEnemigo().getNombre().equals("LaVenusDeMilo")) {
			ImageIcon img = new ImageIcon(venus);

			ene = new JLabel(img);
			pp1 = new JLabel(v1);
			pp2 = new JLabel(v2);
			pp3 = new JLabel(v3);
			pp4 = new JLabel(v4);
		}

		cerrar = new JButton("cerrar");

		panel1 = new JPanel();
		panel1.add(ene);
		add(panel1);

		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(5, 1));
		panel2.add(pp1);
		panel2.add(pp2);
		panel2.add(pp3);
		panel2.add(pp4);
		panel2.add(cerrar);
		cerrar.addActionListener(new CloseListener());
		add(panel2);

	}

	public class CloseListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			setVisible(false);
			dispose();
			revalidate();
			repaint();

		}

	}
}