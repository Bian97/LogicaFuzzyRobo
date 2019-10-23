import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Principal extends JFrame {

	private JPanel contentPane;
	private static MotorInferencia motor = new MotorInferencia();
	private JLabel lblTabuleiro = new JLabel("...");

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
		
		//try {
			// TODO Auto-generated method stub		
			//motor.GerarTabuleiro();
	 
			/*for(;;) {
				TimeUnit.SECONDS.sleep(2);
				if(motor.Movimento()) {
					break;
				}
			}
			} catch (Exception e) {
				System.out.println("Erro!! " + e.getMessage());
			}*/
	/*}*/

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1115, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblTabuleiro.setVerticalAlignment(SwingConstants.TOP);
		
		
		lblTabuleiro.setBounds(10, 10, 933, 557);
		contentPane.add(lblTabuleiro);
		
		JButton btnGerarTabuleiro = new JButton("Gerar Tabuleiro");
		btnGerarTabuleiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ImprimirTabuleiro(motor.GerarTabuleiro());				
			}
		});
		btnGerarTabuleiro.setBounds(969, 10, 119, 40);
		contentPane.add(btnGerarTabuleiro);
	}

	public void ImprimirTabuleiro(String[][] campo){
        String tabuleiro = "";
        for (int x = 0; x < 50; x++) {
        	String num = "";
        	if((x + 1) < 10) {
        		num = "0"+(x+1);
        	} else {
        		num = String.valueOf((x+1));
        	}
            tabuleiro += num+"| ";
            for (int y = 0; y < 50; y++) {
            	String valor = "";
            	if(campo[x][y] != " ") {
            		valor = campo[x][y]; 
            	} else {
            		valor = "&nbsp;";
            	}
            	tabuleiro += valor+"&nbsp;&nbsp;&nbsp;";
            }
            tabuleiro = tabuleiro + "<br>";//"\n";
        }
        String builder = "<html>"+tabuleiro+"</html>";
        lblTabuleiro.setText(builder);
        System.out.println(tabuleiro);
    }
}