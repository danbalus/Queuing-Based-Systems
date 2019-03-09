
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class InterfataSimulatorCozi extends JFrame implements ActionListener{

	private int startsant = 0;
	private static final long serialVersionUID = 1L;
	private Timer timer = new Timer();
	private JButton start = new JButton("Start");
	private JLabel nrCoziL = new JLabel ("Cozi");
	private JLabel nrClientiL = new JLabel ("Clienti");
	private JLabel tSosireMaxL = new JLabel ("Timp de sosire maxim");
	private JLabel tSosireMinL = new JLabel ("Timp de sosire minim");
	private JLabel tServireMaxL = new JLabel ("Timp de servire maxim");
	private JLabel tServireMinL = new JLabel ("Timp de servire minim");
	private JLabel durataSimulareL = new JLabel ("Durata simularii");
	private JLabel medieAsteptareL = new JLabel ("Medie Asteptare:");
	private JLabel medieServireL = new JLabel ("Medie Servire:");
	private JTextField nrCoziTextField = new JTextField("");
	private JTextField tSosireMaxTextField =new JTextField("");
	private JTextField tServireMaxTextField = new JTextField("");
	private JTextField tSosireMintTextField = new JTextField("");
	private JTextField tServireMinTextField = new JTextField("");
	private JTextField nrClientiTextField = new JTextField("");	
	private JTextField medieAsteptare = new JTextField("Medie Asteptare");	
	private JTextField medieServire = new JTextField("Medie Servire");	
	private JLabel timpRamas = new JLabel ("Timp ramas:");
	private JLabel coziLabel[];
	private JLabel ceas = new JLabel("");
	private Clock clock = new Clock();
	private int timpSosMax;
	private int tSosireMin;
	private int tServireMax;
	private int tServireMin;
	private int nrClienti;
	private int nrCozi;
	private Timer t;
	private int durataSim;
	public int nrc=0;
	private int ncl2=0;
	private int sant=0;
	private JTextArea log = new JTextArea();
	private JScrollPane jsp = new JScrollPane(log);
	private String a[];
	private JTextField coziTextField[]; //pentru fiecare coada face cate un Textfield
	private JTextField durataSimTextField = new JTextField("");	
	private JPanel panel = new JPanel();
	
	public InterfataSimulatorCozi()
	{	
		
		panel.setBounds(0, 0, 1080, 800);
		panel.setLayout(null);
	 	nrCoziL.setBounds(50,60,120,20);
	 	panel.add(nrCoziL);
	 	nrClientiL.setBounds(50,80,120,20);
	 	panel.add(nrClientiL);
	 	nrCoziTextField.setBounds(180,60,30,20);
	 	panel.add(nrCoziTextField);	
	 	timpRamas.setBounds(280,60,80,20);
	 	panel.add(timpRamas);	
	 	ceas.setBounds(360,60,100,20);
	 	panel.add(ceas);
	 	start.setBounds(50,200,80,20);
	 	start.addActionListener(this);
	 	panel.add(start);
	 	
	 	medieAsteptareL.setBounds(280,100,120,20);
	 	panel.add(medieAsteptareL);
	 	medieServireL.setBounds(280,130,120,20);
	 	panel.add(medieServireL);
	 	
	 	medieAsteptare.setBounds(390,100,120,20);
	 	panel.add(medieAsteptare);
	 	medieServire.setBounds(390,130,120,20);
	 	panel.add(medieServire);
	 	
	 	
	 	nrClientiTextField.setBounds(180,80,30,20);
	 	panel.add(nrClientiTextField);
	 	tSosireMaxL.setBounds(50,100,130,20);
	 	panel.add(tSosireMaxL);
	 	tSosireMaxTextField.setBounds(180,100,30,20);
	 	panel.add(tSosireMaxTextField);
	 	log.setEditable(false);
		jsp.setBounds(642, 0, 430, 767);
	 	panel.add(jsp);
		jsp.setVisible(true);
		tSosireMinL.setBounds(50,120,130,20);
	 	panel.add(tSosireMinL);
	 	tSosireMintTextField.setBounds(180,120,30,20);
	 	panel.add(tSosireMintTextField);
	 	tServireMaxL.setBounds(50,140,130,20);
	 	panel.add(tServireMaxL);
	 	tServireMaxTextField.setBounds(180,140,30,20);
	 	panel.add(tServireMaxTextField);
	 	tServireMinL.setBounds(50,160,130,20);
	 	panel.add(tServireMinL);
	 	tServireMinTextField.setBounds(180,160,30,20);
	 	panel.add(tServireMinTextField);
	 	durataSimulareL.setBounds(50,180,130,20);
	 	panel.add(durataSimulareL);
	 	durataSimTextField.setBounds(180,180,30,20);
	 	panel.add(durataSimTextField);
	 	this.add(panel);
	 	this.setVisible(true);
	 	this.setSize(1080, 800);
	 	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/*definita in interfata ActionListener si detecteaza daca a fost apasat vreunul dintre butoane, 
	in caz afirmativ se apealeaza metoda din clasa Operatii corespunzatoare butonului apasat.*/
	
	public void actionPerformed(ActionEvent e) 
	{
		Object ev;
		ev = e.getSource();//detecteaza un eveniment

		if (ev == start) 
		{		
			if (startsant == 1){
				for(int i = 1 ; i <= nrCozi; i++)
				{
					panel.remove(coziTextField[i]);
					panel.remove(coziLabel[i-1]);
				}
				panel.remove(coziLabel[nrCozi]);
			}
			startsant = 1;
			//culege informatiile introduse de utilizator
			timpSosMax = Integer.parseInt(tSosireMaxTextField.getText());
			tSosireMin = Integer.parseInt(tSosireMintTextField.getText());
			tServireMax = Integer.parseInt(tServireMaxTextField.getText());
			tServireMin = Integer.parseInt(tServireMinTextField.getText());
			nrClienti = Integer.parseInt(nrClientiTextField.getText());
			nrCozi = Integer.parseInt(nrCoziTextField.getText());
			durataSim = Integer.parseInt(durataSimTextField.getText());	
						
			ncl2 = nrClienti;
			clock.setClock(durataSim);
			clock.startCounter();
			paintCozi(nrCozi);
			t = new Timer();
			t.scheduleAtFixedRate(new Task(), 1000, 1000);//din secunda in secunda apelam run din clasa Task
		}
		//if (ev==reflection){ 
			//construieste un obiect de tip Reflection
			//Reflection r=new Reflection();}
		
	
	}
	
	public void setResult(int res){
		medieAsteptare.setText(" "+res);
	}
	
	
	public void setResult2(int res2){
		medieServire.setText(" "+res2);
	}
	private class Task extends TimerTask
	{
		Repartizator repartizator = new Repartizator(timpSosMax, tSosireMin, tServireMax, tServireMin, nrClienti, nrCozi,durataSim);
		//executa metoda start din clasa repartizator pana simularea va ajunge la final 
		//( expira timpul, sau nu mai sunt clienti care sa intre sau sa iasa din cozi).
		public void run() 
		{	int timp = 0;
			int ok = 1;
			a = new String[Integer.parseInt(nrCoziTextField.getText()) + 3]; //continutul unei cozi la momentul respectiv
			if (sant <= durataSim)
			{
				timp = 0;
				
				
				
				//sant = sant + 1;
				/*try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				ceas.setText(clock.getTime());
				a = repartizator.start(sant,nrc,ncl2);
				setCozi(nrCozi, a);
				if (a[nrCozi + 2] != "")
					log.append(a[nrCozi + 2] + "\n"); //sare la urmatoarea linie in log
				if (a[nrCozi + 3] != "")
					log.append(a[nrCozi + 3] + "\n");
				nrc = Integer.parseInt(a[nrCozi]);
				ncl2 = Integer.parseInt(a[nrCozi + 1]);
				sant ++;  //contor pentru timp
				
				//while (timp < 3){
				//	timp++;
				//	sant++;
				
				//	}
			}
			else 
				{
				t.cancel();  //simularea se opreste daca timpul a depasit timpul simularii
				log.setText("");
				nrc=0;
				sant=0;
				int servire;
				int asteptare;
				servire = repartizator.getMedieAsteptare();
				asteptare = repartizator.getMedieServire();
				setResult(servire);
				setResult2(asteptare);
				}
		}
	}
	
	/*adauga panoului un numar de labeluri si textfielduri corespunzator numarului de 
	cozi introdus de utilizator, unde vor fi afisati clientii care intra si care ies din fiecare coada in parte.*/
	public void paintCozi(int a)
	{	
		coziLabel = new JLabel[a + 1];
		coziTextField = new JTextField[a + 1];
		coziLabel[0]=new JLabel("Nr. Clienti");
		coziLabel[0].setBounds(50, 220, 110, 30);
		coziTextField[0]=new JTextField("");
		coziTextField[0].setBounds(110, 220, 30, 20);
		coziTextField[0].setEditable(false); //utlizatorul nu poate schimba continutul
		panel.add(coziTextField[0]); //adauga textfield pentru cozi
		panel.add(coziLabel[0]);
		for(int i = 1; i <= a; i++)
			{
			
			coziLabel[i]=new JLabel("Coada " + (i));
			coziLabel[i].setBounds(50, 180 + 40* (i + 1), 110, 30);
			coziTextField[i]=new JTextField("");
			coziTextField[i].setBounds(110, 180 + 40 * (i + 1), 300, 20);
			coziTextField[i].setEditable(false);
			panel.add(coziTextField[i]);
			panel.add(coziLabel[i]);
			}
		repaint();
	}
	
	/*afiseaza in cadrul textfieldurilor corespunzatoare cozilor clientii care se afla in cozile respective
	si afiseaza in cadrul logului ceea ce se petrece ( clientii care intra si ies din coada);*/
	public void setCozi(int c, String[] a)
	{
		coziTextField[0].setText(a[nrCozi + 1]);
		for(int i = 1; i < c + 1; i++)
		{
			coziTextField[i].setText(a[i-1]);
			panel.add(coziTextField[i]);
		}
	}
	
	//instantiaza un obiect al clasei , pentru rularea aplicatiei
	public static void main(String args[])
	{ 
		new InterfataSimulatorCozi();
	}
}
