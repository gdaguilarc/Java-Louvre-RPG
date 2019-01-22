import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.io.*;

public class Ventana extends JFrame {
	private JLabel etiqueta1, nombre, over, imagenWelcome, errores, continuar;
	private JTextField name;
	private int index, arma = 1;
	private Mapa louvre;
	private JLabel position, des2, des3;
	private String scontinue = "  Heroe creado, Haz click en Iniciar Juego";
	private Heroe heroe;
	private JLabel snombre, pes, stipo, svida, svelocidad, sspeed, sdefensa, sdefence, snivel, sattack, sname, stype,
			slife, slevel, spower, sdescription, des, sexp, sxp;
	private JButton arriba, abajo, izq, dere, mart, save, conservar, noConservar;
	private ImageIcon icon;
	private JButton at, turbo, fisico, libroDeArte, libroDeHistoria, pc, camara, pincel;
	private JPanel controlesAtack, controlesSec, what, mov, hability, controlesAtack2, libros, weapons, decision;
	private JPanel welcome, crearHeroe, yesOrNo, tablero, ataque, jnombre, controles, stats, info, malla;
	private JButton ingresar, resume, itc, iniciar, lector, amante, foto;
	private Personaje enemy;

	public Ventana() {
		setSize(600, 1000);
		setTitle("Juego Aventura en el Louvre version 1.0");
		setLayout(new GridLayout(1, 1));
		initComponents();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void initComponents2() {
		sname.setText(louvre.getHeroe().getNombre());
		stype.setText(louvre.getHeroe().getTipo());
		slife.setText(Integer.toString(louvre.getHeroe().getVida()));
		slevel.setText(Integer.toString(louvre.getHeroe().getNivel()));
		spower.setText(Integer.toString(louvre.getHeroe().getAttack()));
		sxp.setText(Integer.toString(louvre.getHeroe().getXp()));
		sspeed.setText(Integer.toString(louvre.getHeroe().getSpeed()));
		sdefence.setText(Integer.toString(louvre.getHeroe().getDefensa()));
		pes.setText("Te has encontrado con un " + louvre.getCasilla(index).getObjeto().getNombre()
				+ " Deseas conservarlo??");
		des.setText("  Un enemigo " + louvre.getCasilla(index).getEnemigo().getNombre() + " salvaje con "
				+ louvre.getCasilla(index).getEnemigo().getVida() + " de vida. Que haras contra el?");
	}

	public void initTurn() {
		try {
			getContentPane().removeAll();
			initAttack();
			add(controlesAtack);
			initMap();
			add(malla);
			add(info);
			arma = 1;
			initComponents2();
			revalidate();
			repaint();
			des3.setText(" Usa tus ataques");
			des2.setText(" Preparate para la pelea");
			des.setText("  Un enemigo " + louvre.getCasilla2(index).getEnemigoVivo().getNombre() + " salvaje con "
					+ louvre.getCasilla(index).getEnemigo().getVida() + " de vida. Que haras contra el?");
			new Ventana2(louvre, index);
		} catch (ZombieException ex) {
			getContentPane().removeAll();
			add(controles);
			add(malla);
			add(info);
			initComponents2();
			des.setText(ex.getMessage());
			revalidate();
			repaint();
		} catch (GanarException ex) {
			setLayout(new GridLayout(1, 1));
			getContentPane().removeAll();
			add(new JLabel(new ImageIcon("Img/winner.png")));
			setBackground(Color.BLACK);
		}

	}

	public void initMap() {
		malla.removeAll();
		index = louvre.getPosicion();
		for (int i = 0; i < louvre.getPosicion(); i++) {
			malla.add(new JLabel(new ImageIcon("Img/mapsprite1.png")));
		}
		malla.add(position);
		for (int j = (louvre.getPosicion() + 1); j < louvre.getCasilla().length; j++) {
			if (j < louvre.getCasilla().length - 1) {
				malla.add(new JLabel(new ImageIcon("Img/mapsprite1.png")));
			} else {
				malla.add(new JLabel(new ImageIcon("Img/door.png")));
			}

		}
		revalidate();
		repaint();
	}

	public void initAttack() {
		controlesAtack.removeAll();
		controlesAtack.add(decision);
		controlesAtack.add(libros);
		controlesAtack.add(weapons);
		controlesAtack.add(controlesAtack2);
		controlesAtack.add(fisico);
	}

	public void initComponents() {

		over = new JLabel(new ImageIcon("Img/over.jpg"));

		// crear paneles
		welcome = new JPanel();
		welcome.setLayout(new GridLayout(4, 2));
		decision = new JPanel();
		decision.setLayout(new GridLayout(2, 1));
		yesOrNo = new JPanel();
		yesOrNo.setLayout(new GridLayout(1, 2));
		weapons = new JPanel();
		weapons.setLayout(new GridLayout(1, 3));
		libros = new JPanel();
		libros.setLayout(new GridLayout(1, 2));
		controlesSec = new JPanel();
		controlesSec.setLayout(new GridLayout(3, 1));
		what = new JPanel();
		what.setLayout(new GridLayout(3, 1));
		mov = new JPanel();
		mov.setLayout(new GridLayout(3, 3));
		controlesAtack2 = new JPanel();
		controlesAtack2.setLayout(new GridLayout(1, 2));
		controlesAtack = new JPanel();
		controlesAtack.setLayout(new GridLayout(5, 1));
		malla = new JPanel();
		malla.setLayout(new GridLayout(6, 4));
		malla.setBackground(Color.BLACK);
		info = new JPanel();
		info.setLayout(new GridLayout(2, 1));
		controles = new JPanel();
		controles.setLayout(new GridLayout(2, 1));
		stats = new JPanel();
		stats.setLayout(new GridLayout(9, 3));
		crearHeroe = new JPanel();
		crearHeroe.setLayout(new GridLayout(4, 2));
		tablero = new JPanel();
		ataque = new JPanel();

		// inicializar botones
		libroDeHistoria = new JButton(new ImageIcon("Img/historia.png"));
		libroDeHistoria.addActionListener(new HistoriaPoder());
		libroDeArte = new JButton(new ImageIcon("Img/arte.png"));
		libroDeArte.addActionListener(new ArtePoder());
		pc = new JButton(new ImageIcon("Img/pc.png"));
		pc.addActionListener(new PcPoder());
		camara = new JButton(new ImageIcon("Img/camara.png"));
		camara.addActionListener(new CamaraPoder());
		pincel = new JButton(new ImageIcon("Img/pincel.png"));
		pincel.addActionListener(new PincelPoder());

		// inicializar elementos de welcome
		etiqueta1 = new JLabel();
		etiqueta1.setText("<----------------------------------Bienvendo a Aventura en el Louvre--------------------->");
		ingresar = new JButton("Start New Game");
		ingresar.addActionListener(new MiListener());
		resume = new JButton("Continue");
		resume.addActionListener(new Load());
		icon = new ImageIcon("Img/louvre.png");
		imagenWelcome = new JLabel(icon);

		// inicializar stats
		snombre = new JLabel("  Nombre del heroe: ");
		stipo = new JLabel("  Special Ability: ");
		svida = new JLabel("  health points");
		snivel = new JLabel("  Level:");
		sattack = new JLabel("  Attack: ");
		sexp = new JLabel("  XP: ");
		svelocidad = new JLabel("  Speed: ");
		sdefensa = new JLabel("  Defence: ");

		sname = new JLabel();
		stype = new JLabel();
		slife = new JLabel();
		slevel = new JLabel();
		spower = new JLabel();
		sxp = new JLabel();
		sspeed = new JLabel();
		sdefence = new JLabel();
		sdescription = new JLabel("Situation...");

		// inicializar controles
		arriba = new JButton(new ImageIcon("Img/up.png"));
		arriba.addActionListener(new Arriba());
		abajo = new JButton(new ImageIcon("Img/down.png"));
		abajo.addActionListener(new Abajo());
		izq = new JButton(new ImageIcon("Img/left.png"));
		izq.addActionListener(new Izquierda());
		dere = new JButton(new ImageIcon("Img/rigth.png"));
		dere.addActionListener(new Derecha());

		// inicializar controles de ataque
		at = new JButton("Ataque Basico");
		at.addActionListener(new AtaqueNormal());
		turbo = new JButton("Ataque turboTec");
		turbo.addActionListener(new AtaqueTurbo());
		fisico = new JButton("Ataque arriesga fisico");
		fisico.addActionListener(new AtaqueFisico());

		// inicializar info
		des = new JLabel("  Listo para la aventura....");
		des2 = new JLabel("  Escapa del museo");
		des3 = new JLabel("  Las obras cobraron vida");
		what.add(des);
		what.add(des2);
		what.add(des3);

		// inicializar controles sec
		controlesSec.add(new JLabel());
		controlesSec.add(new JLabel());
		save = new JButton("Save Game");
		save.addActionListener(new Save());
		controlesSec.add(save);

		// inicializar elementos de crearHeroe
		name = new JTextField(10);
		nombre = new JLabel();
		nombre.setText("Nombre: ");
		itc = new JButton("Estudiante ITC");
		itc.addActionListener(new Heroe1());
		amante = new JButton("Amante del Oleo");
		amante.addActionListener(new Heroe2());
		lector = new JButton("Lector de tragedias griegas");
		lector.addActionListener(new Heroe3());
		foto = new JButton("Fotografo de esculturas");
		foto.addActionListener(new Heroe4());
		iniciar = new JButton("Iniciar Juego");
		iniciar.addActionListener(new IniciarJuego());
		continuar = new JLabel();

		// agregar elementos a welcome
		welcome.add(etiqueta1);
		welcome.add(ingresar);
		welcome.add(resume);
		welcome.add(imagenWelcome);

		// agregar elementos a crearHeroe
		crearHeroe.add(nombre);
		crearHeroe.add(name);
		crearHeroe.add(itc);
		crearHeroe.add(amante);
		crearHeroe.add(lector);
		crearHeroe.add(foto);
		crearHeroe.add(iniciar);
		crearHeroe.add(continuar);

		// agregar stats
		stats.add(snombre);
		stats.add(new JLabel(new ImageIcon("Img/player.png")));
		stats.add(sname);

		stats.add(stipo);
		stats.add(new JLabel(new ImageIcon("Img/ability.png")));
		stats.add(stype);

		stats.add(sexp);
		stats.add(new JLabel(new ImageIcon("Img/xp.png")));
		stats.add(sxp);

		stats.add(svida);
		stats.add(new JLabel(new ImageIcon("Img/life.png")));
		stats.add(slife);

		stats.add(sattack);
		stats.add(new JLabel(new ImageIcon("Img/sword.png")));
		stats.add(spower);

		stats.add(sdefensa);
		stats.add(new JLabel(new ImageIcon("Img/shield.png")));
		stats.add(sdefence);

		stats.add(svelocidad);
		stats.add(new JLabel(new ImageIcon("Img/speed.png")));
		stats.add(sspeed);

		stats.add(snivel);
		stats.add(new JLabel(new ImageIcon("Img/level.png")));
		stats.add(slevel);

		stats.add(sdescription);

		// agregar a info
		info.add(stats);
		info.add(what);

		// agregar a controles de ataque
		pes = new JLabel();
		conservar = new JButton("Conservar objeto");
		conservar.addActionListener(new Conservar());
		noConservar = new JButton("No conservar");
		noConservar.addActionListener(new NoConservar());
		controlesAtack2.add(at);
		controlesAtack2.add(turbo);
		weapons.add(pc);
		weapons.add(camara);
		weapons.add(pincel);
		libros.add(libroDeArte);
		libros.add(libroDeHistoria);
		yesOrNo.add(conservar);
		yesOrNo.add(noConservar);
		decision.add(pes);
		decision.add(yesOrNo);

		// inicializar controles
		mov.add(new JLabel(new ImageIcon("Img/wood1.png")));
		mov.add(arriba);
		mov.add(new JLabel(new ImageIcon("Img/wood1.png")));
		mov.add(izq);
		mov.add(new JLabel(new ImageIcon("Img/center.png")));
		mov.add(dere);
		mov.add(new JLabel(new ImageIcon("Img/wood1.png")));
		mov.add(abajo);
		mov.add(new JLabel(new ImageIcon("Img/wood1.png")));
		controles.add(controlesSec);
		controles.add(mov);
		add(welcome);
	}

	public class Conservar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				louvre.getHeroe().setObjeto(louvre.getCasilla(index).getObjeto());
				controlesAtack.removeAll();
				controlesAtack.add(new JLabel());
				controlesAtack.add(libros);
				controlesAtack.add(weapons);
				controlesAtack.add(controlesAtack2);
				controlesAtack.add(fisico);
				des2.setText("Has agregado un " + louvre.getCasilla(index).getObjeto().getNombre()
						+ " a tu mochila, tienes " + Heroe.numeroObjetos + " de objetos.");
				revalidate();
				repaint();
			} catch (MochilaFullException ex) {
				des2.setText(ex.getMessage());
			} catch (ArmaExistenteException ex) {
				des2.setText(ex.getMessage());
			}

		}
	}

	public class NoConservar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			controlesAtack.removeAll();
			controlesAtack.add(new JLabel());
			controlesAtack.add(libros);
			controlesAtack.add(weapons);
			controlesAtack.add(controlesAtack2);
			controlesAtack.add(fisico);
			des2.setText("No lo conservaste");
			revalidate();
			repaint();
		}
	}

	public class HistoriaPoder implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				louvre.getHeroe().searchObjeto("Libro de Historia");
				initComponents2();
			} catch (NoObjetoException ex) {
				des2.setText(ex.getMessage());
			}
		}
	}

	public class ArtePoder implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				louvre.getHeroe().searchObjeto("Libro de Arte");
				initComponents2();
			} catch (NoObjetoException ex) {
				des2.setText(ex.getMessage());
			}
		}
	}

	public class PcPoder implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (arma == 1) {
				try {
					louvre.getHeroe().searchObjeto("Pc");
					initComponents2();
					arma = 0;
				} catch (NoObjetoException ex) {
					des2.setText(ex.getMessage());
				}
			} else {
				des2.setText("  Solo puedes usar un arma por turno.");
			}
		}
	}

	public class CamaraPoder implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (arma == 1) {
				try {
					louvre.getHeroe().searchObjeto("Camara");
					initComponents2();
					arma = 0;
				} catch (NoObjetoException ex) {
					des2.setText(ex.getMessage());
				}
			} else {
				des2.setText("  Solo puedes usar un arma por turno.");
			}
		}
	}

	public class PincelPoder implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (arma == 1) {
				try {
					louvre.getHeroe().searchObjeto("Pincel");
					initComponents2();
					arma = 0;
				} catch (NoObjetoException ex) {
					des2.setText(ex.getMessage());
				}
			} else {
				des2.setText("  Solo puedes usar un arma por turno.");
			}

		}
	}

	public class Load implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			File archivo = new File("game.paris");
			try {
				FileInputStream fin = new FileInputStream(archivo);
				ObjectInputStream ois = new ObjectInputStream(fin);
				louvre = (Mapa) ois.readObject();
				setSize(1500, 700);
				setLayout(new GridLayout(1, 3));
				getContentPane().removeAll();
				add(controles);
				if (louvre.getHeroe().getTipo().equals("pintura")) {
					position = new JLabel(new ImageIcon("Img/mapspriteoleo.png"));
				} else if (louvre.getHeroe().getTipo().equals("fotografia")) {
					position = new JLabel(new ImageIcon("Img/mapspritecam.png"));
				} else if (louvre.getHeroe().getTipo().equals("inteligencia")) {
					position = new JLabel(new ImageIcon("Img/itc.png"));
				} else {
					position = new JLabel(new ImageIcon("Img/mapspritetrag.png"));
				}

				initMap();
				add(malla);
				add(info);
				initComponents2();
				revalidate();
				repaint();
				System.out.println("");
				louvre.imprimirCasillas();
			} catch (IOException ex) {
				etiqueta1.setText("Error al leer archivo");
			} catch (ClassNotFoundException ex) {
				etiqueta1.setText("Error al hacer casting");
			}

		}
	}

	public class Save implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Save
			try {
				FileOutputStream fout = new FileOutputStream("game.paris");
				ObjectOutputStream oos = new ObjectOutputStream(fout);
				oos.writeObject(louvre);
				oos.close();
			} catch (IOException ex) {
				des3.setText("Error al guardar el archivo.");
			}
		}
	}

	public class Arriba implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (louvre.getPosicion() - 4 >= 0) {
				louvre.setPosicion(louvre.getPosicion() - 4);
				initMap();
				initTurn();
			}
		}
	}

	public class Abajo implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (louvre.getPosicion() + 4 < 24) {
				louvre.setPosicion(louvre.getPosicion() + 4);
				initMap();
			}
			initTurn();
		}
	}

	public class Izquierda implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (louvre.getPosicion() - 1 >= 0) {
				louvre.setPosicion(louvre.getPosicion() - 1);
				initMap();
				initTurn();
			}
		}
	}

	public class Derecha implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (louvre.getPosicion() + 1 < 24) {
				louvre.setPosicion(louvre.getPosicion() + 1);
				initMap();
				initTurn();
			}
		}
	}

	public class MiListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			remove(welcome);
			add(crearHeroe);
			revalidate();
			repaint();
		}
	}

	public class Heroe1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				heroe = new EstudianteITC(name.getText());
				heroe.setStats(80, 110, 80, 50, 5);
				continuar.setText(scontinue);
				position = new JLabel(new ImageIcon("Img/itc.png"));
			} catch (NullPointerException ex) {
				continuar.setText("  Error eso esta vacio!!!");
			}
		}
	}

	public class Heroe2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				heroe = new AmanteDelOleo(name.getText());
				heroe.setStats(60, 90, 70, 100, 5);
				continuar.setText(scontinue);
				position = new JLabel(new ImageIcon("Img/mapspriteoleo.png"));
			} catch (NullPointerException ex) {
				continuar.setText("  Error eso esta vacio!!!");
			}
		}
	}

	public class Heroe3 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				heroe = new LectorDeTragediasGriegas(name.getText());
				heroe.setStats(70, 75, 90, 85, 5);
				continuar.setText(scontinue);
				position = new JLabel(new ImageIcon("Img/mapspritetrag.png"));
			} catch (NullPointerException ex) {
				continuar.setText("  Error eso esta vacio!!!");
			}
		}
	}

	public class Heroe4 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				heroe = new FotografoDeEsculturas(name.getText());
				heroe.setStats(60, 60, 120, 80, 5);
				continuar.setText(scontinue);
				position = new JLabel(new ImageIcon("Img/mapspritecam.png"));
			} catch (NullPointerException ex) {
				continuar.setText("  Error eso esta vacio!!!");
			}

		}
	}

	public class IniciarJuego implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			try {
				louvre = new Mapa(heroe);
				louvre.getHeroe().setNivel(5);
				louvre.setCasillas();
				// louvre.imprimirCasillas();
				setSize(1500, 700);
				setLayout(new GridLayout(1, 3));
				remove(crearHeroe);
				add(controles);
				initMap();
				add(malla);
				add(info);

				initComponents2();
			} catch (NullPointerException ex) {
				continuar.setText("  Error eso esta vacio!!!");
			}

		}
	}

	public class AtaqueNormal implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				if (louvre.getHeroe().getSpeed() >= louvre.getCasilla(index).getEnemigo().getSpeed()) {
					louvre.getHeroe().ataque(louvre.getCasilla(index).getEnemigo());
					initComponents2();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException ex) {
					}
					louvre.getCasilla(index).getEnemigo().ataque(louvre.getHeroe());
					initComponents2();
				} else {
					louvre.getCasilla(index).getEnemigo().ataque(louvre.getHeroe());
					initComponents2();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException ex) {
					}

					louvre.getHeroe().ataque(louvre.getCasilla(index).getEnemigo());
					initComponents2();
				}
			} catch (MuerteHeroeException ex) {
				setLayout(new GridLayout(1, 1));
				getContentPane().removeAll();
				add(over);
				setBackground(Color.BLACK);
			} catch (MuerteEnemigoException ex) {

				getContentPane().removeAll();
				louvre.getHeroe().levelUp(
						louvre.getHeroe().getXp() + louvre.getHeroe().gainXp(louvre.getCasilla(index).getEnemigo()));
				add(controles);
				add(malla);
				add(info);
				louvre.getHeroe().refresh();
				initComponents2();
				des.setText(ex.getMessage());
				revalidate();
				repaint();

			}

		}
	}

	public class AtaqueTurbo implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				if (louvre.getHeroe().getSpeed() >= louvre.getCasilla(index).getEnemigo().getSpeed()) {
					Heroe.contadorTurbosLess();
					des2.setText("Te quedan " + Heroe.contador + " ataques turbo.");
					louvre.getHeroe().ataqueTurbo(louvre.getCasilla(index).getEnemigo(), Heroe.contador);
					initComponents2();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException ex) {
					}
					louvre.getCasilla(index).getEnemigo().ataque(louvre.getHeroe());
					initComponents2();
				} else {
					louvre.getCasilla(index).getEnemigo().ataque(louvre.getHeroe());
					initComponents2();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException ex) {
					}
					Heroe.contadorTurbosLess();
					des2.setText("Te quedan " + Heroe.contador + " ataques turbo.");
					louvre.getHeroe().ataqueTurbo(louvre.getCasilla(index).getEnemigo(), Heroe.contador);
					initComponents2();
				}
			} catch (MuerteHeroeException ex) {
				setLayout(new GridLayout(1, 1));
				getContentPane().removeAll();
				add(over);
				setBackground(Color.BLACK);
			} catch (MuerteEnemigoException ex) {
				getContentPane().removeAll();
				louvre.getHeroe().levelUp(
						louvre.getHeroe().getXp() + louvre.getHeroe().gainXp(louvre.getCasilla(index).getEnemigo()));
				add(controles);
				initMap();
				add(malla);
				add(info);
				louvre.getHeroe().refresh();
				initComponents2();
				des.setText(ex.getMessage());
				revalidate();
				repaint();

			} catch (SinTurboException ex) {
				des.setText(ex.getMessage());
			}
		}
	}

	public class AtaqueFisico implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				if (louvre.getHeroe().getSpeed() >= louvre.getCasilla(index).getEnemigo().getSpeed()) {
					louvre.getHeroe().ataqueFisico(louvre.getCasilla(index).getEnemigo());
					initComponents2();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException ex) {
					}
					louvre.getCasilla(index).getEnemigo().ataque(louvre.getHeroe());
					initComponents2();
				} else {
					louvre.getCasilla(index).getEnemigo().ataque(louvre.getHeroe());
					initComponents2();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException ex) {
					}
					louvre.getHeroe().ataqueFisico(louvre.getCasilla(index).getEnemigo());
					initComponents2();
				}
			} catch (MuerteHeroeException ex) {
				setLayout(new GridLayout(1, 1));
				getContentPane().removeAll();
				add(over);
				setBackground(Color.BLACK);
			} catch (MuerteEnemigoException ex) {
				getContentPane().removeAll();
				louvre.getHeroe().levelUp(
						louvre.getHeroe().getXp() + louvre.getHeroe().gainXp(louvre.getCasilla(index).getEnemigo()));
				add(controles);
				initMap();
				add(malla);
				add(info);
				louvre.getHeroe().refresh();
				initComponents2();
				des.setText(ex.getMessage());
				revalidate();
				repaint();

			}
		}
	}
}
