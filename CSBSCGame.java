import javax.swing.JFrame;

public class CSBSCGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameBoard().setVisible(true);
            }
        });
    }
}
